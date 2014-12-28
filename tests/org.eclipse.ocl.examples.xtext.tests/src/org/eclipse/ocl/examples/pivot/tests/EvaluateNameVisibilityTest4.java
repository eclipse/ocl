/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *     E.D.Willink (CEA LIST) - Bug 388493, 399378
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.uml.UML2AS;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.xtext.oclinecore.OCLinEcoreStandaloneSetup;
import org.eclipse.osgi.util.NLS;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for Name access.
 */
@SuppressWarnings({"nls","null"})
@RunWith(value = Parameterized.class)
public class EvaluateNameVisibilityTest4 extends PivotFruitTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false}, {true}};
		return Arrays.asList(data);
	}

	public EvaluateNameVisibilityTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateNameVisibility";
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

	/**
	 * Tests the basic name accesses
	 */
	@Test public void test_bad_navigation() throws InvocationTargetException {
		assertSemanticErrorQuery("let a : Type = null in a.Package", PivotMessagesInternal.UnresolvedProperty_ERROR_, "Type", "Package");
		assertSemanticErrorQuery("let a : Type = null in a.Package()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Type", "Package");
		assertSemanticErrorQuery("let a : Set(Type) = null in a.Package", PivotMessagesInternal.UnresolvedProperty_ERROR_, "Set(Type)", "Package");
		assertSemanticErrorQuery("let a : Set(Type) = null in a.Package()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Set(Type)", "Package");
		assertSemanticErrorQuery("Type.Package", PivotMessagesInternal.UnresolvedStaticProperty_ERROR_, "Type", "Package");
		assertSemanticErrorQuery("Type.Package()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "Type", "Package", "");
		assertSemanticErrorQuery("Set(Type).Package", PivotMessagesInternal.UnresolvedStaticProperty_ERROR_, "Set(Type)", "Package");
		assertSemanticErrorQuery("Set(Type).Package()", PivotMessagesInternal.UnresolvedStaticOperationCall_ERROR_, "Set(Type)", "Package", "");
		assertSemanticErrorQuery("let a : Type = null in a->Package", PivotMessagesInternal.UnresolvedProperty_ERROR_, "Set(Type)", "Package");
		assertSemanticErrorQuery("let a : Type = null in a->Package()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Set(Type)", "Package");
		assertSemanticErrorQuery("let a : Set(Type) = null in a->Package", PivotMessagesInternal.UnresolvedProperty_ERROR_, "Set(Type)", "Package");
		assertSemanticErrorQuery("let a : Set(Type) = null in a->Package()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Set(Type)", "Package");
		assertSemanticErrorQuery("Type->Package", PivotMessagesInternal.UnresolvedProperty_ERROR_, "Set(Class)", "Package");
		assertSemanticErrorQuery("Type->Package()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Set(Class)", "Package");
		assertSemanticErrorQuery("Set(Type)->Package", PivotMessagesInternal.UnresolvedProperty_ERROR_, "Set(Class)", "Package");
		assertSemanticErrorQuery("Set(Type)->Package()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Set(Class)", "Package");
		assertSemanticErrorQuery("let a : Type = null in a.if", "no viable alternative following input ''if''");
		assertSemanticErrorQuery("let a : Type = null in a->if", "no viable alternative following input ''if''");
	}

    @Test public void test_implicit_source() {
		StandardLibrary standardLibrary = metaModelManager.getStandardLibrary();
        assertQueryTrue(standardLibrary.getPackage(), "ownedClasses->select(name = 'Integer') = Set{Integer}");
        assertQueryTrue(standardLibrary.getPackage(), "let name : String = 'String' in ownedClasses->select(name = 'Integer') = Set{Integer}");
        assertQueryTrue(-1, "let type : Class = oclType() in type.owningPackage.ownedClasses->select(name = type.name) = Set{Integer}");
        assertQueryTrue(standardLibrary.getPackage(), "ownedPackages->select(oclIsKindOf(Integer))->isEmpty()");
        assertQueryTrue(standardLibrary.getPackage(), "ownedPackages->select(oclIsKindOf(Package))->isEmpty()");	// Fails unless implicit Package disambiguated away by argument type expectation
    }

	@Test public void test_iterator_scope() {
		assertQueryEquals(null, 6, "Set{1, 2, 3 }->iterate(i : Integer; sum : Integer = 0 | sum + i)");
		assertQueryInvalid(null, "let s : Set(String) = invalid in Set{'a'}->union(s)");
	}

	@Test public void test_compatibility_names() {
		assertQueryEquals(null, 6, "Set{1, 2, 3 }->_iterate(i : Integer; sum : Integer = 0 | _sum + _i)");
		assertQueryInvalid(null, "let s : Set(String) = invalid in Set{'a'}->_union(_s)");
	}

	@Test public void test_self_scope() {
		ExpressionInOCL query = createQuery(null, "Sequence{1}");
		CollectionLiteralExp coll = (CollectionLiteralExp) query.getOwnedBody();
		CollectionItem item = (CollectionItem) coll.getOwnedParts().get(0);
		assertQueryTrue(item, "type = ownedItem.type");
//		assertQueryInvalid(null, "type = item.type");		// A2.2 def'n of invalid = invalid
		assertQueryInvalid(null, "let item : CollectionItem = null in item.type = item");		// A2.2 def'n of invalid = invalid
		assertQueryInvalid(null, "let item : CollectionItem = invalid in item.type = item");		// A2.2 def'n of invalid = invalid
	}

	@Test public void test_caught_and_uncaught() {
		initFruitPackage();
		EObject context = fruitEFactory.create(tree);
		assertQueryTrue(context, "let myName : String = name in myName.oclIsKindOf(String) and myName.oclAsType(String) = myName");
	}

	/**
	 * Tests nested exists iterators.
	 */
	@Test public void test_double_exists_407817() {
		String textQuery = 
			    "Set{'a','1'}->exists(s | Set{1,2}->exists(i | i.toString() = s.toUpper()))";
		assertQueryTrue(null, textQuery);
	}

	/**
	 * Tests same names on both if branches. This gave CG problems.
	 */
	@Test public void test_double_get() {
		initFruitPackage();
		EObject context = fruitEFactory.create(tree);
		assertQueryEquals(context, null, "if true then name else name endif");
	}

	/**
	 * Tests a guarded let if in operator. This gave CG problems.
	 */
	@Test public void test_cg_let_implies() {
		StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
		String textQuery = 
			    "let bodyConstraint : Constraint = null\n" + 
			    "in bodyConstraint <> null implies\n" +
			    "bodyConstraint.ownedSpecification = null";
		org.eclipse.ocl.pivot.Class testType = standardLibrary.getIntegerType();
		assert testType.getOwnedInvariants().isEmpty();
		assertQueryTrue(testType, textQuery);
//		assertQueryTrue(ValuesUtil.createTypeValue(metaModelManager.getMetaclass(testType)), textQuery);
	}
	
	@Test public void test_let_implies_let_implies() {
		StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
		String textQuery = 
			    "let bodyConstraint : Constraint = oclType().ownedInvariants->any(name = 'body')\n" + 
			    "in bodyConstraint <> null implies\n" +
			    "let bodySpecification : ValueSpecification = bodyConstraint.ownedSpecification\n" +
			    "in bodySpecification <> null and\n" +
			    "bodySpecification.oclIsKindOf(ExpressionInOCL) implies\n" +
			    "true";
//	    "CompatibleBody(bodySpecification)";
		org.eclipse.ocl.pivot.Class testType = standardLibrary.getIntegerType();
		assert testType.getOwnedInvariants().isEmpty();
		assertQueryTrue(-1, textQuery);
	}
	
	@Test public void test_no_self() throws ParserException {
		assertSemanticErrorQuery("self->any(true)", "The context of ''self'' is unspecified");
	}
	
	@Test public void test_cg_implies_calls() throws ParserException {
		StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
		getHelper().setContext(standardLibrary.getOclVoidType());
		ExpressionInOCL query = getHelper().createQuery("self->any(true)");
		String textQuery = 
			    "name = 'closure' implies\n" +
			    "type.oclAsType(CollectionType).elementType = null";
		assertQueryTrue(query.getOwnedBody(), textQuery);
	}
	
	@Test public void test_cg_caught_if() throws ParserException {
		StandardLibraryInternal standardLibrary = metaModelManager.getStandardLibrary();
		getHelper().setContext(standardLibrary.getOclVoidType());
		ExpressionInOCL query = getHelper().createQuery("self->any(true)");
		String textQuery = 
			    "name = 'closure' implies\n" +
			    "if self.ownedSource.type.oclIsKindOf(SequenceType) or self.ownedSource.type.oclIsKindOf(OrderedSetType)"
			    + "then self.type.oclIsKindOf(OrderedSetType) else self.type.oclIsKindOf(SetType) endif";
		assertQueryTrue(query.getOwnedBody(), textQuery);
	}
	
	@Test public void test_cg_loop_source_self_or() throws ParserException, IOException {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLinEcoreStandaloneSetup.doSetup();
		}
		String metaModelText =
				"import ecore : 'http://www.eclipse.org/emf/2002/Ecore#/';\n" +
				"package pkg : pkg = 'pkg' {\n" +
				"  class A {\n" +
				"    invariant True : true;\n" +
				"  }\n" +
				"}\n";
		Resource metaModel = cs2as(getOCL(), metaModelText);
		Model pivotModel = (Model) metaModel.getContents().get(0);
		org.eclipse.ocl.pivot.Package pivotPackage = pivotModel.getOwnedPackages().get(0);
		org.eclipse.ocl.pivot.Class pivotType = pivotPackage.getOwnedClasses().get(0);
		Constraint pivotConstraint = pivotType.getOwnedInvariants().get(0);
		String textQuery = "context.oclAsType(Class).ownedInvariants->excluding(self)->forAll(name <> self.name or isCallable <> self.isCallable)";
		assertQueryTrue(pivotConstraint, textQuery);
	}
	
