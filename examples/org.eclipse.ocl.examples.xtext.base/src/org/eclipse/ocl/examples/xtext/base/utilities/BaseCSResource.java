/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.xtext.base.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;

/**
 * BaseResource defines the Xtext-dependent extended interface for a Concrete Syntax resource.
 */
public interface BaseCSResource extends BaseResource
{
	/**
	 * Create the CS2AS converter for the cs2asResourceMap conversions using metaModelManager.
	 */
	// FIXME Pivot2AS Narrow to BaseCSResource
	@NonNull CS2Pivot createCS2Pivot(@NonNull Map<? extends /*BaseCS*/Resource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager);

	/**
	 * Create the AS2CS converter for the cs2asResourceMap conversions using metaModelManager.
	 */
	// FIXME Pivot2AS Narrow to BaseCSResource
	@NonNull Pivot2CS createPivot2CS(@NonNull Map<? extends /*BaseCS*/Resource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager);

	/**
	 * Return a MetaModelManager for use with this CS resource, unless one can be located
	 * via a CS2AS adapter.
	 */
	@NonNull MetaModelManager createMetaModelManager();

	/**
	 * Return the CS2AS adapter for this resource, or null if none installed.
	 */
	@Nullable CS2PivotResourceAdapter findCS2ASAdapter();

	/**
	 * Return the eContentType to be used when creating an AS resource.
	 */
	@NonNull String getASContentType();

	/**
	 * Return the Abstract Syntax URI for the fiven Concrete Syntax URI.
	 */
	@NonNull URI getASURI(@NonNull URI csURI);

	/**
	 * Return the CS2AS adapter for this resource.
	 * If no CS2AS adapter installed, one is created and installed using the provided metaModelManager,
	 * which if null is also created. 
	 */
	@NonNull CS2PivotResourceAdapter getCS2ASAdapter(@Nullable MetaModelManager metaModelManager);
	
	/**
	 * Return the name of the editor for use in diagnostics.
	 */
	@NonNull String getEditorName();
	
	/**
	 * Return a uri against the URI of this CS resource.
	 */
	@NonNull URI resolve(@NonNull URI uri);
}
