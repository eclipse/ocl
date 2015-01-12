package org.eclipse.ocl.pivot.uml;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.uml.internal.es2as.UML2AS;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;

/**
 * Convenient subclass of the <code>OCL</code> fa&ccedil;ade that provides
 * adduitional UML-specific functionality.
 * 
 * @see OCL
 */
public class UMLOCL extends OCL
{
/*	public static class Internal extends UMLOCL
	{
		public static @NonNull EnvironmentFactoryInternal createEnvironmentFactory(@Nullable ProjectManager projectManager) {
			return ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(projectManager);
		}
		
		public static @NonNull Internal newInstance() {
			return newInstance(createEnvironmentFactory(null));
		}
		
		public static @NonNull Internal newInstance(@Nullable ProjectManager projectManager) {	
			return newInstance(createEnvironmentFactory(projectManager));
		}
		
		public static @NonNull Internal newInstance(@NonNull EnvironmentFactoryInternal environmentFactory) {	
			return new Internal(environmentFactory);
		}
		
		public Internal(@NonNull EnvironmentFactoryInternal environmentFactory) {
			super(environmentFactory);
		}

		@Override
		public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
			return getEnvironmentFactoryInternal();
		}

		@Override
		public @NonNull StandardLibraryInternal getStandardLibrary() {
			return getEnvironmentFactoryInternal().getStandardLibrary();
		}
	} */
    /**
     * Creates a new <code>OCL</code> using the specified Ecore package registry.
     * This automatically creates an new EnvironmentFactory and MetamodelManager.
     * 
     * @param reg Ecore package registry
     * @return the new <code>OCL</code>
     */
	public static @NonNull UMLOCL newInstance() {	
		return newInstance(OCL.createEnvironmentFactory(null));
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore package registry.
     * This automatically creates an new EnvironmentFactory and MetamodelManager.
     * 
     * @param reg Ecore package registry
     * @return the new <code>OCL</code>
     */
	public static @NonNull UMLOCL newInstance(@Nullable ProjectManager projectManager) {	
		return newInstance(OCL.createEnvironmentFactory(projectManager));
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

	/**
	 * Return the Pivot resource counterpart of a umlResource.
	 * @throws ParserException 
	 */
	public @NonNull ASResource uml2as(@NonNull Resource umlResource) throws ParserException {
		UML2AS uml2as = UML2AS.getAdapter(umlResource, environmentFactory);
		Model pivotModel = uml2as.getPivotModel();
		ASResource asResource = (ASResource) pivotModel.eResource();
		return ClassUtil.nonNullModel(asResource);
	}
}
