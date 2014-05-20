/**
 * <copyright>
 *
 * Copyright (c) 2009, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.enumeration;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.impl.OrderedSetImpl;

/**
 * EnumerationOwnedLiteralProperty realizes the Enumeration::ownedLiteral() library property.
 */
public class EnumerationOwnedLiteralProperty extends AbstractProperty
{
	public static final @NonNull EnumerationOwnedLiteralProperty INSTANCE = new EnumerationOwnedLiteralProperty();

	public @NonNull OrderedSetValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		DomainType sourceType = asType(sourceValue);
		Set<Object> results = new OrderedSetImpl<Object>();
		for (DomainElement instance : ((DomainEnumeration)sourceType).getEnumerationLiterals()) {
			if (instance != null) {
				results.add(evaluator.getIdResolver().boxedValueOf(instance));
			}
		}
		return evaluator.getIdResolver().createOrderedSetOfAll((CollectionTypeId)returnTypeId, results);
	}
}
