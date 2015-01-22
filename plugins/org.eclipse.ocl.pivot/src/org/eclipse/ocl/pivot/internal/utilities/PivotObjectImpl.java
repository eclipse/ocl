/*******************************************************************************
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.pivot.utilities.PivotObject;

public abstract class PivotObjectImpl extends EObjectImpl implements PivotObject
{
	private EObject target;

	@Override
	protected void eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID) {
		if (newContainer != null) {
			EObject oldContainer = eInternalContainer();
			assert (oldContainer == null) || oldContainer.eIsProxy() || (newContainer == oldContainer) || (oldContainer.eResource() == null);
		}		
		super.eBasicSetContainer(newContainer, newContainerFeatureID);
	}
	
	public EObject getETarget() {
		return target;
	}

	@Override
	public Object getImage() {
		return null;
	}
	
	@Override
	public EObject getTarget() {
		return target;
	}
	
	@Override
	public String getText() {
		return toString();
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == PivotObjectImpl.class;
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setTarget(Notifier newTarget) {
		target = (EObject) newTarget;
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		target = null;
	}
}
