/*******************************************************************************
 * Copyright (c) 2009,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *   E.D.Willink - Bug 400448
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.PivotConstantsInternal;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.messages.OCLMessages;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
@RunWith(value = Parameterized.class)
public class EvaluateOclAnyOperationsTest4 extends PivotSimpleTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false}, {true}};
		return Arrays.asList(data);
	}

	public EvaluateOclAnyOperationsTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateOclAnyOperations";
	}
	
	@BeforeClass public static void resetCounter() throws Exception {
		PivotTestSuite.resetCounter();
    }

    @Override
    @Before public void setUp() throws Exception {
        super.setUp();
        helper.setContext(getMetaclass("OclAny"));
    }

	@Override
	@After public void tearDown() throws Exception {
		super.tearDown();
	}

    @Test public void testEqual() {
		assertQueryTrue(null, "Boolean = Boolean");
		assertQueryFalse(null, "Boolean = Integer");
		assertQueryTrue(null, "OclVoid = OclVoid");
		assertQueryTrue(null, "OclInvalid = OclInvalid");
		assertQueryFalse(null, "OclInvalid = OclVoid");
		assertQueryTrue(null, "Set(String) = Set(String)");
		assertQueryFalse(null, "Set(String) = Set(Integer)");
		assertQueryFalse(null, "Set(String) = Sequence(String)");
		//
		assertQueryTrue(null, "ocl::CollectionKind::_'Collection' = ocl::CollectionKind::_'Collection'");
		assertQueryFalse(null, "ocl::CollectionKind::_'Collection' = ocl::CollectionKind::_'Set'");
    	//
		loadEPackage("ecore", EcorePackage.eINSTANCE);
    	assertQueryFalse(null, "ecore::EDate{'2000-01-25'} = ecore::EDate{'2000-01-24'}");
        assertQueryTrue(null, "ecore::EDate{'2000-01-24'} = ecore::EDate{'2000-01-24'}");
        assertQueryFalse(null, "ecore::EDate{'2000-01-23'} = ecore::EDate{'2000-01-24'}");
        //
	    // invalid
        //
		assertQueryInvalid(null, "invalid = 3");
		assertQueryInvalid(null, "3 = invalid");
		assertQueryInvalid(null, "invalid = 3.0");
		assertQueryInvalid(null, "3.0 = invalid");

		assertQueryInvalid(null, "invalid = 'test'");
		assertQueryInvalid(null, "'test' = invalid");
		assertQueryInvalid(null, "invalid = true");
		assertQueryInvalid(null, "false = invalid");
		assertQueryInvalid(null, "invalid = Sequence{}");
		assertQueryInvalid(null, "Sequence{} = invalid");

		assertQueryInvalid(null, "invalid = invalid");
		//
		// null
		//
		assertQueryFalse(null, "null = 3");
		assertQueryFalse(null, "3 = null");
		assertQueryFalse(null, "null = 3.0");
		assertQueryFalse(null, "3.0 = null");

		assertQueryFalse(null, "null = 'test'");
		assertQueryFalse(null, "'test' = null");
		assertQueryFalse(null, "null = true");
		assertQueryFalse(null, "false = null");
		assertQueryFalse(null, "null = Sequence{}");
		assertQueryFalse(null, "Sequence{} = null");

		assertQueryTrue(null, "null = null");
	}
    
    @Test public void testGreaterThan() {
    	StandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
    	loadEPackage("ecore", EcorePackage.eINSTANCE);
        assertQueryTrue(null, "ecore::EDate{'2000-01-25'} > ecore::EDate{'2000-01-24'}");
        assertQueryFalse(null, "ecore::EDate{'2000-01-24'} > ecore::EDate{'2000-01-24'}");
        assertQueryFalse(null, "ecore::EDate{'2000-01-23'} > ecore::EDate{'2000-01-24'}");
        //
	    // invalid
        //
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("invalid > 0", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclInvalidType(), PivotConstantsInternal.GREATER_THAN_OPERATOR, standardLibrary.getIntegerType());
//		assertQueryInvalid(null, "invalid > 0");
//		assertSemanticErrorQuery("0 > invalid", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.GREATER_THAN_OPERATOR);
		assertQueryInvalid(null, "0 > invalid");
		assertSemanticErrorQuery("invalid > invalid", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclInvalidType(), PivotConstantsInternal.GREATER_THAN_OPERATOR, standardLibrary.getOclInvalidType());
		//
		// null
		//
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("null > 0", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclVoidType(), PivotConstantsInternal.GREATER_THAN_OPERATOR, standardLibrary.getIntegerType());
//		assertQueryInvalid(null, "null > 0");
//		assertSemanticErrorQuery("0 > null", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.GREATER_THAN_OPERATOR);
		assertQueryInvalid(null, "0 > null");
		assertSemanticErrorQuery("null > null", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclVoidType(), PivotConstantsInternal.GREATER_THAN_OPERATOR, standardLibrary.getOclVoidType());
	}
    
    @Test public void testGreaterThanOrEqual() {
    	StandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
    	loadEPackage("ecore", EcorePackage.eINSTANCE);
        assertQueryTrue(null, "ecore::EDate{'2000-01-25'} >= ecore::EDate{'2000-01-24'}");
        assertQueryTrue(null, "ecore::EDate{'2000-01-24'} >= ecore::EDate{'2000-01-24'}");
        assertQueryFalse(null, "ecore::EDate{'2000-01-23'} >= ecore::EDate{'2000-01-24'}");
        //
	    // invalid
        //
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("invalid >= 0", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclInvalidType(), PivotConstantsInternal.GREATER_THAN_OR_EQUAL_OPERATOR, standardLibrary.getIntegerType());
//		assertQueryInvalid(null, "invalid >= 0");
//		assertSemanticErrorQuery("0 >= invalid", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.GREATER_THAN_OR_EQUAL_OPERATOR);
		assertQueryInvalid(null, "0 >= invalid");
		assertSemanticErrorQuery("invalid >= invalid", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclInvalidType(), PivotConstantsInternal.GREATER_THAN_OR_EQUAL_OPERATOR, standardLibrary.getOclInvalidType());
		//
		// null
		//
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("null >= 0", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclVoidType(), PivotConstantsInternal.GREATER_THAN_OR_EQUAL_OPERATOR, standardLibrary.getIntegerType());
//		assertQueryInvalid(null, "null >= 0");
//		assertSemanticErrorQuery("0 >= null", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.GREATER_THAN_OR_EQUAL_OPERATOR);
		assertQueryInvalid(null, "0 >= null");
		assertSemanticErrorQuery("null >= null", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclVoidType(), PivotConstantsInternal.GREATER_THAN_OR_EQUAL_OPERATOR, standardLibrary.getOclVoidType());
	}
    
    @Test public void testLessThan() {
    	StandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
    	loadEPackage("ecore", EcorePackage.eINSTANCE);
    	assertQueryFalse(null, "ecore::EDate{'2000-01-25'} < ecore::EDate{'2000-01-24'}");
    	assertQueryFalse(null, "ecore::EDate{'2000-01-24'} < ecore::EDate{'2000-01-24'}");
        assertQueryTrue(null, "ecore::EDate{'2000-01-23'} < ecore::EDate{'2000-01-24'}");
        //
	    // invalid
        //
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("invalid < 0", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclInvalidType(), PivotConstantsInternal.LESS_THAN_OPERATOR, standardLibrary.getIntegerType());
//		assertQueryInvalid(null, "invalid < 0");
//		assertSemanticErrorQuery("0 < invalid", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.LESS_THAN_OPERATOR);
		assertQueryInvalid(null, "0 < invalid");
		assertSemanticErrorQuery("invalid < invalid", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclInvalidType(), PivotConstantsInternal.LESS_THAN_OPERATOR, standardLibrary.getOclInvalidType());
		//
		// null
		//
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("null < 0", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclVoidType(), PivotConstantsInternal.LESS_THAN_OPERATOR, standardLibrary.getIntegerType());
//		assertQueryInvalid(null, "null < 0");
//		assertSemanticErrorQuery("0 < null", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.LESS_THAN_OPERATOR);
		assertQueryInvalid(null, "0 < null");
		assertSemanticErrorQuery("null < null", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclVoidType(), PivotConstantsInternal.LESS_THAN_OPERATOR, standardLibrary.getOclVoidType());
	}
    
    @Test public void testLessThanOrEqual() {
    	StandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
    	loadEPackage("ecore", EcorePackage.eINSTANCE);
    	assertQueryFalse(null, "ecore::EDate{'2000-01-25'} <= ecore::EDate{'2000-01-24'}");
        assertQueryTrue(null, "ecore::EDate{'2000-01-24'} <= ecore::EDate{'2000-01-24'}");
        assertQueryTrue(null, "ecore::EDate{'2000-01-23'} <= ecore::EDate{'2000-01-24'}");
        //
	    // invalid
        //
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("invalid <= 0", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclInvalidType(), PivotConstantsInternal.LESS_THAN_OR_EQUAL_OPERATOR, standardLibrary.getIntegerType());
//		assertQueryInvalid(null, "invalid <= 0");
//		assertSemanticErrorQuery("0 <= invalid", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.LESS_THAN_OR_EQUAL_OPERATOR);
		assertQueryInvalid(null, "0 <= invalid");
		assertSemanticErrorQuery("invalid <= invalid", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclInvalidType(), PivotConstantsInternal.LESS_THAN_OR_EQUAL_OPERATOR, standardLibrary.getOclInvalidType());
		//
		// null
		//
		// FIXME Analyzer-extraOperation OclAny::< should not be defined
		assertSemanticErrorQuery("null <= 0", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclVoidType(), PivotConstantsInternal.LESS_THAN_OR_EQUAL_OPERATOR, standardLibrary.getIntegerType());
//		assertQueryInvalid(null, "null <= 0");
//		assertSemanticErrorQuery("0 <= null", OCLMessages.OperationCallNotFound_ERROR_, PivotConstants.LESS_THAN_OR_EQUAL_OPERATOR);
		assertQueryInvalid(null, "0 <= null");
		assertSemanticErrorQuery("null <= null", OCLMessages.UnresolvedOperationCall_ERROR_, standardLibrary.getOclVoidType(), PivotConstantsInternal.LESS_THAN_OR_EQUAL_OPERATOR, standardLibrary.getOclVoidType());
	}

	@Test public void testNotEqual() {
		assertQueryFalse(null, "Boolean <> Boolean");
		assertQueryTrue(null, "Boolean <> Integer");
		assertQueryFalse(null, "OclVoid <> OclVoid");
		assertQueryFalse(null, "OclInvalid <> OclInvalid");
		assertQueryTrue(null, "OclInvalid <> OclVoid");
		assertQueryFalse(null, "Set(String) <> Set(String)");
		assertQueryTrue(null, "Set(String) <> Set(Integer)");
		assertQueryTrue(null, "Set(String) <> Sequence(String)");
		//
		assertQueryFalse(null, "ocl::CollectionKind::_'Collection' <> ocl::CollectionKind::_'Collection'");
		assertQueryTrue(null, "ocl::CollectionKind::_'Collection' <> ocl::CollectionKind::_'Set'");
		//
		loadEPackage("ecore", EcorePackage.eINSTANCE);
    	assertQueryTrue(null, "ecore::EDate{'2000-01-25'} <> ecore::EDate{'2000-01-24'}");
    	assertQueryFalse(null, "ecore::EDate{'2000-01-24'} <> ecore::EDate{'2000-01-24'}");
    	assertQueryTrue(null, "ecore::EDate{'2000-01-23'} <> ecore::EDate{'2000-01-24'}");
        //
	    // invalid
        //
        assertQueryInvalid(null, "invalid <> 3");
		assertQueryInvalid(null, "3 <> invalid");
		assertQueryInvalid(null, "invalid <> 3.0");
		assertQueryInvalid(null, "3.0 <> invalid");

		assertQueryInvalid(null, "invalid <> 'test'");
		assertQueryInvalid(null, "'test' <> invalid");
		assertQueryInvalid(null, "invalid <> true");
		assertQueryInvalid(null, "false <> invalid");
		assertQueryInvalid(null, "invalid <> Sequence{}");
		assertQueryInvalid(null, "Sequence{} <> invalid");

		assertQueryInvalid(null, "invalid <> invalid");
		//
		// null
		//
		assertQueryTrue(null, "null <> 3");
		assertQueryTrue(null, "3 <> null");
		assertQueryTrue(null, "null <> 3.0");
		assertQueryTrue(null, "3.0 <> null");

		assertQueryTrue(null, "null <> 'test'");
		assertQueryTrue(null, "'test' <> null");
		assertQueryTrue(null, "null <> true");
		assertQueryTrue(null, "false <> null");
		assertQueryTrue(null, "null <> Sequence{}");
		assertQueryTrue(null, "Sequence{} <> null");

		assertQueryFalse(null, "null <> null");
	}
	
    /**
     * Tests the explicit oclAsSet() operator.
     */
	@Test public void test_oclAsSet_explicit() {
		assertQueryResults(null, "Set{true}", "true.oclAsSet()");
		assertQueryResults(null, "Set{}", "null.oclAsSet()");
		assertQueryInvalid(null, "invalid.oclAsSet()");
		assertQueryResults(null, "Set{Set{1..4}}", "Set{1..4}->oclAsSet()");
	}
	
    /**
     * Tests the implicit oclAsSet() operator.
     */
	@Test public void test_oclAsSet_implicit() {
    	StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
		assertQueryResults(null, "Set{true}", "true->select(true)");
		assertQueryResults(null, "Set{true}", "Set{true}->select(true)");
		assertQueryResults(null, "Set{}", "null->select(true)");
		assertQueryResults(null, "Set{}", "Set{}->select(true)");
		assertQueryResults(null, "Set{null}", "Set{null}->select(true)");
		assertQueryInvalid(null, "invalid->select(true)");
		//
		assertQueryResults(null, "false", "true.oclIsUndefined()");
		assertQueryResults(null, "false", "true->oclIsUndefined()");	// Set{true}
		assertQueryResults(null, "true", "null.oclIsUndefined()");
		assertQueryResults(null, "false", "null->oclIsUndefined()");	// Set{}
		assertQueryResults(null, "true", "invalid.oclIsUndefined()");
		assertQueryResults(null, "true", "invalid->oclIsUndefined()");	// invalid
		//
		assertQueryEquals(null, 4, "'1234'.size()");
		assertQueryEquals(null, 1, "'1234'->size()");
		//
		PrimitiveType booleanType = standardLibrary.getBooleanType();
		assertQueryEquals(null, booleanType, "true.oclType()");
		Type collectionType = getCollectionType("Set", booleanType);
		assertQueryEquals(null, collectionType, "true->oclType()");		// Set{true}
	}
	
    /**
     * Tests the oclAsType() operator.
     */
	@Test public void test_oclAsType() {
		assertQueryInvalid(null, "invalid.oclAsType(String)");
		assertQueryInvalid(null, "invalid.oclAsType(Integer)");
		assertQueryInvalid(null, "invalid.oclAsType(Class)");
		assertQueryInvalid(null, "invalid.oclAsType(OclVoid)");
		assertQueryInvalid(null, "invalid.oclAsType(OclInvalid)");
		assertQueryInvalid(null, "invalid.oclAsType(Set(String))");
		assertQueryInvalid(null, "invalid.oclAsType(Tuple(a:String))");
		assertQueryInvalid(null, "invalid.oclAsType(ocl::Package)");
		//
		assertQueryNull(null, "let s : String = null.oclAsType(String) in s");
		assertQueryNull(null, "null.oclAsType(Integer)");
		assertQueryNull(null, "null.oclAsType(Class)");
		assertQueryNull(null, "null.oclAsType(OclVoid)");
		assertQueryInvalid(null, "null.oclAsType(OclInvalid)");
		assertQueryNull(null, "null.oclAsType(Set(String))");
		assertQueryNull(null, "null.oclAsType(Tuple(a:String))");
		assertQueryNull(null, "null.oclAsType(ocl::Package)");
		//
		assertQueryInvalid(null, "true.oclAsType(Integer)");
		assertQueryInvalid(null, "true.oclAsType(String)");
		assertQueryTrue(null, "true.oclAsType(Boolean)");
		assertQueryTrue(null, "true.oclAsType(OclAny)");
		assertQueryInvalid(null, "true.oclAsType(OclVoid)");
		assertQueryInvalid(null, "true.oclAsType(OclInvalid)");
		//
		assertQueryEquals(null, 3, "3.oclAsType(Integer)");
		assertQueryEquals(null, 3.0, "3.oclAsType(Real)");
		assertQueryInvalid(null, "3.0.oclAsType(Integer)");		// Cannot downcast
		assertQueryEquals(null, 3.0, "3.0.oclAsType(Real)");
		assertQueryInvalid(null, "3.oclAsType(String)");
		assertQueryEquals(null, 3, "3.oclAsType(OclAny)");
		assertQueryInvalid(null, "3.oclAsType(OclVoid)");
		assertQueryInvalid(null, "3.oclAsType(OclInvalid)");
		//
		assertQueryInvalid(null, "3.14.oclAsType(Integer)");
		assertQueryEquals(null, 3.14, "3.14.oclAsType(Real)");
		assertQueryInvalid(null, "3.14.oclAsType(String)");
		assertQueryEquals(null, 3.14, "3.14.oclAsType(OclAny)");
		assertQueryInvalid(null, "3.14.oclAsType(OclVoid)");
		assertQueryInvalid(null, "3.14.oclAsType(OclInvalid)");
		//
		assertQueryInvalid(null, "*.oclAsType(Integer)");
		assertQueryInvalid(null, "*.oclAsType(Real)");
		assertQueryUnlimited(null, "*.oclAsType(UnlimitedNatural)");
		assertQueryInvalid(null, "*.oclAsType(String)");
		assertQueryUnlimited(null, "*.oclAsType(OclAny)");
		assertQueryInvalid(null, "*.oclAsType(OclVoid)");
		assertQueryInvalid(null, "*.oclAsType(OclInvalid)");
		//
		assertQueryInvalid(null, "Set{1,2}->oclAsType(Set(UnlimitedNatural))");
		assertQueryResults(null, "Set{1,2}", "Set{1,2}->oclAsType(Set(Integer))");
		assertQueryResults(null, "Set{1,2}", "Set{1,2}->oclAsType(Collection(Real))");
		assertQueryInvalid(null, "Set{1,2}->oclAsType(Collection(UnlimitedNatural))");
		assertQueryInvalid(null, "Set{1.0,2}->oclAsType(Collection(UnlimitedNatural))");
		assertQueryInvalid(null, "Set{1,2}->oclAsType(Sequence(UnlimitedNatural))");
		assertQueryInvalid(null, "Set{1,2}.oclAsType(Set(UnlimitedNatural))");		// Cannot cast non-collection (elements) to collection
		assertQueryResults(null, "Bag{1,2}", "Set{1,2}.oclAsType(Integer)");
		assertQueryInvalid(null, "Set{1,2}.oclAsType(Set(Integer))");				// Cannot cast non-collection (elements) to collection
		assertQueryResults(null, "Bag{1,2}", "Set{1,2}.oclAsType(Integer)");
		assertQueryResults(null, "Set{Set{1,2},Set{3,4}}", "Set{Set{1,2},Set{3,4}}->oclAsType(Set(Set(Integer)))");
		assertQueryResults(null, "Set{Set{1,2},Set{3,4}}", "Set{Set{1,2},Set{3,4}}->oclAsType(Set(Collection(Integer)))");
		assertQueryResults(null, "Set{Set{1,2},Set{3,4}}", "Set{Set{1,2},Set{3,4}}->oclAsType(Collection(Set(Integer)))");
		assertQueryResults(null, "Set{Set{1,2},Set{3,4}}", "Set{Set{1,2},Set{3,4}}->oclAsType(Set(Set(Real)))");
		assertQueryInvalid(null, "Set{Set{1,2},Set{3,4}}->oclAsType(Set(Sequence(Integer)))");
		assertQueryInvalid(null, "Set{Set{1,2},Set{3,4}}->oclAsType(Sequence(Set(Integer)))");
		//
		assertSemanticErrorQuery("3.oclAsType(OclAny).abs()", OCLMessages.UnresolvedOperation_ERROR_, "OclAny", "abs");
		assertSemanticErrorQuery("let v : OclAny = 3 in v.abs()", OCLMessages.UnresolvedOperation_ERROR_, "OclAny", "abs");
		assertQueryEquals(null, 3, "let v : OclAny = 3 in v.oclAsType(Integer).abs()");
		assertQueryInvalid(null, "Integer.oclAsType(Real)");
	}

    /**
     * Tests the oclIsInvalid() operator.
     */
    @Test public void test_oclIsInvalid() {
        assertQueryTrue(null, "invalid.oclIsInvalid()");
        assertQueryFalse(null, "null.oclIsInvalid()");
        assertQueryFalse(null, "true.oclIsInvalid()");
        assertQueryFalse(null, "false.oclIsInvalid()");
        assertQueryFalse(null, "3.14.oclIsInvalid()");
        assertQueryFalse(null, "1.oclIsInvalid()");
        assertQueryFalse(null, "*.oclIsInvalid()");
        assertQueryFalse(null, "'invalid'.oclIsInvalid()");
        assertQueryFalse(pkg1, "self.oclIsInvalid()");
		assertQueryTrue(null, "('123a'.toInteger()).oclIsInvalid()");	// Bug 342561 for old evaluator
		assertQueryTrue(null, "let a:Integer='123a'.toInteger() in a.oclIsInvalid()");	// Bug 342561 for old evaluator
    }

    /**
     * Tests the oclIsKindOf() operator.
     */
    @Test public void test_oclIsKindOf() {
		assertQueryInvalid(null, "invalid.oclIsKindOf(OclInvalid)");
        assertQueryInvalid(null, "invalid.oclIsKindOf(OclVoid)");
        assertQueryInvalid(null, "invalid.oclIsKindOf(OclAny)");
		assertQueryInvalid(null, "invalid.oclIsKindOf(String)");
		assertQueryInvalid(null, "invalid.oclIsKindOf(Integer)");
		assertQueryInvalid(null, "invalid.oclIsKindOf(Class)");
		assertQueryInvalid(null, "invalid.oclIsKindOf(Bag(Boolean))");
		assertQueryInvalid(null, "invalid.oclIsKindOf(Tuple(a:Integer))");
        assertQueryInvalid(null, "invalid.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "null.oclIsKindOf(OclInvalid)");
        assertQueryTrue(null, "null.oclIsKindOf(OclVoid)");
        assertQueryTrue(null, "null.oclIsKindOf(OclAny)");
		assertQueryTrue(null, "null.oclIsKindOf(String)");
		assertQueryTrue(null, "null.oclIsKindOf(Integer)");
		assertQueryTrue(null, "null.oclIsKindOf(Class)");
		assertQueryTrue(null, "null.oclIsKindOf(Bag(Boolean))");
		assertQueryTrue(null, "null.oclIsKindOf(Tuple(a:Integer))");
        assertQueryTrue(null, "null.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "true.oclIsKindOf(OclInvalid)");
        assertQueryFalse(null, "true.oclIsKindOf(OclVoid)");
        assertQueryTrue(null, "true.oclIsKindOf(Boolean)");
        assertQueryFalse(null, "true.oclIsKindOf(Integer)");
        assertQueryFalse(null, "true.oclIsKindOf(String)");
        assertQueryTrue(null, "true.oclIsKindOf(OclAny)");
        assertQueryFalse(null, "true.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "3.14.oclIsKindOf(OclInvalid)");
        assertQueryFalse(null, "3.14.oclIsKindOf(OclVoid)");
        assertQueryFalse(null, "3.14.oclIsKindOf(Boolean)");
        assertQueryTrue(null, "3.14.oclIsKindOf(Real)");
        assertQueryFalse(null, "3.14.oclIsKindOf(Integer)");
        assertQueryFalse(null, "3.14.oclIsKindOf(String)");
        assertQueryTrue(null, "3.14.oclIsKindOf(OclAny)");
        assertQueryFalse(null, "3.14.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "1.oclIsKindOf(OclInvalid)");
        assertQueryFalse(null, "1.oclIsKindOf(OclVoid)");
        assertQueryFalse(null, "1.oclIsKindOf(Boolean)");
        assertQueryTrue(null, "1.oclIsKindOf(Real)");
        assertQueryTrue(null, "1.oclIsKindOf(Integer)");
        assertQueryTrue(null, "(-1).oclIsKindOf(Integer)");
        assertQueryTrue(null, "1.oclIsKindOf(Integer)");
        assertQueryFalse(null, "1.oclIsKindOf(String)");
        assertQueryTrue(null, "1.oclIsKindOf(OclAny)");
        assertQueryFalse(null, "1.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "*.oclIsKindOf(OclInvalid)");
        assertQueryFalse(null, "*.oclIsKindOf(OclVoid)");
        assertQueryFalse(null, "*.oclIsKindOf(Boolean)");
        assertQueryFalse(null, "*.oclIsKindOf(Real)");
        assertQueryFalse(null, "*.oclIsKindOf(Integer)");
        assertQueryTrue(null, "*.oclIsKindOf(UnlimitedNatural)");
        assertQueryFalse(null, "*.oclIsKindOf(String)");
        assertQueryTrue(null, "*.oclIsKindOf(OclAny)");
        assertQueryFalse(null, "*.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(null, "'invalid'.oclIsKindOf(OclInvalid)");
        assertQueryFalse(null, "'null'.oclIsKindOf(OclVoid)");
        assertQueryFalse(null, "'true'.oclIsKindOf(Boolean)");
        assertQueryFalse(null, "'3.14'.oclIsKindOf(Real)");
        assertQueryFalse(null, "'1'.oclIsKindOf(Integer)");
        assertQueryFalse(null, "'*'.oclIsKindOf(UnlimitedNatural)");
        assertQueryTrue(null, "'string'.oclIsKindOf(String)");
        assertQueryTrue(null, "'any'.oclIsKindOf(OclAny)");
        assertQueryFalse(pkg1, "'self'.oclIsKindOf(ocl::Package)");
        //
        assertQueryFalse(pkg1, "self.oclIsKindOf(OclInvalid)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(OclVoid)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(Boolean)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(Real)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(Integer)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(UnlimitedNatural)");
        assertQueryFalse(pkg1, "self.oclIsKindOf(String)");
        assertQueryTrue(pkg1, "self.oclIsKindOf(OclAny)");
        assertQueryTrue(pkg1, "self.oclIsKindOf(ocl::Package)");
    }

	/**
     * Tests the oclIsTypeOf() operator.
     */
    @Test public void test_oclIsTypeOf() {
        assertQueryInvalid(null, "invalid.oclIsTypeOf(OclInvalid)");
        assertQueryInvalid(null, "invalid.oclIsTypeOf(OclVoid)");
        assertQueryInvalid(null, "invalid.oclIsTypeOf(OclAny)");
		assertQueryInvalid(null, "invalid.oclIsTypeOf(Integer)");
		assertQueryInvalid(null, "invalid.oclIsTypeOf(String)");
		assertQueryInvalid(null, "invalid.oclIsTypeOf(Class)");
		assertQueryInvalid(null, "invalid.oclIsTypeOf(Set(String))");
        assertQueryInvalid(null, "invalid.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "null.oclIsTypeOf(OclInvalid)");
        assertQueryTrue(null, "null.oclIsTypeOf(OclVoid)");
        assertQueryFalse(null, "null.oclIsTypeOf(OclAny)");
		assertQueryFalse(null, "null.oclIsTypeOf(Integer)");
		assertQueryFalse(null, "null.oclIsTypeOf(String)");
		assertQueryFalse(null, "null.oclIsTypeOf(Class)");
		assertQueryFalse(null, "null.oclIsTypeOf(Set(String))");
        assertQueryFalse(null, "null.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "true.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(null, "true.oclIsTypeOf(OclVoid)");
        assertQueryTrue(null, "true.oclIsTypeOf(Boolean)");
        assertQueryFalse(null, "true.oclIsTypeOf(String)");
        assertQueryFalse(null, "true.oclIsTypeOf(OclAny)");
        assertQueryFalse(null, "true.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "3.14.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(OclVoid)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(Boolean)");
        assertQueryTrue(null, "3.14.oclIsTypeOf(Real)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(Integer)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(String)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(OclAny)");
        assertQueryFalse(null, "3.14.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "1.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(null, "1.oclIsTypeOf(OclVoid)");
        assertQueryFalse(null, "1.oclIsTypeOf(Boolean)");
        assertQueryFalse(null, "1.oclIsTypeOf(Real)");
        assertQueryTrue(null, "1.oclIsTypeOf(Integer)");
        assertQueryTrue(null, "(-1).oclIsTypeOf(Integer)");
        assertQueryFalse(null, "1.oclIsTypeOf(UnlimitedNatural)");
        assertQueryFalse(null, "1.oclIsTypeOf(String)");
        assertQueryFalse(null, "1.oclIsTypeOf(OclAny)");
        assertQueryFalse(null, "1.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "*.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(null, "*.oclIsTypeOf(OclVoid)");
        assertQueryFalse(null, "*.oclIsTypeOf(Boolean)");
        assertQueryFalse(null, "*.oclIsTypeOf(Real)");
        assertQueryFalse(null, "*.oclIsTypeOf(Integer)");
        assertQueryTrue(null, "*.oclIsTypeOf(UnlimitedNatural)");
        assertQueryFalse(null, "*.oclIsTypeOf(String)");
        assertQueryFalse(null, "*.oclIsTypeOf(OclAny)");
        assertQueryFalse(null, "*.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(null, "'invalid'.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(null, "'null'.oclIsTypeOf(OclVoid)");
        assertQueryFalse(null, "'true'.oclIsTypeOf(Boolean)");
        assertQueryFalse(null, "'3.14'.oclIsTypeOf(Real)");
        assertQueryFalse(null, "'1'.oclIsTypeOf(Integer)");
        assertQueryFalse(null, "'*'.oclIsTypeOf(UnlimitedNatural)");
        assertQueryTrue(null, "'string'.oclIsTypeOf(String)");
        assertQueryFalse(null, "'any'.oclIsTypeOf(OclAny)");
        assertQueryFalse(pkg1, "'self'.oclIsTypeOf(ocl::Package)");
        //
        assertQueryFalse(pkg1, "self.oclIsTypeOf(OclInvalid)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(OclVoid)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(Boolean)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(Real)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(Integer)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(UnlimitedNatural)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(String)");
        assertQueryFalse(pkg1, "self.oclIsTypeOf(OclAny)");
        assertQueryTrue(pkg1, "self.oclIsTypeOf(ocl::Package)");
    }

    /**
     * Tests the oclIsUndefined() operator.
     */
    @Test public void test_oclIsUndefined() {
        assertQueryTrue(null, "invalid.oclIsUndefined()");
        assertQueryTrue(null, "null.oclIsUndefined()");
        assertQueryFalse(null, "true.oclIsUndefined()");
        assertQueryFalse(null, "false.oclIsUndefined()");
        assertQueryFalse(null, "3.14.oclIsUndefined()");
        assertQueryFalse(null, "1.oclIsUndefined()");
        assertQueryFalse(null, "*.oclIsUndefined()");
        assertQueryFalse(null, "'null'.oclIsUndefined()");
        assertQueryFalse(pkg1, "self.oclIsUndefined()");
    }

    /**
     * Tests the oclType() operator for Booleans.
     */
    @Test public void test_oclType_Boolean() {
    	StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
    	PrimitiveType booleanType = standardLibrary.getBooleanType();
    	org.eclipse.ocl.pivot.Class classType = standardLibrary.getClassType();
    	assertQueryEquals(null, booleanType, "true.oclType()");
    	assertQueryEquals(null, "Boolean", "true.oclType().name");
		assertQueryEquals(null, booleanType, "Boolean");
    	assertQueryEquals(null, "Boolean", "Boolean.name");
    	assertQueryEquals(null, classType, "true.oclType().oclType()");
    	assertQueryEquals(null, "Class", "true.oclType().oclType().name");
    	assertQueryEquals(null, classType, "Boolean.oclType()");
    	assertQueryEquals(null, "Class", "Boolean.oclType().name");
    	assertQueryEquals(null, classType, "true.oclType().oclType().oclType()");
    	assertQueryEquals(null, "Class", "true.oclType().oclType().oclType().name");
    	assertQueryResults(null, "Set{false,true}", "Boolean.allInstances()");
    	assertQueryResults(null, "Set{false,true}", "true.oclType().allInstances()");
    	assertQueryResults(null, "Set{}", "Boolean.oclType().allInstances()");
    	assertQueryEquals(null, 1, "true.oclType().ownedOperations->select(name = 'xor')->any(true).ownedParameters->size()");
    }

    /**
     * Tests the oclType() operator for Classifiers.
     */
    @Test public void test_oclType_Classifier() {
    	StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
    	@SuppressWarnings("null") @NonNull Type packageType = metaModelManager.getPivotType("Package");
       	assertQueryEquals(pkg1, packageType, "self.oclType()");
    	assertQueryEquals(pkg1, "Package", "self.oclType().name");
		assertQueryEquals(null, packageType, "Package");
    	assertQueryEquals(null, "Package", "Package.name");
    	assertQueryEquals(null, standardLibrary.getClassType(), "Package.oclType()");
    	assertQueryResults(null, "Set{}", "Package.allInstances()");
    	assertQueryEquals(pkg1, 8, "Package.allInstances()->size()");
       	assertQueryResults(pkg1, "self.oclAsType(Package)->closure(ownedPackages)->including(self)", "Package.allInstances()");
       	assertQueryEquals(pkg1, 8, "self.oclType().allInstances()->size()");
       	assertQueryEquals(pkg1, 0, "Package.oclType().allInstances()->size()");
    }

    /**
     * Tests the oclType() operator for Collections.
     */
    @Test public void test_oclType_Collection() {   	
    	CompleteEnvironment completeEnvironment = metaModelManager.getCompleteEnvironment();
    	StandardLibrary standardLibrary = completeEnvironment.getOwnedStandardLibrary();
    	assertQueryEquals(null, 1, "Set{1}->oclType().ownedOperations->select(name = 'flatten')->size()");
    	assertQueryEquals(null, completeEnvironment.getSetType(standardLibrary.getOclVoidType(), null, null), "Set{}->oclType()");
    	assertQueryEquals(null, completeEnvironment.getSetType(standardLibrary.getIntegerType(), null, null), "Set{1}->oclType()");
    	assertQueryResults(null, "Bag{'Integer'}", "Set{1}.oclType().name");
    	assertQueryEquals(null, "Set", "Set{1}->oclType().name");
    	assertSemanticErrorQuery("Set{1}.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "Set(Integer)", "allInstances");
    	assertSemanticErrorQuery("Set{1}->allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "Set(Integer)", "allInstances");
    	assertSemanticErrorQuery("Set{1}.oclType().allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "Bag(Class)", "allInstances");
    	assertSemanticErrorQuery("Set{1}->oclType().allInstances()", OCLMessages.UnresolvedStaticOperationCall_ERROR_, "Set(Integer)", "allInstances", "");
    	assertQueryResults(null, "Set{}", "Set.oclType().allInstances()");
    	assertQueryEquals(null, standardLibrary.getIntegerType(), "Set{1}->oclType().elementType");
    }

    /**
     * Tests the oclType() operator for Enumerations.
     */
    @Test public void test_oclType_Enumeration() {
    	StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
    	@SuppressWarnings("null") @NonNull Type collectionKindType = metaModelManager.getPivotType("CollectionKind");
//    	assertQueryEquals(null, metaModelManager.getPivotType("EnumerationLiteral"), "CollectionKind::Set.oclType()");
    	// NB this is not EnumerationLiteral: cf. 4.oclType() is Integer not IntegerLiteral.
    	assertQueryEquals(null, metaModelManager.getPivotType("CollectionKind"), "CollectionKind::Set.oclType()");
    	assertQueryEquals(null, "CollectionKind", "CollectionKind::Set.oclType().name");
    	assertQueryEquals(null, collectionKindType, "CollectionKind");
    	assertQueryEquals(null, "CollectionKind", "CollectionKind.name");
    	assertQueryEquals(null, standardLibrary.getClassType(), "CollectionKind.oclType()");
    	assertQueryEquals(null, 5, "CollectionKind.allLiterals->size()");
    	assertSemanticErrorQuery("CollectionKind.oclType().ownedLiteral", OCLMessages.UnresolvedStaticProperty_ERROR_, "Class", "ownedLiteral");
    	assertQueryResults(null, "Set{CollectionKind::Bag,CollectionKind::Collection,CollectionKind::_'OrderedSet',CollectionKind::_'Sequence',CollectionKind::_'Set'}", "CollectionKind.allInstances()");
    	assertQueryResults(null, "Set{CollectionKind::Bag,CollectionKind::Collection,CollectionKind::OrderedSet,CollectionKind::Sequence,CollectionKind::Set}", "CollectionKind::Set.oclType().allInstances()");
    	assertQueryResults(null, "Set{}", "CollectionKind.oclType().allInstances()");
    }

    /**
     * Tests the oclType() operator for Numerics.
     */
    @Test public void test_oclType_Numeric() {
    	StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
    	PrimitiveType integerType = standardLibrary.getIntegerType();
    	assertQueryEquals(null, standardLibrary.getIntegerType(), "3.oclType()");
    	assertQueryEquals(null, standardLibrary.getRealType(), "3.0.oclType()");
    	assertQueryEquals(null, standardLibrary.getUnlimitedNaturalType(), "*.oclType()");
		assertQueryEquals(null, standardLibrary.getClassType(), "Integer.oclType()");
    	assertQueryEquals(null, integerType, "Integer");
    	assertSemanticErrorQuery("Integer.allInstances()", OCLMessages.UnresolvedStaticOperationCall_ERROR_, "Integer", "allInstances", "");
    	assertSemanticErrorQuery("3.oclType().allInstances()", OCLMessages.UnresolvedStaticOperationCall_ERROR_, "Integer", "allInstances", "");
    	assertQueryResults(null, "Set{}", "Integer.oclType().allInstances()");
		assertQueryEquals(null, "Integer", "4.oclType().name");
     }

    /**
     * Tests the oclType() operator for OclAny.
     */
    @Test public void test_oclType_OclAny() {
    	StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
    	AnyType anyType = standardLibrary.getOclAnyType();
    	assertQueryEquals(null, standardLibrary.getOclVoidType(), "null.oclAsType(OclAny).oclType()");		// Cast does not change the dynamic type
//    	assertQueryEquals(null, "OclAny", "null.oclAsType(OclAny).name");
		assertQueryEquals(null, anyType, "OclAny");
    	assertQueryEquals(null, "OclAny", "OclAny.name");
    	assertQueryEquals(null, standardLibrary.getClassType(), "OclAny.oclType()");
    	assertSemanticErrorQuery("OclAny.allInstances()", OCLMessages.UnresolvedStaticOperationCall_ERROR_, "OclAny", "allInstances", "");
    	assertSemanticErrorQuery("null.oclAsType(OclAny).oclType().allInstances()", OCLMessages.UnresolvedStaticOperationCall_ERROR_, "OclAny", "allInstances", "");
    	assertQueryResults(null, "Set{}", "OclAny.oclType().allInstances()");
    }

    /**
     * Tests the oclType() operator for OclInvalid.
     */
    @Test public void test_oclType_OclInvalid() {
    	StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
       	InvalidType invalidType = standardLibrary.getOclInvalidType();
    	assertQueryInvalid(null, "invalid.oclType()");
    	assertQueryInvalid(null, "invalid.oclType().name");
		assertQueryEquals(null, invalidType, "OclInvalid");
    	assertQueryEquals(null, "OclInvalid", "OclInvalid.name");
    	assertQueryEquals(null, standardLibrary.getClassType(), "OclInvalid.oclType()");
    	assertQueryInvalid(null, "OclInvalid.allInstances()");
    	assertQueryInvalid(null, "invalid.oclType().allInstances()");
    	assertQueryResults(null, "Set{}", "OclInvalid.oclType().allInstances()");
    	assertQueryInvalid(null, "invalid.oclType().ownedOperations->select(name = '=')->any(true).ownedParameters->size()");
    }

    /**
     * Tests the oclType() operator for OclVoid.
     */
    @Test public void test_oclType_OclVoid() {
    	StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
    	VoidType nullType = standardLibrary.getOclVoidType();
    	assertQueryEquals(null, nullType, "null.oclType()");
    	assertQueryEquals(null, "OclVoid", "null.oclType().name");
		assertQueryEquals(null, nullType, "OclVoid");
    	assertQueryEquals(null, "OclVoid", "OclVoid.name");
    	assertQueryEquals(null, standardLibrary.getClassType(), "OclVoid.oclType()");
    	assertQueryResults(null, "Set{null}", "OclVoid.allInstances()");
    	assertQueryResults(null, "Set{null}", "null.oclType().allInstances()");
    	assertQueryResults(null, "Set{}", "OclVoid.oclType().allInstances()");
    	assertQueryEquals(null, 1, "null.oclType().ownedOperations->select(name = '=')->any(true).ownedParameters->size()");
    }

    /**
     * Tests the oclType() operator for Tuples.
     */
    @Test public void test_oclType_Tuple() {
    	StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
    	TuplePartId partId = IdManager.getTuplePartId(0, "a", TypeId.INTEGER);
    	TupleTypeId tupleId = IdManager.getTupleTypeId("Tuple", partId);
    	TupleType tupleType = metaModelManager.getIdResolver().getTupleType(tupleId);
//    	Metaclass<?> tupleMetaclass = getMetaclass(tupleType);
		assertQueryEquals(null, tupleType, "Tuple{a:Integer=3}.oclType()");
    	assertQueryEquals(null, tupleType, "Tuple(a:Integer)");
		assertQueryEquals(null, standardLibrary.getClassType(), "Tuple(a:Integer).oclType()");
    	assertSemanticErrorQuery("Tuple(a:Integer).allInstances()", OCLMessages.UnresolvedStaticOperationCall_ERROR_, "Tuple(a:Integer)", "allInstances", "");
    	assertSemanticErrorQuery("Tuple{a:Integer=3}.oclType().allInstances()", OCLMessages.UnresolvedStaticOperationCall_ERROR_, "Tuple(a:Integer)", "allInstances", "");	// FIXME
    	assertQueryResults(null, "Set{}", "Tuple(a:Integer).oclType().allInstances()");
		assertQueryEquals(null, "Tuple", "Tuple{a:Integer=3}.oclType().name");
     }

    /**
     * Tests the oclType() operator.
     */
    @Test public void test_oclType() {
    	StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
		assertQueryEquals(null, standardLibrary.getStringType(), "'string'.oclType()");
		assertQueryEquals(null, standardLibrary.getOclVoidType(), "self.oclType()");
    	assertQueryEquals(null, standardLibrary.getClassType(), "3.oclType().oclType()");
    	assertQueryEquals(null, standardLibrary.getClassType(), "3.oclType().oclType().oclType()");
    	assertQueryEquals(null, standardLibrary.getClassType(), "Boolean.oclType()");
    	assertQueryEquals(null, "Class", "Boolean.oclType().name");
    	assertSemanticErrorQuery("3.oclType(OclAny)", OCLMessages.UnresolvedOperationCall_ERROR_, "Integer", "oclType", "OclAny");
    }

//	@Test public void testMetaclassInstanceType() {
//		assertQueryEquals(null, metaModelManager.getSequenceType(metaModelManager.getIntegerType()), "Sequence(Integer).oclType().instanceType");
//	}
    
    @Test public void testToString() {
    	loadEPackage("ecore", EcorePackage.eINSTANCE);
    	@SuppressWarnings("null") @NonNull String emfString = EcoreFactory.eINSTANCE.createFromString(EcorePackage.Literals.EDATE, "2000-01-24").toString();
        assertQueryEquals(null, emfString, "ecore::EDate{'2000-01-24'}.toString()");
    }

	public @NonNull Type getCollectionType(@NonNull String collectionName, @NonNull Type type) {
		Type collectionType = metaModelManager.getCollectionType(collectionName, type, null, null);
		metaModelManager.addLockedElement(collectionType);
		return collectionType;
	}
}
