/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface DecorableEssentialOCLCSVisitor<R> extends EssentialOCLCSVisitor<R>, org.eclipse.ocl.examples.xtext.base.basecs.util.DecorableBaseCSVisitor<R>
{
	void setUndecoratedVisitor(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor<R> visitor);
}
