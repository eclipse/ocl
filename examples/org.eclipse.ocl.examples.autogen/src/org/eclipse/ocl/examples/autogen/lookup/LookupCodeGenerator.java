/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (University of York) - Lookup Environment/Visitor
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.lookup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoCG2StringVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaPreVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.library.NativeProperty;
import org.eclipse.ocl.examples.codegen.library.NativeStaticOperation;
import org.eclipse.ocl.examples.codegen.library.NativeVisitorOperation;
import org.eclipse.ocl.examples.codegen.utilities.RereferencingCopier;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLASResourceFactory;

/**
 * LookupCodeGenerator supports generation of the content of a JavaClassFile for the Lookup visitor.
 */
public class LookupCodeGenerator extends AutoCodeGenerator
{	
	public static void generate(@NonNull GenPackage genPackage,
			@NonNull String projectPrefix,	// FIXME Since visitors/visitable package/name are really configured in the MWE file
			@NonNull String projectName,	// there is no point of providing a different to compute it here. To improve the framework, make use of the
			@NonNull String lookupFilePath,
			@NonNull String visitorPackage,	// genModel base logic in the whole framework simplyfying the number of parameters to deal with. Then, these parameters may be removed
			@NonNull String visitorClass,
			@NonNull String visitableClass,
			@Nullable String superProjectPrefix,
			@Nullable String superProjectName,
			@Nullable String superVisitorClass,
			@Nullable String baseProjectPrefix,
			@Nullable String baseVisitorPackage) {
		EPackage ePackage = genPackage.getEcorePackage();
		assert ePackage != null;

		AutoCG2StringVisitor.FACTORY.getClass();

		Resource eResource = ClassUtil.nonNullState(ePackage.eResource());
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(eResource);
		
		for (org.eclipse.ocl.pivot.Package oclDocPackage : LookupCGUtil.getTargetPackages(genPackage,environmentFactory, lookupFilePath, projectName, projectPrefix)){
			org.eclipse.ocl.pivot.Package asSuperPackage = null;
			if (superProjectPrefix != null) {
				asSuperPackage = LookupCGUtil.getPackage(genPackage, superProjectPrefix, environmentFactory);
				if (asSuperPackage == null) {
					throw new IllegalStateException("No super-GenPackage found in UsedGenPackages for " + superProjectPrefix);
				}
			}
			org.eclipse.ocl.pivot.Package basePackage = oclDocPackage;
			if (baseProjectPrefix != null) {
				basePackage = LookupCGUtil.getPackage(genPackage, baseProjectPrefix, environmentFactory);
				if (basePackage == null) {
					throw new IllegalStateException("No super-GenPackage found in UsedGenPackages for " + superProjectPrefix);
				}
			}
			AutoCodeGenerator autoCodeGenerator = new LookupCodeGenerator(environmentFactory, oclDocPackage, asSuperPackage, basePackage, genPackage, // superGenPackage,
					projectPrefix, projectName, visitorPackage, visitorClass, visitableClass, superProjectPrefix, superProjectName, superVisitorClass,
					baseProjectPrefix, baseVisitorPackage);
			autoCodeGenerator.saveSourceFile();
		}
	}
	
	protected final @NonNull String packageName;
	protected final @NonNull String className;
	protected final @NonNull LookupClassContext classContext;
	protected final @NonNull AS2CGVisitor as2cgVisitor;
	//
	//	Expected AS elements
	//
	protected final @NonNull Operation asElementParentEnvOperation;
	protected final @NonNull Operation asEnvironmentHasFinalResultOperation;
	protected final @NonNull Operation asEnvironmentNestedEnvOperation;
	protected final @NonNull Operation asEnvironmentAddElementsOfElementOperation;
	protected final @NonNull Operation asEnvironmentAddElementsOfElementsOperation;
	protected final @NonNull Operation asElementEnvOperation;
	
	protected final @NonNull org.eclipse.ocl.pivot.Class asEnvironmentType;
	
