/*******************************************************************************
 * Copyright (c) 2010, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationCallExpImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.OperationCallExpImpl#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationCallExpImpl
		extends FeatureCallExpImpl
		implements OperationCallExp {

	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> argument;

	/**
	 * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation referredOperation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.OPERATION_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<OCLExpression> getArgument()
	{
		if (argument == null)
		{
			argument = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, PivotPackage.OPERATION_CALL_EXP__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getReferredOperation() {
		if (referredOperation != null && ((EObject)referredOperation).eIsProxy())
		{
			InternalEObject oldReferredOperation = (InternalEObject)referredOperation;
			referredOperation = (Operation)eResolveProxy(oldReferredOperation);
			if (referredOperation != oldReferredOperation)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.OPERATION_CALL_EXP__REFERRED_OPERATION, oldReferredOperation, referredOperation));
			}
		}
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetReferredOperation() {
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredOperation(Operation newReferredOperation) {
		Operation oldReferredOperation = referredOperation;
		referredOperation = newReferredOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.OPERATION_CALL_EXP__REFERRED_OPERATION, oldReferredOperation, referredOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.OPERATION_CALL_EXP__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.OPERATION_CALL_EXP__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.OPERATION_CALL_EXP__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.OPERATION_CALL_EXP__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.OPERATION_CALL_EXP__SOURCE:
				return basicSetSource(null, msgs);
			case PivotPackage.OPERATION_CALL_EXP__ARGUMENT:
				return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.OPERATION_CALL_EXP__COMMENT:
				return getComment();
			case PivotPackage.OPERATION_CALL_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.OPERATION_CALL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.OPERATION_CALL_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.OPERATION_CALL_EXP__NAME:
				return getName();
			case PivotPackage.OPERATION_CALL_EXP__IS_MANY:
				return isMany();
			case PivotPackage.OPERATION_CALL_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.OPERATION_CALL_EXP__IS_TYPEOF:
				return isTypeof();
			case PivotPackage.OPERATION_CALL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.OPERATION_CALL_EXP__IMPLICIT:
				return isImplicit();
			case PivotPackage.OPERATION_CALL_EXP__SOURCE:
				return getSource();
			case PivotPackage.OPERATION_CALL_EXP__IS_PRE:
				return isPre();
			case PivotPackage.OPERATION_CALL_EXP__ARGUMENT:
				return getArgument();
			case PivotPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				if (resolve) return getReferredOperation();
				return basicGetReferredOperation();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.OPERATION_CALL_EXP__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__IS_TYPEOF:
				setIsTypeof((Boolean)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__SOURCE:
				setSource((OCLExpression)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__IS_PRE:
				setIsPre((Boolean)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case PivotPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				setReferredOperation((Operation)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.OPERATION_CALL_EXP__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.OPERATION_CALL_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.OPERATION_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.OPERATION_CALL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.OPERATION_CALL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.OPERATION_CALL_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.OPERATION_CALL_EXP__IS_TYPEOF:
				setIsTypeof(IS_TYPEOF_EDEFAULT);
				return;
			case PivotPackage.OPERATION_CALL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.OPERATION_CALL_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.OPERATION_CALL_EXP__SOURCE:
				setSource((OCLExpression)null);
				return;
			case PivotPackage.OPERATION_CALL_EXP__IS_PRE:
				setIsPre(IS_PRE_EDEFAULT);
				return;
			case PivotPackage.OPERATION_CALL_EXP__ARGUMENT:
				getArgument().clear();
				return;
			case PivotPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				setReferredOperation((Operation)null);
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.OPERATION_CALL_EXP__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.OPERATION_CALL_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.OPERATION_CALL_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.OPERATION_CALL_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.OPERATION_CALL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.OPERATION_CALL_EXP__IS_MANY:
				return isMany() != IS_MANY_EDEFAULT;
			case PivotPackage.OPERATION_CALL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.OPERATION_CALL_EXP__IS_TYPEOF:
				return ((eFlags & IS_TYPEOF_EFLAG) != 0) != IS_TYPEOF_EDEFAULT;
			case PivotPackage.OPERATION_CALL_EXP__TYPE:
				return type != null;
			case PivotPackage.OPERATION_CALL_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.OPERATION_CALL_EXP__SOURCE:
				return source != null;
			case PivotPackage.OPERATION_CALL_EXP__IS_PRE:
				return ((eFlags & IS_PRE_EFLAG) != 0) != IS_PRE_EDEFAULT;
			case PivotPackage.OPERATION_CALL_EXP__ARGUMENT:
				return argument != null && !argument.isEmpty();
			case PivotPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
				return referredOperation != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
	{
		if (baseClass == ReferringElement.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.REFERRING_ELEMENT___GET_REFERRED_ELEMENT: return PivotPackage.OPERATION_CALL_EXP___GET_REFERRED_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PivotPackage.OPERATION_CALL_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.OPERATION_CALL_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.OPERATION_CALL_EXP___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.OPERATION_CALL_EXP___MAKE_PARAMETER:
				return makeParameter();
			case PivotPackage.OPERATION_CALL_EXP___GET_REFERRED_ELEMENT:
				return getReferredElement();
			case PivotPackage.OPERATION_CALL_EXP___VALIDATE_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP:
				return validateArgumentCount((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.OPERATION_CALL_EXP___VALIDATE_ARGUMENT_TYPE_IS_CONFORMANT__DIAGNOSTICCHAIN_MAP:
				return validateArgumentTypeIsConformant((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitOperationCallExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element getReferredElement()
	{
		return getReferredOperation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArgumentTypeIsConformant(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv ArgumentTypeIsConformant:
		 *   let operation : Operation = self.referredOperation
		 *   in
		 *     let parameters : OrderedSet(Parameter) = operation.ownedParameter
		 *     in
		 *       let selfType : Type = operation.owningClass
		 *       in
		 *         Sequence{1..argument->size()
		 *         }
		 *         ->forAll(i |
		 *           let argument : OCLExpression = argument->at(i)
		 *           in
		 *             let parameter : Parameter = parameters->at(i)
		 *             in
		 *               let parameterType : Type = parameter.type
		 *               in
		 *                 let
		 *                   requiredType : Type = parameterType.specializeIn(self, selfType)
		 *                 in
		 *                   if argument.isTypeof and not parameter.isTypeof
		 *                   then Class
		 *                   else argument.type
		 *                   endif
		 *                   .conformsTo(requiredType))
		 */
		@NonNull /*@Caught*/ Object CAUGHT_forAll;
		try {
		    final @Nullable /*@Thrown*/ DomainOperation operation = this.getReferredOperation();
		    if (operation == null) {
		        throw new InvalidValueException("Null source for \'pivot::Operation::ownedParameter\'");
		    }
		    final @NonNull /*@Thrown*/ List<? extends DomainTypedElement> parameters = operation.getOwnedParameter();
		    final @Nullable /*@Thrown*/ DomainClass selfType_1 = operation.getOwningClass();
		    final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		    final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		    final @NonNull /*@Thrown*/ List<? extends DomainExpression> argument = this.getArgument();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_argument = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_OCLExpression, argument);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_argument);
		    final @NonNull /*@Thrown*/ IntegerRange RNG = ValuesUtil.createRange(PivotTables.INT_1, size);
		    final @NonNull /*@Thrown*/ SequenceValue Sequence = ValuesUtil.createSequenceRange(PivotTables.SEQ_PRIMid_Integer, RNG);
		    @NonNull /*@Thrown*/ Object accumulator = ValuesUtil.TRUE_VALUE;
		    @Nullable Iterator<?> ITERATOR_i = Sequence.iterator();
		    /*@Thrown*/ boolean forAll;
		    while (true) {
		        if (!ITERATOR_i.hasNext()) {
		            if (accumulator == ValuesUtil.TRUE_VALUE) {
		                forAll = (Boolean)accumulator;
		            }
		            else {
		                throw (InvalidValueException)accumulator;
		            }
		            break;
		        }
		        @Nullable /*@NonInvalid*/ IntegerValue i = (IntegerValue)ITERATOR_i.next();
		        /**
		         * 
		         * let argument : OCLExpression = argument->at(i)
		         * in
		         *   let parameter : Parameter = parameters->at(i)
		         *   in
		         *     let parameterType : Type = parameter.type
		         *     in
		         *       let requiredType : Type = parameterType.specializeIn(self, selfType)
		         *       in
		         *         if argument.isTypeof and not parameter.isTypeof
		         *         then Class
		         *         else argument.type
		         *         endif
		         *         .conformsTo(requiredType)
		         */
		        @NonNull /*@Caught*/ Object CAUGHT_conformsTo;
		        try {
		            @Nullable /*@Caught*/ Object CAUGHT_argument_1;
		            try {
		                final @Nullable /*@Thrown*/ DomainExpression argument_1 = (DomainExpression)OrderedCollectionAtOperation.INSTANCE.evaluate(BOXED_argument, i);
		                CAUGHT_argument_1 = argument_1;
		            }
		            catch (Exception e) {
		                CAUGHT_argument_1 = ValuesUtil.createInvalidValue(e);
		            }
		            @Nullable /*@Caught*/ Object CAUGHT_parameter;
		            try {
		                final @NonNull /*@Thrown*/ OrderedSetValue BOXED_parameters = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Parameter, parameters);
		                final @Nullable /*@Thrown*/ DomainTypedElement parameter = (DomainTypedElement)OrderedCollectionAtOperation.INSTANCE.evaluate(BOXED_parameters, i);
		                CAUGHT_parameter = parameter;
		            }
		            catch (Exception e) {
		                CAUGHT_parameter = ValuesUtil.createInvalidValue(e);
		            }
		            if (CAUGHT_parameter == null) {
		                throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		            }
		            if (CAUGHT_parameter instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_parameter;
		            }
		            final @Nullable /*@Thrown*/ DomainType parameterType = ((DomainTypedElement)CAUGHT_parameter).getType();
		            if (parameterType == null) {
		                throw new InvalidValueException("Null source for \'pivot::Type::specializeIn(pivot::OCLExpression,pivot::Type) : pivot::Type\'");
		            }
		            final @NonNull /*@Thrown*/ DomainType requiredType = parameterType.specializeIn(this, (Type)selfType_1);
		            @Nullable /*@Caught*/ Object CAUGHT_self_70;
		            try {
		                if (CAUGHT_argument_1 == null) {
		                    throw new InvalidValueException("Null source for \'pivot::TypedElement::isTypeof\'");
		                }
		                if (CAUGHT_argument_1 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_argument_1;
		                }
		                final @Nullable /*@Thrown*/ Boolean self_70 = ((TypedElement)CAUGHT_argument_1).isTypeof();
		                CAUGHT_self_70 = self_70;
		            }
		            catch (Exception e) {
		                CAUGHT_self_70 = ValuesUtil.createInvalidValue(e);
		            }
		            @Nullable /*@Caught*/ Object CAUGHT_symbol_2;
		            try {
		                @Nullable /*@Caught*/ Object CAUGHT_self_71;
		                try {
		                    final @Nullable /*@Thrown*/ Boolean self_71 = ((TypedElement)CAUGHT_parameter).isTypeof();
		                    CAUGHT_self_71 = self_71;
		                }
		                catch (Exception e) {
		                    CAUGHT_self_71 = ValuesUtil.createInvalidValue(e);
		                }
		                if (CAUGHT_self_71 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_71;
		                }
		                final /*@NonInvalid*/ boolean symbol_0 = CAUGHT_self_71 instanceof InvalidValueException;
		                @Nullable /*@Thrown*/ Boolean symbol_2;
		                if (symbol_0) {
		                    symbol_2 = (Boolean)CAUGHT_self_71;
		                }
		                else {
		                    final /*@Thrown*/ boolean eq = CAUGHT_self_71 == null;
		                    @Nullable /*@Thrown*/ Boolean symbol_1;
		                    if (eq) {
		                        symbol_1 = null;
		                    }
		                    else {
		                        final /*@Thrown*/ boolean eq_0 = CAUGHT_self_71 == Boolean.FALSE;
		                        symbol_1 = (Boolean)eq_0;
		                    }
		                    symbol_2 = symbol_1;
		                }
		                CAUGHT_symbol_2 = symbol_2;
		            }
		            catch (Exception e) {
		                CAUGHT_symbol_2 = ValuesUtil.createInvalidValue(e);
		            }
		            final /*@NonInvalid*/ boolean symbol_3 = CAUGHT_self_70 instanceof InvalidValueException;
		            @Nullable /*@Thrown*/ Boolean symbol_13;
		            if (symbol_3) {
		                final /*@NonInvalid*/ boolean symbol_4 = CAUGHT_symbol_2 instanceof InvalidValueException;
		                @Nullable /*@Thrown*/ Boolean symbol_6;
		                if (symbol_4) {
		                    if (CAUGHT_self_70 instanceof InvalidValueException) {
		                        throw (InvalidValueException)CAUGHT_self_70;
		                    }
		                    symbol_6 = (Boolean)CAUGHT_self_70;
		                }
		                else {
		                    if (CAUGHT_symbol_2 instanceof InvalidValueException) {
		                        throw (InvalidValueException)CAUGHT_symbol_2;
		                    }
		                    final /*@Thrown*/ boolean eq_1 = CAUGHT_symbol_2 == Boolean.FALSE;
		                    @Nullable /*@Thrown*/ Boolean symbol_5;
		                    if (eq_1) {
		                        symbol_5 = (Boolean)ValuesUtil.FALSE_VALUE;
		                    }
		                    else {
		                        if (CAUGHT_self_70 instanceof InvalidValueException) {
		                            throw (InvalidValueException)CAUGHT_self_70;
		                        }
		                        symbol_5 = (Boolean)CAUGHT_self_70;
		                    }
		                    symbol_6 = symbol_5;
		                }
		                symbol_13 = symbol_6;
		            }
		            else {
		                if (CAUGHT_self_70 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_70;
		                }
		                final /*@Thrown*/ boolean eq_2 = CAUGHT_self_70 == Boolean.FALSE;
		                @Nullable /*@Thrown*/ Boolean symbol_12;
		                if (eq_2) {
		                    symbol_12 = (Boolean)ValuesUtil.FALSE_VALUE;
		                }
		                else {
		                    if (CAUGHT_symbol_2 instanceof InvalidValueException) {
		                        throw (InvalidValueException)CAUGHT_symbol_2;
		                    }
		                    final /*@NonInvalid*/ boolean symbol_7 = CAUGHT_symbol_2 instanceof InvalidValueException;
		                    @Nullable /*@Thrown*/ Boolean symbol_11;
		                    if (symbol_7) {
		                        symbol_11 = (Boolean)CAUGHT_symbol_2;
		                    }
		                    else {
		                        final /*@Thrown*/ boolean eq_3 = CAUGHT_symbol_2 == Boolean.FALSE;
		                        @Nullable /*@NonInvalid*/ Boolean symbol_10;
		                        if (eq_3) {
		                            symbol_10 = (Boolean)ValuesUtil.FALSE_VALUE;
		                        }
		                        else {
		                            final /*@Thrown*/ boolean eq_4 = CAUGHT_self_70 == null;
		                            @Nullable /*@NonInvalid*/ Boolean symbol_9;
		                            if (eq_4) {
		                                symbol_9 = null;
		                            }
		                            else {
		                                final /*@Thrown*/ boolean eq_5 = CAUGHT_symbol_2 == null;
		                                @Nullable /*@NonInvalid*/ Boolean symbol_8;
		                                if (eq_5) {
		                                    symbol_8 = null;
		                                }
		                                else {
		                                    symbol_8 = (Boolean)ValuesUtil.TRUE_VALUE;
		                                }
		                                symbol_9 = symbol_8;
		                            }
		                            symbol_10 = symbol_9;
		                        }
		                        symbol_11 = symbol_10;
		                    }
		                    symbol_12 = symbol_11;
		                }
		                symbol_13 = symbol_12;
		            }
		            if (symbol_13 == null) {
		                throw new InvalidValueException("Null if condition");
		            }
		            @Nullable /*@Thrown*/ DomainType symbol_14;
		            if (symbol_13) {
		                final @NonNull /*@NonInvalid*/ DomainClass TYP_Class_0 = idResolver.getClass(PivotTables.CLSSid_Class, null);
		                symbol_14 = TYP_Class_0;
		            }
		            else {
		                if (CAUGHT_argument_1 == null) {
		                    throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		                }
		                if (CAUGHT_argument_1 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_argument_1;
		                }
		                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)CAUGHT_argument_1).getType();
		                symbol_14 = type;
		            }
		            final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, symbol_14, requiredType).booleanValue();
		            CAUGHT_conformsTo = conformsTo;
		        }
		        catch (Exception e) {
		            CAUGHT_conformsTo = ValuesUtil.createInvalidValue(e);
		        }
		        //
		        if (CAUGHT_conformsTo == ValuesUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
		            forAll = ValuesUtil.FALSE_VALUE;
		            break;														// Stop immediately 
		        }
		        else if (CAUGHT_conformsTo == ValuesUtil.TRUE_VALUE) {				// Normal successful body evaluation result
		            ;															// Carry on
		        }
		        else if (CAUGHT_conformsTo instanceof InvalidValueException) {		// Abnormal exception evaluation result
		            accumulator = CAUGHT_conformsTo;									// Cache an exception failure
		        }
		        else {															// Impossible badly typed result
		            accumulator = new InvalidValueException(EvaluatorMessages.NonBooleanBody, "forAll");
		        }
		    }
		    CAUGHT_forAll = forAll;
		}
		catch (Exception e) {
		    CAUGHT_forAll = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_forAll == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"OperationCallExp", "ArgumentTypeIsConformant", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.OPERATION_CALL_EXP__ARGUMENT_TYPE_IS_CONFORMANT, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArgumentCount(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv ArgumentCount: argument->size() = referredOperation.ownedParameter->size()
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object CAUGHT_eq;
		try {
		    final @NonNull /*@Thrown*/ List<? extends DomainExpression> argument = this.getArgument();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_argument = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_OCLExpression, argument);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_argument);
		    final @Nullable /*@Thrown*/ DomainOperation referredOperation = this.getReferredOperation();
		    if (referredOperation == null) {
		        throw new InvalidValueException("Null source for \'pivot::Operation::ownedParameter\'");
		    }
		    final @NonNull /*@Thrown*/ List<? extends DomainTypedElement> ownedParameter = referredOperation.getOwnedParameter();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedParameter = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Parameter, ownedParameter);
		    final @NonNull /*@Thrown*/ IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedParameter);
		    final /*@Thrown*/ boolean eq = size.equals(size_0);
		    CAUGHT_eq = eq;
		}
		catch (Exception e) {
		    CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_eq == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"OperationCallExp", "ArgumentCount", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.OPERATION_CALL_EXP__ARGUMENT_COUNT, message, new Object [] { this }));
		}
		return false;
	}
} //OperationCallExpImpl
