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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainFragment;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.library.UnsupportedOperation;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.IndexableIterable;

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
	public static final int OCL_ANY = 1 << 2;
	public static final int OCL_VOID = 1 << 3;
	public static final int OCL_INVALID = 1 << 4;
	
	/**
	 * A simple public static method that may be used to force class initialization.
	 */
	public static void initStatics() {}
	
	protected final @NonNull String name;
	protected final int flags;
//	protected @Nullable Map<String, DomainOperation> operationMap = null;
//	protected @Nullable Map<String, DomainProperty> propertyMap = null;
	
	public AbstractInheritance(@NonNull String name, int flags) {
		this.name = name;
		this.flags = flags;
	}

	public @NonNull DomainInheritance getCommonInheritance(@NonNull DomainInheritance thatInheritance) {
		if (this == thatInheritance) {
			return this;
		}
		if ((flags & (OCL_ANY|OCL_VOID|OCL_INVALID)) != 0) {
			if ((flags & OCL_ANY) != 0) {
				return this;
			}
			else if ((flags & OCL_INVALID) != 0) {
				return thatInheritance;
			}
			else {
				return thatInheritance.isUndefined() ? this : thatInheritance;
			}
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

	public final String getName() {
		return name;
	}

	public final boolean isInvalid() {
		return (flags & OCL_INVALID) != 0;
	}

	public final boolean isOclAny() {
		return (flags & OCL_ANY) != 0;
	}

	public boolean isSubInheritanceOf(@NonNull DomainInheritance thatInheritance) {
		return getFragment(thatInheritance) != null;
	}

	public boolean isSuperInheritanceOf(@NonNull DomainInheritance thatInheritance) {
		return thatInheritance.getFragment(this) != null;
	}

	public final boolean isUndefined() {
		return (flags & (OCL_VOID|OCL_INVALID)) != 0;
	}

	public @NonNull DomainOperation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		getDepth();
		DomainInheritance apparentInheritance = apparentOperation.getInheritance(standardLibrary);
		int apparentDepth = DomainUtil.nonNullModel(apparentInheritance).getDepth();
		if (apparentDepth+1 < getIndexes()) {				// null and invalid may fail here
			int iMax = getIndex(apparentDepth+1);
			for (int i = getIndex(apparentDepth); i < iMax; i++) {
				DomainFragment fragment = getFragment(i);
				if (fragment.getBaseInheritance() == apparentInheritance) {
					DomainOperation actualOperation = fragment.getActualOperation(apparentOperation);
					return actualOperation;
				}
			}
		}
		return apparentOperation;	// invoke apparent op for null and invalid
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		getDepth();
		DomainInheritance apparentInheritance = apparentOperation.getInheritance(standardLibrary);
		int apparentDepth = DomainUtil.nonNullModel(apparentInheritance).getDepth();
		if (apparentDepth+1 < getIndexes()) {				// null and invalid may fail here
			int iMax = getIndex(apparentDepth+1);
			for (int i = getIndex(apparentDepth); i < iMax; i++) {
				DomainFragment fragment = getFragment(i);
				if (fragment.getBaseInheritance() == apparentInheritance) {
					return fragment.getImplementation(apparentOperation);
				}
			}
		}
		LibraryFeature implementation = apparentOperation.getImplementation();	// invoke apparent op for null and invalid
		if (implementation == null) {
			implementation = UnsupportedOperation.INSTANCE;
		}
		return implementation;			
	}

	public @Nullable DomainOperation lookupLocalOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull String operationName, DomainInheritance... argumentTypes) {
		for (DomainOperation localOperation : getType().getOwnedOperations()) {
			if (localOperation.getName().equals(operationName)) {
				ParametersId firstParametersId = localOperation.getParametersId();
				int iMax = firstParametersId.size();
				if (iMax == argumentTypes.length) {
					int i = 0;
					for (; i < iMax; i++) {
						TypeId firstParameterId = firstParametersId.get(i);
						@NonNull DomainType secondParameterType = argumentTypes[i].getType();
						if (firstParameterId != secondParameterType.getTypeId()) {
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
}
