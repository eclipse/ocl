/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.model;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

/**
 * BaseEditorCallback provides an OCL instance whose lifetime correlates
 * with the editor and which is accessible from the Xtext SynchronizedResourceSet.
 */
public class BaseDocumentProvider extends XtextDocumentProvider
{
	private @Nullable OCLInternal ocl;

	protected @NonNull OCLInternal createOCL() {
		return OCLInternal.newInstance();
	}

	@Override
	protected void disconnected() {
		OCL ocl2 = ocl;
		if (ocl2 != null) {
			ocl = null;
			ocl2.dispose();
		}
		super.disconnected();
	}
	
	protected @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return getOCL().getEnvironmentFactory();
	}
	
	protected @NonNull OCLInternal getOCL() {
		OCLInternal ocl2 = ocl;
		if (ocl2 == null) {
			ocl = ocl2 = createOCL();
		}
		return ocl2;
	}

	@Override
	protected void loadResource(XtextResource resource, String document, String encoding) throws CoreException {
		if (resource != null) {
			ResourceSet resourceSet = resource.getResourceSet();
			if (resourceSet != null) {
				resourceSet.eAdapters().add(new EnvironmentFactoryAdapter(getEnvironmentFactory(), resourceSet));
			}
		}
		super.loadResource(resource, document, encoding);
	}
}
