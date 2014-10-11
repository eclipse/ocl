/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibConstraintCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaclassNameCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSFactory;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLstdlibCSFactoryImpl
		extends EFactoryImpl
		implements OCLstdlibCSFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OCLstdlibCSFactory init() {
		try
		{
			OCLstdlibCSFactory theOCLstdlibCSFactory = (OCLstdlibCSFactory)EPackage.Registry.INSTANCE.getEFactory(OCLstdlibCSPackage.eNS_URI);
			if (theOCLstdlibCSFactory != null)
			{
				return theOCLstdlibCSFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OCLstdlibCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLstdlibCSFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
			case OCLstdlibCSPackage.JAVA_CLASS_CS: return createJavaClassCS();
			case OCLstdlibCSPackage.LIB_CLASS_CS: return createLibClassCS();
			case OCLstdlibCSPackage.LIB_CONSTRAINT_CS: return createLibConstraintCS();
			case OCLstdlibCSPackage.LIB_ITERATION_CS: return createLibIterationCS();
			case OCLstdlibCSPackage.LIB_OPERATION_CS: return createLibOperationCS();
			case OCLstdlibCSPackage.LIB_PACKAGE_CS: return createLibPackageCS();
			case OCLstdlibCSPackage.LIB_PROPERTY_CS: return createLibPropertyCS();
			case OCLstdlibCSPackage.LIB_ROOT_PACKAGE_CS: return createLibRootPackageCS();
			case OCLstdlibCSPackage.METACLASS_NAME_CS: return createMetaclassNameCS();
			case OCLstdlibCSPackage.PRECEDENCE_CS: return createPrecedenceCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaClassCS createJavaClassCS()
	{
		JavaClassCSImpl javaClassCS = new JavaClassCSImpl();
		return javaClassCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibClassCS createLibClassCS() {
		LibClassCSImpl libClassCS = new LibClassCSImpl();
		return libClassCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibConstraintCS createLibConstraintCS() {
		LibConstraintCSImpl libConstraintCS = new LibConstraintCSImpl();
		return libConstraintCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibIterationCS createLibIterationCS() {
		LibIterationCSImpl libIterationCS = new LibIterationCSImpl();
		return libIterationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibOperationCS createLibOperationCS() {
		LibOperationCSImpl libOperationCS = new LibOperationCSImpl();
		return libOperationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibPackageCS createLibPackageCS()
	{
		LibPackageCSImpl libPackageCS = new LibPackageCSImpl();
		return libPackageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibPropertyCS createLibPropertyCS() {
		LibPropertyCSImpl libPropertyCS = new LibPropertyCSImpl();
		return libPropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibRootPackageCS createLibRootPackageCS()
	{
		LibRootPackageCSImpl libRootPackageCS = new LibRootPackageCSImpl();
		return libRootPackageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaclassNameCS createMetaclassNameCS()
	{
		MetaclassNameCSImpl metaclassNameCS = new MetaclassNameCSImpl();
		return metaclassNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrecedenceCS createPrecedenceCS() {
		PrecedenceCSImpl precedenceCS = new PrecedenceCSImpl();
		return precedenceCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLstdlibCSPackage getOCLstdlibCSPackage()
	{
		return (OCLstdlibCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OCLstdlibCSPackage getPackage() {
		return OCLstdlibCSPackage.eINSTANCE;
	}

} //OCLstdlibCSFactoryImpl
