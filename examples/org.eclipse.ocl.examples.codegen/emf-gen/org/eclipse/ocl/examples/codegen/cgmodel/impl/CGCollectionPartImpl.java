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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Collection Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCollectionPartImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCollectionPartImpl#getLast <em>Last</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCollectionPartImpl#getCollectionExp <em>Collection Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGCollectionPartImpl extends CGValuedElementImpl implements CGCollectionPart {
	/**
	 * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirst()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement first;

	/**
	 * The cached value of the '{@link #getLast() <em>Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLast()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement last;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGCollectionPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGModelPackage.Literals.CG_COLLECTION_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGValuedElement getFirst() {
		return first;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirst(CGValuedElement newFirst, NotificationChain msgs) {
		CGValuedElement oldFirst = first;
		first = newFirst;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_COLLECTION_PART__FIRST, oldFirst, newFirst);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirst(CGValuedElement newFirst) {
		if (newFirst != first) {
			NotificationChain msgs = null;
			if (first != null)
				msgs = ((InternalEObject)first).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_COLLECTION_PART__FIRST, null, msgs);
			if (newFirst != null)
				msgs = ((InternalEObject)newFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_COLLECTION_PART__FIRST, null, msgs);
			msgs = basicSetFirst(newFirst, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_COLLECTION_PART__FIRST, newFirst, newFirst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGValuedElement getLast() {
		return last;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLast(CGValuedElement newLast, NotificationChain msgs) {
		CGValuedElement oldLast = last;
		last = newLast;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_COLLECTION_PART__LAST, oldLast, newLast);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLast(CGValuedElement newLast) {
		if (newLast != last) {
			NotificationChain msgs = null;
			if (last != null)
				msgs = ((InternalEObject)last).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_COLLECTION_PART__LAST, null, msgs);
			if (newLast != null)
				msgs = ((InternalEObject)newLast).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_COLLECTION_PART__LAST, null, msgs);
			msgs = basicSetLast(newLast, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_COLLECTION_PART__LAST, newLast, newLast));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGCollectionExp getCollectionExp() {
		if (eContainerFeatureID() != CGModelPackage.CG_COLLECTION_PART__COLLECTION_EXP) return null;
		return (CGCollectionExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CGModelPackage.CG_COLLECTION_PART__COLLECTION_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, CGModelPackage.CG_COLLECTION_PART__COLLECTION_EXP, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CGModelPackage.CG_COLLECTION_PART__FIRST:
				return basicSetFirst(null, msgs);
			case CGModelPackage.CG_COLLECTION_PART__LAST:
				return basicSetLast(null, msgs);
			case CGModelPackage.CG_COLLECTION_PART__COLLECTION_EXP:
				return eBasicSetContainer(null, CGModelPackage.CG_COLLECTION_PART__COLLECTION_EXP, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CGModelPackage.CG_COLLECTION_PART__COLLECTION_EXP:
				return eInternalContainer().eInverseRemove(this, CGModelPackage.CG_COLLECTION_EXP__PARTS, CGCollectionExp.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CGModelPackage.CG_COLLECTION_PART__FIRST:
				return getFirst();
			case CGModelPackage.CG_COLLECTION_PART__LAST:
				return getLast();
			case CGModelPackage.CG_COLLECTION_PART__COLLECTION_EXP:
				return getCollectionExp();
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
			case CGModelPackage.CG_COLLECTION_PART__FIRST:
				setFirst((CGValuedElement)newValue);
				return;
			case CGModelPackage.CG_COLLECTION_PART__LAST:
				setLast((CGValuedElement)newValue);
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
			case CGModelPackage.CG_COLLECTION_PART__FIRST:
				setFirst((CGValuedElement)null);
				return;
			case CGModelPackage.CG_COLLECTION_PART__LAST:
				setLast((CGValuedElement)null);
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
			case CGModelPackage.CG_COLLECTION_PART__FIRST:
				return first != null;
			case CGModelPackage.CG_COLLECTION_PART__LAST:
				return last != null;
			case CGModelPackage.CG_COLLECTION_PART__COLLECTION_EXP:
				return getCollectionExp() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return visitor.visitCGCollectionPart(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @NonNull CGValuedElement getReferredValuedElement() {
		CGValuedElement first2 = first;
		if (first2 != null) {
			if (first2.isInvalid()) {
				return first2;
			}
			CGValuedElement last2 = last;
			if (last2 != null) {
				if (last2.isInvalid()) {
					return last2;
				}
			}
			else {
				return first2;
			}
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isBoxed() {
		return isRange() || first.isBoxed();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isConstant() {
		return first.isConstant() && ((last == null) || last.isConstant());
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isGlobal() {
		return first.isGlobal() && ((last == null) || last.isGlobal());
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isInvalid() {
		return first.isInvalid() || ((last != null) && last.isInvalid());
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isNonInvalid() {
		return first.isNonInvalid() && ((last == null) || last.isNonInvalid());
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isNonNull() {
		return first.isNonNull() || ((last != null) && last.isNonNull());
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isNull() {
		return first.isNull() && (last == null);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isRange() {
		return last != null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isUnboxed() {
		return isRange() || first.isUnboxed();
	}

} //CGCollectionPartImpl
