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
package org.eclipse.ocl.xtext.essentialocl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.base.serializer.BaseSemanticSequencer;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
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
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public abstract class AbstractEssentialOCLSemanticSequencer extends BaseSemanticSequencer {

	@Inject
	private EssentialOCLGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == BaseCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
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
				   context == grammarAccess.getTypeLiteralCSRule()) {
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
				else break;
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
				   context == grammarAccess.getTypeLiteralCSRule()) {
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
				else break;
			case BaseCSPackage.TYPE_PARAMETER_CS:
				sequence_TypeParameterCS(context, (TypeParameterCS) semanticObject); 
				return; 
			case BaseCSPackage.TYPED_TYPE_REF_CS:
				sequence_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject); 
				return; 
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
				   context == grammarAccess.getTypeLiteralCSRule()) {
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
				else break;
			case EssentialOCLCSPackage.CONTEXT_CS:
				sequence_Model(context, (ContextCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS:
				sequence_CurlyBracketedClauseCS(context, (CurlyBracketedClauseCS) semanticObject); 
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
				   context == grammarAccess.getTypeLiteralCSRule()) {
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
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (symbol='true' | symbol='false')
	 */
	protected void sequence_BooleanLiteralExpCS(EObject context, BooleanLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedType=CollectionTypeCS (ownedParts+=CollectionLiteralPartCS ownedParts+=CollectionLiteralPartCS*)?)
	 */
	protected void sequence_CollectionLiteralExpCS(EObject context, CollectionLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((ownedExpression=ExpCS ownedLastExpression=ExpCS?) | ownedExpression=PatternExpCS)
	 */
	protected void sequence_CollectionLiteralPartCS(EObject context, CollectionLiteralPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedType=CollectionTypeCS (ownedParts+=PatternExpCS ownedParts+=PatternExpCS* restVariableName=Identifier)?)
	 */
	protected void sequence_CollectionPatternCS(EObject context, CollectionPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedType=CollectionTypeCS (ownedParts+=PatternExpCS ownedParts+=PatternExpCS* restVariableName=Identifier)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_CollectionPatternCS_TypeExpCS(EObject context, CollectionPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=CollectionTypeIdentifier ownedType=TypeExpCS?)
	 */
	protected void sequence_CollectionTypeCS(EObject context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=CollectionTypeIdentifier ownedType=TypeExpCS? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_CollectionTypeCS_TypeExpCS(EObject context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=CollectionTypeIdentifier ownedType=TypeExpCS? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS(EObject context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((ownedParts+=ShadowPartCS ownedParts+=ShadowPartCS*)? | value=StringLiteral)
	 */
	protected void sequence_CurlyBracketedClauseCS(EObject context, CurlyBracketedClauseCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedCondition=ExpCS ownedThenExpression=ExpCS)
	 */
	protected void sequence_ElseIfThenExpCS(EObject context, IfThenExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedLeft=ExpCS_InfixExpCS_0_1_0 name=BinaryOperatorName ownedRight=ExpCS)
	 */
	protected void sequence_ExpCS(EObject context, InfixExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (ownedCondition=ExpCS | ownedCondition=PatternExpCS) 
	 *         ownedThenExpression=ExpCS 
	 *         ownedIfThenExpressions+=ElseIfThenExpCS* 
	 *         ownedElseExpression=ExpCS
	 *     )
	 */
	protected void sequence_IfExpCS(EObject context, IfExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {InvalidLiteralExpCS}
	 */
	protected void sequence_InvalidLiteralExpCS(EObject context, InvalidLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedExpressionCS=ExpCS
	 */
	protected void sequence_LambdaLiteralExpCS(EObject context, LambdaLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedVariables+=LetVariableCS ownedVariables+=LetVariableCS* ownedInExpression=ExpCS)
	 */
	protected void sequence_LetExpCS(EObject context, LetExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? ownedType=TypeExpCS? ownedInitExpression=ExpCS)
	 */
	protected void sequence_LetVariableCS(EObject context, LetVariableCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedType=MapTypeCS (ownedParts+=MapLiteralPartCS ownedParts+=MapLiteralPartCS*)?)
	 */
	protected void sequence_MapLiteralExpCS(EObject context, MapLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedKey=ExpCS ownedValue=ExpCS)
	 */
	protected void sequence_MapLiteralPartCS(EObject context, MapLiteralPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)?)
	 */
	protected void sequence_MapTypeCS(EObject context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_MapTypeCS_TypeExpCS(EObject context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_MapTypeCS_TypeLiteralWithMultiplicityCS(EObject context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedExpression=ExpCS
	 */
	protected void sequence_Model(EObject context, ContextCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ownedPathName=PathNameCS 
	 *         ownedSquareBracketedClauses+=SquareBracketedClauseCS* 
	 *         ownedRoundBracketedClause=RoundBracketedClauseCS? 
	 *         ownedCurlyBracketedClause=CurlyBracketedClauseCS? 
	 *         isPre?='@'?
	 *     )
	 */
	protected void sequence_NameExpCS(EObject context, NameExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((ownedNameExpression=NavigatingArgExpCS ((ownedType=TypeExpCS ownedInitExpression=ExpCS?) | ownedInitExpression=ExpCS)?) | ownedType=TypeExpCS)
	 */
	protected void sequence_NavigatingArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (prefix='|' ownedNameExpression=NavigatingArgExpCS (ownedType=TypeExpCS ownedInitExpression=ExpCS?)?)
	 */
	protected void sequence_NavigatingBarArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (prefix=',' ownedNameExpression=NavigatingArgExpCS ((ownedType=TypeExpCS ownedInitExpression=ExpCS?) | ownedInitExpression=ExpCS)?)
	 */
	protected void sequence_NavigatingCommaArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (prefix=';' ownedNameExpression=NavigatingArgExpCS (ownedType=TypeExpCS ownedInitExpression=ExpCS?)?)
	 */
	protected void sequence_NavigatingSemiArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedExpression=ExpCS
	 */
	protected void sequence_NestedExpCS(EObject context, NestedExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {NullLiteralExpCS}
	 */
	protected void sequence_NullLiteralExpCS(EObject context, NullLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     symbol=NUMBER_LITERAL
	 */
	protected void sequence_NumberLiteralExpCS(EObject context, NumberLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (patternVariableName=UnrestrictedName? ownedPatternType=TypeExpCS)
	 */
	protected void sequence_PatternExpCS(EObject context, PatternExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnaryOperatorName ownedRight=PrefixedLetExpCS)
	 */
	protected void sequence_PrefixedLetExpCS(EObject context, PrefixExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS) | (name=UnaryOperatorName ownedRight=PrefixedLetExpCS))
	 */
	protected void sequence_PrefixedLetExpCS_PrefixedPrimaryExpCS(EObject context, PrefixExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS)
	 */
	protected void sequence_PrefixedPrimaryExpCS(EObject context, PrefixExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=PrimitiveTypeIdentifier
	 */
	protected void sequence_PrimitiveTypeCS(EObject context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_PrimitiveTypeCS_TypeExpCS(EObject context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS(EObject context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             ownedArguments+=NavigatingArgCS 
	 *             ownedArguments+=NavigatingCommaArgCS* 
	 *             (ownedArguments+=NavigatingSemiArgCS ownedArguments+=NavigatingCommaArgCS*)? 
	 *             (ownedArguments+=NavigatingBarArgCS ownedArguments+=NavigatingCommaArgCS*)*
	 *         )?
	 *     )
	 */
	protected void sequence_RoundBracketedClauseCS(EObject context, RoundBracketedClauseCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {SelfExpCS}
	 */
	protected void sequence_SelfExpCS(EObject context, SelfExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (referredProperty=[Property|UnrestrictedName] (ownedInitExpression=ExpCS | ownedInitExpression=PatternExpCS))
	 */
	protected void sequence_ShadowPartCS(EObject context, ShadowPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedTerms+=ExpCS ownedTerms+=ExpCS*)
	 */
	protected void sequence_SquareBracketedClauseCS(EObject context, SquareBracketedClauseCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     segments+=StringLiteral+
	 */
	protected void sequence_StringLiteralExpCS(EObject context, StringLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedParts+=TupleLiteralPartCS ownedParts+=TupleLiteralPartCS*)
	 */
	protected void sequence_TupleLiteralExpCS(EObject context, TupleLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS? ownedInitExpression=ExpCS)
	 */
	protected void sequence_TupleLiteralPartCS(EObject context, TupleLiteralPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS)
	 */
	protected void sequence_TuplePartCS(EObject context, TuplePartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)?)
	 */
	protected void sequence_TupleTypeCS(EObject context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TupleTypeCS_TypeExpCS(EObject context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS(EObject context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ownedPatternGuard=ExpCS?)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TypeExpCS_TypeNameExpCS(EObject context, TypeNameExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedType=TypeLiteralWithMultiplicityCS
	 */
	protected void sequence_TypeLiteralExpCS(EObject context, TypeLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ownedPatternGuard=ExpCS?)?)
	 */
	protected void sequence_TypeNameExpCS(EObject context, TypeNameExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     referredElement=[NamedElement|UnrestrictedName]
	 */
	protected void sequence_URIFirstPathElementCS(EObject context, PathElementCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     referredElement=[Namespace|URI]
	 */
	protected void sequence_URIFirstPathElementCS(EObject context, PathElementWithURICS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedPathElements+=URIFirstPathElementCS ownedPathElements+=NextPathElementCS*)
	 */
	protected void sequence_URIPathNameCS(EObject context, PathNameCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {UnlimitedNaturalLiteralExpCS}
	 */
	protected void sequence_UnlimitedNaturalLiteralExpCS(EObject context, UnlimitedNaturalLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
