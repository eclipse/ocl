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

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.asm3.ASM3JavaAnnotationReader;
import org.eclipse.ocl.examples.codegen.asm5.ASM5JavaAnnotationReader;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cse.CommonSubexpressionEliminator;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;
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
import org.eclipse.ocl.examples.codegen.java.types.Id2BoxedDescriptorVisitor;
import org.eclipse.ocl.examples.codegen.java.types.UnboxedDescriptor;
import org.eclipse.ocl.examples.codegen.utilities.AbstractCGModelResourceFactory;
import org.eclipse.ocl.examples.codegen.utilities.CGModelResource;
import org.eclipse.ocl.examples.codegen.utilities.CGModelResourceFactory;
import org.eclipse.ocl.examples.domain.ids.ElementId;
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
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Property;
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
	
	private static final @NonNull AbstractCGModelResourceFactory CG_RESOURCE_FACTORY = new AbstractCGModelResourceFactory();

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
		org.eclipse.ocl.examples.pivot.utilities.PivotUtil.class,
		org.eclipse.osgi.util.NLS.class
	};

	public static void initPrimitive(Class<?> class1, Class<?> class2) {
		javaPrimitiveClasses.put(class1, class2);
		javaPrimitiveNames.put(class1.getName(), class2);
	}

	private /*@LazyNonNull*/ Id2EClassVisitor id2EClassVisitor = null;
