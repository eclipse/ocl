/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

/**
 * A ValueId provides a unique hierarchical semantic identifier for a value used as part of a template specialization.
 * <p>
 */
public interface ValueId extends ElementId
{
	public static final @NonNull ValueId FALSE_ID = IdManager.getValueId(ValueUtil.FALSE_VALUE);
	public static final @NonNull ValueId ONE_ID = IdManager.getValueId(ValueUtil.ONE_VALUE);
	public static final @NonNull ValueId TRUE_ID = IdManager.getValueId(ValueUtil.TRUE_VALUE);
	public static final @NonNull ValueId UNLIMITED_ID = IdManager.getValueId(ValueUtil.UNLIMITED_VALUE);
	public static final @NonNull ValueId ZERO_ID = IdManager.getValueId(ValueUtil.ZERO_VALUE);
	
	@NonNull TypeId getTypeId();
	@Nullable Object getValue();
}
