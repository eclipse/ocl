/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;

public class EssentialOCLUtils	// FIXME Find some extensible instantiation echanism
{
	/**
	 * Return the element associated with csElement for which there is a
	 * pivot element with an identical moniker.
	 * @param csElement
	 * @return the csElement with a matching pivot element
	 */
	public static ModelElementCS getPivotedCS(EObject csElement) {
		if (csElement instanceof InfixExpCS) {
			OperatorCS csOperator = ((InfixExpCS)csElement).getOwnedOperator();
			while (csOperator.getParent() != null) {
				csOperator = csOperator.getParent();
			}
			return getPivotedCS(csOperator);
		}
		else if (csElement instanceof NavigatingArgCS) {
			return getPivotedCS(((NavigatingArgCS)csElement).getOwnedNameExpression());
		}
		else if (csElement instanceof NavigationOperatorCS) {
			return getPivotedCS(((NavigationOperatorCS)csElement).getArgument());
		}
		else if (csElement instanceof NestedExpCS) {
			return getPivotedCS(((NestedExpCS)csElement).getSource());
		}
		else if (csElement instanceof PrefixExpCS) {
			return getPivotedCS(((PrefixExpCS)csElement).getOwnedOperators().get(0));
		}
		else if (csElement instanceof ModelElementCS) {
			return (ModelElementCS) csElement;
		}
		else {
			return null;
		}
	}

	/**
	 * Return the CS element from the CS elements associated with the
	 * same pivot element as csElement, whose child-parent relationship
	 * corresponds to the child-parent relationship of the pivot element.
	 * 
	 * @param csElement for which the child counterpart is required
	 * @return the child counterpart
	 */
	public static ElementCS getPivotingChildCS(ElementCS csElement) {
//		assert csElement == getPivotedCS(csElement);
		if (csElement == null) {
			return csElement;
		}
		if (csElement instanceof ExpCS) {
			OperatorCS operator = ((ExpCS) csElement).getParent();
			if ((operator instanceof NavigationOperatorCS) && (csElement != operator.getSource())) {
				return getPivotingChildCS(operator);
			}
			else if (operator != null) {
				return csElement;
			}
		}
		if (csElement instanceof NavigatingArgCS) {
			return csElement;
		}
		EObject csParent = csElement.eContainer();
		if (csParent instanceof InfixExpCS) {
			return getPivotingChildCS((InfixExpCS) csParent);
		}
		else if (csParent instanceof NavigatingArgCS) {
			return (NavigatingArgCS) csParent;
		}
		else if (csParent instanceof NameExpCS) {
			return getPivotingChildCS((NameExpCS) csParent);
		}
		else if (csParent instanceof NestedExpCS) {
			return getPivotingChildCS((NestedExpCS) csParent);
		}
		else if (csParent instanceof PrefixExpCS) {
			return getPivotingChildCS((PrefixExpCS) csParent);
		}
		else {
			return csElement;
		}
	}

	// FIXME Simplify since csElement is the immediate child
	public static ModelElementCS getPivotingParentCS(ElementCS csElement) {
		if (csElement == null) {
			return null;
		}
		//		assert csElement == getPivotingChildCS(csElement);
		if (csElement instanceof ExpCS) {
			OperatorCS operator = ((ExpCS) csElement).getParent();
			if (operator != null) {
				return operator;
			}
		}
		EObject csParent = csElement.eContainer();
		if (csParent instanceof ModelElementCS) {
			return (ModelElementCS) csParent;
		}
		else {
			return null;
		}
	}

	// FIXME Simplify since csElement is the immediate child
	public static EReference getPivotingFeature(ElementCS csChildElement, ElementCS csParentElement) {
		if (csChildElement == null) {
			return null;
		}
		assert csChildElement == getPivotingChildCS(csChildElement);
		assert csParentElement == getPivotingParentCS(csChildElement);
		if (csParentElement instanceof OperatorCS) {
			if (((OperatorCS)csParentElement).getSource() == csChildElement) {
				return EssentialOCLCSPackage.Literals.OPERATOR_CS__SOURCE;
			}
			else {
				return EssentialOCLCSPackage.Literals.BINARY_OPERATOR_CS__ARGUMENT;
			}
		}
		return (EReference) csChildElement.eContainingFeature();
/*		EObject csParent = csChildElement.eContainer();
		if (csParent instanceof InfixExpCS) {
			return getPivotingFeature((InfixExpCS) csParent);
		}
		else if (csParent instanceof NavigatingArgCS) {
//			return EssentialOCLCSPackage.Literals.NAVIGATING_EXP_CS__ARGS; //getParentChildFeature((NavigatingArgCS) csParent);
			return getPivotingFeature((NavigatingArgCS) csParent);
		}
		else if (csParent instanceof InvocationExpCS) {
			InvocationExpCS csNavigatingExp = (InvocationExpCS)csParent;
			if (csChildElement == csNavigatingExp.getNamedExp()) {
				return getPivotingFeature(csNavigatingExp.getParent());
			}
			else {
				return EssentialOCLCSPackage.Literals.NAVIGATING_EXP_CS__ARGUMENT;
			}
		}
		else if (csParent instanceof NestedExpCS) {
			return getPivotingFeature((NestedExpCS) csParent);
		}
		else if (csParent instanceof PrefixExpCS) {
			return getPivotingFeature((PrefixExpCS) csParent);
		}
		else {
			return (EReference) csChildElement.eContainingFeature();
		} */
	}
}
