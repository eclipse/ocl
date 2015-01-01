/*******************************************************************************
 * Copyright (c) 2005, 2013 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (University of York) - Bug 415697
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.utilities;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.evaluation.PivotEvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.evaluation.PivotModelManager;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentFactory;
import org.eclipse.ocl.pivot.values.ObjectValue;



/**
 * Implementation of the {@link EnvironmentFactoryInternal} for parsing OCL expressions
 * on Ecore models.
 *
 * @author Christian W. Damus (cdamus)
 */
public class PivotEnvironmentFactory extends AbstractEnvironmentFactory {
	
	/**
     * A convenient shared instance of the environment factory, that creates
     * environments using the global package registry.
	 */
    private static @Nullable PivotEnvironmentFactory globalRegistryInstance = null;

	public static @Nullable PivotEnvironmentFactory basicGetGlobalRegistryInstance() {
		return globalRegistryInstance;
	}

    /**
     * Dispose of the global instance; this is intended for leakage detection in tests.
     */
	public static void disposeGlobalRegistryInstance() {
		if (globalRegistryInstance != null) {
			globalRegistryInstance.getMetamodelManager().dispose();
			globalRegistryInstance = null;
		}
	}
	
	public static @NonNull PivotEnvironmentFactory getGlobalRegistryInstance() {
		PivotEnvironmentFactory globalRegistryInstance2 = globalRegistryInstance;
		if (globalRegistryInstance2 == null) {
			globalRegistryInstance = globalRegistryInstance2 = new PivotEnvironmentFactory(null, null);
		}
		return globalRegistryInstance2;
	}
	
	/**
	 * Initializes me with an optional <code>StandaloneProjectMap</code> of accessible resources and
	 * an optional <code>ModelManager</code> for loaded instances.
	 */
	public PivotEnvironmentFactory(@Nullable StandaloneProjectMap projectMap, @Nullable ModelManager modelManager) {
		super(projectMap, modelManager);
	}

    // implements the inherited specification
	@Override
	public @NonNull EvaluationEnvironment createEvaluationEnvironment() {
		return new PivotEvaluationEnvironment(this);
	}

    // implements the inherited specification
	@Override
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent) {
		return new PivotEvaluationEnvironment(parent);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NonNull ModelManager createModelManager(@Nullable Object object) {
		if (object instanceof ObjectValue) {
			object = ((ObjectValue) object).getObject();
		}
		if (object instanceof EObject) {
			return new PivotModelManager(getMetamodelManager(), (EObject) object);
		}
		return ModelManager.NULL;
	}

	@Override
	protected @NonNull org.eclipse.ocl.pivot.Class getClassifier(@NonNull Object context) {
		MetamodelManager metamodelManager = getMetamodelManager();
		org.eclipse.ocl.pivot.Class dType = metamodelManager.getIdResolver().getStaticTypeOf(context);
		return metamodelManager.getType(dType);
	}

	@Override
	public String getOriginalName(@NonNull ENamedElement eNamedElement) {
		return eNamedElement.getName();
	}
}
