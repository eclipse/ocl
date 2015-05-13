/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.util.PivotValidator;

/**
 * An UnsafePivotValidator omits validation of safe navigation operators.
 */
public class UnsafePivotValidator extends PivotValidator
{
	public static final @NonNull PivotValidator UNSAFE_INSTANCE = new UnsafePivotValidator();

	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return super.validate(eClass, eObject, diagnostics, context);
	}

	@Override
	public boolean validatePropertyCallExp_validateSafeSourceCannotBeNull(
			PropertyCallExp propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	@Override
	public boolean validatePropertyCallExp_validateUnsafeSourceMustBeNotNull(
			PropertyCallExp propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}
}