//	protected final @NonNull Id2JavaInterfaceVisitor id2JavaInterfaceVisitor;
	private /*@LazyNonNull*/ Id2BoxedDescriptorVisitor id2BoxedDescriptorVisitor = null;
	private /*@LazyNonNull*/ JavaGlobalContext<?> globalContext = null;
	private /*@LazyNonNull*/ GlobalPlace globalPlace = null;
	private @NonNull Map<ElementId, BoxedDescriptor> boxedDescriptors = new HashMap<ElementId, BoxedDescriptor>();
	private /*@LazyNonNull*/ Object annotationReader = null;
	private /*@LazyNonNull*/ Method annotationReader_getIsNonNull = null;
	
	public JavaCodeGenerator(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
	}

	@Override
	public @NonNull BoxingAnalyzer createBoxingAnalyzer() {
		return new BoxingAnalyzer(getAnalyzer());
	}

	@Override
	public @NonNull CommonSubexpressionEliminator createCommonSubexpressionEliminator() {
		return new CommonSubexpressionEliminator(this);
	}

	public @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor() {
		return new CG2JavaPreVisitor(getGlobalContext());
	}

	@Override
	public @NonNull DependencyVisitor createDependencyVisitor() {
		return new JavaDependencyVisitor(getAnalyzer(), getGlobalContext(), getGlobalPlace());
	}

	@Override
	public @NonNull FieldingAnalyzer createFieldingAnalyzer() {
		return new FieldingAnalyzer(getAnalyzer());
	}

	@Override
	protected @NonNull GenModelHelper createGenModelHelper() {
		return new AbstractGenModelHelper(metaModelManager);
	}

	protected @NonNull JavaGlobalContext<?> createGlobalContext() {
		return new JavaGlobalContext<JavaCodeGenerator>(this);
	}

	protected @NonNull Id2EClassVisitor createId2EClassVisitor() {
		return new Id2EClassVisitor(metaModelManager);
	}

	protected @NonNull Id2BoxedDescriptorVisitor createId2BoxedDescriptorVisitor() {
		return new Id2BoxedDescriptorVisitor(this);
	}

	@Override
	protected @NonNull NameManager createNameManager() {
		return new NameManager();
	}

	@Override
	@NonNull
	public ReferencesVisitor createReferencesVisitor() {
		return ReferencesVisitor.INSTANCE;
	}

	@Override
	public @NonNull BoxedDescriptor getBoxedDescriptor(@NonNull ElementId elementId) {
		BoxedDescriptor boxedDescriptor = boxedDescriptors.get(elementId);
		if (boxedDescriptor != null) {
			return boxedDescriptor;
		}
		boxedDescriptor = elementId.accept(getId2BoxedDescriptorVisitor());
		assert boxedDescriptor != null;
		boxedDescriptors.put(elementId, boxedDescriptor);
		return boxedDescriptor;
	}

	public @NonNull CGModelResourceFactory getCGResourceFactory() {
		return CG_RESOURCE_FACTORY;
	}

	@Override
	public @Nullable String getConstantsClass() {
		return null;
	}
	
	@Override
	public @NonNull JavaGlobalContext<?> getGlobalContext() {
		JavaGlobalContext<?> globalContext2 = globalContext;
		if (globalContext2 == null) {
			globalContext = globalContext2 = createGlobalContext();
		}
		return globalContext2;
	}

	@Override
	public @NonNull GlobalPlace getGlobalPlace() {
		GlobalPlace globalPlace2 = globalPlace;
		if (globalPlace2 == null) {
			globalPlace = globalPlace2 = new GlobalPlace(getAnalyzer());
		}
		return globalPlace2;
	}

	public @NonNull Id2BoxedDescriptorVisitor getId2BoxedDescriptorVisitor() {
		Id2BoxedDescriptorVisitor id2BoxedDescriptorVisitor2 = id2BoxedDescriptorVisitor;
		if (id2BoxedDescriptorVisitor2 == null) {
			id2BoxedDescriptorVisitor = id2BoxedDescriptorVisitor2 = createId2BoxedDescriptorVisitor();
		}
		return id2BoxedDescriptorVisitor2;
	}

	public @NonNull Id2EClassVisitor getId2EClassVisitor() {
		Id2EClassVisitor id2EClassVisitor2 = id2EClassVisitor;
		if (id2EClassVisitor2 == null) {
			id2EClassVisitor = id2EClassVisitor2 = createId2EClassVisitor();
		}
		return id2EClassVisitor2;
	}

	/**
	 * Return true for an @NonNull annotation, false for an @Nullable annotation, null otherwise.
	 */
	public Boolean getIsNonNull(@NonNull Method method) {
		//
		// org.objectweb.asm introduced an incompatible change between 3.x and 4.x whereby ClassVisitot changes from an interface to a class.
		// when running standalone, only one version can be used and we don't know what xtext.common.types may force so we just try both.
		// construction fails for a compilation error. reflection fails for a missing library. invocation fails for the wrong library.
		//
		if (annotationReader == null) {
			try {
				annotationReader = new ASM5JavaAnnotationReader();
				annotationReader_getIsNonNull = annotationReader.getClass().getMethod("getIsNonNull", Method.class);
				return (Boolean) annotationReader_getIsNonNull.invoke(annotationReader, method);
			}
			catch (Throwable e1) {	// Fails if no org.objectweb.asm 4.x/5.x
				try {
					annotationReader = new ASM3JavaAnnotationReader();
					annotationReader_getIsNonNull = annotationReader.getClass().getMethod("getIsNonNull", Method.class);
					return (Boolean) annotationReader_getIsNonNull.invoke(annotationReader, method);
				}
				catch (Throwable e2) {	// Fails if no org.objectweb.asm 3.x
					annotationReader = this;
					annotationReader_getIsNonNull = null;
				}
			}
		}
		if (annotationReader_getIsNonNull == null) {
			return null;
		}
		try {
			return (Boolean) annotationReader_getIsNonNull.invoke(annotationReader, method);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public @Nullable Iteration2Java getIterationHelper(@NonNull Iteration asIteration) {
		LibraryIteration libraryIteration = (LibraryIteration) asIteration.getImplementation();
		if (asIteration.getOwnedIterator().size() != 1) {
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

	public @Nullable Method getLeastDerivedMethod(@NonNull Class<?> requiredClass, @NonNull String getAccessor) {
		Method leastDerivedMethod = getLeastDerivedMethodInternal(requiredClass, getAccessor);
		if (leastDerivedMethod != null) {
			return leastDerivedMethod;
		}
		else {
			try {
				return requiredClass.getMethod(getAccessor);
			} catch (Throwable e) {
				return null;
			}
		}
	}

	private @Nullable Method getLeastDerivedMethodInternal(@NonNull Class<?> requiredClass, @NonNull String getAccessor) {
		Class<?> superClass = requiredClass.getSuperclass();
		if (superClass != null) {
			try {
				Method lessDerivedSuperMethod = getLeastDerivedMethodInternal(superClass, getAccessor);
				if (lessDerivedSuperMethod != null) {
					return lessDerivedSuperMethod;
				}
				Method method = superClass.getMethod(getAccessor);
				if (method != null) {
					return method;
				}
			} catch (Throwable e) {
			}
		}
		for (@SuppressWarnings("null")@NonNull Class<?> superInterface : requiredClass.getInterfaces()) {
			Method lessDerivedSuperMethod = getLeastDerivedMethodInternal(superInterface, getAccessor);
			if (lessDerivedSuperMethod != null) {
				return lessDerivedSuperMethod;
			}
			try {
				Method method = superInterface.getMethod(getAccessor);
				if (method != null) {
					return method;
				}
			} catch (Throwable e) {
			}
		}
		return null;
	}

	@Override
	public @NonNull TypeDescriptor getTypeDescriptor(@NonNull CGValuedElement cgElement) {
		CGTypeId cgTypeId = DomainUtil.nonNullState(cgElement.getTypeId());
		ElementId elementId = DomainUtil.nonNullState(cgTypeId.getElementId());
		TypeDescriptor typeDescriptor = getBoxedDescriptor(elementId);
		if (!cgElement.isBoxed()) {
			typeDescriptor = typeDescriptor.getUnboxedDescriptor();
		}
		if (maybePrimitive(cgElement)) {
			typeDescriptor = typeDescriptor.getPrimitiveDescriptor();
		}
		return typeDescriptor;
	}

	@Deprecated // Use getBoxed/UnboxedDescriptor
	@Override
	public @NonNull TypeDescriptor getTypeDescriptor(@NonNull ElementId elementId, boolean isBoxed) {
		TypeDescriptor typeDescriptor = getBoxedDescriptor(elementId);
		if (!isBoxed) {
			typeDescriptor = typeDescriptor.getUnboxedDescriptor();
		}
		return typeDescriptor;
	}

	@Deprecated // Use getBoxed/UnboxedDescriptor and then getPrimitive()
	@Override
	public @NonNull TypeDescriptor getTypeDescriptor(@NonNull ElementId elementId, boolean isBoxed, boolean maybePrimitive) {
		TypeDescriptor typeDescriptor = getBoxedDescriptor(elementId);
		if (!isBoxed) {
			typeDescriptor = typeDescriptor.getUnboxedDescriptor();
		}
		if (maybePrimitive) {
			typeDescriptor = typeDescriptor.getPrimitiveDescriptor();
		}
		return typeDescriptor;
	}

	@Override
	public @NonNull UnboxedDescriptor getUnboxedDescriptor(@NonNull ElementId elementId) {
		BoxedDescriptor boxedDescriptor = getBoxedDescriptor(elementId);
		return boxedDescriptor.getUnboxedDescriptor();
	}

	@Override
	public @Nullable Boolean isNonNull(@NonNull OperationCallExp asOperationCallExp) {
		Operation asOperation = asOperationCallExp.getReferredOperation();
		EObject eOperation = asOperation.getETarget();
		if (!(eOperation instanceof EOperation)) {
			return null;
		}
		CGTypeId cgTypeId = getAnalyzer().getTypeId(asOperation.getOwningType().getTypeId());
		ElementId elementId = DomainUtil.nonNullState(cgTypeId.getElementId());
		TypeDescriptor requiredTypeDescriptor = getUnboxedDescriptor(elementId);
		String getAccessor = genModelHelper.getOperationAccessor(asOperation);
		Class<?> requiredJavaClass = requiredTypeDescriptor.hasJavaClass();
		if (requiredJavaClass == null) {
			return null;
		}
		Method leastDerivedMethod = getLeastDerivedMethod(requiredJavaClass, getAccessor);
		if (leastDerivedMethod == null) {
			return null;
		}
		return getIsNonNull(leastDerivedMethod) == Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean isNonNull(@NonNull Property asProperty) {
		EObject eStructuralFeature = asProperty.getETarget();
		if (!(eStructuralFeature instanceof EStructuralFeature)) {
			return null;
		}
		CGTypeId cgTypeId = getAnalyzer().getTypeId(asProperty.getOwningType().getTypeId());
		ElementId elementId = DomainUtil.nonNullState(cgTypeId.getElementId());
		TypeDescriptor requiredTypeDescriptor = getUnboxedDescriptor(elementId);
		String getAccessor = genModelHelper.getGetAccessor((EStructuralFeature)eStructuralFeature);
		Class<?> requiredJavaClass = requiredTypeDescriptor.hasJavaClass();
		if (requiredJavaClass == null) {
			return null;
		}
		Method leastDerivedMethod = getLeastDerivedMethod(requiredJavaClass, getAccessor);
		if (leastDerivedMethod == null) {
			return null;
		}
		return getIsNonNull(leastDerivedMethod) == Boolean.TRUE;
	}

	@Override
	public boolean maybePrimitive(@NonNull CGValuedElement cgValue) {
		if (cgValue.getNamedValue().isCaught()) {
			return false;
		}
		else {
			return cgValue.isNonNull();
		}
	}

	/**
	 * Perform the overall optimization of the CG tree.
	 */
	protected void optimize(@NonNull CGPackage cgPackage) {
		CGModelResource resource = getCGResourceFactory().createResource(URI.createURI("cg.xmi"));
		resource.getContents().add(cgPackage);
		getAnalyzer().analyze(cgPackage);
		CG2JavaPreVisitor cg2PreVisitor = createCG2JavaPreVisitor();
		cgPackage.accept(cg2PreVisitor);
		CommonSubexpressionEliminator cseEliminator = createCommonSubexpressionEliminator();
		cseEliminator.optimize(cgPackage);
	}

	/**
	 * After overall optimization, return a sorted list of global declarations.
	 */
	public @Nullable List<CGValuedElement> prepareGlobals() {
		DependencyVisitor dependencyVisitor = createDependencyVisitor();
		Collection<CGValuedElement> globals = getGlobalContext().getGlobals();
		for (CGValuedElement cgGlobal : globals) {
			assert cgGlobal.isGlobal();
		}
		dependencyVisitor.visitAll(globals);
		List<CGValuedElement> sortedGlobals = getGlobalPlace().getSortedGlobals(dependencyVisitor);
		return sortedGlobals;
	}
}
