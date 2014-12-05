/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.library.executor;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainCollectionType;
import org.eclipse.ocl.domain.elements.DomainElement;
import org.eclipse.ocl.domain.elements.DomainEnvironment;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.domain.elements.DomainTupleType;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.TemplateParameterId;
import org.eclipse.ocl.domain.ids.TupleTypeId;
import org.eclipse.ocl.domain.types.AbstractCollectionType;
import org.eclipse.ocl.domain.types.AbstractStandardLibrary;
import org.eclipse.ocl.domain.types.AbstractTupleType;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.util.ValuesUtil;
import org.eclipse.ocl.library.oclstdlib.OCLstdlibTables;

public abstract class ExecutableStandardLibrary extends AbstractStandardLibrary implements DomainEnvironment
{
	/**
	 * Shared cache of the lazily created lazily deleted specializations of each type. 
	 */
	private @NonNull Map<DomainType, Map<CollectionTypeParameters<DomainType>, WeakReference<AbstractCollectionType>>> specializations = new WeakHashMap<DomainType, Map<CollectionTypeParameters<DomainType>, WeakReference<AbstractCollectionType>>>();
	
	/**
	 * Shared cache of the lazily created lazily deleted tuples. 
	 */
	private @NonNull Map<TupleTypeId, WeakReference<DomainTupleType>> tupleTypeMap = new WeakHashMap<TupleTypeId, WeakReference<DomainTupleType>>();
	
//	public abstract @NonNull DomainEvaluator createEvaluator(@NonNull EObject contextObject, @Nullable Map<Object, Object> contextMap);

//	@Override
//	protected @NonNull IdResolver createIdResolver() {
//		@SuppressWarnings("null")@NonNull List<EObject> emptyList = Collections.<EObject>emptyList();
//		return new EcoreIdResolver(emptyList, this);
//	}

	@Override
	public @NonNull DomainClass getBagType() {
		return OCLstdlibTables.Types._Bag;
	}

	@Override
	public @NonNull DomainCollectionType getBagType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(getBagType(), elementType, lower, upper);
	}

	@Override
	public @NonNull DomainClass getBooleanType() {
		return OCLstdlibTables.Types._Boolean;
	}

	@Override
	public @NonNull DomainClass getCollectionType() {
		return OCLstdlibTables.Types._Collection;
	}

//	@Override
	@Override
	public synchronized @NonNull DomainCollectionType getCollectionType(@NonNull DomainClass genericType, @NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		IntegerValue lower2 = lower;
		IntegerValue upper2 = upper;
		if (lower2 == null) {
			lower2 = ValuesUtil.ZERO_VALUE;
		}
		if (upper2 == null) {
			upper2 = ValuesUtil.UNLIMITED_VALUE;
		}
		CollectionTypeParameters<DomainType> typeParameters = new CollectionTypeParameters<DomainType>(elementType, lower2, upper2);
		AbstractCollectionType specializedType = null;
		Map<CollectionTypeParameters<DomainType>, WeakReference<AbstractCollectionType>> map = specializations.get(genericType);
		if (map == null) {
			map = new WeakHashMap<CollectionTypeParameters<DomainType>, WeakReference<AbstractCollectionType>>();
			specializations.put(genericType, map);
		}
		else {
			specializedType = weakGet(map, typeParameters);
		}
		if (specializedType == null) {
			specializedType = new AbstractCollectionType(this, DomainUtil.nonNullModel(genericType.getName()), genericType, elementType, lower, upper);
			map.put(typeParameters, new WeakReference<AbstractCollectionType>(specializedType));
		}
		return specializedType;
	}

	@Override
	public @NonNull DomainClass getIntegerType() {
		return OCLstdlibTables.Types._Integer;
	}

	// FIXME cf MetaModelManager
	@Override
	public @NonNull DomainClass getMetaclass(@NonNull DomainType classType) {
//		return OCLstdlibTables.Types._OclType;
		return getClassType();
	}

	@Override
	public @Nullable DomainPackage getNestedPackage(@NonNull DomainPackage parentPackage, @NonNull String name) {
		return DomainUtil.getNamedElement(parentPackage.getOwnedPackages(), name);
	}

	@Override
	public @Nullable DomainClass getNestedType(@NonNull DomainPackage parentPackage, @NonNull String name) {
		return DomainUtil.getNamedElement(parentPackage.getOwnedClasses(), name);
	}

	@Override
	public @NonNull DomainClass getOclAnyType() {
		return OCLstdlibTables.Types._OclAny;
	}

	@Override
	public @NonNull DomainClass getOclComparableType() {
		return OCLstdlibTables.Types._OclComparable;
	}

	@Override
	public @NonNull DomainClass getOclElementType() {
		return OCLstdlibTables.Types._OclElement;
	}

	@Override
	public @NonNull DomainClass getOclInvalidType() {
		return OCLstdlibTables.Types._OclInvalid;
	}

	@Override
	public @NonNull DomainClass getOclMessageType() {
		return OCLstdlibTables.Types._OclMessage;
	}

	@Override
	public @NonNull DomainClass getOclSelfType() {
		return OCLstdlibTables.Types._OclSelf;
	}

	@Override
	public @NonNull DomainClass getOclSummableType() {
		return OCLstdlibTables.Types._OclSummable;
	}

	@Override
	public @NonNull DomainClass getOclTupleType() {
		return OCLstdlibTables.Types._OclTuple;
	}

	@Override
	public @NonNull DomainClass getOclVoidType() {
		return OCLstdlibTables.Types._OclVoid;
	}

	@Override
	public @NonNull DomainClass getOrderedCollectionType() {
		return OCLstdlibTables.Types._OrderedCollection;
	}

	@Override
	public @NonNull DomainClass getOrderedSetType() {
		return OCLstdlibTables.Types._OrderedSet;
	}

	@Override
	public @NonNull DomainCollectionType getOrderedSetType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(getOrderedSetType(), elementType, lower, upper);
	}

	@Override
	public @NonNull DomainClass getRealType() {
		return OCLstdlibTables.Types._Real;
	}

	@Override
	public @NonNull DomainClass getSequenceType() {
		return OCLstdlibTables.Types._Sequence;
	}

	@Override
	public @NonNull DomainCollectionType getSequenceType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(getSequenceType(), elementType, lower, upper);
	}

	@Override
	public @NonNull DomainClass getSetType() {
		return OCLstdlibTables.Types._Set;
	}

	@Override
	public @NonNull DomainCollectionType getSetType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(getSetType(), elementType, lower, upper);
	}

	
	@Override
	public @NonNull ExecutableStandardLibrary getStandardLibrary() {
		return this;
	}

	@Override
	public @NonNull DomainClass getStringType() {
		return OCLstdlibTables.Types._String;
	}

