/*******************************************************************************
 * Copyright (c) 2009, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.library.enumeration;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.ids.CollectionTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.AbstractProperty;
import org.eclipse.ocl.domain.values.OrderedSetValue;
import org.eclipse.ocl.domain.values.impl.OrderedSetImpl;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.Type;

/**
 * EnumerationOwnedLiteralProperty realizes the Enumeration::ownedLiteral() library property.
 */
public class EnumerationOwnedLiteralProperty extends AbstractProperty
{
	public static final @NonNull EnumerationOwnedLiteralProperty INSTANCE = new EnumerationOwnedLiteralProperty();

	@Override
	public @NonNull OrderedSetValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		Type sourceType = asType(sourceValue);
		Set<Object> results = new OrderedSetImpl<Object>();
		for (Element instance : ((Enumeration)sourceType).getOwnedLiteral()) {
			if (instance != null) {
				results.add(evaluator.getIdResolver().boxedValueOf(instance));
			}
		}
		return evaluator.getIdResolver().createOrderedSetOfAll((CollectionTypeId)returnTypeId, results);
	}
}
