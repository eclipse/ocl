/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.test.xtext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.model.OCLMetaModel;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.examples.pivot.utilities.AS2Moniker;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;

import com.google.common.collect.Iterables;

/**
 * Tests.
 */
@SuppressWarnings("null")
public class OCLstdlibTests extends XtextTestCase
{
	public static class MonikeredComparator implements Comparator<Element>
	{
		public static final Comparator<? super Element> INSTANCE = new MonikeredComparator();

		@Override
		public int compare(Element o1, Element o2) {
			String m1 = AS2Moniker.toString(o1);
			String m2 = AS2Moniker.toString(o2);
			return m1.compareTo(m2);
		}
	}

	protected MetaModelManager metaModelManager = null;

	public Map<String, Element> computeMoniker2PivotMap(Collection<? extends Resource> pivotResources) {
		Map<String, Element> map = new HashMap<String, Element>();
		for (Resource asResource : pivotResources) {
			for (Iterator<EObject> it = asResource.getAllContents(); it.hasNext();) {
				EObject eObject = it.next();
				assert eObject.eResource() == asResource;
				if ((eObject instanceof Element) && !(eObject instanceof TemplateParameter) && !(eObject instanceof Comment) /*&& (eObject != orphanagePackage)*/) {
					Element newElement = (Element) eObject;
					String moniker = AS2Moniker.toString(newElement);
					assert moniker != null;
					Element oldElement = map.get(moniker);
					if (oldElement == null) {
						map.put(moniker, newElement);
					}
					else {
						assert newElement.getClass() == oldElement.getClass();
					}
				}
			}
		}
		return map;
	}

	protected Resource doLoadAS(@NonNull ResourceSet resourceSet, @NonNull URI libraryURI, @NonNull Resource javaResource, boolean validateMonikers) {
		Resource asResource = resourceSet.getResource(libraryURI, true);
		assertNoResourceErrors("Load failed", asResource);
		assertNoUnresolvedProxies("File Model", asResource);
		assertNoValidationErrors("File Model", asResource);
//		PivotAliasCreator.refreshPackageAliases(javaResource);
		assertNoResourceErrors("Java Model", javaResource);
		assertNoUnresolvedProxies("Java Model", javaResource);
		assertNoValidationErrors("Java Model", javaResource);
		if (!validateMonikers) {
			return asResource;
		}
		//
		//	Check similar content
		//
		Map<String,Element> fileMoniker2PivotMap = computeMoniker2PivotMap(Collections.singletonList(asResource));
//		for (String moniker : fileMoniker2PivotMap.keySet()) {
//			System.out.println("File : " + moniker);
//		}
		Map<String,Element> javaMoniker2PivotMap = computeMoniker2PivotMap(Collections.singletonList(javaResource));
//		for (String moniker : javaMoniker2PivotMap.keySet()) {
//			System.out.println("Java : " + moniker);
//		}
//		assertEquals(fileMoniker2PivotMap.size(), javaMoniker2PivotMap.size());
		for (String moniker : fileMoniker2PivotMap.keySet()) {
			Element fileElement = fileMoniker2PivotMap.get(moniker);
			Element javaElement = javaMoniker2PivotMap.get(moniker);
			if (javaElement == null) {
				boolean isExpression = false;
				for (EObject eObject = fileElement; eObject != null; eObject = eObject.eContainer()) {
					if ((eObject instanceof ExpressionInOCL) || (eObject instanceof Constraint) || (eObject instanceof Annotation)) {
						isExpression = true;		// Embedded OCL not present in Java
						break;
					}
				}
				if (isExpression) {
					continue;
				}
			}
			assertNotNull("Missing java element for '" + moniker + "'", javaElement);
//			@SuppressWarnings("null")	// Can be null and we'll have an NPE as the test failure.
			Class<? extends Element> javaElementClass = javaElement.getClass();
			assertEquals(fileElement.getClass(), javaElementClass);
			if (fileElement instanceof TypedElement) {
				Type fileType = ((TypedElement)fileElement).getType();
				Type javaType = ((TypedElement)javaElement).getType();
				assertEquals(fileType.getClass(), javaType.getClass());
				String fileMoniker = AS2Moniker.toString(fileType);
				String javaMoniker = AS2Moniker.toString(javaType);
				assertEquals(fileMoniker, javaMoniker);
			}
			if (fileElement instanceof Feature) {
				String fileClass = ((Feature)fileElement).getImplementationClass();
				String javaClass = ((Feature)javaElement).getImplementationClass();
				if (fileClass == null) {
					LibraryFeature implementation = ((Feature)fileElement).getImplementation();
					if (implementation != null) {
						fileClass = implementation.getClass().getCanonicalName();
					}
				}
				if (javaClass == null) {
					LibraryFeature implementation = ((Feature)javaElement).getImplementation();
					if (implementation != null) {
						javaClass = implementation.getClass().getCanonicalName();
					}
				}
				assertEquals(fileClass, javaClass);
			}
			if (fileElement instanceof Type) {
				List<Element> fileTypes = new ArrayList<Element>(((Type)fileElement).getSuperClass());
				List<Element> javaTypes = new ArrayList<Element>(((Type)javaElement).getSuperClass());
				Collections.sort(fileTypes, MonikeredComparator.INSTANCE);
				Collections.sort(javaTypes, MonikeredComparator.INSTANCE);
				assertEquals(fileTypes.size(), javaTypes.size());
				for (int i = 0; i < fileTypes.size(); i++) {
					Element fileType = fileTypes.get(i);
					Element javaType = javaTypes.get(i);
					String fileMoniker = AS2Moniker.toString(fileType);
					String javaMoniker = AS2Moniker.toString(javaType);
					assertEquals(fileMoniker, javaMoniker);
				}
			}
		}
		return asResource;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		metaModelManager = new MetaModelManager();
	}

