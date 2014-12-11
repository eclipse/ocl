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
import org.eclipse.ocl.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.TupleType;

/**
 * A representation of the OCL Standard Library, which is the set of singleton
 * instances of the OCL-defined metatypes, including the generic collection
 * types (e.g., <tt>Set(T)</tt>).
 */
public interface DomainStandardLibrary
{
	boolean conformsToCollectionType(@NonNull DomainCollectionType firstCollectionType, @NonNull DomainCollectionType secondCollectionType);

	boolean conformsToLambdaType(@NonNull LambdaType firstLambdaType, @NonNull LambdaType secondLambdaType);

	boolean conformsToTupleType(@NonNull TupleType firstTupleType, @NonNull TupleType secondTupleType);

	@NonNull Iterable<? extends DomainCompletePackage> getAllCompletePackages();

    /**
     * Obtains the generic instance of the BagType metatype, named
     * <tt>Bag(T)</tt>.
     * 
     * @return the <tt>Bag(T)</tt> type (an instance of BagType)
     */
	@NonNull DomainClass getBagType();
	
    /**
     * Obtains the instance of the PrimitiveType metatype, named
     * <tt>Boolean</tt>.
     * 
     * @return the <tt>Boolean</tt> type (an instance of PrimitiveType)
     */
	@NonNull DomainClass getBooleanType();
	
    /**
     * Obtains the single instance of the DomainClass metatype, named
     * <tt>Class</tt>.
     * 
     * @return the <tt>Class</tt> type (an instance of Class)
     */
	@NonNull DomainClass getClassType();
	
    /**
     * Obtains the generic instance of the CollectionType metatype, named
     * <tt>Collection(T)</tt>.
     * 
     * @return the <tt>Collection(T)</tt> type (an instance of CollectionType)
     */
	@NonNull DomainClass getCollectionType();

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
	@NonNull DomainClass getEnumerationType();

	/**
	 * Return the Inheritance dispatch table for a given type.
	 */
	@NonNull DomainInheritance getInheritance(@NonNull DomainClass type);
	
    /**
     * Obtains the instance of the PrimitiveType metatype, named
     * <tt>Integer</tt>.
     * 
     * @return the <tt>Integer</tt> type (an instance of PrimitiveType)
     */
	@NonNull DomainClass getIntegerType();

	/**
	 * Return the instance of the Metaclass metatype whose class is classType.
	 */
	@NonNull DomainClass getMetaclass(@NonNull DomainType classType);

    /**
     * Returns the meta-type of a given type.
     */
	DomainType getMetaType(@NonNull DomainType type);

    org.eclipse.ocl.pivot.Package getNsURIPackage(@NonNull String nsURI);

	/**
     * Obtains the single instance of the AnyType metatype, named
     * <tt>OclAny</tt>.
     * 
     * @return the <tt>OclAny</tt> type (an instance of AnyType)
     */
	@NonNull DomainClass getOclAnyType();
	
    /**
     * Obtains the single instance of the OclComparable metatype, named
     * <tt>OclAny</tt>.
     * 
     * @return the <tt>OclAny</tt> type (an instance of Class)
     */
	@NonNull DomainClass getOclComparableType();

    /**
     * Obtains the single instance of the Class metatype, named
     * <tt>OclElement</tt>.
     * 
     * @return the <tt>OclElement</tt> type (an instance of Class)
     */
	@NonNull DomainClass getOclElementType();

	@NonNull Operation getOclInvalidOperation();
	
    /**
     * Obtains the single instance of the InvalidType metatype, named
     * <tt>OclInvalid</tt>.
     * 
     * @return the <tt>OclInvalid</tt> type (an instance of InvalidType)
     */
	@NonNull DomainClass getOclInvalidType();
	
    /**
     * Obtains the generic instance of the MessageType metatype, named
     * <tt>OclMessage</tt>.
     * 
     * @return the <tt>OclMessage</tt> type (an instance of MessageType)
     */
	@NonNull DomainClass getOclMessageType();

