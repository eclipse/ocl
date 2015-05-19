/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.complete;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.VoidType;

public interface StandardLibraryInternal extends StandardLibrary
{
	@Nullable Operation basicGetOclInvalidOperation();
	@Nullable Property basicGetOclInvalidProperty();
	@Nullable InvalidType basicGetOclInvalidType();
	void defineLibraryType(@NonNull org.eclipse.ocl.pivot.Class pivotType);
	void dispose();
	@Override
	@NonNull BagType getBagType();
	@Nullable PrimitiveType getBehavioralClass(@NonNull Class<?> javaClass);
	@Override
	@NonNull PrimitiveType getBooleanType();
	@Override
	@NonNull CollectionType getCollectionType();
	@NonNull CompleteModelInternal getCompleteModel();
	@NonNull String getDefaultStandardLibraryURI();
	@Override
	@NonNull PrimitiveType getIntegerType();
	org.eclipse.ocl.pivot.Class getLibraryType(@NonNull String typeName);
	@Override
	@NonNull AnyType getOclAnyType();
	@NonNull Property getOclInvalidProperty();
	@Override
	@NonNull InvalidType getOclInvalidType();
	@NonNull org.eclipse.ocl.pivot.Class getOclLambdaType();
	@NonNull org.eclipse.ocl.pivot.Class getOclTypeType();
	@Override
	@NonNull VoidType getOclVoidType();
	@Override
	@NonNull CollectionType getOrderedCollectionType();
	@Override
	@NonNull OrderedSetType getOrderedSetType();
	@Nullable org.eclipse.ocl.pivot.Class getASClass(@NonNull String className);
	@Override
	@NonNull PrimitiveType getRealType();
	@NonNull org.eclipse.ocl.pivot.Class getRequiredLibraryType(@NonNull String typeName);
	@Override
	@NonNull SequenceType getSequenceType();
	@Override
	@NonNull SetType getSetType();
	@Override
	@NonNull PrimitiveType getStringType();
	@Override
	@NonNull CollectionType getUniqueCollectionType();
	@Override
	@NonNull PrimitiveType getUnlimitedNaturalType();
	@NonNull StandardLibraryInternal init(@NonNull CompleteModelInternal completeModel);
	boolean isExplicitDefaultStandardLibraryURI();
	@Nullable Resource loadDefaultLibrary(@Nullable String uri);
	void setDefaultStandardLibraryURI(@NonNull String defaultStandardLibraryURI);
}
