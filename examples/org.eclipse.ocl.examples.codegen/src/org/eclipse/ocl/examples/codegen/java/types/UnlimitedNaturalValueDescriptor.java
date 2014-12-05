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
import org.eclipse.ocl.domain.ids.ElementId;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.codegen.java.JavaStream;

/**
 * An UnlimitedNaturalValueDescriptor describes the boxed unbounded polymorphic representation of an OCL UnlimitedNatural.
 */
public class UnlimitedNaturalValueDescriptor extends BoxedValueDescriptor
{
	public UnlimitedNaturalValueDescriptor(@NonNull ElementId elementId) {
		super(elementId, IntegerValue.class, new UnlimitedNaturalObjectDescriptor(elementId));
	}

	@Override
	public @NonNull Boolean appendUnboxStatements(@NonNull JavaStream js, @NonNull JavaLocalContext<?> localContext,
			@NonNull CGUnboxExp cgUnboxExp, @NonNull CGValuedElement boxedValue) {
		js.appendDeclaration(cgUnboxExp);
		js.append(" = ");
		js.appendValueName(boxedValue);
		js.append(".asNumber();\n");
		return true;
	}
}