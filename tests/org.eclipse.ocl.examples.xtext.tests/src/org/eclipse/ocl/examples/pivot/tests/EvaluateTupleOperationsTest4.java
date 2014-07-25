/*******************************************************************************
 * Copyright (c) 2014 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for Tuple operations.
 */
@SuppressWarnings("nls")
@RunWith(value = Parameterized.class)
public class EvaluateTupleOperationsTest4 extends PivotTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false}, {true}};
		return Arrays.asList(data);
	}

	public EvaluateTupleOperationsTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateTupleOperations";
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

	@Test public void testTupleType_Collections() {
		TuplePartId aTuplePartId = IdManager.getTuplePartId(0, "a", TypeId.UNLIMITED_NATURAL);
		@SuppressWarnings("null") TupleTypeId aTupleTypeId = IdManager.getTupleTypeId("Tuple", Collections.singletonList(aTuplePartId));
		Map<TuplePartId, Object> aValues = new HashMap<TuplePartId, Object>();
		aValues.put(aTuplePartId, ValuesUtil.integerValueOf(3));
		TupleValue aValue = ValuesUtil.createTupleValue(aTupleTypeId, aValues);
		TuplePartId bTuplePartId = IdManager.getTuplePartId(0, "b", TypeId.UNLIMITED_NATURAL);
		@SuppressWarnings("null") TupleTypeId bTupleTypeId = IdManager.getTupleTypeId("Tuple", Collections.singletonList(bTuplePartId));
		Map<TuplePartId, Object> bValues = new HashMap<TuplePartId, Object>();
		bValues.put(bTuplePartId, ValuesUtil.integerValueOf(4));
		TupleValue bValue = ValuesUtil.createTupleValue(bTupleTypeId, bValues);
		CollectionTypeId collectionTypeId = TypeId.SET.getSpecializedId(TypeId.OCL_ANY);
		SetValue setValue = ValuesUtil.createSetOfEach(collectionTypeId,  aValue, bValue);
		assertQueryEquals(null, setValue, "Set{Tuple{a = 3}, Tuple{b = 4}, Tuple{a = 3}}");						// BUG 4404404
		assertValidationErrorQuery2(null, "let s : Set(Tuple(a:UnlimitedNatural)) = Set{Tuple{a = 3}, Tuple{b = 4}} in s",
			EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Variable", "CompatibleInitialiserType",
			"s : Set(Tuple(a:UnlimitedNatural)) = Set{Tuple{a : UnlimitedNatural = 3}, Tuple{b : UnlimitedNatural = 4}}");
		assertQueryEquals(null, setValue, "let s : Set(OclAny) = Set{Tuple{a = 3}, Tuple{b = 4}} in s");
	}

	@Test public void testTupleType_Conformance() {
		assertSemanticErrorQuery("let s : Sequence(OclAny) = Sequence{Tuple{a = 3}, Tuple{b = 4}} in s->first().a", OCLMessages.UnresolvedProperty_ERROR_, "a", "OclAny");
		assertQueryEquals(null, 3, "let s : Sequence(OclAny) = Sequence{Tuple{a = 3}, Tuple{b = 4}} in s->first().oclAsType(Tuple(a:UnlimitedNatural)).a");
// BUG 440453		assertQueryEquals(null, 3, "let s : Sequence(OclAny) = Sequence{Tuple{a = 3}, Tuple{b = 4}} in s->first().oclAsType(Tuple(b:UnlimitedNatural)).b");
//
	}

	@Test public void testTupleType_Equals() {
		assertQueryTrue(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}.b = Tuple{b = 3, a = Tuple{a = '3', b = Tuple{a = 3.1}}}.a");
//
		assertQueryTrue(null, "Tuple{a = 3, b = '4'} = Tuple{a = 3, b = '4'}");
		assertQueryTrue(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}} = Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}");
		assertQueryTrue(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}.b = Tuple{b = 3, a = Tuple{a = '3', b = Tuple{a = 3.1}}}.a");
		assertQueryTrue(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}.b.b = Tuple{b = 3, a = Tuple{b = '3', a = Tuple{a = 3.1}}}.a.a");
		assertQueryTrue(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}.b.b.a = Tuple{b = 3, a = Tuple{b = '3', a = Tuple{a = 3.1}}}.a.a.a");
		//
		assertQueryFalse(null, "Tuple{a = 3, b = '4'} = Tuple{b = 3, a = '4'}");
		assertQueryFalse(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}} = Tuple{a = 3, b = Tuple{a = '3', b = Tuple{b = 3.1}}}");
		assertQueryFalse(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}} = Tuple{a = 3, b = Tuple{a = '3', b = Tuple{b = 3.2}}}");
		assertQueryFalse(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}} = Tuple{a = 3, b = Tuple{a = '3', b = Tuple{b = '3.1'}}}");
	}

	@Test public void testTupleType_NotEquals() {
		assertQueryFalse(null, "Tuple{a = 3, b = '4'} <> Tuple{a = 3, b = '4'}");
		assertQueryFalse(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}} <> Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}");
		assertQueryFalse(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}.b <> Tuple{b = 3, a = Tuple{a = '3', b = Tuple{a = 3.1}}}.a");
		assertQueryFalse(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}.b.b <> Tuple{b = 3, a = Tuple{b = '3', a = Tuple{a = 3.1}}}.a.a");
		assertQueryFalse(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}.b.b.a <> Tuple{b = 3, a = Tuple{b = '3', a = Tuple{a = 3.1}}}.a.a.a");
		//
		assertQueryTrue(null, "Tuple{a = 3, b = '4'} <> Tuple{b = 3, a = '4'}");
		assertQueryTrue(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}} <> Tuple{a = 3, b = Tuple{a = '3', b = Tuple{b = 3.1}}}");
		assertQueryTrue(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}} <> Tuple{a = 3, b = Tuple{a = '3', b = Tuple{b = 3.2}}}");
		assertQueryTrue(null, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}} <> Tuple{a = 3, b = Tuple{a = '3', b = Tuple{b = '3.1'}}}");
	}

	@Test public void testTupleType_Parts() {
//		assertSemanticErrorQuery("let s : Sequence(OclAny) = Sequence{Tuple{a = 3}, Tuple{b = 4}} in s->first().a", OCLMessages.UnresolvedProperty_ERROR_, "a", "OclAny");
		assertQueryEquals(null, 3, "Tuple{a = 3, b = '4'}.a");
		assertQueryEquals(null, 3, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}.a");
		assertQueryEquals(null, "3", "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}.b.a");
		assertQueryEquals(null, 3.1, "Tuple{a = 3, b = Tuple{a = '3', b = Tuple{a = 3.1}}}.b.b.a");
		assertSemanticErrorQuery("Tuple{}.a", "missing EOF at ''{''");
		assertSemanticErrorQuery("Tuple{a = 3, b = '4'}.c", OCLMessages.UnresolvedProperty_ERROR_, "c", "Tuple(a:UnlimitedNatural,b:String)");
// FIXME Duplicate parts warning		assertQueryEquals(null, 3, "Tuple{a = 1, a = 1}.a");
	}
}

