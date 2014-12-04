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
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.ConnectionPointReference;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Pseudostate;
import org.eclipse.ocl.examples.pivot.Region;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateMachine;
import org.eclipse.ocl.examples.pivot.Transition;
import org.eclipse.ocl.examples.pivot.Trigger;
import org.eclipse.ocl.examples.pivot.Vertex;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getConnectionPoint <em>Connection Point</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getDeferrableTrigger <em>Deferrable Trigger</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getDoActivity <em>Do Activity</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getExit <em>Exit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#isComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#isOrthogonal <em>Is Orthogonal</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#isSimple <em>Is Simple</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#isSubmachineState <em>Is Submachine State</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getRedefinedState <em>Redefined State</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getStateInvariant <em>State Invariant</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateImpl#getSubmachine <em>Submachine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl
		extends NamespaceImpl
		implements State {

	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> incoming;
	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outgoing;
	/**
	 * The cached value of the '{@link #getConnection() <em>Connection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnection()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionPointReference> connection;
	/**
	 * The cached value of the '{@link #getConnectionPoint() <em>Connection Point</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionPoint()
	 * @generated
	 * @ordered
	 */
	protected EList<Pseudostate> connectionPoint;
	/**
	 * The cached value of the '{@link #getDeferrableTrigger() <em>Deferrable Trigger</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeferrableTrigger()
	 * @generated
	 * @ordered
	 */
	protected EList<Trigger> deferrableTrigger;
	/**
	 * The cached value of the '{@link #getDoActivity() <em>Do Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoActivity()
	 * @generated
	 * @ordered
	 */
	protected Behavior doActivity;
	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected Behavior entry;
	/**
	 * The cached value of the '{@link #getExit() <em>Exit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExit()
	 * @generated
	 * @ordered
	 */
	protected Behavior exit;
	/**
	 * The default value of the '{@link #isComposite() <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COMPOSITE_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isOrthogonal() <em>Is Orthogonal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrthogonal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORTHOGONAL_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isSimple() <em>Is Simple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSimple()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SIMPLE_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isSubmachineState() <em>Is Submachine State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSubmachineState()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SUBMACHINE_STATE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #getRedefinedState() <em>Redefined State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinedState()
	 * @generated
	 * @ordered
	 */
	protected State redefinedState;
	/**
	 * The cached value of the '{@link #getRegion() <em>Region</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected EList<Region> region;
	/**
	 * The cached value of the '{@link #getStateInvariant() <em>State Invariant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateInvariant()
	 * @generated
	 * @ordered
	 */
	protected Constraint stateInvariant;
	/**
	 * The cached value of the '{@link #getSubmachine() <em>Submachine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubmachine()
	 * @generated
	 * @ordered
	 */
	protected StateMachine submachine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Region getContainer()
	{
		if (eContainerFeatureID() != PivotPackage.STATE__CONTAINER) return null;
		return (Region)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(Region newContainer, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newContainer, PivotPackage.STATE__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContainer(Region newContainer)
	{
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != PivotPackage.STATE__CONTAINER && newContainer != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, PivotPackage.REGION__SUBVERTEX, Region.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Transition> getIncoming()
	{
		if (incoming == null)
		{
			incoming = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, PivotPackage.STATE__INCOMING, PivotPackage.TRANSITION__TARGET);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Transition> getOutgoing()
	{
		if (outgoing == null)
		{
			outgoing = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, PivotPackage.STATE__OUTGOING, PivotPackage.TRANSITION__SOURCE);
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isComposite()
	{
		return getRegion().size() > 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isOrthogonal()
	{
		return getRegion().size() > 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isSimple()
	{
		return getRegion().size() == 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isSubmachineState()
	{
		return eContainer() instanceof StateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateMachine getSubmachine()
	{
		if (submachine != null && ((EObject)submachine).eIsProxy())
		{
			InternalEObject oldSubmachine = (InternalEObject)submachine;
			submachine = (StateMachine)eResolveProxy(oldSubmachine);
			if (submachine != oldSubmachine)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.STATE__SUBMACHINE, oldSubmachine, submachine));
			}
		}
		return submachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine basicGetSubmachine()
	{
		return submachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubmachine(StateMachine newSubmachine, NotificationChain msgs)
	{
		StateMachine oldSubmachine = submachine;
		submachine = newSubmachine;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__SUBMACHINE, oldSubmachine, newSubmachine);
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
	public void setSubmachine(StateMachine newSubmachine)
	{
		if (newSubmachine != submachine)
		{
			NotificationChain msgs = null;
			if (submachine != null)
				msgs = ((InternalEObject)submachine).eInverseRemove(this, PivotPackage.STATE_MACHINE__SUBMACHINE_STATE, StateMachine.class, msgs);
			if (newSubmachine != null)
				msgs = ((InternalEObject)newSubmachine).eInverseAdd(this, PivotPackage.STATE_MACHINE__SUBMACHINE_STATE, StateMachine.class, msgs);
			msgs = basicSetSubmachine(newSubmachine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__SUBMACHINE, newSubmachine, newSubmachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ConnectionPointReference> getConnection()
	{
		if (connection == null)
		{
			connection = new EObjectContainmentWithInverseEList<ConnectionPointReference>(ConnectionPointReference.class, this, PivotPackage.STATE__CONNECTION, PivotPackage.CONNECTION_POINT_REFERENCE__STATE);
		}
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public State getRedefinedState()
	{
		if (redefinedState != null && ((EObject)redefinedState).eIsProxy())
		{
			InternalEObject oldRedefinedState = (InternalEObject)redefinedState;
			redefinedState = (State)eResolveProxy(oldRedefinedState);
			if (redefinedState != oldRedefinedState)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.STATE__REDEFINED_STATE, oldRedefinedState, redefinedState));
			}
		}
		return redefinedState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetRedefinedState()
	{
		return redefinedState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRedefinedState(State newRedefinedState)
	{
		State oldRedefinedState = redefinedState;
		redefinedState = newRedefinedState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__REDEFINED_STATE, oldRedefinedState, redefinedState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Region> getRegion()
	{
		if (region == null)
		{
			region = new EObjectContainmentWithInverseEList<Region>(Region.class, this, PivotPackage.STATE__REGION, PivotPackage.REGION__STATE);
		}
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Constraint getStateInvariant()
	{
		return stateInvariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateInvariant(Constraint newStateInvariant, NotificationChain msgs)
	{
		Constraint oldStateInvariant = stateInvariant;
		stateInvariant = newStateInvariant;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__STATE_INVARIANT, oldStateInvariant, newStateInvariant);
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
	public void setStateInvariant(Constraint newStateInvariant)
	{
		if (newStateInvariant != stateInvariant)
		{
			NotificationChain msgs = null;
			if (stateInvariant != null)
				msgs = ((InternalEObject)stateInvariant).eInverseRemove(this, PivotPackage.CONSTRAINT__OWNING_STATE, Constraint.class, msgs);
			if (newStateInvariant != null)
				msgs = ((InternalEObject)newStateInvariant).eInverseAdd(this, PivotPackage.CONSTRAINT__OWNING_STATE, Constraint.class, msgs);
			msgs = basicSetStateInvariant(newStateInvariant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__STATE_INVARIANT, newStateInvariant, newStateInvariant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Behavior getEntry()
	{
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntry(Behavior newEntry, NotificationChain msgs)
	{
		Behavior oldEntry = entry;
		entry = newEntry;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__ENTRY, oldEntry, newEntry);
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
	public void setEntry(Behavior newEntry)
	{
		if (newEntry != entry)
		{
			NotificationChain msgs = null;
			if (entry != null)
				msgs = ((InternalEObject)entry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.STATE__ENTRY, null, msgs);
			if (newEntry != null)
				msgs = ((InternalEObject)newEntry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.STATE__ENTRY, null, msgs);
			msgs = basicSetEntry(newEntry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__ENTRY, newEntry, newEntry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Behavior getExit()
	{
		return exit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExit(Behavior newExit, NotificationChain msgs)
	{
		Behavior oldExit = exit;
		exit = newExit;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__EXIT, oldExit, newExit);
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
	public void setExit(Behavior newExit)
	{
		if (newExit != exit)
		{
			NotificationChain msgs = null;
			if (exit != null)
				msgs = ((InternalEObject)exit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.STATE__EXIT, null, msgs);
			if (newExit != null)
				msgs = ((InternalEObject)newExit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.STATE__EXIT, null, msgs);
			msgs = basicSetExit(newExit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__EXIT, newExit, newExit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Behavior getDoActivity()
	{
		return doActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDoActivity(Behavior newDoActivity, NotificationChain msgs)
	{
		Behavior oldDoActivity = doActivity;
		doActivity = newDoActivity;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__DO_ACTIVITY, oldDoActivity, newDoActivity);
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
	public void setDoActivity(Behavior newDoActivity)
	{
		if (newDoActivity != doActivity)
		{
			NotificationChain msgs = null;
			if (doActivity != null)
				msgs = ((InternalEObject)doActivity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.STATE__DO_ACTIVITY, null, msgs);
			if (newDoActivity != null)
				msgs = ((InternalEObject)newDoActivity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.STATE__DO_ACTIVITY, null, msgs);
			msgs = basicSetDoActivity(newDoActivity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.STATE__DO_ACTIVITY, newDoActivity, newDoActivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Pseudostate> getConnectionPoint()
	{
		if (connectionPoint == null)
		{
			connectionPoint = new EObjectContainmentWithInverseEList<Pseudostate>(Pseudostate.class, this, PivotPackage.STATE__CONNECTION_POINT, PivotPackage.PSEUDOSTATE__STATE);
		}
		return connectionPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Trigger> getDeferrableTrigger()
	{
		if (deferrableTrigger == null)
		{
			deferrableTrigger = new EObjectContainmentWithInverseEList<Trigger>(Trigger.class, this, PivotPackage.STATE__DEFERRABLE_TRIGGER, PivotPackage.TRIGGER__STATE);
		}
		return deferrableTrigger;
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
			case PivotPackage.STATE__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.STATE__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.STATE__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.STATE__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((Region)otherEnd, msgs);
			case PivotPackage.STATE__INCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
			case PivotPackage.STATE__OUTGOING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
			case PivotPackage.STATE__CONNECTION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnection()).basicAdd(otherEnd, msgs);
			case PivotPackage.STATE__CONNECTION_POINT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectionPoint()).basicAdd(otherEnd, msgs);
			case PivotPackage.STATE__DEFERRABLE_TRIGGER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeferrableTrigger()).basicAdd(otherEnd, msgs);
			case PivotPackage.STATE__REGION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRegion()).basicAdd(otherEnd, msgs);
			case PivotPackage.STATE__STATE_INVARIANT:
				if (stateInvariant != null)
					msgs = ((InternalEObject)stateInvariant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.STATE__STATE_INVARIANT, null, msgs);
				return basicSetStateInvariant((Constraint)otherEnd, msgs);
			case PivotPackage.STATE__SUBMACHINE:
				if (submachine != null)
					msgs = ((InternalEObject)submachine).eInverseRemove(this, PivotPackage.STATE_MACHINE__SUBMACHINE_STATE, StateMachine.class, msgs);
				return basicSetSubmachine((StateMachine)otherEnd, msgs);
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
			case PivotPackage.STATE__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.STATE__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.STATE__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.STATE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.STATE__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.STATE__CONTAINER:
				return basicSetContainer(null, msgs);
			case PivotPackage.STATE__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case PivotPackage.STATE__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case PivotPackage.STATE__CONNECTION:
				return ((InternalEList<?>)getConnection()).basicRemove(otherEnd, msgs);
			case PivotPackage.STATE__CONNECTION_POINT:
				return ((InternalEList<?>)getConnectionPoint()).basicRemove(otherEnd, msgs);
			case PivotPackage.STATE__DEFERRABLE_TRIGGER:
				return ((InternalEList<?>)getDeferrableTrigger()).basicRemove(otherEnd, msgs);
			case PivotPackage.STATE__DO_ACTIVITY:
				return basicSetDoActivity(null, msgs);
			case PivotPackage.STATE__ENTRY:
				return basicSetEntry(null, msgs);
			case PivotPackage.STATE__EXIT:
				return basicSetExit(null, msgs);
			case PivotPackage.STATE__REGION:
				return ((InternalEList<?>)getRegion()).basicRemove(otherEnd, msgs);
			case PivotPackage.STATE__STATE_INVARIANT:
				return basicSetStateInvariant(null, msgs);
			case PivotPackage.STATE__SUBMACHINE:
				return basicSetSubmachine(null, msgs);
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
			case PivotPackage.STATE__CONTAINER:
				return eInternalContainer().eInverseRemove(this, PivotPackage.REGION__SUBVERTEX, Region.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
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
			case PivotPackage.STATE__COMMENT:
				return getComment();
			case PivotPackage.STATE__EXTENSION:
				return getExtension();
			case PivotPackage.STATE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.STATE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.STATE__NAME:
				return getName();
			case PivotPackage.STATE__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.STATE__CONTAINER:
				return getContainer();
			case PivotPackage.STATE__INCOMING:
				return getIncoming();
			case PivotPackage.STATE__OUTGOING:
				return getOutgoing();
			case PivotPackage.STATE__CONNECTION:
				return getConnection();
			case PivotPackage.STATE__CONNECTION_POINT:
				return getConnectionPoint();
			case PivotPackage.STATE__DEFERRABLE_TRIGGER:
				return getDeferrableTrigger();
			case PivotPackage.STATE__DO_ACTIVITY:
				return getDoActivity();
			case PivotPackage.STATE__ENTRY:
				return getEntry();
			case PivotPackage.STATE__EXIT:
				return getExit();
			case PivotPackage.STATE__IS_COMPOSITE:
				return isComposite();
			case PivotPackage.STATE__IS_ORTHOGONAL:
				return isOrthogonal();
			case PivotPackage.STATE__IS_SIMPLE:
				return isSimple();
			case PivotPackage.STATE__IS_SUBMACHINE_STATE:
				return isSubmachineState();
			case PivotPackage.STATE__REDEFINED_STATE:
				if (resolve) return getRedefinedState();
				return basicGetRedefinedState();
			case PivotPackage.STATE__REGION:
				return getRegion();
			case PivotPackage.STATE__STATE_INVARIANT:
				return getStateInvariant();
			case PivotPackage.STATE__SUBMACHINE:
				if (resolve) return getSubmachine();
				return basicGetSubmachine();
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
			case PivotPackage.STATE__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.STATE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.STATE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.STATE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.STATE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.STATE__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.STATE__CONTAINER:
				setContainer((Region)newValue);
				return;
			case PivotPackage.STATE__CONNECTION:
				getConnection().clear();
				getConnection().addAll((Collection<? extends ConnectionPointReference>)newValue);
				return;
			case PivotPackage.STATE__CONNECTION_POINT:
				getConnectionPoint().clear();
				getConnectionPoint().addAll((Collection<? extends Pseudostate>)newValue);
				return;
			case PivotPackage.STATE__DEFERRABLE_TRIGGER:
				getDeferrableTrigger().clear();
				getDeferrableTrigger().addAll((Collection<? extends Trigger>)newValue);
				return;
			case PivotPackage.STATE__DO_ACTIVITY:
				setDoActivity((Behavior)newValue);
				return;
			case PivotPackage.STATE__ENTRY:
				setEntry((Behavior)newValue);
				return;
			case PivotPackage.STATE__EXIT:
				setExit((Behavior)newValue);
				return;
			case PivotPackage.STATE__REDEFINED_STATE:
				setRedefinedState((State)newValue);
				return;
			case PivotPackage.STATE__REGION:
				getRegion().clear();
				getRegion().addAll((Collection<? extends Region>)newValue);
				return;
			case PivotPackage.STATE__STATE_INVARIANT:
				setStateInvariant((Constraint)newValue);
				return;
			case PivotPackage.STATE__SUBMACHINE:
				setSubmachine((StateMachine)newValue);
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
			case PivotPackage.STATE__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.STATE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.STATE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.STATE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.STATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.STATE__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.STATE__CONTAINER:
				setContainer((Region)null);
				return;
			case PivotPackage.STATE__CONNECTION:
				getConnection().clear();
				return;
			case PivotPackage.STATE__CONNECTION_POINT:
				getConnectionPoint().clear();
				return;
			case PivotPackage.STATE__DEFERRABLE_TRIGGER:
				getDeferrableTrigger().clear();
				return;
			case PivotPackage.STATE__DO_ACTIVITY:
				setDoActivity((Behavior)null);
				return;
			case PivotPackage.STATE__ENTRY:
				setEntry((Behavior)null);
				return;
			case PivotPackage.STATE__EXIT:
				setExit((Behavior)null);
				return;
			case PivotPackage.STATE__REDEFINED_STATE:
				setRedefinedState((State)null);
				return;
			case PivotPackage.STATE__REGION:
				getRegion().clear();
				return;
			case PivotPackage.STATE__STATE_INVARIANT:
				setStateInvariant((Constraint)null);
				return;
			case PivotPackage.STATE__SUBMACHINE:
				setSubmachine((StateMachine)null);
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
			case PivotPackage.STATE__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.STATE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.STATE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.STATE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.STATE__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.STATE__CONTAINER:
				return getContainer() != null;
			case PivotPackage.STATE__INCOMING:
				return incoming != null && !incoming.isEmpty();
			case PivotPackage.STATE__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case PivotPackage.STATE__CONNECTION:
				return connection != null && !connection.isEmpty();
			case PivotPackage.STATE__CONNECTION_POINT:
				return connectionPoint != null && !connectionPoint.isEmpty();
			case PivotPackage.STATE__DEFERRABLE_TRIGGER:
				return deferrableTrigger != null && !deferrableTrigger.isEmpty();
			case PivotPackage.STATE__DO_ACTIVITY:
				return doActivity != null;
			case PivotPackage.STATE__ENTRY:
				return entry != null;
			case PivotPackage.STATE__EXIT:
				return exit != null;
			case PivotPackage.STATE__IS_COMPOSITE:
				return isComposite() != IS_COMPOSITE_EDEFAULT;
			case PivotPackage.STATE__IS_ORTHOGONAL:
				return isOrthogonal() != IS_ORTHOGONAL_EDEFAULT;
			case PivotPackage.STATE__IS_SIMPLE:
				return isSimple() != IS_SIMPLE_EDEFAULT;
			case PivotPackage.STATE__IS_SUBMACHINE_STATE:
				return isSubmachineState() != IS_SUBMACHINE_STATE_EDEFAULT;
			case PivotPackage.STATE__REDEFINED_STATE:
				return redefinedState != null;
			case PivotPackage.STATE__REGION:
				return region != null && !region.isEmpty();
			case PivotPackage.STATE__STATE_INVARIANT:
				return stateInvariant != null;
			case PivotPackage.STATE__SUBMACHINE:
				return submachine != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == Vertex.class)
		{
			switch (derivedFeatureID)
			{
				case PivotPackage.STATE__CONTAINER: return PivotPackage.VERTEX__CONTAINER;
				case PivotPackage.STATE__INCOMING: return PivotPackage.VERTEX__INCOMING;
				case PivotPackage.STATE__OUTGOING: return PivotPackage.VERTEX__OUTGOING;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == Vertex.class)
		{
			switch (baseFeatureID)
			{
				case PivotPackage.VERTEX__CONTAINER: return PivotPackage.STATE__CONTAINER;
				case PivotPackage.VERTEX__INCOMING: return PivotPackage.STATE__INCOMING;
				case PivotPackage.VERTEX__OUTGOING: return PivotPackage.STATE__OUTGOING;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitState(this);
	}
} //StateImpl
