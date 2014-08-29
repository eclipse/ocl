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
import org.eclipse.ocl.examples.library.iterator.CollectIteration;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * TemplateParameterSubstitutionHelper instances support irregular YemplateParameterSubstitution deduction for difficult to
 * model operations such as flatten().
 * <p>
 * The TemplateParameterSubstitutionHelper maintains a registry of helpers indexed by their implementatin class.
 */
public abstract class TemplateParameterSubstitutionHelper 
{
	public void resolveUnmodeledTemplateParameterSubstitutions(@NonNull TemplateParameterSubstitutionVisitor templateParameterSubstitutions, @NonNull CallExp callExp) {}

	public @Nullable Type resolveReturnType(@NonNull MetaModelManager metaModelManager, @NonNull CallExp callExp, @Nullable Type returnType) {
		return returnType;
	}

	private static @NonNull Map<Class<? extends LibraryFeature>, TemplateParameterSubstitutionHelper> className2helper = new HashMap<Class<? extends LibraryFeature>, TemplateParameterSubstitutionHelper>();
	
	public static void addHelper(@NonNull Class<? extends LibraryFeature> className, @NonNull TemplateParameterSubstitutionHelper helper) {
		className2helper.put(className,  helper);
	}

	public static @Nullable TemplateParameterSubstitutionHelper getHelper(@NonNull Class<? extends LibraryFeature> className) {
		return className2helper.get(className);
	}

	//
	//	Special case processing for collect() return type.
	//
	private static class CollectionCollectHelper extends TemplateParameterSubstitutionHelper
	{
		@Override
		public @Nullable Type resolveReturnType(@NonNull MetaModelManager metaModelManager, @NonNull CallExp callExp, @Nullable Type returnType) {
			LoopExp loopExp = (LoopExp)callExp;
			OCLExpression body = loopExp.getBody();
			Type asType = body != null ? body.getType() : null;
			Type bodyType = asType != null ? PivotUtil.getType(asType) : null;
			if (bodyType != null) {
				@NonNull Type elementType = bodyType;
//				if (bodyType instanceof CollectionType) {
					while (elementType instanceof CollectionType) {
						Type elementType2 = ((CollectionType)elementType).getElementType();
						if (elementType2 != null) {
							elementType = elementType2;
						}
					}
//				}
				boolean isOrdered = (returnType instanceof CollectionType) && ((CollectionType)returnType).isOrdered();
				returnType = metaModelManager.getCollectionType(isOrdered, false, elementType, null, null);	// FIXME null, null
			}
			return returnType;
		}
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
		addHelper(CollectIteration.class, new CollectionCollectHelper());
		addHelper(CollectionFlattenOperation.class, new CollectionFlattenHelper());
	}
}