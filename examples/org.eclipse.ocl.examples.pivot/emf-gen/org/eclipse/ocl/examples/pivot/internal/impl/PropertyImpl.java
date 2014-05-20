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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getTemplateParameter <em>Template Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getOwningTemplateParameter <em>Owning Template Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getAssociationClass <em>Association Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getDefaultExpression <em>Default Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isImplicit <em>Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isID <em>Is ID</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isReadOnly <em>Is Read Only</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isResolveProxies <em>Is Resolve Proxies</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isUnsettable <em>Is Unsettable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isVolatile <em>Is Volatile</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getKeys <em>Keys</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getOwningType <em>Owning Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getRedefinedProperty <em>Redefined Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getSubsettedProperty <em>Subsetted Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("cast")
public class PropertyImpl
		extends FeatureImpl
		implements Property {

	/**
	 * The cached value of the '{@link #getTemplateParameter() <em>Template Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameter()
	 * @generated
	 * @ordered
	 */
	protected TemplateParameter templateParameter;

	/**
	 * The cached value of the '{@link #getAssociationClass() <em>Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationClass()
	 * @generated
	 * @ordered
	 */
	protected AssociationClass associationClass;

	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected String default_ = DEFAULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultExpression() <em>Default Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultExpression()
	 * @generated
	 * @ordered
	 */
	protected OpaqueExpression defaultExpression;

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
	 * The default value of the '{@link #isComposite() <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COMPOSITE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isComposite() <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposite()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_COMPOSITE_EFLAG = 1 << 11;

	/**
	 * The default value of the '{@link #isDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DERIVED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_DERIVED_EFLAG = 1 << 12;

	/**
	 * The default value of the '{@link #isID() <em>Is ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isID()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ID_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isID() <em>Is ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isID()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ID_EFLAG = 1 << 13;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Is Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_READ_ONLY_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isReadOnly() <em>Is Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_READ_ONLY_EFLAG = 1 << 14;

	/**
	 * The default value of the '{@link #isResolveProxies() <em>Is Resolve Proxies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolveProxies()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_RESOLVE_PROXIES_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isResolveProxies() <em>Is Resolve Proxies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolveProxies()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_RESOLVE_PROXIES_EFLAG = 1 << 15;

	/**
	 * The default value of the '{@link #isTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TRANSIENT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_TRANSIENT_EFLAG = 1 << 16;

	/**
	 * The default value of the '{@link #isUnsettable() <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnsettable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNSETTABLE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isUnsettable() <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnsettable()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_UNSETTABLE_EFLAG = 1 << 17;

	/**
	 * The default value of the '{@link #isVolatile() <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVolatile()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VOLATILE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isVolatile() <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVolatile()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_VOLATILE_EFLAG = 1 << 18;

	/**
	 * The cached value of the '{@link #getKeys() <em>Keys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> keys;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected Property opposite;

	/**
	 * The cached value of the '{@link #getRedefinedProperty() <em>Redefined Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinedProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> redefinedProperty;

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
	 * The cached value of the '{@link #getSubsettedProperty() <em>Subsetted Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsettedProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> subsettedProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyImpl() {
		super();
		eFlags |= IS_RESOLVE_PROXIES_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter getTemplateParameter() {
		if (templateParameter != null && ((EObject)templateParameter).eIsProxy())
		{
			InternalEObject oldTemplateParameter = (InternalEObject)templateParameter;
			templateParameter = (TemplateParameter)eResolveProxy(oldTemplateParameter);
			if (templateParameter != oldTemplateParameter)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PROPERTY__TEMPLATE_PARAMETER, oldTemplateParameter, templateParameter));
			}
		}
		return templateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter basicGetTemplateParameter() {
		return templateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplateParameter(
			TemplateParameter newTemplateParameter, NotificationChain msgs) {
		TemplateParameter oldTemplateParameter = templateParameter;
		templateParameter = newTemplateParameter;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__TEMPLATE_PARAMETER, oldTemplateParameter, newTemplateParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			TemplateParameter owningTemplateParameter = getOwningTemplateParameter();
			if (owningTemplateParameter != null && owningTemplateParameter != newTemplateParameter)
			{
				setOwningTemplateParameter(null);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateParameter(TemplateParameter newTemplateParameter) {
		if (newTemplateParameter != templateParameter)
		{
			NotificationChain msgs = null;
			if (templateParameter != null)
				msgs = ((InternalEObject)templateParameter).eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			if (newTemplateParameter != null)
				msgs = ((InternalEObject)newTemplateParameter).eInverseAdd(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			msgs = basicSetTemplateParameter(newTemplateParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__TEMPLATE_PARAMETER, newTemplateParameter, newTemplateParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter getOwningTemplateParameter() {
		if (eContainerFeatureID() != PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER) return null;
		return (TemplateParameter)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTemplateParameter(
			TemplateParameter newOwningTemplateParameter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTemplateParameter, PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER, msgs);
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newOwningTemplateParameter != null)
			{
				if (newOwningTemplateParameter != templateParameter)
				{
					setTemplateParameter(newOwningTemplateParameter);
				}
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningTemplateParameter(
			TemplateParameter newOwningTemplateParameter) {
		if (newOwningTemplateParameter != eInternalContainer() || (eContainerFeatureID() != PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER && newOwningTemplateParameter != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newOwningTemplateParameter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTemplateParameter != null)
				msgs = ((InternalEObject)newOwningTemplateParameter).eInverseAdd(this, PivotPackage.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			msgs = basicSetOwningTemplateParameter(newOwningTemplateParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER, newOwningTemplateParameter, newOwningTemplateParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass getAssociationClass()
	{
		if (associationClass != null && ((EObject)associationClass).eIsProxy())
		{
			InternalEObject oldAssociationClass = (InternalEObject)associationClass;
			associationClass = (AssociationClass)eResolveProxy(oldAssociationClass);
			if (associationClass != oldAssociationClass)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PROPERTY__ASSOCIATION_CLASS, oldAssociationClass, associationClass));
			}
		}
		return associationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass basicGetAssociationClass()
	{
		return associationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociationClass(AssociationClass newAssociationClass, NotificationChain msgs)
	{
		AssociationClass oldAssociationClass = associationClass;
		associationClass = newAssociationClass;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__ASSOCIATION_CLASS, oldAssociationClass, newAssociationClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociationClass(AssociationClass newAssociationClass)
	{
		if (newAssociationClass != associationClass)
		{
			NotificationChain msgs = null;
			if (associationClass != null)
				msgs = ((InternalEObject)associationClass).eInverseRemove(this, PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE, AssociationClass.class, msgs);
			if (newAssociationClass != null)
				msgs = ((InternalEObject)newAssociationClass).eInverseAdd(this, PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE, AssociationClass.class, msgs);
			msgs = basicSetAssociationClass(newAssociationClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__ASSOCIATION_CLASS, newAssociationClass, newAssociationClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return (eFlags & IS_READ_ONLY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsReadOnly(boolean newIsReadOnly) {
		boolean oldIsReadOnly = (eFlags & IS_READ_ONLY_EFLAG) != 0;
		if (newIsReadOnly) eFlags |= IS_READ_ONLY_EFLAG; else eFlags &= ~IS_READ_ONLY_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_READ_ONLY, oldIsReadOnly, newIsReadOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(String newDefault) {
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComposite() {
		return (eFlags & IS_COMPOSITE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsComposite(boolean newIsComposite) {
		boolean oldIsComposite = (eFlags & IS_COMPOSITE_EFLAG) != 0;
		if (newIsComposite) eFlags |= IS_COMPOSITE_EFLAG; else eFlags &= ~IS_COMPOSITE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_COMPOSITE, oldIsComposite, newIsComposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerived() {
		return (eFlags & IS_DERIVED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDerived(boolean newIsDerived) {
		boolean oldIsDerived = (eFlags & IS_DERIVED_EFLAG) != 0;
		if (newIsDerived) eFlags |= IS_DERIVED_EFLAG; else eFlags &= ~IS_DERIVED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_DERIVED, oldIsDerived, newIsDerived));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getOpposite() {
		if (opposite != null && ((EObject)opposite).eIsProxy())
		{
			InternalEObject oldOpposite = (InternalEObject)opposite;
			opposite = (Property)eResolveProxy(oldOpposite);
			if (opposite != oldOpposite)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PROPERTY__OPPOSITE, oldOpposite, opposite));
			}
		}
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(Property newOpposite) {
		Property oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__OPPOSITE, oldOpposite, opposite));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IMPLICIT, oldImplicit, newImplicit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueExpression getDefaultExpression()
	{
		return defaultExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultExpression(OpaqueExpression newDefaultExpression, NotificationChain msgs)
	{
		OpaqueExpression oldDefaultExpression = defaultExpression;
		defaultExpression = newDefaultExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__DEFAULT_EXPRESSION, oldDefaultExpression, newDefaultExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultExpression(OpaqueExpression newDefaultExpression)
	{
		if (newDefaultExpression != defaultExpression)
		{
			NotificationChain msgs = null;
			if (defaultExpression != null)
				msgs = ((InternalEObject)defaultExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.PROPERTY__DEFAULT_EXPRESSION, null, msgs);
			if (newDefaultExpression != null)
				msgs = ((InternalEObject)newDefaultExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.PROPERTY__DEFAULT_EXPRESSION, null, msgs);
			msgs = basicSetDefaultExpression(newDefaultExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__DEFAULT_EXPRESSION, newDefaultExpression, newDefaultExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isID()
	{
		return (eFlags & IS_ID_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsID(boolean newIsID)
	{
		boolean oldIsID = (eFlags & IS_ID_EFLAG) != 0;
		if (newIsID) eFlags |= IS_ID_EFLAG; else eFlags &= ~IS_ID_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_ID, oldIsID, newIsID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Property> getKeys()
	{
		if (keys == null)
		{
			keys = new EObjectResolvingEList<Property>(Property.class, this, PivotPackage.PROPERTY__KEYS);
		}
		return keys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResolveProxies()
	{
		return (eFlags & IS_RESOLVE_PROXIES_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsResolveProxies(boolean newIsResolveProxies)
	{
		boolean oldIsResolveProxies = (eFlags & IS_RESOLVE_PROXIES_EFLAG) != 0;
		if (newIsResolveProxies) eFlags |= IS_RESOLVE_PROXIES_EFLAG; else eFlags &= ~IS_RESOLVE_PROXIES_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_RESOLVE_PROXIES, oldIsResolveProxies, newIsResolveProxies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransient()
	{
		return (eFlags & IS_TRANSIENT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTransient(boolean newIsTransient)
	{
		boolean oldIsTransient = (eFlags & IS_TRANSIENT_EFLAG) != 0;
		if (newIsTransient) eFlags |= IS_TRANSIENT_EFLAG; else eFlags &= ~IS_TRANSIENT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_TRANSIENT, oldIsTransient, newIsTransient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnsettable()
	{
		return (eFlags & IS_UNSETTABLE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnsettable(boolean newIsUnsettable)
	{
		boolean oldIsUnsettable = (eFlags & IS_UNSETTABLE_EFLAG) != 0;
		if (newIsUnsettable) eFlags |= IS_UNSETTABLE_EFLAG; else eFlags &= ~IS_UNSETTABLE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_UNSETTABLE, oldIsUnsettable, newIsUnsettable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVolatile()
	{
		return (eFlags & IS_VOLATILE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsVolatile(boolean newIsVolatile)
	{
		boolean oldIsVolatile = (eFlags & IS_VOLATILE_EFLAG) != 0;
		if (newIsVolatile) eFlags |= IS_VOLATILE_EFLAG; else eFlags &= ~IS_VOLATILE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_VOLATILE, oldIsVolatile, newIsVolatile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Property> getRedefinedProperty()
	{
		if (redefinedProperty == null)
		{
			redefinedProperty = new EObjectResolvingEList<Property>(Property.class, this, PivotPackage.PROPERTY__REDEFINED_PROPERTY);
		}
		return redefinedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Property> getSubsettedProperty()
	{
		if (subsettedProperty == null)
		{
			subsettedProperty = new EObjectResolvingEList<Property>(Property.class, this, PivotPackage.PROPERTY__SUBSETTED_PROPERTY);
		}
		return subsettedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getReferredProperty()
	{
		if (referredProperty != null && ((EObject)referredProperty).eIsProxy())
		{
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PROPERTY__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty()
	{
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredProperty(Property newReferredProperty)
	{
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getOwningType()
	{
		if (eContainerFeatureID() != PivotPackage.PROPERTY__OWNING_TYPE) return null;
		return (Type)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningType(Type newOwningType, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningType, PivotPackage.PROPERTY__OWNING_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningType(Type newOwningType)
	{
		if (newOwningType != eInternalContainer() || (eContainerFeatureID() != PivotPackage.PROPERTY__OWNING_TYPE && newOwningType != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newOwningType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningType != null)
				msgs = ((InternalEObject)newOwningType).eInverseAdd(this, PivotPackage.TYPE__OWNED_ATTRIBUTE, Type.class, msgs);
			msgs = basicSetOwningType(newOwningType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__OWNING_TYPE, newOwningType, newOwningType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplateParameter() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!ParameterableElement!isTemplateParameter()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCompatibleWith(final ParameterableElement p)
	{
		/**
		 * p.oclIsKindOf(self.oclType())
		 */
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final @NonNull /*@Thrown*/ DomainType oclType = OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, this);
		final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, p, oclType).booleanValue();
		return oclIsKindOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAttribute(final Property p)
	{
		/**
		 * 
		 * let container : OclElement = oclContainer()
		 * in
		 *   container.oclIsKindOf(Type) and
		 *   container.oclAsType(Type)
		 *   .ownedAttribute->includes(self)
		 */
		@Nullable /*@Caught*/ Object CAUGHT_container;
		try {
		    final @Nullable /*@Thrown*/ Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(this);
		    CAUGHT_container = container;
		}
		catch (Exception e) {
		    CAUGHT_container = ValuesUtil.createInvalidValue(e);
		}
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object CAUGHT_self_71;
		try {
		    final @NonNull /*@NonInvalid*/ DomainType TYP_Type_0 = idResolver.getType(PivotTables.CLSSid_Type, null);
		    if (CAUGHT_container instanceof InvalidValueException) {
		        throw (InvalidValueException)CAUGHT_container;
		    }
		    final /*@Thrown*/ boolean self_71 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, CAUGHT_container, TYP_Type_0).booleanValue();
		    CAUGHT_self_71 = self_71;
		}
		catch (Exception e) {
		    CAUGHT_self_71 = ValuesUtil.createInvalidValue(e);
		}
		@NonNull /*@Caught*/ Object CAUGHT_b;
		try {
		    final @NonNull /*@NonInvalid*/ DomainType TYP_Type_1 = idResolver.getType(PivotTables.CLSSid_Type, null);
		    if (CAUGHT_container instanceof InvalidValueException) {
		        throw (InvalidValueException)CAUGHT_container;
		    }
		    final @Nullable /*@Thrown*/ DomainType oclAsType = (DomainType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CAUGHT_container, TYP_Type_1);
		    if (oclAsType == null) {
		        throw new InvalidValueException("Null source for \'pivot::Type::ownedAttribute\'");
		    }
		    final @NonNull /*@Thrown*/ List<? extends DomainProperty> ownedAttribute = oclAsType.getOwnedAttribute();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedAttribute = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Property, ownedAttribute);
		    final /*@Thrown*/ boolean b = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownedAttribute, this).booleanValue();
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
		        if (CAUGHT_b instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_b;
		        }
		        final /*@Thrown*/ boolean eq = CAUGHT_b == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_2;
		        if (eq) {
		            symbol_2 = ValuesUtil.FALSE_VALUE;
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
		    final /*@Thrown*/ boolean eq_0 = CAUGHT_self_71 == Boolean.FALSE;
		    /*@Thrown*/ boolean symbol_7;
		    if (eq_0) {
		        symbol_7 = ValuesUtil.FALSE_VALUE;
		    }
		    else {
		        if (CAUGHT_b instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_b;
		        }
		        final /*@NonInvalid*/ boolean symbol_4 = CAUGHT_b instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_6;
		        if (symbol_4) {
		            symbol_6 = (Boolean)CAUGHT_b;
		        }
		        else {
		            final /*@Thrown*/ boolean eq_1 = CAUGHT_b == Boolean.FALSE;
		            /*@NonInvalid*/ boolean symbol_5;
		            if (eq_1) {
		                symbol_5 = ValuesUtil.FALSE_VALUE;
		            }
		            else {
		                symbol_5 = ValuesUtil.TRUE_VALUE;
		            }
		            symbol_6 = symbol_5;
		        }
		        symbol_7 = symbol_6;
		    }
		    symbol_8 = symbol_7;
		}
		return symbol_8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompatibleDefaultExpression(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv CompatibleDefaultExpression: defaultExpression <> null and defaultExpression.oclIsKindOf(ExpressionInOCL) implies CompatibleBody(defaultExpression)
		 * 
		 * 
		 */
		@NonNull /*@Caught*/ Object CAUGHT_symbol_17;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_symbol_8;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_self_71;
		        try {
		            final @Nullable /*@Thrown*/ DomainExpression defaultExpression = this.getDefaultExpression();
		            final /*@Thrown*/ boolean self_71 = defaultExpression != null;
		            CAUGHT_self_71 = self_71;
		        }
		        catch (Exception e) {
		            CAUGHT_self_71 = ValuesUtil.createInvalidValue(e);
		        }
		        final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = PivotUtil.getEvaluator(this);
		        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		        @NonNull /*@Caught*/ Object CAUGHT_b;
		        try {
		            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_ExpressionInOCL_0 = idResolver.getType(PivotTables.CLSSid_ExpressionInOCL, null);
		            final @Nullable /*@Thrown*/ DomainExpression defaultExpression_0 = this.getDefaultExpression();
		            final /*@Thrown*/ boolean b = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, defaultExpression_0, TYP_pivot_c_c_ExpressionInOCL_0).booleanValue();
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
		                if (CAUGHT_b instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b;
		                }
		                final /*@Thrown*/ boolean eq = CAUGHT_b == Boolean.FALSE;
		                /*@Thrown*/ boolean symbol_2;
		                if (eq) {
		                    symbol_2 = ValuesUtil.FALSE_VALUE;
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
		            final /*@Thrown*/ boolean eq_0 = CAUGHT_self_71 == Boolean.FALSE;
		            /*@Thrown*/ boolean symbol_7;
		            if (eq_0) {
		                symbol_7 = ValuesUtil.FALSE_VALUE;
		            }
		            else {
		                if (CAUGHT_b instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b;
		                }
		                final /*@NonInvalid*/ boolean symbol_4 = CAUGHT_b instanceof InvalidValueException;
		                /*@Thrown*/ boolean symbol_6;
		                if (symbol_4) {
		                    symbol_6 = (Boolean)CAUGHT_b;
		                }
		                else {
		                    final /*@Thrown*/ boolean eq_1 = CAUGHT_b == Boolean.FALSE;
		                    /*@NonInvalid*/ boolean symbol_5;
		                    if (eq_1) {
		                        symbol_5 = ValuesUtil.FALSE_VALUE;
		                    }
		                    else {
		                        symbol_5 = ValuesUtil.TRUE_VALUE;
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
		    @NonNull /*@Caught*/ Object CAUGHT_b_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainExpression defaultExpression_1 = this.getDefaultExpression();
		        final /*@Thrown*/ boolean b_0 = ((TypedMultiplicityElement)this).CompatibleBody((ValueSpecification)defaultExpression_1);
		        CAUGHT_b_0 = b_0;
		    }
		    catch (Exception e) {
		        CAUGHT_b_0 = ValuesUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean symbol_9 = CAUGHT_symbol_8 instanceof InvalidValueException;
		    /*@Thrown*/ boolean symbol_17;
		    if (symbol_9) {
		        final /*@NonInvalid*/ boolean symbol_10 = CAUGHT_b_0 instanceof InvalidValueException;
		        /*@Thrown*/ boolean symbol_12;
		        if (symbol_10) {
		            if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		                throw (InvalidValueException)CAUGHT_symbol_8;
		            }
		            symbol_12 = (Boolean)CAUGHT_symbol_8;
		        }
		        else {
		            /*@Thrown*/ boolean symbol_11;
		            if (CAUGHT_b_0 == Boolean.TRUE) {
		                symbol_11 = ValuesUtil.TRUE_VALUE;
		            }
		            else {
		                if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_symbol_8;
		                }
		                symbol_11 = (Boolean)CAUGHT_symbol_8;
		            }
		            symbol_12 = symbol_11;
		        }
		        symbol_17 = symbol_12;
		    }
		    else {
		        if (CAUGHT_symbol_8 instanceof InvalidValueException) {
		            throw (InvalidValueException)CAUGHT_symbol_8;
		        }
		        final /*@Thrown*/ boolean eq_2 = CAUGHT_symbol_8 == Boolean.FALSE;
		        /*@Thrown*/ boolean symbol_16;
		        if (eq_2) {
		            symbol_16 = ValuesUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonInvalid*/ boolean symbol_13 = CAUGHT_b_0 instanceof InvalidValueException;
		            /*@Thrown*/ boolean symbol_15;
		            if (symbol_13) {
		                if (CAUGHT_b_0 instanceof InvalidValueException) {
		                    throw (InvalidValueException)CAUGHT_b_0;
		                }
		                symbol_15 = (Boolean)CAUGHT_b_0;
		            }
		            else {
		                /*@NonInvalid*/ boolean symbol_14;
		                if (CAUGHT_b_0 == Boolean.TRUE) {
		                    symbol_14 = ValuesUtil.TRUE_VALUE;
		                }
		                else {
		                    symbol_14 = ValuesUtil.FALSE_VALUE;
		                }
		                symbol_15 = symbol_14;
		            }
		            symbol_16 = symbol_15;
		        }
		        symbol_17 = symbol_16;
		    }
		    CAUGHT_symbol_17 = symbol_17;
		}
		catch (Exception e) {
		    CAUGHT_symbol_17 = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_symbol_17 == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Property", "CompatibleDefaultExpression", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.PROPERTY__COMPATIBLE_DEFAULT_EXPRESSION, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.PROPERTY__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				if (templateParameter != null)
					msgs = ((InternalEObject)templateParameter).eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				if (associationClass != null)
					msgs = ((InternalEObject)associationClass).eInverseRemove(this, PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE, AssociationClass.class, msgs);
				return basicSetAssociationClass((AssociationClass)otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNING_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningType((Type)otherEnd, msgs);
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
			case PivotPackage.PROPERTY__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				return basicSetAssociationClass(null, msgs);
			case PivotPackage.PROPERTY__DEFAULT_EXPRESSION:
				return basicSetDefaultExpression(null, msgs);
			case PivotPackage.PROPERTY__OWNING_TYPE:
				return basicSetOwningType(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			case PivotPackage.PROPERTY__OWNING_TYPE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TYPE__OWNED_ATTRIBUTE, Type.class, msgs);
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
			case PivotPackage.PROPERTY__EXTENSION:
				return getExtension();
			case PivotPackage.PROPERTY__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.PROPERTY__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.PROPERTY__IS_STATIC:
				return isStatic();
			case PivotPackage.PROPERTY__NAME:
				return getName();
			case PivotPackage.PROPERTY__IS_REQUIRED:
				return isRequired();
			case PivotPackage.PROPERTY__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.PROPERTY__IMPLEMENTATION:
				return getImplementation();
			case PivotPackage.PROPERTY__IMPLEMENTATION_CLASS:
				return getImplementationClass();
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				if (resolve) return getAssociationClass();
				return basicGetAssociationClass();
			case PivotPackage.PROPERTY__CLASS:
				return getClass_();
			case PivotPackage.PROPERTY__DEFAULT:
				return getDefault();
			case PivotPackage.PROPERTY__DEFAULT_EXPRESSION:
				return getDefaultExpression();
			case PivotPackage.PROPERTY__IMPLICIT:
				return isImplicit();
			case PivotPackage.PROPERTY__IS_COMPOSITE:
				return isComposite();
			case PivotPackage.PROPERTY__IS_DERIVED:
				return isDerived();
			case PivotPackage.PROPERTY__IS_ID:
				return isID();
			case PivotPackage.PROPERTY__IS_READ_ONLY:
				return isReadOnly();
			case PivotPackage.PROPERTY__IS_RESOLVE_PROXIES:
				return isResolveProxies();
			case PivotPackage.PROPERTY__IS_TRANSIENT:
				return isTransient();
			case PivotPackage.PROPERTY__IS_UNSETTABLE:
				return isUnsettable();
			case PivotPackage.PROPERTY__IS_VOLATILE:
				return isVolatile();
			case PivotPackage.PROPERTY__KEYS:
				return getKeys();
			case PivotPackage.PROPERTY__OPPOSITE:
				if (resolve) return getOpposite();
				return basicGetOpposite();
			case PivotPackage.PROPERTY__OWNING_TYPE:
				return getOwningType();
			case PivotPackage.PROPERTY__REDEFINED_PROPERTY:
				return getRedefinedProperty();
			case PivotPackage.PROPERTY__REFERRED_PROPERTY:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
			case PivotPackage.PROPERTY__SUBSETTED_PROPERTY:
				return getSubsettedProperty();
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
			case PivotPackage.PROPERTY__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.PROPERTY__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.PROPERTY__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PROPERTY__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.PROPERTY__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.PROPERTY__IMPLEMENTATION:
				setImplementation((LibraryFeature)newValue);
				return;
			case PivotPackage.PROPERTY__IMPLEMENTATION_CLASS:
				setImplementationClass((String)newValue);
				return;
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				setAssociationClass((AssociationClass)newValue);
				return;
			case PivotPackage.PROPERTY__DEFAULT:
				setDefault((String)newValue);
				return;
			case PivotPackage.PROPERTY__DEFAULT_EXPRESSION:
				setDefaultExpression((OpaqueExpression)newValue);
				return;
			case PivotPackage.PROPERTY__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_COMPOSITE:
				setIsComposite((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_DERIVED:
				setIsDerived((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_ID:
				setIsID((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_READ_ONLY:
				setIsReadOnly((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_RESOLVE_PROXIES:
				setIsResolveProxies((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_TRANSIENT:
				setIsTransient((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_UNSETTABLE:
				setIsUnsettable((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_VOLATILE:
				setIsVolatile((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__KEYS:
				getKeys().clear();
				getKeys().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.PROPERTY__OPPOSITE:
				setOpposite((Property)newValue);
				return;
			case PivotPackage.PROPERTY__OWNING_TYPE:
				setOwningType((Type)newValue);
				return;
			case PivotPackage.PROPERTY__REDEFINED_PROPERTY:
				getRedefinedProperty().clear();
				getRedefinedProperty().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.PROPERTY__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
				return;
			case PivotPackage.PROPERTY__SUBSETTED_PROPERTY:
				getSubsettedProperty().clear();
				getSubsettedProperty().addAll((Collection<? extends Property>)newValue);
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
			case PivotPackage.PROPERTY__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.PROPERTY__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.PROPERTY__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.PROPERTY__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.PROPERTY__IMPLEMENTATION:
				setImplementation(IMPLEMENTATION_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IMPLEMENTATION_CLASS:
				setImplementationClass(IMPLEMENTATION_CLASS_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				setAssociationClass((AssociationClass)null);
				return;
			case PivotPackage.PROPERTY__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__DEFAULT_EXPRESSION:
				setDefaultExpression((OpaqueExpression)null);
				return;
			case PivotPackage.PROPERTY__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_COMPOSITE:
				setIsComposite(IS_COMPOSITE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_DERIVED:
				setIsDerived(IS_DERIVED_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_ID:
				setIsID(IS_ID_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_READ_ONLY:
				setIsReadOnly(IS_READ_ONLY_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_RESOLVE_PROXIES:
				setIsResolveProxies(IS_RESOLVE_PROXIES_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_TRANSIENT:
				setIsTransient(IS_TRANSIENT_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_UNSETTABLE:
				setIsUnsettable(IS_UNSETTABLE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_VOLATILE:
				setIsVolatile(IS_VOLATILE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__KEYS:
				getKeys().clear();
				return;
			case PivotPackage.PROPERTY__OPPOSITE:
				setOpposite((Property)null);
				return;
			case PivotPackage.PROPERTY__OWNING_TYPE:
				setOwningType((Type)null);
				return;
			case PivotPackage.PROPERTY__REDEFINED_PROPERTY:
				getRedefinedProperty().clear();
				return;
			case PivotPackage.PROPERTY__REFERRED_PROPERTY:
				setReferredProperty((Property)null);
				return;
			case PivotPackage.PROPERTY__SUBSETTED_PROPERTY:
				getSubsettedProperty().clear();
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
			case PivotPackage.PROPERTY__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.PROPERTY__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.PROPERTY__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.PROPERTY__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.PROPERTY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PROPERTY__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.PROPERTY__TYPE:
				return type != null;
			case PivotPackage.PROPERTY__IMPLEMENTATION:
				return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
			case PivotPackage.PROPERTY__IMPLEMENTATION_CLASS:
				return IMPLEMENTATION_CLASS_EDEFAULT == null ? implementationClass != null : !IMPLEMENTATION_CLASS_EDEFAULT.equals(implementationClass);
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				return associationClass != null;
			case PivotPackage.PROPERTY__CLASS:
				return getClass_() != null;
			case PivotPackage.PROPERTY__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case PivotPackage.PROPERTY__DEFAULT_EXPRESSION:
				return defaultExpression != null;
			case PivotPackage.PROPERTY__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.PROPERTY__IS_COMPOSITE:
				return ((eFlags & IS_COMPOSITE_EFLAG) != 0) != IS_COMPOSITE_EDEFAULT;
			case PivotPackage.PROPERTY__IS_DERIVED:
				return ((eFlags & IS_DERIVED_EFLAG) != 0) != IS_DERIVED_EDEFAULT;
			case PivotPackage.PROPERTY__IS_ID:
				return ((eFlags & IS_ID_EFLAG) != 0) != IS_ID_EDEFAULT;
			case PivotPackage.PROPERTY__IS_READ_ONLY:
				return ((eFlags & IS_READ_ONLY_EFLAG) != 0) != IS_READ_ONLY_EDEFAULT;
			case PivotPackage.PROPERTY__IS_RESOLVE_PROXIES:
				return ((eFlags & IS_RESOLVE_PROXIES_EFLAG) != 0) != IS_RESOLVE_PROXIES_EDEFAULT;
			case PivotPackage.PROPERTY__IS_TRANSIENT:
				return ((eFlags & IS_TRANSIENT_EFLAG) != 0) != IS_TRANSIENT_EDEFAULT;
			case PivotPackage.PROPERTY__IS_UNSETTABLE:
				return ((eFlags & IS_UNSETTABLE_EFLAG) != 0) != IS_UNSETTABLE_EDEFAULT;
			case PivotPackage.PROPERTY__IS_VOLATILE:
				return ((eFlags & IS_VOLATILE_EFLAG) != 0) != IS_VOLATILE_EDEFAULT;
			case PivotPackage.PROPERTY__KEYS:
				return keys != null && !keys.isEmpty();
			case PivotPackage.PROPERTY__OPPOSITE:
				return opposite != null;
			case PivotPackage.PROPERTY__OWNING_TYPE:
				return getOwningType() != null;
			case PivotPackage.PROPERTY__REDEFINED_PROPERTY:
				return redefinedProperty != null && !redefinedProperty.isEmpty();
			case PivotPackage.PROPERTY__REFERRED_PROPERTY:
				return referredProperty != null;
			case PivotPackage.PROPERTY__SUBSETTED_PROPERTY:
				return subsettedProperty != null && !subsettedProperty.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ParameterableElement.class)
		{
			switch (derivedFeatureID)
			{
				case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER: return PivotPackage.PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER;
				case PivotPackage.PROPERTY__TEMPLATE_PARAMETER: return PivotPackage.PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER;
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ParameterableElement.class)
		{
			switch (baseFeatureID)
			{
				case PivotPackage.PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER: return PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER;
				case PivotPackage.PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER: return PivotPackage.PROPERTY__TEMPLATE_PARAMETER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ParameterableElement.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.PARAMETERABLE_ELEMENT___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT: return PivotPackage.PROPERTY___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;
				case PivotPackage.PARAMETERABLE_ELEMENT___IS_TEMPLATE_PARAMETER: return PivotPackage.PROPERTY___IS_TEMPLATE_PARAMETER;
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
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case PivotPackage.PROPERTY___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.PROPERTY___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.PROPERTY___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.PROPERTY___MAKE_PARAMETER:
				return makeParameter();
			case PivotPackage.PROPERTY___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT:
				return isCompatibleWith((ParameterableElement)arguments.get(0));
			case PivotPackage.PROPERTY___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case PivotPackage.PROPERTY___VALIDATE_COMPATIBLE_DEFAULT_EXPRESSION__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleDefaultExpression((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.PROPERTY___IS_ATTRIBUTE__PROPERTY:
				return isAttribute((Property)arguments.get(0));
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
		return visitor.visitProperty(this);
	}

	public org.eclipse.ocl.examples.pivot.Class getClass_() {
		EObject eContainer = eContainer();
		if (eContainer instanceof org.eclipse.ocl.examples.pivot.Class) {
			return (org.eclipse.ocl.examples.pivot.Class) eContainer;
		}
		else {
			return null;
		}
	}

	public @Nullable DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		Type owningType = getOwningType();
		if (owningType != null) {
			return standardLibrary.getInheritance(owningType);
		}
		else {
			return null;
		}
	}

	private PropertyId propertyId = null;
	
	public @NonNull PropertyId getPropertyId() {
		PropertyId propertyId2 = propertyId;
		if (propertyId2 == null) {
			synchronized (this) {
				propertyId2 = propertyId;
				if (propertyId2 == null) {
					String name = DomainUtil.nonNullModel(getName());
					TypeId typeId = getOwningType().getTypeId();
					propertyId = propertyId2 = typeId.getPropertyId(name);
				}
			}
		}
		return propertyId2;
	}

	public void initValue(@NonNull Object objectValue, @Nullable Object unboxedValue) {
		assert ValuesUtil.isUnboxed(unboxedValue);
		EObject eTarget = getETarget();
		if (eTarget instanceof EStructuralFeature) {
			EStructuralFeature eFeature = (EStructuralFeature) eTarget;
			EObject eObject = ValuesUtil.asNavigableObject(objectValue, eFeature);
			eObject.eSet(eFeature, unboxedValue);
			return;
		}
		throw new UnsupportedOperationException();
	}
} //PropertyImpl
