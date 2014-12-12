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
package org.eclipse.ocl.domain.elements;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;

/**
 * A representation of the OCL Standard Library, which is the set of singleton
 * instances of the OCL-defined metatypes, including the generic collection
 * types (e.g., <tt>Set(T)</tt>).
 */
public interface DomainStandardLibrary
{
	boolean conformsToCollectionType(@NonNull CollectionType firstCollectionType, @NonNull CollectionType secondCollectionType);

	boolean conformsToLambdaType(@NonNull LambdaType firstLambdaType, @NonNull LambdaType secondLambdaType);

	boolean conformsToTupleType(@NonNull TupleType firstTupleType, @NonNull TupleType secondTupleType);

	@NonNull Iterable<? extends CompletePackage> getAllCompletePackages();

    /**
     * Obtains the generic instance of the BagType metatype, named
     * <tt>Bag(T)</tt>.
     * 
     * @return the <tt>Bag(T)</tt> type (an instance of BagType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getBagType();
	
    /**
     * Obtains the instance of the PrimitiveType metatype, named
     * <tt>Boolean</tt>.
     * 
     * @return the <tt>Boolean</tt> type (an instance of PrimitiveType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getBooleanType();
	
    /**
     * Obtains the single instance of the org.eclipse.ocl.pivot.Class metatype, named
     * <tt>Class</tt>.
     * 
     * @return the <tt>Class</tt> type (an instance of Class)
     */
	@NonNull org.eclipse.ocl.pivot.Class getClassType();
	
    /**
     * Obtains the generic instance of the CollectionType metatype, named
     * <tt>Collection(T)</tt>.
     * 
     * @return the <tt>Collection(T)</tt> type (an instance of CollectionType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getCollectionType();

	@NonNull CollectionType getCollectionType(@NonNull org.eclipse.ocl.pivot.Class containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);

	/**
	 * Return the enumeration for a given enumerator.
	 */
	Enumeration getEnumeration(@NonNull Enumerator enumerator);
	
    /**
     * Obtains the single instance of the EnumerationType metatype, named
     * <tt>Enumeration</tt>.
     * 
     * @return the <tt>Enumeration</tt> type (an instance of Enumeration)
     */
	@NonNull org.eclipse.ocl.pivot.Class getEnumerationType();

	/**
	 * Return the Inheritance dispatch table for a given type.
	 */
	@NonNull DomainInheritance getInheritance(@NonNull org.eclipse.ocl.pivot.Class type);
	
    /**
     * Obtains the instance of the PrimitiveType metatype, named
     * <tt>Integer</tt>.
     * 
     * @return the <tt>Integer</tt> type (an instance of PrimitiveType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getIntegerType();

	/**
	 * Return the instance of the Metaclass metatype whose class is classType.
	 */
	@NonNull org.eclipse.ocl.pivot.Class getMetaclass(@NonNull Type classType);

    /**
     * Returns the meta-type of a given type.
     */
	Type getMetaType(@NonNull Type type);

    org.eclipse.ocl.pivot.Package getNsURIPackage(@NonNull String nsURI);

	/**
     * Obtains the single instance of the AnyType metatype, named
     * <tt>OclAny</tt>.
     * 
     * @return the <tt>OclAny</tt> type (an instance of AnyType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getOclAnyType();
	
    /**
     * Obtains the single instance of the OclComparable metatype, named
     * <tt>OclAny</tt>.
     * 
     * @return the <tt>OclAny</tt> type (an instance of Class)
     */
	@NonNull org.eclipse.ocl.pivot.Class getOclComparableType();

    /**
     * Obtains the single instance of the Class metatype, named
     * <tt>OclElement</tt>.
     * 
     * @return the <tt>OclElement</tt> type (an instance of Class)
     */
	@NonNull org.eclipse.ocl.pivot.Class getOclElementType();

	@NonNull Operation getOclInvalidOperation();
	
