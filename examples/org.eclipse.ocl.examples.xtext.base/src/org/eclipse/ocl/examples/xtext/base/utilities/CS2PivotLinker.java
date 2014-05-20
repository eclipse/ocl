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
package org.eclipse.ocl.examples.xtext.base.utilities;

import java.util.List;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.utilities.IllegalLibraryException;
import org.eclipse.ocl.examples.xtext.base.cs2as.LibraryDiagnostic;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.linking.lazy.LazyLinker;

/**
 * CS2PivotLinker ensures that the CS 2 Pivot mappings are refreshed after
 * and CS Resource modification is committed.
 */
public class CS2PivotLinker extends LazyLinker
{
    public static class DiagnosticWrappedException extends WrappedException implements Resource.Diagnostic
    {
      private static final long serialVersionUID = 1L;

      public DiagnosticWrappedException(Exception exception)
      {
        super(exception);
      }

      public String getLocation()
      {
        return "unknown";			// FIXME
      }

      public int getColumn()
      {
        return 0;
      }

      public int getLine()
      {
        return 0;
      }
    }

	@Override
	protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		Resource eResource = model.eResource();		// FIXME Try to do a narrower refresh
//		System.out.println(Thread.currentThread().getName() + " afterModelLinked " + getClass().getSimpleName() + "@" + hashCode()
//			+ " " + eResource.getClass().getSimpleName() + "@" + eResource.hashCode() + " " + eResource.getURI());		
		if ((diagnosticsConsumer != null) && eResource instanceof BaseCSResource) {
			@SuppressWarnings("null") @NonNull List<Diagnostic> errors = eResource.getErrors();
			if (!ElementUtil.hasSyntaxError(errors)) {
//				System.out.println("Starting to refreshPivotMappings for " + eResource.getURI());
				BaseCSResource csResource = (BaseCSResource) eResource;
				try {
					CS2PivotResourceAdapter resourceAdapter = csResource.getCS2ASAdapter(null);
					resourceAdapter.refreshPivotMappings(diagnosticsConsumer);		// FIXME redundant
/*					Resource asResource = resourceAdapter.getPivotResource(csResource);
					ResourceSet resourceSet = csResource.getResourceSet();
					if (resourceSet instanceof ResourceSetImpl) {
						ResourceSetImpl resourceSetImpl = (ResourceSetImpl) resourceSet;
						Map<URI, Resource> uriResourceMap = resourceSetImpl.getURIResourceMap();
						if (uriResourceMap == null) {
							uriResourceMap = new HashMap<URI, Resource>();
							resourceSetImpl.setURIResourceMap(uriResourceMap);
						}
						uriResourceMap.put(asResource.getURI(), asResource);
					} */
				}
				catch (Exception exception) {	// Never let an Exception leak out to abort Xtext
				    Exception cause = exception instanceof Resource.IOWrappedException ? (Exception)exception.getCause() : exception;
//			    	DiagnosticWrappedException wrappedException = new DiagnosticWrappedException(cause);
//					eResource.getErrors().add(wrappedException);
				    if (cause instanceof IllegalLibraryException) {
				    	errors.add(new LibraryDiagnostic(cause));
				    }
				    else {
				    	errors.add(new ExceptionDiagnostic(cause));
				    	BasePlugin.error(0, csResource.getEditorName() + " Editor linking error", cause);
				    }
				}
//				System.out.println("Finished refreshPivotMappings for " + eResource.getURI());
			}
		}
	}
}