/**
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.ocl4uml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='OCLforUML'"
 * @generated
 */
public interface OCL4UMLPackage
		extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ocl4uml"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2015/OCLforUML"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ocl4uml"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCL4UMLPackage eINSTANCE = org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl
		.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.IntegerImpl <em>Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.IntegerImpl
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 1;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER__BASE_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER__MAXIMUM = 1;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER__MINIMUM = 2;

	/**
	 * The number of structural features of the '<em>Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.BoundedIntegerImpl <em>Bounded Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.BoundedIntegerImpl
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getBoundedInteger()
	 * @generated
	 */
	int BOUNDED_INTEGER = 0;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_INTEGER__BASE_DATA_TYPE = INTEGER__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_INTEGER__MAXIMUM = INTEGER__MAXIMUM;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_INTEGER__MINIMUM = INTEGER__MINIMUM;

	/**
	 * The feature id for the '<em><b>Overflow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_INTEGER__OVERFLOW = INTEGER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bounded Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_INTEGER_FEATURE_COUNT = INTEGER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Bounded Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_INTEGER_OPERATION_COUNT = INTEGER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionImpl <em>Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionImpl
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getCollection()
	 * @generated
	 */
	int COLLECTION = 2;

	/**
	 * The feature id for the '<em><b>Base Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__BASE_TYPED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Is Null Free</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__IS_NULL_FREE = 1;

	/**
	 * The number of structural features of the '<em>Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionsImpl <em>Collections</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionsImpl
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getCollections()
	 * @generated
	 */
	int COLLECTIONS = 3;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIONS__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIONS__BASE_PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Is Null Free</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIONS__IS_NULL_FREE = 2;

	/**
	 * The number of structural features of the '<em>Collections</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIONS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Collections</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.RealImpl <em>Real</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.RealImpl
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getReal()
	 * @generated
	 */
	int REAL = 5;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL__BASE_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Epsilon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL__EPSILON = 1;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL__MAXIMUM = 2;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL__MINIMUM = 3;

	/**
	 * The number of structural features of the '<em>Real</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Real</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.FixedPointImpl <em>Fixed Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.FixedPointImpl
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getFixedPoint()
	 * @generated
	 */
	int FIXED_POINT = 4;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT__BASE_DATA_TYPE = REAL__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Epsilon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT__EPSILON = REAL__EPSILON;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT__MAXIMUM = REAL__MAXIMUM;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT__MINIMUM = REAL__MINIMUM;

	/**
	 * The feature id for the '<em><b>Bit True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT__BIT_TRUE = REAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fractional Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT__FRACTIONAL_BITS = REAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Integer Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT__INTEGER_BITS = REAL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Overflow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT__OVERFLOW = REAL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Rounding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT__ROUNDING = REAL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Fixed Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FEATURE_COUNT = REAL_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Fixed Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_OPERATION_COUNT = REAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.FloatingPointImpl <em>Floating Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.FloatingPointImpl
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getFloatingPoint()
	 * @generated
	 */
	int FLOATING_POINT = 6;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT__BASE_DATA_TYPE = REAL__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Epsilon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT__EPSILON = REAL__EPSILON;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT__MAXIMUM = REAL__MAXIMUM;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT__MINIMUM = REAL__MINIMUM;

	/**
	 * The feature id for the '<em><b>Overflow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT__OVERFLOW = REAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rounding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT__ROUNDING = REAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exponent Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT__EXPONENT_BITS = REAL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mantissa Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT__MANTISSA_BITS = REAL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Floating Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT_FEATURE_COUNT = REAL_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Floating Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT_OPERATION_COUNT = REAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.ValidationImpl <em>Validation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.ValidationImpl
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getValidation()
	 * @generated
	 */
	int VALIDATION = 7;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION__BASE_INSTANCE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Validate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION__VALIDATE = 1;

	/**
	 * The number of structural features of the '<em>Validation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Validation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.ValidationsImpl <em>Validations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.ValidationsImpl
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getValidations()
	 * @generated
	 */
	int VALIDATIONS = 8;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATIONS__BASE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Validate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATIONS__VALIDATE = 1;

	/**
	 * The number of structural features of the '<em>Validations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATIONS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Validations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Overflow <em>Overflow</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Overflow
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getOverflow()
	 * @generated
	 */
	int OVERFLOW = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Rounding <em>Rounding</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Rounding
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getRounding()
	 * @generated
	 */
	int ROUNDING = 10;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.uml.ocl4uml.BoundedInteger <em>Bounded Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bounded Integer</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.BoundedInteger
	 * @generated
	 */
	EClass getBoundedInteger();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.BoundedInteger#getOverflow <em>Overflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overflow</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.BoundedInteger#getOverflow()
	 * @see #getBoundedInteger()
	 * @generated
	 */
	EAttribute getBoundedInteger_Overflow();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Integer <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Integer
	 * @generated
	 */
	EClass getInteger();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Integer#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Integer#getBase_DataType()
	 * @see #getInteger()
	 * @generated
	 */
	EReference getInteger_Base_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Integer#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Integer#getMaximum()
	 * @see #getInteger()
	 * @generated
	 */
	EAttribute getInteger_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Integer#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Integer#getMinimum()
	 * @see #getInteger()
	 * @generated
	 */
	EAttribute getInteger_Minimum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Collection
	 * @generated
	 */
	EClass getCollection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Collection#isNullFree <em>Is Null Free</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Null Free</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Collection#isNullFree()
	 * @see #getCollection()
	 * @generated
	 */
	EAttribute getCollection_IsNullFree();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Collections <em>Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collections</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Collections
	 * @generated
	 */
	EClass getCollections();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Collections#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Collections#getBase_Class()
	 * @see #getCollections()
	 * @generated
	 */
	EReference getCollections_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Collections#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Collections#getBase_Package()
	 * @see #getCollections()
	 * @generated
	 */
	EReference getCollections_Base_Package();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Collections#isNullFree <em>Is Null Free</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Null Free</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Collections#isNullFree()
	 * @see #getCollections()
	 * @generated
	 */
	EAttribute getCollections_IsNullFree();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint <em>Fixed Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Point</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint
	 * @generated
	 */
	EClass getFixedPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint#isBitTrue <em>Bit True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bit True</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint#isBitTrue()
	 * @see #getFixedPoint()
	 * @generated
	 */
	EAttribute getFixedPoint_BitTrue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint#getFractionalBits <em>Fractional Bits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fractional Bits</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint#getFractionalBits()
	 * @see #getFixedPoint()
	 * @generated
	 */
	EAttribute getFixedPoint_FractionalBits();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint#getIntegerBits <em>Integer Bits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Bits</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint#getIntegerBits()
	 * @see #getFixedPoint()
	 * @generated
	 */
	EAttribute getFixedPoint_IntegerBits();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint#getOverflow <em>Overflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overflow</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint#getOverflow()
	 * @see #getFixedPoint()
	 * @generated
	 */
	EAttribute getFixedPoint_Overflow();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint#getRounding <em>Rounding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rounding</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint#getRounding()
	 * @see #getFixedPoint()
	 * @generated
	 */
	EAttribute getFixedPoint_Rounding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Real
	 * @generated
	 */
	EClass getReal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Real#getBase_DataType()
	 * @see #getReal()
	 * @generated
	 */
	EReference getReal_Base_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getEpsilon <em>Epsilon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Epsilon</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Real#getEpsilon()
	 * @see #getReal()
	 * @generated
	 */
	EAttribute getReal_Epsilon();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Real#getMaximum()
	 * @see #getReal()
	 * @generated
	 */
	EAttribute getReal_Maximum();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Real#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Real#getMinimum()
	 * @see #getReal()
	 * @generated
	 */
	EAttribute getReal_Minimum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint <em>Floating Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Floating Point</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint
	 * @generated
	 */
	EClass getFloatingPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint#getOverflow <em>Overflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overflow</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint#getOverflow()
	 * @see #getFloatingPoint()
	 * @generated
	 */
	EAttribute getFloatingPoint_Overflow();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint#getRounding <em>Rounding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rounding</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint#getRounding()
	 * @see #getFloatingPoint()
	 * @generated
	 */
	EAttribute getFloatingPoint_Rounding();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint#getExponentBits <em>Exponent Bits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exponent Bits</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint#getExponentBits()
	 * @see #getFloatingPoint()
	 * @generated
	 */
	EAttribute getFloatingPoint_ExponentBits();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint#getMantissaBits <em>Mantissa Bits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mantissa Bits</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint#getMantissaBits()
	 * @see #getFloatingPoint()
	 * @generated
	 */
	EAttribute getFloatingPoint_MantissaBits();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Validation <em>Validation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validation</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Validation
	 * @generated
	 */
	EClass getValidation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Validation#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Validation#getBase_InstanceSpecification()
	 * @see #getValidation()
	 * @generated
	 */
	EReference getValidation_Base_InstanceSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Validation#isValidate <em>Validate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validate</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Validation#isValidate()
	 * @see #getValidation()
	 * @generated
	 */
	EAttribute getValidation_Validate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Validations <em>Validations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validations</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Validations
	 * @generated
	 */
	EClass getValidations();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Validations#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Validations#getBase_Package()
	 * @see #getValidations()
	 * @generated
	 */
	EReference getValidations_Base_Package();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Validations#isValidate <em>Validate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validate</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Validations#isValidate()
	 * @see #getValidations()
	 * @generated
	 */
	EAttribute getValidations_Validate();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Overflow <em>Overflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Overflow</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Overflow
	 * @generated
	 */
	EEnum getOverflow();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Rounding <em>Rounding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rounding</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Rounding
	 * @generated
	 */
	EEnum getRounding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Collection#getBase_TypedElement <em>Base Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Typed Element</em>'.
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Collection#getBase_TypedElement()
	 * @see #getCollection()
	 * @generated
	 */
	EReference getCollection_Base_TypedElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OCL4UMLFactory getOCL4UMLFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.BoundedIntegerImpl <em>Bounded Integer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.BoundedIntegerImpl
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getBoundedInteger()
		 * @generated
		 */
		EClass BOUNDED_INTEGER = eINSTANCE.getBoundedInteger();

		/**
		 * The meta object literal for the '<em><b>Overflow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_INTEGER__OVERFLOW = eINSTANCE
			.getBoundedInteger_Overflow();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.IntegerImpl <em>Integer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.IntegerImpl
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getInteger()
		 * @generated
		 */
		EClass INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGER__BASE_DATA_TYPE = eINSTANCE
			.getInteger_Base_DataType();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER__MAXIMUM = eINSTANCE.getInteger_Maximum();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER__MINIMUM = eINSTANCE.getInteger_Minimum();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionImpl <em>Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionImpl
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getCollection()
		 * @generated
		 */
		EClass COLLECTION = eINSTANCE.getCollection();

		/**
		 * The meta object literal for the '<em><b>Is Null Free</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION__IS_NULL_FREE = eINSTANCE
			.getCollection_IsNullFree();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionsImpl <em>Collections</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionsImpl
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getCollections()
		 * @generated
		 */
		EClass COLLECTIONS = eINSTANCE.getCollections();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTIONS__BASE_CLASS = eINSTANCE
			.getCollections_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTIONS__BASE_PACKAGE = eINSTANCE
			.getCollections_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Is Null Free</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTIONS__IS_NULL_FREE = eINSTANCE
			.getCollections_IsNullFree();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.FixedPointImpl <em>Fixed Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.FixedPointImpl
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getFixedPoint()
		 * @generated
		 */
		EClass FIXED_POINT = eINSTANCE.getFixedPoint();

		/**
		 * The meta object literal for the '<em><b>Bit True</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT__BIT_TRUE = eINSTANCE.getFixedPoint_BitTrue();

		/**
		 * The meta object literal for the '<em><b>Fractional Bits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT__FRACTIONAL_BITS = eINSTANCE
			.getFixedPoint_FractionalBits();

		/**
		 * The meta object literal for the '<em><b>Integer Bits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT__INTEGER_BITS = eINSTANCE
			.getFixedPoint_IntegerBits();

		/**
		 * The meta object literal for the '<em><b>Overflow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT__OVERFLOW = eINSTANCE.getFixedPoint_Overflow();

		/**
		 * The meta object literal for the '<em><b>Rounding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT__ROUNDING = eINSTANCE.getFixedPoint_Rounding();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.RealImpl <em>Real</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.RealImpl
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getReal()
		 * @generated
		 */
		EClass REAL = eINSTANCE.getReal();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REAL__BASE_DATA_TYPE = eINSTANCE.getReal_Base_DataType();

		/**
		 * The meta object literal for the '<em><b>Epsilon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL__EPSILON = eINSTANCE.getReal_Epsilon();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL__MAXIMUM = eINSTANCE.getReal_Maximum();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL__MINIMUM = eINSTANCE.getReal_Minimum();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.FloatingPointImpl <em>Floating Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.FloatingPointImpl
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getFloatingPoint()
		 * @generated
		 */
		EClass FLOATING_POINT = eINSTANCE.getFloatingPoint();

		/**
		 * The meta object literal for the '<em><b>Overflow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOATING_POINT__OVERFLOW = eINSTANCE
			.getFloatingPoint_Overflow();

		/**
		 * The meta object literal for the '<em><b>Rounding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOATING_POINT__ROUNDING = eINSTANCE
			.getFloatingPoint_Rounding();

		/**
		 * The meta object literal for the '<em><b>Exponent Bits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOATING_POINT__EXPONENT_BITS = eINSTANCE
			.getFloatingPoint_ExponentBits();

		/**
		 * The meta object literal for the '<em><b>Mantissa Bits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOATING_POINT__MANTISSA_BITS = eINSTANCE
			.getFloatingPoint_MantissaBits();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.ValidationImpl <em>Validation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.ValidationImpl
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getValidation()
		 * @generated
		 */
		EClass VALIDATION = eINSTANCE.getValidation();

		/**
		 * The meta object literal for the '<em><b>Base Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION__BASE_INSTANCE_SPECIFICATION = eINSTANCE
			.getValidation_Base_InstanceSpecification();

		/**
		 * The meta object literal for the '<em><b>Validate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION__VALIDATE = eINSTANCE.getValidation_Validate();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.ValidationsImpl <em>Validations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.ValidationsImpl
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getValidations()
		 * @generated
		 */
		EClass VALIDATIONS = eINSTANCE.getValidations();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATIONS__BASE_PACKAGE = eINSTANCE
			.getValidations_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Validate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATIONS__VALIDATE = eINSTANCE.getValidations_Validate();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Overflow <em>Overflow</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Overflow
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getOverflow()
		 * @generated
		 */
		EEnum OVERFLOW = eINSTANCE.getOverflow();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Rounding <em>Rounding</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.Rounding
		 * @see org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLPackageImpl#getRounding()
		 * @generated
		 */
		EEnum ROUNDING = eINSTANCE.getRounding();

		/**
		 * The meta object literal for the '<em><b>Base Typed Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION__BASE_TYPED_ELEMENT = eINSTANCE
			.getCollection_Base_TypedElement();

	}

} //OCL4UMLPackage
