/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.completeocl.attributes;

import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.ValidationDiagnostic;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot.UnresolvedProxyMessageProvider;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class IncludeCSAttribution extends AbstractAttribution implements UnresolvedProxyMessageProvider
{
	public static final @NonNull IncludeCSAttribution INSTANCE = new IncludeCSAttribution();

	private static class IncludeAdapter extends AdapterImpl
	{
		private URI uri = null;
		private Element importedElement = null;
		private Throwable throwable = null;
	
		public ScopeView computeLookup(@NonNull IncludeCS targetElement, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
//			String name = environmentView.getName();
//			if (name != null) {
			importComplement(targetElement, environmentView);
//			}
			Element importedElement2 = importedElement;
			if (importedElement2 != null) {
				Resource importedResource = importedElement2.eResource();
				List<Resource.Diagnostic> errors = importedResource.getErrors();
				if (errors.size() == 0) {
//					environmentView.addElement(name, importedElement);
					if (importedElement2 instanceof Root) {
						Root root = (Root)importedElement2;
						String externalURI = root.getExternalURI();
						if (externalURI != null) {
							String name = environmentView.getName();
							if (name != null) {
								URI envURI = URI.createURI(name);
								URI extURI = URI.createURI(externalURI);
								URI resolvedURI = envURI.resolve(extURI);
								if (resolvedURI.equals(extURI)) {
									environmentView.addElement(name, root);
								}
							}
						}
					}
/*					else {
						if (importedElement2 instanceof DomainNamedElement) {
							String name = ((DomainNamedElement)importedElement2).getName();
							if (name != null) {
								environmentView.addElement(name, importedElement2);
							}
						}
						if (importedElement2 instanceof DomainPackage) {
							String nsURI = ((DomainPackage)importedElement2).getNsURI();
							if (nsURI != null) {
								environmentView.addElement(nsURI, importedElement2);
								String suffixedName = nsURI + "#/";
								if (suffixedName.equals(environmentView.getName())) {					// FIXME deprecated compatibility
									environmentView.addElement(suffixedName, importedElement2);
								}
							}
						}
						if (importedElement2 instanceof PivotObjectImpl) {
							EObject originalElement = ((PivotObjectImpl)importedElement2).getTarget();
							if (originalElement != null) {
								EObject eContainer = EcoreUtil.getRootContainer(importedElement2);
								if (eContainer instanceof Root) {
									String name = ((Root)eContainer).getName();
									if (name != null) {
										String uriFragment = originalElement.eResource().getURIFragment(originalElement);
										environmentView.addElement(name + '#' + uriFragment, importedElement2);
									}
								}
							}
						}
					} */
				}
			}
			return null;
		}
	
		public String getMessage() {
			return throwable != null ? throwable.getMessage() : null;
		}
	
		protected void importComplement(@NonNull IncludeCS target, @NonNull EnvironmentView environmentView) {
			String name = environmentView.getName();
			if (name == null) {
				return;
			}
			BaseCSResource csResource = (BaseCSResource) target.eResource();
			URI uri2;
			try {
				URI newURI = URI.createURI(name);
				assert newURI != null;
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
				MetaModelManager metaModelManager = environmentView.getMetaModelManager();
				importedElement = metaModelManager.loadResource(uri2, target.getName(), csResource.getResourceSet());				
				Resource importedResource = importedElement.eResource();
				List<Resource.Diagnostic> warnings = importedResource.getWarnings();
				if (warnings.size() > 0) {
					INode node = NodeModelUtils.getNode(target);
					String errorMessage = PivotUtil.formatResourceDiagnostics(warnings, DomainUtil.bind(OCLMessages.WarningsInURI, uri2), "\n\t");
					Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
					csResource.getWarnings().add(resourceDiagnostic);
				}
				List<Resource.Diagnostic> errors = importedResource.getErrors();
				if (errors.size() > 0) {
					INode node = NodeModelUtils.getNode(target);
					String errorMessage = PivotUtil.formatResourceDiagnostics(errors, DomainUtil.bind(OCLMessages.ErrorsInURI, uri2), "\n\t");
					Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
					csResource.getErrors().add(resourceDiagnostic);
				}
			} catch (WrappedException e) {
				throwable = e.exception();
			} catch (Exception e) {
				throwable = e;
			}
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			return type == IncludeAdapter.class;
		}
	}
	
	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		IncludeCS targetElement = (IncludeCS)target;
		IncludeAdapter adapter = PivotUtil.getAdapter(IncludeAdapter.class, targetElement);
		if (adapter == null) {
			adapter = new IncludeAdapter();
			targetElement.eAdapters().add(adapter);
		}
		return adapter.computeLookup(targetElement, environmentView, scopeView);
	}

	public @NonNull EReference getEReference() {
		@SuppressWarnings("null") @NonNull EReference eReference = CompleteOCLCSPackage.Literals.INCLUDE_CS__NAMESPACE;
		return eReference;
	}

	public String getMessage(@NonNull EObject context, @NonNull String linkText) {
		IncludeAdapter adapter = PivotUtil.getAdapter(IncludeAdapter.class, context);
		if (adapter != null) {
			String message = adapter.getMessage();
			return NLS.bind(OCLMessages.UnresolvedInclude_ERROR_, linkText, message);
		}
		return null;
	}
}
