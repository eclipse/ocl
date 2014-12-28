/*******************************************************************************
 * Copyright (c) 2010, 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 * 	 E.D.Willink (CEA LIST) - Bug 425799 - validity view
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.AssociativityKind;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.PivotConstantsInternal;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.context.ParserContext;
import org.eclipse.ocl.pivot.ecore.Ecore2AS;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.impl.PackageImpl;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.pivot.manager.AbstractMetaModelManagerResourceAdapter;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.pivot.manager.PivotExecutorManager;
import org.eclipse.ocl.pivot.scoping.Attribution;
import org.eclipse.ocl.pivot.scoping.NullAttribution;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

public class PivotUtilInternal extends PivotUtil
{	
	private static final Logger logger = Logger.getLogger(PivotUtilInternal.class);

	public static @NonNull AnyType createAnyType(@NonNull String name) {
		AnyType pivotType = PivotFactory.eINSTANCE.createAnyType();
		pivotType.setName(name);
		return pivotType;
	}

	public static @NonNull BagType createBagType(@NonNull BagType unspecializedType, @NonNull Type elementType) {
		return createCollectionType(PivotFactory.eINSTANCE.createBagType(), unspecializedType, elementType);
	}

	public static @NonNull org.eclipse.ocl.pivot.Class createClass(/*@NonNull*/ EClass eClass) {
		org.eclipse.ocl.pivot.Class pivotType = PivotFactory.eINSTANCE.createClass();
		pivotType.setName(eClass.getName());
		((PivotObjectImpl)pivotType).setTarget(eClass);
		return pivotType;
	}

	public static @NonNull org.eclipse.ocl.pivot.Class createClass(@NonNull String name) {
		org.eclipse.ocl.pivot.Class pivotType = PivotFactory.eINSTANCE.createClass();
		pivotType.setName(name);
		return pivotType;
	}

	public static @NonNull CollectionType createCollectionType(@NonNull CollectionType unspecializedType, @NonNull Type elementType) {
		return createCollectionType(PivotFactory.eINSTANCE.createCollectionType(), unspecializedType, elementType);
	}

	protected static @NonNull  <T extends CollectionType> T createCollectionType(/*@NonNull*/ T specializedType, @NonNull T unspecializedType, @NonNull Type instanceType) {
		specializedType.setName(unspecializedType.getName());
		specializedType.setLower(unspecializedType.getLower());
		specializedType.setUpper(unspecializedType.getUpper());
		specializedType.setUnspecializedElement(unspecializedType);
		specializedType.setElementType(instanceType);
		return specializedType;
	}

	public static @NonNull DataType createDataType(/*@NonNull*/ EDataType eDataType) {
		DataType pivotType = PivotFactory.eINSTANCE.createDataType();
		pivotType.setName(eDataType.getName());
		((PivotObjectImpl)pivotType).setTarget(eDataType);
		return pivotType;
	}

	public static @NonNull DataType createDataType(@NonNull String name) {
		DataType pivotType = PivotFactory.eINSTANCE.createDataType();
		pivotType.setName(name);
		return pivotType;
	}
	
	public static @NonNull Enumeration createEnumeration(/*@NonNull*/ EEnum eEnum) {
		Enumeration pivotType = PivotFactory.eINSTANCE.createEnumeration();
		pivotType.setName(eEnum.getName());
		((PivotObjectImpl)pivotType).setTarget(eEnum);
		return pivotType;
	}
	
	public static @NonNull Enumeration createEnumeration(@NonNull String name) {
		Enumeration pivotType = PivotFactory.eINSTANCE.createEnumeration();
		pivotType.setName(name);
		return pivotType;
	}
	
	public static @NonNull EnumerationLiteral createEnumerationLiteral(/*@NonNull*/ EEnumLiteral eEnumLiteral) {
		EnumerationLiteral pivotEnumerationLiteral = PivotFactory.eINSTANCE.createEnumerationLiteral();
		pivotEnumerationLiteral.setName(eEnumLiteral.getName());
		((PivotObjectImpl)pivotEnumerationLiteral).setTarget(eEnumLiteral);
		return pivotEnumerationLiteral;
	}

	public static @NonNull EnumerationLiteral createEnumerationLiteral(@NonNull String name) {
		EnumerationLiteral pivotEnumerationLiteral = PivotFactory.eINSTANCE.createEnumerationLiteral();
		pivotEnumerationLiteral.setName(name);
		return pivotEnumerationLiteral;
	}

	public static @NonNull ExpressionInOCL createExpressionInOCL(@Nullable Variable asContextVariable, @NonNull OCLExpression asExpression, /*@NonNUll*/ Variable... asParameterVariables) {
		ExpressionInOCL asExpressionInOCL = PivotFactory.eINSTANCE.createExpressionInOCL();
		asExpressionInOCL.setOwnedContext(asContextVariable);
		if (asParameterVariables != null) {
			for (Variable asParameterVariable : asParameterVariables) {
				asExpressionInOCL.getOwnedParameters().add(asParameterVariable);
			}
		}
		asExpressionInOCL.setOwnedBody(asExpression);
		asExpressionInOCL.setType(asExpression.getType());
		asExpressionInOCL.setIsRequired(asExpression.isRequired());
		return asExpressionInOCL;
	}

	public static @NonNull ExpressionInOCL createExpressionInOCLError(@NonNull String string) {
		@SuppressWarnings("null")@NonNull ExpressionInOCL expressionInOCL = PivotFactory.eINSTANCE.createExpressionInOCL();
		StringLiteralExp stringLiteral = PivotFactory.eINSTANCE.createStringLiteralExp();
		stringLiteral.setStringSymbol(string); //createTupleValuedConstraint("false", null, string));
		expressionInOCL.setOwnedBody(stringLiteral);
		expressionInOCL.setType(stringLiteral.getType());
		return expressionInOCL;
	}

	public static @NonNull InvalidType createInvalidType(@NonNull String name) {
		InvalidType pivotType = PivotFactory.eINSTANCE.createInvalidType();
		pivotType.setName(name);
		return pivotType;
	}
	
	public static @NonNull Iteration createIteration(@NonNull String name, @NonNull Type type, @Nullable String implementationClass, @NonNull LibraryFeature implementation) {
		Iteration pivotIteration = PivotFactory.eINSTANCE.createIteration();
		pivotIteration.setName(name);
		pivotIteration.setType(type);
		pivotIteration.setImplementationClass(implementationClass);
		pivotIteration.setImplementation(implementation);
		return pivotIteration;
	}
	
	public static @NonNull LambdaType createLambdaType(@NonNull String name) {
		LambdaType pivotType = PivotFactory.eINSTANCE.createLambdaType();
		pivotType.setName(name);
		return pivotType;
	}

	public static @NonNull LetExp createLetExp(@NonNull Variable asVariable, @NonNull OCLExpression asIn) {
		LetExp asLetExp = PivotFactory.eINSTANCE.createLetExp();
		asLetExp.setOwnedIn(asIn);
		asLetExp.setType(asIn.getType());
		asLetExp.setIsRequired(asIn.isRequired());
		asLetExp.setOwnedVariable(asVariable);
		return asLetExp;
	}

	public static @NonNull Model createModel(@NonNull String externalURI) {
		Model pivotModel = PivotFactory.eINSTANCE.createModel();
		pivotModel.setExternalURI(externalURI);
		return pivotModel;
	}
	
	public static @NonNull Operation createOperation(@NonNull String name, @NonNull Type type, @Nullable String implementationClass, @Nullable LibraryFeature implementation) {
		Operation pivotOperation = PivotFactory.eINSTANCE.createOperation();
		pivotOperation.setName(name);
		pivotOperation.setType(type);
		pivotOperation.setImplementationClass(implementationClass);
		pivotOperation.setImplementation(implementation);
		return pivotOperation;
	}
	
	public static @NonNull Operation createOperation(/*@NonNull*/ EOperation eOperation, @NonNull Type type, @Nullable String implementationClass, @Nullable LibraryFeature implementation) {
		Operation pivotOperation = PivotFactory.eINSTANCE.createOperation();
		pivotOperation.setName(eOperation.getName());
		pivotOperation.setType(type);
		pivotOperation.setImplementationClass(implementationClass);
		pivotOperation.setImplementation(implementation);
		((PivotObjectImpl)pivotOperation).setTarget(eOperation);
		return pivotOperation;
	}

	public static @NonNull Operation createOperation(@NonNull String name, @NonNull ExpressionInOCL asExpressionInOCL) {
		Operation asOperation = PivotFactory.eINSTANCE.createOperation();
		asOperation.setName(name);
		initOperation(asOperation, asExpressionInOCL);
		return asOperation;
	}

	public static @NonNull OperationCallExp createOperationCallExp(@NonNull OCLExpression asSource, @NonNull Operation asOperation, /*@NonNull*/ OCLExpression... asArguments) {
		OperationCallExp asCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		asCallExp.setReferredOperation(asOperation);
		asCallExp.setOwnedSource(asSource);
		if (asArguments != null) {
			List<OCLExpression> asCallArguments = asCallExp.getOwnedArguments();
			for (OCLExpression asArgument : asArguments) {
				asCallArguments.add(ClassUtil.nonNullState(asArgument));
			}
		}
		asCallExp.setType(asOperation.getType());
		asCallExp.setIsRequired(asOperation.isRequired());
		return asCallExp;
	}

	public static @NonNull OrderedSetType createOrderedSetType(@NonNull OrderedSetType unspecializedType, @NonNull Type elementType) {
		return createCollectionType(PivotFactory.eINSTANCE.createOrderedSetType(), unspecializedType, elementType);
	}

	public static @NonNull Package createPackage(/*@NonNull*/ EPackage ePackage, @Nullable String nsPrefix, @NonNull String nsURI) {
		Package pivotPackage = PivotFactory.eINSTANCE.createPackage();
		pivotPackage.setName(ePackage.getName());
		pivotPackage.setNsPrefix(nsPrefix);
		pivotPackage.setURI(nsURI);
		((PivotObjectImpl)pivotPackage).setTarget(ePackage);
		return pivotPackage;
	}

	public static @NonNull Package createPackage(@NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI, @Nullable PackageId packageId) {
		Package pivotPackage = PivotFactory.eINSTANCE.createPackage();
		pivotPackage.setName(name);
		pivotPackage.setNsPrefix(nsPrefix);
		if (packageId != null) {
			((PackageImpl)pivotPackage).setPackageId(packageId);  // FIXME Add to API
		}
		pivotPackage.setURI(nsURI);
		return pivotPackage;
	}

	public static @NonNull Parameter createParameter(@NonNull String name, @NonNull Type asType, boolean isRequired) {
		Parameter asParameter = PivotFactory.eINSTANCE.createParameter();
		asParameter.setName(name);
		asParameter.setType(asType);
		asParameter.setIsRequired(isRequired);
		return asParameter;
	}
	
	public static @NonNull Precedence createPrecedence(@NonNull String name, /*@NonNull*/ AssociativityKind kind) {
		assert kind != null;
		Precedence pivotPrecedence = PivotFactory.eINSTANCE.createPrecedence();
		pivotPrecedence.setName(name);
		pivotPrecedence.setAssociativity(kind);
		return pivotPrecedence;
	}
	
	public static @NonNull PrimitiveType createPrimitiveType(@NonNull String name) {
		PrimitiveType pivotType = PivotFactory.eINSTANCE.createPrimitiveType();
		pivotType.setName(name);
		return pivotType;
	}
	
	public static @NonNull Property createProperty(/*@NonNull*/ EStructuralFeature eFeature, @NonNull Type type) {
		Property pivotProperty = PivotFactory.eINSTANCE.createProperty();
		pivotProperty.setName(eFeature.getName());
		pivotProperty.setType(type);
		((PivotObjectImpl)pivotProperty).setTarget(eFeature);
		return pivotProperty;
	}
	
	public static @NonNull Property createProperty(@NonNull String name, @NonNull Type type) {
		Property pivotProperty = PivotFactory.eINSTANCE.createProperty();
		pivotProperty.setName(name);
		pivotProperty.setType(type);
		return pivotProperty;
	}

	public static @NonNull PropertyCallExp createPropertyCallExp(@NonNull OCLExpression asSource, @NonNull Property asProperty) {
		PropertyCallExp asChild = PivotFactory.eINSTANCE.createPropertyCallExp();
		asChild.setOwnedSource(asSource);
		asChild.setReferredProperty(asProperty);
		asChild.setType(asProperty.getType());
		asChild.setIsRequired(asProperty.isRequired());
		return asChild;
	}

	public static @NonNull SelfType createSelfType(@NonNull String name) {
		SelfType pivotType = PivotFactory.eINSTANCE.createSelfType();
		pivotType.setName(name);
		return pivotType;
	}

	public static @NonNull SequenceType createSequenceType(@NonNull SequenceType unspecializedType, @NonNull Type elementType) {
		return createCollectionType(PivotFactory.eINSTANCE.createSequenceType(), unspecializedType, elementType);
	}

	public static @NonNull SetType createSetType(@NonNull SetType unspecializedType, @NonNull Type elementType) {
		return createCollectionType(PivotFactory.eINSTANCE.createSetType(), unspecializedType, elementType);
	}

	public static @NonNull TemplateBinding createTemplateBinding(TemplateParameterSubstitution... templateParameterSubstitutions) {
		TemplateBinding pivotTemplateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		List<TemplateParameterSubstitution> parameterSubstitutions = pivotTemplateBinding.getOwnedSubstitutions();
		for (TemplateParameterSubstitution templateParameterSubstitution : templateParameterSubstitutions) {
			parameterSubstitutions.add(templateParameterSubstitution);
		}
		return pivotTemplateBinding;
	}

	public static @NonNull TemplateParameter createTemplateParameter(@NonNull String name, @Nullable org.eclipse.ocl.pivot.Class lowerBound, @Nullable org.eclipse.ocl.pivot.Class upperBound) {
		TemplateParameter pivotTemplateParameter = PivotFactory.eINSTANCE.createTemplateParameter();
		pivotTemplateParameter.setName(name);
		pivotTemplateParameter.setLowerBound(lowerBound);
		pivotTemplateParameter.setUpperBound(upperBound);
		return pivotTemplateParameter;
	}

	public static @NonNull TemplateParameterSubstitution createTemplateParameterSubstitution(@NonNull TemplateParameter formal, @NonNull Type actual) {
		TemplateParameterSubstitution pivotTemplateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
		pivotTemplateParameterSubstitution.setFormal(formal);
		pivotTemplateParameterSubstitution.setActual(actual);
		return pivotTemplateParameterSubstitution;
	}

	public static @NonNull TemplateSignature createTemplateSignature(@NonNull TemplateableElement templateableElement, TemplateParameter... templateParameters) {
		TemplateSignature pivotTemplateSignature = PivotFactory.eINSTANCE.createTemplateSignature();
		List<TemplateParameter> parameters = pivotTemplateSignature.getOwnedParameters();
		for (TemplateParameter templateParameter : templateParameters) {
			parameters.add(templateParameter);
		}
		pivotTemplateSignature.setOwningElement(templateableElement);
		return pivotTemplateSignature;
	}
	
	public static @NonNull TupleType createTupleType(@NonNull String name, Property... properties) {
		TupleType pivotType = PivotFactory.eINSTANCE.createTupleType();
		pivotType.setName(name);
		List<Property> ownedProperties = pivotType.getOwnedProperties();
		for (Property property : properties) {
			ownedProperties.add(property);
		}
		return pivotType;
	}

	public static @NonNull String createTupleValuedConstraint(@NonNull String statusText, @Nullable Integer severity, @Nullable String messageText) {
		if ((severity == null) && (messageText == null)) {
			return statusText;
		}
		StringBuilder s = new StringBuilder();
		s.append("Tuple {");
		if (messageText != null) {
			s.append("\n\t" + PivotConstantsInternal.MESSAGE_PART_NAME + " : String = " + messageText + ",");
		}
		if (severity != null) {
			s.append("\n\t" + PivotConstantsInternal.SEVERITY_PART_NAME + " : Integer = " + severity + ",");
		}
		s.append("\n\t" + PivotConstantsInternal.STATUS_PART_NAME + " : Boolean = " + statusText);		// NB parts in alphabetical order
		s.append("\n}."+ PivotConstantsInternal.STATUS_PART_NAME);
		@SuppressWarnings("null")@NonNull String string = s.toString();
		return string;
	}

	public static @NonNull Variable createVariable(@NonNull String name, @NonNull OCLExpression asInitExpression) {
		Variable asVariable = PivotFactory.eINSTANCE.createVariable();
		asVariable.setName(name);
		asVariable.setType(asInitExpression.getType());
		asVariable.setIsRequired(asInitExpression.isRequired());
		asVariable.setOwnedInit(asInitExpression);
		return asVariable;
	}

	public static @NonNull Variable createVariable(@NonNull String name, @NonNull Type asType, boolean isRequired, @Nullable OCLExpression asInitExpression) {
		Variable asVariable = PivotFactory.eINSTANCE.createVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(isRequired);
		asVariable.setOwnedInit(asInitExpression);
		return asVariable;
	}

	public static @NonNull VariableExp createVariableExp(@NonNull Variable asVariable) {
		VariableExp asVariableExp = PivotFactory.eINSTANCE.createVariableExp();
		asVariableExp.setReferredVariable(asVariable);
		asVariableExp.setType(asVariable.getType());
		asVariableExp.setIsRequired(asVariable.isRequired());
		return asVariableExp;
	}

	public static @NonNull VoidType createVoidType(@NonNull String name) {
		VoidType pivotType = PivotFactory.eINSTANCE.createVoidType();
		pivotType.setName(name);
		return pivotType;
	}

	public static void debugObjectUsage(String prefix, EObject element) {
		StringBuilder s = new StringBuilder();
		s.append(prefix);
		if (element != null) {
			s.append(element.eClass().getName());
			s.append("@");
			s.append(Integer.toHexString(element.hashCode()));
			Resource eResource = element.eResource();
			if (eResource != null) {
				if (element instanceof Element) {
					s.append(" ");
					s.append(AS2Moniker.toString((Element) element));
				}
				s.append(" ");
				s.append(eResource.getURI());
			}
			else if (element instanceof NamedElement) {
				s.append(" ");
				s.append(String.valueOf(((NamedElement) element).getName()));
			}
		}
		else {
			s.append("null");
		}
		System.out.println(s.toString());
	}

	public static boolean debugWellContainedness(Type type) {
		if (type.eResource() == null) {
			PivotUtilInternal.debugObjectUsage("Badly contained ", type);
			return false;
		}
		if (type instanceof CollectionType) {
			Type elementType = ((CollectionType)type).getElementType();
			if ((elementType != null) && !debugWellContainedness(elementType)) {
				PivotUtilInternal.debugObjectUsage("Badly contained ", type);
				return false;
			}
		}
		return true;
	}
	
	public static @Nullable MetaModelManager findMetaModelManager(@NonNull EObject eObject) {
		EObject eRoot = EcoreUtil.getRootContainer(eObject);
		if (eRoot != null) {
			Resource resource = eRoot.eResource();
			if (resource != null) {
//				if (eObject instanceof ElementCS) {
					AbstractMetaModelManagerResourceAdapter<?> adapter = AbstractMetaModelManagerResourceAdapter.findAdapter(resource);
					if (adapter != null) {
						return adapter.getMetaModelManager();
					}
//				}
				return findMetaModelManager(resource);
			}
		}
		return null;
	}

	public static @Nullable MetaModelManager findMetaModelManager(@NonNull Resource resource) {
		for (Adapter adapter : resource.eAdapters()) {
			if (adapter instanceof AbstractMetaModelManagerResourceAdapter) {
				return ((AbstractMetaModelManagerResourceAdapter<?>)adapter).getMetaModelManager();
			}
		}
		ResourceSet resourceSet = resource.getResourceSet();
		return resourceSet != null ? findMetaModelManager(resourceSet) : null;
	}

	public static MetaModelManager findMetaModelManager(@NonNull ResourceSet resourceSet) {
		MetaModelManager metaModelManager = MetaModelManager.findAdapter(resourceSet);
		if (metaModelManager != null) {
			return metaModelManager;
		}
		MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
		if (adapter != null) {
			return adapter.getMetaModelManager();
		}
		return null;
	}

	public static Type findTypeOf(@NonNull MetaModelManager metaModelManager, @NonNull EClassifier eClass) {
		Resource resource = eClass.eResource();
		if (resource != null) {
			Ecore2AS adapter = Ecore2AS.findAdapter(resource, metaModelManager);
			if (adapter != null) {
				Type type = adapter.getCreated(Type.class, eClass);
				if (type != null) {
					return type;
				}
			}
		}
		return null;
	}

	@SuppressWarnings("null")
	public static @NonNull URI getASURI(@NonNull URI uri) {
		if (uri.fragment() != null) {
			logger.error("Unexpected fragment ignored for '" + uri.toString() + "'");
			uri = uri.trimFragment();
		}
		URI asURI = uri.appendFileExtension(PivotConstantsInternal.OCL_AS_FILE_EXTENSION);
		if (!isASURI(asURI)) {
			asURI = uri.appendSegment(PivotConstantsInternal.DOT_OCL_AS_FILE_EXTENSION);
		}
		assert isASURI(asURI);
		return asURI;
	}

	public static @NonNull Attribution getAttribution(@NonNull EObject eObject) {
		if (eObject.eIsProxy()) {			// Shouldn't happen, but certainly does during development
			logger.warn("getAttribution for proxy " + eObject);
			return NullAttribution.INSTANCE;
		}
		else {
			EClass eClass = eObject.eClass();
			Attribution attribution = Attribution.REGISTRY.get(eClass);
			if (attribution == null) {
				for (EClass superClass = eClass; superClass.getESuperTypes().size() > 0;) {
					superClass = superClass.getESuperTypes().get(0);
					attribution = Attribution.REGISTRY.get(superClass);
					if (attribution != null) {
						break;
					}
				}
				if (attribution == null) {
					attribution = NullAttribution.INSTANCE;
				}
				Attribution.REGISTRY.put(eClass, attribution);
			}
			return attribution;
		}
	}

	@Deprecated // Use getType
	public static @NonNull Type getBehavioralType(@NonNull Type type) {		// FIXME fold this into normal code
		if (type instanceof DataType) {
			DataType dataType = (DataType)type;
			Type behavioralType = dataType.getBehavioralClass();
			if (behavioralType != null) {
				return behavioralType;
			}
		}
		return type;
	}

	@Deprecated // Use getType
	public static @NonNull Type getBehavioralType(@NonNull TypedElement element) {
		return PivotUtilInternal.getBehavioralType(ClassUtil.nonNullState(element.getType()));
	}

	/**
	 * Trim a surrounding "result=(...)" to convert a UML BodyCondition to an OCL BodyExpression.
	 */
	@SuppressWarnings("null")
	public static @NonNull String getBodyExpression(@NonNull String umlBody) {
		String s = umlBody.trim();
		if (s.startsWith(PivotConstants.RESULT_NAME)) {
			s = s.substring(6).trim();
			if (s.startsWith("=")) {
				s = s.substring(1).trim();
				if (s.startsWith("(") && s.endsWith(")")) {
					s = s.substring(1, s.length()-1); //.trim();
				}
				return s;
			}
		}
		return umlBody;
	}

	/**
	 * Return the number of containers of eObject, 0 if eObject is a root.
	 */
	public static int getContainmentDepth(EObject eObject) {
		int depth = 0;
		for (EObject eContainer = eObject.eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
			depth++;
			if (depth > 100000) {
				return depth;
			}
		}
		return depth;
	}

	public static @NonNull Evaluator getEvaluator(@NonNull EObject eObject) {
		Resource asResource = eObject.eResource();
		if (asResource != null) {
			MetaModelManager metaModelManager = findMetaModelManager(asResource);
			if (metaModelManager != null) {
				return new PivotExecutorManager(metaModelManager, eObject);
			}
		}
		return new EcoreExecutorManager(eObject, PivotTables.LIBRARY);
	}

	public static @NonNull MetaModelManager getMetaModelManager(@NonNull Resource resource) {
		MetaModelManager metaModelManager = findMetaModelManager(resource);
		if (metaModelManager == null) {
			MetaModelManagerResourceAdapter adapter = MetaModelManagerResourceAdapter.getAdapter(resource, null);
			metaModelManager = adapter.getMetaModelManager();
			assert metaModelManager != null;
			ResourceSet resourceSet = resource.getResourceSet();
			if ((resourceSet != null) && (findMetaModelManager(resourceSet) == null)) {
				MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
			}
		}
		return metaModelManager;
	}

	@SuppressWarnings("null")
	public static @NonNull URI getNonASURI(@NonNull URI uri) {
		assert isASURI(uri);
		return uri.trimFileExtension();
	}

	public static @NonNull <T extends Element> T getNonNullAst(@NonNull Class<T> pivotClass, @NonNull Pivotable pivotableElement) {
//		if (pivotableElement == null) {
//			return null;
//		}
		Element pivotElement = pivotableElement.getPivot();
		if (pivotElement == null) {
			throw new IllegalStateException("Null pivotElementfor a " + pivotClass.getName());
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException(pivotElement.getClass().getName() + " is not assignable to " + pivotClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	/**
	 * Return a URI based on the nsURI of the immediate parent package.
	 */
	public static String getNsURI(@NonNull EModelElement element) {
		if (element instanceof EPackage) {
			String nsURI = ((EPackage)element).getNsURI();
			if (nsURI != null) {
				return nsURI;
			}
		}
		StringBuilder s = new StringBuilder();
		getNsURI(s, element);
		return s.toString();
	}

	/**
	 * Return a URI based on the nsURI of the immediate parent package.
	 */
	public static String getNsURI(@NonNull Element element) {
		if (element instanceof org.eclipse.ocl.pivot.Package) {
			String nsURI = ((org.eclipse.ocl.pivot.Package)element).getURI();
			if (nsURI != null) {
				return nsURI;
			}
		}
		StringBuilder s = new StringBuilder();
		s.append("u_r_i:");
		getNsURI(s, element);
		return s.toString();
	}

	private static void getNsURI(@NonNull StringBuilder s, @NonNull EObject element) {
		if (element instanceof org.eclipse.ocl.pivot.Package) {
			String nsURI = ((org.eclipse.ocl.pivot.Package)element).getURI();
			if (nsURI != null) {
				s.append(nsURI);
				return;
			}
		}
		else if (element instanceof Model) {
			String nsURI = ((Model)element).getExternalURI();
			if (nsURI != null) {
				s.append(nsURI);
				return;
			}
		}
		else if (element instanceof EPackage) {
			String nsURI = ((EPackage)element).getNsURI();
			if (nsURI != null) {
				s.append(nsURI);
				return;
			}
		}
		EObject eContainer = element.eContainer();
		if ((eContainer instanceof org.eclipse.ocl.pivot.Package) || (eContainer instanceof Model)) {
			String nsURI = ((org.eclipse.ocl.pivot.Package)element).getURI();
			if (nsURI != null) {
				s.append(nsURI);
				s.append("#/");
			}
			else {
				@SuppressWarnings("null")
				@NonNull EObject eContainer2 = eContainer;
				getNsURI(s, eContainer2);
			}
		}
		else if (eContainer instanceof EPackage) {
			String nsURI = ((EPackage)element).getNsURI();
			if (nsURI != null) {
				s.append(nsURI);
				s.append("#/");
			}
			else {
				getNsURI(s, eContainer);
			}
		}
		else if (eContainer == null) {
			String name = null;
			if (element instanceof org.eclipse.ocl.pivot.Package) {
				name = ((org.eclipse.ocl.pivot.Package)element).getName();
			}
			else if (element instanceof EPackage) {
				name = ((EPackage)element).getName();
			}
			if (name == null) {
				name = "$null$";
			}
			s.append(name);
			return;
		}
		else {
			getNsURI(s, eContainer);
		}
		EReference eFeature = element.eContainmentFeature();
		s.append("@");
		s.append(eFeature.getName());
		if (eFeature.isMany()) {
			int index = ((List<?>) eContainer.eGet(element.eContainingFeature())).indexOf(element);
			s.append(".");
			s.append(index);
		}
	}

	public static @Nullable <T extends Element> T getPivot(@NonNull Class<T> pivotClass, @Nullable Pivotable pivotableElement) {
		if (pivotableElement == null) {
			return null;
		}
		Element pivotElement = pivotableElement.getPivot();
		if (pivotElement == null) {
			return null;
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException(pivotElement.getClass().getName() + " is not assignable to " + pivotClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	public static String getSpecificationRole(@NonNull LanguageExpression specification) {
		EReference eContainmentFeature = specification.eContainmentFeature();
		if (eContainmentFeature == PivotPackage.Literals.NAMESPACE__OWNED_CONSTRAINTS) {
			return PivotConstantsInternal.OWNED_CONSTRAINT_ROLE;
		}
		else if (eContainmentFeature == PivotPackage.Literals.PROPERTY__OWNED_EXPRESSION) {
			return PivotConstantsInternal.DEFAULT_EXPRESSION_ROLE;
		}
		else if (eContainmentFeature == PivotPackage.Literals.OPERATION__BODY_EXPRESSION) {
			return PivotConstantsInternal.BODY_EXPRESSION_ROLE;
		}
		else if (eContainmentFeature == PivotPackage.Literals.OPERATION__OWNED_PRECONDITIONS) {
			return PivotConstantsInternal.PRECONDITION_ROLE;
		}
		else if (eContainmentFeature == PivotPackage.Literals.OPERATION__OWNED_POSTCONDITIONS) {
			return PivotConstantsInternal.POSTCONDITION_ROLE;
		}
		else {
			return PivotConstantsInternal.UNKNOWN_ROLE;
		}
	}

	public static String getStereotype(@NonNull Constraint object) {
		EStructuralFeature eContainingFeature = object.eContainingFeature();
		if (eContainingFeature == PivotPackage.Literals.CLASS__OWNED_INVARIANTS) {
			return PivotConstants.INVARIANT_NAME;
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__BODY_EXPRESSION) {
			return PivotConstants.BODY_NAME;
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__OWNED_POSTCONDITIONS) {
			return PivotConstants.POSTCONDITION_NAME;
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__OWNED_PRECONDITIONS) {
			return PivotConstants.PRECONDITION_NAME;
		}
		else if (eContainingFeature == PivotPackage.Literals.PROPERTY__OWNED_EXPRESSION) {
			return PivotConstants.DERIVATION_NAME;
		}
		return "";
	}

	public static @Nullable Type getType(@Nullable TypedElement typedElement) {
		if (typedElement == null) {
			return null;
		}
		Type type = typedElement.getType();
		if (type == null) {
			return null;
		}
		type = getType(type);
		if (type instanceof SelfType) {
			if (typedElement instanceof Parameter) {
				Operation operation = ((Parameter)typedElement).getOwningOperation();
				if (operation != null) {
					org.eclipse.ocl.pivot.Class selfType = operation.getOwningClass();
					if (selfType != null) {
						type = selfType;
					}
				}
			}
		}
		return type;
	}

	public static @NonNull Type getType(@NonNull Type type) {
		if (type instanceof LambdaType) {
			Type resultType = ((LambdaType)type).getResultType();
			if (resultType != null) {
				type = resultType;
			}
		}
		else if (type instanceof DataType) {
			Type behavioralType = ((DataType)type).getBehavioralClass();
			if (behavioralType != null) {
				type = behavioralType;
			}
		}
		return type;
	}

	public static @NonNull Operation initOperation(@NonNull Operation asOperation, @NonNull ExpressionInOCL asExpressionInOCL) {
		for (Variable asParameterVariable : asExpressionInOCL.getOwnedParameters()) {
			String parameterName = ClassUtil.nonNullState(asParameterVariable.getName());
			Type parameterType = ClassUtil.nonNullState(asParameterVariable.getType());
			Parameter asParameter = createParameter(parameterName, parameterType, asParameterVariable.isRequired());
			asParameterVariable.setRepresentedParameter(asParameter);
			asOperation.getOwnedParameters().add(asParameter);
		}
		asOperation.setBodyExpression(asExpressionInOCL);
		asOperation.setType(asExpressionInOCL.getType());
		asOperation.setIsRequired(asExpressionInOCL.isRequired());
		return asOperation;
	}

	public static boolean isASURI(@Nullable String uri) {
		return (uri != null) && uri.endsWith("as");
	}

	public static boolean isASURI(@Nullable URI uri) {
		return (uri != null) && isASURI(uri.toString());
	}

	public static boolean isLibraryType(@NonNull Type type) {	// FIXME org.eclipse.ocl.pivot.Class
		if (type instanceof LambdaType) {
			return false;
		}
		else if (type instanceof TupleType) {
			return false;			
		}
		else if (type instanceof TemplateableElement){
			return ((TemplateableElement)type).getOwnedBindings().isEmpty();			
		}
		else {
			return false;
		}
	}
	
	public static boolean isValidIdentifier(@Nullable String value) {
		if (value == null) {
			return false;
		}
		int iMax = value.length();
		for (int i = 0; i < iMax; i++) {
			char c = value.charAt(i);
			if (('A' <= c) && (c <= 'Z')) {					
			}
			else if (('a' <= c) && (c <= 'z')) {					
			}
			else if (c == '_') {					
			}
			else if (('0' <= c) && (c <= '9') && (i > 0)) {					
			}
			else {
				return false;
			}
		}
		return true;
	}

	public static <T extends EObject> void refreshList(@Nullable List<? super T> oldElements, @Nullable List<? extends T> newElements) {
		if (oldElements == null) {
			return;			// Never happens but avoids need for null validation in caller
		}
		if (newElements == null) {
			if (oldElements.size() > 0) {
				oldElements.clear();
			}
			return;
		}
		for (int k = newElements.size(); k-- > 0; ) {
			T newElement = newElements.get(k);
			if (newElement.eIsProxy()) {
				oldElements.remove(newElement);			// Lose oldContent before adding possible 'duplicates'
			}
		}
		for (int k = oldElements.size(); k-- > 0; ) {
			Object oldElement = oldElements.get(k);
			if (!newElements.contains(oldElement)) {
				oldElements.remove(k);			// Lose oldContent before adding possible 'duplicates'
			}
		}
		int newMax = newElements.size();
		for (int i = 0; i < newMax; i++) {					// Invariant: lists are equal up to index i
			T newElement = newElements.get(i);
			int oldMax = oldElements.size();
			boolean reused = false;;
			for (int j = i; j < oldMax; j++) {
				Object oldElement = oldElements.get(j);
				if (oldElement == newElement) {
					if (j != i) {
						oldElements.remove(j);
						oldElements.add(i, newElement);
					}
					reused = true;
					break;
				}
			}
			if (!reused) {
				if (i < oldMax) {
					oldElements.add(i, newElement);
				}
				else {
					oldElements.add(newElement);
				}
			}
			assert newElements.get(i) == oldElements.get(i);
		}
		for (int k = oldElements.size(); k > newMax; ) {
			oldElements.remove(--k);
		}
		assert newElements.size() == oldElements.size();
	}

	public static <T extends EObject> void refreshSet(@Nullable List<? super T> oldElements, @Nullable Collection<? extends T> newElements) {
		if (oldElements == null) {
			return;			// Never happens but avoids need for null validation in caller
		}
		if (newElements == null) {
			oldElements.clear();
			return;
		}
		for (int i = oldElements.size(); i-- > 0;) {	// Remove any oldElements not in newElements
			Object oldElement = oldElements.get(i);
			if (!newElements.contains(oldElement)) {
				oldElements.remove(i);
			}
		}
		for (T newElement : newElements) {				// Add any newElements not in oldElements
			if (!newElement.eIsProxy() && !oldElements.contains(newElement)) {
				oldElements.add(newElement);
			}
		}
	}

	/**
	 * Detach object from its container so that a child-stealing detection is avoided when attaching to a new container.
	 */
	public static void resetContainer(@NonNull EObject eObject) {
		EStructuralFeature eContainingFeature = eObject.eContainingFeature();
		if (eContainingFeature != null) {
			EObject eContainer = eObject.eContainer();
			if (eContainer != null) {
				if (!eContainingFeature.isMany()) {
					eContainer.eSet(eContainingFeature, null);
				}
				else {
					Object objects = eContainer.eGet(eContainingFeature);
					if (objects instanceof List<?>) {
						((List<?>)objects).remove(eObject);
					}
				}
			}
		}
	}

	/**
	 * Define oclExpression as the bodyExpression of an expressionInOCL, and if non-null
	 * also define stringExpression as the OCL-languaged body.
	 */
	public static void setBody(@NonNull ExpressionInOCL expressionInOCL, @Nullable OCLExpression oclExpression, @Nullable String stringExpression) {
		setBody(expressionInOCL, stringExpression);
		expressionInOCL.setOwnedBody(oclExpression);
	}

	/**
	 * Define oclExpression as the bodyExpression of an expressionInOCL, and if non-null
	 * also define stringExpression as the OCL-languaged body.
	 */
	@Deprecated
	public static void setBody(@NonNull ExpressionInOCL opaqueExpression, @Nullable String stringExpression) {
		opaqueExpression.setBody(stringExpression);
	}

	/**
	 * Configure resource to support parsing in the context of an eObject. Throws a ParserException
	 * if a pivot element cannot be identified for eObject.eClass(). Return false if a pivot element
	 * can be identified, but it is not one that supports constraint parsing.
	 *
	 * @throws ParserException if eObject cannot be converted to a Pivot element
	 */
	public static boolean setParserContext(@NonNull BaseResource resource, @NonNull EObject eObject, Object... todoParameters) throws ParserException {
		AbstractMetaModelManagerResourceAdapter<?> adapter = MetaModelManagerResourceAdapter.findAdapter(resource);
		MetaModelManager metaModelManager = adapter != null ? adapter.getMetaModelManager() : null;
		if (metaModelManager == null) {
			ResourceSet resourceSet = ClassUtil.nonNullState(resource.getResourceSet());
			metaModelManager = MetaModelManager.getAdapter(resourceSet);
		}
		Element pivotElement;
		if (eObject instanceof Element) {
			pivotElement = (Element) eObject;
		}
		else {
			pivotElement = metaModelManager.getPivotOf(Element.class, eObject);
			if ((eObject instanceof org.eclipse.uml2.uml.Constraint) && (pivotElement instanceof Constraint) && (pivotElement.eContainer() == null)) {
				pivotElement = metaModelManager.getPivotOf(Element.class, ((org.eclipse.uml2.uml.Constraint)eObject).getSpecification());
			}
		}
		if (pivotElement == null) {
			return false;
		}
		ParserContext parserContext = metaModelManager.getParserContext(pivotElement, todoParameters);
		if (parserContext == null) {
			return false;
		}
		else {
			resource.setParserContext(parserContext);
			return true;
		}
	}
}
