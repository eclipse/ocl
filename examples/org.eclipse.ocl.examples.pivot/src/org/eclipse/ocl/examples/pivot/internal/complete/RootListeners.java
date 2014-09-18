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

public class RootListeners<L extends RootListeners.IRootListener> extends AbstractListeners<L>
{
	public static interface IRootListener extends AbstractListeners.IAbstractListener
	{
		void didAddPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage);
		void didRemovePackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage);
	}

	public synchronized void didAddPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		boolean doFlush = false;
		for (WeakReference<L> ref : listeners) {
			L listener = ref.get();
			if (listener != null) {
				listener.didAddPackage(partialPackage);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		}
	}

	public synchronized void didRemovePackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		boolean doFlush = false;
		for (WeakReference<L> ref : listeners) {
			L listener = ref.get();
			if (listener != null) {
				listener.didRemovePackage(partialPackage);
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