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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.pivot.CallOperationAction;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.SendSignalAction;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl#getCalledOperation <em>Called Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl#getSentSignal <em>Sent Signal</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.MessageExpImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageExpImpl
		extends OCLExpressionImpl
		implements MessageExp {

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
	 * The cached value of the '{@link #getCalledOperation() <em>Called Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalledOperation()
	 * @generated
	 * @ordered
	 */
	protected CallOperationAction calledOperation;

	/**
	 * The cached value of the '{@link #getSentSignal() <em>Sent Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentSignal()
	 * @generated
	 * @ordered
	 */
	protected SendSignalAction sentSignal;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.MESSAGE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(OCLExpression newTarget,
			NotificationChain msgs) {
		OCLExpression oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(OCLExpression newTarget) {
		if (newTarget != target)
		{
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<OCLExpression> getArgument()
	{
		if (argument == null)
		{
			argument = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, PivotPackage.MESSAGE_EXP__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallOperationAction getCalledOperation() {
		return calledOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCalledOperation(
			CallOperationAction newCalledOperation, NotificationChain msgs) {
		CallOperationAction oldCalledOperation = calledOperation;
		calledOperation = newCalledOperation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__CALLED_OPERATION, oldCalledOperation, newCalledOperation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalledOperation(CallOperationAction newCalledOperation) {
		if (newCalledOperation != calledOperation)
		{
			NotificationChain msgs = null;
			if (calledOperation != null)
				msgs = ((InternalEObject)calledOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__CALLED_OPERATION, null, msgs);
			if (newCalledOperation != null)
				msgs = ((InternalEObject)newCalledOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__CALLED_OPERATION, null, msgs);
			msgs = basicSetCalledOperation(newCalledOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__CALLED_OPERATION, newCalledOperation, newCalledOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendSignalAction getSentSignal() {
		return sentSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSentSignal(SendSignalAction newSentSignal,
			NotificationChain msgs) {
		SendSignalAction oldSentSignal = sentSignal;
		sentSignal = newSentSignal;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__SENT_SIGNAL, oldSentSignal, newSentSignal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSentSignal(SendSignalAction newSentSignal) {
		if (newSentSignal != sentSignal)
		{
			NotificationChain msgs = null;
			if (sentSignal != null)
				msgs = ((InternalEObject)sentSignal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__SENT_SIGNAL, null, msgs);
			if (newSentSignal != null)
				msgs = ((InternalEObject)newSentSignal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__SENT_SIGNAL, null, msgs);
			msgs = basicSetSentSignal(newSentSignal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__SENT_SIGNAL, newSentSignal, newSentSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOneCallOrOneSend(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv OneCallOrOneSend: calledOperation->size() + sentSignal->size() = 1
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		@NonNull /*@Caught*/ Object CAUGHT_eq;
		try {
		    final @Nullable /*@Thrown*/ CallOperationAction calledOperation = this.getCalledOperation();
		    final @NonNull /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, PivotTables.SET_CLSSid_CallOperationAction, calledOperation);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet);
		    final @Nullable /*@Thrown*/ SendSignalAction sentSignal = this.getSentSignal();
		    final @NonNull /*@Thrown*/ SetValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, PivotTables.SET_CLSSid_SendSignalAction, sentSignal);
		    final @NonNull /*@Thrown*/ IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet_0);
		    final @NonNull /*@Thrown*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(size, size_0);
		    final /*@Thrown*/ boolean eq = sum.equals(PivotTables.INT_1);
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
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"MessageExp", "OneCallOrOneSend", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.MESSAGE_EXP__ONE_CALL_OR_ONE_SEND, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetIsNotACollection(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv TargetIsNotACollection: not target.type.oclIsKindOf (CollectionType)
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object CAUGHT_symbol_1;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType_0 = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		        final @Nullable /*@Thrown*/ DomainExpression target = this.getTarget();
		        if (target == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ DomainType type = target.getType();
		        final /*@Thrown*/ boolean self_71 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType_0).booleanValue();
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValuesUtil.createInvalidValue(e);
		    }
		    if (CAUGHT_self_71 instanceof InvalidValueException) {
		        throw (InvalidValueException)CAUGHT_self_71;
		    }
		    final /*@NonInvalid*/ boolean symbol_0 = CAUGHT_self_71 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_1;
		    if (symbol_0) {
		        symbol_1 = (Boolean)CAUGHT_self_71;
		    }
		    else {
		        final /*@Thrown*/ boolean eq = CAUGHT_self_71 == Boolean.FALSE;
		        symbol_1 = eq;
		    }
		    CAUGHT_symbol_1 = symbol_1;
		}
		catch (Exception e) {
		    CAUGHT_symbol_1 = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_1 == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"MessageExp", "TargetIsNotACollection", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.MESSAGE_EXP__TARGET_IS_NOT_ACOLLECTION, message, new Object [] { this }));
		}
		return false;
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
			case PivotPackage.MESSAGE_EXP__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__ARGUMENT:
				return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__CALLED_OPERATION:
				return basicSetCalledOperation(null, msgs);
			case PivotPackage.MESSAGE_EXP__SENT_SIGNAL:
				return basicSetSentSignal(null, msgs);
			case PivotPackage.MESSAGE_EXP__TARGET:
				return basicSetTarget(null, msgs);
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
			case PivotPackage.MESSAGE_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.MESSAGE_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.MESSAGE_EXP__NAME:
				return getName();
			case PivotPackage.MESSAGE_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.MESSAGE_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.MESSAGE_EXP__ARGUMENT:
				return getArgument();
			case PivotPackage.MESSAGE_EXP__CALLED_OPERATION:
				return getCalledOperation();
			case PivotPackage.MESSAGE_EXP__SENT_SIGNAL:
				return getSentSignal();
			case PivotPackage.MESSAGE_EXP__TARGET:
				return getTarget();
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
			case PivotPackage.MESSAGE_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__CALLED_OPERATION:
				setCalledOperation((CallOperationAction)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__SENT_SIGNAL:
				setSentSignal((SendSignalAction)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__TARGET:
				setTarget((OCLExpression)newValue);
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
			case PivotPackage.MESSAGE_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.MESSAGE_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.MESSAGE_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.MESSAGE_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.MESSAGE_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.MESSAGE_EXP__ARGUMENT:
				getArgument().clear();
				return;
			case PivotPackage.MESSAGE_EXP__CALLED_OPERATION:
				setCalledOperation((CallOperationAction)null);
				return;
			case PivotPackage.MESSAGE_EXP__SENT_SIGNAL:
				setSentSignal((SendSignalAction)null);
				return;
			case PivotPackage.MESSAGE_EXP__TARGET:
				setTarget((OCLExpression)null);
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
			case PivotPackage.MESSAGE_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.MESSAGE_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.MESSAGE_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.MESSAGE_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.MESSAGE_EXP__TYPE:
				return type != null;
			case PivotPackage.MESSAGE_EXP__ARGUMENT:
				return argument != null && !argument.isEmpty();
			case PivotPackage.MESSAGE_EXP__CALLED_OPERATION:
				return calledOperation != null;
			case PivotPackage.MESSAGE_EXP__SENT_SIGNAL:
				return sentSignal != null;
			case PivotPackage.MESSAGE_EXP__TARGET:
				return target != null;
		}
		return eDynamicIsSet(featureID);
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
			case PivotPackage.MESSAGE_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.MESSAGE_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.MESSAGE_EXP___VALIDATE_ONE_CALL_OR_ONE_SEND__DIAGNOSTICCHAIN_MAP:
				return validateOneCallOrOneSend((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.MESSAGE_EXP___VALIDATE_TARGET_IS_NOT_ACOLLECTION__DIAGNOSTICCHAIN_MAP:
				return validateTargetIsNotACollection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitMessageExp(this);
	}
} //MessageExpImpl
