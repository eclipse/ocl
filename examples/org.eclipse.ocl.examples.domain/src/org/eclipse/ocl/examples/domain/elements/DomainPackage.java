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
package org.eclipse.ocl.examples.domain.elements;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.PackageId;

public interface DomainPackage extends DomainNamespace
{
	@Nullable EPackage getEPackage();
	/*@NonNull*/ List<? extends DomainPackage>  getNestedPackage();
	/*@Nullable*/ DomainPackage getNestingPackage();
	/*@Nullable*/ String getNsPrefix();
	/*@Nullable*/ String getNsURI();
	/*@NonNull*/ List<? extends DomainType> getOwnedType();
	@NonNull PackageId getPackageId();
}
