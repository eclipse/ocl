/*******************************************************************************
 * Copyright (c) 2013, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.java;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.AutoCodeGenOptions;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAS2CGVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalysisVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoBoxingAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoCG2StringVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoDependencyVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoFieldingAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoReferencesVisitor;
import org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelFactory;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;
import org.eclipse.ocl.examples.autogen.utilities.AutoCGModelResourceFactory;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreGenModelGeneratorAdapter;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 * AutoCodeGenerator supports generation of the content of a JavaClassFile to
 * execute a Auto transformation.
 */
public class AutoCodeGenerator extends JavaCodeGenerator
{
//	private static final Logger logger = Logger.getLogger(AutoCodeGenerator.class);
	
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
			AutoCodeGenerator autoCodeGenerator = new AutoCodeGenerator(metaModelManager, asPackage, asSuperPackage, genPackage, // superGenPackage,
					projectPrefix, projectName, visitorPackage, visitorClass, superProjectPrefix, superProjectName, superVisitorClass);
			autoCodeGenerator.saveSourceFile();
		}
	}
	
	protected final @NonNull AutoAnalyzer cgAnalyzer;
	protected final @NonNull org.eclipse.ocl.examples.pivot.Package asPackage;
	protected final @Nullable org.eclipse.ocl.examples.pivot.Package asSuperPackage;
	protected final @NonNull GenModel genModel;
	protected final @NonNull GenPackage genPackage;
	//protected final @Nullable GenPackage superGenPackage;
	protected final @NonNull Map<String, CGPackage> externalPackages = new HashMap<String, CGPackage>();
	protected final @NonNull String projectPrefix;
	protected final @NonNull String projectName;
	protected final @NonNull String visitorPackage; 
	protected final @NonNull String visitorClass;
	protected final @Nullable String superProjectPrefix;
	protected final @Nullable String superManualVisitorPackage; 
	protected final @Nullable String superVisitorClass;

	public AutoCodeGenerator(@NonNull MetaModelManager metaModelManager,
			@NonNull org.eclipse.ocl.examples.pivot.Package asPackage,
			@Nullable org.eclipse.ocl.examples.pivot.Package asSuperPackage,
			@NonNull GenPackage genPackage, // @Nullable GenPackage superGenPackage,
			@NonNull String projectPrefix,	// FIXME Since visitors/visitable package/name are really configured in the MWE file
			@NonNull String projectName,    // there is no point of providing a different to compute it here. To improve the framework, make use of the
			@NonNull String visitorPackage,	// genModel base logic in the whole framework simplyfying the number of parameters to deal with. Then, these parameters may be removed
			@NonNull String visitorClass,
			@Nullable String superProjectPrefix,
			@Nullable String superManualVisitorPackage,
			@Nullable String superVisitorClass) {
		super(metaModelManager);
		this.genModel = DomainUtil.nonNullState(genPackage.getGenModel());
		getOptions().setUseNullAnnotations(OCLinEcoreGenModelGeneratorAdapter.useNullAnnotations(genModel));
		cgAnalyzer = new AutoAnalyzer(this);
		this.asPackage = asPackage;
		this.asSuperPackage = asSuperPackage;
		this.genPackage = genPackage;
		// this.superGenPackage = superGenPackage;
		this.projectPrefix = projectPrefix;
		this.projectName = projectName;
		this.visitorPackage = visitorPackage;
		this.visitorClass = visitorClass;
		this.superProjectPrefix = superProjectPrefix;
		this.superManualVisitorPackage = superManualVisitorPackage;
		this.superVisitorClass = superVisitorClass;
	}

	@Override
	public @NonNull AnalysisVisitor createAnalysisVisitor() {
		return new AutoAnalysisVisitor(cgAnalyzer);
	}

	@Override
	public @NonNull BoxingAnalyzer createBoxingAnalyzer() {
		return new AutoBoxingAnalyzer(cgAnalyzer);
	}

	@Override
	public @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor() {
		return new AutoCG2JavaPreVisitor(getGlobalContext());
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
		AS2CGVisitor as2cgVisitor = new AutoAS2CGVisitor(cgAnalyzer, getGlobalContext());
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

	@Override
	public @NonNull AutoCGModelResourceFactory getCGResourceFactory() {
		return AutoCGModelResourceFactory.INSTANCE;
	}

	@Override
	public @NonNull DependencyVisitor createDependencyVisitor() {
		return new AutoDependencyVisitor(cgAnalyzer, getGlobalContext(),
			getGlobalPlace());
	}

	@Override
	public @NonNull FieldingAnalyzer createFieldingAnalyzer() {
		return new AutoFieldingAnalyzer(cgAnalyzer);
	}

	@Override
	protected @NonNull AutoGlobalContext createGlobalContext() {
		return new AutoGlobalContext(this);
	}

	@Override
	protected @NonNull AutoCodeGenOptions createOptions() {
		return new AutoCodeGenOptions();
	}

	@Override
	public @NonNull ReferencesVisitor createReferencesVisitor() {
		return AutoReferencesVisitor.INSTANCE;
	}

	public @NonNull String generateClassFile() {
		CGPackage cgPackage = createCGPackage();
		optimize(cgPackage);
		List<CGValuedElement> sortedGlobals = prepareGlobals();
		AutoCG2JavaVisitor generator = new AutoCG2JavaVisitor(this, cgPackage, sortedGlobals);
		generator.safeVisit(cgPackage);
		Set<String> allImports = generator.getAllImports();
		Map<String, String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
		return ImportUtils.resolveImports(generator.toString(), long2ShortImportNames);
	}

	public @NonNull AutoAnalyzer getAnalyzer() {
		return cgAnalyzer;
	}

	protected @NonNull CGClass getExternalClass(@NonNull Class<?> javaClass, CGClass... javaGenerics) {
		String packageName = javaClass.getPackage().getName();
		@SuppressWarnings("null")@NonNull String className = javaClass.getSimpleName();
		CGClass externalClass = getExternalClass(packageName, className, javaClass.isInterface());
		if (javaGenerics != null) {
			for (CGClass javaGeneric : javaGenerics) {
				if (javaGeneric == null) {
					javaGeneric = getExternalClass(null, "?", true);
				}
				externalClass.getTemplateParameters().add(javaGeneric);
			}
		}
		return externalClass;
	}

	protected @NonNull CGClass getExternalClass(@Nullable String packageName, @NonNull String className, boolean isInterface) {
		CGPackage cgPackage = externalPackages.get(packageName);
		if (cgPackage == null) {
			cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
			cgPackage.setName(packageName);
			externalPackages.put(packageName, cgPackage);
		}
		CGClass cgClass = DomainUtil.getNamedElement(cgPackage.getClasses(), className);
		if (cgClass == null) {
			cgClass = CGModelFactory.eINSTANCE.createCGClass();
			cgClass.setName(className);
			cgClass.setInterface(isInterface);
			cgPackage.getClasses().add(cgClass);
		}
		return cgClass;
	}

	@Override
	public @NonNull AutoGlobalContext getGlobalContext() {
		return (AutoGlobalContext) super.getGlobalContext();
	}

	@Override
	public @NonNull AutoCodeGenOptions getOptions() {
		return (AutoCodeGenOptions) super.getOptions();
	}

	public @NonNull String getQualifiedName() {
		String className = DomainUtil.nonNullState(asPackage.getName());
		String packagePrefix = getOptions().getPackagePrefix();
		if (packagePrefix != null) {
			return packagePrefix + "." + className;
		} else {
			return className;
		}
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
