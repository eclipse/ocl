/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.IteratorExp#getOwnedPattern <em>Owned Pattern</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getIteratorExp()
 * @generated
 */
public interface IteratorExp extends LoopExp, ReferringElement
{

	/**
	 * Returns the value of the '<em><b>Owned Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Pattern</em>' containment reference.
	 * @see #setOwnedPattern(PatternExp)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getIteratorExp_OwnedPattern()
	 * @generated
	 */
	PatternExp getOwnedPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.IteratorExp#getOwnedPattern <em>Owned Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Pattern</em>' containment reference.
	 * @see #getOwnedPattern()
	 * @generated
	 */
	void setOwnedPattern(PatternExp value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateClosureBodyTypeIsConformanttoIteratorType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateSortedByIteratorTypeIsComparable(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Safe navigation is necessary when an iterator cannot be null and the source collection is not null-free.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateUnsafeSourceCanNotBeNull(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is exactly one iterator.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateAnyHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type is the same as the source element type
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateAnyTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the body must be Boolean.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateAnyBodyTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is exactly one iterator.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateClosureHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The collection type for an OrderedSet or a Sequence source type is OrderedSet.
	 * For any other source the collection type is Set.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateClosureTypeIsUniqueCollection(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element type is the flattened type of the body elements.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateCollectElementTypeIsFlattenedBodyType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source element type is the same as type of the body elements or element.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateClosureSourceElementTypeIsBodyElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element type is the same as the source element type.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateClosureElementTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The collection type for an OrderedSet or a Sequence type is a Sequence,
	 * the result type for any other collection type is a Bag.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateCollectTypeIsUnordered(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The collection type for an OrderedSet or a Sequence type is a Sequence, the result type for any other collection type is Bag.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateSortedByIsOrderedIfSourceIsOrdered(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element type is the type of the body elements.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateSortedByElementTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of each iterator variable must be the type of the elements of the source collection.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateIteratorTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Safe navigation is not necessary when an iterator can be null.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateSafeIteratorIsRequired(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Safe navigation is not necessary when the source collection is null-free.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	boolean validateSafeSourceCanBeNull(DiagnosticChain diagnostics, Map<Object, Object> context);
} // IteratorExp
