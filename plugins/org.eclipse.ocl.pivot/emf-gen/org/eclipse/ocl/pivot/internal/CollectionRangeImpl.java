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
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionRangeImpl#getOwnedFirst <em>Owned First</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionRangeImpl#getOwnedLast <em>Owned Last</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionRangeImpl
		extends CollectionLiteralPartImpl
		implements CollectionRange {

	/**
	 * The cached value of the '{@link #getOwnedFirst() <em>Owned First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFirst()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedFirst;

	/**
	 * The cached value of the '{@link #getOwnedLast() <em>Owned Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLast()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedLast;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COLLECTION_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedFirst() {
		return ownedFirst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedFirst(OCLExpression newOwnedFirst, NotificationChain msgs)
	{
		OCLExpression oldOwnedFirst = ownedFirst;
		ownedFirst = newOwnedFirst;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_RANGE__OWNED_FIRST, oldOwnedFirst, newOwnedFirst);
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
	public void setOwnedFirst(OCLExpression newOwnedFirst) {
		if (newOwnedFirst != ownedFirst)
		{
			NotificationChain msgs = null;
			if (ownedFirst != null)
				msgs = ((InternalEObject)ownedFirst).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__OWNED_FIRST, null, msgs);
			if (newOwnedFirst != null)
				msgs = ((InternalEObject)newOwnedFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__OWNED_FIRST, null, msgs);
			msgs = basicSetOwnedFirst(newOwnedFirst, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_RANGE__OWNED_FIRST, newOwnedFirst, newOwnedFirst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedLast() {
		return ownedLast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedLast(OCLExpression newOwnedLast, NotificationChain msgs)
	{
		OCLExpression oldOwnedLast = ownedLast;
		ownedLast = newOwnedLast;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_RANGE__OWNED_LAST, oldOwnedLast, newOwnedLast);
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
	public void setOwnedLast(OCLExpression newOwnedLast) {
		if (newOwnedLast != ownedLast)
		{
			NotificationChain msgs = null;
			if (ownedLast != null)
				msgs = ((InternalEObject)ownedLast).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__OWNED_LAST, null, msgs);
			if (newOwnedLast != null)
				msgs = ((InternalEObject)newOwnedLast).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.COLLECTION_RANGE__OWNED_LAST, null, msgs);
			msgs = basicSetOwnedLast(newOwnedLast, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_RANGE__OWNED_LAST, newOwnedLast, newOwnedLast));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean isNullFree()
	{
		/**
		 * 
		 * if ownedFirst.isNonNull() = null or ownedLast.isNonNull() = null
		 * then null
		 * else ownedFirst.isNonNull() and ownedLast.isNonNull()
		 * endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		@NonNull /*@Caught*/ Object CAUGHT_eq;
		try {
		    @SuppressWarnings("null")
		    final @NonNull /*@Thrown*/ OCLExpression ownedFirst = this.getOwnedFirst();
		    final @Nullable /*@Thrown*/ Boolean isNonNull = ownedFirst.isNonNull();
		    final /*@Thrown*/ boolean eq = isNonNull == null;
		    CAUGHT_eq = eq;
		}
		catch (Exception e) {
		    CAUGHT_eq = ValueUtil.createInvalidValue(e);
		}
		@NonNull /*@Caught*/ Object CAUGHT_eq_0;
		try {
		    @SuppressWarnings("null")
		    final @NonNull /*@Thrown*/ OCLExpression ownedLast = this.getOwnedLast();
		    final @Nullable /*@Thrown*/ Boolean isNonNull_0 = ownedLast.isNonNull();
		    final /*@Thrown*/ boolean eq_0 = isNonNull_0 == null;
		    CAUGHT_eq_0 = eq_0;
		}
		catch (Exception e) {
		    CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		}
		final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		if (or == null) {
		    throw new InvalidValueException("Null if condition");
		}
		@Nullable /*@Thrown*/ Boolean symbol_0;
		if (or) {
		    symbol_0 = null;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_isNonNull_1;
		    try {
		        @SuppressWarnings("null")
		        final @NonNull /*@Thrown*/ OCLExpression ownedFirst_0 = this.getOwnedFirst();
		        final @Nullable /*@Thrown*/ Boolean isNonNull_1 = ownedFirst_0.isNonNull();
		        CAUGHT_isNonNull_1 = isNonNull_1;
		    }
		    catch (Exception e) {
		        CAUGHT_isNonNull_1 = ValueUtil.createInvalidValue(e);
		    }
		    @Nullable /*@Caught*/ Object CAUGHT_isNonNull_2;
		    try {
		        @SuppressWarnings("null")
		        final @NonNull /*@Thrown*/ OCLExpression ownedLast_0 = this.getOwnedLast();
		        final @Nullable /*@Thrown*/ Boolean isNonNull_2 = ownedLast_0.isNonNull();
		        CAUGHT_isNonNull_2 = isNonNull_2;
		    }
		    catch (Exception e) {
		        CAUGHT_isNonNull_2 = ValueUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_isNonNull_1, CAUGHT_isNonNull_2);
		    symbol_0 = and;
		}
		return symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleFirstType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCompatibleFirstType:
		 *   let
		 *     severity : Integer[1] = 'CollectionRange::CompatibleFirstType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[1] = ownedFirst.type.conformsTo(self.type)
		 *       in
		 *         'CollectionRange::CompatibleFirstType'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_CollectionRange_c_c_CompatibleFirstType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_status;
		    try {
		        @SuppressWarnings("null")
		        final @NonNull /*@Thrown*/ OCLExpression ownedFirst = this.getOwnedFirst();
		        final @Nullable /*@Thrown*/ Type type = ownedFirst.getType();
		        final @Nullable /*@Thrown*/ Type type_0 = this.getType();
		        final /*@Thrown*/ boolean status = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_CollectionRange_c_c_CompatibleFirstType, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public boolean validateCompatibleLastType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateCompatibleLastType:
		 *   let
		 *     severity : Integer[1] = 'CollectionRange::CompatibleLastType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[1] = ownedLast.type.conformsTo(self.type)
		 *       in
		 *         'CollectionRange::CompatibleLastType'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_CollectionRange_c_c_CompatibleLastType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_status;
		    try {
		        @SuppressWarnings("null")
		        final @NonNull /*@Thrown*/ OCLExpression ownedLast = this.getOwnedLast();
		        final @Nullable /*@Thrown*/ Type type = ownedLast.getType();
		        final @Nullable /*@Thrown*/ Type type_0 = this.getType();
		        final /*@Thrown*/ boolean status = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_CollectionRange_c_c_CompatibleLastType, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
			case PivotPackage.COLLECTION_RANGE__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_RANGE__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_RANGE__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_RANGE__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_RANGE__OWNED_FIRST:
				return basicSetOwnedFirst(null, msgs);
			case PivotPackage.COLLECTION_RANGE__OWNED_LAST:
				return basicSetOwnedLast(null, msgs);
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
			case PivotPackage.COLLECTION_RANGE__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.COLLECTION_RANGE__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.COLLECTION_RANGE__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.COLLECTION_RANGE__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.COLLECTION_RANGE__NAME:
				return getName();
			case PivotPackage.COLLECTION_RANGE__IS_MANY:
				return isIsMany();
			case PivotPackage.COLLECTION_RANGE__IS_REQUIRED:
				return isIsRequired();
			case PivotPackage.COLLECTION_RANGE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.COLLECTION_RANGE__OWNED_FIRST:
				return getOwnedFirst();
			case PivotPackage.COLLECTION_RANGE__OWNED_LAST:
				return getOwnedLast();
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
			case PivotPackage.COLLECTION_RANGE__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_FIRST:
				setOwnedFirst((OCLExpression)newValue);
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_LAST:
				setOwnedLast((OCLExpression)newValue);
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
			case PivotPackage.COLLECTION_RANGE__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.COLLECTION_RANGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_RANGE__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_RANGE__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_FIRST:
				setOwnedFirst((OCLExpression)null);
				return;
			case PivotPackage.COLLECTION_RANGE__OWNED_LAST:
				setOwnedLast((OCLExpression)null);
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
			case PivotPackage.COLLECTION_RANGE__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.COLLECTION_RANGE__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.COLLECTION_RANGE__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.COLLECTION_RANGE__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.COLLECTION_RANGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COLLECTION_RANGE__IS_MANY:
				return isIsMany() != IS_MANY_EDEFAULT;
			case PivotPackage.COLLECTION_RANGE__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.COLLECTION_RANGE__TYPE:
				return type != null;
			case PivotPackage.COLLECTION_RANGE__OWNED_FIRST:
				return ownedFirst != null;
			case PivotPackage.COLLECTION_RANGE__OWNED_LAST:
				return ownedLast != null;
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
		if (baseClass == CollectionLiteralPart.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.COLLECTION_LITERAL_PART___IS_NULL_FREE: return PivotPackage.COLLECTION_RANGE___IS_NULL_FREE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case PivotPackage.COLLECTION_RANGE___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.COLLECTION_RANGE___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.COLLECTION_RANGE___MAY_HAVE_NULL_NAME:
				return mayHaveNullName();
			case PivotPackage.COLLECTION_RANGE___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.COLLECTION_RANGE___MAY_HAVE_NULL_TYPE:
				return mayHaveNullType();
			case PivotPackage.COLLECTION_RANGE___MAY_HAVE_OCL_INVALID_TYPE:
				return mayHaveOclInvalidType();
			case PivotPackage.COLLECTION_RANGE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_RANGE___VALIDATE_TYPE_IS_NOT_OCL_INVALID__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotOclInvalid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_RANGE___IS_NULL_FREE:
				return isNullFree();
			case PivotPackage.COLLECTION_RANGE___VALIDATE_COMPATIBLE_FIRST_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleFirstType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_RANGE___VALIDATE_COMPATIBLE_LAST_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleLastType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCollectionRange(this);
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return TypeId.INTEGER_RANGE;
	}
} //CollectionRangeImpl
