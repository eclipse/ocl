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

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

public class SimpleAnalysis extends AbstractAnalysis
{	
	static final Logger logger = Logger.getLogger(SimpleAnalysis.class);

	public static final @NonNull SimpleAnalysis[] EMPTY_LIST = new SimpleAnalysis[] {};

	protected final @NonNull StackPlace stackPlace;
	protected final @NonNull CGValuedElement cgElement;
	protected final int depth;
	protected final int structuralHashCode;
	protected final @NonNull SimpleAnalysis[] children;
	private @Nullable SimpleAnalysis parent = null;
	private @Nullable CommonAnalysis commonAnalysis = null;
	
	public SimpleAnalysis(@NonNull StackPlace stackPlace, @NonNull CGValuedElement cgElement, int depth, int structuralHashCode, @NonNull SimpleAnalysis[] children) {
		this.stackPlace = stackPlace;
		this.cgElement = cgElement;
		this.depth = depth;
		this.structuralHashCode = structuralHashCode;
		this.children = children;
//		Set<Object> allReferences = null;
//		List<Object> references = cgElement.accept(globalPlace.getReferencesVisitor());
//		if (references != null) {
//			allReferences = new HashSet<Object>(references);
//		}
		for (SimpleAnalysis child : children) {
			child.parent = this;
		}
		GlobalPlace globalPlace = stackPlace.getGlobalPlace();
		if (cgElement.isCommonable()) {
			ControlPlace controlPlace = globalPlace.getControlPlace(cgElement);
			controlPlace.addAnalysis(this);
		}
		globalPlace.addSimpleAnalysis(this);
	}

	@Override
	public @NonNull CommonAnalysis addAnalysis(@NonNull AbstractAnalysis anAnalysis) {
		return anAnalysis.addSimpleAnalysis(this);
	}

	@Override
	public @NonNull CommonAnalysis addCommonAnalysis(@NonNull CommonAnalysis commonAnalysis) {
		return commonAnalysis.addSimpleAnalysis(this);
	}

	@Override
	public @NonNull CommonAnalysis addSimpleAnalysis(@NonNull SimpleAnalysis simpleAnalysis) {
		assert simpleAnalysis.commonAnalysis == null;
		CommonAnalysis thisSharedAnalysis = commonAnalysis;
		if (thisSharedAnalysis != null) {
			return thisSharedAnalysis.addSimpleAnalysis(this);
		}
		return new CommonAnalysis(this, simpleAnalysis);
	}

	public void dispose() {
		if (commonAnalysis != null) {
			commonAnalysis.removedSimpleAnalysis(this);
			commonAnalysis = null;
		}
		for (SimpleAnalysis simpleAnalysis : children) {
			simpleAnalysis.dispose();
		}
	}
	
	public @NonNull CGValuedElement getCGElement() {
		return cgElement;
	}

	public int getDepth() {
		return depth;
	}

	public @Nullable SimpleAnalysis getParent() {
		return parent;
	}

	@Override
	public int getStructuralHashCode() {
		return structuralHashCode;
	}
	
	@Override
	public boolean isStructurallyEqualTo(@NonNull AbstractAnalysis thatAnalysis) {
		return thatAnalysis.isStructurallyEqualTo(this);
	}

	@Override
	public boolean isStructurallyEqualTo(@NonNull SimpleAnalysis that) {
		if (this == that) {
			return true;
		}
		if (structuralHashCode != that.structuralHashCode) {
			return false;
		}
		if (this.cgElement.getClass() != that.cgElement.getClass()) {
			return false;
		}
		SimpleAnalysis[] theseChildren = children;
		SimpleAnalysis[] thoseChildren = that.children;
		if (theseChildren.length != thoseChildren.length) {
			return false;
		}
		for (int i = 0; i < theseChildren.length; i++) {
			SimpleAnalysis thisChild = theseChildren[i];
			SimpleAnalysis thatChild = thoseChildren[i];
			if ((thisChild == null) || (thatChild == null)) {
				return false;					// Never happens
			}
			if (!thisChild.isStructurallyEqualTo(thatChild)) {
				return false;
			}
		}
		GlobalPlace globalPlace = stackPlace.getGlobalPlace();
		ReferencesVisitor referencesVisitor = globalPlace.getReferencesVisitor();
		List<Object> theseObjects = this.cgElement.accept(referencesVisitor);
		List<Object> thoseObjects = that.cgElement.accept(referencesVisitor);
		if (theseObjects == null) {
			if (thoseObjects != null) {
				return false;
			}
		}
		else {
			if (thoseObjects == null) {
				return false;
			}
			if (theseObjects.size() != thoseObjects.size()) {
				return false;
			}
			for (int i = 0; i < theseObjects.size(); i++) {
				Object thisObject = theseObjects.get(i);
				Object thatObject = thoseObjects.get(i);
				if (thisObject == null) {
					if (thatObject != null) {
						return false;
					}
				}
				else {
					if (thatObject == null) {
						return false;
					}
					else if ((thisObject instanceof CGElement) && (thatObject instanceof CGElement)) {
						SimpleAnalysis thisAnalysis = globalPlace.getSimpleAnalysis(thisObject);
						SimpleAnalysis thatAnalysis = globalPlace.getSimpleAnalysis(thatObject);
						if ((thisAnalysis != null) && (thatAnalysis != null)) {
							if (!thisAnalysis.isStructurallyEqualTo(thatAnalysis)) {
								return false;
							}
							else {
								logger.error("Missing analysis");
							}
						}
					}
					else if (!thisObject.equals(thatObject)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public void setCommonAnalysis(@NonNull CommonAnalysis commonAnalysis) {
		if (this.commonAnalysis != null) {
			this.commonAnalysis.removedSimpleAnalysis(this);
		}
		this.commonAnalysis = commonAnalysis;
		this.commonAnalysis.addedSimpleAnalysis(this);
	}

	@Override
	public String toString() {
		return depth + "," + String.valueOf(cgElement);
	}
}