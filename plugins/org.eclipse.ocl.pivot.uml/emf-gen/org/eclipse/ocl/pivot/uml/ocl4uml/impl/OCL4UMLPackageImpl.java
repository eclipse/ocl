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
package org.eclipse.ocl.pivot.uml.ocl4uml.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.pivot.uml.ocl4uml.BoundedInteger;
import org.eclipse.ocl.pivot.uml.ocl4uml.Collection;
import org.eclipse.ocl.pivot.uml.ocl4uml.Collections;
import org.eclipse.ocl.pivot.uml.ocl4uml.FixedPoint;
import org.eclipse.ocl.pivot.uml.ocl4uml.FloatingPoint;
import org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLFactory;
import org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage;

import org.eclipse.ocl.pivot.uml.ocl4uml.Overflow;
import org.eclipse.ocl.pivot.uml.ocl4uml.Real;
import org.eclipse.ocl.pivot.uml.ocl4uml.Rounding;
import org.eclipse.ocl.pivot.uml.ocl4uml.Validation;
import org.eclipse.ocl.pivot.uml.ocl4uml.Validations;
import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCL4UMLPackageImpl
		extends EPackageImpl
		implements OCL4UMLPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundedIntegerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatingPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum overflowEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum roundingEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OCL4UMLPackageImpl() {
		super(eNS_URI, OCL4UMLFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OCL4UMLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OCL4UMLPackage init() {
		if (isInited)
			return (OCL4UMLPackage) EPackage.Registry.INSTANCE
				.getEPackage(OCL4UMLPackage.eNS_URI);

		// Obtain or create and register package
		OCL4UMLPackageImpl theOCL4UMLPackage = (OCL4UMLPackageImpl) (EPackage.Registry.INSTANCE
			.get(eNS_URI) instanceof OCL4UMLPackageImpl
				? EPackage.Registry.INSTANCE.get(eNS_URI)
				: new OCL4UMLPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOCL4UMLPackage.createPackageContents();

		// Initialize created meta-data
		theOCL4UMLPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOCL4UMLPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OCL4UMLPackage.eNS_URI,
			theOCL4UMLPackage);
		return theOCL4UMLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBoundedInteger() {
		return boundedIntegerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBoundedInteger_Overflow() {
		return (EAttribute) boundedIntegerEClass.getEStructuralFeatures()
			.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInteger() {
		return integerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInteger_Base_DataType() {
		return (EReference) integerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInteger_Maximum() {
		return (EAttribute) integerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInteger_Minimum() {
		return (EAttribute) integerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollection() {
		return collectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCollection_IsNullFree() {
		return (EAttribute) collectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollections() {
		return collectionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollections_Base_Class() {
		return (EReference) collectionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollections_Base_Package() {
		return (EReference) collectionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCollections_IsNullFree() {
		return (EAttribute) collectionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFixedPoint() {
		return fixedPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFixedPoint_BitTrue() {
		return (EAttribute) fixedPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFixedPoint_FractionalBits() {
		return (EAttribute) fixedPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFixedPoint_IntegerBits() {
		return (EAttribute) fixedPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFixedPoint_Overflow() {
		return (EAttribute) fixedPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFixedPoint_Rounding() {
		return (EAttribute) fixedPointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReal() {
		return realEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReal_Base_DataType() {
		return (EReference) realEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReal_Epsilon() {
		return (EAttribute) realEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReal_Maximum() {
		return (EAttribute) realEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReal_Minimum() {
		return (EAttribute) realEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFloatingPoint() {
		return floatingPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFloatingPoint_Overflow() {
		return (EAttribute) floatingPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFloatingPoint_Rounding() {
		return (EAttribute) floatingPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFloatingPoint_ExponentBits() {
		return (EAttribute) floatingPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFloatingPoint_MantissaBits() {
		return (EAttribute) floatingPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValidation() {
		return validationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValidation_Base_InstanceSpecification() {
		return (EReference) validationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValidation_Validate() {
		return (EAttribute) validationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValidations() {
		return validationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValidations_Base_Package() {
		return (EReference) validationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValidations_Validate() {
		return (EAttribute) validationsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getOverflow() {
		return overflowEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getRounding() {
		return roundingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollection_Base_TypedElement() {
		return (EReference) collectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCL4UMLFactory getOCL4UMLFactory() {
		return (OCL4UMLFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		boundedIntegerEClass = createEClass(BOUNDED_INTEGER);
		createEAttribute(boundedIntegerEClass, BOUNDED_INTEGER__OVERFLOW);

		integerEClass = createEClass(INTEGER);
		createEReference(integerEClass, INTEGER__BASE_DATA_TYPE);
		createEAttribute(integerEClass, INTEGER__MAXIMUM);
		createEAttribute(integerEClass, INTEGER__MINIMUM);

		collectionEClass = createEClass(COLLECTION);
		createEReference(collectionEClass, COLLECTION__BASE_TYPED_ELEMENT);
		createEAttribute(collectionEClass, COLLECTION__IS_NULL_FREE);

		collectionsEClass = createEClass(COLLECTIONS);
		createEReference(collectionsEClass, COLLECTIONS__BASE_CLASS);
		createEReference(collectionsEClass, COLLECTIONS__BASE_PACKAGE);
		createEAttribute(collectionsEClass, COLLECTIONS__IS_NULL_FREE);

		fixedPointEClass = createEClass(FIXED_POINT);
		createEAttribute(fixedPointEClass, FIXED_POINT__BIT_TRUE);
		createEAttribute(fixedPointEClass, FIXED_POINT__FRACTIONAL_BITS);
		createEAttribute(fixedPointEClass, FIXED_POINT__INTEGER_BITS);
		createEAttribute(fixedPointEClass, FIXED_POINT__OVERFLOW);
		createEAttribute(fixedPointEClass, FIXED_POINT__ROUNDING);

		realEClass = createEClass(REAL);
		createEReference(realEClass, REAL__BASE_DATA_TYPE);
		createEAttribute(realEClass, REAL__EPSILON);
		createEAttribute(realEClass, REAL__MAXIMUM);
		createEAttribute(realEClass, REAL__MINIMUM);

		floatingPointEClass = createEClass(FLOATING_POINT);
		createEAttribute(floatingPointEClass, FLOATING_POINT__OVERFLOW);
		createEAttribute(floatingPointEClass, FLOATING_POINT__ROUNDING);
		createEAttribute(floatingPointEClass, FLOATING_POINT__EXPONENT_BITS);
		createEAttribute(floatingPointEClass, FLOATING_POINT__MANTISSA_BITS);

		validationEClass = createEClass(VALIDATION);
		createEReference(validationEClass,
			VALIDATION__BASE_INSTANCE_SPECIFICATION);
		createEAttribute(validationEClass, VALIDATION__VALIDATE);

		validationsEClass = createEClass(VALIDATIONS);
		createEReference(validationsEClass, VALIDATIONS__BASE_PACKAGE);
		createEAttribute(validationsEClass, VALIDATIONS__VALIDATE);

		// Create enums
		overflowEEnum = createEEnum(OVERFLOW);
		roundingEEnum = createEEnum(ROUNDING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage) EPackage.Registry.INSTANCE
			.getEPackage(UMLPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE
			.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		boundedIntegerEClass.getESuperTypes().add(this.getInteger());
		fixedPointEClass.getESuperTypes().add(this.getReal());
		floatingPointEClass.getESuperTypes().add(this.getReal());

		// Initialize classes, features, and operations; add parameters
		initEClass(boundedIntegerEClass, BoundedInteger.class, "BoundedInteger", //$NON-NLS-1$
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBoundedInteger_Overflow(), this.getOverflow(),
			"overflow", "invalid", 0, 1, BoundedInteger.class, !IS_TRANSIENT, //$NON-NLS-1$//$NON-NLS-2$
			!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);

		initEClass(integerEClass,
			org.eclipse.ocl.pivot.uml.ocl4uml.Integer.class, "Integer", //$NON-NLS-1$
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInteger_Base_DataType(), theUMLPackage.getDataType(),
			null, "base_DataType", null, 1, 1, //$NON-NLS-1$
			org.eclipse.ocl.pivot.uml.ocl4uml.Integer.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInteger_Maximum(), theTypesPackage.getInteger(),
			"maximum", null, 0, 1, //$NON-NLS-1$
			org.eclipse.ocl.pivot.uml.ocl4uml.Integer.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInteger_Minimum(), theTypesPackage.getInteger(),
			"minimum", null, 0, 1, //$NON-NLS-1$
			org.eclipse.ocl.pivot.uml.ocl4uml.Integer.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);

		initEClass(collectionEClass, Collection.class, "Collection", //$NON-NLS-1$
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollection_Base_TypedElement(),
			theUMLPackage.getTypedElement(), null, "base_TypedElement", null, 1, //$NON-NLS-1$
			1, Collection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCollection_IsNullFree(), theTypesPackage.getBoolean(),
			"isNullFree", "false", 0, 1, Collection.class, !IS_TRANSIENT, //$NON-NLS-1$//$NON-NLS-2$
			!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);

		initEClass(collectionsEClass, Collections.class, "Collections", //$NON-NLS-1$
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollections_Base_Class(), theUMLPackage.getClass_(),
			null, "base_Class", null, 0, 1, Collections.class, !IS_TRANSIENT, //$NON-NLS-1$
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollections_Base_Package(),
			theUMLPackage.getPackage(), null, "base_Package", null, 0, 1, //$NON-NLS-1$
			Collections.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCollections_IsNullFree(),
			theTypesPackage.getBoolean(), "isNullFree", "false", 0, 1, //$NON-NLS-1$//$NON-NLS-2$
			Collections.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fixedPointEClass, FixedPoint.class, "FixedPoint", //$NON-NLS-1$
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFixedPoint_BitTrue(), theTypesPackage.getBoolean(),
			"bitTrue", "false", 0, 1, FixedPoint.class, !IS_TRANSIENT, //$NON-NLS-1$//$NON-NLS-2$
			!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFixedPoint_FractionalBits(),
			theTypesPackage.getInteger(), "fractionalBits", null, 0, 1, //$NON-NLS-1$
			FixedPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFixedPoint_IntegerBits(),
			theTypesPackage.getInteger(), "integerBits", null, 0, 1, //$NON-NLS-1$
			FixedPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFixedPoint_Overflow(), this.getOverflow(), "overflow", //$NON-NLS-1$
			"invalid", 0, 1, FixedPoint.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
			IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
			!IS_ORDERED);
		initEAttribute(getFixedPoint_Rounding(), this.getRounding(), "rounding", //$NON-NLS-1$
			"nearest", 0, 1, FixedPoint.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
			IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
			!IS_ORDERED);

		initEClass(realEClass, Real.class, "Real", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReal_Base_DataType(), theUMLPackage.getDataType(),
			null, "base_DataType", null, 1, 1, Real.class, !IS_TRANSIENT, //$NON-NLS-1$
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getReal_Epsilon(), theTypesPackage.getReal(), "epsilon", //$NON-NLS-1$
			null, 0, 1, Real.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getReal_Maximum(), theTypesPackage.getReal(), "maximum", //$NON-NLS-1$
			null, 0, 1, Real.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getReal_Minimum(), theTypesPackage.getReal(), "minimum", //$NON-NLS-1$
			null, 0, 1, Real.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(floatingPointEClass, FloatingPoint.class, "FloatingPoint", //$NON-NLS-1$
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFloatingPoint_Overflow(), this.getOverflow(),
			"overflow", "invalid", 0, 1, FloatingPoint.class, !IS_TRANSIENT, //$NON-NLS-1$//$NON-NLS-2$
			!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFloatingPoint_Rounding(), this.getRounding(),
			"rounding", "nearest", 0, 1, FloatingPoint.class, !IS_TRANSIENT, //$NON-NLS-1$//$NON-NLS-2$
			!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFloatingPoint_ExponentBits(),
			theTypesPackage.getInteger(), "exponentBits", null, 0, 1, //$NON-NLS-1$
			FloatingPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFloatingPoint_MantissaBits(),
			theTypesPackage.getInteger(), "mantissaBits", null, 0, 1, //$NON-NLS-1$
			FloatingPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(validationEClass, Validation.class, "Validation", //$NON-NLS-1$
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValidation_Base_InstanceSpecification(),
			theUMLPackage.getInstanceSpecification(), null,
			"base_InstanceSpecification", null, 1, 1, Validation.class, //$NON-NLS-1$
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			!IS_ORDERED);
		initEAttribute(getValidation_Validate(), theTypesPackage.getBoolean(),
			"validate", "false", 0, 1, Validation.class, !IS_TRANSIENT, //$NON-NLS-1$//$NON-NLS-2$
			!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);

		initEClass(validationsEClass, Validations.class, "Validations", //$NON-NLS-1$
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValidations_Base_Package(),
			theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, //$NON-NLS-1$
			Validations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);
		initEAttribute(getValidations_Validate(), theTypesPackage.getBoolean(),
			"validate", "false", 0, 1, Validations.class, !IS_TRANSIENT, //$NON-NLS-1$//$NON-NLS-2$
			!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(overflowEEnum, Overflow.class, "Overflow"); //$NON-NLS-1$
		addEEnumLiteral(overflowEEnum, Overflow.INVALID);
		addEEnumLiteral(overflowEEnum, Overflow.SATURATE);
		addEEnumLiteral(overflowEEnum, Overflow.MODULO);

		initEEnum(roundingEEnum, Rounding.class, "Rounding"); //$NON-NLS-1$
		addEEnumLiteral(roundingEEnum, Rounding.NEAREST);
		addEEnumLiteral(roundingEEnum, Rounding.CEILING);
		addEEnumLiteral(roundingEEnum, Rounding.FLOOR);
		addEEnumLiteral(roundingEEnum, Rounding.CONGRUENT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML"; //$NON-NLS-1$	
		addAnnotation(this, source, new String[]{"originalName", "OCLforUML" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

} //OCL4UMLPackageImpl
