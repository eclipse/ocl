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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibConstraintCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaTypeName;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSFactory;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLstdlibCSPackageImpl
		extends EPackageImpl
		implements OCLstdlibCSPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libClassCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libConstraintCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libIterationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libOperationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libPackageCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libRootPackageCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaTypeNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaImplementationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass precedenceCSEClass = null;

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
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OCLstdlibCSPackageImpl() {
		super(eNS_URI, OCLstdlibCSFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OCLstdlibCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OCLstdlibCSPackage init() {
		if (isInited) return (OCLstdlibCSPackage)EPackage.Registry.INSTANCE.getEPackage(OCLstdlibCSPackage.eNS_URI);

		// Obtain or create and register package
		OCLstdlibCSPackageImpl theOCLstdlibCSPackage = (OCLstdlibCSPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OCLstdlibCSPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OCLstdlibCSPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EssentialOCLCSPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOCLstdlibCSPackage.createPackageContents();

		// Initialize created meta-data
		theOCLstdlibCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOCLstdlibCSPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OCLstdlibCSPackage.eNS_URI, theOCLstdlibCSPackage);
		return theOCLstdlibCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibClassCS() {
		return libClassCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibClassCS_MetaTypeName() {
		return (EReference)libClassCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibConstraintCS() {
		return libConstraintCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibIterationCS() {
		return libIterationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibIterationCS_OwnedIterator() {
		return (EReference)libIterationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibIterationCS_OwnedAccumulator() {
		return (EReference)libIterationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibIterationCS_Invalidating()
	{
		return (EAttribute)libIterationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibIterationCS_Validating()
	{
		return (EAttribute)libIterationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibOperationCS() {
		return libOperationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibOperationCS_Precedence() {
		return (EReference)libOperationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibOperationCS_Invalidating()
	{
		return (EAttribute)libOperationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibOperationCS_Static() {
		return (EAttribute)libOperationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibOperationCS_Validating()
	{
		return (EAttribute)libOperationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibPackageCS()
	{
		return libPackageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibPackageCS_OwnedPrecedence()
	{
		return (EReference)libPackageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibPropertyCS() {
		return libPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibPropertyCS_Static() {
		return (EAttribute)libPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibRootPackageCS()
	{
		return libRootPackageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaTypeName() {
		return metaTypeNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetaTypeName_Name() {
		return (EAttribute)metaTypeNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaImplementationCS() {
		return javaImplementationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaImplementationCS_Implementation() {
		return (EReference)javaImplementationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrecedenceCS() {
		return precedenceCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrecedenceCS_RightAssociative() {
		return (EAttribute)precedenceCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLstdlibCSFactory getOCLstdlibCSFactory()
	{
		return (OCLstdlibCSFactory)getEFactoryInstance();
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
		javaImplementationCSEClass = createEClass(JAVA_IMPLEMENTATION_CS);
		createEReference(javaImplementationCSEClass, JAVA_IMPLEMENTATION_CS__IMPLEMENTATION);

		libClassCSEClass = createEClass(LIB_CLASS_CS);
		createEReference(libClassCSEClass, LIB_CLASS_CS__META_TYPE_NAME);

		libConstraintCSEClass = createEClass(LIB_CONSTRAINT_CS);

		libIterationCSEClass = createEClass(LIB_ITERATION_CS);
		createEReference(libIterationCSEClass, LIB_ITERATION_CS__OWNED_ITERATOR);
		createEReference(libIterationCSEClass, LIB_ITERATION_CS__OWNED_ACCUMULATOR);
		createEAttribute(libIterationCSEClass, LIB_ITERATION_CS__INVALIDATING);
		createEAttribute(libIterationCSEClass, LIB_ITERATION_CS__VALIDATING);

		libOperationCSEClass = createEClass(LIB_OPERATION_CS);
		createEReference(libOperationCSEClass, LIB_OPERATION_CS__PRECEDENCE);
		createEAttribute(libOperationCSEClass, LIB_OPERATION_CS__INVALIDATING);
		createEAttribute(libOperationCSEClass, LIB_OPERATION_CS__STATIC);
		createEAttribute(libOperationCSEClass, LIB_OPERATION_CS__VALIDATING);

		libPackageCSEClass = createEClass(LIB_PACKAGE_CS);
		createEReference(libPackageCSEClass, LIB_PACKAGE_CS__OWNED_PRECEDENCE);

		libPropertyCSEClass = createEClass(LIB_PROPERTY_CS);
		createEAttribute(libPropertyCSEClass, LIB_PROPERTY_CS__STATIC);

		libRootPackageCSEClass = createEClass(LIB_ROOT_PACKAGE_CS);

		metaTypeNameEClass = createEClass(META_TYPE_NAME);
		createEAttribute(metaTypeNameEClass, META_TYPE_NAME__NAME);

		precedenceCSEClass = createEClass(PRECEDENCE_CS);
		createEAttribute(precedenceCSEClass, PRECEDENCE_CS__RIGHT_ASSOCIATIVE);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		libClassCSEClass.getESuperTypes().add(theBaseCSPackage.getClassCS());
		libConstraintCSEClass.getESuperTypes().add(theBaseCSPackage.getConstraintCS());
		libIterationCSEClass.getESuperTypes().add(theBaseCSPackage.getOperationCS());
		libIterationCSEClass.getESuperTypes().add(this.getJavaImplementationCS());
		libOperationCSEClass.getESuperTypes().add(theBaseCSPackage.getOperationCS());
		libOperationCSEClass.getESuperTypes().add(this.getJavaImplementationCS());
		libPackageCSEClass.getESuperTypes().add(theBaseCSPackage.getPackageCS());
		libPropertyCSEClass.getESuperTypes().add(theBaseCSPackage.getAttributeCS());
		libPropertyCSEClass.getESuperTypes().add(this.getJavaImplementationCS());
		libRootPackageCSEClass.getESuperTypes().add(theBaseCSPackage.getRootPackageCS());
		metaTypeNameEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		metaTypeNameEClass.getESuperTypes().add(thePivotPackage.getNameable());
		precedenceCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());

		// Initialize classes and features; add operations and parameters
		initEClass(javaImplementationCSEClass, JavaImplementationCS.class, "JavaImplementationCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaImplementationCS_Implementation(), theTypesPackage.getJvmType(), null, "implementation", null, 0, 1, JavaImplementationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libClassCSEClass, LibClassCS.class, "LibClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibClassCS_MetaTypeName(), this.getMetaTypeName(), null, "metaTypeName", null, 0, 1, LibClassCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libConstraintCSEClass, LibConstraintCS.class, "LibConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(libIterationCSEClass, LibIterationCS.class, "LibIterationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibIterationCS_OwnedIterator(), theBaseCSPackage.getParameterCS(), null, "ownedIterator", null, 0, -1, LibIterationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibIterationCS_OwnedAccumulator(), theBaseCSPackage.getParameterCS(), null, "ownedAccumulator", null, 0, -1, LibIterationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibIterationCS_Invalidating(), thePivotPackage.getBoolean(), "invalidating", "false", 0, 1, LibIterationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibIterationCS_Validating(), thePivotPackage.getBoolean(), "validating", "false", 0, 1, LibIterationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libOperationCSEClass, LibOperationCS.class, "LibOperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibOperationCS_Precedence(), thePivotPackage.getPrecedence(), null, "precedence", null, 0, 1, LibOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibOperationCS_Invalidating(), thePivotPackage.getBoolean(), "invalidating", "false", 0, 1, LibOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibOperationCS_Static(), thePivotPackage.getBoolean(), "static", "false", 0, 1, LibOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibOperationCS_Validating(), thePivotPackage.getBoolean(), "validating", "false", 0, 1, LibOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libPackageCSEClass, LibPackageCS.class, "LibPackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibPackageCS_OwnedPrecedence(), this.getPrecedenceCS(), null, "ownedPrecedence", null, 0, -1, LibPackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libPropertyCSEClass, LibPropertyCS.class, "LibPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLibPropertyCS_Static(), thePivotPackage.getBoolean(), "static", "false", 0, 1, LibPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libRootPackageCSEClass, LibRootPackageCS.class, "LibRootPackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metaTypeNameEClass, MetaTypeName.class, "MetaTypeName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetaTypeName_Name(), ecorePackage.getEString(), "name", null, 0, 1, MetaTypeName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(precedenceCSEClass, PrecedenceCS.class, "PrecedenceCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrecedenceCS_RightAssociative(), ecorePackage.getEBoolean(), "rightAssociative", "false", 0, 1, PrecedenceCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations()
	{
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] 
		   {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations()
	{
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] 
		   {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore",
			 "pivot", "../../org.eclipse.ocl.examples.pivot/model/Pivot.ecore#/",
			 "basecs", "../../org.eclipse.ocl.examples.xtext.base/model/BaseCS.ecore#/",
			 "essentialoclcs", "../../org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCS.ecore#/"
		   });
	}

} //OCLstdlibCSPackageImpl
