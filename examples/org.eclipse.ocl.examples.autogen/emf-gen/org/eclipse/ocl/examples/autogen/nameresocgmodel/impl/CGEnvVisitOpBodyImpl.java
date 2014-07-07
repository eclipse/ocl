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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Env Visit Op Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitOpBodyImpl#getEnvConfigParts <em>Env Config Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGEnvVisitOpBodyImpl extends CGValuedElementImpl implements CGEnvVisitOpBody {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * The cached value of the '{@link #getEnvConfigParts() <em>Env Config Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvConfigParts()
	 * @generated
	 * @ordered
	 */
	protected EList<CGEnvVisitIfPart> envConfigParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGEnvVisitOpBodyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NameResoCGModelPackage.Literals.CG_ENV_VISIT_OP_BODY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGEnvVisitIfPart> getEnvConfigParts() {
		if (envConfigParts == null) {
			envConfigParts = new EObjectContainmentEList<CGEnvVisitIfPart>(CGEnvVisitIfPart.class, this, NameResoCGModelPackage.CG_ENV_VISIT_OP_BODY__ENV_CONFIG_PARTS);
		}
		return envConfigParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NameResoCGModelPackage.CG_ENV_VISIT_OP_BODY__ENV_CONFIG_PARTS:
				return ((InternalEList<?>)getEnvConfigParts()).basicRemove(otherEnd, msgs);
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
			case NameResoCGModelPackage.CG_ENV_VISIT_OP_BODY__ENV_CONFIG_PARTS:
				return getEnvConfigParts();
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
			case NameResoCGModelPackage.CG_ENV_VISIT_OP_BODY__ENV_CONFIG_PARTS:
				getEnvConfigParts().clear();
				getEnvConfigParts().addAll((Collection<? extends CGEnvVisitIfPart>)newValue);
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
			case NameResoCGModelPackage.CG_ENV_VISIT_OP_BODY__ENV_CONFIG_PARTS:
				getEnvConfigParts().clear();
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
			case NameResoCGModelPackage.CG_ENV_VISIT_OP_BODY__ENV_CONFIG_PARTS:
				return envConfigParts != null && !envConfigParts.isEmpty();
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
		return (R) ((NameResoCGModelVisitor<?>)visitor).visitCGEnvVisitOpBody(this);
	}

	
	// FIXME ADOLFOSSBH Why is this not generated ?
	public @Nullable Boolean isEquivalentToInternal(@NonNull CGValuedElement thatValue) {
		throw new UnsupportedOperationException(getClass().getName() + ".isEquivalentToInternal()");
	}
} //CGEnvVisitOpBodyImpl
