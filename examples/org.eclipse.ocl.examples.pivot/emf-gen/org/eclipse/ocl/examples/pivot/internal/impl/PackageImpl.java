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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.InstanceSpecification;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.ProfileApplication;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getOwnedTemplateSignature <em>Owned Template Signature</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getTemplateBinding <em>Template Binding</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getUnspecializedElement <em>Unspecialized Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getOwnedRule <em>Owned Rule</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getImportedPackage <em>Imported Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getOwnedInstances <em>Owned Instances</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getOwnedPackages <em>Owned Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl#getProfileApplication <em>Profile Application</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("cast")
public class PackageImpl
		extends PackageableElementImpl
		implements org.eclipse.ocl.examples.pivot.Package {
		
	/**
	 * The cached value of the '{@link #getOwnedTemplateSignature() <em>Owned Template Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTemplateSignature()
	 * @generated
	 * @ordered
	 */
	protected TemplateSignature ownedTemplateSignature;

	/**
	 * The cached value of the '{@link #getTemplateBinding() <em>Template Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateBinding()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateBinding> templateBinding;

	/**
	 * The cached value of the '{@link #getUnspecializedElement() <em>Unspecialized Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnspecializedElement()
	 * @generated
	 * @ordered
	 */
	protected TemplateableElement unspecializedElement;

	/**
	 * The cached value of the '{@link #getOwnedRule() <em>Owned Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRule()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> ownedRule;

	/**
	 * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImportedPackage() <em>Imported Package</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Package> importedPackage;

	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedInstances() <em>Owned Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceSpecification> ownedInstances;

	/**
	 * The cached value of the '{@link #getOwnedPackages() <em>Owned Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Package> ownedPackages;

	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Class> ownedType;

	/**
	 * The cached value of the '{@link #getProfileApplication() <em>Profile Application</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileApplication()
	 * @generated
	 * @ordered
	 */
	protected EList<ProfileApplication> profileApplication;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<Constraint> getOwnedRule()
	{
		if (ownedRule == null)
		{
			ownedRule = new EObjectContainmentEList<Constraint>(Constraint.class, this, PivotPackage.PACKAGE__OWNED_RULE);
		}
		return ownedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<TemplateBinding> getTemplateBinding()
	{
		if (templateBinding == null)
		{
			templateBinding = new EObjectContainmentWithInverseEList<TemplateBinding>(TemplateBinding.class, this, PivotPackage.PACKAGE__TEMPLATE_BINDING, PivotPackage.TEMPLATE_BINDING__BOUND_ELEMENT);
		}
		return templateBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignature getOwnedTemplateSignature() {
		return ownedTemplateSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedTemplateSignature(
			TemplateSignature newOwnedTemplateSignature, NotificationChain msgs) {
		TemplateSignature oldOwnedTemplateSignature = ownedTemplateSignature;
		ownedTemplateSignature = newOwnedTemplateSignature;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE, oldOwnedTemplateSignature, newOwnedTemplateSignature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedTemplateSignature(
			TemplateSignature newOwnedTemplateSignature) {
		if (newOwnedTemplateSignature != ownedTemplateSignature)
		{
			NotificationChain msgs = null;
			if (ownedTemplateSignature != null)
				msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, PivotPackage.TEMPLATE_SIGNATURE__TEMPLATE, TemplateSignature.class, msgs);
			if (newOwnedTemplateSignature != null)
				msgs = ((InternalEObject)newOwnedTemplateSignature).eInverseAdd(this, PivotPackage.TEMPLATE_SIGNATURE__TEMPLATE, TemplateSignature.class, msgs);
			msgs = basicSetOwnedTemplateSignature(newOwnedTemplateSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE, newOwnedTemplateSignature, newOwnedTemplateSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateableElement getUnspecializedElement()
	{
		return unspecializedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnspecializedElement(TemplateableElement newUnspecializedElement)
	{
		TemplateableElement oldUnspecializedElement = unspecializedElement;
		unspecializedElement = newUnspecializedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PACKAGE__UNSPECIALIZED_ELEMENT, oldUnspecializedElement, unspecializedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<org.eclipse.ocl.examples.pivot.Package> getOwnedPackages()
	{
		if (ownedPackages == null)
		{
			ownedPackages = new EObjectContainmentWithInverseEList<org.eclipse.ocl.examples.pivot.Package>(org.eclipse.ocl.examples.pivot.Package.class, this, PivotPackage.PACKAGE__OWNED_PACKAGES, PivotPackage.PACKAGE__OWNING_PACKAGE);
		}
		return ownedPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PACKAGE__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setURIGen(String newURI) {
		String oldURI = uri;
		uri = newURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PACKAGE__URI, oldURI, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getURI() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<org.eclipse.ocl.examples.pivot.Package> getImportedPackage()
	{
		if (importedPackage == null)
		{
			importedPackage = new EObjectResolvingEList<org.eclipse.ocl.examples.pivot.Package>(org.eclipse.ocl.examples.pivot.Package.class, this, PivotPackage.PACKAGE__IMPORTED_PACKAGE);
		}
		return importedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<org.eclipse.ocl.examples.pivot.Class> getOwnedType()
	{
		if (ownedType == null)
		{
			ownedType = new EObjectContainmentWithInverseEList<org.eclipse.ocl.examples.pivot.Class>(org.eclipse.ocl.examples.pivot.Class.class, this, PivotPackage.PACKAGE__OWNED_TYPE, PivotPackage.CLASS__PACKAGE);
		}
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<ProfileApplication> getProfileApplication()
	{
		if (profileApplication == null)
		{
			profileApplication = new EObjectContainmentWithInverseEList<ProfileApplication>(ProfileApplication.class, this, PivotPackage.PACKAGE__PROFILE_APPLICATION, PivotPackage.PROFILE_APPLICATION__APPLYING_PACKAGE);
		}
		return profileApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Package getOwningPackage() {
		if (eContainerFeatureID() != PivotPackage.PACKAGE__OWNING_PACKAGE) return null;
		return (org.eclipse.ocl.examples.pivot.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningPackage(org.eclipse.ocl.examples.pivot.Package newOwningPackage, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningPackage, PivotPackage.PACKAGE__OWNING_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningPackage(
			org.eclipse.ocl.examples.pivot.Package newOwningPackage) {
		if (newOwningPackage != eInternalContainer() || (eContainerFeatureID() != PivotPackage.PACKAGE__OWNING_PACKAGE && newOwningPackage != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newOwningPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningPackage != null)
				msgs = ((InternalEObject)newOwningPackage).eInverseAdd(this, PivotPackage.PACKAGE__OWNED_PACKAGES, org.eclipse.ocl.examples.pivot.Package.class, msgs);
			msgs = basicSetOwningPackage(newOwningPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PACKAGE__OWNING_PACKAGE, newOwningPackage, newOwningPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ParameterableElement> parameterableElements() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!TemplateableElement!parameterableElements()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplate() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!TemplateableElement!isTemplate()
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
			case PivotPackage.PACKAGE__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.PACKAGE__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNING_TEMPLATE_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.PACKAGE__TEMPLATE_PARAMETER:
				if (templateParameter != null)
					msgs = ((InternalEObject)templateParameter).eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case PivotPackage.PACKAGE__TEMPLATE_BINDING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplateBinding()).basicAdd(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNED_INSTANCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedInstances()).basicAdd(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNED_PACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPackages()).basicAdd(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNED_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedType()).basicAdd(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningPackage((org.eclipse.ocl.examples.pivot.Package)otherEnd, msgs);
			case PivotPackage.PACKAGE__PROFILE_APPLICATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProfileApplication()).basicAdd(otherEnd, msgs);
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
			case PivotPackage.PACKAGE__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.PACKAGE__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.PACKAGE__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case PivotPackage.PACKAGE__TEMPLATE_BINDING:
				return ((InternalEList<?>)getTemplateBinding()).basicRemove(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNED_INSTANCES:
				return ((InternalEList<?>)getOwnedInstances()).basicRemove(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNED_PACKAGES:
				return ((InternalEList<?>)getOwnedPackages()).basicRemove(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNED_TYPE:
				return ((InternalEList<?>)getOwnedType()).basicRemove(otherEnd, msgs);
			case PivotPackage.PACKAGE__OWNING_PACKAGE:
				return basicSetOwningPackage(null, msgs);
			case PivotPackage.PACKAGE__PROFILE_APPLICATION:
				return ((InternalEList<?>)getProfileApplication()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.PACKAGE__OWNING_TEMPLATE_PARAMETER:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			case PivotPackage.PACKAGE__OWNING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.PACKAGE__OWNED_PACKAGES, org.eclipse.ocl.examples.pivot.Package.class, msgs);
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
			case PivotPackage.PACKAGE__COMMENT:
				return getComment();
			case PivotPackage.PACKAGE__EXTENSION:
				return getExtension();
			case PivotPackage.PACKAGE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.PACKAGE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.PACKAGE__NAME:
				return getName();
			case PivotPackage.PACKAGE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.PACKAGE__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.PACKAGE__TEMPLATE_BINDING:
				return getTemplateBinding();
			case PivotPackage.PACKAGE__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.PACKAGE__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.PACKAGE__URI:
				return getURI();
			case PivotPackage.PACKAGE__IMPORTED_PACKAGE:
				return getImportedPackage();
			case PivotPackage.PACKAGE__NS_PREFIX:
				return getNsPrefix();
			case PivotPackage.PACKAGE__OWNED_INSTANCES:
				return getOwnedInstances();
			case PivotPackage.PACKAGE__OWNED_PACKAGES:
				return getOwnedPackages();
			case PivotPackage.PACKAGE__OWNED_TYPE:
				return getOwnedType();
			case PivotPackage.PACKAGE__OWNING_PACKAGE:
				return getOwningPackage();
			case PivotPackage.PACKAGE__PROFILE_APPLICATION:
				return getProfileApplication();
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
			case PivotPackage.PACKAGE__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PACKAGE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.PACKAGE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.PACKAGE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PACKAGE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.PACKAGE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.PACKAGE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.PACKAGE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				getTemplateBinding().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.PACKAGE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.PACKAGE__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.PACKAGE__URI:
				setURI((String)newValue);
				return;
			case PivotPackage.PACKAGE__IMPORTED_PACKAGE:
				getImportedPackage().clear();
				getImportedPackage().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case PivotPackage.PACKAGE__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case PivotPackage.PACKAGE__OWNED_INSTANCES:
				getOwnedInstances().clear();
				getOwnedInstances().addAll((Collection<? extends InstanceSpecification>)newValue);
				return;
			case PivotPackage.PACKAGE__OWNED_PACKAGES:
				getOwnedPackages().clear();
				getOwnedPackages().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case PivotPackage.PACKAGE__OWNED_TYPE:
				getOwnedType().clear();
				getOwnedType().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.PACKAGE__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.PACKAGE__PROFILE_APPLICATION:
				getProfileApplication().clear();
				getProfileApplication().addAll((Collection<? extends ProfileApplication>)newValue);
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
			case PivotPackage.PACKAGE__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.PACKAGE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.PACKAGE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.PACKAGE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.PACKAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.PACKAGE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.PACKAGE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.PACKAGE__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				return;
			case PivotPackage.PACKAGE__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.PACKAGE__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.PACKAGE__URI:
				setURI(URI_EDEFAULT);
				return;
			case PivotPackage.PACKAGE__IMPORTED_PACKAGE:
				getImportedPackage().clear();
				return;
			case PivotPackage.PACKAGE__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case PivotPackage.PACKAGE__OWNED_INSTANCES:
				getOwnedInstances().clear();
				return;
			case PivotPackage.PACKAGE__OWNED_PACKAGES:
				getOwnedPackages().clear();
				return;
			case PivotPackage.PACKAGE__OWNED_TYPE:
				getOwnedType().clear();
				return;
			case PivotPackage.PACKAGE__OWNING_PACKAGE:
				setOwningPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.PACKAGE__PROFILE_APPLICATION:
				getProfileApplication().clear();
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
			case PivotPackage.PACKAGE__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.PACKAGE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.PACKAGE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.PACKAGE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.PACKAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PACKAGE__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.PACKAGE__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.PACKAGE__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case PivotPackage.PACKAGE__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.PACKAGE__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.PACKAGE__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case PivotPackage.PACKAGE__IMPORTED_PACKAGE:
				return importedPackage != null && !importedPackage.isEmpty();
			case PivotPackage.PACKAGE__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case PivotPackage.PACKAGE__OWNED_INSTANCES:
				return ownedInstances != null && !ownedInstances.isEmpty();
			case PivotPackage.PACKAGE__OWNED_PACKAGES:
				return ownedPackages != null && !ownedPackages.isEmpty();
			case PivotPackage.PACKAGE__OWNED_TYPE:
				return ownedType != null && !ownedType.isEmpty();
			case PivotPackage.PACKAGE__OWNING_PACKAGE:
				return getOwningPackage() != null;
			case PivotPackage.PACKAGE__PROFILE_APPLICATION:
				return profileApplication != null && !profileApplication.isEmpty();
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
		if (baseClass == TemplateableElement.class)
		{
			switch (derivedFeatureID)
			{
				case PivotPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE: return PivotPackage.TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE;
				case PivotPackage.PACKAGE__TEMPLATE_BINDING: return PivotPackage.TEMPLATEABLE_ELEMENT__TEMPLATE_BINDING;
				case PivotPackage.PACKAGE__UNSPECIALIZED_ELEMENT: return PivotPackage.TEMPLATEABLE_ELEMENT__UNSPECIALIZED_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == Namespace.class)
		{
			switch (derivedFeatureID)
			{
				case PivotPackage.PACKAGE__OWNED_RULE: return PivotPackage.NAMESPACE__OWNED_RULE;
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
		if (baseClass == TemplateableElement.class)
		{
			switch (baseFeatureID)
			{
				case PivotPackage.TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE: return PivotPackage.PACKAGE__OWNED_TEMPLATE_SIGNATURE;
				case PivotPackage.TEMPLATEABLE_ELEMENT__TEMPLATE_BINDING: return PivotPackage.PACKAGE__TEMPLATE_BINDING;
				case PivotPackage.TEMPLATEABLE_ELEMENT__UNSPECIALIZED_ELEMENT: return PivotPackage.PACKAGE__UNSPECIALIZED_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == Namespace.class)
		{
			switch (baseFeatureID)
			{
				case PivotPackage.NAMESPACE__OWNED_RULE: return PivotPackage.PACKAGE__OWNED_RULE;
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
		if (baseClass == TemplateableElement.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.TEMPLATEABLE_ELEMENT___IS_TEMPLATE: return PivotPackage.PACKAGE___IS_TEMPLATE;
				case PivotPackage.TEMPLATEABLE_ELEMENT___PARAMETERABLE_ELEMENTS: return PivotPackage.PACKAGE___PARAMETERABLE_ELEMENTS;
				default: return -1;
			}
		}
		if (baseClass == Namespace.class)
		{
			switch (baseOperationID)
			{
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
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case PivotPackage.PACKAGE___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.PACKAGE___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.PACKAGE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT:
				return isCompatibleWith((ParameterableElement)arguments.get(0));
			case PivotPackage.PACKAGE___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case PivotPackage.PACKAGE___IS_TEMPLATE:
				return isTemplate();
			case PivotPackage.PACKAGE___PARAMETERABLE_ELEMENTS:
				return parameterableElements();
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
		return visitor.visitPackage(this);
	}

	private PackageId packageId = null;

	public @Nullable PackageId basicGetPackageId() {
		return packageId;
	}

	public void setURI(String newURI) {
		setURIGen(newURI);
		if ((packageId == null) && (newURI != null)) {
			setPackageId(IdManager.getPackageId(this));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<InstanceSpecification> getOwnedInstances()
	{
		if (ownedInstances == null)
		{
			ownedInstances = new EObjectContainmentWithInverseEList<InstanceSpecification>(InstanceSpecification.class, this, PivotPackage.PACKAGE__OWNED_INSTANCES, PivotPackage.INSTANCE_SPECIFICATION__OWNING_PACKAGE);
		}
		return ownedInstances;
	}

	public @Nullable EPackage getEPackage() {
		EObject eTarget = getETarget();
		return eTarget instanceof EPackage ? (EPackage) eTarget : null;
	}
	
	public @NonNull PackageId getPackageId() {
		PackageId packageId2 = packageId;
		if (packageId2 == null) {
			synchronized (this) {
				packageId2 = packageId;
				if (packageId2 == null) {
					synchronized (this) {
						packageId = packageId2 = IdManager.getPackageId(this);
					}
				}
			}
		}
		return packageId2;
	}
	
	public void setPackageId(@NonNull PackageId packageId) {
		assert this.packageId == null;
		this.packageId = packageId;
	}

	private boolean ignoreInvariants = false;		// FIXME Model this (used to suppress bad OMG UML 2.5 invariants)
	
	public void setIgnoreInvariants(boolean ignoreInvariants) {
		this.ignoreInvariants = ignoreInvariants;
	}
	
	public boolean isIgnoreInvariants() {
		return ignoreInvariants;
	}
} //PackageImpl
