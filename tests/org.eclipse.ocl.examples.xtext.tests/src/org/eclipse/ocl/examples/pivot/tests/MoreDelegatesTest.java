/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 	E.D.Willink - Bug 306079, 322159
 *  K.Hussey - Bug 331143
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.tests;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * Tests for the OCL delegate implementations.
 */
@SuppressWarnings({"nls"})
public class MoreDelegatesTest extends DelegatesTest
{
	// Passes in isolation; probably an adapter clean-up problem
	public void test_eAttributeDerivation_registered() {
		initPackageRegistrations();
		doTest_eAttributeDerivation(COMPANY_XMI);
	}

	// Passes in isolation; probably an adapter clean-up problem
	public void test_invariantValidation_withoutReflection_registered() {
		initPackageRegistrations();
		doTest_invariantValidation(NO_REFLECTION_COMPANY_XMI, true, Diagnostic.ERROR);
	}

	// Passes in isolation; probably an adapter clean-up problem
	public void test_operationInvocation_registered() throws InvocationTargetException {
		initPackageRegistrations();
		doTest_operationInvocation(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
	}
}
