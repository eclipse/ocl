/*******************************************************************************
 * Copyright (c) 2008,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.common.label;

import org.eclipse.jdt.annotation.NonNull;

public abstract class AbstractLabelGenerator<T> implements ILabelGenerator<T>
{
	protected final @NonNull Class<? extends T> labelledClass;
	
	protected AbstractLabelGenerator(@NonNull Class<? extends T> labelledClass) {
		this.labelledClass = labelledClass;
	}

	public @NonNull Class<? extends T> getLabelledClass() {
		return labelledClass;
	}
}