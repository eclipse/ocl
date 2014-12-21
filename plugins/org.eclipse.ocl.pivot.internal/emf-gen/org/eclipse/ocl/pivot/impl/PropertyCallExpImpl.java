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
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.DomainEvaluator;
import org.eclipse.ocl.pivot.manager.TemplateSpecialisation;
import org.eclipse.ocl.pivot.messages.EvaluatorMessages;
import org.eclipse.ocl.pivot.util.PivotValidator;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.impl.PropertyCallExpImpl#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyCallExpImpl
		extends NavigationCallExpImpl
		implements PropertyCallExp {

	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.PROPERTY_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredProperty() {
		if (referredProperty != null && referredProperty.eIsProxy())
		{
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty() {
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredProperty(Property newReferredProperty) {
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
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
			case PivotPackage.PROPERTY_CALL_EXP__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				return getName();
			case PivotPackage.PROPERTY_CALL_EXP__IS_MANY:
				return isMany();
			case PivotPackage.PROPERTY_CALL_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.PROPERTY_CALL_EXP__TYPE_VALUE:
				return getTypeValue();
			case PivotPackage.PROPERTY_CALL_EXP__IS_IMPLICIT:
				return isImplicit();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_SOURCE:
				return getOwnedSource();
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				return isPre();
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				if (resolve) return getNavigationSource();
				return basicGetNavigationSource();
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIERS:
				return getQualifiers();
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
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
			case PivotPackage.PROPERTY_CALL_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__TYPE_VALUE:
				setTypeValue((Type)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_IMPLICIT:
				setIsImplicit((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_SOURCE:
				setOwnedSource((OCLExpression)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				setIsPre((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIERS:
				getQualifiers().clear();
				getQualifiers().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
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
			case PivotPackage.PROPERTY_CALL_EXP__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__TYPE_VALUE:
				setTypeValue((Type)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_IMPLICIT:
				setIsImplicit(IS_IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_SOURCE:
				setOwnedSource((OCLExpression)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				setIsPre(IS_PRE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIERS:
				getQualifiers().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				setReferredProperty((Property)null);
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
			case PivotPackage.PROPERTY_CALL_EXP__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PROPERTY_CALL_EXP__IS_MANY:
				return isMany() != IS_MANY_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				return type != null;
			case PivotPackage.PROPERTY_CALL_EXP__TYPE_VALUE:
				return typeValue != null;
			case PivotPackage.PROPERTY_CALL_EXP__IS_IMPLICIT:
				return ((eFlags & IS_IMPLICIT_EFLAG) != 0) != IS_IMPLICIT_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_SOURCE:
				return ownedSource != null;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				return ((eFlags & IS_PRE_EFLAG) != 0) != IS_PRE_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				return navigationSource != null;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIERS:
				return qualifiers != null && !qualifiers.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				return referredProperty != null;
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
				case PivotPackage.REFERRING_ELEMENT___GET_REFERRED_ELEMENT: return PivotPackage.PROPERTY_CALL_EXP___GET_REFERRED_ELEMENT;
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
			case PivotPackage.PROPERTY_CALL_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.PROPERTY_CALL_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.PROPERTY_CALL_EXP___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.PROPERTY_CALL_EXP___MAKE_PARAMETER:
				return makeParameter();
			case PivotPackage.PROPERTY_CALL_EXP___GET_REFERRED_ELEMENT:
				return getReferredElement();
			case PivotPackage.PROPERTY_CALL_EXP___VALIDATE_COMPATIBLE_RESULT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleResultType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.PROPERTY_CALL_EXP___VALIDATE_NON_STATIC_SOURCE_TYPE_IS_CONFORMANT__DIAGNOSTICCHAIN_MAP:
				return validateNonStaticSourceTypeIsConformant((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.PROPERTY_CALL_EXP___GET_SPECIALIZED_REFERRED_PROPERTY_OWNING_TYPE:
				return getSpecializedReferredPropertyOwningType();
			case PivotPackage.PROPERTY_CALL_EXP___GET_SPECIALIZED_REFERRED_PROPERTY_TYPE:
				return getSpecializedReferredPropertyType();
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitPropertyCallExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Element getReferredElement()
	{
		return getReferredProperty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getSpecializedReferredPropertyOwningType()
	{
		Property referredProperty = getReferredProperty();
		org.eclipse.ocl.pivot.Class referencedType = referredProperty.getOwningClass();
		if (TemplateSpecialisation.needsSpecialisation(referencedType)) {
		    DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
			TemplateSpecialisation templateSpecialization = new TemplateSpecialisation(evaluator.getCompleteEnvironment());
			Type resultType = getType();
//			if (resultType instanceof DomainMetaclass) {
//				resultType = ((DomainMetaclass)resultType).getInstanceType();
//			}
			templateSpecialization.installEquivalence(resultType, referredProperty.getType());
			if (referencedType != null) {
				return templateSpecialization.getSpecialisation(referencedType);
			}
		}
		if (referencedType != null) {
			return referencedType;
		}
		else {
		    DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		    return evaluator.getCompleteEnvironment().getOwnedStandardLibrary().getOclInvalidType();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getSpecializedReferredPropertyType()
	{
		Property referredProperty = getReferredProperty();
		Type referencedType = referredProperty.getType();
		Type specializedType = referencedType;
		if ((referencedType != null) && TemplateSpecialisation.needsSpecialisation(referencedType)) {
		    DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
			TemplateSpecialisation templateSpecialization = new TemplateSpecialisation(evaluator.getCompleteEnvironment());
			Type resultType = getType();
//			boolean isMetaclass = resultType instanceof DomainMetaclass;
//			if (isMetaclass) {
//				resultType = ((DomainMetaclass)resultType).getInstanceType();
//			}
			templateSpecialization.installEquivalence(resultType, referredProperty.getType());
			specializedType = templateSpecialization.getSpecialisation(referencedType);
//			if (isMetaclass && (specializedType != null)) {
//				specializedType = PivotTables.LIBRARY.getMetaclass(specializedType);
//			}
		}
		if (specializedType instanceof DataType) {
			org.eclipse.ocl.pivot.Class behavioralType = ((DataType)specializedType).getBehavioralClass();
			return behavioralType != null ? behavioralType : (DataType)specializedType;
		}
		else if (specializedType instanceof org.eclipse.ocl.pivot.Class) {
			return (org.eclipse.ocl.pivot.Class)specializedType;
		}
		else {
		    DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		    return evaluator.getCompleteEnvironment().getOwnedStandardLibrary().getOclInvalidType();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNonStaticSourceTypeIsConformant(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv NonStaticSourceTypeIsConformant: not referredProperty.isStatic implies
		 *   ownedSource.type.conformsTo(getSpecializedReferredPropertyOwningType())
		 */
		@Nullable /*@Caught*/ Object CAUGHT_symbol_12;
		try {
		    @Nullable /*@Caught*/ Object CAUGHT_symbol_2;
		    try {
		        @Nullable /*@Caught*/ Object CAUGHT_self_71;
		        try {
		            final @Nullable /*@Thrown*/ Property referredProperty = this.getReferredProperty();
		            if (referredProperty == null) {
		                throw new InvalidValueException("Null source for \'pivot::Feature::isStatic\'");
		            }
		            final @Nullable /*@Thrown*/ Boolean self_71 = referredProperty.isStatic();
		            CAUGHT_self_71 = self_71;
		        }
		        catch (Exception e) {
		            CAUGHT_self_71 = ValueUtil.createInvalidValue(e);
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
		                symbol_1 = eq_0;
		            }
		            symbol_2 = symbol_1;
		        }
		        CAUGHT_symbol_2 = symbol_2;
		    }
		    catch (Exception e) {
		        CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @Nullable /*@Thrown*/ OCLExpression ownedSource = this.getOwnedSource();
		        if (ownedSource == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ Type type = ownedSource.getType();
		        final @NonNull /*@Thrown*/ org.eclipse.ocl.pivot.Class getSpecializedReferredPropertyOwningType = this.getSpecializedReferredPropertyOwningType();
		        final /*@Thrown*/ boolean b = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, type, getSpecializedReferredPropertyOwningType).booleanValue();
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_3 = CAUGHT_symbol_2 instanceof InvalidValueException;
		    @Nullable /*@Thrown*/ Boolean symbol_12;
		    if (symbol_3) {
		        final /*@NonInvalid*/ boolean symbol_4 = CAUGHT_b instanceof InvalidValueException;
		        @Nullable /*@Thrown*/ Boolean symbol_6;
		        if (symbol_4) {
		            if (CAUGHT_symbol_2 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_symbol_2;
		            }
		            symbol_6 = (Boolean)CAUGHT_symbol_2;
		        }
		        else {
		            @Nullable /*@Thrown*/ Boolean symbol_5;
		            if (CAUGHT_b == Boolean.TRUE) {
		                symbol_5 = ValueUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_symbol_2 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_symbol_2;
		                }
		                symbol_5 = (Boolean)CAUGHT_symbol_2;
		            }
		            symbol_6 = symbol_5;
		        }
		        symbol_12 = symbol_6;
		    }
		    else {
		        if (CAUGHT_symbol_2 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_symbol_2;
		        }
		        final /*@Thrown*/ boolean eq_1 = CAUGHT_symbol_2 == Boolean.FALSE;
		        @Nullable /*@Thrown*/ Boolean symbol_11;
		        if (eq_1) {
		            symbol_11 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_7 = CAUGHT_b instanceof InvalidValueException;
		            @Nullable /*@Thrown*/ Boolean symbol_10;
		            if (symbol_7) {
		                if (CAUGHT_b instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b;
		                }
		                symbol_10 = (Boolean)CAUGHT_b;
		            }
		            else {
		                @Nullable /*@NonInvalid*/ Boolean symbol_9;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_9 = ValueUtil.TRUE_VALUE;
		                }
		                else {
		                    final /*@Thrown*/ boolean eq_2 = CAUGHT_symbol_2 == null;
		                    @Nullable /*@NonInvalid*/ Boolean symbol_8;
		                    if (eq_2) {
		                        symbol_8 = null;
		                    }
		                    else {
		                        symbol_8 = ValueUtil.FALSE_VALUE;
		                    }
		                    symbol_9 = symbol_8;
		                }
		                symbol_10 = symbol_9;
		            }
		            symbol_11 = symbol_10;
		        }
		        symbol_12 = symbol_11;
		    }
		    CAUGHT_symbol_12 = symbol_12;
		}
		catch (Exception e) {
		    CAUGHT_symbol_12 = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_12 == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_symbol_12 == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"PropertyCallExp", "NonStaticSourceTypeIsConformant", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.PROPERTY_CALL_EXP__NON_STATIC_SOURCE_TYPE_IS_CONFORMANT, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleResultType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv CompatibleResultType: type = getSpecializedReferredPropertyType()
		 */
		@NonNull /*@Caught*/ Object CAUGHT_eq;
		try {
		    final @Nullable /*@Thrown*/ Type type = this.getType();
		    final @NonNull /*@Thrown*/ org.eclipse.ocl.pivot.Class getSpecializedReferredPropertyType = this.getSpecializedReferredPropertyType();
		    final /*@Thrown*/ boolean eq = (type != null) ? (type.getTypeId() == getSpecializedReferredPropertyType.getTypeId()) : ValueUtil.throwBooleanInvalidValueException("null equal input");
		    ;
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
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"PropertyCallExp", "CompatibleResultType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.PROPERTY_CALL_EXP__COMPATIBLE_RESULT_TYPE, message, new Object [] { this }));
		}
		return false;
	}
} //PropertyCallExpImpl
