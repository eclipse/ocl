/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.ids.impl;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;

public class NsURIPackageIdImpl extends PackageIdImpl implements NsURIPackageId
{
	protected final @NonNull String nsURI;
	protected final @Nullable String nsPrefix;
	private @Nullable EPackage ePackage;

	@Deprecated
	public NsURIPackageIdImpl(@NonNull IdManager idManager, @NonNull String nsURI, @Nullable EPackage ePackage) {
		this(idManager, nsURI, null, ePackage);
	}

	@SuppressWarnings("null")
	public NsURIPackageIdImpl(@NonNull IdManager idManager, @NonNull String nsURI, @Nullable String nsPrefix, @Nullable EPackage ePackage) {
		super(nsURI.hashCode());
		this.nsURI = nsURI;
		this.nsPrefix = nsPrefix;
		this.ePackage = ePackage;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitNsURIPackageId(this);
	}

	public @NonNull String getDisplayName() {
		return nsURI;
	}

	public @Nullable EPackage getEPackage() {
		return ePackage;
	}

	public @Nullable String getNsPrefix() {
		return nsPrefix;
	}

	public @NonNull String getNsURI() {
		return nsURI;
	}

	public void setEPackage(@NonNull EPackage ePackage) {
		this.ePackage = ePackage;
	}

	@Override
	public String toString() {
		return "'" + nsURI + "'";
	}
}