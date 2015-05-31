/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;

/**
 * OCL Domain Manager is the class responsible for managing the OCL virtual
 * machine meta-models and models. 
 * A OCL Domain Manager object encapsulates the domain information need to 
 * modify the domains's models. 
 */
public abstract class VMModelManager implements IVMModelManager
{
	protected final @NonNull MetamodelManagerInternal metamodelManager;

	protected VMModelManager(@NonNull MetamodelManagerInternal metamodelManager) {
		this.metamodelManager = metamodelManager;
	}

	public @NonNull MetamodelManagerInternal getMetamodelManager() {
		return metamodelManager;
	}
}
