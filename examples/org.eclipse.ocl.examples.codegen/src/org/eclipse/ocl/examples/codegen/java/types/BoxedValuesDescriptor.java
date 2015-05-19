/*******************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
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
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.pivot.ids.ElementId;

/**
 * A BoxedValueDescriptor describes a type whose boxed representation differs from its unboxed representation. It has a pivot ElementId and a Java class.
 * <p>
 * Thus an IntegerValue is a TypeId.INTEGER and an org.eclipse.ocl.domain.values.IntegerValue.
 */
public class BoxedValuesDescriptor extends AbstractValueDescriptor implements BoxedDescriptor
{
	protected final @NonNull CollectionDescriptor unboxedDescriptor;
	
	public BoxedValuesDescriptor(@NonNull ElementId elementId, @NonNull Class<?> javaClass, @NonNull CollectionDescriptor unboxedDescriptor) {
		super(elementId, javaClass);
		this.unboxedDescriptor = unboxedDescriptor;
	}

	@Override
	public @NonNull Boolean appendUnboxStatements(@NonNull JavaStream js, @NonNull JavaLocalContext<?> localContext,
			@NonNull CGUnboxExp cgUnboxExp, @NonNull CGValuedElement boxedValue) {
//		if (collectionDescriptor != null) {
			js.append("final ");
//			js.appendIsRequired(true);
//			js.append(" ");
			unboxedDescriptor.append(js, true);
//			js.appendClassReference(List.class, false, unboxedTypeDescriptor.getJavaClass());
			js.append(" ");
			js.appendValueName(cgUnboxExp);
			js.append(" = ");
			js.appendValueName(boxedValue);
			js.append(".asEcoreObjects(");
			js.appendReferenceTo(localContext.getIdResolverVariable(cgUnboxExp));
			js.append(", ");
			unboxedDescriptor.appendElement(js, true);
			js.append(".class);\n");
			//
			js.append("assert ");
			js.appendValueName(cgUnboxExp);
			js.append(" != null;\n");
//		}
		return true;
	}

	@Override
	public @NonNull UnboxedDescriptor getUnboxedDescriptor() {
		return unboxedDescriptor;
	}

	@Override
	public final boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor) {
		if (!(typeDescriptor instanceof BoxedDescriptor)) {
			return false;
		}
		return javaClass.isAssignableFrom(typeDescriptor.getJavaClass());
	}
}