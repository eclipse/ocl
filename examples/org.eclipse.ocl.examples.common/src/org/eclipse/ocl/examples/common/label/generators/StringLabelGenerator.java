/*******************************************************************************
 * Copyright (c) 2008,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.common.label.generators;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;

public final class StringLabelGenerator extends AbstractLabelGenerator<String>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(String.class, new StringLabelGenerator());		
	}
	
	public StringLabelGenerator() {
		super(String.class);
	}

	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull String object) {
		labelBuilder.appendString(object);
	}
}