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
package org.eclipse.ocl.xtext.base.cs2as;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.manager.MetaModelManager;
import org.eclipse.ocl.pivot.internal.resource.ASResource;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

/**
 * BaseCS2AS provides an extensible conversion from CS models to the pivot model.
 */
public class BaseCS2AS extends CS2AS
{	
	public BaseCS2AS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}

	public BaseCS2AS(@NonNull BaseCS2AS cs2as) {
		super(cs2as);
	}

	@Override
	protected @NonNull BaseCSVisitor<Continuation<?>> createContainmentVisitor(@NonNull CS2ASConversion converter) {
		return new BaseCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull BaseCSVisitor<Element> createLeft2RightVisitor(@NonNull CS2ASConversion converter) {
		return new BaseCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull BaseCSVisitor<Continuation<?>> createPostOrderVisitor(@NonNull CS2ASConversion converter) {
		return new BaseCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull BaseCSVisitor<Continuation<?>> createPreOrderVisitor(@NonNull CS2ASConversion converter) {
		return new BaseCSPreOrderVisitor(converter);
	}
}
