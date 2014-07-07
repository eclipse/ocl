/**
 * <copyright>
 * 
 * Copyright (c) 2014 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	 Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.autogen.nameresocgmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Env Visit If Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitIfPartImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitIfPartImpl#getEnvExpression <em>Env Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGEnvVisitIfPartImpl extends CGValuedElementImpl implements CGEnvVisitIfPart {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected String propertyName = PROPERTY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnvExpression() <em>Env Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvExpression()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement envExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGEnvVisitIfPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NameResoCGModelPackage.Literals.CG_ENV_VISIT_IF_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyName(String newPropertyName) {
		String oldPropertyName = propertyName;
		propertyName = newPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__PROPERTY_NAME, oldPropertyName, propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGValuedElement getEnvExpression() {
		return envExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnvExpression(CGValuedElement newEnvExpression, NotificationChain msgs) {
		CGValuedElement oldEnvExpression = envExpression;
		envExpression = newEnvExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__ENV_EXPRESSION, oldEnvExpression, newEnvExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnvExpression(CGValuedElement newEnvExpression) {
		if (newEnvExpression != envExpression) {
			NotificationChain msgs = null;
			if (envExpression != null)
				msgs = ((InternalEObject)envExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__ENV_EXPRESSION, null, msgs);
			if (newEnvExpression != null)
				msgs = ((InternalEObject)newEnvExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__ENV_EXPRESSION, null, msgs);
			msgs = basicSetEnvExpression(newEnvExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__ENV_EXPRESSION, newEnvExpression, newEnvExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__ENV_EXPRESSION:
				return basicSetEnvExpression(null, msgs);
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
		switch (featureID) {
			case NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__PROPERTY_NAME:
				return getPropertyName();
			case NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__ENV_EXPRESSION:
				return getEnvExpression();
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
			case NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__PROPERTY_NAME:
				setPropertyName((String)newValue);
				return;
			case NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__ENV_EXPRESSION:
				setEnvExpression((CGValuedElement)newValue);
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
			case NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_EDEFAULT);
				return;
			case NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__ENV_EXPRESSION:
				setEnvExpression((CGValuedElement)null);
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
			case NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__PROPERTY_NAME:
				return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
			case NameResoCGModelPackage.CG_ENV_VISIT_IF_PART__ENV_EXPRESSION:
				return envExpression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return (R) ((NameResoCGModelVisitor<?>)visitor).visitCGEnvVisitIfPart(this);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
	}


	//FIXME ADOLFOSSBH Why is this not generated ?
	public @Nullable Boolean isEquivalentToInternal(@NonNull CGValuedElement thatValue) {
		throw new UnsupportedOperationException(getClass().getName() + ".isEquivalentToInternal()");
	}
} //CGEnvVisitIfPartImpl
