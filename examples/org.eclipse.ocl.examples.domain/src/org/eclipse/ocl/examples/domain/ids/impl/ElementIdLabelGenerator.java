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
package org.eclipse.ocl.examples.domain.ids.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;
import org.eclipse.ocl.examples.domain.ids.ElementId;

public final class ElementIdLabelGenerator extends AbstractLabelGenerator<ElementId>
{
	public static void initialize(Registry registry) {
		registry.install(ElementId.class, new ElementIdLabelGenerator());		
	}
	
	public ElementIdLabelGenerator() {
		super(ElementId.class);
	}

	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull ElementId object) {
		String name = object.getDisplayName();
		labelBuilder.appendString(name);
	}
}