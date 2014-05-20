/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.java.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * n UnlimitedNaturalObjectDescriptor describes the unboxed representations of an OCL UnlimitedNatural.
 */
public class UnlimitedNaturalObjectDescriptor extends UnboxedValueDescriptor implements UnboxedDescriptor
{
	public UnlimitedNaturalObjectDescriptor(@NonNull ElementId elementId) {
		super(elementId, Number.class);
	}

	@Override
	public @NonNull Boolean appendBox(@NonNull JavaStream js, @NonNull JavaLocalContext localContext, @NonNull CGBoxExp cgBoxExp,@NonNull  CGValuedElement unboxedValue) {
		js.appendDeclaration(cgBoxExp);
		js.append(" = ");
		if (!unboxedValue.isNonNull()) {
			js.appendReferenceTo(unboxedValue);
			js.append(" == null ? null : ");
		}
		js.appendClassReference(ValuesUtil.class);
		js.append(".integerValueOf(");
		js.appendReferenceTo(unboxedValue);
		js.append(")");
		js.append(";\n");
		return true;
	}
}