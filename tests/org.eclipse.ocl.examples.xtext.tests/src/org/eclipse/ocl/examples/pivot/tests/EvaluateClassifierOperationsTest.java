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
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class EvaluateClassifierOperationsTest extends PivotTestSuite
{
	public static class MyOCL extends TestOCL
	{
        // need a metamodel that has a reflexive EReference.
        // Ecore will do nicely. Create the following structure:
        // pkg1
        // pkg1::pkg2
        // pkg1::pkg2::jim
        // pkg1::bob
        // pkg1::pkg3
        // pkg1::pkg3::pkg4
        // pkg1::pkg3::pkg5
        // pkg1::pkg3::pkg5::george
        @NonNull Model root = createModel();
        @NonNull org.eclipse.ocl.pivot.Package pkg1 = createPackage(root, "pkg1");
        @NonNull org.eclipse.ocl.pivot.Package pkg2 = createPackage(pkg1, "pkg2");
        @NonNull org.eclipse.ocl.pivot.Package jim = createPackage(pkg2, "jim");
        @NonNull org.eclipse.ocl.pivot.Package bob = createPackage(pkg1, "bob");
        @NonNull org.eclipse.ocl.pivot.Package pkg3 = createPackage(pkg1, "pkg3");
        @NonNull org.eclipse.ocl.pivot.Package pkg4 = createPackage(pkg3, "pkg4");
        @NonNull org.eclipse.ocl.pivot.Package pkg5 = createPackage(pkg3, "pkg5");
        @NonNull org.eclipse.ocl.pivot.Package george = createPackage(pkg5, "george");
		
		public MyOCL(@NonNull String testPackageName, @NonNull String name) {
			super(testPackageName, name);
			MetamodelManager metamodelManager = getMetamodelManager();
//			metamodelManager.addGlobalNamespace(PivotConstants.OCL_NAME, ClassUtil.nonNullState(metamodelManager.getASmetamodel()));

	        metamodelManager.installRoot(ClassUtil.nonNullState(root));
//	        helper.setContext(ClassUtil.nonNullState(metamodelManager.getPivotType("Package")));
		}
	}

	public EvaluateClassifierOperationsTest() {
		super(false);
	}

	@Override
	protected @NonNull MyOCL createOCL() {
		return new MyOCL(getTestPackageName(), getName());
	}

	@Override
    protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
        super.setUp();
    }

	/**
	 * Tests the allInstances() operator.
	 */
	public void test_allInstances() {
		MyOCL ocl = createOCL();
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		try {
			org.eclipse.ocl.pivot.Class classType = metamodelManager.getStandardLibrary().getClassType();
			ocl.assertQueryResults(null, "Set{CollectionKind::Bag,CollectionKind::Collection,CollectionKind::_'OrderedSet',CollectionKind::_'Sequence',CollectionKind::_'Set'}", "CollectionKind.allInstances()");
			ocl.assertQueryResults(null, "Set{true,false}", "Boolean.allInstances()");
			ocl.assertQueryResults(null, "Set{null}", "OclVoid.allInstances()");
			ocl.assertQueryResults(null, "Set{}", "ocl::Package.allInstances()");
			ocl.assertQueryEquals(ocl.pkg1, 8, "Package.allInstances()->size()");
			ocl.assertSemanticErrorQuery(classType, "Integer.allInstances()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "Integer", "allInstances", "");
			ocl.assertSemanticErrorQuery(classType, "String.allInstances()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "String", "allInstances", "");
			ocl.assertSemanticErrorQuery(classType, "Set(Integer).allInstances()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "Set(Integer)", "allInstances", "");
			ocl.assertSemanticErrorQuery(classType, "Tuple(a:Integer).allInstances()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "Tuple(a:Integer)", "allInstances", "");
			ocl.assertSemanticErrorQuery(classType, "OclAny.allInstances()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "OclAny", "allInstances", "");
			ocl.assertSemanticErrorQuery(classType, "4.allInstances()", PivotMessagesInternal.UnresolvedOperationCall_ERROR_, "Integer", "allInstances", "");
			ocl.assertSemanticErrorQuery(classType, "true.allInstances()", PivotMessagesInternal.UnresolvedOperationCall_ERROR_, "Boolean", "allInstances", "");
	//		ocl.assertQueryInvalid(null, "true.allInstances()");
	//		ocl.assertQueryResults(null, "Set{true,false}", "true.allInstances()");
			ocl.assertSemanticErrorQuery(classType, "Set{1}.allInstances()", PivotMessagesInternal.UnresolvedOperationCall_ERROR_, "Set(Integer)", "allInstances", "");
			ocl.assertSemanticErrorQuery(classType, "Tuple{a:Integer=1}.allInstances()", PivotMessagesInternal.UnresolvedOperationCall_ERROR_, "Tuple(a:Integer)", "allInstances", "");
			ocl.assertQueryInvalid(null, "OclInvalid.allInstances()");
		} finally {
			ocl.dispose();
		}
	}
	
	/**
	 * Tests the conformsTo() operator.
	 */
	public void test_conformsTo() {
		MyOCL ocl = createOCL();
		try {
	//		ocl.assertQueryTrue(null, "true.conformsTo(Boolean)");
			ocl.assertQueryTrue(null, "Boolean.conformsTo(Boolean)");
			ocl.assertQueryFalse(null, "String.conformsTo(Boolean)");
			ocl.assertQueryFalse(null, "Boolean.conformsTo(String)");
			ocl.assertQueryTrue(null, "Integer.conformsTo(Real)");
			ocl.assertQueryFalse(null, "UnlimitedNatural.conformsTo(Integer)");
			ocl.assertQueryFalse(null, "UnlimitedNatural.conformsTo(Real)");
			ocl.assertQueryFalse(null, "Real.conformsTo(Integer)");
			ocl.assertQueryFalse(null, "Real.conformsTo(UnlimitedNatural)");
			ocl.assertQueryFalse(null, "Integer.conformsTo(UnlimitedNatural)");
			//FIXME much more
		} finally {
			ocl.dispose();
		}
	}
	
	/**
	 * Tests the oclContainer() operator.
	 */
	public void test_oclContainer() {
		MyOCL ocl = createOCL();
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		try {
			org.eclipse.ocl.pivot.Class classType = metamodelManager.getStandardLibrary().getClassType();
			ocl.assertSemanticErrorQuery(classType, "invalid.oclContainer()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "OclInvalid", "oclContainer");
			ocl.assertQueryInvalid(ocl.pkg2, "let s : OclElement = invalid in s.oclContainer()");
			ocl.assertSemanticErrorQuery(classType, "null.oclContainer()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "OclVoid", "oclContainer");
			ocl.assertQueryInvalid(ocl.pkg2, "let s : OclElement = null in s.oclContainer()");
			ocl.assertQueryResults(ocl.root, "null", "oclContainer()");
			ocl.assertQueryEquals(ocl.pkg2, ocl.pkg1, "oclContainer()");
			ocl.assertSemanticErrorQuery(classType, "1.oclContainer()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Integer", "oclContainer");
		} finally {
			ocl.dispose();
		}
	}
	
	/**
	 * Tests the oclContents() operator.
	 */
	public void test_oclContents() {
		MyOCL ocl = createOCL();
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		try {
			IdResolver idResolver = metamodelManager.getEnvironmentFactory().getIdResolver();
			org.eclipse.ocl.pivot.Class classType = metamodelManager.getStandardLibrary().getClassType();
	    	@SuppressWarnings("null") @NonNull Type packageType = metamodelManager.getPivotType("Package");
			CollectionTypeId typeId = TypeId.SET.getSpecializedId(packageType.getTypeId());
			ocl.assertSemanticErrorQuery(classType, "invalid.oclContents()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "OclInvalid", "oclContents");
			ocl.assertQueryInvalid(ocl.pkg2, "let s : OclElement = invalid in s.oclContents()");
			ocl.assertSemanticErrorQuery(classType, "null.oclContents()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "OclVoid", "oclContents");
			ocl.assertQueryInvalid(ocl.pkg2, "let s : OclElement = null in s.oclContents()");
			ocl.assertQueryEquals(ocl.pkg1, idResolver.createSetOfEach(typeId, ocl.bob, ocl.pkg2, ocl.pkg3), "oclContents()");
			ocl.assertQueryEquals(ocl.pkg2, idResolver.createSetOfEach(typeId, ocl.jim), "oclContents()");
			ocl.assertQueryEquals(ocl.george, idResolver.createSetOfEach(typeId), "oclContents()");
			ocl.assertSemanticErrorQuery(classType, "1.oclContents()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Integer", "oclContents");
		} finally {
			ocl.dispose();
		}
	}
}
