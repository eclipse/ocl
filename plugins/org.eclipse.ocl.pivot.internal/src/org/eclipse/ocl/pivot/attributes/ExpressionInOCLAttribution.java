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
package org.eclipse.ocl.pivot.attributes;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.scoping.ScopeView;

public class ExpressionInOCLAttribution extends AbstractAttribution
{
	public static final ExpressionInOCLAttribution INSTANCE = new ExpressionInOCLAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ExpressionInOCL targetExpression = (ExpressionInOCL) target;
		Variable contextVariable = targetExpression.getOwnedContext();
		for (Variable parameterVariable : targetExpression.getOwnedParameters()) {
			assert parameterVariable != null;
			environmentView.addNamedElement(parameterVariable);
		}
		Variable resultVariable = targetExpression.getOwnedResult();
		if (resultVariable != null) {
			environmentView.addNamedElement(resultVariable);
		}
		if (contextVariable != null) {
			Type type = contextVariable.getType();
			MetaModelManager metaModelManager = environmentView.getMetaModelManager();
			if (type != null) {
				environmentView.addNamedElement(contextVariable);
			}
			else {
				type = metaModelManager.getStandardLibrary().getOclVoidType();
			}
			if (!environmentView.hasFinalResult()) {
				Type userType = /*type instanceof Metaclass<?> ? ((Metaclass<?>)type).getInstanceType() :*/ type;// FIXME is this really right - needed by test_stereotypeM2Navigation for implicit self of an base_xxx
				if (userType instanceof org.eclipse.ocl.pivot.Class) {
					Package contextPackage = ((org.eclipse.ocl.pivot.Class)userType).getOwningPackage();
					if (contextPackage != null) {
						if (targetExpression.eContainer() == null) {
							environmentView.addRootPackages();
							environmentView.addAllPackages(contextPackage);
						}
						if (!environmentView.hasFinalResult()) {
							environmentView.addElementsOfScope(contextPackage, scopeView);
						}
						if ((targetExpression.eContainer() == null) /*&& !environmentView.hasFinalResult()*/) {
							environmentView.addRootPackages();
							environmentView.addAllPackages(contextPackage);
							if (!environmentView.hasFinalResult()) {
								environmentView.addElementsOfScope(contextPackage, scopeView);
								if (environmentView.accepts(PivotPackage.Literals.TYPE)) {
									for (Type gType : metaModelManager.getGlobalTypes()) {
										if (gType != null) {
											environmentView.addNamedElement(gType);
										}
									}
								}
								if (environmentView.accepts(PivotPackage.Literals.NAMESPACE)) {
									for (Map.Entry<String, Namespace> entry : metaModelManager.getGlobalNamespaces()) {
										String key = entry.getKey();
										Namespace value = entry.getValue();
										if ((key != null) && (value != null)) {
											environmentView.addElement(key, value);
										}
									}
								}
							}
						}
					}
				}
			}
			if (!environmentView.hasFinalResult()) {
				environmentView.addElementsOfScope(type, scopeView);
			}
		}
		return scopeView.getParent();
	}
}
