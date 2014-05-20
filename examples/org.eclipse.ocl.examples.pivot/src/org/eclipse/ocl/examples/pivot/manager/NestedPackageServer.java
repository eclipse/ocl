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
package org.eclipse.ocl.examples.pivot.manager;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.ids.PackageId;

/**
 * A RootPackageServer adapts the primary nested Package to coordinate the coherent behavior of a primary and one or more
 * secondary Packages as required for Complete OCL package extension.
 */
public class NestedPackageServer extends PackageServer
{	
	@SuppressWarnings("null")
	public static final @NonNull List<NestedPackageServer> EMPTY_LIST = Collections.<NestedPackageServer>emptyList();
	
	private final @NonNull PackageServer parentPackageServer;
	
	public NestedPackageServer(@NonNull PackageServer parentPackageServer, @NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId) {
		super(parentPackageServer.getPackageManager(), name, nsPrefix, nsURI, packageId);
		this.parentPackageServer = parentPackageServer;
	}

	@Override
	protected void assertSamePackage(@Nullable DomainPackage domainPackage) {
		assert domainPackage != null;
		DomainPackage parentPackage = domainPackage.getNestingPackage();
		assert parentPackage != null;
		parentPackageServer.assertSamePackage(parentPackage);
		super.assertSamePackage(domainPackage);
	}

	@Override
	public void dispose() {
		super.dispose();
		parentPackageServer.disposedNestedPackageServer(this);
	}

	public @NonNull DomainPackage getNestingPackage() {
		return parentPackageServer;
	}

	@Override
	public @NonNull PackageServer getParentPackageServer() {
		return parentPackageServer;
	}
}