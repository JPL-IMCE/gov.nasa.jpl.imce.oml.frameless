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

import org.apache.spark.sql.Row
import org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema
import gov.nasa.jpl.imce.oml.tables
import scala.{Boolean,Int,None,Some,StringContext}
import scala.Predef.String

object OMLReaders {
	
	def terminologyKind(kind: Int)
	: tables.TerminologyKind
	= kind match {
		case 0 =>
		  tables.OpenWorldDefinitions
		case 1 =>
		  tables.ClosedWorldDesignations
    }

	def descriptionKind(kind: Int)
	: tables.DescriptionKind
	= kind match {
		case 0 =>
		  tables.Final
		case 1 =>
		  tables.Partial
    }

	def AnnotationPropertyRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("moduleUUID"),
	  row.getAs[String]("iri"),
	  row.getAs[String]("abbrevIRI")
	)
	
	def AnnotationPropertyTuple2Type
	(uuid: String,
	 moduleUUID: String,
	 iri: String,
	 abbrevIRI: String)
	: tables.AnnotationProperty
	= tables.AnnotationProperty(
	  tables.taggedTypes.annotationPropertyUUID(uuid),
	  tables.taggedTypes.moduleUUID(moduleUUID),
	  tables.taggedTypes.iri(iri),
	  tables.taggedTypes.abbrevIRI(abbrevIRI)
	)
	
	def AnnotationPropertyValueRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("subjectUUID"),
	  row.getAs[String]("propertyUUID"),
	  row.getAs[String]("value")
	)
	
	def AnnotationPropertyValueTuple2Type
	(uuid: String,
	 subjectUUID: String,
	 propertyUUID: String,
	 value: String)
	: tables.AnnotationPropertyValue
	= tables.AnnotationPropertyValue(
	  tables.taggedTypes.annotationPropertyValueUUID(uuid),
	  tables.taggedTypes.logicalElementUUID(subjectUUID),
	  tables.taggedTypes.annotationPropertyUUID(propertyUUID),
	  tables.taggedTypes.stringDataType(value)
	)
	
	def AnonymousConceptUnionAxiomRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("disjointTaxonomyParentUUID"),
	  row.getAs[String]("name")
	)
	
	def AnonymousConceptUnionAxiomTuple2Type
	(uuid: String,
	 disjointTaxonomyParentUUID: String,
	 name: String)
	: tables.AnonymousConceptUnionAxiom
	= tables.AnonymousConceptUnionAxiom(
	  tables.taggedTypes.anonymousConceptUnionAxiomUUID(uuid),
	  tables.taggedTypes.conceptTreeDisjunctionUUID(disjointTaxonomyParentUUID),
	  tables.taggedTypes.localName(name)
	)
	
	def AspectRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)
	
	def AspectTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 name: String)
	: tables.Aspect
	= tables.Aspect(
	  tables.taggedTypes.aspectUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.localName(name)
	)
	
	def AspectPredicateRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("aspectUUID"),
	  row.getAs[String]("bodySegmentUUID")
	)
	
	def AspectPredicateTuple2Type
	(uuid: String,
	 aspectUUID: String,
	 bodySegmentUUID: String)
	: tables.AspectPredicate
	= tables.AspectPredicate(
	  tables.taggedTypes.aspectPredicateUUID(uuid),
	  tables.taggedTypes.aspectUUID(aspectUUID),
	  tables.taggedTypes.ruleBodySegmentUUID(bodySegmentUUID)
	)
	
	def AspectSpecializationAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("superAspectUUID"),
	  row.getAs[String]("subEntityUUID")
	)
	
	def AspectSpecializationAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 superAspectUUID: String,
	 subEntityUUID: String)
	: tables.AspectSpecializationAxiom
	= tables.AspectSpecializationAxiom(
	  tables.taggedTypes.aspectSpecializationAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.aspectUUID(superAspectUUID),
	  tables.taggedTypes.entityUUID(subEntityUUID)
	)
	
	def BinaryScalarRestrictionRow2Tuple
	(row: Row)
	: (String, String, String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("length"),
	  row.getAs[String]("minLength"),
	  row.getAs[String]("maxLength"),
	  row.getAs[String]("name")
	)
	
	def BinaryScalarRestrictionTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 length: String,
	 minLength: String,
	 maxLength: String,
	 name: String)
	: tables.BinaryScalarRestriction
	= tables.BinaryScalarRestriction(
	  tables.taggedTypes.binaryScalarRestrictionUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.dataRangeUUID(restrictedRangeUUID),
	  if (null == length || length.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(length)),
	  if (null == minLength || minLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(minLength)),
	  if (null == maxLength || maxLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(maxLength)),
	  tables.taggedTypes.localName(name)
	)
	
	def BundleRow2Tuple
	(row: Row)
	: (String, Int, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[Int]("kind"),
	  row.getAs[String]("iri")
	)
	
	def BundleTuple2Type
	(uuid: String,
	 kind: Int,
	 iri: String)
	: tables.Bundle
	= tables.Bundle(
	  tables.taggedTypes.bundleUUID(uuid),
	  terminologyKind(kind),
	  tables.taggedTypes.iri(iri)
	)
	
	def BundledTerminologyAxiomRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bundleUUID"),
	  row.getAs[String]("bundledTerminologyIRI")
	)
	
	def BundledTerminologyAxiomTuple2Type
	(uuid: String,
	 bundleUUID: String,
	 bundledTerminologyIRI: String)
	: tables.BundledTerminologyAxiom
	= tables.BundledTerminologyAxiom(
	  tables.taggedTypes.bundledTerminologyAxiomUUID(uuid),
	  tables.taggedTypes.bundleUUID(bundleUUID),
	  tables.taggedTypes.iri(bundledTerminologyIRI)
	)
	
	def ChainRuleRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name"),
	  row.getAs[String]("headUUID")
	)
	
	def ChainRuleTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 name: String,
	 headUUID: String)
	: tables.ChainRule
	= tables.ChainRule(
	  tables.taggedTypes.chainRuleUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.localName(name),
	  tables.taggedTypes.unreifiedRelationshipUUID(headUUID)
	)
	
	def ConceptRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)
	
	def ConceptTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 name: String)
	: tables.Concept
	= tables.Concept(
	  tables.taggedTypes.conceptUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.localName(name)
	)
	
	def ConceptDesignationTerminologyAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("designatedConceptUUID"),
	  row.getAs[String]("designatedTerminologyIRI")
	)
	
	def ConceptDesignationTerminologyAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 designatedConceptUUID: String,
	 designatedTerminologyIRI: String)
	: tables.ConceptDesignationTerminologyAxiom
	= tables.ConceptDesignationTerminologyAxiom(
	  tables.taggedTypes.conceptDesignationTerminologyAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.conceptUUID(designatedConceptUUID),
	  tables.taggedTypes.iri(designatedTerminologyIRI)
	)
	
	def ConceptInstanceRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonConceptClassifierUUID"),
	  row.getAs[String]("name")
	)
	
	def ConceptInstanceTuple2Type
	(uuid: String,
	 descriptionBoxUUID: String,
	 singletonConceptClassifierUUID: String,
	 name: String)
	: tables.ConceptInstance
	= tables.ConceptInstance(
	  tables.taggedTypes.conceptInstanceUUID(uuid),
	  tables.taggedTypes.descriptionBoxUUID(descriptionBoxUUID),
	  tables.taggedTypes.conceptUUID(singletonConceptClassifierUUID),
	  tables.taggedTypes.localName(name)
	)
	
	def ConceptPredicateRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("conceptUUID")
	)
	
	def ConceptPredicateTuple2Type
	(uuid: String,
	 bodySegmentUUID: String,
	 conceptUUID: String)
	: tables.ConceptPredicate
	= tables.ConceptPredicate(
	  tables.taggedTypes.conceptPredicateUUID(uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(bodySegmentUUID),
	  tables.taggedTypes.conceptUUID(conceptUUID)
	)
	
	def ConceptSpecializationAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("superConceptUUID"),
	  row.getAs[String]("subConceptUUID")
	)
	
	def ConceptSpecializationAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 superConceptUUID: String,
	 subConceptUUID: String)
	: tables.ConceptSpecializationAxiom
	= tables.ConceptSpecializationAxiom(
	  tables.taggedTypes.conceptSpecializationAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.conceptUUID(superConceptUUID),
	  tables.taggedTypes.conceptUUID(subConceptUUID)
	)
	
	def DescriptionBoxRow2Tuple
	(row: Row)
	: (String, Int, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[Int]("kind"),
	  row.getAs[String]("iri")
	)
	
	def DescriptionBoxTuple2Type
	(uuid: String,
	 kind: Int,
	 iri: String)
	: tables.DescriptionBox
	= tables.DescriptionBox(
	  tables.taggedTypes.descriptionBoxUUID(uuid),
	  descriptionKind(kind),
	  tables.taggedTypes.iri(iri)
	)
	
	def DescriptionBoxExtendsClosedWorldDefinitionsRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("closedWorldDefinitionsIRI")
	)
	
	def DescriptionBoxExtendsClosedWorldDefinitionsTuple2Type
	(uuid: String,
	 descriptionBoxUUID: String,
	 closedWorldDefinitionsIRI: String)
	: tables.DescriptionBoxExtendsClosedWorldDefinitions
	= tables.DescriptionBoxExtendsClosedWorldDefinitions(
	  tables.taggedTypes.descriptionBoxExtendsClosedWorldDefinitionsUUID(uuid),
	  tables.taggedTypes.descriptionBoxUUID(descriptionBoxUUID),
	  tables.taggedTypes.iri(closedWorldDefinitionsIRI)
	)
	
	def DescriptionBoxRefinementRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("refiningDescriptionBoxUUID"),
	  row.getAs[String]("refinedDescriptionBoxIRI")
	)
	
	def DescriptionBoxRefinementTuple2Type
	(uuid: String,
	 refiningDescriptionBoxUUID: String,
	 refinedDescriptionBoxIRI: String)
	: tables.DescriptionBoxRefinement
	= tables.DescriptionBoxRefinement(
	  tables.taggedTypes.descriptionBoxRefinementUUID(uuid),
	  tables.taggedTypes.descriptionBoxUUID(refiningDescriptionBoxUUID),
	  tables.taggedTypes.iri(refinedDescriptionBoxIRI)
	)
	
	def EntityExistentialRestrictionAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRelationUUID"),
	  row.getAs[String]("restrictedDomainUUID"),
	  row.getAs[String]("restrictedRangeUUID")
	)
	
	def EntityExistentialRestrictionAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedRelationUUID: String,
	 restrictedDomainUUID: String,
	 restrictedRangeUUID: String)
	: tables.EntityExistentialRestrictionAxiom
	= tables.EntityExistentialRestrictionAxiom(
	  tables.taggedTypes.entityExistentialRestrictionAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.entityRelationshipUUID(restrictedRelationUUID),
	  tables.taggedTypes.entityUUID(restrictedDomainUUID),
	  tables.taggedTypes.entityUUID(restrictedRangeUUID)
	)
	
	def EntityScalarDataPropertyRow2Tuple
	(row: Row)
	: (String, String, String, String, Boolean, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[Boolean]("isIdentityCriteria"),
	  row.getAs[String]("name")
	)
	
	def EntityScalarDataPropertyTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 domainUUID: String,
	 rangeUUID: String,
	 isIdentityCriteria: Boolean,
	 name: String)
	: tables.EntityScalarDataProperty
	= tables.EntityScalarDataProperty(
	  tables.taggedTypes.entityScalarDataPropertyUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.entityUUID(domainUUID),
	  tables.taggedTypes.dataRangeUUID(rangeUUID),
	  isIdentityCriteria,
	  tables.taggedTypes.localName(name)
	)
	
	def EntityScalarDataPropertyExistentialRestrictionAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedEntityUUID"),
	  row.getAs[String]("scalarPropertyUUID"),
	  row.getAs[String]("scalarRestrictionUUID")
	)
	
	def EntityScalarDataPropertyExistentialRestrictionAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedEntityUUID: String,
	 scalarPropertyUUID: String,
	 scalarRestrictionUUID: String)
	: tables.EntityScalarDataPropertyExistentialRestrictionAxiom
	= tables.EntityScalarDataPropertyExistentialRestrictionAxiom(
	  tables.taggedTypes.entityScalarDataPropertyExistentialRestrictionAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.entityUUID(restrictedEntityUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(scalarPropertyUUID),
	  tables.taggedTypes.dataRangeUUID(scalarRestrictionUUID)
	)
	
	def EntityScalarDataPropertyParticularRestrictionAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedEntityUUID"),
	  row.getAs[String]("scalarPropertyUUID"),
	  row.getAs[GenericRowWithSchema]("literalValue").getAs[String]("literalType"),row.getAs[GenericRowWithSchema]("literalValue").getAs[String]("value"),
	  row.getAs[String]("valueTypeUUID")
	)
	
	def EntityScalarDataPropertyParticularRestrictionAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedEntityUUID: String,
	 scalarPropertyUUID: String,
	 literalValue_literalType: String, literalValue_value: String,
	 valueTypeUUID: String)
	: tables.EntityScalarDataPropertyParticularRestrictionAxiom
	= tables.EntityScalarDataPropertyParticularRestrictionAxiom(
	  tables.taggedTypes.entityScalarDataPropertyParticularRestrictionAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.entityUUID(restrictedEntityUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(scalarPropertyUUID),
	  tables.LiteralValue.fromJSON(s"""{"literalType":"$literalValue_literalType","value":"$literalValue_value"}"""),
	  if (null == valueTypeUUID || valueTypeUUID.isEmpty) None else Some(tables.taggedTypes.dataRangeUUID(valueTypeUUID))
	)
	
	def EntityScalarDataPropertyUniversalRestrictionAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedEntityUUID"),
	  row.getAs[String]("scalarPropertyUUID"),
	  row.getAs[String]("scalarRestrictionUUID")
	)
	
	def EntityScalarDataPropertyUniversalRestrictionAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedEntityUUID: String,
	 scalarPropertyUUID: String,
	 scalarRestrictionUUID: String)
	: tables.EntityScalarDataPropertyUniversalRestrictionAxiom
	= tables.EntityScalarDataPropertyUniversalRestrictionAxiom(
	  tables.taggedTypes.entityScalarDataPropertyUniversalRestrictionAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.entityUUID(restrictedEntityUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(scalarPropertyUUID),
	  tables.taggedTypes.dataRangeUUID(scalarRestrictionUUID)
	)
	
	def EntityStructuredDataPropertyRow2Tuple
	(row: Row)
	: (String, String, String, String, Boolean, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[Boolean]("isIdentityCriteria"),
	  row.getAs[String]("name")
	)
	
	def EntityStructuredDataPropertyTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 domainUUID: String,
	 rangeUUID: String,
	 isIdentityCriteria: Boolean,
	 name: String)
	: tables.EntityStructuredDataProperty
	= tables.EntityStructuredDataProperty(
	  tables.taggedTypes.entityStructuredDataPropertyUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.entityUUID(domainUUID),
	  tables.taggedTypes.structureUUID(rangeUUID),
	  isIdentityCriteria,
	  tables.taggedTypes.localName(name)
	)
	
	def EntityStructuredDataPropertyParticularRestrictionAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("structuredDataPropertyUUID"),
	  row.getAs[String]("restrictedEntityUUID")
	)
	
	def EntityStructuredDataPropertyParticularRestrictionAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 structuredDataPropertyUUID: String,
	 restrictedEntityUUID: String)
	: tables.EntityStructuredDataPropertyParticularRestrictionAxiom
	= tables.EntityStructuredDataPropertyParticularRestrictionAxiom(
	  tables.taggedTypes.entityStructuredDataPropertyParticularRestrictionAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.dataRelationshipToStructureUUID(structuredDataPropertyUUID),
	  tables.taggedTypes.entityUUID(restrictedEntityUUID)
	)
	
	def EntityUniversalRestrictionAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRelationUUID"),
	  row.getAs[String]("restrictedDomainUUID"),
	  row.getAs[String]("restrictedRangeUUID")
	)
	
	def EntityUniversalRestrictionAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedRelationUUID: String,
	 restrictedDomainUUID: String,
	 restrictedRangeUUID: String)
	: tables.EntityUniversalRestrictionAxiom
	= tables.EntityUniversalRestrictionAxiom(
	  tables.taggedTypes.entityUniversalRestrictionAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.entityRelationshipUUID(restrictedRelationUUID),
	  tables.taggedTypes.entityUUID(restrictedDomainUUID),
	  tables.taggedTypes.entityUUID(restrictedRangeUUID)
	)
	
	def IRIScalarRestrictionRow2Tuple
	(row: Row)
	: (String, String, String, String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("length"),
	  row.getAs[String]("minLength"),
	  row.getAs[String]("maxLength"),
	  row.getAs[String]("name"),
	  row.getAs[String]("pattern")
	)
	
	def IRIScalarRestrictionTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 length: String,
	 minLength: String,
	 maxLength: String,
	 name: String,
	 pattern: String)
	: tables.IRIScalarRestriction
	= tables.IRIScalarRestriction(
	  tables.taggedTypes.iriScalarRestrictionUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.dataRangeUUID(restrictedRangeUUID),
	  if (null == length || length.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(length)),
	  if (null == minLength || minLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(minLength)),
	  if (null == maxLength || maxLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(maxLength)),
	  tables.taggedTypes.localName(name),
	  if (null == pattern || pattern.isEmpty) None else Some(tables.taggedTypes.literalPattern(pattern))
	)
	
	def NumericScalarRestrictionRow2Tuple
	(row: Row)
	: (String, String, String, String, String, String, String, String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[GenericRowWithSchema]("minExclusive").getAs[String]("literalType"),row.getAs[GenericRowWithSchema]("minExclusive").getAs[String]("value"),
	  row.getAs[GenericRowWithSchema]("minInclusive").getAs[String]("literalType"),row.getAs[GenericRowWithSchema]("minInclusive").getAs[String]("value"),
	  row.getAs[GenericRowWithSchema]("maxExclusive").getAs[String]("literalType"),row.getAs[GenericRowWithSchema]("maxExclusive").getAs[String]("value"),
	  row.getAs[GenericRowWithSchema]("maxInclusive").getAs[String]("literalType"),row.getAs[GenericRowWithSchema]("maxInclusive").getAs[String]("value"),
	  row.getAs[String]("name")
	)
	
	def NumericScalarRestrictionTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 minExclusive_literalType: String, minExclusive_value: String,
	 minInclusive_literalType: String, minInclusive_value: String,
	 maxExclusive_literalType: String, maxExclusive_value: String,
	 maxInclusive_literalType: String, maxInclusive_value: String,
	 name: String)
	: tables.NumericScalarRestriction
	= tables.NumericScalarRestriction(
	  tables.taggedTypes.numericScalarRestrictionUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.dataRangeUUID(restrictedRangeUUID),
	  if ((null == minExclusive_literalType || minExclusive_literalType.isEmpty) && (null == minExclusive_value || minExclusive_value.isEmpty)) None else Some(tables.LiteralNumber.fromJSON(s"""{"literalType":"$minExclusive_literalType","value":"$minExclusive_value"}""")),
	  if ((null == minInclusive_literalType || minInclusive_literalType.isEmpty) && (null == minInclusive_value || minInclusive_value.isEmpty)) None else Some(tables.LiteralNumber.fromJSON(s"""{"literalType":"$minInclusive_literalType","value":"$minInclusive_value"}""")),
	  if ((null == maxExclusive_literalType || maxExclusive_literalType.isEmpty) && (null == maxExclusive_value || maxExclusive_value.isEmpty)) None else Some(tables.LiteralNumber.fromJSON(s"""{"literalType":"$maxExclusive_literalType","value":"$maxExclusive_value"}""")),
	  if ((null == maxInclusive_literalType || maxInclusive_literalType.isEmpty) && (null == maxInclusive_value || maxInclusive_value.isEmpty)) None else Some(tables.LiteralNumber.fromJSON(s"""{"literalType":"$maxInclusive_literalType","value":"$maxInclusive_value"}""")),
	  tables.taggedTypes.localName(name)
	)
	
	def PlainLiteralScalarRestrictionRow2Tuple
	(row: Row)
	: (String, String, String, String, String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("length"),
	  row.getAs[String]("minLength"),
	  row.getAs[String]("maxLength"),
	  row.getAs[String]("name"),
	  row.getAs[String]("langRange"),
	  row.getAs[String]("pattern")
	)
	
	def PlainLiteralScalarRestrictionTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 length: String,
	 minLength: String,
	 maxLength: String,
	 name: String,
	 langRange: String,
	 pattern: String)
	: tables.PlainLiteralScalarRestriction
	= tables.PlainLiteralScalarRestriction(
	  tables.taggedTypes.plainLiteralScalarRestrictionUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.dataRangeUUID(restrictedRangeUUID),
	  if (null == length || length.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(length)),
	  if (null == minLength || minLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(minLength)),
	  if (null == maxLength || maxLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(maxLength)),
	  tables.taggedTypes.localName(name),
	  if (null == langRange || langRange.isEmpty) None else Some(tables.taggedTypes.languageTagDataType(langRange)),
	  if (null == pattern || pattern.isEmpty) None else Some(tables.taggedTypes.literalPattern(pattern))
	)
	
	def ReifiedRelationshipRow2Tuple
	(row: Row)
	: (String, String, String, String, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("sourceUUID"),
	  row.getAs[String]("targetUUID"),
	  row.getAs[Boolean]("isAsymmetric"),
	  row.getAs[Boolean]("isEssential"),
	  row.getAs[Boolean]("isFunctional"),
	  row.getAs[Boolean]("isInverseEssential"),
	  row.getAs[Boolean]("isInverseFunctional"),
	  row.getAs[Boolean]("isIrreflexive"),
	  row.getAs[Boolean]("isReflexive"),
	  row.getAs[Boolean]("isSymmetric"),
	  row.getAs[Boolean]("isTransitive"),
	  row.getAs[String]("name"),
	  row.getAs[String]("unreifiedPropertyName"),
	  row.getAs[String]("unreifiedInversePropertyName")
	)
	
	def ReifiedRelationshipTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 sourceUUID: String,
	 targetUUID: String,
	 isAsymmetric: Boolean,
	 isEssential: Boolean,
	 isFunctional: Boolean,
	 isInverseEssential: Boolean,
	 isInverseFunctional: Boolean,
	 isIrreflexive: Boolean,
	 isReflexive: Boolean,
	 isSymmetric: Boolean,
	 isTransitive: Boolean,
	 name: String,
	 unreifiedPropertyName: String,
	 unreifiedInversePropertyName: String)
	: tables.ReifiedRelationship
	= tables.ReifiedRelationship(
	  tables.taggedTypes.reifiedRelationshipUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.entityUUID(sourceUUID),
	  tables.taggedTypes.entityUUID(targetUUID),
	  isAsymmetric,
	  isEssential,
	  isFunctional,
	  isInverseEssential,
	  isInverseFunctional,
	  isIrreflexive,
	  isReflexive,
	  isSymmetric,
	  isTransitive,
	  tables.taggedTypes.localName(name),
	  tables.taggedTypes.localName(unreifiedPropertyName),
	  if (null == unreifiedInversePropertyName || unreifiedInversePropertyName.isEmpty) None else Some(tables.taggedTypes.localName(unreifiedInversePropertyName))
	)
	
	def ReifiedRelationshipInstanceRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonReifiedRelationshipClassifierUUID"),
	  row.getAs[String]("name")
	)
	
	def ReifiedRelationshipInstanceTuple2Type
	(uuid: String,
	 descriptionBoxUUID: String,
	 singletonReifiedRelationshipClassifierUUID: String,
	 name: String)
	: tables.ReifiedRelationshipInstance
	= tables.ReifiedRelationshipInstance(
	  tables.taggedTypes.reifiedRelationshipInstanceUUID(uuid),
	  tables.taggedTypes.descriptionBoxUUID(descriptionBoxUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(singletonReifiedRelationshipClassifierUUID),
	  tables.taggedTypes.localName(name)
	)
	
	def ReifiedRelationshipInstanceDomainRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("reifiedRelationshipInstanceUUID"),
	  row.getAs[String]("domainUUID")
	)
	
	def ReifiedRelationshipInstanceDomainTuple2Type
	(uuid: String,
	 descriptionBoxUUID: String,
	 reifiedRelationshipInstanceUUID: String,
	 domainUUID: String)
	: tables.ReifiedRelationshipInstanceDomain
	= tables.ReifiedRelationshipInstanceDomain(
	  tables.taggedTypes.reifiedRelationshipInstanceDomainUUID(uuid),
	  tables.taggedTypes.descriptionBoxUUID(descriptionBoxUUID),
	  tables.taggedTypes.reifiedRelationshipInstanceUUID(reifiedRelationshipInstanceUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(domainUUID)
	)
	
	def ReifiedRelationshipInstanceRangeRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("reifiedRelationshipInstanceUUID"),
	  row.getAs[String]("rangeUUID")
	)
	
	def ReifiedRelationshipInstanceRangeTuple2Type
	(uuid: String,
	 descriptionBoxUUID: String,
	 reifiedRelationshipInstanceUUID: String,
	 rangeUUID: String)
	: tables.ReifiedRelationshipInstanceRange
	= tables.ReifiedRelationshipInstanceRange(
	  tables.taggedTypes.reifiedRelationshipInstanceRangeUUID(uuid),
	  tables.taggedTypes.descriptionBoxUUID(descriptionBoxUUID),
	  tables.taggedTypes.reifiedRelationshipInstanceUUID(reifiedRelationshipInstanceUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(rangeUUID)
	)
	
	def ReifiedRelationshipInversePropertyPredicateRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
	
	def ReifiedRelationshipInversePropertyPredicateTuple2Type
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)
	: tables.ReifiedRelationshipInversePropertyPredicate
	= tables.ReifiedRelationshipInversePropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipInversePropertyPredicateUUID(uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(reifiedRelationshipUUID)
	)
	
	def ReifiedRelationshipPredicateRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
	
	def ReifiedRelationshipPredicateTuple2Type
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)
	: tables.ReifiedRelationshipPredicate
	= tables.ReifiedRelationshipPredicate(
	  tables.taggedTypes.reifiedRelationshipPredicateUUID(uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(reifiedRelationshipUUID)
	)
	
	def ReifiedRelationshipPropertyPredicateRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
	
	def ReifiedRelationshipPropertyPredicateTuple2Type
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)
	: tables.ReifiedRelationshipPropertyPredicate
	= tables.ReifiedRelationshipPropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipPropertyPredicateUUID(uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(reifiedRelationshipUUID)
	)
	
	def ReifiedRelationshipSourceInversePropertyPredicateRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
	
	def ReifiedRelationshipSourceInversePropertyPredicateTuple2Type
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)
	: tables.ReifiedRelationshipSourceInversePropertyPredicate
	= tables.ReifiedRelationshipSourceInversePropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipSourceInversePropertyPredicateUUID(uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(reifiedRelationshipUUID)
	)
	
	def ReifiedRelationshipSourcePropertyPredicateRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
	
	def ReifiedRelationshipSourcePropertyPredicateTuple2Type
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)
	: tables.ReifiedRelationshipSourcePropertyPredicate
	= tables.ReifiedRelationshipSourcePropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipSourcePropertyPredicateUUID(uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(reifiedRelationshipUUID)
	)
	
	def ReifiedRelationshipSpecializationAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("superRelationshipUUID"),
	  row.getAs[String]("subRelationshipUUID")
	)
	
	def ReifiedRelationshipSpecializationAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 superRelationshipUUID: String,
	 subRelationshipUUID: String)
	: tables.ReifiedRelationshipSpecializationAxiom
	= tables.ReifiedRelationshipSpecializationAxiom(
	  tables.taggedTypes.reifiedRelationshipSpecializationAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(superRelationshipUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(subRelationshipUUID)
	)
	
	def ReifiedRelationshipTargetInversePropertyPredicateRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
	
	def ReifiedRelationshipTargetInversePropertyPredicateTuple2Type
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)
	: tables.ReifiedRelationshipTargetInversePropertyPredicate
	= tables.ReifiedRelationshipTargetInversePropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipTargetInversePropertyPredicateUUID(uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(reifiedRelationshipUUID)
	)
	
	def ReifiedRelationshipTargetPropertyPredicateRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
	
	def ReifiedRelationshipTargetPropertyPredicateTuple2Type
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)
	: tables.ReifiedRelationshipTargetPropertyPredicate
	= tables.ReifiedRelationshipTargetPropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipTargetPropertyPredicateUUID(uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(reifiedRelationshipUUID)
	)
	
	def RestrictionScalarDataPropertyValueRow2Tuple
	(row: Row)
	: (String, String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("scalarDataPropertyUUID"),
	  row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("literalType"),row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("value"),
	  row.getAs[String]("structuredDataPropertyContextUUID"),
	  row.getAs[String]("valueTypeUUID")
	)
	
	def RestrictionScalarDataPropertyValueTuple2Type
	(uuid: String,
	 scalarDataPropertyUUID: String,
	 scalarPropertyValue_literalType: String, scalarPropertyValue_value: String,
	 structuredDataPropertyContextUUID: String,
	 valueTypeUUID: String)
	: tables.RestrictionScalarDataPropertyValue
	= tables.RestrictionScalarDataPropertyValue(
	  tables.taggedTypes.restrictionScalarDataPropertyValueUUID(uuid),
	  tables.taggedTypes.dataRelationshipToScalarUUID(scalarDataPropertyUUID),
	  tables.LiteralValue.fromJSON(s"""{"literalType":"$scalarPropertyValue_literalType","value":"$scalarPropertyValue_value"}"""),
	  tables.taggedTypes.restrictionStructuredDataPropertyContextUUID(structuredDataPropertyContextUUID),
	  if (null == valueTypeUUID || valueTypeUUID.isEmpty) None else Some(tables.taggedTypes.dataRangeUUID(valueTypeUUID))
	)
	
	def RestrictionStructuredDataPropertyTupleRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("structuredDataPropertyUUID"),
	  row.getAs[String]("structuredDataPropertyContextUUID")
	)
	
	def RestrictionStructuredDataPropertyTupleTuple2Type
	(uuid: String,
	 structuredDataPropertyUUID: String,
	 structuredDataPropertyContextUUID: String)
	: tables.RestrictionStructuredDataPropertyTuple
	= tables.RestrictionStructuredDataPropertyTuple(
	  tables.taggedTypes.restrictionStructuredDataPropertyTupleUUID(uuid),
	  tables.taggedTypes.dataRelationshipToStructureUUID(structuredDataPropertyUUID),
	  tables.taggedTypes.restrictionStructuredDataPropertyContextUUID(structuredDataPropertyContextUUID)
	)
	
	def RootConceptTaxonomyAxiomRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bundleUUID"),
	  row.getAs[String]("rootUUID")
	)
	
	def RootConceptTaxonomyAxiomTuple2Type
	(uuid: String,
	 bundleUUID: String,
	 rootUUID: String)
	: tables.RootConceptTaxonomyAxiom
	= tables.RootConceptTaxonomyAxiom(
	  tables.taggedTypes.rootConceptTaxonomyAxiomUUID(uuid),
	  tables.taggedTypes.bundleUUID(bundleUUID),
	  tables.taggedTypes.conceptUUID(rootUUID)
	)
	
	def RuleBodySegmentRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("previousSegmentUUID"),
	  row.getAs[String]("ruleUUID")
	)
	
	def RuleBodySegmentTuple2Type
	(uuid: String,
	 previousSegmentUUID: String,
	 ruleUUID: String)
	: tables.RuleBodySegment
	= tables.RuleBodySegment(
	  tables.taggedTypes.ruleBodySegmentUUID(uuid),
	  if (null == previousSegmentUUID || previousSegmentUUID.isEmpty) None else Some(tables.taggedTypes.ruleBodySegmentUUID(previousSegmentUUID)),
	  if (null == ruleUUID || ruleUUID.isEmpty) None else Some(tables.taggedTypes.chainRuleUUID(ruleUUID))
	)
	
	def ScalarRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)
	
	def ScalarTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 name: String)
	: tables.Scalar
	= tables.Scalar(
	  tables.taggedTypes.scalarUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.localName(name)
	)
	
	def ScalarDataPropertyRow2Tuple
	(row: Row)
	: (String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[String]("name")
	)
	
	def ScalarDataPropertyTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 domainUUID: String,
	 rangeUUID: String,
	 name: String)
	: tables.ScalarDataProperty
	= tables.ScalarDataProperty(
	  tables.taggedTypes.scalarDataPropertyUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.structureUUID(domainUUID),
	  tables.taggedTypes.dataRangeUUID(rangeUUID),
	  tables.taggedTypes.localName(name)
	)
	
	def ScalarDataPropertyValueRow2Tuple
	(row: Row)
	: (String, String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("scalarDataPropertyUUID"),
	  row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("literalType"),row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("value"),
	  row.getAs[String]("structuredDataPropertyContextUUID"),
	  row.getAs[String]("valueTypeUUID")
	)
	
	def ScalarDataPropertyValueTuple2Type
	(uuid: String,
	 scalarDataPropertyUUID: String,
	 scalarPropertyValue_literalType: String, scalarPropertyValue_value: String,
	 structuredDataPropertyContextUUID: String,
	 valueTypeUUID: String)
	: tables.ScalarDataPropertyValue
	= tables.ScalarDataPropertyValue(
	  tables.taggedTypes.scalarDataPropertyValueUUID(uuid),
	  tables.taggedTypes.dataRelationshipToScalarUUID(scalarDataPropertyUUID),
	  tables.LiteralValue.fromJSON(s"""{"literalType":"$scalarPropertyValue_literalType","value":"$scalarPropertyValue_value"}"""),
	  tables.taggedTypes.singletonInstanceStructuredDataPropertyContextUUID(structuredDataPropertyContextUUID),
	  if (null == valueTypeUUID || valueTypeUUID.isEmpty) None else Some(tables.taggedTypes.dataRangeUUID(valueTypeUUID))
	)
	
	def ScalarOneOfLiteralAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("axiomUUID"),
	  row.getAs[GenericRowWithSchema]("value").getAs[String]("literalType"),row.getAs[GenericRowWithSchema]("value").getAs[String]("value"),
	  row.getAs[String]("valueTypeUUID")
	)
	
	def ScalarOneOfLiteralAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 axiomUUID: String,
	 value_literalType: String, value_value: String,
	 valueTypeUUID: String)
	: tables.ScalarOneOfLiteralAxiom
	= tables.ScalarOneOfLiteralAxiom(
	  tables.taggedTypes.scalarOneOfLiteralAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.scalarOneOfRestrictionUUID(axiomUUID),
	  tables.LiteralValue.fromJSON(s"""{"literalType":"$value_literalType","value":"$value_value"}"""),
	  if (null == valueTypeUUID || valueTypeUUID.isEmpty) None else Some(tables.taggedTypes.dataRangeUUID(valueTypeUUID))
	)
	
	def ScalarOneOfRestrictionRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("name")
	)
	
	def ScalarOneOfRestrictionTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 name: String)
	: tables.ScalarOneOfRestriction
	= tables.ScalarOneOfRestriction(
	  tables.taggedTypes.scalarOneOfRestrictionUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.dataRangeUUID(restrictedRangeUUID),
	  tables.taggedTypes.localName(name)
	)
	
	def SingletonInstanceScalarDataPropertyValueRow2Tuple
	(row: Row)
	: (String, String, String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonInstanceUUID"),
	  row.getAs[String]("scalarDataPropertyUUID"),
	  row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("literalType"),row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("value"),
	  row.getAs[String]("valueTypeUUID")
	)
	
	def SingletonInstanceScalarDataPropertyValueTuple2Type
	(uuid: String,
	 descriptionBoxUUID: String,
	 singletonInstanceUUID: String,
	 scalarDataPropertyUUID: String,
	 scalarPropertyValue_literalType: String, scalarPropertyValue_value: String,
	 valueTypeUUID: String)
	: tables.SingletonInstanceScalarDataPropertyValue
	= tables.SingletonInstanceScalarDataPropertyValue(
	  tables.taggedTypes.singletonInstanceScalarDataPropertyValueUUID(uuid),
	  tables.taggedTypes.descriptionBoxUUID(descriptionBoxUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(singletonInstanceUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(scalarDataPropertyUUID),
	  tables.LiteralValue.fromJSON(s"""{"literalType":"$scalarPropertyValue_literalType","value":"$scalarPropertyValue_value"}"""),
	  if (null == valueTypeUUID || valueTypeUUID.isEmpty) None else Some(tables.taggedTypes.dataRangeUUID(valueTypeUUID))
	)
	
	def SingletonInstanceStructuredDataPropertyValueRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonInstanceUUID"),
	  row.getAs[String]("structuredDataPropertyUUID")
	)
	
	def SingletonInstanceStructuredDataPropertyValueTuple2Type
	(uuid: String,
	 descriptionBoxUUID: String,
	 singletonInstanceUUID: String,
	 structuredDataPropertyUUID: String)
	: tables.SingletonInstanceStructuredDataPropertyValue
	= tables.SingletonInstanceStructuredDataPropertyValue(
	  tables.taggedTypes.singletonInstanceStructuredDataPropertyValueUUID(uuid),
	  tables.taggedTypes.descriptionBoxUUID(descriptionBoxUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(singletonInstanceUUID),
	  tables.taggedTypes.dataRelationshipToStructureUUID(structuredDataPropertyUUID)
	)
	
	def SpecificDisjointConceptAxiomRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("disjointTaxonomyParentUUID"),
	  row.getAs[String]("disjointLeafUUID")
	)
	
	def SpecificDisjointConceptAxiomTuple2Type
	(uuid: String,
	 disjointTaxonomyParentUUID: String,
	 disjointLeafUUID: String)
	: tables.SpecificDisjointConceptAxiom
	= tables.SpecificDisjointConceptAxiom(
	  tables.taggedTypes.specificDisjointConceptAxiomUUID(uuid),
	  tables.taggedTypes.conceptTreeDisjunctionUUID(disjointTaxonomyParentUUID),
	  tables.taggedTypes.conceptUUID(disjointLeafUUID)
	)
	
	def StringScalarRestrictionRow2Tuple
	(row: Row)
	: (String, String, String, String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("length"),
	  row.getAs[String]("minLength"),
	  row.getAs[String]("maxLength"),
	  row.getAs[String]("name"),
	  row.getAs[String]("pattern")
	)
	
	def StringScalarRestrictionTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 length: String,
	 minLength: String,
	 maxLength: String,
	 name: String,
	 pattern: String)
	: tables.StringScalarRestriction
	= tables.StringScalarRestriction(
	  tables.taggedTypes.stringScalarRestrictionUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.dataRangeUUID(restrictedRangeUUID),
	  if (null == length || length.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(length)),
	  if (null == minLength || minLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(minLength)),
	  if (null == maxLength || maxLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(maxLength)),
	  tables.taggedTypes.localName(name),
	  if (null == pattern || pattern.isEmpty) None else Some(tables.taggedTypes.literalPattern(pattern))
	)
	
	def StructureRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)
	
	def StructureTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 name: String)
	: tables.Structure
	= tables.Structure(
	  tables.taggedTypes.structureUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.localName(name)
	)
	
	def StructuredDataPropertyRow2Tuple
	(row: Row)
	: (String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[String]("name")
	)
	
	def StructuredDataPropertyTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 domainUUID: String,
	 rangeUUID: String,
	 name: String)
	: tables.StructuredDataProperty
	= tables.StructuredDataProperty(
	  tables.taggedTypes.structuredDataPropertyUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.structureUUID(domainUUID),
	  tables.taggedTypes.structureUUID(rangeUUID),
	  tables.taggedTypes.localName(name)
	)
	
	def StructuredDataPropertyTupleRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("structuredDataPropertyUUID"),
	  row.getAs[String]("structuredDataPropertyContextUUID")
	)
	
	def StructuredDataPropertyTupleTuple2Type
	(uuid: String,
	 structuredDataPropertyUUID: String,
	 structuredDataPropertyContextUUID: String)
	: tables.StructuredDataPropertyTuple
	= tables.StructuredDataPropertyTuple(
	  tables.taggedTypes.structuredDataPropertyTupleUUID(uuid),
	  tables.taggedTypes.dataRelationshipToStructureUUID(structuredDataPropertyUUID),
	  tables.taggedTypes.singletonInstanceStructuredDataPropertyContextUUID(structuredDataPropertyContextUUID)
	)
	
	def SubDataPropertyOfAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("subPropertyUUID"),
	  row.getAs[String]("superPropertyUUID")
	)
	
	def SubDataPropertyOfAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 subPropertyUUID: String,
	 superPropertyUUID: String)
	: tables.SubDataPropertyOfAxiom
	= tables.SubDataPropertyOfAxiom(
	  tables.taggedTypes.subDataPropertyOfAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(subPropertyUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(superPropertyUUID)
	)
	
	def SubObjectPropertyOfAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("subPropertyUUID"),
	  row.getAs[String]("superPropertyUUID")
	)
	
	def SubObjectPropertyOfAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 subPropertyUUID: String,
	 superPropertyUUID: String)
	: tables.SubObjectPropertyOfAxiom
	= tables.SubObjectPropertyOfAxiom(
	  tables.taggedTypes.subObjectPropertyOfAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.unreifiedRelationshipUUID(subPropertyUUID),
	  tables.taggedTypes.unreifiedRelationshipUUID(superPropertyUUID)
	)
	
	def SynonymScalarRestrictionRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("name")
	)
	
	def SynonymScalarRestrictionTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 name: String)
	: tables.SynonymScalarRestriction
	= tables.SynonymScalarRestriction(
	  tables.taggedTypes.synonymScalarRestrictionUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.dataRangeUUID(restrictedRangeUUID),
	  tables.taggedTypes.localName(name)
	)
	
	def TerminologyExtensionAxiomRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("extendedTerminologyIRI")
	)
	
	def TerminologyExtensionAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 extendedTerminologyIRI: String)
	: tables.TerminologyExtensionAxiom
	= tables.TerminologyExtensionAxiom(
	  tables.taggedTypes.terminologyExtensionAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.iri(extendedTerminologyIRI)
	)
	
	def TerminologyGraphRow2Tuple
	(row: Row)
	: (String, Int, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[Int]("kind"),
	  row.getAs[String]("iri")
	)
	
	def TerminologyGraphTuple2Type
	(uuid: String,
	 kind: Int,
	 iri: String)
	: tables.TerminologyGraph
	= tables.TerminologyGraph(
	  tables.taggedTypes.terminologyGraphUUID(uuid),
	  terminologyKind(kind),
	  tables.taggedTypes.iri(iri)
	)
	
	def TerminologyNestingAxiomRow2Tuple
	(row: Row)
	: (String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("nestingContextUUID"),
	  row.getAs[String]("nestingTerminologyIRI")
	)
	
	def TerminologyNestingAxiomTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 nestingContextUUID: String,
	 nestingTerminologyIRI: String)
	: tables.TerminologyNestingAxiom
	= tables.TerminologyNestingAxiom(
	  tables.taggedTypes.terminologyNestingAxiomUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.conceptUUID(nestingContextUUID),
	  tables.taggedTypes.iri(nestingTerminologyIRI)
	)
	
	def TimeScalarRestrictionRow2Tuple
	(row: Row)
	: (String, String, String, String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("minExclusive"),
	  row.getAs[String]("minInclusive"),
	  row.getAs[String]("maxExclusive"),
	  row.getAs[String]("maxInclusive"),
	  row.getAs[String]("name")
	)
	
	def TimeScalarRestrictionTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 minExclusive: String,
	 minInclusive: String,
	 maxExclusive: String,
	 maxInclusive: String,
	 name: String)
	: tables.TimeScalarRestriction
	= tables.TimeScalarRestriction(
	  tables.taggedTypes.timeScalarRestrictionUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.dataRangeUUID(restrictedRangeUUID),
	  if (minExclusive.isEmpty) None else tables.LiteralDateTime.parseDateTime(minExclusive),
	  if (minInclusive.isEmpty) None else tables.LiteralDateTime.parseDateTime(minInclusive),
	  if (maxExclusive.isEmpty) None else tables.LiteralDateTime.parseDateTime(maxExclusive),
	  if (maxInclusive.isEmpty) None else tables.LiteralDateTime.parseDateTime(maxInclusive),
	  tables.taggedTypes.localName(name)
	)
	
	def UnreifiedRelationshipRow2Tuple
	(row: Row)
	: (String, String, String, String, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("sourceUUID"),
	  row.getAs[String]("targetUUID"),
	  row.getAs[Boolean]("isAsymmetric"),
	  row.getAs[Boolean]("isEssential"),
	  row.getAs[Boolean]("isFunctional"),
	  row.getAs[Boolean]("isInverseEssential"),
	  row.getAs[Boolean]("isInverseFunctional"),
	  row.getAs[Boolean]("isIrreflexive"),
	  row.getAs[Boolean]("isReflexive"),
	  row.getAs[Boolean]("isSymmetric"),
	  row.getAs[Boolean]("isTransitive"),
	  row.getAs[String]("name")
	)
	
	def UnreifiedRelationshipTuple2Type
	(uuid: String,
	 tboxUUID: String,
	 sourceUUID: String,
	 targetUUID: String,
	 isAsymmetric: Boolean,
	 isEssential: Boolean,
	 isFunctional: Boolean,
	 isInverseEssential: Boolean,
	 isInverseFunctional: Boolean,
	 isIrreflexive: Boolean,
	 isReflexive: Boolean,
	 isSymmetric: Boolean,
	 isTransitive: Boolean,
	 name: String)
	: tables.UnreifiedRelationship
	= tables.UnreifiedRelationship(
	  tables.taggedTypes.unreifiedRelationshipUUID(uuid),
	  tables.taggedTypes.terminologyBoxUUID(tboxUUID),
	  tables.taggedTypes.entityUUID(sourceUUID),
	  tables.taggedTypes.entityUUID(targetUUID),
	  isAsymmetric,
	  isEssential,
	  isFunctional,
	  isInverseEssential,
	  isInverseFunctional,
	  isIrreflexive,
	  isReflexive,
	  isSymmetric,
	  isTransitive,
	  tables.taggedTypes.localName(name)
	)
	
	def UnreifiedRelationshipInstanceTupleRow2Tuple
	(row: Row)
	: (String, String, String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("unreifiedRelationshipUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID")
	)
	
	def UnreifiedRelationshipInstanceTupleTuple2Type
	(uuid: String,
	 descriptionBoxUUID: String,
	 unreifiedRelationshipUUID: String,
	 domainUUID: String,
	 rangeUUID: String)
	: tables.UnreifiedRelationshipInstanceTuple
	= tables.UnreifiedRelationshipInstanceTuple(
	  tables.taggedTypes.unreifiedRelationshipInstanceTupleUUID(uuid),
	  tables.taggedTypes.descriptionBoxUUID(descriptionBoxUUID),
	  tables.taggedTypes.unreifiedRelationshipUUID(unreifiedRelationshipUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(domainUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(rangeUUID)
	)
	
	def UnreifiedRelationshipInversePropertyPredicateRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("unreifiedRelationshipUUID"),
	  row.getAs[String]("bodySegmentUUID")
	)
	
	def UnreifiedRelationshipInversePropertyPredicateTuple2Type
	(uuid: String,
	 unreifiedRelationshipUUID: String,
	 bodySegmentUUID: String)
	: tables.UnreifiedRelationshipInversePropertyPredicate
	= tables.UnreifiedRelationshipInversePropertyPredicate(
	  tables.taggedTypes.unreifiedRelationshipInversePropertyPredicateUUID(uuid),
	  tables.taggedTypes.unreifiedRelationshipUUID(unreifiedRelationshipUUID),
	  tables.taggedTypes.ruleBodySegmentUUID(bodySegmentUUID)
	)
	
	def UnreifiedRelationshipPropertyPredicateRow2Tuple
	(row: Row)
	: (String, String, String)
	= (
	  row.getAs[String]("uuid"),
	  row.getAs[String]("unreifiedRelationshipUUID"),
	  row.getAs[String]("bodySegmentUUID")
	)
	
	def UnreifiedRelationshipPropertyPredicateTuple2Type
	(uuid: String,
	 unreifiedRelationshipUUID: String,
	 bodySegmentUUID: String)
	: tables.UnreifiedRelationshipPropertyPredicate
	= tables.UnreifiedRelationshipPropertyPredicate(
	  tables.taggedTypes.unreifiedRelationshipPropertyPredicateUUID(uuid),
	  tables.taggedTypes.unreifiedRelationshipUUID(unreifiedRelationshipUUID),
	  tables.taggedTypes.ruleBodySegmentUUID(bodySegmentUUID)
	)
	
}
