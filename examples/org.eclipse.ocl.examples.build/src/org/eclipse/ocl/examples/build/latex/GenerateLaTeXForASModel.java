/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.latex;

import java.io.File;
import java.io.FileWriter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;

public abstract class GenerateLaTeXForASModel extends GenerateLaTeXUtils
{
	protected abstract @NonNull String generateLaTeX(@NonNull org.eclipse.ocl.pivot.Package asPackage);

	protected OCLInternal ocl;

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		String rootPath = StandaloneSetup.getPlatformRootPath();
//		PivotStandaloneSetup.doSetup();
		CompleteOCLStandaloneSetup.doSetup();
		File folder = new File(rootPath + latexFolder);
		folder.mkdirs();
		ocl = OCLInternal.newInstance();
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		ResourceSet resourceSet = ocl.getResourceSet();
		try {
			org.eclipse.ocl.pivot.Package asPackage = null;
			org.eclipse.ocl.pivot.Package wfrPackage = null;
			if ((wfrFile != null) && (wfrFile.length() > 0)) {
				String wfrSourceFile = "/" + projectName + "/" + wfrFile;
				URI wfrURI = ClassUtil.nonNullState(URI.createPlatformResourceURI(wfrSourceFile, true));
				log.info("Loading Model '" + wfrURI);
				Resource wfrResource = ocl.getCSResource(wfrURI);
				wfrPackage = getSecondaryPackage(metamodelManager, wfrResource);
			}
			if (wfrPackage != null) {
				for (org.eclipse.ocl.pivot.Class wfrClass : wfrPackage.getOwnedClasses()) {
					if (wfrClass != null) {
						org.eclipse.ocl.pivot.Class asClass = metamodelManager.getPrimaryClass(wfrClass);
						if (asClass != wfrClass) {
							asPackage = asClass.getOwningPackage();
							break;
						}
					}
				}
			}
			else {
				String sourceFile = "/" + projectName + "/" + modelFile;
				URI fileURI = URI.createPlatformResourceURI(sourceFile, true);
				log.info("Loading Model '" + fileURI);
				Resource eResource = resourceSet.getResource(fileURI, true);
				if (eResource == null) {
					issues.addError(this, "No eResource for + ;" + fileURI + "'", null, null, null);
					return;
				}
				String message = PivotUtil.formatResourceDiagnostics(ClassUtil.nonNullEMF(eResource.getErrors()), "OCLstdlib parse failure", "\n");
				if (message != null) {
					issues.addError(this, message, null, null, null);
					return;
				}
				Ecore2AS adapter = Ecore2AS.getAdapter(eResource, ocl.getEnvironmentFactory());
				Model asModel = adapter.getASModel();
				asPackage = asModel.getOwnedPackages().get(0);
			}
//			String message = PivotUtil.formatResourceDiagnostics(ClassUtil.nonNullEMF(eResource.getErrors()), "OCLstdlib parse failure", "\n");
//			if (message != null) {
//				issues.addError(this, message, null, null, null);
//				return;
//			}
//			ASSaver saver = new ASSaver(asResource);
//			saver.localizeSpecializations();
			String fileName = folder + "/" + latexFileName + ".tex";
			log.info("Generating '" + fileName + "'");
			String latexContent = generateLaTeX(ClassUtil.nonNullState(asPackage));
			String encodedContent = encodeForLaTeX(latexContent);
			FileWriter fw = new FileWriter(fileName);
			fw.append(encodedContent);
			fw.close();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		} finally {
			ocl.dispose();
		}
	}
}
