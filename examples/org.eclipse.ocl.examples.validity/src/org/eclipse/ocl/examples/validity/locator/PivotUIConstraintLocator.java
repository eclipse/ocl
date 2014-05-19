/**
 * <copyright>
 *
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.validity.locator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.launching.OCLLaunchConstants;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ui.locator.ConstraintUILocator;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

public class PivotUIConstraintLocator extends PivotConstraintLocator implements ConstraintUILocator
{
	public static @NonNull PivotUIConstraintLocator INSTANCE = new PivotUIConstraintLocator();

	@Override
	public boolean debug(@NonNull ResultConstrainingNode resultConstrainingNode, final @NonNull ValidityView validityView, @NonNull IProgressMonitor monitor) throws CoreException {
		final Object object = resultConstrainingNode.getParent().getConstrainingObject();
		if (!(object instanceof Constraint)) {
			throw new IllegalStateException("non-Constraint " + object);
//			return false;
		}
		Constraint constraint = (Constraint)object;
		URI constraintURI = EcoreUtil.getURI(constraint);
        Path path = new Path(constraintURI.toPlatformString(true));
		OpaqueExpression specification = constraint.getSpecification();
		String string = specification != null ? PrettyPrinter.print(specification) : "";
		IPath trimmedPath = path.removeLastSegments(1);
		IContainer folder = (IContainer) ResourcesPlugin.getWorkspace().getRoot().findMember(trimmedPath);
		Path tailPath = new Path(constraint.getName() + ".essentialocl");
		final IFile file = folder.getFile(tailPath);
		file.create(new URIConverter.ReadableInputStream(string, "UTF-8"), false, null);
		
		ValidatableNode parent = resultConstrainingNode.getResultValidatableNode().getParent();
		if (parent == null) {
			return false;
		}
		EObject eObject = parent.getConstrainedObject();
		URI contextURI = EcoreUtil.getURI(eObject);

		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(OCLLaunchConstants.LAUNCH_CONFIGURATION_TYPE_ID);
		ILaunchConfigurationWorkingCopy launchConfiguration = launchConfigurationType.newInstance(folder, constraint.getName());
		launchConfiguration.setAttribute(OCLLaunchConstants.CONSTRAINT_URI, constraintURI.toString());
		launchConfiguration.setAttribute(OCLLaunchConstants.CONTEXT_URI, contextURI.toString());
//		launchConfiguration.doSave();
		launchConfiguration.launch(ILaunchManager.DEBUG_MODE, new NullProgressMonitor());
		return true;
	}
}