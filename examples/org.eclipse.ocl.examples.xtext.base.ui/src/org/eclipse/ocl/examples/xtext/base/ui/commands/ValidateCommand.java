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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.HandlerEvent;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.uml.UMLOCLEValidator;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

public class ValidateCommand extends ValidateAction
{
	protected abstract static class PivotDiagnostician extends Diagnostician
	{
		protected final AdapterFactory adapterFactory;

		protected PivotDiagnostician(@NonNull EValidator.Registry eValidatorRegistry, ResourceSet resourceSet, AdapterFactory adapterFactory) {
			super(eValidatorRegistry);
			this.adapterFactory = adapterFactory;
			if (resourceSet != null) {
				OCLDelegateDomain.initializePivotOnlyDiagnosticianResourceSet(resourceSet);
			}
		}
		
		@Override
		public Map<Object, Object> createDefaultContext() {
			Map<Object, Object> context = super.createDefaultContext();
		    if (context != null) {
		    	OCLDelegateDomain.initializePivotOnlyDiagnosticianContext(context);
		    }
			return context;
		}
		
		@Override
		public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
			if (eClass != null) {
				EPackage ePackage = eClass.getEPackage();
				if (ePackage != null) {
					EObject eContainer = ePackage.eContainer();
					if (eContainer instanceof EAnnotation) {
						EObject eContainerContainer = eContainer.eContainer();
						if (eContainerContainer instanceof Profile) {
							return true;		// Stereotype applications are validated where they applied
						}
					}
				}
			}
			
			return super.validate(eClass, eObject, diagnostics, context);
		}
	}

	protected final static class Diagnostician_2_8 extends PivotDiagnostician
	{
		protected Diagnostician_2_8(@NonNull EValidator.Registry eValidatorRegistry, ResourceSet resourceSet, AdapterFactory adapterFactory) {
			super(eValidatorRegistry, resourceSet, adapterFactory);
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
	protected final static class Diagnostician_2_9 extends PivotDiagnostician
	{
		private final ResourceSet resourceSet;
		private final IProgressMonitor progressMonitor;

		protected Diagnostician_2_9(@NonNull EValidator.Registry eValidatorRegistry, ResourceSet resourceSet,
				AdapterFactory adapterFactory, IProgressMonitor progressMonitor) {
			super(eValidatorRegistry, resourceSet, adapterFactory);
			this.resourceSet = resourceSet;
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

	@Override
	protected Diagnostician createDiagnostician(final AdapterFactory adapterFactory, final IProgressMonitor progressMonitor) {
		final ResourceSet resourceSet = domain.getResourceSet();
		EValidatorRegistryImpl registry = new EValidatorRegistryImpl();
		registry.put(UMLPackage.eINSTANCE, UMLOCLEValidator.NO_NEW_LINES);
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
			return new Diagnostician_2_8(registry, resourceSet, adapterFactory);
		}
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

	@Override
	public void setActiveWorkbenchPart(IWorkbenchPart workbenchPart) {
		Object object = workbenchPart.getAdapter(EditingDomain.class);
		if (object instanceof EditingDomain) {
			domain = (EditingDomain)object;
			return;
		}
		object = workbenchPart.getAdapter(IEditingDomainProvider.class);
		if (object instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider)object).getEditingDomain();
			return;
		}
		if (workbenchPart instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider) workbenchPart).getEditingDomain();
		}
	}

	@Override
	public boolean updateSelection(IStructuredSelection selection) {
		selectedObjects = new ArrayList<EObject>();
		for (Iterator<?> objects = selection.iterator(); objects.hasNext();) {
			Object object = AdapterFactoryEditingDomain.unwrap(objects.next());
			if (object instanceof IAdaptable) {
				object = ((IAdaptable) object).getAdapter(EObject.class);
			}
			if (object instanceof EObject) {
				selectedObjects.add((EObject) object);
			} else if (object instanceof Resource) {
				selectedObjects.addAll(((Resource) object).getContents());
			} else {
				return false;
			}
		}
		selectedObjects = EcoreUtil.filterDescendants(selectedObjects);
		return !selectedObjects.isEmpty();
	}
}
