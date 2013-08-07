package org.eclipse.ocl.ui.wizards.utils;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;

/**
 * Set of convenient methods which deals with EMF resources (load, save, etc.).<br>
 * 
 */
public final class OCLResourceUtil {

	/**
	 * Private constructor
	 */
	private OCLResourceUtil() {
		// prevent from instanciation
	}

	/**
	 * Loads an EMF resource from a {@link IFile}
	 * 
	 * @param file
	 *            The resource to load given as a {@link IFile}
	 * @return EObject of the model
	 */
	public static Resource loadResource(IFile file) {
		return loadResource(file.getFullPath(), null);
	}

	/**
	 * Loads an EMF resource from a {@link IFile}
	 * 
	 * @param file
	 *            The resource to load given as a {@link IFile}
	 * @return EObject of the model
	 */
	public static Resource loadResource(IFile file, ResourceSet set) {
		return loadResource(file.getFullPath(), set);
	}

	/**
	 * Loads an EMF resource and returns it.
	 * 
	 * @param path
	 *            The resource to load given as a {@link IPath}
	 * @return The loaded resource
	 */
	public static Resource loadResource(IPath path) {
		return loadResource(path, null);
	}

	/**
	 * Loads an EMF resource and returns it.
	 * 
	 * @param path
	 *            The resource to load given as a {@link IPath}
	 * @return The loaded resource
	 */
	public static Resource loadResource(IPath path, ResourceSet set) {
		URI uri = null;
		if (isRelativePath(path)) {
			uri = URI.createPlatformResourceURI(path.toString(), true);
		} else {
			uri = URI.createFileURI(path.toString());
		}
		if (set == null) {
			set = new ResourceSetImpl();
			set.getLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
			set.getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION,
				true);
			set.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("xml", new GenericXMLResourceFactoryImpl()); //$NON-NLS-1$
			set.setPackageRegistry(new EPackageRegistryImpl(
				EPackage.Registry.INSTANCE));
		}
		return set.getResource(uri, true);
	}

	/**
	 * Tests to know if the path is relative or absolute.
	 * 
	 * @param path
	 *            A path
	 * @return
	 */
	private static boolean isRelativePath(IPath path) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot()
			.findMember(path);
		return resource != null && resource.exists();
	}

	/**
	 * Tries to resolve all resources
	 * 
	 * @param model
	 * @return
	 */
	public static EList<Resource> registerResolvedResources(EObject model) {
		EcoreUtil.resolveAll(model);
		EList<Resource> allResources = null;
		if (model.eResource().getResourceSet() != null) {
			allResources = model.eResource().getResourceSet().getResources();
			for (Iterator<Resource> it = allResources.iterator(); it.hasNext();) {
				Resource aResrc = it.next();
				EList<EObject> allPackages = aResrc.getContents();
				for (Iterator<EObject> itP = allPackages.iterator(); itP
					.hasNext();) {
					EPackage aPackage = (EPackage) itP.next();
					MetamodelUtils.registerMetaModel(aPackage);
				}
			}
		}
		return allResources;
	}
}
