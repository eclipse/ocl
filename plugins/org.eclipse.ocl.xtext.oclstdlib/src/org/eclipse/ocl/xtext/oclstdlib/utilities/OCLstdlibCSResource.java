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
package org.eclipse.ocl.xtext.oclstdlib.utilities;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.xtext.oclstdlib.cs2as.OCLstdlibCS2AS;

public class OCLstdlibCSResource extends EssentialOCLCSResource
{
	@Override
	public @NonNull CS2AS createCS2AS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new OCLstdlibCS2AS(cs2asResourceMap, metaModelManager);
	}

	@Override
	public @NonNull String getASContentType() {
		return ASResource.OCLSTDLIB_CONTENT_TYPE;
	}

	@Override
	public @NonNull String getEditorName() {
		return "OCL Standard Library";
	}
}
