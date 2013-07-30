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
package org.eclipse.ocl.examples.codegen.cgmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstant;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElementId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEqualsExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorCompositionProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorNavigationProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInfinity;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInteger;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModel;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGReal;
import org.eclipse.ocl.examples.codegen.cgmodel.CGSettableVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGString;
import org.eclipse.ocl.examples.codegen.cgmodel.CGText;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CGModelPackageImpl extends EPackageImpl implements CGModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgBooleanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgBoxExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgBuiltInIterationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgCastParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgCatchExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgCollectionExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgCollectionPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgConstantExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgConstructorExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgConstructorPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgEcoreClassConstructorExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgEcoreDataTypeConstructorExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgEcoreOperationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgEcorePropertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgElementIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgEqualsExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgExecutorCompositionPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgExecutorConstructorPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgExecutorNavigationPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgExecutorOppositePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgExecutorOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgExecutorOperationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgExecutorPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgExecutorPropertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgExecutorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgFinalVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgGuardExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgIfExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgInfinityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgIntegerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgInvalidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgIsInvalidExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgIsUndefinedExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgIterationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgIteratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgLetExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgLibraryIterateCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgLibraryIterationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgLibraryOperationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgLibraryPropertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgLocalVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgNullEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgOperationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgPropertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgRealEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgSettableVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgTextParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgThrowExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgTupleExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgTuplePartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgTuplePartCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgTypeIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgTypeExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgTypedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgUnboxExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgValuedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgVariableExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType elementIdEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType enumerationLiteralIdEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iterationEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType libraryIterationEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType libraryOperationEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType libraryPropertyEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType namedElementEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType operationEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType propertyEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tuplePartIdEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeIdEDataType = null;

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
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CGModelPackageImpl() {
		super(eNS_URI, CGModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CGModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CGModelPackage init() {
		if (isInited) return (CGModelPackage)EPackage.Registry.INSTANCE.getEPackage(CGModelPackage.eNS_URI);

		// Obtain or create and register package
		CGModelPackageImpl theCGModelPackage = (CGModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CGModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CGModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCGModelPackage.createPackageContents();

		// Initialize created meta-data
		theCGModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCGModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CGModelPackage.eNS_URI, theCGModelPackage);
		return theCGModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGBoolean() {
		return cgBooleanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGBoolean_BooleanValue() {
		return (EAttribute)cgBooleanEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGBoxExp() {
		return cgBoxExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGBuiltInIterationCallExp() {
		return cgBuiltInIterationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGBuiltInIterationCallExp_Accumulator() {
		return (EReference)cgBuiltInIterationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGCallExp() {
		return cgCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGCallExp_Invalidating() {
		return (EAttribute)cgCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGCallExp_Validating() {
		return (EAttribute)cgCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGCallExp_Source() {
		return (EReference)cgCallExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGCastParameter() {
		return cgCastParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGCastParameter_ReferredParameter() {
		return (EReference)cgCastParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGCatchExp() {
		return cgCatchExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGClass() {
		return cgClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGClass_ContainingPackage() {
		return (EReference)cgClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGClass_Operations() {
		return (EReference)cgClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGClass_Properties() {
		return (EReference)cgClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGClass_Invariants() {
		return (EReference)cgClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGCollectionExp() {
		return cgCollectionExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGCollectionExp_Parts() {
		return (EReference)cgCollectionExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGCollectionPart() {
		return cgCollectionPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGCollectionPart_First() {
		return (EReference)cgCollectionPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGCollectionPart_Last() {
		return (EReference)cgCollectionPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGCollectionPart_CollectionExp() {
		return (EReference)cgCollectionPartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGConstant() {
		return cgConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGConstantExp() {
		return cgConstantExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGConstantExp_ReferredConstant() {
		return (EReference)cgConstantExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGConstraint() {
		return cgConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGConstraint_Body() {
		return (EReference)cgConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGConstraint_Message() {
		return (EReference)cgConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGConstructorExp() {
		return cgConstructorExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGConstructorExp_Parts() {
		return (EReference)cgConstructorExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGConstructorPart() {
		return cgConstructorPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGConstructorPart_Init() {
		return (EReference)cgConstructorPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGConstructorPart_ConstructorExp() {
		return (EReference)cgConstructorPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGEcoreClassConstructorExp() {
		return cgEcoreClassConstructorExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGEcoreClassConstructorExp_EClass() {
		return (EReference)cgEcoreClassConstructorExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGEcoreDataTypeConstructorExp() {
		return cgEcoreDataTypeConstructorExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGEcoreDataTypeConstructorExp_EDataType() {
		return (EReference)cgEcoreDataTypeConstructorExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGEcoreDataTypeConstructorExp_String() {
		return (EAttribute)cgEcoreDataTypeConstructorExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGEcoreOperationCallExp() {
		return cgEcoreOperationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGEcoreOperationCallExp_EOperation() {
		return (EReference)cgEcoreOperationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGEcorePropertyCallExp() {
		return cgEcorePropertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGEcorePropertyCallExp_EStructuralFeature() {
		return (EReference)cgEcorePropertyCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGElement() {
		return cgElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGElementId() {
		return cgElementIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGElementId_ElementId() {
		return (EAttribute)cgElementIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGEqualsExp() {
		return cgEqualsExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGEqualsExp_Argument() {
		return (EReference)cgEqualsExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGExecutorCompositionProperty() {
		return cgExecutorCompositionPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGExecutorConstructorPart() {
		return cgExecutorConstructorPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGExecutorNavigationProperty() {
		return cgExecutorNavigationPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGExecutorOppositeProperty() {
		return cgExecutorOppositePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGExecutorOperation() {
		return cgExecutorOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGExecutorOperation_UnderlyingOperationId() {
		return (EReference)cgExecutorOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGExecutorOperationCallExp() {
		return cgExecutorOperationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGExecutorOperationCallExp_ExecutorOperation() {
		return (EReference)cgExecutorOperationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGExecutorProperty() {
		return cgExecutorPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGExecutorProperty_UnderlyingPropertyId() {
		return (EReference)cgExecutorPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGExecutorPropertyCallExp() {
		return cgExecutorPropertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGExecutorPropertyCallExp_ExecutorProperty() {
		return (EReference)cgExecutorPropertyCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGExecutorType() {
		return cgExecutorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGExecutorType_UnderlyingTypeId() {
		return (EReference)cgExecutorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGFinalVariable() {
		return cgFinalVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGGuardExp() {
		return cgGuardExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIfExp() {
		return cgIfExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIfExp_Condition() {
		return (EReference)cgIfExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIfExp_ThenExpression() {
		return (EReference)cgIfExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIfExp_ElseExpression() {
		return (EReference)cgIfExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGInfinity() {
		return cgInfinityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGInteger() {
		return cgIntegerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGInteger_IntegerValue() {
		return (EAttribute)cgIntegerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGInvalid() {
		return cgInvalidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGInvalid_MessageTemplate() {
		return (EAttribute)cgInvalidEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGInvalid_Bindings() {
		return (EAttribute)cgInvalidEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIsInvalidExp() {
		return cgIsInvalidExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIsUndefinedExp() {
		return cgIsUndefinedExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIterationCallExp() {
		return cgIterationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIterationCallExp_ReferredIteration() {
		return (EAttribute)cgIterationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIterationCallExp_Iterators() {
		return (EReference)cgIterationCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIterationCallExp_Body() {
		return (EReference)cgIterationCallExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIterator() {
		return cgIteratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGLetExp() {
		return cgLetExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGLetExp_Init() {
		return (EReference)cgLetExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGLetExp_In() {
		return (EReference)cgLetExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGLibraryIterateCallExp() {
		return cgLibraryIterateCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGLibraryIterateCallExp_LibraryIteration() {
		return (EAttribute)cgLibraryIterateCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGLibraryIterateCallExp_Result() {
		return (EReference)cgLibraryIterateCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGLibraryIterationCallExp() {
		return cgLibraryIterationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGLibraryIterationCallExp_LibraryIteration() {
		return (EAttribute)cgLibraryIterationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGLibraryOperationCallExp() {
		return cgLibraryOperationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGLibraryOperationCallExp_LibraryOperation() {
		return (EAttribute)cgLibraryOperationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGLibraryPropertyCallExp() {
		return cgLibraryPropertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGLibraryPropertyCallExp_LibraryProperty() {
		return (EAttribute)cgLibraryPropertyCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGLocalVariable() {
		return cgLocalVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGModel() {
		return cgModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGModel_Globals() {
		return (EReference)cgModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGModel_Packages() {
		return (EReference)cgModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGNamedElement() {
		return cgNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGNamedElement_Name() {
		return (EAttribute)cgNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGNamedElement_Pivot() {
		return (EAttribute)cgNamedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGNull() {
		return cgNullEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGOperation() {
		return cgOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGOperation_Parameters() {
		return (EReference)cgOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGOperation_Body() {
		return (EReference)cgOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGOperation_Preconditions() {
		return (EReference)cgOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGOperation_Postconditions() {
		return (EReference)cgOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGOperation_ContainingClass() {
		return (EReference)cgOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGOperation_EOperation() {
		return (EReference)cgOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGOperationCallExp() {
		return cgOperationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGOperationCallExp_Arguments() {
		return (EReference)cgOperationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGOperationCallExp_ReferredOperation() {
		return (EAttribute)cgOperationCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGPackage() {
		return cgPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGPackage_Classes() {
		return (EReference)cgPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGPackage_Packages() {
		return (EReference)cgPackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGPackage_ContainingPackage() {
		return (EReference)cgPackageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGParameter() {
		return cgParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGParameter_Operation() {
		return (EReference)cgParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGProperty() {
		return cgPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGProperty_ContainingClass() {
		return (EReference)cgPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGProperty_Body() {
		return (EReference)cgPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGPropertyCallExp() {
		return cgPropertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGPropertyCallExp_ReferredProperty() {
		return (EAttribute)cgPropertyCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGReal() {
		return cgRealEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGReal_RealValue() {
		return (EAttribute)cgRealEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGSettableVariable() {
		return cgSettableVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGString() {
		return cgStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGString_StringValue() {
		return (EAttribute)cgStringEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGText() {
		return cgTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGText_TextValue() {
		return (EAttribute)cgTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGTextParameter() {
		return cgTextParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGTextParameter_TextValue() {
		return (EAttribute)cgTextParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGThrowExp() {
		return cgThrowExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGTupleExp() {
		return cgTupleExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGTupleExp_Parts() {
		return (EReference)cgTupleExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGTuplePart() {
		return cgTuplePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGTuplePart_Init() {
		return (EReference)cgTuplePartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGTuplePart_TupleExp() {
		return (EReference)cgTuplePartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGTuplePartCallExp() {
		return cgTuplePartCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGTuplePartCallExp_PivotTuplePartId() {
		return (EAttribute)cgTuplePartCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGTypeId() {
		return cgTypeIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGTypeExp() {
		return cgTypeExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGTypeExp_ReferredType() {
		return (EReference)cgTypeExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGTypedElement() {
		return cgTypedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGTypedElement_TypeId() {
		return (EReference)cgTypedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGTypedElement_Required() {
		return (EAttribute)cgTypedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGUnboxExp() {
		return cgUnboxExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGValuedElement() {
		return cgValuedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGValuedElement_DependsOn() {
		return (EReference)cgValuedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGVariable() {
		return cgVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGVariable_Init() {
		return (EReference)cgVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGVariableExp() {
		return cgVariableExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGVariableExp_ReferredVariable() {
		return (EReference)cgVariableExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameable() {
		return nameableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getElementId() {
		return elementIdEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEnumerationLiteralId() {
		return enumerationLiteralIdEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIteration() {
		return iterationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLibraryIteration() {
		return libraryIterationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLibraryOperation() {
		return libraryOperationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLibraryProperty() {
		return libraryPropertyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNamedElement() {
		return namedElementEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumber() {
		return numberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObject() {
		return objectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOperation() {
		return operationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getProperty() {
		return propertyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTuplePartId() {
		return tuplePartIdEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeId() {
		return typeIdEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGModelFactory getCGModelFactory() {
		return (CGModelFactory)getEFactoryInstance();
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
		cgBooleanEClass = createEClass(CG_BOOLEAN);
		createEAttribute(cgBooleanEClass, CG_BOOLEAN__BOOLEAN_VALUE);

		cgBoxExpEClass = createEClass(CG_BOX_EXP);

		cgBuiltInIterationCallExpEClass = createEClass(CG_BUILT_IN_ITERATION_CALL_EXP);
		createEReference(cgBuiltInIterationCallExpEClass, CG_BUILT_IN_ITERATION_CALL_EXP__ACCUMULATOR);

		cgCallExpEClass = createEClass(CG_CALL_EXP);
		createEAttribute(cgCallExpEClass, CG_CALL_EXP__INVALIDATING);
		createEAttribute(cgCallExpEClass, CG_CALL_EXP__VALIDATING);
		createEReference(cgCallExpEClass, CG_CALL_EXP__SOURCE);

		cgCastParameterEClass = createEClass(CG_CAST_PARAMETER);
		createEReference(cgCastParameterEClass, CG_CAST_PARAMETER__REFERRED_PARAMETER);

		cgCatchExpEClass = createEClass(CG_CATCH_EXP);

		cgClassEClass = createEClass(CG_CLASS);
		createEReference(cgClassEClass, CG_CLASS__CONTAINING_PACKAGE);
		createEReference(cgClassEClass, CG_CLASS__OPERATIONS);
		createEReference(cgClassEClass, CG_CLASS__PROPERTIES);
		createEReference(cgClassEClass, CG_CLASS__INVARIANTS);

		cgCollectionExpEClass = createEClass(CG_COLLECTION_EXP);
		createEReference(cgCollectionExpEClass, CG_COLLECTION_EXP__PARTS);

		cgCollectionPartEClass = createEClass(CG_COLLECTION_PART);
		createEReference(cgCollectionPartEClass, CG_COLLECTION_PART__FIRST);
		createEReference(cgCollectionPartEClass, CG_COLLECTION_PART__LAST);
		createEReference(cgCollectionPartEClass, CG_COLLECTION_PART__COLLECTION_EXP);

		cgConstantEClass = createEClass(CG_CONSTANT);

		cgConstantExpEClass = createEClass(CG_CONSTANT_EXP);
		createEReference(cgConstantExpEClass, CG_CONSTANT_EXP__REFERRED_CONSTANT);

		cgConstraintEClass = createEClass(CG_CONSTRAINT);
		createEReference(cgConstraintEClass, CG_CONSTRAINT__BODY);
		createEReference(cgConstraintEClass, CG_CONSTRAINT__MESSAGE);

		cgConstructorExpEClass = createEClass(CG_CONSTRUCTOR_EXP);
		createEReference(cgConstructorExpEClass, CG_CONSTRUCTOR_EXP__PARTS);

		cgConstructorPartEClass = createEClass(CG_CONSTRUCTOR_PART);
		createEReference(cgConstructorPartEClass, CG_CONSTRUCTOR_PART__INIT);
		createEReference(cgConstructorPartEClass, CG_CONSTRUCTOR_PART__CONSTRUCTOR_EXP);

		cgEcoreClassConstructorExpEClass = createEClass(CG_ECORE_CLASS_CONSTRUCTOR_EXP);
		createEReference(cgEcoreClassConstructorExpEClass, CG_ECORE_CLASS_CONSTRUCTOR_EXP__ECLASS);

		cgEcoreDataTypeConstructorExpEClass = createEClass(CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP);
		createEReference(cgEcoreDataTypeConstructorExpEClass, CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__EDATA_TYPE);
		createEAttribute(cgEcoreDataTypeConstructorExpEClass, CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__STRING);

		cgEcoreOperationCallExpEClass = createEClass(CG_ECORE_OPERATION_CALL_EXP);
		createEReference(cgEcoreOperationCallExpEClass, CG_ECORE_OPERATION_CALL_EXP__EOPERATION);

		cgEcorePropertyCallExpEClass = createEClass(CG_ECORE_PROPERTY_CALL_EXP);
		createEReference(cgEcorePropertyCallExpEClass, CG_ECORE_PROPERTY_CALL_EXP__ESTRUCTURAL_FEATURE);

		cgElementEClass = createEClass(CG_ELEMENT);

		cgElementIdEClass = createEClass(CG_ELEMENT_ID);
		createEAttribute(cgElementIdEClass, CG_ELEMENT_ID__ELEMENT_ID);

		cgEqualsExpEClass = createEClass(CG_EQUALS_EXP);
		createEReference(cgEqualsExpEClass, CG_EQUALS_EXP__ARGUMENT);

		cgExecutorCompositionPropertyEClass = createEClass(CG_EXECUTOR_COMPOSITION_PROPERTY);

		cgExecutorConstructorPartEClass = createEClass(CG_EXECUTOR_CONSTRUCTOR_PART);

		cgExecutorNavigationPropertyEClass = createEClass(CG_EXECUTOR_NAVIGATION_PROPERTY);

		cgExecutorOppositePropertyEClass = createEClass(CG_EXECUTOR_OPPOSITE_PROPERTY);

		cgExecutorOperationEClass = createEClass(CG_EXECUTOR_OPERATION);
		createEReference(cgExecutorOperationEClass, CG_EXECUTOR_OPERATION__UNDERLYING_OPERATION_ID);

		cgExecutorOperationCallExpEClass = createEClass(CG_EXECUTOR_OPERATION_CALL_EXP);
		createEReference(cgExecutorOperationCallExpEClass, CG_EXECUTOR_OPERATION_CALL_EXP__EXECUTOR_OPERATION);

		cgExecutorPropertyEClass = createEClass(CG_EXECUTOR_PROPERTY);
		createEReference(cgExecutorPropertyEClass, CG_EXECUTOR_PROPERTY__UNDERLYING_PROPERTY_ID);

		cgExecutorPropertyCallExpEClass = createEClass(CG_EXECUTOR_PROPERTY_CALL_EXP);
		createEReference(cgExecutorPropertyCallExpEClass, CG_EXECUTOR_PROPERTY_CALL_EXP__EXECUTOR_PROPERTY);

		cgExecutorTypeEClass = createEClass(CG_EXECUTOR_TYPE);
		createEReference(cgExecutorTypeEClass, CG_EXECUTOR_TYPE__UNDERLYING_TYPE_ID);

		cgFinalVariableEClass = createEClass(CG_FINAL_VARIABLE);

		cgGuardExpEClass = createEClass(CG_GUARD_EXP);

		cgIfExpEClass = createEClass(CG_IF_EXP);
		createEReference(cgIfExpEClass, CG_IF_EXP__CONDITION);
		createEReference(cgIfExpEClass, CG_IF_EXP__THEN_EXPRESSION);
		createEReference(cgIfExpEClass, CG_IF_EXP__ELSE_EXPRESSION);

		cgInfinityEClass = createEClass(CG_INFINITY);

		cgIntegerEClass = createEClass(CG_INTEGER);
		createEAttribute(cgIntegerEClass, CG_INTEGER__INTEGER_VALUE);

		cgInvalidEClass = createEClass(CG_INVALID);
		createEAttribute(cgInvalidEClass, CG_INVALID__MESSAGE_TEMPLATE);
		createEAttribute(cgInvalidEClass, CG_INVALID__BINDINGS);

		cgIsInvalidExpEClass = createEClass(CG_IS_INVALID_EXP);

		cgIsUndefinedExpEClass = createEClass(CG_IS_UNDEFINED_EXP);

		cgIterationCallExpEClass = createEClass(CG_ITERATION_CALL_EXP);
		createEAttribute(cgIterationCallExpEClass, CG_ITERATION_CALL_EXP__REFERRED_ITERATION);
		createEReference(cgIterationCallExpEClass, CG_ITERATION_CALL_EXP__ITERATORS);
		createEReference(cgIterationCallExpEClass, CG_ITERATION_CALL_EXP__BODY);

		cgIteratorEClass = createEClass(CG_ITERATOR);

		cgLetExpEClass = createEClass(CG_LET_EXP);
		createEReference(cgLetExpEClass, CG_LET_EXP__INIT);
		createEReference(cgLetExpEClass, CG_LET_EXP__IN);

		cgLibraryIterateCallExpEClass = createEClass(CG_LIBRARY_ITERATE_CALL_EXP);
		createEAttribute(cgLibraryIterateCallExpEClass, CG_LIBRARY_ITERATE_CALL_EXP__LIBRARY_ITERATION);
		createEReference(cgLibraryIterateCallExpEClass, CG_LIBRARY_ITERATE_CALL_EXP__RESULT);

		cgLibraryIterationCallExpEClass = createEClass(CG_LIBRARY_ITERATION_CALL_EXP);
		createEAttribute(cgLibraryIterationCallExpEClass, CG_LIBRARY_ITERATION_CALL_EXP__LIBRARY_ITERATION);

		cgLibraryOperationCallExpEClass = createEClass(CG_LIBRARY_OPERATION_CALL_EXP);
		createEAttribute(cgLibraryOperationCallExpEClass, CG_LIBRARY_OPERATION_CALL_EXP__LIBRARY_OPERATION);

		cgLibraryPropertyCallExpEClass = createEClass(CG_LIBRARY_PROPERTY_CALL_EXP);
		createEAttribute(cgLibraryPropertyCallExpEClass, CG_LIBRARY_PROPERTY_CALL_EXP__LIBRARY_PROPERTY);

		cgLocalVariableEClass = createEClass(CG_LOCAL_VARIABLE);

		cgModelEClass = createEClass(CG_MODEL);
		createEReference(cgModelEClass, CG_MODEL__GLOBALS);
		createEReference(cgModelEClass, CG_MODEL__PACKAGES);

		cgNamedElementEClass = createEClass(CG_NAMED_ELEMENT);
		createEAttribute(cgNamedElementEClass, CG_NAMED_ELEMENT__NAME);
		createEAttribute(cgNamedElementEClass, CG_NAMED_ELEMENT__PIVOT);

		cgNullEClass = createEClass(CG_NULL);

		cgOperationEClass = createEClass(CG_OPERATION);
		createEReference(cgOperationEClass, CG_OPERATION__PARAMETERS);
		createEReference(cgOperationEClass, CG_OPERATION__BODY);
		createEReference(cgOperationEClass, CG_OPERATION__PRECONDITIONS);
		createEReference(cgOperationEClass, CG_OPERATION__POSTCONDITIONS);
		createEReference(cgOperationEClass, CG_OPERATION__CONTAINING_CLASS);
		createEReference(cgOperationEClass, CG_OPERATION__EOPERATION);

		cgOperationCallExpEClass = createEClass(CG_OPERATION_CALL_EXP);
		createEReference(cgOperationCallExpEClass, CG_OPERATION_CALL_EXP__ARGUMENTS);
		createEAttribute(cgOperationCallExpEClass, CG_OPERATION_CALL_EXP__REFERRED_OPERATION);

		cgPackageEClass = createEClass(CG_PACKAGE);
		createEReference(cgPackageEClass, CG_PACKAGE__CLASSES);
		createEReference(cgPackageEClass, CG_PACKAGE__PACKAGES);
		createEReference(cgPackageEClass, CG_PACKAGE__CONTAINING_PACKAGE);

		cgParameterEClass = createEClass(CG_PARAMETER);
		createEReference(cgParameterEClass, CG_PARAMETER__OPERATION);

		cgPropertyEClass = createEClass(CG_PROPERTY);
		createEReference(cgPropertyEClass, CG_PROPERTY__CONTAINING_CLASS);
		createEReference(cgPropertyEClass, CG_PROPERTY__BODY);

		cgPropertyCallExpEClass = createEClass(CG_PROPERTY_CALL_EXP);
		createEAttribute(cgPropertyCallExpEClass, CG_PROPERTY_CALL_EXP__REFERRED_PROPERTY);

		cgRealEClass = createEClass(CG_REAL);
		createEAttribute(cgRealEClass, CG_REAL__REAL_VALUE);

		cgSettableVariableEClass = createEClass(CG_SETTABLE_VARIABLE);

		cgStringEClass = createEClass(CG_STRING);
		createEAttribute(cgStringEClass, CG_STRING__STRING_VALUE);

		cgTextEClass = createEClass(CG_TEXT);
		createEAttribute(cgTextEClass, CG_TEXT__TEXT_VALUE);

		cgTextParameterEClass = createEClass(CG_TEXT_PARAMETER);
		createEAttribute(cgTextParameterEClass, CG_TEXT_PARAMETER__TEXT_VALUE);

		cgThrowExpEClass = createEClass(CG_THROW_EXP);

		cgTupleExpEClass = createEClass(CG_TUPLE_EXP);
		createEReference(cgTupleExpEClass, CG_TUPLE_EXP__PARTS);

		cgTuplePartEClass = createEClass(CG_TUPLE_PART);
		createEReference(cgTuplePartEClass, CG_TUPLE_PART__INIT);
		createEReference(cgTuplePartEClass, CG_TUPLE_PART__TUPLE_EXP);

		cgTuplePartCallExpEClass = createEClass(CG_TUPLE_PART_CALL_EXP);
		createEAttribute(cgTuplePartCallExpEClass, CG_TUPLE_PART_CALL_EXP__PIVOT_TUPLE_PART_ID);

		cgTypeIdEClass = createEClass(CG_TYPE_ID);

		cgTypeExpEClass = createEClass(CG_TYPE_EXP);
		createEReference(cgTypeExpEClass, CG_TYPE_EXP__REFERRED_TYPE);

		cgTypedElementEClass = createEClass(CG_TYPED_ELEMENT);
		createEReference(cgTypedElementEClass, CG_TYPED_ELEMENT__TYPE_ID);
		createEAttribute(cgTypedElementEClass, CG_TYPED_ELEMENT__REQUIRED);

		cgUnboxExpEClass = createEClass(CG_UNBOX_EXP);

		cgValuedElementEClass = createEClass(CG_VALUED_ELEMENT);
		createEReference(cgValuedElementEClass, CG_VALUED_ELEMENT__DEPENDS_ON);

		cgVariableEClass = createEClass(CG_VARIABLE);
		createEReference(cgVariableEClass, CG_VARIABLE__INIT);

		cgVariableExpEClass = createEClass(CG_VARIABLE_EXP);
		createEReference(cgVariableExpEClass, CG_VARIABLE_EXP__REFERRED_VARIABLE);

		nameableEClass = createEClass(NAMEABLE);

		// Create data types
		elementIdEDataType = createEDataType(ELEMENT_ID);
		enumerationLiteralIdEDataType = createEDataType(ENUMERATION_LITERAL_ID);
		iterationEDataType = createEDataType(ITERATION);
		libraryIterationEDataType = createEDataType(LIBRARY_ITERATION);
		libraryOperationEDataType = createEDataType(LIBRARY_OPERATION);
		libraryPropertyEDataType = createEDataType(LIBRARY_PROPERTY);
		namedElementEDataType = createEDataType(NAMED_ELEMENT);
		numberEDataType = createEDataType(NUMBER);
		objectEDataType = createEDataType(OBJECT);
		operationEDataType = createEDataType(OPERATION);
		propertyEDataType = createEDataType(PROPERTY);
		tuplePartIdEDataType = createEDataType(TUPLE_PART_ID);
		typeIdEDataType = createEDataType(TYPE_ID);
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

		// Set bounds for type parameters

		// Add supertypes to classes
		cgBooleanEClass.getESuperTypes().add(this.getCGConstant());
		cgBoxExpEClass.getESuperTypes().add(this.getCGCallExp());
		cgBuiltInIterationCallExpEClass.getESuperTypes().add(this.getCGIterationCallExp());
		cgCallExpEClass.getESuperTypes().add(this.getCGValuedElement());
		cgCastParameterEClass.getESuperTypes().add(this.getCGParameter());
		cgCatchExpEClass.getESuperTypes().add(this.getCGCallExp());
		cgClassEClass.getESuperTypes().add(this.getCGNamedElement());
		cgCollectionExpEClass.getESuperTypes().add(this.getCGValuedElement());
		cgCollectionPartEClass.getESuperTypes().add(this.getCGValuedElement());
		cgConstantEClass.getESuperTypes().add(this.getCGValuedElement());
		cgConstantExpEClass.getESuperTypes().add(this.getCGValuedElement());
		cgConstraintEClass.getESuperTypes().add(this.getCGNamedElement());
		cgConstructorExpEClass.getESuperTypes().add(this.getCGValuedElement());
		cgConstructorPartEClass.getESuperTypes().add(this.getCGValuedElement());
		cgEcoreClassConstructorExpEClass.getESuperTypes().add(this.getCGConstructorExp());
		cgEcoreDataTypeConstructorExpEClass.getESuperTypes().add(this.getCGConstructorExp());
		cgEcoreOperationCallExpEClass.getESuperTypes().add(this.getCGOperationCallExp());
		cgEcorePropertyCallExpEClass.getESuperTypes().add(this.getCGPropertyCallExp());
		cgElementIdEClass.getESuperTypes().add(this.getCGConstant());
		cgEqualsExpEClass.getESuperTypes().add(this.getCGCallExp());
		cgExecutorCompositionPropertyEClass.getESuperTypes().add(this.getCGExecutorProperty());
		cgExecutorConstructorPartEClass.getESuperTypes().add(this.getCGExecutorProperty());
		cgExecutorNavigationPropertyEClass.getESuperTypes().add(this.getCGExecutorProperty());
		cgExecutorOppositePropertyEClass.getESuperTypes().add(this.getCGExecutorProperty());
		cgExecutorOperationEClass.getESuperTypes().add(this.getCGValuedElement());
		cgExecutorOperationCallExpEClass.getESuperTypes().add(this.getCGOperationCallExp());
		cgExecutorPropertyEClass.getESuperTypes().add(this.getCGValuedElement());
		cgExecutorPropertyCallExpEClass.getESuperTypes().add(this.getCGPropertyCallExp());
		cgExecutorTypeEClass.getESuperTypes().add(this.getCGValuedElement());
		cgFinalVariableEClass.getESuperTypes().add(this.getCGVariable());
		cgGuardExpEClass.getESuperTypes().add(this.getCGCallExp());
		cgIfExpEClass.getESuperTypes().add(this.getCGValuedElement());
		cgInfinityEClass.getESuperTypes().add(this.getCGConstant());
		cgIntegerEClass.getESuperTypes().add(this.getCGConstant());
		cgInvalidEClass.getESuperTypes().add(this.getCGConstant());
		cgIsInvalidExpEClass.getESuperTypes().add(this.getCGCallExp());
		cgIsUndefinedExpEClass.getESuperTypes().add(this.getCGCallExp());
		cgIterationCallExpEClass.getESuperTypes().add(this.getCGCallExp());
		cgIteratorEClass.getESuperTypes().add(this.getCGParameter());
		cgLetExpEClass.getESuperTypes().add(this.getCGValuedElement());
		cgLibraryIterateCallExpEClass.getESuperTypes().add(this.getCGIterationCallExp());
		cgLibraryIterationCallExpEClass.getESuperTypes().add(this.getCGIterationCallExp());
		cgLibraryOperationCallExpEClass.getESuperTypes().add(this.getCGOperationCallExp());
		cgLibraryPropertyCallExpEClass.getESuperTypes().add(this.getCGPropertyCallExp());
		cgLocalVariableEClass.getESuperTypes().add(this.getCGVariable());
		cgModelEClass.getESuperTypes().add(this.getCGNamedElement());
		cgNamedElementEClass.getESuperTypes().add(this.getCGElement());
		cgNamedElementEClass.getESuperTypes().add(this.getNameable());
		cgNullEClass.getESuperTypes().add(this.getCGConstant());
		cgOperationEClass.getESuperTypes().add(this.getCGValuedElement());
		cgOperationCallExpEClass.getESuperTypes().add(this.getCGCallExp());
		cgPackageEClass.getESuperTypes().add(this.getCGNamedElement());
		cgParameterEClass.getESuperTypes().add(this.getCGVariable());
		cgPropertyEClass.getESuperTypes().add(this.getCGValuedElement());
		cgPropertyCallExpEClass.getESuperTypes().add(this.getCGCallExp());
		cgRealEClass.getESuperTypes().add(this.getCGConstant());
		cgSettableVariableEClass.getESuperTypes().add(this.getCGVariable());
		cgStringEClass.getESuperTypes().add(this.getCGConstant());
		cgTextEClass.getESuperTypes().add(this.getCGConstant());
		cgTextParameterEClass.getESuperTypes().add(this.getCGParameter());
		cgThrowExpEClass.getESuperTypes().add(this.getCGCallExp());
		cgTupleExpEClass.getESuperTypes().add(this.getCGValuedElement());
		cgTuplePartEClass.getESuperTypes().add(this.getCGValuedElement());
		cgTuplePartCallExpEClass.getESuperTypes().add(this.getCGPropertyCallExp());
		cgTypeIdEClass.getESuperTypes().add(this.getCGElementId());
		cgTypeExpEClass.getESuperTypes().add(this.getCGValuedElement());
		cgTypedElementEClass.getESuperTypes().add(this.getCGNamedElement());
		cgUnboxExpEClass.getESuperTypes().add(this.getCGCallExp());
		cgValuedElementEClass.getESuperTypes().add(this.getCGTypedElement());
		cgVariableEClass.getESuperTypes().add(this.getCGValuedElement());
		cgVariableExpEClass.getESuperTypes().add(this.getCGValuedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(cgBooleanEClass, CGBoolean.class, "CGBoolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGBoolean_BooleanValue(), ecorePackage.getEBoolean(), "booleanValue", null, 1, 1, CGBoolean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgBoxExpEClass, CGBoxExp.class, "CGBoxExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgBuiltInIterationCallExpEClass, CGBuiltInIterationCallExp.class, "CGBuiltInIterationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGBuiltInIterationCallExp_Accumulator(), this.getCGIterator(), null, "accumulator", null, 0, 1, CGBuiltInIterationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgCallExpEClass, CGCallExp.class, "CGCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGCallExp_Invalidating(), ecorePackage.getEBoolean(), "invalidating", "false", 1, 1, CGCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCGCallExp_Validating(), ecorePackage.getEBoolean(), "validating", "false", 1, 1, CGCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGCallExp_Source(), this.getCGValuedElement(), null, "source", null, 0, 1, CGCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgCastParameterEClass, CGCastParameter.class, "CGCastParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGCastParameter_ReferredParameter(), this.getCGParameter(), null, "referredParameter", null, 1, 1, CGCastParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgCatchExpEClass, CGCatchExp.class, "CGCatchExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgClassEClass, CGClass.class, "CGClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGClass_ContainingPackage(), this.getCGPackage(), this.getCGPackage_Classes(), "containingPackage", null, 1, 1, CGClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGClass_Operations(), this.getCGOperation(), this.getCGOperation_ContainingClass(), "operations", null, 0, -1, CGClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCGClass_Properties(), this.getCGProperty(), this.getCGProperty_ContainingClass(), "properties", null, 0, -1, CGClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCGClass_Invariants(), this.getCGConstraint(), null, "invariants", null, 0, -1, CGClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cgCollectionExpEClass, CGCollectionExp.class, "CGCollectionExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGCollectionExp_Parts(), this.getCGCollectionPart(), this.getCGCollectionPart_CollectionExp(), "parts", null, 0, -1, CGCollectionExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgCollectionPartEClass, CGCollectionPart.class, "CGCollectionPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGCollectionPart_First(), this.getCGValuedElement(), null, "first", null, 1, 1, CGCollectionPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGCollectionPart_Last(), this.getCGValuedElement(), null, "last", null, 1, 1, CGCollectionPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGCollectionPart_CollectionExp(), this.getCGCollectionExp(), this.getCGCollectionExp_Parts(), "collectionExp", null, 1, 1, CGCollectionPart.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgConstantEClass, CGConstant.class, "CGConstant", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgConstantExpEClass, CGConstantExp.class, "CGConstantExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGConstantExp_ReferredConstant(), this.getCGValuedElement(), null, "referredConstant", null, 1, 1, CGConstantExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgConstraintEClass, CGConstraint.class, "CGConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGConstraint_Body(), this.getCGValuedElement(), null, "body", null, 0, 1, CGConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGConstraint_Message(), this.getCGValuedElement(), null, "message", null, 0, 1, CGConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgConstructorExpEClass, CGConstructorExp.class, "CGConstructorExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGConstructorExp_Parts(), this.getCGConstructorPart(), this.getCGConstructorPart_ConstructorExp(), "parts", null, 0, -1, CGConstructorExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgConstructorPartEClass, CGConstructorPart.class, "CGConstructorPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGConstructorPart_Init(), this.getCGValuedElement(), null, "init", null, 1, 1, CGConstructorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGConstructorPart_ConstructorExp(), this.getCGConstructorExp(), this.getCGConstructorExp_Parts(), "constructorExp", null, 1, 1, CGConstructorPart.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgEcoreClassConstructorExpEClass, CGEcoreClassConstructorExp.class, "CGEcoreClassConstructorExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGEcoreClassConstructorExp_EClass(), ecorePackage.getEClass(), null, "eClass", null, 1, 1, CGEcoreClassConstructorExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgEcoreDataTypeConstructorExpEClass, CGEcoreDataTypeConstructorExp.class, "CGEcoreDataTypeConstructorExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGEcoreDataTypeConstructorExp_EDataType(), ecorePackage.getEDataType(), null, "eDataType", null, 1, 1, CGEcoreDataTypeConstructorExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCGEcoreDataTypeConstructorExp_String(), ecorePackage.getEString(), "string", null, 1, 1, CGEcoreDataTypeConstructorExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgEcoreOperationCallExpEClass, CGEcoreOperationCallExp.class, "CGEcoreOperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGEcoreOperationCallExp_EOperation(), ecorePackage.getEOperation(), null, "eOperation", null, 1, 1, CGEcoreOperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgEcorePropertyCallExpEClass, CGEcorePropertyCallExp.class, "CGEcorePropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGEcorePropertyCallExp_EStructuralFeature(), ecorePackage.getEStructuralFeature(), null, "eStructuralFeature", null, 1, 1, CGEcorePropertyCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgElementEClass, CGElement.class, "CGElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgElementIdEClass, CGElementId.class, "CGElementId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGElementId_ElementId(), this.getElementId(), "elementId", null, 1, 1, CGElementId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgEqualsExpEClass, CGEqualsExp.class, "CGEqualsExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGEqualsExp_Argument(), this.getCGValuedElement(), null, "argument", null, 0, 1, CGEqualsExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgExecutorCompositionPropertyEClass, CGExecutorCompositionProperty.class, "CGExecutorCompositionProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgExecutorConstructorPartEClass, CGExecutorConstructorPart.class, "CGExecutorConstructorPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgExecutorNavigationPropertyEClass, CGExecutorNavigationProperty.class, "CGExecutorNavigationProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgExecutorOppositePropertyEClass, CGExecutorOppositeProperty.class, "CGExecutorOppositeProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgExecutorOperationEClass, CGExecutorOperation.class, "CGExecutorOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGExecutorOperation_UnderlyingOperationId(), this.getCGElementId(), null, "underlyingOperationId", null, 0, 1, CGExecutorOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgExecutorOperationCallExpEClass, CGExecutorOperationCallExp.class, "CGExecutorOperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGExecutorOperationCallExp_ExecutorOperation(), this.getCGExecutorOperation(), null, "executorOperation", null, 1, 1, CGExecutorOperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgExecutorPropertyEClass, CGExecutorProperty.class, "CGExecutorProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGExecutorProperty_UnderlyingPropertyId(), this.getCGElementId(), null, "underlyingPropertyId", null, 0, 1, CGExecutorProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgExecutorPropertyCallExpEClass, CGExecutorPropertyCallExp.class, "CGExecutorPropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGExecutorPropertyCallExp_ExecutorProperty(), this.getCGExecutorProperty(), null, "executorProperty", null, 1, 1, CGExecutorPropertyCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgExecutorTypeEClass, CGExecutorType.class, "CGExecutorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGExecutorType_UnderlyingTypeId(), this.getCGTypeId(), null, "underlyingTypeId", null, 0, 1, CGExecutorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgFinalVariableEClass, CGFinalVariable.class, "CGFinalVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgGuardExpEClass, CGGuardExp.class, "CGGuardExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgIfExpEClass, CGIfExp.class, "CGIfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGIfExp_Condition(), this.getCGValuedElement(), null, "condition", null, 1, 1, CGIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGIfExp_ThenExpression(), this.getCGValuedElement(), null, "thenExpression", null, 1, 1, CGIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGIfExp_ElseExpression(), this.getCGValuedElement(), null, "elseExpression", null, 1, 1, CGIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgInfinityEClass, CGInfinity.class, "CGInfinity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgIntegerEClass, CGInteger.class, "CGInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGInteger_IntegerValue(), this.getNumber(), "integerValue", null, 1, 1, CGInteger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgInvalidEClass, CGInvalid.class, "CGInvalid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGInvalid_MessageTemplate(), ecorePackage.getEString(), "messageTemplate", null, 0, 1, CGInvalid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCGInvalid_Bindings(), this.getObject(), "bindings", null, 0, -1, CGInvalid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgIsInvalidExpEClass, CGIsInvalidExp.class, "CGIsInvalidExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgIsUndefinedExpEClass, CGIsUndefinedExp.class, "CGIsUndefinedExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgIterationCallExpEClass, CGIterationCallExp.class, "CGIterationCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGIterationCallExp_ReferredIteration(), this.getIteration(), "referredIteration", null, 1, 1, CGIterationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGIterationCallExp_Iterators(), this.getCGIterator(), null, "iterators", null, 0, -1, CGIterationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGIterationCallExp_Body(), this.getCGValuedElement(), null, "body", null, 1, 1, CGIterationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgIteratorEClass, CGIterator.class, "CGIterator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgLetExpEClass, CGLetExp.class, "CGLetExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGLetExp_Init(), this.getCGVariable(), null, "init", null, 1, 1, CGLetExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGLetExp_In(), this.getCGValuedElement(), null, "in", null, 1, 1, CGLetExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgLibraryIterateCallExpEClass, CGLibraryIterateCallExp.class, "CGLibraryIterateCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGLibraryIterateCallExp_LibraryIteration(), this.getLibraryIteration(), "libraryIteration", null, 1, 1, CGLibraryIterateCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGLibraryIterateCallExp_Result(), this.getCGIterator(), null, "result", null, 0, 1, CGLibraryIterateCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgLibraryIterationCallExpEClass, CGLibraryIterationCallExp.class, "CGLibraryIterationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGLibraryIterationCallExp_LibraryIteration(), this.getLibraryIteration(), "libraryIteration", null, 1, 1, CGLibraryIterationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgLibraryOperationCallExpEClass, CGLibraryOperationCallExp.class, "CGLibraryOperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGLibraryOperationCallExp_LibraryOperation(), this.getLibraryOperation(), "libraryOperation", null, 1, 1, CGLibraryOperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgLibraryPropertyCallExpEClass, CGLibraryPropertyCallExp.class, "CGLibraryPropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGLibraryPropertyCallExp_LibraryProperty(), this.getLibraryProperty(), "libraryProperty", null, 1, 1, CGLibraryPropertyCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgLocalVariableEClass, CGLocalVariable.class, "CGLocalVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgModelEClass, CGModel.class, "CGModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGModel_Globals(), this.getCGConstant(), null, "globals", null, 0, -1, CGModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCGModel_Packages(), this.getCGPackage(), null, "packages", null, 0, -1, CGModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cgNamedElementEClass, CGNamedElement.class, "CGNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, CGNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCGNamedElement_Pivot(), this.getNamedElement(), "pivot", null, 1, 1, CGNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgNullEClass, CGNull.class, "CGNull", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgOperationEClass, CGOperation.class, "CGOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGOperation_Parameters(), this.getCGParameter(), null, "parameters", null, 0, -1, CGOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCGOperation_Body(), this.getCGValuedElement(), null, "body", null, 0, 1, CGOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGOperation_Preconditions(), this.getCGConstraint(), null, "preconditions", null, 0, -1, CGOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCGOperation_Postconditions(), this.getCGConstraint(), null, "postconditions", null, 0, -1, CGOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCGOperation_ContainingClass(), this.getCGClass(), this.getCGClass_Operations(), "containingClass", null, 1, 1, CGOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGOperation_EOperation(), ecorePackage.getEOperation(), null, "eOperation", null, 0, 1, CGOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgOperationCallExpEClass, CGOperationCallExp.class, "CGOperationCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGOperationCallExp_Arguments(), this.getCGValuedElement(), null, "arguments", null, 0, -1, CGOperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCGOperationCallExp_ReferredOperation(), this.getOperation(), "referredOperation", null, 1, 1, CGOperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgPackageEClass, CGPackage.class, "CGPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGPackage_Classes(), this.getCGClass(), this.getCGClass_ContainingPackage(), "classes", null, 0, -1, CGPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCGPackage_Packages(), this.getCGPackage(), this.getCGPackage_ContainingPackage(), "packages", null, 0, -1, CGPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCGPackage_ContainingPackage(), this.getCGPackage(), this.getCGPackage_Packages(), "containingPackage", null, 0, 1, CGPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgParameterEClass, CGParameter.class, "CGParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGParameter_Operation(), this.getCGOperation(), null, "operation", null, 1, 1, CGParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgPropertyEClass, CGProperty.class, "CGProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGProperty_ContainingClass(), this.getCGClass(), this.getCGClass_Properties(), "containingClass", null, 1, 1, CGProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGProperty_Body(), this.getCGValuedElement(), null, "body", null, 0, 1, CGProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgPropertyCallExpEClass, CGPropertyCallExp.class, "CGPropertyCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGPropertyCallExp_ReferredProperty(), this.getProperty(), "referredProperty", null, 1, 1, CGPropertyCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgRealEClass, CGReal.class, "CGReal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGReal_RealValue(), this.getNumber(), "realValue", null, 1, 1, CGReal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgSettableVariableEClass, CGSettableVariable.class, "CGSettableVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgStringEClass, CGString.class, "CGString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGString_StringValue(), ecorePackage.getEString(), "stringValue", null, 1, 1, CGString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgTextEClass, CGText.class, "CGText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGText_TextValue(), ecorePackage.getEString(), "textValue", null, 1, 1, CGText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgTextParameterEClass, CGTextParameter.class, "CGTextParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGTextParameter_TextValue(), ecorePackage.getEString(), "textValue", null, 1, 1, CGTextParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgThrowExpEClass, CGThrowExp.class, "CGThrowExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgTupleExpEClass, CGTupleExp.class, "CGTupleExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGTupleExp_Parts(), this.getCGTuplePart(), this.getCGTuplePart_TupleExp(), "parts", null, 0, -1, CGTupleExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgTuplePartEClass, CGTuplePart.class, "CGTuplePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGTuplePart_Init(), this.getCGValuedElement(), null, "init", null, 1, 1, CGTuplePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGTuplePart_TupleExp(), this.getCGTupleExp(), this.getCGTupleExp_Parts(), "tupleExp", null, 1, 1, CGTuplePart.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgTuplePartCallExpEClass, CGTuplePartCallExp.class, "CGTuplePartCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGTuplePartCallExp_PivotTuplePartId(), this.getTuplePartId(), "pivotTuplePartId", null, 1, 1, CGTuplePartCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgTypeIdEClass, CGTypeId.class, "CGTypeId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgTypeExpEClass, CGTypeExp.class, "CGTypeExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGTypeExp_ReferredType(), this.getCGExecutorType(), null, "referredType", null, 1, 1, CGTypeExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgTypedElementEClass, CGTypedElement.class, "CGTypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGTypedElement_TypeId(), this.getCGTypeId(), null, "typeId", null, 1, 1, CGTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCGTypedElement_Required(), ecorePackage.getEBoolean(), "required", "false", 1, 1, CGTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgUnboxExpEClass, CGUnboxExp.class, "CGUnboxExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgValuedElementEClass, CGValuedElement.class, "CGValuedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGValuedElement_DependsOn(), this.getCGValuedElement(), null, "dependsOn", null, 0, -1, CGValuedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgVariableEClass, CGVariable.class, "CGVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGVariable_Init(), this.getCGValuedElement(), null, "init", null, 0, 1, CGVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgVariableExpEClass, CGVariableExp.class, "CGVariableExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGVariableExp_ReferredVariable(), this.getCGVariable(), null, "referredVariable", null, 1, 1, CGVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameableEClass, Nameable.class, "Nameable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(elementIdEDataType, ElementId.class, "ElementId", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(enumerationLiteralIdEDataType, EnumerationLiteralId.class, "EnumerationLiteralId", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iterationEDataType, Iteration.class, "Iteration", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(libraryIterationEDataType, LibraryIteration.class, "LibraryIteration", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(libraryOperationEDataType, LibraryOperation.class, "LibraryOperation", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(libraryPropertyEDataType, LibraryProperty.class, "LibraryProperty", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(namedElementEDataType, NamedElement.class, "NamedElement", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(numberEDataType, Number.class, "Number", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(objectEDataType, Object.class, "Object", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(operationEDataType, Operation.class, "Operation", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(propertyEDataType, Property.class, "Property", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tuplePartIdEDataType, TuplePartId.class, "TuplePartId", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeIdEDataType, TypeId.class, "TypeId", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore#/"
		   });	
	}

} //CGModelPackageImpl
