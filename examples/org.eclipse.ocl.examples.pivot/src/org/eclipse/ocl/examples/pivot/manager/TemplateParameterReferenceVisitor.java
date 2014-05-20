/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * The TemplateParameterReferenceVisitor traverse a type declaration to gather all references to TemplateParameters as a mapping
 * from each template parameter to it's hierarchical index. incrementing from 0 through the package to type to operation hierarchy,
 * and across the potential multiple template parameters of a generalization.
 */
public class TemplateParameterReferenceVisitor extends AbstractExtendingVisitor<Object, List<TemplateParameter>>
{
	public TemplateParameterReferenceVisitor(@NonNull List<TemplateParameter> context) {
		super(context);
	}

	public String visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Unsupported " + getClass().getSimpleName() + " " + visitable.getClass().getSimpleName());
	}

	@Override
	public @Nullable Object visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		TemplateParameter owningTemplateParameter = object.getOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			owningTemplateParameter.accept(this);
		}
		return super.visitClass(object);
	}

	@Override
	public @Nullable Object visitCollectionType(@NonNull CollectionType object) {
		safeVisit(object.getElementType());
		return null;
	}

	@Override
	public @Nullable Object visitLambdaType(@NonNull LambdaType object) {
		safeVisit(object.getContextType());
		safeVisit(object.getResultType());
		for (Type parameterType : object.getParameterType()) {
			safeVisit(parameterType);
		}
		return super.visitLambdaType(object);
	}

	@Override
	public @Nullable Object visitMetaclass(@NonNull Metaclass<?> object) {
		safeVisit(object.getInstanceType());
		return null;
	}

	@Override
	public @Nullable Object visitPrimitiveType(@NonNull PrimitiveType object) {
		return null;
	}

	@Override
	public @Nullable Object visitTemplateParameter(@NonNull TemplateParameter object) {
		TemplateParameterId elementId = object.getElementId();
		int index = elementId.getIndex();
		if (index < context.size()) {
			context.set(index, object);
		}
		else {
			while (context.size() < index) {
				context.add(null);
			}
			context.add(object);
		}
		return null;
	}

	@Override
	public @Nullable Object visitTupleType(@NonNull TupleType object) {
		for (Property tuplePart : object.getOwnedAttribute()) {
			safeVisit(tuplePart.getType());
		}
		return super.visitTupleType(object);
	}

	@Override
	public @Nullable Object visitType(@NonNull Type object) {
		for (TemplateBinding templateBinding : object.getTemplateBinding()) {
			for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitution()) {
				safeVisit(templateParameterSubstitution.getActual());
			}
		}
		return null;
	}
}
