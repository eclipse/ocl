/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.uml;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;

public final class UMLElementExtensionLabelGenerator extends AbstractLabelGenerator<UMLElementExtension>
{
	public static void initialize(Registry registry) {
		registry.install(UMLElementExtension.class, new UMLElementExtensionLabelGenerator());		
	}
	
	public UMLElementExtensionLabelGenerator() {
		super(UMLElementExtension.class);
	}

	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull UMLElementExtension object) {
		labelBuilder.appendString(EcoreUtils.simpleNameFor(object.getTarget()));
		labelBuilder.appendString("$");
		labelBuilder.appendString(EcoreUtils.simpleNameFor(object.getDynamicStereotype()));
	}
}