	//
	//	New AS elements
	//
	protected final @NonNull org.eclipse.ocl.pivot.Class asVisitorClass;
	protected final @NonNull Variable asThisVariable;
	protected final @NonNull Variable asContextVariable;
	protected final @NonNull Property asChildProperty;
	protected final @NonNull Property asEvaluatorProperty;
	protected final @NonNull Property asIdResolverProperty;
	protected final @NonNull Operation asVisitorEnvOperation;
	protected final @NonNull Operation asVisitorParentEnvOperation;
	protected final @NonNull Operation asVisitorEnvForChildOperation;
	
	
	//
	//	Important CG elements
	//
	private @Nullable CGProperty cgEvaluatorVariable = null;
	private @Nullable CGProperty cgIdResolverVariable = null;
	private @Nullable CGProperty cgChildVariable = null;

	protected LookupCodeGenerator(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull org.eclipse.ocl.pivot.Package asPackage,
			@Nullable org.eclipse.ocl.pivot.Package asSuperPackage, @NonNull org.eclipse.ocl.pivot.Package asBasePackage, @NonNull GenPackage genPackage,
			@NonNull String projectPrefix, @NonNull String projectName, @NonNull String visitorPackage, @NonNull String visitorClass, @NonNull String visitableClass,
			@Nullable String superProjectPrefix, @Nullable String superManualVisitorPackage, @Nullable String superVisitorClass,
			@Nullable String baseVisitorPrefix, @Nullable String baseVisitorPackage) {
		super(environmentFactory, asPackage, asSuperPackage, genPackage, projectPrefix, projectName,
			visitorPackage, visitorClass, visitableClass, superProjectPrefix, superManualVisitorPackage, superVisitorClass,
			baseVisitorPrefix, baseVisitorPackage);
		this.packageName = getVisitorPackageName(projectName); 
		this.className = getAutoVisitorClassName(projectPrefix);
		this.classContext = new LookupClassContext(this, asPackage);
		this.as2cgVisitor = createAS2CGVisitor();
		//
		//	Find expected AS elements
		//
		// FIXME Bad. This is PIVOT dependent code which means that the LookupCodeGenerator can only work with pivot-based lookup descriptions
		ParametersId emptyParametersId = IdManager.getParametersId();
		org.eclipse.ocl.pivot.Class asOclElement = metamodelManager.getStandardLibrary().getOclElementType();
		
		// org.eclipse.ocl.pivot.Class asOclAny = metamodelManager.getStandardLibrary().getOclAnyType();
		CompleteClass asElementCompleteClass = metamodelManager.getCompletePackage(metamodelManager.getStandardLibrary().getPackage()).getCompleteClass(asOclElement);
		OperationId envOperationId = asOclElement.getTypeId().getOperationId(0, LookupClassContext.ENV_NAME, IdManager.getParametersId(asOclElement.getTypeId()));
		this.asElementEnvOperation = ClassUtil.nonNullState(asElementCompleteClass.getOperation(envOperationId));
		OperationId parentEnvOperationId = asOclElement.getTypeId().getOperationId(0, LookupClassContext.PARENT_ENV_NAME, emptyParametersId);
		this.asElementParentEnvOperation = ClassUtil.nonNullState(asElementCompleteClass.getOperation(parentEnvOperationId));
		this.asEnvironmentType = ClassUtil.nonNullState(asElementParentEnvOperation.getType().isClass());
		CompleteClass asEnvironmentCompleteClass = metamodelManager.getCompleteClass(asEnvironmentType);
		OperationId nestedEnvOperationId = asEnvironmentType.getTypeId().getOperationId(0, LookupClassContext.NESTED_ENV_NAME, emptyParametersId);
		this.asEnvironmentNestedEnvOperation = ClassUtil.nonNullState(asEnvironmentCompleteClass.getOperation(nestedEnvOperationId));
		OperationId hasFinalResultOperationId = asEnvironmentType.getTypeId().getOperationId(0, LookupClassContext.HAS_FINAL_RESULT_NAME, emptyParametersId);
		this.asEnvironmentHasFinalResultOperation = ClassUtil.nonNullState(asEnvironmentCompleteClass.getOperation(hasFinalResultOperationId));
		OperationId addElementsOfElementOperationId = asEnvironmentCompleteClass.getPrimaryClass().getTypeId()
				.getOperationId(0, LookupClassContext.ADD_ELEMENTS_OF_NAME, IdManager.getParametersId(asOclElement.getTypeId()));
		asEnvironmentAddElementsOfElementOperation = ClassUtil.nonNullState(asEnvironmentCompleteClass.getOperation(addElementsOfElementOperationId));
		CollectionTypeId col = IdManager.getCollectionTypeId("Collection");
		OperationId addElementsOfElementsOperationId = asEnvironmentCompleteClass.getPrimaryClass().getTypeId()				
				.getOperationId(0, LookupClassContext.ADD_ELEMENTS_OF_NAME, IdManager.getParametersId(col.getSpecializedId(asOclElement.getTypeId())));
		asEnvironmentAddElementsOfElementsOperation = ClassUtil.nonNullState(asEnvironmentCompleteClass.getOperation(addElementsOfElementsOperationId));
		//
		//	Create new AS elements
		//
		this.asVisitorClass = createASVisitorClass(packageName, className);
		this.asThisVariable = PivotUtil.createVariable("this", asVisitorClass, true, null);
		this.asContextVariable = PivotUtil.createVariable(LookupClassContext.CONTEXT_NAME, asEnvironmentType, true, null);
		CGVariable cgVariable = as2cgVisitor.getVariable(asContextVariable);
		nameManager.reserveName(LookupClassContext.CONTEXT_NAME, cgVariable);
		//
		//	Create new AS Visitor helper properties
		//
		this.asChildProperty = createNativeProperty(LookupClassContext.CHILD_NAME, asOclElement, false);
		this.asEvaluatorProperty = createNativeProperty(JavaConstants.EXECUTOR_NAME, Executor.class, true);
		this.asIdResolverProperty = createNativeProperty(JavaConstants.ID_RESOLVER_NAME, IdResolver.class, true);
		List<Property> asVisitorProperties = asVisitorClass.getOwnedProperties();
		asVisitorProperties.add(asChildProperty);
		asVisitorProperties.add(asEvaluatorProperty);
		asVisitorProperties.add(asIdResolverProperty);
		//
		//	Create new AS Visitor helper operations
		//
		this.asVisitorEnvOperation = PivotUtil.createOperation(LookupClassContext.ENV_NAME, asEnvironmentType, null, null);
		asVisitorEnvOperation.getOwnedParameters().add(PivotUtil.createParameter(LookupClassContext.ELEMENT_NAME, asOclElement, true));
		asVisitorEnvOperation.getOwnedParameters().add(PivotUtil.createParameter(LookupClassContext.CHILD_NAME, asOclElement, false));
		this.asVisitorParentEnvOperation = PivotUtil.createOperation(LookupClassContext.PARENT_ENV_NAME, asEnvironmentType, null, null);
		asVisitorParentEnvOperation.getOwnedParameters().add(PivotUtil.createParameter(LookupClassContext.ELEMENT_NAME, asOclElement, true));
		asVisitorParentEnvOperation.setImplementation(NativeStaticOperation.INSTANCE);
		asVisitorParentEnvOperation.setIsRequired(false);
		this.asVisitorEnvForChildOperation = PivotUtil.createOperation(LookupClassContext.ENV_FOR_CHILD_NAME, asEnvironmentType, null, null);
		asVisitorEnvForChildOperation.getOwnedParameters().add(PivotUtil.createParameter(LookupClassContext.ELEMENT_NAME, asOclElement, true));
		asVisitorEnvForChildOperation.getOwnedParameters().add(PivotUtil.createParameter(LookupClassContext.CHILD_NAME, asOclElement, true));
		asVisitorEnvForChildOperation.setImplementation(NativeStaticOperation.INSTANCE);
		asVisitorEnvForChildOperation.setIsRequired(false);
		List<Operation> asVisitorOperations = asVisitorClass.getOwnedOperations();
		asVisitorOperations.add(asVisitorEnvOperation);
		asVisitorOperations.add(asVisitorParentEnvOperation);
		asVisitorOperations.add(asVisitorEnvForChildOperation);
	}

