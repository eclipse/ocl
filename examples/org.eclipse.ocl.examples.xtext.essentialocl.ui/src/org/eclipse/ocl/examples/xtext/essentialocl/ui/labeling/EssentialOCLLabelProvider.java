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
package org.eclipse.ocl.examples.xtext.essentialocl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS;

import com.google.inject.Inject;

/**
 * Provides labels for EssentialOCL CS objects.
 * <p>
 * The outline normally displays the result of CST to AST redirection using the
 * labels defined by BaseLabelProvider. However when there are syntax errors there
 * is no AST and so CST labels are used.
 */
public class EssentialOCLLabelProvider extends BaseLabelProvider
{
	@Inject
	public EssentialOCLLabelProvider(@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected void appendTemplateParameter(@NonNull StringBuilder s, TemplateParameterCS templateParameter) {
		appendName(s, templateParameter);
	}

	@Override
	protected void appendType(@NonNull StringBuilder s, Type type) {
		if (type instanceof CollectionTypeCS) {
			appendName(s, (CollectionTypeCS)type);
			s.append("(");
			appendType(s, ((CollectionTypeCS)type).getOwnedType());
			s.append(")");
		}
		else if (type instanceof TupleTypeCS) {
			appendName(s, (TupleTypeCS)type);
			s.append("Tuple(");
			String prefix = "";
			for (TuplePartCS part : ((TupleTypeCS)type).getOwnedParts()) {
				s.append(prefix);
				appendName(s, part);
				s.append(" : ");
				appendType(s, part.getOwnedType());
				prefix = ", ";
			}
			s.append(")");
		}
		else if (type instanceof NameExpCS) {
//			appendName(s, ((NameExpCS)type).getNamedElement());
		}
		else {
			super.appendType(s, type);
		}	
	}

/*	protected String text(InfixExpCS ele) {
		String op = ele.getOp();
		if (!".".equals(op) &&  !"->".equals(op)) {
			return op;
		}
	StringBuilder s = new StringBuilder();
	appendString(s, op);
	ExpCS argument = ele.getArgument();
	if (argument instanceof NamedExpCS) {
		s.append(" ");
		appendName(s, ((NamedExpCS)argument).getName().getNamedElement());
		if (((NamedExpCS) argument).isPre()) {
			s.append(" @pre");
		}
	}
	return s.toString();
	} */

	protected String text(BooleanLiteralExpCS ele) {
		return String.valueOf(ele.getName());
	}

	protected String text(ExpCS ele) {
		return "<<" + ele.eClass().getName() + ">>";
	}

	protected String text(InvalidLiteralExpCS ele) {
		return "invalid";
	}

	protected String text(InvocationExpCS ele) {
		NamedElement namedElement = ele.getNamedElement();
		return String.valueOf(namedElement != null ? namedElement.getName() : null);
	}

	protected String text(NameExpCS ele) {
		return String.valueOf(ele.getPathName().toString());
	}

	protected String text(NavigatingArgCS ele) {
		return "<" + String.valueOf(ele.getRole()).toLowerCase() + ">";
	}

	protected String text(NestedExpCS ele) {
		return "(   )";
	}

	protected String text(NullLiteralExpCS ele) {
		return "null";
	}

	protected String text(NumberLiteralExpCS ele) {
		return String.valueOf(ele.getName());
	}

	protected String image(OperatorCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/OperationCallExp.gif";
	}

	protected String text(OperatorCS ele) {
		return String.valueOf(ele.getName());
	}

	protected String image(SelfExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/VariableExp.gif";
	}

	protected String text(SelfExpCS ele) {
		return "self";
	}

	protected String text(StringLiteralExpCS ele) {
		return String.valueOf(ele.getName());
	}

}
