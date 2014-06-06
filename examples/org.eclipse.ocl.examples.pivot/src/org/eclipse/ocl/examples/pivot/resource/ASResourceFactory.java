/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintVisitor;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.utilities.AS2Moniker;
import org.eclipse.ocl.examples.pivot.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIidVisitor;
import org.eclipse.ocl.examples.pivot.utilities.ASSaver;
import org.eclipse.ocl.examples.pivot.utilities.ASSaverLocateVisitor;
import org.eclipse.ocl.examples.pivot.utilities.ASSaverNormalizeVisitor;
import org.eclipse.ocl.examples.pivot.utilities.ASSaverResolveVisitor;
import org.eclipse.ocl.examples.pivot.utilities.ToStringVisitor;

/**
 * ASResourceFactory provides Resource-type-dependent functionality for an OCL Abstract Syntax (Pivot) Model
 * without requiring a corresponding Resource to exist. It is therefore typically used to 
 * create ASResource-related artefacts.
 */
public interface ASResourceFactory extends Resource.Factory
{
	int CANNOT_HANDLE = -100;
	int MAY_HANDLE = 0;
	int CAN_HANDLE = 100;
	
	/**
	 * Configure the MetaModelManager's external ResourceSet. Implementations may install
	 * any required extension or content to factory mappings in the resource factory registry.
	 * @param resourceSet
	 */
	void configure(@NonNull ResourceSet resourceSet);

	/**
	 * Create a visitor to compute a structural descriptor for an element. 
	 */
	@NonNull AS2MonikerVisitor createAS2MonikerVisitor(@NonNull AS2Moniker as2moniker);

	/**
	 * Create a visitor to compute the xmi:id value of an element. 
	 */
	@NonNull AS2XMIidVisitor createAS2XMIidVisitor(@NonNull AS2XMIid as2id);

	/**
	 * Create a visitor to locate orphan specializations. 
	 */
	@NonNull ASSaverLocateVisitor createASSaverLocateVisitor(@NonNull ASSaver asSaver);

	/**
	 * Create a visitor to normalize content. 
	 */
	@NonNull ASSaverNormalizeVisitor createASSaverNormalizeVisitor(@NonNull ASSaver asSaver);

	/**
	 * Create a visitor to resolve orphan specializations. 
	 */
	@NonNull ASSaverResolveVisitor createASSaverResolveVisitor(@NonNull ASSaver asSaver);

	/**
	 * Create a visitor to provide a pretty printed representation of one or more elements in the resource. 
	 */
	@NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter prettyPrinter);

	/**
	 * Create a visitor to provide a debug representation of one or more elements in the resource. 
	 */
	@NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s);

	/**
	 * Return the OCL AS element corresponding to eObject using metaModelManager to supervise
	 * the correspondence and ensuring that the result is of asClass.
	 */
	@Nullable <T extends Element> T getASElement(@NonNull MetaModelManager metaModelManager, @NonNull Class<T> asClass, @NonNull EObject eObject) throws ParserException;

	/**
	 * Return the Content Type Identifier supported by this ASResourceFactory.
	 */
	@NonNull String getContentType();

	/**
	 * Return an EOperation for a pivot Operation if one is available.
	 * <br>
	 * For UML this locates the corresponding operation in the Eclipse namespace for the OMG namespace.
	 * @param asResource 
	 */
	@Nullable EOperation getEOperation(@NonNull ASResource asResource, @NonNull EObject eObject);

	@Nullable EReference getEReference(@NonNull ASResource asResource, @NonNull EObject eObject);

	/**
	 * Return a positive handler priority if this factory can handle creation of an OCL AS type from the
	 * available object, negative if it cannot. Generic handlers such as Ecore return a low priority.
	 */
	int getHandlerPriority(@NonNull EObject eObject);

	/**
	 * Return a positive handler priority if this factory can handle creation of an OCL AS resource from the
	 * available resource, negative if it cannot. Generic handlers such as Ecore return a low priority.
	 */
	int getHandlerPriority(@NonNull Resource resource);

	/**
	 * Return a positive handler priority if this factory can handle creation of an OCL AS resource from the
	 * available URI, negative if it cannot. Generic handlers such as Ecore return a low priority.
	 */
	int getHandlerPriority(@NonNull URI uri);

	/**
	 * Return a specific metamodel NsURI if ePackage has particular requirements as is the case for UML.
	 */
	@Nullable String getMetamodelNsURI(@NonNull EPackage ePackage);

	/**
	 * Return the URI of an eObject if it can be treated as a Package.
	 */
	@Nullable URI getPackageURI(@NonNull EObject eObject);
	
	/**
	 * Return the root element in the Pivot resource resulting from import of the available
	 * resource. 
	 * @throws ParserException 
	 */
	@Nullable Element importFromResource(@NonNull MetaModelManager metaModelManager, @NonNull Resource resource, @Nullable URI uri) throws ParserException;

	/**
	 * Return true if newResource can be ignored in favour of an already loaded oldResource.
	 * Return false if an error message is required
	 */
	boolean isCompatibleResource(@NonNull Resource newResource, @NonNull Resource oldResource);
}