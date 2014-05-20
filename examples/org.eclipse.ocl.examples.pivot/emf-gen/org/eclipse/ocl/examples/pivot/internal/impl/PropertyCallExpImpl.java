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
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.TemplateSpecialisation;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyCallExpImpl#getReferredProperty <em>Referred Property</em>}</li>
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
	public Property getReferredProperty() {
		if (referredProperty != null && ((EObject)referredProperty).eIsProxy())
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
			case PivotPackage.PROPERTY_CALL_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				return getName();
			case PivotPackage.PROPERTY_CALL_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				return isImplicit();
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				return getSource();
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				return isPre();
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				if (resolve) return getNavigationSource();
				return basicGetNavigationSource();
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				return getQualifier();
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
			case PivotPackage.PROPERTY_CALL_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
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
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				setSource((OCLExpression)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				setIsPre((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				getQualifier().clear();
				getQualifier().addAll((Collection<? extends OCLExpression>)newValue);
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
			case PivotPackage.PROPERTY_CALL_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
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
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				setSource((OCLExpression)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				setIsPre(IS_PRE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				getQualifier().clear();
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
			case PivotPackage.PROPERTY_CALL_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PROPERTY_CALL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				return type != null;
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				return source != null;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				return ((eFlags & IS_PRE_EFLAG) != 0) != IS_PRE_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				return navigationSource != null;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				return qualifier != null && !qualifier.isEmpty();
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
	public Element getReferredElement()
	{
		return getReferredProperty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DomainType getSpecializedReferredPropertyOwningType()
	{
		Property referredProperty = getReferredProperty();
		Type referencedType = referredProperty.getOwningType();
		if (!TemplateSpecialisation.needsSpecialisation(referencedType)) {
			return referencedType;
		}
		TemplateSpecialisation templateSpecialization = new TemplateSpecialisation(PivotTables.LIBRARY);
		DomainType resultType = getType();
//		if (resultType instanceof DomainMetaclass) {
//			resultType = ((DomainMetaclass)resultType).getInstanceType();
//		}
		templateSpecialization.installEquivalence(resultType, referredProperty.getType());
		return templateSpecialization.getSpecialisation(referencedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DomainType getSpecializedReferredPropertyType()
	{
		Property referredProperty = getReferredProperty();
		Type referencedType = referredProperty.getType();
		DomainType specializedType = referencedType;
		if ((referencedType != null) && TemplateSpecialisation.needsSpecialisation(referencedType)) {
			TemplateSpecialisation templateSpecialization = new TemplateSpecialisation(PivotTables.LIBRARY);
			DomainType resultType = getType();
			boolean isMetaclass = resultType instanceof DomainMetaclass;
			if (isMetaclass) {
				resultType = ((DomainMetaclass)resultType).getInstanceType();
			}
			templateSpecialization.installEquivalence(resultType, referredProperty.getType());
			specializedType = templateSpecialization.getSpecialisation(referencedType);
			if (isMetaclass && (specializedType != null)) {
				specializedType = PivotTables.LIBRARY.getMetaclass(specializedType);
			}
		}
		if (specializedType instanceof DataType) {
			Type behavioralType = ((DataType)specializedType).getBehavioralType();
			return behavioralType != null ? behavioralType : specializedType;
		}
		else {
			return specializedType;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonStaticSourceTypeIsConformant(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv NonStaticSourceTypeIsConformant: not referredProperty.isStatic implies source.type.conformsTo(getSpecializedReferredPropertyOwningType())
		 * 
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_10;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_symbol_1;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_self_71;
		        try {
		            final @Nullable /*@Thrown*/ DomainProperty referredProperty = this.getReferredProperty();
		            if (referredProperty == null) {
		                throw new InvalidValueException("Null source for \'pivot::NamedElement::isStatic\'");
		            }
		            final /*@Thrown*/ boolean self_71 = referredProperty.isStatic();
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
		    final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @Nullable /*@Thrown*/ DomainExpression source = this.getSource();
		        if (source == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ DomainType type = source.getType();
		        final @NonNull /*@Thrown*/ DomainType getSpecializedReferredPropertyOwningType = this.getSpecializedReferredPropertyOwningType();
		        final /*@Thrown*/ boolean b = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, type, getSpecializedReferredPropertyOwningType).booleanValue();
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValuesUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_2 = CAUGHT_symbol_1 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_10;
		    if (symbol_2) {
		        final /*@NonInvalid*/ boolean symbol_3 = CAUGHT_b instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_5;
		        if (symbol_3) {
		            if (CAUGHT_symbol_1 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_symbol_1;
		            }
		            symbol_5 = (Boolean)CAUGHT_symbol_1;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_4;
		            if (CAUGHT_b == Boolean.TRUE) {
		                symbol_4 = ValuesUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_symbol_1 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_symbol_1;
		                }
		                symbol_4 = (Boolean)CAUGHT_symbol_1;
		            }
		            symbol_5 = symbol_4;
		        }
		        symbol_10 = symbol_5;
		    }
		    else {
		        if (CAUGHT_symbol_1 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_symbol_1;
		        }
		        final /*@Thrown*/ boolean eq_0 = CAUGHT_symbol_1 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_9;
		        if (eq_0) {
		            symbol_9 = ValuesUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_6 = CAUGHT_b instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_8;
		            if (symbol_6) {
		                if (CAUGHT_b instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b;
		                }
		                symbol_8 = (Boolean)CAUGHT_b;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_7;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_7 = ValuesUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_7 = ValuesUtil.FALSE_VALUE;
		                }
		                symbol_8 = symbol_7;
		            }
		            symbol_9 = symbol_8;
		        }
		        symbol_10 = symbol_9;
		    }
		    CAUGHT_symbol_10 = symbol_10;
		}
		catch (Exception e) {
		    CAUGHT_symbol_10 = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_10 == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
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
	public boolean validateCompatibleResultType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv CompatibleResultType: type = getSpecializedReferredPropertyType()
		 * 
		 * 
		 */
		@NonNull /*@Caught*/ Object CAUGHT_eq;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = this.getType();
		    final @NonNull /*@Thrown*/ DomainType getSpecializedReferredPropertyType = this.getSpecializedReferredPropertyType();
		    final /*@Thrown*/ boolean eq = (type != null) ? (type.getTypeId() == getSpecializedReferredPropertyType.getTypeId()) : ValuesUtil.throwBooleanInvalidValueException("null equal input");
		    ;
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
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"PropertyCallExp", "CompatibleResultType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.PROPERTY_CALL_EXP__COMPATIBLE_RESULT_TYPE, message, new Object [] { this }));
		}
		return false;
	}
} //PropertyCallExpImpl
