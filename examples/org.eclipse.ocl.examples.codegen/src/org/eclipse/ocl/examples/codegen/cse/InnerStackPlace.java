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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;

/**
 * An InnerStackPlace describes either the body forest of CG trees for a loop expression.
 */
public class InnerStackPlace extends StackPlace
{
	public static @NonNull LocalPlace createPlace(@NonNull Map<CGElement, AbstractPlace> element2place, @NonNull CGIterationCallExp cgLoopExp) {
		CGElement cgParent = cgLoopExp.getParent();
		LocalPlace loopPlace = getLocalPlace(element2place, cgParent);
		StackPlace stackPlace = loopPlace.getStackPlace();
		CGValuedElement cgBodyExp = cgLoopExp.getBody();
		if (cgBodyExp != null) {
			@SuppressWarnings("null")@NonNull EReference loopExpBody = PivotPackage.Literals.LOOP_EXP__BODY;
			InnerStackPlace bodyPlace = new InnerStackPlace(stackPlace, cgBodyExp, loopExpBody);
			element2place.put(cgBodyExp, bodyPlace);
		}
		return loopPlace;
	}
	
	protected final @NonNull StackPlace parentPlace;
	
	private InnerStackPlace(@NonNull StackPlace parentPlace, @NonNull CGValuedElement cgBodyExp, @NonNull EReference eContainmentFeature) {
		super(parentPlace.getGlobalPlace(), cgBodyExp, eContainmentFeature);
		this.parentPlace = parentPlace;
		parentPlace.addStackPlace(this);
	}
	
	@Override
	public @NonNull StackPlace getParentPlace() {
		return parentPlace;
	}
}