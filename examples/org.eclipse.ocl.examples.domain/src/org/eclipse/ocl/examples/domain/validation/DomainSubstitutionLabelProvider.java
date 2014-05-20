/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.validation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EValidator.SubstitutionLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * A DomainSubstitutionLabelProvider provides readable names for EObjects. 
 */
public class DomainSubstitutionLabelProvider implements SubstitutionLabelProvider
{
	public static DomainSubstitutionLabelProvider INSTANCE = new DomainSubstitutionLabelProvider();
	
	/**
	 * Return a context map for use by EValidator.validate in which the EVlaidator.class key
	 * is mapped to the eValidator, and the EValidator.SubstitutionLabelProvider.class key
	 * is mapped to a DomainSubstitutionLabelProvider.
	 */
	public static @NonNull Map<Object, Object> createDefaultContext(EValidator eValidator) {
		Map<Object, Object> context = new HashMap<Object, Object>();
		context.put(EValidator.SubstitutionLabelProvider.class, INSTANCE);
		context.put(EValidator.class, eValidator);
		return context;
	}
	
	public String getObjectLabel(EObject eObject) {
		return DomainUtil.getLabel(eObject);
	}

	public String getFeatureLabel(EStructuralFeature eStructuralFeature) {
		return DomainUtil.getLabel(eStructuralFeature);
	}

	public String getValueLabel(EDataType eDataType, Object value) {
		return DomainUtil.getLabel(eDataType, value, null);
	}
}
