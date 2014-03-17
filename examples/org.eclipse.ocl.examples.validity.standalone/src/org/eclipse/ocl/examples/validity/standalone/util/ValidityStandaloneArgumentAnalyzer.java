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
package org.eclipse.ocl.examples.validity.standalone.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ocl.examples.emf.validation.validity.ui.export.AbstractExport;
import org.eclipse.ocl.examples.emf.validation.validity.ui.export.HTMLExport;
import org.eclipse.ocl.examples.emf.validation.validity.ui.export.TextExport;
import org.eclipse.ocl.examples.validity.standalone.ValidityApplication;
import org.eclipse.ocl.examples.validity.standalone.internal.ValidityStandaloneMessages;

/**
 * Argument analyzer for received parameters in the application representing the
 * validity Standalone mode.<br>
 * This analyzer is used to interpret the standalone command arguments:
 * <ul>
 * <li>"-model" A mandatory argument key of the model file path. This argument
 * key must be followed by the model file path.</li>
 * <li>"-rules" A mandatory argument used to define the paths to the OCL
 * documents containing the constraints to evaluate. Users can specify one or
 * several OCL Documents paths in the command line, separated with a whitespace.
 * A text file containing a list of OCL Documents paths can be used instead, in
 * which case all OCL constraints defined in all of these documents will be
 * evaluated sequentially.</li>
 * <li>"-output" An optional argument to define the output file path. The
 * exporter will create results within that target file.</li>
 * <li>"-exporter" An optional argument to specify which exporter should be
 * used. By default, the "txt" exporter will be used, exporting a textual report
 * of the validation.</li>
 * <li>"-using" This optional argument can be used if the user wishes to run all
 * constraints or to only run the OCL, Java or UML constraints validation.
 * Otherwise, all constraints will be checked against the input model.</li>
 * </ul>
 */
public class ValidityStandaloneArgumentAnalyzer {
	private static final Logger logger = Logger
			.getLogger(ValidityApplication.class);

	private static final TextExport textExporter = new TextExport();
	private static final HTMLExport htmlExporter = new HTMLExport();

	/**
	 * A mandatory argument key of the model file path. This argument key must
	 * be followed by the model file path.
	 */
	private static final String MODEL_ARG = "-model"; //$NON-NLS-1$

	/**
	 * A mandatory argument used to define the paths to the OCL documents
	 * containing the constraints to evaluate. Users can specify one or several
	 * OCL Documents paths in the command line, separated with a whitespace. A
	 * text file containing a list of OCL Documents paths can be used instead,
	 * in which case all OCL constraints defined in all of these documents will
	 * be evaluated sequentially.
	 */
	private static final String RULES_ARG = "-rules"; //$NON-NLS-1$

	/**
	 * An optional argument to define the output file path. The exporter will
	 * create results within that target file.
	 */
	private static final String OUTPUT_ARG = "-output"; //$NON-NLS-1$

	/**
	 * An optional argument to specify which exporter should be used. By
	 * default, the “txt” exporter will be used, exporting a textual report of
	 * the validation.
	 */
	private static final String EXPORTER_ARG = "-exporter"; //$NON-NLS-1$

	/**
	 * An optional argument used if the user wishes to run all constraints or to
	 * only run the OCL, Java or UML constraints validation. Otherwise, all
	 * constraints will be checked against the input model.
	 */
	private static final String REQUIRED_LOCATORS_ARG = "-using"; //$NON-NLS-1$

	/**
	 * "-exporter" argument value to export validation results using html
	 * format.
	 */
	private static final String HTML_EXPORTER_NAME = "html"; //$NON-NLS-1$

	/** html file extension. */
	private static final String HTML_FILE_EXTENSION = "html"; //$NON-NLS-1$
	/** txt file extension. */
	private static final String TXT_FILE_EXTENSION = "txt"; //$NON-NLS-1$

