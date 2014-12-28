/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.ecore.AS2Ecore;
import org.eclipse.ocl.pivot.internal.ecore.Ecore2AS;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.manager.MetaModelManager;
import org.eclipse.ocl.pivot.internal.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.StandaloneProjectMap;
import org.eclipse.ocl.pivot.utilities.StandaloneProjectMap.IProjectDescriptor;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;

/**
 * Merges a specified <tt>uri</tt> into a designated <tt>modelSlot</tt>.
 */
public class ConstraintMerger extends AbstractProjectComponent
{
	private Logger log = Logger.getLogger(getClass());	
	protected String uri;	

	public ConstraintMerger() {
		OCLstdlib.install();
		CompleteOCLStandaloneSetup.doSetup();
	}

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (uri == null) {
			issues.addError(this, "uri not specified.");
		}
	}

	public String getUri() {
		return uri;
	}

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		IProjectDescriptor projectDescriptor = ClassUtil.nonNullState(getProjectDescriptor());
		assert uri != null;
		URI inputURI = projectDescriptor.getPlatformResourceURI(uri);
		log.info("Merging '" + inputURI + "'");
		Resource ecoreResource = (Resource) ctx.get(getModelSlot());
		EPackage ecorePivotPackage = (EPackage) ecoreResource.getContents().get(0);
		final String pivotNsURI = ClassUtil.nonNullState(ecorePivotPackage.getNsURI());
//		IPackageDescriptor packageDescriptor = projectDescriptor.getPackageDescriptor(URI.createURI(pivotNsURI));
		ResourceSet resourceSet = new ResourceSetImpl();
//		packageDescriptor.setUseModel(true, null);				// Hide packages installed by CompleteOCLStandaloneSetup
			
		MetaModelManager metaModelManager = MetaModelManager.getAdapter(resourceSet);
//		metaModelManager.setLibraryLoadInProgress(true);
		metaModelManager.getExternalResourceSet().getResources().add(ecoreResource);		// Don't load another copy
		metaModelManager.getStandardLibrary().setDefaultStandardLibraryURI(pivotNsURI);
		StandardLibraryContribution.REGISTRY.put(pivotNsURI, new OCLstdlib.Loader());
//		metaModelManager.getBooleanType();
		for (EObject eObject : ecoreResource.getContents()) {
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage) eObject;
				ClassUtil.getMetamodelAnnotation(ePackage); // Install EAnnotation
			}
		}
		Ecore2AS ecore2as = Ecore2AS.getAdapter(ecoreResource, metaModelManager);
		Model pivotModel = ecore2as.getPivotModel();
//		metaModelManager.setPivotMetaModel(pivotModel.getNestedPackage().get(0));
//		metaModelManager.setLibraryLoadInProgress(false);
		Resource asResource = ClassUtil.nonNullState(pivotModel.eResource());
//FIXME		diagnoseErrors(asResource);
//		URI fileURI = URI.createPlatformResourceURI(uri, true);
		try {
			EssentialOCLCSResource xtextResource = ClassUtil.nonNullState((EssentialOCLCSResource) metaModelManager.getExternalResourceSet().createResource(inputURI, null));
			MetaModelManagerResourceAdapter.getAdapter(xtextResource, metaModelManager);
			xtextResource.load(null);
			ResourceUtils.checkResourceSet(resourceSet);
//			CS2ASResourceAdapter cs2as = CS2ASResourceAdapter.getAdapter(xtextResource, metaModelManager);
//			Resource oclResource = cs2as.getPivotResource(xtextResource);
//			Set<Resource> primaryPivotResources = new HashSet<Resource>();
//			Set<Resource> libraryPivotResources = new HashSet<Resource>();
//			Iterable<org.eclipse.ocl.pivot.Package> somePackages = metaModelManager.getPackageManager().getAllPackages();
//			identifyResources(metaModelManager, somePackages, primaryPivotResources, libraryPivotResources);
//			Set<Resource> secondaryPivotResources = new HashSet<Resource>(metaModelManager.getPivotResourceSet().getResources());
//			secondaryPivotResources.removeAll(primaryPivotResources);
//			secondaryPivotResources.removeAll(libraryPivotResources);
//			primaryPivotResources.removeAll(libraryPivotResources);
//			for (Resource secondaryPivotResource : secondaryPivotResources) {
			for (Resource resource : metaModelManager.getASResourceSet().getResources()) {
				if (resource != asResource) {
					for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
						EObject eObject = tit.next();
						if ((eObject instanceof Library) || (eObject instanceof Orphanage)) {
							tit.prune();
						}
						else if (eObject instanceof org.eclipse.ocl.pivot.Class) {
							org.eclipse.ocl.pivot.Class mergeType = (org.eclipse.ocl.pivot.Class)eObject;
							CompleteClass completeClass = metaModelManager.getCompleteClass(mergeType);
							for (org.eclipse.ocl.pivot.Class partialClass : completeClass.getPartialClasses()) {
								if (partialClass != null) {
									if (partialClass.eResource() == asResource) {
										mergeType(metaModelManager, partialClass, mergeType);
										break;
									}
								}
							}
							tit.prune();
						}
					}
				}
			}
