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
package org.eclipse.ocl.examples.debug.vm.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;

/**
 * VM Domain Manager is the class responsible for managing the virtual
 * machine meta-models and models. 
 * A VM Domain Manager object encapsulates the domain information need to 
 * modify the domains's models. 
 */
public interface IVMModelManager extends ModelManager
{
	void dispose();
	@NonNull MetamodelManager getMetamodelManager();
}
