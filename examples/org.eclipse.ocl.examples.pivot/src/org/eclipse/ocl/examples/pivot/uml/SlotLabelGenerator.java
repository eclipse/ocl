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
package org.eclipse.ocl.examples.pivot.uml;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;
import org.eclipse.uml2.uml.Slot;

public final class SlotLabelGenerator extends AbstractLabelGenerator<Slot>
{
	public static void initialize(Registry registry) {
		registry.install(Slot.class, new SlotLabelGenerator());		
	}
	
	public SlotLabelGenerator() {
		super(Slot.class);
	}

	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull Slot object) {
		String name = object.getDefiningFeature().getName();
		if (name != null)
			labelBuilder.appendString(name);
		else {
			labelBuilder.appendString("<null-featured-");
			labelBuilder.appendString(object.getClass().getSimpleName());
			labelBuilder.appendString(">");
		}
	}
}