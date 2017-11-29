# Scala/Frameless-based API for the Ontological Modeling Language
 
[![Build Status](https://travis-ci.org/JPL-IMCE/gov.nasa.jpl.imce.oml.frameless.svg?branch=master)](https://travis-ci.org/JPL-IMCE/gov.nasa.jpl.imce.oml.frameless)
 [ ![Download](https://api.bintray.com/packages/jpl-imce/gov.nasa.jpl.imce/gov.nasa.jpl.imce.oml.frameless/images/download.svg) ](https://bintray.com/jpl-imce/gov.nasa.jpl.imce/gov.nasa.jpl.imce.oml.frameless/_latestVersion)
  
## Copyrights

[Caltech](copyrights/Caltech.md)

## License

[Apache-2.0](http://www.apache.org/licenses/LICENSE-2.0)

## Building

This depends on [typelevel/frameless](https://github.com/typelevel/frameless) with a fix 
for this issue https://github.com/typelevel/frameless/issues/213

## Description

This Scala library provides a strongly typed API 
for processing Ontological Modeling Language data on Apache Spark 
using the expressive type extensions provided by Frameless.

With Apache Spark, it it possible to make mistakes when processing OML data.
Consider for example two OML tables describes as case classes like this:

```
case class TerminologyGraph(
  uuid: taggedTypes.TerminologyGraphUUID,
    
  kind: TerminologyKind,
    
  iri: taggedTypes.IRI
)

case class Concept(
  uuid: taggedTypes.ConceptUUID,
    
  tboxUUID: taggedTypes.TerminologyBoxUUID,
    
  name: taggedTypes.LocalName
)
```

A `TerminologyGraph` defines a namespace for specifying the vocabulary 
for describing a domain of interest with a strong commitment 
to a semantics of this vocabulary in Description Logic.

A `TerminologyGraph` is globally identified by a unique `IRI`, which is used
to derive its Version 5 `uuid`.

A `Concept` names a class of things in the vocabulary of a `TerminologyBox`
such as a `TerminologyGraph`. A `Concept` is identified by its `name` 
within the `TerminologyBox` in which it is defined; the latter being 
cross-referenced by its Version 5 `tboxUUID`.

By joining a table of `TerminologyGraph` with a table of `Concept`,
one can resolve the information about which `TerminologyGraph` \
define a particular `Concept`. In Apache Spark, this join can be written like this:

```
// Assume the data has been read from somewhere...
val gs: Dataset[TerminologyGraph] = ... 
val cs: Dataset[Concept] = ...

// Join the two tables
val gs_cs: Dataset[(TerminologyGraph, Concept)] = gs.joinWith(cs, $"uuid" === $"tboxUUID")
```

The notation `$"uuid"` is an Apache Spark syntactic convenience for specifying a reference to a named column in a table.
Unfortunately, this mechanism does not detect certain classes of errors.

One may be lucky and get a runtime error, for example, if there is a typo in the name of a column:

```
val gs_cs_runtime_error: Dataset[(TerminologyGraph, Concept)] = gs.joinWith(cs, $"uid" === $"tboxUUID")
```

This should fail at runtime because the `Concept` table does not have a field named `uid`.

One may be unlucky and a silent failure without any compilation/runtime error at all,
for example, if the join refers to an incorrect column that happens to have a compatible type:

```
val gs_cs_always_empty: Dataset[(TerminologyGraph, Concept)] = gs.joinWith(cs, $"uuid" === $"uuid")
```

This will never succeed because the Version 5 UUID of a `TerminologyGraph` and that of a `Concept` are constructed using different schemes and therefore will practically never produce identical results.
The join condition will, in practice, always be false.

This library uses advanced type techniques in the Scala programming languages
and the type extensions of the Apache Spark API provided by Frameless
to prevent a large class of silent failures, particularly those due to accidental confusion in common query operations such as `select` and `join` that involve expressions referring to table columns.

With this library, the above example becomes the following:

```
import OMLCatalystCasts.TerminologyGraph2TerminologyBoxUUIDCast

val gs_cs
: TypedDataset[(TerminologyGraph, Concept)]
= omlDS.terminologyGraphs.join(
  omlDS.concepts,
  omlDS.terminologyGraphs.col('uuid).cast[taggedTypes.TerminologyBoxUUID],
  omlDS.concepts.col('tboxUUID))
```

This join is strongly typed. 

Suppose one confuses which column of the `Concept` table to join:

```
import OMLCatalystCasts.TerminologyGraph2TerminologyBoxUUIDCast

val gs_cs
: TypedDataset[(TerminologyGraph, Concept)]
= omlDS.terminologyGraphs.join(
  omlDS.concepts,
  omlDS.terminologyGraphs.col('uuid).cast[taggedTypes.TerminologyBoxUUID], // line 137
  omlDS.concepts.col('uuid)) // line 138
```

The compiler catches this problem as a type mismatch:
that is, the types produced by the column expressions are different and therefore not comparable!

The actual compiler error message may be a bit cryptic for Scala novices;
however, the location of the error clearly points to the problem: the two column expressions are incompatible!

```
Error:(137, 46) type mismatch;
 found   : frameless.TypedColumn[gov.nasa.jpl.imce.oml.frameless.api.TerminologyGraph,gov.nasa.jpl.imce.oml.tables.taggedTypes.TerminologyBoxUUID]
    (which expands to)  frameless.TypedColumn[gov.nasa.jpl.imce.oml.frameless.api.TerminologyGraph,String with gov.nasa.jpl.imce.oml.covariantTag.Tagged[gov.nasa.jpl.imce.oml.tables.taggedTypes.TerminologyBoxTag]]
 required: frameless.TypedColumn[gov.nasa.jpl.imce.oml.spark.frameless.api.TerminologyGraph,String with gov.nasa.jpl.imce.oml.covariantTag.Tagged[gov.nasa.jpl.imce.oml.tables.taggedTypes.ResourceTag]]
Note: gov.nasa.jpl.imce.oml.tables.taggedTypes.TerminologyBoxUUID <: String with gov.nasa.jpl.imce.oml.covariantTag.Tagged[gov.nasa.jpl.imce.oml.tables.taggedTypes.ResourceTag], but class TypedColumn is invariant in type U.
You may wish to define U as +U instead. (SLS 4.5)
      omlDS.terminologyGraphs.col('uuid).cast[taggedTypes.TerminologyBoxUUID],
Error:(138, 25) type mismatch;
 found   : frameless.TypedColumn[gov.nasa.jpl.imce.oml.frameless.api.Concept,String with gov.nasa.jpl.imce.oml.covariantTag.Tagged[gov.nasa.jpl.imce.oml.tables.taggedTypes.ConceptTag]]
 required: frameless.TypedColumn[gov.nasa.jpl.imce.oml.frameless.api.Concept,String with gov.nasa.jpl.imce.oml.covariantTag.Tagged[gov.nasa.jpl.imce.oml.tables.taggedTypes.ResourceTag]]
Note: String with gov.nasa.jpl.imce.oml.covariantTag.Tagged[gov.nasa.jpl.imce.oml.tables.taggedTypes.ConceptTag] <: String with gov.nasa.jpl.imce.oml.covariantTag.Tagged[gov.nasa.jpl.imce.oml.tables.taggedTypes.ResourceTag], but class TypedColumn is invariant in type U.
You may wish to define U as +U instead. (SLS 4.5)
      omlDS.concepts.col('uuid))
```
