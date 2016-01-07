/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (University of York) - Lookup Environment/Visitor
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
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.AutoCodeGenOptions;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreGenModelGeneratorAdapter;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;

/**
 * AutoCodeGenerator supports generation of the content of a JavaClassFile to
 * execute a Auto transformation.
 */
public abstract class AutoCodeGenerator extends JavaCodeGenerator
{
//	private static final Logger logger = Logger.getLogger(AutoCodeGenerator.class);
	
	protected final @NonNull CodeGenAnalyzer cgAnalyzer;
	protected final org.eclipse.ocl.pivot.@NonNull Package asPackage;
	protected final org.eclipse.ocl.pivot.@Nullable Package asSuperPackage;
	protected final @NonNull GenModel genModel;
	protected final @NonNull GenPackage genPackage;
	//protected final @Nullable GenPackage superGenPackage;
	protected final @NonNull Map<String, CGPackage> externalPackages = new HashMap<String, CGPackage>();
	protected final @NonNull String projectPrefix;
	protected final @NonNull String projectName;
	protected final @NonNull String visitorPackage; 
	protected final @NonNull String visitorClass;
	protected final @NonNull String visitableClass;
	protected final @Nullable String superProjectPrefix;
	protected final @Nullable String superManualVisitorPackage; 
	protected final @Nullable String superVisitorClass;
	protected final @NonNull String baseProjectPrefix;
	protected final @NonNull String baseVisitorPackage;
	

	public AutoCodeGenerator(@NonNull EnvironmentFactoryInternal environmentFactory,
			org.eclipse.ocl.pivot.@NonNull Package asPackage,
			org.eclipse.ocl.pivot.@Nullable Package asSuperPackage,
			@NonNull GenPackage genPackage, // @Nullable GenPackage superGenPackage,
			@NonNull String projectPrefix,	// FIXME Since visitors/visitable package/name are really configured in the MWE file
			@NonNull String projectName,    // there is no point of providing a different to compute it here. To improve the framework, make use of the
			@NonNull String visitorPackage,	// genModel base logic in the whole framework simplyfying the number of parameters to deal with. Then, these parameters may be removed
			@NonNull String visitorClass,
			@NonNull String visitableClass,
			@Nullable String superProjectPrefix,
			@Nullable String superManualVisitorPackage,
			@Nullable String superVisitorClass,
			@Nullable String baseProjectPrefix,
			@Nullable String baseVisitorPackage) {
		super(environmentFactory);
		this.genModel = ClassUtil.nonNullState(genPackage.getGenModel());
		getOptions().setUseNullAnnotations(OCLinEcoreGenModelGeneratorAdapter.useNullAnnotations(genModel));
		cgAnalyzer = new CodeGenAnalyzer(this);
		this.asPackage = asPackage;
		this.asSuperPackage = asSuperPackage;
		this.genPackage = genPackage;
		// this.superGenPackage = superGenPackage;
		this.projectPrefix = projectPrefix;
		this.projectName = projectName;
		this.visitorPackage = visitorPackage;
		this.visitorClass = visitorClass;
		this.visitableClass = visitableClass;
		this.superProjectPrefix = superProjectPrefix;
		this.superManualVisitorPackage = superManualVisitorPackage;
		this.superVisitorClass = superVisitorClass;
		this.baseProjectPrefix = baseProjectPrefix != null ? baseProjectPrefix 
			: superProjectPrefix != null ? superProjectPrefix
				: projectPrefix;
		this.baseVisitorPackage = baseVisitorPackage != null ? baseVisitorPackage 
			: superManualVisitorPackage != null ? superManualVisitorPackage
				: visitorPackage;
	}

	protected @NonNull AS2CGVisitor createAS2CGVisitor() {
		return new AS2CGVisitor(cgAnalyzer);
	}
	
	@Override
	public abstract @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor();

	protected abstract @NonNull AutoCG2JavaVisitor<@NonNull ? extends AutoCodeGenerator> createCG2JavaVisitor(@NonNull CGPackage cgPackage, @Nullable List<CGValuedElement> sortedGlobals);

	protected abstract @NonNull List<CGPackage> createCGPackages() throws ParserException;
	


	@Override
	protected @NonNull AutoCodeGenOptions createOptions() {
		return new AutoCodeGenOptions();
	}



