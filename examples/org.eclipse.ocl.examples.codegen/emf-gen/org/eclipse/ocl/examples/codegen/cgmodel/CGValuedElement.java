/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.cgmodel;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;




/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Valued Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getDependsOn <em>Depends On</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement()
 * @model abstract="true"
 * @generated
 */
public interface CGValuedElement extends CGTypedElement {

	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The elements that must be declared before this element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_DependsOn()
	 * @model resolveProxies="false"
	 * @generated
	 */
	List<CGValuedElement> getDependsOn();

	/**
	 * Return the value to which this valuedElement delegates to obtain its value.
	 * Returns this if no delegation occurs.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$3
	@NonNull CGValuedElement getReferredValuedElement();

	/**
	 * Return the value of this element.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$4
	@NonNull CGValuedElement getValue();

	/**
	 * Return the declared name value of this element. The text is valid for use in the target language and
	 * unique within the context in which this element is declared.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$5
	@Nullable String getValueName();

	/**
	 * Return true if this value is a boxed value.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$6
	boolean isBoxed();

	/**
	 * Returns true if any exception associated with this value has been caught and consequently the value may be an InvalidValueException.
	 * Returns true if any exception has been thrown.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$7
	boolean isCaught();

	/**
	 * Return true if this value can be shared as part of a Common Subexpression.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.modelspecs.CGValuedElementModelSpec$8
	boolean isCommonable();

	/**
	 * Return true if this value is a local constant (dependent of the user type system).
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$8
	boolean isConstant();

	/**
	 * Return true if this value is false.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$9
	boolean isFalse();

	/**
	 * Return true if this value is a global constant (independent of the user type system).
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$10
	boolean isGlobal();

	/**
	 * Return true if this value can be inlined as an expression term.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$11
	boolean isInlineable();

	/**
	 * Return true if this value is false.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$12
	boolean isInvalid();

	/**
	 * Return true if this value is false.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$13
	boolean isNonInvalid();

	/**
	 * Return true if this value is not null.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$14
	boolean isNonNull();

	/**
	 * Return true if this value is null.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$15
	boolean isNull();

	/**
	 * Return true if this value can be inlined as an expression term.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$17
	boolean isSettable();

	/**
	 * Return true if this value is true.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$18
	boolean isTrue();

	/**
	 * Return true if this value is an unboxed value.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$19
	boolean isUnboxed();

	/**
	 * Set the caught status.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$20
	void setCaught(boolean isCaught);

	/**
	 * Set the name of the value.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$23
	void setValueName(@NonNull String valueName);
} // CGValuedElement
