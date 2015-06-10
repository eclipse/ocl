/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

public interface IVMEvaluator
{
	Object execute();

	@NonNull NamedElement getDebuggable();

	@NonNull EnvironmentFactory getEnvironmentFactory();
	
	@NonNull IVMModelManager getVMModelManager();

	void saveModels();

	void setSuspendOnStartUp(boolean suspendOnStartup);
}
