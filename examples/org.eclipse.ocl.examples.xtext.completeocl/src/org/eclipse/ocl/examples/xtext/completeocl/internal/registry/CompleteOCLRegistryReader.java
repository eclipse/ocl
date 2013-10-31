/**
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 */
package org.eclipse.ocl.examples.xtext.completeocl.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.ocl.examples.xtext.completeocl.utilities.CompleteOCLPlugin;

/**
 * A plugin extension reader that populates the complete OCL resource registry.
 * 
 * @author <a href="mailto:marwa.rostren@obeo.fr">Marwa Rostren</a>
 */
public class CompleteOCLRegistryReader
		extends RegistryReader {
	private static final String TAG_RESOURCE = "completeOCLResource";

	private static final String ATTRIBUTE_RESOURCE = "resource";

	public CompleteOCLRegistryReader() {
		super(Platform.getExtensionRegistry(), CompleteOCLPlugin.getPlugin()
			.getBundle().getSymbolicName(),
			CompleteOCLPlugin.OCL_RESOURCE_REGISTRY_PID);
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		if (!TAG_RESOURCE.equals(element.getName())) {
			return false;
		}

		final String filePath = element.getAttribute(ATTRIBUTE_RESOURCE);
		final boolean recognized;
		if (filePath == null) {
			logMissingAttribute(element, ATTRIBUTE_RESOURCE);
			recognized = false;
		} else {
			final URI fileURI = makeFileURI(element, filePath);
			if (add) {
				CompleteOCLRegistry.addURI(fileURI);
			} else {
				CompleteOCLRegistry.removeURI(fileURI);
			}
			recognized = true;
		}

		return recognized;
	}

	private URI makeFileURI(IConfigurationElement element, String path) {
		URI resourceURI = URI.createURI(path);
		if (resourceURI.isRelative()) {
			resourceURI = URI.createPlatformPluginURI(element
				.getDeclaringExtension().getContributor().getName()
				+ '/' + path, true);
		}
		return resourceURI;
	}
}
