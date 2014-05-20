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
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class PrimitiveTypeIdImpl extends UnscopedId implements PrimitiveTypeId
{
	public PrimitiveTypeIdImpl(@NonNull IdManager idManager, @NonNull String name) {
		super(name);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitPrimitiveTypeId(this);
	}

	@Override
	public @Nullable String getLiteralName() {
		if (this == TypeId.BOOLEAN) {
			return "BOOLEAN";
		}
		else if (this == TypeId.INTEGER) {
			return "INTEGER";
		}
		else if (this == TypeId.INTEGER_RANGE) {
			return "INTEGER_RANGE";
		}
		else if (this == TypeId.OCL_ANY) {
			return "OCL_ANY";
		}
		else if (this == TypeId.OCL_COMPARABLE) {
			return "OCL_COMPARABLE";
		}
		else if (this == TypeId.OCL_SELF) {
			return "OCL_SELF";
		}
		else if (this == TypeId.OCL_SUMMABLE) {
			return "OCL_SUMMABLE";
		}
		else if (this == TypeId.REAL) {
			return "REAL";
		}
		else if (this == TypeId.STRING) {
			return "STRING";
		}
		else if (this == TypeId.UNLIMITED_NATURAL) {
			return "UNLIMITED_NATURAL";
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return PRIMITIVE_TYPE_NAME;
	}
}