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
package org.eclipse.ocl.examples.pivot.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;

public class EnumerationTypeServer extends ExtensibleTypeServer implements DomainEnumeration
{
	private Map<String, DomainEnumerationLiteral> literals = new HashMap<String, DomainEnumerationLiteral>();
	
	public EnumerationTypeServer(@NonNull PackageServer packageServer, @NonNull Enumeration type) {
		super(packageServer, type);
		int index = 0;
		EObject eTarget = type.getETarget();
		if (eTarget instanceof EEnum) {
			for (EEnumLiteral eLiteral : ((EEnum)eTarget).getELiterals()) {
				String enumerationLiteralName = DomainUtil.nonNullModel(eLiteral.getName());
				literals.put(enumerationLiteralName, new EcoreExecutorEnumerationLiteral(eLiteral, this, index++));
			}
		}
		else {
			for (EnumerationLiteral enumerationLiteral : type.getOwnedLiteral()) {
				String enumerationLiteralName = DomainUtil.nonNullModel(enumerationLiteral.getName());
				literals.put(enumerationLiteralName, new EnumeratorEnumerationLiteral(enumerationLiteralName, this, index++));
			}
		}
	}

	public @NonNull EnumerationId getEnumerationId() {
		return (EnumerationId) getTypeId();
	}

	public @Nullable DomainEnumerationLiteral getEnumerationLiteral(@NonNull String name) {
		return literals.get(name);
	}

	public @NonNull Iterable<? extends DomainEnumerationLiteral> getEnumerationLiterals() {
		@SuppressWarnings("null") @NonNull Collection<DomainEnumerationLiteral> result = literals.values();
		return result;
	}
}