	/** "-using" argument value to run the all constraints (ocl, java and uml). */
	private static final String ALL_LOCATORS = "all"; //$NON-NLS-1$
	/** "-using" argument value to additionally run the OCL constraints. */
	private static final String OCL_LOCATOR = "ocl"; //$NON-NLS-1$
	/** "-using" argument value to additionally run the Java constraints. */
	private static final String JAVA_LOCATOR = "java"; //$NON-NLS-1$
	/** "-using" argument value to additionally run the UML constraints. */
	private static final String UML_LOCATOR = "uml"; //$NON-NLS-1$

	private static final String DEFAULT_EXPORTED_FILE_NAME = "log"; //$NON-NLS-1$ 

	/** Possible "text" extension file for the "-rules" argument entry. */
	private static final Object TEXT_FILE_EXTENSION = "txt"; //$NON-NLS-1$
	/** Possible "ocl" extension file for the "-rules" argument entry. */
	private static final Object OCL_FILE_EXTENSION = "ocl"; //$NON-NLS-1$

	private String[] arguments;
	private String keyword;
	private Stack<String> tokens = new Stack<String>();

	private IPath modelPath;
	private IPath outputFilePath;
	private AbstractExport exporter;
	private String outputFileExtension;
	private List<IPath> oclFilesPath = new ArrayList<IPath>();
	private boolean doRunOCLConstraints = false;
	private boolean doRunJavaConstraints = false;
	private boolean doRunUMLConstraints = false;

	/**
	 * Constructor
	 * 
	 * @param args
	 *            An array of arguments
	 */
	public ValidityStandaloneArgumentAnalyzer(String[] args) {
		arguments = args;
	}

	/**
	 * Gets the absolute path to the model file deduced from the value specified
	 * after the argument <b>-model</b>.
	 * 
	 * @return the model path as a String.
	 */
	public IPath getModelFilePath() {
		return modelPath;
	}

	/**
	 * Gets the absolute path to the output directory deduced from the value
	 * specified after the <b>-output</b> argument.
	 * 
	 * @return the result path of the output directory where result must be
	 *         stored.
	 */
	public IPath getOutputPath() {
		return outputFilePath;
	}

	/**
	 * Gets the collection of OCL resources deduced from values specified after
	 * the <b>-rule</b> argument.
	 * 
	 * @return A List of OCL Uris
	 */
	public List<IPath> getOCLPaths() {
		return oclFilesPath;
	}

	/**
	 * Gets the validation exporter corresponding to the argument read after the
	 * <b>-report</b> argument.
	 * 
	 * @return The validation exporter.
	 */
	public AbstractExport getExporter() {
		return exporter;
	}

	/**
	 * Gets "true" if the command line requires to only run the java
	 * constraints, "false otherwise.
	 * 
	 * @return <code>true</code> if the command line requires to only run the
	 *         java constraints, <code>false</code> otherwise.
	 */
	public boolean doRunJavaConstraints() {
		return doRunJavaConstraints;
	}

	/**
	 * Gets "true" if the command line requires to only run the ocl constraints,
	 * "false otherwise.
	 * 
	 * @return <code>true</code> if the command line requires to only run the
	 *         ocl constraints, <code>false</code> otherwise.
	 */
	public boolean doRunOCLConstraints() {
		return doRunOCLConstraints;
	}

	/**
	 * Gets "true" if the command line requires to only run the uml constraints,
	 * "false otherwise.
	 * 
	 * @return <code>true</code> if the command line requires to only run the
	 *         uml constraints, <code>false</code> otherwise.
	 */
	public boolean doRunUMLConstraints() {
		return doRunUMLConstraints;
	}

