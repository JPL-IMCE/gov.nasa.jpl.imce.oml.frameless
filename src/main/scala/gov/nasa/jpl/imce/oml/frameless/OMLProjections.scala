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
import shapeless.HNil
import gov.nasa.jpl.imce.oml.tables.TerminologyKind
import gov.nasa.jpl.imce.oml.tables.taggedTypes

object OMLProjections {
	
	import OMLSpecificationTypedDatasets._
	import OMLCatalystCasts._
	
	// 2 smart projects for api.AnnotationProperty
	
	// 2 smart projects for api.AnnotationPropertyValue
	
	// 2 smart projects for api.AnonymousConceptUnionAxiom
	
	implicit val AnonymousConceptUnionAxiom2DisjointUnionOfConceptsAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_disjointTaxonomyParentUUID ::
	            HNil)
	          .as[api.DisjointUnionOfConceptsAxiom]
	        result
	      })

	// 1 smart projects for api.Aspect
	
	implicit val Aspect2AspectKindProjection
	: SmartProject
	  [ api.Aspect,
	    api.AspectKind]
	= SmartProject
	  [ api.Aspect,
	    api.AspectKind](
	      (x: TypedDataset[api.Aspect]) => {
	        val x_uuid: TypedColumn[api.Aspect, taggedTypes.AspectKindUUID]
	        = x.col[taggedTypes.AspectUUID]('uuid).cast[taggedTypes.AspectKindUUID]
	    
	        val x_tboxUUID: TypedColumn[api.Aspect, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.Aspect, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.AspectKind]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.AspectKind]
	        result
	      })

	// 2 smart projects for api.AspectKind
	
	implicit val AspectKind2EntityProjection
	: SmartProject
	  [ api.AspectKind,
	    api.Entity]
	= SmartProject
	  [ api.AspectKind,
	    api.Entity](
	      (x: TypedDataset[api.AspectKind]) => {
	        val x_uuid: TypedColumn[api.AspectKind, taggedTypes.EntityUUID]
	        = x.col[taggedTypes.AspectKindUUID]('uuid).cast[taggedTypes.EntityUUID]
	    
	        val x_tboxUUID: TypedColumn[api.AspectKind, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.AspectKind, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.Entity]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Entity]
	        result
	      })

	implicit val AspectKind2UnaryTermKindProjection
	: SmartProject
	  [ api.AspectKind,
	    api.UnaryTermKind]
	= SmartProject
	  [ api.AspectKind,
	    api.UnaryTermKind](
	      (x: TypedDataset[api.AspectKind]) => {
	        val x_uuid: TypedColumn[api.AspectKind, taggedTypes.UnaryTermKindUUID]
	        = x.col[taggedTypes.AspectKindUUID]('uuid).cast[taggedTypes.UnaryTermKindUUID]
	    
	        val x_tboxUUID: TypedColumn[api.AspectKind, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.AspectKind, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.UnaryTermKind]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.UnaryTermKind]
	        result
	      })

	// 1 smart projects for api.AspectSpecializationAxiom
	
	implicit val AspectSpecializationAxiom2SpecializationAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.SpecializationAxiom]
	        result
	      })

	// 1 smart projects for api.BinaryScalarRestriction
	
	implicit val BinaryScalarRestriction2RestrictedDataRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedRangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.RestrictedDataRange]
	        result
	      })

	// 1 smart projects for api.Bundle
	
	implicit val Bundle2TerminologyBoxProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_kind :: 
	            x_iri ::
	            HNil)
	          .as[api.TerminologyBox]
	        result
	      })

	// 1 smart projects for api.BundledTerminologyAxiom
	
	implicit val BundledTerminologyAxiom2TerminologyBundleAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_bundleUUID ::
	            HNil)
	          .as[api.TerminologyBundleAxiom]
	        result
	      })

	// 1 smart projects for api.CardinalityRestrictedAspect
	
	implicit val CardinalityRestrictedAspect2AspectKindProjection
	: SmartProject
	  [ api.CardinalityRestrictedAspect,
	    api.AspectKind]
	= SmartProject
	  [ api.CardinalityRestrictedAspect,
	    api.AspectKind](
	      (x: TypedDataset[api.CardinalityRestrictedAspect]) => {
	        val x_uuid: TypedColumn[api.CardinalityRestrictedAspect, taggedTypes.AspectKindUUID]
	        = x.col[taggedTypes.CardinalityRestrictedAspectUUID]('uuid).cast[taggedTypes.AspectKindUUID]
	    
	        val x_tboxUUID: TypedColumn[api.CardinalityRestrictedAspect, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.CardinalityRestrictedAspect, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.AspectKind]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.AspectKind]
	        result
	      })

	// 1 smart projects for api.CardinalityRestrictedConcept
	
	implicit val CardinalityRestrictedConcept2ConceptKindProjection
	: SmartProject
	  [ api.CardinalityRestrictedConcept,
	    api.ConceptKind]
	= SmartProject
	  [ api.CardinalityRestrictedConcept,
	    api.ConceptKind](
	      (x: TypedDataset[api.CardinalityRestrictedConcept]) => {
	        val x_uuid: TypedColumn[api.CardinalityRestrictedConcept, taggedTypes.ConceptKindUUID]
	        = x.col[taggedTypes.CardinalityRestrictedConceptUUID]('uuid).cast[taggedTypes.ConceptKindUUID]
	    
	        val x_tboxUUID: TypedColumn[api.CardinalityRestrictedConcept, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.CardinalityRestrictedConcept, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.ConceptKind]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.ConceptKind]
	        result
	      })

	// 1 smart projects for api.CardinalityRestrictedReifiedRelationship
	
	implicit val CardinalityRestrictedReifiedRelationship2ConceptualRelationshipProjection
	: SmartProject
	  [ api.CardinalityRestrictedReifiedRelationship,
	    api.ConceptualRelationship]
	= SmartProject
	  [ api.CardinalityRestrictedReifiedRelationship,
	    api.ConceptualRelationship](
	      (x: TypedDataset[api.CardinalityRestrictedReifiedRelationship]) => {
	        val x_uuid: TypedColumn[api.CardinalityRestrictedReifiedRelationship, taggedTypes.ConceptualRelationshipUUID]
	        = x.col[taggedTypes.CardinalityRestrictedReifiedRelationshipUUID]('uuid).cast[taggedTypes.ConceptualRelationshipUUID]
	    
	        val x_tboxUUID: TypedColumn[api.CardinalityRestrictedReifiedRelationship, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.CardinalityRestrictedReifiedRelationship, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.ConceptualRelationship]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.ConceptualRelationship]
	        result
	      })

	// 1 smart projects for api.ChainRule
	
	implicit val ChainRule2RuleProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Rule]
	        result
	      })

	// 1 smart projects for api.CharacterizedEntityRelationship
	
	implicit val CharacterizedEntityRelationship2EntityRelationshipProjection
	: SmartProject
	  [ api.CharacterizedEntityRelationship,
	    api.EntityRelationship]
	= SmartProject
	  [ api.CharacterizedEntityRelationship,
	    api.EntityRelationship](
	      (x: TypedDataset[api.CharacterizedEntityRelationship]) => {
	        val x_uuid: TypedColumn[api.CharacterizedEntityRelationship, taggedTypes.EntityRelationshipUUID]
	        = x.col[taggedTypes.CharacterizedEntityRelationshipUUID]('uuid).cast[taggedTypes.EntityRelationshipUUID]
	    
	        val x_tboxUUID: TypedColumn[api.CharacterizedEntityRelationship, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.CharacterizedEntityRelationship, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.EntityRelationship]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.EntityRelationship]
	        result
	      })

	// 1 smart projects for api.Concept
	
	implicit val Concept2ConceptKindProjection
	: SmartProject
	  [ api.Concept,
	    api.ConceptKind]
	= SmartProject
	  [ api.Concept,
	    api.ConceptKind](
	      (x: TypedDataset[api.Concept]) => {
	        val x_uuid: TypedColumn[api.Concept, taggedTypes.ConceptKindUUID]
	        = x.col[taggedTypes.ConceptUUID]('uuid).cast[taggedTypes.ConceptKindUUID]
	    
	        val x_tboxUUID: TypedColumn[api.Concept, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.Concept, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.ConceptKind]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.ConceptKind]
	        result
	      })

	// 1 smart projects for api.ConceptDesignationTerminologyAxiom
	
	implicit val ConceptDesignationTerminologyAxiom2TerminologyBoxAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TerminologyBoxAxiom]
	        result
	      })

	// 1 smart projects for api.ConceptInstance
	
	implicit val ConceptInstance2ConceptualEntitySingletonInstanceProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_name ::
	            HNil)
	          .as[api.ConceptualEntitySingletonInstance]
	        result
	      })

	// 2 smart projects for api.ConceptKind
	
	implicit val ConceptKind2ConceptualEntityProjection
	: SmartProject
	  [ api.ConceptKind,
	    api.ConceptualEntity]
	= SmartProject
	  [ api.ConceptKind,
	    api.ConceptualEntity](
	      (x: TypedDataset[api.ConceptKind]) => {
	        val x_uuid: TypedColumn[api.ConceptKind, taggedTypes.ConceptualEntityUUID]
	        = x.col[taggedTypes.ConceptKindUUID]('uuid).cast[taggedTypes.ConceptualEntityUUID]
	    
	        val x_tboxUUID: TypedColumn[api.ConceptKind, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.ConceptKind, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.ConceptualEntity]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.ConceptualEntity]
	        result
	      })

	implicit val ConceptKind2UnaryTermKindProjection
	: SmartProject
	  [ api.ConceptKind,
	    api.UnaryTermKind]
	= SmartProject
	  [ api.ConceptKind,
	    api.UnaryTermKind](
	      (x: TypedDataset[api.ConceptKind]) => {
	        val x_uuid: TypedColumn[api.ConceptKind, taggedTypes.UnaryTermKindUUID]
	        = x.col[taggedTypes.ConceptKindUUID]('uuid).cast[taggedTypes.UnaryTermKindUUID]
	    
	        val x_tboxUUID: TypedColumn[api.ConceptKind, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.ConceptKind, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.UnaryTermKind]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.UnaryTermKind]
	        result
	      })

	// 1 smart projects for api.ConceptSpecializationAxiom
	
	implicit val ConceptSpecializationAxiom2SpecializationAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.SpecializationAxiom]
	        result
	      })

	// 1 smart projects for api.ConceptTreeDisjunction
	
	// 1 smart projects for api.ConceptualEntity
	
	implicit val ConceptualEntity2EntityProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Entity]
	        result
	      })

	// 2 smart projects for api.ConceptualEntitySingletonInstance
	
	// 2 smart projects for api.ConceptualRelationship
	
	implicit val ConceptualRelationship2ConceptualEntityProjection
	: SmartProject
	  [ api.ConceptualRelationship,
	    api.ConceptualEntity]
	= SmartProject
	  [ api.ConceptualRelationship,
	    api.ConceptualEntity](
	      (x: TypedDataset[api.ConceptualRelationship]) => {
	        val x_uuid: TypedColumn[api.ConceptualRelationship, taggedTypes.ConceptualEntityUUID]
	        = x.col[taggedTypes.ConceptualRelationshipUUID]('uuid).cast[taggedTypes.ConceptualEntityUUID]
	    
	        val x_tboxUUID: TypedColumn[api.ConceptualRelationship, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.ConceptualRelationship, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.ConceptualEntity]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.ConceptualEntity]
	        result
	      })

	implicit val ConceptualRelationship2EntityRelationshipProjection
	: SmartProject
	  [ api.ConceptualRelationship,
	    api.EntityRelationship]
	= SmartProject
	  [ api.ConceptualRelationship,
	    api.EntityRelationship](
	      (x: TypedDataset[api.ConceptualRelationship]) => {
	        val x_uuid: TypedColumn[api.ConceptualRelationship, taggedTypes.EntityRelationshipUUID]
	        = x.col[taggedTypes.ConceptualRelationshipUUID]('uuid).cast[taggedTypes.EntityRelationshipUUID]
	    
	        val x_tboxUUID: TypedColumn[api.ConceptualRelationship, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.ConceptualRelationship, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.EntityRelationship]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.EntityRelationship]
	        result
	      })

	// 1 smart projects for api.CrossReferencableKind
	
	// 1 smart projects for api.DataRange
	
	implicit val DataRange2DatatypeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Datatype]
	        result
	      })

	// 2 smart projects for api.DataRelationship
	
	implicit val DataRelationship2DirectedBinaryRelationshipKindProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DirectedBinaryRelationshipKind]
	        result
	      })

	implicit val DataRelationship2TermProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Term]
	        result
	      })

	// 1 smart projects for api.DataRelationshipDomain
	
	implicit val DataRelationshipDomain2DataRelationshipProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationship]
	        result
	      })

	// 1 smart projects for api.DataRelationshipFromEntity
	
	implicit val DataRelationshipFromEntity2DataRelationshipDomainProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipDomain]
	        result
	      })

	// 1 smart projects for api.DataRelationshipFromStructure
	
	implicit val DataRelationshipFromStructure2DataRelationshipDomainProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipDomain]
	        result
	      })

	// 1 smart projects for api.DataRelationshipRange
	
	implicit val DataRelationshipRange2DataRelationshipProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationship]
	        result
	      })

	// 1 smart projects for api.DataRelationshipToScalar
	
	implicit val DataRelationshipToScalar2DataRelationshipRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipRange]
	        result
	      })

	// 1 smart projects for api.DataRelationshipToStructure
	
	implicit val DataRelationshipToStructure2DataRelationshipRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipRange]
	        result
	      })

	// 1 smart projects for api.Datatype
	
	implicit val Datatype2TermProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Term]
	        result
	      })

	// 1 smart projects for api.DescriptionBox
	
	implicit val DescriptionBox2ModuleProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_iri ::
	            HNil)
	          .as[api.Module]
	        result
	      })

	// 1 smart projects for api.DescriptionBoxExtendsClosedWorldDefinitions
	
	// 1 smart projects for api.DescriptionBoxRefinement
	
	// 1 smart projects for api.DescriptionBoxRelationship
	
	// 1 smart projects for api.DirectedBinaryRelationshipKind
	
	implicit val DirectedBinaryRelationshipKind2TermProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Term]
	        result
	      })

	// 1 smart projects for api.DisjointUnionOfConceptsAxiom
	
	// 3 smart projects for api.ElementCrossReferenceTuple
	
	// 2 smart projects for api.Entity
	
	implicit val Entity2TermProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Term]
	        result
	      })

	// 1 smart projects for api.EntityExistentialRestrictionAxiom
	
	implicit val EntityExistentialRestrictionAxiom2EntityRestrictionAxiomProjection
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
	    
	        val x_restrictedDomainUUID: TypedColumn[api.EntityExistentialRestrictionAxiom, taggedTypes.EntityUUID]
	        = x.col[taggedTypes.EntityUUID]('restrictedDomainUUID)
	    
	        val x_restrictedRangeUUID: TypedColumn[api.EntityExistentialRestrictionAxiom, taggedTypes.EntityUUID]
	        = x.col[taggedTypes.EntityUUID]('restrictedRangeUUID)
	    
	        val x_restrictedRelationshipUUID: TypedColumn[api.EntityExistentialRestrictionAxiom, taggedTypes.RestrictableRelationshipUUID]
	        = x.col[taggedTypes.RestrictableRelationshipUUID]('restrictedRelationshipUUID)
	    
	        val result
	        : TypedDataset[api.EntityRestrictionAxiom]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedDomainUUID :: 
	            x_restrictedRangeUUID :: 
	            x_restrictedRelationshipUUID ::
	            HNil)
	          .as[api.EntityRestrictionAxiom]
	        result
	      })

	// 2 smart projects for api.EntityRelationship
	
	implicit val EntityRelationship2DirectedBinaryRelationshipKindProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DirectedBinaryRelationshipKind]
	        result
	      })

	implicit val EntityRelationship2TermProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Term]
	        result
	      })

	// 2 smart projects for api.EntityRestrictionAxiom
	
	implicit val EntityRestrictionAxiom2TermAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TermAxiom]
	        result
	      })

	// 3 smart projects for api.EntityScalarDataProperty
	
	implicit val EntityScalarDataProperty2DataRelationshipProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationship]
	        result
	      })

	implicit val EntityScalarDataProperty2DataRelationshipFromEntityProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_domainUUID :: 
	            x_isIdentityCriteria :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipFromEntity]
	        result
	      })

	implicit val EntityScalarDataProperty2DataRelationshipToScalarProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_rangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipToScalar]
	        result
	      })

	// 2 smart projects for api.EntityScalarDataPropertyExistentialRestrictionAxiom
	
	implicit val EntityScalarDataPropertyExistentialRestrictionAxiom2EntityScalarDataPropertyRestrictionAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedEntityUUID :: 
	            x_scalarPropertyUUID ::
	            HNil)
	          .as[api.EntityScalarDataPropertyRestrictionAxiom]
	        result
	      })

	// 2 smart projects for api.EntityScalarDataPropertyParticularRestrictionAxiom
	
	implicit val EntityScalarDataPropertyParticularRestrictionAxiom2EntityScalarDataPropertyRestrictionAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedEntityUUID :: 
	            x_scalarPropertyUUID ::
	            HNil)
	          .as[api.EntityScalarDataPropertyRestrictionAxiom]
	        result
	      })

	// 2 smart projects for api.EntityScalarDataPropertyRestrictionAxiom
	
	implicit val EntityScalarDataPropertyRestrictionAxiom2TermAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TermAxiom]
	        result
	      })

	// 2 smart projects for api.EntityScalarDataPropertyUniversalRestrictionAxiom
	
	implicit val EntityScalarDataPropertyUniversalRestrictionAxiom2EntityScalarDataPropertyRestrictionAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedEntityUUID :: 
	            x_scalarPropertyUUID ::
	            HNil)
	          .as[api.EntityScalarDataPropertyRestrictionAxiom]
	        result
	      })

	// 3 smart projects for api.EntityStructuredDataProperty
	
	implicit val EntityStructuredDataProperty2DataRelationshipProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationship]
	        result
	      })

	implicit val EntityStructuredDataProperty2DataRelationshipFromEntityProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_domainUUID :: 
	            x_isIdentityCriteria :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipFromEntity]
	        result
	      })

	implicit val EntityStructuredDataProperty2DataRelationshipToStructureProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_rangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipToStructure]
	        result
	      })

	// 2 smart projects for api.EntityStructuredDataPropertyParticularRestrictionAxiom
	
	implicit val EntityStructuredDataPropertyParticularRestrictionAxiom2EntityStructuredDataPropertyRestrictionAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedEntityUUID ::
	            HNil)
	          .as[api.EntityStructuredDataPropertyRestrictionAxiom]
	        result
	      })

	implicit val EntityStructuredDataPropertyParticularRestrictionAxiom2RestrictionStructuredDataPropertyContextProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_structuredDataPropertyUUID ::
	            HNil)
	          .as[api.RestrictionStructuredDataPropertyContext]
	        result
	      })

	// 2 smart projects for api.EntityStructuredDataPropertyRestrictionAxiom
	
	implicit val EntityStructuredDataPropertyRestrictionAxiom2TermAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TermAxiom]
	        result
	      })

	// 1 smart projects for api.EntityUniversalRestrictionAxiom
	
	implicit val EntityUniversalRestrictionAxiom2EntityRestrictionAxiomProjection
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
	    
	        val x_restrictedDomainUUID: TypedColumn[api.EntityUniversalRestrictionAxiom, taggedTypes.EntityUUID]
	        = x.col[taggedTypes.EntityUUID]('restrictedDomainUUID)
	    
	        val x_restrictedRangeUUID: TypedColumn[api.EntityUniversalRestrictionAxiom, taggedTypes.EntityUUID]
	        = x.col[taggedTypes.EntityUUID]('restrictedRangeUUID)
	    
	        val x_restrictedRelationshipUUID: TypedColumn[api.EntityUniversalRestrictionAxiom, taggedTypes.RestrictableRelationshipUUID]
	        = x.col[taggedTypes.RestrictableRelationshipUUID]('restrictedRelationshipUUID)
	    
	        val result
	        : TypedDataset[api.EntityRestrictionAxiom]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedDomainUUID :: 
	            x_restrictedRangeUUID :: 
	            x_restrictedRelationshipUUID ::
	            HNil)
	          .as[api.EntityRestrictionAxiom]
	        result
	      })

	// 1 smart projects for api.ExtrinsicIdentityKind
	
	// 1 smart projects for api.ForwardProperty
	
	// 1 smart projects for api.IRIScalarRestriction
	
	implicit val IRIScalarRestriction2RestrictedDataRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedRangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.RestrictedDataRange]
	        result
	      })

	// 1 smart projects for api.IdentityKind
	
	// 2 smart projects for api.IntrinsicIdentityKind
	
	// 1 smart projects for api.InverseProperty
	
	// 1 smart projects for api.LogicalElement
	
	// 1 smart projects for api.Module
	
	// 1 smart projects for api.ModuleEdge
	
	// 1 smart projects for api.ModuleElement
	
	// 1 smart projects for api.NonCrossReferencableKind
	
	// 1 smart projects for api.NonLogicalElement
	
	// 1 smart projects for api.NumericScalarRestriction
	
	implicit val NumericScalarRestriction2RestrictedDataRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedRangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.RestrictedDataRange]
	        result
	      })

	// 1 smart projects for api.PlainLiteralScalarRestriction
	
	implicit val PlainLiteralScalarRestriction2RestrictedDataRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedRangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.RestrictedDataRange]
	        result
	      })

	// 1 smart projects for api.Predicate
	
	// 2 smart projects for api.ReifiedRelationship
	
	implicit val ReifiedRelationship2CharacterizedEntityRelationshipProjection
	: SmartProject
	  [ api.ReifiedRelationship,
	    api.CharacterizedEntityRelationship]
	= SmartProject
	  [ api.ReifiedRelationship,
	    api.CharacterizedEntityRelationship](
	      (x: TypedDataset[api.ReifiedRelationship]) => {
	        val x_uuid: TypedColumn[api.ReifiedRelationship, taggedTypes.CharacterizedEntityRelationshipUUID]
	        = x.col[taggedTypes.ReifiedRelationshipUUID]('uuid).cast[taggedTypes.CharacterizedEntityRelationshipUUID]
	    
	        val x_tboxUUID: TypedColumn[api.ReifiedRelationship, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
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
	        : TypedDataset[api.CharacterizedEntityRelationship]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_isAsymmetric :: 
	            x_isEssential :: 
	            x_isFunctional :: 
	            x_isInverseEssential :: 
	            x_isInverseFunctional :: 
	            x_isIrreflexive :: 
	            x_isReflexive :: 
	            x_isSymmetric :: 
	            x_isTransitive :: 
	            x_name ::
	            HNil)
	          .as[api.CharacterizedEntityRelationship]
	        result
	      })

	implicit val ReifiedRelationship2ConceptualRelationshipProjection
	: SmartProject
	  [ api.ReifiedRelationship,
	    api.ConceptualRelationship]
	= SmartProject
	  [ api.ReifiedRelationship,
	    api.ConceptualRelationship](
	      (x: TypedDataset[api.ReifiedRelationship]) => {
	        val x_uuid: TypedColumn[api.ReifiedRelationship, taggedTypes.ConceptualRelationshipUUID]
	        = x.col[taggedTypes.ReifiedRelationshipUUID]('uuid).cast[taggedTypes.ConceptualRelationshipUUID]
	    
	        val x_tboxUUID: TypedColumn[api.ReifiedRelationship, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.ReifiedRelationship, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.ConceptualRelationship]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.ConceptualRelationship]
	        result
	      })

	// 1 smart projects for api.ReifiedRelationshipInstance
	
	implicit val ReifiedRelationshipInstance2ConceptualEntitySingletonInstanceProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_name ::
	            HNil)
	          .as[api.ConceptualEntitySingletonInstance]
	        result
	      })

	// 2 smart projects for api.ReifiedRelationshipInstanceDomain
	
	// 2 smart projects for api.ReifiedRelationshipInstanceRange
	
	// 1 smart projects for api.ReifiedRelationshipRestriction
	
	implicit val ReifiedRelationshipRestriction2ConceptualRelationshipProjection
	: SmartProject
	  [ api.ReifiedRelationshipRestriction,
	    api.ConceptualRelationship]
	= SmartProject
	  [ api.ReifiedRelationshipRestriction,
	    api.ConceptualRelationship](
	      (x: TypedDataset[api.ReifiedRelationshipRestriction]) => {
	        val x_uuid: TypedColumn[api.ReifiedRelationshipRestriction, taggedTypes.ConceptualRelationshipUUID]
	        = x.col[taggedTypes.ReifiedRelationshipRestrictionUUID]('uuid).cast[taggedTypes.ConceptualRelationshipUUID]
	    
	        val x_tboxUUID: TypedColumn[api.ReifiedRelationshipRestriction, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val x_name: TypedColumn[api.ReifiedRelationshipRestriction, taggedTypes.LocalName]
	        = x.col[taggedTypes.LocalName]('name)
	    
	        val result
	        : TypedDataset[api.ConceptualRelationship]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.ConceptualRelationship]
	        result
	      })

	// 1 smart projects for api.ReifiedRelationshipSpecializationAxiom
	
	implicit val ReifiedRelationshipSpecializationAxiom2SpecializationAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.SpecializationAxiom]
	        result
	      })

	// 2 smart projects for api.Resource
	
	// 1 smart projects for api.RestrictableRelationship
	
	// 1 smart projects for api.RestrictedDataRange
	
	implicit val RestrictedDataRange2DataRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRange]
	        result
	      })

	// 2 smart projects for api.RestrictionScalarDataPropertyValue
	
	// 2 smart projects for api.RestrictionStructuredDataPropertyContext
	
	// 1 smart projects for api.RestrictionStructuredDataPropertyTuple
	
	implicit val RestrictionStructuredDataPropertyTuple2RestrictionStructuredDataPropertyContextProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_structuredDataPropertyUUID ::
	            HNil)
	          .as[api.RestrictionStructuredDataPropertyContext]
	        result
	      })

	// 2 smart projects for api.RootConceptTaxonomyAxiom
	
	implicit val RootConceptTaxonomyAxiom2TerminologyBundleStatementProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_bundleUUID ::
	            HNil)
	          .as[api.TerminologyBundleStatement]
	        result
	      })

	// 1 smart projects for api.Rule
	
	implicit val Rule2TermProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Term]
	        result
	      })

	// 1 smart projects for api.RuleBodySegment
	
	// 2 smart projects for api.Scalar
	
	implicit val Scalar2DataRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRange]
	        result
	      })

	implicit val Scalar2UnaryTermKindProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.UnaryTermKind]
	        result
	      })

	// 3 smart projects for api.ScalarDataProperty
	
	implicit val ScalarDataProperty2DataRelationshipProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationship]
	        result
	      })

	implicit val ScalarDataProperty2DataRelationshipFromStructureProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_domainUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipFromStructure]
	        result
	      })

	implicit val ScalarDataProperty2DataRelationshipToScalarProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_rangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipToScalar]
	        result
	      })

	// 2 smart projects for api.ScalarDataPropertyValue
	
	// 2 smart projects for api.ScalarOneOfLiteralAxiom
	
	implicit val ScalarOneOfLiteralAxiom2TermAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TermAxiom]
	        result
	      })

	// 1 smart projects for api.ScalarOneOfRestriction
	
	implicit val ScalarOneOfRestriction2RestrictedDataRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedRangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.RestrictedDataRange]
	        result
	      })

	// 1 smart projects for api.SegmentPredicate
	
	// 2 smart projects for api.SingletonInstanceScalarDataPropertyValue
	
	// 1 smart projects for api.SingletonInstanceStructuredDataPropertyContext
	
	// 2 smart projects for api.SingletonInstanceStructuredDataPropertyValue
	
	implicit val SingletonInstanceStructuredDataPropertyValue2SingletonInstanceStructuredDataPropertyContextProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_structuredDataPropertyUUID ::
	            HNil)
	          .as[api.SingletonInstanceStructuredDataPropertyContext]
	        result
	      })

	// 2 smart projects for api.SpecializationAxiom
	
	implicit val SpecializationAxiom2TermAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TermAxiom]
	        result
	      })

	// 1 smart projects for api.SpecificDisjointConceptAxiom
	
	implicit val SpecificDisjointConceptAxiom2DisjointUnionOfConceptsAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_disjointTaxonomyParentUUID ::
	            HNil)
	          .as[api.DisjointUnionOfConceptsAxiom]
	        result
	      })

	// 1 smart projects for api.StringScalarRestriction
	
	implicit val StringScalarRestriction2RestrictedDataRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedRangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.RestrictedDataRange]
	        result
	      })

	// 2 smart projects for api.Structure
	
	implicit val Structure2DatatypeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Datatype]
	        result
	      })

	implicit val Structure2UnaryTermKindProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.UnaryTermKind]
	        result
	      })

	// 3 smart projects for api.StructuredDataProperty
	
	implicit val StructuredDataProperty2DataRelationshipProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationship]
	        result
	      })

	implicit val StructuredDataProperty2DataRelationshipFromStructureProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_domainUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipFromStructure]
	        result
	      })

	implicit val StructuredDataProperty2DataRelationshipToStructureProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_rangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.DataRelationshipToStructure]
	        result
	      })

	// 1 smart projects for api.StructuredDataPropertyTuple
	
	implicit val StructuredDataPropertyTuple2SingletonInstanceStructuredDataPropertyContextProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_structuredDataPropertyUUID ::
	            HNil)
	          .as[api.SingletonInstanceStructuredDataPropertyContext]
	        result
	      })

	// 2 smart projects for api.SubDataPropertyOfAxiom
	
	implicit val SubDataPropertyOfAxiom2TermAxiomProjection
	: SmartProject
	  [ api.SubDataPropertyOfAxiom,
	    api.TermAxiom]
	= SmartProject
	  [ api.SubDataPropertyOfAxiom,
	    api.TermAxiom](
	      (x: TypedDataset[api.SubDataPropertyOfAxiom]) => {
	        val x_uuid: TypedColumn[api.SubDataPropertyOfAxiom, taggedTypes.TermAxiomUUID]
	        = x.col[taggedTypes.SubDataPropertyOfAxiomUUID]('uuid).cast[taggedTypes.TermAxiomUUID]
	    
	        val x_tboxUUID: TypedColumn[api.SubDataPropertyOfAxiom, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val result
	        : TypedDataset[api.TermAxiom]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TermAxiom]
	        result
	      })

	// 2 smart projects for api.SubObjectPropertyOfAxiom
	
	implicit val SubObjectPropertyOfAxiom2TermAxiomProjection
	: SmartProject
	  [ api.SubObjectPropertyOfAxiom,
	    api.TermAxiom]
	= SmartProject
	  [ api.SubObjectPropertyOfAxiom,
	    api.TermAxiom](
	      (x: TypedDataset[api.SubObjectPropertyOfAxiom]) => {
	        val x_uuid: TypedColumn[api.SubObjectPropertyOfAxiom, taggedTypes.TermAxiomUUID]
	        = x.col[taggedTypes.SubObjectPropertyOfAxiomUUID]('uuid).cast[taggedTypes.TermAxiomUUID]
	    
	        val x_tboxUUID: TypedColumn[api.SubObjectPropertyOfAxiom, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
	        val result
	        : TypedDataset[api.TermAxiom]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TermAxiom]
	        result
	      })

	// 1 smart projects for api.SynonymScalarRestriction
	
	implicit val SynonymScalarRestriction2RestrictedDataRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedRangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.RestrictedDataRange]
	        result
	      })

	// 2 smart projects for api.Term
	
	implicit val Term2TerminologyBoxStatementProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TerminologyBoxStatement]
	        result
	      })

	// 1 smart projects for api.TermAxiom
	
	implicit val TermAxiom2TerminologyBoxStatementProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TerminologyBoxStatement]
	        result
	      })

	// 1 smart projects for api.TerminologyAxiom
	
	// 1 smart projects for api.TerminologyBox
	
	implicit val TerminologyBox2ModuleProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_iri ::
	            HNil)
	          .as[api.Module]
	        result
	      })

	// 1 smart projects for api.TerminologyBoxAxiom
	
	// 1 smart projects for api.TerminologyBoxStatement
	
	// 1 smart projects for api.TerminologyBundleAxiom
	
	// 1 smart projects for api.TerminologyBundleStatement
	
	// 1 smart projects for api.TerminologyExtensionAxiom
	
	implicit val TerminologyExtensionAxiom2TerminologyBoxAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TerminologyBoxAxiom]
	        result
	      })

	// 1 smart projects for api.TerminologyGraph
	
	implicit val TerminologyGraph2TerminologyBoxProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_kind :: 
	            x_iri ::
	            HNil)
	          .as[api.TerminologyBox]
	        result
	      })

	// 1 smart projects for api.TerminologyInstanceAssertion
	
	// 1 smart projects for api.TerminologyNestingAxiom
	
	implicit val TerminologyNestingAxiom2TerminologyBoxAxiomProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID ::
	            HNil)
	          .as[api.TerminologyBoxAxiom]
	        result
	      })

	// 1 smart projects for api.TimeScalarRestriction
	
	implicit val TimeScalarRestriction2RestrictedDataRangeProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_restrictedRangeUUID :: 
	            x_name ::
	            HNil)
	          .as[api.RestrictedDataRange]
	        result
	      })

	// 1 smart projects for api.UnaryTermKind
	
	implicit val UnaryTermKind2TermProjection
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
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_name ::
	            HNil)
	          .as[api.Term]
	        result
	      })

	// 2 smart projects for api.UnreifiedRelationship
	
	implicit val UnreifiedRelationship2CharacterizedEntityRelationshipProjection
	: SmartProject
	  [ api.UnreifiedRelationship,
	    api.CharacterizedEntityRelationship]
	= SmartProject
	  [ api.UnreifiedRelationship,
	    api.CharacterizedEntityRelationship](
	      (x: TypedDataset[api.UnreifiedRelationship]) => {
	        val x_uuid: TypedColumn[api.UnreifiedRelationship, taggedTypes.CharacterizedEntityRelationshipUUID]
	        = x.col[taggedTypes.UnreifiedRelationshipUUID]('uuid).cast[taggedTypes.CharacterizedEntityRelationshipUUID]
	    
	        val x_tboxUUID: TypedColumn[api.UnreifiedRelationship, taggedTypes.TerminologyBoxUUID]
	        = x.col[taggedTypes.TerminologyBoxUUID]('tboxUUID)
	    
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
	        : TypedDataset[api.CharacterizedEntityRelationship]
	        = x
	          .selectMany
	          .applyProduct(
	            x_uuid :: 
	            x_tboxUUID :: 
	            x_isAsymmetric :: 
	            x_isEssential :: 
	            x_isFunctional :: 
	            x_isInverseEssential :: 
	            x_isInverseFunctional :: 
	            x_isIrreflexive :: 
	            x_isReflexive :: 
	            x_isSymmetric :: 
	            x_isTransitive :: 
	            x_name ::
	            HNil)
	          .as[api.CharacterizedEntityRelationship]
	        result
	      })

	// 2 smart projects for api.UnreifiedRelationshipInstanceTuple
	
	// 2 smart projects for api.ValueCrossReferenceTuple
	
}
