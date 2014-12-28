/**
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.internal.complete;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.internal.manager.MetaModelManager;

public interface CompleteClassInternal extends CompleteClass
{
	void addClass(@NonNull org.eclipse.ocl.pivot.Class partialClass);
	void didAddClass(@NonNull org.eclipse.ocl.pivot.Class partialClass);
//	@NonNull CompleteInheritance createCompleteInheritance();
	boolean didRemoveClass(@NonNull org.eclipse.ocl.pivot.Class partialClass);
	void dispose();
	void uninstall();
	@Override
	@NonNull CompleteInheritanceImpl getCompleteInheritance();
	@NonNull CompleteModelInternal getCompleteModel();
	@NonNull MetaModelManager getMetaModelManager();
	@Override
	CompletePackageInternal getOwningCompletePackage();
	@Override
	@NonNull PartialClasses getPartialClasses();
	@NonNull Iterable<org.eclipse.ocl.pivot.Class> getProperSuperClasses();
} // CompleteClass
