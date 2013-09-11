/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     Obeo - add log and image descriptor facilities
 *******************************************************************************/
package org.eclipse.ocl.common.ui.internal;

import java.text.MessageFormat;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.internal.misc.StatusUtil;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

@SuppressWarnings("restriction")
public class Activator extends AbstractUIPlugin implements BundleActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.ocl.common.ui"; //$NON-NLS-1$
	

	// The shared instance
	private static Activator plugin;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}
	
	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	/**
	 * Return the workspace used by the workbench
	 * 
	 * This method is internal to the workbench and must not be called by any
	 * plugins.
	 */
	public static IWorkspace getPluginWorkspace() {
		return ResourcesPlugin.getWorkspace();
	}
	
	/**
	 * Gets the Id of the Plugin
	 * 
	 * @return the Plugin Identifier
	 */
	private static String getId() {
		return getDefault().getBundle().getSymbolicName();
	}
	
	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	/**
	 * Logs the given message and throwable to the platform log.
	 * 
	 * If you have a status object in hand call log(String, IStatus) instead.
	 * 
	 * This convenience method is for internal use by the IDE Workbench only and
	 * must not be called outside the IDE Workbench.
	 * 
	 * @param message
	 *            A high level UI message describing when the problem happened.
	 * @param t
	 *            The throwable from where the problem actually occurred.
	 */
	public static void log(String message, Throwable t) {
		IStatus status = StatusUtil.newStatus(IStatus.ERROR, message, t);
		log(message, status);
	}

	/**
	 * Logs the given throwable to the platform log, indicating the class and
	 * method from where it is being logged (this is not necessarily where it
	 * occurred).
	 * 
	 * This convenience method is for internal use by the IDE Workbench only and
	 * must not be called outside the IDE Workbench.
	 * 
	 * @param clazz
	 *            The calling class.
	 * @param methodName
	 *            The calling method name.
	 * @param t
	 *            The throwable from where the problem actually occurred.
	 */
	public static void log(@SuppressWarnings("rawtypes") Class clazz, String methodName, Throwable t) {
		String msg = MessageFormat.format("Exception in {0}.{1}: {2}", //$NON-NLS-1$
			new Object[]{clazz.getName(), methodName, t});
		log(msg, t);
	}

	/**
	 * Logs the given message and status to the platform log.
	 * 
	 * This convenience method is for internal use by the IDE Workbench only and
	 * must not be called outside the IDE Workbench.
	 * 
	 * @param message
	 *            A high level UI message describing when the problem happened.
	 *            May be <code>null</code>.
	 * @param status
	 *            The status describing the problem. Must not be null.
	 */
	public static void log(String message, IStatus status) {

		if (message != null) {
			getDefault().getLog().log(
				StatusUtil.newStatus(IStatus.ERROR, message, null));
		}

		getDefault().getLog().log(status);
	}
	

	/**
	 * Logs a message with given level into the Eclipse log file
	 * 
	 * @param message
	 *            the message to log
	 * @param severity
	 *            the message priority
	 */
	public static void log(Exception e) {
		log(e.getMessage(), IStatus.ERROR, e);
	}

	/**
	 * Logs a message with given level into the Eclipse log file
	 * 
	 * @param message
	 *            the message to log
	 * @param severity
	 *            the message priority
	 * @param e
	 *            exception to log
	 */
	public static void log(String message, int severity, Exception e) {
		IStatus status = new Status(severity, getId(), severity, message, e);
		getDefault().getLog().log(status);
	}

}
