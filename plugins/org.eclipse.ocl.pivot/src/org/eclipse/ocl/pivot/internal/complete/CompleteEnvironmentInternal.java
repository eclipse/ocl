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
package org.eclipse.ocl.pivot.internal.complete;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.values.CollectionTypeParameters;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.PivotStandardLibrary;
import org.eclipse.ocl.pivot.manager.TupleTypeManager;

public interface CompleteEnvironmentInternal extends CompleteEnvironment
{
	boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions);
	void dispose();
	void didAddClass(@NonNull org.eclipse.ocl.pivot.Class partialClass, @NonNull CompleteClassInternal completeClass);
	void didRemoveClass(@NonNull org.eclipse.ocl.pivot.Class partialClass);
	@Nullable CollectionType findCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters);
	@NonNull CollectionType getCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters);
	@NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);
	@NonNull CompleteClassInternal getCompleteClass(@NonNull DomainType pivotType);
	@Override
	@NonNull CompleteModelInternal getCompleteModel();
	@NonNull MetaModelManager getMetaModelManager();
//	@Override
//	@NonNull PivotStandardLibrary getStandardLibrary();
	@Override
	@NonNull PivotStandardLibrary getStandardLibrary();
	@NonNull TupleTypeManager getTupleManager();
}