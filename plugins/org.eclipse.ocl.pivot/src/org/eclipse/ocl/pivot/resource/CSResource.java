/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.context.ParserContext;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;

/**
 * CSResource defines the Xtext-independent extended interface for a Concrete Syntax resource
 * for which a ParserContext defines how the Abstract Syntax elements should
 * be initialized.
 */
public interface CSResource extends Resource
{
	/**
	 * Return the Abstract Syntax representation of this Concrete Syntax resource
	 * under the supervision of metamodelManager.
	 */
	@NonNull ASResource getASResource(@Nullable MetamodelManager metamodelManager);
	
	@Nullable ParserContext getParserContext();
	void setParserContext(@Nullable ParserContext parserContext);
	void updateFrom(@NonNull ASResource asResource, @NonNull MetamodelManager metamodelManager);
}
