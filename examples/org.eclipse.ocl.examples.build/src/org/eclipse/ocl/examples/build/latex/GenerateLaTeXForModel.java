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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Model;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.RootCS;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;

public abstract class GenerateLaTeXForModel extends GenerateLaTeXUtils
{
	protected String cs2asFile;
	protected String cs2csFile;

	protected abstract @NonNull String generateLaTeX(@NonNull org.eclipse.ocl.examples.pivot.Package asPackage,
			@Nullable org.eclipse.ocl.examples.pivot.Package cs2asPackage,
			@Nullable org.eclipse.ocl.examples.pivot.Package cs2csPackage);
	
	protected @Nullable org.eclipse.ocl.examples.pivot.Package getPrimaryPackage(@NonNull MetaModelManager metaModelManager, @Nullable Resource oclResource) {
		if (oclResource != null) {
			for (EObject eContent : oclResource.getContents()) {
				if (eContent instanceof RootCS) {
					Element asRoot = ((RootCS)eContent).getPivot();
					if (asRoot instanceof Model) {
						for (org.eclipse.ocl.examples.pivot.Package asPackage : ((Model)asRoot).getOwnedPackages()) {
							return asPackage;
						}
					}
				}
			}
		}
		return null;
	}
	
	protected @Nullable org.eclipse.ocl.examples.pivot.Package getSecondaryPackage(@NonNull MetaModelManager metaModelManager, @Nullable Resource oclResource) {
		if (oclResource != null) {
			for (EObject eContent : oclResource.getContents()) {
				if (eContent instanceof RootCS) {
					Element asRoot = ((RootCS)eContent).getPivot();
					if (asRoot instanceof Model) {
						for (org.eclipse.ocl.examples.pivot.Package asPackage : ((Model)asRoot).getOwnedPackages()) {
							return asPackage;
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		String rootPath = StandaloneSetup.getPlatformRootPath();
//		PivotStandaloneSetup.doSetup();
		CompleteOCLStandaloneSetup.doSetup();
		File folder = new File(rootPath + latexFolder);
		folder.mkdirs();
		OCL ocl = OCL.newInstance();
		try {
			MetaModelManager metaModelManager = ocl.getMetaModelManager();
			ResourceSet resourceSet = metaModelManager.getExternalResourceSet();
			org.eclipse.ocl.examples.pivot.Package asPackage = null;
			org.eclipse.ocl.examples.pivot.Package cs2asPackage = null;
			org.eclipse.ocl.examples.pivot.Package cs2csPackage = null;
			if ((cs2asFile != null) && (cs2asFile.length() > 0)) {
				String cs2asSourceFile = "/" + projectName + "/" + cs2asFile;
				URI cs2asURI = DomainUtil.nonNullState(URI.createPlatformResourceURI(cs2asSourceFile, true));
				log.info("Loading Model '" + cs2asURI);
				Resource oclResource = ocl.load(cs2asURI);
				cs2asPackage = getSecondaryPackage(metaModelManager, oclResource);
			}
			if ((cs2csFile != null) && (cs2csFile.length() > 0)) {
				String cs2csSourceFile = "/" + projectName + "/" + cs2csFile;
				URI cs2csURI = DomainUtil.nonNullState(URI.createPlatformResourceURI(cs2csSourceFile, true));
				log.info("Loading Model '" + cs2csURI);
				Resource oclResource = ocl.load(cs2csURI);
				cs2csPackage = getSecondaryPackage(metaModelManager, oclResource);
			}
			if (cs2asPackage != null) {
				asPackage = (org.eclipse.ocl.examples.pivot.Package)metaModelManager.getPrimaryPackage(cs2asPackage);
			}
			else if (cs2csPackage != null) {
				asPackage = (org.eclipse.ocl.examples.pivot.Package)metaModelManager.getPrimaryPackage(cs2csPackage);
			}
			else {
				sourceFile = "/" + projectName + "/" + modelFile;
				URI fileURI = URI.createPlatformResourceURI(sourceFile, true);
				log.info("Loading Model '" + fileURI);
				Resource eResource = resourceSet.getResource(fileURI, true);
				if (eResource == null) {
					issues.addError(this, "No eResource for + ;" + fileURI + "'", null, null, null);
					return;
				}
				Ecore2Pivot adapter = Ecore2Pivot.getAdapter(eResource, metaModelManager);
				Model asModel = adapter.getPivotModel();
				asPackage = asModel.getOwnedPackages().get(0);
			}
			EObject eObject = asPackage.getETarget();
			Resource eResource = eObject.eResource();
			if (eResource != null) {
				String message = PivotUtil.formatResourceDiagnostics(DomainUtil.nonNullEMF(eResource.getErrors()), "OCLstdlib parse failure", "\n");
				if (message != null) {
					issues.addError(this, message, null, null, null);
					return;
				}
//				ASSaver saver = new ASSaver(asResource);
//				saver.localizeSpecializations();
				String fileName = folder + "/" + latexFileName + ".tex";
				log.info("Generating '" + fileName + "'");
				String latexContent = generateLaTeX(asPackage, cs2asPackage, cs2csPackage);
				String encodedContent = encodeForLaTeX(latexContent);
				FileWriter fw = new FileWriter(fileName);
				fw.append(encodedContent);
				fw.close();
			}
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		} finally {
			ocl.dispose();
		}
	}

	/**
	 * The projectName relative path to the CS2AS rules. (e.g. "model/BaseCS2AS.ocl")
	 */
	public void setCs2asFile(String cs2asFile) {
		this.cs2asFile = cs2asFile;
	}

	/**
	 * The projectName relative path to the CS2CS rules. (e.g. "model/BaseCS2CS.ocl")
	 */
	public void setCs2csFile(String cs2csFile) {
		this.cs2csFile = cs2csFile;
	}
}
