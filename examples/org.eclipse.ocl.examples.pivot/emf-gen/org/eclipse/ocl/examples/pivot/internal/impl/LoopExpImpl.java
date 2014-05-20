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
import java.util.Collections;
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
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LoopExpImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LoopExpImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LoopExpImpl#getReferredIteration <em>Referred Iteration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LoopExpImpl
		extends CallExpImpl
		implements LoopExp {

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression body;

	/**
	 * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterator()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> iterator;

	/**
	 * The cached value of the '{@link #getReferredIteration() <em>Referred Iteration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredIteration()
	 * @generated
	 * @ordered
	 */
	protected Iteration referredIteration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.LOOP_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(OCLExpression newBody,
			NotificationChain msgs) {
		OCLExpression oldBody = body;
		body = newBody;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.LOOP_EXP__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(OCLExpression newBody) {
		if (newBody != body)
		{
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.LOOP_EXP__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.LOOP_EXP__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.LOOP_EXP__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<Variable> getIterator()
	{
		if (iterator == null)
		{
			iterator = new EObjectContainmentEList<Variable>(Variable.class, this, PivotPackage.LOOP_EXP__ITERATOR);
		}
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iteration getReferredIteration()
	{
		if (referredIteration != null && ((EObject)referredIteration).eIsProxy())
		{
			InternalEObject oldReferredIteration = (InternalEObject)referredIteration;
			referredIteration = (Iteration)eResolveProxy(oldReferredIteration);
			if (referredIteration != oldReferredIteration)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.LOOP_EXP__REFERRED_ITERATION, oldReferredIteration, referredIteration));
			}
		}
		return referredIteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iteration basicGetReferredIteration()
	{
		return referredIteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredIteration(Iteration newReferredIteration)
	{
		Iteration oldReferredIteration = referredIteration;
		referredIteration = newReferredIteration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.LOOP_EXP__REFERRED_ITERATION, oldReferredIteration, referredIteration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceIsCollection(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv SourceIsCollection: source.type.oclIsKindOf (CollectionType)
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		try {
		    final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType_0 = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		    final @Nullable /*@Thrown*/ DomainExpression source = this.getSource();
		    if (source == null) {
		        throw new InvalidValueException("Null source for \'pivot::TypedElement::type\'");
		    }
		    final @Nullable /*@Thrown*/ DomainType type = source.getType();
		    final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_CollectionType_0).booleanValue();
		    CAUGHT_oclIsKindOf = oclIsKindOf;
		}
		catch (Exception e) {
		    CAUGHT_oclIsKindOf = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_oclIsKindOf == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"LoopExp", "SourceIsCollection", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.LOOP_EXP__SOURCE_IS_COLLECTION, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNoInitializers(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv NoInitializers: self.iterator->forAll(initExpression->isEmpty())
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object CAUGHT_forAll;
		try {
		    final @NonNull /*@Thrown*/ List<Variable> iterator = this.getIterator();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		    @NonNull /*@Thrown*/ Object accumulator = ValuesUtil.TRUE_VALUE;
		    @Nullable Iterator<?> ITERATOR__1 = BOXED_iterator.iterator();
		    /*@Thrown*/ boolean forAll;
		    while (true) {
		        if (!ITERATOR__1.hasNext()) {
		            if (accumulator == ValuesUtil.TRUE_VALUE) {
		                forAll = (Boolean)accumulator;
		            }
		            else {
		                throw (InvalidValueException)accumulator;
		            }
		            break;
		        }
		        @Nullable /*@NonInvalid*/ Variable _1 = (Variable)ITERATOR__1.next();
		        /**
		         * initExpression->isEmpty()
		         */
		        @NonNull /*@Caught*/ Object CAUGHT_isEmpty;
		        try {
		            if (_1 == null) {
		                throw new InvalidValueException("Null source for \'pivot::Variable::initExpression\'");
		            }
		            final @Nullable /*@Thrown*/ DomainExpression initExpression = _1.getInitExpression();
		            final @NonNull /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, PivotTables.SET_CLSSid_OCLExpression, initExpression);
		            final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(oclAsSet).booleanValue();
		            CAUGHT_isEmpty = isEmpty;
		        }
		        catch (Exception e) {
		            CAUGHT_isEmpty = ValuesUtil.createInvalidValue(e);
		        }
		        //
		        if (CAUGHT_isEmpty == ValuesUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
		            forAll = ValuesUtil.FALSE_VALUE;
		            break;														// Stop immediately 
		        }
		        else if (CAUGHT_isEmpty == ValuesUtil.TRUE_VALUE) {				// Normal successful body evaluation result
		            ;															// Carry on
		        }
		        else if (CAUGHT_isEmpty instanceof InvalidValueException) {		// Abnormal exception evaluation result
		            accumulator = CAUGHT_isEmpty;									// Cache an exception failure
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
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"LoopExp", "NoInitializers", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.LOOP_EXP__NO_INITIALIZERS, message, new Object [] { this }));
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
			case PivotPackage.LOOP_EXP__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.LOOP_EXP__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.LOOP_EXP__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.LOOP_EXP__SOURCE:
				return basicSetSource(null, msgs);
			case PivotPackage.LOOP_EXP__BODY:
				return basicSetBody(null, msgs);
			case PivotPackage.LOOP_EXP__ITERATOR:
				return ((InternalEList<?>)getIterator()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.LOOP_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.LOOP_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.LOOP_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.LOOP_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.LOOP_EXP__NAME:
				return getName();
			case PivotPackage.LOOP_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.LOOP_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.LOOP_EXP__IMPLICIT:
				return isImplicit();
			case PivotPackage.LOOP_EXP__SOURCE:
				return getSource();
			case PivotPackage.LOOP_EXP__BODY:
				return getBody();
			case PivotPackage.LOOP_EXP__ITERATOR:
				return getIterator();
			case PivotPackage.LOOP_EXP__REFERRED_ITERATION:
				if (resolve) return getReferredIteration();
				return basicGetReferredIteration();
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
			case PivotPackage.LOOP_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.LOOP_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.LOOP_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.LOOP_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.LOOP_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.LOOP_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.LOOP_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.LOOP_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.LOOP_EXP__SOURCE:
				setSource((OCLExpression)newValue);
				return;
			case PivotPackage.LOOP_EXP__BODY:
				setBody((OCLExpression)newValue);
				return;
			case PivotPackage.LOOP_EXP__ITERATOR:
				getIterator().clear();
				getIterator().addAll((Collection<? extends Variable>)newValue);
				return;
			case PivotPackage.LOOP_EXP__REFERRED_ITERATION:
				setReferredIteration((Iteration)newValue);
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
			case PivotPackage.LOOP_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.LOOP_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.LOOP_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.LOOP_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.LOOP_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.LOOP_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.LOOP_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.LOOP_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.LOOP_EXP__SOURCE:
				setSource((OCLExpression)null);
				return;
			case PivotPackage.LOOP_EXP__BODY:
				setBody((OCLExpression)null);
				return;
			case PivotPackage.LOOP_EXP__ITERATOR:
				getIterator().clear();
				return;
			case PivotPackage.LOOP_EXP__REFERRED_ITERATION:
				setReferredIteration((Iteration)null);
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
			case PivotPackage.LOOP_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.LOOP_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.LOOP_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.LOOP_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.LOOP_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.LOOP_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.LOOP_EXP__TYPE:
				return type != null;
			case PivotPackage.LOOP_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.LOOP_EXP__SOURCE:
				return source != null;
			case PivotPackage.LOOP_EXP__BODY:
				return body != null;
			case PivotPackage.LOOP_EXP__ITERATOR:
				return iterator != null && !iterator.isEmpty();
			case PivotPackage.LOOP_EXP__REFERRED_ITERATION:
				return referredIteration != null;
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
			case PivotPackage.LOOP_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.LOOP_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.LOOP_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP:
				return validateNoInitializers((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.LOOP_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP:
				return validateSourceIsCollection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitLoopExp(this);
	}

	@SuppressWarnings({"null", "unchecked"})
	public @NonNull List<? extends DomainExpression> getArgument() {
		return Collections.EMPTY_LIST;
	}
} //LoopExpImpl
