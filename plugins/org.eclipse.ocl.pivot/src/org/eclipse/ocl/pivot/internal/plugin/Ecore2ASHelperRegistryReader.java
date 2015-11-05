/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2ASHelperContribution;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2ASHelperRegistry;
import org.eclipse.ocl.pivot.util.PivotPlugin;

/**
 * A plugin extension reader that populates the
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#INSTANCE
 * global} resource factory's
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#getProtocolToFactoryMap()
 * protocol} map. Clients are not expected to use this class directly.
 * @since 1.1
 */
public class Ecore2ASHelperRegistryReader extends RegistryReader
{
	static final @NonNull String TAG_METAMODEL = "metamodel";
	static final @NonNull String TAG_MODEL = "model";
	static final @NonNull String ATT_URI = "uri";
	static final @NonNull String ATT_CLASS = "class";

	public Ecore2ASHelperRegistryReader() {
		super(Platform.getExtensionRegistry(), PivotPlugin.getPlugin()
			.getBundle().getSymbolicName(), PivotPlugin.ECORE2AS_HELPER_PPID);
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		boolean isMetamodel = element.getName().equals(TAG_METAMODEL);
		boolean isModel = element.getName().equals(TAG_MODEL);
		if (isMetamodel || isModel) {
			String uri = element.getAttribute(ATT_URI);
			if (uri == null) {
				logMissingAttribute(element, ATT_URI);
			} else if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
			} else if (add) {
				Ecore2ASHelperContribution.Descriptor newDescriptor = new Ecore2ASHelperContribution.Descriptor(element, uri, isModel, ATT_CLASS);
				Object previous = Ecore2ASHelperRegistry.INSTANCE.addEcore2ASHelper(uri, newDescriptor);
				if (previous instanceof Ecore2ASHelperContribution.Descriptor) {
					Ecore2ASHelperContribution.Descriptor descriptor = (Ecore2ASHelperContribution.Descriptor) previous;
					EcorePlugin.INSTANCE.log("Both '"
						+ descriptor.getElement().getContributor().getName()
						+ "' and '" + element.getContributor().getName()
						+ "' register an Ecore2ASHelper for '" + uri
						+ "'");
				}
				return true;
			} else {
				Ecore2ASHelperRegistry.INSTANCE.remove(uri, isModel);
				return true;
			}
		}
	    return false;
	}
}
