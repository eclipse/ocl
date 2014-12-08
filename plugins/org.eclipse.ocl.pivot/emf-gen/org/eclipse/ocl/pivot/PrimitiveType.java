/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import java.util.List;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A primitive type is a data type implemented by the underlying infrastructure and made available for modeling.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.PrimitiveType#getCoercions <em>Coercions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getPrimitiveType()
 * @generated
 */
public interface PrimitiveType
		extends DataType {

	/**
	 * Returns the value of the '<em><b>Coercions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coercions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coercions</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPrimitiveType_Coercions()
	 * @generated
	 */
	List<Operation> getCoercions();
} // PrimitiveType
