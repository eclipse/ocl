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
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
//import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractEssentialOCLSemanticSequencer extends BaseSemanticSequencer {

	@Inject
	private EssentialOCLGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		EObject rule = context;
		EObject action = context;
//		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == BaseCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case BaseCSPackage.MULTIPLICITY_BOUNDS_CS:
				if (rule == grammarAccess.getMultiplicityBoundsCSRule()) {
					sequence_MultiplicityBoundsCS(context, (MultiplicityBoundsCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMultiplicityCSRule()) {
					sequence_MultiplicityBoundsCS_MultiplicityCS(context, (MultiplicityBoundsCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.MULTIPLICITY_STRING_CS:
				if (rule == grammarAccess.getMultiplicityCSRule()) {
					sequence_MultiplicityCS_MultiplicityStringCS(context, (MultiplicityStringCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMultiplicityStringCSRule()) {
					sequence_MultiplicityStringCS(context, (MultiplicityStringCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PATH_ELEMENT_CS:
				if (rule == grammarAccess.getFirstPathElementCSRule()) {
					sequence_FirstPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNextPathElementCSRule()) {
					sequence_NextPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getURIFirstPathElementCSRule()) {
					sequence_URIFirstPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PATH_ELEMENT_WITH_URICS:
				sequence_URIFirstPathElementCS(context, (PathElementWithURICS) semanticObject); 
				return; 
			case BaseCSPackage.PATH_NAME_CS:
				if (rule == grammarAccess.getPathNameCSRule()) {
					sequence_PathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getURIPathNameCSRule()) {
					sequence_URIPathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PRIMITIVE_TYPE_REF_CS:
				if (rule == grammarAccess.getPrimitiveTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()) {
					sequence_PrimitiveTypeCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_PrimitiveTypeCS_TypeExpCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
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
				if (rule == grammarAccess.getTupleTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()) {
					sequence_TupleTypeCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_TupleTypeCS_TypeExpCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
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
		else if (epackage == EssentialOCLCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
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
				if (rule == grammarAccess.getCollectionPatternCSRule()) {
					sequence_CollectionPatternCS(context, (CollectionPatternCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_CollectionPatternCS_TypeExpCS(context, (CollectionPatternCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.COLLECTION_TYPE_CS:
				if (rule == grammarAccess.getCollectionTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()) {
					sequence_CollectionTypeCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_CollectionTypeCS_TypeExpCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
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
				if (rule == grammarAccess.getMapTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()) {
					sequence_MapTypeCS(context, (MapTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_MapTypeCS_TypeExpCS(context, (MapTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_MapTypeCS_TypeLiteralWithMultiplicityCS(context, (MapTypeCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NAME_EXP_CS:
				sequence_NameExpCS(context, (NameExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.NAVIGATING_ARG_CS:
				if (rule == grammarAccess.getNavigatingArgCSRule()) {
					sequence_NavigatingArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNavigatingBarArgCSRule()) {
					sequence_NavigatingBarArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNavigatingCommaArgCSRule()) {
					sequence_NavigatingCommaArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNavigatingSemiArgCSRule()) {
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
				if (rule == grammarAccess.getPrefixedLetExpCSRule()) {
					sequence_PrefixedLetExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExpCSRule()
						|| rule == grammarAccess.getNavigatingArgExpCSRule()) {
					sequence_PrefixedLetExpCS_PrefixedPrimaryExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0()
						|| rule == grammarAccess.getPrefixedPrimaryExpCSRule()) {
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
				if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_TypeExpCS_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeNameExpCSRule()) {
					sequence_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
				sequence_UnlimitedNaturalLiteralExpCS(context, (UnlimitedNaturalLiteralExpCS) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns BooleanLiteralExpCS
	 *     BooleanLiteralExpCS returns BooleanLiteralExpCS
	 *     ExpCS returns BooleanLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns BooleanLiteralExpCS
	 *     PrefixedPrimaryExpCS returns BooleanLiteralExpCS
	 *     PrimaryExpCS returns BooleanLiteralExpCS
	 *     NavigatingArgExpCS returns BooleanLiteralExpCS
	 *
	 * Constraint:
	 *     (symbol='true' | symbol='false')
	 */
	protected void sequence_BooleanLiteralExpCS(EObject context, BooleanLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_BooleanLiteralExpCS2(EObject context, BooleanLiteralExpCS semanticObject) {
		sequence_BooleanLiteralExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     CollectionLiteralExpCS returns CollectionLiteralExpCS
	 *     ExpCS returns CollectionLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns CollectionLiteralExpCS
	 *     PrefixedPrimaryExpCS returns CollectionLiteralExpCS
	 *     PrimaryExpCS returns CollectionLiteralExpCS
	 *     NavigatingArgExpCS returns CollectionLiteralExpCS
	 *
	 * Constraint:
	 *     (ownedType=CollectionTypeCS (ownedParts+=CollectionLiteralPartCS ownedParts+=CollectionLiteralPartCS*)?)
	 */
	protected void sequence_CollectionLiteralExpCS(EObject context, CollectionLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_CollectionLiteralExpCS2(EObject context, CollectionLiteralExpCS semanticObject) {
		sequence_CollectionLiteralExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     CollectionLiteralPartCS returns CollectionLiteralPartCS
	 *
	 * Constraint:
	 *     ((ownedExpression=ExpCS ownedLastExpression=ExpCS?) | ownedExpression=PatternExpCS)
	 */
	protected void sequence_CollectionLiteralPartCS(EObject context, CollectionLiteralPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_CollectionLiteralPartCS2(EObject context, CollectionLiteralPartCS semanticObject) {
		sequence_CollectionLiteralPartCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     CollectionPatternCS returns CollectionPatternCS
	 *
	 * Constraint:
	 *     (ownedType=CollectionTypeCS (ownedParts+=PatternExpCS ownedParts+=PatternExpCS* restVariableName=Identifier)?)
	 */
	protected void sequence_CollectionPatternCS(EObject context, CollectionPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_CollectionPatternCS2(EObject context, CollectionPatternCS semanticObject) {
		sequence_CollectionPatternCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeExpCS returns CollectionPatternCS
	 *
	 * Constraint:
	 *     (ownedType=CollectionTypeCS (ownedParts+=PatternExpCS ownedParts+=PatternExpCS* restVariableName=Identifier)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_CollectionPatternCS_TypeExpCS(EObject context, CollectionPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_CollectionPatternCS_TypeExpCS2(EObject context, CollectionPatternCS semanticObject) {
		sequence_CollectionPatternCS_TypeExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     CollectionTypeCS returns CollectionTypeCS
	 *     TypeLiteralCS returns CollectionTypeCS
	 *
	 * Constraint:
	 *     (name=CollectionTypeIdentifier ownedType=TypeExpCS?)
	 */
	protected void sequence_CollectionTypeCS(EObject context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_CollectionTypeCS2(EObject context, CollectionTypeCS semanticObject) {
		sequence_CollectionTypeCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeExpCS returns CollectionTypeCS
	 *
	 * Constraint:
	 *     (name=CollectionTypeIdentifier ownedType=TypeExpCS? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_CollectionTypeCS_TypeExpCS(EObject context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_CollectionTypeCS_TypeExpCS2(EObject context, CollectionTypeCS semanticObject) {
		sequence_CollectionTypeCS_TypeExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeLiteralWithMultiplicityCS returns CollectionTypeCS
	 *
	 * Constraint:
	 *     (name=CollectionTypeIdentifier ownedType=TypeExpCS? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS(EObject context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS2(EObject context, CollectionTypeCS semanticObject) {
		sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     CurlyBracketedClauseCS returns CurlyBracketedClauseCS
	 *
	 * Constraint:
	 *     ((ownedParts+=ShadowPartCS ownedParts+=ShadowPartCS*) | value=StringLiteral)?
	 */
	protected void sequence_CurlyBracketedClauseCS(EObject context, CurlyBracketedClauseCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_CurlyBracketedClauseCS2(EObject context, CurlyBracketedClauseCS semanticObject) {
		sequence_CurlyBracketedClauseCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     ElseIfThenExpCS returns IfThenExpCS
	 *
	 * Constraint:
	 *     (ownedCondition=ExpCS ownedThenExpression=ExpCS)
	 */
	protected void sequence_ElseIfThenExpCS(EObject context, IfThenExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION));
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0(), semanticObject.getOwnedCondition());
		feeder.accept(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0(), semanticObject.getOwnedThenExpression());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_ElseIfThenExpCS2(EObject context, IfThenExpCS semanticObject) {
		sequence_ElseIfThenExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     ExpCS returns InfixExpCS
	 *     NavigatingArgExpCS returns InfixExpCS
	 *
	 * Constraint:
	 *     (ownedLeft=ExpCS_InfixExpCS_0_1_0 name=BinaryOperatorName ownedRight=ExpCS)
	 */
	protected void sequence_ExpCS(EObject context, InfixExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT));
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0(), semanticObject.getOwnedLeft());
		feeder.accept(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0(), semanticObject.getOwnedRight());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_ExpCS2(EObject context, InfixExpCS semanticObject) {
		sequence_ExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     ExpCS returns IfExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns IfExpCS
	 *     PrefixedPrimaryExpCS returns IfExpCS
	 *     PrimaryExpCS returns IfExpCS
	 *     NavigatingArgExpCS returns IfExpCS
	 *     IfExpCS returns IfExpCS
	 *
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
	
	@Deprecated
	protected void sequence_IfExpCS2(EObject context, IfExpCS semanticObject) {
		sequence_IfExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns InvalidLiteralExpCS
	 *     InvalidLiteralExpCS returns InvalidLiteralExpCS
	 *     ExpCS returns InvalidLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns InvalidLiteralExpCS
	 *     PrefixedPrimaryExpCS returns InvalidLiteralExpCS
	 *     PrimaryExpCS returns InvalidLiteralExpCS
	 *     NavigatingArgExpCS returns InvalidLiteralExpCS
	 *
	 * Constraint:
	 *     {InvalidLiteralExpCS}
	 */
	protected void sequence_InvalidLiteralExpCS(EObject context, InvalidLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_InvalidLiteralExpCS2(EObject context, InvalidLiteralExpCS semanticObject) {
		sequence_InvalidLiteralExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     LambdaLiteralExpCS returns LambdaLiteralExpCS
	 *     ExpCS returns LambdaLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns LambdaLiteralExpCS
	 *     PrefixedPrimaryExpCS returns LambdaLiteralExpCS
	 *     PrimaryExpCS returns LambdaLiteralExpCS
	 *     NavigatingArgExpCS returns LambdaLiteralExpCS
	 *
	 * Constraint:
	 *     ownedExpressionCS=ExpCS
	 */
	protected void sequence_LambdaLiteralExpCS(EObject context, LambdaLiteralExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0(), semanticObject.getOwnedExpressionCS());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_LambdaLiteralExpCS2(EObject context, LambdaLiteralExpCS semanticObject) {
		sequence_LambdaLiteralExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     ExpCS returns LetExpCS
	 *     PrefixedLetExpCS returns LetExpCS
	 *     NavigatingArgExpCS returns LetExpCS
	 *     LetExpCS returns LetExpCS
	 *
	 * Constraint:
	 *     (ownedVariables+=LetVariableCS ownedVariables+=LetVariableCS* ownedInExpression=ExpCS)
	 */
	protected void sequence_LetExpCS(EObject context, LetExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_LetExpCS2(EObject context, LetExpCS semanticObject) {
		sequence_LetExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     LetVariableCS returns LetVariableCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? ownedType=TypeExpCS? ownedInitExpression=ExpCS)
	 */
	protected void sequence_LetVariableCS(EObject context, LetVariableCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_LetVariableCS2(EObject context, LetVariableCS semanticObject) {
		sequence_LetVariableCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     MapLiteralExpCS returns MapLiteralExpCS
	 *     ExpCS returns MapLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns MapLiteralExpCS
	 *     PrefixedPrimaryExpCS returns MapLiteralExpCS
	 *     PrimaryExpCS returns MapLiteralExpCS
	 *     NavigatingArgExpCS returns MapLiteralExpCS
	 *
	 * Constraint:
	 *     (ownedType=MapTypeCS (ownedParts+=MapLiteralPartCS ownedParts+=MapLiteralPartCS*)?)
	 */
	protected void sequence_MapLiteralExpCS(EObject context, MapLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_MapLiteralExpCS2(EObject context, MapLiteralExpCS semanticObject) {
		sequence_MapLiteralExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     MapLiteralPartCS returns MapLiteralPartCS
	 *
	 * Constraint:
	 *     (ownedKey=ExpCS ownedValue=ExpCS)
	 */
	protected void sequence_MapLiteralPartCS(EObject context, MapLiteralPartCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY));
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0(), semanticObject.getOwnedKey());
		feeder.accept(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0(), semanticObject.getOwnedValue());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_MapLiteralPartCS2(EObject context, MapLiteralPartCS semanticObject) {
		sequence_MapLiteralPartCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     MapTypeCS returns MapTypeCS
	 *     TypeLiteralCS returns MapTypeCS
	 *
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)?)
	 */
	protected void sequence_MapTypeCS(EObject context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_MapTypeCS2(EObject context, MapTypeCS semanticObject) {
		sequence_MapTypeCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeExpCS returns MapTypeCS
	 *
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_MapTypeCS_TypeExpCS(EObject context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_MapTypeCS_TypeExpCS2(EObject context, MapTypeCS semanticObject) {
		sequence_MapTypeCS_TypeExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeLiteralWithMultiplicityCS returns MapTypeCS
	 *
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_MapTypeCS_TypeLiteralWithMultiplicityCS(EObject context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_MapTypeCS_TypeLiteralWithMultiplicityCS2(EObject context, MapTypeCS semanticObject) {
		sequence_MapTypeCS_TypeLiteralWithMultiplicityCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     Model returns ContextCS
	 *
	 * Constraint:
	 *     ownedExpression=ExpCS
	 */
	protected void sequence_Model(EObject context, ContextCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getModelAccess().getOwnedExpressionExpCSParserRuleCall_0(), semanticObject.getOwnedExpression());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_Model2(EObject context, ContextCS semanticObject) {
		sequence_Model(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     ExpCS returns NameExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns NameExpCS
	 *     PrefixedPrimaryExpCS returns NameExpCS
	 *     PrimaryExpCS returns NameExpCS
	 *     NameExpCS returns NameExpCS
	 *     NavigatingArgExpCS returns NameExpCS
	 *
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
	
	@Deprecated
	protected void sequence_NameExpCS2(EObject context, NameExpCS semanticObject) {
		sequence_NameExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     NavigatingArgCS returns NavigatingArgCS
	 *
	 * Constraint:
	 *     ((ownedNameExpression=NavigatingArgExpCS ((ownedType=TypeExpCS ownedInitExpression=ExpCS?) | ownedInitExpression=ExpCS)?) | ownedType=TypeExpCS)
	 */
	protected void sequence_NavigatingArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_NavigatingArgCS2(EObject context, NavigatingArgCS semanticObject) {
		sequence_NavigatingArgCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     NavigatingBarArgCS returns NavigatingArgCS
	 *
	 * Constraint:
	 *     (prefix='|' ownedNameExpression=NavigatingArgExpCS (ownedType=TypeExpCS ownedInitExpression=ExpCS?)?)
	 */
	protected void sequence_NavigatingBarArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_NavigatingBarArgCS2(EObject context, NavigatingArgCS semanticObject) {
		sequence_NavigatingBarArgCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     NavigatingCommaArgCS returns NavigatingArgCS
	 *
	 * Constraint:
	 *     (prefix=',' ownedNameExpression=NavigatingArgExpCS ((ownedType=TypeExpCS ownedInitExpression=ExpCS?) | ownedInitExpression=ExpCS)?)
	 */
	protected void sequence_NavigatingCommaArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_NavigatingCommaArgCS2(EObject context, NavigatingArgCS semanticObject) {
		sequence_NavigatingCommaArgCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     NavigatingSemiArgCS returns NavigatingArgCS
	 *
	 * Constraint:
	 *     (prefix=';' ownedNameExpression=NavigatingArgExpCS (ownedType=TypeExpCS ownedInitExpression=ExpCS?)?)
	 */
	protected void sequence_NavigatingSemiArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_NavigatingSemiArgCS2(EObject context, NavigatingArgCS semanticObject) {
		sequence_NavigatingSemiArgCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     ExpCS returns NestedExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns NestedExpCS
	 *     PrefixedPrimaryExpCS returns NestedExpCS
	 *     PrimaryExpCS returns NestedExpCS
	 *     NavigatingArgExpCS returns NestedExpCS
	 *     NestedExpCS returns NestedExpCS
	 *
	 * Constraint:
	 *     ownedExpression=ExpCS
	 */
	protected void sequence_NestedExpCS(EObject context, NestedExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0(), semanticObject.getOwnedExpression());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_NestedExpCS2(EObject context, NestedExpCS semanticObject) {
		sequence_NestedExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns NullLiteralExpCS
	 *     NullLiteralExpCS returns NullLiteralExpCS
	 *     ExpCS returns NullLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns NullLiteralExpCS
	 *     PrefixedPrimaryExpCS returns NullLiteralExpCS
	 *     PrimaryExpCS returns NullLiteralExpCS
	 *     NavigatingArgExpCS returns NullLiteralExpCS
	 *
	 * Constraint:
	 *     {NullLiteralExpCS}
	 */
	protected void sequence_NullLiteralExpCS(EObject context, NullLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_NullLiteralExpCS2(EObject context, NullLiteralExpCS semanticObject) {
		sequence_NullLiteralExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns NumberLiteralExpCS
	 *     NumberLiteralExpCS returns NumberLiteralExpCS
	 *     ExpCS returns NumberLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns NumberLiteralExpCS
	 *     PrefixedPrimaryExpCS returns NumberLiteralExpCS
	 *     PrimaryExpCS returns NumberLiteralExpCS
	 *     NavigatingArgExpCS returns NumberLiteralExpCS
	 *
	 * Constraint:
	 *     symbol=NUMBER_LITERAL
	 */
	protected void sequence_NumberLiteralExpCS(EObject context, NumberLiteralExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0(), semanticObject.getSymbol());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_NumberLiteralExpCS2(EObject context, NumberLiteralExpCS semanticObject) {
		sequence_NumberLiteralExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     PatternExpCS returns PatternExpCS
	 *
	 * Constraint:
	 *     (patternVariableName=UnrestrictedName? ownedPatternType=TypeExpCS)
	 */
	protected void sequence_PatternExpCS(EObject context, PatternExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_PatternExpCS2(EObject context, PatternExpCS semanticObject) {
		sequence_PatternExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     PrefixedLetExpCS returns PrefixExpCS
	 *
	 * Constraint:
	 *     (name=UnaryOperatorName ownedRight=PrefixedLetExpCS)
	 */
	protected void sequence_PrefixedLetExpCS(EObject context, PrefixExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0(), semanticObject.getOwnedRight());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_PrefixedLetExpCS2(EObject context, PrefixExpCS semanticObject) {
		sequence_PrefixedLetExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     ExpCS returns PrefixExpCS
	 *     NavigatingArgExpCS returns PrefixExpCS
	 *
	 * Constraint:
	 *     ((name=UnaryOperatorName ownedRight=PrefixedLetExpCS) | (name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS))
	 */
	protected void sequence_PrefixedLetExpCS_PrefixedPrimaryExpCS(EObject context, PrefixExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_PrefixedLetExpCS_PrefixedPrimaryExpCS2(EObject context, PrefixExpCS semanticObject) {
		sequence_PrefixedLetExpCS_PrefixedPrimaryExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     ExpCS.InfixExpCS_0_1_0 returns PrefixExpCS
	 *     PrefixedPrimaryExpCS returns PrefixExpCS
	 *
	 * Constraint:
	 *     (name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS)
	 */
	protected void sequence_PrefixedPrimaryExpCS(EObject context, PrefixExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0(), semanticObject.getOwnedRight());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_PrefixedPrimaryExpCS2(EObject context, PrefixExpCS semanticObject) {
		sequence_PrefixedPrimaryExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     PrimitiveTypeCS returns PrimitiveTypeRefCS
	 *     TypeLiteralCS returns PrimitiveTypeRefCS
	 *
	 * Constraint:
	 *     name=PrimitiveTypeIdentifier
	 */
	protected void sequence_PrimitiveTypeCS(EObject context, PrimitiveTypeRefCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_PrimitiveTypeCS2(EObject context, PrimitiveTypeRefCS semanticObject) {
		sequence_PrimitiveTypeCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeExpCS returns PrimitiveTypeRefCS
	 *
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_PrimitiveTypeCS_TypeExpCS(EObject context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_PrimitiveTypeCS_TypeExpCS2(EObject context, PrimitiveTypeRefCS semanticObject) {
		sequence_PrimitiveTypeCS_TypeExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeLiteralWithMultiplicityCS returns PrimitiveTypeRefCS
	 *
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS(EObject context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS2(EObject context, PrimitiveTypeRefCS semanticObject) {
		sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     RoundBracketedClauseCS returns RoundBracketedClauseCS
	 *
	 * Constraint:
	 *     (
	 *         ownedArguments+=NavigatingArgCS 
	 *         ownedArguments+=NavigatingCommaArgCS* 
	 *         (ownedArguments+=NavigatingSemiArgCS ownedArguments+=NavigatingCommaArgCS*)? 
	 *         (ownedArguments+=NavigatingBarArgCS ownedArguments+=NavigatingCommaArgCS*)*
	 *     )?
	 */
	protected void sequence_RoundBracketedClauseCS(EObject context, RoundBracketedClauseCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_RoundBracketedClauseCS2(EObject context, RoundBracketedClauseCS semanticObject) {
		sequence_RoundBracketedClauseCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     ExpCS returns SelfExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns SelfExpCS
	 *     PrefixedPrimaryExpCS returns SelfExpCS
	 *     PrimaryExpCS returns SelfExpCS
	 *     NavigatingArgExpCS returns SelfExpCS
	 *     SelfExpCS returns SelfExpCS
	 *
	 * Constraint:
	 *     {SelfExpCS}
	 */
	protected void sequence_SelfExpCS(EObject context, SelfExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_SelfExpCS2(EObject context, SelfExpCS semanticObject) {
		sequence_SelfExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     ShadowPartCS returns ShadowPartCS
	 *
	 * Constraint:
	 *     (referredProperty=[Property|UnrestrictedName] (ownedInitExpression=ExpCS | ownedInitExpression=PatternExpCS))
	 */
	protected void sequence_ShadowPartCS(EObject context, ShadowPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_ShadowPartCS2(EObject context, ShadowPartCS semanticObject) {
		sequence_ShadowPartCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     SquareBracketedClauseCS returns SquareBracketedClauseCS
	 *
	 * Constraint:
	 *     (ownedTerms+=ExpCS ownedTerms+=ExpCS*)
	 */
	protected void sequence_SquareBracketedClauseCS(EObject context, SquareBracketedClauseCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_SquareBracketedClauseCS2(EObject context, SquareBracketedClauseCS semanticObject) {
		sequence_SquareBracketedClauseCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns StringLiteralExpCS
	 *     StringLiteralExpCS returns StringLiteralExpCS
	 *     ExpCS returns StringLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns StringLiteralExpCS
	 *     PrefixedPrimaryExpCS returns StringLiteralExpCS
	 *     PrimaryExpCS returns StringLiteralExpCS
	 *     NavigatingArgExpCS returns StringLiteralExpCS
	 *
	 * Constraint:
	 *     segments+=StringLiteral+
	 */
	protected void sequence_StringLiteralExpCS(EObject context, StringLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_StringLiteralExpCS2(EObject context, StringLiteralExpCS semanticObject) {
		sequence_StringLiteralExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TupleLiteralExpCS returns TupleLiteralExpCS
	 *     ExpCS returns TupleLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns TupleLiteralExpCS
	 *     PrefixedPrimaryExpCS returns TupleLiteralExpCS
	 *     PrimaryExpCS returns TupleLiteralExpCS
	 *     NavigatingArgExpCS returns TupleLiteralExpCS
	 *
	 * Constraint:
	 *     (ownedParts+=TupleLiteralPartCS ownedParts+=TupleLiteralPartCS*)
	 */
	protected void sequence_TupleLiteralExpCS(EObject context, TupleLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_TupleLiteralExpCS2(EObject context, TupleLiteralExpCS semanticObject) {
		sequence_TupleLiteralExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TupleLiteralPartCS returns TupleLiteralPartCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS? ownedInitExpression=ExpCS)
	 */
	protected void sequence_TupleLiteralPartCS(EObject context, TupleLiteralPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_TupleLiteralPartCS2(EObject context, TupleLiteralPartCS semanticObject) {
		sequence_TupleLiteralPartCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TuplePartCS returns TuplePartCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS)
	 */
	protected void sequence_TuplePartCS(EObject context, TuplePartCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0(), semanticObject.getOwnedType());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_TuplePartCS2(EObject context, TuplePartCS semanticObject) {
		sequence_TuplePartCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TupleTypeCS returns TupleTypeCS
	 *     TypeLiteralCS returns TupleTypeCS
	 *
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)?)
	 */
	protected void sequence_TupleTypeCS(EObject context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_TupleTypeCS2(EObject context, TupleTypeCS semanticObject) {
		sequence_TupleTypeCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeExpCS returns TupleTypeCS
	 *
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TupleTypeCS_TypeExpCS(EObject context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_TupleTypeCS_TypeExpCS2(EObject context, TupleTypeCS semanticObject) {
		sequence_TupleTypeCS_TypeExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeLiteralWithMultiplicityCS returns TupleTypeCS
	 *
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS(EObject context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS2(EObject context, TupleTypeCS semanticObject) {
		sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeExpCS returns TypeNameExpCS
	 *
	 * Constraint:
	 *     (ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ownedPatternGuard=ExpCS?)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TypeExpCS_TypeNameExpCS(EObject context, TypeNameExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_TypeExpCS_TypeNameExpCS2(EObject context, TypeNameExpCS semanticObject) {
		sequence_TypeExpCS_TypeNameExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeLiteralExpCS returns TypeLiteralExpCS
	 *     ExpCS returns TypeLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns TypeLiteralExpCS
	 *     PrefixedPrimaryExpCS returns TypeLiteralExpCS
	 *     PrimaryExpCS returns TypeLiteralExpCS
	 *     NavigatingArgExpCS returns TypeLiteralExpCS
	 *
	 * Constraint:
	 *     ownedType=TypeLiteralWithMultiplicityCS
	 */
	protected void sequence_TypeLiteralExpCS(EObject context, TypeLiteralExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0(), semanticObject.getOwnedType());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_TypeLiteralExpCS2(EObject context, TypeLiteralExpCS semanticObject) {
		sequence_TypeLiteralExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeNameExpCS returns TypeNameExpCS
	 *
	 * Constraint:
	 *     (ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ownedPatternGuard=ExpCS?)?)
	 */
	protected void sequence_TypeNameExpCS(EObject context, TypeNameExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_TypeNameExpCS2(EObject context, TypeNameExpCS semanticObject) {
		sequence_TypeNameExpCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     URIFirstPathElementCS returns PathElementCS
	 *
	 * Constraint:
	 *     referredElement=[NamedElement|UnrestrictedName]
	 */
	protected void sequence_URIFirstPathElementCS(EObject context, PathElementCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_0_1(), semanticObject.getReferredElement());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_URIFirstPathElementCS2(EObject context, PathElementCS semanticObject) {
		sequence_URIFirstPathElementCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     URIFirstPathElementCS returns PathElementWithURICS
	 *
	 * Constraint:
	 *     referredElement=[Namespace|URI]
	 */
	protected void sequence_URIFirstPathElementCS(EObject context, PathElementWithURICS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceURIParserRuleCall_1_1_0_1(), semanticObject.getReferredElement());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_URIFirstPathElementCS2(EObject context, PathElementWithURICS semanticObject) {
		sequence_URIFirstPathElementCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     URIPathNameCS returns PathNameCS
	 *
	 * Constraint:
	 *     (ownedPathElements+=URIFirstPathElementCS ownedPathElements+=NextPathElementCS*)
	 */
	protected void sequence_URIPathNameCS(EObject context, PathNameCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_URIPathNameCS2(EObject context, PathNameCS semanticObject) {
		sequence_URIPathNameCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns UnlimitedNaturalLiteralExpCS
	 *     UnlimitedNaturalLiteralExpCS returns UnlimitedNaturalLiteralExpCS
	 *     ExpCS returns UnlimitedNaturalLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns UnlimitedNaturalLiteralExpCS
	 *     PrefixedPrimaryExpCS returns UnlimitedNaturalLiteralExpCS
	 *     PrimaryExpCS returns UnlimitedNaturalLiteralExpCS
	 *     NavigatingArgExpCS returns UnlimitedNaturalLiteralExpCS
	 *
	 * Constraint:
	 *     {UnlimitedNaturalLiteralExpCS}
	 */
	protected void sequence_UnlimitedNaturalLiteralExpCS(EObject context, UnlimitedNaturalLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_UnlimitedNaturalLiteralExpCS2(EObject context, UnlimitedNaturalLiteralExpCS semanticObject) {
		sequence_UnlimitedNaturalLiteralExpCS(context, semanticObject);
	}
	
}
