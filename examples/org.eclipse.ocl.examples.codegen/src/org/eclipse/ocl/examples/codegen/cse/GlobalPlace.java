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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.common.utils.TracingOption;

/**
 * The GlobalPlace describes a forest of CG trees that can be resolved as global constants. 
 */
public class GlobalPlace extends AbstractPlace
{
	@SuppressWarnings("null")
	public static @NonNull AbstractPlace createPlace(@NonNull Map<CGElement, AbstractPlace> element2place, @NonNull CGElement cgElement) {
		return element2place.get(null);
	}

 	protected final @NonNull CodeGenAnalyzer analyzer;
	protected final @NonNull ReferencesVisitor referencesVisitor;
	private final @NonNull Map<CGElement, AbstractPlace> element2place = new HashMap<CGElement, AbstractPlace>();
	private final @NonNull Set<OuterStackPlace> stackPlaces = new HashSet<OuterStackPlace>();
	private final @NonNull Map<CGElement, SimpleAnalysis> element2simpleAnalysis = new HashMap<CGElement, SimpleAnalysis>();

	public GlobalPlace(@NonNull CodeGenAnalyzer analyzer) {
		this.analyzer = analyzer;
		this.referencesVisitor = analyzer.getCodeGenerator().createReferencesVisitor();
	}

	public void addSimpleAnalysis(@NonNull SimpleAnalysis simpleAnalysis) {
		element2simpleAnalysis.put(simpleAnalysis.getCGElement(), simpleAnalysis);
	}

	void addStackPlace(@NonNull OuterStackPlace stackPlace) {
		stackPlaces.add(stackPlace);
	}
	
	/**
	 * Populate the map from structural hash code to same-hashed analysis in the analysis tree rooted at thisAnalysis.
	 * <p>
	 * Returns the SimpleAnalysis of cgElement.
	 */
	protected @Nullable SimpleAnalysis buildSimpleAnalysisTree(@NonNull CGElement cgElement, int depth) {
		//
		//	Create the Place hierarchy in Preorder
		//
		AbstractPlace abstractPlace = element2place.get(cgElement);
		if (abstractPlace == null) {
			abstractPlace = cgElement.getPlace(element2place);
			if (abstractPlace == null) {
				return null;
			}
			if (element2place.get(cgElement) == null) {
				element2place.put(cgElement, abstractPlace);
			}
		}
		//
		//	Determine the local part of the structural hash code from referenced objects
		//
		int structuralHashCode = cgElement.getClass().hashCode();
		List<Object> referencedObjects = cgElement.accept(referencesVisitor);
		if (referencedObjects != null) {
			for (Object referencedObject : referencedObjects) {
				int referenceHashCode = referencedObject != null ? referencedObject.hashCode() : 0;
				structuralHashCode = 3 * structuralHashCode + referenceHashCode;
			}
		}
		//
		//	Accumulate the contained part of the structural hash code in a post order traversal
		//
		Iterable<? extends CGElement> childElements = cgElement.getChildren();
		List<SimpleAnalysis> childAnalyses = null;
		for (CGElement cgChild : childElements) {
			if (cgChild != null) {
				SimpleAnalysis childAnalysis = buildSimpleAnalysisTree(cgChild, depth+1);
				if (childAnalysis != null) {
					structuralHashCode = 3 * structuralHashCode + childAnalysis.getStructuralHashCode();
					if (childAnalyses == null) {
						childAnalyses = new ArrayList<SimpleAnalysis>();
					}
					childAnalyses.add(childAnalysis);
				}
			}
		}
		if (!(cgElement instanceof CGValuedElement)) {
			return null;
		}
		CGValuedElement cgValuedElement = (CGValuedElement)cgElement;
/*		if (cgValuedElement.isContext()) {
			return null;
		}
		@NonNull CGValuedElement stackedElement = cgValuedElement;
		for (CGElement cgParent; (cgParent = stackedElement.getParent()) instanceof CGValuedElement; stackedElement = (CGValuedElement) cgParent) {
			if (cgParent.isContext()) {
				break;
			}
		} */
	//	StackPlace stackPlace = element2place.get(stackedElement);
	//	if (stackPlace == null) {
	//		stackPlace = new StackPlace(this, stackedElement);
	//		element2place.put(stackedElement, stackPlace);
	//	}
	//	if (stackedElement != cgElement) {
	//		element2place.put(cgElement, stackPlace);
	//	}
		StackPlace stackPlace = abstractPlace.getStackPlace();
		if (stackPlace == null) {
			return null;
		}
		if (cgValuedElement == stackPlace.getStackElement()) {
			return null;
		}
		SimpleAnalysis structuralAnalysis;
		if (childAnalyses != null) {
			@SuppressWarnings("null")@NonNull SimpleAnalysis[] childArray = childAnalyses.toArray(new SimpleAnalysis[childAnalyses.size()]);
			structuralAnalysis = new SimpleAnalysis(stackPlace, cgValuedElement, depth, structuralHashCode, childArray);
		}
		else {
			structuralAnalysis = new SimpleAnalysis(stackPlace, cgValuedElement, depth, structuralHashCode, SimpleAnalysis.EMPTY_LIST);
		}
		return structuralAnalysis;
	}

	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return analyzer;
	}

	public @NonNull ControlPlace getControlPlace(@NonNull CGValuedElement cgElement) {
		AbstractPlace abstractPlace = element2place.get(cgElement);
		if (abstractPlace instanceof ControlPlace) {
			return (ControlPlace) abstractPlace;
		}
		else {
			throw new IllegalStateException("Not ControlPlace " + abstractPlace);
		}
	}
	
	@Override
	public @NonNull GlobalPlace getGlobalPlace() {
		return this;
	}
	
	@Override
	public @NonNull GlobalPlace getParentPlace() {
		return this;
	}

	public @Nullable AbstractPlace getPlace(@NonNull CGElement cgElement) {
		return element2place.get(cgElement);
	}

	public @NonNull ReferencesVisitor getReferencesVisitor() {
		return referencesVisitor;
	}

	public @Nullable SimpleAnalysis getSimpleAnalysis(@NonNull Object anObject) {
		return element2simpleAnalysis.get(anObject);
	}

	@Override
	public @Nullable StackPlace getStackPlace() {
		return null;
	}

	/**
	 * Optimize the cgRoot tree by eliminating common subexpressions.
	 */
	public void optimize(@NonNull CGElement cgRoot) {
		element2place.put(null, this);
		element2place.put(cgRoot, this);
		//
		//	Analyze the tree to create an analysis per node and a partitioning into Places
		//	with a Map from structural hash code to analysis in each Place.
		//
		buildSimpleAnalysisTree(cgRoot, 0);
		//
		if (CommonSubexpressionEliminator.CSE_PLACES.isActive()) {
			CommonSubexpressionEliminator.CSE_PLACES.println("Places");
			printHierarchy(CommonSubexpressionEliminator.CSE_PLACES, "");
		}
		//
		//	Optimize each outer stack place.
		//
		for (OuterStackPlace stackPlace : stackPlaces) {
			stackPlace.optimize(analyzer);
		}
	}
	
	@Override
	public void printHierarchy(@NonNull Appendable appendable, @NonNull String indentation) {
		TracingOption.println(appendable, indentation + "GlobalPlace");
		for (OuterStackPlace stackPlace : stackPlaces) {
			stackPlace.printHierarchy(appendable, indentation + "  ");
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}