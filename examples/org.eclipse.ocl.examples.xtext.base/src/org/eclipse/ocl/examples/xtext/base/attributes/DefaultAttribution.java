/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.attributes;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;

/**
 * Scopes that are accidentally empty; a debugging aid.
 */
public class DefaultAttribution extends AbstractAttribution
{
	private static final Logger logger = Logger.getLogger(DefaultAttribution.class);

	public DefaultAttribution(EObject eObject) {
		logger.warn("Using DefaultAttribution for '" + eObject.eClass().getName() + "'");
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}
}
