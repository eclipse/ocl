/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.ocl.pivot.values;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.values.ValuesFactory
 * @generated
 */
public interface ValuesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "values";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2015/Values";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "values";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ValuesPackage eINSTANCE = org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl.init();

	/**
	 * The meta object id for the 'Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int VALUE = 15;

	/**
	 * The number of structural features of the 'Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the 'Collection Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int COLLECTION_VALUE = 1;

	/**
	 * The number of structural features of the 'Collection Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the 'Bag Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int BAG_VALUE = 0;

	/**
	 * The number of structural features of the 'Bag Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_VALUE_FEATURE_COUNT = COLLECTION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the 'Object Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int OBJECT_VALUE = 6;

	/**
	 * The meta object id for the 'Integer Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int INTEGER_VALUE = 2;

	/**
	 * The meta object id for the 'Null Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int NULL_VALUE = 5;

	/**
	 * The meta object id for the 'Sequence Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int SEQUENCE_VALUE = 10;

	/**
	 * The meta object id for the 'Ordered Set Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int ORDERED_SET_VALUE = 8;

	/**
	 * The meta object id for the 'Real Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int REAL_VALUE = 9;

	/**
	 * The number of structural features of the 'Real Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the 'Integer Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_FEATURE_COUNT = REAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the 'Map Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int MAP_VALUE = 4;

	/**
	 * The number of structural features of the 'Object Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the 'Null Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_VALUE_FEATURE_COUNT = OBJECT_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the 'Invalid Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int INVALID_VALUE = 3;

	/**
	 * The number of structural features of the 'Invalid Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_VALUE_FEATURE_COUNT = NULL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the 'Map Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the 'Ordered Collection Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int ORDERED_COLLECTION_VALUE = 7;

	/**
	 * The number of structural features of the 'Ordered Collection Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_COLLECTION_VALUE_FEATURE_COUNT = COLLECTION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the 'Ordered Set Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_VALUE_FEATURE_COUNT = ORDERED_COLLECTION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the 'Sequence Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_VALUE_FEATURE_COUNT = ORDERED_COLLECTION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the 'Set Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int SET_VALUE = 11;

	/**
	 * The meta object id for the 'Tuple Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int TUPLE_VALUE = 12;

	/**
	 * The meta object id for the 'Unique Collection Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int UNIQUE_COLLECTION_VALUE = 13;

	/**
	 * The number of structural features of the 'Unique Collection Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COLLECTION_VALUE_FEATURE_COUNT = COLLECTION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the 'Set Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE_FEATURE_COUNT = UNIQUE_COLLECTION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the 'Tuple Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the 'Unlimited Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int UNLIMITED_VALUE = 14;

	/**
	 * The number of structural features of the 'Unlimited Value' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_VALUE_FEATURE_COUNT = INTEGER_VALUE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class 'Bag Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Bag Value'.
	 * @generated
	 */
	EClass getBagValue();

	/**
	 * Returns the meta object for class 'Collection Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Collection Value'.
	 * @generated
	 */
	EClass getCollectionValue();

	/**
	 * Returns the meta object for class 'Integer Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Integer Value'.
	 * @generated
	 */
	EClass getIntegerValue();

	/**
	 * Returns the meta object for class 'Invalid Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Invalid Value'.
	 * @generated
	 */
	EClass getInvalidValue();

	/**
	 * Returns the meta object for class 'Map Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Map Value'.
	 * @generated
	 */
	EClass getMapValue();

	/**
	 * Returns the meta object for class 'Null Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Null Value'.
	 * @generated
	 */
	EClass getNullValue();

	/**
	 * Returns the meta object for class 'Object Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Object Value'.
	 * @generated
	 */
	EClass getObjectValue();

	/**
	 * Returns the meta object for class 'Ordered Collection Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Ordered Collection Value'.
	 * @generated
	 */
	EClass getOrderedCollectionValue();

	/**
	 * Returns the meta object for class 'Ordered Set Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Ordered Set Value'.
	 * @generated
	 */
	EClass getOrderedSetValue();

	/**
	 * Returns the meta object for class 'Real Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Real Value'.
	 * @generated
	 */
	EClass getRealValue();

	/**
	 * Returns the meta object for class 'Sequence Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Sequence Value'.
	 * @generated
	 */
	EClass getSequenceValue();

	/**
	 * Returns the meta object for class 'Set Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Set Value'.
	 * @generated
	 */
	EClass getSetValue();

	/**
	 * Returns the meta object for class 'Tuple Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Tuple Value'.
	 * @generated
	 */
	EClass getTupleValue();

	/**
	 * Returns the meta object for class 'Unique Collection Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Unique Collection Value'.
	 * @generated
	 */
	EClass getUniqueCollectionValue();

	/**
	 * Returns the meta object for class 'Unlimited Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Unlimited Value'.
	 * @generated
	 */
	EClass getUnlimitedValue();

	/**
	 * Returns the meta object for class 'Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class 'Value'.
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ValuesFactory getValuesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the 'Bag Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass BAG_VALUE = eINSTANCE.getBagValue();

		/**
		 * The meta object literal for the 'Collection Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass COLLECTION_VALUE = eINSTANCE.getCollectionValue();

		/**
		 * The meta object literal for the 'Integer Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

		/**
		 * The meta object literal for the 'Invalid Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass INVALID_VALUE = eINSTANCE.getInvalidValue();

		/**
		 * The meta object literal for the 'Map Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass MAP_VALUE = eINSTANCE.getMapValue();

		/**
		 * The meta object literal for the 'Null Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass NULL_VALUE = eINSTANCE.getNullValue();

		/**
		 * The meta object literal for the 'Object Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass OBJECT_VALUE = eINSTANCE.getObjectValue();

		/**
		 * The meta object literal for the 'Ordered Collection Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass ORDERED_COLLECTION_VALUE = eINSTANCE.getOrderedCollectionValue();

		/**
		 * The meta object literal for the 'Ordered Set Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass ORDERED_SET_VALUE = eINSTANCE.getOrderedSetValue();

		/**
		 * The meta object literal for the 'Real Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass REAL_VALUE = eINSTANCE.getRealValue();

		/**
		 * The meta object literal for the 'Sequence Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass SEQUENCE_VALUE = eINSTANCE.getSequenceValue();

		/**
		 * The meta object literal for the 'Set Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass SET_VALUE = eINSTANCE.getSetValue();

		/**
		 * The meta object literal for the 'Tuple Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass TUPLE_VALUE = eINSTANCE.getTupleValue();

		/**
		 * The meta object literal for the 'Unique Collection Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass UNIQUE_COLLECTION_VALUE = eINSTANCE.getUniqueCollectionValue();

		/**
		 * The meta object literal for the 'Unlimited Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass UNLIMITED_VALUE = eINSTANCE.getUnlimitedValue();

		/**
		 * The meta object literal for the 'Value' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
			 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

	}

} //ValuesPackage
