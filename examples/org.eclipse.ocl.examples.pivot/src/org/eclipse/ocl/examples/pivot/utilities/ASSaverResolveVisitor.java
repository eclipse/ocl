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
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * ResolveVisitor converts references to shared specializations
 * to references to local copies.
 */
public class ASSaverResolveVisitor extends AbstractExtendingVisitor<Object, ASSaver>
{
	public ASSaverResolveVisitor(@NonNull ASSaver saver) {
		super(saver);
	}

	@Override
	public Object visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		List<Type> superClasses = object.getSuperClass();
		for (int i = 0; i < superClasses.size(); i++) {
			Type referredClass = superClasses.get(i);
			if (referredClass != null) {
				Type resolvedClass = context.resolveType(referredClass);
				superClasses.set(i, resolvedClass);
			}
		}
		return super.visitClass(object);
	}

	@Override
	public Object visitCollectionType(@NonNull CollectionType object) {
		Type referredType = DomainUtil.nonNullModel(object.getElementType());
		Type resolvedType = context.resolveType(referredType);
		if (resolvedType != referredType) {
			object.setElementType(resolvedType);
		}
		return super.visitCollectionType(object);
	}

	@Override
	public Object visitLambdaType(@NonNull LambdaType object) {
		Type referredType = DomainUtil.nonNullModel(object.getContextType());
		Type resolvedType = context.resolveType(referredType);
		object.setContextType(resolvedType);
		referredType = DomainUtil.nonNullModel(object.getResultType());
		resolvedType = context.resolveType(referredType);
		object.setResultType(resolvedType);
		List<Type> parameterTypes = object.getParameterType();
		for (int i = 0; i < parameterTypes.size(); i++) {
			referredType = parameterTypes.get(i);
			if (referredType != null) {
				resolvedType = context.resolveType(referredType);
				parameterTypes.set(i, resolvedType);
			}
		}
		return super.visitLambdaType(object);
	}

	@Override
	public Object visitLoopExp(@NonNull LoopExp object) {
		Iteration referredIteration = DomainUtil.nonNullModel(object.getReferredIteration());
		Iteration resolvedIteration = context.resolveOperation(referredIteration);
		object.setReferredIteration(resolvedIteration);
		return super.visitLoopExp(object);
	}

	@Override
	public Object visitMetaclass(@NonNull Metaclass<?> object) {
		Type referredType = DomainUtil.nonNullModel(object.getInstanceType());
		Type resolvedType = context.resolveType(referredType);
		object.setInstanceType(resolvedType);
		return super.visitMetaclass(object);
	}

	@Override
	public Object visitOperationCallExp(@NonNull OperationCallExp object) {	// FIXME Obsolete once referredOperation is not a specialization
		Operation referredOperation = DomainUtil.nonNullModel(object.getReferredOperation());
		Operation resolvedOperation = context.resolveOperation(referredOperation);
		object.setReferredOperation(resolvedOperation);
		return super.visitOperationCallExp(object);
	}

	@Override
	public Object visitTemplateParameterSubstitution(@NonNull TemplateParameterSubstitution object) {
		Type referredType = DomainUtil.nonNullModel((Type) object.getActual());
		Type resolvedType = context.resolveType(referredType);
		object.setActual(resolvedType);
		return null;
	}

	@Override
	public Object visitTypeTemplateParameter(@NonNull TypeTemplateParameter object) {
		List<Type> constrainingTypes = object.getConstrainingType();
		for (int i = 0; i < constrainingTypes.size(); i++) {
			Type referredType = constrainingTypes.get(i);
			if (referredType != null) {
				Type resolvedType = context.resolveType(referredType);
				constrainingTypes.set(i, resolvedType);
			}
		}
		return null;
	}

	@Override
	public Object visitType(@NonNull Type object) {
		return null;
	}

	@Override
	public Object visitTypedElement(@NonNull TypedElement object) {
		Type referredType = DomainUtil.nonNullEMF(object.getType());
		Type resolvedType = context.resolveType(referredType);
		object.setType(resolvedType);
		return null;
	}

	public Object visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for PivotSaver Resolve pass");
	}
}
