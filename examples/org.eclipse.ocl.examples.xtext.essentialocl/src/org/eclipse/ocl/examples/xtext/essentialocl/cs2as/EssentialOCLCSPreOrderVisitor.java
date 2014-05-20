/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.essentialocl.cs2as;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractEssentialOCLCSPreOrderVisitor;

public class EssentialOCLCSPreOrderVisitor extends AbstractEssentialOCLCSPreOrderVisitor
{
	protected static class CollectionTypeContinuation extends SingleContinuation<CollectionTypeCS>
	{
		public CollectionTypeContinuation(@NonNull CS2PivotConversion context, @NonNull CollectionTypeCS csElement) {
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
				Element unspecializedPivotElement = CS2Pivot.basicGetType((TypedTypeRefCS)csTypedRef);
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
					IntegerValue upperValue;
					MultiplicityCS csMultiplicity = csElement.getMultiplicity();
					if (csMultiplicity != null) {
						lowerValue = ValuesUtil.integerValueOf(csMultiplicity.getLower());
						int upper = csMultiplicity.getUpper();
						upperValue = upper != -1 ? ValuesUtil.integerValueOf(upper) : ValuesUtil.UNLIMITED_VALUE;
					}
					else {
						lowerValue = null;
						upperValue = null;
					}
					type = metaModelManager.getCollectionType(name, elementType, lowerValue, upperValue);
				}
			}
			if (type == null) {
				type = metaModelManager.getLibraryType(name);
			}
			csElement.setPivot(type);
			return null;
		}
	}

	protected static class TypeNameExpContinuation extends SingleContinuation<TypeNameExpCS>
	{
		public TypeNameExpContinuation(@NonNull CS2PivotConversion context, @NonNull TypeNameExpCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Type element = csElement.getElement();
			if ((element == null) || element.eIsProxy()) {
				String boundMessage = context.bind(csElement, OCLMessages.UnresolvedType_ERROR_, csElement.toString());
				context.addDiagnostic(csElement, boundMessage);
				element = context.getMetaModelManager().getOclInvalidType();	// FIXME with reason
			}
			context.installPivotTypeWithMultiplicity(element, csElement);
			return null;
		}
	}

	public EssentialOCLCSPreOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitCollectionTypeCS(@NonNull CollectionTypeCS csCollectionType) {
		// Must at least wait till library types defined
		return new CollectionTypeContinuation(context, csCollectionType);
	}

	@Override
	public Continuation<?> visitConstructorExpCS(@NonNull ConstructorExpCS csConstructorExp) {
		return null;
	}

	@Override
	public Continuation<?> visitContextCS(@NonNull ContextCS csContext) {
		return null;
	}

	@Override
	public Continuation<?> visitExpCS(@NonNull ExpCS csExp) {
		return null;
	}

	@Override
	public Continuation<?> visitInvocationExpCS(@NonNull InvocationExpCS csNavigatingExp) {
		return null;
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
	public Continuation<?> visitNavigationOperatorCS(@NonNull NavigationOperatorCS object) {
		EObject eContainer = object.eContainer();
		if (eContainer instanceof InfixExpCS) {
			InfixExpCS csInfixExp = (InfixExpCS)eContainer;
			int index = csInfixExp.getOwnedOperator().indexOf(object);
			if (index >= 0) {
				List<ExpCS> expressions = csInfixExp.getOwnedExpression();
				if ((index+1) < expressions.size()) {
					ExpCS csExp = expressions.get(index+1);
					if ((csExp instanceof NameExpCS) && !(csExp instanceof InvocationExpCS)) {
						PathNameCS pathName = ((NameExpCS) csExp).getPathName();
						assert pathName != null;
						CS2Pivot.setElementType(pathName, PivotPackage.Literals.PROPERTY, csExp, null);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitOperatorCS(@NonNull OperatorCS object) {
		return null;
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