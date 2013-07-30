/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.cse;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * A CatchPlace describes either the body forest of CG trees for a catch expression.
 */
public class CatchPlace extends ControlPlace
{
	public static @NonNull LocalPlace createPlace(@NonNull Map<CGElement, AbstractPlace> element2place, @NonNull CGCatchExp cgCatchExp) {
		CGElement cgParent = cgCatchExp.getParent();
		LocalPlace catchPlace = getLocalPlace(element2place, cgParent);
		CGValuedElement cgCaughtExp = cgCatchExp.getSource();
		if (cgCaughtExp != null) {
			CatchPlace caughtPlace = new CatchPlace(catchPlace, cgCaughtExp);
			element2place.put(cgCaughtExp, caughtPlace);
		}
		return catchPlace;
	}
	
	private CatchPlace(@NonNull LocalPlace catchPlace, @NonNull CGValuedElement cgCaughtExp) {
		super(catchPlace, cgCaughtExp);
	}
}