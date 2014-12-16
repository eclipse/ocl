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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.elements.AbstractExecutorElement;
import org.eclipse.ocl.pivot.ids.PrimitiveTypeId;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.types.AbstractCollectionType;
import org.eclipse.ocl.pivot.types.AbstractTupleType;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionTypeParameters;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public abstract class ExecutableStandardLibrary extends AbstractExecutorElement implements CompleteEnvironment, StandardLibrary
{
	/**
	 * Shared cache of the lazily created lazily deleted specializations of each type. 
	 */
	private @NonNull Map<Type, Map<CollectionTypeParameters<Type>, WeakReference<AbstractCollectionType>>> specializations = new WeakHashMap<Type, Map<CollectionTypeParameters<Type>, WeakReference<AbstractCollectionType>>>();
	
	/**
	 * Shared cache of the lazily created lazily deleted tuples. 
	 */
	private @NonNull Map<TupleTypeId, WeakReference<TupleType>> tupleTypeMap = new WeakHashMap<TupleTypeId, WeakReference<TupleType>>();

	@Override
	public @NonNull Iterable<? extends CompletePackage> getAllCompletePackages() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getBagType() {
		return OCLstdlibTables.Types._Bag;
	}

	@Override
	public @NonNull CollectionType getBagType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getBagType(), elementType, lower, upper);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getBooleanType() {
		return OCLstdlibTables.Types._Boolean;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getCollectionType() {
		return OCLstdlibTables.Types._Collection;
	}

//	@Override
	@Override
	public synchronized @NonNull CollectionType getCollectionType(@NonNull org.eclipse.ocl.pivot.Class genericType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		IntegerValue lower2 = lower;
		UnlimitedNaturalValue upper2 = upper;
		if (lower2 == null) {
			lower2 = ValueUtil.ZERO_VALUE;
		}
		if (upper2 == null) {
			upper2 = ValueUtil.UNLIMITED_VALUE;
		}
		CollectionTypeParameters<Type> typeParameters = TypeUtil.createCollectionTypeParameters(elementType, lower2, upper2);
		AbstractCollectionType specializedType = null;
		Map<CollectionTypeParameters<Type>, WeakReference<AbstractCollectionType>> map = specializations.get(genericType);
		if (map == null) {
			map = new WeakHashMap<CollectionTypeParameters<Type>, WeakReference<AbstractCollectionType>>();
			specializations.put(genericType, map);
		}
		else {
			specializedType = weakGet(map, typeParameters);
		}
		if (specializedType == null) {
			specializedType = new AbstractCollectionType(ClassUtil.nonNullModel(genericType.getName()), genericType, elementType, lower, upper);
			map.put(typeParameters, new WeakReference<AbstractCollectionType>(specializedType));
		}
		return specializedType;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getIntegerType() {
		return OCLstdlibTables.Types._Integer;
	}

	// FIXME cf MetaModelManager
	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getMetaclass(@NonNull Type classType) {
//		return OCLstdlibTables.Types._OclType;
		return getClassType();
	}

	@Override
	public Type getMetaType(@NonNull Type instanceType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable org.eclipse.ocl.pivot.Package getNestedPackage(@NonNull org.eclipse.ocl.pivot.Package parentPackage, @NonNull String name) {
		return ClassUtil.getNamedElement(parentPackage.getOwnedPackages(), name);
	}

	@Override
	public @Nullable org.eclipse.ocl.pivot.Class getNestedType(@NonNull org.eclipse.ocl.pivot.Package parentPackage, @NonNull String name) {
		return ClassUtil.getNamedElement(parentPackage.getOwnedClasses(), name);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getOclAnyType() {
		return OCLstdlibTables.Types._OclAny;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getOclComparableType() {
		return OCLstdlibTables.Types._OclComparable;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getOclElementType() {
		return OCLstdlibTables.Types._OclElement;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getOclInvalidType() {
		return OCLstdlibTables.Types._OclInvalid;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getOclMessageType() {
		return OCLstdlibTables.Types._OclMessage;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getOclSelfType() {
		return OCLstdlibTables.Types._OclSelf;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getOclSummableType() {
		return OCLstdlibTables.Types._OclSummable;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getOclTupleType() {
		return OCLstdlibTables.Types._OclTuple;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getOclVoidType() {
		return OCLstdlibTables.Types._OclVoid;
	}

	@Override
	public @Nullable Element getOperationTemplateParameter(@NonNull Operation anOperation, int index) {
		return anOperation.getTypeParameters().get(index);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getOrderedCollectionType() {
		return OCLstdlibTables.Types._OrderedCollection;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getOrderedSetType() {
		return OCLstdlibTables.Types._OrderedSet;
	}

	@Override
	public @NonNull CollectionType getOrderedSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getOrderedSetType(), elementType, lower, upper);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Package getPackage() {
		return OCLstdlibTables.PACKAGE;
	}

	@Override
	public @Nullable Type getPrimitiveType(@NonNull PrimitiveTypeId typeId) {
		return TypeUtil.getPrimitiveType(this, typeId);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getRealType() {
		return OCLstdlibTables.Types._Real;
	}

	@Override
	public org.eclipse.ocl.pivot.Package getRootPackage(@NonNull String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getSequenceType() {
		return OCLstdlibTables.Types._Sequence;
	}

	@Override
	public @NonNull CollectionType getSequenceType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getSequenceType(), elementType, lower, upper);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getSetType() {
		return OCLstdlibTables.Types._Set;
	}

	@Override
	public @NonNull CollectionType getSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(getSetType(), elementType, lower, upper);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStringType() {
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

	public @NonNull Element getTemplateParameter(@NonNull TemplateParameterId id, Element context) {
		throw new UnsupportedOperationException();
	}

	public synchronized @NonNull TupleType getTupleType(@NonNull TupleTypeId typeId) {
		WeakReference<TupleType> ref = tupleTypeMap.get(typeId);
		if (ref != null) {
			TupleType domainTupleType = ref.get();
			if (domainTupleType != null) {
				return domainTupleType;
			}
		}
		TupleType domainTupleType = new AbstractTupleType(typeId);
		tupleTypeMap.put(typeId, new WeakReference<TupleType>(domainTupleType));
		return domainTupleType;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getUniqueCollectionType() {
		return OCLstdlibTables.Types._UniqueCollection;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getUnlimitedNaturalType() {
		return OCLstdlibTables.Types._UnlimitedNatural;
	}

	@Override
	public @NonNull LambdaType getLambdaType(@NonNull String typeName,
			@NonNull Type contextType,
			@NonNull List<? extends Type> parameterTypes,
			@NonNull Type resultType,
			@Nullable TemplateParameterSubstitutions bindings) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Type getSpecializedType(@NonNull Type type,
			@Nullable TemplateParameterSubstitutions substitutions) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull TupleType getTupleType(@NonNull String typeName,
			@NonNull Collection<? extends TypedElement> parts,
			@Nullable TemplateParameterSubstitutions bindings) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CompleteModel getOwnedCompleteModel() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwnedCompleteModel(CompleteModel value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull StandardLibrary getOwnedStandardLibrary() {
		return this;
	}

	@Override
	public void setOwnedStandardLibrary(StandardLibrary value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public CompleteEnvironment getOwningCompleteEnvironment() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwningCompleteEnvironment(CompleteEnvironment value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Return the map.get(key).get() entry if there is one or null if not, removing any stale
	 * entry that may be encountered.
	 */
	protected <K, V> V weakGet(@NonNull Map<K, WeakReference<V>> map, @NonNull K key) {
		WeakReference<V> ref = map.get(key);
		if (ref == null) {
			return null;
		}
		V value = ref.get();
		if (value == null) {
			map.remove(key);
		}
		return value;
	}
}
