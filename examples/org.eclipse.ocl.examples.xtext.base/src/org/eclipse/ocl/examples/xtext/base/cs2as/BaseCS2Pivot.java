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
package org.eclipse.ocl.examples.xtext.base.cs2as;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;

/**
 * BaseCS2Pivot provides an extensible conversion from CS models to the pivot model.
 */
public class BaseCS2Pivot extends CS2Pivot
{	
	public BaseCS2Pivot(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}

	public BaseCS2Pivot(@NonNull BaseCS2Pivot cs2pivot) {
		super(cs2pivot);
	}

	@Override
	protected @NonNull BaseCSVisitor<Continuation<?>> createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new BaseCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull BaseCSVisitor<Element> createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new BaseCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull BaseCSVisitor<Continuation<?>> createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new BaseCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull BaseCSVisitor<Continuation<?>> createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new BaseCSPreOrderVisitor(converter);
	}
}
