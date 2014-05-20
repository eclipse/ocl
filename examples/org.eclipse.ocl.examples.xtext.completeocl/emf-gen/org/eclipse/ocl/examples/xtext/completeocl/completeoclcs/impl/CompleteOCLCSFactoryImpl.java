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
package org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSFactory;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OCLMessageArgCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompleteOCLCSFactoryImpl
		extends EFactoryImpl
		implements CompleteOCLCSFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompleteOCLCSFactory init() {
		try
		{
			CompleteOCLCSFactory theCompleteOCLCSFactory = (CompleteOCLCSFactory)EPackage.Registry.INSTANCE.getEFactory(CompleteOCLCSPackage.eNS_URI);
			if (theCompleteOCLCSFactory != null)
			{
				return theCompleteOCLCSFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompleteOCLCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLCSFactoryImpl() {
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
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS: return createClassifierContextDeclCS();
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS: return createCompleteOCLDocumentCS();
			case CompleteOCLCSPackage.DEF_OPERATION_CS: return createDefOperationCS();
			case CompleteOCLCSPackage.DEF_PROPERTY_CS: return createDefPropertyCS();
			case CompleteOCLCSPackage.INCLUDE_CS: return createIncludeCS();
			case CompleteOCLCSPackage.OCL_MESSAGE_ARG_CS: return createOCLMessageArgCS();
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS: return createOperationContextDeclCS();
			case CompleteOCLCSPackage.PACKAGE_DECLARATION_CS: return createPackageDeclarationCS();
			case CompleteOCLCSPackage.PROPERTY_CONTEXT_DECL_CS: return createPropertyContextDeclCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageDeclarationCS createPackageDeclarationCS() {
		PackageDeclarationCSImpl packageDeclarationCS = new PackageDeclarationCSImpl();
		return packageDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyContextDeclCS createPropertyContextDeclCS() {
		PropertyContextDeclCSImpl propertyContextDeclCS = new PropertyContextDeclCSImpl();
		return propertyContextDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLCSPackage getCompleteOCLCSPackage() {
		return (CompleteOCLCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncludeCS createIncludeCS() {
		IncludeCSImpl includeCS = new IncludeCSImpl();
		return includeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierContextDeclCS createClassifierContextDeclCS() {
		ClassifierContextDeclCSImpl classifierContextDeclCS = new ClassifierContextDeclCSImpl();
		return classifierContextDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLDocumentCS createCompleteOCLDocumentCS() {
		CompleteOCLDocumentCSImpl completeOCLDocumentCS = new CompleteOCLDocumentCSImpl();
		return completeOCLDocumentCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLMessageArgCS createOCLMessageArgCS() {
		OCLMessageArgCSImpl oclMessageArgCS = new OCLMessageArgCSImpl();
		return oclMessageArgCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefOperationCS createDefOperationCS() {
		DefOperationCSImpl defOperationCS = new DefOperationCSImpl();
		return defOperationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefPropertyCS createDefPropertyCS() {
		DefPropertyCSImpl defPropertyCS = new DefPropertyCSImpl();
		return defPropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationContextDeclCS createOperationContextDeclCS() {
		OperationContextDeclCSImpl operationContextDeclCS = new OperationContextDeclCSImpl();
		return operationContextDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CompleteOCLCSPackage getPackage() {
		return CompleteOCLCSPackage.eINSTANCE;
	}

} //CompleteOCLCSFactoryImpl
