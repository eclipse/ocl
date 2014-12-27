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
package org.eclipse.ocl.xtext.base.attributes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.pivot.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.IllegalLibraryException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS.UnresolvedProxyMessageProvider;
import org.eclipse.ocl.xtext.base.cs2as.ValidationDiagnostic;
import org.eclipse.ocl.xtext.base.scoping.AbstractJavaClassScope;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.LibraryCS;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class LibraryCSAttribution extends AbstractAttribution implements UnresolvedProxyMessageProvider
{
	public static final LibraryCSAttribution INSTANCE = new LibraryCSAttribution();

	private static class LibraryAdapter extends AdapterImpl
	{
		private URI uri = null;
		private Element importedElement = null;
		private Throwable throwable = null;
	
		public ScopeView computeLookup(LibraryCS targetElement, EnvironmentView environmentView, ScopeView scopeView) {
			importLibrary(targetElement, environmentView);
			Element importedElement2 = importedElement;
			if (importedElement2 != null) {
				Resource importedResource = importedElement2.eResource();
				List<Resource.Diagnostic> errors = importedResource.getErrors();
				if (errors.size() == 0) {
					if (importedElement2 instanceof NamedElement) {
						String name = ((NamedElement)importedElement2).getName();
						if (name != null) {
							environmentView.addElement(name, importedElement2);
							if (importedElement instanceof Model) {
								for (org.eclipse.ocl.pivot.Package rootPackage : ((Model)importedElement2).getOwnedPackages()) {
									environmentView.addElement(name, rootPackage);
								}
							}
						}
					}
				}
			}
			return null;
		}
	
		public String getMessage() {
			return throwable != null ? throwable.getMessage() : null;
		}
	
		protected void importLibrary(LibraryCS target, EnvironmentView environmentView) {
			String name = environmentView.getName();
			if (name == null) {
				return;
			}
			StandardLibraryContribution contribution = StandardLibraryContribution.REGISTRY.get(name);
			if (contribution != null) {
				Resource resource = contribution.getResource();
				try {
					MetaModelManager metaModelManager = environmentView.getMetaModelManager();
					metaModelManager.installResource(resource);
					for (EObject root : resource.getContents()) {
						if (root instanceof Model) {
							for (Element pkg : ((Model)root).getOwnedPackages()) {
								if (pkg instanceof Library) {
									environmentView.addElement(name, pkg);									
								}
							}
						}
					}
				} catch (IllegalLibraryException e) {
					throwable = e;
				}
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
			List<EObject> importedElements = new ArrayList<EObject>();
			ResourceSet csResourceSet = ClassUtil.nonNullState(csResource.getResourceSet());
			MetaModelManager metaModelManager = environmentView.getMetaModelManager();
			MetaModelManagerResourceSetAdapter.getAdapter(csResourceSet, metaModelManager);
			try {
				Resource importedResource = csResourceSet.createResource(uri2);
				AbstractJavaClassScope outerClassScope = AbstractJavaClassScope.findAdapter(csResource);
				if ((outerClassScope != null) && (importedResource instanceof BaseCSResource)) {
					outerClassScope.getAdapter((BaseCSResource)importedResource);
				}
				importedResource.load(null);
				List<EObject> contents = importedResource.getContents();
				if (contents.size() > 0) {
					for (EObject content : contents) {
						if (content instanceof Pivotable) {
							Element pivot = ((Pivotable)content).getPivot();
							importedElements.add(pivot);
							if (importedElement == null) {
								importedElement = pivot;		// FIXME Use a single RootElement
							}
						}
					}
				}
				List<Resource.Diagnostic> warnings = importedResource.getWarnings();
				if (warnings.size() > 0) {
					INode node = NodeModelUtils.getNode(target);
					String errorMessage = PivotUtil.formatResourceDiagnostics(warnings, StringUtil.bind(PivotMessagesInternal.WarningsInURI, uri), "\n\t");
					Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
					csResource.getWarnings().add(resourceDiagnostic);
				}
				List<Resource.Diagnostic> errors = importedResource.getErrors();
				if (errors.size() > 0) {
					Diagnostic diagnostic = errors.get(0);
					if (diagnostic instanceof WrappedException) {
						throwable = ((WrappedException)diagnostic).exception();
					}
					else {
						INode node = NodeModelUtils.getNode(target);
						String errorMessage = PivotUtil.formatResourceDiagnostics(errors, "Errors in '" + uri + "'", "\n\t");
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
			return type == LibraryAdapter.class;
		}
	}

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		LibraryCS targetElement = (LibraryCS)target;
		LibraryAdapter adapter = ClassUtil.getAdapter(LibraryAdapter.class, targetElement);
		if (adapter == null) {
			adapter = new LibraryAdapter();
			targetElement.eAdapters().add(adapter);
		}
		return adapter.computeLookup(targetElement, environmentView, scopeView);
	}

	@Override
	public @NonNull EReference getEReference() {
		@SuppressWarnings("null") @NonNull EReference libraryCsPackage = BaseCSPackage.Literals.LIBRARY_CS__REFERRED_PACKAGE;
		return libraryCsPackage;
	}

	@Override
	public @Nullable String getMessage(@NonNull EObject context, @NonNull String linkText) {
		LibraryAdapter adapter = ClassUtil.getAdapter(LibraryAdapter.class, context);
		if (adapter != null) {
			String message = adapter.getMessage();
			return NLS.bind(PivotMessagesInternal.UnresolvedLibrary_ERROR_, linkText, message);
		}
		return null;
	}
}
