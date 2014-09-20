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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.internal.complete.PartialPackages;
import org.eclipse.ocl.examples.pivot.manager.CompleteInheritance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Package</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainCompletePackage
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getOwnedCompleteClasses <em>Owned Complete Classes</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getOwnedCompletePackages <em>Owned Complete Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getPartialPackages <em>Partial Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage()
 * @generated
 */
public interface CompletePackage extends NamedElement, org.eclipse.ocl.examples.domain.elements.DomainCompletePackage
{
	/**
	 * Returns the value of the '<em><b>Owned Complete Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.CompleteClass}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.CompleteClass#getOwningCompletePackage <em>Owning Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Complete Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * This is a logically derived collection. One CompleteClass for each distinctly named partial Class
	 * inv: ownedCompleteClasses->isUnique(name)
	 * inv: ownedCompleteClasses->forAll(name <> null)
	 * inv: ownedCompleteClasses->forAll(cc | cc.partialClasses = self.partialPackages.ownedClasses->select(name = cc.name))
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Complete Classes</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_OwnedCompleteClasses()
	 * @see org.eclipse.ocl.examples.pivot.CompleteClass#getOwningCompletePackage
	 * @generated
	 */
	@NonNull List<CompleteClass> getOwnedCompleteClasses();

	/**
	 * Returns the value of the '<em><b>Owned Complete Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.NestedCompletePackage}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.NestedCompletePackage#getOwningCompletePackage <em>Owning Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Complete Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Complete Packages</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_OwnedCompletePackages()
	 * @see org.eclipse.ocl.examples.pivot.NestedCompletePackage#getOwningCompletePackage
	 * @generated
	 */
	@NonNull List<NestedCompletePackage> getOwnedCompletePackages();

	/**
	 * Returns the value of the '<em><b>Partial Packages</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partial Packages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partial Packages</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_PartialPackages()
	 * @generated
	 */
	@NonNull List<org.eclipse.ocl.examples.pivot.Package> getPartialPackages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompleteClass getOwnedCompleteClass(String name);

	@NonNull CompleteClass getCompleteClass(@NonNull DomainClass pivotType);


	org.eclipse.ocl.examples.pivot.Package getPivotPackage();

	org.eclipse.ocl.examples.pivot.Class getMemberType(String name);

	RootCompletePackage getRootCompletePackage();

//	@NonNull PackageManager getPackageManager();

//	String getURI();

//	String getNsPrefix();

	int getIndex(org.eclipse.ocl.examples.pivot.Package p1);

	void assertSamePackage(DomainPackage pivotPackage);

	EPackage getEPackage();

	DomainType getType(String metatypeName);

	@Nullable CompletePackage getOwnedCompletePackage(@Nullable String name);

	@NonNull CompleteModel getCompleteModel();
	
	public interface Internal extends CompletePackage
	{
		@NonNull CompleteClass.Internal getCompleteClass(@NonNull DomainClass pivotType);
		@NonNull CompleteInheritance getCompleteInheritance(@NonNull CompleteClass.Internal completeClass);
		@NonNull CompleteModel.Internal getCompleteModel();
		void dispose();
		CompleteClass.Internal getOwnedCompleteClass(String name);
		@Nullable CompletePackage.Internal getOwnedCompletePackage(@Nullable String name);
		@NonNull PartialPackages getPartialPackages();
		boolean hasNestedClasses();
		void init(String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId);
	}
} // CompletePackage
