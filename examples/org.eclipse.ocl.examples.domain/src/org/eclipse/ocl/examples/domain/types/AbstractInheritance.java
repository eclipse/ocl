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
package org.eclipse.ocl.examples.domain.types;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainConstraint;
import org.eclipse.ocl.examples.domain.elements.DomainFragment;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.library.UnsupportedOperation;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.IndexableIterable;
import org.eclipse.ocl.examples.domain.values.OCLValue;

public abstract class AbstractInheritance implements DomainInheritance
{
	public static class FragmentIterable implements IndexableIterable<DomainFragment>
	{
		protected class Iterator implements java.util.Iterator<DomainFragment>
		{
			private int index = firstIndex;
			
			public boolean hasNext() {
				return index < lastIndex;
			}

			public DomainFragment next() {
				return array[index++];
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		}
		
		private final DomainFragment[] array;
		private final int firstIndex;
		private final int lastIndex;
		
		public FragmentIterable(@NonNull DomainFragment[] array) {
			this.array = array;
			this.firstIndex = 0;
			this.lastIndex = array.length;
		}
		
		public FragmentIterable(@NonNull DomainFragment[] array, int firstIndex, int lastIndex) {
			this.array = array;
			this.firstIndex = firstIndex;
			this.lastIndex = lastIndex;
		}

		public @NonNull DomainFragment get(int index) {
			return DomainUtil.nonNullState(array[firstIndex + index]);
		}
		
		public @NonNull java.util.Iterator<DomainFragment> iterator() {
			return new Iterator();
		}

		public int size() {
			return lastIndex - firstIndex;
		}

		@Override
		public String toString() {
			StringBuilder s = null;
			for (int i = firstIndex; i < lastIndex; i++) {
				if (s == null) {
					s = new StringBuilder();
					s.append("[");
				}
				else {
					s.append(", ");
				}
				s.append(array[i]);
			}
			if (s == null) {
				return "";
			}
			s.append("]");
			return s.toString();
		}		
	}

	public static final int ORDERED = 1 << 0;
	public static final int UNIQUE = 1 << 1;
	
	/**
	 * A simple public static method that may be used to force class initialization.
	 */
	public static void initStatics() {}
	
	protected final @NonNull String name;
	protected final @NonNull DomainPackage evaluationPackage;
	protected final int flags;
	protected Map<String, DomainOperation> operationMap = null;
	protected Map<String, DomainProperty> propertyMap = null;
	
	public AbstractInheritance(@NonNull String name, @NonNull DomainPackage evaluationPackage, int flags) {
		this.name = name;
		this.evaluationPackage = evaluationPackage;
		this.flags = flags;
	}

	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		DomainInheritance thatInheritance = type.getInheritance(standardLibrary);
		if (this == thatInheritance) {
			return true;
		}
		return thatInheritance.isSuperInheritanceOf(standardLibrary, this);
	}

//	public @NonNull Object createInstance() {
//		throw new UnsupportedOperationException();
//	}

//	public @Nullable Object createInstance( @NonNull String value) {
//		throw new UnsupportedOperationException();
//	}

