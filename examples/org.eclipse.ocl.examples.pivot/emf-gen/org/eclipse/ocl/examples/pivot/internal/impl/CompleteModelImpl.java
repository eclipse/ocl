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
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.library.executor.CollectionTypeParameters;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompleteModel;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.OrphanCompletePackage;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.RootCompletePackage;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.complete.AllCompleteClasses;
import org.eclipse.ocl.examples.pivot.internal.complete.CompleteURIs;
import org.eclipse.ocl.examples.pivot.internal.complete.PartialClasses;
import org.eclipse.ocl.examples.pivot.internal.complete.PartialRoots;
import org.eclipse.ocl.examples.pivot.internal.complete.RootCompletePackages;
import org.eclipse.ocl.examples.pivot.manager.CompleteInheritance;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.TemplateParameterSubstitutions;
import org.eclipse.ocl.examples.pivot.manager.TupleTypeManager;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Model</b></em>'.
 * @extends org.eclipse.ocl.examples.pivot.CompleteModel.Internal
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
public class CompleteModelImpl extends NamedElementImpl implements CompleteModel, org.eclipse.ocl.examples.pivot.CompleteModel.Internal
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
	@SuppressWarnings("null")
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

	/**
	 * The cached value of the '{@link #getOwnedCompletePackages() <em>Owned Complete Packages</em>}' containment reference list.
	 */
	protected final @NonNull RootCompletePackages ownedCompletePackages;

	/**
	 * The cached value of the '{@link #getPartialRoots() <em>Partial Roots</em>}' reference list.
	 */
	protected final @NonNull PartialRoots partialRoots;

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
	 * Map from each partial Class to the CompleteClass that supervises its merge. CompleteClass are created lazily. 
	 */
	private final @NonNull AllCompleteClasses allCompleteClasses;

	/**
	 * Map from complete to/from package URI. 
	 */
	private final @NonNull CompleteURIs completeURIs = new CompleteURIs(this);
	
	protected /*final*/ /*@NonNull*/ MetaModelManager metaModelManager;

	protected CompleteModelImpl()
	{
		partialRoots = new PartialRoots(this);
		ownedCompletePackages = new RootCompletePackages(this);
		allCompleteClasses = new AllCompleteClasses(this);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCompleteModel(this);
	}
	
/*	void addPackage(@NonNull CompletePackage parentCompletePackage, @NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		CompletePackage completePackage = null;
		String name = pivotPackage.getName();
		String packageURI = pivotPackage.getURI();
		if (packageURI != null) {										// Explicit packageURI for explicit package (merge)
			completePackage = completeURI2completePackage.get(packageURI);
		}
		else if (name != null) {										// Null packageURI can merge into same named package
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
	} */

	/**
	 * Partial models such as the OCL Standard Library have their own distinct package URI. These partial
	 * models are merged by mapping the package URI to a complete URI. DomainConstants.METAMODEL_NAME is the
	 * complete URI for all contributions merged as the overall OCL metamodel. 
	 */
	public void addPackageURI2completeURI(@NonNull String packageURI, @NonNull String newCompleteURI) {
		completeURIs.addPackageURI2completeURI(packageURI, newCompleteURI);
	}

	public void didAddClass(@NonNull DomainClass partialClass, @NonNull CompleteClass.Internal completeClass) {
		allCompleteClasses.didAddClass(partialClass, completeClass);
	}

	public void didAddCompletePackage(@NonNull CompletePackage.Internal completePackage) {
		completeURIs.didAddCompletePackage(completePackage);
	}
	
//	public void didAddClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
//		throw new UnsupportedOperationException();		// Classes not added to Root
//	}

	public void didAddNestedPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		ownedCompletePackages.didAddPackage(pivotPackage);
	}
	
/*	public void didAddPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		((PackageImpl)partialPackage).getPackageListeners().addListener(this);
//		if (name2completeClass != null) {
//			doRefreshPartialClasses(partialPackage);
//		}
	} */
	
	public void didAddPartialRoot(@NonNull Root partialRoot) {
		completeURIs.didAddPartialRoot(partialRoot);
	}
	
//	public void didRemoveClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
//		throw new UnsupportedOperationException();		// Classes not added to Root
//	}
	
//	public void didRemovePackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
//		// TODO Auto-generated method stub
//		
//	}

