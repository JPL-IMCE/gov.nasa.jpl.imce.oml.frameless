/*
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */
package gov.nasa.jpl.imce.oml.frameless

import java.util.Properties

import frameless.{TypedDataset,TypedEncoder}
import gov.nasa.jpl.imce.oml.tables
import org.apache.spark.sql.{SQLContext, SaveMode, SparkSession}

import scala.collection.immutable.Seq
import scala.{Boolean,Unit}
import scala.Predef.String

object OMLWriters {

  @scala.annotation.tailrec
  def writeRestrictions
  (url: String,
   props: Properties,
   dataRanges: Seq[tables.taggedTypes.DataRangeUUID],

   binaryScalarRestrictions: Seq[tables.BinaryScalarRestriction],
   binaryScalarRestrictionTable: String,
   binaryScalarRestriction2Tuple: tables.BinaryScalarRestriction => OMLReaders.BinaryScalarRestrictionTuple,

   iriScalarRestrictions: Seq[tables.IRIScalarRestriction],
   iriScalarRestrictionTable: String,
   iriScalarRestriction2Tuple: tables.IRIScalarRestriction => OMLReaders.IRIScalarRestrictionTuple,

   numericScalarRestrictions: Seq[tables.NumericScalarRestriction],
   numericScalarRestrictionTable: String,
   numericScalarRestriction2Tuple: tables.NumericScalarRestriction => OMLReaders.NumericScalarRestrictionTuple,

   plainLiteralScalarRestrictions: Seq[tables.PlainLiteralScalarRestriction],
   plainLiteralScalarRestrictionTable: String,
   plainLiteralScalarRestriction2Tuple: tables.PlainLiteralScalarRestriction => OMLReaders.PlainLiteralScalarRestrictionTuple,

   scalarOneOfRestrictions: Seq[tables.ScalarOneOfRestriction],
   scalarOneOfRestrictionTable: String,
   scalarOneOfRestriction2Tuple: tables.ScalarOneOfRestriction => OMLReaders.ScalarOneOfRestrictionTuple,

   stringScalarRestrictions: Seq[tables.StringScalarRestriction],
   stringScalarRestrictionTable: String,
   stringScalarRestriction2Tuple: tables.StringScalarRestriction => OMLReaders.StringScalarRestrictionTuple,

   synonymScalarRestrictions: Seq[tables.SynonymScalarRestriction],
   synonymScalarRestrictionTable: String,
   synonymScalarRestriction2Tuple: tables.SynonymScalarRestriction => OMLReaders.SynonymScalarRestrictionTuple,

   timeScalarRestrictions: Seq[tables.TimeScalarRestriction],
   timeScalarRestrictionTable: String,
   timeScalarRestriction2Tuple: tables.TimeScalarRestriction => OMLReaders.TimeScalarRestrictionTuple)
  (implicit spark: SparkSession, sqlContext: SQLContext)
  : Unit
  = {
    import spark.implicits._
    import OMLSpecificationTypedDatasets._

    val p1 = binaryScalarRestrictions.partition(r => dataRanges.contains(r.restrictedRangeUUID))
    val p2 = iriScalarRestrictions.partition(r => dataRanges.contains(r.restrictedRangeUUID))
    val p3 = numericScalarRestrictions.partition(r => dataRanges.contains(r.restrictedRangeUUID))
    val p4 = plainLiteralScalarRestrictions.partition(r => dataRanges.contains(r.restrictedRangeUUID))
    val p5 = scalarOneOfRestrictions.partition(r => dataRanges.contains(r.restrictedRangeUUID))
    val p6 = stringScalarRestrictions.partition(r => dataRanges.contains(r.restrictedRangeUUID))
    val p7 = synonymScalarRestrictions.partition(r => dataRanges.contains(r.restrictedRangeUUID))
    val p8 = timeScalarRestrictions.partition(r => dataRanges.contains(r.restrictedRangeUUID))

    if (p1._1.nonEmpty)
      TypedDataset
        .create(p1._1)
        .dataset
        .map(binaryScalarRestriction2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, binaryScalarRestrictionTable, props)

    if (p2._1.nonEmpty)
      TypedDataset
        .create(p2._1)
        .dataset
        .map(iriScalarRestriction2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, iriScalarRestrictionTable, props)

    if (p3._1.nonEmpty)
      TypedDataset
        .create(p3._1)
        .dataset
        .map(numericScalarRestriction2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, numericScalarRestrictionTable, props)

    if (p4._1.nonEmpty)
      TypedDataset
        .create(p4._1)
        .dataset
        .map(plainLiteralScalarRestriction2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, plainLiteralScalarRestrictionTable, props)

    if (p5._1.nonEmpty)
      TypedDataset
        .create(p5._1)
        .dataset
        .map(scalarOneOfRestriction2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, scalarOneOfRestrictionTable, props)

    if (p6._1.nonEmpty)
      TypedDataset
        .create(p6._1)
        .dataset
        .map(stringScalarRestriction2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, stringScalarRestrictionTable, props)

    if (p7._1.nonEmpty)
      TypedDataset
        .create(p7._1)
        .dataset
        .map(synonymScalarRestriction2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, synonymScalarRestrictionTable, props)

    if (p8._1.nonEmpty)
      TypedDataset
        .create(p8._1)
        .dataset
        .map(timeScalarRestriction2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, timeScalarRestrictionTable, props)

    if (p1._2.nonEmpty || p2._2.nonEmpty || p3._2.nonEmpty || p4._2.nonEmpty ||
        p5._2.nonEmpty || p6._2.nonEmpty || p7._2.nonEmpty || p8._2.nonEmpty)
      writeRestrictions(
        url, props,
        dataRanges ++
          p1._1.map(_.uuid) ++
          p2._1.map(_.uuid) ++
          p3._1.map(_.uuid) ++
          p4._1.map(_.uuid) ++
          p5._1.map(_.uuid) ++
          p6._1.map(_.uuid) ++
          p7._1.map(_.uuid) ++
          p8._1.map(_.uuid),
        p1._2, binaryScalarRestrictionTable, binaryScalarRestriction2Tuple,
        p2._2, iriScalarRestrictionTable, iriScalarRestriction2Tuple,
        p3._2, numericScalarRestrictionTable, numericScalarRestriction2Tuple,
        p4._2, plainLiteralScalarRestrictionTable, plainLiteralScalarRestriction2Tuple,
        p5._2, scalarOneOfRestrictionTable, scalarOneOfRestriction2Tuple,
        p6._2, stringScalarRestrictionTable, stringScalarRestriction2Tuple,
        p7._2, synonymScalarRestrictionTable, synonymScalarRestriction2Tuple,
        p8._2, timeScalarRestrictionTable, timeScalarRestriction2Tuple)
  }

//  @scala.annotation.tailrec
//  def serializeAndWrite[T <: tables.LogicalElement, Tuple, TUUID <: tables.taggedTypes.LogicalElementUUID]
//  (url: String,
//   props: Properties,
//   ts: Seq[T],
//   sqlTable: String,
//   t2tuple: T => Tuple,
//   serializedUUIDs: Seq[TUUID],
//   partitioner: (T, Seq[TUUID]) => Boolean)
//  (implicit spark: SparkSession, sqlContext: SQLContext, encoder1: TypedEncoder[T], encoder2: TypedEncoder[Tuple])
//  : Unit
//  = {
//    import spark.implicits._
//    import OMLSpecificationTypedDatasets._
//
//    val (serializable, queue) =
//      ts.partition { s =>
//        partitioner(s, serializedUUIDs)
//      }
//
//    if (serializable.nonEmpty)
//      TypedDataset
//        .create(serializable)
//        .dataset
//        .map(t2tuple)
//        .write
//        .mode(SaveMode.Append)
//        .jdbc(url, sqlTable, props)
//
//    if (queue.nonEmpty)
//      serializeAndWrite(
//        url, props,
//        queue,
//        sqlTable,
//        t2tuple,
//        serializedUUIDs ++ serializable.map(_.uuid),
//        partitioner)
//  }

