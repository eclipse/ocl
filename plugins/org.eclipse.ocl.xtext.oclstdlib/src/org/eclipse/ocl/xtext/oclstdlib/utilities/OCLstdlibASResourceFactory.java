/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlib.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryContribution;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

public final class OCLstdlibASResourceFactory extends AbstractASResourceFactory
{
	private static @Nullable OCLstdlibASResourceFactory INSTANCE = null;

	public static @NonNull OCLstdlibASResourceFactory getInstance() {
		if (INSTANCE == null) {
			ASResourceFactoryContribution asResourceRegistry = ASResourceFactoryRegistry.INSTANCE.get(ASResource.OCLSTDLIB_CONTENT_TYPE);
			if (asResourceRegistry != null) {
				asResourceRegistry.getASResourceFactory();						// Create the registered singleton
			}
			if (INSTANCE == null) {
				new OCLstdlibASResourceFactory();							// Create our own singleton
			}
			assert INSTANCE != null;
			INSTANCE.install(PivotConstants.OCLSTDLIB_FILE_EXTENSION, null);
		}
		assert INSTANCE != null;
		return INSTANCE;
	}

	public OCLstdlibASResourceFactory() {
		super(ASResource.OCLSTDLIB_CONTENT_TYPE);
		INSTANCE = this;
	}
}
