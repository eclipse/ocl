/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.types;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.ids.CollectionTypeId;
import org.eclipse.ocl.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.domain.ids.IdVisitor;
import org.eclipse.ocl.domain.ids.OperationId;
import org.eclipse.ocl.domain.ids.PropertyId;
import org.eclipse.ocl.domain.ids.TupleTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.values.BagValue;
import org.eclipse.ocl.domain.values.CollectionValue;
import org.eclipse.ocl.domain.values.OrderedSetValue;
import org.eclipse.ocl.domain.values.SequenceValue;
import org.eclipse.ocl.domain.values.SetValue;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;

/**
 * IdResolver supports discovery/creation of rich Pivot-based objects from limited
 * descriptors such as ElementIds, or from Ecore objects or from Java objects.
 */
public interface IdResolver extends IdVisitor<Element>
{
	@Nullable Object boxedValueOf(@Nullable Object unboxedValue);
	
	@Nullable Object boxedValueOf(@NonNull Object unboxedValue, @Nullable EClassifier eClassifier);
	
	@Nullable Object boxedValueOf(@NonNull Object unboxedValue, @NonNull ETypedElement eFeature, @Nullable TypeId typeId);

	@NonNull BagValue createBagOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues);

	@NonNull BagValue createBagOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... unboxedValues);
	
	@NonNull CollectionValue createCollectionOfAll(boolean isOrdered, boolean isUnique, @NonNull TypeId elementTypeId, @NonNull Iterable<? extends Object> unboxedValues);
	
	@NonNull CollectionValue createCollectionOfAll(@NonNull CollectionTypeId collectedId, @NonNull Iterable<?> unboxedValues);

	@Nullable Object createInstance(@NonNull TypeId typeId, @NonNull String stringValue);

	@NonNull OrderedSetValue createOrderedSetOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues);

	@NonNull OrderedSetValue createOrderedSetOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... unboxedValues);

	@NonNull SequenceValue createSequenceOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues);

	@NonNull SequenceValue createSequenceOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... unboxedValues);

	@NonNull SetValue createSetOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues);

	@NonNull SetValue createSetOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... unboxedValues);

	void dispose();

	@NonNull org.eclipse.ocl.pivot.Class getClass(@NonNull TypeId typeId, @Nullable Object context);

	@NonNull Type getCollectionType(@NonNull CollectionTypeId typeId);

	@NonNull Type getDynamicTypeOf(@Nullable Object value);

	@Nullable Type getDynamicTypeOf(@NonNull Object... values);

	@Nullable Type getDynamicTypeOf(@NonNull Iterable<?> values);

	@NonNull CompleteEnvironment getEnvironment();

	@NonNull CompleteInheritance getInheritance(@NonNull EClassifier eClassifier);
	
	@NonNull org.eclipse.ocl.pivot.Class getJavaType(@NonNull Class<?> javaClass);

	@NonNull Operation getOperation(@NonNull OperationId operationId);

	@NonNull Property getProperty(@NonNull PropertyId propertyId);

	@NonNull DomainStandardLibrary getStandardLibrary();

	@NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value);

	@NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, Object... values);

	@NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values);

	@NonNull TypedElement getTuplePart(@NonNull String name, @NonNull TypeId typeId);

	@NonNull TupleType getTupleType(@NonNull TupleTypeId typeId);

	@NonNull org.eclipse.ocl.pivot.Class getType(@NonNull EClassifier eClassifier);

	@NonNull Type getType(@NonNull TypeId typeId, @Nullable Object context);

	boolean oclEquals(@Nullable Object thisValue, @Nullable Object thatValue);

	@Nullable Object unboxedValueOf(@Nullable Object boxedValue);
	
	@NonNull Enumerator unboxedValueOf(@NonNull EnumerationLiteralId enumerationLiteralId);
	
	@NonNull EList<Object> unboxedValuesOfAll(@NonNull Collection<? extends Object> boxedValues);
	
	@NonNull EList<Object> unboxedValuesOfEach(@NonNull Object... boxedValues);
}