	@Override
	protected void tearDown() throws Exception {
		MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
		if (adapter != null) {
			MetaModelManager metaModelManager = adapter.getMetaModelManager();
			if (metaModelManager != null) {
				metaModelManager.dispose();
			}
		}
		metaModelManager.dispose();
		metaModelManager = null;
		super.tearDown();
	}
	
	public void testLoadAsString() throws Exception {
		String testFile =
			"library lib : lib = 'http://mylib'{\n"+
			"    type OclAny : AnyType {\n"+
			"    	operation a(elem : Boolean) : Integer {\n"+
			"           post a: elem;\n"+
			"       }\n"+
			"    }\n"+
			"    type Class conformsTo OclAny {}\n"+	
			"    type Boolean : PrimitiveType conformsTo OclAny {}\n"+
			"    type Enumeration conformsTo OclAny {}\n"+
			"    type Integer : PrimitiveType conformsTo Real {}\n"+
			"    type Metaclass(T) : Metaclass conformsTo OclAny {}\n"+
			"    type OclElement conformsTo OclAny {}\n"+
			"    type OclInvalid : InvalidType {}\n"+
			"    type Real : PrimitiveType conformsTo OclAny {}\n"+
			"    type String : PrimitiveType conformsTo OclAny {}\n"+
			"    type UnlimitedNatural : PrimitiveType conformsTo Integer {}\n"+
			"}\n";		
		doLoadFromString("string.oclstdlib", testFile);
	}
	
	public void testImport() throws Exception {
		String testFile =
			"import 'minimal.oclstdlib';\n"+
			"import 'minimal.oclstdlib';\n"+
			"library lib : lib = 'http://minimal.oclstdlib'{\n"+
			"    type OclAny : AnyType {\n"+
			"    	operation a(elem : Boolean) : Boolean {\n"+
			"           post a: result = elem;\n"+
			"       }\n"+
			"    }\n"+
			"}\n";		
		Resource asResource = doLoadASResourceFromString(metaModelManager, "string.oclstdlib", testFile);
		MetaModelManager metaModelManager = MetaModelManager.getAdapter(asResource.getResourceSet());
		AnyType oclAnyType = metaModelManager.getOclAnyType();
		Iterable<? extends DomainOperation> ownedOperations = metaModelManager.getAllOperations(oclAnyType, FeatureFilter.SELECT_NON_STATIC);
		assertEquals(2, Iterables.size(ownedOperations));		// one from OclAny::=
		metaModelManager.dispose();
	}
	
