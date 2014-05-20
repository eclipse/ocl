/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * PropertyContext supports parsing OCL expressions in the context of a Property.
 */
public class PropertyContext extends ClassContext
{
//	private final Property propertyContext;
	
	public PropertyContext(@NonNull MetaModelManager metaModelManager, @Nullable URI uri, @NonNull Property propertyContext) {
		super(metaModelManager, uri, DomainUtil.nonNullModel(propertyContext.getOwningType()));
//		this.propertyContext = propertyContext;
	}
}
