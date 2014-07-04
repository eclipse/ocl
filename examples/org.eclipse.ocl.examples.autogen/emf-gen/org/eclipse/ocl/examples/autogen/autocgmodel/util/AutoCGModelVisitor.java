/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.autogen/model/autocgmodel.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.autogen.autocgmodel.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface AutoCGModelVisitor<R> extends org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor<R>
{
	@Nullable R visitCGASTCallExp(@NonNull org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp object);
	@Nullable R visitCGContainmentBody(@NonNull org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody object);
	@Nullable R visitCGContainmentPart(@NonNull org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart object);
	@Nullable R visitCGContainmentVisit(@NonNull org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit object);
}
