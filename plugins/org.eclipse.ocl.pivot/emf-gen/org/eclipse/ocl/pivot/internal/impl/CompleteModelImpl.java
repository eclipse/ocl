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
package org.eclipse.ocl.pivot.internal.impl;

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
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.domain.values.CollectionTypeParameters;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.domain.values.impl.CollectionTypeParametersImpl;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OrphanCompletePackage;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceImpl;
import org.eclipse.ocl.pivot.internal.complete.CompletePackageInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteURIs;
import org.eclipse.ocl.pivot.internal.complete.PartialModels;
import org.eclipse.ocl.pivot.internal.complete.RootCompletePackages;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.Orphanage;
import org.eclipse.ocl.pivot.manager.PivotStandardLibrary;
import org.eclipse.ocl.pivot.manager.TupleTypeManager;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Model</b></em>'.
 * @extends org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.CompleteModelImpl#getOrphanCompletePackage <em>Orphan Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.CompleteModelImpl#getOwnedCompletePackages <em>Owned Complete Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.CompleteModelImpl#getPartialModels <em>Partial Models</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.impl.CompleteModelImpl#getPrimitiveCompletePackage <em>Primitive Complete Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteModelImpl extends NamedElementImpl implements CompleteModel, org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal
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
			case PivotPackage.COMPLETE_MODEL__PARTIAL_MODELS:
				return getPartialModels();
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
				getOwnedCompletePackages().addAll((Collection<? extends CompletePackage>)newValue);
				return;
			case PivotPackage.COMPLETE_MODEL__PARTIAL_MODELS:
				getPartialModels().clear();
				getPartialModels().addAll((Collection<? extends Model>)newValue);
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
			case PivotPackage.COMPLETE_MODEL__PARTIAL_MODELS:
				getPartialModels().clear();
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
			case PivotPackage.COMPLETE_MODEL__PARTIAL_MODELS:
				return partialModels != null && !partialModels.isEmpty();
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
	 * The cached value of the '{@link #getPartialModels() <em>Partial Roots</em>}' reference list.
	 */
	protected final @NonNull PartialModels partialModels;

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
	private final @NonNull CompleteEnvironmentInternal completeEnvironment;

	/**
	 * Map from complete to/from package URI. 
	 */
	private final @NonNull CompleteURIs completeURIs = new CompleteURIs(this);
	
	protected final @NonNull MetaModelManager metaModelManager;
	
	private Orphanage orphanage = null;

	public CompleteModelImpl() {
		throw new UnsupportedOperationException("Must be constructed by CompleteEnvironment");
	}

	public CompleteModelImpl(@NonNull CompleteEnvironmentInternal completeEnvironment)
	{
		this.completeEnvironment = completeEnvironment;
		this.metaModelManager = completeEnvironment.getMetaModelManager();
		partialModels = new PartialModels(this);
		ownedCompletePackages = new RootCompletePackages(this);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCompleteModel(this);
	}

	/**
	 * Partial models such as the OCL Standard Library have their own distinct package URI. These partial
	 * models are merged by mapping the package URI to a complete URI. DomainConstants.METAMODEL_NAME is the
	 * complete URI for all contributions merged as the overall OCL metamodel. 
	 */
	@Override
	public void addPackageURI2completeURI(@NonNull String packageURI, @NonNull String newCompleteURI) {
		completeURIs.addPackageURI2completeURI(packageURI, newCompleteURI);
	}

	@Override
	public boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions) {
		return completeEnvironment.conformsTo(firstType, firstSubstitutions, secondType, secondSubstitutions);
	}

	@Override
	public void didAddClass(@NonNull org.eclipse.ocl.pivot.Class partialClass, @NonNull CompleteClassInternal completeClass) {
		completeEnvironment.didAddClass(partialClass, completeClass);
	}

	@Override
	public void didAddCompletePackage(@NonNull CompletePackageInternal completePackage) {
		completeURIs.didAddCompletePackage(completePackage);
	}

	@Override
	public void didAddNestedPackage(@NonNull org.eclipse.ocl.pivot.Package pivotPackage) {
		ownedCompletePackages.didAddPackage(pivotPackage);
	}
	
	@Override
	public void didAddPartialModel(@NonNull Model partialModel) {
		completeURIs.didAddPartialModel(partialModel);
	}
	
	@Override
	public void didRemoveClass(@NonNull org.eclipse.ocl.pivot.Class pivotType) {
		completeEnvironment.didRemoveClass(pivotType);
	}

	@Override
	public void didRemoveCompletePackage(@NonNull CompletePackageInternal completePackage) {
		if (completePackage == primitiveCompletePackage) {
			primitiveCompletePackage = null;
		}
		completeURIs.didRemoveCompletePackage(completePackage);
	}

	@Override
	public void didRemoveNestedPackage(@NonNull org.eclipse.ocl.pivot.Package pivotPackage) {
		ownedCompletePackages.didRemovePackage(pivotPackage);
	}
	
	@Override
	public void didRemovePartialModel(@NonNull Model partialModel) {
		completeURIs.didRemovePartialModel(partialModel);
	}

	@Override
	public synchronized void dispose() {
		completeEnvironment.dispose();
		ownedCompletePackages.dispose();
		completeURIs.dispose();
		Orphanage orphanage2 = orphanage;
		if (orphanage2 != null) {
			orphanage2.removePackageListener(getOrphanCompletePackage().getPartialPackages());
			orphanage = null;
		}
	}

	@Override
	public @Nullable CollectionType findCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters) {
		return completeEnvironment.findCollectionType(completeClass, typeParameters);
	}

	@Override
	public @NonNull Iterable<CompletePackageInternal> getAllCompletePackages() {
		return completeURIs.getAllCompletePackages();
	}

	@Override
	public @NonNull Iterable<? extends CompletePackage> getAllCompletePackagesWithUris() {
		return completeURIs.getAllCompletePackagesWithUris();
	}

	@Override
	public @NonNull CollectionType getCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters) {
		return completeEnvironment.getCollectionType(completeClass, typeParameters);
	}

	public @NonNull CollectionType getCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return completeEnvironment.getCollectionType(completeClass, new CollectionTypeParametersImpl<Type>(elementType, lower, upper));
	}
	
	@Override
	public @NonNull CompleteClassInternal getCompleteClass(@NonNull Type pivotType) {
		return completeEnvironment.getCompleteClass(pivotType);
	}

	@Override
	public @NonNull CompleteEnvironmentInternal getCompleteEnvironment() {
		return completeEnvironment;
	}

	@Override
	public @NonNull CompletePackageInternal getCompletePackage(@NonNull org.eclipse.ocl.pivot.Package asPackage) {
		return ownedCompletePackages.getCompletePackage(asPackage);
	}

	@Override
	public @Nullable CompletePackage getCompletePackageByURI(@NonNull String packageURI) {
		return completeURIs.getCompletePackageByURI(packageURI);
	}

	@Override
	public @Nullable String getCompleteURI(@Nullable String packageURI) {
		return completeURIs.getCompleteURI(packageURI);
	}

	@Override
	public @NonNull CompleteURIs getCompleteURIs() {
		return completeURIs;
	}
	
	@Override
	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType) {
		return completeEnvironment.getLambdaType(typeName, contextType, parameterTypes, resultType, null);
	}

	@Override
	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType,
			@Nullable TemplateParameterSubstitutions bindings) {
		return completeEnvironment.getLambdaType(typeName, contextType, parameterTypes, resultType, bindings);
	}

	public @Nullable CompletePackage getMemberPackage(@NonNull String memberPackageName) {
		return ownedCompletePackages.getOwnedCompletePackage(memberPackageName);
	}

	public @NonNull Iterable<? extends CompletePackage> getMemberPackages() {
		return ownedCompletePackages;
	}

	@Override
	public @NonNull MetaModelManager getMetaModelManager() {
		return DomainUtil.nonNullState(metaModelManager);
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull OrphanCompletePackageImpl getOrphanCompletePackage()
	{
		OrphanCompletePackage orphanCompletePackage2 = orphanCompletePackage;
		if (orphanCompletePackage2 == null) {
			orphanCompletePackage2 = orphanCompletePackage = PivotFactory.eINSTANCE.createOrphanCompletePackage();
			ownedCompletePackages.add(orphanCompletePackage2);
		}
		return (OrphanCompletePackageImpl)orphanCompletePackage2;
	}

	@Override
	public @NonNull Orphanage getOrphanage() {
		Orphanage orphanage2 = orphanage;
		if (orphanage2 == null) {
			orphanage2 = orphanage = metaModelManager.createOrphanage();
			orphanage2.addPackageListener(getOrphanCompletePackage().getPartialPackages());
		}
		return orphanage2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull List<CompletePackage> getOwnedCompletePackages() {
		return ownedCompletePackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull PartialModels getPartialModels() {
		return partialModels;
	}
	
	@Override
	@SuppressWarnings("null")
	public @NonNull PrimitiveCompletePackageImpl getPrimitiveCompletePackage()
	{
		PrimitiveCompletePackage primitiveCompletePackage2 = primitiveCompletePackage;
		if (primitiveCompletePackage2 == null) {
			primitiveCompletePackage2 = primitiveCompletePackage = PivotFactory.eINSTANCE.createPrimitiveCompletePackage();
			ownedCompletePackages.add(primitiveCompletePackage2);
		}
		return (PrimitiveCompletePackageImpl) primitiveCompletePackage2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @Nullable CompletePackage getOwnedCompletePackage(@Nullable String completeURIorName) {
		CompletePackage completePackage = completeURIs.getCompletePackage(completeURIorName);
		if (completePackage != null) {
			return completePackage;
		}
		return ownedCompletePackages.getOwnedCompletePackage(completeURIorName);
	}

	@Override
	public @Nullable org.eclipse.ocl.pivot.Package getRootPackage(@NonNull String completeURIorName) {
		CompletePackage completePackage = completeURIs.getCompletePackage(completeURIorName);
		if (completePackage != null) {
			return completePackage.getPivotPackage();
		}
		completePackage = getOwnedCompletePackage(completeURIorName);
		return completePackage != null ? completePackage.getPivotPackage() : null;
	}
	
	@Override
	public @NonNull Type getSpecializedType(@NonNull Type type, @Nullable TemplateParameterSubstitutions substitutions) {
		return completeEnvironment.getSpecializedType(type, substitutions);
	}

	@Override
	public @NonNull PivotStandardLibrary getStandardLibrary() {
		return completeEnvironment.getStandardLibrary();
	}
	
	@Override
	public @NonNull TupleTypeManager getTupleManager() {
		return completeEnvironment.getTupleManager();
	}

	@Override
	public @NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<? extends TypedElement> parts,
			@Nullable TemplateParameterSubstitutions bindings) {
		return completeEnvironment.getTupleType(typeName, parts, bindings);
	}

/*	public void removedType(@NonNull org.eclipse.ocl.pivot.Class pivotType) {
		CompleteClass completeClass = class2completeClass.get(pivotType);
		if (completeClass != null) {
//			completeClass.dispose();
		}
	} */

	@Override
	public void resolveSuperClasses(@NonNull org.eclipse.ocl.pivot.Class specializedClass, @NonNull org.eclipse.ocl.pivot.Class unspecializedClass) {
		List<TemplateBinding> specializedTemplateBindings = specializedClass.getOwnedTemplateBindings();
		for (org.eclipse.ocl.pivot.Class superClass : unspecializedClass.getSuperClasses()) {
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
				@NonNull org.eclipse.ocl.pivot.Class unspecializedSuperClass = PivotUtil.getUnspecializedTemplateableElement(superClass);
				CompleteClassInternal superCompleteClass = metaModelManager.getCompleteClass(unspecializedSuperClass);
				org.eclipse.ocl.pivot.Class superPivotClass = superCompleteClass.getPivotClass();
				if (superPivotClass instanceof CollectionType) {
					if (superSpecializedTemplateParameterSubstitutions.size() == 1) {
						Type templateArgument = superSpecializedTemplateParameterSubstitutions.get(0).getActual();
						if (templateArgument != null) {
							org.eclipse.ocl.pivot.Class specializedSuperClass = completeEnvironment.getCollectionType(superCompleteClass, new CollectionTypeParametersImpl<Type>(templateArgument, null, null));
							specializedClass.getSuperClasses().add(specializedSuperClass);
						}
					}
				}
				else {
					List<Type> superTemplateArgumentList = new ArrayList<Type>(superSpecializedTemplateParameterSubstitutions.size());
					for (TemplateParameterSubstitution superSpecializedTemplateParameterSubstitution : superSpecializedTemplateParameterSubstitutions) {
						superTemplateArgumentList.add(superSpecializedTemplateParameterSubstitution.getActual());
					}
					CompleteInheritanceImpl superCompleteInheritance = superCompleteClass.getCompleteInheritance();
					org.eclipse.ocl.pivot.Class specializedSuperType = superCompleteInheritance.getCompleteClass().getPartialClasses().getSpecializedType(superTemplateArgumentList);
					specializedClass.getSuperClasses().add(specializedSuperType);
				}
			}
			else {
				specializedClass.getSuperClasses().add(superClass);
			}
		}
	}
} //CompleteModelImpl
