/*
 * Copyright 2017 Copyright 2017 California Institute of Technology ("Caltech").
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
 *
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
 */

package gov.nasa.jpl.imce.oml.frameless

import ammonite.ops.Path

import frameless.{Injection, TypedDataset}
import gov.nasa.jpl.imce.oml.covariantTag
import gov.nasa.jpl.imce.oml.covariantTag.@@
import gov.nasa.jpl.imce.oml.tables
import org.apache.spark.sql.SparkSession

import scala.collection.immutable.Seq
import scala.util.control.Exception._
import scala.util.{Failure,Success,Try}
import scala.{Int,Unit}
import scala.Predef.String

object OMLSpecificationTypedDatasets {

  implicit def tagInjection[Tag] = new Injection[String @@ Tag, String] {
    def apply(t: String @@ Tag): String = t
    def invert(s: String): String @@ Tag = covariantTag[Tag][String](s)
  }

  implicit val literalTypeInjection = new Injection[tables.LiteralType, String] {
    def apply(t: tables.LiteralType): String = tables.LiteralType.toString(t)
    def invert(s: String): tables.LiteralType = tables.LiteralType.fromString(s)
  }

  implicit val literalNumberTypeInjection = new Injection[tables.LiteralNumberType, String] {
    def apply(t: tables.LiteralNumberType): String = tables.LiteralNumberType.toString(t)
  	def invert(s: String): tables.LiteralNumberType = tables.LiteralNumberType.fromString(s)
  }

  def createEmptyOMLSpecificationTypedDatasets()(implicit sqlContext: SparkSession)
  : OMLSpecificationTypedDatasets
  = OMLSpecificationTypedDatasets(
    annotationProperties = 
    TypedDataset.create[api.AnnotationProperty](
      Seq.empty[api.AnnotationProperty]),
  
    annotationPropertyValues = 
    TypedDataset.create[api.AnnotationPropertyValue](
      Seq.empty[api.AnnotationPropertyValue]),
  
    anonymousConceptUnionAxioms = 
    TypedDataset.create[api.AnonymousConceptUnionAxiom](
      Seq.empty[api.AnonymousConceptUnionAxiom]),
  
    aspects = 
    TypedDataset.create[api.Aspect](
      Seq.empty[api.Aspect]),
  
    aspectPredicates = 
    TypedDataset.create[api.AspectPredicate](
      Seq.empty[api.AspectPredicate]),
  
    aspectSpecializationAxioms = 
    TypedDataset.create[api.AspectSpecializationAxiom](
      Seq.empty[api.AspectSpecializationAxiom]),
  
    binaryScalarRestrictions = 
    TypedDataset.create[api.BinaryScalarRestriction](
      Seq.empty[api.BinaryScalarRestriction]),
  
    bundles = 
    TypedDataset.create[api.Bundle](
      Seq.empty[api.Bundle]),
  
    bundledTerminologyAxioms = 
    TypedDataset.create[api.BundledTerminologyAxiom](
      Seq.empty[api.BundledTerminologyAxiom]),
  
    chainRules = 
    TypedDataset.create[api.ChainRule](
      Seq.empty[api.ChainRule]),
  
    concepts = 
    TypedDataset.create[api.Concept](
      Seq.empty[api.Concept]),
  
    conceptDesignationTerminologyAxioms = 
    TypedDataset.create[api.ConceptDesignationTerminologyAxiom](
      Seq.empty[api.ConceptDesignationTerminologyAxiom]),
  
    conceptInstances = 
    TypedDataset.create[api.ConceptInstance](
      Seq.empty[api.ConceptInstance]),
  
    conceptPredicates = 
    TypedDataset.create[api.ConceptPredicate](
      Seq.empty[api.ConceptPredicate]),
  
    conceptSpecializationAxioms = 
    TypedDataset.create[api.ConceptSpecializationAxiom](
      Seq.empty[api.ConceptSpecializationAxiom]),
  
    descriptionBoxes = 
    TypedDataset.create[api.DescriptionBox](
      Seq.empty[api.DescriptionBox]),
  
    descriptionBoxExtendsClosedWorldDefinitions = 
    TypedDataset.create[api.DescriptionBoxExtendsClosedWorldDefinitions](
      Seq.empty[api.DescriptionBoxExtendsClosedWorldDefinitions]),
  
    descriptionBoxRefinements = 
    TypedDataset.create[api.DescriptionBoxRefinement](
      Seq.empty[api.DescriptionBoxRefinement]),
  
    entityExistentialRestrictionAxioms = 
    TypedDataset.create[api.EntityExistentialRestrictionAxiom](
      Seq.empty[api.EntityExistentialRestrictionAxiom]),
  
    entityScalarDataProperties = 
    TypedDataset.create[api.EntityScalarDataProperty](
      Seq.empty[api.EntityScalarDataProperty]),
  
    entityScalarDataPropertyExistentialRestrictionAxioms = 
    TypedDataset.create[api.EntityScalarDataPropertyExistentialRestrictionAxiom](
      Seq.empty[api.EntityScalarDataPropertyExistentialRestrictionAxiom]),
  
    entityScalarDataPropertyParticularRestrictionAxioms = 
    TypedDataset.create[api.EntityScalarDataPropertyParticularRestrictionAxiom](
      Seq.empty[api.EntityScalarDataPropertyParticularRestrictionAxiom]),
  
    entityScalarDataPropertyUniversalRestrictionAxioms = 
    TypedDataset.create[api.EntityScalarDataPropertyUniversalRestrictionAxiom](
      Seq.empty[api.EntityScalarDataPropertyUniversalRestrictionAxiom]),
  
    entityStructuredDataProperties = 
    TypedDataset.create[api.EntityStructuredDataProperty](
      Seq.empty[api.EntityStructuredDataProperty]),
  
    entityStructuredDataPropertyParticularRestrictionAxioms = 
    TypedDataset.create[api.EntityStructuredDataPropertyParticularRestrictionAxiom](
      Seq.empty[api.EntityStructuredDataPropertyParticularRestrictionAxiom]),
  
    entityUniversalRestrictionAxioms = 
    TypedDataset.create[api.EntityUniversalRestrictionAxiom](
      Seq.empty[api.EntityUniversalRestrictionAxiom]),
  
    iriScalarRestrictions = 
    TypedDataset.create[api.IRIScalarRestriction](
      Seq.empty[api.IRIScalarRestriction]),
  
    numericScalarRestrictions = 
    TypedDataset.create[api.NumericScalarRestriction](
      Seq.empty[api.NumericScalarRestriction]),
  
    plainLiteralScalarRestrictions = 
    TypedDataset.create[api.PlainLiteralScalarRestriction](
      Seq.empty[api.PlainLiteralScalarRestriction]),
  
    reifiedRelationships = 
    TypedDataset.create[api.ReifiedRelationship](
      Seq.empty[api.ReifiedRelationship]),
  
    reifiedRelationshipInstances = 
    TypedDataset.create[api.ReifiedRelationshipInstance](
      Seq.empty[api.ReifiedRelationshipInstance]),
  
    reifiedRelationshipInstanceDomains = 
    TypedDataset.create[api.ReifiedRelationshipInstanceDomain](
      Seq.empty[api.ReifiedRelationshipInstanceDomain]),
  
    reifiedRelationshipInstanceRanges = 
    TypedDataset.create[api.ReifiedRelationshipInstanceRange](
      Seq.empty[api.ReifiedRelationshipInstanceRange]),
  
    reifiedRelationshipInversePropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipInversePropertyPredicate](
      Seq.empty[api.ReifiedRelationshipInversePropertyPredicate]),
  
    reifiedRelationshipPredicates = 
    TypedDataset.create[api.ReifiedRelationshipPredicate](
      Seq.empty[api.ReifiedRelationshipPredicate]),
  
    reifiedRelationshipPropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipPropertyPredicate](
      Seq.empty[api.ReifiedRelationshipPropertyPredicate]),
  
    reifiedRelationshipSourceInversePropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipSourceInversePropertyPredicate](
      Seq.empty[api.ReifiedRelationshipSourceInversePropertyPredicate]),
  
    reifiedRelationshipSourcePropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipSourcePropertyPredicate](
      Seq.empty[api.ReifiedRelationshipSourcePropertyPredicate]),
  
    reifiedRelationshipSpecializationAxioms = 
    TypedDataset.create[api.ReifiedRelationshipSpecializationAxiom](
      Seq.empty[api.ReifiedRelationshipSpecializationAxiom]),
  
    reifiedRelationshipTargetInversePropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipTargetInversePropertyPredicate](
      Seq.empty[api.ReifiedRelationshipTargetInversePropertyPredicate]),
  
    reifiedRelationshipTargetPropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipTargetPropertyPredicate](
      Seq.empty[api.ReifiedRelationshipTargetPropertyPredicate]),
  
    restrictionScalarDataPropertyValues = 
    TypedDataset.create[api.RestrictionScalarDataPropertyValue](
      Seq.empty[api.RestrictionScalarDataPropertyValue]),
  
    restrictionStructuredDataPropertyTuples = 
    TypedDataset.create[api.RestrictionStructuredDataPropertyTuple](
      Seq.empty[api.RestrictionStructuredDataPropertyTuple]),
  
    rootConceptTaxonomyAxioms = 
    TypedDataset.create[api.RootConceptTaxonomyAxiom](
      Seq.empty[api.RootConceptTaxonomyAxiom]),
  
    ruleBodySegments = 
    TypedDataset.create[api.RuleBodySegment](
      Seq.empty[api.RuleBodySegment]),
  
    scalars = 
    TypedDataset.create[api.Scalar](
      Seq.empty[api.Scalar]),
  
    scalarDataProperties = 
    TypedDataset.create[api.ScalarDataProperty](
      Seq.empty[api.ScalarDataProperty]),
  
    scalarDataPropertyValues = 
    TypedDataset.create[api.ScalarDataPropertyValue](
      Seq.empty[api.ScalarDataPropertyValue]),
  
    scalarOneOfLiteralAxioms = 
    TypedDataset.create[api.ScalarOneOfLiteralAxiom](
      Seq.empty[api.ScalarOneOfLiteralAxiom]),
  
    scalarOneOfRestrictions = 
    TypedDataset.create[api.ScalarOneOfRestriction](
      Seq.empty[api.ScalarOneOfRestriction]),
  
    singletonInstanceScalarDataPropertyValues = 
    TypedDataset.create[api.SingletonInstanceScalarDataPropertyValue](
      Seq.empty[api.SingletonInstanceScalarDataPropertyValue]),
  
    singletonInstanceStructuredDataPropertyValues = 
    TypedDataset.create[api.SingletonInstanceStructuredDataPropertyValue](
      Seq.empty[api.SingletonInstanceStructuredDataPropertyValue]),
  
    specificDisjointConceptAxioms = 
    TypedDataset.create[api.SpecificDisjointConceptAxiom](
      Seq.empty[api.SpecificDisjointConceptAxiom]),
  
    stringScalarRestrictions = 
    TypedDataset.create[api.StringScalarRestriction](
      Seq.empty[api.StringScalarRestriction]),
  
    structures = 
    TypedDataset.create[api.Structure](
      Seq.empty[api.Structure]),
  
    structuredDataProperties = 
    TypedDataset.create[api.StructuredDataProperty](
      Seq.empty[api.StructuredDataProperty]),
  
    structuredDataPropertyTuples = 
    TypedDataset.create[api.StructuredDataPropertyTuple](
      Seq.empty[api.StructuredDataPropertyTuple]),
  
    synonymScalarRestrictions = 
    TypedDataset.create[api.SynonymScalarRestriction](
      Seq.empty[api.SynonymScalarRestriction]),
  
    terminologyExtensionAxioms = 
    TypedDataset.create[api.TerminologyExtensionAxiom](
      Seq.empty[api.TerminologyExtensionAxiom]),
  
    terminologyGraphs = 
    TypedDataset.create[api.TerminologyGraph](
      Seq.empty[api.TerminologyGraph]),
  
    terminologyNestingAxioms = 
    TypedDataset.create[api.TerminologyNestingAxiom](
      Seq.empty[api.TerminologyNestingAxiom]),
  
    timeScalarRestrictions = 
    TypedDataset.create[api.TimeScalarRestriction](
      Seq.empty[api.TimeScalarRestriction]),
  
    unreifiedRelationships = 
    TypedDataset.create[api.UnreifiedRelationship](
      Seq.empty[api.UnreifiedRelationship]),
  
    unreifiedRelationshipInstanceTuples = 
    TypedDataset.create[api.UnreifiedRelationshipInstanceTuple](
      Seq.empty[api.UnreifiedRelationshipInstanceTuple]),
  
    unreifiedRelationshipInversePropertyPredicates = 
    TypedDataset.create[api.UnreifiedRelationshipInversePropertyPredicate](
      Seq.empty[api.UnreifiedRelationshipInversePropertyPredicate]),
  
    unreifiedRelationshipPropertyPredicates = 
    TypedDataset.create[api.UnreifiedRelationshipPropertyPredicate](
      Seq.empty[api.UnreifiedRelationshipPropertyPredicate])
  )
    
  def convertToOMLSpecificationTypedDatasets
  (t: tables.OMLSpecificationTables)
  (implicit sqlContext: SparkSession)
  : OMLSpecificationTypedDatasets
  = OMLSpecificationTypedDatasets(
    annotationProperties = 
    TypedDataset.create[api.AnnotationProperty](
      t.annotationProperties.map(i =>
       api.AnnotationProperty(
         uuid = i.uuid,
         iri = i.iri,
         abbrevIRI = i.abbrevIRI))),
  
    annotationPropertyValues = 
    TypedDataset.create[api.AnnotationPropertyValue](
      t.annotationPropertyValues.map(i =>
       api.AnnotationPropertyValue(
         uuid = i.uuid,
         subjectUUID = i.subjectUUID,
         propertyUUID = i.propertyUUID,
         value = i.value))),
  
    anonymousConceptUnionAxioms = 
    TypedDataset.create[api.AnonymousConceptUnionAxiom](
      t.anonymousConceptUnionAxioms.map(i =>
       api.AnonymousConceptUnionAxiom(
         uuid = i.uuid,
         disjointTaxonomyParentUUID = i.disjointTaxonomyParentUUID,
         name = i.name))),
  
    aspects = 
    TypedDataset.create[api.Aspect](
      t.aspects.map(i =>
       api.Aspect(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         name = i.name))),
  
    aspectPredicates = 
    TypedDataset.create[api.AspectPredicate](
      t.aspectPredicates.map(i =>
       api.AspectPredicate(
         uuid = i.uuid,
         aspectUUID = i.aspectUUID,
         bodySegmentUUID = i.bodySegmentUUID))),
  
    aspectSpecializationAxioms = 
    TypedDataset.create[api.AspectSpecializationAxiom](
      t.aspectSpecializationAxioms.map(i =>
       api.AspectSpecializationAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         superAspectUUID = i.superAspectUUID,
         subEntityUUID = i.subEntityUUID))),
  
    binaryScalarRestrictions = 
    TypedDataset.create[api.BinaryScalarRestriction](
      t.binaryScalarRestrictions.map(i =>
       api.BinaryScalarRestriction(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         length = i.length,
         minLength = i.minLength,
         maxLength = i.maxLength,
         name = i.name))),
  
    bundles = 
    TypedDataset.create[api.Bundle](
      t.bundles.map(i =>
       api.Bundle(
         uuid = i.uuid,
         kind = i.kind,
         iri = i.iri))),
  
    bundledTerminologyAxioms = 
    TypedDataset.create[api.BundledTerminologyAxiom](
      t.bundledTerminologyAxioms.map(i =>
       api.BundledTerminologyAxiom(
         uuid = i.uuid,
         bundleUUID = i.bundleUUID,
         bundledTerminologyIRI = i.bundledTerminologyIRI))),
  
    chainRules = 
    TypedDataset.create[api.ChainRule](
      t.chainRules.map(i =>
       api.ChainRule(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         name = i.name,
         headUUID = i.headUUID))),
  
    concepts = 
    TypedDataset.create[api.Concept](
      t.concepts.map(i =>
       api.Concept(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         name = i.name))),
  
    conceptDesignationTerminologyAxioms = 
    TypedDataset.create[api.ConceptDesignationTerminologyAxiom](
      t.conceptDesignationTerminologyAxioms.map(i =>
       api.ConceptDesignationTerminologyAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         designatedConceptUUID = i.designatedConceptUUID,
         designatedTerminologyIRI = i.designatedTerminologyIRI))),
  
    conceptInstances = 
    TypedDataset.create[api.ConceptInstance](
      t.conceptInstances.map(i =>
       api.ConceptInstance(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         singletonConceptClassifierUUID = i.singletonConceptClassifierUUID,
         name = i.name))),
  
    conceptPredicates = 
    TypedDataset.create[api.ConceptPredicate](
      t.conceptPredicates.map(i =>
       api.ConceptPredicate(
         uuid = i.uuid,
         bodySegmentUUID = i.bodySegmentUUID,
         conceptUUID = i.conceptUUID))),
  
    conceptSpecializationAxioms = 
    TypedDataset.create[api.ConceptSpecializationAxiom](
      t.conceptSpecializationAxioms.map(i =>
       api.ConceptSpecializationAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         superConceptUUID = i.superConceptUUID,
         subConceptUUID = i.subConceptUUID))),
  
    descriptionBoxes = 
    TypedDataset.create[api.DescriptionBox](
      t.descriptionBoxes.map(i =>
       api.DescriptionBox(
         uuid = i.uuid,
         kind = i.kind,
         iri = i.iri))),
  
    descriptionBoxExtendsClosedWorldDefinitions = 
    TypedDataset.create[api.DescriptionBoxExtendsClosedWorldDefinitions](
      t.descriptionBoxExtendsClosedWorldDefinitions.map(i =>
       api.DescriptionBoxExtendsClosedWorldDefinitions(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         closedWorldDefinitionsIRI = i.closedWorldDefinitionsIRI))),
  
    descriptionBoxRefinements = 
    TypedDataset.create[api.DescriptionBoxRefinement](
      t.descriptionBoxRefinements.map(i =>
       api.DescriptionBoxRefinement(
         uuid = i.uuid,
         refiningDescriptionBoxUUID = i.refiningDescriptionBoxUUID,
         refinedDescriptionBoxIRI = i.refinedDescriptionBoxIRI))),
  
    entityExistentialRestrictionAxioms = 
    TypedDataset.create[api.EntityExistentialRestrictionAxiom](
      t.entityExistentialRestrictionAxioms.map(i =>
       api.EntityExistentialRestrictionAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRelationUUID = i.restrictedRelationUUID,
         restrictedDomainUUID = i.restrictedDomainUUID,
         restrictedRangeUUID = i.restrictedRangeUUID))),
  
    entityScalarDataProperties = 
    TypedDataset.create[api.EntityScalarDataProperty](
      t.entityScalarDataProperties.map(i =>
       api.EntityScalarDataProperty(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         domainUUID = i.domainUUID,
         rangeUUID = i.rangeUUID,
         isIdentityCriteria = i.isIdentityCriteria,
         name = i.name))),
  
    entityScalarDataPropertyExistentialRestrictionAxioms = 
    TypedDataset.create[api.EntityScalarDataPropertyExistentialRestrictionAxiom](
      t.entityScalarDataPropertyExistentialRestrictionAxioms.map(i =>
       api.EntityScalarDataPropertyExistentialRestrictionAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedEntityUUID = i.restrictedEntityUUID,
         scalarPropertyUUID = i.scalarPropertyUUID,
         scalarRestrictionUUID = i.scalarRestrictionUUID))),
  
    entityScalarDataPropertyParticularRestrictionAxioms = 
    TypedDataset.create[api.EntityScalarDataPropertyParticularRestrictionAxiom](
      t.entityScalarDataPropertyParticularRestrictionAxioms.map(i =>
       api.EntityScalarDataPropertyParticularRestrictionAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedEntityUUID = i.restrictedEntityUUID,
         scalarPropertyUUID = i.scalarPropertyUUID,
         literalValue = i.literalValue,
         valueTypeUUID = i.valueTypeUUID))),
  
    entityScalarDataPropertyUniversalRestrictionAxioms = 
    TypedDataset.create[api.EntityScalarDataPropertyUniversalRestrictionAxiom](
      t.entityScalarDataPropertyUniversalRestrictionAxioms.map(i =>
       api.EntityScalarDataPropertyUniversalRestrictionAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedEntityUUID = i.restrictedEntityUUID,
         scalarPropertyUUID = i.scalarPropertyUUID,
         scalarRestrictionUUID = i.scalarRestrictionUUID))),
  
    entityStructuredDataProperties = 
    TypedDataset.create[api.EntityStructuredDataProperty](
      t.entityStructuredDataProperties.map(i =>
       api.EntityStructuredDataProperty(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         domainUUID = i.domainUUID,
         rangeUUID = i.rangeUUID,
         isIdentityCriteria = i.isIdentityCriteria,
         name = i.name))),
  
    entityStructuredDataPropertyParticularRestrictionAxioms = 
    TypedDataset.create[api.EntityStructuredDataPropertyParticularRestrictionAxiom](
      t.entityStructuredDataPropertyParticularRestrictionAxioms.map(i =>
       api.EntityStructuredDataPropertyParticularRestrictionAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         structuredDataPropertyUUID = i.structuredDataPropertyUUID,
         restrictedEntityUUID = i.restrictedEntityUUID))),
  
    entityUniversalRestrictionAxioms = 
    TypedDataset.create[api.EntityUniversalRestrictionAxiom](
      t.entityUniversalRestrictionAxioms.map(i =>
       api.EntityUniversalRestrictionAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRelationUUID = i.restrictedRelationUUID,
         restrictedDomainUUID = i.restrictedDomainUUID,
         restrictedRangeUUID = i.restrictedRangeUUID))),
  
    iriScalarRestrictions = 
    TypedDataset.create[api.IRIScalarRestriction](
      t.iriScalarRestrictions.map(i =>
       api.IRIScalarRestriction(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         length = i.length,
         minLength = i.minLength,
         maxLength = i.maxLength,
         name = i.name,
         pattern = i.pattern))),
  
    numericScalarRestrictions = 
    TypedDataset.create[api.NumericScalarRestriction](
      t.numericScalarRestrictions.map(i =>
       api.NumericScalarRestriction(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         minExclusive = i.minExclusive,
         minInclusive = i.minInclusive,
         maxExclusive = i.maxExclusive,
         maxInclusive = i.maxInclusive,
         name = i.name))),
  
    plainLiteralScalarRestrictions = 
    TypedDataset.create[api.PlainLiteralScalarRestriction](
      t.plainLiteralScalarRestrictions.map(i =>
       api.PlainLiteralScalarRestriction(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         length = i.length,
         minLength = i.minLength,
         maxLength = i.maxLength,
         name = i.name,
         langRange = i.langRange,
         pattern = i.pattern))),
  
    reifiedRelationships = 
    TypedDataset.create[api.ReifiedRelationship](
      t.reifiedRelationships.map(i =>
       api.ReifiedRelationship(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         sourceUUID = i.sourceUUID,
         targetUUID = i.targetUUID,
         isAsymmetric = i.isAsymmetric,
         isEssential = i.isEssential,
         isFunctional = i.isFunctional,
         isInverseEssential = i.isInverseEssential,
         isInverseFunctional = i.isInverseFunctional,
         isIrreflexive = i.isIrreflexive,
         isReflexive = i.isReflexive,
         isSymmetric = i.isSymmetric,
         isTransitive = i.isTransitive,
         name = i.name,
         unreifiedPropertyName = i.unreifiedPropertyName,
         unreifiedInversePropertyName = i.unreifiedInversePropertyName))),
  
    reifiedRelationshipInstances = 
    TypedDataset.create[api.ReifiedRelationshipInstance](
      t.reifiedRelationshipInstances.map(i =>
       api.ReifiedRelationshipInstance(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         singletonReifiedRelationshipClassifierUUID = i.singletonReifiedRelationshipClassifierUUID,
         name = i.name))),
  
    reifiedRelationshipInstanceDomains = 
    TypedDataset.create[api.ReifiedRelationshipInstanceDomain](
      t.reifiedRelationshipInstanceDomains.map(i =>
       api.ReifiedRelationshipInstanceDomain(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         reifiedRelationshipInstanceUUID = i.reifiedRelationshipInstanceUUID,
         domainUUID = i.domainUUID))),
  
    reifiedRelationshipInstanceRanges = 
    TypedDataset.create[api.ReifiedRelationshipInstanceRange](
      t.reifiedRelationshipInstanceRanges.map(i =>
       api.ReifiedRelationshipInstanceRange(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         reifiedRelationshipInstanceUUID = i.reifiedRelationshipInstanceUUID,
         rangeUUID = i.rangeUUID))),
  
    reifiedRelationshipInversePropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipInversePropertyPredicate](
      t.reifiedRelationshipInversePropertyPredicates.map(i =>
       api.ReifiedRelationshipInversePropertyPredicate(
         uuid = i.uuid,
         bodySegmentUUID = i.bodySegmentUUID,
         reifiedRelationshipUUID = i.reifiedRelationshipUUID))),
  
    reifiedRelationshipPredicates = 
    TypedDataset.create[api.ReifiedRelationshipPredicate](
      t.reifiedRelationshipPredicates.map(i =>
       api.ReifiedRelationshipPredicate(
         uuid = i.uuid,
         bodySegmentUUID = i.bodySegmentUUID,
         reifiedRelationshipUUID = i.reifiedRelationshipUUID))),
  
    reifiedRelationshipPropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipPropertyPredicate](
      t.reifiedRelationshipPropertyPredicates.map(i =>
       api.ReifiedRelationshipPropertyPredicate(
         uuid = i.uuid,
         bodySegmentUUID = i.bodySegmentUUID,
         reifiedRelationshipUUID = i.reifiedRelationshipUUID))),
  
    reifiedRelationshipSourceInversePropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipSourceInversePropertyPredicate](
      t.reifiedRelationshipSourceInversePropertyPredicates.map(i =>
       api.ReifiedRelationshipSourceInversePropertyPredicate(
         uuid = i.uuid,
         bodySegmentUUID = i.bodySegmentUUID,
         reifiedRelationshipUUID = i.reifiedRelationshipUUID))),
  
    reifiedRelationshipSourcePropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipSourcePropertyPredicate](
      t.reifiedRelationshipSourcePropertyPredicates.map(i =>
       api.ReifiedRelationshipSourcePropertyPredicate(
         uuid = i.uuid,
         bodySegmentUUID = i.bodySegmentUUID,
         reifiedRelationshipUUID = i.reifiedRelationshipUUID))),
  
    reifiedRelationshipSpecializationAxioms = 
    TypedDataset.create[api.ReifiedRelationshipSpecializationAxiom](
      t.reifiedRelationshipSpecializationAxioms.map(i =>
       api.ReifiedRelationshipSpecializationAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         superRelationshipUUID = i.superRelationshipUUID,
         subRelationshipUUID = i.subRelationshipUUID))),
  
    reifiedRelationshipTargetInversePropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipTargetInversePropertyPredicate](
      t.reifiedRelationshipTargetInversePropertyPredicates.map(i =>
       api.ReifiedRelationshipTargetInversePropertyPredicate(
         uuid = i.uuid,
         bodySegmentUUID = i.bodySegmentUUID,
         reifiedRelationshipUUID = i.reifiedRelationshipUUID))),
  
    reifiedRelationshipTargetPropertyPredicates = 
    TypedDataset.create[api.ReifiedRelationshipTargetPropertyPredicate](
      t.reifiedRelationshipTargetPropertyPredicates.map(i =>
       api.ReifiedRelationshipTargetPropertyPredicate(
         uuid = i.uuid,
         bodySegmentUUID = i.bodySegmentUUID,
         reifiedRelationshipUUID = i.reifiedRelationshipUUID))),
  
    restrictionScalarDataPropertyValues = 
    TypedDataset.create[api.RestrictionScalarDataPropertyValue](
      t.restrictionScalarDataPropertyValues.map(i =>
       api.RestrictionScalarDataPropertyValue(
         uuid = i.uuid,
         scalarDataPropertyUUID = i.scalarDataPropertyUUID,
         scalarPropertyValue = i.scalarPropertyValue,
         structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
         valueTypeUUID = i.valueTypeUUID))),
  
    restrictionStructuredDataPropertyTuples = 
    TypedDataset.create[api.RestrictionStructuredDataPropertyTuple](
      t.restrictionStructuredDataPropertyTuples.map(i =>
       api.RestrictionStructuredDataPropertyTuple(
         uuid = i.uuid,
         structuredDataPropertyUUID = i.structuredDataPropertyUUID,
         structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID))),
  
    rootConceptTaxonomyAxioms = 
    TypedDataset.create[api.RootConceptTaxonomyAxiom](
      t.rootConceptTaxonomyAxioms.map(i =>
       api.RootConceptTaxonomyAxiom(
         uuid = i.uuid,
         bundleUUID = i.bundleUUID,
         rootUUID = i.rootUUID))),
  
    ruleBodySegments = 
    TypedDataset.create[api.RuleBodySegment](
      t.ruleBodySegments.map(i =>
       api.RuleBodySegment(
         uuid = i.uuid,
         previousSegmentUUID = i.previousSegmentUUID,
         ruleUUID = i.ruleUUID))),
  
    scalars = 
    TypedDataset.create[api.Scalar](
      t.scalars.map(i =>
       api.Scalar(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         name = i.name))),
  
    scalarDataProperties = 
    TypedDataset.create[api.ScalarDataProperty](
      t.scalarDataProperties.map(i =>
       api.ScalarDataProperty(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         domainUUID = i.domainUUID,
         rangeUUID = i.rangeUUID,
         name = i.name))),
  
    scalarDataPropertyValues = 
    TypedDataset.create[api.ScalarDataPropertyValue](
      t.scalarDataPropertyValues.map(i =>
       api.ScalarDataPropertyValue(
         uuid = i.uuid,
         scalarDataPropertyUUID = i.scalarDataPropertyUUID,
         scalarPropertyValue = i.scalarPropertyValue,
         structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
         valueTypeUUID = i.valueTypeUUID))),
  
    scalarOneOfLiteralAxioms = 
    TypedDataset.create[api.ScalarOneOfLiteralAxiom](
      t.scalarOneOfLiteralAxioms.map(i =>
       api.ScalarOneOfLiteralAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         axiomUUID = i.axiomUUID,
         value = i.value,
         valueTypeUUID = i.valueTypeUUID))),
  
    scalarOneOfRestrictions = 
    TypedDataset.create[api.ScalarOneOfRestriction](
      t.scalarOneOfRestrictions.map(i =>
       api.ScalarOneOfRestriction(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         name = i.name))),
  
    singletonInstanceScalarDataPropertyValues = 
    TypedDataset.create[api.SingletonInstanceScalarDataPropertyValue](
      t.singletonInstanceScalarDataPropertyValues.map(i =>
       api.SingletonInstanceScalarDataPropertyValue(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         singletonInstanceUUID = i.singletonInstanceUUID,
         scalarDataPropertyUUID = i.scalarDataPropertyUUID,
         scalarPropertyValue = i.scalarPropertyValue,
         valueTypeUUID = i.valueTypeUUID))),
  
    singletonInstanceStructuredDataPropertyValues = 
    TypedDataset.create[api.SingletonInstanceStructuredDataPropertyValue](
      t.singletonInstanceStructuredDataPropertyValues.map(i =>
       api.SingletonInstanceStructuredDataPropertyValue(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         singletonInstanceUUID = i.singletonInstanceUUID,
         structuredDataPropertyUUID = i.structuredDataPropertyUUID))),
  
    specificDisjointConceptAxioms = 
    TypedDataset.create[api.SpecificDisjointConceptAxiom](
      t.specificDisjointConceptAxioms.map(i =>
       api.SpecificDisjointConceptAxiom(
         uuid = i.uuid,
         disjointTaxonomyParentUUID = i.disjointTaxonomyParentUUID,
         disjointLeafUUID = i.disjointLeafUUID))),
  
    stringScalarRestrictions = 
    TypedDataset.create[api.StringScalarRestriction](
      t.stringScalarRestrictions.map(i =>
       api.StringScalarRestriction(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         length = i.length,
         minLength = i.minLength,
         maxLength = i.maxLength,
         name = i.name,
         pattern = i.pattern))),
  
    structures = 
    TypedDataset.create[api.Structure](
      t.structures.map(i =>
       api.Structure(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         name = i.name))),
  
    structuredDataProperties = 
    TypedDataset.create[api.StructuredDataProperty](
      t.structuredDataProperties.map(i =>
       api.StructuredDataProperty(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         domainUUID = i.domainUUID,
         rangeUUID = i.rangeUUID,
         name = i.name))),
  
    structuredDataPropertyTuples = 
    TypedDataset.create[api.StructuredDataPropertyTuple](
      t.structuredDataPropertyTuples.map(i =>
       api.StructuredDataPropertyTuple(
         uuid = i.uuid,
         structuredDataPropertyUUID = i.structuredDataPropertyUUID,
         structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID))),
  
    synonymScalarRestrictions = 
    TypedDataset.create[api.SynonymScalarRestriction](
      t.synonymScalarRestrictions.map(i =>
       api.SynonymScalarRestriction(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         name = i.name))),
  
    terminologyExtensionAxioms = 
    TypedDataset.create[api.TerminologyExtensionAxiom](
      t.terminologyExtensionAxioms.map(i =>
       api.TerminologyExtensionAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         extendedTerminologyIRI = i.extendedTerminologyIRI))),
  
    terminologyGraphs = 
    TypedDataset.create[api.TerminologyGraph](
      t.terminologyGraphs.map(i =>
       api.TerminologyGraph(
         uuid = i.uuid,
         kind = i.kind,
         iri = i.iri))),
  
    terminologyNestingAxioms = 
    TypedDataset.create[api.TerminologyNestingAxiom](
      t.terminologyNestingAxioms.map(i =>
       api.TerminologyNestingAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         nestingContextUUID = i.nestingContextUUID,
         nestingTerminologyIRI = i.nestingTerminologyIRI))),
  
    timeScalarRestrictions = 
    TypedDataset.create[api.TimeScalarRestriction](
      t.timeScalarRestrictions.map(i =>
       api.TimeScalarRestriction(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         minExclusive = i.minExclusive,
         minInclusive = i.minInclusive,
         maxExclusive = i.maxExclusive,
         maxInclusive = i.maxInclusive,
         name = i.name))),
  
    unreifiedRelationships = 
    TypedDataset.create[api.UnreifiedRelationship](
      t.unreifiedRelationships.map(i =>
       api.UnreifiedRelationship(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         sourceUUID = i.sourceUUID,
         targetUUID = i.targetUUID,
         isAsymmetric = i.isAsymmetric,
         isEssential = i.isEssential,
         isFunctional = i.isFunctional,
         isInverseEssential = i.isInverseEssential,
         isInverseFunctional = i.isInverseFunctional,
         isIrreflexive = i.isIrreflexive,
         isReflexive = i.isReflexive,
         isSymmetric = i.isSymmetric,
         isTransitive = i.isTransitive,
         name = i.name))),
  
    unreifiedRelationshipInstanceTuples = 
    TypedDataset.create[api.UnreifiedRelationshipInstanceTuple](
      t.unreifiedRelationshipInstanceTuples.map(i =>
       api.UnreifiedRelationshipInstanceTuple(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         unreifiedRelationshipUUID = i.unreifiedRelationshipUUID,
         domainUUID = i.domainUUID,
         rangeUUID = i.rangeUUID))),
  
    unreifiedRelationshipInversePropertyPredicates = 
    TypedDataset.create[api.UnreifiedRelationshipInversePropertyPredicate](
      t.unreifiedRelationshipInversePropertyPredicates.map(i =>
       api.UnreifiedRelationshipInversePropertyPredicate(
         uuid = i.uuid,
         unreifiedRelationshipUUID = i.unreifiedRelationshipUUID,
         bodySegmentUUID = i.bodySegmentUUID))),
  
    unreifiedRelationshipPropertyPredicates = 
    TypedDataset.create[api.UnreifiedRelationshipPropertyPredicate](
      t.unreifiedRelationshipPropertyPredicates.map(i =>
       api.UnreifiedRelationshipPropertyPredicate(
         uuid = i.uuid,
         unreifiedRelationshipUUID = i.unreifiedRelationshipUUID,
         bodySegmentUUID = i.bodySegmentUUID)))
  )

  def extractFromOMLSpecificationTypedDatasets
  (t: OMLSpecificationTypedDatasets)
  (implicit sqlContext: SparkSession)
  : tables.OMLSpecificationTables
  = {
  	import frameless.syntax.DefaultSparkDelay
  	
  	tables.OMLSpecificationTables(
  	  annotationProperties = 
  	t.annotationProperties.collect().run().to[Seq].map(i =>
  	  tables.AnnotationProperty(
  	    uuid = i.uuid,
  	    iri = i.iri,
  	    abbrevIRI = i.abbrevIRI)),
  	
  	  annotationPropertyValues = 
  	t.annotationPropertyValues.collect().run().to[Seq].map(i =>
  	  tables.AnnotationPropertyValue(
  	    uuid = i.uuid,
  	    subjectUUID = i.subjectUUID,
  	    propertyUUID = i.propertyUUID,
  	    value = i.value)),
  	
  	  anonymousConceptUnionAxioms = 
  	t.anonymousConceptUnionAxioms.collect().run().to[Seq].map(i =>
  	  tables.AnonymousConceptUnionAxiom(
  	    uuid = i.uuid,
  	    disjointTaxonomyParentUUID = i.disjointTaxonomyParentUUID,
  	    name = i.name)),
  	
  	  aspects = 
  	t.aspects.collect().run().to[Seq].map(i =>
  	  tables.Aspect(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    name = i.name)),
  	
  	  aspectPredicates = 
  	t.aspectPredicates.collect().run().to[Seq].map(i =>
  	  tables.AspectPredicate(
  	    uuid = i.uuid,
  	    aspectUUID = i.aspectUUID,
  	    bodySegmentUUID = i.bodySegmentUUID)),
  	
  	  aspectSpecializationAxioms = 
  	t.aspectSpecializationAxioms.collect().run().to[Seq].map(i =>
  	  tables.AspectSpecializationAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    superAspectUUID = i.superAspectUUID,
  	    subEntityUUID = i.subEntityUUID)),
  	
  	  binaryScalarRestrictions = 
  	t.binaryScalarRestrictions.collect().run().to[Seq].map(i =>
  	  tables.BinaryScalarRestriction(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    length = i.length,
  	    minLength = i.minLength,
  	    maxLength = i.maxLength,
  	    name = i.name)),
  	
  	  bundles = 
  	t.bundles.collect().run().to[Seq].map(i =>
  	  tables.Bundle(
  	    uuid = i.uuid,
  	    kind = i.kind,
  	    iri = i.iri)),
  	
  	  bundledTerminologyAxioms = 
  	t.bundledTerminologyAxioms.collect().run().to[Seq].map(i =>
  	  tables.BundledTerminologyAxiom(
  	    uuid = i.uuid,
  	    bundleUUID = i.bundleUUID,
  	    bundledTerminologyIRI = i.bundledTerminologyIRI)),
  	
  	  chainRules = 
  	t.chainRules.collect().run().to[Seq].map(i =>
  	  tables.ChainRule(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    name = i.name,
  	    headUUID = i.headUUID)),
  	
  	  concepts = 
  	t.concepts.collect().run().to[Seq].map(i =>
  	  tables.Concept(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    name = i.name)),
  	
  	  conceptDesignationTerminologyAxioms = 
  	t.conceptDesignationTerminologyAxioms.collect().run().to[Seq].map(i =>
  	  tables.ConceptDesignationTerminologyAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    designatedConceptUUID = i.designatedConceptUUID,
  	    designatedTerminologyIRI = i.designatedTerminologyIRI)),
  	
  	  conceptInstances = 
  	t.conceptInstances.collect().run().to[Seq].map(i =>
  	  tables.ConceptInstance(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    singletonConceptClassifierUUID = i.singletonConceptClassifierUUID,
  	    name = i.name)),
  	
  	  conceptPredicates = 
  	t.conceptPredicates.collect().run().to[Seq].map(i =>
  	  tables.ConceptPredicate(
  	    uuid = i.uuid,
  	    bodySegmentUUID = i.bodySegmentUUID,
  	    conceptUUID = i.conceptUUID)),
  	
  	  conceptSpecializationAxioms = 
  	t.conceptSpecializationAxioms.collect().run().to[Seq].map(i =>
  	  tables.ConceptSpecializationAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    superConceptUUID = i.superConceptUUID,
  	    subConceptUUID = i.subConceptUUID)),
  	
  	  descriptionBoxes = 
  	t.descriptionBoxes.collect().run().to[Seq].map(i =>
  	  tables.DescriptionBox(
  	    uuid = i.uuid,
  	    kind = i.kind,
  	    iri = i.iri)),
  	
  	  descriptionBoxExtendsClosedWorldDefinitions = 
  	t.descriptionBoxExtendsClosedWorldDefinitions.collect().run().to[Seq].map(i =>
  	  tables.DescriptionBoxExtendsClosedWorldDefinitions(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    closedWorldDefinitionsIRI = i.closedWorldDefinitionsIRI)),
  	
  	  descriptionBoxRefinements = 
  	t.descriptionBoxRefinements.collect().run().to[Seq].map(i =>
  	  tables.DescriptionBoxRefinement(
  	    uuid = i.uuid,
  	    refiningDescriptionBoxUUID = i.refiningDescriptionBoxUUID,
  	    refinedDescriptionBoxIRI = i.refinedDescriptionBoxIRI)),
  	
  	  entityExistentialRestrictionAxioms = 
  	t.entityExistentialRestrictionAxioms.collect().run().to[Seq].map(i =>
  	  tables.EntityExistentialRestrictionAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRelationUUID = i.restrictedRelationUUID,
  	    restrictedDomainUUID = i.restrictedDomainUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID)),
  	
  	  entityScalarDataProperties = 
  	t.entityScalarDataProperties.collect().run().to[Seq].map(i =>
  	  tables.EntityScalarDataProperty(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    domainUUID = i.domainUUID,
  	    rangeUUID = i.rangeUUID,
  	    isIdentityCriteria = i.isIdentityCriteria,
  	    name = i.name)),
  	
  	  entityScalarDataPropertyExistentialRestrictionAxioms = 
  	t.entityScalarDataPropertyExistentialRestrictionAxioms.collect().run().to[Seq].map(i =>
  	  tables.EntityScalarDataPropertyExistentialRestrictionAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedEntityUUID = i.restrictedEntityUUID,
  	    scalarPropertyUUID = i.scalarPropertyUUID,
  	    scalarRestrictionUUID = i.scalarRestrictionUUID)),
  	
  	  entityScalarDataPropertyParticularRestrictionAxioms = 
  	t.entityScalarDataPropertyParticularRestrictionAxioms.collect().run().to[Seq].map(i =>
  	  tables.EntityScalarDataPropertyParticularRestrictionAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedEntityUUID = i.restrictedEntityUUID,
  	    scalarPropertyUUID = i.scalarPropertyUUID,
  	    literalValue = i.literalValue,
  	    valueTypeUUID = i.valueTypeUUID)),
  	
  	  entityScalarDataPropertyUniversalRestrictionAxioms = 
  	t.entityScalarDataPropertyUniversalRestrictionAxioms.collect().run().to[Seq].map(i =>
  	  tables.EntityScalarDataPropertyUniversalRestrictionAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedEntityUUID = i.restrictedEntityUUID,
  	    scalarPropertyUUID = i.scalarPropertyUUID,
  	    scalarRestrictionUUID = i.scalarRestrictionUUID)),
  	
  	  entityStructuredDataProperties = 
  	t.entityStructuredDataProperties.collect().run().to[Seq].map(i =>
  	  tables.EntityStructuredDataProperty(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    domainUUID = i.domainUUID,
  	    rangeUUID = i.rangeUUID,
  	    isIdentityCriteria = i.isIdentityCriteria,
  	    name = i.name)),
  	
  	  entityStructuredDataPropertyParticularRestrictionAxioms = 
  	t.entityStructuredDataPropertyParticularRestrictionAxioms.collect().run().to[Seq].map(i =>
  	  tables.EntityStructuredDataPropertyParticularRestrictionAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    structuredDataPropertyUUID = i.structuredDataPropertyUUID,
  	    restrictedEntityUUID = i.restrictedEntityUUID)),
  	
  	  entityUniversalRestrictionAxioms = 
  	t.entityUniversalRestrictionAxioms.collect().run().to[Seq].map(i =>
  	  tables.EntityUniversalRestrictionAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRelationUUID = i.restrictedRelationUUID,
  	    restrictedDomainUUID = i.restrictedDomainUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID)),
  	
  	  iriScalarRestrictions = 
  	t.iriScalarRestrictions.collect().run().to[Seq].map(i =>
  	  tables.IRIScalarRestriction(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    length = i.length,
  	    minLength = i.minLength,
  	    maxLength = i.maxLength,
  	    name = i.name,
  	    pattern = i.pattern)),
  	
  	  numericScalarRestrictions = 
  	t.numericScalarRestrictions.collect().run().to[Seq].map(i =>
  	  tables.NumericScalarRestriction(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    minExclusive = i.minExclusive,
  	    minInclusive = i.minInclusive,
  	    maxExclusive = i.maxExclusive,
  	    maxInclusive = i.maxInclusive,
  	    name = i.name)),
  	
  	  plainLiteralScalarRestrictions = 
  	t.plainLiteralScalarRestrictions.collect().run().to[Seq].map(i =>
  	  tables.PlainLiteralScalarRestriction(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    length = i.length,
  	    minLength = i.minLength,
  	    maxLength = i.maxLength,
  	    name = i.name,
  	    langRange = i.langRange,
  	    pattern = i.pattern)),
  	
  	  reifiedRelationships = 
  	t.reifiedRelationships.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationship(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    sourceUUID = i.sourceUUID,
  	    targetUUID = i.targetUUID,
  	    isAsymmetric = i.isAsymmetric,
  	    isEssential = i.isEssential,
  	    isFunctional = i.isFunctional,
  	    isInverseEssential = i.isInverseEssential,
  	    isInverseFunctional = i.isInverseFunctional,
  	    isIrreflexive = i.isIrreflexive,
  	    isReflexive = i.isReflexive,
  	    isSymmetric = i.isSymmetric,
  	    isTransitive = i.isTransitive,
  	    name = i.name,
  	    unreifiedPropertyName = i.unreifiedPropertyName,
  	    unreifiedInversePropertyName = i.unreifiedInversePropertyName)),
  	
  	  reifiedRelationshipInstances = 
  	t.reifiedRelationshipInstances.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipInstance(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    singletonReifiedRelationshipClassifierUUID = i.singletonReifiedRelationshipClassifierUUID,
  	    name = i.name)),
  	
  	  reifiedRelationshipInstanceDomains = 
  	t.reifiedRelationshipInstanceDomains.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipInstanceDomain(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    reifiedRelationshipInstanceUUID = i.reifiedRelationshipInstanceUUID,
  	    domainUUID = i.domainUUID)),
  	
  	  reifiedRelationshipInstanceRanges = 
  	t.reifiedRelationshipInstanceRanges.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipInstanceRange(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    reifiedRelationshipInstanceUUID = i.reifiedRelationshipInstanceUUID,
  	    rangeUUID = i.rangeUUID)),
  	
  	  reifiedRelationshipInversePropertyPredicates = 
  	t.reifiedRelationshipInversePropertyPredicates.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipInversePropertyPredicate(
  	    uuid = i.uuid,
  	    bodySegmentUUID = i.bodySegmentUUID,
  	    reifiedRelationshipUUID = i.reifiedRelationshipUUID)),
  	
  	  reifiedRelationshipPredicates = 
  	t.reifiedRelationshipPredicates.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipPredicate(
  	    uuid = i.uuid,
  	    bodySegmentUUID = i.bodySegmentUUID,
  	    reifiedRelationshipUUID = i.reifiedRelationshipUUID)),
  	
  	  reifiedRelationshipPropertyPredicates = 
  	t.reifiedRelationshipPropertyPredicates.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipPropertyPredicate(
  	    uuid = i.uuid,
  	    bodySegmentUUID = i.bodySegmentUUID,
  	    reifiedRelationshipUUID = i.reifiedRelationshipUUID)),
  	
  	  reifiedRelationshipSourceInversePropertyPredicates = 
  	t.reifiedRelationshipSourceInversePropertyPredicates.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipSourceInversePropertyPredicate(
  	    uuid = i.uuid,
  	    bodySegmentUUID = i.bodySegmentUUID,
  	    reifiedRelationshipUUID = i.reifiedRelationshipUUID)),
  	
  	  reifiedRelationshipSourcePropertyPredicates = 
  	t.reifiedRelationshipSourcePropertyPredicates.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipSourcePropertyPredicate(
  	    uuid = i.uuid,
  	    bodySegmentUUID = i.bodySegmentUUID,
  	    reifiedRelationshipUUID = i.reifiedRelationshipUUID)),
  	
  	  reifiedRelationshipSpecializationAxioms = 
  	t.reifiedRelationshipSpecializationAxioms.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipSpecializationAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    superRelationshipUUID = i.superRelationshipUUID,
  	    subRelationshipUUID = i.subRelationshipUUID)),
  	
  	  reifiedRelationshipTargetInversePropertyPredicates = 
  	t.reifiedRelationshipTargetInversePropertyPredicates.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipTargetInversePropertyPredicate(
  	    uuid = i.uuid,
  	    bodySegmentUUID = i.bodySegmentUUID,
  	    reifiedRelationshipUUID = i.reifiedRelationshipUUID)),
  	
  	  reifiedRelationshipTargetPropertyPredicates = 
  	t.reifiedRelationshipTargetPropertyPredicates.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipTargetPropertyPredicate(
  	    uuid = i.uuid,
  	    bodySegmentUUID = i.bodySegmentUUID,
  	    reifiedRelationshipUUID = i.reifiedRelationshipUUID)),
  	
  	  restrictionScalarDataPropertyValues = 
  	t.restrictionScalarDataPropertyValues.collect().run().to[Seq].map(i =>
  	  tables.RestrictionScalarDataPropertyValue(
  	    uuid = i.uuid,
  	    scalarDataPropertyUUID = i.scalarDataPropertyUUID,
  	    scalarPropertyValue = i.scalarPropertyValue,
  	    structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
  	    valueTypeUUID = i.valueTypeUUID)),
  	
  	  restrictionStructuredDataPropertyTuples = 
  	t.restrictionStructuredDataPropertyTuples.collect().run().to[Seq].map(i =>
  	  tables.RestrictionStructuredDataPropertyTuple(
  	    uuid = i.uuid,
  	    structuredDataPropertyUUID = i.structuredDataPropertyUUID,
  	    structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID)),
  	
  	  rootConceptTaxonomyAxioms = 
  	t.rootConceptTaxonomyAxioms.collect().run().to[Seq].map(i =>
  	  tables.RootConceptTaxonomyAxiom(
  	    uuid = i.uuid,
  	    bundleUUID = i.bundleUUID,
  	    rootUUID = i.rootUUID)),
  	
  	  ruleBodySegments = 
  	t.ruleBodySegments.collect().run().to[Seq].map(i =>
  	  tables.RuleBodySegment(
  	    uuid = i.uuid,
  	    previousSegmentUUID = i.previousSegmentUUID,
  	    ruleUUID = i.ruleUUID)),
  	
  	  scalars = 
  	t.scalars.collect().run().to[Seq].map(i =>
  	  tables.Scalar(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    name = i.name)),
  	
  	  scalarDataProperties = 
  	t.scalarDataProperties.collect().run().to[Seq].map(i =>
  	  tables.ScalarDataProperty(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    domainUUID = i.domainUUID,
  	    rangeUUID = i.rangeUUID,
  	    name = i.name)),
  	
  	  scalarDataPropertyValues = 
  	t.scalarDataPropertyValues.collect().run().to[Seq].map(i =>
  	  tables.ScalarDataPropertyValue(
  	    uuid = i.uuid,
  	    scalarDataPropertyUUID = i.scalarDataPropertyUUID,
  	    scalarPropertyValue = i.scalarPropertyValue,
  	    structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
  	    valueTypeUUID = i.valueTypeUUID)),
  	
  	  scalarOneOfLiteralAxioms = 
  	t.scalarOneOfLiteralAxioms.collect().run().to[Seq].map(i =>
  	  tables.ScalarOneOfLiteralAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    axiomUUID = i.axiomUUID,
  	    value = i.value,
  	    valueTypeUUID = i.valueTypeUUID)),
  	
  	  scalarOneOfRestrictions = 
  	t.scalarOneOfRestrictions.collect().run().to[Seq].map(i =>
  	  tables.ScalarOneOfRestriction(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    name = i.name)),
  	
  	  singletonInstanceScalarDataPropertyValues = 
  	t.singletonInstanceScalarDataPropertyValues.collect().run().to[Seq].map(i =>
  	  tables.SingletonInstanceScalarDataPropertyValue(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    singletonInstanceUUID = i.singletonInstanceUUID,
  	    scalarDataPropertyUUID = i.scalarDataPropertyUUID,
  	    scalarPropertyValue = i.scalarPropertyValue,
  	    valueTypeUUID = i.valueTypeUUID)),
  	
  	  singletonInstanceStructuredDataPropertyValues = 
  	t.singletonInstanceStructuredDataPropertyValues.collect().run().to[Seq].map(i =>
  	  tables.SingletonInstanceStructuredDataPropertyValue(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    singletonInstanceUUID = i.singletonInstanceUUID,
  	    structuredDataPropertyUUID = i.structuredDataPropertyUUID)),
  	
  	  specificDisjointConceptAxioms = 
  	t.specificDisjointConceptAxioms.collect().run().to[Seq].map(i =>
  	  tables.SpecificDisjointConceptAxiom(
  	    uuid = i.uuid,
  	    disjointTaxonomyParentUUID = i.disjointTaxonomyParentUUID,
  	    disjointLeafUUID = i.disjointLeafUUID)),
  	
  	  stringScalarRestrictions = 
  	t.stringScalarRestrictions.collect().run().to[Seq].map(i =>
  	  tables.StringScalarRestriction(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    length = i.length,
  	    minLength = i.minLength,
  	    maxLength = i.maxLength,
  	    name = i.name,
  	    pattern = i.pattern)),
  	
  	  structures = 
  	t.structures.collect().run().to[Seq].map(i =>
  	  tables.Structure(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    name = i.name)),
  	
  	  structuredDataProperties = 
  	t.structuredDataProperties.collect().run().to[Seq].map(i =>
  	  tables.StructuredDataProperty(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    domainUUID = i.domainUUID,
  	    rangeUUID = i.rangeUUID,
  	    name = i.name)),
  	
  	  structuredDataPropertyTuples = 
  	t.structuredDataPropertyTuples.collect().run().to[Seq].map(i =>
  	  tables.StructuredDataPropertyTuple(
  	    uuid = i.uuid,
  	    structuredDataPropertyUUID = i.structuredDataPropertyUUID,
  	    structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID)),
  	
  	  synonymScalarRestrictions = 
  	t.synonymScalarRestrictions.collect().run().to[Seq].map(i =>
  	  tables.SynonymScalarRestriction(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    name = i.name)),
  	
  	  terminologyExtensionAxioms = 
  	t.terminologyExtensionAxioms.collect().run().to[Seq].map(i =>
  	  tables.TerminologyExtensionAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    extendedTerminologyIRI = i.extendedTerminologyIRI)),
  	
  	  terminologyGraphs = 
  	t.terminologyGraphs.collect().run().to[Seq].map(i =>
  	  tables.TerminologyGraph(
  	    uuid = i.uuid,
  	    kind = i.kind,
  	    iri = i.iri)),
  	
  	  terminologyNestingAxioms = 
  	t.terminologyNestingAxioms.collect().run().to[Seq].map(i =>
  	  tables.TerminologyNestingAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    nestingContextUUID = i.nestingContextUUID,
  	    nestingTerminologyIRI = i.nestingTerminologyIRI)),
  	
  	  timeScalarRestrictions = 
  	t.timeScalarRestrictions.collect().run().to[Seq].map(i =>
  	  tables.TimeScalarRestriction(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    minExclusive = i.minExclusive,
  	    minInclusive = i.minInclusive,
  	    maxExclusive = i.maxExclusive,
  	    maxInclusive = i.maxInclusive,
  	    name = i.name)),
  	
  	  unreifiedRelationships = 
  	t.unreifiedRelationships.collect().run().to[Seq].map(i =>
  	  tables.UnreifiedRelationship(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    sourceUUID = i.sourceUUID,
  	    targetUUID = i.targetUUID,
  	    isAsymmetric = i.isAsymmetric,
  	    isEssential = i.isEssential,
  	    isFunctional = i.isFunctional,
  	    isInverseEssential = i.isInverseEssential,
  	    isInverseFunctional = i.isInverseFunctional,
  	    isIrreflexive = i.isIrreflexive,
  	    isReflexive = i.isReflexive,
  	    isSymmetric = i.isSymmetric,
  	    isTransitive = i.isTransitive,
  	    name = i.name)),
  	
  	  unreifiedRelationshipInstanceTuples = 
  	t.unreifiedRelationshipInstanceTuples.collect().run().to[Seq].map(i =>
  	  tables.UnreifiedRelationshipInstanceTuple(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    unreifiedRelationshipUUID = i.unreifiedRelationshipUUID,
  	    domainUUID = i.domainUUID,
  	    rangeUUID = i.rangeUUID)),
  	
  	  unreifiedRelationshipInversePropertyPredicates = 
  	t.unreifiedRelationshipInversePropertyPredicates.collect().run().to[Seq].map(i =>
  	  tables.UnreifiedRelationshipInversePropertyPredicate(
  	    uuid = i.uuid,
  	    unreifiedRelationshipUUID = i.unreifiedRelationshipUUID,
  	    bodySegmentUUID = i.bodySegmentUUID)),
  	
  	  unreifiedRelationshipPropertyPredicates = 
  	t.unreifiedRelationshipPropertyPredicates.collect().run().to[Seq].map(i =>
  	  tables.UnreifiedRelationshipPropertyPredicate(
  	    uuid = i.uuid,
  	    unreifiedRelationshipUUID = i.unreifiedRelationshipUUID,
  	    bodySegmentUUID = i.bodySegmentUUID))
  	)
  }

  def parquetReadOMLSpecificationTables
  (dir: Path)
  (implicit spark: SparkSession, sqlContext: SparkSession)
  : Try[tables.OMLSpecificationTables]
  = nonFatalCatch[Try[tables.OMLSpecificationTables]]
    .withApply {
      (cause: java.lang.Throwable) =>
        cause.fillInStackTrace()
        Failure(cause)
    }
    .apply {
  	  dir.toIO.mkdirs()

      import spark.implicits._
	  import scala.Predef.refArrayOps
	  
  	  Success(
  	    tables.OMLSpecificationTables(
  	      annotationProperties = 
  	      spark
  	      .read
  	      .parquet((dir / "AnnotationProperty.parquet").toIO.getAbsolutePath)
  	      .as[tables.AnnotationProperty]
  	      .collect()
  	      .to[Seq],
  	    
  	      annotationPropertyValues = 
  	      spark
  	      .read
  	      .parquet((dir / "AnnotationPropertyValue.parquet").toIO.getAbsolutePath)
  	      .as[tables.AnnotationPropertyValue]
  	      .collect()
  	      .to[Seq],
  	    
  	      anonymousConceptUnionAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "AnonymousConceptUnionAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.AnonymousConceptUnionAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      aspects = 
  	      spark
  	      .read
  	      .parquet((dir / "Aspect.parquet").toIO.getAbsolutePath)
  	      .as[tables.Aspect]
  	      .collect()
  	      .to[Seq],
  	    
  	      aspectPredicates = 
  	      spark
  	      .read
  	      .parquet((dir / "AspectPredicate.parquet").toIO.getAbsolutePath)
  	      .as[tables.AspectPredicate]
  	      .collect()
  	      .to[Seq],
  	    
  	      aspectSpecializationAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "AspectSpecializationAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.AspectSpecializationAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      binaryScalarRestrictions = 
  	      spark
  	      .read
  	      .parquet((dir / "BinaryScalarRestriction.parquet").toIO.getAbsolutePath)
  	      .as[tables.BinaryScalarRestriction]
  	      .collect()
  	      .to[Seq],
  	    
  	      bundles = 
  	      spark
  	      .read
  	      .parquet((dir / "Bundle.parquet").toIO.getAbsolutePath)
  	      .as[tables.Bundle]
  	      .collect()
  	      .to[Seq],
  	    
  	      bundledTerminologyAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "BundledTerminologyAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.BundledTerminologyAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      chainRules = 
  	      spark
  	      .read
  	      .parquet((dir / "ChainRule.parquet").toIO.getAbsolutePath)
  	      .as[tables.ChainRule]
  	      .collect()
  	      .to[Seq],
  	    
  	      concepts = 
  	      spark
  	      .read
  	      .parquet((dir / "Concept.parquet").toIO.getAbsolutePath)
  	      .as[tables.Concept]
  	      .collect()
  	      .to[Seq],
  	    
  	      conceptDesignationTerminologyAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "ConceptDesignationTerminologyAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.ConceptDesignationTerminologyAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      conceptInstances = 
  	      spark
  	      .read
  	      .parquet((dir / "ConceptInstance.parquet").toIO.getAbsolutePath)
  	      .as[tables.ConceptInstance]
  	      .collect()
  	      .to[Seq],
  	    
  	      conceptPredicates = 
  	      spark
  	      .read
  	      .parquet((dir / "ConceptPredicate.parquet").toIO.getAbsolutePath)
  	      .as[tables.ConceptPredicate]
  	      .collect()
  	      .to[Seq],
  	    
  	      conceptSpecializationAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "ConceptSpecializationAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.ConceptSpecializationAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      descriptionBoxes = 
  	      spark
  	      .read
  	      .parquet((dir / "DescriptionBox.parquet").toIO.getAbsolutePath)
  	      .as[tables.DescriptionBox]
  	      .collect()
  	      .to[Seq],
  	    
  	      descriptionBoxExtendsClosedWorldDefinitions = 
  	      spark
  	      .read
  	      .parquet((dir / "DescriptionBoxExtendsClosedWorldDefinitions.parquet").toIO.getAbsolutePath)
  	      .as[tables.DescriptionBoxExtendsClosedWorldDefinitions]
  	      .collect()
  	      .to[Seq],
  	    
  	      descriptionBoxRefinements = 
  	      spark
  	      .read
  	      .parquet((dir / "DescriptionBoxRefinement.parquet").toIO.getAbsolutePath)
  	      .as[tables.DescriptionBoxRefinement]
  	      .collect()
  	      .to[Seq],
  	    
  	      entityExistentialRestrictionAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "EntityExistentialRestrictionAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.EntityExistentialRestrictionAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      entityScalarDataProperties = 
  	      spark
  	      .read
  	      .parquet((dir / "EntityScalarDataProperty.parquet").toIO.getAbsolutePath)
  	      .as[tables.EntityScalarDataProperty]
  	      .collect()
  	      .to[Seq],
  	    
  	      entityScalarDataPropertyExistentialRestrictionAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "EntityScalarDataPropertyExistentialRestrictionAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.EntityScalarDataPropertyExistentialRestrictionAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      entityScalarDataPropertyParticularRestrictionAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "EntityScalarDataPropertyParticularRestrictionAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.EntityScalarDataPropertyParticularRestrictionAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      entityScalarDataPropertyUniversalRestrictionAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "EntityScalarDataPropertyUniversalRestrictionAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.EntityScalarDataPropertyUniversalRestrictionAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      entityStructuredDataProperties = 
  	      spark
  	      .read
  	      .parquet((dir / "EntityStructuredDataProperty.parquet").toIO.getAbsolutePath)
  	      .as[tables.EntityStructuredDataProperty]
  	      .collect()
  	      .to[Seq],
  	    
  	      entityStructuredDataPropertyParticularRestrictionAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "EntityStructuredDataPropertyParticularRestrictionAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.EntityStructuredDataPropertyParticularRestrictionAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      entityUniversalRestrictionAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "EntityUniversalRestrictionAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.EntityUniversalRestrictionAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      iriScalarRestrictions = 
  	      spark
  	      .read
  	      .parquet((dir / "IRIScalarRestriction.parquet").toIO.getAbsolutePath)
  	      .as[tables.IRIScalarRestriction]
  	      .collect()
  	      .to[Seq],
  	    
  	      numericScalarRestrictions = 
  	      spark
  	      .read
  	      .parquet((dir / "NumericScalarRestriction.parquet").toIO.getAbsolutePath)
  	      .as[tables.NumericScalarRestriction]
  	      .collect()
  	      .to[Seq],
  	    
  	      plainLiteralScalarRestrictions = 
  	      spark
  	      .read
  	      .parquet((dir / "PlainLiteralScalarRestriction.parquet").toIO.getAbsolutePath)
  	      .as[tables.PlainLiteralScalarRestriction]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationships = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationship.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationship]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationshipInstances = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationshipInstance.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationshipInstance]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationshipInstanceDomains = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationshipInstanceDomain.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationshipInstanceDomain]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationshipInstanceRanges = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationshipInstanceRange.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationshipInstanceRange]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationshipInversePropertyPredicates = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationshipInversePropertyPredicate.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationshipInversePropertyPredicate]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationshipPredicates = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationshipPredicate.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationshipPredicate]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationshipPropertyPredicates = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationshipPropertyPredicate.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationshipPropertyPredicate]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationshipSourceInversePropertyPredicates = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationshipSourceInversePropertyPredicate.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationshipSourceInversePropertyPredicate]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationshipSourcePropertyPredicates = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationshipSourcePropertyPredicate.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationshipSourcePropertyPredicate]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationshipSpecializationAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationshipSpecializationAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationshipSpecializationAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationshipTargetInversePropertyPredicates = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationshipTargetInversePropertyPredicate.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationshipTargetInversePropertyPredicate]
  	      .collect()
  	      .to[Seq],
  	    
  	      reifiedRelationshipTargetPropertyPredicates = 
  	      spark
  	      .read
  	      .parquet((dir / "ReifiedRelationshipTargetPropertyPredicate.parquet").toIO.getAbsolutePath)
  	      .as[tables.ReifiedRelationshipTargetPropertyPredicate]
  	      .collect()
  	      .to[Seq],
  	    
  	      restrictionScalarDataPropertyValues = 
  	      spark
  	      .read
  	      .parquet((dir / "RestrictionScalarDataPropertyValue.parquet").toIO.getAbsolutePath)
  	      .as[tables.RestrictionScalarDataPropertyValue]
  	      .collect()
  	      .to[Seq],
  	    
  	      restrictionStructuredDataPropertyTuples = 
  	      spark
  	      .read
  	      .parquet((dir / "RestrictionStructuredDataPropertyTuple.parquet").toIO.getAbsolutePath)
  	      .as[tables.RestrictionStructuredDataPropertyTuple]
  	      .collect()
  	      .to[Seq],
  	    
  	      rootConceptTaxonomyAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "RootConceptTaxonomyAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.RootConceptTaxonomyAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      ruleBodySegments = 
  	      spark
  	      .read
  	      .parquet((dir / "RuleBodySegment.parquet").toIO.getAbsolutePath)
  	      .as[tables.RuleBodySegment]
  	      .collect()
  	      .to[Seq],
  	    
  	      scalars = 
  	      spark
  	      .read
  	      .parquet((dir / "Scalar.parquet").toIO.getAbsolutePath)
  	      .as[tables.Scalar]
  	      .collect()
  	      .to[Seq],
  	    
  	      scalarDataProperties = 
  	      spark
  	      .read
  	      .parquet((dir / "ScalarDataProperty.parquet").toIO.getAbsolutePath)
  	      .as[tables.ScalarDataProperty]
  	      .collect()
  	      .to[Seq],
  	    
  	      scalarDataPropertyValues = 
  	      spark
  	      .read
  	      .parquet((dir / "ScalarDataPropertyValue.parquet").toIO.getAbsolutePath)
  	      .as[tables.ScalarDataPropertyValue]
  	      .collect()
  	      .to[Seq],
  	    
  	      scalarOneOfLiteralAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "ScalarOneOfLiteralAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.ScalarOneOfLiteralAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      scalarOneOfRestrictions = 
  	      spark
  	      .read
  	      .parquet((dir / "ScalarOneOfRestriction.parquet").toIO.getAbsolutePath)
  	      .as[tables.ScalarOneOfRestriction]
  	      .collect()
  	      .to[Seq],
  	    
  	      singletonInstanceScalarDataPropertyValues = 
  	      spark
  	      .read
  	      .parquet((dir / "SingletonInstanceScalarDataPropertyValue.parquet").toIO.getAbsolutePath)
  	      .as[tables.SingletonInstanceScalarDataPropertyValue]
  	      .collect()
  	      .to[Seq],
  	    
  	      singletonInstanceStructuredDataPropertyValues = 
  	      spark
  	      .read
  	      .parquet((dir / "SingletonInstanceStructuredDataPropertyValue.parquet").toIO.getAbsolutePath)
  	      .as[tables.SingletonInstanceStructuredDataPropertyValue]
  	      .collect()
  	      .to[Seq],
  	    
  	      specificDisjointConceptAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "SpecificDisjointConceptAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.SpecificDisjointConceptAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      stringScalarRestrictions = 
  	      spark
  	      .read
  	      .parquet((dir / "StringScalarRestriction.parquet").toIO.getAbsolutePath)
  	      .as[tables.StringScalarRestriction]
  	      .collect()
  	      .to[Seq],
  	    
  	      structures = 
  	      spark
  	      .read
  	      .parquet((dir / "Structure.parquet").toIO.getAbsolutePath)
  	      .as[tables.Structure]
  	      .collect()
  	      .to[Seq],
  	    
  	      structuredDataProperties = 
  	      spark
  	      .read
  	      .parquet((dir / "StructuredDataProperty.parquet").toIO.getAbsolutePath)
  	      .as[tables.StructuredDataProperty]
  	      .collect()
  	      .to[Seq],
  	    
  	      structuredDataPropertyTuples = 
  	      spark
  	      .read
  	      .parquet((dir / "StructuredDataPropertyTuple.parquet").toIO.getAbsolutePath)
  	      .as[tables.StructuredDataPropertyTuple]
  	      .collect()
  	      .to[Seq],
  	    
  	      synonymScalarRestrictions = 
  	      spark
  	      .read
  	      .parquet((dir / "SynonymScalarRestriction.parquet").toIO.getAbsolutePath)
  	      .as[tables.SynonymScalarRestriction]
  	      .collect()
  	      .to[Seq],
  	    
  	      terminologyExtensionAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "TerminologyExtensionAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.TerminologyExtensionAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      terminologyGraphs = 
  	      spark
  	      .read
  	      .parquet((dir / "TerminologyGraph.parquet").toIO.getAbsolutePath)
  	      .as[tables.TerminologyGraph]
  	      .collect()
  	      .to[Seq],
  	    
  	      terminologyNestingAxioms = 
  	      spark
  	      .read
  	      .parquet((dir / "TerminologyNestingAxiom.parquet").toIO.getAbsolutePath)
  	      .as[tables.TerminologyNestingAxiom]
  	      .collect()
  	      .to[Seq],
  	    
  	      timeScalarRestrictions = 
  	      spark
  	      .read
  	      .parquet((dir / "TimeScalarRestriction.parquet").toIO.getAbsolutePath)
  	      .as[tables.TimeScalarRestriction]
  	      .collect()
  	      .to[Seq],
  	    
  	      unreifiedRelationships = 
  	      spark
  	      .read
  	      .parquet((dir / "UnreifiedRelationship.parquet").toIO.getAbsolutePath)
  	      .as[tables.UnreifiedRelationship]
  	      .collect()
  	      .to[Seq],
  	    
  	      unreifiedRelationshipInstanceTuples = 
  	      spark
  	      .read
  	      .parquet((dir / "UnreifiedRelationshipInstanceTuple.parquet").toIO.getAbsolutePath)
  	      .as[tables.UnreifiedRelationshipInstanceTuple]
  	      .collect()
  	      .to[Seq],
  	    
  	      unreifiedRelationshipInversePropertyPredicates = 
  	      spark
  	      .read
  	      .parquet((dir / "UnreifiedRelationshipInversePropertyPredicate.parquet").toIO.getAbsolutePath)
  	      .as[tables.UnreifiedRelationshipInversePropertyPredicate]
  	      .collect()
  	      .to[Seq],
  	    
  	      unreifiedRelationshipPropertyPredicates = 
  	      spark
  	      .read
  	      .parquet((dir / "UnreifiedRelationshipPropertyPredicate.parquet").toIO.getAbsolutePath)
  	      .as[tables.UnreifiedRelationshipPropertyPredicate]
  	      .collect()
  	      .to[Seq]
  	    ))
  	}

  def parquetWriteOMLSpecificationTables
  (t: tables.OMLSpecificationTables,
   dir: Path)
  (implicit spark: SparkSession, sqlContext: SparkSession)
  : Try[Unit]
  = nonFatalCatch[Try[Unit]]
    .withApply {
      (cause: java.lang.Throwable) =>
        cause.fillInStackTrace()
        Failure(cause)
    }
    .apply {
    	  import spark.implicits._

  	  dir.toIO.mkdirs()

      t
      .annotationProperties
      .toDF()
      .write
      .parquet((dir / "AnnotationProperty.parquet").toIO.getAbsolutePath())
      
      t
      .annotationPropertyValues
      .toDF()
      .write
      .parquet((dir / "AnnotationPropertyValue.parquet").toIO.getAbsolutePath())
      
      t
      .anonymousConceptUnionAxioms
      .toDF()
      .write
      .parquet((dir / "AnonymousConceptUnionAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .aspects
      .toDF()
      .write
      .parquet((dir / "Aspect.parquet").toIO.getAbsolutePath())
      
      t
      .aspectPredicates
      .toDF()
      .write
      .parquet((dir / "AspectPredicate.parquet").toIO.getAbsolutePath())
      
      t
      .aspectSpecializationAxioms
      .toDF()
      .write
      .parquet((dir / "AspectSpecializationAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .binaryScalarRestrictions
      .toDF()
      .write
      .parquet((dir / "BinaryScalarRestriction.parquet").toIO.getAbsolutePath())
      
      t
      .bundles
      .toDF()
      .write
      .parquet((dir / "Bundle.parquet").toIO.getAbsolutePath())
      
      t
      .bundledTerminologyAxioms
      .toDF()
      .write
      .parquet((dir / "BundledTerminologyAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .chainRules
      .toDF()
      .write
      .parquet((dir / "ChainRule.parquet").toIO.getAbsolutePath())
      
      t
      .concepts
      .toDF()
      .write
      .parquet((dir / "Concept.parquet").toIO.getAbsolutePath())
      
      t
      .conceptDesignationTerminologyAxioms
      .toDF()
      .write
      .parquet((dir / "ConceptDesignationTerminologyAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .conceptInstances
      .toDF()
      .write
      .parquet((dir / "ConceptInstance.parquet").toIO.getAbsolutePath())
      
      t
      .conceptPredicates
      .toDF()
      .write
      .parquet((dir / "ConceptPredicate.parquet").toIO.getAbsolutePath())
      
      t
      .conceptSpecializationAxioms
      .toDF()
      .write
      .parquet((dir / "ConceptSpecializationAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .descriptionBoxes
      .toDF()
      .write
      .parquet((dir / "DescriptionBox.parquet").toIO.getAbsolutePath())
      
      t
      .descriptionBoxExtendsClosedWorldDefinitions
      .toDF()
      .write
      .parquet((dir / "DescriptionBoxExtendsClosedWorldDefinitions.parquet").toIO.getAbsolutePath())
      
      t
      .descriptionBoxRefinements
      .toDF()
      .write
      .parquet((dir / "DescriptionBoxRefinement.parquet").toIO.getAbsolutePath())
      
      t
      .entityExistentialRestrictionAxioms
      .toDF()
      .write
      .parquet((dir / "EntityExistentialRestrictionAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .entityScalarDataProperties
      .toDF()
      .write
      .parquet((dir / "EntityScalarDataProperty.parquet").toIO.getAbsolutePath())
      
      t
      .entityScalarDataPropertyExistentialRestrictionAxioms
      .toDF()
      .write
      .parquet((dir / "EntityScalarDataPropertyExistentialRestrictionAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .entityScalarDataPropertyParticularRestrictionAxioms
      .toDF()
      .write
      .parquet((dir / "EntityScalarDataPropertyParticularRestrictionAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .entityScalarDataPropertyUniversalRestrictionAxioms
      .toDF()
      .write
      .parquet((dir / "EntityScalarDataPropertyUniversalRestrictionAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .entityStructuredDataProperties
      .toDF()
      .write
      .parquet((dir / "EntityStructuredDataProperty.parquet").toIO.getAbsolutePath())
      
      t
      .entityStructuredDataPropertyParticularRestrictionAxioms
      .toDF()
      .write
      .parquet((dir / "EntityStructuredDataPropertyParticularRestrictionAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .entityUniversalRestrictionAxioms
      .toDF()
      .write
      .parquet((dir / "EntityUniversalRestrictionAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .iriScalarRestrictions
      .toDF()
      .write
      .parquet((dir / "IRIScalarRestriction.parquet").toIO.getAbsolutePath())
      
      t
      .numericScalarRestrictions
      .toDF()
      .write
      .parquet((dir / "NumericScalarRestriction.parquet").toIO.getAbsolutePath())
      
      t
      .plainLiteralScalarRestrictions
      .toDF()
      .write
      .parquet((dir / "PlainLiteralScalarRestriction.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationships
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationship.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationshipInstances
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationshipInstance.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationshipInstanceDomains
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationshipInstanceDomain.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationshipInstanceRanges
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationshipInstanceRange.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationshipInversePropertyPredicates
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationshipInversePropertyPredicate.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationshipPredicates
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationshipPredicate.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationshipPropertyPredicates
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationshipPropertyPredicate.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationshipSourceInversePropertyPredicates
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationshipSourceInversePropertyPredicate.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationshipSourcePropertyPredicates
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationshipSourcePropertyPredicate.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationshipSpecializationAxioms
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationshipSpecializationAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationshipTargetInversePropertyPredicates
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationshipTargetInversePropertyPredicate.parquet").toIO.getAbsolutePath())
      
      t
      .reifiedRelationshipTargetPropertyPredicates
      .toDF()
      .write
      .parquet((dir / "ReifiedRelationshipTargetPropertyPredicate.parquet").toIO.getAbsolutePath())
      
      t
      .restrictionScalarDataPropertyValues
      .toDF()
      .write
      .parquet((dir / "RestrictionScalarDataPropertyValue.parquet").toIO.getAbsolutePath())
      
      t
      .restrictionStructuredDataPropertyTuples
      .toDF()
      .write
      .parquet((dir / "RestrictionStructuredDataPropertyTuple.parquet").toIO.getAbsolutePath())
      
      t
      .rootConceptTaxonomyAxioms
      .toDF()
      .write
      .parquet((dir / "RootConceptTaxonomyAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .ruleBodySegments
      .toDF()
      .write
      .parquet((dir / "RuleBodySegment.parquet").toIO.getAbsolutePath())
      
      t
      .scalars
      .toDF()
      .write
      .parquet((dir / "Scalar.parquet").toIO.getAbsolutePath())
      
      t
      .scalarDataProperties
      .toDF()
      .write
      .parquet((dir / "ScalarDataProperty.parquet").toIO.getAbsolutePath())
      
      t
      .scalarDataPropertyValues
      .toDF()
      .write
      .parquet((dir / "ScalarDataPropertyValue.parquet").toIO.getAbsolutePath())
      
      t
      .scalarOneOfLiteralAxioms
      .toDF()
      .write
      .parquet((dir / "ScalarOneOfLiteralAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .scalarOneOfRestrictions
      .toDF()
      .write
      .parquet((dir / "ScalarOneOfRestriction.parquet").toIO.getAbsolutePath())
      
      t
      .singletonInstanceScalarDataPropertyValues
      .toDF()
      .write
      .parquet((dir / "SingletonInstanceScalarDataPropertyValue.parquet").toIO.getAbsolutePath())
      
      t
      .singletonInstanceStructuredDataPropertyValues
      .toDF()
      .write
      .parquet((dir / "SingletonInstanceStructuredDataPropertyValue.parquet").toIO.getAbsolutePath())
      
      t
      .specificDisjointConceptAxioms
      .toDF()
      .write
      .parquet((dir / "SpecificDisjointConceptAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .stringScalarRestrictions
      .toDF()
      .write
      .parquet((dir / "StringScalarRestriction.parquet").toIO.getAbsolutePath())
      
      t
      .structures
      .toDF()
      .write
      .parquet((dir / "Structure.parquet").toIO.getAbsolutePath())
      
      t
      .structuredDataProperties
      .toDF()
      .write
      .parquet((dir / "StructuredDataProperty.parquet").toIO.getAbsolutePath())
      
      t
      .structuredDataPropertyTuples
      .toDF()
      .write
      .parquet((dir / "StructuredDataPropertyTuple.parquet").toIO.getAbsolutePath())
      
      t
      .synonymScalarRestrictions
      .toDF()
      .write
      .parquet((dir / "SynonymScalarRestriction.parquet").toIO.getAbsolutePath())
      
      t
      .terminologyExtensionAxioms
      .toDF()
      .write
      .parquet((dir / "TerminologyExtensionAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .terminologyGraphs
      .toDF()
      .write
      .parquet((dir / "TerminologyGraph.parquet").toIO.getAbsolutePath())
      
      t
      .terminologyNestingAxioms
      .toDF()
      .write
      .parquet((dir / "TerminologyNestingAxiom.parquet").toIO.getAbsolutePath())
      
      t
      .timeScalarRestrictions
      .toDF()
      .write
      .parquet((dir / "TimeScalarRestriction.parquet").toIO.getAbsolutePath())
      
      t
      .unreifiedRelationships
      .toDF()
      .write
      .parquet((dir / "UnreifiedRelationship.parquet").toIO.getAbsolutePath())
      
      t
      .unreifiedRelationshipInstanceTuples
      .toDF()
      .write
      .parquet((dir / "UnreifiedRelationshipInstanceTuple.parquet").toIO.getAbsolutePath())
      
      t
      .unreifiedRelationshipInversePropertyPredicates
      .toDF()
      .write
      .parquet((dir / "UnreifiedRelationshipInversePropertyPredicate.parquet").toIO.getAbsolutePath())
      
      t
      .unreifiedRelationshipPropertyPredicates
      .toDF()
      .write
      .parquet((dir / "UnreifiedRelationshipPropertyPredicate.parquet").toIO.getAbsolutePath())
      
  	  Success(())
  	}

  implicit val descriptionKindI
  : Injection[tables.DescriptionKind, Int]
  = Injection(
  {
  	case tables.Final => 0
  	case tables.Partial => 1
  },
  {
  	case 0 => tables.Final
  	case 1 => tables.Partial
  }
  )
  
  implicit val terminologyKindI
  : Injection[tables.TerminologyKind, Int]
  = Injection(
  {
  	case tables.OpenWorldDefinitions => 0
  	case tables.ClosedWorldDesignations => 1
  },
  {
  	case 0 => tables.OpenWorldDefinitions
  	case 1 => tables.ClosedWorldDesignations
  }
  )
  
}
		
case class OMLSpecificationTypedDatasets
(
  annotationProperties
  : TypedDataset[api.AnnotationProperty],

  annotationPropertyValues
  : TypedDataset[api.AnnotationPropertyValue],

  anonymousConceptUnionAxioms
  : TypedDataset[api.AnonymousConceptUnionAxiom],

  aspects
  : TypedDataset[api.Aspect],

  aspectPredicates
  : TypedDataset[api.AspectPredicate],

  aspectSpecializationAxioms
  : TypedDataset[api.AspectSpecializationAxiom],

  binaryScalarRestrictions
  : TypedDataset[api.BinaryScalarRestriction],

  bundles
  : TypedDataset[api.Bundle],

  bundledTerminologyAxioms
  : TypedDataset[api.BundledTerminologyAxiom],

  chainRules
  : TypedDataset[api.ChainRule],

  concepts
  : TypedDataset[api.Concept],

  conceptDesignationTerminologyAxioms
  : TypedDataset[api.ConceptDesignationTerminologyAxiom],

  conceptInstances
  : TypedDataset[api.ConceptInstance],

  conceptPredicates
  : TypedDataset[api.ConceptPredicate],

  conceptSpecializationAxioms
  : TypedDataset[api.ConceptSpecializationAxiom],

  descriptionBoxes
  : TypedDataset[api.DescriptionBox],

  descriptionBoxExtendsClosedWorldDefinitions
  : TypedDataset[api.DescriptionBoxExtendsClosedWorldDefinitions],

  descriptionBoxRefinements
  : TypedDataset[api.DescriptionBoxRefinement],

  entityExistentialRestrictionAxioms
  : TypedDataset[api.EntityExistentialRestrictionAxiom],

  entityScalarDataProperties
  : TypedDataset[api.EntityScalarDataProperty],

  entityScalarDataPropertyExistentialRestrictionAxioms
  : TypedDataset[api.EntityScalarDataPropertyExistentialRestrictionAxiom],

  entityScalarDataPropertyParticularRestrictionAxioms
  : TypedDataset[api.EntityScalarDataPropertyParticularRestrictionAxiom],

  entityScalarDataPropertyUniversalRestrictionAxioms
  : TypedDataset[api.EntityScalarDataPropertyUniversalRestrictionAxiom],

  entityStructuredDataProperties
  : TypedDataset[api.EntityStructuredDataProperty],

  entityStructuredDataPropertyParticularRestrictionAxioms
  : TypedDataset[api.EntityStructuredDataPropertyParticularRestrictionAxiom],

  entityUniversalRestrictionAxioms
  : TypedDataset[api.EntityUniversalRestrictionAxiom],

  iriScalarRestrictions
  : TypedDataset[api.IRIScalarRestriction],

  numericScalarRestrictions
  : TypedDataset[api.NumericScalarRestriction],

  plainLiteralScalarRestrictions
  : TypedDataset[api.PlainLiteralScalarRestriction],

  reifiedRelationships
  : TypedDataset[api.ReifiedRelationship],

  reifiedRelationshipInstances
  : TypedDataset[api.ReifiedRelationshipInstance],

  reifiedRelationshipInstanceDomains
  : TypedDataset[api.ReifiedRelationshipInstanceDomain],

  reifiedRelationshipInstanceRanges
  : TypedDataset[api.ReifiedRelationshipInstanceRange],

  reifiedRelationshipInversePropertyPredicates
  : TypedDataset[api.ReifiedRelationshipInversePropertyPredicate],

  reifiedRelationshipPredicates
  : TypedDataset[api.ReifiedRelationshipPredicate],

  reifiedRelationshipPropertyPredicates
  : TypedDataset[api.ReifiedRelationshipPropertyPredicate],

  reifiedRelationshipSourceInversePropertyPredicates
  : TypedDataset[api.ReifiedRelationshipSourceInversePropertyPredicate],

  reifiedRelationshipSourcePropertyPredicates
  : TypedDataset[api.ReifiedRelationshipSourcePropertyPredicate],

  reifiedRelationshipSpecializationAxioms
  : TypedDataset[api.ReifiedRelationshipSpecializationAxiom],

  reifiedRelationshipTargetInversePropertyPredicates
  : TypedDataset[api.ReifiedRelationshipTargetInversePropertyPredicate],

  reifiedRelationshipTargetPropertyPredicates
  : TypedDataset[api.ReifiedRelationshipTargetPropertyPredicate],

  restrictionScalarDataPropertyValues
  : TypedDataset[api.RestrictionScalarDataPropertyValue],

  restrictionStructuredDataPropertyTuples
  : TypedDataset[api.RestrictionStructuredDataPropertyTuple],

  rootConceptTaxonomyAxioms
  : TypedDataset[api.RootConceptTaxonomyAxiom],

  ruleBodySegments
  : TypedDataset[api.RuleBodySegment],

  scalars
  : TypedDataset[api.Scalar],

  scalarDataProperties
  : TypedDataset[api.ScalarDataProperty],

  scalarDataPropertyValues
  : TypedDataset[api.ScalarDataPropertyValue],

  scalarOneOfLiteralAxioms
  : TypedDataset[api.ScalarOneOfLiteralAxiom],

  scalarOneOfRestrictions
  : TypedDataset[api.ScalarOneOfRestriction],

  singletonInstanceScalarDataPropertyValues
  : TypedDataset[api.SingletonInstanceScalarDataPropertyValue],

  singletonInstanceStructuredDataPropertyValues
  : TypedDataset[api.SingletonInstanceStructuredDataPropertyValue],

  specificDisjointConceptAxioms
  : TypedDataset[api.SpecificDisjointConceptAxiom],

  stringScalarRestrictions
  : TypedDataset[api.StringScalarRestriction],

  structures
  : TypedDataset[api.Structure],

  structuredDataProperties
  : TypedDataset[api.StructuredDataProperty],

  structuredDataPropertyTuples
  : TypedDataset[api.StructuredDataPropertyTuple],

  synonymScalarRestrictions
  : TypedDataset[api.SynonymScalarRestriction],

  terminologyExtensionAxioms
  : TypedDataset[api.TerminologyExtensionAxiom],

  terminologyGraphs
  : TypedDataset[api.TerminologyGraph],

  terminologyNestingAxioms
  : TypedDataset[api.TerminologyNestingAxiom],

  timeScalarRestrictions
  : TypedDataset[api.TimeScalarRestriction],

  unreifiedRelationships
  : TypedDataset[api.UnreifiedRelationship],

  unreifiedRelationshipInstanceTuples
  : TypedDataset[api.UnreifiedRelationshipInstanceTuple],

  unreifiedRelationshipInversePropertyPredicates
  : TypedDataset[api.UnreifiedRelationshipInversePropertyPredicate],

  unreifiedRelationshipPropertyPredicates
  : TypedDataset[api.UnreifiedRelationshipPropertyPredicate]
)

