/*******************************************************************************
 * Copyright (c) 2006, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 296409, 297541
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.LibraryConstants;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.xtext.oclinecore.OCLinEcoreStandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for iterator expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
@RunWith(value = Parameterized.class)
public class IteratorsTest4 extends PivotTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false}, {true}};
		return Arrays.asList(data);
	}

	public IteratorsTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	Root root;
	org.eclipse.ocl.examples.pivot.Package pkg1;
	org.eclipse.ocl.examples.pivot.Package pkg2;
	org.eclipse.ocl.examples.pivot.Package pkg3;
	org.eclipse.ocl.examples.pivot.Package pkg4;
	org.eclipse.ocl.examples.pivot.Package pkg5;
	org.eclipse.ocl.examples.pivot.Package jim;
	org.eclipse.ocl.examples.pivot.Package bob;
	org.eclipse.ocl.examples.pivot.Package george;

	@Override
	protected @NonNull String getTestPackageName() {
		return "Iterators";
	}
	
	@BeforeClass public static void resetCounter() throws Exception {
		PivotTestSuite.resetCounter();
    }

    @SuppressWarnings("null")
	@Override
    @Before public void setUp() throws Exception {
        super.setUp();
        PivotTables.LIBRARY.getClass();
//		metaModelManager.addGlobalNamespace(PivotConstants.OCL_NAME, DomainUtil.nonNullState(metaModelManager.getASMetamodel()));

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

        root = createRoot();
        pkg1 = createPackage(root, "pkg1");
        pkg2 = createPackage(pkg1, "pkg2");
        jim = createPackage(pkg2, "jim");
        bob = createPackage(pkg1, "bob");
        pkg3 = createPackage(pkg1, "pkg3");
        pkg4 = createPackage(pkg3, "pkg4");
        pkg5 = createPackage(pkg3, "pkg5");
        george = createPackage(pkg5, "george");
        metaModelManager.installRoot(DomainUtil.nonNullState(root));
        helper.setContext(DomainUtil.nonNullState(metaModelManager.getPivotType("Package")));
    }

	@Override
	@After public void tearDown() throws Exception {
		super.tearDown();
	}

    /**
     * Tests the generic iterate() iterator.
     */
    @Test public void test_iterate_143996() {
    	CollectionTypeId typeId = TypeId.SET.getSpecializedId(TypeId.STRING);
    	SetValue expected = idResolver.createSetOfEach(typeId, "pkg2", "bob", "pkg3");

        // complete form
        assertQueryEquals(pkg1, expected, "ownedPackages->iterate(p; s : Set(String) = Set{} | s->including(p.name))");

        // shorter form
        assertQueryEquals(pkg1, expected, "ownedPackages->iterate(p; s : Set(String) = Set{} | s->including(p.name))");

        // shortest form
        assertQueryEquals(pkg1, expected, "ownedPackages->iterate(s : Set(String) = Set{} | s->including(name))");

        assertQueryEquals(pkg1, "pfx_a_b_c", "Sequence{'a','b','c'}->iterate(e : String; s : String = 'pfx' | s + '_' + e)");
    }
    
    /**
     * Tests the select() iterator.
     */
	@Test public void test_select() {
    	@SuppressWarnings("null") @NonNull Type packageType = metaModelManager.getPivotType("Package");
		CollectionTypeId typeId = TypeId.SET.getSpecializedId(packageType.getTypeId());
		CollectionValue expected = idResolver.createSetOfEach(typeId, pkg2, pkg3);

        // complete form
        assertQueryEquals(pkg1, expected, "ownedPackages->select(p : ocl::Package | p.name <> 'bob')");

        // shorter form
        assertQueryEquals(pkg1, expected, "ownedPackages->select(p | p.name <> 'bob')");

        // shortest form
        assertQueryEquals(pkg1, expected, "ownedPackages->select(name <> 'bob')");

        Value expected2 = idResolver.createSetOfEach(typeId, bob, pkg2, pkg3);
        assertQueryEquals(pkg1, expected2, "ownedPackages->select(true)");
    }

    /**
     * Tests the reject() iterator.
     */
    @Test public void test_reject() {
    	@SuppressWarnings("null") @NonNull Type packageType = metaModelManager.getPivotType("Package");
		CollectionTypeId typeId = TypeId.SET.getSpecializedId(packageType.getTypeId());
		CollectionValue expected = idResolver.createSetOfEach(typeId, pkg2, pkg3);

        // complete form
        assertQueryEquals(pkg1, expected, "ownedPackages->reject(p : ocl::Package | p.name = 'bob')");

        // shorter form
        assertQueryEquals(pkg1, expected, "ownedPackages->reject(p | p.name = 'bob')");

        // shortest form
        assertQueryEquals(pkg1, expected, "ownedPackages->reject(name = 'bob')");

        expected = idResolver.createSetOfEach(typeId);
        assertQueryEquals(pkg1, expected, "ownedPackages->reject(true)");
    }

    /**
     * Tests the any() iterator.
     */
    @Test public void test_any() {
        // complete form
    	assertQueryEquals(pkg1, bob, "ownedPackages->any(p : ocl::Package | p.name = 'bob')");

        // shorter form
    	assertQueryEquals(pkg1, bob, "ownedPackages->any(p | p.name = 'bob')");

        // shortest form
    	assertQueryEquals(pkg1, bob, "ownedPackages->any(name = 'bob')");

        // negative
        assertQueryNotSame(pkg1, bob, "ownedPackages->any(name = 'pkg2')");

        assertQueryInvalid(null, "Sequence{}->any(s | s = false)");		// OMG Issue 18504
        assertQueryFalse(null, "Sequence{false}->any(s | s = false)");
        assertQueryFalse(null, "Sequence{false, false}->any(s | s = false)");

        assertQueryInvalid(null, "Sequence{}->any(s | s = null)");		// OMG Issue 18504
        assertQueryNull(null, "Sequence{null}->any(s | s = null)");
        assertQueryNull(null, "Sequence{null, null}->any(s | s = null)");

        assertQueryDefined(pkg1, "ownedPackages->any(true)");
        assertQueryInvalid(pkg1, "ownedPackages->any(false)");			// OMG Issue 18504
    }

    /**
     * Tests the isUnique() iterator.
     */
    @Test public void test_isUnique_126861() {
//    	Abstract2Moniker.TRACE_MONIKERS.setState(true);
        assertQueryTrue(pkg1, "Sequence{'a', 'b', 'c', 'd', 'e'}->isUnique(e | e)");

        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'c', 'c', 'e'}->isUnique(e | e)");

        // when there are no values, they implicitly all evaluate to a
        // different result
        assertQueryTrue(pkg1, "Sequence{}->isUnique(e | e)");
        assertQueryTrue(pkg1, "Sequence{null}->isUnique(e | e)");
        assertQueryTrue(pkg1, "Sequence{null,1}->isUnique(e | e)");
        assertQueryFalse(pkg1, "Sequence{null,null}->isUnique(e | e)");

        assertQueryTrue(pkg1, "ownedPackages->isUnique(name)");
    }

    /**
     * Tests the exists() iterator.
     */
    @Test public void test_exists() {
    	assertQueryFalse(null, "Sequence{Sequence{false}, Sequence{false}, Sequence{false}, Sequence{false}}->exists(e | e->first())");
    	assertQueryTrue(null, "Sequence{Sequence{false}, Sequence{true}, Sequence{false}, Sequence{false}}->exists(e | e->first())");
    	assertQueryTrue(null, "Sequence{Sequence{false}, Sequence{true}, Sequence{null}, Sequence{true}}->exists(e | e->first())");
    	assertQueryNull(null, "Sequence{Sequence{false}, Sequence{false}, Sequence{null}, Sequence{false}}->exists(e | e->first())");
    	assertQueryTrue(null, "Sequence{Sequence{false}, Sequence{true}, Sequence{null}, Sequence{}}->exists(e | e->first())");
    	assertQueryInvalid(null, "Sequence{Sequence{false}, Sequence{false}, Sequence{null}, Sequence{}}->exists(e | e->first())");
    	assertQueryInvalid(null, "Sequence{Sequence{false}, Sequence{false}, Sequence{}, Sequence{null}}->exists(e | e->first())");
       	assertQueryInvalid(null, "Sequence{Sequence{false}, Sequence{false}, Sequence{false}, Sequence{}}->exists(e | e->first())");

        assertQueryTrue(pkg1, "Sequence{'a', 'b', 'c', 'd', 'e'}->exists(e | e = 'c')");

        assertQueryTrue(pkg1, "Sequence{'a', 'b', 'c', 'c', 'e'}->exists(e | e = 'c')");

        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'd', 'e'}->exists(e | e = 'c')");

        // when there are no values, they the desired result implictly
        // does not occur
        assertQueryFalse(pkg1, "Sequence{}->exists(e | e = 'c')");

        assertQueryTrue(pkg1, "ownedPackages->exists(true)");
    }

    /**
     * Tests the forAll() iterator.
     */
    @Test public void test_forAll() {
    	assertQueryTrue(null, "Sequence{Sequence{true}, Sequence{true}, Sequence{true}, Sequence{true}}->forAll(e | e->first())");
    	assertQueryFalse(null, "Sequence{Sequence{true}, Sequence{false}, Sequence{true}, Sequence{true}}->forAll(e | e->first())");
    	assertQueryFalse(null, "Sequence{Sequence{true}, Sequence{false}, Sequence{null}, Sequence{false}}->forAll(e | e->first())");
    	assertQueryNull(null, "Sequence{Sequence{true}, Sequence{true}, Sequence{null}, Sequence{true}}->forAll(e | e->first())");
       	assertQueryFalse(null, "Sequence{Sequence{true}, Sequence{false}, Sequence{null}, Sequence{}}->forAll(e | e->first())");
       	assertQueryInvalid(null, "Sequence{Sequence{true}, Sequence{true}, Sequence{null}, Sequence{}}->forAll(e | e->first())");
       	assertQueryInvalid(null, "Sequence{Sequence{true}, Sequence{true}, Sequence{}, Sequence{null}}->forAll(e | e->first())");
       	assertQueryInvalid(null, "Sequence{Sequence{true}, Sequence{true}, Sequence{true}, Sequence{}}->forAll(e | e->first())");

        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'c', 'd', 'e'}->forAll(e | e = 'c')");

        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'd', 'e'}->forAll(e | e = 'c')");

        assertQueryTrue(pkg1, "Sequence{'c', 'c', 'c', 'c'}->forAll(e | e = 'c')");

        assertQueryTrue(pkg1, "Sequence{'c'}->forAll(e | e = 'c')");

        // when there are no values, they implicitly all evaluate to the
        // desired result
        assertQueryTrue(pkg1, "Sequence{}->forAll(e | e = 'c')");

        assertQueryTrue(pkg1, "ownedPackages->forAll(true)");
        //
        assertQueryTrue(pkg1, "Sequence{1..0}->forAll(false)");
        assertQueryFalse(pkg1, "Sequence{1..1}->forAll(false)");
    }

    /**
     * Tests the one() iterator.
     */
    @Test public void test_one() {
        assertQueryTrue(pkg1, "Sequence{'a', 'b', 'c', 'd', 'e'}->one(e | e = 'c')");

        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'c', 'c', 'e'}->one(e | e = 'c')");

        assertQueryFalse(pkg1, "Sequence{'a', 'b', 'd', 'e'}->one(e | e = 'c')");

        assertQueryTrue(pkg1, "Sequence{'a'}->one(true)");
    }
    
    /**
     * Tests the collect() iterator.
     */
    @Test public void test_collect() {
//    	Abstract2Moniker.TRACE_MONIKERS.setState(true);
    	@SuppressWarnings("null") @NonNull Type packageType = metaModelManager.getPivotType("Package");
		CollectionTypeId typeId = TypeId.BAG.getSpecializedId(packageType.getTypeId());
        CollectionValue expected1 = idResolver.createBagOfEach(typeId, "pkg2", "bob", "pkg3");

        // complete form
        assertQueryEquals(pkg1, expected1, "ownedPackages->collect(p : ocl::Package | p.name)");

        // shorter form
        assertQueryEquals(pkg1, expected1, "ownedPackages->collect(p | p.name)");

        // yet shorter form
        assertQueryEquals(pkg1, expected1, "ownedPackages->collect(name)");

        // shortest form
        assertQueryEquals(pkg1, expected1, "ownedPackages.name");

        // flattening of nested collections
        CollectionValue expected2 = idResolver.createBagOfEach(typeId, jim, pkg4, pkg5);
        // ownedPackages is Set<Package>
        // ownedPackages->collectNested(ownedPackages) is Bag<Set<Package>>
        // ownedPackages->collectNested(ownedPackages)->flatten() is Bag<Package>
        assertQueryEquals(pkg1, expected2, "ownedPackages.ownedPackages");
        assertQueryResults(pkg1, "Sequence{1,2}", "let s:Sequence(OclAny) = Sequence{'a','bb'} in s->collect(oclAsType(String)).size()");
    }

	/**
     * Tests that parsing fails, in the case of an unknown property in a
     * collection navigation, with an appropriate parse failure, not a
     * <code>ClassCastException</code>.
     */
    @Test public void test_implicitCollect_unknownAttribute_232669() {
        assertBadInvariant(SemanticException.class, Diagnostic.ERROR,
    		"ownedPackages.unknownAttribute",
        	OCLMessages.UnresolvedProperty_ERROR_, "Set(Package)", "unknownAttribute");
   }

    /**
     * Tests that parsing fails, in the case of an unknown operation in a
     * collection navigation, with an appropriate parse failure, not a
     * <code>ClassCastException</code>.
     */
    @Test public void test_implicitCollect_unknownOperation_232669() {
    	assertBadInvariant(SemanticException.class, Diagnostic.ERROR,
    		"ownedPackages.unknownOperation(self)",
        	OCLMessages.UnresolvedOperationCall_ERROR_, "Set(Package)", "unknownOperation", "self");
   }

    /**
     * Tests that the collect() iterator correctly flattens its result.
     */
    @Test public void test_collect_flattens_217461() {
        String self = "foo";
    	CollectionTypeId typeId = TypeId.SEQUENCE.getSpecializedId(TypeId.STRING);
        SequenceValue expected = idResolver.createSequenceOfEach(typeId, "THIS AND", "THAT", "THE OTHER");

        assertQueryEquals(self, expected, "Sequence{Sequence{'this and', 'that'}, Sequence{'the other'}}->collect(s : Sequence(String) | s.toUpperCase())");
    }

    /**
     * Tests that the collect() iterator correctly deals with empty collections.
     */
    @Test public void test_collect_empty_217461() {
        String self = "foo";
        List<String> expected = Collections.emptyList();

        assertQueryEquals(self, expected, "let c : Sequence(OrderedSet(String)) = Sequence{} in c->collect(s : OrderedSet(String) | s.toUpperCase())");
    }

    /**
     * Tests the collectNested() iterator.
     */
    @Test public void test_collectNested() {
    	@SuppressWarnings("null") @NonNull Type packageType = metaModelManager.getPivotType("Package");
		CollectionTypeId typeId = TypeId.BAG.getSpecializedId(packageType.getTypeId());
        CollectionValue expected1 = idResolver.createBagOfEach(typeId, "pkg2", "bob", "pkg3");

        // complete form
        assertQueryEquals(pkg1, expected1, "ownedPackages->collectNested(p : ocl::Package | p.name)");

        // shorter form
        assertQueryEquals(pkg1, expected1, "ownedPackages->collectNested(p | p.name)");

        // shortest form
        assertQueryEquals(pkg1, expected1, "ownedPackages->collectNested(name)");

        // nested collections not flattened
		Set<org.eclipse.ocl.examples.pivot.Package> e1 = Collections.singleton(jim);
        Set<?> e2 = Collections.EMPTY_SET;
        HashSet<Object> e3 = new HashSet<Object>(Arrays.asList(new Object[] {pkg4, pkg5}));
		CollectionValue expected2 = idResolver.createBagOfEach(typeId, e1, e2, e3);

        assertQueryEquals(pkg1, expected2, "ownedPackages->collectNested(ownedPackages)");
        // Bug 423489 - ensure return is collection of body type not source type
        assertQueryResults(pkg1, "Sequence{1,2}", "let s:Sequence(OclAny) = Sequence{'a','bb'} in s->collectNested(oclAsType(String)).size()");
        assertQueryResults(pkg1, "Sequence{Sequence{1,2},Sequence{3,4}}", "let s:Sequence(Sequence(OclAny)) = Sequence{Sequence{'a','bb'},Sequence{'ccc','dddd'}} in s->collectNested(oclAsType(Sequence(String)))->collectNested(s | s.size())");
        // Bug 423490 - ensure nested iteration uses iterator as implicit source
        assertQueryResults(pkg1, "Sequence{2,1}", "let s:Sequence(Sequence(OclAny)) = Sequence{Sequence{'a','bb'},Sequence{'ccc'}} in s->collectNested(size())");
    }

    /**
     * Tests the sortedBy() iterator.
     */
    @Test public void test_sortedBy() {
    	@SuppressWarnings("null") @NonNull Type packageType = metaModelManager.getPivotType("Package");
		CollectionTypeId typeId = TypeId.ORDERED_SET.getSpecializedId(packageType.getTypeId());
        OrderedSetValue expectedSet = idResolver.createOrderedSetOfEach(typeId, bob, pkg2, pkg3);

        // complete form
        assertQueryEquals(pkg1, expectedSet, "ownedPackages->sortedBy(p : ocl::Package | p.name)");

        // shorter form
        assertQueryEquals(pkg1, expectedSet, "ownedPackages->sortedBy(p | p.name)");

        // shortest form
        assertQueryEquals(pkg1, expectedSet, "ownedPackages->sortedBy(name)");

    	CollectionTypeId stringsTypeId = TypeId.SEQUENCE.getSpecializedId(TypeId.STRING);
        SequenceValue expected = idResolver.createSequenceOfEach(stringsTypeId, "a", "b", "c", "d", "e");
        assertQueryEquals(pkg1, expected, "Bag{'d', 'b', 'e', 'a', 'c'}->sortedBy(e | e)");
        assertQueryResults(null, "Sequence{'x', 'aa', 'zzz', 'zzz', 'zzz', 'yyyy', 'yyyy'}", "Bag{'x', 'yyyy', 'zzz', 'aa', 'zzz', 'yyyy', 'zzz'}->sortedBy(size())");
    }

    /**
     * Tests the closure() iterator.
     */
    // pkg1
    // pkg1::pkg2
    // pkg1::pkg2::jim
    // pkg1::bob
    // pkg1::pkg3
    // pkg1::pkg3::pkg4
    // pkg1::pkg3::pkg5
    // pkg1::pkg3::pkg5::george
    @Test public void test_closure() {
    	@SuppressWarnings("null") @NonNull Type packageType = metaModelManager.getPivotType("Package");
		CollectionTypeId typeId = TypeId.SET.getSpecializedId(packageType.getTypeId());
    	CollectionValue expected1 = idResolver.createSetOfEach(typeId, pkg1, pkg3, pkg5, george); // closure does include sources (george)
        assertQueryEquals(george, expected1, "self.oclAsType(Package)->closure(owningPackage)");

        CollectionValue expected2 = idResolver.createSetOfEach(typeId, pkg1, pkg2, jim, bob, pkg3, pkg4, pkg5, george);
//        CollectionValue expected2a = metaModelManager.createOrderedSetValue(null, pkg2, jim, bob, pkg3, pkg4, pkg5, george);
        assertQueryEquals(pkg1, expected2, "self.oclAsType(Package)->closure(ownedPackages)");
// FIXME not a valid test for UML's unordered nested packages
//        assertQueryEquals(pkg1, expected2a, "self->asSequence()->closure(ownedPackages)");
        assertQueryEquals(pkg1, expected2, "self.oclAsType(Package)->closure(ownedPackages->asSequence())");
	    SetValue expected3 = idResolver.createSetOfEach(typeId, pkg1, pkg2, jim, bob, pkg3, pkg4, pkg5, george);
        assertQueryEquals(pkg1, expected3, "self.oclAsType(Package)->asBag()->closure(ownedPackages)");
        assertQueryEquals(pkg1, expected3, "self.oclAsType(Package)->closure(ownedPackages->asBag())");

        // empty closure
        CollectionTypeId collectedId = expected1.getTypeId();
//        @SuppressWarnings("unused") DomainType elementType = collectionType.getElementType();
		assertQueryEquals(pkg1, idResolver.createSetOfEach(collectedId, pkg1), "self.oclAsType(Package)->closure(owningPackage)");
//WIP        assertQueryNotEquals(pkg1, getEmptySetValue(), "self->closure(owningPackage)");
        // empty closure
        assertQueryEquals(pkg1, idResolver.createOrderedSetOfEach(collectedId, pkg1), "self.oclAsType(Package)->asSequence()->closure(owningPackage)");
//WIP 		assertQueryNotEquals(pkg1, metaModelManager.createOrderedSetValue(metaModelManager.getOrderedSetType(elementType)), "self->asSequence()->closure(owningPackage)");
    }

    /**
     * Tests that the closure() iterator handles cycles.
     */
    @Test public void test_closure_cycles() {
    	@SuppressWarnings("null") @NonNull org.eclipse.ocl.examples.pivot.Class packageMetaclass = metaModelManager.getPivotType("Package");
		CollectionTypeId typeId = TypeId.SET.getSpecializedId(packageMetaclass.getTypeId());
        Property ownedPackages = getAttribute(packageMetaclass, "ownedPackages", packageMetaclass);
        Property owningPackage = getAttribute(packageMetaclass, "owningPackage", packageMetaclass);
        SetValue expected = idResolver.createSetOfEach(typeId, ownedPackages, owningPackage); // cyclic closure *does* include self
        assertQueryEquals(owningPackage, expected, "self->closure(opposite)");
        assertQueryEquals(ownedPackages, expected, "self->closure(opposite)");
    }

    /**
     * Tests parsing the closure of operation calls.
     */
    @Test public void test_closure_operations() {
    	Resource fakeResource = new XMIResourceFactoryImpl().createResource(URI.createURI("fake"));
    	Root fakeRoot = metaModelManager.createRoot(null);
    	org.eclipse.ocl.examples.pivot.Package fakePkg = createPackage(fakeRoot, "fake");
    	fakeResource.getContents().add(fakePkg);
        org.eclipse.ocl.examples.pivot.Class fake = createOwnedClass(fakePkg, "Fake", false);
        createGeneralization(fake, metaModelManager.getOclAnyType());
        Operation getFakes = createOwnedOperation(fake, "getFakes", null, null, fake, true);
        getFakes.setType(metaModelManager.getSetType(fake, null, null));

        assertQuery(fake, "self->closure(getFakes())");
    }

    /**
     * Tests the validation of the closure() iterator.
     *
    @Test public void test_closureValidation() {
        // non-recursive reference
        assertQueryInvalid(pkg1, "self->closure(xyzzy)");
        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"self->closure(ownedType)",
        	OCLMessages.NonStd_Iterator_, "closure");
    } */

    /**
     * Tests the validation of the closure() iterator for conformance of the
     * body type with the iterator variable (source element) type.
     */
    @Test public void test_closureValidation_typeConformance_154695() {
    	Resource fakeResource = new XMIResourceFactoryImpl().createResource(URI.createURI("fake"));
    	Root fakeRoot = metaModelManager.createRoot(null);
    	org.eclipse.ocl.examples.pivot.Package fakePkg = createPackage(fakeRoot, "fake");
    	fakeResource.getContents().add(fakePkg);
        org.eclipse.ocl.examples.pivot.Class fake = createOwnedClass(fakePkg, "Fake", false);
        @SuppressWarnings("unused")
        Operation getFakes = createOwnedOperation(fake, "getFakes", null, null, metaModelManager.getSetType(fake, null, null), true);

        // subclass the Fake class
        org.eclipse.ocl.examples.pivot.Class subFake = createOwnedClass(fakePkg, "Subfake", false);
        createGeneralization(subFake, fake);
        createGeneralization(fake, metaModelManager.getOclAnyType());

        // get sub-fakes from a fake
        @SuppressWarnings("unused")
		Operation getSubFakes = createOwnedOperation(fake, "getSubFakes", null, null, metaModelManager.getSetType(subFake, null, null), true);
 
        helper.setContext(subFake);

        // this should not parse because the result of the closure
        // expression
        // is more general than the iterator variable, so cannot be
        // assigned recursively
        assertValidationErrorQuery("self->closure(getFakes())",
        	OCLMessages.IncompatibleBodyType_WARNING_, fake, subFake);

        // this should parse OK because the result of the closure expression
        // is more specific than the iterator variable, so it can be
        // assigned recursively
        assertQuery(fake, "self->closure(getSubFakes())");
    }
    /**
     * Tests that the closure() body is not necessarily compatible.
     */
    @Test public void test_closure_body_393509() {
    	@SuppressWarnings("null") @NonNull org.eclipse.ocl.examples.pivot.Class packageMetaclass = metaModelManager.getPivotType("Package");
    	@SuppressWarnings("null") @NonNull org.eclipse.ocl.examples.pivot.Class propertyMetaclass = metaModelManager.getPivotType("Property");
		CollectionTypeId typeId = TypeId.SET.getSpecializedId(packageMetaclass.getTypeId());
        Property owningPackage = getAttribute(packageMetaclass, "owningPackage", packageMetaclass);
        SetValue expected = idResolver.createSetOfEach(typeId, owningPackage, packageMetaclass, packageMetaclass.eContainer(), packageMetaclass.eContainer().eContainer());
        assertQueryEquals(owningPackage, expected, "self->closure(i : OclElement | i.oclContainer())");
		assertValidationErrorQuery2(propertyMetaclass, "self->closure(oclContainer())", OCLMessages.IncompatibleBodyType_WARNING_, "OclElement", "Property");
    }

    @SuppressWarnings("unchecked")
	@Test public void test_closure_recursions_401302() throws IOException {
    	if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
    		OCLinEcoreStandaloneSetup.doSetup();
    	}
		MetaModelManager metaModelManager = new MetaModelManager();
		String nodeModel =
			"package nodes : nodes = 'http://nodes'{\n" +
