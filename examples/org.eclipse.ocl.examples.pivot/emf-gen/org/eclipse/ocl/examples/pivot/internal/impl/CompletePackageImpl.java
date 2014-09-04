/**
 * Copyright (c) 2010,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.NestedCompletePackage;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.RootCompletePackage;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.manager.AnyTypeServer;
import org.eclipse.ocl.examples.pivot.manager.CollectionTypeServer;
import org.eclipse.ocl.examples.pivot.manager.EnumerationTypeServer;
import org.eclipse.ocl.examples.pivot.manager.ExtensibleTypeServer;
import org.eclipse.ocl.examples.pivot.manager.InvalidTypeServer;
import org.eclipse.ocl.examples.pivot.manager.TemplateableTypeServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.manager.VoidTypeServer;
import org.eclipse.ocl.examples.pivot.util.Visitor;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl#getOwnedCompleteClasses <em>Owned Complete Classes</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl#getOwnedCompletePackages <em>Owned Complete Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl#getPartialPackages <em>Partial Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompletePackageImpl extends NamedElementImpl implements CompletePackage
{
	/**
	 * The cached value of the '{@link #getOwnedCompleteClasses() <em>Owned Complete Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCompleteClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<CompleteClass> ownedCompleteClasses;

	/**
	 * The cached value of the '{@link #getOwnedCompletePackages() <em>Owned Complete Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCompletePackages()
	 * @generated
	 * @ordered
	 */
	protected EList<NestedCompletePackage> ownedCompletePackages;

	/**
	 * The cached value of the '{@link #getPartialPackages() <em>Partial Packages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartialPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Package> partialPackages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompletePackageImpl()
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
		return PivotPackage.Literals.COMPLETE_PACKAGE;
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
			case PivotPackage.COMPLETE_PACKAGE__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.COMPLETE_PACKAGE__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedCompleteClasses()).basicAdd(otherEnd, msgs);
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedCompletePackages()).basicAdd(otherEnd, msgs);
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
			case PivotPackage.COMPLETE_PACKAGE__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_PACKAGE__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_PACKAGE__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				return ((InternalEList<?>)getOwnedCompleteClasses()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				return ((InternalEList<?>)getOwnedCompletePackages()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
			case PivotPackage.COMPLETE_PACKAGE__COMMENT:
				return getComment();
			case PivotPackage.COMPLETE_PACKAGE__EXTENSION:
				return getExtension();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.COMPLETE_PACKAGE__NAME:
				return getName();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				return getOwnedCompleteClasses();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				return getOwnedCompletePackages();
			case PivotPackage.COMPLETE_PACKAGE__PARTIAL_PACKAGES:
				return getPartialPackages();
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
			case PivotPackage.COMPLETE_PACKAGE__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				getOwnedCompleteClasses().clear();
				getOwnedCompleteClasses().addAll((Collection<? extends CompleteClass>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				getOwnedCompletePackages().clear();
				getOwnedCompletePackages().addAll((Collection<? extends NestedCompletePackage>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__PARTIAL_PACKAGES:
				getPartialPackages().clear();
				getPartialPackages().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
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
			case PivotPackage.COMPLETE_PACKAGE__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				getOwnedCompleteClasses().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				getOwnedCompletePackages().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__PARTIAL_PACKAGES:
				getPartialPackages().clear();
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
			case PivotPackage.COMPLETE_PACKAGE__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES:
				return ownedCompleteClasses != null && !ownedCompleteClasses.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES:
				return ownedCompletePackages != null && !ownedCompletePackages.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__PARTIAL_PACKAGES:
				return partialPackages != null && !partialPackages.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	private /*final*/ /*@NonNull*/ String nsPrefix;
	private /*final*/ /*@NonNull*/ String nsURI;
