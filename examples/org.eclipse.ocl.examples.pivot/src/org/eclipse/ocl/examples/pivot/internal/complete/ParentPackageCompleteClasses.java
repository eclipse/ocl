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
import org.eclipse.ocl.examples.domain.DomainConstants;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.ParentCompletePackageImpl;

public class ParentPackageCompleteClasses extends AbstractCompleteClasses
{
	public static final long serialVersionUID = 1L;

	public ParentPackageCompleteClasses(@NonNull ParentCompletePackageImpl owner) {
		super(owner);
	}

	@Override
	protected void doRefreshPartialClass(@NonNull org.eclipse.ocl.examples.pivot.Class partialClass) {	// FIXME Inefficient
		Map<String, CompleteClass> name2completeClass2 = name2completeClass;
		assert name2completeClass2 != null;
		CompleteModelImpl completeModel = getCompleteModel();
		String name = partialClass.getName();
		if (name != null) {
			CompleteClass completeClass = null;
			if (partialClass instanceof PrimitiveType) {
				PrimitiveCompletePackage primitiveCompletePackage = completeModel.getPrimitiveCompletePackage();
				completeClass = primitiveCompletePackage.getCompleteClass((PrimitiveType)partialClass);
			}
			else if (DomainConstants.METAMODEL_NAME.equals(getCompletePackage().getURI())) {
				PrimitiveCompletePackage primitiveCompletePackage = completeModel.getPrimitiveCompletePackage();
				completeClass = primitiveCompletePackage.getOwnedCompleteClass(name);
			}
			if (completeClass == null) {
				completeClass = name2completeClass2.get(name);
				if (completeClass == null) {
					completeClass = PivotFactory.eINSTANCE.createCompleteClass();
					completeClass.setName(name);
					add(completeClass);
				}
			}
			completeClass.getPartialClasses().add(partialClass);
		}
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull ParentCompletePackageImpl getCompletePackage() {
		return (ParentCompletePackageImpl) owner;
	}
}