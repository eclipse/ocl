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
package org.eclipse.ocl.pivot.impl;

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
import org.eclipse.ocl.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.CallOperationAction;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.MessageExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.SendSignalAction;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.messages.EvaluatorMessages;
import org.eclipse.ocl.pivot.util.PivotValidator;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.impl.MessageExpImpl#getOwnedArguments <em>Owned Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.MessageExpImpl#getOwnedCalledOperation <em>Owned Called Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.MessageExpImpl#getOwnedSentSignal <em>Owned Sent Signal</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.MessageExpImpl#getOwnedTarget <em>Owned Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageExpImpl
		extends OCLExpressionImpl
		implements MessageExp {

	/**
	 * The cached value of the '{@link #getOwnedArguments() <em>Owned Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> ownedArguments;

	/**
	 * The cached value of the '{@link #getOwnedCalledOperation() <em>Owned Called Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCalledOperation()
	 * @generated
	 * @ordered
	 */
	protected CallOperationAction ownedCalledOperation;

	/**
	 * The cached value of the '{@link #getOwnedSentSignal() <em>Owned Sent Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSentSignal()
	 * @generated
	 * @ordered
	 */
	protected SendSignalAction ownedSentSignal;

	/**
	 * The cached value of the '{@link #getOwnedTarget() <em>Owned Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTarget()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedTarget;

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
	public OCLExpression getOwnedTarget() {
		return ownedTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedTarget(OCLExpression newOwnedTarget, NotificationChain msgs)
	{
		OCLExpression oldOwnedTarget = ownedTarget;
		ownedTarget = newOwnedTarget;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__OWNED_TARGET, oldOwnedTarget, newOwnedTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedTarget(OCLExpression newOwnedTarget) {
		if (newOwnedTarget != ownedTarget)
		{
			NotificationChain msgs = null;
			if (ownedTarget != null)
				msgs = ((InternalEObject)ownedTarget).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__OWNED_TARGET, null, msgs);
			if (newOwnedTarget != null)
				msgs = ((InternalEObject)newOwnedTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__OWNED_TARGET, null, msgs);
			msgs = basicSetOwnedTarget(newOwnedTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__OWNED_TARGET, newOwnedTarget, newOwnedTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<OCLExpression> getOwnedArguments()
	{
		if (ownedArguments == null)
		{
			ownedArguments = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, PivotPackage.MESSAGE_EXP__OWNED_ARGUMENTS);
		}
		return ownedArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CallOperationAction getOwnedCalledOperation() {
		return ownedCalledOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedCalledOperation(CallOperationAction newOwnedCalledOperation, NotificationChain msgs)
	{
		CallOperationAction oldOwnedCalledOperation = ownedCalledOperation;
		ownedCalledOperation = newOwnedCalledOperation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__OWNED_CALLED_OPERATION, oldOwnedCalledOperation, newOwnedCalledOperation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedCalledOperation(CallOperationAction newOwnedCalledOperation)
	{
		if (newOwnedCalledOperation != ownedCalledOperation)
		{
			NotificationChain msgs = null;
			if (ownedCalledOperation != null)
				msgs = ((InternalEObject)ownedCalledOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__OWNED_CALLED_OPERATION, null, msgs);
			if (newOwnedCalledOperation != null)
				msgs = ((InternalEObject)newOwnedCalledOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__OWNED_CALLED_OPERATION, null, msgs);
			msgs = basicSetOwnedCalledOperation(newOwnedCalledOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__OWNED_CALLED_OPERATION, newOwnedCalledOperation, newOwnedCalledOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SendSignalAction getOwnedSentSignal() {
		return ownedSentSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSentSignal(SendSignalAction newOwnedSentSignal, NotificationChain msgs)
	{
		SendSignalAction oldOwnedSentSignal = ownedSentSignal;
		ownedSentSignal = newOwnedSentSignal;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__OWNED_SENT_SIGNAL, oldOwnedSentSignal, newOwnedSentSignal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedSentSignal(SendSignalAction newOwnedSentSignal)
	{
		if (newOwnedSentSignal != ownedSentSignal)
		{
			NotificationChain msgs = null;
			if (ownedSentSignal != null)
				msgs = ((InternalEObject)ownedSentSignal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__OWNED_SENT_SIGNAL, null, msgs);
			if (newOwnedSentSignal != null)
				msgs = ((InternalEObject)newOwnedSentSignal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.MESSAGE_EXP__OWNED_SENT_SIGNAL, null, msgs);
			msgs = basicSetOwnedSentSignal(newOwnedSentSignal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.MESSAGE_EXP__OWNED_SENT_SIGNAL, newOwnedSentSignal, newOwnedSentSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOneCallOrOneSend(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv OneCallOrOneSend:
		 *   ownedCalledOperation->size() +
		 *   ownedSentSignal->size() = 1
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		@NonNull /*@Caught*/ Object CAUGHT_eq;
		try {
		    final @Nullable /*@Thrown*/ CallOperationAction ownedCalledOperation = this.getOwnedCalledOperation();
		    final @NonNull /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, PivotTables.SET_CLSSid_CallOperationAction, ownedCalledOperation);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet);
		    final @Nullable /*@Thrown*/ SendSignalAction ownedSentSignal = this.getOwnedSentSignal();
		    final @NonNull /*@Thrown*/ SetValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, PivotTables.SET_CLSSid_SendSignalAction, ownedSentSignal);
		    final @NonNull /*@Thrown*/ IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet_0);
		    final @NonNull /*@Thrown*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(size, size_0);
		    final /*@Thrown*/ boolean eq = sum.equals(PivotTables.INT_1);
		    CAUGHT_eq = eq;
		}
		catch (Exception e) {
		    CAUGHT_eq = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_eq == ValueUtil.TRUE_VALUE) {
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
	@Override
	public boolean validateTargetIsNotACollection(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv TargetIsNotACollection:
		 *   not ownedTarget.type.oclIsKindOf(CollectionType)
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object CAUGHT_symbol_1;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_CollectionType_0 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
		        final @Nullable /*@Thrown*/ OCLExpression ownedTarget = this.getOwnedTarget();
		        if (ownedTarget == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type = ownedTarget.getType();
		        final /*@Thrown*/ boolean self_71 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType_0).booleanValue();
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
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
		    CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_1 == ValueUtil.TRUE_VALUE) {
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
			case PivotPackage.MESSAGE_EXP__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__OWNED_ARGUMENTS:
				return ((InternalEList<?>)getOwnedArguments()).basicRemove(otherEnd, msgs);
			case PivotPackage.MESSAGE_EXP__OWNED_CALLED_OPERATION:
				return basicSetOwnedCalledOperation(null, msgs);
			case PivotPackage.MESSAGE_EXP__OWNED_SENT_SIGNAL:
				return basicSetOwnedSentSignal(null, msgs);
			case PivotPackage.MESSAGE_EXP__OWNED_TARGET:
				return basicSetOwnedTarget(null, msgs);
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
			case PivotPackage.MESSAGE_EXP__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.MESSAGE_EXP__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.MESSAGE_EXP__NAME:
				return getName();
			case PivotPackage.MESSAGE_EXP__IS_MANY:
				return isMany();
			case PivotPackage.MESSAGE_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.MESSAGE_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.MESSAGE_EXP__TYPE_VALUE:
				return getTypeValue();
			case PivotPackage.MESSAGE_EXP__OWNED_ARGUMENTS:
				return getOwnedArguments();
			case PivotPackage.MESSAGE_EXP__OWNED_CALLED_OPERATION:
				return getOwnedCalledOperation();
			case PivotPackage.MESSAGE_EXP__OWNED_SENT_SIGNAL:
				return getOwnedSentSignal();
			case PivotPackage.MESSAGE_EXP__OWNED_TARGET:
				return getOwnedTarget();
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
			case PivotPackage.MESSAGE_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
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
			case PivotPackage.MESSAGE_EXP__TYPE_VALUE:
				setTypeValue((Type)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_ARGUMENTS:
				getOwnedArguments().clear();
				getOwnedArguments().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_CALLED_OPERATION:
				setOwnedCalledOperation((CallOperationAction)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_SENT_SIGNAL:
				setOwnedSentSignal((SendSignalAction)newValue);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_TARGET:
				setOwnedTarget((OCLExpression)newValue);
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
			case PivotPackage.MESSAGE_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
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
			case PivotPackage.MESSAGE_EXP__TYPE_VALUE:
				setTypeValue((Type)null);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_ARGUMENTS:
				getOwnedArguments().clear();
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_CALLED_OPERATION:
				setOwnedCalledOperation((CallOperationAction)null);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_SENT_SIGNAL:
				setOwnedSentSignal((SendSignalAction)null);
				return;
			case PivotPackage.MESSAGE_EXP__OWNED_TARGET:
				setOwnedTarget((OCLExpression)null);
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
			case PivotPackage.MESSAGE_EXP__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.MESSAGE_EXP__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.MESSAGE_EXP__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.MESSAGE_EXP__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.MESSAGE_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.MESSAGE_EXP__IS_MANY:
				return isMany() != IS_MANY_EDEFAULT;
			case PivotPackage.MESSAGE_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.MESSAGE_EXP__TYPE:
				return type != null;
			case PivotPackage.MESSAGE_EXP__TYPE_VALUE:
				return typeValue != null;
			case PivotPackage.MESSAGE_EXP__OWNED_ARGUMENTS:
				return ownedArguments != null && !ownedArguments.isEmpty();
			case PivotPackage.MESSAGE_EXP__OWNED_CALLED_OPERATION:
				return ownedCalledOperation != null;
			case PivotPackage.MESSAGE_EXP__OWNED_SENT_SIGNAL:
				return ownedSentSignal != null;
			case PivotPackage.MESSAGE_EXP__OWNED_TARGET:
				return ownedTarget != null;
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
			case PivotPackage.MESSAGE_EXP___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.MESSAGE_EXP___MAKE_PARAMETER:
				return makeParameter();
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
