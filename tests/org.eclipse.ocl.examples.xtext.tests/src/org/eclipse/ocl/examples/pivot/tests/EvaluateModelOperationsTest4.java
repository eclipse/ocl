/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.domain.values.OrderedSetValue;
import org.eclipse.ocl.domain.values.Value;
import org.eclipse.ocl.pivot.OCL;
import org.eclipse.ocl.pivot.messages.OCLMessages;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for model access operations.
 */
@SuppressWarnings("nls")
@RunWith(value = Parameterized.class)
public class EvaluateModelOperationsTest4 extends PivotTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false}, {true}};
		return Arrays.asList(data);
	}

	public EvaluateModelOperationsTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateModelOperations";
	}
	
	@BeforeClass public static void resetCounter() throws Exception {
		PivotTestSuite.resetCounter();
    }

    @Override
    @Before public void setUp() throws Exception {
        super.setUp();
		doOCLinEcoreSetup();
    }

	@Override
	@After public void tearDown() throws Exception {
		super.tearDown();
	}
	
	@SuppressWarnings("unchecked")
	public void eAdd(@NonNull EObject eObject, @NonNull String featureName, @Nullable Object value) {
		EStructuralFeature eStructuralFeature = eObject.eClass().getEStructuralFeature(featureName);
		assert eStructuralFeature.isMany();
		if (eStructuralFeature instanceof EReference) {
			assert value instanceof EObject;
		}
		else {
			assert !(value instanceof EObject);
		}
		((List<Object>)eObject.eGet(eStructuralFeature)).add(value);
	}

	public @NonNull EObject eCreate(EClass cClass) {
		return DomainUtil.nonNullEMF(cClass.getEPackage().getEFactoryInstance().create(cClass));
	}

	public void eSet(@NonNull EObject eObject, @NonNull String featureName, @Nullable Object value) {
		EStructuralFeature eStructuralFeature = eObject.eClass().getEStructuralFeature(featureName);
		assert !eStructuralFeature.isMany();
		if (eStructuralFeature instanceof EReference) {
			assert value instanceof EObject;
		}
		else {
			assert !(value instanceof EObject);
		}
		eObject.eSet(eStructuralFeature, value);
	}

	/**
	 * Test that Ecore Data Types can be used. Inspired by Bug 358713.
	 */
	@Test public void test_ecoreDataTypes() throws IOException {
		String metaModelText =
			"import ecore : 'http://www.eclipse.org/emf/2002/Ecore#/';\n" +
			"package pkg : pkg = 'pkg' {\n" +
			"  class A {\n" +
			"    property anEBigDecimal : ecore::EBigDecimal;\n" +
			"    property anEBigInteger : ecore::EBigInteger;\n" +
			"    property anEBoolean : ecore::EBoolean;\n" +
			"    property anEBooleanObject : ecore::EBooleanObject;\n" +
			"    property anEByte : ecore::EByte;\n" +
			"    property anEByteObject : ecore::EByteObject;\n" +
			"    property anEChar : ecore::EChar;\n" +
			"    property anECharacterObject : ecore::ECharacterObject;\n" +
			"    property anEDouble : ecore::EDouble;\n" +
			"    property anEDoubleObject : ecore::EDoubleObject;\n" +
			"    property anEFloat : ecore::EFloat;\n" +
			"    property anEFloatObject : ecore::EFloatObject;\n" +
			"    property anEInt : ecore::EInt;\n" +
			"    property anEIntegerObject : ecore::EIntegerObject;\n" +
			"    property anELong : ecore::ELong;\n" +
			"    property anELongObject : ecore::ELongObject;\n" +
			"    property anEShort : ecore::EShort;\n" +
			"    property anEShortObject : ecore::EShortObject;\n" +
			"    property anEString : ecore::EString;\n" +
			"  }\n" +
			"}\n";
		Resource metaModel = cs2ecore(getOCL(), metaModelText, null);
		EPackage ePackage = (EPackage) metaModel.getContents().get(0);
		EClass eClass = DomainUtil.nonNullState((EClass) ePackage.getEClassifiers().get(0));
        helper.setContext(metaModelManager.getIdResolver().getType(eClass));
        EObject eObject = eCreate(eClass);
        //
        eSet(eObject, "anEBigDecimal", BigDecimal.valueOf(0));
		assertQueryEquals(eObject, 0, "anEBigDecimal");
		assertQueryEquals(eObject, 1, "anEBigDecimal + 1");
		assertQueryEquals(eObject, 0, "self.anEBigDecimal");
		assertQueryEquals(eObject, 1, "self.anEBigDecimal + 1");
        //
        eSet(eObject, "anEBigInteger", BigInteger.valueOf(0));
		assertQueryEquals(eObject, 0, "anEBigInteger");
		assertQueryEquals(eObject, 1, "anEBigInteger + 1");
		assertQueryEquals(eObject, 0, "self.anEBigInteger");
		assertQueryEquals(eObject, 1, "self.anEBigInteger + 1");
        //
		assertQueryEquals(eObject, false, "anEBoolean");
		assertQueryEquals(eObject, true, "anEBoolean or true");
		assertQueryEquals(eObject, false, "self.anEBoolean");
		assertQueryEquals(eObject, true, "self.anEBoolean or true");
        //
        eSet(eObject, "anEBooleanObject", false);
		assertQueryEquals(eObject, false, "anEBooleanObject");
		assertQueryEquals(eObject, true, "anEBooleanObject or true");
		assertQueryEquals(eObject, false, "self.anEBooleanObject");
		assertQueryEquals(eObject, true, "self.anEBooleanObject or true");
        //
		assertQueryEquals(eObject, 0, "anEByte");
		assertQueryEquals(eObject, 1, "anEByte + 1");
		assertQueryEquals(eObject, 0, "self.anEByte");
		assertQueryEquals(eObject, 1, "self.anEByte + 1");
        //
        eSet(eObject, "anEByteObject", (byte)0);
		assertQueryEquals(eObject, 0, "anEByteObject");
		assertQueryEquals(eObject, 1, "anEByteObject + 1");
		assertQueryEquals(eObject, 0, "self.anEByteObject");
		assertQueryEquals(eObject, 1, "self.anEByteObject + 1");
        //
		assertQueryEquals(eObject, 0, "anEChar");
		assertQueryEquals(eObject, 1, "anEChar + 1");
		assertQueryEquals(eObject, 0, "self.anEChar");
		assertQueryEquals(eObject, 1, "self.anEChar + 1");
        //
	    eSet(eObject, "anECharacterObject", (char)0);
		assertQueryEquals(eObject, 0, "anECharacterObject");
		assertQueryEquals(eObject, 1, "anECharacterObject + 1");
		assertQueryEquals(eObject, 0, "self.anECharacterObject");
		assertQueryEquals(eObject, 1, "self.anECharacterObject + 1");
        //
		assertQueryEquals(eObject, 0, "anEDouble");
		assertQueryEquals(eObject, 1, "anEDouble + 1");
		assertQueryEquals(eObject, 0, "self.anEDouble");
		assertQueryEquals(eObject, 1, "self.anEDouble + 1");
        //
        eSet(eObject, "anEDoubleObject", (double)0);
		assertQueryEquals(eObject, 0, "anEDoubleObject");
		assertQueryEquals(eObject, 1, "anEDoubleObject + 1");
		assertQueryEquals(eObject, 0, "self.anEDoubleObject");
		assertQueryEquals(eObject, 1, "self.anEDoubleObject + 1");
        //
		assertQueryEquals(eObject, 0, "anEFloat");
		assertQueryEquals(eObject, 1, "anEFloat + 1");
		assertQueryEquals(eObject, 0, "self.anEFloat");
		assertQueryEquals(eObject, 1, "self.anEFloat + 1");
        //
        eSet(eObject, "anEFloatObject", (float)0);
		assertQueryEquals(eObject, 0, "anEFloatObject");
		assertQueryEquals(eObject, 1, "anEFloatObject + 1");
		assertQueryEquals(eObject, 0, "self.anEFloatObject");
		assertQueryEquals(eObject, 1, "self.anEFloatObject + 1");
        //
		assertQueryEquals(eObject, 0, "anEInt");
		assertQueryEquals(eObject, 1, "anEInt + 1");
		assertQueryEquals(eObject, 0, "self.anEInt");
		assertQueryEquals(eObject, 1, "self.anEInt + 1");
        //
        eSet(eObject, "anEIntegerObject", 0);
		assertQueryEquals(eObject, 0, "anEIntegerObject");
		assertQueryEquals(eObject, 1, "anEIntegerObject + 1");
		assertQueryEquals(eObject, 0, "self.anEIntegerObject");
		assertQueryEquals(eObject, 1, "self.anEIntegerObject + 1");
        //
		assertQueryEquals(eObject, 0, "anELong");
		assertQueryEquals(eObject, 1, "anELong + 1");
		assertQueryEquals(eObject, 0, "self.anELong");
		assertQueryEquals(eObject, 1, "self.anELong + 1");
        //
        eSet(eObject, "anELongObject", (long)0);
		assertQueryEquals(eObject, 0, "anELongObject");
		assertQueryEquals(eObject, 1, "anELongObject + 1");
		assertQueryEquals(eObject, 0, "self.anELongObject");
		assertQueryEquals(eObject, 1, "self.anELongObject + 1");
        //
		assertQueryEquals(eObject, 0, "anEShort");
		assertQueryEquals(eObject, 1, "anEShort + 1");
		assertQueryEquals(eObject, 0, "self.anEShort");
		assertQueryEquals(eObject, 1, "self.anEShort + 1");
        //
        eSet(eObject, "anEShortObject", (short)0);
		assertQueryEquals(eObject, 0, "anEShortObject");
		assertQueryEquals(eObject, 1, "anEShortObject + 1");
		assertQueryEquals(eObject, 0, "self.anEShortObject");
		assertQueryEquals(eObject, 1, "self.anEShortObject + 1");
        //
        eSet(eObject, "anEString", "");
		assertQueryEquals(eObject, "", "anEString");
		assertQueryEquals(eObject, "1", "anEString + '1'");
		assertQueryEquals(eObject, "", "self.anEString");
		assertQueryEquals(eObject, "1", "self.anEString + '1'");
	}

	/**
	 * Test implicit collect and oclAsSet() therein. Inspired by Bug 351512.
	 */
	@Test public void test_oclAsSet_351512() throws IOException {
		String metaModelText =
			"import ecore : 'http://www.eclipse.org/emf/2002/Ecore#/';\n" +
			"package pkg : pkg = 'pkg' {\n" +
			"  class A {\n" +
			"    property bs : B[*] {ordered,unique};\n" +
			"    attribute name : String;\n" +
			"  }\n" +
			"  class B {\n" +
			"    property c : C;\n" +
			"  }\n" +
			"  class C {\n" +
			"    attribute name : String;\n" +
			"  }\n" +
			"}\n";
		Resource metaModel = cs2ecore(getOCL(), metaModelText, null);
		EPackage ePackage = (EPackage) metaModel.getContents().get(0);
		EClass aClass = DomainUtil.nonNullState((EClass) ePackage.getEClassifier("A"));
		EClass bClass = (EClass) ePackage.getEClassifier("B");
		EClass cClass = (EClass) ePackage.getEClassifier("C");
        EObject c1 = eCreate(cClass);
        eSet(c1, "name", "c1");
        EObject c2 = eCreate(cClass);
        eSet(c2, "name", "c2");
        EObject b1 = eCreate(bClass);
        eSet(b1, "c", c1);
        EObject b2 = eCreate(bClass);
        eSet(b2, "c", c2);
        EObject a = eCreate(aClass);
        eAdd(a, "bs", b1);
        eAdd(a, "bs", b2);

        org.eclipse.ocl.pivot.Class aType = metaModelManager.getIdResolver().getType(aClass);
        //
		Object b1_value = idResolver.boxedValueOf(b1);
		Object b2_value = idResolver.boxedValueOf(b2);
		Object c1_value = idResolver.boxedValueOf(c1);
		Object c2_value = idResolver.boxedValueOf(c2);
		Value orderedSet_b1_b2 = idResolver.createOrderedSetOfEach(TypeId.ORDERED_SET.getSpecializedId(TypeId.OCL_ANY), b1_value, b2_value);
		Value sequence_c1_c2 = idResolver.createSequenceOfEach(TypeId.SEQUENCE.getSpecializedId(TypeId.OCL_ANY), c1_value, c2_value);
		//
		helper.setContext(aType);
		//
		assertQueryEquals(a, orderedSet_b1_b2, "bs");
		assertQueryEquals(a, sequence_c1_c2, "bs.c");
		assertQueryEquals(a, sequence_c1_c2, "bs.c.oclAsSet()");
		assertQueryResults(a, "Sequence{'c1','c2'}", "bs.c.name");
		assertQueryResults(a, "Sequence{'c1','c2'}", "self.bs.c.name");
        assertQueryResults(a, "Sequence{'c1','c2'}", "bs.c.oclAsSet().name");
        assertQueryResults(a, "Sequence{'c1','c2'}", "bs.c.oclAsSet()->collect(name)");	// Test for Bug 351512
        assertQueryResults(a, "Sequence{'c1','c2'}", "bs.c->collect(oclAsSet()).name");
        assertQueryResults(a, "Sequence{'c1','c2'}", "bs.c->collect(j : C | j.oclAsSet()).name");
        assertQueryResults(a, "Sequence{'c1','c2'}", "bs->collect(i : B | i.c)->collect(j : C | j.oclAsSet())->collect(k : C | k.name)");
	}

	/**
	 * Test container/containment navigation.
	 */
	@Test public void test_containment_navigation() throws IOException {
		String metaModelText =
			"package containment : pfx = 'http://containment'\n" +
			"{\n" +
			"	class Parent\n" +
			"	{\n" +
			"		property child1 : Child1[?] { ordered composes };\n" +
			"		property child2#parent : Child2[?] { ordered composes };\n" +
			"		property children1 : Children1[*] { ordered composes };\n" +
			"		property children2#parent : Children2[*] { ordered composes };\n" +
			"	}\n" +
			"	class Child1\n" +
			"	{\n" +
			"	}\n" +
			"	class Child2\n" +
			"	{\n" +
			"		property parent#child2 : Parent[?] { ordered };\n" +
			"	}\n" +
			"	class Children1\n" +
			"	{\n" +
			"	}\n" +
			"	class Children2\n" +
			"	{\n" +
			"		property parent#children2 : Parent[?] { ordered };\n" +
			"	}\n" +
			"}\n";
		OCL ocl1 = OCL.newInstance();
		Resource metaModel = cs2ecore(ocl1, metaModelText, null);
		EPackage ePackage = (EPackage) metaModel.getContents().get(0);
		EClass parentClass = DomainUtil.nonNullState((EClass) ePackage.getEClassifier("Parent"));
		EClass child1Class = DomainUtil.nonNullState((EClass) ePackage.getEClassifier("Child1"));
		EClass child2Class = DomainUtil.nonNullState((EClass) ePackage.getEClassifier("Child2"));
		EClass children1Class = DomainUtil.nonNullState((EClass) ePackage.getEClassifier("Children1"));
		EClass children2Class = DomainUtil.nonNullState((EClass) ePackage.getEClassifier("Children2"));
        EObject parent = eCreate(parentClass);
        EObject child1 = eCreate(child1Class);
        EObject child2 = eCreate(child2Class);
        EObject children1 = eCreate(children1Class);
        EObject children2 = eCreate(children2Class);
        eSet(parent, "child1", child1);
        eSet(parent, "child2", child2);
        eAdd(parent, "children1", children1);
        eAdd(parent, "children2", children2);

        org.eclipse.ocl.pivot.Class parentType = metaModelManager.getIdResolver().getType(parentClass);
        org.eclipse.ocl.pivot.Class child1Type = metaModelManager.getIdResolver().getType(child1Class);
        org.eclipse.ocl.pivot.Class child2Type = metaModelManager.getIdResolver().getType(child2Class);
        org.eclipse.ocl.pivot.Class children1Type = metaModelManager.getIdResolver().getType(children1Class);
        org.eclipse.ocl.pivot.Class children2Type = metaModelManager.getIdResolver().getType(children2Class);
        //
		OrderedSetValue kids1 = idResolver.createOrderedSetOfEach(TypeId.ORDERED_SET.getSpecializedId(children1Type.getTypeId()), children1);
		OrderedSetValue kids2 = idResolver.createOrderedSetOfEach(TypeId.ORDERED_SET.getSpecializedId(children2Type.getTypeId()), children2);
		//
		assertSemanticErrorQuery2(parentType, "parent", OCLMessages.UnresolvedProperty_ERROR_, "", "parent");
		assertSemanticErrorQuery2(parentType, "self.parent", OCLMessages.UnresolvedProperty_ERROR_, parentType, "parent");
		assertQueryEquals(parent, parentType, "Parent");
		assertSemanticErrorQuery2(parentType, "self.Parent", OCLMessages.UnresolvedProperty_ERROR_, parentType, "Parent");
		assertQueryEquals(parent, child1, "child1");
		assertQueryEquals(parent, child1, "self.child1");
		assertQueryEquals(parent, child1Type, "Child1");
		assertSemanticErrorQuery2(parentType, "self.Child1", OCLMessages.UnresolvedProperty_ERROR_, parentType, "Child1");
		assertQueryEquals(parent, child2, "child2");
		assertQueryEquals(parent, child2, "self.child2");
		assertQueryEquals(parent, child2Type, "Child2");
		assertSemanticErrorQuery2(parentType, "self.Child2", OCLMessages.UnresolvedProperty_ERROR_, parentType, "Child2");
		assertQueryEquals(parent, kids1, "children1");
		assertQueryEquals(parent, kids1, "self.children1");
		assertQueryEquals(parent, children1Type, "Children1");
		assertSemanticErrorQuery2(parentType, "self.Children1", OCLMessages.UnresolvedProperty_ERROR_, parentType, "Children1");
		assertQueryEquals(parent, kids2, "children2");
		assertQueryEquals(parent, kids2, "self.children2");
		assertQueryEquals(parent, children2Type, "Children2");
		assertSemanticErrorQuery2(parentType, "self.Children2", OCLMessages.UnresolvedProperty_ERROR_, parentType, "Children2");
		//
		assertSemanticErrorQuery2(child1Type, "parent", OCLMessages.UnresolvedProperty_ERROR_, "", "parent");
		assertQueryEquals(child2, parentType, "Parent");
		assertSemanticErrorQuery2(child1Type, "self.parent", OCLMessages.UnresolvedProperty_ERROR_, child1Type, "parent");
		assertQueryEquals(child1, parent, "self.Parent");
		//
		assertQueryEquals(child2, parent, "parent");
		assertQueryEquals(child2, parentType, "Parent");
		assertQueryEquals(child2, parent, "self.parent");
		assertSemanticErrorQuery2(child2Type, "self.Parent", OCLMessages.UnresolvedProperty_ERROR_, child2Type, "Parent");
		//
		assertSemanticErrorQuery2(children1Type, "parent", OCLMessages.UnresolvedProperty_ERROR_, "", "parent");
		assertQueryEquals(children1, parentType, "Parent");
		assertSemanticErrorQuery2(children1Type, "self.parent", OCLMessages.UnresolvedProperty_ERROR_, children1Type, "parent");
		assertQueryEquals(children1, parent, "self.Parent");
		//
		assertQueryEquals(children2, parent, "parent");
		assertQueryEquals(children2, parentType, "Parent");
		assertQueryEquals(children2, parent, "self.parent");
		assertSemanticErrorQuery2(children2Type, "self.Parent", OCLMessages.UnresolvedProperty_ERROR_, children2Type, "Parent");
		//
		assertQueryTrue(parent, "child1 = child1");
		ocl1.dispose();
	}

	/**
	 * Test multi-container navigation inspired by Bug 394152.
	 */
	@Test public void test_multi_container_394152() throws IOException {
		String metaModelText =
			"package bug394152 : pfx = 'http://bug394152'\n" +
			"{\n" +
			"	class Parent\n" +
			"	{\n" +
			"		property left#left : Child[+] { ordered composes };\n" +
			"		property right#right : Child[+] { ordered composes };\n" +
			"	}\n" +
			"	class Child\n" +
			"	{\n" +
			"		property left#left : Parent[?] { ordered };\n" +
			"		property right#right : Parent[?] { ordered };\n" +
			"	}\n" +
			"}\n";
		Resource metaModel = cs2ecore(getOCL(), metaModelText, null);
		EPackage ePackage = (EPackage) metaModel.getContents().get(0);
		EClass parentClass = (EClass) ePackage.getEClassifier("Parent");
		EClass childClass = DomainUtil.nonNullState((EClass) ePackage.getEClassifier("Child"));
        EObject parent = eCreate(parentClass);
        EObject leftChild = eCreate(childClass);
        EObject rightChild = eCreate(childClass);
        eAdd(parent, "left", leftChild);
        eAdd(parent, "right", rightChild);

        org.eclipse.ocl.pivot.Class childType = metaModelManager.getIdResolver().getType(childClass);
		//
		helper.setContext(childType);
		//
		assertQueryEquals(leftChild, parent, "left");
		assertQueryEquals(leftChild, null, "right");
		assertQueryEquals(rightChild, null, "left");
		assertQueryEquals(rightChild, parent, "right");
	}
	
	@Test public void test_unified_types_411441() {
		assertQueryTrue(null, "let x : Collection(Type) = Set{Integer,Real} in x->forAll(x : Type | x.name.indexOf('e') > 0)");
		assertQueryTrue(null, "let x : Type[*] = Bag{Integer,Real} in x->forAll(x : Type | x.name.indexOf('e') > 0)");
		assertValidationErrorQuery2(null, "let x : Type[*] = Set{Integer,Real} in x->forAll(x : Type | x.name.indexOf('e') > 0)",
			EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Variable", "CompatibleInitialiserType", "x : Bag(Type) = Set{Integer, Real}");
		assertQueryTrue(null, "let x : Collection(Type[*]) = Set{Bag{Integer,Real},Bag{Boolean}} in x->forAll(x : Type[*] | x->size() > 0)");
		assertValidationErrorQuery2(null, "let x : Collection(Type[*]) = Set{Bag{Integer,Real},Bag{Boolean}} in x->forAll(x : Type | x->size() > 0)",
			EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "IteratorExp", "IteratorTypeIsSourceElementType", "x->forAll(x : Type[?] | x.oclAsSet()->size().>(0))");
		assertValidationErrorQuery2(null, "let x : Collection(Type) = Set{Integer,Real} in x->forAll(x : Type[*] | x->size() > 0)",
			EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "IteratorExp", "IteratorTypeIsSourceElementType", "x->forAll(x : Bag(Type)[?] | x->size().>(0))");
	}
}
