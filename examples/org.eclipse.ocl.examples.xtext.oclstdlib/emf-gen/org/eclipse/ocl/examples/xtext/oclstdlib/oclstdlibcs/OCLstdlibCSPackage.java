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

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' pivot='../../org.eclipse.ocl.examples.pivot/model/Pivot.ecore#/' basecs='../../org.eclipse.ocl.examples.xtext.base/model/BaseCS.ecore#/' essentialoclcs='../../org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCS.ecore#/'"
 * @generated
 */
public interface OCLstdlibCSPackage
		extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclstdlibcs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/OCLstdlibCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "oclstdlibcs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLstdlibCSPackage eINSTANCE = org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibConstraintCSImpl <em>Lib Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibConstraintCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibConstraintCS()
	 * @generated
	 */
	int LIB_CONSTRAINT_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibIterationCSImpl <em>Lib Iteration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibIterationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibIterationCS()
	 * @generated
	 */
	int LIB_ITERATION_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibOperationCSImpl <em>Lib Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibOperationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibOperationCS()
	 * @generated
	 */
	int LIB_OPERATION_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibPropertyCSImpl <em>Lib Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibPropertyCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibPropertyCS()
	 * @generated
	 */
	int LIB_PROPERTY_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS <em>Java Implementation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getJavaImplementationCS()
	 * @generated
	 */
	int JAVA_IMPLEMENTATION_CS = 0;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_IMPLEMENTATION_CS__IMPLEMENTATION = 0;

	/**
	 * The number of structural features of the '<em>Java Implementation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_IMPLEMENTATION_CS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibClassCSImpl <em>Lib Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibClassCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibClassCS()
	 * @generated
	 */
	int LIB_CLASS_CS = 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__LOGICAL_PARENT = BaseCSPackage.CLASS_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__PIVOT = BaseCSPackage.CLASS_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_ANNOTATION = BaseCSPackage.CLASS_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__ORIGINAL_XMI_ID = BaseCSPackage.CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__CSI = BaseCSPackage.CLASS_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__NAME = BaseCSPackage.CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSPackage.CLASS_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNER = BaseCSPackage.CLASS_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__INSTANCE_CLASS_NAME = BaseCSPackage.CLASS_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_CONSTRAINT = BaseCSPackage.CLASS_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__QUALIFIER = BaseCSPackage.CLASS_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Super Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_SUPER_TYPE = BaseCSPackage.CLASS_CS__OWNED_SUPER_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_OPERATION = BaseCSPackage.CLASS_CS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Owned Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_PROPERTY = BaseCSPackage.CLASS_CS__OWNED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Owned Meta Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__OWNED_META_TYPE = BaseCSPackage.CLASS_CS__OWNED_META_TYPE;

	/**
	 * The feature id for the '<em><b>Meta Type Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS__META_TYPE_NAME = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lib Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CLASS_CS_FEATURE_COUNT = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__LOGICAL_PARENT = BaseCSPackage.CONSTRAINT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__PIVOT = BaseCSPackage.CONSTRAINT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__OWNED_ANNOTATION = BaseCSPackage.CONSTRAINT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__ORIGINAL_XMI_ID = BaseCSPackage.CONSTRAINT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__CSI = BaseCSPackage.CONSTRAINT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__NAME = BaseCSPackage.CONSTRAINT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__STEREOTYPE = BaseCSPackage.CONSTRAINT_CS__STEREOTYPE;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__SPECIFICATION = BaseCSPackage.CONSTRAINT_CS__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Message Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS__MESSAGE_SPECIFICATION = BaseCSPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION;

	/**
	 * The number of structural features of the '<em>Lib Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_CONSTRAINT_CS_FEATURE_COUNT = BaseCSPackage.CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__LOGICAL_PARENT = BaseCSPackage.OPERATION_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__PIVOT = BaseCSPackage.OPERATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_ANNOTATION = BaseCSPackage.OPERATION_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__CSI = BaseCSPackage.OPERATION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__NAME = BaseCSPackage.OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_TYPE = BaseCSPackage.OPERATION_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__QUALIFIER = BaseCSPackage.OPERATION_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OPTIONAL = BaseCSPackage.OPERATION_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNING_CLASS = BaseCSPackage.OPERATION_CS__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_PARAMETER = BaseCSPackage.OPERATION_CS__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Owned Exception</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_EXCEPTION = BaseCSPackage.OPERATION_CS__OWNED_EXCEPTION;

	/**
	 * The feature id for the '<em><b>Owned Precondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_PRECONDITION = BaseCSPackage.OPERATION_CS__OWNED_PRECONDITION;

	/**
	 * The feature id for the '<em><b>Owned Postcondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_POSTCONDITION = BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITION;

	/**
	 * The feature id for the '<em><b>Owned Body Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_BODY_EXPRESSION = BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__IMPLEMENTATION = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_ITERATOR = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Accumulator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__OWNED_ACCUMULATOR = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__INVALIDATING = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS__VALIDATING = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Lib Iteration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ITERATION_CS_FEATURE_COUNT = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__LOGICAL_PARENT = BaseCSPackage.OPERATION_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__PIVOT = BaseCSPackage.OPERATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_ANNOTATION = BaseCSPackage.OPERATION_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__CSI = BaseCSPackage.OPERATION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__NAME = BaseCSPackage.OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_TYPE = BaseCSPackage.OPERATION_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__QUALIFIER = BaseCSPackage.OPERATION_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OPTIONAL = BaseCSPackage.OPERATION_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNING_CLASS = BaseCSPackage.OPERATION_CS__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_PARAMETER = BaseCSPackage.OPERATION_CS__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Owned Exception</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_EXCEPTION = BaseCSPackage.OPERATION_CS__OWNED_EXCEPTION;

	/**
	 * The feature id for the '<em><b>Owned Precondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_PRECONDITION = BaseCSPackage.OPERATION_CS__OWNED_PRECONDITION;

	/**
	 * The feature id for the '<em><b>Owned Postcondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_POSTCONDITION = BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITION;

	/**
	 * The feature id for the '<em><b>Owned Body Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__OWNED_BODY_EXPRESSION = BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__IMPLEMENTATION = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__PRECEDENCE = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__INVALIDATING = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__STATIC = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS__VALIDATING = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Lib Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_OPERATION_CS_FEATURE_COUNT = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibPackageCSImpl <em>Lib Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibPackageCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibPackageCS()
	 * @generated
	 */
	int LIB_PACKAGE_CS = 5;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__LOGICAL_PARENT = BaseCSPackage.PACKAGE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__PIVOT = BaseCSPackage.PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__OWNED_ANNOTATION = BaseCSPackage.PACKAGE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__ORIGINAL_XMI_ID = BaseCSPackage.PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__CSI = BaseCSPackage.PACKAGE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__OWNED_NESTED_PACKAGE = BaseCSPackage.PACKAGE_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__NAME = BaseCSPackage.PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__OWNED_TYPE = BaseCSPackage.PACKAGE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__NS_PREFIX = BaseCSPackage.PACKAGE_CS__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__NS_URI = BaseCSPackage.PACKAGE_CS__NS_URI;

	/**
	 * The feature id for the '<em><b>Owned Precedence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS__OWNED_PRECEDENCE = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lib Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PACKAGE_CS_FEATURE_COUNT = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__LOGICAL_PARENT = BaseCSPackage.ATTRIBUTE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__PIVOT = BaseCSPackage.ATTRIBUTE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__OWNED_ANNOTATION = BaseCSPackage.ATTRIBUTE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__ORIGINAL_XMI_ID = BaseCSPackage.ATTRIBUTE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__CSI = BaseCSPackage.ATTRIBUTE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__NAME = BaseCSPackage.ATTRIBUTE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__OWNED_TYPE = BaseCSPackage.ATTRIBUTE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__QUALIFIER = BaseCSPackage.ATTRIBUTE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__OPTIONAL = BaseCSPackage.ATTRIBUTE_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__OWNER = BaseCSPackage.ATTRIBUTE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__DEFAULT = BaseCSPackage.ATTRIBUTE_CS__DEFAULT;

	/**
	 * The feature id for the '<em><b>Owned Default Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__OWNED_DEFAULT_EXPRESSION = BaseCSPackage.ATTRIBUTE_CS__OWNED_DEFAULT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__IMPLEMENTATION = BaseCSPackage.ATTRIBUTE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS__STATIC = BaseCSPackage.ATTRIBUTE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Lib Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_PROPERTY_CS_FEATURE_COUNT = BaseCSPackage.ATTRIBUTE_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibRootPackageCSImpl <em>Lib Root Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibRootPackageCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibRootPackageCS()
	 * @generated
	 */
	int LIB_ROOT_PACKAGE_CS = 7;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__LOGICAL_PARENT = BaseCSPackage.ROOT_PACKAGE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__PIVOT = BaseCSPackage.ROOT_PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__OWNED_ANNOTATION = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__ORIGINAL_XMI_ID = BaseCSPackage.ROOT_PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__CSI = BaseCSPackage.ROOT_PACKAGE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__OWNED_NESTED_PACKAGE = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__OWNED_IMPORT = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS__OWNED_LIBRARY = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY;

	/**
	 * The number of structural features of the '<em>Lib Root Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIB_ROOT_PACKAGE_CS_FEATURE_COUNT = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.MetaTypeNameImpl <em>Meta Type Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.MetaTypeNameImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getMetaTypeName()
	 * @generated
	 */
	int META_TYPE_NAME = 8;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_TYPE_NAME__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_TYPE_NAME__NAME = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Meta Type Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_TYPE_NAME_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.PrecedenceCSImpl <em>Precedence CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.PrecedenceCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getPrecedenceCS()
	 * @generated
	 */
	int PRECEDENCE_CS = 9;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__LOGICAL_PARENT = BaseCSPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__PIVOT = BaseCSPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__OWNED_ANNOTATION = BaseCSPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__ORIGINAL_XMI_ID = BaseCSPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__CSI = BaseCSPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__NAME = BaseCSPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Right Associative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS__RIGHT_ASSOCIATIVE = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Precedence CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_CS_FEATURE_COUNT = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS <em>Lib Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Class CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS
	 * @generated
	 */
	EClass getLibClassCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS#getMetaTypeName <em>Meta Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Meta Type Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS#getMetaTypeName()
	 * @see #getLibClassCS()
	 * @generated
	 */
	EReference getLibClassCS_MetaTypeName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibConstraintCS <em>Lib Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Constraint CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibConstraintCS
	 * @generated
	 */
	EClass getLibConstraintCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS <em>Lib Iteration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Iteration CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS
	 * @generated
	 */
	EClass getLibIterationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS#getOwnedIterator <em>Owned Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Iterator</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS#getOwnedIterator()
	 * @see #getLibIterationCS()
	 * @generated
	 */
	EReference getLibIterationCS_OwnedIterator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS#getOwnedAccumulator <em>Owned Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Accumulator</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS#getOwnedAccumulator()
	 * @see #getLibIterationCS()
	 * @generated
	 */
	EReference getLibIterationCS_OwnedAccumulator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS#isInvalidating <em>Invalidating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invalidating</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS#isInvalidating()
	 * @see #getLibIterationCS()
	 * @generated
	 */
	EAttribute getLibIterationCS_Invalidating();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS#isValidating <em>Validating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validating</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS#isValidating()
	 * @see #getLibIterationCS()
	 * @generated
	 */
	EAttribute getLibIterationCS_Validating();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS <em>Lib Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Operation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS
	 * @generated
	 */
	EClass getLibOperationCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#getPrecedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Precedence</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#getPrecedence()
	 * @see #getLibOperationCS()
	 * @generated
	 */
	EReference getLibOperationCS_Precedence();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isInvalidating <em>Invalidating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invalidating</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isInvalidating()
	 * @see #getLibOperationCS()
	 * @generated
	 */
	EAttribute getLibOperationCS_Invalidating();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isStatic()
	 * @see #getLibOperationCS()
	 * @generated
	 */
	EAttribute getLibOperationCS_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isValidating <em>Validating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validating</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isValidating()
	 * @see #getLibOperationCS()
	 * @generated
	 */
	EAttribute getLibOperationCS_Validating();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS <em>Lib Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Package CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS
	 * @generated
	 */
	EClass getLibPackageCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS#getOwnedPrecedence <em>Owned Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Precedence</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS#getOwnedPrecedence()
	 * @see #getLibPackageCS()
	 * @generated
	 */
	EReference getLibPackageCS_OwnedPrecedence();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS <em>Lib Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Property CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS
	 * @generated
	 */
	EClass getLibPropertyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS#isStatic()
	 * @see #getLibPropertyCS()
	 * @generated
	 */
	EAttribute getLibPropertyCS_Static();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS <em>Lib Root Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Root Package CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS
	 * @generated
	 */
	EClass getLibRootPackageCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaTypeName <em>Meta Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Type Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaTypeName
	 * @generated
	 */
	EClass getMetaTypeName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaTypeName#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaTypeName#getName()
	 * @see #getMetaTypeName()
	 * @generated
	 */
	EAttribute getMetaTypeName_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS <em>Java Implementation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Implementation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS
	 * @generated
	 */
	EClass getJavaImplementationCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS#getImplementation()
	 * @see #getJavaImplementationCS()
	 * @generated
	 */
	EReference getJavaImplementationCS_Implementation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS <em>Precedence CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precedence CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS
	 * @generated
	 */
	EClass getPrecedenceCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS#isRightAssociative <em>Right Associative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right Associative</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS#isRightAssociative()
	 * @see #getPrecedenceCS()
	 * @generated
	 */
	EAttribute getPrecedenceCS_RightAssociative();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OCLstdlibCSFactory getOCLstdlibCSFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibClassCSImpl <em>Lib Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibClassCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibClassCS()
		 * @generated
		 */
		EClass LIB_CLASS_CS = eINSTANCE.getLibClassCS();

		/**
		 * The meta object literal for the '<em><b>Meta Type Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_CLASS_CS__META_TYPE_NAME = eINSTANCE.getLibClassCS_MetaTypeName();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibConstraintCSImpl <em>Lib Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibConstraintCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibConstraintCS()
		 * @generated
		 */
		EClass LIB_CONSTRAINT_CS = eINSTANCE.getLibConstraintCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibIterationCSImpl <em>Lib Iteration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibIterationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibIterationCS()
		 * @generated
		 */
		EClass LIB_ITERATION_CS = eINSTANCE.getLibIterationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Iterator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_ITERATION_CS__OWNED_ITERATOR = eINSTANCE.getLibIterationCS_OwnedIterator();

		/**
		 * The meta object literal for the '<em><b>Owned Accumulator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_ITERATION_CS__OWNED_ACCUMULATOR = eINSTANCE.getLibIterationCS_OwnedAccumulator();

		/**
		 * The meta object literal for the '<em><b>Invalidating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_ITERATION_CS__INVALIDATING = eINSTANCE.getLibIterationCS_Invalidating();

		/**
		 * The meta object literal for the '<em><b>Validating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_ITERATION_CS__VALIDATING = eINSTANCE.getLibIterationCS_Validating();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibOperationCSImpl <em>Lib Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibOperationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibOperationCS()
		 * @generated
		 */
		EClass LIB_OPERATION_CS = eINSTANCE.getLibOperationCS();

		/**
		 * The meta object literal for the '<em><b>Precedence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_OPERATION_CS__PRECEDENCE = eINSTANCE.getLibOperationCS_Precedence();

		/**
		 * The meta object literal for the '<em><b>Invalidating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_OPERATION_CS__INVALIDATING = eINSTANCE.getLibOperationCS_Invalidating();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_OPERATION_CS__STATIC = eINSTANCE.getLibOperationCS_Static();

		/**
		 * The meta object literal for the '<em><b>Validating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_OPERATION_CS__VALIDATING = eINSTANCE.getLibOperationCS_Validating();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibPackageCSImpl <em>Lib Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibPackageCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibPackageCS()
		 * @generated
		 */
		EClass LIB_PACKAGE_CS = eINSTANCE.getLibPackageCS();

		/**
		 * The meta object literal for the '<em><b>Owned Precedence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_PACKAGE_CS__OWNED_PRECEDENCE = eINSTANCE.getLibPackageCS_OwnedPrecedence();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibPropertyCSImpl <em>Lib Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibPropertyCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibPropertyCS()
		 * @generated
		 */
		EClass LIB_PROPERTY_CS = eINSTANCE.getLibPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_PROPERTY_CS__STATIC = eINSTANCE.getLibPropertyCS_Static();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibRootPackageCSImpl <em>Lib Root Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.LibRootPackageCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibRootPackageCS()
		 * @generated
		 */
		EClass LIB_ROOT_PACKAGE_CS = eINSTANCE.getLibRootPackageCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.MetaTypeNameImpl <em>Meta Type Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.MetaTypeNameImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getMetaTypeName()
		 * @generated
		 */
		EClass META_TYPE_NAME = eINSTANCE.getMetaTypeName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_TYPE_NAME__NAME = eINSTANCE.getMetaTypeName_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS <em>Java Implementation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getJavaImplementationCS()
		 * @generated
		 */
		EClass JAVA_IMPLEMENTATION_CS = eINSTANCE.getJavaImplementationCS();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_IMPLEMENTATION_CS__IMPLEMENTATION = eINSTANCE.getJavaImplementationCS_Implementation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.PrecedenceCSImpl <em>Precedence CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.PrecedenceCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getPrecedenceCS()
		 * @generated
		 */
		EClass PRECEDENCE_CS = eINSTANCE.getPrecedenceCS();

		/**
		 * The meta object literal for the '<em><b>Right Associative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRECEDENCE_CS__RIGHT_ASSOCIATIVE = eINSTANCE.getPrecedenceCS_RightAssociative();

	}

} //OCLstdlibCSPackage
