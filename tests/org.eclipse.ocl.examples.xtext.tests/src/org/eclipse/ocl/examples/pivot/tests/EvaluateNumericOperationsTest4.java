/*******************************************************************************
 * Copyright (c) 2009, 2012 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.values.impl.BigIntegerValueImpl;
import org.eclipse.ocl.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.domain.values.util.ValuesUtil;
import org.eclipse.ocl.pivot.messages.OCLMessages;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * Tests for numeric operations.
 */
@SuppressWarnings("nls")
@RunWith(value = Parameterized.class)
public class EvaluateNumericOperationsTest4 extends PivotTestSuite
{	 
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false}, {true}};
		return Arrays.asList(data);
	}

	protected double doubleEpsilon = Math.pow(0.5, Double.SIZE - 12);

	public EvaluateNumericOperationsTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateNumericOperations";
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

	@Test public void testIntValue() {
		assert ValuesUtil.integerValueOf(Integer.MAX_VALUE) instanceof IntIntegerValueImpl;
		assert ValuesUtil.integerValueOf((long)Integer.MAX_VALUE) instanceof IntIntegerValueImpl;
		assert ValuesUtil.integerValueOf(BigInteger.valueOf(Integer.MAX_VALUE)) instanceof IntIntegerValueImpl;
		assert ValuesUtil.integerValueOf(BigInteger.valueOf(Integer.MAX_VALUE + 1L)) instanceof LongIntegerValueImpl;

		assert ValuesUtil.integerValueOf(Long.MAX_VALUE) instanceof LongIntegerValueImpl;
		assert ValuesUtil.integerValueOf(BigInteger.valueOf(Long.MAX_VALUE)) instanceof LongIntegerValueImpl;
		assert ValuesUtil.integerValueOf(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE)) instanceof BigIntegerValueImpl;

		assert ValuesUtil.integerValueOf(Integer.MIN_VALUE) instanceof IntIntegerValueImpl;
		assert ValuesUtil.integerValueOf((long)Integer.MIN_VALUE) instanceof IntIntegerValueImpl;
		assert ValuesUtil.integerValueOf(BigInteger.valueOf(Integer.MIN_VALUE)) instanceof IntIntegerValueImpl;
		assert ValuesUtil.integerValueOf(BigInteger.valueOf(Integer.MIN_VALUE - 1L)) instanceof LongIntegerValueImpl;

		assert ValuesUtil.integerValueOf(Long.MIN_VALUE) instanceof LongIntegerValueImpl;
		assert ValuesUtil.integerValueOf(BigInteger.valueOf(Long.MIN_VALUE)) instanceof LongIntegerValueImpl;
		assert ValuesUtil.integerValueOf(BigInteger.valueOf(Long.MIN_VALUE).subtract(BigInteger.ONE)) instanceof BigIntegerValueImpl;
    }

    @Test public void testIntPlus() {
		// hashCode, equals
    }

    @Test public void testIntMinus() {
		// hashCode, equals
    }
    
	@Test public void testNumber() {
		assertQueryEquals(null, 0, "0");
//		assertSemanticErrorQuery("00", "extraneous input ''{0}'' expecting EOF", "0");
//		assertSemanticErrorQuery("01", "extraneous input ''{0}'' expecting EOF", "1");
		assertQueryEquals(null, 3, "3");
		assertQueryEquals(null, 3.1, "3.1");
		assertQueryEquals(null, 3.1e1, "3.1e1");
		assertQueryEquals(null, 3.1e+1, "3.1e+1");
		assertQueryEquals(null, 3.1e-1, "3.1e-1");
		assertQueryEquals(null, 3e1, "3e1");
		assertQueryEquals(null, 3e+1, "3e+1");
		assertQueryEquals(null, 3e-1, "3e-1");
		assertQueryEquals(null, 3, "(3)");
		assertQueryEquals(null, 3.1, "(3.1)");
		assertQueryEquals(null, 3.1e1, "(3.1e1)");
		assertQueryEquals(null, 3.1e+1, "(3.1e+1)");
		assertQueryEquals(null, 3.1e-1, "(3.1e-1)");
		assertQueryEquals(null, 3e1, "(3e1)");
		assertQueryEquals(null, 3e+1, "(3e+1)");
		assertQueryEquals(null, 3e-1, "(3e-1)");
		assertQueryEquals(null, 3, "( 3)");
		assertQueryEquals(null, 3.1, "( 3.1 )");
		assertQueryEquals(null, 3.1e1, "( 3.1e1 )");
		assertQueryEquals(null, 3.1e+1, "( 3.1e+1 )");
		assertQueryEquals(null, 3.1e-1, "( 3.1e-1 )");
		assertQueryEquals(null, 3e1, "( 3e1 )");
		assertQueryEquals(null, 3e+1, "( 3e+1 )");
		assertQueryEquals(null, 3e-1, "( 3e-1 )");
		assertSemanticErrorQuery("3 .1", "bad navigation argument");
		assertSemanticErrorQuery("3. 1", "bad navigation argument");
		assertSemanticErrorQuery("3.1 e1", "extraneous input ''{0}'' expecting EOF", "e1");
		assertSemanticErrorQuery("3.1e 1", "no viable alternative at ''{0}''", "e");
		assertSemanticErrorQuery("3.1e+ 1", "no viable alternative at ''{0}''", "e");
	}
    
	@Test public void testNumberAbs() {
		// Integer::abs()
		assertQueryEquals(null, 3, "3.abs()");
		assertQueryEquals(null, 3, "(-3).abs()");

		assertQueryEquals(null, 2147483647, "2147483647.abs()");
		assertQueryEquals(null, 2147483648L, "2147483648.abs()");
		assertQueryEquals(null, 2147483649L, "(-2147483649).abs()");
		assertQueryEquals(null, 2147483648L, "(-2147483648).abs()");

		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).subtract(BigInteger.ONE), "9223372036854775807.abs()");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63), "9223372036854775808.abs()");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).add(BigInteger.ONE), "(-9223372036854775809).abs()");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63), "(-9223372036854775808).abs()");

		// Real::abs()
		assertQueryEquals(null, 3.0, "(3.0).abs()", 0.0);
		assertQueryEquals(null, 3.0, "(-3.0).abs()", 0.0);
		assertQueryEquals(null, 3.1758, "(3.1758).abs()", 0.0);
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i.abs()");
		assertQueryInvalid(null, "let r : Real = invalid in r.abs()");
		// null
		assertQueryInvalid(null, "let i : Integer = null in i.abs()");
		assertQueryInvalid(null, "let r : Real = null in r.abs()");
	}

	@Test public void testNumberDiv() {
		assertQueryEquals(null, 1, "3.div(2)");
		assertQueryEquals(null, -1, "(-3).div(2)");
		assertQueryEquals(null, -1, "3.div(-2)");
		assertQueryEquals(null, 1, "(-3).div(-2)");
		// by zero
		assertQueryInvalid(null, "1.div(0)");
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1.div(i)");
		assertQueryInvalid(null, "let i : Integer = invalid in i.div(1)");
		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1.div(i2)");
		// null
		assertQueryInvalid(null, "let i : Integer = null in 1.div(i)");
		assertQueryInvalid(null, "let i : Integer = null in i.div(1)");
		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1.div(i2)");
	}

	@Test public void testNumberDivide() {
		// A.2.1.3 Contrary to other operations, "Integer x Integer -> Real"
		// Integer::/(Integer)
		assertQueryEquals(null, 1.0, "1 / 1", 0.0);
		assertQueryEquals(null, -0.25, "1 / -4", 0.0);

		// Integer::/(Real)
		assertQueryEquals(null, 1.0, "1 / 1.0", 0.0);
		assertQueryEquals(null, -0.25, "1 / -4.0", 0.0);

		// Real::/(Integer)
		assertQueryEquals(null, 1.0, "1.0 / 1", 0.0);
		assertQueryEquals(null, -0.25, "1.0 / -4", 0.0);

		// Real::/(Real)
		assertQueryEquals(null, 1.0, "1.0 / 1.0", 0.0);
		assertQueryEquals(null, 1.11 / 1.12, "1.11 / 1.12", 1 * doubleEpsilon);
		
		// by zero
		assertQueryInvalid(null, "1 / 0");
		assertQueryInvalid(null, "1.0 / 0");
		assertQueryInvalid(null, "1 / 0.0");
		assertQueryInvalid(null, "1.0 / 0.0");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1 / i");
		assertQueryInvalid(null, "let i : Integer = invalid in i / 1");
		assertQueryInvalid(null, "let r : Real = invalid in 1 / r");
		assertQueryInvalid(null, "let r : Real = invalid in r / 1");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 / i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 / r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1 / i");
		assertQueryInvalid(null, "let i : Integer = null in i / 1");
		assertQueryInvalid(null, "let r : Real = null in 1 / r");
		assertQueryInvalid(null, "let r : Real = null in r / 1");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 / i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 / r2");
	}

	@Test public void testNumberEqual() {
		assertQueryFalse(null, "4 = 5");
		assertQueryFalse(null, "1 = 4.0");
		assertQueryFalse(null, "1.0 = 4");
		assertQueryFalse(null, "1.0 = 4.0");
		assertQueryFalse(null, "1.0 = 1.0000000000000001");

		assertQueryTrue(null, "4 = 4");
		assertQueryTrue(null, "1 = 1.0");
		assertQueryTrue(null, "1.0 = 1");
		assertQueryTrue(null, "1.0 = 1.0");
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i = 0");
		assertQueryInvalid(null, "let i : Integer = invalid in -1 = i");
		assertQueryInvalid(null, "let r : Real = invalid in r = 0.0");
		assertQueryInvalid(null, "let r : Real = invalid in -1.0 = r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 = i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 = r2");
		// null
		assertQueryFalse(null, "let i : Integer = null in i = 0");
		assertQueryFalse(null, "let i : Integer = null in -1 = i");
		assertQueryFalse(null, "let r : Real = null in r = 0.0");
		assertQueryFalse(null, "let r : Real = null in -1.0 = r");

		assertQueryTrue(null, "let i1 : Integer = null, i2 : Integer = null in i1 = i2");
		assertQueryTrue(null, "let r1 : Real = null, r2 : Real = null in r1 = r2");
	}

	@Test public void testNumberFloor() {
		// Integer::floor()
		assertQueryEquals(null, 3, "3.floor()");
		assertQueryEquals(null, -3, "(-3).floor()");

		// Real::floor()
		assertQueryEquals(null, -2, "(-1.5).floor()");
		assertQueryEquals(null, 1, "(1.01).floor()");
		assertQueryEquals(null, 3, "(3.999).floor()");
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i.floor()");
		assertQueryInvalid(null, "let r : Real = invalid in r.floor()");
		// null
		assertQueryInvalid(null, "let i : Integer = null in i.floor()");
		assertQueryInvalid(null, "let r : Real = null in r.floor()");
	}

	@Test public void testNumberGreaterThan() {
		// Integer::greaterThan(Integer)
		assertQueryTrue(null, "3 > 2");
		assertQueryFalse(null, "-3 > 2");
		assertQueryTrue(null, "3 > -2");
		assertQueryFalse(null, "-3 > -2");

		assertQueryTrue(null, "2147483648 > 2147483647");
		assertQueryFalse(null, "2147483647 > 2147483648");
		assertQueryFalse(null, "-2147483649 > -2147483648");
		assertQueryTrue(null, "-2147483648 > -2147483649");

		assertQueryTrue(null, "9223372036854775808 > 9223372036854775807");
		assertQueryFalse(null, "9223372036854775807 > 9223372036854775808");
		assertQueryFalse(null, "-9223372036854775809 > -9223372036854775808");
		assertQueryTrue(null, "-9223372036854775808 > -9223372036854775809");

		// Real::greaterThan(Real)
		assertQueryTrue(null, "3.0 > 2.0");
		assertQueryFalse(null, "-3.0 > 2.0");
		assertQueryTrue(null, "3.0 > -2.0");
		assertQueryFalse(null, "-3.0 > -2.0");

		// Real::greaterThan(Integer)
		assertQueryFalse(null, "3.0 > 3");
		assertQueryFalse(null, "-3.0 > 3");
		assertQueryTrue(null, "3.0 > -3");
		assertQueryFalse(null, "-3.0 > -3");

		// Integer::greaterThan(Real)
		assertQueryFalse(null, "3 > 3.0");
		assertQueryFalse(null, "-3 > 3.0");
		assertQueryTrue(null, "3 > -3.0");
		assertQueryFalse(null, "-3 > -3.0");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i > 0");
		assertQueryInvalid(null, "let i : Integer = invalid in 0 > i");
		assertQueryInvalid(null, "let r : Real = invalid in r > 0");
		assertQueryInvalid(null, "let r : Real = invalid in 0 > r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 > i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 > r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in i > 0");
		assertQueryInvalid(null, "let i : Integer = null in 0 > i");
		assertQueryInvalid(null, "let r : Real = null in r > 0");
		assertQueryInvalid(null, "let r : Real = null in 0 > r");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 > i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 > r2");
	}

	@Test public void testNumberGreaterThanOrEqual() {
		// Integer::greaterThanOrEqual(Integer)
		assertQueryTrue(null, "3 >= 2");
		assertQueryFalse(null, "-3 >= 2");
		assertQueryTrue(null, "3 >= -2");
		assertQueryFalse(null, "-3 >= -2");

		assertQueryTrue(null, "2147483648 >= 2147483647");
		assertQueryFalse(null, "2147483647 >= 2147483648");
		assertQueryFalse(null, "-2147483649 >= -2147483648");
		assertQueryTrue(null, "-2147483648 >= -2147483649");

		assertQueryTrue(null, "9223372036854775808 >= 9223372036854775807");
		assertQueryFalse(null, "9223372036854775807 >= 9223372036854775808");
		assertQueryFalse(null, "-9223372036854775809 >= -9223372036854775808");
		assertQueryTrue(null, "-9223372036854775808 >= -9223372036854775809");

		// Real::greaterThanOrEqual(Real)
		assertQueryTrue(null, "3.0 >= 2.0");
		assertQueryFalse(null, "-3.0 >= 2.0");
		assertQueryTrue(null, "3.0 >= -2.0");
		assertQueryFalse(null, "-3.0 >= -2.0");

		// Real::greaterThanOrEqual(Integer)
		assertQueryTrue(null, "3.0 >= 3");
		assertQueryFalse(null, "-3.0 >= 3");
		assertQueryTrue(null, "3.0 >= -3");
		assertQueryTrue(null, "-3.0 >= -3");

		// Integer::greaterThanOrEqual(Real)
		assertQueryTrue(null, "3 >= 3.0");
		assertQueryFalse(null, "-3 >= 3.0");
		assertQueryTrue(null, "3 >= -3.0");
		assertQueryTrue(null, "-3 >= -3.0");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i >= 0");
		assertQueryInvalid(null, "let i : Integer = invalid in 0 >= i");
		assertQueryInvalid(null, "let r : Real = invalid in r >= 0");
		assertQueryInvalid(null, "let r : Real = invalid in 0 >= r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 >= i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 >= r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in i >= 0");
		assertQueryInvalid(null, "let i : Integer = null in 0 >= i");
		assertQueryInvalid(null, "let r : Real = null in r >= 0");
		assertQueryInvalid(null, "let r : Real = null in 0 >= r");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 >= i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 >= r2");
	}

	@Test public void testNumberLessThan() {
		// Integer::lessThan(Integer)
		assertQueryFalse(null, "3 < 2");
		assertQueryTrue(null, "-3 < 2");
		assertQueryFalse(null, "3 < -2");
		assertQueryTrue(null, "-3 < -2");

		assertQueryFalse(null, "2147483648 < 2147483647");
		assertQueryTrue(null, "2147483647 < 2147483648");
		assertQueryTrue(null, "-2147483649 < -2147483648");
		assertQueryFalse(null, "-2147483648 < -2147483649");

		assertQueryFalse(null, "9223372036854775808 < 9223372036854775807");
		assertQueryTrue(null, "9223372036854775807 < 9223372036854775808");
		assertQueryTrue(null, "-9223372036854775809 < -9223372036854775808");
		assertQueryFalse(null, "-9223372036854775808 < -9223372036854775809");

		// Real::lessThan(Real)
		assertQueryFalse(null, "3.0 < 2.0");
		assertQueryTrue(null, "-3.0 < 2.0");
		assertQueryFalse(null, "3.0 < -2.0");
		assertQueryTrue(null, "-3.0 < -2.0");

		// Real::lessThan(Integer)
		assertQueryFalse(null, "3.0 < 3");
		assertQueryTrue(null, "-3.0 < 3");
		assertQueryFalse(null, "3.0 < -3");
		assertQueryFalse(null, "-3.0 < -3");

		// Integer::lessThan(Real)
		assertQueryFalse(null, "3 < 3.0");
		assertQueryTrue(null, "-3 < 3.0");
		assertQueryFalse(null, "3 < -3.0");
		assertQueryFalse(null, "-3 < -3.0");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i < 0");
		assertQueryInvalid(null, "let i : Integer = invalid in 0 < i");
		assertQueryInvalid(null, "let r : Real = invalid in r < 0");
		assertQueryInvalid(null, "let r : Real = invalid in 0 < r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 < i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 < r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in i < 0");
		assertQueryInvalid(null, "let i : Integer = null in 0 < i");
		assertQueryInvalid(null, "let r : Real = null in r < 0");
		assertQueryInvalid(null, "let r : Real = null in 0 < r");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 < i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 < r2");
	}

	@Test public void testNumberLessThanOrEqual() {
		// Integer::lessThanOrEqual(Integer)
		assertQueryFalse(null, "3 <= 2");
		assertQueryTrue(null, "-3 <= 2");
		assertQueryFalse(null, "3 <= -2");
		assertQueryTrue(null, "-3 <= -2");

		assertQueryFalse(null, "2147483648 <= 2147483647");
		assertQueryTrue(null, "2147483647 <= 2147483648");
		assertQueryTrue(null, "-2147483649 <= -2147483648");
		assertQueryFalse(null, "-2147483648 <= -2147483649");

		assertQueryFalse(null, "9223372036854775808 <= 9223372036854775807");
		assertQueryTrue(null, "9223372036854775807 <= 9223372036854775808");
		assertQueryTrue(null, "-9223372036854775809 <= -9223372036854775808");
		assertQueryFalse(null, "-9223372036854775808 <= -9223372036854775809");

		// Real::lessThanOrEqual(Real)
		assertQueryFalse(null, "3.0 <= 2.0");
		assertQueryTrue(null, "-3.0 <= 2.0");
		assertQueryFalse(null, "3.0 <= -2.0");
		assertQueryTrue(null, "-3.0 <= -2.0");

		// Real::lessThanOrEqual(Integer)
		assertQueryTrue(null, "3.0 <= 3");
		assertQueryTrue(null, "-3.0 <= 3");
		assertQueryFalse(null, "3.0 <= -3");
		assertQueryTrue(null, "-3.0 <= -3");

		// Integer::lessThanOrEqual(Real)
		assertQueryTrue(null, "3 <= 3.0");
		assertQueryTrue(null, "-3 <= 3.0");
		assertQueryFalse(null, "3 <= -3.0");
		assertQueryTrue(null, "-3 <= -3.0");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i <= 0");
		assertQueryInvalid(null, "let i : Integer = invalid in 0 <= i");
		assertQueryInvalid(null, "let r : Real = invalid in r <= 0");
		assertQueryInvalid(null, "let r : Real = invalid in 0 <= r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 <= i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 <= r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in i <= 0");
		assertQueryInvalid(null, "let i : Integer = null in 0 <= i");
		assertQueryInvalid(null, "let r : Real = null in r <= 0");
		assertQueryInvalid(null, "let r : Real = null in 0 <= r");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 <= i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 <= r2");
	}

	@Test public void testNumberMax() {
		// Integer::max(Integer)
		assertQueryEquals(null, 3, "3.max(2)");
		assertQueryEquals(null, 2, "(-3).max(2)");
		assertQueryEquals(null, 3, "3.max(-2)");
		assertQueryEquals(null, -2, "(-3).max(-2)");

		assertQueryEquals(null, 2147483648L, "2147483648.max(2147483647)");
		assertQueryEquals(null, 2147483648L, "2147483647.max(2147483648)");
		assertQueryEquals(null, -2147483648L, "(-2147483649).max(-2147483648)");
		assertQueryEquals(null, -2147483648L, "(-2147483648).max(-2147483649)");

		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63), "9223372036854775808.max(9223372036854775807)");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63), "9223372036854775807.max(9223372036854775808)");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).negate(), "(-9223372036854775809).max(-9223372036854775808)");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).negate(), "(-9223372036854775808).max(-9223372036854775809)");

		// Integer::max(Real)
		assertQueryEquals(null, 3.0, "3.max(2.0)", 0.0);
		assertQueryEquals(null, 2.0, "(-3).max(2.0)", 0.0);
		assertQueryEquals(null, 3.0, "3.max(-2.0)", 0.0);
		assertQueryEquals(null, -2.0, "(-3).max(-2.0)", 0.0);

		// Real::max(Integer)
		assertQueryEquals(null, 3.0, "(3.0).max(2)", 0.0);
		assertQueryEquals(null, 2.0, "(-3.0).max(2)", 0.0);
		assertQueryEquals(null, 3.0, "(3.0).max(-2)", 0.0);
		assertQueryEquals(null, -2.0, "(-3.0).max(-2)", 0.0);

		// Real::max(Real)
		assertQueryEquals(null, 3.0, "(3.0).max(2.0)", 0.0);
		assertQueryEquals(null, 2.0, "(-3.0).max(2.0)", 0.0);
		assertQueryEquals(null, 3.0, "(3.0).max(-2.0)", 0.0);
		assertQueryEquals(null, -2.0, "(-3.0).max(-2.0)", 0.0);

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1.max(i)");
		assertQueryInvalid(null, "let i : Integer = invalid in i.max(1)");
		assertQueryInvalid(null, "let r : Real = invalid in 1.max(r)");
		assertQueryInvalid(null, "let r : Real = invalid in r.max(1)");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1.max(i2)");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1.max(r2)");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1.max(i)");
		assertQueryInvalid(null, "let i : Integer = null in i.max(1)");
		assertQueryInvalid(null, "let r : Real = null in 1.max(r)");
		assertQueryInvalid(null, "let r : Real = null in r.max(1)");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1.max(i2)");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1.max(r2)");
	}

	@Test public void testNumberMin() {
		// Integer::min(Integer)
		assertQueryEquals(null, 2, "3.min(2)");
		assertQueryEquals(null, -3, "(-3).min(2)");
		assertQueryEquals(null, -2, "3.min(-2)");
		assertQueryEquals(null, -3, "(-3).min(-2)");

		assertQueryEquals(null, 2147483647, "2147483648.min(2147483647)");
		assertQueryEquals(null, 2147483647, "2147483647.min(2147483648)");
		assertQueryEquals(null, -2147483649L, "(-2147483649).min(-2147483648)");
		assertQueryEquals(null, -2147483649L, "(-2147483648).min(-2147483649)");

		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).subtract(BigInteger.ONE), "9223372036854775808.min(9223372036854775807)");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).subtract(BigInteger.ONE), "9223372036854775807.min(9223372036854775808)");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).negate().subtract(BigInteger.ONE), "(-9223372036854775809).min(-9223372036854775808)");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).negate().subtract(BigInteger.ONE), "(-9223372036854775808).min(-9223372036854775809)");

		// Integer::min(Real)
		assertQueryEquals(null, 2.0, "3.min(2.0)", 0.0);
		assertQueryEquals(null, -3.0, "(-3).min(2.0)", 0.0);
		assertQueryEquals(null, -2.0, "3.min(-2.0)", 0.0);
		assertQueryEquals(null, -3.0, "(-3).min(-2.0)", 0.0);

		// Real::min(Integer)
		assertQueryEquals(null, 2.0, "(3.0).min(2)", 0.0);
		assertQueryEquals(null, -3.0, "(-3.0).min(2)", 0.0);
		assertQueryEquals(null, -2.0, "(3.0).min(-2)", 0.0);
		assertQueryEquals(null, -3.0, "(-3.0).min(-2)", 0.0);

		// Real::min(Real)
		assertQueryEquals(null, 2.0, "(3.0).min(2.0)", 0.0);
		assertQueryEquals(null, -3.0, "(-3.0).min(2.0)", 0.0);
		assertQueryEquals(null, -2.0, "(3.0).min(-2.0)", 0.0);
		assertQueryEquals(null, -3.0, "(-3.0).min(-2.0)", 0.0);

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1.min(i)");
		assertQueryInvalid(null, "let i : Integer = invalid in i.min(1)");
		assertQueryInvalid(null, "let r : Real = invalid in 1.min(r)");
		assertQueryInvalid(null, "let r : Real = invalid in r.min(1)");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1.min(i2)");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1.min(r2)");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1.min(i)");
		assertQueryInvalid(null, "let i : Integer = null in i.min(1)");
		assertQueryInvalid(null, "let r : Real = null in 1.min(r)");
		assertQueryInvalid(null, "let r : Real = null in r.min(1)");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1.min(i2)");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1.min(r2)");
	}

	@Test public void testNumberMinus() {
		// Integer::-(Integer)
		assertQueryEquals(null, 0, "1 - 1");
		assertQueryEquals(null, 5, "1 - -4");

		assertQueryEquals(null, BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE), "2147483646 - -1");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(31), "2147483647 - -1");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).subtract(BigInteger.ONE), "9223372036854775806 - -1");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63), "9223372036854775807 - -1");

		assertQueryEquals(null, BigInteger.ONE.negate().shiftLeft(31), "-2147483647 - 1");
		assertQueryEquals(null, BigInteger.ONE.negate().shiftLeft(31).subtract(BigInteger.ONE), "-2147483648 - 1");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).negate(), "-9223372036854775807 - 1");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).negate().subtract(BigInteger.ONE), "-9223372036854775808 - 1");

		// Integer::-(Real)
		assertQueryEquals(null, 0.0, "1 - 1.0", 2 * doubleEpsilon);
		assertQueryEquals(null, 5.0, "1 - -4.0", 5 * doubleEpsilon);

		// Real::-(Integer)
		assertQueryEquals(null, 0.0, "1.0 - 1", 2 * doubleEpsilon);
		assertQueryEquals(null, 5.0, "1.0 - -4", 5 * doubleEpsilon);

		// Real::-(Real)
		assertQueryEquals(null, 0.0, "1.0 - 1.0", 2 * doubleEpsilon);
		assertQueryEquals(null, -0.01, "1.11 - 1.12", 3 * doubleEpsilon);

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1 - i");
		assertQueryInvalid(null, "let i : Integer = invalid in i - 1");
		assertQueryInvalid(null, "let r : Real = invalid in 1 - r");
		assertQueryInvalid(null, "let r : Real = invalid in r - 1");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 - i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 - r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1 - i");
		assertQueryInvalid(null, "let i : Integer = null in i - 1");
		assertQueryInvalid(null, "let r : Real = null in 1 - r");
		assertQueryInvalid(null, "let r : Real = null in r - 1");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 - i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 - r2");
	}

	@Test public void testNumberMod() {
		assertQueryEquals(null, 1, "3.mod(2)");
		assertQueryEquals(null, -1, "(-3).mod(2)");
		assertQueryEquals(null, 1, "3.mod(-2)");
		assertQueryEquals(null, -1, "(-3).mod(-2)");

		// by zero
		assertQueryInvalid(null, "1.mod(0)");

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1.mod(i)");
		assertQueryInvalid(null, "let i : Integer = invalid in i.mod(1)");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1.mod(i2)");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1.mod(i)");
