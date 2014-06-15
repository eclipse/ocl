/*******************************************************************************
 * Copyright (c) 2010,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.pivot/model/Pivot.merged.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.pivot.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface Visitable
{
	/**
	 * Returns the result of accepting a visit from a visitor.
	 * Implementations typically invoke a derived-class-specific
	 * variant of visitXXX() to facilitate derived-class-specific
	 * processing or just visit() when no such method is available.
	 * <p>
	 * Implementations of visit() may use the EcoreSwitch to perform
	 * derived-class-specific processing.
	 * <p>
	 * Derived implementations of accept() may use getAdapter() to obtain
	 * richer visitor interfaces.
	 * @param <R>
	 * @param visitor
	 * @return the result of the visit.
	 */
	@Nullable <R> R accept(@NonNull org.eclipse.ocl.examples.pivot.util.Visitor<R> visitor);
	
	EClass eClass();
}
