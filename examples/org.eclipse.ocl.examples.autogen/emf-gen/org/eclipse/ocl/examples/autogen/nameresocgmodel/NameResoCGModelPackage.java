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
package org.eclipse.ocl.examples.autogen.nameresocgmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;

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
 * <!-- begin-model-doc -->
 * The CGModel for Name Resolution Framework
 * <!-- end-model-doc -->
 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 * @generated
 */
public interface NameResoCGModelPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nameresocgmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/1.0.0/NameResoCG";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nameresocg";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.examples.autogen.nameresocgmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NameResoCGModelPackage eINSTANCE = org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.NameResoCGModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGAddCallImpl <em>CG Add Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGAddCallImpl
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.NameResoCGModelPackageImpl#getCGAddCall()
	 * @generated
	 */
	int CG_ADD_CALL = 0;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL__AST = CGModelPackage.CG_OPERATION_CALL_EXP__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL__NAME = CGModelPackage.CG_OPERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL__TYPE_ID = CGModelPackage.CG_OPERATION_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL__REQUIRED = CGModelPackage.CG_OPERATION_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL__DEPENDS_ON = CGModelPackage.CG_OPERATION_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL__OWNS = CGModelPackage.CG_OPERATION_CALL_EXP__OWNS;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL__INVALIDATING = CGModelPackage.CG_OPERATION_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL__VALIDATING = CGModelPackage.CG_OPERATION_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL__SOURCE = CGModelPackage.CG_OPERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL__ARGUMENTS = CGModelPackage.CG_OPERATION_CALL_EXP__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL__REFERRED_OPERATION = CGModelPackage.CG_OPERATION_CALL_EXP__REFERRED_OPERATION;

	/**
	 * The number of structural features of the '<em>CG Add Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ADD_CALL_FEATURE_COUNT = CGModelPackage.CG_OPERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitOpImpl <em>CG Env Visit Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitOpImpl
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.NameResoCGModelPackageImpl#getCGEnvVisitOp()
	 * @generated
	 */
	int CG_ENV_VISIT_OP = 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP__AST = CGModelPackage.CG_OPERATION__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP__NAME = CGModelPackage.CG_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP__TYPE_ID = CGModelPackage.CG_OPERATION__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP__REQUIRED = CGModelPackage.CG_OPERATION__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP__DEPENDS_ON = CGModelPackage.CG_OPERATION__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP__OWNS = CGModelPackage.CG_OPERATION__OWNS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP__PARAMETERS = CGModelPackage.CG_OPERATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP__BODY = CGModelPackage.CG_OPERATION__BODY;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP__PRECONDITIONS = CGModelPackage.CG_OPERATION__PRECONDITIONS;

	/**
	 * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP__POSTCONDITIONS = CGModelPackage.CG_OPERATION__POSTCONDITIONS;

	/**
	 * The feature id for the '<em><b>Containing Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP__CONTAINING_CLASS = CGModelPackage.CG_OPERATION__CONTAINING_CLASS;

	/**
	 * The number of structural features of the '<em>CG Env Visit Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP_FEATURE_COUNT = CGModelPackage.CG_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitOpBodyImpl <em>CG Env Visit Op Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitOpBodyImpl
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.NameResoCGModelPackageImpl#getCGEnvVisitOpBody()
	 * @generated
	 */
	int CG_ENV_VISIT_OP_BODY = 2;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP_BODY__AST = CGModelPackage.CG_VALUED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP_BODY__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP_BODY__TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP_BODY__REQUIRED = CGModelPackage.CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP_BODY__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP_BODY__OWNS = CGModelPackage.CG_VALUED_ELEMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Env Config Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP_BODY__ENV_CONFIG_PARTS = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Env Visit Op Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_OP_BODY_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitIfPartImpl <em>CG Env Visit If Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitIfPartImpl
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.NameResoCGModelPackageImpl#getCGEnvVisitIfPart()
	 * @generated
	 */
	int CG_ENV_VISIT_IF_PART = 3;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_IF_PART__AST = CGModelPackage.CG_VALUED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_IF_PART__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_IF_PART__TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_IF_PART__REQUIRED = CGModelPackage.CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_IF_PART__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_IF_PART__OWNS = CGModelPackage.CG_VALUED_ELEMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_IF_PART__PROPERTY_NAME = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Env Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_IF_PART__ENV_EXPRESSION = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Env Visit If Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ENV_VISIT_IF_PART_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddCall <em>CG Add Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Add Call</em>'.
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddCall
	 * @generated
	 */
	EClass getCGAddCall();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp <em>CG Env Visit Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Env Visit Op</em>'.
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp
	 * @generated
	 */
	EClass getCGEnvVisitOp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody <em>CG Env Visit Op Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Env Visit Op Body</em>'.
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody
	 * @generated
	 */
	EClass getCGEnvVisitOpBody();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody#getEnvConfigParts <em>Env Config Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Env Config Parts</em>'.
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody#getEnvConfigParts()
	 * @see #getCGEnvVisitOpBody()
	 * @generated
	 */
	EReference getCGEnvVisitOpBody_EnvConfigParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart <em>CG Env Visit If Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Env Visit If Part</em>'.
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart
	 * @generated
	 */
	EClass getCGEnvVisitIfPart();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart#getPropertyName()
	 * @see #getCGEnvVisitIfPart()
	 * @generated
	 */
	EAttribute getCGEnvVisitIfPart_PropertyName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart#getEnvExpression <em>Env Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Env Expression</em>'.
	 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart#getEnvExpression()
	 * @see #getCGEnvVisitIfPart()
	 * @generated
	 */
	EReference getCGEnvVisitIfPart_EnvExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NameResoCGModelFactory getNameResoCGModelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGAddCallImpl <em>CG Add Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGAddCallImpl
		 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.NameResoCGModelPackageImpl#getCGAddCall()
		 * @generated
		 */
		EClass CG_ADD_CALL = eINSTANCE.getCGAddCall();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitOpImpl <em>CG Env Visit Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitOpImpl
		 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.NameResoCGModelPackageImpl#getCGEnvVisitOp()
		 * @generated
		 */
		EClass CG_ENV_VISIT_OP = eINSTANCE.getCGEnvVisitOp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitOpBodyImpl <em>CG Env Visit Op Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitOpBodyImpl
		 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.NameResoCGModelPackageImpl#getCGEnvVisitOpBody()
		 * @generated
		 */
		EClass CG_ENV_VISIT_OP_BODY = eINSTANCE.getCGEnvVisitOpBody();

		/**
		 * The meta object literal for the '<em><b>Env Config Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ENV_VISIT_OP_BODY__ENV_CONFIG_PARTS = eINSTANCE.getCGEnvVisitOpBody_EnvConfigParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitIfPartImpl <em>CG Env Visit If Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.CGEnvVisitIfPartImpl
		 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.impl.NameResoCGModelPackageImpl#getCGEnvVisitIfPart()
		 * @generated
		 */
		EClass CG_ENV_VISIT_IF_PART = eINSTANCE.getCGEnvVisitIfPart();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_ENV_VISIT_IF_PART__PROPERTY_NAME = eINSTANCE.getCGEnvVisitIfPart_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Env Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ENV_VISIT_IF_PART__ENV_EXPRESSION = eINSTANCE.getCGEnvVisitIfPart_EnvExpression();

	}

} //NameResoCGModelPackage
