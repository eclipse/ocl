/*******************************************************************************
 * Copyright (c) 2009,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388529
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class EvaluateClassifierOperationsTest extends PivotSimpleTestSuite
{
	public EvaluateClassifierOperationsTest() {
		super(false);
	}

	@Override
    protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
        super.setUp();
        helper.setContext(metaModelManager.getStandardLibrary().getClassType());
    }

	/**
	 * Tests the allInstances() operator.
	 */
	public void test_allInstances() {
		assertQueryResults(null, "Set{CollectionKind::Bag,CollectionKind::Collection,CollectionKind::_'OrderedSet',CollectionKind::_'Sequence',CollectionKind::_'Set'}", "CollectionKind.allInstances()");
		assertQueryResults(null, "Set{true,false}", "Boolean.allInstances()");
		assertQueryResults(null, "Set{null}", "OclVoid.allInstances()");
		assertQueryResults(null, "Set{}", "ocl::Package.allInstances()");
		assertQueryEquals(pkg1, 8, "Package.allInstances()->size()");
		assertSemanticErrorQuery("Integer.allInstances()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "Integer", "allInstances", "");
		assertSemanticErrorQuery("String.allInstances()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "String", "allInstances", "");
		assertSemanticErrorQuery("Set(Integer).allInstances()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "Set(Integer)", "allInstances", "");
		assertSemanticErrorQuery("Tuple(a:Integer).allInstances()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "Tuple(a:Integer)", "allInstances", "");
		assertSemanticErrorQuery("OclAny.allInstances()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "OclAny", "allInstances", "");
		assertSemanticErrorQuery("4.allInstances()", PivotMessagesInternal.UnresolvedOperationCall_ERROR_, "Integer", "allInstances", "");
		assertSemanticErrorQuery("true.allInstances()", PivotMessagesInternal.UnresolvedOperationCall_ERROR_, "Boolean", "allInstances", "");
//		assertQueryInvalid(null, "true.allInstances()");
//		assertQueryResults(null, "Set{true,false}", "true.allInstances()");
		assertSemanticErrorQuery("Set{1}.allInstances()", PivotMessagesInternal.UnresolvedOperationCall_ERROR_, "Set(Integer)", "allInstances", "");
		assertSemanticErrorQuery("Tuple{a:Integer=1}.allInstances()", PivotMessagesInternal.UnresolvedOperationCall_ERROR_, "Tuple(a:Integer)", "allInstances", "");
		assertQueryInvalid(null, "OclInvalid.allInstances()");
	}
	
	/**
	 * Tests the conformsTo() operator.
	 */
	public void test_conformsTo() {
//		assertQueryTrue(null, "true.conformsTo(Boolean)");
		assertQueryTrue(null, "Boolean.conformsTo(Boolean)");
		assertQueryFalse(null, "String.conformsTo(Boolean)");
		assertQueryFalse(null, "Boolean.conformsTo(String)");
		assertQueryTrue(null, "Integer.conformsTo(Real)");
		assertQueryFalse(null, "UnlimitedNatural.conformsTo(Integer)");
		assertQueryFalse(null, "UnlimitedNatural.conformsTo(Real)");
		assertQueryFalse(null, "Real.conformsTo(Integer)");
		assertQueryFalse(null, "Real.conformsTo(UnlimitedNatural)");
		assertQueryFalse(null, "Integer.conformsTo(UnlimitedNatural)");
		//FIXME much more
	}
	
	/**
	 * Tests the oclContainer() operator.
	 */
	public void test_oclContainer() {
		assertSemanticErrorQuery("invalid.oclContainer()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "OclInvalid", "oclContainer");
		assertQueryInvalid(pkg2, "let s : OclElement = invalid in s.oclContainer()");
		assertSemanticErrorQuery("null.oclContainer()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "OclVoid", "oclContainer");
		assertQueryInvalid(pkg2, "let s : OclElement = null in s.oclContainer()");
		assertQueryResults(root, "null", "oclContainer()");
		assertQueryEquals(pkg2, pkg1, "oclContainer()");
		assertSemanticErrorQuery("1.oclContainer()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Integer", "oclContainer");
	}
	
	/**
	 * Tests the oclContents() operator.
	 */
	public void test_oclContents() {
    	@SuppressWarnings("null") @NonNull Type packageType = metaModelManager.getPivotType("Package");
		CollectionTypeId typeId = TypeId.SET.getSpecializedId(packageType.getTypeId());
		assertSemanticErrorQuery("invalid.oclContents()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "OclInvalid", "oclContents");
		assertQueryInvalid(pkg2, "let s : OclElement = invalid in s.oclContents()");
		assertSemanticErrorQuery("null.oclContents()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "OclVoid", "oclContents");
		assertQueryInvalid(pkg2, "let s : OclElement = null in s.oclContents()");
		assertQueryEquals(pkg1, idResolver.createSetOfEach(typeId, bob, pkg2, pkg3), "oclContents()");
		assertQueryEquals(pkg2, idResolver.createSetOfEach(typeId, jim), "oclContents()");
		assertQueryEquals(george, idResolver.createSetOfEach(typeId), "oclContents()");
		assertSemanticErrorQuery("1.oclContents()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Integer", "oclContents");
	}
}
