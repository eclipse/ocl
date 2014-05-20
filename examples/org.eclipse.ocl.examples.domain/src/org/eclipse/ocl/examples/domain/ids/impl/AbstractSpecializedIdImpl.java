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
import org.eclipse.ocl.examples.domain.ids.SpecializedId;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.TemplateableId;

public abstract class AbstractSpecializedIdImpl<T extends TemplateableId> extends AbstractTemplateableIdImpl<T> implements SpecializedId
{
	protected final @NonNull T generalizedId;
	protected final @NonNull BindingsId templateBindings;

	public AbstractSpecializedIdImpl(@NonNull T generalizedId, @NonNull BindingsId templateBindings) {
		super(generalizedId.hashCode() + templateBindings.hashCode(), generalizedId.getTemplateParameters());
		this.generalizedId = generalizedId;
		this.templateBindings = templateBindings;
		int generalizedTemplateParameters = generalizedId.getTemplateParameters();
		int templateParameterCount = generalizedTemplateParameters;
		assert templateParameterCount > 0;
		assert templateBindings.size() == templateParameterCount;
	}

	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(generalizedId.getDisplayName());
		s.append("<");
		for (int i = 0; i < templateParameters; i++) {
			if (i > 0) {
				s.append(",");
			}
			s.append("$" + i + ":");
			s.append(templateBindings.get(i));
		}
		s.append(">");
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}

	public @NonNull T getGeneralizedId() {
		return generalizedId;
	}

	public @NonNull String getMetaTypeName() {
		return generalizedId.getMetaTypeName();
	}

	public @NonNull String getName() {
		return generalizedId.getName();
	}

	public @NonNull BindingsId getTemplateBindings() {
		return templateBindings;
	}
}