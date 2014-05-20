/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.markup.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.markup.*;
import org.eclipse.ocl.examples.xtext.markup.CompoundElement;
import org.eclipse.ocl.examples.xtext.markup.FigureElement;
import org.eclipse.ocl.examples.xtext.markup.FigureRefElement;
import org.eclipse.ocl.examples.xtext.markup.FontElement;
import org.eclipse.ocl.examples.xtext.markup.Markup;
import org.eclipse.ocl.examples.xtext.markup.MarkupElement;
import org.eclipse.ocl.examples.xtext.markup.MarkupFactory;
import org.eclipse.ocl.examples.xtext.markup.MarkupPackage;
import org.eclipse.ocl.examples.xtext.markup.NewLineElement;
import org.eclipse.ocl.examples.xtext.markup.TextElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MarkupFactoryImpl extends EFactoryImpl implements MarkupFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MarkupFactory init() {
		try {
			MarkupFactory theMarkupFactory = (MarkupFactory)EPackage.Registry.INSTANCE.getEFactory(MarkupPackage.eNS_URI);
			if (theMarkupFactory != null) {
				return theMarkupFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MarkupFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkupFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MarkupPackage.BULLET_ELEMENT: return createBulletElement();
			case MarkupPackage.COMPOUND_ELEMENT: return createCompoundElement();
			case MarkupPackage.FIGURE_ELEMENT: return createFigureElement();
			case MarkupPackage.FIGURE_REF_ELEMENT: return createFigureRefElement();
			case MarkupPackage.FONT_ELEMENT: return createFontElement();
			case MarkupPackage.FOOTNOTE_ELEMENT: return createFootnoteElement();
			case MarkupPackage.HEADING_ELEMENT: return createHeadingElement();
			case MarkupPackage.MARKUP: return createMarkup();
			case MarkupPackage.MARKUP_ELEMENT: return createMarkupElement();
			case MarkupPackage.NEW_LINE_ELEMENT: return createNewLineElement();
			case MarkupPackage.NULL_ELEMENT: return createNullElement();
			case MarkupPackage.OCL_CODE_ELEMENT: return createOCLCodeElement();
			case MarkupPackage.OCL_EVAL_ELEMENT: return createOCLEvalElement();
			case MarkupPackage.OCL_TEXT_ELEMENT: return createOCLTextElement();
			case MarkupPackage.TEXT_ELEMENT: return createTextElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BulletElement createBulletElement() {
		BulletElementImpl bulletElement = new BulletElementImpl();
		return bulletElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundElement createCompoundElement() {
		CompoundElementImpl compoundElement = new CompoundElementImpl();
		return compoundElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FigureElement createFigureElement() {
		FigureElementImpl figureElement = new FigureElementImpl();
		return figureElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FigureRefElement createFigureRefElement() {
		FigureRefElementImpl figureRefElement = new FigureRefElementImpl();
		return figureRefElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontElement createFontElement() {
		FontElementImpl fontElement = new FontElementImpl();
		return fontElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FootnoteElement createFootnoteElement() {
		FootnoteElementImpl footnoteElement = new FootnoteElementImpl();
		return footnoteElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeadingElement createHeadingElement() {
		HeadingElementImpl headingElement = new HeadingElementImpl();
		return headingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Markup createMarkup() {
		MarkupImpl markup = new MarkupImpl();
		return markup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkupElement createMarkupElement() {
		MarkupElementImpl markupElement = new MarkupElementImpl();
		return markupElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewLineElement createNewLineElement() {
		NewLineElementImpl newLineElement = new NewLineElementImpl();
		return newLineElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullElement createNullElement() {
		NullElementImpl nullElement = new NullElementImpl();
		return nullElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLCodeElement createOCLCodeElement() {
		OCLCodeElementImpl oclCodeElement = new OCLCodeElementImpl();
		return oclCodeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLEvalElement createOCLEvalElement() {
		OCLEvalElementImpl oclEvalElement = new OCLEvalElementImpl();
		return oclEvalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLTextElement createOCLTextElement() {
		OCLTextElementImpl oclTextElement = new OCLTextElementImpl();
		return oclTextElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextElement createTextElement() {
		TextElementImpl textElement = new TextElementImpl();
		return textElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkupPackage getMarkupPackage() {
		return (MarkupPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MarkupPackage getPackage() {
		return MarkupPackage.eINSTANCE;
	}

} //MarkupFactoryImpl
