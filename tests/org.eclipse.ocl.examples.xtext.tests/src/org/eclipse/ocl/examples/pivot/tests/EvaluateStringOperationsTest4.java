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

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.PatternSyntaxException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.messages.EvaluatorMessages;
import org.eclipse.ocl.pivot.messages.OCLMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.osgi.util.NLS;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for String operations.
 */
@SuppressWarnings("nls")
@RunWith(value = Parameterized.class)
public class EvaluateStringOperationsTest4 extends PivotTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false}, {true}};
		return Arrays.asList(data);
	}

	public EvaluateStringOperationsTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateStringOperations";
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

	@Test public void testStringAt() {
		assertQueryEquals(null, "t", "'test'.at(1)");
		assertQueryEquals(null, "e", "'test'.at(2)");
		assertQueryEquals(null, "t", "'test'.at(4)");
		// out of bounds
		assertQueryInvalid(null, "'test'.at(0)");
		assertQueryInvalid(null, "'test'.at(5)");
		assertQueryInvalid(null, "''.at(1)");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.at(1)");
		// null
		assertQueryInvalid(null, "let s : String = null in s.at(1)");
	}

	@Test public void testStringCharacters() {
		assertQueryEquals(null, new String[] {}, "''.characters()");
		assertQueryEquals(null, new String[] {"a"}, "'a'.characters()");
		assertQueryEquals(null, new String[] {"a", "\r", "\n", "b"}, "'a\\r\nb'.characters()");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.characters()");
		// null
		assertQueryInvalid(null, "let s : String = null in s.characters()");
	}

	@Test public void testStringConcat() {
		assertQueryEquals(null, "concatenationTest", "'concatenation'.concat('Test')");
		assertQueryEquals(null, "concatenation\n", "'concatenation'.concat('\\n')");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in 'concatenation'.concat(s)");
		assertQueryInvalid(null, "let s : String = invalid in s.concat('concatenation')");
		// null
		assertQueryInvalid(null, "let s : String = null in 'concatenation'.concat(s)");
		assertQueryInvalid(null, "let s : String = null in s.concat('concatenation')");
	}

	@Test public void testStringEndsWith() {
		assertQueryFalse(null, "'abcdef'.endsWith('aabcdef')");
		assertQueryTrue(null, "'abcdef'.endsWith('abcdef')");
		assertQueryTrue(null, "'abcdef'.endsWith('cdef')");
		assertQueryTrue(null, "'abcdef'.endsWith('f')");
		assertQueryTrue(null, "'abcdef'.endsWith('')");
		assertQueryTrue(null, "''.endsWith('')");
		assertQueryFalse(null, "''.endsWith('a')");
		assertQueryTrue(null, "'abcdef'.endsWith('')");
		assertQueryFalse(null, "'abcdef'.endsWith('bcd')");
		assertQueryFalse(null, "'abcdef'.endsWith('ab')");
		assertQueryFalse(null, "'abcdef'.endsWith('a')");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.endsWith('')");
		assertQueryInvalid(null, "let s : String = invalid in ''.endsWith(s)");
		// null
		assertQueryInvalid(null, "let s : String = null in s.endsWith('')");
		assertQueryInvalid(null, "let s : String = null in ''.endsWith(s)");
	}

	@Test public void testStringEqual() {
		assertQueryFalse(null, "'test' = 'se'");
		assertQueryTrue(null, "'test' = 'test'");
		assertQueryFalse(null, "'tESt' = 'TesT'");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s = 'se'");
		assertQueryInvalid(null, "let s : String = invalid in 'test' = s");
		assertQueryInvalid(null, "let s1 : String = invalid, s2 : String = invalid in s1 = s2");
		// null
		assertQueryFalse(null, "let s : String = null in s = 'se'");
		assertQueryFalse(null, "let s : String = null in 'test' = s");
		assertQueryTrue(null, "let s1 : String = null, s2 : String = null in s1 = s2");
	}

	@Test public void testStringEqualIgnoresCase() {
		assertQueryFalse(null, "'test'.equalsIgnoreCase('se')");
		assertQueryTrue(null, "'test'.equalsIgnoreCase('test')");
		assertQueryTrue(null, "'Test'.equalsIgnoreCase('tEst')");
		assertQueryTrue(null, "'tesT'.equalsIgnoreCase('teSt')");
		assertQueryTrue(null, "'TEST'.equalsIgnoreCase('test')");
		assertQueryTrue(null, "'test'.equalsIgnoreCase('TEST')");
	}

	@Test public void testStringGreaterThan() {
		// FIXME Analyzer-extraOperation String::> should not be defined
		assertQueryFalse(null, "'3' > '4'");
		assertQueryFalse(null, "'a' > 'b'");
		assertQueryFalse(null, "'aardvark' > 'aardvarks'");

		assertQueryTrue(null, "'3.2' > '3.1'");
		assertQueryTrue(null, "'a' > 'A'");
		assertQueryTrue(null, "'aardvark' > 'aardvarK'");

		assertQueryFalse(null, "'3' > '3'");
		assertQueryFalse(null, "'a' > 'a'");
		assertQueryFalse(null, "'aardvark' > 'aardvark'");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s > 'se'");
		assertQueryInvalid(null, "let s : String = invalid in 'test' > s");
		assertQueryInvalid(null, "let s1 : String = invalid, s2 : String = invalid in s1 > s2");
		// null
		assertQueryInvalid(null, "let s : String = null in s > 'se'");
		assertQueryInvalid(null, "let s : String = null in 'test' > s");
		assertQueryInvalid(null, "let s1 : String = null, s2 : String = null in s1 > s2");
	}

	@Test public void testStringGreaterThanOrEqual() {
		// FIXME Analyzer-extraOperation String::>= should not be defined
		assertQueryFalse(null, "'3' >= '4'");
		assertQueryFalse(null, "'a' >= 'b'");
		assertQueryFalse(null, "'aardvark' >= 'aardvarks'");

		assertQueryTrue(null, "'3.2' >= '3.1'");
		assertQueryTrue(null, "'a' >= 'A'");
		assertQueryTrue(null, "'aardvark' >= 'aardvarK'");

		assertQueryTrue(null, "'3' >= '3'");
		assertQueryTrue(null, "'a' >= 'a'");
		assertQueryTrue(null, "'aardvark' >= 'aardvark'");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s >= 'se'");
		assertQueryInvalid(null, "let s : String = invalid in 'test' >= s");
		assertQueryInvalid(null, "let s1 : String = invalid, s2 : String = invalid in s1 >= s2");
		// null
		assertQueryInvalid(null, "let s : String = null in s >= 'se'");
		assertQueryInvalid(null, "let s : String = null in 'test' >= s");
		assertQueryInvalid(null, "let s1 : String = null, s2 : String = null in s1 >= s2");
	}

	@Test public void testStringIndexOf() {
		assertQueryEquals(null, 1, "'test'.indexOf('t')");
		assertQueryEquals(null, 1, "'test'.indexOf('te')");
		assertQueryEquals(null, 2, "'test'.indexOf('es')");
		assertQueryEquals(null, 3, "'test'.indexOf('st')");
		assertQueryEquals(null, 5, "'tesla'.indexOf('a')");
		// out of bounds
		assertQueryEquals(null, 0, "'test'.indexOf('xyzzy')");
		assertQueryEquals(null, 0, "'test'.indexOf('est2')");
		// empty
		assertQueryEquals(null, 1, "'test'.indexOf('')");
		assertQueryEquals(null, 1, "''.indexOf('')");
		assertQueryEquals(null, 0, "''.indexOf('t')");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in 'test'.indexOf(s)");
		assertQueryInvalid(null, "let s : String = invalid in s.indexOf('s')");
		// null
		assertQueryInvalid(null, "let s : String = null in 'test'.indexOf(s)");
		assertQueryInvalid(null, "let s : String = null in s.indexOf('s')");
	}

	@Test public void testStringLastIndexOf() {
		assertQueryEquals(null, 4, "'test'.lastIndexOf('t')");
		assertQueryEquals(null, 1, "'test'.lastIndexOf('te')");
		assertQueryEquals(null, 2, "'test'.lastIndexOf('es')");
		assertQueryEquals(null, 3, "'test'.lastIndexOf('st')");
		assertQueryEquals(null, 5, "'tesla'.lastIndexOf('a')");
		assertQueryEquals(null, 1, "'ates'.lastIndexOf('a')");
		// out of bounds
		assertQueryEquals(null, 0, "'test'.lastIndexOf('xyzzy')");
		assertQueryEquals(null, 0, "'test'.lastIndexOf('est2')");
		// empty
		assertQueryEquals(null, 5, "'test'.lastIndexOf('')");
		assertQueryEquals(null, 1, "''.lastIndexOf('')");
		assertQueryEquals(null, 0, "''.lastIndexOf('t')");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in 'test'.lastIndexOf(s)");
		assertQueryInvalid(null, "let s : String = invalid in s.lastIndexOf('s')");
		// null
		assertQueryInvalid(null, "let s : String = null in 'test'.lastIndexOf(s)");
		assertQueryInvalid(null, "let s : String = null in s.lastIndexOf('s')");
	}

	@Test public void testStringLessThan() {
		// FIXME Analyzer-extraOperation String::< should not be defined
		assertQueryTrue(null, "'3' < '4'");
		assertQueryTrue(null, "'a' < 'b'");
		assertQueryTrue(null, "'aardvark' < 'aardvarks'");

		assertQueryFalse(null, "'3.2' < '3.1'");
		assertQueryFalse(null, "'a' < 'A'");
		assertQueryFalse(null, "'aardvark' < 'aardvarK'");

		assertQueryFalse(null, "'3' < '3'");
		assertQueryFalse(null, "'a' < 'a'");
		assertQueryFalse(null, "'aardvark' < 'aardvark'");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s < 'se'");
		assertQueryInvalid(null, "let s : String = invalid in 'test' < s");
		assertQueryInvalid(null, "let s1 : String = invalid, s2 : String = invalid in s1 < s2");
		// null
		assertQueryInvalid(null, "let s : String = null in s < 'se'");
		assertQueryInvalid(null, "let s : String = null in 'test' < s");
		assertQueryInvalid(null, "let s1 : String = null, s2 : String = null in s1 < s2");
	}

	@Test public void testStringLessThanOrEqual() {
		// FIXME Analyzer-extraOperation String::<= should not be defined
		assertQueryTrue(null, "'3' <= '4'");
		assertQueryTrue(null, "'a' <= 'b'");
		assertQueryTrue(null, "'aardvark' <= 'aardvarks'");

		assertQueryFalse(null, "'3.2' <= '3.1'");
		assertQueryFalse(null, "'a' <= 'A'");
		assertQueryFalse(null, "'aardvark' <= 'aardvarK'");

		assertQueryTrue(null, "'3' <= '3'");
		assertQueryTrue(null, "'a' <= 'a'");
		assertQueryTrue(null, "'aardvark' <= 'aardvark'");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s <= 'se'");
		assertQueryInvalid(null, "let s : String = invalid in 'test' <= s");
		assertQueryInvalid(null, "let s1 : String = invalid, s2 : String = invalid in s1 <= s2");
		// null
		assertQueryInvalid(null, "let s : String = null in s <= 'se'");
		assertQueryInvalid(null, "let s : String = null in 'test' <= s");
		assertQueryInvalid(null, "let s1 : String = null, s2 : String = null in s1 <= s2");
	}

	@Test public void testStringMatches() {
		assertQueryTrue(null, "'characters and spaces'.matches('[\\\\w\\\\s]+')");		// *2 for Java, *2 for OCL
		assertQueryFalse(null, "'characters and 3 digits'.matches('[\\\\p{Alpha}\\\\s]+')");
		//
		assertQueryTrue(null, "''.matches('')");
		assertQueryTrue(null, "''.matches('')");
		assertQueryFalse(null, "'a'.matches('')");
		assertQueryFalse(null, "''.matches('b')");
		//
		assertQueryInvalid(null, "'repla ce operation'.matches('a[b-')", null, PatternSyntaxException.class);
		//
		assertQueryInvalid(null, "let s : String = null in s.matches('(\\\\w+)\\\\s*')");
		assertQueryInvalid(null, "'repla ce operation'.matches(null)");
		//
		assertQueryInvalid(null, "let s : String = invalid in s.matches('(\\\\w+)\\\\s*')");
		assertQueryInvalid(null, "'repla ce operation'.matches(invalid)");
		// -- visual inspection of println's demonstrates cache re-use; this test just conforms cache still ok once full
		assertQueryEquals(null, 50, "let seq = Sequence{1..20}, rseq = seq->reverse(), seqs = Sequence{seq,rseq,seq,rseq,seq}->flatten() in seqs->iterate(i; acc : Integer = 0 | if '123456789'.matches('.*' + i.toString() + '.*') then acc + 1 else acc endif)");
	}

	@Test public void testStringNotEqual() {
		assertQueryTrue(null, "'test' <> 'se'");
		assertQueryFalse(null, "'test' <> 'test'");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s <> 'se'");
		assertQueryInvalid(null, "let s : String = invalid in 'test' <> s");
		assertQueryInvalid(null, "let s1 : String = invalid, s2 : String = invalid in s1 <> s2");
		// null
		assertQueryTrue(null, "let s : String = null in s <> 'se'");
		assertQueryTrue(null, "let s : String = null in 'test' <> s");
		assertQueryFalse(null, "let s1 : String = null, s2 : String = null in s1 <> s2");
	}

	@Test public void testStringOclAsType() {
		assertQueryInvalid(null, "'test'.oclAsType(Integer)");
		assertQueryEquals(null, "test", "'test'.oclAsType(String)");
		assertQueryEquals(null, "test", "'test'.oclAsType(OclAny)");
		assertQueryInvalid(null, "'test'.oclAsType(OclVoid)");
		assertQueryInvalid(null, "'test'.oclAsType(OclInvalid)");
	}

	@Test public void testStringOclIsInvalid() {
		assertQueryFalse(null, "'test'.oclIsInvalid()");
		assertQueryFalse(null, "''.oclIsInvalid()");
	}

	@Test public void testStringOclIsKindOf() {
		assertQueryFalse(null, "'test'.oclIsKindOf(Integer)");
		assertQueryTrue(null, "'test'.oclIsKindOf(String)");
		assertQueryTrue(null, "'test'.oclIsKindOf(OclAny)");
		assertQueryFalse(null, "'test'.oclIsKindOf(OclVoid)");
		assertQueryFalse(null, "'test'.oclIsKindOf(OclInvalid)");
	}

	@Test public void testStringOclIsTypeOf() {
		assertQueryFalse(null, "'test'.oclIsTypeOf(Integer)");
		assertQueryTrue(null, "'test'.oclIsTypeOf(String)");
		assertQueryFalse(null, "'test'.oclIsTypeOf(OclAny)");
		assertQueryFalse(null, "'test'.oclIsTypeOf(OclVoid)");
		assertQueryFalse(null, "'test'.oclIsTypeOf(OclInvalid)");
	}

	@Test public void testStringOclIsUndefined() {
		assertQueryFalse(null, "'test'.oclIsUndefined()");
		assertQueryFalse(null, "''.oclIsUndefined()");
	}

	@Test public void testStringPlus() {
		assertQueryEquals(null, "concatenationTest", "'concatenation' + 'Test'");
		assertQueryEquals(null, "concatenation\n", "'concatenation' + '\\n'");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in 'concatenation' + s");
		assertQueryInvalid(null, "let s : String = invalid in s + 'concatenation'");
		// null
		assertQueryInvalid(null, "let s : String = null in 'concatenation' + s");
		assertQueryInvalid(null, "let s : String = null in s + 'concatenation'");
	}

	@Test public void testStringReplaceAll() {
		assertQueryEquals(null, "rePlaceAll oPeration", "'replaceAll operation'.replaceAll('p', 'P')");
		assertQueryEquals(null, "ReplaceAllOperation", "'Repla ce All Operation'.replaceAll('(\\\\w+)\\\\s*', '$1')");
		//
		assertQueryEquals(null, "xx", "''.replaceAll('', 'xx')");
		assertQueryEquals(null, "xxrxxexxpxxlxxaxx xxcxxexx xxoxxpxxexxrxxaxxtxxixxoxxnxx", "'repla ce operation'.replaceAll('', 'xx')");
		assertQueryEquals(null, "", "'repla ce operation'.replaceAll('(\\\\w+)\\\\s*', '')");
		assertQueryEquals(null, "repla ce operation", "'repla ce operation'.replaceAll('', '')");
		//
		assertQueryInvalid(null, "'repla ce operation'.replaceAll('a[b-', '$1')", null, PatternSyntaxException.class);
		assertQueryInvalid(null, "'repla ce operation'.replaceAll('', '$1')", "No group 1", IndexOutOfBoundsException.class);
		//
		assertQueryInvalid(null, "let s : String = null in s.replaceAll('(\\\\w+)\\\\s*', '$1')");
		assertQueryInvalid(null, "'repla ce operation'.replaceAll(null, '$1')");
		assertQueryInvalid(null, "'repla ce operation'.replaceAll('(\\\\w+)\\\\s*', null)");
		//
		assertQueryInvalid(null, "let s : String = invalid in s.replaceAll('(\\\\w+)\\\\s*', '$1')");
		assertQueryInvalid(null, "'repla ce operation'.replaceAll(invalid, '$1')");
		assertQueryInvalid(null, "'repla ce operation'.replaceAll('(\\\\w+)\\\\s*', invalid)");
	}

	@Test public void testStringReplaceFirst() {
		assertQueryEquals(null, "rePlace operation", "'replace operation'.replaceFirst('p', 'P')");
		assertQueryEquals(null, "replace operation", "'repla ce operation'.replaceFirst('(\\\\w+)\\\\s*', '$1')");
		//
		assertQueryEquals(null, "xx", "''.replaceFirst('', 'xx')");
		assertQueryEquals(null, "xxrepla ce operation", "'repla ce operation'.replaceFirst('', 'xx')");
		assertQueryEquals(null, "ce operation", "'repla ce operation'.replaceFirst('(\\\\w+)\\\\s*', '')");
		assertQueryEquals(null, "repla ce operation", "'repla ce operation'.replaceFirst('', '')");
		//
		assertQueryInvalid(null, "'repla ce operation'.replaceFirst('a[b-', '$1')", null, PatternSyntaxException.class);
		assertQueryInvalid(null, "'repla ce operation'.replaceFirst('', '$1')", "No group 1", IndexOutOfBoundsException.class);
		//
		assertQueryInvalid(null, "let s : String = null in s.replaceFirst('(\\\\w+)\\\\s*', '$1')");
		assertQueryInvalid(null, "'repla ce operation'.replaceFirst(null, '$1')");
		assertQueryInvalid(null, "'repla ce operation'.replaceFirst('(\\\\w+)\\\\s*', null)");
		//
		assertQueryInvalid(null, "let s : String = invalid in s.replaceFirst('(\\\\w+)\\\\s*', '$1')");
		assertQueryInvalid(null, "'repla ce operation'.replaceFirst(invalid, '$1')");
		assertQueryInvalid(null, "'repla ce operation'.replaceFirst('(\\\\w+)\\\\s*', invalid)");
	}

	@Test public void testStringSize() {
		assertQueryEquals(null, Integer.valueOf(4), "'test'.size()"); //$NON-NLS-2$
		assertQueryEquals(null, Integer.valueOf(0), "''.size()"); //$NON-NLS-2$
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.size()"); //$NON-NLS-2$
		// null
		assertQueryInvalid(null, "let s : String = null in s.size()"); //$NON-NLS-2$
	}

	@Test public void testStringStartsWith() {
		assertQueryFalse(null, "'abcdef'.startsWith('abcdefg')");
		assertQueryTrue(null, "'abcdef'.startsWith('abcdef')");
		assertQueryTrue(null, "'abcdef'.startsWith('abcd')");
		assertQueryTrue(null, "'abcdef'.startsWith('a')");
		assertQueryTrue(null, "'abcdef'.startsWith('')");
		assertQueryTrue(null, "''.startsWith('')");
		assertQueryFalse(null, "''.startsWith('a')");
		assertQueryTrue(null, "'abcdef'.startsWith('')");
		assertQueryFalse(null, "'abcdef'.startsWith('bcd')");
		assertQueryFalse(null, "'abcdef'.startsWith('ef')");
		assertQueryFalse(null, "'abcdef'.startsWith('f')");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.startsWith('')");
		assertQueryInvalid(null, "let s : String = invalid in ''.startsWith(s)");
		// null
		assertQueryInvalid(null, "let s : String = null in s.startsWith('')");
		assertQueryInvalid(null, "let s : String = null in ''.startsWith(s)");
	}

	@Test public void testStringSubstituteAll() {
		assertQueryEquals(null, "subsTiTuTeAll operaTion", "'substituteAll operation'.substituteAll('t', 'T')");
		//
		assertQueryEquals(null, "xx", "''.replaceAll('', 'xx')");
		assertQueryEquals(null, "xxrxxexxpxxlxxaxx xxcxxexx xxoxxpxxexxrxxaxxtxxixxoxxnxx", "'repla ce operation'.substituteAll('', 'xx')");
		assertQueryEquals(null, "repla ce operation", "'repla ce operation'.substituteAll('(\\\\w+)\\\\s*', '')");
		assertQueryEquals(null, "repla ce operation", "'repla ce operation'.substituteAll('', '')");
		//
		assertQueryInvalid(null, "let s : String = null in s.substituteAll('(\\\\w+)\\\\s*', '$1')");
		assertQueryInvalid(null, "'repla ce operation'.substituteAll(null, '$1')");
		assertQueryInvalid(null, "'repla ce operation'.substituteAll('(\\\\w+)\\\\s*', null)");
		//
		assertQueryInvalid(null, "let s : String = invalid in s.substituteAll('(\\\\w+)\\\\s*', '$1')");
		assertQueryInvalid(null, "'repla ce operation'.substituteAll(invalid, '$1')");
		assertQueryInvalid(null, "'repla ce operation'.substituteAll('(\\\\w+)\\\\s*', invalid)");
	}

	@Test public void testStringSubstituteFirst() {
		assertQueryEquals(null, "subsTiTuTeFirst operaTion", "'substiTuTeFirst operaTion'.substituteFirst('t', 'T')");
		assertQueryEquals(null, "SubstiTuTeFirst operaTion", "'substiTuTeFirst operaTion'.substituteFirst('s', 'S')");
		assertQueryEquals(null, "substiTuTeFirst operaTioN", "'substiTuTeFirst operaTion'.substituteFirst('n', 'N')");
		assertQueryEquals(null, "substiTuTeFirst operaTion", "'substiTuTeFirst operaTion'.substituteFirst('n', 'n')");
		assertQueryEquals(null, "substiTuTeFirst operaTiON", "'substiTuTeFirst operaTion'.substituteFirst('on', 'ON')");
		assertQueryEquals(null, "a[b-c]d\r\n*", "'a[b-c]d\\\\w*'.substituteFirst('\\\\w', '\r\n')");
		//
		assertQueryEquals(null, "xx", "''.substituteFirst('', 'xx')");
		assertQueryEquals(null, "xxrepla ce operation", "'repla ce operation'.substituteFirst('', 'xx')");
		assertQueryEquals(null, "repla ce operation", "'repla ce operation'.substituteFirst('', '')");
		//
		assertQueryInvalid(null, "'repla ce operation'.substituteFirst('(\\\\w+)\\\\s*', '')",
			ClassUtil.bind(EvaluatorMessages.MissingSubstring, "(\\w+)\\s*", "repla ce operation"), null);
		//
		assertQueryInvalid(null, "let s : String = null in s.substituteFirst('(\\\\w+)\\\\s*', '$1')");
		assertQueryInvalid(null, "'repla ce operation'.substituteFirst(null, '$1')");
		assertQueryInvalid(null, "'repla ce operation'.substituteFirst('(\\\\w+)\\\\s*', null)");
		//
		assertQueryInvalid(null, "let s : String = invalid in s.substituteFirst('(\\\\w+)\\\\s*', '$1')");
		assertQueryInvalid(null, "'repla ce operation'.substituteFirst(invalid, '$1')");
		assertQueryInvalid(null, "'repla ce operation'.substituteFirst('(\\\\w+)\\\\s*', invalid)");
	}

	@Test public void testStringSubstring() {
		assertQueryEquals(null, "t", "'test'.substring(1, 1)");
		assertQueryEquals(null, "es", "'test'.substring(2, 3)");
		assertQueryEquals(null, "t", "'test'.substring(4, 4)");
		// illegal
		assertQueryInvalid(null, "'test'.substring(2, 1)");
		assertQueryInvalid(null, "'test'.substring(3, 1)");
		// out of bounds
		assertQueryInvalid(null, "'test'.substring(0, 1)");
		assertQueryInvalid(null, "'test'.substring(4, 5)");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.substring(1, 1)");
		assertQueryInvalid(null, "let s : String = invalid in s.substring(5, 5)");
		// null
		assertQueryInvalid(null, "let s : String = null in s.substring(1, 1)");
		assertQueryInvalid(null, "let s : String = null in s.substring(5, 5)");
	}

	@Test public void testStringToBoolean() {
		assertQueryTrue(null, "'true'.toBoolean()");
		assertQueryFalse(null, "' true'.toBoolean()");
		assertQueryFalse(null, "'true '.toBoolean()");
		assertQueryFalse(null, "'True'.toBoolean()");
		assertQueryFalse(null, "'false'.toBoolean()");
		assertQueryFalse(null, "'-4'.toBoolean()");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.toBoolean()");
		// null
		assertQueryInvalid(null, "let s : String = null in s.toBoolean()");
	}

	@Test public void testStringToInteger() {
		assertQueryEquals(null, Integer.valueOf(4), "'4'.toInteger()");
		assertQueryEquals(null, Integer.valueOf(-4), "'-4'.toInteger()");
		assertQueryInvalid(null, "'4.0'.toInteger()", NLS.bind(EvaluatorMessages.InvalidInteger, "4.0"), NumberFormatException.class);

		assertQueryInvalid(null, "'2.4.0'.toInteger()");
		assertQueryInvalid(null, "'a'.toInteger()");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.toInteger()");
		// null
		assertQueryInvalid(null, "let s : String = null in s.toInteger()");
	}

	@Test public void testStringToLowerCase() {
//		checkForUTF8Encoding()		
		assertQueryEquals(null, "4", "'4'.toLowerCase()"); //$NON-NLS-2$
		assertQueryEquals(null, "mixed", "'MiXeD'.toLowerCase()"); //$NON-NLS-2$
		assertQueryEquals(null, "upper", "'UPPER'.toLowerCase()"); //$NON-NLS-2$
		// Ensures word-final sigma and regular sigmas are converted as needed
		// TODO re-enable once the Unicode problems on Hudson have been resolved
//		assertQueryEquals(null, "ὀδυσσεύς", "'ὈΔΥΣΣΕΎΣ'.toLowerCase()");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.toLowerCase()");
		// null
		assertQueryInvalid(null, "let s : String = null in s.toLowerCase()");
	}

	@Test public void testStringToReal() {
		assertQueryEquals(null, 4.0, "'4'.toReal()", 0.0);
		assertQueryEquals(null, -4.0, "'-4'.toReal()", 0.0);
		assertQueryEquals(null, 4.0, "'4.0'.toReal()", 0.0);

		assertQueryInvalid(null, "'2.4.0'.toReal()", NLS.bind(EvaluatorMessages.InvalidReal, "2.4.0"), NumberFormatException.class);
		assertQueryInvalid(null, "'a'.toReal()", NLS.bind(EvaluatorMessages.InvalidReal, "a"), NumberFormatException.class);
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.toReal()");
		// null
		assertQueryInvalid(null, "let s : String = null in s.toReal()");
	}

	@Test public void testStringToString() {
		assertQueryEquals(null, "4.0", "'4.0'.toString()");
		assertQueryEquals(null, "4.0\t4", "('4.0' + '\t' + '4').toString()");
	}

	@Test public void testStringToUpperCase() {
//		checkForUTF8Encoding();
		assertQueryEquals(null, "4", "'4'.toUpperCase()");
		assertQueryEquals(null, "MIXED", "'MiXeD'.toUpperCase()");
		assertQueryEquals(null, "LOWER", "'lower'.toUpperCase()");
		
		// Ensures word-final sigma and regular sigmas are converted as needed
		// TODO re-enable once the Unicode problems on Hudson have been resolved
//		assertQueryEquals(null, "ὈΔΥΣΣΕΎΣ", "'ὀδυσσεύς'.toUpperCase()");
		
		// Sharp s should be mapped to a double S upper case
		// TODO re-enable once the Unicode problems on Hudson have been resolved
//		assertQueryEquals(null, "SS", "'ß'.toUpperCase()");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.toUpperCase()");
		// null
		assertQueryInvalid(null, "let s : String = null in s.toUpperCase()");
	}

	@Test public void testStringTokenize() {
		assertQueryResults(null, "Sequence{'a','b','c','d'}", "'\na b\tc\fd\r'.tokenize()");
		assertQueryResults(null, "Sequence{'a','b','c','d'}", "' \t\n\r\fa b\tc\fd \t\n\r\f'.tokenize()");
		assertQueryResults(null, "Sequence{' ','\t','\n','\r','\f','a',' ','b','\t','c','\f','d',' ','\t','\n','\r','\f'}", "' \t\n\r\fa b\tc\fd \t\n\r\f'.tokenize(' \t\n\r\f', true)");
		assertQueryResults(null, "Sequence{'\na',' ', 'b\tc\fd\r'}", "'\na b\tc\fd\r'.tokenize(' ', true)");
		assertQueryResults(null, "Sequence{'\na','b\tc\fd\r'}", "'\na b\tc\fd\r'.tokenize(' ')");
		assertQueryResults(null, "Sequence{'1','2','3','4'}", "'1.2.3.4'.tokenize('.')");					// BUG 422296
		assertQueryResults(null, "Sequence{}", "''.tokenize(' ', true)");
		assertQueryResults(null, "Sequence{' \t\n\r\f'}", "' \t\n\r\f'.tokenize('', true)");
		assertQueryResults(null, "Sequence{}", "''.tokenize('', true)");
		assertQueryResults(null, "Sequence{}", "''.tokenize(' \t\n\r\f', true)");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.tokenize()");
		assertQueryInvalid(null, "let s : String = invalid in s.tokenize('')");
		assertQueryInvalid(null, "let s : String = invalid in s.tokenize('',true)");
		assertQueryInvalid(null, "let s : String = invalid in ''.tokenize(s)");
		assertQueryInvalid(null, "let s : String = invalid in ''.tokenize(s,true)");
		assertQueryInvalid(null, "let b : Boolean = invalid in ''.tokenize('',b)");
		// null
		assertQueryInvalid(null, "let s : String = null in s.tokenize()");
		assertQueryInvalid(null, "let s : String = null in s.tokenize('')");
		assertQueryInvalid(null, "let s : String = null in s.tokenize('',true)");
		assertQueryInvalid(null, "let s : String = null in ''.tokenize(s)");
		assertQueryInvalid(null, "let s : String = null in ''.tokenize(s,true)");
		assertQueryInvalid(null, "let b : Boolean = null in ''.tokenize('',b)");
		//
		assertSemanticErrorQuery("''.tokenize('',false,null)", OCLMessages.UnresolvedOperationCall_ERROR_, "String", "tokenize", "'',false,null");
	}

	@Test public void testStringTrim() {
		assertQueryEquals(null, "ab", "'ab'.trim()");
		assertQueryEquals(null, "a", "'a'.trim()");
		assertQueryEquals(null, "", "''.trim()");
		assertQueryEquals(null, "a \t\n\r\fb", "'\na \t\n\r\fb\n'.trim()");
		assertQueryEquals(null, "", "' \t\n\r\f \t\n\r\f'.trim()");
		// invalid
		assertQueryInvalid(null, "let s : String = invalid in s.trim()");
		// null
		assertQueryInvalid(null, "let s : String = null in s.trim()");
	}
}
