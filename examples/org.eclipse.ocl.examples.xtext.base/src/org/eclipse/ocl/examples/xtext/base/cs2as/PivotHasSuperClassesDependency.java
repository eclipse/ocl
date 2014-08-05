/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.cs2as;

import java.util.List;

import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;

public class PivotHasSuperClassesDependency extends AbstractDependency<TypedTypeRefCS>
{
	public PivotHasSuperClassesDependency(TypedTypeRefCS csElement) {
		super(csElement);
	}

	@Override
	public boolean canExecute() {
		Type pivot = element.getType();
		if (pivot == null) {
			return false;
		}
		Type type = PivotUtil.getUnspecializedTemplateableElement(pivot);
		assert type == pivot;		// WIP
		if (type instanceof AnyType) {
			return true;
		}
		if ((type instanceof DataType) && !(type instanceof CollectionType) && !(type instanceof Metaclass)) {
			return true;
		}
		if (type instanceof InvalidType) {
			return true;
		}
		if (type instanceof UnspecifiedType) {
			return true;
		}
		if (type instanceof VoidType) {
			return true;
		}
		if (type instanceof org.eclipse.ocl.examples.pivot.Class) {
			List<org.eclipse.ocl.examples.pivot.Class> superClasses = ((org.eclipse.ocl.examples.pivot.Class)type).getSuperClass();
			return !superClasses.isEmpty();
		}
		return false;
	}
}