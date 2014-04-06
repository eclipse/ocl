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
package org.eclipse.ocl.examples.validity.standalone.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ocl.examples.emf.validation.validity.export.HTMLExporter;
import org.eclipse.ocl.examples.emf.validation.validity.export.TextExporter;
import org.eclipse.ocl.examples.validity.standalone.util.ValidityStandaloneArgumentAnalyzer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ValidityStandaloneArgumentAnalyserTest {

	@Rule
	public TemporaryFolder outputFolder = new TemporaryFolder();

	private final String inputRootPath = "inputTest"; //$NON-NLS-1$

	private final String modelInputRootPath = inputRootPath + "/model"; //$NON-NLS-1$

	private final String oclInputRootPath = inputRootPath + "/ocl"; //$NON-NLS-1$

	private final String inputModelName = "EcoreTestFile.ecore"; //$NON-NLS-1$

	private final String inputOCLFileName = "eclipse_ocl_rule.ocl"; //$NON-NLS-1$

	private final String outputTextFileName = "log.txt"; //$NON-NLS-1$

	private final String outputHtmlFileName = "log.html"; //$NON-NLS-1$

	private final String textExporterAttribute = "text"; //$NON-NLS-1$

	private final String htmlExporterAttribute = "html"; //$NON-NLS-1$

	private final String anotherExporterAttribute = "another"; //$NON-NLS-1$

	private final String outputRootPath = outputFolder.toString();

	private ValidityStandaloneArgumentAnalyzer commandAnalyzer;

	private void runAnalyzer(String[] args)
			throws CoreException {
		commandAnalyzer = new ValidityStandaloneArgumentAnalyzer(args);
		commandAnalyzer.parseCommandLine();
	}

	@Test
	public void helpTest()
			throws CoreException {
		String[] arguments = {"help"}; //$NON-NLS-1$

		runAnalyzer(arguments);

		assertEquals(null, commandAnalyzer.getOutputFile());
		assertEquals(null, commandAnalyzer.getModelFilePath());
		assertEquals(null, commandAnalyzer.getExporter());

		assertFalse(null, commandAnalyzer.doRunOCLConstraints());
		assertFalse(null, commandAnalyzer.doRunJavaConstraints());
		assertFalse(null, commandAnalyzer.doRunUMLConstraints());
	}

	@Test
	public void mandatoryArgumentsOnlyTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName}; //$NON-NLS-1$ //$NON-NLS-2$

		runAnalyzer(arguments);

//		assertTrue(commandAnalyzer.getOutputPath().lastSegment()
//			.matches("log[0-9]*\\.txt")); //$NON-NLS-1$
		assertEquals(commandAnalyzer.getExporter().getClass(), TextExporter.class);
	}

	@Test
	public void outputArgumentWithNoValueTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output" //$NON-NLS-1$
		};

		runAnalyzer(arguments);

//		assertEquals(null, commandAnalyzer.getOutputPath());
	}

	@Test
	public void exporterArgumentWithNoValueTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter" //$NON-NLS-1$
		};

		runAnalyzer(arguments);

		assertEquals(null, commandAnalyzer.getExporter());
	}

	@Test
	public void usingArgumentWithNoValueTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-using" //$NON-NLS-1$
		};

		runAnalyzer(arguments);

		assertFalse(null, commandAnalyzer.doRunOCLConstraints());
		assertFalse(null, commandAnalyzer.doRunJavaConstraints());
		assertFalse(null, commandAnalyzer.doRunUMLConstraints());
	}

	@Test
	public void textExportedFileTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute}; //$NON-NLS-1$

		runAnalyzer(arguments);

		assertTrue(commandAnalyzer.getModelFilePath().toString()
			.endsWith(modelInputRootPath + "/" + inputModelName)); //$NON-NLS-1$
		assertEquals(1, commandAnalyzer.getOCLPaths().size());
//		assertTrue(commandAnalyzer.getOutputPath().toString()
//			.endsWith(outputRootPath + "/" + outputTextFileName)); //$NON-NLS-1$
		assertEquals(commandAnalyzer.getExporter().getClass(), TextExporter.class);

		assertTrue(commandAnalyzer.doRunOCLConstraints());
		assertTrue(commandAnalyzer.doRunJavaConstraints());
		assertTrue(commandAnalyzer.doRunUMLConstraints());
	}

	@Test
	public void htmlExportedFileTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputHtmlFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", htmlExporterAttribute}; //$NON-NLS-1$

		runAnalyzer(arguments);

		assertTrue(commandAnalyzer.getModelFilePath().toString()
			.endsWith(modelInputRootPath + "/" + inputModelName)); //$NON-NLS-1$
		assertEquals(1, commandAnalyzer.getOCLPaths().size());
