/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.DynamicType#getOwnedProperty <em>Owned Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getDynamicType()
 * @generated
 */
public interface DynamicType extends Type, DynamicElement
{
	/**
	 * Returns the value of the '<em><b>Owned Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.DynamicProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Property</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getDynamicType_OwnedProperty()
	 * @generated
	 */
	List<DynamicProperty> getOwnedProperty();

} // DynamicType
