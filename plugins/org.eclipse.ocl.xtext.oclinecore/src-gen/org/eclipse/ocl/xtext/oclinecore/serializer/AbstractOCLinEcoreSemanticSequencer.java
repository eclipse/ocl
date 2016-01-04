/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.basecs.AnnotationCS;
import org.eclipse.ocl.xtext.basecs.AttributeCS;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.DataTypeCS;
import org.eclipse.ocl.xtext.basecs.DetailCS;
import org.eclipse.ocl.xtext.basecs.DocumentationCS;
import org.eclipse.ocl.xtext.basecs.EnumerationCS;
import org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.ModelElementRefCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.ReferenceCS;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.xtext.essentialocl.serializer.EssentialOCLSemanticSequencer;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS;
import org.eclipse.ocl.xtext.oclinecorecs.SysMLCS;
import org.eclipse.ocl.xtext.oclinecorecs.TopLevelCS;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public abstract class AbstractOCLinEcoreSemanticSequencer extends EssentialOCLSemanticSequencer {

	@Inject
	private OCLinEcoreGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == BaseCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case BaseCSPackage.ANNOTATION_CS:
				sequence_AnnotationCS(context, (AnnotationCS) semanticObject); 
				return; 
			case BaseCSPackage.ATTRIBUTE_CS:
				sequence_AttributeCS(context, (AttributeCS) semanticObject); 
				return; 
			case BaseCSPackage.DATA_TYPE_CS:
				sequence_DataTypeCS(context, (DataTypeCS) semanticObject); 
				return; 
			case BaseCSPackage.DETAIL_CS:
				sequence_DetailCS(context, (DetailCS) semanticObject); 
				return; 
			case BaseCSPackage.DOCUMENTATION_CS:
				sequence_DocumentationCS(context, (DocumentationCS) semanticObject); 
				return; 
			case BaseCSPackage.ENUMERATION_CS:
				sequence_EnumerationCS(context, (EnumerationCS) semanticObject); 
				return; 
			case BaseCSPackage.ENUMERATION_LITERAL_CS:
				sequence_EnumerationLiteralCS(context, (EnumerationLiteralCS) semanticObject); 
				return; 
			case BaseCSPackage.IMPORT_CS:
				sequence_ImportCS(context, (ImportCS) semanticObject); 
				return; 
			case BaseCSPackage.MODEL_ELEMENT_REF_CS:
				sequence_ModelElementRefCS(context, (ModelElementRefCS) semanticObject); 
				return; 
			case BaseCSPackage.MULTIPLICITY_BOUNDS_CS:
				if(context == grammarAccess.getMultiplicityBoundsCSRule()) {
					sequence_MultiplicityBoundsCS(context, (MultiplicityBoundsCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMultiplicityCSRule()) {
					sequence_MultiplicityBoundsCS_MultiplicityCS(context, (MultiplicityBoundsCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.MULTIPLICITY_STRING_CS:
				if(context == grammarAccess.getMultiplicityCSRule()) {
					sequence_MultiplicityCS_MultiplicityStringCS(context, (MultiplicityStringCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMultiplicityStringCSRule()) {
					sequence_MultiplicityStringCS(context, (MultiplicityStringCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.OPERATION_CS:
				sequence_OperationCS(context, (OperationCS) semanticObject); 
				return; 
			case BaseCSPackage.PACKAGE_CS:
				sequence_PackageCS(context, (PackageCS) semanticObject); 
				return; 
			case BaseCSPackage.PARAMETER_CS:
				sequence_ParameterCS(context, (ParameterCS) semanticObject); 
				return; 
			case BaseCSPackage.PATH_ELEMENT_CS:
				if(context == grammarAccess.getFirstPathElementCSRule()) {
					sequence_FirstPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNextPathElementCSRule()) {
					sequence_NextPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getURIFirstPathElementCSRule()) {
					sequence_URIFirstPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PATH_ELEMENT_WITH_URICS:
				sequence_URIFirstPathElementCS(context, (PathElementWithURICS) semanticObject); 
				return; 
			case BaseCSPackage.PATH_NAME_CS:
				if(context == grammarAccess.getPathNameCSRule()) {
					sequence_PathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getURIPathNameCSRule()) {
					sequence_URIPathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PRIMITIVE_TYPE_REF_CS:
				if(context == grammarAccess.getPrimitiveTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule() ||
				   context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule()) {
					sequence_PrimitiveTypeCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_PrimitiveTypeCS_TypeExpCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_PrimitiveTypeCS_TypedMultiplicityRefCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.REFERENCE_CS:
				sequence_ReferenceCS(context, (ReferenceCS) semanticObject); 
				return; 
			case BaseCSPackage.STRUCTURED_CLASS_CS:
				sequence_StructuredClassCS(context, (StructuredClassCS) semanticObject); 
				return; 
			case BaseCSPackage.TEMPLATE_BINDING_CS:
				sequence_TemplateBindingCS(context, (TemplateBindingCS) semanticObject); 
				return; 
			case BaseCSPackage.TEMPLATE_PARAMETER_SUBSTITUTION_CS:
				sequence_TemplateParameterSubstitutionCS(context, (TemplateParameterSubstitutionCS) semanticObject); 
				return; 
			case BaseCSPackage.TEMPLATE_SIGNATURE_CS:
				sequence_TemplateSignatureCS(context, (TemplateSignatureCS) semanticObject); 
				return; 
			case BaseCSPackage.TUPLE_PART_CS:
				sequence_TuplePartCS(context, (TuplePartCS) semanticObject); 
				return; 
			case BaseCSPackage.TUPLE_TYPE_CS:
				if(context == grammarAccess.getTupleTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule() ||
				   context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule()) {
					sequence_TupleTypeCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_TupleTypeCS_TypeExpCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_TupleTypeCS_TypedMultiplicityRefCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TYPE_PARAMETER_CS:
				sequence_TypeParameterCS(context, (TypeParameterCS) semanticObject); 
				return; 
			case BaseCSPackage.TYPED_TYPE_REF_CS:
				if(context == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_TypedMultiplicityRefCS_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule() ||
				   context == grammarAccess.getTypedTypeRefCSRule()) {
					sequence_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.WILDCARD_TYPE_REF_CS:
				sequence_WildcardTypeRefCS(context, (WildcardTypeRefCS) semanticObject); 
				return; 
			}
		else if(semanticObject.eClass().getEPackage() == EssentialOCLCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EssentialOCLCSPackage.BOOLEAN_LITERAL_EXP_CS:
				sequence_BooleanLiteralExpCS(context, (BooleanLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.COLLECTION_LITERAL_EXP_CS:
				sequence_CollectionLiteralExpCS(context, (CollectionLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS:
				sequence_CollectionLiteralPartCS(context, (CollectionLiteralPartCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.COLLECTION_PATTERN_CS:
				if(context == grammarAccess.getCollectionPatternCSRule()) {
					sequence_CollectionPatternCS(context, (CollectionPatternCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_CollectionPatternCS_TypeExpCS(context, (CollectionPatternCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.COLLECTION_TYPE_CS:
				if(context == grammarAccess.getCollectionTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule() ||
				   context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule()) {
					sequence_CollectionTypeCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_CollectionTypeCS_TypeExpCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_CollectionTypeCS_TypedMultiplicityRefCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.CONTEXT_CS:
				sequence_Model(context, (ContextCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS:
				sequence_CurlyBracketedClauseCS(context, (CurlyBracketedClauseCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.EXP_SPECIFICATION_CS:
				sequence_SpecificationCS(context, (ExpSpecificationCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.IF_EXP_CS:
				sequence_IfExpCS(context, (IfExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.IF_THEN_EXP_CS:
				sequence_ElseIfThenExpCS(context, (IfThenExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.INFIX_EXP_CS:
				sequence_ExpCS(context, (InfixExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.INVALID_LITERAL_EXP_CS:
				sequence_InvalidLiteralExpCS(context, (InvalidLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.LAMBDA_LITERAL_EXP_CS:
				sequence_LambdaLiteralExpCS(context, (LambdaLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.LET_EXP_CS:
				sequence_LetExpCS(context, (LetExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.LET_VARIABLE_CS:
				sequence_LetVariableCS(context, (LetVariableCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.MAP_LITERAL_EXP_CS:
				sequence_MapLiteralExpCS(context, (MapLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.MAP_LITERAL_PART_CS:
				sequence_MapLiteralPartCS(context, (MapLiteralPartCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.MAP_TYPE_CS:
				if(context == grammarAccess.getMapTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule() ||
				   context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule()) {
					sequence_MapTypeCS(context, (MapTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_MapTypeCS_TypeExpCS(context, (MapTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_MapTypeCS_TypeLiteralWithMultiplicityCS(context, (MapTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_MapTypeCS_TypedMultiplicityRefCS(context, (MapTypeCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NAME_EXP_CS:
				sequence_NameExpCS(context, (NameExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.NAVIGATING_ARG_CS:
				if(context == grammarAccess.getNavigatingArgCSRule()) {
					sequence_NavigatingArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingBarArgCSRule()) {
					sequence_NavigatingBarArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingCommaArgCSRule()) {
					sequence_NavigatingCommaArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingSemiArgCSRule()) {
					sequence_NavigatingSemiArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NESTED_EXP_CS:
				sequence_NestedExpCS(context, (NestedExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.NULL_LITERAL_EXP_CS:
				sequence_NullLiteralExpCS(context, (NullLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.NUMBER_LITERAL_EXP_CS:
				sequence_NumberLiteralExpCS(context, (NumberLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.PATTERN_EXP_CS:
				sequence_PatternExpCS(context, (PatternExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.PREFIX_EXP_CS:
				if(context == grammarAccess.getPrefixedLetExpCSRule()) {
					sequence_PrefixedLetExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule()) {
					sequence_PrefixedLetExpCS_PrefixedPrimaryExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule()) {
					sequence_PrefixedPrimaryExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS:
				sequence_RoundBracketedClauseCS(context, (RoundBracketedClauseCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.SELF_EXP_CS:
				sequence_SelfExpCS(context, (SelfExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.SHADOW_PART_CS:
				sequence_ShadowPartCS(context, (ShadowPartCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS:
				sequence_SquareBracketedClauseCS(context, (SquareBracketedClauseCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.STRING_LITERAL_EXP_CS:
				sequence_StringLiteralExpCS(context, (StringLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.TUPLE_LITERAL_EXP_CS:
				sequence_TupleLiteralExpCS(context, (TupleLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.TUPLE_LITERAL_PART_CS:
				sequence_TupleLiteralPartCS(context, (TupleLiteralPartCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.TYPE_LITERAL_EXP_CS:
				sequence_TypeLiteralExpCS(context, (TypeLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.TYPE_NAME_EXP_CS:
				if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_TypeExpCS_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeNameExpCSRule()) {
					sequence_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
				sequence_UnlimitedNaturalLiteralExpCS(context, (UnlimitedNaturalLiteralExpCS) semanticObject); 
				return; 
			}
		else if(semanticObject.eClass().getEPackage() == OCLinEcoreCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case OCLinEcoreCSPackage.OC_LIN_ECORE_CONSTRAINT_CS:
				if(context == grammarAccess.getInvariantConstraintCSRule()) {
					sequence_InvariantConstraintCS(context, (OCLinEcoreConstraintCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPostconditionConstraintCSRule()) {
					sequence_PostconditionConstraintCS(context, (OCLinEcoreConstraintCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPreconditionConstraintCSRule()) {
					sequence_PreconditionConstraintCS(context, (OCLinEcoreConstraintCS) semanticObject); 
					return; 
				}
				else break;
			case OCLinEcoreCSPackage.SYS_MLCS:
				sequence_SysMLCS(context, (SysMLCS) semanticObject); 
				return; 
			case OCLinEcoreCSPackage.TOP_LEVEL_CS:
				sequence_TopLevelCS(context, (TopLevelCS) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         (name=UnrestrictedName | name=SINGLE_QUOTED_STRING)? 
	 *         (ownedDetails+=DetailCS ownedDetails+=DetailCS*)? 
	 *         (ownedAnnotations+=AnnotationElementCS | ownedContents+=ModelElementCS | ownedReferences+=ModelElementRefCS)*
	 *     )
	 */
	protected void sequence_AnnotationCS(EObject context, AnnotationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((qualifiers+='static' qualifiers+='definition'?) | (qualifiers+='definition' qualifiers+='static'?))? 
	 *         name=UnrestrictedName 
	 *         ownedType=TypedMultiplicityRefCS? 
	 *         default=SINGLE_QUOTED_STRING? 
	 *         (
	 *             qualifiers+='derived' | 
	 *             qualifiers+='!derived' | 
	 *             qualifiers+='id' | 
	 *             qualifiers+='!id' | 
	 *             qualifiers+='ordered' | 
	 *             qualifiers+='!ordered' | 
	 *             qualifiers+='readonly' | 
	 *             qualifiers+='!readonly' | 
	 *             qualifiers+='transient' | 
	 *             qualifiers+='!transient' | 
	 *             qualifiers+='unique' | 
	 *             qualifiers+='!unique' | 
	 *             qualifiers+='unsettable' | 
	 *             qualifiers+='!unsettable' | 
	 *             qualifiers+='volatile' | 
	 *             qualifiers+='!volatile'
	 *         )* 
	 *         (ownedAnnotations+=AnnotationElementCS | ownedDefaultExpressions+=SpecificationCS? | ownedDefaultExpressions+=SpecificationCS?)*
	 *     )
	 */
	protected void sequence_AttributeCS(EObject context, AttributeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=CollectionTypeIdentifier ownedType=TypeExpCS? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_CollectionTypeCS_TypedMultiplicityRefCS(EObject context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isPrimitive?='primitive'? 
	 *         name=UnrestrictedName 
	 *         ownedSignature=TemplateSignatureCS? 
	 *         instanceClassName=SINGLE_QUOTED_STRING? 
	 *         isSerializable?='serializable'? 
	 *         (ownedAnnotations+=AnnotationElementCS | ownedConstraints+=InvariantConstraintCS)*
	 *     )
	 */
	protected void sequence_DataTypeCS(EObject context, DataTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=UnrestrictedName | name=SINGLE_QUOTED_STRING) (values+=SINGLE_QUOTED_STRING | values+=ML_SINGLE_QUOTED_STRING)*)
	 */
	protected void sequence_DetailCS(EObject context, DetailCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=SINGLE_QUOTED_STRING? (ownedDetails+=DetailCS ownedDetails+=DetailCS*)?)
	 */
	protected void sequence_DocumentationCS(EObject context, DocumentationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         ownedSignature=TemplateSignatureCS? 
	 *         instanceClassName=SINGLE_QUOTED_STRING? 
	 *         isSerializable?='serializable'? 
	 *         (ownedAnnotations+=AnnotationElementCS | ownedLiterals+=EnumerationLiteralCS | ownedConstraints+=InvariantConstraintCS)*
	 *     )
	 */
	protected void sequence_EnumerationCS(EObject context, EnumerationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=UnrestrictedName | name=EnumerationLiteralName) value=SIGNED? ownedAnnotations+=AnnotationElementCS*)
	 */
	protected void sequence_EnumerationLiteralCS(EObject context, EnumerationLiteralCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName? ownedPathName=URIPathNameCS isAll?='::*'?)
	 */
	protected void sequence_ImportCS(EObject context, ImportCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isCallable?='callable'? 
	 *         stereotype='invariant' 
	 *         (name=UnrestrictedName ownedMessageSpecification=SpecificationCS?)? 
	 *         ownedSpecification=SpecificationCS?
	 *     )
	 */
	protected void sequence_InvariantConstraintCS(EObject context, OCLinEcoreConstraintCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_MapTypeCS_TypedMultiplicityRefCS(EObject context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedPathName=PathNameCS
	 */
	protected void sequence_ModelElementRefCS(EObject context, ModelElementRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((qualifiers+='static' qualifiers+='definition'?) | (qualifiers+='definition' qualifiers+='static'?))? 
	 *         ownedSignature=TemplateSignatureCS? 
	 *         name=UnrestrictedName 
	 *         (ownedParameters+=ParameterCS ownedParameters+=ParameterCS*)? 
	 *         ownedType=TypedMultiplicityRefCS? 
	 *         (ownedExceptions+=TypedRefCS ownedExceptions+=TypedRefCS*)? 
	 *         (
	 *             qualifiers+='derived' | 
	 *             qualifiers+='!derived' | 
	 *             qualifiers+='ordered' | 
	 *             qualifiers+='!ordered' | 
	 *             qualifiers+='unique' | 
	 *             qualifiers+='!unique'
	 *         )* 
	 *         (
	 *             ownedAnnotations+=AnnotationElementCS | 
	 *             ownedPreconditions+=PreconditionConstraintCS | 
	 *             ownedBodyExpressions+=SpecificationCS? | 
	 *             ownedPostconditions+=PostconditionConstraintCS
	 *         )*
	 *     )
	 */
	protected void sequence_OperationCS(EObject context, OperationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         nsPrefix=UnrestrictedName? 
	 *         nsURI=URI? 
	 *         (ownedAnnotations+=AnnotationElementCS | ownedPackages+=PackageCS | ownedClasses+=ClassCS)*
	 *     )
	 */
	protected void sequence_PackageCS(EObject context, PackageCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         ownedType=TypedMultiplicityRefCS? 
	 *         (qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique')* 
	 *         ownedAnnotations+=AnnotationElementCS*
	 *     )
	 */
	protected void sequence_ParameterCS(EObject context, ParameterCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (stereotype='postcondition' (name=UnrestrictedName ownedMessageSpecification=SpecificationCS?)? ownedSpecification=SpecificationCS?)
	 */
	protected void sequence_PostconditionConstraintCS(EObject context, OCLinEcoreConstraintCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (stereotype='precondition' (name=UnrestrictedName ownedMessageSpecification=SpecificationCS?)? ownedSpecification=SpecificationCS?)
	 */
	protected void sequence_PreconditionConstraintCS(EObject context, OCLinEcoreConstraintCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_PrimitiveTypeCS_TypedMultiplicityRefCS(EObject context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((qualifiers+='static' qualifiers+='definition'?) | (qualifiers+='definition' qualifiers+='static'?))? 
	 *         name=UnrestrictedName 
	 *         referredOpposite=[Property|UnrestrictedName]? 
	 *         ownedType=TypedMultiplicityRefCS? 
	 *         default=SINGLE_QUOTED_STRING? 
	 *         (
	 *             qualifiers+='composes' | 
	 *             qualifiers+='!composes' | 
	 *             qualifiers+='derived' | 
	 *             qualifiers+='!derived' | 
	 *             qualifiers+='ordered' | 
	 *             qualifiers+='!ordered' | 
	 *             qualifiers+='readonly' | 
	 *             qualifiers+='!readonly' | 
	 *             qualifiers+='resolve' | 
	 *             qualifiers+='!resolve' | 
	 *             qualifiers+='transient' | 
	 *             qualifiers+='!transient' | 
	 *             qualifiers+='unique' | 
	 *             qualifiers+='!unique' | 
	 *             qualifiers+='unsettable' | 
	 *             qualifiers+='!unsettable' | 
	 *             qualifiers+='volatile' | 
	 *             qualifiers+='!volatile'
	 *         )* 
	 *         (
	 *             ownedAnnotations+=AnnotationElementCS | 
	 *             (referredKeys+=[Property|UnrestrictedName] referredKeys+=[Property|UnrestrictedName]*) | 
	 *             ownedDefaultExpressions+=SpecificationCS? | 
	 *             ownedDefaultExpressions+=SpecificationCS?
	 *         )*
	 *     )
	 */
	protected void sequence_ReferenceCS(EObject context, ReferenceCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedExpression=ExpCS | exprString=UNQUOTED_STRING)
	 */
	protected void sequence_SpecificationCS(EObject context, ExpSpecificationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=UnrestrictedName 
	 *         ownedSignature=TemplateSignatureCS? 
	 *         (ownedSuperTypes+=TypedRefCS ownedSuperTypes+=TypedRefCS*)? 
	 *         instanceClassName=SINGLE_QUOTED_STRING? 
	 *         isInterface?='interface'? 
	 *         (ownedAnnotations+=AnnotationElementCS | ownedOperations+=OperationCS | ownedProperties+=StructuralFeatureCS | ownedConstraints+=InvariantConstraintCS)*
	 *     )
	 */
	protected void sequence_StructuredClassCS(EObject context, StructuredClassCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedDetails+=DetailCS | ownedDetails+=DetailCS*)
	 */
	protected void sequence_SysMLCS(EObject context, SysMLCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((ownedParameters+=TypeParameterCS ownedParameters+=TypeParameterCS*) | (ownedParameters+=TypeParameterCS ownedParameters+=TypeParameterCS*))
	 */
	protected void sequence_TemplateSignatureCS(EObject context, TemplateSignatureCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedImports+=ImportCS* ownedPackages+=PackageCS*)
	 */
	protected void sequence_TopLevelCS(EObject context, TopLevelCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TupleTypeCS_TypedMultiplicityRefCS(EObject context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedPathName=PathNameCS (ownedBinding=TemplateBindingCS | ownedBinding=TemplateBindingCS)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TypedMultiplicityRefCS_TypedTypeRefCS(EObject context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedPathName=PathNameCS (ownedBinding=TemplateBindingCS | ownedBinding=TemplateBindingCS)?)
	 */
	protected void sequence_TypedTypeRefCS(EObject context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
