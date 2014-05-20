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
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class TemplateParameterIdImpl /*extends AbstractTypeId*/ implements TemplateParameterId
{
	private final int index;
	private final @NonNull String name;
	private final int hashCode;

	public TemplateParameterIdImpl(@NonNull IdManager idManager, int index) {
//		System.out.println("create " + DomainUtil.debugFullName(this));
		this.index = index;
		this.name = "$" + Integer.toString(index);
		this.hashCode = IdHash.createGlobalHash(TemplateParameterId.class, name);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTemplateParameterId(this);
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (hashCode() != that.hashCode()) {
			return false;
		}
		if (!(that instanceof TemplateParameterId)) {
			return false;
		}
		if (index != ((TemplateParameterId)that).getIndex()) {
			return false;
		}
		assert false;	// Never happens; should be a singleton
		return true;
	}

	public @NonNull String getDisplayName() {
		return name;
	}

	public int getIndex() {
		return index;
	}

	public @Nullable String getLiteralName() {
		if (this == TypeId.T_1) {
			return "T_1";
		}
		else if (this == TypeId.T_2) {
			return "T_2";
		}
		else if (this == TypeId.T_3) {
			return "T_3";
		}
		else {
			return null;
		}
	}

	public @NonNull String getMetaTypeName() {
    	throw new UnsupportedOperationException();
	}

	public @NonNull String getName() {
		return name;
	}

    public @NonNull OperationId getOperationId(int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
    	throw new UnsupportedOperationException();
    }

    public @NonNull PropertyId getPropertyId(@NonNull String name) {
    	throw new UnsupportedOperationException();
    }
	
    public @NonNull TemplateParameterId getTemplateParameterId(int index) {
    	throw new UnsupportedOperationException();
    }
	
    public int getTemplateParameters() {
    	throw new UnsupportedOperationException();
    }

	@Override
	public final int hashCode() {
		return hashCode;
	}

    public @NonNull ElementId specialize(@NonNull BindingsId templateBindings) {
    	ElementId elementId = templateBindings.get(index);
		assert elementId != null;
		return elementId;
	}

	@Override
	public String toString() {
		return getDisplayName();
	}
}