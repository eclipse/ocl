/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.types.IdResolver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * @extends org.eclipse.ocl.domain.values.OCLValue
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type is a named element that is used as the type for a typed element. A type can be contained in a package.
 * Type is defined to be a kind of templateable element so that a type can be parameterized. It is also defined to be a kind of parameterable element so that a type can be a formal template parameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Type#getExtendedBys <em>Extended Bys</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getType()
 * @generated
 */
public interface Type extends NamedElement, org.eclipse.ocl.domain.values.OCLValue {

	/**
	 * Returns the value of the '<em><b>Extended Bys</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.TypeExtension}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.TypeExtension#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Bys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Bys</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getType_ExtendedBys()
	 * @see org.eclipse.ocl.pivot.TypeExtension#getType
	 * @generated
	 */
	List<TypeExtension> getExtendedBys();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Type flattenedType();

	@Nullable org.eclipse.ocl.pivot.Class isClass();

	@Nullable TemplateParameter isTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Type specializeIn(OCLExpression expr, Type selfType);
	
	/**
	 * Return true if this type conform to thatType within standardLibrary.
	 */
	boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type thatType);
	
	/**
	 * Return the most derived type common to this type and thatType within standardLibrary.
	 */
	@NonNull Type getCommonType(@NonNull IdResolver idResolver, @NonNull Type thatType);

	/**
	 * Return the inheritance description for this type within standardLibrary.
	 */
	@NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary);
	
	/**
	 * Return the unique executable form of this type within standardLibrary.
	 */
	@NonNull org.eclipse.ocl.pivot.Class getNormalizedType(@NonNull StandardLibrary standardLibrary);

	/**
	 * Return a unique StandardLibrary-independent identifier for this type.
	 */
	@NonNull TypeId getTypeId();
	
	/**
	 * Return true if this is the same type as thatType within standardLibrary.
	 */
	boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type thatType);
	boolean isEqualToUnspecializedType(@NonNull StandardLibrary standardLibrary, @NonNull Type type);
	
	/**
	 * Return true if this is an invalid type (with an associated error message).
	 */
//	boolean isInvalid();

	@NonNull Type specializeIn(@NonNull CallExp expr, @Nullable Type selfType);
} // Type
