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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.EnvLookupKind;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Env Visit Op</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitOpImpl#getEnvLookupPropagation <em>Env Lookup Propagation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGEnvVisitOpImpl extends CGOperationImpl implements CGEnvVisitOp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * The default value of the '{@link #getEnvLookupPropagation() <em>Env Lookup Propagation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvLookupPropagation()
	 * @generated
	 * @ordered
	 */
	protected static final EnvLookupKind ENV_LOOKUP_PROPAGATION_EDEFAULT = EnvLookupKind.LOOKUP_ONLY_LOCAL;
	/**
	 * The cached value of the '{@link #getEnvLookupPropagation() <em>Env Lookup Propagation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvLookupPropagation()
	 * @generated
	 * @ordered
	 */
	protected EnvLookupKind envLookupPropagation = ENV_LOOKUP_PROPAGATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGEnvVisitOpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NameResoCGModelPackage.Literals.CG_ENV_VISIT_OP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvLookupKind getEnvLookupPropagation() {
		return envLookupPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnvLookupPropagation(EnvLookupKind newEnvLookupPropagation) {
		EnvLookupKind oldEnvLookupPropagation = envLookupPropagation;
		envLookupPropagation = newEnvLookupPropagation == null ? ENV_LOOKUP_PROPAGATION_EDEFAULT : newEnvLookupPropagation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NameResoCGModelPackage.CG_ENV_VISIT_OP__ENV_LOOKUP_PROPAGATION, oldEnvLookupPropagation, envLookupPropagation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NameResoCGModelPackage.CG_ENV_VISIT_OP__ENV_LOOKUP_PROPAGATION:
				return getEnvLookupPropagation();
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
			case NameResoCGModelPackage.CG_ENV_VISIT_OP__ENV_LOOKUP_PROPAGATION:
				setEnvLookupPropagation((EnvLookupKind)newValue);
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
			case NameResoCGModelPackage.CG_ENV_VISIT_OP__ENV_LOOKUP_PROPAGATION:
				setEnvLookupPropagation(ENV_LOOKUP_PROPAGATION_EDEFAULT);
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
			case NameResoCGModelPackage.CG_ENV_VISIT_OP__ENV_LOOKUP_PROPAGATION:
				return envLookupPropagation != ENV_LOOKUP_PROPAGATION_EDEFAULT;
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
		return (R) ((NameResoCGModelVisitor<?>)visitor).visitCGEnvVisitOp(this);
	}


} //CGEnvVisitOpImpl
