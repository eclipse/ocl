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
package org.eclipse.ocl.examples.debug.vm.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.pivot.Element;

/**
 * An IStepper provives the element-type specific strategy for a variety of actions while stepping throuygh souyrce code.
 */
public interface IStepper
{
	/**
	 * Return the source descriptor for element.
	 */
	public @NonNull UnitLocation createUnitLocation(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element);
	
	/**
	 * Return null if no suspension is required after executing childElement, else return the next element to be executed. 
	 * <p>
	 * zzparentElement is not used; Change to value of childElement once an API change is acceptable
	 */
	@Nullable Element isPostStoppable(@NonNull IVMRootEvaluationVisitor<?> rootVMEvaluationVisitor, @NonNull Element childElement, @Nullable Element zzparentElement);

	/**
	 * Return true if execution may be suspended before executing element.
	 */
	boolean isPreStoppable(@NonNull IVMRootEvaluationVisitor<?> rootVMEvaluationVisitor, @NonNull Element element);
}