//		assertQueryInvalid(null, "let i : Integer = null in mod(1)");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1.mod(i2)");
	}

	@Test public void testNumberNegate() {
		assertQueryEquals(null, -1, "-1");
		assertQueryEquals(null, -1.0, "-1.0", 0.0);

		assertQueryEquals(null, -2147483647, "-2147483647");
		assertQueryEquals(null, -2147483648, "-2147483648");
		assertQueryEquals(null, -2147483649L, "-2147483649");

		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).negate().add(BigInteger.ONE), "-9223372036854775807");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).negate(), "-9223372036854775808");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).negate().subtract(BigInteger.ONE), "-9223372036854775809");
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in -i");
		assertQueryInvalid(null, "let r : Real = invalid in -r");
		// null
		assertQueryInvalid(null, "let i : Integer = null in -i");
		assertQueryInvalid(null, "let r : Real = null in -r");
	}

	@Test public void testNumberNotEqual() {
		assertQueryTrue(null, "4 <> 5");
		assertQueryTrue(null, "1 <> 4.0");
		assertQueryTrue(null, "1.0 <> 4");
		assertQueryTrue(null, "1.0 <> 4.0");

		assertQueryFalse(null, "4 <> 4");
		assertQueryFalse(null, "1 <> 1.0");
		assertQueryFalse(null, "1.0 <> 1");
		assertQueryFalse(null, "1.0 <> 1.0");
		assertQueryTrue(null, "1.0 <> 1.0000000000000001");
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i <> 0");
		assertQueryInvalid(null, "let i : Integer = invalid in -1 <> i");
		assertQueryInvalid(null, "let r : Real = invalid in r <> 0.0");
		assertQueryInvalid(null, "let r : Real = invalid in -1.0 <> r");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 <> i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 <> r2");
		// null
		assertQueryTrue(null, "let i : Integer = null in i <> 0");
		assertQueryTrue(null, "let i : Integer = null in -1 <> i");
		assertQueryTrue(null, "let r : Real = null in r <> 0.0");
		assertQueryTrue(null, "let r : Real = null in -1.0 <> r");

		assertQueryFalse(null, "let i1 : Integer = null, i2 : Integer = null in i1 <> i2");
		assertQueryFalse(null, "let r1 : Real = null, r2 : Real = null in r1 <> r2");
	}


	@Test public void testNumberPlus() {
		// Integer::+(Integer)
		assertQueryEquals(null, 2, "1 + 1");
		assertQueryEquals(null, -3, "1 + -4");

		assertQueryEquals(null, BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE), "2147483646 + 1");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(31), "2147483647 + 1");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63).subtract(BigInteger.ONE), "9223372036854775806 + 1");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(63), "9223372036854775807 + 1");

		assertQueryEquals(null, BigInteger.ONE.negate().shiftLeft(31), "-2147483647 + -1");
		assertQueryEquals(null, BigInteger.ONE.negate().shiftLeft(31).subtract(BigInteger.ONE), "-2147483648 + -1");
		assertQueryEquals(null, BigInteger.ONE.negate().shiftLeft(63), "-9223372036854775807 + -1");
		assertQueryEquals(null, BigInteger.ONE.negate().shiftLeft(63).subtract(BigInteger.ONE), "-9223372036854775808 + -1");

		// Integer::+(Real)
		assertQueryEquals(null, 2.0, "1 + 1.0", 2 * doubleEpsilon);
		assertQueryEquals(null, -3.0, "1 + -4.0", 5 * doubleEpsilon);

		// Real::+(Integer)
		assertQueryEquals(null, 2.0, "1.0 + 1", 2 * doubleEpsilon);
		assertQueryEquals(null, -3.0, "1.0 + -4", 5 * doubleEpsilon);

		// Real::+(Real)
		assertQueryEquals(null, 2.0, "1.0 + 1.0", 2 * doubleEpsilon);
		assertQueryEquals(null, 2.23, "1.11 + 1.12", 3 * doubleEpsilon);

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1 + i");
		assertQueryInvalid(null, "let i : Integer = invalid in i + 1");
		assertQueryInvalid(null, "let r : Real = invalid in 1 + r");
		assertQueryInvalid(null, "let r : Real = invalid in r + 1");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 + i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 + r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1 + i");
		assertQueryInvalid(null, "let i : Integer = null in i + 1");
		assertQueryInvalid(null, "let r : Real = null in 1 + r");
		assertQueryInvalid(null, "let r : Real = null in r + 1");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 + i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 + r2");
	}

	@Test public void testNumberRound() {
		// Integer::round()
		assertQueryEquals(null, 3, "3.round()");
		assertQueryEquals(null, -3, "(-3).round()");

		// Real::round()
		assertQueryEquals(null, -1, "(-1.5).round()");
		assertQueryEquals(null, 1, "(1.01).round()");
		assertQueryEquals(null, 4, "(3.999).round()");
		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in i.round()");
		assertQueryInvalid(null, "let r : Real = invalid in r.round()");
		// null
		assertQueryInvalid(null, "let i : Integer = null in i.round()");
		assertQueryInvalid(null, "let r : Real = null in r.round()");
	}

	@Test public void testNumberTimes() {
		// Integer::*(Integer)
		assertQueryEquals(null, 1, "1 * 1");
		assertQueryEquals(null, -4, "1 * -4");

		assertQueryEquals(null, BigInteger.ONE.shiftLeft(62), "-2147483648 * -2147483648");
		assertQueryEquals(null, BigInteger.ONE.shiftLeft(126), "-9223372036854775808 * -9223372036854775808");

		// Integer::*(Real)
		assertQueryEquals(null, 1.0, "1 * 1.0", 0.0);
		assertQueryEquals(null, -4.0, "1 * -4.0", 0.0);

		// Real::*(Integer)
		assertQueryEquals(null, 1.0, "1.0 * 1", 0.0);
		assertQueryEquals(null, -4.0, "1.0 * -4", 0.0);

		// Real::*(Real)
		assertQueryEquals(null, 1.0, "1.0 * 1.0", 0.0);
		@SuppressWarnings("null") @NonNull BigDecimal expected = BigDecimal.valueOf(1.11).multiply(BigDecimal.valueOf(1.12));
		assertQueryEquals(null, expected, "1.11 * 1.12", 0.0);

		// invalid
		assertQueryInvalid(null, "let i : Integer = invalid in 1 * i");
		assertQueryInvalid(null, "let i : Integer = invalid in i * 1");
		assertQueryInvalid(null, "let r : Real = invalid in 1 * r");
		assertQueryInvalid(null, "let r : Real = invalid in r * 1");

		assertQueryInvalid(null, "let i1 : Integer = invalid, i2 : Integer = invalid in i1 * i2");
		assertQueryInvalid(null, "let r1 : Real = invalid, r2 : Real = invalid in r1 * r2");

		// null
		assertQueryInvalid(null, "let i : Integer = null in 1 * i");
		assertQueryInvalid(null, "let i : Integer = null in i * 1");
		assertQueryInvalid(null, "let r : Real = null in 1 * r");
		assertQueryInvalid(null, "let r : Real = null in r * 1");

		assertQueryInvalid(null, "let i1 : Integer = null, i2 : Integer = null in i1 * i2");
		assertQueryInvalid(null, "let r1 : Real = null, r2 : Real = null in r1 * r2");
	}

	@Test public void testNumberToString() {
		assertQueryEquals(null, "1", "1.toString()");
		assertQueryEquals(null, "3.0", "3.0.toString()");
		assertQueryEquals(null, "4.0", "(1.0+3.0).toString()");
		assertQueryEquals(null, "null", "null.toString()");
//		assertQueryEquals(null, "invalid", "invalid.toString()");
		assertQueryInvalid(null, "invalid.toString()");
		assertQueryEquals(null, "*", "*.toString()");
	}

	@Test public void testUnlimitedAbs() {
		assertSemanticErrorQuery("*.abs()", OCLMessages.UnresolvedOperation_ERROR_, "UnlimitedNatural", "abs");
		// invalid
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in u.abs()", OCLMessages.UnresolvedOperation_ERROR_, "UnlimitedNatural", "abs");
		// null
		assertSemanticErrorQuery("let u : UnlimitedNatural = null in u.abs()", OCLMessages.UnresolvedOperation_ERROR_, "UnlimitedNatural", "abs");

	}

