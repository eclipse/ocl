/*******************************************************************************
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.services;

import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;

public class BaseQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider
{
	protected String name(NamedElement namdElement) {
		return namdElement.getName();
	}
}
