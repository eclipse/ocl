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
package org.eclipse.ocl.examples.pivot.manager;

import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainEnvironment;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.library.executor.CollectionTypeParameters;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompleteModel;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;


public interface CompleteEnvironment extends DomainEnvironment
{
	@Override
	@NonNull CollectionType getCollectionType(@NonNull DomainClass containerType, @NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper);
	@NonNull CompleteModel getCompleteModel();
	@NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType,
			@Nullable TemplateParameterSubstitutions bindings);
	@NonNull CollectionType getSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper);
	@NonNull Type getSpecializedType(@NonNull Type type, @Nullable TemplateParameterSubstitutions substitutions);
	@Override
	@NonNull PivotStandardLibrary getStandardLibrary();
	@NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<? extends DomainTypedElement> parts,
			@Nullable TemplateParameterSubstitutions bindings);

		public interface Internal extends CompleteEnvironment
	{
		boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
				@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions);
		void dispose();
		void didAddClass(@NonNull DomainClass partialClass, @NonNull CompleteClass.Internal completeClass);
		void didRemoveClass(@NonNull DomainClass partialClass);
		@Nullable CollectionType findCollectionType(@NonNull CompleteClass.Internal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters);
		@NonNull CollectionType getCollectionType(@NonNull CompleteClass.Internal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters);
		@NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper);
		@NonNull CompleteClass.Internal getCompleteClass(@NonNull DomainType pivotType);
		@Override
		@NonNull CompleteModel.Internal getCompleteModel();
		@NonNull MetaModelManager getMetaModelManager();
		@Override
		@NonNull PivotStandardLibrary2 getStandardLibrary();
		@NonNull TupleTypeManager getTupleManager();
	}
}