/*	void addedNestedPrimaryPackage(@NonNull DomainPackage pivotPackage) {
		String packageURI = PivotUtil.getNsURI(pivotPackage);
		DomainPackage primaryPackage = null;
		if (packageURI != null) {
			CompletePackage completePackage = getCompletePackageByURI(packageURI);
			primaryPackage = completePackage != null ? completePackage.getPivotPackage() : null;
		}
		if (primaryPackage == pivotPackage) {
			// Recursive call
		}
		else if (primaryPackage != null) {
			throw new IllegalArgumentException("Duplicate packageURI '" + packageURI + "'");
		}
		else {
//			getPackageTracker(pivotPackage);
		}
	} */
	
	public void didRemoveClass(@NonNull DomainClass pivotType) {
		allCompleteClasses.didRemoveClass(pivotType);
	}

	public void didRemoveCompletePackage(@NonNull CompletePackage.Internal completePackage) {
		if (completePackage == primitiveCompletePackage) {
			primitiveCompletePackage = null;
		}
		completeURIs.didRemoveCompletePackage(completePackage);
	}

	public void didRemoveNestedPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		ownedCompletePackages.didRemovePackage(pivotPackage);
	}
	
	public void didRemovePartialRoot(@NonNull Root partialRoot) {
		completeURIs.didRemovePartialRoot(partialRoot);
	}

	public synchronized void dispose() {
		allCompleteClasses.dispose();
		ownedCompletePackages.dispose();
		completeURIs.dispose();
	}

	public @Nullable CollectionType findCollectionType(@NonNull CompleteClass.Internal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters) {
		return allCompleteClasses.findCollectionType(completeClass, typeParameters);
	}

	public @NonNull Iterable<? extends CompletePackage> getAllCompletePackages() {
		return completeURIs.getAllCompletePackages();
	}

	public @NonNull Iterable<? extends CompletePackage> getAllCompletePackagesWithUris() {
		return completeURIs.getAllCompletePackagesWithUris();
	}

	public @NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return allCompleteClasses.getCollectionType(containerType, elementType, lower, upper);
	}

	public @NonNull CollectionType getCollectionType(@NonNull CompleteClass.Internal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters) {
		return allCompleteClasses.getCollectionType(completeClass, typeParameters);
	}
	
	public @NonNull CompleteClass.Internal getCompleteClass(@NonNull DomainType pivotType) {
		return allCompleteClasses.getCompleteClass(pivotType);
	}
	
	public @NonNull CompletePackage.Internal getCompletePackage(@NonNull DomainPackage asPackage) {
		return ownedCompletePackages.getCompletePackage(asPackage);
	}

	public @Nullable CompletePackage getCompletePackageByURI(@NonNull String packageURI) {
		return completeURIs.getCompletePackageByURI(packageURI);
	}

	public @Nullable String getCompleteURI(@Nullable String packageURI) {
		return completeURIs.getCompleteURI(packageURI);
	}

	public @NonNull CompleteURIs getCompleteURIs() {
		return completeURIs;
	}
	
	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType) {
		return allCompleteClasses.getLambdaType(typeName, contextType, parameterTypes, resultType, null);
	}

	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType,
			@Nullable TemplateParameterSubstitutions bindings) {
		return allCompleteClasses.getLambdaType(typeName, contextType, parameterTypes, resultType, bindings);
	}

	public @Nullable RootCompletePackage getMemberPackage(@NonNull String memberPackageName) {
		return ownedCompletePackages.getOwnedCompletePackage(memberPackageName);
	}

	public @NonNull Iterable<? extends RootCompletePackage> getMemberPackages() {
		return ownedCompletePackages;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return DomainUtil.nonNullState(metaModelManager);
	}

	@SuppressWarnings("null")
	public @NonNull OrphanCompletePackage.Internal getOrphanCompletePackage()
	{
		OrphanCompletePackage orphanCompletePackage2 = orphanCompletePackage;
		if (orphanCompletePackage2 == null) {
			orphanCompletePackage2 = orphanCompletePackage = PivotFactory.eINSTANCE.createOrphanCompletePackage();
			ownedCompletePackages.add(orphanCompletePackage2);
		}
		return (OrphanCompletePackage.Internal)orphanCompletePackage2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public @NonNull RootCompletePackages getOwnedCompletePackages() {
		return ownedCompletePackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public @NonNull PartialRoots getPartialRoots() {
		return partialRoots;
	}
	
	@SuppressWarnings("null")
	public @NonNull PrimitiveCompletePackage.Internal getPrimitiveCompletePackage()
	{
		PrimitiveCompletePackage primitiveCompletePackage2 = primitiveCompletePackage;
		if (primitiveCompletePackage2 == null) {
			primitiveCompletePackage2 = primitiveCompletePackage = PivotFactory.eINSTANCE.createPrimitiveCompletePackage();
			ownedCompletePackages.add(primitiveCompletePackage2);
		}
		return (PrimitiveCompletePackage.Internal)primitiveCompletePackage2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public @Nullable CompletePackage getOwnedCompletePackage(@Nullable String completeURIorName) {
		CompletePackage completePackage = completeURIs.getCompletePackage(completeURIorName);
		if (completePackage != null) {
			return completePackage;
		}
		return ownedCompletePackages.getOwnedCompletePackage(completeURIorName);
	}

	public @Nullable org.eclipse.ocl.examples.pivot.Package getRootPackage(@NonNull String completeURIorName) {
		CompletePackage completePackage = completeURIs.getCompletePackage(completeURIorName);
		if (completePackage != null) {
			return completePackage.getPivotPackage();
		}
		completePackage = getOwnedCompletePackage(completeURIorName);
//		if (completePackage == null) {
//			completePackage = uri2package.get(name);		// FIXME avoid double lookup
//		}
		return completePackage != null ? completePackage.getPivotPackage() : null;
	}

	public @NonNull CollectionType getCollectionType(@NonNull CompleteClass.Internal completeClass, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return allCompleteClasses.getCollectionType(completeClass, new CollectionTypeParameters<Type>(elementType, lower, upper));
	}
	
	public @NonNull Type getSpecializedType(@NonNull Type type, @Nullable TemplateParameterSubstitutions substitutions) {
		return allCompleteClasses.getSpecializedType(type, substitutions);
	}
	
	public @NonNull TupleTypeManager getTupleManager() {
		return allCompleteClasses.getTupleManager();
	}

	public @NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<? extends DomainTypedElement> parts,
			@Nullable TemplateParameterSubstitutions bindings) {
		return allCompleteClasses.getTupleType(typeName, parts, bindings);
	}

	public void initMetaModelManager(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

/*	public void removedType(@NonNull DomainClass pivotType) {
		CompleteClass completeClass = class2completeClass.get(pivotType);
		if (completeClass != null) {
//			completeClass.dispose();
		}
	} */

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
				CompleteClass.Internal superCompleteClass = (CompleteClass.Internal)metaModelManager.getCompleteClass(unspecializedSuperClass);
				org.eclipse.ocl.examples.pivot.Class superPivotClass = superCompleteClass.getPivotClass();
				if (superPivotClass instanceof DomainCollectionType) {
					if (superSpecializedTemplateParameterSubstitutions.size() == 1) {
						Type templateArgument = superSpecializedTemplateParameterSubstitutions.get(0).getActual();
						if (templateArgument != null) {
							org.eclipse.ocl.examples.pivot.Class specializedSuperClass = allCompleteClasses.getCollectionType(superCompleteClass, new CollectionTypeParameters<Type>(templateArgument, null, null));
							specializedClass.getSuperClasses().add(specializedSuperClass);
						}
					}
				}
				else {
					List<Type> superTemplateArgumentList = new ArrayList<Type>(superSpecializedTemplateParameterSubstitutions.size());
					for (TemplateParameterSubstitution superSpecializedTemplateParameterSubstitution : superSpecializedTemplateParameterSubstitutions) {
						superTemplateArgumentList.add(superSpecializedTemplateParameterSubstitution.getActual());
					}
					CompleteInheritance superCompleteInheritance = superCompleteClass.getCompleteInheritance();
					org.eclipse.ocl.examples.pivot.Class specializedSuperType = ((PartialClasses)superCompleteInheritance.getCompleteClass().getPartialClasses()).getSpecializedType(superTemplateArgumentList);
					specializedClass.getSuperClasses().add(specializedSuperType);
				}
			}
			else {
				specializedClass.getSuperClasses().add(superClass);
			}
		}
	}
} //CompleteModelImpl
