/**
 *************************************************************************
 * This code is 100% auto-generated
 * from: oclstdlib
 * using: org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 */
package org.eclipse.ocl.examples.library.oclstdlib;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorInvalidType;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorVoidType;
import org.eclipse.ocl.examples.library.executor.ExecutorFragment;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorSpecializedType;
import org.eclipse.ocl.examples.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.executor.ExecutorTypeParameter;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

/**
 * OCLstdlibTables provides the dispatch tables for the oclstdlib for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class OCLstdlibTables
{
	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(OCLstdlibPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = new ExecutorStandardLibrary();

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		public static final @NonNull ExecutorTypeParameter _Bag_T = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "T");
		public static final @NonNull ExecutorTypeParameter __Bag__collect_V = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "V");
		public static final @NonNull ExecutorTypeParameter __Bag__collectNested_V = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "V");
		public static final @NonNull ExecutorTypeParameter __Bag__flatten_T2 = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "T2");
		public static final @NonNull ExecutorTypeParameter __Bag__selectByKind_TT = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "TT");
		public static final @NonNull ExecutorTypeParameter __Bag__selectByType_TT = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "TT");

		public static final @NonNull ExecutorTypeParameter _Collection_T = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "T");
		public static final @NonNull ExecutorTypeParameter __Collection__collect_V = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "V");
		public static final @NonNull ExecutorTypeParameter __Collection__collectNested_V = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "V");
		public static final @NonNull ExecutorTypeParameter __Collection__excludesAll_T2 = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "T2");
		public static final @NonNull ExecutorTypeParameter __Collection__flatten_T2 = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "T2");
		public static final @NonNull ExecutorTypeParameter __Collection__includesAll_T2 = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "T2");
		public static final @NonNull ExecutorTypeParameter __Collection__iterate_Tacc = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "Tacc");
		public static final @NonNull ExecutorTypeParameter __Collection__product_T2 = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "T2");
		public static final @NonNull ExecutorTypeParameter __Collection__selectByKind_TT = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "TT");
		public static final @NonNull ExecutorTypeParameter __Collection__selectByType_TT = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "TT");
		public static final @NonNull ExecutorTypeParameter __OclAny__oclAsType_TT = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "TT");
		public static final @NonNull ExecutorTypeParameter __OclAny__oclIsKindOf_T = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "T");
		public static final @NonNull ExecutorTypeParameter __OclAny__oclIsTypeOf_T = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "T");
		public static final @NonNull ExecutorTypeParameter __OclInvalid__oclAsType_TT = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "TT");
		public static final @NonNull ExecutorTypeParameter __OclInvalid__oclIsKindOf_T = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "T");
		public static final @NonNull ExecutorTypeParameter __OclInvalid__oclIsTypeOf_T = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "T");

		public static final @NonNull ExecutorTypeParameter _OrderedSet_T = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "T");
		public static final @NonNull ExecutorTypeParameter __OrderedSet__flatten_T2 = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "T2");
		public static final @NonNull ExecutorTypeParameter __OrderedSet__selectByKind_TT = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "TT");
		public static final @NonNull ExecutorTypeParameter __OrderedSet__selectByType_TT = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "TT");

		public static final @NonNull ExecutorTypeParameter _Sequence_T = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "T");
		public static final @NonNull ExecutorTypeParameter __Sequence__collect_V = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "V");
		public static final @NonNull ExecutorTypeParameter __Sequence__collectNested_V = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "V");
		public static final @NonNull ExecutorTypeParameter __Sequence__flatten_T2 = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "T2");
		public static final @NonNull ExecutorTypeParameter __Sequence__selectByKind_TT = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "TT");
		public static final @NonNull ExecutorTypeParameter __Sequence__selectByType_TT = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "TT");

		public static final @NonNull ExecutorTypeParameter _Set_T = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "T");
		public static final @NonNull ExecutorTypeParameter __Set__flatten_T2 = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "T2");
		public static final @NonNull ExecutorTypeParameter __Set__selectByKind_TT = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "TT");
		public static final @NonNull ExecutorTypeParameter __Set__selectByType_TT = new ExecutorTypeParameter(TypeId.T_2, LIBRARY, "TT");

		public static final @NonNull ExecutorTypeParameter _UniqueCollection_T = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "T");
		public static final @NonNull ExecutorTypeParameter __UnlimitedNatural__oclAsType_TT = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "TT");
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		public static final @NonNull EcoreExecutorType _Bag = new EcoreExecutorType(TypeId.BAG, PACKAGE, 0, TypeParameters._Bag_T);
		public static final @NonNull EcoreExecutorType _Boolean = new EcoreExecutorType(TypeId.BOOLEAN, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Collection = new EcoreExecutorType(TypeId.COLLECTION, PACKAGE, 0, TypeParameters._Collection_T);
		public static final @NonNull EcoreExecutorType _Integer = new EcoreExecutorType(TypeId.INTEGER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OclAny = new EcoreExecutorType(TypeId.OCL_ANY, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OclComparable = new EcoreExecutorType("OclComparable", PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OclElement = new EcoreExecutorType("OclElement", PACKAGE, 0);
		public static final @NonNull EcoreExecutorInvalidType _OclInvalid = new EcoreExecutorInvalidType(TypeId.OCL_INVALID, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OclLambda = new EcoreExecutorType("OclLambda", PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OclMessage = new EcoreExecutorType("OclMessage", PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OclSelf = new EcoreExecutorType(TypeId.OCL_SELF, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OclState = new EcoreExecutorType("OclState", PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OclSummable = new EcoreExecutorType("OclSummable", PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OclTuple = new EcoreExecutorType("OclTuple", PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OclType = new EcoreExecutorType("OclType", PACKAGE, 0);
		public static final @NonNull EcoreExecutorVoidType _OclVoid = new EcoreExecutorVoidType(TypeId.OCL_VOID, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OrderedSet = new EcoreExecutorType(TypeId.ORDERED_SET, PACKAGE, ExecutorType.ORDERED | ExecutorType.UNIQUE, TypeParameters._OrderedSet_T);
		public static final @NonNull EcoreExecutorType _Real = new EcoreExecutorType(TypeId.REAL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Sequence = new EcoreExecutorType(TypeId.SEQUENCE, PACKAGE, ExecutorType.ORDERED, TypeParameters._Sequence_T);
		public static final @NonNull EcoreExecutorType _Set = new EcoreExecutorType(TypeId.SET, PACKAGE, ExecutorType.UNIQUE, TypeParameters._Set_T);
		public static final @NonNull EcoreExecutorType _String = new EcoreExecutorType(TypeId.STRING, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _UniqueCollection = new EcoreExecutorType(TypeId.UNIQUE_COLLECTION, PACKAGE, 0, TypeParameters._UniqueCollection_T);
		public static final @NonNull EcoreExecutorType _UnlimitedNatural = new EcoreExecutorType(TypeId.UNLIMITED_NATURAL, PACKAGE, 0);

		private static final @NonNull EcoreExecutorType[] types = {
			_Bag,
			_Boolean,
			_Collection,
			_Integer,
			_OclAny,
			_OclComparable,
			_OclElement,
			_OclInvalid,
			_OclLambda,
			_OclMessage,
			_OclSelf,
			_OclState,
			_OclSummable,
			_OclTuple,
			_OclType,
			_OclVoid,
			_OrderedSet,
			_Real,
			_Sequence,
			_Set,
			_String,
			_UniqueCollection,
			_UnlimitedNatural
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			TypeFragments.init();
			FragmentOperations.init();
			FragmentProperties.init();
		}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		private static final @NonNull ExecutorFragment _Bag__Bag = new ExecutorFragment(Types._Bag, OCLstdlibTables.Types._Bag);
		private static final @NonNull ExecutorFragment _Bag__Collection = new ExecutorFragment(Types._Bag, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _Bag__OclAny = new ExecutorFragment(Types._Bag, OCLstdlibTables.Types._OclAny);

		private static final @NonNull ExecutorFragment _Boolean__Boolean = new ExecutorFragment(Types._Boolean, OCLstdlibTables.Types._Boolean);
		private static final @NonNull ExecutorFragment _Boolean__OclAny = new ExecutorFragment(Types._Boolean, OCLstdlibTables.Types._OclAny);

		private static final @NonNull ExecutorFragment _Collection__Collection = new ExecutorFragment(Types._Collection, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _Collection__OclAny = new ExecutorFragment(Types._Collection, OCLstdlibTables.Types._OclAny);

		private static final @NonNull ExecutorFragment _Integer__Integer = new ExecutorFragment(Types._Integer, OCLstdlibTables.Types._Integer);
		private static final @NonNull ExecutorFragment _Integer__OclAny = new ExecutorFragment(Types._Integer, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Integer__OclComparable = new ExecutorFragment(Types._Integer, OCLstdlibTables.Types._OclComparable);
		private static final @NonNull ExecutorFragment _Integer__OclSummable = new ExecutorFragment(Types._Integer, OCLstdlibTables.Types._OclSummable);
		private static final @NonNull ExecutorFragment _Integer__Real = new ExecutorFragment(Types._Integer, OCLstdlibTables.Types._Real);

		private static final @NonNull ExecutorFragment _OclAny__OclAny = new ExecutorFragment(Types._OclAny, OCLstdlibTables.Types._OclAny);

		private static final @NonNull ExecutorFragment _OclComparable__OclAny = new ExecutorFragment(Types._OclComparable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclComparable__OclComparable = new ExecutorFragment(Types._OclComparable, OCLstdlibTables.Types._OclComparable);

		private static final @NonNull ExecutorFragment _OclElement__OclAny = new ExecutorFragment(Types._OclElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclElement__OclElement = new ExecutorFragment(Types._OclElement, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _OclInvalid__OclAny = new ExecutorFragment(Types._OclInvalid, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclInvalid__OclInvalid = new ExecutorFragment(Types._OclInvalid, OCLstdlibTables.Types._OclInvalid);
		private static final @NonNull ExecutorFragment _OclInvalid__OclVoid = new ExecutorFragment(Types._OclInvalid, OCLstdlibTables.Types._OclVoid);

		private static final @NonNull ExecutorFragment _OclLambda__OclAny = new ExecutorFragment(Types._OclLambda, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclLambda__OclLambda = new ExecutorFragment(Types._OclLambda, OCLstdlibTables.Types._OclLambda);

		private static final @NonNull ExecutorFragment _OclMessage__OclAny = new ExecutorFragment(Types._OclMessage, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclMessage__OclMessage = new ExecutorFragment(Types._OclMessage, OCLstdlibTables.Types._OclMessage);

		private static final @NonNull ExecutorFragment _OclSelf__OclAny = new ExecutorFragment(Types._OclSelf, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclSelf__OclSelf = new ExecutorFragment(Types._OclSelf, OCLstdlibTables.Types._OclSelf);

		private static final @NonNull ExecutorFragment _OclState__OclAny = new ExecutorFragment(Types._OclState, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclState__OclState = new ExecutorFragment(Types._OclState, OCLstdlibTables.Types._OclState);

		private static final @NonNull ExecutorFragment _OclSummable__OclAny = new ExecutorFragment(Types._OclSummable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclSummable__OclSummable = new ExecutorFragment(Types._OclSummable, OCLstdlibTables.Types._OclSummable);

		private static final @NonNull ExecutorFragment _OclTuple__OclAny = new ExecutorFragment(Types._OclTuple, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclTuple__OclTuple = new ExecutorFragment(Types._OclTuple, OCLstdlibTables.Types._OclTuple);

		private static final @NonNull ExecutorFragment _OclType__OclAny = new ExecutorFragment(Types._OclType, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclType__OclElement = new ExecutorFragment(Types._OclType, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OclType__OclType = new ExecutorFragment(Types._OclType, OCLstdlibTables.Types._OclType);

		private static final @NonNull ExecutorFragment _OclVoid__OclAny = new ExecutorFragment(Types._OclVoid, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OclVoid__OclVoid = new ExecutorFragment(Types._OclVoid, OCLstdlibTables.Types._OclVoid);

		private static final @NonNull ExecutorFragment _OrderedSet__Collection = new ExecutorFragment(Types._OrderedSet, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _OrderedSet__OclAny = new ExecutorFragment(Types._OrderedSet, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OrderedSet__OrderedSet = new ExecutorFragment(Types._OrderedSet, OCLstdlibTables.Types._OrderedSet);
		private static final @NonNull ExecutorFragment _OrderedSet__Sequence = new ExecutorFragment(Types._OrderedSet, OCLstdlibTables.Types._Sequence);
		private static final @NonNull ExecutorFragment _OrderedSet__UniqueCollection = new ExecutorFragment(Types._OrderedSet, OCLstdlibTables.Types._UniqueCollection);

		private static final @NonNull ExecutorFragment _Real__OclAny = new ExecutorFragment(Types._Real, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Real__OclComparable = new ExecutorFragment(Types._Real, OCLstdlibTables.Types._OclComparable);
		private static final @NonNull ExecutorFragment _Real__OclSummable = new ExecutorFragment(Types._Real, OCLstdlibTables.Types._OclSummable);
		private static final @NonNull ExecutorFragment _Real__Real = new ExecutorFragment(Types._Real, OCLstdlibTables.Types._Real);

		private static final @NonNull ExecutorFragment _Sequence__Collection = new ExecutorFragment(Types._Sequence, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _Sequence__OclAny = new ExecutorFragment(Types._Sequence, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Sequence__Sequence = new ExecutorFragment(Types._Sequence, OCLstdlibTables.Types._Sequence);

		private static final @NonNull ExecutorFragment _Set__Bag = new ExecutorFragment(Types._Set, OCLstdlibTables.Types._Bag);
		private static final @NonNull ExecutorFragment _Set__Collection = new ExecutorFragment(Types._Set, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _Set__OclAny = new ExecutorFragment(Types._Set, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Set__Set = new ExecutorFragment(Types._Set, OCLstdlibTables.Types._Set);
		private static final @NonNull ExecutorFragment _Set__UniqueCollection = new ExecutorFragment(Types._Set, OCLstdlibTables.Types._UniqueCollection);

		private static final @NonNull ExecutorFragment _String__OclAny = new ExecutorFragment(Types._String, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _String__OclComparable = new ExecutorFragment(Types._String, OCLstdlibTables.Types._OclComparable);
		private static final @NonNull ExecutorFragment _String__OclSummable = new ExecutorFragment(Types._String, OCLstdlibTables.Types._OclSummable);
		private static final @NonNull ExecutorFragment _String__String = new ExecutorFragment(Types._String, OCLstdlibTables.Types._String);

		private static final @NonNull ExecutorFragment _UniqueCollection__Collection = new ExecutorFragment(Types._UniqueCollection, OCLstdlibTables.Types._Collection);
		private static final @NonNull ExecutorFragment _UniqueCollection__OclAny = new ExecutorFragment(Types._UniqueCollection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _UniqueCollection__UniqueCollection = new ExecutorFragment(Types._UniqueCollection, OCLstdlibTables.Types._UniqueCollection);

		private static final @NonNull ExecutorFragment _UnlimitedNatural__Integer = new ExecutorFragment(Types._UnlimitedNatural, OCLstdlibTables.Types._Integer);
		private static final @NonNull ExecutorFragment _UnlimitedNatural__OclAny = new ExecutorFragment(Types._UnlimitedNatural, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _UnlimitedNatural__OclComparable = new ExecutorFragment(Types._UnlimitedNatural, OCLstdlibTables.Types._OclComparable);
		private static final @NonNull ExecutorFragment _UnlimitedNatural__OclSummable = new ExecutorFragment(Types._UnlimitedNatural, OCLstdlibTables.Types._OclSummable);
		private static final @NonNull ExecutorFragment _UnlimitedNatural__Real = new ExecutorFragment(Types._UnlimitedNatural, OCLstdlibTables.Types._Real);
		private static final @NonNull ExecutorFragment _UnlimitedNatural__UnlimitedNatural = new ExecutorFragment(Types._UnlimitedNatural, OCLstdlibTables.Types._UnlimitedNatural);
	}

	/**
	 *	The parameter lists shared by operations.
	 */
	public static class Parameters {
		public static final @NonNull DomainParameterTypes _ = new DomainParameterTypes();
		public static final @NonNull DomainParameterTypes _Bag_T = new DomainParameterTypes(OCLstdlibTables.TypeParameters._Bag_T);
		public static final @NonNull DomainParameterTypes _Boolean = new DomainParameterTypes(OCLstdlibTables.Types._Boolean);
		public static final @NonNull DomainParameterTypes _Collection = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Collection", OCLstdlibTables.TypeParameters._Collection_T));
		public static final @NonNull DomainParameterTypes _Collection_T = new DomainParameterTypes(OCLstdlibTables.TypeParameters._Collection_T);
		public static final @NonNull DomainParameterTypes _Collection__Bag_T__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Collection", OCLstdlibTables.TypeParameters._Bag_T));
		public static final @NonNull DomainParameterTypes _Collection__Collection_excludesAll_T2__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Collection", OCLstdlibTables.TypeParameters.__Collection__excludesAll_T2));
		public static final @NonNull DomainParameterTypes _Collection__Collection_includesAll_T2__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Collection", OCLstdlibTables.TypeParameters.__Collection__includesAll_T2));
		public static final @NonNull DomainParameterTypes _Collection__Collection_product_T2__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Collection", OCLstdlibTables.TypeParameters.__Collection__product_T2));
		public static final @NonNull DomainParameterTypes _Collection__OclAny__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Collection", OCLstdlibTables.Types._OclAny));
		public static final @NonNull DomainParameterTypes _Collection__Set_T__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Collection", OCLstdlibTables.TypeParameters._Set_T));
		public static final @NonNull DomainParameterTypes _Collection__UniqueCollection_T__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Collection", OCLstdlibTables.TypeParameters._UniqueCollection_T));
		public static final @NonNull DomainParameterTypes _Integer = new DomainParameterTypes(OCLstdlibTables.Types._Integer);
		public static final @NonNull DomainParameterTypes _Integer___Integer = new DomainParameterTypes(OCLstdlibTables.Types._Integer, OCLstdlibTables.Types._Integer);
		public static final @NonNull DomainParameterTypes _Integer___OrderedSet_T = new DomainParameterTypes(OCLstdlibTables.Types._Integer, OCLstdlibTables.TypeParameters._OrderedSet_T);
		public static final @NonNull DomainParameterTypes _Integer___Sequence_T = new DomainParameterTypes(OCLstdlibTables.Types._Integer, OCLstdlibTables.TypeParameters._Sequence_T);
		public static final @NonNull DomainParameterTypes _Lambda_Bag_T_Bag_collectNested_V = new DomainParameterTypes(OCLstdlibTables.TypeParameters.__Bag__collectNested_V);
		public static final @NonNull DomainParameterTypes _Lambda_Bag_T_Bag_collect_V = new DomainParameterTypes(OCLstdlibTables.TypeParameters.__Bag__collect_V);
		public static final @NonNull DomainParameterTypes _Lambda_Bag_T_Boolean = new DomainParameterTypes(OCLstdlibTables.Types._Boolean);
		public static final @NonNull DomainParameterTypes _Lambda_Bag_T_OclAny = new DomainParameterTypes(OCLstdlibTables.Types._OclAny);
		public static final @NonNull DomainParameterTypes _Lambda_Bag_T_Set__Bag_T__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Set", OCLstdlibTables.TypeParameters._Bag_T));
		public static final @NonNull DomainParameterTypes _Lambda_Collection_T_Boolean = new DomainParameterTypes(OCLstdlibTables.Types._Boolean);
		public static final @NonNull DomainParameterTypes _Lambda_Collection_T_Collection_collectNested_V = new DomainParameterTypes(OCLstdlibTables.TypeParameters.__Collection__collectNested_V);
		public static final @NonNull DomainParameterTypes _Lambda_Collection_T_Collection_collect_V = new DomainParameterTypes(OCLstdlibTables.TypeParameters.__Collection__collect_V);
		public static final @NonNull DomainParameterTypes _Lambda_Collection_T_Collection_iterate_Tacc = new DomainParameterTypes(OCLstdlibTables.TypeParameters.__Collection__iterate_Tacc);
		public static final @NonNull DomainParameterTypes _Lambda_Collection_T_OclAny = new DomainParameterTypes(OCLstdlibTables.Types._OclAny);
		public static final @NonNull DomainParameterTypes _Lambda_OrderedSet_T_Boolean = new DomainParameterTypes(OCLstdlibTables.Types._Boolean);
		public static final @NonNull DomainParameterTypes _Lambda_OrderedSet_T_OclAny = new DomainParameterTypes(OCLstdlibTables.Types._OclAny);
		public static final @NonNull DomainParameterTypes _Lambda_Sequence_T_Boolean = new DomainParameterTypes(OCLstdlibTables.Types._Boolean);
		public static final @NonNull DomainParameterTypes _Lambda_Sequence_T_OclAny = new DomainParameterTypes(OCLstdlibTables.Types._OclAny);
		public static final @NonNull DomainParameterTypes _Lambda_Sequence_T_OrderedSet__Sequence_T__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "OrderedSet", OCLstdlibTables.TypeParameters._Sequence_T));
		public static final @NonNull DomainParameterTypes _Lambda_Sequence_T_Sequence_collectNested_V = new DomainParameterTypes(OCLstdlibTables.TypeParameters.__Sequence__collectNested_V);
		public static final @NonNull DomainParameterTypes _Lambda_Sequence_T_Sequence_collect_V = new DomainParameterTypes(OCLstdlibTables.TypeParameters.__Sequence__collect_V);
		public static final @NonNull DomainParameterTypes _Lambda_Set_T_Boolean = new DomainParameterTypes(OCLstdlibTables.Types._Boolean);
		public static final @NonNull DomainParameterTypes _Lambda_Set_T_OclAny = new DomainParameterTypes(OCLstdlibTables.Types._OclAny);
		public static final @NonNull DomainParameterTypes _Lambda_UniqueCollection_T_OclAny = new DomainParameterTypes(OCLstdlibTables.Types._OclAny);
		public static final @NonNull DomainParameterTypes _Metaclass__Bag_selectByKind_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__Bag__selectByKind_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__Bag_selectByType_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__Bag__selectByType_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__Collection_selectByKind_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__Collection__selectByKind_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__Collection_selectByType_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__Collection__selectByType_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__OclAny_oclAsType_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__OclAny__oclAsType_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__OclAny_oclIsKindOf_T__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__OclAny__oclIsKindOf_T));
		public static final @NonNull DomainParameterTypes _Metaclass__OclAny_oclIsTypeOf_T__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__OclAny__oclIsTypeOf_T));
		public static final @NonNull DomainParameterTypes _Metaclass__OclInvalid_oclAsType_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__OclInvalid__oclAsType_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__OclInvalid_oclIsKindOf_T__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__OclInvalid__oclIsKindOf_T));
		public static final @NonNull DomainParameterTypes _Metaclass__OclInvalid_oclIsTypeOf_T__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__OclInvalid__oclIsTypeOf_T));
		public static final @NonNull DomainParameterTypes _Metaclass__OrderedSet_selectByKind_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__OrderedSet__selectByKind_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__OrderedSet_selectByType_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__OrderedSet__selectByType_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__Sequence_selectByKind_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__Sequence__selectByKind_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__Sequence_selectByType_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__Sequence__selectByType_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__Set_selectByKind_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__Set__selectByKind_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__Set_selectByType_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__Set__selectByType_TT));
		public static final @NonNull DomainParameterTypes _Metaclass__UnlimitedNatural_oclAsType_TT__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Metaclass", OCLstdlibTables.TypeParameters.__UnlimitedNatural__oclAsType_TT));
		public static final @NonNull DomainParameterTypes _OclAny = new DomainParameterTypes(OCLstdlibTables.Types._OclAny);
		public static final @NonNull DomainParameterTypes _OclSelf = new DomainParameterTypes(OCLstdlibTables.Types._OclSelf);
		public static final @NonNull DomainParameterTypes _OclState = new DomainParameterTypes(OCLstdlibTables.Types._OclState);
		public static final @NonNull DomainParameterTypes _OclType = new DomainParameterTypes(OCLstdlibTables.Types._OclType);
		public static final @NonNull DomainParameterTypes _OrderedSet = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "OrderedSet", OCLstdlibTables.TypeParameters._OrderedSet_T));
		public static final @NonNull DomainParameterTypes _OrderedSet_T = new DomainParameterTypes(OCLstdlibTables.TypeParameters._OrderedSet_T);
		public static final @NonNull DomainParameterTypes _Sequence = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "Sequence", OCLstdlibTables.TypeParameters._Sequence_T));
		public static final @NonNull DomainParameterTypes _Sequence_T = new DomainParameterTypes(OCLstdlibTables.TypeParameters._Sequence_T);
		public static final @NonNull DomainParameterTypes _Set_T = new DomainParameterTypes(OCLstdlibTables.TypeParameters._Set_T);
		public static final @NonNull DomainParameterTypes _String = new DomainParameterTypes(OCLstdlibTables.Types._String);
		public static final @NonNull DomainParameterTypes _String___Boolean = new DomainParameterTypes(OCLstdlibTables.Types._String, OCLstdlibTables.Types._Boolean);
		public static final @NonNull DomainParameterTypes _String___String = new DomainParameterTypes(OCLstdlibTables.Types._String, OCLstdlibTables.Types._String);
		public static final @NonNull DomainParameterTypes _UniqueCollection = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "UniqueCollection", OCLstdlibTables.TypeParameters._UniqueCollection_T));
		public static final @NonNull DomainParameterTypes _UniqueCollection__Collection_T__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "UniqueCollection", OCLstdlibTables.TypeParameters._Collection_T));
		public static final @NonNull DomainParameterTypes _UniqueCollection__OclAny__ = new DomainParameterTypes(new ExecutorSpecializedType(LIBRARY, "UniqueCollection", OCLstdlibTables.Types._OclAny));
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 */
	public static class Operations {
		public static final @NonNull ExecutorOperation _Bag___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Bag,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Bag,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__closure = new ExecutorOperation("closure", Parameters._Lambda_Bag_T_Set__Bag_T__, Types._Bag,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__collect = new ExecutorOperation("collect", Parameters._Lambda_Bag_T_Bag_collect_V, Types._Bag,
			3, new DomainTypeParameters(TypeParameters.__Bag__collect_V), org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__collectNested = new ExecutorOperation("collectNested", Parameters._Lambda_Bag_T_Bag_collectNested_V, Types._Bag,
			4, new DomainTypeParameters(TypeParameters.__Bag__collectNested_V), org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__excluding = new ExecutorOperation("excluding", Parameters._OclAny, Types._Bag,
			5, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__excludingAll = new ExecutorOperation("excludingAll", Parameters._Collection__OclAny__, Types._Bag,
			6, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionExcludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__flatten = new ExecutorOperation("flatten", Parameters._, Types._Bag,
			7, new DomainTypeParameters(TypeParameters.__Bag__flatten_T2), org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__including = new ExecutorOperation("including", Parameters._Bag_T, Types._Bag,
			8, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__includingAll = new ExecutorOperation("includingAll", Parameters._Collection__Bag_T__, Types._Bag,
			9, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIncludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__reject = new ExecutorOperation("reject", Parameters._Lambda_Bag_T_Boolean, Types._Bag,
			10, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__select = new ExecutorOperation("select", Parameters._Lambda_Bag_T_Boolean, Types._Bag,
			11, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__selectByKind = new ExecutorOperation("selectByKind", Parameters._Metaclass__Bag_selectByKind_TT__, Types._Bag,
			12, new DomainTypeParameters(TypeParameters.__Bag__selectByKind_TT), org.eclipse.ocl.examples.library.collection.CollectionSelectByKindOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__selectByType = new ExecutorOperation("selectByType", Parameters._Metaclass__Bag_selectByType_TT__, Types._Bag,
			13, new DomainTypeParameters(TypeParameters.__Bag__selectByType_TT), org.eclipse.ocl.examples.library.collection.CollectionSelectByTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Bag__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_Bag_T_OclAny, Types._Bag,
			14, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);

		public static final @NonNull ExecutorOperation _Boolean___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Boolean,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Boolean,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__and = new ExecutorOperation("and", Parameters._Boolean, Types._Boolean,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__implies = new ExecutorOperation("implies", Parameters._Boolean, Types._Boolean,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__not = new ExecutorOperation("not", Parameters._, Types._Boolean,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.logical.BooleanNotOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__or = new ExecutorOperation("or", Parameters._Boolean, Types._Boolean,
			5, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.logical.BooleanOrOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__xor = new ExecutorOperation("xor", Parameters._Boolean, Types._Boolean,
			6, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.logical.BooleanXorOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__allInstances = new ExecutorOperation("allInstances", Parameters._, Types._Boolean,
			7, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.logical.BooleanAllInstancesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Boolean__toString = new ExecutorOperation("toString", Parameters._, Types._Boolean,
			8, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _Collection___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Collection,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Collection,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__any = new ExecutorOperation("any", Parameters._Lambda_Collection_T_Boolean, Types._Collection,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.AnyIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__asBag = new ExecutorOperation("asBag", Parameters._, Types._Collection,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionAsBagOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__asOrderedSet = new ExecutorOperation("asOrderedSet", Parameters._, Types._Collection,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionAsOrderedSetOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__asSequence = new ExecutorOperation("asSequence", Parameters._, Types._Collection,
			5, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionAsSequenceOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__asSet = new ExecutorOperation("asSet", Parameters._, Types._Collection,
			6, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__collect = new ExecutorOperation("collect", Parameters._Lambda_Collection_T_Collection_collect_V, Types._Collection,
			7, new DomainTypeParameters(TypeParameters.__Collection__collect_V), org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__collectNested = new ExecutorOperation("collectNested", Parameters._Lambda_Collection_T_Collection_collectNested_V, Types._Collection,
			8, new DomainTypeParameters(TypeParameters.__Collection__collectNested_V), org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__count = new ExecutorOperation("count", Parameters._OclAny, Types._Collection,
			9, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionCountOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__excludes = new ExecutorOperation("excludes", Parameters._OclAny, Types._Collection,
			10, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionExcludesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__excludesAll = new ExecutorOperation("excludesAll", Parameters._Collection__Collection_excludesAll_T2__, Types._Collection,
			11, new DomainTypeParameters(TypeParameters.__Collection__excludesAll_T2), org.eclipse.ocl.examples.library.collection.CollectionExcludesAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__excluding = new ExecutorOperation("excluding", Parameters._OclAny, Types._Collection,
			12, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__excludingAll = new ExecutorOperation("excludingAll", Parameters._Collection__OclAny__, Types._Collection,
			13, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionExcludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__1_exists = new ExecutorOperation("exists", Parameters._Lambda_Collection_T_Boolean, Types._Collection,
			14, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__0_exists = new ExecutorOperation("exists", Parameters._Lambda_Collection_T_Boolean, Types._Collection,
			15, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.ExistsIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__flatten = new ExecutorOperation("flatten", Parameters._, Types._Collection,
			16, new DomainTypeParameters(TypeParameters.__Collection__flatten_T2), org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__1_forAll = new ExecutorOperation("forAll", Parameters._Lambda_Collection_T_Boolean, Types._Collection,
			17, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__0_forAll = new ExecutorOperation("forAll", Parameters._Lambda_Collection_T_Boolean, Types._Collection,
			18, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.ForAllIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__includes = new ExecutorOperation("includes", Parameters._OclAny, Types._Collection,
			19, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__includesAll = new ExecutorOperation("includesAll", Parameters._Collection__Collection_includesAll_T2__, Types._Collection,
			20, new DomainTypeParameters(TypeParameters.__Collection__includesAll_T2), org.eclipse.ocl.examples.library.collection.CollectionIncludesAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__including = new ExecutorOperation("including", Parameters._Collection_T, Types._Collection,
			21, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__includingAll = new ExecutorOperation("includingAll", Parameters._Collection, Types._Collection,
			22, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIncludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__0_intersection = new ExecutorOperation("intersection", Parameters._Collection, Types._Collection,
			23, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIntersectionOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__1_intersection = new ExecutorOperation("intersection", Parameters._UniqueCollection__Collection_T__, Types._Collection,
			24, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIntersectionOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__isEmpty = new ExecutorOperation("isEmpty", Parameters._, Types._Collection,
			25, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__isUnique = new ExecutorOperation("isUnique", Parameters._Lambda_Collection_T_OclAny, Types._Collection,
			26, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.IsUniqueIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__iterate = new ExecutorOperation("iterate", Parameters._Lambda_Collection_T_Collection_iterate_Tacc, Types._Collection,
			27, new DomainTypeParameters(TypeParameters.__Collection__iterate_Tacc), org.eclipse.ocl.examples.library.iterator.IterateIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__max = new ExecutorOperation("max", Parameters._, Types._Collection,
			28, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionMaxOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__min = new ExecutorOperation("min", Parameters._, Types._Collection,
			29, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionMinOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__notEmpty = new ExecutorOperation("notEmpty", Parameters._, Types._Collection,
			30, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__one = new ExecutorOperation("one", Parameters._Lambda_Collection_T_Boolean, Types._Collection,
			31, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.OneIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__product = new ExecutorOperation("product", Parameters._Collection__Collection_product_T2__, Types._Collection,
			32, new DomainTypeParameters(TypeParameters.__Collection__product_T2), org.eclipse.ocl.examples.library.collection.CollectionProductOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__reject = new ExecutorOperation("reject", Parameters._Lambda_Collection_T_Boolean, Types._Collection,
			33, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__select = new ExecutorOperation("select", Parameters._Lambda_Collection_T_Boolean, Types._Collection,
			34, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__selectByKind = new ExecutorOperation("selectByKind", Parameters._Metaclass__Collection_selectByKind_TT__, Types._Collection,
			35, new DomainTypeParameters(TypeParameters.__Collection__selectByKind_TT), org.eclipse.ocl.examples.library.collection.CollectionSelectByKindOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__selectByType = new ExecutorOperation("selectByType", Parameters._Metaclass__Collection_selectByType_TT__, Types._Collection,
			36, new DomainTypeParameters(TypeParameters.__Collection__selectByType_TT), org.eclipse.ocl.examples.library.collection.CollectionSelectByTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__size = new ExecutorOperation("size", Parameters._, Types._Collection,
			37, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionSizeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_Collection_T_OclAny, Types._Collection,
			38, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__sum = new ExecutorOperation("sum", Parameters._, Types._Collection,
			39, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionSumOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Collection__union = new ExecutorOperation("union", Parameters._Collection, Types._Collection,
			40, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _Integer___mul_ = new ExecutorOperation("*", Parameters._OclSelf, Types._Integer,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer___add_ = new ExecutorOperation("+", Parameters._OclSelf, Types._Integer,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer___neg_ = new ExecutorOperation("-", Parameters._, Types._Integer,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer___sub_ = new ExecutorOperation("-", Parameters._OclSelf, Types._Integer,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer___div_ = new ExecutorOperation("/", Parameters._OclSelf, Types._Integer,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__abs = new ExecutorOperation("abs", Parameters._, Types._Integer,
			5, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__compareTo = new ExecutorOperation("compareTo", Parameters._OclSelf, Types._Integer,
			6, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericCompareToOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__div = new ExecutorOperation("div", Parameters._Integer, Types._Integer,
			7, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericDivOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__max = new ExecutorOperation("max", Parameters._OclSelf, Types._Integer,
			8, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__min = new ExecutorOperation("min", Parameters._OclSelf, Types._Integer,
			9, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__mod = new ExecutorOperation("mod", Parameters._Integer, Types._Integer,
			10, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericModOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Integer__toString = new ExecutorOperation("toString", Parameters._, Types._Integer,
			11, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclAny___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._OclAny,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._OclAny,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclAsSet = new ExecutorOperation("oclAsSet", Parameters._, Types._OclAny,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclAsType = new ExecutorOperation("oclAsType", Parameters._Metaclass__OclAny_oclAsType_TT__, Types._OclAny,
			3, new DomainTypeParameters(TypeParameters.__OclAny__oclAsType_TT), org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsInState = new ExecutorOperation("oclIsInState", Parameters._OclState, Types._OclAny,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInStateOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsInvalid = new ExecutorOperation("oclIsInvalid", Parameters._, Types._OclAny,
			5, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsKindOf = new ExecutorOperation("oclIsKindOf", Parameters._Metaclass__OclAny_oclIsKindOf_T__, Types._OclAny,
			6, new DomainTypeParameters(TypeParameters.__OclAny__oclIsKindOf_T), org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsNew = new ExecutorOperation("oclIsNew", Parameters._, Types._OclAny,
			7, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsTypeOf = new ExecutorOperation("oclIsTypeOf", Parameters._Metaclass__OclAny_oclIsTypeOf_T__, Types._OclAny,
			8, new DomainTypeParameters(TypeParameters.__OclAny__oclIsTypeOf_T), org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclIsUndefined = new ExecutorOperation("oclIsUndefined", Parameters._, Types._OclAny,
			9, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__0_oclLog = new ExecutorOperation("oclLog", Parameters._, Types._OclAny,
			10, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclLogOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__1_oclLog = new ExecutorOperation("oclLog", Parameters._String, Types._OclAny,
			11, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclLogOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__oclType = new ExecutorOperation("oclType", Parameters._, Types._OclAny,
			12, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclAny__toString = new ExecutorOperation("toString", Parameters._, Types._OclAny,
			13, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclComparable___lt_ = new ExecutorOperation("<", Parameters._OclSelf, Types._OclComparable,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclComparableLessThanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclComparable___lt__eq_ = new ExecutorOperation("<=", Parameters._OclSelf, Types._OclComparable,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclComparableLessThanEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclComparable___gt_ = new ExecutorOperation(">", Parameters._OclSelf, Types._OclComparable,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclComparableGreaterThanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclComparable___gt__eq_ = new ExecutorOperation(">=", Parameters._OclSelf, Types._OclComparable,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclComparableGreaterThanEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclComparable__compareTo = new ExecutorOperation("compareTo", Parameters._OclSelf, Types._OclComparable,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclComparableCompareToOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclElement__allInstances = new ExecutorOperation("allInstances", Parameters._, Types._OclElement,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__oclContainer = new ExecutorOperation("oclContainer", Parameters._, Types._OclElement,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclElement__oclContents = new ExecutorOperation("oclContents", Parameters._, Types._OclElement,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclInvalid___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._OclInvalid,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._OclInvalid,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__and = new ExecutorOperation("and", Parameters._Boolean, Types._OclInvalid,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__implies = new ExecutorOperation("implies", Parameters._Boolean, Types._OclInvalid,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__or = new ExecutorOperation("or", Parameters._Boolean, Types._OclInvalid,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.logical.BooleanAndOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__allInstances = new ExecutorOperation("allInstances", Parameters._, Types._OclInvalid,
			5, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclinvalid.OclInvalidAllInstancesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclAsSet = new ExecutorOperation("oclAsSet", Parameters._, Types._OclInvalid,
			6, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclAsType = new ExecutorOperation("oclAsType", Parameters._Metaclass__OclInvalid_oclAsType_TT__, Types._OclInvalid,
			7, new DomainTypeParameters(TypeParameters.__OclInvalid__oclAsType_TT), org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclIsInvalid = new ExecutorOperation("oclIsInvalid", Parameters._, Types._OclInvalid,
			8, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclIsKindOf = new ExecutorOperation("oclIsKindOf", Parameters._Metaclass__OclInvalid_oclIsKindOf_T__, Types._OclInvalid,
			9, new DomainTypeParameters(TypeParameters.__OclInvalid__oclIsKindOf_T), org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclIsTypeOf = new ExecutorOperation("oclIsTypeOf", Parameters._Metaclass__OclInvalid_oclIsTypeOf_T__, Types._OclInvalid,
			10, new DomainTypeParameters(TypeParameters.__OclInvalid__oclIsTypeOf_T), org.eclipse.ocl.examples.library.oclany.OclAnyOclIsTypeOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclIsUndefined = new ExecutorOperation("oclIsUndefined", Parameters._, Types._OclInvalid,
			11, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__oclType = new ExecutorOperation("oclType", Parameters._, Types._OclInvalid,
			12, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclInvalid__toString = new ExecutorOperation("toString", Parameters._, Types._OclInvalid,
			13, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclMessage__hasReturned = new ExecutorOperation("hasReturned", Parameters._, Types._OclMessage,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclMessage__isOperationCall = new ExecutorOperation("isOperationCall", Parameters._, Types._OclMessage,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclMessage__isSignalSent = new ExecutorOperation("isSignalSent", Parameters._, Types._OclMessage,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclMessage__result = new ExecutorOperation("result", Parameters._, Types._OclMessage,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclSummable__sum = new ExecutorOperation("sum", Parameters._OclSelf, Types._OclSummable,
			0, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _OclSummable__zero = new ExecutorOperation("zero", Parameters._, Types._OclSummable,
			1, DomainTypeParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _OclTuple___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._OclTuple,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclTuple___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._OclTuple,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclType__conformsTo = new ExecutorOperation("conformsTo", Parameters._OclType, Types._OclType,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.classifier.OclTypeConformsToOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OclVoid___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._OclVoid,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._OclVoid,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__and = new ExecutorOperation("and", Parameters._Boolean, Types._OclVoid,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclvoid.OclVoidAndOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__implies = new ExecutorOperation("implies", Parameters._Boolean, Types._OclVoid,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclvoid.OclVoidImpliesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__or = new ExecutorOperation("or", Parameters._Boolean, Types._OclVoid,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclvoid.OclVoidOrOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__allInstances = new ExecutorOperation("allInstances", Parameters._, Types._OclVoid,
			5, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclvoid.OclVoidAllInstancesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__oclIsInvalid = new ExecutorOperation("oclIsInvalid", Parameters._, Types._OclVoid,
			6, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclIsInvalidOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__oclIsUndefined = new ExecutorOperation("oclIsUndefined", Parameters._, Types._OclVoid,
			7, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OclVoid__toString = new ExecutorOperation("toString", Parameters._, Types._OclVoid,
			8, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _OrderedSet___sub_ = new ExecutorOperation("-", Parameters._UniqueCollection__OclAny__, Types._OrderedSet,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._OrderedSet,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._OrderedSet,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__append = new ExecutorOperation("append", Parameters._OrderedSet_T, Types._OrderedSet,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__appendAll = new ExecutorOperation("appendAll", Parameters._OrderedSet, Types._OrderedSet,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__excluding = new ExecutorOperation("excluding", Parameters._OclAny, Types._OrderedSet,
			5, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__excludingAll = new ExecutorOperation("excludingAll", Parameters._Collection__OclAny__, Types._OrderedSet,
			6, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionExcludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__flatten = new ExecutorOperation("flatten", Parameters._, Types._OrderedSet,
			7, new DomainTypeParameters(TypeParameters.__OrderedSet__flatten_T2), org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__including = new ExecutorOperation("including", Parameters._OrderedSet_T, Types._OrderedSet,
			8, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__insertAt = new ExecutorOperation("insertAt", Parameters._Integer___OrderedSet_T, Types._OrderedSet,
			9, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__prepend = new ExecutorOperation("prepend", Parameters._OrderedSet_T, Types._OrderedSet,
			10, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__prependAll = new ExecutorOperation("prependAll", Parameters._OrderedSet, Types._OrderedSet,
			11, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__reject = new ExecutorOperation("reject", Parameters._Lambda_OrderedSet_T_Boolean, Types._OrderedSet,
			12, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__reverse = new ExecutorOperation("reverse", Parameters._, Types._OrderedSet,
			13, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__select = new ExecutorOperation("select", Parameters._Lambda_OrderedSet_T_Boolean, Types._OrderedSet,
			14, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__selectByKind = new ExecutorOperation("selectByKind", Parameters._Metaclass__OrderedSet_selectByKind_TT__, Types._OrderedSet,
			15, new DomainTypeParameters(TypeParameters.__OrderedSet__selectByKind_TT), org.eclipse.ocl.examples.library.collection.CollectionSelectByKindOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__selectByType = new ExecutorOperation("selectByType", Parameters._Metaclass__OrderedSet_selectByType_TT__, Types._OrderedSet,
			16, new DomainTypeParameters(TypeParameters.__OrderedSet__selectByType_TT), org.eclipse.ocl.examples.library.collection.CollectionSelectByTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_OrderedSet_T_OclAny, Types._OrderedSet,
			17, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _OrderedSet__subOrderedSet = new ExecutorOperation("subOrderedSet", Parameters._Integer___Integer, Types._OrderedSet,
			18, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedSetSubOrderedSetOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _Real___mul_ = new ExecutorOperation("*", Parameters._OclSelf, Types._Real,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericTimesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___add_ = new ExecutorOperation("+", Parameters._OclSelf, Types._Real,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericPlusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___neg_ = new ExecutorOperation("-", Parameters._, Types._Real,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericNegateOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___sub_ = new ExecutorOperation("-", Parameters._OclSelf, Types._Real,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericMinusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___div_ = new ExecutorOperation("/", Parameters._OclSelf, Types._Real,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericDivideOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___lt_ = new ExecutorOperation("<", Parameters._OclSelf, Types._Real,
			5, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___lt__eq_ = new ExecutorOperation("<=", Parameters._OclSelf, Types._Real,
			6, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericLessThanEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Real,
			7, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Real,
			8, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___gt_ = new ExecutorOperation(">", Parameters._OclSelf, Types._Real,
			9, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real___gt__eq_ = new ExecutorOperation(">=", Parameters._OclSelf, Types._Real,
			10, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericGreaterThanEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__abs = new ExecutorOperation("abs", Parameters._, Types._Real,
			11, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericAbsOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__compareTo = new ExecutorOperation("compareTo", Parameters._OclSelf, Types._Real,
			12, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericCompareToOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__floor = new ExecutorOperation("floor", Parameters._, Types._Real,
			13, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericFloorOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__max = new ExecutorOperation("max", Parameters._OclSelf, Types._Real,
			14, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericMaxOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__min = new ExecutorOperation("min", Parameters._OclSelf, Types._Real,
			15, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericMinOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__round = new ExecutorOperation("round", Parameters._, Types._Real,
			16, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.numeric.NumericRoundOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Real__toString = new ExecutorOperation("toString", Parameters._, Types._Real,
			17, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _Sequence___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Sequence,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Sequence,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__append = new ExecutorOperation("append", Parameters._Sequence_T, Types._Sequence,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__appendAll = new ExecutorOperation("appendAll", Parameters._Sequence, Types._Sequence,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionAppendAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__at = new ExecutorOperation("at", Parameters._Integer, Types._Sequence,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionAtOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__closure = new ExecutorOperation("closure", Parameters._Lambda_Sequence_T_OrderedSet__Sequence_T__, Types._Sequence,
			5, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.ClosureIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__collect = new ExecutorOperation("collect", Parameters._Lambda_Sequence_T_Sequence_collect_V, Types._Sequence,
			6, new DomainTypeParameters(TypeParameters.__Sequence__collect_V), org.eclipse.ocl.examples.library.iterator.CollectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__collectNested = new ExecutorOperation("collectNested", Parameters._Lambda_Sequence_T_Sequence_collectNested_V, Types._Sequence,
			7, new DomainTypeParameters(TypeParameters.__Sequence__collectNested_V), org.eclipse.ocl.examples.library.iterator.CollectNestedIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__excluding = new ExecutorOperation("excluding", Parameters._OclAny, Types._Sequence,
			8, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__excludingAll = new ExecutorOperation("excludingAll", Parameters._Collection__OclAny__, Types._Sequence,
			9, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionExcludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__first = new ExecutorOperation("first", Parameters._, Types._Sequence,
			10, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__flatten = new ExecutorOperation("flatten", Parameters._, Types._Sequence,
			11, new DomainTypeParameters(TypeParameters.__Sequence__flatten_T2), org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__including = new ExecutorOperation("including", Parameters._Sequence_T, Types._Sequence,
			12, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__indexOf = new ExecutorOperation("indexOf", Parameters._OclAny, Types._Sequence,
			13, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__insertAt = new ExecutorOperation("insertAt", Parameters._Integer___Sequence_T, Types._Sequence,
			14, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionInsertAtOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__last = new ExecutorOperation("last", Parameters._, Types._Sequence,
			15, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionLastOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__prepend = new ExecutorOperation("prepend", Parameters._Sequence_T, Types._Sequence,
			16, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__prependAll = new ExecutorOperation("prependAll", Parameters._Sequence, Types._Sequence,
			17, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__reject = new ExecutorOperation("reject", Parameters._Lambda_Sequence_T_Boolean, Types._Sequence,
			18, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__reverse = new ExecutorOperation("reverse", Parameters._, Types._Sequence,
			19, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.OrderedCollectionReverseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__select = new ExecutorOperation("select", Parameters._Lambda_Sequence_T_Boolean, Types._Sequence,
			20, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__selectByKind = new ExecutorOperation("selectByKind", Parameters._Metaclass__Sequence_selectByKind_TT__, Types._Sequence,
			21, new DomainTypeParameters(TypeParameters.__Sequence__selectByKind_TT), org.eclipse.ocl.examples.library.collection.CollectionSelectByKindOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__selectByType = new ExecutorOperation("selectByType", Parameters._Metaclass__Sequence_selectByType_TT__, Types._Sequence,
			22, new DomainTypeParameters(TypeParameters.__Sequence__selectByType_TT), org.eclipse.ocl.examples.library.collection.CollectionSelectByTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_Sequence_T_OclAny, Types._Sequence,
			23, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Sequence__subSequence = new ExecutorOperation("subSequence", Parameters._Integer___Integer, Types._Sequence,
			24, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.SequenceSubSequenceOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _Set___sub_ = new ExecutorOperation("-", Parameters._UniqueCollection__OclAny__, Types._Set,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._Set,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._Set,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__excluding = new ExecutorOperation("excluding", Parameters._OclAny, Types._Set,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__excludingAll = new ExecutorOperation("excludingAll", Parameters._Collection__OclAny__, Types._Set,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionExcludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__flatten = new ExecutorOperation("flatten", Parameters._, Types._Set,
			5, new DomainTypeParameters(TypeParameters.__Set__flatten_T2), org.eclipse.ocl.examples.library.collection.CollectionFlattenOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__including = new ExecutorOperation("including", Parameters._Set_T, Types._Set,
			6, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIncludingOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__includingAll = new ExecutorOperation("includingAll", Parameters._Collection__Set_T__, Types._Set,
			7, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIncludingAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__reject = new ExecutorOperation("reject", Parameters._Lambda_Set_T_Boolean, Types._Set,
			8, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.RejectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__select = new ExecutorOperation("select", Parameters._Lambda_Set_T_Boolean, Types._Set,
			9, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.SelectIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__selectByKind = new ExecutorOperation("selectByKind", Parameters._Metaclass__Set_selectByKind_TT__, Types._Set,
			10, new DomainTypeParameters(TypeParameters.__Set__selectByKind_TT), org.eclipse.ocl.examples.library.collection.CollectionSelectByKindOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__selectByType = new ExecutorOperation("selectByType", Parameters._Metaclass__Set_selectByType_TT__, Types._Set,
			11, new DomainTypeParameters(TypeParameters.__Set__selectByType_TT), org.eclipse.ocl.examples.library.collection.CollectionSelectByTypeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _Set__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_Set_T_OclAny, Types._Set,
			12, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);

		public static final @NonNull ExecutorOperation _String___add_ = new ExecutorOperation("+", Parameters._String, Types._String,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___lt_ = new ExecutorOperation("<", Parameters._OclSelf, Types._String,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringLessThanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___lt__eq_ = new ExecutorOperation("<=", Parameters._OclSelf, Types._String,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringLessThanEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___lt__gt_ = new ExecutorOperation("<>", Parameters._OclSelf, Types._String,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___eq_ = new ExecutorOperation("=", Parameters._OclSelf, Types._String,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___gt_ = new ExecutorOperation(">", Parameters._OclSelf, Types._String,
			5, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringGreaterThanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String___gt__eq_ = new ExecutorOperation(">=", Parameters._OclSelf, Types._String,
			6, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringGreaterThanEqualOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__at = new ExecutorOperation("at", Parameters._Integer, Types._String,
			7, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringAtOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__characters = new ExecutorOperation("characters", Parameters._, Types._String,
			8, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringCharactersOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__compareTo = new ExecutorOperation("compareTo", Parameters._OclSelf, Types._String,
			9, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringCompareToOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__concat = new ExecutorOperation("concat", Parameters._String, Types._String,
			10, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringConcatOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__endsWith = new ExecutorOperation("endsWith", Parameters._String, Types._String,
			11, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringEndsWithOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__equalsIgnoreCase = new ExecutorOperation("equalsIgnoreCase", Parameters._String, Types._String,
			12, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringEqualsIgnoreCaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__indexOf = new ExecutorOperation("indexOf", Parameters._String, Types._String,
			13, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringIndexOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__lastIndexOf = new ExecutorOperation("lastIndexOf", Parameters._String, Types._String,
			14, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringLastIndexOfOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__matches = new ExecutorOperation("matches", Parameters._String, Types._String,
			15, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringMatchesOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__replaceAll = new ExecutorOperation("replaceAll", Parameters._String___String, Types._String,
			16, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringReplaceAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__replaceFirst = new ExecutorOperation("replaceFirst", Parameters._String___String, Types._String,
			17, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringReplaceFirstOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__size = new ExecutorOperation("size", Parameters._, Types._String,
			18, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringSizeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__startsWith = new ExecutorOperation("startsWith", Parameters._String, Types._String,
			19, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringStartsWithOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__substituteAll = new ExecutorOperation("substituteAll", Parameters._String___String, Types._String,
			20, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringSubstituteAllOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__substituteFirst = new ExecutorOperation("substituteFirst", Parameters._String___String, Types._String,
			21, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringSubstituteFirstOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__substring = new ExecutorOperation("substring", Parameters._Integer___Integer, Types._String,
			22, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringSubstringOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toBoolean = new ExecutorOperation("toBoolean", Parameters._, Types._String,
			23, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringToBooleanOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toInteger = new ExecutorOperation("toInteger", Parameters._, Types._String,
			24, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringToIntegerOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toLower = new ExecutorOperation("toLower", Parameters._, Types._String,
			25, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toLowerCase = new ExecutorOperation("toLowerCase", Parameters._, Types._String,
			26, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringToLowerCaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toReal = new ExecutorOperation("toReal", Parameters._, Types._String,
			27, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringToRealOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toString = new ExecutorOperation("toString", Parameters._, Types._String,
			28, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.oclany.OclAnyToStringOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toUpper = new ExecutorOperation("toUpper", Parameters._, Types._String,
			29, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__toUpperCase = new ExecutorOperation("toUpperCase", Parameters._, Types._String,
			30, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringToUpperCaseOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__0_tokenize = new ExecutorOperation("tokenize", Parameters._, Types._String,
			31, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringTokenizeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__1_tokenize = new ExecutorOperation("tokenize", Parameters._String, Types._String,
			32, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringTokenizeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__2_tokenize = new ExecutorOperation("tokenize", Parameters._String___Boolean, Types._String,
			33, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringTokenizeOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _String__trim = new ExecutorOperation("trim", Parameters._, Types._String,
			34, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.string.StringTrimOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _UniqueCollection___sub_ = new ExecutorOperation("-", Parameters._UniqueCollection__OclAny__, Types._UniqueCollection,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.SetMinusOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _UniqueCollection__intersection = new ExecutorOperation("intersection", Parameters._Collection__UniqueCollection_T__, Types._UniqueCollection,
			1, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionIntersectionOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _UniqueCollection__sortedBy = new ExecutorOperation("sortedBy", Parameters._Lambda_UniqueCollection_T_OclAny, Types._UniqueCollection,
			2, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.iterator.SortedByIteration.INSTANCE);
		public static final @NonNull ExecutorOperation _UniqueCollection__symmetricDifference = new ExecutorOperation("symmetricDifference", Parameters._UniqueCollection__OclAny__, Types._UniqueCollection,
			3, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.SetSymmetricDifferenceOperation.INSTANCE);
		public static final @NonNull ExecutorOperation _UniqueCollection__union = new ExecutorOperation("union", Parameters._UniqueCollection, Types._UniqueCollection,
			4, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.collection.CollectionUnionOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _UnlimitedNatural__oclAsType = new ExecutorOperation("oclAsType", Parameters._Metaclass__UnlimitedNatural_oclAsType_TT__, Types._UnlimitedNatural,
			0, new DomainTypeParameters(TypeParameters.__UnlimitedNatural__oclAsType_TT), org.eclipse.ocl.examples.library.numeric.UnlimitedNaturalOclAsTypeOperation.INSTANCE);

	}

	/**
	 *	The property descriptors for each property of each type.
	 */
	public static class Properties {
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		private static final @NonNull ExecutorFragment[] _Bag =
		{
			Fragments._Bag__OclAny /* 0 */,
			Fragments._Bag__Collection /* 1 */,
			Fragments._Bag__Bag /* 2 */
		};
		private static final @NonNull int[] __Bag = { 1,1,1 };

		private static final @NonNull ExecutorFragment[] _Boolean =
		{
			Fragments._Boolean__OclAny /* 0 */,
			Fragments._Boolean__Boolean /* 1 */
		};
		private static final @NonNull int[] __Boolean = { 1,1 };

		private static final @NonNull ExecutorFragment[] _Collection =
		{
			Fragments._Collection__OclAny /* 0 */,
			Fragments._Collection__Collection /* 1 */
		};
		private static final @NonNull int[] __Collection = { 1,1 };

		private static final @NonNull ExecutorFragment[] _Integer =
		{
			Fragments._Integer__OclAny /* 0 */,
			Fragments._Integer__OclComparable /* 1 */,
			Fragments._Integer__OclSummable /* 1 */,
			Fragments._Integer__Real /* 2 */,
			Fragments._Integer__Integer /* 3 */
		};
		private static final @NonNull int[] __Integer = { 1,2,1,1 };

		private static final @NonNull ExecutorFragment[] _OclAny =
		{
			Fragments._OclAny__OclAny /* 0 */
		};
		private static final @NonNull int[] __OclAny = { 1 };

		private static final @NonNull ExecutorFragment[] _OclComparable =
		{
			Fragments._OclComparable__OclAny /* 0 */,
			Fragments._OclComparable__OclComparable /* 1 */
		};
		private static final @NonNull int[] __OclComparable = { 1,1 };

		private static final @NonNull ExecutorFragment[] _OclElement =
		{
			Fragments._OclElement__OclAny /* 0 */,
			Fragments._OclElement__OclElement /* 1 */
		};
		private static final @NonNull int[] __OclElement = { 1,1 };

		private static final @NonNull ExecutorFragment[] _OclInvalid =
		{
			Fragments._OclInvalid__OclAny /* 0 */,
			Fragments._OclInvalid__OclVoid /* 1 */,
			Fragments._OclInvalid__OclInvalid /* 2 */
		};
		private static final @NonNull int[] __OclInvalid = { 1,1,1 };

		private static final @NonNull ExecutorFragment[] _OclLambda =
		{
			Fragments._OclLambda__OclAny /* 0 */,
			Fragments._OclLambda__OclLambda /* 1 */
		};
		private static final @NonNull int[] __OclLambda = { 1,1 };

		private static final @NonNull ExecutorFragment[] _OclMessage =
		{
			Fragments._OclMessage__OclAny /* 0 */,
			Fragments._OclMessage__OclMessage /* 1 */
		};
		private static final @NonNull int[] __OclMessage = { 1,1 };

		private static final @NonNull ExecutorFragment[] _OclSelf =
		{
			Fragments._OclSelf__OclAny /* 0 */,
			Fragments._OclSelf__OclSelf /* 1 */
		};
		private static final @NonNull int[] __OclSelf = { 1,1 };

		private static final @NonNull ExecutorFragment[] _OclState =
		{
			Fragments._OclState__OclAny /* 0 */,
			Fragments._OclState__OclState /* 1 */
		};
		private static final @NonNull int[] __OclState = { 1,1 };

		private static final @NonNull ExecutorFragment[] _OclSummable =
		{
			Fragments._OclSummable__OclAny /* 0 */,
			Fragments._OclSummable__OclSummable /* 1 */
		};
		private static final @NonNull int[] __OclSummable = { 1,1 };

		private static final @NonNull ExecutorFragment[] _OclTuple =
		{
			Fragments._OclTuple__OclAny /* 0 */,
			Fragments._OclTuple__OclTuple /* 1 */
		};
		private static final @NonNull int[] __OclTuple = { 1,1 };

		private static final @NonNull ExecutorFragment[] _OclType =
		{
			Fragments._OclType__OclAny /* 0 */,
			Fragments._OclType__OclElement /* 1 */,
			Fragments._OclType__OclType /* 2 */
		};
		private static final @NonNull int[] __OclType = { 1,1,1 };

		private static final @NonNull ExecutorFragment[] _OclVoid =
		{
			Fragments._OclVoid__OclAny /* 0 */,
			Fragments._OclVoid__OclVoid /* 1 */
		};
		private static final @NonNull int[] __OclVoid = { 1,1 };

		private static final @NonNull ExecutorFragment[] _OrderedSet =
		{
			Fragments._OrderedSet__OclAny /* 0 */,
			Fragments._OrderedSet__Collection /* 1 */,
			Fragments._OrderedSet__Sequence /* 2 */,
			Fragments._OrderedSet__UniqueCollection /* 2 */,
			Fragments._OrderedSet__OrderedSet /* 3 */
		};
		private static final @NonNull int[] __OrderedSet = { 1,1,2,1 };

		private static final @NonNull ExecutorFragment[] _Real =
		{
			Fragments._Real__OclAny /* 0 */,
			Fragments._Real__OclComparable /* 1 */,
			Fragments._Real__OclSummable /* 1 */,
			Fragments._Real__Real /* 2 */
		};
		private static final @NonNull int[] __Real = { 1,2,1 };

		private static final @NonNull ExecutorFragment[] _Sequence =
		{
			Fragments._Sequence__OclAny /* 0 */,
			Fragments._Sequence__Collection /* 1 */,
			Fragments._Sequence__Sequence /* 2 */
		};
		private static final @NonNull int[] __Sequence = { 1,1,1 };

		private static final @NonNull ExecutorFragment[] _Set =
		{
			Fragments._Set__OclAny /* 0 */,
			Fragments._Set__Collection /* 1 */,
			Fragments._Set__Bag /* 2 */,
			Fragments._Set__UniqueCollection /* 2 */,
			Fragments._Set__Set /* 3 */
		};
		private static final @NonNull int[] __Set = { 1,1,2,1 };

		private static final @NonNull ExecutorFragment[] _String =
		{
			Fragments._String__OclAny /* 0 */,
			Fragments._String__OclComparable /* 1 */,
			Fragments._String__OclSummable /* 1 */,
			Fragments._String__String /* 2 */
		};
		private static final @NonNull int[] __String = { 1,2,1 };

		private static final @NonNull ExecutorFragment[] _UniqueCollection =
		{
			Fragments._UniqueCollection__OclAny /* 0 */,
			Fragments._UniqueCollection__Collection /* 1 */,
			Fragments._UniqueCollection__UniqueCollection /* 2 */
		};
		private static final @NonNull int[] __UniqueCollection = { 1,1,1 };

		private static final @NonNull ExecutorFragment[] _UnlimitedNatural =
		{
			Fragments._UnlimitedNatural__OclAny /* 0 */,
			Fragments._UnlimitedNatural__OclComparable /* 1 */,
			Fragments._UnlimitedNatural__OclSummable /* 1 */,
			Fragments._UnlimitedNatural__Real /* 2 */,
			Fragments._UnlimitedNatural__Integer /* 3 */,
			Fragments._UnlimitedNatural__UnlimitedNatural /* 4 */
		};
		private static final @NonNull int[] __UnlimitedNatural = { 1,2,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._Bag.initFragments(_Bag, __Bag);
			Types._Boolean.initFragments(_Boolean, __Boolean);
			Types._Collection.initFragments(_Collection, __Collection);
			Types._Integer.initFragments(_Integer, __Integer);
			Types._OclAny.initFragments(_OclAny, __OclAny);
			Types._OclComparable.initFragments(_OclComparable, __OclComparable);
			Types._OclElement.initFragments(_OclElement, __OclElement);
			Types._OclInvalid.initFragments(_OclInvalid, __OclInvalid);
			Types._OclLambda.initFragments(_OclLambda, __OclLambda);
			Types._OclMessage.initFragments(_OclMessage, __OclMessage);
			Types._OclSelf.initFragments(_OclSelf, __OclSelf);
			Types._OclState.initFragments(_OclState, __OclState);
			Types._OclSummable.initFragments(_OclSummable, __OclSummable);
			Types._OclTuple.initFragments(_OclTuple, __OclTuple);
			Types._OclType.initFragments(_OclType, __OclType);
			Types._OclVoid.initFragments(_OclVoid, __OclVoid);
			Types._OrderedSet.initFragments(_OrderedSet, __OrderedSet);
			Types._Real.initFragments(_Real, __Real);
			Types._Sequence.initFragments(_Sequence, __Sequence);
			Types._Set.initFragments(_Set, __Set);
			Types._String.initFragments(_String, __String);
			Types._UniqueCollection.initFragments(_UniqueCollection, __UniqueCollection);
			Types._UnlimitedNatural.initFragments(_UnlimitedNatural, __UnlimitedNatural);
		}

		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		private static final @NonNull ExecutorOperation[] _Bag__Bag = {
			OCLstdlibTables.Operations._Bag___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Bag___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Bag__closure /* closure(T|Lambda T() : Set(T)) */,
			OCLstdlibTables.Operations._Bag__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Bag__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Bag__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._Bag__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._Bag__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Bag__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Bag__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Bag__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Bag__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Bag__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Bag__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Bag__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */
		};
		private static final @NonNull ExecutorOperation[] _Bag__Collection = {
			OCLstdlibTables.Operations._Bag___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Bag___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Bag__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Bag__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Bag__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._Bag__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Bag__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Bag__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Bag__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__0_intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Bag__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Bag__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Bag__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Bag__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._Bag__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation[] _Bag__OclAny = {
			OCLstdlibTables.Operations._Bag___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Bag___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _Boolean__Boolean = {
			OCLstdlibTables.Operations._Boolean___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Boolean___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Boolean__and /* _'and'(Boolean[?]) */,
			OCLstdlibTables.Operations._Boolean__implies /* _'implies'(Boolean[?]) */,
			OCLstdlibTables.Operations._Boolean__not /* _'not'() */,
			OCLstdlibTables.Operations._Boolean__or /* _'or'(Boolean[?]) */,
			OCLstdlibTables.Operations._Boolean__xor /* _'xor'(Boolean[?]) */,
			OCLstdlibTables.Operations._Boolean__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._Boolean__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Boolean__OclAny = {
			OCLstdlibTables.Operations._Boolean___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Boolean___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._Boolean__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _Collection__Collection = {
			OCLstdlibTables.Operations._Collection___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Collection___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Collection__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Collection__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__0_intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Collection__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._Collection__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation[] _Collection__OclAny = {
			OCLstdlibTables.Operations._Collection___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Collection___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _Integer__Integer = {
			OCLstdlibTables.Operations._Integer___mul_ /* _'*'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___add_ /* _'+'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___neg_ /* _'-'() */,
			OCLstdlibTables.Operations._Integer___sub_ /* _'-'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___div_ /* _'/'(OclSelf) */,
			OCLstdlibTables.Operations._Integer__abs /* abs() */,
			OCLstdlibTables.Operations._Integer__compareTo /* compareTo(OclSelf) */,
			OCLstdlibTables.Operations._Integer__div /* div(Integer) */,
			OCLstdlibTables.Operations._Integer__max /* max(OclSelf) */,
			OCLstdlibTables.Operations._Integer__min /* min(OclSelf) */,
			OCLstdlibTables.Operations._Integer__mod /* mod(Integer) */,
			OCLstdlibTables.Operations._Integer__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Integer__OclAny = {
			OCLstdlibTables.Operations._Real___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._Integer__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Integer__OclComparable = {
			OCLstdlibTables.Operations._Real___lt_ /* _'<'(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt__eq_ /* _'<='(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt_ /* _'>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt__eq_ /* _'>='(OclSelf) */,
			OCLstdlibTables.Operations._Integer__compareTo /* compareTo(OclSelf) */
		};
		private static final @NonNull ExecutorOperation[] _Integer__OclSummable = {
			OCLstdlibTables.Operations._OclSummable__sum /* sum(OclSelf) */,
			OCLstdlibTables.Operations._OclSummable__zero /* zero() */
		};
		private static final @NonNull ExecutorOperation[] _Integer__Real = {
			OCLstdlibTables.Operations._Integer___mul_ /* _'*'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___add_ /* _'+'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___neg_ /* _'-'() */,
			OCLstdlibTables.Operations._Integer___sub_ /* _'-'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___div_ /* _'/'(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt_ /* _'<'(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt__eq_ /* _'<='(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt_ /* _'>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt__eq_ /* _'>='(OclSelf) */,
			OCLstdlibTables.Operations._Integer__abs /* abs() */,
			OCLstdlibTables.Operations._Integer__compareTo /* compareTo(OclSelf) */,
			OCLstdlibTables.Operations._Real__floor /* floor() */,
			OCLstdlibTables.Operations._Integer__max /* max(OclSelf) */,
			OCLstdlibTables.Operations._Integer__min /* min(OclSelf) */,
			OCLstdlibTables.Operations._Real__round /* round() */,
			OCLstdlibTables.Operations._Integer__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OclAny__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OclComparable__OclComparable = {
			OCLstdlibTables.Operations._OclComparable___lt_ /* _'<'(OclSelf) */,
			OCLstdlibTables.Operations._OclComparable___lt__eq_ /* _'<='(OclSelf) */,
			OCLstdlibTables.Operations._OclComparable___gt_ /* _'>'(OclSelf) */,
			OCLstdlibTables.Operations._OclComparable___gt__eq_ /* _'>='(OclSelf) */,
			OCLstdlibTables.Operations._OclComparable__compareTo /* compareTo(OclSelf) */
		};
		private static final @NonNull ExecutorOperation[] _OclComparable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OclElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _OclElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OclInvalid__OclInvalid = {
			OCLstdlibTables.Operations._OclInvalid___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclInvalid___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclInvalid__and /* _'and'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclInvalid__implies /* _'implies'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclInvalid__or /* _'or'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclInvalid__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclInvalid__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclInvalid__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclInvalid__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclInvalid__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclInvalid__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _OclInvalid__OclAny = {
			OCLstdlibTables.Operations._OclInvalid___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclInvalid___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclInvalid__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclInvalid__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclInvalid__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclInvalid__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclInvalid__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclInvalid__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclInvalid__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _OclInvalid__OclVoid = {
			OCLstdlibTables.Operations._OclInvalid___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclInvalid___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclInvalid__and /* _'and'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclInvalid__implies /* _'implies'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclInvalid__or /* _'or'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclInvalid__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclInvalid__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclInvalid__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclInvalid__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OclLambda__OclLambda = {};
		private static final @NonNull ExecutorOperation[] _OclLambda__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OclMessage__OclMessage = {
			OCLstdlibTables.Operations._OclMessage__hasReturned /* hasReturned() */,
			OCLstdlibTables.Operations._OclMessage__isOperationCall /* isOperationCall() */,
			OCLstdlibTables.Operations._OclMessage__isSignalSent /* isSignalSent() */,
			OCLstdlibTables.Operations._OclMessage__result /* result() */
		};
		private static final @NonNull ExecutorOperation[] _OclMessage__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OclSelf__OclSelf = {};
		private static final @NonNull ExecutorOperation[] _OclSelf__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OclState__OclState = {};
		private static final @NonNull ExecutorOperation[] _OclState__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OclSummable__OclSummable = {
			OCLstdlibTables.Operations._OclSummable__sum /* sum(OclSelf) */,
			OCLstdlibTables.Operations._OclSummable__zero /* zero() */
		};
		private static final @NonNull ExecutorOperation[] _OclSummable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OclTuple__OclTuple = {
			OCLstdlibTables.Operations._OclTuple___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclTuple___eq_ /* _'='(OclSelf) */
		};
		private static final @NonNull ExecutorOperation[] _OclTuple__OclAny = {
			OCLstdlibTables.Operations._OclTuple___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclTuple___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OclType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _OclType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _OclType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final @NonNull ExecutorOperation[] _OclVoid__OclVoid = {
			OCLstdlibTables.Operations._OclVoid___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclVoid___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclVoid__and /* _'and'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclVoid__implies /* _'implies'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclVoid__or /* _'or'(Boolean[?]) */,
			OCLstdlibTables.Operations._OclVoid__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclVoid__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclVoid__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclVoid__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _OclVoid__OclAny = {
			OCLstdlibTables.Operations._OclVoid___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclVoid___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclVoid__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclVoid__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclVoid__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OrderedSet__OrderedSet = {
			OCLstdlibTables.Operations._OrderedSet___sub_ /* _'-'(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._OrderedSet___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OrderedSet___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OrderedSet__append /* append(T[?]) */,
			OCLstdlibTables.Operations._OrderedSet__appendAll /* appendAll(OrderedSet(T)) */,
			OCLstdlibTables.Operations._OrderedSet__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._OrderedSet__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._OrderedSet__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._OrderedSet__including /* including(T[?]) */,
			OCLstdlibTables.Operations._OrderedSet__insertAt /* insertAt(Integer,T[?]) */,
			OCLstdlibTables.Operations._OrderedSet__prepend /* prepend(T[?]) */,
			OCLstdlibTables.Operations._OrderedSet__prependAll /* prependAll(OrderedSet(T)) */,
			OCLstdlibTables.Operations._OrderedSet__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._OrderedSet__reverse /* reverse() */,
			OCLstdlibTables.Operations._OrderedSet__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._OrderedSet__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OrderedSet__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OrderedSet__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._OrderedSet__subOrderedSet /* subOrderedSet(Integer,Integer) */
		};
		private static final @NonNull ExecutorOperation[] _OrderedSet__Collection = {
			OCLstdlibTables.Operations._OrderedSet___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OrderedSet___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Sequence__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Sequence__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._OrderedSet__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._OrderedSet__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._OrderedSet__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._OrderedSet__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Collection__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._OrderedSet__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._OrderedSet__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._OrderedSet__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OrderedSet__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._OrderedSet__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation[] _OrderedSet__OclAny = {
			OCLstdlibTables.Operations._OrderedSet___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OrderedSet___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _OrderedSet__Sequence = {
			OCLstdlibTables.Operations._OrderedSet___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OrderedSet___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OrderedSet__append /* append(T[?]) */,
			OCLstdlibTables.Operations._Sequence__appendAll /* appendAll(Sequence(T)) */,
			OCLstdlibTables.Operations._Sequence__at /* at(Integer) */,
			OCLstdlibTables.Operations._Sequence__closure /* closure(T|Lambda T() : OrderedSet(T)) */,
			OCLstdlibTables.Operations._Sequence__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Sequence__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._OrderedSet__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._OrderedSet__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._Sequence__first /* first() */,
			OCLstdlibTables.Operations._OrderedSet__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._OrderedSet__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Sequence__indexOf /* indexOf(OclAny[?]) */,
			OCLstdlibTables.Operations._OrderedSet__insertAt /* insertAt(Integer,T[?]) */,
			OCLstdlibTables.Operations._Sequence__last /* last() */,
			OCLstdlibTables.Operations._OrderedSet__prepend /* prepend(T[?]) */,
			OCLstdlibTables.Operations._Sequence__prependAll /* prependAll(Sequence(T)) */,
			OCLstdlibTables.Operations._OrderedSet__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._OrderedSet__reverse /* reverse() */,
			OCLstdlibTables.Operations._OrderedSet__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._OrderedSet__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OrderedSet__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OrderedSet__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._Sequence__subSequence /* subSequence(Integer,Integer) */
		};
		private static final @NonNull ExecutorOperation[] _OrderedSet__UniqueCollection = {
			OCLstdlibTables.Operations._OrderedSet___sub_ /* _'-'(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._OrderedSet__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._UniqueCollection__symmetricDifference /* symmetricDifference(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__union /* union(UniqueCollection(T)) */
		};

		private static final @NonNull ExecutorOperation[] _Real__Real = {
			OCLstdlibTables.Operations._Real___mul_ /* _'*'(OclSelf) */,
			OCLstdlibTables.Operations._Real___add_ /* _'+'(OclSelf) */,
			OCLstdlibTables.Operations._Real___neg_ /* _'-'() */,
			OCLstdlibTables.Operations._Real___sub_ /* _'-'(OclSelf) */,
			OCLstdlibTables.Operations._Real___div_ /* _'/'(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt_ /* _'<'(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt__eq_ /* _'<='(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt_ /* _'>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt__eq_ /* _'>='(OclSelf) */,
			OCLstdlibTables.Operations._Real__abs /* abs() */,
			OCLstdlibTables.Operations._Real__compareTo /* compareTo(OclSelf) */,
			OCLstdlibTables.Operations._Real__floor /* floor() */,
			OCLstdlibTables.Operations._Real__max /* max(OclSelf) */,
			OCLstdlibTables.Operations._Real__min /* min(OclSelf) */,
			OCLstdlibTables.Operations._Real__round /* round() */,
			OCLstdlibTables.Operations._Real__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Real__OclAny = {
			OCLstdlibTables.Operations._Real___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._Real__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Real__OclComparable = {
			OCLstdlibTables.Operations._Real___lt_ /* _'<'(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt__eq_ /* _'<='(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt_ /* _'>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt__eq_ /* _'>='(OclSelf) */,
			OCLstdlibTables.Operations._Real__compareTo /* compareTo(OclSelf) */
		};
		private static final @NonNull ExecutorOperation[] _Real__OclSummable = {
			OCLstdlibTables.Operations._OclSummable__sum /* sum(OclSelf) */,
			OCLstdlibTables.Operations._OclSummable__zero /* zero() */
		};

		private static final @NonNull ExecutorOperation[] _Sequence__Sequence = {
			OCLstdlibTables.Operations._Sequence___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Sequence___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Sequence__append /* append(T[?]) */,
			OCLstdlibTables.Operations._Sequence__appendAll /* appendAll(Sequence(T)) */,
			OCLstdlibTables.Operations._Sequence__at /* at(Integer) */,
			OCLstdlibTables.Operations._Sequence__closure /* closure(T|Lambda T() : OrderedSet(T)) */,
			OCLstdlibTables.Operations._Sequence__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Sequence__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Sequence__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._Sequence__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._Sequence__first /* first() */,
			OCLstdlibTables.Operations._Sequence__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Sequence__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Sequence__indexOf /* indexOf(OclAny[?]) */,
			OCLstdlibTables.Operations._Sequence__insertAt /* insertAt(Integer,T[?]) */,
			OCLstdlibTables.Operations._Sequence__last /* last() */,
			OCLstdlibTables.Operations._Sequence__prepend /* prepend(T[?]) */,
			OCLstdlibTables.Operations._Sequence__prependAll /* prependAll(Sequence(T)) */,
			OCLstdlibTables.Operations._Sequence__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Sequence__reverse /* reverse() */,
			OCLstdlibTables.Operations._Sequence__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Sequence__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Sequence__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Sequence__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._Sequence__subSequence /* subSequence(Integer,Integer) */
		};
		private static final @NonNull ExecutorOperation[] _Sequence__Collection = {
			OCLstdlibTables.Operations._Sequence___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Sequence___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Sequence__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Sequence__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Sequence__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._Sequence__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Sequence__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Sequence__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Collection__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__0_intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Sequence__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Sequence__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Sequence__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Sequence__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._Sequence__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation[] _Sequence__OclAny = {
			OCLstdlibTables.Operations._Sequence___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Sequence___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _Set__Set = {
			OCLstdlibTables.Operations._Set___sub_ /* _'-'(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._Set___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Set___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Set__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._Set__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._Set__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Set__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Set__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Set__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Set__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Set__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Set__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Set__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */
		};
		private static final @NonNull ExecutorOperation[] _Set__Bag = {
			OCLstdlibTables.Operations._Set___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Set___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Bag__closure /* closure(T|Lambda T() : Set(T)) */,
			OCLstdlibTables.Operations._Bag__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Bag__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Set__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._Set__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._Set__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Set__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Set__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._Set__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Set__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Set__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Set__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Set__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */
		};
		private static final @NonNull ExecutorOperation[] _Set__Collection = {
			OCLstdlibTables.Operations._Set___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Set___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Bag__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Bag__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Set__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._Set__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Set__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Set__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Set__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Set__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Set__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Set__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Set__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._Set__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation[] _Set__OclAny = {
			OCLstdlibTables.Operations._Set___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Set___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Set__UniqueCollection = {
			OCLstdlibTables.Operations._Set___sub_ /* _'-'(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Set__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._UniqueCollection__symmetricDifference /* symmetricDifference(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__union /* union(UniqueCollection(T)) */
		};

		private static final @NonNull ExecutorOperation[] _String__String = {
			OCLstdlibTables.Operations._String___add_ /* _'+'(String) */,
			OCLstdlibTables.Operations._String___lt_ /* _'<'(OclSelf) */,
			OCLstdlibTables.Operations._String___lt__eq_ /* _'<='(OclSelf) */,
			OCLstdlibTables.Operations._String___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._String___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._String___gt_ /* _'>'(OclSelf) */,
			OCLstdlibTables.Operations._String___gt__eq_ /* _'>='(OclSelf) */,
			OCLstdlibTables.Operations._String__at /* at(Integer) */,
			OCLstdlibTables.Operations._String__characters /* characters() */,
			OCLstdlibTables.Operations._String__compareTo /* compareTo(OclSelf) */,
			OCLstdlibTables.Operations._String__concat /* concat(String) */,
			OCLstdlibTables.Operations._String__endsWith /* endsWith(String) */,
			OCLstdlibTables.Operations._String__equalsIgnoreCase /* equalsIgnoreCase(String) */,
			OCLstdlibTables.Operations._String__indexOf /* indexOf(String) */,
			OCLstdlibTables.Operations._String__lastIndexOf /* lastIndexOf(String) */,
			OCLstdlibTables.Operations._String__matches /* matches(String) */,
			OCLstdlibTables.Operations._String__replaceAll /* replaceAll(String,String) */,
			OCLstdlibTables.Operations._String__replaceFirst /* replaceFirst(String,String) */,
			OCLstdlibTables.Operations._String__size /* size() */,
			OCLstdlibTables.Operations._String__startsWith /* startsWith(String) */,
			OCLstdlibTables.Operations._String__substituteAll /* substituteAll(String,String) */,
			OCLstdlibTables.Operations._String__substituteFirst /* substituteFirst(String,String) */,
			OCLstdlibTables.Operations._String__substring /* substring(Integer,Integer) */,
			OCLstdlibTables.Operations._String__toBoolean /* toBoolean() */,
			OCLstdlibTables.Operations._String__toInteger /* toInteger() */,
			OCLstdlibTables.Operations._String__toLower /* toLower() */,
			OCLstdlibTables.Operations._String__toLowerCase /* toLowerCase() */,
			OCLstdlibTables.Operations._String__toReal /* toReal() */,
			OCLstdlibTables.Operations._String__toString /* toString() */,
			OCLstdlibTables.Operations._String__toUpper /* toUpper() */,
			OCLstdlibTables.Operations._String__toUpperCase /* toUpperCase() */,
			OCLstdlibTables.Operations._String__0_tokenize /* tokenize() */,
			OCLstdlibTables.Operations._String__1_tokenize /* tokenize(String) */,
			OCLstdlibTables.Operations._String__2_tokenize /* tokenize(String,Boolean) */,
			OCLstdlibTables.Operations._String__trim /* trim() */
		};
		private static final @NonNull ExecutorOperation[] _String__OclAny = {
			OCLstdlibTables.Operations._String___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._String___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._String__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _String__OclComparable = {
			OCLstdlibTables.Operations._String___lt_ /* _'<'(OclSelf) */,
			OCLstdlibTables.Operations._String___lt__eq_ /* _'<='(OclSelf) */,
			OCLstdlibTables.Operations._String___gt_ /* _'>'(OclSelf) */,
			OCLstdlibTables.Operations._String___gt__eq_ /* _'>='(OclSelf) */,
			OCLstdlibTables.Operations._String__compareTo /* compareTo(OclSelf) */
		};
		private static final @NonNull ExecutorOperation[] _String__OclSummable = {
			OCLstdlibTables.Operations._OclSummable__sum /* sum(OclSelf) */,
			OCLstdlibTables.Operations._OclSummable__zero /* zero() */
		};

		private static final @NonNull ExecutorOperation[] _UniqueCollection__UniqueCollection = {
			OCLstdlibTables.Operations._UniqueCollection___sub_ /* _'-'(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._UniqueCollection__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._UniqueCollection__symmetricDifference /* symmetricDifference(UniqueCollection(OclAny)) */,
			OCLstdlibTables.Operations._UniqueCollection__union /* union(UniqueCollection(T)) */
		};
		private static final @NonNull ExecutorOperation[] _UniqueCollection__Collection = {
			OCLstdlibTables.Operations._Collection___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Collection___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Collection__any /* any(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__asBag /* asBag() */,
			OCLstdlibTables.Operations._Collection__asOrderedSet /* asOrderedSet() */,
			OCLstdlibTables.Operations._Collection__asSequence /* asSequence() */,
			OCLstdlibTables.Operations._Collection__asSet /* asSet() */,
			OCLstdlibTables.Operations._Collection__collect /* collect(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__collectNested /* collectNested(V)(T[?]|Lambda T() : V[?]) */,
			OCLstdlibTables.Operations._Collection__count /* count(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludes /* excludes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludesAll /* excludesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__excluding /* excluding(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__excludingAll /* excludingAll(Collection(OclAny)) */,
			OCLstdlibTables.Operations._Collection__1_exists /* exists(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_exists /* exists(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__flatten /* flatten(T2)() */,
			OCLstdlibTables.Operations._Collection__1_forAll /* forAll(T[?],T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__0_forAll /* forAll(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__includes /* includes(OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__includesAll /* includesAll(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__including /* including(T[?]) */,
			OCLstdlibTables.Operations._Collection__includingAll /* includingAll(Collection(T)) */,
			OCLstdlibTables.Operations._UniqueCollection__intersection /* intersection(Collection(T)) */,
			OCLstdlibTables.Operations._Collection__1_intersection /* intersection(UniqueCollection(T)) */,
			OCLstdlibTables.Operations._Collection__isEmpty /* isEmpty() */,
			OCLstdlibTables.Operations._Collection__isUnique /* isUnique(T[?]|Lambda T() : OclAny[?]) */,
			OCLstdlibTables.Operations._Collection__iterate /* iterate(Tacc)(T[?];Tacc[?]|Lambda T() : Tacc[?]) */,
			OCLstdlibTables.Operations._Collection__max /* max() */,
			OCLstdlibTables.Operations._Collection__min /* min() */,
			OCLstdlibTables.Operations._Collection__notEmpty /* notEmpty() */,
			OCLstdlibTables.Operations._Collection__one /* one(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__product /* product(T2)(Collection(T2)) */,
			OCLstdlibTables.Operations._Collection__reject /* reject(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__select /* select(T[?]|Lambda T() : Boolean) */,
			OCLstdlibTables.Operations._Collection__selectByKind /* selectByKind(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Collection__selectByType /* selectByType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._Collection__size /* size() */,
			OCLstdlibTables.Operations._UniqueCollection__sortedBy /* sortedBy(T[?]|Lambda T() : OclAny) */,
			OCLstdlibTables.Operations._Collection__sum /* sum() */,
			OCLstdlibTables.Operations._Collection__union /* union(Collection(T)) */
		};
		private static final @NonNull ExecutorOperation[] _UniqueCollection__OclAny = {
			OCLstdlibTables.Operations._Collection___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Collection___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _UnlimitedNatural__UnlimitedNatural = {
			OCLstdlibTables.Operations._UnlimitedNatural__oclAsType /* oclAsType(TT)(Metaclass(TT)) */
		};
		private static final @NonNull ExecutorOperation[] _UnlimitedNatural__Integer = {
			OCLstdlibTables.Operations._Integer___mul_ /* _'*'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___add_ /* _'+'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___neg_ /* _'-'() */,
			OCLstdlibTables.Operations._Integer___sub_ /* _'-'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___div_ /* _'/'(OclSelf) */,
			OCLstdlibTables.Operations._Integer__abs /* abs() */,
			OCLstdlibTables.Operations._Integer__compareTo /* compareTo(OclSelf) */,
			OCLstdlibTables.Operations._Integer__div /* div(Integer) */,
			OCLstdlibTables.Operations._Integer__max /* max(OclSelf) */,
			OCLstdlibTables.Operations._Integer__min /* min(OclSelf) */,
			OCLstdlibTables.Operations._Integer__mod /* mod(Integer) */,
			OCLstdlibTables.Operations._Integer__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _UnlimitedNatural__OclAny = {
			OCLstdlibTables.Operations._Real___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._UnlimitedNatural__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._Integer__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _UnlimitedNatural__OclComparable = {
			OCLstdlibTables.Operations._Real___lt_ /* _'<'(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt__eq_ /* _'<='(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt_ /* _'>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt__eq_ /* _'>='(OclSelf) */,
			OCLstdlibTables.Operations._Integer__compareTo /* compareTo(OclSelf) */
		};
		private static final @NonNull ExecutorOperation[] _UnlimitedNatural__OclSummable = {
			OCLstdlibTables.Operations._OclSummable__sum /* sum(OclSelf) */,
			OCLstdlibTables.Operations._OclSummable__zero /* zero() */
		};
		private static final @NonNull ExecutorOperation[] _UnlimitedNatural__Real = {
			OCLstdlibTables.Operations._Integer___mul_ /* _'*'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___add_ /* _'+'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___neg_ /* _'-'() */,
			OCLstdlibTables.Operations._Integer___sub_ /* _'-'(OclSelf) */,
			OCLstdlibTables.Operations._Integer___div_ /* _'/'(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt_ /* _'<'(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt__eq_ /* _'<='(OclSelf) */,
			OCLstdlibTables.Operations._Real___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt_ /* _'>'(OclSelf) */,
			OCLstdlibTables.Operations._Real___gt__eq_ /* _'>='(OclSelf) */,
			OCLstdlibTables.Operations._Integer__abs /* abs() */,
			OCLstdlibTables.Operations._Integer__compareTo /* compareTo(OclSelf) */,
			OCLstdlibTables.Operations._Real__floor /* floor() */,
			OCLstdlibTables.Operations._Integer__max /* max(OclSelf) */,
			OCLstdlibTables.Operations._Integer__min /* min(OclSelf) */,
			OCLstdlibTables.Operations._Real__round /* round() */,
			OCLstdlibTables.Operations._Integer__toString /* toString() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Bag__Bag.initOperations(_Bag__Bag);
			Fragments._Bag__Collection.initOperations(_Bag__Collection);
			Fragments._Bag__OclAny.initOperations(_Bag__OclAny);

			Fragments._Boolean__Boolean.initOperations(_Boolean__Boolean);
			Fragments._Boolean__OclAny.initOperations(_Boolean__OclAny);

			Fragments._Collection__Collection.initOperations(_Collection__Collection);
			Fragments._Collection__OclAny.initOperations(_Collection__OclAny);

			Fragments._Integer__Integer.initOperations(_Integer__Integer);
			Fragments._Integer__OclAny.initOperations(_Integer__OclAny);
			Fragments._Integer__OclComparable.initOperations(_Integer__OclComparable);
			Fragments._Integer__OclSummable.initOperations(_Integer__OclSummable);
			Fragments._Integer__Real.initOperations(_Integer__Real);

			Fragments._OclAny__OclAny.initOperations(_OclAny__OclAny);

			Fragments._OclComparable__OclAny.initOperations(_OclComparable__OclAny);
			Fragments._OclComparable__OclComparable.initOperations(_OclComparable__OclComparable);

			Fragments._OclElement__OclAny.initOperations(_OclElement__OclAny);
			Fragments._OclElement__OclElement.initOperations(_OclElement__OclElement);

			Fragments._OclInvalid__OclAny.initOperations(_OclInvalid__OclAny);
			Fragments._OclInvalid__OclInvalid.initOperations(_OclInvalid__OclInvalid);
			Fragments._OclInvalid__OclVoid.initOperations(_OclInvalid__OclVoid);

			Fragments._OclLambda__OclAny.initOperations(_OclLambda__OclAny);
			Fragments._OclLambda__OclLambda.initOperations(_OclLambda__OclLambda);

			Fragments._OclMessage__OclAny.initOperations(_OclMessage__OclAny);
			Fragments._OclMessage__OclMessage.initOperations(_OclMessage__OclMessage);

			Fragments._OclSelf__OclAny.initOperations(_OclSelf__OclAny);
			Fragments._OclSelf__OclSelf.initOperations(_OclSelf__OclSelf);

			Fragments._OclState__OclAny.initOperations(_OclState__OclAny);
			Fragments._OclState__OclState.initOperations(_OclState__OclState);

			Fragments._OclSummable__OclAny.initOperations(_OclSummable__OclAny);
			Fragments._OclSummable__OclSummable.initOperations(_OclSummable__OclSummable);

			Fragments._OclTuple__OclAny.initOperations(_OclTuple__OclAny);
			Fragments._OclTuple__OclTuple.initOperations(_OclTuple__OclTuple);

			Fragments._OclType__OclAny.initOperations(_OclType__OclAny);
			Fragments._OclType__OclElement.initOperations(_OclType__OclElement);
			Fragments._OclType__OclType.initOperations(_OclType__OclType);

			Fragments._OclVoid__OclAny.initOperations(_OclVoid__OclAny);
			Fragments._OclVoid__OclVoid.initOperations(_OclVoid__OclVoid);

			Fragments._OrderedSet__Collection.initOperations(_OrderedSet__Collection);
			Fragments._OrderedSet__OclAny.initOperations(_OrderedSet__OclAny);
			Fragments._OrderedSet__OrderedSet.initOperations(_OrderedSet__OrderedSet);
			Fragments._OrderedSet__Sequence.initOperations(_OrderedSet__Sequence);
			Fragments._OrderedSet__UniqueCollection.initOperations(_OrderedSet__UniqueCollection);

			Fragments._Real__OclAny.initOperations(_Real__OclAny);
			Fragments._Real__OclComparable.initOperations(_Real__OclComparable);
			Fragments._Real__OclSummable.initOperations(_Real__OclSummable);
			Fragments._Real__Real.initOperations(_Real__Real);

			Fragments._Sequence__Collection.initOperations(_Sequence__Collection);
			Fragments._Sequence__OclAny.initOperations(_Sequence__OclAny);
			Fragments._Sequence__Sequence.initOperations(_Sequence__Sequence);

			Fragments._Set__Bag.initOperations(_Set__Bag);
			Fragments._Set__Collection.initOperations(_Set__Collection);
			Fragments._Set__OclAny.initOperations(_Set__OclAny);
			Fragments._Set__Set.initOperations(_Set__Set);
			Fragments._Set__UniqueCollection.initOperations(_Set__UniqueCollection);

			Fragments._String__OclAny.initOperations(_String__OclAny);
			Fragments._String__OclComparable.initOperations(_String__OclComparable);
			Fragments._String__OclSummable.initOperations(_String__OclSummable);
			Fragments._String__String.initOperations(_String__String);

			Fragments._UniqueCollection__Collection.initOperations(_UniqueCollection__Collection);
			Fragments._UniqueCollection__OclAny.initOperations(_UniqueCollection__OclAny);
			Fragments._UniqueCollection__UniqueCollection.initOperations(_UniqueCollection__UniqueCollection);

			Fragments._UnlimitedNatural__Integer.initOperations(_UnlimitedNatural__Integer);
			Fragments._UnlimitedNatural__OclAny.initOperations(_UnlimitedNatural__OclAny);
			Fragments._UnlimitedNatural__OclComparable.initOperations(_UnlimitedNatural__OclComparable);
			Fragments._UnlimitedNatural__OclSummable.initOperations(_UnlimitedNatural__OclSummable);
			Fragments._UnlimitedNatural__Real.initOperations(_UnlimitedNatural__Real);
			Fragments._UnlimitedNatural__UnlimitedNatural.initOperations(_UnlimitedNatural__UnlimitedNatural);
		}

		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		private static final @NonNull ExecutorProperty[] _Bag = {};

		private static final @NonNull ExecutorProperty[] _Boolean = {};

		private static final @NonNull ExecutorProperty[] _Collection = {};

		private static final @NonNull ExecutorProperty[] _Integer = {};

		private static final @NonNull ExecutorProperty[] _OclAny = {};

		private static final @NonNull ExecutorProperty[] _OclComparable = {};

		private static final @NonNull ExecutorProperty[] _OclElement = {};

		private static final @NonNull ExecutorProperty[] _OclInvalid = {};

		private static final @NonNull ExecutorProperty[] _OclLambda = {};

		private static final @NonNull ExecutorProperty[] _OclMessage = {};

		private static final @NonNull ExecutorProperty[] _OclSelf = {};

		private static final @NonNull ExecutorProperty[] _OclState = {};

		private static final @NonNull ExecutorProperty[] _OclSummable = {};

		private static final @NonNull ExecutorProperty[] _OclTuple = {};

		private static final @NonNull ExecutorProperty[] _OclType = {};

		private static final @NonNull ExecutorProperty[] _OclVoid = {};

		private static final @NonNull ExecutorProperty[] _OrderedSet = {};

		private static final @NonNull ExecutorProperty[] _Real = {};

		private static final @NonNull ExecutorProperty[] _Sequence = {};

		private static final @NonNull ExecutorProperty[] _Set = {};

		private static final @NonNull ExecutorProperty[] _String = {};

		private static final @NonNull ExecutorProperty[] _UniqueCollection = {};

		private static final @NonNull ExecutorProperty[] _UnlimitedNatural = {};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Bag__Bag.initProperties(_Bag);
			Fragments._Boolean__Boolean.initProperties(_Boolean);
			Fragments._Collection__Collection.initProperties(_Collection);
			Fragments._Integer__Integer.initProperties(_Integer);
			Fragments._OclAny__OclAny.initProperties(_OclAny);
			Fragments._OclComparable__OclComparable.initProperties(_OclComparable);
			Fragments._OclElement__OclElement.initProperties(_OclElement);
			Fragments._OclInvalid__OclInvalid.initProperties(_OclInvalid);
			Fragments._OclLambda__OclLambda.initProperties(_OclLambda);
			Fragments._OclMessage__OclMessage.initProperties(_OclMessage);
			Fragments._OclSelf__OclSelf.initProperties(_OclSelf);
			Fragments._OclState__OclState.initProperties(_OclState);
			Fragments._OclSummable__OclSummable.initProperties(_OclSummable);
			Fragments._OclTuple__OclTuple.initProperties(_OclTuple);
			Fragments._OclType__OclType.initProperties(_OclType);
			Fragments._OclVoid__OclVoid.initProperties(_OclVoid);
			Fragments._OrderedSet__OrderedSet.initProperties(_OrderedSet);
			Fragments._Real__Real.initProperties(_Real);
			Fragments._Sequence__Sequence.initProperties(_Sequence);
			Fragments._Set__Set.initProperties(_Set);
			Fragments._String__String.initProperties(_String);
			Fragments._UniqueCollection__UniqueCollection.initProperties(_UniqueCollection);
			Fragments._UnlimitedNatural__UnlimitedNatural.initProperties(_UnlimitedNatural);
		}

		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
		}

		public static void init() {}
	}

	static {
		Types.types[0].getClass();
	}
}
