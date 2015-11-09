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
package org.eclipse.ocl.xtext.base.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.TypeRef;

public final class XtextActionLabelGenerator extends AbstractLabelGenerator<Action>
{
	public static void initialize(Registry registry) {
		registry.install(Action.class, new XtextActionLabelGenerator());		
	}
	
	public XtextActionLabelGenerator() {
		super(Action.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull Action object) {
		String feature = object.getFeature();
		String operator = object.getOperator();
		TypeRef type = object.getType();
		if (type != null) {
			labelBuilder.appendString(type.getClassifier().getName());
		}
		if (feature != null) {
			labelBuilder.appendString(".");
			labelBuilder.appendString(feature);
		}
		if (feature != null) {
			labelBuilder.appendString(operator);
			labelBuilder.appendString("current");
		}
	}
}