/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.xtext.base.basecs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' pivot='../../org.eclipse.ocl.examples.pivot/model/Pivot.ecore#/'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface BaseCSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "basecs"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/BaseCST"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "basecs"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BaseCSPackage eINSTANCE = org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS <em>Visitable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getVisitableCS()
	 * @generated
	 */
	int VISITABLE_CS = 52;

	/**
	 * The number of structural features of the '<em>Visitable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_CS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ElementCSImpl <em>Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getElementCS()
	 * @generated
	 */
	int ELEMENT_CS = 10;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CS__LOGICAL_PARENT = VISITABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CS_FEATURE_COUNT = VISITABLE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PivotableElementCSImpl <em>Pivotable Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PivotableElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPivotableElementCS()
	 * @generated
	 */
	int PIVOTABLE_ELEMENT_CS = 32;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIVOTABLE_ELEMENT_CS__LOGICAL_PARENT = ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIVOTABLE_ELEMENT_CS__PIVOT = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pivotable Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIVOTABLE_ELEMENT_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ModelElementCSImpl <em>Model Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ModelElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getModelElementCS()
	 * @generated
	 */
	int MODEL_ELEMENT_CS = 18;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__LOGICAL_PARENT = PIVOTABLE_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__PIVOT = PIVOTABLE_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__OWNED_ANNOTATION = PIVOTABLE_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__ORIGINAL_XMI_ID = PIVOTABLE_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS__CSI = PIVOTABLE_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_CS_FEATURE_COUNT = PIVOTABLE_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.AnnotationElementCSImpl <em>Annotation Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.AnnotationElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getAnnotationElementCS()
	 * @generated
	 */
	int ANNOTATION_ELEMENT_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.DetailCSImpl <em>Detail CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.DetailCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getDetailCS()
	 * @generated
	 */
	int DETAIL_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ImportCSImpl <em>Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ImportCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getImportCS()
	 * @generated
	 */
	int IMPORT_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.NamedElementCSImpl <em>Named Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.NamedElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getNamedElementCS()
	 * @generated
	 */
	int NAMED_ELEMENT_CS = 23;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__LOGICAL_PARENT = MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__CSI = MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__NAME = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__LOGICAL_PARENT = NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ClassifierCSImpl <em>Classifier CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ClassifierCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getClassifierCS()
	 * @generated
	 */
	int CLASSIFIER_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedElementCSImpl <em>Typed Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypedElementCS()
	 * @generated
	 */
	int TYPED_ELEMENT_CS = 49;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.FeatureCS <em>Feature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.FeatureCS
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getFeatureCS()
	 * @generated
	 */
	int FEATURE_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.StructuralFeatureCSImpl <em>Structural Feature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.StructuralFeatureCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getStructuralFeatureCS()
	 * @generated
	 */
	int STRUCTURAL_FEATURE_CS = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.AttributeCSImpl <em>Attribute CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.AttributeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getAttributeCS()
	 * @generated
	 */
	int ATTRIBUTE_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ClassCSImpl <em>Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ClassCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getClassCS()
	 * @generated
	 */
	int CLASS_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.LibraryCSImpl <em>Library CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.LibraryCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getLibraryCS()
	 * @generated
	 */
	int LIBRARY_CS = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.NamespaceCS <em>Namespace CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.NamespaceCS
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getNamespaceCS()
	 * @generated
	 */
	int NAMESPACE_CS = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl <em>Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getOperationCS()
	 * @generated
	 */
	int OPERATION_CS = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PackageCSImpl <em>Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PackageCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPackageCS()
	 * @generated
	 */
	int PACKAGE_CS = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ParameterCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getParameterCS()
	 * @generated
	 */
	int PARAMETER_CS = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PrimitiveTypeRefCSImpl <em>Primitive Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PrimitiveTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPrimitiveTypeRefCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_REF_CS = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ReferenceCSImpl <em>Reference CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ReferenceCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getReferenceCS()
	 * @generated
	 */
	int REFERENCE_CS = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypeCS <em>Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypeCS
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypeCS()
	 * @generated
	 */
	int TYPE_CS = 46;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypeParameterCSImpl <em>Type Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TypeParameterCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypeParameterCS()
	 * @generated
	 */
	int TYPE_PARAMETER_CS = 47;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedTypeRefCSImpl <em>Typed Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypedTypeRefCS()
	 * @generated
	 */
	int TYPED_TYPE_REF_CS = 51;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.WildcardTypeRefCSImpl <em>Wildcard Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.WildcardTypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getWildcardTypeRefCS()
	 * @generated
	 */
	int WILDCARD_TYPE_REF_CS = 53;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypeRefCSImpl <em>Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TypeRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypeRefCS()
	 * @generated
	 */
	int TYPE_REF_CS = 48;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedRefCSImpl <em>Typed Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypedRefCS()
	 * @generated
	 */
	int TYPED_REF_CS = 50;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.AnnotationCSImpl <em>Annotation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.AnnotationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getAnnotationCS()
	 * @generated
	 */
	int ANNOTATION_CS = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateBindingCSImpl <em>Template Binding CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateBindingCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTemplateBindingCS()
	 * @generated
	 */
	int TEMPLATE_BINDING_CS = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateParameterCSImpl <em>Template Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateParameterCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTemplateParameterCS()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_CS = 40;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateParameterSubstitutionCSImpl <em>Template Parameter Substitution CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateParameterSubstitutionCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTemplateParameterSubstitutionCS()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS = 41;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateSignatureCSImpl <em>Template Signature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateSignatureCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTemplateSignatureCS()
	 * @generated
	 */
	int TEMPLATE_SIGNATURE_CS = 42;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS <em>Templateable Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTemplateableElementCS()
	 * @generated
	 */
	int TEMPLATEABLE_ELEMENT_CS = 43;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ConstraintCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getConstraintCS()
	 * @generated
	 */
	int CONSTRAINT_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.DataTypeCSImpl <em>Data Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.DataTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getDataTypeCS()
	 * @generated
	 */
	int DATA_TYPE_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.DocumentationCSImpl <em>Documentation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.DocumentationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getDocumentationCS()
	 * @generated
	 */
	int DOCUMENTATION_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.EnumerationCSImpl <em>Enumeration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.EnumerationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getEnumerationCS()
	 * @generated
	 */
	int ENUMERATION_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.EnumerationLiteralCSImpl <em>Enumeration Literal CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.EnumerationLiteralCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getEnumerationLiteralCS()
	 * @generated
	 */
	int ENUMERATION_LITERAL_CS = 13;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__CSI = NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS__OWNED_DETAIL = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotation Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ELEMENT_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__LOGICAL_PARENT = ANNOTATION_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__PIVOT = ANNOTATION_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__OWNED_ANNOTATION = ANNOTATION_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__ORIGINAL_XMI_ID = ANNOTATION_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__CSI = ANNOTATION_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__NAME = ANNOTATION_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__OWNED_DETAIL = ANNOTATION_ELEMENT_CS__OWNED_DETAIL;

	/**
	 * The feature id for the '<em><b>Owned Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__OWNED_CONTENT = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS__OWNED_REFERENCE = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Annotation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_CS_FEATURE_COUNT = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__LOGICAL_PARENT = NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__CSI = NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__OWNED_TYPE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__QUALIFIER = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS__OPTIONAL = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Typed Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__LOGICAL_PARENT = TYPED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__PIVOT = TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__OWNED_ANNOTATION = TYPED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__ORIGINAL_XMI_ID = TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__CSI = TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__NAME = TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__OWNED_TYPE = TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__QUALIFIER = TYPED_ELEMENT_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS__OPTIONAL = TYPED_ELEMENT_CS__OPTIONAL;

	/**
	 * The number of structural features of the '<em>Feature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CS_FEATURE_COUNT = TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__LOGICAL_PARENT = FEATURE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__PIVOT = FEATURE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__OWNED_ANNOTATION = FEATURE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID = FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__CSI = FEATURE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__NAME = FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__OWNED_TYPE = FEATURE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__QUALIFIER = FEATURE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__OPTIONAL = FEATURE_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__OWNER = FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__DEFAULT = FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Default Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSION = FEATURE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Structural Feature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_CS_FEATURE_COUNT = FEATURE_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__LOGICAL_PARENT = STRUCTURAL_FEATURE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__PIVOT = STRUCTURAL_FEATURE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__OWNED_ANNOTATION = STRUCTURAL_FEATURE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__ORIGINAL_XMI_ID = STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__CSI = STRUCTURAL_FEATURE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__NAME = STRUCTURAL_FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__OWNED_TYPE = STRUCTURAL_FEATURE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__QUALIFIER = STRUCTURAL_FEATURE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__OPTIONAL = STRUCTURAL_FEATURE_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__OWNER = STRUCTURAL_FEATURE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__DEFAULT = STRUCTURAL_FEATURE_CS__DEFAULT;

	/**
	 * The feature id for the '<em><b>Owned Default Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS__OWNED_DEFAULT_EXPRESSION = STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Attribute CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CS_FEATURE_COUNT = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__LOGICAL_PARENT = NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__CSI = NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__OWNER = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__INSTANCE_CLASS_NAME = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__OWNED_CONSTRAINT = NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS__QUALIFIER = NAMED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Classifier CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__LOGICAL_PARENT = CLASSIFIER_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__PIVOT = CLASSIFIER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_ANNOTATION = CLASSIFIER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__ORIGINAL_XMI_ID = CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__CSI = CLASSIFIER_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__NAME = CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_TEMPLATE_SIGNATURE = CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNER = CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__INSTANCE_CLASS_NAME = CLASSIFIER_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_CONSTRAINT = CLASSIFIER_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__QUALIFIER = CLASSIFIER_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Super Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_SUPER_TYPE = CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_OPERATION = CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_PROPERTY = CLASSIFIER_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Meta Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OWNED_META_TYPE = CLASSIFIER_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS_FEATURE_COUNT = CLASSIFIER_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ElementRefCSImpl <em>Element Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ElementRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getElementRefCS()
	 * @generated
	 */
	int ELEMENT_REF_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.LambdaTypeCSImpl <em>Lambda Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.LambdaTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getLambdaTypeCS()
	 * @generated
	 */
	int LAMBDA_TYPE_CS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ModelElementRefCSImpl <em>Model Element Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ModelElementRefCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getModelElementRefCS()
	 * @generated
	 */
	int MODEL_ELEMENT_REF_CS = 19;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__LOGICAL_PARENT = NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__CSI = NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__STEREOTYPE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__SPECIFICATION = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__MESSAGE_SPECIFICATION = NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ContextLessElementCSImpl <em>Context Less Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ContextLessElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getContextLessElementCS()
	 * @generated
	 */
	int CONTEXT_LESS_ELEMENT_CS = 6;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_LESS_ELEMENT_CS__LOGICAL_PARENT = ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The number of structural features of the '<em>Context Less Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__LOGICAL_PARENT = CLASSIFIER_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__PIVOT = CLASSIFIER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__OWNED_ANNOTATION = CLASSIFIER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__ORIGINAL_XMI_ID = CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__CSI = CLASSIFIER_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__NAME = CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__OWNED_TEMPLATE_SIGNATURE = CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__OWNER = CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__INSTANCE_CLASS_NAME = CLASSIFIER_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__OWNED_CONSTRAINT = CLASSIFIER_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__QUALIFIER = CLASSIFIER_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS__LITERALS = CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_CS_FEATURE_COUNT = CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__LOGICAL_PARENT = NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__CSI = NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS__VALUE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Detail CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__LOGICAL_PARENT = ANNOTATION_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__PIVOT = ANNOTATION_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__OWNED_ANNOTATION = ANNOTATION_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__ORIGINAL_XMI_ID = ANNOTATION_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__CSI = ANNOTATION_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__NAME = ANNOTATION_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__OWNED_DETAIL = ANNOTATION_ELEMENT_CS__OWNED_DETAIL;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS__VALUE = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Documentation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_CS_FEATURE_COUNT = ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REF_CS__LOGICAL_PARENT = PIVOTABLE_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REF_CS__PIVOT = PIVOTABLE_ELEMENT_CS__PIVOT;

	/**
	 * The number of structural features of the '<em>Element Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REF_CS_FEATURE_COUNT = PIVOTABLE_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__LOGICAL_PARENT = CLASSIFIER_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__PIVOT = CLASSIFIER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__OWNED_ANNOTATION = CLASSIFIER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__ORIGINAL_XMI_ID = CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__CSI = CLASSIFIER_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__NAME = CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__OWNED_TEMPLATE_SIGNATURE = CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__OWNER = CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__INSTANCE_CLASS_NAME = CLASSIFIER_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__OWNED_CONSTRAINT = CLASSIFIER_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__QUALIFIER = CLASSIFIER_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS__OWNED_LITERALS = CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CS_FEATURE_COUNT = CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__LOGICAL_PARENT = NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__CSI = NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS__VALUE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Literal CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__LOGICAL_PARENT = NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__CSI = NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The number of structural features of the '<em>Namespace CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__LOGICAL_PARENT = NAMESPACE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__PIVOT = NAMESPACE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__OWNED_ANNOTATION = NAMESPACE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__ORIGINAL_XMI_ID = NAMESPACE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__CSI = NAMESPACE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__NAME = NAMESPACE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__PATH_NAME = NAMESPACE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__NAMESPACE = NAMESPACE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS__ALL = NAMESPACE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Import CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_CS_FEATURE_COUNT = NAMESPACE_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS__LOGICAL_PARENT = ELEMENT_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS__PIVOT = ELEMENT_REF_CS__PIVOT;

	/**
	 * The number of structural features of the '<em>Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_CS_FEATURE_COUNT = ELEMENT_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS__LOGICAL_PARENT = TYPE_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS__PIVOT = TYPE_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS__MULTIPLICITY = TYPE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_REF_CS_FEATURE_COUNT = TYPE_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityCS <em>Multiplicity CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityCS
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getMultiplicityCS()
	 * @generated
	 */
	int MULTIPLICITY_CS = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.MultiplicityBoundsCSImpl <em>Multiplicity Bounds CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.MultiplicityBoundsCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getMultiplicityBoundsCS()
	 * @generated
	 */
	int MULTIPLICITY_BOUNDS_CS = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.MultiplicityStringCSImpl <em>Multiplicity String CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.MultiplicityStringCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getMultiplicityStringCS()
	 * @generated
	 */
	int MULTIPLICITY_STRING_CS = 22;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE_CS__LOGICAL_PARENT = TYPED_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE_CS__PIVOT = TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE_CS__MULTIPLICITY = TYPED_REF_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE_CS__OWNED_TEMPLATE_SIGNATURE = TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE_CS__NAME = TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Context Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE_CS__OWNED_CONTEXT_TYPE = TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Parameter Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE_CS__OWNED_PARAMETER_TYPE = TYPED_REF_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Result Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE_CS__OWNED_RESULT_TYPE = TYPED_REF_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Lambda Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAMBDA_TYPE_CS_FEATURE_COUNT = TYPED_REF_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__LOGICAL_PARENT = NAMESPACE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__PIVOT = NAMESPACE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__OWNED_ANNOTATION = NAMESPACE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__ORIGINAL_XMI_ID = NAMESPACE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__CSI = NAMESPACE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__NAME = NAMESPACE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS__PACKAGE = NAMESPACE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Library CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_CS_FEATURE_COUNT = NAMESPACE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REF_CS__LOGICAL_PARENT = ELEMENT_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REF_CS__PIVOT = ELEMENT_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REF_CS__PATH_NAME = ELEMENT_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REF_CS__ELEMENT = ELEMENT_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Element Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REF_CS_FEATURE_COUNT = ELEMENT_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_CS__LOGICAL_PARENT = ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The number of structural features of the '<em>Multiplicity CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_BOUNDS_CS__LOGICAL_PARENT = MULTIPLICITY_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_BOUNDS_CS__LOWER_BOUND = MULTIPLICITY_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_BOUNDS_CS__UPPER_BOUND = MULTIPLICITY_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multiplicity Bounds CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_BOUNDS_CS_FEATURE_COUNT = MULTIPLICITY_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_STRING_CS__LOGICAL_PARENT = MULTIPLICITY_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>String Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_STRING_CS__STRING_BOUNDS = MULTIPLICITY_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multiplicity String CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_STRING_CS_FEATURE_COUNT = MULTIPLICITY_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__LOGICAL_PARENT = FEATURE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__PIVOT = FEATURE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_ANNOTATION = FEATURE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__ORIGINAL_XMI_ID = FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__CSI = FEATURE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__NAME = FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_TYPE = FEATURE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__QUALIFIER = FEATURE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OPTIONAL = FEATURE_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_TEMPLATE_SIGNATURE = FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNING_CLASS = FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_PARAMETER = FEATURE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Exception</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_EXCEPTION = FEATURE_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Precondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_PRECONDITION = FEATURE_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owned Postcondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_POSTCONDITION = FEATURE_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Owned Body Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__OWNED_BODY_EXPRESSION = FEATURE_CS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS_FEATURE_COUNT = FEATURE_CS_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PackageOwnerCSImpl <em>Package Owner CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PackageOwnerCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPackageOwnerCS()
	 * @generated
	 */
	int PACKAGE_OWNER_CS = 27;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OWNER_CS__LOGICAL_PARENT = MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OWNER_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OWNER_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OWNER_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OWNER_CS__CSI = MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OWNER_CS__OWNED_NESTED_PACKAGE = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Package Owner CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OWNER_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__LOGICAL_PARENT = PACKAGE_OWNER_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__PIVOT = PACKAGE_OWNER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__OWNED_ANNOTATION = PACKAGE_OWNER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__ORIGINAL_XMI_ID = PACKAGE_OWNER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__CSI = PACKAGE_OWNER_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__OWNED_NESTED_PACKAGE = PACKAGE_OWNER_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__NAME = PACKAGE_OWNER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__OWNED_TYPE = PACKAGE_OWNER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__NS_PREFIX = PACKAGE_OWNER_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__NS_URI = PACKAGE_OWNER_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS_FEATURE_COUNT = PACKAGE_OWNER_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__LOGICAL_PARENT = TYPED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__PIVOT = TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__OWNED_ANNOTATION = TYPED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__ORIGINAL_XMI_ID = TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__CSI = TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__NAME = TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__OWNED_TYPE = TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__QUALIFIER = TYPED_ELEMENT_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__OPTIONAL = TYPED_ELEMENT_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__OWNER = TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS_FEATURE_COUNT = TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathElementCSImpl <em>Path Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PathElementCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPathElementCS()
	 * @generated
	 */
	int PATH_ELEMENT_CS = 29;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS__LOGICAL_PARENT = ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS__PATH_NAME = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS__ELEMENT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS__ELEMENT_TYPE = ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Path Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathElementWithURICSImpl <em>Path Element With URICS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PathElementWithURICSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPathElementWithURICS()
	 * @generated
	 */
	int PATH_ELEMENT_WITH_URICS = 30;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_WITH_URICS__LOGICAL_PARENT = PATH_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_WITH_URICS__PATH_NAME = PATH_ELEMENT_CS__PATH_NAME;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_WITH_URICS__ELEMENT = PATH_ELEMENT_CS__ELEMENT;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_WITH_URICS__ELEMENT_TYPE = PATH_ELEMENT_CS__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_WITH_URICS__URI = PATH_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Element With URICS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_WITH_URICS_FEATURE_COUNT = PATH_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PathNameCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPathNameCS()
	 * @generated
	 */
	int PATH_NAME_CS = 31;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS__LOGICAL_PARENT = ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS__PATH = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS__ELEMENT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS__CONTEXT = ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scope Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS__SCOPE_FILTER = ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Path Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__LOGICAL_PARENT = TYPED_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__PIVOT = TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__MULTIPLICITY = TYPED_REF_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS__NAME = TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_REF_CS_FEATURE_COUNT = TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__LOGICAL_PARENT = STRUCTURAL_FEATURE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__PIVOT = STRUCTURAL_FEATURE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OWNED_ANNOTATION = STRUCTURAL_FEATURE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__ORIGINAL_XMI_ID = STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__CSI = STRUCTURAL_FEATURE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__NAME = STRUCTURAL_FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OWNED_TYPE = STRUCTURAL_FEATURE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__QUALIFIER = STRUCTURAL_FEATURE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OPTIONAL = STRUCTURAL_FEATURE_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OWNER = STRUCTURAL_FEATURE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__DEFAULT = STRUCTURAL_FEATURE_CS__DEFAULT;

	/**
	 * The feature id for the '<em><b>Owned Default Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OWNED_DEFAULT_EXPRESSION = STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__OPPOSITE = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS__KEYS = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CS_FEATURE_COUNT = STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.RootCS <em>Root CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.RootCS
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getRootCS()
	 * @generated
	 */
	int ROOT_CS = 35;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__LOGICAL_PARENT = MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__CSI = MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owned Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__OWNED_IMPORT = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__OWNED_LIBRARY = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Root CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.RootPackageCSImpl <em>Root Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.RootPackageCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getRootPackageCS()
	 * @generated
	 */
	int ROOT_PACKAGE_CS = 36;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__LOGICAL_PARENT = PACKAGE_OWNER_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__PIVOT = PACKAGE_OWNER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__OWNED_ANNOTATION = PACKAGE_OWNER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__ORIGINAL_XMI_ID = PACKAGE_OWNER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__CSI = PACKAGE_OWNER_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__OWNED_NESTED_PACKAGE = PACKAGE_OWNER_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__OWNED_IMPORT = PACKAGE_OWNER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS__OWNED_LIBRARY = PACKAGE_OWNER_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Root Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_PACKAGE_CS_FEATURE_COUNT = PACKAGE_OWNER_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.SpecificationCSImpl <em>Specification CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.SpecificationCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getSpecificationCS()
	 * @generated
	 */
	int SPECIFICATION_CS = 37;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_CS__LOGICAL_PARENT = MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_CS__CSI = MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Expr String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_CS__EXPR_STRING = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specification CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS__LOGICAL_PARENT = ELEMENT_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS__PIVOT = ELEMENT_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owning Template Bindable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT = ELEMENT_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Parameter Substitution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION = ELEMENT_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Binding CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_BINDING_CS_FEATURE_COUNT = ELEMENT_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__LOGICAL_PARENT = NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__PIVOT = NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__OWNED_ANNOTATION = NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__ORIGINAL_XMI_ID = NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__CSI = NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owning Template Signature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template Parameter CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__LOGICAL_PARENT = MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__CSI = MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owning Template Binding</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNING_TEMPLATE_BINDING = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Actual Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Parameter Substitution CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__LOGICAL_PARENT = MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__CSI = MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owning Template Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Template Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER = MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Signature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_CS__LOGICAL_PARENT = ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Templateable Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATEABLE_ELEMENT_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TuplePartCSImpl <em>Tuple Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TuplePartCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTuplePartCS()
	 * @generated
	 */
	int TUPLE_PART_CS = 44;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__LOGICAL_PARENT = TYPED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__PIVOT = TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__OWNED_ANNOTATION = TYPED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__ORIGINAL_XMI_ID = TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__CSI = TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__NAME = TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__OWNED_TYPE = TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__QUALIFIER = TYPED_ELEMENT_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS__OPTIONAL = TYPED_ELEMENT_CS__OPTIONAL;

	/**
	 * The number of structural features of the '<em>Tuple Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_CS_FEATURE_COUNT = TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TupleTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTupleTypeCS()
	 * @generated
	 */
	int TUPLE_TYPE_CS = 45;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__LOGICAL_PARENT = TYPED_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__PIVOT = TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__MULTIPLICITY = TYPED_REF_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__NAME = TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__OWNED_PARTS = TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tuple Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS_FEATURE_COUNT = TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__LOGICAL_PARENT = MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__PIVOT = MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__OWNED_ANNOTATION = MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__ORIGINAL_XMI_ID = MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS__CSI = MODEL_ELEMENT_CS__CSI;

	/**
	 * The number of structural features of the '<em>Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS_FEATURE_COUNT = MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__LOGICAL_PARENT = TEMPLATE_PARAMETER_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__PIVOT = TEMPLATE_PARAMETER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__OWNED_ANNOTATION = TEMPLATE_PARAMETER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__ORIGINAL_XMI_ID = TEMPLATE_PARAMETER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__CSI = TEMPLATE_PARAMETER_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__NAME = TEMPLATE_PARAMETER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owning Template Signature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE = TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owned Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__OWNED_EXTENDS = TEMPLATE_PARAMETER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS__OWNED_SUPER = TEMPLATE_PARAMETER_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Parameter CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_CS_FEATURE_COUNT = TEMPLATE_PARAMETER_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__LOGICAL_PARENT = TYPED_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__PIVOT = TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__MULTIPLICITY = TYPED_REF_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__PATH_NAME = TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__TYPE = TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Template Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING = TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Typed Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TYPE_REF_CS_FEATURE_COUNT = TYPED_REF_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__LOGICAL_PARENT = TYPE_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__PIVOT = TYPE_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__EXTENDS = TYPE_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS__SUPER = TYPE_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Wildcard Type Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_TYPE_REF_CS_FEATURE_COUNT = TYPE_REF_CS_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.IteratorKind <em>Iterator Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.IteratorKind
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getIteratorKind()
	 * @generated
	 */
	int ITERATOR_KIND = 54;


	/**
	 * The meta object id for the '<em>Scope Filter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.scoping.ScopeFilter
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getScopeFilter()
	 * @generated
	 */
	int SCOPE_FILTER = 55;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS <em>Annotation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS
	 * @generated
	 */
	EClass getAnnotationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS#getOwnedContent <em>Owned Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Content</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS#getOwnedContent()
	 * @see #getAnnotationCS()
	 * @generated
	 */
	EReference getAnnotationCS_OwnedContent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS#getOwnedReference <em>Owned Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Reference</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS#getOwnedReference()
	 * @see #getAnnotationCS()
	 * @generated
	 */
	EReference getAnnotationCS_OwnedReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS <em>Annotation Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS
	 * @generated
	 */
	EClass getAnnotationElementCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS#getOwnedDetail <em>Owned Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Detail</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS#getOwnedDetail()
	 * @see #getAnnotationElementCS()
	 * @generated
	 */
	EReference getAnnotationElementCS_OwnedDetail();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.AttributeCS <em>Attribute CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.AttributeCS
	 * @generated
	 */
	EClass getAttributeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassCS <em>Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassCS
	 * @generated
	 */
	EClass getClassCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassCS#getOwnedSuperType <em>Owned Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Super Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassCS#getOwnedSuperType()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_OwnedSuperType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassCS#getOwnedOperation <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassCS#getOwnedOperation()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_OwnedOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassCS#getOwnedProperty <em>Owned Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Property</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassCS#getOwnedProperty()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_OwnedProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassCS#getOwnedMetaType <em>Owned Meta Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Meta Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassCS#getOwnedMetaType()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_OwnedMetaType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS <em>Classifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS
	 * @generated
	 */
	EClass getClassifierCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS#getOwner()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EReference getClassifierCS_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS#getInstanceClassName <em>Instance Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Class Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS#getInstanceClassName()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EAttribute getClassifierCS_InstanceClassName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS#getOwnedConstraint <em>Owned Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Constraint</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS#getOwnedConstraint()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EReference getClassifierCS_OwnedConstraint();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS#getQualifier <em>Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifier</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS#getQualifier()
	 * @see #getClassifierCS()
	 * @generated
	 */
	EAttribute getClassifierCS_Qualifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS <em>Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS
	 * @generated
	 */
	EClass getConstraintCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS#getStereotype()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EAttribute getConstraintCS_Stereotype();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS#getSpecification()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EReference getConstraintCS_Specification();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS#getMessageSpecification <em>Message Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Message Specification</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS#getMessageSpecification()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EReference getConstraintCS_MessageSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ContextLessElementCS <em>Context Less Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Less Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ContextLessElementCS
	 * @generated
	 */
	EClass getContextLessElementCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS <em>Data Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS
	 * @generated
	 */
	EClass getDataTypeCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS#getLiterals()
	 * @see #getDataTypeCS()
	 * @generated
	 */
	EReference getDataTypeCS_Literals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.DetailCS <em>Detail CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detail CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.DetailCS
	 * @generated
	 */
	EClass getDetailCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.base.basecs.DetailCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.DetailCS#getValue()
	 * @see #getDetailCS()
	 * @generated
	 */
	EAttribute getDetailCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS <em>Documentation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS
	 * @generated
	 */
	EClass getDocumentationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS#getValue()
	 * @see #getDocumentationCS()
	 * @generated
	 */
	EAttribute getDocumentationCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ElementCS <em>Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ElementCS
	 * @generated
	 */
	EClass getElementCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.ElementCS#getLogicalParent <em>Logical Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Logical Parent</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ElementCS#getLogicalParent()
	 * @see #getElementCS()
	 * @generated
	 */
	EReference getElementCS_LogicalParent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS <em>Element Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS
	 * @generated
	 */
	EClass getElementRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS <em>Enumeration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS
	 * @generated
	 */
	EClass getEnumerationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS#getOwnedLiterals <em>Owned Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Literals</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS#getOwnedLiterals()
	 * @see #getEnumerationCS()
	 * @generated
	 */
	EReference getEnumerationCS_OwnedLiterals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS <em>Enumeration Literal CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS
	 * @generated
	 */
	EClass getEnumerationLiteralCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS#getValue()
	 * @see #getEnumerationLiteralCS()
	 * @generated
	 */
	EAttribute getEnumerationLiteralCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.FeatureCS <em>Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.FeatureCS
	 * @generated
	 */
	EClass getFeatureCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ImportCS <em>Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ImportCS
	 * @generated
	 */
	EClass getImportCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.ImportCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ImportCS#getPathName()
	 * @see #getImportCS()
	 * @generated
	 */
	EReference getImportCS_PathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.ImportCS#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Namespace</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ImportCS#getNamespace()
	 * @see #getImportCS()
	 * @generated
	 */
	EReference getImportCS_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.ImportCS#isAll <em>All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ImportCS#isAll()
	 * @see #getImportCS()
	 * @generated
	 */
	EAttribute getImportCS_All();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS <em>Lambda Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lambda Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS
	 * @generated
	 */
	EClass getLambdaTypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS#getName()
	 * @see #getLambdaTypeCS()
	 * @generated
	 */
	EAttribute getLambdaTypeCS_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS#getOwnedContextType <em>Owned Context Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Context Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS#getOwnedContextType()
	 * @see #getLambdaTypeCS()
	 * @generated
	 */
	EReference getLambdaTypeCS_OwnedContextType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS#getOwnedParameterType <em>Owned Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameter Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS#getOwnedParameterType()
	 * @see #getLambdaTypeCS()
	 * @generated
	 */
	EReference getLambdaTypeCS_OwnedParameterType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS#getOwnedResultType <em>Owned Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Result Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS#getOwnedResultType()
	 * @see #getLambdaTypeCS()
	 * @generated
	 */
	EReference getLambdaTypeCS_OwnedResultType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS <em>Library CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS
	 * @generated
	 */
	EClass getLibraryCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS#getPackage()
	 * @see #getLibraryCS()
	 * @generated
	 */
	EReference getLibraryCS_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS <em>Model Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS
	 * @generated
	 */
	EClass getModelElementCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS#getOwnedAnnotation <em>Owned Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Annotation</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS#getOwnedAnnotation()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EReference getModelElementCS_OwnedAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS#getOriginalXmiId <em>Original Xmi Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Xmi Id</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS#getOriginalXmiId()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EAttribute getModelElementCS_OriginalXmiId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS#getCsi <em>Csi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Csi</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS#getCsi()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EAttribute getModelElementCS_Csi();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS <em>Model Element Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS
	 * @generated
	 */
	EClass getModelElementRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS#getPathName()
	 * @see #getModelElementRefCS()
	 * @generated
	 */
	EReference getModelElementRefCS_PathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS#getElement()
	 * @see #getModelElementRefCS()
	 * @generated
	 */
	EReference getModelElementRefCS_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS <em>Multiplicity Bounds CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Bounds CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS
	 * @generated
	 */
	EClass getMultiplicityBoundsCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS#getLowerBound()
	 * @see #getMultiplicityBoundsCS()
	 * @generated
	 */
	EAttribute getMultiplicityBoundsCS_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS#getUpperBound()
	 * @see #getMultiplicityBoundsCS()
	 * @generated
	 */
	EAttribute getMultiplicityBoundsCS_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityCS <em>Multiplicity CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityCS
	 * @generated
	 */
	EClass getMultiplicityCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS <em>Multiplicity String CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity String CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS
	 * @generated
	 */
	EClass getMultiplicityStringCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS#getStringBounds <em>String Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Bounds</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS#getStringBounds()
	 * @see #getMultiplicityStringCS()
	 * @generated
	 */
	EAttribute getMultiplicityStringCS_StringBounds();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS <em>Named Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS
	 * @generated
	 */
	EClass getNamedElementCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS#getName()
	 * @see #getNamedElementCS()
	 * @generated
	 */
	EAttribute getNamedElementCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.NamespaceCS <em>Namespace CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.NamespaceCS
	 * @generated
	 */
	EClass getNamespaceCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS <em>Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.OperationCS
	 * @generated
	 */
	EClass getOperationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedParameter <em>Owned Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameter</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedParameter()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedParameter();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedException <em>Owned Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Exception</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedException()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedException();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedPrecondition <em>Owned Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Precondition</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedPrecondition()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedPrecondition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedPostcondition <em>Owned Postcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Postcondition</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedPostcondition()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedPostcondition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedBodyExpression <em>Owned Body Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Body Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedBodyExpression()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedBodyExpression();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwningClass()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwningClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.PackageCS <em>Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PackageCS
	 * @generated
	 */
	EClass getPackageCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.PackageCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PackageCS#getOwnedType()
	 * @see #getPackageCS()
	 * @generated
	 */
	EReference getPackageCS_OwnedType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.PackageCS#getNsPrefix <em>Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns Prefix</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PackageCS#getNsPrefix()
	 * @see #getPackageCS()
	 * @generated
	 */
	EAttribute getPackageCS_NsPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.PackageCS#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PackageCS#getNsURI()
	 * @see #getPackageCS()
	 * @generated
	 */
	EAttribute getPackageCS_NsURI();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS <em>Package Owner CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Owner CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS
	 * @generated
	 */
	EClass getPackageOwnerCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS#getOwnedNestedPackage <em>Owned Nested Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Nested Package</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS#getOwnedNestedPackage()
	 * @see #getPackageOwnerCS()
	 * @generated
	 */
	EReference getPackageOwnerCS_OwnedNestedPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS <em>Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS
	 * @generated
	 */
	EClass getParameterCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS#getOwner()
	 * @see #getParameterCS()
	 * @generated
	 */
	EReference getParameterCS_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS <em>Path Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS
	 * @generated
	 */
	EClass getPathElementCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Path Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getPathName()
	 * @see #getPathElementCS()
	 * @generated
	 */
	EReference getPathElementCS_PathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getElement()
	 * @see #getPathElementCS()
	 * @generated
	 */
	EReference getPathElementCS_Element();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS#getElementType()
	 * @see #getPathElementCS()
	 * @generated
	 */
	EReference getPathElementCS_ElementType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS <em>Path Element With URICS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Element With URICS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS
	 * @generated
	 */
	EClass getPathElementWithURICS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS#getUri()
	 * @see #getPathElementWithURICS()
	 * @generated
	 */
	EAttribute getPathElementWithURICS_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Name CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS
	 * @generated
	 */
	EClass getPathNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Path</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getPath()
	 * @see #getPathNameCS()
	 * @generated
	 */
	EReference getPathNameCS_Path();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getElement()
	 * @see #getPathNameCS()
	 * @generated
	 */
	EReference getPathNameCS_Element();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getContext()
	 * @see #getPathNameCS()
	 * @generated
	 */
	EReference getPathNameCS_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getScopeFilter <em>Scope Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope Filter</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS#getScopeFilter()
	 * @see #getPathNameCS()
	 * @generated
	 */
	EAttribute getPathNameCS_ScopeFilter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS <em>Pivotable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pivotable Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS
	 * @generated
	 */
	EClass getPivotableElementCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS#getPivot <em>Pivot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pivot</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS#getPivot()
	 * @see #getPivotableElementCS()
	 * @generated
	 */
	EReference getPivotableElementCS_Pivot();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS <em>Primitive Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS
	 * @generated
	 */
	EClass getPrimitiveTypeRefCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS#getName()
	 * @see #getPrimitiveTypeRefCS()
	 * @generated
	 */
	EAttribute getPrimitiveTypeRefCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS <em>Reference CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS
	 * @generated
	 */
	EClass getReferenceCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS#getOpposite()
	 * @see #getReferenceCS()
	 * @generated
	 */
	EReference getReferenceCS_Opposite();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Keys</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS#getKeys()
	 * @see #getReferenceCS()
	 * @generated
	 */
	EReference getReferenceCS_Keys();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.RootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.RootCS
	 * @generated
	 */
	EClass getRootCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.RootCS#getOwnedImport <em>Owned Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Import</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.RootCS#getOwnedImport()
	 * @see #getRootCS()
	 * @generated
	 */
	EReference getRootCS_OwnedImport();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.RootCS#getOwnedLibrary <em>Owned Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Library</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.RootCS#getOwnedLibrary()
	 * @see #getRootCS()
	 * @generated
	 */
	EReference getRootCS_OwnedLibrary();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS <em>Root Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Package CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS
	 * @generated
	 */
	EClass getRootPackageCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS <em>Specification CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specification CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS
	 * @generated
	 */
	EClass getSpecificationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS#getExprString <em>Expr String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expr String</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS#getExprString()
	 * @see #getSpecificationCS()
	 * @generated
	 */
	EAttribute getSpecificationCS_ExprString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS <em>Structural Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Feature CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS
	 * @generated
	 */
	EClass getStructuralFeatureCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS#getOwner()
	 * @see #getStructuralFeatureCS()
	 * @generated
	 */
	EReference getStructuralFeatureCS_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS#getDefault()
	 * @see #getStructuralFeatureCS()
	 * @generated
	 */
	EAttribute getStructuralFeatureCS_Default();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS#getOwnedDefaultExpression <em>Owned Default Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Default Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS#getOwnedDefaultExpression()
	 * @see #getStructuralFeatureCS()
	 * @generated
	 */
	EReference getStructuralFeatureCS_OwnedDefaultExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS <em>Template Binding CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Binding CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS
	 * @generated
	 */
	EClass getTemplateBindingCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS#getOwningTemplateBindableElement <em>Owning Template Bindable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Template Bindable Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS#getOwningTemplateBindableElement()
	 * @see #getTemplateBindingCS()
	 * @generated
	 */
	EReference getTemplateBindingCS_OwningTemplateBindableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS#getOwnedParameterSubstitution <em>Owned Parameter Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameter Substitution</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS#getOwnedParameterSubstitution()
	 * @see #getTemplateBindingCS()
	 * @generated
	 */
	EReference getTemplateBindingCS_OwnedParameterSubstitution();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS <em>Template Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS
	 * @generated
	 */
	EClass getTemplateParameterCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS#getOwningTemplateSignature <em>Owning Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Template Signature</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS#getOwningTemplateSignature()
	 * @see #getTemplateParameterCS()
	 * @generated
	 */
	EReference getTemplateParameterCS_OwningTemplateSignature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS <em>Template Parameter Substitution CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter Substitution CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS
	 * @generated
	 */
	EClass getTemplateParameterSubstitutionCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS#getOwningTemplateBinding <em>Owning Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Template Binding</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS#getOwningTemplateBinding()
	 * @see #getTemplateParameterSubstitutionCS()
	 * @generated
	 */
	EReference getTemplateParameterSubstitutionCS_OwningTemplateBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS#getOwnedActualParameter <em>Owned Actual Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Actual Parameter</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS#getOwnedActualParameter()
	 * @see #getTemplateParameterSubstitutionCS()
	 * @generated
	 */
	EReference getTemplateParameterSubstitutionCS_OwnedActualParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS <em>Template Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Signature CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS
	 * @generated
	 */
	EClass getTemplateSignatureCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS#getOwningTemplateElement <em>Owning Template Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Template Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS#getOwningTemplateElement()
	 * @see #getTemplateSignatureCS()
	 * @generated
	 */
	EReference getTemplateSignatureCS_OwningTemplateElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS#getOwnedTemplateParameter <em>Owned Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Template Parameter</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS#getOwnedTemplateParameter()
	 * @see #getTemplateSignatureCS()
	 * @generated
	 */
	EReference getTemplateSignatureCS_OwnedTemplateParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS <em>Templateable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Templateable Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS
	 * @generated
	 */
	EClass getTemplateableElementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS#getOwnedTemplateSignature <em>Owned Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Template Signature</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS#getOwnedTemplateSignature()
	 * @see #getTemplateableElementCS()
	 * @generated
	 */
	EReference getTemplateableElementCS_OwnedTemplateSignature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS <em>Tuple Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Part CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS
	 * @generated
	 */
	EClass getTuplePartCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS <em>Tuple Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS
	 * @generated
	 */
	EClass getTupleTypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS#getName()
	 * @see #getTupleTypeCS()
	 * @generated
	 */
	EAttribute getTupleTypeCS_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS#getOwnedParts()
	 * @see #getTupleTypeCS()
	 * @generated
	 */
	EReference getTupleTypeCS_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypeCS
	 * @generated
	 */
	EClass getTypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS <em>Type Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Parameter CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS
	 * @generated
	 */
	EClass getTypeParameterCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS#getOwnedExtends <em>Owned Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Extends</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS#getOwnedExtends()
	 * @see #getTypeParameterCS()
	 * @generated
	 */
	EReference getTypeParameterCS_OwnedExtends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS#getOwnedSuper <em>Owned Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Super</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS#getOwnedSuper()
	 * @see #getTypeParameterCS()
	 * @generated
	 */
	EReference getTypeParameterCS_OwnedSuper();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS <em>Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS
	 * @generated
	 */
	EClass getTypeRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS <em>Typed Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS
	 * @generated
	 */
	EClass getTypedElementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS#getOwnedType()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EReference getTypedElementCS_OwnedType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS#getQualifier <em>Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifier</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS#getQualifier()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Qualifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS#isOptional()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Optional();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS <em>Typed Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS
	 * @generated
	 */
	EClass getTypedRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Multiplicity</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS#getMultiplicity()
	 * @see #getTypedRefCS()
	 * @generated
	 */
	EReference getTypedRefCS_Multiplicity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS <em>Typed Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS
	 * @generated
	 */
	EClass getTypedTypeRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getPathName()
	 * @see #getTypedTypeRefCS()
	 * @generated
	 */
	EReference getTypedTypeRefCS_PathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getType()
	 * @see #getTypedTypeRefCS()
	 * @generated
	 */
	EReference getTypedTypeRefCS_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getOwnedTemplateBinding <em>Owned Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Template Binding</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS#getOwnedTemplateBinding()
	 * @see #getTypedTypeRefCS()
	 * @generated
	 */
	EReference getTypedTypeRefCS_OwnedTemplateBinding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS <em>Visitable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS
	 * @model instanceClass="org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS"
	 * @generated
	 */
	EClass getVisitableCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS <em>Wildcard Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard Type Ref CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS
	 * @generated
	 */
	EClass getWildcardTypeRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS#getExtends()
	 * @see #getWildcardTypeRefCS()
	 * @generated
	 */
	EReference getWildcardTypeRefCS_Extends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS#getSuper()
	 * @see #getWildcardTypeRefCS()
	 * @generated
	 */
	EReference getWildcardTypeRefCS_Super();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.xtext.base.basecs.IteratorKind <em>Iterator Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Iterator Kind</em>'.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.IteratorKind
	 * @generated
	 */
	EEnum getIteratorKind();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.pivot.scoping.ScopeFilter <em>Scope Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Scope Filter</em>'.
	 * @see org.eclipse.ocl.examples.pivot.scoping.ScopeFilter
	 * @model instanceClass="org.eclipse.ocl.examples.pivot.scoping.ScopeFilter"
	 * @generated
	 */
	EDataType getScopeFilter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BaseCSFactory getBaseCSFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.AnnotationCSImpl <em>Annotation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.AnnotationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getAnnotationCS()
		 * @generated
		 */
		EClass ANNOTATION_CS = eINSTANCE.getAnnotationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Content</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_CS__OWNED_CONTENT = eINSTANCE.getAnnotationCS_OwnedContent();

		/**
		 * The meta object literal for the '<em><b>Owned Reference</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_CS__OWNED_REFERENCE = eINSTANCE.getAnnotationCS_OwnedReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.AnnotationElementCSImpl <em>Annotation Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.AnnotationElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getAnnotationElementCS()
		 * @generated
		 */
		EClass ANNOTATION_ELEMENT_CS = eINSTANCE.getAnnotationElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Detail</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_ELEMENT_CS__OWNED_DETAIL = eINSTANCE.getAnnotationElementCS_OwnedDetail();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.AttributeCSImpl <em>Attribute CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.AttributeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getAttributeCS()
		 * @generated
		 */
		EClass ATTRIBUTE_CS = eINSTANCE.getAttributeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ClassCSImpl <em>Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ClassCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getClassCS()
		 * @generated
		 */
		EClass CLASS_CS = eINSTANCE.getClassCS();

		/**
		 * The meta object literal for the '<em><b>Owned Super Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OWNED_SUPER_TYPE = eINSTANCE.getClassCS_OwnedSuperType();

		/**
		 * The meta object literal for the '<em><b>Owned Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OWNED_OPERATION = eINSTANCE.getClassCS_OwnedOperation();

		/**
		 * The meta object literal for the '<em><b>Owned Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OWNED_PROPERTY = eINSTANCE.getClassCS_OwnedProperty();

		/**
		 * The meta object literal for the '<em><b>Owned Meta Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OWNED_META_TYPE = eINSTANCE.getClassCS_OwnedMetaType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ClassifierCSImpl <em>Classifier CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ClassifierCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getClassifierCS()
		 * @generated
		 */
		EClass CLASSIFIER_CS = eINSTANCE.getClassifierCS();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CS__OWNER = eINSTANCE.getClassifierCS_Owner();

		/**
		 * The meta object literal for the '<em><b>Instance Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_CS__INSTANCE_CLASS_NAME = eINSTANCE.getClassifierCS_InstanceClassName();

		/**
		 * The meta object literal for the '<em><b>Owned Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_CS__OWNED_CONSTRAINT = eINSTANCE.getClassifierCS_OwnedConstraint();

		/**
		 * The meta object literal for the '<em><b>Qualifier</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_CS__QUALIFIER = eINSTANCE.getClassifierCS_Qualifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ConstraintCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getConstraintCS()
		 * @generated
		 */
		EClass CONSTRAINT_CS = eINSTANCE.getConstraintCS();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_CS__STEREOTYPE = eINSTANCE.getConstraintCS_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_CS__SPECIFICATION = eINSTANCE.getConstraintCS_Specification();

		/**
		 * The meta object literal for the '<em><b>Message Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_CS__MESSAGE_SPECIFICATION = eINSTANCE.getConstraintCS_MessageSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ContextLessElementCSImpl <em>Context Less Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ContextLessElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getContextLessElementCS()
		 * @generated
		 */
		EClass CONTEXT_LESS_ELEMENT_CS = eINSTANCE.getContextLessElementCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.DataTypeCSImpl <em>Data Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.DataTypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getDataTypeCS()
		 * @generated
		 */
		EClass DATA_TYPE_CS = eINSTANCE.getDataTypeCS();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_CS__LITERALS = eINSTANCE.getDataTypeCS_Literals();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.DetailCSImpl <em>Detail CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.DetailCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getDetailCS()
		 * @generated
		 */
		EClass DETAIL_CS = eINSTANCE.getDetailCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAIL_CS__VALUE = eINSTANCE.getDetailCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.DocumentationCSImpl <em>Documentation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.DocumentationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getDocumentationCS()
		 * @generated
		 */
		EClass DOCUMENTATION_CS = eINSTANCE.getDocumentationCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION_CS__VALUE = eINSTANCE.getDocumentationCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ElementCSImpl <em>Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getElementCS()
		 * @generated
		 */
		EClass ELEMENT_CS = eINSTANCE.getElementCS();

		/**
		 * The meta object literal for the '<em><b>Logical Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_CS__LOGICAL_PARENT = eINSTANCE.getElementCS_LogicalParent();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ElementRefCSImpl <em>Element Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ElementRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getElementRefCS()
		 * @generated
		 */
		EClass ELEMENT_REF_CS = eINSTANCE.getElementRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.EnumerationCSImpl <em>Enumeration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.EnumerationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getEnumerationCS()
		 * @generated
		 */
		EClass ENUMERATION_CS = eINSTANCE.getEnumerationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_CS__OWNED_LITERALS = eINSTANCE.getEnumerationCS_OwnedLiterals();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.EnumerationLiteralCSImpl <em>Enumeration Literal CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.EnumerationLiteralCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getEnumerationLiteralCS()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL_CS = eINSTANCE.getEnumerationLiteralCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL_CS__VALUE = eINSTANCE.getEnumerationLiteralCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.FeatureCS <em>Feature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.FeatureCS
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getFeatureCS()
		 * @generated
		 */
		EClass FEATURE_CS = eINSTANCE.getFeatureCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ImportCSImpl <em>Import CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ImportCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getImportCS()
		 * @generated
		 */
		EClass IMPORT_CS = eINSTANCE.getImportCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT_CS__PATH_NAME = eINSTANCE.getImportCS_PathName();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT_CS__NAMESPACE = eINSTANCE.getImportCS_Namespace();

		/**
		 * The meta object literal for the '<em><b>All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_CS__ALL = eINSTANCE.getImportCS_All();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.LambdaTypeCSImpl <em>Lambda Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.LambdaTypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getLambdaTypeCS()
		 * @generated
		 */
		EClass LAMBDA_TYPE_CS = eINSTANCE.getLambdaTypeCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAMBDA_TYPE_CS__NAME = eINSTANCE.getLambdaTypeCS_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Context Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE_CS__OWNED_CONTEXT_TYPE = eINSTANCE.getLambdaTypeCS_OwnedContextType();

		/**
		 * The meta object literal for the '<em><b>Owned Parameter Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE_CS__OWNED_PARAMETER_TYPE = eINSTANCE.getLambdaTypeCS_OwnedParameterType();

		/**
		 * The meta object literal for the '<em><b>Owned Result Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE_CS__OWNED_RESULT_TYPE = eINSTANCE.getLambdaTypeCS_OwnedResultType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.LibraryCSImpl <em>Library CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.LibraryCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getLibraryCS()
		 * @generated
		 */
		EClass LIBRARY_CS = eINSTANCE.getLibraryCS();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_CS__PACKAGE = eINSTANCE.getLibraryCS_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ModelElementCSImpl <em>Model Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ModelElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getModelElementCS()
		 * @generated
		 */
		EClass MODEL_ELEMENT_CS = eINSTANCE.getModelElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Annotation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_CS__OWNED_ANNOTATION = eINSTANCE.getModelElementCS_OwnedAnnotation();

		/**
		 * The meta object literal for the '<em><b>Original Xmi Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_CS__ORIGINAL_XMI_ID = eINSTANCE.getModelElementCS_OriginalXmiId();

		/**
		 * The meta object literal for the '<em><b>Csi</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_CS__CSI = eINSTANCE.getModelElementCS_Csi();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ModelElementRefCSImpl <em>Model Element Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ModelElementRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getModelElementRefCS()
		 * @generated
		 */
		EClass MODEL_ELEMENT_REF_CS = eINSTANCE.getModelElementRefCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_REF_CS__PATH_NAME = eINSTANCE.getModelElementRefCS_PathName();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_REF_CS__ELEMENT = eINSTANCE.getModelElementRefCS_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.MultiplicityBoundsCSImpl <em>Multiplicity Bounds CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.MultiplicityBoundsCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getMultiplicityBoundsCS()
		 * @generated
		 */
		EClass MULTIPLICITY_BOUNDS_CS = eINSTANCE.getMultiplicityBoundsCS();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_BOUNDS_CS__LOWER_BOUND = eINSTANCE.getMultiplicityBoundsCS_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_BOUNDS_CS__UPPER_BOUND = eINSTANCE.getMultiplicityBoundsCS_UpperBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityCS <em>Multiplicity CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityCS
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getMultiplicityCS()
		 * @generated
		 */
		EClass MULTIPLICITY_CS = eINSTANCE.getMultiplicityCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.MultiplicityStringCSImpl <em>Multiplicity String CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.MultiplicityStringCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getMultiplicityStringCS()
		 * @generated
		 */
		EClass MULTIPLICITY_STRING_CS = eINSTANCE.getMultiplicityStringCS();

		/**
		 * The meta object literal for the '<em><b>String Bounds</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_STRING_CS__STRING_BOUNDS = eINSTANCE.getMultiplicityStringCS_StringBounds();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.NamedElementCSImpl <em>Named Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.NamedElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getNamedElementCS()
		 * @generated
		 */
		EClass NAMED_ELEMENT_CS = eINSTANCE.getNamedElementCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT_CS__NAME = eINSTANCE.getNamedElementCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.NamespaceCS <em>Namespace CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.NamespaceCS
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getNamespaceCS()
		 * @generated
		 */
		EClass NAMESPACE_CS = eINSTANCE.getNamespaceCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl <em>Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.OperationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getOperationCS()
		 * @generated
		 */
		EClass OPERATION_CS = eINSTANCE.getOperationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_PARAMETER = eINSTANCE.getOperationCS_OwnedParameter();

		/**
		 * The meta object literal for the '<em><b>Owned Exception</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_EXCEPTION = eINSTANCE.getOperationCS_OwnedException();

		/**
		 * The meta object literal for the '<em><b>Owned Precondition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_PRECONDITION = eINSTANCE.getOperationCS_OwnedPrecondition();

		/**
		 * The meta object literal for the '<em><b>Owned Postcondition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_POSTCONDITION = eINSTANCE.getOperationCS_OwnedPostcondition();

		/**
		 * The meta object literal for the '<em><b>Owned Body Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_BODY_EXPRESSION = eINSTANCE.getOperationCS_OwnedBodyExpression();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNING_CLASS = eINSTANCE.getOperationCS_OwningClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PackageCSImpl <em>Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PackageCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPackageCS()
		 * @generated
		 */
		EClass PACKAGE_CS = eINSTANCE.getPackageCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_CS__OWNED_TYPE = eINSTANCE.getPackageCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_CS__NS_PREFIX = eINSTANCE.getPackageCS_NsPrefix();

		/**
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_CS__NS_URI = eINSTANCE.getPackageCS_NsURI();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PackageOwnerCSImpl <em>Package Owner CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PackageOwnerCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPackageOwnerCS()
		 * @generated
		 */
		EClass PACKAGE_OWNER_CS = eINSTANCE.getPackageOwnerCS();

		/**
		 * The meta object literal for the '<em><b>Owned Nested Package</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_OWNER_CS__OWNED_NESTED_PACKAGE = eINSTANCE.getPackageOwnerCS_OwnedNestedPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ParameterCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getParameterCS()
		 * @generated
		 */
		EClass PARAMETER_CS = eINSTANCE.getParameterCS();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_CS__OWNER = eINSTANCE.getParameterCS_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathElementCSImpl <em>Path Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PathElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPathElementCS()
		 * @generated
		 */
		EClass PATH_ELEMENT_CS = eINSTANCE.getPathElementCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_ELEMENT_CS__PATH_NAME = eINSTANCE.getPathElementCS_PathName();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_ELEMENT_CS__ELEMENT = eINSTANCE.getPathElementCS_Element();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_ELEMENT_CS__ELEMENT_TYPE = eINSTANCE.getPathElementCS_ElementType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathElementWithURICSImpl <em>Path Element With URICS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PathElementWithURICSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPathElementWithURICS()
		 * @generated
		 */
		EClass PATH_ELEMENT_WITH_URICS = eINSTANCE.getPathElementWithURICS();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_ELEMENT_WITH_URICS__URI = eINSTANCE.getPathElementWithURICS_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PathNameCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPathNameCS()
		 * @generated
		 */
		EClass PATH_NAME_CS = eINSTANCE.getPathNameCS();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME_CS__PATH = eINSTANCE.getPathNameCS_Path();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME_CS__ELEMENT = eINSTANCE.getPathNameCS_Element();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME_CS__CONTEXT = eINSTANCE.getPathNameCS_Context();

		/**
		 * The meta object literal for the '<em><b>Scope Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_NAME_CS__SCOPE_FILTER = eINSTANCE.getPathNameCS_ScopeFilter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PivotableElementCSImpl <em>Pivotable Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PivotableElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPivotableElementCS()
		 * @generated
		 */
		EClass PIVOTABLE_ELEMENT_CS = eINSTANCE.getPivotableElementCS();

		/**
		 * The meta object literal for the '<em><b>Pivot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIVOTABLE_ELEMENT_CS__PIVOT = eINSTANCE.getPivotableElementCS_Pivot();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.PrimitiveTypeRefCSImpl <em>Primitive Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.PrimitiveTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getPrimitiveTypeRefCS()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_REF_CS = eINSTANCE.getPrimitiveTypeRefCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE_REF_CS__NAME = eINSTANCE.getPrimitiveTypeRefCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.ReferenceCSImpl <em>Reference CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.ReferenceCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getReferenceCS()
		 * @generated
		 */
		EClass REFERENCE_CS = eINSTANCE.getReferenceCS();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CS__OPPOSITE = eINSTANCE.getReferenceCS_Opposite();

		/**
		 * The meta object literal for the '<em><b>Keys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CS__KEYS = eINSTANCE.getReferenceCS_Keys();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.RootCS <em>Root CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.RootCS
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getRootCS()
		 * @generated
		 */
		EClass ROOT_CS = eINSTANCE.getRootCS();

		/**
		 * The meta object literal for the '<em><b>Owned Import</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CS__OWNED_IMPORT = eINSTANCE.getRootCS_OwnedImport();

		/**
		 * The meta object literal for the '<em><b>Owned Library</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CS__OWNED_LIBRARY = eINSTANCE.getRootCS_OwnedLibrary();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.RootPackageCSImpl <em>Root Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.RootPackageCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getRootPackageCS()
		 * @generated
		 */
		EClass ROOT_PACKAGE_CS = eINSTANCE.getRootPackageCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.SpecificationCSImpl <em>Specification CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.SpecificationCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getSpecificationCS()
		 * @generated
		 */
		EClass SPECIFICATION_CS = eINSTANCE.getSpecificationCS();

		/**
		 * The meta object literal for the '<em><b>Expr String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFICATION_CS__EXPR_STRING = eINSTANCE.getSpecificationCS_ExprString();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.StructuralFeatureCSImpl <em>Structural Feature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.StructuralFeatureCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getStructuralFeatureCS()
		 * @generated
		 */
		EClass STRUCTURAL_FEATURE_CS = eINSTANCE.getStructuralFeatureCS();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE_CS__OWNER = eINSTANCE.getStructuralFeatureCS_Owner();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURAL_FEATURE_CS__DEFAULT = eINSTANCE.getStructuralFeatureCS_Default();

		/**
		 * The meta object literal for the '<em><b>Owned Default Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSION = eINSTANCE.getStructuralFeatureCS_OwnedDefaultExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateBindingCSImpl <em>Template Binding CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateBindingCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTemplateBindingCS()
		 * @generated
		 */
		EClass TEMPLATE_BINDING_CS = eINSTANCE.getTemplateBindingCS();

		/**
		 * The meta object literal for the '<em><b>Owning Template Bindable Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT = eINSTANCE.getTemplateBindingCS_OwningTemplateBindableElement();

		/**
		 * The meta object literal for the '<em><b>Owned Parameter Substitution</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION = eINSTANCE.getTemplateBindingCS_OwnedParameterSubstitution();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateParameterCSImpl <em>Template Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateParameterCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTemplateParameterCS()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_CS = eINSTANCE.getTemplateParameterCS();

		/**
		 * The meta object literal for the '<em><b>Owning Template Signature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE = eINSTANCE.getTemplateParameterCS_OwningTemplateSignature();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateParameterSubstitutionCSImpl <em>Template Parameter Substitution CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateParameterSubstitutionCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTemplateParameterSubstitutionCS()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_SUBSTITUTION_CS = eINSTANCE.getTemplateParameterSubstitutionCS();

		/**
		 * The meta object literal for the '<em><b>Owning Template Binding</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNING_TEMPLATE_BINDING = eINSTANCE.getTemplateParameterSubstitutionCS_OwningTemplateBinding();

		/**
		 * The meta object literal for the '<em><b>Owned Actual Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER = eINSTANCE.getTemplateParameterSubstitutionCS_OwnedActualParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateSignatureCSImpl <em>Template Signature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TemplateSignatureCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTemplateSignatureCS()
		 * @generated
		 */
		EClass TEMPLATE_SIGNATURE_CS = eINSTANCE.getTemplateSignatureCS();

		/**
		 * The meta object literal for the '<em><b>Owning Template Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT = eINSTANCE.getTemplateSignatureCS_OwningTemplateElement();

		/**
		 * The meta object literal for the '<em><b>Owned Template Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER = eINSTANCE.getTemplateSignatureCS_OwnedTemplateParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS <em>Templateable Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTemplateableElementCS()
		 * @generated
		 */
		EClass TEMPLATEABLE_ELEMENT_CS = eINSTANCE.getTemplateableElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Template Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE = eINSTANCE.getTemplateableElementCS_OwnedTemplateSignature();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TuplePartCSImpl <em>Tuple Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TuplePartCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTuplePartCS()
		 * @generated
		 */
		EClass TUPLE_PART_CS = eINSTANCE.getTuplePartCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TupleTypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTupleTypeCS()
		 * @generated
		 */
		EClass TUPLE_TYPE_CS = eINSTANCE.getTupleTypeCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TUPLE_TYPE_CS__NAME = eINSTANCE.getTupleTypeCS_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_TYPE_CS__OWNED_PARTS = eINSTANCE.getTupleTypeCS_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypeCS <em>Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypeCS
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypeCS()
		 * @generated
		 */
		EClass TYPE_CS = eINSTANCE.getTypeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypeParameterCSImpl <em>Type Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TypeParameterCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypeParameterCS()
		 * @generated
		 */
		EClass TYPE_PARAMETER_CS = eINSTANCE.getTypeParameterCS();

		/**
		 * The meta object literal for the '<em><b>Owned Extends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETER_CS__OWNED_EXTENDS = eINSTANCE.getTypeParameterCS_OwnedExtends();

		/**
		 * The meta object literal for the '<em><b>Owned Super</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETER_CS__OWNED_SUPER = eINSTANCE.getTypeParameterCS_OwnedSuper();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypeRefCSImpl <em>Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypeRefCS()
		 * @generated
		 */
		EClass TYPE_REF_CS = eINSTANCE.getTypeRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedElementCSImpl <em>Typed Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedElementCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypedElementCS()
		 * @generated
		 */
		EClass TYPED_ELEMENT_CS = eINSTANCE.getTypedElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT_CS__OWNED_TYPE = eINSTANCE.getTypedElementCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Qualifier</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_CS__QUALIFIER = eINSTANCE.getTypedElementCS_Qualifier();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_CS__OPTIONAL = eINSTANCE.getTypedElementCS_Optional();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedRefCSImpl <em>Typed Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypedRefCS()
		 * @generated
		 */
		EClass TYPED_REF_CS = eINSTANCE.getTypedRefCS();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_REF_CS__MULTIPLICITY = eINSTANCE.getTypedRefCS_Multiplicity();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedTypeRefCSImpl <em>Typed Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.TypedTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getTypedTypeRefCS()
		 * @generated
		 */
		EClass TYPED_TYPE_REF_CS = eINSTANCE.getTypedTypeRefCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TYPE_REF_CS__PATH_NAME = eINSTANCE.getTypedTypeRefCS_PathName();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TYPE_REF_CS__TYPE = eINSTANCE.getTypedTypeRefCS_Type();

		/**
		 * The meta object literal for the '<em><b>Owned Template Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING = eINSTANCE.getTypedTypeRefCS_OwnedTemplateBinding();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS <em>Visitable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getVisitableCS()
		 * @generated
		 */
		EClass VISITABLE_CS = eINSTANCE.getVisitableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.impl.WildcardTypeRefCSImpl <em>Wildcard Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.WildcardTypeRefCSImpl
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getWildcardTypeRefCS()
		 * @generated
		 */
		EClass WILDCARD_TYPE_REF_CS = eINSTANCE.getWildcardTypeRefCS();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD_TYPE_REF_CS__EXTENDS = eINSTANCE.getWildcardTypeRefCS_Extends();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD_TYPE_REF_CS__SUPER = eINSTANCE.getWildcardTypeRefCS_Super();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.base.basecs.IteratorKind <em>Iterator Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.IteratorKind
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getIteratorKind()
		 * @generated
		 */
		EEnum ITERATOR_KIND = eINSTANCE.getIteratorKind();

		/**
		 * The meta object literal for the '<em>Scope Filter</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.scoping.ScopeFilter
		 * @see org.eclipse.ocl.examples.xtext.base.basecs.impl.BaseCSPackageImpl#getScopeFilter()
		 * @generated
		 */
		EDataType SCOPE_FILTER = eINSTANCE.getScopeFilter();

	}

} //BaseCSPackage
