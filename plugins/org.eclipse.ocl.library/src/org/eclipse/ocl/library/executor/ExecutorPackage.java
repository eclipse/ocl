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
package org.eclipse.ocl.library.executor;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.domain.ids.ElementId;
import org.eclipse.ocl.domain.ids.PackageId;
import org.eclipse.ocl.pivot.Constraint;

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

	@Override
	public @Nullable EPackage getEPackage() {
		return null;
	}

	public @NonNull ElementId getElementId() {
		return packageId;
	}

	@Override
	public final @NonNull String getName() {
		return name;
	}

	@Override
	public final @Nullable String getNsPrefix() {
		return nsPrefix;
	}

	@Override
	public final @Nullable String getURI() {
		return nsURI;
	}

	@Override
	public @NonNull List<? extends Constraint> getOwnedRule() {
		throw new UnsupportedOperationException();			// FIXME
	}
	
	@Override
	public abstract @NonNull List<? extends DomainClass> getOwnedClasses();

	@Override
	public @NonNull PackageId getPackageId() {
		return packageId;
	}


	public DomainClass getType(String typeName) {
		for (DomainClass type: getOwnedClasses()) {
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