	public @NonNull String generateClassFile(@NonNull CGPackage cgPackage) {
		
		optimize(cgPackage);
		List<CGValuedElement> sortedGlobals = prepareGlobals();
		AutoCG2JavaVisitor<@NonNull ?> generator = createCG2JavaVisitor(cgPackage, sortedGlobals);
		generator.safeVisit(cgPackage);
		Set<String> allImports = generator.getAllImports();
		Map<@NonNull String, @Nullable String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
		return ImportUtils.resolveImports(generator.toString(), long2ShortImportNames, false);
	}

	@Override
	public @NonNull CodeGenAnalyzer getAnalyzer() {		
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
		CGClass cgClass = NameUtil.getNameable(cgPackage.getClasses(), className);
		if (cgClass == null) {
			cgClass = CGModelFactory.eINSTANCE.createCGClass();
			cgClass.setName(className);
			cgClass.setInterface(isInterface);
			cgPackage.getClasses().add(cgClass);
		}
		return cgClass;
	}
	
	protected @Nullable CGClass getExternalClass(org.eclipse.ocl.pivot.@NonNull Class aClass) {
		return getExternalClass(genModelHelper.getEcoreInterfaceClass(aClass));
	}

	public @NonNull GenPackage getGenPackage() {
		return genPackage;
	}

	protected abstract @NonNull String getManualVisitorClassName(@NonNull String prefix);

	@Override
	public @NonNull AutoCodeGenOptions getOptions() {
		return (AutoCodeGenOptions) super.getOptions();
	}

	public @NonNull String getQualifiedName() {
		String className = ClassUtil.nonNullState(asPackage.getName());
		String packagePrefix = getOptions().getPackagePrefix();
		if (packagePrefix != null) {
			return packagePrefix + "." + className;
		} else {
			return className;
		}
	}

	public @NonNull String getSourceFileName(String javaClassName) {
		return genModel.getModelDirectory() + "/" + getVisitorPackageName(projectName).replace('.', '/') + "/" + javaClassName;
	}

	@SuppressWarnings("null")
	public @NonNull Class<?> getVisitableClass() {
		try {
			return genModel.getClass().getClassLoader().loadClass(baseVisitorPackage + '.' + visitableClass);
		} catch (ClassNotFoundException e) {
			return Object.class;
		}
	}
	
	protected org.eclipse.ocl.pivot.@NonNull Class getVisitablePivotClass() {
		
//		return ClassUtil.nonNullState(metamodelManager.getASClass(visitableClass)); 
		for (GenPackage genPackage : genModel.getAllGenAndUsedGenPackagesWithClassifiers()) {
			if (baseProjectPrefix.equals(genPackage.getPrefix()) &&
				baseVisitorPackage.startsWith(genPackage.getQualifiedPackageName())) {
				for (GenClass genClass : genPackage.getGenClasses()) {
					if (visitableClass.equals(genClass.getName())) {
						EClass visitableEClass = genClass.getEcoreClass();
						org.eclipse.ocl.pivot.Class visitableClass = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Class.class, visitableEClass); 
						if (visitableClass != null) {
							return visitableClass;	
						}
					}
				}
			}
		}
		throw new IllegalStateException("Visitable Class not found from the provided GenModel");		
	}
	
	protected abstract @NonNull String getVisitorPackageName(@NonNull String visitorsPackageName);

	public @NonNull Class<?> getVisitorResultClass() {
		return Object.class;
	}

	public void saveSourceFile() {
		try {
			for (CGPackage cgPackage : createCGPackages()){
				String className = cgPackage.getClasses().get(0).getName();
				URI uri = URI.createPlatformResourceURI(getSourceFileName(className+".java"), true);
				String javaCodeSource = generateClassFile(cgPackage);;
				try {
					
					OutputStream outputStream = URIConverter.INSTANCE.createOutputStream(uri);
					Writer writer = new OutputStreamWriter(outputStream);
					writer.append(javaCodeSource);
					writer.close();
				} catch (IOException e) {
					throw new IllegalStateException("Failed to save '" + uri + "'", e);
				}
			}
		} catch (ParserException e) {
			throw new IllegalStateException("Failed to process '" + asPackage.getName() + "'", e);
		}
	}
}
