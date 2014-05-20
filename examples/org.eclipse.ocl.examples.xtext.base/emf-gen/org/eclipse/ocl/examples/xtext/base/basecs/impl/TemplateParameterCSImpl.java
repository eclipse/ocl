/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.basecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Parameter CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateParameterCSImpl#getOwningTemplateSignature <em>Owning Template Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TemplateParameterCSImpl extends NamedElementCSImpl implements TemplateParameterCS
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateParameterCSImpl()
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
		return BaseCSPackage.Literals.TEMPLATE_PARAMETER_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignatureCS getOwningTemplateSignature()
	{
		if (eContainerFeatureID() != BaseCSPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE) return null;
		return (TemplateSignatureCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTemplateSignature(TemplateSignatureCS newOwningTemplateSignature, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningTemplateSignature, BaseCSPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningTemplateSignature(TemplateSignatureCS newOwningTemplateSignature)
	{
		if (newOwningTemplateSignature != eInternalContainer() || (eContainerFeatureID() != BaseCSPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE && newOwningTemplateSignature != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningTemplateSignature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTemplateSignature != null)
				msgs = ((InternalEObject)newOwningTemplateSignature).eInverseAdd(this, BaseCSPackage.TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER, TemplateSignatureCS.class, msgs);
			msgs = basicSetOwningTemplateSignature(newOwningTemplateSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE, newOwningTemplateSignature, newOwningTemplateSignature));
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
			case BaseCSPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateSignature((TemplateSignatureCS)otherEnd, msgs);
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
			case BaseCSPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE:
				return basicSetOwningTemplateSignature(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case BaseCSPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE:
				return eInternalContainer().eInverseRemove(this, BaseCSPackage.TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER, TemplateSignatureCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case BaseCSPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE:
				return getOwningTemplateSignature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case BaseCSPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE:
				setOwningTemplateSignature((TemplateSignatureCS)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case BaseCSPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE:
				setOwningTemplateSignature((TemplateSignatureCS)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case BaseCSPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE:
				return getOwningTemplateSignature() != null;
		}
		return super.eIsSet(featureID);
	}
} //TemplateParameterCSImpl
