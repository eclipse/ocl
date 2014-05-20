/*******************************************************************************
 * Copyright (c) 2010 Kenn Hussey and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 *   Kenn Hussey - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.interpreter.delegate;

import org.eclipse.emf.edit.ui.util.QueryDelegateTextViewer;
import org.eclipse.emf.edit.ui.util.QueryDelegateTextViewer.Factory;
import org.eclipse.swt.widgets.Composite;

/**
 * @since 3.1
 */
public class OCLQueryDelegateTextViewerFactory
		implements Factory {

	public QueryDelegateTextViewer createTextViewer(Composite parent, int styles) {
		return new OCLQueryDelegateTextViewer(parent, styles);
	}

}
