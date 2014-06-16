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
package org.eclipse.ocl.examples.pivot.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CallOperationAction;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.ConnectionPointReference;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.DynamicBehavior;
import org.eclipse.ocl.examples.pivot.DynamicElement;
import org.eclipse.ocl.examples.pivot.DynamicProperty;
import org.eclipse.ocl.examples.pivot.DynamicType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.FeatureCallExp;
import org.eclipse.ocl.examples.pivot.FinalState;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.Import;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.LiteralExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.MessageType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.NavigationCallExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.NumericLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OperationTemplateParameter;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.PackageableElement;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Profile;
import org.eclipse.ocl.examples.pivot.ProfileApplication;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Pseudostate;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.Region;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.SendSignalAction;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.Signal;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StateMachine;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateParameterType;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Transition;
import org.eclipse.ocl.examples.pivot.Trigger;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.Vertex;
import org.eclipse.ocl.examples.pivot.VoidType;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.pivot.PivotPackage
 * @generated
 */
public class PivotSwitch<T1> extends Switch<T1> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PivotPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PivotSwitch() {
		if (modelPackage == null)
		{
			modelPackage = PivotPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID)
		{
			case PivotPackage.ANNOTATION:
			{
				Annotation annotation = (Annotation)theEObject;
				T1 result = caseAnnotation(annotation);
				if (result == null) result = caseNamedElement(annotation);
				if (result == null) result = caseElement(annotation);
				if (result == null) result = caseNameable(annotation);
				if (result == null) result = caseVisitable(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ANY_TYPE:
			{
				AnyType anyType = (AnyType)theEObject;
				T1 result = caseAnyType(anyType);
				if (result == null) result = caseClass(anyType);
				if (result == null) result = caseType(anyType);
				if (result == null) result = caseNamespace(anyType);
				if (result == null) result = caseNamedElement(anyType);
				if (result == null) result = caseTemplateableElement(anyType);
				if (result == null) result = caseParameterableElement(anyType);
				if (result == null) result = caseElement(anyType);
				if (result == null) result = caseNameable(anyType);
				if (result == null) result = caseVisitable(anyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ASSOCIATION_CLASS:
			{
				AssociationClass associationClass = (AssociationClass)theEObject;
				T1 result = caseAssociationClass(associationClass);
				if (result == null) result = caseClass(associationClass);
				if (result == null) result = caseType(associationClass);
				if (result == null) result = caseNamespace(associationClass);
				if (result == null) result = caseNamedElement(associationClass);
				if (result == null) result = caseTemplateableElement(associationClass);
				if (result == null) result = caseParameterableElement(associationClass);
				if (result == null) result = caseElement(associationClass);
				if (result == null) result = caseNameable(associationClass);
				if (result == null) result = caseVisitable(associationClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP:
			{
				AssociationClassCallExp associationClassCallExp = (AssociationClassCallExp)theEObject;
				T1 result = caseAssociationClassCallExp(associationClassCallExp);
				if (result == null) result = caseNavigationCallExp(associationClassCallExp);
				if (result == null) result = caseFeatureCallExp(associationClassCallExp);
				if (result == null) result = caseCallExp(associationClassCallExp);
				if (result == null) result = caseOCLExpression(associationClassCallExp);
				if (result == null) result = caseTypedElement(associationClassCallExp);
				if (result == null) result = caseNamedElement(associationClassCallExp);
				if (result == null) result = caseElement(associationClassCallExp);
				if (result == null) result = caseNameable(associationClassCallExp);
				if (result == null) result = caseVisitable(associationClassCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.BAG_TYPE:
			{
				BagType bagType = (BagType)theEObject;
				T1 result = caseBagType(bagType);
				if (result == null) result = caseCollectionType(bagType);
				if (result == null) result = caseDataType(bagType);
				if (result == null) result = caseClass(bagType);
				if (result == null) result = caseType(bagType);
				if (result == null) result = caseNamespace(bagType);
				if (result == null) result = caseNamedElement(bagType);
				if (result == null) result = caseTemplateableElement(bagType);
				if (result == null) result = caseParameterableElement(bagType);
				if (result == null) result = caseElement(bagType);
				if (result == null) result = caseNameable(bagType);
				if (result == null) result = caseVisitable(bagType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.BEHAVIOR:
			{
				Behavior behavior = (Behavior)theEObject;
				T1 result = caseBehavior(behavior);
				if (result == null) result = caseClass(behavior);
				if (result == null) result = caseType(behavior);
				if (result == null) result = caseNamespace(behavior);
				if (result == null) result = caseNamedElement(behavior);
				if (result == null) result = caseTemplateableElement(behavior);
				if (result == null) result = caseParameterableElement(behavior);
				if (result == null) result = caseElement(behavior);
				if (result == null) result = caseNameable(behavior);
				if (result == null) result = caseVisitable(behavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.BOOLEAN_LITERAL_EXP:
			{
				BooleanLiteralExp booleanLiteralExp = (BooleanLiteralExp)theEObject;
				T1 result = caseBooleanLiteralExp(booleanLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(booleanLiteralExp);
				if (result == null) result = caseLiteralExp(booleanLiteralExp);
				if (result == null) result = caseOCLExpression(booleanLiteralExp);
				if (result == null) result = caseTypedElement(booleanLiteralExp);
				if (result == null) result = caseNamedElement(booleanLiteralExp);
				if (result == null) result = caseElement(booleanLiteralExp);
				if (result == null) result = caseNameable(booleanLiteralExp);
				if (result == null) result = caseVisitable(booleanLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.CALL_EXP:
			{
				CallExp callExp = (CallExp)theEObject;
				T1 result = caseCallExp(callExp);
				if (result == null) result = caseOCLExpression(callExp);
				if (result == null) result = caseTypedElement(callExp);
				if (result == null) result = caseNamedElement(callExp);
				if (result == null) result = caseElement(callExp);
				if (result == null) result = caseNameable(callExp);
				if (result == null) result = caseVisitable(callExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.CALL_OPERATION_ACTION:
			{
				CallOperationAction callOperationAction = (CallOperationAction)theEObject;
				T1 result = caseCallOperationAction(callOperationAction);
				if (result == null) result = caseNamedElement(callOperationAction);
				if (result == null) result = caseElement(callOperationAction);
				if (result == null) result = caseNameable(callOperationAction);
				if (result == null) result = caseVisitable(callOperationAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.CLASS:
			{
				org.eclipse.ocl.examples.pivot.Class class_ = (org.eclipse.ocl.examples.pivot.Class)theEObject;
				T1 result = caseClass(class_);
				if (result == null) result = caseType(class_);
				if (result == null) result = caseNamespace(class_);
				if (result == null) result = caseNamedElement(class_);
				if (result == null) result = caseTemplateableElement(class_);
				if (result == null) result = caseParameterableElement(class_);
				if (result == null) result = caseElement(class_);
				if (result == null) result = caseNameable(class_);
				if (result == null) result = caseVisitable(class_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.COLLECTION_ITEM:
			{
				CollectionItem collectionItem = (CollectionItem)theEObject;
				T1 result = caseCollectionItem(collectionItem);
				if (result == null) result = caseCollectionLiteralPart(collectionItem);
				if (result == null) result = caseTypedElement(collectionItem);
				if (result == null) result = caseNamedElement(collectionItem);
				if (result == null) result = caseElement(collectionItem);
				if (result == null) result = caseNameable(collectionItem);
				if (result == null) result = caseVisitable(collectionItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.COLLECTION_LITERAL_EXP:
			{
				CollectionLiteralExp collectionLiteralExp = (CollectionLiteralExp)theEObject;
				T1 result = caseCollectionLiteralExp(collectionLiteralExp);
				if (result == null) result = caseLiteralExp(collectionLiteralExp);
				if (result == null) result = caseOCLExpression(collectionLiteralExp);
				if (result == null) result = caseTypedElement(collectionLiteralExp);
				if (result == null) result = caseNamedElement(collectionLiteralExp);
				if (result == null) result = caseElement(collectionLiteralExp);
				if (result == null) result = caseNameable(collectionLiteralExp);
				if (result == null) result = caseVisitable(collectionLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.COLLECTION_LITERAL_PART:
			{
				CollectionLiteralPart collectionLiteralPart = (CollectionLiteralPart)theEObject;
				T1 result = caseCollectionLiteralPart(collectionLiteralPart);
				if (result == null) result = caseTypedElement(collectionLiteralPart);
				if (result == null) result = caseNamedElement(collectionLiteralPart);
				if (result == null) result = caseElement(collectionLiteralPart);
				if (result == null) result = caseNameable(collectionLiteralPart);
				if (result == null) result = caseVisitable(collectionLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.COLLECTION_RANGE:
			{
				CollectionRange collectionRange = (CollectionRange)theEObject;
				T1 result = caseCollectionRange(collectionRange);
				if (result == null) result = caseCollectionLiteralPart(collectionRange);
				if (result == null) result = caseTypedElement(collectionRange);
				if (result == null) result = caseNamedElement(collectionRange);
				if (result == null) result = caseElement(collectionRange);
				if (result == null) result = caseNameable(collectionRange);
				if (result == null) result = caseVisitable(collectionRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.COLLECTION_TYPE:
			{
				CollectionType collectionType = (CollectionType)theEObject;
				T1 result = caseCollectionType(collectionType);
				if (result == null) result = caseDataType(collectionType);
				if (result == null) result = caseClass(collectionType);
				if (result == null) result = caseType(collectionType);
				if (result == null) result = caseNamespace(collectionType);
				if (result == null) result = caseNamedElement(collectionType);
				if (result == null) result = caseTemplateableElement(collectionType);
				if (result == null) result = caseParameterableElement(collectionType);
				if (result == null) result = caseElement(collectionType);
				if (result == null) result = caseNameable(collectionType);
				if (result == null) result = caseVisitable(collectionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.COMMENT:
			{
				Comment comment = (Comment)theEObject;
				T1 result = caseComment(comment);
				if (result == null) result = caseElement(comment);
				if (result == null) result = caseVisitable(comment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.CONNECTION_POINT_REFERENCE:
			{
				ConnectionPointReference connectionPointReference = (ConnectionPointReference)theEObject;
				T1 result = caseConnectionPointReference(connectionPointReference);
				if (result == null) result = caseVertex(connectionPointReference);
				if (result == null) result = caseNamedElement(connectionPointReference);
				if (result == null) result = caseElement(connectionPointReference);
				if (result == null) result = caseNameable(connectionPointReference);
				if (result == null) result = caseVisitable(connectionPointReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.CONSTRAINT:
			{
				Constraint constraint = (Constraint)theEObject;
				T1 result = caseConstraint(constraint);
				if (result == null) result = caseNamedElement(constraint);
				if (result == null) result = caseElement(constraint);
				if (result == null) result = caseNameable(constraint);
				if (result == null) result = caseVisitable(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.CONSTRUCTOR_EXP:
			{
				ConstructorExp constructorExp = (ConstructorExp)theEObject;
				T1 result = caseConstructorExp(constructorExp);
				if (result == null) result = caseOCLExpression(constructorExp);
				if (result == null) result = caseTypedElement(constructorExp);
				if (result == null) result = caseNamedElement(constructorExp);
				if (result == null) result = caseElement(constructorExp);
				if (result == null) result = caseNameable(constructorExp);
				if (result == null) result = caseVisitable(constructorExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.CONSTRUCTOR_PART:
			{
				ConstructorPart constructorPart = (ConstructorPart)theEObject;
				T1 result = caseConstructorPart(constructorPart);
				if (result == null) result = caseTypedElement(constructorPart);
				if (result == null) result = caseNamedElement(constructorPart);
				if (result == null) result = caseElement(constructorPart);
				if (result == null) result = caseNameable(constructorPart);
				if (result == null) result = caseVisitable(constructorPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.DATA_TYPE:
			{
				DataType dataType = (DataType)theEObject;
				T1 result = caseDataType(dataType);
				if (result == null) result = caseClass(dataType);
				if (result == null) result = caseType(dataType);
				if (result == null) result = caseNamespace(dataType);
				if (result == null) result = caseNamedElement(dataType);
				if (result == null) result = caseTemplateableElement(dataType);
				if (result == null) result = caseParameterableElement(dataType);
				if (result == null) result = caseElement(dataType);
				if (result == null) result = caseNameable(dataType);
				if (result == null) result = caseVisitable(dataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.DETAIL:
			{
				Detail detail = (Detail)theEObject;
				T1 result = caseDetail(detail);
				if (result == null) result = caseNamedElement(detail);
				if (result == null) result = caseElement(detail);
				if (result == null) result = caseNameable(detail);
				if (result == null) result = caseVisitable(detail);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.DYNAMIC_BEHAVIOR:
			{
				DynamicBehavior dynamicBehavior = (DynamicBehavior)theEObject;
				T1 result = caseDynamicBehavior(dynamicBehavior);
				if (result == null) result = caseBehavior(dynamicBehavior);
				if (result == null) result = caseDynamicType(dynamicBehavior);
				if (result == null) result = caseClass(dynamicBehavior);
				if (result == null) result = caseDynamicElement(dynamicBehavior);
				if (result == null) result = caseType(dynamicBehavior);
				if (result == null) result = caseNamespace(dynamicBehavior);
				if (result == null) result = caseNamedElement(dynamicBehavior);
				if (result == null) result = caseTemplateableElement(dynamicBehavior);
				if (result == null) result = caseParameterableElement(dynamicBehavior);
				if (result == null) result = caseElement(dynamicBehavior);
				if (result == null) result = caseNameable(dynamicBehavior);
				if (result == null) result = caseVisitable(dynamicBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.DYNAMIC_ELEMENT:
			{
				DynamicElement dynamicElement = (DynamicElement)theEObject;
				T1 result = caseDynamicElement(dynamicElement);
				if (result == null) result = caseElement(dynamicElement);
				if (result == null) result = caseVisitable(dynamicElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.DYNAMIC_PROPERTY:
			{
				DynamicProperty dynamicProperty = (DynamicProperty)theEObject;
				T1 result = caseDynamicProperty(dynamicProperty);
				if (result == null) result = caseElement(dynamicProperty);
				if (result == null) result = caseVisitable(dynamicProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.DYNAMIC_TYPE:
			{
				DynamicType dynamicType = (DynamicType)theEObject;
				T1 result = caseDynamicType(dynamicType);
				if (result == null) result = caseType(dynamicType);
				if (result == null) result = caseDynamicElement(dynamicType);
				if (result == null) result = caseNamedElement(dynamicType);
				if (result == null) result = caseTemplateableElement(dynamicType);
				if (result == null) result = caseParameterableElement(dynamicType);
				if (result == null) result = caseElement(dynamicType);
				if (result == null) result = caseNameable(dynamicType);
				if (result == null) result = caseVisitable(dynamicType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ELEMENT:
			{
				Element element = (Element)theEObject;
				T1 result = caseElement(element);
				if (result == null) result = caseVisitable(element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ELEMENT_EXTENSION:
			{
				ElementExtension elementExtension = (ElementExtension)theEObject;
				T1 result = caseElementExtension(elementExtension);
				if (result == null) result = caseType(elementExtension);
				if (result == null) result = caseNamedElement(elementExtension);
				if (result == null) result = caseTemplateableElement(elementExtension);
				if (result == null) result = caseParameterableElement(elementExtension);
				if (result == null) result = caseElement(elementExtension);
				if (result == null) result = caseNameable(elementExtension);
				if (result == null) result = caseVisitable(elementExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ENUM_LITERAL_EXP:
			{
				EnumLiteralExp enumLiteralExp = (EnumLiteralExp)theEObject;
				T1 result = caseEnumLiteralExp(enumLiteralExp);
				if (result == null) result = caseLiteralExp(enumLiteralExp);
				if (result == null) result = caseOCLExpression(enumLiteralExp);
				if (result == null) result = caseTypedElement(enumLiteralExp);
				if (result == null) result = caseNamedElement(enumLiteralExp);
				if (result == null) result = caseElement(enumLiteralExp);
				if (result == null) result = caseNameable(enumLiteralExp);
				if (result == null) result = caseVisitable(enumLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ENUMERATION:
			{
				Enumeration enumeration = (Enumeration)theEObject;
				T1 result = caseEnumeration(enumeration);
				if (result == null) result = caseDataType(enumeration);
				if (result == null) result = caseClass(enumeration);
				if (result == null) result = caseType(enumeration);
				if (result == null) result = caseNamespace(enumeration);
				if (result == null) result = caseNamedElement(enumeration);
				if (result == null) result = caseTemplateableElement(enumeration);
				if (result == null) result = caseParameterableElement(enumeration);
				if (result == null) result = caseElement(enumeration);
				if (result == null) result = caseNameable(enumeration);
				if (result == null) result = caseVisitable(enumeration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ENUMERATION_LITERAL:
			{
				EnumerationLiteral enumerationLiteral = (EnumerationLiteral)theEObject;
				T1 result = caseEnumerationLiteral(enumerationLiteral);
				if (result == null) result = caseNamedElement(enumerationLiteral);
				if (result == null) result = caseElement(enumerationLiteral);
				if (result == null) result = caseNameable(enumerationLiteral);
				if (result == null) result = caseVisitable(enumerationLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.EXPRESSION_IN_OCL:
			{
				ExpressionInOCL expressionInOCL = (ExpressionInOCL)theEObject;
				T1 result = caseExpressionInOCL(expressionInOCL);
				if (result == null) result = caseOpaqueExpression(expressionInOCL);
				if (result == null) result = caseValueSpecification(expressionInOCL);
				if (result == null) result = caseTypedElement(expressionInOCL);
				if (result == null) result = caseParameterableElement(expressionInOCL);
				if (result == null) result = caseNamedElement(expressionInOCL);
				if (result == null) result = caseElement(expressionInOCL);
				if (result == null) result = caseNameable(expressionInOCL);
				if (result == null) result = caseVisitable(expressionInOCL);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.FEATURE:
			{
				Feature feature = (Feature)theEObject;
				T1 result = caseFeature(feature);
				if (result == null) result = caseTypedMultiplicityElement(feature);
				if (result == null) result = caseTypedElement(feature);
				if (result == null) result = caseNamedElement(feature);
				if (result == null) result = caseElement(feature);
				if (result == null) result = caseNameable(feature);
				if (result == null) result = caseVisitable(feature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.FEATURE_CALL_EXP:
			{
				FeatureCallExp featureCallExp = (FeatureCallExp)theEObject;
				T1 result = caseFeatureCallExp(featureCallExp);
				if (result == null) result = caseCallExp(featureCallExp);
				if (result == null) result = caseOCLExpression(featureCallExp);
				if (result == null) result = caseTypedElement(featureCallExp);
				if (result == null) result = caseNamedElement(featureCallExp);
				if (result == null) result = caseElement(featureCallExp);
				if (result == null) result = caseNameable(featureCallExp);
				if (result == null) result = caseVisitable(featureCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.FINAL_STATE:
			{
				FinalState finalState = (FinalState)theEObject;
				T1 result = caseFinalState(finalState);
				if (result == null) result = caseState(finalState);
				if (result == null) result = caseVertex(finalState);
				if (result == null) result = caseNamespace(finalState);
				if (result == null) result = caseNamedElement(finalState);
				if (result == null) result = caseElement(finalState);
				if (result == null) result = caseNameable(finalState);
				if (result == null) result = caseVisitable(finalState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.IF_EXP:
			{
				IfExp ifExp = (IfExp)theEObject;
				T1 result = caseIfExp(ifExp);
				if (result == null) result = caseOCLExpression(ifExp);
				if (result == null) result = caseTypedElement(ifExp);
				if (result == null) result = caseNamedElement(ifExp);
				if (result == null) result = caseElement(ifExp);
				if (result == null) result = caseNameable(ifExp);
				if (result == null) result = caseVisitable(ifExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.IMPORT:
			{
				Import import_ = (Import)theEObject;
				T1 result = caseImport(import_);
				if (result == null) result = caseNamedElement(import_);
				if (result == null) result = caseElement(import_);
				if (result == null) result = caseNameable(import_);
				if (result == null) result = caseVisitable(import_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.INTEGER_LITERAL_EXP:
			{
				IntegerLiteralExp integerLiteralExp = (IntegerLiteralExp)theEObject;
				T1 result = caseIntegerLiteralExp(integerLiteralExp);
				if (result == null) result = caseNumericLiteralExp(integerLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(integerLiteralExp);
				if (result == null) result = caseLiteralExp(integerLiteralExp);
				if (result == null) result = caseOCLExpression(integerLiteralExp);
				if (result == null) result = caseTypedElement(integerLiteralExp);
				if (result == null) result = caseNamedElement(integerLiteralExp);
				if (result == null) result = caseElement(integerLiteralExp);
				if (result == null) result = caseNameable(integerLiteralExp);
				if (result == null) result = caseVisitable(integerLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.INVALID_LITERAL_EXP:
			{
				InvalidLiteralExp invalidLiteralExp = (InvalidLiteralExp)theEObject;
				T1 result = caseInvalidLiteralExp(invalidLiteralExp);
				if (result == null) result = caseLiteralExp(invalidLiteralExp);
				if (result == null) result = caseOCLExpression(invalidLiteralExp);
				if (result == null) result = caseTypedElement(invalidLiteralExp);
				if (result == null) result = caseNamedElement(invalidLiteralExp);
				if (result == null) result = caseElement(invalidLiteralExp);
				if (result == null) result = caseNameable(invalidLiteralExp);
				if (result == null) result = caseVisitable(invalidLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.INVALID_TYPE:
			{
				InvalidType invalidType = (InvalidType)theEObject;
				T1 result = caseInvalidType(invalidType);
				if (result == null) result = caseClass(invalidType);
				if (result == null) result = caseType(invalidType);
				if (result == null) result = caseNamespace(invalidType);
				if (result == null) result = caseNamedElement(invalidType);
				if (result == null) result = caseTemplateableElement(invalidType);
				if (result == null) result = caseParameterableElement(invalidType);
				if (result == null) result = caseElement(invalidType);
				if (result == null) result = caseNameable(invalidType);
				if (result == null) result = caseVisitable(invalidType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ITERATE_EXP:
			{
				IterateExp iterateExp = (IterateExp)theEObject;
				T1 result = caseIterateExp(iterateExp);
				if (result == null) result = caseLoopExp(iterateExp);
				if (result == null) result = caseReferringElement(iterateExp);
				if (result == null) result = caseCallExp(iterateExp);
				if (result == null) result = caseOCLExpression(iterateExp);
				if (result == null) result = caseTypedElement(iterateExp);
				if (result == null) result = caseNamedElement(iterateExp);
				if (result == null) result = caseElement(iterateExp);
				if (result == null) result = caseNameable(iterateExp);
				if (result == null) result = caseVisitable(iterateExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ITERATION:
			{
				Iteration iteration = (Iteration)theEObject;
				T1 result = caseIteration(iteration);
				if (result == null) result = caseOperation(iteration);
				if (result == null) result = caseFeature(iteration);
				if (result == null) result = caseNamespace(iteration);
				if (result == null) result = caseTemplateableElement(iteration);
				if (result == null) result = caseParameterableElement(iteration);
				if (result == null) result = caseTypedMultiplicityElement(iteration);
				if (result == null) result = caseTypedElement(iteration);
				if (result == null) result = caseNamedElement(iteration);
				if (result == null) result = caseElement(iteration);
				if (result == null) result = caseNameable(iteration);
				if (result == null) result = caseVisitable(iteration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ITERATOR_EXP:
			{
				IteratorExp iteratorExp = (IteratorExp)theEObject;
				T1 result = caseIteratorExp(iteratorExp);
				if (result == null) result = caseLoopExp(iteratorExp);
				if (result == null) result = caseReferringElement(iteratorExp);
				if (result == null) result = caseCallExp(iteratorExp);
				if (result == null) result = caseOCLExpression(iteratorExp);
				if (result == null) result = caseTypedElement(iteratorExp);
				if (result == null) result = caseNamedElement(iteratorExp);
				if (result == null) result = caseElement(iteratorExp);
				if (result == null) result = caseNameable(iteratorExp);
				if (result == null) result = caseVisitable(iteratorExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.LAMBDA_TYPE:
			{
				LambdaType lambdaType = (LambdaType)theEObject;
				T1 result = caseLambdaType(lambdaType);
				if (result == null) result = caseDataType(lambdaType);
				if (result == null) result = caseClass(lambdaType);
				if (result == null) result = caseType(lambdaType);
				if (result == null) result = caseNamespace(lambdaType);
				if (result == null) result = caseNamedElement(lambdaType);
				if (result == null) result = caseTemplateableElement(lambdaType);
				if (result == null) result = caseParameterableElement(lambdaType);
				if (result == null) result = caseElement(lambdaType);
				if (result == null) result = caseNameable(lambdaType);
				if (result == null) result = caseVisitable(lambdaType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.LET_EXP:
			{
				LetExp letExp = (LetExp)theEObject;
				T1 result = caseLetExp(letExp);
				if (result == null) result = caseOCLExpression(letExp);
				if (result == null) result = caseTypedElement(letExp);
				if (result == null) result = caseNamedElement(letExp);
				if (result == null) result = caseElement(letExp);
				if (result == null) result = caseNameable(letExp);
				if (result == null) result = caseVisitable(letExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.LIBRARY:
			{
				Library library = (Library)theEObject;
				T1 result = caseLibrary(library);
				if (result == null) result = casePackage(library);
				if (result == null) result = caseNamespace(library);
				if (result == null) result = caseTemplateableElement(library);
				if (result == null) result = caseNamedElement(library);
				if (result == null) result = caseElement(library);
				if (result == null) result = caseNameable(library);
				if (result == null) result = caseVisitable(library);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.LITERAL_EXP:
			{
				LiteralExp literalExp = (LiteralExp)theEObject;
				T1 result = caseLiteralExp(literalExp);
				if (result == null) result = caseOCLExpression(literalExp);
				if (result == null) result = caseTypedElement(literalExp);
				if (result == null) result = caseNamedElement(literalExp);
				if (result == null) result = caseElement(literalExp);
				if (result == null) result = caseNameable(literalExp);
				if (result == null) result = caseVisitable(literalExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.LOOP_EXP:
			{
				LoopExp loopExp = (LoopExp)theEObject;
				T1 result = caseLoopExp(loopExp);
				if (result == null) result = caseCallExp(loopExp);
				if (result == null) result = caseOCLExpression(loopExp);
				if (result == null) result = caseTypedElement(loopExp);
				if (result == null) result = caseNamedElement(loopExp);
				if (result == null) result = caseElement(loopExp);
				if (result == null) result = caseNameable(loopExp);
				if (result == null) result = caseVisitable(loopExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.MESSAGE_EXP:
			{
				MessageExp messageExp = (MessageExp)theEObject;
				T1 result = caseMessageExp(messageExp);
				if (result == null) result = caseOCLExpression(messageExp);
				if (result == null) result = caseTypedElement(messageExp);
				if (result == null) result = caseNamedElement(messageExp);
				if (result == null) result = caseElement(messageExp);
				if (result == null) result = caseNameable(messageExp);
				if (result == null) result = caseVisitable(messageExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.MESSAGE_TYPE:
			{
				MessageType messageType = (MessageType)theEObject;
				T1 result = caseMessageType(messageType);
				if (result == null) result = caseType(messageType);
				if (result == null) result = caseNamedElement(messageType);
				if (result == null) result = caseTemplateableElement(messageType);
				if (result == null) result = caseParameterableElement(messageType);
				if (result == null) result = caseElement(messageType);
				if (result == null) result = caseNameable(messageType);
				if (result == null) result = caseVisitable(messageType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.METACLASS:
			{
				Metaclass<?> metaclass = (Metaclass<?>)theEObject;
				T1 result = caseMetaclass(metaclass);
				if (result == null) result = caseClass(metaclass);
				if (result == null) result = caseType(metaclass);
				if (result == null) result = caseNamespace(metaclass);
				if (result == null) result = caseNamedElement(metaclass);
				if (result == null) result = caseTemplateableElement(metaclass);
				if (result == null) result = caseParameterableElement(metaclass);
				if (result == null) result = caseElement(metaclass);
				if (result == null) result = caseNameable(metaclass);
				if (result == null) result = caseVisitable(metaclass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.MORE_PIVOTABLE:
			{
				MorePivotable morePivotable = (MorePivotable)theEObject;
				T1 result = caseMorePivotable(morePivotable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.NAMEABLE:
			{
				Nameable nameable = (Nameable)theEObject;
				T1 result = caseNameable(nameable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.NAMED_ELEMENT:
			{
				NamedElement namedElement = (NamedElement)theEObject;
				T1 result = caseNamedElement(namedElement);
				if (result == null) result = caseElement(namedElement);
				if (result == null) result = caseNameable(namedElement);
				if (result == null) result = caseVisitable(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.NAMESPACE:
			{
				Namespace namespace = (Namespace)theEObject;
				T1 result = caseNamespace(namespace);
				if (result == null) result = caseNamedElement(namespace);
				if (result == null) result = caseElement(namespace);
				if (result == null) result = caseNameable(namespace);
				if (result == null) result = caseVisitable(namespace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.NAVIGATION_CALL_EXP:
			{
				NavigationCallExp navigationCallExp = (NavigationCallExp)theEObject;
				T1 result = caseNavigationCallExp(navigationCallExp);
				if (result == null) result = caseFeatureCallExp(navigationCallExp);
				if (result == null) result = caseCallExp(navigationCallExp);
				if (result == null) result = caseOCLExpression(navigationCallExp);
				if (result == null) result = caseTypedElement(navigationCallExp);
				if (result == null) result = caseNamedElement(navigationCallExp);
				if (result == null) result = caseElement(navigationCallExp);
				if (result == null) result = caseNameable(navigationCallExp);
				if (result == null) result = caseVisitable(navigationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.NULL_LITERAL_EXP:
			{
				NullLiteralExp nullLiteralExp = (NullLiteralExp)theEObject;
				T1 result = caseNullLiteralExp(nullLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(nullLiteralExp);
				if (result == null) result = caseLiteralExp(nullLiteralExp);
				if (result == null) result = caseOCLExpression(nullLiteralExp);
				if (result == null) result = caseTypedElement(nullLiteralExp);
				if (result == null) result = caseNamedElement(nullLiteralExp);
				if (result == null) result = caseElement(nullLiteralExp);
				if (result == null) result = caseNameable(nullLiteralExp);
				if (result == null) result = caseVisitable(nullLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.NUMERIC_LITERAL_EXP:
			{
				NumericLiteralExp numericLiteralExp = (NumericLiteralExp)theEObject;
				T1 result = caseNumericLiteralExp(numericLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(numericLiteralExp);
				if (result == null) result = caseLiteralExp(numericLiteralExp);
				if (result == null) result = caseOCLExpression(numericLiteralExp);
				if (result == null) result = caseTypedElement(numericLiteralExp);
				if (result == null) result = caseNamedElement(numericLiteralExp);
				if (result == null) result = caseElement(numericLiteralExp);
				if (result == null) result = caseNameable(numericLiteralExp);
				if (result == null) result = caseVisitable(numericLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.OCL_EXPRESSION:
			{
				OCLExpression oclExpression = (OCLExpression)theEObject;
				T1 result = caseOCLExpression(oclExpression);
				if (result == null) result = caseTypedElement(oclExpression);
				if (result == null) result = caseNamedElement(oclExpression);
				if (result == null) result = caseElement(oclExpression);
				if (result == null) result = caseNameable(oclExpression);
				if (result == null) result = caseVisitable(oclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.OPAQUE_EXPRESSION:
			{
				OpaqueExpression opaqueExpression = (OpaqueExpression)theEObject;
				T1 result = caseOpaqueExpression(opaqueExpression);
				if (result == null) result = caseValueSpecification(opaqueExpression);
				if (result == null) result = caseTypedElement(opaqueExpression);
				if (result == null) result = caseParameterableElement(opaqueExpression);
				if (result == null) result = caseNamedElement(opaqueExpression);
				if (result == null) result = caseElement(opaqueExpression);
				if (result == null) result = caseNameable(opaqueExpression);
				if (result == null) result = caseVisitable(opaqueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.OPERATION:
			{
				Operation operation = (Operation)theEObject;
				T1 result = caseOperation(operation);
				if (result == null) result = caseFeature(operation);
				if (result == null) result = caseNamespace(operation);
				if (result == null) result = caseTemplateableElement(operation);
				if (result == null) result = caseParameterableElement(operation);
				if (result == null) result = caseTypedMultiplicityElement(operation);
				if (result == null) result = caseTypedElement(operation);
				if (result == null) result = caseNamedElement(operation);
				if (result == null) result = caseElement(operation);
				if (result == null) result = caseNameable(operation);
				if (result == null) result = caseVisitable(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.OPERATION_CALL_EXP:
			{
				OperationCallExp operationCallExp = (OperationCallExp)theEObject;
				T1 result = caseOperationCallExp(operationCallExp);
				if (result == null) result = caseFeatureCallExp(operationCallExp);
				if (result == null) result = caseReferringElement(operationCallExp);
				if (result == null) result = caseCallExp(operationCallExp);
				if (result == null) result = caseOCLExpression(operationCallExp);
				if (result == null) result = caseTypedElement(operationCallExp);
				if (result == null) result = caseNamedElement(operationCallExp);
				if (result == null) result = caseElement(operationCallExp);
				if (result == null) result = caseNameable(operationCallExp);
				if (result == null) result = caseVisitable(operationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.OPERATION_TEMPLATE_PARAMETER:
			{
				OperationTemplateParameter operationTemplateParameter = (OperationTemplateParameter)theEObject;
				T1 result = caseOperationTemplateParameter(operationTemplateParameter);
				if (result == null) result = caseTemplateParameter(operationTemplateParameter);
				if (result == null) result = caseElement(operationTemplateParameter);
				if (result == null) result = caseVisitable(operationTemplateParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.OPPOSITE_PROPERTY_CALL_EXP:
			{
				OppositePropertyCallExp oppositePropertyCallExp = (OppositePropertyCallExp)theEObject;
				T1 result = caseOppositePropertyCallExp(oppositePropertyCallExp);
				if (result == null) result = caseNavigationCallExp(oppositePropertyCallExp);
				if (result == null) result = caseFeatureCallExp(oppositePropertyCallExp);
				if (result == null) result = caseCallExp(oppositePropertyCallExp);
				if (result == null) result = caseOCLExpression(oppositePropertyCallExp);
				if (result == null) result = caseTypedElement(oppositePropertyCallExp);
				if (result == null) result = caseNamedElement(oppositePropertyCallExp);
				if (result == null) result = caseElement(oppositePropertyCallExp);
				if (result == null) result = caseNameable(oppositePropertyCallExp);
				if (result == null) result = caseVisitable(oppositePropertyCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ORDERED_SET_TYPE:
			{
				OrderedSetType orderedSetType = (OrderedSetType)theEObject;
				T1 result = caseOrderedSetType(orderedSetType);
				if (result == null) result = caseCollectionType(orderedSetType);
				if (result == null) result = caseDataType(orderedSetType);
				if (result == null) result = caseClass(orderedSetType);
				if (result == null) result = caseType(orderedSetType);
				if (result == null) result = caseNamespace(orderedSetType);
				if (result == null) result = caseNamedElement(orderedSetType);
				if (result == null) result = caseTemplateableElement(orderedSetType);
				if (result == null) result = caseParameterableElement(orderedSetType);
				if (result == null) result = caseElement(orderedSetType);
				if (result == null) result = caseNameable(orderedSetType);
				if (result == null) result = caseVisitable(orderedSetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PACKAGE:
			{
				org.eclipse.ocl.examples.pivot.Package package_ = (org.eclipse.ocl.examples.pivot.Package)theEObject;
				T1 result = casePackage(package_);
				if (result == null) result = caseNamespace(package_);
				if (result == null) result = caseTemplateableElement(package_);
				if (result == null) result = caseNamedElement(package_);
				if (result == null) result = caseElement(package_);
				if (result == null) result = caseNameable(package_);
				if (result == null) result = caseVisitable(package_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PACKAGEABLE_ELEMENT:
			{
				PackageableElement packageableElement = (PackageableElement)theEObject;
				T1 result = casePackageableElement(packageableElement);
				if (result == null) result = caseParameterableElement(packageableElement);
				if (result == null) result = caseElement(packageableElement);
				if (result == null) result = caseVisitable(packageableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PARAMETER:
			{
				Parameter parameter = (Parameter)theEObject;
				T1 result = caseParameter(parameter);
				if (result == null) result = caseTypedMultiplicityElement(parameter);
				if (result == null) result = caseVariableDeclaration(parameter);
				if (result == null) result = caseTypedElement(parameter);
				if (result == null) result = caseNamedElement(parameter);
				if (result == null) result = caseElement(parameter);
				if (result == null) result = caseNameable(parameter);
				if (result == null) result = caseVisitable(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PARAMETERABLE_ELEMENT:
			{
				ParameterableElement parameterableElement = (ParameterableElement)theEObject;
				T1 result = caseParameterableElement(parameterableElement);
				if (result == null) result = caseElement(parameterableElement);
				if (result == null) result = caseVisitable(parameterableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PIVOTABLE:
			{
				Pivotable pivotable = (Pivotable)theEObject;
				T1 result = casePivotable(pivotable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PRECEDENCE:
			{
				Precedence precedence = (Precedence)theEObject;
				T1 result = casePrecedence(precedence);
				if (result == null) result = caseNamedElement(precedence);
				if (result == null) result = caseElement(precedence);
				if (result == null) result = caseNameable(precedence);
				if (result == null) result = caseVisitable(precedence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PRIMITIVE_LITERAL_EXP:
			{
				PrimitiveLiteralExp primitiveLiteralExp = (PrimitiveLiteralExp)theEObject;
				T1 result = casePrimitiveLiteralExp(primitiveLiteralExp);
				if (result == null) result = caseLiteralExp(primitiveLiteralExp);
				if (result == null) result = caseOCLExpression(primitiveLiteralExp);
				if (result == null) result = caseTypedElement(primitiveLiteralExp);
				if (result == null) result = caseNamedElement(primitiveLiteralExp);
				if (result == null) result = caseElement(primitiveLiteralExp);
				if (result == null) result = caseNameable(primitiveLiteralExp);
				if (result == null) result = caseVisitable(primitiveLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PRIMITIVE_TYPE:
			{
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T1 result = casePrimitiveType(primitiveType);
				if (result == null) result = caseDataType(primitiveType);
				if (result == null) result = caseClass(primitiveType);
				if (result == null) result = caseType(primitiveType);
				if (result == null) result = caseNamespace(primitiveType);
				if (result == null) result = caseNamedElement(primitiveType);
				if (result == null) result = caseTemplateableElement(primitiveType);
				if (result == null) result = caseParameterableElement(primitiveType);
				if (result == null) result = caseElement(primitiveType);
				if (result == null) result = caseNameable(primitiveType);
				if (result == null) result = caseVisitable(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PROFILE:
			{
				Profile profile = (Profile)theEObject;
				T1 result = caseProfile(profile);
				if (result == null) result = casePackage(profile);
				if (result == null) result = caseNamespace(profile);
				if (result == null) result = caseTemplateableElement(profile);
				if (result == null) result = caseNamedElement(profile);
				if (result == null) result = caseElement(profile);
				if (result == null) result = caseNameable(profile);
				if (result == null) result = caseVisitable(profile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PROFILE_APPLICATION:
			{
				ProfileApplication profileApplication = (ProfileApplication)theEObject;
				T1 result = caseProfileApplication(profileApplication);
				if (result == null) result = caseElement(profileApplication);
				if (result == null) result = caseVisitable(profileApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PROPERTY:
			{
				Property property = (Property)theEObject;
				T1 result = caseProperty(property);
				if (result == null) result = caseFeature(property);
				if (result == null) result = caseParameterableElement(property);
				if (result == null) result = caseTypedMultiplicityElement(property);
				if (result == null) result = caseTypedElement(property);
				if (result == null) result = caseNamedElement(property);
				if (result == null) result = caseElement(property);
				if (result == null) result = caseNameable(property);
				if (result == null) result = caseVisitable(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PROPERTY_CALL_EXP:
			{
				PropertyCallExp propertyCallExp = (PropertyCallExp)theEObject;
				T1 result = casePropertyCallExp(propertyCallExp);
				if (result == null) result = caseNavigationCallExp(propertyCallExp);
				if (result == null) result = caseReferringElement(propertyCallExp);
				if (result == null) result = caseFeatureCallExp(propertyCallExp);
				if (result == null) result = caseCallExp(propertyCallExp);
				if (result == null) result = caseOCLExpression(propertyCallExp);
				if (result == null) result = caseTypedElement(propertyCallExp);
				if (result == null) result = caseNamedElement(propertyCallExp);
				if (result == null) result = caseElement(propertyCallExp);
				if (result == null) result = caseNameable(propertyCallExp);
				if (result == null) result = caseVisitable(propertyCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.PSEUDOSTATE:
			{
				Pseudostate pseudostate = (Pseudostate)theEObject;
				T1 result = casePseudostate(pseudostate);
				if (result == null) result = caseVertex(pseudostate);
				if (result == null) result = caseNamedElement(pseudostate);
				if (result == null) result = caseElement(pseudostate);
				if (result == null) result = caseNameable(pseudostate);
				if (result == null) result = caseVisitable(pseudostate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.REAL_LITERAL_EXP:
			{
				RealLiteralExp realLiteralExp = (RealLiteralExp)theEObject;
				T1 result = caseRealLiteralExp(realLiteralExp);
				if (result == null) result = caseNumericLiteralExp(realLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(realLiteralExp);
				if (result == null) result = caseLiteralExp(realLiteralExp);
				if (result == null) result = caseOCLExpression(realLiteralExp);
				if (result == null) result = caseTypedElement(realLiteralExp);
				if (result == null) result = caseNamedElement(realLiteralExp);
				if (result == null) result = caseElement(realLiteralExp);
				if (result == null) result = caseNameable(realLiteralExp);
				if (result == null) result = caseVisitable(realLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.REFERRING_ELEMENT:
			{
				ReferringElement referringElement = (ReferringElement)theEObject;
				T1 result = caseReferringElement(referringElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.REGION:
			{
				Region region = (Region)theEObject;
				T1 result = caseRegion(region);
				if (result == null) result = caseNamespace(region);
				if (result == null) result = caseNamedElement(region);
				if (result == null) result = caseElement(region);
				if (result == null) result = caseNameable(region);
				if (result == null) result = caseVisitable(region);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.ROOT:
			{
				Root root = (Root)theEObject;
				T1 result = caseRoot(root);
				if (result == null) result = caseNamespace(root);
				if (result == null) result = caseNamedElement(root);
				if (result == null) result = caseElement(root);
				if (result == null) result = caseNameable(root);
				if (result == null) result = caseVisitable(root);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.SELF_TYPE:
			{
				SelfType selfType = (SelfType)theEObject;
				T1 result = caseSelfType(selfType);
				if (result == null) result = caseClass(selfType);
				if (result == null) result = caseType(selfType);
				if (result == null) result = caseNamespace(selfType);
				if (result == null) result = caseNamedElement(selfType);
				if (result == null) result = caseTemplateableElement(selfType);
				if (result == null) result = caseParameterableElement(selfType);
				if (result == null) result = caseElement(selfType);
				if (result == null) result = caseNameable(selfType);
				if (result == null) result = caseVisitable(selfType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.SEND_SIGNAL_ACTION:
			{
				SendSignalAction sendSignalAction = (SendSignalAction)theEObject;
				T1 result = caseSendSignalAction(sendSignalAction);
				if (result == null) result = caseNamedElement(sendSignalAction);
				if (result == null) result = caseElement(sendSignalAction);
				if (result == null) result = caseNameable(sendSignalAction);
				if (result == null) result = caseVisitable(sendSignalAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.SEQUENCE_TYPE:
			{
				SequenceType sequenceType = (SequenceType)theEObject;
				T1 result = caseSequenceType(sequenceType);
				if (result == null) result = caseCollectionType(sequenceType);
				if (result == null) result = caseDataType(sequenceType);
				if (result == null) result = caseClass(sequenceType);
				if (result == null) result = caseType(sequenceType);
				if (result == null) result = caseNamespace(sequenceType);
				if (result == null) result = caseNamedElement(sequenceType);
				if (result == null) result = caseTemplateableElement(sequenceType);
				if (result == null) result = caseParameterableElement(sequenceType);
				if (result == null) result = caseElement(sequenceType);
				if (result == null) result = caseNameable(sequenceType);
				if (result == null) result = caseVisitable(sequenceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.SET_TYPE:
			{
				SetType setType = (SetType)theEObject;
				T1 result = caseSetType(setType);
				if (result == null) result = caseCollectionType(setType);
				if (result == null) result = caseDataType(setType);
				if (result == null) result = caseClass(setType);
				if (result == null) result = caseType(setType);
				if (result == null) result = caseNamespace(setType);
				if (result == null) result = caseNamedElement(setType);
				if (result == null) result = caseTemplateableElement(setType);
				if (result == null) result = caseParameterableElement(setType);
				if (result == null) result = caseElement(setType);
				if (result == null) result = caseNameable(setType);
				if (result == null) result = caseVisitable(setType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.SIGNAL:
			{
				Signal signal = (Signal)theEObject;
				T1 result = caseSignal(signal);
				if (result == null) result = caseNamedElement(signal);
				if (result == null) result = caseElement(signal);
				if (result == null) result = caseNameable(signal);
				if (result == null) result = caseVisitable(signal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.STATE:
			{
				State state = (State)theEObject;
				T1 result = caseState(state);
				if (result == null) result = caseVertex(state);
				if (result == null) result = caseNamespace(state);
				if (result == null) result = caseNamedElement(state);
				if (result == null) result = caseElement(state);
				if (result == null) result = caseNameable(state);
				if (result == null) result = caseVisitable(state);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.STATE_EXP:
			{
				StateExp stateExp = (StateExp)theEObject;
				T1 result = caseStateExp(stateExp);
				if (result == null) result = caseOCLExpression(stateExp);
				if (result == null) result = caseTypedElement(stateExp);
				if (result == null) result = caseNamedElement(stateExp);
				if (result == null) result = caseElement(stateExp);
				if (result == null) result = caseNameable(stateExp);
				if (result == null) result = caseVisitable(stateExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.STATE_MACHINE:
			{
				StateMachine stateMachine = (StateMachine)theEObject;
				T1 result = caseStateMachine(stateMachine);
				if (result == null) result = caseBehavior(stateMachine);
				if (result == null) result = caseClass(stateMachine);
				if (result == null) result = caseType(stateMachine);
				if (result == null) result = caseNamespace(stateMachine);
				if (result == null) result = caseNamedElement(stateMachine);
				if (result == null) result = caseTemplateableElement(stateMachine);
				if (result == null) result = caseParameterableElement(stateMachine);
				if (result == null) result = caseElement(stateMachine);
				if (result == null) result = caseNameable(stateMachine);
				if (result == null) result = caseVisitable(stateMachine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.STEREOTYPE:
			{
				Stereotype stereotype = (Stereotype)theEObject;
				T1 result = caseStereotype(stereotype);
				if (result == null) result = caseClass(stereotype);
				if (result == null) result = caseType(stereotype);
				if (result == null) result = caseNamespace(stereotype);
				if (result == null) result = caseNamedElement(stereotype);
				if (result == null) result = caseTemplateableElement(stereotype);
				if (result == null) result = caseParameterableElement(stereotype);
				if (result == null) result = caseElement(stereotype);
				if (result == null) result = caseNameable(stereotype);
				if (result == null) result = caseVisitable(stereotype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.STRING_LITERAL_EXP:
			{
				StringLiteralExp stringLiteralExp = (StringLiteralExp)theEObject;
				T1 result = caseStringLiteralExp(stringLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(stringLiteralExp);
				if (result == null) result = caseLiteralExp(stringLiteralExp);
				if (result == null) result = caseOCLExpression(stringLiteralExp);
				if (result == null) result = caseTypedElement(stringLiteralExp);
				if (result == null) result = caseNamedElement(stringLiteralExp);
				if (result == null) result = caseElement(stringLiteralExp);
				if (result == null) result = caseNameable(stringLiteralExp);
				if (result == null) result = caseVisitable(stringLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TEMPLATE_BINDING:
			{
				TemplateBinding templateBinding = (TemplateBinding)theEObject;
				T1 result = caseTemplateBinding(templateBinding);
				if (result == null) result = caseElement(templateBinding);
				if (result == null) result = caseVisitable(templateBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TEMPLATE_PARAMETER:
			{
				TemplateParameter templateParameter = (TemplateParameter)theEObject;
				T1 result = caseTemplateParameter(templateParameter);
				if (result == null) result = caseElement(templateParameter);
				if (result == null) result = caseVisitable(templateParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION:
			{
				TemplateParameterSubstitution templateParameterSubstitution = (TemplateParameterSubstitution)theEObject;
				T1 result = caseTemplateParameterSubstitution(templateParameterSubstitution);
				if (result == null) result = caseElement(templateParameterSubstitution);
				if (result == null) result = caseVisitable(templateParameterSubstitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TEMPLATE_PARAMETER_TYPE:
			{
				TemplateParameterType templateParameterType = (TemplateParameterType)theEObject;
				T1 result = caseTemplateParameterType(templateParameterType);
				if (result == null) result = caseType(templateParameterType);
				if (result == null) result = caseNamedElement(templateParameterType);
				if (result == null) result = caseTemplateableElement(templateParameterType);
				if (result == null) result = caseParameterableElement(templateParameterType);
				if (result == null) result = caseElement(templateParameterType);
				if (result == null) result = caseNameable(templateParameterType);
				if (result == null) result = caseVisitable(templateParameterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TEMPLATE_SIGNATURE:
			{
				TemplateSignature templateSignature = (TemplateSignature)theEObject;
				T1 result = caseTemplateSignature(templateSignature);
				if (result == null) result = caseElement(templateSignature);
				if (result == null) result = caseVisitable(templateSignature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TEMPLATEABLE_ELEMENT:
			{
				TemplateableElement templateableElement = (TemplateableElement)theEObject;
				T1 result = caseTemplateableElement(templateableElement);
				if (result == null) result = caseElement(templateableElement);
				if (result == null) result = caseVisitable(templateableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TRANSITION:
			{
				Transition transition = (Transition)theEObject;
				T1 result = caseTransition(transition);
				if (result == null) result = caseNamespace(transition);
				if (result == null) result = caseNamedElement(transition);
				if (result == null) result = caseElement(transition);
				if (result == null) result = caseNameable(transition);
				if (result == null) result = caseVisitable(transition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TRIGGER:
			{
				Trigger trigger = (Trigger)theEObject;
				T1 result = caseTrigger(trigger);
				if (result == null) result = caseNamedElement(trigger);
				if (result == null) result = caseElement(trigger);
				if (result == null) result = caseNameable(trigger);
				if (result == null) result = caseVisitable(trigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TUPLE_LITERAL_EXP:
			{
				TupleLiteralExp tupleLiteralExp = (TupleLiteralExp)theEObject;
				T1 result = caseTupleLiteralExp(tupleLiteralExp);
				if (result == null) result = caseLiteralExp(tupleLiteralExp);
				if (result == null) result = caseOCLExpression(tupleLiteralExp);
				if (result == null) result = caseTypedElement(tupleLiteralExp);
				if (result == null) result = caseNamedElement(tupleLiteralExp);
				if (result == null) result = caseElement(tupleLiteralExp);
				if (result == null) result = caseNameable(tupleLiteralExp);
				if (result == null) result = caseVisitable(tupleLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TUPLE_LITERAL_PART:
			{
				TupleLiteralPart tupleLiteralPart = (TupleLiteralPart)theEObject;
				T1 result = caseTupleLiteralPart(tupleLiteralPart);
				if (result == null) result = caseVariableDeclaration(tupleLiteralPart);
				if (result == null) result = caseTypedElement(tupleLiteralPart);
				if (result == null) result = caseNamedElement(tupleLiteralPart);
				if (result == null) result = caseElement(tupleLiteralPart);
				if (result == null) result = caseNameable(tupleLiteralPart);
				if (result == null) result = caseVisitable(tupleLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TUPLE_TYPE:
			{
				TupleType tupleType = (TupleType)theEObject;
				T1 result = caseTupleType(tupleType);
				if (result == null) result = caseDataType(tupleType);
				if (result == null) result = caseClass(tupleType);
				if (result == null) result = caseType(tupleType);
				if (result == null) result = caseNamespace(tupleType);
				if (result == null) result = caseNamedElement(tupleType);
				if (result == null) result = caseTemplateableElement(tupleType);
				if (result == null) result = caseParameterableElement(tupleType);
				if (result == null) result = caseElement(tupleType);
				if (result == null) result = caseNameable(tupleType);
				if (result == null) result = caseVisitable(tupleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TYPE:
			{
				Type type = (Type)theEObject;
				T1 result = caseType(type);
				if (result == null) result = caseNamedElement(type);
				if (result == null) result = caseTemplateableElement(type);
				if (result == null) result = caseParameterableElement(type);
				if (result == null) result = caseElement(type);
				if (result == null) result = caseNameable(type);
				if (result == null) result = caseVisitable(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TYPE_EXP:
			{
				TypeExp typeExp = (TypeExp)theEObject;
				T1 result = caseTypeExp(typeExp);
				if (result == null) result = caseOCLExpression(typeExp);
				if (result == null) result = caseReferringElement(typeExp);
				if (result == null) result = caseTypedElement(typeExp);
				if (result == null) result = caseNamedElement(typeExp);
				if (result == null) result = caseElement(typeExp);
				if (result == null) result = caseNameable(typeExp);
				if (result == null) result = caseVisitable(typeExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TYPE_EXTENSION:
			{
				TypeExtension typeExtension = (TypeExtension)theEObject;
				T1 result = caseTypeExtension(typeExtension);
				if (result == null) result = caseElement(typeExtension);
				if (result == null) result = caseVisitable(typeExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TYPE_TEMPLATE_PARAMETER:
			{
				TypeTemplateParameter typeTemplateParameter = (TypeTemplateParameter)theEObject;
				T1 result = caseTypeTemplateParameter(typeTemplateParameter);
				if (result == null) result = caseTemplateParameter(typeTemplateParameter);
				if (result == null) result = caseElement(typeTemplateParameter);
				if (result == null) result = caseVisitable(typeTemplateParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TYPED_ELEMENT:
			{
				TypedElement typedElement = (TypedElement)theEObject;
				T1 result = caseTypedElement(typedElement);
				if (result == null) result = caseNamedElement(typedElement);
				if (result == null) result = caseElement(typedElement);
				if (result == null) result = caseNameable(typedElement);
				if (result == null) result = caseVisitable(typedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT:
			{
				TypedMultiplicityElement typedMultiplicityElement = (TypedMultiplicityElement)theEObject;
				T1 result = caseTypedMultiplicityElement(typedMultiplicityElement);
				if (result == null) result = caseTypedElement(typedMultiplicityElement);
				if (result == null) result = caseNamedElement(typedMultiplicityElement);
				if (result == null) result = caseElement(typedMultiplicityElement);
				if (result == null) result = caseNameable(typedMultiplicityElement);
				if (result == null) result = caseVisitable(typedMultiplicityElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP:
			{
				UnlimitedNaturalLiteralExp unlimitedNaturalLiteralExp = (UnlimitedNaturalLiteralExp)theEObject;
				T1 result = caseUnlimitedNaturalLiteralExp(unlimitedNaturalLiteralExp);
				if (result == null) result = caseNumericLiteralExp(unlimitedNaturalLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(unlimitedNaturalLiteralExp);
				if (result == null) result = caseLiteralExp(unlimitedNaturalLiteralExp);
				if (result == null) result = caseOCLExpression(unlimitedNaturalLiteralExp);
				if (result == null) result = caseTypedElement(unlimitedNaturalLiteralExp);
				if (result == null) result = caseNamedElement(unlimitedNaturalLiteralExp);
				if (result == null) result = caseElement(unlimitedNaturalLiteralExp);
				if (result == null) result = caseNameable(unlimitedNaturalLiteralExp);
				if (result == null) result = caseVisitable(unlimitedNaturalLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.UNSPECIFIED_TYPE:
			{
				UnspecifiedType unspecifiedType = (UnspecifiedType)theEObject;
				T1 result = caseUnspecifiedType(unspecifiedType);
				if (result == null) result = caseClass(unspecifiedType);
				if (result == null) result = caseType(unspecifiedType);
				if (result == null) result = caseNamespace(unspecifiedType);
				if (result == null) result = caseNamedElement(unspecifiedType);
				if (result == null) result = caseTemplateableElement(unspecifiedType);
				if (result == null) result = caseParameterableElement(unspecifiedType);
				if (result == null) result = caseElement(unspecifiedType);
				if (result == null) result = caseNameable(unspecifiedType);
				if (result == null) result = caseVisitable(unspecifiedType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.UNSPECIFIED_VALUE_EXP:
			{
				UnspecifiedValueExp unspecifiedValueExp = (UnspecifiedValueExp)theEObject;
				T1 result = caseUnspecifiedValueExp(unspecifiedValueExp);
				if (result == null) result = caseOCLExpression(unspecifiedValueExp);
				if (result == null) result = caseTypedElement(unspecifiedValueExp);
				if (result == null) result = caseNamedElement(unspecifiedValueExp);
				if (result == null) result = caseElement(unspecifiedValueExp);
				if (result == null) result = caseNameable(unspecifiedValueExp);
				if (result == null) result = caseVisitable(unspecifiedValueExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.VALUE_SPECIFICATION:
			{
				ValueSpecification valueSpecification = (ValueSpecification)theEObject;
				T1 result = caseValueSpecification(valueSpecification);
				if (result == null) result = caseTypedElement(valueSpecification);
				if (result == null) result = caseParameterableElement(valueSpecification);
				if (result == null) result = caseNamedElement(valueSpecification);
				if (result == null) result = caseElement(valueSpecification);
				if (result == null) result = caseNameable(valueSpecification);
				if (result == null) result = caseVisitable(valueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.VARIABLE:
			{
				Variable variable = (Variable)theEObject;
				T1 result = caseVariable(variable);
				if (result == null) result = caseVariableDeclaration(variable);
				if (result == null) result = caseTypedElement(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = caseElement(variable);
				if (result == null) result = caseNameable(variable);
				if (result == null) result = caseVisitable(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.VARIABLE_DECLARATION:
			{
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T1 result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = caseTypedElement(variableDeclaration);
				if (result == null) result = caseNamedElement(variableDeclaration);
				if (result == null) result = caseElement(variableDeclaration);
				if (result == null) result = caseNameable(variableDeclaration);
				if (result == null) result = caseVisitable(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.VARIABLE_EXP:
			{
				VariableExp variableExp = (VariableExp)theEObject;
				T1 result = caseVariableExp(variableExp);
				if (result == null) result = caseOCLExpression(variableExp);
				if (result == null) result = caseReferringElement(variableExp);
				if (result == null) result = caseTypedElement(variableExp);
				if (result == null) result = caseNamedElement(variableExp);
				if (result == null) result = caseElement(variableExp);
				if (result == null) result = caseNameable(variableExp);
				if (result == null) result = caseVisitable(variableExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.VERTEX:
			{
				Vertex vertex = (Vertex)theEObject;
				T1 result = caseVertex(vertex);
				if (result == null) result = caseNamedElement(vertex);
				if (result == null) result = caseElement(vertex);
				if (result == null) result = caseNameable(vertex);
				if (result == null) result = caseVisitable(vertex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.VISITABLE:
			{
				Visitable visitable = (Visitable)theEObject;
				T1 result = caseVisitable(visitable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.VISITOR:
			{
				Visitor<?> visitor = (Visitor<?>)theEObject;
				T1 result = caseVisitor(visitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PivotPackage.VOID_TYPE:
			{
				VoidType voidType = (VoidType)theEObject;
				T1 result = caseVoidType(voidType);
				if (result == null) result = caseClass(voidType);
				if (result == null) result = caseType(voidType);
				if (result == null) result = caseNamespace(voidType);
				if (result == null) result = caseNamedElement(voidType);
				if (result == null) result = caseTemplateableElement(voidType);
				if (result == null) result = caseParameterableElement(voidType);
				if (result == null) result = caseElement(voidType);
				if (result == null) result = caseNameable(voidType);
				if (result == null) result = caseVisitable(voidType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseElementExtension(ElementExtension object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBagType(BagType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBehavior(Behavior object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCollectionType(CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBooleanLiteralExp(BooleanLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePrimitiveLiteralExp(PrimitiveLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLiteralExp(LiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Operation Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Operation Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCallOperationAction(CallOperationAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCollectionItem(CollectionItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCollectionLiteralPart(CollectionLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCollectionLiteralExp(CollectionLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCollectionRange(CollectionRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumLiteralExp(EnumLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumerationLiteral(EnumerationLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseExpressionInOCL(ExpressionInOCL object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumeration(Enumeration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFeature(Feature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opaque Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opaque Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOpaqueExpression(OpaqueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIfExp(IfExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImport(Import object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntegerLiteralExp(IntegerLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNumericLiteralExp(NumericLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOCLExpression(OCLExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInvalidLiteralExp(InvalidLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInvalidType(InvalidType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIterateExp(IterateExp object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iteration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIteration(Iteration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIteratorExp(IteratorExp object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lambda Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lambda Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLambdaType(LambdaType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLetExp(LetExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLibrary(Library object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLoopExp(LoopExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMessageExp(MessageExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Send Signal Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Send Signal Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSendSignalAction(SendSignalAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSignal(Signal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMessageType(MessageType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metaclass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metaclass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseMetaclass(Metaclass<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>More Pivotable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>More Pivotable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMorePivotable(MorePivotable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNameable(Nameable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNullLiteralExp(NullLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOperationCallExp(OperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOrderedSetType(OrderedSetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Packageable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Packageable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePackageableElement(PackageableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Profile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Profile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProfile(Profile object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Profile Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Profile Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProfileApplication(ProfileApplication object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePropertyCallExp(PropertyCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pseudostate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePseudostate(Pseudostate object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRealLiteralExp(RealLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referring Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referring Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseReferringElement(ReferringElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRegion(Region object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRoot(Root object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Self Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Self Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSelfType(SelfType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSequenceType(SequenceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSetType(SetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseState(State object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStateExp(StateExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Machine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStateMachine(StateMachine object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStereotype(Stereotype object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStringLiteralExp(StringLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTemplateParameterType(TemplateParameterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTupleLiteralExp(TupleLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTupleLiteralPart(TupleLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTupleType(TupleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypeExp(TypeExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypeExtension(TypeExtension object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unspecified Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unspecified Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseUnspecifiedType(UnspecifiedType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unspecified Value Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unspecified Value Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseUnspecifiedValueExp(UnspecifiedValueExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVariableExp(VariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vertex</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVertex(Vertex object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVoidType(VoidType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePivotable(Pivotable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVisitable(Visitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseClass(org.eclipse.ocl.examples.pivot.Class object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Templateable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Templateable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTemplateableElement(TemplateableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTransition(Transition object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTrigger(Trigger object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTemplateBinding(TemplateBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Signature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Signature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTemplateSignature(TemplateSignature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTemplateParameter(TemplateParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseParameterableElement(ParameterableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter Substitution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTemplateParameterSubstitution(
			TemplateParameterSubstitution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePackage(org.eclipse.ocl.examples.pivot.Package object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Precedence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Precedence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePrecedence(Precedence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Template Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypeTemplateParameter(TypeTemplateParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Multiplicity Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Multiplicity Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypedMultiplicityElement(TypedMultiplicityElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAssociationClass(AssociationClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Template Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOperationTemplateParameter(OperationTemplateParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opposite Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opposite Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOppositePropertyCallExp(OppositePropertyCallExp object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseComment(Comment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Point Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Point Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConnectionPointReference(ConnectionPointReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConstructorExp(ConstructorExp object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConstructorPart(ConstructorPart object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseValueSpecification(ValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Detail</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Detail</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDetail(Detail object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDynamicBehavior(DynamicBehavior object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDynamicElement(DynamicElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDynamicProperty(DynamicProperty object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDynamicType(DynamicType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAnyType(AnyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Class Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Class Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAssociationClassCallExp(AssociationClassCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNavigationCallExp(NavigationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFeatureCallExp(FeatureCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Final State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFinalState(FinalState object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCallExp(CallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R> T1 caseVisitor(Visitor<R> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //PivotSwitch
