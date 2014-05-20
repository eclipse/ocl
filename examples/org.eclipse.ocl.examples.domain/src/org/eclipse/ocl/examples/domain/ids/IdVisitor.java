/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package	org.eclipse.ocl.examples.domain.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An IdVisitor supports visting an ElementId to react according to the derived Element type.
 */
public interface IdVisitor<R>
{	
	@Nullable R visitClassId(@NonNull ClassId id);
	@Nullable R visitCollectionTypeId(@NonNull CollectionTypeId id);
	@Nullable R visitDataTypeId(@NonNull DataTypeId id);
	@Nullable R visitEnumerationId(@NonNull EnumerationId id);
	@Nullable R visitEnumerationLiteralId(@NonNull EnumerationLiteralId id);
	@Nullable R visitInvalidId(@NonNull OclInvalidTypeId id);
	@Nullable R visitLambdaTypeId(@NonNull LambdaTypeId id);
	@Nullable R visitMetaclassId(@NonNull MetaclassId id);
	@Nullable R visitNestedPackageId(@NonNull NestedPackageId id);
	@Nullable R visitNsURIPackageId(@NonNull NsURIPackageId id);
	@Nullable R visitNullId(@NonNull OclVoidTypeId id);
	@Nullable R visitOperationId(@NonNull OperationId id);
	@Nullable R visitPrimitiveTypeId(@NonNull PrimitiveTypeId id);
	@Nullable R visitPropertyId(@NonNull PropertyId id);
	@Nullable R visitRootPackageId(@NonNull RootPackageId id);
	@Nullable R visitTemplateBinding(@NonNull TemplateBinding id);
	@Nullable R visitTemplateParameterId(@NonNull TemplateParameterId id);
	@Nullable R visitTemplateableTypeId(@NonNull TemplateableTypeId id);
	@Nullable R visitTuplePartId(@NonNull TuplePartId id);
	@Nullable R visitTupleTypeId(@NonNull TupleTypeId id);
	@Nullable R visitUnspecifiedId(@NonNull UnspecifiedId id);
}