//			List<Resource> resources = resourceSet.getResources();
			URI ecoreURI = ClassUtil.nonNullState(ecoreResource.getURI());
//			for (int i = resources.size() - 1; i >= 0; --i) {
//				Resource resource = resources.get(i);
//				if (ecoreURI.equals(resource.getURI())) {
//					resources.remove(resource);
//				}
//			}
//				System.out.println("AS2Ecore " + asResource.getURI());
			Map<String,Object> options = new HashMap<String,Object>();
			options.put(AS2Ecore.OPTION_SUPPRESS_DUPLICATES,  true);
			Resource ecoreResource2 = AS2Ecore.createResource(metaModelManager, asResource, ecoreURI, options);
			ctx.set(getModelSlot(), ecoreResource2);
			projectDescriptor.configure(ecoreResource2.getResourceSet(), StandaloneProjectMap.LoadBothStrategy.INSTANCE, null);
			
//			for (EObject eObject : oclResource.getContents()) {
//				if (eObject instanceof org.eclipse.ocl.pivot.Package) {
//					org.eclipse.ocl.pivot.Package pivotPackage = (org.eclipse.ocl.pivot.Package)eObject;
//					PackageTracker packageTracker = metaModelManager.getPackageTracker(pivotPackage);
//					PackageServer packageServer = packageTracker.getPackageServer();
//					packageServer.removePackage(pivotPackage);
//				}
//			}
//			EcoreUtil.resolveAll(resourceSet);
//			ResourceUtils.checkResourceSet(resourceSet);
//			ctx.set(getModelSlot(), resource);
		} catch (IOException e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	protected void mergeType(@NonNull MetaModelManager metaModelManager, @NonNull org.eclipse.ocl.pivot.Class primaryType, @NonNull org.eclipse.ocl.pivot.Class mergeType) {
		List<Constraint> mergeInvariants = mergeType.getOwnedInvariants();
		List<Constraint> primaryInvariants = primaryType.getOwnedInvariants();
		for (Constraint mergeInvariant : new ArrayList<Constraint>(mergeInvariants)) {
			mergeInvariant.setIsCallable(true);
			PivotUtilInternal.resetContainer(mergeInvariant);
			primaryInvariants.add(mergeInvariant);
		}
		List<Property> mergeProperties = mergeType.getOwnedProperties();
		if (mergeProperties.size() > 0) {
			List<Property> primaryProperties = primaryType.getOwnedProperties();
			for (@SuppressWarnings("null")@NonNull Property mergeProperty : new ArrayList<Property>(mergeProperties)) {
				Property primaryProperty = metaModelManager.getPrimaryElement(mergeProperty);
				if (primaryProperty != mergeProperty) {			// If merge needed
					LanguageExpression pivotDefaultExpression = mergeProperty.getOwnedExpression();
					LanguageExpression primaryDefaultExpression = primaryProperty.getOwnedExpression();
					if ((primaryDefaultExpression == null) && (pivotDefaultExpression != null)) {
						primaryProperty.setOwnedExpression(pivotDefaultExpression);
					}
				}
				else											// Else simple promotion
				{
					primaryProperties.add(mergeProperty);
				}
			}
		}
		List<Operation> mergeOperations = mergeType.getOwnedOperations();
		if (mergeOperations.size() > 0) {
			List<Operation> primaryOperations = primaryType.getOwnedOperations();
			for (@SuppressWarnings("null")@NonNull Operation mergeOperation : new ArrayList<Operation>(mergeOperations)) {
				Operation primaryOperation = metaModelManager.getPrimaryElement(mergeOperation);
				if (primaryOperation != mergeOperation) {		// If merge needed
					LanguageExpression pivotBodyExpression = mergeOperation.getBodyExpression();
					LanguageExpression primaryBodyExpression = primaryOperation.getBodyExpression();
					if ((primaryBodyExpression == null) && (pivotBodyExpression != null)) {
						primaryOperation.setBodyExpression(pivotBodyExpression);
					}
				}
				else											// Else simple promotion
				{
					PivotUtilInternal.resetContainer(mergeOperation);
					primaryOperations.add(mergeOperation);
				}
			}
		}
	}

/*	public void identifyResources(MetaModelManager metaModelManager, Iterable<org.eclipse.ocl.pivot.Package> somePackages,
			Set<Resource> primaryPivotResources, Set<Resource> libraryPivotResources) {
		for (org.eclipse.ocl.pivot.Package pPackage : somePackages) {
			if (pPackage instanceof Library) {
				libraryPivotResources.add(pPackage.eResource());
			}
			else {
				for (Type pType : pPackage.getOwnedType()) {
					TypeTracker typeTracker = metaModelManager.getTypeTracker(pType);
					if (typeTracker instanceof TypeServer) {
						primaryPivotResources.add(pPackage.eResource());
						break;
					}
				}
				identifyResources(metaModelManager, pPackage.getNestedPackage(),  primaryPivotResources, libraryPivotResources);
			}
		}
	} */

	public void setUri(String uri) {
		this.uri = uri;
	}
}
