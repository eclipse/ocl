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
package org.eclipse.ocl.pivot.internal.manager;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.library.executor.ExecutorManager;
import org.eclipse.ocl.pivot.library.executor.LazyModelManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * A PivotExecutorManager instance provides the bridge between a conventional EMF execution context
 * and the richer OCL Pivot concepts. Since the OCL concepts are not needed for simple expressions
 * that make no use of types, the default construction is lightweight deferring construction costs
 * until actually needed.
 */
public class PivotExecutorManager extends ExecutorManager
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull PivotIdResolver idResolver;
	protected final @NonNull EObject contextObject;
	private @Nullable ModelManager modelManager = null;

	public PivotExecutorManager(@NonNull MetaModelManager metaModelManager, @NonNull EObject contextObject) {
		super(metaModelManager.getCompleteEnvironment());
		this.metaModelManager = metaModelManager;
		this.idResolver = metaModelManager.getIdResolver();
		this.contextObject = contextObject;
		idResolver.addRoot(ClassUtil.nonNullEMF(EcoreUtil.getRootContainer(contextObject)));
	}

	protected @NonNull IdResolver createIdResolver() {
		return metaModelManager.getIdResolver();
	}

	@Override
	public @NonNull Evaluator createNestedEvaluator() {
		return new PivotExecutorManager(metaModelManager, contextObject);
	}

	@Override
	public @NonNull Type getDynamicTypeOf(@Nullable Object value) {
		return idResolver.getDynamicTypeOf(value);
	}

	@Override
	public @NonNull ModelManager getModelManager() {
		ModelManager modelManager2 = modelManager;
		if (modelManager2 == null) {
			synchronized (this) {
				modelManager2 = modelManager;
				if (modelManager2 == null) {
					modelManager2 = new LazyModelManager(contextObject)
					{
						@Override
						protected boolean isInstance(@NonNull Type type, @NonNull EObject element) {
							EClass eClass = ClassUtil.nonNullEMF(element.eClass());
							Type elementType = idResolver.getInheritance(eClass).getType();
							return elementType.conformsTo(standardLibrary, type);
						}
						
					};
					modelManager = modelManager2;
				}
			}
		}
		return modelManager2;
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		return idResolver;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value) {
		return idResolver.getStaticTypeOf(value);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return idResolver.getStaticTypeOf(value, values);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		return idResolver.getStaticTypeOf(value, values);
	}
}