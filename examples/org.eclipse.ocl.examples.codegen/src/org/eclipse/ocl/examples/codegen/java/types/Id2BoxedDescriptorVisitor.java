/*******************************************************************************
 * Copyright (c) 2013,2014 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.java.types;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.LambdaTypeId;
import org.eclipse.ocl.pivot.ids.NestedPackageId;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.OclInvalidTypeId;
import org.eclipse.ocl.pivot.ids.OclVoidTypeId;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.PrimitiveTypeId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TemplateBinding;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TemplateableTypeId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.ids.UnspecifiedId;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.manager.PivotIdResolver;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerRange;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.RealValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.TupleValue;

/**
 * An Id2BoxedDescriptorVisitor visit returns a descriptor for the boxed type and a delegation to a descriptor for the unboxed type,
 * each corresponding to a visited ElementId.
 */
public class Id2BoxedDescriptorVisitor implements IdVisitor<BoxedDescriptor>
{
	protected final @NonNull GenModelHelper genModelHelper;
	protected final @NonNull MetamodelManager metamodelManager;
	protected final @NonNull PivotIdResolver idResolver;
//	private /*@LazyNonNull*/ Id2BoxedJavaClassVisitor id2BoxedJavaClassVisitor = null;
//	private /*@LazyNonNull*/ Id2UnboxedJavaClassVisitor id2UnboxedJavaClassVisitor = null;
	
	public Id2BoxedDescriptorVisitor(@NonNull JavaCodeGenerator javaCodeGenerator) {
		this.genModelHelper = javaCodeGenerator.getGenModelHelper();
		this.metamodelManager = javaCodeGenerator.getMetamodelManager();
		this.idResolver = metamodelManager.getIdResolver();
	}

