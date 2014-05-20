/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.executor;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainConstraint;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.PackageId;

public abstract class ExecutorPackage implements DomainPackage
{
	protected final @NonNull String name;
	protected final @Nullable String nsPrefix;
	protected final @Nullable String nsURI;
	protected final @NonNull PackageId packageId;

	protected ExecutorPackage(@NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId) {
		this.name = name;
		this.nsPrefix = nsPrefix;
		this.nsURI = nsURI;
		this.packageId = packageId;
	}

	public @Nullable EPackage getEPackage() {
		return null;
	}

	public @NonNull ElementId getElementId() {
		return packageId;
	}

	public final @NonNull String getName() {
		return name;
	}

	public final @Nullable String getNsPrefix() {
		return nsPrefix;
	}

	public final @Nullable String getNsURI() {
		return nsURI;
	}

	public @NonNull List<? extends DomainConstraint> getOwnedRule() {
		throw new UnsupportedOperationException();			// FIXME
	}
	
	public abstract @NonNull List<? extends DomainType> getOwnedType();

	public @NonNull PackageId getPackageId() {
		return packageId;
	}


	public DomainType getType(String typeName) {
		for (DomainType type: getOwnedType()) {
			if (type.getName().equals(typeName)) {
				return type;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return name;
	}
}