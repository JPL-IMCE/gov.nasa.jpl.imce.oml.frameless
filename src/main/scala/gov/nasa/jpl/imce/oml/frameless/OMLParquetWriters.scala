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

import gov.nasa.jpl.imce.oml.tables
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder
import org.apache.spark.sql.SQLContext
import scala.collection.immutable.Seq
import scala.Unit
import scala.Predef.String

object OMLParquetWriters {
	
	
	def writeAnnotationProperties
	(table: Seq[tables.AnnotationProperty], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.AnnotationProperty])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeAnnotationPropertyValues
	(table: Seq[tables.AnnotationPropertyValue], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.AnnotationPropertyValue])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeAnonymousConceptUnionAxioms
	(table: Seq[tables.AnonymousConceptUnionAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.AnonymousConceptUnionAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeAspects
	(table: Seq[tables.Aspect], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.Aspect])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeAspectSpecializationAxioms
	(table: Seq[tables.AspectSpecializationAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.AspectSpecializationAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeBinaryScalarRestrictions
	(table: Seq[tables.BinaryScalarRestriction], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.BinaryScalarRestriction])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeBundles
	(table: Seq[tables.Bundle], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.Bundle])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeBundledTerminologyAxioms
	(table: Seq[tables.BundledTerminologyAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.BundledTerminologyAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeCardinalityRestrictedAspects
	(table: Seq[tables.CardinalityRestrictedAspect], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.CardinalityRestrictedAspect])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeCardinalityRestrictedConcepts
	(table: Seq[tables.CardinalityRestrictedConcept], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.CardinalityRestrictedConcept])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeCardinalityRestrictedReifiedRelationships
	(table: Seq[tables.CardinalityRestrictedReifiedRelationship], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.CardinalityRestrictedReifiedRelationship])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeChainRules
	(table: Seq[tables.ChainRule], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ChainRule])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeConcepts
	(table: Seq[tables.Concept], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.Concept])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeConceptDesignationTerminologyAxioms
	(table: Seq[tables.ConceptDesignationTerminologyAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ConceptDesignationTerminologyAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeConceptInstances
	(table: Seq[tables.ConceptInstance], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ConceptInstance])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeConceptSpecializationAxioms
	(table: Seq[tables.ConceptSpecializationAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ConceptSpecializationAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeDescriptionBoxes
	(table: Seq[tables.DescriptionBox], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.DescriptionBox])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeDescriptionBoxExtendsClosedWorldDefinitions
	(table: Seq[tables.DescriptionBoxExtendsClosedWorldDefinitions], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.DescriptionBoxExtendsClosedWorldDefinitions])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeDescriptionBoxRefinements
	(table: Seq[tables.DescriptionBoxRefinement], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.DescriptionBoxRefinement])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeEntityExistentialRestrictionAxioms
	(table: Seq[tables.EntityExistentialRestrictionAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.EntityExistentialRestrictionAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeEntityScalarDataProperties
	(table: Seq[tables.EntityScalarDataProperty], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.EntityScalarDataProperty])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeEntityScalarDataPropertyExistentialRestrictionAxioms
	(table: Seq[tables.EntityScalarDataPropertyExistentialRestrictionAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.EntityScalarDataPropertyExistentialRestrictionAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeEntityScalarDataPropertyParticularRestrictionAxioms
	(table: Seq[tables.EntityScalarDataPropertyParticularRestrictionAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.EntityScalarDataPropertyParticularRestrictionAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeEntityScalarDataPropertyUniversalRestrictionAxioms
	(table: Seq[tables.EntityScalarDataPropertyUniversalRestrictionAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.EntityScalarDataPropertyUniversalRestrictionAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeEntityStructuredDataProperties
	(table: Seq[tables.EntityStructuredDataProperty], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.EntityStructuredDataProperty])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeEntityStructuredDataPropertyParticularRestrictionAxioms
	(table: Seq[tables.EntityStructuredDataPropertyParticularRestrictionAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.EntityStructuredDataPropertyParticularRestrictionAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeEntityUniversalRestrictionAxioms
	(table: Seq[tables.EntityUniversalRestrictionAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.EntityUniversalRestrictionAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeForwardProperties
	(table: Seq[tables.ForwardProperty], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ForwardProperty])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeIRIScalarRestrictions
	(table: Seq[tables.IRIScalarRestriction], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.IRIScalarRestriction])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeInverseProperties
	(table: Seq[tables.InverseProperty], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.InverseProperty])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeNumericScalarRestrictions
	(table: Seq[tables.NumericScalarRestriction], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.NumericScalarRestriction])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writePlainLiteralScalarRestrictions
	(table: Seq[tables.PlainLiteralScalarRestriction], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.PlainLiteralScalarRestriction])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeReifiedRelationships
	(table: Seq[tables.ReifiedRelationship], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ReifiedRelationship])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeReifiedRelationshipInstances
	(table: Seq[tables.ReifiedRelationshipInstance], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ReifiedRelationshipInstance])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeReifiedRelationshipInstanceDomains
	(table: Seq[tables.ReifiedRelationshipInstanceDomain], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ReifiedRelationshipInstanceDomain])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeReifiedRelationshipInstanceRanges
	(table: Seq[tables.ReifiedRelationshipInstanceRange], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ReifiedRelationshipInstanceRange])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeReifiedRelationshipRestrictions
	(table: Seq[tables.ReifiedRelationshipRestriction], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ReifiedRelationshipRestriction])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeReifiedRelationshipSpecializationAxioms
	(table: Seq[tables.ReifiedRelationshipSpecializationAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ReifiedRelationshipSpecializationAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeRestrictionScalarDataPropertyValues
	(table: Seq[tables.RestrictionScalarDataPropertyValue], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.RestrictionScalarDataPropertyValue])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeRestrictionStructuredDataPropertyTuples
	(table: Seq[tables.RestrictionStructuredDataPropertyTuple], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.RestrictionStructuredDataPropertyTuple])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeRootConceptTaxonomyAxioms
	(table: Seq[tables.RootConceptTaxonomyAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.RootConceptTaxonomyAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeRuleBodySegments
	(table: Seq[tables.RuleBodySegment], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.RuleBodySegment])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeScalars
	(table: Seq[tables.Scalar], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.Scalar])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeScalarDataProperties
	(table: Seq[tables.ScalarDataProperty], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ScalarDataProperty])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeScalarDataPropertyValues
	(table: Seq[tables.ScalarDataPropertyValue], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ScalarDataPropertyValue])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeScalarOneOfLiteralAxioms
	(table: Seq[tables.ScalarOneOfLiteralAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ScalarOneOfLiteralAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeScalarOneOfRestrictions
	(table: Seq[tables.ScalarOneOfRestriction], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.ScalarOneOfRestriction])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeSegmentPredicates
	(table: Seq[tables.SegmentPredicate], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.SegmentPredicate])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeSingletonInstanceScalarDataPropertyValues
	(table: Seq[tables.SingletonInstanceScalarDataPropertyValue], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.SingletonInstanceScalarDataPropertyValue])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeSingletonInstanceStructuredDataPropertyValues
	(table: Seq[tables.SingletonInstanceStructuredDataPropertyValue], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.SingletonInstanceStructuredDataPropertyValue])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeSpecificDisjointConceptAxioms
	(table: Seq[tables.SpecificDisjointConceptAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.SpecificDisjointConceptAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeStringScalarRestrictions
	(table: Seq[tables.StringScalarRestriction], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.StringScalarRestriction])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeStructures
	(table: Seq[tables.Structure], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.Structure])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeStructuredDataProperties
	(table: Seq[tables.StructuredDataProperty], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.StructuredDataProperty])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeStructuredDataPropertyTuples
	(table: Seq[tables.StructuredDataPropertyTuple], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.StructuredDataPropertyTuple])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeSubDataPropertyOfAxioms
	(table: Seq[tables.SubDataPropertyOfAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.SubDataPropertyOfAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeSubObjectPropertyOfAxioms
	(table: Seq[tables.SubObjectPropertyOfAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.SubObjectPropertyOfAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeSynonymScalarRestrictions
	(table: Seq[tables.SynonymScalarRestriction], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.SynonymScalarRestriction])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeTerminologyExtensionAxioms
	(table: Seq[tables.TerminologyExtensionAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.TerminologyExtensionAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeTerminologyGraphs
	(table: Seq[tables.TerminologyGraph], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.TerminologyGraph])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeTerminologyNestingAxioms
	(table: Seq[tables.TerminologyNestingAxiom], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.TerminologyNestingAxiom])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeTimeScalarRestrictions
	(table: Seq[tables.TimeScalarRestriction], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.TimeScalarRestriction])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeUnreifiedRelationships
	(table: Seq[tables.UnreifiedRelationship], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.UnreifiedRelationship])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
	
	def writeUnreifiedRelationshipInstanceTuples
	(table: Seq[tables.UnreifiedRelationshipInstanceTuple], path: String)
	(implicit sqlContext: SQLContext, encoder: ExpressionEncoder[tables.UnreifiedRelationshipInstanceTuple])
	: Unit
	= sqlContext
	  .createDataset(table)
	  .write
	  .parquet(path)
}