//			"    class Root {\n" +
//			"    	property nodes : Node[*] {composes};\n" +
//			"	 }\n" +
			"    class Node {\n" +
			"    	property nodes : Node[*] {ordered,!unique};\n" +
			"    	property name : String;\n" +
			"	 }\n" +
			"}\n";
		URI uri = createEcoreFile(metaModelManager, "NodeModel", nodeModel);
		metaModelManager.dispose();
		Resource ecoreResource = resourceSet.getResource(uri, true);
		EPackage nodesEPackage = (EPackage) ecoreResource.getContents().get(0);
//		EClass rootEClass = (EClass) nodesEPackage.getEClassifier("Root");
		EClass nodeEClass = (EClass) nodesEPackage.getEClassifier("Node");
		EAttribute nameEAttribute = (EAttribute) nodeEClass.getEStructuralFeature("name");
		EReference nodesEReference = (EReference) nodeEClass.getEStructuralFeature("nodes");
		EFactory nodesEFactory = nodesEPackage.getEFactoryInstance();
//		EObject root = nodesEFactory.create(rootEClass);
		EObject node1 = nodesEFactory.create(nodeEClass);
		EObject node2 = nodesEFactory.create(nodeEClass);
		EObject node3 = nodesEFactory.create(nodeEClass);
		EObject node4 = nodesEFactory.create(nodeEClass);
		EObject node5 = nodesEFactory.create(nodeEClass);
		node1.eSet(nameEAttribute, "node1");
		node2.eSet(nameEAttribute, "node2");
		node3.eSet(nameEAttribute, "node3");
		node4.eSet(nameEAttribute, "node4");
		node5.eSet(nameEAttribute, "node5");
		//
		((List<EObject>)node1.eGet(nodesEReference)).add(node2);
		//
		((List<EObject>)node2.eGet(nodesEReference)).add(node1);
		((List<EObject>)node2.eGet(nodesEReference)).add(node1);			// This repetition terminated recursion erroneously
		((List<EObject>)node2.eGet(nodesEReference)).add(node2);
		((List<EObject>)node2.eGet(nodesEReference)).add(node3);
		((List<EObject>)node2.eGet(nodesEReference)).add(node4);
		((List<EObject>)node2.eGet(nodesEReference)).add(node5);
		((List<EObject>)node2.eGet(nodesEReference)).add(node2);
		((List<EObject>)node2.eGet(nodesEReference)).add(node1);
		((List<EObject>)node2.eGet(nodesEReference)).add(node1);
		assertQueryEquals(node1, 5, "self->closure(nodes)->size()");
	}	

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    @Test public void test_forAll_invalidBody_142518() {
    	assertQueryInvalid(null, "Bag{1, 2, 3}->forAll('true')");		// Bug 415669
    	assertQueryInvalid(null, "Bag{1, 2, 3}->forAll(2)");			// Bug 415669

    	assertQueryNull(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->forAll(b and b)");

        // check that the "check" API interprets invalid as a constraint
        // violation
        assertInvariantFalse(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1}->forAll(b and b)");

        // same deal for a null value (in the forAll case)
        assertQueryNull(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->forAll(null.oclAsType(Boolean))");
    	assertQueryInvalid(EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->forAll(Sequence{}->first())");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    @Test public void test_exists_invalidBody_142518() {
    	assertQueryInvalid(null, "Bag{1, 2, 3}->exists('true')");		// Bug 415669
    	assertQueryInvalid(null, "Bag{1, 2, 3}->exists(2)");			// Bug 415669

    	assertQueryNull(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->exists(b and b)");

        // same deal for a null value (in the exists case)
    	assertQueryNull(EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->exists(null.oclAsType(Boolean))");
    	assertQueryInvalid(EcorePackage.eINSTANCE,
                "Bag{1, 2, 3}->exists(Sequence{}->first())");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    @Test public void test_one_invalidBody_142518() {
    	assertQueryInvalid(null, "Bag{1, 2, 3}->one('true')");		// Bug 415669
    	assertQueryInvalid(null, "Bag{1, 2, 3}->one(2)");			// Bug 415669

    	assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->one(b and b)");

        // same deal for a null value (in the one case)
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->one(null.oclAsType(Boolean))");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    @Test public void test_any_invalidBody_142518() {
	    assertQueryInvalid(null, "Bag{1, 2, 3}->any('true')");		// Bug 415669
	    assertQueryInvalid(null, "Bag{1, 2, 3}->any(2)");			// Bug 415669   	
    	
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->any(b and b)");

        // same deal for a null value (in the any case)
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->any(null.oclAsType(Boolean))");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    @Test public void test_select_invalidBody_142518() {
    	assertQueryInvalid(null, "Bag{1, 2, 3}->select('true')");		// Bug 415669
    	assertQueryInvalid(null, "Bag{1, 2, 3}->select(2)");			// Bug 415669
    	
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->select(b and b)");

        // same deal for a null value (in the exists case)
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->select(null.oclAsType(Boolean))");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    @Test public void test_reject_invalidBody_142518() {
    	assertQueryInvalid(null, "Bag{1, 2, 3}->reject('true')");		// Bug 415669
    	assertQueryInvalid(null, "Bag{1, 2, 3}->reject(2)");			// Bug 415669

    	assertQueryInvalid(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->reject(b and b)");

        // same deal for a null value (in the exists case)
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->reject(null.oclAsType(Boolean))");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the
     * isUnique iterator expression treats it like any other value.
     */
    @Test public void test_isUnique_invalidBody_142518() {
    	assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->isUnique(Sequence{}->first())");

        assertQueryFalse(EcorePackage.eINSTANCE,
            "let b:Boolean = null in Bag{1, 2, 3}->isUnique(null)");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    @Test public void test_collect_invalidBody_142518() {
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->collect(Sequence{}->first())");

        // in the case of a null value, null is allowed in a collection, so
        // it does not result in invalid
    	CollectionTypeId typeId = TypeId.BAG.getSpecializedId(TypeId.OCL_ANY);
        BagValue expected = idResolver.createBagOfEach(typeId, getNull(), getNull(), getNull());
        assertQueryEquals(EcorePackage.eINSTANCE, expected,
            "let b:Boolean = null in Bag{1, 2, 3}->collect(null)");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
	@Test public void test_collectNested_invalidBody_142518() {
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->collectNested(Sequence{}->first())");

        // in the case of a null value, null is allowed in a collection, so
        // it does not result in invalid
    	Set<BigInteger> e1 = Collections.singleton(BigInteger.valueOf(1));
    	Object e2 = getNull();
    	Set<BigInteger> e3 = Collections.singleton(BigInteger.valueOf(3));
    	CollectionTypeId typeId = TypeId.BAG.getSpecializedId(TypeId.INTEGER);
        BagValue expected = idResolver.createBagOfEach(typeId, e1, e2, e3);
        assertQueryEquals(EcorePackage.eINSTANCE, expected,
            "let b:Boolean = null in Bag{1, 2, 3}->collectNested(e | if e = 2 then null else Set{e} endif)");
    }

    /**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    @Test public void test_closure_invalidBody_142518() {
        assertQueryInvalid(getUMLMetamodel(),
            "let c : ocl::Type = invalid in ownedType->closure(c)", EvaluatorMessages.InvalidLiteral, InvalidValueException.class);

        // in the case of a null value, null is allowed in a collection, so
        // it does not result in invalid
        assertQueryResults(null, "Set{5, null}",
    		"let c : Set(UnlimitedNatural) = Set{null} in 5->closure(c)");
 
//        Set<Object> expected = Collections.singleton(getNull());
//        assertQueryEquals(EcorePackage.eINSTANCE, expected,
//        	"let c : Set(ocl::Type) = Set{null} in ownedType->closure(c)");
    }

	/**
     * Tests that when the body of an iterator results in invalid, the entire
     * iterator expression's value is invalid.
     */
    @Test public void test_sortedBy_invalidBody_142518() {
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "let s : String = null in Bag{1, 2, 3}->sortedBy(s.size())", DomainUtil.bind(EvaluatorMessages.TypedValueRequired, TypeId.STRING_NAME, ValuesUtil.getTypeName(null)), InvalidValueException.class);

        // same deal for null values
        assertQueryInvalid(EcorePackage.eINSTANCE,
            "Bag{1, 2, 3}->sortedBy(null.oclAsType(Integer))", DomainUtil.bind(EvaluatorMessages.UndefinedBody, "sortedBy"), InvalidValueException.class);

    }

    /**
     * Tests that the generic iterate() iterator returns invalid when the
     * source collection is null or invalid.
     */
    @Test public void test_iterateWithNullSource_143996() {
        assertQueryInvalid(pkg1,
            "let e : Collection(ocl::Package) = null in e->iterate(" +
                "p : ocl::Package; s : String = '' | s.concat(p.name))", DomainUtil.bind(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_NAME, ValuesUtil.getTypeName(null)), InvalidValueException.class);

        assertQueryInvalid(pkg1,
            "let e : Collection(ocl::Package) = invalid in e->iterate(" +
                "p : ocl::Package; s : String = '' | s.concat(p.name))", EvaluatorMessages.InvalidLiteral, InvalidValueException.class);
    }

    /**
     * Tests that the exists() iterator return invalid when the source
     * collection is null or invalid.
     */
    @Test public void test_existsWithNullSource_143996() {
    	assertQueryInvalid(pkg1,
            "let e : Collection(ocl::Package) = null in e->exists(" +
                "p : ocl::Package | p.name = 'bob')", DomainUtil.bind(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_NAME, ValuesUtil.getTypeName(null)), InvalidValueException.class);

    	assertQueryInvalid(pkg1,
            "let e : Collection(ocl::Package) = invalid in e->exists(" +
                "p : ocl::Package | p.name = 'bob')", EvaluatorMessages.InvalidLiteral, InvalidValueException.class);
    }

    /**
     * Tests the exists iterator with multiple iterator variables.
     */
    @Test public void test_exists_multipleIteratorVariables() {
        assertInvariantTrue(pkg1, "Sequence{1, 2, 3, 4}->exists(e1, e2 | e1 = e2)");
        assertInvariantTrue(pkg1, "Sequence{1, 2, 3, 4}->exists(e1, e2 | (e1 + e2) = 7)");
        assertInvariantFalse(pkg1, "Sequence{1, 2, 3, 4}->exists(e1, e2 | (e1 + e2) = 0)");

        // when there are no values, the the desired result implictly
        // does not occur
        assertInvariantFalse(pkg1, "Sequence{}->exists(e1, e2 | e1 = e2)");
    }

    /**
     * Tests the forAll iterator with multiple iterator variables.
     */
    @Test public void test_forAll_multipleIteratorVariables() {
    	assertInvariantFalse(pkg1, "Sequence{1, 2, 3, 4}->forAll(e1, e2 | e1 = e2)");

        assertInvariantTrue(pkg1, "Sequence{1, 2, 3, 4}->forAll(e1, e2 | (e1 + e2) > e1)");

	    // when there are no values, the the desired result implictly occurs
	    assertInvariantTrue(pkg1, "Sequence{}->forAll(e1, e2 | e1 = e2)");
    }

    /**
     * Tests the validation the number of iterator variables for iterators that
     * do not support multiple variables.
     */
    @Test public void test_invalidMultipleIteratorVariables() {
        assertBadQuery(SemanticException.class, Diagnostic.ERROR,		// FIXME Bug 296990
        	"Sequence{'a', 'b', 'c'}->exists(e1, e2, e3 | e1 = e2)",
        	OCLMessages.UnresolvedOperationCall_ERROR_, "Sequence(String)", "exists", "e1, e2, e3| e1 = e2");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,		// FIXME Bug 296990
        	"Sequence{'a', 'b', 'c'}->forAll(e1, e2, e3 | e1 = e2)",
        	OCLMessages.UnresolvedOperationCall_ERROR_, "Sequence(String)", "forAll", "e1, e2, e3| e1 = e2");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->collect(e1, e2 | Tuple{a : String = e1, b : String = e2})",
        	OCLMessages.UnresolvedOperationCall_ERROR_, "Sequence(String)", "collect", "e1, e2| Tuple{a : String = e1, b : String = e2}");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->any(e1, e2 | e1 = e2)",
        	OCLMessages.UnresolvedOperationCall_ERROR_, "Sequence(String)", "any", "e1, e2| e1 = e2");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->one(e1, e2 | e1 = e2)",
        	OCLMessages.UnresolvedOperationCall_ERROR_, "Sequence(String)", "one", "e1, e2| e1 = e2");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->select(e1, e2 | e1 = e2)",
        	OCLMessages.UnresolvedOperationCall_ERROR_, "Sequence(String)", "select", "e1, e2| e1 = e2");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->reject(e1, e2 | e1 = e2)",
        	OCLMessages.UnresolvedOperationCall_ERROR_, "Sequence(String)", "reject", "e1, e2| e1 = e2");

        assertBadQuery(SemanticException.class, Diagnostic.ERROR,
        	"Sequence{'a', 'b', 'c'}->isUnique(e1, e2 | e1 = e2)",
        	OCLMessages.UnresolvedOperationCall_ERROR_, "Sequence(String)", "isUnique", "e1, e2| e1 = e2");
    }

	/**
     * Test to check the validation of the <tt>sortedBy</tt> iterator, that
     * the body expression type has a <tt>&lt;</tt> operation.
     */
    @Test public void test_sortedByRequiresComparability_192729() {
    	org.eclipse.ocl.examples.pivot.Class context = metaModelManager.getPivotType("Package");
    	org.eclipse.ocl.examples.pivot.Class type = metaModelManager.getPivotType("Class");
     	assertValidationErrorQuery("ownedType->sortedBy(e | e)",
        	OCLMessages.UnresolvedOperation_ERROR_, type + "", LibraryConstants.COMPARE_TO);
       
    	assertQuery(context, "ownedType->sortedBy(e | e.name)");
    	loadEPackage("ecore", EcorePackage.eINSTANCE);
        
        // EDate defines an OclComparable::compareTo by having a java.lang.Comparable instance class
        assertQuery(context, "let dates : Sequence(ecore::EDate) = Sequence{} in dates->sortedBy(e | e)");
        // EInt defines OclComparable::compareTo by having a behavioral mapping to the Integer type
        assertQueryResults(context, "Sequence{1,7,9}", "let values : Sequence(ecore::EInt) = Sequence{1,9,7} in values->sortedBy(e | e)");
    }
}
