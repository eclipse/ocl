/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A ComposedEValidator supports validation over a list of EValidators, validation terminating prematurely at
 * the first child EValidator that returns false.
 * <p>
 * A ComposedEValidator may be installed to displace an EValidator.Registry.INSTANCE. This in itself is
 * harmless but since the EValidator.Registry.INSTANCE is global, any additional EValidators added to the
 * ComposedEValidator should restrict theior activitioers to ResourceSets in which they are required.
 */
public class ComposedEValidator implements EValidator
{
	/**
	 * Install a ComposedEValidator for ePackage displacing the prevailing EValidator.Registry.INSTANCE
	 * entry and adding it as the first ComposedEValidator child.
	 */
	public static synchronized @NonNull ComposedEValidator install(@NonNull EPackage ePackage) {
		Registry eValidatorRegistry = EValidator.Registry.INSTANCE;
		synchronized (eValidatorRegistry) {
			Object oldEValidator = eValidatorRegistry.get(ePackage);
			if (oldEValidator instanceof ComposedEValidator) {
				return (ComposedEValidator) oldEValidator;
			}
			if (oldEValidator instanceof EValidator.Descriptor) {
				oldEValidator = ((EValidator.Descriptor)oldEValidator).getEValidator();
			}
			ComposedEValidator newEValidator = new ComposedEValidator((EValidator) oldEValidator);
			eValidatorRegistry.put(ePackage, newEValidator);
			return newEValidator;
		}
	}

	protected final @NonNull List<EValidator> eValidators = new ArrayList<EValidator>();

	public ComposedEValidator(@Nullable EValidator eValidator) {
		if (eValidator != null) {
			eValidators.add(eValidator);
		}
	}

	/**
	 * Add a child EValidator, suppressing null and duplicates.
	 */
	public void addChild(@Nullable EValidator eValidator) {
		if (eValidator != null) {
			synchronized (this) {
				if (!eValidators.contains(eValidator)) {
					eValidators.add(eValidator);
				}
			}
		}
	}

	public @NonNull List<EValidator> getChildren() {
		return eValidators;
	}

	public boolean removeChild(@Nullable EValidator eValidator) {
		return eValidators.remove(eValidator);
	}

	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		for (EValidator eValidator : eValidators) {
			if (!eValidator.validate(eObject, diagnostics, context)) {
				return false;
			}
		}
		return true;
	}

	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		for (EValidator eValidator : eValidators) {
			if (!eValidator.validate(eClass, eObject, diagnostics, context)) {
				return false;
			}
		}
		return true;
	}

	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		for (EValidator eValidator : eValidators) {
			if (!eValidator.validate(eDataType, value, diagnostics, context)) {
				return false;
			}
		}
		return true;
	}
}
