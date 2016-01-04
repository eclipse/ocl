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
package org.eclipse.ocl.xtext.markup.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.markup.services.MarkupGrammarAccess;
import org.eclipse.ocl.xtext.markupcs.BulletElement;
import org.eclipse.ocl.xtext.markupcs.FigureElement;
import org.eclipse.ocl.xtext.markupcs.FigureRefElement;
import org.eclipse.ocl.xtext.markupcs.FontElement;
import org.eclipse.ocl.xtext.markupcs.FootnoteElement;
import org.eclipse.ocl.xtext.markupcs.HeadingElement;
import org.eclipse.ocl.xtext.markupcs.Markup;
import org.eclipse.ocl.xtext.markupcs.MarkupPackage;
import org.eclipse.ocl.xtext.markupcs.NewLineElement;
import org.eclipse.ocl.xtext.markupcs.NullElement;
import org.eclipse.ocl.xtext.markupcs.OCLCodeElement;
import org.eclipse.ocl.xtext.markupcs.OCLEvalElement;
import org.eclipse.ocl.xtext.markupcs.OCLTextElement;
import org.eclipse.ocl.xtext.markupcs.TextElement;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public abstract class AbstractMarkupSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MarkupGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == MarkupPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MarkupPackage.BULLET_ELEMENT:
				sequence_BulletElement(context, (BulletElement) semanticObject); 
				return; 
			case MarkupPackage.FIGURE_ELEMENT:
				sequence_FigureElement(context, (FigureElement) semanticObject); 
				return; 
			case MarkupPackage.FIGURE_REF_ELEMENT:
				sequence_FigureRefElement(context, (FigureRefElement) semanticObject); 
				return; 
			case MarkupPackage.FONT_ELEMENT:
				sequence_FontElement(context, (FontElement) semanticObject); 
				return; 
			case MarkupPackage.FOOTNOTE_ELEMENT:
				sequence_FootnoteElement(context, (FootnoteElement) semanticObject); 
				return; 
			case MarkupPackage.HEADING_ELEMENT:
				sequence_HeadingElement(context, (HeadingElement) semanticObject); 
				return; 
			case MarkupPackage.MARKUP:
				sequence_Markup(context, (Markup) semanticObject); 
				return; 
			case MarkupPackage.NEW_LINE_ELEMENT:
				sequence_NewLineElement(context, (NewLineElement) semanticObject); 
				return; 
			case MarkupPackage.NULL_ELEMENT:
				sequence_NullElement(context, (NullElement) semanticObject); 
				return; 
			case MarkupPackage.OCL_CODE_ELEMENT:
				sequence_OCLCodeElement(context, (OCLCodeElement) semanticObject); 
				return; 
			case MarkupPackage.OCL_EVAL_ELEMENT:
				sequence_OCLEvalElement(context, (OCLEvalElement) semanticObject); 
				return; 
			case MarkupPackage.OCL_TEXT_ELEMENT:
				sequence_OCLTextElement(context, (OCLTextElement) semanticObject); 
				return; 
			case MarkupPackage.TEXT_ELEMENT:
				sequence_TextElement(context, (TextElement) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (level=INT? elements+=MarkupElement*)
	 */
	protected void sequence_BulletElement(EObject context, BulletElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (def=ID? src=STRING (alt=STRING (requiredWidth=INT requiredHeight=INT?)?)?)
	 */
	protected void sequence_FigureElement(EObject context, FigureElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ref=[FigureElement|ID]
	 */
	protected void sequence_FigureRefElement(EObject context, FigureRefElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((font='b' | font='e') elements+=MarkupElement*)
	 */
	protected void sequence_FontElement(EObject context, FontElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (elements+=MarkupElement*)
	 */
	protected void sequence_FootnoteElement(EObject context, FootnoteElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (level=INT? elements+=MarkupElement*)
	 */
	protected void sequence_HeadingElement(EObject context, HeadingElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     elements+=MarkupElement*
	 */
	protected void sequence_Markup(EObject context, Markup semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     text=NL
	 */
	protected void sequence_NewLineElement(EObject context, NewLineElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (elements+=MarkupElement*)
	 */
	protected void sequence_NullElement(EObject context, NullElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (elements+=MarkupElement*)
	 */
	protected void sequence_OCLCodeElement(EObject context, OCLCodeElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (elements+=MarkupElement*)
	 */
	protected void sequence_OCLEvalElement(EObject context, OCLEvalElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (elements+=MarkupElement*)
	 */
	protected void sequence_OCLTextElement(EObject context, OCLTextElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             text+=ID | 
	 *             text+=WORD | 
	 *             text+=INT | 
	 *             text+=WS | 
	 *             text+=':' | 
	 *             text+='#' | 
	 *             text+=','
	 *         )+ | 
	 *         text+=MarkupKeyword
	 *     )
	 */
	protected void sequence_TextElement(EObject context, TextElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
