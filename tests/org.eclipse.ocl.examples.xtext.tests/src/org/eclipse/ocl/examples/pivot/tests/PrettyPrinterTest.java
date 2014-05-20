/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class PrettyPrinterTest extends PivotSimpleTestSuite
{
	public PrettyPrinterTest() {
		super(false);
	}

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        helper.setContext(metaModelManager.getMetaclassType());
    }
    
	protected @Nullable Object assertPrintResults(@Nullable Object context, @NonNull String expression) {
		try {
			ExpressionInOCL query = helper.createQuery(expression);
			String prettyExpression = PrettyPrinter.print(query);
			assertEquals(expression, prettyExpression);
		} catch (ParserException e) {
            fail("Failed to parse \"" + expression + "\": " + e.getLocalizedMessage());
		}
		return null;
	}
    
	protected @Nullable Object assertPrintResults(@Nullable Object context, @NonNull String expression, @NonNull String expectedExpression) {
		try {
			ExpressionInOCL query = helper.createQuery(expression);
			String prettyExpression = PrettyPrinter.print(query);
			assertEquals(expectedExpression, prettyExpression);
		} catch (ParserException e) {
            fail("Failed to parse \"" + expression + "\": " + e.getLocalizedMessage());
		}
		return null;
	}

	/**
	 * Tests the quoting on reserved words.
	 */
	public void test_ReservedWords() {
		assertPrintResults(null, "let _'and' : Boolean = false in _'and' and _'and'");
		assertPrintResults(null, "let _'else' : Boolean = false in if _'else' then _'else' else _'else' endif");
		assertPrintResults(null, "let _'endif' : Boolean = false in if _'endif' then _'endif' else _'endif' endif");
		assertPrintResults(null, "let _'false' : Boolean = false in _'false' and _'false'");
		assertPrintResults(null, "let _'if' : Boolean = false in if _'if' then _'if' else _'if' endif");
		assertPrintResults(null, "let _'implies' : Boolean = false in _'implies' implies _'implies'");
		assertPrintResults(null, "let _'in' : Boolean = false in _'in'");
		assertPrintResults(null, "let _'invalid' : Boolean = false in _'invalid' and invalid");
		assertPrintResults(null, "let _'let' : Boolean = false in _'let'");
		assertPrintResults(null, "let _'not' : Boolean = false in not _'not'");
		assertPrintResults(null, "let _'null' : Boolean = false in _'null' and null");
		assertPrintResults(null, "let _'or' : Boolean = false in _'or' or _'or'");
		assertPrintResults(null, "let _'self' : Boolean = false in self or _'self'", "let _'self' : Boolean = false in self or self");
		assertPrintResults(null, "let _'then' : Boolean = false in if _'then' then _'then' else _'then' endif");
		assertPrintResults(null, "let _'true' : Boolean = false in _'true' and _'true'");
		assertPrintResults(null, "let _'xor' : Boolean = false in _'xor' xor _'xor'");
	}

	/**
	 * Tests the precedence on a specialized collection operator.
	 */
	public void test_SetDifference() {
		assertPrintResults(null, "let a : Set(Integer) = Set{1} in let b : Set(Integer) = Set{1} in a - b");
	}

	/**
	 * Tests the precedence on a specialized collection operator.
	 */
	public void test_SourceNavigationPrecedence() {
		assertPrintResults(null, "let a : Set(Integer) = Set{1} in (a - a)->isEmpty()");
		assertPrintResults(null, "let a : Set(Integer) = Set{1} in a->isEmpty()");
		assertPrintResults(null, "let a : Set(Integer) = Set{1} in a->asSet()->asSet()");
		assertPrintResults(null, "let a : Set(Integer) = Set{1} in a->select(true)->asSet()");
	}

	/**
	 * Tests the non-printing of implicoit collect's realization.
	 */
	public void test_ImplicitCollect() {
		assertPrintResults(null, "Set{1}.toString()");
	}
}
