/*******************************************************************************
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *******************************************************************************/
package org.eclipse.ocl.examples.standalone.validity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.ResultSet;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.locator.ConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.locator.EClassConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.locator.EClassifierConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.locator.EValidatorConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;
import org.eclipse.ocl.examples.validity.locator.PivotConstraintLocator;
import org.eclipse.ocl.examples.validity.locator.UMLConstraintLocator;

public class StandaloneValidityManager extends ValidityManager
{
	private boolean runOCLConstraints = false;
	private boolean runJavaConstraints = false;
	private boolean runUMLConstraints = false;

	public StandaloneValidityManager() {}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager
	 * #createModel(java.util.Collection)
	 */
	@Override
	protected @NonNull ValidityModel createModel(@NonNull Collection<Resource> newResources) {
		return new StandaloneValidityModel(this, newResources);
	}

	private static @NonNull List<ConstrainingNode> getConstrainingNodeAncestors(@NonNull ConstrainingNode constraining) {
		ConstrainingNode ancestor = constraining.getParent();
		List<ConstrainingNode> ancestors = new ArrayList<ConstrainingNode>();
		while (ancestor != null) {
			ancestors.add(ancestor);
			ancestor = ancestor.getParent();
		}
		return ancestors;
	}

	public @NonNull List<ConstraintLocator> getInUseConstraintLocators(@NonNull String nsURI) {
		List<ConstraintLocator> list = new ArrayList<ConstraintLocator>();

		if (runOCLConstraints) {
			PivotConstraintLocator pivotConstraintsLocator = new PivotConstraintLocator();
			list.add(pivotConstraintsLocator);
		}

		if (runJavaConstraints) {
			EClassConstraintLocator eClassConstraintsLocator = new EClassConstraintLocator();
			list.add(eClassConstraintsLocator);
			EClassifierConstraintLocator eClassifierConstraintsLocator = new EClassifierConstraintLocator();
			list.add(eClassifierConstraintsLocator);
			EValidatorConstraintLocator eValidatorConstraintsLocator = new EValidatorConstraintLocator();
			list.add(eValidatorConstraintsLocator);
		}

		if (runUMLConstraints) {
			UMLConstraintLocator umlConstraintsLocator = new UMLConstraintLocator();
			list.add(umlConstraintsLocator);
		}
		return list;
	}

	public void runValidation() {
		final ResultSet resultSet = createResultSet(new NullProgressMonitor());
		List<Result> results = installResultSet(resultSet, new NullProgressMonitor());
		for (Result result : results) {
			try {
				ValidatableNode validatable = result.getValidatableNode();
				ValidatableNode validatableParent = validatable.getParent();
				LeafConstrainingNode constraint = result
						.getLeafConstrainingNode();

				if (constraint != null) {
					List<ConstrainingNode> constrainingAncestors = getConstrainingNodeAncestors(constraint);

					boolean isConstrainingNodeEnabled = true;
					for (ConstrainingNode constrainingAncestor : constrainingAncestors) {
						if (!constrainingAncestor.isEnabled()) {
							isConstrainingNodeEnabled = false;
							break;
						}
					}

					boolean isEnabledForValidation = false;
					if (isConstrainingNodeEnabled) {
						if (validatable instanceof ResultValidatableNode) {
							if (validatableParent != null
									&& validatableParent.isEnabled()) {
								isEnabledForValidation = true;
							}
						} else {
							isEnabledForValidation = true;
						}
					}

					if (isEnabledForValidation) {
						ConstraintLocator constraintLocator = constraint
								.getConstraintLocator();
						constraintLocator.validate(result,
								StandaloneValidityManager.this, null);
					} else {
						result.setSeverity(Severity.UNKNOWN);
					}
				} else {
					result.setSeverity(Severity.UNKNOWN);
				}
			} catch (Exception e) {
				result.setException(e);
				result.setSeverity(Severity.FATAL);
			}
		}
	}

	public void setRunJavaConstraints(boolean runJavaConstraints) {
		this.runJavaConstraints = runJavaConstraints;
	}
	
	public void setRunOCLConstraints(boolean runOCLConstraints) {
		this.runOCLConstraints = runOCLConstraints;
	}
	
	public void setRunUMLConstraints(boolean runUMLConstraints) {
		this.runUMLConstraints = runUMLConstraints;
	}
}
