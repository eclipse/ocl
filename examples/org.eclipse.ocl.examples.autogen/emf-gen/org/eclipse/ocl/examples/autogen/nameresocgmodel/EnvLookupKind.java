/**
 * <copyright>
 * 
 * Copyright (c) 2014 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	 Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.autogen.nameresocgmodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Env Lookup Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage#getEnvLookupKind()
 * @model
 * @generated
 */
public enum EnvLookupKind implements Enumerator {
	/**
	 * The '<em><b>Lookup Only Local</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOOKUP_ONLY_LOCAL_VALUE
	 * @generated
	 * @ordered
	 */
	LOOKUP_ONLY_LOCAL(0, "LookupOnlyLocal", "LookupOnlyLocal"), /**
	 * The '<em><b>Lookup In Parent If Not Complete</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOOKUP_IN_PARENT_IF_NOT_COMPLETE_VALUE
	 * @generated
	 * @ordered
	 */
	LOOKUP_IN_PARENT_IF_NOT_COMPLETE(1, "LookupInParentIfNotComplete", "LookupInParentIfNotComplete"), /**
	 * The '<em><b>Lookup In Parent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOOKUP_IN_PARENT_VALUE
	 * @generated
	 * @ordered
	 */
	LOOKUP_IN_PARENT(2, "LookupInParent", "LookupInParent");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * The '<em><b>Lookup Only Local</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lookup Only Local</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOOKUP_ONLY_LOCAL
	 * @model name="LookupOnlyLocal"
	 * @generated
	 * @ordered
	 */
	public static final int LOOKUP_ONLY_LOCAL_VALUE = 0;

	/**
	 * The '<em><b>Lookup In Parent If Not Complete</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lookup In Parent If Not Complete</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOOKUP_IN_PARENT_IF_NOT_COMPLETE
	 * @model name="LookupInParentIfNotComplete"
	 * @generated
	 * @ordered
	 */
	public static final int LOOKUP_IN_PARENT_IF_NOT_COMPLETE_VALUE = 1;

	/**
	 * The '<em><b>Lookup In Parent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lookup In Parent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOOKUP_IN_PARENT
	 * @model name="LookupInParent"
	 * @generated
	 * @ordered
	 */
	public static final int LOOKUP_IN_PARENT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Env Lookup Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EnvLookupKind[] VALUES_ARRAY =
		new EnvLookupKind[] {
			LOOKUP_ONLY_LOCAL,
			LOOKUP_IN_PARENT_IF_NOT_COMPLETE,
			LOOKUP_IN_PARENT,
		};

	/**
	 * A public read-only list of all the '<em><b>Env Lookup Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EnvLookupKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Env Lookup Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnvLookupKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnvLookupKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Env Lookup Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnvLookupKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnvLookupKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Env Lookup Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnvLookupKind get(int value) {
		switch (value) {
			case LOOKUP_ONLY_LOCAL_VALUE: return LOOKUP_ONLY_LOCAL;
			case LOOKUP_IN_PARENT_IF_NOT_COMPLETE_VALUE: return LOOKUP_IN_PARENT_IF_NOT_COMPLETE;
			case LOOKUP_IN_PARENT_VALUE: return LOOKUP_IN_PARENT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EnvLookupKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //EnvLookupKind
