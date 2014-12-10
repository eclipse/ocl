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
package org.eclipse.ocl.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.values.TemplateParameterSubstitutions;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.CompleteModel#getOrphanCompletePackage <em>Orphan Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CompleteModel#getOwnedCompletePackages <em>Owned Complete Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CompleteModel#getPartialModels <em>Partial Models</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CompleteModel#getPrimitiveCompletePackage <em>Primitive Complete Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getCompleteModel()
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
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCompleteModel_OrphanCompletePackage()
	 * @generated
	 */
	@NonNull OrphanCompletePackage getOrphanCompletePackage();

	/**
	 * Returns the value of the '<em><b>Owned Complete Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.RootCompletePackage}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.RootCompletePackage#getOwningCompleteModel <em>Owning Complete Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Complete Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Complete Packages</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCompleteModel_OwnedCompletePackages()
	 * @see org.eclipse.ocl.pivot.RootCompletePackage#getOwningCompleteModel
	 * @generated
	 */
	@NonNull List<RootCompletePackage> getOwnedCompletePackages();

	/**
	 * Returns the value of the '<em><b>Partial Models</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Model}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partial Roots</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partial Models</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCompleteModel_PartialModels()
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
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCompleteModel_PrimitiveCompletePackage()
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
//	@NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);
	@NonNull CompleteClass getCompleteClass(@NonNull DomainType partialClass);
	@NonNull CompleteEnvironment getCompleteEnvironment();
	@NonNull CompletePackage getCompletePackage(@NonNull DomainPackage asPackage);
	@Nullable CompletePackage getCompletePackageByURI(@NonNull String packageURI);
	@NonNull Iterable<? extends CompletePackage> getAllCompletePackagesWithUris();
	@NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType);
	@Nullable org.eclipse.ocl.pivot.Package getRootPackage(@NonNull String completeURIorName);
} // CompleteModel
