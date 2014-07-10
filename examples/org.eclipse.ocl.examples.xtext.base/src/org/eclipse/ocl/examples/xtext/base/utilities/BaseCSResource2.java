/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.NamedElement;

/**
 * BaseResource defines the Xtext-dependent extended interface for a Concrete Syntax resource.
 * @since 3.5
 */
public interface BaseCSResource2 extends BaseCSResource
{
	/**
	 * Return a non-null NamedElement if element is able to be accessed by a qualified path; Other elements must use a quoted URI.
	 */
	@Nullable NamedElement isPathable(@NonNull EObject element);
}
