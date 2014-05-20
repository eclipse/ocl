/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.pivot.OCL;

/**
 * An object that converts values according to their declared multiplicities,
 * as collections or not.
 */
interface ValueConverter {

	ValueConverter VERBATIM = new ValueConverter() {

		public @NonNull Object convert(@NonNull OCL ocl, @NonNull Value value) {
			return value;
		}
	};

	ValueConverter LIST = new ValueConverter() {

		public @NonNull Object convert(@NonNull OCL ocl, @NonNull Value value) {
			Collection<?> collection = (Collection<?>) value;
			return new BasicEList.UnmodifiableEList<Object>(collection
				.size(), collection.toArray());
		}
	};

	@NonNull Object convert(@NonNull OCL ocl, @NonNull Value value);
}
