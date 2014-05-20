/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

/**
 * customization of the default outline structure
 * 
 */
public class BaseOutlineTreeProvider extends DefaultOutlineTreeProvider
{
	/* This was used on Xtext 2.0
	@Override
	protected EObjectNode createEObjectNode(IOutlineNode parentNode,
			EObject modelElement) {
		if (!(modelElement instanceof Element)) {
			return super.createEObjectNode(parentNode, modelElement);
		}
		Object text = textDispatcher.invoke(modelElement);
		Image image = imageDispatcher.invoke(modelElement);
		EObjectNode eObjectNode = new ElementNode(modelElement, parentNode,
			image, text, isLeafDispatcher.invoke(modelElement));
		ICompositeNode parserNode = NodeModelUtils.getNode(modelElement);
		if (parserNode != null)
			eObjectNode.setTextRegion(new TextRegion(parserNode.getOffset(),
				parserNode.getLength()));
		eObjectNode.setShortTextRegion(locationInFileProvider
			.getSignificantTextRegion(modelElement));
		return eObjectNode;
	} */

	// This is used on Xtext 2.1
	@Override
	protected EObjectNode createEObjectNode(IOutlineNode parentNode, EObject modelElement, Image image, Object text, boolean isLeaf) {
		EObject pivotedElement = getPivoted(modelElement);
		EObjectNode eObjectNode;
		if (pivotedElement instanceof Element) {
			eObjectNode = new EObjectNode(modelElement, /*pivotedElement,*/ parentNode, image, text, isLeaf);
		}
		else {
			eObjectNode = new EObjectNode(modelElement, parentNode, image, text, isLeaf);
		}
		if (isLocalElement(parentNode, modelElement)) {
			eObjectNode.setTextRegion(locationInFileProvider.getFullTextRegion(modelElement));
			eObjectNode.setShortTextRegion(locationInFileProvider.getSignificantTextRegion(modelElement));
		}
		return eObjectNode;
	}
	
	@Override
	protected void _createNode(DocumentRootNode parentNode, EObject modelElement) {
		EObject pivotedElement = getPivoted(modelElement);
		Object text = textDispatcher.invoke(pivotedElement);
		if (text == null) {
			text = pivotedElement.eResource().getURI().trimFileExtension().lastSegment();
		}
		createEObjectNode(parentNode, modelElement, imageDispatcher.invoke(modelElement), text, isLeafDispatcher.invoke(modelElement));
	}
	
	@Override
	protected void _createNode(IOutlineNode parentNode, EObject modelElement) {
		EObject pivotedElement = getPivoted(modelElement);
		Object text = textDispatcher.invoke(pivotedElement);
		boolean isLeaf = isLeafDispatcher.invoke(pivotedElement);
		if (text == null && isLeaf)
			return;
		Image image = imageDispatcher.invoke(pivotedElement);
		createEObjectNode(parentNode, modelElement, image, text, isLeaf);
	}
	
	protected EObject getPivoted(EObject modelElement) {
		if (modelElement instanceof Pivotable) {
			Pivotable pivotable = (Pivotable) modelElement;
			Element pivot = pivotable.getPivot();
			if (pivot != null) {
				return pivot;
			}
		}
		return modelElement;
	}
	

	// protected void _createNode(IOutlineNode parentNode, TemplateParameter
	// templateParameter) {
	// createNode(parentNode, templateParameter.getParameteredElement());
	// }

	// protected void _createNode(IOutlineNode parentNode, TemplateSignature
	// templateSignature) {
	// createChildren(parentNode, templateSignature);
	// }

	protected void _createChildren(IOutlineNode parentNode, Constraint constraint) {
		createChildren(parentNode, constraint.getSpecification());
	}

	protected void _createChildren(IOutlineNode parentNode, IfExp exp) {
		createNode(parentNode, exp.getCondition());
		createNode(parentNode, exp.getThenExpression());
		createNode(parentNode, exp.getElseExpression());
	}

	protected void _createChildren(IOutlineNode parentNode, OppositePropertyCallExp ele) {
		createNode(parentNode, ele.getSource());
	}

	protected void _createChildren(IOutlineNode parentNode, PropertyCallExp ele) {
		createNode(parentNode, ele.getSource());
	}
}
