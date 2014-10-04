/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.BaseCS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.pivot2cs.OCLinEcorePivot2CS;
import org.eclipse.ocl.examples.xtext.oclstdlib.cs2as.OCLstdlibCS2Pivot;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.JavaClassScope;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;

/**
 * Tests.
 */
public class PivotTests extends XtextTestCase
{
	public static class Checker extends BaseCS2Pivot
	{
		private Checker(@NonNull BaseCS2Pivot aConverter) {
			super(aConverter);
		}

		public void assertContainedBy(@NonNull CS2Pivot thatConverter) {
/*			Map<String, MonikeredElement> thisMoniker2PivotMap = metaModelManager.computeMoniker2PivotMap(getPivotResources());
			Map<String, MonikeredElement> thatMoniker2PivotMap = metaModelManager.computeMoniker2PivotMap(thatConverter.getPivotResources());
			List<String> theseMonikers = new ArrayList<String>(thisMoniker2PivotMap.keySet());
			List<String> thoseMonikers = new ArrayList<String>(thatMoniker2PivotMap.keySet());
			Collections.sort(theseMonikers);
			Collections.sort(thoseMonikers);
			for (String moniker : thisMoniker2PivotMap.keySet()) {
				MonikeredElement thisPivotElement = thisMoniker2PivotMap.get(moniker);
				MonikeredElement thatPivotElement = thatMoniker2PivotMap.get(moniker);
				if (isValidPivot(thisPivotElement) && isValidPivot(thatPivotElement)) {
					assertEquals("Preserved pivot", thisPivotElement, thatPivotElement);
				}
			} */
		}

		public void assertSameContents() { // WIP
/*			Map<String, MonikeredElement> moniker2PivotMap = metaModelManager.computeMoniker2PivotMap(getPivotResources());
			Collection<? extends Resource> csResources = cs2asResourceMap.keySet();
			for (Resource csResource : csResources) {
				for (TreeIterator<EObject> tit = csResource.getAllContents(); tit.hasNext(); ) {
					ElementCS csElement = (ElementCS) tit.next();
					if (csElement instanceof MonikeredElementCS) { //&& !(csElement instanceof TemplateBindingCS) && !(csElement instanceof TemplateParameterSubstitutionCS)) {
						MonikeredElementCS csMonikeredElement = (MonikeredElementCS)csElement;
						if (hasCorrespondingPivot(csMonikeredElement)) {
							String csMoniker = CS2Moniker.toString(csMonikeredElement);
							MonikeredElement actualPivotElement = (MonikeredElement) csMonikeredElement.getPivot();
							if (actualPivotElement == null) {
								@SuppressWarnings("unused")
								MonikeredElement pivotElement = moniker2PivotMap.get(csMoniker);
								fail("Missing pivot for '" + csMoniker + "'");
							}
							else {
								String actualPivotMoniker = actualPivotElement.getMoniker();
								assertEquals("Moniker mismatch", csMoniker, actualPivotMoniker);
								MonikeredElement expectedPivotElement = moniker2PivotMap.get(csMoniker);
								assertEquals("Element mismatch", expectedPivotElement, actualPivotElement);
							}
						}
					}
				}
			} */
/*			Collection<? extends Resource> pivotResources = cs2asResourceMap.values();
			Map<String, MonikeredElementCS> moniker2CSMap = computeMoniker2CSMap(csResources);
			for (Resource asResource : pivotResources) {
				for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
					Element pivotElement = (Element) tit.next();
					if (pivotElement instanceof MonikeredElement) { //&& !(pivotElement instanceof TemplateSignature) && !(pivotElement instanceof TemplateParameterSubstitution) && !(pivotElement instanceof TemplateParameter)) {
						MonikeredElement pivotNameableElement = (MonikeredElement)pivotElement;
						if (hasCorrespondingCS(pivotNameableElement)) {
							String pivotMoniker = pivotNameableElement.getMoniker();
							MonikeredElementCS csNameableElement = moniker2CSMap.get(pivotMoniker);
							MonikeredElement pivotCSElement = (MonikeredElement) csNameableElement.getPivot();
							if (pivotCSElement == null) {
								fail("Missing pivot for '" + pivotElement + "'");
							}
							else {
								assertEquals("Moniker mismatch", pivotMoniker, CS2Moniker.toString(csNameableElement));
								assertEquals("Element mismatch", pivotElement, pivotCSElement);
							}
						}
					}
				}
			} */
		}

/*		public List<EObject> getRoots() {
			List<EObject> roots = new ArrayList<EObject>();
			for (Map.Entry<? extends Resource, ? extends Resource> entry : cs2asResourceMap.entrySet()) {
				roots.addAll(entry.getKey().getContents());
				roots.addAll(entry.getValue().getContents());
			}
			return roots;
		} */
	}

/*	public static class Damager extends Checker
	{
		private Damager(CS2Pivot aConverter) {
			super(aConverter);
		}
		
		public List<MonikeredElement> chooseVictims() {
			List<String> pivotKeys = new ArrayList<String>(moniker2PivotMap.keySet());
			List<MonikeredElement> pivotElements = new ArrayList<MonikeredElement>();
			Collections.sort(pivotKeys);
			int iMax = pivotKeys.size();
			int stepSize = Math.max((int) Math.sqrt(iMax), 1);
			for (int i = iMax-1; i > 0; i -= stepSize) {
//				String moniker = pivotKeys.remove(i);
				String moniker = pivotKeys.get(i);
				MonikeredElement pivotElement = moniker2PivotMap.get(moniker);
				pivotElements.add(pivotElement);
			}
			return pivotElements;
		}

		public void removeAll(Collection<? extends MonikeredElement> pivotElements) {
			Collection<EObject> roots = getRoots();
			Map<EObject, Collection<EStructuralFeature.Setting>> xrefMap = EcoreUtil.CrossReferencer.find(roots);
			for (MonikeredElement pivotElement : pivotElements) {
				String moniker = pivotElement.getMoniker();
				logger.trace("Damage " + pivotElement.eClass().getName() + " : " + moniker); //$NON-NLS-1$
				moniker2PivotMap.remove(moniker);
				EObject eContainer = pivotElement.eContainer();
				if (eContainer != null) {
					EStructuralFeature eContainingFeature = pivotElement.eContainingFeature();
					if (eContainingFeature.isMany()) {
						((List<?>) eContainer.eGet(eContainingFeature)).remove(pivotElement);
					}
					else {
						eContainer.eSet(eContainingFeature, null);
					}
				}
				for (EStructuralFeature.Setting setting : xrefMap.get(pivotElement)) {
					setting.unset();	// Invalid -- must reinstate Xtext proxies
				}
			}
		}
	} */
	
