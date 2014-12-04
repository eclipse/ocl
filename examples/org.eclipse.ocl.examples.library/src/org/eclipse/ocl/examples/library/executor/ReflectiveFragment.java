/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.executor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainFragment;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.types.AbstractFragment;
import org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation;

/**
 * A ReflectiveFragment provides the description of the properties and operations defined by some class when accessed by the same
 * or another class. The descriptions are normally built lazily and one name at a time using reflective access to some meta-model.
 */
public abstract class ReflectiveFragment extends AbstractFragment
{
	protected Map<DomainOperation, LibraryFeature> operationMap = null;
	protected Map<DomainOperation, DomainOperation> apparentOperation2actualOperation = null;
	protected Map<DomainProperty, LibraryFeature> propertyMap = null;

	public ReflectiveFragment(@NonNull DomainInheritance derivedInheritance, @NonNull DomainInheritance baseInheritance) {
		super(derivedInheritance, baseInheritance);
	}

	@Override
	public @NonNull LibraryFeature getImplementation(@NonNull DomainOperation apparentOperation) {
		if (operationMap == null) {
			synchronized (this) {
				if (operationMap == null) {
					operationMap = new HashMap<DomainOperation, LibraryFeature>();		// Optimize to reuse single super map if no local ops
				}
			}
		}
		LibraryFeature libraryFeature = operationMap.get(apparentOperation);
		if (libraryFeature != null) {
			return libraryFeature;
		}
		synchronized (operationMap) {
			libraryFeature = operationMap.get(apparentOperation);
			if (libraryFeature != null) {
				return libraryFeature;
			}
			DomainOperation localOperation = getLocalOperation(apparentOperation);
			if (localOperation == null) {
				if (derivedInheritance == baseInheritance) {
					localOperation = apparentOperation;
				}
			}
			if (localOperation != null) {				// Trivial case, there is a local operation
				libraryFeature = localOperation.getImplementation();
			}
			else {										// Non-trivial, search up the inheritance tree for an inherited operation
				DomainOperation bestOverload = null;
				DomainInheritance bestInheritance = null;
				int bestDepth = -1;
				int minDepth = baseInheritance.getDepth();
				for (int depth = derivedInheritance.getDepth()-1; depth >= minDepth; depth--) {
					Iterable<DomainFragment> derivedSuperFragments = derivedInheritance.getSuperFragments(depth);
					for (DomainFragment derivedSuperFragment : derivedSuperFragments) {
						DomainInheritance superInheritance = derivedSuperFragment.getBaseInheritance();
						DomainFragment superFragment = superInheritance.getFragment(baseInheritance);
						if (superFragment != null) {
							DomainOperation overload = superFragment.getLocalOperation(apparentOperation);
							if (overload != null) {
								if (bestInheritance == null) {				// First candidate
									bestDepth = depth;
									bestInheritance = superInheritance;
									bestOverload = overload;
								}
								else if (depth == bestDepth) {				// Sibling candidate 
									bestOverload = null;
									depth = -1;
									break;
								}
								else if (!bestInheritance.isSubInheritanceOf(superInheritance)) {	// Non-occluded child candidate
									bestOverload = null;
									depth = -1;
									break;
								}
							}
						}
					}
				}
				if (bestOverload != null) {
					libraryFeature = bestOverload.getImplementation();
				}
				else {
					libraryFeature = OclAnyUnsupportedOperation.AMBIGUOUS;
				}
			}
			if (libraryFeature == null) {
				libraryFeature = OclAnyUnsupportedOperation.INSTANCE;
			}
			operationMap.put(apparentOperation, libraryFeature);
			return libraryFeature;
		}
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull Iterable<? extends DomainOperation> getLocalOperations() {
		return operationMap != null ? operationMap.keySet() : Collections.<DomainOperation>emptyList();
	}
	
	@Override
	@SuppressWarnings("null")
	public @NonNull Iterable<? extends DomainProperty> getLocalProperties() {
		return propertyMap != null ? propertyMap.keySet() : Collections.<DomainProperty>emptyList();
	}
}