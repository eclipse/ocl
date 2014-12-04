/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.autocgmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelFactory;
import org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelPackage;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AutoCGModelFactoryImpl extends EFactoryImpl implements AutoCGModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AutoCGModelFactory init() {
		try {
			AutoCGModelFactory theAutoCGModelFactory = (AutoCGModelFactory)EPackage.Registry.INSTANCE.getEFactory(AutoCGModelPackage.eNS_URI);
			if (theAutoCGModelFactory != null) {
				return theAutoCGModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AutoCGModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutoCGModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AutoCGModelPackage.CGAST_CALL_EXP: return createCGASTCallExp();
			case AutoCGModelPackage.CG_CONTAINMENT_VISIT: return createCGContainmentVisit();
			case AutoCGModelPackage.CG_CONTAINMENT_PART: return createCGContainmentPart();
			case AutoCGModelPackage.CG_CONTAINMENT_BODY: return createCGContainmentBody();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGASTCallExp createCGASTCallExp() {
		CGASTCallExpImpl cgastCallExp = new CGASTCallExpImpl();
		return cgastCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGContainmentVisit createCGContainmentVisit() {
		CGContainmentVisitImpl cgContainmentVisit = new CGContainmentVisitImpl();
		return cgContainmentVisit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGContainmentPart createCGContainmentPart() {
		CGContainmentPartImpl cgContainmentPart = new CGContainmentPartImpl();
		return cgContainmentPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGContainmentBody createCGContainmentBody() {
		CGContainmentBodyImpl cgContainmentBody = new CGContainmentBodyImpl();
		return cgContainmentBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull AutoCGModelPackage getAutoCGModelPackage() {
		return (AutoCGModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AutoCGModelPackage getPackage() {
		return AutoCGModelPackage.eINSTANCE;
	}

} //AutoCGModelFactoryImpl