	protected MetaModelManager metaModelManager = null;

	@SuppressWarnings("null")
	public BaseCSResource doLoadOCLstdlib(@NonNull String stem, @NonNull String extension) throws IOException {
		resourceSet = new ResourceSetImpl();
		MetaModelManager metaModelManager =  new MetaModelManager();
//		CS2PivotResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
//		long startTime = System.currentTimeMillis();
//		System.out.println("Start at " + startTime);
		String inputName = stem + "." + extension;
		String outputName = stem + "." + extension + ".xmi";
		String output2Name = stem + ".saved." + extension;
		URI inputURI = getProjectFileURI(inputName);
		URI outputURI = getProjectFileURI(outputName);
		URI output2URI = getProjectFileURI(output2Name);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " getResource()");
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.createResource(inputURI);
		JavaClassScope.getAdapter(xtextResource, getClass().getClassLoader());
		MetaModelManagerResourceAdapter.getAdapter(xtextResource, metaModelManager);
		xtextResource.load(null);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " gotResource()");
		assertNoResourceErrors("Load failed", xtextResource);
//		assertNoCSErrors("Load failed", xtextResource);
//		CSAliasCreator.refreshPackageAliases(xtextResource);
//		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(xtextResource);
//		Resource asResource = adapter.getPivotResource(xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " resolveProxies()");
		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
//		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		xtextResource.setURI(output2URI);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " save()");
		xtextResource.save(null);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " saved()");
		assertNoResourceErrors("Save failed", xtextResource);
		Resource xmiResource = resourceSet.createResource(outputURI);
		xmiResource.getContents().addAll(xtextResource.getContents());
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " save()");
		xmiResource.save(null);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " saved()");
		assertNoResourceErrors("Save failed", xmiResource);
		xtextResource.getContents().addAll(xmiResource.getContents());
		return xtextResource;
	}

	@SuppressWarnings("null")
	protected void doPivotTestOCLstdlib(@NonNull String stem) throws IOException {
		String pivotName = stem + PivotConstants.DOT_OCL_AS_FILE_EXTENSION;
		URI pivotURI = getProjectFileURI(pivotName);
		BaseCSResource csResource = doLoadOCLstdlib(stem, "oclstdlib");
		//
		//	Create Pivot model from CS
		//
		CS2PivotResourceAdapter adapter = csResource.findCS2ASAdapter();
		Resource asResource = adapter.getASResource(csResource);
		OCLstdlibCS2Pivot creator = (OCLstdlibCS2Pivot) adapter.getConverter();
		//
		//	Check that Pivot model is ready for damage
		//
		new Checker(creator).assertContainedBy(creator);
		//
		//	Save Pivot Model for manual inspection
		//
		assertNoValidationErrors("Pivot validation problems", asResource);
		URI savedPivotURI = asResource.getURI();
		asResource.setURI(pivotURI);
		asResource.save(null);
		asResource.setURI(savedPivotURI);
		//
		//	Check CS and Pivot have consistent content
		//
		new Checker(creator).assertSameContents();
		//
		//	Update Pivot model from unchanged CS
		//
		OCLstdlibCS2Pivot updater = new OCLstdlibCS2Pivot(creator);
		updater.update(new ListBasedDiagnosticConsumer());
		new Checker(creator).assertSameContents();
		//
		// Damage the Pivot model and update to repair.
		//
//		Damager damager = damagePivot(creator);
//		damager.assertContainedBy(updater);
//		damager.update();
//		damager.assertSameContents();
		//
		assertPivotIsValid(pivotURI);
		MetaModelManager metaModelManager = adapter.getMetaModelManager();
		adapter.dispose();
		metaModelManager.dispose();
	}
	
	@SuppressWarnings("null")
	public void doPivotTestEcore(@NonNull String stem) throws IOException {
		metaModelManager = new MetaModelManager();
		ResourceSet asResourceSet = metaModelManager.getASResourceSet();
//		long startTime = System.currentTimeMillis();
//		System.out.println("Start at " + startTime);
//		String libraryName = "oclstdlib.pivot";
//		String libraryName = "oclstdlib.oclstdlib";
//		URI libraryURI = getProjectFileURI(libraryName);
//		BaseCSResource xtextLibraryResource = (BaseCSResource) resourceSet.getResource(libraryURI, true);
//		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.refreshPivotMappings(xtextLibraryResource, null);
//		Resource asResource = adapter.getPivotResource(xtextLibraryResource);
//		asResourceSet.getResource(libraryURI, true);
		String inputName = stem + ".ecore";
		String csName = stem + ".ecore.cs";
		URI inputURI = getProjectFileURI(inputName);
		URI csURI = getProjectFileURI(csName);
//		URI output2URI = getProjectFileURI(output2Name);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " getResource()");
		Resource ecoreResource = resourceSet.getResource(inputURI, true);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " gotResource()");
		assertNoResourceErrors("Load failed", ecoreResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " resolveProxies()");
		assertNoUnresolvedProxies("Unresolved proxies", ecoreResource);
