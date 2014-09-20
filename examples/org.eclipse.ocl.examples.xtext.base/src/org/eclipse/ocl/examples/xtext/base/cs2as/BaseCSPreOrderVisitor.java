/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.types.AbstractTuplePart;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;

public class BaseCSPreOrderVisitor extends AbstractExtendingBaseCSVisitor<Continuation<?>, CS2PivotConversion>
{
	protected static class ClassSupersContinuation extends SingleContinuation<ClassCS>
	{
		private static Dependency[] computeDependencies(@NonNull CS2PivotConversion context, @NonNull ClassCS csElement) {
			List<TypedRefCS> csSuperTypes = csElement.getOwnedSuperType();
			if (csSuperTypes.isEmpty()) {
				return null;
			}
			List<Dependency> dependencies = new ArrayList<Dependency>();
			for (TypedRefCS csSuperType : csSuperTypes) {
				dependencies.add(new PivotDependency(csSuperType));
			}
			return dependencies.toArray(new Dependency[dependencies.size()]);
		}

		public ClassSupersContinuation(@NonNull CS2PivotConversion context, org.eclipse.ocl.examples.pivot.Class pivotParent, @NonNull ClassCS csElement) {
			super(context, pivotParent, null, csElement, computeDependencies(context, csElement));
		}