//		assertTrue(commandAnalyzer.getOutputPath().toString()
//			.endsWith(outputRootPath + "/" + outputHtmlFileName)); //$NON-NLS-1$
		assertEquals(commandAnalyzer.getExporter().getClass(), HTMLExporter.class);

		assertTrue(commandAnalyzer.doRunOCLConstraints());
		assertTrue(commandAnalyzer.doRunJavaConstraints());
		assertTrue(commandAnalyzer.doRunUMLConstraints());
	}

	@Test
	public void unknownExportedFileTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", anotherExporterAttribute}; //$NON-NLS-1$

		runAnalyzer(arguments);

		assertEquals(commandAnalyzer.getExporter().getClass(), TextExporter.class);
	}

	@Test
	public void unexistingModelTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/unexistingFile.ecore", //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute}; //$NON-NLS-1$

		runAnalyzer(arguments);

		assertEquals(commandAnalyzer.getModelFilePath(), null);
	}

	@Test
	public void unexistingOclFileTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/unexistingFile.ocl", //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute}; //$NON-NLS-1$

		runAnalyzer(arguments);

		assertTrue(commandAnalyzer.getOCLPaths().isEmpty());
	}

	@Test
	public void unexistingOutputFileTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", "unexistingFile", //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute}; //$NON-NLS-1$ 

		runAnalyzer(arguments);

//		assertTrue(commandAnalyzer.getOutputPath().toString()
//			.endsWith("unexistingFile")); //$NON-NLS-1$
	}

	@Test
	public void textOCLFileTest()
			throws CoreException {
		String textInputOCLFileName = "ocl_rules.txt"; //$NON-NLS-1$
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$//$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + textInputOCLFileName, //$NON-NLS-1$//$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$//$NON-NLS-2$
			"-exporter", textExporterAttribute}; //$NON-NLS-1$

		runAnalyzer(arguments);

		assertEquals(2, commandAnalyzer.getOCLPaths().size());
	}

	@Test
	public void usingAllArgumentTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$//$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$//$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$//$NON-NLS-2$
			"-exporter", textExporterAttribute, //$NON-NLS-1$
			"-using", "all"}; //$NON-NLS-1$//$NON-NLS-2$

		runAnalyzer(arguments);

		assertTrue(commandAnalyzer.doRunOCLConstraints());
		assertTrue(commandAnalyzer.doRunJavaConstraints());
		assertTrue(commandAnalyzer.doRunUMLConstraints());
	}

	@Test
	public void usingOCLArgumentTest()
			throws CoreException {
		String[] validationUsingOCLArguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$//$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$//$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$//$NON-NLS-2$
			"-exporter", textExporterAttribute, //$NON-NLS-1$
			"-using", "ocl"}; //$NON-NLS-1$//$NON-NLS-2$

		runAnalyzer(validationUsingOCLArguments);

		assertTrue(commandAnalyzer.doRunOCLConstraints());
		assertFalse(commandAnalyzer.doRunJavaConstraints());
		assertFalse(commandAnalyzer.doRunUMLConstraints());
	}

	@Test
	public void usingJavaArgumentTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute, //$NON-NLS-1$
			"-using", "java"}; //$NON-NLS-1$ //$NON-NLS-2$

		runAnalyzer(arguments);

		assertFalse(commandAnalyzer.doRunOCLConstraints());
		assertTrue(commandAnalyzer.doRunJavaConstraints());
		assertFalse(commandAnalyzer.doRunUMLConstraints());
	}

	@Test
	public void usingUMLArgumentTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute, //$NON-NLS-1$
			"-using", "uml"}; //$NON-NLS-1$ //$NON-NLS-2$

		runAnalyzer(arguments);

		assertFalse(commandAnalyzer.doRunOCLConstraints());
		assertFalse(commandAnalyzer.doRunJavaConstraints());
		assertTrue(commandAnalyzer.doRunUMLConstraints());
	}

	@Test
	public void usingOCLUMLArgumentTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute, //$NON-NLS-1$
			"-using", "ocl", "uml"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		runAnalyzer(arguments);

		assertTrue(commandAnalyzer.doRunOCLConstraints());
		assertFalse(commandAnalyzer.doRunJavaConstraints());
		assertTrue(commandAnalyzer.doRunUMLConstraints());
	}

	@Test
	public void usingOCLJavaArgumentTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute, //$NON-NLS-1$
			"-using", "ocl", "java"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		runAnalyzer(arguments);

		assertTrue(commandAnalyzer.doRunOCLConstraints());
		assertTrue(commandAnalyzer.doRunJavaConstraints());
		assertFalse(commandAnalyzer.doRunUMLConstraints());
	}

	@Test
	public void usingJavaUmlArgumentTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute, //$NON-NLS-1$
			"-using", "uml", "java"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		runAnalyzer(arguments);

		assertFalse(commandAnalyzer.doRunOCLConstraints());
		assertTrue(commandAnalyzer.doRunJavaConstraints());
		assertTrue(commandAnalyzer.doRunUMLConstraints());
	}

	@Test
	public void usingOCLJavaUmlArgumentTest()
			throws CoreException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute, //$NON-NLS-1$
			"-using", "ocl", "uml", "java"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		runAnalyzer(arguments);

		assertTrue(commandAnalyzer.doRunOCLConstraints());
		assertTrue(commandAnalyzer.doRunJavaConstraints());
		assertTrue(commandAnalyzer.doRunUMLConstraints());
	}
}
