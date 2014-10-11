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
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' pivot='../../org.eclipse.ocl.examples.pivot/model/Pivot.ecore#/' basecs='../../org.eclipse.ocl.examples.xtext.base/model/BaseCS.ecore#/'"
 * @generated
 */
public interface EssentialOCLCSPackage
		extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "essentialoclcs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/EssentialOCLCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "essentialoclcs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EssentialOCLCSPackage eINSTANCE = org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ExpCSImpl <em>Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getExpCS()
	 * @generated
	 */
	int EXP_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionTypeCS()
	 * @generated
	 */
	int COLLECTION_TYPE_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLiteralExpCS()
	 * @generated
	 */
	int LITERAL_EXP_CS = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionLiteralExpCS()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionLiteralPartCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionLiteralPartCS()
	 * @generated
	 */
	int COLLECTION_LITERAL_PART_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PrimitiveLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPrimitiveLiteralExpCS()
	 * @generated
	 */
	int PRIMITIVE_LITERAL_EXP_CS = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TupleLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTupleLiteralExpCS()
	 * @generated
	 */
	int TUPLE_LITERAL_EXP_CS = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.StringLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getStringLiteralExpCS()
	 * @generated
	 */
	int STRING_LITERAL_EXP_CS = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.BooleanLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getBooleanLiteralExpCS()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InvalidLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getInvalidLiteralExpCS()
	 * @generated
	 */
	int INVALID_LITERAL_EXP_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NullLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNullLiteralExpCS()
	 * @generated
	 */
	int NULL_LITERAL_EXP_CS = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IfExpCSImpl <em>If Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IfExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIfExpCS()
	 * @generated
	 */
	int IF_EXP_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetExpCSImpl <em>Let Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLetExpCS()
	 * @generated
	 */
	int LET_EXP_CS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl <em>Infix Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getInfixExpCS()
	 * @generated
	 */
	int INFIX_EXP_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNameExpCS()
	 * @generated
	 */
	int NAME_EXP_CS = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TypeNameExpCSImpl <em>Type Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TypeNameExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTypeNameExpCS()
	 * @generated
	 */
	int TYPE_NAME_EXP_CS = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NavigatingArgCSImpl <em>Navigating Arg CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NavigatingArgCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNavigatingArgCS()
	 * @generated
	 */
	int NAVIGATING_ARG_CS = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NestedExpCSImpl <em>Nested Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NestedExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNestedExpCS()
	 * @generated
	 */
	int NESTED_EXP_CS = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NumberLiteralExpCSImpl <em>Number Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NumberLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNumberLiteralExpCS()
	 * @generated
	 */
	int NUMBER_LITERAL_EXP_CS = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.OperatorCSImpl <em>Operator CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.OperatorCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getOperatorCS()
	 * @generated
	 */
	int OPERATOR_CS = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.BinaryOperatorCSImpl <em>Binary Operator CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.BinaryOperatorCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getBinaryOperatorCS()
	 * @generated
	 */
	int BINARY_OPERATOR_CS = 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__LOGICAL_PARENT = BaseCSPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__PIVOT = BaseCSPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__OWNED_ANNOTATIONS = BaseCSPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__ORIGINAL_XMI_ID = BaseCSPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__CSI = BaseCSPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__PARENT = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__HAS_ERROR = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS_FEATURE_COUNT = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__LOGICAL_PARENT = EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__OWNED_ANNOTATIONS = EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__CSI = EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__HAS_ERROR = EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__NAME = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__SOURCE = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operator CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__LOGICAL_PARENT = OPERATOR_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__PIVOT = OPERATOR_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__OWNED_ANNOTATIONS = OPERATOR_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__ORIGINAL_XMI_ID = OPERATOR_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__CSI = OPERATOR_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__PARENT = OPERATOR_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__HAS_ERROR = OPERATOR_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__NAME = OPERATOR_CS__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__SOURCE = OPERATOR_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__ARGUMENT = OPERATOR_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Binary Operator CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS_FEATURE_COUNT = OPERATOR_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__LOGICAL_PARENT = EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__OWNED_ANNOTATIONS = EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__CSI = EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__HAS_ERROR = EXP_CS__HAS_ERROR;

	/**
	 * The number of structural features of the '<em>Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__LOGICAL_PARENT = LITERAL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__PIVOT = LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATIONS = LITERAL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID = LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__CSI = LITERAL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__PARENT = LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__HAS_ERROR = LITERAL_EXP_CS__HAS_ERROR;

	/**
	 * The number of structural features of the '<em>Primitive Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__LOGICAL_PARENT = PRIMITIVE_LITERAL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__OWNED_ANNOTATIONS = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__CSI = PRIMITIVE_LITERAL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__HAS_ERROR = PRIMITIVE_LITERAL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__SYMBOL = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__LOGICAL_PARENT = LITERAL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__PIVOT = LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__OWNED_ANNOTATIONS = LITERAL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__ORIGINAL_XMI_ID = LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__CSI = LITERAL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__PARENT = LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__HAS_ERROR = LITERAL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__OWNED_TYPE = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__OWNED_PARTS = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__LOGICAL_PARENT = BaseCSPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__PIVOT = BaseCSPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__OWNED_ANNOTATIONS = BaseCSPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__ORIGINAL_XMI_ID = BaseCSPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__CSI = BaseCSPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Last Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS_FEATURE_COUNT = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionPatternCSImpl <em>Collection Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionPatternCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionPatternCS()
	 * @generated
	 */
	int COLLECTION_PATTERN_CS = 4;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PATTERN_CS__LOGICAL_PARENT = BaseCSPackage.TYPED_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PATTERN_CS__PIVOT = BaseCSPackage.TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PATTERN_CS__OWNED_MULTIPLICITY = BaseCSPackage.TYPED_REF_CS__OWNED_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PATTERN_CS__OWNED_TYPE = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PATTERN_CS__OWNED_PARTS = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rest Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PATTERN_CS__REST_VARIABLE_NAME = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Pattern Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PATTERN_CS__OWNED_PATTERN_GUARD = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Collection Pattern CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PATTERN_CS_FEATURE_COUNT = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__LOGICAL_PARENT = BaseCSPackage.TYPED_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__PIVOT = BaseCSPackage.TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__OWNED_MULTIPLICITY = BaseCSPackage.TYPED_REF_CS__OWNED_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__NAME = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__OWNED_TYPE = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS_FEATURE_COUNT = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ContextCSImpl <em>Context CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ContextCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getContextCS()
	 * @generated
	 */
	int CONTEXT_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ExpSpecificationCSImpl <em>Exp Specification CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ExpSpecificationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getExpSpecificationCS()
	 * @generated
	 */
	int EXP_SPECIFICATION_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.VariableCSImpl <em>Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.VariableCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getVariableCS()
	 * @generated
	 */
	int VARIABLE_CS = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetVariableCSImpl <em>Let Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetVariableCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLetVariableCS()
	 * @generated
	 */
	int LET_VARIABLE_CS = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ConstructorPartCSImpl <em>Constructor Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ConstructorPartCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getConstructorPartCS()
	 * @generated
	 */
	int CONSTRUCTOR_PART_CS = 6;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART_CS__LOGICAL_PARENT = BaseCSPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART_CS__PIVOT = BaseCSPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART_CS__OWNED_ANNOTATIONS = BaseCSPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART_CS__ORIGINAL_XMI_ID = BaseCSPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART_CS__CSI = BaseCSPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owning Curly Bracket Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART_CS__OWNING_CURLY_BRACKET_CLAUSE = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART_CS__REFERRED_PROPERTY = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART_CS__OWNED_INIT_EXPRESSION = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constructor Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART_CS_FEATURE_COUNT = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__LOGICAL_PARENT = BaseCSPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__PIVOT = BaseCSPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__OWNED_ANNOTATIONS = BaseCSPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__ORIGINAL_XMI_ID = BaseCSPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__CSI = BaseCSPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__NAME = BaseCSPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__OWNED_IMPORTS = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__OWNED_LIBRARIES = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__OWNED_EXPRESSION = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Context CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS_FEATURE_COUNT = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CurlyBracketedClauseCSImpl <em>Curly Bracketed Clause CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CurlyBracketedClauseCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCurlyBracketedClauseCS()
	 * @generated
	 */
	int CURLY_BRACKETED_CLAUSE_CS = 8;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURLY_BRACKETED_CLAUSE_CS__LOGICAL_PARENT = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Owning Name Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURLY_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURLY_BRACKETED_CLAUSE_CS__VALUE = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Curly Bracketed Clause CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURLY_BRACKETED_CLAUSE_CS_FEATURE_COUNT = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_SPECIFICATION_CS__LOGICAL_PARENT = BaseCSPackage.SPECIFICATION_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_SPECIFICATION_CS__PIVOT = BaseCSPackage.SPECIFICATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_SPECIFICATION_CS__OWNED_ANNOTATIONS = BaseCSPackage.SPECIFICATION_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_SPECIFICATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.SPECIFICATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_SPECIFICATION_CS__CSI = BaseCSPackage.SPECIFICATION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Expr String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_SPECIFICATION_CS__EXPR_STRING = BaseCSPackage.SPECIFICATION_CS__EXPR_STRING;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_SPECIFICATION_CS__OWNED_EXPRESSION = BaseCSPackage.SPECIFICATION_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exp Specification CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_SPECIFICATION_CS_FEATURE_COUNT = BaseCSPackage.SPECIFICATION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__LOGICAL_PARENT = EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__OWNED_ANNOTATIONS = EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__CSI = EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__HAS_ERROR = EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Owned Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__OWNED_CONDITION = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__OWNED_THEN_EXPRESSION = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned If Then Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__OWNED_ELSE_EXPRESSION = EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>If Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IfThenExpCSImpl <em>If Then Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IfThenExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIfThenExpCS()
	 * @generated
	 */
	int IF_THEN_EXP_CS = 12;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_EXP_CS__LOGICAL_PARENT = EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_EXP_CS__OWNED_ANNOTATIONS = EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_EXP_CS__CSI = EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_EXP_CS__HAS_ERROR = EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Owned Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_EXP_CS__OWNED_CONDITION = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>If Then Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__LOGICAL_PARENT = EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__OWNED_ANNOTATIONS = EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__CSI = EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__HAS_ERROR = EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Owned Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__OWNED_EXPRESSIONS = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__OWNED_OPERATORS = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Infix Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__LOGICAL_PARENT = PRIMITIVE_LITERAL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__OWNED_ANNOTATIONS = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__CSI = PRIMITIVE_LITERAL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__HAS_ERROR = PRIMITIVE_LITERAL_EXP_CS__HAS_ERROR;

	/**
	 * The number of structural features of the '<em>Invalid Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LambdaLiteralExpCSImpl <em>Lambda Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LambdaLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLambdaLiteralExpCS()
	 * @generated
	 */
	int LAMBDA_LITERAL_EXP_CS = 15;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_LITERAL_EXP_CS__LOGICAL_PARENT = LITERAL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_LITERAL_EXP_CS__PIVOT = LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_LITERAL_EXP_CS__OWNED_ANNOTATIONS = LITERAL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_LITERAL_EXP_CS__ORIGINAL_XMI_ID = LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_LITERAL_EXP_CS__CSI = LITERAL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_LITERAL_EXP_CS__PARENT = LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_LITERAL_EXP_CS__HAS_ERROR = LITERAL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Owned Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lambda Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__LOGICAL_PARENT = EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__OWNED_ANNOTATIONS = EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__CSI = EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__HAS_ERROR = EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Owned Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__OWNED_VARIABLES = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned In Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__OWNED_IN_EXPRESSION = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__LOGICAL_PARENT = BaseCSPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__PIVOT = BaseCSPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__OWNED_ANNOTATIONS = BaseCSPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__ORIGINAL_XMI_ID = BaseCSPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__CSI = BaseCSPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__NAME = BaseCSPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__OWNED_TYPE = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__OWNED_INIT_EXPRESSION = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS_FEATURE_COUNT = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__LOGICAL_PARENT = VARIABLE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__PIVOT = VARIABLE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__OWNED_ANNOTATIONS = VARIABLE_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__ORIGINAL_XMI_ID = VARIABLE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__CSI = VARIABLE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__NAME = VARIABLE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__OWNED_TYPE = VARIABLE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__OWNED_INIT_EXPRESSION = VARIABLE_CS__OWNED_INIT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__PARENT = VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__HAS_ERROR = VARIABLE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Let Expression</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__OWNING_LET_EXPRESSION = VARIABLE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE = VARIABLE_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Let Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS_FEATURE_COUNT = VARIABLE_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__LOGICAL_PARENT = EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__OWNED_ANNOTATIONS = EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__CSI = EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__HAS_ERROR = EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__OWNED_PATH_NAME = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>At Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__AT_PRE = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE = EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES = EXP_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__SOURCE_TYPE = EXP_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Source Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__SOURCE_TYPE_VALUE = EXP_CS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__LOGICAL_PARENT = BaseCSPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__PIVOT = BaseCSPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__OWNED_ANNOTATIONS = BaseCSPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__ORIGINAL_XMI_ID = BaseCSPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__CSI = BaseCSPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owning Round Bracketed Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__OWNING_ROUND_BRACKETED_CLAUSE = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__ROLE = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__PREFIX = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__OWNED_TYPE = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owned Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Navigating Arg CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS_FEATURE_COUNT = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NavigationOperatorCSImpl <em>Navigation Operator CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NavigationOperatorCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNavigationOperatorCS()
	 * @generated
	 */
	int NAVIGATION_OPERATOR_CS = 21;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__LOGICAL_PARENT = BINARY_OPERATOR_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__PIVOT = BINARY_OPERATOR_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__OWNED_ANNOTATIONS = BINARY_OPERATOR_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__ORIGINAL_XMI_ID = BINARY_OPERATOR_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__CSI = BINARY_OPERATOR_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__PARENT = BINARY_OPERATOR_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__HAS_ERROR = BINARY_OPERATOR_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__NAME = BINARY_OPERATOR_CS__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__SOURCE = BINARY_OPERATOR_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__ARGUMENT = BINARY_OPERATOR_CS__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Navigation Operator CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS_FEATURE_COUNT = BINARY_OPERATOR_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__LOGICAL_PARENT = EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__OWNED_ANNOTATIONS = EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__CSI = EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__HAS_ERROR = EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__SOURCE = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nested Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__LOGICAL_PARENT = PRIMITIVE_LITERAL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__OWNED_ANNOTATIONS = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__CSI = PRIMITIVE_LITERAL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__HAS_ERROR = PRIMITIVE_LITERAL_EXP_CS__HAS_ERROR;

	/**
	 * The number of structural features of the '<em>Null Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__LOGICAL_PARENT = PRIMITIVE_LITERAL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__OWNED_ANNOTATIONS = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__CSI = PRIMITIVE_LITERAL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__HAS_ERROR = PRIMITIVE_LITERAL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__SYMBOL = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Number Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PatternExpCSImpl <em>Pattern Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PatternExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPatternExpCS()
	 * @generated
	 */
	int PATTERN_EXP_CS = 26;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXP_CS__LOGICAL_PARENT = EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXP_CS__OWNED_ANNOTATIONS = EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXP_CS__CSI = EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXP_CS__HAS_ERROR = EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Pattern Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXP_CS__PATTERN_VARIABLE_NAME = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Pattern Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXP_CS__OWNED_PATTERN_TYPE = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pattern Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PrefixExpCSImpl <em>Prefix Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PrefixExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPrefixExpCS()
	 * @generated
	 */
	int PREFIX_EXP_CS = 27;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__LOGICAL_PARENT = EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__OWNED_ANNOTATIONS = EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__CSI = EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__HAS_ERROR = EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Owned Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__OWNED_OPERATORS = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__OWNED_EXPRESSION = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Prefix Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.RoundBracketedClauseCSImpl <em>Round Bracketed Clause CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.RoundBracketedClauseCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getRoundBracketedClauseCS()
	 * @generated
	 */
	int ROUND_BRACKETED_CLAUSE_CS = 29;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_BRACKETED_CLAUSE_CS__LOGICAL_PARENT = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Owning Name Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Round Bracketed Clause CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_BRACKETED_CLAUSE_CS_FEATURE_COUNT = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.SelfExpCSImpl <em>Self Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.SelfExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getSelfExpCS()
	 * @generated
	 */
	int SELF_EXP_CS = 30;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__LOGICAL_PARENT = EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__OWNED_ANNOTATIONS = EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__CSI = EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__HAS_ERROR = EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__NAME = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Self Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.SquareBracketedClauseCSImpl <em>Square Bracketed Clause CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.SquareBracketedClauseCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getSquareBracketedClauseCS()
	 * @generated
	 */
	int SQUARE_BRACKETED_CLAUSE_CS = 31;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_BRACKETED_CLAUSE_CS__LOGICAL_PARENT = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Owning Name Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Square Bracketed Clause CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_BRACKETED_CLAUSE_CS_FEATURE_COUNT = BaseCSPackage.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__LOGICAL_PARENT = PRIMITIVE_LITERAL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__OWNED_ANNOTATIONS = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__CSI = PRIMITIVE_LITERAL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__HAS_ERROR = PRIMITIVE_LITERAL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__SEGMENTS = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__LOGICAL_PARENT = LITERAL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__PIVOT = LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__OWNED_ANNOTATIONS = LITERAL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__ORIGINAL_XMI_ID = LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__CSI = LITERAL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__PARENT = LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__HAS_ERROR = LITERAL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__OWNED_PARTS = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TupleLiteralPartCSImpl <em>Tuple Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TupleLiteralPartCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTupleLiteralPartCS()
	 * @generated
	 */
	int TUPLE_LITERAL_PART_CS = 34;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__LOGICAL_PARENT = VARIABLE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__PIVOT = VARIABLE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__OWNED_ANNOTATIONS = VARIABLE_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__ORIGINAL_XMI_ID = VARIABLE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__CSI = VARIABLE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__NAME = VARIABLE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__OWNED_TYPE = VARIABLE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__OWNED_INIT_EXPRESSION = VARIABLE_CS__OWNED_INIT_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Tuple Literal Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS_FEATURE_COUNT = VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TypeLiteralExpCSImpl <em>Type Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TypeLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTypeLiteralExpCS()
	 * @generated
	 */
	int TYPE_LITERAL_EXP_CS = 35;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__LOGICAL_PARENT = LITERAL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__PIVOT = LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__OWNED_ANNOTATIONS = LITERAL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__ORIGINAL_XMI_ID = LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__CSI = LITERAL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__PARENT = LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__HAS_ERROR = LITERAL_EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__OWNED_TYPE = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__LOGICAL_PARENT = BaseCSPackage.TYPED_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__PIVOT = BaseCSPackage.TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__OWNED_MULTIPLICITY = BaseCSPackage.TYPED_REF_CS__OWNED_MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__OWNED_PATH_NAME = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__ELEMENT = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Pattern Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Type Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS_FEATURE_COUNT = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.UnaryOperatorCSImpl <em>Unary Operator CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.UnaryOperatorCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getUnaryOperatorCS()
	 * @generated
	 */
	int UNARY_OPERATOR_CS = 37;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__LOGICAL_PARENT = OPERATOR_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__PIVOT = OPERATOR_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__OWNED_ANNOTATIONS = OPERATOR_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__ORIGINAL_XMI_ID = OPERATOR_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__CSI = OPERATOR_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__PARENT = OPERATOR_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__HAS_ERROR = OPERATOR_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__NAME = OPERATOR_CS__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__SOURCE = OPERATOR_CS__SOURCE;

	/**
	 * The number of structural features of the '<em>Unary Operator CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS_FEATURE_COUNT = OPERATOR_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.UnlimitedNaturalLiteralExpCSImpl <em>Unlimited Natural Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.UnlimitedNaturalLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getUnlimitedNaturalLiteralExpCS()
	 * @generated
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS = 38;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__LOGICAL_PARENT = PRIMITIVE_LITERAL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__OWNED_ANNOTATIONS = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__CSI = PRIMITIVE_LITERAL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__HAS_ERROR = PRIMITIVE_LITERAL_EXP_CS__HAS_ERROR;

	/**
	 * The number of structural features of the '<em>Unlimited Natural Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole <em>Navigation Role</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNavigationRole()
	 * @generated
	 */
	int NAVIGATION_ROLE = 40;

	/**
	 * The meta object id for the '<em>Big Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getBigNumber()
	 * @generated
	 */
	int BIG_NUMBER = 41;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS <em>Binary Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Operator CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS
	 * @generated
	 */
	EClass getBinaryOperatorCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Argument</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS#getArgument()
	 * @see #getBinaryOperatorCS()
	 * @generated
	 */
	EReference getBinaryOperatorCS_Argument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS <em>Prefix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prefix Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS
	 * @generated
	 */
	EClass getPrefixExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS#getOwnedOperators <em>Owned Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operators</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS#getOwnedOperators()
	 * @see #getPrefixExpCS()
	 * @generated
	 */
	EReference getPrefixExpCS_OwnedOperators();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS#getOwnedExpression()
	 * @see #getPrefixExpCS()
	 * @generated
	 */
	EReference getPrefixExpCS_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS <em>Collection Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS
	 * @generated
	 */
	EClass getCollectionTypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS#getName()
	 * @see #getCollectionTypeCS()
	 * @generated
	 */
	EAttribute getCollectionTypeCS_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS#getOwnedType()
	 * @see #getCollectionTypeCS()
	 * @generated
	 */
	EReference getCollectionTypeCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS <em>Constructor Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor Part CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS
	 * @generated
	 */
	EClass getConstructorPartCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS#getOwningCurlyBracketClause <em>Owning Curly Bracket Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Curly Bracket Clause</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS#getOwningCurlyBracketClause()
	 * @see #getConstructorPartCS()
	 * @generated
	 */
	EReference getConstructorPartCS_OwningCurlyBracketClause();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS#getReferredProperty()
	 * @see #getConstructorPartCS()
	 * @generated
	 */
	EReference getConstructorPartCS_ReferredProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS#getOwnedInitExpression <em>Owned Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS#getOwnedInitExpression()
	 * @see #getConstructorPartCS()
	 * @generated
	 */
	EReference getConstructorPartCS_OwnedInitExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS <em>Context CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS
	 * @generated
	 */
	EClass getContextCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS#getOwnedExpression()
	 * @see #getContextCS()
	 * @generated
	 */
	EReference getContextCS_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS <em>Curly Bracketed Clause CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Curly Bracketed Clause CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS
	 * @generated
	 */
	EClass getCurlyBracketedClauseCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Name Exp</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS#getOwningNameExp()
	 * @see #getCurlyBracketedClauseCS()
	 * @generated
	 */
	EReference getCurlyBracketedClauseCS_OwningNameExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS#getOwnedParts()
	 * @see #getCurlyBracketedClauseCS()
	 * @generated
	 */
	EReference getCurlyBracketedClauseCS_OwnedParts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS#getValue()
	 * @see #getCurlyBracketedClauseCS()
	 * @generated
	 */
	EAttribute getCurlyBracketedClauseCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS <em>Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS
	 * @generated
	 */
	EClass getExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS#getParent()
	 * @see #getExpCS()
	 * @generated
	 */
	EReference getExpCS_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS#isHasError <em>Has Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Error</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS#isHasError()
	 * @see #getExpCS()
	 * @generated
	 */
	EAttribute getExpCS_HasError();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS <em>Exp Specification CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exp Specification CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS
	 * @generated
	 */
	EClass getExpSpecificationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS#getOwnedExpression()
	 * @see #getExpSpecificationCS()
	 * @generated
	 */
	EReference getExpSpecificationCS_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS <em>Type Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS
	 * @generated
	 */
	EClass getTypeLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS#getOwnedType()
	 * @see #getTypeLiteralExpCS()
	 * @generated
	 */
	EReference getTypeLiteralExpCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS <em>Type Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Name Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS
	 * @generated
	 */
	EClass getTypeNameExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS#getOwnedPathName()
	 * @see #getTypeNameExpCS()
	 * @generated
	 */
	EReference getTypeNameExpCS_OwnedPathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS#getElement()
	 * @see #getTypeNameExpCS()
	 * @generated
	 */
	EReference getTypeNameExpCS_Element();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Curly Bracketed Clause</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS#getOwnedCurlyBracketedClause()
	 * @see #getTypeNameExpCS()
	 * @generated
	 */
	EReference getTypeNameExpCS_OwnedCurlyBracketedClause();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS#getOwnedPatternGuard <em>Owned Pattern Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Pattern Guard</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS#getOwnedPatternGuard()
	 * @see #getTypeNameExpCS()
	 * @generated
	 */
	EReference getTypeNameExpCS_OwnedPatternGuard();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnaryOperatorCS <em>Unary Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Operator CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnaryOperatorCS
	 * @generated
	 */
	EClass getUnaryOperatorCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS <em>Unlimited Natural Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Natural Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS
	 * @generated
	 */
	EClass getUnlimitedNaturalLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS <em>Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS
	 * @generated
	 */
	EClass getVariableCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS#getOwnedType()
	 * @see #getVariableCS()
	 * @generated
	 */
	EReference getVariableCS_OwnedType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS#getOwnedInitExpression <em>Owned Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS#getOwnedInitExpression()
	 * @see #getVariableCS()
	 * @generated
	 */
	EReference getVariableCS_OwnedInitExpression();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole <em>Navigation Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Navigation Role</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole
	 * @generated
	 */
	EEnum getNavigationRole();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS <em>Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS
	 * @generated
	 */
	EClass getLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS <em>Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS
	 * @generated
	 */
	EClass getNameExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getOwnedPathName()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EReference getNameExpCS_OwnedPathName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#isAtPre <em>At Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Pre</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#isAtPre()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EAttribute getNameExpCS_AtPre();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Curly Bracketed Clause</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getOwnedCurlyBracketedClause()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EReference getNameExpCS_OwnedCurlyBracketedClause();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Round Bracketed Clause</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getOwnedRoundBracketedClause()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EReference getNameExpCS_OwnedRoundBracketedClause();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getOwnedSquareBracketedClauses <em>Owned Square Bracketed Clauses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Square Bracketed Clauses</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getOwnedSquareBracketedClauses()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EReference getNameExpCS_OwnedSquareBracketedClauses();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getSourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getSourceType()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EReference getNameExpCS_SourceType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getSourceTypeValue <em>Source Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Type Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getSourceTypeValue()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EReference getNameExpCS_SourceTypeValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS <em>Navigating Arg CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigating Arg CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS
	 * @generated
	 */
	EClass getNavigatingArgCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getOwningRoundBracketedClause <em>Owning Round Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Round Bracketed Clause</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getOwningRoundBracketedClause()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_OwningRoundBracketedClause();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getRole()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EAttribute getNavigatingArgCS_Role();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getPrefix()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EAttribute getNavigatingArgCS_Prefix();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getOwnedNameExpression <em>Owned Name Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Name Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getOwnedNameExpression()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_OwnedNameExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getOwnedType()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_OwnedType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getOwnedInitExpression <em>Owned Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getOwnedInitExpression()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_OwnedInitExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS <em>Navigation Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Operator CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS
	 * @generated
	 */
	EClass getNavigationOperatorCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS <em>Nested Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nested Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS
	 * @generated
	 */
	EClass getNestedExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS#getSource()
	 * @see #getNestedExpCS()
	 * @generated
	 */
	EReference getNestedExpCS_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS <em>Collection Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS
	 * @generated
	 */
	EClass getCollectionLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS#getOwnedType()
	 * @see #getCollectionLiteralExpCS()
	 * @generated
	 */
	EReference getCollectionLiteralExpCS_OwnedType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS#getOwnedParts()
	 * @see #getCollectionLiteralExpCS()
	 * @generated
	 */
	EReference getCollectionLiteralExpCS_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS <em>Collection Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Part CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS
	 * @generated
	 */
	EClass getCollectionLiteralPartCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS#getOwnedExpression()
	 * @see #getCollectionLiteralPartCS()
	 * @generated
	 */
	EReference getCollectionLiteralPartCS_OwnedExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS#getOwnedLastExpression <em>Owned Last Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Last Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS#getOwnedLastExpression()
	 * @see #getCollectionLiteralPartCS()
	 * @generated
	 */
	EReference getCollectionLiteralPartCS_OwnedLastExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS <em>Collection Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Pattern CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS
	 * @generated
	 */
	EClass getCollectionPatternCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS#getOwnedType()
	 * @see #getCollectionPatternCS()
	 * @generated
	 */
	EReference getCollectionPatternCS_OwnedType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS#getOwnedParts()
	 * @see #getCollectionPatternCS()
	 * @generated
	 */
	EReference getCollectionPatternCS_OwnedParts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS#getRestVariableName <em>Rest Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rest Variable Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS#getRestVariableName()
	 * @see #getCollectionPatternCS()
	 * @generated
	 */
	EAttribute getCollectionPatternCS_RestVariableName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS#getOwnedPatternGuard <em>Owned Pattern Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Pattern Guard</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionPatternCS#getOwnedPatternGuard()
	 * @see #getCollectionPatternCS()
	 * @generated
	 */
	EReference getCollectionPatternCS_OwnedPatternGuard();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS <em>Primitive Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS
	 * @generated
	 */
	EClass getPrimitiveLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS <em>Round Bracketed Clause CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Round Bracketed Clause CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS
	 * @generated
	 */
	EClass getRoundBracketedClauseCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Name Exp</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS#getOwningNameExp()
	 * @see #getRoundBracketedClauseCS()
	 * @generated
	 */
	EReference getRoundBracketedClauseCS_OwningNameExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS#getOwnedArguments <em>Owned Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Arguments</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS#getOwnedArguments()
	 * @see #getRoundBracketedClauseCS()
	 * @generated
	 */
	EReference getRoundBracketedClauseCS_OwnedArguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS <em>Self Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Self Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS
	 * @generated
	 */
	EClass getSelfExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS#getName()
	 * @see #getSelfExpCS()
	 * @generated
	 */
	EAttribute getSelfExpCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS <em>Square Bracketed Clause CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Square Bracketed Clause CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS
	 * @generated
	 */
	EClass getSquareBracketedClauseCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Name Exp</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS#getOwningNameExp()
	 * @see #getSquareBracketedClauseCS()
	 * @generated
	 */
	EReference getSquareBracketedClauseCS_OwningNameExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS#getOwnedTerms <em>Owned Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Terms</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS#getOwnedTerms()
	 * @see #getSquareBracketedClauseCS()
	 * @generated
	 */
	EReference getSquareBracketedClauseCS_OwnedTerms();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS <em>Tuple Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS
	 * @generated
	 */
	EClass getTupleLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS#getOwnedParts()
	 * @see #getTupleLiteralExpCS()
	 * @generated
	 */
	EReference getTupleLiteralExpCS_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS <em>Tuple Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Part CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS
	 * @generated
	 */
	EClass getTupleLiteralPartCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS
	 * @generated
	 */
	EClass getStringLiteralExpCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Segments</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS#getSegments()
	 * @see #getStringLiteralExpCS()
	 * @generated
	 */
	EAttribute getStringLiteralExpCS_Segments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS
	 * @generated
	 */
	EClass getBooleanLiteralExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS#getSymbol()
	 * @see #getBooleanLiteralExpCS()
	 * @generated
	 */
	EAttribute getBooleanLiteralExpCS_Symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS <em>Invalid Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS
	 * @generated
	 */
	EClass getInvalidLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LambdaLiteralExpCS <em>Lambda Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lambda Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LambdaLiteralExpCS
	 * @generated
	 */
	EClass getLambdaLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LambdaLiteralExpCS#getOwnedExpressionCS <em>Owned Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LambdaLiteralExpCS#getOwnedExpressionCS()
	 * @see #getLambdaLiteralExpCS()
	 * @generated
	 */
	EReference getLambdaLiteralExpCS_OwnedExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS <em>Null Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS
	 * @generated
	 */
	EClass getNullLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS <em>Number Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS
	 * @generated
	 */
	EClass getNumberLiteralExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS#getSymbol()
	 * @see #getNumberLiteralExpCS()
	 * @generated
	 */
	EAttribute getNumberLiteralExpCS_Symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS <em>Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS
	 * @generated
	 */
	EClass getOperatorCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS#getSource()
	 * @see #getOperatorCS()
	 * @generated
	 */
	EReference getOperatorCS_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PatternExpCS <em>Pattern Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PatternExpCS
	 * @generated
	 */
	EClass getPatternExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PatternExpCS#getPatternVariableName <em>Pattern Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern Variable Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PatternExpCS#getPatternVariableName()
	 * @see #getPatternExpCS()
	 * @generated
	 */
	EAttribute getPatternExpCS_PatternVariableName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PatternExpCS#getOwnedPatternType <em>Owned Pattern Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Pattern Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PatternExpCS#getOwnedPatternType()
	 * @see #getPatternExpCS()
	 * @generated
	 */
	EReference getPatternExpCS_OwnedPatternType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Big Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Big Number</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number"
	 * @generated
	 */
	EDataType getBigNumber();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EssentialOCLCSFactory getEssentialOCLCSFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS <em>If Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS
	 * @generated
	 */
	EClass getIfExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS#getOwnedCondition <em>Owned Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Condition</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS#getOwnedCondition()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EReference getIfExpCS_OwnedCondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS#getOwnedThenExpression <em>Owned Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Then Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS#getOwnedThenExpression()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EReference getIfExpCS_OwnedThenExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS#getOwnedIfThenExpressions <em>Owned If Then Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned If Then Expressions</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS#getOwnedIfThenExpressions()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EReference getIfExpCS_OwnedIfThenExpressions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS#getOwnedElseExpression <em>Owned Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Else Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS#getOwnedElseExpression()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EReference getIfExpCS_OwnedElseExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfThenExpCS <em>If Then Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Then Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfThenExpCS
	 * @generated
	 */
	EClass getIfThenExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfThenExpCS#getOwnedCondition <em>Owned Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Condition</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfThenExpCS#getOwnedCondition()
	 * @see #getIfThenExpCS()
	 * @generated
	 */
	EReference getIfThenExpCS_OwnedCondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfThenExpCS#getOwnedThenExpression <em>Owned Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Then Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfThenExpCS#getOwnedThenExpression()
	 * @see #getIfThenExpCS()
	 * @generated
	 */
	EReference getIfThenExpCS_OwnedThenExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS <em>Infix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infix Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS
	 * @generated
	 */
	EClass getInfixExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS#getOwnedExpressions <em>Owned Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Expressions</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS#getOwnedExpressions()
	 * @see #getInfixExpCS()
	 * @generated
	 */
	EReference getInfixExpCS_OwnedExpressions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS#getOwnedOperators <em>Owned Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operators</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS#getOwnedOperators()
	 * @see #getInfixExpCS()
	 * @generated
	 */
	EReference getInfixExpCS_OwnedOperators();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS <em>Let Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS
	 * @generated
	 */
	EClass getLetExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS#getOwnedVariables <em>Owned Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Variables</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS#getOwnedVariables()
	 * @see #getLetExpCS()
	 * @generated
	 */
	EReference getLetExpCS_OwnedVariables();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS#getOwnedInExpression <em>Owned In Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned In Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS#getOwnedInExpression()
	 * @see #getLetExpCS()
	 * @generated
	 */
	EReference getLetExpCS_OwnedInExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS <em>Let Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Variable CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS
	 * @generated
	 */
	EClass getLetVariableCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS#getOwningLetExpression <em>Owning Let Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Let Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS#getOwningLetExpression()
	 * @see #getLetVariableCS()
	 * @generated
	 */
	EReference getLetVariableCS_OwningLetExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Round Bracketed Clause</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS#getOwnedRoundBracketedClause()
	 * @see #getLetVariableCS()
	 * @generated
	 */
	EReference getLetVariableCS_OwnedRoundBracketedClause();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.BinaryOperatorCSImpl <em>Binary Operator CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.BinaryOperatorCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getBinaryOperatorCS()
		 * @generated
		 */
		EClass BINARY_OPERATOR_CS = eINSTANCE.getBinaryOperatorCS();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_OPERATOR_CS__ARGUMENT = eINSTANCE.getBinaryOperatorCS_Argument();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PrefixExpCSImpl <em>Prefix Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PrefixExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPrefixExpCS()
		 * @generated
		 */
		EClass PREFIX_EXP_CS = eINSTANCE.getPrefixExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFIX_EXP_CS__OWNED_OPERATORS = eINSTANCE.getPrefixExpCS_OwnedOperators();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFIX_EXP_CS__OWNED_EXPRESSION = eINSTANCE.getPrefixExpCS_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionTypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionTypeCS()
		 * @generated
		 */
		EClass COLLECTION_TYPE_CS = eINSTANCE.getCollectionTypeCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_TYPE_CS__NAME = eINSTANCE.getCollectionTypeCS_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_CS__OWNED_TYPE = eINSTANCE.getCollectionTypeCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ConstructorPartCSImpl <em>Constructor Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ConstructorPartCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getConstructorPartCS()
		 * @generated
		 */
		EClass CONSTRUCTOR_PART_CS = eINSTANCE.getConstructorPartCS();

		/**
		 * The meta object literal for the '<em><b>Owning Curly Bracket Clause</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR_PART_CS__OWNING_CURLY_BRACKET_CLAUSE = eINSTANCE.getConstructorPartCS_OwningCurlyBracketClause();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR_PART_CS__REFERRED_PROPERTY = eINSTANCE.getConstructorPartCS_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Owned Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR_PART_CS__OWNED_INIT_EXPRESSION = eINSTANCE.getConstructorPartCS_OwnedInitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ContextCSImpl <em>Context CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ContextCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getContextCS()
		 * @generated
		 */
		EClass CONTEXT_CS = eINSTANCE.getContextCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_CS__OWNED_EXPRESSION = eINSTANCE.getContextCS_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CurlyBracketedClauseCSImpl <em>Curly Bracketed Clause CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CurlyBracketedClauseCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCurlyBracketedClauseCS()
		 * @generated
		 */
		EClass CURLY_BRACKETED_CLAUSE_CS = eINSTANCE.getCurlyBracketedClauseCS();

		/**
		 * The meta object literal for the '<em><b>Owning Name Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CURLY_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP = eINSTANCE.getCurlyBracketedClauseCS_OwningNameExp();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS = eINSTANCE.getCurlyBracketedClauseCS_OwnedParts();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURLY_BRACKETED_CLAUSE_CS__VALUE = eINSTANCE.getCurlyBracketedClauseCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ExpCSImpl <em>Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getExpCS()
		 * @generated
		 */
		EClass EXP_CS = eINSTANCE.getExpCS();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_CS__PARENT = eINSTANCE.getExpCS_Parent();

		/**
		 * The meta object literal for the '<em><b>Has Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXP_CS__HAS_ERROR = eINSTANCE.getExpCS_HasError();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ExpSpecificationCSImpl <em>Exp Specification CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ExpSpecificationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getExpSpecificationCS()
		 * @generated
		 */
		EClass EXP_SPECIFICATION_CS = eINSTANCE.getExpSpecificationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_SPECIFICATION_CS__OWNED_EXPRESSION = eINSTANCE.getExpSpecificationCS_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TypeLiteralExpCSImpl <em>Type Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TypeLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTypeLiteralExpCS()
		 * @generated
		 */
		EClass TYPE_LITERAL_EXP_CS = eINSTANCE.getTypeLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_LITERAL_EXP_CS__OWNED_TYPE = eINSTANCE.getTypeLiteralExpCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TypeNameExpCSImpl <em>Type Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TypeNameExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTypeNameExpCS()
		 * @generated
		 */
		EClass TYPE_NAME_EXP_CS = eINSTANCE.getTypeNameExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_NAME_EXP_CS__OWNED_PATH_NAME = eINSTANCE.getTypeNameExpCS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_NAME_EXP_CS__ELEMENT = eINSTANCE.getTypeNameExpCS_Element();

		/**
		 * The meta object literal for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = eINSTANCE.getTypeNameExpCS_OwnedCurlyBracketedClause();

		/**
		 * The meta object literal for the '<em><b>Owned Pattern Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD = eINSTANCE.getTypeNameExpCS_OwnedPatternGuard();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.UnaryOperatorCSImpl <em>Unary Operator CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.UnaryOperatorCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getUnaryOperatorCS()
		 * @generated
		 */
		EClass UNARY_OPERATOR_CS = eINSTANCE.getUnaryOperatorCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.UnlimitedNaturalLiteralExpCSImpl <em>Unlimited Natural Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.UnlimitedNaturalLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getUnlimitedNaturalLiteralExpCS()
		 * @generated
		 */
		EClass UNLIMITED_NATURAL_LITERAL_EXP_CS = eINSTANCE.getUnlimitedNaturalLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.VariableCSImpl <em>Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.VariableCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getVariableCS()
		 * @generated
		 */
		EClass VARIABLE_CS = eINSTANCE.getVariableCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CS__OWNED_TYPE = eINSTANCE.getVariableCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Owned Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CS__OWNED_INIT_EXPRESSION = eINSTANCE.getVariableCS_OwnedInitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole <em>Navigation Role</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNavigationRole()
		 * @generated
		 */
		EEnum NAVIGATION_ROLE = eINSTANCE.getNavigationRole();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLiteralExpCS()
		 * @generated
		 */
		EClass LITERAL_EXP_CS = eINSTANCE.getLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NameExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNameExpCS()
		 * @generated
		 */
		EClass NAME_EXP_CS = eINSTANCE.getNameExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXP_CS__OWNED_PATH_NAME = eINSTANCE.getNameExpCS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>At Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAME_EXP_CS__AT_PRE = eINSTANCE.getNameExpCS_AtPre();

		/**
		 * The meta object literal for the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE = eINSTANCE.getNameExpCS_OwnedCurlyBracketedClause();

		/**
		 * The meta object literal for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE = eINSTANCE.getNameExpCS_OwnedRoundBracketedClause();

		/**
		 * The meta object literal for the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES = eINSTANCE.getNameExpCS_OwnedSquareBracketedClauses();

		/**
		 * The meta object literal for the '<em><b>Source Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXP_CS__SOURCE_TYPE = eINSTANCE.getNameExpCS_SourceType();

		/**
		 * The meta object literal for the '<em><b>Source Type Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXP_CS__SOURCE_TYPE_VALUE = eINSTANCE.getNameExpCS_SourceTypeValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NavigatingArgCSImpl <em>Navigating Arg CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NavigatingArgCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNavigatingArgCS()
		 * @generated
		 */
		EClass NAVIGATING_ARG_CS = eINSTANCE.getNavigatingArgCS();

		/**
		 * The meta object literal for the '<em><b>Owning Round Bracketed Clause</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__OWNING_ROUND_BRACKETED_CLAUSE = eINSTANCE.getNavigatingArgCS_OwningRoundBracketedClause();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATING_ARG_CS__ROLE = eINSTANCE.getNavigatingArgCS_Role();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATING_ARG_CS__PREFIX = eINSTANCE.getNavigatingArgCS_Prefix();

		/**
		 * The meta object literal for the '<em><b>Owned Name Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION = eINSTANCE.getNavigatingArgCS_OwnedNameExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__OWNED_TYPE = eINSTANCE.getNavigatingArgCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Owned Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION = eINSTANCE.getNavigatingArgCS_OwnedInitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NavigationOperatorCSImpl <em>Navigation Operator CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NavigationOperatorCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNavigationOperatorCS()
		 * @generated
		 */
		EClass NAVIGATION_OPERATOR_CS = eINSTANCE.getNavigationOperatorCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NestedExpCSImpl <em>Nested Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NestedExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNestedExpCS()
		 * @generated
		 */
		EClass NESTED_EXP_CS = eINSTANCE.getNestedExpCS();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_EXP_CS__SOURCE = eINSTANCE.getNestedExpCS_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionLiteralExpCS()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP_CS = eINSTANCE.getCollectionLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP_CS__OWNED_TYPE = eINSTANCE.getCollectionLiteralExpCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getCollectionLiteralExpCS_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionLiteralPartCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionLiteralPartCS()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_PART_CS = eINSTANCE.getCollectionLiteralPartCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION = eINSTANCE.getCollectionLiteralPartCS_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Last Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION = eINSTANCE.getCollectionLiteralPartCS_OwnedLastExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionPatternCSImpl <em>Collection Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CollectionPatternCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getCollectionPatternCS()
		 * @generated
		 */
		EClass COLLECTION_PATTERN_CS = eINSTANCE.getCollectionPatternCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_PATTERN_CS__OWNED_TYPE = eINSTANCE.getCollectionPatternCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_PATTERN_CS__OWNED_PARTS = eINSTANCE.getCollectionPatternCS_OwnedParts();

		/**
		 * The meta object literal for the '<em><b>Rest Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_PATTERN_CS__REST_VARIABLE_NAME = eINSTANCE.getCollectionPatternCS_RestVariableName();

		/**
		 * The meta object literal for the '<em><b>Owned Pattern Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_PATTERN_CS__OWNED_PATTERN_GUARD = eINSTANCE.getCollectionPatternCS_OwnedPatternGuard();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PrimitiveLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPrimitiveLiteralExpCS()
		 * @generated
		 */
		EClass PRIMITIVE_LITERAL_EXP_CS = eINSTANCE.getPrimitiveLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.RoundBracketedClauseCSImpl <em>Round Bracketed Clause CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.RoundBracketedClauseCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getRoundBracketedClauseCS()
		 * @generated
		 */
		EClass ROUND_BRACKETED_CLAUSE_CS = eINSTANCE.getRoundBracketedClauseCS();

		/**
		 * The meta object literal for the '<em><b>Owning Name Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP = eINSTANCE.getRoundBracketedClauseCS_OwningNameExp();

		/**
		 * The meta object literal for the '<em><b>Owned Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS = eINSTANCE.getRoundBracketedClauseCS_OwnedArguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.SelfExpCSImpl <em>Self Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.SelfExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getSelfExpCS()
		 * @generated
		 */
		EClass SELF_EXP_CS = eINSTANCE.getSelfExpCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELF_EXP_CS__NAME = eINSTANCE.getSelfExpCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.SquareBracketedClauseCSImpl <em>Square Bracketed Clause CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.SquareBracketedClauseCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getSquareBracketedClauseCS()
		 * @generated
		 */
		EClass SQUARE_BRACKETED_CLAUSE_CS = eINSTANCE.getSquareBracketedClauseCS();

		/**
		 * The meta object literal for the '<em><b>Owning Name Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SQUARE_BRACKETED_CLAUSE_CS__OWNING_NAME_EXP = eINSTANCE.getSquareBracketedClauseCS_OwningNameExp();

		/**
		 * The meta object literal for the '<em><b>Owned Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS = eINSTANCE.getSquareBracketedClauseCS_OwnedTerms();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TupleLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTupleLiteralExpCS()
		 * @generated
		 */
		EClass TUPLE_LITERAL_EXP_CS = eINSTANCE.getTupleLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getTupleLiteralExpCS_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TupleLiteralPartCSImpl <em>Tuple Literal Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.TupleLiteralPartCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getTupleLiteralPartCS()
		 * @generated
		 */
		EClass TUPLE_LITERAL_PART_CS = eINSTANCE.getTupleLiteralPartCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.StringLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getStringLiteralExpCS()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP_CS = eINSTANCE.getStringLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP_CS__SEGMENTS = eINSTANCE.getStringLiteralExpCS_Segments();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.BooleanLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getBooleanLiteralExpCS()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP_CS = eINSTANCE.getBooleanLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP_CS__SYMBOL = eINSTANCE.getBooleanLiteralExpCS_Symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InvalidLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getInvalidLiteralExpCS()
		 * @generated
		 */
		EClass INVALID_LITERAL_EXP_CS = eINSTANCE.getInvalidLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LambdaLiteralExpCSImpl <em>Lambda Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LambdaLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLambdaLiteralExpCS()
		 * @generated
		 */
		EClass LAMBDA_LITERAL_EXP_CS = eINSTANCE.getLambdaLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS = eINSTANCE.getLambdaLiteralExpCS_OwnedExpressionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NullLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNullLiteralExpCS()
		 * @generated
		 */
		EClass NULL_LITERAL_EXP_CS = eINSTANCE.getNullLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NumberLiteralExpCSImpl <em>Number Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NumberLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getNumberLiteralExpCS()
		 * @generated
		 */
		EClass NUMBER_LITERAL_EXP_CS = eINSTANCE.getNumberLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_LITERAL_EXP_CS__SYMBOL = eINSTANCE.getNumberLiteralExpCS_Symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.OperatorCSImpl <em>Operator CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.OperatorCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getOperatorCS()
		 * @generated
		 */
		EClass OPERATOR_CS = eINSTANCE.getOperatorCS();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_CS__SOURCE = eINSTANCE.getOperatorCS_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PatternExpCSImpl <em>Pattern Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PatternExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getPatternExpCS()
		 * @generated
		 */
		EClass PATTERN_EXP_CS = eINSTANCE.getPatternExpCS();

		/**
		 * The meta object literal for the '<em><b>Pattern Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_EXP_CS__PATTERN_VARIABLE_NAME = eINSTANCE.getPatternExpCS_PatternVariableName();

		/**
		 * The meta object literal for the '<em><b>Owned Pattern Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EXP_CS__OWNED_PATTERN_TYPE = eINSTANCE.getPatternExpCS_OwnedPatternType();

		/**
		 * The meta object literal for the '<em>Big Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getBigNumber()
		 * @generated
		 */
		EDataType BIG_NUMBER = eINSTANCE.getBigNumber();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IfExpCSImpl <em>If Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IfExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIfExpCS()
		 * @generated
		 */
		EClass IF_EXP_CS = eINSTANCE.getIfExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_CS__OWNED_CONDITION = eINSTANCE.getIfExpCS_OwnedCondition();

		/**
		 * The meta object literal for the '<em><b>Owned Then Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_CS__OWNED_THEN_EXPRESSION = eINSTANCE.getIfExpCS_OwnedThenExpression();

		/**
		 * The meta object literal for the '<em><b>Owned If Then Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS = eINSTANCE.getIfExpCS_OwnedIfThenExpressions();

		/**
		 * The meta object literal for the '<em><b>Owned Else Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_CS__OWNED_ELSE_EXPRESSION = eINSTANCE.getIfExpCS_OwnedElseExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IfThenExpCSImpl <em>If Then Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.IfThenExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getIfThenExpCS()
		 * @generated
		 */
		EClass IF_THEN_EXP_CS = eINSTANCE.getIfThenExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_THEN_EXP_CS__OWNED_CONDITION = eINSTANCE.getIfThenExpCS_OwnedCondition();

		/**
		 * The meta object literal for the '<em><b>Owned Then Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION = eINSTANCE.getIfThenExpCS_OwnedThenExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl <em>Infix Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getInfixExpCS()
		 * @generated
		 */
		EClass INFIX_EXP_CS = eINSTANCE.getInfixExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFIX_EXP_CS__OWNED_EXPRESSIONS = eINSTANCE.getInfixExpCS_OwnedExpressions();

		/**
		 * The meta object literal for the '<em><b>Owned Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFIX_EXP_CS__OWNED_OPERATORS = eINSTANCE.getInfixExpCS_OwnedOperators();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetExpCSImpl <em>Let Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLetExpCS()
		 * @generated
		 */
		EClass LET_EXP_CS = eINSTANCE.getLetExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP_CS__OWNED_VARIABLES = eINSTANCE.getLetExpCS_OwnedVariables();

		/**
		 * The meta object literal for the '<em><b>Owned In Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP_CS__OWNED_IN_EXPRESSION = eINSTANCE.getLetExpCS_OwnedInExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetVariableCSImpl <em>Let Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetVariableCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.EssentialOCLCSPackageImpl#getLetVariableCS()
		 * @generated
		 */
		EClass LET_VARIABLE_CS = eINSTANCE.getLetVariableCS();

		/**
		 * The meta object literal for the '<em><b>Owning Let Expression</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_VARIABLE_CS__OWNING_LET_EXPRESSION = eINSTANCE.getLetVariableCS_OwningLetExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE = eINSTANCE.getLetVariableCS_OwnedRoundBracketedClause();

	}

} //EssentialOCLCSPackage
