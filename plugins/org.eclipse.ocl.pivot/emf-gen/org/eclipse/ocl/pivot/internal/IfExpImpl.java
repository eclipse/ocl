/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.ParameterableElement;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.IfExpImpl#isIsElseIf <em>Is Else If</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.IfExpImpl#getOwnedCondition <em>Owned Condition</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.IfExpImpl#getOwnedElse <em>Owned Else</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.IfExpImpl#getOwnedThen <em>Owned Then</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfExpImpl
		extends OCLExpressionImpl
		implements IfExp {

	/**
	 * The default value of the '{@link #isIsElseIf() <em>Is Else If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsElseIf()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ELSE_IF_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsElseIf() <em>Is Else If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsElseIf()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ELSE_IF_EFLAG = 1 << 9;

	/**
	 * The cached value of the '{@link #getOwnedCondition() <em>Owned Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCondition()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedCondition;

	/**
	 * The cached value of the '{@link #getOwnedElse() <em>Owned Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElse()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedElse;

	/**
	 * The cached value of the '{@link #getOwnedThen() <em>Owned Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedThen()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedThen;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.IF_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsElseIf()
	{
		return (eFlags & IS_ELSE_IF_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsElseIf(boolean newIsElseIf)
	{
		boolean oldIsElseIf = (eFlags & IS_ELSE_IF_EFLAG) != 0;
		if (newIsElseIf) eFlags |= IS_ELSE_IF_EFLAG; else eFlags &= ~IS_ELSE_IF_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.IF_EXP__IS_ELSE_IF, oldIsElseIf, newIsElseIf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedCondition() {
		return ownedCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedCondition(OCLExpression newOwnedCondition, NotificationChain msgs)
	{
		OCLExpression oldOwnedCondition = ownedCondition;
		ownedCondition = newOwnedCondition;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.IF_EXP__OWNED_CONDITION, oldOwnedCondition, newOwnedCondition);
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
	public void setOwnedCondition(OCLExpression newOwnedCondition) {
		if (newOwnedCondition != ownedCondition)
		{
			NotificationChain msgs = null;
			if (ownedCondition != null)
				msgs = ((InternalEObject)ownedCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.IF_EXP__OWNED_CONDITION, null, msgs);
			if (newOwnedCondition != null)
				msgs = ((InternalEObject)newOwnedCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.IF_EXP__OWNED_CONDITION, null, msgs);
			msgs = basicSetOwnedCondition(newOwnedCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.IF_EXP__OWNED_CONDITION, newOwnedCondition, newOwnedCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedThen() {
		return ownedThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedThen(OCLExpression newOwnedThen, NotificationChain msgs)
	{
		OCLExpression oldOwnedThen = ownedThen;
		ownedThen = newOwnedThen;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.IF_EXP__OWNED_THEN, oldOwnedThen, newOwnedThen);
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
	public void setOwnedThen(OCLExpression newOwnedThen) {
		if (newOwnedThen != ownedThen)
		{
			NotificationChain msgs = null;
			if (ownedThen != null)
				msgs = ((InternalEObject)ownedThen).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.IF_EXP__OWNED_THEN, null, msgs);
			if (newOwnedThen != null)
				msgs = ((InternalEObject)newOwnedThen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.IF_EXP__OWNED_THEN, null, msgs);
			msgs = basicSetOwnedThen(newOwnedThen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.IF_EXP__OWNED_THEN, newOwnedThen, newOwnedThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleElseType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCompatibleElseType:
		 *   let severity : Integer[1] = 'IfExp::CompatibleElseType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[1] = ownedElse.type.conformsTo(type)
		 *       in
		 *         'IfExp::CompatibleElseType'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_IfExp_c_c_CompatibleElseType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_status;
		    try {
		        @SuppressWarnings("null")
		        final @NonNull /*@Thrown*/ OCLExpression ownedElse = this.getOwnedElse();
		        final @Nullable /*@Thrown*/ Type type = ownedElse.getType();
		        final @Nullable /*@Thrown*/ Type type_0 = this.getType();
		        final /*@Thrown*/ boolean status = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_IfExp_c_c_CompatibleElseType, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleThenType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCompatibleThenType:
		 *   let severity : Integer[1] = 'IfExp::CompatibleThenType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[1] = ownedThen.type.conformsTo(type)
		 *       in
		 *         'IfExp::CompatibleThenType'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_IfExp_c_c_CompatibleThenType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_status;
		    try {
		        @SuppressWarnings("null")
		        final @NonNull /*@Thrown*/ OCLExpression ownedThen = this.getOwnedThen();
		        final @Nullable /*@Thrown*/ Type type = ownedThen.getType();
		        final @Nullable /*@Thrown*/ Type type_0 = this.getType();
		        final /*@Thrown*/ boolean status = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_IfExp_c_c_CompatibleThenType, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedElse() {
		return ownedElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedElse(OCLExpression newOwnedElse, NotificationChain msgs)
	{
		OCLExpression oldOwnedElse = ownedElse;
		ownedElse = newOwnedElse;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.IF_EXP__OWNED_ELSE, oldOwnedElse, newOwnedElse);
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
	public void setOwnedElse(OCLExpression newOwnedElse) {
		if (newOwnedElse != ownedElse)
		{
			NotificationChain msgs = null;
			if (ownedElse != null)
				msgs = ((InternalEObject)ownedElse).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.IF_EXP__OWNED_ELSE, null, msgs);
			if (newOwnedElse != null)
				msgs = ((InternalEObject)newOwnedElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.IF_EXP__OWNED_ELSE, null, msgs);
			msgs = basicSetOwnedElse(newOwnedElse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.IF_EXP__OWNED_ELSE, newOwnedElse, newOwnedElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateConditionTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateConditionTypeIsBoolean:
		 *   let severity : Integer[1] = 'IfExp::ConditionTypeIsBoolean'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[?] = ownedCondition.type = Boolean and typeValue = null
		 *       in
		 *         'IfExp::ConditionTypeIsBoolean'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_IfExp_c_c_ConditionTypeIsBoolean);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_status;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_eq;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		            @SuppressWarnings("null")
		            final @NonNull /*@Thrown*/ OCLExpression ownedCondition = this.getOwnedCondition();
		            final @Nullable /*@Thrown*/ Type type = ownedCondition.getType();
		            final /*@Thrown*/ boolean eq = (type != null) ? (type.getTypeId() == TYP_Boolean_0.getTypeId()) : false;
		            CAUGHT_eq = eq;
		        }
		        catch (Exception e) {
		            CAUGHT_eq = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_eq_0;
		        try {
		            final @Nullable /*@Thrown*/ Type typeValue = this.getTypeValue();
		            final /*@Thrown*/ boolean eq_0 = typeValue == null;
		            CAUGHT_eq_0 = eq_0;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean status = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_IfExp_c_c_ConditionTypeIsBoolean, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
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
			case PivotPackage.IF_EXP__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.IF_EXP__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.IF_EXP__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.IF_EXP__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.IF_EXP__OWNED_CONDITION:
				return basicSetOwnedCondition(null, msgs);
			case PivotPackage.IF_EXP__OWNED_ELSE:
				return basicSetOwnedElse(null, msgs);
			case PivotPackage.IF_EXP__OWNED_THEN:
				return basicSetOwnedThen(null, msgs);
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
			case PivotPackage.IF_EXP__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.IF_EXP__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.IF_EXP__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.IF_EXP__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.IF_EXP__NAME:
				return getName();
			case PivotPackage.IF_EXP__IS_MANY:
				return isIsMany();
			case PivotPackage.IF_EXP__IS_REQUIRED:
				return isIsRequired();
			case PivotPackage.IF_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.IF_EXP__TYPE_VALUE:
				return getTypeValue();
			case PivotPackage.IF_EXP__IS_ELSE_IF:
				return isIsElseIf();
			case PivotPackage.IF_EXP__OWNED_CONDITION:
				return getOwnedCondition();
			case PivotPackage.IF_EXP__OWNED_ELSE:
				return getOwnedElse();
			case PivotPackage.IF_EXP__OWNED_THEN:
				return getOwnedThen();
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
			case PivotPackage.IF_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.IF_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.IF_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.IF_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.IF_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.IF_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.IF_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.IF_EXP__TYPE_VALUE:
				setTypeValue((Type)newValue);
				return;
			case PivotPackage.IF_EXP__IS_ELSE_IF:
				setIsElseIf((Boolean)newValue);
				return;
			case PivotPackage.IF_EXP__OWNED_CONDITION:
				setOwnedCondition((OCLExpression)newValue);
				return;
			case PivotPackage.IF_EXP__OWNED_ELSE:
				setOwnedElse((OCLExpression)newValue);
				return;
			case PivotPackage.IF_EXP__OWNED_THEN:
				setOwnedThen((OCLExpression)newValue);
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
			case PivotPackage.IF_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.IF_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.IF_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.IF_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.IF_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.IF_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.IF_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.IF_EXP__TYPE_VALUE:
				setTypeValue((Type)null);
				return;
			case PivotPackage.IF_EXP__IS_ELSE_IF:
				setIsElseIf(IS_ELSE_IF_EDEFAULT);
				return;
			case PivotPackage.IF_EXP__OWNED_CONDITION:
				setOwnedCondition((OCLExpression)null);
				return;
			case PivotPackage.IF_EXP__OWNED_ELSE:
				setOwnedElse((OCLExpression)null);
				return;
			case PivotPackage.IF_EXP__OWNED_THEN:
				setOwnedThen((OCLExpression)null);
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
			case PivotPackage.IF_EXP__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.IF_EXP__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.IF_EXP__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.IF_EXP__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.IF_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.IF_EXP__IS_MANY:
				return isIsMany() != IS_MANY_EDEFAULT;
			case PivotPackage.IF_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.IF_EXP__TYPE:
				return type != null;
			case PivotPackage.IF_EXP__TYPE_VALUE:
				return typeValue != null;
			case PivotPackage.IF_EXP__IS_ELSE_IF:
				return ((eFlags & IS_ELSE_IF_EFLAG) != 0) != IS_ELSE_IF_EDEFAULT;
			case PivotPackage.IF_EXP__OWNED_CONDITION:
				return ownedCondition != null;
			case PivotPackage.IF_EXP__OWNED_ELSE:
				return ownedElse != null;
			case PivotPackage.IF_EXP__OWNED_THEN:
				return ownedThen != null;
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
			case PivotPackage.IF_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.IF_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.IF_EXP___MAY_HAVE_NULL_NAME:
				return mayHaveNullName();
			case PivotPackage.IF_EXP___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.IF_EXP___MAY_HAVE_NULL_TYPE:
				return mayHaveNullType();
			case PivotPackage.IF_EXP___MAY_HAVE_OCL_INVALID_TYPE:
				return mayHaveOclInvalidType();
			case PivotPackage.IF_EXP___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.IF_EXP___VALIDATE_TYPE_IS_NOT_OCL_INVALID__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotOclInvalid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.IF_EXP___AS_TEMPLATE_PARAMETER:
				return asTemplateParameter();
			case PivotPackage.IF_EXP___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT:
				return isCompatibleWith((ParameterableElement)arguments.get(0));
			case PivotPackage.IF_EXP___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case PivotPackage.IF_EXP___IS_NON_NULL:
				return isNonNull();
			case PivotPackage.IF_EXP___VALIDATE_COMPATIBLE_ELSE_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleElseType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.IF_EXP___VALIDATE_COMPATIBLE_THEN_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleThenType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.IF_EXP___VALIDATE_CONDITION_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateConditionTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitIfExp(this);
	}
} //IfExpImpl
