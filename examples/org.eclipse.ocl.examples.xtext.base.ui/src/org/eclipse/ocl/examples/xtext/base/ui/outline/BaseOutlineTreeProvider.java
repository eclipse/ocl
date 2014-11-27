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
package org.eclipse.ocl.examples.xtext.base.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.ITextRegion;

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
		EObject asElement = getPivoted(modelElement);
		EObject csElement = modelElement;
		EObjectNode eObjectNode;
		if (asElement instanceof Element) {
			csElement = ElementUtil.getCsElement((Element)asElement);
			eObjectNode = new BaseOutlineNode((Element)asElement, (ElementCS)csElement, parentNode, image, text, isLeaf);
		}
		else {
			eObjectNode = new EObjectNode(modelElement, parentNode, image, text, isLeaf);
		}
		if ((csElement != null) && isLocalElement(parentNode, csElement)) {
			eObjectNode.setTextRegion(locationInFileProvider.getFullTextRegion(csElement));
			eObjectNode.setShortTextRegion(locationInFileProvider.getSignificantTextRegion(csElement));
		}
		ITextRegion fullText = eObjectNode.getFullTextRegion();
		ITextRegion shortText = eObjectNode.getSignificantTextRegion();
		System.out.println("[" + fullText.getOffset() + "," + fullText.getLength() + "] [" + shortText.getOffset() + "," + shortText.getLength() + "] " + DomainUtil.debugSimpleName(eObjectNode) + " " + String.valueOf(eObjectNode.getText()).replace("\n", "\\n"));
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

	@Override
	public void createChildren(IOutlineNode parent, EObject modelElement) {
		EObject pivotedElement = getPivoted(modelElement);
		if (pivotedElement != null) {
			superCreateChildren(parent, pivotedElement);
		}
	}

	protected void superCreateChildren(IOutlineNode parent, EObject modelElement) {
		super.createChildren(parent, modelElement);
	}

	@Override
	protected void createNode(IOutlineNode parent, EObject modelElement) {
		if (modelElement != null) {
			super.createNode(parent, modelElement);
		}
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

	protected void _createChildren(IOutlineNode parentNode, Constraint constraint) {
		createChildren(parentNode, constraint.getSpecification());
	}

	protected void _createChildren(IOutlineNode parentNode, Operation ele) {
		for (Parameter parameter : ele.getOwnedParameter()) {
			createNode(parentNode, parameter);
		}
		createNode(parentNode, ele.getBodyExpression());
	}

	// protected void _createNode(IOutlineNode parentNode, TemplateParameter
	// templateParameter) {
	// createNode(parentNode, templateParameter.getParameteredElement());
	// }

	// protected void _createNode(IOutlineNode parentNode, TemplateSignature
	// templateSignature) {
	// createChildren(parentNode, templateSignature);
	// }

//	protected boolean _isLeaf(Variable csExp) {
//		return true;
//	}
}
