/**
 * <copyright>
 * 
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */

package org.eclipse.ocl.examples.pivot.tests;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.osgi.util.NLS;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for Boolean operations.
 */
@SuppressWarnings("nls")
@RunWith(value = Parameterized.class)
public class EvaluateConstructsTest4 extends PivotTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false}, {true}};
		return Arrays.asList(data);
	}

	public EvaluateConstructsTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateConstructs";
	}
	
	@BeforeClass public static void resetCounter() throws Exception {
		PivotTestSuite.resetCounter();
    }

    @Override
    @Before public void setUp() throws Exception {
        super.setUp();
    }

	@Override
	@After public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test public void testConstruct_if() throws Exception {		
		assertQueryFalse(null, "if true then false else false endif");
		assertQueryEquals(null, 1, "if true then 1 else 2 endif");
		assertQueryEquals(null, 2, "if false then 1 else 2 endif");
		assertQueryEquals(null, 3.0, "if true then 3 else 4.0 endif");
		assertQueryEquals(null, 4.0, "if false then 3 else 4.0 endif");
		//
		assertValidationErrorQuery2(null, "if null then 1 else 2 endif",
			EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "IfExp", "ConditionTypeIsBoolean", "if null then 1 else 2 endif");
		assertQueryInvalid(null, "if null then 1 else 2 endif");
		assertQueryInvalid(null, "if invalid then 1 else 2 endif");
		//
		assertQueryEquals(null, 4.5, "if true then 4.5 else null endif");
		assertQueryEquals(null, "ok", "if false then null else 'ok' endif");
		assertQueryEquals(null, 4.5, "if true then 4.5 else invalid endif");
		assertQueryEquals(null, "ok", "if false then invalid else 'ok' endif");
		//
		assertQueryTrue(null, "if self.oclIsUndefined() then true else false endif");
		assertQueryInvalid(null, "if 4 then 4 else 4 endif",
			NLS.bind(EvaluatorMessages.TypedValueRequired, "Boolean", "UnlimitedNatural"), null);
		assertQueryEquals(null, 4, "if 4=4 then 4 else 4 endif");
		//
		assertValidQuery(metaModelManager.getOclAnyType(), "let a : Boolean = false in if true then OrderedSet{5} else OrderedSet{} endif->first()+5");
	}

	@Test public void testConstruct_let() {		
		assertQueryEquals(null, 3, "let a : Integer = 1 in a + 2");
		assertQueryEquals(null, 7, "1 + let a : Integer = 2 in a * 3");
		assertQueryEquals(null, 4/2+5*3, "4/2 + let a : Integer = 5 in a * 3");
		assertQueryEquals(null, 4/2+3*5*7, "4/2 + (let a : Integer = 5 in 3 * (let b : Integer = 7 in a * b))");
		assertSemanticErrorQuery("4/2 + (let a : Integer = 5 in 3) * (let b : Integer = 7 in a * b)",
			OCLMessages.UnresolvedProperty_ERROR_, "a", "");
		assertQueryEquals(null, 4/2+3*5*7, "4/2 + let a : Integer = 5 in 3 * let b : Integer = 7 in a * b");
		assertQueryEquals(null, (64.0 / 16) / (8 / 4), "(64 / 16) / (let b : Integer = 0 in 8 / (let c : Integer = 0 in 4 ))");
		assertQueryEquals(null, (64.0 / 16) / (8 / 4), "64 / 16 / let b : Integer = 0 in 8 / let c : Integer = 0 in 4");
		assertQueryEquals(null, -5, "-let a : Integer = 5 in a");
		//
		assertQueryEquals(null, 5 * 7 * 9, "let a : Integer = 5, b : Real = 7, c : UnlimitedNatural = 9 in a * b * c");
		//
		assertQueryNull(null, "let a : Integer = null in a");
		//
		assertQueryInvalid(null, "let a : Integer = invalid in a");
	}
}
