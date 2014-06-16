/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;

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
 * @see org.eclipse.ocl.examples.pivot.PivotFactory
 * @generated
 */
public interface PivotPackage
		extends EPackage
{

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "pivot"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/Pivot"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "pivot"; //$NON-NLS-1$

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eCONTENT_TYPE = "org.eclipse.ocl.examples.oclas"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")@NonNull PivotPackage eINSTANCE = org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OCLExpressionImpl <em>OCL Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OCLExpressionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOCLExpression()
	 * @generated
	 */
	int OCL_EXPRESSION = 58;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CallExpImpl <em>Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCallExp()
	 * @generated
	 */
	int CALL_EXP = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.FeatureCallExpImpl <em>Feature Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.FeatureCallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getFeatureCallExp()
	 * @generated
	 */
	int FEATURE_CALL_EXP = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.NavigationCallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNavigationCallExp()
	 * @generated
	 */
	int NAVIGATION_CALL_EXP = 55;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassCallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociationClassCallExp()
	 * @generated
	 */
	int ASSOCIATION_CLASS_CALL_EXP = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.DataTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionType()
	 * @generated
	 */
	int COLLECTION_TYPE = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.BagTypeImpl <em>Bag Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.BagTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBagType()
	 * @generated
	 */
	int BAG_TYPE = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.LiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLiteralExp()
	 * @generated
	 */
	int LITERAL_EXP = 46;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrimitiveLiteralExp()
	 * @generated
	 */
	int PRIMITIVE_LITERAL_EXP = 71;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.BooleanLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBooleanLiteralExp()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CallOperationActionImpl <em>Call Operation Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CallOperationActionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCallOperationAction()
	 * @generated
	 */
	int CALL_OPERATION_ACTION = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralPartImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionLiteralPart()
	 * @generated
	 */
	int COLLECTION_LITERAL_PART = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionItemImpl <em>Collection Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionItemImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionItem()
	 * @generated
	 */
	int COLLECTION_ITEM = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionLiteralExp()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionRangeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionRange()
	 * @generated
	 */
	int COLLECTION_RANGE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumLiteralExp()
	 * @generated
	 */
	int ENUM_LITERAL_EXP = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumerationLiteralImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumerationLiteral()
	 * @generated
	 */
	int ENUMERATION_LITERAL = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumerationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl <em>Opaque Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOpaqueExpression()
	 * @generated
	 */
	int OPAQUE_EXPRESSION = 59;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOCLImpl <em>Expression In OCL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOCLImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getExpressionInOCL()
	 * @generated
	 */
	int EXPRESSION_IN_OCL = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 113;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IfExpImpl <em>If Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.IfExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIfExp()
	 * @generated
	 */
	int IF_EXP = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.NumericLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNumericLiteralExp()
	 * @generated
	 */
	int NUMERIC_LITERAL_EXP = 57;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.IntegerLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIntegerLiteralExp()
	 * @generated
	 */
	int INTEGER_LITERAL_EXP = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInvalidLiteralExp()
	 * @generated
	 */
	int INVALID_LITERAL_EXP = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidTypeImpl <em>Invalid Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.InvalidTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInvalidType()
	 * @generated
	 */
	int INVALID_TYPE = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LetExpImpl <em>Let Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.LetExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLetExp()
	 * @generated
	 */
	int LET_EXP = 44;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LoopExpImpl <em>Loop Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.LoopExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLoopExp()
	 * @generated
	 */
	int LOOP_EXP = 47;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl <em>Message Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMessageExp()
	 * @generated
	 */
	int MESSAGE_EXP = 48;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SendSignalActionImpl <em>Send Signal Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.SendSignalActionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSendSignalAction()
	 * @generated
	 */
	int SEND_SIGNAL_ACTION = 83;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SignalImpl <em>Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.SignalImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSignal()
	 * @generated
	 */
	int SIGNAL = 86;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageTypeImpl <em>Message Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.MessageTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMessageType()
	 * @generated
	 */
	int MESSAGE_TYPE = 49;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.NullLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNullLiteralExp()
	 * @generated
	 */
	int NULL_LITERAL_EXP = 56;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationCallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperationCallExp()
	 * @generated
	 */
	int OPERATION_CALL_EXP = 61;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OrderedSetTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOrderedSetType()
	 * @generated
	 */
	int ORDERED_SET_TYPE = 64;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageableElementImpl <em>Packageable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PackageableElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPackageableElement()
	 * @generated
	 */
	int PACKAGEABLE_ELEMENT = 66;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 72;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PropertyCallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPropertyCallExp()
	 * @generated
	 */
	int PROPERTY_CALL_EXP = 76;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.RealLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getRealLiteralExp()
	 * @generated
	 */
	int REAL_LITERAL_EXP = 78;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.SequenceTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSequenceType()
	 * @generated
	 */
	int SEQUENCE_TYPE = 84;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SetTypeImpl <em>Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.SetTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSetType()
	 * @generated
	 */
	int SET_TYPE = 85;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.StateImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getState()
	 * @generated
	 */
	int STATE = 87;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StateExpImpl <em>State Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.StateExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStateExp()
	 * @generated
	 */
	int STATE_EXP = 88;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.StringLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStringLiteralExp()
	 * @generated
	 */
	int STRING_LITERAL_EXP = 91;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterTypeImpl <em>Template Parameter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameterType()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_TYPE = 95;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleLiteralExp()
	 * @generated
	 */
	int TUPLE_LITERAL_EXP = 100;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralPartImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleLiteralPart()
	 * @generated
	 */
	int TUPLE_LITERAL_PART = 101;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleType()
	 * @generated
	 */
	int TUPLE_TYPE = 102;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeExpImpl <em>Type Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypeExp()
	 * @generated
	 */
	int TYPE_EXP = 104;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnlimitedNaturalLiteralExpImpl <em>Unlimited Natural Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnlimitedNaturalLiteralExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnlimitedNaturalLiteralExp()
	 * @generated
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP = 109;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedValueExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnspecifiedValueExp()
	 * @generated
	 */
	int UNSPECIFIED_VALUE_EXP = 111;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl <em>Variable Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariableExp()
	 * @generated
	 */
	int VARIABLE_EXP = 115;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VoidTypeImpl <em>Void Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.VoidTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVoidType()
	 * @generated
	 */
	int VOID_TYPE = 119;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.util.Pivotable <em>Pivotable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.util.Pivotable
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPivotable()
	 * @generated
	 */
	int PIVOTABLE = 69;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.util.Visitable <em>Visitable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.util.Visitable
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVisitable()
	 * @generated
	 */
	int VISITABLE = 117;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.NamedElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 53;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 103;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateableElementImpl <em>Templateable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateableElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateableElement()
	 * @generated
	 */
	int TEMPLATEABLE_ELEMENT = 97;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateBindingImpl <em>Template Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateBindingImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateBinding()
	 * @generated
	 */
	int TEMPLATE_BINDING = 92;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateSignatureImpl <em>Template Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateSignatureImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateSignature()
	 * @generated
	 */
	int TEMPLATE_SIGNATURE = 96;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterImpl <em>Template Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameter()
	 * @generated
	 */
	int TEMPLATE_PARAMETER = 93;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ParameterableElementImpl <em>Parameterable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ParameterableElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getParameterableElement()
	 * @generated
	 */
	int PARAMETERABLE_ELEMENT = 68;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl <em>Template Parameter Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameterSubstitution()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION = 94;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 65;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NamespaceImpl <em>Namespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.NamespaceImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNamespace()
	 * @generated
	 */
	int NAMESPACE = 54;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrecedenceImpl <em>Precedence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrecedenceImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrecedence()
	 * @generated
	 */
	int PRECEDENCE = 70;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl <em>Type Template Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypeTemplateParameter()
	 * @generated
	 */
	int TYPE_TEMPLATE_PARAMETER = 106;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl <em>Typed Multiplicity Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypedMultiplicityElement()
	 * @generated
	 */
	int TYPED_MULTIPLICITY_ELEMENT = 108;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 75;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 107;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassImpl <em>Association Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociationClass()
	 * @generated
	 */
	int ASSOCIATION_CLASS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 60;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ParameterImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 67;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableDeclarationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 114;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationTemplateParameterImpl <em>Operation Template Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationTemplateParameterImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperationTemplateParameter()
	 * @generated
	 */
	int OPERATION_TEMPLATE_PARAMETER = 62;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.CommentImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ConstraintImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ValueSpecificationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getValueSpecification()
	 * @generated
	 */
	int VALUE_SPECIFICATION = 112;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.elements.Nameable <em>Nameable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.elements.Nameable
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNameable()
	 * @generated
	 */
	int NAMEABLE = 52;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DetailImpl <em>Detail</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.DetailImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDetail()
	 * @generated
	 */
	int DETAIL = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AnyTypeImpl <em>Any Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.AnyTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAnyType()
	 * @generated
	 */
	int ANY_TYPE = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.FeatureImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.IterateExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIterateExp()
	 * @generated
	 */
	int ITERATE_EXP = 40;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IterationImpl <em>Iteration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.IterationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIteration()
	 * @generated
	 */
	int ITERATION = 41;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.IteratorExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIteratorExp()
	 * @generated
	 */
	int ITERATOR_EXP = 42;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.LibraryImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 45;

	/**
	 * The number of structural features of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__EXTENSION = VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__OWNED_ANNOTATION = VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__OWNED_COMMENT = VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT___ALL_OWNED_ELEMENTS = VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT___GET_VALUE__TYPE_STRING = VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__IS_STATIC = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OWNED_CONTENT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OWNED_DETAIL = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__REFERENCE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_TEMPLATE_SIGNATURE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__TEMPLATE_BINDING = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__UNSPECIALIZED_ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNING_TEMPLATE_PARAMETER = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__TEMPLATE_PARAMETER = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__EXTENDED_BYS = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__INSTANCE_CLASS_NAME = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_ATTRIBUTE = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_INVARIANT = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__OWNED_OPERATION = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__PACKAGE = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__SUPER_CLASS = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_TEMPLATE = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___PARAMETERABLE_ELEMENTS = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___IS_TEMPLATE_PARAMETER = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = NAMED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = NAMED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__EXTENSION = TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_ANNOTATION = TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_COMMENT = TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_STATIC = TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_TEMPLATE_SIGNATURE = TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__TEMPLATE_BINDING = TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__UNSPECIALIZED_ELEMENT = TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNING_TEMPLATE_PARAMETER = TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__TEMPLATE_PARAMETER = TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__EXTENDED_BYS = TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__INSTANCE_CLASS_NAME = TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_ATTRIBUTE = TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_INVARIANT = TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_OPERATION = TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__PACKAGE = TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUPER_CLASS = TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_RULE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_ABSTRACT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_ACTIVE = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_INTERFACE = TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NESTED_TYPE = TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_BEHAVIOR = TYPE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = TYPE_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___ALL_OWNED_ELEMENTS = TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GET_VALUE__TYPE_STRING = TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_TEMPLATE = TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___PARAMETERABLE_ELEMENTS = TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_TEMPLATE_PARAMETER = TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE = TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__EXTENSION = CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__UNSPECIALIZED_ELEMENT = CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__EXTENDED_BYS = CLASS__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_INVARIANT = CLASS__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__IS_ACTIVE = CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__NESTED_TYPE = CLASS__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__OWNED_BEHAVIOR = CLASS__OWNED_BEHAVIOR;

	/**
	 * The number of structural features of the '<em>Any Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___ALL_OWNED_ELEMENTS = CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___GET_VALUE__TYPE_STRING = CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Any Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__EXTENSION = CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__UNSPECIALIZED_ELEMENT = CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__EXTENDED_BYS = CLASS__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_INVARIANT = CLASS__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__IS_ACTIVE = CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__NESTED_TYPE = CLASS__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OWNED_BEHAVIOR = CLASS__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Unowned Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE = CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Association Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_FEATURE_COUNT = CLASS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___ALL_OWNED_ELEMENTS = CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___GET_VALUE__TYPE_STRING = CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE = CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Association Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__IS_REQUIRED = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__EXTENSION = TYPED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__IS_REQUIRED = TYPED_ELEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>OCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION___ALL_OWNED_ELEMENTS = TYPED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION___GET_VALUE__TYPE_STRING = TYPED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>OCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__EXTENSION = OCL_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__IS_REQUIRED = OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__IMPLICIT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__SOURCE = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP___ALL_OWNED_ELEMENTS = OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP___GET_VALUE__TYPE_STRING = OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__EXTENSION = CALL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__OWNED_ANNOTATION = CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__OWNED_COMMENT = CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__IS_STATIC = CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__NAME = CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__IS_REQUIRED = CALL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__TYPE = CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__IMPLICIT = CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__SOURCE = CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP__IS_PRE = CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP___ALL_OWNED_ELEMENTS = CALL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP___GET_VALUE__TYPE_STRING = CALL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Feature Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXP_OPERATION_COUNT = CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__EXTENSION = FEATURE_CALL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__OWNED_ANNOTATION = FEATURE_CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__OWNED_COMMENT = FEATURE_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__IS_STATIC = FEATURE_CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__NAME = FEATURE_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__IS_REQUIRED = FEATURE_CALL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__TYPE = FEATURE_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__IMPLICIT = FEATURE_CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__IS_PRE = FEATURE_CALL_EXP__IS_PRE;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__NAVIGATION_SOURCE = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP__QUALIFIER = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Navigation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP___ALL_OWNED_ELEMENTS = FEATURE_CALL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP___GET_VALUE__TYPE_STRING = FEATURE_CALL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Navigation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_CALL_EXP_OPERATION_COUNT = FEATURE_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__EXTENSION = NAVIGATION_CALL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__OWNED_ANNOTATION = NAVIGATION_CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__OWNED_COMMENT = NAVIGATION_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__IS_STATIC = NAVIGATION_CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__NAME = NAVIGATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__IS_REQUIRED = NAVIGATION_CALL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__TYPE = NAVIGATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__IMPLICIT = NAVIGATION_CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__IS_PRE = NAVIGATION_CALL_EXP__IS_PRE;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Referred Association Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Association Class Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP___ALL_OWNED_ELEMENTS = NAVIGATION_CALL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP___GET_VALUE__TYPE_STRING = NAVIGATION_CALL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Association Class Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_CALL_EXP_OPERATION_COUNT = NAVIGATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__EXTENSION = CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__UNSPECIALIZED_ELEMENT = CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__EXTENDED_BYS = CLASS__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_INVARIANT = CLASS__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__IS_ACTIVE = CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NESTED_TYPE = CLASS__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OWNED_BEHAVIOR = CLASS__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__BEHAVIORAL_TYPE = CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__IS_SERIALIZABLE = CLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___ALL_OWNED_ELEMENTS = CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___GET_VALUE__TYPE_STRING = CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__EXTENSION = DATA_TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_ANNOTATION = DATA_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_COMMENT = DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IS_STATIC = DATA_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE = DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TEMPLATE_BINDING = DATA_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__UNSPECIALIZED_ELEMENT = DATA_TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER = DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TEMPLATE_PARAMETER = DATA_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__EXTENDED_BYS = DATA_TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__INSTANCE_CLASS_NAME = DATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_ATTRIBUTE = DATA_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_INVARIANT = DATA_TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_OPERATION = DATA_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__PACKAGE = DATA_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__SUPER_CLASS = DATA_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_RULE = DATA_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IS_ABSTRACT = DATA_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IS_ACTIVE = DATA_TYPE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IS_INTERFACE = DATA_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NESTED_TYPE = DATA_TYPE__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OWNED_BEHAVIOR = DATA_TYPE__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__BEHAVIORAL_TYPE = DATA_TYPE__BEHAVIORAL_TYPE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__IS_SERIALIZABLE = DATA_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__ELEMENT_TYPE = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__LOWER = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__UPPER = DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___ALL_OWNED_ELEMENTS = DATA_TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___GET_VALUE__TYPE_STRING = DATA_TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___IS_TEMPLATE = DATA_TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___PARAMETERABLE_ELEMENTS = DATA_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = DATA_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___IS_TEMPLATE_PARAMETER = DATA_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = DATA_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = DATA_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__EXTENSION = COLLECTION_TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_ANNOTATION = COLLECTION_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IS_STATIC = COLLECTION_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__UNSPECIALIZED_ELEMENT = COLLECTION_TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__EXTENDED_BYS = COLLECTION_TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_INVARIANT = COLLECTION_TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__SUPER_CLASS = COLLECTION_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IS_ACTIVE = COLLECTION_TYPE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IS_INTERFACE = COLLECTION_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__NESTED_TYPE = COLLECTION_TYPE__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OWNED_BEHAVIOR = COLLECTION_TYPE__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__BEHAVIORAL_TYPE = COLLECTION_TYPE__BEHAVIORAL_TYPE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__IS_SERIALIZABLE = COLLECTION_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__LOWER = COLLECTION_TYPE__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__UPPER = COLLECTION_TYPE__UPPER;

	/**
	 * The number of structural features of the '<em>Bag Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___ALL_OWNED_ELEMENTS = COLLECTION_TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___GET_VALUE__TYPE_STRING = COLLECTION_TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___IS_TEMPLATE = COLLECTION_TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___PARAMETERABLE_ELEMENTS = COLLECTION_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = COLLECTION_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___IS_TEMPLATE_PARAMETER = COLLECTION_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = COLLECTION_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = COLLECTION_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Bag Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.BehaviorImpl <em>Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.BehaviorImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBehavior()
	 * @generated
	 */
	int BEHAVIOR = 5;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__EXTENSION = CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__UNSPECIALIZED_ELEMENT = CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__EXTENDED_BYS = CLASS__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__OWNED_INVARIANT = CLASS__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__IS_ACTIVE = CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__NESTED_TYPE = CLASS__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__OWNED_BEHAVIOR = CLASS__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__TRANSITION = CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_FEATURE_COUNT = CLASS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR___ALL_OWNED_ELEMENTS = CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR___GET_VALUE__TYPE_STRING = CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR___SPECIALIZE_IN__OCLEXPRESSION_TYPE = CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__EXTENSION = OCL_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__IS_REQUIRED = OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The number of structural features of the '<em>Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP___ALL_OWNED_ELEMENTS = OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP___GET_VALUE__TYPE_STRING = OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__EXTENSION = LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__OWNED_ANNOTATION = LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__IS_STATIC = LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__IS_REQUIRED = LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The number of structural features of the '<em>Primitive Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP___ALL_OWNED_ELEMENTS = LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP___GET_VALUE__TYPE_STRING = LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Primitive Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__EXTENSION = PRIMITIVE_LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__OWNED_COMMENT = PRIMITIVE_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__IS_STATIC = PRIMITIVE_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__IS_REQUIRED = PRIMITIVE_LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Boolean Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP___ALL_OWNED_ELEMENTS = PRIMITIVE_LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP___GET_VALUE__TYPE_STRING = PRIMITIVE_LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Type Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP___VALIDATE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = PRIMITIVE_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_OPERATION_COUNT = PRIMITIVE_LITERAL_EXP_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION__OPERATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Call Operation Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Call Operation Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_OPERATION_ACTION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ConstructorExpImpl <em>Constructor Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ConstructorExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getConstructorExp()
	 * @generated
	 */
	int CONSTRUCTOR_EXP = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ConstructorPartImpl <em>Constructor Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ConstructorPartImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getConstructorPart()
	 * @generated
	 */
	int CONSTRUCTOR_PART = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DynamicElementImpl <em>Dynamic Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.DynamicElementImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDynamicElement()
	 * @generated
	 */
	int DYNAMIC_ELEMENT = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DynamicPropertyImpl <em>Dynamic Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.DynamicPropertyImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDynamicProperty()
	 * @generated
	 */
	int DYNAMIC_PROPERTY = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DynamicTypeImpl <em>Dynamic Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.DynamicTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDynamicType()
	 * @generated
	 */
	int DYNAMIC_TYPE = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LambdaTypeImpl <em>Lambda Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.LambdaTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLambdaType()
	 * @generated
	 */
	int LAMBDA_TYPE = 43;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MetaclassImpl <em>Metaclass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.MetaclassImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMetaclass()
	 * @generated
	 */
	int METACLASS = 50;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.util.MorePivotable <em>More Pivotable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.util.MorePivotable
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMorePivotable()
	 * @generated
	 */
	int MORE_PIVOTABLE = 51;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__EXTENSION = TYPED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__IS_REQUIRED = TYPED_ELEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>Collection Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART___ALL_OWNED_ELEMENTS = TYPED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART___GET_VALUE__TYPE_STRING = TYPED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Collection Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__EXTENSION = COLLECTION_LITERAL_PART__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__OWNED_ANNOTATION = COLLECTION_LITERAL_PART__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__OWNED_COMMENT = COLLECTION_LITERAL_PART__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__IS_STATIC = COLLECTION_LITERAL_PART__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__NAME = COLLECTION_LITERAL_PART__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__IS_REQUIRED = COLLECTION_LITERAL_PART__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__TYPE = COLLECTION_LITERAL_PART__TYPE;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__ITEM = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM___ALL_OWNED_ELEMENTS = COLLECTION_LITERAL_PART___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM___GET_VALUE__TYPE_STRING = COLLECTION_LITERAL_PART___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Type Is Item Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM___VALIDATE_TYPE_IS_ITEM_TYPE__DIAGNOSTICCHAIN_MAP = COLLECTION_LITERAL_PART_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Collection Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM_OPERATION_COUNT = COLLECTION_LITERAL_PART_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__EXTENSION = LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__OWNED_ANNOTATION = LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__IS_STATIC = LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__IS_REQUIRED = LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__KIND = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP___ALL_OWNED_ELEMENTS = LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP___GET_VALUE__TYPE_STRING = LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Bag Kind Is Bag</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP___VALIDATE_BAG_KIND_IS_BAG__DIAGNOSTICCHAIN_MAP = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Collection Kind Is Concrete</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP___VALIDATE_COLLECTION_KIND_IS_CONCRETE__DIAGNOSTICCHAIN_MAP = LITERAL_EXP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Ordered Set Kind Is Ordered Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP___VALIDATE_ORDERED_SET_KIND_IS_ORDERED_SET__DIAGNOSTICCHAIN_MAP = LITERAL_EXP_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Sequence Kind Is Sequence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP___VALIDATE_SEQUENCE_KIND_IS_SEQUENCE__DIAGNOSTICCHAIN_MAP = LITERAL_EXP_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Set Kind Is Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP___VALIDATE_SET_KIND_IS_SET__DIAGNOSTICCHAIN_MAP = LITERAL_EXP_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Collection Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__EXTENSION = COLLECTION_LITERAL_PART__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__OWNED_ANNOTATION = COLLECTION_LITERAL_PART__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__OWNED_COMMENT = COLLECTION_LITERAL_PART__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__IS_STATIC = COLLECTION_LITERAL_PART__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__NAME = COLLECTION_LITERAL_PART__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__IS_REQUIRED = COLLECTION_LITERAL_PART__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__TYPE = COLLECTION_LITERAL_PART__TYPE;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__FIRST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__LAST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE___ALL_OWNED_ELEMENTS = COLLECTION_LITERAL_PART___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE___GET_VALUE__TYPE_STRING = COLLECTION_LITERAL_PART___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Collection Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_OPERATION_COUNT = COLLECTION_LITERAL_PART_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__ANNOTATED_ELEMENT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__BODY = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VertexImpl <em>Vertex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.VertexImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVertex()
	 * @generated
	 */
	int VERTEX = 116;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__CONTAINER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__INCOMING = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__OUTGOING = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ConnectionPointReferenceImpl <em>Connection Point Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ConnectionPointReferenceImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getConnectionPointReference()
	 * @generated
	 */
	int CONNECTION_POINT_REFERENCE = 16;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE__EXTENSION = VERTEX__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE__OWNED_ANNOTATION = VERTEX__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE__OWNED_COMMENT = VERTEX__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE__IS_STATIC = VERTEX__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE__NAME = VERTEX__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE__CONTAINER = VERTEX__CONTAINER;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE__INCOMING = VERTEX__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE__OUTGOING = VERTEX__OUTGOING;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE__ENTRY = VERTEX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE__EXIT = VERTEX_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE__STATE = VERTEX_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Connection Point Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE_FEATURE_COUNT = VERTEX_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE___ALL_OWNED_ELEMENTS = VERTEX___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE___GET_VALUE__TYPE_STRING = VERTEX___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Connection Point Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE_OPERATION_COUNT = VERTEX_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Constrained Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONSTRAINED_ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONTEXT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Callable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__IS_CALLABLE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__OWNING_STATE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Redefined Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__REDEFINED_CONSTRAINT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__SPECIFICATION = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__TRANSITION = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Unique Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT___VALIDATE_UNIQUE_NAME__DIAGNOSTICCHAIN_MAP = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP__EXTENSION = OCL_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP__IS_REQUIRED = OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP__PART = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP__VALUE = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constructor Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP___ALL_OWNED_ELEMENTS = OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP___GET_VALUE__TYPE_STRING = OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Constructor Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART__EXTENSION = TYPED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART__IS_REQUIRED = TYPED_ELEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART__INIT_EXPRESSION = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART__REFERRED_PROPERTY = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constructor Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART___ALL_OWNED_ELEMENTS = TYPED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART___GET_VALUE__TYPE_STRING = TYPED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Constructor Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_PART_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DynamicBehaviorImpl <em>Dynamic Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.DynamicBehaviorImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDynamicBehavior()
	 * @generated
	 */
	int DYNAMIC_BEHAVIOR = 22;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__EXTENSION = BEHAVIOR__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__OWNED_ANNOTATION = BEHAVIOR__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__OWNED_COMMENT = BEHAVIOR__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__IS_STATIC = BEHAVIOR__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__NAME = BEHAVIOR__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__OWNED_TEMPLATE_SIGNATURE = BEHAVIOR__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__TEMPLATE_BINDING = BEHAVIOR__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__UNSPECIALIZED_ELEMENT = BEHAVIOR__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__OWNING_TEMPLATE_PARAMETER = BEHAVIOR__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__TEMPLATE_PARAMETER = BEHAVIOR__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__EXTENDED_BYS = BEHAVIOR__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__INSTANCE_CLASS_NAME = BEHAVIOR__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__OWNED_ATTRIBUTE = BEHAVIOR__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__OWNED_INVARIANT = BEHAVIOR__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__OWNED_OPERATION = BEHAVIOR__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__PACKAGE = BEHAVIOR__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__SUPER_CLASS = BEHAVIOR__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__OWNED_RULE = BEHAVIOR__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__IS_ABSTRACT = BEHAVIOR__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__IS_ACTIVE = BEHAVIOR__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__IS_INTERFACE = BEHAVIOR__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__NESTED_TYPE = BEHAVIOR__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__OWNED_BEHAVIOR = BEHAVIOR__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__TRANSITION = BEHAVIOR__TRANSITION;

	/**
	 * The feature id for the '<em><b>Meta Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__META_TYPE = BEHAVIOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR__OWNED_PROPERTY = BEHAVIOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dynamic Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR___ALL_OWNED_ELEMENTS = BEHAVIOR___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR___GET_VALUE__TYPE_STRING = BEHAVIOR___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR___IS_TEMPLATE = BEHAVIOR___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR___PARAMETERABLE_ELEMENTS = BEHAVIOR___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = BEHAVIOR___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR___IS_TEMPLATE_PARAMETER = BEHAVIOR___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = BEHAVIOR___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR___SPECIALIZE_IN__OCLEXPRESSION_TYPE = BEHAVIOR___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Dynamic Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_BEHAVIOR_OPERATION_COUNT = BEHAVIOR_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ELEMENT__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ELEMENT__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ELEMENT__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Meta Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ELEMENT__META_TYPE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dynamic Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ELEMENT___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ELEMENT___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Dynamic Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROPERTY__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROPERTY__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROPERTY__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROPERTY__DEFAULT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROPERTY__REFERRED_PROPERTY = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dynamic Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROPERTY_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROPERTY___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROPERTY___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Dynamic Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROPERTY_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__EXTENSION = TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__OWNED_ANNOTATION = TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__OWNED_COMMENT = TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__IS_STATIC = TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__OWNED_TEMPLATE_SIGNATURE = TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__TEMPLATE_BINDING = TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__UNSPECIALIZED_ELEMENT = TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__OWNING_TEMPLATE_PARAMETER = TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__TEMPLATE_PARAMETER = TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__EXTENDED_BYS = TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__INSTANCE_CLASS_NAME = TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__OWNED_ATTRIBUTE = TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__OWNED_INVARIANT = TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__OWNED_OPERATION = TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__PACKAGE = TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__SUPER_CLASS = TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Meta Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__META_TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE__OWNED_PROPERTY = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dynamic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE___ALL_OWNED_ELEMENTS = TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE___GET_VALUE__TYPE_STRING = TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE___IS_TEMPLATE = TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE___PARAMETERABLE_ELEMENTS = TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE___IS_TEMPLATE_PARAMETER = TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Dynamic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ElementExtensionImpl <em>Element Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ElementExtensionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getElementExtension()
	 * @generated
	 */
	int ELEMENT_EXTENSION = 27;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__EXTENSION = TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__OWNED_ANNOTATION = TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__OWNED_COMMENT = TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__IS_STATIC = TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__OWNED_TEMPLATE_SIGNATURE = TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__TEMPLATE_BINDING = TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__UNSPECIALIZED_ELEMENT = TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__OWNING_TEMPLATE_PARAMETER = TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__TEMPLATE_PARAMETER = TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__EXTENDED_BYS = TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__INSTANCE_CLASS_NAME = TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__OWNED_ATTRIBUTE = TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__OWNED_INVARIANT = TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__OWNED_OPERATION = TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__PACKAGE = TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__SUPER_CLASS = TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Base</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__BASE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Applied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__IS_APPLIED = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__IS_REQUIRED = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION__STEREOTYPE = TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Element Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION_FEATURE_COUNT = TYPE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION___ALL_OWNED_ELEMENTS = TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION___GET_VALUE__TYPE_STRING = TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION___IS_TEMPLATE = TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION___PARAMETERABLE_ELEMENTS = TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION___IS_TEMPLATE_PARAMETER = TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION___SPECIALIZE_IN__OCLEXPRESSION_TYPE = TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Element Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_EXTENSION_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__EXTENSION = LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__OWNED_ANNOTATION = LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__IS_STATIC = LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__IS_REQUIRED = LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Referred Enum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP___ALL_OWNED_ELEMENTS = LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP___GET_VALUE__TYPE_STRING = LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Type Is Enumeration Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP___VALIDATE_TYPE_IS_ENUMERATION_TYPE__DIAGNOSTICCHAIN_MAP = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Enum Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__EXTENSION = DATA_TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_ANNOTATION = DATA_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_COMMENT = DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__IS_STATIC = DATA_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_TEMPLATE_SIGNATURE = DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__TEMPLATE_BINDING = DATA_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__UNSPECIALIZED_ELEMENT = DATA_TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNING_TEMPLATE_PARAMETER = DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__TEMPLATE_PARAMETER = DATA_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__EXTENDED_BYS = DATA_TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__INSTANCE_CLASS_NAME = DATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_ATTRIBUTE = DATA_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_INVARIANT = DATA_TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_OPERATION = DATA_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__PACKAGE = DATA_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__SUPER_CLASS = DATA_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_RULE = DATA_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__IS_ABSTRACT = DATA_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__IS_ACTIVE = DATA_TYPE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__IS_INTERFACE = DATA_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NESTED_TYPE = DATA_TYPE__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_BEHAVIOR = DATA_TYPE__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__BEHAVIORAL_TYPE = DATA_TYPE__BEHAVIORAL_TYPE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__IS_SERIALIZABLE = DATA_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Owned Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_LITERAL = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___ALL_OWNED_ELEMENTS = DATA_TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___GET_VALUE__TYPE_STRING = DATA_TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___IS_TEMPLATE = DATA_TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___PARAMETERABLE_ELEMENTS = DATA_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = DATA_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___IS_TEMPLATE_PARAMETER = DATA_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = DATA_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION___SPECIALIZE_IN__OCLEXPRESSION_TYPE = DATA_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__ENUMERATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__EXTENSION = TYPED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__IS_REQUIRED = TYPED_ELEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__OWNING_TEMPLATE_PARAMETER = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION__TEMPLATE_PARAMETER = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___ALL_OWNED_ELEMENTS = TYPED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___GET_VALUE__TYPE_STRING = TYPED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___IS_TEMPLATE_PARAMETER = TYPED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Boolean Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___BOOLEAN_VALUE = TYPED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Integer Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___INTEGER_VALUE = TYPED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Computable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___IS_COMPUTABLE = TYPED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___IS_NULL = TYPED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___STRING_VALUE = TYPED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Unlimited Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION___UNLIMITED_VALUE = TYPED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The number of operations of the '<em>Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__EXTENSION = VALUE_SPECIFICATION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__OWNED_ANNOTATION = VALUE_SPECIFICATION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__OWNED_COMMENT = VALUE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__IS_STATIC = VALUE_SPECIFICATION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__NAME = VALUE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__IS_REQUIRED = VALUE_SPECIFICATION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__TYPE = VALUE_SPECIFICATION__TYPE;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER = VALUE_SPECIFICATION__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__TEMPLATE_PARAMETER = VALUE_SPECIFICATION__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__BODY = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression In OCL</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__EXPRESSION_IN_OCL = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION__LANGUAGE = VALUE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Opaque Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___ALL_OWNED_ELEMENTS = VALUE_SPECIFICATION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___GET_VALUE__TYPE_STRING = VALUE_SPECIFICATION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = VALUE_SPECIFICATION___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___IS_TEMPLATE_PARAMETER = VALUE_SPECIFICATION___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Boolean Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___BOOLEAN_VALUE = VALUE_SPECIFICATION___BOOLEAN_VALUE;

	/**
	 * The operation id for the '<em>Integer Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___INTEGER_VALUE = VALUE_SPECIFICATION___INTEGER_VALUE;

	/**
	 * The operation id for the '<em>Is Computable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___IS_COMPUTABLE = VALUE_SPECIFICATION___IS_COMPUTABLE;

	/**
	 * The operation id for the '<em>Is Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___IS_NULL = VALUE_SPECIFICATION___IS_NULL;

	/**
	 * The operation id for the '<em>String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___STRING_VALUE = VALUE_SPECIFICATION___STRING_VALUE;

	/**
	 * The operation id for the '<em>Unlimited Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION___UNLIMITED_VALUE = VALUE_SPECIFICATION___UNLIMITED_VALUE;

	/**
	 * The number of operations of the '<em>Opaque Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_EXPRESSION_OPERATION_COUNT = VALUE_SPECIFICATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__EXTENSION = OPAQUE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNED_ANNOTATION = OPAQUE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNED_COMMENT = OPAQUE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__IS_STATIC = OPAQUE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__NAME = OPAQUE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__IS_REQUIRED = OPAQUE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__TYPE = OPAQUE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER = OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__TEMPLATE_PARAMETER = OPAQUE_EXPRESSION__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__BODY = OPAQUE_EXPRESSION__BODY;

	/**
	 * The feature id for the '<em><b>Expression In OCL</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__EXPRESSION_IN_OCL = OPAQUE_EXPRESSION__EXPRESSION_IN_OCL;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__LANGUAGE = OPAQUE_EXPRESSION__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__BODY_EXPRESSION = OPAQUE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__CONTEXT_VARIABLE = OPAQUE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__PARAMETER_VARIABLE = OPAQUE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Result Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__RESULT_VARIABLE = OPAQUE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Expression In OCL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL_FEATURE_COUNT = OPAQUE_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___ALL_OWNED_ELEMENTS = OPAQUE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___GET_VALUE__TYPE_STRING = OPAQUE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = OPAQUE_EXPRESSION___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___IS_TEMPLATE_PARAMETER = OPAQUE_EXPRESSION___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Boolean Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___BOOLEAN_VALUE = OPAQUE_EXPRESSION___BOOLEAN_VALUE;

	/**
	 * The operation id for the '<em>Integer Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___INTEGER_VALUE = OPAQUE_EXPRESSION___INTEGER_VALUE;

	/**
	 * The operation id for the '<em>Is Computable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___IS_COMPUTABLE = OPAQUE_EXPRESSION___IS_COMPUTABLE;

	/**
	 * The operation id for the '<em>Is Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___IS_NULL = OPAQUE_EXPRESSION___IS_NULL;

	/**
	 * The operation id for the '<em>String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___STRING_VALUE = OPAQUE_EXPRESSION___STRING_VALUE;

	/**
	 * The operation id for the '<em>Unlimited Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL___UNLIMITED_VALUE = OPAQUE_EXPRESSION___UNLIMITED_VALUE;

	/**
	 * The number of operations of the '<em>Expression In OCL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL_OPERATION_COUNT = OPAQUE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__EXTENSION = TYPED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__IS_REQUIRED = TYPED_ELEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>Typed Multiplicity Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___ALL_OWNED_ELEMENTS = TYPED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___GET_VALUE__TYPE_STRING = TYPED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___COMPATIBLE_BODY__VALUESPECIFICATION = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Make Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT___MAKE_PARAMETER = TYPED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Typed Multiplicity Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MULTIPLICITY_ELEMENT_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__EXTENSION = TYPED_MULTIPLICITY_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__OWNED_ANNOTATION = TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__OWNED_COMMENT = TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__IS_STATIC = TYPED_MULTIPLICITY_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = TYPED_MULTIPLICITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__IS_REQUIRED = TYPED_MULTIPLICITY_ELEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__TYPE = TYPED_MULTIPLICITY_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__IMPLEMENTATION = TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__IMPLEMENTATION_CLASS = TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___ALL_OWNED_ELEMENTS = TYPED_MULTIPLICITY_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___GET_VALUE__TYPE_STRING = TYPED_MULTIPLICITY_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___COMPATIBLE_BODY__VALUESPECIFICATION = TYPED_MULTIPLICITY_ELEMENT___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Make Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___MAKE_PARAMETER = TYPED_MULTIPLICITY_ELEMENT___MAKE_PARAMETER;

	/**
	 * The number of operations of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_COUNT = TYPED_MULTIPLICITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ProfileImpl <em>Profile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ProfileImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getProfile()
	 * @generated
	 */
	int PROFILE = 73;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PseudostateImpl <em>Pseudostate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PseudostateImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPseudostate()
	 * @generated
	 */
	int PSEUDOSTATE = 77;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.ReferringElement <em>Referring Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.ReferringElement
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getReferringElement()
	 * @generated
	 */
	int REFERRING_ELEMENT = 79;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.RegionImpl <em>Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.RegionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 80;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.RootImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 81;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SelfTypeImpl <em>Self Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.SelfTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSelfType()
	 * @generated
	 */
	int SELF_TYPE = 82;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EXTENSION = VERTEX__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OWNED_ANNOTATION = VERTEX__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OWNED_COMMENT = VERTEX__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IS_STATIC = VERTEX__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = VERTEX__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__CONTAINER = VERTEX__CONTAINER;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INCOMING = VERTEX__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING = VERTEX__OUTGOING;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OWNED_RULE = VERTEX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__CONNECTION = VERTEX_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Connection Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__CONNECTION_POINT = VERTEX_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Deferrable Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__DEFERRABLE_TRIGGER = VERTEX_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Do Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__DO_ACTIVITY = VERTEX_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ENTRY = VERTEX_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EXIT = VERTEX_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Is Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IS_COMPOSITE = VERTEX_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Is Orthogonal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IS_ORTHOGONAL = VERTEX_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Is Simple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IS_SIMPLE = VERTEX_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Is Submachine State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IS_SUBMACHINE_STATE = VERTEX_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Redefined State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__REDEFINED_STATE = VERTEX_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__REGION = VERTEX_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>State Invariant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__STATE_INVARIANT = VERTEX_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Submachine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SUBMACHINE = VERTEX_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = VERTEX_FEATURE_COUNT + 15;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE___ALL_OWNED_ELEMENTS = VERTEX___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE___GET_VALUE__TYPE_STRING = VERTEX___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = VERTEX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.FinalStateImpl <em>Final State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.FinalStateImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getFinalState()
	 * @generated
	 */
	int FINAL_STATE = 34;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__EXTENSION = STATE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__OWNED_ANNOTATION = STATE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__OWNED_COMMENT = STATE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__IS_STATIC = STATE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__CONTAINER = STATE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__INCOMING = STATE__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__OUTGOING = STATE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__OWNED_RULE = STATE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__CONNECTION = STATE__CONNECTION;

	/**
	 * The feature id for the '<em><b>Connection Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__CONNECTION_POINT = STATE__CONNECTION_POINT;

	/**
	 * The feature id for the '<em><b>Deferrable Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__DEFERRABLE_TRIGGER = STATE__DEFERRABLE_TRIGGER;

	/**
	 * The feature id for the '<em><b>Do Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__DO_ACTIVITY = STATE__DO_ACTIVITY;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__ENTRY = STATE__ENTRY;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__EXIT = STATE__EXIT;

	/**
	 * The feature id for the '<em><b>Is Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__IS_COMPOSITE = STATE__IS_COMPOSITE;

	/**
	 * The feature id for the '<em><b>Is Orthogonal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__IS_ORTHOGONAL = STATE__IS_ORTHOGONAL;

	/**
	 * The feature id for the '<em><b>Is Simple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__IS_SIMPLE = STATE__IS_SIMPLE;

	/**
	 * The feature id for the '<em><b>Is Submachine State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__IS_SUBMACHINE_STATE = STATE__IS_SUBMACHINE_STATE;

	/**
	 * The feature id for the '<em><b>Redefined State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__REDEFINED_STATE = STATE__REDEFINED_STATE;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__REGION = STATE__REGION;

	/**
	 * The feature id for the '<em><b>State Invariant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__STATE_INVARIANT = STATE__STATE_INVARIANT;

	/**
	 * The feature id for the '<em><b>Submachine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__SUBMACHINE = STATE__SUBMACHINE;

	/**
	 * The number of structural features of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE___ALL_OWNED_ELEMENTS = STATE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE___GET_VALUE__TYPE_STRING = STATE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__EXTENSION = OCL_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__IS_REQUIRED = OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__CONDITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__ELSE_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP__THEN_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP___ALL_OWNED_ELEMENTS = OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP___GET_VALUE__TYPE_STRING = OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Condition Type Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP___VALIDATE_CONDITION_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ImportImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 36;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Imported Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORTED_NAMESPACE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__EXTENSION = PRIMITIVE_LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__OWNED_COMMENT = PRIMITIVE_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__IS_STATIC = PRIMITIVE_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__IS_REQUIRED = PRIMITIVE_LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The number of structural features of the '<em>Numeric Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP___ALL_OWNED_ELEMENTS = PRIMITIVE_LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP___GET_VALUE__TYPE_STRING = PRIMITIVE_LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Numeric Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_EXP_OPERATION_COUNT = PRIMITIVE_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__EXTENSION = NUMERIC_LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__OWNED_ANNOTATION = NUMERIC_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__OWNED_COMMENT = NUMERIC_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__IS_STATIC = NUMERIC_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__IS_REQUIRED = NUMERIC_LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__TYPE = NUMERIC_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__INTEGER_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP___ALL_OWNED_ELEMENTS = NUMERIC_LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP___GET_VALUE__TYPE_STRING = NUMERIC_LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Type Is Integer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP___VALIDATE_TYPE_IS_INTEGER__DIAGNOSTICCHAIN_MAP = NUMERIC_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Integer Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_OPERATION_COUNT = NUMERIC_LITERAL_EXP_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__EXTENSION = LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__OWNED_ANNOTATION = LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__IS_STATIC = LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__IS_REQUIRED = LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The number of structural features of the '<em>Invalid Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP___ALL_OWNED_ELEMENTS = LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP___GET_VALUE__TYPE_STRING = LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Invalid Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__EXTENSION = CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__UNSPECIALIZED_ELEMENT = CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__EXTENDED_BYS = CLASS__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_INVARIANT = CLASS__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__IS_ACTIVE = CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__NESTED_TYPE = CLASS__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE__OWNED_BEHAVIOR = CLASS__OWNED_BEHAVIOR;

	/**
	 * The number of structural features of the '<em>Invalid Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___ALL_OWNED_ELEMENTS = CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___GET_VALUE__TYPE_STRING = CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Invalid Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_TYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__EXTENSION = CALL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__OWNED_ANNOTATION = CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__OWNED_COMMENT = CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__IS_STATIC = CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__NAME = CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__IS_REQUIRED = CALL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__TYPE = CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__IMPLICIT = CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__SOURCE = CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__BODY = CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__ITERATOR = CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__REFERRED_ITERATION = CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP___ALL_OWNED_ELEMENTS = CALL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP___GET_VALUE__TYPE_STRING = CALL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate No Initializers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP = CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Source Is Collection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP = CALL_EXP_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_OPERATION_COUNT = CALL_EXP_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__EXTENSION = LOOP_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__OWNED_ANNOTATION = LOOP_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__OWNED_COMMENT = LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__IS_STATIC = LOOP_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__NAME = LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__IS_REQUIRED = LOOP_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__TYPE = LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__IMPLICIT = LOOP_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__SOURCE = LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__BODY = LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__ITERATOR = LOOP_EXP__ITERATOR;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__REFERRED_ITERATION = LOOP_EXP__REFERRED_ITERATION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__RESULT = LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Iterate Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP___ALL_OWNED_ELEMENTS = LOOP_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP___GET_VALUE__TYPE_STRING = LOOP_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate No Initializers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP = LOOP_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Source Is Collection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP = LOOP_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Referred Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP___GET_REFERRED_ELEMENT = LOOP_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Body Type Conforms To Result Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP___VALIDATE_BODY_TYPE_CONFORMS_TO_RESULT_TYPE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate One Initializer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP___VALIDATE_ONE_INITIALIZER__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Type Is Result Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP___VALIDATE_TYPE_IS_RESULT_TYPE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Iterate Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_OPERATION_COUNT = LOOP_EXP_OPERATION_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__EXTENSION = FEATURE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_ANNOTATION = FEATURE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_COMMENT = FEATURE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IS_STATIC = FEATURE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IS_REQUIRED = FEATURE__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TYPE = FEATURE__TYPE;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IMPLEMENTATION = FEATURE__IMPLEMENTATION;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IMPLEMENTATION_CLASS = FEATURE__IMPLEMENTATION_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_RULE = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_TEMPLATE_SIGNATURE = FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TEMPLATE_BINDING = FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__UNSPECIALIZED_ELEMENT = FEATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNING_TEMPLATE_PARAMETER = FEATURE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TEMPLATE_PARAMETER = FEATURE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__BODY_EXPRESSION = FEATURE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__CLASS = FEATURE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Is Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IS_INVALIDATING = FEATURE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Is Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IS_VALIDATING = FEATURE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_PARAMETER = FEATURE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Owning Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNING_TYPE = FEATURE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Postcondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__POSTCONDITION = FEATURE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PRECEDENCE = FEATURE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PRECONDITION = FEATURE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Raised Exception</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__RAISED_EXCEPTION = FEATURE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Redefined Operation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__REDEFINED_OPERATION = FEATURE_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 17;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___ALL_OWNED_ELEMENTS = FEATURE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___GET_VALUE__TYPE_STRING = FEATURE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___COMPATIBLE_BODY__VALUESPECIFICATION = FEATURE___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Make Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___MAKE_PARAMETER = FEATURE___MAKE_PARAMETER;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___IS_TEMPLATE = FEATURE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___PARAMETERABLE_ELEMENTS = FEATURE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = FEATURE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___IS_TEMPLATE_PARAMETER = FEATURE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Compatible Return</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___VALIDATE_COMPATIBLE_RETURN__DIAGNOSTICCHAIN_MAP = FEATURE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Loadable Implementation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___VALIDATE_LOADABLE_IMPLEMENTATION__DIAGNOSTICCHAIN_MAP = FEATURE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Unique Postcondition Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___VALIDATE_UNIQUE_POSTCONDITION_NAME__DIAGNOSTICCHAIN_MAP = FEATURE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Validate Unique Precondition Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___VALIDATE_UNIQUE_PRECONDITION_NAME__DIAGNOSTICCHAIN_MAP = FEATURE_OPERATION_COUNT + 7;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = FEATURE_OPERATION_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__EXTENSION = OPERATION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_ANNOTATION = OPERATION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_COMMENT = OPERATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IS_STATIC = OPERATION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__NAME = OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IS_REQUIRED = OPERATION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__TYPE = OPERATION__TYPE;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IMPLEMENTATION = OPERATION__IMPLEMENTATION;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IMPLEMENTATION_CLASS = OPERATION__IMPLEMENTATION_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_RULE = OPERATION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_TEMPLATE_SIGNATURE = OPERATION__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__TEMPLATE_BINDING = OPERATION__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__UNSPECIALIZED_ELEMENT = OPERATION__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNING_TEMPLATE_PARAMETER = OPERATION__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__TEMPLATE_PARAMETER = OPERATION__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__BODY_EXPRESSION = OPERATION__BODY_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__CLASS = OPERATION__CLASS;

	/**
	 * The feature id for the '<em><b>Is Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IS_INVALIDATING = OPERATION__IS_INVALIDATING;

	/**
	 * The feature id for the '<em><b>Is Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__IS_VALIDATING = OPERATION__IS_VALIDATING;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_PARAMETER = OPERATION__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Owning Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNING_TYPE = OPERATION__OWNING_TYPE;

	/**
	 * The feature id for the '<em><b>Postcondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__POSTCONDITION = OPERATION__POSTCONDITION;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__PRECEDENCE = OPERATION__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__PRECONDITION = OPERATION__PRECONDITION;

	/**
	 * The feature id for the '<em><b>Raised Exception</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__RAISED_EXCEPTION = OPERATION__RAISED_EXCEPTION;

	/**
	 * The feature id for the '<em><b>Redefined Operation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__REDEFINED_OPERATION = OPERATION__REDEFINED_OPERATION;

	/**
	 * The feature id for the '<em><b>Owned Accumulator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_ACCUMULATOR = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__OWNED_ITERATOR = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___ALL_OWNED_ELEMENTS = OPERATION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___GET_VALUE__TYPE_STRING = OPERATION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___COMPATIBLE_BODY__VALUESPECIFICATION = OPERATION___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Make Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___MAKE_PARAMETER = OPERATION___MAKE_PARAMETER;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___IS_TEMPLATE = OPERATION___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___PARAMETERABLE_ELEMENTS = OPERATION___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = OPERATION___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___IS_TEMPLATE_PARAMETER = OPERATION___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Compatible Return</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___VALIDATE_COMPATIBLE_RETURN__DIAGNOSTICCHAIN_MAP = OPERATION___VALIDATE_COMPATIBLE_RETURN__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Loadable Implementation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___VALIDATE_LOADABLE_IMPLEMENTATION__DIAGNOSTICCHAIN_MAP = OPERATION___VALIDATE_LOADABLE_IMPLEMENTATION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Unique Postcondition Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___VALIDATE_UNIQUE_POSTCONDITION_NAME__DIAGNOSTICCHAIN_MAP = OPERATION___VALIDATE_UNIQUE_POSTCONDITION_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Unique Precondition Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION___VALIDATE_UNIQUE_PRECONDITION_NAME__DIAGNOSTICCHAIN_MAP = OPERATION___VALIDATE_UNIQUE_PRECONDITION_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__EXTENSION = LOOP_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__OWNED_ANNOTATION = LOOP_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__OWNED_COMMENT = LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__IS_STATIC = LOOP_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__NAME = LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__IS_REQUIRED = LOOP_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__TYPE = LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__IMPLICIT = LOOP_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__SOURCE = LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__BODY = LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__ITERATOR = LOOP_EXP__ITERATOR;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__REFERRED_ITERATION = LOOP_EXP__REFERRED_ITERATION;

	/**
	 * The number of structural features of the '<em>Iterator Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___ALL_OWNED_ELEMENTS = LOOP_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___GET_VALUE__TYPE_STRING = LOOP_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate No Initializers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP = LOOP_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Source Is Collection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP = LOOP_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Referred Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___GET_REFERRED_ELEMENT = LOOP_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Any Body Type Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_ANY_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Any Has One Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_ANY_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Any Type Is Source Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_ANY_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Closure Body Type Is Conformantto Iterator Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_CLOSURE_BODY_TYPE_IS_CONFORMANTTO_ITERATOR_TYPE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Closure Element Type Is Source Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_CLOSURE_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Closure Has One Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_CLOSURE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Validate Closure Source Element Type Is Body Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_CLOSURE_SOURCE_ELEMENT_TYPE_IS_BODY_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Validate Closure Type Is Unique Collection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_CLOSURE_TYPE_IS_UNIQUE_COLLECTION__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Validate Collect Element Type Is Source Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_COLLECT_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Validate Collect Has One Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_COLLECT_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Validate Collect Nested Has One Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_COLLECT_NESTED_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Validate Collect Nested Type Is Bag</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_COLLECT_NESTED_TYPE_IS_BAG__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Validate Collect Nested Type Is Body Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_COLLECT_NESTED_TYPE_IS_BODY_TYPE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Validate Collect Type Is Unordered</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_COLLECT_TYPE_IS_UNORDERED__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Validate Exists Body Type Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_EXISTS_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Validate Exists Type Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_EXISTS_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Validate For All Body Type Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_FOR_ALL_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Validate For All Type Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_FOR_ALL_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>Validate Is Unique Has One Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_IS_UNIQUE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Validate Is Unique Type Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_IS_UNIQUE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>Validate Iterator Type Is Source Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_ITERATOR_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 21;

	/**
	 * The operation id for the '<em>Validate One Body Type Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_ONE_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 22;

	/**
	 * The operation id for the '<em>Validate One Has One Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_ONE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 23;

	/**
	 * The operation id for the '<em>Validate One Type Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_ONE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 24;

	/**
	 * The operation id for the '<em>Validate Reject Or Select Has One Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 25;

	/**
	 * The operation id for the '<em>Validate Reject Or Select Type Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 26;

	/**
	 * The operation id for the '<em>Validate Reject Or Select Type Is Source Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_TYPE_IS_SOURCE_TYPE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 27;

	/**
	 * The operation id for the '<em>Validate Sorted By Element Type Is Source Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_SORTED_BY_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 28;

	/**
	 * The operation id for the '<em>Validate Sorted By Has One Iterator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_SORTED_BY_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 29;

	/**
	 * The operation id for the '<em>Validate Sorted By Is Ordered If Source Is Ordered</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_SORTED_BY_IS_ORDERED_IF_SOURCE_IS_ORDERED__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 30;

	/**
	 * The operation id for the '<em>Validate Sorted By Iterator Type Is Comparable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP___VALIDATE_SORTED_BY_ITERATOR_TYPE_IS_COMPARABLE__DIAGNOSTICCHAIN_MAP = LOOP_EXP_OPERATION_COUNT + 31;

	/**
	 * The number of operations of the '<em>Iterator Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_OPERATION_COUNT = LOOP_EXP_OPERATION_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__EXTENSION = DATA_TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__OWNED_ANNOTATION = DATA_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__OWNED_COMMENT = DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__IS_STATIC = DATA_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__OWNED_TEMPLATE_SIGNATURE = DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__TEMPLATE_BINDING = DATA_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__UNSPECIALIZED_ELEMENT = DATA_TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__OWNING_TEMPLATE_PARAMETER = DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__TEMPLATE_PARAMETER = DATA_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__EXTENDED_BYS = DATA_TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__INSTANCE_CLASS_NAME = DATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__OWNED_ATTRIBUTE = DATA_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__OWNED_INVARIANT = DATA_TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__OWNED_OPERATION = DATA_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__PACKAGE = DATA_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__SUPER_CLASS = DATA_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__OWNED_RULE = DATA_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__IS_ABSTRACT = DATA_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__IS_ACTIVE = DATA_TYPE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__IS_INTERFACE = DATA_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__NESTED_TYPE = DATA_TYPE__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__OWNED_BEHAVIOR = DATA_TYPE__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__BEHAVIORAL_TYPE = DATA_TYPE__BEHAVIORAL_TYPE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__IS_SERIALIZABLE = DATA_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Context Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__CONTEXT_TYPE = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__PARAMETER_TYPE = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE__RESULT_TYPE = DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Lambda Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE___ALL_OWNED_ELEMENTS = DATA_TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE___GET_VALUE__TYPE_STRING = DATA_TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE___IS_TEMPLATE = DATA_TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE___PARAMETERABLE_ELEMENTS = DATA_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = DATA_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE___IS_TEMPLATE_PARAMETER = DATA_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = DATA_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = DATA_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Lambda Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__EXTENSION = OCL_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__IS_REQUIRED = OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__IN = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP___ALL_OWNED_ELEMENTS = OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP___GET_VALUE__TYPE_STRING = OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Type Is In Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP___VALIDATE_TYPE_IS_IN_TYPE__DIAGNOSTICCHAIN_MAP = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Let Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__OWNED_RULE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__EXTENSION = NAMESPACE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_ANNOTATION = NAMESPACE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_COMMENT = NAMESPACE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__IS_STATIC = NAMESPACE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_RULE = NAMESPACE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_TEMPLATE_SIGNATURE = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__TEMPLATE_BINDING = NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__UNSPECIALIZED_ELEMENT = NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Imported Package</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__IMPORTED_PACKAGE = NAMESPACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NESTED_PACKAGE = NAMESPACE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NESTING_PACKAGE = NAMESPACE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NS_PREFIX = NAMESPACE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NS_URI = NAMESPACE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_TYPE = NAMESPACE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Profile Application</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__PROFILE_APPLICATION = NAMESPACE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___ALL_OWNED_ELEMENTS = NAMESPACE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___GET_VALUE__TYPE_STRING = NAMESPACE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___IS_TEMPLATE = NAMESPACE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___PARAMETERABLE_ELEMENTS = NAMESPACE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OPERATION_COUNT = NAMESPACE_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EXTENSION = PACKAGE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_ANNOTATION = PACKAGE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_COMMENT = PACKAGE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__IS_STATIC = PACKAGE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NAME = PACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_RULE = PACKAGE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_TEMPLATE_SIGNATURE = PACKAGE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__TEMPLATE_BINDING = PACKAGE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__UNSPECIALIZED_ELEMENT = PACKAGE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Imported Package</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__IMPORTED_PACKAGE = PACKAGE__IMPORTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NESTED_PACKAGE = PACKAGE__NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NESTING_PACKAGE = PACKAGE__NESTING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NS_PREFIX = PACKAGE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NS_URI = PACKAGE__NS_URI;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_TYPE = PACKAGE__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Profile Application</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__PROFILE_APPLICATION = PACKAGE__PROFILE_APPLICATION;

	/**
	 * The feature id for the '<em><b>Owned Precedence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_PRECEDENCE = PACKAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = PACKAGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY___ALL_OWNED_ELEMENTS = PACKAGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY___GET_VALUE__TYPE_STRING = PACKAGE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY___IS_TEMPLATE = PACKAGE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY___PARAMETERABLE_ELEMENTS = PACKAGE___PARAMETERABLE_ELEMENTS;

	/**
	 * The number of operations of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_OPERATION_COUNT = PACKAGE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__EXTENSION = OCL_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__IS_REQUIRED = OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__ARGUMENT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Called Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__CALLED_OPERATION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sent Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__SENT_SIGNAL = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP__TARGET = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Message Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP___ALL_OWNED_ELEMENTS = OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP___GET_VALUE__TYPE_STRING = OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate One Call Or One Send</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP___VALIDATE_ONE_CALL_OR_ONE_SEND__DIAGNOSTICCHAIN_MAP = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Target Is Not ACollection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP___VALIDATE_TARGET_IS_NOT_ACOLLECTION__DIAGNOSTICCHAIN_MAP = OCL_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Message Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__EXTENSION = TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_ANNOTATION = TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_COMMENT = TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__IS_STATIC = TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_TEMPLATE_SIGNATURE = TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__TEMPLATE_BINDING = TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__UNSPECIALIZED_ELEMENT = TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNING_TEMPLATE_PARAMETER = TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__TEMPLATE_PARAMETER = TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__EXTENDED_BYS = TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__INSTANCE_CLASS_NAME = TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_ATTRIBUTE = TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_INVARIANT = TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__OWNED_OPERATION = TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__PACKAGE = TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__SUPER_CLASS = TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REFERRED_OPERATION = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REFERRED_SIGNAL = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Message Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___ALL_OWNED_ELEMENTS = TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___GET_VALUE__TYPE_STRING = TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___IS_TEMPLATE = TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___PARAMETERABLE_ELEMENTS = TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___IS_TEMPLATE_PARAMETER = TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Message Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__EXTENSION = CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__UNSPECIALIZED_ELEMENT = CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__EXTENDED_BYS = CLASS__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__OWNED_INVARIANT = CLASS__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__IS_ACTIVE = CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__NESTED_TYPE = CLASS__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__OWNED_BEHAVIOR = CLASS__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Instance Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__INSTANCE_TYPE = CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS_FEATURE_COUNT = CLASS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS___ALL_OWNED_ELEMENTS = CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS___GET_VALUE__TYPE_STRING = CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE = CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>More Pivotable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORE_PIVOTABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>More Pivotable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORE_PIVOTABLE_OPERATION_COUNT = 0;

	/**
	 * The number of structural features of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__EXTENSION = PRIMITIVE_LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__OWNED_COMMENT = PRIMITIVE_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__IS_STATIC = PRIMITIVE_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__IS_REQUIRED = PRIMITIVE_LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The number of structural features of the '<em>Null Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP___ALL_OWNED_ELEMENTS = PRIMITIVE_LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP___GET_VALUE__TYPE_STRING = PRIMITIVE_LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Null Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_OPERATION_COUNT = PRIMITIVE_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__EXTENSION = FEATURE_CALL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OWNED_ANNOTATION = FEATURE_CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OWNED_COMMENT = FEATURE_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__IS_STATIC = FEATURE_CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__NAME = FEATURE_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__IS_REQUIRED = FEATURE_CALL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__TYPE = FEATURE_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__IMPLICIT = FEATURE_CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__IS_PRE = FEATURE_CALL_EXP__IS_PRE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__ARGUMENT = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__REFERRED_OPERATION = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP___ALL_OWNED_ELEMENTS = FEATURE_CALL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP___GET_VALUE__TYPE_STRING = FEATURE_CALL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Referred Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP___GET_REFERRED_ELEMENT = FEATURE_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Argument Count</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP___VALIDATE_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP = FEATURE_CALL_EXP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Argument Type Is Conformant</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP___VALIDATE_ARGUMENT_TYPE_IS_CONFORMANT__DIAGNOSTICCHAIN_MAP = FEATURE_CALL_EXP_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_OPERATION_COUNT = FEATURE_CALL_EXP_OPERATION_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__DEFAULT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__OWNED_DEFAULT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Parametered Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parametered Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__PARAMETERED_ELEMENT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER__SIGNATURE = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__EXTENSION = TEMPLATE_PARAMETER__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__OWNED_ANNOTATION = TEMPLATE_PARAMETER__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__OWNED_COMMENT = TEMPLATE_PARAMETER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__DEFAULT = TEMPLATE_PARAMETER__DEFAULT;

	/**
	 * The feature id for the '<em><b>Owned Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__OWNED_DEFAULT = TEMPLATE_PARAMETER__OWNED_DEFAULT;

	/**
	 * The feature id for the '<em><b>Owned Parametered Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT = TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Parametered Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT = TEMPLATE_PARAMETER__PARAMETERED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER__SIGNATURE = TEMPLATE_PARAMETER__SIGNATURE;

	/**
	 * The number of structural features of the '<em>Operation Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER_FEATURE_COUNT = TEMPLATE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER___ALL_OWNED_ELEMENTS = TEMPLATE_PARAMETER___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER___GET_VALUE__TYPE_STRING = TEMPLATE_PARAMETER___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Operation Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_TEMPLATE_PARAMETER_OPERATION_COUNT = TEMPLATE_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OppositePropertyCallExpImpl <em>Opposite Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.OppositePropertyCallExpImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOppositePropertyCallExp()
	 * @generated
	 */
	int OPPOSITE_PROPERTY_CALL_EXP = 63;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__EXTENSION = NAVIGATION_CALL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__OWNED_ANNOTATION = NAVIGATION_CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__OWNED_COMMENT = NAVIGATION_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__IS_STATIC = NAVIGATION_CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__NAME = NAVIGATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__IS_REQUIRED = NAVIGATION_CALL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__TYPE = NAVIGATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__IMPLICIT = NAVIGATION_CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__IS_PRE = NAVIGATION_CALL_EXP__IS_PRE;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP__REFERRED_PROPERTY = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Opposite Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP___ALL_OWNED_ELEMENTS = NAVIGATION_CALL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP___GET_VALUE__TYPE_STRING = NAVIGATION_CALL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Opposite Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CALL_EXP_OPERATION_COUNT = NAVIGATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__EXTENSION = COLLECTION_TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_ANNOTATION = COLLECTION_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IS_STATIC = COLLECTION_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__UNSPECIALIZED_ELEMENT = COLLECTION_TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__EXTENDED_BYS = COLLECTION_TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_INVARIANT = COLLECTION_TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__SUPER_CLASS = COLLECTION_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IS_ACTIVE = COLLECTION_TYPE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IS_INTERFACE = COLLECTION_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__NESTED_TYPE = COLLECTION_TYPE__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OWNED_BEHAVIOR = COLLECTION_TYPE__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__BEHAVIORAL_TYPE = COLLECTION_TYPE__BEHAVIORAL_TYPE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__IS_SERIALIZABLE = COLLECTION_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__LOWER = COLLECTION_TYPE__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__UPPER = COLLECTION_TYPE__UPPER;

	/**
	 * The number of structural features of the '<em>Ordered Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___ALL_OWNED_ELEMENTS = COLLECTION_TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___GET_VALUE__TYPE_STRING = COLLECTION_TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___IS_TEMPLATE = COLLECTION_TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___PARAMETERABLE_ELEMENTS = COLLECTION_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = COLLECTION_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___IS_TEMPLATE_PARAMETER = COLLECTION_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = COLLECTION_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = COLLECTION_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Ordered Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameterable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT___IS_TEMPLATE_PARAMETER = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parameterable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__EXTENSION = PARAMETERABLE_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__OWNED_ANNOTATION = PARAMETERABLE_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__OWNED_COMMENT = PARAMETERABLE_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER = PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__TEMPLATE_PARAMETER = PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER;

	/**
	 * The number of structural features of the '<em>Packageable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT_FEATURE_COUNT = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT___ALL_OWNED_ELEMENTS = PARAMETERABLE_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT___GET_VALUE__TYPE_STRING = PARAMETERABLE_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = PARAMETERABLE_ELEMENT___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT___IS_TEMPLATE_PARAMETER = PARAMETERABLE_ELEMENT___IS_TEMPLATE_PARAMETER;

	/**
	 * The number of operations of the '<em>Packageable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT_OPERATION_COUNT = PARAMETERABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__EXTENSION = TYPED_MULTIPLICITY_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OWNED_ANNOTATION = TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OWNED_COMMENT = TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IS_STATIC = TYPED_MULTIPLICITY_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = TYPED_MULTIPLICITY_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IS_REQUIRED = TYPED_MULTIPLICITY_ELEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = TYPED_MULTIPLICITY_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OPERATION = TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = TYPED_MULTIPLICITY_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___ALL_OWNED_ELEMENTS = TYPED_MULTIPLICITY_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___GET_VALUE__TYPE_STRING = TYPED_MULTIPLICITY_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___COMPATIBLE_BODY__VALUESPECIFICATION = TYPED_MULTIPLICITY_ELEMENT___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Make Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___MAKE_PARAMETER = TYPED_MULTIPLICITY_ELEMENT___MAKE_PARAMETER;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = TYPED_MULTIPLICITY_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pivotable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIVOTABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Pivotable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIVOTABLE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Associativity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__ASSOCIATIVITY = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__ORDER = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Precedence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Precedence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__EXTENSION = DATA_TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_ANNOTATION = DATA_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_COMMENT = DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_STATIC = DATA_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_TEMPLATE_SIGNATURE = DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__TEMPLATE_BINDING = DATA_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__UNSPECIALIZED_ELEMENT = DATA_TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNING_TEMPLATE_PARAMETER = DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__TEMPLATE_PARAMETER = DATA_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__EXTENDED_BYS = DATA_TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__INSTANCE_CLASS_NAME = DATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_ATTRIBUTE = DATA_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_INVARIANT = DATA_TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_OPERATION = DATA_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__PACKAGE = DATA_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__SUPER_CLASS = DATA_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_RULE = DATA_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_ABSTRACT = DATA_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_ACTIVE = DATA_TYPE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_INTERFACE = DATA_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NESTED_TYPE = DATA_TYPE__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__OWNED_BEHAVIOR = DATA_TYPE__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__BEHAVIORAL_TYPE = DATA_TYPE__BEHAVIORAL_TYPE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__IS_SERIALIZABLE = DATA_TYPE__IS_SERIALIZABLE;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___ALL_OWNED_ELEMENTS = DATA_TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___GET_VALUE__TYPE_STRING = DATA_TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_TEMPLATE = DATA_TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___PARAMETERABLE_ELEMENTS = DATA_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = DATA_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___IS_TEMPLATE_PARAMETER = DATA_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = DATA_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = DATA_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__EXTENSION = PACKAGE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__OWNED_ANNOTATION = PACKAGE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__OWNED_COMMENT = PACKAGE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__IS_STATIC = PACKAGE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__NAME = PACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__OWNED_RULE = PACKAGE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__OWNED_TEMPLATE_SIGNATURE = PACKAGE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__TEMPLATE_BINDING = PACKAGE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__UNSPECIALIZED_ELEMENT = PACKAGE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Imported Package</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__IMPORTED_PACKAGE = PACKAGE__IMPORTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__NESTED_PACKAGE = PACKAGE__NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__NESTING_PACKAGE = PACKAGE__NESTING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__NS_PREFIX = PACKAGE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__NS_URI = PACKAGE__NS_URI;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__OWNED_TYPE = PACKAGE__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Profile Application</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__PROFILE_APPLICATION = PACKAGE__PROFILE_APPLICATION;

	/**
	 * The feature id for the '<em><b>Application</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__APPLICATION = PACKAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FEATURE_COUNT = PACKAGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE___ALL_OWNED_ELEMENTS = PACKAGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE___GET_VALUE__TYPE_STRING = PACKAGE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE___IS_TEMPLATE = PACKAGE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE___PARAMETERABLE_ELEMENTS = PACKAGE___PARAMETERABLE_ELEMENTS;

	/**
	 * The number of operations of the '<em>Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_OPERATION_COUNT = PACKAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ProfileApplicationImpl <em>Profile Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.ProfileApplicationImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getProfileApplication()
	 * @generated
	 */
	int PROFILE_APPLICATION = 74;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_APPLICATION__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_APPLICATION__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_APPLICATION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Applied Profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_APPLICATION__APPLIED_PROFILE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Applying Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_APPLICATION__APPLYING_PACKAGE = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_APPLICATION__IS_STRICT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Profile Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_APPLICATION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_APPLICATION___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_APPLICATION___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Profile Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_APPLICATION_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__EXTENSION = FEATURE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OWNED_ANNOTATION = FEATURE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OWNED_COMMENT = FEATURE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_STATIC = FEATURE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_REQUIRED = FEATURE__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = FEATURE__TYPE;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IMPLEMENTATION = FEATURE__IMPLEMENTATION;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IMPLEMENTATION_CLASS = FEATURE__IMPLEMENTATION_CLASS;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OWNING_TEMPLATE_PARAMETER = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TEMPLATE_PARAMETER = FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Association Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ASSOCIATION_CLASS = FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__CLASS = FEATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DEFAULT = FEATURE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Default Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DEFAULT_EXPRESSION = FEATURE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IMPLICIT = FEATURE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Is Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_COMPOSITE = FEATURE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_DERIVED = FEATURE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Is ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_ID = FEATURE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Is Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_READ_ONLY = FEATURE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Is Resolve Proxies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_RESOLVE_PROXIES = FEATURE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Is Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_TRANSIENT = FEATURE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Is Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_UNSETTABLE = FEATURE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Is Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_VOLATILE = FEATURE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__KEYS = FEATURE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OPPOSITE = FEATURE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Owning Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OWNING_TYPE = FEATURE_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Redefined Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__REDEFINED_PROPERTY = FEATURE_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__REFERRED_PROPERTY = FEATURE_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Subsetted Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__SUBSETTED_PROPERTY = FEATURE_FEATURE_COUNT + 20;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 21;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___ALL_OWNED_ELEMENTS = FEATURE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___GET_VALUE__TYPE_STRING = FEATURE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___COMPATIBLE_BODY__VALUESPECIFICATION = FEATURE___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Make Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___MAKE_PARAMETER = FEATURE___MAKE_PARAMETER;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = FEATURE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___IS_TEMPLATE_PARAMETER = FEATURE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Compatible Default Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___VALIDATE_COMPATIBLE_DEFAULT_EXPRESSION__DIAGNOSTICCHAIN_MAP = FEATURE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___IS_ATTRIBUTE__PROPERTY = FEATURE_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = FEATURE_OPERATION_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__EXTENSION = NAVIGATION_CALL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__OWNED_ANNOTATION = NAVIGATION_CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__OWNED_COMMENT = NAVIGATION_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__IS_STATIC = NAVIGATION_CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__NAME = NAVIGATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__IS_REQUIRED = NAVIGATION_CALL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__TYPE = NAVIGATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__IMPLICIT = NAVIGATION_CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__IS_PRE = NAVIGATION_CALL_EXP__IS_PRE;

	/**
	 * The feature id for the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__REFERRED_PROPERTY = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP___ALL_OWNED_ELEMENTS = NAVIGATION_CALL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP___GET_VALUE__TYPE_STRING = NAVIGATION_CALL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Referred Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP___GET_REFERRED_ELEMENT = NAVIGATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Compatible Result Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP___VALIDATE_COMPATIBLE_RESULT_TYPE__DIAGNOSTICCHAIN_MAP = NAVIGATION_CALL_EXP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Non Static Source Type Is Conformant</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP___VALIDATE_NON_STATIC_SOURCE_TYPE_IS_CONFORMANT__DIAGNOSTICCHAIN_MAP = NAVIGATION_CALL_EXP_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Specialized Referred Property Owning Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP___GET_SPECIALIZED_REFERRED_PROPERTY_OWNING_TYPE = NAVIGATION_CALL_EXP_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Specialized Referred Property Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP___GET_SPECIALIZED_REFERRED_PROPERTY_TYPE = NAVIGATION_CALL_EXP_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP_OPERATION_COUNT = NAVIGATION_CALL_EXP_OPERATION_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__EXTENSION = VERTEX__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__OWNED_ANNOTATION = VERTEX__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__OWNED_COMMENT = VERTEX__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__IS_STATIC = VERTEX__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__NAME = VERTEX__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__CONTAINER = VERTEX__CONTAINER;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__INCOMING = VERTEX__INCOMING;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__OUTGOING = VERTEX__OUTGOING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__KIND = VERTEX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__STATE = VERTEX_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__STATE_MACHINE = VERTEX_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Pseudostate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE_FEATURE_COUNT = VERTEX_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE___ALL_OWNED_ELEMENTS = VERTEX___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE___GET_VALUE__TYPE_STRING = VERTEX___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Pseudostate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE_OPERATION_COUNT = VERTEX_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__EXTENSION = NUMERIC_LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__OWNED_ANNOTATION = NUMERIC_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__OWNED_COMMENT = NUMERIC_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__IS_STATIC = NUMERIC_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__IS_REQUIRED = NUMERIC_LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__TYPE = NUMERIC_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Real Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__REAL_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP___ALL_OWNED_ELEMENTS = NUMERIC_LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP___GET_VALUE__TYPE_STRING = NUMERIC_LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Real Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_OPERATION_COUNT = NUMERIC_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Referring Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRING_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Referred Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRING_ELEMENT___GET_REFERRED_ELEMENT = 0;

	/**
	 * The number of operations of the '<em>Referring Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRING_ELEMENT_OPERATION_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__EXTENSION = NAMESPACE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_ANNOTATION = NAMESPACE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_COMMENT = NAMESPACE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__IS_STATIC = NAMESPACE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__NAME = NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_RULE = NAMESPACE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Extended Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__EXTENDED_REGION = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__STATE = NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__STATE_MACHINE = NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Subvertex</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__SUBVERTEX = NAMESPACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__TRANSITION = NAMESPACE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___ALL_OWNED_ELEMENTS = NAMESPACE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___GET_VALUE__TYPE_STRING = NAMESPACE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_OPERATION_COUNT = NAMESPACE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__EXTENSION = NAMESPACE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__OWNED_ANNOTATION = NAMESPACE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__OWNED_COMMENT = NAMESPACE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__IS_STATIC = NAMESPACE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__NAME = NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__OWNED_RULE = NAMESPACE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__EXTERNAL_URI = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__IMPORTS = NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__NESTED_PACKAGE = NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT___ALL_OWNED_ELEMENTS = NAMESPACE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT___GET_VALUE__TYPE_STRING = NAMESPACE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OPERATION_COUNT = NAMESPACE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__EXTENSION = CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__UNSPECIALIZED_ELEMENT = CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__EXTENDED_BYS = CLASS__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__OWNED_INVARIANT = CLASS__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__IS_ACTIVE = CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__NESTED_TYPE = CLASS__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__OWNED_BEHAVIOR = CLASS__OWNED_BEHAVIOR;

	/**
	 * The number of structural features of the '<em>Self Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE___ALL_OWNED_ELEMENTS = CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE___GET_VALUE__TYPE_STRING = CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE_1 = CLASS_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Self Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION__SIGNAL = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Send Signal Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Send Signal Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_ACTION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__EXTENSION = COLLECTION_TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_ANNOTATION = COLLECTION_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IS_STATIC = COLLECTION_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__UNSPECIALIZED_ELEMENT = COLLECTION_TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__EXTENDED_BYS = COLLECTION_TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_INVARIANT = COLLECTION_TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__SUPER_CLASS = COLLECTION_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IS_ACTIVE = COLLECTION_TYPE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IS_INTERFACE = COLLECTION_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__NESTED_TYPE = COLLECTION_TYPE__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OWNED_BEHAVIOR = COLLECTION_TYPE__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__BEHAVIORAL_TYPE = COLLECTION_TYPE__BEHAVIORAL_TYPE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__IS_SERIALIZABLE = COLLECTION_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__LOWER = COLLECTION_TYPE__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__UPPER = COLLECTION_TYPE__UPPER;

	/**
	 * The number of structural features of the '<em>Sequence Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___ALL_OWNED_ELEMENTS = COLLECTION_TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___GET_VALUE__TYPE_STRING = COLLECTION_TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___IS_TEMPLATE = COLLECTION_TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___PARAMETERABLE_ELEMENTS = COLLECTION_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = COLLECTION_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___IS_TEMPLATE_PARAMETER = COLLECTION_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = COLLECTION_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = COLLECTION_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Sequence Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__EXTENSION = COLLECTION_TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_ANNOTATION = COLLECTION_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_COMMENT = COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IS_STATIC = COLLECTION_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_TEMPLATE_SIGNATURE = COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__TEMPLATE_BINDING = COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__UNSPECIALIZED_ELEMENT = COLLECTION_TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNING_TEMPLATE_PARAMETER = COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__TEMPLATE_PARAMETER = COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__EXTENDED_BYS = COLLECTION_TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_ATTRIBUTE = COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_INVARIANT = COLLECTION_TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_OPERATION = COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__PACKAGE = COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__SUPER_CLASS = COLLECTION_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_RULE = COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IS_ABSTRACT = COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IS_ACTIVE = COLLECTION_TYPE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IS_INTERFACE = COLLECTION_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__NESTED_TYPE = COLLECTION_TYPE__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OWNED_BEHAVIOR = COLLECTION_TYPE__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__BEHAVIORAL_TYPE = COLLECTION_TYPE__BEHAVIORAL_TYPE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__IS_SERIALIZABLE = COLLECTION_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__LOWER = COLLECTION_TYPE__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__UPPER = COLLECTION_TYPE__UPPER;

	/**
	 * The number of structural features of the '<em>Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___ALL_OWNED_ELEMENTS = COLLECTION_TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___GET_VALUE__TYPE_STRING = COLLECTION_TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___IS_TEMPLATE = COLLECTION_TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___PARAMETERABLE_ELEMENTS = COLLECTION_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = COLLECTION_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___IS_TEMPLATE_PARAMETER = COLLECTION_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = COLLECTION_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = COLLECTION_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__EXTENSION = OCL_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__IS_REQUIRED = OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Referred State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP__REFERRED_STATE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP___ALL_OWNED_ELEMENTS = OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP___GET_VALUE__TYPE_STRING = OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>State Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StateMachineImpl <em>State Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.StateMachineImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStateMachine()
	 * @generated
	 */
	int STATE_MACHINE = 89;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__EXTENSION = BEHAVIOR__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__OWNED_ANNOTATION = BEHAVIOR__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__OWNED_COMMENT = BEHAVIOR__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__IS_STATIC = BEHAVIOR__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__NAME = BEHAVIOR__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__OWNED_TEMPLATE_SIGNATURE = BEHAVIOR__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__TEMPLATE_BINDING = BEHAVIOR__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__UNSPECIALIZED_ELEMENT = BEHAVIOR__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__OWNING_TEMPLATE_PARAMETER = BEHAVIOR__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__TEMPLATE_PARAMETER = BEHAVIOR__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__EXTENDED_BYS = BEHAVIOR__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__INSTANCE_CLASS_NAME = BEHAVIOR__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__OWNED_ATTRIBUTE = BEHAVIOR__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__OWNED_INVARIANT = BEHAVIOR__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__OWNED_OPERATION = BEHAVIOR__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__PACKAGE = BEHAVIOR__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__SUPER_CLASS = BEHAVIOR__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__OWNED_RULE = BEHAVIOR__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__IS_ABSTRACT = BEHAVIOR__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__IS_ACTIVE = BEHAVIOR__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__IS_INTERFACE = BEHAVIOR__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__NESTED_TYPE = BEHAVIOR__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__OWNED_BEHAVIOR = BEHAVIOR__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__TRANSITION = BEHAVIOR__TRANSITION;

	/**
	 * The feature id for the '<em><b>Connection Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__CONNECTION_POINT = BEHAVIOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extended State Machine</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__EXTENDED_STATE_MACHINE = BEHAVIOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__REGION = BEHAVIOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Submachine State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__SUBMACHINE_STATE = BEHAVIOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE___ALL_OWNED_ELEMENTS = BEHAVIOR___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE___GET_VALUE__TYPE_STRING = BEHAVIOR___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE___IS_TEMPLATE = BEHAVIOR___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE___PARAMETERABLE_ELEMENTS = BEHAVIOR___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = BEHAVIOR___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE___IS_TEMPLATE_PARAMETER = BEHAVIOR___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = BEHAVIOR___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = BEHAVIOR___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_OPERATION_COUNT = BEHAVIOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StereotypeImpl <em>Stereotype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.StereotypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStereotype()
	 * @generated
	 */
	int STEREOTYPE = 90;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__EXTENSION = CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__UNSPECIALIZED_ELEMENT = CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__EXTENDED_BYS = CLASS__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__OWNED_INVARIANT = CLASS__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__IS_ACTIVE = CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__NESTED_TYPE = CLASS__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__OWNED_BEHAVIOR = CLASS__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Extension Ofs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__EXTENSION_OFS = CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stereotype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE___ALL_OWNED_ELEMENTS = CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE___GET_VALUE__TYPE_STRING = CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Stereotype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__EXTENSION = PRIMITIVE_LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__OWNED_COMMENT = PRIMITIVE_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__IS_STATIC = PRIMITIVE_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__NAME = PRIMITIVE_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__IS_REQUIRED = PRIMITIVE_LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__TYPE = PRIMITIVE_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>String Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__STRING_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP___ALL_OWNED_ELEMENTS = PRIMITIVE_LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP___GET_VALUE__TYPE_STRING = PRIMITIVE_LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>String Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_OPERATION_COUNT = PRIMITIVE_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Bound Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__BOUND_ELEMENT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__PARAMETER_SUBSTITUTION = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING__SIGNATURE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Template Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Template Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Formal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Actual</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Template Parameter Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Template Parameter Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__EXTENSION = TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_ANNOTATION = TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_COMMENT = TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__IS_STATIC = TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_TEMPLATE_SIGNATURE = TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__TEMPLATE_BINDING = TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__UNSPECIALIZED_ELEMENT = TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNING_TEMPLATE_PARAMETER = TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__TEMPLATE_PARAMETER = TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__EXTENDED_BYS = TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__INSTANCE_CLASS_NAME = TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_ATTRIBUTE = TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_INVARIANT = TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION = TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__PACKAGE = TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__SUPER_CLASS = TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__SPECIFICATION = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___ALL_OWNED_ELEMENTS = TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___GET_VALUE__TYPE_STRING = TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___IS_TEMPLATE = TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___PARAMETERABLE_ELEMENTS = TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___IS_TEMPLATE_PARAMETER = TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Template Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE__OWNED_PARAMETER = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE__TEMPLATE = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Template Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT__TEMPLATE_BINDING = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT__UNSPECIALIZED_ELEMENT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Templateable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT___IS_TEMPLATE = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT___PARAMETERABLE_ELEMENTS = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Templateable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TransitionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 98;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EXTENSION = NAMESPACE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__OWNED_ANNOTATION = NAMESPACE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__OWNED_COMMENT = NAMESPACE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__IS_STATIC = NAMESPACE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__OWNED_RULE = NAMESPACE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__CONTAINER = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EFFECT = NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GUARD = NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__KIND = NAMESPACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = NAMESPACE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = NAMESPACE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TRIGGER = NAMESPACE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION___ALL_OWNED_ELEMENTS = NAMESPACE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION___GET_VALUE__TYPE_STRING = NAMESPACE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = NAMESPACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TriggerImpl <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TriggerImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTrigger()
	 * @generated
	 */
	int TRIGGER = 99;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__EXTENSION = NAMED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__OWNED_ANNOTATION = NAMED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__OWNED_COMMENT = NAMED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__STATE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__TRANSITION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER___ALL_OWNED_ELEMENTS = NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER___GET_VALUE__TYPE_STRING = NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__EXTENSION = LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__OWNED_ANNOTATION = LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__OWNED_COMMENT = LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__IS_STATIC = LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__IS_REQUIRED = LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP___ALL_OWNED_ELEMENTS = LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP___GET_VALUE__TYPE_STRING = LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Tuple Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__EXTENSION = TYPED_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__OWNED_ANNOTATION = TYPED_ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__OWNED_COMMENT = TYPED_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__IS_STATIC = TYPED_ELEMENT__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__IS_REQUIRED = TYPED_ELEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION___ALL_OWNED_ELEMENTS = TYPED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION___GET_VALUE__TYPE_STRING = TYPED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__EXTENSION = VARIABLE_DECLARATION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__OWNED_ANNOTATION = VARIABLE_DECLARATION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__OWNED_COMMENT = VARIABLE_DECLARATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__IS_STATIC = VARIABLE_DECLARATION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__NAME = VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__IS_REQUIRED = VARIABLE_DECLARATION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__TYPE = VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART__INIT_EXPRESSION = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART___ALL_OWNED_ELEMENTS = VARIABLE_DECLARATION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART___GET_VALUE__TYPE_STRING = VARIABLE_DECLARATION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Tuple Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_OPERATION_COUNT = VARIABLE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EXTENSION = DATA_TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_ANNOTATION = DATA_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_COMMENT = DATA_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IS_STATIC = DATA_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_TEMPLATE_SIGNATURE = DATA_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__TEMPLATE_BINDING = DATA_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__UNSPECIALIZED_ELEMENT = DATA_TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNING_TEMPLATE_PARAMETER = DATA_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__TEMPLATE_PARAMETER = DATA_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EXTENDED_BYS = DATA_TYPE__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__INSTANCE_CLASS_NAME = DATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_ATTRIBUTE = DATA_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_INVARIANT = DATA_TYPE__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_OPERATION = DATA_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__PACKAGE = DATA_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__SUPER_CLASS = DATA_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_RULE = DATA_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IS_ABSTRACT = DATA_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IS_ACTIVE = DATA_TYPE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IS_INTERFACE = DATA_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__NESTED_TYPE = DATA_TYPE__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OWNED_BEHAVIOR = DATA_TYPE__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__BEHAVIORAL_TYPE = DATA_TYPE__BEHAVIORAL_TYPE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__IS_SERIALIZABLE = DATA_TYPE__IS_SERIALIZABLE;

	/**
	 * The number of structural features of the '<em>Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___ALL_OWNED_ELEMENTS = DATA_TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___GET_VALUE__TYPE_STRING = DATA_TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___IS_TEMPLATE = DATA_TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___PARAMETERABLE_ELEMENTS = DATA_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = DATA_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___IS_TEMPLATE_PARAMETER = DATA_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = DATA_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = DATA_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__EXTENSION = OCL_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__IS_REQUIRED = OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP__REFERRED_TYPE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP___ALL_OWNED_ELEMENTS = OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP___GET_VALUE__TYPE_STRING = OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Referred Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP___GET_REFERRED_ELEMENT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Type Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeExtensionImpl <em>Type Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeExtensionImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypeExtension()
	 * @generated
	 */
	int TYPE_EXTENSION = 105;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXTENSION__EXTENSION = ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXTENSION__OWNED_ANNOTATION = ELEMENT__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXTENSION__OWNED_COMMENT = ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXTENSION__IS_REQUIRED = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXTENSION__STEREOTYPE = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXTENSION__TYPE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXTENSION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXTENSION___ALL_OWNED_ELEMENTS = ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXTENSION___GET_VALUE__TYPE_STRING = ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Type Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXTENSION_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__EXTENSION = TEMPLATE_PARAMETER__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__OWNED_ANNOTATION = TEMPLATE_PARAMETER__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__OWNED_COMMENT = TEMPLATE_PARAMETER__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__DEFAULT = TEMPLATE_PARAMETER__DEFAULT;

	/**
	 * The feature id for the '<em><b>Owned Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__OWNED_DEFAULT = TEMPLATE_PARAMETER__OWNED_DEFAULT;

	/**
	 * The feature id for the '<em><b>Owned Parametered Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT = TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Parametered Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT = TEMPLATE_PARAMETER__PARAMETERED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__SIGNATURE = TEMPLATE_PARAMETER__SIGNATURE;

	/**
	 * The feature id for the '<em><b>Allow Substitutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__ALLOW_SUBSTITUTABLE = TEMPLATE_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraining Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER__CONSTRAINING_TYPE = TEMPLATE_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER_FEATURE_COUNT = TEMPLATE_PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER___ALL_OWNED_ELEMENTS = TEMPLATE_PARAMETER___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER___GET_VALUE__TYPE_STRING = TEMPLATE_PARAMETER___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Type Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEMPLATE_PARAMETER_OPERATION_COUNT = TEMPLATE_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__EXTENSION = NUMERIC_LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__OWNED_ANNOTATION = NUMERIC_LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__OWNED_COMMENT = NUMERIC_LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__IS_STATIC = NUMERIC_LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__NAME = NUMERIC_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__IS_REQUIRED = NUMERIC_LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__TYPE = NUMERIC_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Unlimited Natural Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unlimited Natural Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP___ALL_OWNED_ELEMENTS = NUMERIC_LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP___GET_VALUE__TYPE_STRING = NUMERIC_LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Unlimited Natural Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_OPERATION_COUNT = NUMERIC_LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedTypeImpl <em>Unspecified Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedTypeImpl
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnspecifiedType()
	 * @generated
	 */
	int UNSPECIFIED_TYPE = 110;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__EXTENSION = CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__UNSPECIALIZED_ELEMENT = CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__EXTENDED_BYS = CLASS__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_INVARIANT = CLASS__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__IS_ACTIVE = CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__NESTED_TYPE = CLASS__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__OWNED_BEHAVIOR = CLASS__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__LOWER_BOUND = CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE__UPPER_BOUND = CLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unspecified Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___ALL_OWNED_ELEMENTS = CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___GET_VALUE__TYPE_STRING = CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Unspecified Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_TYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__EXTENSION = OCL_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__IS_REQUIRED = OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The number of structural features of the '<em>Unspecified Value Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP___ALL_OWNED_ELEMENTS = OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP___GET_VALUE__TYPE_STRING = OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Unspecified Value Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__EXTENSION = VARIABLE_DECLARATION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OWNED_ANNOTATION = VARIABLE_DECLARATION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OWNED_COMMENT = VARIABLE_DECLARATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__IS_STATIC = VARIABLE_DECLARATION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__IS_REQUIRED = VARIABLE_DECLARATION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__IMPLICIT = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INIT_EXPRESSION = VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__REPRESENTED_PARAMETER = VARIABLE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___ALL_OWNED_ELEMENTS = VARIABLE_DECLARATION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___GET_VALUE__TYPE_STRING = VARIABLE_DECLARATION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Compatible Initialiser Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP = VARIABLE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = VARIABLE_DECLARATION_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__EXTENSION = OCL_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__OWNED_ANNOTATION = OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__OWNED_COMMENT = OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__IS_STATIC = OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__IS_REQUIRED = OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__IMPLICIT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__REFERRED_VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP___ALL_OWNED_ELEMENTS = OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP___GET_VALUE__TYPE_STRING = OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Referred Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP___GET_REFERRED_ELEMENT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.util.Visitor <em>Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.util.Visitor
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVisitor()
	 * @generated
	 */
	int VISITOR = 118;

	/**
	 * The number of structural features of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITOR_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__EXTENSION = CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_ANNOTATION = CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_COMMENT = CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__IS_STATIC = CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_TEMPLATE_SIGNATURE = CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__TEMPLATE_BINDING = CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__UNSPECIALIZED_ELEMENT = CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNING_TEMPLATE_PARAMETER = CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__TEMPLATE_PARAMETER = CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Extended Bys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__EXTENDED_BYS = CLASS__EXTENDED_BYS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__INSTANCE_CLASS_NAME = CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_ATTRIBUTE = CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_INVARIANT = CLASS__OWNED_INVARIANT;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_OPERATION = CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__SUPER_CLASS = CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_RULE = CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__IS_ABSTRACT = CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__IS_ACTIVE = CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__IS_INTERFACE = CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Nested Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__NESTED_TYPE = CLASS__NESTED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OWNED_BEHAVIOR = CLASS__OWNED_BEHAVIOR;

	/**
	 * The number of structural features of the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_FEATURE_COUNT = CLASS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___ALL_OWNED_ELEMENTS = CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___GET_VALUE__TYPE_STRING = CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_TEMPLATE = CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___PARAMETERABLE_ELEMENTS = CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___IS_TEMPLATE_PARAMETER = CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = CLASS___SPECIALIZE_IN__OCLEXPRESSION_TYPE;

	/**
	 * The number of operations of the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_OPERATION_COUNT = CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.AssociativityKind <em>Associativity Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.AssociativityKind
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociativityKind()
	 * @generated
	 */
	int ASSOCIATIVITY_KIND = 120;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.CollectionKind <em>Collection Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.CollectionKind
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionKind()
	 * @generated
	 */
	int COLLECTION_KIND = 121;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.PseudostateKind <em>Pseudostate Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.PseudostateKind
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPseudostateKind()
	 * @generated
	 */
	int PSEUDOSTATE_KIND = 122;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.pivot.TransitionKind <em>Transition Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.TransitionKind
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTransitionKind()
	 * @generated
	 */
	int TRANSITION_KIND = 123;

	/**
	 * The meta object id for the '<em>Boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBoolean()
	 * @generated
	 */
	int BOOLEAN = 124;

	/**
	 * The meta object id for the '<em>Integer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 125;

	/**
	 * The meta object id for the '<em>Library Feature</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.library.LibraryFeature
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLibraryFeature()
	 * @generated
	 */
	int LIBRARY_FEATURE = 126;

	/**
	 * The meta object id for the '<em>Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 127;

	/**
	 * The meta object id for the '<em>Real</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getReal()
	 * @generated
	 */
	int REAL = 128;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getString()
	 * @generated
	 */
	int STRING = 129;

	/**
	 * The meta object id for the '<em>Throwable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Throwable
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getThrowable()
	 * @generated
	 */
	int THROWABLE = 130;

	/**
	 * The meta object id for the '<em>Unlimited Natural</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnlimitedNatural()
	 * @generated
	 */
	int UNLIMITED_NATURAL = 131;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Annotation#getOwnedContent <em>Owned Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Content</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Annotation#getOwnedContent()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_OwnedContent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Annotation#getOwnedDetail <em>Owned Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Detail</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Annotation#getOwnedDetail()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_OwnedDetail();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Annotation#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reference</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Annotation#getReference()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_Reference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.NamedElement#isStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NamedElement#isStatic()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_IsStatic();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Element#getOwnedComment <em>Owned Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Comment</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Element#getOwnedComment()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_OwnedComment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Element#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Element#getExtension()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Extension();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Element#getOwnedAnnotation <em>Owned Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Annotation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Element#getOwnedAnnotation()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_OwnedAnnotation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Element#allOwnedElements() <em>All Owned Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Owned Elements</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Element#allOwnedElements()
	 * @generated
	 */
	EOperation getElement__AllOwnedElements();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Element#getValue(org.eclipse.ocl.examples.pivot.Type, java.lang.String) <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Element#getValue(org.eclipse.ocl.examples.pivot.Type, java.lang.String)
	 * @generated
	 */
	EOperation getElement__GetValue__Type_String();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ElementExtension <em>Element Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Extension</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ElementExtension
	 * @generated
	 */
	EClass getElementExtension();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.ElementExtension#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Stereotype</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ElementExtension#getStereotype()
	 * @see #getElementExtension()
	 * @generated
	 */
	EReference getElementExtension_Stereotype();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.ElementExtension#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Base</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ElementExtension#getBase()
	 * @see #getElementExtension()
	 * @generated
	 */
	EReference getElementExtension_Base();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.ElementExtension#isApplied <em>Is Applied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Applied</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ElementExtension#isApplied()
	 * @see #getElementExtension()
	 * @generated
	 */
	EAttribute getElementExtension_IsApplied();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.ElementExtension#isRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ElementExtension#isRequired()
	 * @see #getElementExtension()
	 * @generated
	 */
	EAttribute getElementExtension_IsRequired();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.BagType <em>Bag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.BagType
	 * @generated
	 */
	EClass getBagType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Behavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Behavior
	 * @generated
	 */
	EClass getBehavior();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Behavior#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Transition</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Behavior#getTransition()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_Transition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionType
	 * @generated
	 */
	EClass getCollectionType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CollectionType#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionType#getElementType()
	 * @see #getCollectionType()
	 * @generated
	 */
	EReference getCollectionType_ElementType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.CollectionType#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionType#getLower()
	 * @see #getCollectionType()
	 * @generated
	 */
	EAttribute getCollectionType_Lower();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.CollectionType#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionType#getUpper()
	 * @see #getCollectionType()
	 * @generated
	 */
	EAttribute getCollectionType_Upper();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.DataType#isSerializable <em>Is Serializable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Serializable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DataType#isSerializable()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_IsSerializable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.DataType#getBehavioralType <em>Behavioral Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Behavioral Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DataType#getBehavioralType()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_BehavioralType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.BooleanLiteralExp
	 * @generated
	 */
	EClass getBooleanLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Symbol</em>'.
	 * @see org.eclipse.ocl.examples.pivot.BooleanLiteralExp#isBooleanSymbol()
	 * @see #getBooleanLiteralExp()
	 * @generated
	 */
	EAttribute getBooleanLiteralExp_BooleanSymbol();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.BooleanLiteralExp#validateTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.BooleanLiteralExp#validateTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBooleanLiteralExp__ValidateTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp
	 * @generated
	 */
	EClass getPrimitiveLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.LiteralExp <em>Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LiteralExp
	 * @generated
	 */
	EClass getLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CallOperationAction <em>Call Operation Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Operation Action</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CallOperationAction
	 * @generated
	 */
	EClass getCallOperationAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.CallOperationAction#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CallOperationAction#getOperation()
	 * @see #getCallOperationAction()
	 * @generated
	 */
	EReference getCallOperationAction_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CollectionItem <em>Collection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Item</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionItem
	 * @generated
	 */
	EClass getCollectionItem();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.CollectionItem#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Item</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionItem#getItem()
	 * @see #getCollectionItem()
	 * @generated
	 */
	EReference getCollectionItem_Item();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CollectionItem#validateTypeIsItemType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Item Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Item Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CollectionItem#validateTypeIsItemType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionItem__ValidateTypeIsItemType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralPart <em>Collection Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Part</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralPart
	 * @generated
	 */
	EClass getCollectionLiteralPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralExp
	 * @generated
	 */
	EClass getCollectionLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralExp#getKind()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EAttribute getCollectionLiteralExp_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralExp#getPart()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EReference getCollectionLiteralExp_Part();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#validateCollectionKindIsConcrete(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Collection Kind Is Concrete</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Collection Kind Is Concrete</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralExp#validateCollectionKindIsConcrete(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionLiteralExp__ValidateCollectionKindIsConcrete__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#validateSetKindIsSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Set Kind Is Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Set Kind Is Set</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralExp#validateSetKindIsSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionLiteralExp__ValidateSetKindIsSet__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#validateOrderedSetKindIsOrderedSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Ordered Set Kind Is Ordered Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Ordered Set Kind Is Ordered Set</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralExp#validateOrderedSetKindIsOrderedSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionLiteralExp__ValidateOrderedSetKindIsOrderedSet__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#validateSequenceKindIsSequence(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Sequence Kind Is Sequence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Sequence Kind Is Sequence</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralExp#validateSequenceKindIsSequence(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionLiteralExp__ValidateSequenceKindIsSequence__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#validateBagKindIsBag(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Bag Kind Is Bag</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Bag Kind Is Bag</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.CollectionLiteralExp#validateBagKindIsBag(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionLiteralExp__ValidateBagKindIsBag__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CollectionRange <em>Collection Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Range</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionRange
	 * @generated
	 */
	EClass getCollectionRange();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.CollectionRange#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionRange#getFirst()
	 * @see #getCollectionRange()
	 * @generated
	 */
	EReference getCollectionRange_First();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.CollectionRange#getLast <em>Last</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Last</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionRange#getLast()
	 * @see #getCollectionRange()
	 * @generated
	 */
	EReference getCollectionRange_Last();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.EnumLiteralExp <em>Enum Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.EnumLiteralExp
	 * @generated
	 */
	EClass getEnumLiteralExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.EnumLiteralExp#getReferredEnumLiteral <em>Referred Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Enum Literal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.EnumLiteralExp#getReferredEnumLiteral()
	 * @see #getEnumLiteralExp()
	 * @generated
	 */
	EReference getEnumLiteralExp_ReferredEnumLiteral();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.EnumLiteralExp#validateTypeIsEnumerationType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Enumeration Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Enumeration Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.EnumLiteralExp#validateTypeIsEnumerationType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getEnumLiteralExp__ValidateTypeIsEnumerationType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.EnumerationLiteral
	 * @generated
	 */
	EClass getEnumerationLiteral();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.EnumerationLiteral#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Enumeration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.EnumerationLiteral#getEnumeration()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EReference getEnumerationLiteral_Enumeration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.EnumerationLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.pivot.EnumerationLiteral#getValue()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EAttribute getEnumerationLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL <em>Expression In OCL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression In OCL</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ExpressionInOCL
	 * @generated
	 */
	EClass getExpressionInOCL();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL#getBodyExpression <em>Body Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ExpressionInOCL#getBodyExpression()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_BodyExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL#getContextVariable <em>Context Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ExpressionInOCL#getContextVariable()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_ContextVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL#getResultVariable <em>Result Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ExpressionInOCL#getResultVariable()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_ResultVariable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL#getParameterVariable <em>Parameter Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ExpressionInOCL#getParameterVariable()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_ParameterVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Enumeration#getOwnedLiteral <em>Owned Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Literal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Enumeration#getOwnedLiteral()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_OwnedLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Feature#getImplementationClass <em>Implementation Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Feature#getImplementationClass()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_ImplementationClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Feature#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Feature#getImplementation()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Implementation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.OpaqueExpression <em>Opaque Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OpaqueExpression
	 * @generated
	 */
	EClass getOpaqueExpression();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Body</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OpaqueExpression#getBody()
	 * @see #getOpaqueExpression()
	 * @generated
	 */
	EAttribute getOpaqueExpression_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getExpressionInOCL <em>Expression In OCL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression In OCL</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OpaqueExpression#getExpressionInOCL()
	 * @see #getOpaqueExpression()
	 * @generated
	 */
	EReference getOpaqueExpression_ExpressionInOCL();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Language</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OpaqueExpression#getLanguage()
	 * @see #getOpaqueExpression()
	 * @generated
	 */
	EAttribute getOpaqueExpression_Language();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.Variable#getInitExpression <em>Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Variable#getInitExpression()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_InitExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Variable#getRepresentedParameter <em>Represented Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Represented Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Variable#getRepresentedParameter()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_RepresentedParameter();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Variable#validateCompatibleInitialiserType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Initialiser Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Initialiser Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Variable#validateCompatibleInitialiserType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVariable__ValidateCompatibleInitialiserType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Variable#isImplicit <em>Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implicit</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Variable#isImplicit()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Implicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.IfExp <em>If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IfExp
	 * @generated
	 */
	EClass getIfExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.IfExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IfExp#getCondition()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.IfExp#getThenExpression <em>Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IfExp#getThenExpression()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_ThenExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.IfExp#getElseExpression <em>Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IfExp#getElseExpression()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_ElseExpression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IfExp#validateConditionTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Condition Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Condition Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IfExp#validateConditionTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIfExp__ValidateConditionTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Import#getImportedNamespace <em>Imported Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported Namespace</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Import#getImportedNamespace()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_ImportedNamespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IntegerLiteralExp
	 * @generated
	 */
	EClass getIntegerLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.IntegerLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Symbol</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IntegerLiteralExp#getIntegerSymbol()
	 * @see #getIntegerLiteralExp()
	 * @generated
	 */
	EAttribute getIntegerLiteralExp_IntegerSymbol();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IntegerLiteralExp#validateTypeIsInteger(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Integer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Integer</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IntegerLiteralExp#validateTypeIsInteger(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIntegerLiteralExp__ValidateTypeIsInteger__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NumericLiteralExp
	 * @generated
	 */
	EClass getNumericLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.OCLExpression <em>OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OCLExpression
	 * @generated
	 */
	EClass getOCLExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.InvalidLiteralExp
	 * @generated
	 */
	EClass getInvalidLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.InvalidType <em>Invalid Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.InvalidType
	 * @generated
	 */
	EClass getInvalidType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.IterateExp <em>Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IterateExp
	 * @generated
	 */
	EClass getIterateExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.IterateExp#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IterateExp#getResult()
	 * @see #getIterateExp()
	 * @generated
	 */
	EReference getIterateExp_Result();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IterateExp#validateTypeIsResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Result Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Result Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IterateExp#validateTypeIsResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIterateExp__ValidateTypeIsResultType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IterateExp#validateBodyTypeConformsToResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Body Type Conforms To Result Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Body Type Conforms To Result Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IterateExp#validateBodyTypeConformsToResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIterateExp__ValidateBodyTypeConformsToResultType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IterateExp#validateOneInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate One Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate One Initializer</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IterateExp#validateOneInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIterateExp__ValidateOneInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Iteration
	 * @generated
	 */
	EClass getIteration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Iteration#getOwnedIterator <em>Owned Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Iterator</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Iteration#getOwnedIterator()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_OwnedIterator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Iteration#getOwnedAccumulator <em>Owned Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Accumulator</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Iteration#getOwnedAccumulator()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_OwnedAccumulator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.IteratorExp <em>Iterator Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp
	 * @generated
	 */
	EClass getIteratorExp();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateClosureBodyTypeIsConformanttoIteratorType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Body Type Is Conformantto Iterator Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Body Type Is Conformantto Iterator Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateClosureBodyTypeIsConformanttoIteratorType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureBodyTypeIsConformanttoIteratorType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateSortedByIteratorTypeIsComparable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Sorted By Iterator Type Is Comparable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Sorted By Iterator Type Is Comparable</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateSortedByIteratorTypeIsComparable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateSortedByIteratorTypeIsComparable__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateAnyHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Any Has One Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Any Has One Iterator</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateAnyHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateAnyHasOneIterator__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateAnyTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Any Type Is Source Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Any Type Is Source Element Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateAnyTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateAnyTypeIsSourceElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateAnyBodyTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Any Body Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Any Body Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateAnyBodyTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateAnyBodyTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateClosureHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Has One Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Has One Iterator</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateClosureHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureHasOneIterator__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateClosureTypeIsUniqueCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Type Is Unique Collection</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Type Is Unique Collection</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateClosureTypeIsUniqueCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureTypeIsUniqueCollection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateClosureSourceElementTypeIsBodyElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Source Element Type Is Body Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Source Element Type Is Body Element Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateClosureSourceElementTypeIsBodyElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureSourceElementTypeIsBodyElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateClosureElementTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Element Type Is Source Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Element Type Is Source Element Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateClosureElementTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureElementTypeIsSourceElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Collect Has One Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Collect Has One Iterator</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateCollectHasOneIterator__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectTypeIsUnordered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Collect Type Is Unordered</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Collect Type Is Unordered</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectTypeIsUnordered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateCollectTypeIsUnordered__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectElementTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Collect Element Type Is Source Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Collect Element Type Is Source Element Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectElementTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateCollectElementTypeIsSourceElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectNestedHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Collect Nested Has One Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Collect Nested Has One Iterator</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectNestedHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateCollectNestedHasOneIterator__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectNestedTypeIsBag(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Collect Nested Type Is Bag</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Collect Nested Type Is Bag</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectNestedTypeIsBag(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateCollectNestedTypeIsBag__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectNestedTypeIsBodyType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Collect Nested Type Is Body Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Collect Nested Type Is Body Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateCollectNestedTypeIsBodyType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateCollectNestedTypeIsBodyType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateExistsTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Exists Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Exists Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateExistsTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateExistsTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateExistsBodyTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Exists Body Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Exists Body Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateExistsBodyTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateExistsBodyTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateForAllTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate For All Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate For All Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateForAllTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateForAllTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateForAllBodyTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate For All Body Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate For All Body Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateForAllBodyTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateForAllBodyTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateIsUniqueHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Is Unique Has One Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Is Unique Has One Iterator</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateIsUniqueHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateIsUniqueHasOneIterator__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateIsUniqueTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Is Unique Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Is Unique Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateIsUniqueTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateIsUniqueTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateOneHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate One Has One Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate One Has One Iterator</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateOneHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateOneHasOneIterator__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateOneTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate One Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate One Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateOneTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateOneTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateOneBodyTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate One Body Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate One Body Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateOneBodyTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateOneBodyTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateRejectOrSelectHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Reject Or Select Has One Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Reject Or Select Has One Iterator</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateRejectOrSelectHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateRejectOrSelectHasOneIterator__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateRejectOrSelectTypeIsSourceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Reject Or Select Type Is Source Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Reject Or Select Type Is Source Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateRejectOrSelectTypeIsSourceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateRejectOrSelectTypeIsSourceType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateRejectOrSelectTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Reject Or Select Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Reject Or Select Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateRejectOrSelectTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateRejectOrSelectTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateSortedByHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Sorted By Has One Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Sorted By Has One Iterator</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateSortedByHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateSortedByHasOneIterator__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateSortedByIsOrderedIfSourceIsOrdered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Sorted By Is Ordered If Source Is Ordered</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Sorted By Is Ordered If Source Is Ordered</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateSortedByIsOrderedIfSourceIsOrdered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateSortedByIsOrderedIfSourceIsOrdered__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateSortedByElementTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Sorted By Element Type Is Source Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Sorted By Element Type Is Source Element Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateSortedByElementTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateSortedByElementTypeIsSourceElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.IteratorExp#validateIteratorTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Iterator Type Is Source Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Iterator Type Is Source Element Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.IteratorExp#validateIteratorTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateIteratorTypeIsSourceElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.LambdaType <em>Lambda Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lambda Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LambdaType
	 * @generated
	 */
	EClass getLambdaType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.LambdaType#getContextType <em>Context Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LambdaType#getContextType()
	 * @see #getLambdaType()
	 * @generated
	 */
	EReference getLambdaType_ContextType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.LambdaType#getParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LambdaType#getParameterType()
	 * @see #getLambdaType()
	 * @generated
	 */
	EReference getLambdaType_ParameterType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.LambdaType#getResultType <em>Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LambdaType#getResultType()
	 * @see #getLambdaType()
	 * @generated
	 */
	EReference getLambdaType_ResultType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.LetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LetExp
	 * @generated
	 */
	EClass getLetExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.LetExp#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LetExp#getIn()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_In();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.LetExp#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LetExp#getVariable()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_Variable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.LetExp#validateTypeIsInType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is In Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is In Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.LetExp#validateTypeIsInType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLetExp__ValidateTypeIsInType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Library#getOwnedPrecedence <em>Owned Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Precedence</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Library#getOwnedPrecedence()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_OwnedPrecedence();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.LoopExp <em>Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LoopExp
	 * @generated
	 */
	EClass getLoopExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.LoopExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LoopExp#getBody()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_Body();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.LoopExp#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Iterator</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LoopExp#getIterator()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_Iterator();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.LoopExp#getReferredIteration <em>Referred Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Iteration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.LoopExp#getReferredIteration()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_ReferredIteration();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.LoopExp#validateSourceIsCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Is Collection</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Is Collection</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.LoopExp#validateSourceIsCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLoopExp__ValidateSourceIsCollection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.LoopExp#validateNoInitializers(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Initializers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Initializers</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.LoopExp#validateNoInitializers(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLoopExp__ValidateNoInitializers__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.MessageExp <em>Message Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp
	 * @generated
	 */
	EClass getMessageExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.MessageExp#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp#getTarget()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.MessageExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp#getArgument()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_Argument();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.MessageExp#getCalledOperation <em>Called Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Called Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp#getCalledOperation()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_CalledOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.MessageExp#getSentSignal <em>Sent Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sent Signal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp#getSentSignal()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_SentSignal();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.MessageExp#validateOneCallOrOneSend(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate One Call Or One Send</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate One Call Or One Send</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp#validateOneCallOrOneSend(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageExp__ValidateOneCallOrOneSend__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.MessageExp#validateTargetIsNotACollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Is Not ACollection</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Is Not ACollection</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.MessageExp#validateTargetIsNotACollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageExp__ValidateTargetIsNotACollection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.SendSignalAction <em>Send Signal Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send Signal Action</em>'.
	 * @see org.eclipse.ocl.examples.pivot.SendSignalAction
	 * @generated
	 */
	EClass getSendSignalAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.SendSignalAction#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.SendSignalAction#getSignal()
	 * @see #getSendSignalAction()
	 * @generated
	 */
	EReference getSendSignalAction_Signal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Signal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Signal
	 * @generated
	 */
	EClass getSignal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.MessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageType
	 * @generated
	 */
	EClass getMessageType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.MessageType#getReferredSignal <em>Referred Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Signal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageType#getReferredSignal()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_ReferredSignal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.MessageType#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.MessageType#getReferredOperation()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_ReferredOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Metaclass <em>Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metaclass</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Metaclass
	 * @generated
	 */
	EClass getMetaclass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Metaclass#getInstanceType <em>Instance Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Metaclass#getInstanceType()
	 * @see #getMetaclass()
	 * @generated
	 */
	EReference getMetaclass_InstanceType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.util.MorePivotable <em>More Pivotable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>More Pivotable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.util.MorePivotable
	 * @generated
	 */
	EClass getMorePivotable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.NullLiteralExp <em>Null Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NullLiteralExp
	 * @generated
	 */
	EClass getNullLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OperationCallExp
	 * @generated
	 */
	EClass getOperationCallExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.OperationCallExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OperationCallExp#getArgument()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_Argument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.OperationCallExp#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OperationCallExp#getReferredOperation()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_ReferredOperation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.OperationCallExp#validateArgumentTypeIsConformant(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Argument Type Is Conformant</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Argument Type Is Conformant</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.OperationCallExp#validateArgumentTypeIsConformant(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperationCallExp__ValidateArgumentTypeIsConformant__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.OperationCallExp#validateArgumentCount(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Argument Count</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Argument Count</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.OperationCallExp#validateArgumentCount(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperationCallExp__ValidateArgumentCount__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.OrderedSetType <em>Ordered Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OrderedSetType
	 * @generated
	 */
	EClass getOrderedSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.PackageableElement <em>Packageable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Packageable Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.PackageableElement
	 * @generated
	 */
	EClass getPackageableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Profile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Profile
	 * @generated
	 */
	EClass getProfile();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Profile#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Application</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Profile#getApplication()
	 * @see #getProfile()
	 * @generated
	 */
	EReference getProfile_Application();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ProfileApplication <em>Profile Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile Application</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ProfileApplication
	 * @generated
	 */
	EClass getProfileApplication();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.ProfileApplication#getAppliedProfile <em>Applied Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Applied Profile</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ProfileApplication#getAppliedProfile()
	 * @see #getProfileApplication()
	 * @generated
	 */
	EReference getProfileApplication_AppliedProfile();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.ProfileApplication#getApplyingPackage <em>Applying Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Applying Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ProfileApplication#getApplyingPackage()
	 * @see #getProfileApplication()
	 * @generated
	 */
	EReference getProfileApplication_ApplyingPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.ProfileApplication#isStrict <em>Is Strict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Strict</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ProfileApplication#isStrict()
	 * @see #getProfileApplication()
	 * @generated
	 */
	EAttribute getProfileApplication_IsStrict();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.PropertyCallExp <em>Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.PropertyCallExp
	 * @generated
	 */
	EClass getPropertyCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.PropertyCallExp#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.PropertyCallExp#getReferredProperty()
	 * @see #getPropertyCallExp()
	 * @generated
	 */
	EReference getPropertyCallExp_ReferredProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.PropertyCallExp#getSpecializedReferredPropertyOwningType() <em>Get Specialized Referred Property Owning Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Specialized Referred Property Owning Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.PropertyCallExp#getSpecializedReferredPropertyOwningType()
	 * @generated
	 */
	EOperation getPropertyCallExp__GetSpecializedReferredPropertyOwningType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.PropertyCallExp#getSpecializedReferredPropertyType() <em>Get Specialized Referred Property Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Specialized Referred Property Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.PropertyCallExp#getSpecializedReferredPropertyType()
	 * @generated
	 */
	EOperation getPropertyCallExp__GetSpecializedReferredPropertyType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.PropertyCallExp#validateNonStaticSourceTypeIsConformant(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Non Static Source Type Is Conformant</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Non Static Source Type Is Conformant</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.PropertyCallExp#validateNonStaticSourceTypeIsConformant(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyCallExp__ValidateNonStaticSourceTypeIsConformant__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.PropertyCallExp#validateCompatibleResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Result Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Result Type</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.PropertyCallExp#validateCompatibleResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyCallExp__ValidateCompatibleResultType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Pseudostate <em>Pseudostate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pseudostate</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Pseudostate
	 * @generated
	 */
	EClass getPseudostate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Pseudostate#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Pseudostate#getKind()
	 * @see #getPseudostate()
	 * @generated
	 */
	EAttribute getPseudostate_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Pseudostate#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Machine</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Pseudostate#getStateMachine()
	 * @see #getPseudostate()
	 * @generated
	 */
	EReference getPseudostate_StateMachine();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Pseudostate#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Pseudostate#getState()
	 * @see #getPseudostate()
	 * @generated
	 */
	EReference getPseudostate_State();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.RealLiteralExp
	 * @generated
	 */
	EClass getRealLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.RealLiteralExp#getRealSymbol <em>Real Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real Symbol</em>'.
	 * @see org.eclipse.ocl.examples.pivot.RealLiteralExp#getRealSymbol()
	 * @see #getRealLiteralExp()
	 * @generated
	 */
	EAttribute getRealLiteralExp_RealSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ReferringElement <em>Referring Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referring Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ReferringElement
	 * @generated
	 */
	EClass getReferringElement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ReferringElement#getReferredElement() <em>Get Referred Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Referred Element</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ReferringElement#getReferredElement()
	 * @generated
	 */
	EOperation getReferringElement__GetReferredElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Region
	 * @generated
	 */
	EClass getRegion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Region#getSubvertex <em>Subvertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subvertex</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Region#getSubvertex()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Subvertex();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Region#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transition</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Region#getTransition()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Transition();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Region#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State Machine</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Region#getStateMachine()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_StateMachine();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Region#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Region#getState()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_State();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Region#getExtendedRegion <em>Extended Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended Region</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Region#getExtendedRegion()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_ExtendedRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Root#getNestedPackage <em>Nested Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Root#getNestedPackage()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_NestedPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Root#getExternalURI <em>External URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External URI</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Root#getExternalURI()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_ExternalURI();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Root#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Root#getImports()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Imports();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.SelfType <em>Self Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Self Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.SelfType
	 * @generated
	 */
	EClass getSelfType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.SelfType#specializeIn(org.eclipse.ocl.examples.pivot.OCLExpression, org.eclipse.ocl.examples.pivot.Type) <em>Specialize In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Specialize In</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.SelfType#specializeIn(org.eclipse.ocl.examples.pivot.OCLExpression, org.eclipse.ocl.examples.pivot.Type)
	 * @generated
	 */
	EOperation getSelfType__SpecializeIn__OCLExpression_Type_1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.SequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.SequenceType
	 * @generated
	 */
	EClass getSequenceType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.SetType <em>Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.SetType
	 * @generated
	 */
	EClass getSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.State#isComposite <em>Is Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Composite</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#isComposite()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_IsComposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.State#isOrthogonal <em>Is Orthogonal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Orthogonal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#isOrthogonal()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_IsOrthogonal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.State#isSimple <em>Is Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Simple</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#isSimple()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_IsSimple();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.State#isSubmachineState <em>Is Submachine State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Submachine State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#isSubmachineState()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_IsSubmachineState();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.State#getSubmachine <em>Submachine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Submachine</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#getSubmachine()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Submachine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.State#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#getConnection()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Connection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.State#getRedefinedState <em>Redefined State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Redefined State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#getRedefinedState()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_RedefinedState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.State#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Region</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#getRegion()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Region();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.State#getStateInvariant <em>State Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State Invariant</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#getStateInvariant()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_StateInvariant();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.State#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Entry</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#getEntry()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Entry();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.State#getExit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exit</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#getExit()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Exit();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.State#getDoActivity <em>Do Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Do Activity</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#getDoActivity()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_DoActivity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.State#getConnectionPoint <em>Connection Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection Point</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#getConnectionPoint()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_ConnectionPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.State#getDeferrableTrigger <em>Deferrable Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deferrable Trigger</em>'.
	 * @see org.eclipse.ocl.examples.pivot.State#getDeferrableTrigger()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_DeferrableTrigger();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.StateExp <em>State Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StateExp
	 * @generated
	 */
	EClass getStateExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.StateExp#getReferredState <em>Referred State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StateExp#getReferredState()
	 * @see #getStateExp()
	 * @generated
	 */
	EReference getStateExp_ReferredState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StateMachine
	 * @generated
	 */
	EClass getStateMachine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.StateMachine#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Region</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StateMachine#getRegion()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_Region();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.StateMachine#getConnectionPoint <em>Connection Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection Point</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StateMachine#getConnectionPoint()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_ConnectionPoint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.StateMachine#getExtendedStateMachine <em>Extended State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extended State Machine</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StateMachine#getExtendedStateMachine()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_ExtendedStateMachine();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.StateMachine#getSubmachineState <em>Submachine State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Submachine State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StateMachine#getSubmachineState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_SubmachineState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Stereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Stereotype
	 * @generated
	 */
	EClass getStereotype();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Stereotype#getExtensionOfs <em>Extension Ofs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension Ofs</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Stereotype#getExtensionOfs()
	 * @see #getStereotype()
	 * @generated
	 */
	EReference getStereotype_ExtensionOfs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StringLiteralExp
	 * @generated
	 */
	EClass getStringLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.StringLiteralExp#getStringSymbol <em>String Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Symbol</em>'.
	 * @see org.eclipse.ocl.examples.pivot.StringLiteralExp#getStringSymbol()
	 * @see #getStringLiteralExp()
	 * @generated
	 */
	EAttribute getStringLiteralExp_StringSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateParameterType <em>Template Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterType
	 * @generated
	 */
	EClass getTemplateParameterType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.TemplateParameterType#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterType#getSpecification()
	 * @see #getTemplateParameterType()
	 * @generated
	 */
	EAttribute getTemplateParameterType_Specification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TupleLiteralExp
	 * @generated
	 */
	EClass getTupleLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.TupleLiteralExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TupleLiteralExp#getPart()
	 * @see #getTupleLiteralExp()
	 * @generated
	 */
	EReference getTupleLiteralExp_Part();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TupleLiteralPart <em>Tuple Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Part</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TupleLiteralPart
	 * @generated
	 */
	EClass getTupleLiteralPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.TupleLiteralPart#getInitExpression <em>Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TupleLiteralPart#getInitExpression()
	 * @see #getTupleLiteralPart()
	 * @generated
	 */
	EReference getTupleLiteralPart_InitExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TupleType <em>Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TupleType
	 * @generated
	 */
	EClass getTupleType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TypeExp <em>Type Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeExp
	 * @generated
	 */
	EClass getTypeExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TypeExp#getReferredType <em>Referred Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeExp#getReferredType()
	 * @see #getTypeExp()
	 * @generated
	 */
	EReference getTypeExp_ReferredType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TypeExtension <em>Type Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Extension</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeExtension
	 * @generated
	 */
	EClass getTypeExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.TypeExtension#isRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeExtension#isRequired()
	 * @see #getTypeExtension()
	 * @generated
	 */
	EAttribute getTypeExtension_IsRequired();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.TypeExtension#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Stereotype</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeExtension#getStereotype()
	 * @see #getTypeExtension()
	 * @generated
	 */
	EReference getTypeExtension_Stereotype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TypeExtension#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeExtension#getType()
	 * @see #getTypeExtension()
	 * @generated
	 */
	EReference getTypeExtension_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp <em>Unlimited Natural Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Natural Literal Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp
	 * @generated
	 */
	EClass getUnlimitedNaturalLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp#getUnlimitedNaturalSymbol <em>Unlimited Natural Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unlimited Natural Symbol</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp#getUnlimitedNaturalSymbol()
	 * @see #getUnlimitedNaturalLiteralExp()
	 * @generated
	 */
	EAttribute getUnlimitedNaturalLiteralExp_UnlimitedNaturalSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.UnspecifiedType <em>Unspecified Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unspecified Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnspecifiedType
	 * @generated
	 */
	EClass getUnspecifiedType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.UnspecifiedType#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lower Bound</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnspecifiedType#getLowerBound()
	 * @see #getUnspecifiedType()
	 * @generated
	 */
	EReference getUnspecifiedType_LowerBound();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.UnspecifiedType#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Upper Bound</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnspecifiedType#getUpperBound()
	 * @see #getUnspecifiedType()
	 * @generated
	 */
	EReference getUnspecifiedType_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.UnspecifiedValueExp <em>Unspecified Value Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unspecified Value Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.UnspecifiedValueExp
	 * @generated
	 */
	EClass getUnspecifiedValueExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.VariableExp
	 * @generated
	 */
	EClass getVariableExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.VariableExp#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.VariableExp#getReferredVariable()
	 * @see #getVariableExp()
	 * @generated
	 */
	EReference getVariableExp_ReferredVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.VariableExp#isImplicit <em>Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implicit</em>'.
	 * @see org.eclipse.ocl.examples.pivot.VariableExp#isImplicit()
	 * @see #getVariableExp()
	 * @generated
	 */
	EAttribute getVariableExp_Implicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Vertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Vertex
	 * @generated
	 */
	EClass getVertex();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Vertex#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Vertex#getContainer()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_Container();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Vertex#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Vertex#getOutgoing()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_Outgoing();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Vertex#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Vertex#getIncoming()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_Incoming();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Void Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.VoidType
	 * @generated
	 */
	EClass getVoidType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.util.Pivotable <em>Pivotable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pivotable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.util.Pivotable
	 * @generated
	 */
	EClass getPivotable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.util.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.util.Visitable
	 * @generated
	 */
	EClass getVisitable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Class#isAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class#isAbstract()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Class#isActive <em>Is Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Active</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class#isActive()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsActive();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Class#getOwnedBehavior <em>Owned Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Behavior</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class#getOwnedBehavior()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedBehavior();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Class#isInterface <em>Is Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Interface</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class#isInterface()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Class#getNestedType <em>Nested Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Class#getNestedType()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_NestedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Type#getExtendedBys <em>Extended Bys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extended Bys</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Type#getExtendedBys()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_ExtendedBys();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Type#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Type#getPackage()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_Package();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Type#getOwnedAttribute <em>Owned Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Attribute</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Type#getOwnedAttribute()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_OwnedAttribute();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Type#getOwnedOperation <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Type#getOwnedOperation()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_OwnedOperation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Type#getSuperClass <em>Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Type#getSuperClass()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_SuperClass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Type#getOwnedInvariant <em>Owned Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Invariant</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Type#getOwnedInvariant()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_OwnedInvariant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Type#getInstanceClassName <em>Instance Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Class Name</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Type#getInstanceClassName()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_InstanceClassName();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Type#specializeIn(org.eclipse.ocl.examples.pivot.OCLExpression, org.eclipse.ocl.examples.pivot.Type) <em>Specialize In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Specialize In</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Type#specializeIn(org.eclipse.ocl.examples.pivot.OCLExpression, org.eclipse.ocl.examples.pivot.Type)
	 * @generated
	 */
	EOperation getType__SpecializeIn__OCLExpression_Type();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Type#validateUniqueInvariantName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unique Invariant Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unique Invariant Name</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Type#validateUniqueInvariantName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getType__ValidateUniqueInvariantName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateableElement <em>Templateable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Templateable Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement
	 * @generated
	 */
	EClass getTemplateableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#getTemplateBinding <em>Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Binding</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement#getTemplateBinding()
	 * @see #getTemplateableElement()
	 * @generated
	 */
	EReference getTemplateableElement_TemplateBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#getOwnedTemplateSignature <em>Owned Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Template Signature</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement#getOwnedTemplateSignature()
	 * @see #getTemplateableElement()
	 * @generated
	 */
	EReference getTemplateableElement_OwnedTemplateSignature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#getUnspecializedElement <em>Unspecialized Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unspecialized Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement#getUnspecializedElement()
	 * @see #getTemplateableElement()
	 * @generated
	 */
	EReference getTemplateableElement_UnspecializedElement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#parameterableElements() <em>Parameterable Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parameterable Elements</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement#parameterableElements()
	 * @generated
	 */
	EOperation getTemplateableElement__ParameterableElements();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#isTemplate() <em>Is Template</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Template</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement#isTemplate()
	 * @generated
	 */
	EOperation getTemplateableElement__IsTemplate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Transition#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Transition#getKind()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Kind();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Transition#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Transition#getContainer()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Container();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.Transition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Transition#getGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Guard();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.Transition#getEffect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Effect</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Transition#getEffect()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Effect();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Transition#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trigger</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Transition#getTrigger()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Trigger();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Trigger
	 * @generated
	 */
	EClass getTrigger();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Trigger#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Trigger#getState()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_State();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Trigger#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Transition</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Trigger#getTransition()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_Transition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateBinding <em>Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Binding</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateBinding
	 * @generated
	 */
	EClass getTemplateBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TemplateBinding#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateBinding#getSignature()
	 * @see #getTemplateBinding()
	 * @generated
	 */
	EReference getTemplateBinding_Signature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.TemplateBinding#getParameterSubstitution <em>Parameter Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Substitution</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateBinding#getParameterSubstitution()
	 * @see #getTemplateBinding()
	 * @generated
	 */
	EReference getTemplateBinding_ParameterSubstitution();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.TemplateBinding#getBoundElement <em>Bound Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bound Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateBinding#getBoundElement()
	 * @see #getTemplateBinding()
	 * @generated
	 */
	EReference getTemplateBinding_BoundElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateSignature <em>Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Signature</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateSignature
	 * @generated
	 */
	EClass getTemplateSignature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getOwnedParameter <em>Owned Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateSignature#getOwnedParameter()
	 * @see #getTemplateSignature()
	 * @generated
	 */
	EReference getTemplateSignature_OwnedParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Template</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateSignature#getTemplate()
	 * @see #getTemplateSignature()
	 * @generated
	 */
	EReference getTemplateSignature_Template();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter
	 * @generated
	 */
	EClass getTemplateParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Signature</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getSignature()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_Signature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getParameteredElement <em>Parametered Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parametered Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getParameteredElement()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_ParameteredElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getOwnedParameteredElement <em>Owned Parametered Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Parametered Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getOwnedParameteredElement()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_OwnedParameteredElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getDefault()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_Default();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getOwnedDefault <em>Owned Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Default</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getOwnedDefault()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_OwnedDefault();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ParameterableElement <em>Parameterable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterable Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ParameterableElement
	 * @generated
	 */
	EClass getParameterableElement();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.ParameterableElement#getOwningTemplateParameter <em>Owning Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ParameterableElement#getOwningTemplateParameter()
	 * @see #getParameterableElement()
	 * @generated
	 */
	EReference getParameterableElement_OwningTemplateParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.ParameterableElement#getTemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ParameterableElement#getTemplateParameter()
	 * @see #getParameterableElement()
	 * @generated
	 */
	EReference getParameterableElement_TemplateParameter();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ParameterableElement#isTemplateParameter() <em>Is Template Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Template Parameter</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ParameterableElement#isTemplateParameter()
	 * @generated
	 */
	EOperation getParameterableElement__IsTemplateParameter();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ParameterableElement#isCompatibleWith(org.eclipse.ocl.examples.pivot.ParameterableElement) <em>Is Compatible With</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Compatible With</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ParameterableElement#isCompatibleWith(org.eclipse.ocl.examples.pivot.ParameterableElement)
	 * @generated
	 */
	EOperation getParameterableElement__IsCompatibleWith__ParameterableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution <em>Template Parameter Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter Substitution</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution
	 * @generated
	 */
	EClass getTemplateParameterSubstitution();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getFormal <em>Formal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Formal</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getFormal()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_Formal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getActual <em>Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actual</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getActual()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_Actual();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getOwnedActual <em>Owned Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Actual</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getOwnedActual()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_OwnedActual();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getTemplateBinding <em>Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Template Binding</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution#getTemplateBinding()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_TemplateBinding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Package#getNestedPackage <em>Nested Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getNestedPackage()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_NestedPackage();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Package#getNestingPackage <em>Nesting Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Nesting Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getNestingPackage()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_NestingPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Package#getNsPrefix <em>Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns Prefix</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getNsPrefix()
	 * @see #getPackage()
	 * @generated
	 */
	EAttribute getPackage_NsPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Package#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getNsURI()
	 * @see #getPackage()
	 * @generated
	 */
	EAttribute getPackage_NsURI();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Package#getImportedPackage <em>Imported Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imported Package</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getImportedPackage()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_ImportedPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Package#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getOwnedType()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwnedType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Package#getProfileApplication <em>Profile Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Profile Application</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Package#getProfileApplication()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_ProfileApplication();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Namespace
	 * @generated
	 */
	EClass getNamespace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Namespace#getOwnedRule <em>Owned Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Rule</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Namespace#getOwnedRule()
	 * @see #getNamespace()
	 * @generated
	 */
	EReference getNamespace_OwnedRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Precedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precedence</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Precedence
	 * @generated
	 */
	EClass getPrecedence();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Precedence#getAssociativity <em>Associativity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Associativity</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Precedence#getAssociativity()
	 * @see #getPrecedence()
	 * @generated
	 */
	EAttribute getPrecedence_Associativity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Precedence#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Precedence#getOrder()
	 * @see #getPrecedence()
	 * @generated
	 */
	EAttribute getPrecedence_Order();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TypeTemplateParameter <em>Type Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeTemplateParameter
	 * @generated
	 */
	EClass getTypeTemplateParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.TypeTemplateParameter#isAllowSubstitutable <em>Allow Substitutable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Substitutable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeTemplateParameter#isAllowSubstitutable()
	 * @see #getTypeTemplateParameter()
	 * @generated
	 */
	EAttribute getTypeTemplateParameter_AllowSubstitutable();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.TypeTemplateParameter#getConstrainingType <em>Constraining Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraining Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypeTemplateParameter#getConstrainingType()
	 * @see #getTypeTemplateParameter()
	 * @generated
	 */
	EReference getTypeTemplateParameter_ConstrainingType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Property#getAssociationClass <em>Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getAssociationClass()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_AssociationClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isReadOnly <em>Is Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Read Only</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isReadOnly()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getDefault()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isComposite <em>Is Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Composite</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isComposite()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsComposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isDerived <em>Is Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Derived</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isDerived()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsDerived();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Property#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getOpposite()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Opposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isImplicit <em>Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implicit</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isImplicit()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Implicit();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.Property#getDefaultExpression <em>Default Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getDefaultExpression()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_DefaultExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isID <em>Is ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is ID</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isID()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsID();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Property#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Keys</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getKeys()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Keys();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isResolveProxies <em>Is Resolve Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Resolve Proxies</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isResolveProxies()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsResolveProxies();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isTransient <em>Is Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Transient</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isTransient()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsTransient();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isUnsettable <em>Is Unsettable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unsettable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isUnsettable()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsUnsettable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Property#isVolatile <em>Is Volatile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Volatile</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#isVolatile()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsVolatile();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Property#getRedefinedProperty <em>Redefined Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Redefined Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getRedefinedProperty()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_RedefinedProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Property#getSubsettedProperty <em>Subsetted Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subsetted Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getSubsettedProperty()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_SubsettedProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Property#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getReferredProperty()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_ReferredProperty();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Property#getOwningType <em>Owning Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getOwningType()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_OwningType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Property#isAttribute(org.eclipse.ocl.examples.pivot.Property) <em>Is Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Attribute</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Property#isAttribute(org.eclipse.ocl.examples.pivot.Property)
	 * @generated
	 */
	EOperation getProperty__IsAttribute__Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Property#validateCompatibleDefaultExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Default Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Default Expression</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Property#validateCompatibleDefaultExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getProperty__ValidateCompatibleDefaultExpression__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Property#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property#getClass_()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.TypedElement#isRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypedElement#isRequired()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_IsRequired();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.TypedMultiplicityElement <em>Typed Multiplicity Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Multiplicity Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TypedMultiplicityElement
	 * @generated
	 */
	EClass getTypedMultiplicityElement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TypedMultiplicityElement#CompatibleBody(org.eclipse.ocl.examples.pivot.ValueSpecification) <em>Compatible Body</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Compatible Body</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TypedMultiplicityElement#CompatibleBody(org.eclipse.ocl.examples.pivot.ValueSpecification)
	 * @generated
	 */
	EOperation getTypedMultiplicityElement__CompatibleBody__ValueSpecification();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.TypedMultiplicityElement#makeParameter() <em>Make Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Make Parameter</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.TypedMultiplicityElement#makeParameter()
	 * @generated
	 */
	EOperation getTypedMultiplicityElement__MakeParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.AssociationClass <em>Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AssociationClass
	 * @generated
	 */
	EClass getAssociationClass();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.AssociationClass#getUnownedAttribute <em>Unowned Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unowned Attribute</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AssociationClass#getUnownedAttribute()
	 * @see #getAssociationClass()
	 * @generated
	 */
	EReference getAssociationClass_UnownedAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Operation#getRaisedException <em>Raised Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Raised Exception</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getRaisedException()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_RaisedException();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Operation#getOwnedParameter <em>Owned Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getOwnedParameter()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwnedParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Operation#getOwningType <em>Owning Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getOwningType()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwningType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Operation#getPrecondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Precondition</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getPrecondition()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Precondition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.Operation#getPostcondition <em>Postcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postcondition</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getPostcondition()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Postcondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.Operation#getBodyExpression <em>Body Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getBodyExpression()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_BodyExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Operation#isInvalidating <em>Is Invalidating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Invalidating</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#isInvalidating()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_IsInvalidating();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Operation#isValidating <em>Is Validating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Validating</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#isValidating()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_IsValidating();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Operation#getPrecedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Precedence</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getPrecedence()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Precedence();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Operation#getRedefinedOperation <em>Redefined Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Redefined Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getRedefinedOperation()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_RedefinedOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Operation#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation#getClass_()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Class();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Operation#validateCompatibleReturn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Return</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Return</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Operation#validateCompatibleReturn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperation__ValidateCompatibleReturn__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Operation#validateLoadableImplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Loadable Implementation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Loadable Implementation</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Operation#validateLoadableImplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperation__ValidateLoadableImplementation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Operation#validateUniquePreconditionName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unique Precondition Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unique Precondition Name</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Operation#validateUniquePreconditionName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperation__ValidateUniquePreconditionName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Operation#validateUniquePostconditionName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unique Postcondition Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unique Postcondition Name</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Operation#validateUniquePostconditionName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperation__ValidateUniquePostconditionName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Parameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Parameter#getOperation()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.OperationTemplateParameter <em>Operation Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OperationTemplateParameter
	 * @generated
	 */
	EClass getOperationTemplateParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.OppositePropertyCallExp <em>Opposite Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opposite Property Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OppositePropertyCallExp
	 * @generated
	 */
	EClass getOppositePropertyCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.OppositePropertyCallExp#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.OppositePropertyCallExp#getReferredProperty()
	 * @see #getOppositePropertyCallExp()
	 * @generated
	 */
	EReference getOppositePropertyCallExp_ReferredProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Comment#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Comment#getBody()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Body();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Comment#getAnnotatedElement <em>Annotated Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Annotated Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Comment#getAnnotatedElement()
	 * @see #getComment()
	 * @generated
	 */
	EReference getComment_AnnotatedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ConnectionPointReference <em>Connection Point Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Point Reference</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ConnectionPointReference
	 * @generated
	 */
	EClass getConnectionPointReference();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.ConnectionPointReference#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Entry</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ConnectionPointReference#getEntry()
	 * @see #getConnectionPointReference()
	 * @generated
	 */
	EReference getConnectionPointReference_Entry();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.ConnectionPointReference#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ConnectionPointReference#getState()
	 * @see #getConnectionPointReference()
	 * @generated
	 */
	EReference getConnectionPointReference_State();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.ConnectionPointReference#getExit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Exit</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ConnectionPointReference#getExit()
	 * @see #getConnectionPointReference()
	 * @generated
	 */
	EReference getConnectionPointReference_Exit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Constraint#getConstrainedElement <em>Constrained Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constrained Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getConstrainedElement()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_ConstrainedElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.Constraint#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getSpecification()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Specification();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Constraint#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Transition</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getTransition()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Transition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.Constraint#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getContext()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.Constraint#isCallable <em>Is Callable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Callable</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#isCallable()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_IsCallable();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.pivot.Constraint#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getOwningState()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_OwningState();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.Constraint#getRedefinedConstraint <em>Redefined Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Redefined Constraint</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getRedefinedConstraint()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_RedefinedConstraint();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.Constraint#validateUniqueName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unique Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unique Name</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.Constraint#validateUniqueName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getConstraint__ValidateUniqueName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ConstructorExp <em>Constructor Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ConstructorExp
	 * @generated
	 */
	EClass getConstructorExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.ConstructorExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ConstructorExp#getPart()
	 * @see #getConstructorExp()
	 * @generated
	 */
	EReference getConstructorExp_Part();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.ConstructorExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ConstructorExp#getValue()
	 * @see #getConstructorExp()
	 * @generated
	 */
	EAttribute getConstructorExp_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ConstructorPart <em>Constructor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor Part</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ConstructorPart
	 * @generated
	 */
	EClass getConstructorPart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.ConstructorPart#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ConstructorPart#getReferredProperty()
	 * @see #getConstructorPart()
	 * @generated
	 */
	EReference getConstructorPart_ReferredProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.ConstructorPart#getInitExpression <em>Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Expression</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ConstructorPart#getInitExpression()
	 * @see #getConstructorPart()
	 * @generated
	 */
	EReference getConstructorPart_InitExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.ValueSpecification <em>Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Specification</em>'.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification
	 * @generated
	 */
	EClass getValueSpecification();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#isComputable() <em>Is Computable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Computable</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#isComputable()
	 * @generated
	 */
	EOperation getValueSpecification__IsComputable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#integerValue() <em>Integer Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Integer Value</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#integerValue()
	 * @generated
	 */
	EOperation getValueSpecification__IntegerValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#booleanValue() <em>Boolean Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Boolean Value</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#booleanValue()
	 * @generated
	 */
	EOperation getValueSpecification__BooleanValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#stringValue() <em>String Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>String Value</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#stringValue()
	 * @generated
	 */
	EOperation getValueSpecification__StringValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#unlimitedValue() <em>Unlimited Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Unlimited Value</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#unlimitedValue()
	 * @generated
	 */
	EOperation getValueSpecification__UnlimitedValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.pivot.ValueSpecification#isNull() <em>Is Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Null</em>' operation.
	 * @see org.eclipse.ocl.examples.pivot.ValueSpecification#isNull()
	 * @generated
	 */
	EOperation getValueSpecification__IsNull();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.elements.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see org.eclipse.ocl.examples.domain.elements.Nameable
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.Detail <em>Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detail</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Detail
	 * @generated
	 */
	EClass getDetail();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.pivot.Detail#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Detail#getValue()
	 * @see #getDetail()
	 * @generated
	 */
	EAttribute getDetail_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.DynamicBehavior <em>Dynamic Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Behavior</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DynamicBehavior
	 * @generated
	 */
	EClass getDynamicBehavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.DynamicElement <em>Dynamic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DynamicElement
	 * @generated
	 */
	EClass getDynamicElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.DynamicElement#getMetaType <em>Meta Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Meta Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DynamicElement#getMetaType()
	 * @see #getDynamicElement()
	 * @generated
	 */
	EReference getDynamicElement_MetaType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.DynamicProperty <em>Dynamic Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DynamicProperty
	 * @generated
	 */
	EClass getDynamicProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.DynamicProperty#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DynamicProperty#getReferredProperty()
	 * @see #getDynamicProperty()
	 * @generated
	 */
	EReference getDynamicProperty_ReferredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.DynamicProperty#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DynamicProperty#getDefault()
	 * @see #getDynamicProperty()
	 * @generated
	 */
	EAttribute getDynamicProperty_Default();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.DynamicType <em>Dynamic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DynamicType
	 * @generated
	 */
	EClass getDynamicType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.pivot.DynamicType#getOwnedProperty <em>Owned Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.DynamicType#getOwnedProperty()
	 * @see #getDynamicType()
	 * @generated
	 */
	EReference getDynamicType_OwnedProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.AnyType <em>Any Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Type</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AnyType
	 * @generated
	 */
	EClass getAnyType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.AssociationClassCallExp <em>Association Class Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Class Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AssociationClassCallExp
	 * @generated
	 */
	EClass getAssociationClassCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.AssociationClassCallExp#getReferredAssociationClass <em>Referred Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Association Class</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AssociationClassCallExp#getReferredAssociationClass()
	 * @see #getAssociationClassCallExp()
	 * @generated
	 */
	EReference getAssociationClassCallExp_ReferredAssociationClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.NavigationCallExp <em>Navigation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NavigationCallExp
	 * @generated
	 */
	EClass getNavigationCallExp();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.pivot.NavigationCallExp#getQualifier <em>Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Qualifier</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NavigationCallExp#getQualifier()
	 * @see #getNavigationCallExp()
	 * @generated
	 */
	EReference getNavigationCallExp_Qualifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.pivot.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Navigation Source</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NavigationCallExp#getNavigationSource()
	 * @see #getNavigationCallExp()
	 * @generated
	 */
	EReference getNavigationCallExp_NavigationSource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.FeatureCallExp <em>Feature Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.FeatureCallExp
	 * @generated
	 */
	EClass getFeatureCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.FeatureCallExp#isPre <em>Is Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Pre</em>'.
	 * @see org.eclipse.ocl.examples.pivot.FeatureCallExp#isPre()
	 * @see #getFeatureCallExp()
	 * @generated
	 */
	EAttribute getFeatureCallExp_IsPre();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final State</em>'.
	 * @see org.eclipse.ocl.examples.pivot.FinalState
	 * @generated
	 */
	EClass getFinalState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.CallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CallExp
	 * @generated
	 */
	EClass getCallExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.pivot.CallExp#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CallExp#getSource()
	 * @see #getCallExp()
	 * @generated
	 */
	EReference getCallExp_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.pivot.CallExp#isImplicit <em>Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implicit</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CallExp#isImplicit()
	 * @see #getCallExp()
	 * @generated
	 */
	EAttribute getCallExp_Implicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.pivot.util.Visitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor</em>'.
	 * @see org.eclipse.ocl.examples.pivot.util.Visitor
	 * @generated
	 */
	EClass getVisitor();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.pivot.AssociativityKind <em>Associativity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Associativity Kind</em>'.
	 * @see org.eclipse.ocl.examples.pivot.AssociativityKind
	 * @generated
	 */
	EEnum getAssociativityKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.pivot.CollectionKind <em>Collection Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Kind</em>'.
	 * @see org.eclipse.ocl.examples.pivot.CollectionKind
	 * @generated
	 */
	EEnum getCollectionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.pivot.PseudostateKind <em>Pseudostate Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Pseudostate Kind</em>'.
	 * @see org.eclipse.ocl.examples.pivot.PseudostateKind
	 * @generated
	 */
	EEnum getPseudostateKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.pivot.TransitionKind <em>Transition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transition Kind</em>'.
	 * @see org.eclipse.ocl.examples.pivot.TransitionKind
	 * @generated
	 */
	EEnum getTransitionKind();

	/**
	 * Returns the meta object for data type '<em>Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Boolean</em>'.
	 * @generated
	 */
	EDataType getBoolean();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer</em>'.
	 * @see java.lang.Number
	 * @generated
	 */
	EDataType getInteger();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.domain.library.LibraryFeature <em>Library Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Library Feature</em>'.
	 * @see org.eclipse.ocl.examples.domain.library.LibraryFeature
	 * @generated
	 */
	EDataType getLibraryFeature();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @generated
	 */
	EDataType getObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Real</em>'.
	 * @see java.lang.Number
	 * @generated
	 */
	EDataType getReal();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the meta object for data type '{@link java.lang.Throwable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Throwable</em>'.
	 * @see java.lang.Throwable
	 * @generated
	 */
	EDataType getThrowable();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Unlimited Natural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unlimited Natural</em>'.
	 * @see java.lang.Number
	 * @generated
	 */
	EDataType getUnlimitedNatural();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PivotFactory getPivotFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Owned Content</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__OWNED_CONTENT = eINSTANCE.getAnnotation_OwnedContent();

		/**
		 * The meta object literal for the '<em><b>Owned Detail</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__OWNED_DETAIL = eINSTANCE.getAnnotation_OwnedDetail();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__REFERENCE = eINSTANCE.getAnnotation_Reference();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.NamedElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__IS_STATIC = eINSTANCE.getNamedElement_IsStatic();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Owned Comment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__OWNED_COMMENT = eINSTANCE.getElement_OwnedComment();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__EXTENSION = eINSTANCE.getElement_Extension();

		/**
		 * The meta object literal for the '<em><b>Owned Annotation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__OWNED_ANNOTATION = eINSTANCE.getElement_OwnedAnnotation();

		/**
		 * The meta object literal for the '<em><b>All Owned Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ELEMENT___ALL_OWNED_ELEMENTS = eINSTANCE.getElement__AllOwnedElements();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ELEMENT___GET_VALUE__TYPE_STRING = eINSTANCE.getElement__GetValue__Type_String();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ElementExtensionImpl <em>Element Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ElementExtensionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getElementExtension()
		 * @generated
		 */
		EClass ELEMENT_EXTENSION = eINSTANCE.getElementExtension();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_EXTENSION__STEREOTYPE = eINSTANCE.getElementExtension_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_EXTENSION__BASE = eINSTANCE.getElementExtension_Base();

		/**
		 * The meta object literal for the '<em><b>Is Applied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_EXTENSION__IS_APPLIED = eINSTANCE.getElementExtension_IsApplied();

		/**
		 * The meta object literal for the '<em><b>Is Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_EXTENSION__IS_REQUIRED = eINSTANCE.getElementExtension_IsRequired();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OCLExpressionImpl <em>OCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OCLExpressionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOCLExpression()
		 * @generated
		 */
		EClass OCL_EXPRESSION = eINSTANCE.getOCLExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.BagTypeImpl <em>Bag Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.BagTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBagType()
		 * @generated
		 */
		EClass BAG_TYPE = eINSTANCE.getBagType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.BehaviorImpl <em>Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.BehaviorImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBehavior()
		 * @generated
		 */
		EClass BEHAVIOR = eINSTANCE.getBehavior();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__TRANSITION = eINSTANCE.getBehavior_Transition();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionType()
		 * @generated
		 */
		EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE__ELEMENT_TYPE = eINSTANCE.getCollectionType_ElementType();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_TYPE__LOWER = eINSTANCE.getCollectionType_Lower();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_TYPE__UPPER = eINSTANCE.getCollectionType_Upper();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.DataTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Is Serializable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__IS_SERIALIZABLE = eINSTANCE.getDataType_IsSerializable();

		/**
		 * The meta object literal for the '<em><b>Behavioral Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__BEHAVIORAL_TYPE = eINSTANCE.getDataType_BehavioralType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.BooleanLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBooleanLiteralExp()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Boolean Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = eINSTANCE.getBooleanLiteralExp_BooleanSymbol();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOOLEAN_LITERAL_EXP___VALIDATE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getBooleanLiteralExp__ValidateTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrimitiveLiteralExp()
		 * @generated
		 */
		EClass PRIMITIVE_LITERAL_EXP = eINSTANCE.getPrimitiveLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.LiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLiteralExp()
		 * @generated
		 */
		EClass LITERAL_EXP = eINSTANCE.getLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CallOperationActionImpl <em>Call Operation Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CallOperationActionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCallOperationAction()
		 * @generated
		 */
		EClass CALL_OPERATION_ACTION = eINSTANCE.getCallOperationAction();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_OPERATION_ACTION__OPERATION = eINSTANCE.getCallOperationAction_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionItemImpl <em>Collection Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionItemImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionItem()
		 * @generated
		 */
		EClass COLLECTION_ITEM = eINSTANCE.getCollectionItem();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_ITEM__ITEM = eINSTANCE.getCollectionItem_Item();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Item Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_ITEM___VALIDATE_TYPE_IS_ITEM_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionItem__ValidateTypeIsItemType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralPartImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionLiteralPart()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_PART = eINSTANCE.getCollectionLiteralPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionLiteralExp()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP = eINSTANCE.getCollectionLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_LITERAL_EXP__KIND = eINSTANCE.getCollectionLiteralExp_Kind();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP__PART = eINSTANCE.getCollectionLiteralExp_Part();

		/**
		 * The meta object literal for the '<em><b>Validate Collection Kind Is Concrete</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_LITERAL_EXP___VALIDATE_COLLECTION_KIND_IS_CONCRETE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionLiteralExp__ValidateCollectionKindIsConcrete__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Set Kind Is Set</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_LITERAL_EXP___VALIDATE_SET_KIND_IS_SET__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionLiteralExp__ValidateSetKindIsSet__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Ordered Set Kind Is Ordered Set</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_LITERAL_EXP___VALIDATE_ORDERED_SET_KIND_IS_ORDERED_SET__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionLiteralExp__ValidateOrderedSetKindIsOrderedSet__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Sequence Kind Is Sequence</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_LITERAL_EXP___VALIDATE_SEQUENCE_KIND_IS_SEQUENCE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionLiteralExp__ValidateSequenceKindIsSequence__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Bag Kind Is Bag</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_LITERAL_EXP___VALIDATE_BAG_KIND_IS_BAG__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionLiteralExp__ValidateBagKindIsBag__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CollectionRangeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionRange()
		 * @generated
		 */
		EClass COLLECTION_RANGE = eINSTANCE.getCollectionRange();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RANGE__FIRST = eINSTANCE.getCollectionRange_First();

		/**
		 * The meta object literal for the '<em><b>Last</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RANGE__LAST = eINSTANCE.getCollectionRange_Last();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumLiteralExp()
		 * @generated
		 */
		EClass ENUM_LITERAL_EXP = eINSTANCE.getEnumLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Referred Enum Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = eINSTANCE.getEnumLiteralExp_ReferredEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Enumeration Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENUM_LITERAL_EXP___VALIDATE_TYPE_IS_ENUMERATION_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getEnumLiteralExp__ValidateTypeIsEnumerationType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumerationLiteralImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_LITERAL__ENUMERATION = eINSTANCE.getEnumerationLiteral_Enumeration();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL__VALUE = eINSTANCE.getEnumerationLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.EnumerationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Owned Literal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__OWNED_LITERAL = eINSTANCE.getEnumeration_OwnedLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOCLImpl <em>Expression In OCL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOCLImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getExpressionInOCL()
		 * @generated
		 */
		EClass EXPRESSION_IN_OCL = eINSTANCE.getExpressionInOCL();

		/**
		 * The meta object literal for the '<em><b>Body Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__BODY_EXPRESSION = eINSTANCE.getExpressionInOCL_BodyExpression();

		/**
		 * The meta object literal for the '<em><b>Context Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__CONTEXT_VARIABLE = eINSTANCE.getExpressionInOCL_ContextVariable();

		/**
		 * The meta object literal for the '<em><b>Result Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__RESULT_VARIABLE = eINSTANCE.getExpressionInOCL_ResultVariable();

		/**
		 * The meta object literal for the '<em><b>Parameter Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__PARAMETER_VARIABLE = eINSTANCE.getExpressionInOCL_ParameterVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.FeatureImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Implementation Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__IMPLEMENTATION_CLASS = eINSTANCE.getFeature_ImplementationClass();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__IMPLEMENTATION = eINSTANCE.getFeature_Implementation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl <em>Opaque Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOpaqueExpression()
		 * @generated
		 */
		EClass OPAQUE_EXPRESSION = eINSTANCE.getOpaqueExpression();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPAQUE_EXPRESSION__BODY = eINSTANCE.getOpaqueExpression_Body();

		/**
		 * The meta object literal for the '<em><b>Expression In OCL</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPAQUE_EXPRESSION__EXPRESSION_IN_OCL = eINSTANCE.getOpaqueExpression_ExpressionInOCL();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPAQUE_EXPRESSION__LANGUAGE = eINSTANCE.getOpaqueExpression_Language();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__INIT_EXPRESSION = eINSTANCE.getVariable_InitExpression();

		/**
		 * The meta object literal for the '<em><b>Represented Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__REPRESENTED_PARAMETER = eINSTANCE.getVariable_RepresentedParameter();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Initialiser Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVariable__ValidateCompatibleInitialiserType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__IMPLICIT = eINSTANCE.getVariable_Implicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IfExpImpl <em>If Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.IfExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIfExp()
		 * @generated
		 */
		EClass IF_EXP = eINSTANCE.getIfExp();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP__CONDITION = eINSTANCE.getIfExp_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP__THEN_EXPRESSION = eINSTANCE.getIfExp_ThenExpression();

		/**
		 * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP__ELSE_EXPRESSION = eINSTANCE.getIfExp_ElseExpression();

		/**
		 * The meta object literal for the '<em><b>Validate Condition Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IF_EXP___VALIDATE_CONDITION_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIfExp__ValidateConditionTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ImportImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Imported Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.IntegerLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIntegerLiteralExp()
		 * @generated
		 */
		EClass INTEGER_LITERAL_EXP = eINSTANCE.getIntegerLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Integer Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL_EXP__INTEGER_SYMBOL = eINSTANCE.getIntegerLiteralExp_IntegerSymbol();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Integer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTEGER_LITERAL_EXP___VALIDATE_TYPE_IS_INTEGER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIntegerLiteralExp__ValidateTypeIsInteger__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.NumericLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNumericLiteralExp()
		 * @generated
		 */
		EClass NUMERIC_LITERAL_EXP = eINSTANCE.getNumericLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.InvalidLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInvalidLiteralExp()
		 * @generated
		 */
		EClass INVALID_LITERAL_EXP = eINSTANCE.getInvalidLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.InvalidTypeImpl <em>Invalid Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.InvalidTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInvalidType()
		 * @generated
		 */
		EClass INVALID_TYPE = eINSTANCE.getInvalidType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.IterateExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIterateExp()
		 * @generated
		 */
		EClass ITERATE_EXP = eINSTANCE.getIterateExp();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE_EXP__RESULT = eINSTANCE.getIterateExp_Result();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Result Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATE_EXP___VALIDATE_TYPE_IS_RESULT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIterateExp__ValidateTypeIsResultType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Body Type Conforms To Result Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATE_EXP___VALIDATE_BODY_TYPE_CONFORMS_TO_RESULT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIterateExp__ValidateBodyTypeConformsToResultType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate One Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATE_EXP___VALIDATE_ONE_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIterateExp__ValidateOneInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IterationImpl <em>Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.IterationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIteration()
		 * @generated
		 */
		EClass ITERATION = eINSTANCE.getIteration();

		/**
		 * The meta object literal for the '<em><b>Owned Iterator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__OWNED_ITERATOR = eINSTANCE.getIteration_OwnedIterator();

		/**
		 * The meta object literal for the '<em><b>Owned Accumulator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__OWNED_ACCUMULATOR = eINSTANCE.getIteration_OwnedAccumulator();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.IteratorExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getIteratorExp()
		 * @generated
		 */
		EClass ITERATOR_EXP = eINSTANCE.getIteratorExp();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Body Type Is Conformantto Iterator Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_BODY_TYPE_IS_CONFORMANTTO_ITERATOR_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureBodyTypeIsConformanttoIteratorType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Sorted By Iterator Type Is Comparable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_SORTED_BY_ITERATOR_TYPE_IS_COMPARABLE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateSortedByIteratorTypeIsComparable__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Any Has One Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ANY_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateAnyHasOneIterator__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Any Type Is Source Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ANY_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateAnyTypeIsSourceElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Any Body Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ANY_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateAnyBodyTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Has One Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureHasOneIterator__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Type Is Unique Collection</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_TYPE_IS_UNIQUE_COLLECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureTypeIsUniqueCollection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Source Element Type Is Body Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_SOURCE_ELEMENT_TYPE_IS_BODY_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureSourceElementTypeIsBodyElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Element Type Is Source Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureElementTypeIsSourceElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Collect Has One Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_COLLECT_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateCollectHasOneIterator__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Collect Type Is Unordered</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_COLLECT_TYPE_IS_UNORDERED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateCollectTypeIsUnordered__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Collect Element Type Is Source Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_COLLECT_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateCollectElementTypeIsSourceElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Collect Nested Has One Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_COLLECT_NESTED_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateCollectNestedHasOneIterator__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Collect Nested Type Is Bag</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_COLLECT_NESTED_TYPE_IS_BAG__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateCollectNestedTypeIsBag__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Collect Nested Type Is Body Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_COLLECT_NESTED_TYPE_IS_BODY_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateCollectNestedTypeIsBodyType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Exists Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_EXISTS_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateExistsTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Exists Body Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_EXISTS_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateExistsBodyTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate For All Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_FOR_ALL_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateForAllTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate For All Body Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_FOR_ALL_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateForAllBodyTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Is Unique Has One Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_IS_UNIQUE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateIsUniqueHasOneIterator__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Is Unique Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_IS_UNIQUE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateIsUniqueTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate One Has One Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ONE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateOneHasOneIterator__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate One Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ONE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateOneTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate One Body Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ONE_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateOneBodyTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Reject Or Select Has One Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateRejectOrSelectHasOneIterator__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Reject Or Select Type Is Source Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_TYPE_IS_SOURCE_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateRejectOrSelectTypeIsSourceType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Reject Or Select Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateRejectOrSelectTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Sorted By Has One Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_SORTED_BY_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateSortedByHasOneIterator__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Sorted By Is Ordered If Source Is Ordered</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_SORTED_BY_IS_ORDERED_IF_SOURCE_IS_ORDERED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateSortedByIsOrderedIfSourceIsOrdered__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Sorted By Element Type Is Source Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_SORTED_BY_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateSortedByElementTypeIsSourceElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Iterator Type Is Source Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ITERATOR_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateIteratorTypeIsSourceElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LambdaTypeImpl <em>Lambda Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.LambdaTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLambdaType()
		 * @generated
		 */
		EClass LAMBDA_TYPE = eINSTANCE.getLambdaType();

		/**
		 * The meta object literal for the '<em><b>Context Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE__CONTEXT_TYPE = eINSTANCE.getLambdaType_ContextType();

		/**
		 * The meta object literal for the '<em><b>Parameter Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE__PARAMETER_TYPE = eINSTANCE.getLambdaType_ParameterType();

		/**
		 * The meta object literal for the '<em><b>Result Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE__RESULT_TYPE = eINSTANCE.getLambdaType_ResultType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LetExpImpl <em>Let Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.LetExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLetExp()
		 * @generated
		 */
		EClass LET_EXP = eINSTANCE.getLetExp();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP__IN = eINSTANCE.getLetExp_In();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP__VARIABLE = eINSTANCE.getLetExp_Variable();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is In Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LET_EXP___VALIDATE_TYPE_IS_IN_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLetExp__ValidateTypeIsInType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.LibraryImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Owned Precedence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__OWNED_PRECEDENCE = eINSTANCE.getLibrary_OwnedPrecedence();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.LoopExpImpl <em>Loop Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.LoopExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLoopExp()
		 * @generated
		 */
		EClass LOOP_EXP = eINSTANCE.getLoopExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__BODY = eINSTANCE.getLoopExp_Body();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__ITERATOR = eINSTANCE.getLoopExp_Iterator();

		/**
		 * The meta object literal for the '<em><b>Referred Iteration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__REFERRED_ITERATION = eINSTANCE.getLoopExp_ReferredIteration();

		/**
		 * The meta object literal for the '<em><b>Validate Source Is Collection</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOP_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLoopExp__ValidateSourceIsCollection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate No Initializers</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOP_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLoopExp__ValidateNoInitializers__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl <em>Message Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMessageExp()
		 * @generated
		 */
		EClass MESSAGE_EXP = eINSTANCE.getMessageExp();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__TARGET = eINSTANCE.getMessageExp_Target();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__ARGUMENT = eINSTANCE.getMessageExp_Argument();

		/**
		 * The meta object literal for the '<em><b>Called Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__CALLED_OPERATION = eINSTANCE.getMessageExp_CalledOperation();

		/**
		 * The meta object literal for the '<em><b>Sent Signal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__SENT_SIGNAL = eINSTANCE.getMessageExp_SentSignal();

		/**
		 * The meta object literal for the '<em><b>Validate One Call Or One Send</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MESSAGE_EXP___VALIDATE_ONE_CALL_OR_ONE_SEND__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMessageExp__ValidateOneCallOrOneSend__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Target Is Not ACollection</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MESSAGE_EXP___VALIDATE_TARGET_IS_NOT_ACOLLECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMessageExp__ValidateTargetIsNotACollection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SendSignalActionImpl <em>Send Signal Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.SendSignalActionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSendSignalAction()
		 * @generated
		 */
		EClass SEND_SIGNAL_ACTION = eINSTANCE.getSendSignalAction();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_SIGNAL_ACTION__SIGNAL = eINSTANCE.getSendSignalAction_Signal();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SignalImpl <em>Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.SignalImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSignal()
		 * @generated
		 */
		EClass SIGNAL = eINSTANCE.getSignal();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageTypeImpl <em>Message Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.MessageTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMessageType()
		 * @generated
		 */
		EClass MESSAGE_TYPE = eINSTANCE.getMessageType();

		/**
		 * The meta object literal for the '<em><b>Referred Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_TYPE__REFERRED_SIGNAL = eINSTANCE.getMessageType_ReferredSignal();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_TYPE__REFERRED_OPERATION = eINSTANCE.getMessageType_ReferredOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.MetaclassImpl <em>Metaclass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.MetaclassImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMetaclass()
		 * @generated
		 */
		EClass METACLASS = eINSTANCE.getMetaclass();

		/**
		 * The meta object literal for the '<em><b>Instance Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METACLASS__INSTANCE_TYPE = eINSTANCE.getMetaclass_InstanceType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.util.MorePivotable <em>More Pivotable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.util.MorePivotable
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getMorePivotable()
		 * @generated
		 */
		EClass MORE_PIVOTABLE = eINSTANCE.getMorePivotable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.NullLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNullLiteralExp()
		 * @generated
		 */
		EClass NULL_LITERAL_EXP = eINSTANCE.getNullLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationCallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperationCallExp()
		 * @generated
		 */
		EClass OPERATION_CALL_EXP = eINSTANCE.getOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__ARGUMENT = eINSTANCE.getOperationCallExp_Argument();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__REFERRED_OPERATION = eINSTANCE.getOperationCallExp_ReferredOperation();

		/**
		 * The meta object literal for the '<em><b>Validate Argument Type Is Conformant</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION_CALL_EXP___VALIDATE_ARGUMENT_TYPE_IS_CONFORMANT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperationCallExp__ValidateArgumentTypeIsConformant__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Argument Count</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION_CALL_EXP___VALIDATE_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperationCallExp__ValidateArgumentCount__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OrderedSetTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOrderedSetType()
		 * @generated
		 */
		EClass ORDERED_SET_TYPE = eINSTANCE.getOrderedSetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageableElementImpl <em>Packageable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PackageableElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPackageableElement()
		 * @generated
		 */
		EClass PACKAGEABLE_ELEMENT = eINSTANCE.getPackageableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrimitiveTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ProfileImpl <em>Profile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ProfileImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getProfile()
		 * @generated
		 */
		EClass PROFILE = eINSTANCE.getProfile();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILE__APPLICATION = eINSTANCE.getProfile_Application();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ProfileApplicationImpl <em>Profile Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ProfileApplicationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getProfileApplication()
		 * @generated
		 */
		EClass PROFILE_APPLICATION = eINSTANCE.getProfileApplication();

		/**
		 * The meta object literal for the '<em><b>Applied Profile</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILE_APPLICATION__APPLIED_PROFILE = eINSTANCE.getProfileApplication_AppliedProfile();

		/**
		 * The meta object literal for the '<em><b>Applying Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILE_APPLICATION__APPLYING_PACKAGE = eINSTANCE.getProfileApplication_ApplyingPackage();

		/**
		 * The meta object literal for the '<em><b>Is Strict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_APPLICATION__IS_STRICT = eINSTANCE.getProfileApplication_IsStrict();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PropertyCallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPropertyCallExp()
		 * @generated
		 */
		EClass PROPERTY_CALL_EXP = eINSTANCE.getPropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CALL_EXP__REFERRED_PROPERTY = eINSTANCE.getPropertyCallExp_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Get Specialized Referred Property Owning Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_CALL_EXP___GET_SPECIALIZED_REFERRED_PROPERTY_OWNING_TYPE = eINSTANCE.getPropertyCallExp__GetSpecializedReferredPropertyOwningType();

		/**
		 * The meta object literal for the '<em><b>Get Specialized Referred Property Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_CALL_EXP___GET_SPECIALIZED_REFERRED_PROPERTY_TYPE = eINSTANCE.getPropertyCallExp__GetSpecializedReferredPropertyType();

		/**
		 * The meta object literal for the '<em><b>Validate Non Static Source Type Is Conformant</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_CALL_EXP___VALIDATE_NON_STATIC_SOURCE_TYPE_IS_CONFORMANT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyCallExp__ValidateNonStaticSourceTypeIsConformant__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Result Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_CALL_EXP___VALIDATE_COMPATIBLE_RESULT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyCallExp__ValidateCompatibleResultType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PseudostateImpl <em>Pseudostate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PseudostateImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPseudostate()
		 * @generated
		 */
		EClass PSEUDOSTATE = eINSTANCE.getPseudostate();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PSEUDOSTATE__KIND = eINSTANCE.getPseudostate_Kind();

		/**
		 * The meta object literal for the '<em><b>State Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSEUDOSTATE__STATE_MACHINE = eINSTANCE.getPseudostate_StateMachine();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSEUDOSTATE__STATE = eINSTANCE.getPseudostate_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.RealLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getRealLiteralExp()
		 * @generated
		 */
		EClass REAL_LITERAL_EXP = eINSTANCE.getRealLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Real Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL_EXP__REAL_SYMBOL = eINSTANCE.getRealLiteralExp_RealSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.ReferringElement <em>Referring Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.ReferringElement
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getReferringElement()
		 * @generated
		 */
		EClass REFERRING_ELEMENT = eINSTANCE.getReferringElement();

		/**
		 * The meta object literal for the '<em><b>Get Referred Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REFERRING_ELEMENT___GET_REFERRED_ELEMENT = eINSTANCE.getReferringElement__GetReferredElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.RegionImpl <em>Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.RegionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getRegion()
		 * @generated
		 */
		EClass REGION = eINSTANCE.getRegion();

		/**
		 * The meta object literal for the '<em><b>Subvertex</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__SUBVERTEX = eINSTANCE.getRegion_Subvertex();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__TRANSITION = eINSTANCE.getRegion_Transition();

		/**
		 * The meta object literal for the '<em><b>State Machine</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__STATE_MACHINE = eINSTANCE.getRegion_StateMachine();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__STATE = eINSTANCE.getRegion_State();

		/**
		 * The meta object literal for the '<em><b>Extended Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__EXTENDED_REGION = eINSTANCE.getRegion_ExtendedRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.RootImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Nested Package</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__NESTED_PACKAGE = eINSTANCE.getRoot_NestedPackage();

		/**
		 * The meta object literal for the '<em><b>External URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT__EXTERNAL_URI = eINSTANCE.getRoot_ExternalURI();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__IMPORTS = eINSTANCE.getRoot_Imports();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SelfTypeImpl <em>Self Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.SelfTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSelfType()
		 * @generated
		 */
		EClass SELF_TYPE = eINSTANCE.getSelfType();

		/**
		 * The meta object literal for the '<em><b>Specialize In</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SELF_TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE_1 = eINSTANCE.getSelfType__SpecializeIn__OCLExpression_Type_1();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.SequenceTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSequenceType()
		 * @generated
		 */
		EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.SetTypeImpl <em>Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.SetTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getSetType()
		 * @generated
		 */
		EClass SET_TYPE = eINSTANCE.getSetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.StateImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Is Composite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__IS_COMPOSITE = eINSTANCE.getState_IsComposite();

		/**
		 * The meta object literal for the '<em><b>Is Orthogonal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__IS_ORTHOGONAL = eINSTANCE.getState_IsOrthogonal();

		/**
		 * The meta object literal for the '<em><b>Is Simple</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__IS_SIMPLE = eINSTANCE.getState_IsSimple();

		/**
		 * The meta object literal for the '<em><b>Is Submachine State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__IS_SUBMACHINE_STATE = eINSTANCE.getState_IsSubmachineState();

		/**
		 * The meta object literal for the '<em><b>Submachine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__SUBMACHINE = eINSTANCE.getState_Submachine();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__CONNECTION = eINSTANCE.getState_Connection();

		/**
		 * The meta object literal for the '<em><b>Redefined State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__REDEFINED_STATE = eINSTANCE.getState_RedefinedState();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__REGION = eINSTANCE.getState_Region();

		/**
		 * The meta object literal for the '<em><b>State Invariant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__STATE_INVARIANT = eINSTANCE.getState_StateInvariant();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__ENTRY = eINSTANCE.getState_Entry();

		/**
		 * The meta object literal for the '<em><b>Exit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__EXIT = eINSTANCE.getState_Exit();

		/**
		 * The meta object literal for the '<em><b>Do Activity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__DO_ACTIVITY = eINSTANCE.getState_DoActivity();

		/**
		 * The meta object literal for the '<em><b>Connection Point</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__CONNECTION_POINT = eINSTANCE.getState_ConnectionPoint();

		/**
		 * The meta object literal for the '<em><b>Deferrable Trigger</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__DEFERRABLE_TRIGGER = eINSTANCE.getState_DeferrableTrigger();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StateExpImpl <em>State Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.StateExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStateExp()
		 * @generated
		 */
		EClass STATE_EXP = eINSTANCE.getStateExp();

		/**
		 * The meta object literal for the '<em><b>Referred State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_EXP__REFERRED_STATE = eINSTANCE.getStateExp_ReferredState();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StateMachineImpl <em>State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.StateMachineImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStateMachine()
		 * @generated
		 */
		EClass STATE_MACHINE = eINSTANCE.getStateMachine();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__REGION = eINSTANCE.getStateMachine_Region();

		/**
		 * The meta object literal for the '<em><b>Connection Point</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__CONNECTION_POINT = eINSTANCE.getStateMachine_ConnectionPoint();

		/**
		 * The meta object literal for the '<em><b>Extended State Machine</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__EXTENDED_STATE_MACHINE = eINSTANCE.getStateMachine_ExtendedStateMachine();

		/**
		 * The meta object literal for the '<em><b>Submachine State</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__SUBMACHINE_STATE = eINSTANCE.getStateMachine_SubmachineState();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StereotypeImpl <em>Stereotype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.StereotypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStereotype()
		 * @generated
		 */
		EClass STEREOTYPE = eINSTANCE.getStereotype();

		/**
		 * The meta object literal for the '<em><b>Extension Ofs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEREOTYPE__EXTENSION_OFS = eINSTANCE.getStereotype_ExtensionOfs();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.StringLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getStringLiteralExp()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP = eINSTANCE.getStringLiteralExp();

		/**
		 * The meta object literal for the '<em><b>String Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP__STRING_SYMBOL = eINSTANCE.getStringLiteralExp_StringSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterTypeImpl <em>Template Parameter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameterType()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_TYPE = eINSTANCE.getTemplateParameterType();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_PARAMETER_TYPE__SPECIFICATION = eINSTANCE.getTemplateParameterType_Specification();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleLiteralExp()
		 * @generated
		 */
		EClass TUPLE_LITERAL_EXP = eINSTANCE.getTupleLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_LITERAL_EXP__PART = eINSTANCE.getTupleLiteralExp_Part();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleLiteralPartImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleLiteralPart()
		 * @generated
		 */
		EClass TUPLE_LITERAL_PART = eINSTANCE.getTupleLiteralPart();

		/**
		 * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_LITERAL_PART__INIT_EXPRESSION = eINSTANCE.getTupleLiteralPart_InitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TupleTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTupleType()
		 * @generated
		 */
		EClass TUPLE_TYPE = eINSTANCE.getTupleType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeExpImpl <em>Type Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypeExp()
		 * @generated
		 */
		EClass TYPE_EXP = eINSTANCE.getTypeExp();

		/**
		 * The meta object literal for the '<em><b>Referred Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_EXP__REFERRED_TYPE = eINSTANCE.getTypeExp_ReferredType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeExtensionImpl <em>Type Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeExtensionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypeExtension()
		 * @generated
		 */
		EClass TYPE_EXTENSION = eINSTANCE.getTypeExtension();

		/**
		 * The meta object literal for the '<em><b>Is Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_EXTENSION__IS_REQUIRED = eINSTANCE.getTypeExtension_IsRequired();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_EXTENSION__STEREOTYPE = eINSTANCE.getTypeExtension_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_EXTENSION__TYPE = eINSTANCE.getTypeExtension_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnlimitedNaturalLiteralExpImpl <em>Unlimited Natural Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnlimitedNaturalLiteralExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnlimitedNaturalLiteralExp()
		 * @generated
		 */
		EClass UNLIMITED_NATURAL_LITERAL_EXP = eINSTANCE.getUnlimitedNaturalLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Unlimited Natural Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL = eINSTANCE.getUnlimitedNaturalLiteralExp_UnlimitedNaturalSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedTypeImpl <em>Unspecified Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnspecifiedType()
		 * @generated
		 */
		EClass UNSPECIFIED_TYPE = eINSTANCE.getUnspecifiedType();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSPECIFIED_TYPE__LOWER_BOUND = eINSTANCE.getUnspecifiedType_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSPECIFIED_TYPE__UPPER_BOUND = eINSTANCE.getUnspecifiedType_UpperBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.UnspecifiedValueExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnspecifiedValueExp()
		 * @generated
		 */
		EClass UNSPECIFIED_VALUE_EXP = eINSTANCE.getUnspecifiedValueExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl <em>Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariableExp()
		 * @generated
		 */
		EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_EXP__REFERRED_VARIABLE = eINSTANCE.getVariableExp_ReferredVariable();

		/**
		 * The meta object literal for the '<em><b>Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_EXP__IMPLICIT = eINSTANCE.getVariableExp_Implicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VertexImpl <em>Vertex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.VertexImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVertex()
		 * @generated
		 */
		EClass VERTEX = eINSTANCE.getVertex();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__CONTAINER = eINSTANCE.getVertex_Container();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__OUTGOING = eINSTANCE.getVertex_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__INCOMING = eINSTANCE.getVertex_Incoming();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VoidTypeImpl <em>Void Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.VoidTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVoidType()
		 * @generated
		 */
		EClass VOID_TYPE = eINSTANCE.getVoidType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.util.Pivotable <em>Pivotable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.util.Pivotable
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPivotable()
		 * @generated
		 */
		EClass PIVOTABLE = eINSTANCE.getPivotable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.util.Visitable <em>Visitable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.util.Visitable
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVisitable()
		 * @generated
		 */
		EClass VISITABLE = eINSTANCE.getVisitable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_ABSTRACT = eINSTANCE.getClass_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Is Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_ACTIVE = eINSTANCE.getClass_IsActive();

		/**
		 * The meta object literal for the '<em><b>Owned Behavior</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_BEHAVIOR = eINSTANCE.getClass_OwnedBehavior();

		/**
		 * The meta object literal for the '<em><b>Is Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_INTERFACE = eINSTANCE.getClass_IsInterface();

		/**
		 * The meta object literal for the '<em><b>Nested Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__NESTED_TYPE = eINSTANCE.getClass_NestedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Extended Bys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__EXTENDED_BYS = eINSTANCE.getType_ExtendedBys();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__PACKAGE = eINSTANCE.getType_Package();

		/**
		 * The meta object literal for the '<em><b>Owned Attribute</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__OWNED_ATTRIBUTE = eINSTANCE.getType_OwnedAttribute();

		/**
		 * The meta object literal for the '<em><b>Owned Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__OWNED_OPERATION = eINSTANCE.getType_OwnedOperation();

		/**
		 * The meta object literal for the '<em><b>Super Class</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__SUPER_CLASS = eINSTANCE.getType_SuperClass();

		/**
		 * The meta object literal for the '<em><b>Owned Invariant</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__OWNED_INVARIANT = eINSTANCE.getType_OwnedInvariant();

		/**
		 * The meta object literal for the '<em><b>Instance Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__INSTANCE_CLASS_NAME = eINSTANCE.getType_InstanceClassName();

		/**
		 * The meta object literal for the '<em><b>Specialize In</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___SPECIALIZE_IN__OCLEXPRESSION_TYPE = eINSTANCE.getType__SpecializeIn__OCLExpression_Type();

		/**
		 * The meta object literal for the '<em><b>Validate Unique Invariant Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getType__ValidateUniqueInvariantName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateableElementImpl <em>Templateable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateableElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateableElement()
		 * @generated
		 */
		EClass TEMPLATEABLE_ELEMENT = eINSTANCE.getTemplateableElement();

		/**
		 * The meta object literal for the '<em><b>Template Binding</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATEABLE_ELEMENT__TEMPLATE_BINDING = eINSTANCE.getTemplateableElement_TemplateBinding();

		/**
		 * The meta object literal for the '<em><b>Owned Template Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE = eINSTANCE.getTemplateableElement_OwnedTemplateSignature();

		/**
		 * The meta object literal for the '<em><b>Unspecialized Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATEABLE_ELEMENT__UNSPECIALIZED_ELEMENT = eINSTANCE.getTemplateableElement_UnspecializedElement();

		/**
		 * The meta object literal for the '<em><b>Parameterable Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEMPLATEABLE_ELEMENT___PARAMETERABLE_ELEMENTS = eINSTANCE.getTemplateableElement__ParameterableElements();

		/**
		 * The meta object literal for the '<em><b>Is Template</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEMPLATEABLE_ELEMENT___IS_TEMPLATE = eINSTANCE.getTemplateableElement__IsTemplate();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TransitionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__KIND = eINSTANCE.getTransition_Kind();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__CONTAINER = eINSTANCE.getTransition_Container();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__EFFECT = eINSTANCE.getTransition_Effect();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TRIGGER = eINSTANCE.getTransition_Trigger();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TriggerImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTrigger()
		 * @generated
		 */
		EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__STATE = eINSTANCE.getTrigger_State();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__TRANSITION = eINSTANCE.getTrigger_Transition();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateBindingImpl <em>Template Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateBindingImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateBinding()
		 * @generated
		 */
		EClass TEMPLATE_BINDING = eINSTANCE.getTemplateBinding();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING__SIGNATURE = eINSTANCE.getTemplateBinding_Signature();

		/**
		 * The meta object literal for the '<em><b>Parameter Substitution</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING__PARAMETER_SUBSTITUTION = eINSTANCE.getTemplateBinding_ParameterSubstitution();

		/**
		 * The meta object literal for the '<em><b>Bound Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING__BOUND_ELEMENT = eINSTANCE.getTemplateBinding_BoundElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateSignatureImpl <em>Template Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateSignatureImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateSignature()
		 * @generated
		 */
		EClass TEMPLATE_SIGNATURE = eINSTANCE.getTemplateSignature();

		/**
		 * The meta object literal for the '<em><b>Owned Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE__OWNED_PARAMETER = eINSTANCE.getTemplateSignature_OwnedParameter();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE__TEMPLATE = eINSTANCE.getTemplateSignature_Template();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterImpl <em>Template Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameter()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER = eINSTANCE.getTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__SIGNATURE = eINSTANCE.getTemplateParameter_Signature();

		/**
		 * The meta object literal for the '<em><b>Parametered Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__PARAMETERED_ELEMENT = eINSTANCE.getTemplateParameter_ParameteredElement();

		/**
		 * The meta object literal for the '<em><b>Owned Parametered Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT = eINSTANCE.getTemplateParameter_OwnedParameteredElement();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__DEFAULT = eINSTANCE.getTemplateParameter_Default();

		/**
		 * The meta object literal for the '<em><b>Owned Default</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__OWNED_DEFAULT = eINSTANCE.getTemplateParameter_OwnedDefault();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ParameterableElementImpl <em>Parameterable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ParameterableElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getParameterableElement()
		 * @generated
		 */
		EClass PARAMETERABLE_ELEMENT = eINSTANCE.getParameterableElement();

		/**
		 * The meta object literal for the '<em><b>Owning Template Parameter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER = eINSTANCE.getParameterableElement_OwningTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Template Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER = eINSTANCE.getParameterableElement_TemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Is Template Parameter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERABLE_ELEMENT___IS_TEMPLATE_PARAMETER = eINSTANCE.getParameterableElement__IsTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Is Compatible With</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETERABLE_ELEMENT___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = eINSTANCE.getParameterableElement__IsCompatibleWith__ParameterableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl <em>Template Parameter Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTemplateParameterSubstitution()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_SUBSTITUTION = eINSTANCE.getTemplateParameterSubstitution();

		/**
		 * The meta object literal for the '<em><b>Formal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL = eINSTANCE.getTemplateParameterSubstitution_Formal();

		/**
		 * The meta object literal for the '<em><b>Actual</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL = eINSTANCE.getTemplateParameterSubstitution_Actual();

		/**
		 * The meta object literal for the '<em><b>Owned Actual</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL = eINSTANCE.getTemplateParameterSubstitution_OwnedActual();

		/**
		 * The meta object literal for the '<em><b>Template Binding</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING = eINSTANCE.getTemplateParameterSubstitution_TemplateBinding();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Nested Package</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__NESTED_PACKAGE = eINSTANCE.getPackage_NestedPackage();

		/**
		 * The meta object literal for the '<em><b>Nesting Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__NESTING_PACKAGE = eINSTANCE.getPackage_NestingPackage();

		/**
		 * The meta object literal for the '<em><b>Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE__NS_PREFIX = eINSTANCE.getPackage_NsPrefix();

		/**
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE__NS_URI = eINSTANCE.getPackage_NsURI();

		/**
		 * The meta object literal for the '<em><b>Imported Package</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__IMPORTED_PACKAGE = eINSTANCE.getPackage_ImportedPackage();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_TYPE = eINSTANCE.getPackage_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Profile Application</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__PROFILE_APPLICATION = eINSTANCE.getPackage_ProfileApplication();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NamespaceImpl <em>Namespace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.NamespaceImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNamespace()
		 * @generated
		 */
		EClass NAMESPACE = eINSTANCE.getNamespace();

		/**
		 * The meta object literal for the '<em><b>Owned Rule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMESPACE__OWNED_RULE = eINSTANCE.getNamespace_OwnedRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PrecedenceImpl <em>Precedence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PrecedenceImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPrecedence()
		 * @generated
		 */
		EClass PRECEDENCE = eINSTANCE.getPrecedence();

		/**
		 * The meta object literal for the '<em><b>Associativity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRECEDENCE__ASSOCIATIVITY = eINSTANCE.getPrecedence_Associativity();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRECEDENCE__ORDER = eINSTANCE.getPrecedence_Order();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl <em>Type Template Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypeTemplateParameter()
		 * @generated
		 */
		EClass TYPE_TEMPLATE_PARAMETER = eINSTANCE.getTypeTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Allow Substitutable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TEMPLATE_PARAMETER__ALLOW_SUBSTITUTABLE = eINSTANCE.getTypeTemplateParameter_AllowSubstitutable();

		/**
		 * The meta object literal for the '<em><b>Constraining Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_TEMPLATE_PARAMETER__CONSTRAINING_TYPE = eINSTANCE.getTypeTemplateParameter_ConstrainingType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Association Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__ASSOCIATION_CLASS = eINSTANCE.getProperty_AssociationClass();

		/**
		 * The meta object literal for the '<em><b>Is Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_READ_ONLY = eINSTANCE.getProperty_IsReadOnly();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__DEFAULT = eINSTANCE.getProperty_Default();

		/**
		 * The meta object literal for the '<em><b>Is Composite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_COMPOSITE = eINSTANCE.getProperty_IsComposite();

		/**
		 * The meta object literal for the '<em><b>Is Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_DERIVED = eINSTANCE.getProperty_IsDerived();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__OPPOSITE = eINSTANCE.getProperty_Opposite();

		/**
		 * The meta object literal for the '<em><b>Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IMPLICIT = eINSTANCE.getProperty_Implicit();

		/**
		 * The meta object literal for the '<em><b>Default Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__DEFAULT_EXPRESSION = eINSTANCE.getProperty_DefaultExpression();

		/**
		 * The meta object literal for the '<em><b>Is ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_ID = eINSTANCE.getProperty_IsID();

		/**
		 * The meta object literal for the '<em><b>Keys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__KEYS = eINSTANCE.getProperty_Keys();

		/**
		 * The meta object literal for the '<em><b>Is Resolve Proxies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_RESOLVE_PROXIES = eINSTANCE.getProperty_IsResolveProxies();

		/**
		 * The meta object literal for the '<em><b>Is Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_TRANSIENT = eINSTANCE.getProperty_IsTransient();

		/**
		 * The meta object literal for the '<em><b>Is Unsettable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_UNSETTABLE = eINSTANCE.getProperty_IsUnsettable();

		/**
		 * The meta object literal for the '<em><b>Is Volatile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_VOLATILE = eINSTANCE.getProperty_IsVolatile();

		/**
		 * The meta object literal for the '<em><b>Redefined Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__REDEFINED_PROPERTY = eINSTANCE.getProperty_RedefinedProperty();

		/**
		 * The meta object literal for the '<em><b>Subsetted Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__SUBSETTED_PROPERTY = eINSTANCE.getProperty_SubsettedProperty();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__REFERRED_PROPERTY = eINSTANCE.getProperty_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Owning Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__OWNING_TYPE = eINSTANCE.getProperty_OwningType();

		/**
		 * The meta object literal for the '<em><b>Is Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY___IS_ATTRIBUTE__PROPERTY = eINSTANCE.getProperty__IsAttribute__Property();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Default Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY___VALIDATE_COMPATIBLE_DEFAULT_EXPRESSION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getProperty__ValidateCompatibleDefaultExpression__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__CLASS = eINSTANCE.getProperty_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '<em><b>Is Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__IS_REQUIRED = eINSTANCE.getTypedElement_IsRequired();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl <em>Typed Multiplicity Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTypedMultiplicityElement()
		 * @generated
		 */
		EClass TYPED_MULTIPLICITY_ELEMENT = eINSTANCE.getTypedMultiplicityElement();

		/**
		 * The meta object literal for the '<em><b>Compatible Body</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPED_MULTIPLICITY_ELEMENT___COMPATIBLE_BODY__VALUESPECIFICATION = eINSTANCE.getTypedMultiplicityElement__CompatibleBody__ValueSpecification();

		/**
		 * The meta object literal for the '<em><b>Make Parameter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPED_MULTIPLICITY_ELEMENT___MAKE_PARAMETER = eINSTANCE.getTypedMultiplicityElement__MakeParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassImpl <em>Association Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociationClass()
		 * @generated
		 */
		EClass ASSOCIATION_CLASS = eINSTANCE.getAssociationClass();

		/**
		 * The meta object literal for the '<em><b>Unowned Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE = eINSTANCE.getAssociationClass_UnownedAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Raised Exception</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__RAISED_EXCEPTION = eINSTANCE.getOperation_RaisedException();

		/**
		 * The meta object literal for the '<em><b>Owned Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNED_PARAMETER = eINSTANCE.getOperation_OwnedParameter();

		/**
		 * The meta object literal for the '<em><b>Owning Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNING_TYPE = eINSTANCE.getOperation_OwningType();

		/**
		 * The meta object literal for the '<em><b>Precondition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PRECONDITION = eINSTANCE.getOperation_Precondition();

		/**
		 * The meta object literal for the '<em><b>Postcondition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__POSTCONDITION = eINSTANCE.getOperation_Postcondition();

		/**
		 * The meta object literal for the '<em><b>Body Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__BODY_EXPRESSION = eINSTANCE.getOperation_BodyExpression();

		/**
		 * The meta object literal for the '<em><b>Is Invalidating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__IS_INVALIDATING = eINSTANCE.getOperation_IsInvalidating();

		/**
		 * The meta object literal for the '<em><b>Is Validating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__IS_VALIDATING = eINSTANCE.getOperation_IsValidating();

		/**
		 * The meta object literal for the '<em><b>Precedence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PRECEDENCE = eINSTANCE.getOperation_Precedence();

		/**
		 * The meta object literal for the '<em><b>Redefined Operation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__REDEFINED_OPERATION = eINSTANCE.getOperation_RedefinedOperation();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__CLASS = eINSTANCE.getOperation_Class();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Return</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___VALIDATE_COMPATIBLE_RETURN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperation__ValidateCompatibleReturn__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Loadable Implementation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___VALIDATE_LOADABLE_IMPLEMENTATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperation__ValidateLoadableImplementation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unique Precondition Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___VALIDATE_UNIQUE_PRECONDITION_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperation__ValidateUniquePreconditionName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unique Postcondition Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___VALIDATE_UNIQUE_POSTCONDITION_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperation__ValidateUniquePostconditionName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ParameterImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__OPERATION = eINSTANCE.getParameter_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.VariableDeclarationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationTemplateParameterImpl <em>Operation Template Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OperationTemplateParameterImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOperationTemplateParameter()
		 * @generated
		 */
		EClass OPERATION_TEMPLATE_PARAMETER = eINSTANCE.getOperationTemplateParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.OppositePropertyCallExpImpl <em>Opposite Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.OppositePropertyCallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getOppositePropertyCallExp()
		 * @generated
		 */
		EClass OPPOSITE_PROPERTY_CALL_EXP = eINSTANCE.getOppositePropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPPOSITE_PROPERTY_CALL_EXP__REFERRED_PROPERTY = eINSTANCE.getOppositePropertyCallExp_ReferredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CommentImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__BODY = eINSTANCE.getComment_Body();

		/**
		 * The meta object literal for the '<em><b>Annotated Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMENT__ANNOTATED_ELEMENT = eINSTANCE.getComment_AnnotatedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ConnectionPointReferenceImpl <em>Connection Point Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ConnectionPointReferenceImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getConnectionPointReference()
		 * @generated
		 */
		EClass CONNECTION_POINT_REFERENCE = eINSTANCE.getConnectionPointReference();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_POINT_REFERENCE__ENTRY = eINSTANCE.getConnectionPointReference_Entry();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_POINT_REFERENCE__STATE = eINSTANCE.getConnectionPointReference_State();

		/**
		 * The meta object literal for the '<em><b>Exit</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_POINT_REFERENCE__EXIT = eINSTANCE.getConnectionPointReference_Exit();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ConstraintImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Constrained Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__CONSTRAINED_ELEMENT = eINSTANCE.getConstraint_ConstrainedElement();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__SPECIFICATION = eINSTANCE.getConstraint_Specification();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__TRANSITION = eINSTANCE.getConstraint_Transition();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__CONTEXT = eINSTANCE.getConstraint_Context();

		/**
		 * The meta object literal for the '<em><b>Is Callable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__IS_CALLABLE = eINSTANCE.getConstraint_IsCallable();

		/**
		 * The meta object literal for the '<em><b>Owning State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__OWNING_STATE = eINSTANCE.getConstraint_OwningState();

		/**
		 * The meta object literal for the '<em><b>Redefined Constraint</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__REDEFINED_CONSTRAINT = eINSTANCE.getConstraint_RedefinedConstraint();

		/**
		 * The meta object literal for the '<em><b>Validate Unique Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONSTRAINT___VALIDATE_UNIQUE_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getConstraint__ValidateUniqueName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ConstructorExpImpl <em>Constructor Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ConstructorExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getConstructorExp()
		 * @generated
		 */
		EClass CONSTRUCTOR_EXP = eINSTANCE.getConstructorExp();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR_EXP__PART = eINSTANCE.getConstructorExp_Part();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRUCTOR_EXP__VALUE = eINSTANCE.getConstructorExp_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ConstructorPartImpl <em>Constructor Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ConstructorPartImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getConstructorPart()
		 * @generated
		 */
		EClass CONSTRUCTOR_PART = eINSTANCE.getConstructorPart();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR_PART__REFERRED_PROPERTY = eINSTANCE.getConstructorPart_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR_PART__INIT_EXPRESSION = eINSTANCE.getConstructorPart_InitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.ValueSpecificationImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getValueSpecification()
		 * @generated
		 */
		EClass VALUE_SPECIFICATION = eINSTANCE.getValueSpecification();

		/**
		 * The meta object literal for the '<em><b>Is Computable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___IS_COMPUTABLE = eINSTANCE.getValueSpecification__IsComputable();

		/**
		 * The meta object literal for the '<em><b>Integer Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___INTEGER_VALUE = eINSTANCE.getValueSpecification__IntegerValue();

		/**
		 * The meta object literal for the '<em><b>Boolean Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___BOOLEAN_VALUE = eINSTANCE.getValueSpecification__BooleanValue();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___STRING_VALUE = eINSTANCE.getValueSpecification__StringValue();

		/**
		 * The meta object literal for the '<em><b>Unlimited Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___UNLIMITED_VALUE = eINSTANCE.getValueSpecification__UnlimitedValue();

		/**
		 * The meta object literal for the '<em><b>Is Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___IS_NULL = eINSTANCE.getValueSpecification__IsNull();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.elements.Nameable <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.elements.Nameable
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNameable()
		 * @generated
		 */
		EClass NAMEABLE = eINSTANCE.getNameable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DetailImpl <em>Detail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.DetailImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDetail()
		 * @generated
		 */
		EClass DETAIL = eINSTANCE.getDetail();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAIL__VALUE = eINSTANCE.getDetail_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DynamicBehaviorImpl <em>Dynamic Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.DynamicBehaviorImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDynamicBehavior()
		 * @generated
		 */
		EClass DYNAMIC_BEHAVIOR = eINSTANCE.getDynamicBehavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DynamicElementImpl <em>Dynamic Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.DynamicElementImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDynamicElement()
		 * @generated
		 */
		EClass DYNAMIC_ELEMENT = eINSTANCE.getDynamicElement();

		/**
		 * The meta object literal for the '<em><b>Meta Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_ELEMENT__META_TYPE = eINSTANCE.getDynamicElement_MetaType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DynamicPropertyImpl <em>Dynamic Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.DynamicPropertyImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDynamicProperty()
		 * @generated
		 */
		EClass DYNAMIC_PROPERTY = eINSTANCE.getDynamicProperty();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_PROPERTY__REFERRED_PROPERTY = eINSTANCE.getDynamicProperty_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_PROPERTY__DEFAULT = eINSTANCE.getDynamicProperty_Default();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.DynamicTypeImpl <em>Dynamic Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.DynamicTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getDynamicType()
		 * @generated
		 */
		EClass DYNAMIC_TYPE = eINSTANCE.getDynamicType();

		/**
		 * The meta object literal for the '<em><b>Owned Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_TYPE__OWNED_PROPERTY = eINSTANCE.getDynamicType_OwnedProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AnyTypeImpl <em>Any Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.AnyTypeImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAnyType()
		 * @generated
		 */
		EClass ANY_TYPE = eINSTANCE.getAnyType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassCallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociationClassCallExp()
		 * @generated
		 */
		EClass ASSOCIATION_CLASS_CALL_EXP = eINSTANCE.getAssociationClassCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Association Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS = eINSTANCE.getAssociationClassCallExp_ReferredAssociationClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.NavigationCallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getNavigationCallExp()
		 * @generated
		 */
		EClass NAVIGATION_CALL_EXP = eINSTANCE.getNavigationCallExp();

		/**
		 * The meta object literal for the '<em><b>Qualifier</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_CALL_EXP__QUALIFIER = eINSTANCE.getNavigationCallExp_Qualifier();

		/**
		 * The meta object literal for the '<em><b>Navigation Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_CALL_EXP__NAVIGATION_SOURCE = eINSTANCE.getNavigationCallExp_NavigationSource();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.FeatureCallExpImpl <em>Feature Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.FeatureCallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getFeatureCallExp()
		 * @generated
		 */
		EClass FEATURE_CALL_EXP = eINSTANCE.getFeatureCallExp();

		/**
		 * The meta object literal for the '<em><b>Is Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_CALL_EXP__IS_PRE = eINSTANCE.getFeatureCallExp_IsPre();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.FinalStateImpl <em>Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.FinalStateImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getFinalState()
		 * @generated
		 */
		EClass FINAL_STATE = eINSTANCE.getFinalState();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.internal.impl.CallExpImpl <em>Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.CallExpImpl
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCallExp()
		 * @generated
		 */
		EClass CALL_EXP = eINSTANCE.getCallExp();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP__SOURCE = eINSTANCE.getCallExp_Source();

		/**
		 * The meta object literal for the '<em><b>Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL_EXP__IMPLICIT = eINSTANCE.getCallExp_Implicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.util.Visitor <em>Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.util.Visitor
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getVisitor()
		 * @generated
		 */
		EClass VISITOR = eINSTANCE.getVisitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.AssociativityKind <em>Associativity Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.AssociativityKind
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getAssociativityKind()
		 * @generated
		 */
		EEnum ASSOCIATIVITY_KIND = eINSTANCE.getAssociativityKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.CollectionKind <em>Collection Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.CollectionKind
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getCollectionKind()
		 * @generated
		 */
		EEnum COLLECTION_KIND = eINSTANCE.getCollectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.PseudostateKind <em>Pseudostate Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.PseudostateKind
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getPseudostateKind()
		 * @generated
		 */
		EEnum PSEUDOSTATE_KIND = eINSTANCE.getPseudostateKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.pivot.TransitionKind <em>Transition Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.TransitionKind
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getTransitionKind()
		 * @generated
		 */
		EEnum TRANSITION_KIND = eINSTANCE.getTransitionKind();

		/**
		 * The meta object literal for the '<em>Boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getBoolean()
		 * @generated
		 */
		EDataType BOOLEAN = eINSTANCE.getBoolean();

		/**
		 * The meta object literal for the '<em>Integer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getInteger()
		 * @generated
		 */
		EDataType INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '<em>Library Feature</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.library.LibraryFeature
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getLibraryFeature()
		 * @generated
		 */
		EDataType LIBRARY_FEATURE = eINSTANCE.getLibraryFeature();

		/**
		 * The meta object literal for the '<em>Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em>Real</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getReal()
		 * @generated
		 */
		EDataType REAL = eINSTANCE.getReal();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>Throwable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Throwable
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getThrowable()
		 * @generated
		 */
		EDataType THROWABLE = eINSTANCE.getThrowable();

		/**
		 * The meta object literal for the '<em>Unlimited Natural</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.ocl.examples.pivot.internal.impl.PivotPackageImpl#getUnlimitedNatural()
		 * @generated
		 */
		EDataType UNLIMITED_NATURAL = eINSTANCE.getUnlimitedNatural();

	}

} //PivotPackage