/* FIXME	@Test public void testUnlimitedDiv() {
		/ *
		 * FIXME I'm expecting the UnlimitedNatural to conform to Integer, div
		 * and mod calls should then at least parse for them even though they
		 * return an invalid value.
		 * /
		assertQueryInvalid(null, "1.div(*)");
		assertQueryInvalid(null, "*.div(1)");

		assertQueryInvalid(null, "*.div(*)");
		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 1.div(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u.div(1)");
		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 1.div(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u.div(1)");
	} */

	@Test public void testUnlimitedDivide() {
		assertSemanticErrorQuery("1 / *", OCLMessages.UnresolvedOperationCall_ERROR_, "Integer", "/", "UnlimitedNatural");
		assertSemanticErrorQuery("* / 1", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "/", "Integer");

		assertSemanticErrorQuery("1.0 / *", OCLMessages.UnresolvedOperationCall_ERROR_, "Real", "/", "UnlimitedNatural");
		assertSemanticErrorQuery("* / 1.0", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "/", "Real");

		assertSemanticErrorQuery("* / *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "/", "UnlimitedNatural");

		// invalid
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in * / u", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "/", "UnlimitedNatural");
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in u / *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "/", "UnlimitedNatural");

		assertSemanticErrorQuery("let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 / u2", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "/", "UnlimitedNatural");

		// null
		assertSemanticErrorQuery("let u : UnlimitedNatural = null in * / u", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "/", "UnlimitedNatural");
		assertSemanticErrorQuery("let u : UnlimitedNatural = null in u / *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "/", "UnlimitedNatural");

		assertSemanticErrorQuery("let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 / u2", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "/", "UnlimitedNatural");
	}

	@Test public void testUnlimitedEqual() {
		assertQueryFalse(null, "* = 1");
		assertQueryFalse(null, "1 = *");
		assertQueryFalse(null, "* = 1.0");
		assertQueryFalse(null, "1.0 = *");
		assertQueryFalse(null, "* = -1");
		assertQueryFalse(null, "-1 = *");
		assertQueryFalse(null, "* = -1.0");
		assertQueryFalse(null, "-1.0 = *");

		assertQueryTrue(null, "* = *");
		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u = *");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 = u2");
		// null
		assertQueryFalse(null, "let u : UnlimitedNatural = null in u = *");

		assertQueryTrue(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 = u2");
	}

	@Test public void testUnlimitedFloor() {
		assertSemanticErrorQuery("*.floor()", OCLMessages.UnresolvedOperation_ERROR_, "UnlimitedNatural", "floor");

		// invalid
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in u.floor()", OCLMessages.UnresolvedOperation_ERROR_, "UnlimitedNatural", "floor");

		// null
		assertSemanticErrorQuery("let u : UnlimitedNatural = null in u.floor()", OCLMessages.UnresolvedOperation_ERROR_, "UnlimitedNatural", "floor");
	}

	@Test public void testUnlimitedGreaterThan() {
		assertQueryFalse(null, "1 > *");
		assertQueryTrue(null, "* > 1");
		assertQueryFalse(null, "* > *");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u > 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 0 > u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 > u2");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u > 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 0 > u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 > u2");
	}

	@Test public void testUnlimitedGreaterThanOrEqual() {
		/*
		 * FIXME "(* = *) == true" but "(* >= *) == false" ? something's amiss
		 * and since this behavior isn't defined in the specification, we'll
		 * have to make an arbitrary choice. The "expected" here is Java's
		 * behavior with Double.POSITIVE_INFINITY.
		 */
		assertQueryFalse(null, "1 >= *");
		assertQueryTrue(null, "* >= 1");
		assertQueryTrue(null, "* >= *");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u >= 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 0 >= u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 >= u2");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u >= 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 0 >= u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 >= u2");
	}

	@Test public void testUnlimitedLessThan() {
		assertQueryTrue(null, "1 < *");
		assertQueryFalse(null, "* < 1");
		assertQueryFalse(null, "* < *");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u < 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 0 < u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 < u2");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u < 0");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 0 < u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 < u2");
	}

	@Test public void testUnlimitedLessThanOrEqual() {
		/*
		 * FIXME "(* = *) == true" but "(* <= *) == false" ? something's amiss
		 * and since this behavior isn't defined in the specification, we'll
		 * have to make an arbitrary choice. The "expected" here is Java's
		 * behavior with Double.POSITIVE_INFINITY.
		 */
		assertQueryTrue(null, "1 <= *");
		assertQueryFalse(null, "* <= 1.toUnlimitedNatural()");
		assertQueryTrue(null, "* <= *");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u <= 0.toUnlimitedNatural()");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 0.toUnlimitedNatural() <= u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 <= u2");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u <= 0.toUnlimitedNatural()");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 0.toUnlimitedNatural() <= u");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 <= u2");
	}

	@Test public void testUnlimitedMax() {
		assertQueryUnlimited(null, "1.max(*)");
		assertQueryUnlimited(null, "*.max(1)");

		assertQueryUnlimited(null, "0.max(*)");
		assertQueryUnlimited(null, "*.max(0)");

		assertQueryInvalid(null, "(-1).max(*)");
		assertQueryInvalid(null, "*.max(-1)");

		assertSemanticErrorQuery("(1.0).max(*)", OCLMessages.UnresolvedOperationCall_ERROR_, "Real", "max", "UnlimitedNatural");
		assertSemanticErrorQuery("*.max(1.0)", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "max", "Real");

		assertQueryUnlimited(null, "*.max(*)");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in *.max(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u.max(*)");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1.max(u2)");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in *.max(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u.max(*)");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1.max(u2)");
	}

	@Test public void testUnlimitedMin() {
		assertQueryEquals(null, 1, "1.min(*)");
		assertQueryEquals(null, 1, "*.min(1)");

		assertQueryEquals(null, 0, "0.min(*)");
		assertQueryEquals(null, 0, "*.min(0)");

		assertQueryInvalid(null, "(-1).min(*)");
		assertQueryInvalid(null, "*.min(-1)");

		assertSemanticErrorQuery("(1.0).min(*)", OCLMessages.UnresolvedOperationCall_ERROR_, "Real", "min", "UnlimitedNatural");
		assertSemanticErrorQuery("*.min(1.0)", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "min", "Real");

		assertQueryUnlimited(null, "*.min(*)");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in *.min(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u.min(*)");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1.min(u2)");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in *.min(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u.min(*)");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1.min(u2)");
	}

	@Test public void testUnlimitedMinus() {
		assertSemanticErrorQuery("1 - *", OCLMessages.UnresolvedOperationCall_ERROR_, "Integer", "-", "UnlimitedNatural");
		assertSemanticErrorQuery("* - 1", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "-", "Integer");

		assertSemanticErrorQuery("1.0 - *", OCLMessages.UnresolvedOperationCall_ERROR_, "Real", "-", "UnlimitedNatural");
		assertSemanticErrorQuery("* - 1.0", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "-", "Real");

		assertSemanticErrorQuery("* - *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "-", "UnlimitedNatural");

		// invalid
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in * - u", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "-", "UnlimitedNatural");
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in u - *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "-", "UnlimitedNatural");

		assertSemanticErrorQuery("let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 - u2", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "-", "UnlimitedNatural");

		// null
		assertSemanticErrorQuery("let u : UnlimitedNatural = null in * - u", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "-", "UnlimitedNatural");
		assertSemanticErrorQuery("let u : UnlimitedNatural = null in u - *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "-", "UnlimitedNatural");

		assertSemanticErrorQuery("let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 - u2", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "-", "UnlimitedNatural");
	}

/* FIXME	@Test public void testUnlimitedMod() {
		/ *
		 * FIXME I'm expecting the UnlimitedNatural to conform to Integer, div
		 * and mod calls should then at least parse for them even though they
		 * return an invalid value.
		 * /
		assertQueryInvalid(null, "1.mod(*)");
		assertQueryInvalid(null, "*.mod(1)");

		assertQueryInvalid(null, "*.mod(*)");

		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in 1.mod(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u.mod(1)");

		// null
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in 1.mod(u)");
		assertQueryInvalid(null, "let u : UnlimitedNatural = null in u.mod(1)");
	} */

	@Test public void testUnlimitedNegate() {
		assertSemanticErrorQuery("-*", OCLMessages.UnresolvedOperation_ERROR_, "UnlimitedNatural", "-");
		// invalid
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in -u", OCLMessages.UnresolvedOperation_ERROR_, "UnlimitedNatural", "-");
		// null
	}

	@Test public void testUnlimitedNotEqual() {
		assertQueryTrue(null, "* <> 1");
		assertQueryTrue(null, "1 <> *");
		assertQueryTrue(null, "* <> 1.0");
		assertQueryTrue(null, "1.0 <> *");
		assertQueryTrue(null, "* <> -1");
		assertQueryTrue(null, "-1 <> *");
		assertQueryTrue(null, "* <> -1.0");
		assertQueryTrue(null, "-1.0 <> *");

		assertQueryFalse(null, "* <> *");
		// invalid
		assertQueryInvalid(null, "let u : UnlimitedNatural = invalid in u <> *");

		assertQueryInvalid(null, "let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 <> u2");
		// null
		assertQueryTrue(null, "let u : UnlimitedNatural = null in u <> *");

		assertQueryFalse(null, "let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 <> u2");
	}

	@Test public void testUnlimitedPlus() {
		assertSemanticErrorQuery("1 + *", OCLMessages.UnresolvedOperationCall_ERROR_, "Integer", "+", "UnlimitedNatural");
		assertSemanticErrorQuery("* + 1", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "+", "Integer");

		assertSemanticErrorQuery("1.0 + *", OCLMessages.UnresolvedOperationCall_ERROR_, "Real", "+", "UnlimitedNatural");
		assertSemanticErrorQuery("* + 1.0", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "+", "Real");

		assertSemanticErrorQuery("* + *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "+", "UnlimitedNatural");
		// invalid
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in * + u", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "+", "UnlimitedNatural");
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in u + *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "+", "UnlimitedNatural");
		assertSemanticErrorQuery("let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 + u2", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "+", "UnlimitedNatural");
		// null
		assertSemanticErrorQuery("let u : UnlimitedNatural = null in * + u", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "+", "UnlimitedNatural");
		assertSemanticErrorQuery("let u : UnlimitedNatural = null in u + *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "+", "UnlimitedNatural");
		assertSemanticErrorQuery("let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 + u2", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "+", "UnlimitedNatural");
	}

	@Test public void testUnlimitedRound() {
		assertSemanticErrorQuery("*.round()", OCLMessages.UnresolvedOperation_ERROR_, "UnlimitedNatural", "round");
		// invalid
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in u.round()", OCLMessages.UnresolvedOperation_ERROR_, "UnlimitedNatural", "round");
		// null
		assertSemanticErrorQuery("let u : UnlimitedNatural = null in u.round()", OCLMessages.UnresolvedOperation_ERROR_, "UnlimitedNatural", "round");
	}

	@Test public void testUnlimitedTimes() {
		assertSemanticErrorQuery("1 * *", OCLMessages.UnresolvedOperationCall_ERROR_, "Integer", "*", "UnlimitedNatural");
		assertSemanticErrorQuery("* * 1", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "*", "Integer");

		assertSemanticErrorQuery("1.0 * *", OCLMessages.UnresolvedOperationCall_ERROR_, "Real", "*", "UnlimitedNatural");
		assertSemanticErrorQuery("* * 1.0", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "*", "Real");

		assertSemanticErrorQuery("* * *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "*", "UnlimitedNatural");

		// invalid
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in * * u", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "*", "UnlimitedNatural");
		assertSemanticErrorQuery("let u : UnlimitedNatural = invalid in u * *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "*", "UnlimitedNatural");

		assertSemanticErrorQuery("let u1 : UnlimitedNatural = invalid, u2 : UnlimitedNatural = invalid in u1 * u2", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "*", "UnlimitedNatural");
		// null
		assertSemanticErrorQuery("let u : UnlimitedNatural = null in * * u", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "*", "UnlimitedNatural");
		assertSemanticErrorQuery("let u : UnlimitedNatural = null in u * *", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "*", "UnlimitedNatural");

		assertSemanticErrorQuery("let u1 : UnlimitedNatural = null, u2 : UnlimitedNatural = null in u1 * u2", OCLMessages.UnresolvedOperationCall_ERROR_, "UnlimitedNatural", "*", "UnlimitedNatural");
	}
}
