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

package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.AbstractEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.PivotEvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;



/**
 * Implementation of the {@link EnvironmentFactory} for parsing OCL expressions
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
			globalRegistryInstance.getMetaModelManager().dispose();
			globalRegistryInstance = null;
		}
	}
	
	public static @NonNull PivotEnvironmentFactory getGlobalRegistryInstance() {
		PivotEnvironmentFactory globalRegistryInstance2 = globalRegistryInstance;
		if (globalRegistryInstance2 == null) {
			globalRegistryInstance = globalRegistryInstance2 = new PivotEnvironmentFactory();
		}
		return globalRegistryInstance2;
	}
	
    protected final @NonNull MetaModelManager metaModelManager;

	private final @Nullable EPackage.Registry registry;

	/**
	 * Initializes me.  Environments that I create will use the global package
     * registry to look up packages.
	 */
	public PivotEnvironmentFactory() {
		this(EPackage.Registry.INSTANCE, null);
	}
	
	/**
	 * Initializes me with an <code>EPackage.Registry</code> that the
     * environments I create will use to look up packages.
     * 
     * @param reg my package registry
	 * @param metaModelManager 
	 */
	public PivotEnvironmentFactory(@Nullable EPackage.Registry reg, @Nullable MetaModelManager metaModelManager) {
		super();
		this.registry = reg;
		this.metaModelManager = metaModelManager != null ? metaModelManager : new MetaModelManager();
	}
	
    // implements the inherited specification
    public @NonNull PivotEnvironment createEnvironment() {
		PivotEnvironment result = new PivotEnvironment(this, null);
		return result;
	}
	
    // implements the inherited specification
    public @NonNull PivotEnvironment loadEnvironment(@NonNull Resource resource) {
    	PivotEnvironment result = new PivotEnvironment(this, resource);
		return result;
	}
	
    /**
     * Obtains the package registry used by environment that I create to look
     * up packages.
     * 
     * @return my package registry
     */
	public final @Nullable EPackage.Registry getEPackageRegistry() {
		return registry;
	}

    // implements the inherited specification
	public @NonNull PivotEnvironment createEnvironment(@NonNull Environment parent) {
		if (!(parent instanceof PivotEnvironment)) {
			throw new IllegalArgumentException(
				"Parent environment must be a Pivot environment: " + parent); //$NON-NLS-1$
		}
		
		PivotEnvironment result = new PivotEnvironment((PivotEnvironment) parent);
		return result;
	}

    // implements the inherited specification
	public @NonNull EvaluationEnvironment createEvaluationEnvironment() {
		return new PivotEvaluationEnvironment(getMetaModelManager());
	}

    // implements the inherited specification
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent) {
		return new PivotEvaluationEnvironment(parent);
	}

	@Override
	protected @NonNull Type getClassifier(@NonNull Object context) {
		DomainType dType = metaModelManager.getIdResolver().getStaticTypeOf(context);
		return metaModelManager.getType(dType);
	}
	
	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}
}
