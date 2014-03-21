package org.eclipse.ocl.examples.xtext.markup.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.markup.BulletElement;
import org.eclipse.ocl.examples.xtext.markup.FigureElement;
import org.eclipse.ocl.examples.xtext.markup.FigureRefElement;
import org.eclipse.ocl.examples.xtext.markup.FontElement;
import org.eclipse.ocl.examples.xtext.markup.FootnoteElement;
import org.eclipse.ocl.examples.xtext.markup.HeadingElement;
import org.eclipse.ocl.examples.xtext.markup.Markup;
import org.eclipse.ocl.examples.xtext.markup.MarkupPackage;
import org.eclipse.ocl.examples.xtext.markup.NewLineElement;
import org.eclipse.ocl.examples.xtext.markup.NullElement;
import org.eclipse.ocl.examples.xtext.markup.OCLCodeElement;
import org.eclipse.ocl.examples.xtext.markup.OCLEvalElement;
import org.eclipse.ocl.examples.xtext.markup.OCLTextElement;
import org.eclipse.ocl.examples.xtext.markup.TextElement;
import org.eclipse.ocl.examples.xtext.markup.services.MarkupGrammarAccess;
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
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == MarkupPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MarkupPackage.BULLET_ELEMENT:
				if(context == grammarAccess.getBulletElementRule() ||
				   context == grammarAccess.getMarkupElementRule()) {
					sequence_BulletElement(context, (BulletElement) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.FIGURE_ELEMENT:
				if(context == grammarAccess.getFigureElementRule() ||
				   context == grammarAccess.getMarkupElementRule()) {
					sequence_FigureElement(context, (FigureElement) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.FIGURE_REF_ELEMENT:
				if(context == grammarAccess.getFigureRefElementRule() ||
				   context == grammarAccess.getMarkupElementRule()) {
					sequence_FigureRefElement(context, (FigureRefElement) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.FONT_ELEMENT:
				if(context == grammarAccess.getFontElementRule() ||
				   context == grammarAccess.getMarkupElementRule()) {
					sequence_FontElement(context, (FontElement) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.FOOTNOTE_ELEMENT:
				if(context == grammarAccess.getFootnoteElementRule() ||
				   context == grammarAccess.getMarkupElementRule()) {
					sequence_FootnoteElement(context, (FootnoteElement) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.HEADING_ELEMENT:
				if(context == grammarAccess.getHeadingElementRule() ||
				   context == grammarAccess.getMarkupElementRule()) {
					sequence_HeadingElement(context, (HeadingElement) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.MARKUP:
				if(context == grammarAccess.getMarkupRule()) {
					sequence_Markup(context, (Markup) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.NEW_LINE_ELEMENT:
				if(context == grammarAccess.getMarkupElementRule() ||
				   context == grammarAccess.getNewLineElementRule()) {
					sequence_NewLineElement(context, (NewLineElement) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.NULL_ELEMENT:
				if(context == grammarAccess.getMarkupElementRule() ||
				   context == grammarAccess.getNullElementRule()) {
					sequence_NullElement(context, (NullElement) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.OCL_CODE_ELEMENT:
				if(context == grammarAccess.getMarkupElementRule() ||
				   context == grammarAccess.getOCLCodeElementRule()) {
					sequence_OCLCodeElement(context, (OCLCodeElement) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.OCL_EVAL_ELEMENT:
				if(context == grammarAccess.getMarkupElementRule() ||
				   context == grammarAccess.getOCLEvalElementRule()) {
					sequence_OCLEvalElement(context, (OCLEvalElement) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.OCL_TEXT_ELEMENT:
				if(context == grammarAccess.getMarkupElementRule() ||
				   context == grammarAccess.getOCLTextElementRule()) {
					sequence_OCLTextElement(context, (OCLTextElement) semanticObject); 
					return; 
				}
				else break;
			case MarkupPackage.TEXT_ELEMENT:
				if(context == grammarAccess.getMarkupElementRule() ||
				   context == grammarAccess.getTextElementRule()) {
					sequence_TextElement(context, (TextElement) semanticObject); 
					return; 
				}
				else break;
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
