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
import org.eclipse.ocl.examples.domain.elements.DomainPackage;



/**
 * A PackageServerParent defines the common parent of PackageServer behavior for the PackageManager and a PackageServer.
 */
interface PackageServerParent
{
	@NonNull PackageServer getMemberPackageServer(@NonNull DomainPackage pivotPackage);
}