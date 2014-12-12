/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.elements;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Type;

/**
 * A representation of the OCL Standard Library, which is the set of singleton
 * instances of the OCL-defined metatypes, including the generic collection
 * types (e.g., <tt>Set(T)</tt>).
 */
public interface DomainEnvironment
{
	/**
	 * Return the instance of the Bag metatype whose elements are of elementType.
	 */
	@NonNull CollectionType getBagType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);
	
	/**
	 * Return the specialized collection type for the containerType for elementType.
	 */
	@NonNull CollectionType getCollectionType(@NonNull org.eclipse.ocl.pivot.Class containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);

	org.eclipse.ocl.pivot.Package getNestedPackage(@NonNull org.eclipse.ocl.pivot.Package parentPackage, @NonNull String name);
	
    Type getNestedType(@NonNull org.eclipse.ocl.pivot.Package parentPackage, @NonNull String name);

	/**
	 * Return the instance of the OrderedSet metatype whose elements are of elementType.
	 */
	@NonNull CollectionType getOrderedSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);

	/**
	 * Return the instance of the Sequence metatype whose elements are of elementType.
	 */
	@NonNull CollectionType getSequenceType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);

	@NonNull DomainStandardLibrary getStandardLibrary();
	/**
	 * Return the instance of the Set metatype whose elements are of elementType.
	 */
	@NonNull CollectionType getSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);
}
