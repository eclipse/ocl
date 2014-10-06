/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Model;
import org.eclipse.ocl.examples.pivot.PivotStandaloneSetup;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public abstract class GenerateLaTeXForModel extends GenerateLaTeXUtils
{
	protected abstract @NonNull String generateLaTeX(@NonNull Model asModel);

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		String rootPath = StandaloneSetup.getPlatformRootPath();
		PivotStandaloneSetup.doSetup();
		File folder = new File(rootPath + latexFolder);
		folder.mkdirs();
		try {
			sourceFile = "/" + projectName + "/" + modelFile;
			URI fileURI = URI.createPlatformResourceURI(sourceFile, true);
			log.info("Loading Model '" + fileURI);
			ResourceSet resourceSet = getResourceSet();
			Resource eResource = resourceSet.getResource(fileURI, true);
			String message = PivotUtil.formatResourceDiagnostics(DomainUtil.nonNullEMF(eResource.getErrors()), "OCLstdlib parse failure", "\n");
			if (message != null) {
				issues.addError(this, message, null, null, null);
				return;
			}
			Ecore2Pivot adapter = Ecore2Pivot.getAdapter(eResource, null);
			Model asModel = adapter.getPivotModel();
//			ASSaver saver = new ASSaver(asResource);
//			saver.localizeSpecializations();
			String fileName = folder + "/" + latexFileName + ".tex";
			log.info("Generating '" + fileName + "'");
			String latexContent = generateLaTeX(asModel);
			FileWriter fw = new FileWriter(fileName);
			fw.append(latexContent);
			fw.close();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}
}
