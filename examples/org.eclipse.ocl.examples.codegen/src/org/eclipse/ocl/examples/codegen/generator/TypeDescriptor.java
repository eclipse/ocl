/*******************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.generator;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.JavaStream.SubStream;
import org.eclipse.ocl.examples.codegen.java.types.CollectionDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.UnboxedDescriptor;

/**
 * TypeDescriptor captures the characteristics of a Java type and supports serialization to a javaStream.
 * <p>
 * Derived classes support boxed/unboxed types, static/dynamic Ecore and collections.
 */
public interface TypeDescriptor
{
	/**
	 * Append the declaration of this type to a JavaStream. e.g. "typename"
	 */
	void append(@NonNull JavaStream js);

	@NonNull Boolean appendBox(@NonNull JavaStream js, @NonNull JavaLocalContext<?> localContext,
			@NonNull CGBoxExp cgBoxExp, @NonNull CGValuedElement unboxedValue);

	/**
	 * Append the actualJavaClass subStream to js wrapped in a cast to this type.g. "(typename)subStream"
	 */
	void appendCast(@NonNull JavaStream js, @Nullable Class<?> actualJavaClass, @Nullable SubStream subStream);
	
	/**
	 * Append a cgElement to js wrapped in a cast to this type
	 */
	void appendCastTerm(@NonNull JavaStream js, @NonNull CGValuedElement cgElement);

	/**
	 * Append an expression term that evaluates whether (this TypedDescriptor and) thisValue is not equal to thatTypeDescriptor and thatName.
	 */
	void appendNotEqualsTerm(@NonNull JavaStream js, @NonNull CGValuedElement thisValue, @NonNull TypeDescriptor thatTypeDescriptor, @NonNull String thatName);

	/**
	 * Append an expression term that evaluates whether (this TypedDescriptor and) thisValue is not equals/ notEquals to thatValue.
	 * <br>
	 * It is assumed that all the degenerate constant cases have been optimzed away.
	 */
	void appendEqualsValue(@NonNull JavaStream js, @NonNull CGValuedElement thisValue, @NonNull CGValuedElement thatValue, boolean notEquals);

	@NonNull Boolean appendUnboxStatements(@NonNull JavaStream js, @NonNull JavaLocalContext<?> localContext,
			@NonNull CGUnboxExp cgUnboxExp, @NonNull CGValuedElement boxedValue);

	/**
	 * Return a non-null Collection type descriptor if this type descriptor describes a Collection.
	 */
	@Nullable CollectionDescriptor asCollectionDescriptor();
	
	/**
	 * Return the fully qualified Java class name described by this type. In the case of collection types, this method returns
	 * the class name of the collection elements.
	 */
	@NonNull String getClassName();

	/**
	 * Return the Ecore EClassifier described by this type. In the case of collection types, this method returns
	 * the EClassifier of the collection elements. May return null when no EClssifier available.
	 */
	@Nullable EClassifier getEClassifier();

	/**
	 * Return the basic Java class for this descriptor. e.g. List<?> for an unboxed collection.
	 */
	@NonNull Class<?> getJavaClass();

	/**
	 * Return the type descriptor for use when a primitive type would be appropriate.
	 * Returns this when there is no distinction for primitive types.
	 */
	@NonNull TypeDescriptor getPrimitiveDescriptor();

	/**
	 * Return the type descriptor for use when an unboxed type would be appropriate.
	 * Returns this when this is an unboxed descriptor.
	 */
	@NonNull UnboxedDescriptor getUnboxedDescriptor();

	/**
	 * Return the basic Java class for this descriptor. e.g. List<?> for an unboxed collection.
	 * Returns null for no Java class known.
	 */
	@Nullable Class<?> hasJavaClass();

	/**
	 * Return true if an instance described by typeDescriptor may be assigned to an instance described by this.
	 */
	boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor);

	/**
	 * Return true if an instance described by this typeDescriptor may be assigned to a javaClass.
	 */
	boolean isAssignableTo(@NonNull Class<?> javaClass);
}