/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.complete;

import java.lang.ref.WeakReference;

import org.eclipse.jdt.annotation.NonNull;

public class PackageListeners<L extends PackageListeners.IPackageListener> extends ModelListeners<L>
{
	public static interface IPackageListener extends IModelListener
	{
		void didAddClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass);
		void didRemoveClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass);
	}

	public synchronized void didAddClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
		boolean doFlush = false;
		for (WeakReference<L> ref : listeners) {
			IPackageListener listener = ref.get();
			if (listener != null) {
				listener.didAddClass(partialClass);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		}
	}

	public synchronized void didRemoveClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
		boolean doFlush = false;
		for (WeakReference<L> ref : listeners) {
			IPackageListener listener = ref.get();
			if (listener != null) {
				listener.didRemoveClass(partialClass);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		}
	}
}