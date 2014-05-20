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
 * from: org.eclipse.ocl.examples.xtext.completeocl/model/CompleteOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.util;

import org.eclipse.jdt.annotation.NonNull;

/*
 * An AbstractCompleteOCLCSVisitor provides a default implementation of the visitor framework
 * but n implementations of the visitXXX methods..
 */
public abstract class AbstractCompleteOCLCSVisitor<R, C>
	extends org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractEssentialOCLCSVisitor<R, C>
	implements CompleteOCLCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractCompleteOCLCSVisitor(@NonNull C context) {
		super(context);
	}
}