/*	@Test public void test_cg_derived_operation() throws ParserException, IOException {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLinEcoreStandaloneSetup.doSetup();
			OCLDelegateDomain.initialize(null);
		}
		String metaModelText =
				"import ecore : 'http://www.eclipse.org/emf/2002/Ecore#/';\n" +
				"package pkg : pkg = 'pkg' {\n" +
				"  class A {\n" +
				"    operation derivedOperation(p : Integer) : Integer { body: p * 99; }\n" +
				"    operation derivedDerivedOperation(p : Integer) : Integer { body: 2 * derivedOperation(p);}\n" +
				"  }\n" +
				"}\n";
		Resource metaModel = cs2as(getOCL(), metaModelText);
		Root pivotModel = (Root) metaModel.getContents().get(0);
		org.eclipse.ocl.pivot.Package pivotPackage = pivotModel.getNestedPackage().get(0);
		Type pivotType = pivotPackage.getOwnedType().get(0);
		EClass eClass = metaModelManager.getEcoreOfPivot(EClass.class, pivotType);
		Object testObject = eClass.getEPackage().getEFactoryInstance().create(eClass);
		String textQuery = "self.derivedDerivedOperation(3)";
		assertQueryEquals(testObject, 594, textQuery);
	} */
	
	@Test public void test_cg_derived_property() throws ParserException, IOException {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLinEcoreStandaloneSetup.doSetup();
			OCLDelegateDomain.initialize(null);
		}
		String metaModelText =
				"import ecore : 'http://www.eclipse.org/emf/2002/Ecore#/';\n" +
				"package pkg : pkg = 'pkg' {\n" +
				"  class A {\n" +
				"    property derivedInteger : Integer { derivation: 99; }\n" +
				"    property derivedDerivedInteger : Integer { derivation: 2 * derivedInteger;}\n" +
				"  }\n" +
				"}\n";
		Resource metaModel = cs2as(getOCL(), metaModelText);
		Model pivotModel = (Model) metaModel.getContents().get(0);
		org.eclipse.ocl.pivot.Package pivotPackage = pivotModel.getOwnedPackages().get(0);
		org.eclipse.ocl.pivot.Class pivotType = pivotPackage.getOwnedClasses().get(0);
		EClass eClass = metaModelManager.getEcoreOfPivot(EClass.class, pivotType);
		Object testObject = eClass.getEPackage().getEFactoryInstance().create(eClass);
		String textQuery = "self.derivedDerivedInteger";
		assertQueryEquals(testObject, 198, textQuery);
	}
	
	@Test public void test_cg_name_occlusion_401692() throws ParserException, IOException {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLinEcoreStandaloneSetup.doSetup();
			OCLDelegateDomain.initialize(null);
		}
		String metaModelText =
				"package scope = 'abc'\n" + 
				"{\n" + 
				"	class A\n" + 
				"	{\n" + 
				"		attribute d : String;\n" + 
				"		attribute e : String;\n" + 
				"	}\n" + 
				"	class B\n" + 
				"	{\n" + 
				"		operation findA(e : String) : A[?]\n" + 
				"		{\n" + 
				"			body:\n" + 
				"				let found : OrderedSet(A) = as->select(a : A | a.d = e) in if found->size() > 0 then found->first() else null endif;\n" + 
				"		}\n" + 
				"		property as : A[*] { ordered composes };\n" + 
				"	}\n" + 
				"}\n";
		Resource metaModel = cs2as(getOCL(), metaModelText);
		Model pivotModel = (Model) metaModel.getContents().get(0);
		org.eclipse.ocl.pivot.Package pivotPackage = pivotModel.getOwnedPackages().get(0);
		org.eclipse.ocl.pivot.Class pivotTypeA = NameUtil.getNameable(pivotPackage.getOwnedClasses(), "A");
		org.eclipse.ocl.pivot.Class pivotTypeB = NameUtil.getNameable(pivotPackage.getOwnedClasses(), "B");
		EPackage ePackage = metaModelManager.getEcoreOfPivot(EPackage.class, pivotPackage);
		EClass eClassA = metaModelManager.getEcoreOfPivot(EClass.class, pivotTypeA);
		EClass eClassB = metaModelManager.getEcoreOfPivot(EClass.class, pivotTypeB);
		EAttribute eAttributeAd = metaModelManager.getEcoreOfPivot(EAttribute.class, NameUtil.getNameable(pivotTypeA.getOwnedProperties(), "d"));
		EAttribute eAttributeAe = metaModelManager.getEcoreOfPivot(EAttribute.class, NameUtil.getNameable(pivotTypeA.getOwnedProperties(), "e"));
		EReference eReferenceBas = metaModelManager.getEcoreOfPivot(EReference.class, NameUtil.getNameable(pivotTypeB.getOwnedProperties(), "as"));
		EFactory eFactory = ePackage.getEFactoryInstance();
		Resource resource = new ResourceImpl();
		EObject testObjectA1 = eFactory.create(eClassA);
		testObjectA1.eSet(eAttributeAd, "d1");
		testObjectA1.eSet(eAttributeAe, "e1");
		EObject testObjectA2 = eFactory.create(eClassA);
		testObjectA2.eSet(eAttributeAd, "d2");
		testObjectA2.eSet(eAttributeAe, "e2");
		EObject testObjectB = eFactory.create(eClassB);
		resource.getContents().add(testObjectB);
		@SuppressWarnings("unchecked")List<EObject> as = (List<EObject>) testObjectB.eGet(eReferenceBas);
		as.add(testObjectA1);
		as.add(testObjectA2);
		//
		assertQueryEquals(testObjectB, testObjectA1, "self.findA('d1')");
		assertQueryEquals(testObjectB, null, "self.findA('e2')");
	}
	
	@Test public void test_cg_tuple_access() throws ParserException, IOException {
//		getHelper().setContext(metaModelManager.getOclVoidType());
		String textQuery = 
				"let\n" +
				"  table : Set(Tuple(range : Sequence(Integer), size : String)) = Set{\n" +
				"    Tuple{range = Sequence{0..49}, size = 'small'},\n" +
				"    Tuple{range = Sequence{50..999}, size = 'medium'},\n" +
				"    Tuple{range = Sequence{1000..1000000}, size = 'large'}\n" +
				"  }\n" +
				"in\n" +
				"  table->any(range->includes(200000)).size";
		assertQueryEquals(null, "large", textQuery);
	}
	
	/**
	 * Tests the basic name accesses
	 */
	@Test public void test_container_navigation() throws InvocationTargetException {
		initFruitPackage();
		metaModelManager.addGlobalNamespace("fruit", fruitPackage);
		//
		//	Simple model: aTree contains redApple
		//
		EObject redApple = fruitEFactory.create(apple);
		redApple.eSet(fruit_color, color_red);
//		EObject greenApple = fruitEFactory.create(apple);
//		greenApple.eSet(fruit_color, color_green);
		EObject aTree = fruitEFactory.create(tree);
		@SuppressWarnings("unchecked")
		List<Object> treeFruits = (List<Object>) aTree.eGet(tree_fruits);
		treeFruits.add(redApple);
		//
		Type pivotTree = metaModelManager.getPivotOfEcore(Type.class, tree);
		//
		assertQueryEquals(redApple, color_red, "let aFruit : fruit::Fruit = self in aFruit.color");
		assertQueryEquals(aTree, idResolver.createOrderedSetOfEach(null, redApple), "let aTree : fruit::Tree = self in aTree.fruits");
		assertQueryEquals(aTree, idResolver.createOrderedSetOfEach(null, redApple), "self.fruits");
		assertQueryEquals(aTree, idResolver.createOrderedSetOfEach(null, redApple), "fruits");
		assertQueryEquals(redApple, aTree, "self.oclContainer()");
		assertQueryEquals(redApple, aTree, "self.Tree");
		//
		//	type/property ambiguity is resolved to type.
		//
		assertQueryEquals(redApple, pivotTree, "Tree");
		//
		//	type/property ambiguity is resolved to type.
		//
		assertQueryInvalid(redApple, "self.oclAsType(Tree)");
//		assertQueryEquals(aTree, ValuesUtil.createOrderedSetValue(null, redApple), "self.oclAsType(Tree).fruits");
	}
	
	/**
	 * Tests the nested name accesses
	 */
	@Test public void test_nested_names() throws InvocationTargetException {
		initFruitPackage();
		org.eclipse.ocl.pivot.Class appleType = metaModelManager.getPivotOfEcore(org.eclipse.ocl.pivot.Class.class, apple);
		//
		//	Simple model: appleTree contains redApple
		//
		EObject redApple = fruitEFactory.create(apple);
		redApple.eSet(fruit_color, color_red);
		redApple.eSet(fruit_name, "RedApple");
		EObject appleTree = fruitEFactory.create(tree);
		appleTree.eSet(tree_name, "AppleTree");
		@SuppressWarnings("unchecked")
		List<Object> treeFruits = (List<Object>) appleTree.eGet(tree_fruits);
		treeFruits.add(redApple);
//		
		assertQueryEquals(redApple, "RedApple", "self.name");
		assertQueryEquals(redApple, "RedApple", "self.Fruit::name");
		assertQueryEquals(redApple, "RedApple", "self.Apple::name");
		assertValidationErrorQuery2(appleType, "self.Tree::name",
			PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, "PropertyCallExp", "NonStaticSourceTypeIsConformant", "self.name");
		assertQueryEquals(redApple, redApple, "self.oclAsType(Apple)");
		assertQueryEquals(redApple, redApple, "self.oclAsType(fruit::Apple)");
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, redApple), "self->oclAsType(Set(Fruit))");
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, redApple), "self->oclAsType(Set(fruit::Apple))");
		assertSemanticErrorQuery("self.oclAsType(fruit::fruit::Apple)", PivotMessagesInternal.UnresolvedNamespace_ERROR_, "", "fruit");	// Demonstrates Bug 353985
		assertSemanticErrorQuery("self->oclAsType(Set(fruit::apple::BadApple))", PivotMessagesInternal.UnresolvedType_ERROR_, "", "BadApple");
		assertSemanticErrorQuery("self->oclAsType(Set(fruit::apple::BadApple))", PivotMessagesInternal.UnresolvedType_ERROR_, "", "BadApple");
		assertSemanticErrorQuery("self->oclAsType(Set(fruit::badapple::BadApple))", PivotMessagesInternal.UnresolvedNamespace_ERROR_, "", "badapple");
		assertSemanticErrorQuery("self->oclAsType(Set(badfruit::badapple::BadApple))", PivotMessagesInternal.UnresolvedNamespace_ERROR_, "", "badfruit");
		assertQueryInvalid(redApple, "self->oclAsType(Set(fruit::apple::EatingApple))");
		assertQueryInvalid(redApple, "self->oclAsType(Set(fruit::Tree))");		
		//
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, appleTree), "Tree.allInstances()");
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, appleTree), "fruit::Tree.allInstances()");
		assertQueryEquals(null, getEmptySetValue(), "fruit::Tree.allInstances()");
