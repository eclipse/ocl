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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSFactory;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.FeatureContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OCLMessageArgCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PathNameDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompleteOCLCSPackageImpl
		extends EPackageImpl
		implements CompleteOCLCSPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureContextDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass includeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathNameDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyContextDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierContextDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completeOCLDocumentCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defOperationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationContextDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclMessageArgCSEClass = null;

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
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompleteOCLCSPackageImpl() {
		super(eNS_URI, CompleteOCLCSFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CompleteOCLCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CompleteOCLCSPackage init() {
		if (isInited) return (CompleteOCLCSPackage)EPackage.Registry.INSTANCE.getEPackage(CompleteOCLCSPackage.eNS_URI);

		// Obtain or create and register package
		CompleteOCLCSPackageImpl theCompleteOCLCSPackage = (CompleteOCLCSPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CompleteOCLCSPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CompleteOCLCSPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EssentialOCLCSPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCompleteOCLCSPackage.createPackageContents();

		// Initialize created meta-data
		theCompleteOCLCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompleteOCLCSPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CompleteOCLCSPackage.eNS_URI, theCompleteOCLCSPackage);
		return theCompleteOCLCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureContextDeclCS() {
		return featureContextDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureContextDeclCS_Class() {
		return (EReference)featureContextDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureContextDeclCS_OwnedType() {
		return (EReference)featureContextDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIncludeCS() {
		return includeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIncludeCS_ReferredNamespace()
	{
		return (EReference)includeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageDeclarationCS() {
		return packageDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageDeclarationCS_ReferredPackage()
	{
		return (EReference)packageDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageDeclarationCS_OwnedContexts()
	{
		return (EReference)packageDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageDeclarationCS_OwnedInvariants()
	{
		return (EReference)packageDeclarationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathNameDeclCS() {
		return pathNameDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathNameDeclCS_OwnedPathName()
	{
		return (EReference)pathNameDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextDeclCS() {
		return contextDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyContextDeclCS() {
		return propertyContextDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyContextDeclCS_ReferredProperty()
	{
		return (EReference)propertyContextDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyContextDeclCS_OwnedDefaultExpressions()
	{
		return (EReference)propertyContextDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyContextDeclCS_OwnedDerivedInvariants()
	{
		return (EReference)propertyContextDeclCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLCSFactory getCompleteOCLCSFactory() {
		return (CompleteOCLCSFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierContextDeclCS() {
		return classifierContextDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierContextDeclCS_SelfName() {
		return (EAttribute)classifierContextDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierContextDeclCS_ReferredClassifier()
	{
		return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierContextDeclCS_OwnedInvariants()
	{
		return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierContextDeclCS_OwnedDefinitions()
	{
		return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompleteOCLDocumentCS() {
		return completeOCLDocumentCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteOCLDocumentCS_OwnedPackages()
	{
		return (EReference)completeOCLDocumentCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteOCLDocumentCS_OwnedContexts()
	{
		return (EReference)completeOCLDocumentCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteOCLDocumentCS_OwnedIncludes()
	{
		return (EReference)completeOCLDocumentCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLMessageArgCS() {
		return oclMessageArgCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOCLMessageArgCS_Type() {
		return (EReference)oclMessageArgCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefCS() {
		return defCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefCS_OwningClassifierContextDecl()
	{
		return (EReference)defCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefCS_OwnedSpecification()
	{
		return (EReference)defCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefCS_Static() {
		return (EAttribute)defCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefOperationCS() {
		return defOperationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefOperationCS_OwnedParameters()
	{
		return (EReference)defOperationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefPropertyCS() {
		return defPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationContextDeclCS() {
		return operationContextDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_ReferredOperation()
	{
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_OwnedParameters()
	{
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_OwnedResult()
	{
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_OwnedPreconditions()
	{
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_OwnedPostconditions()
	{
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclCS_OwnedBodies()
	{
		return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(5);
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
		classifierContextDeclCSEClass = createEClass(CLASSIFIER_CONTEXT_DECL_CS);
		createEAttribute(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME);
		createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__REFERRED_CLASSIFIER);
		createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__OWNED_INVARIANTS);
		createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__OWNED_DEFINITIONS);

		completeOCLDocumentCSEClass = createEClass(COMPLETE_OCL_DOCUMENT_CS);
		createEReference(completeOCLDocumentCSEClass, COMPLETE_OCL_DOCUMENT_CS__OWNED_PACKAGES);
		createEReference(completeOCLDocumentCSEClass, COMPLETE_OCL_DOCUMENT_CS__OWNED_CONTEXTS);
		createEReference(completeOCLDocumentCSEClass, COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDES);

		contextDeclCSEClass = createEClass(CONTEXT_DECL_CS);

		defCSEClass = createEClass(DEF_CS);
		createEReference(defCSEClass, DEF_CS__OWNING_CLASSIFIER_CONTEXT_DECL);
		createEReference(defCSEClass, DEF_CS__OWNED_SPECIFICATION);
		createEAttribute(defCSEClass, DEF_CS__STATIC);

		defOperationCSEClass = createEClass(DEF_OPERATION_CS);
		createEReference(defOperationCSEClass, DEF_OPERATION_CS__OWNED_PARAMETERS);

		defPropertyCSEClass = createEClass(DEF_PROPERTY_CS);

		featureContextDeclCSEClass = createEClass(FEATURE_CONTEXT_DECL_CS);
		createEReference(featureContextDeclCSEClass, FEATURE_CONTEXT_DECL_CS__CLASS);
		createEReference(featureContextDeclCSEClass, FEATURE_CONTEXT_DECL_CS__OWNED_TYPE);

		includeCSEClass = createEClass(INCLUDE_CS);
		createEReference(includeCSEClass, INCLUDE_CS__REFERRED_NAMESPACE);

		oclMessageArgCSEClass = createEClass(OCL_MESSAGE_ARG_CS);
		createEReference(oclMessageArgCSEClass, OCL_MESSAGE_ARG_CS__TYPE);

		operationContextDeclCSEClass = createEClass(OPERATION_CONTEXT_DECL_CS);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__REFERRED_OPERATION);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__OWNED_PARAMETERS);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__OWNED_RESULT);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__OWNED_PRECONDITIONS);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__OWNED_POSTCONDITIONS);
		createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__OWNED_BODIES);

		packageDeclarationCSEClass = createEClass(PACKAGE_DECLARATION_CS);
		createEReference(packageDeclarationCSEClass, PACKAGE_DECLARATION_CS__REFERRED_PACKAGE);
		createEReference(packageDeclarationCSEClass, PACKAGE_DECLARATION_CS__OWNED_CONTEXTS);
		createEReference(packageDeclarationCSEClass, PACKAGE_DECLARATION_CS__OWNED_INVARIANTS);

		pathNameDeclCSEClass = createEClass(PATH_NAME_DECL_CS);
		createEReference(pathNameDeclCSEClass, PATH_NAME_DECL_CS__OWNED_PATH_NAME);

		propertyContextDeclCSEClass = createEClass(PROPERTY_CONTEXT_DECL_CS);
		createEReference(propertyContextDeclCSEClass, PROPERTY_CONTEXT_DECL_CS__REFERRED_PROPERTY);
		createEReference(propertyContextDeclCSEClass, PROPERTY_CONTEXT_DECL_CS__OWNED_DEFAULT_EXPRESSIONS);
		createEReference(propertyContextDeclCSEClass, PROPERTY_CONTEXT_DECL_CS__OWNED_DERIVED_INVARIANTS);
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
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		EssentialOCLCSPackage theEssentialOCLCSPackage = (EssentialOCLCSPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		classifierContextDeclCSEClass.getESuperTypes().add(this.getContextDeclCS());
		classifierContextDeclCSEClass.getESuperTypes().add(theBaseCSPackage.getTemplateableElementCS());
		completeOCLDocumentCSEClass.getESuperTypes().add(theBaseCSPackage.getNamespaceCS());
		completeOCLDocumentCSEClass.getESuperTypes().add(theBaseCSPackage.getRootCS());
		contextDeclCSEClass.getESuperTypes().add(this.getPathNameDeclCS());
		defCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedElementCS());
		defOperationCSEClass.getESuperTypes().add(this.getDefCS());
		defOperationCSEClass.getESuperTypes().add(theBaseCSPackage.getTemplateableElementCS());
		defPropertyCSEClass.getESuperTypes().add(this.getDefCS());
		featureContextDeclCSEClass.getESuperTypes().add(this.getContextDeclCS());
		includeCSEClass.getESuperTypes().add(theBaseCSPackage.getNamespaceCS());
		oclMessageArgCSEClass.getESuperTypes().add(theEssentialOCLCSPackage.getExpCS());
		operationContextDeclCSEClass.getESuperTypes().add(this.getFeatureContextDeclCS());
		operationContextDeclCSEClass.getESuperTypes().add(theBaseCSPackage.getTemplateableElementCS());
		packageDeclarationCSEClass.getESuperTypes().add(this.getPathNameDeclCS());
		pathNameDeclCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		pathNameDeclCSEClass.getESuperTypes().add(thePivotPackage.getMorePivotable());
		propertyContextDeclCSEClass.getESuperTypes().add(this.getFeatureContextDeclCS());

		// Initialize classes and features; add operations and parameters
		initEClass(classifierContextDeclCSEClass, ClassifierContextDeclCS.class, "ClassifierContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassifierContextDeclCS_SelfName(), ecorePackage.getEString(), "selfName", null, 0, 1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierContextDeclCS_ReferredClassifier(), thePivotPackage.getClass_(), null, "referredClassifier", null, 0, 1, ClassifierContextDeclCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierContextDeclCS_OwnedInvariants(), theBaseCSPackage.getConstraintCS(), null, "ownedInvariants", null, 0, -1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierContextDeclCS_OwnedDefinitions(), this.getDefCS(), this.getDefCS_OwningClassifierContextDecl(), "ownedDefinitions", null, 0, -1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(completeOCLDocumentCSEClass, CompleteOCLDocumentCS.class, "CompleteOCLDocumentCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompleteOCLDocumentCS_OwnedPackages(), this.getPackageDeclarationCS(), null, "ownedPackages", null, 0, -1, CompleteOCLDocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompleteOCLDocumentCS_OwnedContexts(), this.getContextDeclCS(), null, "ownedContexts", null, 0, -1, CompleteOCLDocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompleteOCLDocumentCS_OwnedIncludes(), this.getIncludeCS(), null, "ownedIncludes", null, 0, -1, CompleteOCLDocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextDeclCSEClass, ContextDeclCS.class, "ContextDeclCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(defCSEClass, DefCS.class, "DefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefCS_OwningClassifierContextDecl(), this.getClassifierContextDeclCS(), this.getClassifierContextDeclCS_OwnedDefinitions(), "owningClassifierContextDecl", null, 0, 1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefCS_OwnedSpecification(), theEssentialOCLCSPackage.getExpSpecificationCS(), null, "ownedSpecification", null, 0, 1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefCS_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defOperationCSEClass, DefOperationCS.class, "DefOperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefOperationCS_OwnedParameters(), theBaseCSPackage.getParameterCS(), null, "ownedParameters", null, 0, -1, DefOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defPropertyCSEClass, DefPropertyCS.class, "DefPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureContextDeclCSEClass, FeatureContextDeclCS.class, "FeatureContextDeclCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureContextDeclCS_Class(), theBaseCSPackage.getStructuredClassCS(), null, "class", null, 0, 1, FeatureContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureContextDeclCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, FeatureContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(includeCSEClass, IncludeCS.class, "IncludeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIncludeCS_ReferredNamespace(), thePivotPackage.getNamespace(), null, "referredNamespace", null, 0, 1, IncludeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oclMessageArgCSEClass, OCLMessageArgCS.class, "OCLMessageArgCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOCLMessageArgCS_Type(), theBaseCSPackage.getTypeCS(), null, "type", null, 0, 1, OCLMessageArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationContextDeclCSEClass, OperationContextDeclCS.class, "OperationContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationContextDeclCS_ReferredOperation(), thePivotPackage.getOperation(), null, "referredOperation", null, 0, 1, OperationContextDeclCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_OwnedParameters(), theBaseCSPackage.getParameterCS(), null, "ownedParameters", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_OwnedResult(), theEssentialOCLCSPackage.getVariableCS(), null, "ownedResult", null, 0, 1, OperationContextDeclCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_OwnedPreconditions(), theBaseCSPackage.getConstraintCS(), null, "ownedPreconditions", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_OwnedPostconditions(), theBaseCSPackage.getConstraintCS(), null, "ownedPostconditions", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationContextDeclCS_OwnedBodies(), theEssentialOCLCSPackage.getExpSpecificationCS(), null, "ownedBodies", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageDeclarationCSEClass, PackageDeclarationCS.class, "PackageDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageDeclarationCS_ReferredPackage(), thePivotPackage.getPackage(), null, "referredPackage", null, 0, 1, PackageDeclarationCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPackageDeclarationCS_OwnedContexts(), this.getContextDeclCS(), null, "ownedContexts", null, 0, -1, PackageDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageDeclarationCS_OwnedInvariants(), theBaseCSPackage.getConstraintCS(), null, "ownedInvariants", null, 0, -1, PackageDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathNameDeclCSEClass, PathNameDeclCS.class, "PathNameDeclCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathNameDeclCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, PathNameDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyContextDeclCSEClass, PropertyContextDeclCS.class, "PropertyContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyContextDeclCS_ReferredProperty(), thePivotPackage.getProperty(), null, "referredProperty", null, 0, 1, PropertyContextDeclCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyContextDeclCS_OwnedDefaultExpressions(), theEssentialOCLCSPackage.getExpSpecificationCS(), null, "ownedDefaultExpressions", null, 0, -1, PropertyContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyContextDeclCS_OwnedDerivedInvariants(), theBaseCSPackage.getConstraintCS(), null, "ownedDerivedInvariants", null, 0, -1, PropertyContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
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

} //CompleteOCLCSPackageImpl
