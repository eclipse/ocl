/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2as;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuations;
import org.eclipse.ocl.examples.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.util.AbstractOCLstdlibCSPreOrderVisitor;
import org.eclipse.xtext.common.types.JvmType;

public class OCLstdlibCSPreOrderVisitor extends AbstractOCLstdlibCSPreOrderVisitor
{
	protected static class ClassifierInstanceTypeContinuation extends SingleContinuation<LibClassCS>
	{
		public ClassifierInstanceTypeContinuation(@NonNull CS2PivotConversion context, @NonNull LibClassCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Metaclass<?> type = PivotUtil.getPivot(Metaclass.class, csElement);
			if (type != null) {
				TemplateSignature ownedTemplateSignature = type.getOwnedTemplateSignature();
				if (ownedTemplateSignature != null) {
					List<TemplateParameter> parameters = ownedTemplateSignature.getOwnedTemplateParameters();
					type.setInstanceType(parameters.size() > 0 ? parameters.get(0) : null);
				}
			}
			return null;
		}
	}
	
	protected static class CollectionElementTypeContinuation extends SingleContinuation<LibClassCS>
	{
		public CollectionElementTypeContinuation(@NonNull CS2PivotConversion context, @NonNull LibClassCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			CollectionType type = PivotUtil.getPivot(CollectionType.class, csElement);
			if (type != null) {
				TemplateSignature ownedTemplateSignature = type.getOwnedTemplateSignature();
				if (ownedTemplateSignature != null) {
					List<TemplateParameter> parameters = ownedTemplateSignature.getOwnedTemplateParameters();
					type.setElementType(parameters.size() > 0 ? parameters.get(0) : null);
				}
			}
			return null;
		}
	}
	
	protected static class LibIterationContinuation extends SingleContinuation<LibIterationCS>
	{
		public LibIterationContinuation(@NonNull CS2PivotConversion context, @NonNull LibIterationCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Iteration pivotIteration = PivotUtil.getPivot(Iteration.class, csElement);
			if (pivotIteration != null) {
//				pivotElement.setPrecedence(csIteration.getPrecedence());
//				pivotElement.setIsStatic(csIteration.isStatic());
				JvmType implementation = csElement.getImplementation();
				if ((implementation != null) && !implementation.eIsProxy()) {
					pivotIteration.setImplementationClass(implementation.getIdentifier());
				}
			}
			return null;
		}
	}
	
	protected static class LibOperationContinuation extends SingleContinuation<LibOperationCS>
	{
		public LibOperationContinuation(@NonNull CS2PivotConversion context, @NonNull LibOperationCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Operation pivotElement = PivotUtil.getPivot(Operation.class, csElement);
			if (pivotElement != null) {
				Precedence precedence = csElement.getPrecedence();
				if ((precedence != null) && precedence.eIsProxy()) {
					precedence = null;
				}
				pivotElement.setPrecedence(precedence);
				pivotElement.setIsStatic(csElement.isStatic());
				JvmType implementation = csElement.getImplementation();
				if ((implementation != null) && !implementation.eIsProxy()) {
					pivotElement.setImplementationClass(implementation.getIdentifier());
				}
			}
			return null;
		}
	}
	
	protected static class LibPropertyContinuation extends SingleContinuation<LibPropertyCS>
	{
		public LibPropertyContinuation(@NonNull CS2PivotConversion context, @NonNull LibPropertyCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Property pivotElement = PivotUtil.getPivot(Property.class, csElement);
			if (pivotElement != null) {
				pivotElement.setIsStatic(csElement.isStatic());
				JvmType implementation = csElement.getImplementation();
				if ((implementation != null) && !implementation.eIsProxy()) {
					pivotElement.setImplementationClass(implementation.getIdentifier());
				}
			}
			return null;
		}
	}

	protected static class LibraryPrecedenceContinuation extends SingleContinuation<LibPackageCS>
	{
		private LibraryPrecedenceContinuation(@NonNull CS2PivotConversion context, @NonNull LibPackageCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Library pivotElement = PivotUtil.getPivot(Library.class, csElement);
			if (pivotElement != null) {
				context.refreshPivotList(Precedence.class, pivotElement.getOwnedPrecedence(), csElement.getOwnedPrecedence());
			}
			return null;
		}
	}

	public OCLstdlibCSPreOrderVisitor(@NonNull CS2PivotConversion context) {
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
		else if (type instanceof Metaclass<?>) {
			continuation = Continuations.combine(continuation,
				new ClassifierInstanceTypeContinuation(context, csLibClass));
		}
//		else if (type instanceof LambdaType) {
//			LambdaType lamdbaType = (LambdaType) type;
//			lamdbaType.setContextType(lamdbaType);
//			lamdbaType.setResultType(lamdbaType);
//		}
		return continuation;
	}

	@Override
	public Continuation<?> visitLibIterationCS(@NonNull LibIterationCS csIteration) {
		return new LibIterationContinuation(context, csIteration);
	}

	@Override
	public Continuation<?> visitLibOperationCS(@NonNull LibOperationCS csOperation) {
		return new LibOperationContinuation(context, csOperation);
	}

	@Override
	public Continuation<?> visitLibPropertyCS(@NonNull LibPropertyCS csProperty) {
		return new LibPropertyContinuation(context, csProperty);
	}

	@Override
	public Continuation<?> visitLibPackageCS(@NonNull LibPackageCS csLibPackage) {
		Continuation<?> superContinuation = super.visitLibPackageCS(csLibPackage);
		Continuation<?> localContinuation =  new LibraryPrecedenceContinuation(context, csLibPackage);
		return Continuations.combine(superContinuation, localContinuation);
	}

	@Override
	public Continuation<?> visitPrecedenceCS(@NonNull PrecedenceCS csPrecedence) {
		return null;
	}
}