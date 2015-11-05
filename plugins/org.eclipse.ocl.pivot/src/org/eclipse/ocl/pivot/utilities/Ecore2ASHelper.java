/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.ecore.es2as.AbstractExternal2AS;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2ASDeclarationSwitch;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2ASHelperContribution;

/**
 * @since 1.1
 */
public interface Ecore2ASHelper extends Ecore2ASHelperContribution
{
	@NonNull Ecore2ASDeclarationSwitch createEcore2ASDeclarationSwitch(@NonNull AbstractExternal2AS converter);
}
