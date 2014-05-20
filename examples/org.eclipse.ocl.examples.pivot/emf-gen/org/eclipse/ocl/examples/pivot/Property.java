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
package org.eclipse.ocl.examples.pivot;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.PropertyId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainProperty
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A property is a typed element that represents an attribute of a class.
 * Property specializes ParameterableElement to specify that a property can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getAssociationClass <em>Association Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getDefaultExpression <em>Default Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isImplicit <em>Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isID <em>Is ID</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isReadOnly <em>Is Read Only</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isResolveProxies <em>Is Resolve Proxies</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isUnsettable <em>Is Unsettable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isVolatile <em>Is Volatile</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getKeys <em>Keys</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getOwningType <em>Owning Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getRedefinedProperty <em>Redefined Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getSubsettedProperty <em>Subsetted Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty()
 * @generated
 */
public interface Property
		extends Feature, ParameterableElement, org.eclipse.ocl.examples.domain.elements.DomainProperty {

	/**
	 * Returns the value of the '<em><b>Association Class</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.AssociationClass#getUnownedAttribute <em>Unowned Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association Class</em>' reference.
	 * @see #setAssociationClass(AssociationClass)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_AssociationClass()
	 * @see org.eclipse.ocl.examples.pivot.AssociationClass#getUnownedAttribute
	 * @generated
	 */
	AssociationClass getAssociationClass();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#getAssociationClass <em>Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association Class</em>' reference.
	 * @see #getAssociationClass()
	 * @generated
	 */
	void setAssociationClass(AssociationClass value);

	/**
	 * Returns the value of the '<em><b>Is Read Only</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If isReadOnly is true, the attribute may not be written to after initialization.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Read Only</em>' attribute.
	 * @see #setIsReadOnly(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsReadOnly()
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isReadOnly <em>Is Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setIsReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A string that is evaluated to give a default value for the attribute when an object of the owning class is instantiated.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_Default()
	 * @generated
	 */
	String getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(String value);

	/**
	 * Returns the value of the '<em><b>Is Composite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If isComposite is true, the object containing the attribute is a container for the object or value contained in the attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Composite</em>' attribute.
	 * @see #setIsComposite(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsComposite()
	 * @generated
	 */
	boolean isComposite();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isComposite <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Composite</em>' attribute.
	 * @see #isComposite()
	 * @generated
	 */
	void setIsComposite(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Derived</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If isDerived is true, the value of the attribute is derived from information elsewhere.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Derived</em>' attribute.
	 * @see #setIsDerived(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsDerived()
	 * @generated
	 */
	boolean isDerived();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isDerived <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Derived</em>' attribute.
	 * @see #isDerived()
	 * @generated
	 */
	void setIsDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Two attributes attr1 and attr2 of two objects o1 and o2 (which may be the same object) may be paired with each other so that o1.attr1 refers to o2 if and only if o2.attr2 refers to o1. In such a case attr1 is the opposite of attr2 and attr2 is the opposite of attr1.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(Property)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_Opposite()
	 * @generated
	 */
	Property getOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(Property value);

	/**
	 * Returns the value of the '<em><b>Implicit</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implicit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implicit</em>' attribute.
	 * @see #setImplicit(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_Implicit()
	 * @generated
	 */
	boolean isImplicit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isImplicit <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit</em>' attribute.
	 * @see #isImplicit()
	 * @generated
	 */
	void setImplicit(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Expression</em>' containment reference.
	 * @see #setDefaultExpression(OpaqueExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_DefaultExpression()
	 * @generated
	 */
	OpaqueExpression getDefaultExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#getDefaultExpression <em>Default Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Expression</em>' containment reference.
	 * @see #getDefaultExpression()
	 * @generated
	 */
	void setDefaultExpression(OpaqueExpression value);

	/**
	 * Returns the value of the '<em><b>Is ID</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is ID</em>' attribute.
	 * @see #setIsID(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsID()
	 * @generated
	 */
	boolean isID();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isID <em>Is ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is ID</em>' attribute.
	 * @see #isID()
	 * @generated
	 */
	void setIsID(boolean value);

	/**
	 * Returns the value of the '<em><b>Keys</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_Keys()
	 * @generated
	 */
	List<Property> getKeys();

	/**
	 * Returns the value of the '<em><b>Is Resolve Proxies</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolve Proxies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Resolve Proxies</em>' attribute.
	 * @see #setIsResolveProxies(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsResolveProxies()
	 * @generated
	 */
	boolean isResolveProxies();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isResolveProxies <em>Is Resolve Proxies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Resolve Proxies</em>' attribute.
	 * @see #isResolveProxies()
	 * @generated
	 */
	void setIsResolveProxies(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Transient</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Transient</em>' attribute.
	 * @see #setIsTransient(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsTransient()
	 * @generated
	 */
	boolean isTransient();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isTransient <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Transient</em>' attribute.
	 * @see #isTransient()
	 * @generated
	 */
	void setIsTransient(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unsettable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsettable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unsettable</em>' attribute.
	 * @see #setIsUnsettable(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsUnsettable()
	 * @generated
	 */
	boolean isUnsettable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isUnsettable <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unsettable</em>' attribute.
	 * @see #isUnsettable()
	 * @generated
	 */
	void setIsUnsettable(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Volatile</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volatile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Volatile</em>' attribute.
	 * @see #setIsVolatile(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsVolatile()
	 * @generated
	 */
	boolean isVolatile();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isVolatile <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Volatile</em>' attribute.
	 * @see #isVolatile()
	 * @generated
	 */
	void setIsVolatile(boolean value);

	/**
	 * Returns the value of the '<em><b>Redefined Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefined Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redefined Property</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_RedefinedProperty()
	 * @generated
	 */
	List<Property> getRedefinedProperty();

	/**
	 * Returns the value of the '<em><b>Subsetted Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsetted Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsetted Property</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_SubsettedProperty()
	 * @generated
	 */
	List<Property> getSubsettedProperty();

	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_ReferredProperty()
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Owning Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Type#getOwnedAttribute <em>Owned Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Type</em>' container reference.
	 * @see #setOwningType(Type)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_OwningType()
	 * @see org.eclipse.ocl.examples.pivot.Type#getOwnedAttribute
	 * @generated
	 */
	Type getOwningType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#getOwningType <em>Owning Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Type</em>' container reference.
	 * @see #getOwningType()
	 * @generated
	 */
	void setOwningType(Type value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean isAttribute(Property p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleDefaultExpression(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The class that owns the property, and of which the property is an attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_Class()
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Class getClass_();

	@NonNull PropertyId getPropertyId();
} // Property
