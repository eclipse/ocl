/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Pseudostate;
import org.eclipse.ocl.examples.pivot.PseudostateKind;
import org.eclipse.ocl.examples.pivot.Region;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateMachine;
import org.eclipse.ocl.examples.pivot.Transition;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pseudostate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PseudostateImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PseudostateImpl#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PseudostateImpl#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PseudostateImpl extends VertexImpl implements Pseudostate
{
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final PseudostateKind KIND_EDEFAULT = PseudostateKind.INITIAL;

	/**
	 * The offset of the flags representing the value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG_OFFSET = 9;

	/**
	 * The flags representing the default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG_DEFAULT = KIND_EDEFAULT.ordinal() << KIND_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link PseudostateKind Pseudostate Kind}'
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final PseudostateKind[] KIND_EFLAG_VALUES = PseudostateKind.values();

	/**
	 * The flags representing the value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG = 0xf << KIND_EFLAG_OFFSET;

	/**
	 * The cached value of the '{@link #getStateMachine() <em>State Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachine()
	 * @generated
	 * @ordered
	 */
	protected StateMachine stateMachine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PseudostateImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.PSEUDOSTATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PseudostateKind getKind()
	{
		return KIND_EFLAG_VALUES[(eFlags & KIND_EFLAG) >>> KIND_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(PseudostateKind newKind)
	{
		PseudostateKind oldKind = KIND_EFLAG_VALUES[(eFlags & KIND_EFLAG) >>> KIND_EFLAG_OFFSET];
		if (newKind == null) newKind = KIND_EDEFAULT;
		eFlags = eFlags & ~KIND_EFLAG | newKind.ordinal() << KIND_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PSEUDOSTATE__KIND, oldKind, newKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getStateMachine()
	{
		if (stateMachine != null && ((EObject)stateMachine).eIsProxy())
		{
			InternalEObject oldStateMachine = (InternalEObject)stateMachine;
			stateMachine = (StateMachine)eResolveProxy(oldStateMachine);
			if (stateMachine != oldStateMachine)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PSEUDOSTATE__STATE_MACHINE, oldStateMachine, stateMachine));
			}
		}
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine basicGetStateMachine()
	{
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateMachine(StateMachine newStateMachine)
	{
		StateMachine oldStateMachine = stateMachine;
		stateMachine = newStateMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PSEUDOSTATE__STATE_MACHINE, oldStateMachine, stateMachine));
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
			case PivotPackage.PSEUDOSTATE__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.PSEUDOSTATE__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((Region)otherEnd, msgs);
			case PivotPackage.PSEUDOSTATE__INCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
			case PivotPackage.PSEUDOSTATE__OUTGOING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
			case PivotPackage.PSEUDOSTATE__STATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetState((State)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.PSEUDOSTATE__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.PSEUDOSTATE__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.PSEUDOSTATE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.PSEUDOSTATE__CONTAINER:
				return basicSetContainer(null, msgs);
			case PivotPackage.PSEUDOSTATE__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case PivotPackage.PSEUDOSTATE__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case PivotPackage.PSEUDOSTATE__STATE:
				return basicSetState(null, msgs);
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
			case PivotPackage.PSEUDOSTATE__CONTAINER:
				return eInternalContainer().eInverseRemove(this, PivotPackage.REGION__SUBVERTEX, Region.class, msgs);
			case PivotPackage.PSEUDOSTATE__STATE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.STATE__CONNECTION_POINT, State.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getState()
	{
		if (eContainerFeatureID() != PivotPackage.PSEUDOSTATE__STATE) return null;
		return (State)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetState(State newState, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newState, PivotPackage.PSEUDOSTATE__STATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("cast")
	public void setState(State newState)
	{
		if (newState != eInternalContainer() || (eContainerFeatureID() != PivotPackage.PSEUDOSTATE__STATE && newState != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newState))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newState != null)
				msgs = ((InternalEObject)newState).eInverseAdd(this, PivotPackage.STATE__CONNECTION_POINT, State.class, msgs);
			msgs = basicSetState(newState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PSEUDOSTATE__STATE, newState, newState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case PivotPackage.PSEUDOSTATE__EXTENSION:
				return getExtension();
			case PivotPackage.PSEUDOSTATE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.PSEUDOSTATE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.PSEUDOSTATE__IS_STATIC:
				return isStatic();
			case PivotPackage.PSEUDOSTATE__NAME:
				return getName();
			case PivotPackage.PSEUDOSTATE__CONTAINER:
				return getContainer();
			case PivotPackage.PSEUDOSTATE__INCOMING:
				return getIncoming();
			case PivotPackage.PSEUDOSTATE__OUTGOING:
				return getOutgoing();
			case PivotPackage.PSEUDOSTATE__KIND:
				return getKind();
			case PivotPackage.PSEUDOSTATE__STATE:
				return getState();
			case PivotPackage.PSEUDOSTATE__STATE_MACHINE:
				if (resolve) return getStateMachine();
				return basicGetStateMachine();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PivotPackage.PSEUDOSTATE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.PSEUDOSTATE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.PSEUDOSTATE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PSEUDOSTATE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.PSEUDOSTATE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.PSEUDOSTATE__CONTAINER:
				setContainer((Region)newValue);
				return;
			case PivotPackage.PSEUDOSTATE__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends Transition>)newValue);
				return;
			case PivotPackage.PSEUDOSTATE__OUTGOING:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends Transition>)newValue);
				return;
			case PivotPackage.PSEUDOSTATE__KIND:
				setKind((PseudostateKind)newValue);
				return;
			case PivotPackage.PSEUDOSTATE__STATE:
				setState((State)newValue);
				return;
			case PivotPackage.PSEUDOSTATE__STATE_MACHINE:
				setStateMachine((StateMachine)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.PSEUDOSTATE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.PSEUDOSTATE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.PSEUDOSTATE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.PSEUDOSTATE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.PSEUDOSTATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.PSEUDOSTATE__CONTAINER:
				setContainer((Region)null);
				return;
			case PivotPackage.PSEUDOSTATE__INCOMING:
				getIncoming().clear();
				return;
			case PivotPackage.PSEUDOSTATE__OUTGOING:
				getOutgoing().clear();
				return;
			case PivotPackage.PSEUDOSTATE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case PivotPackage.PSEUDOSTATE__STATE:
				setState((State)null);
				return;
			case PivotPackage.PSEUDOSTATE__STATE_MACHINE:
				setStateMachine((StateMachine)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.PSEUDOSTATE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.PSEUDOSTATE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.PSEUDOSTATE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.PSEUDOSTATE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.PSEUDOSTATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PSEUDOSTATE__CONTAINER:
				return getContainer() != null;
			case PivotPackage.PSEUDOSTATE__INCOMING:
				return incoming != null && !incoming.isEmpty();
			case PivotPackage.PSEUDOSTATE__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case PivotPackage.PSEUDOSTATE__KIND:
				return (eFlags & KIND_EFLAG) != KIND_EFLAG_DEFAULT;
			case PivotPackage.PSEUDOSTATE__STATE:
				return getState() != null;
			case PivotPackage.PSEUDOSTATE__STATE_MACHINE:
				return stateMachine != null;
		}
		return eDynamicIsSet(featureID);
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
		return visitor.visitPseudostate(this);
	}
} //PseudostateImpl
