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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableImpl#isImplicit <em>Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableImpl#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.VariableImpl#getRepresentedParameter <em>Represented Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl
		extends VariableDeclarationImpl
		implements Variable {

	/**
	 * The default value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPLICIT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final int IMPLICIT_EFLAG = 1 << 10;

	/**
	 * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression initExpression;

	/**
	 * The cached value of the '{@link #getRepresentedParameter() <em>Represented Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentedParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter representedParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getInitExpression() {
		return initExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExpression(
			OCLExpression newInitExpression, NotificationChain msgs) {
		OCLExpression oldInitExpression = initExpression;
		initExpression = newInitExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.VARIABLE__INIT_EXPRESSION, oldInitExpression, newInitExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExpression(OCLExpression newInitExpression) {
		if (newInitExpression != initExpression)
		{
			NotificationChain msgs = null;
			if (initExpression != null)
				msgs = ((InternalEObject)initExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.VARIABLE__INIT_EXPRESSION, null, msgs);
			if (newInitExpression != null)
				msgs = ((InternalEObject)newInitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.VARIABLE__INIT_EXPRESSION, null, msgs);
			msgs = basicSetInitExpression(newInitExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.VARIABLE__INIT_EXPRESSION, newInitExpression, newInitExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getRepresentedParameter() {
		if (representedParameter != null && ((EObject)representedParameter).eIsProxy())
		{
			InternalEObject oldRepresentedParameter = (InternalEObject)representedParameter;
			representedParameter = (Parameter)eResolveProxy(oldRepresentedParameter);
			if (representedParameter != oldRepresentedParameter)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.VARIABLE__REPRESENTED_PARAMETER, oldRepresentedParameter, representedParameter));
			}
		}
		return representedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetRepresentedParameter() {
		return representedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentedParameter(Parameter newRepresentedParameter) {
		Parameter oldRepresentedParameter = representedParameter;
		representedParameter = newRepresentedParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.VARIABLE__REPRESENTED_PARAMETER, oldRepresentedParameter, representedParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompatibleInitialiserType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv CompatibleInitialiserType: initExpression <> null implies initExpression.type.conformsTo(type)
		 * 
		 * 
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_self_71;
		    try {
		        final @Nullable /*@Thrown*/ DomainExpression initExpression = this.getInitExpression();
		        final /*@Thrown*/ boolean self_71 = initExpression != null;
		        CAUGHT_self_71 = self_71;
		    }
		    catch (Exception e) {
		        CAUGHT_self_71 = ValuesUtil.createInvalidValue(e);
		    }
		    final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		    @NonNull /*@Caught*/ Object CAUGHT_b;
		    try {
		        final @Nullable /*@Thrown*/ DomainExpression initExpression_0 = this.getInitExpression();
		        if (initExpression_0 == null) {
		            throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		        }
		        final @Nullable /*@Thrown*/ DomainType type = initExpression_0.getType();
		        final @Nullable /*@Thrown*/ DomainType type_0 = this.getType();
		        final /*@Thrown*/ boolean b = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, type, type_0).booleanValue();
		        CAUGHT_b = b;
		    }
		    catch (Exception e) {
		        CAUGHT_b = ValuesUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_0 = CAUGHT_self_71 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_8;
		    if (symbol_0) {
		        final /*@NonInvalid*/ boolean symbol_1 = CAUGHT_b instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_3;
		        if (symbol_1) {
		            if (CAUGHT_self_71 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_self_71;
		            }
		            symbol_3 = (Boolean)CAUGHT_self_71;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_2;
		            if (CAUGHT_b == Boolean.TRUE) {
		                symbol_2 = ValuesUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_self_71 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_self_71;
		                }
		                symbol_2 = (Boolean)CAUGHT_self_71;
		            }
		            symbol_3 = symbol_2;
		        }
		        symbol_8 = symbol_3;
		    }
		    else {
		        if (CAUGHT_self_71 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_self_71;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_self_71 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_7;
		        if (eq) {
		            symbol_7 = ValuesUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_4 = CAUGHT_b instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_6;
		            if (symbol_4) {
		                if (CAUGHT_b instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b;
		                }
		                symbol_6 = (Boolean)CAUGHT_b;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_5;
		                if (CAUGHT_b == Boolean.TRUE) {
		                    symbol_5 = ValuesUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_5 = ValuesUtil.FALSE_VALUE;
		                }
		                symbol_6 = symbol_5;
		            }
		            symbol_7 = symbol_6;
		        }
		        symbol_8 = symbol_7;
		    }
		    CAUGHT_symbol_8 = symbol_8;
		}
		catch (Exception e) {
		    CAUGHT_symbol_8 = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_8 == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Variable", "CompatibleInitialiserType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.VARIABLE__COMPATIBLE_INITIALISER_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImplicit()
	{
		return (eFlags & IMPLICIT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicit(boolean newImplicit)
	{
		boolean oldImplicit = (eFlags & IMPLICIT_EFLAG) != 0;
		if (newImplicit) eFlags |= IMPLICIT_EFLAG; else eFlags &= ~IMPLICIT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.VARIABLE__IMPLICIT, oldImplicit, newImplicit));
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
			case PivotPackage.VARIABLE__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.VARIABLE__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.VARIABLE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.VARIABLE__INIT_EXPRESSION:
				return basicSetInitExpression(null, msgs);
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
			case PivotPackage.VARIABLE__EXTENSION:
				return getExtension();
			case PivotPackage.VARIABLE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.VARIABLE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.VARIABLE__IS_STATIC:
				return isStatic();
			case PivotPackage.VARIABLE__NAME:
				return getName();
			case PivotPackage.VARIABLE__IS_REQUIRED:
				return isRequired();
			case PivotPackage.VARIABLE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.VARIABLE__IMPLICIT:
				return isImplicit();
			case PivotPackage.VARIABLE__INIT_EXPRESSION:
				return getInitExpression();
			case PivotPackage.VARIABLE__REPRESENTED_PARAMETER:
				if (resolve) return getRepresentedParameter();
				return basicGetRepresentedParameter();
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
			case PivotPackage.VARIABLE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.VARIABLE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.VARIABLE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.VARIABLE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.VARIABLE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.VARIABLE__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.VARIABLE__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.VARIABLE__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.VARIABLE__INIT_EXPRESSION:
				setInitExpression((OCLExpression)newValue);
				return;
			case PivotPackage.VARIABLE__REPRESENTED_PARAMETER:
				setRepresentedParameter((Parameter)newValue);
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
			case PivotPackage.VARIABLE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.VARIABLE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.VARIABLE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.VARIABLE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.VARIABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.VARIABLE__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.VARIABLE__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.VARIABLE__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.VARIABLE__INIT_EXPRESSION:
				setInitExpression((OCLExpression)null);
				return;
			case PivotPackage.VARIABLE__REPRESENTED_PARAMETER:
				setRepresentedParameter((Parameter)null);
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
			case PivotPackage.VARIABLE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.VARIABLE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.VARIABLE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.VARIABLE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.VARIABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.VARIABLE__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.VARIABLE__TYPE:
				return type != null;
			case PivotPackage.VARIABLE__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.VARIABLE__INIT_EXPRESSION:
				return initExpression != null;
			case PivotPackage.VARIABLE__REPRESENTED_PARAMETER:
				return representedParameter != null;
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
			case PivotPackage.VARIABLE___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.VARIABLE___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleInitialiserType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return visitor.visitVariable(this);
	}
} //VariableImpl
