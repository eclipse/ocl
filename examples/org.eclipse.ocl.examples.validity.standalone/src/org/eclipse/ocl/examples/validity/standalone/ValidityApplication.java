/**
 * <copyright>
 *
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.validity.standalone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.export.IValidityExporter;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.IDEValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityViewRefreshJob;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.validation.PivotEObjectValidator.ValidationAdapter;
import org.eclipse.ocl.examples.validity.standalone.internal.ValidityStandaloneMessages;
import org.eclipse.ocl.examples.validity.standalone.util.StandaloneResponse;
import org.eclipse.ocl.examples.validity.standalone.util.StandaloneValidityManager;
import org.eclipse.ocl.examples.validity.standalone.util.ValidityStandaloneArgumentAnalyzer;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.completeocl.ui.commands.LoadCompleteOCLResourceHandler.Helper;

/**
 * This class executes an OCL evaluation of a model with one or several OCL
 * file(s). This class is intended to be used only in Standalone mode. The
 * result may be saved in a XMI file or exported as a HTML report.<br>
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class ValidityApplication implements IApplication {

	private static final Logger logger = Logger.getLogger(ValidityApplication.class);

	/** The arguments Constant. */
	private static final String ARGS_KEY = "application.args"; //$NON-NLS-1$

	/** The argument analyzer */
	private ValidityStandaloneArgumentAnalyzer commandAnalyzer;

	/** The Resource Set */
	private ResourceSet resourceSet = null;

	private Resource modelResource;

	private IDEValidityManager validityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	@Override
	public Object start(IApplicationContext context) {
		String[] args = (String[]) context.getArguments().get(ARGS_KEY);
		StandaloneResponse applicationCodeResponse = start(args);
		if (StandaloneResponse.VALIDATE.equals(applicationCodeResponse) ||StandaloneResponse.HELP.equals(applicationCodeResponse)) {
			return IApplication.EXIT_OK;
		}
		return IApplication.EXIT_RELAUNCH;
	}

	/**
	 * This launch the application using the entered arguments.
	 * 
	 * @param args
	 *            the application arguments.
	 * @return the application return code.
	 */
	public StandaloneResponse start(String[] args) {
		// Read and control the application arguments.
		StandaloneResponse applicationCodeResponse = checkArguments(args);
		if (StandaloneResponse.VALIDATE.equals(applicationCodeResponse)) {
			applicationCodeResponse = initializeValidateApplication();

			if (StandaloneResponse.VALIDATE.equals(applicationCodeResponse)) {
				// run the validation
				validate();

				// export results
				exportValidationResults(validityManager.getRootNode(), commandAnalyzer.getOutputFile());
			}
		} else if (StandaloneResponse.HELP.equals(applicationCodeResponse)) {
	        System.out.println(ValidityStandaloneMessages.OCLArgumentAnalyzer_help);
		}
		return applicationCodeResponse;
	}

	/**
	 * Runs the validation
	 */
	private void validate() {
		logger.info(ValidityStandaloneMessages.OCLValidatorApplication_ValidationStarting);
		validityManager.runValidation(new ValidityView());
		logger.info(ValidityStandaloneMessages.OCLValidatorApplication_ValidationComplete);
	}

	/**
	 * Reads and controls application arguments.
	 * 
	 * @param args
	 *            the entered arguments.
	 * @return A {@link StandaloneResponse}:
	 * <ul> 
	 * <li> the value of the '{@link StandaloneResponse <em>VALIDATE</em>}' enum if arguments are controlled well</li>
	 * <li> the value of the '{@link StandaloneResponse <em>HELP</em>}' enum if help is needed</li>
	 * <li> the value of the '{@link StandaloneResponse <em>EXIT</em>}' enum otherwise</li>
	 * </ul>
	 */
	private StandaloneResponse checkArguments(String[] args) {
		commandAnalyzer = new ValidityStandaloneArgumentAnalyzer(args);
		StandaloneResponse analyzerResponse = commandAnalyzer.parseCommandLine();
		if (StandaloneResponse.EXIT.equals(analyzerResponse)) {
			logger.error(ValidityStandaloneMessages.OCLValidatorApplication_Aborted);
		}
		return analyzerResponse;
	}

	/**
	 * Initiates the validity manager using the resourceSet.
	 * 
	 * @param resourceSet
	 *            the resource set.
	 */
	private void initiateValidityManager(ResourceSet resourceSet) {
		if (validityManager == null) {
			validityManager = new StandaloneValidityManager(
					new ValidityViewRefreshJob());
			StandaloneValidityManager.setRunJavaConstraints(commandAnalyzer.doRunJavaConstraints());
			StandaloneValidityManager.setRunOCLConstraints(commandAnalyzer.doRunOCLConstraints());
			StandaloneValidityManager.setRunUMLConstraints(commandAnalyzer.doRunUMLConstraints());
		}
		validityManager.setInput(resourceSet);
	}

	/**
	 * Initializes local variables.
	 * 
	 * @return the value of the '{@link StandaloneResponse <em>VALIDATE</em>}' enum if application is initialized well, 
	 * the value of the '{@link StandaloneResponse <em>EXIT</em>}' enum  otherwise.
	 */
	private StandaloneResponse initializeValidateApplication() {
		StandaloneResponse response = StandaloneResponse.VALIDATE;
		doCompleteOCLSetup(new ResourceSetImpl());

		if (!processResources(commandAnalyzer.getModelFilePath(), commandAnalyzer.getOCLPaths())) {
			logger.error(ValidityStandaloneMessages.OCLValidatorApplication_Aborted);
			response = StandaloneResponse.EXIT;
		} else {
			if (ValidationAdapter.findAdapter(resourceSet) == null) {
				logger.error(ValidityStandaloneMessages.OCLValidatorApplication_Aborted);
				response = StandaloneResponse.EXIT;
			} else {
				initiateValidityManager(resourceSet);
			}
		}

		return response;
	}

	/**
	 * Exports Validation results.
	 * 
	 * @param rootNode
	 *            the validity model rootNode.
	 * @param outputPath
	 *            the exported file path.
	 */
	private void exportValidationResults(RootNode rootNode, @Nullable File outputFile) {
		final IValidityExporter selectedExporter = commandAnalyzer.getExporter();
		if (selectedExporter != null && modelResource != null && rootNode != null) {
			logger.info(ValidityStandaloneMessages.OCLValidatorApplication_ExportStarting);
			Appendable s;
			try {
				s = outputFile != null ? new FileWriter(outputFile) : System.out;
				selectedExporter.export(s, modelResource, rootNode, outputFile != null ? outputFile.toString() : null);
			} catch (IOException e) {
				logger.error(ValidityStandaloneMessages.OCLValidatorApplication_ExportProblem, e);
			}
			logger.info(ValidityStandaloneMessages.OCLValidatorApplication_ExportedFileGenerated);
		} else {
			logger.info(ValidityStandaloneMessages.OCLValidatorApplication_ExportProblem);
		}
	}

	/**
	 * Loads the entered model and ocl files.
	 * 
	 * @param modelFilePath
	 *            the model to validate file path.
	 * @param oclPaths
	 *            the ocl files paths.
	 * @return true if there is not problem while loading, false otherwise.
	 */
	private boolean processResources(IPath modelFilePath, List<IPath> oclPaths) {
		boolean done = true;
		URI modelURI = getFileUri(modelFilePath);
		// Load model resource
		modelResource = loadModelFile(modelURI);
		if (modelResource == null) {
			logger.error(MessageFormat.format(ValidityStandaloneMessages.OCLValidatorApplication_ModelLoadProblem, modelFilePath));
			done = false;
		}

		Helper helper = new Helper(resourceSet) {
			@Override
			protected boolean error(@NonNull String primaryMessage, @Nullable String detailMessage) {
				logger.error(detailMessage);
				return false;
			}
		};

		for (IPath oclPath : oclPaths) {
			URI oclURI = getFileUri(oclPath);

			if (done && oclURI == null) {
				logger.error(MessageFormat.format(ValidityStandaloneMessages.OCLValidatorApplication_OclUriProblem, oclPath));
				done = false;
			}

			// Load ocl models
			if (done && loadModelFile(oclURI) == null) {
				logger.error(MessageFormat.format(ValidityStandaloneMessages.OCLValidatorApplication_OclLoadProblem, oclPath));
				done = false;
			}

			// Load as ocl documents
			try {
				if (done && (helper.loadResource(oclURI) == null)) {
					logger.error(MessageFormat.format(ValidityStandaloneMessages.OCLValidatorApplication_OclLoadProblem, oclPath));
					done = false;
				}
			} catch (Throwable e) {
				logger.error(MessageFormat.format(ValidityStandaloneMessages.OCLValidatorApplication_OclLoadProblem, oclPath));
				done = false;
			}
		}

		if (done && !helper.loadMetaModels()) {
			logger.error(ValidityStandaloneMessages.OCLValidatorApplication_MetaModelsLoadProblem);
			done = false;
		}

		helper.installPackages();
		return done;
	}

	/**
	 * Gets an URI from a file Path.
	 * 
	 * @param filePath
	 *            the file path.
	 * @return an URI from the path.
	 */
	private URI getFileUri(IPath filePath) {
		final URI fileUri;
		if (isRelativePath(filePath)) {
			fileUri = URI.createPlatformResourceURI(filePath.toString(), true);
		} else {
			fileUri = URI.createFileURI(filePath.toString());
		}
		return fileUri;
	}

	/**
	 * Initializes all the needed resource factories to create ecore and ocl
	 * resources in the global registry.
	 * 
	 * @param resourceSet
	 *            the resource set.
	 */
	private void doCompleteOCLSetup(ResourceSet resourceSet) {
		this.resourceSet = DomainUtil.nonNullState(resourceSet);
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			CompleteOCLStandaloneSetup.doSetup();
		}

		// Plug the OCL validation mechanism.
		OCLDelegateDomain.initialize(resourceSet);
	}

	/**
	 * Loads a file and returns The loaded resource.
	 */
	private Resource loadModelFile(URI fileUri) {
		Resource loadedResource = resourceSet.getResource(fileUri, true);
		if (!loadedResource.isLoaded()) {
			return null;
		}

		return loadedResource;
	}

	/**
	 * Checks if the path is relative or absolute.
	 * 
	 * @param path
	 *            a file path.
	 * @return true if the path is relative, false otherwise.
	 */
	private static boolean isRelativePath(IPath path) {
		try {
			IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
			return resource != null && resource.exists();
		} catch (IllegalStateException exception) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	@Override
	public void stop() {
		// Nothing to do
	}
}
