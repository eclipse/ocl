/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.values;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordered Collection Value</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.values.ValuesPackage#getOrderedCollectionValue()
 * @generated
 */
@SuppressWarnings("unused")
public interface OrderedCollectionValue extends CollectionValue
{	
	/**
	 * @deprecated use returnTypeId
	 */
	@Deprecated
	@NonNull OrderedCollectionValue append(@Nullable Object object);

	/**
	 * @generated NOT
	 */
	@NonNull OrderedCollectionValue append(@NonNull CollectionTypeId returnTypeId, @Nullable Object object);

	/**
	 * @deprecated use returnTypeId
	 */
	@Deprecated
    @NonNull OrderedCollectionValue appendAll(@NonNull OrderedCollectionValue objects);

	/**
	 * @generated NOT
	 */
    @NonNull OrderedCollectionValue appendAll(@NonNull CollectionTypeId returnTypeId, @NonNull OrderedCollectionValue objects);

	/**
	 * @generated NOT
	 */
	@Nullable Object at(int index);

	/**
	 * @generated NOT
	 */
	@Nullable Object first();

	/**
	 * @deprecated use returnTypeId
	 */
	@Deprecated
	@NonNull OrderedCollectionValue insertAt(int index, @Nullable Object object);

	/**
	 * @generated NOT
	 */
	@NonNull OrderedCollectionValue insertAt(@NonNull CollectionTypeId returnTypeId, int index, @Nullable Object object);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue indexOf(@Nullable Object object);

	/**
	 * @generated NOT
	 */
	@Nullable Object last();

	/**
	 * @deprecated use returnTypeId
	 */
	@Deprecated
    @NonNull OrderedCollectionValue prepend(@Nullable Object object);

	/**
	 * @generated NOT
	 */
    @NonNull OrderedCollectionValue prepend(@NonNull CollectionTypeId returnTypeId, @Nullable Object object);

	/**
	 * @deprecated use returnTypeId
	 */
	@Deprecated
    @NonNull OrderedCollectionValue prependAll(@NonNull OrderedCollectionValue objects);

	/**
	 * @generated NOT
	 */
    @NonNull OrderedCollectionValue prependAll(@NonNull CollectionTypeId returnTypeId, @NonNull OrderedCollectionValue objects);

    /**
	 * @generated NOT
	 */
    @NonNull OrderedCollectionValue reverse();
} // OrderedCollectionValue
