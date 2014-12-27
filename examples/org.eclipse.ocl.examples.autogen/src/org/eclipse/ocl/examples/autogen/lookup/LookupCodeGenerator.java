/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
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
import org.eclipse.ocl.pivot.OCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.lookup.Environment;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.Orphanage;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtilInternal;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLASResourceFactory;

/**
 * LookupCodeGenerator supports generation of the content of a JavaClassFile for the Lookup visitor.
 */
public class LookupCodeGenerator extends AutoCodeGenerator
{	
	public static void generate(@NonNull GenPackage genPackage,
			@NonNull String projectPrefix,	// FIXME Since visitors/visitable package/name are really configured in the MWE file
			@NonNull String projectName,	// there is no point of providing a different to compute it here. To improve the framework, make use of the
			@NonNull String visitorPackage,	// genModel base logic in the whole framework simplyfying the number of parameters to deal with. Then, these parameters may be removed
			@NonNull String visitorClass,
			@Nullable String superProjectPrefix,
			@Nullable String superProjectName,
			@Nullable String superVisitorClass) {
		EPackage ePackage = genPackage.getEcorePackage();
		assert ePackage != null;
//		CommonSubexpressionEliminator.CSE_BUILD.setState(true);
//		CommonSubexpressionEliminator.CSE_PLACES.setState(true);
//		CommonSubexpressionEliminator.CSE_PRUNE.setState(true);
//		CommonSubexpressionEliminator.CSE_PULL_UP.setState(true);
//		CommonSubexpressionEliminator.CSE_PUSH_UP.setState(true);
//		CommonSubexpressionEliminator.CSE_REWRITE.setState(true);
	
		AutoCG2StringVisitor.FACTORY.getClass();
		
		
		MetaModelManager metaModelManager = PivotUtilInternal.getMetaModelManager(ClassUtil.nonNullState(ePackage.eResource()));
		URI projectResourceURI = URI.createPlatformResourceURI("/" + projectName + "/", true);
		@SuppressWarnings("null")@NonNull URI nameResoURI = URI.createURI("model/PivotLookup.ocl").resolve(projectResourceURI);
		OCL ocl = OCL.newInstance(new PivotEnvironmentFactory(null, metaModelManager));
//		Resource resource = metaModelManager.getResource(nameResoURI, CompleteOCL);
		Resource resource = ClassUtil.nonNullState(ocl.parse(nameResoURI));
//		Root root = (Root) resource.getContents().get(0);
//		return root.getNestedPackage().get(0);
//	}
		
		
		for (EObject root : resource.getContents()) {
			if (root instanceof Model) {
				for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.pivot.Package asPackage : ((Model)root).getOwnedPackages()) {
					GenPackage superGenPackage = null;
					org.eclipse.ocl.pivot.Package asSuperPackage = null;
					if (superProjectPrefix != null) {
						for (GenPackage gPackage : genPackage.getGenModel().getAllUsedGenPackagesWithClassifiers()) {
							String name = gPackage.getPrefix();
							if (name.startsWith(superProjectPrefix)) {
								superGenPackage = gPackage;
								EPackage eSuperPackage = gPackage.getEcorePackage();
								asSuperPackage = metaModelManager.getPivotOfEcore(org.eclipse.ocl.pivot.Package.class, eSuperPackage);
								break;
							}
						}
						if (superGenPackage == null) {
							throw new IllegalStateException("No super-GenPackage found in UsedGenPackages for " + superProjectPrefix);
						}
					}
					AutoCodeGenerator autoCodeGenerator = new LookupCodeGenerator(metaModelManager, asPackage, asSuperPackage, genPackage, // superGenPackage,
							projectPrefix, projectName, visitorPackage, visitorClass, superProjectPrefix, superProjectName, superVisitorClass);
					autoCodeGenerator.saveSourceFile();
				}
			}
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
	protected final @NonNull Operation asElementEnvOperation;
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
	protected final @NonNull Type asEnvironmentType;
	//
	//	Important CG elements
	//
	private @Nullable CGProperty cgEvaluatorVariable = null;
	private @Nullable CGProperty cgIdResolverVariable = null;
	private @Nullable CGProperty cgChildVariable = null;

	protected LookupCodeGenerator(@NonNull MetaModelManager metaModelManager, @NonNull org.eclipse.ocl.pivot.Package asPackage,
			@Nullable org.eclipse.ocl.pivot.Package asSuperPackage, @NonNull GenPackage genPackage,
			@NonNull String projectPrefix, @NonNull String projectName, @NonNull String visitorPackage, @NonNull String visitorClass,
			@Nullable String superProjectPrefix, @Nullable String superManualVisitorPackage, @Nullable String superVisitorClass) {
		super(metaModelManager, asPackage, asSuperPackage, genPackage, projectPrefix, projectName,
			visitorPackage, visitorClass, superProjectPrefix, superManualVisitorPackage, superVisitorClass);
		this.packageName = getVisitorPackageName(projectName); 
		this.className = getAutoVisitorClassName(projectPrefix);
		this.classContext = new LookupClassContext(this, asPackage);
		this.as2cgVisitor = createAS2CGVisitor();
		//
		//	Find expected AS elements
		//
		ParametersId emptyParametersId = IdManager.getParametersId();
		CompleteClass asElementCompleteClass = metaModelManager.getCompletePackage(asPackage).getOwnedCompleteClass(PivotPackage.Literals.ELEMENT.getName());
		org.eclipse.ocl.pivot.Class asElementType = asElementCompleteClass.getPivotClass();
		OperationId envOperationId = asElementType.getTypeId().getOperationId(0, LookupClassContext.ENV_NAME, IdManager.getParametersId(asElementType.getTypeId()));
		this.asElementEnvOperation = ClassUtil.nonNullState(asElementCompleteClass.getOperation(envOperationId));
		OperationId parentEnvOperationId = asElementType.getTypeId().getOperationId(0, LookupClassContext.PARENT_ENV_NAME, emptyParametersId);
		this.asElementParentEnvOperation = ClassUtil.nonNullState(asElementCompleteClass.getOperation(parentEnvOperationId));
		this.asEnvironmentType = ClassUtil.nonNullState(asElementParentEnvOperation.getType());
		CompleteClass asEnvironmentCompleteClass = metaModelManager.getCompleteClass(asEnvironmentType);
		OperationId nestedEnvOperationId = asElementType.getTypeId().getOperationId(0, LookupClassContext.NESTED_ENV_NAME, emptyParametersId);
		this.asEnvironmentNestedEnvOperation = ClassUtil.nonNullState(asEnvironmentCompleteClass.getOperation(nestedEnvOperationId));
		OperationId hasFinalResultOperationId = asElementType.getTypeId().getOperationId(0, LookupClassContext.HAS_FINAL_RESULT_NAME, emptyParametersId);
		this.asEnvironmentHasFinalResultOperation = ClassUtil.nonNullState(asEnvironmentCompleteClass.getOperation(hasFinalResultOperationId));
		//
		//	Create new AS elements
		//
		this.asVisitorClass = createASVisitorClass(packageName, className);
		this.asThisVariable = PivotUtilInternal.createVariable("this", asVisitorClass, true, null);
		this.asContextVariable = PivotUtilInternal.createVariable(LookupClassContext.CONTEXT_NAME, asEnvironmentType, true, null);
		//
		//	Create new AS Visitor helper properties
		//
		this.asChildProperty = createNativeProperty(LookupClassContext.CHILD_NAME, asElementType, false);
		this.asEvaluatorProperty = createNativeProperty(JavaConstants.EVALUATOR_NAME, Evaluator.class, true);
		this.asIdResolverProperty = createNativeProperty(JavaConstants.ID_RESOLVER_NAME, IdResolver.class, true);
		List<Property> asVisitorProperties = asVisitorClass.getOwnedProperties();
		asVisitorProperties.add(asChildProperty);
		asVisitorProperties.add(asEvaluatorProperty);
		asVisitorProperties.add(asIdResolverProperty);
		//
		//	Create new AS Visitor helper operations
		//
		this.asVisitorEnvOperation = PivotUtilInternal.createOperation(LookupClassContext.ENV_NAME, asEnvironmentType, null, null);
		asVisitorEnvOperation.getOwnedParameters().add(PivotUtilInternal.createParameter(LookupClassContext.ELEMENT_NAME, asElementType, true));
		asVisitorEnvOperation.getOwnedParameters().add(PivotUtilInternal.createParameter(LookupClassContext.CHILD_NAME, asElementType, false));
		this.asVisitorParentEnvOperation = PivotUtilInternal.createOperation(LookupClassContext.PARENT_ENV_NAME, asEnvironmentType, null, null);
		asVisitorParentEnvOperation.getOwnedParameters().add(PivotUtilInternal.createParameter(LookupClassContext.ELEMENT_NAME, asElementType, true));
		asVisitorParentEnvOperation.setImplementation(NativeStaticOperation.INSTANCE);
		asVisitorParentEnvOperation.setIsRequired(false);
		List<Operation> asVisitorOperations = asVisitorClass.getOwnedOperations();
		asVisitorOperations.add(asVisitorEnvOperation);
		asVisitorOperations.add(asVisitorParentEnvOperation);
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
		if (superProjectPrefix2 != null) {
			// String superPackageName = super
			String superPackageName = getVisitorPackageName(ClassUtil.nonNullState(superManualVisitorPackage));
			// String superClassName = superGenPackage2.getPrefix() + "AutoContainmentVisitor";
			String superClassName = getManualVisitorClassName(superProjectPrefix2);
			// String superInterfaceName = /*trimmed*/prefix + "Visitor";
			String superInterfaceName = visitorClass;
			
			CGClass superClass = getExternalClass(superPackageName, superClassName, false);
			cgClass.getSuperTypes().add(superClass);
			CGClass superInterface = getExternalClass(visitorPackage, superInterfaceName, true);
			superInterface.getTemplateParameters().add(getExternalClass(Environment.class));
			cgClass.getSuperTypes().add(superInterface);
		}
		else {
			// String superClassName = "Abstract" + /*trimmed*/prefix + "CSVisitor";
//			String superClassName = "AbstractExtending" + visitorClass; // The default Abstract Visitor generated for the language
			String superClassName = "AbstractExtendingVisitor"; // The default Abstract Visitor generated for the language
			CGClass superClass = getExternalClass(visitorPackage, superClassName, false);
			CGClass cgResultClass = getExternalClass(getVisitorResultClass());
			superClass.getTemplateParameters().add(cgResultClass);
			superClass.getTemplateParameters().add(cgResultClass);
			cgClass.getSuperTypes().add(superClass);
		}
	}

	protected @NonNull org.eclipse.ocl.pivot.Class createASVisitorClass(@NonNull String packageName, @NonNull String className) {
		org.eclipse.ocl.pivot.Class asVisitorClass = PivotUtilInternal.createClass(className);
		String nsURI = "java://"+packageName;		// java: has no significance other than diagnostic readability
		org.eclipse.ocl.pivot.Package asVisitorPackage = PivotUtilInternal.createPackage(packageName, "viz", nsURI, IdManager.getRootPackageId(nsURI));
		asVisitorPackage.getOwnedClasses().add(asVisitorClass);
		Model asVisitorRoot = PivotUtilInternal.createModel(nsURI + ".java");
		asVisitorRoot.getOwnedPackages().add(asVisitorPackage);
		metaModelManager.installRoot(asVisitorRoot);
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
		Resource dummyResource = EssentialOCLASResourceFactory.INSTANCE.createResource(URI.createURI("dummy.essentialocl"));
		dummyResource.getContents().addAll(asOperations);		// PrettyPrinter needs containment
		return cgPackage;
	}

	protected @NonNull Property createNativeProperty(@NonNull String name, @NonNull Type asElementType, boolean isReadOnly) {
		Property asChildProperty = PivotUtilInternal.createProperty(name, asElementType);
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
		Orphanage orphanage = metaModelManager.getCompleteModel().getOrphanage();
		org.eclipse.ocl.pivot.Package asPackage = NameUtil.getNameable(orphanage.getOwnedPackages(), packageName);
		if (asPackage == null) {
			asPackage = PivotUtilInternal.createPackage(packageName, packageName, packageName, javaPackageId);
			orphanage.getOwnedPackages().add(asPackage);
		}
		org.eclipse.ocl.pivot.Class asType = NameUtil.getNameable(asPackage.getOwnedClasses(), className);
		if (asType == null) {
			asType = PivotUtilInternal.createClass(className);
			asPackage.getOwnedClasses().add(asType);
		}
		Property asChildProperty = PivotUtilInternal.createProperty(name, asType);
		asChildProperty.setImplementation(NativeProperty.INSTANCE);
		asChildProperty.setIsRequired(isReadOnly);
		asChildProperty.setIsReadOnly(isReadOnly);
		return asChildProperty;
	}

	protected @NonNull VariableExp createThisVariableExp() {
		return PivotUtilInternal.createVariableExp(asThisVariable);
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
		ExpressionInOCL envExpressionInOCL = metaModelManager.getQueryOrThrow(envSpecification);
		//
		org.eclipse.ocl.pivot.Class asType = ClassUtil.nonNullState(envOperation.getOwningClass());
		Variable asElement = PivotUtilInternal.createVariable(LookupClassContext.ELEMENT_NAME, asType, true, null);
		reDefinitions.put(envExpressionInOCL.getOwnedContext(), asElement);
		//
		VariableExp asChildSource = createThisVariableExp();
		PropertyCallExp asChildAccess = PivotUtilInternal.createPropertyCallExp(asChildSource, asChildProperty);
		Variable asChild = PivotUtilInternal.createVariable(LookupClassContext.CHILD_NAME, asChildAccess);
		reDefinitions.put(envExpressionInOCL.getOwnedParameters().get(0), asChild);
		//
		String visitorName = "visit" + asType.getName();
		Operation asOperation = PivotFactory.eINSTANCE.createOperation();
		asOperation.setName(visitorName);
		asOperation.setImplementation(NativeVisitorOperation.INSTANCE);
		reDefinitions.put(envOperation, asOperation);
		return asOperation;
	}
	
	@Override
	protected @NonNull String getAutoVisitorClassName(@NonNull String prefix) {
		return "Auto" +  prefix + "LookupVisitor";
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
		return "New" + prefix + "LookupVisitor";  
	}

	@Override
	public @NonNull String getSourceFileName() {
		return genModel.getModelDirectory() + "/" + visitorPackage.replace('.', '/') + "/" + getAutoVisitorClassName(projectPrefix) + ".java";
	}


	@Override
	public @NonNull Class<?> getVisitableClass() {
		return Visitable.class;
	}

	@Override
	public @NonNull Class<?> getVisitorResultClass() {
		return Environment.class;
	}
	
	@Override
	protected @NonNull String getVisitorPackageName(@NonNull String visitorsPackageName) {
		return visitorsPackageName + ".lookup";
	}

	/**
	 * Replace selected OperationCallExps by alternative implementations.
	 */
	protected void rewriteOperationCalls(@NonNull Collection<? extends EObject> allContents) {
		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : EcoreUtil.CrossReferencer.find(allContents).entrySet()) {
			EObject crossReference = entry.getKey();
			if (crossReference instanceof Operation) {
				Operation asOperation = metaModelManager.getPrimaryOperation((Operation)crossReference);
				if (asOperation == asElementEnvOperation) {
					for (EStructuralFeature.Setting setting : entry.getValue()) {
						EObject eObject = setting.getEObject();
						if (eObject instanceof OperationCallExp) {
							rewriteEnvOperationCall((OperationCallExp)eObject);
						}
					}
				}
				else if (asOperation == asEnvironmentNestedEnvOperation) {
					for (EStructuralFeature.Setting setting : entry.getValue()) {
						EObject eObject = setting.getEObject();
						if (eObject instanceof OperationCallExp) {
							rewriteNestedEnvOperationCall((OperationCallExp)eObject);
						}
					}
				}
				else if (asOperation == asElementParentEnvOperation) {
					for (EStructuralFeature.Setting setting : entry.getValue()) {
						EObject eObject = setting.getEObject();
						if (eObject instanceof OperationCallExp) {
							rewriteParentEnvOperationCall((OperationCallExp)eObject);
						}
					}
				}
			}
			
		}
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
			VariableExp asContextExp = PivotUtilInternal.createVariableExp(asContextVariable);
			asInnerCallExp.setOwnedSource(asContextExp);										// asOperationCallExp becomes an orphan
			Variable asInnerEnv = PivotUtilInternal.createVariable("inner", asOuterCallExp);
			VariableExp asInnerEnvExp1 = PivotUtilInternal.createVariableExp(asInnerEnv);
			VariableExp asInnerEnvExp2 = PivotUtilInternal.createVariableExp(asInnerEnv);
			OperationCallExp asCondition = PivotUtilInternal.createOperationCallExp(asInnerEnvExp1, asEnvironmentHasFinalResultOperation);
			IfExp asIfExp = metaModelManager.createIfExp(asCondition, asInnerEnvExp2, asSource);
			LetExp asLetExp = PivotUtilInternal.createLetExp(asInnerEnv, asIfExp);
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
	 * Copy all the visitXXX operation bodies from the _env bodies replacing references to redefined parameters.
	 */
	protected void rewriteVisitOperationBodies(@NonNull Map<Element, Element> reDefinitions, @NonNull Map<Operation, Operation> envOperation2asOperation) throws ParserException {
		for (@SuppressWarnings("null")@NonNull Operation envOperation : envOperation2asOperation.keySet()) {
			@SuppressWarnings("null")@NonNull Operation asOperation = envOperation2asOperation.get(envOperation);
			LanguageExpression envSpecification = ClassUtil.nonNullState(envOperation.getBodyExpression());
			ExpressionInOCL envExpressionInOCL = metaModelManager.getQueryOrThrow(envSpecification);
			Variable asElement = (Variable) reDefinitions.get(envExpressionInOCL.getOwnedContext());
			OCLExpression asExpression = RereferencingCopier.copy(ClassUtil.nonNullState(envExpressionInOCL.getOwnedBody()), reDefinitions);
			ExpressionInOCL asExpressionInOCL = PivotUtilInternal.createExpressionInOCL(null, asExpression, asElement);
			PivotUtilInternal.initOperation(asOperation, asExpressionInOCL);
			asOperation.setType(asEnvironmentType);
			asOperation.setIsRequired(false);
		}
	}
}
