/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.library.executor.ExecutorEnumerationLiteral;

/**
 * An EnumeratorEnumerationLiteral is used as the unboxed representation when no Ecore Enumerator is avaialble. This occurs for
 * UML-originated EnumersationLiterals.
 */
public class EnumeratorEnumerationLiteral extends ExecutorEnumerationLiteral implements Enumerator
{
	public EnumeratorEnumerationLiteral(@NonNull String enumerationLiteralName, @NonNull EnumerationTypeServer enumerationTypeServer, int ordinal) {
		super(enumerationLiteralName, enumerationTypeServer, ordinal);
	}

	public @NonNull Enumerator getEnumerator() {
		return this;
	}

	public String getLiteral() {
		return name;
	}

	public int getValue() {
		return ordinal;
	}

}
