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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.DomainConstants;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteModel;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.OrphanCompletePackage;
import org.eclipse.ocl.examples.pivot.ParentCompletePackage;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.RootCompletePackage;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.CollectionTypeServer;
import org.eclipse.ocl.examples.pivot.manager.ExtensibleTypeServer;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.Orphanage;
import org.eclipse.ocl.examples.pivot.manager.RootTracker;
import org.eclipse.ocl.examples.pivot.manager.TemplateableTypeServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.manager.TypeTracker;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.IllegalMetamodelException;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl#getOrphanCompletePackage <em>Orphan Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl#getOwnedCompletePackages <em>Owned Complete Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl#getPartialRoots <em>Partial Roots</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl#getPrimitiveCompletePackage <em>Primitive Complete Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteModelImpl extends NamedElementImpl implements CompleteModel
{
	/**
	 * The cached value of the '{@link #getOrphanCompletePackage() <em>Orphan Complete Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrphanCompletePackage()
	 * @generated
	 * @ordered
	 */
	protected OrphanCompletePackage orphanCompletePackage;

	/**
	 * The cached value of the '{@link #getOwnedCompletePackages() <em>Owned Complete Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCompletePackages()
	 * @generated
	 * @ordered
	 */
	protected EList<RootCompletePackage> ownedCompletePackages;

	/**
	 * The cached value of the '{@link #getPartialRoots() <em>Partial Roots</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartialRoots()
	 * @generated
	 * @ordered
	 */
	protected EList<Root> partialRoots;

	/**
	 * The cached value of the '{@link #getPrimitiveCompletePackage() <em>Primitive Complete Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveCompletePackage()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveCompletePackage primitiveCompletePackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteModelImpl()
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
		return PivotPackage.Literals.COMPLETE_MODEL;
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
			case PivotPackage.COMPLETE_MODEL__COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.COMPLETE_MODEL__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.COMPLETE_MODEL__OWNED_COMMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
			case PivotPackage.COMPLETE_MODEL__OWNED_COMPLETE_PACKAGES:
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
			case PivotPackage.COMPLETE_MODEL__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_MODEL__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_MODEL__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_MODEL__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.COMPLETE_MODEL__OWNED_COMPLETE_PACKAGES:
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
			case PivotPackage.COMPLETE_MODEL__COMMENT:
				return getComment();
			case PivotPackage.COMPLETE_MODEL__EXTENSION:
				return getExtension();
			case PivotPackage.COMPLETE_MODEL__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.COMPLETE_MODEL__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.COMPLETE_MODEL__NAME:
				return getName();
			case PivotPackage.COMPLETE_MODEL__ORPHAN_COMPLETE_PACKAGE:
				return getOrphanCompletePackage();
			case PivotPackage.COMPLETE_MODEL__OWNED_COMPLETE_PACKAGES:
				return getOwnedCompletePackages();
			case PivotPackage.COMPLETE_MODEL__PARTIAL_ROOTS:
				return getPartialRoots();
			case PivotPackage.COMPLETE_MODEL__PRIMITIVE_COMPLETE_PACKAGE:
				return getPrimitiveCompletePackage();
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
			case PivotPackage.COMPLETE_MODEL__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COMPLETE_MODEL__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.COMPLETE_MODEL__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.COMPLETE_MODEL__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COMPLETE_MODEL__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COMPLETE_MODEL__OWNED_COMPLETE_PACKAGES:
				getOwnedCompletePackages().clear();
				getOwnedCompletePackages().addAll((Collection<? extends RootCompletePackage>)newValue);
				return;
			case PivotPackage.COMPLETE_MODEL__PARTIAL_ROOTS:
				getPartialRoots().clear();
				getPartialRoots().addAll((Collection<? extends Root>)newValue);
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
			case PivotPackage.COMPLETE_MODEL__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.COMPLETE_MODEL__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.COMPLETE_MODEL__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.COMPLETE_MODEL__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.COMPLETE_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_MODEL__OWNED_COMPLETE_PACKAGES:
				getOwnedCompletePackages().clear();
				return;
			case PivotPackage.COMPLETE_MODEL__PARTIAL_ROOTS:
				getPartialRoots().clear();
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
			case PivotPackage.COMPLETE_MODEL__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.COMPLETE_MODEL__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.COMPLETE_MODEL__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.COMPLETE_MODEL__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.COMPLETE_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COMPLETE_MODEL__ORPHAN_COMPLETE_PACKAGE:
				return orphanCompletePackage != null;
			case PivotPackage.COMPLETE_MODEL__OWNED_COMPLETE_PACKAGES:
				return ownedCompletePackages != null && !ownedCompletePackages.isEmpty();
			case PivotPackage.COMPLETE_MODEL__PARTIAL_ROOTS:
				return partialRoots != null && !partialRoots.isEmpty();
			case PivotPackage.COMPLETE_MODEL__PRIMITIVE_COMPLETE_PACKAGE:
				return primitiveCompletePackage != null;
		}
		return eDynamicIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PivotPackage.COMPLETE_MODEL___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.COMPLETE_MODEL___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.COMPLETE_MODEL___GET_OWNED_COMPLETE_PACKAGE__STRING:
				return getOwnedCompletePackage((String)arguments.get(0));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	private static final Logger logger = Logger.getLogger(CompleteModelImpl.class);
	
	protected /*final*/ /*@NonNull*/ MetaModelManager metaModelManager;

	/**
	 * Map of (nested) package-name to package server.
	 * <p>????
	 * let entries = ownedRootCompletePackages->select(nsURI <> null)
	 * in entries->collect(entry | Tuple{key : String = entry.name, value : RootCompletePackage = entry})
	 */
	private final @NonNull Map<String, RootCompletePackage> name2rootCompletePackage = new HashMap<String, RootCompletePackage>();

	private final @NonNull Set<RootTracker> rootTrackers = new HashSet<RootTracker>();
	
	/**
	 * Map of shared URIs to synonyms
	 */
	private final @NonNull Map<String, Set<String>> sharedURI2synonymURIs = new HashMap<String, Set<String>>();
	
	/**
	 * Map of synonym URI to shared URI.
	 */
	private final @NonNull Map<String, String> synonymURI2sharedURI = new HashMap<String, String>();

	/**
	 * Map from each merged type to the TypeTracker that supervises its merge. TypeTrackers are only
	 * created for merged types, so a missing entry just denotes an unmerged type. 
	 */
	private final @NonNull Map<DomainClass, TypeTracker> type2tracker = new WeakHashMap<DomainClass, TypeTracker>();

	/**
	 * Map from package URI to primary package. 
	 * <p>
	 * let entries = ownedRootCompletePackages->closure(ownedNestedCompletePackages)->select(nsURI <> null)
	 * in entries->collect(entry | Tuple{key : String = entry.nsURI, value : CompletePackage = entry})
	 */
	private final @NonNull Map<String, CompletePackage> uri2completePackage = new HashMap<String, CompletePackage>();

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCompleteModel(this);
	}

	public void addPackage(@NonNull CompleteModel completeModel, @NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		CompletePackage completePackage = null;
		String name = pivotPackage.getName();
		String nsURI = pivotPackage.getURI();
		if (nsURI != null) {										// Explicit nsURI for explicit package (merge)
			completePackage = uri2completePackage.get(nsURI);
		}
		else if (name != null) {										// Null nsURI can merge into same named package
			completePackage = getMemberPackage(name);
		}
		if (completePackage == null) {
			completePackage = getOwnedCompletePackage(pivotPackage);
			completePackage.assertSamePackage(pivotPackage);
		}
		completePackage.getPartialPackages().add(pivotPackage);
//		completePackage.addTrackedPackage(pivotPackage);
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : pivotPackage.getOwnedPackages()) {
			if (nestedPackage != null) {
				addPackage(completePackage, nestedPackage);
			}
		}
	}
	void addPackage(@NonNull CompletePackage parentCompletePackage, @NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		CompletePackage completePackage = null;
		String name = pivotPackage.getName();
		String nsURI = pivotPackage.getURI();
		if (nsURI != null) {										// Explicit nsURI for explicit package (merge)
			completePackage = uri2completePackage.get(nsURI);
		}
		else if (name != null) {										// Null nsURI can merge into same named package
			completePackage = getMemberPackage(name);
		}
		if ((name != null) && (completePackage == null)) {
			completePackage = parentCompletePackage.getOwnedCompletePackage(name);
		}
		if (completePackage != null) {
			assert completePackage != null;
			completePackage.assertSamePackage(pivotPackage);
			completePackage.getPartialPackages().add(pivotPackage);
	//		completePackage.addTrackedPackage(pivotPackage);
			for (org.eclipse.ocl.examples.pivot.Package nestedPackage : pivotPackage.getOwnedPackages()) {
				if (nestedPackage != null) {
					addPackage(completePackage, nestedPackage);
				}
			}
		}
	}

	/**
	 * The OCL Standard Library is normally registered under it's own nsURI and the OCL Pivot MetaModel is changed to share
	 * the same URI. This routine allows the original OCL Pivot MetaModel nsURI to reference the merged packes too.
	 */

	public void addPackageNsURISynonym(@NonNull String newURI, @NonNull String oldURI) {
		String sharedURI = synonymURI2sharedURI.get(newURI);
		if (oldURI.equals(sharedURI)) {
			return;
		}
		if (sharedURI != null) {
			throw new IllegalMetamodelException(oldURI, sharedURI);	// FIXME Better name
		}
		if (sharedURI2synonymURIs.containsKey(newURI)) {
			throw new IllegalMetamodelException(newURI, sharedURI);	// FIXME Better name
		}
		synonymURI2sharedURI.put(newURI, oldURI);
		Set<String> synonymURIs = sharedURI2synonymURIs.get(oldURI);
		if (synonymURIs == null) {
			synonymURIs = new HashSet<String>();
			sharedURI2synonymURIs.put(oldURI, synonymURIs);
		}
		synonymURIs.add(newURI);
	}

	public void addTypeTracker(@NonNull DomainClass pivotType, @NonNull TypeTracker typeTracker) {
		TypeTracker oldTracker = type2tracker.put(pivotType, typeTracker);
		assert oldTracker == null;
	}

	void addedNestedPrimaryPackage(@NonNull DomainPackage pivotPackage) {
		String nsURI = PivotUtil.getNsURI(pivotPackage);
		DomainPackage primaryPackage = null;
		if (nsURI != null) {
			CompletePackage completePackage = getCompletePackageByURI(nsURI);
			primaryPackage = completePackage != null ? completePackage.getPivotPackage() : null;
		}
		if (primaryPackage == pivotPackage) {
			// Recursive call
		}
		else if (primaryPackage != null) {
			throw new IllegalArgumentException("Duplicate nsURI '" + nsURI + "'");
		}
		else {
//			getPackageTracker(pivotPackage);
		}
	}

	protected @NonNull RootCompletePackage createRootCompletePackage(@NonNull DomainPackage pivotPackage) {
		String name = pivotPackage.getName();
//		if (name == null) {
//			throw new IllegalStateException("Unnamed package");
//		}
		String nonNullName = name;
		if (nonNullName == null) {
			nonNullName = "$anon_" + Integer.toHexString(System.identityHashCode(pivotPackage));
		}
		String nsPrefix = pivotPackage.getNsPrefix();
		String nsURI = getSharedURI(pivotPackage.getURI());
		PackageId packageId = pivotPackage.getPackageId();
		RootCompletePackage rootCompletePackage;
		if (Orphanage.isTypeOrphanage(pivotPackage)) {
			rootCompletePackage = getOrphanCompletePackage();
		}
		else {
			PackageId metapackageId = metaModelManager.getMetapackageId(pivotPackage);
			ParentCompletePackage parentCompletePackage = PivotFactory.eINSTANCE.createParentCompletePackage();
			parentCompletePackage.init(nonNullName, nsPrefix, nsURI, packageId, metapackageId);
			rootCompletePackage = parentCompletePackage;
		}
		getOwnedCompletePackages().add(rootCompletePackage);
		return rootCompletePackage;
	}

	void didAddCompletePackage(@NonNull CompletePackage completePackage) {
		if ((completePackage != orphanCompletePackage) && (completePackage != primitiveCompletePackage)) {
			String nsURI = completePackage.getURI();
			if (nsURI != null) {
				CompletePackage oldCompletePackage = uri2completePackage.put(nsURI, completePackage);
				assert oldCompletePackage == null;
			}
		}
	}
	
	private void didAddRoot(@NonNull Root partialRoot) {
		for (org.eclipse.ocl.examples.pivot.Package asPackage : partialRoot.getOwnedPackages()) {
			String nsURI = asPackage.getURI();
			String sharedURI = getSharedURI(nsURI);
			if (sharedURI == nsURI) {
				PackageId packageId = asPackage.getPackageId();
				if (packageId == IdManager.METAMODEL) {
					if (nsURI != null) {
						addPackageNsURISynonym(nsURI, DomainConstants.METAMODEL_NAME);
					}
				}
			}
		}
		rootTrackers.add(new RootTracker(this, partialRoot));
		for (org.eclipse.ocl.examples.pivot.Package pivotPackage : partialRoot.getOwnedPackages()) {
			if (pivotPackage != null) {
				addPackage(this, pivotPackage);
			}
		}
	}

	void didAddRootCompletePackage(@NonNull RootCompletePackage rootCompletePackage) {
		didAddCompletePackage(rootCompletePackage);
		String name = rootCompletePackage.getName();
		if (name != null) {
			if (!name2rootCompletePackage.containsKey(name)) {
				CompletePackage oldCompletePackage = name2rootCompletePackage.put(name, rootCompletePackage);		// New name
				assert oldCompletePackage == null;
			}
			else {
				name2rootCompletePackage.put(name, null);														// Ambiguous name
			}
		}
		String nsURI = rootCompletePackage.getURI();
		String sharedNsURI = getSharedURI(nsURI);
		if ((sharedNsURI != null) && (sharedNsURI == nsURI)) {
			name2rootCompletePackage.put(nsURI, rootCompletePackage);
		}
	}

	void didRemoveCompletePackage(@NonNull CompletePackage completePackage) {
		if ((completePackage != orphanCompletePackage) && (completePackage != primitiveCompletePackage)) {
			String nsURI = completePackage.getURI();
			if (nsURI != null) {
				uri2completePackage.remove(nsURI);
				Set<String> synonymURIs = sharedURI2synonymURIs.remove(nsURI);
				if (synonymURIs != null) {
					for (String synonymURI : synonymURIs) {
						synonymURI2sharedURI.remove(synonymURI);
					}
				}
			}
		}
	}
	
	private void didRemoveRoot(@NonNull Root partialRoot) {
		for (RootTracker rootTracker : rootTrackers) {
			if (rootTracker.getTarget() == partialRoot) {
				rootTracker.dispose();
				partialRoot.getOwnedPackages().clear();
				break;
			}
		}
	}

	public void didRemoveRootCompletePackage(@NonNull RootCompletePackage rootCompletePackage) {
		if (rootCompletePackage == primitiveCompletePackage) {
			primitiveCompletePackage = null;
		}
		name2rootCompletePackage.remove(rootCompletePackage.getName());
		didRemoveCompletePackage(rootCompletePackage);
	}

	public synchronized void dispose() {
		if (!rootTrackers.isEmpty()) {
			Collection<RootTracker> savedRootTrackers = new ArrayList<RootTracker>(rootTrackers);
			rootTrackers.clear();
			for (RootTracker rootTracker : savedRootTrackers) {
				rootTracker.dispose();
			}
		}
/*		if (!package2tracker.isEmpty()) {
			Collection<PackageTracker> savedPackageTrackers = new ArrayList<PackageTracker>(package2tracker.values());
			package2tracker.clear();
			for (PackageTracker packageTracker : savedPackageTrackers) {
				packageTracker.dispose();
			}
		} */
		if (!type2tracker.isEmpty()) {
			Collection<TypeTracker> savedTypeTrackers = new ArrayList<TypeTracker>(type2tracker.values());
			type2tracker.clear();
			for (TypeTracker typeTracker : savedTypeTrackers) {
				typeTracker.dispose();
			}
		}
		uri2completePackage.clear();
		Collection<RootCompletePackage> savedCompletePackages = new ArrayList<RootCompletePackage>(name2rootCompletePackage.values());
		name2rootCompletePackage.clear();
//		for (RootCompletePackage completePackage : savedCompletePackages) {
//			completePackage.dispose();
//		}
	}

	public void disposedRootTracker(@NonNull RootTracker rootTracker) {
		rootTrackers.remove(rootTracker);
		for (org.eclipse.ocl.examples.pivot.Package partialPackage : rootTracker.getTarget().getOwnedPackages()) {
			CompletePackage completePackage = getCompletePackage(partialPackage);
			completePackage.getPartialPackages().remove(partialPackage);
		}
	}

	public void disposedTypeTracker(@NonNull TypeTracker typeTracker) {
		type2tracker.remove(typeTracker.getTarget());
	}
	
	public @Nullable ExtensibleTypeServer findTypeServer(@NonNull DomainType pivotType) {
		TypeTracker typeTracker = type2tracker.get(pivotType);
		return typeTracker != null ? typeTracker.getTypeServer() : null;
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<CompletePackage> getAllCompletePackages() {
		return uri2completePackage.values();
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<CompletePackage> getAllCompletePackagesWithUris() {
		return uri2completePackage.values();
	}

	public @NonNull CompletePackage getCompletePackage(@NonNull DomainPackage pivotPackage) {
		CompletePackage completePackage = null;
		if (pivotPackage instanceof CompletePackage) {
			((CompletePackage)pivotPackage).assertSamePackage(pivotPackage);
			completePackage = (CompletePackage)pivotPackage;
		}
		else {
			String nsURI = pivotPackage.getURI();
			if (nsURI != null) {
				String sharedURI = getSharedURI(nsURI);
				completePackage = uri2completePackage.get(sharedURI);
			}
			if (completePackage == null) {
				DomainPackage pivotPackageParent = pivotPackage.getOwningPackage();
				if (pivotPackageParent == null) {
					completePackage = getOwnedCompletePackage(pivotPackage);
					completePackage.getPartialPackages().add((org.eclipse.ocl.examples.pivot.Package)pivotPackage);		// FIXME cast
//					completePackage.addTrackedPackage(pivotPackage);
					completePackage.assertSamePackage(pivotPackage);
				}
				else {
					CompletePackage completeParentPackage = getCompletePackage(pivotPackageParent);
					CompletePackage completeChildPackage = completeParentPackage.getOwnedCompletePackage(pivotPackage.getName());
					assert completeChildPackage != null;
					return completeChildPackage;
//					CompletePackageParent completePackageParent;
/*					PackageTracker parentTracker = getPackageTracker(pivotPackageParent);
					completePackageParent = parentTracker.getPackageServer();
					((PackageServer)completePackageParent).assertSamePackage(pivotPackageParent); */
//					completePackage = completePackageParent.getMemberPackageServer(pivotPackage);
//					completePackage.addTrackedPackage(pivotPackage);
//					completePackage.assertSamePackage(pivotPackage);
				}
			}
		}
		completePackage.assertSamePackage(pivotPackage);
		return completePackage;
	}

	public @Nullable CompletePackage getCompletePackageByURI(@NonNull String nsURI) {
		int lastIndex = nsURI.lastIndexOf("#/");
		if (lastIndex > 0) {
			@SuppressWarnings("null") @NonNull String substring = nsURI.substring(0, lastIndex);
			nsURI = substring;
		}
		String sharedURI = getSharedURI(nsURI);
		return uri2completePackage.get(sharedURI);
	}

	public @Nullable RootCompletePackage getMemberPackage(@NonNull String memberPackageName) {
		return name2rootCompletePackage.get(memberPackageName);
	}

	public @NonNull Iterable<RootCompletePackage> getMemberPackages() {
		@SuppressWarnings("null")
		@NonNull Collection<RootCompletePackage> values = name2rootCompletePackage.values();
		return values;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	@SuppressWarnings("null")
	public @NonNull OrphanCompletePackage getOrphanCompletePackage()
	{
		OrphanCompletePackage orphanCompletePackage2 = orphanCompletePackage;
		if (orphanCompletePackage2 == null) {
			orphanCompletePackage2 = orphanCompletePackage = PivotFactory.eINSTANCE.createOrphanCompletePackage();
			getOwnedCompletePackages().add(orphanCompletePackage2);
		}
		return orphanCompletePackage2;
	}

	public @NonNull RootCompletePackage getOwnedCompletePackage(@NonNull DomainPackage pivotPackage) {
		//
		//	Try to find package by nsURI
		//
		String nsURI = pivotPackage.getURI();
		if (nsURI != null) {
			String sharedURI = getSharedURI(nsURI);
			CompletePackage completePackage = uri2completePackage.get(sharedURI);
			if (completePackage != null) {
				return (RootCompletePackage) completePackage;
			}
		}
		//
		//	Else generate an error for a name-less Package, fatally if also nsURI-less.
		//
		String name = pivotPackage.getName();
		if (name == null) {
			String message = null;
			if (pivotPackage instanceof EObject) {
				for (EObject eObject = (EObject) pivotPackage; eObject != null; eObject = eObject.eContainer()) {
					if (eObject instanceof Root) {
						message = "Unnamed package for '" + nsURI + "' in '" + ((Root)eObject).getExternalURI() + "'";
						break;
					}
				}
			}
			if (message == null) {
				message = "Unnamed package for '" + nsURI + "'";
			}
			logger.error(message);
			name = nsURI;
			if (name == null) {
				throw new IllegalStateException(message);
			}
		}
		//
		//	Try to find package by name, provided there is no nsURI conflict
		//
		RootCompletePackage rootCompletePackage = name2rootCompletePackage.get(name);
		if (rootCompletePackage != null) {
			String nsURI2 = rootCompletePackage.getURI();
			if ((nsURI == null) || (nsURI2 == null) || nsURI.equals(nsURI2)) {
				return rootCompletePackage;
			}
		}
		rootCompletePackage = createRootCompletePackage(pivotPackage);
		return rootCompletePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<RootCompletePackage> getOwnedCompletePackages()
	{
		if (ownedCompletePackages == null)
		{
			ownedCompletePackages = new EObjectContainmentWithInverseEList<RootCompletePackage>(RootCompletePackage.class, this, PivotPackage.COMPLETE_MODEL__OWNED_COMPLETE_PACKAGES, PivotPackage.ROOT_COMPLETE_PACKAGE__OWNING_COMPLETE_MODEL)
			{
				private static final long serialVersionUID = 1L;

				@Override
				protected void didAdd(int index, RootCompletePackage rootCompletePackage) {
					assert rootCompletePackage != null;
					super.didAdd(index, rootCompletePackage);
					didAddRootCompletePackage(rootCompletePackage);
				}

				@Override
				protected void didRemove(int index, RootCompletePackage rootCompletePackage) {
					assert rootCompletePackage != null;
					super.didRemove(index, rootCompletePackage);
					didRemoveRootCompletePackage(rootCompletePackage);
				}
			};
		}
		return ownedCompletePackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public @NonNull List<Root> getPartialRoots()
	{
		if (partialRoots == null)
		{
			partialRoots = new EObjectResolvingEList<Root>(Root.class, this, PivotPackage.COMPLETE_MODEL__PARTIAL_ROOTS)
			{
				private static final long serialVersionUID = 1L;

				@Override
				protected void didAdd(int index, Root partialRoot) {
					assert partialRoot != null;
					super.didAdd(index, partialRoot);
					didAddRoot(partialRoot);
				}

				@Override
				protected void didRemove(int index, Root partialRoot) {
					assert partialRoot != null;
					super.didRemove(index, partialRoot);
					didRemoveRoot(partialRoot);
				}
			};
		}
		return partialRoots;
	}

	@SuppressWarnings("null")
	public @NonNull PrimitiveCompletePackage getPrimitiveCompletePackage()
	{
		PrimitiveCompletePackage primitiveCompletePackage2 = primitiveCompletePackage;
		if (primitiveCompletePackage2 == null) {
			primitiveCompletePackage2 = primitiveCompletePackage = PivotFactory.eINSTANCE.createPrimitiveCompletePackage();
			getOwnedCompletePackages().add(primitiveCompletePackage2);
		}
		return primitiveCompletePackage2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CompletePackage getOwnedCompletePackage(final String name)
	{
		return name2rootCompletePackage.get(name);
	}

	public @Nullable org.eclipse.ocl.examples.pivot.Package getRootPackage(@NonNull String name) {
		CompletePackage completePackage = name2rootCompletePackage.get(name);
//		if (completePackage == null) {
//			completePackage = uri2package.get(name);		// FIXME avoid double lookup
//		}
		return completePackage != null ? completePackage.getPivotPackage() : null;
	}

	public @Nullable String getSharedURI(@Nullable String nsURI) {
		String sharedURI = synonymURI2sharedURI.get(nsURI);
		if (sharedURI != null) {
			return sharedURI;
		}
		else {
			return nsURI;
		}
	}
	
	public @NonNull TypeServer getTypeServer(@NonNull DomainType pivotType) {
		if (pivotType instanceof ElementExtension) {
			Stereotype stereotype = ((ElementExtension)pivotType).getStereotype();
			if (stereotype != null) {
				pivotType = stereotype;
			}
		}
		if (pivotType instanceof TypeServer) {
			return (TypeServer)pivotType;
		}
		assert metaModelManager.isTypeServeable(pivotType);
		TypeTracker typeTracker = type2tracker.get(pivotType);
		if (typeTracker != null) {
			return typeTracker.getTypeServer();
		}
		else if (pivotType instanceof PrimitiveType) {
			PrimitiveCompletePackageImpl primitiveCompletePackage = (PrimitiveCompletePackageImpl) getPrimitiveCompletePackage();
			return primitiveCompletePackage.getTypeServer((PrimitiveType) pivotType);
		}
		else if (pivotType instanceof DomainClass) {
			DomainPackage pivotPackage = ((DomainClass)pivotType).getOwningPackage();
			if (pivotPackage == null) {
				throw new IllegalStateException("type has no package");
			}
			CompletePackage completePackage = getCompletePackage(pivotPackage);
			return completePackage.getTypeServer(pivotType);
		}
		else {
			throw new UnsupportedOperationException("TemplateType");
		}
	}

	public void initMetaModelManager(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

	public void removedType(@NonNull DomainClass pivotType) {
		TypeTracker typeTracker = type2tracker.get(pivotType);
		if (typeTracker != null) {
			typeTracker.dispose();
		}
	}

	public void resolveSuperClasses(@NonNull org.eclipse.ocl.examples.pivot.Class specializedClass, @NonNull org.eclipse.ocl.examples.pivot.Class unspecializedClass) {
		List<TemplateBinding> specializedTemplateBindings = specializedClass.getOwnedTemplateBindings();
		for (org.eclipse.ocl.examples.pivot.Class superClass : unspecializedClass.getSuperClasses()) {
			List<TemplateBinding> superTemplateBindings = superClass.getOwnedTemplateBindings();
			if (superTemplateBindings.size() > 0) {
				List<TemplateParameterSubstitution> superSpecializedTemplateParameterSubstitutions = new ArrayList<TemplateParameterSubstitution>();
				for (TemplateBinding superTemplateBinding : superTemplateBindings) {
					for (TemplateParameterSubstitution superParameterSubstitution : superTemplateBinding.getOwnedTemplateParameterSubstitutions()) {
						TemplateParameterSubstitution superSpecializedTemplateParameterSubstitution = null;
						Type superActual = superParameterSubstitution.getActual();
						for (TemplateBinding specializedTemplateBinding : specializedTemplateBindings) {
							for (TemplateParameterSubstitution specializedParameterSubstitution : specializedTemplateBinding.getOwnedTemplateParameterSubstitutions()) {
								if (specializedParameterSubstitution.getFormal() == superActual) {
									Type specializedActual = DomainUtil.nonNullModel(specializedParameterSubstitution.getActual());
									TemplateParameter superFormal = DomainUtil.nonNullModel(superParameterSubstitution.getFormal());
									superSpecializedTemplateParameterSubstitution = PivotUtil.createTemplateParameterSubstitution(superFormal, specializedActual);
									break;
								}
							}
							if (superSpecializedTemplateParameterSubstitution != null) {
								break;
							}
						}
						if (superSpecializedTemplateParameterSubstitution != null) {
							superSpecializedTemplateParameterSubstitutions.add(superSpecializedTemplateParameterSubstitution);
						}
					}
				}
				@NonNull org.eclipse.ocl.examples.pivot.Class unspecializedSuperClass = PivotUtil.getUnspecializedTemplateableElement(superClass);
				TypeServer superTypeServer = metaModelManager.getTypeServer(unspecializedSuperClass);
				if ((superTypeServer instanceof CollectionTypeServer) && (superSpecializedTemplateParameterSubstitutions.size() == 1)) {
					Type templateArgument = superSpecializedTemplateParameterSubstitutions.get(0).getActual();
					if (templateArgument != null) {
						org.eclipse.ocl.examples.pivot.Class specializedSuperClass = ((CollectionTypeServer)superTypeServer).getSpecializedType(templateArgument, null, null);
						specializedClass.getSuperClasses().add(specializedSuperClass);
					}
				}
				else if (superTypeServer instanceof TemplateableTypeServer) {
					List<Type> superTemplateArgumentList = new ArrayList<Type>(superSpecializedTemplateParameterSubstitutions.size());
					for (TemplateParameterSubstitution superSpecializedTemplateParameterSubstitution : superSpecializedTemplateParameterSubstitutions) {
						superTemplateArgumentList.add(superSpecializedTemplateParameterSubstitution.getActual());
					}
					org.eclipse.ocl.examples.pivot.Class specializedSuperType = ((TemplateableTypeServer)superTypeServer).getSpecializedType(superTemplateArgumentList);
					specializedClass.getSuperClasses().add(specializedSuperType);
				}
			}
			else {
				specializedClass.getSuperClasses().add(superClass);
			}
		}
	}
} //CompleteModelImpl
