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
package org.eclipse.ocl.xtext.essentialocl.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LambdaLiteralExp;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParameterType;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.PrecedenceManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.Dependency;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ContextLessElementCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathTypeCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialocl.attributes.NavigationUtil;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.PathExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.util.AbstractEssentialOCLCSPreOrderVisitor;

public class EssentialOCLCSPreOrderVisitor extends AbstractEssentialOCLCSPreOrderVisitor
{
	protected static class CollectionTypeContinuation extends SingleContinuation<CollectionTypeCS>
	{
		public CollectionTypeContinuation(@NonNull CS2ASConversion context, @NonNull CollectionTypeCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			String name = csElement.getName();
			assert name != null;
			org.eclipse.ocl.pivot.Class requiredLibraryType = context.getStandardLibrary().getRequiredLibraryType(name);
			if (requiredLibraryType.getSuperClasses().size() <= 0) {
				return false;
			}
			return isReady(csElement.getOwnedType());
		}

		@Override
		public BasicContinuation<?> execute() {
			PivotMetamodelManager metamodelManager = context.getMetamodelManager();
			TypedRefCS csElementType = csElement.getOwnedType();
			Type type = null;
			String name = csElement.getName();
			assert name != null;
			if (csElementType != null) {
				Type elementType = PivotUtil.getPivot(Type.class, csElementType);
				if (elementType != null) {
					boolean isNullFree;
					IntegerValue lowerValue;
					UnlimitedNaturalValue upperValue;
					MultiplicityCS csMultiplicity = csElement.getOwnedMultiplicity();
					if (csMultiplicity != null) {
						isNullFree = csMultiplicity.isIsNullFree();
						lowerValue = ValueUtil.integerValueOf(csMultiplicity.getLower());
						int upper = csMultiplicity.getUpper();
						upperValue = upper != -1 ? ValueUtil.unlimitedNaturalValueOf(upper) : ValueUtil.UNLIMITED_VALUE;
					}
					else {
						isNullFree = false;
						lowerValue = null;
						upperValue = null;
					}
					type = metamodelManager.getCollectionType(name, elementType, isNullFree, lowerValue, upperValue);
				}
			}
			if (type == null) {
				type = metamodelManager.getStandardLibrary().getLibraryType(name);
			}
			csElement.setPivot(type);
			return null;
		}
	}

	protected static class InfixExpContinuation extends OperatorExpContinuation<InfixExpCS>
	{
		public InfixExpContinuation(@NonNull CS2ASConversion context, @NonNull InfixExpCS csElement) {
			super(context, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			PivotMetamodelManager metamodelManager = context.getMetamodelManager();
			String operatorName = csElement.getName();
			Precedence precedence = operatorName != null ? metamodelManager.getInfixPrecedence(operatorName) : null;
			csElement.setPrecedence(precedence);
			return super.execute();
		}
	}
	
	protected static class LambdaLiteralContinuation extends SingleContinuation<LambdaLiteralExpCS>
	{
		private static Dependency[] computeDependencies(@NonNull CS2ASConversion context, @NonNull LambdaLiteralExpCS csElement) {
			TypedRefCS csResultType = ClassUtil.nonNullState(csElement.getOwnedType());
			List<ParameterCS> csParameterTypes = csElement.getOwnedParameters();
			int iMax = csParameterTypes.size();
			Dependency[] dependencies = new Dependency[1 + iMax];
			dependencies[0] = context.createTypeIsReferenceableDependency(csResultType);
			for (int i = 0; i < iMax; i++) {
				ParameterCS csParameter = csParameterTypes.get(i);
				if (csParameter != null) {
					TypedRefCS csParameterType = csParameter.getOwnedType();
					if (csParameterType != null) {
						dependencies[i+1] = context.createTypeIsReferenceableDependency(csParameterType);
					}
				}
			}
			return dependencies;
		}

