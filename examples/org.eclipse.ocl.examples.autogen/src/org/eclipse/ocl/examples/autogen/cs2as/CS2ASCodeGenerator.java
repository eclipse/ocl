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
package org.eclipse.ocl.examples.autogen.cs2as;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoCG2StringVisitor;
import org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelFactory;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaPreVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.pivot.ConstructorExp;
import org.eclipse.ocl.pivot.ConstructorPart;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.basecs.util.VisitableCS;

/**
 * CS2ASCodeGenerator supports generation of the content of a JavaClassFile for the CS2AS visitor.
 */
public class CS2ASCodeGenerator extends AutoCodeGenerator
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
		MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(ClassUtil.nonNullState(ePackage.eResource()));
		org.eclipse.ocl.pivot.Package asPackage = metaModelManager.getPivotOfEcore(org.eclipse.ocl.pivot.Package.class, ePackage);
		if (asPackage != null) {
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
			AutoCodeGenerator autoCodeGenerator = new CS2ASCodeGenerator(metaModelManager, asPackage, asSuperPackage, genPackage, // superGenPackage,
					projectPrefix, projectName, visitorPackage, visitorClass, superProjectPrefix, superProjectName, superVisitorClass);
			autoCodeGenerator.saveSourceFile();
		}
	}

	protected final @NonNull CS2ASGlobalContext globalContext = new CS2ASGlobalContext(this);

	public CS2ASCodeGenerator(@NonNull MetaModelManager metaModelManager,
			@NonNull Package asPackage, Package asSuperPackage, @NonNull GenPackage genPackage,
			@NonNull String projectPrefix, @NonNull String projectName, @NonNull String visitorPackage,
			@NonNull String visitorClass, String superProjectPrefix,
			String superManualVisitorPackage, String superVisitorClass) {
		super(metaModelManager, asPackage, asSuperPackage, genPackage, projectPrefix,
			projectName, visitorPackage, visitorClass, superProjectPrefix,
			superManualVisitorPackage, superVisitorClass);
	}

	@Override
	protected @NonNull AS2CGVisitor createAS2CGVisitor() {
		return new CS2ASAS2CGVisitor(cgAnalyzer);
	}

	@Override
	protected @NonNull CS2ASCG2JavaVisitor createCG2JavaVisitor(@NonNull CGPackage cgPackage, @Nullable List<CGValuedElement> sortedGlobals) {
		return new CS2ASCG2JavaVisitor(this, cgPackage, sortedGlobals);
	}

	@Override
	public @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor() {
		return new AutoCG2JavaPreVisitor(globalContext);
	}

	@Override
	protected @NonNull CGPackage createCGPackage() throws ParserException {
		// FIXME clean code removing unnecessary extra variables
		// String prefix = genPackage.getPrefix();
		// String trimmedPrefix = prefix.endsWith("CST") ? prefix.substring(0, prefix.length()-3) : "FIXME";
		String prefix = projectPrefix;
		
		// String packageName = genPackage.getBasePackage() + ".util";
		String packageName = getVisitorPackageName(projectName); 
		
		//String className = prefix + "AutoContainmentVisitor";
		String className = getAutoVisitorClassName(prefix);
		AS2CGVisitor as2cgVisitor = createAS2CGVisitor();
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		cgPackage.setName(packageName);
		CGClass cgClass = CGModelFactory.eINSTANCE.createCGClass();
		cgClass.setName(className);
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
			superInterface.getTemplateParameters().add(getExternalClass(Continuation.class, (CGClass)null));
			cgClass.getSuperTypes().add(superInterface);
		}
		else {
			// String superClassName = "Abstract" + /*trimmed*/prefix + "CSVisitor";
			String superClassName = "Abstract" + visitorClass; // The default Abstract Visitor generated for the language
			CGClass superClass = getExternalClass(visitorPackage, superClassName, false);
			superClass.getTemplateParameters().add(getExternalClass(Continuation.class, (CGClass)null));
			superClass.getTemplateParameters().add(getExternalClass(CS2ASConversion.class));
			cgClass.getSuperTypes().add(superClass);
		}
		cgPackage.getClasses().add(cgClass);
		for (org.eclipse.ocl.pivot.Class asType : asPackage.getOwnedClasses()) {
			boolean hasCS2ASmappingOperation = false;
			Operation astOperation = ClassUtil.getNamedElement(asType.getOwnedOperations(), "ast");			
			if (astOperation != null) {
				LanguageExpression specification = ClassUtil.nonNullState(astOperation.getBodyExpression());
				ExpressionInOCL expressionInOCL = metaModelManager.getQueryOrThrow(specification);
				OCLExpression oclExpression = expressionInOCL.getBodyExpression();
				if (oclExpression instanceof ConstructorExp) {
					hasCS2ASmappingOperation = true;
					ConstructorExp constructorExp = (ConstructorExp) oclExpression;
					CGContainmentVisit cgOperation = AutoCGModelFactory.eINSTANCE.createCGContainmentVisit();
					cgOperation.setName("visit" + asType.getName());
					cgOperation.setAst(asType);
					cgClass.getOperations().add(cgOperation);
					CGContainmentBody cgBody = AutoCGModelFactory.eINSTANCE.createCGContainmentBody();
					cgBody.setAst(astOperation);
//					cgBody.setTypeId(getAnalyzer().getTypeId(astOperation.getTypeId()));
					cgOperation.setBody(cgBody);
					Variable contextVariable = expressionInOCL.getContextVariable();
					if (contextVariable != null) {
						List<CGParameter> cgParameters = cgOperation.getParameters();
						CGParameter cgContext = as2cgVisitor.getParameter(contextVariable);
						cgContext.setValueName("self");
						cgParameters.add(cgContext);
					}
					
					org.eclipse.ocl.pivot.Class constructorType = ClassUtil.nonNullState(constructorExp.getType());
					GenClass genClass = ClassUtil.nonNullState((GenClass) genModelHelper.getGenClassifier(constructorType));
					EClass eClass = ClassUtil.nonNullState(genClass.getEcoreClass());
					for (ConstructorPart constructorPart : constructorExp.getPart()) {
						CGContainmentPart cgPart = AutoCGModelFactory.eINSTANCE.createCGContainmentPart();
						String name = constructorPart.getName();
						cgPart.setName(name);
						cgPart.setAst(constructorPart);
						cgPart.setEStructuralFeature(ClassUtil.nonNullState(eClass.getEStructuralFeature(name)));
						cgPart.setInit((CGValuedElement) constructorPart.getInitExpression().accept(as2cgVisitor));
						cgBody.getParts().add(cgPart);
					}
					cgClass.getOperations().add(cgOperation);					
				}
			}
			if (!hasCS2ASmappingOperation && !asType.isInterface() && !(asType instanceof DataType)) {
				CGOperation cgOperation = CGModelFactory.eINSTANCE.createCGEcoreOperation();
				cgOperation.setName("visit" + asType.getName());
				cgOperation.setAst(asType);
				cgClass.getOperations().add(cgOperation);
			}
		}
		return cgPackage;
	}
	
	@Override
	protected @NonNull String getAutoVisitorClassName(@NonNull String prefix) {
		return "Auto" +  prefix + "ContainmentVisitor";
	}

	@Override
	public @NonNull CS2ASGlobalContext getGlobalContext() {
		return globalContext;
	}
	
	@Override
	protected @NonNull String getManualVisitorClassName(@NonNull String prefix) {
		return "New" + prefix + "ContainmentVisitor";  
	}

	@Override
	public @NonNull Class<?> getVisitableClass() {
		return VisitableCS.class;
	}
	
	@Override
	protected @NonNull String getVisitorPackageName(@NonNull String visitorsPackageName) {
		return visitorsPackageName + ".cs2as";
	}

	@Override
	public @NonNull Class<?> getVisitorResultClass() {
		return Continuation.class;
	}
}