//		EcoreAliasCreator.createPackageAliases(ecoreResource);
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
		Root pivotRoot = ecore2Pivot.getPivotRoot();
		
		
//		checkPivotMonikers(pivotRoot);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
//		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
//		xtextResource.setURI(output2URI);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " save()");
//		xtextResource.save(null);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " saved()");
//		assertNoResourceErrors("Save failed", xtextResource.getErrors());
		@SuppressWarnings("unused")
		ASResource asResource = (ASResource) pivotRoot.eResource();
//		CS2PivotAliasCreator.createPackageAliases(asResource);
//		Resource asResource = resourceSet.createResource(outputURI);
//		asResource.getContents().add(pivotRoot);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " save()");
		for (Resource pResource : asResourceSet.getResources()) {
			URI uri = pResource.getURI();
			if (uri.isFile()) {
				pResource.save(null);
			}
			assertNoResourceErrors("Pivot Save failed", pResource);
		}
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " saved()");
//		return asResource;
		ResourceSetImpl csResourceSet = new ResourceSetImpl();
		csResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cs", new EcoreResourceFactoryImpl());
		csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
		Resource csResource = csResourceSet.createResource(csURI);
		Map<BaseCSResource, ASResource> cs2PivotResourceMap = new HashMap<BaseCSResource, ASResource>();
//		cs2PivotResourceMap.put(csResource, asResource);
		Pivot2CS pivot2cs = new OCLinEcorePivot2CS(cs2PivotResourceMap, metaModelManager);
		pivot2cs.update();
		csResource.save(null);
//		adapter.dispose();
	}
	
//	public Damager damagePivot(CS2Pivot aConverter) {
//		Damager damager = new Damager(aConverter);
//		List<MonikeredElement> pivotElements = damager.chooseVictims();
//		damager.removeAll(pivotElements);
//		return damager;
//	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("trace", new EcoreResourceFactoryImpl());
	}

//	public void testPivot_mini_oclstdlib() throws IOException, InterruptedException {
//		doPivotTestOCLstdlib("mini");
//	}

//	public void testPivot_midi_oclstdlib() throws IOException, InterruptedException {
//		doPivotTestOCLstdlib("midi");
//	}

	@Override
	protected void tearDown() throws Exception {
		if (metaModelManager != null) {
			metaModelManager.dispose();
			metaModelManager = null;
		}		
		super.tearDown();
	}

	public void testPivot_oclstdlib_oclstdlib() throws IOException, InterruptedException {
		doPivotTestOCLstdlib("oclstdlib");
	}

//	public void testPivot_temp_oclstdlib() throws IOException, InterruptedException {
//		doPivotTestOCLstdlib("temp");
//	}

//	public void testPivot_temp2_oclstdlib() throws IOException, InterruptedException {
//		doPivotTestOCLstdlib("temp2");
//	}

	public void testPivot_Ecore_ecore() throws IOException, InterruptedException {
//		Abstract2Moniker.TRACE_MONIKERS.setState(true);
		doPivotTestEcore("Ecore");
	}

	public void testPivot_Names_ecore() throws IOException, InterruptedException {
//		Abstract2Moniker.TRACE_MONIKERS.setState(true);
		doPivotTestEcore("Names");
	}

//	public void testPivot_Temp_ecore() throws IOException, InterruptedException {
//		Abstract2Moniker.TRACE_MONIKERS.setState(true);
//		doPivotTestEcore("Temp");
//	}
}
