/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.ecore;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.ArrayIterable;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.osgi.util.NLS;

public class EcoreExecutorEnumeration extends EcoreExecutorType implements DomainEnumeration
{
	private EcoreExecutorEnumerationLiteral[] literals = null;

	/**
	 * Construct an executable type descriptor for a known EClassifier.
	 */
	public EcoreExecutorEnumeration(/*@NonNull*/ EEnum eEnum, @NonNull EcoreExecutorPackage evaluationPackage, int flags) {
		super(eEnum, evaluationPackage, flags);
	}

	@Override
	public @NonNull ObjectValue createInstance() {
		throw new UnsupportedOperationException();
	}

	public final @NonNull EEnum getEEnum() {
		EClassifier eClassifier2 = eClassifier;
		if (eClassifier2 == null) {
			throw new IllegalStateException(NLS.bind(EvaluatorMessages.IncompleteInitialization, this));
		}
		return (EEnum) eClassifier2;
	}

	@Override
	public @Nullable EcoreExecutorEnumerationLiteral getEnumerationLiteral(@NonNull String name) {
		for (EcoreExecutorEnumerationLiteral enumerationLiteral : literals) {
			if (name.equals(enumerationLiteral.getName())) {
				return enumerationLiteral;
			}
		}
		return null;
	}
	
	@Override
	public @NonNull EnumerationId getEnumerationId() {
		return (EnumerationId) getTypeId();
	}

	@Override
	public @NonNull Iterable<? extends DomainEnumerationLiteral> getEnumerationLiterals() {
		return new ArrayIterable<EcoreExecutorEnumerationLiteral>(literals);
	}
	
	public EcoreExecutorEnumeration initLiterals(EcoreExecutorEnumerationLiteral[] literals) {
		assert this.literals == null;
		this.literals = literals;
		return this;
	}
}
