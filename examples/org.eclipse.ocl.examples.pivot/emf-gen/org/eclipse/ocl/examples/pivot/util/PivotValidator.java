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

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CallOperationAction;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionKind;
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
import org.eclipse.ocl.examples.pivot.PseudostateKind;
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
import org.eclipse.ocl.examples.pivot.TransitionKind;
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
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.pivot.PivotPackage
 * @generated
 */
@SuppressWarnings("cast")
public class PivotValidator
		extends EObjectValidator {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final PivotValidator INSTANCE = new PivotValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.examples.pivot"; //$NON-NLS-1$

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Boolean' of 'Boolean Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BOOLEAN_LITERAL_EXP__TYPE_IS_BOOLEAN = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Item Type' of 'Collection Item'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_ITEM__TYPE_IS_ITEM_TYPE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Bag Kind Is Bag' of 'Collection Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_LITERAL_EXP__BAG_KIND_IS_BAG = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sequence Kind Is Sequence' of 'Collection Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_LITERAL_EXP__SEQUENCE_KIND_IS_SEQUENCE = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Ordered Set Kind Is Ordered Set' of 'Collection Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_LITERAL_EXP__ORDERED_SET_KIND_IS_ORDERED_SET = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Set Kind Is Set' of 'Collection Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_LITERAL_EXP__SET_KIND_IS_SET = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Collection Kind Is Concrete' of 'Collection Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_LITERAL_EXP__COLLECTION_KIND_IS_CONCRETE = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unique Name' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__UNIQUE_NAME = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Enumeration Type' of 'Enum Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ENUM_LITERAL_EXP__TYPE_IS_ENUMERATION_TYPE = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Condition Type Is Boolean' of 'If Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IF_EXP__CONDITION_TYPE_IS_BOOLEAN = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Integer' of 'Integer Literal Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTEGER_LITERAL_EXP__TYPE_IS_INTEGER = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Initializer' of 'Iterate Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATE_EXP__ONE_INITIALIZER = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Body Type Is Conformantto Iterator Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__CLOSURE_BODY_TYPE_IS_CONFORMANTTO_ITERATOR_TYPE = 18;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sorted By Iterator Type Is Comparable' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__SORTED_BY_ITERATOR_TYPE_IS_COMPARABLE = 45;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Body Type Conforms To Result Type' of 'Iterate Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATE_EXP__BODY_TYPE_CONFORMS_TO_RESULT_TYPE = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Result Type' of 'Iterate Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATE_EXP__TYPE_IS_RESULT_TYPE = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Iterator Type Is Source Element Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__ITERATOR_TYPE_IS_SOURCE_ELEMENT_TYPE = 35;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sorted By Element Type Is Source Element Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__SORTED_BY_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE = 42;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sorted By Is Ordered If Source Is Ordered' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__SORTED_BY_IS_ORDERED_IF_SOURCE_IS_ORDERED = 44;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sorted By Has One Iterator' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__SORTED_BY_HAS_ONE_ITERATOR = 43;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Reject Or Select Type Is Boolean' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__REJECT_OR_SELECT_TYPE_IS_BOOLEAN = 40;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Reject Or Select Type Is Source Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__REJECT_OR_SELECT_TYPE_IS_SOURCE_TYPE = 41;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Reject Or Select Has One Iterator' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__REJECT_OR_SELECT_HAS_ONE_ITERATOR = 39;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Body Type Is Boolean' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__ONE_BODY_TYPE_IS_BOOLEAN = 36;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Type Is Boolean' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__ONE_TYPE_IS_BOOLEAN = 38;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Has One Iterator' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__ONE_HAS_ONE_ITERATOR = 37;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Is Unique Type Is Boolean' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__IS_UNIQUE_TYPE_IS_BOOLEAN = 34;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Is Unique Has One Iterator' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__IS_UNIQUE_HAS_ONE_ITERATOR = 33;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate For All Body Type Is Boolean' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__FOR_ALL_BODY_TYPE_IS_BOOLEAN = 31;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate For All Type Is Boolean' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__FOR_ALL_TYPE_IS_BOOLEAN = 32;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Exists Body Type Is Boolean' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__EXISTS_BODY_TYPE_IS_BOOLEAN = 29;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Exists Type Is Boolean' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__EXISTS_TYPE_IS_BOOLEAN = 30;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Collect Nested Type Is Body Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__COLLECT_NESTED_TYPE_IS_BODY_TYPE = 27;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Collect Nested Type Is Bag' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__COLLECT_NESTED_TYPE_IS_BAG = 26;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Collect Nested Has One Iterator' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__COLLECT_NESTED_HAS_ONE_ITERATOR = 25;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Collect Element Type Is Source Element Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__COLLECT_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE = 23;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Collect Type Is Unordered' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__COLLECT_TYPE_IS_UNORDERED = 28;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Collect Has One Iterator' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__COLLECT_HAS_ONE_ITERATOR = 24;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Element Type Is Source Element Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__CLOSURE_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE = 19;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Source Element Type Is Body Element Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__CLOSURE_SOURCE_ELEMENT_TYPE_IS_BODY_ELEMENT_TYPE = 21;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Type Is Unique Collection' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__CLOSURE_TYPE_IS_UNIQUE_COLLECTION = 22;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Closure Has One Iterator' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__CLOSURE_HAS_ONE_ITERATOR = 20;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Any Body Type Is Boolean' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__ANY_BODY_TYPE_IS_BOOLEAN = 15;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Any Type Is Source Element Type' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__ANY_TYPE_IS_SOURCE_ELEMENT_TYPE = 17;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Any Has One Iterator' of 'Iterator Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ITERATOR_EXP__ANY_HAS_ONE_ITERATOR = 16;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is In Type' of 'Let Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LET_EXP__TYPE_IS_IN_TYPE = 46;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Initializers' of 'Loop Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_EXP__NO_INITIALIZERS = 47;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Is Collection' of 'Loop Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_EXP__SOURCE_IS_COLLECTION = 48;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Is Not ACollection' of 'Message Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE_EXP__TARGET_IS_NOT_ACOLLECTION = 50;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Return' of 'Operation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION__COMPATIBLE_RETURN = 51;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Call Or One Send' of 'Message Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE_EXP__ONE_CALL_OR_ONE_SEND = 49;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Loadable Implementation' of 'Operation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION__LOADABLE_IMPLEMENTATION = 52;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unique Precondition Name' of 'Operation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION__UNIQUE_PRECONDITION_NAME = 54;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unique Postcondition Name' of 'Operation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION__UNIQUE_POSTCONDITION_NAME = 53;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Argument Type Is Conformant' of 'Operation Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_CALL_EXP__ARGUMENT_TYPE_IS_CONFORMANT = 56;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Argument Count' of 'Operation Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION_CALL_EXP__ARGUMENT_COUNT = 55;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Default Expression' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__COMPATIBLE_DEFAULT_EXPRESSION = 57;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Non Static Source Type Is Conformant' of 'Property Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_CALL_EXP__NON_STATIC_SOURCE_TYPE_IS_CONFORMANT = 59;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Result Type' of 'Property Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_CALL_EXP__COMPATIBLE_RESULT_TYPE = 58;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unique Invariant Name' of 'Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TYPE__UNIQUE_INVARIANT_NAME = 60;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Initialiser Type' of 'Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VARIABLE__COMPATIBLE_INITIALISER_TYPE = 61;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 61;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PivotValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return PivotPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID)
		{
			case PivotPackage.ANNOTATION:
				return validateAnnotation((Annotation)value, diagnostics, context);
			case PivotPackage.ANY_TYPE:
				return validateAnyType((AnyType)value, diagnostics, context);
			case PivotPackage.ASSOCIATION_CLASS:
				return validateAssociationClass((AssociationClass)value, diagnostics, context);
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP:
				return validateAssociationClassCallExp((AssociationClassCallExp)value, diagnostics, context);
			case PivotPackage.BAG_TYPE:
				return validateBagType((BagType)value, diagnostics, context);
			case PivotPackage.BEHAVIOR:
				return validateBehavior((Behavior)value, diagnostics, context);
			case PivotPackage.BOOLEAN_LITERAL_EXP:
				return validateBooleanLiteralExp((BooleanLiteralExp)value, diagnostics, context);
			case PivotPackage.CALL_EXP:
				return validateCallExp((CallExp)value, diagnostics, context);
			case PivotPackage.CALL_OPERATION_ACTION:
				return validateCallOperationAction((CallOperationAction)value, diagnostics, context);
			case PivotPackage.CLASS:
				return validateClass((org.eclipse.ocl.examples.pivot.Class)value, diagnostics, context);
			case PivotPackage.COLLECTION_ITEM:
				return validateCollectionItem((CollectionItem)value, diagnostics, context);
			case PivotPackage.COLLECTION_LITERAL_EXP:
				return validateCollectionLiteralExp((CollectionLiteralExp)value, diagnostics, context);
			case PivotPackage.COLLECTION_LITERAL_PART:
				return validateCollectionLiteralPart((CollectionLiteralPart)value, diagnostics, context);
			case PivotPackage.COLLECTION_RANGE:
				return validateCollectionRange((CollectionRange)value, diagnostics, context);
			case PivotPackage.COLLECTION_TYPE:
				return validateCollectionType((CollectionType)value, diagnostics, context);
			case PivotPackage.COMMENT:
				return validateComment((Comment)value, diagnostics, context);
			case PivotPackage.CONNECTION_POINT_REFERENCE:
				return validateConnectionPointReference((ConnectionPointReference)value, diagnostics, context);
			case PivotPackage.CONSTRAINT:
				return validateConstraint((Constraint)value, diagnostics, context);
			case PivotPackage.CONSTRUCTOR_EXP:
				return validateConstructorExp((ConstructorExp)value, diagnostics, context);
			case PivotPackage.CONSTRUCTOR_PART:
				return validateConstructorPart((ConstructorPart)value, diagnostics, context);
			case PivotPackage.DATA_TYPE:
				return validateDataType((DataType)value, diagnostics, context);
			case PivotPackage.DETAIL:
				return validateDetail((Detail)value, diagnostics, context);
			case PivotPackage.DYNAMIC_BEHAVIOR:
				return validateDynamicBehavior((DynamicBehavior)value, diagnostics, context);
			case PivotPackage.DYNAMIC_ELEMENT:
				return validateDynamicElement((DynamicElement)value, diagnostics, context);
			case PivotPackage.DYNAMIC_PROPERTY:
				return validateDynamicProperty((DynamicProperty)value, diagnostics, context);
			case PivotPackage.DYNAMIC_TYPE:
				return validateDynamicType((DynamicType)value, diagnostics, context);
			case PivotPackage.ELEMENT:
				return validateElement((Element)value, diagnostics, context);
			case PivotPackage.ELEMENT_EXTENSION:
				return validateElementExtension((ElementExtension)value, diagnostics, context);
			case PivotPackage.ENUM_LITERAL_EXP:
				return validateEnumLiteralExp((EnumLiteralExp)value, diagnostics, context);
			case PivotPackage.ENUMERATION:
				return validateEnumeration((Enumeration)value, diagnostics, context);
			case PivotPackage.ENUMERATION_LITERAL:
				return validateEnumerationLiteral((EnumerationLiteral)value, diagnostics, context);
			case PivotPackage.EXPRESSION_IN_OCL:
				return validateExpressionInOCL((ExpressionInOCL)value, diagnostics, context);
			case PivotPackage.FEATURE:
				return validateFeature((Feature)value, diagnostics, context);
			case PivotPackage.FEATURE_CALL_EXP:
				return validateFeatureCallExp((FeatureCallExp)value, diagnostics, context);
			case PivotPackage.FINAL_STATE:
				return validateFinalState((FinalState)value, diagnostics, context);
			case PivotPackage.IF_EXP:
				return validateIfExp((IfExp)value, diagnostics, context);
			case PivotPackage.IMPORT:
				return validateImport((Import)value, diagnostics, context);
			case PivotPackage.INTEGER_LITERAL_EXP:
				return validateIntegerLiteralExp((IntegerLiteralExp)value, diagnostics, context);
			case PivotPackage.INVALID_LITERAL_EXP:
				return validateInvalidLiteralExp((InvalidLiteralExp)value, diagnostics, context);
			case PivotPackage.INVALID_TYPE:
				return validateInvalidType((InvalidType)value, diagnostics, context);
			case PivotPackage.ITERATE_EXP:
				return validateIterateExp((IterateExp)value, diagnostics, context);
			case PivotPackage.ITERATION:
				return validateIteration((Iteration)value, diagnostics, context);
			case PivotPackage.ITERATOR_EXP:
				return validateIteratorExp((IteratorExp)value, diagnostics, context);
			case PivotPackage.LAMBDA_TYPE:
				return validateLambdaType((LambdaType)value, diagnostics, context);
			case PivotPackage.LET_EXP:
				return validateLetExp((LetExp)value, diagnostics, context);
			case PivotPackage.LIBRARY:
				return validateLibrary((Library)value, diagnostics, context);
			case PivotPackage.LITERAL_EXP:
				return validateLiteralExp((LiteralExp)value, diagnostics, context);
			case PivotPackage.LOOP_EXP:
				return validateLoopExp((LoopExp)value, diagnostics, context);
			case PivotPackage.MESSAGE_EXP:
				return validateMessageExp((MessageExp)value, diagnostics, context);
			case PivotPackage.MESSAGE_TYPE:
				return validateMessageType((MessageType)value, diagnostics, context);
			case PivotPackage.METACLASS:
				return validateMetaclass((Metaclass<?>)value, diagnostics, context);
			case PivotPackage.MORE_PIVOTABLE:
				return validateMorePivotable((MorePivotable)value, diagnostics, context);
			case PivotPackage.NAMEABLE:
				return validateNameable((Nameable)value, diagnostics, context);
			case PivotPackage.NAMED_ELEMENT:
				return validateNamedElement((NamedElement)value, diagnostics, context);
			case PivotPackage.NAMESPACE:
				return validateNamespace((Namespace)value, diagnostics, context);
			case PivotPackage.NAVIGATION_CALL_EXP:
				return validateNavigationCallExp((NavigationCallExp)value, diagnostics, context);
			case PivotPackage.NULL_LITERAL_EXP:
				return validateNullLiteralExp((NullLiteralExp)value, diagnostics, context);
			case PivotPackage.NUMERIC_LITERAL_EXP:
				return validateNumericLiteralExp((NumericLiteralExp)value, diagnostics, context);
			case PivotPackage.OCL_EXPRESSION:
				return validateOCLExpression((OCLExpression)value, diagnostics, context);
			case PivotPackage.OPAQUE_EXPRESSION:
				return validateOpaqueExpression((OpaqueExpression)value, diagnostics, context);
			case PivotPackage.OPERATION:
				return validateOperation((Operation)value, diagnostics, context);
			case PivotPackage.OPERATION_CALL_EXP:
				return validateOperationCallExp((OperationCallExp)value, diagnostics, context);
			case PivotPackage.OPERATION_TEMPLATE_PARAMETER:
				return validateOperationTemplateParameter((OperationTemplateParameter)value, diagnostics, context);
			case PivotPackage.OPPOSITE_PROPERTY_CALL_EXP:
				return validateOppositePropertyCallExp((OppositePropertyCallExp)value, diagnostics, context);
			case PivotPackage.ORDERED_SET_TYPE:
				return validateOrderedSetType((OrderedSetType)value, diagnostics, context);
			case PivotPackage.PACKAGE:
				return validatePackage((org.eclipse.ocl.examples.pivot.Package)value, diagnostics, context);
			case PivotPackage.PACKAGEABLE_ELEMENT:
				return validatePackageableElement((PackageableElement)value, diagnostics, context);
			case PivotPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case PivotPackage.PARAMETERABLE_ELEMENT:
				return validateParameterableElement((ParameterableElement)value, diagnostics, context);
			case PivotPackage.PIVOTABLE:
				return validatePivotable((Pivotable)value, diagnostics, context);
			case PivotPackage.PRECEDENCE:
				return validatePrecedence((Precedence)value, diagnostics, context);
			case PivotPackage.PRIMITIVE_LITERAL_EXP:
				return validatePrimitiveLiteralExp((PrimitiveLiteralExp)value, diagnostics, context);
			case PivotPackage.PRIMITIVE_TYPE:
				return validatePrimitiveType((PrimitiveType)value, diagnostics, context);
			case PivotPackage.PROFILE:
				return validateProfile((Profile)value, diagnostics, context);
			case PivotPackage.PROFILE_APPLICATION:
				return validateProfileApplication((ProfileApplication)value, diagnostics, context);
			case PivotPackage.PROPERTY:
				return validateProperty((Property)value, diagnostics, context);
			case PivotPackage.PROPERTY_CALL_EXP:
				return validatePropertyCallExp((PropertyCallExp)value, diagnostics, context);
			case PivotPackage.PSEUDOSTATE:
				return validatePseudostate((Pseudostate)value, diagnostics, context);
			case PivotPackage.REAL_LITERAL_EXP:
				return validateRealLiteralExp((RealLiteralExp)value, diagnostics, context);
			case PivotPackage.REFERRING_ELEMENT:
				return validateReferringElement((ReferringElement)value, diagnostics, context);
			case PivotPackage.REGION:
				return validateRegion((Region)value, diagnostics, context);
			case PivotPackage.ROOT:
				return validateRoot((Root)value, diagnostics, context);
			case PivotPackage.SELF_TYPE:
				return validateSelfType((SelfType)value, diagnostics, context);
			case PivotPackage.SEND_SIGNAL_ACTION:
				return validateSendSignalAction((SendSignalAction)value, diagnostics, context);
			case PivotPackage.SEQUENCE_TYPE:
				return validateSequenceType((SequenceType)value, diagnostics, context);
			case PivotPackage.SET_TYPE:
				return validateSetType((SetType)value, diagnostics, context);
			case PivotPackage.SIGNAL:
				return validateSignal((Signal)value, diagnostics, context);
			case PivotPackage.STATE:
				return validateState((State)value, diagnostics, context);
			case PivotPackage.STATE_EXP:
				return validateStateExp((StateExp)value, diagnostics, context);
			case PivotPackage.STATE_MACHINE:
				return validateStateMachine((StateMachine)value, diagnostics, context);
			case PivotPackage.STEREOTYPE:
				return validateStereotype((Stereotype)value, diagnostics, context);
			case PivotPackage.STRING_LITERAL_EXP:
				return validateStringLiteralExp((StringLiteralExp)value, diagnostics, context);
			case PivotPackage.TEMPLATE_BINDING:
				return validateTemplateBinding((TemplateBinding)value, diagnostics, context);
			case PivotPackage.TEMPLATE_PARAMETER:
				return validateTemplateParameter((TemplateParameter)value, diagnostics, context);
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION:
				return validateTemplateParameterSubstitution((TemplateParameterSubstitution)value, diagnostics, context);
			case PivotPackage.TEMPLATE_PARAMETER_TYPE:
				return validateTemplateParameterType((TemplateParameterType)value, diagnostics, context);
			case PivotPackage.TEMPLATE_SIGNATURE:
				return validateTemplateSignature((TemplateSignature)value, diagnostics, context);
			case PivotPackage.TEMPLATEABLE_ELEMENT:
				return validateTemplateableElement((TemplateableElement)value, diagnostics, context);
			case PivotPackage.TRANSITION:
				return validateTransition((Transition)value, diagnostics, context);
			case PivotPackage.TRIGGER:
				return validateTrigger((Trigger)value, diagnostics, context);
			case PivotPackage.TUPLE_LITERAL_EXP:
				return validateTupleLiteralExp((TupleLiteralExp)value, diagnostics, context);
			case PivotPackage.TUPLE_LITERAL_PART:
				return validateTupleLiteralPart((TupleLiteralPart)value, diagnostics, context);
			case PivotPackage.TUPLE_TYPE:
				return validateTupleType((TupleType)value, diagnostics, context);
			case PivotPackage.TYPE:
				return validateType((Type)value, diagnostics, context);
			case PivotPackage.TYPE_EXP:
				return validateTypeExp((TypeExp)value, diagnostics, context);
			case PivotPackage.TYPE_EXTENSION:
				return validateTypeExtension((TypeExtension)value, diagnostics, context);
			case PivotPackage.TYPE_TEMPLATE_PARAMETER:
				return validateTypeTemplateParameter((TypeTemplateParameter)value, diagnostics, context);
			case PivotPackage.TYPED_ELEMENT:
				return validateTypedElement((TypedElement)value, diagnostics, context);
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT:
				return validateTypedMultiplicityElement((TypedMultiplicityElement)value, diagnostics, context);
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP:
				return validateUnlimitedNaturalLiteralExp((UnlimitedNaturalLiteralExp)value, diagnostics, context);
			case PivotPackage.UNSPECIFIED_TYPE:
				return validateUnspecifiedType((UnspecifiedType)value, diagnostics, context);
			case PivotPackage.UNSPECIFIED_VALUE_EXP:
				return validateUnspecifiedValueExp((UnspecifiedValueExp)value, diagnostics, context);
			case PivotPackage.VALUE_SPECIFICATION:
				return validateValueSpecification((ValueSpecification)value, diagnostics, context);
			case PivotPackage.VARIABLE:
				return validateVariable((Variable)value, diagnostics, context);
			case PivotPackage.VARIABLE_DECLARATION:
				return validateVariableDeclaration((VariableDeclaration)value, diagnostics, context);
			case PivotPackage.VARIABLE_EXP:
				return validateVariableExp((VariableExp)value, diagnostics, context);
			case PivotPackage.VERTEX:
				return validateVertex((Vertex)value, diagnostics, context);
			case PivotPackage.VISITABLE:
				return validateVisitable((Visitable)value, diagnostics, context);
			case PivotPackage.VISITOR:
				return validateVisitor((Visitor<?>)value, diagnostics, context);
			case PivotPackage.VOID_TYPE:
				return validateVoidType((VoidType)value, diagnostics, context);
			case PivotPackage.ASSOCIATIVITY_KIND:
				return validateAssociativityKind((AssociativityKind)value, diagnostics, context);
			case PivotPackage.COLLECTION_KIND:
				return validateCollectionKind((CollectionKind)value, diagnostics, context);
			case PivotPackage.PSEUDOSTATE_KIND:
				return validatePseudostateKind((PseudostateKind)value, diagnostics, context);
			case PivotPackage.TRANSITION_KIND:
				return validateTransitionKind((TransitionKind)value, diagnostics, context);
			case PivotPackage.BOOLEAN:
				return validateBoolean((Boolean)value, diagnostics, context);
			case PivotPackage.INTEGER:
				return validateInteger((Number)value, diagnostics, context);
			case PivotPackage.LIBRARY_FEATURE:
				return validateLibraryFeature((LibraryFeature)value, diagnostics, context);
			case PivotPackage.OBJECT:
				return validateObject(value, diagnostics, context);
			case PivotPackage.REAL:
				return validateReal((Number)value, diagnostics, context);
			case PivotPackage.STRING:
				return validateString((String)value, diagnostics, context);
			case PivotPackage.THROWABLE:
				return validateThrowable((Throwable)value, diagnostics, context);
			case PivotPackage.UNLIMITED_NATURAL:
				return validateUnlimitedNatural((Number)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotation(Annotation annotation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)annotation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyType(AnyType anyType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)anyType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)anyType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(anyType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)type, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)type, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)type, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(type, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateUniqueInvariantName constraint of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType_validateUniqueInvariantName(Type type, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return type.validateUniqueInvariantName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)namedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespace(Namespace namespace,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)namespace, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement(Element element,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)element, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementExtension(ElementExtension elementExtension, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)elementExtension, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)elementExtension, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(elementExtension, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass(org.eclipse.ocl.examples.pivot.Class class_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)class_, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)class_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)class_, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(class_, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)property, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validateProperty_validateCompatibleDefaultExpression(property, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleDefaultExpression constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateCompatibleDefaultExpression(Property property, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return property.validateCompatibleDefaultExpression(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElement(TypedElement typedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)typedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedMultiplicityElement(
			TypedMultiplicityElement typedMultiplicityElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)typedMultiplicityElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnlimitedNaturalLiteralExp(
			UnlimitedNaturalLiteralExp unlimitedNaturalLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)unlimitedNaturalLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnspecifiedType(UnspecifiedType unspecifiedType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)unspecifiedType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)unspecifiedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)unspecifiedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)unspecifiedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)unspecifiedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)unspecifiedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)unspecifiedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)unspecifiedType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)unspecifiedType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(unspecifiedType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterableElement(
			ParameterableElement parameterableElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)parameterableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePivotable(Pivotable pivotable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)pivotable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrecedence(Precedence precedence,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)precedence, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameter(
			TemplateParameter templateParameter, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)templateParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateSignature(
			TemplateSignature templateSignature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)templateSignature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateableElement(
			TemplateableElement templateableElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)templateableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition(Transition transition, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)transition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTrigger(Trigger trigger, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)trigger, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateBinding(TemplateBinding templateBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)templateBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterSubstitution(
			TemplateParameterSubstitution templateParameterSubstitution,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)templateParameterSubstitution, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociationClass(AssociationClass associationClass,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)associationClass, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)associationClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(associationClass, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation(Operation operation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)operation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateCompatibleReturn(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateLoadableImplementation(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateUniquePostconditionName(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateUniquePreconditionName(operation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleReturn constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_validateCompatibleReturn(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operation.validateCompatibleReturn(diagnostics, context);
	}

	/**
	 * Validates the validateLoadableImplementation constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_validateLoadableImplementation(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operation.validateLoadableImplementation(diagnostics, context);
	}

	/**
	 * Validates the validateUniquePreconditionName constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_validateUniquePreconditionName(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operation.validateUniquePreconditionName(diagnostics, context);
	}

	/**
	 * Validates the validateUniquePostconditionName constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_validateUniquePostconditionName(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operation.validateUniquePostconditionName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)parameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationTemplateParameter(
			OperationTemplateParameter operationTemplateParameter,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)operationTemplateParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOppositePropertyCallExp(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)oppositePropertyCallExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComment(Comment comment,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)comment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionPointReference(ConnectionPointReference connectionPointReference, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)connectionPointReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)constraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_validateUniqueName(constraint, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateUniqueName constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_validateUniqueName(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return constraint.validateUniqueName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstructorExp(ConstructorExp constructorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)constructorExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstructorPart(ConstructorPart constructorPart, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)constructorPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackage(
			org.eclipse.ocl.examples.pivot.Package package_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)package_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeTemplateParameter(
			TypeTemplateParameter typeTemplateParameter,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)typeTemplateParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociationClassCallExp(
			AssociationClassCallExp associationClassCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)associationClassCallExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNavigationCallExp(
			NavigationCallExp navigationCallExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)navigationCallExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureCallExp(FeatureCallExp featureCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)featureCallExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalState(FinalState finalState, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)finalState, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallExp(CallExp callExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)callExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallOperationAction(
			CallOperationAction callOperationAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)callOperationAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBagType(BagType bagType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)bagType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)bagType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(bagType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavior(Behavior behavior, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)behavior, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)behavior, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(behavior, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionType(CollectionType collectionType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)collectionType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)collectionType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(collectionType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)dataType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)dataType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(dataType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDetail(Detail detail, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)detail, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDynamicBehavior(DynamicBehavior dynamicBehavior, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)dynamicBehavior, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)dynamicBehavior, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(dynamicBehavior, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDynamicElement(DynamicElement dynamicElement, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)dynamicElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDynamicProperty(DynamicProperty dynamicProperty, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)dynamicProperty, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDynamicType(DynamicType dynamicType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)dynamicType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)dynamicType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(dynamicType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteralExp(
			BooleanLiteralExp booleanLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)booleanLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateBooleanLiteralExp_validateTypeIsBoolean(booleanLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsBoolean constraint of '<em>Boolean Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteralExp_validateTypeIsBoolean(BooleanLiteralExp booleanLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return booleanLiteralExp.validateTypeIsBoolean(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveLiteralExp(
			PrimitiveLiteralExp primitiveLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)primitiveLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralExp(LiteralExp literalExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)literalExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionItem(CollectionItem collectionItem,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)collectionItem, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)collectionItem, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionItem_validateTypeIsItemType(collectionItem, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsItemType constraint of '<em>Collection Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionItem_validateTypeIsItemType(CollectionItem collectionItem, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionItem.validateTypeIsItemType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralPart(
			CollectionLiteralPart collectionLiteralPart,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)collectionLiteralPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp(
			CollectionLiteralExp collectionLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)collectionLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralExp_validateBagKindIsBag(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralExp_validateCollectionKindIsConcrete(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralExp_validateOrderedSetKindIsOrderedSet(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralExp_validateSequenceKindIsSequence(collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionLiteralExp_validateSetKindIsSet(collectionLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateBagKindIsBag constraint of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp_validateBagKindIsBag(CollectionLiteralExp collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionLiteralExp.validateBagKindIsBag(diagnostics, context);
	}

	/**
	 * Validates the validateSequenceKindIsSequence constraint of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp_validateSequenceKindIsSequence(CollectionLiteralExp collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionLiteralExp.validateSequenceKindIsSequence(diagnostics, context);
	}

	/**
	 * Validates the validateOrderedSetKindIsOrderedSet constraint of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp_validateOrderedSetKindIsOrderedSet(CollectionLiteralExp collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionLiteralExp.validateOrderedSetKindIsOrderedSet(diagnostics, context);
	}

	/**
	 * Validates the validateSetKindIsSet constraint of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp_validateSetKindIsSet(CollectionLiteralExp collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionLiteralExp.validateSetKindIsSet(diagnostics, context);
	}

	/**
	 * Validates the validateCollectionKindIsConcrete constraint of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp_validateCollectionKindIsConcrete(CollectionLiteralExp collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return collectionLiteralExp.validateCollectionKindIsConcrete(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionRange(CollectionRange collectionRange,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)collectionRange, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumLiteralExp(EnumLiteralExp enumLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)enumLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateEnumLiteralExp_validateTypeIsEnumerationType(enumLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsEnumerationType constraint of '<em>Enum Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumLiteralExp_validateTypeIsEnumerationType(EnumLiteralExp enumLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return enumLiteralExp.validateTypeIsEnumerationType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationLiteral(
			EnumerationLiteral enumerationLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)enumerationLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionInOCL(ExpressionInOCL expressionInOCL, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)expressionInOCL, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumeration(Enumeration enumeration,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)enumeration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(enumeration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeature(Feature feature,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)feature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueExpression(OpaqueExpression opaqueExpression,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)opaqueExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable(Variable variable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)variable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)variable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)variable, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariable_validateCompatibleInitialiserType(variable, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleInitialiserType constraint of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable_validateCompatibleInitialiserType(Variable variable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return variable.validateCompatibleInitialiserType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableDeclaration(
			VariableDeclaration variableDeclaration,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)variableDeclaration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfExp(IfExp ifExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)ifExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)ifExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIfExp_validateConditionTypeIsBoolean(ifExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateConditionTypeIsBoolean constraint of '<em>If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfExp_validateConditionTypeIsBoolean(IfExp ifExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return ifExp.validateConditionTypeIsBoolean(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImport(Import import_, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)import_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerLiteralExp(
			IntegerLiteralExp integerLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)integerLiteralExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIntegerLiteralExp_validateTypeIsInteger(integerLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsInteger constraint of '<em>Integer Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerLiteralExp_validateTypeIsInteger(IntegerLiteralExp integerLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return integerLiteralExp.validateTypeIsInteger(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericLiteralExp(
			NumericLiteralExp numericLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)numericLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOCLExpression(OCLExpression oclExpression, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)oclExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvalidLiteralExp(
			InvalidLiteralExp invalidLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)invalidLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvalidType(InvalidType invalidType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)invalidType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)invalidType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(invalidType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)iterateExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoInitializers(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateSourceIsCollection(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIterateExp_validateBodyTypeConformsToResultType(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIterateExp_validateOneInitializer(iterateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIterateExp_validateTypeIsResultType(iterateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOneInitializer constraint of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp_validateOneInitializer(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iterateExp.validateOneInitializer(diagnostics, context);
	}

	/**
	 * Validates the validateBodyTypeConformsToResultType constraint of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp_validateBodyTypeConformsToResultType(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iterateExp.validateBodyTypeConformsToResultType(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsResultType constraint of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp_validateTypeIsResultType(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iterateExp.validateTypeIsResultType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteration(Iteration iteration, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)iteration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateCompatibleReturn(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateLoadableImplementation(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateUniquePostconditionName(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateUniquePreconditionName(iteration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)iteratorExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoInitializers(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateSourceIsCollection(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateAnyBodyTypeIsBoolean(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateAnyHasOneIterator(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateAnyTypeIsSourceElementType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureBodyTypeIsConformanttoIteratorType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureElementTypeIsSourceElementType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureHasOneIterator(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureSourceElementTypeIsBodyElementType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateClosureTypeIsUniqueCollection(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateCollectElementTypeIsSourceElementType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateCollectHasOneIterator(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateCollectNestedHasOneIterator(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateCollectNestedTypeIsBag(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateCollectNestedTypeIsBodyType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateCollectTypeIsUnordered(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateExistsBodyTypeIsBoolean(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateExistsTypeIsBoolean(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateForAllBodyTypeIsBoolean(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateForAllTypeIsBoolean(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateIsUniqueHasOneIterator(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateIsUniqueTypeIsBoolean(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateIteratorTypeIsSourceElementType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateOneBodyTypeIsBoolean(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateOneHasOneIterator(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateOneTypeIsBoolean(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateRejectOrSelectHasOneIterator(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateRejectOrSelectTypeIsBoolean(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateRejectOrSelectTypeIsSourceType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateSortedByElementTypeIsSourceElementType(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateSortedByHasOneIterator(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateSortedByIsOrderedIfSourceIsOrdered(iteratorExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateIteratorExp_validateSortedByIteratorTypeIsComparable(iteratorExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateClosureBodyTypeIsConformanttoIteratorType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureBodyTypeIsConformanttoIteratorType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureBodyTypeIsConformanttoIteratorType(diagnostics, context);
	}

	/**
	 * Validates the validateSortedByIteratorTypeIsComparable constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateSortedByIteratorTypeIsComparable(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateSortedByIteratorTypeIsComparable(diagnostics, context);
	}

	/**
	 * Validates the validateIteratorTypeIsSourceElementType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateIteratorTypeIsSourceElementType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateIteratorTypeIsSourceElementType(diagnostics, context);
	}

	/**
	 * Validates the validateSortedByElementTypeIsSourceElementType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateSortedByElementTypeIsSourceElementType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateSortedByElementTypeIsSourceElementType(diagnostics, context);
	}

	/**
	 * Validates the validateSortedByIsOrderedIfSourceIsOrdered constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateSortedByIsOrderedIfSourceIsOrdered(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateSortedByIsOrderedIfSourceIsOrdered(diagnostics, context);
	}

	/**
	 * Validates the validateSortedByHasOneIterator constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateSortedByHasOneIterator(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateSortedByHasOneIterator(diagnostics, context);
	}

	/**
	 * Validates the validateRejectOrSelectTypeIsBoolean constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateRejectOrSelectTypeIsBoolean(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateRejectOrSelectTypeIsBoolean(diagnostics, context);
	}

	/**
	 * Validates the validateRejectOrSelectTypeIsSourceType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateRejectOrSelectTypeIsSourceType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateRejectOrSelectTypeIsSourceType(diagnostics, context);
	}

	/**
	 * Validates the validateRejectOrSelectHasOneIterator constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateRejectOrSelectHasOneIterator(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateRejectOrSelectHasOneIterator(diagnostics, context);
	}

	/**
	 * Validates the validateOneBodyTypeIsBoolean constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateOneBodyTypeIsBoolean(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateOneBodyTypeIsBoolean(diagnostics, context);
	}

	/**
	 * Validates the validateOneTypeIsBoolean constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateOneTypeIsBoolean(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateOneTypeIsBoolean(diagnostics, context);
	}

	/**
	 * Validates the validateOneHasOneIterator constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateOneHasOneIterator(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateOneHasOneIterator(diagnostics, context);
	}

	/**
	 * Validates the validateIsUniqueTypeIsBoolean constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateIsUniqueTypeIsBoolean(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateIsUniqueTypeIsBoolean(diagnostics, context);
	}

	/**
	 * Validates the validateIsUniqueHasOneIterator constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateIsUniqueHasOneIterator(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateIsUniqueHasOneIterator(diagnostics, context);
	}

	/**
	 * Validates the validateForAllBodyTypeIsBoolean constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateForAllBodyTypeIsBoolean(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateForAllBodyTypeIsBoolean(diagnostics, context);
	}

	/**
	 * Validates the validateForAllTypeIsBoolean constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateForAllTypeIsBoolean(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateForAllTypeIsBoolean(diagnostics, context);
	}

	/**
	 * Validates the validateExistsBodyTypeIsBoolean constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateExistsBodyTypeIsBoolean(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateExistsBodyTypeIsBoolean(diagnostics, context);
	}

	/**
	 * Validates the validateExistsTypeIsBoolean constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateExistsTypeIsBoolean(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateExistsTypeIsBoolean(diagnostics, context);
	}

	/**
	 * Validates the validateCollectNestedTypeIsBodyType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateCollectNestedTypeIsBodyType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateCollectNestedTypeIsBodyType(diagnostics, context);
	}

	/**
	 * Validates the validateCollectNestedTypeIsBag constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateCollectNestedTypeIsBag(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateCollectNestedTypeIsBag(diagnostics, context);
	}

	/**
	 * Validates the validateCollectNestedHasOneIterator constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateCollectNestedHasOneIterator(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateCollectNestedHasOneIterator(diagnostics, context);
	}

	/**
	 * Validates the validateCollectElementTypeIsSourceElementType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateCollectElementTypeIsSourceElementType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateCollectElementTypeIsSourceElementType(diagnostics, context);
	}

	/**
	 * Validates the validateCollectTypeIsUnordered constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateCollectTypeIsUnordered(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateCollectTypeIsUnordered(diagnostics, context);
	}

	/**
	 * Validates the validateCollectHasOneIterator constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateCollectHasOneIterator(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateCollectHasOneIterator(diagnostics, context);
	}

	/**
	 * Validates the validateClosureElementTypeIsSourceElementType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureElementTypeIsSourceElementType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureElementTypeIsSourceElementType(diagnostics, context);
	}

	/**
	 * Validates the validateClosureSourceElementTypeIsBodyElementType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureSourceElementTypeIsBodyElementType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureSourceElementTypeIsBodyElementType(diagnostics, context);
	}

	/**
	 * Validates the validateClosureTypeIsUniqueCollection constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureTypeIsUniqueCollection(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureTypeIsUniqueCollection(diagnostics, context);
	}

	/**
	 * Validates the validateClosureHasOneIterator constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateClosureHasOneIterator(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateClosureHasOneIterator(diagnostics, context);
	}

	/**
	 * Validates the validateAnyBodyTypeIsBoolean constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateAnyBodyTypeIsBoolean(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateAnyBodyTypeIsBoolean(diagnostics, context);
	}

	/**
	 * Validates the validateAnyTypeIsSourceElementType constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateAnyTypeIsSourceElementType(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateAnyTypeIsSourceElementType(diagnostics, context);
	}

	/**
	 * Validates the validateAnyHasOneIterator constraint of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp_validateAnyHasOneIterator(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return iteratorExp.validateAnyHasOneIterator(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLambdaType(LambdaType lambdaType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)lambdaType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)lambdaType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(lambdaType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp(LoopExp loopExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)loopExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateNoInitializers(loopExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoopExp_validateSourceIsCollection(loopExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNoInitializers constraint of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp_validateNoInitializers(LoopExp loopExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return loopExp.validateNoInitializers(diagnostics, context);
	}

	/**
	 * Validates the validateSourceIsCollection constraint of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp_validateSourceIsCollection(LoopExp loopExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return loopExp.validateSourceIsCollection(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetExp(LetExp letExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)letExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)letExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateLetExp_validateTypeIsInType(letExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsInType constraint of '<em>Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetExp_validateTypeIsInType(LetExp letExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return letExp.validateTypeIsInType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibrary(Library library, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)library, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageExp(MessageExp messageExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)messageExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateMessageExp_validateOneCallOrOneSend(messageExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateMessageExp_validateTargetIsNotACollection(messageExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTargetIsNotACollection constraint of '<em>Message Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageExp_validateTargetIsNotACollection(MessageExp messageExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return messageExp.validateTargetIsNotACollection(diagnostics, context);
	}

	/**
	 * Validates the validateOneCallOrOneSend constraint of '<em>Message Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageExp_validateOneCallOrOneSend(MessageExp messageExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return messageExp.validateOneCallOrOneSend(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageType(MessageType messageType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)messageType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(messageType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetaclass(Metaclass<?> metaclass, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)metaclass, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)metaclass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)metaclass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)metaclass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)metaclass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)metaclass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)metaclass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)metaclass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)metaclass, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(metaclass, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMorePivotable(MorePivotable morePivotable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)morePivotable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameable(Nameable nameable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)nameable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignal(Signal signal, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)signal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNullLiteralExp(NullLiteralExp nullLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)nullLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCallExp(OperationCallExp operationCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)operationCallExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationCallExp_validateArgumentCount(operationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperationCallExp_validateArgumentTypeIsConformant(operationCallExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateArgumentTypeIsConformant constraint of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCallExp_validateArgumentTypeIsConformant(OperationCallExp operationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operationCallExp.validateArgumentTypeIsConformant(diagnostics, context);
	}

	/**
	 * Validates the validateArgumentCount constraint of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCallExp_validateArgumentCount(OperationCallExp operationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return operationCallExp.validateArgumentCount(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderedSetType(OrderedSetType orderedSetType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)orderedSetType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)orderedSetType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(orderedSetType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageableElement(
			PackageableElement packageableElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)packageableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveType(PrimitiveType primitiveType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)primitiveType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)primitiveType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(primitiveType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProfile(Profile profile, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)profile, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProfileApplication(ProfileApplication profileApplication, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)profileApplication, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyCallExp(PropertyCallExp propertyCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)propertyCallExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyCallExp_validateCompatibleResultType(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyCallExp_validateNonStaticSourceTypeIsConformant(propertyCallExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNonStaticSourceTypeIsConformant constraint of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyCallExp_validateNonStaticSourceTypeIsConformant(PropertyCallExp propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return propertyCallExp.validateNonStaticSourceTypeIsConformant(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleResultType constraint of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyCallExp_validateCompatibleResultType(PropertyCallExp propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return propertyCallExp.validateCompatibleResultType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate(Pseudostate pseudostate, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)pseudostate, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealLiteralExp(RealLiteralExp realLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)realLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferringElement(ReferringElement referringElement, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)referringElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegion(Region region, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)region, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRoot(Root root, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)root, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSelfType(SelfType selfType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)selfType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)selfType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(selfType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSendSignalAction(SendSignalAction sendSignalAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)sendSignalAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceType(SequenceType sequenceType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)sequenceType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)sequenceType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(sequenceType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetType(SetType setType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)setType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)setType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)setType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(setType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState(State state, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)state, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateExp(StateExp stateExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)stateExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateMachine(StateMachine stateMachine, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)stateMachine, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)stateMachine, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(stateMachine, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotype(Stereotype stereotype, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)stereotype, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)stereotype, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(stereotype, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringLiteralExp(StringLiteralExp stringLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)stringLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterType(
			TemplateParameterType templateParameterType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)templateParameterType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)templateParameterType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)templateParameterType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)templateParameterType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)templateParameterType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)templateParameterType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)templateParameterType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)templateParameterType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)templateParameterType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(templateParameterType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleLiteralExp(TupleLiteralExp tupleLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)tupleLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleLiteralPart(TupleLiteralPart tupleLiteralPart,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)tupleLiteralPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleType(TupleType tupleType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)tupleType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)tupleType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(tupleType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeExp(TypeExp typeExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)typeExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeExtension(TypeExtension typeExtension, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)typeExtension, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnspecifiedValueExp(
			UnspecifiedValueExp unspecifiedValueExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)unspecifiedValueExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueSpecification(
			ValueSpecification valueSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)valueSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableExp(VariableExp variableExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)variableExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVertex(Vertex vertex, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)vertex, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVisitable(Visitable visitable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)visitable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVisitor(Visitor<?> visitor,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)visitor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVoidType(VoidType voidType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)voidType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)voidType, diagnostics, context);
		if (result || diagnostics != null) result &= validateType_validateUniqueInvariantName(voidType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociativityKind(
			AssociativityKind associativityKind, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionKind(CollectionKind collectionKind,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostateKind(PseudostateKind pseudostateKind, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransitionKind(TransitionKind transitionKind, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBoolean(boolean boolean_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteger(Number integer, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibraryFeature(LibraryFeature libraryFeature, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObject(Object object, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReal(Number real, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateString(String string, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThrowable(Throwable throwable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnlimitedNatural(Number unlimitedNatural, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PivotPlugin.INSTANCE;
	}

} //PivotValidator
