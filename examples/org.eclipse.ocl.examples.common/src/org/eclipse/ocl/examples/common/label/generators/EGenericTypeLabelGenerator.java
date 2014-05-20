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
package org.eclipse.ocl.examples.common.label.generators;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;

public final class EGenericTypeLabelGenerator extends AbstractLabelGenerator<EGenericType>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(EGenericType.class, new EGenericTypeLabelGenerator());		
	}
	
	public EGenericTypeLabelGenerator() {
		super(EGenericType.class);
	}

	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull EGenericType object) {
		EClassifier eClassifier = object.getEClassifier();
		if (eClassifier != null) {
			labelBuilder.appendObject(eClassifier);
		}
		else {
			ETypeParameter eTypeParameter = object.getETypeParameter();
			labelBuilder.appendObject(eTypeParameter);
		}
		List<EGenericType> eTypeArguments = object.getETypeArguments();
		int size = eTypeArguments.size();
		if (size > 0) {
			labelBuilder.appendString("<");
			for (int i = 0; i < size; i++) {
				if (i > 0) {
					labelBuilder.appendString(",");
				}
				labelBuilder.appendObject(eTypeArguments.get(0));
			}
			labelBuilder.appendString(">");
		}
	}
}