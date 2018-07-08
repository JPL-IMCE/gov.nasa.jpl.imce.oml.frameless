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

import frameless.CatalystCast
import gov.nasa.jpl.imce.oml.tables.taggedTypes
import scala.Any

object OMLCatalystCasts {
	val theInstance = new CatalystCast[Any, Any] {}
	
	// 2 casts for AnnotationProperty
	
	implicit val AnnotationProperty2IntrinsicIdentityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.AnnotationPropertyUUID,
	    taggedTypes.IntrinsicIdentityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.AnnotationPropertyUUID,
	    taggedTypes.IntrinsicIdentityKindUUID]]
	
	implicit val AnnotationProperty2NonLogicalElementUUIDCast
	: CatalystCast
	  [ taggedTypes.AnnotationPropertyUUID,
	    taggedTypes.NonLogicalElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.AnnotationPropertyUUID,
	    taggedTypes.NonLogicalElementUUID]]
	
	// 2 casts for AnnotationPropertyValue
	
	implicit val AnnotationPropertyValue2NonLogicalElementUUIDCast
	: CatalystCast
	  [ taggedTypes.AnnotationPropertyValueUUID,
	    taggedTypes.NonLogicalElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.AnnotationPropertyValueUUID,
	    taggedTypes.NonLogicalElementUUID]]
	
	implicit val AnnotationPropertyValue2ValueCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.AnnotationPropertyValueUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.AnnotationPropertyValueUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]]
	
	// 2 casts for AnonymousConceptUnionAxiom
	
	implicit val AnonymousConceptUnionAxiom2ConceptTreeDisjunctionUUIDCast
	: CatalystCast
	  [ taggedTypes.AnonymousConceptUnionAxiomUUID,
	    taggedTypes.ConceptTreeDisjunctionUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.AnonymousConceptUnionAxiomUUID,
	    taggedTypes.ConceptTreeDisjunctionUUID]]
	
	implicit val AnonymousConceptUnionAxiom2DisjointUnionOfConceptsAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.AnonymousConceptUnionAxiomUUID,
	    taggedTypes.DisjointUnionOfConceptsAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.AnonymousConceptUnionAxiomUUID,
	    taggedTypes.DisjointUnionOfConceptsAxiomUUID]]
	
	// 1 casts for Aspect
	
	implicit val Aspect2AspectKindUUIDCast
	: CatalystCast
	  [ taggedTypes.AspectUUID,
	    taggedTypes.AspectKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.AspectUUID,
	    taggedTypes.AspectKindUUID]]
	
	// 2 casts for AspectKind
	
	implicit val AspectKind2EntityUUIDCast
	: CatalystCast
	  [ taggedTypes.AspectKindUUID,
	    taggedTypes.EntityUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.AspectKindUUID,
	    taggedTypes.EntityUUID]]
	
	implicit val AspectKind2UnaryTermKindUUIDCast
	: CatalystCast
	  [ taggedTypes.AspectKindUUID,
	    taggedTypes.UnaryTermKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.AspectKindUUID,
	    taggedTypes.UnaryTermKindUUID]]
	
	// 1 casts for AspectSpecializationAxiom
	
	implicit val AspectSpecializationAxiom2SpecializationAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.AspectSpecializationAxiomUUID,
	    taggedTypes.SpecializationAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.AspectSpecializationAxiomUUID,
	    taggedTypes.SpecializationAxiomUUID]]
	
	// 1 casts for BinaryScalarRestriction
	
	implicit val BinaryScalarRestriction2RestrictedDataRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.BinaryScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.BinaryScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]]
	
	// 1 casts for Bundle
	
	implicit val Bundle2TerminologyBoxUUIDCast
	: CatalystCast
	  [ taggedTypes.BundleUUID,
	    taggedTypes.TerminologyBoxUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.BundleUUID,
	    taggedTypes.TerminologyBoxUUID]]
	
	// 1 casts for BundledTerminologyAxiom
	
	implicit val BundledTerminologyAxiom2TerminologyBundleAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.BundledTerminologyAxiomUUID,
	    taggedTypes.TerminologyBundleAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.BundledTerminologyAxiomUUID,
	    taggedTypes.TerminologyBundleAxiomUUID]]
	
	// 1 casts for CardinalityRestrictedAspect
	
	implicit val CardinalityRestrictedAspect2AspectKindUUIDCast
	: CatalystCast
	  [ taggedTypes.CardinalityRestrictedAspectUUID,
	    taggedTypes.AspectKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.CardinalityRestrictedAspectUUID,
	    taggedTypes.AspectKindUUID]]
	
	// 1 casts for CardinalityRestrictedConcept
	
	implicit val CardinalityRestrictedConcept2ConceptKindUUIDCast
	: CatalystCast
	  [ taggedTypes.CardinalityRestrictedConceptUUID,
	    taggedTypes.ConceptKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.CardinalityRestrictedConceptUUID,
	    taggedTypes.ConceptKindUUID]]
	
	// 1 casts for CardinalityRestrictedReifiedRelationship
	
	implicit val CardinalityRestrictedReifiedRelationship2ConceptualRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.CardinalityRestrictedReifiedRelationshipUUID,
	    taggedTypes.ConceptualRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.CardinalityRestrictedReifiedRelationshipUUID,
	    taggedTypes.ConceptualRelationshipUUID]]
	
	// 1 casts for ChainRule
	
	implicit val ChainRule2RuleUUIDCast
	: CatalystCast
	  [ taggedTypes.ChainRuleUUID,
	    taggedTypes.RuleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ChainRuleUUID,
	    taggedTypes.RuleUUID]]
	
	// 1 casts for CharacterizedEntityRelationship
	
	implicit val CharacterizedEntityRelationship2EntityRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.CharacterizedEntityRelationshipUUID,
	    taggedTypes.EntityRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.CharacterizedEntityRelationshipUUID,
	    taggedTypes.EntityRelationshipUUID]]
	
	// 1 casts for Concept
	
	implicit val Concept2ConceptKindUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptUUID,
	    taggedTypes.ConceptKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptUUID,
	    taggedTypes.ConceptKindUUID]]
	
	// 1 casts for ConceptDesignationTerminologyAxiom
	
	implicit val ConceptDesignationTerminologyAxiom2TerminologyBoxAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptDesignationTerminologyAxiomUUID,
	    taggedTypes.TerminologyBoxAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptDesignationTerminologyAxiomUUID,
	    taggedTypes.TerminologyBoxAxiomUUID]]
	
	// 1 casts for ConceptInstance
	
	implicit val ConceptInstance2ConceptualEntitySingletonInstanceUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptInstanceUUID,
	    taggedTypes.ConceptualEntitySingletonInstanceUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptInstanceUUID,
	    taggedTypes.ConceptualEntitySingletonInstanceUUID]]
	
	// 2 casts for ConceptKind
	
	implicit val ConceptKind2ConceptualEntityUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptKindUUID,
	    taggedTypes.ConceptualEntityUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptKindUUID,
	    taggedTypes.ConceptualEntityUUID]]
	
	implicit val ConceptKind2UnaryTermKindUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptKindUUID,
	    taggedTypes.UnaryTermKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptKindUUID,
	    taggedTypes.UnaryTermKindUUID]]
	
	// 1 casts for ConceptSpecializationAxiom
	
	implicit val ConceptSpecializationAxiom2SpecializationAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptSpecializationAxiomUUID,
	    taggedTypes.SpecializationAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptSpecializationAxiomUUID,
	    taggedTypes.SpecializationAxiomUUID]]
	
	// 1 casts for ConceptTreeDisjunction
	
	implicit val ConceptTreeDisjunction2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptTreeDisjunctionUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptTreeDisjunctionUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	// 1 casts for ConceptualEntity
	
	implicit val ConceptualEntity2EntityUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptualEntityUUID,
	    taggedTypes.EntityUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptualEntityUUID,
	    taggedTypes.EntityUUID]]
	
	// 2 casts for ConceptualEntitySingletonInstance
	
	implicit val ConceptualEntitySingletonInstance2ResourceUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptualEntitySingletonInstanceUUID,
	    taggedTypes.ResourceUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptualEntitySingletonInstanceUUID,
	    taggedTypes.ResourceUUID]]
	
	implicit val ConceptualEntitySingletonInstance2TerminologyInstanceAssertionUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptualEntitySingletonInstanceUUID,
	    taggedTypes.TerminologyInstanceAssertionUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptualEntitySingletonInstanceUUID,
	    taggedTypes.TerminologyInstanceAssertionUUID]]
	
	// 2 casts for ConceptualRelationship
	
	implicit val ConceptualRelationship2ConceptualEntityUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptualRelationshipUUID,
	    taggedTypes.ConceptualEntityUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptualRelationshipUUID,
	    taggedTypes.ConceptualEntityUUID]]
	
	implicit val ConceptualRelationship2EntityRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.ConceptualRelationshipUUID,
	    taggedTypes.EntityRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ConceptualRelationshipUUID,
	    taggedTypes.EntityRelationshipUUID]]
	
	// 1 casts for CrossReferencableKind
	
	implicit val CrossReferencableKind2CrossReferencabilityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.CrossReferencableKindUUID,
	    taggedTypes.CrossReferencabilityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.CrossReferencableKindUUID,
	    taggedTypes.CrossReferencabilityKindUUID]]
	
	// 1 casts for DataRange
	
	implicit val DataRange2DatatypeUUIDCast
	: CatalystCast
	  [ taggedTypes.DataRangeUUID,
	    taggedTypes.DatatypeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DataRangeUUID,
	    taggedTypes.DatatypeUUID]]
	
	// 2 casts for DataRelationship
	
	implicit val DataRelationship2DirectedBinaryRelationshipKindUUIDCast
	: CatalystCast
	  [ taggedTypes.DataRelationshipUUID,
	    taggedTypes.DirectedBinaryRelationshipKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DataRelationshipUUID,
	    taggedTypes.DirectedBinaryRelationshipKindUUID]]
	
	implicit val DataRelationship2TermUUIDCast
	: CatalystCast
	  [ taggedTypes.DataRelationshipUUID,
	    taggedTypes.TermUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DataRelationshipUUID,
	    taggedTypes.TermUUID]]
	
	// 1 casts for DataRelationshipDomain
	
	implicit val DataRelationshipDomain2DataRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.DataRelationshipDomainUUID,
	    taggedTypes.DataRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DataRelationshipDomainUUID,
	    taggedTypes.DataRelationshipUUID]]
	
	// 1 casts for DataRelationshipFromEntity
	
	implicit val DataRelationshipFromEntity2DataRelationshipDomainUUIDCast
	: CatalystCast
	  [ taggedTypes.DataRelationshipFromEntityUUID,
	    taggedTypes.DataRelationshipDomainUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DataRelationshipFromEntityUUID,
	    taggedTypes.DataRelationshipDomainUUID]]
	
	// 1 casts for DataRelationshipFromStructure
	
	implicit val DataRelationshipFromStructure2DataRelationshipDomainUUIDCast
	: CatalystCast
	  [ taggedTypes.DataRelationshipFromStructureUUID,
	    taggedTypes.DataRelationshipDomainUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DataRelationshipFromStructureUUID,
	    taggedTypes.DataRelationshipDomainUUID]]
	
	// 1 casts for DataRelationshipRange
	
	implicit val DataRelationshipRange2DataRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.DataRelationshipRangeUUID,
	    taggedTypes.DataRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DataRelationshipRangeUUID,
	    taggedTypes.DataRelationshipUUID]]
	
	// 1 casts for DataRelationshipToScalar
	
	implicit val DataRelationshipToScalar2DataRelationshipRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.DataRelationshipToScalarUUID,
	    taggedTypes.DataRelationshipRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DataRelationshipToScalarUUID,
	    taggedTypes.DataRelationshipRangeUUID]]
	
	// 1 casts for DataRelationshipToStructure
	
	implicit val DataRelationshipToStructure2DataRelationshipRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.DataRelationshipToStructureUUID,
	    taggedTypes.DataRelationshipRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DataRelationshipToStructureUUID,
	    taggedTypes.DataRelationshipRangeUUID]]
	
	// 1 casts for Datatype
	
	implicit val Datatype2TermUUIDCast
	: CatalystCast
	  [ taggedTypes.DatatypeUUID,
	    taggedTypes.TermUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DatatypeUUID,
	    taggedTypes.TermUUID]]
	
	// 1 casts for DescriptionBox
	
	implicit val DescriptionBox2ModuleUUIDCast
	: CatalystCast
	  [ taggedTypes.DescriptionBoxUUID,
	    taggedTypes.ModuleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DescriptionBoxUUID,
	    taggedTypes.ModuleUUID]]
	
	// 1 casts for DescriptionBoxExtendsClosedWorldDefinitions
	
	implicit val DescriptionBoxExtendsClosedWorldDefinitions2DescriptionBoxRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.DescriptionBoxExtendsClosedWorldDefinitionsUUID,
	    taggedTypes.DescriptionBoxRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DescriptionBoxExtendsClosedWorldDefinitionsUUID,
	    taggedTypes.DescriptionBoxRelationshipUUID]]
	
	// 1 casts for DescriptionBoxRefinement
	
	implicit val DescriptionBoxRefinement2DescriptionBoxRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.DescriptionBoxRefinementUUID,
	    taggedTypes.DescriptionBoxRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DescriptionBoxRefinementUUID,
	    taggedTypes.DescriptionBoxRelationshipUUID]]
	
	// 1 casts for DescriptionBoxRelationship
	
	implicit val DescriptionBoxRelationship2ModuleEdgeUUIDCast
	: CatalystCast
	  [ taggedTypes.DescriptionBoxRelationshipUUID,
	    taggedTypes.ModuleEdgeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DescriptionBoxRelationshipUUID,
	    taggedTypes.ModuleEdgeUUID]]
	
	// 1 casts for DirectedBinaryRelationshipKind
	
	implicit val DirectedBinaryRelationshipKind2TermUUIDCast
	: CatalystCast
	  [ taggedTypes.DirectedBinaryRelationshipKindUUID,
	    taggedTypes.TermUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DirectedBinaryRelationshipKindUUID,
	    taggedTypes.TermUUID]]
	
	// 1 casts for DisjointUnionOfConceptsAxiom
	
	implicit val DisjointUnionOfConceptsAxiom2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.DisjointUnionOfConceptsAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.DisjointUnionOfConceptsAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	// 3 casts for ElementCrossReferenceTuple
	
	implicit val ElementCrossReferenceTuple2CrossReferencableKindUUIDCast
	: CatalystCast
	  [ taggedTypes.ElementCrossReferenceTupleUUID,
	    taggedTypes.CrossReferencableKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ElementCrossReferenceTupleUUID,
	    taggedTypes.CrossReferencableKindUUID]]
	
	implicit val ElementCrossReferenceTuple2ExtrinsicIdentityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.ElementCrossReferenceTupleUUID,
	    taggedTypes.ExtrinsicIdentityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ElementCrossReferenceTupleUUID,
	    taggedTypes.ExtrinsicIdentityKindUUID]]
	
	implicit val ElementCrossReferenceTuple2LogicalElementUUIDCast
	: CatalystCast
	  [ taggedTypes.ElementCrossReferenceTupleUUID,
	    taggedTypes.LogicalElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ElementCrossReferenceTupleUUID,
	    taggedTypes.LogicalElementUUID]]
	
	// 2 casts for Entity
	
	implicit val Entity2PredicateUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityUUID,
	    taggedTypes.PredicateUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityUUID,
	    taggedTypes.PredicateUUID]]
	
	implicit val Entity2TermUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityUUID,
	    taggedTypes.TermUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityUUID,
	    taggedTypes.TermUUID]]
	
	// 1 casts for EntityExistentialRestrictionAxiom
	
	implicit val EntityExistentialRestrictionAxiom2EntityRestrictionAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityExistentialRestrictionAxiomUUID,
	    taggedTypes.EntityRestrictionAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityExistentialRestrictionAxiomUUID,
	    taggedTypes.EntityRestrictionAxiomUUID]]
	
	// 2 casts for EntityRelationship
	
	implicit val EntityRelationship2DirectedBinaryRelationshipKindUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityRelationshipUUID,
	    taggedTypes.DirectedBinaryRelationshipKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityRelationshipUUID,
	    taggedTypes.DirectedBinaryRelationshipKindUUID]]
	
	implicit val EntityRelationship2TermUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityRelationshipUUID,
	    taggedTypes.TermUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityRelationshipUUID,
	    taggedTypes.TermUUID]]
	
	// 2 casts for EntityRestrictionAxiom
	
	implicit val EntityRestrictionAxiom2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityRestrictionAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityRestrictionAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	implicit val EntityRestrictionAxiom2TermAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityRestrictionAxiomUUID,
	    taggedTypes.TermAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityRestrictionAxiomUUID,
	    taggedTypes.TermAxiomUUID]]
	
	// 3 casts for EntityScalarDataProperty
	
	implicit val EntityScalarDataProperty2DataRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipUUID]]
	
	implicit val EntityScalarDataProperty2DataRelationshipFromEntityUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipFromEntityUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipFromEntityUUID]]
	
	implicit val EntityScalarDataProperty2DataRelationshipToScalarUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipToScalarUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipToScalarUUID]]
	
	// 2 casts for EntityScalarDataPropertyExistentialRestrictionAxiom
	
	implicit val EntityScalarDataPropertyExistentialRestrictionAxiom2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyExistentialRestrictionAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyExistentialRestrictionAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	implicit val EntityScalarDataPropertyExistentialRestrictionAxiom2EntityScalarDataPropertyRestrictionAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyExistentialRestrictionAxiomUUID,
	    taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyExistentialRestrictionAxiomUUID,
	    taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]]
	
	// 2 casts for EntityScalarDataPropertyParticularRestrictionAxiom
	
	implicit val EntityScalarDataPropertyParticularRestrictionAxiom2EntityScalarDataPropertyRestrictionAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyParticularRestrictionAxiomUUID,
	    taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyParticularRestrictionAxiomUUID,
	    taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]]
	
	implicit val EntityScalarDataPropertyParticularRestrictionAxiom2ValueCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyParticularRestrictionAxiomUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyParticularRestrictionAxiomUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]]
	
	// 2 casts for EntityScalarDataPropertyRestrictionAxiom
	
	implicit val EntityScalarDataPropertyRestrictionAxiom2ExtrinsicIdentityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID,
	    taggedTypes.ExtrinsicIdentityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID,
	    taggedTypes.ExtrinsicIdentityKindUUID]]
	
	implicit val EntityScalarDataPropertyRestrictionAxiom2TermAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID,
	    taggedTypes.TermAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID,
	    taggedTypes.TermAxiomUUID]]
	
	// 2 casts for EntityScalarDataPropertyUniversalRestrictionAxiom
	
	implicit val EntityScalarDataPropertyUniversalRestrictionAxiom2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyUniversalRestrictionAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyUniversalRestrictionAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	implicit val EntityScalarDataPropertyUniversalRestrictionAxiom2EntityScalarDataPropertyRestrictionAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyUniversalRestrictionAxiomUUID,
	    taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityScalarDataPropertyUniversalRestrictionAxiomUUID,
	    taggedTypes.EntityScalarDataPropertyRestrictionAxiomUUID]]
	
	// 3 casts for EntityStructuredDataProperty
	
	implicit val EntityStructuredDataProperty2DataRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipUUID]]
	
	implicit val EntityStructuredDataProperty2DataRelationshipFromEntityUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipFromEntityUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipFromEntityUUID]]
	
	implicit val EntityStructuredDataProperty2DataRelationshipToStructureUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipToStructureUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipToStructureUUID]]
	
	// 2 casts for EntityStructuredDataPropertyParticularRestrictionAxiom
	
	implicit val EntityStructuredDataPropertyParticularRestrictionAxiom2EntityStructuredDataPropertyRestrictionAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyParticularRestrictionAxiomUUID,
	    taggedTypes.EntityStructuredDataPropertyRestrictionAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyParticularRestrictionAxiomUUID,
	    taggedTypes.EntityStructuredDataPropertyRestrictionAxiomUUID]]
	
	implicit val EntityStructuredDataPropertyParticularRestrictionAxiom2RestrictionStructuredDataPropertyContextUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyParticularRestrictionAxiomUUID,
	    taggedTypes.RestrictionStructuredDataPropertyContextUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyParticularRestrictionAxiomUUID,
	    taggedTypes.RestrictionStructuredDataPropertyContextUUID]]
	
	// 2 casts for EntityStructuredDataPropertyRestrictionAxiom
	
	implicit val EntityStructuredDataPropertyRestrictionAxiom2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyRestrictionAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyRestrictionAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	implicit val EntityStructuredDataPropertyRestrictionAxiom2TermAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyRestrictionAxiomUUID,
	    taggedTypes.TermAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityStructuredDataPropertyRestrictionAxiomUUID,
	    taggedTypes.TermAxiomUUID]]
	
	// 1 casts for EntityUniversalRestrictionAxiom
	
	implicit val EntityUniversalRestrictionAxiom2EntityRestrictionAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.EntityUniversalRestrictionAxiomUUID,
	    taggedTypes.EntityRestrictionAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.EntityUniversalRestrictionAxiomUUID,
	    taggedTypes.EntityRestrictionAxiomUUID]]
	
	// 1 casts for ExtrinsicIdentityKind
	
	implicit val ExtrinsicIdentityKind2IdentityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.ExtrinsicIdentityKindUUID,
	    taggedTypes.IdentityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ExtrinsicIdentityKindUUID,
	    taggedTypes.IdentityKindUUID]]
	
	// 1 casts for ForwardProperty
	
	implicit val ForwardProperty2RestrictableRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.ForwardPropertyUUID,
	    taggedTypes.RestrictableRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ForwardPropertyUUID,
	    taggedTypes.RestrictableRelationshipUUID]]
	
	// 1 casts for IRIScalarRestriction
	
	implicit val IRIScalarRestriction2RestrictedDataRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.IRIScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.IRIScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]]
	
	// 1 casts for IdentityKind
	
	implicit val IdentityKind2CrossReferencabilityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.IdentityKindUUID,
	    taggedTypes.CrossReferencabilityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.IdentityKindUUID,
	    taggedTypes.CrossReferencabilityKindUUID]]
	
	// 2 casts for IntrinsicIdentityKind
	
	implicit val IntrinsicIdentityKind2CrossReferencableKindUUIDCast
	: CatalystCast
	  [ taggedTypes.IntrinsicIdentityKindUUID,
	    taggedTypes.CrossReferencableKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.IntrinsicIdentityKindUUID,
	    taggedTypes.CrossReferencableKindUUID]]
	
	implicit val IntrinsicIdentityKind2IdentityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.IntrinsicIdentityKindUUID,
	    taggedTypes.IdentityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.IntrinsicIdentityKindUUID,
	    taggedTypes.IdentityKindUUID]]
	
	// 1 casts for InverseProperty
	
	implicit val InverseProperty2RestrictableRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.InversePropertyUUID,
	    taggedTypes.RestrictableRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.InversePropertyUUID,
	    taggedTypes.RestrictableRelationshipUUID]]
	
	// 1 casts for LogicalElement
	
	implicit val LogicalElement2IdentityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.LogicalElementUUID,
	    taggedTypes.IdentityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.LogicalElementUUID,
	    taggedTypes.IdentityKindUUID]]
	
	// 1 casts for Module
	
	implicit val Module2ResourceUUIDCast
	: CatalystCast
	  [ taggedTypes.ModuleUUID,
	    taggedTypes.ResourceUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ModuleUUID,
	    taggedTypes.ResourceUUID]]
	
	// 1 casts for ModuleEdge
	
	implicit val ModuleEdge2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.ModuleEdgeUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ModuleEdgeUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	// 1 casts for ModuleElement
	
	implicit val ModuleElement2LogicalElementUUIDCast
	: CatalystCast
	  [ taggedTypes.ModuleElementUUID,
	    taggedTypes.LogicalElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ModuleElementUUID,
	    taggedTypes.LogicalElementUUID]]
	
	// 1 casts for NonCrossReferencableKind
	
	implicit val NonCrossReferencableKind2CrossReferencabilityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.NonCrossReferencableKindUUID,
	    taggedTypes.CrossReferencabilityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.NonCrossReferencableKindUUID,
	    taggedTypes.CrossReferencabilityKindUUID]]
	
	// 1 casts for NonLogicalElement
	
	implicit val NonLogicalElement2IdentityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.NonLogicalElementUUID,
	    taggedTypes.IdentityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.NonLogicalElementUUID,
	    taggedTypes.IdentityKindUUID]]
	
	// 1 casts for NumericScalarRestriction
	
	implicit val NumericScalarRestriction2RestrictedDataRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.NumericScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.NumericScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]]
	
	// 1 casts for PlainLiteralScalarRestriction
	
	implicit val PlainLiteralScalarRestriction2RestrictedDataRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.PlainLiteralScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.PlainLiteralScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]]
	
	// 1 casts for Predicate
	
	implicit val Predicate2ResourceUUIDCast
	: CatalystCast
	  [ taggedTypes.PredicateUUID,
	    taggedTypes.ResourceUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.PredicateUUID,
	    taggedTypes.ResourceUUID]]
	
	// 2 casts for ReifiedRelationship
	
	implicit val ReifiedRelationship2CharacterizedEntityRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.ReifiedRelationshipUUID,
	    taggedTypes.CharacterizedEntityRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ReifiedRelationshipUUID,
	    taggedTypes.CharacterizedEntityRelationshipUUID]]
	
	implicit val ReifiedRelationship2ConceptualRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.ReifiedRelationshipUUID,
	    taggedTypes.ConceptualRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ReifiedRelationshipUUID,
	    taggedTypes.ConceptualRelationshipUUID]]
	
	// 1 casts for ReifiedRelationshipInstance
	
	implicit val ReifiedRelationshipInstance2ConceptualEntitySingletonInstanceUUIDCast
	: CatalystCast
	  [ taggedTypes.ReifiedRelationshipInstanceUUID,
	    taggedTypes.ConceptualEntitySingletonInstanceUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ReifiedRelationshipInstanceUUID,
	    taggedTypes.ConceptualEntitySingletonInstanceUUID]]
	
	// 2 casts for ReifiedRelationshipInstanceDomain
	
	implicit val ReifiedRelationshipInstanceDomain2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.ReifiedRelationshipInstanceDomainUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ReifiedRelationshipInstanceDomainUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	implicit val ReifiedRelationshipInstanceDomain2TerminologyInstanceAssertionUUIDCast
	: CatalystCast
	  [ taggedTypes.ReifiedRelationshipInstanceDomainUUID,
	    taggedTypes.TerminologyInstanceAssertionUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ReifiedRelationshipInstanceDomainUUID,
	    taggedTypes.TerminologyInstanceAssertionUUID]]
	
	// 2 casts for ReifiedRelationshipInstanceRange
	
	implicit val ReifiedRelationshipInstanceRange2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.ReifiedRelationshipInstanceRangeUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ReifiedRelationshipInstanceRangeUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	implicit val ReifiedRelationshipInstanceRange2TerminologyInstanceAssertionUUIDCast
	: CatalystCast
	  [ taggedTypes.ReifiedRelationshipInstanceRangeUUID,
	    taggedTypes.TerminologyInstanceAssertionUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ReifiedRelationshipInstanceRangeUUID,
	    taggedTypes.TerminologyInstanceAssertionUUID]]
	
	// 1 casts for ReifiedRelationshipRestriction
	
	implicit val ReifiedRelationshipRestriction2ConceptualRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.ReifiedRelationshipRestrictionUUID,
	    taggedTypes.ConceptualRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ReifiedRelationshipRestrictionUUID,
	    taggedTypes.ConceptualRelationshipUUID]]
	
	// 1 casts for ReifiedRelationshipSpecializationAxiom
	
	implicit val ReifiedRelationshipSpecializationAxiom2SpecializationAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.ReifiedRelationshipSpecializationAxiomUUID,
	    taggedTypes.SpecializationAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ReifiedRelationshipSpecializationAxiomUUID,
	    taggedTypes.SpecializationAxiomUUID]]
	
	// 2 casts for Resource
	
	implicit val Resource2IntrinsicIdentityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.ResourceUUID,
	    taggedTypes.IntrinsicIdentityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ResourceUUID,
	    taggedTypes.IntrinsicIdentityKindUUID]]
	
	implicit val Resource2LogicalElementUUIDCast
	: CatalystCast
	  [ taggedTypes.ResourceUUID,
	    taggedTypes.LogicalElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ResourceUUID,
	    taggedTypes.LogicalElementUUID]]
	
	// 1 casts for RestrictableRelationship
	
	implicit val RestrictableRelationship2PredicateUUIDCast
	: CatalystCast
	  [ taggedTypes.RestrictableRelationshipUUID,
	    taggedTypes.PredicateUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.RestrictableRelationshipUUID,
	    taggedTypes.PredicateUUID]]
	
	// 1 casts for RestrictedDataRange
	
	implicit val RestrictedDataRange2DataRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.RestrictedDataRangeUUID,
	    taggedTypes.DataRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.RestrictedDataRangeUUID,
	    taggedTypes.DataRangeUUID]]
	
	// 2 casts for RestrictionScalarDataPropertyValue
	
	implicit val RestrictionScalarDataPropertyValue2LogicalElementUUIDCast
	: CatalystCast
	  [ taggedTypes.RestrictionScalarDataPropertyValueUUID,
	    taggedTypes.LogicalElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.RestrictionScalarDataPropertyValueUUID,
	    taggedTypes.LogicalElementUUID]]
	
	implicit val RestrictionScalarDataPropertyValue2ValueCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.RestrictionScalarDataPropertyValueUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.RestrictionScalarDataPropertyValueUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]]
	
	// 2 casts for RestrictionStructuredDataPropertyContext
	
	implicit val RestrictionStructuredDataPropertyContext2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.RestrictionStructuredDataPropertyContextUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.RestrictionStructuredDataPropertyContextUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	implicit val RestrictionStructuredDataPropertyContext2ModuleElementUUIDCast
	: CatalystCast
	  [ taggedTypes.RestrictionStructuredDataPropertyContextUUID,
	    taggedTypes.ModuleElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.RestrictionStructuredDataPropertyContextUUID,
	    taggedTypes.ModuleElementUUID]]
	
	// 1 casts for RestrictionStructuredDataPropertyTuple
	
	implicit val RestrictionStructuredDataPropertyTuple2RestrictionStructuredDataPropertyContextUUIDCast
	: CatalystCast
	  [ taggedTypes.RestrictionStructuredDataPropertyTupleUUID,
	    taggedTypes.RestrictionStructuredDataPropertyContextUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.RestrictionStructuredDataPropertyTupleUUID,
	    taggedTypes.RestrictionStructuredDataPropertyContextUUID]]
	
	// 2 casts for RootConceptTaxonomyAxiom
	
	implicit val RootConceptTaxonomyAxiom2ConceptTreeDisjunctionUUIDCast
	: CatalystCast
	  [ taggedTypes.RootConceptTaxonomyAxiomUUID,
	    taggedTypes.ConceptTreeDisjunctionUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.RootConceptTaxonomyAxiomUUID,
	    taggedTypes.ConceptTreeDisjunctionUUID]]
	
	implicit val RootConceptTaxonomyAxiom2TerminologyBundleStatementUUIDCast
	: CatalystCast
	  [ taggedTypes.RootConceptTaxonomyAxiomUUID,
	    taggedTypes.TerminologyBundleStatementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.RootConceptTaxonomyAxiomUUID,
	    taggedTypes.TerminologyBundleStatementUUID]]
	
	// 1 casts for Rule
	
	implicit val Rule2TermUUIDCast
	: CatalystCast
	  [ taggedTypes.RuleUUID,
	    taggedTypes.TermUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.RuleUUID,
	    taggedTypes.TermUUID]]
	
	// 1 casts for RuleBodySegment
	
	implicit val RuleBodySegment2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.RuleBodySegmentUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.RuleBodySegmentUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	// 2 casts for Scalar
	
	implicit val Scalar2DataRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.ScalarUUID,
	    taggedTypes.DataRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ScalarUUID,
	    taggedTypes.DataRangeUUID]]
	
	implicit val Scalar2UnaryTermKindUUIDCast
	: CatalystCast
	  [ taggedTypes.ScalarUUID,
	    taggedTypes.UnaryTermKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ScalarUUID,
	    taggedTypes.UnaryTermKindUUID]]
	
	// 3 casts for ScalarDataProperty
	
	implicit val ScalarDataProperty2DataRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.ScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipUUID]]
	
	implicit val ScalarDataProperty2DataRelationshipFromStructureUUIDCast
	: CatalystCast
	  [ taggedTypes.ScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipFromStructureUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipFromStructureUUID]]
	
	implicit val ScalarDataProperty2DataRelationshipToScalarUUIDCast
	: CatalystCast
	  [ taggedTypes.ScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipToScalarUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ScalarDataPropertyUUID,
	    taggedTypes.DataRelationshipToScalarUUID]]
	
	// 2 casts for ScalarDataPropertyValue
	
	implicit val ScalarDataPropertyValue2LogicalElementUUIDCast
	: CatalystCast
	  [ taggedTypes.ScalarDataPropertyValueUUID,
	    taggedTypes.LogicalElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ScalarDataPropertyValueUUID,
	    taggedTypes.LogicalElementUUID]]
	
	implicit val ScalarDataPropertyValue2ValueCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.ScalarDataPropertyValueUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ScalarDataPropertyValueUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]]
	
	// 2 casts for ScalarOneOfLiteralAxiom
	
	implicit val ScalarOneOfLiteralAxiom2TermAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.ScalarOneOfLiteralAxiomUUID,
	    taggedTypes.TermAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ScalarOneOfLiteralAxiomUUID,
	    taggedTypes.TermAxiomUUID]]
	
	implicit val ScalarOneOfLiteralAxiom2ValueCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.ScalarOneOfLiteralAxiomUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ScalarOneOfLiteralAxiomUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]]
	
	// 1 casts for ScalarOneOfRestriction
	
	implicit val ScalarOneOfRestriction2RestrictedDataRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.ScalarOneOfRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ScalarOneOfRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]]
	
	// 1 casts for SegmentPredicate
	
	implicit val SegmentPredicate2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.SegmentPredicateUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SegmentPredicateUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	// 2 casts for SingletonInstanceScalarDataPropertyValue
	
	implicit val SingletonInstanceScalarDataPropertyValue2ModuleElementUUIDCast
	: CatalystCast
	  [ taggedTypes.SingletonInstanceScalarDataPropertyValueUUID,
	    taggedTypes.ModuleElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SingletonInstanceScalarDataPropertyValueUUID,
	    taggedTypes.ModuleElementUUID]]
	
	implicit val SingletonInstanceScalarDataPropertyValue2ValueCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.SingletonInstanceScalarDataPropertyValueUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SingletonInstanceScalarDataPropertyValueUUID,
	    taggedTypes.ValueCrossReferenceTupleUUID]]
	
	// 1 casts for SingletonInstanceStructuredDataPropertyContext
	
	implicit val SingletonInstanceStructuredDataPropertyContext2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	// 2 casts for SingletonInstanceStructuredDataPropertyValue
	
	implicit val SingletonInstanceStructuredDataPropertyValue2ModuleElementUUIDCast
	: CatalystCast
	  [ taggedTypes.SingletonInstanceStructuredDataPropertyValueUUID,
	    taggedTypes.ModuleElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SingletonInstanceStructuredDataPropertyValueUUID,
	    taggedTypes.ModuleElementUUID]]
	
	implicit val SingletonInstanceStructuredDataPropertyValue2SingletonInstanceStructuredDataPropertyContextUUIDCast
	: CatalystCast
	  [ taggedTypes.SingletonInstanceStructuredDataPropertyValueUUID,
	    taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SingletonInstanceStructuredDataPropertyValueUUID,
	    taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID]]
	
	// 2 casts for SpecializationAxiom
	
	implicit val SpecializationAxiom2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.SpecializationAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SpecializationAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	implicit val SpecializationAxiom2TermAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.SpecializationAxiomUUID,
	    taggedTypes.TermAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SpecializationAxiomUUID,
	    taggedTypes.TermAxiomUUID]]
	
	// 1 casts for SpecificDisjointConceptAxiom
	
	implicit val SpecificDisjointConceptAxiom2DisjointUnionOfConceptsAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.SpecificDisjointConceptAxiomUUID,
	    taggedTypes.DisjointUnionOfConceptsAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SpecificDisjointConceptAxiomUUID,
	    taggedTypes.DisjointUnionOfConceptsAxiomUUID]]
	
	// 1 casts for StringScalarRestriction
	
	implicit val StringScalarRestriction2RestrictedDataRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.StringScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.StringScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]]
	
	// 2 casts for Structure
	
	implicit val Structure2DatatypeUUIDCast
	: CatalystCast
	  [ taggedTypes.StructureUUID,
	    taggedTypes.DatatypeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.StructureUUID,
	    taggedTypes.DatatypeUUID]]
	
	implicit val Structure2UnaryTermKindUUIDCast
	: CatalystCast
	  [ taggedTypes.StructureUUID,
	    taggedTypes.UnaryTermKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.StructureUUID,
	    taggedTypes.UnaryTermKindUUID]]
	
	// 3 casts for StructuredDataProperty
	
	implicit val StructuredDataProperty2DataRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.StructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.StructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipUUID]]
	
	implicit val StructuredDataProperty2DataRelationshipFromStructureUUIDCast
	: CatalystCast
	  [ taggedTypes.StructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipFromStructureUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.StructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipFromStructureUUID]]
	
	implicit val StructuredDataProperty2DataRelationshipToStructureUUIDCast
	: CatalystCast
	  [ taggedTypes.StructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipToStructureUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.StructuredDataPropertyUUID,
	    taggedTypes.DataRelationshipToStructureUUID]]
	
	// 1 casts for StructuredDataPropertyTuple
	
	implicit val StructuredDataPropertyTuple2SingletonInstanceStructuredDataPropertyContextUUIDCast
	: CatalystCast
	  [ taggedTypes.StructuredDataPropertyTupleUUID,
	    taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.StructuredDataPropertyTupleUUID,
	    taggedTypes.SingletonInstanceStructuredDataPropertyContextUUID]]
	
	// 2 casts for SubDataPropertyOfAxiom
	
	implicit val SubDataPropertyOfAxiom2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.SubDataPropertyOfAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SubDataPropertyOfAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	implicit val SubDataPropertyOfAxiom2TermAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.SubDataPropertyOfAxiomUUID,
	    taggedTypes.TermAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SubDataPropertyOfAxiomUUID,
	    taggedTypes.TermAxiomUUID]]
	
	// 2 casts for SubObjectPropertyOfAxiom
	
	implicit val SubObjectPropertyOfAxiom2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.SubObjectPropertyOfAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SubObjectPropertyOfAxiomUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	implicit val SubObjectPropertyOfAxiom2TermAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.SubObjectPropertyOfAxiomUUID,
	    taggedTypes.TermAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SubObjectPropertyOfAxiomUUID,
	    taggedTypes.TermAxiomUUID]]
	
	// 1 casts for SynonymScalarRestriction
	
	implicit val SynonymScalarRestriction2RestrictedDataRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.SynonymScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.SynonymScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]]
	
	// 2 casts for Term
	
	implicit val Term2ResourceUUIDCast
	: CatalystCast
	  [ taggedTypes.TermUUID,
	    taggedTypes.ResourceUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TermUUID,
	    taggedTypes.ResourceUUID]]
	
	implicit val Term2TerminologyBoxStatementUUIDCast
	: CatalystCast
	  [ taggedTypes.TermUUID,
	    taggedTypes.TerminologyBoxStatementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TermUUID,
	    taggedTypes.TerminologyBoxStatementUUID]]
	
	// 1 casts for TermAxiom
	
	implicit val TermAxiom2TerminologyBoxStatementUUIDCast
	: CatalystCast
	  [ taggedTypes.TermAxiomUUID,
	    taggedTypes.TerminologyBoxStatementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TermAxiomUUID,
	    taggedTypes.TerminologyBoxStatementUUID]]
	
	// 1 casts for TerminologyAxiom
	
	implicit val TerminologyAxiom2ModuleEdgeUUIDCast
	: CatalystCast
	  [ taggedTypes.TerminologyAxiomUUID,
	    taggedTypes.ModuleEdgeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TerminologyAxiomUUID,
	    taggedTypes.ModuleEdgeUUID]]
	
	// 1 casts for TerminologyBox
	
	implicit val TerminologyBox2ModuleUUIDCast
	: CatalystCast
	  [ taggedTypes.TerminologyBoxUUID,
	    taggedTypes.ModuleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TerminologyBoxUUID,
	    taggedTypes.ModuleUUID]]
	
	// 1 casts for TerminologyBoxAxiom
	
	implicit val TerminologyBoxAxiom2TerminologyAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.TerminologyBoxAxiomUUID,
	    taggedTypes.TerminologyAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TerminologyBoxAxiomUUID,
	    taggedTypes.TerminologyAxiomUUID]]
	
	// 1 casts for TerminologyBoxStatement
	
	implicit val TerminologyBoxStatement2ModuleElementUUIDCast
	: CatalystCast
	  [ taggedTypes.TerminologyBoxStatementUUID,
	    taggedTypes.ModuleElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TerminologyBoxStatementUUID,
	    taggedTypes.ModuleElementUUID]]
	
	// 1 casts for TerminologyBundleAxiom
	
	implicit val TerminologyBundleAxiom2TerminologyAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.TerminologyBundleAxiomUUID,
	    taggedTypes.TerminologyAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TerminologyBundleAxiomUUID,
	    taggedTypes.TerminologyAxiomUUID]]
	
	// 1 casts for TerminologyBundleStatement
	
	implicit val TerminologyBundleStatement2ModuleElementUUIDCast
	: CatalystCast
	  [ taggedTypes.TerminologyBundleStatementUUID,
	    taggedTypes.ModuleElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TerminologyBundleStatementUUID,
	    taggedTypes.ModuleElementUUID]]
	
	// 1 casts for TerminologyExtensionAxiom
	
	implicit val TerminologyExtensionAxiom2TerminologyBoxAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.TerminologyExtensionAxiomUUID,
	    taggedTypes.TerminologyBoxAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TerminologyExtensionAxiomUUID,
	    taggedTypes.TerminologyBoxAxiomUUID]]
	
	// 1 casts for TerminologyGraph
	
	implicit val TerminologyGraph2TerminologyBoxUUIDCast
	: CatalystCast
	  [ taggedTypes.TerminologyGraphUUID,
	    taggedTypes.TerminologyBoxUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TerminologyGraphUUID,
	    taggedTypes.TerminologyBoxUUID]]
	
	// 1 casts for TerminologyInstanceAssertion
	
	implicit val TerminologyInstanceAssertion2ModuleElementUUIDCast
	: CatalystCast
	  [ taggedTypes.TerminologyInstanceAssertionUUID,
	    taggedTypes.ModuleElementUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TerminologyInstanceAssertionUUID,
	    taggedTypes.ModuleElementUUID]]
	
	// 1 casts for TerminologyNestingAxiom
	
	implicit val TerminologyNestingAxiom2TerminologyBoxAxiomUUIDCast
	: CatalystCast
	  [ taggedTypes.TerminologyNestingAxiomUUID,
	    taggedTypes.TerminologyBoxAxiomUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TerminologyNestingAxiomUUID,
	    taggedTypes.TerminologyBoxAxiomUUID]]
	
	// 1 casts for TimeScalarRestriction
	
	implicit val TimeScalarRestriction2RestrictedDataRangeUUIDCast
	: CatalystCast
	  [ taggedTypes.TimeScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.TimeScalarRestrictionUUID,
	    taggedTypes.RestrictedDataRangeUUID]]
	
	// 1 casts for UnaryTermKind
	
	implicit val UnaryTermKind2TermUUIDCast
	: CatalystCast
	  [ taggedTypes.UnaryTermKindUUID,
	    taggedTypes.TermUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.UnaryTermKindUUID,
	    taggedTypes.TermUUID]]
	
	// 2 casts for UnreifiedRelationship
	
	implicit val UnreifiedRelationship2CharacterizedEntityRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.UnreifiedRelationshipUUID,
	    taggedTypes.CharacterizedEntityRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.UnreifiedRelationshipUUID,
	    taggedTypes.CharacterizedEntityRelationshipUUID]]
	
	implicit val UnreifiedRelationship2RestrictableRelationshipUUIDCast
	: CatalystCast
	  [ taggedTypes.UnreifiedRelationshipUUID,
	    taggedTypes.RestrictableRelationshipUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.UnreifiedRelationshipUUID,
	    taggedTypes.RestrictableRelationshipUUID]]
	
	// 2 casts for UnreifiedRelationshipInstanceTuple
	
	implicit val UnreifiedRelationshipInstanceTuple2ElementCrossReferenceTupleUUIDCast
	: CatalystCast
	  [ taggedTypes.UnreifiedRelationshipInstanceTupleUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.UnreifiedRelationshipInstanceTupleUUID,
	    taggedTypes.ElementCrossReferenceTupleUUID]]
	
	implicit val UnreifiedRelationshipInstanceTuple2TerminologyInstanceAssertionUUIDCast
	: CatalystCast
	  [ taggedTypes.UnreifiedRelationshipInstanceTupleUUID,
	    taggedTypes.TerminologyInstanceAssertionUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.UnreifiedRelationshipInstanceTupleUUID,
	    taggedTypes.TerminologyInstanceAssertionUUID]]
	
	// 2 casts for ValueCrossReferenceTuple
	
	implicit val ValueCrossReferenceTuple2ExtrinsicIdentityKindUUIDCast
	: CatalystCast
	  [ taggedTypes.ValueCrossReferenceTupleUUID,
	    taggedTypes.ExtrinsicIdentityKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ValueCrossReferenceTupleUUID,
	    taggedTypes.ExtrinsicIdentityKindUUID]]
	
	implicit val ValueCrossReferenceTuple2NonCrossReferencableKindUUIDCast
	: CatalystCast
	  [ taggedTypes.ValueCrossReferenceTupleUUID,
	    taggedTypes.NonCrossReferencableKindUUID]
	= theInstance.asInstanceOf[CatalystCast
	  [ taggedTypes.ValueCrossReferenceTupleUUID,
	    taggedTypes.NonCrossReferencableKindUUID]]
	
}