	/**
	 * Convert the asOperations to cgOperations of cgClass.
	 */
	protected void convertOperations(@NonNull CGClass cgClass, @NonNull Collection<Operation> asOperations) {
		List<Operation> sortedOperations = new ArrayList<Operation>(asOperations);
		Collections.sort(sortedOperations, NameUtil.NAMEABLE_COMPARATOR);
		for (Operation asOperation : sortedOperations) {
			CGOperation cgOperation = as2cgVisitor.doVisit(CGOperation.class, asOperation);
			cgClass.getOperations().add(cgOperation);					
		}
	}

	/**
	 * Convert the asProperties to cgProperties of cgClass.
	 */
	protected void convertProperties(@NonNull CGClass cgClass, @NonNull List<Property> asProperties) {
		for (Property asProperty : asProperties) {
			CGProperty cgProperty = as2cgVisitor.doVisit(CGProperty.class, asProperty);
			cgClass.getProperties().add(cgProperty);	
			if (asProperty == asEvaluatorProperty) {
				cgEvaluatorVariable = cgProperty;
			}
			else if (asProperty == asIdResolverProperty) {
				cgIdResolverVariable = cgProperty;
			}
			else if (asProperty == asChildProperty) {
				cgChildVariable = cgProperty;
			}
		}
	}

