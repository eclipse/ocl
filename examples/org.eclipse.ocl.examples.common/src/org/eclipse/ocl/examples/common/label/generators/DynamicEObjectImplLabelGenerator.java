/**
 * <copyright>
 * 
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.common.label.generators;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;

public final class DynamicEObjectImplLabelGenerator extends AbstractLabelGenerator<DynamicEObjectImpl>
{
	public static void initialize(Registry registry) {
		registry.install(DynamicEObjectImpl.class, new DynamicEObjectImplLabelGenerator());		
	}
	
	public DynamicEObjectImplLabelGenerator() {
		super(DynamicEObjectImpl.class);
	}

	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull DynamicEObjectImpl object) {
		EClass eClass = object.eClass();
		Resource eResource = object.eResource();
		if (eResource != null) {
			String className = eResource.getClass().getName();
			if (className.contains("UML")) {
				labelBuilder.appendString("«");
				labelBuilder.appendString(eClass.getName());
				labelBuilder.appendString("»");
				return;
			}
		}
		labelBuilder.appendString(eClass.getName());
	}
}