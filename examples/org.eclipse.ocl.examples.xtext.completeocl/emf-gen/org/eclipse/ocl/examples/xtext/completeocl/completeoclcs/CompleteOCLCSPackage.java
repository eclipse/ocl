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
package org.eclipse.ocl.examples.xtext.completeocl.completeoclcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;

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
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' pivot='../../org.eclipse.ocl.examples.pivot/model/Pivot.ecore#/' basecs='../../org.eclipse.ocl.examples.xtext.base/model/BaseCS.ecore#/' essentialoclcs='../../org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCS.ecore#/'"
 * @generated
 */
public interface CompleteOCLCSPackage
		extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "completeoclcs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/CompleteOCLCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "completeoclcs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompleteOCLCSPackage eINSTANCE = org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PackageDeclarationCSImpl <em>Package Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PackageDeclarationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getPackageDeclarationCS()
	 * @generated
	 */
	int PACKAGE_DECLARATION_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ContextDeclCSImpl <em>Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ContextDeclCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getContextDeclCS()
	 * @generated
	 */
	int CONTEXT_DECL_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PropertyContextDeclCSImpl <em>Property Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PropertyContextDeclCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getPropertyContextDeclCS()
	 * @generated
	 */
	int PROPERTY_CONTEXT_DECL_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ClassifierContextDeclCSImpl <em>Classifier Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ClassifierContextDeclCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getClassifierContextDeclCS()
	 * @generated
	 */
	int CLASSIFIER_CONTEXT_DECL_CS = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefCSImpl <em>Def CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefCS()
	 * @generated
	 */
	int DEF_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OperationContextDeclCSImpl <em>Operation Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OperationContextDeclCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getOperationContextDeclCS()
	 * @generated
	 */
	int OPERATION_CONTEXT_DECL_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PathNameDeclCSImpl <em>Path Name Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PathNameDeclCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getPathNameDeclCS()
	 * @generated
	 */
	int PATH_NAME_DECL_CS = 11;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_DECL_CS__LOGICAL_PARENT = BaseCSPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_DECL_CS__PIVOT = BaseCSPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_DECL_CS__OWNED_ANNOTATION = BaseCSPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_DECL_CS__ORIGINAL_XMI_ID = BaseCSPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_DECL_CS__CSI = BaseCSPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_DECL_CS__PATH_NAME = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Name Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_DECL_CS_FEATURE_COUNT = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECL_CS__LOGICAL_PARENT = PATH_NAME_DECL_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECL_CS__PIVOT = PATH_NAME_DECL_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECL_CS__OWNED_ANNOTATION = PATH_NAME_DECL_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECL_CS__ORIGINAL_XMI_ID = PATH_NAME_DECL_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECL_CS__CSI = PATH_NAME_DECL_CS__CSI;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECL_CS__PATH_NAME = PATH_NAME_DECL_CS__PATH_NAME;

	/**
	 * The number of structural features of the '<em>Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DECL_CS_FEATURE_COUNT = PATH_NAME_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__LOGICAL_PARENT = CONTEXT_DECL_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__PIVOT = CONTEXT_DECL_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__OWNED_ANNOTATION = CONTEXT_DECL_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__ORIGINAL_XMI_ID = CONTEXT_DECL_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__CSI = CONTEXT_DECL_CS__CSI;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME = CONTEXT_DECL_CS__PATH_NAME;

	/**
	 * The feature id for the '<em><b>Self Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME = CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__CLASSIFIER = CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS = CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS = CONTEXT_DECL_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Classifier Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CONTEXT_DECL_CS_FEATURE_COUNT = CONTEXT_DECL_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl <em>Complete OCL Document CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getCompleteOCLDocumentCS()
	 * @generated
	 */
	int COMPLETE_OCL_DOCUMENT_CS = 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__LOGICAL_PARENT = BaseCSPackage.NAMESPACE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__PIVOT = BaseCSPackage.NAMESPACE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__OWNED_ANNOTATION = BaseCSPackage.NAMESPACE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__ORIGINAL_XMI_ID = BaseCSPackage.NAMESPACE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__CSI = BaseCSPackage.NAMESPACE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__NAME = BaseCSPackage.NAMESPACE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__OWNED_IMPORT = BaseCSPackage.NAMESPACE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__OWNED_LIBRARY = BaseCSPackage.NAMESPACE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__PACKAGES = BaseCSPackage.NAMESPACE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__CONTEXTS = BaseCSPackage.NAMESPACE_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Include</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDE = BaseCSPackage.NAMESPACE_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Complete OCL Document CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_OCL_DOCUMENT_CS_FEATURE_COUNT = BaseCSPackage.NAMESPACE_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__LOGICAL_PARENT = BaseCSPackage.TYPED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__OWNED_ANNOTATION = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__QUALIFIER = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Classifier Context Decl</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__CLASSIFIER_CONTEXT_DECL = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__SPECIFICATION = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS__STATIC = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Def CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefOperationCSImpl <em>Def Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefOperationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefOperationCS()
	 * @generated
	 */
	int DEF_OPERATION_CS = 4;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__LOGICAL_PARENT = DEF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__PIVOT = DEF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__OWNED_ANNOTATION = DEF_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__ORIGINAL_XMI_ID = DEF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__CSI = DEF_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__NAME = DEF_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__OWNED_TYPE = DEF_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__QUALIFIER = DEF_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__OPTIONAL = DEF_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Classifier Context Decl</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__CLASSIFIER_CONTEXT_DECL = DEF_CS__CLASSIFIER_CONTEXT_DECL;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__SPECIFICATION = DEF_CS__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__STATIC = DEF_CS__STATIC;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS__PARAMETERS = DEF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Def Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_CS_FEATURE_COUNT = DEF_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefPropertyCSImpl <em>Def Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefPropertyCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefPropertyCS()
	 * @generated
	 */
	int DEF_PROPERTY_CS = 5;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__LOGICAL_PARENT = DEF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__PIVOT = DEF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__OWNED_ANNOTATION = DEF_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__ORIGINAL_XMI_ID = DEF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__CSI = DEF_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__NAME = DEF_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__OWNED_TYPE = DEF_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__QUALIFIER = DEF_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__OPTIONAL = DEF_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Classifier Context Decl</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__CLASSIFIER_CONTEXT_DECL = DEF_CS__CLASSIFIER_CONTEXT_DECL;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__SPECIFICATION = DEF_CS__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS__STATIC = DEF_CS__STATIC;

	/**
	 * The number of structural features of the '<em>Def Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_PROPERTY_CS_FEATURE_COUNT = DEF_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.FeatureContextDeclCSImpl <em>Feature Context Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.FeatureContextDeclCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getFeatureContextDeclCS()
	 * @generated
	 */
	int FEATURE_CONTEXT_DECL_CS = 6;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS__LOGICAL_PARENT = CONTEXT_DECL_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS__PIVOT = CONTEXT_DECL_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS__OWNED_ANNOTATION = CONTEXT_DECL_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS__ORIGINAL_XMI_ID = CONTEXT_DECL_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS__CSI = CONTEXT_DECL_CS__CSI;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS__PATH_NAME = CONTEXT_DECL_CS__PATH_NAME;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS__CLASS = CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS__OWNED_TYPE = CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT = CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.IncludeCSImpl <em>Include CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.IncludeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getIncludeCS()
	 * @generated
	 */
	int INCLUDE_CS = 7;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_CS__LOGICAL_PARENT = BaseCSPackage.NAMESPACE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_CS__PIVOT = BaseCSPackage.NAMESPACE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_CS__OWNED_ANNOTATION = BaseCSPackage.NAMESPACE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_CS__ORIGINAL_XMI_ID = BaseCSPackage.NAMESPACE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_CS__CSI = BaseCSPackage.NAMESPACE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_CS__NAME = BaseCSPackage.NAMESPACE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_CS__NAMESPACE = BaseCSPackage.NAMESPACE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Include CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_CS_FEATURE_COUNT = BaseCSPackage.NAMESPACE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OCLMessageArgCSImpl <em>OCL Message Arg CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OCLMessageArgCSImpl
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getOCLMessageArgCS()
	 * @generated
	 */
	int OCL_MESSAGE_ARG_CS = 8;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS__LOGICAL_PARENT = EssentialOCLCSPackage.EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS__PIVOT = EssentialOCLCSPackage.EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS__OWNED_ANNOTATION = EssentialOCLCSPackage.EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS__CSI = EssentialOCLCSPackage.EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS__PARENT = EssentialOCLCSPackage.EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS__HAS_ERROR = EssentialOCLCSPackage.EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS__TYPE = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OCL Message Arg CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_CS_FEATURE_COUNT = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__LOGICAL_PARENT = FEATURE_CONTEXT_DECL_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__PIVOT = FEATURE_CONTEXT_DECL_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__OWNED_ANNOTATION = FEATURE_CONTEXT_DECL_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__ORIGINAL_XMI_ID = FEATURE_CONTEXT_DECL_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__CSI = FEATURE_CONTEXT_DECL_CS__CSI;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__PATH_NAME = FEATURE_CONTEXT_DECL_CS__PATH_NAME;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__CLASS = FEATURE_CONTEXT_DECL_CS__CLASS;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__OWNED_TYPE = FEATURE_CONTEXT_DECL_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__OPERATION = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__PARAMETERS = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__RESULT = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__PRECONDITIONS = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Bodies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS__BODIES = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Operation Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTEXT_DECL_CS_FEATURE_COUNT = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__LOGICAL_PARENT = PATH_NAME_DECL_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__PIVOT = PATH_NAME_DECL_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__OWNED_ANNOTATION = PATH_NAME_DECL_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__ORIGINAL_XMI_ID = PATH_NAME_DECL_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__CSI = PATH_NAME_DECL_CS__CSI;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__PATH_NAME = PATH_NAME_DECL_CS__PATH_NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__PACKAGE = PATH_NAME_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS__CONTEXTS = PATH_NAME_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECLARATION_CS_FEATURE_COUNT = PATH_NAME_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__LOGICAL_PARENT = FEATURE_CONTEXT_DECL_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__PIVOT = FEATURE_CONTEXT_DECL_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__OWNED_ANNOTATION = FEATURE_CONTEXT_DECL_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__ORIGINAL_XMI_ID = FEATURE_CONTEXT_DECL_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__CSI = FEATURE_CONTEXT_DECL_CS__CSI;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__PATH_NAME = FEATURE_CONTEXT_DECL_CS__PATH_NAME;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__CLASS = FEATURE_CONTEXT_DECL_CS__CLASS;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__OWNED_TYPE = FEATURE_CONTEXT_DECL_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__PROPERTY = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__DEFAULT_EXPRESSIONS = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Derived Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS__DERIVED_INVARIANTS = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Context Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTEXT_DECL_CS_FEATURE_COUNT = FEATURE_CONTEXT_DECL_CS_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.FeatureContextDeclCS <em>Feature Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Context Decl CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.FeatureContextDeclCS
	 * @generated
	 */
	EClass getFeatureContextDeclCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.FeatureContextDeclCS#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.FeatureContextDeclCS#getClass_()
	 * @see #getFeatureContextDeclCS()
	 * @generated
	 */
	EReference getFeatureContextDeclCS_Class();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.FeatureContextDeclCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.FeatureContextDeclCS#getOwnedType()
	 * @see #getFeatureContextDeclCS()
	 * @generated
	 */
	EReference getFeatureContextDeclCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS <em>Include CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Include CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS
	 * @generated
	 */
	EClass getIncludeCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Namespace</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS#getNamespace()
	 * @see #getIncludeCS()
	 * @generated
	 */
	EReference getIncludeCS_Namespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS <em>Package Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Declaration CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS
	 * @generated
	 */
	EClass getPackageDeclarationCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS#getPackage()
	 * @see #getPackageDeclarationCS()
	 * @generated
	 */
	EReference getPackageDeclarationCS_Package();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS#getContexts()
	 * @see #getPackageDeclarationCS()
	 * @generated
	 */
	EReference getPackageDeclarationCS_Contexts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PathNameDeclCS <em>Path Name Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Name Decl CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PathNameDeclCS
	 * @generated
	 */
	EClass getPathNameDeclCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PathNameDeclCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PathNameDeclCS#getPathName()
	 * @see #getPathNameDeclCS()
	 * @generated
	 */
	EReference getPathNameDeclCS_PathName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS <em>Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Decl CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS
	 * @generated
	 */
	EClass getContextDeclCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS <em>Property Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Context Decl CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS
	 * @generated
	 */
	EClass getPropertyContextDeclCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS#getProperty()
	 * @see #getPropertyContextDeclCS()
	 * @generated
	 */
	EReference getPropertyContextDeclCS_Property();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS#getDefaultExpressions <em>Default Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Default Expressions</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS#getDefaultExpressions()
	 * @see #getPropertyContextDeclCS()
	 * @generated
	 */
	EReference getPropertyContextDeclCS_DefaultExpressions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS#getDerivedInvariants <em>Derived Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Derived Invariants</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS#getDerivedInvariants()
	 * @see #getPropertyContextDeclCS()
	 * @generated
	 */
	EReference getPropertyContextDeclCS_DerivedInvariants();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompleteOCLCSFactory getCompleteOCLCSFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS <em>Classifier Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Context Decl CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS
	 * @generated
	 */
	EClass getClassifierContextDeclCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Self Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getSelfName()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EAttribute getClassifierContextDeclCS_SelfName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Classifier</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getClassifier()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EReference getClassifierContextDeclCS_Classifier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getInvariants <em>Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invariants</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getInvariants()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EReference getClassifierContextDeclCS_Invariants();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getDefinitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Definitions</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS#getDefinitions()
	 * @see #getClassifierContextDeclCS()
	 * @generated
	 */
	EReference getClassifierContextDeclCS_Definitions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS <em>Complete OCL Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete OCL Document CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS
	 * @generated
	 */
	EClass getCompleteOCLDocumentCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS#getPackages()
	 * @see #getCompleteOCLDocumentCS()
	 * @generated
	 */
	EReference getCompleteOCLDocumentCS_Packages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS#getContexts()
	 * @see #getCompleteOCLDocumentCS()
	 * @generated
	 */
	EReference getCompleteOCLDocumentCS_Contexts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS#getOwnedInclude <em>Owned Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Include</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS#getOwnedInclude()
	 * @see #getCompleteOCLDocumentCS()
	 * @generated
	 */
	EReference getCompleteOCLDocumentCS_OwnedInclude();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OCLMessageArgCS <em>OCL Message Arg CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Message Arg CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OCLMessageArgCS
	 * @generated
	 */
	EClass getOCLMessageArgCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OCLMessageArgCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OCLMessageArgCS#getType()
	 * @see #getOCLMessageArgCS()
	 * @generated
	 */
	EReference getOCLMessageArgCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS <em>Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Def CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS
	 * @generated
	 */
	EClass getDefCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS#getClassifierContextDecl <em>Classifier Context Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Classifier Context Decl</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS#getClassifierContextDecl()
	 * @see #getDefCS()
	 * @generated
	 */
	EReference getDefCS_ClassifierContextDecl();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS#getSpecification()
	 * @see #getDefCS()
	 * @generated
	 */
	EReference getDefCS_Specification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS#isStatic()
	 * @see #getDefCS()
	 * @generated
	 */
	EAttribute getDefCS_Static();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS <em>Def Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Def Operation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS
	 * @generated
	 */
	EClass getDefOperationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS#getParameters()
	 * @see #getDefOperationCS()
	 * @generated
	 */
	EReference getDefOperationCS_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS <em>Def Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Def Property CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS
	 * @generated
	 */
	EClass getDefPropertyCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS <em>Operation Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Context Decl CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS
	 * @generated
	 */
	EClass getOperationContextDeclCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getOperation()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getParameters()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getResult()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Result();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getPreconditions <em>Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preconditions</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getPreconditions()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Preconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getPostconditions <em>Postconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postconditions</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getPostconditions()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Postconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getBodies <em>Bodies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bodies</em>'.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getBodies()
	 * @see #getOperationContextDeclCS()
	 * @generated
	 */
	EReference getOperationContextDeclCS_Bodies();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.FeatureContextDeclCSImpl <em>Feature Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.FeatureContextDeclCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getFeatureContextDeclCS()
		 * @generated
		 */
		EClass FEATURE_CONTEXT_DECL_CS = eINSTANCE.getFeatureContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONTEXT_DECL_CS__CLASS = eINSTANCE.getFeatureContextDeclCS_Class();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONTEXT_DECL_CS__OWNED_TYPE = eINSTANCE.getFeatureContextDeclCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.IncludeCSImpl <em>Include CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.IncludeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getIncludeCS()
		 * @generated
		 */
		EClass INCLUDE_CS = eINSTANCE.getIncludeCS();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUDE_CS__NAMESPACE = eINSTANCE.getIncludeCS_Namespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PackageDeclarationCSImpl <em>Package Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PackageDeclarationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getPackageDeclarationCS()
		 * @generated
		 */
		EClass PACKAGE_DECLARATION_CS = eINSTANCE.getPackageDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_DECLARATION_CS__PACKAGE = eINSTANCE.getPackageDeclarationCS_Package();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_DECLARATION_CS__CONTEXTS = eINSTANCE.getPackageDeclarationCS_Contexts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PathNameDeclCSImpl <em>Path Name Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PathNameDeclCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getPathNameDeclCS()
		 * @generated
		 */
		EClass PATH_NAME_DECL_CS = eINSTANCE.getPathNameDeclCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME_DECL_CS__PATH_NAME = eINSTANCE.getPathNameDeclCS_PathName();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ContextDeclCSImpl <em>Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ContextDeclCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getContextDeclCS()
		 * @generated
		 */
		EClass CONTEXT_DECL_CS = eINSTANCE.getContextDeclCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PropertyContextDeclCSImpl <em>Property Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.PropertyContextDeclCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getPropertyContextDeclCS()
		 * @generated
		 */
		EClass PROPERTY_CONTEXT_DECL_CS = eINSTANCE.getPropertyContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL_CS__PROPERTY = eINSTANCE.getPropertyContextDeclCS_Property();

		/**
		 * The meta object literal for the '<em><b>Default Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL_CS__DEFAULT_EXPRESSIONS = eINSTANCE.getPropertyContextDeclCS_DefaultExpressions();

		/**
		 * The meta object literal for the '<em><b>Derived Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTEXT_DECL_CS__DERIVED_INVARIANTS = eINSTANCE.getPropertyContextDeclCS_DerivedInvariants();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ClassifierContextDeclCSImpl <em>Classifier Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.ClassifierContextDeclCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getClassifierContextDeclCS()
		 * @generated
		 */
		EClass CLASSIFIER_CONTEXT_DECL_CS = eINSTANCE.getClassifierContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Self Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME = eINSTANCE.getClassifierContextDeclCS_SelfName();

		/**
		 * The meta object literal for the '<em><b>Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL_CS__CLASSIFIER = eINSTANCE.getClassifierContextDeclCS_Classifier();

		/**
		 * The meta object literal for the '<em><b>Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS = eINSTANCE.getClassifierContextDeclCS_Invariants();

		/**
		 * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS = eINSTANCE.getClassifierContextDeclCS_Definitions();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl <em>Complete OCL Document CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLDocumentCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getCompleteOCLDocumentCS()
		 * @generated
		 */
		EClass COMPLETE_OCL_DOCUMENT_CS = eINSTANCE.getCompleteOCLDocumentCS();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_OCL_DOCUMENT_CS__PACKAGES = eINSTANCE.getCompleteOCLDocumentCS_Packages();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_OCL_DOCUMENT_CS__CONTEXTS = eINSTANCE.getCompleteOCLDocumentCS_Contexts();

		/**
		 * The meta object literal for the '<em><b>Owned Include</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_OCL_DOCUMENT_CS__OWNED_INCLUDE = eINSTANCE.getCompleteOCLDocumentCS_OwnedInclude();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefCSImpl <em>Def CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefCS()
		 * @generated
		 */
		EClass DEF_CS = eINSTANCE.getDefCS();

		/**
		 * The meta object literal for the '<em><b>Classifier Context Decl</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF_CS__CLASSIFIER_CONTEXT_DECL = eINSTANCE.getDefCS_ClassifierContextDecl();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF_CS__SPECIFICATION = eINSTANCE.getDefCS_Specification();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEF_CS__STATIC = eINSTANCE.getDefCS_Static();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefOperationCSImpl <em>Def Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefOperationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefOperationCS()
		 * @generated
		 */
		EClass DEF_OPERATION_CS = eINSTANCE.getDefOperationCS();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF_OPERATION_CS__PARAMETERS = eINSTANCE.getDefOperationCS_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefPropertyCSImpl <em>Def Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.DefPropertyCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getDefPropertyCS()
		 * @generated
		 */
		EClass DEF_PROPERTY_CS = eINSTANCE.getDefPropertyCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OperationContextDeclCSImpl <em>Operation Context Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OperationContextDeclCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getOperationContextDeclCS()
		 * @generated
		 */
		EClass OPERATION_CONTEXT_DECL_CS = eINSTANCE.getOperationContextDeclCS();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__OPERATION = eINSTANCE.getOperationContextDeclCS_Operation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__PARAMETERS = eINSTANCE.getOperationContextDeclCS_Parameters();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__RESULT = eINSTANCE.getOperationContextDeclCS_Result();

		/**
		 * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__PRECONDITIONS = eINSTANCE.getOperationContextDeclCS_Preconditions();

		/**
		 * The meta object literal for the '<em><b>Postconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS = eINSTANCE.getOperationContextDeclCS_Postconditions();

		/**
		 * The meta object literal for the '<em><b>Bodies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTEXT_DECL_CS__BODIES = eINSTANCE.getOperationContextDeclCS_Bodies();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OCLMessageArgCSImpl <em>OCL Message Arg CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.OCLMessageArgCSImpl
		 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.impl.CompleteOCLCSPackageImpl#getOCLMessageArgCS()
		 * @generated
		 */
		EClass OCL_MESSAGE_ARG_CS = eINSTANCE.getOCLMessageArgCS();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_MESSAGE_ARG_CS__TYPE = eINSTANCE.getOCLMessageArgCS_Type();

	}

} //CompleteOCLCSPackage
