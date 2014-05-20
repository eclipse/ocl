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

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * The OrphanPackageServer ensures that orphan types have their own servers. (Numerous Collection, Metaclass and Tuple types have the
 * same basic name but are not the same type at all.)
 * <p>
 * Orphan types are maintained here rather than in the PackageManager so that weak references to the type ensure that stale types are
 * garbage collected, and so that weka references to a stale cached server are also garbngae collected.
 */
public class OrphanPackageServer extends RootPackageServer
{
	private @NonNull Map<DomainType, WeakReference<OrphanTypeServer>> servers = new WeakHashMap<DomainType, WeakReference<OrphanTypeServer>>();	
	
	public OrphanPackageServer(@NonNull PackageManager packageManager, @NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId) {
		super(packageManager, name, nsPrefix, nsURI, packageId);
	}

	@Override
	public @NonNull TypeServer getTypeServer(@NonNull DomainType type) {
		WeakReference<OrphanTypeServer> ref = servers.get(type);
		if (ref != null) {
			OrphanTypeServer orphanTypeServer = ref.get();
			if (orphanTypeServer != null) {
				return orphanTypeServer;
			}
		}
		OrphanTypeServer orphanTypeServer = new OrphanTypeServer(this, (Type)type);
		servers.put(type, new WeakReference<OrphanTypeServer>(orphanTypeServer));
		return orphanTypeServer;
	}
}