/*	public @NonNull DomainTupleType getTupleType(@NonNull List<? extends DomainTypedElement> parts) {
		StringBuilder s = new StringBuilder();
		for (DomainTypedElement part : parts) {
			s.append(part.getName());
			s.append("\n"); //$NON-NLS-1$
		}
		String key = s.toString();
		synchronized (this) {
			List<WeakReference<DomainTupleType>> tupleTypes = tupleTypeMap.get(key);
			if (tupleTypes != null) {
				for (int j = tupleTypes.size(); --j >= 0; ) {
					WeakReference<DomainTupleType> tupleTypeRef = tupleTypes.get(j);
					DomainTupleType tupleType = tupleTypeRef.get();
					if (tupleType == null) {
						tupleTypes.remove(j);		// Trim stale list entry.
					}
					else {
						int i = 0;
						for (; i < parts.size(); i++) {
							List<? extends DomainTypedElement> ownedAttributes = tupleType.getOwnedAttribute();
							if (ownedAttributes.get(i).getType() != parts.get(i).getType()) {
								break;
							}
						}
						if (i >= parts.size()) {
							return tupleType;
						}
					}
				}
			}
			else {
				tupleTypes = new ArrayList<WeakReference<DomainTupleType>>();
				tupleTypeMap.put(key, tupleTypes);
			}
			DomainTupleType tupleType = new AbstractTupleType(this, parts);
			tupleTypes.add(new WeakReference<DomainTupleType>(tupleType));
			return tupleType;
		}
	} */

	public @NonNull DomainElement getTemplateParameter(@NonNull TemplateParameterId id, DomainElement context) {
		throw new UnsupportedOperationException();
	}

	public synchronized @NonNull DomainTupleType getTupleType(@NonNull TupleTypeId typeId) {
		WeakReference<DomainTupleType> ref = tupleTypeMap.get(typeId);
		if (ref != null) {
			DomainTupleType domainTupleType = ref.get();
			if (domainTupleType != null) {
				return domainTupleType;
			}
		}
		DomainTupleType domainTupleType = new AbstractTupleType(this, typeId);
		tupleTypeMap.put(typeId, new WeakReference<DomainTupleType>(domainTupleType));
		return domainTupleType;
	}

	@Override
	public @NonNull DomainClass getUniqueCollectionType() {
		return OCLstdlibTables.Types._UniqueCollection;
	}

	@Override
	public @NonNull DomainClass getUnlimitedNaturalType() {
		return OCLstdlibTables.Types._UnlimitedNatural;
	}
}
