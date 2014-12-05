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
package org.eclipse.ocl.examples.codegen.java.types;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.CollectionTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.codegen.java.JavaStream;

/**
 * An AbstractCollectionDescriptor extends an AbstractDescriptor to describe a collection type.
 */
public abstract class AbstractCollectionDescriptor extends AbstractDescriptor implements CollectionDescriptor
{
	public AbstractCollectionDescriptor(@NonNull CollectionTypeId collectionTypeId) {
		super(collectionTypeId);
	}

	@Override
	public void append(@NonNull JavaStream javaStream, boolean reClass) {
		append(javaStream);
	}

	@Override
	public @NonNull Boolean appendBox(@NonNull JavaStream js, @NonNull JavaLocalContext<?> localContext, @NonNull CGBoxExp cgBoxExp,@NonNull  CGValuedElement unboxedValue) {
		TypeId typeId = unboxedValue.getASTypeId();
		js.appendDeclaration(cgBoxExp);
		js.append(" = ");
		if (!unboxedValue.isNonNull()) {
			js.appendReferenceTo(unboxedValue);
			js.append(" == null ? null : ");
		}
		@NonNull String collectionName = "Collection";
		if (typeId instanceof CollectionTypeId) {
			collectionName = ((CollectionTypeId)typeId).getGeneralizedId().getName();
		}
		js.appendReferenceTo(localContext.getIdResolverVariable(cgBoxExp));
		js.append(".create" + collectionName + "OfAll(");
		js.appendIdReference(typeId);
		js.append(", ");
		js.appendReferenceTo(Iterable.class, unboxedValue);
		js.append(")");
		js.append(";\n");
		return true;
	}

	@Override
	public void appendElement(@NonNull JavaStream javaStream, boolean reClass) {
		javaStream.append(getClassName());
	}

	@Override
	public @Nullable CollectionDescriptor asCollectionDescriptor() {
		return this;
	}
	
	@Override
	public @NonNull CollectionTypeId getElementId() {
		return (CollectionTypeId)super.getElementId();
	}

	@Override
	public boolean isAssignableTo(@NonNull Class<?> javaClass) {
		return javaClass.isAssignableFrom(List.class);
	}

	@Override
	public @NonNull String toString() {
		return elementId + " => List<" + getClassName() + ">";
	}
}