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
package org.eclipse.ocl.examples.debug.vm.core;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.utils.Log;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.MetaModelManagerListener;

public abstract class EvaluationContext implements MetaModelManagerListener
{
	private @Nullable MetaModelManager metaModelManager;
	private @Nullable Log log;
	
	public @Nullable Log getLog() {
		return log;
	}

	protected @Nullable MetaModelManager findMetaModelManager() {
		return null;
	}

	public abstract @NonNull URI getDebuggableURI();

	public @NonNull MetaModelManager getMetaModelManager() {
		MetaModelManager metaModelManager2 = metaModelManager;
		if (metaModelManager2 == null) {
			if (metaModelManager2 == null) {
				metaModelManager2 = findMetaModelManager();
			}
			if (metaModelManager2 == null) {
				metaModelManager2 = new MetaModelManager();
			}
			metaModelManager = metaModelManager2;
			metaModelManager2.addListener(this);
		}
		return metaModelManager2;
	}

	@Override
	public void metaModelManagerDisposed(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = null;
	}

	public void setLog(@NonNull Log log) {
		this.log = log;
	}
}
