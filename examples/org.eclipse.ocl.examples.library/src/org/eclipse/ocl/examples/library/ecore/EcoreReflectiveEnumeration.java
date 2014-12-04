/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.ecore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;

public class EcoreReflectiveEnumeration extends EcoreReflectiveType implements DomainEnumeration
{
	private /*@LazyNonNull*/ Map<String, DomainEnumerationLiteral> name2literal = null;

	public EcoreReflectiveEnumeration(@NonNull EcoreReflectivePackage evaluationPackage, int flags, @NonNull EEnum eEnum, @NonNull DomainTemplateParameter... typeParameters) {
		super(evaluationPackage, flags, eEnum, typeParameters);
	}

	@Override
	public @Nullable DomainEnumerationLiteral getEnumerationLiteral(@NonNull String name) {
		if (name2literal == null) {
			name2literal = initLiterals();
		}
		return name2literal.get(name);
	}
	
	@Override
	public @NonNull EnumerationId getEnumerationId() {
		return (EnumerationId) getTypeId();
	}

	@Override
	public @NonNull Iterable<? extends DomainEnumerationLiteral> getEnumerationLiterals() {
		if (name2literal == null) {
			name2literal = initLiterals();
		}
		@SuppressWarnings("null")@NonNull Collection<DomainEnumerationLiteral> values = name2literal.values();
		return values;
	}

	protected @NonNull Map<String, DomainEnumerationLiteral> initLiterals() {
		Map<String, DomainEnumerationLiteral> name2literal = new HashMap<String, DomainEnumerationLiteral>();
		for (EEnumLiteral eEnumLiteral : ((EEnum) eClassifier).getELiterals()) {
			DomainEnumerationLiteral enumerationLiteral = new EcoreExecutorEnumerationLiteral(eEnumLiteral, this, eEnumLiteral.getValue());
			name2literal.put(eEnumLiteral.getName(), enumerationLiteral);
		}
		return name2literal;
	}
}
