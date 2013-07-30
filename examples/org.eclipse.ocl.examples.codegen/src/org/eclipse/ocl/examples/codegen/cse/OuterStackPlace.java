/**
 * <copyright>
 * 
 * Copyright (c) 2012,2013 CEA LIST and others.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.common.utils.TracingOption;

public class OuterStackPlace extends StackPlace
{
	public static @Nullable OuterStackPlace createPlace(@NonNull Map<CGElement, AbstractPlace> element2place, @NonNull CGElement cgStackElement, @Nullable EObject eObject) {
		if (eObject == null) {
			return null;
		}
		EReference eContainmentFeature = eObject.eContainmentFeature();
		if (eContainmentFeature == null) {
			throw new IllegalStateException("Null eContainmentFeature for " + cgStackElement);
		}
		GlobalPlace globalPlace = getGlobalPlace(element2place);
		OuterStackPlace stackPlace = new OuterStackPlace(globalPlace, cgStackElement, eContainmentFeature);
		return stackPlace;
	}
	
	protected OuterStackPlace(@NonNull GlobalPlace globalPlace, @NonNull CGElement stackElement, @NonNull EReference eContainmentFeature) {
		super(globalPlace, stackElement, eContainmentFeature);
		globalPlace.addStackPlace(this);
	}
	
	@Override
	public @NonNull GlobalPlace getParentPlace() {
		return globalPlace;
	}

	public void optimize(@NonNull CodeGenAnalyzer analyzer) {
		//
		//	Push common SEs upwards (e.g. terms on both then and else of an IF).
		//
		pushUp();
		if (CommonSubexpressionEliminator.CSE_PUSH_UP.isActive()) {
			CommonSubexpressionEliminator.CSE_PUSH_UP.println("Places after push up");
			printHierarchy(CommonSubexpressionEliminator.CSE_PUSH_UP, "");
		}
		//
		//	Pull common SEs upwards (e.g. terms on just else of an IF already available in a parent).
		//
		pullUp();
		if (CommonSubexpressionEliminator.CSE_PULL_UP.isActive()) {
			CommonSubexpressionEliminator.CSE_PULL_UP.println("Places after pull up");
			printHierarchy(CommonSubexpressionEliminator.CSE_PULL_UP, "");
		}
		//
		//	Prune to eliminate single use CSEs, the secondary terms of selected CSEs.
		//
		prune();
		if (CommonSubexpressionEliminator.CSE_PRUNE.isActive()) {
			CommonSubexpressionEliminator.CSE_PRUNE.println("Places after prune");
			printHierarchy(CommonSubexpressionEliminator.CSE_PRUNE, "");
		}
		//
		//	Rewrite shared analyses as LetExps, VarExps.
		//
		rewrite();
		if (CommonSubexpressionEliminator.CSE_REWRITE.isActive()) {
			CommonSubexpressionEliminator.CSE_REWRITE.println("Places after rewrite");
			printHierarchy(CommonSubexpressionEliminator.CSE_REWRITE, "");
			@SuppressWarnings("null")@NonNull String string = String.valueOf(stackElement.eGet(eContainmentFeature));
			TracingOption.println(CommonSubexpressionEliminator.CSE_REWRITE, string);
		}
	}
}