/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

public class AS2MonikerVisitor extends AbstractExtendingVisitor<Object, AS2Moniker> implements PivotConstants
{	
	private static boolean initialized = false;
	
	public static void initialize() {
		if (!initialized) {
			initialized = true;
			roleNames.put(PivotPackage.Literals.LOOP_EXP__BODY, "argument");
//			roleNames.put(PivotPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION, "ownedExpression");
	
			/*		roleNames.put(PivotPackage.Literals.CALL_EXP__SOURCE, "s");
			roleNames.put(PivotPackage.Literals.CONSTRAINT__SPECIFICATION, "z");
			roleNames.put(PivotPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION, "x");
			roleNames.put(PivotPackage.Literals.IF_EXP__CONDITION, "q");
			roleNames.put(PivotPackage.Literals.IF_EXP__THEN_EXPRESSION, "t");
			roleNames.put(PivotPackage.Literals.IF_EXP__ELSE_EXPRESSION, "f");
			roleNames.put(PivotPackage.Literals.LET_EXP__IN, "i");
			roleNames.put(PivotPackage.Literals.LET_EXP__VARIABLE, "v");
			roleNames.put(PivotPackage.Literals.LOOP_EXP__BODY, "b");
			roleNames.put(PivotPackage.Literals.LOOP_EXP__ITERATOR, "i");
			roleNames.put(PivotPackage.Literals.OPERATION_CALL_EXP__ARGUMENT, "a");
			roleNames.put(PivotPackage.Literals.VARIABLE__INIT_EXPRESSION, "i");
	*/	}
	}
	
	protected final @Nullable Map<TemplateParameter, ParameterableElement> templateBindings;
	
