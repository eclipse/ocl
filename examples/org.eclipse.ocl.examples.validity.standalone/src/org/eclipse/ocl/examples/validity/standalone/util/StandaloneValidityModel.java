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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.locator.ConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;

public class StandaloneValidityModel extends ValidityModel{
	public StandaloneValidityModel(ValidityManager validityManager,
			Collection<Resource> newResources) {
		super(validityManager, newResources);
	}

	@Override
	protected List<ConstraintLocator> getConstraintLocators(
			@NonNull String nsURI) {
		return StandaloneValidityManager.getConstraintLocators(nsURI);
	}
}
