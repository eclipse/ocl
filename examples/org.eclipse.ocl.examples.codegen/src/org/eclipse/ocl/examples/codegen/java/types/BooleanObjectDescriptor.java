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
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;

/**
 * A BooleanObjectDescriptor describes the Boolean type and any associated irregular code generation patterns.
 */
public class BooleanObjectDescriptor extends SimpleValueDescriptor implements SimpleDescriptor
{
	protected final @NonNull BooleanPrimitiveDescriptor primitiveTypeDescriptor;
	
	public BooleanObjectDescriptor(@NonNull ElementId elementId) {
		super(elementId, Boolean.class);
		primitiveTypeDescriptor = new BooleanPrimitiveDescriptor(elementId);
	}

	@Override
	public void appendNotEqualsTerm(@NonNull JavaStream js, @NonNull CGValuedElement thisValue, @NonNull TypeDescriptor thatTypeDescriptor, @NonNull String thatName) {
		if (thatTypeDescriptor instanceof BooleanPrimitiveDescriptor) {
			js.append("(");
			js.appendValueName(thisValue);
			js.append(" == null) || (");
			js.appendValueName(thisValue);
			js.append(" != ");
			js.append(thatName);
			js.append(")");
		}
		else {
			js.appendValueName(thisValue);
			js.append(" != ");
			js.append(thatName);
		}
	}

	@Override
	public void appendEqualsValue(@NonNull JavaStream js, @NonNull CGValuedElement thisValue,
			@NonNull CGValuedElement thatValue, boolean notEquals) {
		super.appendEqualsValue(js, thisValue, thatValue, notEquals);
	}

	@Override
	public @NonNull TypeDescriptor getPrimitiveDescriptor() {
		return primitiveTypeDescriptor;
	}
}