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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteClassImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;

public abstract class AbstractCompleteClasses extends EObjectContainmentWithInverseEList<CompleteClass>
{
	public static final @NonNull TracingOption COMPLETE_CLASSES = new TracingOption(PivotPlugin.PLUGIN_ID, "completeClasses");
//	static { COMPLETE_CLASSES.setState(true); }
	private static final long serialVersionUID = 1L;

	protected @Nullable Map<String, CompleteClass> name2completeClass = null;

	public AbstractCompleteClasses(@NonNull CompletePackageImpl owner) {
		super(CompleteClass.class, owner, PivotPackage.COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES, PivotPackage.COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE);
		if (COMPLETE_CLASSES.isActive()) {
			COMPLETE_CLASSES.println("Create " + this);
		}
	}

	@Override
	protected void didAdd(int index, CompleteClass completeClass) {
		assert completeClass != null;
		super.didAdd(index, completeClass);
		didAdd(completeClass);
	}
	
	public void didAdd(@NonNull CompleteClass completeClass) {
		Map<String, CompleteClass> name2completeClass2 = name2completeClass;
		if (name2completeClass2 != null) {
			String name = completeClass.getName();
			if (name != null) {
				CompleteClass oldCompleteClass = name2completeClass2.put(name, completeClass);
				assert oldCompleteClass == null;
			}
		}
	}

	public void didAddClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
		if (name2completeClass != null) {
			CompleteClass completeClass = name2completeClass.get(partialClass.getName());
			if (completeClass == null) {
				doRefreshPartialClass(partialClass);
			}
			else {
				completeClass.getPartialClasses().add(partialClass);
			}
		}
	}

	public void didAddPackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		if (name2completeClass != null) {
			doRefreshPartialClasses(partialPackage);
		}
	}

	@Override
	protected void didRemove(int index, CompleteClass completeClass) {
		assert completeClass != null;
		didRemove(completeClass);
		super.didRemove(index, completeClass);
	}

	protected void didRemove(@NonNull CompleteClass completeClass) {
		Map<String, CompleteClass> name2completeClass2 = name2completeClass;
		if (name2completeClass2 != null) {
			String name = completeClass.getName();
			if (name != null) {
				CompleteClass oldCompleteClass = name2completeClass2.remove(name);
				assert oldCompleteClass == completeClass;
			}
		}
	}

	public void didRemoveClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
		if (name2completeClass != null) {
			CompleteClass completeClass = name2completeClass.get(partialClass.getName());
			if ((completeClass != null) && ((CompleteClassImpl)completeClass).didRemoveClass(partialClass)) {
				remove(partialClass);
				((CompleteClassImpl)completeClass).dispose();
			}
		}
		if (partialClass.getUnspecializedElement() == null) {
			getCompleteModel().didRemoveClass(partialClass);
		}
	}

	public void didRemovePackage(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		Map<String, CompleteClass> name2completeClass2 = name2completeClass;
		if (name2completeClass2 != null) {
			for (org.eclipse.ocl.examples.pivot.Class partialClass : partialPackage.getOwnedClasses()) {
				if (partialClass != null) {
					didRemoveClass(partialClass);
				}
			}
		}
	}
	
	protected abstract void doRefreshPartialClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass);

	protected @NonNull Map<String, CompleteClass> doRefreshPartialClasses() {
		Map<String, CompleteClass> name2completeClass2 = name2completeClass;
		if (name2completeClass2 == null) {
			name2completeClass2 = name2completeClass = new HashMap<String, CompleteClass>();
		}
		for (org.eclipse.ocl.examples.pivot.Package partialPackage : getCompletePackage().getPartialPackages()) {
			if (partialPackage != null) {
				doRefreshPartialClasses(partialPackage);
			}
		}
		return name2completeClass2;
	}

	protected void doRefreshPartialClasses(@NonNull org.eclipse.ocl.examples.pivot.Package partialPackage) {
		for (org.eclipse.ocl.examples.pivot.Class partialClass : partialPackage.getOwnedClasses()) {
			if (partialClass != null) {
				doRefreshPartialClass(partialClass);
			}
		}
	}

	public @NonNull CompleteModelImpl getCompleteModel() {
		return getCompletePackage().getCompleteModel();
	}

	@SuppressWarnings("null")
	public @NonNull CompletePackageImpl getCompletePackage() {
		return (CompletePackageImpl) owner;
	}

	public @Nullable CompleteClass getOwnedCompleteClass(String name) {
		Map<String, CompleteClass> name2completeClass2 = name2completeClass;
		if (name2completeClass2 == null) {
			name2completeClass2 = doRefreshPartialClasses();
		}
		return name2completeClass2.get(name);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + owner.toString();
	}
}