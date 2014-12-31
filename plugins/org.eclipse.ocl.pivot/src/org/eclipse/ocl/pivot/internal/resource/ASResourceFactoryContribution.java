/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.library.RegisteredContribution;

public interface ASResourceFactoryContribution extends RegisteredContribution<ASResourceFactoryContribution>
{
	public static class Descriptor extends AbstractDescriptor<ASResourceFactoryContribution> implements ASResourceFactoryContribution
	{
		public Descriptor(@NonNull IConfigurationElement e, @NonNull String attrName) {
			super(e, attrName);
		}

		@Override
		protected ASResourceFactoryContribution createContribution() {
			Object createInstance = createInstance();
			return (ASResourceFactoryContribution) createInstance;
		}

		@Override
		public @NonNull ASResourceFactory getASResourceFactory() {
			return getContribution().getASResourceFactory();
		}
	}
	
	@NonNull ASResourceFactory getASResourceFactory();
}
