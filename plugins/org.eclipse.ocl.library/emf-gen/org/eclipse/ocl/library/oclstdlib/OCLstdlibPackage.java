/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.ocl.library.oclstdlib;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.values.Bag;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.OrderedSet;
import org.eclipse.ocl.pivot.values.RealValue;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibFactory
 * @model kind="package"
 * @generated
 */
public class OCLstdlibPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "oclstdlib"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.eclipse.org/ocl/2015/Library"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "oclstdlib"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public static final @NonNull OCLstdlibPackage eINSTANCE = org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage.init();

	/**
	 * The meta object id for the '<em>Ocl Any</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getOclAny()
	 * @generated
	 */
	public static final int OCL_ANY = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.library.oclstdlib.OclInvalid <em>Ocl Invalid</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.library.oclstdlib.OclInvalid
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getOclInvalid()
	 * @generated
	 */
	public static final int OCL_INVALID = 0;

	/**
	 * The number of structural features of the '<em>Ocl Invalid</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OCL_INVALID_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.library.oclstdlib.OclVoid <em>Ocl Void</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.library.oclstdlib.OclVoid
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getOclVoid()
	 * @generated
	 */
	public static final int OCL_VOID = 1;

	/**
	 * The number of structural features of the '<em>Ocl Void</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OCL_VOID_FEATURE_COUNT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclInvalidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclVoidEClass = null;

	/**
	 * The meta object id for the '<em>Boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Boolean
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getBoolean()
	 * @generated
	 */
	public static final int BOOLEAN = 2;

	/**
	 * The meta object id for the '<em>Integer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.values.IntegerValue
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getInteger()
	 * @generated
	 */
	public static final int INTEGER = 3;

	/**
	 * The meta object id for the '<em>Real</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.values.RealValue
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getReal()
	 * @generated
	 */
	public static final int REAL = 4;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getString()
	 * @generated
	 */
	public static final int STRING = 5;

	/**
	 * The meta object id for the '<em>Unlimited Natural</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.values.IntegerValue
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getUnlimitedNatural()
	 * @generated
	 */
	public static final int UNLIMITED_NATURAL = 6;

	/**
	 * The meta object id for the '<em>Bag</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.values.Bag
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getBag()
	 * @generated
	 */
	public static final int BAG = 7;

	/**
	 * The meta object id for the '<em>Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getCollection()
	 * @generated
	 */
	public static final int COLLECTION = 8;

	/**
	 * The meta object id for the '<em>Ordered Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.values.OrderedSet
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getOrderedSet()
	 * @generated
	 */
	public static final int ORDERED_SET = 9;

	/**
	 * The meta object id for the '<em>Sequence</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getSequence()
	 * @generated
	 */
	public static final int SEQUENCE = 10;

	/**
	 * The meta object id for the '<em>Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Set
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getSet()
	 * @generated
	 */
	public static final int SET = 11;

	/**
	 * The meta object id for the '<em>Unique Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Set
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getUniqueCollection()
	 * @generated
	 */
	public static final int UNIQUE_COLLECTION = 12;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType integerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType realEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType unlimitedNaturalEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType bagEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType collectionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType orderedSetEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sequenceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType setEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uniqueCollectionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType oclAnyEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OCLstdlibPackage() {
		super(eNS_URI, OCLstdlibFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OCLstdlibPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OCLstdlibPackage init() {
		if (isInited) return (OCLstdlibPackage)EPackage.Registry.INSTANCE.getEPackage(OCLstdlibPackage.eNS_URI);

		// Obtain or create and register package
		OCLstdlibPackage theOCLstdlibPackage = (OCLstdlibPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OCLstdlibPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OCLstdlibPackage());

		isInited = true;

		// Create package meta-data objects
		theOCLstdlibPackage.createPackageContents();

		// Initialize created meta-data
		theOCLstdlibPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOCLstdlibPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OCLstdlibPackage.eNS_URI, theOCLstdlibPackage);
		return theOCLstdlibPackage;
	}


	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Ocl Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ocl Any</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	public EDataType getOclAny() {
		return oclAnyEDataType;
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.library.oclstdlib.OclInvalid <em>Ocl Invalid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Invalid</em>'.
	 * @see org.eclipse.ocl.library.oclstdlib.OclInvalid
	 * @generated
	 */
	public EClass getOclInvalid() {
		return oclInvalidEClass;
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.library.oclstdlib.OclVoid <em>Ocl Void</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Void</em>'.
	 * @see org.eclipse.ocl.library.oclstdlib.OclVoid
	 * @generated
	 */
	public EClass getOclVoid() {
		return oclVoidEClass;
	}


	/**
	 * Returns the meta object for data type '{@link java.lang.Boolean <em>Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Boolean</em>'.
	 * @see java.lang.Boolean
	 * @model instanceClass="java.lang.Boolean"
	 * @generated
	 */
	public EDataType getBoolean() {
		return booleanEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.pivot.values.IntegerValue <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer</em>'.
	 * @see org.eclipse.ocl.pivot.values.IntegerValue
	 * @model instanceClass="org.eclipse.ocl.pivot.values.IntegerValue"
	 * @generated
	 */
	public EDataType getInteger() {
		return integerEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.pivot.values.RealValue <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Real</em>'.
	 * @see org.eclipse.ocl.pivot.values.RealValue
	 * @model instanceClass="org.eclipse.ocl.pivot.values.RealValue"
	 * @generated
	 */
	public EDataType getReal() {
		return realEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	public EDataType getString() {
		return stringEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.pivot.values.IntegerValue <em>Unlimited Natural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unlimited Natural</em>'.
	 * @see org.eclipse.ocl.pivot.values.IntegerValue
	 * @model instanceClass="org.eclipse.ocl.pivot.values.IntegerValue"
	 * @generated
	 */
	public EDataType getUnlimitedNatural() {
		return unlimitedNaturalEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.pivot.values.Bag <em>Bag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Bag</em>'.
	 * @see org.eclipse.ocl.pivot.values.Bag
	 * @model instanceClass="org.eclipse.ocl.pivot.values.Bag" typeParameters="T"
	 * @generated
	 */
	public EDataType getBag() {
		return bagEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Collection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection" typeParameters="T"
	 * @generated
	 */
	public EDataType getCollection() {
		return collectionEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.pivot.values.OrderedSet <em>Ordered Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ordered Set</em>'.
	 * @see org.eclipse.ocl.pivot.values.OrderedSet
	 * @model instanceClass="org.eclipse.ocl.pivot.values.OrderedSet" typeParameters="T"
	 * @generated
	 */
	public EDataType getOrderedSet() {
		return orderedSetEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Sequence</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List" typeParameters="T"
	 * @generated
	 */
	public EDataType getSequence() {
		return sequenceEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.Set <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Set</em>'.
	 * @see java.util.Set
	 * @model instanceClass="java.util.Set" typeParameters="T"
	 * @generated
	 */
	public EDataType getSet() {
		return setEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.Set <em>Unique Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unique Collection</em>'.
	 * @see java.util.Set
	 * @model instanceClass="java.util.Set" typeParameters="T"
	 * @generated
	 */
	public EDataType getUniqueCollection() {
		return uniqueCollectionEDataType;
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public OCLstdlibFactory getOCLstdlibFactory() {
		return (OCLstdlibFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		oclInvalidEClass = createEClass(OCL_INVALID);

		oclVoidEClass = createEClass(OCL_VOID);

		// Create data types
		booleanEDataType = createEDataType(BOOLEAN);
		integerEDataType = createEDataType(INTEGER);
		realEDataType = createEDataType(REAL);
		stringEDataType = createEDataType(STRING);
		unlimitedNaturalEDataType = createEDataType(UNLIMITED_NATURAL);
		bagEDataType = createEDataType(BAG);
		collectionEDataType = createEDataType(COLLECTION);
		orderedSetEDataType = createEDataType(ORDERED_SET);
		sequenceEDataType = createEDataType(SEQUENCE);
		setEDataType = createEDataType(SET);
		uniqueCollectionEDataType = createEDataType(UNIQUE_COLLECTION);
		oclAnyEDataType = createEDataType(OCL_ANY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		addETypeParameter(bagEDataType, "T"); //$NON-NLS-1$
		addETypeParameter(collectionEDataType, "T"); //$NON-NLS-1$
		addETypeParameter(orderedSetEDataType, "T"); //$NON-NLS-1$
		addETypeParameter(sequenceEDataType, "T"); //$NON-NLS-1$
		addETypeParameter(setEDataType, "T"); //$NON-NLS-1$
		addETypeParameter(uniqueCollectionEDataType, "T"); //$NON-NLS-1$

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(oclInvalidEClass, OclInvalid.class, "OclInvalid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(oclVoidEClass, OclVoid.class, "OclVoid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize data types
		initEDataType(booleanEDataType, Boolean.class, "Boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(integerEDataType, IntegerValue.class, "Integer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(realEDataType, RealValue.class, "Real", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(unlimitedNaturalEDataType, IntegerValue.class, "UnlimitedNatural", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(bagEDataType, Bag.class, "Bag", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(collectionEDataType, Collection.class, "Collection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(orderedSetEDataType, OrderedSet.class, "OrderedSet", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(sequenceEDataType, List.class, "Sequence", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(setEDataType, Set.class, "Set", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(uniqueCollectionEDataType, Set.class, "UniqueCollection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(oclAnyEDataType, Object.class, "OclAny", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/ASLibrary
		createASLibraryAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/ASLibrary</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createASLibraryAnnotations() {
		String source = "http://www.eclipse.org/OCL/ASLibrary"; //$NON-NLS-1$	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '<em>Ocl Any</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getOclAny()
		 * @generated
		 */
		public static final EDataType OCL_ANY = eINSTANCE.getOclAny();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.library.oclstdlib.OclInvalid <em>Ocl Invalid</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.library.oclstdlib.OclInvalid
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getOclInvalid()
		 * @generated
		 */
		public static final EClass OCL_INVALID = eINSTANCE.getOclInvalid();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.library.oclstdlib.OclVoid <em>Ocl Void</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.library.oclstdlib.OclVoid
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getOclVoid()
		 * @generated
		 */
		public static final EClass OCL_VOID = eINSTANCE.getOclVoid();

		/**
		 * The meta object literal for the '<em>Boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Boolean
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getBoolean()
		 * @generated
		 */
		public static final EDataType BOOLEAN = eINSTANCE.getBoolean();

		/**
		 * The meta object literal for the '<em>Integer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.IntegerValue
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getInteger()
		 * @generated
		 */
		public static final EDataType INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '<em>Real</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.RealValue
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getReal()
		 * @generated
		 */
		public static final EDataType REAL = eINSTANCE.getReal();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getString()
		 * @generated
		 */
		public static final EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>Unlimited Natural</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.IntegerValue
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getUnlimitedNatural()
		 * @generated
		 */
		public static final EDataType UNLIMITED_NATURAL = eINSTANCE.getUnlimitedNatural();

		/**
		 * The meta object literal for the '<em>Bag</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.Bag
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getBag()
		 * @generated
		 */
		public static final EDataType BAG = eINSTANCE.getBag();

		/**
		 * The meta object literal for the '<em>Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getCollection()
		 * @generated
		 */
		public static final EDataType COLLECTION = eINSTANCE.getCollection();

		/**
		 * The meta object literal for the '<em>Ordered Set</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.OrderedSet
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getOrderedSet()
		 * @generated
		 */
		public static final EDataType ORDERED_SET = eINSTANCE.getOrderedSet();

		/**
		 * The meta object literal for the '<em>Sequence</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getSequence()
		 * @generated
		 */
		public static final EDataType SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '<em>Set</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Set
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getSet()
		 * @generated
		 */
		public static final EDataType SET = eINSTANCE.getSet();

		/**
		 * The meta object literal for the '<em>Unique Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Set
		 * @see org.eclipse.ocl.library.oclstdlib.OCLstdlibPackage#getUniqueCollection()
		 * @generated
		 */
		public static final EDataType UNIQUE_COLLECTION = eINSTANCE.getUniqueCollection();

	}

} //OCLstdlibPackage
