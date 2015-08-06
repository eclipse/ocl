/**
 * Copyright (c) 2014, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.ParameterType;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.OrphanCompletePackageImpl;
import org.eclipse.ocl.pivot.internal.PrimitiveCompletePackageImpl;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TupleTypeManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.values.CollectionTypeParameters;
import org.eclipse.ocl.pivot.values.MapTypeParameters;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;

public interface CompleteModelInternal extends CompleteModel
{
	void didAddClass(@NonNull org.eclipse.ocl.pivot.Class partialClass, @NonNull CompleteClassInternal completeClass);
	void didAddCompletePackage(@NonNull CompletePackageInternal completePackage);
	void didRemoveCompletePackage(@NonNull CompletePackageInternal completePackage);
	void didRemoveClass(@NonNull org.eclipse.ocl.pivot.Class partialClass);
	@Nullable CollectionType findCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters);
	@Nullable MapType findMapType(@NonNull CompleteClassInternal completeClass, @NonNull MapTypeParameters<Type, Type> typeParameters);
	@Override
	@NonNull Iterable<CompletePackageInternal> getAllCompletePackages();
	@NonNull CollectionType getCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters);
	@Override
	@NonNull CompleteClassInternal getCompleteClass(@NonNull Type partialClass);
	@Override
	@NonNull CompletePackageInternal getCompletePackage(@NonNull org.eclipse.ocl.pivot.Package partialPackage);
	@Override
	@Nullable CompletePackageInternal getCompletePackageByURI(@NonNull String packageURI);
	@NonNull CompleteURIs getCompleteURIs();
	@NonNull EnvironmentFactoryInternal getEnvironmentFactory();
	@NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull List<ParameterType> parameterTypes, @NonNull ParameterType resultType,
			@Nullable TemplateParameterSubstitutions bindings);
	@NonNull MapType getMapType(@NonNull CompleteClassInternal completeClass, @NonNull MapTypeParameters<Type, Type> typeParameters);
	@NonNull PivotMetamodelManager getMetamodelManager();
	@Override
	@NonNull OrphanCompletePackageImpl getOrphanCompletePackage();
	@Override
	@NonNull PartialModels getPartialModels();
	@Override
	@NonNull PrimitiveCompletePackageImpl getPrimitiveCompletePackage();
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
	@NonNull StandardLibraryInternal getStandardLibrary();
	@Override
	@NonNull CompleteEnvironmentInternal getCompleteEnvironment();
	@NonNull CompleteModelInternal init(@NonNull CompleteEnvironmentInternal completeEnvironment);
}
