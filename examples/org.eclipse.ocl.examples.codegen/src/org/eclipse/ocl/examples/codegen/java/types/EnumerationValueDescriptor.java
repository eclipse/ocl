/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
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
import org.eclipse.ocl.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.codegen.java.JavaStream;

public class EnumerationValueDescriptor extends BoxedValueDescriptor
{
	public EnumerationValueDescriptor(@NonNull ElementId elementId) {
		super(elementId, EnumerationLiteralId.class, new EnumerationObjectDescriptor(elementId));
	}

	@Override
	public void appendEqualsValue(@NonNull JavaStream js, @NonNull CGValuedElement thisValue,
			@NonNull CGValuedElement thatValue, boolean notEquals) {
		js.appendValueName(thisValue);
		js.append(notEquals ? " != " : " == ");
		js.appendValueName(thatValue);
	}
	
	@Override
	public @NonNull Boolean appendUnboxStatements(@NonNull JavaStream js, @NonNull JavaLocalContext<?> localContext,
			@NonNull CGUnboxExp cgUnboxExp, @NonNull CGValuedElement boxedValue) {
		js.appendDeclaration(cgUnboxExp);
		js.append(" = ");
		js.appendReferenceTo(localContext.getIdResolverVariable(cgUnboxExp));
		js.append(".unboxedValueOf(");
		js.appendValueName(boxedValue);
		js.append(");\n");
		return true;
	}
}