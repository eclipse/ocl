package org.eclipse.ocl.ui.common;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class OCLUIPlugin
		extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.ocl.ui"; //$NON-NLS-1$

	// The shared instance
	private static OCLUIPlugin plugin;

	/**
	 * The constructor
	 */
	public OCLUIPlugin() {
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context)
			throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context)
			throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static OCLUIPlugin getDefault() {
		return plugin;
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
	 */
	public static void log(String message, int severity) {
		log(message, severity, null);
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
