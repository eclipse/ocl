/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.java.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.domain.ids.ElementId;

/**
 * An UnboxedValueDescriptor describes a type whose unboxed representation differs from its boxed representation. It has a pivot ElementId and a Java class.
 * <p>
 * Thus an Integer is a TypeId.INTEGER and a java.lang.Integer.
 */
public class UnboxedValueDescriptor extends AbstractValueDescriptor implements UnboxedDescriptor
{
	public UnboxedValueDescriptor(@NonNull ElementId elementId, @NonNull Class<?> javaClass) {
		super(elementId, javaClass);
	}

	@Override
	public @NonNull UnboxedDescriptor getUnboxedDescriptor() {
		return this;
	}

	@Override
	public final boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor) {
		if (!(typeDescriptor instanceof UnboxedValueDescriptor)) {
			return false;
		}
		return javaClass.isAssignableFrom(typeDescriptor.getJavaClass());
	}
}