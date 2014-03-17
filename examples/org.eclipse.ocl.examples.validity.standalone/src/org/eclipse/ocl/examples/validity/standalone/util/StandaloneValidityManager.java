/**
 * <copyright>
 *
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.validity.standalone.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
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
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.IDEValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityViewRefreshJob;
import org.eclipse.ocl.examples.validity.locator.PivotConstraintLocator;
import org.eclipse.ocl.examples.validity.locator.UMLConstraintLocator;

public class StandaloneValidityManager extends IDEValidityManager {

	private static boolean runOCLConstraints = false;
	private static boolean runJavaConstraints = false;
	private static boolean runUMLConstraints = false;

	public static @Nullable
	List<ConstraintLocator> getConstraintLocators(@NonNull String nsURI) {
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


	public StandaloneValidityManager(ValidityViewRefreshJob refreshJob) {
		super(refreshJob);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager
	 * #createModel(java.util.Collection)
	 */
	@Override
	protected @NonNull
	ValidityModel createModel(@NonNull Collection<Resource> newResources) {
		return new StandaloneValidityModel(this, newResources);
	}

	@Override
	public void runValidation(@NonNull ValidityView validityView) {
		final ResultSet resultSet = createResultSet(new NullProgressMonitor());
		List<Result> results = installResultSet(resultSet,
				new NullProgressMonitor());
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

	private static @NonNull
	List<ConstrainingNode> getConstrainingNodeAncestors(
			@NonNull ConstrainingNode constraining) {
		ConstrainingNode ancestor = constraining.getParent();
		List<ConstrainingNode> ancestors = new ArrayList<ConstrainingNode>();
		while (ancestor != null) {
			ancestors.add(ancestor);
			ancestor = ancestor.getParent();
		}
		return ancestors;
	}
	
	
	public static void setRunJavaConstraints(boolean runJavaConstraints) {
		StandaloneValidityManager.runJavaConstraints = runJavaConstraints;
	}
	
	public static void setRunOCLConstraints(boolean runOCLConstraints) {
		StandaloneValidityManager.runOCLConstraints = runOCLConstraints;
	}
	
	public static void setRunUMLConstraints(boolean runUMLConstraints) {
		StandaloneValidityManager.runUMLConstraints = runUMLConstraints;
	}
}
