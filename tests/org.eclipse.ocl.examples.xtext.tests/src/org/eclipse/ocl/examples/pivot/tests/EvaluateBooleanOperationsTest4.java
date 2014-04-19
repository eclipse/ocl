/**
 * <copyright>
 * 
 * Copyright (c) 2009, 2012 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EvaluateBooleanOperationsTest.java,v 1.1 2011/02/19 12:03:51 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
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
public class EvaluateBooleanOperationsTest4 extends PivotTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false}, {true}};
		return Arrays.asList(data);
	}

	public EvaluateBooleanOperationsTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateBooleanOperations";
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

	@Test public void testBoolean() {
		assertQueryFalse(null, "false");
		assertQueryTrue(null, "true");
		// invalid
		assertQueryFalse(null, "let b : Boolean = false in b");
		assertQueryTrue(null, "let b : Boolean = true in b");
		assertQueryNull(null, "let b : Boolean = null in b");
		assertQueryInvalid(null, "let b : Boolean = invalid in b");
	}

	@Test public void testBooleanAnd() {
		assertQueryFalse(null, "false and false");
		assertQueryFalse(null, "false and true");
		assertQueryFalse(null, "true and false");
		assertQueryTrue(null, "true and true");
		// invalid
		assertQueryFalse(null, "let b : Boolean = invalid in false and b");
		assertQueryInvalid(null, "let b : Boolean = invalid in true and b");
		assertQueryFalse(null, "let a : Boolean = invalid in a and false");
		assertQueryInvalid(null, "let a : Boolean = invalid in a and true");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = invalid in a and b");
		// null
		assertQueryFalse(null, "let b : Boolean = null in false and b");
		assertQueryNull(null, "let b : Boolean = null in true and b");
		assertQueryNull(null, "let a : Boolean = null, b : Boolean = null in a and b");
		assertQueryInvalid(null, "let a : Boolean = null, b : Boolean = invalid in a and b");
		assertQueryInvalid(null, "let a : Boolean = null in a and Sequence{true}->at(0)");
		assertQueryFalse(null, "let a : Boolean = null in a and false");
		assertQueryNull(null, "let a : Boolean = null in a and true");
		assertQueryNull(null, "let a : Boolean = null, b : Boolean = null in a and b");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = null in a and b");
		assertQueryInvalid(null, "let b : Boolean = null in Sequence{true}->at(0) and b");
	}

	@Test public void testBooleanEqual() {
		assertQueryFalse(null, "true = false");

		assertQueryTrue(null, "true = true");
		assertQueryTrue(null, "false = false");
		// invalid
		assertQueryInvalid(null, "let b : Boolean = invalid in b = true");
		assertQueryInvalid(null, "let b : Boolean = invalid in false = b");

		assertQueryInvalid(null, "let b1 : Boolean = invalid, b2 : Boolean = invalid in b1 = b2");
		// null
		assertQueryFalse(null, "let b : Boolean = null in b = true");
		assertQueryFalse(null, "let b : Boolean = null in false = b");

		assertQueryTrue(null, "let b1 : Boolean = null, b2 : Boolean = null in b1 = b2");
	}

	@Test public void testBooleanImplies() {
		assertQueryTrue(null, "false implies false");
		assertQueryTrue(null, "false implies true");
		assertQueryFalse(null, "true implies false");
		assertQueryTrue(null, "true implies true");
		// invalid
		assertQueryTrue(null, "let b : Boolean = invalid in false implies b");
		assertQueryInvalid(null, "let b : Boolean = invalid in true implies b");
		assertQueryInvalid(null, "let a : Boolean = invalid in a implies false");
		assertQueryTrue(null, "let a : Boolean = invalid in a implies true");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = invalid in a implies b");
		// null
		assertQueryTrue(null, "let b : Boolean = null in false implies b");
		assertQueryNull(null, "let b : Boolean = null in true implies b");
		assertQueryInvalid(null, "let a : Boolean = null, b : Boolean = invalid in a implies b");
		assertQueryInvalid(null, "let a : Boolean = null in a implies Sequence{true}->at(0)");
		assertQueryNull(null, "let a : Boolean = null in a implies false");
		assertQueryTrue(null, "let a : Boolean = null in a implies true");
		assertQueryNull(null, "let a : Boolean = null, b : Boolean = null in a implies b");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = null in a implies b");
		assertQueryInvalid(null, "let b : Boolean = null in Sequence{true}->at(0) implies b");
	}

	@Test public void testBooleanNot() {
		assertQueryTrue(null, "not false");
		assertQueryFalse(null, "not true");
		// invalid
		assertQueryInvalid(null, "let a : Boolean = invalid in not a");
		// null
		assertQueryNull(null, "let a : Boolean = null in not a");
	}

	@Test public void testBooleanNotEqual() {
		assertQueryTrue(null, "true <> false");

		assertQueryFalse(null, "true <> true");
		assertQueryFalse(null, "false <> false");
		// invalid
		assertQueryInvalid(null, "let b : Boolean = invalid in b <> true");
		assertQueryInvalid(null, "let b : Boolean = invalid in false <> b");

		assertQueryInvalid(null, "let b1 : Boolean = invalid, b2 : Boolean = invalid in b1 <> b2");
		// null
		assertQueryTrue(null, "let b : Boolean = null in b <> true");
		assertQueryTrue(null, "let b : Boolean = null in false <> b");

		assertQueryFalse(null, "let b1 : Boolean = null, b2 : Boolean = null in b1 <> b2");
	}

	@Test public void testBooleanOr() {
		assertQueryFalse(null, "false or false");
		assertQueryTrue(null, "false or true");
		assertQueryTrue(null, "true or false");
		assertQueryTrue(null, "true or true");
		// invalid
		assertQueryInvalid(null, "let b : Boolean = invalid in false or b");
		assertQueryTrue(null, "let b : Boolean = invalid in true or b");
		assertQueryInvalid(null, "let a : Boolean = invalid in a or false");
		assertQueryTrue(null, "let a : Boolean = invalid in a or true");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = invalid in a or b");
		// null
		assertQueryNull(null, "let b : Boolean = null in false or b");
		assertQueryTrue(null, "let b : Boolean = null in true or b");
		assertQueryNull(null, "let a : Boolean = null, b : Boolean = null in a or b");
		assertQueryInvalid(null, "let a : Boolean = null, b : Boolean = invalid in a or b");
		assertQueryInvalid(null, "let a : Boolean = null in a or Sequence{true}->at(0)");
		assertQueryNull(null, "let a : Boolean = null in a or false");
		assertQueryTrue(null, "let a : Boolean = null in a or true");
		assertQueryNull(null, "let a : Boolean = null, b : Boolean = null in a or b");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = null in a or b");
		assertQueryInvalid(null, "let b : Boolean = null in Sequence{true}->at(0) or b");
	}

	@Test public void testBooleanToString() {
		assertQueryEquals(null, "false", "false.toString()");
		assertQueryEquals(null, "true", "true.toString()");
		assertQueryEquals(null, "true", "(not false).toString()");
	}

	@Test public void testBooleanXor() {
		assertQueryFalse(null, "false xor false");
		assertQueryTrue(null, "false xor true");
		assertQueryTrue(null, "true xor false");
		assertQueryFalse(null, "true xor true");
		// invalid
		assertQueryInvalid(null, "let b : Boolean = invalid in false xor b");
		assertQueryInvalid(null, "let b : Boolean = invalid in true xor b");
		assertQueryInvalid(null, "let a : Boolean = null, b : Boolean = invalid in a xor b");
		assertQueryInvalid(null, "let a : Boolean = null in a xor Sequence{true}->at(0)");
		assertQueryInvalid(null, "let a : Boolean = invalid in a xor false");
		assertQueryInvalid(null, "let a : Boolean = invalid in a xor true");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = null in a xor b");
		assertQueryInvalid(null, "let a : Boolean = invalid, b : Boolean = null in a xor b");
		assertQueryInvalid(null, "let b : Boolean = invalid in Sequence{true}->at(0) xor b");
		// xor
		assertQueryNull(null, "let b : Boolean = null in false xor b");
		assertQueryNull(null, "let b : Boolean = null in true xor b");
		assertQueryNull(null, "let b : Boolean = null in true xor b");
		assertQueryNull(null, "let a : Boolean = null in a xor true");
		assertQueryNull(null, "let a : Boolean = null, b : Boolean = null in a xor b");
	}
}
