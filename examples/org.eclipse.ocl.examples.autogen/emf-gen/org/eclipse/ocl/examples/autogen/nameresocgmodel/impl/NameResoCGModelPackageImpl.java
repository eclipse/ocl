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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddCall;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.EnvLookupKind;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelFactory;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NameResoCGModelPackageImpl extends EPackageImpl implements NameResoCGModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgAddCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgEnvVisitOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgEnvVisitOpBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgEnvVisitIfPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum envLookupKindEEnum = null;

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
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NameResoCGModelPackageImpl() {
		super(eNS_URI, NameResoCGModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NameResoCGModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NameResoCGModelPackage init() {
		if (isInited) return (NameResoCGModelPackage)EPackage.Registry.INSTANCE.getEPackage(NameResoCGModelPackage.eNS_URI);

		// Obtain or create and register package
		NameResoCGModelPackageImpl theNameResoCGModelPackage = (NameResoCGModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NameResoCGModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NameResoCGModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CGModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theNameResoCGModelPackage.createPackageContents();

		// Initialize created meta-data
		theNameResoCGModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNameResoCGModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NameResoCGModelPackage.eNS_URI, theNameResoCGModelPackage);
		return theNameResoCGModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGAddCall() {
		return cgAddCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGEnvVisitOp() {
		return cgEnvVisitOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGEnvVisitOp_EnvLookupPropagation() {
		return (EAttribute)cgEnvVisitOpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGEnvVisitOpBody() {
		return cgEnvVisitOpBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGEnvVisitOpBody_EnvConfigParts() {
		return (EReference)cgEnvVisitOpBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGEnvVisitIfPart() {
		return cgEnvVisitIfPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGEnvVisitIfPart_PropertyName() {
		return (EAttribute)cgEnvVisitIfPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGEnvVisitIfPart_EnvExpression() {
		return (EReference)cgEnvVisitIfPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnvLookupKind() {
		return envLookupKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameResoCGModelFactory getNameResoCGModelFactory() {
		return (NameResoCGModelFactory)getEFactoryInstance();
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
		cgAddCallEClass = createEClass(CG_ADD_CALL);

		cgEnvVisitOpEClass = createEClass(CG_ENV_VISIT_OP);
		createEAttribute(cgEnvVisitOpEClass, CG_ENV_VISIT_OP__ENV_LOOKUP_PROPAGATION);

		cgEnvVisitOpBodyEClass = createEClass(CG_ENV_VISIT_OP_BODY);
		createEReference(cgEnvVisitOpBodyEClass, CG_ENV_VISIT_OP_BODY__ENV_CONFIG_PARTS);

		cgEnvVisitIfPartEClass = createEClass(CG_ENV_VISIT_IF_PART);
		createEAttribute(cgEnvVisitIfPartEClass, CG_ENV_VISIT_IF_PART__PROPERTY_NAME);
		createEReference(cgEnvVisitIfPartEClass, CG_ENV_VISIT_IF_PART__ENV_EXPRESSION);

		// Create enums
		envLookupKindEEnum = createEEnum(ENV_LOOKUP_KIND);
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
		CGModelPackage theCGModelPackage = (CGModelPackage)EPackage.Registry.INSTANCE.getEPackage(CGModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cgAddCallEClass.getESuperTypes().add(theCGModelPackage.getCGOperationCallExp());
		cgEnvVisitOpEClass.getESuperTypes().add(theCGModelPackage.getCGOperation());
		cgEnvVisitOpBodyEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgEnvVisitIfPartEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(cgAddCallEClass, CGAddCall.class, "CGAddCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgEnvVisitOpEClass, CGEnvVisitOp.class, "CGEnvVisitOp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGEnvVisitOp_EnvLookupPropagation(), this.getEnvLookupKind(), "envLookupPropagation", null, 0, 1, CGEnvVisitOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgEnvVisitOpBodyEClass, CGEnvVisitOpBody.class, "CGEnvVisitOpBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGEnvVisitOpBody_EnvConfigParts(), this.getCGEnvVisitIfPart(), null, "envConfigParts", null, 0, -1, CGEnvVisitOpBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgEnvVisitIfPartEClass, CGEnvVisitIfPart.class, "CGEnvVisitIfPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGEnvVisitIfPart_PropertyName(), ecorePackage.getEString(), "propertyName", null, 0, 1, CGEnvVisitIfPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGEnvVisitIfPart_EnvExpression(), theCGModelPackage.getCGValuedElement(), null, "envExpression", null, 1, 1, CGEnvVisitIfPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(envLookupKindEEnum, EnvLookupKind.class, "EnvLookupKind");
		addEEnumLiteral(envLookupKindEEnum, EnvLookupKind.LOOKUP_ONLY_LOCAL);
		addEEnumLiteral(envLookupKindEEnum, EnvLookupKind.LOOKUP_IN_PARENT_IF_NOT_COMPLETE);
		addEEnumLiteral(envLookupKindEEnum, EnvLookupKind.LOOKUP_IN_PARENT);

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
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore#/"
		   });
	}

} //NameResoCGModelPackageImpl
