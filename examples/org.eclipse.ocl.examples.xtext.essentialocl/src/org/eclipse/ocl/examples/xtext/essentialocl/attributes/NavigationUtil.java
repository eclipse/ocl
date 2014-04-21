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
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS;

public class NavigationUtil
{
	/**
	 * Return the NavigationOperatorCS for which csExp is the left node of the navigation operator's argument tree.
	 */
	public static @Nullable NavigationOperatorCS getNavigationOperator(@NonNull AbstractNameExpCS csExp) {
		EObject eContainer = csExp.eContainer();
		if (eContainer instanceof AbstractNameExpCS) {
			csExp = (AbstractNameExpCS) eContainer;
		}
		for (ExpCS csChild = csExp; true; csChild = csChild.getParent()) {
			OperatorCS csOperator = csChild.getParent();
			if (csOperator == null) {
				return null;
			}
			ExpCS csSource = csOperator.getSource();
			if (csSource == csChild) {									// e.g.    ... -> (X... -> ...)
				;
			}
			else if (csOperator instanceof NavigationOperatorCS) {		// e.g 	   ... -> X
				return (NavigationOperatorCS) csOperator;
			}
			else {														// e.g.    ... and X
				return null;
			}
		}
	}

	public static boolean isIteration(@NonNull MetaModelManager metaModelManager, @NonNull InvocationExpCS csInvocationExp, @NonNull CollectionType type) {
		for (NavigatingArgCS csArg : csInvocationExp.getArgument()) {
			if (csArg.getRole() != NavigationRole.EXPRESSION) {
				return true;
			}
		}
		PathNameCS pathName = csInvocationExp.getPathName();
		List<PathElementCS> path = pathName.getPath();
		if (path.size() != 1) {
			return false;
		}
		PathElementCS csPathElement = path.get(0);
		Element unresolvedElement = csPathElement.basicGetElement();
		if ((unresolvedElement != null) && !unresolvedElement.eIsProxy()) {
			return unresolvedElement instanceof Iteration;
		}
		String name = csPathElement.toString();
		assert name != null;
		for (DomainOperation operation : metaModelManager.getAllOperations(type, FeatureFilter.SELECT_NON_STATIC, name)) {
			return operation instanceof Iteration;		// mixed overload are not allowed
		}
		return false;
	}
}
