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

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteClassImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.NestedCompletePackageImpl;

public class NestedPackageCompleteClasses extends AbstractCompleteClasses
{
	public static final long serialVersionUID = 1L;

	public NestedPackageCompleteClasses(@NonNull NestedCompletePackageImpl owner) {
		super(owner);
	}

	@Override
	protected void doRefreshPartialClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {
		Map<String, CompleteClass> name2completeClass2 = name2completeClass;
		assert name2completeClass2 != null;
		String name = partialClass.getName();
		if (name != null) {
			CompleteClass completeClass = name2completeClass2.get(name);
			if (completeClass == null) {
				completeClass = PivotFactory.eINSTANCE.createCompleteClass();
				completeClass.setName(name);
				add(completeClass);
//					TypeServer typeServer = getCompleteModel().getTypeServer(partialClass);
//					((CompleteClassImpl)completeClass).setTypeServer(typeServer);
			}
			((CompleteClassImpl)completeClass).didAddClass(partialClass);
		}
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull NestedCompletePackageImpl getCompletePackage() {
		return (NestedCompletePackageImpl) owner;
	}
}