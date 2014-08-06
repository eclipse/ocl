/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.ocl.examples.pivot.lookup;

import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation;
import org.eclipse.ocl.examples.library.numeric.NumericMinusOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Import;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.lookup.Environment;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

public class AutoPivotLookupVisitor
	extends AbstractExtendingVisitor<Environment, Environment>
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_example_org_s_examples_s_env_ecore = IdManager.getNsURIPackageId("http://www.example.org/examples/env.ecore", null, null);
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_java_c_s_s_org_eclipse_ocl_examples_pivot_lookup = IdManager.getRootPackageId("java://org.eclipse.ocl.examples.pivot.lookup");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_examples_domain_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.examples.domain.evaluation");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_examples_domain_types = IdManager.getRootPackageId("org.eclipse.ocl.examples.domain.types");
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AutoPivotLookupVisitor = PACKid_java_c_s_s_org_eclipse_ocl_examples_pivot_lookup.getClassId("AutoPivotLookupVisitor", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Behavior = PACKid_$metamodel$.getClassId("Behavior", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_DataType = PACKid_$metamodel$.getClassId("DataType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_DomainEvaluator = PACKid_org_eclipse_ocl_examples_domain_evaluation.getClassId("DomainEvaluator", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Element = PACKid_$metamodel$.getClassId("Element", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Enumeration = PACKid_$metamodel$.getClassId("Enumeration", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_EnumerationLiteral = PACKid_$metamodel$.getClassId("EnumerationLiteral", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Environment = PACKid_http_c_s_s_www_example_org_s_examples_s_env_ecore.getClassId("Environment", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ExpressionInOCL = PACKid_$metamodel$.getClassId("ExpressionInOCL", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_examples_domain_types.getClassId("IdResolver", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Import = PACKid_$metamodel$.getClassId("Import", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IterateExp = PACKid_$metamodel$.getClassId("IterateExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IteratorExp = PACKid_$metamodel$.getClassId("IteratorExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LetExp = PACKid_$metamodel$.getClassId("LetExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Library = PACKid_$metamodel$.getClassId("Library", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Metaclass = PACKid_$metamodel$.getClassId("Metaclass", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Operation = PACKid_$metamodel$.getClassId("Operation", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_$metamodel$.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Parameter = PACKid_$metamodel$.getClassId("Parameter", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Precedence = PACKid_$metamodel$.getClassId("Precedence", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Root = PACKid_$metamodel$.getClassId("Root", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Type = PACKid_$metamodel$.getClassId("Type", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_1 = ValuesUtil.integerValueOf("1");
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_Operation = TypeId.BAG.getSpecializedId(CLSSid_Operation);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_Property = TypeId.BAG.getSpecializedId(CLSSid_Property);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_EnumerationLiteral = TypeId.ORDERED_SET.getSpecializedId(CLSSid_EnumerationLiteral);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Import = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Import);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Precedence = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Precedence);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Type = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Type);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Behavior = TypeId.SET.getSpecializedId(CLSSid_Behavior);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Type = TypeId.SET.getSpecializedId(CLSSid_Type);
    
    protected @Nullable /*@Thrown*/ Element child;
    protected final @NonNull /*@Thrown*/ DomainEvaluator evaluator;
    protected final @NonNull /*@Thrown*/ IdResolver idResolver;
    
    public AutoPivotLookupVisitor(@NonNull Environment context) {
        super(context);
        this.evaluator = context.getEvaluator();
        this.idResolver = evaluator.getIdResolver();
    }
    
    /**
     * Return the results of a lookup from the child of element.
     */
    public @Nullable Environment envForChild(@NonNull Element element, @Nullable Element child) {
        this.child = element;
        return element.accept(this);
    }
    
    /**
     * Continue the search for matches in the parent of element.
     */
    protected @Nullable Environment parentEnv(@NonNull Element element) {
        EObject parent = element.eContainer();
        if (parent instanceof Visitable) {
            this.child = element;
            return ((Visitable)parent).accept(this);
        }
        else {
            return null;
        }
    }
    
    public @Nullable Environment visiting(@NonNull Visitable visitable) {
        throw new UnsupportedOperationException("AutoPivotLookupVisitor is not supported by \"" + getClass().getName() + "\"");
    }
    
    /**
     * visitClass(element : Class) : env::Environment[?]
     * 
     * 
     * let superClasses : Set(Class) = element->closure(superClass)
     * in
     *   let
     *     inner : env::Environment = context.addElements(
     *       superClasses.ownedAttribute->select(not isStatic))
     *     .addElements(superClasses.ownedOperation->select(not isStatic))
     *     .addElements(element.ownedBehavior)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitClass(final @NonNull /*@NonInvalid*/ Class element) {
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ DomainStandardLibrary standardLibrary = idResolver.getStandardLibrary();
        final @NonNull /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_Class, element);
        final @NonNull DomainType TYPE_superClasses_0 = evaluator.getStaticTypeOf(oclAsSet);
        final @NonNull LibraryIteration IMPL_superClasses_0 = (LibraryIteration)TYPE_superClasses_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
        final @NonNull Object ACC_superClasses_0 = IMPL_superClasses_0.createAccumulatorValue(evaluator, SET_CLSSid_Class, ORD_CLSSid_Type);
        /**
         * Implementation of the iterator body.
         */
        final @NonNull AbstractBinaryOperation BODY_superClasses_0 = new AbstractBinaryOperation()
        {
            /**
             * superClass
             */
            @Override
            public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final @Nullable /*@NonInvalid*/ Object _1) {
                final @Nullable /*@NonInvalid*/ Class symbol_0 = (Class)_1;
                if (symbol_0 == null) {
                    throw new InvalidValueException("Null source for \'pivot::Type::superClass\'");
                }
                final @NonNull /*@Thrown*/ List<? extends DomainType> superClass = symbol_0.getSuperClass();
                final @NonNull /*@Thrown*/ OrderedSetValue BOXED_superClass = idResolver.createOrderedSetOfAll(ORD_CLSSid_Type, superClass);
                return BOXED_superClass;
            }
        };
        final @NonNull  ExecutorSingleIterationManager MGR_superClasses_0 = new ExecutorSingleIterationManager(evaluator, SET_CLSSid_Class, BODY_superClasses_0, oclAsSet, ACC_superClasses_0);
        final @NonNull /*@Thrown*/ SetValue superClasses = DomainUtil.nonNullState((SetValue)IMPL_superClasses_0.evaluateIteration(MGR_superClasses_0));
        @NonNull /*@Thrown*/ BagValue.Accumulator accumulator = ValuesUtil.createBagAccumulatorValue(BAG_CLSSid_Property);
        @Nullable Iterator<?> ITERATOR__1_0 = superClasses.iterator();
        @NonNull /*@Thrown*/ BagValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ Class _1_0 = (Class)ITERATOR__1_0.next();
            /**
             * ownedAttribute
             */
            if (_1_0 == null) {
                throw new InvalidValueException("Null source for \'pivot::Type::ownedAttribute\'");
            }
            final @NonNull /*@Thrown*/ List<? extends DomainProperty> ownedAttribute = _1_0.getOwnedAttribute();
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedAttribute = idResolver.createOrderedSetOfAll(ORD_CLSSid_Property, ownedAttribute);
            //
            for (Object value : BOXED_ownedAttribute.flatten().getElements()) {
                accumulator.add(value);
            }
        }
        @NonNull /*@Thrown*/ BagValue.Accumulator accumulator_0 = ValuesUtil.createBagAccumulatorValue(BAG_CLSSid_Property);
        @Nullable Iterator<?> ITERATOR__1_1 = collect.iterator();
        @NonNull /*@Thrown*/ BagValue select;
        while (true) {
            if (!ITERATOR__1_1.hasNext()) {
                select = accumulator_0;
                break;
            }
            @Nullable /*@NonInvalid*/ DomainProperty _1_1 = (DomainProperty)ITERATOR__1_1.next();
            /**
             * _'null' : Boolean
             */
            @NonNull /*@Caught*/ Object CAUGHT_self_0;
            try {
                if (_1_1 == null) {
                    throw new InvalidValueException("Null source for \'pivot::NamedElement::isStatic\'");
                }
                final /*@Thrown*/ boolean self_0 = _1_1.isStatic();
                CAUGHT_self_0 = self_0;
            }
            catch (Exception e) {
                CAUGHT_self_0 = ValuesUtil.createInvalidValue(e);
            }
            if (CAUGHT_self_0 instanceof InvalidValueException) {
                throw (InvalidValueException)CAUGHT_self_0;
            }
            final /*@NonInvalid*/ boolean symbol_1 = CAUGHT_self_0 instanceof InvalidValueException;
            /*@Thrown*/ boolean symbol_2;
            if (symbol_1) {
                symbol_2 = (Boolean)CAUGHT_self_0;
            }
            else {
                final /*@Thrown*/ boolean eq = CAUGHT_self_0 == Boolean.FALSE;
                symbol_2 = eq;
            }
            //
            if (symbol_2 == ValuesUtil.TRUE_VALUE) {
                accumulator_0.add(_1_1);
            }
        }
        final List<? extends Property> UNBOXED_select = select.asEcoreObjects(idResolver, Property.class);
        assert UNBOXED_select != null;
        final @NonNull /*@Thrown*/ Environment addElements = context.addElements(UNBOXED_select);
        @NonNull /*@Thrown*/ BagValue.Accumulator accumulator_1 = ValuesUtil.createBagAccumulatorValue(BAG_CLSSid_Operation);
        @Nullable Iterator<?> ITERATOR__1_2 = superClasses.iterator();
        @NonNull /*@Thrown*/ BagValue collect_0;
        while (true) {
            if (!ITERATOR__1_2.hasNext()) {
                collect_0 = accumulator_1;
                break;
            }
            @Nullable /*@NonInvalid*/ Class _1_2 = (Class)ITERATOR__1_2.next();
            /**
             * ownedOperation
             */
            if (_1_2 == null) {
                throw new InvalidValueException("Null source for \'pivot::Type::ownedOperation\'");
            }
            final @NonNull /*@Thrown*/ List<? extends DomainOperation> ownedOperation = _1_2.getOwnedOperation();
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedOperation = idResolver.createOrderedSetOfAll(ORD_CLSSid_Operation, ownedOperation);
            //
            for (Object value : BOXED_ownedOperation.flatten().getElements()) {
                accumulator_1.add(value);
            }
        }
        @NonNull /*@Thrown*/ BagValue.Accumulator accumulator_2 = ValuesUtil.createBagAccumulatorValue(BAG_CLSSid_Operation);
        @Nullable Iterator<?> ITERATOR__1_3 = collect_0.iterator();
        @NonNull /*@Thrown*/ BagValue select_0;
        while (true) {
            if (!ITERATOR__1_3.hasNext()) {
                select_0 = accumulator_2;
                break;
            }
            @Nullable /*@NonInvalid*/ DomainOperation _1_3 = (DomainOperation)ITERATOR__1_3.next();
            /**
             * _'null' : Boolean
             */
            @NonNull /*@Caught*/ Object CAUGHT_self_1;
            try {
                if (_1_3 == null) {
                    throw new InvalidValueException("Null source for \'pivot::NamedElement::isStatic\'");
                }
                final /*@Thrown*/ boolean self_1 = _1_3.isStatic();
                CAUGHT_self_1 = self_1;
            }
            catch (Exception e) {
                CAUGHT_self_1 = ValuesUtil.createInvalidValue(e);
            }
            if (CAUGHT_self_1 instanceof InvalidValueException) {
                throw (InvalidValueException)CAUGHT_self_1;
            }
            final /*@NonInvalid*/ boolean symbol_3 = CAUGHT_self_1 instanceof InvalidValueException;
            /*@Thrown*/ boolean symbol_4;
            if (symbol_3) {
                symbol_4 = (Boolean)CAUGHT_self_1;
            }
            else {
                final /*@Thrown*/ boolean eq_0 = CAUGHT_self_1 == Boolean.FALSE;
                symbol_4 = eq_0;
            }
            //
            if (symbol_4 == ValuesUtil.TRUE_VALUE) {
                accumulator_2.add(_1_3);
            }
        }
        final List<? extends Operation> UNBOXED_select_0 = select_0.asEcoreObjects(idResolver, Operation.class);
        assert UNBOXED_select_0 != null;
        final @NonNull /*@Thrown*/ Environment addElements_0 = addElements.addElements(UNBOXED_select_0);
        final @Nullable /*@Thrown*/ List<Behavior> ownedBehavior = element.getOwnedBehavior();
        assert ownedBehavior != null;
        final @NonNull /*@Thrown*/ Environment inner = addElements_0.addElements(ownedBehavior);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ Environment symbol_5;
        if (hasFinalResult) {
            symbol_5 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element);
            symbol_5 = parentEnv;
        }
        return symbol_5;
    }
    
    /**
     * visitDataType(element : DataType) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitDataType(final @NonNull /*@NonInvalid*/ DataType element_0) {
        final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_0);
        return parentEnv;
    }
    
    /**
     * visitElement(element : Element) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitElement(final @NonNull /*@NonInvalid*/ Element element_1) {
        final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_1);
        return parentEnv;
    }
    
    /**
     * visitEnumeration(element : Enumeration) : env::Environment[?]
     * 
     * 
     * let
     *   inner : env::Environment = context.addElements(element.ownedLiteral)
     *   .addElements(element.ownedAttribute->select(not isStatic))
     *   .addElements(element.ownedOperation->select(not isStatic))
     *   .addElements(element.ownedBehavior)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitEnumeration(final @NonNull /*@NonInvalid*/ Enumeration element_2) {
        final @NonNull /*@Thrown*/ List<EnumerationLiteral> ownedLiteral = element_2.getOwnedLiteral();
        final @NonNull /*@Thrown*/ Environment addElements = context.addElements(ownedLiteral);
        final @NonNull /*@Thrown*/ List<? extends DomainProperty> ownedAttribute = element_2.getOwnedAttribute();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedAttribute = idResolver.createOrderedSetOfAll(ORD_CLSSid_Property, ownedAttribute);
        @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValuesUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Property);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedAttribute.iterator();
        @NonNull /*@Thrown*/ OrderedSetValue select;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                select = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ DomainProperty _1 = (DomainProperty)ITERATOR__1.next();
            /**
             * _'null' : Boolean
             */
            @NonNull /*@Caught*/ Object CAUGHT_self_0;
            try {
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'pivot::NamedElement::isStatic\'");
                }
                final /*@Thrown*/ boolean self_0 = _1.isStatic();
                CAUGHT_self_0 = self_0;
            }
            catch (Exception e) {
                CAUGHT_self_0 = ValuesUtil.createInvalidValue(e);
            }
            if (CAUGHT_self_0 instanceof InvalidValueException) {
                throw (InvalidValueException)CAUGHT_self_0;
            }
            final /*@NonInvalid*/ boolean symbol_0 = CAUGHT_self_0 instanceof InvalidValueException;
            /*@Thrown*/ boolean symbol_1;
            if (symbol_0) {
                symbol_1 = (Boolean)CAUGHT_self_0;
            }
            else {
                final /*@Thrown*/ boolean eq = CAUGHT_self_0 == Boolean.FALSE;
                symbol_1 = eq;
            }
            //
            if (symbol_1 == ValuesUtil.TRUE_VALUE) {
                accumulator.add(_1);
            }
        }
        final List<? extends Property> UNBOXED_select = select.asEcoreObjects(idResolver, Property.class);
        assert UNBOXED_select != null;
        final @NonNull /*@Thrown*/ Environment addElements_0 = addElements.addElements(UNBOXED_select);
        final @NonNull /*@Thrown*/ List<? extends DomainOperation> ownedOperation = element_2.getOwnedOperation();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedOperation = idResolver.createOrderedSetOfAll(ORD_CLSSid_Operation, ownedOperation);
        @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator_0 = ValuesUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Operation);
        @Nullable Iterator<?> ITERATOR__1_0 = BOXED_ownedOperation.iterator();
        @NonNull /*@Thrown*/ OrderedSetValue select_0;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                select_0 = accumulator_0;
                break;
            }
            @Nullable /*@NonInvalid*/ DomainOperation _1_0 = (DomainOperation)ITERATOR__1_0.next();
            /**
             * _'null' : Boolean
             */
            @NonNull /*@Caught*/ Object CAUGHT_self_1;
            try {
                if (_1_0 == null) {
                    throw new InvalidValueException("Null source for \'pivot::NamedElement::isStatic\'");
                }
                final /*@Thrown*/ boolean self_1 = _1_0.isStatic();
                CAUGHT_self_1 = self_1;
            }
            catch (Exception e) {
                CAUGHT_self_1 = ValuesUtil.createInvalidValue(e);
            }
            if (CAUGHT_self_1 instanceof InvalidValueException) {
                throw (InvalidValueException)CAUGHT_self_1;
            }
            final /*@NonInvalid*/ boolean symbol_2 = CAUGHT_self_1 instanceof InvalidValueException;
            /*@Thrown*/ boolean symbol_3;
            if (symbol_2) {
                symbol_3 = (Boolean)CAUGHT_self_1;
            }
            else {
                final /*@Thrown*/ boolean eq_0 = CAUGHT_self_1 == Boolean.FALSE;
                symbol_3 = eq_0;
            }
            //
            if (symbol_3 == ValuesUtil.TRUE_VALUE) {
                accumulator_0.add(_1_0);
            }
        }
        final List<? extends Operation> UNBOXED_select_0 = select_0.asEcoreObjects(idResolver, Operation.class);
        assert UNBOXED_select_0 != null;
        final @NonNull /*@Thrown*/ Environment addElements_1 = addElements_0.addElements(UNBOXED_select_0);
        final @Nullable /*@Thrown*/ List<Behavior> ownedBehavior = element_2.getOwnedBehavior();
        assert ownedBehavior != null;
        final @NonNull /*@Thrown*/ Environment inner = addElements_1.addElements(ownedBehavior);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ Environment symbol_4;
        if (hasFinalResult) {
            symbol_4 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_2);
            symbol_4 = parentEnv;
        }
        return symbol_4;
    }
    
    /**
     * visitExpressionInOCL(element : ExpressionInOCL) : env::Environment[?]
     * 
     * 
     * let
     *   inner : env::Environment = context.addElement(element.contextVariable)
     *   .addElements(element.parameterVariable)
     *   .addElement(element.resultVariable)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitExpressionInOCL(final @NonNull /*@NonInvalid*/ ExpressionInOCL element_3) {
        final @Nullable /*@Thrown*/ Variable contextVariable = element_3.getContextVariable();
        final @NonNull /*@Thrown*/ Environment addElement = context.addElement(contextVariable);
        final @NonNull /*@Thrown*/ List<Variable> parameterVariable = element_3.getParameterVariable();
        final @NonNull /*@Thrown*/ Environment addElements = addElement.addElements(parameterVariable);
        final @Nullable /*@Thrown*/ Variable resultVariable = element_3.getResultVariable();
        final @NonNull /*@Thrown*/ Environment inner = addElements.addElement(resultVariable);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ Environment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_3);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitIterateExp(element : IterateExp) : env::Environment[?]
     * 
     * 
     * if child = result
     * then
     *   let
     *     inner : env::Environment = context.addElements(element.iterator)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   let index : Integer = iterator->indexOf(child)
     *   in
     *     if index > 1
     *     then
     *       let
     *         inner : env::Environment = context.addElements(
     *           element.iterator->subOrderedSet(1, index - 1))
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     else
     *       let
     *         inner : env::Environment = context.addElements(element.iterator)
     *         .addElement(result)
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     endif
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitIterateExp(final @NonNull /*@NonInvalid*/ IterateExp element_4) {
        final @NonNull /*@Thrown*/ List<Variable> iterator = element_4.getIterator();
        final @Nullable /*@Thrown*/ Variable result = element_4.getResult();
        final /*@Thrown*/ boolean eq = (child != null) ? child.equals(result) : (result == null);
        @Nullable /*@Thrown*/ Environment symbol_4;
        if (eq) {
            final @NonNull /*@Thrown*/ Environment inner = context.addElements(iterator);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_4);
                symbol_0 = parentEnv;
            }
            symbol_4 = symbol_0;
        }
        else {
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Variable, iterator);
            final @NonNull /*@Thrown*/ IntegerValue index = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_iterator_0, child);
            final /*@Thrown*/ boolean gt = NumericGreaterThanOperation.INSTANCE.evaluate(index, INT_1).booleanValue();
            @Nullable /*@Thrown*/ Environment symbol_3;
            if (gt) {
                final @NonNull /*@Thrown*/ IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(index, INT_1);
                final @NonNull /*@Thrown*/ OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_iterator_0, INT_1, diff);
                final List<Variable> UNBOXED_subOrderedSet = subOrderedSet.asEcoreObjects(idResolver, Variable.class);
                assert UNBOXED_subOrderedSet != null;
                final @NonNull /*@Thrown*/ Environment inner_0 = context.addElements(UNBOXED_subOrderedSet);
                final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
                @Nullable /*@Thrown*/ Environment symbol_1;
                if (hasFinalResult_0) {
                    symbol_1 = inner_0;
                }
                else {
                    final @Nullable /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_4);
                    symbol_1 = parentEnv_0;
                }
                symbol_3 = symbol_1;
            }
            else {
                final @NonNull /*@Thrown*/ Environment addElements = context.addElements(iterator);
                final @NonNull /*@Thrown*/ Environment inner_1 = addElements.addElement(result);
                final /*@Thrown*/ boolean hasFinalResult_1 = inner_1.hasFinalResult();
                @Nullable /*@Thrown*/ Environment symbol_2;
                if (hasFinalResult_1) {
                    symbol_2 = inner_1;
                }
                else {
                    final @Nullable /*@Thrown*/ Environment parentEnv_1 = this.parentEnv(element_4);
                    symbol_2 = parentEnv_1;
                }
                symbol_3 = symbol_2;
            }
            symbol_4 = symbol_3;
        }
        return symbol_4;
    }
    
    /**
     * visitIteratorExp(element : IteratorExp) : env::Environment[?]
     * 
     * 
     * let index : Integer = iterator->indexOf(child)
     * in
     *   if index > 1
     *   then
     *     let
     *       inner : env::Environment = context.addElements(
     *         element.iterator->subOrderedSet(1, index - 1))
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   else
     *     let
     *       inner : env::Environment = context.addElements(element.iterator)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitIteratorExp(final @NonNull /*@NonInvalid*/ IteratorExp element_5) {
        final @NonNull /*@Thrown*/ List<Variable> iterator = element_5.getIterator();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(ORD_CLSSid_Variable, iterator);
        final @NonNull /*@Thrown*/ IntegerValue index = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_iterator, child);
        final /*@Thrown*/ boolean gt = NumericGreaterThanOperation.INSTANCE.evaluate(index, INT_1).booleanValue();
        @Nullable /*@Thrown*/ Environment symbol_2;
        if (gt) {
            final @NonNull /*@Thrown*/ IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(index, INT_1);
            final @NonNull /*@Thrown*/ OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_iterator, INT_1, diff);
            final List<Variable> UNBOXED_subOrderedSet = subOrderedSet.asEcoreObjects(idResolver, Variable.class);
            assert UNBOXED_subOrderedSet != null;
            final @NonNull /*@Thrown*/ Environment inner = context.addElements(UNBOXED_subOrderedSet);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_5);
                symbol_0 = parentEnv;
            }
            symbol_2 = symbol_0;
        }
        else {
            final @NonNull /*@Thrown*/ Environment inner_0 = context.addElements(iterator);
            final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
            @Nullable /*@Thrown*/ Environment symbol_1;
            if (hasFinalResult_0) {
                symbol_1 = inner_0;
            }
            else {
                final @Nullable /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_5);
                symbol_1 = parentEnv_0;
            }
            symbol_2 = symbol_1;
        }
        return symbol_2;
    }
    
    /**
     * visitLetExp(element : LetExp) : env::Environment[?]
     * 
     * 
     * if child = _'in'
     * then
     *   let
     *     inner : env::Environment = context.addElement(element.variable)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitLetExp(final @NonNull /*@NonInvalid*/ LetExp element_6) {
        final @Nullable /*@Thrown*/ DomainExpression in = element_6.getIn();
        final /*@Thrown*/ boolean eq = (child != null) ? child.equals(in) : (in == null);
        @Nullable /*@Thrown*/ Environment symbol_1;
        if (eq) {
            final @Nullable /*@Thrown*/ Variable variable = element_6.getVariable();
            final @NonNull /*@Thrown*/ Environment inner = context.addElement(variable);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_6);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final @Nullable /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_6);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitLibrary(element : Library) : env::Environment[?]
     * 
     * 
     * let
     *   inner : env::Environment = context.addElements(element.nestedPackage)
     *   .addElements(element.ownedType)
     *   .addElements(element.ownedPrecedence)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitLibrary(final @NonNull /*@NonInvalid*/ Library element_7) {
        final @Nullable /*@Thrown*/ List<? extends DomainPackage> nestedPackage = element_7.getNestedPackage();
        assert nestedPackage != null;
        final @NonNull /*@Thrown*/ Environment addElements = context.addElements(nestedPackage);
        final @Nullable /*@Thrown*/ List<? extends DomainType> ownedType = element_7.getOwnedType();
        assert ownedType != null;
        final @NonNull /*@Thrown*/ Environment addElements_0 = addElements.addElements(ownedType);
        final @Nullable /*@Thrown*/ List<Precedence> ownedPrecedence = element_7.getOwnedPrecedence();
        assert ownedPrecedence != null;
        final @NonNull /*@Thrown*/ Environment inner = addElements_0.addElements(ownedPrecedence);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ Environment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_7);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitMetaclass(element : Metaclass) : env::Environment[?]
     * 
     * null
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitMetaclass(final @NonNull /*@NonInvalid*/ Metaclass<?> element_8) {
        return null;
    }
    
    /**
     * visitOperation(element : Operation) : env::Environment[?]
     * 
     * 
     * if ownedParameter->includes(child)
     * then this.parentEnv(element)
     * else
     *   let
     *     inner : env::Environment = context.addElements(element.ownedParameter)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitOperation(final @NonNull /*@NonInvalid*/ Operation element_9) {
        final @NonNull /*@Thrown*/ List<? extends DomainTypedElement> ownedParameter = element_9.getOwnedParameter();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedParameter = idResolver.createOrderedSetOfAll(ORD_CLSSid_Parameter, ownedParameter);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownedParameter, child).booleanValue();
        @Nullable /*@Thrown*/ Environment symbol_1;
        if (includes) {
            final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv((Element)element_9);
            symbol_1 = parentEnv;
        }
        else {
            final @NonNull /*@Thrown*/ Environment inner = context.addElements(ownedParameter);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ Environment parentEnv_0 = this.parentEnv((Element)element_9);
                symbol_0 = parentEnv_0;
            }
            symbol_1 = symbol_0;
        }
        return symbol_1;
    }
    
    /**
     * visitPackage(element : Package) : env::Environment[?]
     * 
     * 
     * let
     *   inner : env::Environment = context.addElements(element.nestedPackage)
     *   .addElements(element.ownedType)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitPackage(final @NonNull /*@NonInvalid*/ Package element_10) {
        final @Nullable /*@Thrown*/ List<? extends DomainPackage> nestedPackage = element_10.getNestedPackage();
        assert nestedPackage != null;
        final @NonNull /*@Thrown*/ Environment addElements = context.addElements(nestedPackage);
        final @Nullable /*@Thrown*/ List<? extends DomainType> ownedType = element_10.getOwnedType();
        assert ownedType != null;
        final @NonNull /*@Thrown*/ Environment inner = addElements.addElements(ownedType);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ Environment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv((Element)element_10);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitRoot(element : Root) : env::Environment[?]
     * 
     * 
     * this.parentEnv(element)
     * .addElements(element.imports)
     * .addElements(element.nestedPackage)
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitRoot(final @NonNull /*@NonInvalid*/ Root element_11) {
        final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_11);
        if (parentEnv == null) {
            throw new InvalidValueException("Null source for \'env::Environment::addElements(Collection(pivot::NamedElement)) : env::Environment\'");
        }
        final @NonNull /*@Thrown*/ List<Import> imports = element_11.getImports();
        final @NonNull /*@Thrown*/ Environment addElements = parentEnv.addElements(imports);
        final @Nullable /*@Thrown*/ List<? extends DomainPackage> nestedPackage = element_11.getNestedPackage();
        assert nestedPackage != null;
        final @NonNull /*@Thrown*/ Environment addElements_0 = addElements.addElements(nestedPackage);
        return addElements_0;
    }
}
