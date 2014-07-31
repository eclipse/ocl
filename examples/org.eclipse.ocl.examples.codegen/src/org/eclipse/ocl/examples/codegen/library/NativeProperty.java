/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;

/**
 * The instance of NativeProperty supports evaluation of a property using native language facilities
 * (i.e X.nativeProperty) when code generated).
 */
public class NativeProperty extends AbstractProperty
{
	public static final @NonNull NativeProperty INSTANCE = new NativeProperty();

	public NativeProperty() {}

	@Override
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		throw new UnsupportedOperationException();	// Only evaluated in code generated form; see CG2JavaVisitor.visitCGNativePropertyCallExp
	}
}