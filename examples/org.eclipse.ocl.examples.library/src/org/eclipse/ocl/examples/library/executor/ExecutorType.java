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
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainConstraint;
import org.eclipse.ocl.examples.domain.elements.DomainFragment;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.AbstractInheritance;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.ArrayIterable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.OCLValue;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

/**
 * An ExecutorType defines a Type using a compact representation suitable for efficient
 * execution and static construction.
 */
public abstract class ExecutorType extends AbstractInheritance implements DomainClass, ExecutorTypeArgument
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
	
	protected final @NonNull DomainPackage evaluationPackage;
	private final @NonNull DomainTypeParameters typeParameters;
	private /*@LazyNonNull*/ DomainProperties allProperties;
	
	public ExecutorType(@NonNull String name, @NonNull ExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter... typeParameters) {
		super(name, flags);
		this.evaluationPackage = evaluationPackage;
		this.typeParameters = new DomainTypeParameters(typeParameters);
	}

	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		DomainInheritance thatInheritance = type.getInheritance(standardLibrary);
		if (this == thatInheritance) {
			return true;
		}
		return thatInheritance.isSuperInheritanceOf(this);
	}
	
	public final @NonNull FragmentIterable getAllProperSuperFragments() {
		DomainFragment[] fragments2 = DomainUtil.nonNullState(fragments);
		return new FragmentIterable(fragments2, 0, fragments2.length-1);
	}
	
	public @NonNull FragmentIterable getAllSuperFragments() {
		return new FragmentIterable(DomainUtil.nonNullState(fragments));
	}
	
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		if (this == type) {
			return this.getType();
		}
		DomainInheritance firstInheritance = this;
		DomainInheritance secondInheritance = type.getInheritance(idResolver.getStandardLibrary());
		DomainInheritance commonInheritance = firstInheritance.getCommonInheritance(secondInheritance);
		return commonInheritance.getType();
	}

	public int getDepth() {
		return indexes.length-2;
	}
	
	public @NonNull Iterable<DomainFragment> getFragments() {
		return new ArrayIterable<DomainFragment>(fragments);
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

	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return this;
	}

	public @Nullable DomainOperation getMemberOperation(@NonNull OperationId operationId) {
		throw new UnsupportedOperationException();					// FIXME
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

	public @NonNull DomainClass getNormalizedType(@NonNull DomainStandardLibrary standardLibrary) {
		return this;
	}

	public @NonNull List<? extends DomainConstraint> getOwnedInvariants() {
		throw new UnsupportedOperationException();			// FIXME
	}

	public @NonNull List<? extends DomainProperty> getOwnedProperties() {
		return getSelfFragment().getLocalProperties();
	}

	public @NonNull List<? extends DomainOperation> getOwnedOperations() {
		return getSelfFragment().getLocalOperations();
	}
	
	public @NonNull DomainPackage getOwningPackage() {
		return evaluationPackage;
	}

	public @NonNull List<? extends DomainConstraint> getOwnedRule() {
		throw new UnsupportedOperationException();			// FIXME
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

	public @NonNull DomainClass getType() {
		return this;
	}

//	public @NonNull TypeId getTypeId() {
//		throw new UnsupportedOperationException();					// FIXME
//	}

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

	public @NonNull DomainClass isClass() {
		return this;
	}

	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		return this == type;
	}

	public boolean isEqualToUnspecializedType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		return this == type;
	}

	public boolean isOrdered() {
		return (flags & ORDERED) != 0;
	}

	public @Nullable DomainTemplateParameter isTemplateParameter() {
		return null;
	}

	public boolean isUnique() {
		return (flags & UNIQUE) != 0;
	}

	public boolean oclEquals(@NonNull OCLValue thatValue) {
		if (!(thatValue instanceof DomainType)) {
			return false;
		}
		TypeId thisTypeId = getTypeId();
		TypeId thatTypeId = ((DomainType)thatValue).getTypeId();
		return thisTypeId.equals(thatTypeId);
	}

	public int oclHashCode() {
		return getTypeId().hashCode();
	}

	public DomainType specializeIn(@NonNull DomainCallExp expr, DomainType selfType) {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}
	
	@Override
	public String toString() {
		return String.valueOf(evaluationPackage) + "::" + String.valueOf(name); //$NON-NLS-1$
	}
}