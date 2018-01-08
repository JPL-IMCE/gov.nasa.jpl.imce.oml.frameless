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

import frameless.{Injection, TypedDataset}
import gov.nasa.jpl.imce.oml.covariantTag
import gov.nasa.jpl.imce.oml.covariantTag.@@
import gov.nasa.jpl.imce.oml.tables
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
      
      val aspectPredicates
      : Seq[tables.AspectPredicate]
      = spark
        .read
        .parquet((dir / "AspectPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.AspectPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.AspectPredicateTuple2Type)
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
      
      val conceptPredicates
      : Seq[tables.ConceptPredicate]
      = spark
        .read
        .parquet((dir / "ConceptPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ConceptPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.ConceptPredicateTuple2Type)
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
      
      val iriScalarRestrictions
      : Seq[tables.IRIScalarRestriction]
      = spark
        .read
        .parquet((dir / "IRIScalarRestriction.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.IRIScalarRestrictionRow2Tuple)
        .collect()
        .map(OMLReaders.IRIScalarRestrictionTuple2Type)
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
      
      val reifiedRelationshipInversePropertyPredicates
      : Seq[tables.ReifiedRelationshipInversePropertyPredicate]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipInversePropertyPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipInversePropertyPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipInversePropertyPredicateTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipPredicates
      : Seq[tables.ReifiedRelationshipPredicate]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipPredicateTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipPropertyPredicates
      : Seq[tables.ReifiedRelationshipPropertyPredicate]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipPropertyPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipPropertyPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipPropertyPredicateTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipSourceInversePropertyPredicates
      : Seq[tables.ReifiedRelationshipSourceInversePropertyPredicate]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipSourceInversePropertyPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipSourceInversePropertyPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipSourceInversePropertyPredicateTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipSourcePropertyPredicates
      : Seq[tables.ReifiedRelationshipSourcePropertyPredicate]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipSourcePropertyPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipSourcePropertyPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipSourcePropertyPredicateTuple2Type)
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
      
      val reifiedRelationshipTargetInversePropertyPredicates
      : Seq[tables.ReifiedRelationshipTargetInversePropertyPredicate]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipTargetInversePropertyPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipTargetInversePropertyPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipTargetInversePropertyPredicateTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipTargetPropertyPredicates
      : Seq[tables.ReifiedRelationshipTargetPropertyPredicate]
      = spark
        .read
        .parquet((dir / "ReifiedRelationshipTargetPropertyPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.ReifiedRelationshipTargetPropertyPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipTargetPropertyPredicateTuple2Type)
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
      
      val unreifiedRelationshipInversePropertyPredicates
      : Seq[tables.UnreifiedRelationshipInversePropertyPredicate]
      = spark
        .read
        .parquet((dir / "UnreifiedRelationshipInversePropertyPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.UnreifiedRelationshipInversePropertyPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.UnreifiedRelationshipInversePropertyPredicateTuple2Type)
        .to[Seq]
      
      val unreifiedRelationshipPropertyPredicates
      : Seq[tables.UnreifiedRelationshipPropertyPredicate]
      = spark
        .read
        .parquet((dir / "UnreifiedRelationshipPropertyPredicate.parquet").toIO.getAbsolutePath)
        .map(OMLReaders.UnreifiedRelationshipPropertyPredicateRow2Tuple)
        .collect()
        .map(OMLReaders.UnreifiedRelationshipPropertyPredicateTuple2Type)
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
  	      unreifiedRelationships = unreifiedRelationships,
  	      chainRules = chainRules,
  	      ruleBodySegments = ruleBodySegments,
  	      aspectPredicates = aspectPredicates,
  	      conceptPredicates = conceptPredicates,
  	      reifiedRelationshipPredicates = reifiedRelationshipPredicates,
  	      reifiedRelationshipPropertyPredicates = reifiedRelationshipPropertyPredicates,
  	      reifiedRelationshipSourcePropertyPredicates = reifiedRelationshipSourcePropertyPredicates,
  	      reifiedRelationshipTargetPropertyPredicates = reifiedRelationshipTargetPropertyPredicates,
  	      unreifiedRelationshipPropertyPredicates = unreifiedRelationshipPropertyPredicates,
  	      reifiedRelationshipInversePropertyPredicates = reifiedRelationshipInversePropertyPredicates,
  	      reifiedRelationshipSourceInversePropertyPredicates = reifiedRelationshipSourceInversePropertyPredicates,
  	      reifiedRelationshipTargetInversePropertyPredicates = reifiedRelationshipTargetInversePropertyPredicates,
  	      unreifiedRelationshipInversePropertyPredicates = unreifiedRelationshipInversePropertyPredicates,
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
  	      annotationPropertyValues = annotationPropertyValues
  	    ))
  	}

  def parquetWriteOMLSpecificationTables
  (t: tables.OMLSpecificationTables,
   dir: Path)
  (implicit spark: SparkSession, sqlContext: SQLContext)
  : Try[Unit]
  = nonFatalCatch[Try[Unit]]
    .withApply {
      (cause: java.lang.Throwable) =>
        Failure(cause)
    }
    .apply {

  	  dir.toIO.mkdirs()

      TypedDataset
        .create(t.annotationProperties)
        .dataset
        .write
        .parquet((dir / "AnnotationProperty.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.annotationPropertyValues)
        .dataset
        .write
        .parquet((dir / "AnnotationPropertyValue.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.anonymousConceptUnionAxioms)
        .dataset
        .write
        .parquet((dir / "AnonymousConceptUnionAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.aspects)
        .dataset
        .write
        .parquet((dir / "Aspect.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.aspectPredicates)
        .dataset
        .write
        .parquet((dir / "AspectPredicate.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.aspectSpecializationAxioms)
        .dataset
        .write
        .parquet((dir / "AspectSpecializationAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.binaryScalarRestrictions)
        .dataset
        .write
        .parquet((dir / "BinaryScalarRestriction.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.bundles)
        .dataset
        .write
        .parquet((dir / "Bundle.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.bundledTerminologyAxioms)
        .dataset
        .write
        .parquet((dir / "BundledTerminologyAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.chainRules)
        .dataset
        .write
        .parquet((dir / "ChainRule.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.concepts)
        .dataset
        .write
        .parquet((dir / "Concept.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.conceptDesignationTerminologyAxioms)
        .dataset
        .write
        .parquet((dir / "ConceptDesignationTerminologyAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.conceptInstances)
        .dataset
        .write
        .parquet((dir / "ConceptInstance.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.conceptPredicates)
        .dataset
        .write
        .parquet((dir / "ConceptPredicate.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.conceptSpecializationAxioms)
        .dataset
        .write
        .parquet((dir / "ConceptSpecializationAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.descriptionBoxes)
        .dataset
        .write
        .parquet((dir / "DescriptionBox.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.descriptionBoxExtendsClosedWorldDefinitions)
        .dataset
        .write
        .parquet((dir / "DescriptionBoxExtendsClosedWorldDefinitions.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.descriptionBoxRefinements)
        .dataset
        .write
        .parquet((dir / "DescriptionBoxRefinement.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.entityExistentialRestrictionAxioms)
        .dataset
        .write
        .parquet((dir / "EntityExistentialRestrictionAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.entityScalarDataProperties)
        .dataset
        .write
        .parquet((dir / "EntityScalarDataProperty.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.entityScalarDataPropertyExistentialRestrictionAxioms)
        .dataset
        .write
        .parquet((dir / "EntityScalarDataPropertyExistentialRestrictionAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.entityScalarDataPropertyParticularRestrictionAxioms)
        .dataset
        .write
        .parquet((dir / "EntityScalarDataPropertyParticularRestrictionAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.entityScalarDataPropertyUniversalRestrictionAxioms)
        .dataset
        .write
        .parquet((dir / "EntityScalarDataPropertyUniversalRestrictionAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.entityStructuredDataProperties)
        .dataset
        .write
        .parquet((dir / "EntityStructuredDataProperty.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.entityStructuredDataPropertyParticularRestrictionAxioms)
        .dataset
        .write
        .parquet((dir / "EntityStructuredDataPropertyParticularRestrictionAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.entityUniversalRestrictionAxioms)
        .dataset
        .write
        .parquet((dir / "EntityUniversalRestrictionAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.iriScalarRestrictions)
        .dataset
        .write
        .parquet((dir / "IRIScalarRestriction.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.numericScalarRestrictions)
        .dataset
        .write
        .parquet((dir / "NumericScalarRestriction.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.plainLiteralScalarRestrictions)
        .dataset
        .write
        .parquet((dir / "PlainLiteralScalarRestriction.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationships)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationship.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationshipInstances)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationshipInstance.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationshipInstanceDomains)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationshipInstanceDomain.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationshipInstanceRanges)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationshipInstanceRange.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationshipInversePropertyPredicates)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationshipInversePropertyPredicate.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationshipPredicates)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationshipPredicate.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationshipPropertyPredicates)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationshipPropertyPredicate.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationshipSourceInversePropertyPredicates)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationshipSourceInversePropertyPredicate.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationshipSourcePropertyPredicates)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationshipSourcePropertyPredicate.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationshipSpecializationAxioms)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationshipSpecializationAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationshipTargetInversePropertyPredicates)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationshipTargetInversePropertyPredicate.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.reifiedRelationshipTargetPropertyPredicates)
        .dataset
        .write
        .parquet((dir / "ReifiedRelationshipTargetPropertyPredicate.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.restrictionScalarDataPropertyValues)
        .dataset
        .write
        .parquet((dir / "RestrictionScalarDataPropertyValue.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.restrictionStructuredDataPropertyTuples)
        .dataset
        .write
        .parquet((dir / "RestrictionStructuredDataPropertyTuple.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.rootConceptTaxonomyAxioms)
        .dataset
        .write
        .parquet((dir / "RootConceptTaxonomyAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.ruleBodySegments)
        .dataset
        .write
        .parquet((dir / "RuleBodySegment.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.scalars)
        .dataset
        .write
        .parquet((dir / "Scalar.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.scalarDataProperties)
        .dataset
        .write
        .parquet((dir / "ScalarDataProperty.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.scalarDataPropertyValues)
        .dataset
        .write
        .parquet((dir / "ScalarDataPropertyValue.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.scalarOneOfLiteralAxioms)
        .dataset
        .write
        .parquet((dir / "ScalarOneOfLiteralAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.scalarOneOfRestrictions)
        .dataset
        .write
        .parquet((dir / "ScalarOneOfRestriction.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.singletonInstanceScalarDataPropertyValues)
        .dataset
        .write
        .parquet((dir / "SingletonInstanceScalarDataPropertyValue.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.singletonInstanceStructuredDataPropertyValues)
        .dataset
        .write
        .parquet((dir / "SingletonInstanceStructuredDataPropertyValue.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.specificDisjointConceptAxioms)
        .dataset
        .write
        .parquet((dir / "SpecificDisjointConceptAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.stringScalarRestrictions)
        .dataset
        .write
        .parquet((dir / "StringScalarRestriction.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.structures)
        .dataset
        .write
        .parquet((dir / "Structure.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.structuredDataProperties)
        .dataset
        .write
        .parquet((dir / "StructuredDataProperty.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.structuredDataPropertyTuples)
        .dataset
        .write
        .parquet((dir / "StructuredDataPropertyTuple.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.subDataPropertyOfAxioms)
        .dataset
        .write
        .parquet((dir / "SubDataPropertyOfAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.subObjectPropertyOfAxioms)
        .dataset
        .write
        .parquet((dir / "SubObjectPropertyOfAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.synonymScalarRestrictions)
        .dataset
        .write
        .parquet((dir / "SynonymScalarRestriction.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.terminologyExtensionAxioms)
        .dataset
        .write
        .parquet((dir / "TerminologyExtensionAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.terminologyGraphs)
        .dataset
        .write
        .parquet((dir / "TerminologyGraph.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.terminologyNestingAxioms)
        .dataset
        .write
        .parquet((dir / "TerminologyNestingAxiom.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.timeScalarRestrictions)
        .dataset
        .write
        .parquet((dir / "TimeScalarRestriction.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.unreifiedRelationships)
        .dataset
        .write
        .parquet((dir / "UnreifiedRelationship.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.unreifiedRelationshipInstanceTuples)
        .dataset
        .write
        .parquet((dir / "UnreifiedRelationshipInstanceTuple.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.unreifiedRelationshipInversePropertyPredicates)
        .dataset
        .write
        .parquet((dir / "UnreifiedRelationshipInversePropertyPredicate.parquet").toIO.getAbsolutePath)
      
      TypedDataset
        .create(t.unreifiedRelationshipPropertyPredicates)
        .dataset
        .write
        .parquet((dir / "UnreifiedRelationshipPropertyPredicate.parquet").toIO.getAbsolutePath)
      
  	  Success(())
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
        .jdbc(url, "OML.Aspects", props)
        .map(OMLReaders.AspectSQL2Tuple)
        .collect()
        .map(OMLReaders.AspectTuple2Type)
        .to[Seq]
      
      val aspectPredicates
      : Seq[tables.AspectPredicate]
      = spark
        .read
        .jdbc(url, "OML.AspectP", props)
        .map(OMLReaders.AspectPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.AspectPredicateTuple2Type)
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
      
      val chainRules
      : Seq[tables.ChainRule]
      = spark
        .read
        .jdbc(url, "OML.ChainRules", props)
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
      
      val conceptPredicates
      : Seq[tables.ConceptPredicate]
      = spark
        .read
        .jdbc(url, "OML.CP", props)
        .map(OMLReaders.ConceptPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.ConceptPredicateTuple2Type)
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
      
      val iriScalarRestrictions
      : Seq[tables.IRIScalarRestriction]
      = spark
        .read
        .jdbc(url, "OML.IRIScRs", props)
        .map(OMLReaders.IRIScalarRestrictionSQL2Tuple)
        .collect()
        .map(OMLReaders.IRIScalarRestrictionTuple2Type)
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
      
      val reifiedRelationshipInversePropertyPredicates
      : Seq[tables.ReifiedRelationshipInversePropertyPredicate]
      = spark
        .read
        .jdbc(url, "OML.RRInvPropP", props)
        .map(OMLReaders.ReifiedRelationshipInversePropertyPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipInversePropertyPredicateTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipPredicates
      : Seq[tables.ReifiedRelationshipPredicate]
      = spark
        .read
        .jdbc(url, "OML.RRP", props)
        .map(OMLReaders.ReifiedRelationshipPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipPredicateTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipPropertyPredicates
      : Seq[tables.ReifiedRelationshipPropertyPredicate]
      = spark
        .read
        .jdbc(url, "OML.RRPropP", props)
        .map(OMLReaders.ReifiedRelationshipPropertyPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipPropertyPredicateTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipSourceInversePropertyPredicates
      : Seq[tables.ReifiedRelationshipSourceInversePropertyPredicate]
      = spark
        .read
        .jdbc(url, "OML.RRSrcInvPropP", props)
        .map(OMLReaders.ReifiedRelationshipSourceInversePropertyPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipSourceInversePropertyPredicateTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipSourcePropertyPredicates
      : Seq[tables.ReifiedRelationshipSourcePropertyPredicate]
      = spark
        .read
        .jdbc(url, "OML.RRSrcPropP", props)
        .map(OMLReaders.ReifiedRelationshipSourcePropertyPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipSourcePropertyPredicateTuple2Type)
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
      
      val reifiedRelationshipTargetInversePropertyPredicates
      : Seq[tables.ReifiedRelationshipTargetInversePropertyPredicate]
      = spark
        .read
        .jdbc(url, "OML.RRTgtInvPropP", props)
        .map(OMLReaders.ReifiedRelationshipTargetInversePropertyPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipTargetInversePropertyPredicateTuple2Type)
        .to[Seq]
      
      val reifiedRelationshipTargetPropertyPredicates
      : Seq[tables.ReifiedRelationshipTargetPropertyPredicate]
      = spark
        .read
        .jdbc(url, "OML.RRTgtPropP", props)
        .map(OMLReaders.ReifiedRelationshipTargetPropertyPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.ReifiedRelationshipTargetPropertyPredicateTuple2Type)
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
      
      val unreifiedRelationshipInversePropertyPredicates
      : Seq[tables.UnreifiedRelationshipInversePropertyPredicate]
      = spark
        .read
        .jdbc(url, "OML.URInvPropP", props)
        .map(OMLReaders.UnreifiedRelationshipInversePropertyPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.UnreifiedRelationshipInversePropertyPredicateTuple2Type)
        .to[Seq]
      
      val unreifiedRelationshipPropertyPredicates
      : Seq[tables.UnreifiedRelationshipPropertyPredicate]
      = spark
        .read
        .jdbc(url, "OML.URPropP", props)
        .map(OMLReaders.UnreifiedRelationshipPropertyPredicateSQL2Tuple)
        .collect()
        .map(OMLReaders.UnreifiedRelationshipPropertyPredicateTuple2Type)
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
  	      unreifiedRelationships = unreifiedRelationships,
  	      chainRules = chainRules,
  	      ruleBodySegments = ruleBodySegments,
  	      aspectPredicates = aspectPredicates,
  	      conceptPredicates = conceptPredicates,
  	      reifiedRelationshipPredicates = reifiedRelationshipPredicates,
  	      reifiedRelationshipPropertyPredicates = reifiedRelationshipPropertyPredicates,
  	      reifiedRelationshipSourcePropertyPredicates = reifiedRelationshipSourcePropertyPredicates,
  	      reifiedRelationshipTargetPropertyPredicates = reifiedRelationshipTargetPropertyPredicates,
  	      unreifiedRelationshipPropertyPredicates = unreifiedRelationshipPropertyPredicates,
  	      reifiedRelationshipInversePropertyPredicates = reifiedRelationshipInversePropertyPredicates,
  	      reifiedRelationshipSourceInversePropertyPredicates = reifiedRelationshipSourceInversePropertyPredicates,
  	      reifiedRelationshipTargetInversePropertyPredicates = reifiedRelationshipTargetInversePropertyPredicates,
  	      unreifiedRelationshipInversePropertyPredicates = unreifiedRelationshipInversePropertyPredicates,
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
  	      annotationPropertyValues = annotationPropertyValues
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
        .jdbc(url, "OML.Aspects", props)
      
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
        .jdbc(url, "OML.ChainRules", props)

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
        .create(t.aspectPredicates)
        .dataset
        .map(OMLReaders.AspectPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.AspectP", props)

      TypedDataset
        .create(t.conceptPredicates)
        .dataset
        .map(OMLReaders.ConceptPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.CP", props)

      TypedDataset
        .create(t.reifiedRelationshipPredicates)
        .dataset
        .map(OMLReaders.ReifiedRelationshipPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRP", props)

      TypedDataset
        .create(t.reifiedRelationshipPropertyPredicates)
        .dataset
        .map(OMLReaders.ReifiedRelationshipPropertyPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRPropP", props)

      TypedDataset
        .create(t.reifiedRelationshipSourcePropertyPredicates)
        .dataset
        .map(OMLReaders.ReifiedRelationshipSourcePropertyPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRSrcPropP", props)

      TypedDataset
        .create(t.reifiedRelationshipTargetPropertyPredicates)
        .dataset
        .map(OMLReaders.ReifiedRelationshipTargetPropertyPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRTgtPropP", props)

      TypedDataset
        .create(t.unreifiedRelationshipPropertyPredicates)
        .dataset
        .map(OMLReaders.UnreifiedRelationshipPropertyPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.URPropP", props)

      TypedDataset
        .create(t.reifiedRelationshipInversePropertyPredicates)
        .dataset
        .map(OMLReaders.ReifiedRelationshipInversePropertyPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRInvPropP", props)

      TypedDataset
        .create(t.reifiedRelationshipSourceInversePropertyPredicates)
        .dataset
        .map(OMLReaders.ReifiedRelationshipSourceInversePropertyPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRSrcInvPropP", props)

      TypedDataset
        .create(t.reifiedRelationshipTargetInversePropertyPredicates)
        .dataset
        .map(OMLReaders.ReifiedRelationshipTargetInversePropertyPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.RRTgtInvPropP", props)

      TypedDataset
        .create(t.unreifiedRelationshipInversePropertyPredicates)
        .dataset
        .map(OMLReaders.UnreifiedRelationshipInversePropertyPredicateType2Tuple)
        .write
        .mode(SaveMode.Append)
        .jdbc(url, "OML.URInvPropP", props)

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
  : TypedDataset[api.UnreifiedRelationshipInstanceTuple],

  unreifiedRelationshipInversePropertyPredicates
  : TypedDataset[api.UnreifiedRelationshipInversePropertyPredicate],

  unreifiedRelationshipPropertyPredicates
  : TypedDataset[api.UnreifiedRelationshipPropertyPredicate]
)

