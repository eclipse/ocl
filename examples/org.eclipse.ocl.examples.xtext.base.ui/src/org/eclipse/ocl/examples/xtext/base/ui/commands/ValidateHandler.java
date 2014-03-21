/**
 * <copyright>
 *
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.ui.commands;

import java.lang.reflect.Method;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.HandlerEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ocl.examples.pivot.uml.UMLOCLEValidator;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.UMLPackage;

public class ValidateHandler extends ValidateAction implements IHandler//2
{
	protected final static class Diagnostician_2_8 extends Diagnostician
	{
		private final AdapterFactory adapterFactory;

		protected Diagnostician_2_8(EValidator.Registry eValidatorRegistry, AdapterFactory adapterFactory) {
			super(eValidatorRegistry);
			this.adapterFactory = adapterFactory;
		}

		@Override
		public String getObjectLabel(EObject eObject) {
			if (adapterFactory != null && !eObject.eIsProxy()) {
				IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(eObject, IItemLabelProvider.class);
				if (itemLabelProvider != null) {
					return itemLabelProvider.getText(eObject);
				}
			}
			return super.getObjectLabel(eObject);
		}
	}
	protected final static class Diagnostician_2_9 extends Diagnostician
	{
		private final ResourceSet resourceSet;
		private final AdapterFactory adapterFactory;
		private final IProgressMonitor progressMonitor;

		protected Diagnostician_2_9(EValidator.Registry eValidatorRegistry, ResourceSet resourceSet,
				AdapterFactory adapterFactory, IProgressMonitor progressMonitor) {
			super(eValidatorRegistry);
			this.resourceSet = resourceSet;
			this.adapterFactory = adapterFactory;
			this.progressMonitor = progressMonitor;
		}

		@Override
		public String getObjectLabel(EObject eObject) {
			if (adapterFactory != null && !eObject.eIsProxy()) {
				IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(eObject, IItemLabelProvider.class);
				if (itemLabelProvider != null) {
					return itemLabelProvider.getText(eObject);
				}
			}
			return super.getObjectLabel(eObject);
		}

		@Override
		protected boolean doValidate(EValidator eValidator, EClass eClass, EObject eObject,
				DiagnosticChain diagnostics, Map<Object, Object> context) {
			progressMonitor.worked(1);
			synchronized (resourceSet) {
				return super.doValidate(eValidator, eClass, eObject, diagnostics, context);
			}
		}
	}

	private static Boolean diagnosticianHasDoValidate = null; // Use 2.9/2.8 Diagnostician

	protected static boolean diagnosticianHasDoValidate() {
		for (Method method : Diagnostician.class.getDeclaredMethods()) {
			if ("doValidate".equals(method.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @see IHandler#addHandlerListener(IHandlerListener)
	 */
	public void addHandlerListener(final IHandlerListener handlerListener) {
		addListenerObject(handlerListener);
	}

	@Override
	protected Diagnostician createDiagnostician(final AdapterFactory adapterFactory, final IProgressMonitor progressMonitor) {
		final ResourceSet resourceSet = domain.getResourceSet();
		EValidatorRegistryImpl registry = new EValidatorRegistryImpl();
		registry.put(UMLPackage.eINSTANCE, UMLOCLEValidator.INSTANCE);
		if (diagnosticianHasDoValidate == null) {
			diagnosticianHasDoValidate = false;
			for (Method method : Diagnostician.class.getDeclaredMethods()) {
				if ("doValidate".equals(method.getName())) {
					diagnosticianHasDoValidate = true;
				}
			}
		}
		if (diagnosticianHasDoValidate) {
			return new Diagnostician_2_9(registry, resourceSet, adapterFactory, progressMonitor);
		}
		else {
			return new Diagnostician_2_8(registry, adapterFactory);
		}
	}

	/**
	 * The default implementation does nothing. Subclasses who attach listeners
	 * to other objects are encouraged to detach them in this method.
	 * 
	 * @see org.eclipse.core.commands.IHandler#dispose()
	 */
	public void dispose() {
		// Do nothing.
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart part = HandlerUtil.getActivePart(event);
		setActiveWorkbenchPart(part);
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			setEnabled(updateSelection((IStructuredSelection) selection));
		} else {
			setEnabled(false);
		}
		run();
		return null;
	}

	/**
	 * Fires an event to all registered listeners describing changes to this
	 * instance.
	 * <p>
	 * Subclasses may extend the definition of this method (i.e., if a different
	 * type of listener can be attached to a subclass). This is used primarily
	 * for support of <code>AbstractHandler</code> in
	 * <code>org.eclipse.ui.workbench</code>, and clients should be wary of
	 * overriding this behaviour. If this method is overridden, then the first
	 * line of the method should be "<code>super.fireHandlerChanged(handlerEvent);</code>".
	 * </p>
	 * 
	 * @param handlerEvent
	 *            the event describing changes to this instance. Must not be
	 *            <code>null</code>.
	 */
	protected void fireHandlerChanged(final HandlerEvent handlerEvent) {
		if (handlerEvent == null) {
			throw new NullPointerException();
		}

		final Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			final IHandlerListener listener = (IHandlerListener) listeners[i];
			listener.handlerChanged(handlerEvent);
		}
	}

	/**
	 * <p>
	 * Returns true iff there is one or more IHandlerListeners attached to this
	 * AbstractHandler.
	 * </p>
	 * <p>
	 * Subclasses may extend the definition of this method (i.e., if a different
	 * type of listener can be attached to a subclass). This is used primarily
	 * for support of <code>AbstractHandler</code> in
	 * <code>org.eclipse.ui.workbench</code>, and clients should be wary of
	 * overriding this behaviour. If this method is overridden, then the return
	 * value should include "<code>super.hasListeners() ||</code>".
	 * </p>
	 * 
	 * @return true iff there is one or more IHandlerListeners attached to this
	 *         AbstractHandler
	 */
	protected boolean hasListeners() {
		return isListenerAttached();
	}

	/**
	 * @see IHandler#removeHandlerListener(IHandlerListener)
	 */
	public void removeHandlerListener(final IHandlerListener handlerListener) {
		removeListenerObject(handlerListener);
	}
}
