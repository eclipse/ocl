/*******************************************************************************
 * Copyright (c) 2012,2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.oclinecore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLCommon;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.common.internal.options.CodeGenerationMode;
import org.eclipse.ocl.common.internal.options.CommonOptions;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.library.LibraryConstants;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotConstants;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.pivot.ecore.AS2Ecore;
import org.eclipse.ocl.pivot.ecore.Ecore2AS;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.pivot.util.PivotInternalPlugin;
import org.eclipse.ocl.pivot.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.uml2.codegen.ecore.genmodel.util.UML2GenModelUtil;

public class OCLinEcoreGenModelGeneratorAdapter extends GenBaseGeneratorAdapter
{
	public static final @NonNull String OCL_GENMODEL_URI = "http://www.eclipse.org/OCL/GenModel";
	public static final @NonNull String USE_DELEGATES_KEY = "Use Delegates";
	public static final @NonNull String USE_NULL_ANNOTATIONS_KEY = "Use Null Annotations";

	/**
	 * Return true if the genModel has a {@link #OCL_GENMODEL_URI} GenAnnotation with a
	 * {@link #USE_DELEGATES_KEY} detail set to true, or if there is no such GenAnnotation and the
	 * global preference {@link CommonOptions#CODE_GENERATION_MODE}
	 * has been set to {@link CodeGenerationMode#DELEGATED}
	 */
	public static boolean useDelegates(@NonNull GenModel genModel) {
		GenAnnotation genAnnotation = genModel.getGenAnnotation(OCL_GENMODEL_URI);
		if (genAnnotation != null) {
			EMap<String, String> details = genAnnotation.getDetails();
			if (details.containsKey(USE_DELEGATES_KEY)) {
				return Boolean.valueOf(details.get(USE_DELEGATES_KEY));
			}
		}
		CodeGenerationMode preference = CommonOptions.CODE_GENERATION_MODE.getPreferredValue();
		if (preference == CodeGenerationMode.DELEGATED) {
			return true;
		}
		return false;
	}

	/**
	 * Return true if the genModel has a {@link #OCL_GENMODEL_URI} GenAnnotation with a
	 * {@link #USE_NULL_ANNOTATIONS_KEY} detail set to true.
	 */
	public static boolean useNullAnnotations(@NonNull GenModel genModel) {
		GenAnnotation genAnnotation = genModel.getGenAnnotation(OCL_GENMODEL_URI);
		if (genAnnotation != null) {
			EMap<String, String> details = genAnnotation.getDetails();
			if (details.containsKey(USE_NULL_ANNOTATIONS_KEY)) {
				return Boolean.valueOf(details.get(USE_NULL_ANNOTATIONS_KEY));
			}
		}
//		CodeGenerationMode preference = OCLCommon.getPreference(CommonOptions.CODE_GENERATION_MODE, null);
//		if (preference == CodeGenerationMode.DELEGATED) {
//			return true;
//		}
		return false;
	}

	private @NonNull Set<GenModel> hadDelegates = new HashSet<GenModel>();
	private @NonNull Map<GenPackage, String> constantsTexts = new HashMap<GenPackage, String>();
	
	public OCLinEcoreGenModelGeneratorAdapter(@NonNull OCLinEcoreGeneratorAdapterFactory generatorAdapterFactory) {
		super(generatorAdapterFactory);
	}

	protected void convertConstraintToOperation(@NonNull Ecore2AS ecore2as, @NonNull GenModel genModel, @NonNull EClassifier eClassifier, @NonNull String key, @NonNull String body, @Nullable String message) {
		org.eclipse.ocl.pivot.Class pType = ecore2as.getCreated(org.eclipse.ocl.pivot.Class.class, eClassifier);
		if (pType != null) {
			List<Constraint> ownedInvariants = pType.getOwnedInvariants();
			for (Constraint rule : ownedInvariants) {
				String ruleName = rule.getName();
				if (ruleName == null) {
					ruleName = "";
				}
				if (ruleName.equals(key)) {
					String prefix = UML2GenModelUtil.getInvariantPrefix(genModel);
					if (prefix == null) {
						prefix = "";
					}
					EOperation eOperation = AS2Ecore.createConstraintEOperation(rule, prefix + ruleName, null);
					((EClass)eClassifier).getEOperations().add(eOperation);
					ecore2as.addMapping(eOperation, rule);
					if (message != null) {
						body = PivotUtil.createTupleValuedConstraint(body, null, message);
					}
					EcoreUtil.setAnnotation(eOperation, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT, "body", body);
				}
			}
		}
	}

	protected void convertConstraintsToOperations(@NonNull MetaModelManager metaModelManager, @NonNull GenModel genModel) {
		List<GenPackage> genPackages = genModel.getAllGenPackagesWithClassifiers();
		for (GenPackage genPackage : genPackages) {
			EPackage ecorePackage = genPackage.getEcorePackage();
			Resource ecoreResource = ecorePackage.eResource();
			if (ecoreResource != null) {
				Ecore2AS ecore2as = Ecore2AS.getAdapter(ecoreResource, metaModelManager);
				if (ecore2as != null) {
					for (GenClass genClass : genPackage.getGenClasses()) {
						EClass eClass = genClass.getEcoreClass();
						if (eClass != null) {
							EClassifier eClassifier = eClass;
							List<EAnnotation> obsoleteAnnotations = null;
							for (EAnnotation eAnnotation : eClassifier.getEAnnotations()) {
								String source = eAnnotation.getSource();
								if (OCLCommon.isDelegateURI(source)) {
									@SuppressWarnings("deprecation")
									String messageAnnotationDetailSuffix = PivotConstants.MESSAGE_ANNOTATION_DETAIL_SUFFIX;
									EMap<String, String> details = eAnnotation.getDetails();
									for (String key : details.keySet()) {
										if ((key != null) && !key.endsWith(messageAnnotationDetailSuffix)) {
											String expression = details.get(key);
											String messageExpression = details.get(key + messageAnnotationDetailSuffix);
											if (expression != null) {
												convertConstraintToOperation(ecore2as, genModel, eClassifier, key, expression, messageExpression);
											}
										}
									}
									if (obsoleteAnnotations == null) {
										obsoleteAnnotations = new ArrayList<EAnnotation>();
									}
									obsoleteAnnotations.add(eAnnotation);
								}
							    if (EcorePackage.eNS_URI.equals(source))
							    {
							      eAnnotation.getDetails().remove("constraints");
							    }
							}
							if (obsoleteAnnotations != null) {
								eClassifier.getEAnnotations().removeAll(obsoleteAnnotations);
							}
							genClass.initialize(eClass);
						}
					}
				}
			}
		}
	}

	protected void createDispatchTables(@NonNull GenModel genModel, @NonNull Monitor monitor) throws IOException {
        try {
    		String lineDelimiter = getLineDelimiter(genModel);
   	     	genModel.setLineDelimiter(lineDelimiter);
   			File projectFolder = getProjectFolder(genModel);
   			List<GenPackage> genPackages = genModel.getAllGenPackagesWithClassifiers();
   			for (@SuppressWarnings("null")@NonNull GenPackage genPackage : genPackages) {
	   			OCLinEcoreTables generateTables = new OCLinEcoreTables(genPackage);
	   			String tablesClass = generateTables.getTablesClassName();
	   			String dir = genPackage.getReflectionPackageName().replace(".", "/");
	   			generateTables.generateTablesClass(constantsTexts.get(genPackage));
	   			String str = generateTables.toString();
	   			File tablesFolder = new File(projectFolder, dir);
	   			tablesFolder.mkdirs();
	   			File file = new File(tablesFolder, tablesClass + ".java");
				FileWriter testFile = new FileWriter(file);
	   			testFile.append(str);
	   			testFile.close();
   			}
        }
        finally {
        	genModel.setLineDelimiter(null);
        }
	}

	/**
	 * Create a Map of feature identification to body to be embedded in the EMF model.
	 * @throws IOException 
	 */
	protected @NonNull Map<String, String> createFeatureBodies(@NonNull GenModel genModel) throws IOException {
		Map<String, String> allResults = new HashMap<String, String>();
		List<GenPackage> genPackages = genModel.getAllGenPackagesWithClassifiers();
		for (@SuppressWarnings("null")@NonNull GenPackage genPackage : genPackages) {
			OCLinEcoreCodeGenerator.generatePackage(genPackage, allResults, constantsTexts);
		}
        List<String> resultsKeys = new ArrayList<String>(allResults.keySet());
        Collections.sort(resultsKeys);
		return allResults;
	}

	@Override
	protected Diagnostic doPreGenerate(Object object, Object projectType) {
		assert object != null;
		GenModel genModel = (GenModel) object;
	    try {
			if ((projectType == MODEL_PROJECT_TYPE) && !useDelegates(genModel) && (hasDelegates(genModel) || hadDelegates.contains(genModel))) {
				List<String> modelPluginVariables = genModel.getModelPluginVariables();
				if (!modelPluginVariables.contains(LibraryConstants.PLUGIN_ID)) {
					modelPluginVariables.add(LibraryConstants.PLUGIN_ID);
				}				
				if (!modelPluginVariables.contains(PivotInternalPlugin.PLUGIN_ID)) {	// FIXME delete me BUG 401862
					modelPluginVariables.add(PivotInternalPlugin.PLUGIN_ID);
				}				
				if (!modelPluginVariables.contains("org.eclipse.ocl.examples.codegen")) {	// FIXME delete me BUG 401862
					modelPluginVariables.add("org.eclipse.ocl.examples.codegen");
				}				
				if (useNullAnnotations(genModel) && !modelPluginVariables.contains("org.eclipse.ocl.jdt.annotation7")) {
					modelPluginVariables.add("org.eclipse.ocl.jdt.annotation7");
				}
				for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
					createImportManager(genPackage.getReflectionPackageName(), genPackage.getFactoryInterfaceName() + AbstractGenModelHelper.TABLES_CLASS_SUFFIX);	// Only used to suppress NPE
				}
				Resource genResource = genModel.eResource();
				ResourceSet resourceSet = genResource.getResourceSet();
				if (resourceSet == null) {
					throw new NullPointerException("No ResourceSet for genmodel");
				}
				MetaModelManager metaModelManager = MetaModelManager.findAdapter(resourceSet);
				MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
				metaModelManager = adapter.getMetaModelManager();
				convertConstraintsToOperations(metaModelManager, genModel);
			    Map<String, String> results = createFeatureBodies(genModel);			
				installJavaBodies(metaModelManager, genModel, results);
				pruneDelegates(genModel);
			}
		} catch (Exception e) {
			BasicDiagnostic thisDiagnostic = new BasicDiagnostic(Diagnostic.ERROR, getClass().getPackage().getName(), 0, "Failed to pre-generate " + genModel.getModelPluginID() + " constraints", new Object[]{e});
			Diagnostic thatDiagnostic = super.doPreGenerate(object, projectType);
			if (thatDiagnostic.getSeverity() == Diagnostic.OK) {
				return thisDiagnostic;
			}
			else {
				thatDiagnostic.getChildren().add(thisDiagnostic);
				return thatDiagnostic;
			}
		}
		return super.doPreGenerate(object, projectType);
	}

	@Override
	protected Diagnostic generateModel(Object object, Monitor monitor) {
		assert object != null;
		GenModel genModel = (GenModel) object;
	    try {
			if (!useDelegates(genModel) && hadDelegates.contains(genModel)) {
			    monitor.beginTask("", 4);
			    monitor.subTask("Generating Dispatch Tables");
				for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
					createImportManager(genPackage.getReflectionPackageName(), genPackage.getFactoryInterfaceName() + AbstractGenModelHelper.TABLES_CLASS_SUFFIX);	// Only used to suppress NPE
				}
				createDispatchTables(genModel, monitor);
			    monitor.worked(1);
			    monitor.worked(1);
				if (EMFPlugin.IS_ECLIPSE_RUNNING) {
				    IWorkspace workspace = ResourcesPlugin.getWorkspace();
					String modelProjectDirectory = genModel.getModelProjectDirectory();
				    IProject modelProject = workspace.getRoot().getProject(modelProjectDirectory);
				    modelProject.refreshLocal(IResource.DEPTH_INFINITE, BasicMonitor.toIProgressMonitor(monitor));
				}
			    monitor.worked(1);
			}
		} catch (Exception e) {
			BasicDiagnostic thisDiagnostic = new BasicDiagnostic(Diagnostic.ERROR, getClass().getPackage().getName(), 0, "Failed to generate " + genModel.getModelPluginID() + " tables and bodies", new Object[]{e});
//			Diagnostic thatDiagnostic = super.generateModel(object, monitor);
//			if (thatDiagnostic.getSeverity() == Diagnostic.OK) {
				return thisDiagnostic;
//			}
//			else {
//				thatDiagnostic.getChildren().add(thisDiagnostic);
//				return thatDiagnostic;
//			}
		}
		return super.generateModel(object, monitor);
	}

	/**
	 * Deduce the required line delimiter from the usage in the .project file.
	 */
	protected String getLineDelimiter(GenModel genModel) {
		String modelProjectDirectory = genModel.getModelProjectDirectory() + "/.project";
		URI workspacePath = URI.createURI(modelProjectDirectory);
		String targetFileEncoding = getEncoding(workspacePath);
		return getLineDelimiter(workspacePath, targetFileEncoding);
	}

	protected @NonNull File getProjectFolder(@NonNull GenModel genModel) {
		String modelProjectDirectory = genModel.getModelProjectDirectory();
		String modelDirectory = genModel.getModelDirectory();
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
		    IWorkspace workspace = ResourcesPlugin.getWorkspace();
		    IProject modelProject = workspace.getRoot().getProject(modelProjectDirectory);
		    IPath javaSource = new Path(modelDirectory);
		    IFolder folder = modelProject.getParent().getFolder(javaSource);
		    java.net.URI locationURI = ClassUtil.nonNullState(folder.getLocationURI());
		    return ClassUtil.nonNullState(URIUtil.toFile(locationURI));
		}
		else {
		    URI locationURI = URI.createPlatformResourceURI(modelDirectory, true);
			ResourceSet resourceSet = genModel.eResource().getResourceSet();
			URIConverter uriConverter = resourceSet != null ? resourceSet.getURIConverter() : URIConverter.INSTANCE;
			URI normalizedURI = uriConverter.normalize(locationURI);
			return new File(normalizedURI.toFileString());
		}
	}
	
	protected boolean hasConstraints(org.eclipse.ocl.pivot.Class pivotClass) {
		if (pivotClass.getOwnedInvariants().size() > 0) {
			return true;
		}
		for (Operation operation : PivotQueries.getOperations(pivotClass)) {
			if (operation.getOwnedPreconditions().size() > 0) {
				return true;
			}
			if (operation.getOwnedPostconditions().size() > 0) {
				return true;
			}
			if (operation.getBodyExpression() != null) {
				return true;
			}
		}
		for (Property property : PivotQueries.getProperties(pivotClass)) {
			if (property.getOwnedExpression() != null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return true if any local GenPackage is for an EPackage that has OCL validation/setting/invocation delegates.
	 */
	protected boolean hasDelegates(@NonNull GenModel genModel) {
		for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
			EPackage ePackage = genPackage.getEcorePackage();
			if ((ePackage != null) && hasDelegates(ePackage)) {
				return true;
			}
		}
		return false;
	}
	protected boolean hasDelegates(@NonNull EPackage ePackage) {
		List<String> validationDelegates = EcoreUtil.getValidationDelegates(ePackage);
		for (String validationDelegate : validationDelegates) {
			if (OCLCommon.isDelegateURI(validationDelegate)) {
				return true;
			}
		}
		List<String> settingDelegates = EcoreUtil.getSettingDelegates(ePackage);
		for (String settingDelegate : settingDelegates) {
			if (OCLCommon.isDelegateURI(settingDelegate)) {
				return true;
			}
		}
		List<String> invocationDelegates = EcoreUtil.getInvocationDelegates(ePackage);
		for (String invocationDelegate : invocationDelegates) {
			if (OCLCommon.isDelegateURI(invocationDelegate)) {
				return true;
			}
		}
		return false;
	}

	protected void installJavaBodies(@NonNull MetaModelManager metaModelManager, @NonNull GenModel genModel, @NonNull Map<String, String> results) {
		List<GenPackage> genPackages = genModel.getAllGenPackagesWithClassifiers();
		for (GenPackage genPackage : genPackages) {
			EPackage ecorePackage = genPackage.getEcorePackage();
			Resource ecoreResource = ecorePackage.eResource();
			if (ecoreResource != null) {
				Ecore2AS ecore2as = Ecore2AS.getAdapter(ecoreResource, metaModelManager);
				if (ecore2as != null) {
					for (GenClass genClass : genPackage.getGenClasses()) {
						EClass eClass = genClass.getEcoreClass();
						if (eClass != null) {
							for (@SuppressWarnings("null")@NonNull EOperation eOperation : eClass.getEOperations()) {
								installOperation(ecore2as, eOperation, results);
							}
							for (@SuppressWarnings("null")@NonNull EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
								installProperty(ecore2as, eFeature, results);
							}
						}
					}
				}
			}
		}
	}

	protected void installOperation(@NonNull Ecore2AS ecore2as, @NonNull EOperation eOperation, @NonNull Map<String, String> results) {
		Element pOperation = ecore2as.getCreated(Element.class, eOperation);
		String fragmentURI = null;
		if (pOperation instanceof Operation) {
			fragmentURI = EcoreUtil.getURI(pOperation).fragment().toString();
		}
		else if (pOperation instanceof Constraint) {
			Constraint constraint = (Constraint) pOperation;
			fragmentURI = EcoreUtil.getURI(constraint.eContainer()).fragment().toString() + "==" + constraint.getName();
		}
		String body = fragmentURI != null ? results.get(fragmentURI) : null;
		if ((body == null) || ((body = body.trim()).length() == 0)) {
			body = "throw new UnsupportedOperationException();  // FIXME Unimplemented " + (pOperation != null ? AS2Moniker.toString(pOperation) : "");
		}
		EcoreUtil.setAnnotation(eOperation, GenModelPackage.eNS_URI, "body", body);
		List<EAnnotation> eAnnotations = eOperation.getEAnnotations();
		EAnnotation oclAnnotation = eOperation.getEAnnotation(OCLConstants.OCL_DELEGATE_URI);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
		}
		oclAnnotation = eOperation.getEAnnotation(OCLConstants.OCL_DELEGATE_URI_LPG);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
		}
		oclAnnotation = eOperation.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
		}
		oclAnnotation = eOperation.getEAnnotation(UML2GenModelUtil.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
		}
	}

	protected void installProperty(@NonNull Ecore2AS ecore2as, @NonNull EStructuralFeature eFeature, @NonNull Map<String, String> results) {
		Property pProperty = ecore2as.getCreated(Property.class, eFeature);
		String fragmentURI = EcoreUtil.getURI(pProperty).fragment().toString();
		String body = results.get(fragmentURI);
		if (body == null) {
			body = "throw new UnsupportedOperationException();  // FIXME Unimplemented " + (pProperty != null ? AS2Moniker.toString(pProperty) : "");
		}
		EcoreUtil.setAnnotation(eFeature, GenModelPackage.eNS_URI, "get", body);
//		EcoreUtil.setAnnotation(eFeature, GenModelPackage.eNS_URI, "body", body);
		List<EAnnotation> eAnnotations = eFeature.getEAnnotations();
		EAnnotation oclAnnotation = eFeature.getEAnnotation(OCLConstants.OCL_DELEGATE_URI);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
		}
		oclAnnotation = eFeature.getEAnnotation(OCLConstants.OCL_DELEGATE_URI_LPG);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
		}
		oclAnnotation = eFeature.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
		}
		oclAnnotation = eFeature.getEAnnotation(UML2GenModelUtil.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
		}
	}

	/**
	 * Eliminate all OCL validation/setting/invocation delegates.
	 */
	protected void pruneDelegates(@NonNull GenModel genModel) {
		for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
			EPackage ePackage = genPackage.getEcorePackage();
			if ((ePackage != null) && hasDelegates(ePackage)) {
				hadDelegates.add(genModel);
				EcoreUtil.setValidationDelegates(ePackage, pruneDelegates(EcoreUtil.getValidationDelegates(ePackage)));
				EcoreUtil.setSettingDelegates(ePackage, pruneDelegates(EcoreUtil.getSettingDelegates(ePackage)));
				EcoreUtil.setInvocationDelegates(ePackage, pruneDelegates(EcoreUtil.getInvocationDelegates(ePackage)));
			}
		}
	}
	protected List<String> pruneDelegates(@Nullable List<String> oldDelegates) {
		List<String> newDelegates = new ArrayList<String>();
		if (oldDelegates != null) {
			for (String aDelegate : oldDelegates) {
				if (!OCLCommon.isDelegateURI(aDelegate)) {
					newDelegates.add(aDelegate);
				}
			}
		}
		return newDelegates;
	}
}
