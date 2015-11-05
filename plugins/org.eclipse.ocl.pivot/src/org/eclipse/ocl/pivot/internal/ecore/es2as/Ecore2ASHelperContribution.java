/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ecore.es2as;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.library.RegisteredContribution;
import org.eclipse.ocl.pivot.utilities.Ecore2ASHelper;

/**
 * @since 1.1
 */
public interface Ecore2ASHelperContribution extends RegisteredContribution<Ecore2ASHelper>
{
	public static class Descriptor extends AbstractDescriptor<Ecore2ASHelper> implements Ecore2ASHelperContribution
	{
		protected final @NonNull String uri;
		protected final boolean isModel;

		public Descriptor(@NonNull IConfigurationElement e, @NonNull String uri, boolean isModel, @NonNull String attrName) {
			super(e, attrName);
			this.uri = uri;
			this.isModel = isModel;
		}

		@Override
		public @Nullable Ecore2ASHelper basicGetEcore2ASHelper() {
			return contribution;
		}

		@Override
		public Ecore2ASHelper createContribution() {
			Object createInstance = createInstance();
			return ((Ecore2ASHelper) createInstance).getEcore2ASHelper();
		}

		@Override
		public @NonNull Ecore2ASHelper getEcore2ASHelper() {
			return getContribution().getEcore2ASHelper();
		}
		
		@Override
		public @NonNull String getURI() {
			return uri;
		}
		
		@Override
		public boolean isModel() {
			return isModel;
		}
	}

	@Nullable Ecore2ASHelper basicGetEcore2ASHelper();
	
	@NonNull Ecore2ASHelper getEcore2ASHelper();
	
	@NonNull String getURI();

	boolean isModel();
}
