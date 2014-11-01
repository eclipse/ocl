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
package org.eclipse.ocl.examples.xtext.oclinecore.utilities;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.examples.xtext.oclinecore.cs2as.OCLinEcoreCS2AS;
import org.eclipse.ocl.examples.xtext.oclinecore.pivot2cs.OCLinEcorePivot2CS;

public class OCLinEcoreCSResource extends EssentialOCLCSResource
{
	@Override
	public @NonNull CS2AS createCS2AS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new OCLinEcoreCS2AS(cs2asResourceMap, metaModelManager);
	}

	@Override
	public @NonNull Pivot2CS createPivot2CS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new OCLinEcorePivot2CS(cs2asResourceMap, metaModelManager);
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (getContents().size() > 0) {
			super.doSave(outputStream, options);	// Avoid NPE or ISE from XtextResource
		}
	}

	@Override
	public @NonNull String getASContentType() {
		return ASResource.OCLINECORE_CONTENT_TYPE;
	}

	@Override
	public @NonNull String getEditorName() {
		return "OCL in Ecore";
	}
}
