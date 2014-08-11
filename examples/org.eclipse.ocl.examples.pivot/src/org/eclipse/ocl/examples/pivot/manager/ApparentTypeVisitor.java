/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * ApparentTypeVisitor computes the apparent type of operation arguments that have a 'typeof' characteristic.
 * <p>
 * The apparent type of the argument in ...->selectByKind(String)->... is therefore String rather than Class
 * enabling the subsequent return type to exploit the statically known type.
 */
public class ApparentTypeVisitor extends AbstractExtendingVisitor<Type, MetaModelManager>
{
	public static @Nullable Type getApparentType(@NonNull MetaModelManager metaModelManager, @NonNull Element element) {
		ApparentTypeVisitor visitor = null;
//		Resource eResource = element.eResource();
//		if (eResource instanceof ASResource) {
// FIXME			visitor = ((ASResource)eResource).getASResourceFactory().createApparentTypeVisitor(metaModelManager);	
//		}
//		if (visitor == null) {
			visitor = new ApparentTypeVisitor(metaModelManager);
//		}
		return element.accept(visitor);
	}

	private /*@LazyNonNull*/ Map<VariableDeclaration, Type> variable2type = null;
	
	public ApparentTypeVisitor(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
	}

	public @Nullable Type visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}

	@Override
	public @Nullable Type visitIfExp(@NonNull IfExp object) {
		Type thenType = safeVisit(object.getThenExpression());
		Type elseType = safeVisit(object.getElseExpression());
		if ((thenType == null) || (elseType == null)) {
			return null;
		}
		else {
			return context.getCommonType(thenType, TemplateParameterSubstitutions.EMPTY, elseType, TemplateParameterSubstitutions.EMPTY);
		}
	}

	@Override
	public @Nullable Type visitLetExp(@NonNull LetExp object) {
		return safeVisit(object.getIn());
	}

	@Override
	public @Nullable Type visitTypedElement(@NonNull TypedElement object) {
		return object.getType();
	}

	@Override
	public @Nullable Type visitTypeExp(@NonNull TypeExp object) {
		return object.getReferredType();
	}

	@Override
	public @Nullable Type visitVariable(@NonNull Variable object) {
		Map<VariableDeclaration, Type> variable2type2 = variable2type;
		if (variable2type2 != null) {
			Type cachedType = variable2type2.get(object);
			if (cachedType != null) {
				return cachedType;
			}
		}
		Type varType = super.visitVariable(object);
		OCLExpression initExpression = object.getInitExpression();
		if (initExpression != null) {
			Type initType = safeVisit(initExpression);
			if (initType != null) {
				if (varType == null) {
					varType = initType;
				}
				else {
					varType = context.getCommonType(varType, TemplateParameterSubstitutions.EMPTY, initType, TemplateParameterSubstitutions.EMPTY);
				}
			}
		}
		if (variable2type2 == null) {
			variable2type = variable2type2 = new HashMap<VariableDeclaration, Type>();
		}
		variable2type2.put(object, varType);
		return varType;
	}

	@Override
	public @Nullable Type visitVariableExp(@NonNull VariableExp object) {
		return safeVisit(object.getReferredVariable());
	}
}
