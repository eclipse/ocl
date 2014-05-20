/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.utilities;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A SingletonIterator supports a single iteration over a given value.
 */
public final class SingletonIterator<T> implements Iterator<T>
{
	private @NonNull T value;
	private boolean done = false;

	public SingletonIterator(@NonNull T value) {
		this.value = value;
	}

	public boolean hasNext() {
		return !done;
	}

	public @NonNull T next() {
        if (done) {
        	throw new NoSuchElementException();
        }
        else {
        	done = true;
			return value;
        }
	}

	public void remove() {
		throw new UnsupportedOperationException();			
	}
}