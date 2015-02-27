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
package org.eclipse.ocl.pivot.internal;

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
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.ocl.pivot.AssociationClass;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.PivotValidator;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getAssociationClass <em>Association Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getDefaultValueString <em>Default Value String</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isID <em>Is ID</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isImplicit <em>Is Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isReadOnly <em>Is Read Only</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isResolveProxies <em>Is Resolve Proxies</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isUnsettable <em>Is Unsettable</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isVolatile <em>Is Volatile</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getKeys <em>Keys</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getRedefinedProperties <em>Redefined Properties</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getSubsettedProperty <em>Subsetted Property</em>}</li>
 * </ul>
 *
 * @generated
 */
@SuppressWarnings("cast")
public class PropertyImpl
		extends FeatureImpl
		implements Property {

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
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected Object defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultValueString() <em>Default Value String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValueString()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValueString() <em>Default Value String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValueString()
	 * @generated
	 * @ordered
	 */
	protected String defaultValueString = DEFAULT_VALUE_STRING_EDEFAULT;

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
	protected static final int IS_COMPOSITE_EFLAG = 1 << 10;

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
	protected static final int IS_DERIVED_EFLAG = 1 << 11;

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
	protected static final int IS_ID_EFLAG = 1 << 12;

	/**
	 * The default value of the '{@link #isImplicit() <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_IMPLICIT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isImplicit() <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_IMPLICIT_EFLAG = 1 << 13;

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
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected LanguageExpression ownedExpression;

	/**
	 * The cached value of the '{@link #getRedefinedProperties() <em>Redefined Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> redefinedProperties;

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
	@Override
	public AssociationClass getAssociationClass()
	{
		if (associationClass != null && associationClass.eIsProxy())
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
	@Override
	public void setAssociationClass(AssociationClass newAssociationClass)
	{
		if (newAssociationClass != associationClass)
		{
			NotificationChain msgs = null;
			if (associationClass != null)
				msgs = ((InternalEObject)associationClass).eInverseRemove(this, PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTES, AssociationClass.class, msgs);
			if (newAssociationClass != null)
				msgs = ((InternalEObject)newAssociationClass).eInverseAdd(this, PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTES, AssociationClass.class, msgs);
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
	@Override
	public boolean isReadOnly() {
		return (eFlags & IS_READ_ONLY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public boolean isComposite() {
		return (eFlags & IS_COMPOSITE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public boolean isDerived() {
		return (eFlags & IS_DERIVED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public Property getOpposite() {
		if (opposite != null && opposite.eIsProxy())
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
	@Override
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
	@Override
	public LanguageExpression getOwnedExpression()
	{
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(LanguageExpression newOwnedExpression, NotificationChain msgs)
	{
		LanguageExpression oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__OWNED_EXPRESSION, oldOwnedExpression, newOwnedExpression);
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
	public void setOwnedExpression(LanguageExpression newOwnedExpression)
	{
		if (newOwnedExpression != ownedExpression)
		{
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.PROPERTY__OWNED_EXPRESSION, null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.PROPERTY__OWNED_EXPRESSION, null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__OWNED_EXPRESSION, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isImplicit()
	{
		return (eFlags & IS_IMPLICIT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsImplicit(boolean newIsImplicit)
	{
		boolean oldIsImplicit = (eFlags & IS_IMPLICIT_EFLAG) != 0;
		if (newIsImplicit) eFlags |= IS_IMPLICIT_EFLAG; else eFlags &= ~IS_IMPLICIT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_IMPLICIT, oldIsImplicit, newIsImplicit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getDefaultValue()
	{
		String defaultValueString2 = defaultValueString;
		if ((defaultValue == null) && (defaultValueString2 != null)) {
			TypeId typeId = getTypeId();
			if (typeId instanceof EnumerationId) {
				defaultValue = NameUtil.getNameable(((Enumeration)type).getOwnedLiterals(), defaultValueString2);
				if (defaultValue == null) {
					throw new IllegalStateException("Unknown enumeration literal'" + defaultValueString2 + "' for '" + typeId + "'");
				}
			}
			else if (typeId == TypeId.BOOLEAN) {
				defaultValue = Boolean.valueOf(defaultValueString2);
			}
			else if (typeId == TypeId.STRING) {
				defaultValue = (String)defaultValueString2;
			}
			else if (typeId == TypeId.REAL) {
				defaultValue = ValueUtil.realValueOf(defaultValueString2);
			}
			else if (typeId == TypeId.INTEGER) {
				defaultValue = ValueUtil.integerValueOf(defaultValueString2);
			}
			else if (typeId == TypeId.UNLIMITED_NATURAL) {
				defaultValue = ValueUtil.unlimitedNaturalValueOf(defaultValueString2);
			}
			else {
				defaultValue = null;		// FIXME ?? caller's responsibility to help by providing a ResourceSet etc.
			}
		}
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setDefaultValue(Object newDefaultValue)
	{
		Object oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (newDefaultValue != oldDefaultValue) {
			String newDefaultValueString = null;
			if (newDefaultValue instanceof String) {
				newDefaultValueString = (String)newDefaultValue;
			}
			else if (newDefaultValue instanceof Boolean) {
				newDefaultValueString = newDefaultValue.toString();
			}
			else if (newDefaultValue instanceof Value) {
				newDefaultValueString = newDefaultValue.toString();
			}
			else if (newDefaultValue instanceof EnumerationLiteral) {
				newDefaultValueString = ((EnumerationLiteral)newDefaultValue).getName();
			}
			else if (newDefaultValue instanceof EObject) {
				URI uri = EcoreUtil.getURI((EObject)newDefaultValue);
				if (uri != null) {
					newDefaultValueString = uri.toString(); 		// FIXME resolve to parent base URI
				}
			}
			else {
				newDefaultValueString = newDefaultValue.toString();	
			}
			setDefaultValueStringGen(newDefaultValueString);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultValueString()
	{
		return defaultValueString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValueStringGen(String newDefaultValueString)
	{
		String oldDefaultValueString = defaultValueString;
		defaultValueString = newDefaultValueString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__DEFAULT_VALUE_STRING, oldDefaultValueString, defaultValueString));
	}
	@Override
	public void setDefaultValueString(String newDefaultValueString)
	{
		String oldDefaultValueString = defaultValueString;
		setDefaultValueStringGen(newDefaultValueString);
		if ((oldDefaultValueString != defaultValueString) && ((oldDefaultValueString == null) || !oldDefaultValueString.equals(defaultValueString))) {
			defaultValue = null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isID()
	{
		return (eFlags & IS_ID_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
	public boolean isResolveProxies()
	{
		return (eFlags & IS_RESOLVE_PROXIES_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public boolean isTransient()
	{
		return (eFlags & IS_TRANSIENT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public boolean isUnsettable()
	{
		return (eFlags & IS_UNSETTABLE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public boolean isVolatile()
	{
		return (eFlags & IS_VOLATILE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
	public Property getReferredProperty()
	{
		if (referredProperty != null && referredProperty.eIsProxy())
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
	@Override
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
	@Override
	public boolean isAttribute(final Property p)
	{
		/**
		 * 
		 * let container : OclElement = oclContainer()
		 * in
		 *   container.oclIsKindOf(Class) and
		 *   container.oclAsType(Class)
		 *   .ownedProperties->includes(self)
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		@Nullable /*@Caught*/ Object CAUGHT_container;
		try {
		    final @Nullable /*@Thrown*/ Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		    CAUGHT_container = container;
		}
		catch (Exception e) {
		    CAUGHT_container = ValueUtil.createInvalidValue(e);
		}
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		try {
		    final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Class_0 = idResolver.getClass(PivotTables.CLSSid_Class, null);
		    if (CAUGHT_container instanceof InvalidValueException) {
		        throw (InvalidValueException)CAUGHT_container;
		    }
		    final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, CAUGHT_container, TYP_Class_0).booleanValue();
		    CAUGHT_oclIsKindOf = oclIsKindOf;
		}
		catch (Exception e) {
		    CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		}
		@NonNull /*@Caught*/ Object CAUGHT_includes;
		try {
		    final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_Class_1 = idResolver.getClass(PivotTables.CLSSid_Class, null);
		    if (CAUGHT_container instanceof InvalidValueException) {
		        throw (InvalidValueException)CAUGHT_container;
		    }
		    final @Nullable /*@Thrown*/ org.eclipse.ocl.pivot.Class oclAsType = (org.eclipse.ocl.pivot.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CAUGHT_container, TYP_Class_1);
		    if (oclAsType == null) {
		        throw new InvalidValueException("Null source for \'pivot::Class::ownedProperties\'");
		    }
		    final @NonNull /*@Thrown*/ List<Property> ownedProperties = oclAsType.getOwnedProperties();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedProperties = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Property, ownedProperties);
		    final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownedProperties, this).booleanValue();
		    CAUGHT_includes = includes;
		}
		catch (Exception e) {
		    CAUGHT_includes = ValueUtil.createInvalidValue(e);
		}
		final @Nullable /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf, CAUGHT_includes);
		if (and == null) {
		    throw new InvalidValueException("Null body for \'pivot::Property::isAttribute(pivot::Property) : Boolean\'");
		}
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleDefaultExpression(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv CompatibleDefaultExpression: ownedExpression <> null and
		 *   ownedExpression.oclAsType(ExpressionInOCL).ownedBody <> null implies
		 *   CompatibleBody(ownedExpression)
		 */
		final @NonNull /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @Nullable /*@Caught*/ Object CAUGHT_and;
		    try {
		        @NonNull /*@Caught*/ Object CAUGHT_ne;
		        try {
		            final @Nullable /*@Thrown*/ LanguageExpression ownedExpression = this.getOwnedExpression();
		            final /*@Thrown*/ boolean ne = ownedExpression != null;
		            CAUGHT_ne = ne;
		        }
		        catch (Exception e) {
		            CAUGHT_ne = ValueUtil.createInvalidValue(e);
		        }
		        @NonNull /*@Caught*/ Object CAUGHT_ne_0;
		        try {
		            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pivot_c_c_ExpressionInOCL_0 = idResolver.getClass(PivotTables.CLSSid_ExpressionInOCL, null);
		            final @Nullable /*@Thrown*/ LanguageExpression ownedExpression_0 = this.getOwnedExpression();
		            final @Nullable /*@Thrown*/ ExpressionInOCL oclAsType = (ExpressionInOCL)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ownedExpression_0, TYP_pivot_c_c_ExpressionInOCL_0);
		            if (oclAsType == null) {
		                throw new InvalidValueException("Null source for \'pivot::ExpressionInOCL::ownedBody\'");
		            }
		            final @Nullable /*@Thrown*/ OCLExpression ownedBody = oclAsType.getOwnedBody();
		            final /*@Thrown*/ boolean ne_0 = ownedBody != null;
		            CAUGHT_ne_0 = ne_0;
		        }
		        catch (Exception e) {
		            CAUGHT_ne_0 = ValueUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_ne, CAUGHT_ne_0);
		        CAUGHT_and = and;
		    }
		    catch (Exception e) {
		        CAUGHT_and = ValueUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_CompatibleBody;
		    try {
		        final @Nullable /*@Thrown*/ LanguageExpression ownedExpression_1 = this.getOwnedExpression();
		        final /*@Thrown*/ boolean CompatibleBody = this.CompatibleBody((ValueSpecification)ownedExpression_1);
		        CAUGHT_CompatibleBody = CompatibleBody;
		    }
		    catch (Exception e) {
		        CAUGHT_CompatibleBody = ValueUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_and, CAUGHT_CompatibleBody);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValueUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = StringUtil.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Property", "CompatibleDefaultExpression", EObjectValidator.getObjectLabel(this, context)});
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
			case PivotPackage.PROPERTY__ANNOTATING_COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotatingComments()).basicAdd(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNED_COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComments()).basicAdd(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNED_EXTENSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedExtensions()).basicAdd(otherEnd, msgs);
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				if (associationClass != null)
					msgs = ((InternalEObject)associationClass).eInverseRemove(this, PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTES, AssociationClass.class, msgs);
				return basicSetAssociationClass((AssociationClass)otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNING_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningClass((org.eclipse.ocl.pivot.Class)otherEnd, msgs);
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
			case PivotPackage.PROPERTY__ANNOTATING_COMMENTS:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNED_ANNOTATIONS:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNED_COMMENTS:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNED_EXTENSIONS:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				return basicSetAssociationClass(null, msgs);
			case PivotPackage.PROPERTY__OWNED_EXPRESSION:
				return basicSetOwnedExpression(null, msgs);
			case PivotPackage.PROPERTY__OWNING_CLASS:
				return basicSetOwningClass(null, msgs);
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
			case PivotPackage.PROPERTY__OWNING_CLASS:
				return eInternalContainer().eInverseRemove(this, PivotPackage.CLASS__OWNED_PROPERTIES, org.eclipse.ocl.pivot.Class.class, msgs);
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
			case PivotPackage.PROPERTY__ANNOTATING_COMMENTS:
				return getAnnotatingComments();
			case PivotPackage.PROPERTY__OWNED_ANNOTATIONS:
				return getOwnedAnnotations();
			case PivotPackage.PROPERTY__OWNED_COMMENTS:
				return getOwnedComments();
			case PivotPackage.PROPERTY__OWNED_EXTENSIONS:
				return getOwnedExtensions();
			case PivotPackage.PROPERTY__NAME:
				return getName();
			case PivotPackage.PROPERTY__IS_MANY:
				return isMany();
			case PivotPackage.PROPERTY__IS_REQUIRED:
				return isRequired();
			case PivotPackage.PROPERTY__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.PROPERTY__IMPLEMENTATION:
				return getImplementation();
			case PivotPackage.PROPERTY__IMPLEMENTATION_CLASS:
				return getImplementationClass();
			case PivotPackage.PROPERTY__IS_STATIC:
				return isStatic();
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				if (resolve) return getAssociationClass();
				return basicGetAssociationClass();
			case PivotPackage.PROPERTY__DEFAULT_VALUE:
				return getDefaultValue();
			case PivotPackage.PROPERTY__DEFAULT_VALUE_STRING:
				return getDefaultValueString();
			case PivotPackage.PROPERTY__IS_COMPOSITE:
				return isComposite();
			case PivotPackage.PROPERTY__IS_DERIVED:
				return isDerived();
			case PivotPackage.PROPERTY__IS_ID:
				return isID();
			case PivotPackage.PROPERTY__IS_IMPLICIT:
				return isImplicit();
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
			case PivotPackage.PROPERTY__OWNED_EXPRESSION:
				return getOwnedExpression();
			case PivotPackage.PROPERTY__OWNING_CLASS:
				return getOwningClass();
			case PivotPackage.PROPERTY__REDEFINED_PROPERTIES:
				return getRedefinedProperties();
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
			case PivotPackage.PROPERTY__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PROPERTY__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.PROPERTY__OWNED_COMMENTS:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PROPERTY__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
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
			case PivotPackage.PROPERTY__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				setAssociationClass((AssociationClass)newValue);
				return;
			case PivotPackage.PROPERTY__DEFAULT_VALUE:
				setDefaultValue(newValue);
				return;
			case PivotPackage.PROPERTY__DEFAULT_VALUE_STRING:
				setDefaultValueString((String)newValue);
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
			case PivotPackage.PROPERTY__IS_IMPLICIT:
				setIsImplicit((Boolean)newValue);
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
			case PivotPackage.PROPERTY__OWNED_EXPRESSION:
				setOwnedExpression((LanguageExpression)newValue);
				return;
			case PivotPackage.PROPERTY__OWNING_CLASS:
				setOwningClass((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case PivotPackage.PROPERTY__REDEFINED_PROPERTIES:
				getRedefinedProperties().clear();
				getRedefinedProperties().addAll((Collection<? extends Property>)newValue);
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
			case PivotPackage.PROPERTY__ANNOTATING_COMMENTS:
				getAnnotatingComments().clear();
				return;
			case PivotPackage.PROPERTY__OWNED_ANNOTATIONS:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.PROPERTY__OWNED_COMMENTS:
				getOwnedComments().clear();
				return;
			case PivotPackage.PROPERTY__OWNED_EXTENSIONS:
				getOwnedExtensions().clear();
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
			case PivotPackage.PROPERTY__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				setAssociationClass((AssociationClass)null);
				return;
			case PivotPackage.PROPERTY__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__DEFAULT_VALUE_STRING:
				setDefaultValueString(DEFAULT_VALUE_STRING_EDEFAULT);
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
			case PivotPackage.PROPERTY__IS_IMPLICIT:
				setIsImplicit(IS_IMPLICIT_EDEFAULT);
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
			case PivotPackage.PROPERTY__OWNED_EXPRESSION:
				setOwnedExpression((LanguageExpression)null);
				return;
			case PivotPackage.PROPERTY__OWNING_CLASS:
				setOwningClass((org.eclipse.ocl.pivot.Class)null);
				return;
			case PivotPackage.PROPERTY__REDEFINED_PROPERTIES:
				getRedefinedProperties().clear();
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
			case PivotPackage.PROPERTY__ANNOTATING_COMMENTS:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case PivotPackage.PROPERTY__OWNED_ANNOTATIONS:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.PROPERTY__OWNED_COMMENTS:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.PROPERTY__OWNED_EXTENSIONS:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case PivotPackage.PROPERTY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PROPERTY__IS_MANY:
				return isMany() != IS_MANY_EDEFAULT;
			case PivotPackage.PROPERTY__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.PROPERTY__TYPE:
				return type != null;
			case PivotPackage.PROPERTY__IMPLEMENTATION:
				return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
			case PivotPackage.PROPERTY__IMPLEMENTATION_CLASS:
				return IMPLEMENTATION_CLASS_EDEFAULT == null ? implementationClass != null : !IMPLEMENTATION_CLASS_EDEFAULT.equals(implementationClass);
			case PivotPackage.PROPERTY__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.PROPERTY__ASSOCIATION_CLASS:
				return associationClass != null;
			case PivotPackage.PROPERTY__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
			case PivotPackage.PROPERTY__DEFAULT_VALUE_STRING:
				return DEFAULT_VALUE_STRING_EDEFAULT == null ? defaultValueString != null : !DEFAULT_VALUE_STRING_EDEFAULT.equals(defaultValueString);
			case PivotPackage.PROPERTY__IS_COMPOSITE:
				return ((eFlags & IS_COMPOSITE_EFLAG) != 0) != IS_COMPOSITE_EDEFAULT;
			case PivotPackage.PROPERTY__IS_DERIVED:
				return ((eFlags & IS_DERIVED_EFLAG) != 0) != IS_DERIVED_EDEFAULT;
			case PivotPackage.PROPERTY__IS_ID:
				return ((eFlags & IS_ID_EFLAG) != 0) != IS_ID_EDEFAULT;
			case PivotPackage.PROPERTY__IS_IMPLICIT:
				return ((eFlags & IS_IMPLICIT_EFLAG) != 0) != IS_IMPLICIT_EDEFAULT;
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
			case PivotPackage.PROPERTY__OWNED_EXPRESSION:
				return ownedExpression != null;
			case PivotPackage.PROPERTY__OWNING_CLASS:
				return getOwningClass() != null;
			case PivotPackage.PROPERTY__REDEFINED_PROPERTIES:
				return redefinedProperties != null && !redefinedProperties.isEmpty();
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Class getOwningClass() {
		if (eContainerFeatureID() != PivotPackage.PROPERTY__OWNING_CLASS) return null;
		return (org.eclipse.ocl.pivot.Class)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningClass(org.eclipse.ocl.pivot.Class newOwningClass, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningClass, PivotPackage.PROPERTY__OWNING_CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningClass(org.eclipse.ocl.pivot.Class newOwningClass)
	{
		if (newOwningClass != eInternalContainer() || (eContainerFeatureID() != PivotPackage.PROPERTY__OWNING_CLASS && newOwningClass != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningClass != null)
				msgs = ((InternalEObject)newOwningClass).eInverseAdd(this, PivotPackage.CLASS__OWNED_PROPERTIES, org.eclipse.ocl.pivot.Class.class, msgs);
			msgs = basicSetOwningClass(newOwningClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__OWNING_CLASS, newOwningClass, newOwningClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Property> getRedefinedProperties()
	{
		if (redefinedProperties == null)
		{
			redefinedProperties = new EObjectResolvingEList<Property>(Property.class, this, PivotPackage.PROPERTY__REDEFINED_PROPERTIES);
		}
		return redefinedProperties;
	}

	@Override
	public @Nullable CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		org.eclipse.ocl.pivot.Class owningType = getOwningClass();
		if (owningType != null) {
			return standardLibrary.getInheritance(owningType);
		}
		else {
			return null;
		}
	}

	private PropertyId propertyId = null;
	
	@Override
	public @NonNull PropertyId getPropertyId() {
		PropertyId propertyId2 = propertyId;
		if (propertyId2 == null) {
			synchronized (this) {
				propertyId2 = propertyId;
				if (propertyId2 == null) {
					String name = ClassUtil.nonNullModel(getName());
					TypeId typeId = getOwningClass().getTypeId();
					propertyId = propertyId2 = typeId.getPropertyId(name);
				}
			}
		}
		return propertyId2;
	}

	@Override
	public void initValue(@NonNull EObject objectValue, @Nullable Object ecoreValue) {
		assert ValueUtil.isEcore(ecoreValue);
		EObject eTarget = getESObject();
		if (eTarget instanceof EStructuralFeature) {
			EStructuralFeature eFeature = (EStructuralFeature) eTarget;
			EObject eObject = ValueUtil.asNavigableObject(objectValue, eFeature, null);
			eObject.eSet(eFeature, ecoreValue);
			return;
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public void unloaded(@NonNull ASResource asResource) {
		super.unloaded(asResource);
		Property asOpposite = getOpposite();
		if (asOpposite != null) {
			Resource eResource = asOpposite.eResource();
			if ((eResource != null) && (eResource != asResource)) {
				asOpposite.setOwningClass(null);
			}
			asOpposite.setType(null);
			asOpposite.setOpposite(null);
			setOpposite(null);
		}
		setType(null);				// Easier to set them all than just the base_xxx ones
	}
} //PropertyImpl
