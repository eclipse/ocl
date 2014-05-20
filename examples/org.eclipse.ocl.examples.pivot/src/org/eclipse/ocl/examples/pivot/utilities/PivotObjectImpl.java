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
package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.examples.domain.elements.Labelable;

public abstract class PivotObjectImpl extends EObjectImpl implements PivotObject, Adapter.Internal, Labelable
{
	private EObject target;

	@Override
	protected void eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID) {
		if (newContainer != null) {
			EObject oldContainer = eContainer();
			assert ((oldContainer == null) || (newContainer == oldContainer) || (oldContainer.eResource() == null));
		}		
		super.eBasicSetContainer(newContainer, newContainerFeatureID);
	}

	@Override
	public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain msgs) {
		if (newContainer != null) {
			EObject oldContainer = eContainer();
			assert ((oldContainer == null) || (newContainer == oldContainer) || (oldContainer.eResource() == null));
		}		
		return super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
	}
	
	public EObject getETarget() {
		return target;
	}

	public Object getImage() {
		return null;
	}
	
	public EObject getTarget() {
		return target;
	}
	
	public String getText() {
		return toString();
	}

	public boolean isAdapterForType(Object type) {
		return type == PivotObject.class;
	}
	
	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
		
	}
	
	public void setTarget(Notifier newTarget) {
		target = (EObject) newTarget;
	}

	public void unsetTarget(Notifier oldTarget) {
		target = null;
	}
}
