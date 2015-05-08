/**
 * Copyright (c) 2014, 2015 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 */
package org.eclipse.ocl.pivot.internal.lookup.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.lookup.LookupFactory;
import org.eclipse.ocl.pivot.internal.lookup.LookupPackage;
import org.eclipse.ocl.pivot.lookup.LookupEnvironment;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LookupPackageImpl extends EPackageImpl implements LookupPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass environmentEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LookupPackageImpl() {
		super(eNS_URI, LookupFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link LookupPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LookupPackage init() {
		if (isInited) return (LookupPackage)EPackage.Registry.INSTANCE.getEPackage(LookupPackage.eNS_URI);

		// Obtain or create and register package
		LookupPackageImpl theLookupPackage = (LookupPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LookupPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LookupPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		OCLstdlibPackage.eINSTANCE.eClass();
		PivotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLookupPackage.createPackageContents();

		// Initialize created meta-data
		theLookupPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLookupPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LookupPackage.eNS_URI, theLookupPackage);
		return theLookupPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnvironment() {
		return environmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnvironment_NamedElements() {
		return (EReference)environmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEnvironment__AddElement__NamedElement() {
		return environmentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEnvironment__AddElement__String_NamedElement() {
		return environmentEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEnvironment__AddElements__Collection() {
		return environmentEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEnvironment__AddElementsOf__Namespace() {
		return environmentEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEnvironment__HasFinalResult() {
		return environmentEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEnvironment__NestedEnv() {
		return environmentEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LookupFactory getLookupFactory() {
		return (LookupFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		environmentEClass = createEClass(ENVIRONMENT);
		createEReference(environmentEClass, ENVIRONMENT__NAMED_ELEMENTS);
		createEOperation(environmentEClass, ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT);
		createEOperation(environmentEClass, ENVIRONMENT___ADD_ELEMENT__STRING_NAMEDELEMENT);
		createEOperation(environmentEClass, ENVIRONMENT___ADD_ELEMENTS__COLLECTION);
		createEOperation(environmentEClass, ENVIRONMENT___ADD_ELEMENTS_OF__NAMESPACE);
		createEOperation(environmentEClass, ENVIRONMENT___HAS_FINAL_RESULT);
		createEOperation(environmentEClass, ENVIRONMENT___NESTED_ENV);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		OCLstdlibPackage theOCLstdlibPackage = (OCLstdlibPackage)EPackage.Registry.INSTANCE.getEPackage(OCLstdlibPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(environmentEClass, LookupEnvironment.class, "Environment", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEnvironment_NamedElements(), thePivotPackage.getNamedElement(), null, "namedElements", null, 0, -1, LookupEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = initEOperation(getEnvironment__AddElement__NamedElement(), this.getEnvironment(), "addElement", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, thePivotPackage.getNamedElement(), "element", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getEnvironment__AddElement__String_NamedElement(), this.getEnvironment(), "addElement", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theOCLstdlibPackage.getString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, thePivotPackage.getNamedElement(), "element", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getEnvironment__AddElements__Collection(), this.getEnvironment(), "addElements", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		EGenericType g1 = createEGenericType(theOCLstdlibPackage.getCollection());
		EGenericType g2 = createEGenericType(thePivotPackage.getNamedElement());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "elements", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getEnvironment__AddElementsOf__Namespace(), this.getEnvironment(), "addElementsOf", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, thePivotPackage.getNamespace(), "elements", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEOperation(getEnvironment__HasFinalResult(), ecorePackage.getEBoolean(), "hasFinalResult", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEOperation(getEnvironment__NestedEnv(), this.getEnvironment(), "nestedEnv", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //LookupPackageImpl
