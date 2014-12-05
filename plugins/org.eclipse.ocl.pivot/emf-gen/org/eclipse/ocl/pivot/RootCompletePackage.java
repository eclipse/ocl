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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.ids.PackageId;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Complete Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.RootCompletePackage#getOwningCompleteModel <em>Owning Complete Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getRootCompletePackage()
 * @generated
 */
public interface RootCompletePackage extends CompletePackage
{

	/**
	 * Returns the value of the '<em><b>Owning Complete Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.CompleteModel#getOwnedCompletePackages <em>Owned Complete Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Complete Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Complete Model</em>' container reference.
	 * @see #setOwningCompleteModel(CompleteModel)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getRootCompletePackage_OwningCompleteModel()
	 * @see org.eclipse.ocl.pivot.CompleteModel#getOwnedCompletePackages
	 * @generated
	 */
	CompleteModel getOwningCompleteModel();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.RootCompletePackage#getOwningCompleteModel <em>Owning Complete Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Complete Model</em>' container reference.
	 * @see #getOwningCompleteModel()
	 * @generated
	 */
	void setOwningCompleteModel(CompleteModel value);

	@NonNull PackageId getMetapackageId();
	
	public interface Internal extends RootCompletePackage, CompletePackage.Internal
	{
	}
} // RootCompletePackage
