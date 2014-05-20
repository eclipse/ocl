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
package org.eclipse.ocl.examples.domain.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;
import org.eclipse.ocl.examples.domain.elements.Nameable;

public final class NameableLabelGenerator extends AbstractLabelGenerator<Nameable>
{
	public static void initialize(Registry registry) {
		registry.install(Nameable.class, new NameableLabelGenerator());		
	}
	
	public NameableLabelGenerator() {
		super(Nameable.class);
	}

	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull Nameable object) {
		String name = object.getName();
		if (name != null)
			labelBuilder.appendString(name);
		else {
			labelBuilder.appendString("<null-named-");
			labelBuilder.appendString(object.getClass().getSimpleName());
			labelBuilder.appendString(">");
		}
	}
}