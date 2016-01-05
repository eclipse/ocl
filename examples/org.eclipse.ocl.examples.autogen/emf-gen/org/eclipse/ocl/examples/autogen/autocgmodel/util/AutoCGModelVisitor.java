/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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

/**
 */
public interface AutoCGModelVisitor<R> extends org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor<R>
{
	R visitCGASTCallExp(org.eclipse.ocl.examples.autogen.autocgmodel.@NonNull CGASTCallExp object);
	R visitCGContainmentBody(org.eclipse.ocl.examples.autogen.autocgmodel.@NonNull CGContainmentBody object);
	R visitCGContainmentPart(org.eclipse.ocl.examples.autogen.autocgmodel.@NonNull CGContainmentPart object);
	R visitCGContainmentVisit(org.eclipse.ocl.examples.autogen.autocgmodel.@NonNull CGContainmentVisit object);
}
