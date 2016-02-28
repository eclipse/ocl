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
package org.eclipse.ocl.xtext.base.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.xtext.Action;
//import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
//import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractBaseSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private BaseGrammarAccess grammarAccess;
	
	protected EObject createContext(EObject context, EObject semanticObject) {
		return context;
	}
	
	protected SequenceFeeder createSequencerFeeder(EObject createContext, EObject semanticObject) {
		// TODO Auto-generated method stub
		return null;
	}
	
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
				else break;
			case BaseCSPackage.PATH_NAME_CS:
				sequence_PathNameCS(context, (PathNameCS) semanticObject); 
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
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     FirstPathElementCS returns PathElementCS
	 *
	 * Constraint:
	 *     referredElement=[NamedElement|UnrestrictedName]
	 */
	protected void sequence_FirstPathElementCS(EObject context, PathElementCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1(), semanticObject.getReferredElement());
		feeder.finish();
	}

	@Deprecated
	protected void sequence_FirstPathElementCS2(EObject context, PathElementCS semanticObject) {
		sequence_FirstPathElementCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     MultiplicityBoundsCS returns MultiplicityBoundsCS
	 *
	 * Constraint:
	 *     (lowerBound=LOWER upperBound=UPPER?)
	 */
	protected void sequence_MultiplicityBoundsCS(EObject context, MultiplicityBoundsCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_MultiplicityBoundsCS2(EObject context, MultiplicityBoundsCS semanticObject) {
		sequence_MultiplicityBoundsCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     MultiplicityCS returns MultiplicityBoundsCS
	 *
	 * Constraint:
	 *     (lowerBound=LOWER upperBound=UPPER? isNullFree?='|1'?)
	 */
	protected void sequence_MultiplicityBoundsCS_MultiplicityCS(EObject context, MultiplicityBoundsCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_MultiplicityBoundsCS_MultiplicityCS2(EObject context, MultiplicityBoundsCS semanticObject) {
		sequence_MultiplicityBoundsCS_MultiplicityCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     MultiplicityCS returns MultiplicityStringCS
	 *
	 * Constraint:
	 *     ((stringBounds='*' | stringBounds='+' | stringBounds='?') isNullFree?='|1'?)
	 */
	protected void sequence_MultiplicityCS_MultiplicityStringCS(EObject context, MultiplicityStringCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_MultiplicityCS_MultiplicityStringCS2(EObject context, MultiplicityStringCS semanticObject) {
		sequence_MultiplicityCS_MultiplicityStringCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     MultiplicityStringCS returns MultiplicityStringCS
	 *
	 * Constraint:
	 *     (stringBounds='*' | stringBounds='+' | stringBounds='?')
	 */
	protected void sequence_MultiplicityStringCS(EObject context, MultiplicityStringCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_MultiplicityStringCS2(EObject context, MultiplicityStringCS semanticObject) {
		sequence_MultiplicityStringCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     NextPathElementCS returns PathElementCS
	 *
	 * Constraint:
	 *     referredElement=[NamedElement|UnreservedName]
	 */
	protected void sequence_NextPathElementCS(EObject context, PathElementCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1(), semanticObject.getReferredElement());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_NextPathElementCS2(EObject context, PathElementCS semanticObject) {
		sequence_NextPathElementCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     PathNameCS returns PathNameCS
	 *
	 * Constraint:
	 *     (ownedPathElements+=FirstPathElementCS ownedPathElements+=NextPathElementCS*)
	 */
	protected void sequence_PathNameCS(EObject context, PathNameCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_PathNameCS2(EObject context, PathNameCS semanticObject) {
		sequence_PathNameCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TemplateBindingCS returns TemplateBindingCS
	 *
	 * Constraint:
	 *     (ownedSubstitutions+=TemplateParameterSubstitutionCS ownedSubstitutions+=TemplateParameterSubstitutionCS* ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TemplateBindingCS(EObject context, TemplateBindingCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_TemplateBindingCS2(EObject context, TemplateBindingCS semanticObject) {
		sequence_TemplateBindingCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TemplateParameterSubstitutionCS returns TemplateParameterSubstitutionCS
	 *
	 * Constraint:
	 *     ownedActualParameter=TypeRefCS
	 */
	protected void sequence_TemplateParameterSubstitutionCS(EObject context, TemplateParameterSubstitutionCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER));
		}
		SequenceFeeder feeder = createSequencerFeeder(createContext(context, semanticObject), semanticObject);
		feeder.accept(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0(), semanticObject.getOwnedActualParameter());
		feeder.finish();
	}

	@Deprecated
	protected void sequence_TemplateParameterSubstitutionCS2(EObject context, TemplateParameterSubstitutionCS semanticObject) {
		sequence_TemplateParameterSubstitutionCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TemplateSignatureCS returns TemplateSignatureCS
	 *
	 * Constraint:
	 *     (ownedParameters+=TypeParameterCS ownedParameters+=TypeParameterCS*)
	 */
	protected void sequence_TemplateSignatureCS(EObject context, TemplateSignatureCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_TemplateSignatureCS2(EObject context, TemplateSignatureCS semanticObject) {
		sequence_TemplateSignatureCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeParameterCS returns TypeParameterCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName (ownedExtends+=TypedRefCS ownedExtends+=TypedRefCS*)?)
	 */
	protected void sequence_TypeParameterCS(EObject context, TypeParameterCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_TypeParameterCS2(EObject context, TypeParameterCS semanticObject) {
		sequence_TypeParameterCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeRefCS returns TypedTypeRefCS
	 *     TypedRefCS returns TypedTypeRefCS
	 *     TypedTypeRefCS returns TypedTypeRefCS
	 *
	 * Constraint:
	 *     (ownedPathName=PathNameCS ownedBinding=TemplateBindingCS?)
	 */
	protected void sequence_TypedTypeRefCS(EObject context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_TypedTypeRefCS2(EObject context, TypedTypeRefCS semanticObject) {
		sequence_TypedTypeRefCS(context, semanticObject);
	}
	
	/**
	 * Contexts:
	 *     TypeRefCS returns WildcardTypeRefCS
	 *     WildcardTypeRefCS returns WildcardTypeRefCS
	 *
	 * Constraint:
	 *     ownedExtends=TypedRefCS?
	 */
	protected void sequence_WildcardTypeRefCS(EObject context, WildcardTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_WildcardTypeRefCS2(EObject context, WildcardTypeRefCS semanticObject) {
		sequence_WildcardTypeRefCS(context, semanticObject);
	}
	
}