		@Override
		public BasicContinuation<?> execute() {
			org.eclipse.ocl.examples.pivot.Class pivotElement = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Class.class, csElement);
			if (pivotElement != null) {
				List<org.eclipse.ocl.examples.pivot.Class> superClasses = pivotElement.getSuperClasses();
				context.refreshList(org.eclipse.ocl.examples.pivot.Class.class, superClasses, csElement.getOwnedSuperType());
				if (superClasses.isEmpty()) {
					org.eclipse.ocl.examples.pivot.Class oclElementType = context.getMetaModelManager().getOclElementType();
					pivotElement.getSuperClasses().add(oclElementType);
				}
			}
			return null;
		}
	}
	
	protected static class LambdaContinuation extends SingleContinuation<LambdaTypeCS>
	{
		private static Dependency[] computeDependencies(@NonNull CS2PivotConversion context, @NonNull LambdaTypeCS csElement) {
			TypedRefCS ownedContextType = DomainUtil.nonNullState(csElement.getOwnedContextType());
			TypedRefCS ownedResultType = DomainUtil.nonNullState(csElement.getOwnedResultType());
			List<TypedRefCS> csParameterTypes = csElement.getOwnedParameterType();
			int iMax = csParameterTypes.size();
			Dependency[] dependencies = new Dependency[2 + iMax];
			dependencies[0] = context.createTypeIsReferenceableDependency(ownedContextType);
			dependencies[1] = context.createTypeIsReferenceableDependency(ownedResultType);
			for (int i = 0; i < iMax; i++) {
				TypedRefCS csParameterType = DomainUtil.nonNullState(csParameterTypes.get(i));
				dependencies[i+2] = context.createTypeIsReferenceableDependency(csParameterType);
			}
			return dependencies;
		}

		public LambdaContinuation(@NonNull CS2PivotConversion context, @NonNull LambdaTypeCS csElement) {
			super(context, null, null, csElement, computeDependencies(context, csElement));
		}

		@Override
		public BasicContinuation<?> execute() {
			Type contextType = PivotUtil.getPivot(Type.class, csElement.getOwnedContextType());
			Type resultType = PivotUtil.getPivot(Type.class, csElement.getOwnedResultType());
			String name = csElement.getName();
			if ((contextType != null) && (resultType != null) && (name != null)) {
				List<Type> parameterTypes = new ArrayList<Type>();
				for (TypedRefCS csParameterType : csElement.getOwnedParameterType()) {
					Type parameterType = PivotUtil.getPivot(Type.class, csParameterType);
					parameterTypes.add(parameterType);
				}
				LambdaType lambdaType = context.getMetaModelManager().getCompleteModel().getLambdaType(name, contextType, parameterTypes, resultType, null);
				context.installPivotTypeWithMultiplicity(lambdaType, csElement);
			}
			return null;
		}
	}
	
	protected static class ParameterContinuation extends SingleContinuation<ParameterCS>
	{
		public ParameterContinuation(@NonNull CS2PivotConversion context, @NonNull ParameterCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			TypedRefCS ownedType = csElement.getOwnedType();
			Element pivot = ownedType != null ? ownedType.getPivot() : null;
			if (pivot == null) {
				return false;
			}
			return true;
		}

		@Override
		public BasicContinuation<?> execute() {
			Parameter parameter = PivotUtil.getPivot(Parameter.class, csElement);
			if (parameter != null) {
				context.refreshRequiredType(parameter, csElement);
				TypedRefCS ownedType = csElement.getOwnedType();
				boolean isTypeof = false;
				if (ownedType  instanceof TypedTypeRefCS) {
					isTypeof = ((TypedTypeRefCS)ownedType).isTypeof();
				}
				parameter.setIsTypeof(isTypeof);
			}
			return null;
		}
	}

	protected static class PrimitiveTypeRefContinuation extends TypedRefContinuation<PrimitiveTypeRefCS>
	{		
		public PrimitiveTypeRefContinuation(@NonNull CS2PivotConversion context, @NonNull PrimitiveTypeRefCS csElement) {
			super(context, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			String name = csElement.getName();
			if (name != null) {
				Type pivotType = context.getMetaModelManager().getLibraryType(name);
				if (pivotType != null) {
					context.installPivotTypeWithMultiplicity(pivotType, csElement);
				}
			}
			return null;
		}
	}
	
	protected static class SpecializedTypeRefContinuation1 extends SingleContinuation<TypedTypeRefCS>
	{
		public SpecializedTypeRefContinuation1(@NonNull CS2PivotConversion context, @NonNull TypedTypeRefCS csElement) {
			super(context, null, null, csElement, context.getTypesHaveSignaturesInterDependency());
			assert csElement.getOwnedTemplateBinding() != null;
		}

		@Override
		public BasicContinuation<?> execute() {
			@SuppressWarnings("unused")
			Element pivotType = csElement.getType();
			return new SpecializedTypeRefContinuation2(context, csElement);
		}
	}

	protected static class SpecializedTypeRefContinuation2 extends TypedRefContinuation<TypedTypeRefCS>
	{
		private static Dependency[] computeDependencies(@NonNull CS2PivotConversion context, @NonNull TypedTypeRefCS csElement) {
			List<Dependency> dependencies = new ArrayList<Dependency>();
			TemplateBindingCS csTemplateBinding = csElement.getOwnedTemplateBinding();
			if (csTemplateBinding != null) {
				for (TemplateParameterSubstitutionCS csTemplateParameterSubstitution : csTemplateBinding.getOwnedParameterSubstitution()) {
					TypeRefCS csTemplateParameter = csTemplateParameterSubstitution.getOwnedActualParameter();
					if (csTemplateParameter != null) {
						Dependency dependency = context.createTypeIsReferenceableDependency(csTemplateParameter);
						if (dependency != null) {
							dependencies.add(dependency);
						}
					}
				}
				for (TemplateParameterSubstitutionCS csTemplateParameterSubstitution : csTemplateBinding.getOwnedParameterSubstitution()) {
					TypeRefCS csActualParameter = csTemplateParameterSubstitution.getOwnedActualParameter();
					dependencies.add(new PivotDependency(csActualParameter));	// FIXME may be a redundant duplicate
				}
			}
			dependencies.add(new PivotHasSuperClassesDependency(csElement));
			return dependencies.toArray(new Dependency[dependencies.size()]);
		}
		
		public SpecializedTypeRefContinuation2(@NonNull CS2PivotConversion context, @NonNull TypedTypeRefCS csElement) {
			super(context, csElement, computeDependencies(context, csElement));
			assert csElement.getOwnedTemplateBinding() != null;
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			if (context.isInReturnTypeWithUnresolvedParameters(csElement)) {
				return false;
			}
			Type pivotType = csElement.getType();
			if (pivotType instanceof org.eclipse.ocl.examples.pivot.Class) {
				if (((org.eclipse.ocl.examples.pivot.Class)pivotType).getSuperClasses().size() <= 0) {
					return false;
				}
				TemplateBindingCS csTemplateBinding = csElement.getOwnedTemplateBinding();
				if (csTemplateBinding != null)  {
					for (TemplateParameterSubstitutionCS csTemplateParameterSubstitution : csTemplateBinding.getOwnedParameterSubstitution()) {
						TypeRefCS ownedActualParameter = csTemplateParameterSubstitution.getOwnedActualParameter();
						if (ownedActualParameter instanceof WildcardTypeRefCS) {
							return true;
						}
						Type actualParameterClass = (Type) ownedActualParameter.getPivot();
						if (actualParameterClass == null) {
							return false;
						}
					}
				}
			}
			return true;
		}

		@Override
		public BasicContinuation<?> execute() {
			Type pivotType = csElement.getType();
			if (pivotType != null) {
				TemplateBindingCS csTemplateBinding = csElement.getOwnedTemplateBinding();
				if ((csTemplateBinding != null) && ElementUtil.isSpecialization(csTemplateBinding)) {
					pivotType = (Type) context.specializeTemplates(csElement);
//					TemplateBinding pivotTemplateBinding = PivotUtil.getPivot(TemplateBinding.class, csTemplateBinding);
//					pivotType = pivotTemplateBinding.getBoundElement();
				}
				if (pivotType != null) {
					context.installPivotTypeWithMultiplicity(pivotType, csElement);
				}
			}
			return null;
		}
	}

	protected static class TemplateSignatureContinuation extends SingleContinuation<ClassifierCS>
	{
		public TemplateSignatureContinuation(@NonNull CS2PivotConversion context, NamedElement pivotParent, @NonNull ClassifierCS csElement) {
			super(context, pivotParent, PivotPackage.Literals.TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE, csElement);
			context.getTypesHaveSignaturesInterDependency().addDependency(this);
		}

		@Override
		public BasicContinuation<?> execute() {
			Type pivotElement = PivotUtil.getPivot(Type.class, csElement);
			if (pivotElement != null) {
				if (pivotElement instanceof TemplateableElement) {
					context.refreshTemplateSignature(csElement, (TemplateableElement)pivotElement);
				}
				context.getTypesHaveSignaturesInterDependency().setSatisfied(this);
			}
			return null;
		}
	}
	
	protected static class TupleContinuation extends TypedRefContinuation<TupleTypeCS>
	{
		public TupleContinuation(@NonNull CS2PivotConversion context, @NonNull TupleTypeCS csElement) {
			super(context, csElement);
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			for (TuplePartCS csTuplePart : csElement.getOwnedParts()) {
				TypedRefCS ownedType = csTuplePart.getOwnedType();
				Element pivot = ownedType.getPivot();
				if (pivot == null) {
					return false;
				}
			}
			if (context.isInReturnTypeWithUnresolvedParameters(csElement)) {
				return false;
			}
			return true;
		}

		@Override
		public BasicContinuation<?> execute() {
			String name = csElement.getName();
			if (name != null) {
				List<DomainTypedElement> parts = new ArrayList<DomainTypedElement>();
				for (@SuppressWarnings("null")@NonNull TuplePartCS csTuplePart : csElement.getOwnedParts()) {
					String partName = csTuplePart.getName();
					if (partName != null) {
						Type partType = PivotUtil.getPivot(Type.class, csTuplePart.getOwnedType());
						if (partType != null) {
							parts.add(new AbstractTuplePart(partType, partName));
						}
					}
				}
				TupleType tupleType = context.getMetaModelManager().getCompleteModel().getTupleType(name, parts, null);
				context.installPivotTypeWithMultiplicity(tupleType, csElement);
				List<Property> tupleParts = tupleType.getOwnedProperties();
				for (TuplePartCS csTuplePart : csElement.getOwnedParts()) {
					String partName = csTuplePart.getName();
					Property tuplePart = DomainUtil.getNamedElement(tupleParts, partName);
					if (tuplePart != null) {
						context.installPivotUsage(csTuplePart, tuplePart);
					}
				}
			}
			return null;
		}
	}

	protected static abstract class TypedRefContinuation<T extends TypedRefCS> extends SingleContinuation<T>
	{
		public TypedRefContinuation(@NonNull CS2PivotConversion context, @NonNull T csElement, Dependency... dependencies) {
			super(context, null, null, csElement);
		}
	}

	protected static class UnspecializedTypeRefContinuation extends TypedRefContinuation<TypedTypeRefCS>
	{
		public UnspecializedTypeRefContinuation(@NonNull CS2PivotConversion context, @NonNull TypedTypeRefCS csElement) {
			super(context, csElement, context.getTypesHaveSignaturesInterDependency());
			assert csElement.getOwnedTemplateBinding() == null;
		}

		@Override
		public BasicContinuation<?> execute() {
			Type pivotType = csElement.getType();
			if (pivotType != null) {
				context.installPivotTypeWithMultiplicity(pivotType, csElement);
			}
			return null;
		}
	}

	public BaseCSPreOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public Continuation<?> visiting(@NonNull VisitableCS visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for CS2Pivot PreOrder pass");
	}

	@Override
	public Continuation<?> visitAnnotationCS(@NonNull AnnotationCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitClassCS(@NonNull ClassCS csClass) {
		org.eclipse.ocl.examples.pivot.Class pivotElement = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Class.class, csClass);
		if (pivotElement == null) {
			return null;
		}
		Continuations continuations = new Continuations();
		if (csClass.getOwnedTemplateSignature() != null) {
			continuations.add(new TemplateSignatureContinuation(context, pivotElement, csClass));
		}
		else {
			pivotElement.setOwnedTemplateSignature(null);
		}
		if (!(pivotElement instanceof AnyType)) {
			continuations.add(new ClassSupersContinuation(context, pivotElement, csClass));
		}
		return continuations.getContinuation();
	}

	@Override
	public Continuation<?> visitConstraintCS(@NonNull ConstraintCS csConstraint) {
		return null;
	}

	@Override
	public Continuation<?> visitDataTypeCS(@NonNull DataTypeCS csDataType) {
		DataType pivotElement = PivotUtil.getPivot(DataType.class, csDataType);
		if (pivotElement != null) {
			List<org.eclipse.ocl.examples.pivot.Class> pivotSuperClasses = pivotElement.getSuperClasses();
			pivotSuperClasses.clear();
			org.eclipse.ocl.examples.pivot.Class oclElementType = context.getMetaModelManager().getOclElementType();
			pivotSuperClasses.add(oclElementType);
		}
		return null;
	}

	@Override
	public Continuation<?> visitDocumentationCS(@NonNull DocumentationCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitEnumerationCS(@NonNull EnumerationCS csEnumeration) {
		org.eclipse.ocl.examples.pivot.Enumeration pivotElement = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Enumeration.class, csEnumeration);
		if (pivotElement != null) {
			List<org.eclipse.ocl.examples.pivot.Class> pivotSuperClasses = pivotElement.getSuperClasses();
			pivotSuperClasses.clear();
			org.eclipse.ocl.examples.pivot.Class oclElementType = context.getMetaModelManager().getOclElementType();
			pivotSuperClasses.add(oclElementType);
		}
		return null;
	}

	@Override
	public Continuation<?> visitEnumerationLiteralCS(@NonNull EnumerationLiteralCS csEnumerationLiteral) {
		return null;
	}

	@Override
	public Continuation<?> visitLambdaTypeCS(@NonNull LambdaTypeCS csLambdaType) {
		return new LambdaContinuation(context, csLambdaType);
	}

	@Override
	public Continuation<?> visitModelElementCS(@NonNull ModelElementCS csModelElement) {
		return null;
	}

	@Override
	public Continuation<?> visitModelElementRefCS(@NonNull ModelElementRefCS csModelElementRef) {
		return null;
	}

	@Override
	public Continuation<?> visitMultiplicityBoundsCS(@NonNull MultiplicityBoundsCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitMultiplicityStringCS(@NonNull MultiplicityStringCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitOperationCS(@NonNull OperationCS csOperation) {
		return null;
	}
	
	@Override
	public Continuation<?> visitPackageCS(@NonNull PackageCS csPackage) {
		return null;
	}
	
	@Override
	public Continuation<?> visitPackageOwnerCS(@NonNull PackageOwnerCS object) {
		return null;
	};

	@Override
	public Continuation<?> visitParameterCS(@NonNull ParameterCS csParameter) {
		return new ParameterContinuation(context, csParameter);
	}

	@Override
	public Continuation<?> visitPathElementCS(@NonNull PathElementCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPathNameCS(@NonNull PathNameCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPrimitiveTypeRefCS(@NonNull PrimitiveTypeRefCS csPrimitiveTypeRef) {
		return new PrimitiveTypeRefContinuation(context, csPrimitiveTypeRef);
	}

	@Override
	public Continuation<?> visitStructuralFeatureCS(@NonNull StructuralFeatureCS csStructuralFeature) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateBindingCS(@NonNull TemplateBindingCS csTemplateBinding) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateSignatureCS(@NonNull TemplateSignatureCS csTemplateSignature) {
		return null;
	}

	@Override
	public Continuation<?> visitTupleTypeCS(@NonNull TupleTypeCS csTupleType) {
		return new TupleContinuation(context, csTupleType);
	}

	@Override
	public Continuation<?> visitTypedTypeRefCS(@NonNull TypedTypeRefCS csTypedTypeRef) {
		if (csTypedTypeRef.getOwnedTemplateBinding() == null) {
			return new UnspecializedTypeRefContinuation(context, csTypedTypeRef);
		}
		else {
			return new SpecializedTypeRefContinuation1(context, csTypedTypeRef);
		}
	}

	@Override
	public Continuation<?> visitWildcardTypeRefCS(@NonNull WildcardTypeRefCS csWildcardTypeRef) {
		return null;
	}
}