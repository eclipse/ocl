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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;

public abstract class StackPlace extends LocalPlace
{
	protected final @NonNull CGElement stackElement;
	protected final @NonNull EReference eContainmentFeature;
	private /*@LazyNonNull*/ Set<InnerStackPlace> stackPlaces = null;
	
	protected StackPlace(@NonNull GlobalPlace globalPlace, @NonNull CGElement stackElement, @NonNull EReference eContainmentFeature) {
		super(globalPlace);
		this.stackElement = stackElement;
		this.eContainmentFeature = eContainmentFeature;
	}

	void addStackPlace(@NonNull InnerStackPlace stackPlace) {
		if (stackPlaces == null) {
			stackPlaces = new HashSet<InnerStackPlace>();
		}
		stackPlaces.add(stackPlace);
	}

	public @NonNull CGElement getStackElement() {
		return stackElement;
	}

	@Override
	public @NonNull StackPlace getStackPlace() {
		return this;
	}
	
	@Override
	public void printHierarchy(@NonNull Appendable appendable, @NonNull String indentation) {
		super.printHierarchy(appendable, indentation);
		if (stackPlaces != null) {
			for (StackPlace stackPlace : stackPlaces) {
				stackPlace.printHierarchy(appendable, indentation + "  ");
			}
		}
	}
	
	@Override
	public void prune() {
		if (stackPlaces != null) {
			for (StackPlace stackPlace : stackPlaces) {
				stackPlace.prune();
			}
		}
		super.prune();
	}
	
	@Override
	public void pullUp() {
		if (stackPlaces != null) {
			for (StackPlace stackPlace : stackPlaces) {
				stackPlace.pullUp();
			}
		}
		super.pullUp();
	}
	
	@Override
	public void pushUp() {
		if (stackPlaces != null) {
			for (StackPlace stackPlace : stackPlaces) {
				stackPlace.pushUp();
			}
		}
		super.pushUp();
	}
	
	@Override
	public void rewrite() {
		if (stackPlaces != null) {
			for (StackPlace stackPlace : stackPlaces) {
				stackPlace.rewrite();
			}
		}
		super.rewrite();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + String.valueOf(stackElement);
	}
}