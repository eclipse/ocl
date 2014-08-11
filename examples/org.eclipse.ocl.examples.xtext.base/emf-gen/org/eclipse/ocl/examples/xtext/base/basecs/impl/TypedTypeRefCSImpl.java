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
package org.eclipse.ocl.examples.xtext.base.basecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Type Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedTypeRefCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedTypeRefCSImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedTypeRefCSImpl#getOwnedTemplateBinding <em>Owned Template Binding</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedTypeRefCSImpl#isTypeof <em>Typeof</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypedTypeRefCSImpl extends TypedRefCSImpl implements TypedTypeRefCS {
	/**
	 * The cached value of the '{@link #getPathName() <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS pathName;
	/**
	 * The cached value of the '{@link #getOwnedTemplateBinding() <em>Owned Template Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTemplateBinding()
	 * @generated
	 * @ordered
	 */
	protected TemplateBindingCS ownedTemplateBinding;

	/**
	 * The default value of the '{@link #isTypeof() <em>Typeof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypeof()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TYPEOF_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isTypeof() <em>Typeof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypeof()
	 * @generated
	 * @ordered
	 */
	protected boolean typeof = TYPEOF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedTypeRefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSPackage.Literals.TYPED_TYPE_REF_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getPathName()
	{
		return pathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathName(PathNameCS newPathName, NotificationChain msgs)
	{
		PathNameCS oldPathName = pathName;
		pathName = newPathName;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPED_TYPE_REF_CS__PATH_NAME, oldPathName, newPathName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathName(PathNameCS newPathName)
	{
		if (newPathName != pathName)
		{
			NotificationChain msgs = null;
			if (pathName != null)
				msgs = ((InternalEObject)pathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.TYPED_TYPE_REF_CS__PATH_NAME, null, msgs);
			if (newPathName != null)
				msgs = ((InternalEObject)newPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.TYPED_TYPE_REF_CS__PATH_NAME, null, msgs);
			msgs = basicSetPathName(newPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPED_TYPE_REF_CS__PATH_NAME, newPathName, newPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBindingCS getOwnedTemplateBinding()
	{
		return ownedTemplateBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedTemplateBinding(TemplateBindingCS newOwnedTemplateBinding, NotificationChain msgs)
	{
		TemplateBindingCS oldOwnedTemplateBinding = ownedTemplateBinding;
		ownedTemplateBinding = newOwnedTemplateBinding;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING, oldOwnedTemplateBinding, newOwnedTemplateBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedTemplateBinding(TemplateBindingCS newOwnedTemplateBinding)
	{
		if (newOwnedTemplateBinding != ownedTemplateBinding)
		{
			NotificationChain msgs = null;
			if (ownedTemplateBinding != null)
				msgs = ((InternalEObject)ownedTemplateBinding).eInverseRemove(this, BaseCSPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT, TemplateBindingCS.class, msgs);
			if (newOwnedTemplateBinding != null)
				msgs = ((InternalEObject)newOwnedTemplateBinding).eInverseAdd(this, BaseCSPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT, TemplateBindingCS.class, msgs);
			msgs = basicSetOwnedTemplateBinding(newOwnedTemplateBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING, newOwnedTemplateBinding, newOwnedTemplateBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTypeof()
	{
		return typeof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeof(boolean newTypeof)
	{
		boolean oldTypeof = typeof;
		typeof = newTypeof;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPED_TYPE_REF_CS__TYPEOF, oldTypeof, typeof));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString()
	{
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case BaseCSPackage.TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				if (ownedTemplateBinding != null)
					msgs = ((InternalEObject)ownedTemplateBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING, null, msgs);
				return basicSetOwnedTemplateBinding((TemplateBindingCS)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case BaseCSPackage.TYPED_TYPE_REF_CS__PATH_NAME:
				return basicSetPathName(null, msgs);
			case BaseCSPackage.TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				return basicSetOwnedTemplateBinding(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case BaseCSPackage.TYPED_TYPE_REF_CS__PATH_NAME:
				return getPathName();
			case BaseCSPackage.TYPED_TYPE_REF_CS__TYPE:
				return getType();
			case BaseCSPackage.TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				return getOwnedTemplateBinding();
			case BaseCSPackage.TYPED_TYPE_REF_CS__TYPEOF:
				return isTypeof();
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
			case BaseCSPackage.TYPED_TYPE_REF_CS__PATH_NAME:
				setPathName((PathNameCS)newValue);
				return;
			case BaseCSPackage.TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				setOwnedTemplateBinding((TemplateBindingCS)newValue);
				return;
			case BaseCSPackage.TYPED_TYPE_REF_CS__TYPEOF:
				setTypeof((Boolean)newValue);
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
			case BaseCSPackage.TYPED_TYPE_REF_CS__PATH_NAME:
				setPathName((PathNameCS)null);
				return;
			case BaseCSPackage.TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				setOwnedTemplateBinding((TemplateBindingCS)null);
				return;
			case BaseCSPackage.TYPED_TYPE_REF_CS__TYPEOF:
				setTypeof(TYPEOF_EDEFAULT);
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
			case BaseCSPackage.TYPED_TYPE_REF_CS__PATH_NAME:
				return pathName != null;
			case BaseCSPackage.TYPED_TYPE_REF_CS__TYPE:
				return getType() != null;
			case BaseCSPackage.TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				return ownedTemplateBinding != null;
			case BaseCSPackage.TYPED_TYPE_REF_CS__TYPEOF:
				return typeof != TYPEOF_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitTypedTypeRefCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Type getType() {
		if (pathName == null) {
			return null;
		}
		return (Type) pathName.getElement();
	}
} //TypedTypeRefCSImpl