	/**
	 * Convert the construction context to supertypes/interfaces of cgClass.
	 */
	protected void convertSuperTypes(@NonNull CGClass cgClass) {
		// GenPackage superGenPackage2 = superGenPackage;
		String superProjectPrefix2 = superProjectPrefix;
		CGClass cgEnvironmentClass = getExternalClass(asEnvironmentType);
		if (superProjectPrefix2 != null) {
			// String superPackageName = super
			String superPackageName = getManualVisitorPackageName(ClassUtil.nonNullState(superManualVisitorPackage));
			// String superClassName = superGenPackage2.getPrefix() + "AutoContainmentVisitor";
			String superClassName = getManualVisitorClassName(superProjectPrefix2);
			// String superInterfaceName = /*trimmed*/prefix + "Visitor";
			String superInterfaceName = visitorClass;
			
			CGClass superClass = getExternalClass(superPackageName, superClassName, false);
			cgClass.getSuperTypes().add(superClass);
			CGClass superInterface = getExternalClass(visitorPackage, superInterfaceName, true);
			superInterface.getTemplateParameters().add(cgEnvironmentClass);
			cgClass.getSuperTypes().add(superInterface);
		}
		else {
			// String superClassName = "Abstract" + /*trimmed*/prefix + "CSVisitor";
//			String superClassName = "AbstractExtending" + visitorClass; // The default Abstract Visitor generated for the language
			String superClassName = "AbstractExtendingVisitor"; // The default Abstract Visitor generated for the language
			CGClass superClass = getExternalClass(visitorPackage, superClassName, false);
			superClass.getTemplateParameters().add(cgEnvironmentClass);
			superClass.getTemplateParameters().add(cgEnvironmentClass);
			cgClass.getSuperTypes().add(superClass);
		}
	}

	protected @NonNull org.eclipse.ocl.pivot.Class createASVisitorClass(@NonNull String packageName, @NonNull String className) {
		org.eclipse.ocl.pivot.Class asVisitorClass = PivotUtil.createClass(className);
		String nsURI = "java://"+packageName;		// java: has no significance other than diagnostic readability
		org.eclipse.ocl.pivot.Package asVisitorPackage = PivotUtil.createPackage(packageName, "viz", nsURI, IdManager.getRootPackageId(nsURI));
		asVisitorPackage.getOwnedClasses().add(asVisitorClass);
		Model asVisitorRoot = PivotUtil.createModel(nsURI + ".java");
		asVisitorRoot.getOwnedPackages().add(asVisitorPackage);
		metamodelManager.installRoot(asVisitorRoot);
		return asVisitorClass;
	}

