/*******************************************************************************
 * Copyright (c) 2013, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Framework Refactoring 
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.AutoCodeGenOptions;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
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
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreGenModelGeneratorAdapter;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * AutoCodeGenerator supports generation of the content of a JavaClassFile to
 * execute a Auto transformation.
 */
public abstract class AutoCodeGenerator extends JavaCodeGenerator
{
//	private static final Logger logger = Logger.getLogger(AutoCodeGenerator.class);

	
	protected final @NonNull IAutoCGComponentFactory cFactory;
	protected final @NonNull AutoAnalyzer cgAnalyzer;
	protected final @NonNull org.eclipse.ocl.examples.pivot.Package asPackage;
	protected final @Nullable org.eclipse.ocl.examples.pivot.Package asSuperPackage;
	protected final @NonNull GenModel genModel;
	protected final @NonNull GenPackage genPackage;
	//protected final @Nullable GenPackage superGenPackage;
	protected final @NonNull Map<String, CGPackage> externalPackages = new HashMap<String, CGPackage>();
	protected final @NonNull String projectPrefix;
	protected final @NonNull String visitorPackage; 
	protected final @NonNull String visitorClass;
	protected final @Nullable String superProjectPrefix;
	protected final @Nullable String superManualVisitorPackage; 
	protected final @Nullable String superVisitorClass;

	public AutoCodeGenerator(@NonNull MetaModelManager metaModelManager,
			@NonNull IAutoCGComponentFactory cFactory,
			@NonNull org.eclipse.ocl.examples.pivot.Package asPackage,
			@Nullable org.eclipse.ocl.examples.pivot.Package asSuperPackage,
			@NonNull GenPackage genPackage, // @Nullable GenPackage superGenPackage,
			@NonNull String projectPrefix,	// FIXME Since visitors/visitable package/name are really configured in the MWE file
											// there is no point of providing a different to compute it here. To improve the framework, make use of the
			@NonNull String visitorPackage,	// genModel base logic in the whole framework simplyfying the number of parameters to deal with. Then, these parameters may be removed
			@NonNull String visitorClass,
			@Nullable String superProjectPrefix,
			@Nullable String superManualVisitorPackage,
			@Nullable String superVisitorClass) {
		super(metaModelManager);
		this.genModel = DomainUtil.nonNullState(genPackage.getGenModel());
		getOptions().setUseNullAnnotations(OCLinEcoreGenModelGeneratorAdapter.useNullAnnotations(genModel));
		this.cgAnalyzer = createAnalyser();
		this.cFactory = cFactory;
		this.asPackage = asPackage;
		this.asSuperPackage = asSuperPackage;
		this.genPackage = genPackage;
		// this.superGenPackage = superGenPackage;
		this.projectPrefix = projectPrefix;
		this.visitorPackage = visitorPackage;
		this.visitorClass = visitorClass;
		this.superProjectPrefix = superProjectPrefix;
		this.superManualVisitorPackage = superManualVisitorPackage;
		this.superVisitorClass = superVisitorClass;
	}

	@Override
	@NonNull
	public final AnalysisVisitor createAnalysisVisitor() {
		return cFactory.createAnalysisVisitor(cgAnalyzer);
	}

	@Override
	@NonNull
	public final BoxingAnalyzer createBoxingAnalyzer() {
		return cFactory.createBoxingAnalyzer(cgAnalyzer);
	}

	@Override
	@NonNull
	public final CG2JavaPreVisitor createCG2JavaPreVisitor() {
		return cFactory.createCG2JavaPreVisitor(getGlobalContext());
	}

	@Override
	@NonNull
	public final DependencyVisitor createDependencyVisitor() {
		return cFactory.createDependencyVisitor(cgAnalyzer, getGlobalContext(),
			getGlobalPlace());
	}

	@Override
	@NonNull
	public final FieldingAnalyzer createFieldingAnalyzer() {
		return cFactory.createFieldingAnalyzer(cgAnalyzer);
	}
	
	@Override
	@NonNull
	public final ReferencesVisitor createReferencesVisitor() {
		return cFactory.createReferencesVisitor();
	}
	
	@NonNull
	protected final AutoCG2JavaVisitor createCG2JavaVisitor(
			@Nullable List<CGValuedElement> sortedGlobals) {
		return cFactory.createCG2JavaVisitor(this, sortedGlobals);
	}
	
	@Override
	@NonNull
	protected final AutoGlobalContext createGlobalContext() {
		return cFactory.createGlobalContext(this);
	}
	
	@NonNull
	protected final AS2CGVisitor createAS2CGVisitor() {	
		return cFactory.createAS2CGVisitor(cgAnalyzer);
	}
	
	@NonNull
	protected AutoAnalyzer createAnalyser() {
		return new AutoAnalyzer(this);
	}

	@Override
	@NonNull
	protected AutoCodeGenOptions createOptions() {
		return new AutoCodeGenOptions();
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
}
