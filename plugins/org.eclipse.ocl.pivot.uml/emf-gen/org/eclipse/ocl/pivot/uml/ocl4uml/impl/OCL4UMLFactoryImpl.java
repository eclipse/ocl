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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCL4UMLFactoryImpl
		extends EFactoryImpl
		implements OCL4UMLFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OCL4UMLFactory init() {
		try {
			OCL4UMLFactory theOCL4UMLFactory = (OCL4UMLFactory) EPackage.Registry.INSTANCE
				.getEFactory(OCL4UMLPackage.eNS_URI);
			if (theOCL4UMLFactory != null) {
				return theOCL4UMLFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OCL4UMLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCL4UMLFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OCL4UMLPackage.BOUNDED_INTEGER :
				return createBoundedInteger();
			case OCL4UMLPackage.INTEGER :
				return createInteger();
			case OCL4UMLPackage.COLLECTION :
				return createCollection();
			case OCL4UMLPackage.COLLECTIONS :
				return createCollections();
			case OCL4UMLPackage.FIXED_POINT :
				return createFixedPoint();
			case OCL4UMLPackage.REAL :
				return createReal();
			case OCL4UMLPackage.FLOATING_POINT :
				return createFloatingPoint();
			case OCL4UMLPackage.VALIDATION :
				return createValidation();
			case OCL4UMLPackage.VALIDATIONS :
				return createValidations();
			default :
				throw new IllegalArgumentException("The class '" //$NON-NLS-1$
					+ eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OCL4UMLPackage.OVERFLOW :
				return createOverflowFromString(eDataType, initialValue);
			case OCL4UMLPackage.ROUNDING :
				return createRoundingFromString(eDataType, initialValue);
			default :
				throw new IllegalArgumentException("The datatype '" //$NON-NLS-1$
					+ eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OCL4UMLPackage.OVERFLOW :
				return convertOverflowToString(eDataType, instanceValue);
			case OCL4UMLPackage.ROUNDING :
				return convertRoundingToString(eDataType, instanceValue);
			default :
				throw new IllegalArgumentException("The datatype '" //$NON-NLS-1$
					+ eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BoundedInteger createBoundedInteger() {
		BoundedIntegerImpl boundedInteger = new BoundedIntegerImpl();
		return boundedInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.uml.ocl4uml.Integer createInteger() {
		IntegerImpl integer = new IntegerImpl();
		return integer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection createCollection() {
		CollectionImpl collection = new CollectionImpl();
		return collection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collections createCollections() {
		CollectionsImpl collections = new CollectionsImpl();
		return collections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FixedPoint createFixedPoint() {
		FixedPointImpl fixedPoint = new FixedPointImpl();
		return fixedPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Real createReal() {
		RealImpl real = new RealImpl();
		return real;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FloatingPoint createFloatingPoint() {
		FloatingPointImpl floatingPoint = new FloatingPointImpl();
		return floatingPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Validation createValidation() {
		ValidationImpl validation = new ValidationImpl();
		return validation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Validations createValidations() {
		ValidationsImpl validations = new ValidationsImpl();
		return validations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Overflow createOverflowFromString(EDataType eDataType,
			String initialValue) {
		Overflow result = Overflow.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue //$NON-NLS-1$
				+ "' is not a valid enumerator of '" + eDataType.getName() //$NON-NLS-1$
				+ "'"); //$NON-NLS-1$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOverflowToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null
			? null
			: instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rounding createRoundingFromString(EDataType eDataType,
			String initialValue) {
		Rounding result = Rounding.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue //$NON-NLS-1$
				+ "' is not a valid enumerator of '" + eDataType.getName() //$NON-NLS-1$
				+ "'"); //$NON-NLS-1$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRoundingToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null
			? null
			: instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCL4UMLPackage getOCL4UMLPackage() {
		return (OCL4UMLPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OCL4UMLPackage getPackage() {
		return OCL4UMLPackage.eINSTANCE;
	}

} //OCL4UMLFactoryImpl
