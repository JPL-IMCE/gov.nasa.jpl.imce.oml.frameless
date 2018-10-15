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

import ammonite.ops.Path

import frameless.{Injection, TypedDataset, TypedExpressionEncoder}
import gov.nasa.jpl.imce.oml.covariantTag
import gov.nasa.jpl.imce.oml.covariantTag.@@
import gov.nasa.jpl.imce.oml.tables
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder
import org.apache.spark.sql.{SQLContext, SaveMode, SparkSession}

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

  def createEmptyOMLSpecificationTypedDatasets()(implicit sqlContext: SQLContext) // frameless 0.5.0: use SparkSession instead.
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
  
    cardinalityRestrictedAspects = 
    TypedDataset.create[api.CardinalityRestrictedAspect](
      Seq.empty[api.CardinalityRestrictedAspect]),
  
    cardinalityRestrictedConcepts = 
    TypedDataset.create[api.CardinalityRestrictedConcept](
      Seq.empty[api.CardinalityRestrictedConcept]),
  
    cardinalityRestrictedReifiedRelationships = 
    TypedDataset.create[api.CardinalityRestrictedReifiedRelationship](
      Seq.empty[api.CardinalityRestrictedReifiedRelationship]),
  
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
  
    forwardProperties = 
    TypedDataset.create[api.ForwardProperty](
      Seq.empty[api.ForwardProperty]),
  
    iriScalarRestrictions = 
    TypedDataset.create[api.IRIScalarRestriction](
      Seq.empty[api.IRIScalarRestriction]),
  
    instanceRelationshipEnumerationRestrictions = 
    TypedDataset.create[api.InstanceRelationshipEnumerationRestriction](
      Seq.empty[api.InstanceRelationshipEnumerationRestriction]),
  
    instanceRelationshipExistentialRangeRestrictions = 
    TypedDataset.create[api.InstanceRelationshipExistentialRangeRestriction](
      Seq.empty[api.InstanceRelationshipExistentialRangeRestriction]),
  
    instanceRelationshipOneOfRestrictions = 
    TypedDataset.create[api.InstanceRelationshipOneOfRestriction](
      Seq.empty[api.InstanceRelationshipOneOfRestriction]),
  
    instanceRelationshipUniversalRangeRestrictions = 
    TypedDataset.create[api.InstanceRelationshipUniversalRangeRestriction](
      Seq.empty[api.InstanceRelationshipUniversalRangeRestriction]),
  
    instanceRelationshipValueRestrictions = 
    TypedDataset.create[api.InstanceRelationshipValueRestriction](
      Seq.empty[api.InstanceRelationshipValueRestriction]),
  
    inverseProperties = 
    TypedDataset.create[api.InverseProperty](
      Seq.empty[api.InverseProperty]),
  
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
  
    reifiedRelationshipRestrictions = 
    TypedDataset.create[api.ReifiedRelationshipRestriction](
      Seq.empty[api.ReifiedRelationshipRestriction]),
  
    reifiedRelationshipSpecializationAxioms = 
    TypedDataset.create[api.ReifiedRelationshipSpecializationAxiom](
      Seq.empty[api.ReifiedRelationshipSpecializationAxiom]),
  
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
  
    segmentPredicates = 
    TypedDataset.create[api.SegmentPredicate](
      Seq.empty[api.SegmentPredicate]),
  
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
  
    subDataPropertyOfAxioms = 
    TypedDataset.create[api.SubDataPropertyOfAxiom](
      Seq.empty[api.SubDataPropertyOfAxiom]),
  
    subObjectPropertyOfAxioms = 
    TypedDataset.create[api.SubObjectPropertyOfAxiom](
      Seq.empty[api.SubObjectPropertyOfAxiom]),
  
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
      Seq.empty[api.UnreifiedRelationshipInstanceTuple])
  )
    
  def convertToOMLSpecificationTypedDatasets
  (t: tables.OMLSpecificationTables)
  (implicit sqlContext: SQLContext) // frameless 0.5.0: use SparkSession instead.
  : OMLSpecificationTypedDatasets
  = OMLSpecificationTypedDatasets(
    annotationProperties = 
    TypedDataset.create[api.AnnotationProperty](
      t.annotationProperties.map(i =>
       api.AnnotationProperty(
         uuid = i.uuid,
         moduleUUID = i.moduleUUID,
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
  
    cardinalityRestrictedAspects = 
    TypedDataset.create[api.CardinalityRestrictedAspect](
      t.cardinalityRestrictedAspects.map(i =>
       api.CardinalityRestrictedAspect(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         name = i.name,
         restrictedCardinality = i.restrictedCardinality,
         restrictedRelationshipUUID = i.restrictedRelationshipUUID,
         restrictionKind = i.restrictionKind))),
  
    cardinalityRestrictedConcepts = 
    TypedDataset.create[api.CardinalityRestrictedConcept](
      t.cardinalityRestrictedConcepts.map(i =>
       api.CardinalityRestrictedConcept(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         name = i.name,
         restrictedCardinality = i.restrictedCardinality,
         restrictedRelationshipUUID = i.restrictedRelationshipUUID,
         restrictionKind = i.restrictionKind))),
  
    cardinalityRestrictedReifiedRelationships = 
    TypedDataset.create[api.CardinalityRestrictedReifiedRelationship](
      t.cardinalityRestrictedReifiedRelationships.map(i =>
       api.CardinalityRestrictedReifiedRelationship(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         name = i.name,
         restrictedCardinality = i.restrictedCardinality,
         restrictedRelationshipUUID = i.restrictedRelationshipUUID,
         restrictionKind = i.restrictionKind))),
  
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
         restrictedDomainUUID = i.restrictedDomainUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         restrictedRelationshipUUID = i.restrictedRelationshipUUID))),
  
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
         restrictedDomainUUID = i.restrictedDomainUUID,
         restrictedRangeUUID = i.restrictedRangeUUID,
         restrictedRelationshipUUID = i.restrictedRelationshipUUID))),
  
    forwardProperties = 
    TypedDataset.create[api.ForwardProperty](
      t.forwardProperties.map(i =>
       api.ForwardProperty(
         uuid = i.uuid,
         name = i.name,
         reifiedRelationshipUUID = i.reifiedRelationshipUUID))),
  
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
  
    instanceRelationshipEnumerationRestrictions = 
    TypedDataset.create[api.InstanceRelationshipEnumerationRestriction](
      t.instanceRelationshipEnumerationRestrictions.map(i =>
       api.InstanceRelationshipEnumerationRestriction(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         domainUUID = i.domainUUID,
         restrictedRelationshipUUID = i.restrictedRelationshipUUID))),
  
    instanceRelationshipExistentialRangeRestrictions = 
    TypedDataset.create[api.InstanceRelationshipExistentialRangeRestriction](
      t.instanceRelationshipExistentialRangeRestrictions.map(i =>
       api.InstanceRelationshipExistentialRangeRestriction(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         domainUUID = i.domainUUID,
         rangeUUID = i.rangeUUID,
         restrictedRelationshipUUID = i.restrictedRelationshipUUID))),
  
    instanceRelationshipOneOfRestrictions = 
    TypedDataset.create[api.InstanceRelationshipOneOfRestriction](
      t.instanceRelationshipOneOfRestrictions.map(i =>
       api.InstanceRelationshipOneOfRestriction(
         uuid = i.uuid,
         rangeUUID = i.rangeUUID,
         enumerationUUID = i.enumerationUUID))),
  
    instanceRelationshipUniversalRangeRestrictions = 
    TypedDataset.create[api.InstanceRelationshipUniversalRangeRestriction](
      t.instanceRelationshipUniversalRangeRestrictions.map(i =>
       api.InstanceRelationshipUniversalRangeRestriction(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         domainUUID = i.domainUUID,
         rangeUUID = i.rangeUUID,
         restrictedRelationshipUUID = i.restrictedRelationshipUUID))),
  
    instanceRelationshipValueRestrictions = 
    TypedDataset.create[api.InstanceRelationshipValueRestriction](
      t.instanceRelationshipValueRestrictions.map(i =>
       api.InstanceRelationshipValueRestriction(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         domainUUID = i.domainUUID,
         rangeUUID = i.rangeUUID,
         restrictedRelationshipUUID = i.restrictedRelationshipUUID))),
  
    inverseProperties = 
    TypedDataset.create[api.InverseProperty](
      t.inverseProperties.map(i =>
       api.InverseProperty(
         uuid = i.uuid,
         name = i.name,
         reifiedRelationshipUUID = i.reifiedRelationshipUUID))),
  
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
         name = i.name))),
  
    reifiedRelationshipInstances = 
    TypedDataset.create[api.ReifiedRelationshipInstance](
      t.reifiedRelationshipInstances.map(i =>
       api.ReifiedRelationshipInstance(
         uuid = i.uuid,
         descriptionBoxUUID = i.descriptionBoxUUID,
         singletonConceptualRelationshipClassifierUUID = i.singletonConceptualRelationshipClassifierUUID,
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
  
    reifiedRelationshipRestrictions = 
    TypedDataset.create[api.ReifiedRelationshipRestriction](
      t.reifiedRelationshipRestrictions.map(i =>
       api.ReifiedRelationshipRestriction(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         sourceUUID = i.sourceUUID,
         targetUUID = i.targetUUID,
         name = i.name))),
  
    reifiedRelationshipSpecializationAxioms = 
    TypedDataset.create[api.ReifiedRelationshipSpecializationAxiom](
      t.reifiedRelationshipSpecializationAxioms.map(i =>
       api.ReifiedRelationshipSpecializationAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         superRelationshipUUID = i.superRelationshipUUID,
         subRelationshipUUID = i.subRelationshipUUID))),
  
    restrictionScalarDataPropertyValues = 
    TypedDataset.create[api.RestrictionScalarDataPropertyValue](
      t.restrictionScalarDataPropertyValues.map(i =>
       api.RestrictionScalarDataPropertyValue(
         uuid = i.uuid,
         structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
         scalarDataPropertyUUID = i.scalarDataPropertyUUID,
         scalarPropertyValue = i.scalarPropertyValue,
         valueTypeUUID = i.valueTypeUUID))),
  
    restrictionStructuredDataPropertyTuples = 
    TypedDataset.create[api.RestrictionStructuredDataPropertyTuple](
      t.restrictionStructuredDataPropertyTuples.map(i =>
       api.RestrictionStructuredDataPropertyTuple(
         uuid = i.uuid,
         structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
         structuredDataPropertyUUID = i.structuredDataPropertyUUID))),
  
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
         structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
         scalarDataPropertyUUID = i.scalarDataPropertyUUID,
         scalarPropertyValue = i.scalarPropertyValue,
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
  
    segmentPredicates = 
    TypedDataset.create[api.SegmentPredicate](
      t.segmentPredicates.map(i =>
       api.SegmentPredicate(
         uuid = i.uuid,
         bodySegmentUUID = i.bodySegmentUUID,
         predicateUUID = i.predicateUUID,
         reifiedRelationshipSourceUUID = i.reifiedRelationshipSourceUUID,
         reifiedRelationshipInverseSourceUUID = i.reifiedRelationshipInverseSourceUUID,
         reifiedRelationshipTargetUUID = i.reifiedRelationshipTargetUUID,
         reifiedRelationshipInverseTargetUUID = i.reifiedRelationshipInverseTargetUUID,
         unreifiedRelationshipInverseUUID = i.unreifiedRelationshipInverseUUID))),
  
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
         structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
         structuredDataPropertyUUID = i.structuredDataPropertyUUID))),
  
    subDataPropertyOfAxioms = 
    TypedDataset.create[api.SubDataPropertyOfAxiom](
      t.subDataPropertyOfAxioms.map(i =>
       api.SubDataPropertyOfAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         subPropertyUUID = i.subPropertyUUID,
         superPropertyUUID = i.superPropertyUUID))),
  
    subObjectPropertyOfAxioms = 
    TypedDataset.create[api.SubObjectPropertyOfAxiom](
      t.subObjectPropertyOfAxioms.map(i =>
       api.SubObjectPropertyOfAxiom(
         uuid = i.uuid,
         tboxUUID = i.tboxUUID,
         subPropertyUUID = i.subPropertyUUID,
         superPropertyUUID = i.superPropertyUUID))),
  
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
         rangeUUID = i.rangeUUID)))
  )

  def extractFromOMLSpecificationTypedDatasets
  (t: OMLSpecificationTypedDatasets)
  (implicit sqlContext: SQLContext) // frameless 0.5.0: use SparkSession instead.
  : tables.OMLSpecificationTables
  = {
  	import frameless.syntax.DefaultSparkDelay
  	
  	tables.OMLSpecificationTables(
  	  annotationProperties = 
  	t.annotationProperties.collect().run().to[Seq].map(i =>
  	  tables.AnnotationProperty(
  	    uuid = i.uuid,
  	    moduleUUID = i.moduleUUID,
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
  	
  	  cardinalityRestrictedAspects = 
  	t.cardinalityRestrictedAspects.collect().run().to[Seq].map(i =>
  	  tables.CardinalityRestrictedAspect(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    name = i.name,
  	    restrictedCardinality = i.restrictedCardinality,
  	    restrictedRelationshipUUID = i.restrictedRelationshipUUID,
  	    restrictionKind = i.restrictionKind)),
  	
  	  cardinalityRestrictedConcepts = 
  	t.cardinalityRestrictedConcepts.collect().run().to[Seq].map(i =>
  	  tables.CardinalityRestrictedConcept(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    name = i.name,
  	    restrictedCardinality = i.restrictedCardinality,
  	    restrictedRelationshipUUID = i.restrictedRelationshipUUID,
  	    restrictionKind = i.restrictionKind)),
  	
  	  cardinalityRestrictedReifiedRelationships = 
  	t.cardinalityRestrictedReifiedRelationships.collect().run().to[Seq].map(i =>
  	  tables.CardinalityRestrictedReifiedRelationship(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    name = i.name,
  	    restrictedCardinality = i.restrictedCardinality,
  	    restrictedRelationshipUUID = i.restrictedRelationshipUUID,
  	    restrictionKind = i.restrictionKind)),
  	
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
  	    restrictedDomainUUID = i.restrictedDomainUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    restrictedRelationshipUUID = i.restrictedRelationshipUUID)),
  	
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
  	    restrictedDomainUUID = i.restrictedDomainUUID,
  	    restrictedRangeUUID = i.restrictedRangeUUID,
  	    restrictedRelationshipUUID = i.restrictedRelationshipUUID)),
  	
  	  forwardProperties = 
  	t.forwardProperties.collect().run().to[Seq].map(i =>
  	  tables.ForwardProperty(
  	    uuid = i.uuid,
  	    name = i.name,
  	    reifiedRelationshipUUID = i.reifiedRelationshipUUID)),
  	
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
  	
  	  instanceRelationshipEnumerationRestrictions = 
  	t.instanceRelationshipEnumerationRestrictions.collect().run().to[Seq].map(i =>
  	  tables.InstanceRelationshipEnumerationRestriction(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    domainUUID = i.domainUUID,
  	    restrictedRelationshipUUID = i.restrictedRelationshipUUID)),
  	
  	  instanceRelationshipExistentialRangeRestrictions = 
  	t.instanceRelationshipExistentialRangeRestrictions.collect().run().to[Seq].map(i =>
  	  tables.InstanceRelationshipExistentialRangeRestriction(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    domainUUID = i.domainUUID,
  	    rangeUUID = i.rangeUUID,
  	    restrictedRelationshipUUID = i.restrictedRelationshipUUID)),
  	
  	  instanceRelationshipOneOfRestrictions = 
  	t.instanceRelationshipOneOfRestrictions.collect().run().to[Seq].map(i =>
  	  tables.InstanceRelationshipOneOfRestriction(
  	    uuid = i.uuid,
  	    rangeUUID = i.rangeUUID,
  	    enumerationUUID = i.enumerationUUID)),
  	
  	  instanceRelationshipUniversalRangeRestrictions = 
  	t.instanceRelationshipUniversalRangeRestrictions.collect().run().to[Seq].map(i =>
  	  tables.InstanceRelationshipUniversalRangeRestriction(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    domainUUID = i.domainUUID,
  	    rangeUUID = i.rangeUUID,
  	    restrictedRelationshipUUID = i.restrictedRelationshipUUID)),
  	
  	  instanceRelationshipValueRestrictions = 
  	t.instanceRelationshipValueRestrictions.collect().run().to[Seq].map(i =>
  	  tables.InstanceRelationshipValueRestriction(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    domainUUID = i.domainUUID,
  	    rangeUUID = i.rangeUUID,
  	    restrictedRelationshipUUID = i.restrictedRelationshipUUID)),
  	
  	  inverseProperties = 
  	t.inverseProperties.collect().run().to[Seq].map(i =>
  	  tables.InverseProperty(
  	    uuid = i.uuid,
  	    name = i.name,
  	    reifiedRelationshipUUID = i.reifiedRelationshipUUID)),
  	
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
  	    name = i.name)),
  	
  	  reifiedRelationshipInstances = 
  	t.reifiedRelationshipInstances.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipInstance(
  	    uuid = i.uuid,
  	    descriptionBoxUUID = i.descriptionBoxUUID,
  	    singletonConceptualRelationshipClassifierUUID = i.singletonConceptualRelationshipClassifierUUID,
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
  	
  	  reifiedRelationshipRestrictions = 
  	t.reifiedRelationshipRestrictions.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipRestriction(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    sourceUUID = i.sourceUUID,
  	    targetUUID = i.targetUUID,
  	    name = i.name)),
  	
  	  reifiedRelationshipSpecializationAxioms = 
  	t.reifiedRelationshipSpecializationAxioms.collect().run().to[Seq].map(i =>
  	  tables.ReifiedRelationshipSpecializationAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    superRelationshipUUID = i.superRelationshipUUID,
  	    subRelationshipUUID = i.subRelationshipUUID)),
  	
  	  restrictionScalarDataPropertyValues = 
  	t.restrictionScalarDataPropertyValues.collect().run().to[Seq].map(i =>
  	  tables.RestrictionScalarDataPropertyValue(
  	    uuid = i.uuid,
  	    structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
  	    scalarDataPropertyUUID = i.scalarDataPropertyUUID,
  	    scalarPropertyValue = i.scalarPropertyValue,
  	    valueTypeUUID = i.valueTypeUUID)),
  	
  	  restrictionStructuredDataPropertyTuples = 
  	t.restrictionStructuredDataPropertyTuples.collect().run().to[Seq].map(i =>
  	  tables.RestrictionStructuredDataPropertyTuple(
  	    uuid = i.uuid,
  	    structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
  	    structuredDataPropertyUUID = i.structuredDataPropertyUUID)),
  	
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
  	    structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
  	    scalarDataPropertyUUID = i.scalarDataPropertyUUID,
  	    scalarPropertyValue = i.scalarPropertyValue,
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
  	
  	  segmentPredicates = 
  	t.segmentPredicates.collect().run().to[Seq].map(i =>
  	  tables.SegmentPredicate(
  	    uuid = i.uuid,
  	    bodySegmentUUID = i.bodySegmentUUID,
  	    predicateUUID = i.predicateUUID,
  	    reifiedRelationshipSourceUUID = i.reifiedRelationshipSourceUUID,
  	    reifiedRelationshipInverseSourceUUID = i.reifiedRelationshipInverseSourceUUID,
  	    reifiedRelationshipTargetUUID = i.reifiedRelationshipTargetUUID,
  	    reifiedRelationshipInverseTargetUUID = i.reifiedRelationshipInverseTargetUUID,
  	    unreifiedRelationshipInverseUUID = i.unreifiedRelationshipInverseUUID)),
  	
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
  	    structuredDataPropertyContextUUID = i.structuredDataPropertyContextUUID,
  	    structuredDataPropertyUUID = i.structuredDataPropertyUUID)),
  	
  	  subDataPropertyOfAxioms = 
  	t.subDataPropertyOfAxioms.collect().run().to[Seq].map(i =>
  	  tables.SubDataPropertyOfAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    subPropertyUUID = i.subPropertyUUID,
  	    superPropertyUUID = i.superPropertyUUID)),
  	
  	  subObjectPropertyOfAxioms = 
  	t.subObjectPropertyOfAxioms.collect().run().to[Seq].map(i =>
  	  tables.SubObjectPropertyOfAxiom(
  	    uuid = i.uuid,
  	    tboxUUID = i.tboxUUID,
  	    subPropertyUUID = i.subPropertyUUID,
  	    superPropertyUUID = i.superPropertyUUID)),
  	
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
  	    rangeUUID = i.rangeUUID))
  	)
  }

  def parquetReadOMLSpecificationTables
  (dir: Path)
  (implicit spark: SparkSession, sqlContext: SQLContext)
  : Try[tables.OMLSpecificationTables]
  = nonFatalCatch[Try[tables.OMLSpecificationTables]]
    .withApply {
      (cause: java.lang.Throwable) =>
        Failure(cause)
    }
    .apply {
  	  dir.toIO.mkdirs()

      import spark.implicits._
      import scala.Predef.refArrayOps
	  
      val annotationProperties
      : Seq[tables.AnnotationProperty]
      = spark
        .read
        .parquet((dir / "AnnotationProperty.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.AnnotationPropertyRow2Tuple)
        .collect()
        .map(OMLReaders.AnnotationPropertyTuple2Type)
        .to[Seq]
      
      val annotationPropertyValues
      : Seq[tables.AnnotationPropertyValue]
      = spark
        .read
        .parquet((dir / "AnnotationPropertyValue.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.AnnotationPropertyValueRow2Tuple)
        .collect()
        .map(OMLReaders.AnnotationPropertyValueTuple2Type)
        .to[Seq]
      
      val anonymousConceptUnionAxioms
      : Seq[tables.AnonymousConceptUnionAxiom]
      = spark
        .read
        .parquet((dir / "AnonymousConceptUnionAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.AnonymousConceptUnionAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.AnonymousConceptUnionAxiomTuple2Type)
        .to[Seq]
      
      val aspects
      : Seq[tables.Aspect]
      = spark
        .read
        .parquet((dir / "Aspect.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.AspectRow2Tuple)
        .collect()
        .map(OMLReaders.AspectTuple2Type)
        .to[Seq]
      
      val aspectSpecializationAxioms
      : Seq[tables.AspectSpecializationAxiom]
      = spark
        .read
        .parquet((dir / "AspectSpecializationAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.AspectSpecializationAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.AspectSpecializationAxiomTuple2Type)
        .to[Seq]
      
      val binaryScalarRestrictions
      : Seq[tables.BinaryScalarRestriction]
      = spark
        .read
        .parquet((dir / "BinaryScalarRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.BinaryScalarRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.BinaryScalarRestrictionTuple2Type)
        .to[Seq]
      
      val bundles
      : Seq[tables.Bundle]
      = spark
        .read
        .parquet((dir / "Bundle.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.BundleRow2Tuple)
        .collect()
        .map(OMLReaders.BundleTuple2Type)
        .to[Seq]
      
      val bundledTerminologyAxioms
      : Seq[tables.BundledTerminologyAxiom]
      = spark
        .read
        .parquet((dir / "BundledTerminologyAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.BundledTerminologyAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.BundledTerminologyAxiomTuple2Type)
        .to[Seq]
      
      val cardinalityRestrictedAspects
      : Seq[tables.CardinalityRestrictedAspect]
      = spark
        .read
        .parquet((dir / "CardinalityRestrictedAspect.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.CardinalityRestrictedAspectRow2Tuple)
        .collect()
        .map(OMLReaders.CardinalityRestrictedAspectTuple2Type)
        .to[Seq]
      
      val cardinalityRestrictedConcepts
      : Seq[tables.CardinalityRestrictedConcept]
      = spark
        .read
        .parquet((dir / "CardinalityRestrictedConcept.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.CardinalityRestrictedConceptRow2Tuple)
        .collect()
        .map(OMLReaders.CardinalityRestrictedConceptTuple2Type)
        .to[Seq]
      
      val cardinalityRestrictedReifiedRelationships
      : Seq[tables.CardinalityRestrictedReifiedRelationship]
      = spark
        .read
        .parquet((dir / "CardinalityRestrictedReifiedRelationship.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.CardinalityRestrictedReifiedRelationshipRow2Tuple)
        .collect()
        .map(OMLReaders.CardinalityRestrictedReifiedRelationshipTuple2Type)
        .to[Seq]
      
      val chainRules
      : Seq[tables.ChainRule]
      = spark
        .read
        .parquet((dir / "ChainRule.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ChainRuleRow2Tuple)
        .collect()
        .map(OMLReaders.ChainRuleTuple2Type)
        .to[Seq]
      
      val concepts
      : Seq[tables.Concept]
      = spark
        .read
        .parquet((dir / "Concept.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ConceptRow2Tuple)
        .collect()
        .map(OMLReaders.ConceptTuple2Type)
        .to[Seq]
      
      val conceptDesignationTerminologyAxioms
      : Seq[tables.ConceptDesignationTerminologyAxiom]
      = spark
        .read
        .parquet((dir / "ConceptDesignationTerminologyAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ConceptDesignationTerminologyAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.ConceptDesignationTerminologyAxiomTuple2Type)
        .to[Seq]
      
      val conceptInstances
      : Seq[tables.ConceptInstance]
      = spark
        .read
        .parquet((dir / "ConceptInstance.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ConceptInstanceRow2Tuple)
        .collect()
        .map(OMLReaders.ConceptInstanceTuple2Type)
        .to[Seq]
      
      val conceptSpecializationAxioms
      : Seq[tables.ConceptSpecializationAxiom]
      = spark
        .read
        .parquet((dir / "ConceptSpecializationAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ConceptSpecializationAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.ConceptSpecializationAxiomTuple2Type)
        .to[Seq]
      
      val descriptionBoxes
      : Seq[tables.DescriptionBox]
      = spark
        .read
        .parquet((dir / "DescriptionBox.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.DescriptionBoxRow2Tuple)
        .collect()
        .map(OMLReaders.DescriptionBoxTuple2Type)
        .to[Seq]
      
      val descriptionBoxExtendsClosedWorldDefinitions
      : Seq[tables.DescriptionBoxExtendsClosedWorldDefinitions]
      = spark
        .read
        .parquet((dir / "DescriptionBoxExtendsClosedWorldDefinitions.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.DescriptionBoxExtendsClosedWorldDefinitionsRow2Tuple)
        .collect()
        .map(OMLReaders.DescriptionBoxExtendsClosedWorldDefinitionsTuple2Type)
        .to[Seq]
      
      val descriptionBoxRefinements
      : Seq[tables.DescriptionBoxRefinement]
      = spark
        .read
        .parquet((dir / "DescriptionBoxRefinement.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.DescriptionBoxRefinementRow2Tuple)
        .collect()
        .map(OMLReaders.DescriptionBoxRefinementTuple2Type)
        .to[Seq]
      
      val entityExistentialRestrictionAxioms
      : Seq[tables.EntityExistentialRestrictionAxiom]
      = spark
        .read
        .parquet((dir / "EntityExistentialRestrictionAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.EntityExistentialRestrictionAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.EntityExistentialRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val entityScalarDataProperties
      : Seq[tables.EntityScalarDataProperty]
      = spark
        .read
        .parquet((dir / "EntityScalarDataProperty.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.EntityScalarDataPropertyRow2Tuple)
        .collect()
        .map(OMLReaders.EntityScalarDataPropertyTuple2Type)
        .to[Seq]
      
      val entityScalarDataPropertyExistentialRestrictionAxioms
      : Seq[tables.EntityScalarDataPropertyExistentialRestrictionAxiom]
      = spark
        .read
        .parquet((dir / "EntityScalarDataPropertyExistentialRestrictionAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.EntityScalarDataPropertyExistentialRestrictionAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.EntityScalarDataPropertyExistentialRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val entityScalarDataPropertyParticularRestrictionAxioms
      : Seq[tables.EntityScalarDataPropertyParticularRestrictionAxiom]
      = spark
        .read
        .parquet((dir / "EntityScalarDataPropertyParticularRestrictionAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.EntityScalarDataPropertyParticularRestrictionAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.EntityScalarDataPropertyParticularRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val entityScalarDataPropertyUniversalRestrictionAxioms
      : Seq[tables.EntityScalarDataPropertyUniversalRestrictionAxiom]
      = spark
        .read
        .parquet((dir / "EntityScalarDataPropertyUniversalRestrictionAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.EntityScalarDataPropertyUniversalRestrictionAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.EntityScalarDataPropertyUniversalRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val entityStructuredDataProperties
      : Seq[tables.EntityStructuredDataProperty]
      = spark
        .read
        .parquet((dir / "EntityStructuredDataProperty.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.EntityStructuredDataPropertyRow2Tuple)
        .collect()
        .map(OMLReaders.EntityStructuredDataPropertyTuple2Type)
        .to[Seq]
      
      val entityStructuredDataPropertyParticularRestrictionAxioms
      : Seq[tables.EntityStructuredDataPropertyParticularRestrictionAxiom]
      = spark
        .read
        .parquet((dir / "EntityStructuredDataPropertyParticularRestrictionAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.EntityStructuredDataPropertyParticularRestrictionAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.EntityStructuredDataPropertyParticularRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val entityUniversalRestrictionAxioms
      : Seq[tables.EntityUniversalRestrictionAxiom]
      = spark
        .read
        .parquet((dir / "EntityUniversalRestrictionAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.EntityUniversalRestrictionAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.EntityUniversalRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val forwardProperties
      : Seq[tables.ForwardProperty]
      = spark
        .read
        .parquet((dir / "ForwardProperty.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ForwardPropertyRow2Tuple)
        .collect()
        .map(OMLReaders.ForwardPropertyTuple2Type)
        .to[Seq]
      
      val iriScalarRestrictions
      : Seq[tables.IRIScalarRestriction]
      = spark
        .read
        .parquet((dir / "IRIScalarRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.IRIScalarRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.IRIScalarRestrictionTuple2Type)
        .to[Seq]
      
      val instanceRelationshipEnumerationRestrictions
      : Seq[tables.InstanceRelationshipEnumerationRestriction]
      = spark
        .read
        .parquet((dir / "InstanceRelationshipEnumerationRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.InstanceRelationshipEnumerationRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.InstanceRelationshipEnumerationRestrictionTuple2Type)
        .to[Seq]
      
      val instanceRelationshipExistentialRangeRestrictions
      : Seq[tables.InstanceRelationshipExistentialRangeRestriction]
      = spark
        .read
        .parquet((dir / "InstanceRelationshipExistentialRangeRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.InstanceRelationshipExistentialRangeRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.InstanceRelationshipExistentialRangeRestrictionTuple2Type)
        .to[Seq]
      
      val instanceRelationshipOneOfRestrictions
      : Seq[tables.InstanceRelationshipOneOfRestriction]
      = spark
        .read
        .parquet((dir / "InstanceRelationshipOneOfRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.InstanceRelationshipOneOfRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.InstanceRelationshipOneOfRestrictionTuple2Type)
        .to[Seq]
      
      val instanceRelationshipUniversalRangeRestrictions
      : Seq[tables.InstanceRelationshipUniversalRangeRestriction]
      = spark
        .read
        .parquet((dir / "InstanceRelationshipUniversalRangeRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.InstanceRelationshipUniversalRangeRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.InstanceRelationshipUniversalRangeRestrictionTuple2Type)
        .to[Seq]
      
      val instanceRelationshipValueRestrictions
      : Seq[tables.InstanceRelationshipValueRestriction]
      = spark
        .read
        .parquet((dir / "InstanceRelationshipValueRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.InstanceRelationshipValueRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.InstanceRelationshipValueRestrictionTuple2Type)
        .to[Seq]
      
      val inverseProperties
      : Seq[tables.InverseProperty]
      = spark
        .read
        .parquet((dir / "InverseProperty.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.InversePropertyRow2Tuple)
        .collect()
        .map(OMLReaders.InversePropertyTuple2Type)
        .to[Seq]
      
      val numericScalarRestrictions
      : Seq[tables.NumericScalarRestriction]
      = spark
        .read
        .parquet((dir / "NumericScalarRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.NumericScalarRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.NumericScalarRestrictionTuple2Type)
        .to[Seq]
      
      val plainLiteralScalarRestrictions
      : Seq[tables.PlainLiteralScalarRestriction]
      = spark
        .read
        .parquet((dir / "PlainLiteralScalarRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.PlainLiteralScalarRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.PlainLiteralScalarRestrictionTuple2Type)
        .to[Seq]
      
      val reifiedRelationships
      : Seq[tables.ReifiedRelationship]
      = spark
        .read
        .parquet((dir / "ReifiedRelationship.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipInstances
      : Seq[tables.ReifiedRelationshipInstance]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipInstance.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipInstanceRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipInstanceTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipInstanceDomains
      : Seq[tables.ReifiedRelationshipInstanceDomain]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipInstanceDomain.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipInstanceDomainRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipInstanceDomainTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipInstanceRanges
      : Seq[tables.ReifiedRelationshipInstanceRange]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipInstanceRange.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipInstanceRangeRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipInstanceRangeTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipRestrictions
      : Seq[tables.ReifiedRelationshipRestriction]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipRestrictionTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipSpecializationAxioms
      : Seq[tables.ReifiedRelationshipSpecializationAxiom]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipSpecializationAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipSpecializationAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipSpecializationAxiomTuple2Type)
        .to[Seq]
      
      val restrictionScalarDataPropertyValues
      : Seq[tables.RestrictionScalarDataPropertyValue]
      = spark
        .read
        .parquet((dir / "RestrictionScalarDataPropertyValue.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.RestrictionScalarDataPropertyValueRow2Tuple)
        .collect()
        .map(OMLReaders.RestrictionScalarDataPropertyValueTuple2Type)
        .to[Seq]
      
      val restrictionStructuredDataPropertyTuples
      : Seq[tables.RestrictionStructuredDataPropertyTuple]
      = spark
        .read
        .parquet((dir / "RestrictionStructuredDataPropertyTuple.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.RestrictionStructuredDataPropertyTupleRow2Tuple)
        .collect()
        .map(OMLReaders.RestrictionStructuredDataPropertyTupleTuple2Type)
        .to[Seq]
      
      val rootConceptTaxonomyAxioms
      : Seq[tables.RootConceptTaxonomyAxiom]
      = spark
        .read
        .parquet((dir / "RootConceptTaxonomyAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.RootConceptTaxonomyAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.RootConceptTaxonomyAxiomTuple2Type)
        .to[Seq]
      
      val ruleBodySegments
      : Seq[tables.RuleBodySegment]
      = spark
        .read
        .parquet((dir / "RuleBodySegment.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.RuleBodySegmentRow2Tuple)
        .collect()
        .map(OMLReaders.RuleBodySegmentTuple2Type)
        .to[Seq]
      
      val scalars
      : Seq[tables.Scalar]
      = spark
        .read
        .parquet((dir / "Scalar.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ScalarRow2Tuple)
        .collect()
        .map(OMLReaders.ScalarTuple2Type)
        .to[Seq]
      
      val scalarDataProperties
      : Seq[tables.ScalarDataProperty]
      = spark
        .read
        .parquet((dir / "ScalarDataProperty.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ScalarDataPropertyRow2Tuple)
        .collect()
        .map(OMLReaders.ScalarDataPropertyTuple2Type)
        .to[Seq]
      
      val scalarDataPropertyValues
      : Seq[tables.ScalarDataPropertyValue]
      = spark
        .read
        .parquet((dir / "ScalarDataPropertyValue.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ScalarDataPropertyValueRow2Tuple)
        .collect()
        .map(OMLReaders.ScalarDataPropertyValueTuple2Type)
        .to[Seq]
      
      val scalarOneOfLiteralAxioms
      : Seq[tables.ScalarOneOfLiteralAxiom]
      = spark
        .read
        .parquet((dir / "ScalarOneOfLiteralAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ScalarOneOfLiteralAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.ScalarOneOfLiteralAxiomTuple2Type)
        .to[Seq]
      
      val scalarOneOfRestrictions
      : Seq[tables.ScalarOneOfRestriction]
      = spark
        .read
        .parquet((dir / "ScalarOneOfRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ScalarOneOfRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.ScalarOneOfRestrictionTuple2Type)
        .to[Seq]
      
      val segmentPredicates
      : Seq[tables.SegmentPredicate]
      = spark
        .read
        .parquet((dir / "SegmentPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.SegmentPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.SegmentPredicateTuple2Type)
        .to[Seq]
      
      val singletonInstanceScalarDataPropertyValues
      : Seq[tables.SingletonInstanceScalarDataPropertyValue]
      = spark
        .read
        .parquet((dir / "SingletonInstanceScalarDataPropertyValue.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.SingletonInstanceScalarDataPropertyValueRow2Tuple)
        .collect()
        .map(OMLReaders.SingletonInstanceScalarDataPropertyValueTuple2Type)
        .to[Seq]
      
      val singletonInstanceStructuredDataPropertyValues
      : Seq[tables.SingletonInstanceStructuredDataPropertyValue]
      = spark
        .read
        .parquet((dir / "SingletonInstanceStructuredDataPropertyValue.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.SingletonInstanceStructuredDataPropertyValueRow2Tuple)
        .collect()
        .map(OMLReaders.SingletonInstanceStructuredDataPropertyValueTuple2Type)
        .to[Seq]
      
      val specificDisjointConceptAxioms
      : Seq[tables.SpecificDisjointConceptAxiom]
      = spark
        .read
        .parquet((dir / "SpecificDisjointConceptAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.SpecificDisjointConceptAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.SpecificDisjointConceptAxiomTuple2Type)
        .to[Seq]
      
      val stringScalarRestrictions
      : Seq[tables.StringScalarRestriction]
      = spark
        .read
        .parquet((dir / "StringScalarRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.StringScalarRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.StringScalarRestrictionTuple2Type)
        .to[Seq]
      
      val structures
      : Seq[tables.Structure]
      = spark
        .read
        .parquet((dir / "Structure.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.StructureRow2Tuple)
        .collect()
        .map(OMLReaders.StructureTuple2Type)
        .to[Seq]
      
      val structuredDataProperties
      : Seq[tables.StructuredDataProperty]
      = spark
        .read
        .parquet((dir / "StructuredDataProperty.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.StructuredDataPropertyRow2Tuple)
        .collect()
        .map(OMLReaders.StructuredDataPropertyTuple2Type)
        .to[Seq]
      
      val structuredDataPropertyTuples
      : Seq[tables.StructuredDataPropertyTuple]
      = spark
        .read
        .parquet((dir / "StructuredDataPropertyTuple.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.StructuredDataPropertyTupleRow2Tuple)
        .collect()
        .map(OMLReaders.StructuredDataPropertyTupleTuple2Type)
        .to[Seq]
      
      val subDataPropertyOfAxioms
      : Seq[tables.SubDataPropertyOfAxiom]
      = spark
        .read
        .parquet((dir / "SubDataPropertyOfAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.SubDataPropertyOfAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.SubDataPropertyOfAxiomTuple2Type)
        .to[Seq]
      
      val subObjectPropertyOfAxioms
      : Seq[tables.SubObjectPropertyOfAxiom]
      = spark
        .read
        .parquet((dir / "SubObjectPropertyOfAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.SubObjectPropertyOfAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.SubObjectPropertyOfAxiomTuple2Type)
        .to[Seq]
      
      val synonymScalarRestrictions
      : Seq[tables.SynonymScalarRestriction]
      = spark
        .read
        .parquet((dir / "SynonymScalarRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.SynonymScalarRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.SynonymScalarRestrictionTuple2Type)
        .to[Seq]
      
      val terminologyExtensionAxioms
      : Seq[tables.TerminologyExtensionAxiom]
      = spark
        .read
        .parquet((dir / "TerminologyExtensionAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.TerminologyExtensionAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.TerminologyExtensionAxiomTuple2Type)
        .to[Seq]
      
      val terminologyGraphs
      : Seq[tables.TerminologyGraph]
      = spark
        .read
        .parquet((dir / "TerminologyGraph.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.TerminologyGraphRow2Tuple)
        .collect()
        .map(OMLReaders.TerminologyGraphTuple2Type)
        .to[Seq]
      
      val terminologyNestingAxioms
      : Seq[tables.TerminologyNestingAxiom]
      = spark
        .read
        .parquet((dir / "TerminologyNestingAxiom.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.TerminologyNestingAxiomRow2Tuple)
        .collect()
        .map(OMLReaders.TerminologyNestingAxiomTuple2Type)
        .to[Seq]
      
      val timeScalarRestrictions
      : Seq[tables.TimeScalarRestriction]
      = spark
        .read
        .parquet((dir / "TimeScalarRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.TimeScalarRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.TimeScalarRestrictionTuple2Type)
        .to[Seq]
      
      val unreifiedRelationships
      : Seq[tables.UnreifiedRelationship]
      = spark
        .read
        .parquet((dir / "UnreifiedRelationship.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.UnreifiedRelationshipRow2Tuple)
        .collect()
        .map(OMLReaders.UnreifiedRelationshipTuple2Type)
        .to[Seq]
      
      val unreifiedRelationshipInstanceTuples
      : Seq[tables.UnreifiedRelationshipInstanceTuple]
      = spark
        .read
        .parquet((dir / "UnreifiedRelationshipInstanceTuple.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.UnreifiedRelationshipInstanceTupleRow2Tuple)
        .collect()
        .map(OMLReaders.UnreifiedRelationshipInstanceTupleTuple2Type)
        .to[Seq]

  	  Success(
  	    tables.OMLSpecificationTables(
  	      terminologyGraphs = terminologyGraphs,
  	      bundles = bundles,
  	      descriptionBoxes = descriptionBoxes,
  	      annotationProperties = annotationProperties,
  	      aspects = aspects,
  	      concepts = concepts,
  	      scalars = scalars,
  	      structures = structures,
  	      conceptDesignationTerminologyAxioms = conceptDesignationTerminologyAxioms,
  	      terminologyExtensionAxioms = terminologyExtensionAxioms,
  	      terminologyNestingAxioms = terminologyNestingAxioms,
  	      bundledTerminologyAxioms = bundledTerminologyAxioms,
  	      descriptionBoxExtendsClosedWorldDefinitions = descriptionBoxExtendsClosedWorldDefinitions,
  	      descriptionBoxRefinements = descriptionBoxRefinements,
  	      binaryScalarRestrictions = binaryScalarRestrictions,
  	      iriScalarRestrictions = iriScalarRestrictions,
  	      numericScalarRestrictions = numericScalarRestrictions,
  	      plainLiteralScalarRestrictions = plainLiteralScalarRestrictions,
  	      scalarOneOfRestrictions = scalarOneOfRestrictions,
  	      scalarOneOfLiteralAxioms = scalarOneOfLiteralAxioms,
  	      stringScalarRestrictions = stringScalarRestrictions,
  	      synonymScalarRestrictions = synonymScalarRestrictions,
  	      timeScalarRestrictions = timeScalarRestrictions,
  	      entityScalarDataProperties = entityScalarDataProperties,
  	      entityStructuredDataProperties = entityStructuredDataProperties,
  	      scalarDataProperties = scalarDataProperties,
  	      structuredDataProperties = structuredDataProperties,
  	      reifiedRelationships = reifiedRelationships,
  	      reifiedRelationshipRestrictions = reifiedRelationshipRestrictions,
  	      forwardProperties = forwardProperties,
  	      inverseProperties = inverseProperties,
  	      unreifiedRelationships = unreifiedRelationships,
  	      chainRules = chainRules,
  	      ruleBodySegments = ruleBodySegments,
  	      segmentPredicates = segmentPredicates,
  	      entityExistentialRestrictionAxioms = entityExistentialRestrictionAxioms,
  	      entityUniversalRestrictionAxioms = entityUniversalRestrictionAxioms,
  	      entityScalarDataPropertyExistentialRestrictionAxioms = entityScalarDataPropertyExistentialRestrictionAxioms,
  	      entityScalarDataPropertyParticularRestrictionAxioms = entityScalarDataPropertyParticularRestrictionAxioms,
  	      entityScalarDataPropertyUniversalRestrictionAxioms = entityScalarDataPropertyUniversalRestrictionAxioms,
  	      entityStructuredDataPropertyParticularRestrictionAxioms = entityStructuredDataPropertyParticularRestrictionAxioms,
  	      restrictionStructuredDataPropertyTuples = restrictionStructuredDataPropertyTuples,
  	      restrictionScalarDataPropertyValues = restrictionScalarDataPropertyValues,
  	      aspectSpecializationAxioms = aspectSpecializationAxioms,
  	      conceptSpecializationAxioms = conceptSpecializationAxioms,
  	      reifiedRelationshipSpecializationAxioms = reifiedRelationshipSpecializationAxioms,
  	      subDataPropertyOfAxioms = subDataPropertyOfAxioms,
  	      subObjectPropertyOfAxioms = subObjectPropertyOfAxioms,
  	      rootConceptTaxonomyAxioms = rootConceptTaxonomyAxioms,
  	      anonymousConceptUnionAxioms = anonymousConceptUnionAxioms,
  	      specificDisjointConceptAxioms = specificDisjointConceptAxioms,
  	      conceptInstances = conceptInstances,
  	      reifiedRelationshipInstances = reifiedRelationshipInstances,
  	      reifiedRelationshipInstanceDomains = reifiedRelationshipInstanceDomains,
  	      reifiedRelationshipInstanceRanges = reifiedRelationshipInstanceRanges,
  	      unreifiedRelationshipInstanceTuples = unreifiedRelationshipInstanceTuples,
  	      singletonInstanceStructuredDataPropertyValues = singletonInstanceStructuredDataPropertyValues,
  	      singletonInstanceScalarDataPropertyValues = singletonInstanceScalarDataPropertyValues,
  	      structuredDataPropertyTuples = structuredDataPropertyTuples,
  	      scalarDataPropertyValues = scalarDataPropertyValues,
  	      annotationPropertyValues = annotationPropertyValues,
  	      cardinalityRestrictedAspects = cardinalityRestrictedAspects,
  	      cardinalityRestrictedConcepts = cardinalityRestrictedConcepts,
  	      cardinalityRestrictedReifiedRelationships = cardinalityRestrictedReifiedRelationships,
  	      instanceRelationshipEnumerationRestrictions = instanceRelationshipEnumerationRestrictions,
  	      instanceRelationshipExistentialRangeRestrictions = instanceRelationshipExistentialRangeRestrictions,
  	      instanceRelationshipOneOfRestrictions = instanceRelationshipOneOfRestrictions,
  	      instanceRelationshipUniversalRangeRestrictions = instanceRelationshipUniversalRangeRestrictions,
  	      instanceRelationshipValueRestrictions = instanceRelationshipValueRestrictions
  	    ))
  	}

  implicit val cardinalityRestrictionKindI
  : Injection[tables.CardinalityRestrictionKind, Int]
  = Injection(
  {
  	case tables.MinCardinalityRestriction => 0
  	case tables.MaxCardinalityRestriction => 1
  	case tables.ExactCardinalityRestriction => 2
  },
  {
  	case 0 => tables.MinCardinalityRestriction
  	case 1 => tables.MaxCardinalityRestriction
  	case 2 => tables.ExactCardinalityRestriction
  }
  )
  
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
  
  implicit val annotationPropertiesEncoder
  : ExpressionEncoder[tables.AnnotationProperty]
  = TypedExpressionEncoder[tables.AnnotationProperty]
  
  implicit val annotationPropertyValuesEncoder
  : ExpressionEncoder[tables.AnnotationPropertyValue]
  = TypedExpressionEncoder[tables.AnnotationPropertyValue]
  
  implicit val anonymousConceptUnionAxiomsEncoder
  : ExpressionEncoder[tables.AnonymousConceptUnionAxiom]
  = TypedExpressionEncoder[tables.AnonymousConceptUnionAxiom]
  
  implicit val aspectsEncoder
  : ExpressionEncoder[tables.Aspect]
  = TypedExpressionEncoder[tables.Aspect]
  
  implicit val aspectSpecializationAxiomsEncoder
  : ExpressionEncoder[tables.AspectSpecializationAxiom]
  = TypedExpressionEncoder[tables.AspectSpecializationAxiom]
  
  implicit val binaryScalarRestrictionsEncoder
  : ExpressionEncoder[tables.BinaryScalarRestriction]
  = TypedExpressionEncoder[tables.BinaryScalarRestriction]
  
  implicit val bundlesEncoder
  : ExpressionEncoder[tables.Bundle]
  = TypedExpressionEncoder[tables.Bundle]
  
  implicit val bundledTerminologyAxiomsEncoder
  : ExpressionEncoder[tables.BundledTerminologyAxiom]
  = TypedExpressionEncoder[tables.BundledTerminologyAxiom]
  
  implicit val cardinalityRestrictedAspectsEncoder
  : ExpressionEncoder[tables.CardinalityRestrictedAspect]
  = TypedExpressionEncoder[tables.CardinalityRestrictedAspect]
  
  implicit val cardinalityRestrictedConceptsEncoder
  : ExpressionEncoder[tables.CardinalityRestrictedConcept]
  = TypedExpressionEncoder[tables.CardinalityRestrictedConcept]
  
  implicit val cardinalityRestrictedReifiedRelationshipsEncoder
  : ExpressionEncoder[tables.CardinalityRestrictedReifiedRelationship]
  = TypedExpressionEncoder[tables.CardinalityRestrictedReifiedRelationship]
  
  implicit val chainRulesEncoder
  : ExpressionEncoder[tables.ChainRule]
  = TypedExpressionEncoder[tables.ChainRule]
  
  implicit val conceptsEncoder
  : ExpressionEncoder[tables.Concept]
  = TypedExpressionEncoder[tables.Concept]
  
  implicit val conceptDesignationTerminologyAxiomsEncoder
  : ExpressionEncoder[tables.ConceptDesignationTerminologyAxiom]
  = TypedExpressionEncoder[tables.ConceptDesignationTerminologyAxiom]
  
  implicit val conceptInstancesEncoder
  : ExpressionEncoder[tables.ConceptInstance]
  = TypedExpressionEncoder[tables.ConceptInstance]
  
  implicit val conceptSpecializationAxiomsEncoder
  : ExpressionEncoder[tables.ConceptSpecializationAxiom]
  = TypedExpressionEncoder[tables.ConceptSpecializationAxiom]
  
  implicit val descriptionBoxesEncoder
  : ExpressionEncoder[tables.DescriptionBox]
  = TypedExpressionEncoder[tables.DescriptionBox]
  
  implicit val descriptionBoxExtendsClosedWorldDefinitionsEncoder
  : ExpressionEncoder[tables.DescriptionBoxExtendsClosedWorldDefinitions]
  = TypedExpressionEncoder[tables.DescriptionBoxExtendsClosedWorldDefinitions]
  
  implicit val descriptionBoxRefinementsEncoder
  : ExpressionEncoder[tables.DescriptionBoxRefinement]
  = TypedExpressionEncoder[tables.DescriptionBoxRefinement]
  
  implicit val entityExistentialRestrictionAxiomsEncoder
  : ExpressionEncoder[tables.EntityExistentialRestrictionAxiom]
  = TypedExpressionEncoder[tables.EntityExistentialRestrictionAxiom]
  
  implicit val entityScalarDataPropertiesEncoder
  : ExpressionEncoder[tables.EntityScalarDataProperty]
  = TypedExpressionEncoder[tables.EntityScalarDataProperty]
  
  implicit val entityScalarDataPropertyExistentialRestrictionAxiomsEncoder
  : ExpressionEncoder[tables.EntityScalarDataPropertyExistentialRestrictionAxiom]
  = TypedExpressionEncoder[tables.EntityScalarDataPropertyExistentialRestrictionAxiom]
  
  implicit val entityScalarDataPropertyParticularRestrictionAxiomsEncoder
  : ExpressionEncoder[tables.EntityScalarDataPropertyParticularRestrictionAxiom]
  = TypedExpressionEncoder[tables.EntityScalarDataPropertyParticularRestrictionAxiom]
  
  implicit val entityScalarDataPropertyUniversalRestrictionAxiomsEncoder
  : ExpressionEncoder[tables.EntityScalarDataPropertyUniversalRestrictionAxiom]
  = TypedExpressionEncoder[tables.EntityScalarDataPropertyUniversalRestrictionAxiom]
  
  implicit val entityStructuredDataPropertiesEncoder
  : ExpressionEncoder[tables.EntityStructuredDataProperty]
  = TypedExpressionEncoder[tables.EntityStructuredDataProperty]
  
  implicit val entityStructuredDataPropertyParticularRestrictionAxiomsEncoder
  : ExpressionEncoder[tables.EntityStructuredDataPropertyParticularRestrictionAxiom]
  = TypedExpressionEncoder[tables.EntityStructuredDataPropertyParticularRestrictionAxiom]
  
  implicit val entityUniversalRestrictionAxiomsEncoder
  : ExpressionEncoder[tables.EntityUniversalRestrictionAxiom]
  = TypedExpressionEncoder[tables.EntityUniversalRestrictionAxiom]
  
  implicit val forwardPropertiesEncoder
  : ExpressionEncoder[tables.ForwardProperty]
  = TypedExpressionEncoder[tables.ForwardProperty]
  
  implicit val iriScalarRestrictionsEncoder
  : ExpressionEncoder[tables.IRIScalarRestriction]
  = TypedExpressionEncoder[tables.IRIScalarRestriction]
  
  implicit val instanceRelationshipEnumerationRestrictionsEncoder
  : ExpressionEncoder[tables.InstanceRelationshipEnumerationRestriction]
  = TypedExpressionEncoder[tables.InstanceRelationshipEnumerationRestriction]
  
  implicit val instanceRelationshipExistentialRangeRestrictionsEncoder
  : ExpressionEncoder[tables.InstanceRelationshipExistentialRangeRestriction]
  = TypedExpressionEncoder[tables.InstanceRelationshipExistentialRangeRestriction]
  
  implicit val instanceRelationshipOneOfRestrictionsEncoder
  : ExpressionEncoder[tables.InstanceRelationshipOneOfRestriction]
  = TypedExpressionEncoder[tables.InstanceRelationshipOneOfRestriction]
  
  implicit val instanceRelationshipUniversalRangeRestrictionsEncoder
  : ExpressionEncoder[tables.InstanceRelationshipUniversalRangeRestriction]
  = TypedExpressionEncoder[tables.InstanceRelationshipUniversalRangeRestriction]
  
  implicit val instanceRelationshipValueRestrictionsEncoder
  : ExpressionEncoder[tables.InstanceRelationshipValueRestriction]
  = TypedExpressionEncoder[tables.InstanceRelationshipValueRestriction]
  
  implicit val inversePropertiesEncoder
  : ExpressionEncoder[tables.InverseProperty]
  = TypedExpressionEncoder[tables.InverseProperty]
  
  implicit val numericScalarRestrictionsEncoder
  : ExpressionEncoder[tables.NumericScalarRestriction]
  = TypedExpressionEncoder[tables.NumericScalarRestriction]
  
  implicit val plainLiteralScalarRestrictionsEncoder
  : ExpressionEncoder[tables.PlainLiteralScalarRestriction]
  = TypedExpressionEncoder[tables.PlainLiteralScalarRestriction]
  
  implicit val reifiedRelationshipsEncoder
  : ExpressionEncoder[tables.ReifiedRelationship]
  = TypedExpressionEncoder[tables.ReifiedRelationship]
  
  implicit val reifiedRelationshipInstancesEncoder
  : ExpressionEncoder[tables.ReifiedRelationshipInstance]
  = TypedExpressionEncoder[tables.ReifiedRelationshipInstance]
  
  implicit val reifiedRelationshipInstanceDomainsEncoder
  : ExpressionEncoder[tables.ReifiedRelationshipInstanceDomain]
  = TypedExpressionEncoder[tables.ReifiedRelationshipInstanceDomain]
  
  implicit val reifiedRelationshipInstanceRangesEncoder
  : ExpressionEncoder[tables.ReifiedRelationshipInstanceRange]
  = TypedExpressionEncoder[tables.ReifiedRelationshipInstanceRange]
  
  implicit val reifiedRelationshipRestrictionsEncoder
  : ExpressionEncoder[tables.ReifiedRelationshipRestriction]
  = TypedExpressionEncoder[tables.ReifiedRelationshipRestriction]
  
  implicit val reifiedRelationshipSpecializationAxiomsEncoder
  : ExpressionEncoder[tables.ReifiedRelationshipSpecializationAxiom]
  = TypedExpressionEncoder[tables.ReifiedRelationshipSpecializationAxiom]
  
  implicit val restrictionScalarDataPropertyValuesEncoder
  : ExpressionEncoder[tables.RestrictionScalarDataPropertyValue]
  = TypedExpressionEncoder[tables.RestrictionScalarDataPropertyValue]
  
  implicit val restrictionStructuredDataPropertyTuplesEncoder
  : ExpressionEncoder[tables.RestrictionStructuredDataPropertyTuple]
  = TypedExpressionEncoder[tables.RestrictionStructuredDataPropertyTuple]
  
  implicit val rootConceptTaxonomyAxiomsEncoder
  : ExpressionEncoder[tables.RootConceptTaxonomyAxiom]
  = TypedExpressionEncoder[tables.RootConceptTaxonomyAxiom]
  
  implicit val ruleBodySegmentsEncoder
  : ExpressionEncoder[tables.RuleBodySegment]
  = TypedExpressionEncoder[tables.RuleBodySegment]
  
  implicit val scalarsEncoder
  : ExpressionEncoder[tables.Scalar]
  = TypedExpressionEncoder[tables.Scalar]
  
  implicit val scalarDataPropertiesEncoder
  : ExpressionEncoder[tables.ScalarDataProperty]
  = TypedExpressionEncoder[tables.ScalarDataProperty]
  
  implicit val scalarDataPropertyValuesEncoder
  : ExpressionEncoder[tables.ScalarDataPropertyValue]
  = TypedExpressionEncoder[tables.ScalarDataPropertyValue]
  
  implicit val scalarOneOfLiteralAxiomsEncoder
  : ExpressionEncoder[tables.ScalarOneOfLiteralAxiom]
  = TypedExpressionEncoder[tables.ScalarOneOfLiteralAxiom]
  
  implicit val scalarOneOfRestrictionsEncoder
  : ExpressionEncoder[tables.ScalarOneOfRestriction]
  = TypedExpressionEncoder[tables.ScalarOneOfRestriction]
  
  implicit val segmentPredicatesEncoder
  : ExpressionEncoder[tables.SegmentPredicate]
  = TypedExpressionEncoder[tables.SegmentPredicate]
  
  implicit val singletonInstanceScalarDataPropertyValuesEncoder
  : ExpressionEncoder[tables.SingletonInstanceScalarDataPropertyValue]
  = TypedExpressionEncoder[tables.SingletonInstanceScalarDataPropertyValue]
  
  implicit val singletonInstanceStructuredDataPropertyValuesEncoder
  : ExpressionEncoder[tables.SingletonInstanceStructuredDataPropertyValue]
  = TypedExpressionEncoder[tables.SingletonInstanceStructuredDataPropertyValue]
  
  implicit val specificDisjointConceptAxiomsEncoder
  : ExpressionEncoder[tables.SpecificDisjointConceptAxiom]
  = TypedExpressionEncoder[tables.SpecificDisjointConceptAxiom]
  
  implicit val stringScalarRestrictionsEncoder
  : ExpressionEncoder[tables.StringScalarRestriction]
  = TypedExpressionEncoder[tables.StringScalarRestriction]
  
  implicit val structuresEncoder
  : ExpressionEncoder[tables.Structure]
  = TypedExpressionEncoder[tables.Structure]
  
  implicit val structuredDataPropertiesEncoder
  : ExpressionEncoder[tables.StructuredDataProperty]
  = TypedExpressionEncoder[tables.StructuredDataProperty]
  
  implicit val structuredDataPropertyTuplesEncoder
  : ExpressionEncoder[tables.StructuredDataPropertyTuple]
  = TypedExpressionEncoder[tables.StructuredDataPropertyTuple]
  
  implicit val subDataPropertyOfAxiomsEncoder
  : ExpressionEncoder[tables.SubDataPropertyOfAxiom]
  = TypedExpressionEncoder[tables.SubDataPropertyOfAxiom]
  
  implicit val subObjectPropertyOfAxiomsEncoder
  : ExpressionEncoder[tables.SubObjectPropertyOfAxiom]
  = TypedExpressionEncoder[tables.SubObjectPropertyOfAxiom]
  
  implicit val synonymScalarRestrictionsEncoder
  : ExpressionEncoder[tables.SynonymScalarRestriction]
  = TypedExpressionEncoder[tables.SynonymScalarRestriction]
  
  implicit val terminologyExtensionAxiomsEncoder
  : ExpressionEncoder[tables.TerminologyExtensionAxiom]
  = TypedExpressionEncoder[tables.TerminologyExtensionAxiom]
  
  implicit val terminologyGraphsEncoder
  : ExpressionEncoder[tables.TerminologyGraph]
  = TypedExpressionEncoder[tables.TerminologyGraph]
  
  implicit val terminologyNestingAxiomsEncoder
  : ExpressionEncoder[tables.TerminologyNestingAxiom]
  = TypedExpressionEncoder[tables.TerminologyNestingAxiom]
  
  implicit val timeScalarRestrictionsEncoder
  : ExpressionEncoder[tables.TimeScalarRestriction]
  = TypedExpressionEncoder[tables.TimeScalarRestriction]
  
  implicit val unreifiedRelationshipsEncoder
  : ExpressionEncoder[tables.UnreifiedRelationship]
  = TypedExpressionEncoder[tables.UnreifiedRelationship]
  
  implicit val unreifiedRelationshipInstanceTuplesEncoder
  : ExpressionEncoder[tables.UnreifiedRelationshipInstanceTuple]
  = TypedExpressionEncoder[tables.UnreifiedRelationshipInstanceTuple]
  

  def parquetWriteOMLSpecificationTables
  (t: tables.OMLSpecificationTables,
   dir: Path)
  (implicit spark: SparkSession, sqlContext: SQLContext)
  : Unit
  = {
  	  dir.toIO.mkdirs()

      OMLParquetWriters.writeAnnotationProperties(
        t.annotationProperties,
        (dir / "AnnotationProperty.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeAnnotationPropertyValues(
        t.annotationPropertyValues,
        (dir / "AnnotationPropertyValue.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeAnonymousConceptUnionAxioms(
        t.anonymousConceptUnionAxioms,
        (dir / "AnonymousConceptUnionAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeAspects(
        t.aspects,
        (dir / "Aspect.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeAspectSpecializationAxioms(
        t.aspectSpecializationAxioms,
        (dir / "AspectSpecializationAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeBinaryScalarRestrictions(
        t.binaryScalarRestrictions,
        (dir / "BinaryScalarRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeBundles(
        t.bundles,
        (dir / "Bundle.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeBundledTerminologyAxioms(
        t.bundledTerminologyAxioms,
        (dir / "BundledTerminologyAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeCardinalityRestrictedAspects(
        t.cardinalityRestrictedAspects,
        (dir / "CardinalityRestrictedAspect.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeCardinalityRestrictedConcepts(
        t.cardinalityRestrictedConcepts,
        (dir / "CardinalityRestrictedConcept.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeCardinalityRestrictedReifiedRelationships(
        t.cardinalityRestrictedReifiedRelationships,
        (dir / "CardinalityRestrictedReifiedRelationship.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeChainRules(
        t.chainRules,
        (dir / "ChainRule.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeConcepts(
        t.concepts,
        (dir / "Concept.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeConceptDesignationTerminologyAxioms(
        t.conceptDesignationTerminologyAxioms,
        (dir / "ConceptDesignationTerminologyAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeConceptInstances(
        t.conceptInstances,
        (dir / "ConceptInstance.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeConceptSpecializationAxioms(
        t.conceptSpecializationAxioms,
        (dir / "ConceptSpecializationAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeDescriptionBoxes(
        t.descriptionBoxes,
        (dir / "DescriptionBox.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeDescriptionBoxExtendsClosedWorldDefinitions(
        t.descriptionBoxExtendsClosedWorldDefinitions,
        (dir / "DescriptionBoxExtendsClosedWorldDefinitions.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeDescriptionBoxRefinements(
        t.descriptionBoxRefinements,
        (dir / "DescriptionBoxRefinement.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeEntityExistentialRestrictionAxioms(
        t.entityExistentialRestrictionAxioms,
        (dir / "EntityExistentialRestrictionAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeEntityScalarDataProperties(
        t.entityScalarDataProperties,
        (dir / "EntityScalarDataProperty.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeEntityScalarDataPropertyExistentialRestrictionAxioms(
        t.entityScalarDataPropertyExistentialRestrictionAxioms,
        (dir / "EntityScalarDataPropertyExistentialRestrictionAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeEntityScalarDataPropertyParticularRestrictionAxioms(
        t.entityScalarDataPropertyParticularRestrictionAxioms,
        (dir / "EntityScalarDataPropertyParticularRestrictionAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeEntityScalarDataPropertyUniversalRestrictionAxioms(
        t.entityScalarDataPropertyUniversalRestrictionAxioms,
        (dir / "EntityScalarDataPropertyUniversalRestrictionAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeEntityStructuredDataProperties(
        t.entityStructuredDataProperties,
        (dir / "EntityStructuredDataProperty.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeEntityStructuredDataPropertyParticularRestrictionAxioms(
        t.entityStructuredDataPropertyParticularRestrictionAxioms,
        (dir / "EntityStructuredDataPropertyParticularRestrictionAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeEntityUniversalRestrictionAxioms(
        t.entityUniversalRestrictionAxioms,
        (dir / "EntityUniversalRestrictionAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeForwardProperties(
        t.forwardProperties,
        (dir / "ForwardProperty.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeIRIScalarRestrictions(
        t.iriScalarRestrictions,
        (dir / "IRIScalarRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeInstanceRelationshipEnumerationRestrictions(
        t.instanceRelationshipEnumerationRestrictions,
        (dir / "InstanceRelationshipEnumerationRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeInstanceRelationshipExistentialRangeRestrictions(
        t.instanceRelationshipExistentialRangeRestrictions,
        (dir / "InstanceRelationshipExistentialRangeRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeInstanceRelationshipOneOfRestrictions(
        t.instanceRelationshipOneOfRestrictions,
        (dir / "InstanceRelationshipOneOfRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeInstanceRelationshipUniversalRangeRestrictions(
        t.instanceRelationshipUniversalRangeRestrictions,
        (dir / "InstanceRelationshipUniversalRangeRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeInstanceRelationshipValueRestrictions(
        t.instanceRelationshipValueRestrictions,
        (dir / "InstanceRelationshipValueRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeInverseProperties(
        t.inverseProperties,
        (dir / "InverseProperty.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeNumericScalarRestrictions(
        t.numericScalarRestrictions,
        (dir / "NumericScalarRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writePlainLiteralScalarRestrictions(
        t.plainLiteralScalarRestrictions,
        (dir / "PlainLiteralScalarRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeReifiedRelationships(
        t.reifiedRelationships,
        (dir / "ReifiedRelationship.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeReifiedRelationshipInstances(
        t.reifiedRelationshipInstances,
        (dir / "ReifiedRelationshipInstance.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeReifiedRelationshipInstanceDomains(
        t.reifiedRelationshipInstanceDomains,
        (dir / "ReifiedRelationshipInstanceDomain.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeReifiedRelationshipInstanceRanges(
        t.reifiedRelationshipInstanceRanges,
        (dir / "ReifiedRelationshipInstanceRange.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeReifiedRelationshipRestrictions(
        t.reifiedRelationshipRestrictions,
        (dir / "ReifiedRelationshipRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeReifiedRelationshipSpecializationAxioms(
        t.reifiedRelationshipSpecializationAxioms,
        (dir / "ReifiedRelationshipSpecializationAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeRestrictionScalarDataPropertyValues(
        t.restrictionScalarDataPropertyValues,
        (dir / "RestrictionScalarDataPropertyValue.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeRestrictionStructuredDataPropertyTuples(
        t.restrictionStructuredDataPropertyTuples,
        (dir / "RestrictionStructuredDataPropertyTuple.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeRootConceptTaxonomyAxioms(
        t.rootConceptTaxonomyAxioms,
        (dir / "RootConceptTaxonomyAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeRuleBodySegments(
        t.ruleBodySegments,
        (dir / "RuleBodySegment.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeScalars(
        t.scalars,
        (dir / "Scalar.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeScalarDataProperties(
        t.scalarDataProperties,
        (dir / "ScalarDataProperty.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeScalarDataPropertyValues(
        t.scalarDataPropertyValues,
        (dir / "ScalarDataPropertyValue.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeScalarOneOfLiteralAxioms(
        t.scalarOneOfLiteralAxioms,
        (dir / "ScalarOneOfLiteralAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeScalarOneOfRestrictions(
        t.scalarOneOfRestrictions,
        (dir / "ScalarOneOfRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeSegmentPredicates(
        t.segmentPredicates,
        (dir / "SegmentPredicate.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeSingletonInstanceScalarDataPropertyValues(
        t.singletonInstanceScalarDataPropertyValues,
        (dir / "SingletonInstanceScalarDataPropertyValue.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeSingletonInstanceStructuredDataPropertyValues(
        t.singletonInstanceStructuredDataPropertyValues,
        (dir / "SingletonInstanceStructuredDataPropertyValue.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeSpecificDisjointConceptAxioms(
        t.specificDisjointConceptAxioms,
        (dir / "SpecificDisjointConceptAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeStringScalarRestrictions(
        t.stringScalarRestrictions,
        (dir / "StringScalarRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeStructures(
        t.structures,
        (dir / "Structure.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeStructuredDataProperties(
        t.structuredDataProperties,
        (dir / "StructuredDataProperty.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeStructuredDataPropertyTuples(
        t.structuredDataPropertyTuples,
        (dir / "StructuredDataPropertyTuple.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeSubDataPropertyOfAxioms(
        t.subDataPropertyOfAxioms,
        (dir / "SubDataPropertyOfAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeSubObjectPropertyOfAxioms(
        t.subObjectPropertyOfAxioms,
        (dir / "SubObjectPropertyOfAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeSynonymScalarRestrictions(
        t.synonymScalarRestrictions,
        (dir / "SynonymScalarRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeTerminologyExtensionAxioms(
        t.terminologyExtensionAxioms,
        (dir / "TerminologyExtensionAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeTerminologyGraphs(
        t.terminologyGraphs,
        (dir / "TerminologyGraph.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeTerminologyNestingAxioms(
        t.terminologyNestingAxioms,
        (dir / "TerminologyNestingAxiom.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeTimeScalarRestrictions(
        t.timeScalarRestrictions,
        (dir / "TimeScalarRestriction.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeUnreifiedRelationships(
        t.unreifiedRelationships,
        (dir / "UnreifiedRelationship.parquet").toIO.getAbsolutePath)

      OMLParquetWriters.writeUnreifiedRelationshipInstanceTuples(
        t.unreifiedRelationshipInstanceTuples,
        (dir / "UnreifiedRelationshipInstanceTuple.parquet").toIO.getAbsolutePath)

  	}

  def sqlReadOMLSpecificationTables
  (url: String,
   props: Properties)
  (implicit spark: SparkSession, sqlContext: SQLContext)
  : Try[tables.OMLSpecificationTables]
  = nonFatalCatch[Try[tables.OMLSpecificationTables]]
    .withApply {
      (cause: java.lang.Throwable) =>
        Failure(cause)
    }
    .apply {
    	
      import spark.implicits._
      import scala.Predef.refArrayOps
	  
      val annotationProperties
      : Seq[tables.AnnotationProperty]
      = spark
        .read
        .jdbc(url, "OML.AnnotProps", props)
        .map(OMLReaders.AnnotationPropertySQL2Tuple)
        .collect()
        .map(OMLReaders.AnnotationPropertyTuple2Type)
        .to[Seq]
      
      val annotationPropertyValues
      : Seq[tables.AnnotationPropertyValue]
      = spark
        .read
        .jdbc(url, "OML.AnnotPropVals", props)
        .map(OMLReaders.AnnotationPropertyValueSQL2Tuple)
        .collect()
        .map(OMLReaders.AnnotationPropertyValueTuple2Type)
        .to[Seq]
      
      val anonymousConceptUnionAxioms
      : Seq[tables.AnonymousConceptUnionAxiom]
      = spark
        .read
        .jdbc(url, "OML.AnonymousCUnionAx", props)
        .map(OMLReaders.AnonymousConceptUnionAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.AnonymousConceptUnionAxiomTuple2Type)
        .to[Seq]
      
      val aspects
      : Seq[tables.Aspect]
      = spark
        .read
        .jdbc(url, "OML.As", props)
        .map(OMLReaders.AspectSQL2Tuple)
        .collect()
        .map(OMLReaders.AspectTuple2Type)
        .to[Seq]
      
      val aspectSpecializationAxioms
      : Seq[tables.AspectSpecializationAxiom]
      = spark
        .read
        .jdbc(url, "OML.AspectSpeAx", props)
        .map(OMLReaders.AspectSpecializationAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.AspectSpecializationAxiomTuple2Type)
        .to[Seq]
      
      val binaryScalarRestrictions
      : Seq[tables.BinaryScalarRestriction]
      = spark
        .read
        .jdbc(url, "OML.BinScRs", props)
        .map(OMLReaders.BinaryScalarRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.BinaryScalarRestrictionTuple2Type)
        .to[Seq]
      
      val bundles
      : Seq[tables.Bundle]
      = spark
        .read
        .jdbc(url, "OML.Bdls", props)
        .map(OMLReaders.BundleSQL2Tuple)
        .collect()
        .map(OMLReaders.BundleTuple2Type)
        .to[Seq]
      
      val bundledTerminologyAxioms
      : Seq[tables.BundledTerminologyAxiom]
      = spark
        .read
        .jdbc(url, "OML.BdldTlgyAx", props)
        .map(OMLReaders.BundledTerminologyAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.BundledTerminologyAxiomTuple2Type)
        .to[Seq]
      
      val cardinalityRestrictedAspects
      : Seq[tables.CardinalityRestrictedAspect]
      = spark
        .read
        .jdbc(url, "OML.CardinalityRestAs", props)
        .map(OMLReaders.CardinalityRestrictedAspectSQL2Tuple)
        .collect()
        .map(OMLReaders.CardinalityRestrictedAspectTuple2Type)
        .to[Seq]
      
      val cardinalityRestrictedConcepts
      : Seq[tables.CardinalityRestrictedConcept]
      = spark
        .read
        .jdbc(url, "OML.CardinalityRestCs", props)
        .map(OMLReaders.CardinalityRestrictedConceptSQL2Tuple)
        .collect()
        .map(OMLReaders.CardinalityRestrictedConceptTuple2Type)
        .to[Seq]
      
      val cardinalityRestrictedReifiedRelationships
      : Seq[tables.CardinalityRestrictedReifiedRelationship]
      = spark
        .read
        .jdbc(url, "OML.CardinalityRestRRs", props)
        .map(OMLReaders.CardinalityRestrictedReifiedRelationshipSQL2Tuple)
        .collect()
        .map(OMLReaders.CardinalityRestrictedReifiedRelationshipTuple2Type)
        .to[Seq]
      
      val chainRules
      : Seq[tables.ChainRule]
      = spark
        .read
        .jdbc(url, "OML.CR", props)
        .map(OMLReaders.ChainRuleSQL2Tuple)
        .collect()
        .map(OMLReaders.ChainRuleTuple2Type)
        .to[Seq]
      
      val concepts
      : Seq[tables.Concept]
      = spark
        .read
        .jdbc(url, "OML.Cs", props)
        .map(OMLReaders.ConceptSQL2Tuple)
        .collect()
        .map(OMLReaders.ConceptTuple2Type)
        .to[Seq]
      
      val conceptDesignationTerminologyAxioms
      : Seq[tables.ConceptDesignationTerminologyAxiom]
      = spark
        .read
        .jdbc(url, "OML.CDesTlgyAx", props)
        .map(OMLReaders.ConceptDesignationTerminologyAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.ConceptDesignationTerminologyAxiomTuple2Type)
        .to[Seq]
      
      val conceptInstances
      : Seq[tables.ConceptInstance]
      = spark
        .read
        .jdbc(url, "OML.CIs", props)
        .map(OMLReaders.ConceptInstanceSQL2Tuple)
        .collect()
        .map(OMLReaders.ConceptInstanceTuple2Type)
        .to[Seq]
      
      val conceptSpecializationAxioms
      : Seq[tables.ConceptSpecializationAxiom]
      = spark
        .read
        .jdbc(url, "OML.CSpeAx", props)
        .map(OMLReaders.ConceptSpecializationAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.ConceptSpecializationAxiomTuple2Type)
        .to[Seq]
      
      val descriptionBoxes
      : Seq[tables.DescriptionBox]
      = spark
        .read
        .jdbc(url, "OML.DBoxes", props)
        .map(OMLReaders.DescriptionBoxSQL2Tuple)
        .collect()
        .map(OMLReaders.DescriptionBoxTuple2Type)
        .to[Seq]
      
      val descriptionBoxExtendsClosedWorldDefinitions
      : Seq[tables.DescriptionBoxExtendsClosedWorldDefinitions]
      = spark
        .read
        .jdbc(url, "OML.DBoxExtCWDef", props)
        .map(OMLReaders.DescriptionBoxExtendsClosedWorldDefinitionsSQL2Tuple)
        .collect()
        .map(OMLReaders.DescriptionBoxExtendsClosedWorldDefinitionsTuple2Type)
        .to[Seq]
      
      val descriptionBoxRefinements
      : Seq[tables.DescriptionBoxRefinement]
      = spark
        .read
        .jdbc(url, "OML.DBoxRfns", props)
        .map(OMLReaders.DescriptionBoxRefinementSQL2Tuple)
        .collect()
        .map(OMLReaders.DescriptionBoxRefinementTuple2Type)
        .to[Seq]
      
      val entityExistentialRestrictionAxioms
      : Seq[tables.EntityExistentialRestrictionAxiom]
      = spark
        .read
        .jdbc(url, "OML.EExRAx", props)
        .map(OMLReaders.EntityExistentialRestrictionAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.EntityExistentialRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val entityScalarDataProperties
      : Seq[tables.EntityScalarDataProperty]
      = spark
        .read
        .jdbc(url, "OML.EScPs", props)
        .map(OMLReaders.EntityScalarDataPropertySQL2Tuple)
        .collect()
        .map(OMLReaders.EntityScalarDataPropertyTuple2Type)
        .to[Seq]
      
      val entityScalarDataPropertyExistentialRestrictionAxioms
      : Seq[tables.EntityScalarDataPropertyExistentialRestrictionAxiom]
      = spark
        .read
        .jdbc(url, "OML.EScPExRAx", props)
        .map(OMLReaders.EntityScalarDataPropertyExistentialRestrictionAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.EntityScalarDataPropertyExistentialRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val entityScalarDataPropertyParticularRestrictionAxioms
      : Seq[tables.EntityScalarDataPropertyParticularRestrictionAxiom]
      = spark
        .read
        .jdbc(url, "OML.EScPPtrRAx", props)
        .map(OMLReaders.EntityScalarDataPropertyParticularRestrictionAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.EntityScalarDataPropertyParticularRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val entityScalarDataPropertyUniversalRestrictionAxioms
      : Seq[tables.EntityScalarDataPropertyUniversalRestrictionAxiom]
      = spark
        .read
        .jdbc(url, "OML.EScPUxRAx", props)
        .map(OMLReaders.EntityScalarDataPropertyUniversalRestrictionAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.EntityScalarDataPropertyUniversalRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val entityStructuredDataProperties
      : Seq[tables.EntityStructuredDataProperty]
      = spark
        .read
        .jdbc(url, "OML.EStPs", props)
        .map(OMLReaders.EntityStructuredDataPropertySQL2Tuple)
        .collect()
        .map(OMLReaders.EntityStructuredDataPropertyTuple2Type)
        .to[Seq]
      
      val entityStructuredDataPropertyParticularRestrictionAxioms
      : Seq[tables.EntityStructuredDataPropertyParticularRestrictionAxiom]
      = spark
        .read
        .jdbc(url, "OML.EStPPtrRAx", props)
        .map(OMLReaders.EntityStructuredDataPropertyParticularRestrictionAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.EntityStructuredDataPropertyParticularRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val entityUniversalRestrictionAxioms
      : Seq[tables.EntityUniversalRestrictionAxiom]
      = spark
        .read
        .jdbc(url, "OML.EUxRAx", props)
        .map(OMLReaders.EntityUniversalRestrictionAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.EntityUniversalRestrictionAxiomTuple2Type)
        .to[Seq]
      
      val forwardProperties
      : Seq[tables.ForwardProperty]
      = spark
        .read
        .jdbc(url, "OML.FwdProps", props)
        .map(OMLReaders.ForwardPropertySQL2Tuple)
        .collect()
        .map(OMLReaders.ForwardPropertyTuple2Type)
        .to[Seq]
      
      val iriScalarRestrictions
      : Seq[tables.IRIScalarRestriction]
      = spark
        .read
        .jdbc(url, "OML.IRIScRs", props)
        .map(OMLReaders.IRIScalarRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.IRIScalarRestrictionTuple2Type)
        .to[Seq]
      
      val instanceRelationshipEnumerationRestrictions
      : Seq[tables.InstanceRelationshipEnumerationRestriction]
      = spark
        .read
        .jdbc(url, "OML.IRelEnumerationRs", props)
        .map(OMLReaders.InstanceRelationshipEnumerationRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.InstanceRelationshipEnumerationRestrictionTuple2Type)
        .to[Seq]
      
      val instanceRelationshipExistentialRangeRestrictions
      : Seq[tables.InstanceRelationshipExistentialRangeRestriction]
      = spark
        .read
        .jdbc(url, "OML.IRelExRangeRs", props)
        .map(OMLReaders.InstanceRelationshipExistentialRangeRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.InstanceRelationshipExistentialRangeRestrictionTuple2Type)
        .to[Seq]
      
      val instanceRelationshipOneOfRestrictions
      : Seq[tables.InstanceRelationshipOneOfRestriction]
      = spark
        .read
        .jdbc(url, "OML.IRelOneOfRs", props)
        .map(OMLReaders.InstanceRelationshipOneOfRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.InstanceRelationshipOneOfRestrictionTuple2Type)
        .to[Seq]
      
      val instanceRelationshipUniversalRangeRestrictions
      : Seq[tables.InstanceRelationshipUniversalRangeRestriction]
      = spark
        .read
        .jdbc(url, "OML.IRelUxRangeRs", props)
        .map(OMLReaders.InstanceRelationshipUniversalRangeRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.InstanceRelationshipUniversalRangeRestrictionTuple2Type)
        .to[Seq]
      
      val instanceRelationshipValueRestrictions
      : Seq[tables.InstanceRelationshipValueRestriction]
      = spark
        .read
        .jdbc(url, "OML.IRelValRs", props)
        .map(OMLReaders.InstanceRelationshipValueRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.InstanceRelationshipValueRestrictionTuple2Type)
        .to[Seq]
      
      val inverseProperties
      : Seq[tables.InverseProperty]
      = spark
        .read
        .jdbc(url, "OML.InvProps", props)
        .map(OMLReaders.InversePropertySQL2Tuple)
        .collect()
        .map(OMLReaders.InversePropertyTuple2Type)
        .to[Seq]
      
      val numericScalarRestrictions
      : Seq[tables.NumericScalarRestriction]
      = spark
        .read
        .jdbc(url, "OML.NumericScRs", props)
        .map(OMLReaders.NumericScalarRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.NumericScalarRestrictionTuple2Type)
        .to[Seq]
      
      val plainLiteralScalarRestrictions
      : Seq[tables.PlainLiteralScalarRestriction]
      = spark
        .read
        .jdbc(url, "OML.PlainLitScRs", props)
        .map(OMLReaders.PlainLiteralScalarRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.PlainLiteralScalarRestrictionTuple2Type)
        .to[Seq]
      
      val reifiedRelationships
      : Seq[tables.ReifiedRelationship]
      = spark
        .read
        .jdbc(url, "OML.RRs", props)
        .map(OMLReaders.ReifiedRelationshipSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipInstances
      : Seq[tables.ReifiedRelationshipInstance]
      = spark
        .read
        .jdbc(url, "OML.RRIs", props)
        .map(OMLReaders.ReifiedRelationshipInstanceSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipInstanceTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipInstanceDomains
      : Seq[tables.ReifiedRelationshipInstanceDomain]
      = spark
        .read
        .jdbc(url, "OML.RRIDomains", props)
        .map(OMLReaders.ReifiedRelationshipInstanceDomainSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipInstanceDomainTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipInstanceRanges
      : Seq[tables.ReifiedRelationshipInstanceRange]
      = spark
        .read
        .jdbc(url, "OML.RRIRanges", props)
        .map(OMLReaders.ReifiedRelationshipInstanceRangeSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipInstanceRangeTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipRestrictions
      : Seq[tables.ReifiedRelationshipRestriction]
      = spark
        .read
        .jdbc(url, "OML.RRRs", props)
        .map(OMLReaders.ReifiedRelationshipRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipRestrictionTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipSpecializationAxioms
      : Seq[tables.ReifiedRelationshipSpecializationAxiom]
      = spark
        .read
        .jdbc(url, "OML.RRSpeAx", props)
        .map(OMLReaders.ReifiedRelationshipSpecializationAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipSpecializationAxiomTuple2Type)
        .to[Seq]
      
      val restrictionScalarDataPropertyValues
      : Seq[tables.RestrictionScalarDataPropertyValue]
      = spark
        .read
        .jdbc(url, "OML.RScPVals", props)
        .map(OMLReaders.RestrictionScalarDataPropertyValueSQL2Tuple)
        .collect()
        .map(OMLReaders.RestrictionScalarDataPropertyValueTuple2Type)
        .to[Seq]
      
      val restrictionStructuredDataPropertyTuples
      : Seq[tables.RestrictionStructuredDataPropertyTuple]
      = spark
        .read
        .jdbc(url, "OML.RStPTs", props)
        .map(OMLReaders.RestrictionStructuredDataPropertyTupleSQL2Tuple)
        .collect()
        .map(OMLReaders.RestrictionStructuredDataPropertyTupleTuple2Type)
        .to[Seq]
      
      val rootConceptTaxonomyAxioms
      : Seq[tables.RootConceptTaxonomyAxiom]
      = spark
        .read
        .jdbc(url, "OML.RootCTaxonomyAx", props)
        .map(OMLReaders.RootConceptTaxonomyAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.RootConceptTaxonomyAxiomTuple2Type)
        .to[Seq]
      
      val ruleBodySegments
      : Seq[tables.RuleBodySegment]
      = spark
        .read
        .jdbc(url, "OML.RuleBodySegs", props)
        .map(OMLReaders.RuleBodySegmentSQL2Tuple)
        .collect()
        .map(OMLReaders.RuleBodySegmentTuple2Type)
        .to[Seq]
      
      val scalars
      : Seq[tables.Scalar]
      = spark
        .read
        .jdbc(url, "OML.Scs", props)
        .map(OMLReaders.ScalarSQL2Tuple)
        .collect()
        .map(OMLReaders.ScalarTuple2Type)
        .to[Seq]
      
      val scalarDataProperties
      : Seq[tables.ScalarDataProperty]
      = spark
        .read
        .jdbc(url, "OML.ScPs", props)
        .map(OMLReaders.ScalarDataPropertySQL2Tuple)
        .collect()
        .map(OMLReaders.ScalarDataPropertyTuple2Type)
        .to[Seq]
      
      val scalarDataPropertyValues
      : Seq[tables.ScalarDataPropertyValue]
      = spark
        .read
        .jdbc(url, "OML.ScPVals", props)
        .map(OMLReaders.ScalarDataPropertyValueSQL2Tuple)
        .collect()
        .map(OMLReaders.ScalarDataPropertyValueTuple2Type)
        .to[Seq]
      
      val scalarOneOfLiteralAxioms
      : Seq[tables.ScalarOneOfLiteralAxiom]
      = spark
        .read
        .jdbc(url, "OML.ScOneOfLitAx", props)
        .map(OMLReaders.ScalarOneOfLiteralAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.ScalarOneOfLiteralAxiomTuple2Type)
        .to[Seq]
      
      val scalarOneOfRestrictions
      : Seq[tables.ScalarOneOfRestriction]
      = spark
        .read
        .jdbc(url, "OML.ScOneOfRs", props)
        .map(OMLReaders.ScalarOneOfRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.ScalarOneOfRestrictionTuple2Type)
        .to[Seq]
      
      val segmentPredicates
      : Seq[tables.SegmentPredicate]
      = spark
        .read
        .jdbc(url, "OML.SegP", props)
        .map(OMLReaders.SegmentPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.SegmentPredicateTuple2Type)
        .to[Seq]
      
      val singletonInstanceScalarDataPropertyValues
      : Seq[tables.SingletonInstanceScalarDataPropertyValue]
      = spark
        .read
        .jdbc(url, "OML.S1IScPVals", props)
        .map(OMLReaders.SingletonInstanceScalarDataPropertyValueSQL2Tuple)
        .collect()
        .map(OMLReaders.SingletonInstanceScalarDataPropertyValueTuple2Type)
        .to[Seq]
      
      val singletonInstanceStructuredDataPropertyValues
      : Seq[tables.SingletonInstanceStructuredDataPropertyValue]
      = spark
        .read
        .jdbc(url, "OML.S1IStPVals", props)
        .map(OMLReaders.SingletonInstanceStructuredDataPropertyValueSQL2Tuple)
        .collect()
        .map(OMLReaders.SingletonInstanceStructuredDataPropertyValueTuple2Type)
        .to[Seq]
      
      val specificDisjointConceptAxioms
      : Seq[tables.SpecificDisjointConceptAxiom]
      = spark
        .read
        .jdbc(url, "OML.SpeDsjtCAx", props)
        .map(OMLReaders.SpecificDisjointConceptAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.SpecificDisjointConceptAxiomTuple2Type)
        .to[Seq]
      
      val stringScalarRestrictions
      : Seq[tables.StringScalarRestriction]
      = spark
        .read
        .jdbc(url, "OML.StringScRs", props)
        .map(OMLReaders.StringScalarRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.StringScalarRestrictionTuple2Type)
        .to[Seq]
      
      val structures
      : Seq[tables.Structure]
      = spark
        .read
        .jdbc(url, "OML.Sts", props)
        .map(OMLReaders.StructureSQL2Tuple)
        .collect()
        .map(OMLReaders.StructureTuple2Type)
        .to[Seq]
      
      val structuredDataProperties
      : Seq[tables.StructuredDataProperty]
      = spark
        .read
        .jdbc(url, "OML.StPs", props)
        .map(OMLReaders.StructuredDataPropertySQL2Tuple)
        .collect()
        .map(OMLReaders.StructuredDataPropertyTuple2Type)
        .to[Seq]
      
      val structuredDataPropertyTuples
      : Seq[tables.StructuredDataPropertyTuple]
      = spark
        .read
        .jdbc(url, "OML.StPTs", props)
        .map(OMLReaders.StructuredDataPropertyTupleSQL2Tuple)
        .collect()
        .map(OMLReaders.StructuredDataPropertyTupleTuple2Type)
        .to[Seq]
      
      val subDataPropertyOfAxioms
      : Seq[tables.SubDataPropertyOfAxiom]
      = spark
        .read
        .jdbc(url, "OML.SubDataPropOfAx", props)
        .map(OMLReaders.SubDataPropertyOfAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.SubDataPropertyOfAxiomTuple2Type)
        .to[Seq]
      
      val subObjectPropertyOfAxioms
      : Seq[tables.SubObjectPropertyOfAxiom]
      = spark
        .read
        .jdbc(url, "OML.SubObjectPropOfAx", props)
        .map(OMLReaders.SubObjectPropertyOfAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.SubObjectPropertyOfAxiomTuple2Type)
        .to[Seq]
      
      val synonymScalarRestrictions
      : Seq[tables.SynonymScalarRestriction]
      = spark
        .read
        .jdbc(url, "OML.SynonymScRs", props)
        .map(OMLReaders.SynonymScalarRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.SynonymScalarRestrictionTuple2Type)
        .to[Seq]
      
      val terminologyExtensionAxioms
      : Seq[tables.TerminologyExtensionAxiom]
      = spark
        .read
        .jdbc(url, "OML.TlgyExtensionAx", props)
        .map(OMLReaders.TerminologyExtensionAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.TerminologyExtensionAxiomTuple2Type)
        .to[Seq]
      
      val terminologyGraphs
      : Seq[tables.TerminologyGraph]
      = spark
        .read
        .jdbc(url, "OML.TlgyGraphs", props)
        .map(OMLReaders.TerminologyGraphSQL2Tuple)
        .collect()
        .map(OMLReaders.TerminologyGraphTuple2Type)
        .to[Seq]
      
      val terminologyNestingAxioms
      : Seq[tables.TerminologyNestingAxiom]
      = spark
        .read
        .jdbc(url, "OML.TlgyNestingAx", props)
        .map(OMLReaders.TerminologyNestingAxiomSQL2Tuple)
        .collect()
        .map(OMLReaders.TerminologyNestingAxiomTuple2Type)
        .to[Seq]
      
      val timeScalarRestrictions
      : Seq[tables.TimeScalarRestriction]
      = spark
        .read
        .jdbc(url, "OML.TimeScRs", props)
        .map(OMLReaders.TimeScalarRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.TimeScalarRestrictionTuple2Type)
        .to[Seq]
      
      val unreifiedRelationships
      : Seq[tables.UnreifiedRelationship]
      = spark
        .read
        .jdbc(url, "OML.URs", props)
        .map(OMLReaders.UnreifiedRelationshipSQL2Tuple)
        .collect()
        .map(OMLReaders.UnreifiedRelationshipTuple2Type)
        .to[Seq]
      
      val unreifiedRelationshipInstanceTuples
      : Seq[tables.UnreifiedRelationshipInstanceTuple]
      = spark
        .read
        .jdbc(url, "OML.URITs", props)
        .map(OMLReaders.UnreifiedRelationshipInstanceTupleSQL2Tuple)
        .collect()
        .map(OMLReaders.UnreifiedRelationshipInstanceTupleTuple2Type)
        .to[Seq]

  	  Success(
  	    tables.OMLSpecificationTables(
  	      terminologyGraphs = terminologyGraphs,
  	      bundles = bundles,
  	      descriptionBoxes = descriptionBoxes,
  	      annotationProperties = annotationProperties,
  	      aspects = aspects,
  	      concepts = concepts,
  	      scalars = scalars,
  	      structures = structures,
  	      conceptDesignationTerminologyAxioms = conceptDesignationTerminologyAxioms,
  	      terminologyExtensionAxioms = terminologyExtensionAxioms,
  	      terminologyNestingAxioms = terminologyNestingAxioms,
  	      bundledTerminologyAxioms = bundledTerminologyAxioms,
  	      descriptionBoxExtendsClosedWorldDefinitions = descriptionBoxExtendsClosedWorldDefinitions,
  	      descriptionBoxRefinements = descriptionBoxRefinements,
  	      binaryScalarRestrictions = binaryScalarRestrictions,
  	      iriScalarRestrictions = iriScalarRestrictions,
  	      numericScalarRestrictions = numericScalarRestrictions,
  	      plainLiteralScalarRestrictions = plainLiteralScalarRestrictions,
  	      scalarOneOfRestrictions = scalarOneOfRestrictions,
  	      scalarOneOfLiteralAxioms = scalarOneOfLiteralAxioms,
  	      stringScalarRestrictions = stringScalarRestrictions,
  	      synonymScalarRestrictions = synonymScalarRestrictions,
  	      timeScalarRestrictions = timeScalarRestrictions,
  	      entityScalarDataProperties = entityScalarDataProperties,
  	      entityStructuredDataProperties = entityStructuredDataProperties,
  	      scalarDataProperties = scalarDataProperties,
  	      structuredDataProperties = structuredDataProperties,
  	      reifiedRelationships = reifiedRelationships,
  	      reifiedRelationshipRestrictions = reifiedRelationshipRestrictions,
  	      forwardProperties = forwardProperties,
  	      inverseProperties = inverseProperties,
  	      unreifiedRelationships = unreifiedRelationships,
  	      chainRules = chainRules,
  	      ruleBodySegments = ruleBodySegments,
  	      segmentPredicates = segmentPredicates,
  	      entityExistentialRestrictionAxioms = entityExistentialRestrictionAxioms,
  	      entityUniversalRestrictionAxioms = entityUniversalRestrictionAxioms,
  	      entityScalarDataPropertyExistentialRestrictionAxioms = entityScalarDataPropertyExistentialRestrictionAxioms,
  	      entityScalarDataPropertyParticularRestrictionAxioms = entityScalarDataPropertyParticularRestrictionAxioms,
  	      entityScalarDataPropertyUniversalRestrictionAxioms = entityScalarDataPropertyUniversalRestrictionAxioms,
  	      entityStructuredDataPropertyParticularRestrictionAxioms = entityStructuredDataPropertyParticularRestrictionAxioms,
  	      restrictionStructuredDataPropertyTuples = restrictionStructuredDataPropertyTuples,
  	      restrictionScalarDataPropertyValues = restrictionScalarDataPropertyValues,
  	      aspectSpecializationAxioms = aspectSpecializationAxioms,
  	      conceptSpecializationAxioms = conceptSpecializationAxioms,
  	      reifiedRelationshipSpecializationAxioms = reifiedRelationshipSpecializationAxioms,
  	      subDataPropertyOfAxioms = subDataPropertyOfAxioms,
  	      subObjectPropertyOfAxioms = subObjectPropertyOfAxioms,
  	      rootConceptTaxonomyAxioms = rootConceptTaxonomyAxioms,
  	      anonymousConceptUnionAxioms = anonymousConceptUnionAxioms,
  	      specificDisjointConceptAxioms = specificDisjointConceptAxioms,
  	      conceptInstances = conceptInstances,
  	      reifiedRelationshipInstances = reifiedRelationshipInstances,
  	      reifiedRelationshipInstanceDomains = reifiedRelationshipInstanceDomains,
  	      reifiedRelationshipInstanceRanges = reifiedRelationshipInstanceRanges,
  	      unreifiedRelationshipInstanceTuples = unreifiedRelationshipInstanceTuples,
  	      singletonInstanceStructuredDataPropertyValues = singletonInstanceStructuredDataPropertyValues,
  	      singletonInstanceScalarDataPropertyValues = singletonInstanceScalarDataPropertyValues,
  	      structuredDataPropertyTuples = structuredDataPropertyTuples,
  	      scalarDataPropertyValues = scalarDataPropertyValues,
  	      annotationPropertyValues = annotationPropertyValues,
  	      cardinalityRestrictedAspects = cardinalityRestrictedAspects,
  	      cardinalityRestrictedConcepts = cardinalityRestrictedConcepts,
  	      cardinalityRestrictedReifiedRelationships = cardinalityRestrictedReifiedRelationships,
  	      instanceRelationshipEnumerationRestrictions = instanceRelationshipEnumerationRestrictions,
  	      instanceRelationshipExistentialRangeRestrictions = instanceRelationshipExistentialRangeRestrictions,
  	      instanceRelationshipOneOfRestrictions = instanceRelationshipOneOfRestrictions,
  	      instanceRelationshipUniversalRangeRestrictions = instanceRelationshipUniversalRangeRestrictions,
  	      instanceRelationshipValueRestrictions = instanceRelationshipValueRestrictions
  	    ))
  	}

  def sqlWriteOMLSpecificationTables
  (t: tables.OMLSpecificationTables,
   url: String,
   props: Properties)
  (implicit spark: SparkSession, sqlContext: SQLContext)
  : Try[Unit]
  = nonFatalCatch[Try[Unit]]
    .withApply {
      (cause: java.lang.Throwable) =>
        Failure(cause)
    }
    .apply {
      import spark.implicits._
      
      TypedDataset
        .create(t.terminologyGraphs)
        .dataset
        .map(OMLReaders.TerminologyGraphType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.TlgyGraphs", props)
      
      TypedDataset
        .create(t.bundles)
        .dataset
        .map(OMLReaders.BundleType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.Bdls", props)
      
      TypedDataset
        .create(t.descriptionBoxes)
        .dataset
        .map(OMLReaders.DescriptionBoxType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.DBoxes", props)
      
      TypedDataset
        .create(t.annotationProperties)
        .dataset
        .map(OMLReaders.AnnotationPropertyType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.AnnotProps", props)
      
      TypedDataset
        .create(t.aspects)
        .dataset
        .map(OMLReaders.AspectType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.As", props)
      
      TypedDataset
        .create(t.concepts)
        .dataset
        .map(OMLReaders.ConceptType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.Cs", props)
      
      TypedDataset
        .create(t.scalars)
        .dataset
        .map(OMLReaders.ScalarType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.Scs", props)
      
      TypedDataset
        .create(t.structures)
        .dataset
        .map(OMLReaders.StructureType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.Sts", props)
      
      TypedDataset
        .create(t.conceptDesignationTerminologyAxioms)
        .dataset
        .map(OMLReaders.ConceptDesignationTerminologyAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.CDesTlgyAx", props)
      
      TypedDataset
        .create(t.terminologyExtensionAxioms)
        .dataset
        .map(OMLReaders.TerminologyExtensionAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.TlgyExtensionAx", props)
      
      TypedDataset
        .create(t.terminologyNestingAxioms)
        .dataset
        .map(OMLReaders.TerminologyNestingAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.TlgyNestingAx", props)
      
      TypedDataset
        .create(t.bundledTerminologyAxioms)
        .dataset
        .map(OMLReaders.BundledTerminologyAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.BdldTlgyAx", props)
      
      TypedDataset
        .create(t.descriptionBoxExtendsClosedWorldDefinitions)
        .dataset
        .map(OMLReaders.DescriptionBoxExtendsClosedWorldDefinitionsType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.DBoxExtCWDef", props)
      
      TypedDataset
        .create(t.descriptionBoxRefinements)
        .dataset
        .map(OMLReaders.DescriptionBoxRefinementType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.DBoxRfns", props)
      
	    OMLWriters
	      .writeRestrictions(
	        url, 
	        props,
	        t.scalars.map(_.uuid),
	        t.binaryScalarRestrictions, "OML.BinScRs", OMLReaders.BinaryScalarRestrictionType2Tuple,
	        t.iriScalarRestrictions, "OML.IRIScRs", OMLReaders.IRIScalarRestrictionType2Tuple,
	        t.numericScalarRestrictions, "OML.NumericScRs", OMLReaders.NumericScalarRestrictionType2Tuple,
	        t.plainLiteralScalarRestrictions, "OML.PlainLitScRs", OMLReaders.PlainLiteralScalarRestrictionType2Tuple,
	        t.scalarOneOfRestrictions, "OML.ScOneOfRs", OMLReaders.ScalarOneOfRestrictionType2Tuple,
	        t.stringScalarRestrictions, "OML.StringScRs", OMLReaders.StringScalarRestrictionType2Tuple,
	        t.synonymScalarRestrictions, "OML.SynonymScRs", OMLReaders.SynonymScalarRestrictionType2Tuple,
	        t.timeScalarRestrictions, "OML.TimeScRs", OMLReaders.TimeScalarRestrictionType2Tuple)

      TypedDataset
        .create(t.scalarOneOfLiteralAxioms)
        .dataset
        .map(OMLReaders.ScalarOneOfLiteralAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.ScOneOfLitAx", props)

      TypedDataset
        .create(t.entityScalarDataProperties)
        .dataset
        .map(OMLReaders.EntityScalarDataPropertyType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.EScPs", props)

      TypedDataset
        .create(t.entityStructuredDataProperties)
        .dataset
        .map(OMLReaders.EntityStructuredDataPropertyType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.EStPs", props)

      TypedDataset
        .create(t.scalarDataProperties)
        .dataset
        .map(OMLReaders.ScalarDataPropertyType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.ScPs", props)

      TypedDataset
        .create(t.structuredDataProperties)
        .dataset
        .map(OMLReaders.StructuredDataPropertyType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.StPs", props)

      TypedDataset
        .create(t.reifiedRelationships)
        .dataset
        .map(OMLReaders.ReifiedRelationshipType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRs", props)

      TypedDataset
        .create(t.forwardProperties)
        .dataset
        .map(OMLReaders.ForwardPropertyType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.FwdProps", props)

      TypedDataset
        .create(t.inverseProperties)
        .dataset
        .map(OMLReaders.InversePropertyType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.InvProps", props)

      TypedDataset
        .create(t.unreifiedRelationships)
        .dataset
        .map(OMLReaders.UnreifiedRelationshipType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.URs", props)

      TypedDataset
        .create(t.chainRules)
        .dataset
        .map(OMLReaders.ChainRuleType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.CR", props)

      OMLWriters
        .serializeAndWriteRuleBodySegments(
          url,
          props,
          t.ruleBodySegments,
          "OML.RuleBodySegs",
          OMLReaders.RuleBodySegmentType2Tuple,
          Seq.empty[tables.taggedTypes.RuleBodySegmentUUID],
          OMLWriters.ruleBodySegmentPartitioner)

      TypedDataset
        .create(t.segmentPredicates)
        .dataset
        .map(OMLReaders.SegmentPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.SegP", props)

      TypedDataset
        .create(t.entityExistentialRestrictionAxioms)
        .dataset
        .map(OMLReaders.EntityExistentialRestrictionAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.EExRAx", props)

      TypedDataset
        .create(t.entityUniversalRestrictionAxioms)
        .dataset
        .map(OMLReaders.EntityUniversalRestrictionAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.EUxRAx", props)

      TypedDataset
        .create(t.entityScalarDataPropertyExistentialRestrictionAxioms)
        .dataset
        .map(OMLReaders.EntityScalarDataPropertyExistentialRestrictionAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.EScPExRAx", props)

      TypedDataset
        .create(t.entityScalarDataPropertyParticularRestrictionAxioms)
        .dataset
        .map(OMLReaders.EntityScalarDataPropertyParticularRestrictionAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.EScPPtrRAx", props)

      TypedDataset
        .create(t.entityScalarDataPropertyUniversalRestrictionAxioms)
        .dataset
        .map(OMLReaders.EntityScalarDataPropertyUniversalRestrictionAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.EScPUxRAx", props)

      TypedDataset
        .create(t.entityStructuredDataPropertyParticularRestrictionAxioms)
        .dataset
        .map(OMLReaders.EntityStructuredDataPropertyParticularRestrictionAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.EStPPtrRAx", props)

      OMLWriters
        .serializeAndWriteRestrictionStructuredDataPropertyTuples(
          url,
          props,
          t.restrictionStructuredDataPropertyTuples,
          "OML.RStPTs",
          OMLReaders.RestrictionStructuredDataPropertyTupleType2Tuple,
          t.entityStructuredDataPropertyParticularRestrictionAxioms.map(_.uuid),
          OMLWriters.restrictionStructuredDataPropertyTuplePartitioner)

      TypedDataset
        .create(t.restrictionScalarDataPropertyValues)
        .dataset
        .map(OMLReaders.RestrictionScalarDataPropertyValueType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RScPVals", props)

      TypedDataset
        .create(t.aspectSpecializationAxioms)
        .dataset
        .map(OMLReaders.AspectSpecializationAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.AspectSpeAx", props)

      TypedDataset
        .create(t.conceptSpecializationAxioms)
        .dataset
        .map(OMLReaders.ConceptSpecializationAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.CSpeAx", props)

      TypedDataset
        .create(t.reifiedRelationshipSpecializationAxioms)
        .dataset
        .map(OMLReaders.ReifiedRelationshipSpecializationAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRSpeAx", props)

      TypedDataset
        .create(t.subDataPropertyOfAxioms)
        .dataset
        .map(OMLReaders.SubDataPropertyOfAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.SubDataPropOfAx", props)

      TypedDataset
        .create(t.subObjectPropertyOfAxioms)
        .dataset
        .map(OMLReaders.SubObjectPropertyOfAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.SubObjectPropOfAx", props)

      TypedDataset
        .create(t.rootConceptTaxonomyAxioms)
        .dataset
        .map(OMLReaders.RootConceptTaxonomyAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RootCTaxonomyAx", props)

      OMLWriters
        .serializeAndWriteAnonymousConceptUnionAxioms(
          url,
          props,
          t.anonymousConceptUnionAxioms,
          "OML.AnonymousCUnionAx",
          OMLReaders.AnonymousConceptUnionAxiomType2Tuple,
          t.rootConceptTaxonomyAxioms.map(_.uuid),
          OMLWriters.anonymousConceptUnionAxiomPartitioner)

      TypedDataset
        .create(t.specificDisjointConceptAxioms)
        .dataset
        .map(OMLReaders.SpecificDisjointConceptAxiomType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.SpeDsjtCAx", props)

      TypedDataset
        .create(t.conceptInstances)
        .dataset
        .map(OMLReaders.ConceptInstanceType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.CIs", props)

      TypedDataset
        .create(t.reifiedRelationshipInstances)
        .dataset
        .map(OMLReaders.ReifiedRelationshipInstanceType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRIs", props)

      TypedDataset
        .create(t.reifiedRelationshipInstanceDomains)
        .dataset
        .map(OMLReaders.ReifiedRelationshipInstanceDomainType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRIDomains", props)

      TypedDataset
        .create(t.reifiedRelationshipInstanceRanges)
        .dataset
        .map(OMLReaders.ReifiedRelationshipInstanceRangeType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRIRanges", props)

      TypedDataset
        .create(t.unreifiedRelationshipInstanceTuples)
        .dataset
        .map(OMLReaders.UnreifiedRelationshipInstanceTupleType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.URITs", props)

      TypedDataset
        .create(t.singletonInstanceStructuredDataPropertyValues)
        .dataset
        .map(OMLReaders.SingletonInstanceStructuredDataPropertyValueType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.S1IStPVals", props)

      TypedDataset
        .create(t.singletonInstanceScalarDataPropertyValues)
        .dataset
        .map(OMLReaders.SingletonInstanceScalarDataPropertyValueType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.S1IScPVals", props)

      OMLWriters
        .serializeAndWriteStructuredDataPropertyTuples(
          url,
          props,
          t.structuredDataPropertyTuples,
          "OML.StPTs",
          OMLReaders.StructuredDataPropertyTupleType2Tuple,
          t.singletonInstanceStructuredDataPropertyValues.map(_.uuid),
          OMLWriters.structuredDataPropertyTuplePartitioner)

      TypedDataset
        .create(t.scalarDataPropertyValues)
        .dataset
        .map(OMLReaders.ScalarDataPropertyValueType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.ScPVals", props)

      TypedDataset
        .create(t.annotationPropertyValues)
        .dataset
        .map(OMLReaders.AnnotationPropertyValueType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.AnnotPropVals", props)

      TypedDataset
        .create(t.cardinalityRestrictedAspects)
        .dataset
        .map(OMLReaders.CardinalityRestrictedAspectType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.CardinalityRestAs", props)

      TypedDataset
        .create(t.cardinalityRestrictedConcepts)
        .dataset
        .map(OMLReaders.CardinalityRestrictedConceptType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.CardinalityRestCs", props)

      TypedDataset
        .create(t.cardinalityRestrictedReifiedRelationships)
        .dataset
        .map(OMLReaders.CardinalityRestrictedReifiedRelationshipType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.CardinalityRestRRs", props)

  	  Success(())
  	}
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

  aspectSpecializationAxioms
  : TypedDataset[api.AspectSpecializationAxiom],

  binaryScalarRestrictions
  : TypedDataset[api.BinaryScalarRestriction],

  bundles
  : TypedDataset[api.Bundle],

  bundledTerminologyAxioms
  : TypedDataset[api.BundledTerminologyAxiom],

  cardinalityRestrictedAspects
  : TypedDataset[api.CardinalityRestrictedAspect],

  cardinalityRestrictedConcepts
  : TypedDataset[api.CardinalityRestrictedConcept],

  cardinalityRestrictedReifiedRelationships
  : TypedDataset[api.CardinalityRestrictedReifiedRelationship],

  chainRules
  : TypedDataset[api.ChainRule],

  concepts
  : TypedDataset[api.Concept],

  conceptDesignationTerminologyAxioms
  : TypedDataset[api.ConceptDesignationTerminologyAxiom],

  conceptInstances
  : TypedDataset[api.ConceptInstance],

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

  forwardProperties
  : TypedDataset[api.ForwardProperty],

  iriScalarRestrictions
  : TypedDataset[api.IRIScalarRestriction],

  instanceRelationshipEnumerationRestrictions
  : TypedDataset[api.InstanceRelationshipEnumerationRestriction],

  instanceRelationshipExistentialRangeRestrictions
  : TypedDataset[api.InstanceRelationshipExistentialRangeRestriction],

  instanceRelationshipOneOfRestrictions
  : TypedDataset[api.InstanceRelationshipOneOfRestriction],

  instanceRelationshipUniversalRangeRestrictions
  : TypedDataset[api.InstanceRelationshipUniversalRangeRestriction],

  instanceRelationshipValueRestrictions
  : TypedDataset[api.InstanceRelationshipValueRestriction],

  inverseProperties
  : TypedDataset[api.InverseProperty],

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

  reifiedRelationshipRestrictions
  : TypedDataset[api.ReifiedRelationshipRestriction],

  reifiedRelationshipSpecializationAxioms
  : TypedDataset[api.ReifiedRelationshipSpecializationAxiom],

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

  segmentPredicates
  : TypedDataset[api.SegmentPredicate],

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

  subDataPropertyOfAxioms
  : TypedDataset[api.SubDataPropertyOfAxiom],

  subObjectPropertyOfAxioms
  : TypedDataset[api.SubObjectPropertyOfAxiom],

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
  : TypedDataset[api.UnreifiedRelationshipInstanceTuple]
)

