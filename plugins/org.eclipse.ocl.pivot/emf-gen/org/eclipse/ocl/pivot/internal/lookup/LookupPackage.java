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
package org.eclipse.ocl.pivot.internal.lookup;

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
 * @see org.eclipse.ocl.pivot.internal.lookup.LookupFactory
 * @model kind="package"
 * @generated
 */
public interface LookupPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "lookup"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2015/Lookup"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "lookup"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LookupPackage eINSTANCE = org.eclipse.ocl.pivot.internal.lookup.impl.LookupPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.internal.lookup.impl.EnvironmentImpl <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.internal.lookup.impl.EnvironmentImpl
	 * @see org.eclipse.ocl.pivot.internal.lookup.impl.LookupPackageImpl#getEnvironment()
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
	int ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT = 0;

	/**
	 * The operation id for the '<em>Add Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT___ADD_ELEMENT__STRING_NAMEDELEMENT = 1;

	/**
	 * The operation id for the '<em>Add Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT___ADD_ELEMENTS__COLLECTION = 2;

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment
	 * @model instanceClass="org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment"
	 * @generated
	 */
	EClass getEnvironment();

	/**
	 * Returns the meta object for the reference list '<em>Named Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Named Elements</em>'.
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_NamedElements();

	/**
	 * Returns the meta object for the '<em>Add Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Element</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#addElement(org.eclipse.ocl.pivot.NamedElement)
	 * @generated
	 */
	EOperation getEnvironment__AddElement__NamedElement();

	/**
	 * Returns the meta object for the '<em>Add Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Element</em>' operation.
	 * @generated
	 */
	EOperation getEnvironment__AddElement__String_NamedElement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#addElements(java.util.Collection) <em>Add Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Elements</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#addElements(java.util.Collection)
	 * @generated
	 */
	EOperation getEnvironment__AddElements__Collection();

	/**
	 * Returns the meta object for the '<em>Add Elements Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Elements Of</em>' operation.
	 * @generated
	 */
	EOperation getEnvironment__AddElementsOf__Namespace();

	/**
	 * Returns the meta object for the '<em>Has Final Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Final Result</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#hasFinalResult()
	 * @generated
	 */
	EOperation getEnvironment__HasFinalResult();

	/**
	 * Returns the meta object for the '<em>Nested Env</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Nested Env</em>' operation.
	 * @generated
	 */
	EOperation getEnvironment__NestedEnv();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LookupFactory getLookupFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.lookup.impl.EnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.lookup.impl.EnvironmentImpl
		 * @see org.eclipse.ocl.pivot.internal.lookup.impl.LookupPackageImpl#getEnvironment()
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
		EOperation ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT = eINSTANCE.getEnvironment__AddElement__NamedElement();

		/**
		 * The meta object literal for the '<em><b>Add Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENVIRONMENT___ADD_ELEMENT__STRING_NAMEDELEMENT = eINSTANCE.getEnvironment__AddElement__String_NamedElement();

		/**
		 * The meta object literal for the '<em><b>Add Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENVIRONMENT___ADD_ELEMENTS__COLLECTION = eINSTANCE.getEnvironment__AddElements__Collection();

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
		EOperation ENVIRONMENT___HAS_FINAL_RESULT = eINSTANCE.getEnvironment__HasFinalResult();

		/**
		 * The meta object literal for the '<em><b>Nested Env</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENVIRONMENT___NESTED_ENV = eINSTANCE.getEnvironment__NestedEnv();

	}

} //LookupPackage
