/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - Bug 397429
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.essentialocl.cs2as;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.BaseCS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

public class EssentialOCLCS2Pivot extends BaseCS2Pivot
{		
	public EssentialOCLCS2Pivot(@NonNull Map<? extends /*BaseCS*/Resource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(ElementUtil.apiConvert(cs2asResourceMap), metaModelManager);
	}
	
	public EssentialOCLCS2Pivot(@NonNull EssentialOCLCS2Pivot cs2pivot) {
		super(cs2pivot);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Continuation<?>> createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new EssentialOCLCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Element> createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new EssentialOCLCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Continuation<?>> createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new EssentialOCLCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Continuation<?>> createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new EssentialOCLCSPreOrderVisitor(converter);
	}
}
