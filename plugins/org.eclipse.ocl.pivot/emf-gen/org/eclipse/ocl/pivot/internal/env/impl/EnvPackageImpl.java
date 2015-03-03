/**
 */
package org.eclipse.ocl.pivot.internal.env.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.env.EnvFactory;
import org.eclipse.ocl.pivot.internal.env.EnvPackage;
import org.eclipse.ocl.pivot.internal.lookup.IEnvironment;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnvPackageImpl extends EPackageImpl implements EnvPackage {
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
	 * @see org.eclipse.ocl.pivot.internal.env.EnvPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EnvPackageImpl() {
		super(eNS_URI, EnvFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EnvPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EnvPackage init() {
		if (isInited) return (EnvPackage)EPackage.Registry.INSTANCE.getEPackage(EnvPackage.eNS_URI);

		// Obtain or create and register package
		EnvPackageImpl theEnvPackage = (EnvPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EnvPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EnvPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		OCLstdlibPackage.eINSTANCE.eClass();
		PivotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEnvPackage.createPackageContents();

		// Initialize created meta-data
		theEnvPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEnvPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EnvPackage.eNS_URI, theEnvPackage);
		return theEnvPackage;
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
	public EOperation getEnvironment__AddElement__NamedElement_1() {
		return environmentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEnvironment__AddElement__String_NamedElement_1() {
		return environmentEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEnvironment__AddElements__Collection_1() {
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
	public EOperation getEnvironment__HasFinalResult_1() {
		return environmentEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEnvironment__NestedEnv_1() {
		return environmentEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnvFactory getEnvFactory() {
		return (EnvFactory)getEFactoryInstance();
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
		createEOperation(environmentEClass, ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT_1);
		createEOperation(environmentEClass, ENVIRONMENT___ADD_ELEMENT__STRING_NAMEDELEMENT_1);
		createEOperation(environmentEClass, ENVIRONMENT___ADD_ELEMENTS__COLLECTION_1);
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
		initEClass(environmentEClass, IEnvironment.class, "Environment", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnvironment_NamedElements(), thePivotPackage.getNamedElement(), null, "namedElements", null, 0, -1, IEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getEnvironment__AddElement__NamedElement_1(), this.getEnvironment(), "addElement", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePivotPackage.getNamedElement(), "element", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEnvironment__AddElement__String_NamedElement_1(), this.getEnvironment(), "addElement", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOCLstdlibPackage.getString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePivotPackage.getNamedElement(), "element", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEnvironment__AddElements__Collection_1(), this.getEnvironment(), "addElements", 1, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(theOCLstdlibPackage.getCollection());
		EGenericType g2 = createEGenericType(thePivotPackage.getNamedElement());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "elements", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEnvironment__AddElementsOf__Namespace(), this.getEnvironment(), "addElementsOf", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePivotPackage.getNamespace(), "elements", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getEnvironment__HasFinalResult_1(), ecorePackage.getEBoolean(), "hasFinalResult", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getEnvironment__NestedEnv_1(), this.getEnvironment(), "nestedEnv", 1, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //EnvPackageImpl
