/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.ui;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.internal.EssentialOCLActivator;

public class EssentialOCLUiPluginHelper extends EMFPlugin.InternalHelper
{
	public static final EssentialOCLUiPluginHelper INSTANCE = new EssentialOCLUiPluginHelper(EssentialOCLActivator.getInstance()); 
	
	private EssentialOCLUiPluginHelper(Plugin plugin) {
		super(plugin);
	}

	public Status createErrorStatus(Exception e) {
		return new Status(Status.ERROR, getSymbolicName(), e.getMessage(), e);
	}
}
