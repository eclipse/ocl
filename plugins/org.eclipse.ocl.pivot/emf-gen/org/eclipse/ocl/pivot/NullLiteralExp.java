/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Null Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getNullLiteralExp()
 * @generated
 */
public interface NullLiteralExp
		extends PrimitiveLiteralExp {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * False for a null value.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	@Override
	Boolean isNonNull();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a NullLiteralExp is the type OclVoid.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateTypeIsOclVoid(DiagnosticChain diagnostics, Map<Object, Object> context);
} // NullLiteralExp
