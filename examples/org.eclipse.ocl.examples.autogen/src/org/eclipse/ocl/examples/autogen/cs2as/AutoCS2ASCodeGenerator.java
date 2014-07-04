/**
 * Copyright (c) 2014 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		 Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation
 */
package org.eclipse.ocl.examples.autogen.cs2as;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoCG2StringVisitor;
import org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelFactory;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.autogen.java.IAutoCGComponentFactory;
import org.eclipse.ocl.examples.autogen.utilities.AutoCGModelResourceFactory;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

public class AutoCS2ASCodeGenerator extends AutoCodeGenerator {

	protected final @NonNull String projectName;

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
		MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(DomainUtil.nonNullState(ePackage.eResource()));
		org.eclipse.ocl.examples.pivot.Package asPackage = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Package.class, ePackage);
		if (asPackage != null) {
			GenPackage superGenPackage = null;
			org.eclipse.ocl.examples.pivot.Package asSuperPackage = null;
			if (superProjectPrefix != null) {
				for (GenPackage gPackage : genPackage.getGenModel().getAllUsedGenPackagesWithClassifiers()) {
					String name = gPackage.getPrefix();
					if (name.startsWith(superProjectPrefix)) {
						superGenPackage = gPackage;
						EPackage eSuperPackage = gPackage.getEcorePackage();
						asSuperPackage = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Package.class, eSuperPackage);
						break;
					}
				}
				if (superGenPackage == null) {
					throw new IllegalStateException("No super-GenPackage found in UsedGenPackages for " + superProjectPrefix);
				}
			}
			AutoCS2ASFactory factory = new AutoCS2ASFactory();
			AutoCS2ASCodeGenerator autoCodeGenerator = new AutoCS2ASCodeGenerator(metaModelManager, factory, asPackage, asSuperPackage, genPackage, // superGenPackage,
					projectPrefix, projectName, visitorPackage, visitorClass, superProjectPrefix, superProjectName, superVisitorClass);
			autoCodeGenerator.saveSourceFile();
		}
	}
		
	public AutoCS2ASCodeGenerator(@NonNull MetaModelManager metaModelManager,
			@NonNull IAutoCGComponentFactory cFactory,
			@NonNull Package asPackage, @Nullable Package asSuperPackage, @NonNull GenPackage genPackage,
			@NonNull String projectPrefix, @NonNull String projectName, @NonNull String visitorPackage,
			@NonNull String visitorClass, @Nullable String superProjectPrefix,
			@Nullable String superManualVisitorPackage, @Nullable String superVisitorClass) {
		super(metaModelManager, cFactory, asPackage, asSuperPackage, genPackage, projectPrefix,
			visitorPackage, visitorClass, superProjectPrefix,
			superManualVisitorPackage, superVisitorClass);
		this.projectName = projectName;
	}

	
	@Override
	public @NonNull AutoCGModelResourceFactory getCGResourceFactory() {
		return AutoCGModelResourceFactory.INSTANCE;
	}
	
	public void saveSourceFile() {
		// String utilDir = genModel.getModelDirectory() + "/" + genPackage.getBasePackage().replace('.', '/') +"/util/" + genPackage.getPrefix() + "AutoContainmentVisitor.java";
		String utilDir = genModel.getModelDirectory() + "/" + getCS2ASVisitorPackageName(projectName).replace('.', '/') + "/" + getAutoVisitorClassName(projectPrefix) + ".java";
		URI uri = URI.createPlatformResourceURI(utilDir, true);
		String javaCodeSource = generateClassFile();
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(uri);
			Writer writer = new OutputStreamWriter(outputStream);
			writer.append(javaCodeSource);
			writer.close();
		} catch (IOException e) {
			throw new IllegalStateException("Failed to save '" + uri + "'");
		}
	}
		
	public @NonNull String generateClassFile() {
		CGPackage cgPackage = createCGPackage();
		optimize(cgPackage);
		List<CGValuedElement> sortedGlobals = prepareGlobals();
		AutoCG2JavaVisitor generator = createCG2JavaVisitor(sortedGlobals);
		generator.safeVisit(cgPackage);
		Set<String> allImports = generator.getAllImports();
		Map<String, String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
		return ImportUtils.resolveImports(generator.toString(), long2ShortImportNames);
	}
	
	protected @NonNull CGPackage createCGPackage() {
		// FIXME clean code removing unnecessary extra variables
		// String prefix = genPackage.getPrefix();
		// String trimmedPrefix = prefix.endsWith("CST") ? prefix.substring(0, prefix.length()-3) : "FIXME";
		String prefix = projectPrefix;
		
		// String packageName = genPackage.getBasePackage() + ".util";
		String packageName = getCS2ASVisitorPackageName(projectName); 
		
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
			String superPackageName = getCS2ASVisitorPackageName(DomainUtil.nonNullState(superManualVisitorPackage));
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
			superClass.getTemplateParameters().add(getExternalClass(CS2PivotConversion.class));
			cgClass.getSuperTypes().add(superClass);
		}
		cgPackage.getClasses().add(cgClass);
		for (Type asType : asPackage.getOwnedType()) {
			boolean hasCS2ASmappingOperation = false;
			Operation astOperation = DomainUtil.getNamedElement(asType.getOwnedOperation(), "ast");			
			if (astOperation != null) {
				OpaqueExpression bodyExpression = DomainUtil.nonNullState(astOperation.getBodyExpression());
				ExpressionInOCL expressionInOCL = DomainUtil.nonNullState(bodyExpression.getExpressionInOCL());
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
					
					Type constructorType = DomainUtil.nonNullState(constructorExp.getType());
					GenClass genClass = DomainUtil.nonNullState((GenClass) genModelHelper.getGenClassifier(constructorType));
					EClass eClass = DomainUtil.nonNullState(genClass.getEcoreClass());
					for (ConstructorPart constructorPart : constructorExp.getPart()) {
						CGContainmentPart cgPart = AutoCGModelFactory.eINSTANCE.createCGContainmentPart();
						String name = constructorPart.getName();
						cgPart.setName(name);
						cgPart.setAst(constructorPart);
						cgPart.setEStructuralFeature(DomainUtil.nonNullState(eClass.getEStructuralFeature(name)));
						cgPart.setInit((CGValuedElement) constructorPart.getInitExpression().accept(as2cgVisitor));
						cgBody.getParts().add(cgPart);
					}
					cgClass.getOperations().add(cgOperation);					
				}
			}
			if (!hasCS2ASmappingOperation) {
				CGOperation cgOperation = CGModelFactory.eINSTANCE.createCGEcoreOperation();
				cgOperation.setName("visit" + asType.getName());
				cgOperation.setAst(asType);
				cgClass.getOperations().add(cgOperation);
			}
		}
		return cgPackage;
	}
	

	protected @NonNull String getAutoVisitorClassName(@NonNull String prefix) {
		return "Auto" +  prefix + "ContainmentVisitor";
	}
	
	protected @NonNull String getManualVisitorClassName(@NonNull String prefix) {
		return "New" + prefix + "ContainmentVisitor";  
	}
	
	protected @NonNull String getCS2ASVisitorPackageName(@NonNull String visitorsPackageName) {
		return visitorsPackageName + ".cs2as";
	}
}
