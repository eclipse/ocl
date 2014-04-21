/**
 * <copyright>
 *
 * Copyright (c) 2010, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink (Obeo) - Add complete ocl registry to enable export and re-use CompleteOCL files
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.completeocl.utilities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.validation.PivotEObjectValidator;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;

public abstract class CompleteOCLLoader
{  // FIXME This is a pragmatic re-use. Redesign as part of a coherent API.
	protected final @NonNull ResourceSet resourceSet;
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull Set<EPackage> mmPackages;
	
	public CompleteOCLLoader(@NonNull ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, null);	// ?? Shared global MMM
		this.metaModelManager = adapter.getMetaModelManager();
		this.mmPackages = new HashSet<EPackage>();
	}
	
	public boolean loadMetaModels() {
		for (Resource resource : resourceSet.getResources()) {
			assert resource != null;
			Ecore2Pivot ecore2Pivot = Ecore2Pivot.findAdapter(resource, metaModelManager);
			if (ecore2Pivot == null) {			// Pivot has its own validation
				for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					EClass eClass = eObject.eClass();
					if (eClass != null) {
						EPackage mmPackage = eClass.getEPackage();
						if (mmPackage != null) {
							mmPackages.add(mmPackage);
						}
					}
				}
 			}
		}
		String metamodelNsURI = null;
		Set<Resource> mmResources = new HashSet<Resource>();
		for (@SuppressWarnings("null")@NonNull EPackage mmPackage : mmPackages) {
			Resource mmResource = EcoreUtil.getRootContainer(mmPackage).eResource();
			if (mmResource != null) {
				mmResources.add(mmResource);
				String metaNsURI = metaModelManager.getMetamodelNsURI(mmPackage);
				if (metaNsURI != null) {
					if (metamodelNsURI != null) {
						if (!metamodelNsURI.equals(metaNsURI)) {
							return error("Conflicting metamodel NsURIs", "'" + metamodelNsURI + "', '" + metaNsURI + "'");
						}
					}
					else {
						metamodelNsURI = metaNsURI;
					}
				}
			}
		}
		if (metamodelNsURI != null) {
			metaModelManager.setMetamodelNsURI(metamodelNsURI);
		}
		for (Resource mmResource : mmResources) {
			assert mmResource != null;
			try {
				Element pivotRoot = metaModelManager.loadResource(mmResource, null);
				if (pivotRoot != null) {
					List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> errors = pivotRoot.eResource().getErrors();
					assert errors != null;
					String message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
					if (message != null) {
						return error("Failed to load Pivot from '" + mmResource.getURI(), message);
					}
				}
				else {
					return error("Failed to load Pivot from '" + mmResource.getURI(), "");
				}
			} catch (ParserException e) {
				return error("Failed to load Pivot from '" + mmResource.getURI(), e.getMessage());
			}
		}
		return true;
	}

	protected abstract boolean error(@NonNull String primaryMessage, @Nullable String detailMessage);

	public void installPackages() {
		//
		//	Install validation for all the complemented packages
		//
		PivotEObjectValidator.install(resourceSet, metaModelManager);
		for (EPackage mmPackage : mmPackages) {
			assert mmPackage != null;
			PivotEObjectValidator.install(mmPackage);
		}
	}

	public boolean loadDocument(@NonNull URI oclURI) {
		Resource resource = loadResource(oclURI);
		if (resource == null) {
			return false;
		}
		//
		//	Identify the packages which the Complete OCL document complements.
		//
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
				DomainPackage aPackage = metaModelManager.getPrimaryPackage((org.eclipse.ocl.examples.pivot.Package)eObject);
				if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
					EPackage mmPackage = (EPackage) ((org.eclipse.ocl.examples.pivot.Package)aPackage).getETarget();
					if (mmPackage != null) {
						mmPackages.add(mmPackage);
					}
				}
			}
			else if (eObject instanceof Type) {
				tit.prune();
			}
		}
		return true;
	}

	/**
	 * Load the Xtext resource from oclURI, then convert it to a pivot representation and return it.
	 * Return null after invoking error() to display any errors in a pop-up.
	 */
	public Resource loadResource(@NonNull URI oclURI) {
		BaseResource xtextResource = null;
		CompleteOCLStandaloneSetup.init();
		try {
			xtextResource = (BaseResource) resourceSet.getResource(oclURI, true);
		}
		catch (WrappedException e) {
			URI retryURI = null;
			Throwable cause = e.getCause();
			if (cause instanceof CoreException) {
				IStatus status = ((CoreException)cause).getStatus();
				if ((status.getCode() == IResourceStatus.RESOURCE_NOT_FOUND) && status.getPlugin().equals(ResourcesPlugin.PI_RESOURCES)) {
					if (oclURI.isPlatformResource()) {
						retryURI = URI.createPlatformPluginURI(oclURI.toPlatformString(false), false);
					}
				}
			}
			if (retryURI != null) {
				xtextResource = (BaseResource) resourceSet.getResource(retryURI, true);			
			}
			else {
				throw e;
			}
		}
		List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> errors = xtextResource.getErrors();
		assert errors != null;
		String message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			error("Failed to load '" + oclURI, message);
			return null;
		}
		Resource asResource = xtextResource.getASResource(metaModelManager);
		errors = asResource.getErrors();
		assert errors != null;
		message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			error("Failed to load Pivot from '" + oclURI, message);
			return null;
		}
		return asResource;
	}
}