/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.labels;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.tx.TransformationInstance;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;

/**
 * @since 1.1
 */
public final class TransformationInstanceLabelGenerator extends AbstractLabelGenerator<TransformationInstance>
{
	public static void initialize(Registry registry) {
		registry.install(TransformationInstance.class, new TransformationInstanceLabelGenerator());		
	}
	
	public TransformationInstanceLabelGenerator() {
		super(TransformationInstance.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull TransformationInstance element) {
		labelBuilder.appendString(element.getName());
	}
}