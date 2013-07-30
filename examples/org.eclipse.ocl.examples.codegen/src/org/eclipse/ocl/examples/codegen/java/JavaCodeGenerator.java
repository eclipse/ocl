/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.java;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cse.CommonSubexpressionEliminator;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.iteration.AnyIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.CollectIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.CollectNestedIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.ExistsIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.ForAllIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.IsUniqueIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.IterateIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.OneIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.RejectIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.SelectIteration2Java;
import org.eclipse.ocl.examples.codegen.java.types.BoxedDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.BoxedValueDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.RootObjectDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.SimpleDataTypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.SimpleDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.SimpleEObjectDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.SimpleValueDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.UnboxedDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.UnboxedDynamicEObjectsDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.UnboxedEObjectsDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.UnboxedElementsDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.UnboxedValueDescriptor;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.DataTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.iterator.AnyIteration;
import org.eclipse.ocl.examples.library.iterator.CollectIteration;
import org.eclipse.ocl.examples.library.iterator.CollectNestedIteration;
import org.eclipse.ocl.examples.library.iterator.ExistsIteration;
import org.eclipse.ocl.examples.library.iterator.ForAllIteration;
import org.eclipse.ocl.examples.library.iterator.IsUniqueIteration;
import org.eclipse.ocl.examples.library.iterator.IterateIteration;
import org.eclipse.ocl.examples.library.iterator.OneIteration;
import org.eclipse.ocl.examples.library.iterator.RejectIteration;
import org.eclipse.ocl.examples.library.iterator.SelectIteration;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile to
 * provide the polymorphic implementation of an ExpressionInOCL.
 */
public abstract class JavaCodeGenerator extends AbstractCodeGenerator
{
	public static Map<Class<?>, Class<?>> javaPrimitiveClasses = new HashMap<Class<?>, Class<?>>();

	public static Map<String, Class<?>> javaPrimitiveNames = new HashMap<String, Class<?>>();
	{
		initPrimitive(boolean.class, Boolean.class);
		initPrimitive(byte.class, Byte.class);
		initPrimitive(char.class, Character.class);
		initPrimitive(double.class, Double.class);
		initPrimitive(float.class, Float.class);
		initPrimitive(int.class, Integer.class);
		initPrimitive(long.class, Long.class);
		initPrimitive(short.class, Short.class);
	}