//
		metaModelManager.addGlobalNamespace("zz", fruitPackage);
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, appleTree), "zz::Tree.allInstances()");
//
		assertQueryEquals(redApple, idResolver.createBagOfEach(null, redApple), "Fruit.allInstances().oclAsType(Apple)");		
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, redApple), "Fruit.allInstances()->oclAsType(Set(Apple))");		
	}
	
	/**
	 * Tests construction of a type instance with property values
	 */
	@Test public void test_type_construction() throws InvocationTargetException {
		initFruitPackage();
		EObject context = fruitEFactory.create(tree);
		assertQueryEquals(context, null, "Apple{}.name");
		assertQueryEquals(context, "RedApple", "Apple{name='RedApple',color=Color::red}.name");
		assertQueryEquals(context, color_red, "Apple{name='RedApple',color=Color::red}.color");
		assertQueryFalse(context, "Apple{name='RedApple',color=Color::red} = Apple{name='RedApple',color=Color::red}");
		assertQueryFalse(context, "let thisApple = Apple{name='AnApple',color=Color::red}, thatApple = Apple{name='AnApple',color=Color::red} in thisApple = thatApple");
		assertQueryTrue(context, "let thisApple = Apple{name='AnApple',color=Color::red}, thatApple = Apple{name='AnApple',color=Color::red} in thisApple.name = thatApple.name");
		assertQueryTrue(context, "let thisApple = Apple{name='AnApple',color=Color::red}, thatApple = Apple{name='AnApple',color=Color::red} in thisApple.color = thatApple.color");
		assertQueryTrue(context, "let thisApple = Apple{name='AnApple',color=Color::red}, thatApple = Apple{name='AnApple',color=Color::red} in thisApple.name = thatApple.name and thisApple.color = thatApple.color");
		assertQueryFalse(context, "let thisApple = Apple{name='ThisApple',color=Color::red}, thatApple = Apple{name='ThatApple',color=Color::red} in thisApple.name = thatApple.name and thisApple.color = thatApple.color");
		assertQueryFalse(context, "let thisApple = Apple{name='AnApple',color=Color::red}, thatApple = Apple{name='AnApple',color=Color::black} in thisApple.name = thatApple.name and thisApple.color = thatApple.color");
	}
	
	/**
	 * Tests construction of a type instance with property values
	 * @throws ParserException 
	 */
	@Test public void test_uml_primitives_399378() throws ParserException {
		UML2AS.initialize(resourceSet);
		URI uri = getTestModelURI("model/Fruit.uml");
		Element element = metaModelManager.loadResource(uri, null, resourceSet);
		org.eclipse.ocl.pivot.Package fruitPackage = ((Model)element).getOwnedPackages().get(0);
		org.eclipse.ocl.pivot.Class treeClass = NameUtil.getNameable(fruitPackage.getOwnedClasses(), "Tree");
		ExpressionInOCL query = createQuery(treeClass, "self.height>20");
		assertNotNull(query);
	}
	
	@Test public void test_dynamic_dispatch_411154() throws ParserException, IOException {
		if (useCodeGen) return;
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLinEcoreStandaloneSetup.doSetup();
			OCLDelegateDomain.initialize(null);
		}
		String metaModelText =
				"package Bug411154 : pfx = 'Bug411154.ecore'\n" +
				"{\n" +
				"	class Domain {\n" +
				"		property types : T1[*] { ordered composes };\n" +
				"		property t1_2a : T1;\n" +
				"		property t1_3a : T1;\n" +
				"		property t1_3b : T1;\n" +
				"		property t1_4 : T1;\n" +
				"		property t2a_2a : T2a;\n" +
				"		property t2a_3a : T2a;\n" +
				"		property t2b_2b : T2b;\n" +
				"		property t3a : T3a;\n" +
				"	}\n" +
				"	abstract class T1 {\n" +
				"		operation op1() : String { body: 'T1::op1'; }\n" +
				"		operation op4() : String { body: 'T1::op4'; }\n" +
				"		operation op5() : String { body: 'T1::op5'; }\n" +
				"		operation op6() : String { body: 'T1::op6'; }\n" +
				"	}\n" +
				"	class T2a extends T1 {\n" +
				"		operation op1() : String { body: 'T2a::op1'; }\n" +
				"		operation op2() : String { body: 'T2a::op2'; }\n" +
				"		operation op4() : String { body: 'T2a::op4'; }\n" +
				"		operation op6() : String { body: 'T2a::op6'; }\n" +
				"		operation op7() : String { body: 'T2a::op7'; }\n" +
				"		operation op9() : String { body: 'T2a::op9'; }\n" +
				"	}\n" +
				"	class T2b extends T1 {\n" +
				"		operation op6() : String { body: 'T2b::op6'; }\n" +
				"		operation op7() : String { body: 'T2b::op7'; }\n" +
				"		operation op9() : String { body: 'T2b::op9'; }\n" +
				"	}\n" +
				"	class T3a extends T2a,T2b {\n" +
				"		operation op1() : String { body: 'T3a::op1'; }\n" +
				"		operation op2() : String { body: 'T3a::op2'; }\n" +
				"		operation op3() : String { body: 'T3a::op3'; }\n" +
				"		operation op6() : String { body: 'T3a::op6'; }\n" +
				"		operation op7() : String { body: 'T3a::op7'; }\n" +
				"	}\n" +
				"	class T3b extends T2a,T2b {\n" +
				"	}\n" +
				"	class T4 extends T3a,T3b {\n" +
				"		operation op6() : String { body: 'T4::op6'; }\n" +
				"		operation op7() : String { body: 'T4::op7'; }\n" +
				"	}\n" +
				"}\n";
		Resource metaModel = cs2as(getOCL(), metaModelText);
		Model pivotModel = (Model) metaModel.getContents().get(0);
		org.eclipse.ocl.pivot.Package pivotPackage = pivotModel.getOwnedPackages().get(0);
		org.eclipse.ocl.pivot.Class pivotTypeDomain = NameUtil.getNameable(pivotPackage.getOwnedClasses(), "Domain");
