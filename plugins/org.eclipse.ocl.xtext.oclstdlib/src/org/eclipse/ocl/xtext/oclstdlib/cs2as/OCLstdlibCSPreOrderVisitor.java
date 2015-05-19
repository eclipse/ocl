/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlib.cs2as;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.Continuations;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS;
import org.eclipse.ocl.xtext.oclstdlibcs.util.AbstractOCLstdlibCSPreOrderVisitor;

public class OCLstdlibCSPreOrderVisitor extends AbstractOCLstdlibCSPreOrderVisitor
{
	protected static class CollectionElementTypeContinuation extends SingleContinuation<LibClassCS>
	{
		public CollectionElementTypeContinuation(@NonNull CS2ASConversion context, @NonNull LibClassCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			CollectionType type = PivotUtil.getPivot(CollectionType.class, csElement);
			if (type != null) {
				TemplateSignature ownedTemplateSignature = type.getOwnedSignature();
				if (ownedTemplateSignature != null) {
					List<TemplateParameter> parameters = ownedTemplateSignature.getOwnedParameters();
					type.setElementType(parameters.size() > 0 ? parameters.get(0) : null);
				}
			}
			return null;
		}
	}

	protected static class MapTypeContinuation extends SingleContinuation<LibClassCS>
	{
		public MapTypeContinuation(@NonNull CS2ASConversion context, @NonNull LibClassCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			MapType type = PivotUtil.getPivot(MapType.class, csElement);
			if (type != null) {
				TemplateSignature ownedTemplateSignature = type.getOwnedSignature();
				if (ownedTemplateSignature != null) {
					List<TemplateParameter> parameters = ownedTemplateSignature.getOwnedParameters();
					type.setKeyType(parameters.size() > 0 ? parameters.get(0) : null);
					type.setValueType(parameters.size() > 1 ? parameters.get(1) : null);
				}
			}
			return null;
		}
	}

	public OCLstdlibCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitLibClassCS(@NonNull LibClassCS csLibClass) {
		Type type = PivotUtil.getPivot(Type.class, csLibClass);
		Continuation<?> continuation = super.visitLibClassCS(csLibClass);
		if (type instanceof CollectionType) {
			continuation = Continuations.combine(continuation,
				new CollectionElementTypeContinuation(context, csLibClass));
		}
		else if (type instanceof MapType) {
			continuation = Continuations.combine(continuation,
				new MapTypeContinuation(context, csLibClass));
		}
//		else if (type instanceof LambdaType) {
//			LambdaType lamdbaType = (LambdaType) type;
//			lamdbaType.setContextType(lamdbaType);
//			lamdbaType.setResultType(lamdbaType);
//		}
		return continuation;
	}

	@Override
	public Continuation<?> visitLibCoercionCS(@NonNull LibCoercionCS csCoercion) {
		Operation pivotCoercion = PivotUtil.getPivot(Operation.class, csCoercion);
		if (pivotCoercion != null) {
//			pivotElement.setPrecedence(csIteration.getPrecedence());
//			pivotElement.setIsStatic(csIteration.isStatic());
			JavaClassCS implementation = csCoercion.getImplementation();
			if ((implementation != null) && !implementation.eIsProxy()) {
				pivotCoercion.setImplementationClass(implementation.getName());
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitLibIterationCS(@NonNull LibIterationCS csIteration) {
		Iteration pivotIteration = PivotUtil.getPivot(Iteration.class, csIteration);
		if (pivotIteration != null) {
//			pivotElement.setPrecedence(csIteration.getPrecedence());
//			pivotElement.setIsStatic(csIteration.isStatic());
			JavaClassCS implementation = csIteration.getImplementation();
			if ((implementation != null) && !implementation.eIsProxy()) {
				pivotIteration.setImplementationClass(implementation.getName());
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitLibOperationCS(@NonNull LibOperationCS csOperation) {
		Operation pivotElement = PivotUtil.getPivot(Operation.class, csOperation);
		if (pivotElement != null) {
			Precedence precedence = csOperation.getPrecedence();
			if ((precedence != null) && precedence.eIsProxy()) {
				precedence = null;
			}
			pivotElement.setPrecedence(precedence);
			pivotElement.setIsStatic(csOperation.isIsStatic());
			JavaClassCS implementation = csOperation.getImplementation();
			if ((implementation != null) && !implementation.eIsProxy()) {
				pivotElement.setImplementationClass(implementation.getName());
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitLibPropertyCS(@NonNull LibPropertyCS csProperty) {
		Property pivotElement = PivotUtil.getPivot(Property.class, csProperty);
		if (pivotElement != null) {
			pivotElement.setIsStatic(csProperty.isIsStatic());
			JavaClassCS implementation = csProperty.getImplementation();
			if ((implementation != null) && !implementation.eIsProxy()) {
				pivotElement.setImplementationClass(implementation.getName());
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitPrecedenceCS(@NonNull PrecedenceCS csPrecedence) {
		return null;
	}
}
