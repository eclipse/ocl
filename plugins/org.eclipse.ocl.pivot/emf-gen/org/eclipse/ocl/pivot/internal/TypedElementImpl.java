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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.pivot.values.UnlimitedValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.TypedElementImpl#isIsMany <em>Is Many</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.TypedElementImpl#isIsRequired <em>Is Required</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.TypedElementImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TypedElementImpl
		extends NamedElementImpl
		implements TypedElement {

	/**
	 * The default value of the '{@link #isIsMany() <em>Is Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMany()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MANY_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isIsRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REQUIRED_EDEFAULT = true;
	/**
	 * The flag representing the value of the '{@link #isIsRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRequired()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_REQUIRED_EFLAG = 1 << 8;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedElementImpl() {
		super();
		eFlags |= IS_REQUIRED_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TYPED_ELEMENT;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsRequired()
	{
		return (eFlags & IS_REQUIRED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getType() {
		if (type != null && type.eIsProxy())
		{
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.TYPED_ELEMENT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPED_ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean CompatibleBody(final ValueSpecification bodySpecification)
	{
		/**
		 * bodySpecification.type?.conformsTo(self.type)
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @Nullable /*@Thrown*/ Type type = bodySpecification.getType();
		@Nullable /*@Caught*/ Object CAUGHT_type;
		try {
		    CAUGHT_type = type;
		}
		catch (Exception e) {
		    CAUGHT_type = ValueUtil.createInvalidValue(e);
		}
		final @NonNull /*@NonInvalid*/ Object symbol_0 = CAUGHT_type == null;
		@Nullable /*@Thrown*/ Boolean safe_conformsTo_source;
		if (symbol_0 == Boolean.TRUE) {
		    safe_conformsTo_source = null;
		}
		else {
		    final @Nullable /*@Thrown*/ Type type_0 = this.getType();
		    final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
		    safe_conformsTo_source = conformsTo;
		}
		if (safe_conformsTo_source == null) {
		    throw new InvalidValueException("Null body for \'pivot::TypedElement::CompatibleBody(ValueSpecification[1]) : Boolean[1]\'");
		}
		return safe_conformsTo_source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean mayHaveNullType()
	{
		/**
		 * false
		 */
		return ValueUtil.FALSE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean mayHaveOclInvalidType()
	{
		/**
		 * false
		 */
		return ValueUtil.FALSE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTypeIsNotNull(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateTypeIsNotNull:
		 *   let severity : Integer[1] = 'TypedElement::TypeIsNotNull'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : Boolean[?] = not mayHaveNullType() implies type <> null
		 *       in
		 *         'TypedElement::TypeIsNotNull'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_TypedElement_c_c_TypeIsNotNull);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_status;
		    try {
		        @Nullable /*@Caught*/ Object CAUGHT_not;
		        try {
		            final /*@Thrown*/ boolean mayHaveNullType = this.mayHaveNullType();
		            final @Nullable /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(mayHaveNullType);
		            CAUGHT_not = not;
		        }
		        catch (Exception e) {
		            CAUGHT_not = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_ne;
		        try {
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean ne = type != null;
		            CAUGHT_ne = ne;
		        }
		        catch (Exception e) {
		            CAUGHT_ne = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_not, CAUGHT_ne);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_TypedElement_c_c_TypeIsNotNull, this, diagnostics, context, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public boolean validateTypeIsNotOclInvalid(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv validateTypeIsNotOclInvalid:
		 *   let
		 *     severity : Integer[1] = 'TypedElement::TypeIsNotOclInvalid'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : Boolean[?] = not mayHaveOclInvalidType() implies type <> OclInvalid
		 *       in
		 *         'TypedElement::TypeIsNotOclInvalid'.logDiagnostic(self, diagnostics, context, severity, status, 0)
		 *     endif
		 */
		final @NonNull /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final @NonNull /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotTables.STR_TypedElement_c_c_TypeIsNotOclInvalid);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    @Nullable /*@Caught*/ Object CAUGHT_status;
		    try {
		        @Nullable /*@Caught*/ Object CAUGHT_not;
		        try {
		            final /*@Thrown*/ boolean mayHaveOclInvalidType = this.mayHaveOclInvalidType();
		            final @Nullable /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(mayHaveOclInvalidType);
		            CAUGHT_not = not;
		        }
		        catch (Exception e) {
		            CAUGHT_not = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_ne;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclInvalid = idResolver.getClass(TypeId.OCL_INVALID, null);
		            final @Nullable /*@Thrown*/ Type type = this.getType();
		            final /*@Thrown*/ boolean ne = (type != null) ? (type.getTypeId() != TYP_OclInvalid.getTypeId()) : true;
		            CAUGHT_ne = ne;
		        }
		        catch (Exception e) {
		            CAUGHT_ne = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_not, CAUGHT_ne);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, PivotTables.STR_TypedElement_c_c_TypeIsNotOclInvalid, this, diagnostics, context, severity_0, CAUGHT_status, PivotTables.INT_0).booleanValue();
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
	public void setIsRequired(boolean newIsRequired)
	{
		boolean oldIsRequired = (eFlags & IS_REQUIRED_EFLAG) != 0;
		if (newIsRequired) eFlags |= IS_REQUIRED_EFLAG; else eFlags &= ~IS_REQUIRED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPED_ELEMENT__IS_REQUIRED, oldIsRequired, newIsRequired));
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
			case PivotPackage.TYPED_ELEMENT__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.TYPED_ELEMENT__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.TYPED_ELEMENT__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.TYPED_ELEMENT__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.TYPED_ELEMENT__NAME:
				return getName();
			case PivotPackage.TYPED_ELEMENT__IS_MANY:
				return isIsMany();
			case PivotPackage.TYPED_ELEMENT__IS_REQUIRED:
				return isIsRequired();
			case PivotPackage.TYPED_ELEMENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case PivotPackage.TYPED_ELEMENT__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPED_ELEMENT__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.TYPED_ELEMENT__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPED_ELEMENT__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.TYPED_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.TYPED_ELEMENT__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.TYPED_ELEMENT__TYPE:
				setType((Type)newValue);
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
			case PivotPackage.TYPED_ELEMENT__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.TYPED_ELEMENT__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.TYPED_ELEMENT__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.TYPED_ELEMENT__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.TYPED_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.TYPED_ELEMENT__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.TYPED_ELEMENT__TYPE:
				setType((Type)null);
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
			case PivotPackage.TYPED_ELEMENT__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.TYPED_ELEMENT__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.TYPED_ELEMENT__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.TYPED_ELEMENT__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.TYPED_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.TYPED_ELEMENT__IS_MANY:
				return isIsMany() != IS_MANY_EDEFAULT;
			case PivotPackage.TYPED_ELEMENT__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.TYPED_ELEMENT__TYPE:
				return type != null;
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
			case PivotPackage.TYPED_ELEMENT___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.TYPED_ELEMENT___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.TYPED_ELEMENT___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.TYPED_ELEMENT___MAY_HAVE_NULL_TYPE:
				return mayHaveNullType();
			case PivotPackage.TYPED_ELEMENT___MAY_HAVE_OCL_INVALID_TYPE:
				return mayHaveOclInvalidType();
			case PivotPackage.TYPED_ELEMENT___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.TYPED_ELEMENT___VALIDATE_TYPE_IS_NOT_OCL_INVALID__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsNotOclInvalid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitTypedElement(this);
	}

	@Override
	public @NonNull TypeId getTypeId() {
		Type type2 = getType();
		return type2 != null ? type2.getTypeId() : TypeId.OCL_INVALID;
	}

	@Override
	public boolean isIsMany() {
		Type type = getType();
		if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			UnlimitedNaturalValue upperValue = collectionType.getUpperValue();
			return (upperValue instanceof UnlimitedValue) || (upperValue.intValue() > 1);
		}
		return false;
	}
} //TypedElementImpl
