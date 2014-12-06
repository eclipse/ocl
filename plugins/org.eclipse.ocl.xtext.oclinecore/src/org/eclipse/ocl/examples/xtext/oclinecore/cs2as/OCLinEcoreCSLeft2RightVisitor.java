/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.oclinecore.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.util.AbstractOCLinEcoreCSLeft2RightVisitor;

public class OCLinEcoreCSLeft2RightVisitor extends AbstractOCLinEcoreCSLeft2RightVisitor
{
	public OCLinEcoreCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}
}