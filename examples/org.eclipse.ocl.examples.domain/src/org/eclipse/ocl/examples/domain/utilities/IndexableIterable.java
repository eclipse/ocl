/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.utilities;

import org.eclipse.jdt.annotation.NonNull;

/**
 * IterableWithSize provides an Iterable that can be indexed and has a known size.
 */
public interface IndexableIterable<T> extends Iterable<T>
{
	@NonNull T get(int index);
	int size();		
}