	/**
	 * The known classes that templates may use in unqualified form. The list is
	 * here in a Java form to reduce the impact of refactoring on Acceleo
	 * templates.
	 */
	public static final @NonNull Class<?>[] knownClasses = {
		java.lang.Class.class,
		java.lang.Object.class,
		java.lang.Package.class,
		java.util.Iterator.class,
		org.eclipse.ocl.examples.domain.elements.DomainElement.class,
		org.eclipse.ocl.examples.domain.elements.DomainMetaclass.class,
		org.eclipse.ocl.examples.domain.elements.DomainCollectionType.class,
		org.eclipse.ocl.examples.domain.elements.DomainParameterTypes.class,
		org.eclipse.ocl.examples.domain.elements.DomainProperty.class,
		org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary.class,
		org.eclipse.ocl.examples.domain.elements.DomainTupleType.class,
		org.eclipse.ocl.examples.domain.elements.DomainType.class,
		org.eclipse.ocl.examples.domain.elements.DomainTypeParameters.class,
		org.eclipse.ocl.examples.domain.elements.DomainTypedElement.class,
		org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator.class,
		org.eclipse.ocl.examples.domain.ids.ClassId.class,
		org.eclipse.ocl.examples.domain.ids.CollectionTypeId.class,
		org.eclipse.ocl.examples.domain.ids.DataTypeId.class,
		org.eclipse.ocl.examples.domain.ids.EnumerationId.class,
		org.eclipse.ocl.examples.domain.ids.IdManager.class,
		org.eclipse.ocl.examples.domain.ids.MetaclassId.class,
		org.eclipse.ocl.examples.domain.ids.PackageId.class,
		org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId.class,
		org.eclipse.ocl.examples.domain.ids.TemplateParameterId.class,
		org.eclipse.ocl.examples.domain.ids.TuplePartId.class,
		org.eclipse.ocl.examples.domain.ids.TupleTypeId.class,
		org.eclipse.ocl.examples.domain.ids.TypeId.class,
		org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation.class,
		org.eclipse.ocl.examples.domain.library.AbstractProperty.class,
		org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation.class,
		org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation.class,
		org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation.class,
		org.eclipse.ocl.examples.domain.library.LibraryIteration.class,
		org.eclipse.ocl.examples.domain.library.LibraryProperty.class,
		org.eclipse.ocl.examples.domain.library.LibraryTernaryOperation.class,
		org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation.class,
		org.eclipse.ocl.examples.domain.messages.EvaluatorMessages.class,
		org.eclipse.ocl.examples.domain.values.BagValue.class,
		org.eclipse.ocl.examples.domain.values.CollectionValue.class,
		org.eclipse.ocl.examples.domain.values.IntegerRange.class,
		org.eclipse.ocl.examples.domain.values.IntegerValue.class,
		org.eclipse.ocl.examples.domain.values.InvalidValue.class,
		org.eclipse.ocl.examples.domain.values.OrderedSetValue.class,
		org.eclipse.ocl.examples.domain.values.RealValue.class,
		org.eclipse.ocl.examples.domain.values.SequenceValue.class,
		org.eclipse.ocl.examples.domain.values.SetValue.class,
		org.eclipse.ocl.examples.domain.values.TupleValue.class,
		org.eclipse.ocl.examples.domain.values.UnlimitedValue.class,
		org.eclipse.ocl.examples.domain.values.Value.class,
		org.eclipse.ocl.examples.domain.values.impl.InvalidValueException.class,
		org.eclipse.ocl.examples.domain.values.util.ValuesUtil.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumeration.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumerationLiteral.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorInvalidType.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorPackage.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorProperty.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorType.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorVoidType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorDoubleIterationManager.class,
		org.eclipse.ocl.examples.library.executor.ExecutorFragment.class,
		org.eclipse.ocl.examples.library.executor.ExecutorLambdaType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorOperation.class,
		org.eclipse.ocl.examples.library.executor.ExecutorProperty.class,
		org.eclipse.ocl.examples.library.executor.ExecutorPropertyWithImplementation.class,
		org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager.class,
		org.eclipse.ocl.examples.library.executor.ExecutorSpecializedType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorStandardLibrary.class,
		org.eclipse.ocl.examples.library.executor.ExecutorType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorTypeParameter.class,
		org.eclipse.ocl.examples.pivot.PivotPackage.class,
		org.eclipse.osgi.util.NLS.class};

	public static void initPrimitive(Class<?> class1, Class<?> class2) {
		javaPrimitiveClasses.put(class1, class2);
		javaPrimitiveNames.put(class1.getName(), class2);
	}

	private /*@LazyNonNull*/ Id2BoxedJavaClassVisitor id2BoxedJavaClassVisitor = null;
	private /*@LazyNonNull*/ Id2EClassVisitor id2EClassVisitor = null;
//	protected final @NonNull Id2JavaInterfaceVisitor id2JavaInterfaceVisitor;
	private /*@LazyNonNull*/ Id2UnboxedJavaClassVisitor id2UnboxedJavaClassVisitor = null;
	private /*@LazyNonNull*/ JavaGlobalContext globalContext = null;
	private @NonNull Map<ElementId, SimpleDescriptor> simpleDescriptors = new HashMap<ElementId, SimpleDescriptor>();
	private @NonNull Map<ElementId, BoxedDescriptor> boxedDescriptors = new HashMap<ElementId, BoxedDescriptor>();
	private @NonNull Map<ElementId, UnboxedDescriptor> unboxedDescriptors = new HashMap<ElementId, UnboxedDescriptor>();

	public JavaCodeGenerator(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
	}

	public @NonNull BoxingAnalyzer createBoxingAnalyzer() {
		return new BoxingAnalyzer(getAnalyzer());
	}

	public @NonNull CommonSubexpressionEliminator createCommonSubexpressionEliminator() {
		return new CommonSubexpressionEliminator(getAnalyzer());
	}

	public @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor() {
		return new CG2JavaPreVisitor(globalContext);
	}

	public DependencyVisitor createDependencyVisitor() {
		return new JavaDependencyVisitor(getAnalyzer(), globalContext);
	}

	public DependencyVisitor createDependencyVisitor(@NonNull JavaLocalContext localContext) {
		return new JavaDependencyVisitor(localContext);
	}

