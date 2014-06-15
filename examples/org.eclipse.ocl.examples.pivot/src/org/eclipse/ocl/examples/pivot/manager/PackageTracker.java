/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;

import com.google.common.base.Function;

/**
 * A PackageTracker adapts a Package to keep the overall managed meta-model in tune with any changes.
 */
class PackageTracker implements Adapter.Internal
{	
	public static Function<PackageTracker, DomainPackage> tracker2package = new Function<PackageTracker, DomainPackage>()
	{
		public DomainPackage apply(PackageTracker packageTracker) {
			return packageTracker.getPackage();
		}
	};

	protected final @NonNull PackageServer packageServer;
	
	/**
	 * The Package tracked by this tracker.
	 */
	private final @NonNull DomainPackage target;

	PackageTracker(@NonNull PackageServer packageServer, @NonNull DomainPackage target) {
		this.packageServer = packageServer;
		this.target = target;
		assert !(target instanceof PackageServer);
		if (target instanceof Notifier) {
			((Notifier)target).eAdapters().add(this);
		}
	}

	void dispose() {
		PackageManager packageManager = packageServer.getPackageManager();
		for (DomainType type : target.getOwnedType()) {
			if (type != null) {
				packageManager.removedType(type);
			}
		}
		packageServer.disposedPackageTracker(this);
		if (target instanceof Notifier) {
			((Notifier)target).eAdapters().remove(this);
		}
	}

	public @NonNull DomainPackage getPackage() {
		return target;
	}

	/**
	 * Return the PackageServer supervising this package merge.
	 */
	final @NonNull PackageServer getPackageServer() {
		return packageServer;
	}

	/**
	 * Return the primary Package of this package merge.
	 *
	@NonNull DomainPackage getPrimaryPackage() {
		return packageServer.getPrimaryPackage();
	} */

	public Notifier getTarget() {
		return target instanceof Notifier ? (Notifier)target : null;
	}

	public boolean isAdapterForType(Object type) {
		return type == packageServer.getPackageManager();
	}

	public void notifyChanged(Notification notification) {
		int eventType = notification.getEventType();
		Object feature = notification.getFeature();
		if (feature == PivotPackage.Literals.PACKAGE__OWNED_TYPE) {
			switch (eventType) {
				case Notification.ADD: {
					Object value = notification.getNewValue();
					if (value instanceof Type) {
						packageServer.addedMemberType((Type)value);
					}
					break;
				}
				case Notification.ADD_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getNewValue();
					for (Object value : values) {
						if (value instanceof Type) {
							packageServer.addedMemberType((Type)value);
						}
					}
					break;
				}
				case Notification.REMOVE: {
					Object value = notification.getOldValue();
					if (value instanceof Type) {
						packageServer.removedMemberType((Type) value);
					}
					break;
				}
				case Notification.REMOVE_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getOldValue();
					for (Object value : values) {
						if (value instanceof Type) {
							packageServer.removedMemberType((Type) value);
						}
					}
					break;
				}
			}
		}
		else if (feature == PivotPackage.Literals.PACKAGE__NESTED_PACKAGE) {
			switch (eventType) {
				case Notification.ADD: {
					Object value = notification.getNewValue();
					if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
						packageServer.addedMemberPackage((org.eclipse.ocl.examples.pivot.Package)value);
					}
					break;
				}
				case Notification.ADD_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getNewValue();
					for (Object value : values) {
						if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
							packageServer.addedMemberPackage((org.eclipse.ocl.examples.pivot.Package)value);
						}
					}
					break;
				}
				case Notification.REMOVE: {
					Object value = notification.getOldValue();
					if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
						packageServer.removedMemberPackage((org.eclipse.ocl.examples.pivot.Package)value);
					}
					break;
				}
				case Notification.REMOVE_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getOldValue();
					for (Object value : values) {
						if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
							packageServer.removedMemberPackage((org.eclipse.ocl.examples.pivot.Package)value);
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
		return target.getName() + " : " + target.getNsURI();
	}

	public void unsetTarget(Notifier oldTarget) {
		assert target == oldTarget;
	}
}