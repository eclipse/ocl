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
package org.eclipse.ocl.examples.autogen.namereso;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.autogen.java.IAutoCGComponentFactory;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelFactory;
import org.eclipse.ocl.examples.autogen.utilities.AutoCGModelResourceFactory;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * Class to generate lookup infrastructure based on CG model.  
 *
 */
public class AutoLookupCodeGenerator extends AutoCodeGenerator {

	@NonNull
	protected final String outputFolder;
	
	@NonNull
	protected final String packageName;
	
	@NonNull
	protected final AutoNameResoCGNamesProvider nProvider; 
	
	public static void generate(
			@NonNull String outputFolder, 
			@NonNull String projectPrefix,
			@NonNull GenPackage genPackage,
			@NonNull String modelPckName,
			@NonNull String nameResoPackName, 
			@NonNull String visitorPckName,			
			@NonNull String visitorName,
			@NonNull Package nameResoDescPackage) {
		
		MetaModelManager mManager = DomainUtil.nonNullState(PivotUtil.findMetaModelManager(nameResoDescPackage));
		AutoLookupFactory factory = new AutoLookupFactory();
		AutoLookupCodeGenerator autoCodeGenerator = new AutoLookupCodeGenerator(mManager, factory, nameResoDescPackage, null, genPackage, // superGenPackage,
				projectPrefix, visitorPckName, visitorName, null, null, null, outputFolder, nameResoPackName);
		autoCodeGenerator.saveSourceFile();
		
	}
		
	public AutoLookupCodeGenerator(@NonNull MetaModelManager metaModelManager,
			@NonNull IAutoCGComponentFactory cFactory,
			@NonNull Package asPackage, @Nullable Package asSuperPackage, @NonNull GenPackage genPackage,
			@NonNull String projectPrefix, @NonNull String visitorPackage,
			@NonNull String visitorClass, @Nullable String superProjectPrefix,
			@Nullable String superManualVisitorPackage, @Nullable String superVisitorClass,
			@NonNull String outputFolder,
			@NonNull String nameResoPckName) {
		super(metaModelManager, cFactory, asPackage, asSuperPackage, genPackage, projectPrefix,
			visitorPackage, visitorClass, superProjectPrefix,
			superManualVisitorPackage, superVisitorClass);
		this.outputFolder = outputFolder;
		this.packageName = nameResoPckName;
		this.nProvider = createNamesProviders(projectPrefix);
	}

	
	@Override
	public @NonNull AutoCGModelResourceFactory getCGResourceFactory() {
		return AutoCGModelResourceFactory.INSTANCE;
	}
	
	public @NonNull AutoNameResoCGNamesProvider getCGNamesProvider() {
		return nProvider;
	}
	
	public void saveSourceFile() {
		// String utilDir = genModel.getModelDirectory() + "/" + genPackage.getBasePackage().replace('.', '/') +"/util/" + genPackage.getPrefix() + "AutoContainmentVisitor.java";
		
		URI uri = URI.createFileURI(outputFolder + "/" + getAutoLookupVisitorClassName(projectPrefix) + ".java");
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
		//String packageName = getCS2ASVisitorPackageName(projectName); 
		
		//String className = prefix + "AutoContainmentVisitor";
		String className = getAutoLookupVisitorClassName(prefix);
		AS2CGVisitor as2cgVisitor = createAS2CGVisitor();
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		cgPackage.setName(packageName);
		CGClass cgClass = CGModelFactory.eINSTANCE.createCGClass();
		cgClass.setName(className);
		// GenPackage superGenPackage2 = superGenPackage;
		String superProjectPrefix2 = superProjectPrefix;
//		if (superProjectPrefix2 != null) {
//			// String superPackageName = super
//			String superPackageName = getCS2ASVisitorPackageName(DomainUtil.nonNullState(superManualVisitorPackage));
//			// String superClassName = superGenPackage2.getPrefix() + "AutoContainmentVisitor";
//			String superClassName = getManualVisitorClassName(superProjectPrefix2);
//			// String superInterfaceName = /*trimmed*/prefix + "Visitor";
//			String superInterfaceName = visitorClass;
//			
//			CGClass superClass = getExternalClass(superPackageName, superClassName, false);
//			cgClass.getSuperTypes().add(superClass);
//			CGClass superInterface = getExternalClass(visitorPackage, superInterfaceName, true);
//			superInterface.getTemplateParameters().add(getExternalClass(Continuation.class, (CGClass)null));
//			cgClass.getSuperTypes().add(superInterface);
//		}
//		else {
			// String superClassName = "Abstract" + /*trimmed*/prefix + "CSVisitor";
			String superClassName = "AbstractExtending" + visitorClass; // The default Abstract Visitor generated for the language
			CGClass superClass = getExternalClass(visitorPackage, superClassName, false);
			superClass.getTemplateParameters().add(getExternalClass(packageName, nProvider.getSpecificEnvironmentItf(), true));			
			superClass.getTemplateParameters().add(getExternalClass(packageName, nProvider.getCommonContextItf(), true, getExternalClass(Element.class))); // FIXME ASBH parametrize Element
			cgClass.getSuperTypes().add(superClass);
			
			CGClass superInterface = getExternalClass(packageName, nProvider.getSpecificVisitorItf(), true);
			cgClass.getSuperTypes().add(superInterface);
//		}
		cgPackage.getClasses().add(cgClass);
		for (Type asType : asPackage.getOwnedType()) {
		
			CGOperation cgOperation = NameResoCGModelFactory.eINSTANCE.createCGEnvVisitOp();
			cgOperation.setName("visit" + asType.getName());
			cgOperation.setAst(asType);
			cgClass.getOperations().add(cgOperation);
			
			CGEnvVisitOpBody cgOpBody = NameResoCGModelFactory.eINSTANCE.createCGEnvVisitOpBody();			
			cgOperation.setBody(cgOpBody);
			
			for (Operation asOperation : asType.getOwnedOperation()) {
				if (NameResolutionUtil.isEnvOperation(asOperation)) {
					CGEnvVisitIfPart cgEnvOpIfPart = NameResoCGModelFactory.eINSTANCE.createCGEnvVisitIfPart();
					cgEnvOpIfPart.setPropertyName(NameResolutionUtil.getEnvOpPropertyName(asOperation));					
					cgEnvOpIfPart.setEnvExpression((CGValuedElement) asOperation.getBodyExpression().accept(as2cgVisitor));
					
					
				}
			}
		}
		return cgPackage;
	}

	@NonNull
	protected AutoNameResoCGNamesProvider createNamesProviders(@NonNull String projectPrefix) {
		return new AutoNameResoCGNamesProvider(projectPrefix);
	}
	
	protected @NonNull String getAutoLookupVisitorClassName(@NonNull String prefix) {
		return nProvider.getSpecificVisitorClass();
	}
	
	protected @NonNull String getManualLookupVisitorClassName(@NonNull String prefix) {
		return nProvider.getCustomSpecificVisitorClass();  
	}
		
}
