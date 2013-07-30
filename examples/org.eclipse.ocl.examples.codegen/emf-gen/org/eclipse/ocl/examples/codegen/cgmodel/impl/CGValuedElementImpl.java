/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.cgmodel.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cse.AbstractPlace;
import org.eclipse.ocl.examples.codegen.cse.ControlPlace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Valued Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#getDependsOn <em>Depends On</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CGValuedElementImpl extends CGTypedElementImpl implements CGValuedElement {
	/**
	 * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOn()
	 * @generated
	 * @ordered
	 */
	protected EList<CGValuedElement> dependsOn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGValuedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGModelPackage.Literals.CG_VALUED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGValuedElement> getDependsOn() {
		if (dependsOn == null) {
			dependsOn = new EObjectEList<CGValuedElement>(CGValuedElement.class, this, CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON);
		}
		return dependsOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON:
				return getDependsOn();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON:
				getDependsOn().clear();
				getDependsOn().addAll((Collection<? extends CGValuedElement>)newValue);
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
			case CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON:
				getDependsOn().clear();
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
			case CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON:
				return dependsOn != null && !dependsOn.isEmpty();
		}
		return super.eIsSet(featureID);
	}


	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable AbstractPlace getPlace(@NonNull Map<CGElement,AbstractPlace> element2place) {
		return ControlPlace.createPlace(element2place, this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public @NonNull CGValuedElement getReferredValuedElement() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public @NonNull CGValuedElement getValue() {
		CGValuedElement referredValue = getReferredValuedElement();
		if (referredValue == this) {
			return this;
		}
		else {
			return referredValue.getValue();
		}
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public @Nullable String getValueName() {
		if (valueName != null) {
			return valueName;
		}
		CGValuedElement value = getValue(); // FIXME getReferredValuedElement();
		if (value != this) {
			return value.getValueName();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isBoxed() {
		CGValuedElement referredValue = getReferredValuedElement();
//		CGValuedElement value = getValue();
		assert referredValue != this : "isBoxed must be overridden for a " + getClass().getSimpleName() + " since referredValue returns this";
		return referredValue.isBoxed();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isCaught() {
		return caught;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isCommonable() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isConstant() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isConstant();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isContext() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isFalse() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isFalse();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isGlobal() {
		for (CGValuedElement cgElement : getDependsOn()) {
			if (!cgElement.isGlobal()) {
				return false;
			}
		}
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isGlobal();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isInlineable() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isInlineable();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isInvalid() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isInvalid();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isNonInvalid() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isNonInvalid();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isNonNull() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isNonNull();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isNull() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isNull();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isSettable() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isTrue() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isTrue();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isUnboxed() {
		CGValuedElement referredValue = getReferredValuedElement();
//		CGValuedElement value = getValue();
		assert referredValue != this : "isUnboxed must be overridden for a " + getClass().getSimpleName() + " since referredValue returns this";
		return referredValue.isUnboxed();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	private boolean caught = false;

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public void setCaught(boolean isCaught) {
		caught = isCaught;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	private String valueName = null;

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public void setValueName(@NonNull String valueName) {
		this.valueName = valueName;
	}

} //CGValuedElementImpl
