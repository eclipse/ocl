/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.Transition;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ConstraintImpl#getConstrainedElement <em>Constrained Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ConstraintImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ConstraintImpl#isCallable <em>Is Callable</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ConstraintImpl#getOwningState <em>Owning State</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ConstraintImpl#getPostContext <em>Post Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ConstraintImpl#getPreContext <em>Pre Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ConstraintImpl#getRedefinedConstraint <em>Redefined Constraint</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ConstraintImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.impl.ConstraintImpl#getTransition <em>Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl
		extends NamedElementImpl
		implements Constraint {

	/**
	 * The cached value of the '{@link #getConstrainedElement() <em>Constrained Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedElement()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> constrainedElement;

	/**
	 * The default value of the '{@link #isCallable() <em>Is Callable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCallable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CALLABLE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isCallable() <em>Is Callable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCallable()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_CALLABLE_EFLAG = 1 << 8;

	/**
	 * The cached value of the '{@link #getRedefinedConstraint() <em>Redefined Constraint</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinedConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> redefinedConstraint;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected LanguageExpression specification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Element> getConstrainedElement()
	{
		if (constrainedElement == null)
		{
			constrainedElement = new EObjectResolvingEList<Element>(Element.class, this, PivotPackage.CONSTRAINT__CONSTRAINED_ELEMENT);
		}
		return constrainedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LanguageExpression getSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification(LanguageExpression newSpecification, NotificationChain msgs)
	{
		LanguageExpression oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.CONSTRAINT__SPECIFICATION, oldSpecification, newSpecification);
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
	public void setSpecification(LanguageExpression newSpecification)
	{
		if (newSpecification != specification)
		{
			NotificationChain msgs = null;
			if (specification != null)
				msgs = ((InternalEObject)specification).eInverseRemove(this, PivotPackage.LANGUAGE_EXPRESSION__OWNING_CONSTRAINT, LanguageExpression.class, msgs);
			if (newSpecification != null)
				msgs = ((InternalEObject)newSpecification).eInverseAdd(this, PivotPackage.LANGUAGE_EXPRESSION__OWNING_CONSTRAINT, LanguageExpression.class, msgs);
			msgs = basicSetSpecification(newSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.CONSTRAINT__SPECIFICATION, newSpecification, newSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transition getTransition()
	{
		if (eContainerFeatureID() != PivotPackage.CONSTRAINT__TRANSITION) return null;
		return (Transition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransition(Transition newTransition, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newTransition, PivotPackage.CONSTRAINT__TRANSITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransition(Transition newTransition)
	{
		if (newTransition != eInternalContainer() || (eContainerFeatureID() != PivotPackage.CONSTRAINT__TRANSITION && newTransition != null))
		{
			if (EcoreUtil.isAncestor(this, newTransition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransition != null)
				msgs = ((InternalEObject)newTransition).eInverseAdd(this, PivotPackage.TRANSITION__GUARD, Transition.class, msgs);
			msgs = basicSetTransition(newTransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.CONSTRAINT__TRANSITION, newTransition, newTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCallable()
	{
		return (eFlags & IS_CALLABLE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsCallable(boolean newIsCallable)
	{
		boolean oldIsCallable = (eFlags & IS_CALLABLE_EFLAG) != 0;
		if (newIsCallable) eFlags |= IS_CALLABLE_EFLAG; else eFlags &= ~IS_CALLABLE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.CONSTRAINT__IS_CALLABLE, oldIsCallable, newIsCallable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public State getOwningState()
	{
		if (eContainerFeatureID() != PivotPackage.CONSTRAINT__OWNING_STATE) return null;
		return (State)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningState(State newOwningState, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningState, PivotPackage.CONSTRAINT__OWNING_STATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningState(State newOwningState)
	{
		if (newOwningState != eInternalContainer() || (eContainerFeatureID() != PivotPackage.CONSTRAINT__OWNING_STATE && newOwningState != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningState))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningState != null)
				msgs = ((InternalEObject)newOwningState).eInverseAdd(this, PivotPackage.STATE__STATE_INVARIANT, State.class, msgs);
			msgs = basicSetOwningState(newOwningState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.CONSTRAINT__OWNING_STATE, newOwningState, newOwningState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getPostContext()
	{
		if (eContainerFeatureID() != PivotPackage.CONSTRAINT__POST_CONTEXT) return null;
		return (Operation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostContext(Operation newPostContext, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newPostContext, PivotPackage.CONSTRAINT__POST_CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPostContext(Operation newPostContext)
	{
		if (newPostContext != eInternalContainer() || (eContainerFeatureID() != PivotPackage.CONSTRAINT__POST_CONTEXT && newPostContext != null))
		{
			if (EcoreUtil.isAncestor(this, newPostContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPostContext != null)
				msgs = ((InternalEObject)newPostContext).eInverseAdd(this, PivotPackage.OPERATION__POSTCONDITION, Operation.class, msgs);
			msgs = basicSetPostContext(newPostContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.CONSTRAINT__POST_CONTEXT, newPostContext, newPostContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getPreContext()
	{
		if (eContainerFeatureID() != PivotPackage.CONSTRAINT__PRE_CONTEXT) return null;
		return (Operation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreContext(Operation newPreContext, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newPreContext, PivotPackage.CONSTRAINT__PRE_CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPreContext(Operation newPreContext)
	{
		if (newPreContext != eInternalContainer() || (eContainerFeatureID() != PivotPackage.CONSTRAINT__PRE_CONTEXT && newPreContext != null))
		{
			if (EcoreUtil.isAncestor(this, newPreContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPreContext != null)
				msgs = ((InternalEObject)newPreContext).eInverseAdd(this, PivotPackage.OPERATION__PRECONDITION, Operation.class, msgs);
			msgs = basicSetPreContext(newPreContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.CONSTRAINT__PRE_CONTEXT, newPreContext, newPreContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Constraint> getRedefinedConstraint()
	{
		if (redefinedConstraint == null)
		{
			redefinedConstraint = new EObjectResolvingEList<Constraint>(Constraint.class, this, PivotPackage.CONSTRAINT__REDEFINED_CONSTRAINT);
		}
		return redefinedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateUniqueName(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv UniqueName: true
		 */
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.CONSTRAINT__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.CONSTRAINT__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.CONSTRAINT__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.CONSTRAINT__OWNING_STATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningState((State)otherEnd, msgs);
			case PivotPackage.CONSTRAINT__POST_CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPostContext((Operation)otherEnd, msgs);
			case PivotPackage.CONSTRAINT__PRE_CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPreContext((Operation)otherEnd, msgs);
			case PivotPackage.CONSTRAINT__SPECIFICATION:
				if (specification != null)
					msgs = ((InternalEObject)specification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.CONSTRAINT__SPECIFICATION, null, msgs);
				return basicSetSpecification((LanguageExpression)otherEnd, msgs);
			case PivotPackage.CONSTRAINT__TRANSITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTransition((Transition)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
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
			case PivotPackage.CONSTRAINT__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.CONSTRAINT__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.CONSTRAINT__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.CONSTRAINT__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.CONSTRAINT__OWNING_STATE:
				return basicSetOwningState(null, msgs);
			case PivotPackage.CONSTRAINT__POST_CONTEXT:
				return basicSetPostContext(null, msgs);
			case PivotPackage.CONSTRAINT__PRE_CONTEXT:
				return basicSetPreContext(null, msgs);
			case PivotPackage.CONSTRAINT__SPECIFICATION:
				return basicSetSpecification(null, msgs);
			case PivotPackage.CONSTRAINT__TRANSITION:
				return basicSetTransition(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case PivotPackage.CONSTRAINT__OWNING_STATE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.STATE__STATE_INVARIANT, State.class, msgs);
			case PivotPackage.CONSTRAINT__POST_CONTEXT:
				return eInternalContainer().eInverseRemove(this, PivotPackage.OPERATION__POSTCONDITION, Operation.class, msgs);
			case PivotPackage.CONSTRAINT__PRE_CONTEXT:
				return eInternalContainer().eInverseRemove(this, PivotPackage.OPERATION__PRECONDITION, Operation.class, msgs);
			case PivotPackage.CONSTRAINT__TRANSITION:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TRANSITION__GUARD, Transition.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
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
			case PivotPackage.CONSTRAINT__COMMENT:
				return getComment();
			case PivotPackage.CONSTRAINT__EXTENSION:
				return getExtension();
			case PivotPackage.CONSTRAINT__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.CONSTRAINT__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.CONSTRAINT__NAME:
				return getName();
			case PivotPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
				return getConstrainedElement();
			case PivotPackage.CONSTRAINT__CONTEXT:
				return getContext();
			case PivotPackage.CONSTRAINT__IS_CALLABLE:
				return isCallable();
			case PivotPackage.CONSTRAINT__OWNING_STATE:
				return getOwningState();
			case PivotPackage.CONSTRAINT__POST_CONTEXT:
				return getPostContext();
			case PivotPackage.CONSTRAINT__PRE_CONTEXT:
				return getPreContext();
			case PivotPackage.CONSTRAINT__REDEFINED_CONSTRAINT:
				return getRedefinedConstraint();
			case PivotPackage.CONSTRAINT__SPECIFICATION:
				return getSpecification();
			case PivotPackage.CONSTRAINT__TRANSITION:
				return getTransition();
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
			case PivotPackage.CONSTRAINT__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.CONSTRAINT__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.CONSTRAINT__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.CONSTRAINT__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.CONSTRAINT__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
				getConstrainedElement().clear();
				getConstrainedElement().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.CONSTRAINT__IS_CALLABLE:
				setIsCallable((Boolean)newValue);
				return;
			case PivotPackage.CONSTRAINT__OWNING_STATE:
				setOwningState((State)newValue);
				return;
			case PivotPackage.CONSTRAINT__POST_CONTEXT:
				setPostContext((Operation)newValue);
				return;
			case PivotPackage.CONSTRAINT__PRE_CONTEXT:
				setPreContext((Operation)newValue);
				return;
			case PivotPackage.CONSTRAINT__REDEFINED_CONSTRAINT:
				getRedefinedConstraint().clear();
				getRedefinedConstraint().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.CONSTRAINT__SPECIFICATION:
				setSpecification((LanguageExpression)newValue);
				return;
			case PivotPackage.CONSTRAINT__TRANSITION:
				setTransition((Transition)newValue);
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
			case PivotPackage.CONSTRAINT__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.CONSTRAINT__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.CONSTRAINT__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.CONSTRAINT__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.CONSTRAINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
				getConstrainedElement().clear();
				return;
			case PivotPackage.CONSTRAINT__IS_CALLABLE:
				setIsCallable(IS_CALLABLE_EDEFAULT);
				return;
			case PivotPackage.CONSTRAINT__OWNING_STATE:
				setOwningState((State)null);
				return;
			case PivotPackage.CONSTRAINT__POST_CONTEXT:
				setPostContext((Operation)null);
				return;
			case PivotPackage.CONSTRAINT__PRE_CONTEXT:
				setPreContext((Operation)null);
				return;
			case PivotPackage.CONSTRAINT__REDEFINED_CONSTRAINT:
				getRedefinedConstraint().clear();
				return;
			case PivotPackage.CONSTRAINT__SPECIFICATION:
				setSpecification((LanguageExpression)null);
				return;
			case PivotPackage.CONSTRAINT__TRANSITION:
				setTransition((Transition)null);
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
			case PivotPackage.CONSTRAINT__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.CONSTRAINT__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.CONSTRAINT__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.CONSTRAINT__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.CONSTRAINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
				return constrainedElement != null && !constrainedElement.isEmpty();
			case PivotPackage.CONSTRAINT__CONTEXT:
				return getContext() != null;
			case PivotPackage.CONSTRAINT__IS_CALLABLE:
				return ((eFlags & IS_CALLABLE_EFLAG) != 0) != IS_CALLABLE_EDEFAULT;
			case PivotPackage.CONSTRAINT__OWNING_STATE:
				return getOwningState() != null;
			case PivotPackage.CONSTRAINT__POST_CONTEXT:
				return getPostContext() != null;
			case PivotPackage.CONSTRAINT__PRE_CONTEXT:
				return getPreContext() != null;
			case PivotPackage.CONSTRAINT__REDEFINED_CONSTRAINT:
				return redefinedConstraint != null && !redefinedConstraint.isEmpty();
			case PivotPackage.CONSTRAINT__SPECIFICATION:
				return specification != null;
			case PivotPackage.CONSTRAINT__TRANSITION:
				return getTransition() != null;
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
			case PivotPackage.CONSTRAINT___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.CONSTRAINT___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.CONSTRAINT___VALIDATE_UNIQUE_NAME__DIAGNOSTICCHAIN_MAP:
				return validateUniqueName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitConstraint(this);
	}

	@Override
	public Namespace getContext() {
		for (EObject context = eContainer(); context != null; context = context.eContainer()) {
			if (context instanceof Namespace) {
				return (Namespace) context;
			}
		}
		return null;
	}

	public boolean isSetContext() {
		return getContext() != null;
	}


	@Override
	public String toString()
	{
		return super.toString();
	}
} //ConstraintImpl
