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

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.AutoCodeGenOptions;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalysisVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoBoxingAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoDependencyVisitor;
import org.eclipse.ocl.examples.autogen.analyzer.AutoFieldingAnalyzer;
import org.eclipse.ocl.examples.autogen.analyzer.AutoReferencesVisitor;
import org.eclipse.ocl.examples.autogen.utilities.AutoCGModelResourceFactory;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreGenModelGeneratorAdapter;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.manager.MetaModelManager;

/**
 * AutoCodeGenerator supports generation of the content of a JavaClassFile to
 * execute a Auto transformation.
 */
public abstract class AutoCodeGenerator extends JavaCodeGenerator
{
//	private static final Logger logger = Logger.getLogger(AutoCodeGenerator.class);
	
	protected final @NonNull AutoAnalyzer cgAnalyzer;
	protected final @NonNull org.eclipse.ocl.pivot.Package asPackage;
	protected final @Nullable org.eclipse.ocl.pivot.Package asSuperPackage;
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
			@NonNull org.eclipse.ocl.pivot.Package asPackage,
			@Nullable org.eclipse.ocl.pivot.Package asSuperPackage,
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

	protected @NonNull AS2CGVisitor createAS2CGVisitor() {
		return new AS2CGVisitor(cgAnalyzer);
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
	public abstract @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor();

	protected abstract @NonNull AutoCG2JavaVisitor<? extends AutoCodeGenerator> createCG2JavaVisitor(@NonNull CGPackage cgPackage, @Nullable List<CGValuedElement> sortedGlobals);

	protected abstract @NonNull CGPackage createCGPackage() throws ParserException;

	@Override
	public @NonNull AutoCGModelResourceFactory getCGResourceFactory() {
		return AutoCGModelResourceFactory.INSTANCE;
	}

	@Override
	public @NonNull DependencyVisitor createDependencyVisitor() {
		return new AutoDependencyVisitor(cgAnalyzer, getGlobalContext(), getGlobalPlace());
	}

	@Override
	public @NonNull FieldingAnalyzer createFieldingAnalyzer() {
		return new AutoFieldingAnalyzer(cgAnalyzer);
	}

	@Override
	protected @NonNull AutoCodeGenOptions createOptions() {
		return new AutoCodeGenOptions();
	}

	@Override
	public @NonNull ReferencesVisitor createReferencesVisitor() {
		return AutoReferencesVisitor.INSTANCE;
	}

	public @NonNull String generateClassFile() throws ParserException {
		CGPackage cgPackage = createCGPackage();
		optimize(cgPackage);
		List<CGValuedElement> sortedGlobals = prepareGlobals();
		AutoCG2JavaVisitor<?> generator = createCG2JavaVisitor(cgPackage, sortedGlobals);
		generator.safeVisit(cgPackage);
		Set<String> allImports = generator.getAllImports();
		Map<String, String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
		return ImportUtils.resolveImports(generator.toString(), long2ShortImportNames);
	}

	@Override
	public @NonNull AutoAnalyzer getAnalyzer() {
		return cgAnalyzer;
	}
	
	protected abstract @NonNull String getAutoVisitorClassName(@NonNull String prefix);

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
	
	protected abstract @NonNull String getManualVisitorClassName(@NonNull String prefix);

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

	public abstract @NonNull Class<?> getVisitableClass();
	
	protected abstract @NonNull String getVisitorPackageName(@NonNull String visitorsPackageName);

	public @NonNull Class<?> getVisitorResultClass() {
		return Object.class;
	}

	public void saveSourceFile() {
		// String utilDir = genModel.getModelDirectory() + "/" + genPackage.getBasePackage().replace('.', '/') +"/util/" + genPackage.getPrefix() + "AutoContainmentVisitor.java";
		String utilDir = genModel.getModelDirectory() + "/" + getVisitorPackageName(projectName).replace('.', '/') + "/" + getAutoVisitorClassName(projectPrefix) + ".java";
		URI uri = URI.createPlatformResourceURI(utilDir, true);
		String javaCodeSource;
		try {
			javaCodeSource = generateClassFile();
		} catch (ParserException e) {
			throw new IllegalStateException("Failed to process '" + uri + "'", e);
		}
		try {
			OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(uri);
			Writer writer = new OutputStreamWriter(outputStream);
			writer.append(javaCodeSource);
			writer.close();
		} catch (IOException e) {
			throw new IllegalStateException("Failed to save '" + uri + "'", e);
		}
	}
}
