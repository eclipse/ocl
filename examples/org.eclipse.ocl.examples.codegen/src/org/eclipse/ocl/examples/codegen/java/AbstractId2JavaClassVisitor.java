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
import org.eclipse.ocl.domain.elements.DomainLambdaType;
import org.eclipse.ocl.domain.elements.DomainOperation;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.ClassId;
import org.eclipse.ocl.domain.ids.ElementId;
import org.eclipse.ocl.domain.ids.IdVisitor;
import org.eclipse.ocl.domain.ids.LambdaTypeId;
import org.eclipse.ocl.domain.ids.NestedPackageId;
import org.eclipse.ocl.domain.ids.NsURIPackageId;
import org.eclipse.ocl.domain.ids.OclInvalidTypeId;
import org.eclipse.ocl.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.domain.ids.OperationId;
import org.eclipse.ocl.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.domain.ids.PropertyId;
import org.eclipse.ocl.domain.ids.RootPackageId;
import org.eclipse.ocl.domain.ids.TemplateBinding;
import org.eclipse.ocl.domain.ids.TemplateParameterId;
import org.eclipse.ocl.domain.ids.TemplateableTypeId;
import org.eclipse.ocl.domain.ids.TuplePartId;
import org.eclipse.ocl.domain.ids.TupleTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.ids.UnspecifiedId;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.domain.values.IntegerRange;
import org.eclipse.ocl.domain.values.TupleValue;
import org.eclipse.ocl.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.java.types.JavaTypeId;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.manager.MetaModelManager;

public abstract class AbstractId2JavaClassVisitor implements IdVisitor<Class<?>>
{
	protected final @NonNull GenModelHelper genModelHelper;;
	
	protected AbstractId2JavaClassVisitor(@NonNull GenModelHelper genModelHelper) {
		this.genModelHelper = genModelHelper;
	}

	public @NonNull Class<?> doVisit(@NonNull ElementId elementId) {
		return DomainUtil.nonNullState(elementId.accept(this));
	}

	@Override
	public @NonNull Class<?> visitClassId(@NonNull ClassId id) {
//		return visiting(id);
		MetaModelManager metaModelManager = genModelHelper.getMetaModelManager();
		Type type = metaModelManager.getIdResolver().getType(id, null);
		EClass eClass = (EClass) type.getETarget();
		if (eClass != null) {
			try {
				return genModelHelper.getEcoreInterfaceClassifier(eClass);
			}
			catch (Exception e) {}
		}
		return Object.class;
	}

	@Override
	public @NonNull Class<?> visitInvalidId(@NonNull OclInvalidTypeId id) {
		return InvalidValueException.class;
	}

	@Override
	public @NonNull Class<?> visitLambdaTypeId(@NonNull LambdaTypeId id) {
		return DomainLambdaType.class;
	}

	@Override
	public @NonNull Class<?> visitNestedPackageId(@NonNull NestedPackageId id) {
		return DomainPackage.class;
	}

	@Override
	public @NonNull Class<?> visitNsURIPackageId(@NonNull NsURIPackageId id) {
		return DomainPackage.class;
	}

	@Override
	public @NonNull Class<?> visitNullId(@NonNull OclVoidTypeId id) {
		return Object.class;		// NullValue is never used
	}

	@Override
	public @NonNull Class<?> visitOperationId(@NonNull OperationId id) {
		return DomainOperation.class;
	}

	@Override
	public @Nullable Class<?> visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		if (id instanceof JavaTypeId) {
			return ((JavaTypeId)id).getJavaClass();
		}
		else if (id == TypeId.BOOLEAN) {						// FIXME Do reflective field analysis
			return Boolean.class;
		}
		else if (id == TypeId.INTEGER_RANGE) {
			return IntegerRange.class;
		}
		else if (id == TypeId.OCL_ANY) {
			return Object.class;
		}
		else if (id == TypeId.OCL_COMPARABLE) {
			return Object.class;
		}
		else if (id == TypeId.OCL_SUMMABLE) {
			return Object.class;
		}
		else if (id == TypeId.STRING) {
			return String.class;
		}
		return null;
	}

	@Override
	public @NonNull Class<?> visitPropertyId(@NonNull PropertyId id) {
		return Property.class;
	}

	@Override
	public @NonNull Class<?> visitRootPackageId(@NonNull RootPackageId id) {
		return DomainPackage.class;
	}

	@Override
	public @NonNull Class<?> visitTemplateBinding(@NonNull TemplateBinding id) {
		return visiting(id);
	}

	@Override
	public @NonNull Class<?> visitTemplateParameterId(@NonNull TemplateParameterId id) {
		return Object.class;				// FIXME
	}

	@Override
	public @NonNull Class<?> visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		return DomainType.class;
	}

	@Override
	public @NonNull Class<?> visitTuplePartId(@NonNull TuplePartId id) {
		return Property.class;
	}

	@Override
	public @NonNull Class<?> visitTupleTypeId(@NonNull TupleTypeId id) {
		return TupleValue.class;
	}

	@Override
	public @NonNull Class<?> visitUnspecifiedId(@NonNull UnspecifiedId id) {
		return visiting(id);
	}
	
	public @NonNull Class<?> visiting(@NonNull ElementId id) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + id.getClass().getName());
	}
}