	protected EClassifier getEClassifier(@NonNull Type type) {
		for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.pivot.Class dType : metamodelManager.getPartialClasses(type)) {
			EClassifier eClass = (EClassifier) dType.getETarget();
			if (eClass != null) {
				return eClass;
			}
		}
		return null;
	}

	@Override
	public @NonNull BoxedDescriptor visitClassId(@NonNull ClassId id) {
		org.eclipse.ocl.pivot.Class type = idResolver.getClass(id, null);
		EClassifier eClassifier = getEClassifier(type);
		if (eClassifier != null) {
			try {
				Class<?> javaClass = genModelHelper.getEcoreInterfaceClassifier(eClassifier);
				return new EObjectDescriptor(id, eClassifier, javaClass);
			}
			catch (Exception e) {
				String instanceClassName = type.getInstanceClassName();
				if (instanceClassName == null) {
					instanceClassName = genModelHelper.getEcoreInterfaceClassifierName(eClassifier);
				}
				if (instanceClassName != null) {
					return new FutureEObjectDescriptor(id, eClassifier, instanceClassName);
				}
			}
		}
/*		EClass eClass = (EClass) type.getETarget();
		if (eClass != null) {
			try {
				Class<?> javaClass = genModelHelper.getEcoreInterfaceClassifier(eClass);
				if (javaClass != Object.class) {
					return new SimpleValueDescriptor(id, javaClass);
				}
			}
			catch (Exception e) {}
		} */
//		if (type instanceof org.eclipse.ocl.pivot.Class) {
			org.eclipse.ocl.pivot.Package asPackage = type.getOwningPackage();
			if ((asPackage != null) && (asPackage.eContainer() instanceof Orphanage)) {
				return new SimpleDataTypeDescriptor(id, asPackage.getName() + "." + type.getName());
			}
//		}
		return new RootObjectDescriptor(id);
	}
	
	@Override
	public @NonNull BoxedDescriptor visitCollectionTypeId(@NonNull CollectionTypeId id) {
		TypeId generalizedId = id.getGeneralizedId();
		org.eclipse.ocl.pivot.Class type;
		if (generalizedId == id) {
			type = idResolver.getClass(id, null);
		}
		else {
			TypeId typeId = id.getElementTypeId();
			type = idResolver.getClass(typeId, null);
		}
		CollectionDescriptor unboxedDescriptor = null;
		EClassifier eClassifier = getEClassifier(type);
		if (eClassifier != null) {
			try {
				Class<?> javaClass = genModelHelper.getEcoreInterfaceClassifier(eClassifier);
				unboxedDescriptor = new EObjectsDescriptor(id, eClassifier, javaClass);
			}
			catch (Exception e) {
				String instanceClassName = type.getInstanceClassName();
				if (instanceClassName == null) {
					instanceClassName = genModelHelper.getEcoreInterfaceClassifierName(eClassifier);
				}
				if (instanceClassName != null) {
					unboxedDescriptor = new FutureEObjectsDescriptor(id, eClassifier, instanceClassName);
				}
			}
		}
		if (unboxedDescriptor == null) {
			unboxedDescriptor = new UnboxedElementsDescriptor(id, metamodelManager.getStandardLibrary(), type);
		}
		Class<?> boxedClass;
		if (generalizedId == TypeId.BAG) {
			boxedClass = BagValue.class;
		}
		else if (generalizedId == TypeId.COLLECTION) {
			boxedClass = CollectionValue.class;
		}
		else if (generalizedId == TypeId.ORDERED_SET) {
			boxedClass = OrderedSetValue.class;
		}
		else if (generalizedId == TypeId.SEQUENCE) {
			boxedClass = SequenceValue.class;
		}
		else if (generalizedId == TypeId.SET) {
			boxedClass = SetValue.class;
		}
		else {
			boxedClass = CollectionValue.class;
		}
		return new BoxedValuesDescriptor(id, boxedClass, unboxedDescriptor);
	}

	@Override
	public @NonNull BoxedDescriptor visitDataTypeId(@NonNull DataTypeId id) {
		org.eclipse.ocl.pivot.Class type = idResolver.getClass(id, null);
		String instanceClassName = type.getInstanceClassName();
		if (instanceClassName != null) {
			if (BigDecimal.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, RealValue.class, new UnboxedValueDescriptor(id, BigDecimal.class));
			}
			else if (BigInteger.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, IntegerValue.class, new UnboxedValueDescriptor(id, BigInteger.class));
			}
			else if (Byte.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, IntegerValue.class, new UnboxedValueDescriptor(id, Byte.class));
			}
			else if (Double.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, RealValue.class, new UnboxedValueDescriptor(id, Double.class));
			}
			else if (Float.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, RealValue.class, new UnboxedValueDescriptor(id, Float.class));
			}
			else if (Integer.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, IntegerValue.class, new UnboxedValueDescriptor(id, Integer.class));
			}
			else if (Long.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, IntegerValue.class, new UnboxedValueDescriptor(id, Long.class));
			}
			else if (Short.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, IntegerValue.class, new UnboxedValueDescriptor(id, Short.class));
			}
			else if (byte.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, IntegerValue.class, new UnboxedValueDescriptor(id, byte.class));
			}
			else if (char.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, IntegerValue.class, new UnboxedValueDescriptor(id, char.class));
			}
			else if (double.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, RealValue.class, new UnboxedValueDescriptor(id, double.class));
			}
			else if (float.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, RealValue.class, new UnboxedValueDescriptor(id, float.class));
			}
			else if (int.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, IntegerValue.class, new UnboxedValueDescriptor(id, int.class));
			}
			else if (long.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, IntegerValue.class, new UnboxedValueDescriptor(id, long.class));
			}
			else if (short.class.getName().equals(instanceClassName)) {
				return new BoxedValueDescriptor(id, IntegerValue.class, new UnboxedValueDescriptor(id, short.class));
			}
			else {
				return new SimpleDataTypeDescriptor(id, instanceClassName);
			}
		}
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitEnumerationId(@NonNull EnumerationId id) {
		return new EnumerationValueDescriptor(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
//		return new BoxedValueDescriptor(id, EnumerationLiteralId.class, new UnboxedValueDescriptor(id, Enumerator.class));
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitInvalidId(@NonNull OclInvalidTypeId id) {
		return new SimpleValueDescriptor(id, InvalidValueException.class);
	}

	@Override
	public @NonNull BoxedDescriptor visitLambdaTypeId(@NonNull LambdaTypeId id) {
		return new SimpleValueDescriptor(id, LambdaType.class);
	}

	@Override
	public @NonNull BoxedDescriptor visitNestedPackageId(@NonNull NestedPackageId id) {
		return new SimpleValueDescriptor(id, org.eclipse.ocl.pivot.Package.class);
	}

	@Override
	public @NonNull BoxedDescriptor visitNsURIPackageId(@NonNull NsURIPackageId id) {
		return new SimpleValueDescriptor(id, org.eclipse.ocl.pivot.Package.class);
	}

	@Override
	public @NonNull BoxedDescriptor visitNullId(@NonNull OclVoidTypeId id) {
		return new RootObjectDescriptor(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitOperationId(@NonNull OperationId id) {
		return new SimpleValueDescriptor(id, Operation.class);
	}

	@Override
	public @NonNull BoxedDescriptor visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		if (id instanceof JavaTypeId) {
			Class<?> javaClass = ((JavaTypeId)id).getJavaClass();
			if (javaClass == Object.class) {
				return new RootObjectDescriptor(id);
			}
			else {
				return new SimpleValueDescriptor(id, javaClass);
			}
		}
		else if (id == TypeId.BOOLEAN) {
			return new BooleanObjectDescriptor(id);
		}
		else if (id == TypeId.INTEGER) {
			return new IntegerValueDescriptor(id);
		}
		else if (id == TypeId.INTEGER_RANGE) {
			return new SimpleValueDescriptor(id, IntegerRange.class);
		}
		else if (id == TypeId.OCL_ANY) {
			return new RootObjectDescriptor(id);
		}
		else if (id == TypeId.OCL_COMPARABLE) {
			return new RootObjectDescriptor(id);
		}
		else if (id == TypeId.OCL_SUMMABLE) {
			return new RootObjectDescriptor(id);
		}
		else if (id == TypeId.REAL) {
			return new RealValueDescriptor(id);
		}
		else if (id == TypeId.STRING) {
			return new SimpleValueDescriptor(id, String.class);
		}
		else if (id == TypeId.UNLIMITED_NATURAL) {
			return new UnlimitedNaturalValueDescriptor(id);
		}
//		else {
//			try {
//				javaClass = Class.forName(id.getName());
//				if (javaClass != null) {
//					return javaClass;
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitPropertyId(@NonNull PropertyId id) {
		return new SimpleValueDescriptor(id, Property.class);
	}

	@Override
	public @NonNull BoxedDescriptor visitRootPackageId(@NonNull RootPackageId id) {
		return new SimpleValueDescriptor(id, org.eclipse.ocl.pivot.Package.class);
	}

	@Override
	public @NonNull BoxedDescriptor visitTemplateBinding(@NonNull TemplateBinding id) {
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitTemplateParameterId(@NonNull TemplateParameterId id) {
		return new RootObjectDescriptor(id);		// FIXME */
	}

	@Override
	public @NonNull BoxedDescriptor visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		return new SimpleValueDescriptor(id, Type.class);
	}

	@Override
	public @NonNull BoxedDescriptor visitTuplePartId(@NonNull TuplePartId id) {
		return new SimpleValueDescriptor(id, Property.class);
	}

	@Override
	public @NonNull BoxedDescriptor visitTupleTypeId(@NonNull TupleTypeId id) {
		return new SimpleValueDescriptor(id, TupleValue.class);
	}

	@Override
	public @NonNull BoxedDescriptor visitUnspecifiedId(@NonNull UnspecifiedId id) {
		return visiting(id);
	}
	
	public @NonNull BoxedDescriptor visiting(@NonNull ElementId id) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + id.getClass().getName());
	}

/*	private @NonNull BoxedDescriptor visiting2(@NonNull ElementId elementId) {
		Id2BoxedJavaClassVisitor id2BoxedJavaClassVisitor2 = id2BoxedJavaClassVisitor;
		if (id2BoxedJavaClassVisitor2 == null) {
			id2BoxedJavaClassVisitor = id2BoxedJavaClassVisitor2 = new Id2BoxedJavaClassVisitor(genModelHelper);
		}
		Id2UnboxedJavaClassVisitor id2UnboxedJavaClassVisitor2 = id2UnboxedJavaClassVisitor;
		if (id2UnboxedJavaClassVisitor2 == null) {
			id2UnboxedJavaClassVisitor = id2UnboxedJavaClassVisitor2 = new Id2UnboxedJavaClassVisitor(genModelHelper);
		}
		Class<?> boxedClass = id2BoxedJavaClassVisitor2.doVisit(elementId);
		Class<?> unboxedClass = id2UnboxedJavaClassVisitor2.doVisit(elementId);
		if (boxedClass == unboxedClass) {
			BoxedDescriptor simpleDescriptor;
			if (boxedClass == Object.class) {
				simpleDescriptor = new RootObjectDescriptor(elementId);
			}
			else {
				simpleDescriptor = new SimpleValueDescriptor(elementId, boxedClass);
			}
			return simpleDescriptor;
		}
		{
			UnboxedDescriptor unboxedDescriptor = null;
			if (unboxedClass == Object.class) {
				unboxedDescriptor = new RootObjectDescriptor(elementId);
			}
			else {
				unboxedDescriptor = new UnboxedValueDescriptor(elementId, unboxedClass);
			}
			return new BoxedValueDescriptor(elementId, boxedClass, unboxedDescriptor);
		}
	} */
}
