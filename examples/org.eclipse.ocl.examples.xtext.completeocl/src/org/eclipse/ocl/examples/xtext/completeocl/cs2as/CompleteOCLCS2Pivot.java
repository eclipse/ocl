/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - Bug 397429
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.completeocl.cs2as;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.util.CompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2Pivot;

public class CompleteOCLCS2Pivot extends EssentialOCLCS2Pivot
{	
	public CompleteOCLCS2Pivot(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull CompleteOCLCSVisitor<Continuation<?>> createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new CompleteOCLCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull CompleteOCLCSVisitor<Element> createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new CompleteOCLCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull CompleteOCLCSVisitor<Continuation<?>> createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new CompleteOCLCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull CompleteOCLCSVisitor<Continuation<?>> createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new CompleteOCLCSPreOrderVisitor(converter);
	}
}
