/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink (CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Profile;
import org.eclipse.ocl.examples.pivot.ProfileApplication;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ProfileApplicationImpl#getAppliedProfile <em>Applied Profile</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ProfileApplicationImpl#getApplyingPackage <em>Applying Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ProfileApplicationImpl#isStrict <em>Is Strict</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfileApplicationImpl extends ElementImpl implements ProfileApplication
{
	/**
	 * The cached value of the '{@link #getAppliedProfile() <em>Applied Profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliedProfile()
	 * @generated
	 * @ordered
	 */
	protected Profile appliedProfile;

	/**
	 * The default value of the '{@link #isStrict() <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrict()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STRICT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isStrict() <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrict()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_STRICT_EFLAG = 1 << 8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfileApplicationImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.PROFILE_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Profile getAppliedProfile()
	{
		if (appliedProfile != null && ((EObject)appliedProfile).eIsProxy())
		{
			InternalEObject oldAppliedProfile = (InternalEObject)appliedProfile;
			appliedProfile = (Profile)eResolveProxy(oldAppliedProfile);
			if (appliedProfile != oldAppliedProfile)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PROFILE_APPLICATION__APPLIED_PROFILE, oldAppliedProfile, appliedProfile));
			}
		}
		return appliedProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Profile basicGetAppliedProfile()
	{
		return appliedProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAppliedProfile(Profile newAppliedProfile, NotificationChain msgs)
	{
		Profile oldAppliedProfile = appliedProfile;
		appliedProfile = newAppliedProfile;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.PROFILE_APPLICATION__APPLIED_PROFILE, oldAppliedProfile, newAppliedProfile);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedProfile(Profile newAppliedProfile)
	{
		if (newAppliedProfile != appliedProfile)
		{
			NotificationChain msgs = null;
			if (appliedProfile != null)
				msgs = ((InternalEObject)appliedProfile).eInverseRemove(this, PivotPackage.PROFILE__APPLICATION, Profile.class, msgs);
			if (newAppliedProfile != null)
				msgs = ((InternalEObject)newAppliedProfile).eInverseAdd(this, PivotPackage.PROFILE__APPLICATION, Profile.class, msgs);
			msgs = basicSetAppliedProfile(newAppliedProfile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROFILE_APPLICATION__APPLIED_PROFILE, newAppliedProfile, newAppliedProfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Package getApplyingPackage()
	{
		if (eContainerFeatureID() != PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE) return null;
		return (org.eclipse.ocl.examples.pivot.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplyingPackage(org.eclipse.ocl.examples.pivot.Package newApplyingPackage, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newApplyingPackage, PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("cast")
	public void setApplyingPackage(org.eclipse.ocl.examples.pivot.Package newApplyingPackage)
	{
		if (newApplyingPackage != eInternalContainer() || (eContainerFeatureID() != PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE && newApplyingPackage != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newApplyingPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newApplyingPackage != null)
				msgs = ((InternalEObject)newApplyingPackage).eInverseAdd(this, PivotPackage.PACKAGE__PROFILE_APPLICATION, org.eclipse.ocl.examples.pivot.Package.class, msgs);
			msgs = basicSetApplyingPackage(newApplyingPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE, newApplyingPackage, newApplyingPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStrict()
	{
		return (eFlags & IS_STRICT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStrict(boolean newIsStrict)
	{
		boolean oldIsStrict = (eFlags & IS_STRICT_EFLAG) != 0;
		if (newIsStrict) eFlags |= IS_STRICT_EFLAG; else eFlags &= ~IS_STRICT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROFILE_APPLICATION__IS_STRICT, oldIsStrict, newIsStrict));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.PROFILE_APPLICATION__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.PROFILE_APPLICATION__APPLIED_PROFILE:
				if (appliedProfile != null)
					msgs = ((InternalEObject)appliedProfile).eInverseRemove(this, PivotPackage.PROFILE__APPLICATION, Profile.class, msgs);
				return basicSetAppliedProfile((Profile)otherEnd, msgs);
			case PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetApplyingPackage((org.eclipse.ocl.examples.pivot.Package)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.PROFILE_APPLICATION__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROFILE_APPLICATION__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROFILE_APPLICATION__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROFILE_APPLICATION__APPLIED_PROFILE:
				return basicSetAppliedProfile(null, msgs);
			case PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE:
				return basicSetApplyingPackage(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.PACKAGE__PROFILE_APPLICATION, org.eclipse.ocl.examples.pivot.Package.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case PivotPackage.PROFILE_APPLICATION__EXTENSION:
				return getExtension();
			case PivotPackage.PROFILE_APPLICATION__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.PROFILE_APPLICATION__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.PROFILE_APPLICATION__APPLIED_PROFILE:
				if (resolve) return getAppliedProfile();
				return basicGetAppliedProfile();
			case PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE:
				return getApplyingPackage();
			case PivotPackage.PROFILE_APPLICATION__IS_STRICT:
				return isStrict();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PivotPackage.PROFILE_APPLICATION__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.PROFILE_APPLICATION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.PROFILE_APPLICATION__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PROFILE_APPLICATION__APPLIED_PROFILE:
				setAppliedProfile((Profile)newValue);
				return;
			case PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE:
				setApplyingPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.PROFILE_APPLICATION__IS_STRICT:
				setIsStrict((Boolean)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.PROFILE_APPLICATION__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.PROFILE_APPLICATION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.PROFILE_APPLICATION__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.PROFILE_APPLICATION__APPLIED_PROFILE:
				setAppliedProfile((Profile)null);
				return;
			case PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE:
				setApplyingPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.PROFILE_APPLICATION__IS_STRICT:
				setIsStrict(IS_STRICT_EDEFAULT);
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.PROFILE_APPLICATION__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.PROFILE_APPLICATION__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.PROFILE_APPLICATION__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.PROFILE_APPLICATION__APPLIED_PROFILE:
				return appliedProfile != null;
			case PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE:
				return getApplyingPackage() != null;
			case PivotPackage.PROFILE_APPLICATION__IS_STRICT:
				return ((eFlags & IS_STRICT_EFLAG) != 0) != IS_STRICT_EDEFAULT;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitProfileApplication(this);
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //ProfileApplicationImpl
