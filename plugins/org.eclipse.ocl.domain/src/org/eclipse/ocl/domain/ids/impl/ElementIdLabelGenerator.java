/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.ids.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.ids.ElementId;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;

public final class ElementIdLabelGenerator extends AbstractLabelGenerator<ElementId>
{
	public static void initialize(Registry registry) {
		registry.install(ElementId.class, new ElementIdLabelGenerator());		
	}
	
	public ElementIdLabelGenerator() {
		super(ElementId.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull ElementId object) {
		String name = object.getDisplayName();
		labelBuilder.appendString(name);
	}
}