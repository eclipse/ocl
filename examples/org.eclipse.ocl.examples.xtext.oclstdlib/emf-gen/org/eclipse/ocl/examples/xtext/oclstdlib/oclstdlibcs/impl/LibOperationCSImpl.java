/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.util.OCLstdlibCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lib Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibOperationCSImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibOperationCSImpl#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibOperationCSImpl#isInvalidating <em>Invalidating</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibOperationCSImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibOperationCSImpl#isValidating <em>Validating</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibOperationCSImpl
		extends OperationCSImpl
		implements LibOperationCS {

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected JavaClassCS implementation;

	/**
	 * The cached value of the '{@link #getPrecedence() <em>Precedence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecedence()
	 * @generated
	 * @ordered
	 */
	protected Precedence precedence;

	/**
	 * The default value of the '{@link #isInvalidating() <em>Invalidating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInvalidating()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INVALIDATING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInvalidating() <em>Invalidating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInvalidating()
	 * @generated
	 * @ordered
	 */
	protected boolean invalidating = INVALIDATING_EDEFAULT;

	/**
	 * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean static_ = STATIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isValidating() <em>Validating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidating()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALIDATING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValidating() <em>Validating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidating()
	 * @generated
	 * @ordered
	 */
	protected boolean validating = VALIDATING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibOperationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLstdlibCSPackage.Literals.LIB_OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaClassCS getImplementation() {
		if (implementation != null && implementation.eIsProxy())
		{
			InternalEObject oldImplementation = (InternalEObject)implementation;
			implementation = (JavaClassCS)eResolveProxy(oldImplementation);
			if (implementation != oldImplementation)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OCLstdlibCSPackage.LIB_OPERATION_CS__IMPLEMENTATION, oldImplementation, implementation));
			}
		}
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaClassCS basicGetImplementation()
	{
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(JavaClassCS newImplementation)
	{
		JavaClassCS oldImplementation = implementation;
		implementation = newImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSPackage.LIB_OPERATION_CS__IMPLEMENTATION, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Precedence getPrecedence() {
		if (precedence != null && ((EObject)precedence).eIsProxy())
		{
			InternalEObject oldPrecedence = (InternalEObject)precedence;
			precedence = (Precedence)eResolveProxy(oldPrecedence);
			if (precedence != oldPrecedence)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OCLstdlibCSPackage.LIB_OPERATION_CS__PRECEDENCE, oldPrecedence, precedence));
			}
		}
		return precedence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Precedence basicGetPrecedence() {
		return precedence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecedence(Precedence newPrecedence) {
		Precedence oldPrecedence = precedence;
		precedence = newPrecedence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSPackage.LIB_OPERATION_CS__PRECEDENCE, oldPrecedence, precedence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInvalidating()
	{
		return invalidating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvalidating(boolean newInvalidating)
	{
		boolean oldInvalidating = invalidating;
		invalidating = newInvalidating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSPackage.LIB_OPERATION_CS__INVALIDATING, oldInvalidating, invalidating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStatic() {
		return static_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatic(boolean newStatic) {
		boolean oldStatic = static_;
		static_ = newStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSPackage.LIB_OPERATION_CS__STATIC, oldStatic, static_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValidating()
	{
		return validating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidating(boolean newValidating)
	{
		boolean oldValidating = validating;
		validating = newValidating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSPackage.LIB_OPERATION_CS__VALIDATING, oldValidating, validating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case OCLstdlibCSPackage.LIB_OPERATION_CS__IMPLEMENTATION:
				if (resolve) return getImplementation();
				return basicGetImplementation();
			case OCLstdlibCSPackage.LIB_OPERATION_CS__PRECEDENCE:
				if (resolve) return getPrecedence();
				return basicGetPrecedence();
			case OCLstdlibCSPackage.LIB_OPERATION_CS__INVALIDATING:
				return isInvalidating();
			case OCLstdlibCSPackage.LIB_OPERATION_CS__STATIC:
				return isStatic();
			case OCLstdlibCSPackage.LIB_OPERATION_CS__VALIDATING:
				return isValidating();
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
		switch (featureID)
		{
			case OCLstdlibCSPackage.LIB_OPERATION_CS__IMPLEMENTATION:
				setImplementation((JavaClassCS)newValue);
				return;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__PRECEDENCE:
				setPrecedence((Precedence)newValue);
				return;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__INVALIDATING:
				setInvalidating((Boolean)newValue);
				return;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__STATIC:
				setStatic((Boolean)newValue);
				return;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__VALIDATING:
				setValidating((Boolean)newValue);
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
		switch (featureID)
		{
			case OCLstdlibCSPackage.LIB_OPERATION_CS__IMPLEMENTATION:
				setImplementation((JavaClassCS)null);
				return;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__PRECEDENCE:
				setPrecedence((Precedence)null);
				return;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__INVALIDATING:
				setInvalidating(INVALIDATING_EDEFAULT);
				return;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__VALIDATING:
				setValidating(VALIDATING_EDEFAULT);
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
		switch (featureID)
		{
			case OCLstdlibCSPackage.LIB_OPERATION_CS__IMPLEMENTATION:
				return implementation != null;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__PRECEDENCE:
				return precedence != null;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__INVALIDATING:
				return invalidating != INVALIDATING_EDEFAULT;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__STATIC:
				return static_ != STATIC_EDEFAULT;
			case OCLstdlibCSPackage.LIB_OPERATION_CS__VALIDATING:
				return validating != VALIDATING_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == JavaImplementationCS.class)
		{
			switch (derivedFeatureID)
			{
				case OCLstdlibCSPackage.LIB_OPERATION_CS__IMPLEMENTATION: return OCLstdlibCSPackage.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == JavaImplementationCS.class)
		{
			switch (baseFeatureID)
			{
				case OCLstdlibCSPackage.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION: return OCLstdlibCSPackage.LIB_OPERATION_CS__IMPLEMENTATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((OCLstdlibCSVisitor<?>)visitor).visitLibOperationCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}
} //LibOperationCSImpl
