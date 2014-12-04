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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * DomainExecutorPackage uses the limited Domain interfaces to construct a package description for use
 * in contexts where no explicit ExecutorPackage is available.
 * 
 * This typically occurs when a dynamic Ecore model is used but no MetaModelManager is accessible.
 */
public class DomainReflectivePackage extends ReflectivePackage
{
	protected final @NonNull DomainStandardLibrary standardLibrary;
	protected final @NonNull DomainPackage domainPackage;

	public DomainReflectivePackage(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainPackage domainPackage) {
		super(DomainUtil.nonNullPivot(domainPackage.getName()), domainPackage.getNsPrefix(), domainPackage.getURI(), domainPackage.getPackageId());
		this.standardLibrary = standardLibrary;
		this.domainPackage = domainPackage;
	}

	@Override
	protected @NonNull ReflectiveInheritance createInheritance(@NonNull DomainClass domainClass) {
		return new DomainReflectiveType(this, domainClass);
	}

	@Override
	protected @NonNull List<? extends DomainClass> getDomainClasses() {
		return DomainUtil.nonNullPivot(domainPackage.getOwnedClasses());
	}

	@Override
	public List<? extends DomainPackage> getOwnedPackages() {
		return domainPackage.getOwnedPackages();			// FIXME Is this recursive??
	}

	@Override
	public DomainPackage getOwningPackage() {
		return domainPackage.getOwningPackage();			// FIXME Is this recursive??
	}

	@Override
	public @NonNull PackageId getPackageId() {
		return domainPackage.getPackageId();
	}
	
	@Override
	protected @NonNull DomainStandardLibrary getStandardLibrary() {
		return standardLibrary;
	}
}