  @scala.annotation.tailrec
  def serializeAndWriteRuleBodySegments
  (url: String,
   props: Properties,
   ts: Seq[tables.RuleBodySegment],
   sqlTable: String,
   t2tuple: tables.RuleBodySegment => OMLReaders.RuleBodySegmentTuple,
   serializedUUIDs: Seq[tables.taggedTypes.RuleBodySegmentUUID],
   partitioner: (tables.RuleBodySegment, Seq[tables.taggedTypes.RuleBodySegmentUUID]) => Boolean)
  (implicit spark: SparkSession, sqlContext: SQLContext, encoder1: TypedEncoder[tables.RuleBodySegment], encoder2: TypedEncoder[OMLReaders.RuleBodySegmentTuple])
  : Unit
  = {
    import spark.implicits._

    val (serializable, queue) =
      ts.partition { s =>
        partitioner(s, serializedUUIDs)
      }

    if (serializable.nonEmpty)
      TypedDataset
        .create(serializable)
        .dataset
        .map(t2tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, sqlTable, props)

    if (queue.nonEmpty)
      serializeAndWriteRuleBodySegments(
        url, props,
        queue,
        sqlTable,
        t2tuple,
        serializedUUIDs ++ serializable.map(_.uuid),
        partitioner)
  }

  def ruleBodySegmentPartitioner
  (rbs: tables.RuleBodySegment,
   serializedUUIDs: Seq[tables.taggedTypes.RuleBodySegmentUUID])
  : Boolean
  = rbs.ruleUUID.nonEmpty || rbs.previousSegmentUUID.fold[Boolean](false)(serializedUUIDs.contains)

