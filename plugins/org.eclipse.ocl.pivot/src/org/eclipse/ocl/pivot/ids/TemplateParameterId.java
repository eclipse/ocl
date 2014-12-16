/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Nameable;

/**
 * A TemplateParameterId provides a unique identifier for a template parameter such as Set<T> or product<T>(...).
 */
public interface TemplateParameterId extends TypeId, Nameable
{
	int getIndex();

	@Override
	@NonNull String getName();
}