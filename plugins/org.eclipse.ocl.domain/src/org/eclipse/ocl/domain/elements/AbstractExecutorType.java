/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.elements;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.OperationId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.types.AbstractInheritance;
import org.eclipse.ocl.domain.types.IdResolver;
import org.eclipse.ocl.domain.utilities.IndexableIterable;
import org.eclipse.ocl.domain.values.OCLValue;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExtension;

public class AbstractExecutorType extends AbstractInheritance implements Type
{
	public AbstractExecutorType(@NonNull String name, int flags) {
		super(name, flags);
	}

	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary,
			@NonNull DomainType thatType) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public DomainType getCommonType(@NonNull IdResolver idResolver,
			@NonNull DomainType thatType) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public DomainInheritance getInheritance(
			@NonNull DomainStandardLibrary standardLibrary) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public String getMetaTypeName() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public DomainClass getNormalizedType(
			@NonNull DomainStandardLibrary standardLibrary) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public TypeId getTypeId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary,
			@NonNull DomainType thatType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEqualToUnspecializedType(
			@NonNull DomainStandardLibrary standardLibrary,
			@NonNull DomainType type) {
		throw new UnsupportedOperationException();
	}

	@Override
	public DomainType specializeIn(@NonNull CallExp expr, DomainType selfType) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<? extends Constraint> getOwnedRule() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int oclHashCode() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public Iterable<DomainFragment> getAllProperSuperFragments() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public Iterable<DomainFragment> getAllSuperFragments() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getDepth() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public Iterable<DomainFragment> getFragments() {
		throw new UnsupportedOperationException();
	}

	@Override
	public DomainFragment getFragment(int fragmentNumber) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getIndex(int fragmentNumber) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getIndexes() {
		throw new UnsupportedOperationException();
	}

	@Override
	@Nullable
	public Operation getMemberOperation(@NonNull OperationId id) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Nullable
	public Property getMemberProperty(@NonNull String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public DomainFragment getSelfFragment() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public IndexableIterable<DomainFragment> getSuperFragments(int depth) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public DomainClass getType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<TypeExtension> getExtendedBys() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Type flattenedType() {
		throw new UnsupportedOperationException();
	}

	@Override
	@Nullable
	public Class isClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	@Nullable
	public TemplateParameter isTemplateParameter() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Type specializeIn(OCLExpression expr, Type selfType) {
		throw new UnsupportedOperationException();
	}
}