	@Override
	protected @NonNull LookupCG2JavaVisitor createCG2JavaVisitor(@NonNull CGPackage cgPackage, @Nullable List<CGValuedElement> sortedGlobals) {
		return new LookupCG2JavaVisitor(this, cgPackage, sortedGlobals);
	}

	@Override
	public @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor() {
		return new AutoCG2JavaPreVisitor(classContext);
	}

	/**
	 * Synthesize an AS package by simple AS2AS conversions and convert the AS package to a CG package for onward code generation. 
	 * @throws ParserException 
	 */
	@Override
	protected @NonNull CGPackage createCGPackage() throws ParserException {
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		cgPackage.setName(visitorPackage);
		CGClass cgClass = CGModelFactory.eINSTANCE.createCGClass();
		cgClass.setName(className);
		convertSuperTypes(cgClass);
		cgPackage.getClasses().add(cgClass);
		convertProperties(cgClass, asVisitorClass.getOwnedProperties());
		Map<Element,Element> reDefinitions = new HashMap<Element,Element>();
		Map<Operation, Operation> envOperation2asOperation = createVisitOperationDeclarations(reDefinitions);
		rewriteVisitOperationBodies(reDefinitions, envOperation2asOperation);
		Collection<Operation> asOperations = envOperation2asOperation.values();
		if (asOperations != null) {
			rewriteOperationCalls(asOperations);
			convertOperations(cgClass, asOperations);
		}
		Resource dummyResource = EssentialOCLASResourceFactory.getInstance().createResource(URI.createURI("dummy.essentialocl"));
		dummyResource.getContents().addAll(asOperations);		// PrettyPrinter needs containment
		return cgPackage;
	}

	protected @NonNull Property createNativeProperty(@NonNull String name, @NonNull Type asElementType, boolean isReadOnly) {
		Property asChildProperty = PivotUtil.createProperty(name, asElementType);
		asChildProperty.setImplementation(NativeProperty.INSTANCE);
		asChildProperty.setIsReadOnly(isReadOnly);
		asChildProperty.setIsRequired(isReadOnly);
		return asChildProperty;
	}

	protected @NonNull Property createNativeProperty(@NonNull String name, @NonNull Class<?> javaClass, boolean isReadOnly) {
		Package javaPackage = javaClass.getPackage();
		@SuppressWarnings("null")@NonNull String packageName = javaPackage.getName();
		@SuppressWarnings("null")@NonNull String className = javaClass.getSimpleName();
		RootPackageId javaPackageId = IdManager.getRootPackageId(packageName);
		Orphanage orphanage = metamodelManager.getCompleteModel().getOrphanage();
		org.eclipse.ocl.pivot.Package asPackage = NameUtil.getNameable(orphanage.getOwnedPackages(), packageName);
		if (asPackage == null) {
			asPackage = PivotUtil.createPackage(packageName, packageName, packageName, javaPackageId);
			orphanage.getOwnedPackages().add(asPackage);
		}
		org.eclipse.ocl.pivot.Class asType = NameUtil.getNameable(asPackage.getOwnedClasses(), className);
		if (asType == null) {
			asType = PivotUtil.createClass(className);
			asPackage.getOwnedClasses().add(asType);
		}
		Property asChildProperty = PivotUtil.createProperty(name, asType);
		asChildProperty.setImplementation(NativeProperty.INSTANCE);
		asChildProperty.setIsRequired(isReadOnly);
		asChildProperty.setIsReadOnly(isReadOnly);
		return asChildProperty;
	}

	protected @NonNull VariableExp createThisVariableExp() {
		return PivotUtil.createVariableExp(asThisVariable);
	}
	
	protected @NonNull NullLiteralExp createNullLiteralExp() {
		return metamodelManager.createNullLiteralExp();
	}