	public @NonNull FieldingAnalyzer createFieldingAnalyzer() {
		return new FieldingAnalyzer(getAnalyzer());
	}

	@Override
	protected @NonNull GenModelHelper createGenModelHelper() {
		return new AbstractGenModelHelper(metaModelManager);
	}

	protected abstract @NonNull JavaGlobalContext createGlobalContext();

	protected @NonNull Id2BoxedJavaClassVisitor createId2BoxedJavaClassVisitor() {
		return new Id2BoxedJavaClassVisitor(genModelHelper);
	}

	protected @NonNull Id2EClassVisitor createId2EClassVisitor() {
		return new Id2EClassVisitor(metaModelManager);
	}

	protected @NonNull Id2UnboxedJavaClassVisitor createId2UnboxedJavaClassVisitor() {
		return new Id2UnboxedJavaClassVisitor(genModelHelper);
	}

	@Override
	protected @NonNull NameManager createNameManager() {
		return new NameManager();
	}

	@NonNull
	public ReferencesVisitor createReferencesVisitor() {
		return ReferencesVisitor.INSTANCE;
	}

	public @Nullable String getConstantsClass() {
		return null;
	}

	protected EClass getEClass(@NonNull Type type) {
		for (DomainType dType : metaModelManager.getPartialTypes(type)) {
			if (dType instanceof Type) {
				Type pType = (Type) dType;
				EClass eClass = (EClass) pType.getETarget();
				if (eClass != null) {
					return eClass;
				}
			}
		}
		return null;
	}
	
	public @NonNull JavaGlobalContext getGlobalContext() {
		JavaGlobalContext globalContext2 = globalContext;
		if (globalContext2 == null) {
			globalContext = globalContext2 = createGlobalContext();
		}
		return globalContext2;
	}

	public @NonNull Id2BoxedJavaClassVisitor getId2BoxedClassVisitor() {
		Id2BoxedJavaClassVisitor id2BoxedJavaClassVisitor2 = id2BoxedJavaClassVisitor;
		if (id2BoxedJavaClassVisitor2 == null) {
			id2BoxedJavaClassVisitor = id2BoxedJavaClassVisitor2 = createId2BoxedJavaClassVisitor();
		}
		return id2BoxedJavaClassVisitor2;
	}

	public @NonNull Id2EClassVisitor getId2EClassVisitor() {
		Id2EClassVisitor id2EClassVisitor2 = id2EClassVisitor;
		if (id2EClassVisitor2 == null) {
			id2EClassVisitor = id2EClassVisitor2 = createId2EClassVisitor();
		}
		return id2EClassVisitor2;
	}

	public @NonNull Id2UnboxedJavaClassVisitor getId2UnboxedClassVisitor() {
		Id2UnboxedJavaClassVisitor id2UnboxedJavaClassVisitor2 = id2UnboxedJavaClassVisitor;
		if (id2UnboxedJavaClassVisitor2 == null) {
			id2UnboxedJavaClassVisitor = id2UnboxedJavaClassVisitor2 = createId2UnboxedJavaClassVisitor();
		}
		return id2UnboxedJavaClassVisitor2;
	}

	public @Nullable Iteration2Java getIterationHelper(@NonNull Iteration pivotIteration) {
		LibraryIteration libraryIteration = (LibraryIteration) pivotIteration.getImplementation();
		if (pivotIteration.getOwnedIterator().size() != 1) {
			return null;
		}
		if (libraryIteration instanceof AnyIteration) {
			return AnyIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof CollectIteration) {
			return CollectIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof CollectNestedIteration) {
			return CollectNestedIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof ExistsIteration) {
			return ExistsIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof ForAllIteration) {
			return ForAllIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof IsUniqueIteration) {
			return IsUniqueIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof IterateIteration) {
			return IterateIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof OneIteration) {
			return OneIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof RejectIteration) {
			return RejectIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof SelectIteration) {
			return SelectIteration2Java.INSTANCE;
		}
		else {
			return null;
		}
	}

	public @NonNull TypeDescriptor getTypeDescriptor(@NonNull CGValuedElement cgElement) {
		CGTypeId cgTypeId = DomainUtil.nonNullState(cgElement.getTypeId());
		ElementId elementId = DomainUtil.nonNullState(cgTypeId.getElementId());
		boolean isBoxed = cgElement.isBoxed();
		return getTypeDescriptor(elementId, isBoxed);
	}

