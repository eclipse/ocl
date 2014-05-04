/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.srclookup;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.launching.OCLLaunchConstants;
import org.eclipse.ocl.examples.debug.vm.srclookup.VMSourcePathComputer;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class OCLSourcePathComputer extends VMSourcePathComputer
{
	public static final @NonNull String ID = "org.eclipse.ocl.examples.debug.srclookup.OCLSourcePathComputer";  //$NON-NLS-1$
	
	public @NonNull String getId() {
		return ID;
	}

	protected IFile getModuleFile(@NonNull ILaunchConfiguration configuration) throws CoreException {
//      String moduleFileName = configuration.getAttribute(LaunchConstants.MODULE, ""); //$NON-NLS-1$
      String moduleFileName = configuration.getAttribute(OCLLaunchConstants.CONSTRAINT_URI, ""); //$NON-NLS-1$
      @SuppressWarnings("null")@NonNull URI trimFragment = URI.createURI(moduleFileName).trimFragment();
      URI moduleUri = PivotUtil.getNonASURI(trimFragment);
      IFile moduleFile = getWorkspaceFile(moduleUri);
      if (moduleFile == null) {
      	//IStatus errorStatus = MiscUtil.makeErrorStatus( 
      		//	NLS.bind(Messages.VMLaunchConfigurationDelegate_transformationFileNotFound, moduleFileName));
      	//throw new CoreException(errorStatus);
      }
      
      return moduleFile;
	}
}
