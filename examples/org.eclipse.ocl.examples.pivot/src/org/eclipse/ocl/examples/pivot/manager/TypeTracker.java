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
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;

import com.google.common.base.Function;

/**
 * A TypeTracker adapts a Type to coordinate the coherent behaviour of one or more
 * merged Types as required for Complete OCL type extension.
 */
class TypeTracker implements Adapter.Internal
{
	public static Function<TypeTracker, DomainType> tracker2type = new Function<TypeTracker, DomainType>()
	{
		public DomainType apply(TypeTracker typeTracker) {
			return typeTracker.getType();
		}
	};

	protected final @NonNull ExtensibleTypeServer typeServer;

	/**
	 * The Type tracked by this tracker.
	 */
	private final @NonNull DomainType type;
	
	TypeTracker(@NonNull ExtensibleTypeServer typeServer, @NonNull DomainType type) {
		this.typeServer = typeServer;
		this.type = type;
		assert !(type instanceof ExtensibleTypeServer);
		if (type instanceof Notifier) {
			((Notifier)type).eAdapters().add(this);
		}
	}

	public void dispose() {
		typeServer.disposedTypeTracker(this);
		if (type instanceof Notifier) {
			((Notifier)type).eAdapters().remove(this);
		}
	}

	public final Notifier getTarget() {
		return type instanceof Notifier ? (Notifier)type : null;
	}

	public final @NonNull DomainType getType() {
		return type;
	}
	
	public @NonNull ExtensibleTypeServer getTypeServer() {
		return typeServer;
	}
	
	public final boolean isAdapterForType(Object type) {
		return type == typeServer.getPackageManager();
	}

	/**
	 * Observe any superclass changes and uninstall all affected Inheritances.
	 */
	public void notifyChanged(Notification notification) {
		if (notification.getNotifier() != type) {
			return;
		}
		int eventType = notification.getEventType();
		Object feature = notification.getFeature();
		if (feature == PivotPackage.Literals.TYPE__OWNED_OPERATION) {
			switch (eventType) {
				case Notification.ADD: {
					Object value = notification.getNewValue();
					if (value instanceof Operation) {
						typeServer.addedMemberOperation((Operation) value);
					}
					break;
				}
				case Notification.ADD_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getNewValue();
					for (Object value : values) {
						if (value instanceof Operation) {
							typeServer.addedMemberOperation((Operation) value);
						}
					}
					break;
				}
				case Notification.REMOVE: {
					Object value = notification.getOldValue();
					if (value instanceof Operation) {
						typeServer.removedMemberOperation((Operation) value);
					}
					break;
				}
				case Notification.REMOVE_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getOldValue();
					for (Object value : values) {
						if (value instanceof Operation) {
							typeServer.removedMemberOperation((Operation) value);
						}
					}
					break;
				}
			}
		}
		else if (feature == PivotPackage.Literals.TYPE__OWNED_ATTRIBUTE) {
			switch (eventType) {
				case Notification.ADD: {
					Object value = notification.getNewValue();
					if (value instanceof Property) {
						typeServer.addedMemberProperty((Property) value);
					}
					break;
				}
				case Notification.ADD_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getNewValue();
					for (Object value : values) {
						if (value instanceof Property) {
							typeServer.addedMemberProperty((Property) value);
						}
					}
					break;
				}
				case Notification.REMOVE: {
					Object value = notification.getOldValue();
					if (value instanceof Property) {
						typeServer.removedMemberProperty((Property) value);
					}
					break;
				}
				case Notification.REMOVE_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getOldValue();
					for (Object value : values) {
						if (value instanceof Property) {
							typeServer.removedMemberProperty((Property) value);
						}
					}
					break;
				}
			}
		}
		else if (feature == PivotPackage.Literals.TYPE__SUPER_CLASS) {
			switch (eventType) {
				case Notification.ADD:
				case Notification.ADD_MANY:
				case Notification.REMOVE:
				case Notification.REMOVE_MANY:
				case Notification.RESOLVE:
				case Notification.SET:
				case Notification.UNSET:
					typeServer.changedInheritance();
					break;
			}
		}
		else if (feature == PivotPackage.Literals.NAMED_ELEMENT__NAME) {
			switch (eventType) {
				case Notification.SET:
				case Notification.UNSET:
					PackageServer packageServer = typeServer.getPackageServer();
					dispose();
					packageServer.addedMemberType(type);
					break;
			}
		}
	}

	public void setTarget(Notifier newTarget) {
		assert type == newTarget;
	}

	@Override
	public String toString() {
		return String.valueOf(type);
	}

	public void unsetTarget(Notifier oldTarget) {
		assert type == oldTarget;
	}
}