/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.validity.locator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.debug.launching.OCLLaunchConstants;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ui.locator.ConstraintUILocator;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LanguageExpression;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.validity.plugin.OCLValidityPlugin;
import org.eclipse.ocl.examples.xtext.console.XtextConsolePlugin;
import org.eclipse.ocl.examples.xtext.console.messages.ConsoleMessages;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;

public class PivotUIConstraintLocator extends PivotConstraintLocator implements ConstraintUILocator
{
    /**
     * The DebugStarter sequences the start up of the debugger off the thread.
     */
    protected static class DebugStarter implements IRunnableWithProgress
	{
		protected final @NonNull Shell shell;
    	protected final @NonNull MetaModelManager metaModelManager;
    	protected final @Nullable EObject contextObject;
    	protected final @NonNull ExpressionInOCL constraint;
    	private @Nullable ILaunch launch = null;

		public DebugStarter(@NonNull Shell shell, @NonNull MetaModelManager metaModelManager, @Nullable EObject contextObject, @NonNull ExpressionInOCL constraint) {
			this.shell = shell;
			this.metaModelManager = metaModelManager;
			this.contextObject = contextObject;
			this.constraint = constraint;
		}
		
		public ILaunch getLaunch() {
			return launch;
		}

		/**
		 * Create and launch an internal launch configuration to debug expressionInOCL applied to contextObject.
		 */
		protected ILaunch launchDebugger(IProgressMonitor monitor, @Nullable EObject contextObject, @NonNull ExpressionInOCL expressionInOCL) throws CoreException {
			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(OCLLaunchConstants.LAUNCH_CONFIGURATION_TYPE_ID);
			ILaunchConfigurationWorkingCopy launchConfiguration = launchConfigurationType.newInstance(null, "test" /*constraint.getName()*/);
			Map<String,Object> attributes = new HashMap<String,Object>();
			attributes.put(OCLLaunchConstants.EXPRESSION_OBJECT, expressionInOCL);
			attributes.put(OCLLaunchConstants.CONTEXT_OBJECT, contextObject);
			launchConfiguration.setAttributes(attributes);
			return launchConfiguration.launch(ILaunchManager.DEBUG_MODE, monitor);
		}

		protected void openError(final String message, final @NonNull Exception e) {
			shell.getDisplay().asyncExec(new Runnable()
			{
				@Override
				public void run() {
					IStatus status = new Status(IStatus.ERROR, XtextConsolePlugin.PLUGIN_ID, e.getLocalizedMessage(), e);
					ErrorDialog.openError(shell, ConsoleMessages.Debug_Starter, message, status);
				}
			});
		}

		@Override
		public void run(IProgressMonitor monitor) {
			String expression = constraint.toString();
			monitor.beginTask(NLS.bind(ConsoleMessages.Debug_Starter, expression), 1);
			try {
				monitor.subTask(ConsoleMessages.Debug_ProgressLoad);
				try {
					launch = launchDebugger(monitor, contextObject, constraint);
				} catch (CoreException e) {
					openError(ConsoleMessages.Debug_FailLaunch, e);
				}
				monitor.worked(1);
			}
			finally {
				monitor.done();
			}
		}
	}

    public static @NonNull PivotUIConstraintLocator INSTANCE = new PivotUIConstraintLocator();

	public static @NonNull IStatus createStatus(Throwable e, String messageTemplate, Object... bindings) {
		String message = DomainUtil.bind(messageTemplate, bindings);
		return new Status(IStatus.ERROR, OCLValidityPlugin.PLUGIN_ID, 0, message, e);
	}

	@Override
	public boolean debug(@NonNull ResultConstrainingNode resultConstrainingNode, final @NonNull ValidityView validityView, @NonNull IProgressMonitor monitor) throws CoreException {
		ValidatableNode validatableNode = resultConstrainingNode.getResultValidatableNode().getParent();
		assert validatableNode != null;
		EObject constrainedObject = validatableNode.getConstrainedObject();
		Resource eResource = constrainedObject.eResource();
		if (eResource == null) {
			return false;
		}
		MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(eResource);
		Constraint asConstraint = null;
		Object constrainingObject = resultConstrainingNode.getParent().getConstrainingObject();
		if (constrainingObject instanceof Constraint) {
			asConstraint = (Constraint)constrainingObject;
		}
		if (asConstraint == null) {
			IStatus status = createStatus(null, OCLMessages.MissingSpecification_ERROR_, EcoreUtils.qualifiedNameFor(asConstraint), PivotConstants.OWNED_RULE_ROLE);
			throw new CoreException(status);
		}
		LanguageExpression specification = asConstraint.getSpecification();
		if (specification == null) {
			IStatus status = createStatus(null, OCLMessages.MissingSpecificationBody_ERROR_, EcoreUtils.qualifiedNameFor(asConstraint), PivotConstants.OWNED_RULE_ROLE);
			throw new CoreException(status);
		}
		ExpressionInOCL query;
		try {
			query = metaModelManager.getQueryOrThrow(specification);
		} catch (ParserException e) {
			IStatus status = createStatus(e, OCLMessages.InvalidSpecificationBody_ERROR_, EcoreUtils.qualifiedNameFor(asConstraint), PivotConstants.OWNED_RULE_ROLE);
			throw new CoreException(status);
		}
		ValidatableNode parent = resultConstrainingNode.getResultValidatableNode().getParent();
		if (parent == null) {
			return false;
		}
		EObject eObject = parent.getConstrainedObject();
		
		Shell shell = validityView.getSite().getShell();
		if (shell == null) {
			return false;
		}
		DebugStarter runnable = new DebugStarter(shell, metaModelManager, eObject, query);
		runnable.run(monitor);
		return runnable.getLaunch() != null;
	}
}
