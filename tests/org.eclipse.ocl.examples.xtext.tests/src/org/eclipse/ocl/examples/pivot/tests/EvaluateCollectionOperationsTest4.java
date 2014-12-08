/*******************************************************************************
 * Copyright (c) 2010, 2013 Eclipse Modeling Project and others.
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.pivot.messages.OCLMessages;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * Tests for collection operations.
 */
@SuppressWarnings("nls")
@RunWith(value = Parameterized.class)
public class EvaluateCollectionOperationsTest4 extends PivotTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false}, {true}};
		return Arrays.asList(data);
	}

	public EvaluateCollectionOperationsTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateCollectionOperations";
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

	@Test public void testCollectionAppend() {
		assertQueryResults(null, "Sequence{'a', 'b', 'c'}", "Sequence{'a', 'b'}->append('c')");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b'}->append('c')");
		assertQueryResults(null, "Sequence{1..4,0}", "Sequence{1..4}->append(0)");
		assertQueryResults(null, "Sequence{1..4,4}", "Sequence{1..4}->append(4)");
		assertQueryResults(null, "Sequence{1..5}", "Sequence{1..4}->append(5)");
		assertQueryResults(null, "Sequence{1..4,6}", "Sequence{1..4}->append(6)");
		assertQueryResults(null, "OrderedSet{1..4,0}", "OrderedSet{1..4}->append(0)");
		assertQueryResults(null, "OrderedSet{1,3,4,2}", "OrderedSet{1..4}->append(2)");
		assertQueryResults(null, "OrderedSet{1..5}", "OrderedSet{1..4}->append(5)");
		assertQueryResults(null, "OrderedSet{1..4,6}", "OrderedSet{1..4}->append(6)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->append('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->append('a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->append(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->append(invalid)");
		// null collection
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->append('a')");
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->append('a')");
		// null collection element
		assertQueryResults(null, "Sequence{'a', 'b', null}", "Sequence{'a', 'b'}->append(null)");
		assertQueryResults(null, "OrderedSet{'a', 'b', null}", "OrderedSet{'a', 'b'}->append(null)");
		assertQueryResults(null, "Sequence{'a', null, 'b', null}", "Sequence{'a', null, 'b'}->append(null)");
		assertQueryResults(null, "OrderedSet{'a', 'b', null}", "OrderedSet{'a', null, 'b'}->append(null)");
		assertQueryResults(null, "Sequence{'1..2', null}", "Sequence{'1..2'}->append(null)");
		assertQueryResults(null, "OrderedSet{'1..2', null}", "OrderedSet{'1..2'}->append(null)");
	}

	@Test public void testCollectionAppendAll() {
		assertQueryResults(null, "Sequence{'a', 'b', 'c', 'd'}", "Sequence{'a', 'b'}->appendAll(Sequence{'c', 'd'})");
		assertQueryResults(null, "Sequence{'a', 'b', 'c', 'd'}", "Sequence{'a', 'b'}->appendAll(OrderedSet{'c', 'd'})");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c', 'd'}", "OrderedSet{'a', 'b'}->appendAll(Sequence{'c', 'd'})");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c', 'd'}", "OrderedSet{'a', 'b'}->appendAll(OrderedSet{'c', 'd'})");
		assertQueryResults(null, "Sequence{10..40,0..10}", "Sequence{10..40}->appendAll(Sequence{0..10})");
		assertQueryResults(null, "Sequence{10..40,40..50}", "Sequence{10..40}->appendAll(Sequence{40..50})");
		assertQueryResults(null, "Sequence{1..9}", "Sequence{1..4}->appendAll(Sequence{5..9})");
		assertQueryResults(null, "Sequence{1..4,6..10}", "Sequence{1..4}->appendAll(Sequence{6..10})");
		assertQueryResults(null, "OrderedSet{12..40,0..11}", "OrderedSet{10..40}->appendAll(OrderedSet{0..11})");
		assertQueryResults(null, "OrderedSet{1,3,2,4}", "OrderedSet{1..4}->appendAll(OrderedSet{2,4})");
		assertQueryResults(null, "OrderedSet{1..10}", "OrderedSet{1..4}->appendAll(OrderedSet{5..10})");
		assertQueryResults(null, "OrderedSet{1..4,6..10}", "OrderedSet{1..4}->appendAll(OrderedSet{6..10})");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->appendAll(Sequence{'c', 'd'})");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->appendAll(OrderedSet{'c', 'd'})");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->appendAll(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->appendAll(invalid)");
		// null collection
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->appendAll(Sequence{'c', 'd'})");
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->appendAll(OrderedSet{'c', 'd'})");
		assertQueryInvalid(null, "Sequence{'a', 'b'}->appendAll(null)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->appendAll(null)");
		// null collection element
		assertQueryResults(null, "Sequence{'a', 'b', null, null}", "Sequence{'a', 'b'}->appendAll(Sequence{null,null})");
		assertQueryResults(null, "OrderedSet{'a', 'b', null}", "OrderedSet{'a', 'b'}->appendAll(Sequence{null,null})");
		assertQueryResults(null, "Sequence{'a', null, 'b', null, null}", "Sequence{'a', null, 'b'}->appendAll(Sequence{null,null})");
		assertQueryResults(null, "OrderedSet{'a', 'b', null}", "OrderedSet{'a', null, 'b'}->appendAll(Sequence{null,null})");
		assertQueryResults(null, "Sequence{'1..2', null, null}", "Sequence{'1..2'}->appendAll(Sequence{null,null})");
		assertQueryResults(null, "OrderedSet{'1..2', null}", "OrderedSet{'1..2'}->appendAll(Sequence{null,null})");
	}

	@Test public void testCollectionAsBag() {
		assertQueryEquals(null, getEmptyBagValue(), "Sequence{}->asBag()");
		assertQueryEquals(null, getEmptyBagValue(), "Bag{}->asBag()");
		assertQueryEquals(null, getEmptyBagValue(), "Set{}->asBag()");
		assertQueryEquals(null, getEmptyBagValue(), "OrderedSet{}->asBag()");

		assertQueryResults(null, "Bag{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asBag()");
		assertQueryResults(null, "Bag{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asBag()");
		assertQueryResults(null, "Bag{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asBag()");
		assertQueryResults(null, "Bag{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asBag()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->asBag()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->asBag()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->asBag()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->asBag()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->asBag()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->asBag()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->asBag()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->asBag()");
	}

	@Test public void testCollectionAsOrderedSet() {
		assertQueryEquals(null, getEmptyOrderedSetValue(), "Sequence{}->asOrderedSet()");
		assertQueryEquals(null, getEmptyOrderedSetValue(), "Bag{}->asOrderedSet()");
		assertQueryEquals(null, getEmptyOrderedSetValue(), "Set{}->asOrderedSet()");
		assertQueryEquals(null, getEmptyOrderedSetValue(), "OrderedSet{}->asOrderedSet()");

		assertQueryResults(null, "OrderedSet{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asOrderedSet()");
		assertQueryResults(null, "OrderedSet{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asOrderedSet()");

		/*
		 * Bag and Set are not ordered, simply check that the result is an
		 * OrderedSet and it contains all needed values.
		 */
		assertResultContainsAll(null, "OrderedSet{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asOrderedSet()");
		assertResultContainsAll(null, "OrderedSet{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asOrderedSet()");

		assertQueryResults(null, "OrderedSet{'a', 'b', 'c'}", "Sequence{'a', 'b', 'c', 'b'}->asOrderedSet()");
		assertResultContainsAll(null, "OrderedSet{'a', 'b', 'c'}", "Bag{'a', 'b', 'c', 'b'}->asOrderedSet()");
		assertResultContainsAll(null, "OrderedSet{'a', 'b', 'c'}", "Set{'a', 'b', 'c', 'b'}->asOrderedSet()");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b', 'c', 'b'}->asOrderedSet()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->asOrderedSet()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->asOrderedSet()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->asOrderedSet()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->asOrderedSet()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->asOrderedSet()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->asOrderedSet()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->asOrderedSet()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->asOrderedSet()");
	}

	@Test public void testCollectionAsSequence() {
		assertQueryEquals(null, getEmptySequenceValue(), "Sequence{}->asSequence()");
		assertQueryEquals(null, getEmptySequenceValue(), "Bag{}->asSequence()");
		assertQueryEquals(null, getEmptySequenceValue(), "Set{}->asSequence()");
		assertQueryEquals(null, getEmptySequenceValue(), "OrderedSet{}->asSequence()");

		assertQueryResults(null, "Sequence{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asSequence()");
		assertQueryResults(null, "Sequence{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asSequence()");
//		assertQueryResults(null, "OrderedSet{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asSequence()");

		/*
		 * Bag and Set are not ordered, simply check that the result is a
		 * Sequence and it contains all needed values.
		 */
		assertResultContainsAll(null, "Sequence{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asSequence()");
		assertResultContainsAll(null, "Sequence{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asSequence()");
		// invalid collection
//		assertQueryInvalid(null, "invalid->asSequence()");
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->asSequence()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->asSequence()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->asSequence()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->asSequence()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->asSequence()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->asSequence()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->asSequence()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->asSequence()");
	}

	@Test public void testCollectionAsSet() {
		assertQueryEquals(null, getEmptySetValue(), "Sequence{}->asSet()");
		assertQueryEquals(null, getEmptySetValue(), "Bag{}->asSet()");
		assertQueryEquals(null, getEmptySetValue(), "Set{}->asSet()");
		assertQueryEquals(null, getEmptySetValue(), "OrderedSet{}->asSet()");

		assertQueryResults(null, "Set{1, 2.0, '3'}", "Sequence{1, 2.0, '3'}->asSet()");
		assertResultContainsAll(null, "Set{1, 2.0, '3'}", "Bag{1, 2.0, '3'}->asSet()");
		assertResultContainsAll(null, "Set{1, 2.0, '3'}", "Set{1, 2.0, '3'}->asSet()");
		assertQueryResults(null, "Set{1, 2.0, '3'}", "OrderedSet{1, 2.0, '3'}->asSet()");

		assertQueryResults(null, "Set{'a', 'b', 'c'}", "Sequence{'a', 'b', 'c', 'b'}->asSet()");
		assertQueryResults(null, "Set{'a', 'b', 'c'}", "Bag{'a', 'b', 'c', 'b'}->asSet()");
		assertQueryResults(null, "Set{'a', 'b', 'c'}", "Set{'a', 'b', 'c', 'b'}->asSet()");
		assertQueryResults(null, "Set{'a', 'b', 'c'}", "OrderedSet{'a', 'b', 'c', 'b'}->asSet()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->asSet()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->asSet()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->asSet()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->asSet()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->asSet()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->asSet()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->asSet()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->asSet()");
	}

	@Test public void testCollectionAt() {
		assertQueryEquals(null, "a", "Sequence{'a', 'b'}->at(1)");
		assertQueryEquals(null, "b", "OrderedSet{'a', 'b'}->at(2)");
		assertQueryEquals(null, -3, "Sequence{-3..-1}->at(1)");
		assertQueryInvalid(null, "Sequence{-1..-3}->at(3)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->at(1)");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->at(1)");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', invalid}->at(1)");
		assertQueryInvalid(null, "OrderedSet{'a', invalid}->at(1)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->at(1)");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->at(1)");
		// null collection element
		assertQueryNull(null, "Sequence{null, 'a'}->at(1)");
		assertQueryNull(null, "OrderedSet{null, 'a'}->at(1)");
		// out of bounds
		assertQueryInvalid(null, "Sequence{'a'}->at(0)");
		assertQueryInvalid(null, "OrderedSet{'a'}->at(0)");

		assertQueryInvalid(null, "Sequence{'a'}->at(2)");
		assertQueryInvalid(null, "OrderedSet{'a'}->at(2)");
		
		assertQueryInvalid(null, "Sequence{-1..-3}->at(0)");
		assertQueryInvalid(null, "Sequence{-1..-3}->at(4)");
	}

	@Test public void testCollectionCount() {
		assertQueryEquals(null, 1, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		assertQueryEquals(null, 3, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(4)");
		assertQueryEquals(null, 3, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(-(-4))");
		assertQueryEquals(null, 3, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertQueryEquals(null, 2, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");
		assertQueryEquals(null, 1, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		assertQueryEquals(null, 3, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(4)");
		assertQueryEquals(null, 3, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(-(-4))");
		assertQueryEquals(null, 3, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertQueryEquals(null, 2, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");
		assertQueryEquals(null, 1, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		assertQueryEquals(null, 1, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(4)");
		assertQueryEquals(null, 1, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(-(-4))");
		assertQueryEquals(null, 1, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertQueryEquals(null, 1, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");
		assertQueryEquals(null, 1, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(3)");
		assertQueryEquals(null, 1, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(4)");
		assertQueryEquals(null, 1, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(-(-4))");
		assertQueryEquals(null, 1, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(4.0)");
		assertQueryEquals(null, 1, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count('test')");
		assertQueryEquals(null, 1, "Sequence{-4..-4}->count(-4)");
		assertQueryEquals(null, 1, "Sequence{-4..-1}->count(-4)");
		assertQueryEquals(null, 0, "Sequence{-1..-4}->count(-4)");
		assertQueryEquals(null, 1, "Sequence{-4..-1}->count(-1)");
		assertQueryEquals(null, 0, "Sequence{-1..-4}->count(-1)");

		assertQueryEquals(null, 0, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
		assertQueryEquals(null, 0, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
		assertQueryEquals(null, 0, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
		assertQueryEquals(null, 0, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(0)");
		assertQueryEquals(null, 0, "Sequence{-4..-1}->count(-5)");
		assertQueryEquals(null, 0, "Sequence{-1..-4}->count(-5)");
		assertQueryEquals(null, 0, "Sequence{-4..-1}->count(0)");
		assertQueryEquals(null, 0, "Sequence{-1..-4}->count(0)");
		assertQueryEquals(null, 0, "Sequence{-1..-4}->count('x')");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->count(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->count(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->count(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in os->count(0)");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");
		assertQueryInvalid(null, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");
		assertQueryInvalid(null, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");
		assertQueryInvalid(null, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(invalid)");

		assertQueryInvalid(null, "Sequence{3, invalid, 4.0, invalid, 'test'}->count(3)");
		assertQueryInvalid(null, "Bag{3, invalid, 4.0, invalid, 'test'}->count(3)");
		assertQueryInvalid(null, "Set{3, invalid, 4.0, invalid, 'test'}->count(3)");
		assertQueryInvalid(null, "OrderedSet{3, invalid, 4.0, invalid, 'test'}->count(3)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->count(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->count(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->count(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in os->count(0)");
		// null collection element
		assertQueryEquals(null, 0, "Sequence{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");
		assertQueryEquals(null, 0, "Bag{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");
		assertQueryEquals(null, 0, "Set{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");
		assertQueryEquals(null, 0, "OrderedSet{3, 'test', 4.0, 4, 4.0, 'test'}->count(null)");

		assertQueryEquals(null, 2, "Sequence{3, null, 4.0, null, 'test'}->count(null)");
		assertQueryEquals(null, 2, "Bag{3, null, 4.0, null, 'test'}->count(null)");
		assertQueryEquals(null, 1, "Set{3, null, 4.0, null, 'test'}->count(null)");
		assertQueryEquals(null, 1, "OrderedSet{3, null, 4.0, null, 'test'}->count(null)");
	}

	@Test public void testCollectionElementType() {
		DomainStandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
		assertQueryEquals(null, standardLibrary.getStringType(), "Sequence{'1', '2', '3'}->oclType().elementType");
		assertQueryEquals(null, standardLibrary.getOclAnyType(), "Sequence{1, 2.0, '3'}->oclType().elementType");
		assertQueryEquals(null, standardLibrary.getIntegerType(), "Sequence{1, 2, 3}->oclType().elementType");
		assertQueryEquals(null, standardLibrary.getIntegerType(), "Sequence{1, 2, 3}->oclAsType(Collection(Real))->oclType().elementType");
// FIXME fails because common type is Set(T) and then because T is not type-servable and has no OclAny inheritance
//		assertQueryEquals(null, metaModelManager.getSetType(), "Sequence{Set{1}, Set{2.0}, Set{'3'}}->elementType");
// FIXME fails because common type is inadequate for implicit collect
//				assertQueryEquals(null, metaModelManager.getOclAnyType(), "Sequence{Set{1}, Set{2.0}, Set{'3'}}.elementType");
	}

	@Test public void testCollectionEqual() {		
		assertQueryFalse(null, "Bag{1} = 1");
		assertQueryFalse(null, "OrderedSet{1} = 1");
		assertQueryFalse(null, "Sequence{1} = 1");
		assertQueryFalse(null, "Set{1} = 1");

		assertQueryFalse(null, "1 = Bag{1}");
		assertQueryFalse(null, "1 = OrderedSet{1}");
		assertQueryFalse(null, "1 = Sequence{1}");
		assertQueryFalse(null, "1 = Set{1}");
		assertQueryFalse(null, "Set{1} = Set{Set{1}}");

		assertQueryFalse(null, "Bag{1.01} = Bag{1}");
		assertQueryFalse(null, "OrderedSet{1.01} = OrderedSet{1}");
		assertQueryFalse(null, "Sequence{1.01} = Sequence{1}");
		assertQueryFalse(null, "Set{1.01} = Set{1}");
		assertQueryFalse(null, "Set{Set{1.01}} = Set{Set{1}}");

		assertQueryTrue(null, "Bag{1.0} = Bag{1}");
		assertQueryTrue(null, "OrderedSet{1.0} = OrderedSet{1}");
		assertQueryTrue(null, "Sequence{1.0} = Sequence{1}");
		assertQueryTrue(null, "Set{1.0} = Set{1}");
		assertQueryTrue(null, "Set{Set{1.0}} = Set{Set{1}}");

		assertQueryTrue(null, "Sequence{1,2} = Sequence{1,2}");
		assertQueryTrue(null, "Sequence{1..2} = Sequence{1..2}");
		assertQueryTrue(null, "Sequence{1..2} = Sequence{1,2}");
		assertQueryTrue(null, "Sequence{1,2} = Sequence{1..2}");
		assertQueryFalse(null, "Sequence{1..2} = Sequence{2,1}");
		assertQueryFalse(null, "Sequence{1..2} = Sequence{1,2,1}");
		assertQueryTrue(null, "OrderedSet{1,2} = OrderedSet{1,2}");
		assertQueryTrue(null, "OrderedSet{1..2} = OrderedSet{1..2}");
		assertQueryTrue(null, "OrderedSet{1..2} = OrderedSet{1,2}");
		assertQueryTrue(null, "OrderedSet{1,2} = OrderedSet{1..2}");
		assertQueryFalse(null, "OrderedSet{1..2} = OrderedSet{2,1}");
		assertQueryTrue(null, "OrderedSet{1..2} = OrderedSet{1,2,1}");
		assertQueryFalse(null, "Sequence{1..2} = OrderedSet{1,2}");
		// null collection element

		assertQueryTrue(null, "Bag{null} = Bag{null}");
		assertQueryTrue(null, "OrderedSet{null} = OrderedSet{null}");
		assertQueryTrue(null, "Sequence{null} = Sequence{null}");
		assertQueryTrue(null, "Set{null} = Set{null}");
		assertQueryTrue(null, "Set{Set{null}} = Set{Set{null}}");
	}

	@Test public void testCollectionEqualOrderedXOrdered() {
		// same order, same quantities
		assertQueryTrue(null, "Sequence{4, 5, 'test'} = Sequence{4, 5, 'test'}");
		assertQueryTrue(null, "Sequence{4, 5, 'test', 5} = Sequence{4, 5, 'test', 5}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 5} = OrderedSet{4, 5, 'test'}");
		assertQueryFalse(null, "Sequence{4, 5, 'test'} = OrderedSet{4, 5, 'test', 5}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 5} = Sequence{4, 5, 'test'}");

		// distinct order, same quantities
		assertQueryFalse(null, "Sequence{4, 5, 'test'} = Sequence{4, 'test', 5}");
		assertQueryFalse(null, "Sequence{4, 5, 'test', 5} = Sequence{5, 4, 'test', 5}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 5} = OrderedSet{4, 'test', 5}");
		assertQueryFalse(null, "Sequence{4, 5, 'test'} = OrderedSet{5, 4, 'test', 5}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 5} = Sequence{5, 4, 'test'}");

		// distinct quantities
		assertQueryFalse(null, "Sequence{4, 5, 'test', 5} = Sequence{4, 5, 'test'}");
		assertQueryFalse(null, "Sequence{4, 5, 'test', 5} = OrderedSet{4, 5, 'test', 5}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 5} = Sequence{4, 5, 'test', 5}");
	}

	@Test public void testCollectionEqualOrderedXUnordered() {
		// same quantities
		assertQueryFalse(null, "Sequence{4, 5, 'test'} = Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "Sequence{4, 5, 'test', 4} = Bag{4, 'test', 5, 4}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 4} = Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 4} = Bag{4, 'test', 5}");

		// distinct quantities
		assertQueryFalse(null, "Sequence{4, 5, 'test', 4} = Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "Sequence{4, 5, 'test'} = Bag{4, 'test', 5, 4}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 4} = Bag{4, 'test', 5, 4}");
	}

	@Test public void testCollectionEqualUnorderedXUnordered() {
		// same quantities
		assertQueryFalse(null, "Bag{4, 5, 'test'} = Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "Bag{4, 5, 'test', 4} = Bag{4, 'test', 5, 4}");
		assertQueryTrue(null, "Set{4, 5, 'test', 4} = Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "Set{4, 5, 'test', 4} = Bag{4, 'test', 5}");

		// distinct quantities
		assertQueryFalse(null, "Bag{4, 5, 'test', 4} = Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "Bag{4, 5, 'test'} = Bag{4, 'test', 5, 4}");
		assertQueryFalse(null, "Set{4, 5, 'test', 4} = Bag{4, 'test', 5, 4}");
	}

	@Test public void testCollectionEqualInvalid() {
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s = Sequence{5}");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Bag{5} = b");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s = Set{5}");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in OrderedSet{5} = o");

		assertQueryInvalid(null, "let s1 : Sequence(Integer) = invalid, s2 : Sequence(Integer) = invalid in s1 = s2");
		assertQueryInvalid(null, "let b1 : Bag(Integer) = invalid, b2 : Bag(Integer) = invalid in b1 = b2");
		assertQueryInvalid(null, "let s1 : Set(Integer) = invalid, s2 : Set(Integer) = invalid in s1 = s2");
		assertQueryInvalid(null, "let o1 : OrderedSet(Integer) = invalid, o2 : OrderedSet(Integer) = invalid in o1 = o2");
	}

	@Test public void testCollectionEqualNull() {				
		assertQueryFalse(null, "Bag{} = null");
		assertQueryFalse(null, "OrderedSet{} = null");
		assertQueryFalse(null, "Sequence{} = null");
		assertQueryFalse(null, "Set{} = null");

		assertQueryFalse(null, "null = Bag{}");
		assertQueryFalse(null, "null = OrderedSet{}");
		assertQueryFalse(null, "null = Sequence{}");
		assertQueryFalse(null, "null = Set{}");

		assertQueryFalse(null, "let b : Bag(Integer) = null in b = Bag{}");
		assertQueryFalse(null, "let b : Bag(Integer) = null, s : Set(Integer) = Set{} in b = s");	
		assertQueryFalse(null, "let s : Sequence(Integer) = null in s = Sequence{5}");
		assertQueryFalse(null, "let b : Bag(Integer) = null in Bag{5} = b");
		assertQueryFalse(null, "let s : Set(Integer) = null in s = Set{5}");
		assertQueryFalse(null, "let o : OrderedSet(Integer) = null in OrderedSet{5} = o");

		assertQueryTrue(null, "let s1 : Sequence(Integer) = null, s2 : Sequence(Integer) = null in s1 = s2");
		assertQueryTrue(null, "let b1 : Bag(Integer) = null, b2 : Bag(Integer) = null in b1 = b2");
		assertQueryTrue(null, "let s1 : Set(Integer) = null, s2 : Set(Integer) = null in s1 = s2");
		assertQueryTrue(null, "let o1 : OrderedSet(Integer) = null, o2 : OrderedSet(Integer) = null in o1 = o2");
	}

	@Test public void testCollectionExcludes() {
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludes(3)");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludes(3.0)");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludes(4)");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludes('test')");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludes(3)");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludes(3.0)");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludes(4)");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludes('test')");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludes(3)");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludes(3.0)");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludes(4)");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludes('test')");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludes(3)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludes(3.0)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludes(4)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludes('test')");

		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludes(3.5)");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludes(3.5)");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludes(3.5)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludes(3.5)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->excludes(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->excludes(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->excludes(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in os->excludes(0)");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{3, 4.0, 'test'}->excludes(invalid)");
		assertQueryInvalid(null, "Bag{3, 4.0, 'test'}->excludes(invalid)");
		assertQueryInvalid(null, "Set{3, 4.0, 'test'}->excludes(invalid)");
		assertQueryInvalid(null, "OrderedSet{3, 4.0, 'test'}->excludes(invalid)");

		assertQueryInvalid(null, "Sequence{0, invalid}->excludes(0)");
		assertQueryInvalid(null, "Bag{0, invalid}->excludes(0)");
		assertQueryInvalid(null, "Set{0, invalid}->excludes(0)");
		assertQueryInvalid(null, "OrderedSet{0, invalid}->excludes(0)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->excludes(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->excludes(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->excludes(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in os->excludes(0)");
		// null collection element
		assertQueryFalse(null, "Sequence{3, 4.0, null, 'test'}->excludes(null)");
		assertQueryFalse(null, "Sequence{null}->excludes(null)");
		assertQueryFalse(null, "Bag{3, 4.0, null, 'test'}->excludes(null)");
		assertQueryFalse(null, "Bag{null}->excludes(null)");
		assertQueryFalse(null, "Set{3, 4.0, null, 'test'}->excludes(null)");
		assertQueryFalse(null, "Set{null}->excludes(null)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, null, 'test'}->excludes(null)");
		assertQueryFalse(null, "OrderedSet{null}->excludes(null)");

		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludes(null)");
		assertQueryTrue(null, "Sequence{}->excludes(null)");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludes(null)");
		assertQueryTrue(null, "Bag{}->excludes(null)");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludes(null)");
		assertQueryTrue(null, "Set{}->excludes(null)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludes(null)");
		assertQueryTrue(null, "OrderedSet{}->excludes(null)");
	}

	@Test public void testCollectionExcludesAll() {
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Sequence{3, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Bag{3, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Set{3, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(OrderedSet{3, 'test'})");

		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludesAll(Sequence{3.5, 'TEST'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludesAll(Bag{3.5, 'TEST'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludesAll(Set{3.5, 'TEST'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->excludesAll(OrderedSet{3.5, 'TEST'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludesAll(Sequence{3.5, 'TEST'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludesAll(Bag{3.5, 'TEST'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludesAll(Set{3.5, 'TEST'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->excludesAll(OrderedSet{3.5, 'TEST'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludesAll(Sequence{3.5, 'TEST'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludesAll(Bag{3.5, 'TEST'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludesAll(Set{3.5, 'TEST'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->excludesAll(OrderedSet{3.5, 'TEST'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Sequence{3.5, 'TEST'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Bag{3.5, 'TEST'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(Set{3.5, 'TEST'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->excludesAll(OrderedSet{3.5, 'TEST'})");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->excludesAll(Sequence{0})");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->excludesAll(Bag{0})");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->excludesAll(Set{0})");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in os->excludesAll(OrderedSet{0})");

		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in Sequence{0}->excludesAll(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Bag{0}->excludesAll(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in Set{0}->excludesAll(s)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in OrderedSet{0}->excludesAll(os)");
		// invalid collection element
		// Collections can't contain the invalid value
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->excludesAll(OrderedSet{'test'})");
		assertQueryInvalid(null, "Sequence{3, 4, invalid, 'test'}->excludesAll(OrderedSet{'test'})");
		assertQueryInvalid(null, "Bag{3, 4, invalid, 'test'}->excludesAll(Set{'test'})");
		assertQueryInvalid(null, "Set{3, 4, invalid, 'test'}->excludesAll(Bag{'test'})");
		assertQueryInvalid(null, "OrderedSet{3, 4, invalid, 'test'}->excludesAll(Sequence{'test'})");

		assertQueryInvalid(null, "Sequence{3, 4, 'test'}->excludesAll(OrderedSet{'test', invalid})");
		assertQueryInvalid(null, "Bag{3, 4, 'test'}->excludesAll(Set{'test', invalid})");
		assertQueryInvalid(null, "Set{3, 4, 'test'}->excludesAll(Bag{'test', invalid})");
		assertQueryInvalid(null, "OrderedSet{3, 4, 'test'}->excludesAll(Sequence{'test', invalid})");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->excludesAll(Sequence{0})");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->excludesAll(Bag{0})");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->excludesAll(Set{0})");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in os->excludesAll(OrderedSet{0})");

		assertQueryInvalid(null, "let s : Sequence(Integer) = null in Sequence{0}->excludesAll(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in Bag{0}->excludesAll(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in Set{0}->excludesAll(s)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in OrderedSet{0}->excludesAll(os)");
		// null collection element
		assertQueryFalse(null, "Sequence{3, 4, null, 'test'}->excludesAll(OrderedSet{'TEST', null})");
		assertQueryFalse(null, "Bag{3, 4, null, 'test'}->excludesAll(Set{'TEST', null})");
		assertQueryFalse(null, "Set{3, 4, null, 'test'}->excludesAll(Bag{'TEST', null})");
		assertQueryFalse(null, "OrderedSet{3, 4, null, 'test'}->excludesAll(Sequence{'TEST', null})");

		assertQueryTrue(null, "Sequence{3, 4, 'test'}->excludesAll(OrderedSet{'TEST', null})");
		assertQueryTrue(null, "Bag{3, 4, 'test'}->excludesAll(Set{'TEST', null})");
		assertQueryTrue(null, "Set{3, 4, 'test'}->excludesAll(Bag{'TEST', null})");
		assertQueryTrue(null, "OrderedSet{3, 4, 'test'}->excludesAll(Sequence{'TEST', null})");
	}

	@Test public void testCollectionExcluding() {
		/*
		 * FIXME OMG-issue to add OrderedSet::excluding
		 * since it's defined in oclstdlib.ecore. However the defined
		 * "OrderedSet::excluding(T) : Set" should be
		 * "OrderedSet::excluding(T) : OrderedSet"
		 */
		assertQueryResults(null, "Sequence{'a', 'c'}", "Sequence{'b', 'a', 'b', 'c'}->excluding('b')");
		assertQueryResults(null, "Bag{'c', 'a'}", "Bag{'b', 'a', 'b', 'c'}->excluding('b')");
		assertQueryResults(null, "Set{'c', 'a'}", "Set{'a', 'b', 'c'}->excluding('b')");
		assertQueryResults(null, "OrderedSet{'a', 'c'}", "OrderedSet{'a', 'b', 'c'}->excluding('b')");
		assertQueryResults(null, "Sequence{1,3,4}", "Sequence{1..4}->excluding(2)");
		assertQueryResults(null, "OrderedSet{1,3,4}", "OrderedSet{1..4}->excluding(2)");
		assertQueryResults(null, "Sequence{1..3,6..9}", "Sequence{1..4,6,7..9}->excluding(4)");
		assertQueryResults(null, "OrderedSet{1..3,6..9}", "OrderedSet{1..4,6,7..9}->excluding(4)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->excluding('a')");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->excluding('a')");
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->excluding('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->excluding('a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->excluding(invalid)");
		assertQueryInvalid(null, "Bag{'a', 'b'}->excluding(invalid)");
		assertQueryInvalid(null, "Set{'a', 'b'}->excluding(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->excluding(invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->excluding('a')");
		assertQueryInvalid(null, "let b : Bag(String) = null in b->excluding('a')");
		assertQueryInvalid(null, "let s : Set(String) = null in s->excluding('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->excluding('a')");
		// invalid collection element
		assertQueryResults(null, "Sequence{'a', 'b'}", "Sequence{null, 'a', null, 'b'}->excluding(null)");
		assertQueryResults(null, "Bag{'b', 'a'}", "Bag{null, 'a', null, 'b'}->excluding(null)");
		assertQueryResults(null, "Set{'b', 'a'}", "Set{'a', null, 'b'}->excluding(null)");
		assertQueryResults(null, "OrderedSet{'a', 'b'}", "OrderedSet{'a', null, 'b'}->excluding(null)");
	}

	@Test public void testCollectionExcludingAll() {
		assertQueryResults(null, "Sequence{'a', 'c'}", "Sequence{'b', 'a', 'd', 'd', 'b', 'c', 'd'}->excludingAll(Sequence{'d', 'd', 'b', 'e'})");
		assertQueryResults(null, "Bag{'c', 'a'}", "Bag{'b', 'a', 'd', 'd', 'b', 'c', 'd'}->excludingAll(Bag{'b', 'd', 'd', 'e'})");
		assertQueryResults(null, "Set{'c', 'a'}", "Set{'a', 'b', 'c', 'd'}->excludingAll(Set{'b', 'd', 'e'})");
		assertQueryResults(null, "OrderedSet{'a', 'c'}", "OrderedSet{'a', 'b', 'c', 'd'}->excludingAll(OrderedSet{'b', 'd', 'e'})");
		assertQueryResults(null, "Sequence{1,3,7..8,10}", "Sequence{1..10}->excludingAll(Sequence{2,4..6,9})");
		assertQueryResults(null, "OrderedSet{1,3,7..8,10}", "OrderedSet{1..10}->excludingAll(OrderedSet{2,4..6,9})");
		assertQueryResults(null, "Sequence{1..2,4,8..9}", "Sequence{1..4,6,7..9}->excludingAll(Sequence{3,5..7})");
		assertQueryResults(null, "OrderedSet{1..2,4,8..9}", "OrderedSet{1..4,6,7..9}->excludingAll(OrderedSet{3,5..7})");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->excludingAll(Sequence{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->excludingAll(Bag{'a'})");
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->excludingAll(Set{'a'})");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->excludingAll(OrderedSet{'a'})");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->excludingAll(invalid)");
		assertQueryInvalid(null, "Bag{'a', 'b'}->excludingAll(invalid)");
		assertQueryInvalid(null, "Set{'a', 'b'}->excludingAll(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->excludingAll(invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->excludingAll(Sequence{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = null in b->excludingAll(Bag{'a'})");
		assertQueryInvalid(null, "let s : Set(String) = null in s->excludingAll(Set{'a'})");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->excludingAll(OrderedSet{'a'})");
		// invalid collection element
		assertQueryResults(null, "Sequence{'a', 'b'}", "Sequence{null, 'a', null, 'b', 'c'}->excludingAll(Sequence{null, 'c'})");
		assertQueryResults(null, "Bag{'b', 'a'}", "Bag{null, 'a', null, 'b'}->excludingAll(Bag{null})");
		assertQueryResults(null, "Set{'b', 'a'}", "Set{'a', null, 'b'}->excludingAll(Set{null})");
		assertQueryResults(null, "OrderedSet{'a', 'b'}", "OrderedSet{'a', null, 'b'}->excludingAll(OrderedSet{null})");
	}

	@Test public void testCollectionFirst() {
		assertQueryEquals(null, 1, "Sequence{1, 2.0, '3'}->first()");
		assertQueryEquals(null, 1, "OrderedSet{1, 2.0, '3'}->first()");
		// empty
		assertQueryInvalid(null, "OrderedSet{}->first()");
		assertQueryInvalid(null, "Sequence{}->first()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->first()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->first()");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{1, invalid}->first()");
		assertQueryInvalid(null, "OrderedSet{1, invalid}->first()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->first()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->first()");
		// null collection element
		assertQueryNull(null, "Sequence{null}->first()");
		assertQueryNull(null, "OrderedSet{null}->first()");
	}

	@Test public void testCollectionFlatten() {
		assertQueryEquals(null, getEmptySequenceValue(), "Sequence{}->flatten()");
		assertQueryEquals(null, getEmptyBagValue(), "Bag{}->flatten()");
		assertQueryEquals(null, getEmptySetValue(), "Set{}->flatten()");
		assertQueryEquals(null, getEmptyOrderedSetValue(), "OrderedSet{}->flatten()");

		String expression = "Sequence{Set{1,2,3}, Sequence{2.0, 3.0}, Bag{'test'}}->flatten()";
		String expectedResultExpression = "Sequence{1, 2, 3, 2.0, 3.0, 'test'}";
		/*
		 * as the Sequence is ordered and we cannot know in which order the
		 * result of the Set flattening were inserted, simply check that the
		 * result is a Sequence and contains all elements.
		 */
		assertResultContainsAll(null, expectedResultExpression, expression);

		expression = "Bag{Set{Bag{'test', 2, 3.0}}, Sequence{OrderedSet{2.0, 3, 1}}}->flatten()";
		expectedResultExpression = "Bag{1, 2, 3, 2.0, 3.0, 'test'}";
		assertQueryResults(null, expectedResultExpression, expression);

		expression = "Set{OrderedSet{Set{3.0, 'test'}, Sequence{2.0, 2}, Bag{1, 3}}}->flatten()";
		expectedResultExpression = "Set{1, 2.0, 3.0, 'test'}";
		assertResultContainsAll(null, expectedResultExpression, expression);

		expression = "OrderedSet{Set{Set{3.0, 'test'}, Sequence{2.0, 2}, Bag{1, 3}}}->flatten()";
		expectedResultExpression = "OrderedSet{1, 2, 2.0, 3.0, 'test'}";
		assertResultContainsAll(null, expectedResultExpression, expression);

		expression = "Set{Sequence{Sequence{3.0, 'test'}}, Sequence{Sequence{2.0, 2}, Sequence{1, 3}}}->flatten()";
		expectedResultExpression = "Set{1, 2, 3, 2.0, 3.0, 'test'}";
		assertResultContainsAll(null, expectedResultExpression, expression);
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->flatten()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->flatten()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->flatten()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->flatten()");
		// non collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->flatten()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->flatten()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->flatten()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->flatten()");
		// pseudo collection
		assertQueryResults(null, "Set{1}", "1->flatten()");
		assertQueryResults(null, "Set{1}", "let s : Sequence(Integer) = null in 1->flatten()");
		assertQueryResults(null, "Set{1}", "let b : Bag(Integer) = null in 1->flatten()");
		assertQueryResults(null, "Set{1}", "let s : Set(Integer) = null in 1->flatten()");
		assertQueryResults(null, "Set{1}", "let o : OrderedSet(Integer) = null in 1->flatten()");
	}

	@Test public void testCollectionIncludes() {
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includes(3)");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includes(3.0)");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includes(4)");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includes('test')");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includes(3)");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includes(3.0)");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includes(4)");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includes('test')");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includes(3)");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includes(3.0)");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includes(4)");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includes('test')");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includes(3)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includes(3.0)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includes(4)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includes('test')");
		
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includes(3.5)");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includes(3.5)");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includes(3.5)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includes(3.5)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->includes(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->includes(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->includes(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in os->includes(0)");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{3, 4.0, 'test'}->includes(invalid)");
		assertQueryInvalid(null, "Bag{3, 4.0, 'test'}->includes(invalid)");
		assertQueryInvalid(null, "Set{3, 4.0, 'test'}->includes(invalid)");
		assertQueryInvalid(null, "OrderedSet{3, 4.0, 'test'}->includes(invalid)");

		assertQueryInvalid(null, "Sequence{0, invalid}->includes(0)");
		assertQueryInvalid(null, "Bag{0, invalid}->includes(0)");
		assertQueryInvalid(null, "Set{0, invalid}->includes(0)");
		assertQueryInvalid(null, "OrderedSet{0, invalid}->includes(0)");
		// invalid null
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->includes(0)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->includes(0)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->includes(0)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in os->includes(0)");
		// invalid null element
		assertQueryTrue(null, "Sequence{3, 4.0, null, 'test'}->includes(null)");
		assertQueryTrue(null, "Sequence{null}->includes(null)");
		assertQueryTrue(null, "Bag{3, 4.0, null, 'test'}->includes(null)");
		assertQueryTrue(null, "Bag{null}->includes(null)");
		assertQueryTrue(null, "Set{3, 4.0, null, 'test'}->includes(null)");
		assertQueryTrue(null, "Set{null}->includes(null)");
		assertQueryTrue(null, "OrderedSet{3, 4.0, null, 'test'}->includes(null)");
		assertQueryTrue(null, "OrderedSet{null}->includes(null)");

		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includes(null)");
		assertQueryFalse(null, "Sequence{}->includes(null)");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includes(null)");
		assertQueryFalse(null, "Bag{}->includes(null)");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includes(null)");
		assertQueryFalse(null, "Set{}->includes(null)");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includes(null)");
		assertQueryFalse(null, "OrderedSet{}->includes(null)");
	}

	@Test public void testCollectionIncludesAll() {
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertQueryTrue(null, "Sequence{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertQueryTrue(null, "Bag{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertQueryTrue(null, "Set{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Sequence{3, 'test'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Bag{3, 'test'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Set{3, 'test'})");
		assertQueryTrue(null, "OrderedSet{3, 4.0, 'test'}->includesAll(OrderedSet{3, 'test'})");

		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includesAll(Sequence{3.5, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includesAll(Bag{3.5, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includesAll(Set{3.5, 'test'})");
		assertQueryFalse(null, "Sequence{3, 4.0, 'test'}->includesAll(OrderedSet{3.5, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includesAll(Sequence{3.5, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includesAll(Bag{3.5, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includesAll(Set{3.5, 'test'})");
		assertQueryFalse(null, "Bag{3, 4.0, 'test'}->includesAll(OrderedSet{3.5, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includesAll(Sequence{3.5, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includesAll(Bag{3.5, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includesAll(Set{3.5, 'test'})");
		assertQueryFalse(null, "Set{3, 4.0, 'test'}->includesAll(OrderedSet{3.5, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Sequence{3.5, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Bag{3.5, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includesAll(Set{3.5, 'test'})");
		assertQueryFalse(null, "OrderedSet{3, 4.0, 'test'}->includesAll(OrderedSet{3.5, 'test'})");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->includesAll(Sequence{0})");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->includesAll(Bag{0})");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->includesAll(Set{0})");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in os->includesAll(OrderedSet{0})");

		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in Sequence{0}->includesAll(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Bag{0}->includesAll(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in Set{0}->includesAll(s)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = invalid in OrderedSet{0}->includesAll(os)");
		// invalid collection element
		// Collections can't contain the invalid value
		assertQueryInvalid(null, "Sequence{3, 4, invalid, 'test'}->includesAll(OrderedSet{'test'})");
		assertQueryInvalid(null, "Bag{3, 4, invalid, 'test'}->includesAll(Set{'test'})");
		assertQueryInvalid(null, "Set{3, 4, invalid, 'test'}->includesAll(Bag{'test'})");
		assertQueryInvalid(null, "OrderedSet{3, 4, invalid, 'test'}->includesAll(Sequence{'test'})");

		assertQueryInvalid(null, "Sequence{3, 4, 'test'}->includesAll(OrderedSet{'test', invalid})");
		assertQueryInvalid(null, "Bag{3, 4, 'test'}->includesAll(Set{'test', invalid})");
		assertQueryInvalid(null, "Set{3, 4, 'test'}->includesAll(Bag{'test', invalid})");
		assertQueryInvalid(null, "OrderedSet{3, 4, 'test'}->includesAll(Sequence{'test', invalid})");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->includesAll(Sequence{0})");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->includesAll(Bag{0})");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->includesAll(Set{0})");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in os->includesAll(OrderedSet{0})");

		assertQueryInvalid(null, "let s : Sequence(Integer) = null in Sequence{0}->includesAll(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in Bag{0}->includesAll(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in Set{0}->includesAll(s)");
		assertQueryInvalid(null, "let os : OrderedSet(Integer) = null in OrderedSet{0}->includesAll(os)");
		// null collection element
		assertQueryTrue(null, "Sequence{3, 4, null, 'test'}->includesAll(OrderedSet{'test', null})");
		assertQueryTrue(null, "Bag{3, 4, null, 'test'}->includesAll(Set{'test', null})");
		assertQueryTrue(null, "Set{3, 4, null, 'test'}->includesAll(Bag{'test', null})");
		assertQueryTrue(null, "OrderedSet{3, 4, null, 'test'}->includesAll(Sequence{'test', null})");

		assertQueryFalse(null, "Sequence{3, 4, 'test'}->includesAll(OrderedSet{'test', null})");
		assertQueryFalse(null, "Bag{3, 4, 'test'}->includesAll(Set{'test', null})");
		assertQueryFalse(null, "Set{3, 4, 'test'}->includesAll(Bag{'test', null})");
		assertQueryFalse(null, "OrderedSet{3, 4, 'test'}->includesAll(Sequence{'test', null})");
	}

	@Test public void testCollectionIncluding() {
		/*
		 * FIXME OMG-issue to add OrderedSet::including
		 * since it's defined in oclstdlib.ecore. However the defined
		 * "OrderedSet::including(T) : Set" should be
		 * "OrderedSet::including(T) : OrderedSet"
		 */
		assertQueryResults(null, "Sequence{'a', 'b', 'c'}", "Sequence{'a', 'b'}->including('c')");
		assertQueryResults(null, "Bag{'c', 'b', 'a'}", "Bag{'a', 'b'}->including('c')");
		assertQueryResults(null, "Set{'a', 'c', 'b'}", "Set{'a', 'b'}->including('c')");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b'}->including('c')");
		assertQueryResults(null, "OrderedSet{1..2,3..4}", "OrderedSet{1..4}->including(4)");
		assertQueryResults(null, "Sequence{1..2,3..4,4}", "Sequence{1..4}->including(4)");
		assertQueryResults(null, "Sequence{1..5}", "Sequence{1..4}->including(5)");
		assertQueryResults(null, "Sequence{1..3,4,6}", "Sequence{1..4}->including(6)");
		assertQueryResults(null, "Sequence{1..4,0}", "Sequence{1..4}->including(0)");
		assertQueryResults(null, "Set{1..9}", "Set{1..4,6,7..9}->including(5)");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->including('a')");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->including('a')");
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->including('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->including('a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->including(invalid)");
		assertQueryInvalid(null, "Bag{'a', 'b'}->including(invalid)");
		assertQueryInvalid(null, "Set{'a', 'b'}->including(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->including(invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->including('a')");
		assertQueryInvalid(null, "let b : Bag(String) = null in b->including('a')");
		assertQueryInvalid(null, "let s : Set(String) = null in s->including('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->including('a')");
		// null collection element
		assertQueryResults(null, "Sequence{'a', 'b', null}", "Sequence{'a', 'b'}->including(null)");
		assertQueryResults(null, "Bag{null, 'b', 'a'}", "Bag{'a', 'b'}->including(null)");
		assertQueryResults(null, "Set{'a', null, 'b'}", "Set{'a', 'b'}->including(null)");
		assertQueryResults(null, "OrderedSet{'a', 'b', null}", "OrderedSet{'a', 'b'}->including(null)");
		assertQueryResults(null, "Sequence{'a', null, 'b', null}", "Sequence{'a', null, 'b'}->including(null)");
		assertQueryResults(null, "Bag{null, 'b', null, 'a'}", "Bag{'a', null, 'b'}->including(null)");
		assertQueryResults(null, "Set{'a', null, 'b'}", "Set{'a', null, 'b'}->including(null)");
		assertQueryResults(null, "OrderedSet{'a', null, 'b'}", "OrderedSet{'a', null, 'b'}->including(null)");
		assertQueryResults(null, "Sequence{'1..4', null}", "Sequence{'1..4'}->including(null)");
		assertQueryResults(null, "OrderedSet{'1..4', null}", "OrderedSet{'1..4'}->including(null)");
	}

	@Test public void testCollectionIncludingAll() {
		assertQueryResults(null, "Sequence{'a', 'b', 'c', 'd'}", "Sequence{'a', 'b'}->includingAll(Sequence{'c', 'd'})");
		assertQueryResults(null, "Bag{'c', 'b', 'a', 'd'}", "Bag{'a', 'b'}->includingAll(Bag{'c', 'd'})");
		assertQueryResults(null, "Set{'a', 'c', 'b', 'd'}", "Set{'a', 'b'}->includingAll(Set{'c', 'd'})");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c', 'd'}", "OrderedSet{'a', 'b'}->includingAll(OrderedSet{'c', 'd'})");
		assertQueryResults(null, "OrderedSet{1..2,3..4}", "OrderedSet{1..4}->includingAll(OrderedSet{2..4})");
		assertQueryResults(null, "Sequence{1..2,3..4,4..6}", "Sequence{1..4}->includingAll(Sequence{4..6})");
		assertQueryResults(null, "Sequence{1..7}", "Sequence{1..4}->includingAll(Sequence{5..7})");
		assertQueryResults(null, "Sequence{1..3,4,6..8}", "Sequence{1..4}->includingAll(Sequence{6..8})");
		assertQueryResults(null, "Sequence{2..4,0..1}", "Sequence{2..4}->includingAll(Sequence{0..1})");
		assertQueryResults(null, "Set{1..9}", "Set{1..4,7,8..9}->includingAll(Set{5..7})");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->includingAll(Sequence{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->includingAll(Bag{'a'})");
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->includingAll(Set{'a'})");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->includingAll(OrderedSet{'a'})");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->includingAll(invalid)");
		assertQueryInvalid(null, "Bag{'a', 'b'}->includingAll(invalid)");
		assertQueryInvalid(null, "Set{'a', 'b'}->includingAll(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->includingAll(invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->includingAll(Sequence{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = null in b->includingAll(Bag{'a'})");
		assertQueryInvalid(null, "let s : Set(String) = null in s->includingAll(Set{'a'})");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->includingAll(OrderedSet{'a'})");
		// null collection element
		assertQueryResults(null, "Sequence{'a', 'b', null, null}", "Sequence{'a', 'b'}->includingAll(Sequence{null, null})");
		assertQueryResults(null, "Bag{null, null, 'b', 'a'}", "Bag{'a', 'b'}->includingAll(Bag{null, null})");
		assertQueryResults(null, "Set{'a', null, 'b'}", "Set{'a', 'b'}->includingAll(Set{null})");
		assertQueryResults(null, "OrderedSet{'a', 'b', null}", "OrderedSet{'a', 'b'}->includingAll(OrderedSet{null})");
		assertQueryResults(null, "Sequence{'a', null, 'b', null}", "Sequence{'a', null, 'b'}->includingAll(Sequence{null})");
		assertQueryResults(null, "Bag{null, 'b', null, 'a'}", "Bag{'a', null, 'b'}->includingAll(Bag{null})");
		assertQueryResults(null, "Set{'a', null, 'b'}", "Set{'a', null, 'b'}->includingAll(Set{null})");
		assertQueryResults(null, "OrderedSet{'a', null, 'b'}", "OrderedSet{'a', null, 'b'}->includingAll(OrderedSet{null})");
		assertQueryResults(null, "Sequence{'1..4', null}", "Sequence{'1..4'}->includingAll(Sequence{null})");
		assertQueryResults(null, "OrderedSet{'1..4', null}", "OrderedSet{'1..4'}->includingAll(OrderedSet{null})");
	}

	@Test public void testCollectionIndexOf() {
		assertQueryEquals(null, 1, "Sequence{'a', 'b'}->indexOf('a')");
		assertQueryEquals(null, 2, "OrderedSet{'a', 'b'}->indexOf('b')");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->indexOf('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->indexOf('a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', invalid}->indexOf(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', invalid}->indexOf(invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->indexOf('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->indexOf('a')");
		// null collection element
		assertQueryEquals(null, 1, "Sequence{null, 'a'}->indexOf(null)");
		assertQueryEquals(null, 1, "OrderedSet{null, 'a'}->indexOf(null)");
		// non-element
		assertQueryInvalid(null, "Sequence{'a'}->indexOf('b')");
		assertQueryInvalid(null, "OrderedSet{'a'}->indexOf('b')");
	}

	@Test public void testCollectionInsertAt() {
		// For now resolve Issue 14980 semantics by by first removing an existing content
		assertQueryResults(null, "Sequence{'c', 'a', 'b'}", "Sequence{'a', 'b'}->insertAt(1, 'c')");
		assertQueryResults(null, "OrderedSet{'a', 'c', 'b'}", "OrderedSet{'a', 'b'}->insertAt(2, 'c')");

		// We can add _after_ the last element
		assertQueryResults(null, "Sequence{'a', 'b', 'c'}", "Sequence{'a', 'b'}->insertAt(3, 'c')");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b'}->insertAt(3, 'c')");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->insertAt(1, 'a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->insertAt(1, 'a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a'}->insertAt(1, invalid)");
		assertQueryInvalid(null, "OrderedSet{'a'}->insertAt(1, invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->insertAt(1, 'a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->insertAt(1, 'a')");
		// null collection element
		assertQueryResults(null, "Sequence{null, 'a'}", "Sequence{'a'}->insertAt(1, null)");
		assertQueryResults(null, "Sequence{null, null}", "Sequence{null}->insertAt(1, null)");
//		assertQueryResults(null, "Sequence{'a', null}", "Sequence{null}->insertAt(1, 'a')");
		assertQueryResults(null, "OrderedSet{'a', null}", "OrderedSet{'a'}->insertAt(2, null)");
		assertQueryResults(null, "OrderedSet{null}", "OrderedSet{null}->insertAt(1, null)");
//		assertQueryResults(null, "OrderedSet{null, 'a'}", "OrderedSet{null}->insertAt(2, 'a')");
		// out of bounds
		assertQueryInvalid(null, "Sequence{'a'}->insertAt(0, 'b')");
		assertQueryInvalid(null, "OrderedSet{'a'}->insertAt(0, 'b')");
		assertQueryInvalid(null, "Sequence{'a'}->insertAt(3, 'b')");
		assertQueryInvalid(null, "OrderedSet{'a'}->insertAt(3, 'b')");
		assertQueryInvalid(null, "OrderedSet{'a'}->insertAt(2, 'a')");
		// duplicates
		assertQueryResults(null, "Sequence{'b', 'a', 'b', 'c'}", "Sequence{'a', 'b', 'c'}->insertAt(1, 'b')");
		assertQueryResults(null, "Sequence{'a', 'b', 'c', 'b'}", "Sequence{'a', 'b', 'c'}->insertAt(4, 'b')");
		assertQueryResults(null, "OrderedSet{'b', 'a', 'c'}", "OrderedSet{'a', 'b', 'c'}->insertAt(1, 'b')");
		assertQueryResults(null, "OrderedSet{'a', 'b', 'c'}", "OrderedSet{'a', 'b', 'c'}->insertAt(2, 'b')");
		assertQueryResults(null, "OrderedSet{'a', 'c', 'b'}", "OrderedSet{'a', 'b', 'c'}->insertAt(3, 'b')");
		assertQueryInvalid(null, "OrderedSet{'a', 'b', 'c'}->insertAt(4, 'b')");
	}

	@Test public void testCollectionIntersection() {
		// No duplicates
		assertQueryEquals(null, getEmptySetValue(), "Set{'a', 'b'}->intersection(Set{'c', 'd'})");
		assertQueryEquals(null, getEmptySetValue(), "Set{'a', 'b'}->intersection(Sequence{'c', 'd'})");
		assertQueryEquals(null, getEmptySetValue(), "Set{'a', 'b'}->intersection(OrderedSet{'c', 'd'})");
		assertQueryEquals(null, getEmptySetValue(), "Set{'a', 'b'}->intersection(Bag{'c', 'd'})");
		assertQueryEquals(null, getEmptySetValue(), "Sequence{'a', 'b'}->intersection(Set{'c', 'd'})");
		assertQueryEquals(null, getEmptyBagValue(), "Sequence{'a', 'b'}->intersection(Sequence{'c', 'd'})");
		assertQueryEquals(null, getEmptySetValue(), "Sequence{'a', 'b'}->intersection(OrderedSet{'c', 'd'})");
		assertQueryEquals(null, getEmptyBagValue(), "Sequence{'a', 'b'}->intersection(Bag{'c', 'd'})");
		assertQueryEquals(null, getEmptySetValue(), "OrderedSet{'a', 'b'}->intersection(Set{'c', 'd'})");
		assertQueryEquals(null, getEmptySetValue(), "OrderedSet{'a', 'b'}->intersection(Sequence{'c', 'd'})");
		assertQueryEquals(null, getEmptySetValue(), "OrderedSet{'a', 'b'}->intersection(OrderedSet{'c', 'd'})");
		assertQueryEquals(null, getEmptySetValue(), "OrderedSet{'a', 'b'}->intersection(Bag{'c', 'd'})");
		assertQueryEquals(null, getEmptySetValue(), "Bag{'a', 'b'}->intersection(Set{'c', 'd'})");
		assertQueryEquals(null, getEmptyBagValue(), "Bag{'a', 'b'}->intersection(Sequence{'c', 'd'})");
		assertQueryEquals(null, getEmptySetValue(), "Bag{'a', 'b'}->intersection(OrderedSet{'c', 'd'})");
		assertQueryEquals(null, getEmptyBagValue(), "Bag{'a', 'b'}->intersection(Bag{'c', 'd'})");
		// Duplicates
		assertQueryResults(null, "Set{'a', 'b'}", "Set{'a', 'b', 'a'}->intersection(Set{'a', 'b', 'c'})");
		assertQueryResults(null, "Set{'a', 'b'}", "Set{'a', 'b', 'a'}->intersection(Bag{'a', 'b', 'c'})");
		assertQueryResults(null, "Set{'a', 'b'}", "Bag{'a', 'b', 'a'}->intersection(Set{'a', 'b', 'c'})");

		assertQueryResults(null, "Bag{'a', 'b'}", "Bag{'a', 'b', 'a'}->intersection(Bag{'a', 'b'})");
		assertQueryResults(null, "Bag{'a', 'b'}", "Bag{'a', 'b'}->intersection(Bag{'a', 'b', 'a'})");
		assertQueryResults(null, "Bag{'a', 'b', 'b'}", "Bag{'a', 'b', 'a', 'b'}->intersection(Bag{'a', 'b', 'b'})");
		assertQueryResults(null, "Bag{'a', 'b'}", "Bag{'a', 'b', 'a'}->intersection(Bag{'a', 'b', 'c'})");

		assertQueryResults(null, "Bag{'a'}", "Bag{'a', 'a', 'a', 'a'}->intersection(Bag{'a', 'b', 'b'})");
		
		// empty collection
		assertQueryEquals(null, getEmptySetValue(), "Set{3, 4}->intersection(Set{})");
		assertQueryEquals(null, getEmptySetValue(), "Set{3, 4}->intersection(Bag{})");
		assertQueryEquals(null, getEmptyBagValue(), "Bag{3, 4}->intersection(Bag{})");
		assertQueryEquals(null, getEmptySetValue(), "Bag{3, 4}->intersection(Set{})");
		// implicit collection
		assertQueryEquals(null, getEmptySetValue(), "1->intersection(Set{})");
		assertQueryEquals(null, getEmptySetValue(), "2->intersection(Bag{})");

//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"Set{}->intersection(Set{3, 4})",
//        	OCLMessages.OperationNotFound_ERROR_, "intersection(Set(Integer))", "Set(OclVoid)");	
		
		assertQueryEquals(null, getEmptySetValue(), "Set{}->intersection(Set{3, 4})");
		assertQueryEquals(null, getEmptySetValue(), "Set{}->intersection(Bag{3, 4})");
		assertQueryEquals(null, getEmptyBagValue(), "Bag{}->intersection(Bag{3, 4})");
		assertQueryEquals(null, getEmptySetValue(), "Bag{}->intersection(Set{3, 4})");
		// invalid collection
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->intersection(Set{4})");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->intersection(Bag{4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->intersection(Set{4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->intersection(Bag{4})");

//		assertSemanticErrorQuery("let s : Set(Integer) = invalid in Set{4}->intersection(s)",
//		OCLMessages.UnresolvedOperationCall_ERROR_, "intersection", "Set(UnlimitedNatural)", "Set(Integer)");
//		assertSemanticErrorQuery("let s : Set(Real) = invalid in Set{4}->intersection(s)",
//			OCLMessages.UnresolvedOperationCall_ERROR_, "Set(Integer)", "intersection", "Set(Real)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in Set{4.0}->intersection(s)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in Bag{4.0}->intersection(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Set{4.0}->intersection(b)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Bag{4.0}->intersection(b)");
		// invalid collection element
		assertQueryInvalid(null, "Set{3, 4}->intersection(Set{invalid})");
		assertQueryInvalid(null, "Set{3, invalid}->intersection(Bag{4})");
		assertQueryInvalid(null, "Bag{3, invalid}->intersection(Set{4})");
		assertQueryInvalid(null, "Bag{3, 4}->intersection(Bag{invalid})");
		// null collection
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->intersection(Set{4})");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->intersection(Bag{4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->intersection(Set{4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->intersection(Bag{4})");

		assertQueryInvalid(null, "let s : Set(Integer) = null in Set{4.0}->intersection(s)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in Bag{4.0}->intersection(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in Set{4.0}->intersection(b)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in Bag{4.0}->intersection(b)");
		// null collection element
		assertQueryResults(null, "Set{2, null}", "Set{2, 3, null}->intersection(Set{2, 4, null})");
		assertQueryResults(null, "Set{2, null}", "Set{2, 3, null}->intersection(Bag{2, 4, null})");
		assertQueryResults(null, "Set{2, null}", "Bag{2, 3, null}->intersection(Set{2, 4, null})");
		assertQueryResults(null, "Bag{null, null}", "Bag{3, 4, null, null}->intersection(Bag{null, 2, null})");
	}

	@Test public void testCollectionIntersectionReturnType() {
		assertQueryResults(null, "Set{'c'}", "Set{'a'}->intersection(Set{'b'})->including('c')");
		assertQueryResults(null, "Set{'c'}", "let domainVars: Set(String) = Set{'a'}, whenVars: Set(String) = Set{'b'}, tev: String = 'c' in domainVars->intersection(whenVars)->including(tev)");
		assertQueryTrue(null, "let domainTopVars: Set(String) = Set{'c'}, domainVars: Set(String) = Set{'a'}, whenVars: Set(String) = Set{'b'}, tev: String = 'c' in domainTopVars = domainVars->intersection(whenVars)->including(tev)");
	}

	@Test public void testCollectionIsEmpty() {
		assertQueryTrue(null, "Sequence{}->isEmpty()");
		assertQueryTrue(null, "Bag{}->isEmpty()");
		assertQueryTrue(null, "Set{}->isEmpty()");
		assertQueryTrue(null, "OrderedSet{}->isEmpty()");

		assertQueryFalse(null, "Sequence{4, 4, 'test'}->isEmpty()");
		assertQueryFalse(null, "Bag{4, 4, 'test'}->isEmpty()");
		assertQueryFalse(null, "Set{4, 4, 'test'}->isEmpty()");
		assertQueryFalse(null, "OrderedSet{4, 4, 'test'}->isEmpty()");

		assertQueryResults(null, "Set{'test'}", "'test'.oclAsSet()");
		assertQueryFalse(null, "'test'.oclAsSet()->isEmpty()");
		assertQueryFalse(null, "'test'->isEmpty()");
		assertQueryFalse(null, "''->isEmpty()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->isEmpty()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->isEmpty()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->isEmpty()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->isEmpty()");
		// invalid collection element
		assertQueryInvalid(null, "invalid->isEmpty()");
		assertQueryInvalid(null, "Sequence{invalid}->isEmpty()");
		assertQueryInvalid(null, "Bag{invalid}->isEmpty()");
		assertQueryInvalid(null, "Set{invalid}->isEmpty()");
		assertQueryInvalid(null, "OrderedSet{invalid}->isEmpty()");
		// null collection
//		assertQueryInvalid(null, "null->isEmpty()");
		assertQueryTrue(null, "null->isEmpty()");
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->isEmpty()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->isEmpty()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->isEmpty()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->isEmpty()");
		// null collection element
//		assertQueryInvalid(null, "let s : String = null in s->isEmpty()");
		assertQueryTrue(null, "let s : String = null in s->isEmpty()");
		assertQueryFalse(null, "Sequence{null}->isEmpty()");
		assertQueryFalse(null, "Bag{null}->isEmpty()");
		assertQueryFalse(null, "Set{null}->isEmpty()");
		assertQueryFalse(null, "OrderedSet{null}->isEmpty()");
	}

	@Test public void testCollectionLast() {
		assertQueryEquals(null, "3", "Sequence{1, 2.0, '3'}->last()"); //$NON-NLS-2$
		assertQueryEquals(null, "3", "OrderedSet{1, 2.0, '3'}->last()"); //$NON-NLS-2$
		// empty
		assertQueryInvalid(null, "Sequence{}->last()");
		assertQueryInvalid(null, "OrderedSet{}->last()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->last()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->last()");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{invalid, 1}->last()");
		assertQueryInvalid(null, "OrderedSet{invalid, 1}->last()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->last()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->last()");
		// null collection element
		assertQueryNull(null, "Sequence{null}->last()");
		assertQueryNull(null, "OrderedSet{null}->last()");
	}

	@Test public void testCollectionLower() {
		assertQueryEquals(null, 3, "Sequence{1, 2.0, '3'}->oclType().lower");
		assertQueryEquals(null, 3, "Sequence{1, 2.0, 3}->oclAsType(Collection(Real))->oclType().lower");
		assertQueryEquals(null, 3, "Set{1, 2.0, 3}->oclAsType(Collection(Real)[2..4])->oclType().lower"); // no change to dynamic bound
	}

	@Test public void testCollectionMax() {
		assertQueryEquals(null, 2, "Sequence{1, 2}->max()");
		assertQueryEquals(null, 5.0, "Set{5, 4.0, 3.0, 2, 1}->max()");
		assertQueryEquals(null, 1, "Bag{1}->max()");
		assertQueryEquals(null, 1, "Bag{1}->max()");
		assertQueryInvalid(null, "OrderedSet{'hi', 'lo'}->max()");
		assertQueryInvalid(null, "Set{}->max()");
		assertQueryInvalid(null, "OrderedSet{true, 1, 'bad'}->max()");
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"OrderedSet{'hi', 'lo'}->max()",
//        	OCLMessages.MaxOperator_ERROR_);
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"Set{}->max()",
//        	OCLMessages.MaxOperator_ERROR_);
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"OrderedSet{true, 1, 'bad'}->max()",
//        	OCLMessages.MaxOperator_ERROR_);		
		// FIXME Bug 301351 Subtest-not-implemented user-defined max
	}

	@Test public void testCollectionMin() {
		assertQueryEquals(null, 1, "Sequence{1, 2}->min()");
		assertQueryEquals(null, 1.0, "Set{5, 4.0, 3.0, 2, 1}->min()");
		assertQueryEquals(null, 1, "Bag{1}->min()");
		assertQueryInvalid(null, "OrderedSet{'hi', 'lo'}->min()");
		assertQueryInvalid(null, "Set{}->min()");
		assertQueryInvalid(null, "OrderedSet{true, 1, 'bad'}->min()");
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"OrderedSet{'hi', 'lo'}->min()",
//        	OCLMessages.MinOperator_ERROR_);
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"Set{}->min()",
//        	OCLMessages.MinOperator_ERROR_);
//        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
//        	"OrderedSet{true, 1, 'bad'}->min()",
//        	OCLMessages.MinOperator_ERROR_);		
		// FIXME Bug 301351 Subtest-not-implemented user-defined min
	}

	@Test public void testCollectionMinus() {
		assertQueryResults(null, "Set{'b'}", "Set{'a', 'b', 'c'} - Set{'c', 'a'}");
		/*
		 * FIXME OMG-issue generalise to UniqueCollection::-
		 * "OrderedSet::-(Set) : Set", we also need "Set::-(OrderedSet) : Set"
		 * and "OrderedSet::-(OrderedSet) : OrderedSet". That being said,
		 * "OrderedSet::-(Set) : Set" should be
		 * "OrderedSet::-(Set) : OrderedSet". revisit all "testCollectionMinus*"
		 * to add the new
		 */
		assertQueryResults(null, "OrderedSet{'b'}", "OrderedSet{'a', 'b', 'c'} - Set{'c', 'a'}");
		// invalid collection
		assertQueryInvalid(null, "let s : Set(String) = invalid in s - Set{'c'}");
		assertQueryInvalid(null, "let s : Set(String) = invalid in Set{'a'} - s");
		// invalid collection element
		assertQueryInvalid(null, "Set{'a', invalid} - Set{'c', invalid}");
		assertQueryInvalid(null, "Set{'a', invalid} - Set{'c', 'a'}");
		// null collection
		assertQueryInvalid(null, "let s : Set(String) = null in s - Set{'c', null}");
		assertQueryInvalid(null, "let s : Set(String) = null in Set{'a', null} - s");
		// null collection element
		assertQueryResults(null, "Set{'a'}", "Set{'a', null} - Set{'c', null}");
		assertQueryResults(null, "Set{null}", "Set{'a', null} - Set{'c', 'a'}");
	}

	@Test public void testCollectionNotEmpty() {
		assertQueryFalse(null, "Sequence{}->notEmpty()");
		assertQueryFalse(null, "Bag{}->notEmpty()");
		assertQueryFalse(null, "Set{}->notEmpty()");
		assertQueryFalse(null, "OrderedSet{}->notEmpty()");

		assertQueryTrue(null, "Sequence{4, 4, 'test'}->notEmpty()");
		assertQueryTrue(null, "Bag{4, 4, 'test'}->notEmpty()");
		assertQueryTrue(null, "Set{4, 4, 'test'}->notEmpty()");
		assertQueryTrue(null, "OrderedSet{4, 4, 'test'}->notEmpty()");

		assertQueryTrue(null, "'test'->notEmpty()");
		assertQueryTrue(null, "''->notEmpty()");
		// invalid collection
		assertQueryInvalid(null, "invalid->notEmpty()", "invalid", InvalidValueException.class);
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->notEmpty()", "invalid", InvalidValueException.class);
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->notEmpty()", "invalid", InvalidValueException.class);
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->notEmpty()", "invalid", InvalidValueException.class);
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->notEmpty()", "invalid", InvalidValueException.class);
		// invalid collection element
		assertQueryInvalid(null, "Sequence{invalid}->notEmpty()", "invalid", InvalidValueException.class);
		assertQueryInvalid(null, "Bag{invalid}->notEmpty()", "invalid", InvalidValueException.class);
		assertQueryInvalid(null, "Set{invalid}->notEmpty()", "invalid", InvalidValueException.class);
		assertQueryInvalid(null, "OrderedSet{invalid}->notEmpty()", "invalid", InvalidValueException.class);
		// null collection
//		assertQueryInvalid(null, "null->notEmpty()");
		assertQueryFalse(null, "null->notEmpty()");
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->notEmpty()", "'Collection' rather than 'OclVoid' value required", InvalidValueException.class);
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->notEmpty()", "'Collection' rather than 'OclVoid' value required", InvalidValueException.class);
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->notEmpty()", "'Collection' rather than 'OclVoid' value required", InvalidValueException.class);
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->notEmpty()", "'Collection' rather than 'OclVoid' value required", InvalidValueException.class);
		// null collection element
		assertQueryTrue(null, "Sequence{null}->notEmpty()");
		assertQueryTrue(null, "Bag{null}->notEmpty()");
		assertQueryTrue(null, "Set{null}->notEmpty()");
		assertQueryTrue(null, "OrderedSet{null}->notEmpty()");
	}

	@Test public void testCollectionNotEqual() {		
		assertQueryTrue(null, "Bag{1} <> 1");
		assertQueryTrue(null, "OrderedSet{1} <> 1");
		assertQueryTrue(null, "Sequence{1} <> 1");
		assertQueryTrue(null, "Set{1} <> 1");

		assertQueryTrue(null, "1 <> Bag{1}");
		assertQueryTrue(null, "1 <> OrderedSet{1}");
		assertQueryTrue(null, "1 <> Sequence{1}");
		assertQueryTrue(null, "1 <> Set{1}");
		assertQueryTrue(null, "Set{1} <> Set{Set{1}}");

		assertQueryTrue(null, "Bag{1.01} <> Bag{1}");
		assertQueryTrue(null, "OrderedSet{1.01} <> OrderedSet{1}");
		assertQueryTrue(null, "Sequence{1.01} <> Sequence{1}");
		assertQueryTrue(null, "Set{1.01} <> Set{1}");
		assertQueryTrue(null, "Set{Set{1.01}} <> Set{Set{1}}");

		assertQueryFalse(null, "Bag{1.0} <> Bag{1}");
		assertQueryFalse(null, "OrderedSet{1.0} <> OrderedSet{1}");
		assertQueryFalse(null, "Sequence{1.0} <> Sequence{1}");
		assertQueryFalse(null, "Set{1.0} <> Set{1}");
		assertQueryFalse(null, "Set{Set{1.0}} <> Set{Set{1}}");

		assertQueryFalse(null, "Sequence{1..2} <> Sequence{1,2}");
		assertQueryFalse(null, "OrderedSet{1..2} <> OrderedSet{1,2}");
		assertQueryTrue(null, "Sequence{1..2} <> Sequence{2,1}");
		assertQueryTrue(null, "OrderedSet{1..2} <> OrderedSet{2,1}");
		assertQueryTrue(null, "Sequence{1..2} <> OrderedSet{1,2}");
	}

	@Test public void testCollectionNotEqualInvalid() {
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s <> Sequence{5}");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Bag{5} <> b");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s <> Set{5}");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in OrderedSet{5} <> o");

		assertQueryInvalid(null, "let s1 : Sequence(Integer) = invalid, s2 : Sequence(Integer) = invalid in s1 <> s2");
		assertQueryInvalid(null, "let b1 : Bag(Integer) = invalid, b2 : Bag(Integer) = invalid in b1 <> b2");
		assertQueryInvalid(null, "let s1 : Set(Integer) = invalid, s2 : Set(Integer) = invalid in s1 <> s2");
		assertQueryInvalid(null, "let o1 : OrderedSet(Integer) = invalid, o2 : OrderedSet(Integer) = invalid in o1 <> o2");
	}

	@Test public void testCollectionNotEqualNull() {
		assertQueryTrue(null, "let s : Sequence(Integer) = null in s <> Sequence{5}");
		assertQueryTrue(null, "let b : Bag(Integer) = null in Bag{5} <> b");
		assertQueryTrue(null, "let s : Set(Integer) = null in s <> Set{5}");
		assertQueryTrue(null, "let o : OrderedSet(Integer) = null in OrderedSet{5} <> o");

		assertQueryFalse(null, "let s1 : Sequence(Integer) = null, s2 : Sequence(Integer) = null in s1 <> s2");
		assertQueryFalse(null, "let b1 : Bag(Integer) = null, b2 : Bag(Integer) = null in b1 <> b2");
		assertQueryFalse(null, "let s1 : Set(Integer) = null, s2 : Set(Integer) = null in s1 <> s2");
		assertQueryFalse(null, "let o1 : OrderedSet(Integer) = null, o2 : OrderedSet(Integer) = null in o1 <> o2");
	}

	@Test public void testCollectionNotEqualOrderedXOrdered() {
		// same order, same quantities
/*		assertQueryFalse(null, "Sequence{4, 5, 'test'} <> Sequence{4, 5, 'test'}");
		assertQueryFalse(null, "Sequence{4, 5, 'test', 5} <> Sequence{4, 5, 'test', 5}");
		assertQueryFalse(null, "OrderedSet{4, 5, 'test', 5} <> OrderedSet{4, 5, 'test'}");
		assertQueryTrue(null, "Sequence{4, 5, 'test'} <> OrderedSet{4, 5, 'test', 5}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 5} <> Sequence{4, 5, 'test'}");

		// distinct order, same quantities
		assertQueryTrue(null, "Sequence{4, 5, 'test'} <> Sequence{4, 'test', 5}");
		assertQueryTrue(null, "Sequence{4, 5, 'test', 5} <> Sequence{5, 4, 'test', 5}");
*/		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 5} <> OrderedSet{4, 'test', 5}");
		assertQueryTrue(null, "Sequence{4, 5, 'test'} <> OrderedSet{5, 4, 'test', 5}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 5} <> Sequence{5, 4, 'test'}");

		// distinct quantities
		assertQueryTrue(null, "Sequence{4, 5, 'test', 5} <> Sequence{4, 5, 'test'}");
		assertQueryTrue(null, "Sequence{4, 5, 'test', 5} <> OrderedSet{4, 5, 'test', 5}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 5} <> Sequence{4, 5, 'test', 5}");
	}

@Test public void testCollectionNotEqualOrderedXUnordered() {
		// same quantities
		assertQueryTrue(null, "Sequence{4, 5, 'test'} <> Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "Sequence{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 4} <> Bag{4, 'test', 5}");

		// distinct quantities
		assertQueryTrue(null, "Sequence{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "Sequence{4, 5, 'test'} <> Bag{4, 'test', 5, 4}");
		assertQueryTrue(null, "OrderedSet{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
	}

	@Test public void testCollectionNotEqualUnorderedXUnordered() {
		// same quantities
		assertQueryTrue(null, "Bag{4, 5, 'test'} <> Set{4, 'test', 5, 4}");
		assertQueryFalse(null, "Bag{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
		assertQueryFalse(null, "Set{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "Set{4, 5, 'test', 4} <> Bag{4, 'test', 5}");

		// distinct quantities
		assertQueryTrue(null, "Bag{4, 5, 'test', 4} <> Set{4, 'test', 5, 4}");
		assertQueryTrue(null, "Bag{4, 5, 'test'} <> Bag{4, 'test', 5, 4}");
		assertQueryTrue(null, "Set{4, 5, 'test', 4} <> Bag{4, 'test', 5, 4}");
	}

	@Test public void testCollectionPrepend() {
		assertQueryResults(null, "Sequence{'c', 'a', 'b'}", "Sequence{'a', 'b'}->prepend('c')");
		assertQueryResults(null, "OrderedSet{'c', 'a', 'b'}", "OrderedSet{'a', 'b'}->prepend('c')");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->prepend('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->prepend('a')");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->prepend(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->prepend(invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->prepend('a')");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->prepend('a')");
		// null collection element
		assertQueryResults(null, "Sequence{null, 'a', null, 'b'}", "Sequence{'a', null, 'b'}->prepend(null)");
		assertQueryResults(null, "OrderedSet{null, 'a', 'b'}", "OrderedSet{'a', null, 'b'}->prepend(null)");
	}

	@Test public void testCollectionPrependAll() {
		assertQueryResults(null, "Sequence{'c', 'd', 'a', 'b'}", "Sequence{'a', 'b'}->prependAll(Sequence{'c', 'd'})");
		assertQueryResults(null, "Sequence{'c', 'd', 'a', 'b'}", "Sequence{'a', 'b'}->prependAll(OrderedSet{'c', 'd'})");
		assertQueryResults(null, "OrderedSet{'c', 'd', 'a', 'b'}", "OrderedSet{'a', 'b'}->prependAll(Sequence{'c', 'd'})");
		assertQueryResults(null, "OrderedSet{'c', 'd', 'a', 'b'}", "OrderedSet{'a', 'b'}->prependAll(OrderedSet{'c', 'd'})");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->prependAll(Sequence{'a', 'b'})");
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->prependAll(OrderedSet{'a', 'b'})");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{'a', 'b'}->prependAll(invalid)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b'}->prependAll(invalid)");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->prependAll(Sequence{'a', 'b'})");
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->prependAll(OrderedSet{'a', 'b'})");
		// null collection element
		assertQueryResults(null, "Sequence{null, null, 'a', null, 'b'}", "Sequence{'a', null, 'b'}->prependAll(Sequence{null,null})");
		assertQueryResults(null, "OrderedSet{null, 'a', 'b'}", "OrderedSet{'a', null, 'b'}->prependAll(Sequence{null,null})");
	}

	@Test public void testCollectionProduct() {
//		Abstract2Moniker.TRACE_MONIKERS.setState(true);
		String expectedResultExpression = "Set{Tuple{first = 3, second = 3.0}, Tuple{first = 3, second = 4.0}, Tuple{first = 4, second = 3.0}, Tuple{first = 4, second = 4.0}}";

		// Sequence::product(Collection)
		assertQueryResults(null, expectedResultExpression, "Sequence{3, 4}->product(Sequence{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Sequence{3, 4}->product(Bag{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Sequence{3, 4}->product(Set{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Sequence{3, 4}->product(OrderedSet{3.0, 4.0})");

		// Bag::product(Collection)
		assertQueryResults(null, expectedResultExpression, "Bag{3, 4}->product(Sequence{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Bag{3, 4}->product(Bag{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Bag{3, 4}->product(Set{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Bag{3, 4}->product(OrderedSet{3.0, 4.0})");

		// Set::product(Collection)
		assertQueryResults(null, expectedResultExpression, "Set{3, 4}->product(Sequence{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Set{3, 4}->product(Bag{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Set{3, 4}->product(Set{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "Set{3, 4}->product(OrderedSet{3.0, 4.0})");

		// OrderedSet::product(Collection)
		assertQueryResults(null, expectedResultExpression, "OrderedSet{3, 4}->product(Sequence{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "OrderedSet{3, 4}->product(Bag{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "OrderedSet{3, 4}->product(Set{3.0, 4.0})");
		assertQueryResults(null, expectedResultExpression, "OrderedSet{3, 4}->product(OrderedSet{3.0, 4.0})");
		// bug284129
//		assertQueryResults(null, "Set{Tuple{first = 3, second = 3.0}, Tuple{first = 3, second = 4}, Tuple{first = 4.0, second = 3.0}, Tuple{first = 4.0, second = 4}}", "Sequence{3, 4.0}->product(Sequence{3.0, 4})");
		assertQueryResults(null, "Set{Tuple{first = 3.0, second = 3.0}, Tuple{first = 3.0, second = 4.0}, Tuple{first = 4.0, second = 3.0}, Tuple{first = 4.0, second = 4.0}}", "Sequence{3, 4.0}->product(Sequence{3.0, 4})");
		// empty
		assertQueryEquals(null, getEmptySetValue(), "Sequence{3, 4}->product(OrderedSet{})");
		assertQueryEquals(null, getEmptySetValue(), "Bag{3, 4}->product(Set{})");
		assertQueryEquals(null, getEmptySetValue(), "Set{3, 4}->product(Bag{})");
		assertQueryEquals(null, getEmptySetValue(), "OrderedSet{3, 4}->product(Sequence{})");

		assertQueryEquals(null, getEmptySetValue(), "Sequence{}->product(OrderedSet{3, 4})");
		assertQueryEquals(null, getEmptySetValue(), "Bag{}->product(Set{3, 4})");
		assertQueryEquals(null, getEmptySetValue(), "Set{}->product(Bag{3, 4})");
		assertQueryEquals(null, getEmptySetValue(), "OrderedSet{}->product(Sequence{3, 4})");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in OrderedSet{3, 4}->product(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in Set{3, 4}->product(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in Bag{3, 4}->product(s)");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in Sequence{3, 4}->product(o)");

		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->product(OrderedSet{3, 4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->product(Set{3, 4})");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->product(Bag{3, 4})");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->product(Sequence{3, 4})");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{3, 4}->product(OrderedSet{invalid})");
		assertQueryInvalid(null, "Bag{3, 4}->product(Set{invalid})");
		assertQueryInvalid(null, "Set{3, 4}->product(Bag{invalid})");
		assertQueryInvalid(null, "OrderedSet{3, 4}->product(Sequence{invalid})");

		assertQueryInvalid(null, "Sequence{invalid, 4}->product(Sequence{3})");
		assertQueryInvalid(null, "Bag{invalid, 4}->product(Set{3})");
		assertQueryInvalid(null, "Set{invalid, 4}->product(Bag{3})");
		assertQueryInvalid(null, "OrderedSet{invalid, 4}->product(Sequence{3})");
	}

	@Test public void testCollectionProductNull() {
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in OrderedSet{3, 4}->product(s)");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in Set{3, 4}->product(b)");
		assertQueryInvalid(null, "let s : Set(Integer) = null in Bag{3, 4}->product(s)");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in Sequence{3, 4}->product(o)");

		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->product(OrderedSet{3, 4})");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->product(Set{3, 4})");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->product(Bag{3, 4})");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->product(Sequence{3, 4})");
	}

	@Test public void testCollectionProductNullValue() {
		assertQueryResults(null, "Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "Sequence{3, 4}->product(OrderedSet{null})");
		assertQueryResults(null, "Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "Bag{3, 4}->product(Set{null})");
		assertQueryResults(null, "Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "Set{3, 4}->product(Bag{null})");
		assertQueryResults(null, "Set{Tuple{first = 3, second = null}, Tuple{first = 4, second = null}}", "OrderedSet{3, 4}->product(Sequence{null})");

		assertQueryResults(null, "Set{Tuple{first = null, second = 3}, Tuple{first = null, second = 4}}", "Sequence{null}->product(OrderedSet{3, 4})");
		assertQueryResults(null, "Set{Tuple{first = null, second = 3}, Tuple{first = null, second = 4}}", "Bag{null}->product(Set{3, 4})");
		assertQueryResults(null, "Set{Tuple{first = null, second = 3}, Tuple{first = null, second = 4}}", "Set{null}->product(Bag{3, 4})");
		assertQueryResults(null, "Set{Tuple{first = null, second = 3}, Tuple{first = null, second = 4}}", "OrderedSet{null}->product(Sequence{3, 4})");

		assertQueryResults(null, "let nu : Integer = null in Set{Tuple{first = nu, second = 3}, Tuple{first = 4, second = 3}}", "Sequence{null, 4}->product(Sequence{3})");
		assertQueryResults(null, "let nu : Integer = null in Set{Tuple{first = nu, second = 3}, Tuple{first = 4, second = 3}}", "Bag{null, 4}->product(Set{3})");
		assertQueryResults(null, "let nu : Integer = null in Set{Tuple{first = nu, second = 3}, Tuple{first = 4, second = 3}}", "Set{null, 4}->product(Bag{3})");
		assertQueryResults(null, "let nu : Integer = null in Set{Tuple{first = nu, second = 3}, Tuple{first = 4, second = 3}}", "OrderedSet{null, 4}->product(Sequence{3})");

		assertQueryResults(null, "let n : Real = null in Set{Tuple{first = n, second = 3}, Tuple{first = 4.0, second = 3}}", "Sequence{null, 4.0}->product(Sequence{3})");
		assertQueryResults(null, "let n : Real = null in Set{Tuple{first = n, second = 3}, Tuple{first = 4.0, second = 3}}", "Bag{null, 4.0}->product(Sequence{3})");
		assertQueryResults(null, "let n : Real = null in Set{Tuple{first = n, second = 3}, Tuple{first = 4.0, second = 3}}", "Set{null, 4.0}->product(Sequence{3})");
		assertQueryResults(null, "let n : Real = null in Set{Tuple{first = n, second = 3}, Tuple{first = 4.0, second = 3}}", "OrderedSet{null, 4.0}->product(Sequence{3})");
	}

	@Test public void testCollectionReverse() {
		assertSemanticErrorQuery("Bag{1,3,null,2}->reverse()", OCLMessages.UnresolvedOperation_ERROR_, "Bag(Integer)", "reverse");
		assertQueryResults(null, "OrderedSet{}", "OrderedSet{}->reverse()");
		assertQueryResults(null, "OrderedSet{null}", "OrderedSet{null}->reverse()");
		assertQueryResults(null, "OrderedSet{2,1}", "OrderedSet{1,2}->reverse()");
		assertQueryResults(null, "OrderedSet{'a','b'}", "OrderedSet{'b','a'}->reverse()");
		assertQueryResults(null, "OrderedSet{}", "OrderedSet{}->reverse()");
		assertQueryResults(null, "OrderedSet{21,20,19,18,17,16,13,24,23,22,15,14,12,11,10,9,null,8,7,6,5,4,3,2,1}", "OrderedSet{1..4,3..8,null,9..12,14..15,4,22..24,13..21}->reverse()");
		assertQueryResults(null, "Sequence{2,null,3,1}", "Sequence{1,3,null,2}->reverse()");
		assertQueryResults(null, "Sequence{21,20,19,18,17,16,15,14,13,24,23,22,4,15,14,12,11,10,9,null,8,7,6,5,4,3,4,3,2,1}", "Sequence{1..4,3..8,null,9..12,14..15,4,22..24,13..21}->reverse()");
		assertQueryResults(null, "Sequence{Set{1..3},Sequence{1..3},OrderedSet{1,3},Bag{1,1,1}}", "Sequence{Bag{1,1,1},OrderedSet{1,3},Sequence{1..3},Set{1..3}}->reverse()");
		assertSemanticErrorQuery("Set{}->reverse()", OCLMessages.UnresolvedOperation_ERROR_, "Set(OclVoid)", "reverse");
	}

	@Test public void testCollectionSelectByKind() {
		assertQueryResults(null, "Bag{4,4}", "Bag{4, 4, 5.0, 'test', null}->selectByKind(Integer)");
		assertQueryResults(null, "OrderedSet{4}", "OrderedSet{4, 4, 5.0, 'test', null}->selectByKind(Integer)");
		assertQueryResults(null, "Sequence{4,4}", "Sequence{4, 4, 5.0, 'test', null}->selectByKind(Integer)");
		assertQueryResults(null, "Set{4}", "Set{4, 4, 5.0, 'test', null}->selectByKind(Integer)");
		//
		assertQueryResults(null, "Bag{}", "Bag{}->selectByKind(Integer)");
		assertQueryResults(null, "OrderedSet{}", "OrderedSet{}->selectByKind(Integer)");
		assertQueryResults(null, "Sequence{}", "Sequence{}->selectByKind(Integer)");
		assertQueryResults(null, "Set{}", "Set{}->selectByKind(Integer)");
		//
		assertQueryResults(null, "Bag{}", "Bag{null}->selectByKind(Integer)");
		assertQueryResults(null, "OrderedSet{}", "OrderedSet{null}->selectByKind(Integer)");
		assertQueryResults(null, "Sequence{}", "Sequence{null}->selectByKind(Integer)");
		assertQueryResults(null, "Set{}", "Set{null}->selectByKind(Integer)");
		//
		assertQueryResults(null, "Bag{}", "Bag{null}->selectByKind(OclVoid)");
		assertQueryResults(null, "OrderedSet{}", "OrderedSet{null}->selectByKind(OclVoid)");
		assertQueryResults(null, "Sequence{}", "Sequence{null}->selectByKind(OclVoid)");
		assertQueryResults(null, "Set{}", "Set{null}->selectByKind(OclVoid)");
		//
		assertQueryResults(null, "Bag{}", "Bag{null}->selectByKind(OclInvalid)");
		assertQueryResults(null, "OrderedSet{}", "OrderedSet{null}->selectByKind(OclInvalid)");
		assertQueryResults(null, "Sequence{}", "Sequence{null}->selectByKind(OclInvalid)");
		assertQueryResults(null, "Set{}", "Set{null}->selectByKind(OclInvalid)");
		//
		assertQueryResults(null, "Bag{*, *}", "Bag{4, 4, *, 5.0, 'test', *}->selectByKind(UnlimitedNatural)");
		assertQueryResults(null, "OrderedSet{*}", "OrderedSet{4, 4, *, 5.0, 'test', *}->selectByKind(UnlimitedNatural)");
		assertQueryResults(null, "Sequence{*, *}", "Sequence{4, 4, *, 5.0, 'test', *}->selectByKind(UnlimitedNatural)");
		assertQueryResults(null, "Set{*}", "Set{4, 4, *, 5.0, 'test', *}->selectByKind(UnlimitedNatural)");
		//
		assertQueryResults(null, "Sequence{'TEST'}", "Sequence{4, 4, 5.0, 'test'}->selectByKind(String).toUpper()");
		assertQueryEquals(null, 9.0, "Set{4, 4, 5.0, 'test'}->selectByKind(Real)->sum()");
		assertQueryEquals(null, 4, "Set{4, 4, 5.0, 'test'}->selectByKind(Integer)->sum()");
	}

	@Test public void testCollectionSelectByType() {
		assertQueryResults(null, "Bag{4,4}", "Bag{4, 4, 5.0, 'test', null}->selectByType(Integer)");
		assertQueryResults(null, "OrderedSet{4}", "OrderedSet{4, 4, 5.0, 'test', null}->selectByType(Integer)");
		assertQueryResults(null, "Sequence{4,4}", "Sequence{4, 4, 5.0, 'test', null}->selectByType(Integer)");
		assertQueryResults(null, "Set{4}", "Set{4, 4, 5.0, 'test', null}->selectByType(Integer)");
		//
		assertQueryResults(null, "Bag{}", "Bag{}->selectByType(Integer)");
		assertQueryResults(null, "OrderedSet{}", "OrderedSet{}->selectByType(Integer)");
		assertQueryResults(null, "Sequence{}", "Sequence{}->selectByType(Integer)");
		assertQueryResults(null, "Set{}", "Set{}->selectByType(Integer)");
		//
		assertQueryResults(null, "Bag{}", "Bag{null}->selectByType(Integer)");
		assertQueryResults(null, "OrderedSet{}", "OrderedSet{null}->selectByType(Integer)");
		assertQueryResults(null, "Sequence{}", "Sequence{null}->selectByType(Integer)");
		assertQueryResults(null, "Set{}", "Set{null}->selectByType(Integer)");
		//
		assertQueryResults(null, "Bag{null}", "Bag{null}->selectByType(OclVoid)");
		assertQueryResults(null, "OrderedSet{null}", "OrderedSet{null}->selectByType(OclVoid)");
		assertQueryResults(null, "Sequence{null}", "Sequence{null}->selectByType(OclVoid)");
		assertQueryResults(null, "Set{null}", "Set{null}->selectByType(OclVoid)");
		//
		assertQueryResults(null, "Bag{}", "Bag{null}->selectByType(OclInvalid)");
		assertQueryResults(null, "OrderedSet{}", "OrderedSet{null}->selectByType(OclInvalid)");
		assertQueryResults(null, "Sequence{}", "Sequence{null}->selectByType(OclInvalid)");
		assertQueryResults(null, "Set{}", "Set{null}->selectByType(OclInvalid)");
		//
		assertQueryResults(null, "Bag{*, *}", "Bag{4, 4, *, 5.0, 'test', *}->selectByType(UnlimitedNatural)");
		assertQueryResults(null, "OrderedSet{*}", "OrderedSet{4, 4, *, 5.0, 'test', *}->selectByType(UnlimitedNatural)");
		assertQueryResults(null, "Sequence{*, *}", "Sequence{4, 4, *, 5.0, 'test', *}->selectByType(UnlimitedNatural)");
		assertQueryResults(null, "Set{*}", "Set{4, 4, *, 5.0, 'test', *}->selectByType(UnlimitedNatural)");
		//
		assertQueryResults(null, "Sequence{'TEST'}", "Sequence{4, 4, 5.0, 'test'}->selectByType(String).toUpper()");
		assertQueryEquals(null, 5.0, "Set{4, 4, 5.0, 'test'}->selectByType(Real)->sum()");
		assertQueryEquals(null, 4, "Set{4, 4, 5.0, 'test'}->selectByType(Integer)->sum()");
	}

	@Test public void testCollectionSize() {
		assertQueryEquals(null, 4, "Sequence{4, 4, 5, 'test'}->size()");
		assertQueryEquals(null, 4, "Bag{4, 4, 5, 'test'}->size()");
		assertQueryEquals(null, 3, "Set{4, 4, 5, 'test'}->size()");
		assertQueryEquals(null, 3, "OrderedSet{4, 4, 5, 'test'}->size()");

		assertQueryEquals(null, 0, "Sequence{}->size()");
		assertQueryEquals(null, 0, "Bag{}->size()");
		assertQueryEquals(null, 0, "Set{}->size()");
		assertQueryEquals(null, 0, "OrderedSet{}->size()");
		// invalid collection
		assertQueryInvalid(null, "let s : String = invalid in s->size()");
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->size()");
		// invalid collection element
		assertQueryInvalid(null, "OrderedSet{'a', 'b', invalid}->size()");
		assertQueryInvalid(null, "Set{'a', 'b', invalid}->size()");
		assertQueryInvalid(null, "Bag{'a', 'b', invalid}->size()");
		assertQueryInvalid(null, "Sequence{'a', 'b', invalid}->size()");
		// null collection
//		assertQueryInvalid(null, "let s : String = null in s->size()");
		assertQueryEquals(null, 0, "let s : String = null in s->size()");
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->size()");
		// null collection element
		assertQueryEquals(null, 4, "Sequence{'a', 'b', null, null}->size()");
		assertQueryEquals(null, 4, "Bag{'a', 'b', null, null}->size()");
		assertQueryEquals(null, 3, "Set{'a', 'b', null, null}->size()");
		assertQueryEquals(null, 3, "OrderedSet{'a', 'b', null, null}->size()");
	}

	@Test public void testCollectionSubOrderedSet() {
		assertQueryResults(null, "OrderedSet{'a'}", "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(1, 1)");
		assertQueryResults(null, "OrderedSet{'b', 'c'}", "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(2, 3)");
		assertQueryResults(null, "OrderedSet{'d'}", "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(4, 4)");
		// invalid collection
		assertQueryInvalid(null, "let o : OrderedSet(String) = invalid in o->subOrderedSet(1, 1)");
		// null collection
		assertQueryInvalid(null, "let o : OrderedSet(String) = null in o->subOrderedSet(1, 1)");
		// out of bounds
		assertQueryInvalid(null, "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(0, 1)");
		assertQueryInvalid(null, "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(4, 5)");
		// illegal arguments
		assertQueryInvalid(null, "OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(2, 1)");
	}

	@Test public void testCollectionSubSequence() {
		assertQueryResults(null, "Sequence{'a'}", "Sequence{'a', 'b', 'c', 'd'}->subSequence(1, 1)");
		assertQueryResults(null, "Sequence{'b', 'c'}", "Sequence{'a', 'b', 'c', 'd'}->subSequence(2, 3)");
		assertQueryResults(null, "Sequence{'d'}", "Sequence{'a', 'b', 'c', 'd'}->subSequence(4, 4)");
		// invalid collection
		assertQueryInvalid(null, "let o : Sequence(String) = invalid in o->subSequence(1, 1)");
		// null collection
		assertQueryInvalid(null, "let o : Sequence(String) = null in o->subSequence(1, 1)");
		// out of bounds
		assertQueryInvalid(null, "Sequence{'a', 'b', 'c', 'd'}->subSequence(0, 1)");
		assertQueryInvalid(null, "Sequence{'a', 'b', 'c', 'd'}->subSequence(4, 5)");
		// illegal arguments
		assertQueryInvalid(null, "Sequence{'a', 'b', 'c', 'd'}->subSequence(2, 1)");
	}

	@Test public void testCollectionSum() {
		DomainStandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
		assertQueryEquals(null, 0, "let s : Sequence(Integer) = Sequence{} in s->sum()");
		assertQueryEquals(null, 0.0, "let b : Bag(Real) = Bag{} in b->sum()");
		assertQueryEquals(null, 0.0, "let s : Set(Real) = Set{} in s->sum()");
		assertQueryEquals(null, 0, "let o : OrderedSet(Integer) = OrderedSet{} in o->sum()");

		assertQueryEquals(null, 13.0, "Sequence{4.0, 4.0, 5.0}->sum()");
		assertQueryEquals(null, 13, "Bag{4, 4, 5}->sum()");
		assertQueryEquals(null, 9.0, "Set{4, 4.0, 5.0}->sum()");
		assertQueryEquals(null, 9.0, "OrderedSet{4.0, 4.0, 5.0}->sum()");
		assertQueryEquals(null, standardLibrary.getRealType(), "Bag{4.0, 4, 5}->sum().oclType()");
		assertQueryEquals(null, standardLibrary.getIntegerType(), "Bag{4, -4, -5}->sum().oclType()");
		assertQueryEquals(null, standardLibrary.getIntegerType(), "Bag{4, 4, 5}->sum().oclType()");

		assertQueryEquals(null, 4, "4->sum()");
		// invalid collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = invalid in s->sum()");
		assertQueryInvalid(null, "let b : Bag(Integer) = invalid in b->sum()");
		assertQueryInvalid(null, "let s : Set(Integer) = invalid in s->sum()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = invalid in o->sum()");
		// invalid collection element
		assertQueryInvalid(null, "Sequence{4.0, invalid, 5.0}->sum()");
		assertQueryInvalid(null, "Bag{4, invalid, 5}->sum()");
		assertQueryInvalid(null, "Set{4, invalid, 5}->sum()");
		assertQueryInvalid(null, "OrderedSet{4.0, invalid, 5.0}->sum()");
		// null collection
		assertQueryInvalid(null, "let s : Sequence(Integer) = null in s->sum()");
		assertQueryInvalid(null, "let b : Bag(Integer) = null in b->sum()");
		assertQueryInvalid(null, "let s : Set(Integer) = null in s->sum()");
		assertQueryInvalid(null, "let o : OrderedSet(Integer) = null in o->sum()");
		// null collection element
		assertQueryInvalid(null, "Sequence{4.0, null, 5.0}->sum()");
		assertQueryInvalid(null, "Bag{4, null, 5}->sum()");
		assertQueryInvalid(null, "Set{4, null, 5}->sum()");
		assertQueryInvalid(null, "OrderedSet{4.0, null, 5.0}->sum()");

		// FIXME Bug 301351 Subtest-not-implemented user-defined +
	}

	@Test public void testCollectionSymmetricDifference() {
		assertQueryResults(null, "Set{'a', 'c'}", "Set{'a', 'b'}->symmetricDifference(Set{'b', 'c'})");
		// invalid collection
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->symmetricDifference(Set{'a'})");
		// invalid collection element
		assertQueryInvalid(null, "Set{'a', invalid, 'b'}->symmetricDifference(Set{'b', 'c'})");
		// null collection
		assertQueryInvalid(null, "let s : Set(String) = null in s->symmetricDifference(Set{'a'})");
		// null collection element
		assertQueryResults(null, "Set{'a', null, 'c'}", "Set{'a', null, 'b'}->symmetricDifference(Set{'b', 'c'})");
	}

	@Test public void testCollectionUnionDuplicates() {
		assertQueryResults(null, "Set{'a', 'b', 'c'}", "Set{'a', 'b', 'a'}->union(Set{'b', 'c'})");
		assertQueryResults(null, "Bag{'a', 'b', 'b', 'c'}", "Set{'a', 'b', 'a'}->union(Bag{'b', 'c'})");
		assertQueryResults(null, "Bag{'a', 'b', 'a', 'b', 'c'}", "Bag{'a', 'b', 'a'}->union(Bag{'b', 'c'})");
		assertQueryResults(null, "Bag{'a', 'b', 'a', 'b', 'c'}", "Bag{'a', 'b', 'a'}->union(Set{'b', 'c'})");

//		assertQueryResults(null, "Sequence{'a', 'b', 'a', 'b', 'c'}", "Sequence{'a', 'b', 'a'}->union(Sequence{'b', 'c'})");
		assertQueryResults(null, "Bag{'a', 'b', 'a', 'b', 'c'}", "Sequence{'a', 'b', 'a'}->union(Sequence{'b', 'c'})");
	}

	@Test public void testCollectionUnionEmptyCollection() {
		assertQueryResults(null, "Set{3, 4}", "Set{}->union(Set{3, 4})");
//
		assertQueryResults(null, "Set{3, 4}", "Set{3, 4}->union(Set{})");
		assertQueryResults(null, "Bag{3, 4}", "Set{3, 4}->union(Bag{})");
		assertQueryResults(null, "Bag{3, 4}", "Bag{3, 4}->union(Bag{})");
		assertQueryResults(null, "Bag{3, 4}", "Bag{3, 4}->union(Set{})");
		assertQueryResults(null, "Bag{3, 4}", "Sequence{3, 4}->union(Sequence{})");

		assertQueryResults(null, "Set{3, 4}", "Set{}->union(Set{3, 4})");
		assertQueryResults(null, "Bag{3, 4}", "Set{}->union(Bag{3, 4})");
		assertQueryResults(null, "Bag{3, 4}", "Bag{}->union(Bag{3, 4})");
		assertQueryResults(null, "Bag{3, 4}", "Bag{}->union(Set{3, 4})");
		assertQueryResults(null, "Bag{3, 4}", "Sequence{}->union(Sequence{3, 4})");
	}

	@Test public void testCollectionUnionInvalid() {
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->union(Set{'a'})");
		assertQueryInvalid(null, "let s : Set(String) = invalid in s->union(Bag{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->union(Bag{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in b->union(Set{'a'})");
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in s->union(Sequence{'a'})");

		assertQueryInvalid(null, "let s : Set(String) = invalid in Set{'a'}->union(s)");
		assertQueryInvalid(null, "let s : Set(String) = invalid in Bag{'a'}->union(s)");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in Bag{'a'}->union(b)");
		assertQueryInvalid(null, "let b : Bag(String) = invalid in Set{'a'}->union(b)");
		assertQueryInvalid(null, "let s : Sequence(String) = invalid in Sequence{'a'}->union(s)");
	}

	@Test public void testCollectionUnionInvalidValue() {
		assertQueryInvalid(null, "Set{'a', invalid}->union(Set{'b', invalid})");
		assertQueryInvalid(null, "Set{'a', invalid}->union(Bag{'b', invalid})");
		assertQueryInvalid(null, "Bag{'a', invalid}->union(Bag{'b', invalid})");
		assertQueryInvalid(null, "Bag{'a', invalid}->union(Set{'b', invalid})");
		assertQueryInvalid(null, "Sequence{'a', invalid}->union(Sequence{'b', invalid})");
	}

	@Test public void testCollectionUnionNoDuplicates() {
		/*
		 * FIXME OMG-issue generalise to Collection::union
		 * the specification defines operations Set::union(Set),
		 * Set::union(Bag), Bag::union(Set) and Bag::union(Bag) with the same
		 * semantics "the union of self and bag" and operation
		 * Sequence::union(Sequence) with the description
		 * "The sequence consisting of all elements in self, followed by all elements in s"
		 * . Why aren't there Sequence::union(OrderedSet),
		 * OrderedSet::union(Sequence) and OrderedSet::union(OrderedSet) with
		 * the same semantics as Sequence::union(Sequence) ? That is most likely
		 * an overlook.
		 */
		assertQueryResults(null, "Set{'a', 'b', 'c', 'd'}", "Set{'a', 'b'}->union(Set{'c', 'd'})");
		assertQueryResults(null, "Bag{'a', 'b', 'c', 'd'}", "Set{'a', 'b'}->union(Bag{'c', 'd'})");
		assertQueryResults(null, "Bag{'a', 'b', 'c', 'd'}", "Bag{'a', 'b'}->union(Bag{'c', 'd'})");
		assertQueryResults(null, "Bag{'a', 'b', 'c', 'd'}", "Bag{'a', 'b'}->union(Set{'c', 'd'})");

//		assertQueryResults(null, "Sequence{'a', 'b', 'c', 'd'}", "Sequence{'a', 'b'}->union(Sequence{'c', 'd'})");
		assertQueryResults(null, "Bag{'a', 'b', 'c', 'd'}", "Sequence{'a', 'b'}->union(Sequence{'c', 'd'})");
	}

	@Test public void testCollectionUnionNull() {
		assertQueryInvalid(null, "let s : Set(String) = null in s->union(Set{'a'})");
		assertQueryInvalid(null, "let s : Set(String) = null in s->union(Bag{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = null in b->union(Bag{'a'})");
		assertQueryInvalid(null, "let b : Bag(String) = null in b->union(Set{'a'})");
		assertQueryInvalid(null, "let s : Sequence(String) = null in s->union(Sequence{'a'})");

		assertQueryInvalid(null, "let s : Set(String) = null in Set{'a'}->union(s)");
		assertQueryInvalid(null, "let s : Set(String) = null in Bag{'a'}->union(s)");
		assertQueryInvalid(null, "let b : Bag(String) = null in Bag{'a'}->union(b)");
		assertQueryInvalid(null, "let b : Bag(String) = null in Set{'a'}->union(b)");
		assertQueryInvalid(null, "let s : Sequence(String) = null in Sequence{'a'}->union(s)");
	}

	@Test public void testCollectionUnionNullValue() {
		assertQueryResults(null, "Set{'a', null, 'b'}", "Set{'a', null}->union(Set{'b', null})");
		assertQueryResults(null, "Bag{'a', null, 'b', null}", "Set{'a', null}->union(Bag{'b', null})");
		assertQueryResults(null, "Bag{'a', null, 'b', null}", "Bag{'a', null}->union(Bag{'b', null})");
		assertQueryResults(null, "Bag{'a', null, 'b', null}", "Bag{'a', null}->union(Set{'b', null})");
//		assertQueryResults(null, "Sequence{'a', null, 'b', null}", "Sequence{'a', null}->union(Sequence{'b', null})");
		assertQueryResults(null, "Bag{'a', null, 'b', null}", "Sequence{'a', null}->union(Sequence{'b', null})");
	}

	@Test public void testCollectionUpper() {
		assertQueryEquals(null, 3, "Sequence{1, 2.0, '3'}->oclType().upper");
		assertQueryEquals(null, 3, "Sequence{1, 2.0, 3}->oclAsType(Collection(Real))->oclType().upper");
		assertQueryEquals(null, 3, "Set{1, 2.0, 3}->oclAsType(Collection(Real)[2..4])->oclType().upper"); // no change to dynamic bound
	}
}
