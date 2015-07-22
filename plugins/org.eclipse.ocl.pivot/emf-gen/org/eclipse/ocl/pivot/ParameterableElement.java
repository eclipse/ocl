/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.ElementId;

public interface ParameterableElement extends Element {


	@Nullable org.eclipse.ocl.pivot.Class asClass();

	@Nullable TemplateParameter asTemplateParameter();

	@NonNull ElementId getTypeId();

	boolean isTemplateParameter();

//	@NonNull TypeOrValue getCommonType(@NonNull IdResolver idResolver, @NonNull TypeOrValue typeOrValue);

//	boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull TypeOrValue typeOrValue);

//	boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull TypeOrValue secondKeyType);
	
} 