//		org.eclipse.ocl.pivot.Class pivotTypeT1 = ClassUtil.getNamedElement(pivotPackage.getOwnedType(), "T1");
		org.eclipse.ocl.pivot.Class pivotTypeT2a = NameUtil.getNameable(pivotPackage.getOwnedClasses(), "T2a");
		org.eclipse.ocl.pivot.Class pivotTypeT2b = NameUtil.getNameable(pivotPackage.getOwnedClasses(), "T2b");
		org.eclipse.ocl.pivot.Class pivotTypeT3a = NameUtil.getNameable(pivotPackage.getOwnedClasses(), "T3a");
		org.eclipse.ocl.pivot.Class pivotTypeT3b = NameUtil.getNameable(pivotPackage.getOwnedClasses(), "T3b");
		org.eclipse.ocl.pivot.Class pivotTypeT4 = NameUtil.getNameable(pivotPackage.getOwnedClasses(), "T4");
		EPackage ePackage = metaModelManager.getEcoreOfPivot(EPackage.class, pivotPackage);
		EClass eClassDomain = metaModelManager.getEcoreOfPivot(EClass.class, pivotTypeDomain);
//		EClass eClassT1 = metaModelManager.getEcoreOfPivot(EClass.class, pivotTypeT1);
		EClass eClassT2a = metaModelManager.getEcoreOfPivot(EClass.class, pivotTypeT2a);
		EClass eClassT2b = metaModelManager.getEcoreOfPivot(EClass.class, pivotTypeT2b);
		EClass eClassT3a = metaModelManager.getEcoreOfPivot(EClass.class, pivotTypeT3a);
		EClass eClassT3b = metaModelManager.getEcoreOfPivot(EClass.class, pivotTypeT3b);
		EClass eClassT4 = metaModelManager.getEcoreOfPivot(EClass.class, pivotTypeT4);
		EReference eReferenceDomain_types = metaModelManager.getEcoreOfPivot(EReference.class, NameUtil.getNameable(pivotTypeDomain.getOwnedProperties(), "types"));
		EReference eReferenceDomain_t1_2a = metaModelManager.getEcoreOfPivot(EReference.class, NameUtil.getNameable(pivotTypeDomain.getOwnedProperties(), "t1_2a"));
		EReference eReferenceDomain_t1_3a = metaModelManager.getEcoreOfPivot(EReference.class, NameUtil.getNameable(pivotTypeDomain.getOwnedProperties(), "t1_3a"));
		EReference eReferenceDomain_t1_3b = metaModelManager.getEcoreOfPivot(EReference.class, NameUtil.getNameable(pivotTypeDomain.getOwnedProperties(), "t1_3b"));
		EReference eReferenceDomain_t1_4 = metaModelManager.getEcoreOfPivot(EReference.class, NameUtil.getNameable(pivotTypeDomain.getOwnedProperties(), "t1_4"));
		EReference eReferenceDomain_t2a_2a = metaModelManager.getEcoreOfPivot(EReference.class, NameUtil.getNameable(pivotTypeDomain.getOwnedProperties(), "t2a_2a"));
		EReference eReferenceDomain_t2a_3a = metaModelManager.getEcoreOfPivot(EReference.class, NameUtil.getNameable(pivotTypeDomain.getOwnedProperties(), "t2a_3a"));
		EReference eReferenceDomain_t2b_2b = metaModelManager.getEcoreOfPivot(EReference.class, NameUtil.getNameable(pivotTypeDomain.getOwnedProperties(), "t2b_2b"));
		EReference eReferenceDomain_t3a = metaModelManager.getEcoreOfPivot(EReference.class, NameUtil.getNameable(pivotTypeDomain.getOwnedProperties(), "t3a"));
		EFactory eFactory = ePackage.getEFactoryInstance();
		Resource resource = new ResourceImpl();
		EObject testObjectDomain = eFactory.create(eClassDomain);
		resource.getContents().add(testObjectDomain);
		EObject testObjectT2a = eFactory.create(eClassT2a);
		EObject testObjectT2b = eFactory.create(eClassT2b);
		EObject testObjectT3a = eFactory.create(eClassT3a);
		EObject testObjectT3b = eFactory.create(eClassT3b);
		EObject testObjectT4 = eFactory.create(eClassT4);
		@SuppressWarnings("unchecked")
		List<EObject> list = (List<EObject>)testObjectDomain.eGet(eReferenceDomain_types);
		list.add(testObjectT2a);
		list.add(testObjectT2b);
		list.add(testObjectT3a);
		list.add(testObjectT3b);
		list.add(testObjectT4);
		testObjectDomain.eSet(eReferenceDomain_t1_2a, testObjectT2a);
		testObjectDomain.eSet(eReferenceDomain_t1_3a, testObjectT3a);
		testObjectDomain.eSet(eReferenceDomain_t1_3b, testObjectT3b);
		testObjectDomain.eSet(eReferenceDomain_t1_4, testObjectT4);
		testObjectDomain.eSet(eReferenceDomain_t2a_2a, testObjectT2a);
		testObjectDomain.eSet(eReferenceDomain_t2a_3a, testObjectT3a);
		testObjectDomain.eSet(eReferenceDomain_t2b_2b, testObjectT2b);
		testObjectDomain.eSet(eReferenceDomain_t3a, testObjectT3a);
		//
		assertQueryEquals(testObjectT2a, "T2a::op1", "self.op1()");
		assertQueryEquals(testObjectT2a, "T2a::op2", "self.op2()");
		assertSemanticErrorQuery2(pivotTypeT2a, "self.op3()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T2a::op3");
		assertQueryEquals(testObjectT2a, "T2a::op4", "self.op4()");
		assertQueryEquals(testObjectT2a, "T1::op5", "self.op5()");
		assertQueryEquals(testObjectT2a, "T2a::op6", "self.op6()");
		assertQueryEquals(testObjectT2a, "T2a::op7", "self.op7()");
		assertSemanticErrorQuery2(pivotTypeT2a, "self.op8()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T2a::op8");
		assertQueryEquals(testObjectT2a, "T2a::op9", "self.op9()");
		//
		assertQueryEquals(testObjectT3a, "T3a::op1", "self.op1()");
		assertQueryEquals(testObjectT3a, "T3a::op2", "self.op2()");
		assertQueryEquals(testObjectT3a, "T3a::op3", "self.op3()");
		assertQueryEquals(testObjectT3a, "T2a::op4", "self.op4()");
		assertQueryEquals(testObjectT3a, "T1::op5", "self.op5()");
		assertQueryEquals(testObjectT3a, "T3a::op6", "self.op6()");
		assertQueryEquals(testObjectT3a, "T3a::op7", "self.op7()");
		assertSemanticErrorQuery2(pivotTypeT3a, "self.op8()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T3a::op8");
		assertSemanticErrorQuery2(pivotTypeT3a, "self.op9()", "Ambiguous resolution:\n" +
				"\tOperation : Bug411154::T2a::op9() : String\n" +
				"\tOperation : Bug411154::T2b::op9() : String");
		//
		assertQueryEquals(testObjectDomain, "T2a::op1", "t1_2a.op1()");
		assertSemanticErrorQuery2(pivotTypeDomain, "t1_2a.op2()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T1::op2");
		assertSemanticErrorQuery2(pivotTypeDomain, "t1_2a.op3()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T1::op3");
		assertQueryEquals(testObjectDomain, "T2a::op4", "t1_2a.op4()");
		assertQueryEquals(testObjectDomain, "T1::op5", "t1_2a.op5()");
		//
		assertQueryEquals(testObjectDomain, "T3a::op1", "t1_3a.op1()");
		assertSemanticErrorQuery2(pivotTypeDomain, "t1_3a.op2()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T1::op2");
		assertSemanticErrorQuery2(pivotTypeDomain, "t1_3a.op3()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T1::op3");
		assertQueryEquals(testObjectDomain, "T2a::op4", "t1_3a.op4()");
		assertQueryEquals(testObjectDomain, "T1::op5", "t1_3a.op5()");
		//
		assertQueryEquals(testObjectDomain, "T2a::op1", "t1_3b.op1()");
		assertSemanticErrorQuery2(pivotTypeDomain, "t1_3b.op2()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T1::op2");
		assertSemanticErrorQuery2(pivotTypeDomain, "t1_3b.op3()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T1::op3");
		assertQueryEquals(testObjectDomain, "T2a::op4", "t1_3b.op4()");
		assertQueryEquals(testObjectDomain, "T1::op5", "t1_3b.op5()");
		assertQueryInvalid(testObjectDomain, "t1_3b.op6()", NLS.bind(PivotMessages.AmbiguousOperation, "Bug411154::T1::op6() : String", "Bug411154::T3b"), InvalidValueException.class);
		assertSemanticErrorQuery2(pivotTypeDomain, "t1_3b.op7()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T1::op7");
		//
		assertQueryEquals(testObjectDomain, "T3a::op1", "t1_4.op1()");
		assertSemanticErrorQuery2(pivotTypeDomain, "t1_4.op2()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T1::op2");
		assertSemanticErrorQuery2(pivotTypeDomain, "t1_4.op3()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T1::op3");
		assertQueryEquals(testObjectDomain, "T2a::op4", "t1_4.op4()");
		assertQueryEquals(testObjectDomain, "T1::op5", "t1_4.op5()");
		assertQueryEquals(testObjectDomain, "T4::op6", "t1_4.op6()");
		assertSemanticErrorQuery2(pivotTypeDomain, "t1_4.op7()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T1::op7");
		//
		assertQueryEquals(testObjectDomain, "T2a::op1", "t2a_2a.op1()");
		assertQueryEquals(testObjectDomain, "T2a::op2", "t2a_2a.op2()");
		assertSemanticErrorQuery2(pivotTypeDomain, "t2a_2a.op3()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T2a::op3");
		assertQueryEquals(testObjectDomain, "T2a::op4", "t2a_2a.op4()");
		assertQueryEquals(testObjectDomain, "T1::op5", "t2a_2a.op5()");
		assertQueryEquals(testObjectDomain, "T2a::op6", "t2a_2a.op6()");
		assertQueryEquals(testObjectDomain, "T2a::op7", "t2a_2a.op7()");
		//
		assertQueryEquals(testObjectDomain, "T2b::op6", "t2b_2b.op6()");
		//
		assertQueryEquals(testObjectDomain, "T3a::op1", "t2a_3a.op1()");
		assertQueryEquals(testObjectDomain, "T3a::op2", "t2a_3a.op2()");
		assertSemanticErrorQuery2(pivotTypeDomain, "t2a_3a.op3()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Bug411154", "T2a::op3");
		assertQueryEquals(testObjectDomain, "T2a::op4", "t2a_3a.op4()");
		assertQueryEquals(testObjectDomain, "T1::op5", "t2a_3a.op5()");
		//
		assertQueryEquals(testObjectDomain, "T3a::op1", "t3a.op1()");
		assertQueryEquals(testObjectDomain, "T3a::op2", "t3a.op2()");
		assertQueryEquals(testObjectDomain, "T3a::op3", "t3a.op3()");
		assertQueryEquals(testObjectDomain, "T2a::op4", "t3a.op4()");
		assertQueryEquals(testObjectDomain, "T1::op5", "t3a.op5()");
	}
}
