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

import frameless.{TypedColumn,TypedDataset}
import frameless.ops.SmartProject
import gov.nasa.jpl.imce.oml.tables.TerminologyKind
import gov.nasa.jpl.imce.oml.tables.taggedTypes

object OMLSmartProjects {
	
	import OMLSpecificationTypedDatasets._
	import OMLCatalystCasts._
	
	// 2 smart projects for api.AnonymousConceptUnionAxiom
	
	implicit val AnonymousConceptUnionAxiom2DisjointUnionOfConceptsAxiomSmartProject
	: SmartProject
	  [ api.AnonymousConceptUnionAxiom,
	    api.DisjointUnionOfConceptsAxiom]
	= SmartProject
	  [ api.AnonymousConceptUnionAxiom,
		api.DisjointUnionOfConceptsAxiom](
		  (x: TypedDataset[api.AnonymousConceptUnionAxiom]) => {
		    val x_uuid: TypedColumn[api.AnonymousConceptUnionAxiom, taggedTypes.DisjointUnionOfConceptsAxiomUUID]
		  = x.col[taggedTypes.AnonymousConceptUnionAxiomUUID]('uuid).cast[taggedTypes.DisjointUnionOfConceptsAxiomUUID]
		    val x_disjointTaxonomyParentUUID: TypedColumn[api.AnonymousConceptUnionAxiom, taggedTypes.ConceptTreeDisjunctionUUID]
		  = x.col[taggedTypes.ConceptTreeDisjunctionUUID]('disjointTaxonomyParentUUID)
		
	      
	    val result
	    : TypedDataset[api.DisjointUnionOfConceptsAxiom]
	    = x
		  .select[
		  taggedTypes.DisjointUnionOfConceptsAxiomUUID,
		    taggedTypes.ConceptTreeDisjunctionUUID](
		  x_uuid,
		    x_disjointTaxonomyParentUUID)
		  .as[api.DisjointUnionOfConceptsAxiom]
		  
		result
	  })

	// 2 smart projects for api.Aspect
	
	implicit val Aspect2EntitySmartProject
	: SmartProject
	  [ api.Aspect,
	    api.Entity]
	= SmartProject
	  [ api.Aspect,
		api.Entity](
		  (x: TypedDataset[api.Aspect]) => {
		    val x_uuid: TypedColumn[api.Aspect, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.AspectUUID]('uuid).cast[taggedTypes.EntityUUID]
		    val x_tboxUUID: TypedColumn[api.Aspect, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.Aspect, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Entity]
	    = x
		  .select[
		  taggedTypes.EntityUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Entity]
		  
		result
	  })

	implicit val Aspect2UnaryTermKindSmartProject
	: SmartProject
	  [ api.Aspect,
	    api.UnaryTermKind]
	= SmartProject
	  [ api.Aspect,
		api.UnaryTermKind](
		  (x: TypedDataset[api.Aspect]) => {
		    val x_uuid: TypedColumn[api.Aspect, taggedTypes.UnaryTermKindUUID]
		  = x.col[taggedTypes.AspectUUID]('uuid).cast[taggedTypes.UnaryTermKindUUID]
		    val x_tboxUUID: TypedColumn[api.Aspect, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.Aspect, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.UnaryTermKind]
	    = x
		  .select[
		  taggedTypes.UnaryTermKindUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.UnaryTermKind]
		  
		result
	  })

	// 1 smart projects for api.AspectPredicate
	
	implicit val AspectPredicate2UnarySegmentPredicateSmartProject
	: SmartProject
	  [ api.AspectPredicate,
	    api.UnarySegmentPredicate]
	= SmartProject
	  [ api.AspectPredicate,
		api.UnarySegmentPredicate](
		  (x: TypedDataset[api.AspectPredicate]) => {
		    val x_uuid: TypedColumn[api.AspectPredicate, taggedTypes.UnarySegmentPredicateUUID]
		  = x.col[taggedTypes.AspectPredicateUUID]('uuid).cast[taggedTypes.UnarySegmentPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.AspectPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.UnarySegmentPredicate]
	    = x
		  .select[
		  taggedTypes.UnarySegmentPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.UnarySegmentPredicate]
		  
		result
	  })

	// 1 smart projects for api.AspectSpecializationAxiom
	
	implicit val AspectSpecializationAxiom2SpecializationAxiomSmartProject
	: SmartProject
	  [ api.AspectSpecializationAxiom,
	    api.SpecializationAxiom]
	= SmartProject
	  [ api.AspectSpecializationAxiom,
		api.SpecializationAxiom](
		  (x: TypedDataset[api.AspectSpecializationAxiom]) => {
		    val x_uuid: TypedColumn[api.AspectSpecializationAxiom, taggedTypes.SpecializationAxiomUUID]
		  = x.col[taggedTypes.AspectSpecializationAxiomUUID]('uuid).cast[taggedTypes.SpecializationAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.AspectSpecializationAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.SpecializationAxiom]
	    = x
		  .select[
		  taggedTypes.SpecializationAxiomUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.SpecializationAxiom]
		  
		result
	  })

	// 1 smart projects for api.BinaryScalarRestriction
	
	implicit val BinaryScalarRestriction2RestrictedDataRangeSmartProject
	: SmartProject
	  [ api.BinaryScalarRestriction,
	    api.RestrictedDataRange]
	= SmartProject
	  [ api.BinaryScalarRestriction,
		api.RestrictedDataRange](
		  (x: TypedDataset[api.BinaryScalarRestriction]) => {
		    val x_uuid: TypedColumn[api.BinaryScalarRestriction, taggedTypes.RestrictedDataRangeUUID]
		  = x.col[taggedTypes.BinaryScalarRestrictionUUID]('uuid).cast[taggedTypes.RestrictedDataRangeUUID]
		    val x_tboxUUID: TypedColumn[api.BinaryScalarRestriction, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedRangeUUID: TypedColumn[api.BinaryScalarRestriction, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.DataRangeUUID]('restrictedRangeUUID)
		    val x_name: TypedColumn[api.BinaryScalarRestriction, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.RestrictedDataRange]
	    = x
		  .select[
		  taggedTypes.RestrictedDataRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.DataRangeUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedRangeUUID,
		    x_name)
		  .as[api.RestrictedDataRange]
		  
		result
	  })

	// 1 smart projects for api.BinarySegmentForwardPropertyPredicate
	
	implicit val BinarySegmentForwardPropertyPredicate2BinarySegmentPropertyPredicateSmartProject
	: SmartProject
	  [ api.BinarySegmentForwardPropertyPredicate,
	    api.BinarySegmentPropertyPredicate]
	= SmartProject
	  [ api.BinarySegmentForwardPropertyPredicate,
		api.BinarySegmentPropertyPredicate](
		  (x: TypedDataset[api.BinarySegmentForwardPropertyPredicate]) => {
		    val x_uuid: TypedColumn[api.BinarySegmentForwardPropertyPredicate, taggedTypes.BinarySegmentPropertyPredicateUUID]
		  = x.col[taggedTypes.BinarySegmentForwardPropertyPredicateUUID]('uuid).cast[taggedTypes.BinarySegmentPropertyPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.BinarySegmentForwardPropertyPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.BinarySegmentPropertyPredicate]
	    = x
		  .select[
		  taggedTypes.BinarySegmentPropertyPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.BinarySegmentPropertyPredicate]
		  
		result
	  })

	// 1 smart projects for api.BinarySegmentPropertyPredicate
	
	implicit val BinarySegmentPropertyPredicate2SegmentPredicateSmartProject
	: SmartProject
	  [ api.BinarySegmentPropertyPredicate,
	    api.SegmentPredicate]
	= SmartProject
	  [ api.BinarySegmentPropertyPredicate,
		api.SegmentPredicate](
		  (x: TypedDataset[api.BinarySegmentPropertyPredicate]) => {
		    val x_uuid: TypedColumn[api.BinarySegmentPropertyPredicate, taggedTypes.SegmentPredicateUUID]
		  = x.col[taggedTypes.BinarySegmentPropertyPredicateUUID]('uuid).cast[taggedTypes.SegmentPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.BinarySegmentPropertyPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.SegmentPredicate]
	    = x
		  .select[
		  taggedTypes.SegmentPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.SegmentPredicate]
		  
		result
	  })

	// 1 smart projects for api.BinarySegmentReversePropertyPredicate
	
	implicit val BinarySegmentReversePropertyPredicate2BinarySegmentPropertyPredicateSmartProject
	: SmartProject
	  [ api.BinarySegmentReversePropertyPredicate,
	    api.BinarySegmentPropertyPredicate]
	= SmartProject
	  [ api.BinarySegmentReversePropertyPredicate,
		api.BinarySegmentPropertyPredicate](
		  (x: TypedDataset[api.BinarySegmentReversePropertyPredicate]) => {
		    val x_uuid: TypedColumn[api.BinarySegmentReversePropertyPredicate, taggedTypes.BinarySegmentPropertyPredicateUUID]
		  = x.col[taggedTypes.BinarySegmentReversePropertyPredicateUUID]('uuid).cast[taggedTypes.BinarySegmentPropertyPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.BinarySegmentReversePropertyPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.BinarySegmentPropertyPredicate]
	    = x
		  .select[
		  taggedTypes.BinarySegmentPropertyPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.BinarySegmentPropertyPredicate]
		  
		result
	  })

	// 1 smart projects for api.Bundle
	
	implicit val Bundle2TerminologyBoxSmartProject
	: SmartProject
	  [ api.Bundle,
	    api.TerminologyBox]
	= SmartProject
	  [ api.Bundle,
		api.TerminologyBox](
		  (x: TypedDataset[api.Bundle]) => {
		    val x_uuid: TypedColumn[api.Bundle, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.BundleUUID]('uuid).cast[taggedTypes.TerminologyBoxUUID]
		    val x_kind: TypedColumn[api.Bundle, TerminologyKind]
		  = x.col[TerminologyKind]('kind)
		    val x_iri: TypedColumn[api.Bundle, taggedTypes.IRI]
		  = x.col[taggedTypes.IRI]('iri)
		
	      
	    val result
	    : TypedDataset[api.TerminologyBox]
	    = x
		  .select[
		  taggedTypes.TerminologyBoxUUID,
		    TerminologyKind,
		    taggedTypes.IRI](
		  x_uuid,
		    x_kind,
		    x_iri)
		  .as[api.TerminologyBox]
		  
		result
	  })

	// 1 smart projects for api.BundledTerminologyAxiom
	
	implicit val BundledTerminologyAxiom2TerminologyBundleAxiomSmartProject
	: SmartProject
	  [ api.BundledTerminologyAxiom,
	    api.TerminologyBundleAxiom]
	= SmartProject
	  [ api.BundledTerminologyAxiom,
		api.TerminologyBundleAxiom](
		  (x: TypedDataset[api.BundledTerminologyAxiom]) => {
		    val x_uuid: TypedColumn[api.BundledTerminologyAxiom, taggedTypes.TerminologyBundleAxiomUUID]
		  = x.col[taggedTypes.BundledTerminologyAxiomUUID]('uuid).cast[taggedTypes.TerminologyBundleAxiomUUID]
		    val x_bundleUUID: TypedColumn[api.BundledTerminologyAxiom, taggedTypes.BundleUUID]
		  = x.col[taggedTypes.BundleUUID]('bundleUUID)
		
	      
	    val result
	    : TypedDataset[api.TerminologyBundleAxiom]
	    = x
		  .select[
		  taggedTypes.TerminologyBundleAxiomUUID,
		    taggedTypes.BundleUUID](
		  x_uuid,
		    x_bundleUUID)
		  .as[api.TerminologyBundleAxiom]
		  
		result
	  })

	// 1 smart projects for api.ChainRule
	
	implicit val ChainRule2RuleSmartProject
	: SmartProject
	  [ api.ChainRule,
	    api.Rule]
	= SmartProject
	  [ api.ChainRule,
		api.Rule](
		  (x: TypedDataset[api.ChainRule]) => {
		    val x_uuid: TypedColumn[api.ChainRule, taggedTypes.RuleUUID]
		  = x.col[taggedTypes.ChainRuleUUID]('uuid).cast[taggedTypes.RuleUUID]
		    val x_tboxUUID: TypedColumn[api.ChainRule, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.ChainRule, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Rule]
	    = x
		  .select[
		  taggedTypes.RuleUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Rule]
		  
		result
	  })

	// 2 smart projects for api.Concept
	
	implicit val Concept2ConceptualEntitySmartProject
	: SmartProject
	  [ api.Concept,
	    api.ConceptualEntity]
	= SmartProject
	  [ api.Concept,
		api.ConceptualEntity](
		  (x: TypedDataset[api.Concept]) => {
		    val x_uuid: TypedColumn[api.Concept, taggedTypes.ConceptualEntityUUID]
		  = x.col[taggedTypes.ConceptUUID]('uuid).cast[taggedTypes.ConceptualEntityUUID]
		    val x_tboxUUID: TypedColumn[api.Concept, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.Concept, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.ConceptualEntity]
	    = x
		  .select[
		  taggedTypes.ConceptualEntityUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.ConceptualEntity]
		  
		result
	  })

	implicit val Concept2UnaryTermKindSmartProject
	: SmartProject
	  [ api.Concept,
	    api.UnaryTermKind]
	= SmartProject
	  [ api.Concept,
		api.UnaryTermKind](
		  (x: TypedDataset[api.Concept]) => {
		    val x_uuid: TypedColumn[api.Concept, taggedTypes.UnaryTermKindUUID]
		  = x.col[taggedTypes.ConceptUUID]('uuid).cast[taggedTypes.UnaryTermKindUUID]
		    val x_tboxUUID: TypedColumn[api.Concept, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.Concept, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.UnaryTermKind]
	    = x
		  .select[
		  taggedTypes.UnaryTermKindUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.UnaryTermKind]
		  
		result
	  })

	// 1 smart projects for api.ConceptDesignationTerminologyAxiom
	
	implicit val ConceptDesignationTerminologyAxiom2TerminologyBoxAxiomSmartProject
	: SmartProject
	  [ api.ConceptDesignationTerminologyAxiom,
	    api.TerminologyBoxAxiom]
	= SmartProject
	  [ api.ConceptDesignationTerminologyAxiom,
		api.TerminologyBoxAxiom](
		  (x: TypedDataset[api.ConceptDesignationTerminologyAxiom]) => {
		    val x_uuid: TypedColumn[api.ConceptDesignationTerminologyAxiom, taggedTypes.TerminologyBoxAxiomUUID]
		  = x.col[taggedTypes.ConceptDesignationTerminologyAxiomUUID]('uuid).cast[taggedTypes.TerminologyBoxAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.ConceptDesignationTerminologyAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.TerminologyBoxAxiom]
	    = x
		  .select[
		  taggedTypes.TerminologyBoxAxiomUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.TerminologyBoxAxiom]
		  
		result
	  })

	// 1 smart projects for api.ConceptInstance
	
	implicit val ConceptInstance2ConceptualEntitySingletonInstanceSmartProject
	: SmartProject
	  [ api.ConceptInstance,
	    api.ConceptualEntitySingletonInstance]
	= SmartProject
	  [ api.ConceptInstance,
		api.ConceptualEntitySingletonInstance](
		  (x: TypedDataset[api.ConceptInstance]) => {
		    val x_uuid: TypedColumn[api.ConceptInstance, taggedTypes.ConceptualEntitySingletonInstanceUUID]
		  = x.col[taggedTypes.ConceptInstanceUUID]('uuid).cast[taggedTypes.ConceptualEntitySingletonInstanceUUID]
		    val x_name: TypedColumn[api.ConceptInstance, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.ConceptualEntitySingletonInstance]
	    = x
		  .select[
		  taggedTypes.ConceptualEntitySingletonInstanceUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_name)
		  .as[api.ConceptualEntitySingletonInstance]
		  
		result
	  })

	// 1 smart projects for api.ConceptPredicate
	
	implicit val ConceptPredicate2UnarySegmentPredicateSmartProject
	: SmartProject
	  [ api.ConceptPredicate,
	    api.UnarySegmentPredicate]
	= SmartProject
	  [ api.ConceptPredicate,
		api.UnarySegmentPredicate](
		  (x: TypedDataset[api.ConceptPredicate]) => {
		    val x_uuid: TypedColumn[api.ConceptPredicate, taggedTypes.UnarySegmentPredicateUUID]
		  = x.col[taggedTypes.ConceptPredicateUUID]('uuid).cast[taggedTypes.UnarySegmentPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.ConceptPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.UnarySegmentPredicate]
	    = x
		  .select[
		  taggedTypes.UnarySegmentPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.UnarySegmentPredicate]
		  
		result
	  })

	// 1 smart projects for api.ConceptSpecializationAxiom
	
	implicit val ConceptSpecializationAxiom2SpecializationAxiomSmartProject
	: SmartProject
	  [ api.ConceptSpecializationAxiom,
	    api.SpecializationAxiom]
	= SmartProject
	  [ api.ConceptSpecializationAxiom,
		api.SpecializationAxiom](
		  (x: TypedDataset[api.ConceptSpecializationAxiom]) => {
		    val x_uuid: TypedColumn[api.ConceptSpecializationAxiom, taggedTypes.SpecializationAxiomUUID]
		  = x.col[taggedTypes.ConceptSpecializationAxiomUUID]('uuid).cast[taggedTypes.SpecializationAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.ConceptSpecializationAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.SpecializationAxiom]
	    = x
		  .select[
		  taggedTypes.SpecializationAxiomUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.SpecializationAxiom]
		  
		result
	  })

	// 1 smart projects for api.ConceptTreeDisjunction
	
	// 1 smart projects for api.ConceptualEntity
	
	implicit val ConceptualEntity2EntitySmartProject
	: SmartProject
	  [ api.ConceptualEntity,
	    api.Entity]
	= SmartProject
	  [ api.ConceptualEntity,
		api.Entity](
		  (x: TypedDataset[api.ConceptualEntity]) => {
		    val x_uuid: TypedColumn[api.ConceptualEntity, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.ConceptualEntityUUID]('uuid).cast[taggedTypes.EntityUUID]
		    val x_tboxUUID: TypedColumn[api.ConceptualEntity, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.ConceptualEntity, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Entity]
	    = x
		  .select[
		  taggedTypes.EntityUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Entity]
		  
		result
	  })

	// 2 smart projects for api.ConceptualEntitySingletonInstance
	
	// 1 smart projects for api.DataRange
	
	implicit val DataRange2DatatypeSmartProject
	: SmartProject
	  [ api.DataRange,
	    api.Datatype]
	= SmartProject
	  [ api.DataRange,
		api.Datatype](
		  (x: TypedDataset[api.DataRange]) => {
		    val x_uuid: TypedColumn[api.DataRange, taggedTypes.DatatypeUUID]
		  = x.col[taggedTypes.DataRangeUUID]('uuid).cast[taggedTypes.DatatypeUUID]
		    val x_tboxUUID: TypedColumn[api.DataRange, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.DataRange, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Datatype]
	    = x
		  .select[
		  taggedTypes.DatatypeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Datatype]
		  
		result
	  })

	// 2 smart projects for api.DataRelationship
	
	implicit val DataRelationship2DirectedBinaryRelationshipKindSmartProject
	: SmartProject
	  [ api.DataRelationship,
	    api.DirectedBinaryRelationshipKind]
	= SmartProject
	  [ api.DataRelationship,
		api.DirectedBinaryRelationshipKind](
		  (x: TypedDataset[api.DataRelationship]) => {
		    val x_uuid: TypedColumn[api.DataRelationship, taggedTypes.DirectedBinaryRelationshipKindUUID]
		  = x.col[taggedTypes.DataRelationshipUUID]('uuid).cast[taggedTypes.DirectedBinaryRelationshipKindUUID]
		    val x_tboxUUID: TypedColumn[api.DataRelationship, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.DataRelationship, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DirectedBinaryRelationshipKind]
	    = x
		  .select[
		  taggedTypes.DirectedBinaryRelationshipKindUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DirectedBinaryRelationshipKind]
		  
		result
	  })

	implicit val DataRelationship2TermSmartProject
	: SmartProject
	  [ api.DataRelationship,
	    api.Term]
	= SmartProject
	  [ api.DataRelationship,
		api.Term](
		  (x: TypedDataset[api.DataRelationship]) => {
		    val x_uuid: TypedColumn[api.DataRelationship, taggedTypes.TermUUID]
		  = x.col[taggedTypes.DataRelationshipUUID]('uuid).cast[taggedTypes.TermUUID]
		    val x_tboxUUID: TypedColumn[api.DataRelationship, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.DataRelationship, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Term]
	    = x
		  .select[
		  taggedTypes.TermUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Term]
		  
		result
	  })

	// 1 smart projects for api.DataRelationshipDomain
	
	implicit val DataRelationshipDomain2DataRelationshipSmartProject
	: SmartProject
	  [ api.DataRelationshipDomain,
	    api.DataRelationship]
	= SmartProject
	  [ api.DataRelationshipDomain,
		api.DataRelationship](
		  (x: TypedDataset[api.DataRelationshipDomain]) => {
		    val x_uuid: TypedColumn[api.DataRelationshipDomain, taggedTypes.DataRelationshipUUID]
		  = x.col[taggedTypes.DataRelationshipDomainUUID]('uuid).cast[taggedTypes.DataRelationshipUUID]
		    val x_tboxUUID: TypedColumn[api.DataRelationshipDomain, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.DataRelationshipDomain, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationship]
	    = x
		  .select[
		  taggedTypes.DataRelationshipUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRelationship]
		  
		result
	  })

	// 1 smart projects for api.DataRelationshipFromEntity
	
	implicit val DataRelationshipFromEntity2DataRelationshipDomainSmartProject
	: SmartProject
	  [ api.DataRelationshipFromEntity,
	    api.DataRelationshipDomain]
	= SmartProject
	  [ api.DataRelationshipFromEntity,
		api.DataRelationshipDomain](
		  (x: TypedDataset[api.DataRelationshipFromEntity]) => {
		    val x_uuid: TypedColumn[api.DataRelationshipFromEntity, taggedTypes.DataRelationshipDomainUUID]
		  = x.col[taggedTypes.DataRelationshipFromEntityUUID]('uuid).cast[taggedTypes.DataRelationshipDomainUUID]
		    val x_tboxUUID: TypedColumn[api.DataRelationshipFromEntity, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.DataRelationshipFromEntity, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipDomain]
	    = x
		  .select[
		  taggedTypes.DataRelationshipDomainUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRelationshipDomain]
		  
		result
	  })

	// 1 smart projects for api.DataRelationshipFromStructure
	
	implicit val DataRelationshipFromStructure2DataRelationshipDomainSmartProject
	: SmartProject
	  [ api.DataRelationshipFromStructure,
	    api.DataRelationshipDomain]
	= SmartProject
	  [ api.DataRelationshipFromStructure,
		api.DataRelationshipDomain](
		  (x: TypedDataset[api.DataRelationshipFromStructure]) => {
		    val x_uuid: TypedColumn[api.DataRelationshipFromStructure, taggedTypes.DataRelationshipDomainUUID]
		  = x.col[taggedTypes.DataRelationshipFromStructureUUID]('uuid).cast[taggedTypes.DataRelationshipDomainUUID]
		    val x_tboxUUID: TypedColumn[api.DataRelationshipFromStructure, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.DataRelationshipFromStructure, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipDomain]
	    = x
		  .select[
		  taggedTypes.DataRelationshipDomainUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRelationshipDomain]
		  
		result
	  })

	// 1 smart projects for api.DataRelationshipRange
	
	implicit val DataRelationshipRange2DataRelationshipSmartProject
	: SmartProject
	  [ api.DataRelationshipRange,
	    api.DataRelationship]
	= SmartProject
	  [ api.DataRelationshipRange,
		api.DataRelationship](
		  (x: TypedDataset[api.DataRelationshipRange]) => {
		    val x_uuid: TypedColumn[api.DataRelationshipRange, taggedTypes.DataRelationshipUUID]
		  = x.col[taggedTypes.DataRelationshipRangeUUID]('uuid).cast[taggedTypes.DataRelationshipUUID]
		    val x_tboxUUID: TypedColumn[api.DataRelationshipRange, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.DataRelationshipRange, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationship]
	    = x
		  .select[
		  taggedTypes.DataRelationshipUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRelationship]
		  
		result
	  })

	// 1 smart projects for api.DataRelationshipToScalar
	
	implicit val DataRelationshipToScalar2DataRelationshipRangeSmartProject
	: SmartProject
	  [ api.DataRelationshipToScalar,
	    api.DataRelationshipRange]
	= SmartProject
	  [ api.DataRelationshipToScalar,
		api.DataRelationshipRange](
		  (x: TypedDataset[api.DataRelationshipToScalar]) => {
		    val x_uuid: TypedColumn[api.DataRelationshipToScalar, taggedTypes.DataRelationshipRangeUUID]
		  = x.col[taggedTypes.DataRelationshipToScalarUUID]('uuid).cast[taggedTypes.DataRelationshipRangeUUID]
		    val x_tboxUUID: TypedColumn[api.DataRelationshipToScalar, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.DataRelationshipToScalar, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipRange]
	    = x
		  .select[
		  taggedTypes.DataRelationshipRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRelationshipRange]
		  
		result
	  })

	// 1 smart projects for api.DataRelationshipToStructure
	
	implicit val DataRelationshipToStructure2DataRelationshipRangeSmartProject
	: SmartProject
	  [ api.DataRelationshipToStructure,
	    api.DataRelationshipRange]
	= SmartProject
	  [ api.DataRelationshipToStructure,
		api.DataRelationshipRange](
		  (x: TypedDataset[api.DataRelationshipToStructure]) => {
		    val x_uuid: TypedColumn[api.DataRelationshipToStructure, taggedTypes.DataRelationshipRangeUUID]
		  = x.col[taggedTypes.DataRelationshipToStructureUUID]('uuid).cast[taggedTypes.DataRelationshipRangeUUID]
		    val x_tboxUUID: TypedColumn[api.DataRelationshipToStructure, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.DataRelationshipToStructure, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipRange]
	    = x
		  .select[
		  taggedTypes.DataRelationshipRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRelationshipRange]
		  
		result
	  })

	// 1 smart projects for api.Datatype
	
	implicit val Datatype2TermSmartProject
	: SmartProject
	  [ api.Datatype,
	    api.Term]
	= SmartProject
	  [ api.Datatype,
		api.Term](
		  (x: TypedDataset[api.Datatype]) => {
		    val x_uuid: TypedColumn[api.Datatype, taggedTypes.TermUUID]
		  = x.col[taggedTypes.DatatypeUUID]('uuid).cast[taggedTypes.TermUUID]
		    val x_tboxUUID: TypedColumn[api.Datatype, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.Datatype, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Term]
	    = x
		  .select[
		  taggedTypes.TermUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Term]
		  
		result
	  })

	// 1 smart projects for api.DescriptionBox
	
	implicit val DescriptionBox2ModuleSmartProject
	: SmartProject
	  [ api.DescriptionBox,
	    api.Module]
	= SmartProject
	  [ api.DescriptionBox,
		api.Module](
		  (x: TypedDataset[api.DescriptionBox]) => {
		    val x_uuid: TypedColumn[api.DescriptionBox, taggedTypes.ModuleUUID]
		  = x.col[taggedTypes.DescriptionBoxUUID]('uuid).cast[taggedTypes.ModuleUUID]
		    val x_iri: TypedColumn[api.DescriptionBox, taggedTypes.IRI]
		  = x.col[taggedTypes.IRI]('iri)
		
	      
	    val result
	    : TypedDataset[api.Module]
	    = x
		  .select[
		  taggedTypes.ModuleUUID,
		    taggedTypes.IRI](
		  x_uuid,
		    x_iri)
		  .as[api.Module]
		  
		result
	  })

	// 1 smart projects for api.DescriptionBoxExtendsClosedWorldDefinitions
	
	// 1 smart projects for api.DescriptionBoxRefinement
	
	// 1 smart projects for api.DescriptionBoxRelationship
	
	// 1 smart projects for api.DirectedBinaryRelationshipKind
	
	implicit val DirectedBinaryRelationshipKind2TermSmartProject
	: SmartProject
	  [ api.DirectedBinaryRelationshipKind,
	    api.Term]
	= SmartProject
	  [ api.DirectedBinaryRelationshipKind,
		api.Term](
		  (x: TypedDataset[api.DirectedBinaryRelationshipKind]) => {
		    val x_uuid: TypedColumn[api.DirectedBinaryRelationshipKind, taggedTypes.TermUUID]
		  = x.col[taggedTypes.DirectedBinaryRelationshipKindUUID]('uuid).cast[taggedTypes.TermUUID]
		    val x_tboxUUID: TypedColumn[api.DirectedBinaryRelationshipKind, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.DirectedBinaryRelationshipKind, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Term]
	    = x
		  .select[
		  taggedTypes.TermUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Term]
		  
		result
	  })

	// 1 smart projects for api.DisjointUnionOfConceptsAxiom
	
	// 1 smart projects for api.Entity
	
	implicit val Entity2TermSmartProject
	: SmartProject
	  [ api.Entity,
	    api.Term]
	= SmartProject
	  [ api.Entity,
		api.Term](
		  (x: TypedDataset[api.Entity]) => {
		    val x_uuid: TypedColumn[api.Entity, taggedTypes.TermUUID]
		  = x.col[taggedTypes.EntityUUID]('uuid).cast[taggedTypes.TermUUID]
		    val x_tboxUUID: TypedColumn[api.Entity, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.Entity, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Term]
	    = x
		  .select[
		  taggedTypes.TermUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Term]
		  
		result
	  })

	// 1 smart projects for api.EntityExistentialRestrictionAxiom
	
	implicit val EntityExistentialRestrictionAxiom2EntityRestrictionAxiomSmartProject
	: SmartProject
	  [ api.EntityExistentialRestrictionAxiom,
	    api.EntityRestrictionAxiom]
	= SmartProject
	  [ api.EntityExistentialRestrictionAxiom,
		api.EntityRestrictionAxiom](
		  (x: TypedDataset[api.EntityExistentialRestrictionAxiom]) => {
		    val x_uuid: TypedColumn[api.EntityExistentialRestrictionAxiom, taggedTypes.EntityRestrictionAxiomUUID]
		  = x.col[taggedTypes.EntityExistentialRestrictionAxiomUUID]('uuid).cast[taggedTypes.EntityRestrictionAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.EntityExistentialRestrictionAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedRelationUUID: TypedColumn[api.EntityExistentialRestrictionAxiom, taggedTypes.EntityRelationshipUUID]
		  = x.col[taggedTypes.EntityRelationshipUUID]('restrictedRelationUUID)
		    val x_restrictedDomainUUID: TypedColumn[api.EntityExistentialRestrictionAxiom, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('restrictedDomainUUID)
		    val x_restrictedRangeUUID: TypedColumn[api.EntityExistentialRestrictionAxiom, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('restrictedRangeUUID)
		
	      
	    val result
	    : TypedDataset[api.EntityRestrictionAxiom]
	    = x
		  .select[
		  taggedTypes.EntityRestrictionAxiomUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.EntityRelationshipUUID,
		    taggedTypes.EntityUUID,
		    taggedTypes.EntityUUID](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedRelationUUID,
		    x_restrictedDomainUUID,
		    x_restrictedRangeUUID)
		  .as[api.EntityRestrictionAxiom]
		  
		result
	  })

	// 2 smart projects for api.EntityRelationship
	
	implicit val EntityRelationship2DirectedBinaryRelationshipKindSmartProject
	: SmartProject
	  [ api.EntityRelationship,
	    api.DirectedBinaryRelationshipKind]
	= SmartProject
	  [ api.EntityRelationship,
		api.DirectedBinaryRelationshipKind](
		  (x: TypedDataset[api.EntityRelationship]) => {
		    val x_uuid: TypedColumn[api.EntityRelationship, taggedTypes.DirectedBinaryRelationshipKindUUID]
		  = x.col[taggedTypes.EntityRelationshipUUID]('uuid).cast[taggedTypes.DirectedBinaryRelationshipKindUUID]
		    val x_tboxUUID: TypedColumn[api.EntityRelationship, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.EntityRelationship, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DirectedBinaryRelationshipKind]
	    = x
		  .select[
		  taggedTypes.DirectedBinaryRelationshipKindUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DirectedBinaryRelationshipKind]
		  
		result
	  })

	implicit val EntityRelationship2TermSmartProject
	: SmartProject
	  [ api.EntityRelationship,
	    api.Term]
	= SmartProject
	  [ api.EntityRelationship,
		api.Term](
		  (x: TypedDataset[api.EntityRelationship]) => {
		    val x_uuid: TypedColumn[api.EntityRelationship, taggedTypes.TermUUID]
		  = x.col[taggedTypes.EntityRelationshipUUID]('uuid).cast[taggedTypes.TermUUID]
		    val x_tboxUUID: TypedColumn[api.EntityRelationship, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.EntityRelationship, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Term]
	    = x
		  .select[
		  taggedTypes.TermUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Term]
		  
		result
	  })

	// 1 smart projects for api.EntityRestrictionAxiom
	
	implicit val EntityRestrictionAxiom2TermAxiomSmartProject
	: SmartProject
	  [ api.EntityRestrictionAxiom,
	    api.TermAxiom]
	= SmartProject
	  [ api.EntityRestrictionAxiom,
		api.TermAxiom](
		  (x: TypedDataset[api.EntityRestrictionAxiom]) => {
		    val x_uuid: TypedColumn[api.EntityRestrictionAxiom, taggedTypes.TermAxiomUUID]
		  = x.col[taggedTypes.EntityRestrictionAxiomUUID]('uuid).cast[taggedTypes.TermAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.EntityRestrictionAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.TermAxiom]
	    = x
		  .select[
		  taggedTypes.TermAxiomUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.TermAxiom]
		  
		result
	  })

	// 3 smart projects for api.EntityScalarDataProperty
	
	implicit val EntityScalarDataProperty2DataRelationshipSmartProject
	: SmartProject
	  [ api.EntityScalarDataProperty,
	    api.DataRelationship]
	= SmartProject
	  [ api.EntityScalarDataProperty,
		api.DataRelationship](
		  (x: TypedDataset[api.EntityScalarDataProperty]) => {
		    val x_uuid: TypedColumn[api.EntityScalarDataProperty, taggedTypes.DataRelationshipUUID]
		  = x.col[taggedTypes.EntityScalarDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipUUID]
		    val x_tboxUUID: TypedColumn[api.EntityScalarDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.EntityScalarDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationship]
	    = x
		  .select[
		  taggedTypes.DataRelationshipUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRelationship]
		  
		result
	  })

	implicit val EntityScalarDataProperty2DataRelationshipFromEntitySmartProject
	: SmartProject
	  [ api.EntityScalarDataProperty,
	    api.DataRelationshipFromEntity]
	= SmartProject
	  [ api.EntityScalarDataProperty,
		api.DataRelationshipFromEntity](
		  (x: TypedDataset[api.EntityScalarDataProperty]) => {
		    val x_uuid: TypedColumn[api.EntityScalarDataProperty, taggedTypes.DataRelationshipFromEntityUUID]
		  = x.col[taggedTypes.EntityScalarDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipFromEntityUUID]
		    val x_tboxUUID: TypedColumn[api.EntityScalarDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_domainUUID: TypedColumn[api.EntityScalarDataProperty, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('domainUUID)
		    val x_isIdentityCriteria: TypedColumn[api.EntityScalarDataProperty, scala.Boolean]
		  = x.col[scala.Boolean]('isIdentityCriteria)
		    val x_name: TypedColumn[api.EntityScalarDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipFromEntity]
	    = x
		  .select[
		  taggedTypes.DataRelationshipFromEntityUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.EntityUUID,
		    scala.Boolean,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_domainUUID,
		    x_isIdentityCriteria,
		    x_name)
		  .as[api.DataRelationshipFromEntity]
		  
		result
	  })

	implicit val EntityScalarDataProperty2DataRelationshipToScalarSmartProject
	: SmartProject
	  [ api.EntityScalarDataProperty,
	    api.DataRelationshipToScalar]
	= SmartProject
	  [ api.EntityScalarDataProperty,
		api.DataRelationshipToScalar](
		  (x: TypedDataset[api.EntityScalarDataProperty]) => {
		    val x_uuid: TypedColumn[api.EntityScalarDataProperty, taggedTypes.DataRelationshipToScalarUUID]
		  = x.col[taggedTypes.EntityScalarDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipToScalarUUID]
		    val x_tboxUUID: TypedColumn[api.EntityScalarDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_rangeUUID: TypedColumn[api.EntityScalarDataProperty, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.DataRangeUUID]('rangeUUID)
		    val x_name: TypedColumn[api.EntityScalarDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipToScalar]
	    = x
		  .select[
		  taggedTypes.DataRelationshipToScalarUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.DataRangeUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_rangeUUID,
		    x_name)
		  .as[api.DataRelationshipToScalar]
		  
		result
	  })

	// 1 smart projects for api.EntityScalarDataPropertyExistentialRestrictionAxiom
	
	implicit val EntityScalarDataPropertyExistentialRestrictionAxiom2EntityScalarDataPropertyRestrictionAxiomSmartProject
	: SmartProject
	  [ api.EntityScalarDataPropertyExistentialRestrictionAxiom,
	    api.EntityScalarDataPropertyRestrictionAxiom]
	= SmartProject
	  [ api.EntityScalarDataPropertyExistentialRestrictionAxiom,
		api.EntityScalarDataPropertyRestrictionAxiom](
		  (x: TypedDataset[api.EntityScalarDataPropertyExistentialRestrictionAxiom]) => {
		    val x_uuid: TypedColumn[api.EntityScalarDataPropertyExistentialRestrictionAxiom, taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]
		  = x.col[taggedTypes.EntityScalarDataPropertyExistentialRestrictionAxiomUUID]('uuid).cast[taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.EntityScalarDataPropertyExistentialRestrictionAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedEntityUUID: TypedColumn[api.EntityScalarDataPropertyExistentialRestrictionAxiom, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('restrictedEntityUUID)
		    val x_scalarPropertyUUID: TypedColumn[api.EntityScalarDataPropertyExistentialRestrictionAxiom, taggedTypes.EntityScalarDataPropertyUUID]
		  = x.col[taggedTypes.EntityScalarDataPropertyUUID]('scalarPropertyUUID)
		
	      
	    val result
	    : TypedDataset[api.EntityScalarDataPropertyRestrictionAxiom]
	    = x
		  .select[
		  taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.EntityUUID,
		    taggedTypes.EntityScalarDataPropertyUUID](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedEntityUUID,
		    x_scalarPropertyUUID)
		  .as[api.EntityScalarDataPropertyRestrictionAxiom]
		  
		result
	  })

	// 1 smart projects for api.EntityScalarDataPropertyParticularRestrictionAxiom
	
	implicit val EntityScalarDataPropertyParticularRestrictionAxiom2EntityScalarDataPropertyRestrictionAxiomSmartProject
	: SmartProject
	  [ api.EntityScalarDataPropertyParticularRestrictionAxiom,
	    api.EntityScalarDataPropertyRestrictionAxiom]
	= SmartProject
	  [ api.EntityScalarDataPropertyParticularRestrictionAxiom,
		api.EntityScalarDataPropertyRestrictionAxiom](
		  (x: TypedDataset[api.EntityScalarDataPropertyParticularRestrictionAxiom]) => {
		    val x_uuid: TypedColumn[api.EntityScalarDataPropertyParticularRestrictionAxiom, taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]
		  = x.col[taggedTypes.EntityScalarDataPropertyParticularRestrictionAxiomUUID]('uuid).cast[taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.EntityScalarDataPropertyParticularRestrictionAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedEntityUUID: TypedColumn[api.EntityScalarDataPropertyParticularRestrictionAxiom, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('restrictedEntityUUID)
		    val x_scalarPropertyUUID: TypedColumn[api.EntityScalarDataPropertyParticularRestrictionAxiom, taggedTypes.EntityScalarDataPropertyUUID]
		  = x.col[taggedTypes.EntityScalarDataPropertyUUID]('scalarPropertyUUID)
		
	      
	    val result
	    : TypedDataset[api.EntityScalarDataPropertyRestrictionAxiom]
	    = x
		  .select[
		  taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.EntityUUID,
		    taggedTypes.EntityScalarDataPropertyUUID](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedEntityUUID,
		    x_scalarPropertyUUID)
		  .as[api.EntityScalarDataPropertyRestrictionAxiom]
		  
		result
	  })

	// 1 smart projects for api.EntityScalarDataPropertyRestrictionAxiom
	
	implicit val EntityScalarDataPropertyRestrictionAxiom2TermAxiomSmartProject
	: SmartProject
	  [ api.EntityScalarDataPropertyRestrictionAxiom,
	    api.TermAxiom]
	= SmartProject
	  [ api.EntityScalarDataPropertyRestrictionAxiom,
		api.TermAxiom](
		  (x: TypedDataset[api.EntityScalarDataPropertyRestrictionAxiom]) => {
		    val x_uuid: TypedColumn[api.EntityScalarDataPropertyRestrictionAxiom, taggedTypes.TermAxiomUUID]
		  = x.col[taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]('uuid).cast[taggedTypes.TermAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.EntityScalarDataPropertyRestrictionAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.TermAxiom]
	    = x
		  .select[
		  taggedTypes.TermAxiomUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.TermAxiom]
		  
		result
	  })

	// 1 smart projects for api.EntityScalarDataPropertyUniversalRestrictionAxiom
	
	implicit val EntityScalarDataPropertyUniversalRestrictionAxiom2EntityScalarDataPropertyRestrictionAxiomSmartProject
	: SmartProject
	  [ api.EntityScalarDataPropertyUniversalRestrictionAxiom,
	    api.EntityScalarDataPropertyRestrictionAxiom]
	= SmartProject
	  [ api.EntityScalarDataPropertyUniversalRestrictionAxiom,
		api.EntityScalarDataPropertyRestrictionAxiom](
		  (x: TypedDataset[api.EntityScalarDataPropertyUniversalRestrictionAxiom]) => {
		    val x_uuid: TypedColumn[api.EntityScalarDataPropertyUniversalRestrictionAxiom, taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]
		  = x.col[taggedTypes.EntityScalarDataPropertyUniversalRestrictionAxiomUUID]('uuid).cast[taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.EntityScalarDataPropertyUniversalRestrictionAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedEntityUUID: TypedColumn[api.EntityScalarDataPropertyUniversalRestrictionAxiom, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('restrictedEntityUUID)
		    val x_scalarPropertyUUID: TypedColumn[api.EntityScalarDataPropertyUniversalRestrictionAxiom, taggedTypes.EntityScalarDataPropertyUUID]
		  = x.col[taggedTypes.EntityScalarDataPropertyUUID]('scalarPropertyUUID)
		
	      
	    val result
	    : TypedDataset[api.EntityScalarDataPropertyRestrictionAxiom]
	    = x
		  .select[
		  taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.EntityUUID,
		    taggedTypes.EntityScalarDataPropertyUUID](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedEntityUUID,
		    x_scalarPropertyUUID)
		  .as[api.EntityScalarDataPropertyRestrictionAxiom]
		  
		result
	  })

	// 3 smart projects for api.EntityStructuredDataProperty
	
	implicit val EntityStructuredDataProperty2DataRelationshipSmartProject
	: SmartProject
	  [ api.EntityStructuredDataProperty,
	    api.DataRelationship]
	= SmartProject
	  [ api.EntityStructuredDataProperty,
		api.DataRelationship](
		  (x: TypedDataset[api.EntityStructuredDataProperty]) => {
		    val x_uuid: TypedColumn[api.EntityStructuredDataProperty, taggedTypes.DataRelationshipUUID]
		  = x.col[taggedTypes.EntityStructuredDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipUUID]
		    val x_tboxUUID: TypedColumn[api.EntityStructuredDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.EntityStructuredDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationship]
	    = x
		  .select[
		  taggedTypes.DataRelationshipUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRelationship]
		  
		result
	  })

	implicit val EntityStructuredDataProperty2DataRelationshipFromEntitySmartProject
	: SmartProject
	  [ api.EntityStructuredDataProperty,
	    api.DataRelationshipFromEntity]
	= SmartProject
	  [ api.EntityStructuredDataProperty,
		api.DataRelationshipFromEntity](
		  (x: TypedDataset[api.EntityStructuredDataProperty]) => {
		    val x_uuid: TypedColumn[api.EntityStructuredDataProperty, taggedTypes.DataRelationshipFromEntityUUID]
		  = x.col[taggedTypes.EntityStructuredDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipFromEntityUUID]
		    val x_tboxUUID: TypedColumn[api.EntityStructuredDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_domainUUID: TypedColumn[api.EntityStructuredDataProperty, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('domainUUID)
		    val x_isIdentityCriteria: TypedColumn[api.EntityStructuredDataProperty, scala.Boolean]
		  = x.col[scala.Boolean]('isIdentityCriteria)
		    val x_name: TypedColumn[api.EntityStructuredDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipFromEntity]
	    = x
		  .select[
		  taggedTypes.DataRelationshipFromEntityUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.EntityUUID,
		    scala.Boolean,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_domainUUID,
		    x_isIdentityCriteria,
		    x_name)
		  .as[api.DataRelationshipFromEntity]
		  
		result
	  })

	implicit val EntityStructuredDataProperty2DataRelationshipToStructureSmartProject
	: SmartProject
	  [ api.EntityStructuredDataProperty,
	    api.DataRelationshipToStructure]
	= SmartProject
	  [ api.EntityStructuredDataProperty,
		api.DataRelationshipToStructure](
		  (x: TypedDataset[api.EntityStructuredDataProperty]) => {
		    val x_uuid: TypedColumn[api.EntityStructuredDataProperty, taggedTypes.DataRelationshipToStructureUUID]
		  = x.col[taggedTypes.EntityStructuredDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipToStructureUUID]
		    val x_tboxUUID: TypedColumn[api.EntityStructuredDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_rangeUUID: TypedColumn[api.EntityStructuredDataProperty, taggedTypes.StructureUUID]
		  = x.col[taggedTypes.StructureUUID]('rangeUUID)
		    val x_name: TypedColumn[api.EntityStructuredDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipToStructure]
	    = x
		  .select[
		  taggedTypes.DataRelationshipToStructureUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.StructureUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_rangeUUID,
		    x_name)
		  .as[api.DataRelationshipToStructure]
		  
		result
	  })

	// 2 smart projects for api.EntityStructuredDataPropertyParticularRestrictionAxiom
	
	implicit val EntityStructuredDataPropertyParticularRestrictionAxiom2EntityStructuredDataPropertyRestrictionAxiomSmartProject
	: SmartProject
	  [ api.EntityStructuredDataPropertyParticularRestrictionAxiom,
	    api.EntityStructuredDataPropertyRestrictionAxiom]
	= SmartProject
	  [ api.EntityStructuredDataPropertyParticularRestrictionAxiom,
		api.EntityStructuredDataPropertyRestrictionAxiom](
		  (x: TypedDataset[api.EntityStructuredDataPropertyParticularRestrictionAxiom]) => {
		    val x_uuid: TypedColumn[api.EntityStructuredDataPropertyParticularRestrictionAxiom, taggedTypes.EntityStructuredDataPropertyRestrictionAxiomUUID]
		  = x.col[taggedTypes.EntityStructuredDataPropertyParticularRestrictionAxiomUUID]('uuid).cast[taggedTypes.EntityStructuredDataPropertyRestrictionAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.EntityStructuredDataPropertyParticularRestrictionAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedEntityUUID: TypedColumn[api.EntityStructuredDataPropertyParticularRestrictionAxiom, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('restrictedEntityUUID)
		
	      
	    val result
	    : TypedDataset[api.EntityStructuredDataPropertyRestrictionAxiom]
	    = x
		  .select[
		  taggedTypes.EntityStructuredDataPropertyRestrictionAxiomUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.EntityUUID](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedEntityUUID)
		  .as[api.EntityStructuredDataPropertyRestrictionAxiom]
		  
		result
	  })

	implicit val EntityStructuredDataPropertyParticularRestrictionAxiom2RestrictionStructuredDataPropertyContextSmartProject
	: SmartProject
	  [ api.EntityStructuredDataPropertyParticularRestrictionAxiom,
	    api.RestrictionStructuredDataPropertyContext]
	= SmartProject
	  [ api.EntityStructuredDataPropertyParticularRestrictionAxiom,
		api.RestrictionStructuredDataPropertyContext](
		  (x: TypedDataset[api.EntityStructuredDataPropertyParticularRestrictionAxiom]) => {
		    val x_uuid: TypedColumn[api.EntityStructuredDataPropertyParticularRestrictionAxiom, taggedTypes.RestrictionStructuredDataPropertyContextUUID]
		  = x.col[taggedTypes.EntityStructuredDataPropertyParticularRestrictionAxiomUUID]('uuid).cast[taggedTypes.RestrictionStructuredDataPropertyContextUUID]
		    val x_structuredDataPropertyUUID: TypedColumn[api.EntityStructuredDataPropertyParticularRestrictionAxiom, taggedTypes.DataRelationshipToStructureUUID]
		  = x.col[taggedTypes.DataRelationshipToStructureUUID]('structuredDataPropertyUUID)
		
	      
	    val result
	    : TypedDataset[api.RestrictionStructuredDataPropertyContext]
	    = x
		  .select[
		  taggedTypes.RestrictionStructuredDataPropertyContextUUID,
		    taggedTypes.DataRelationshipToStructureUUID](
		  x_uuid,
		    x_structuredDataPropertyUUID)
		  .as[api.RestrictionStructuredDataPropertyContext]
		  
		result
	  })

	// 1 smart projects for api.EntityStructuredDataPropertyRestrictionAxiom
	
	implicit val EntityStructuredDataPropertyRestrictionAxiom2TermAxiomSmartProject
	: SmartProject
	  [ api.EntityStructuredDataPropertyRestrictionAxiom,
	    api.TermAxiom]
	= SmartProject
	  [ api.EntityStructuredDataPropertyRestrictionAxiom,
		api.TermAxiom](
		  (x: TypedDataset[api.EntityStructuredDataPropertyRestrictionAxiom]) => {
		    val x_uuid: TypedColumn[api.EntityStructuredDataPropertyRestrictionAxiom, taggedTypes.TermAxiomUUID]
		  = x.col[taggedTypes.EntityStructuredDataPropertyRestrictionAxiomUUID]('uuid).cast[taggedTypes.TermAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.EntityStructuredDataPropertyRestrictionAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.TermAxiom]
	    = x
		  .select[
		  taggedTypes.TermAxiomUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.TermAxiom]
		  
		result
	  })

	// 1 smart projects for api.EntityUniversalRestrictionAxiom
	
	implicit val EntityUniversalRestrictionAxiom2EntityRestrictionAxiomSmartProject
	: SmartProject
	  [ api.EntityUniversalRestrictionAxiom,
	    api.EntityRestrictionAxiom]
	= SmartProject
	  [ api.EntityUniversalRestrictionAxiom,
		api.EntityRestrictionAxiom](
		  (x: TypedDataset[api.EntityUniversalRestrictionAxiom]) => {
		    val x_uuid: TypedColumn[api.EntityUniversalRestrictionAxiom, taggedTypes.EntityRestrictionAxiomUUID]
		  = x.col[taggedTypes.EntityUniversalRestrictionAxiomUUID]('uuid).cast[taggedTypes.EntityRestrictionAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.EntityUniversalRestrictionAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedRelationUUID: TypedColumn[api.EntityUniversalRestrictionAxiom, taggedTypes.EntityRelationshipUUID]
		  = x.col[taggedTypes.EntityRelationshipUUID]('restrictedRelationUUID)
		    val x_restrictedDomainUUID: TypedColumn[api.EntityUniversalRestrictionAxiom, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('restrictedDomainUUID)
		    val x_restrictedRangeUUID: TypedColumn[api.EntityUniversalRestrictionAxiom, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('restrictedRangeUUID)
		
	      
	    val result
	    : TypedDataset[api.EntityRestrictionAxiom]
	    = x
		  .select[
		  taggedTypes.EntityRestrictionAxiomUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.EntityRelationshipUUID,
		    taggedTypes.EntityUUID,
		    taggedTypes.EntityUUID](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedRelationUUID,
		    x_restrictedDomainUUID,
		    x_restrictedRangeUUID)
		  .as[api.EntityRestrictionAxiom]
		  
		result
	  })

	// 1 smart projects for api.IRIScalarRestriction
	
	implicit val IRIScalarRestriction2RestrictedDataRangeSmartProject
	: SmartProject
	  [ api.IRIScalarRestriction,
	    api.RestrictedDataRange]
	= SmartProject
	  [ api.IRIScalarRestriction,
		api.RestrictedDataRange](
		  (x: TypedDataset[api.IRIScalarRestriction]) => {
		    val x_uuid: TypedColumn[api.IRIScalarRestriction, taggedTypes.RestrictedDataRangeUUID]
		  = x.col[taggedTypes.IRIScalarRestrictionUUID]('uuid).cast[taggedTypes.RestrictedDataRangeUUID]
		    val x_tboxUUID: TypedColumn[api.IRIScalarRestriction, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedRangeUUID: TypedColumn[api.IRIScalarRestriction, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.DataRangeUUID]('restrictedRangeUUID)
		    val x_name: TypedColumn[api.IRIScalarRestriction, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.RestrictedDataRange]
	    = x
		  .select[
		  taggedTypes.RestrictedDataRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.DataRangeUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedRangeUUID,
		    x_name)
		  .as[api.RestrictedDataRange]
		  
		result
	  })

	// 1 smart projects for api.Module
	
	// 1 smart projects for api.ModuleEdge
	
	// 1 smart projects for api.ModuleElement
	
	// 1 smart projects for api.NumericScalarRestriction
	
	implicit val NumericScalarRestriction2RestrictedDataRangeSmartProject
	: SmartProject
	  [ api.NumericScalarRestriction,
	    api.RestrictedDataRange]
	= SmartProject
	  [ api.NumericScalarRestriction,
		api.RestrictedDataRange](
		  (x: TypedDataset[api.NumericScalarRestriction]) => {
		    val x_uuid: TypedColumn[api.NumericScalarRestriction, taggedTypes.RestrictedDataRangeUUID]
		  = x.col[taggedTypes.NumericScalarRestrictionUUID]('uuid).cast[taggedTypes.RestrictedDataRangeUUID]
		    val x_tboxUUID: TypedColumn[api.NumericScalarRestriction, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedRangeUUID: TypedColumn[api.NumericScalarRestriction, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.DataRangeUUID]('restrictedRangeUUID)
		    val x_name: TypedColumn[api.NumericScalarRestriction, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.RestrictedDataRange]
	    = x
		  .select[
		  taggedTypes.RestrictedDataRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.DataRangeUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedRangeUUID,
		    x_name)
		  .as[api.RestrictedDataRange]
		  
		result
	  })

	// 1 smart projects for api.PlainLiteralScalarRestriction
	
	implicit val PlainLiteralScalarRestriction2RestrictedDataRangeSmartProject
	: SmartProject
	  [ api.PlainLiteralScalarRestriction,
	    api.RestrictedDataRange]
	= SmartProject
	  [ api.PlainLiteralScalarRestriction,
		api.RestrictedDataRange](
		  (x: TypedDataset[api.PlainLiteralScalarRestriction]) => {
		    val x_uuid: TypedColumn[api.PlainLiteralScalarRestriction, taggedTypes.RestrictedDataRangeUUID]
		  = x.col[taggedTypes.PlainLiteralScalarRestrictionUUID]('uuid).cast[taggedTypes.RestrictedDataRangeUUID]
		    val x_tboxUUID: TypedColumn[api.PlainLiteralScalarRestriction, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedRangeUUID: TypedColumn[api.PlainLiteralScalarRestriction, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.DataRangeUUID]('restrictedRangeUUID)
		    val x_name: TypedColumn[api.PlainLiteralScalarRestriction, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.RestrictedDataRange]
	    = x
		  .select[
		  taggedTypes.RestrictedDataRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.DataRangeUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedRangeUUID,
		    x_name)
		  .as[api.RestrictedDataRange]
		  
		result
	  })

	// 2 smart projects for api.ReifiedRelationship
	
	implicit val ReifiedRelationship2ConceptualEntitySmartProject
	: SmartProject
	  [ api.ReifiedRelationship,
	    api.ConceptualEntity]
	= SmartProject
	  [ api.ReifiedRelationship,
		api.ConceptualEntity](
		  (x: TypedDataset[api.ReifiedRelationship]) => {
		    val x_uuid: TypedColumn[api.ReifiedRelationship, taggedTypes.ConceptualEntityUUID]
		  = x.col[taggedTypes.ReifiedRelationshipUUID]('uuid).cast[taggedTypes.ConceptualEntityUUID]
		    val x_tboxUUID: TypedColumn[api.ReifiedRelationship, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.ReifiedRelationship, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.ConceptualEntity]
	    = x
		  .select[
		  taggedTypes.ConceptualEntityUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.ConceptualEntity]
		  
		result
	  })

	implicit val ReifiedRelationship2EntityRelationshipSmartProject
	: SmartProject
	  [ api.ReifiedRelationship,
	    api.EntityRelationship]
	= SmartProject
	  [ api.ReifiedRelationship,
		api.EntityRelationship](
		  (x: TypedDataset[api.ReifiedRelationship]) => {
		    val x_uuid: TypedColumn[api.ReifiedRelationship, taggedTypes.EntityRelationshipUUID]
		  = x.col[taggedTypes.ReifiedRelationshipUUID]('uuid).cast[taggedTypes.EntityRelationshipUUID]
		    val x_tboxUUID: TypedColumn[api.ReifiedRelationship, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_sourceUUID: TypedColumn[api.ReifiedRelationship, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('sourceUUID)
		    val x_targetUUID: TypedColumn[api.ReifiedRelationship, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('targetUUID)
		    val x_isAsymmetric: TypedColumn[api.ReifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isAsymmetric)
		    val x_isEssential: TypedColumn[api.ReifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isEssential)
		    val x_isFunctional: TypedColumn[api.ReifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isFunctional)
		    val x_isInverseEssential: TypedColumn[api.ReifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isInverseEssential)
		    val x_isInverseFunctional: TypedColumn[api.ReifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isInverseFunctional)
		    val x_isIrreflexive: TypedColumn[api.ReifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isIrreflexive)
		    val x_isReflexive: TypedColumn[api.ReifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isReflexive)
		    val x_isSymmetric: TypedColumn[api.ReifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isSymmetric)
		    val x_isTransitive: TypedColumn[api.ReifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isTransitive)
		    val x_name: TypedColumn[api.ReifiedRelationship, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.EntityRelationship]
	    = x
		  .select[
		  taggedTypes.EntityRelationshipUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.EntityUUID,
		    taggedTypes.EntityUUID,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_sourceUUID,
		    x_targetUUID,
		    x_isAsymmetric,
		    x_isEssential,
		    x_isFunctional,
		    x_isInverseEssential,
		    x_isInverseFunctional,
		    x_isIrreflexive,
		    x_isReflexive,
		    x_isSymmetric,
		    x_isTransitive,
		    x_name)
		  .as[api.EntityRelationship]
		  
		result
	  })

	// 1 smart projects for api.ReifiedRelationshipInstance
	
	implicit val ReifiedRelationshipInstance2ConceptualEntitySingletonInstanceSmartProject
	: SmartProject
	  [ api.ReifiedRelationshipInstance,
	    api.ConceptualEntitySingletonInstance]
	= SmartProject
	  [ api.ReifiedRelationshipInstance,
		api.ConceptualEntitySingletonInstance](
		  (x: TypedDataset[api.ReifiedRelationshipInstance]) => {
		    val x_uuid: TypedColumn[api.ReifiedRelationshipInstance, taggedTypes.ConceptualEntitySingletonInstanceUUID]
		  = x.col[taggedTypes.ReifiedRelationshipInstanceUUID]('uuid).cast[taggedTypes.ConceptualEntitySingletonInstanceUUID]
		    val x_name: TypedColumn[api.ReifiedRelationshipInstance, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.ConceptualEntitySingletonInstance]
	    = x
		  .select[
		  taggedTypes.ConceptualEntitySingletonInstanceUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_name)
		  .as[api.ConceptualEntitySingletonInstance]
		  
		result
	  })

	// 1 smart projects for api.ReifiedRelationshipInstanceDomain
	
	// 1 smart projects for api.ReifiedRelationshipInstanceRange
	
	// 1 smart projects for api.ReifiedRelationshipInversePropertyPredicate
	
	implicit val ReifiedRelationshipInversePropertyPredicate2BinarySegmentReversePropertyPredicateSmartProject
	: SmartProject
	  [ api.ReifiedRelationshipInversePropertyPredicate,
	    api.BinarySegmentReversePropertyPredicate]
	= SmartProject
	  [ api.ReifiedRelationshipInversePropertyPredicate,
		api.BinarySegmentReversePropertyPredicate](
		  (x: TypedDataset[api.ReifiedRelationshipInversePropertyPredicate]) => {
		    val x_uuid: TypedColumn[api.ReifiedRelationshipInversePropertyPredicate, taggedTypes.BinarySegmentReversePropertyPredicateUUID]
		  = x.col[taggedTypes.ReifiedRelationshipInversePropertyPredicateUUID]('uuid).cast[taggedTypes.BinarySegmentReversePropertyPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.ReifiedRelationshipInversePropertyPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.BinarySegmentReversePropertyPredicate]
	    = x
		  .select[
		  taggedTypes.BinarySegmentReversePropertyPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.BinarySegmentReversePropertyPredicate]
		  
		result
	  })

	// 1 smart projects for api.ReifiedRelationshipPredicate
	
	implicit val ReifiedRelationshipPredicate2UnarySegmentPredicateSmartProject
	: SmartProject
	  [ api.ReifiedRelationshipPredicate,
	    api.UnarySegmentPredicate]
	= SmartProject
	  [ api.ReifiedRelationshipPredicate,
		api.UnarySegmentPredicate](
		  (x: TypedDataset[api.ReifiedRelationshipPredicate]) => {
		    val x_uuid: TypedColumn[api.ReifiedRelationshipPredicate, taggedTypes.UnarySegmentPredicateUUID]
		  = x.col[taggedTypes.ReifiedRelationshipPredicateUUID]('uuid).cast[taggedTypes.UnarySegmentPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.ReifiedRelationshipPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.UnarySegmentPredicate]
	    = x
		  .select[
		  taggedTypes.UnarySegmentPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.UnarySegmentPredicate]
		  
		result
	  })

	// 1 smart projects for api.ReifiedRelationshipPropertyPredicate
	
	implicit val ReifiedRelationshipPropertyPredicate2BinarySegmentForwardPropertyPredicateSmartProject
	: SmartProject
	  [ api.ReifiedRelationshipPropertyPredicate,
	    api.BinarySegmentForwardPropertyPredicate]
	= SmartProject
	  [ api.ReifiedRelationshipPropertyPredicate,
		api.BinarySegmentForwardPropertyPredicate](
		  (x: TypedDataset[api.ReifiedRelationshipPropertyPredicate]) => {
		    val x_uuid: TypedColumn[api.ReifiedRelationshipPropertyPredicate, taggedTypes.BinarySegmentForwardPropertyPredicateUUID]
		  = x.col[taggedTypes.ReifiedRelationshipPropertyPredicateUUID]('uuid).cast[taggedTypes.BinarySegmentForwardPropertyPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.ReifiedRelationshipPropertyPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.BinarySegmentForwardPropertyPredicate]
	    = x
		  .select[
		  taggedTypes.BinarySegmentForwardPropertyPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.BinarySegmentForwardPropertyPredicate]
		  
		result
	  })

	// 1 smart projects for api.ReifiedRelationshipSourceInversePropertyPredicate
	
	implicit val ReifiedRelationshipSourceInversePropertyPredicate2BinarySegmentReversePropertyPredicateSmartProject
	: SmartProject
	  [ api.ReifiedRelationshipSourceInversePropertyPredicate,
	    api.BinarySegmentReversePropertyPredicate]
	= SmartProject
	  [ api.ReifiedRelationshipSourceInversePropertyPredicate,
		api.BinarySegmentReversePropertyPredicate](
		  (x: TypedDataset[api.ReifiedRelationshipSourceInversePropertyPredicate]) => {
		    val x_uuid: TypedColumn[api.ReifiedRelationshipSourceInversePropertyPredicate, taggedTypes.BinarySegmentReversePropertyPredicateUUID]
		  = x.col[taggedTypes.ReifiedRelationshipSourceInversePropertyPredicateUUID]('uuid).cast[taggedTypes.BinarySegmentReversePropertyPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.ReifiedRelationshipSourceInversePropertyPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.BinarySegmentReversePropertyPredicate]
	    = x
		  .select[
		  taggedTypes.BinarySegmentReversePropertyPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.BinarySegmentReversePropertyPredicate]
		  
		result
	  })

	// 1 smart projects for api.ReifiedRelationshipSourcePropertyPredicate
	
	implicit val ReifiedRelationshipSourcePropertyPredicate2BinarySegmentForwardPropertyPredicateSmartProject
	: SmartProject
	  [ api.ReifiedRelationshipSourcePropertyPredicate,
	    api.BinarySegmentForwardPropertyPredicate]
	= SmartProject
	  [ api.ReifiedRelationshipSourcePropertyPredicate,
		api.BinarySegmentForwardPropertyPredicate](
		  (x: TypedDataset[api.ReifiedRelationshipSourcePropertyPredicate]) => {
		    val x_uuid: TypedColumn[api.ReifiedRelationshipSourcePropertyPredicate, taggedTypes.BinarySegmentForwardPropertyPredicateUUID]
		  = x.col[taggedTypes.ReifiedRelationshipSourcePropertyPredicateUUID]('uuid).cast[taggedTypes.BinarySegmentForwardPropertyPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.ReifiedRelationshipSourcePropertyPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.BinarySegmentForwardPropertyPredicate]
	    = x
		  .select[
		  taggedTypes.BinarySegmentForwardPropertyPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.BinarySegmentForwardPropertyPredicate]
		  
		result
	  })

	// 1 smart projects for api.ReifiedRelationshipSpecializationAxiom
	
	implicit val ReifiedRelationshipSpecializationAxiom2SpecializationAxiomSmartProject
	: SmartProject
	  [ api.ReifiedRelationshipSpecializationAxiom,
	    api.SpecializationAxiom]
	= SmartProject
	  [ api.ReifiedRelationshipSpecializationAxiom,
		api.SpecializationAxiom](
		  (x: TypedDataset[api.ReifiedRelationshipSpecializationAxiom]) => {
		    val x_uuid: TypedColumn[api.ReifiedRelationshipSpecializationAxiom, taggedTypes.SpecializationAxiomUUID]
		  = x.col[taggedTypes.ReifiedRelationshipSpecializationAxiomUUID]('uuid).cast[taggedTypes.SpecializationAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.ReifiedRelationshipSpecializationAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.SpecializationAxiom]
	    = x
		  .select[
		  taggedTypes.SpecializationAxiomUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.SpecializationAxiom]
		  
		result
	  })

	// 1 smart projects for api.ReifiedRelationshipTargetInversePropertyPredicate
	
	implicit val ReifiedRelationshipTargetInversePropertyPredicate2BinarySegmentReversePropertyPredicateSmartProject
	: SmartProject
	  [ api.ReifiedRelationshipTargetInversePropertyPredicate,
	    api.BinarySegmentReversePropertyPredicate]
	= SmartProject
	  [ api.ReifiedRelationshipTargetInversePropertyPredicate,
		api.BinarySegmentReversePropertyPredicate](
		  (x: TypedDataset[api.ReifiedRelationshipTargetInversePropertyPredicate]) => {
		    val x_uuid: TypedColumn[api.ReifiedRelationshipTargetInversePropertyPredicate, taggedTypes.BinarySegmentReversePropertyPredicateUUID]
		  = x.col[taggedTypes.ReifiedRelationshipTargetInversePropertyPredicateUUID]('uuid).cast[taggedTypes.BinarySegmentReversePropertyPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.ReifiedRelationshipTargetInversePropertyPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.BinarySegmentReversePropertyPredicate]
	    = x
		  .select[
		  taggedTypes.BinarySegmentReversePropertyPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.BinarySegmentReversePropertyPredicate]
		  
		result
	  })

	// 1 smart projects for api.ReifiedRelationshipTargetPropertyPredicate
	
	implicit val ReifiedRelationshipTargetPropertyPredicate2BinarySegmentForwardPropertyPredicateSmartProject
	: SmartProject
	  [ api.ReifiedRelationshipTargetPropertyPredicate,
	    api.BinarySegmentForwardPropertyPredicate]
	= SmartProject
	  [ api.ReifiedRelationshipTargetPropertyPredicate,
		api.BinarySegmentForwardPropertyPredicate](
		  (x: TypedDataset[api.ReifiedRelationshipTargetPropertyPredicate]) => {
		    val x_uuid: TypedColumn[api.ReifiedRelationshipTargetPropertyPredicate, taggedTypes.BinarySegmentForwardPropertyPredicateUUID]
		  = x.col[taggedTypes.ReifiedRelationshipTargetPropertyPredicateUUID]('uuid).cast[taggedTypes.BinarySegmentForwardPropertyPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.ReifiedRelationshipTargetPropertyPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.BinarySegmentForwardPropertyPredicate]
	    = x
		  .select[
		  taggedTypes.BinarySegmentForwardPropertyPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.BinarySegmentForwardPropertyPredicate]
		  
		result
	  })

	// 1 smart projects for api.Resource
	
	// 1 smart projects for api.RestrictedDataRange
	
	implicit val RestrictedDataRange2DataRangeSmartProject
	: SmartProject
	  [ api.RestrictedDataRange,
	    api.DataRange]
	= SmartProject
	  [ api.RestrictedDataRange,
		api.DataRange](
		  (x: TypedDataset[api.RestrictedDataRange]) => {
		    val x_uuid: TypedColumn[api.RestrictedDataRange, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.RestrictedDataRangeUUID]('uuid).cast[taggedTypes.DataRangeUUID]
		    val x_tboxUUID: TypedColumn[api.RestrictedDataRange, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.RestrictedDataRange, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRange]
	    = x
		  .select[
		  taggedTypes.DataRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRange]
		  
		result
	  })

	// 1 smart projects for api.RestrictionScalarDataPropertyValue
	
	// 1 smart projects for api.RestrictionStructuredDataPropertyContext
	
	// 1 smart projects for api.RestrictionStructuredDataPropertyTuple
	
	implicit val RestrictionStructuredDataPropertyTuple2RestrictionStructuredDataPropertyContextSmartProject
	: SmartProject
	  [ api.RestrictionStructuredDataPropertyTuple,
	    api.RestrictionStructuredDataPropertyContext]
	= SmartProject
	  [ api.RestrictionStructuredDataPropertyTuple,
		api.RestrictionStructuredDataPropertyContext](
		  (x: TypedDataset[api.RestrictionStructuredDataPropertyTuple]) => {
		    val x_uuid: TypedColumn[api.RestrictionStructuredDataPropertyTuple, taggedTypes.RestrictionStructuredDataPropertyContextUUID]
		  = x.col[taggedTypes.RestrictionStructuredDataPropertyTupleUUID]('uuid).cast[taggedTypes.RestrictionStructuredDataPropertyContextUUID]
		    val x_structuredDataPropertyUUID: TypedColumn[api.RestrictionStructuredDataPropertyTuple, taggedTypes.DataRelationshipToStructureUUID]
		  = x.col[taggedTypes.DataRelationshipToStructureUUID]('structuredDataPropertyUUID)
		
	      
	    val result
	    : TypedDataset[api.RestrictionStructuredDataPropertyContext]
	    = x
		  .select[
		  taggedTypes.RestrictionStructuredDataPropertyContextUUID,
		    taggedTypes.DataRelationshipToStructureUUID](
		  x_uuid,
		    x_structuredDataPropertyUUID)
		  .as[api.RestrictionStructuredDataPropertyContext]
		  
		result
	  })

	// 2 smart projects for api.RootConceptTaxonomyAxiom
	
	implicit val RootConceptTaxonomyAxiom2TerminologyBundleStatementSmartProject
	: SmartProject
	  [ api.RootConceptTaxonomyAxiom,
	    api.TerminologyBundleStatement]
	= SmartProject
	  [ api.RootConceptTaxonomyAxiom,
		api.TerminologyBundleStatement](
		  (x: TypedDataset[api.RootConceptTaxonomyAxiom]) => {
		    val x_uuid: TypedColumn[api.RootConceptTaxonomyAxiom, taggedTypes.TerminologyBundleStatementUUID]
		  = x.col[taggedTypes.RootConceptTaxonomyAxiomUUID]('uuid).cast[taggedTypes.TerminologyBundleStatementUUID]
		    val x_bundleUUID: TypedColumn[api.RootConceptTaxonomyAxiom, taggedTypes.BundleUUID]
		  = x.col[taggedTypes.BundleUUID]('bundleUUID)
		
	      
	    val result
	    : TypedDataset[api.TerminologyBundleStatement]
	    = x
		  .select[
		  taggedTypes.TerminologyBundleStatementUUID,
		    taggedTypes.BundleUUID](
		  x_uuid,
		    x_bundleUUID)
		  .as[api.TerminologyBundleStatement]
		  
		result
	  })

	// 1 smart projects for api.Rule
	
	implicit val Rule2TermSmartProject
	: SmartProject
	  [ api.Rule,
	    api.Term]
	= SmartProject
	  [ api.Rule,
		api.Term](
		  (x: TypedDataset[api.Rule]) => {
		    val x_uuid: TypedColumn[api.Rule, taggedTypes.TermUUID]
		  = x.col[taggedTypes.RuleUUID]('uuid).cast[taggedTypes.TermUUID]
		    val x_tboxUUID: TypedColumn[api.Rule, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.Rule, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Term]
	    = x
		  .select[
		  taggedTypes.TermUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Term]
		  
		result
	  })

	// 1 smart projects for api.RuleBodySegment
	
	// 2 smart projects for api.Scalar
	
	implicit val Scalar2DataRangeSmartProject
	: SmartProject
	  [ api.Scalar,
	    api.DataRange]
	= SmartProject
	  [ api.Scalar,
		api.DataRange](
		  (x: TypedDataset[api.Scalar]) => {
		    val x_uuid: TypedColumn[api.Scalar, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.ScalarUUID]('uuid).cast[taggedTypes.DataRangeUUID]
		    val x_tboxUUID: TypedColumn[api.Scalar, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.Scalar, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRange]
	    = x
		  .select[
		  taggedTypes.DataRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRange]
		  
		result
	  })

	implicit val Scalar2UnaryTermKindSmartProject
	: SmartProject
	  [ api.Scalar,
	    api.UnaryTermKind]
	= SmartProject
	  [ api.Scalar,
		api.UnaryTermKind](
		  (x: TypedDataset[api.Scalar]) => {
		    val x_uuid: TypedColumn[api.Scalar, taggedTypes.UnaryTermKindUUID]
		  = x.col[taggedTypes.ScalarUUID]('uuid).cast[taggedTypes.UnaryTermKindUUID]
		    val x_tboxUUID: TypedColumn[api.Scalar, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.Scalar, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.UnaryTermKind]
	    = x
		  .select[
		  taggedTypes.UnaryTermKindUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.UnaryTermKind]
		  
		result
	  })

	// 3 smart projects for api.ScalarDataProperty
	
	implicit val ScalarDataProperty2DataRelationshipSmartProject
	: SmartProject
	  [ api.ScalarDataProperty,
	    api.DataRelationship]
	= SmartProject
	  [ api.ScalarDataProperty,
		api.DataRelationship](
		  (x: TypedDataset[api.ScalarDataProperty]) => {
		    val x_uuid: TypedColumn[api.ScalarDataProperty, taggedTypes.DataRelationshipUUID]
		  = x.col[taggedTypes.ScalarDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipUUID]
		    val x_tboxUUID: TypedColumn[api.ScalarDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.ScalarDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationship]
	    = x
		  .select[
		  taggedTypes.DataRelationshipUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRelationship]
		  
		result
	  })

	implicit val ScalarDataProperty2DataRelationshipFromStructureSmartProject
	: SmartProject
	  [ api.ScalarDataProperty,
	    api.DataRelationshipFromStructure]
	= SmartProject
	  [ api.ScalarDataProperty,
		api.DataRelationshipFromStructure](
		  (x: TypedDataset[api.ScalarDataProperty]) => {
		    val x_uuid: TypedColumn[api.ScalarDataProperty, taggedTypes.DataRelationshipFromStructureUUID]
		  = x.col[taggedTypes.ScalarDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipFromStructureUUID]
		    val x_tboxUUID: TypedColumn[api.ScalarDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_domainUUID: TypedColumn[api.ScalarDataProperty, taggedTypes.StructureUUID]
		  = x.col[taggedTypes.StructureUUID]('domainUUID)
		    val x_name: TypedColumn[api.ScalarDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipFromStructure]
	    = x
		  .select[
		  taggedTypes.DataRelationshipFromStructureUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.StructureUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_domainUUID,
		    x_name)
		  .as[api.DataRelationshipFromStructure]
		  
		result
	  })

	implicit val ScalarDataProperty2DataRelationshipToScalarSmartProject
	: SmartProject
	  [ api.ScalarDataProperty,
	    api.DataRelationshipToScalar]
	= SmartProject
	  [ api.ScalarDataProperty,
		api.DataRelationshipToScalar](
		  (x: TypedDataset[api.ScalarDataProperty]) => {
		    val x_uuid: TypedColumn[api.ScalarDataProperty, taggedTypes.DataRelationshipToScalarUUID]
		  = x.col[taggedTypes.ScalarDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipToScalarUUID]
		    val x_tboxUUID: TypedColumn[api.ScalarDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_rangeUUID: TypedColumn[api.ScalarDataProperty, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.DataRangeUUID]('rangeUUID)
		    val x_name: TypedColumn[api.ScalarDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipToScalar]
	    = x
		  .select[
		  taggedTypes.DataRelationshipToScalarUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.DataRangeUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_rangeUUID,
		    x_name)
		  .as[api.DataRelationshipToScalar]
		  
		result
	  })

	// 1 smart projects for api.ScalarDataPropertyValue
	
	// 1 smart projects for api.ScalarOneOfLiteralAxiom
	
	implicit val ScalarOneOfLiteralAxiom2TermAxiomSmartProject
	: SmartProject
	  [ api.ScalarOneOfLiteralAxiom,
	    api.TermAxiom]
	= SmartProject
	  [ api.ScalarOneOfLiteralAxiom,
		api.TermAxiom](
		  (x: TypedDataset[api.ScalarOneOfLiteralAxiom]) => {
		    val x_uuid: TypedColumn[api.ScalarOneOfLiteralAxiom, taggedTypes.TermAxiomUUID]
		  = x.col[taggedTypes.ScalarOneOfLiteralAxiomUUID]('uuid).cast[taggedTypes.TermAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.ScalarOneOfLiteralAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.TermAxiom]
	    = x
		  .select[
		  taggedTypes.TermAxiomUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.TermAxiom]
		  
		result
	  })

	// 1 smart projects for api.ScalarOneOfRestriction
	
	implicit val ScalarOneOfRestriction2RestrictedDataRangeSmartProject
	: SmartProject
	  [ api.ScalarOneOfRestriction,
	    api.RestrictedDataRange]
	= SmartProject
	  [ api.ScalarOneOfRestriction,
		api.RestrictedDataRange](
		  (x: TypedDataset[api.ScalarOneOfRestriction]) => {
		    val x_uuid: TypedColumn[api.ScalarOneOfRestriction, taggedTypes.RestrictedDataRangeUUID]
		  = x.col[taggedTypes.ScalarOneOfRestrictionUUID]('uuid).cast[taggedTypes.RestrictedDataRangeUUID]
		    val x_tboxUUID: TypedColumn[api.ScalarOneOfRestriction, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedRangeUUID: TypedColumn[api.ScalarOneOfRestriction, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.DataRangeUUID]('restrictedRangeUUID)
		    val x_name: TypedColumn[api.ScalarOneOfRestriction, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.RestrictedDataRange]
	    = x
		  .select[
		  taggedTypes.RestrictedDataRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.DataRangeUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedRangeUUID,
		    x_name)
		  .as[api.RestrictedDataRange]
		  
		result
	  })

	// 1 smart projects for api.SegmentPredicate
	
	// 1 smart projects for api.SingletonInstanceScalarDataPropertyValue
	
	// 1 smart projects for api.SingletonInstanceStructuredDataPropertyContext
	
	// 2 smart projects for api.SingletonInstanceStructuredDataPropertyValue
	
	implicit val SingletonInstanceStructuredDataPropertyValue2SingletonInstanceStructuredDataPropertyContextSmartProject
	: SmartProject
	  [ api.SingletonInstanceStructuredDataPropertyValue,
	    api.SingletonInstanceStructuredDataPropertyContext]
	= SmartProject
	  [ api.SingletonInstanceStructuredDataPropertyValue,
		api.SingletonInstanceStructuredDataPropertyContext](
		  (x: TypedDataset[api.SingletonInstanceStructuredDataPropertyValue]) => {
		    val x_uuid: TypedColumn[api.SingletonInstanceStructuredDataPropertyValue, taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID]
		  = x.col[taggedTypes.SingletonInstanceStructuredDataPropertyValueUUID]('uuid).cast[taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID]
		    val x_structuredDataPropertyUUID: TypedColumn[api.SingletonInstanceStructuredDataPropertyValue, taggedTypes.DataRelationshipToStructureUUID]
		  = x.col[taggedTypes.DataRelationshipToStructureUUID]('structuredDataPropertyUUID)
		
	      
	    val result
	    : TypedDataset[api.SingletonInstanceStructuredDataPropertyContext]
	    = x
		  .select[
		  taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID,
		    taggedTypes.DataRelationshipToStructureUUID](
		  x_uuid,
		    x_structuredDataPropertyUUID)
		  .as[api.SingletonInstanceStructuredDataPropertyContext]
		  
		result
	  })

	// 1 smart projects for api.SpecializationAxiom
	
	implicit val SpecializationAxiom2TermAxiomSmartProject
	: SmartProject
	  [ api.SpecializationAxiom,
	    api.TermAxiom]
	= SmartProject
	  [ api.SpecializationAxiom,
		api.TermAxiom](
		  (x: TypedDataset[api.SpecializationAxiom]) => {
		    val x_uuid: TypedColumn[api.SpecializationAxiom, taggedTypes.TermAxiomUUID]
		  = x.col[taggedTypes.SpecializationAxiomUUID]('uuid).cast[taggedTypes.TermAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.SpecializationAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.TermAxiom]
	    = x
		  .select[
		  taggedTypes.TermAxiomUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.TermAxiom]
		  
		result
	  })

	// 1 smart projects for api.SpecificDisjointConceptAxiom
	
	implicit val SpecificDisjointConceptAxiom2DisjointUnionOfConceptsAxiomSmartProject
	: SmartProject
	  [ api.SpecificDisjointConceptAxiom,
	    api.DisjointUnionOfConceptsAxiom]
	= SmartProject
	  [ api.SpecificDisjointConceptAxiom,
		api.DisjointUnionOfConceptsAxiom](
		  (x: TypedDataset[api.SpecificDisjointConceptAxiom]) => {
		    val x_uuid: TypedColumn[api.SpecificDisjointConceptAxiom, taggedTypes.DisjointUnionOfConceptsAxiomUUID]
		  = x.col[taggedTypes.SpecificDisjointConceptAxiomUUID]('uuid).cast[taggedTypes.DisjointUnionOfConceptsAxiomUUID]
		    val x_disjointTaxonomyParentUUID: TypedColumn[api.SpecificDisjointConceptAxiom, taggedTypes.ConceptTreeDisjunctionUUID]
		  = x.col[taggedTypes.ConceptTreeDisjunctionUUID]('disjointTaxonomyParentUUID)
		
	      
	    val result
	    : TypedDataset[api.DisjointUnionOfConceptsAxiom]
	    = x
		  .select[
		  taggedTypes.DisjointUnionOfConceptsAxiomUUID,
		    taggedTypes.ConceptTreeDisjunctionUUID](
		  x_uuid,
		    x_disjointTaxonomyParentUUID)
		  .as[api.DisjointUnionOfConceptsAxiom]
		  
		result
	  })

	// 1 smart projects for api.StringScalarRestriction
	
	implicit val StringScalarRestriction2RestrictedDataRangeSmartProject
	: SmartProject
	  [ api.StringScalarRestriction,
	    api.RestrictedDataRange]
	= SmartProject
	  [ api.StringScalarRestriction,
		api.RestrictedDataRange](
		  (x: TypedDataset[api.StringScalarRestriction]) => {
		    val x_uuid: TypedColumn[api.StringScalarRestriction, taggedTypes.RestrictedDataRangeUUID]
		  = x.col[taggedTypes.StringScalarRestrictionUUID]('uuid).cast[taggedTypes.RestrictedDataRangeUUID]
		    val x_tboxUUID: TypedColumn[api.StringScalarRestriction, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedRangeUUID: TypedColumn[api.StringScalarRestriction, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.DataRangeUUID]('restrictedRangeUUID)
		    val x_name: TypedColumn[api.StringScalarRestriction, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.RestrictedDataRange]
	    = x
		  .select[
		  taggedTypes.RestrictedDataRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.DataRangeUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedRangeUUID,
		    x_name)
		  .as[api.RestrictedDataRange]
		  
		result
	  })

	// 2 smart projects for api.Structure
	
	implicit val Structure2DatatypeSmartProject
	: SmartProject
	  [ api.Structure,
	    api.Datatype]
	= SmartProject
	  [ api.Structure,
		api.Datatype](
		  (x: TypedDataset[api.Structure]) => {
		    val x_uuid: TypedColumn[api.Structure, taggedTypes.DatatypeUUID]
		  = x.col[taggedTypes.StructureUUID]('uuid).cast[taggedTypes.DatatypeUUID]
		    val x_tboxUUID: TypedColumn[api.Structure, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.Structure, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Datatype]
	    = x
		  .select[
		  taggedTypes.DatatypeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Datatype]
		  
		result
	  })

	implicit val Structure2UnaryTermKindSmartProject
	: SmartProject
	  [ api.Structure,
	    api.UnaryTermKind]
	= SmartProject
	  [ api.Structure,
		api.UnaryTermKind](
		  (x: TypedDataset[api.Structure]) => {
		    val x_uuid: TypedColumn[api.Structure, taggedTypes.UnaryTermKindUUID]
		  = x.col[taggedTypes.StructureUUID]('uuid).cast[taggedTypes.UnaryTermKindUUID]
		    val x_tboxUUID: TypedColumn[api.Structure, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.Structure, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.UnaryTermKind]
	    = x
		  .select[
		  taggedTypes.UnaryTermKindUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.UnaryTermKind]
		  
		result
	  })

	// 3 smart projects for api.StructuredDataProperty
	
	implicit val StructuredDataProperty2DataRelationshipSmartProject
	: SmartProject
	  [ api.StructuredDataProperty,
	    api.DataRelationship]
	= SmartProject
	  [ api.StructuredDataProperty,
		api.DataRelationship](
		  (x: TypedDataset[api.StructuredDataProperty]) => {
		    val x_uuid: TypedColumn[api.StructuredDataProperty, taggedTypes.DataRelationshipUUID]
		  = x.col[taggedTypes.StructuredDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipUUID]
		    val x_tboxUUID: TypedColumn[api.StructuredDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.StructuredDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationship]
	    = x
		  .select[
		  taggedTypes.DataRelationshipUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.DataRelationship]
		  
		result
	  })

	implicit val StructuredDataProperty2DataRelationshipFromStructureSmartProject
	: SmartProject
	  [ api.StructuredDataProperty,
	    api.DataRelationshipFromStructure]
	= SmartProject
	  [ api.StructuredDataProperty,
		api.DataRelationshipFromStructure](
		  (x: TypedDataset[api.StructuredDataProperty]) => {
		    val x_uuid: TypedColumn[api.StructuredDataProperty, taggedTypes.DataRelationshipFromStructureUUID]
		  = x.col[taggedTypes.StructuredDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipFromStructureUUID]
		    val x_tboxUUID: TypedColumn[api.StructuredDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_domainUUID: TypedColumn[api.StructuredDataProperty, taggedTypes.StructureUUID]
		  = x.col[taggedTypes.StructureUUID]('domainUUID)
		    val x_name: TypedColumn[api.StructuredDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipFromStructure]
	    = x
		  .select[
		  taggedTypes.DataRelationshipFromStructureUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.StructureUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_domainUUID,
		    x_name)
		  .as[api.DataRelationshipFromStructure]
		  
		result
	  })

	implicit val StructuredDataProperty2DataRelationshipToStructureSmartProject
	: SmartProject
	  [ api.StructuredDataProperty,
	    api.DataRelationshipToStructure]
	= SmartProject
	  [ api.StructuredDataProperty,
		api.DataRelationshipToStructure](
		  (x: TypedDataset[api.StructuredDataProperty]) => {
		    val x_uuid: TypedColumn[api.StructuredDataProperty, taggedTypes.DataRelationshipToStructureUUID]
		  = x.col[taggedTypes.StructuredDataPropertyUUID]('uuid).cast[taggedTypes.DataRelationshipToStructureUUID]
		    val x_tboxUUID: TypedColumn[api.StructuredDataProperty, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_rangeUUID: TypedColumn[api.StructuredDataProperty, taggedTypes.StructureUUID]
		  = x.col[taggedTypes.StructureUUID]('rangeUUID)
		    val x_name: TypedColumn[api.StructuredDataProperty, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.DataRelationshipToStructure]
	    = x
		  .select[
		  taggedTypes.DataRelationshipToStructureUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.StructureUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_rangeUUID,
		    x_name)
		  .as[api.DataRelationshipToStructure]
		  
		result
	  })

	// 1 smart projects for api.StructuredDataPropertyTuple
	
	implicit val StructuredDataPropertyTuple2SingletonInstanceStructuredDataPropertyContextSmartProject
	: SmartProject
	  [ api.StructuredDataPropertyTuple,
	    api.SingletonInstanceStructuredDataPropertyContext]
	= SmartProject
	  [ api.StructuredDataPropertyTuple,
		api.SingletonInstanceStructuredDataPropertyContext](
		  (x: TypedDataset[api.StructuredDataPropertyTuple]) => {
		    val x_uuid: TypedColumn[api.StructuredDataPropertyTuple, taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID]
		  = x.col[taggedTypes.StructuredDataPropertyTupleUUID]('uuid).cast[taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID]
		    val x_structuredDataPropertyUUID: TypedColumn[api.StructuredDataPropertyTuple, taggedTypes.DataRelationshipToStructureUUID]
		  = x.col[taggedTypes.DataRelationshipToStructureUUID]('structuredDataPropertyUUID)
		
	      
	    val result
	    : TypedDataset[api.SingletonInstanceStructuredDataPropertyContext]
	    = x
		  .select[
		  taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID,
		    taggedTypes.DataRelationshipToStructureUUID](
		  x_uuid,
		    x_structuredDataPropertyUUID)
		  .as[api.SingletonInstanceStructuredDataPropertyContext]
		  
		result
	  })

	// 1 smart projects for api.SynonymScalarRestriction
	
	implicit val SynonymScalarRestriction2RestrictedDataRangeSmartProject
	: SmartProject
	  [ api.SynonymScalarRestriction,
	    api.RestrictedDataRange]
	= SmartProject
	  [ api.SynonymScalarRestriction,
		api.RestrictedDataRange](
		  (x: TypedDataset[api.SynonymScalarRestriction]) => {
		    val x_uuid: TypedColumn[api.SynonymScalarRestriction, taggedTypes.RestrictedDataRangeUUID]
		  = x.col[taggedTypes.SynonymScalarRestrictionUUID]('uuid).cast[taggedTypes.RestrictedDataRangeUUID]
		    val x_tboxUUID: TypedColumn[api.SynonymScalarRestriction, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedRangeUUID: TypedColumn[api.SynonymScalarRestriction, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.DataRangeUUID]('restrictedRangeUUID)
		    val x_name: TypedColumn[api.SynonymScalarRestriction, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.RestrictedDataRange]
	    = x
		  .select[
		  taggedTypes.RestrictedDataRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.DataRangeUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedRangeUUID,
		    x_name)
		  .as[api.RestrictedDataRange]
		  
		result
	  })

	// 2 smart projects for api.Term
	
	implicit val Term2TerminologyBoxStatementSmartProject
	: SmartProject
	  [ api.Term,
	    api.TerminologyBoxStatement]
	= SmartProject
	  [ api.Term,
		api.TerminologyBoxStatement](
		  (x: TypedDataset[api.Term]) => {
		    val x_uuid: TypedColumn[api.Term, taggedTypes.TerminologyBoxStatementUUID]
		  = x.col[taggedTypes.TermUUID]('uuid).cast[taggedTypes.TerminologyBoxStatementUUID]
		    val x_tboxUUID: TypedColumn[api.Term, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.TerminologyBoxStatement]
	    = x
		  .select[
		  taggedTypes.TerminologyBoxStatementUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.TerminologyBoxStatement]
		  
		result
	  })

	// 1 smart projects for api.TermAxiom
	
	implicit val TermAxiom2TerminologyBoxStatementSmartProject
	: SmartProject
	  [ api.TermAxiom,
	    api.TerminologyBoxStatement]
	= SmartProject
	  [ api.TermAxiom,
		api.TerminologyBoxStatement](
		  (x: TypedDataset[api.TermAxiom]) => {
		    val x_uuid: TypedColumn[api.TermAxiom, taggedTypes.TerminologyBoxStatementUUID]
		  = x.col[taggedTypes.TermAxiomUUID]('uuid).cast[taggedTypes.TerminologyBoxStatementUUID]
		    val x_tboxUUID: TypedColumn[api.TermAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.TerminologyBoxStatement]
	    = x
		  .select[
		  taggedTypes.TerminologyBoxStatementUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.TerminologyBoxStatement]
		  
		result
	  })

	// 1 smart projects for api.TerminologyAxiom
	
	// 1 smart projects for api.TerminologyBox
	
	implicit val TerminologyBox2ModuleSmartProject
	: SmartProject
	  [ api.TerminologyBox,
	    api.Module]
	= SmartProject
	  [ api.TerminologyBox,
		api.Module](
		  (x: TypedDataset[api.TerminologyBox]) => {
		    val x_uuid: TypedColumn[api.TerminologyBox, taggedTypes.ModuleUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('uuid).cast[taggedTypes.ModuleUUID]
		    val x_iri: TypedColumn[api.TerminologyBox, taggedTypes.IRI]
		  = x.col[taggedTypes.IRI]('iri)
		
	      
	    val result
	    : TypedDataset[api.Module]
	    = x
		  .select[
		  taggedTypes.ModuleUUID,
		    taggedTypes.IRI](
		  x_uuid,
		    x_iri)
		  .as[api.Module]
		  
		result
	  })

	// 1 smart projects for api.TerminologyBoxAxiom
	
	// 1 smart projects for api.TerminologyBoxStatement
	
	// 1 smart projects for api.TerminologyBundleAxiom
	
	// 1 smart projects for api.TerminologyBundleStatement
	
	// 1 smart projects for api.TerminologyExtensionAxiom
	
	implicit val TerminologyExtensionAxiom2TerminologyBoxAxiomSmartProject
	: SmartProject
	  [ api.TerminologyExtensionAxiom,
	    api.TerminologyBoxAxiom]
	= SmartProject
	  [ api.TerminologyExtensionAxiom,
		api.TerminologyBoxAxiom](
		  (x: TypedDataset[api.TerminologyExtensionAxiom]) => {
		    val x_uuid: TypedColumn[api.TerminologyExtensionAxiom, taggedTypes.TerminologyBoxAxiomUUID]
		  = x.col[taggedTypes.TerminologyExtensionAxiomUUID]('uuid).cast[taggedTypes.TerminologyBoxAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.TerminologyExtensionAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.TerminologyBoxAxiom]
	    = x
		  .select[
		  taggedTypes.TerminologyBoxAxiomUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.TerminologyBoxAxiom]
		  
		result
	  })

	// 1 smart projects for api.TerminologyGraph
	
	implicit val TerminologyGraph2TerminologyBoxSmartProject
	: SmartProject
	  [ api.TerminologyGraph,
	    api.TerminologyBox]
	= SmartProject
	  [ api.TerminologyGraph,
		api.TerminologyBox](
		  (x: TypedDataset[api.TerminologyGraph]) => {
		    val x_uuid: TypedColumn[api.TerminologyGraph, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyGraphUUID]('uuid).cast[taggedTypes.TerminologyBoxUUID]
		    val x_kind: TypedColumn[api.TerminologyGraph, TerminologyKind]
		  = x.col[TerminologyKind]('kind)
		    val x_iri: TypedColumn[api.TerminologyGraph, taggedTypes.IRI]
		  = x.col[taggedTypes.IRI]('iri)
		
	      
	    val result
	    : TypedDataset[api.TerminologyBox]
	    = x
		  .select[
		  taggedTypes.TerminologyBoxUUID,
		    TerminologyKind,
		    taggedTypes.IRI](
		  x_uuid,
		    x_kind,
		    x_iri)
		  .as[api.TerminologyBox]
		  
		result
	  })

	// 1 smart projects for api.TerminologyInstanceAssertion
	
	// 1 smart projects for api.TerminologyNestingAxiom
	
	implicit val TerminologyNestingAxiom2TerminologyBoxAxiomSmartProject
	: SmartProject
	  [ api.TerminologyNestingAxiom,
	    api.TerminologyBoxAxiom]
	= SmartProject
	  [ api.TerminologyNestingAxiom,
		api.TerminologyBoxAxiom](
		  (x: TypedDataset[api.TerminologyNestingAxiom]) => {
		    val x_uuid: TypedColumn[api.TerminologyNestingAxiom, taggedTypes.TerminologyBoxAxiomUUID]
		  = x.col[taggedTypes.TerminologyNestingAxiomUUID]('uuid).cast[taggedTypes.TerminologyBoxAxiomUUID]
		    val x_tboxUUID: TypedColumn[api.TerminologyNestingAxiom, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		
	      
	    val result
	    : TypedDataset[api.TerminologyBoxAxiom]
	    = x
		  .select[
		  taggedTypes.TerminologyBoxAxiomUUID,
		    taggedTypes.TerminologyBoxUUID](
		  x_uuid,
		    x_tboxUUID)
		  .as[api.TerminologyBoxAxiom]
		  
		result
	  })

	// 1 smart projects for api.TimeScalarRestriction
	
	implicit val TimeScalarRestriction2RestrictedDataRangeSmartProject
	: SmartProject
	  [ api.TimeScalarRestriction,
	    api.RestrictedDataRange]
	= SmartProject
	  [ api.TimeScalarRestriction,
		api.RestrictedDataRange](
		  (x: TypedDataset[api.TimeScalarRestriction]) => {
		    val x_uuid: TypedColumn[api.TimeScalarRestriction, taggedTypes.RestrictedDataRangeUUID]
		  = x.col[taggedTypes.TimeScalarRestrictionUUID]('uuid).cast[taggedTypes.RestrictedDataRangeUUID]
		    val x_tboxUUID: TypedColumn[api.TimeScalarRestriction, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_restrictedRangeUUID: TypedColumn[api.TimeScalarRestriction, taggedTypes.DataRangeUUID]
		  = x.col[taggedTypes.DataRangeUUID]('restrictedRangeUUID)
		    val x_name: TypedColumn[api.TimeScalarRestriction, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.RestrictedDataRange]
	    = x
		  .select[
		  taggedTypes.RestrictedDataRangeUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.DataRangeUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_restrictedRangeUUID,
		    x_name)
		  .as[api.RestrictedDataRange]
		  
		result
	  })

	// 1 smart projects for api.UnarySegmentPredicate
	
	implicit val UnarySegmentPredicate2SegmentPredicateSmartProject
	: SmartProject
	  [ api.UnarySegmentPredicate,
	    api.SegmentPredicate]
	= SmartProject
	  [ api.UnarySegmentPredicate,
		api.SegmentPredicate](
		  (x: TypedDataset[api.UnarySegmentPredicate]) => {
		    val x_uuid: TypedColumn[api.UnarySegmentPredicate, taggedTypes.SegmentPredicateUUID]
		  = x.col[taggedTypes.UnarySegmentPredicateUUID]('uuid).cast[taggedTypes.SegmentPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.UnarySegmentPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.SegmentPredicate]
	    = x
		  .select[
		  taggedTypes.SegmentPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.SegmentPredicate]
		  
		result
	  })

	// 1 smart projects for api.UnaryTermKind
	
	implicit val UnaryTermKind2TermSmartProject
	: SmartProject
	  [ api.UnaryTermKind,
	    api.Term]
	= SmartProject
	  [ api.UnaryTermKind,
		api.Term](
		  (x: TypedDataset[api.UnaryTermKind]) => {
		    val x_uuid: TypedColumn[api.UnaryTermKind, taggedTypes.TermUUID]
		  = x.col[taggedTypes.UnaryTermKindUUID]('uuid).cast[taggedTypes.TermUUID]
		    val x_tboxUUID: TypedColumn[api.UnaryTermKind, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_name: TypedColumn[api.UnaryTermKind, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.Term]
	    = x
		  .select[
		  taggedTypes.TermUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_name)
		  .as[api.Term]
		  
		result
	  })

	// 1 smart projects for api.UnreifiedRelationship
	
	implicit val UnreifiedRelationship2EntityRelationshipSmartProject
	: SmartProject
	  [ api.UnreifiedRelationship,
	    api.EntityRelationship]
	= SmartProject
	  [ api.UnreifiedRelationship,
		api.EntityRelationship](
		  (x: TypedDataset[api.UnreifiedRelationship]) => {
		    val x_uuid: TypedColumn[api.UnreifiedRelationship, taggedTypes.EntityRelationshipUUID]
		  = x.col[taggedTypes.UnreifiedRelationshipUUID]('uuid).cast[taggedTypes.EntityRelationshipUUID]
		    val x_tboxUUID: TypedColumn[api.UnreifiedRelationship, taggedTypes.TerminologyBoxUUID]
		  = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
		    val x_sourceUUID: TypedColumn[api.UnreifiedRelationship, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('sourceUUID)
		    val x_targetUUID: TypedColumn[api.UnreifiedRelationship, taggedTypes.EntityUUID]
		  = x.col[taggedTypes.EntityUUID]('targetUUID)
		    val x_isAsymmetric: TypedColumn[api.UnreifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isAsymmetric)
		    val x_isEssential: TypedColumn[api.UnreifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isEssential)
		    val x_isFunctional: TypedColumn[api.UnreifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isFunctional)
		    val x_isInverseEssential: TypedColumn[api.UnreifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isInverseEssential)
		    val x_isInverseFunctional: TypedColumn[api.UnreifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isInverseFunctional)
		    val x_isIrreflexive: TypedColumn[api.UnreifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isIrreflexive)
		    val x_isReflexive: TypedColumn[api.UnreifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isReflexive)
		    val x_isSymmetric: TypedColumn[api.UnreifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isSymmetric)
		    val x_isTransitive: TypedColumn[api.UnreifiedRelationship, scala.Boolean]
		  = x.col[scala.Boolean]('isTransitive)
		    val x_name: TypedColumn[api.UnreifiedRelationship, taggedTypes.LocalName]
		  = x.col[taggedTypes.LocalName]('name)
		
	      
	    val result
	    : TypedDataset[api.EntityRelationship]
	    = x
		  .select[
		  taggedTypes.EntityRelationshipUUID,
		    taggedTypes.TerminologyBoxUUID,
		    taggedTypes.EntityUUID,
		    taggedTypes.EntityUUID,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    scala.Boolean,
		    taggedTypes.LocalName](
		  x_uuid,
		    x_tboxUUID,
		    x_sourceUUID,
		    x_targetUUID,
		    x_isAsymmetric,
		    x_isEssential,
		    x_isFunctional,
		    x_isInverseEssential,
		    x_isInverseFunctional,
		    x_isIrreflexive,
		    x_isReflexive,
		    x_isSymmetric,
		    x_isTransitive,
		    x_name)
		  .as[api.EntityRelationship]
		  
		result
	  })

	// 1 smart projects for api.UnreifiedRelationshipInstanceTuple
	
	// 1 smart projects for api.UnreifiedRelationshipInversePropertyPredicate
	
	implicit val UnreifiedRelationshipInversePropertyPredicate2BinarySegmentReversePropertyPredicateSmartProject
	: SmartProject
	  [ api.UnreifiedRelationshipInversePropertyPredicate,
	    api.BinarySegmentReversePropertyPredicate]
	= SmartProject
	  [ api.UnreifiedRelationshipInversePropertyPredicate,
		api.BinarySegmentReversePropertyPredicate](
		  (x: TypedDataset[api.UnreifiedRelationshipInversePropertyPredicate]) => {
		    val x_uuid: TypedColumn[api.UnreifiedRelationshipInversePropertyPredicate, taggedTypes.BinarySegmentReversePropertyPredicateUUID]
		  = x.col[taggedTypes.UnreifiedRelationshipInversePropertyPredicateUUID]('uuid).cast[taggedTypes.BinarySegmentReversePropertyPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.UnreifiedRelationshipInversePropertyPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.BinarySegmentReversePropertyPredicate]
	    = x
		  .select[
		  taggedTypes.BinarySegmentReversePropertyPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.BinarySegmentReversePropertyPredicate]
		  
		result
	  })

	// 1 smart projects for api.UnreifiedRelationshipPropertyPredicate
	
	implicit val UnreifiedRelationshipPropertyPredicate2BinarySegmentForwardPropertyPredicateSmartProject
	: SmartProject
	  [ api.UnreifiedRelationshipPropertyPredicate,
	    api.BinarySegmentForwardPropertyPredicate]
	= SmartProject
	  [ api.UnreifiedRelationshipPropertyPredicate,
		api.BinarySegmentForwardPropertyPredicate](
		  (x: TypedDataset[api.UnreifiedRelationshipPropertyPredicate]) => {
		    val x_uuid: TypedColumn[api.UnreifiedRelationshipPropertyPredicate, taggedTypes.BinarySegmentForwardPropertyPredicateUUID]
		  = x.col[taggedTypes.UnreifiedRelationshipPropertyPredicateUUID]('uuid).cast[taggedTypes.BinarySegmentForwardPropertyPredicateUUID]
		    val x_bodySegmentUUID: TypedColumn[api.UnreifiedRelationshipPropertyPredicate, taggedTypes.RuleBodySegmentUUID]
		  = x.col[taggedTypes.RuleBodySegmentUUID]('bodySegmentUUID)
		
	      
	    val result
	    : TypedDataset[api.BinarySegmentForwardPropertyPredicate]
	    = x
		  .select[
		  taggedTypes.BinarySegmentForwardPropertyPredicateUUID,
		    taggedTypes.RuleBodySegmentUUID](
		  x_uuid,
		    x_bodySegmentUUID)
		  .as[api.BinarySegmentForwardPropertyPredicate]
		  
		result
	  })

}
