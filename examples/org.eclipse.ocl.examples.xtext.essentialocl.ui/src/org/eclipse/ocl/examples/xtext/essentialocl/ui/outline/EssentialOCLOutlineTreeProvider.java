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
package org.eclipse.ocl.examples.xtext.essentialocl.ui.outline;

import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.xtext.base.ui.outline.BaseOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * customization of the default outline structure
 * 
 */
public class EssentialOCLOutlineTreeProvider extends BaseOutlineTreeProvider
{
	protected void _createNode(IOutlineNode parentNode, ExpressionInOCL ele) {
		createNode(parentNode, ele.getBodyExpression());
	}

	protected void _createChildren(IOutlineNode parentNode, IfExp exp) {
		createNode(parentNode, exp.getCondition());
		createNode(parentNode, exp.getThenExpression());
		createNode(parentNode, exp.getElseExpression());
	}

	protected void _createChildren(IOutlineNode parentNode, IterateExp ele) {
		createNode(parentNode, ele.getSource());
		for (Variable iterator : ele.getIterator()) {
			createNode(parentNode, iterator);
		}
		createNode(parentNode, ele.getResult());
		createNode(parentNode, ele.getBody());
	}

	protected void _createChildren(IOutlineNode parentNode, IteratorExp ele) {
		createNode(parentNode, ele.getSource());
		for (Variable iterator : ele.getIterator()) {
			createNode(parentNode, iterator);
		}
		createNode(parentNode, ele.getBody());
	}

	protected void _createChildren(IOutlineNode parentNode, LetExp exp) {
		createNode(parentNode, exp.getVariable());
		createNode(parentNode, exp.getIn());
	}

	protected void _createChildren(IOutlineNode parentNode, OperationCallExp ele) {
		createNode(parentNode, ele.getSource());
		for (OCLExpression argument : ele.getArgument()) {
			createNode(parentNode, argument);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, OppositePropertyCallExp ele) {
		createNode(parentNode, ele.getSource());
	}

	protected void _createChildren(IOutlineNode parentNode, PropertyCallExp ele) {
		createNode(parentNode, ele.getSource());
	}
}
