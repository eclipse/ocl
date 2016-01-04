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
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public abstract class AbstractBaseSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private BaseGrammarAccess grammarAccess;
	
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
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     referredElement=[NamedElement|UnrestrictedName]
	 */
	protected void sequence_FirstPathElementCS(EObject context, PathElementCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lowerBound=LOWER upperBound=UPPER?)
	 */
	protected void sequence_MultiplicityBoundsCS(EObject context, MultiplicityBoundsCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lowerBound=LOWER upperBound=UPPER? isNullFree?='|1'?)
	 */
	protected void sequence_MultiplicityBoundsCS_MultiplicityCS(EObject context, MultiplicityBoundsCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((stringBounds='*' | stringBounds='+' | stringBounds='?') isNullFree?='|1'?)
	 */
	protected void sequence_MultiplicityCS_MultiplicityStringCS(EObject context, MultiplicityStringCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (stringBounds='*' | stringBounds='+' | stringBounds='?')
	 */
	protected void sequence_MultiplicityStringCS(EObject context, MultiplicityStringCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     referredElement=[NamedElement|UnreservedName]
	 */
	protected void sequence_NextPathElementCS(EObject context, PathElementCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedPathElements+=FirstPathElementCS ownedPathElements+=NextPathElementCS*)
	 */
	protected void sequence_PathNameCS(EObject context, PathNameCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedSubstitutions+=TemplateParameterSubstitutionCS ownedSubstitutions+=TemplateParameterSubstitutionCS* ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TemplateBindingCS(EObject context, TemplateBindingCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedActualParameter=TypeRefCS
	 */
	protected void sequence_TemplateParameterSubstitutionCS(EObject context, TemplateParameterSubstitutionCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedParameters+=TypeParameterCS ownedParameters+=TypeParameterCS*)
	 */
	protected void sequence_TemplateSignatureCS(EObject context, TemplateSignatureCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName (ownedExtends+=TypedRefCS ownedExtends+=TypedRefCS*)?)
	 */
	protected void sequence_TypeParameterCS(EObject context, TypeParameterCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedPathName=PathNameCS ownedBinding=TemplateBindingCS?)
	 */
	protected void sequence_TypedTypeRefCS(EObject context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedExtends=TypedRefCS?)
	 */
	protected void sequence_WildcardTypeRefCS(EObject context, WildcardTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
