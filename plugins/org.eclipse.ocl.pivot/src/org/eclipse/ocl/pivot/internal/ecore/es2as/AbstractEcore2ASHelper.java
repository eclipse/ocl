/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ecore.es2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.Ecore2ASHelper;

/**
 * AbstractEcore2ASHelper provides the abstract functionality for Ecore2AS conversion helpers.
 * @since 1.1
 */
public abstract class AbstractEcore2ASHelper implements Ecore2ASHelper
{
	protected final @NonNull String uri;
	protected final boolean isModel;

	protected AbstractEcore2ASHelper(@NonNull String uri, boolean isModel) {
		this.uri = uri;
		this.isModel = isModel;
	}

	@Override
	public @NonNull Ecore2ASHelper basicGetEcore2ASHelper() {
		return this;
	}

	@Override
	public @NonNull Ecore2ASHelper getContribution() {
		return this;
	}

	@Override
	public @NonNull Ecore2ASHelper getEcore2ASHelper() {
		return this;
	}

	@Override
	public @NonNull String getURI() {
		return uri;
	}

	public void install() {
		Ecore2ASHelperRegistry.INSTANCE.addEcore2ASHelper(uri, this);
	}

	@Override
	public boolean isModel() {
		return isModel;
	}

	@Override
	public @NonNull String toString() {
		return uri;
	}
}
