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
package org.eclipse.ocl.examples.domain.ids.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdHash;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class GeneralizedMetaclassIdImpl extends AbstractMetaclassId
{
	/**
	 * Map from template bindings to the corresponding specialization. 
	 */
	private @NonNull WeakHashMapOfWeakReference<ElementId, MetaclassId> specializations =
			new WeakHashMapOfWeakReference<ElementId, MetaclassId>() {
				@Override
				protected @NonNull MetaclassId newId(@NonNull ElementId elementId) {
					return new SpecializedMetaclassIdImpl(elementId);
				}
			};

	public GeneralizedMetaclassIdImpl() {
		super(IdHash.createGlobalHash(MetaclassId.class, TypeId.METACLASS_NAME));
	}

	public @NonNull String getDisplayName() {
		return TypeId.METACLASS_NAME;
	}

	public @NonNull ElementId getElementId() {
		return TypeId.T_1;
	}

	@Override
	public @Nullable String getLiteralName() {
		if (this == TypeId.METACLASS) {
			return "METACLASS";
		}
		else {
			return null;
		}
	}

	public @NonNull MetaclassId getSpecializedId(@NonNull ElementId elementId) {
		return specializations.getId(elementId);
    }
}