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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.SetValue;

/**
 * EnumerationAllInstancesOperation realises the Enumeration::allInstances() library operation.
 */
public class EnumerationAllInstancesOperation extends AbstractUnaryOperation
{
	public static final @NonNull EnumerationAllInstancesOperation INSTANCE = new EnumerationAllInstancesOperation();

	@Override
	public @NonNull SetValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		DomainType sourceType = asType(sourceVal);
		Set<Object> results = new HashSet<Object>();
		DomainEnumeration domainEnumeration = sourceType instanceof DomainEnumeration ? (DomainEnumeration)sourceType : (DomainEnumeration)((DomainMetaclass)sourceType).getInstanceType();
		for (DomainEnumerationLiteral instance : domainEnumeration.getEnumerationLiterals()) {
			if (instance != null) {
				results.add(instance.getEnumerationLiteralId());
			}
		}
		return createSetValue((CollectionTypeId)returnTypeId, results);
	}
}
