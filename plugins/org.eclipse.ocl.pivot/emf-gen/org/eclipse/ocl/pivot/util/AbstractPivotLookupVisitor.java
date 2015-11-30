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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment;
import org.eclipse.ocl.pivot.internal.lookup.LookupPackage;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSequenceOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
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
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Constraint = PACKid_$metamodel$.getClassId("Constraint", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_DataType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("DataType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_DataType_0 = PACKid_$metamodel$.getClassId("DataType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Enumeration = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Enumeration", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_EnumerationLiteral = PACKid_$metamodel$.getClassId("EnumerationLiteral", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Enumeration_0 = PACKid_$metamodel$.getClassId("Enumeration", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ExpressionInOCL = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("ExpressionInOCL", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ExpressionInOCL_0 = PACKid_$metamodel$.getClassId("ExpressionInOCL", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IterateExp = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("IterateExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IterateExp_0 = PACKid_$metamodel$.getClassId("IterateExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IteratorExp = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("IteratorExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IteratorExp_0 = PACKid_$metamodel$.getClassId("IteratorExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LanguageExpression = PACKid_$metamodel$.getClassId("LanguageExpression", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LetExp = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("LetExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LetExp_0 = PACKid_$metamodel$.getClassId("LetExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Library = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Library", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Library_0 = PACKid_$metamodel$.getClassId("Library", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Lookup.getClassId("LookupEnvironment", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Namespace = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Namespace", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Namespace_0 = PACKid_$metamodel$.getClassId("Namespace", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Operation = PACKid_$metamodel$.getClassId("Operation", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Operation_0 = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Operation", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package_0 = PACKid_$metamodel$.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Parameter = PACKid_$metamodel$.getClassId("Parameter", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Precedence = PACKid_$metamodel$.getClassId("Precedence", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Property_0 = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Property", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Variable_0 = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Pivot.getClassId("Variable", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_EnumerationLiteral = TypeId.ORDERED_SET.getSpecializedId(CLSSid_EnumerationLiteral);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Precedence = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Precedence);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Variable = TypeId.SEQUENCE.getSpecializedId(CLSSid_Variable);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Behavior = TypeId.SET.getSpecializedId(CLSSid_Behavior);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class_0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Constraint = TypeId.SET.getSpecializedId(CLSSid_Constraint);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_LanguageExpression = TypeId.SET.getSpecializedId(CLSSid_LanguageExpression);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_OCLExpression = TypeId.SET.getSpecializedId(CLSSid_OCLExpression);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package_0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Variable = TypeId.SET.getSpecializedId(CLSSid_Variable);
    
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
     *   inner : lookup::LookupEnvironment[1] = context.addElements(
     *     ownedProperties->select(not isStatic))
     *   .addElements(ownedOperations->select(not isStatic))
     *   .addElements(ownedBehaviors)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitClass(final @NonNull /*@NonInvalid*/ Class element) {
        final @NonNull /*@Thrown*/ List<Property> ownedProperties = element.getOwnedProperties();
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
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements(ECORE_select);
        final @NonNull /*@Thrown*/ List<Operation> ownedOperations = element.getOwnedOperations();
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
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements(ECORE_select_0);
        final @NonNull /*@Thrown*/ List<Behavior> ownedBehaviors = element.getOwnedBehaviors();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements_0.addElements(ownedBehaviors);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitDataType(element : DataType[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   inner : lookup::LookupEnvironment[1] = context.addElements(
     *     ownedProperties->select(not isStatic))
     *   .addElements(ownedOperations->select(not isStatic))
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitDataType(final @NonNull /*@NonInvalid*/ DataType element_0) {
        final @NonNull /*@Thrown*/ List<Property> ownedProperties = element_0.getOwnedProperties();
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
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements(ECORE_select);
        final @NonNull /*@Thrown*/ List<Operation> ownedOperations = element_0.getOwnedOperations();
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
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements.addElements(ECORE_select_0);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_0);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitEnumeration(element : Enumeration[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   inner : lookup::LookupEnvironment[1] = context.addElements(ownedLiterals)
     *   .addElements(ownedProperties->select(not isStatic))
     *   .addElements(ownedOperations->select(not isStatic))
     *   .addElements(ownedBehaviors)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitEnumeration(final @NonNull /*@NonInvalid*/ Enumeration element_1) {
        final @NonNull /*@Thrown*/ List<EnumerationLiteral> ownedLiterals = element_1.getOwnedLiterals();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements(ownedLiterals);
        final @NonNull /*@Thrown*/ List<Property> ownedProperties = element_1.getOwnedProperties();
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
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements(ECORE_select);
        final @NonNull /*@Thrown*/ List<Operation> ownedOperations = element_1.getOwnedOperations();
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
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_1 = addElements_0.addElements(ECORE_select_0);
        final @NonNull /*@Thrown*/ List<Behavior> ownedBehaviors = element_1.getOwnedBehaviors();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements_1.addElements(ownedBehaviors);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_1);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitExpressionInOCL(element : ExpressionInOCL[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   inner : lookup::LookupEnvironment[1] = context.addElements(
     *     ownedContext->asSequence())
     *   .addElements(ownedParameters)
     *   .addElements(ownedResult->asSequence())
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitExpressionInOCL(final @NonNull /*@NonInvalid*/ ExpressionInOCL element_2) {
        final @Nullable /*@Thrown*/ Variable ownedContext = element_2.getOwnedContext();
        final @NonNull /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Variable, ownedContext);
        final @NonNull /*@Thrown*/ SequenceValue asSequence = CollectionAsSequenceOperation.INSTANCE.evaluate(oclAsSet);
        final @NonNull /*@Thrown*/ List<Variable> ECORE_asSequence = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, asSequence);
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements(ECORE_asSequence);
        final @NonNull /*@Thrown*/ List<Variable> ownedParameters = element_2.getOwnedParameters();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements(ownedParameters);
        final @Nullable /*@Thrown*/ Variable ownedResult = element_2.getOwnedResult();
        final @NonNull /*@Thrown*/ SetValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Variable, ownedResult);
        final @NonNull /*@Thrown*/ SequenceValue asSequence_0 = CollectionAsSequenceOperation.INSTANCE.evaluate(oclAsSet_0);
        final @NonNull /*@Thrown*/ List<Variable> ECORE_asSequence_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, asSequence_0);
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements_0.addElements(ECORE_asSequence_0);
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
     * visitIterateExp(element : IterateExp[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if ownedIterators->includes(child)
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(
     *       ownedResult->asSequence())
     *     .addElements(
     *       ownedIterators->select(x |
     *         element.ownedIterators->indexOf(x) <
     *         element.ownedIterators->indexOf(child)))
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(ownedIterators)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitIterateExp(final @NonNull /*@NonInvalid*/ IterateExp element_3) {
        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = element_3.getOwnedIterators();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(ORD_CLSSid_Variable, ownedIterators);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownedIterators, child).booleanValue();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_2;
        if (includes) {
            final @Nullable /*@Thrown*/ Variable ownedResult = element_3.getOwnedResult();
            final @NonNull /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Variable, ownedResult);
            final @NonNull /*@Thrown*/ SequenceValue asSequence = CollectionAsSequenceOperation.INSTANCE.evaluate(oclAsSet);
            final @NonNull /*@Thrown*/ List<Variable> ECORE_asSequence = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, asSequence);
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements(ECORE_asSequence);
            @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Variable);
            @Nullable Iterator<?> ITERATOR_x = BOXED_ownedIterators.iterator();
            @NonNull /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                @Nullable /*@NonInvalid*/ Variable x = (Variable)ITERATOR_x.next();
                /**
                 * element.ownedIterators->indexOf(x) < element.ownedIterators->indexOf(child)
                 */
                final @NonNull /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedIterators, x);
                final @NonNull /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedIterators, child);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final @NonNull /*@Thrown*/ List<Variable> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, select);
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements.addElements(ECORE_select);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_3);
                symbol_0 = parentEnv;
            }
            symbol_2 = symbol_0;
        }
        else {
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ LookupEnvironment inner_0 = context.addElements(ownedIterators);
            final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
            if (hasFinalResult_0) {
                symbol_1 = inner_0;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_3);
                symbol_1 = parentEnv_0;
            }
            symbol_2 = symbol_1;
        }
        return symbol_2;
    }
    
    /**
     * visitIteratorExp(element : IteratorExp[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if ownedIterators->includes(child)
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(
     *       ownedIterators->select(x |
     *         element.ownedIterators->indexOf(x) <
     *         element.ownedIterators->indexOf(child)))
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(ownedIterators)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitIteratorExp(final @NonNull /*@NonInvalid*/ IteratorExp element_4) {
        final @NonNull /*@Thrown*/ List<Variable> ownedIterators = element_4.getOwnedIterators();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(ORD_CLSSid_Variable, ownedIterators);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownedIterators, child).booleanValue();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_2;
        if (includes) {
            @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Variable);
            @Nullable Iterator<?> ITERATOR_x = BOXED_ownedIterators.iterator();
            @NonNull /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                @Nullable /*@NonInvalid*/ Variable x = (Variable)ITERATOR_x.next();
                /**
                 * element.ownedIterators->indexOf(x) < element.ownedIterators->indexOf(child)
                 */
                final @NonNull /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedIterators, x);
                final @NonNull /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedIterators, child);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final @NonNull /*@Thrown*/ List<Variable> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, select);
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ LookupEnvironment inner = context.addElements(ECORE_select);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_4);
                symbol_0 = parentEnv;
            }
            symbol_2 = symbol_0;
        }
        else {
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ LookupEnvironment inner_0 = context.addElements(ownedIterators);
            final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
            if (hasFinalResult_0) {
                symbol_1 = inner_0;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_4);
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
     * if ownedIn->includes(child)
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(
     *       ownedVariable->asSequence())
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitLetExp(final @NonNull /*@NonInvalid*/ LetExp element_5) {
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ OCLExpression ownedIn = element_5.getOwnedIn();
        final @NonNull /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_OCLExpression, ownedIn);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(oclAsSet, child).booleanValue();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
        if (includes) {
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ Variable ownedVariable = element_5.getOwnedVariable();
            final @NonNull /*@Thrown*/ SetValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Variable, ownedVariable);
            final @NonNull /*@Thrown*/ SequenceValue asSequence = CollectionAsSequenceOperation.INSTANCE.evaluate(oclAsSet_0);
            final @NonNull /*@Thrown*/ List<Variable> ECORE_asSequence = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Variable.class, asSequence);
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ LookupEnvironment inner = context.addElements(ECORE_asSequence);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_5);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_5);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitLibrary(element : Library[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   inner : lookup::LookupEnvironment[1] = context.addElements(ownedPackages)
     *   .addElements(ownedClasses)
     *   .addElements(ownedPrecedences)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitLibrary(final @NonNull /*@NonInvalid*/ Library element_6) {
        final @NonNull /*@Thrown*/ List<Package> ownedPackages = element_6.getOwnedPackages();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements(ownedPackages);
        final @NonNull /*@Thrown*/ List<Class> ownedClasses = element_6.getOwnedClasses();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements(ownedClasses);
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Precedence> ownedPrecedences = element_6.getOwnedPrecedences();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment inner = addElements_0.addElements(ownedPrecedences);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_6);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitNamespace(element : Namespace[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitNamespace(final @NonNull /*@NonInvalid*/ Namespace element_7) {
        final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_7);
        return parentEnv;
    }
    
    /**
     * visitOperation(element : Operation[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if bodyExpression->includes(child)
     * then
     *   let
     *     inner : lookup::LookupEnvironment[1] = context.addElements(ownedParameters)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   if ownedPostconditions->includes(child)
     *   then
     *     let
     *       inner : lookup::LookupEnvironment[1] = context.addElements(ownedParameters)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   else this.parentEnv(element)
     *   endif
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitOperation(final @NonNull /*@NonInvalid*/ Operation element_8) {
        final @Nullable /*@Thrown*/ LanguageExpression bodyExpression = element_8.getBodyExpression();
        final @NonNull /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_LanguageExpression, bodyExpression);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(oclAsSet, child).booleanValue();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_3;
        if (includes) {
            final @NonNull /*@Thrown*/ List<Parameter> ownedParameters = element_8.getOwnedParameters();
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ LookupEnvironment inner = context.addElements(ownedParameters);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_8);
                symbol_0 = parentEnv;
            }
            symbol_3 = symbol_0;
        }
        else {
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ List<Constraint> ownedPostconditions = element_8.getOwnedPostconditions();
            final @NonNull /*@Thrown*/ SetValue BOXED_ownedPostconditions = idResolver.createSetOfAll(SET_CLSSid_Constraint, ownedPostconditions);
            final /*@Thrown*/ boolean includes_0 = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownedPostconditions, child).booleanValue();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_2;
            if (includes_0) {
                final @NonNull /*@Thrown*/ List<Parameter> ownedParameters_0 = element_8.getOwnedParameters();
                @SuppressWarnings("null")
                final @NonNull /*@Thrown*/ LookupEnvironment inner_0 = context.addElements(ownedParameters_0);
                final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
                @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
                if (hasFinalResult_0) {
                    symbol_1 = inner_0;
                }
                else {
                    final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_8);
                    symbol_1 = parentEnv_0;
                }
                symbol_2 = symbol_1;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_1 = this.parentEnv(element_8);
                symbol_2 = parentEnv_1;
            }
            symbol_3 = symbol_2;
        }
        return symbol_3;
    }
    
    /**
     * visitPackage(element : Package[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * let
     *   inner : lookup::LookupEnvironment[1] = context.addElements(ownedClasses)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitPackage(final @NonNull /*@NonInvalid*/ Package element_9) {
        final @NonNull /*@Thrown*/ List<Class> ownedClasses = element_9.getOwnedClasses();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment inner = context.addElements(ownedClasses);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_9);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitProperty(element : Property[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitProperty(final @NonNull /*@NonInvalid*/ Property element_10) {
        final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_10);
        return parentEnv;
    }
    
    /**
     * visitVariable(element : Variable[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitVariable(final @NonNull /*@NonInvalid*/ Variable element_11) {
        final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_11);
        return parentEnv;
    }
}
