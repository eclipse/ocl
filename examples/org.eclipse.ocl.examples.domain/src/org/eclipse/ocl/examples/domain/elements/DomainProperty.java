/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.elements;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface DomainProperty extends DomainFeature
{
	DomainExpression getDefaultExpression();

	/**
	 * Return the Inheritance dispatch table for the owning type, or null for an orphan property owned by an Annotation.
	 */
	@Nullable DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary);

	/**
	 * Return the opposite Property if there is one, else null.
	 */
	/*@NonNull*/ DomainProperty getOpposite();
	
	/**
	 * Initialize the value of this property within objectValue to propertyValue.
	 * <p>
	 * This method is not thread-safe and should only be invoked to complete construction of objectvalue before
	 * making it visible to other threads.
	 */
	void initValue(@NonNull Object object, @Nullable Object unboxedValue);
}
