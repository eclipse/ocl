/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.xtend;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSet;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Model;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.utilities.ASSaver;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage;

public abstract class GenerateOCLstdlib extends GenerateOCLCommonXtend
{
	protected abstract @NonNull String generateMetamodel(@NonNull Model pivotModel);

	protected @Nullable Library getLibrary(@NonNull Model root) {
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof Library) {
				return (Library) eObject;
			}
		}
		return null;
	}
	
	@Override
	protected @NonNull List<CollectionType> getSortedCollectionTypes(@NonNull Model root) {
		List<CollectionType> sortedElements = super.getSortedCollectionTypes(root);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		String rootPath = StandaloneSetup.getPlatformRootPath();
		File folder = new File(rootPath + javaFolder + "/" + javaPackageName.replace(".", "/"));
		try {
			sourceFile = "/" + projectName + "/" + modelFile;
			URI fileURI = URI.createPlatformResourceURI(sourceFile, true);
			log.info("Loading OCL library '" + fileURI);
			ResourceSet resourceSet = getResourceSet();
			BaseCSResource xtextResource = (BaseCSResource)resourceSet.getResource(fileURI, true);
			String message = PivotUtil.formatResourceDiagnostics(DomainUtil.nonNullEMF(xtextResource.getErrors()), "OCLstdlib parse failure", "\n");
			if (message != null) {
				issues.addError(this, message, null, null, null);
				return;
			}
			ASResource asResource = xtextResource.getASResource(null);
//			if (asResource == null) {
//				return;
//			}
			EObject pivotModel = DomainUtil.nonNullState(asResource.getContents().get(0));
			ASSaver saver = new ASSaver(asResource);
			saver.localizeSpecializations();
			String fileName = folder + "/" + javaClassName + ".java";
			log.info("Generating '" + fileName + "'");
			String metaModel = generateMetamodel((Model)pivotModel);
			MergeWriter fw = new MergeWriter(fileName);
			fw.append(metaModel);
			fw.close();
			String saveFile = "/" + projectName + "/" + modelFile.replace("model", "model-gen").replace("oclstdlib", "oclas");
			URI saveURI = URI.createPlatformResourceURI(saveFile, true);
			log.info("Loading '" + saveURI + "'");
			log.info("Saving '" + saveURI + "'");
			asResource.setURI(saveURI);
			Map<String, Object> options = new HashMap<String, Object>();
			options.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
			asResource.save(options);
			MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(asResource);
			String ecoreFile = "/" + projectName + "/model-gen/oclstdlib.ecore";
			@SuppressWarnings("null")@NonNull URI ecoreURI = URI.createPlatformResourceURI(ecoreFile, true);
			Pivot2Ecore converter = new Pivot2Ecore(metaModelManager, ecoreURI, null);
			XMLResource eResource = converter.convertResource(asResource, ecoreURI);
			EPackage ePackage = (EPackage) DomainUtil.nonNullState(eResource.getContents().get(0));
			ePackage.setName("oclstdlib");
			ePackage.setNsPrefix("oclstdlib");
			setInstanceClassName(ePackage, "Bag", Bag.class, null);
			setInstanceClassName(ePackage, "Boolean", Boolean.class, null);
			setInstanceClassName(ePackage, "Collection", Collection.class, null);
			setInstanceClassName(ePackage, "Integer", IntegerValue.class, null);
			setInstanceClassName(ePackage, "OclAny", Object.class, "This Ecore representation of the pivot OclAny exists solely to support serialization of Ecore metamodels.\nTRue functionality is only available once converted to a Pivot model.");
//			setInstanceClassName(ePackage, "OclInvalid", InvalidValue.class, null);
//			setInstanceClassName(ePackage, "OclVoid", NullValue.class, null);
			setInstanceClassName(ePackage, "OrderedSet", OrderedSet.class, null);
			setInstanceClassName(ePackage, "Real", RealValue.class, null);
			setInstanceClassName(ePackage, "Sequence", List.class, null);
			setInstanceClassName(ePackage, "Set", Set.class, null);
			setInstanceClassName(ePackage, "String", String.class, null);
			setInstanceClassName(ePackage, "UniqueCollection", Set.class, null);
			setInstanceClassName(ePackage, "UnlimitedNatural", IntegerValue.class, null);
			EList<EClassifier> eClassifiers = ePackage.getEClassifiers();
			for (EClassifier eClassifier : new ArrayList<EClassifier>(eClassifiers)) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					eClass.getEGenericSuperTypes().clear();
					eClass.getEOperations().clear();
					eClass.getEStructuralFeatures().clear();
				}
				eClassifier.getEAnnotations().clear();
//				EAnnotation eAnnotation = eClassifier.getEAnnotation(PivotConstants.OMG_OCL_ANNOTATION_SOURCE);
//				if (eAnnotation != null) {
//					eClassifier.getEAnnotations().remove(eAnnotation);
//				}
//				eAnnotation = eClassifier.getEAnnotation(GenModelPackage.eNS_URI);
//				if (eAnnotation != null) {
//					eClassifier.getEAnnotations().remove(eAnnotation);
//				}
				String name = eClassifier.getName();
				if ((eClassifier.getInstanceClassName() == null)
				  && !name.equals("OclAny")
				  && !name.equals("OclInvalid")
				  && !name.equals("OclVoid")) {
					eClassifiers.remove(eClassifier);
				}
//				eClassifier.setName(LibraryConstants.ECORE_STDLIB_PREFIX + name);
//				eResource.setID(eClassifier, name);
			}
			ePackage.getEAnnotations().clear();
//			EAnnotation eAnnotation = ePackage.getEAnnotation(PivotConstants.OMG_OCL_ANNOTATION_SOURCE);
//			if (eAnnotation != null) {
//				ePackage.getEAnnotations().remove(eAnnotation);
//			}
//			eAnnotation = ePackage.getEAnnotation(GenModelPackage.eNS_URI);
//			if (eAnnotation != null) {
//				ePackage.getEAnnotations().remove(eAnnotation);
//			}
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(PivotConstants.AS_LIBRARY_ANNOTATION_SOURCE);
			ePackage.getEAnnotations().add(eAnnotation);
			log.info("Saving '" + ecoreURI + "'");
			eResource.save(null);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	private void setInstanceClassName(@NonNull EPackage ePackage, String typeName, Class<?> javaClass, @Nullable String comment) {
		EClassifier eClassifier = DomainUtil.nonNullState(ePackage.getEClassifier(typeName));
		if (eClassifier instanceof EClass) {
			String name = eClassifier.getName();
			ePackage.getEClassifiers().remove(eClassifier);
			eClassifier = EcoreFactory.eINSTANCE.createEDataType();
			eClassifier.setName(name);
			ePackage.getEClassifiers().add(eClassifier);
		}
		eClassifier.setInstanceClassName(javaClass.getName());
		if (comment != null) {
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(GenModelPackage.eNS_URI);
			eAnnotation.getDetails().put("body", comment);
			eClassifier.getEAnnotations().add(eAnnotation);
		}
	}

	/**
	 * The platform relative path to the Java generated source folder (e.g. "/org.eclipse.ocl.examples.pivot/emf-src")
	 */
	public void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}
}
