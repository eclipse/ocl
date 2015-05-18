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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage;
import org.eclipse.ocl.pivot.uml.ocl4uml.Real;

import org.eclipse.uml2.uml.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.RealImpl#getBase_DataType <em>Base Data Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.RealImpl#getEpsilon <em>Epsilon</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.RealImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.RealImpl#getMinimum <em>Minimum</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RealImpl
		extends EObjectImpl
		implements Real {

	/**
	 * The cached value of the '{@link #getBase_DataType() <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_DataType()
	 * @generated
	 * @ordered
	 */
	protected DataType base_DataType;

	/**
	 * The default value of the '{@link #getEpsilon() <em>Epsilon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEpsilon()
	 * @generated
	 * @ordered
	 */
	protected static final double EPSILON_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getEpsilon() <em>Epsilon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEpsilon()
	 * @generated
	 * @ordered
	 */
	protected double epsilon = EPSILON_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final double MAXIMUM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected double maximum = MAXIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected static final double MINIMUM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected double minimum = MINIMUM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCL4UMLPackage.Literals.REAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType getBase_DataType() {
		if (base_DataType != null && base_DataType.eIsProxy()) {
			InternalEObject oldBase_DataType = (InternalEObject) base_DataType;
			base_DataType = (DataType) eResolveProxy(oldBase_DataType);
			if (base_DataType != oldBase_DataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						OCL4UMLPackage.REAL__BASE_DATA_TYPE, oldBase_DataType,
						base_DataType));
			}
		}
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetBase_DataType() {
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_DataType(DataType newBase_DataType) {
		DataType oldBase_DataType = base_DataType;
		base_DataType = newBase_DataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OCL4UMLPackage.REAL__BASE_DATA_TYPE, oldBase_DataType,
				base_DataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEpsilon() {
		return epsilon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEpsilon(double newEpsilon) {
		double oldEpsilon = epsilon;
		epsilon = newEpsilon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OCL4UMLPackage.REAL__EPSILON, oldEpsilon, epsilon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaximum(double newMaximum) {
		double oldMaximum = maximum;
		maximum = newMaximum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OCL4UMLPackage.REAL__MAXIMUM, oldMaximum, maximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMinimum() {
		return minimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinimum(double newMinimum) {
		double oldMinimum = minimum;
		minimum = newMinimum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OCL4UMLPackage.REAL__MINIMUM, oldMinimum, minimum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OCL4UMLPackage.REAL__BASE_DATA_TYPE :
				if (resolve)
					return getBase_DataType();
				return basicGetBase_DataType();
			case OCL4UMLPackage.REAL__EPSILON :
				return getEpsilon();
			case OCL4UMLPackage.REAL__MAXIMUM :
				return getMaximum();
			case OCL4UMLPackage.REAL__MINIMUM :
				return getMinimum();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OCL4UMLPackage.REAL__BASE_DATA_TYPE :
				setBase_DataType((DataType) newValue);
				return;
			case OCL4UMLPackage.REAL__EPSILON :
				setEpsilon((Double) newValue);
				return;
			case OCL4UMLPackage.REAL__MAXIMUM :
				setMaximum((Double) newValue);
				return;
			case OCL4UMLPackage.REAL__MINIMUM :
				setMinimum((Double) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OCL4UMLPackage.REAL__BASE_DATA_TYPE :
				setBase_DataType((DataType) null);
				return;
			case OCL4UMLPackage.REAL__EPSILON :
				setEpsilon(EPSILON_EDEFAULT);
				return;
			case OCL4UMLPackage.REAL__MAXIMUM :
				setMaximum(MAXIMUM_EDEFAULT);
				return;
			case OCL4UMLPackage.REAL__MINIMUM :
				setMinimum(MINIMUM_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OCL4UMLPackage.REAL__BASE_DATA_TYPE :
				return base_DataType != null;
			case OCL4UMLPackage.REAL__EPSILON :
				return epsilon != EPSILON_EDEFAULT;
			case OCL4UMLPackage.REAL__MAXIMUM :
				return maximum != MAXIMUM_EDEFAULT;
			case OCL4UMLPackage.REAL__MINIMUM :
				return minimum != MINIMUM_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (epsilon: "); //$NON-NLS-1$
		result.append(epsilon);
		result.append(", maximum: "); //$NON-NLS-1$
		result.append(maximum);
		result.append(", minimum: "); //$NON-NLS-1$
		result.append(minimum);
		result.append(')');
		return result.toString();
	}

} //RealImpl
