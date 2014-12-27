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
package org.eclipse.ocl.xtext.base.attributes;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.compatibility.EMF_2_9;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.messages.OCLMessages;
import org.eclipse.ocl.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS.UnresolvedProxyMessageProvider;
import org.eclipse.ocl.xtext.base.cs2as.ValidationDiagnostic;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class ImportCSAttribution extends AbstractAttribution implements UnresolvedProxyMessageProvider
{
	public static final ImportCSAttribution INSTANCE = new ImportCSAttribution();

	private static class ImportAdapter extends AdapterImpl
	{
		private URI uri = null;
		private Element importedElement = null;
		private Throwable throwable = null;
	
		public ScopeView computeLookup(ImportCS targetElement, EnvironmentView environmentView, ScopeView scopeView) {
			String name = environmentView.getName();
			if (name != null) {				// Looking for a specific name
				importModel(targetElement, environmentView);
				Element importedElement2 = importedElement;
				if (importedElement2 != null) {
					Resource importedResource = importedElement2.eResource();
					if (importedResource != null) {
						List<Resource.Diagnostic> errors = importedResource.getErrors();
						if (errors.size() == 0) {
							environmentView.addElement(name, importedElement2);		// The name we imported must be a good name for the element
						}
					}
				}
			}
			else {							// looking for all possible names
				Map<String, URI> ePackageNsURIToGenModelLocationMap = EMF_2_9.EcorePlugin.getEPackageNsURIToGenModelLocationMap(false);
				for (String key : ePackageNsURIToGenModelLocationMap.keySet()) {
					environmentView.addElement(key, environmentView.getStandardLibrary().getOclVoidType());
				}
				// FIXME platform:/resource/... and local file names
			}
			return null;
		}
	
		public String getMessage() {
			return throwable != null ? throwable.getMessage() : null;
		}
	
		protected void importModel(ImportCS target, EnvironmentView environmentView) {
			String name = environmentView.getName();
			if (name == null) {
				return;
			}
			MetaModelManager metaModelManager = environmentView.getMetaModelManager();
			CompletePackage completePackage = metaModelManager.getCompleteModel().getCompletePackageByURI(name);
			if (completePackage != null) {
				importedElement = completePackage.getPivotPackage();
				throwable = null;
				return;
			}
			BaseCSResource csResource = (BaseCSResource) target.eResource();
			@NonNull URI uri2;
			try {
				@SuppressWarnings("null") @NonNull URI newURI = URI.createURI(name);
				newURI = csResource.resolve(newURI);
				if (newURI.equals(uri)) {
					return;
				}
				uri2 = uri = newURI;					// Lock out recursive attempt from EcoreUtil.resolveProxy
				importedElement = null;
				throwable = null;
			} catch (WrappedException e) {
				throwable = e.exception();
				return;
			} catch (Exception e) {
				throwable = e;
				return;
			}
			try {
				importedElement = metaModelManager.loadResource(uri2, target.getName(), null);				
				Resource importedResource = importedElement.eResource();
				if (importedResource != null) {
					List<Resource.Diagnostic> warnings = importedResource.getWarnings();
					if (warnings.size() > 0) {
						INode node = NodeModelUtils.getNode(target);
						String errorMessage = PivotUtil.formatResourceDiagnostics(warnings, StringUtil.bind(OCLMessages.WarningsInURI, uri2), "\n\t");
						Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
						csResource.getWarnings().add(resourceDiagnostic);
					}
					List<Resource.Diagnostic> errors = importedResource.getErrors();
					if (errors.size() > 0) {
						INode node = NodeModelUtils.getNode(target);
						String errorMessage = PivotUtil.formatResourceDiagnostics(errors, StringUtil.bind(OCLMessages.ErrorsInURI, uri), "\n\t");
						Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
						csResource.getErrors().add(resourceDiagnostic);
					}
				}
			} catch (WrappedException e) {
				throwable = e.exception();
			} catch (Exception e) {
				throwable = e;
			}
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == ImportAdapter.class;
		}
	}

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ImportCS targetElement = (ImportCS)target;
		ImportAdapter adapter = PivotUtil.getAdapter(ImportAdapter.class, targetElement);
		if (adapter == null) {
			adapter = new ImportAdapter();
			targetElement.eAdapters().add(adapter);
		}
		return adapter.computeLookup(targetElement, environmentView, scopeView);
	}

	@Override
	public @NonNull EReference getEReference() {
		@SuppressWarnings("null") @NonNull EReference importCsNamespace = BaseCSPackage.Literals.IMPORT_CS__REFERRED_NAMESPACE;
		return importCsNamespace;
	}

	@Override
	public @Nullable String getMessage(@NonNull EObject context, @NonNull String linkText) {
		ImportAdapter adapter = PivotUtil.getAdapter(ImportAdapter.class, context);
		if (adapter != null) {
			String message = adapter.getMessage();
			return NLS.bind(OCLMessages.UnresolvedImport_ERROR_, linkText, message);
		}
		return null;
	}
}
