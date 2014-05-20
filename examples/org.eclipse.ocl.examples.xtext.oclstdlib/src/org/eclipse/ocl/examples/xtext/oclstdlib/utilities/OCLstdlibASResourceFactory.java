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
package org.eclipse.ocl.examples.xtext.oclstdlib.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.resource.AbstractASResourceFactory;

public final class OCLstdlibASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull OCLstdlibASResourceFactory INSTANCE = new OCLstdlibASResourceFactory();
	
	protected OCLstdlibASResourceFactory() {
		super(ASResource.OCLSTDLIB_CONTENT_TYPE, null);
	}
}