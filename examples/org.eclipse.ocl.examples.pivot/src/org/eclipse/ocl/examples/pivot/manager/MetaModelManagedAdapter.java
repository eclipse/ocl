/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.jdt.annotation.NonNull;

public interface MetaModelManagedAdapter extends Adapter.Internal, MetaModelManagerListener
{		
	boolean isAdapterFor(@NonNull MetaModelManager metaModelManager);
}