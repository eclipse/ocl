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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.xtext.AbstractMetamodelDeclaration;

public final class XtextAbstractMetamodelDeclarationLabelGenerator extends AbstractLabelGenerator<AbstractMetamodelDeclaration>
{
	public static void initialize(Registry registry) {
		registry.install(AbstractMetamodelDeclaration.class, new XtextAbstractMetamodelDeclarationLabelGenerator());		
	}
	
	public XtextAbstractMetamodelDeclarationLabelGenerator() {
		super(AbstractMetamodelDeclaration.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull AbstractMetamodelDeclaration object) {
		EPackage ePackage = object.getEPackage();
		String nsURI = ePackage != null ? ePackage.getNsURI() : null;
		if (nsURI != null)
			labelBuilder.appendString(nsURI);
		else {
			labelBuilder.appendString("<null-nsURI-");
			labelBuilder.appendString(object.getClass().getSimpleName());
			labelBuilder.appendString(">");
		}
	}
}