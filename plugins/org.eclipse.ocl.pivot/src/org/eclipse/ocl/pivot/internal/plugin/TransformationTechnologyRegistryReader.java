/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.plugin;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.evaluation.tx.TransformationTechnologyContribution;
import org.eclipse.ocl.pivot.util.PivotPlugin;

/**
 * A plugin extension reader that populates the
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#INSTANCE
 * global} resource factory's
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#getProtocolToFactoryMap()
 * protocol} map. Clients are not expected to use this class directly.
 * @since 1.1
 */
public class TransformationTechnologyRegistryReader extends RegistryReader
{
	static final @NonNull String TAG_LIBRARY = "library";
	static final @NonNull String ATT_URI = "uri";
	static final @NonNull String ATT_CLASS = "class";

	public TransformationTechnologyRegistryReader() {
		super(Platform.getExtensionRegistry(), PivotPlugin.PLUGIN_ID, PivotPlugin.TRANSFORMATION_TECHNOLOGY_PPID);
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		if (element.getName().equals(TAG_LIBRARY)) {
			String uri = element.getAttribute(ATT_URI);
			if (uri == null) {
				logMissingAttribute(element, ATT_URI);
			} else if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
			} else if (add) {
				Object previous = TransformationTechnologyContribution.REGISTRY
					.put(uri, new TransformationTechnologyContribution.Descriptor(element, "org.eclipse.qvtd.ocl2qvti", ATT_CLASS));
				if (previous instanceof TransformationTechnologyContribution.Descriptor) {
					TransformationTechnologyContribution.Descriptor descriptor = (TransformationTechnologyContribution.Descriptor) previous;
					EcorePlugin.INSTANCE.log("Both '"
						+ descriptor.getElement().getContributor().getName()
						+ "' and '" + element.getContributor().getName()
						+ "' register a transformation technology for '" + uri
						+ "'");
				}
				return true;
			} else {
				TransformationTechnologyContribution.REGISTRY.remove(uri);
				return true;
			}
		}
	    return false;
	}
}
