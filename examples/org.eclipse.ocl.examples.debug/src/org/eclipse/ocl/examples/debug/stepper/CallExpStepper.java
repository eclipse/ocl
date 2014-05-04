/**
 * <copyright>
 * 
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.debug.stepper;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.evaluator.IRootVMEvaluationVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public abstract class CallExpStepper extends PostStepper
{
	public @NonNull UnitLocation createUnitLocation(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element) {
		INode startNode = null;
		INode endNode = null;
		ModelElementCS csStartElement = ElementUtil.getCsElement(element);
		if (csStartElement instanceof NavigationOperatorCS) {
			ModelElementCS csEndElement = ((NavigationOperatorCS)csStartElement).getArgument();
			if (csEndElement != null) {
				startNode = NodeModelUtils.getNode(csStartElement);
				endNode = NodeModelUtils.getNode(csEndElement);
			}
		}
		else if (csStartElement != null) {
			startNode = NodeModelUtils.getNode(csStartElement);
			endNode = startNode;
		}
		return createUnitLocation(evalEnv, element, startNode, endNode);
	}

	@Override
	public @Nullable Element isPostStoppable(@NonNull IRootVMEvaluationVisitor<?> rootVMEvaluationVisitor, @NonNull Element element, @Nullable Element parentElement) {
		return parentElement;
	}
}