	public @NonNull DomainInheritance getCommonInheritance(@NonNull DomainInheritance thatInheritance) {
		if (this == thatInheritance) {
			return this;
		}
		int thatDepth = thatInheritance.getDepth();
		if ((thatDepth ==  1) && thatInheritance.isUndefined()) {
			return this;
		}
		int thisDepth = getDepth();
		int staticDepth = Math.min(thisDepth, thatDepth);
		for ( ; staticDepth > 0; --staticDepth) {
			int iMax = getIndex(staticDepth+1);
			int jMax = thatInheritance.getIndex(staticDepth+1);
			DomainInheritance commonInheritance = null;
			int commonInheritances = 0;
			for (int i = getIndex(staticDepth); i < iMax; i++) {
				DomainInheritance thisBaseInheritance = getFragment(i).getBaseInheritance();
				for (int j = thatInheritance.getIndex(staticDepth); j < jMax; j++) {
					DomainInheritance thatBaseInheritance = thatInheritance.getFragment(j).getBaseInheritance();
					if (thisBaseInheritance == thatBaseInheritance) {
						commonInheritances++;
						commonInheritance = thisBaseInheritance;
						break;
					}
				}
				if (commonInheritances > 1) { 				// More than one so must go less deep to find uniqueness
					break;
				}
			}
			if (commonInheritances == 1) {					// Must be unique to avoid arbitrary choice for e.g. Sequence{1, 2.0, '3'}->elementType
				assert commonInheritance != null;
				return commonInheritance;
			}
		}
		return getFragment(0).getBaseInheritance();	// Always OclAny at index 0
	}
	
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		if (this == type) {
			return this;
		}
		DomainInheritance firstInheritance = this;
		DomainInheritance secondInheritance = type.getInheritance(idResolver.getStandardLibrary());
		DomainInheritance commonInheritance = firstInheritance.getCommonInheritance(secondInheritance);
		return commonInheritance;
	}

	public @Nullable DomainFragment getFragment(@NonNull DomainInheritance thatInheritance) {
		int staticDepth = thatInheritance.getDepth();
		if (staticDepth <= getDepth()) {
			int iMax = getIndex(staticDepth+1);
			for (int i = getIndex(staticDepth); i < iMax; i++) {
				DomainFragment fragment = getFragment(i);
				if (fragment.getBaseInheritance() == thatInheritance) {
					return fragment;
				}
			}
		}
		return null;
	}

	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return this;
	}

	public @Nullable DomainOperation getMemberOperation(@NonNull OperationId operationId) {
		throw new UnsupportedOperationException();					// FIXME
	}

	public final String getName() {
		return name;
	}
	
	/**
	 * @since 3.5
	 */
	public @NonNull Iterable<String> getMemberOperationNames() {
		throw new UnsupportedOperationException();					// FIXME
	}
	
	/**
	 * @since 3.5
	 */
	public @NonNull Iterable<DomainOperation> getMemberOperations() {
		throw new UnsupportedOperationException();					// FIXME
	}

	public @NonNull DomainType getNormalizedType(@NonNull DomainStandardLibrary standardLibrary) {
		return this;
	}

	protected @NonNull DomainInheritance getOclAnyInheritance() {
		DomainStandardLibrary standardLibrary = getStandardLibrary();
		DomainType oclAnyType = standardLibrary.getOclAnyType();
		return oclAnyType.getInheritance(standardLibrary);
	}

	public @NonNull List<? extends DomainConstraint> getOwnedInvariant() {
		throw new UnsupportedOperationException();			// FIXME
	}

	public @NonNull List<? extends DomainConstraint> getOwnedRule() {
		throw new UnsupportedOperationException();			// FIXME
	}
	
	public final @NonNull DomainPackage getPackage() {
		return evaluationPackage;
	}

	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		return this == type;
	}

	public boolean isEqualToUnspecializedType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		return this == type;
	}

	public boolean isInvalid() {
		return false;
	}

	public boolean isOrdered() {
		return (flags & ORDERED) != 0;
	}

	public boolean isSubInheritanceOf(@NonNull DomainInheritance thatInheritance) {
		return getFragment(thatInheritance) != null;
	}

	public boolean isSuperInheritanceOf(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainInheritance thatInheritance) {
		return thatInheritance.getFragment(this) != null;
	}

	public boolean isUndefined() {
		return false;
	}

	public boolean isUnique() {
		return (flags & UNIQUE) != 0;
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation staticOperation) {
		getDepth();
		DomainInheritance staticInheritance = staticOperation.getInheritance(standardLibrary);
		int staticDepth = DomainUtil.nonNullModel(staticInheritance).getDepth();
		if (staticDepth+1 < getIndexes()) {				// null and invalid may fail here
			int iMax = getIndex(staticDepth+1);
			for (int i = getIndex(staticDepth); i < iMax; i++) {
				DomainFragment fragment = getFragment(i);
				if (fragment.getBaseInheritance() == staticInheritance) {
					return fragment.getImplementation(staticOperation);
				}
			}
		}
		LibraryFeature implementation = staticOperation.getImplementation();	// invoke static op for null and invalid
		if (implementation == null) {
			implementation = UnsupportedOperation.INSTANCE;
		}
		return implementation;			
	}

	public @Nullable DomainOperation lookupLocalOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull String operationName, DomainInheritance... argumentTypes) {
		for (DomainOperation localOperation : getLocalOperations()) {
			if (localOperation.getName().equals(operationName)) {
				ParametersId firstParametersId = localOperation.getParametersId();
				int iMax = firstParametersId.size();
				if (iMax == argumentTypes.length) {
					int i = 0;
					for (; i < iMax; i++) {
						TypeId firstParameterId = firstParametersId.get(i);
						DomainType secondParameterType = argumentTypes[i];
						if ((secondParameterType == null) || (firstParameterId != secondParameterType.getTypeId())) {
							break;
						}
					}
					if (i >= iMax) {
						return localOperation;
					}
				}
			}
		}
		return null;
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