	protected @NonNull Map<Operation, Operation> createVisitOperationDeclarations(@NonNull Map<Element, Element> reDefinitions) throws ParserException {
		Map<Operation,Operation> envOperation2asOperation = new HashMap<Operation,Operation>();
		for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.pivot.Class asType : asPackage.getOwnedClasses()) {
			for (Operation envOperation : asType.getOwnedOperations()) {
				if (LookupClassContext.ENV_NAME.equals(envOperation.getName())) {
					List<Parameter> asParameters = envOperation.getOwnedParameters();
					if (asParameters.size() == 1) {
						Operation asOperation = createVisitOperationDeclaration(reDefinitions, envOperation, asChildProperty);
						envOperation2asOperation.put(envOperation, asOperation);
						reDefinitions.put(envOperation, asOperation);
					}
				}
			}
		}
		return envOperation2asOperation;
	}

	/**
	 * Convert  'Element'::_env(child : Element) : Environment 
	 * to AutoPivotLookupVisitor::visit'Element'(parent : 'Element') : Environment
	 * 
	 * with child accessed as this.child.
	 * @throws ParserException 
	 */
	protected @NonNull Operation createVisitOperationDeclaration(@NonNull Map<Element, Element> reDefinitions, @NonNull Operation envOperation, @NonNull Property asChildProperty) throws ParserException {
		LanguageExpression envSpecification = ClassUtil.nonNullState(envOperation.getBodyExpression());
		ExpressionInOCL envExpressionInOCL = metamodelManager.parseSpecification(envSpecification);
		//
		org.eclipse.ocl.pivot.Class asType = ClassUtil.nonNullState(envOperation.getOwningClass());
		Variable asElement = PivotUtil.createVariable(LookupClassContext.ELEMENT_NAME, asType, true, null);
		reDefinitions.put(envExpressionInOCL.getOwnedContext(), asElement);
		//
		VariableExp asChildSource = createThisVariableExp();
		PropertyCallExp asChildAccess = PivotUtil.createPropertyCallExp(asChildSource, asChildProperty);
		Variable asChild = PivotUtil.createVariable(LookupClassContext.CHILD_NAME, asChildAccess);
		reDefinitions.put(envExpressionInOCL.getOwnedParameters().get(0), asChild);
		//
		String visitorName = "visit" + asType.getName();
		Operation asOperation = PivotFactory.eINSTANCE.createOperation();
		asOperation.setName(visitorName);
		asOperation.setImplementation(NativeVisitorOperation.INSTANCE);
		asOperation.setType(envOperation.getType());
		reDefinitions.put(envOperation, asOperation);
		return asOperation;
	}
	
	@Override
	protected @NonNull String getAutoVisitorClassName(@NonNull String prefix) {
		return "Abstract" +  prefix + "LookupVisitor";
	}

	public @NonNull CGValuedElement getChildVariable() {
		return ClassUtil.nonNullState(cgChildVariable);
	}

	public @NonNull CGValuedElement getEvaluatorVariable() {
		return ClassUtil.nonNullState(cgEvaluatorVariable);
	}

	@Override
	public @NonNull LookupClassContext getGlobalContext() {
		return classContext;
	}

	public @NonNull CGValuedElement getIdResolverVariable() {
		return ClassUtil.nonNullState(cgIdResolverVariable);
	}
	
	@Override
	protected @NonNull String getManualVisitorClassName(@NonNull String prefix) {
		return prefix + "LookupVisitor";  
	}

	@Override
	public @NonNull String getSourceFileName() {
		return genModel.getModelDirectory() + "/" + visitorPackage.replace('.', '/') + "/" + getAutoVisitorClassName(projectPrefix) + ".java";
	}

	@Override
	public @NonNull Class<?> getVisitorResultClass() {
		return getEnvironmentClass();
	}
	
	public @NonNull Class<?> getEnvironmentClass() {
		return genModelHelper.getEcoreInterfaceClass(asEnvironmentType);
	}
	
	@Override
	protected @NonNull String getVisitorPackageName(@NonNull String visitorsPackageName) {
		return visitorsPackageName + ".lookup";
	}
	
	protected @NonNull String getManualVisitorPackageName(@NonNull String visitorsPackageName) {
		return getVisitorPackageName(visitorsPackageName);
	}
	

	/**
	 * Replace selected OperationCallExps by alternative implementations.
	 */
	protected void rewriteOperationCalls(@NonNull Collection<? extends EObject> allContents) {
		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : EcoreUtil.CrossReferencer.find(allContents).entrySet()) {
			EObject crossReference = entry.getKey();
			if (crossReference instanceof Operation) {
				Operation asOperation = metamodelManager.getPrimaryOperation((Operation)crossReference);
				if (sameOrRedefiningOperation(asOperation, asElementEnvOperation)) {
					for (EStructuralFeature.Setting setting : entry.getValue()) {
						EObject eObject = setting.getEObject();
						if (eObject instanceof OperationCallExp) {
							rewriteEnvOperationCall((OperationCallExp)eObject);
						}
					}
				}
				else if (sameOrRedefiningOperation(asOperation, asEnvironmentNestedEnvOperation)) {
					for (EStructuralFeature.Setting setting : entry.getValue()) {
						EObject eObject = setting.getEObject();
						if (eObject instanceof OperationCallExp) {
							rewriteNestedEnvOperationCall((OperationCallExp)eObject);
						}
					}
				}
				else if (sameOrRedefiningOperation(asOperation, asElementParentEnvOperation)) {
					for (EStructuralFeature.Setting setting : entry.getValue()) {
						EObject eObject = setting.getEObject();
						if (eObject instanceof OperationCallExp) {
							rewriteParentEnvOperationCall((OperationCallExp)eObject);
						}
					}
				} 
				else if (sameOrRedefiningOperation(asOperation, asEnvironmentAddElementsOfElementOperation)) {
					for (EStructuralFeature.Setting setting : entry.getValue()) {
						EObject eObject = setting.getEObject();
						if (eObject instanceof OperationCallExp) {
							rewriteAddElementsOfOperationCall((OperationCallExp)eObject);
						}
					}	
				} else if (sameOrRedefiningOperation(asOperation, asEnvironmentAddElementsOfElementsOperation)) {
					// the addElementsOf(Collection(Visitable)) will contain the operation call we want to rewrite: addElementsOf(Visitable)
					rewriteOperationCalls(ClassUtil.nonNullState(Collections.singletonList(asOperation.getBodyExpression())));
				}
			}
			
		}
	}
	
	protected boolean sameOrRedefiningOperation(@NonNull Operation redefiningOperation, @NonNull Operation baseOperation) {
		
		// calledOperation.getRedefinedOperations().contains(baseOperation);
		// Note: the own operation seems to be an "overload"
		for (Operation redefinedOp :  metamodelManager.getOperationOverloads(redefiningOperation)) { 
			if (baseOperation == redefinedOp) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Convert source.env(child) to this.env(source, child)
	 */
	protected void rewriteEnvOperationCall(@NonNull OperationCallExp asOperationCallExp) {
		OCLExpression asSource = asOperationCallExp.getOwnedSource();
		asOperationCallExp.setOwnedSource(createThisVariableExp());
		asOperationCallExp.getOwnedArguments().add(0, asSource);
		asOperationCallExp.setReferredOperation(asVisitorEnvOperation);
	}
	
	/**
	 * Convert "source.nestedEnv().r.e.s.i.d.u.e" to
	 * "let innerEnv = this.context.r.e.s.i.d.u.e in if innerEnv.hasFinalResult() then innerEnv else source endif"
	 *  where r.e.s.i.d.u.e does not include any nestedEnv() call.
	 *  
	 *  "source.nestedEnv()" to "source"
	 */
	protected void rewriteNestedEnvOperationCall(@NonNull OperationCallExp asOperationCallExp) {
		CallExp asOuterCallExp = asOperationCallExp;
		for (EObject eContainer; (asOuterCallExp.eContainmentFeature() == PivotPackage.Literals.CALL_EXP__OWNED_SOURCE) && ((eContainer = asOuterCallExp.eContainer()) != null); asOuterCallExp = (CallExp)eContainer) {
			if (eContainer instanceof OperationCallExp) {
				OperationCallExp asParentOperationCallExp = (OperationCallExp)eContainer;
				Operation asReferredOperation = asParentOperationCallExp.getReferredOperation();
				if (asReferredOperation == asEnvironmentNestedEnvOperation) {
					break;
				}
			}
		}
		EObject eContainer = asOuterCallExp.eContainer();
		EReference eContainingFeature = asOuterCallExp.eContainmentFeature();		// This is not isMany()
		eContainer.eSet(eContainingFeature, null);									// asOuterCallExp becomes an orphan
		OCLExpression asSource = ClassUtil.nonNullState(asOperationCallExp.getOwnedSource());
		if (asOuterCallExp != asOperationCallExp) {
			CallExp asInnerCallExp = (CallExp)asOperationCallExp.eContainer();
			VariableExp asContextExp = PivotUtil.createVariableExp(asContextVariable);
			asInnerCallExp.setOwnedSource(asContextExp);										// asOperationCallExp becomes an orphan
			Variable asInnerEnv = PivotUtil.createVariable("inner", asOuterCallExp);
			VariableExp asInnerEnvExp1 = PivotUtil.createVariableExp(asInnerEnv);
			VariableExp asInnerEnvExp2 = PivotUtil.createVariableExp(asInnerEnv);
			OperationCallExp asCondition = PivotUtil.createOperationCallExp(asInnerEnvExp1, asEnvironmentHasFinalResultOperation);
			IfExp asIfExp = metamodelManager.createIfExp(asCondition, asInnerEnvExp2, asSource);
			LetExp asLetExp = PivotUtil.createLetExp(asInnerEnv, asIfExp);
			eContainer.eSet(eContainingFeature, asLetExp);
		}
		else {
			eContainer.eSet(eContainingFeature, asSource);
		}
	}
	
	/**
	 * Convert source.parentEnv() to this.parentEnv(source)
	 */
	protected void rewriteParentEnvOperationCall(@NonNull OperationCallExp asOperationCallExp) {
		OCLExpression asSource = asOperationCallExp.getOwnedSource();
		asOperationCallExp.setOwnedSource(createThisVariableExp());
		asOperationCallExp.getOwnedArguments().add(asSource);
		asOperationCallExp.setReferredOperation(asVisitorParentEnvOperation);
	}
	
	/**
	 * Convert env.addElementsOf(arg) to this.envForChildren(arg, null)
	 */
	protected void rewriteAddElementsOfOperationCall(@NonNull OperationCallExp asOperationCallExp) {
		asOperationCallExp.setOwnedSource(createThisVariableExp());
		asOperationCallExp.getOwnedArguments().add(createNullLiteralExp());
		asOperationCallExp.setReferredOperation(asVisitorEnvForChildOperation);
	}

	/**
	 * Copy all the visitXXX operation bodies from the _env bodies replacing references to redefined parameters.
	 */
	protected void rewriteVisitOperationBodies(@NonNull Map<Element, Element> reDefinitions, @NonNull Map<Operation, Operation> envOperation2asOperation) throws ParserException {
		for (@SuppressWarnings("null")@NonNull Operation envOperation : envOperation2asOperation.keySet()) {
			@SuppressWarnings("null")@NonNull Operation asOperation = envOperation2asOperation.get(envOperation);
			LanguageExpression envSpecification = ClassUtil.nonNullState(envOperation.getBodyExpression());
			ExpressionInOCL envExpressionInOCL = metamodelManager.parseSpecification(envSpecification);
			Variable asElement = (Variable) reDefinitions.get(envExpressionInOCL.getOwnedContext());
			OCLExpression asExpression = RereferencingCopier.copy(ClassUtil.nonNullState(envExpressionInOCL.getOwnedBody()), reDefinitions);
			ExpressionInOCL asExpressionInOCL = PivotUtil.createExpressionInOCL(null, asExpression, asElement);
			PivotUtil.initOperation(asOperation, asExpressionInOCL);
			asOperation.setType(asEnvironmentType);
			asOperation.setIsRequired(false);
		}
	}
}