    /**
     * Obtains the single instance of the OclSelf pseudo-metatype, named
     * <tt>OclSelf</tt>.
     * 
     * @return the <tt>OclSelf</tt> type (an instance of SelfType)
     */
	@NonNull DomainClass getOclSelfType();
	
    /**
     * Obtains the single instance of the OclSummable metatype, named
     * <tt>OclAny</tt>.
     * 
     * @return the <tt>OclAny</tt> type (an instance of Class)
     */
	@NonNull DomainClass getOclSummableType();
	
    /**
     * Obtains the single instance of the OclTupleType metatype, named
     * <tt>OclVoid</tt>.
     * 
     * @return the <tt>OclTuple</tt> type (an instance of Class)
     */
	@NonNull DomainClass getOclTupleType();
	
	DomainType getOclType(@NonNull String typeName);
	
    /**
     * Obtains the single instance of the VoidType metatype, named
     * <tt>OclVoid</tt>.
     * 
     * @return the <tt>OclVoid</tt> type (an instance of VoidType)
     */
	@NonNull DomainClass getOclVoidType();
	
    DomainElement getOperationTemplateParameter(@NonNull Operation anOperation, int index);

	/**
     * Obtains the generic instance of the OrderedCollection metatype, named
     * <tt>OrderedCollection(T)</tt>.
     * 
     * @return the <tt>OrderedCollection(T)</tt> type (an instance of CollectionType)
     */
	@NonNull DomainClass getOrderedCollectionType();

	/**
     * Obtains the generic instance of the OrderedSetType metatype, named
     * <tt>OrderedSet(T)</tt>.
     * 
     * @return the <tt>OrderedSet(T)</tt> type (an instance of OrderedSetType)
     */
	@NonNull DomainClass getOrderedSetType();
	
    DomainType getPrimitiveType(@NonNull PrimitiveTypeId id);

	/**
     * Obtains the instance of the PrimitiveType metatype, named
     * <tt>Real</tt>.
     * 
     * @return the <tt>Real</tt> type (an instance of PrimitiveType)
     */
	@NonNull DomainClass getRealType();

	org.eclipse.ocl.pivot.Package getRootPackage(@NonNull String name);
	
    /**
     * Obtains the generic instance of the SequenceType metatype, named
     * <tt>Sequence(T)</tt>.
     * 
     * @return the <tt>Sequence(T)</tt> type (an instance of SequenceType)
     */
	@NonNull DomainClass getSequenceType();
	
    /**
     * Obtains the generic instance of the SetType metatype, named
     * <tt>Set(T)</tt>.
     * 
     * @return the <tt>Set(T)</tt> type (an instance of SetType)
     */
	@NonNull DomainClass getSetType();

    /**
     * Obtains the instance of the PrimitiveType metatype, named
     * <tt>String</tt>.
     * 
     * @return the <tt>String</tt> type (an instance of PrimitiveType)
     */
	@NonNull DomainClass getStringType();

	/**
     * Obtains the generic instance of the UniqueCollection metatype, named
     * <tt>Set(T)</tt>.
     * 
     * @return the <tt>Set(T)</tt> type (an instance of CollectionType)
     */
	@NonNull DomainClass getUniqueCollectionType();
   
    /**
     * Obtains the instance of the PrimitiveType metatype,
     * named <tt>UnlimitedNatural</tt>.
     * 
     * @return the <tt>UnlimitedNatural</tt> type (an instance of
     *     PrimitiveType)
     */
	@NonNull DomainClass getUnlimitedNaturalType();
	
	boolean isEqualToCollectionType(@NonNull DomainCollectionType firstCollectionType, @NonNull DomainCollectionType secondCollectionType);

	boolean isEqualToTupleType(@NonNull TupleType firstTupleType, @NonNull TupleType secondTupleType);
}
