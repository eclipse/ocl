/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.elements;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;

public interface FeatureFilter
{
	boolean accept(@NonNull DomainFeature asFeature);
	boolean accept(@NonNull Property asFeature);
	
	public static final @NonNull FeatureFilter SELECT_NON_STATIC = new FeatureFilter()
	{
		@Override
		public boolean accept(@NonNull DomainFeature asFeature) {
			return !asFeature.isStatic();
		}
		@Override
		public boolean accept(@NonNull Property asFeature) {
			return !asFeature.isStatic();
		}
	};
	
	public static final @NonNull FeatureFilter SELECT_STATIC = new FeatureFilter()
	{
		@Override
		public boolean accept(@NonNull DomainFeature asFeature) {
			return asFeature.isStatic();
		}
		@Override
		public boolean accept(@NonNull Property asFeature) {
			return asFeature.isStatic();
		}
	};
}