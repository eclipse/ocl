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
 * A representation of the model object '<em><b>Invalid Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getInvalidLiteralExp()
 * @generated
 */
public interface InvalidLiteralExp
		extends LiteralExp {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * InvalidLiteralExps may have an OclInvalid type
	 * <!-- end-model-doc -->
	 * @generated
	 */
	@Override
	boolean mayHaveOclInvalidType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of an InvalidLiteralExp is the type OclInvalid.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateTypeIsOclInvalid(DiagnosticChain diagnostics, Map<Object, Object> context);
} // InvalidLiteralExp
