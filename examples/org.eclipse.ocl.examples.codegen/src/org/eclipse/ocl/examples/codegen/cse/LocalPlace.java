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

import java.util.HashSet;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.common.utils.TracingOption;

/**
 * A LocalPlace describes a forest of CG trees that cannot be resolved as global constants. 
 */
public abstract class LocalPlace extends AbstractPlace
{
	protected static @NonNull GlobalPlace getGlobalPlace(@NonNull Map<CGElement, AbstractPlace> element2place) {
		AbstractPlace abstractPlace = element2place.get(null);
		if (abstractPlace instanceof GlobalPlace) {
			return (GlobalPlace) abstractPlace;
		}
		else {
			throw new IllegalStateException("No GlobalPlace");
		}
	}
	
	protected static @NonNull LocalPlace getLocalPlace(@NonNull Map<CGElement, AbstractPlace> element2place, @Nullable CGElement cgElement) {
		if (cgElement == null) {
			throw new IllegalStateException("No LocalPlace for null element");
		}
		AbstractPlace abstractPlace = element2place.get(cgElement);
		return getLocalPlace(abstractPlace, cgElement);
	}

	protected static @NonNull LocalPlace getLocalPlace(@Nullable AbstractPlace abstractPlace, @NonNull CGElement cgElement) {
		if (abstractPlace instanceof LocalPlace) {
			return (LocalPlace) abstractPlace;
		}
		else {
			throw new IllegalStateException("No LocalPlace for " + cgElement);
		}
	}

	protected final @NonNull GlobalPlace globalPlace;
	private /*@LazyNonNull*/ HashSet<ControlPlace> controlPlaces = null;
	
	protected LocalPlace(@NonNull GlobalPlace globalPlace) {
		this.globalPlace = globalPlace;
	}

	public void addControlPlace(@NonNull ControlPlace controlPlace) {
		if (controlPlaces == null) {
			controlPlaces = new HashSet<ControlPlace>();
		}
		controlPlaces.add(controlPlace);
	}
	
	@Override
	public @NonNull GlobalPlace getGlobalPlace() {
		return globalPlace;
	}

	@Override
	public abstract @NonNull StackPlace getStackPlace();
	
	@Override
	public void printHierarchy(@NonNull Appendable appendable, @NonNull String indentation) {
		TracingOption.println(appendable, indentation + this);
		if (controlPlaces != null) {
			for (ControlPlace controlPlace : controlPlaces) {
				controlPlace.printHierarchy(appendable, indentation + "  ");
			}
		}
	}
	
	public void prune() {
		if (controlPlaces != null) {
			for (ControlPlace controlPlace : controlPlaces) {
				controlPlace.prune();
			}
		}
	}
	
	public void pullUp() {
		if (controlPlaces != null) {
			for (ControlPlace controlPlace : controlPlaces) {
				controlPlace.pullUp();
			}
		}
	}
	
	public void pushUp() {
		if (controlPlaces != null) {
			for (ControlPlace controlPlace : controlPlaces) {
				controlPlace.pushUp();
			}
		}
	}
	
	public void rewrite() {
		if (controlPlaces != null) {
			for (ControlPlace controlPlace : controlPlaces) {
				controlPlace.rewrite();
			}
		}
	}
}