	/**
	 * Launches the analysis of the argument chains passed to the application.
	 * 
	 * @return A {@link StandaloneResponse}:
	 * <ul> 
	 * <li> the value of the '{@link StandaloneResponse <em>VALIDATE</em>}' enum if all required arguments are provided</li>
	 * <li> the value of the '{@link StandaloneResponse <em>HELP</em>}' enum if help is needed</li>
	 * <li> the value of the '{@link StandaloneResponse <em>EXIT</em>}' enum otherwise</li>
	 * </ul>
	 */
	public StandaloneResponse parseCommandLine() {
		final StandaloneResponse response;
		boolean valid = true;
		for (String arg : arguments) {
			if (keyword == null && !arg.startsWith("-")) { //$NON-NLS-1$
				keyword = arg;
			} else if (keyword != null && arg.startsWith("-")) { //$NON-NLS-1$
				tokens.add(arg);
			} else if (keyword != null) {
				String lastKeyword = tokens.lastElement();
				if (MODEL_ARG.equals(lastKeyword)) {
					valid &= checkModel(arg);
				} else if (RULES_ARG.equals(lastKeyword)) {
					checkOclFile(arg);
				} else if (OUTPUT_ARG.equals(lastKeyword)) {
					valid &= checkOutput(arg);
				} else if (EXPORTER_ARG.equals(lastKeyword)) {
					checkReportExporter(arg);
				} else if (REQUIRED_LOCATORS_ARG.equals(lastKeyword)) {
					valid &= checkRequiredLocators(arg);
				}
			}
		}

		if (StandaloneResponse.VALIDATE.getLabel().equals(keyword)) {
			if (oclFilesPath.isEmpty()) {
				logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_NoOCLFiles);
				return StandaloneResponse.EXIT;
			}

			valid &= checkArguments();
			valid &= checkValues();
			response = StandaloneResponse.VALIDATE;
		} else if (StandaloneResponse.HELP.getLabel().equals(keyword)) {
			response = StandaloneResponse.HELP;
		} else {
			logger.error(MessageFormat
					.format(ValidityStandaloneMessages.OCLArgumentAnalyzer_NoDefinedKeyword,
							StandaloneResponse.HELP));
			response = StandaloneResponse.EXIT;
		}