  @scala.annotation.tailrec
  def serializeAndWriteAnonymousConceptUnionAxioms
  (url: String,
   props: Properties,
   ts: Seq[tables.AnonymousConceptUnionAxiom],
   sqlTable: String,
   t2tuple: tables.AnonymousConceptUnionAxiom => OMLReaders.AnonymousConceptUnionAxiomTuple,
   serializedUUIDs: Seq[tables.taggedTypes.ConceptTreeDisjunctionUUID],
   partitioner: (tables.AnonymousConceptUnionAxiom, Seq[tables.taggedTypes.ConceptTreeDisjunctionUUID]) => Boolean)
  (implicit spark: SparkSession, sqlContext: SQLContext, encoder1: TypedEncoder[tables.AnonymousConceptUnionAxiom], encoder2: TypedEncoder[OMLReaders.AnonymousConceptUnionAxiomTuple])
  : Unit
  = {
    import spark.implicits._

    val (serializable, queue) =
      ts.partition { s =>
        partitioner(s, serializedUUIDs)
      }

    if (serializable.nonEmpty)
      TypedDataset
        .create(serializable)
        .dataset
        .map(t2tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, sqlTable, props)

    if (queue.nonEmpty)
      serializeAndWriteAnonymousConceptUnionAxioms(
        url, props,
        queue,
        sqlTable,
        t2tuple,
        serializedUUIDs ++ serializable.map(_.uuid),
        partitioner)
  }

  def anonymousConceptUnionAxiomPartitioner
  (ax: tables.AnonymousConceptUnionAxiom,
   serializedUUIDs: Seq[tables.taggedTypes.ConceptTreeDisjunctionUUID])
  : Boolean
  = serializedUUIDs.contains(ax.disjointTaxonomyParentUUID)

  @scala.annotation.tailrec
  def serializeAndWriteRestrictionStructuredDataPropertyTuples
  (url: String,
   props: Properties,
   ts: Seq[tables.RestrictionStructuredDataPropertyTuple],
   sqlTable: String,
   t2tuple: tables.RestrictionStructuredDataPropertyTuple => OMLReaders.RestrictionStructuredDataPropertyTupleTuple,
   serializedUUIDs: Seq[tables.taggedTypes.RestrictionStructuredDataPropertyContextUUID],
   partitioner: (tables.RestrictionStructuredDataPropertyTuple, Seq[tables.taggedTypes.RestrictionStructuredDataPropertyContextUUID]) => Boolean)
  (implicit spark: SparkSession, sqlContext: SQLContext, encoder1: TypedEncoder[tables.RestrictionStructuredDataPropertyTuple], encoder2: TypedEncoder[OMLReaders.RestrictionStructuredDataPropertyTupleTuple])
  : Unit
  = {
    import spark.implicits._

    val (serializable, queue) =
      ts.partition { s =>
        partitioner(s, serializedUUIDs)
      }

    if (serializable.nonEmpty)
      TypedDataset
        .create(serializable)
        .dataset
        .map(t2tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, sqlTable, props)

    if (queue.nonEmpty)
      serializeAndWriteRestrictionStructuredDataPropertyTuples(
        url, props,
        queue,
        sqlTable,
        t2tuple,
        serializedUUIDs ++ serializable.map(_.uuid),
        partitioner)
  }

  def restrictionStructuredDataPropertyTuplePartitioner
  (rsd: tables.RestrictionStructuredDataPropertyTuple,
   serializedUUIDs: Seq[tables.taggedTypes.RestrictionStructuredDataPropertyContextUUID])
  : Boolean
  = serializedUUIDs.contains(rsd.structuredDataPropertyContextUUID)

  @scala.annotation.tailrec
  def serializeAndWriteStructuredDataPropertyTuples
  (url: String,
   props: Properties,
   ts: Seq[tables.StructuredDataPropertyTuple],
   sqlTable: String,
   t2tuple: tables.StructuredDataPropertyTuple => OMLReaders.StructuredDataPropertyTupleTuple,
   serializedUUIDs: Seq[tables.taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID],
   partitioner: (tables.StructuredDataPropertyTuple, Seq[tables.taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID]) => Boolean)
  (implicit spark: SparkSession, sqlContext: SQLContext, encoder1: TypedEncoder[tables.StructuredDataPropertyTuple], encoder2: TypedEncoder[OMLReaders.StructuredDataPropertyTupleTuple])
  : Unit
  = {
    import spark.implicits._

    val (serializable, queue) =
      ts.partition { s =>
        partitioner(s, serializedUUIDs)
      }

    if (serializable.nonEmpty)
      TypedDataset
        .create(serializable)
        .dataset
        .map(t2tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, sqlTable, props)

    if (queue.nonEmpty)
      serializeAndWriteStructuredDataPropertyTuples(
        url, props,
        queue,
        sqlTable,
        t2tuple,
        serializedUUIDs ++ serializable.map(_.uuid),
        partitioner)
  }

  def structuredDataPropertyTuplePartitioner
  (sdp: tables.StructuredDataPropertyTuple,
   serializedUUIDs: Seq[tables.taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID])
  : Boolean
  = serializedUUIDs.contains(sdp.structuredDataPropertyContextUUID)

}