	public AS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
		templateBindings = null;
		if (!initialized) {
			initialize();
		}
	}

	public AS2MonikerVisitor(@NonNull AS2Moniker context, @Nullable Map<TemplateParameter, ParameterableElement> templateBindings) {
		super(context);
		this.templateBindings = templateBindings;
	}

	public void appendExpPrefix(@NonNull NamedElement object) {
		EObject parent = object.eContainer();
		if (parent instanceof CallExp) {
			CallExp callExpParent = (CallExp)parent;
			if (callExpParent.isImplicit()) {
				if (callExpParent instanceof IteratorExp) {		// Bypass implicit collect
					if (callExpParent.getSource() == object) {
						context.appendElement(((IteratorExp)callExpParent).getBody());
						context.append(MONIKER_SCOPE_SEPARATOR);
						context.appendRole(object);
						context.append(MONIKER_OPERATOR_SEPARATOR);
						return;
					}
					else {
						context.appendParent(callExpParent, MONIKER_SCOPE_SEPARATOR);
						context.appendRole(callExpParent);
						context.append(MONIKER_OPERATOR_SEPARATOR);
						return;
					}
				}
				else if (callExpParent.getSource() == object) {
					object = callExpParent;
				}
			}
		}
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		context.appendRole(object);
		context.append(MONIKER_OPERATOR_SEPARATOR);
	}

	@Override
	public String toString() {
		return context.toString();
	}

	@Override
	public Object visitAnnotation(@NonNull Annotation object) {
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		context.append(ANNOTATION_QUOTE);
		context.append(String.valueOf(object.getName()));
		context.append(ANNOTATION_QUOTE);
		Object container = object.eContainer().eGet(object.eContainingFeature());
		if (container instanceof List<?>) {
			int index = 0;
			for (Object element : (List<?>)container) {
				if (element == object) {
					break;
				}
				if ((element instanceof Annotation) && (((Annotation)element).getName().equals(object.getName()))) {
					index++;
				}
			}
			if (index > 0) {
				context.append(index);
			}
		}
		return true;
	}

	@Override
	public Object visitBooleanLiteralExp(@NonNull BooleanLiteralExp object) {
		appendExpPrefix(object);
		context.append(Boolean.toString(object.isBooleanSymbol()));
		return true;
	}

	@Override
	public Object visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		TemplateParameter owningTemplateParameter = object.getOwningTemplateParameter();
		if (owningTemplateParameter != null) {		
			if (templateBindings != null) {
				ParameterableElement parameterableElement = templateBindings.get(owningTemplateParameter);
				if ((parameterableElement != null) && (parameterableElement != object) ){
					context.appendElement(parameterableElement);
					return true;
				}
			}
			TemplateableElement owningTemplateElement = owningTemplateParameter.getSignature().getTemplate();
			if (!context.hasEmitted(owningTemplateParameter)/* || !context.isTemplateParameter(owningTemplateParameter)*/) {
				context.appendElement(owningTemplateElement);
				context.append(TEMPLATE_PARAMETER_PREFIX);
			}
			context.appendName(object);
		}
		else if (!object.getTemplateBinding().isEmpty()) {
			Type templateableClass = PivotUtil.getUnspecializedTemplateableElement(object);
			context.appendParent(templateableClass, MONIKER_SCOPE_SEPARATOR);
			context.appendName(templateableClass);
			context.appendTemplateBindings(object, templateBindings);
		}
		else if (object.eContainer() instanceof TemplateParameterSubstitution) {
			TemplateParameter formal = ((TemplateParameterSubstitution)object.eContainer()).getFormal();
			int index = formal.getSignature().getOwnedParameter().indexOf(formal);
			context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
			context.append(WILDCARD_INDICATOR + index);
		}
		else {
			context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
			context.appendName(object);
			context.appendTemplateParameters(object);
		}
		if (object instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)object;
			Number lower = collectionType.getLower();
			Number upper = collectionType.getUpper();
			if ((lower.longValue() != 0) || !(upper instanceof Unlimited)) {
				context.append("_" + lower);
				if (!(upper instanceof Unlimited)) {
					context.append("_" + upper);
				}
			}
		}
		return true;
	}

	@Override
	public Object visitCollectionLiteralExp(@NonNull CollectionLiteralExp object) {
		appendExpPrefix(object);
		context.appendName(object.getType());
		return true;
	}

	@Override
	public Object visitCollectionLiteralPart(@NonNull CollectionLiteralPart object) {
		context.appendParent(object, MONIKER_PART_SEPARATOR);
		context.appendIndex(object);
		return true;
	}

	@Override
	public Object visitConstraint(@NonNull Constraint object) {
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		context.append(PivotUtil.getStereotype(object));
		Object container = object.eContainer().eGet(object.eContainingFeature());
		if (container instanceof List<?>) {		
			int index = 0;
			String name2 = object.getName();
			for (Object content : (List<?>)container) {
				if (content == object) {
					break;
				}
				if (content instanceof Constraint) {
					Constraint sibling = (Constraint) content;
					if (PivotUtil.getStereotype(sibling).equals(PivotUtil.getStereotype(object))) {
						String name1 = sibling.getName();
						if (name1 != name2) {
							if ((name1 == null) || !name1.equals(name2)) {
								break;
							}
						}
						index++;
					}
				}
			}
			context.append(MONIKER_OPERATOR_SEPARATOR);
			if (name2 != null) {
				context.append(name2);
			}
			if (index != 0) {
				context.append(MONIKER_OPERATOR_SEPARATOR);
				context.append(index);
			}
		}
		return true;
	}

	@Override
	public String visitConstructorExp(@NonNull ConstructorExp constructorExp) {
		appendExpPrefix(constructorExp);
		context.append(MONIKER_TUPLE_LITERAL_EXP);
//		appendQualifiedName(constructorExp.getReferredType());
//		append("{");//$NON-NLS-1$
//		String prefix = "";
//		for (TupleLiteralPart part : constructorExp.getPart()) {
//			append(prefix);
//           safeVisit(part);
//			prefix = ", ";//$NON-NLS-1$
//		}
//		append("}");
		return null;
	}

	@Override
	public Object visitDetail(@NonNull Detail object) {
		context.appendParent(object, BINDINGS_PREFIX);
		context.append(object.getName());
		return true;
	}

	@Override
	public Object visitEnumLiteralExp(@NonNull EnumLiteralExp object) {
		appendExpPrefix(object);
		context.appendName(object.getReferredEnumLiteral());
		return true;
	}

	@Override
	public Object visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		if (object.eContainer() != null) {
			context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
			context.appendRole(object);		
		}
		else {
			context.append(MONIKER_ROOT_EXP);
		}
		return true;
	}

	@Override
	public Object visitIfExp(@NonNull IfExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_IF_EXP);
		return true;
	}

	@Override
	public Object visitIntegerLiteralExp(@NonNull IntegerLiteralExp object) {
		appendExpPrefix(object);
		context.append(object.getIntegerSymbol().toString());
		return true;
	}

	@Override
	public Object visitInvalidLiteralExp(@NonNull InvalidLiteralExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_INVALID_LITERAL_EXP);
		return true;
	}

	@Override
	public Object visitLambdaType(@NonNull LambdaType object) {
		context.append(object.getName());
//		context.appendTemplateParameters(object);
		Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, object);
		context.appendLambdaType(object.getContextType(), object.getParameterType(), object.getResultType(), bindings);
		return true;
	}

	@Override
	public Object visitLetExp(@NonNull LetExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_LET_EXP);
		return true;
	}

	@Override
	public Object visitLoopExp(@NonNull LoopExp object) {
		appendExpPrefix(object);
		if (object.isImplicit()) {
			OCLExpression body = object.getBody();
			if (body instanceof CallExp) {
				Feature referredFeature = PivotUtil.getReferredFeature((CallExp) body);
				context.appendName(referredFeature);
				return true;
			}
		}
		context.appendName(object.getReferredIteration());
		return true;
	}

	@Override
	public Object visitNamedElement(@NonNull NamedElement object) {
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitNullLiteralExp(@NonNull NullLiteralExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_NULL_LITERAL_EXP);
		return true;
	}

	@Override
	public Object visitOperation(@NonNull Operation object) {
		TemplateParameter owningTemplateParameter = object.getOwningTemplateParameter();
		if (owningTemplateParameter != null) {			// FIXME does this happen ?
			TemplateableElement owningTemplateElement = owningTemplateParameter.getSignature().getTemplate();
			if (!context.hasEmitted(owningTemplateParameter)/* || !context.isTemplateParameter(owningTemplateParameter)*/) {
				context.appendElement(owningTemplateElement);
				context.append(TEMPLATE_PARAMETER_PREFIX);
			}
			context.appendName(object);
		}
		else if (!object.getTemplateBinding().isEmpty()) {
			context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
			context.appendName(object);
			Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, object);
			if (templateBindings != null) {
				if (bindings == null) {
					bindings = templateBindings;
				}
				else {
					// FIXME merge templateBindings
				}
			}
			context.appendTemplateBindings(object, bindings);
			context.appendParameters(object, bindings);
			return true;
		}
		else {
			context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
			context.appendName(object);
			context.appendTemplateParameters(object);
			context.appendParameters(object, null);
		}
		return true;
	}

	@Override
	public Object visitOperationCallExp(@NonNull OperationCallExp object) {
		appendExpPrefix(object);
		context.appendName(object.getReferredOperation());
		return true;
	}

	@Override
	public Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp object) {
		appendExpPrefix(object);
		context.append("~");
		context.appendName(object.getReferredProperty());
		return true;
	}

	@Override
	public Object visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package object) {
//		if (!object.hasMoniker()) {
//			throw new IllegalStateException("No moniker has been configured for " + object);
//		}
		context.append(PivotUtil.getNsURI(object));
		return true;
	}

	@Override
	public Object visitPrecedence(@NonNull Precedence object) {
		context.appendParent(object, PRECEDENCE_PREFIX);
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitPrimitiveType(@NonNull PrimitiveType object) {
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitPropertyCallExp(@NonNull PropertyCallExp object) {
		appendExpPrefix(object);
		context.appendName(object.getReferredProperty());
		return true;
	}

	@Override
	public Object visitRealLiteralExp(@NonNull RealLiteralExp object) {
		appendExpPrefix(object);
		context.append(object.getRealSymbol().toString());
		return true;
	}

	@Override
	public Object visitRoot(@NonNull Root object) {
		context.append(MONIKER_ROOT);
		return true;
	}

	@Override
	public Object visitStringLiteralExp(@NonNull StringLiteralExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_STRING_LITERAL_EXP);
		return true;
	}

	@Override
	public Object visitTemplateBinding(@NonNull TemplateBinding object) {
		TemplateSignature signature = object.getSignature();
		if (signature != null) {
			context.appendElement(signature.getTemplate());
		}
		context.append(BINDINGS_PREFIX);
		return true;
	}

	@Override
	public Object visitTemplateParameter(@NonNull TemplateParameter object) {
		TemplateableElement owningTemplateElement = object.getSignature().getTemplate();
		context.appendElement(owningTemplateElement);
		context.append(TEMPLATE_PARAMETER_PREFIX);
		context.appendName(object.getParameteredElement());
		return true;
	}

	@Override
	public Object visitTemplateParameterSubstitution(@NonNull TemplateParameterSubstitution object) {
		context.appendElement(object.getTemplateBinding());
		context.appendName(object.getFormal().getParameteredElement());
		return true;
	}

	@Override
	public Object visitTemplateSignature(@NonNull TemplateSignature object) {
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		return true;
	}

	@Override
	public Object visitTupleLiteralExp(@NonNull TupleLiteralExp object) {
		appendExpPrefix(object);
		context.append(MONIKER_TUPLE_LITERAL_EXP);
		return true;
	}

	@Override
	public Object visitTupleType(@NonNull TupleType object) {
		List<Property> ownedAttributes = object.getOwnedAttribute();
		if (ownedAttributes.isEmpty()) {
			super.visitTupleType(object);
		}
		else {
			context.appendName(object);
			context.appendTupleType(ownedAttributes);
		}
		return true;
	}

	@Override
	public Object visitTypeExp(@NonNull TypeExp object) {
		appendExpPrefix(object);
		context.appendName(object.getReferredType());
		return true;
	}

	@Override
	public Object visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp object) {
		appendExpPrefix(object);
		Number unlimitedNaturalSymbol = object.getUnlimitedNaturalSymbol();
		context.append(unlimitedNaturalSymbol.toString());
		return true;
	}

	@Override
	public Object visitVariable(@NonNull Variable object) {
		appendExpPrefix(object);
		context.appendName(object);
		return true;
	}

	@Override
	public Object visitVariableExp(@NonNull VariableExp object) {
		appendExpPrefix(object);
		context.appendName(object.getReferredVariable());
		return true;
	}

	public Object visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}	
}