	public @NonNull TypeDescriptor getTypeDescriptor(@NonNull ElementId elementId, boolean isBoxed) {
		SimpleDescriptor simpleDescriptor = simpleDescriptors.get(elementId);
		if (simpleDescriptor != null) {
			return simpleDescriptor;
		}
		if (isBoxed) {
			BoxedDescriptor boxedDescriptor = boxedDescriptors.get(elementId);
			if (boxedDescriptor != null) {
				return boxedDescriptor;
			}
		}
		else {
			UnboxedDescriptor unboxedDescriptor = unboxedDescriptors.get(elementId);
			if (unboxedDescriptor != null) {
				return unboxedDescriptor;
			}
		}
		if (elementId instanceof ClassId) {
			Type type = metaModelManager.getIdResolver().getType((ClassId)elementId, null);
			EClass eClass = getEClass(type);
			if (eClass != null) {
				try {
					Class<?> javaClass = genModelHelper.getEcoreInterfaceClass(eClass);
					simpleDescriptor = new SimpleEObjectDescriptor(elementId, javaClass, eClass);
					simpleDescriptors.put(elementId, simpleDescriptor);
					return simpleDescriptor;
				}
				catch (Exception e) {
					String instanceClassName = type.getInstanceClassName();
					if (instanceClassName == null) {
						instanceClassName = genModelHelper.getEcoreInterfaceClassName(eClass);
					}
					if (instanceClassName != null) {
						simpleDescriptor = new SimpleDataTypeDescriptor(elementId, instanceClassName);
						simpleDescriptors.put(elementId, simpleDescriptor);
						return simpleDescriptor;
					}
				}
			}
//			return Object.class;
		}
		else if (elementId instanceof DataTypeId) {
			Type type = metaModelManager.getIdResolver().getType((DataTypeId)elementId, null);
			String instanceClassName = type.getInstanceClassName();
			if (instanceClassName != null) {
				simpleDescriptor = new SimpleDataTypeDescriptor(elementId, instanceClassName);
				simpleDescriptors.put(elementId, simpleDescriptor);
				return simpleDescriptor;
			}
		}
		Class<?> boxedClass = getId2BoxedClassVisitor().doVisit(elementId);
		Class<?> unboxedClass = getId2UnboxedClassVisitor().doVisit(elementId);
		if (boxedClass == unboxedClass) {
			if (boxedClass == Object.class) {
				simpleDescriptor = new RootObjectDescriptor(elementId);
			}
			else {
				simpleDescriptor = new SimpleValueDescriptor(elementId, boxedClass);
			}
			simpleDescriptors.put(elementId, simpleDescriptor);
			return simpleDescriptor;
		}
		if (isBoxed) {
			BoxedDescriptor boxedDescriptor = new BoxedValueDescriptor(elementId, boxedClass);
			boxedDescriptors.put(elementId, boxedDescriptor);
			return boxedDescriptor;
		}
		else {
			UnboxedDescriptor unboxedDescriptor = null;
			if (unboxedClass == Object.class) {
				unboxedDescriptor = new RootObjectDescriptor(elementId);
			}
			else if (elementId instanceof CollectionTypeId) {
				CollectionTypeId collectionTypeId = (CollectionTypeId)elementId;
				TypeId typeId = collectionTypeId.getElementTypeId();
				Type type = metaModelManager.getIdResolver().getType(typeId, null);
				EClass eClass = getEClass(type);
				if (eClass != null) {
					try {
						Class<?> javaClass = genModelHelper.getEcoreInterfaceClass(eClass);
						unboxedDescriptor = new UnboxedEObjectsDescriptor(collectionTypeId, javaClass, eClass);
					}
					catch (Exception e) {
						unboxedDescriptor = new UnboxedDynamicEObjectsDescriptor(collectionTypeId, eClass);
					}
				}
				if (unboxedDescriptor == null) {
					unboxedDescriptor = new UnboxedElementsDescriptor(collectionTypeId, metaModelManager, type);
				}
			}
			else {
				unboxedDescriptor = new UnboxedValueDescriptor(elementId, unboxedClass);
			}
			unboxedDescriptors.put(elementId, unboxedDescriptor);
			return unboxedDescriptor;
		}
	}
}
