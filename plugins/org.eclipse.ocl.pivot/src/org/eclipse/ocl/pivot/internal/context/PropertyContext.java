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
package org.eclipse.ocl.pivot.internal.context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * PropertyContext supports parsing OCL expressions in the context of a Property.
 */
public class PropertyContext extends ClassContext
{
//	private final Property propertyContext;
	
	public PropertyContext(@NonNull MetamodelManager metamodelManager, @Nullable URI uri, @NonNull Property propertyContext) {
		super(metamodelManager, uri, ClassUtil.nonNullModel(propertyContext.getOwningClass()), null);
//		this.propertyContext = propertyContext;
	}
}
