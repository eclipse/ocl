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
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.scoping.AbstractRootCSAttribution;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS;

public class ContextCSAttribution extends AbstractRootCSAttribution
{
	public static final @NonNull ContextCSAttribution INSTANCE = new ContextCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
		ContextCS targetElement = (ContextCS)target;
		environmentView.addRootPackages();
		ExpressionInOCL pivot = PivotUtil.getPivot(ExpressionInOCL.class, targetElement);
		if ((pivot != null) && !environmentView.hasFinalResult()) {
			Variable contextVariable = pivot.getContextVariable();
			if ((contextVariable != null)/* && (contextVariable.getType() != null)*/) {
				Variable resultVariable = pivot.getResultVariable();
				if (resultVariable != null) {
					environmentView.addNamedElement(resultVariable);
				}
				for (Variable parameterVariable : pivot.getParameterVariable()) {
					assert parameterVariable != null;
					environmentView.addNamedElement(parameterVariable);
				}
				Type contextType = contextVariable.getType();
				if (contextType != null) {
					environmentView.addNamedElement(contextVariable);
				}
				if (!environmentView.hasFinalResult()) {
					if (contextType != null) {
						if (contextType instanceof Metaclass<?>) {			// FIXME is this really right - needed by test_stereotypeM2Navigation for implicit self of an base_xxx
							contextType = ((Metaclass<?>)contextType).getInstanceType();	// Many usages have been confused test context objects
						}
						if (contextType instanceof Enumeration) {
							environmentView.addAllEnumerationLiterals((Enumeration)contextType);
						}
						if (contextType != null) {
							environmentView.addAllOperations(contextType, null);
							environmentView.addAllProperties(contextType, null);
							environmentView.addAllStates(contextType);
	//						environmentView.addAllElements(contextType, scopeView);
	//						if (!environmentView.hasFinalResult()) {
	//							environmentView.addElementsOfScope(type.getPackage(), scopeView);
	//						}
						}
					}
				}
	//			if (!environmentView.hasFinalResult()) {
					if (contextType == null) {
						contextType = metaModelManager.getOclAnyType();
					}
					environmentView.addElementsOfScope(contextType.getPackage(), scopeView);
					if (!environmentView.hasFinalResult()) {
						org.eclipse.ocl.examples.pivot.Package contextPackage = contextType.getPackage();
						if (contextPackage != null) {
							PackageId metapackageId = metaModelManager.getMetapackageId(contextPackage);
							DomainPackage mmPackage = metaModelManager.getIdResolver().getPackage(metapackageId);
							if (mmPackage instanceof Element) {
								environmentView.addElementsOfScope((Element)mmPackage, scopeView);
							}
						}
					}
	//			}
			}
			else {
				Resource resource = target.eResource();
				if (resource instanceof BaseResource) {
					ParserContext parserContext = ((BaseResource)resource).getParserContext();
					if (parserContext != null) {
						Type contextType = parserContext.getClassContext();
						if (contextType != null) {
							environmentView.computeLookups(contextType, null);
							if (!environmentView.hasFinalResult()) {
								environmentView.addElementsOfScope(contextType.getPackage(), scopeView);
							}
						}
					}
				}
			}
	//		if (!environmentView.hasFinalResult()) {
	//			environmentView.addRootPackages();
	//		}
			if (!environmentView.hasFinalResult()) {
				Resource eResource = pivot.eResource();
				if (eResource != null) {
					URI baseURI = eResource.getURI();
					if (baseURI != null) {
						URI nonPivotBaseURI = PivotUtil.getNonASURI(baseURI);
						String nonPivotScheme = nonPivotBaseURI.scheme();
						if ((nonPivotScheme != null) && !"null".equals(nonPivotScheme)) {			// FIXME Is this obsolete code
							environmentView.addImportedElement(baseURI);
						}
					}
				}
			}
	//		if (!environmentView.hasFinalResult()) {
	//			environmentView.addElementsOfScope(metaModelManager.getOclAnyType().getPackage(), scopeView);
	//		}
		}
		return super.computeLookup(targetElement, environmentView, scopeView);
	}
}
