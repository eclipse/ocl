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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.library.executor.CollectionTypeParameters;
import org.eclipse.ocl.examples.pivot.internal.complete.PartialClasses;
import org.eclipse.ocl.examples.pivot.manager.CompleteInheritance;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteClass#getOwningCompletePackage <em>Owning Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteClass#getPartialClasses <em>Partial Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteClass()
 * @generated
 */
public interface CompleteClass extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Owning Complete Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.CompletePackage#getOwnedCompleteClasses <em>Owned Complete Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Complete Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Complete Package</em>' container reference.
	 * @see #setOwningCompletePackage(CompletePackage)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteClass_OwningCompletePackage()
	 * @see org.eclipse.ocl.examples.pivot.CompletePackage#getOwnedCompleteClasses
	 * @generated
	 */
	CompletePackage getOwningCompletePackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CompleteClass#getOwningCompletePackage <em>Owning Complete Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Complete Package</em>' container reference.
	 * @see #getOwningCompletePackage()
	 * @generated
	 */
	void setOwningCompletePackage(CompletePackage value);

	/**
	 * Returns the value of the '<em><b>Partial Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partial Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partial Classes</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteClass_PartialClasses()
	 * @generated
	 */
	@NonNull List<org.eclipse.ocl.examples.pivot.Class> getPartialClasses();

	boolean conformsTo(@NonNull DomainType elementType);
	
	@NonNull org.eclipse.ocl.examples.pivot.Class getPivotClass();

	@Nullable CollectionType findCollectionType(@NonNull CollectionTypeParameters<Type> typeParameters);
	@NonNull CollectionType getCollectionType(@NonNull CollectionTypeParameters<Type> typeParameters);
	@NonNull CompleteInheritance getCompleteInheritance();

	@Nullable DomainOperation getOperation(@NonNull OperationId operationId);
	@Nullable DomainOperation getOperation(@NonNull DomainOperation operationId);
	@Nullable Iterable<DomainOperation> getOperationOverloads(@NonNull DomainOperation pivotOperation);
	@NonNull Iterable<? extends DomainOperation> getOperations(final @Nullable FeatureFilter featureFilter);
	@NonNull Iterable<? extends DomainOperation> getOperations(final @Nullable FeatureFilter featureFilter, @Nullable String name);
	@NonNull Iterable<CompleteClass> getProperSuperCompleteClasses();
	@Nullable Iterable<DomainProperty> getProperties(@NonNull DomainProperty pivotProperty);
	@Nullable Iterable<DomainProperty> getProperties(@Nullable String propertyName);
	@NonNull Iterable<? extends DomainProperty> getProperties(final @Nullable FeatureFilter featureFilter);
	@NonNull Iterable<? extends DomainProperty> getProperties(final @Nullable FeatureFilter featureFilter, @Nullable String name);
	@Nullable DomainProperty getProperty(@Nullable String propertyName);
	@NonNull Iterable<? extends State>  getStates();
	@NonNull Iterable<? extends State>  getStates(@Nullable String name);
	@NonNull Iterable<CompleteClass> getSuperCompleteClasses();
	
	public interface Internal extends CompleteClass
	{
		void didAddClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass);
		boolean didRemoveClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass);
		void dispose();
		void uninstall();
		@NonNull CompleteModel.Internal getCompleteModel();
		@NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances();
		@NonNull MetaModelManager getMetaModelManager();
		CompletePackage.Internal getOwningCompletePackage();
		@NonNull PartialClasses getPartialClasses();
		@NonNull Iterable<? extends DomainClass> getProperSuperClasses();
		void setCompleteInheritance(@NonNull CompleteInheritance completeInheritance);
	}
} // CompleteClass
