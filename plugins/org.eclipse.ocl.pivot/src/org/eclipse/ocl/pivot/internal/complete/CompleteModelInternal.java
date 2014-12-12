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

import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.values.CollectionTypeParameters;
import org.eclipse.ocl.domain.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.Orphanage;
import org.eclipse.ocl.pivot.manager.PivotStandardLibrary;
import org.eclipse.ocl.pivot.manager.TupleTypeManager;

public interface CompleteModelInternal extends CompleteModel
{
	void didAddClass(@NonNull org.eclipse.ocl.pivot.Class partialClass, @NonNull CompleteClassInternal completeClass);
	void didAddCompletePackage(@NonNull CompletePackageInternal completePackage);
	void didRemoveCompletePackage(@NonNull CompletePackageInternal completePackage);
	void didRemoveClass(@NonNull org.eclipse.ocl.pivot.Class partialClass);
	@Nullable CollectionType findCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters);
	@NonNull CollectionType getCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters);
	@Override
	@NonNull CompleteClassInternal getCompleteClass(@NonNull Type partialClass);
	@Override
	@NonNull CompletePackageInternal getCompletePackage(@NonNull org.eclipse.ocl.pivot.Package partialPackage);
	@Override
	@Nullable CompletePackage getCompletePackageByURI(@NonNull String packageURI);
	@NonNull CompleteURIs getCompleteURIs();
	@NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType,
			@Nullable TemplateParameterSubstitutions bindings);
	@NonNull MetaModelManager getMetaModelManager();
	@Override
	@NonNull OrphanCompletePackageInternal getOrphanCompletePackage();
	@Override
	@NonNull RootCompletePackages getOwnedCompletePackages();
	@Override
	@NonNull PartialModels getPartialModels();
	@Override
	@NonNull PrimitiveCompletePackageInternal getPrimitiveCompletePackage();
	@NonNull Type getSpecializedType(@NonNull Type type, @Nullable TemplateParameterSubstitutions substitutions);
	@NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<? extends TypedElement> parts,
			@Nullable TemplateParameterSubstitutions bindings);	

	void resolveSuperClasses(@NonNull org.eclipse.ocl.pivot.Class specializedClass, @NonNull org.eclipse.ocl.pivot.Class unspecializedClass);
	void dispose();
	void didAddPartialModel(@NonNull Model partialModel);
	void didAddNestedPackage(@NonNull org.eclipse.ocl.pivot.Package pivotPackage);
	void didRemoveNestedPackage(@NonNull org.eclipse.ocl.pivot.Package pivotPackage);
	void didRemovePartialModel(@NonNull Model partialModel);
	@Nullable String getCompleteURI(@Nullable String nsURI);
	@NonNull TupleTypeManager getTupleManager();
	@NonNull Orphanage getOrphanage();
	@NonNull PivotStandardLibrary getStandardLibrary();
	@Override
	@NonNull CompleteEnvironmentInternal getCompleteEnvironment();
}