	/**
	 * Checks that the local oclstdlib.oclstdlib is the same as the pre-compiled
	 * Java implementation.
	 * 
	 * FIXME check the library/model version instead.
	 */
	public void testOCLstdlib() throws Exception {
		//
		//	Load OCL stdlib as a file.
		//
		new ProjectMap().initializeResourceSet(resourceSet);
		URI libraryURI = URI.createPlatformResourceURI("org.eclipse.ocl.examples.library/model/OCL-2.5.oclstdlib", true);
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.createResource(libraryURI);
		MetaModelManagerResourceAdapter.getAdapter(xtextResource, metaModelManager);
		xtextResource.load(null);
		CS2PivotResourceAdapter adapter = xtextResource.findCS2ASAdapter();
		assertNoResourceErrors("Load failed", xtextResource);
		Resource fileResource = adapter.getASResource(xtextResource);
		assertNoResourceErrors("File Model", fileResource);
		assertNoUnresolvedProxies("File Model", fileResource);
		assertNoValidationErrors("File Model", fileResource);
		//
		//	Load 'oclstdlib.oclstdlib' as pre-code-generated Java.
		//
		Resource javaResource = OCLstdlib.getDefault();
//		PivotAliasCreator.refreshPackageAliases(javaResource);
		assertNoResourceErrors("Java Model", javaResource);
		assertNoUnresolvedProxies("Java Model", javaResource);
		assertNoValidationErrors("Java Model", javaResource);
		//
		//	Check similar content
		//
		Map<String,Element> fileMoniker2PivotMap = computeMoniker2PivotMap(Collections.singletonList(fileResource));
//		for (String moniker : fileMoniker2PivotMap.keySet()) {
//			System.out.println("File : " + moniker);
//		}
		Map<String,Element> javaMoniker2PivotMap = computeMoniker2PivotMap(Collections.singletonList(javaResource));
//		for (String moniker : javaMoniker2PivotMap.keySet()) {
//			System.out.println("Java : " + moniker);
//		}
//		assertEquals(fileMoniker2PivotMap.size(), javaMoniker2PivotMap.size());
		for (String moniker : fileMoniker2PivotMap.keySet()) {
			Element fileElement = fileMoniker2PivotMap.get(moniker);
			Element javaElement = javaMoniker2PivotMap.get(moniker);
			if (javaElement == null) {
				boolean isExpression = false;
				for (EObject eObject = fileElement; eObject != null; eObject = eObject.eContainer()) {
					if ((eObject instanceof ExpressionInOCL) || (eObject instanceof Constraint) || (eObject instanceof Annotation)) {
						isExpression = true;		// Embedded OCL not present in Java
						break;
					}
				}
				if (isExpression) {
					continue;
				}
			}
			assertNotNull("Missing java element for '" + moniker + "'", javaElement);
//			@SuppressWarnings("null")	// Can be null and we'll have an NPE as the test failure.
			Class<? extends Element> javaElementClass = javaElement.getClass();
			assertEquals(fileElement.getClass(), javaElementClass);
			if (fileElement instanceof TypedElement) {
				Type fileType = ((TypedElement)fileElement).getType();
				Type javaType = ((TypedElement)javaElement).getType();
				assertEquals(fileType.getClass(), javaType.getClass());
				String fileMoniker = AS2Moniker.toString(fileType);
				String javaMoniker = AS2Moniker.toString(javaType);
				assertEquals(fileMoniker, javaMoniker);
			}
			if (fileElement instanceof Feature) {
				String fileClass = ((Feature)fileElement).getImplementationClass();
				String javaClass = ((Feature)javaElement).getImplementationClass();
				if (fileClass == null) {
					LibraryFeature implementation = ((Feature)fileElement).getImplementation();
					if (implementation != null) {
						fileClass = implementation.getClass().getCanonicalName();
					}
				}
				if (javaClass == null) {
					LibraryFeature implementation = ((Feature)javaElement).getImplementation();
					if (implementation != null) {
						javaClass = implementation.getClass().getCanonicalName();
					}
				}
				assertEquals(fileClass, javaClass);
			}
			if (fileElement instanceof Type) {
				List<Element> fileTypes = new ArrayList<Element>(((Type)fileElement).getSuperClass());
				List<Element> javaTypes = new ArrayList<Element>(((Type)javaElement).getSuperClass());
				Collections.sort(fileTypes, MonikeredComparator.INSTANCE);
				Collections.sort(javaTypes, MonikeredComparator.INSTANCE);
				assertEquals(fileTypes.size(), javaTypes.size());
				for (int i = 0; i < fileTypes.size(); i++) {
					Element fileType = fileTypes.get(i);
					Element javaType = javaTypes.get(i);
					String fileMoniker = AS2Moniker.toString(fileType);
					String javaMoniker = AS2Moniker.toString(javaType);
					assertEquals(fileMoniker, javaMoniker);
				}
			}
		}
	}
	
	/**
	 * Checks that the OCL 2.5 AS model is the same as the pre-compiled
	 * Java implementation.
	 */
	public void testOCLstdlib_AS() throws Exception {
		//
		//	Load OCL stdlib as an AS file.
		//
		ResourceSet resourceSet = new ResourceSetImpl();
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {			
			new ProjectMap().initializeResourceSet(resourceSet);
		}
		URI libraryURI = URI.createPlatformResourceURI("org.eclipse.ocl.examples.library/model-gen/OCL-2.5.oclas", true);
		//
		//	Load 'oclstdlib.oclstdlib' as pre-code-generated Java.
		//
		Resource javaResource = OCLstdlib.getDefault();
		Resource asResource = doLoadAS(resourceSet, libraryURI, javaResource, true);
		PivotUtil.getMetaModelManager(asResource).dispose();
	}
	
	/**
	 * Checks that the OCL 2.5 AS model is the same as the pre-compiled
	 * Java implementation.
	 */
	public void testPivot_AS() throws Exception {
		//
		//	Load OCL stdlib as an AS file.
		//
		ResourceSet resourceSet = new ResourceSetImpl();
		new ProjectMap().initializeResourceSet(resourceSet);
		ASResourceFactoryRegistry.INSTANCE.configureResourceSet(resourceSet);
		URI pivotURI = URI.createPlatformResourceURI("org.eclipse.ocl.examples.pivot/model-gen/Pivot.oclas", true);
		//
		//	Load OCLmetamodel as pre-code-generated Java.
		//
		Library asLibrary = (Library) metaModelManager.getOclAnyType().getPackage();
		org.eclipse.ocl.examples.pivot.Package oclMetamodel = OCLMetaModel.create(metaModelManager, asLibrary.getName(), asLibrary.getNsPrefix(), OCLMetaModel.PIVOT_URI);
		Resource javaResource = oclMetamodel.eResource();
		Resource asResource = doLoadAS(resourceSet, pivotURI, javaResource, false);		// FIXME Contents are far from identical
		PivotUtil.getMetaModelManager(asResource).dispose();
	}
}
