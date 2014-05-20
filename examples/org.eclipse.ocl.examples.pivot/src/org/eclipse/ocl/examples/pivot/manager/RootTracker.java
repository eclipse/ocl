/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Root;

/**
 * A RootTracker adapts a Root to keep the overall managed meta-model in tune with any changes.
 */
class RootTracker implements Adapter.Internal
{	
	protected final PackageManager packageManager;
	
	/**
	 * The Package tracked by this tracker.
	 */
	private final Root target;

	RootTracker(@NonNull PackageManager packageManager, @NonNull Root target) {
		this.packageManager = packageManager;
		this.target = target;
		target.eAdapters().add(this);
	}

	void dispose() {
		packageManager.disposedRootTracker(this);
		target.eAdapters().remove(this);
	}

	@SuppressWarnings("null")
	public @NonNull Root getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		return type == packageManager;
	}

	public void notifyChanged(Notification notification) {
		int eventType = notification.getEventType();
		Object feature = notification.getFeature();
		if (feature == PivotPackage.Literals.ROOT__NESTED_PACKAGE) {
			switch (eventType) {
				case Notification.ADD: {
					Object value = notification.getNewValue();
					if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
						packageManager.addedMemberPackage((org.eclipse.ocl.examples.pivot.Package)value);
					}
					break;
				}
				case Notification.ADD_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getNewValue();
					for (Object value : values) {
						if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
							packageManager.addedMemberPackage((org.eclipse.ocl.examples.pivot.Package)value);
						}
					}
					break;
				}
				case Notification.REMOVE: {
					Object value = notification.getOldValue();
					if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
						packageManager.removedPackage((org.eclipse.ocl.examples.pivot.Package)value);
					}
					break;
				}
				case Notification.REMOVE_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getOldValue();
					for (Object value : values) {
						if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
							packageManager.removedPackage((org.eclipse.ocl.examples.pivot.Package)value);
						}
					}
					break;
				}
			}
		}
	}

	public void setTarget(Notifier newTarget) {
		assert target == newTarget;
	}

	@Override
	public String toString() {
		return String.valueOf(target);
	}

	public void unsetTarget(Notifier oldTarget) {
		assert target == oldTarget;
	}
}