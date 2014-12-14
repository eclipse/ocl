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
import org.eclipse.ocl.domain.ids.PackageId;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Complete Package</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getRootCompletePackage()
 * @generated
 */
public interface RootCompletePackage extends CompletePackage
{

	@NonNull PackageId getMetapackageId();
} // RootCompletePackage
