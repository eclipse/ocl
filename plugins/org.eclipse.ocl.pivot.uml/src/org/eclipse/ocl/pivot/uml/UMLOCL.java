package org.eclipse.ocl.pivot.uml;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
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
	public static @NonNull UMLOCL newInstance(@NonNull EnvironmentFactory envFactory) {	
		return new UMLOCL((EnvironmentFactoryInternal) envFactory);
	}

	protected UMLOCL(@NonNull EnvironmentFactoryInternal envFactory) {
		super(envFactory);
	}

	/**
	 * Return the Pivot resource counterpart of a umlResource.
	 * @throws ParserException 
	 */
	public @NonNull ASResource uml2as(@NonNull Resource umlResource) throws ParserException {
		MetamodelManager metamodelManager = getMetamodelManager();
		UML2AS uml2as = UML2AS.getAdapter(umlResource, metamodelManager);
		Model pivotModel = uml2as.getPivotModel();
		ASResource asResource = (ASResource) pivotModel.eResource();
		return ClassUtil.nonNullModel(asResource);
	}
}
