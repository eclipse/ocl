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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainFragment;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.AbstractInheritance;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

/**
 * An ExecutorType defines a Type using a compact representation suitable for efficient
 * execution and static construction.
 */
public abstract class ExecutorType extends AbstractInheritance implements DomainType, ExecutorTypeArgument
{
	/**
	 * Depth ordered inheritance fragments. OclAny at depth 0, OclSelf at depth size-1.
	 */
	private ExecutorFragment[] fragments = null;
	
	/**
	 * The index in fragments at which inheritance fragments at a given depth start.
	 * depthIndexes[0] is always zero since OclAny is always at depth 0.
	 * depthIndexes[depthIndexes.length-2] is always depthIndexes.length-1 since OclSelf is always at depth depthIndexes.length-2.
	 * depthIndexes[depthIndexes.length-1] is always depthIndexes.length to provide an easy end stop.
	 */
	private int[] indexes = null;
	
	private final @NonNull DomainTypeParameters typeParameters;
	private /*@LazyNonNull*/ DomainProperties allProperties;
	
	public ExecutorType(@NonNull String name, @NonNull ExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter... typeParameters) {
		super(name, evaluationPackage, flags);
		this.typeParameters = new DomainTypeParameters(typeParameters);
	}

	@NonNull
	public Iterable<? extends DomainOperation> getAllOperations(@Nullable FeatureFilter featureFilter) {
		throw new UnsupportedOperationException();
	}

	public @NonNull Iterable<? extends DomainProperty> getAllProperties(@Nullable FeatureFilter featureFilter) {
		DomainProperties allProperties2 = allProperties;
		if (allProperties2 == null) {
			allProperties = allProperties2 = new DomainProperties(this);
		}
		return allProperties2.getAllProperties(featureFilter);
	}
	
	public final @NonNull FragmentIterable getAllProperSuperFragments() {
		DomainFragment[] fragments2 = DomainUtil.nonNullState(fragments);
		return new FragmentIterable(fragments2, 0, fragments2.length-1);
	}
	
	public @NonNull FragmentIterable getAllSuperFragments() {
		return new FragmentIterable(DomainUtil.nonNullState(fragments));
	}

	public int getDepth() {
		return indexes.length-2;
	}

	public ExecutorFragment getFragment(int fragmentNumber) {
		return fragments[fragmentNumber];
	}
	
	public int getIndex(int fragmentNumber) {
		return indexes[fragmentNumber];
	}

	public int getIndexes(){
		return indexes.length;
	}

	public @Nullable DomainProperty getMemberProperty(@NonNull String name) {
		DomainProperties allProperties2 = allProperties;
		if (allProperties2 == null) {
			allProperties = allProperties2 = new DomainProperties(this);
		}
		return allProperties2.getMemberProperty(name);
	}

	public @NonNull String getMetaTypeName() {
		throw new UnsupportedOperationException();
	}

	public @NonNull List<? extends DomainProperty> getOwnedProperties() {
		return getSelfFragment().getLocalProperties();
	}

	public @NonNull List<? extends DomainOperation> getOwnedOperations() {
		return getSelfFragment().getLocalOperations();
	}

	public @NonNull ExecutorFragment getSelfFragment() {
		return DomainUtil.nonNullState(getFragment(fragments.length-1));
	}

	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return OCLstdlibTables.LIBRARY;
	}

	public @NonNull List<? extends DomainClass> getSuperClasses() {
		return getSelfFragment().getSuperClasses();
	}
	
	public final @NonNull FragmentIterable getSuperFragments(int depth) {
		return new FragmentIterable(DomainUtil.nonNullState(fragments), indexes[depth], indexes[depth+1]);
	}

	public @NonNull DomainType getType() {
		return this;
	}

	public @NonNull TypeId getTypeId() {
		throw new UnsupportedOperationException();					// FIXME
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		return typeParameters;
	}

	public void initFragments(@NonNull ExecutorFragment[] fragments, int[] depthCounts) {
		int[] indexes = new int[depthCounts.length+1];
		indexes[0] = 0;
		for (int i = 0; i <  depthCounts.length; i++) {
			indexes[i+1] = indexes[i] + depthCounts[i];
		}
		this.fragments = fragments;
		this.indexes = indexes;
	}
}