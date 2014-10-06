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
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.ClassloaderClasspathUriResolver;

public abstract class GenerateLaTeXForGrammar extends GenerateLaTeXUtils
{
	public class ClasspathURIHandler extends URIHandlerImpl
	{
		private final @NonNull ClassloaderClasspathUriResolver resolver = new ClassloaderClasspathUriResolver();
	
		@Override
		public boolean canHandle(URI uri) {
			return "classpath".equals(uri.scheme());
		}
	
		@Override
		public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
			try {
				URI resolvedURI = resolver.findResourceOnClasspath(getClass().getClassLoader(), uri);
				return super.createInputStream(resolvedURI, options);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	protected String labelPrefix = "";

	protected abstract String encodeForLaTeX(String latexContent);
	
	protected abstract @NonNull String generateLaTeX(@NonNull Grammar xtextModel);

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		String rootPath = StandaloneSetup.getPlatformRootPath();
		XtextStandaloneSetup.doSetup();
		CompleteOCLStandaloneSetup.doSetup();
		EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
		uriHandlers.add(0, new ClasspathURIHandler());
		File folder = new File(rootPath + latexFolder);
		folder.mkdirs();
		try {
			sourceFile = "/" + projectName + "/" + modelFile;
			URI fileURI = URI.createPlatformResourceURI(sourceFile, true);
			log.info("Loading Grammar '" + fileURI);
			ResourceSet resourceSet = getResourceSet();
			Resource xtextResource = resourceSet.getResource(fileURI, true);
			String message = PivotUtil.formatResourceDiagnostics(DomainUtil.nonNullEMF(xtextResource.getErrors()), "Grammar parse failure", "\n");
			if (message != null) {
				issues.addError(this, message, null, null, null);
				return;
			}
			EObject xtextModel = DomainUtil.nonNullState(xtextResource.getContents().get(0));
			String fileName = folder + "/" + latexFileName + ".tex";
			log.info("Generating '" + fileName + "'");
			String latexContent = generateLaTeX((Grammar)xtextModel);
			String encodedContent = encodeForLaTeX(latexContent);
			FileWriter fw = new FileWriter(fileName);
			fw.append(encodedContent);
			fw.close();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	/**
	 * The prefix to apply to all Latex labels (e.g. "ocl:EssentialOCL:")
	 */
	public void setLabelPrefix(String labelPrefix) {
		this.labelPrefix = labelPrefix;
	}
}
