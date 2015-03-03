/**
 */
package org.eclipse.ocl.pivot.internal.env;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.internal.env.EnvFactory
 * @model kind="package"
 * @generated
 */
public interface EnvPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "env";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/examples/env.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "env";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnvPackage eINSTANCE = org.eclipse.ocl.pivot.internal.env.impl.EnvPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.internal.env.impl.EnvironmentImpl <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.internal.env.impl.EnvironmentImpl
	 * @see org.eclipse.ocl.pivot.internal.env.impl.EnvPackageImpl#getEnvironment()
	 * @generated
	 */
	int ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Named Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__NAMED_ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Add Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT_1 = 0;

	/**
	 * The operation id for the '<em>Add Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT___ADD_ELEMENT__STRING_NAMEDELEMENT_1 = 1;

	/**
	 * The operation id for the '<em>Add Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT___ADD_ELEMENTS__COLLECTION_1 = 2;

	/**
	 * The operation id for the '<em>Add Elements Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT___ADD_ELEMENTS_OF__NAMESPACE = 3;

	/**
	 * The operation id for the '<em>Has Final Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT___HAS_FINAL_RESULT = 4;

	/**
	 * The operation id for the '<em>Nested Env</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT___NESTED_ENV = 5;

	/**
	 * The number of operations of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_OPERATION_COUNT = 6;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.internal.lookup.IEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see org.eclipse.ocl.pivot.internal.lookup.IEnvironment
	 * @model instanceClass="org.eclipse.ocl.pivot.internal.lookup.IEnvironment"
	 * @generated
	 */
	EClass getEnvironment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.internal.lookup.IEnvironment#getNamedElements <em>Named Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Named Elements</em>'.
	 * @see org.eclipse.ocl.pivot.internal.lookup.IEnvironment#getNamedElements()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_NamedElements();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.internal.lookup.IEnvironment#addElement(org.eclipse.ocl.pivot.NamedElement) <em>Add Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Element</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.IEnvironment#addElement(org.eclipse.ocl.pivot.NamedElement)
	 * @generated
	 */
	EOperation getEnvironment__AddElement__NamedElement_1();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.internal.lookup.IEnvironment#addElement(java.lang.String, org.eclipse.ocl.pivot.NamedElement) <em>Add Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Element</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.IEnvironment#addElement(java.lang.String, org.eclipse.ocl.pivot.NamedElement)
	 * @generated
	 */
	EOperation getEnvironment__AddElement__String_NamedElement_1();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.internal.lookup.IEnvironment#addElements(java.util.Collection) <em>Add Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Elements</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.IEnvironment#addElements(java.util.Collection)
	 * @generated
	 */
	EOperation getEnvironment__AddElements__Collection_1();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.internal.lookup.IEnvironment#addElementsOf(org.eclipse.ocl.pivot.Namespace) <em>Add Elements Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Elements Of</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.IEnvironment#addElementsOf(org.eclipse.ocl.pivot.Namespace)
	 * @generated
	 */
	EOperation getEnvironment__AddElementsOf__Namespace();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.internal.lookup.IEnvironment#hasFinalResult() <em>Has Final Result</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Final Result</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.IEnvironment#hasFinalResult()
	 * @generated
	 */
	EOperation getEnvironment__HasFinalResult_1();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.internal.lookup.IEnvironment#nestedEnv() <em>Nested Env</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Nested Env</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.IEnvironment#nestedEnv()
	 * @generated
	 */
	EOperation getEnvironment__NestedEnv_1();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EnvFactory getEnvFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.env.impl.EnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.env.impl.EnvironmentImpl
		 * @see org.eclipse.ocl.pivot.internal.env.impl.EnvPackageImpl#getEnvironment()
		 * @generated
		 */
		EClass ENVIRONMENT = eINSTANCE.getEnvironment();

		/**
		 * The meta object literal for the '<em><b>Named Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__NAMED_ELEMENTS = eINSTANCE.getEnvironment_NamedElements();

		/**
		 * The meta object literal for the '<em><b>Add Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT_1 = eINSTANCE.getEnvironment__AddElement__NamedElement_1();

		/**
		 * The meta object literal for the '<em><b>Add Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENVIRONMENT___ADD_ELEMENT__STRING_NAMEDELEMENT_1 = eINSTANCE.getEnvironment__AddElement__String_NamedElement_1();

		/**
		 * The meta object literal for the '<em><b>Add Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENVIRONMENT___ADD_ELEMENTS__COLLECTION_1 = eINSTANCE.getEnvironment__AddElements__Collection_1();

		/**
		 * The meta object literal for the '<em><b>Add Elements Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENVIRONMENT___ADD_ELEMENTS_OF__NAMESPACE = eINSTANCE.getEnvironment__AddElementsOf__Namespace();

		/**
		 * The meta object literal for the '<em><b>Has Final Result</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENVIRONMENT___HAS_FINAL_RESULT = eINSTANCE.getEnvironment__HasFinalResult_1();

		/**
		 * The meta object literal for the '<em><b>Nested Env</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENVIRONMENT___NESTED_ENV = eINSTANCE.getEnvironment__NestedEnv_1();

	}

} //EnvPackage