		if (!valid) {
			return StandaloneResponse.EXIT;
		}
		return response;
	}

	/**
	 * Inspects and checks that required arguments are present in the command
	 * line (model and rules arguments).
	 * 
	 * @return <code>true</code> if the required argument are used,
	 *         <code>false</code> if a required argument is missing.
	 */
	private boolean checkArguments() {
		boolean valid = true;
		// Mandatory "-model" argument
		if (!tokens.contains(MODEL_ARG)) {
			logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_ModelArg);
			valid = false;
		}
		// Mandatory "-rules" argument
		if (!tokens.contains(RULES_ARG)) {
			logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_RulesArg);
			valid = false;
		}
		return valid;
	}

	/**
	 * Inspects and checks that optional arguments are present or not in the
	 * command line (output, exporter, from arguments).
	 * 
	 * @return <code>true</code> if all arguments values are valid,
	 *         <code>false</code> if an argument value is not valid.
	 */
	private boolean checkValues() {
		boolean valid = true;
		// Mandatory "-model" argument value
		if (modelPath == null) {
			logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_ModelPathMissing);
			valid = false;
		}
		// Mandatory "-rules" argument value
		if (oclFilesPath.isEmpty()) {
			logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_RulesPathMissing);
			valid = false;
		}

		// Optional "-output" argument value
		if (!tokens.contains(OUTPUT_ARG)) {
			logger.info(ValidityStandaloneMessages.OCLArgumentAnalyzer_OutputArg);
			try {
				File outputFile = File.createTempFile(
						DEFAULT_EXPORTED_FILE_NAME, "." + TEXT_FILE_EXTENSION); //$NON-NLS-1$
				outputFilePath = new Path(outputFile.getAbsolutePath());
			} catch (IOException e) {
				logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_OutputFileCreationProblem);
			}
		} else if (outputFilePath == null) {
			logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_OutputFilePathMissing);
			valid = false;
		}

		// Optional "-exporter" argument value
		if (!tokens.contains(EXPORTER_ARG)) {
			logger.info(ValidityStandaloneMessages.OCLArgumentAnalyzer_ExporterArg);
			exporter = textExporter;
			outputFileExtension = TXT_FILE_EXTENSION;
		} else if (exporter == null) {
			logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_ExporterMissing);
			valid = false;
		}

		// validate output file extension
		if (outputFileExtension != null && outputFilePath != null) {
			String fileExtension = outputFilePath.getFileExtension();
			if (!outputFileExtension.equals(fileExtension)) {
				logger.error(MessageFormat
						.format(ValidityStandaloneMessages.OCLArgumentAnalyzer_OutputFileInvalidExtension,
								outputFileExtension));
				valid = false;
			}
		}

		// Optional "-locator" argument value
		if (tokens.contains(REQUIRED_LOCATORS_ARG) && !checkLocators()) {
			logger.info(ValidityStandaloneMessages.OCLArgumentAnalyzer_RestrictionMissing);
			valid = false;
		} else if (!tokens.contains(REQUIRED_LOCATORS_ARG)) {
			doRunOCLConstraints = true;
			doRunJavaConstraints = true;
			doRunUMLConstraints = true;
		}
		return valid;
	}

	/**
	 * Checks consistency of the model passed to the command line.
	 * 
	 * @param argument
	 *            the relative/absolute path to the resource to check.
	 * @return <code>true</code> if the model exists and is a file,
	 *         <code>false</code> otherwise.
	 */
	private boolean checkModel(String argument) {
		if (modelPath != null) {
			logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_ModelFile
					+ ValidityStandaloneMessages.OCLArgumentAnalyzer_AlreadyExists);
		} else {
			try {
				File file = new File(argument).getCanonicalFile();
				if (!file.exists()) {
					logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_ModelFile
							+ file.getAbsolutePath()
							+ ValidityStandaloneMessages.OCLArgumentAnalyzer_NotExist);
				} else if (!file.isFile()) {
					logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_ModelFile
							+ file.getAbsolutePath()
							+ ValidityStandaloneMessages.OCLArgumentAnalyzer_NotFile);
				} else {
					modelPath = new Path(file.getAbsolutePath());
					logger.info(ValidityStandaloneMessages.OCLArgumentAnalyzer_ModelFile
							+ file.getAbsolutePath()
							+ ValidityStandaloneMessages.OCLArgumentAnalyzer_found);
					return true;
				}
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return false;
	}

	/**
	 * 
	 * Check consistency of the output directory specified in the command line.
	 * 
	 * @param argument
	 *            the relative/absolute path to the output file.
	 * @return <code>true</code> if the output file/directory exists,
	 *         <code>false</code> otherwise.
	 */
	private boolean checkOutput(String argument) {
		try {
			File file = new File(argument).getCanonicalFile();
			if (file.exists()) {
				if (file.isFile()) {
					file.delete();
				} else {
					logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_OutputFile
							+ file.getAbsolutePath()
							+ ValidityStandaloneMessages.OCLArgumentAnalyzer_NotFile);
				}
			}
			if (!file.exists()) {
				outputFilePath = new Path(file.getAbsolutePath());
				File outputFolder = file.getParentFile();
				if (!outputFolder.exists()) {
					logger.error(ValidityStandaloneMessages.OCLArgumentAnalyzer_OutputDir
							+ outputFolder.getAbsolutePath()
							+ ValidityStandaloneMessages.OCLArgumentAnalyzer_NotExist);
				} else {
					return true;
				}
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	/**
	 * Checks consistency of the ocl file passed to the command line.
	 * 
	 * @param argument
	 *            is the path to the relative/absolute path to the resource
	 * @return <code>true</code> if the model exists and is a file,
	 *         <code>false</code> otherwise.
	 */
	private void checkOclFile(String argument) {
		boolean ignored = false;
		try {
			File file = new File(argument).getCanonicalFile();
			IPath path = new Path(file.getCanonicalPath());
			// a txt file may contain relative or absolute path to a set of OCL
			// files.
			if (TEXT_FILE_EXTENSION.equals(path.getFileExtension()
					.toLowerCase())) {
				extractOCLUris(file);
			} else if (OCL_FILE_EXTENSION.equals(path.getFileExtension()
					.toLowerCase())) {
				if (!file.exists()) {
					logger.warn(ValidityStandaloneMessages.OCLArgumentAnalyzer_OCLResource
							+ file.getAbsolutePath()
							+ ValidityStandaloneMessages.OCLArgumentAnalyzer_NotExist);
					ignored = true;
				} else if (!file.isFile()) {
					logger.warn(ValidityStandaloneMessages.OCLArgumentAnalyzer_OCLResource
							+ file.getAbsolutePath()
							+ ValidityStandaloneMessages.OCLArgumentAnalyzer_NotFile);
					ignored = true;
				} else if (!file.canRead()) {
					logger.warn(ValidityStandaloneMessages.OCLArgumentAnalyzer_OCLResource
							+ file.getAbsolutePath()
							+ ValidityStandaloneMessages.OCLArgumentAnalyzer_CannotBeRead);
					ignored = true;
				} else {
					oclFilesPath.add(new Path(file.getAbsolutePath()));
				}
			} else {
				logger.warn(ValidityStandaloneMessages.OCLArgumentAnalyzer_FileExt
						+ path.lastSegment()
						+ ValidityStandaloneMessages.OCLArgumentAnalyzer_ExtensionPb);
				ignored = true;
			}

			if (ignored) {
				logger.warn(ValidityStandaloneMessages.OCLArgumentAnalyzer_OCLFile
						+ file.getAbsolutePath()
						+ ValidityStandaloneMessages.OCLArgumentAnalyzer_ignored);

			} else {
				logger.info(ValidityStandaloneMessages.OCLArgumentAnalyzer_OCLFile
						+ file.getAbsolutePath()
						+ ValidityStandaloneMessages.OCLArgumentAnalyzer_found);
			}
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}

	/**
	 * 
	 * Check the specified additional constraints locators in the command line.
	 * 
	 * @param argument
	 *            the validation defines additional constraints kind {java,
	 *            uml}.
	 * @return <code>true</code> if the additional constraints are correctly
	 *         defined, <code>false</code> otherwise.
	 */
	private boolean checkRequiredLocators(String argument) {
		if (ALL_LOCATORS.equals(argument)) {
			doRunOCLConstraints = true;
			doRunJavaConstraints = true;
			doRunUMLConstraints = true;
		} else if (OCL_LOCATOR.equals(argument)) {
			doRunOCLConstraints = true;
		} else if (JAVA_LOCATOR.equals(argument)) {
			doRunJavaConstraints = true;
		} else if (UML_LOCATOR.equals(argument)) {
			doRunUMLConstraints = true;
		}
		return checkLocators();
	}

	/**
	 * 
	 * Check if the locators argument is specified or not in the command line.
	 * 
	 * @return <code>true</code> if the locators argument is correctly defined,
	 *         <code>false</code> otherwise.
	 */
	private boolean checkLocators() {
		return doRunOCLConstraints || doRunJavaConstraints
				|| doRunUMLConstraints;
	}

	/**
	 * Checks that the report exporter name is indicated, otherwise the text
	 * default exporter name is returned.
	 * 
	 * @param argument
	 *            Represents the name or a part of the name of the validation
	 *            exporter.
	 */
	private void checkReportExporter(String argument) {
		if (argument != null && HTML_EXPORTER_NAME.equals(argument)) {
			exporter = htmlExporter;
			outputFileExtension = HTML_FILE_EXTENSION;
		} else {
			exporter = textExporter;
			outputFileExtension = TXT_FILE_EXTENSION;
		}
	}

	/**
	 * Extracts information contained in the text file.
	 * 
	 * @param txtFile
	 *            The file containing relative path to OCL files.
	 */
	private void extractOCLUris(File txtFile) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(txtFile));
			String line = reader.readLine();
			while (line != null) {
				checkOclFile(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			logger.error(MessageFormat
					.format(ValidityStandaloneMessages.OCLArgumentAnalyzer_OCLFileNotFound,
							txtFile.getAbsolutePath()));
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
}
