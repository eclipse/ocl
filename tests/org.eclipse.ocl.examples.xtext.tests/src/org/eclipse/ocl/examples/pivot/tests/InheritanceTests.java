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

import java.util.Iterator;

import org.eclipse.ocl.examples.domain.elements.DomainFragment;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PivotStandardLibrary;
import org.eclipse.ocl.examples.pivot.manager.PivotStandardLibrary2;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class InheritanceTests extends PivotSimpleTestSuite
{
	public InheritanceTests() {
		super(false);
	}

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        helper.setContext(metaModelManager.getStandardLibrary().getClassType());
    }

	public void test_Inheritance_Boolean() {
		MetaModelManager metaModelManager = new MetaModelManager();
		PivotStandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
		try {
			DomainInheritance oclAnyInheritance = standardLibrary.getInheritance(standardLibrary.getOclAnyType());
			PrimitiveType booleanType = standardLibrary.getBooleanType();
			DomainInheritance booleanInheritance = standardLibrary.getInheritance(booleanType);
			assert booleanInheritance.getDepth() == 1;
			Iterator<DomainFragment> allSuperInheritances = booleanInheritance.getAllSuperFragments().iterator();
			assert allSuperInheritances.next().getBaseInheritance() == oclAnyInheritance;
			assert allSuperInheritances.next().getBaseInheritance() == booleanInheritance;
			assert !allSuperInheritances.hasNext();
			Iterator<DomainFragment> depth0Inheritances = booleanInheritance.getSuperFragments(0).iterator();
			assert depth0Inheritances.next().getBaseInheritance() == oclAnyInheritance;
			assert !depth0Inheritances.hasNext();
			Iterator<DomainFragment> depth1Inheritances = booleanInheritance.getSuperFragments(1).iterator();
			assert depth1Inheritances.next().getBaseInheritance() == booleanInheritance;
			assert !depth1Inheritances.hasNext();
		} finally {
			metaModelManager.dispose();
		}
	}

	public void test_Inheritance_OclAny() {
		MetaModelManager metaModelManager = new MetaModelManager();
		PivotStandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
		try {
			AnyType oclAnyType = standardLibrary.getOclAnyType();
			DomainInheritance oclAnyInheritance = standardLibrary.getInheritance(oclAnyType);
			assert oclAnyInheritance.getDepth() == 0;
			Iterator<DomainFragment> allSuperInheritances = oclAnyInheritance.getAllSuperFragments().iterator();
			assert allSuperInheritances.next().getBaseInheritance() == oclAnyInheritance;
			assert !allSuperInheritances.hasNext();
			Iterator<DomainFragment> depth0Inheritances = oclAnyInheritance.getSuperFragments(0).iterator();
			assert depth0Inheritances.next().getBaseInheritance() == oclAnyInheritance;
			assert !depth0Inheritances.hasNext();
		} finally {
			metaModelManager.dispose();
		}
	}

	public void test_Inheritance_Set() {
		MetaModelManager metaModelManager = new MetaModelManager();
		PivotStandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
		try {
			DomainInheritance oclAnyInheritance = standardLibrary.getInheritance(standardLibrary.getOclAnyType());
	//		InheritanceInheritance collectionInheritance = metaModelManager.getStandardLibrary().getInheritance(metaModelManager.getStandardLibrary().getCollectionType());
			SetType setType = standardLibrary.getSetType();
			DomainInheritance setInheritance = standardLibrary.getInheritance(setType);
			assert setInheritance.getDepth() == 3;
			Iterator<DomainFragment> allSuperInheritances = setInheritance.getAllSuperFragments().iterator();
			assert allSuperInheritances.next().getBaseInheritance() == oclAnyInheritance;
	//		assert allSuperInheritances.next().getBaseInheritance() == collectionInheritance;
			DomainInheritance next = allSuperInheritances.next().getBaseInheritance();
			while (allSuperInheritances.hasNext()) {
				next = allSuperInheritances.next().getBaseInheritance();
			}
			assert next == setInheritance;
			assert !allSuperInheritances.hasNext();
			Iterator<DomainFragment> depth0Inheritances = setInheritance.getSuperFragments(0).iterator();
			assert depth0Inheritances.next().getBaseInheritance() == oclAnyInheritance;
			assert !depth0Inheritances.hasNext();
	//		Iterator<InheritanceInheritance> depth1Inheritances = setInheritance.getSuperFragments(1).iterator();
	//		assert depth1Inheritances.next() == collectionInheritance;
	//		assert !depth1Inheritances.hasNext();
			Iterator<DomainFragment> depth3Inheritances = setInheritance.getSuperFragments(3).iterator();
			assert depth3Inheritances.next().getBaseInheritance() == setInheritance;
			assert !depth3Inheritances.hasNext();
		} finally {
			metaModelManager.dispose();
		}
	}

	public void test_Inheritance_IfExp() {
		MetaModelManager metaModelManager = new MetaModelManager();
		PivotStandardLibrary2 standardLibrary = metaModelManager.getStandardLibrary();
		try {
			DomainInheritance oclAnyInheritance = standardLibrary.getInheritance(standardLibrary.getOclAnyType());
			DomainInheritance ifInheritance = standardLibrary.getInheritance(DomainUtil.nonNullState(standardLibrary.getPivotType("IfExp")));
			Iterator<DomainFragment> allSuperInheritances = ifInheritance.getAllSuperFragments().iterator();
			assert allSuperInheritances.next().getBaseInheritance() == oclAnyInheritance;
			DomainInheritance next = allSuperInheritances.next().getBaseInheritance();
			while (allSuperInheritances.hasNext()) {
				next = allSuperInheritances.next().getBaseInheritance();
			}
			assert next == ifInheritance;
			assert !allSuperInheritances.hasNext();
			Iterator<DomainFragment> depth0Inheritances = ifInheritance.getSuperFragments(0).iterator();
			assert depth0Inheritances.next().getBaseInheritance() == oclAnyInheritance;
			assert !depth0Inheritances.hasNext();
			Iterator<DomainFragment> depthNInheritances = ifInheritance.getSuperFragments(ifInheritance.getDepth()).iterator();
			assert depthNInheritances.next().getBaseInheritance() == ifInheritance;
			assert !depthNInheritances.hasNext();
			assert oclAnyInheritance.isSuperInheritanceOf(ifInheritance);
			assert !ifInheritance.isSuperInheritanceOf(oclAnyInheritance);
			DomainInheritance oclExpressionInheritance = standardLibrary.getInheritance(DomainUtil.nonNullState(standardLibrary.getPivotType("OCLExpression")));
			assert oclExpressionInheritance.isSuperInheritanceOf(ifInheritance);
			assert !ifInheritance.isSuperInheritanceOf(oclExpressionInheritance);
			DomainInheritance loopExpInheritance = standardLibrary.getInheritance(DomainUtil.nonNullState(standardLibrary.getPivotType("LoopExp")));
			assert !ifInheritance.isSuperInheritanceOf(loopExpInheritance);
			assert !loopExpInheritance.isSuperInheritanceOf(ifInheritance);
		} finally {
			metaModelManager.dispose();
		}
	}

	public void test_Inheritance_UnlimitedNatural() {
		MetaModelManager metaModelManager = new MetaModelManager();
		PivotStandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
		try {
			DomainInheritance oclAnyInheritance = standardLibrary.getInheritance(standardLibrary.getOclAnyType());
			DomainInheritance realTypeInheritance = standardLibrary.getInheritance(standardLibrary.getRealType());
			DomainInheritance integerTypeInheritance = standardLibrary.getInheritance(standardLibrary.getIntegerType());
			DomainInheritance unlimitedNaturalTypeInheritance = standardLibrary.getInheritance(standardLibrary.getUnlimitedNaturalType());
			assertEquals(4, unlimitedNaturalTypeInheritance.getDepth());
			Iterator<DomainFragment> allSuperInheritances = unlimitedNaturalTypeInheritance.getAllSuperFragments().iterator();
			assertEquals(oclAnyInheritance, allSuperInheritances.next().getBaseInheritance());
			Iterator<DomainFragment> depth0Inheritances = unlimitedNaturalTypeInheritance.getSuperFragments(0).iterator();
			assertEquals(oclAnyInheritance, depth0Inheritances.next().getBaseInheritance());
			assert !depth0Inheritances.hasNext();
			Iterator<DomainFragment> depth2Inheritances = unlimitedNaturalTypeInheritance.getSuperFragments(2).iterator();
			assertEquals(realTypeInheritance, depth2Inheritances.next().getBaseInheritance());
			assert !depth2Inheritances.hasNext();
			Iterator<DomainFragment> depth3Inheritances = unlimitedNaturalTypeInheritance.getSuperFragments(3).iterator();
			assertEquals(integerTypeInheritance, depth3Inheritances.next().getBaseInheritance());
			assert !depth3Inheritances.hasNext();
			Iterator<DomainFragment> depth4Inheritances = unlimitedNaturalTypeInheritance.getSuperFragments(4).iterator();
			assertEquals(unlimitedNaturalTypeInheritance, depth4Inheritances.next().getBaseInheritance());
			assert !depth4Inheritances.hasNext();
		} finally {
			metaModelManager.dispose();
		}
	}

	/**
	 * Check that an inheritance loop is diagnosed. 
	 */
	public void test_Inheritance_Loop() {
		MetaModelManager metaModelManager = new MetaModelManager();
		PivotStandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
		try {
			DomainInheritance unlimitedNaturalTypeInheritance = standardLibrary.getInheritance(standardLibrary.getUnlimitedNaturalType());
			assertEquals(4, unlimitedNaturalTypeInheritance.getDepth());
			try {
				standardLibrary.getRealType().getSuperClasses().add(standardLibrary.getIntegerType());
				unlimitedNaturalTypeInheritance.getDepth();
				fail("Missing IllegalStateException");
			} catch (IllegalStateException e) {
				// FIXME validate body
			} finally {
				standardLibrary.getRealType().getSuperClasses().remove(standardLibrary.getIntegerType());
			}
		} finally {
			metaModelManager.dispose();
		}
	}

	/**
	 * Check that addition of a supertype invalidates cached inheritances. 
	 */
	public void test_Inheritance_Addition() {
		MetaModelManager metaModelManager = new MetaModelManager();
		PivotStandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
		try {
			DomainInheritance unlimitedNaturalTypeInheritance = standardLibrary.getInheritance(standardLibrary.getUnlimitedNaturalType());
			assertEquals(4, unlimitedNaturalTypeInheritance.getDepth());
			try {
				standardLibrary.getRealType().getSuperClasses().add(standardLibrary.getStringType());
				assertEquals(3, standardLibrary.getInheritance(standardLibrary.getRealType()).getDepth());
				assertEquals(5, unlimitedNaturalTypeInheritance.getDepth());
			} finally {
				standardLibrary.getRealType().getSuperClasses().remove(standardLibrary.getStringType());
			}
		} finally {
			metaModelManager.dispose();
		}
	}


	/**
	 * Check that removal of a supertype invalidates cached inheritances. 
	 */
	public void test_Inheritance_Removal() {
		MetaModelManager metaModelManager = new MetaModelManager();
		PivotStandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
		try {
			DomainInheritance unlimitedNaturalTypeInheritance = standardLibrary.getInheritance(standardLibrary.getUnlimitedNaturalType());
			assertEquals(4, unlimitedNaturalTypeInheritance.getDepth());
			try {
				standardLibrary.getIntegerType().getSuperClasses().remove(standardLibrary.getRealType());
				standardLibrary.getIntegerType().getSuperClasses().add(standardLibrary.getOclAnyType());
				assertEquals(2, unlimitedNaturalTypeInheritance.getDepth());
				assertEquals(1, standardLibrary.getInheritance(standardLibrary.getIntegerType()).getDepth());
				assertEquals(2, standardLibrary.getInheritance(standardLibrary.getRealType()).getDepth());
			} finally {
				standardLibrary.getIntegerType().getSuperClasses().add(standardLibrary.getRealType());
			}
		} finally {
			metaModelManager.dispose();
		}
	}
}
