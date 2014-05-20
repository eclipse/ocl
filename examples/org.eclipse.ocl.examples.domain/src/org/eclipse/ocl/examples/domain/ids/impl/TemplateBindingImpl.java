/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.ids.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;


public class TemplateBindingImpl extends AbstractTypeId implements TemplateBinding
{
	private DomainTemplateParameter templateParameter;
	private TemplateParameterId templateParameterId;
	
	public TemplateBindingImpl(@NonNull DomainTemplateParameter templateParameter) {
		this.templateParameter = templateParameter;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTemplateBinding(this);
	}

	public @NonNull String getDisplayName() {
		String string = String.valueOf(templateParameter != null ? templateParameter : templateParameterId);
		assert string != null;
		return string;
	}

	public @NonNull DomainTemplateParameter getTemplateParameter() {
		return DomainUtil.nonNullState(templateParameter);
	}

	@Override
	public int hashCode() {
		return templateParameter.hashCode();
	}

	public void install(@NonNull TemplateParameterId templateParameterId) {
		this.templateParameterId = templateParameterId;
		this.templateParameter = null;
	}
	   
    @Override
	public @NonNull TypeId specialize(@NonNull BindingsId templateBindings) {
    	int index = templateParameterId.getIndex();
		ElementId templateBinding = templateBindings.get(index);
		if (templateBinding instanceof TemplateBinding) {
			return new TemplateBindingImpl(((TemplateBinding)templateBinding).getTemplateParameter());
		}
		else {
			assert templateBinding != null;
			return (TypeId) templateBinding;
		}
	}
}
