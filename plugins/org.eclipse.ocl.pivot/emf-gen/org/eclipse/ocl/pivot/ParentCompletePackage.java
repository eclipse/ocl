/**
 * Copyright (c) 2010,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.PackageId;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parent Complete Package</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getParentCompletePackage()
 * @generated
 */
public interface ParentCompletePackage extends RootCompletePackage
{
	public interface Internal extends ParentCompletePackage, RootCompletePackage.Internal
	{
		void init(@NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId, @NonNull PackageId metapackageId);
	}
} // ParentCompletePackage
