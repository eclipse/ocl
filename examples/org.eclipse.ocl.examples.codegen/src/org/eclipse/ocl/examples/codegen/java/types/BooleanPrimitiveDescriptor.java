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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.JavaStream.SubStream;
import org.eclipse.ocl.examples.domain.ids.ElementId;

/**
 * A BooleanPrimitiveDescriptor describes the boolean type and any associated irregular code generation patterns.
 */
public class BooleanPrimitiveDescriptor extends SimpleValueDescriptor implements SimpleDescriptor
{
	public BooleanPrimitiveDescriptor(@NonNull ElementId elementId) {
		super(elementId, boolean.class);
	}

	@Override
	public void append(@NonNull JavaStream js) {
		js.append("boolean");			// Override avoids registration of boolean as an import
	}

	@Override
	public void appendCast(@NonNull JavaStream js, @Nullable Class<?> actualJavaClass, @Nullable SubStream subStream) {
		if ((subStream != null) && (actualJavaClass == Boolean.class)) {
			subStream.append();
			js.append(".booleanValue()");
		}
		else {
			js.append("(");
			js.appendClassReference(Boolean.class);
			js.append(")");
			if (subStream != null) {
				subStream.append();
			}
		}
	}

	@Override
	public void appendNotEqualsTerm(@NonNull JavaStream js, @NonNull CGValuedElement thisValue, @NonNull TypeDescriptor thatTypeDescriptor, @NonNull String thatName) {
		if (thatTypeDescriptor instanceof BooleanPrimitiveDescriptor) {
			js.appendValueName(thisValue);
			js.append(" != ");
			js.append(thatName);
		}
		else {
			js.append("(");
			js.append(thatName);
			js.append(" == null) || (");
			js.appendValueName(thisValue);
			js.append(" != ");
			js.append(thatName);
			js.append(")");
		}
	}

	@Override
	public void appendEqualsValue(@NonNull JavaStream js, @NonNull CGValuedElement thisValue,
			@NonNull CGValuedElement thatValue, boolean notEquals) {
		js.appendValueName(thisValue);
		js.append(notEquals ? " != " : " == ");
		js.appendValueName(thatValue);
//		super.appendEqualsValue(js, thisValue, thatValue, notEquals);
	}
}