		public LambdaLiteralContinuation(@NonNull CS2ASConversion context, @NonNull LambdaLiteralExpCS csElement) {
			super(context, null, null, csElement, computeDependencies(context, csElement));
		}

/*		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			if (!isReady(csElement.getOwnedType())) {
				return false;
			}
			for (ParameterCS csParameter: csElement.getOwnedParameters()) {
				if (!isReady(csParameter.getOwnedType())) {
					return false;
				}
			}
			return true;
		} */

		@Override
		public BasicContinuation<?> execute() {
			LambdaLiteralExp asLambdaExpression = PivotUtil.getPivot(LambdaLiteralExp.class, csElement);
			if (asLambdaExpression != null) {
				TypedRefCS csResultType = csElement.getOwnedType();
				if (csResultType != null) {
					Type asResultType = PivotUtil.getPivot(Type.class, csResultType);
					String name = csElement.getName();
					asLambdaExpression.setName(name);
					if ((asResultType != null) && (name != null)) {
						List<Parameter> asParameters = new ArrayList<Parameter>();
						List<ParameterType> parameterTypes = new ArrayList<ParameterType>();
						for (ParameterCS csParameter: csElement.getOwnedParameters()) {
							TypedRefCS csParameterType = csParameter.getOwnedType();
							Type asParameterType = PivotUtil.getPivot(Type.class, csParameterType);
							Parameter asParameter = PivotUtil.getPivot(Parameter.class, csParameter);
							if ((asParameter != null) && (asParameterType != null)) {
								asParameters.add(asParameter);
								parameterTypes.add(PivotUtil.createParameterType(asParameterType, ElementUtil.isRequired(csParameterType)));
							}
						}
						ParameterType resultParameterType = PivotUtil.createParameterType(asResultType, ElementUtil.isRequired(csResultType));
						LambdaType lambdaType = context.getMetamodelManager().getCompleteModel().getLambdaType(name, parameterTypes, resultParameterType, null);
						context.setType(asLambdaExpression, lambdaType, true, null);
						PivotUtilInternal.refreshList(asLambdaExpression.getOwnedParameters(), asParameters);
					}
				}
			}
			return null;
		}
	}
	
	protected static class MapTypeContinuation extends SingleContinuation<MapTypeCS>
	{
		public MapTypeContinuation(@NonNull CS2ASConversion context, @NonNull MapTypeCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			return isReady(csElement.getOwnedKeyType()) && isReady(csElement.getOwnedValueType());
		}

		@Override
		public BasicContinuation<?> execute() {
			PivotMetamodelManager metamodelManager = context.getMetamodelManager();
			TypedRefCS csKeyType = csElement.getOwnedKeyType();
			TypedRefCS csValueType = csElement.getOwnedValueType();
			Type type = null;
			String name = csElement.getName();
			assert name != null;
			if ((csKeyType != null) && (csValueType != null)) {
				Type keyType = PivotUtil.getPivot(Type.class, csKeyType);
				Type valueType = PivotUtil.getPivot(Type.class, csValueType);
				if ((keyType != null) && (valueType != null)) {
					type = metamodelManager.getMapType(name, keyType, valueType);
				}
			}
			if (type == null) {
				type = metamodelManager.getStandardLibrary().getLibraryType(name);
			}
			csElement.setPivot(type);
			return null;
		}
	}

	protected static class PrefixExpContinuation extends OperatorExpContinuation<PrefixExpCS>
	{
		public PrefixExpContinuation(@NonNull CS2ASConversion context, @NonNull PrefixExpCS csElement) {
			super(context, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			PivotMetamodelManager metamodelManager = context.getMetamodelManager();
			String operatorName = csElement.getName();
			Precedence precedence = operatorName != null ? metamodelManager.getPrefixPrecedence(operatorName) : null;
			csElement.setPrecedence(precedence);
			return super.execute();
		}
	}

	protected static class PathExpContinuation extends SingleContinuation<PathExpCS>
	{
		public PathExpContinuation(@NonNull CS2ASConversion context, @NonNull PathExpCS csElement) {
			super(context, null, null, csElement, context.getOperatorsHavePrecedenceInterDependency());
		}

