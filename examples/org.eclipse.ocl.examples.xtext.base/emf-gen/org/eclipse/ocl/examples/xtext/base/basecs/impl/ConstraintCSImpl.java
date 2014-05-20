/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.basecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ConstraintCSImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ConstraintCSImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ConstraintCSImpl#getMessageSpecification <em>Message Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintCSImpl extends NamedElementCSImpl implements ConstraintCS
{
	/**
	 * The default value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected String stereotype = STEREOTYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected SpecificationCS specification;

	/**
	 * The cached value of the '{@link #getMessageSpecification() <em>Message Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageSpecification()
	 * @generated
	 * @ordered
	 */
	protected SpecificationCS messageSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintCSImpl()
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
		return BaseCSPackage.Literals.CONSTRAINT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStereotype()
	{
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(String newStereotype)
	{
		String oldStereotype = stereotype;
		stereotype = newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.CONSTRAINT_CS__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificationCS getSpecification()
	{
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification(SpecificationCS newSpecification, NotificationChain msgs)
	{
		SpecificationCS oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSPackage.CONSTRAINT_CS__SPECIFICATION, oldSpecification, newSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(SpecificationCS newSpecification)
	{
		if (newSpecification != specification)
		{
			NotificationChain msgs = null;
			if (specification != null)
				msgs = ((InternalEObject)specification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.CONSTRAINT_CS__SPECIFICATION, null, msgs);
			if (newSpecification != null)
				msgs = ((InternalEObject)newSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.CONSTRAINT_CS__SPECIFICATION, null, msgs);
			msgs = basicSetSpecification(newSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.CONSTRAINT_CS__SPECIFICATION, newSpecification, newSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificationCS getMessageSpecification()
	{
		return messageSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMessageSpecification(SpecificationCS newMessageSpecification, NotificationChain msgs)
	{
		SpecificationCS oldMessageSpecification = messageSpecification;
		messageSpecification = newMessageSpecification;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION, oldMessageSpecification, newMessageSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageSpecification(SpecificationCS newMessageSpecification)
	{
		if (newMessageSpecification != messageSpecification)
		{
			NotificationChain msgs = null;
			if (messageSpecification != null)
				msgs = ((InternalEObject)messageSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION, null, msgs);
			if (newMessageSpecification != null)
				msgs = ((InternalEObject)newMessageSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION, null, msgs);
			msgs = basicSetMessageSpecification(newMessageSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION, newMessageSpecification, newMessageSpecification));
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
			case BaseCSPackage.CONSTRAINT_CS__SPECIFICATION:
				return basicSetSpecification(null, msgs);
			case BaseCSPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION:
				return basicSetMessageSpecification(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case BaseCSPackage.CONSTRAINT_CS__STEREOTYPE:
				return getStereotype();
			case BaseCSPackage.CONSTRAINT_CS__SPECIFICATION:
				return getSpecification();
			case BaseCSPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION:
				return getMessageSpecification();
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
			case BaseCSPackage.CONSTRAINT_CS__STEREOTYPE:
				setStereotype((String)newValue);
				return;
			case BaseCSPackage.CONSTRAINT_CS__SPECIFICATION:
				setSpecification((SpecificationCS)newValue);
				return;
			case BaseCSPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION:
				setMessageSpecification((SpecificationCS)newValue);
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
			case BaseCSPackage.CONSTRAINT_CS__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case BaseCSPackage.CONSTRAINT_CS__SPECIFICATION:
				setSpecification((SpecificationCS)null);
				return;
			case BaseCSPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION:
				setMessageSpecification((SpecificationCS)null);
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
			case BaseCSPackage.CONSTRAINT_CS__STEREOTYPE:
				return STEREOTYPE_EDEFAULT == null ? stereotype != null : !STEREOTYPE_EDEFAULT.equals(stereotype);
			case BaseCSPackage.CONSTRAINT_CS__SPECIFICATION:
				return specification != null;
			case BaseCSPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION:
				return messageSpecification != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitConstraintCS(this);
	}
} //ConstraintCSImpl
