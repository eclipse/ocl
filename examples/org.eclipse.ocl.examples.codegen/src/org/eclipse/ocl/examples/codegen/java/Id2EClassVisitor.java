/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.java;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.DataTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.NestedPackageId;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.OclInvalidTypeId;
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableTypeId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.UnspecifiedId;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public class Id2EClassVisitor implements IdVisitor<EClass>
{
	protected final @NonNull MetaModelManager metaModelManager;
	
	protected Id2EClassVisitor(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

	@Override
	public @Nullable EClass visitClassId(@NonNull ClassId id) {
		Type type = metaModelManager.getIdResolver().getType(id, null);
		return (EClass) type.getETarget();
	}

	@Override
	public @Nullable EClass visitCollectionTypeId(@NonNull CollectionTypeId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitDataTypeId(@NonNull DataTypeId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitEnumerationId(@NonNull EnumerationId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitInvalidId(@NonNull OclInvalidTypeId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitLambdaTypeId(@NonNull LambdaTypeId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitMetaclassId(@NonNull MetaclassId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitNestedPackageId(@NonNull NestedPackageId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitNsURIPackageId(@NonNull NsURIPackageId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitNullId(@NonNull OclVoidTypeId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitOperationId(@NonNull OperationId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitPropertyId(@NonNull PropertyId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitRootPackageId(@NonNull RootPackageId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitTemplateBinding(@NonNull TemplateBinding id) {
		return visiting(id);
	}

	@Override
	public @Nullable EClass visitTemplateParameterId(@NonNull TemplateParameterId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitTuplePartId(@NonNull TuplePartId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitTupleTypeId(@NonNull TupleTypeId id) {
		return null;
	}

	@Override
	public @Nullable EClass visitUnspecifiedId(@NonNull UnspecifiedId id) {
		return visiting(id);
	}
	
	public @Nullable EClass visiting(@NonNull ElementId id) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + id.getClass().getName());
	}
}
