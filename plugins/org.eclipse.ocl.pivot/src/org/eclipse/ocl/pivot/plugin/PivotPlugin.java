/*******************************************************************************
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.plugin;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;

public final class PivotPlugin extends EMFPlugin
{
	// The plug-in ID
	public static final @NonNull String PLUGIN_ID = "org.eclipse.ocl.pivot";
	public static final @NonNull PivotPlugin INSTANCE = new PivotPlugin();

	public static final @NonNull String LABEL_GENERATOR_PPID = "label_generator";
	public static final @NonNull String STANDARD_LIBRARY_PPID = "standard_library";
	public static final @NonNull String COMPLETE_OCL_REGISTRY_PID = "complete_ocl_registry";
	public static final @NonNull String COMPLETE_OCL_REGISTRY_QPID = PLUGIN_ID + "." + COMPLETE_OCL_REGISTRY_PID;

	private static Implementation plugin;

	public PivotPlugin() {
		super
		  (new ResourceLocator [] {
		     EcorePlugin.INSTANCE,
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * @return the singleton instance.
	 */
	@Override public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * @return the singleton instance.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}
	
	public static void logError(String string, Throwable e) {
		if (plugin != null)
			plugin.logError(string, e);
		else
			System.err.println(string);
	}		

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
		
		public void logError(String string, Throwable e) {
			logException(newError(string, e));
		}		

		public void logException(Throwable e) {
			if (e instanceof InvocationTargetException) {
				e = ((InvocationTargetException) e).getTargetException();
			}
			IStatus status = null;
			if (e instanceof CoreException) {
				status = ((CoreException) e).getStatus();
			} else {
				String message = e.getMessage();
				if (message == null)
					message = e.toString();
				status = new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, message, e);
			}
			log(status);
		}
		
	    /**
	     * Return a CoreException with Error severity containing a text description and optionally
	     * wrapping a further exception.
	     * @param text description of exception
	     * @param exception optional wrapped exception
	     */
	    public CoreException newError(String text, Throwable exception) {
	        return new CoreException(new Status(IStatus.ERROR,
					PLUGIN_ID, IStatus.ERROR, "ERROR -- " + text, exception));
	    }
	}
}
