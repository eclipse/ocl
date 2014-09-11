package org.eclipse.ocl.examples.pivot.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

public class PackageListeners
{
	public static interface IPackageListener
	{
		void didAddClass(@NonNull org.eclipse.ocl.examples.pivot.Class asClass);
		void didRemoveClass(@NonNull org.eclipse.ocl.examples.pivot.Class asClass);
//		void didRenameClass(@NonNull org.eclipse.ocl.examples.pivot.Class asClass, String oldName);
	}
	
	private @NonNull List<WeakReference<IPackageListener>> listeners = new ArrayList<WeakReference<IPackageListener>>();

	public synchronized void addListener(@NonNull IPackageListener packageListener) {
		for (WeakReference<IPackageListener> ref : listeners) {
			IPackageListener listener = ref.get();
			if (listener == packageListener) {
				return;
			}
		}
		listeners.add(new WeakReference<IPackageListener>(packageListener));
	}

	public synchronized void didAddClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
		boolean doFlush = false;
		for (WeakReference<IPackageListener> ref : listeners) {
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
		for (WeakReference<IPackageListener> ref : listeners) {
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

/*	public synchronized void didRenameClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass, String oldName) {
		boolean doFlush = false;
		for (WeakReference<IPackageListener> ref : listeners) {
			IPackageListener listener = ref.get();
			if (listener != null) {
				listener.didRenameClass(partialClass, oldName);
			}
			else {
				doFlush = true;
			}
		}
		if (doFlush) {
			doFlush();
		} 
	} */

	private void doFlush() {
		for (int i = listeners.size(); --i >= 0; ) {
			IPackageListener completeListener = listeners.get(i).get();
			if (completeListener == null) {
				listeners.remove(i);
			}
		}
	}
}