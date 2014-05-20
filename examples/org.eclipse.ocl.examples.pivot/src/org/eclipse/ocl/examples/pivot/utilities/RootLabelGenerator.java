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
package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;
import org.eclipse.ocl.examples.pivot.Root;

public final class RootLabelGenerator extends AbstractLabelGenerator<Root>
{
	public static void initialize(Registry registry) {
		registry.install(Root.class, new RootLabelGenerator());		
	}
	
	public RootLabelGenerator() {
		super(Root.class);
	}

	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull Root object) {
		if (object == labelBuilder.getLabelledObject()) {
			String name = object.getExternalURI();
			if (name != null)
				labelBuilder.appendString(name);
			else {
				labelBuilder.appendString("<null-uri-");
				labelBuilder.appendString(object.getClass().getSimpleName());
				labelBuilder.appendString(">");
			}
		}
	}
}