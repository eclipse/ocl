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

import org.eclipse.jdt.annotation.NonNull;
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

/**
 * An Id2JavaClassVisitor return the Java Interface for an Id.
 */
public class Id2JavaInterfaceVisitor implements IdVisitor<Class<? extends ElementId>>
{
	@Override
	public Class<? extends ElementId> visitClassId(@NonNull ClassId id) {
		return ClassId.class;
	}

	@Override
	public Class<? extends ElementId> visitCollectionTypeId(@NonNull CollectionTypeId id) {
		return CollectionTypeId.class;
	}

	@Override
	public Class<? extends ElementId> visitDataTypeId(@NonNull DataTypeId id) {
		return DataTypeId.class;
	}

	@Override
	public Class<? extends ElementId> visitEnumerationId(@NonNull EnumerationId id) {
		return EnumerationId.class;
	}

	@Override
	public Class<? extends ElementId> visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		return EnumerationLiteralId.class;
	}

	@Override
	public Class<? extends ElementId> visitInvalidId(@NonNull OclInvalidTypeId id) {
		return OclInvalidTypeId.class;
	}

	@Override
	public Class<? extends ElementId> visitLambdaTypeId(@NonNull LambdaTypeId id) {
		return LambdaTypeId.class;
	}

	@Override
	public Class<? extends ElementId> visitMetaclassId(@NonNull MetaclassId id) {
		return MetaclassId.class;
	}

	@Override
	public Class<? extends ElementId> visitNestedPackageId(@NonNull NestedPackageId id) {
		return NestedPackageId.class;
	}

	@Override
	public Class<? extends ElementId> visitNsURIPackageId(@NonNull NsURIPackageId id) {
		return NsURIPackageId.class;
	}

	@Override
	public Class<? extends ElementId> visitNullId(@NonNull OclVoidTypeId id) {
		return OclVoidTypeId.class;
	}

	@Override
	public Class<? extends ElementId> visitOperationId(@NonNull OperationId id) {
		return OperationId.class;
	}

	@Override
	public Class<? extends ElementId> visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		return PrimitiveTypeId.class;
	}

	@Override
	public Class<? extends ElementId> visitPropertyId(@NonNull PropertyId id) {
		return PropertyId.class;
	}

	@Override
	public Class<? extends ElementId> visitRootPackageId(@NonNull RootPackageId id) {
		return RootPackageId.class;
	}

	@Override
	public Class<? extends ElementId> visitTemplateBinding(@NonNull TemplateBinding id) {
		return TemplateBinding.class;
	}

	@Override
	public Class<? extends ElementId> visitTemplateParameterId(@NonNull TemplateParameterId id) {
		return TemplateParameterId.class;
	}

	@Override
	public Class<? extends ElementId> visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		return TemplateableTypeId.class;
	}

	@Override
	public Class<? extends ElementId> visitTuplePartId(@NonNull TuplePartId id) {
		return TuplePartId.class;
	}

	@Override
	public Class<? extends ElementId> visitTupleTypeId(@NonNull TupleTypeId id) {
		return TupleTypeId.class;
	}

	@Override
	public Class<? extends ElementId> visitUnspecifiedId(@NonNull UnspecifiedId id) {
		return UnspecifiedId.class;
	}
}