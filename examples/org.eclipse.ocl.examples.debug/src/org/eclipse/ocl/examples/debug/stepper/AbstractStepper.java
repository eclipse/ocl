/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.stepper;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public abstract class AbstractStepper implements IStepper
{
	public static @NonNull UnitLocation createUnitLocation(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element, @Nullable INode startNode, @Nullable INode endNode) {
		int startPosition = startNode != null ? startNode.getOffset() : 0;
		int endPosition = endNode != null ? ElementUtil.getEndOffset(endNode) : 0;
		return new UnitLocation(startPosition, endPosition, evalEnv, element);
	}

	public @NonNull UnitLocation createUnitLocation(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element) {
		INode node = null;
		ModelElementCS csElement = ElementUtil.getCsElement(element);
		if (csElement != null) {
			node = NodeModelUtils.getNode(csElement);
		}
		return createUnitLocation(evalEnv, element, node, node);
	}
}
