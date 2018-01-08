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
import scala.Predef.{identity,String}

object OMLReaders {
	
	def terminologyKind(kind: Int)
	: tables.TerminologyKind
	= kind match {
		case 0 =>
		  tables.OpenWorldDefinitions
		case 1 =>
		  tables.ClosedWorldDesignations
    }

	def terminologyKind(kind: tables.TerminologyKind)
	: Int
	= kind match {
		case tables.OpenWorldDefinitions =>
		  0
		case tables.ClosedWorldDesignations =>
		  1
    }

	def descriptionKind(kind: Int)
	: tables.DescriptionKind
	= kind match {
		case 0 =>
		  tables.Final
		case 1 =>
		  tables.Partial
    }

	def descriptionKind(kind: tables.DescriptionKind)
	: Int
	= kind match {
		case tables.Final =>
		  0
		case tables.Partial =>
		  1
    }

	case class AnnotationPropertyTuple
	(uuid: String,
	 moduleUUID: String,
	 iri: String,
	 abbrevIRI: String)

	def AnnotationPropertyRow2Tuple
	(row: Row)
	: AnnotationPropertyTuple
	= AnnotationPropertyTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("moduleUUID"),
	  row.getAs[String]("iri"),
	  row.getAs[String]("abbrevIRI")
	)

	def AnnotationPropertySQL2Tuple
	(row: Row)
	: AnnotationPropertyTuple
	= AnnotationPropertyTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("moduleUUID"),
	  row.getAs[String]("iri"),
	  row.getAs[String]("abbrevIRI")
	)
				
	def AnnotationPropertyTuple2Type
	(tuple: AnnotationPropertyTuple)
	: tables.AnnotationProperty
	= tables.AnnotationProperty(
	  tables.taggedTypes.annotationPropertyUUID(tuple.uuid),
	  tables.taggedTypes.moduleUUID(tuple.moduleUUID),
	  tables.taggedTypes.iri(tuple.iri),
	  tables.taggedTypes.abbrevIRI(tuple.abbrevIRI)
	)

	def AnnotationPropertyType2Tuple
	(e: tables.AnnotationProperty)
	: AnnotationPropertyTuple
	= AnnotationPropertyTuple(
	  e.uuid,
	  e.moduleUUID,
	  e.iri,
	  e.abbrevIRI
	)
	case class AnnotationPropertyValueTuple
	(uuid: String,
	 subjectUUID: String,
	 propertyUUID: String,
	 value: String)

	def AnnotationPropertyValueRow2Tuple
	(row: Row)
	: AnnotationPropertyValueTuple
	= AnnotationPropertyValueTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("subjectUUID"),
	  row.getAs[String]("propertyUUID"),
	  row.getAs[String]("value")
	)

	def AnnotationPropertyValueSQL2Tuple
	(row: Row)
	: AnnotationPropertyValueTuple
	= AnnotationPropertyValueTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("subjectUUID"),
	  row.getAs[String]("propertyUUID"),
	  row.getAs[String]("value")
	)
				
	def AnnotationPropertyValueTuple2Type
	(tuple: AnnotationPropertyValueTuple)
	: tables.AnnotationPropertyValue
	= tables.AnnotationPropertyValue(
	  tables.taggedTypes.annotationPropertyValueUUID(tuple.uuid),
	  tables.taggedTypes.logicalElementUUID(tuple.subjectUUID),
	  tables.taggedTypes.annotationPropertyUUID(tuple.propertyUUID),
	  tables.taggedTypes.stringDataType(tuple.value)
	)

	def AnnotationPropertyValueType2Tuple
	(e: tables.AnnotationPropertyValue)
	: AnnotationPropertyValueTuple
	= AnnotationPropertyValueTuple(
	  e.uuid,
	  e.subjectUUID,
	  e.propertyUUID,
	  e.value
	)
	case class AnonymousConceptUnionAxiomTuple
	(uuid: String,
	 disjointTaxonomyParentUUID: String,
	 name: String)

	def AnonymousConceptUnionAxiomRow2Tuple
	(row: Row)
	: AnonymousConceptUnionAxiomTuple
	= AnonymousConceptUnionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("disjointTaxonomyParentUUID"),
	  row.getAs[String]("name")
	)

	def AnonymousConceptUnionAxiomSQL2Tuple
	(row: Row)
	: AnonymousConceptUnionAxiomTuple
	= AnonymousConceptUnionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("disjointTaxonomyParentUUID"),
	  row.getAs[String]("name")
	)
				
	def AnonymousConceptUnionAxiomTuple2Type
	(tuple: AnonymousConceptUnionAxiomTuple)
	: tables.AnonymousConceptUnionAxiom
	= tables.AnonymousConceptUnionAxiom(
	  tables.taggedTypes.anonymousConceptUnionAxiomUUID(tuple.uuid),
	  tables.taggedTypes.conceptTreeDisjunctionUUID(tuple.disjointTaxonomyParentUUID),
	  tables.taggedTypes.localName(tuple.name)
	)

	def AnonymousConceptUnionAxiomType2Tuple
	(e: tables.AnonymousConceptUnionAxiom)
	: AnonymousConceptUnionAxiomTuple
	= AnonymousConceptUnionAxiomTuple(
	  e.uuid,
	  e.disjointTaxonomyParentUUID,
	  e.name
	)
	case class AspectTuple
	(uuid: String,
	 tboxUUID: String,
	 name: String)

	def AspectRow2Tuple
	(row: Row)
	: AspectTuple
	= AspectTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)

	def AspectSQL2Tuple
	(row: Row)
	: AspectTuple
	= AspectTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)
				
	def AspectTuple2Type
	(tuple: AspectTuple)
	: tables.Aspect
	= tables.Aspect(
	  tables.taggedTypes.aspectUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.localName(tuple.name)
	)

	def AspectType2Tuple
	(e: tables.Aspect)
	: AspectTuple
	= AspectTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.name
	)
	case class AspectPredicateTuple
	(uuid: String,
	 aspectUUID: String,
	 bodySegmentUUID: String)

	def AspectPredicateRow2Tuple
	(row: Row)
	: AspectPredicateTuple
	= AspectPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("aspectUUID"),
	  row.getAs[String]("bodySegmentUUID")
	)

	def AspectPredicateSQL2Tuple
	(row: Row)
	: AspectPredicateTuple
	= AspectPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("aspectUUID"),
	  row.getAs[String]("bodySegmentUUID")
	)
				
	def AspectPredicateTuple2Type
	(tuple: AspectPredicateTuple)
	: tables.AspectPredicate
	= tables.AspectPredicate(
	  tables.taggedTypes.aspectPredicateUUID(tuple.uuid),
	  tables.taggedTypes.aspectUUID(tuple.aspectUUID),
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.bodySegmentUUID)
	)

	def AspectPredicateType2Tuple
	(e: tables.AspectPredicate)
	: AspectPredicateTuple
	= AspectPredicateTuple(
	  e.uuid,
	  e.aspectUUID,
	  e.bodySegmentUUID
	)
	case class AspectSpecializationAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 superAspectUUID: String,
	 subEntityUUID: String)

	def AspectSpecializationAxiomRow2Tuple
	(row: Row)
	: AspectSpecializationAxiomTuple
	= AspectSpecializationAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("superAspectUUID"),
	  row.getAs[String]("subEntityUUID")
	)

	def AspectSpecializationAxiomSQL2Tuple
	(row: Row)
	: AspectSpecializationAxiomTuple
	= AspectSpecializationAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("superAspectUUID"),
	  row.getAs[String]("subEntityUUID")
	)
				
	def AspectSpecializationAxiomTuple2Type
	(tuple: AspectSpecializationAxiomTuple)
	: tables.AspectSpecializationAxiom
	= tables.AspectSpecializationAxiom(
	  tables.taggedTypes.aspectSpecializationAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.aspectUUID(tuple.superAspectUUID),
	  tables.taggedTypes.entityUUID(tuple.subEntityUUID)
	)

	def AspectSpecializationAxiomType2Tuple
	(e: tables.AspectSpecializationAxiom)
	: AspectSpecializationAxiomTuple
	= AspectSpecializationAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.superAspectUUID,
	  e.subEntityUUID
	)
	case class BinaryScalarRestrictionTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 length: String,
	 minLength: String,
	 maxLength: String,
	 name: String)

	def BinaryScalarRestrictionRow2Tuple
	(row: Row)
	: BinaryScalarRestrictionTuple
	= BinaryScalarRestrictionTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("length"),
	  row.getAs[String]("minLength"),
	  row.getAs[String]("maxLength"),
	  row.getAs[String]("name")
	)

	def BinaryScalarRestrictionSQL2Tuple
	(row: Row)
	: BinaryScalarRestrictionTuple
	= BinaryScalarRestrictionTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("length"),
	  row.getAs[String]("minLength"),
	  row.getAs[String]("maxLength"),
	  row.getAs[String]("name")
	)
				
	def BinaryScalarRestrictionTuple2Type
	(tuple: BinaryScalarRestrictionTuple)
	: tables.BinaryScalarRestriction
	= tables.BinaryScalarRestriction(
	  tables.taggedTypes.binaryScalarRestrictionUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.restrictedRangeUUID),
	  if (null == tuple.length || tuple.length.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.length)),
	  if (null == tuple.minLength || tuple.minLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.minLength)),
	  if (null == tuple.maxLength || tuple.maxLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.maxLength)),
	  tables.taggedTypes.localName(tuple.name)
	)

	def BinaryScalarRestrictionType2Tuple
	(e: tables.BinaryScalarRestriction)
	: BinaryScalarRestrictionTuple
	= BinaryScalarRestrictionTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedRangeUUID,
	  e.length.fold[String](null)(identity),
	  e.minLength.fold[String](null)(identity),
	  e.maxLength.fold[String](null)(identity),
	  e.name
	)
	case class BundleTuple
	(uuid: String,
	 kind: Int,
	 iri: String)

	def BundleRow2Tuple
	(row: Row)
	: BundleTuple
	= BundleTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[Int]("kind"),
	  row.getAs[String]("iri")
	)

	def BundleSQL2Tuple
	(row: Row)
	: BundleTuple
	= BundleTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[Int]("kind"),
	  row.getAs[String]("iri")
	)
				
	def BundleTuple2Type
	(tuple: BundleTuple)
	: tables.Bundle
	= tables.Bundle(
	  tables.taggedTypes.bundleUUID(tuple.uuid),
	  terminologyKind(tuple.kind),
	  tables.taggedTypes.iri(tuple.iri)
	)

	def BundleType2Tuple
	(e: tables.Bundle)
	: BundleTuple
	= BundleTuple(
	  e.uuid,
	  terminologyKind(e.kind),
	  e.iri
	)
	case class BundledTerminologyAxiomTuple
	(uuid: String,
	 bundleUUID: String,
	 bundledTerminologyIRI: String)

	def BundledTerminologyAxiomRow2Tuple
	(row: Row)
	: BundledTerminologyAxiomTuple
	= BundledTerminologyAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bundleUUID"),
	  row.getAs[String]("bundledTerminologyIRI")
	)

	def BundledTerminologyAxiomSQL2Tuple
	(row: Row)
	: BundledTerminologyAxiomTuple
	= BundledTerminologyAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bundleUUID"),
	  row.getAs[String]("bundledTerminologyIRI")
	)
				
	def BundledTerminologyAxiomTuple2Type
	(tuple: BundledTerminologyAxiomTuple)
	: tables.BundledTerminologyAxiom
	= tables.BundledTerminologyAxiom(
	  tables.taggedTypes.bundledTerminologyAxiomUUID(tuple.uuid),
	  tables.taggedTypes.bundleUUID(tuple.bundleUUID),
	  tables.taggedTypes.iri(tuple.bundledTerminologyIRI)
	)

	def BundledTerminologyAxiomType2Tuple
	(e: tables.BundledTerminologyAxiom)
	: BundledTerminologyAxiomTuple
	= BundledTerminologyAxiomTuple(
	  e.uuid,
	  e.bundleUUID,
	  e.bundledTerminologyIRI
	)
	case class ChainRuleTuple
	(uuid: String,
	 tboxUUID: String,
	 name: String,
	 headUUID: String)

	def ChainRuleRow2Tuple
	(row: Row)
	: ChainRuleTuple
	= ChainRuleTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name"),
	  row.getAs[String]("headUUID")
	)

	def ChainRuleSQL2Tuple
	(row: Row)
	: ChainRuleTuple
	= ChainRuleTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name"),
	  row.getAs[String]("headUUID")
	)
				
	def ChainRuleTuple2Type
	(tuple: ChainRuleTuple)
	: tables.ChainRule
	= tables.ChainRule(
	  tables.taggedTypes.chainRuleUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.localName(tuple.name),
	  tables.taggedTypes.unreifiedRelationshipUUID(tuple.headUUID)
	)

	def ChainRuleType2Tuple
	(e: tables.ChainRule)
	: ChainRuleTuple
	= ChainRuleTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.name,
	  e.headUUID
	)
	case class ConceptTuple
	(uuid: String,
	 tboxUUID: String,
	 name: String)

	def ConceptRow2Tuple
	(row: Row)
	: ConceptTuple
	= ConceptTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)

	def ConceptSQL2Tuple
	(row: Row)
	: ConceptTuple
	= ConceptTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)
				
	def ConceptTuple2Type
	(tuple: ConceptTuple)
	: tables.Concept
	= tables.Concept(
	  tables.taggedTypes.conceptUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.localName(tuple.name)
	)

	def ConceptType2Tuple
	(e: tables.Concept)
	: ConceptTuple
	= ConceptTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.name
	)
	case class ConceptDesignationTerminologyAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 designatedConceptUUID: String,
	 designatedTerminologyIRI: String)

	def ConceptDesignationTerminologyAxiomRow2Tuple
	(row: Row)
	: ConceptDesignationTerminologyAxiomTuple
	= ConceptDesignationTerminologyAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("designatedConceptUUID"),
	  row.getAs[String]("designatedTerminologyIRI")
	)

	def ConceptDesignationTerminologyAxiomSQL2Tuple
	(row: Row)
	: ConceptDesignationTerminologyAxiomTuple
	= ConceptDesignationTerminologyAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("designatedConceptUUID"),
	  row.getAs[String]("designatedTerminologyIRI")
	)
				
	def ConceptDesignationTerminologyAxiomTuple2Type
	(tuple: ConceptDesignationTerminologyAxiomTuple)
	: tables.ConceptDesignationTerminologyAxiom
	= tables.ConceptDesignationTerminologyAxiom(
	  tables.taggedTypes.conceptDesignationTerminologyAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.conceptUUID(tuple.designatedConceptUUID),
	  tables.taggedTypes.iri(tuple.designatedTerminologyIRI)
	)

	def ConceptDesignationTerminologyAxiomType2Tuple
	(e: tables.ConceptDesignationTerminologyAxiom)
	: ConceptDesignationTerminologyAxiomTuple
	= ConceptDesignationTerminologyAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.designatedConceptUUID,
	  e.designatedTerminologyIRI
	)
	case class ConceptInstanceTuple
	(uuid: String,
	 descriptionBoxUUID: String,
	 singletonConceptClassifierUUID: String,
	 name: String)

	def ConceptInstanceRow2Tuple
	(row: Row)
	: ConceptInstanceTuple
	= ConceptInstanceTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonConceptClassifierUUID"),
	  row.getAs[String]("name")
	)

	def ConceptInstanceSQL2Tuple
	(row: Row)
	: ConceptInstanceTuple
	= ConceptInstanceTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonConceptClassifierUUID"),
	  row.getAs[String]("name")
	)
				
	def ConceptInstanceTuple2Type
	(tuple: ConceptInstanceTuple)
	: tables.ConceptInstance
	= tables.ConceptInstance(
	  tables.taggedTypes.conceptInstanceUUID(tuple.uuid),
	  tables.taggedTypes.descriptionBoxUUID(tuple.descriptionBoxUUID),
	  tables.taggedTypes.conceptUUID(tuple.singletonConceptClassifierUUID),
	  tables.taggedTypes.localName(tuple.name)
	)

	def ConceptInstanceType2Tuple
	(e: tables.ConceptInstance)
	: ConceptInstanceTuple
	= ConceptInstanceTuple(
	  e.uuid,
	  e.descriptionBoxUUID,
	  e.singletonConceptClassifierUUID,
	  e.name
	)
	case class ConceptPredicateTuple
	(uuid: String,
	 bodySegmentUUID: String,
	 conceptUUID: String)

	def ConceptPredicateRow2Tuple
	(row: Row)
	: ConceptPredicateTuple
	= ConceptPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("conceptUUID")
	)

	def ConceptPredicateSQL2Tuple
	(row: Row)
	: ConceptPredicateTuple
	= ConceptPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("conceptUUID")
	)
				
	def ConceptPredicateTuple2Type
	(tuple: ConceptPredicateTuple)
	: tables.ConceptPredicate
	= tables.ConceptPredicate(
	  tables.taggedTypes.conceptPredicateUUID(tuple.uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.bodySegmentUUID),
	  tables.taggedTypes.conceptUUID(tuple.conceptUUID)
	)

	def ConceptPredicateType2Tuple
	(e: tables.ConceptPredicate)
	: ConceptPredicateTuple
	= ConceptPredicateTuple(
	  e.uuid,
	  e.bodySegmentUUID,
	  e.conceptUUID
	)
	case class ConceptSpecializationAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 superConceptUUID: String,
	 subConceptUUID: String)

	def ConceptSpecializationAxiomRow2Tuple
	(row: Row)
	: ConceptSpecializationAxiomTuple
	= ConceptSpecializationAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("superConceptUUID"),
	  row.getAs[String]("subConceptUUID")
	)

	def ConceptSpecializationAxiomSQL2Tuple
	(row: Row)
	: ConceptSpecializationAxiomTuple
	= ConceptSpecializationAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("superConceptUUID"),
	  row.getAs[String]("subConceptUUID")
	)
				
	def ConceptSpecializationAxiomTuple2Type
	(tuple: ConceptSpecializationAxiomTuple)
	: tables.ConceptSpecializationAxiom
	= tables.ConceptSpecializationAxiom(
	  tables.taggedTypes.conceptSpecializationAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.conceptUUID(tuple.superConceptUUID),
	  tables.taggedTypes.conceptUUID(tuple.subConceptUUID)
	)

	def ConceptSpecializationAxiomType2Tuple
	(e: tables.ConceptSpecializationAxiom)
	: ConceptSpecializationAxiomTuple
	= ConceptSpecializationAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.superConceptUUID,
	  e.subConceptUUID
	)
	case class DescriptionBoxTuple
	(uuid: String,
	 kind: Int,
	 iri: String)

	def DescriptionBoxRow2Tuple
	(row: Row)
	: DescriptionBoxTuple
	= DescriptionBoxTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[Int]("kind"),
	  row.getAs[String]("iri")
	)

	def DescriptionBoxSQL2Tuple
	(row: Row)
	: DescriptionBoxTuple
	= DescriptionBoxTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[Int]("kind"),
	  row.getAs[String]("iri")
	)
				
	def DescriptionBoxTuple2Type
	(tuple: DescriptionBoxTuple)
	: tables.DescriptionBox
	= tables.DescriptionBox(
	  tables.taggedTypes.descriptionBoxUUID(tuple.uuid),
	  descriptionKind(tuple.kind),
	  tables.taggedTypes.iri(tuple.iri)
	)

	def DescriptionBoxType2Tuple
	(e: tables.DescriptionBox)
	: DescriptionBoxTuple
	= DescriptionBoxTuple(
	  e.uuid,
	  descriptionKind(e.kind),
	  e.iri
	)
	case class DescriptionBoxExtendsClosedWorldDefinitionsTuple
	(uuid: String,
	 descriptionBoxUUID: String,
	 closedWorldDefinitionsIRI: String)

	def DescriptionBoxExtendsClosedWorldDefinitionsRow2Tuple
	(row: Row)
	: DescriptionBoxExtendsClosedWorldDefinitionsTuple
	= DescriptionBoxExtendsClosedWorldDefinitionsTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("closedWorldDefinitionsIRI")
	)

	def DescriptionBoxExtendsClosedWorldDefinitionsSQL2Tuple
	(row: Row)
	: DescriptionBoxExtendsClosedWorldDefinitionsTuple
	= DescriptionBoxExtendsClosedWorldDefinitionsTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("closedWorldDefinitionsIRI")
	)
				
	def DescriptionBoxExtendsClosedWorldDefinitionsTuple2Type
	(tuple: DescriptionBoxExtendsClosedWorldDefinitionsTuple)
	: tables.DescriptionBoxExtendsClosedWorldDefinitions
	= tables.DescriptionBoxExtendsClosedWorldDefinitions(
	  tables.taggedTypes.descriptionBoxExtendsClosedWorldDefinitionsUUID(tuple.uuid),
	  tables.taggedTypes.descriptionBoxUUID(tuple.descriptionBoxUUID),
	  tables.taggedTypes.iri(tuple.closedWorldDefinitionsIRI)
	)

	def DescriptionBoxExtendsClosedWorldDefinitionsType2Tuple
	(e: tables.DescriptionBoxExtendsClosedWorldDefinitions)
	: DescriptionBoxExtendsClosedWorldDefinitionsTuple
	= DescriptionBoxExtendsClosedWorldDefinitionsTuple(
	  e.uuid,
	  e.descriptionBoxUUID,
	  e.closedWorldDefinitionsIRI
	)
	case class DescriptionBoxRefinementTuple
	(uuid: String,
	 refiningDescriptionBoxUUID: String,
	 refinedDescriptionBoxIRI: String)

	def DescriptionBoxRefinementRow2Tuple
	(row: Row)
	: DescriptionBoxRefinementTuple
	= DescriptionBoxRefinementTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("refiningDescriptionBoxUUID"),
	  row.getAs[String]("refinedDescriptionBoxIRI")
	)

	def DescriptionBoxRefinementSQL2Tuple
	(row: Row)
	: DescriptionBoxRefinementTuple
	= DescriptionBoxRefinementTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("refiningDescriptionBoxUUID"),
	  row.getAs[String]("refinedDescriptionBoxIRI")
	)
				
	def DescriptionBoxRefinementTuple2Type
	(tuple: DescriptionBoxRefinementTuple)
	: tables.DescriptionBoxRefinement
	= tables.DescriptionBoxRefinement(
	  tables.taggedTypes.descriptionBoxRefinementUUID(tuple.uuid),
	  tables.taggedTypes.descriptionBoxUUID(tuple.refiningDescriptionBoxUUID),
	  tables.taggedTypes.iri(tuple.refinedDescriptionBoxIRI)
	)

	def DescriptionBoxRefinementType2Tuple
	(e: tables.DescriptionBoxRefinement)
	: DescriptionBoxRefinementTuple
	= DescriptionBoxRefinementTuple(
	  e.uuid,
	  e.refiningDescriptionBoxUUID,
	  e.refinedDescriptionBoxIRI
	)
	case class EntityExistentialRestrictionAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedRelationUUID: String,
	 restrictedDomainUUID: String,
	 restrictedRangeUUID: String)

	def EntityExistentialRestrictionAxiomRow2Tuple
	(row: Row)
	: EntityExistentialRestrictionAxiomTuple
	= EntityExistentialRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRelationUUID"),
	  row.getAs[String]("restrictedDomainUUID"),
	  row.getAs[String]("restrictedRangeUUID")
	)

	def EntityExistentialRestrictionAxiomSQL2Tuple
	(row: Row)
	: EntityExistentialRestrictionAxiomTuple
	= EntityExistentialRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRelationUUID"),
	  row.getAs[String]("restrictedDomainUUID"),
	  row.getAs[String]("restrictedRangeUUID")
	)
				
	def EntityExistentialRestrictionAxiomTuple2Type
	(tuple: EntityExistentialRestrictionAxiomTuple)
	: tables.EntityExistentialRestrictionAxiom
	= tables.EntityExistentialRestrictionAxiom(
	  tables.taggedTypes.entityExistentialRestrictionAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.entityRelationshipUUID(tuple.restrictedRelationUUID),
	  tables.taggedTypes.entityUUID(tuple.restrictedDomainUUID),
	  tables.taggedTypes.entityUUID(tuple.restrictedRangeUUID)
	)

	def EntityExistentialRestrictionAxiomType2Tuple
	(e: tables.EntityExistentialRestrictionAxiom)
	: EntityExistentialRestrictionAxiomTuple
	= EntityExistentialRestrictionAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedRelationUUID,
	  e.restrictedDomainUUID,
	  e.restrictedRangeUUID
	)
	case class EntityScalarDataPropertyTuple
	(uuid: String,
	 tboxUUID: String,
	 domainUUID: String,
	 rangeUUID: String,
	 isIdentityCriteria: Boolean,
	 name: String)

	def EntityScalarDataPropertyRow2Tuple
	(row: Row)
	: EntityScalarDataPropertyTuple
	= EntityScalarDataPropertyTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[Boolean]("isIdentityCriteria"),
	  row.getAs[String]("name")
	)

	def EntityScalarDataPropertySQL2Tuple
	(row: Row)
	: EntityScalarDataPropertyTuple
	= EntityScalarDataPropertyTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[Boolean]("isIdentityCriteria"),
	  row.getAs[String]("name")
	)
				
	def EntityScalarDataPropertyTuple2Type
	(tuple: EntityScalarDataPropertyTuple)
	: tables.EntityScalarDataProperty
	= tables.EntityScalarDataProperty(
	  tables.taggedTypes.entityScalarDataPropertyUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.entityUUID(tuple.domainUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.rangeUUID),
	  tuple.isIdentityCriteria,
	  tables.taggedTypes.localName(tuple.name)
	)

	def EntityScalarDataPropertyType2Tuple
	(e: tables.EntityScalarDataProperty)
	: EntityScalarDataPropertyTuple
	= EntityScalarDataPropertyTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.domainUUID,
	  e.rangeUUID,
	  e.isIdentityCriteria,
	  e.name
	)
	case class EntityScalarDataPropertyExistentialRestrictionAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedEntityUUID: String,
	 scalarPropertyUUID: String,
	 scalarRestrictionUUID: String)

	def EntityScalarDataPropertyExistentialRestrictionAxiomRow2Tuple
	(row: Row)
	: EntityScalarDataPropertyExistentialRestrictionAxiomTuple
	= EntityScalarDataPropertyExistentialRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedEntityUUID"),
	  row.getAs[String]("scalarPropertyUUID"),
	  row.getAs[String]("scalarRestrictionUUID")
	)

	def EntityScalarDataPropertyExistentialRestrictionAxiomSQL2Tuple
	(row: Row)
	: EntityScalarDataPropertyExistentialRestrictionAxiomTuple
	= EntityScalarDataPropertyExistentialRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedEntityUUID"),
	  row.getAs[String]("scalarPropertyUUID"),
	  row.getAs[String]("scalarRestrictionUUID")
	)
				
	def EntityScalarDataPropertyExistentialRestrictionAxiomTuple2Type
	(tuple: EntityScalarDataPropertyExistentialRestrictionAxiomTuple)
	: tables.EntityScalarDataPropertyExistentialRestrictionAxiom
	= tables.EntityScalarDataPropertyExistentialRestrictionAxiom(
	  tables.taggedTypes.entityScalarDataPropertyExistentialRestrictionAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.entityUUID(tuple.restrictedEntityUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(tuple.scalarPropertyUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.scalarRestrictionUUID)
	)

	def EntityScalarDataPropertyExistentialRestrictionAxiomType2Tuple
	(e: tables.EntityScalarDataPropertyExistentialRestrictionAxiom)
	: EntityScalarDataPropertyExistentialRestrictionAxiomTuple
	= EntityScalarDataPropertyExistentialRestrictionAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedEntityUUID,
	  e.scalarPropertyUUID,
	  e.scalarRestrictionUUID
	)
	case class EntityScalarDataPropertyParticularRestrictionAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedEntityUUID: String,
	 scalarPropertyUUID: String,
	 literalValue: String, literalValueLiteralType: String,
	 valueTypeUUID: String)

	def EntityScalarDataPropertyParticularRestrictionAxiomRow2Tuple
	(row: Row)
	: EntityScalarDataPropertyParticularRestrictionAxiomTuple
	= EntityScalarDataPropertyParticularRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedEntityUUID"),
	  row.getAs[String]("scalarPropertyUUID"),
	  row.getAs[GenericRowWithSchema]("literalValue").getAs[String]("value"),row.getAs[GenericRowWithSchema]("literalValue").getAs[String]("literalType"),
	  row.getAs[String]("valueTypeUUID")
	)

	def EntityScalarDataPropertyParticularRestrictionAxiomSQL2Tuple
	(row: Row)
	: EntityScalarDataPropertyParticularRestrictionAxiomTuple
	= EntityScalarDataPropertyParticularRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedEntityUUID"),
	  row.getAs[String]("scalarPropertyUUID"),
	  row.getAs[String]("literalValue"),row.getAs[String]("literalValueLiteralType"),
	  row.getAs[String]("valueTypeUUID")
	)
				
	def EntityScalarDataPropertyParticularRestrictionAxiomTuple2Type
	(tuple: EntityScalarDataPropertyParticularRestrictionAxiomTuple)
	: tables.EntityScalarDataPropertyParticularRestrictionAxiom
	= tables.EntityScalarDataPropertyParticularRestrictionAxiom(
	  tables.taggedTypes.entityScalarDataPropertyParticularRestrictionAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.entityUUID(tuple.restrictedEntityUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(tuple.scalarPropertyUUID),
	  tables.LiteralValue.fromJSON(s"""{"literalType":"${tuple.literalValueLiteralType}","value":"${tuple.literalValue}"}"""),
	  if (null == tuple.valueTypeUUID || tuple.valueTypeUUID.isEmpty) None else Some(tables.taggedTypes.dataRangeUUID(tuple.valueTypeUUID))
	)

	def EntityScalarDataPropertyParticularRestrictionAxiomType2Tuple
	(e: tables.EntityScalarDataPropertyParticularRestrictionAxiom)
	: EntityScalarDataPropertyParticularRestrictionAxiomTuple
	= EntityScalarDataPropertyParticularRestrictionAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedEntityUUID,
	  e.scalarPropertyUUID,
	  e.literalValue.value, e.literalValue.literalType.toString,
	  e.valueTypeUUID.fold[String](null)(identity)
	)
	case class EntityScalarDataPropertyUniversalRestrictionAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedEntityUUID: String,
	 scalarPropertyUUID: String,
	 scalarRestrictionUUID: String)

	def EntityScalarDataPropertyUniversalRestrictionAxiomRow2Tuple
	(row: Row)
	: EntityScalarDataPropertyUniversalRestrictionAxiomTuple
	= EntityScalarDataPropertyUniversalRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedEntityUUID"),
	  row.getAs[String]("scalarPropertyUUID"),
	  row.getAs[String]("scalarRestrictionUUID")
	)

	def EntityScalarDataPropertyUniversalRestrictionAxiomSQL2Tuple
	(row: Row)
	: EntityScalarDataPropertyUniversalRestrictionAxiomTuple
	= EntityScalarDataPropertyUniversalRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedEntityUUID"),
	  row.getAs[String]("scalarPropertyUUID"),
	  row.getAs[String]("scalarRestrictionUUID")
	)
				
	def EntityScalarDataPropertyUniversalRestrictionAxiomTuple2Type
	(tuple: EntityScalarDataPropertyUniversalRestrictionAxiomTuple)
	: tables.EntityScalarDataPropertyUniversalRestrictionAxiom
	= tables.EntityScalarDataPropertyUniversalRestrictionAxiom(
	  tables.taggedTypes.entityScalarDataPropertyUniversalRestrictionAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.entityUUID(tuple.restrictedEntityUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(tuple.scalarPropertyUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.scalarRestrictionUUID)
	)

	def EntityScalarDataPropertyUniversalRestrictionAxiomType2Tuple
	(e: tables.EntityScalarDataPropertyUniversalRestrictionAxiom)
	: EntityScalarDataPropertyUniversalRestrictionAxiomTuple
	= EntityScalarDataPropertyUniversalRestrictionAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedEntityUUID,
	  e.scalarPropertyUUID,
	  e.scalarRestrictionUUID
	)
	case class EntityStructuredDataPropertyTuple
	(uuid: String,
	 tboxUUID: String,
	 domainUUID: String,
	 rangeUUID: String,
	 isIdentityCriteria: Boolean,
	 name: String)

	def EntityStructuredDataPropertyRow2Tuple
	(row: Row)
	: EntityStructuredDataPropertyTuple
	= EntityStructuredDataPropertyTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[Boolean]("isIdentityCriteria"),
	  row.getAs[String]("name")
	)

	def EntityStructuredDataPropertySQL2Tuple
	(row: Row)
	: EntityStructuredDataPropertyTuple
	= EntityStructuredDataPropertyTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[Boolean]("isIdentityCriteria"),
	  row.getAs[String]("name")
	)
				
	def EntityStructuredDataPropertyTuple2Type
	(tuple: EntityStructuredDataPropertyTuple)
	: tables.EntityStructuredDataProperty
	= tables.EntityStructuredDataProperty(
	  tables.taggedTypes.entityStructuredDataPropertyUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.entityUUID(tuple.domainUUID),
	  tables.taggedTypes.structureUUID(tuple.rangeUUID),
	  tuple.isIdentityCriteria,
	  tables.taggedTypes.localName(tuple.name)
	)

	def EntityStructuredDataPropertyType2Tuple
	(e: tables.EntityStructuredDataProperty)
	: EntityStructuredDataPropertyTuple
	= EntityStructuredDataPropertyTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.domainUUID,
	  e.rangeUUID,
	  e.isIdentityCriteria,
	  e.name
	)
	case class EntityStructuredDataPropertyParticularRestrictionAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 structuredDataPropertyUUID: String,
	 restrictedEntityUUID: String)

	def EntityStructuredDataPropertyParticularRestrictionAxiomRow2Tuple
	(row: Row)
	: EntityStructuredDataPropertyParticularRestrictionAxiomTuple
	= EntityStructuredDataPropertyParticularRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("structuredDataPropertyUUID"),
	  row.getAs[String]("restrictedEntityUUID")
	)

	def EntityStructuredDataPropertyParticularRestrictionAxiomSQL2Tuple
	(row: Row)
	: EntityStructuredDataPropertyParticularRestrictionAxiomTuple
	= EntityStructuredDataPropertyParticularRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("structuredDataPropertyUUID"),
	  row.getAs[String]("restrictedEntityUUID")
	)
				
	def EntityStructuredDataPropertyParticularRestrictionAxiomTuple2Type
	(tuple: EntityStructuredDataPropertyParticularRestrictionAxiomTuple)
	: tables.EntityStructuredDataPropertyParticularRestrictionAxiom
	= tables.EntityStructuredDataPropertyParticularRestrictionAxiom(
	  tables.taggedTypes.entityStructuredDataPropertyParticularRestrictionAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.dataRelationshipToStructureUUID(tuple.structuredDataPropertyUUID),
	  tables.taggedTypes.entityUUID(tuple.restrictedEntityUUID)
	)

	def EntityStructuredDataPropertyParticularRestrictionAxiomType2Tuple
	(e: tables.EntityStructuredDataPropertyParticularRestrictionAxiom)
	: EntityStructuredDataPropertyParticularRestrictionAxiomTuple
	= EntityStructuredDataPropertyParticularRestrictionAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.structuredDataPropertyUUID,
	  e.restrictedEntityUUID
	)
	case class EntityUniversalRestrictionAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedRelationUUID: String,
	 restrictedDomainUUID: String,
	 restrictedRangeUUID: String)

	def EntityUniversalRestrictionAxiomRow2Tuple
	(row: Row)
	: EntityUniversalRestrictionAxiomTuple
	= EntityUniversalRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRelationUUID"),
	  row.getAs[String]("restrictedDomainUUID"),
	  row.getAs[String]("restrictedRangeUUID")
	)

	def EntityUniversalRestrictionAxiomSQL2Tuple
	(row: Row)
	: EntityUniversalRestrictionAxiomTuple
	= EntityUniversalRestrictionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRelationUUID"),
	  row.getAs[String]("restrictedDomainUUID"),
	  row.getAs[String]("restrictedRangeUUID")
	)
				
	def EntityUniversalRestrictionAxiomTuple2Type
	(tuple: EntityUniversalRestrictionAxiomTuple)
	: tables.EntityUniversalRestrictionAxiom
	= tables.EntityUniversalRestrictionAxiom(
	  tables.taggedTypes.entityUniversalRestrictionAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.entityRelationshipUUID(tuple.restrictedRelationUUID),
	  tables.taggedTypes.entityUUID(tuple.restrictedDomainUUID),
	  tables.taggedTypes.entityUUID(tuple.restrictedRangeUUID)
	)

	def EntityUniversalRestrictionAxiomType2Tuple
	(e: tables.EntityUniversalRestrictionAxiom)
	: EntityUniversalRestrictionAxiomTuple
	= EntityUniversalRestrictionAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedRelationUUID,
	  e.restrictedDomainUUID,
	  e.restrictedRangeUUID
	)
	case class IRIScalarRestrictionTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 length: String,
	 minLength: String,
	 maxLength: String,
	 name: String,
	 pattern: String)

	def IRIScalarRestrictionRow2Tuple
	(row: Row)
	: IRIScalarRestrictionTuple
	= IRIScalarRestrictionTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("length"),
	  row.getAs[String]("minLength"),
	  row.getAs[String]("maxLength"),
	  row.getAs[String]("name"),
	  row.getAs[String]("pattern")
	)

	def IRIScalarRestrictionSQL2Tuple
	(row: Row)
	: IRIScalarRestrictionTuple
	= IRIScalarRestrictionTuple(
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
	(tuple: IRIScalarRestrictionTuple)
	: tables.IRIScalarRestriction
	= tables.IRIScalarRestriction(
	  tables.taggedTypes.iriScalarRestrictionUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.restrictedRangeUUID),
	  if (null == tuple.length || tuple.length.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.length)),
	  if (null == tuple.minLength || tuple.minLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.minLength)),
	  if (null == tuple.maxLength || tuple.maxLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.maxLength)),
	  tables.taggedTypes.localName(tuple.name),
	  if (null == tuple.pattern || tuple.pattern.isEmpty) None else Some(tables.taggedTypes.literalPattern(tuple.pattern))
	)

	def IRIScalarRestrictionType2Tuple
	(e: tables.IRIScalarRestriction)
	: IRIScalarRestrictionTuple
	= IRIScalarRestrictionTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedRangeUUID,
	  e.length.fold[String](null)(identity),
	  e.minLength.fold[String](null)(identity),
	  e.maxLength.fold[String](null)(identity),
	  e.name,
	  e.pattern.fold[String](null)(identity)
	)
	case class NumericScalarRestrictionTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 minExclusive: String, minExclusiveLiteralType: String,
	 minInclusive: String, minInclusiveLiteralType: String,
	 maxExclusive: String, maxExclusiveLiteralType: String,
	 maxInclusive: String, maxInclusiveLiteralType: String,
	 name: String)

	def NumericScalarRestrictionRow2Tuple
	(row: Row)
	: NumericScalarRestrictionTuple
	= NumericScalarRestrictionTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[GenericRowWithSchema]("minExclusive").getAs[String]("value"),row.getAs[GenericRowWithSchema]("minExclusive").getAs[String]("literalType"),
	  row.getAs[GenericRowWithSchema]("minInclusive").getAs[String]("value"),row.getAs[GenericRowWithSchema]("minInclusive").getAs[String]("literalType"),
	  row.getAs[GenericRowWithSchema]("maxExclusive").getAs[String]("value"),row.getAs[GenericRowWithSchema]("maxExclusive").getAs[String]("literalType"),
	  row.getAs[GenericRowWithSchema]("maxInclusive").getAs[String]("value"),row.getAs[GenericRowWithSchema]("maxInclusive").getAs[String]("literalType"),
	  row.getAs[String]("name")
	)

	def NumericScalarRestrictionSQL2Tuple
	(row: Row)
	: NumericScalarRestrictionTuple
	= NumericScalarRestrictionTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("minExclusive"),row.getAs[String]("minExclusiveLiteralType"),
	  row.getAs[String]("minInclusive"),row.getAs[String]("minInclusiveLiteralType"),
	  row.getAs[String]("maxExclusive"),row.getAs[String]("maxExclusiveLiteralType"),
	  row.getAs[String]("maxInclusive"),row.getAs[String]("maxInclusiveLiteralType"),
	  row.getAs[String]("name")
	)
				
	def NumericScalarRestrictionTuple2Type
	(tuple: NumericScalarRestrictionTuple)
	: tables.NumericScalarRestriction
	= tables.NumericScalarRestriction(
	  tables.taggedTypes.numericScalarRestrictionUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.restrictedRangeUUID),
	  if ((null == tuple.minExclusiveLiteralType || tuple.minExclusiveLiteralType.isEmpty) && (null == tuple.minExclusive || tuple.minExclusive.isEmpty)) None else Some(tables.LiteralNumber.fromJSON(s"""{"literalType":"${tuple.minExclusiveLiteralType}","value":"${tuple.minExclusive}"}""")),
	  if ((null == tuple.minInclusiveLiteralType || tuple.minInclusiveLiteralType.isEmpty) && (null == tuple.minInclusive || tuple.minInclusive.isEmpty)) None else Some(tables.LiteralNumber.fromJSON(s"""{"literalType":"${tuple.minInclusiveLiteralType}","value":"${tuple.minInclusive}"}""")),
	  if ((null == tuple.maxExclusiveLiteralType || tuple.maxExclusiveLiteralType.isEmpty) && (null == tuple.maxExclusive || tuple.maxExclusive.isEmpty)) None else Some(tables.LiteralNumber.fromJSON(s"""{"literalType":"${tuple.maxExclusiveLiteralType}","value":"${tuple.maxExclusive}"}""")),
	  if ((null == tuple.maxInclusiveLiteralType || tuple.maxInclusiveLiteralType.isEmpty) && (null == tuple.maxInclusive || tuple.maxInclusive.isEmpty)) None else Some(tables.LiteralNumber.fromJSON(s"""{"literalType":"${tuple.maxInclusiveLiteralType}","value":"${tuple.maxInclusive}"}""")),
	  tables.taggedTypes.localName(tuple.name)
	)

	def NumericScalarRestrictionType2Tuple
	(e: tables.NumericScalarRestriction)
	: NumericScalarRestrictionTuple
	= NumericScalarRestrictionTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedRangeUUID,
	  e.minExclusive.fold[String](null) { n => n.value }, e.minExclusive.fold[String](null) { n => n.literalType.toString },
	  e.minInclusive.fold[String](null) { n => n.value }, e.minInclusive.fold[String](null) { n => n.literalType.toString },
	  e.maxExclusive.fold[String](null) { n => n.value }, e.maxExclusive.fold[String](null) { n => n.literalType.toString },
	  e.maxInclusive.fold[String](null) { n => n.value }, e.maxInclusive.fold[String](null) { n => n.literalType.toString },
	  e.name
	)
	case class PlainLiteralScalarRestrictionTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 length: String,
	 minLength: String,
	 maxLength: String,
	 name: String,
	 langRange: String,
	 pattern: String)

	def PlainLiteralScalarRestrictionRow2Tuple
	(row: Row)
	: PlainLiteralScalarRestrictionTuple
	= PlainLiteralScalarRestrictionTuple(
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

	def PlainLiteralScalarRestrictionSQL2Tuple
	(row: Row)
	: PlainLiteralScalarRestrictionTuple
	= PlainLiteralScalarRestrictionTuple(
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
	(tuple: PlainLiteralScalarRestrictionTuple)
	: tables.PlainLiteralScalarRestriction
	= tables.PlainLiteralScalarRestriction(
	  tables.taggedTypes.plainLiteralScalarRestrictionUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.restrictedRangeUUID),
	  if (null == tuple.length || tuple.length.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.length)),
	  if (null == tuple.minLength || tuple.minLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.minLength)),
	  if (null == tuple.maxLength || tuple.maxLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.maxLength)),
	  tables.taggedTypes.localName(tuple.name),
	  if (null == tuple.langRange || tuple.langRange.isEmpty) None else Some(tables.taggedTypes.languageTagDataType(tuple.langRange)),
	  if (null == tuple.pattern || tuple.pattern.isEmpty) None else Some(tables.taggedTypes.literalPattern(tuple.pattern))
	)

	def PlainLiteralScalarRestrictionType2Tuple
	(e: tables.PlainLiteralScalarRestriction)
	: PlainLiteralScalarRestrictionTuple
	= PlainLiteralScalarRestrictionTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedRangeUUID,
	  e.length.fold[String](null)(identity),
	  e.minLength.fold[String](null)(identity),
	  e.maxLength.fold[String](null)(identity),
	  e.name,
	  e.langRange.fold[String](null)(identity),
	  e.pattern.fold[String](null)(identity)
	)
	case class ReifiedRelationshipTuple
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

	def ReifiedRelationshipRow2Tuple
	(row: Row)
	: ReifiedRelationshipTuple
	= ReifiedRelationshipTuple(
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

	def ReifiedRelationshipSQL2Tuple
	(row: Row)
	: ReifiedRelationshipTuple
	= ReifiedRelationshipTuple(
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
	(tuple: ReifiedRelationshipTuple)
	: tables.ReifiedRelationship
	= tables.ReifiedRelationship(
	  tables.taggedTypes.reifiedRelationshipUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.entityUUID(tuple.sourceUUID),
	  tables.taggedTypes.entityUUID(tuple.targetUUID),
	  tuple.isAsymmetric,
	  tuple.isEssential,
	  tuple.isFunctional,
	  tuple.isInverseEssential,
	  tuple.isInverseFunctional,
	  tuple.isIrreflexive,
	  tuple.isReflexive,
	  tuple.isSymmetric,
	  tuple.isTransitive,
	  tables.taggedTypes.localName(tuple.name),
	  tables.taggedTypes.localName(tuple.unreifiedPropertyName),
	  if (null == tuple.unreifiedInversePropertyName || tuple.unreifiedInversePropertyName.isEmpty) None else Some(tables.taggedTypes.localName(tuple.unreifiedInversePropertyName))
	)

	def ReifiedRelationshipType2Tuple
	(e: tables.ReifiedRelationship)
	: ReifiedRelationshipTuple
	= ReifiedRelationshipTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.sourceUUID,
	  e.targetUUID,
	  e.isAsymmetric,
	  e.isEssential,
	  e.isFunctional,
	  e.isInverseEssential,
	  e.isInverseFunctional,
	  e.isIrreflexive,
	  e.isReflexive,
	  e.isSymmetric,
	  e.isTransitive,
	  e.name,
	  e.unreifiedPropertyName,
	  e.unreifiedInversePropertyName.fold[String](null)(identity)
	)
	case class ReifiedRelationshipInstanceTuple
	(uuid: String,
	 descriptionBoxUUID: String,
	 singletonReifiedRelationshipClassifierUUID: String,
	 name: String)

	def ReifiedRelationshipInstanceRow2Tuple
	(row: Row)
	: ReifiedRelationshipInstanceTuple
	= ReifiedRelationshipInstanceTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonReifiedRelationshipClassifierUUID"),
	  row.getAs[String]("name")
	)

	def ReifiedRelationshipInstanceSQL2Tuple
	(row: Row)
	: ReifiedRelationshipInstanceTuple
	= ReifiedRelationshipInstanceTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonReifiedRelationshipClassifierUUID"),
	  row.getAs[String]("name")
	)
				
	def ReifiedRelationshipInstanceTuple2Type
	(tuple: ReifiedRelationshipInstanceTuple)
	: tables.ReifiedRelationshipInstance
	= tables.ReifiedRelationshipInstance(
	  tables.taggedTypes.reifiedRelationshipInstanceUUID(tuple.uuid),
	  tables.taggedTypes.descriptionBoxUUID(tuple.descriptionBoxUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(tuple.singletonReifiedRelationshipClassifierUUID),
	  tables.taggedTypes.localName(tuple.name)
	)

	def ReifiedRelationshipInstanceType2Tuple
	(e: tables.ReifiedRelationshipInstance)
	: ReifiedRelationshipInstanceTuple
	= ReifiedRelationshipInstanceTuple(
	  e.uuid,
	  e.descriptionBoxUUID,
	  e.singletonReifiedRelationshipClassifierUUID,
	  e.name
	)
	case class ReifiedRelationshipInstanceDomainTuple
	(uuid: String,
	 descriptionBoxUUID: String,
	 reifiedRelationshipInstanceUUID: String,
	 domainUUID: String)

	def ReifiedRelationshipInstanceDomainRow2Tuple
	(row: Row)
	: ReifiedRelationshipInstanceDomainTuple
	= ReifiedRelationshipInstanceDomainTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("reifiedRelationshipInstanceUUID"),
	  row.getAs[String]("domainUUID")
	)

	def ReifiedRelationshipInstanceDomainSQL2Tuple
	(row: Row)
	: ReifiedRelationshipInstanceDomainTuple
	= ReifiedRelationshipInstanceDomainTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("reifiedRelationshipInstanceUUID"),
	  row.getAs[String]("domainUUID")
	)
				
	def ReifiedRelationshipInstanceDomainTuple2Type
	(tuple: ReifiedRelationshipInstanceDomainTuple)
	: tables.ReifiedRelationshipInstanceDomain
	= tables.ReifiedRelationshipInstanceDomain(
	  tables.taggedTypes.reifiedRelationshipInstanceDomainUUID(tuple.uuid),
	  tables.taggedTypes.descriptionBoxUUID(tuple.descriptionBoxUUID),
	  tables.taggedTypes.reifiedRelationshipInstanceUUID(tuple.reifiedRelationshipInstanceUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(tuple.domainUUID)
	)

	def ReifiedRelationshipInstanceDomainType2Tuple
	(e: tables.ReifiedRelationshipInstanceDomain)
	: ReifiedRelationshipInstanceDomainTuple
	= ReifiedRelationshipInstanceDomainTuple(
	  e.uuid,
	  e.descriptionBoxUUID,
	  e.reifiedRelationshipInstanceUUID,
	  e.domainUUID
	)
	case class ReifiedRelationshipInstanceRangeTuple
	(uuid: String,
	 descriptionBoxUUID: String,
	 reifiedRelationshipInstanceUUID: String,
	 rangeUUID: String)

	def ReifiedRelationshipInstanceRangeRow2Tuple
	(row: Row)
	: ReifiedRelationshipInstanceRangeTuple
	= ReifiedRelationshipInstanceRangeTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("reifiedRelationshipInstanceUUID"),
	  row.getAs[String]("rangeUUID")
	)

	def ReifiedRelationshipInstanceRangeSQL2Tuple
	(row: Row)
	: ReifiedRelationshipInstanceRangeTuple
	= ReifiedRelationshipInstanceRangeTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("reifiedRelationshipInstanceUUID"),
	  row.getAs[String]("rangeUUID")
	)
				
	def ReifiedRelationshipInstanceRangeTuple2Type
	(tuple: ReifiedRelationshipInstanceRangeTuple)
	: tables.ReifiedRelationshipInstanceRange
	= tables.ReifiedRelationshipInstanceRange(
	  tables.taggedTypes.reifiedRelationshipInstanceRangeUUID(tuple.uuid),
	  tables.taggedTypes.descriptionBoxUUID(tuple.descriptionBoxUUID),
	  tables.taggedTypes.reifiedRelationshipInstanceUUID(tuple.reifiedRelationshipInstanceUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(tuple.rangeUUID)
	)

	def ReifiedRelationshipInstanceRangeType2Tuple
	(e: tables.ReifiedRelationshipInstanceRange)
	: ReifiedRelationshipInstanceRangeTuple
	= ReifiedRelationshipInstanceRangeTuple(
	  e.uuid,
	  e.descriptionBoxUUID,
	  e.reifiedRelationshipInstanceUUID,
	  e.rangeUUID
	)
	case class ReifiedRelationshipInversePropertyPredicateTuple
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)

	def ReifiedRelationshipInversePropertyPredicateRow2Tuple
	(row: Row)
	: ReifiedRelationshipInversePropertyPredicateTuple
	= ReifiedRelationshipInversePropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)

	def ReifiedRelationshipInversePropertyPredicateSQL2Tuple
	(row: Row)
	: ReifiedRelationshipInversePropertyPredicateTuple
	= ReifiedRelationshipInversePropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
				
	def ReifiedRelationshipInversePropertyPredicateTuple2Type
	(tuple: ReifiedRelationshipInversePropertyPredicateTuple)
	: tables.ReifiedRelationshipInversePropertyPredicate
	= tables.ReifiedRelationshipInversePropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipInversePropertyPredicateUUID(tuple.uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(tuple.reifiedRelationshipUUID)
	)

	def ReifiedRelationshipInversePropertyPredicateType2Tuple
	(e: tables.ReifiedRelationshipInversePropertyPredicate)
	: ReifiedRelationshipInversePropertyPredicateTuple
	= ReifiedRelationshipInversePropertyPredicateTuple(
	  e.uuid,
	  e.bodySegmentUUID,
	  e.reifiedRelationshipUUID
	)
	case class ReifiedRelationshipPredicateTuple
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)

	def ReifiedRelationshipPredicateRow2Tuple
	(row: Row)
	: ReifiedRelationshipPredicateTuple
	= ReifiedRelationshipPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)

	def ReifiedRelationshipPredicateSQL2Tuple
	(row: Row)
	: ReifiedRelationshipPredicateTuple
	= ReifiedRelationshipPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
				
	def ReifiedRelationshipPredicateTuple2Type
	(tuple: ReifiedRelationshipPredicateTuple)
	: tables.ReifiedRelationshipPredicate
	= tables.ReifiedRelationshipPredicate(
	  tables.taggedTypes.reifiedRelationshipPredicateUUID(tuple.uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(tuple.reifiedRelationshipUUID)
	)

	def ReifiedRelationshipPredicateType2Tuple
	(e: tables.ReifiedRelationshipPredicate)
	: ReifiedRelationshipPredicateTuple
	= ReifiedRelationshipPredicateTuple(
	  e.uuid,
	  e.bodySegmentUUID,
	  e.reifiedRelationshipUUID
	)
	case class ReifiedRelationshipPropertyPredicateTuple
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)

	def ReifiedRelationshipPropertyPredicateRow2Tuple
	(row: Row)
	: ReifiedRelationshipPropertyPredicateTuple
	= ReifiedRelationshipPropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)

	def ReifiedRelationshipPropertyPredicateSQL2Tuple
	(row: Row)
	: ReifiedRelationshipPropertyPredicateTuple
	= ReifiedRelationshipPropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
				
	def ReifiedRelationshipPropertyPredicateTuple2Type
	(tuple: ReifiedRelationshipPropertyPredicateTuple)
	: tables.ReifiedRelationshipPropertyPredicate
	= tables.ReifiedRelationshipPropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipPropertyPredicateUUID(tuple.uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(tuple.reifiedRelationshipUUID)
	)

	def ReifiedRelationshipPropertyPredicateType2Tuple
	(e: tables.ReifiedRelationshipPropertyPredicate)
	: ReifiedRelationshipPropertyPredicateTuple
	= ReifiedRelationshipPropertyPredicateTuple(
	  e.uuid,
	  e.bodySegmentUUID,
	  e.reifiedRelationshipUUID
	)
	case class ReifiedRelationshipSourceInversePropertyPredicateTuple
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)

	def ReifiedRelationshipSourceInversePropertyPredicateRow2Tuple
	(row: Row)
	: ReifiedRelationshipSourceInversePropertyPredicateTuple
	= ReifiedRelationshipSourceInversePropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)

	def ReifiedRelationshipSourceInversePropertyPredicateSQL2Tuple
	(row: Row)
	: ReifiedRelationshipSourceInversePropertyPredicateTuple
	= ReifiedRelationshipSourceInversePropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
				
	def ReifiedRelationshipSourceInversePropertyPredicateTuple2Type
	(tuple: ReifiedRelationshipSourceInversePropertyPredicateTuple)
	: tables.ReifiedRelationshipSourceInversePropertyPredicate
	= tables.ReifiedRelationshipSourceInversePropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipSourceInversePropertyPredicateUUID(tuple.uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(tuple.reifiedRelationshipUUID)
	)

	def ReifiedRelationshipSourceInversePropertyPredicateType2Tuple
	(e: tables.ReifiedRelationshipSourceInversePropertyPredicate)
	: ReifiedRelationshipSourceInversePropertyPredicateTuple
	= ReifiedRelationshipSourceInversePropertyPredicateTuple(
	  e.uuid,
	  e.bodySegmentUUID,
	  e.reifiedRelationshipUUID
	)
	case class ReifiedRelationshipSourcePropertyPredicateTuple
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)

	def ReifiedRelationshipSourcePropertyPredicateRow2Tuple
	(row: Row)
	: ReifiedRelationshipSourcePropertyPredicateTuple
	= ReifiedRelationshipSourcePropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)

	def ReifiedRelationshipSourcePropertyPredicateSQL2Tuple
	(row: Row)
	: ReifiedRelationshipSourcePropertyPredicateTuple
	= ReifiedRelationshipSourcePropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
				
	def ReifiedRelationshipSourcePropertyPredicateTuple2Type
	(tuple: ReifiedRelationshipSourcePropertyPredicateTuple)
	: tables.ReifiedRelationshipSourcePropertyPredicate
	= tables.ReifiedRelationshipSourcePropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipSourcePropertyPredicateUUID(tuple.uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(tuple.reifiedRelationshipUUID)
	)

	def ReifiedRelationshipSourcePropertyPredicateType2Tuple
	(e: tables.ReifiedRelationshipSourcePropertyPredicate)
	: ReifiedRelationshipSourcePropertyPredicateTuple
	= ReifiedRelationshipSourcePropertyPredicateTuple(
	  e.uuid,
	  e.bodySegmentUUID,
	  e.reifiedRelationshipUUID
	)
	case class ReifiedRelationshipSpecializationAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 superRelationshipUUID: String,
	 subRelationshipUUID: String)

	def ReifiedRelationshipSpecializationAxiomRow2Tuple
	(row: Row)
	: ReifiedRelationshipSpecializationAxiomTuple
	= ReifiedRelationshipSpecializationAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("superRelationshipUUID"),
	  row.getAs[String]("subRelationshipUUID")
	)

	def ReifiedRelationshipSpecializationAxiomSQL2Tuple
	(row: Row)
	: ReifiedRelationshipSpecializationAxiomTuple
	= ReifiedRelationshipSpecializationAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("superRelationshipUUID"),
	  row.getAs[String]("subRelationshipUUID")
	)
				
	def ReifiedRelationshipSpecializationAxiomTuple2Type
	(tuple: ReifiedRelationshipSpecializationAxiomTuple)
	: tables.ReifiedRelationshipSpecializationAxiom
	= tables.ReifiedRelationshipSpecializationAxiom(
	  tables.taggedTypes.reifiedRelationshipSpecializationAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(tuple.superRelationshipUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(tuple.subRelationshipUUID)
	)

	def ReifiedRelationshipSpecializationAxiomType2Tuple
	(e: tables.ReifiedRelationshipSpecializationAxiom)
	: ReifiedRelationshipSpecializationAxiomTuple
	= ReifiedRelationshipSpecializationAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.superRelationshipUUID,
	  e.subRelationshipUUID
	)
	case class ReifiedRelationshipTargetInversePropertyPredicateTuple
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)

	def ReifiedRelationshipTargetInversePropertyPredicateRow2Tuple
	(row: Row)
	: ReifiedRelationshipTargetInversePropertyPredicateTuple
	= ReifiedRelationshipTargetInversePropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)

	def ReifiedRelationshipTargetInversePropertyPredicateSQL2Tuple
	(row: Row)
	: ReifiedRelationshipTargetInversePropertyPredicateTuple
	= ReifiedRelationshipTargetInversePropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
				
	def ReifiedRelationshipTargetInversePropertyPredicateTuple2Type
	(tuple: ReifiedRelationshipTargetInversePropertyPredicateTuple)
	: tables.ReifiedRelationshipTargetInversePropertyPredicate
	= tables.ReifiedRelationshipTargetInversePropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipTargetInversePropertyPredicateUUID(tuple.uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(tuple.reifiedRelationshipUUID)
	)

	def ReifiedRelationshipTargetInversePropertyPredicateType2Tuple
	(e: tables.ReifiedRelationshipTargetInversePropertyPredicate)
	: ReifiedRelationshipTargetInversePropertyPredicateTuple
	= ReifiedRelationshipTargetInversePropertyPredicateTuple(
	  e.uuid,
	  e.bodySegmentUUID,
	  e.reifiedRelationshipUUID
	)
	case class ReifiedRelationshipTargetPropertyPredicateTuple
	(uuid: String,
	 bodySegmentUUID: String,
	 reifiedRelationshipUUID: String)

	def ReifiedRelationshipTargetPropertyPredicateRow2Tuple
	(row: Row)
	: ReifiedRelationshipTargetPropertyPredicateTuple
	= ReifiedRelationshipTargetPropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)

	def ReifiedRelationshipTargetPropertyPredicateSQL2Tuple
	(row: Row)
	: ReifiedRelationshipTargetPropertyPredicateTuple
	= ReifiedRelationshipTargetPropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bodySegmentUUID"),
	  row.getAs[String]("reifiedRelationshipUUID")
	)
				
	def ReifiedRelationshipTargetPropertyPredicateTuple2Type
	(tuple: ReifiedRelationshipTargetPropertyPredicateTuple)
	: tables.ReifiedRelationshipTargetPropertyPredicate
	= tables.ReifiedRelationshipTargetPropertyPredicate(
	  tables.taggedTypes.reifiedRelationshipTargetPropertyPredicateUUID(tuple.uuid),
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.bodySegmentUUID),
	  tables.taggedTypes.reifiedRelationshipUUID(tuple.reifiedRelationshipUUID)
	)

	def ReifiedRelationshipTargetPropertyPredicateType2Tuple
	(e: tables.ReifiedRelationshipTargetPropertyPredicate)
	: ReifiedRelationshipTargetPropertyPredicateTuple
	= ReifiedRelationshipTargetPropertyPredicateTuple(
	  e.uuid,
	  e.bodySegmentUUID,
	  e.reifiedRelationshipUUID
	)
	case class RestrictionScalarDataPropertyValueTuple
	(uuid: String,
	 scalarDataPropertyUUID: String,
	 scalarPropertyValue: String, scalarPropertyValueLiteralType: String,
	 structuredDataPropertyContextUUID: String,
	 valueTypeUUID: String)

	def RestrictionScalarDataPropertyValueRow2Tuple
	(row: Row)
	: RestrictionScalarDataPropertyValueTuple
	= RestrictionScalarDataPropertyValueTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("scalarDataPropertyUUID"),
	  row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("value"),row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("literalType"),
	  row.getAs[String]("structuredDataPropertyContextUUID"),
	  row.getAs[String]("valueTypeUUID")
	)

	def RestrictionScalarDataPropertyValueSQL2Tuple
	(row: Row)
	: RestrictionScalarDataPropertyValueTuple
	= RestrictionScalarDataPropertyValueTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("scalarDataPropertyUUID"),
	  row.getAs[String]("scalarPropertyValue"),row.getAs[String]("scalarPropertyValueLiteralType"),
	  row.getAs[String]("structuredDataPropertyContextUUID"),
	  row.getAs[String]("valueTypeUUID")
	)
				
	def RestrictionScalarDataPropertyValueTuple2Type
	(tuple: RestrictionScalarDataPropertyValueTuple)
	: tables.RestrictionScalarDataPropertyValue
	= tables.RestrictionScalarDataPropertyValue(
	  tables.taggedTypes.restrictionScalarDataPropertyValueUUID(tuple.uuid),
	  tables.taggedTypes.dataRelationshipToScalarUUID(tuple.scalarDataPropertyUUID),
	  tables.LiteralValue.fromJSON(s"""{"literalType":"${tuple.scalarPropertyValueLiteralType}","value":"${tuple.scalarPropertyValue}"}"""),
	  tables.taggedTypes.restrictionStructuredDataPropertyContextUUID(tuple.structuredDataPropertyContextUUID),
	  if (null == tuple.valueTypeUUID || tuple.valueTypeUUID.isEmpty) None else Some(tables.taggedTypes.dataRangeUUID(tuple.valueTypeUUID))
	)

	def RestrictionScalarDataPropertyValueType2Tuple
	(e: tables.RestrictionScalarDataPropertyValue)
	: RestrictionScalarDataPropertyValueTuple
	= RestrictionScalarDataPropertyValueTuple(
	  e.uuid,
	  e.scalarDataPropertyUUID,
	  e.scalarPropertyValue.value, e.scalarPropertyValue.literalType.toString,
	  e.structuredDataPropertyContextUUID,
	  e.valueTypeUUID.fold[String](null)(identity)
	)
	case class RestrictionStructuredDataPropertyTupleTuple
	(uuid: String,
	 structuredDataPropertyUUID: String,
	 structuredDataPropertyContextUUID: String)

	def RestrictionStructuredDataPropertyTupleRow2Tuple
	(row: Row)
	: RestrictionStructuredDataPropertyTupleTuple
	= RestrictionStructuredDataPropertyTupleTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("structuredDataPropertyUUID"),
	  row.getAs[String]("structuredDataPropertyContextUUID")
	)

	def RestrictionStructuredDataPropertyTupleSQL2Tuple
	(row: Row)
	: RestrictionStructuredDataPropertyTupleTuple
	= RestrictionStructuredDataPropertyTupleTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("structuredDataPropertyUUID"),
	  row.getAs[String]("structuredDataPropertyContextUUID")
	)
				
	def RestrictionStructuredDataPropertyTupleTuple2Type
	(tuple: RestrictionStructuredDataPropertyTupleTuple)
	: tables.RestrictionStructuredDataPropertyTuple
	= tables.RestrictionStructuredDataPropertyTuple(
	  tables.taggedTypes.restrictionStructuredDataPropertyTupleUUID(tuple.uuid),
	  tables.taggedTypes.dataRelationshipToStructureUUID(tuple.structuredDataPropertyUUID),
	  tables.taggedTypes.restrictionStructuredDataPropertyContextUUID(tuple.structuredDataPropertyContextUUID)
	)

	def RestrictionStructuredDataPropertyTupleType2Tuple
	(e: tables.RestrictionStructuredDataPropertyTuple)
	: RestrictionStructuredDataPropertyTupleTuple
	= RestrictionStructuredDataPropertyTupleTuple(
	  e.uuid,
	  e.structuredDataPropertyUUID,
	  e.structuredDataPropertyContextUUID
	)
	case class RootConceptTaxonomyAxiomTuple
	(uuid: String,
	 bundleUUID: String,
	 rootUUID: String)

	def RootConceptTaxonomyAxiomRow2Tuple
	(row: Row)
	: RootConceptTaxonomyAxiomTuple
	= RootConceptTaxonomyAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bundleUUID"),
	  row.getAs[String]("rootUUID")
	)

	def RootConceptTaxonomyAxiomSQL2Tuple
	(row: Row)
	: RootConceptTaxonomyAxiomTuple
	= RootConceptTaxonomyAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("bundleUUID"),
	  row.getAs[String]("rootUUID")
	)
				
	def RootConceptTaxonomyAxiomTuple2Type
	(tuple: RootConceptTaxonomyAxiomTuple)
	: tables.RootConceptTaxonomyAxiom
	= tables.RootConceptTaxonomyAxiom(
	  tables.taggedTypes.rootConceptTaxonomyAxiomUUID(tuple.uuid),
	  tables.taggedTypes.bundleUUID(tuple.bundleUUID),
	  tables.taggedTypes.conceptUUID(tuple.rootUUID)
	)

	def RootConceptTaxonomyAxiomType2Tuple
	(e: tables.RootConceptTaxonomyAxiom)
	: RootConceptTaxonomyAxiomTuple
	= RootConceptTaxonomyAxiomTuple(
	  e.uuid,
	  e.bundleUUID,
	  e.rootUUID
	)
	case class RuleBodySegmentTuple
	(uuid: String,
	 previousSegmentUUID: String,
	 ruleUUID: String)

	def RuleBodySegmentRow2Tuple
	(row: Row)
	: RuleBodySegmentTuple
	= RuleBodySegmentTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("previousSegmentUUID"),
	  row.getAs[String]("ruleUUID")
	)

	def RuleBodySegmentSQL2Tuple
	(row: Row)
	: RuleBodySegmentTuple
	= RuleBodySegmentTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("previousSegmentUUID"),
	  row.getAs[String]("ruleUUID")
	)
				
	def RuleBodySegmentTuple2Type
	(tuple: RuleBodySegmentTuple)
	: tables.RuleBodySegment
	= tables.RuleBodySegment(
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.uuid),
	  if (null == tuple.previousSegmentUUID || tuple.previousSegmentUUID.isEmpty) None else Some(tables.taggedTypes.ruleBodySegmentUUID(tuple.previousSegmentUUID)),
	  if (null == tuple.ruleUUID || tuple.ruleUUID.isEmpty) None else Some(tables.taggedTypes.chainRuleUUID(tuple.ruleUUID))
	)

	def RuleBodySegmentType2Tuple
	(e: tables.RuleBodySegment)
	: RuleBodySegmentTuple
	= RuleBodySegmentTuple(
	  e.uuid,
	  e.previousSegmentUUID.fold[String](null)(identity),
	  e.ruleUUID.fold[String](null)(identity)
	)
	case class ScalarTuple
	(uuid: String,
	 tboxUUID: String,
	 name: String)

	def ScalarRow2Tuple
	(row: Row)
	: ScalarTuple
	= ScalarTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)

	def ScalarSQL2Tuple
	(row: Row)
	: ScalarTuple
	= ScalarTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)
				
	def ScalarTuple2Type
	(tuple: ScalarTuple)
	: tables.Scalar
	= tables.Scalar(
	  tables.taggedTypes.scalarUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.localName(tuple.name)
	)

	def ScalarType2Tuple
	(e: tables.Scalar)
	: ScalarTuple
	= ScalarTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.name
	)
	case class ScalarDataPropertyTuple
	(uuid: String,
	 tboxUUID: String,
	 domainUUID: String,
	 rangeUUID: String,
	 name: String)

	def ScalarDataPropertyRow2Tuple
	(row: Row)
	: ScalarDataPropertyTuple
	= ScalarDataPropertyTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[String]("name")
	)

	def ScalarDataPropertySQL2Tuple
	(row: Row)
	: ScalarDataPropertyTuple
	= ScalarDataPropertyTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[String]("name")
	)
				
	def ScalarDataPropertyTuple2Type
	(tuple: ScalarDataPropertyTuple)
	: tables.ScalarDataProperty
	= tables.ScalarDataProperty(
	  tables.taggedTypes.scalarDataPropertyUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.structureUUID(tuple.domainUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.rangeUUID),
	  tables.taggedTypes.localName(tuple.name)
	)

	def ScalarDataPropertyType2Tuple
	(e: tables.ScalarDataProperty)
	: ScalarDataPropertyTuple
	= ScalarDataPropertyTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.domainUUID,
	  e.rangeUUID,
	  e.name
	)
	case class ScalarDataPropertyValueTuple
	(uuid: String,
	 scalarDataPropertyUUID: String,
	 scalarPropertyValue: String, scalarPropertyValueLiteralType: String,
	 structuredDataPropertyContextUUID: String,
	 valueTypeUUID: String)

	def ScalarDataPropertyValueRow2Tuple
	(row: Row)
	: ScalarDataPropertyValueTuple
	= ScalarDataPropertyValueTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("scalarDataPropertyUUID"),
	  row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("value"),row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("literalType"),
	  row.getAs[String]("structuredDataPropertyContextUUID"),
	  row.getAs[String]("valueTypeUUID")
	)

	def ScalarDataPropertyValueSQL2Tuple
	(row: Row)
	: ScalarDataPropertyValueTuple
	= ScalarDataPropertyValueTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("scalarDataPropertyUUID"),
	  row.getAs[String]("scalarPropertyValue"),row.getAs[String]("scalarPropertyValueLiteralType"),
	  row.getAs[String]("structuredDataPropertyContextUUID"),
	  row.getAs[String]("valueTypeUUID")
	)
				
	def ScalarDataPropertyValueTuple2Type
	(tuple: ScalarDataPropertyValueTuple)
	: tables.ScalarDataPropertyValue
	= tables.ScalarDataPropertyValue(
	  tables.taggedTypes.scalarDataPropertyValueUUID(tuple.uuid),
	  tables.taggedTypes.dataRelationshipToScalarUUID(tuple.scalarDataPropertyUUID),
	  tables.LiteralValue.fromJSON(s"""{"literalType":"${tuple.scalarPropertyValueLiteralType}","value":"${tuple.scalarPropertyValue}"}"""),
	  tables.taggedTypes.singletonInstanceStructuredDataPropertyContextUUID(tuple.structuredDataPropertyContextUUID),
	  if (null == tuple.valueTypeUUID || tuple.valueTypeUUID.isEmpty) None else Some(tables.taggedTypes.dataRangeUUID(tuple.valueTypeUUID))
	)

	def ScalarDataPropertyValueType2Tuple
	(e: tables.ScalarDataPropertyValue)
	: ScalarDataPropertyValueTuple
	= ScalarDataPropertyValueTuple(
	  e.uuid,
	  e.scalarDataPropertyUUID,
	  e.scalarPropertyValue.value, e.scalarPropertyValue.literalType.toString,
	  e.structuredDataPropertyContextUUID,
	  e.valueTypeUUID.fold[String](null)(identity)
	)
	case class ScalarOneOfLiteralAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 axiomUUID: String,
	 value: String, valueLiteralType: String,
	 valueTypeUUID: String)

	def ScalarOneOfLiteralAxiomRow2Tuple
	(row: Row)
	: ScalarOneOfLiteralAxiomTuple
	= ScalarOneOfLiteralAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("axiomUUID"),
	  row.getAs[GenericRowWithSchema]("value").getAs[String]("value"),row.getAs[GenericRowWithSchema]("value").getAs[String]("literalType"),
	  row.getAs[String]("valueTypeUUID")
	)

	def ScalarOneOfLiteralAxiomSQL2Tuple
	(row: Row)
	: ScalarOneOfLiteralAxiomTuple
	= ScalarOneOfLiteralAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("axiomUUID"),
	  row.getAs[String]("value"),row.getAs[String]("valueLiteralType"),
	  row.getAs[String]("valueTypeUUID")
	)
				
	def ScalarOneOfLiteralAxiomTuple2Type
	(tuple: ScalarOneOfLiteralAxiomTuple)
	: tables.ScalarOneOfLiteralAxiom
	= tables.ScalarOneOfLiteralAxiom(
	  tables.taggedTypes.scalarOneOfLiteralAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.scalarOneOfRestrictionUUID(tuple.axiomUUID),
	  tables.LiteralValue.fromJSON(s"""{"literalType":"${tuple.valueLiteralType}","value":"${tuple.value}"}"""),
	  if (null == tuple.valueTypeUUID || tuple.valueTypeUUID.isEmpty) None else Some(tables.taggedTypes.dataRangeUUID(tuple.valueTypeUUID))
	)

	def ScalarOneOfLiteralAxiomType2Tuple
	(e: tables.ScalarOneOfLiteralAxiom)
	: ScalarOneOfLiteralAxiomTuple
	= ScalarOneOfLiteralAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.axiomUUID,
	  e.value.value, e.value.literalType.toString,
	  e.valueTypeUUID.fold[String](null)(identity)
	)
	case class ScalarOneOfRestrictionTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 name: String)

	def ScalarOneOfRestrictionRow2Tuple
	(row: Row)
	: ScalarOneOfRestrictionTuple
	= ScalarOneOfRestrictionTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("name")
	)

	def ScalarOneOfRestrictionSQL2Tuple
	(row: Row)
	: ScalarOneOfRestrictionTuple
	= ScalarOneOfRestrictionTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("name")
	)
				
	def ScalarOneOfRestrictionTuple2Type
	(tuple: ScalarOneOfRestrictionTuple)
	: tables.ScalarOneOfRestriction
	= tables.ScalarOneOfRestriction(
	  tables.taggedTypes.scalarOneOfRestrictionUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.restrictedRangeUUID),
	  tables.taggedTypes.localName(tuple.name)
	)

	def ScalarOneOfRestrictionType2Tuple
	(e: tables.ScalarOneOfRestriction)
	: ScalarOneOfRestrictionTuple
	= ScalarOneOfRestrictionTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedRangeUUID,
	  e.name
	)
	case class SingletonInstanceScalarDataPropertyValueTuple
	(uuid: String,
	 descriptionBoxUUID: String,
	 singletonInstanceUUID: String,
	 scalarDataPropertyUUID: String,
	 scalarPropertyValue: String, scalarPropertyValueLiteralType: String,
	 valueTypeUUID: String)

	def SingletonInstanceScalarDataPropertyValueRow2Tuple
	(row: Row)
	: SingletonInstanceScalarDataPropertyValueTuple
	= SingletonInstanceScalarDataPropertyValueTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonInstanceUUID"),
	  row.getAs[String]("scalarDataPropertyUUID"),
	  row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("value"),row.getAs[GenericRowWithSchema]("scalarPropertyValue").getAs[String]("literalType"),
	  row.getAs[String]("valueTypeUUID")
	)

	def SingletonInstanceScalarDataPropertyValueSQL2Tuple
	(row: Row)
	: SingletonInstanceScalarDataPropertyValueTuple
	= SingletonInstanceScalarDataPropertyValueTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonInstanceUUID"),
	  row.getAs[String]("scalarDataPropertyUUID"),
	  row.getAs[String]("scalarPropertyValue"),row.getAs[String]("scalarPropertyValueLiteralType"),
	  row.getAs[String]("valueTypeUUID")
	)
				
	def SingletonInstanceScalarDataPropertyValueTuple2Type
	(tuple: SingletonInstanceScalarDataPropertyValueTuple)
	: tables.SingletonInstanceScalarDataPropertyValue
	= tables.SingletonInstanceScalarDataPropertyValue(
	  tables.taggedTypes.singletonInstanceScalarDataPropertyValueUUID(tuple.uuid),
	  tables.taggedTypes.descriptionBoxUUID(tuple.descriptionBoxUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(tuple.singletonInstanceUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(tuple.scalarDataPropertyUUID),
	  tables.LiteralValue.fromJSON(s"""{"literalType":"${tuple.scalarPropertyValueLiteralType}","value":"${tuple.scalarPropertyValue}"}"""),
	  if (null == tuple.valueTypeUUID || tuple.valueTypeUUID.isEmpty) None else Some(tables.taggedTypes.dataRangeUUID(tuple.valueTypeUUID))
	)

	def SingletonInstanceScalarDataPropertyValueType2Tuple
	(e: tables.SingletonInstanceScalarDataPropertyValue)
	: SingletonInstanceScalarDataPropertyValueTuple
	= SingletonInstanceScalarDataPropertyValueTuple(
	  e.uuid,
	  e.descriptionBoxUUID,
	  e.singletonInstanceUUID,
	  e.scalarDataPropertyUUID,
	  e.scalarPropertyValue.value, e.scalarPropertyValue.literalType.toString,
	  e.valueTypeUUID.fold[String](null)(identity)
	)
	case class SingletonInstanceStructuredDataPropertyValueTuple
	(uuid: String,
	 descriptionBoxUUID: String,
	 singletonInstanceUUID: String,
	 structuredDataPropertyUUID: String)

	def SingletonInstanceStructuredDataPropertyValueRow2Tuple
	(row: Row)
	: SingletonInstanceStructuredDataPropertyValueTuple
	= SingletonInstanceStructuredDataPropertyValueTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonInstanceUUID"),
	  row.getAs[String]("structuredDataPropertyUUID")
	)

	def SingletonInstanceStructuredDataPropertyValueSQL2Tuple
	(row: Row)
	: SingletonInstanceStructuredDataPropertyValueTuple
	= SingletonInstanceStructuredDataPropertyValueTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("singletonInstanceUUID"),
	  row.getAs[String]("structuredDataPropertyUUID")
	)
				
	def SingletonInstanceStructuredDataPropertyValueTuple2Type
	(tuple: SingletonInstanceStructuredDataPropertyValueTuple)
	: tables.SingletonInstanceStructuredDataPropertyValue
	= tables.SingletonInstanceStructuredDataPropertyValue(
	  tables.taggedTypes.singletonInstanceStructuredDataPropertyValueUUID(tuple.uuid),
	  tables.taggedTypes.descriptionBoxUUID(tuple.descriptionBoxUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(tuple.singletonInstanceUUID),
	  tables.taggedTypes.dataRelationshipToStructureUUID(tuple.structuredDataPropertyUUID)
	)

	def SingletonInstanceStructuredDataPropertyValueType2Tuple
	(e: tables.SingletonInstanceStructuredDataPropertyValue)
	: SingletonInstanceStructuredDataPropertyValueTuple
	= SingletonInstanceStructuredDataPropertyValueTuple(
	  e.uuid,
	  e.descriptionBoxUUID,
	  e.singletonInstanceUUID,
	  e.structuredDataPropertyUUID
	)
	case class SpecificDisjointConceptAxiomTuple
	(uuid: String,
	 disjointTaxonomyParentUUID: String,
	 disjointLeafUUID: String)

	def SpecificDisjointConceptAxiomRow2Tuple
	(row: Row)
	: SpecificDisjointConceptAxiomTuple
	= SpecificDisjointConceptAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("disjointTaxonomyParentUUID"),
	  row.getAs[String]("disjointLeafUUID")
	)

	def SpecificDisjointConceptAxiomSQL2Tuple
	(row: Row)
	: SpecificDisjointConceptAxiomTuple
	= SpecificDisjointConceptAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("disjointTaxonomyParentUUID"),
	  row.getAs[String]("disjointLeafUUID")
	)
				
	def SpecificDisjointConceptAxiomTuple2Type
	(tuple: SpecificDisjointConceptAxiomTuple)
	: tables.SpecificDisjointConceptAxiom
	= tables.SpecificDisjointConceptAxiom(
	  tables.taggedTypes.specificDisjointConceptAxiomUUID(tuple.uuid),
	  tables.taggedTypes.conceptTreeDisjunctionUUID(tuple.disjointTaxonomyParentUUID),
	  tables.taggedTypes.conceptUUID(tuple.disjointLeafUUID)
	)

	def SpecificDisjointConceptAxiomType2Tuple
	(e: tables.SpecificDisjointConceptAxiom)
	: SpecificDisjointConceptAxiomTuple
	= SpecificDisjointConceptAxiomTuple(
	  e.uuid,
	  e.disjointTaxonomyParentUUID,
	  e.disjointLeafUUID
	)
	case class StringScalarRestrictionTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 length: String,
	 minLength: String,
	 maxLength: String,
	 name: String,
	 pattern: String)

	def StringScalarRestrictionRow2Tuple
	(row: Row)
	: StringScalarRestrictionTuple
	= StringScalarRestrictionTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("length"),
	  row.getAs[String]("minLength"),
	  row.getAs[String]("maxLength"),
	  row.getAs[String]("name"),
	  row.getAs[String]("pattern")
	)

	def StringScalarRestrictionSQL2Tuple
	(row: Row)
	: StringScalarRestrictionTuple
	= StringScalarRestrictionTuple(
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
	(tuple: StringScalarRestrictionTuple)
	: tables.StringScalarRestriction
	= tables.StringScalarRestriction(
	  tables.taggedTypes.stringScalarRestrictionUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.restrictedRangeUUID),
	  if (null == tuple.length || tuple.length.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.length)),
	  if (null == tuple.minLength || tuple.minLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.minLength)),
	  if (null == tuple.maxLength || tuple.maxLength.isEmpty) None else Some(tables.taggedTypes.positiveIntegerLiteral(tuple.maxLength)),
	  tables.taggedTypes.localName(tuple.name),
	  if (null == tuple.pattern || tuple.pattern.isEmpty) None else Some(tables.taggedTypes.literalPattern(tuple.pattern))
	)

	def StringScalarRestrictionType2Tuple
	(e: tables.StringScalarRestriction)
	: StringScalarRestrictionTuple
	= StringScalarRestrictionTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedRangeUUID,
	  e.length.fold[String](null)(identity),
	  e.minLength.fold[String](null)(identity),
	  e.maxLength.fold[String](null)(identity),
	  e.name,
	  e.pattern.fold[String](null)(identity)
	)
	case class StructureTuple
	(uuid: String,
	 tboxUUID: String,
	 name: String)

	def StructureRow2Tuple
	(row: Row)
	: StructureTuple
	= StructureTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)

	def StructureSQL2Tuple
	(row: Row)
	: StructureTuple
	= StructureTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("name")
	)
				
	def StructureTuple2Type
	(tuple: StructureTuple)
	: tables.Structure
	= tables.Structure(
	  tables.taggedTypes.structureUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.localName(tuple.name)
	)

	def StructureType2Tuple
	(e: tables.Structure)
	: StructureTuple
	= StructureTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.name
	)
	case class StructuredDataPropertyTuple
	(uuid: String,
	 tboxUUID: String,
	 domainUUID: String,
	 rangeUUID: String,
	 name: String)

	def StructuredDataPropertyRow2Tuple
	(row: Row)
	: StructuredDataPropertyTuple
	= StructuredDataPropertyTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[String]("name")
	)

	def StructuredDataPropertySQL2Tuple
	(row: Row)
	: StructuredDataPropertyTuple
	= StructuredDataPropertyTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID"),
	  row.getAs[String]("name")
	)
				
	def StructuredDataPropertyTuple2Type
	(tuple: StructuredDataPropertyTuple)
	: tables.StructuredDataProperty
	= tables.StructuredDataProperty(
	  tables.taggedTypes.structuredDataPropertyUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.structureUUID(tuple.domainUUID),
	  tables.taggedTypes.structureUUID(tuple.rangeUUID),
	  tables.taggedTypes.localName(tuple.name)
	)

	def StructuredDataPropertyType2Tuple
	(e: tables.StructuredDataProperty)
	: StructuredDataPropertyTuple
	= StructuredDataPropertyTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.domainUUID,
	  e.rangeUUID,
	  e.name
	)
	case class StructuredDataPropertyTupleTuple
	(uuid: String,
	 structuredDataPropertyUUID: String,
	 structuredDataPropertyContextUUID: String)

	def StructuredDataPropertyTupleRow2Tuple
	(row: Row)
	: StructuredDataPropertyTupleTuple
	= StructuredDataPropertyTupleTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("structuredDataPropertyUUID"),
	  row.getAs[String]("structuredDataPropertyContextUUID")
	)

	def StructuredDataPropertyTupleSQL2Tuple
	(row: Row)
	: StructuredDataPropertyTupleTuple
	= StructuredDataPropertyTupleTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("structuredDataPropertyUUID"),
	  row.getAs[String]("structuredDataPropertyContextUUID")
	)
				
	def StructuredDataPropertyTupleTuple2Type
	(tuple: StructuredDataPropertyTupleTuple)
	: tables.StructuredDataPropertyTuple
	= tables.StructuredDataPropertyTuple(
	  tables.taggedTypes.structuredDataPropertyTupleUUID(tuple.uuid),
	  tables.taggedTypes.dataRelationshipToStructureUUID(tuple.structuredDataPropertyUUID),
	  tables.taggedTypes.singletonInstanceStructuredDataPropertyContextUUID(tuple.structuredDataPropertyContextUUID)
	)

	def StructuredDataPropertyTupleType2Tuple
	(e: tables.StructuredDataPropertyTuple)
	: StructuredDataPropertyTupleTuple
	= StructuredDataPropertyTupleTuple(
	  e.uuid,
	  e.structuredDataPropertyUUID,
	  e.structuredDataPropertyContextUUID
	)
	case class SubDataPropertyOfAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 subPropertyUUID: String,
	 superPropertyUUID: String)

	def SubDataPropertyOfAxiomRow2Tuple
	(row: Row)
	: SubDataPropertyOfAxiomTuple
	= SubDataPropertyOfAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("subPropertyUUID"),
	  row.getAs[String]("superPropertyUUID")
	)

	def SubDataPropertyOfAxiomSQL2Tuple
	(row: Row)
	: SubDataPropertyOfAxiomTuple
	= SubDataPropertyOfAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("subPropertyUUID"),
	  row.getAs[String]("superPropertyUUID")
	)
				
	def SubDataPropertyOfAxiomTuple2Type
	(tuple: SubDataPropertyOfAxiomTuple)
	: tables.SubDataPropertyOfAxiom
	= tables.SubDataPropertyOfAxiom(
	  tables.taggedTypes.subDataPropertyOfAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(tuple.subPropertyUUID),
	  tables.taggedTypes.entityScalarDataPropertyUUID(tuple.superPropertyUUID)
	)

	def SubDataPropertyOfAxiomType2Tuple
	(e: tables.SubDataPropertyOfAxiom)
	: SubDataPropertyOfAxiomTuple
	= SubDataPropertyOfAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.subPropertyUUID,
	  e.superPropertyUUID
	)
	case class SubObjectPropertyOfAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 subPropertyUUID: String,
	 superPropertyUUID: String)

	def SubObjectPropertyOfAxiomRow2Tuple
	(row: Row)
	: SubObjectPropertyOfAxiomTuple
	= SubObjectPropertyOfAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("subPropertyUUID"),
	  row.getAs[String]("superPropertyUUID")
	)

	def SubObjectPropertyOfAxiomSQL2Tuple
	(row: Row)
	: SubObjectPropertyOfAxiomTuple
	= SubObjectPropertyOfAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("subPropertyUUID"),
	  row.getAs[String]("superPropertyUUID")
	)
				
	def SubObjectPropertyOfAxiomTuple2Type
	(tuple: SubObjectPropertyOfAxiomTuple)
	: tables.SubObjectPropertyOfAxiom
	= tables.SubObjectPropertyOfAxiom(
	  tables.taggedTypes.subObjectPropertyOfAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.unreifiedRelationshipUUID(tuple.subPropertyUUID),
	  tables.taggedTypes.unreifiedRelationshipUUID(tuple.superPropertyUUID)
	)

	def SubObjectPropertyOfAxiomType2Tuple
	(e: tables.SubObjectPropertyOfAxiom)
	: SubObjectPropertyOfAxiomTuple
	= SubObjectPropertyOfAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.subPropertyUUID,
	  e.superPropertyUUID
	)
	case class SynonymScalarRestrictionTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 name: String)

	def SynonymScalarRestrictionRow2Tuple
	(row: Row)
	: SynonymScalarRestrictionTuple
	= SynonymScalarRestrictionTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("name")
	)

	def SynonymScalarRestrictionSQL2Tuple
	(row: Row)
	: SynonymScalarRestrictionTuple
	= SynonymScalarRestrictionTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("name")
	)
				
	def SynonymScalarRestrictionTuple2Type
	(tuple: SynonymScalarRestrictionTuple)
	: tables.SynonymScalarRestriction
	= tables.SynonymScalarRestriction(
	  tables.taggedTypes.synonymScalarRestrictionUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.restrictedRangeUUID),
	  tables.taggedTypes.localName(tuple.name)
	)

	def SynonymScalarRestrictionType2Tuple
	(e: tables.SynonymScalarRestriction)
	: SynonymScalarRestrictionTuple
	= SynonymScalarRestrictionTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedRangeUUID,
	  e.name
	)
	case class TerminologyExtensionAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 extendedTerminologyIRI: String)

	def TerminologyExtensionAxiomRow2Tuple
	(row: Row)
	: TerminologyExtensionAxiomTuple
	= TerminologyExtensionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("extendedTerminologyIRI")
	)

	def TerminologyExtensionAxiomSQL2Tuple
	(row: Row)
	: TerminologyExtensionAxiomTuple
	= TerminologyExtensionAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("extendedTerminologyIRI")
	)
				
	def TerminologyExtensionAxiomTuple2Type
	(tuple: TerminologyExtensionAxiomTuple)
	: tables.TerminologyExtensionAxiom
	= tables.TerminologyExtensionAxiom(
	  tables.taggedTypes.terminologyExtensionAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.iri(tuple.extendedTerminologyIRI)
	)

	def TerminologyExtensionAxiomType2Tuple
	(e: tables.TerminologyExtensionAxiom)
	: TerminologyExtensionAxiomTuple
	= TerminologyExtensionAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.extendedTerminologyIRI
	)
	case class TerminologyGraphTuple
	(uuid: String,
	 kind: Int,
	 iri: String)

	def TerminologyGraphRow2Tuple
	(row: Row)
	: TerminologyGraphTuple
	= TerminologyGraphTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[Int]("kind"),
	  row.getAs[String]("iri")
	)

	def TerminologyGraphSQL2Tuple
	(row: Row)
	: TerminologyGraphTuple
	= TerminologyGraphTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[Int]("kind"),
	  row.getAs[String]("iri")
	)
				
	def TerminologyGraphTuple2Type
	(tuple: TerminologyGraphTuple)
	: tables.TerminologyGraph
	= tables.TerminologyGraph(
	  tables.taggedTypes.terminologyGraphUUID(tuple.uuid),
	  terminologyKind(tuple.kind),
	  tables.taggedTypes.iri(tuple.iri)
	)

	def TerminologyGraphType2Tuple
	(e: tables.TerminologyGraph)
	: TerminologyGraphTuple
	= TerminologyGraphTuple(
	  e.uuid,
	  terminologyKind(e.kind),
	  e.iri
	)
	case class TerminologyNestingAxiomTuple
	(uuid: String,
	 tboxUUID: String,
	 nestingContextUUID: String,
	 nestingTerminologyIRI: String)

	def TerminologyNestingAxiomRow2Tuple
	(row: Row)
	: TerminologyNestingAxiomTuple
	= TerminologyNestingAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("nestingContextUUID"),
	  row.getAs[String]("nestingTerminologyIRI")
	)

	def TerminologyNestingAxiomSQL2Tuple
	(row: Row)
	: TerminologyNestingAxiomTuple
	= TerminologyNestingAxiomTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("nestingContextUUID"),
	  row.getAs[String]("nestingTerminologyIRI")
	)
				
	def TerminologyNestingAxiomTuple2Type
	(tuple: TerminologyNestingAxiomTuple)
	: tables.TerminologyNestingAxiom
	= tables.TerminologyNestingAxiom(
	  tables.taggedTypes.terminologyNestingAxiomUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.conceptUUID(tuple.nestingContextUUID),
	  tables.taggedTypes.iri(tuple.nestingTerminologyIRI)
	)

	def TerminologyNestingAxiomType2Tuple
	(e: tables.TerminologyNestingAxiom)
	: TerminologyNestingAxiomTuple
	= TerminologyNestingAxiomTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.nestingContextUUID,
	  e.nestingTerminologyIRI
	)
	case class TimeScalarRestrictionTuple
	(uuid: String,
	 tboxUUID: String,
	 restrictedRangeUUID: String,
	 minExclusive: String,
	 minInclusive: String,
	 maxExclusive: String,
	 maxInclusive: String,
	 name: String)

	def TimeScalarRestrictionRow2Tuple
	(row: Row)
	: TimeScalarRestrictionTuple
	= TimeScalarRestrictionTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("tboxUUID"),
	  row.getAs[String]("restrictedRangeUUID"),
	  row.getAs[String]("minExclusive"),
	  row.getAs[String]("minInclusive"),
	  row.getAs[String]("maxExclusive"),
	  row.getAs[String]("maxInclusive"),
	  row.getAs[String]("name")
	)

	def TimeScalarRestrictionSQL2Tuple
	(row: Row)
	: TimeScalarRestrictionTuple
	= TimeScalarRestrictionTuple(
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
	(tuple: TimeScalarRestrictionTuple)
	: tables.TimeScalarRestriction
	= tables.TimeScalarRestriction(
	  tables.taggedTypes.timeScalarRestrictionUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.dataRangeUUID(tuple.restrictedRangeUUID),
	  if (tuple.minExclusive.isEmpty) None else tables.LiteralDateTime.parseDateTime(tuple.minExclusive),
	  if (tuple.minInclusive.isEmpty) None else tables.LiteralDateTime.parseDateTime(tuple.minInclusive),
	  if (tuple.maxExclusive.isEmpty) None else tables.LiteralDateTime.parseDateTime(tuple.maxExclusive),
	  if (tuple.maxInclusive.isEmpty) None else tables.LiteralDateTime.parseDateTime(tuple.maxInclusive),
	  tables.taggedTypes.localName(tuple.name)
	)

	def TimeScalarRestrictionType2Tuple
	(e: tables.TimeScalarRestriction)
	: TimeScalarRestrictionTuple
	= TimeScalarRestrictionTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.restrictedRangeUUID,
	  e.minExclusive.fold[String](null)(_.value),
	  e.minInclusive.fold[String](null)(_.value),
	  e.maxExclusive.fold[String](null)(_.value),
	  e.maxInclusive.fold[String](null)(_.value),
	  e.name
	)
	case class UnreifiedRelationshipTuple
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

	def UnreifiedRelationshipRow2Tuple
	(row: Row)
	: UnreifiedRelationshipTuple
	= UnreifiedRelationshipTuple(
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

	def UnreifiedRelationshipSQL2Tuple
	(row: Row)
	: UnreifiedRelationshipTuple
	= UnreifiedRelationshipTuple(
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
	(tuple: UnreifiedRelationshipTuple)
	: tables.UnreifiedRelationship
	= tables.UnreifiedRelationship(
	  tables.taggedTypes.unreifiedRelationshipUUID(tuple.uuid),
	  tables.taggedTypes.terminologyBoxUUID(tuple.tboxUUID),
	  tables.taggedTypes.entityUUID(tuple.sourceUUID),
	  tables.taggedTypes.entityUUID(tuple.targetUUID),
	  tuple.isAsymmetric,
	  tuple.isEssential,
	  tuple.isFunctional,
	  tuple.isInverseEssential,
	  tuple.isInverseFunctional,
	  tuple.isIrreflexive,
	  tuple.isReflexive,
	  tuple.isSymmetric,
	  tuple.isTransitive,
	  tables.taggedTypes.localName(tuple.name)
	)

	def UnreifiedRelationshipType2Tuple
	(e: tables.UnreifiedRelationship)
	: UnreifiedRelationshipTuple
	= UnreifiedRelationshipTuple(
	  e.uuid,
	  e.tboxUUID,
	  e.sourceUUID,
	  e.targetUUID,
	  e.isAsymmetric,
	  e.isEssential,
	  e.isFunctional,
	  e.isInverseEssential,
	  e.isInverseFunctional,
	  e.isIrreflexive,
	  e.isReflexive,
	  e.isSymmetric,
	  e.isTransitive,
	  e.name
	)
	case class UnreifiedRelationshipInstanceTupleTuple
	(uuid: String,
	 descriptionBoxUUID: String,
	 unreifiedRelationshipUUID: String,
	 domainUUID: String,
	 rangeUUID: String)

	def UnreifiedRelationshipInstanceTupleRow2Tuple
	(row: Row)
	: UnreifiedRelationshipInstanceTupleTuple
	= UnreifiedRelationshipInstanceTupleTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("unreifiedRelationshipUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID")
	)

	def UnreifiedRelationshipInstanceTupleSQL2Tuple
	(row: Row)
	: UnreifiedRelationshipInstanceTupleTuple
	= UnreifiedRelationshipInstanceTupleTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("descriptionBoxUUID"),
	  row.getAs[String]("unreifiedRelationshipUUID"),
	  row.getAs[String]("domainUUID"),
	  row.getAs[String]("rangeUUID")
	)
				
	def UnreifiedRelationshipInstanceTupleTuple2Type
	(tuple: UnreifiedRelationshipInstanceTupleTuple)
	: tables.UnreifiedRelationshipInstanceTuple
	= tables.UnreifiedRelationshipInstanceTuple(
	  tables.taggedTypes.unreifiedRelationshipInstanceTupleUUID(tuple.uuid),
	  tables.taggedTypes.descriptionBoxUUID(tuple.descriptionBoxUUID),
	  tables.taggedTypes.unreifiedRelationshipUUID(tuple.unreifiedRelationshipUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(tuple.domainUUID),
	  tables.taggedTypes.conceptualEntitySingletonInstanceUUID(tuple.rangeUUID)
	)

	def UnreifiedRelationshipInstanceTupleType2Tuple
	(e: tables.UnreifiedRelationshipInstanceTuple)
	: UnreifiedRelationshipInstanceTupleTuple
	= UnreifiedRelationshipInstanceTupleTuple(
	  e.uuid,
	  e.descriptionBoxUUID,
	  e.unreifiedRelationshipUUID,
	  e.domainUUID,
	  e.rangeUUID
	)
	case class UnreifiedRelationshipInversePropertyPredicateTuple
	(uuid: String,
	 unreifiedRelationshipUUID: String,
	 bodySegmentUUID: String)

	def UnreifiedRelationshipInversePropertyPredicateRow2Tuple
	(row: Row)
	: UnreifiedRelationshipInversePropertyPredicateTuple
	= UnreifiedRelationshipInversePropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("unreifiedRelationshipUUID"),
	  row.getAs[String]("bodySegmentUUID")
	)

	def UnreifiedRelationshipInversePropertyPredicateSQL2Tuple
	(row: Row)
	: UnreifiedRelationshipInversePropertyPredicateTuple
	= UnreifiedRelationshipInversePropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("unreifiedRelationshipUUID"),
	  row.getAs[String]("bodySegmentUUID")
	)
				
	def UnreifiedRelationshipInversePropertyPredicateTuple2Type
	(tuple: UnreifiedRelationshipInversePropertyPredicateTuple)
	: tables.UnreifiedRelationshipInversePropertyPredicate
	= tables.UnreifiedRelationshipInversePropertyPredicate(
	  tables.taggedTypes.unreifiedRelationshipInversePropertyPredicateUUID(tuple.uuid),
	  tables.taggedTypes.unreifiedRelationshipUUID(tuple.unreifiedRelationshipUUID),
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.bodySegmentUUID)
	)

	def UnreifiedRelationshipInversePropertyPredicateType2Tuple
	(e: tables.UnreifiedRelationshipInversePropertyPredicate)
	: UnreifiedRelationshipInversePropertyPredicateTuple
	= UnreifiedRelationshipInversePropertyPredicateTuple(
	  e.uuid,
	  e.unreifiedRelationshipUUID,
	  e.bodySegmentUUID
	)
	case class UnreifiedRelationshipPropertyPredicateTuple
	(uuid: String,
	 unreifiedRelationshipUUID: String,
	 bodySegmentUUID: String)

	def UnreifiedRelationshipPropertyPredicateRow2Tuple
	(row: Row)
	: UnreifiedRelationshipPropertyPredicateTuple
	= UnreifiedRelationshipPropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("unreifiedRelationshipUUID"),
	  row.getAs[String]("bodySegmentUUID")
	)

	def UnreifiedRelationshipPropertyPredicateSQL2Tuple
	(row: Row)
	: UnreifiedRelationshipPropertyPredicateTuple
	= UnreifiedRelationshipPropertyPredicateTuple(
	  row.getAs[String]("uuid"),
	  row.getAs[String]("unreifiedRelationshipUUID"),
	  row.getAs[String]("bodySegmentUUID")
	)
				
	def UnreifiedRelationshipPropertyPredicateTuple2Type
	(tuple: UnreifiedRelationshipPropertyPredicateTuple)
	: tables.UnreifiedRelationshipPropertyPredicate
	= tables.UnreifiedRelationshipPropertyPredicate(
	  tables.taggedTypes.unreifiedRelationshipPropertyPredicateUUID(tuple.uuid),
	  tables.taggedTypes.unreifiedRelationshipUUID(tuple.unreifiedRelationshipUUID),
	  tables.taggedTypes.ruleBodySegmentUUID(tuple.bodySegmentUUID)
	)

	def UnreifiedRelationshipPropertyPredicateType2Tuple
	(e: tables.UnreifiedRelationshipPropertyPredicate)
	: UnreifiedRelationshipPropertyPredicateTuple
	= UnreifiedRelationshipPropertyPredicateTuple(
	  e.uuid,
	  e.unreifiedRelationshipUUID,
	  e.bodySegmentUUID
	)
}
