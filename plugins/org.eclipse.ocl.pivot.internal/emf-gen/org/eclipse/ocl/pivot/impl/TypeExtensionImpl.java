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
package org.eclipse.ocl.pivot.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExtension;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.impl.TypeExtensionImpl#isRequired <em>Is Required</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.TypeExtensionImpl#getOwningStereotype <em>Owning Stereotype</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.TypeExtensionImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeExtensionImpl extends ElementImpl implements TypeExtension
{
	/**
	 * The default value of the '{@link #isRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REQUIRED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_REQUIRED_EFLAG = 1 << 8;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeExtensionImpl()
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
		return PivotPackage.Literals.TYPE_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRequired()
	{
		return (eFlags & IS_REQUIRED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsRequired(boolean newIsRequired)
	{
		boolean oldIsRequired = (eFlags & IS_REQUIRED_EFLAG) != 0;
		if (newIsRequired) eFlags |= IS_REQUIRED_EFLAG; else eFlags &= ~IS_REQUIRED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPE_EXTENSION__IS_REQUIRED, oldIsRequired, newIsRequired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Stereotype getOwningStereotype()
	{
		if (eContainerFeatureID() != PivotPackage.TYPE_EXTENSION__OWNING_STEREOTYPE) return null;
		return (Stereotype)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningStereotype(Stereotype newOwningStereotype, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningStereotype, PivotPackage.TYPE_EXTENSION__OWNING_STEREOTYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningStereotype(Stereotype newOwningStereotype)
	{
		if (newOwningStereotype != eInternalContainer() || (eContainerFeatureID() != PivotPackage.TYPE_EXTENSION__OWNING_STEREOTYPE && newOwningStereotype != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningStereotype))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningStereotype != null)
				msgs = ((InternalEObject)newOwningStereotype).eInverseAdd(this, PivotPackage.STEREOTYPE__OWNED_EXTENSION_OFS, Stereotype.class, msgs);
			msgs = basicSetOwningStereotype(newOwningStereotype, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPE_EXTENSION__OWNING_STEREOTYPE, newOwningStereotype, newOwningStereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getType()
	{
		if (type != null && type.eIsProxy())
		{
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.TYPE_EXTENSION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(Type newType, NotificationChain msgs)
	{
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.TYPE_EXTENSION__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(Type newType)
	{
		if (newType != type)
		{
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, PivotPackage.TYPE__EXTENDED_BYS, Type.class, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, PivotPackage.TYPE__EXTENDED_BYS, Type.class, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPE_EXTENSION__TYPE, newType, newType));
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
			case PivotPackage.TYPE_EXTENSION__ANNOTATING_COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotatingComments()).basicAdd(otherEnd, msgs);
			case PivotPackage.TYPE_EXTENSION__OWNED_COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComments()).basicAdd(otherEnd, msgs);
			case PivotPackage.TYPE_EXTENSION__OWNED_EXTENSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedExtensions()).basicAdd(otherEnd, msgs);
			case PivotPackage.TYPE_EXTENSION__OWNING_STEREOTYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningStereotype((Stereotype)otherEnd, msgs);
			case PivotPackage.TYPE_EXTENSION__TYPE:
				if (type != null)
					msgs = ((InternalEObject)type).eInverseRemove(this, PivotPackage.TYPE__EXTENDED_BYS, Type.class, msgs);
				return basicSetType((Type)otherEnd, msgs);
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
			case PivotPackage.TYPE_EXTENSION__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE_EXTENSION__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE_EXTENSION__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE_EXTENSION__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.TYPE_EXTENSION__OWNING_STEREOTYPE:
				return basicSetOwningStereotype(null, msgs);
			case PivotPackage.TYPE_EXTENSION__TYPE:
				return basicSetType(null, msgs);
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
			case PivotPackage.TYPE_EXTENSION__OWNING_STEREOTYPE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.STEREOTYPE__OWNED_EXTENSION_OFS, Stereotype.class, msgs);
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
			case PivotPackage.TYPE_EXTENSION__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.TYPE_EXTENSION__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.TYPE_EXTENSION__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.TYPE_EXTENSION__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.TYPE_EXTENSION__IS_REQUIRED:
				return isRequired();
			case PivotPackage.TYPE_EXTENSION__OWNING_STEREOTYPE:
				return getOwningStereotype();
			case PivotPackage.TYPE_EXTENSION__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case PivotPackage.TYPE_EXTENSION__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPE_EXTENSION__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.TYPE_EXTENSION__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPE_EXTENSION__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.TYPE_EXTENSION__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.TYPE_EXTENSION__OWNING_STEREOTYPE:
				setOwningStereotype((Stereotype)newValue);
				return;
			case PivotPackage.TYPE_EXTENSION__TYPE:
				setType((Type)newValue);
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
			case PivotPackage.TYPE_EXTENSION__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.TYPE_EXTENSION__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.TYPE_EXTENSION__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.TYPE_EXTENSION__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.TYPE_EXTENSION__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.TYPE_EXTENSION__OWNING_STEREOTYPE:
				setOwningStereotype((Stereotype)null);
				return;
			case PivotPackage.TYPE_EXTENSION__TYPE:
				setType((Type)null);
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
			case PivotPackage.TYPE_EXTENSION__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.TYPE_EXTENSION__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.TYPE_EXTENSION__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.TYPE_EXTENSION__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.TYPE_EXTENSION__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.TYPE_EXTENSION__OWNING_STEREOTYPE:
				return getOwningStereotype() != null;
			case PivotPackage.TYPE_EXTENSION__TYPE:
				return type != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitTypeExtension(this);
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //TypeExtensionImpl
