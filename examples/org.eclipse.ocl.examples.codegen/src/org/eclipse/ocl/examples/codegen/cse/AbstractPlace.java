/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.cse;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractPlace describes a place where forests of CG trees may be placed for code generation. 
 * <p>A GlobalPlace describes the place for global constants and all outer stack places.
 * <p>A StackPlace describes a callable forest such as an Operation of Iteration.
 * <p>A ControlPlace describes a control dependency such as the Else place of an If.
 */
public abstract class AbstractPlace
{
	public static @NonNull ControlPlace getControlPlace(@NonNull AbstractPlace abstractPlace) {
		if (abstractPlace instanceof ControlPlace) {
			return (ControlPlace) abstractPlace;
		}
		else {
			throw new IllegalStateException("No ControlPlace for " + abstractPlace);
		}
	}

	public abstract @NonNull GlobalPlace getGlobalPlace();

	public abstract @NonNull AbstractPlace getParentPlace();
	
	public abstract @Nullable StackPlace getStackPlace();
	
	public abstract void printHierarchy(@NonNull Appendable appendable, @NonNull String indentation);
}