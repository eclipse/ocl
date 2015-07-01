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
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unlimited Natural Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.UnlimitedNaturalLiteralExpImpl#getUnlimitedNaturalSymbol <em>Unlimited Natural Symbol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnlimitedNaturalLiteralExpImpl
		extends NumericLiteralExpImpl
		implements UnlimitedNaturalLiteralExp {

	/**
	 * The default value of the '{@link #getUnlimitedNaturalSymbol() <em>Unlimited Natural Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnlimitedNaturalSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final Number UNLIMITED_NATURAL_SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnlimitedNaturalSymbol() <em>Unlimited Natural Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnlimitedNaturalSymbol()
	 * @generated
	 * @ordered
	 */
	protected Number unlimitedNaturalSymbol = UNLIMITED_NATURAL_SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnlimitedNaturalLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Number getUnlimitedNaturalSymbol() {
		return unlimitedNaturalSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnlimitedNaturalSymbol(Number newUnlimitedNaturalSymbol)
	{
		Number oldUnlimitedNaturalSymbol = unlimitedNaturalSymbol;
		unlimitedNaturalSymbol = newUnlimitedNaturalSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL, oldUnlimitedNaturalSymbol, unlimitedNaturalSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTypeIsUnlimitedNatural(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateTypeIsUnlimitedNatural:
		 *   let
		 *     severity : Integer[1] = 'UnlimitedNaturalLiteralExp::TypeIsUnlimitedNatural'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[1] = type = UnlimitedNatural
		 *       in
		 *         'UnlimitedNaturalLiteralExp::TypeIsUnlimitedNatural'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_UnlimitedNaturalLiteralExp_c_c_TypeIsUnlimitedNatural);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @NonNull /*@Caught*/ Object CAUGHT_status;
		    try {
		        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_UnlimitedNatural = idResolver.getClass(TypeId.UNLIMITED_NATURAL, null);
		        final @Nullable /*@Thrown*/ Type type = this.getType();
		        final /*@Thrown*/ boolean status = (type != null) ? (type.getTypeId() == TYP_UnlimitedNatural.getTypeId()) : false;
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_UnlimitedNaturalLiteralExp_c_c_TypeIsUnlimitedNatural, this, null, diagnostics, context, null, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__NAME:
				return getName();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_MANY:
				return isIsMany();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_REQUIRED:
				return isIsRequired();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE_VALUE:
				return getTypeValue();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL:
				return getUnlimitedNaturalSymbol();
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
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE_VALUE:
				setTypeValue((Type)newValue);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL:
				setUnlimitedNaturalSymbol((Number)newValue);
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
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE_VALUE:
				setTypeValue((Type)null);
				return;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL:
				setUnlimitedNaturalSymbol(UNLIMITED_NATURAL_SYMBOL_EDEFAULT);
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
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_MANY:
				return isIsMany() != IS_MANY_EDEFAULT;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE:
				return type != null;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__TYPE_VALUE:
				return typeValue != null;
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL:
				return UNLIMITED_NATURAL_SYMBOL_EDEFAULT == null ? unlimitedNaturalSymbol != null : !UNLIMITED_NATURAL_SYMBOL_EDEFAULT.equals(unlimitedNaturalSymbol);
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
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP___MAY_HAVE_NULL_NAME:
				return mayHaveNullName();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP___MAY_HAVE_NULL_TYPE:
				return mayHaveNullType();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP___MAY_HAVE_OCL_INVALID_TYPE:
				return mayHaveOclInvalidType();
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP___VALIDATE_TYPE_IS_NOT_OCL_INVALID__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotOclInvalid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP___VALIDATE_TYPE_VALUE_IS_NULL__DIAGNOSTICCHAIN_MAP:
				return validateTypeValueIsNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP___VALIDATE_TYPE_IS_UNLIMITED_NATURAL__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsUnlimitedNatural((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return visitor.visitUnlimitedNaturalLiteralExp(this);
	}
} //UnlimitedNaturalLiteralExpImpl
