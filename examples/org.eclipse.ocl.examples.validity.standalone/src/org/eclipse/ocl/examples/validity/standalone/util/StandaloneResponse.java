/**
 * <copyright>
 *
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.validity.standalone.util;

/**
 * A representation of the literals of the enumeration '<em><b>StandaloneResponse</b></em>',
 * and utility methods for working with them.
 */
public enum StandaloneResponse {
	/**
	 * The '<em><b>HELP</b></em>' literal object.
	 */
	HELP("help"), //$NON-NLS-1$
	/**
	 * The '<em><b>EXIT</b></em>' literal object.
	 */
	EXIT("exit"), //$NON-NLS-1$
	/**
	 * The '<em><b>VALIDATE</b></em>' literal object.
	 */
	VALIDATE("validate"); //$NON-NLS-1$

	private String label;

	StandaloneResponse(String responseLabel) {
		label = responseLabel;
	}

	public String getLabel() {
		return label;
	}
}
