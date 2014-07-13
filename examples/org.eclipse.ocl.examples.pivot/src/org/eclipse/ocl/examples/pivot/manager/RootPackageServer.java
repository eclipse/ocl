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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;

/**
 * A RootPackageServer adapts the primary root Package to coordinate the coherent behavior of a primary and one or more
 * secondary Packages as required for Complete OCL package extension.
 */
public class RootPackageServer extends PackageServer
{	
	private final @NonNull PackageId metapackageId;

	@Deprecated // specify metaPackageId
	public RootPackageServer(@NonNull PackageManager packageManager, @NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId) {
		this(packageManager, name, nsPrefix, nsURI, packageId, IdManager.METAMODEL);
	}

	/**
	 * @since 3.5
	 */
	public RootPackageServer(@NonNull PackageManager packageManager, @NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId, @NonNull PackageId metapackageId) {
		super(packageManager, name, nsPrefix, nsURI, packageId);
		this.metapackageId = metapackageId;
	}

	@Override
	protected void assertSamePackage(@Nullable DomainPackage domainPackage) {
		assert domainPackage != null;
		DomainPackage parentPackage = domainPackage.getNestingPackage();
		assert parentPackage == null;
		String typeBasedNsURI = domainPackage.getNsURI();
		String serverBasedNsURI = getNsURI();
		if (typeBasedNsURI == null) {
//			assert serverBasedNsURI == null;
		}
		else {
			assert (serverBasedNsURI == null) || (packageManager.getPackageByURI(typeBasedNsURI) == packageManager.getPackageByURI(serverBasedNsURI));
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		packageManager.disposedRootPackageServer(this);
	}
	
	/**
	 * @since 3.5
	 */
	public @NonNull PackageId getMetapackageId() {
		return metapackageId;
	}

	public @Nullable DomainPackage getNestingPackage() {
		return null;
	}

	@Override
	public @Nullable PackageServer getParentPackageServer() {
		return null;
	}
}