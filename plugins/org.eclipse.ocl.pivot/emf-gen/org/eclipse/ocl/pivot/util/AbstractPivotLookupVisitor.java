/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.ocl.pivot.util;

import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment;
import org.eclipse.ocl.pivot.internal.lookup.LookupPackage;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.collection.CollectionAsOrderedSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedSetSubOrderedSetOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;

public class AbstractPivotLookupVisitor
	extends AbstractExtendingVisitor<LookupEnvironment, LookupEnvironment>
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Lookup = IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/2015/Lookup", null, LookupPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot = IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/2015/Pivot", null, PivotPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_java_c_s_s_org_eclipse_ocl_pivot_lookup = IdManager.getRootPackageId("java://org.eclipse.ocl.pivot.lookup");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AbstractPivotLookupVisitor = PACKid_java_c_s_s_org_eclipse_ocl_pivot_lookup.getClassId("AbstractPivotLookupVisitor", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Behavior = PACKid_$metamodel$.getClassId("Behavior", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_DataType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("DataType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_DataType_0 = PACKid_$metamodel$.getClassId("DataType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Element", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Element_0 = PACKid_$metamodel$.getClassId("Element", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Enumeration = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Enumeration", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_EnumerationLiteral = PACKid_$metamodel$.getClassId("EnumerationLiteral", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Enumeration_0 = PACKid_$metamodel$.getClassId("Enumeration", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ExpressionInOCL = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("ExpressionInOCL", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ExpressionInOCL_0 = PACKid_$metamodel$.getClassId("ExpressionInOCL", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Import = PACKid_$metamodel$.getClassId("Import", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IterateExp = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("IterateExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IterateExp_0 = PACKid_$metamodel$.getClassId("IterateExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IteratorExp = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("IteratorExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IteratorExp_0 = PACKid_$metamodel$.getClassId("IteratorExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LetExp = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("LetExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LetExp_0 = PACKid_$metamodel$.getClassId("LetExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Library = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Library", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Library_0 = PACKid_$metamodel$.getClassId("Library", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Lookup.getClassId("LookupEnvironment", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Model", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Model_0 = PACKid_$metamodel$.getClassId("Model", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Operation = PACKid_$metamodel$.getClassId("Operation", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Operation_0 = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Operation", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package_0 = PACKid_$metamodel$.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Parameter = PACKid_$metamodel$.getClassId("Parameter", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Precedence = PACKid_$metamodel$.getClassId("Precedence", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_NULLid = TypeId.ORDERED_SET.getSpecializedId(TypeId.OCL_VOID);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Behavior = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Behavior);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class_0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_DataType = TypeId.ORDERED_SET.getSpecializedId(CLSSid_DataType_0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_EnumerationLiteral = TypeId.ORDERED_SET.getSpecializedId(CLSSid_EnumerationLiteral);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Import = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Import);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package_0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Precedence = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Precedence);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable);
    public static final @NonNull /*@NonInvalid*/ OrderedSetValue OrderedSet = ValueUtil.createOrderedSetOfEach(ORD_NULLid);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Behavior = TypeId.SEQUENCE.getSpecializedId(CLSSid_Behavior);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Property = TypeId.SEQUENCE.getSpecializedId(CLSSid_Property);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Behavior = TypeId.SET.getSpecializedId(CLSSid_Behavior);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class_0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_DataType = TypeId.SET.getSpecializedId(CLSSid_DataType_0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package_0);
    
    protected @Nullable /*@Thrown*/ Object child;
    protected final @NonNull /*@Thrown*/ Executor executor;
    protected final @NonNull /*@Thrown*/ IdResolver idResolver;
    
    public AbstractPivotLookupVisitor(@NonNull LookupEnvironment context) {
        super(context);
        this.executor = context.getExecutor();
        this.idResolver = executor.getIdResolver();
    }
    
    /**
     * Return the results of a lookup from the child of element.
     */
    public @Nullable LookupEnvironment envForChild(@NonNull Object element, @Nullable Object child) {
        this.child = element;
        return ((Visitable)element).accept(this);
    }
    
    /**
     * Continue the search for matches in the parent of element.
     */
    protected @Nullable LookupEnvironment parentEnv(@NonNull EObject element) {
        EObject parent = element.eContainer();
        if (parent instanceof Visitable) {
            this.child = element;
            return ((Visitable)parent).accept(this);
        }
        else {
            return context;
        }
    }
    
    @Override
    public @Nullable LookupEnvironment visiting(@NonNull Visitable visitable) {
        throw new UnsupportedOperationException("AbstractPivotLookupVisitor is not supported by \"" + getClass().getName() + "\"");
    }
    
    /**
     * visitClass(element : Class[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   superClasses : OrderedSet(Class) = element->asOrderedSet()
     *   ->closure(superClasses)
     * in
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(
     *       superClasses.ownedProperties->select(not isStatic)
     *       ->asOrderedSet())
     *     .addElements(
     *       superClasses.ownedOperations->select(not isStatic)
     *       ->asOrderedSet())
     *     .addElements(superClasses.ownedBehaviors->asOrderedSet())
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitClass(final @NonNull /*@NonInvalid*/ Class element) {
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final @NonNull /*@NonInvalid*/ StandardLibrary standardLibrary = idResolver.getStandardLibrary();
        final @NonNull /*@NonInvalid*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, element);
        final @NonNull /*@NonInvalid*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(oclAsSet);
        final @NonNull Class TYPE_superClasses_1 = executor.getStaticTypeOf(asOrderedSet);
        final @NonNull LibraryIteration.LibraryIterationExtension IMPL_superClasses_1 = (LibraryIteration.LibraryIterationExtension)TYPE_superClasses_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._OrderedSet__closure);
        final @NonNull Object ACC_superClasses_1 = IMPL_superClasses_1.createAccumulatorValue(executor, ORD_CLSSid_Class, SET_CLSSid_Class);
        /**
         * Implementation of the iterator body.
         */
        final @NonNull AbstractBinaryOperation BODY_superClasses_1 = new AbstractBinaryOperation()
        {
            /**
             * superClasses
             */
            @Override
            public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object asOrderedSet, final @Nullable /*@NonInvalid*/ Object _1) {
                final @Nullable /*@NonInvalid*/ Class symbol_0 = (Class)_1;
                if (symbol_0 == null) {
                    throw new InvalidValueException("Null source for \'Class::superClasses\'");
                }
                final @NonNull /*@Thrown*/ List<Class> superClasses_0 = symbol_0.getSuperClasses();
                final @NonNull /*@Thrown*/ SetValue BOXED_superClasses_0 = idResolver.createSetOfAll(SET_CLSSid_Class, superClasses_0);
                return BOXED_superClasses_0;
            }
        };
        final @NonNull  ExecutorSingleIterationManager MGR_superClasses_1 = new ExecutorSingleIterationManager(executor, ORD_CLSSid_Class, BODY_superClasses_1, asOrderedSet, ACC_superClasses_1);
        final @NonNull /*@Thrown*/ OrderedSetValue superClasses = ClassUtil.nonNullState((OrderedSetValue)IMPL_superClasses_1.evaluateIteration(MGR_superClasses_1));
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Property);
        @Nullable Iterator<?> ITERATOR__1_0 = superClasses.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ Class _1_0 = (Class)ITERATOR__1_0.next();
            /**
             * ownedProperties
             */
            if (_1_0 == null) {
                throw new InvalidValueException("Null source for \'Class::ownedProperties\'");
            }
            final @NonNull /*@Thrown*/ List<Property> ownedProperties = _1_0.getOwnedProperties();
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedProperties = idResolver.createOrderedSetOfAll(ORD_CLSSid_Property, ownedProperties);
            //
            for (Object value : BOXED_ownedProperties.flatten().getElements()) {
                accumulator.add(value);
            }
        }
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Property);
        @Nullable Iterator<?> ITERATOR__1_1 = collect.iterator();
        @NonNull /*@Thrown*/ SequenceValue select;
        while (true) {
            if (!ITERATOR__1_1.hasNext()) {
                select = accumulator_0;
                break;
            }
            @Nullable /*@NonInvalid*/ Property _1_1 = (Property)ITERATOR__1_1.next();
            /**
             * not isStatic
             */
            if (_1_1 == null) {
                throw new InvalidValueException("Null source for \'Feature::isStatic\'");
            }
            final /*@Thrown*/ boolean isStatic = _1_1.isIsStatic();
            final @Nullable /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isStatic);
            if (not == null) {
                throw new InvalidValueException("Null body for \'Sequence(T).select(Sequence.T[?] | Lambda T() : Boolean[1]) : Sequence(T)\'");
            }
            //
            if (not == ValueUtil.TRUE_VALUE) {
                accumulator_0.add(_1_1);
            }
        }
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet_0 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(select);
        final @NonNull /*@Thrown*/ List<Property> ECORE_asOrderedSet_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Property.class, asOrderedSet_0);
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements((EList)ECORE_asOrderedSet_0);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
        @Nullable Iterator<?> ITERATOR__1_2 = superClasses.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1_2.hasNext()) {
                collect_0 = accumulator_1;
                break;
            }
            @Nullable /*@NonInvalid*/ Class _1_2 = (Class)ITERATOR__1_2.next();
            /**
             * ownedOperations
             */
            if (_1_2 == null) {
                throw new InvalidValueException("Null source for \'Class::ownedOperations\'");
            }
            final @NonNull /*@Thrown*/ List<Operation> ownedOperations = _1_2.getOwnedOperations();
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedOperations = idResolver.createOrderedSetOfAll(ORD_CLSSid_Operation, ownedOperations);
            //
            for (Object value : BOXED_ownedOperations.flatten().getElements()) {
                accumulator_1.add(value);
            }
        }
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_2 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
        @Nullable Iterator<?> ITERATOR__1_3 = collect_0.iterator();
        @NonNull /*@Thrown*/ SequenceValue select_0;
        while (true) {
            if (!ITERATOR__1_3.hasNext()) {
                select_0 = accumulator_2;
                break;
            }
            @Nullable /*@NonInvalid*/ Operation _1_3 = (Operation)ITERATOR__1_3.next();
            /**
             * not isStatic
             */
            if (_1_3 == null) {
                throw new InvalidValueException("Null source for \'Feature::isStatic\'");
            }
            final /*@Thrown*/ boolean isStatic_0 = _1_3.isIsStatic();
            final @Nullable /*@Thrown*/ Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isStatic_0);
            if (not_0 == null) {
                throw new InvalidValueException("Null body for \'Sequence(T).select(Sequence.T[?] | Lambda T() : Boolean[1]) : Sequence(T)\'");
            }
            //
            if (not_0 == ValueUtil.TRUE_VALUE) {
                accumulator_2.add(_1_3);
            }
        }
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet_1 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(select_0);
        final @NonNull /*@Thrown*/ List<Operation> ECORE_asOrderedSet_1 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, asOrderedSet_1);
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements((EList)ECORE_asOrderedSet_1);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_3 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Behavior);
        @Nullable Iterator<?> ITERATOR__1_4 = superClasses.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect_1;
        while (true) {
            if (!ITERATOR__1_4.hasNext()) {
                collect_1 = accumulator_3;
                break;
            }
            @Nullable /*@NonInvalid*/ Class _1_4 = (Class)ITERATOR__1_4.next();
            /**
             * ownedBehaviors
             */
            if (_1_4 == null) {
                throw new InvalidValueException("Null source for \'Class::ownedBehaviors\'");
            }
            final @NonNull /*@Thrown*/ List<Behavior> ownedBehaviors = _1_4.getOwnedBehaviors();
            final @NonNull /*@Thrown*/ SetValue BOXED_ownedBehaviors = idResolver.createSetOfAll(SET_CLSSid_Behavior, ownedBehaviors);
            //
            for (Object value : BOXED_ownedBehaviors.flatten().getElements()) {
                accumulator_3.add(value);
            }
        }
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet_2 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect_1);
        final @NonNull /*@Thrown*/ List<Behavior> ECORE_asOrderedSet_2 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Behavior.class, asOrderedSet_2);
        final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements_0.addElements((EList)ECORE_asOrderedSet_2);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
        if (hasFinalResult) {
            symbol_1 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element);
            symbol_1 = parentEnv;
        }
        return symbol_1;
    }
    
    /**
     * visitDataType(element : DataType[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   superClasses : OrderedSet(Class) = element->asOrderedSet()
     *   ->closure(c | c.superClasses)
     * in
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(
     *       superClasses.ownedProperties->select(not isStatic)
     *       ->asOrderedSet())
     *     .addElements(
     *       superClasses.ownedOperations->select(not isStatic)
     *       ->asOrderedSet())
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitDataType(final @NonNull /*@NonInvalid*/ DataType element_0) {
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final @NonNull /*@NonInvalid*/ StandardLibrary standardLibrary = idResolver.getStandardLibrary();
        final @NonNull /*@NonInvalid*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_DataType, element_0);
        final @NonNull /*@NonInvalid*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(oclAsSet);
        final @NonNull Class TYPE_superClasses_1 = executor.getStaticTypeOf(asOrderedSet);
        final @NonNull LibraryIteration.LibraryIterationExtension IMPL_superClasses_1 = (LibraryIteration.LibraryIterationExtension)TYPE_superClasses_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._OrderedSet__closure);
        final @NonNull Object ACC_superClasses_1 = IMPL_superClasses_1.createAccumulatorValue(executor, ORD_CLSSid_Class, SET_CLSSid_Class);
        /**
         * Implementation of the iterator body.
         */
        final @NonNull AbstractBinaryOperation BODY_superClasses_1 = new AbstractBinaryOperation()
        {
            /**
             * c.superClasses
             */
            @Override
            public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object asOrderedSet, final @Nullable /*@NonInvalid*/ Object c) {
                final @Nullable /*@NonInvalid*/ Class symbol_0 = (Class)c;
                if (symbol_0 == null) {
                    throw new InvalidValueException("Null source for \'Class::superClasses\'");
                }
                final @NonNull /*@Thrown*/ List<Class> superClasses_0 = symbol_0.getSuperClasses();
                final @NonNull /*@Thrown*/ SetValue BOXED_superClasses_0 = idResolver.createSetOfAll(SET_CLSSid_Class, superClasses_0);
                return BOXED_superClasses_0;
            }
        };
        final @NonNull  ExecutorSingleIterationManager MGR_superClasses_1 = new ExecutorSingleIterationManager(executor, ORD_CLSSid_Class, BODY_superClasses_1, asOrderedSet, ACC_superClasses_1);
        final @NonNull /*@Thrown*/ OrderedSetValue superClasses = ClassUtil.nonNullState((OrderedSetValue)IMPL_superClasses_1.evaluateIteration(MGR_superClasses_1));
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Property);
        @Nullable Iterator<?> ITERATOR__1 = superClasses.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ Class _1 = (Class)ITERATOR__1.next();
            /**
             * ownedProperties
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'Class::ownedProperties\'");
            }
            final @NonNull /*@Thrown*/ List<Property> ownedProperties = _1.getOwnedProperties();
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedProperties = idResolver.createOrderedSetOfAll(ORD_CLSSid_Property, ownedProperties);
            //
            for (Object value : BOXED_ownedProperties.flatten().getElements()) {
                accumulator.add(value);
            }
        }
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Property);
        @Nullable Iterator<?> ITERATOR__1_0 = collect.iterator();
        @NonNull /*@Thrown*/ SequenceValue select;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                select = accumulator_0;
                break;
            }
            @Nullable /*@NonInvalid*/ Property _1_0 = (Property)ITERATOR__1_0.next();
            /**
             * not isStatic
             */
            if (_1_0 == null) {
                throw new InvalidValueException("Null source for \'Feature::isStatic\'");
            }
            final /*@Thrown*/ boolean isStatic = _1_0.isIsStatic();
            final @Nullable /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isStatic);
            if (not == null) {
                throw new InvalidValueException("Null body for \'Sequence(T).select(Sequence.T[?] | Lambda T() : Boolean[1]) : Sequence(T)\'");
            }
            //
            if (not == ValueUtil.TRUE_VALUE) {
                accumulator_0.add(_1_0);
            }
        }
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet_0 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(select);
        final @NonNull /*@Thrown*/ List<Property> ECORE_asOrderedSet_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Property.class, asOrderedSet_0);
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements((EList)ECORE_asOrderedSet_0);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
        @Nullable Iterator<?> ITERATOR__1_1 = superClasses.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1_1.hasNext()) {
                collect_0 = accumulator_1;
                break;
            }
            @Nullable /*@NonInvalid*/ Class _1_1 = (Class)ITERATOR__1_1.next();
            /**
             * ownedOperations
             */
            if (_1_1 == null) {
                throw new InvalidValueException("Null source for \'Class::ownedOperations\'");
            }
            final @NonNull /*@Thrown*/ List<Operation> ownedOperations = _1_1.getOwnedOperations();
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedOperations = idResolver.createOrderedSetOfAll(ORD_CLSSid_Operation, ownedOperations);
            //
            for (Object value : BOXED_ownedOperations.flatten().getElements()) {
                accumulator_1.add(value);
            }
        }
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_2 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
        @Nullable Iterator<?> ITERATOR__1_2 = collect_0.iterator();
        @NonNull /*@Thrown*/ SequenceValue select_0;
        while (true) {
            if (!ITERATOR__1_2.hasNext()) {
                select_0 = accumulator_2;
                break;
            }
            @Nullable /*@NonInvalid*/ Operation _1_2 = (Operation)ITERATOR__1_2.next();
            /**
             * not isStatic
             */
            if (_1_2 == null) {
                throw new InvalidValueException("Null source for \'Feature::isStatic\'");
            }
            final /*@Thrown*/ boolean isStatic_0 = _1_2.isIsStatic();
            final @Nullable /*@Thrown*/ Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isStatic_0);
            if (not_0 == null) {
                throw new InvalidValueException("Null body for \'Sequence(T).select(Sequence.T[?] | Lambda T() : Boolean[1]) : Sequence(T)\'");
            }
            //
            if (not_0 == ValueUtil.TRUE_VALUE) {
                accumulator_2.add(_1_2);
            }
        }
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet_1 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(select_0);
        final @NonNull /*@Thrown*/ List<Operation> ECORE_asOrderedSet_1 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, asOrderedSet_1);
        final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements.addElements((EList)ECORE_asOrderedSet_1);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
        if (hasFinalResult) {
            symbol_1 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_0);
            symbol_1 = parentEnv;
        }
        return symbol_1;
    }
    
    /**
     * visitElement(element : Element[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitElement(final @NonNull /*@NonInvalid*/ Element element_1) {
        final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_1);
        return parentEnv;
    }
    
    /**
     * visitEnumeration(element : Enumeration[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   inner : lookup::LookupEnvironment[1] = context.addElements(element.ownedLiterals)
     *   .addElements(element.ownedProperties->select(not isStatic))
     *   .addElements(element.ownedOperations->select(not isStatic))
     *   .addElements(element.ownedBehaviors->asOrderedSet())
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitEnumeration(final @NonNull /*@NonInvalid*/ Enumeration element_2) {
        final @NonNull /*@Thrown*/ List<EnumerationLiteral> ownedLiterals = element_2.getOwnedLiterals();
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements((EList)ownedLiterals);
        final @NonNull /*@Thrown*/ List<Property> ownedProperties = element_2.getOwnedProperties();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedProperties = idResolver.createOrderedSetOfAll(ORD_CLSSid_Property, ownedProperties);
        @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Property);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedProperties.iterator();
        @NonNull /*@Thrown*/ OrderedSetValue select;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                select = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ Property _1 = (Property)ITERATOR__1.next();
            /**
             * not isStatic
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'Feature::isStatic\'");
            }
            final /*@Thrown*/ boolean isStatic = _1.isIsStatic();
            final @Nullable /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isStatic);
            if (not == null) {
                throw new InvalidValueException("Null body for \'OrderedSet(T).select(OrderedSet.T[?] | Lambda T() : Boolean[1]) : OrderedSet(T)\'");
            }
            //
            if (not == ValueUtil.TRUE_VALUE) {
                accumulator.add(_1);
            }
        }
        final @NonNull /*@Thrown*/ List<Property> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Property.class, select);
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements((EList)ECORE_select);
        final @NonNull /*@Thrown*/ List<Operation> ownedOperations = element_2.getOwnedOperations();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedOperations = idResolver.createOrderedSetOfAll(ORD_CLSSid_Operation, ownedOperations);
        @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator_0 = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Operation);
        @Nullable Iterator<?> ITERATOR__1_0 = BOXED_ownedOperations.iterator();
        @NonNull /*@Thrown*/ OrderedSetValue select_0;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                select_0 = accumulator_0;
                break;
            }
            @Nullable /*@NonInvalid*/ Operation _1_0 = (Operation)ITERATOR__1_0.next();
            /**
             * not isStatic
             */
            if (_1_0 == null) {
                throw new InvalidValueException("Null source for \'Feature::isStatic\'");
            }
            final /*@Thrown*/ boolean isStatic_0 = _1_0.isIsStatic();
            final @Nullable /*@Thrown*/ Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isStatic_0);
            if (not_0 == null) {
                throw new InvalidValueException("Null body for \'OrderedSet(T).select(OrderedSet.T[?] | Lambda T() : Boolean[1]) : OrderedSet(T)\'");
            }
            //
            if (not_0 == ValueUtil.TRUE_VALUE) {
                accumulator_0.add(_1_0);
            }
        }
        final @NonNull /*@Thrown*/ List<Operation> ECORE_select_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, select_0);
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_1 = addElements_0.addElements((EList)ECORE_select_0);
        final @NonNull /*@Thrown*/ List<Behavior> ownedBehaviors = element_2.getOwnedBehaviors();
        final @NonNull /*@Thrown*/ SetValue BOXED_ownedBehaviors = idResolver.createSetOfAll(SET_CLSSid_Behavior, ownedBehaviors);
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedBehaviors);
        final @NonNull /*@Thrown*/ List<Behavior> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Behavior.class, asOrderedSet);
        final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements_1.addElements((EList)ECORE_asOrderedSet);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_2);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitExpressionInOCL(element : ExpressionInOCL[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   inner : lookup::LookupEnvironment[1] = context.addElement(element.ownedContext)
     *   .addElements(element.ownedParameters)
     *   .addElement(element.ownedResult)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitExpressionInOCL(final @NonNull /*@NonInvalid*/ ExpressionInOCL element_3) {
        final @Nullable /*@Thrown*/ Variable ownedContext = element_3.getOwnedContext();
        final @NonNull /*@Thrown*/ LookupEnvironment addElement = context.addElement(ownedContext);
        final @NonNull /*@Thrown*/ List<Variable> ownedParameters = element_3.getOwnedParameters();
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = addElement.addElements((EList)ownedParameters);
        final @Nullable /*@Thrown*/ Variable ownedResult = element_3.getOwnedResult();
        final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements.addElement(ownedResult);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_3);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitIterateExp(element : IterateExp[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if child = ownedResult
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(element.ownedIterators)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   let index : Integer[1] = ownedIterators->indexOf(child)
     *   in
     *     if index > 1
     *     then
     *       let
     *         inner : lookup::LookupEnvironment[1] = context.addElements(
     *           element.ownedIterators->subOrderedSet(1, index - 1))
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     else
     *       let
     *         inner : lookup::LookupEnvironment[1] = context.addElements(element.ownedIterators)
     *         .addElement(ownedResult)
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     endif
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitIterateExp(final @NonNull /*@NonInvalid*/ IterateExp element_4) {
        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = element_4.getOwnedIterators();
        final @Nullable /*@Thrown*/ Variable ownedResult = element_4.getOwnedResult();
        final /*@Thrown*/ boolean eq = (child != null) ? child.equals(ownedResult) : (ownedResult == null);
        @Nullable /*@Thrown*/ LookupEnvironment symbol_4;
        if (eq) {
            final @NonNull /*@Thrown*/ LookupEnvironment inner = context.addElements((EList)ownedIterators);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_4);
                symbol_0 = parentEnv;
            }
            symbol_4 = symbol_0;
        }
        else {
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Variable, ownedIterators);
            final @NonNull /*@Thrown*/ IntegerValue index = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedIterators_0, child);
            final /*@Thrown*/ boolean gt = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, index, INT_1).booleanValue();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_3;
            if (gt) {
                final @NonNull /*@Thrown*/ IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(index, INT_1);
                final @NonNull /*@Thrown*/ OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedIterators_0, INT_1, diff);
                final @NonNull /*@Thrown*/ List<Variable> ECORE_subOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, subOrderedSet);
                final @NonNull /*@Thrown*/ LookupEnvironment inner_0 = context.addElements((EList)ECORE_subOrderedSet);
                final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
                @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
                if (hasFinalResult_0) {
                    symbol_1 = inner_0;
                }
                else {
                    final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_4);
                    symbol_1 = parentEnv_0;
                }
                symbol_3 = symbol_1;
            }
            else {
                final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements((EList)ownedIterators);
                final @NonNull /*@Thrown*/ LookupEnvironment inner_1 = addElements.addElement(ownedResult);
                final /*@Thrown*/ boolean hasFinalResult_1 = inner_1.hasFinalResult();
                @Nullable /*@Thrown*/ LookupEnvironment symbol_2;
                if (hasFinalResult_1) {
                    symbol_2 = inner_1;
                }
                else {
                    final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_1 = this.parentEnv(element_4);
                    symbol_2 = parentEnv_1;
                }
                symbol_3 = symbol_2;
            }
            symbol_4 = symbol_3;
        }
        return symbol_4;
    }
    
    /**
     * visitIteratorExp(element : IteratorExp[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let index : Integer[1] = ownedIterators->indexOf(child)
     * in
     *   if index > 1
     *   then
     *     let
     *       inner : lookup::LookupEnvironment[1] = context.addElements(
     *         element.ownedIterators->subOrderedSet(1, index - 1))
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   else
     *     let
     *       inner : lookup::LookupEnvironment[1] = context.addElements(element.ownedIterators)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitIteratorExp(final @NonNull /*@NonInvalid*/ IteratorExp element_5) {
        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = element_5.getOwnedIterators();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(ORD_CLSSid_Variable, ownedIterators);
        final @NonNull /*@Thrown*/ IntegerValue index = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedIterators, child);
        final /*@Thrown*/ boolean gt = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, index, INT_1).booleanValue();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_2;
        if (gt) {
            final @NonNull /*@Thrown*/ IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(index, INT_1);
            final @NonNull /*@Thrown*/ OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedIterators, INT_1, diff);
            final @NonNull /*@Thrown*/ List<Variable> ECORE_subOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, subOrderedSet);
            final @NonNull /*@Thrown*/ LookupEnvironment inner = context.addElements((EList)ECORE_subOrderedSet);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_5);
                symbol_0 = parentEnv;
            }
            symbol_2 = symbol_0;
        }
        else {
            final @NonNull /*@Thrown*/ LookupEnvironment inner_0 = context.addElements((EList)ownedIterators);
            final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
            if (hasFinalResult_0) {
                symbol_1 = inner_0;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_5);
                symbol_1 = parentEnv_0;
            }
            symbol_2 = symbol_1;
        }
        return symbol_2;
    }
    
    /**
     * visitLetExp(element : LetExp[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if child = ownedIn
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElement(element.ownedVariable)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitLetExp(final @NonNull /*@NonInvalid*/ LetExp element_6) {
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ OCLExpression ownedIn = element_6.getOwnedIn();
        final /*@Thrown*/ boolean eq = ownedIn.equals(child);
        @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
        if (eq) {
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ Variable ownedVariable = element_6.getOwnedVariable();
            final @NonNull /*@Thrown*/ LookupEnvironment inner = context.addElement(ownedVariable);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_6);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_6);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitLibrary(element : Library[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   inner : lookup::LookupEnvironment[1] = context.addElements(OrderedSet{})
     *   .addElements(element.ownedPackages->asOrderedSet())
     *   .addElements(element.ownedClasses->asOrderedSet())
     *   .addElements(element.ownedPrecedences->asOrderedSet())
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitLibrary(final @NonNull /*@NonInvalid*/ Library element_7) {
        final @NonNull /*@NonInvalid*/ List<Object> ECORE_OrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Object.class, OrderedSet);
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements((EList)ECORE_OrderedSet);
        final @NonNull /*@Thrown*/ List<Package> ownedPackages = element_7.getOwnedPackages();
        final @NonNull /*@Thrown*/ SetValue BOXED_ownedPackages = idResolver.createSetOfAll(SET_CLSSid_Package, ownedPackages);
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedPackages);
        final @NonNull /*@Thrown*/ List<Package> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet);
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements((EList)ECORE_asOrderedSet);
        final @NonNull /*@Thrown*/ List<Class> ownedClasses = element_7.getOwnedClasses();
        final @NonNull /*@Thrown*/ SetValue BOXED_ownedClasses = idResolver.createSetOfAll(SET_CLSSid_Class, ownedClasses);
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet_0 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedClasses);
        final @NonNull /*@Thrown*/ List<Class> ECORE_asOrderedSet_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Class.class, asOrderedSet_0);
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_1 = addElements_0.addElements((EList)ECORE_asOrderedSet_0);
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Precedence> ownedPrecedences = element_7.getOwnedPrecedences();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedPrecedences = idResolver.createOrderedSetOfAll(ORD_CLSSid_Precedence, ownedPrecedences);
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet_1 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedPrecedences);
        final @NonNull /*@Thrown*/ List<Precedence> ECORE_asOrderedSet_1 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Precedence.class, asOrderedSet_1);
        final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements_1.addElements((EList)ECORE_asOrderedSet_1);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_7);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitModel(element : Model[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * this.parentEnv(element)
     * .addElements(element.ownedImports->asOrderedSet())
     * .addElements(element.ownedPackages->asOrderedSet())
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitModel(final @NonNull /*@NonInvalid*/ Model element_8) {
        final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_8);
        if (parentEnv == null) {
            throw new InvalidValueException("Null source for \'lookup::LookupEnvironment::addElements(NE)(OrderedSet(addElements.NE)) : lookup::LookupEnvironment[1]\'");
        }
        final @NonNull /*@Thrown*/ List<Import> ownedImports = element_8.getOwnedImports();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedImports = idResolver.createOrderedSetOfAll(ORD_CLSSid_Import, ownedImports);
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedImports);
        final @NonNull /*@Thrown*/ List<Import> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Import.class, asOrderedSet);
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = parentEnv.addElements((EList)ECORE_asOrderedSet);
        final @NonNull /*@Thrown*/ List<Package> ownedPackages = element_8.getOwnedPackages();
        final @NonNull /*@Thrown*/ SetValue BOXED_ownedPackages = idResolver.createSetOfAll(SET_CLSSid_Package, ownedPackages);
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet_0 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedPackages);
        final @NonNull /*@Thrown*/ List<Package> ECORE_asOrderedSet_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet_0);
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements((EList)ECORE_asOrderedSet_0);
        return addElements_0;
    }
    
    /**
     * visitOperation(element : Operation[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if ownedParameters->includes(child)
     * then this.parentEnv(element)
     * else
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(element.ownedParameters)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitOperation(final @NonNull /*@NonInvalid*/ Operation element_9) {
        final @NonNull /*@Thrown*/ List<Parameter> ownedParameters = element_9.getOwnedParameters();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedParameters = idResolver.createOrderedSetOfAll(ORD_CLSSid_Parameter, ownedParameters);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownedParameters, child).booleanValue();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
        if (includes) {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_9);
            symbol_1 = parentEnv;
        }
        else {
            final @NonNull /*@Thrown*/ LookupEnvironment inner = context.addElements((EList)ownedParameters);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_9);
                symbol_0 = parentEnv_0;
            }
            symbol_1 = symbol_0;
        }
        return symbol_1;
    }
    
    /**
     * visitPackage(element : Package[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   inner : lookup::LookupEnvironment[1] = context.addElements(
     *     element.ownedPackages->asOrderedSet())
     *   .addElements(element.ownedClasses->asOrderedSet())
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitPackage(final @NonNull /*@NonInvalid*/ Package element_10) {
        final @NonNull /*@Thrown*/ List<Package> ownedPackages = element_10.getOwnedPackages();
        final @NonNull /*@Thrown*/ SetValue BOXED_ownedPackages = idResolver.createSetOfAll(SET_CLSSid_Package, ownedPackages);
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedPackages);
        final @NonNull /*@Thrown*/ List<Package> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet);
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements((EList)ECORE_asOrderedSet);
        final @NonNull /*@Thrown*/ List<Class> ownedClasses = element_10.getOwnedClasses();
        final @NonNull /*@Thrown*/ SetValue BOXED_ownedClasses = idResolver.createSetOfAll(SET_CLSSid_Class, ownedClasses);
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet_0 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(BOXED_ownedClasses);
        final @NonNull /*@Thrown*/ List<Class> ECORE_asOrderedSet_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Class.class, asOrderedSet_0);
        final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements.addElements((EList)ECORE_asOrderedSet_0);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_10);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
}
