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
package org.eclipse.ocl.xtext.essentialocl.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.PrecedenceManager;
import org.eclipse.ocl.pivot.messages.OCLMessages;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.basecs.ContextLessElementCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.essentialocl.attributes.NavigationUtil;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
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
			TypedRefCS csTypedRef = csElement.getOwnedType();			
			if (csTypedRef == null) {
				return true;
			}
			if (csTypedRef instanceof TypedTypeRefCS) {
				Element unspecializedPivotElement = CS2AS.basicGetType((TypedTypeRefCS)csTypedRef);
				if (unspecializedPivotElement == null) {
					return false;
				}
//				if (unspecializedPivotElement.eIsProxy()) {
//					return false;
//				}
			}
			if (csTypedRef.getPivot() == null) {
				return false;
			}
			return true;
		}

		@Override
		public BasicContinuation<?> execute() {
			MetaModelManager metaModelManager = context.getMetaModelManager();
			TypedRefCS csElementType = csElement.getOwnedType();
			Type type = null;
			String name = csElement.getName();
			assert name != null;
			if (csElementType != null) {
				Type elementType = PivotUtil.getPivot(Type.class, csElementType);
				if (elementType != null) {
					IntegerValue lowerValue;
					UnlimitedNaturalValue upperValue;
					MultiplicityCS csMultiplicity = csElement.getOwnedMultiplicity();
					if (csMultiplicity != null) {
						lowerValue = ValueUtil.integerValueOf(csMultiplicity.getLower());
						int upper = csMultiplicity.getUpper();
						upperValue = upper != -1 ? ValueUtil.unlimitedNaturalValueOf(upper) : ValueUtil.UNLIMITED_VALUE;
					}
					else {
						lowerValue = null;
						upperValue = null;
					}
					type = metaModelManager.getCollectionType(name, elementType, lowerValue, upperValue);
				}
			}
			if (type == null) {
				type = metaModelManager.getStandardLibrary().getLibraryType(name);
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
			MetaModelManager metaModelManager = context.getMetaModelManager();
			String operatorName = csElement.getName();
			Precedence precedence = operatorName != null ? metaModelManager.getInfixPrecedence(operatorName) : null;
			csElement.setPrecedence(precedence);
			return super.execute();
		}
	}

	protected static class PrefixExpContinuation extends OperatorExpContinuation<PrefixExpCS>
	{
		public PrefixExpContinuation(@NonNull CS2ASConversion context, @NonNull PrefixExpCS csElement) {
			super(context, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			MetaModelManager metaModelManager = context.getMetaModelManager();
			String operatorName = csElement.getName();
			Precedence precedence = operatorName != null ? metaModelManager.getPrefixPrecedence(operatorName) : null;
			csElement.setPrecedence(precedence);
			return super.execute();
		}
	}

	protected static class TypeNameExpContinuation extends SingleContinuation<TypeNameExpCS>
	{
		public TypeNameExpContinuation(@NonNull CS2ASConversion context, @NonNull TypeNameExpCS csElement) {
			super(context, null, null, csElement, context.getOperatorsHavePrecedenceInterDependency());
		}

		@Override
		public BasicContinuation<?> execute() {
			Type element = csElement.getElement();
			if ((element == null) || element.eIsProxy()) {
				String boundMessage = context.bind(csElement, OCLMessages.UnresolvedType_ERROR_, "", csElement.toString());
				context.addDiagnostic(csElement, boundMessage);
				element = context.getStandardLibrary().getOclInvalidType();	// FIXME with reason
			}
			context.installPivotTypeWithMultiplicity(element, csElement);
			return null;
		}
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
	public Continuation<?> visitNameExpCS(@NonNull NameExpCS csNameExp) {
		return null;
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
	public Continuation<?> visitTypeNameExpCS(@NonNull TypeNameExpCS csTypeNameExp) {
		return new TypeNameExpContinuation(context, csTypeNameExp);
	}

	@Override
	public Continuation<?> visitVariableCS(@NonNull VariableCS csVariable) {
		return null;
	}
}
