/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class PivotUMLPlugin extends EMFPlugin
{
	public static final String PLUGIN_ID = "org.eclipse.ocl.pivot.uml"; //$NON-NLS-1$

	/**
	 * The singleton instance of the plugin.
	 */
	public static final @NonNull PivotUMLPlugin INSTANCE = new PivotUMLPlugin();

	/**
	 * Creates the singleton instance.
	 */
	private PivotUMLPlugin() {
		super(new ResourceLocator[] {});
	}

	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the Eclipse plugin singleton.
	 * 
	 * @return the plugin singleton.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The plugin singleton
	 */
	private static Implementation plugin;

	/**
	 * A plugin implementation that handles Ecore plugin registration.
	 * 
	 * @see #startup()
	 */
	static public class Implementation extends EclipsePlugin
	{
		/**
		 * Creates the singleton instance.
		 */
		public Implementation() {
			super();
			plugin = this;
		}

		/**
		 * Starts up this plugin by reading some extensions and populating the
		 * relevant registries.
		 * 
		 * @throws Exception
		 *             if there is a show stopping problem.
		 */
		@Override
		public void start(BundleContext context) throws Exception {
			super.start(context);
			UMLStandaloneSetup.init();
		}

		@Override
		public void stop(BundleContext context) throws Exception {
			super.stop(context);
			plugin = null;
		}
	}
}
