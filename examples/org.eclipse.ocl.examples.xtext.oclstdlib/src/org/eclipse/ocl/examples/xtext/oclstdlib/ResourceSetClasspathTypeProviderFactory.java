package org.eclipse.ocl.examples.xtext.oclstdlib;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;


@Deprecated // No longer in use
@SuppressWarnings("restriction")
public class ResourceSetClasspathTypeProviderFactory //extends ClasspathTypeProviderFactory
{
//	@Inject
	public ResourceSetClasspathTypeProviderFactory(ClassLoader classLoader) {
//		super(classLoader);
	}

//	@Override
	protected ClasspathTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
		return null;
//		return new ClasspathTypeProvider(resourceSet.getClass().getClassLoader(), resourceSet, getIndexedJvmTypeAccess());
	}
}
