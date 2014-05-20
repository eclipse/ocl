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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * LocateVisitor locates references to shared specializations, so that 
 * local copies can be created and then replaced by the ResolveVisitor.
 */
public class ASSaverLocateVisitor extends AbstractExtendingVisitor<Object, ASSaver>
{
	public ASSaverLocateVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public Object visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		for (Type superClass : object.getSuperClass()) {
			if (superClass.getTemplateBinding().size() > 0) {
				context.addSpecializingElement(object);
				break;
			}
		}
		return null;
	}

	@Override
	public Object visitCollectionType(@NonNull CollectionType object) {
		Type referredType = object.getElementType();
		if (referredType != null) {
			context.addSpecializingElement(object, referredType);
		}
		return super.visitCollectionType(object);
	}

	@Override
	public Object visitLambdaType(@NonNull LambdaType object) {
		boolean doneIt = false;
		Type referredType = object.getContextType();
		if ((referredType != null) && context.addSpecializingElement(object, referredType)) {
			doneIt = true;
		}
		if (!doneIt) {
			referredType = object.getResultType();
			if ((referredType != null) && context.addSpecializingElement(object, referredType)) {
				doneIt = true;
			}
			if (!doneIt) {
				for (Type parameterType : object.getParameterType()) {
					if ((parameterType != null) && context.addSpecializingElement(object, parameterType)) {
						break;
					}
				}
			}
		}
		return super.visitLambdaType(object);
	}

	@Override
	public Object visitLoopExp(@NonNull LoopExp object) {
		Iteration referredIteration = object.getReferredIteration();
		if (referredIteration != null) {
			context.addSpecializingElement(object, referredIteration);
		}
		return super.visitLoopExp(object);
	}

	@Override
	public Object visitOperationCallExp(@NonNull OperationCallExp object) {
		Operation referredOperation = object.getReferredOperation();
		if (referredOperation != null) {
			context.addSpecializingElement(object, referredOperation);
		}
		return super.visitOperationCallExp(object);
	}

	@Override
	public Object visitProperty(@NonNull Property object) {
		Property opposite = object.getOpposite();
		if (opposite != null) {
			Resource eResource = opposite.eResource();
			assert eResource != null;
		}
		return super.visitProperty(object);
	}

	@Override
	public Object visitTemplateParameterSubstitution(@NonNull TemplateParameterSubstitution object) {
		ParameterableElement actual = object.getActual();
		if (actual instanceof Type) {
			context.addSpecializingElement(object, (Type) actual);
		}
		return null;
	}

	@Override
	public Object visitTypedElement(@NonNull TypedElement object) {
		Type referredType = object.getType();
		if (referredType != null) {
			context.addSpecializingElement(object, referredType);
		}
		return null;
	}

	@Override
	public Object visitTypeTemplateParameter(@NonNull TypeTemplateParameter object) {
		for (Type constrainingType : object.getConstrainingType()) {
			if ((constrainingType != null) && context.addSpecializingElement(object, constrainingType)) {
				break;
			}
		}
		return null;
	}

	public Object visiting(@NonNull Visitable visitable) {
		return null;
	}
}
