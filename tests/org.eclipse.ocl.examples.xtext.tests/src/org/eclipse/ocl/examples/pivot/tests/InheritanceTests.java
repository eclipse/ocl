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
        helper.setContext(metaModelManager.getMetaclassType());
    }

	public void test_Inheritance_Boolean() {
		MetaModelManager metaModelManager = new MetaModelManager();
		try {
			DomainInheritance oclAnyInheritance = metaModelManager.getInheritance(metaModelManager.getOclAnyType());
			PrimitiveType booleanType = metaModelManager.getBooleanType();
			DomainInheritance booleanInheritance = metaModelManager.getInheritance(booleanType);
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
		try {
			AnyType oclAnyType = metaModelManager.getOclAnyType();
			DomainInheritance oclAnyInheritance = metaModelManager.getInheritance(oclAnyType);
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
		try {
			DomainInheritance oclAnyInheritance = metaModelManager.getInheritance(metaModelManager.getOclAnyType());
	//		InheritanceInheritance collectionInheritance = metaModelManager.getInheritance(metaModelManager.getCollectionType());
			SetType setType = metaModelManager.getSetType();
			DomainInheritance setInheritance = metaModelManager.getInheritance(setType);
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
		try {
			DomainInheritance oclAnyInheritance = metaModelManager.getInheritance(metaModelManager.getOclAnyType());
			DomainInheritance ifInheritance = metaModelManager.getInheritance(DomainUtil.nonNullState(metaModelManager.getPivotType("IfExp")));
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
			assert oclAnyInheritance.isSuperInheritanceOf(metaModelManager, ifInheritance);
			assert !ifInheritance.isSuperInheritanceOf(metaModelManager, oclAnyInheritance);
			DomainInheritance oclExpressionInheritance = metaModelManager.getInheritance(DomainUtil.nonNullState(metaModelManager.getPivotType("OCLExpression")));
			assert oclExpressionInheritance.isSuperInheritanceOf(metaModelManager, ifInheritance);
			assert !ifInheritance.isSuperInheritanceOf(metaModelManager, oclExpressionInheritance);
			DomainInheritance loopExpInheritance = metaModelManager.getInheritance(DomainUtil.nonNullState(metaModelManager.getPivotType("LoopExp")));
			assert !ifInheritance.isSuperInheritanceOf(metaModelManager, loopExpInheritance);
			assert !loopExpInheritance.isSuperInheritanceOf(metaModelManager, ifInheritance);
		} finally {
			metaModelManager.dispose();
		}
	}

	public void test_Inheritance_UnlimitedNatural() {
		MetaModelManager metaModelManager = new MetaModelManager();
		try {
			DomainInheritance oclAnyInheritance = metaModelManager.getInheritance(metaModelManager.getOclAnyType());
			DomainInheritance realTypeInheritance = metaModelManager.getInheritance(metaModelManager.getRealType());
			DomainInheritance integerTypeInheritance = metaModelManager.getInheritance(metaModelManager.getIntegerType());
			DomainInheritance unlimitedNaturalTypeInheritance = metaModelManager.getInheritance(metaModelManager.getUnlimitedNaturalType());
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
		try {
			DomainInheritance unlimitedNaturalTypeInheritance = metaModelManager.getInheritance(metaModelManager.getUnlimitedNaturalType());
			assertEquals(4, unlimitedNaturalTypeInheritance.getDepth());
			try {
				metaModelManager.getRealType().getSuperClass().add(metaModelManager.getIntegerType());
				unlimitedNaturalTypeInheritance.getDepth();
				fail("Missing IllegalStateException");
			} catch (IllegalStateException e) {
				// FIXME validate body
			} finally {
				metaModelManager.getRealType().getSuperClass().remove(metaModelManager.getIntegerType());
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
		try {
			DomainInheritance unlimitedNaturalTypeInheritance = metaModelManager.getInheritance(metaModelManager.getUnlimitedNaturalType());
			assertEquals(4, unlimitedNaturalTypeInheritance.getDepth());
			try {
				metaModelManager.getRealType().getSuperClass().add(metaModelManager.getStringType());
				assertEquals(3, metaModelManager.getInheritance(metaModelManager.getRealType()).getDepth());
				assertEquals(5, unlimitedNaturalTypeInheritance.getDepth());
			} finally {
				metaModelManager.getRealType().getSuperClass().remove(metaModelManager.getStringType());
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
		try {
			DomainInheritance unlimitedNaturalTypeInheritance = metaModelManager.getInheritance(metaModelManager.getUnlimitedNaturalType());
			assertEquals(4, unlimitedNaturalTypeInheritance.getDepth());
			try {
				metaModelManager.getIntegerType().getSuperClass().remove(metaModelManager.getRealType());
				metaModelManager.getIntegerType().getSuperClass().add(metaModelManager.getOclAnyType());
				assertEquals(2, unlimitedNaturalTypeInheritance.getDepth());
				assertEquals(1, metaModelManager.getInheritance(metaModelManager.getIntegerType()).getDepth());
				assertEquals(2, metaModelManager.getInheritance(metaModelManager.getRealType()).getDepth());
			} finally {
				metaModelManager.getIntegerType().getSuperClass().add(metaModelManager.getRealType());
			}
		} finally {
			metaModelManager.dispose();
		}
	}
}
