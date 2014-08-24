/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * TemplateParameterSubstitutionHelper instances support irregular YemplateParameterSubstitution deduction for difficult to
 * model operations such as flatten().
 * <p>
 * The TemplateParameterSubstitutionHelper maintains a registry of helpers indexed by their implementatin class.
 */
public abstract class TemplateParameterSubstitutionHelper 
{
	public void resolveUnmodeledTemplateParameterSubstitutions(@NonNull TemplateParameterSubstitutionVisitor templateParameterSubstitutions, @NonNull CallExp callExp) {}

	private static @NonNull Map<Class<? extends LibraryFeature>, TemplateParameterSubstitutionHelper> className2helper = new HashMap<Class<? extends LibraryFeature>, TemplateParameterSubstitutionHelper>();
	
	public static void addHelper(@NonNull Class<? extends LibraryFeature> className, @NonNull TemplateParameterSubstitutionHelper helper) {
		className2helper.put(className,  helper);
	}

	public static @Nullable TemplateParameterSubstitutionHelper getHelper(@NonNull Class<? extends LibraryFeature> className) {
		return className2helper.get(className);
	}

	//
	//	Special case processing for flatten() return type.
	//
	private static class CollectionFlattenHelper extends TemplateParameterSubstitutionHelper
	{
		@Override
		public void resolveUnmodeledTemplateParameterSubstitutions(@NonNull TemplateParameterSubstitutionVisitor templateParameterSubstitutions, @NonNull CallExp callExp) {
			Type elementType = callExp.getSource().getType();
			while (elementType instanceof CollectionType) {
				elementType = ((CollectionType)elementType).getElementType();
			}
			templateParameterSubstitutions.put(1, elementType);
		}
	}
	
	static
	{
		addHelper(CollectionFlattenOperation.class, new CollectionFlattenHelper());
	}
}