//	private /*final*/ /*@NonNull*/ PackageId packageId;

	/**
	 * Map of (nested) package-name to package server.
	 * <p>
	 * let entries = ownedNestedCompletePackages->select(name <> null)
	 * in entries->collect(entry | Tuple{key : String = entry.name, value : RootCompletePackage = entry})
	 */
	private Map<String, NestedCompletePackage> name2nestedCompletePackage = null;
	
	/**
	 * Lazily created map of nested class-name to multi-class server.
	 */
	private @Nullable Map<String, TypeServer> typeServers = null;

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCompletePackage(this);
	}

	public void assertSamePackage(DomainPackage pivotPackage) {
		assert pivotPackage != null;
		String typeBasedNsURI = pivotPackage.getURI();
		String serverBasedNsURI = getURI();
		assert (typeBasedNsURI == serverBasedNsURI) || typeBasedNsURI.equals(serverBasedNsURI);
	}
	
	protected abstract void didAddCompleteClass(@NonNull CompleteClass completeClass);

	void didAddNestedCompletePackage(@NonNull NestedCompletePackage nestedCompletePackage) {
		assert name2nestedCompletePackage != null;
		String name = nestedCompletePackage.getName();
		if (name != null) {
			CompletePackage oldCompletePackage = name2nestedCompletePackage.put(name, nestedCompletePackage);
			assert oldCompletePackage == null;
		}
	}
	
	protected abstract void didAddPartialPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage);
	
	protected abstract void didRemoveCompleteClass(@NonNull CompleteClass completeClass);
	
	void didRemoveNestedCompletePackage(@NonNull NestedCompletePackage nestedCompletePackage) {
		assert name2nestedCompletePackage != null;
		String name = nestedCompletePackage.getName();
		if (name != null) {
			name2nestedCompletePackage.remove(name);
		}
	}
	
	protected abstract void didRemovePartialPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage);

	protected void doRefreshNestedPackages() {
		if (name2nestedCompletePackage == null) {
			name2nestedCompletePackage = new HashMap<String, NestedCompletePackage>();
		}
		for (org.eclipse.ocl.examples.pivot.Package partialParentPackage : getPartialPackages()) {
			for (org.eclipse.ocl.examples.pivot.Package partialChildPackage : partialParentPackage.getOwnedPackages()) {
				if (partialChildPackage != null) {
					String name = partialChildPackage.getName();
					if (name != null) {
						NestedCompletePackage completePackage = name2nestedCompletePackage.get(name);
						if (completePackage == null) {
							completePackage = PivotFactory.eINSTANCE.createNestedCompletePackage();
							completePackage.init(name, partialChildPackage.getNsPrefix(), partialChildPackage.getURI(), partialChildPackage.getPackageId());
							completePackage.getPartialPackages().add(partialChildPackage);
							getOwnedCompletePackages().add(completePackage);
						}
					}
				}
			}
		}
	}

	public @NonNull Iterable<? extends DomainClass> getAllClasses() {
		return Iterables.transform(getOwnedCompleteClasses(), new Function<CompleteClass, DomainClass>()
			{
				public DomainClass apply(CompleteClass input) {
					return input.getPivotClass();
				}
			});
	}

	public CompleteModelImpl getCompleteModel() {
		for (EObject eContainer = eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
			if (eContainer instanceof CompleteModelImpl) {
				return (CompleteModelImpl) eContainer;
			}
		}
		return null;
	}

	public EPackage getEPackage() {
		for (org.eclipse.ocl.examples.pivot.Package partialPackage : getPartialPackages()) {
			EPackage ePackage = partialPackage.getEPackage();
			if (ePackage != null) {
				return ePackage;
			}
		}
		return null;
	}

	public int getIndex(org.eclipse.ocl.examples.pivot.Package p1) {
		return getPartialPackages().indexOf(p1);
	}

	public CompletePackage getMemberPackage(String subPackageName) {
		return getOwnedCompletePackage(subPackageName);
	}

	public org.eclipse.ocl.examples.pivot.Class getMemberType(String name) {
		CompleteClass completeClass = name != null ? getOwnedCompleteClass(name) : null;
		return completeClass != null ? ((CompleteClassImpl)completeClass).getPivotClass() : null;
	}

	public void getMemberTypes() {
		throw new UnsupportedOperationException();
	}

	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("null")
	public @NonNull List<CompleteClass> getOwnedCompleteClasses()
	{
		if (ownedCompleteClasses == null)
		{
			ownedCompleteClasses = new EObjectContainmentWithInverseEList<CompleteClass>(CompleteClass.class, this, PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES, PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE)
			{
				private static final long serialVersionUID = 1L;

				@Override
				protected void didAdd(int index, CompleteClass completeClass) {
					assert completeClass != null;
					super.didAdd(index, completeClass);
					didAddCompleteClass(completeClass);
				}

				@Override
				protected void didRemove(int index, CompleteClass completeClass) {
					assert completeClass != null;
					didRemoveCompleteClass(completeClass);
					super.didRemove(index, completeClass);
				}
			};
		}
		return ownedCompleteClasses;
	}
	
	public abstract @Nullable CompleteClass getOwnedCompleteClass(@NonNull String name);

	public CompletePackage getOwnedCompletePackage(@NonNull String name) {
		if (name2nestedCompletePackage == null) {
			doRefreshNestedPackages();
		}
		return name2nestedCompletePackage.get(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("null")
	public @NonNull List<NestedCompletePackage> getOwnedCompletePackages()
	{
		if (ownedCompletePackages == null)
		{
			ownedCompletePackages = new EObjectContainmentWithInverseEList<NestedCompletePackage>(NestedCompletePackage.class, this, PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES, PivotPackage.NESTED_COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE)
			{
				private static final long serialVersionUID = 1L;

				@Override
				protected void didAdd(int index, NestedCompletePackage nestedCompletePackage) {
					assert nestedCompletePackage != null;
					super.didAdd(index, nestedCompletePackage);
					getCompleteModel().didAddCompletePackage(nestedCompletePackage);
					didAddNestedCompletePackage(nestedCompletePackage);
				}

				@Override
				protected void didRemove(int index, NestedCompletePackage nestedCompletePackage) {
					assert nestedCompletePackage != null;
					super.didRemove(index, nestedCompletePackage);
					getCompleteModel().didRemoveCompletePackage(nestedCompletePackage);
					didRemoveNestedCompletePackage(nestedCompletePackage);
				}
			};
		}
		return ownedCompletePackages;
	}

//	@SuppressWarnings("null")
//	public @NonNull PackageManager getPackageManager() {
//		return packageManager;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("null")
	public @NonNull List<org.eclipse.ocl.examples.pivot.Package> getPartialPackages()
	{
		if (partialPackages == null)
		{
			partialPackages = new EObjectResolvingEList<org.eclipse.ocl.examples.pivot.Package>(org.eclipse.ocl.examples.pivot.Package.class, this, PivotPackage.COMPLETE_PACKAGE__PARTIAL_PACKAGES)
			{
				private static final long serialVersionUID = 1L;

				@Override
				protected void didAdd(int index, org.eclipse.ocl.examples.pivot.Package partialPackage) {
					assert partialPackage != null;
					super.didAdd(index, partialPackage);
					didAddPartialPackage(partialPackage);
				}

				@Override
				protected void didRemove(int index, org.eclipse.ocl.examples.pivot.Package partialPackage) {
					assert partialPackage != null;
					super.didRemove(index, partialPackage);
					didRemovePartialPackage(partialPackage);
				}
		
			};
		}
		return partialPackages;
	}

	public org.eclipse.ocl.examples.pivot.Package getPivotPackage() {
		for (org.eclipse.ocl.examples.pivot.Package partialPackage : getPartialPackages()) {
//			if (partialPackage instanceof org.eclipse.ocl.examples.pivot.Package) {
				return partialPackage;
//			}
		}
		throw new UnsupportedOperationException();
	}

	public RootCompletePackage getRootCompletePackage() {
		for (EObject eContainer = this; eContainer != null; eContainer = eContainer.eContainer()) {
			if (eContainer instanceof RootCompletePackage) {
				return (RootCompletePackage) eContainer;
			}
		}
		return null;
	}

	public DomainType getType(String metatypeName) {
		CompleteClass completeClass = getOwnedCompleteClass(metatypeName);
		return completeClass != null ? completeClass.getPivotClass() : null;
	}
	
	@NonNull TypeServer getTypeServer2(@NonNull CompleteClass completeClass, @NonNull DomainType pivotType) {
		assert completeClass.eContainer() == this;
		if (pivotType instanceof TypeServer) {
			return (TypeServer)pivotType;
		}
		assert !(pivotType instanceof TemplateableElement) || (((TemplateableElement)pivotType).getUnspecializedElement() == null);
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 == null) {
			typeServers2 = initMemberTypes();
		}
		String name = pivotType.getName();
		if (name == null) {
			throw new IllegalStateException("Unnamed type");
		}
		TypeServer typeServer = typeServers2.get(name);
		if (typeServer == null) {
			if (pivotType instanceof InvalidType) {
				typeServer = new InvalidTypeServer(completeClass, (InvalidType)pivotType);
			}
			else if (pivotType instanceof VoidType) {
				typeServer = new VoidTypeServer(completeClass, (VoidType)pivotType);
			}
			else if (pivotType instanceof AnyType) {
				typeServer = new AnyTypeServer(completeClass, (AnyType)pivotType);
			}
			else if (pivotType instanceof Enumeration) {
				typeServer = new EnumerationTypeServer(completeClass, (Enumeration)pivotType);
			}
			else if (pivotType instanceof CollectionType) {
				typeServer = new CollectionTypeServer(completeClass, (CollectionType)pivotType);
			}
			else if (pivotType instanceof PrimitiveType) {
				throw new UnsupportedOperationException("PrimitiveType");
//				typeServer = getCompleteModel().getPrimitiveTypeServer((PrimitiveType)pivotType);
			}
//			else if (pivotType instanceof ElementExtension) {
//				typeServer = new ExtensionTypeServer(this, (ElementExtension)pivotType);
//			}
			else if (pivotType instanceof org.eclipse.ocl.examples.pivot.Class) {
				typeServer = new TemplateableTypeServer(completeClass, (org.eclipse.ocl.examples.pivot.Class)pivotType);
			}
			else {
				throw new UnsupportedOperationException("TemplateType");
			}
			if ((pivotType instanceof TemplateableElement) && (((TemplateableElement)pivotType).getUnspecializedElement() == null)) {
				typeServers2.put(name, typeServer);
			}
		}
		if (typeServer instanceof ExtensibleTypeServer) {
			((ExtensibleTypeServer)typeServer).getTypeTracker((DomainClass) pivotType);		// FIXME cast
		}
		return typeServer;
	}

	public String getURI() {
		return nsURI;
	}

	public void init(@NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId) {
		setName(name);
		this.nsPrefix = nsPrefix;
		this.nsURI = nsURI;
//		this.packageId = packageId;
	}
	
	private @NonNull Map<String, TypeServer> initMemberTypes() {
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 == null) {
			typeServers2 = typeServers = new HashMap<String, TypeServer>();
			if (!PivotConstants.ORPHANAGE_URI.equals(nsURI)) {
				for (org.eclipse.ocl.examples.pivot.Package partialPcakge : getPartialPackages()) {
					initMemberTypes(partialPcakge);
				}
			}
		}
		return typeServers2;
	}

	private void initMemberTypes(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		for (DomainClass pivotType : pivotPackage.getOwnedClasses()) {
			if (pivotType != null) {
//				addedMemberType(pivotType);
			}
		}
	}		
} //CompletePackageImpl
