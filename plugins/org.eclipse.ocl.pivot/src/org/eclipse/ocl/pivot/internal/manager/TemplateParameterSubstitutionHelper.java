/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.collection.CollectionAsBagOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsOrderedSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSequenceOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludingAllOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionFlattenOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIntersectionOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionMinOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionAtOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionLastOperation;
import org.eclipse.ocl.pivot.library.iterator.AnyIteration;
import org.eclipse.ocl.pivot.library.iterator.CollectIteration;
import org.eclipse.ocl.pivot.library.iterator.RejectIteration;
import org.eclipse.ocl.pivot.library.iterator.SelectIteration;
import org.eclipse.ocl.pivot.library.iterator.SortedByIteration;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * TemplateParameterSubstitutionHelper instances support irregular YemplateParameterSubstitution deduction for difficult to
 * model operations such as flatten().
 * <p>
 * The TemplateParameterSubstitutionHelper maintains a registry of helpers indexed by their implementatin class.
 */
public abstract class TemplateParameterSubstitutionHelper 
{
	public void resolveUnmodeledTemplateParameterSubstitutions(@NonNull TemplateParameterSubstitutionVisitor templateParameterSubstitutions, @NonNull CallExp callExp) {}

	public @Nullable Type resolveBodyType(@NonNull PivotMetamodelManager metamodelManager, @NonNull CallExp callExp, @Nullable Type bodyType) {
		return bodyType;
	}

	public @Nullable Type resolveReturnType(@NonNull PivotMetamodelManager metamodelManager, @NonNull CallExp callExp, @Nullable Type returnType) {
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
	//	Special case processing for collect() return and body types.
	//
	private static class CollectionCollectHelper extends TemplateParameterSubstitutionHelper
	{
		@Override
		public @Nullable Type resolveBodyType(@NonNull PivotMetamodelManager metamodelManager, @NonNull CallExp callExp, @Nullable Type returnType) {
			LoopExp loopExp = (LoopExp)callExp;
			OCLExpression body = loopExp.getOwnedBody();
			Type asType = body != null ? body.getType() : null;
			Type bodyType = asType != null ? PivotUtilInternal.getType(asType) : null;
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
				return elementType;
			}
			return returnType;
		}

		@Override
		public @Nullable Type resolveReturnType(@NonNull PivotMetamodelManager metamodelManager, @NonNull CallExp callExp, @Nullable Type returnType) {
			LoopExp loopExp = (LoopExp)callExp;
			OCLExpression body = loopExp.getOwnedBody();
			Type asType = body != null ? body.getType() : null;
			Type bodyType = asType != null ? PivotUtilInternal.getType(asType) : null;
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
				boolean isNullFree;
				boolean isRequired;
				IntegerValue lower;
				UnlimitedNaturalValue upper;
				if (asType instanceof CollectionType) {
					CollectionType asCollectionReturnType = (CollectionType)asType;
					isNullFree = asCollectionReturnType.isIsNullFree();
					isRequired = false;
					lower = asCollectionReturnType.getLowerValue();
					upper = asCollectionReturnType.getUpperValue();
				}
				else {
					isNullFree = false;
					isRequired = (body != null) && body.isIsRequired();
					lower = ValueUtil.ZERO_VALUE;
					upper = ValueUtil.UNLIMITED_VALUE;
				}
				returnType = metamodelManager.getCollectionType(isOrdered, false, elementType, isNullFree || isRequired, lower, upper);
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
			Type elementType = callExp.getOwnedSource().getType();
			while (elementType instanceof CollectionType) {
				elementType = ((CollectionType)elementType).getElementType();
			}
			templateParameterSubstitutions.put(1, elementType);
		}
	}

	//
	//	Special case processing for return types based pn the source.
	//
	private static class CollectionSourceHelper extends TemplateParameterSubstitutionHelper
	{
		@Override
		public @Nullable Type resolveReturnType(@NonNull PivotMetamodelManager metamodelManager, @NonNull CallExp callExp, @Nullable Type returnType) {
			if (returnType instanceof CollectionType) {
				OCLExpression ownedSource = callExp.getOwnedSource();
				if (ownedSource != null) {
					Type sourceType = ownedSource.getType();
					CollectionType collectionType = (CollectionType)returnType;
					if ((sourceType instanceof CollectionType) && ((CollectionType)sourceType).isIsNullFree() && !collectionType.isIsNullFree()) {
						@SuppressWarnings("null")@NonNull Type elementType = collectionType.getElementType();
						returnType = metamodelManager.getCollectionType(collectionType.isOrdered(), collectionType.isUnique(),
							elementType, true, collectionType.getLowerValue(), collectionType.getUpperValue());
					}
				}
			}
			return returnType;
		}
	}
	
	static
	{
		addHelper(AnyIteration.class, new CollectionSourceHelper());
		addHelper(CollectIteration.class, new CollectionCollectHelper());
		addHelper(CollectionAsBagOperation.class, new CollectionSourceHelper());
		addHelper(CollectionAsOrderedSetOperation.class, new CollectionSourceHelper());
		addHelper(CollectionAsSequenceOperation.class, new CollectionSourceHelper());
		addHelper(CollectionAsSetOperation.class, new CollectionSourceHelper());
		addHelper(CollectionExcludingOperation.class, new CollectionSourceHelper());
		addHelper(CollectionExcludingAllOperation.class, new CollectionSourceHelper());
//		addHelper(CollectionIncludingOperation.class, new CollectionSourceAndArgumentHelper());
//		addHelper(CollectionIncludingAllOperation.class, new CollectionSourceAndArgumentHelper());
		addHelper(CollectionIntersectionOperation.class, new CollectionSourceHelper()/*OrArgument*/);
		addHelper(CollectionMinOperation.class, new CollectionSourceHelper());
		addHelper(OrderedCollectionAtOperation.class, new CollectionSourceHelper());
		addHelper(OrderedCollectionFirstOperation.class, new CollectionSourceHelper());
		addHelper(OrderedCollectionLastOperation.class, new CollectionSourceHelper());
		addHelper(CollectionFlattenOperation.class, new CollectionFlattenHelper());
		addHelper(RejectIteration.class, new CollectionSourceHelper());
		addHelper(SelectIteration.class, new CollectionSourceHelper());
		addHelper(SortedByIteration.class, new CollectionSourceHelper());
	}
}