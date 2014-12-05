/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.oclinecore.cs2as.AutoOCLinEcoreCSContainmentVisitor;


public class NewOCLinEcoreCSContainmentVisitor extends AutoOCLinEcoreCSContainmentVisitor {

	public NewOCLinEcoreCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}
}
