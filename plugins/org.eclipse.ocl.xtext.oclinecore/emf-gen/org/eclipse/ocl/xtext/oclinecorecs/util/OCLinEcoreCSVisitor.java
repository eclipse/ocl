/*******************************************************************************
 * Copyright (c) 2010,2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.xtext.oclinecore/model/OCLinEcoreCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.oclinecorecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface OCLinEcoreCSVisitor<R> extends org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitOCLinEcoreConstraintCS(@NonNull org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS object);
	@Nullable R visitSysMLCS(@NonNull org.eclipse.ocl.xtext.oclinecorecs.SysMLCS object);
	@Nullable R visitTopLevelCS(@NonNull org.eclipse.ocl.xtext.oclinecorecs.TopLevelCS object);
}
