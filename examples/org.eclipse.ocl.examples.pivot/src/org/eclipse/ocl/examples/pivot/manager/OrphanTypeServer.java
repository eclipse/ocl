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
package org.eclipse.ocl.examples.pivot.manager;

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.SingletonIterator;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * An OrphanTypeServer provides a 'merge' type behaviour for a synthesized type that forms part of the
 * OrphanPackage rather than a true package. OrphanTypeServer provides lightweight support that
 * eliminates the redundant notification tracking.
 */
public class OrphanTypeServer extends AbstractTypeServer implements Iterable<Type>
{
 	protected final @NonNull Type target;
	
	protected OrphanTypeServer(@NonNull OrphanPackageServer packageServer, @NonNull Type type) {
		super(packageServer, type);
		this.target = type;
	}

	public @NonNull Iterable<Type> getPartialTypes() {
		return this;			// 'this' is pragmatically an Iterable
	}
	
	public @NonNull Type getPivotType() {
		return target;
	}

	public @NonNull Iterator<Type> iterator() {
		return new SingletonIterator<Type>(target);
	}

	@Override
	public String toString() {
		return String.valueOf(target);
	}
}
