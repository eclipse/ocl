/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.ids;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A MetaclassId provides a unique identifier for an unspecialized metaclass type such as Metaclass(T).
 */
public interface MetaclassId extends TypeId, TemplateableId
{
	@NonNull ElementId getElementId();
	@NonNull String getMetaTypeName();
	@NonNull String getName();
	@NonNull MetaclassId getSpecializedId(@NonNull ElementId elementId);
}