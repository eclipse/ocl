package org.eclipse.ocl.pivot.uml;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.OCL;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.uml.internal.UML2AS;
import org.eclipse.ocl.pivot.uml.internal.UMLEnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * Convenient subclass of the <code>OCL</code> fa&ccedil;ade that binds the
 * Ecore metamodel to the superclass's generic type parameters.  This frees
 * client code from the long list of parameter substitutions.  This subclass
 * also provides a shortcut to creating an <code>OCL</code> on the shared
 * {@link EnvironmentFactoryInternal} instance.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @see EnvironmentFactoryInternal
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
	public static @NonNull UMLOCL newInstance(@Nullable StandaloneProjectMap projectMap, @Nullable ModelManager modelManager) {	
		return newInstance(new UMLEnvironmentFactory(projectMap, modelManager));
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment
     * factory.
     * 
     * @param envFactory an environment factory for Ecore
     * @return the new <code>OCL</code>
     */
	public static @NonNull UMLOCL newInstance(@NonNull EnvironmentFactoryInternal envFactory) {	
		return new UMLOCL(envFactory);
	}

	protected UMLOCL(EnvironmentFactoryInternal envFactory) {
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
