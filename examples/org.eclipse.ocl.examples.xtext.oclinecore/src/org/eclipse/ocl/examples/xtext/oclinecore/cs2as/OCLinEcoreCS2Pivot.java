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
package org.eclipse.ocl.examples.xtext.oclinecore.cs2as;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2Pivot;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.util.OCLinEcoreCSVisitor;

public class OCLinEcoreCS2Pivot extends EssentialOCLCS2Pivot 
{	
	public OCLinEcoreCS2Pivot(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull OCLinEcoreCSVisitor<Continuation<?>> createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLinEcoreCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull OCLinEcoreCSVisitor<Element> createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLinEcoreCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull OCLinEcoreCSVisitor<Continuation<?>> createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLinEcoreCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull OCLinEcoreCSVisitor<Continuation<?>> createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLinEcoreCSPreOrderVisitor(converter);
	}
}
