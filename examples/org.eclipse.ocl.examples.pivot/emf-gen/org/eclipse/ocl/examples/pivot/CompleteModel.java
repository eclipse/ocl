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
package org.eclipse.ocl.examples.pivot;

import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.library.executor.CollectionTypeParameters;
import org.eclipse.ocl.examples.pivot.internal.complete.CompleteURIs;
import org.eclipse.ocl.examples.pivot.internal.complete.PartialModels;
import org.eclipse.ocl.examples.pivot.internal.complete.RootCompletePackages;
import org.eclipse.ocl.examples.pivot.manager.CompleteEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.Orphanage;
import org.eclipse.ocl.examples.pivot.manager.PivotStandardLibrary2;
import org.eclipse.ocl.examples.pivot.manager.TemplateParameterSubstitutions;
import org.eclipse.ocl.examples.pivot.manager.TupleTypeManager;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteModel#getOrphanCompletePackage <em>Orphan Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteModel#getOwnedCompletePackages <em>Owned Complete Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteModel#getPartialModels <em>Partial Models</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteModel#getPrimitiveCompletePackage <em>Primitive Complete Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteModel()
 * @generated
 */
public interface CompleteModel extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Orphan Complete Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orphan Complete Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orphan Complete Package</em>' reference.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteModel_OrphanCompletePackage()
	 * @generated
	 */
	@NonNull OrphanCompletePackage getOrphanCompletePackage();

	/**
	 * Returns the value of the '<em><b>Owned Complete Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.RootCompletePackage}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.RootCompletePackage#getOwningCompleteModel <em>Owning Complete Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Complete Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Complete Packages</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteModel_OwnedCompletePackages()
	 * @see org.eclipse.ocl.examples.pivot.RootCompletePackage#getOwningCompleteModel
	 * @generated
	 */
	@NonNull List<RootCompletePackage> getOwnedCompletePackages();

	/**
	 * Returns the value of the '<em><b>Partial Models</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Model}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partial Roots</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partial Models</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteModel_PartialModels()
	 * @generated
	 */
	@NonNull List<Model> getPartialModels();

	/**
	 * Returns the value of the '<em><b>Primitive Complete Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive Complete Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Complete Package</em>' reference.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteModel_PrimitiveCompletePackage()
	 * @generated
	 */
	@NonNull PrimitiveCompletePackage getPrimitiveCompletePackage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Nullable CompletePackage getOwnedCompletePackage(String name);
	
	void addPackageURI2completeURI(@NonNull String packageURI, @NonNull String newCompleteURI);
	boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions);
	@NonNull Iterable<? extends CompletePackage> getAllCompletePackages();
//	@NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper);
	@NonNull CompleteClass getCompleteClass(@NonNull DomainType partialClass);
	@NonNull CompleteEnvironment getCompleteEnvironment();
	@NonNull CompletePackage getCompletePackage(@NonNull DomainPackage asPackage);
	@Nullable CompletePackage getCompletePackageByURI(@NonNull String packageURI);
	@NonNull Iterable<? extends CompletePackage> getAllCompletePackagesWithUris();
	@NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType);
	@Nullable org.eclipse.ocl.examples.pivot.Package getRootPackage(@NonNull String completeURIorName);
	
	public interface Internal extends CompleteModel
	{
		void didAddClass(@NonNull DomainClass partialClass, @NonNull CompleteClass.Internal completeClass);
		void didAddCompletePackage(@NonNull CompletePackage.Internal completePackage);
		void didRemoveCompletePackage(@NonNull CompletePackage.Internal completePackage);
		void didRemoveClass(@NonNull DomainClass partialClass);
		@Nullable CollectionType findCollectionType(@NonNull CompleteClass.Internal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters);
		@NonNull CollectionType getCollectionType(@NonNull CompleteClass.Internal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters);
		@NonNull CompleteClass.Internal getCompleteClass(@NonNull DomainType partialClass);
		@NonNull CompletePackage.Internal getCompletePackage(@NonNull DomainPackage partialPackage);
		@Nullable CompletePackage getCompletePackageByURI(@NonNull String packageURI);
		@NonNull CompleteURIs getCompleteURIs();
		@NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType,
				@Nullable TemplateParameterSubstitutions bindings);
		@NonNull MetaModelManager getMetaModelManager();
		@NonNull OrphanCompletePackage.Internal getOrphanCompletePackage();
		@NonNull RootCompletePackages getOwnedCompletePackages();
		@NonNull PartialModels getPartialModels();
		@NonNull PrimitiveCompletePackage.Internal getPrimitiveCompletePackage();
		@NonNull Type getSpecializedType(@NonNull Type type, @Nullable TemplateParameterSubstitutions substitutions);
		@NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<? extends DomainTypedElement> parts,
				@Nullable TemplateParameterSubstitutions bindings);	

		void resolveSuperClasses(@NonNull org.eclipse.ocl.examples.pivot.Class specializedClass, @NonNull org.eclipse.ocl.examples.pivot.Class unspecializedClass);
		void dispose();
		void didAddPartialModel(@NonNull Model partialModel);
		void didAddNestedPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage);
		void didRemoveNestedPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage);
		void didRemovePartialModel(@NonNull Model partialModel);
		@Nullable String getCompleteURI(@Nullable String nsURI);
		@NonNull TupleTypeManager getTupleManager();
		@NonNull Orphanage getOrphanage();
		@NonNull PivotStandardLibrary2 getStandardLibrary();
		@NonNull CompleteEnvironment.Internal getCompleteEnvironment();
	}
} // CompleteModel
