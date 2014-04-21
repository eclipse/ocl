/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.essentialocl.cs2as;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IndexExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractEssentialOCLCSContainmentVisitor;

public class EssentialOCLCSContainmentVisitor extends AbstractEssentialOCLCSContainmentVisitor
{
	private static final Logger logger = Logger.getLogger(EssentialOCLCSContainmentVisitor.class);

	private static final class NotOperationNotPackageFilter implements ScopeFilter
	{
		public static NotOperationNotPackageFilter INSTANCE = new NotOperationNotPackageFilter();
		
		public int compareMatches(@NonNull MetaModelManager metaModelManager, @NonNull Object match1, @Nullable Map<TemplateParameter, ParameterableElement> bindings1,
				@NonNull Object match2, @Nullable Map<TemplateParameter, ParameterableElement> bindings2) {
			return 0;
		}

		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			return !(object instanceof Operation) && !(object instanceof org.eclipse.ocl.examples.pivot.Package);
		}
	}

	public EssentialOCLCSContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitBooleanLiteralExpCS(@NonNull BooleanLiteralExpCS csElement) {
		@NonNull BooleanLiteralExp pivotElement = context.refreshModelElement(BooleanLiteralExp.class, PivotPackage.Literals.BOOLEAN_LITERAL_EXP, csElement);
		pivotElement.setBooleanSymbol(Boolean.valueOf(csElement.getName()));
		return null;
	}

	@Override
	public Continuation<?> visitCollectionLiteralExpCS(@NonNull CollectionLiteralExpCS csElement) {
		@NonNull CollectionLiteralExp pivotElement = context.refreshModelElement(CollectionLiteralExp.class, PivotPackage.Literals.COLLECTION_LITERAL_EXP, csElement);
		context.refreshPivotList(CollectionLiteralPart.class, pivotElement.getPart(), csElement.getOwnedParts());
		return null;
	}

	@Override
	public Continuation<?> visitCollectionLiteralPartCS(@NonNull CollectionLiteralPartCS csElement) {
		if (csElement.getLastExpressionCS() == null) {
			context.refreshModelElement(CollectionItem.class, PivotPackage.Literals.COLLECTION_ITEM, csElement);	
		}
		else {
			context.refreshModelElement(CollectionRange.class, PivotPackage.Literals.COLLECTION_RANGE, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitCollectionTypeCS(@NonNull CollectionTypeCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(@NonNull ConstraintCS csElement) {
		@NonNull Constraint asConstraint = refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, csElement);
		ExpSpecificationCS csStatusSpecification = (ExpSpecificationCS)csElement.getSpecification();
		ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS)csElement.getMessageSpecification();
		if (csMessageSpecification == null) {
			OpaqueExpression asSpecification = PivotUtil.getPivot(OpaqueExpression.class, csStatusSpecification);
			asConstraint.setSpecification(asSpecification);
		}
		else {
			Map<String, Type> tupleParts = new HashMap<String, Type>();
			tupleParts.put(PivotConstants.MESSAGE_PART_NAME, metaModelManager.getStringType());
			tupleParts.put(PivotConstants.STATUS_PART_NAME, metaModelManager.getBooleanType());
			TupleType tupleType = metaModelManager.getTupleManager().getTupleType("Tuple", tupleParts);
			Property statusProperty = DomainUtil.getNamedElement(tupleType.getOwnedAttribute(), PivotConstants.STATUS_PART_NAME);
			OpaqueExpression asSpecification = asConstraint.getSpecification();
			//
			ExpressionInOCL asExpressionInOCL;
			if (asSpecification instanceof ExpressionInOCL) {
				asExpressionInOCL = (ExpressionInOCL) asSpecification;	
			}
			else {
				asExpressionInOCL = PivotFactory.eINSTANCE.createExpressionInOCL();
				asConstraint.setSpecification(asExpressionInOCL);
			}
			OCLExpression asExpression = asExpressionInOCL.getBodyExpression();
			//
			PropertyCallExp asTuplePartExp;
			if (asExpression instanceof PropertyCallExp) {
				asTuplePartExp = (PropertyCallExp) asExpression;	
			}
			else {
				asTuplePartExp = PivotFactory.eINSTANCE.createPropertyCallExp();
				asExpressionInOCL.setBodyExpression(asTuplePartExp);
			}
			asTuplePartExp.setReferredProperty(statusProperty);
			asTuplePartExp.setType(statusProperty.getType());
			asTuplePartExp.setIsRequired(true);
			asExpression = asTuplePartExp.getSource();
			//
			TupleLiteralExp asTupleLiteralExp;
			if (asExpression instanceof TupleLiteralExp) {
				asTupleLiteralExp = (TupleLiteralExp) asExpression;	
			}
			else {
				asTupleLiteralExp = PivotFactory.eINSTANCE.createTupleLiteralExp();
				asTuplePartExp.setSource(asTupleLiteralExp);
			}
			asTupleLiteralExp.setType(tupleType);
			asTupleLiteralExp.setIsRequired(true);
			List<TupleLiteralPart> parts = new ArrayList<TupleLiteralPart>();
			TupleLiteralPart asStatusPart = PivotUtil.getPivot(TupleLiteralPart.class, csStatusSpecification);
			TupleLiteralPart asMessagePart = PivotUtil.getPivot(TupleLiteralPart.class, csMessageSpecification);
			if ((asMessagePart != null) && (asStatusPart != null)) {
				parts.add(asMessagePart);
				parts.add(asStatusPart);
			}
			context.refreshList(asTupleLiteralExp.getPart(), parts);
		}
		return null;
	}

	@Override
	public Continuation<?> visitConstructorExpCS(@NonNull ConstructorExpCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		if (pathName != null) {
			CS2Pivot.setElementType(pathName, PivotPackage.Literals.TYPE, csElement, null);
		}
		@NonNull ConstructorExp pivotElement = context.refreshModelElement(ConstructorExp.class, PivotPackage.Literals.CONSTRUCTOR_EXP, csElement);
		pivotElement.setValue(csElement.getValue());
		context.refreshPivotList(ConstructorPart.class, pivotElement.getPart(), csElement.getOwnedParts());
		return null;
	}

	@Override
	public Continuation<?> visitConstructorPartCS(@NonNull ConstructorPartCS csElement) {
		context.refreshModelElement(ConstructorPart.class, PivotPackage.Literals.CONSTRUCTOR_PART, csElement);	
		return null;
	}

	@Override
	public Continuation<?> visitContextCS(@NonNull ContextCS csElement) {
		@NonNull ExpressionInOCL pivotElement = context.refreshModelElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, csElement);
		PivotUtil.setBody(pivotElement, null, null);
		Resource resource = csElement.eResource();
		if (resource instanceof BaseResource) {	
			ParserContext parserContext = ((BaseResource)resource).getParserContext();
			if (parserContext != null) {
				parserContext.initialize(context, pivotElement);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitExpCS(@NonNull ExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitExpSpecificationCS(@NonNull ExpSpecificationCS csElement) {
		EObject eContainer = csElement.eContainer();
		if (eContainer instanceof ConstraintCS) {
			ConstraintCS csConstraint = (ConstraintCS) eContainer;
			SpecificationCS csStatusSpecification = csConstraint.getSpecification();
			SpecificationCS csMessageSpecification = csConstraint.getMessageSpecification();
			if ((csStatusSpecification != null) && (csMessageSpecification != null)) {
				@NonNull TupleLiteralPart csTupleLiteralPart = context.refreshModelElement(TupleLiteralPart.class, PivotPackage.Literals.TUPLE_LITERAL_PART, csElement);
				EStructuralFeature eContainingFeature = csElement.eContainingFeature();
				if (eContainingFeature == BaseCSPackage.Literals.CONSTRAINT_CS__SPECIFICATION) {
					csTupleLiteralPart.setName(PivotConstants.STATUS_PART_NAME);
					csTupleLiteralPart.setType(metaModelManager.getBooleanType());
				}
				else if (eContainingFeature == BaseCSPackage.Literals.CONSTRAINT_CS__MESSAGE_SPECIFICATION) {
					csTupleLiteralPart.setName(PivotConstants.MESSAGE_PART_NAME);
					csTupleLiteralPart.setType(metaModelManager.getStringType());
				}
				else {
					logger.error("unknown ExpSpecificationCS.eContainingFeature" + eContainingFeature);
				}
				return null;
			}
		}
		if (csElement.getOwnedExpression() != null) {
			context.refreshModelElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, csElement);
		}
		else {
			context.refreshModelElement(OpaqueExpression.class, PivotPackage.Literals.OPAQUE_EXPRESSION, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitIfExpCS(@NonNull IfExpCS csElement) {
		context.refreshModelElement(IfExp.class, PivotPackage.Literals.IF_EXP, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitIndexExpCS(@NonNull IndexExpCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		assert pathName != null;
		CS2Pivot.setElementType(pathName, PivotPackage.Literals.ELEMENT, csElement, NotOperationNotPackageFilter.INSTANCE);
		return null;
	}

	@Override
	public Continuation<?> visitInfixExpCS(@NonNull InfixExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitInvalidLiteralExpCS(@NonNull InvalidLiteralExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitInvocationExpCS(@NonNull InvocationExpCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		assert pathName != null;
		CS2Pivot.setElementType(pathName, PivotPackage.Literals.OPERATION, csElement, null);
		return null;
	}

	@Override
	public Continuation<?> visitLiteralExpCS(@NonNull LiteralExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitNameExpCS(@NonNull NameExpCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		assert pathName != null;
		CS2Pivot.setElementType(pathName, PivotPackage.Literals.ELEMENT, csElement, NotOperationNotPackageFilter.INSTANCE);
		return null;
	}

	@Override
	public Continuation<?> visitNavigatingArgCS(@NonNull NavigatingArgCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitNestedExpCS(@NonNull NestedExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitNullLiteralExpCS(@NonNull NullLiteralExpCS csElement) {
		context.refreshModelElement(NullLiteralExp.class, PivotPackage.Literals.NULL_LITERAL_EXP, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitNumberLiteralExpCS(@NonNull NumberLiteralExpCS csElement) {
		Number number = csElement.getName();
		if ((number instanceof BigDecimal) || (number instanceof Double) || (number instanceof Float)) {
			@NonNull RealLiteralExp pivotElement = context.refreshModelElement(RealLiteralExp.class, PivotPackage.Literals.REAL_LITERAL_EXP, csElement);
			pivotElement.setRealSymbol(number);
		}
		else {
			boolean isNegative;
			if (number instanceof BigInteger) {
				BigInteger bigInteger = (BigInteger) number;
				isNegative = bigInteger.signum() < 0;
				if (isNegative) {
					if (bigInteger.compareTo(ValuesUtil.INTEGER_MIN_VALUE) >= 0) {
						number = Integer.valueOf(bigInteger.intValue());
					}
					else if (bigInteger.compareTo(ValuesUtil.LONG_MIN_VALUE) >= 0) {
						number = Long.valueOf(bigInteger.longValue());
					}
				}
				else {
					if (bigInteger.compareTo(ValuesUtil.INTEGER_MAX_VALUE) <= 0) {
						number = Integer.valueOf(bigInteger.intValue());
					}
					else if (bigInteger.compareTo(ValuesUtil.LONG_MAX_VALUE) <= 0) {
						number = Long.valueOf(bigInteger.longValue());
					}
				}
			}
			else {
				long longValue = number.longValue();
				isNegative = longValue < 0;
				if (isNegative) {
					if (longValue >= Integer.MIN_VALUE) {
						number = Integer.valueOf((int)longValue);
					}
					else {
						number = Long.valueOf(longValue);
					}
				}
				else {
					if (longValue <= Integer.MAX_VALUE) {
						number = Integer.valueOf((int)longValue);
					}
					else {
						number = Long.valueOf(longValue);
					}
				}
			}				
			if (isNegative) {
				@NonNull IntegerLiteralExp pivotElement = context.refreshModelElement(IntegerLiteralExp.class, PivotPackage.Literals.INTEGER_LITERAL_EXP, csElement);
				pivotElement.setIntegerSymbol(number);
			}
			else {
				@NonNull UnlimitedNaturalLiteralExp pivotElement = context.refreshModelElement(UnlimitedNaturalLiteralExp.class, PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP, csElement);
				pivotElement.setUnlimitedNaturalSymbol(number);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitOperatorCS(@NonNull OperatorCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPrefixExpCS(@NonNull PrefixExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPrimitiveLiteralExpCS(@NonNull PrimitiveLiteralExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitSelfExpCS(@NonNull SelfExpCS csElement) {
		context.refreshModelElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitStringLiteralExpCS(@NonNull StringLiteralExpCS csElement) {
		@NonNull StringLiteralExp pivotElement = context.refreshModelElement(StringLiteralExp.class, PivotPackage.Literals.STRING_LITERAL_EXP, csElement);
		List<String> names = csElement.getName();
		if (names.size() == 0) {
			pivotElement.setStringSymbol("");
		}
		else if (names.size() == 1) {
			pivotElement.setStringSymbol(names.get(0));
		}
		else {
			StringBuilder s = new StringBuilder();
			for (String name : names) {
				s.append(name);
			}
			pivotElement.setStringSymbol(s.toString());
		}
		return null;
	}

	@Override
	public Continuation<?> visitTupleLiteralExpCS(@NonNull TupleLiteralExpCS csElement) {
		@NonNull TupleLiteralExp pivotElement = context.refreshModelElement(TupleLiteralExp.class, PivotPackage.Literals.TUPLE_LITERAL_EXP, csElement);	
		context.refreshPivotList(TupleLiteralPart.class, pivotElement.getPart(), csElement.getOwnedParts());
		return null;
	}

	@Override
	public Continuation<?> visitTupleLiteralPartCS(@NonNull TupleLiteralPartCS csElement) {
		refreshNamedElement(TupleLiteralPart.class, PivotPackage.Literals.TUPLE_LITERAL_PART, csElement);	
		return null;
	}

	@Override
	public Continuation<?> visitTypeLiteralExpCS(@NonNull TypeLiteralExpCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTypeNameExpCS(@NonNull TypeNameExpCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		assert pathName != null;
		CS2Pivot.setElementType(pathName, PivotPackage.Literals.TYPE, csElement, null);
		return null;
	}

	@Override
	public Continuation<?> visitUnlimitedNaturalLiteralExpCS(@NonNull UnlimitedNaturalLiteralExpCS csElement) {
		@NonNull UnlimitedNaturalLiteralExp pivotElement = context.refreshModelElement(UnlimitedNaturalLiteralExp.class, PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP, csElement);
		pivotElement.setName("*");
		pivotElement.setUnlimitedNaturalSymbol(Unlimited.INSTANCE);
		return null;
	}

	@Override
	public Continuation<?> visitVariableCS(@NonNull VariableCS csElement) {
		refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, csElement);
		return null;
	}
}