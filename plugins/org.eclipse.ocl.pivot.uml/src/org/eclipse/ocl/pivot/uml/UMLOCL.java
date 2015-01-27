package org.eclipse.ocl.pivot.uml;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.OCL;

/**
 * Convenient subclass of the <code>OCL</code> fa&ccedil;ade that provides
 * adduitional UML-specific functionality.
 * 
 * @see OCL
 */
@Deprecated // Adds no value to OCL
public class UMLOCL extends OCL
{
    /**
     * Creates a new <code>OCL</code> using the specified Ecore package registry.
     * This automatically creates an new EnvironmentFactory and MetamodelManager.
     * 
     * @param reg Ecore package registry
     * @return the new <code>OCL</code>
     */
	public static @NonNull UMLOCL newInstance() {	
		return newInstance();
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore package registry.
     * This automatically creates an new EnvironmentFactory and MetamodelManager.
     * 
     * @param reg Ecore package registry
     * @return the new <code>OCL</code>
     */
	public static @NonNull UMLOCL newInstance(@Nullable ProjectManager projectManager) {	
		return newInstance(projectManager);
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment
     * factory.
     * 
     * @param envFactory an environment factory for Ecore
     * @return the new <code>OCL</code>
     */
	public static @NonNull UMLOCL newInstance(@NonNull EnvironmentFactory environmentFactory) {	
		return new UMLOCL((EnvironmentFactoryInternal) environmentFactory);
	}

	protected UMLOCL(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
	}
}