		@Override
		public BasicContinuation<?> execute() {
			Type element = csElement.getReferredType();
//			if ((element == null) || element.eIsProxy() || (element instanceof InvalidType)) {
//				String boundMessage = context.bind(csElement, PivotMessagesInternal.UnresolvedType_ERROR_, "", csElement.toString());
//				context.addDiagnostic(csElement, boundMessage);
//				element = context.getStandardLibrary().getOclInvalidType();	// FIXME with reason
//			}
			context.installPivotTypeWithMultiplicity(element, csElement);
			return null;
		}
	}

	protected static boolean isReady(TypedRefCS csTypedRef) {
		if (csTypedRef == null) {
			return true;
		}
		if (csTypedRef instanceof PathTypeCS) {
			Element unspecializedPivotElement = CS2AS.basicGetType((PathTypeCS)csTypedRef);
			if (unspecializedPivotElement == null) {
				return false;
			}
//			if (unspecializedPivotElement.eIsProxy()) {
//				return false;
//			}
		}
		if (csTypedRef.getPivot() == null) {
			return false;
		}
		return true;
	}

	public EssentialOCLCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitCollectionTypeCS(@NonNull CollectionTypeCS csCollectionType) {
		// Must at least wait till library types defined
		return new CollectionTypeContinuation(context, csCollectionType);
	}

	@Override
	public Continuation<?> visitContextCS(@NonNull ContextCS csContext) {
		return null;
	}

	@Override
	public Continuation<?> visitContextLessElementCS(@NonNull ContextLessElementCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitExpCS(@NonNull ExpCS csExp) {
		return null;
	}

	@Override
	public Continuation<?> visitInfixExpCS(@NonNull InfixExpCS csElement) {
		if (NavigationUtil.isNavigationInfixExp(csElement)) {
			csElement.setPrecedence(PrecedenceManager.NAVIGATION_PRECEDENCE);
			return null;
		}
		else {
			// Defer setting precedence until all OCLstdlib-defined operations using precedence are available
			return new InfixExpContinuation(context, csElement);
		}
	}

	@Override
	public @Nullable Continuation<?> visitLambdaLiteralExpCS(@NonNull LambdaLiteralExpCS csElement) {
		return new LambdaLiteralContinuation(context, csElement);
	}

	@Override
	public @Nullable Continuation<?> visitLetVariableCS(@NonNull LetVariableCS csElement) {
		Continuation<?> continuation = super.visitLetVariableCS(csElement);
		assert continuation == null;
		Variable asVariable = PivotUtil.getPivot(Variable.class, csElement);
		if (asVariable != null) {
			OCLExpression asInitExpression = PivotUtil.getPivot(OCLExpression.class, csElement.getOwnedInitExpression());
			asVariable.setOwnedInit(asInitExpression);		// Non-null for a LambdaLiteralExp, null for many other expressions
		}
		return null;
	}

	@Override
	public Continuation<?> visitMapTypeCS(@NonNull MapTypeCS csMapType) {
		// Must at least wait till library types defined
		return new MapTypeContinuation(context, csMapType);
	}

	@Override
	public Continuation<?> visitNameExpCS(@NonNull NameExpCS csNameExp) {
		return null;
	}

	@Override
	public Continuation<?> visitPathExpCS(@NonNull PathExpCS csTypeNameExp) {
		return new PathExpContinuation(context, csTypeNameExp);
	}

	@Override
	public Continuation<?> visitNavigatingArgCS(@NonNull NavigatingArgCS csNavigatingArg) {
		return null;
	}

	@Override
	public Continuation<?> visitPrefixExpCS(@NonNull PrefixExpCS csElement) {
		// Defer setting precedence until all OCLstdlib-defined operations using precedence are available
		return new PrefixExpContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitVariableCS(@NonNull VariableCS csVariable) {
		return null;
	}
}
