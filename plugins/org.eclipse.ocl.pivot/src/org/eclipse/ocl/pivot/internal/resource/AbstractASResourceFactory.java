/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.EssentialOCLPrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.pivot.utilities.AS2XMIidVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverLocateVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverNormalizeVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverResolveVisitor;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;

/**
 * AbstractASResourceFactory provides the abstract functionality for creating and maintaining
 * OCL Abstract Syntax Resources.
 */
public abstract class AbstractASResourceFactory extends ResourceFactoryImpl implements ASResourceFactory
{
	public static void installContentHandler(int priority, @NonNull ContentHandler contentHandler) {
		List<ContentHandler> contentHandlers = ContentHandler.Registry.INSTANCE.get(priority);
		if (contentHandlers == null) {
			contentHandlers = new ArrayList<ContentHandler>();
			ContentHandler.Registry.INSTANCE.put(priority, contentHandlers);
		}
		if (!contentHandlers.contains(contentHandler)) {
			contentHandlers.add(contentHandler);
		}
	}

	protected final @NonNull String contentType;

	protected AbstractASResourceFactory(@NonNull String contentType) {
		this.contentType = contentType;
}

	@Override
	public void configure(@NonNull ResourceSet resourceSet) {
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
		resourceFactoryRegistry.getContentTypeToFactoryMap().put(contentType, this);
	}

	protected void configureResource(@NonNull ASResource asResource) {
		asResource.setEncoding(ASResource.DEFAULT_ENCODING);
		Map<Object, Object> defaultSaveOptions = asResource.getDefaultSaveOptions();
		defaultSaveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		defaultSaveOptions.put(XMLResource.OPTION_LINE_WIDTH, 80);
		defaultSaveOptions.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
		defaultSaveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		defaultSaveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
	}
	
	@Override
	public @NonNull AS2MonikerVisitor createAS2MonikerVisitor(@NonNull AS2Moniker as2moniker) {
		return new AS2MonikerVisitor(as2moniker);
	}

	@Override
	public @NonNull AS2XMIidVisitor createAS2XMIidVisitor(@NonNull AS2XMIid as2id) {
		return new AS2XMIidVisitor(as2id);
	}

	@Override
	public @NonNull ASSaverLocateVisitor createASSaverLocateVisitor(@NonNull ASSaver saver) {
		return new ASSaverLocateVisitor(saver);
	}

	@Override
	public @NonNull ASSaverNormalizeVisitor createASSaverNormalizeVisitor(@NonNull ASSaver saver) {
		return new ASSaverNormalizeVisitor(saver);
	}

	@Override
	public @NonNull ASSaverResolveVisitor createASSaverResolveVisitor(@NonNull ASSaver saver) {
		return new ASSaverResolveVisitor(saver);
	}
	
	@Override
	public @NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter prettyPrinter) {
		return new EssentialOCLPrettyPrintVisitor(prettyPrinter);
	}
	
	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(@NonNull MetamodelManager metamodelManager, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		return new TemplateParameterSubstitutionVisitor(metamodelManager, selfType, selfTypeValue);
	}

	@Override
	public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
		return new ToStringVisitor(s);
	}

	/**
	 * Creates an instance of the resource.
	 */
	@Override
	public Resource createResource(URI uri) {
		assert uri != null;
		ASResource result = new ASResourceImpl(uri, this);
		configureResource(result);
	    return result;
	}

	@Override
	public @Nullable <T extends Element> T getASElement(@NonNull MetamodelManager metamodelManager,
			@NonNull Class<T> pivotClass, @NonNull EObject eObject) throws ParserException {
		throw new UnsupportedOperationException(getClass().getName() + ".getPivotOf");
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return this;
	}

	@Override
	public @NonNull ASResourceFactoryContribution getContribution() {
		return this;
	}

	@Override
	public @NonNull String getContentType() {
		return contentType;
	}

	@Override
	public @Nullable EOperation getEOperation(@NonNull ASResource asResource, @NonNull EObject eObject) {
		return null;
	}
	
	@Override
	public @Nullable EReference getEReference(@NonNull ASResource asResource, @NonNull EObject eObject) {
		return null;
	}

	@Override
	public @Nullable String getMetamodelNsURI(@NonNull EPackage ePackage) {
		return null;
	}

	@Override
	public @Nullable URI getPackageURI(@NonNull EObject eObject) {
		return null;
	}

	@Override
	public @Nullable Element importFromResource(@NonNull MetamodelManager metamodelManager,
			@NonNull Resource resource, @Nullable URI uri) throws ParserException {
		if (resource instanceof ASResource) {
			if (uri == null) {
				return null;
			}
			String fragment = uri.fragment();
			if (fragment == null) {
				return null;
			}
			EObject eObject = resource.getEObject(fragment);
			if (eObject instanceof Element) {
				return (Element) eObject;
			}
			else {
				return null;
			}
		}
		throw new UnsupportedOperationException(getClass().getName() + ".importFromResource");
	}

	@Override
	public void initializeEValidatorRegistry(@NonNull EValidator.Registry eValidatorRegistry) {}

	protected void install(@Nullable String oclasExtension, @Nullable String resourceClassName) {
		ASResourceFactoryRegistry.INSTANCE.addASResourceFactory(contentType, oclasExtension, resourceClassName, this);
	}

	@Override
	public boolean isCompatibleResource(@NonNull Resource newResource, @NonNull Resource oldResource) {
		return false;
	}

	@Override
	public @NonNull String toString() {
		return contentType;
	}
}