    /**
     * Obtains the single instance of the InvalidType metatype, named
     * <tt>OclInvalid</tt>.
     * 
     * @return the <tt>OclInvalid</tt> type (an instance of InvalidType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getOclInvalidType();
	
    /**
     * Obtains the generic instance of the MessageType metatype, named
     * <tt>OclMessage</tt>.
     * 
     * @return the <tt>OclMessage</tt> type (an instance of MessageType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getOclMessageType();

    /**
     * Obtains the single instance of the OclSelf pseudo-metatype, named
     * <tt>OclSelf</tt>.
     * 
     * @return the <tt>OclSelf</tt> type (an instance of SelfType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getOclSelfType();
	
    /**
     * Obtains the single instance of the OclSummable metatype, named
     * <tt>OclAny</tt>.
     * 
     * @return the <tt>OclAny</tt> type (an instance of Class)
     */
	@NonNull org.eclipse.ocl.pivot.Class getOclSummableType();
	
    /**
     * Obtains the single instance of the OclTupleType metatype, named
     * <tt>OclVoid</tt>.
     * 
     * @return the <tt>OclTuple</tt> type (an instance of Class)
     */
	@NonNull org.eclipse.ocl.pivot.Class getOclTupleType();
	
	Type getOclType(@NonNull String typeName);
	
    /**
     * Obtains the single instance of the VoidType metatype, named
     * <tt>OclVoid</tt>.
     * 
     * @return the <tt>OclVoid</tt> type (an instance of VoidType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getOclVoidType();
	
    DomainElement getOperationTemplateParameter(@NonNull Operation anOperation, int index);

	/**
     * Obtains the generic instance of the OrderedCollection metatype, named
     * <tt>OrderedCollection(T)</tt>.
     * 
     * @return the <tt>OrderedCollection(T)</tt> type (an instance of CollectionType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getOrderedCollectionType();

	/**
     * Obtains the generic instance of the OrderedSetType metatype, named
     * <tt>OrderedSet(T)</tt>.
     * 
     * @return the <tt>OrderedSet(T)</tt> type (an instance of OrderedSetType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getOrderedSetType();
	
    Type getPrimitiveType(@NonNull PrimitiveTypeId id);

	/**
     * Obtains the instance of the PrimitiveType metatype, named
     * <tt>Real</tt>.
     * 
     * @return the <tt>Real</tt> type (an instance of PrimitiveType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getRealType();

	org.eclipse.ocl.pivot.Package getRootPackage(@NonNull String name);
	
    /**
     * Obtains the generic instance of the SequenceType metatype, named
     * <tt>Sequence(T)</tt>.
     * 
     * @return the <tt>Sequence(T)</tt> type (an instance of SequenceType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getSequenceType();
	
    /**
     * Obtains the generic instance of the SetType metatype, named
     * <tt>Set(T)</tt>.
     * 
     * @return the <tt>Set(T)</tt> type (an instance of SetType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getSetType();

    /**
     * Obtains the instance of the PrimitiveType metatype, named
     * <tt>String</tt>.
     * 
     * @return the <tt>String</tt> type (an instance of PrimitiveType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getStringType();

	/**
     * Obtains the generic instance of the UniqueCollection metatype, named
     * <tt>Set(T)</tt>.
     * 
     * @return the <tt>Set(T)</tt> type (an instance of CollectionType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getUniqueCollectionType();
   
    /**
     * Obtains the instance of the PrimitiveType metatype,
     * named <tt>UnlimitedNatural</tt>.
     * 
     * @return the <tt>UnlimitedNatural</tt> type (an instance of
     *     PrimitiveType)
     */
	@NonNull org.eclipse.ocl.pivot.Class getUnlimitedNaturalType();
	
	boolean isEqualToCollectionType(@NonNull CollectionType firstCollectionType, @NonNull CollectionType secondCollectionType);

	boolean isEqualToTupleType(@NonNull TupleType firstTupleType, @NonNull TupleType secondTupleType);
}
