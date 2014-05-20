/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.util.AbstractOCLinEcoreCSPreOrderVisitor;

public class OCLinEcoreCSPreOrderVisitor extends AbstractOCLinEcoreCSPreOrderVisitor
{
	public OCLinEcoreCSPreOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}
}