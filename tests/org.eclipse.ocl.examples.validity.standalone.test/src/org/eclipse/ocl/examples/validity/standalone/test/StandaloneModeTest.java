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
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ocl.examples.validity.standalone.ValidityApplication;
import org.eclipse.ocl.examples.validity.standalone.util.StandaloneResponse;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class StandaloneModeTest {

	@Rule
	public TemporaryFolder outputFolder = new TemporaryFolder();

	private final String inputRootPath = "inputTest"; //$NON-NLS-1$

	private final String modelInputRootPath = inputRootPath + "/model";//$NON-NLS-1$

	private final String oclInputRootPath = inputRootPath + "/ocl";//$NON-NLS-1$

	private final String inputModelName = "EcoreTestFile.ecore";//$NON-NLS-1$

	private final String inputOCLFileName = "eclipse_ocl_rule.ocl";//$NON-NLS-1$

	private final String outputTextFileName = "log.txt";//$NON-NLS-1$

	private final String outputHtmlFileName = "log.html";//$NON-NLS-1$

	private final String textExporterAttribute = "text";//$NON-NLS-1$

	private final String htmlExporterAttribute = "html";//$NON-NLS-1$

	private final String anotherExporterAttribute = "another";//$NON-NLS-1$

	private String expectedTextOutputFilePath;

	private String expectedHtmlOutputFilePath;

	private String outputRootPath;

	@Before
	public void setup()
			throws IOException {
		this.outputRootPath = outputFolder.getRoot().getAbsolutePath();
		this.expectedTextOutputFilePath = outputFolder.newFile(
			outputTextFileName).getAbsolutePath();
		this.expectedHtmlOutputFilePath = outputFolder.newFile(
			outputHtmlFileName).getAbsolutePath();
	}

	private StandaloneResponse runtTest(String[] args)
			throws CoreException {
		ValidityApplication validityApplication = new ValidityApplication();
		return validityApplication.start(args);
	}

	@Test
	public void helpTest()
			throws CoreException {
		String[] arguments = {"help"};//$NON-NLS-1$

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.HELP);
	}

	@Test
	public void mandatoryArgumentsOnlyTest()
			throws CoreException {
		String[] arguments = {"validate",//$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName};//$NON-NLS-1$ //$NON-NLS-2$

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.VALIDATE);

		File file = new File(expectedTextOutputFilePath);
		assertTrue(file.exists());
	}

	@Test
	public void outputArgumentWithNoValueTest()
			throws CoreException, IOException {
		String[] arguments = {"validate",//$NON-NLS-1$ 
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$  //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$  //$NON-NLS-2$
			"-output" //$NON-NLS-1$
		};

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.EXIT);

		File file = new File(expectedTextOutputFilePath);

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		reader.close();
		assertEquals(null, line);
	}

	@Test
	public void exporterArgumentWithNoValueTest()
			throws CoreException, IOException {
		String[] arguments = {"validate", //$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName,//$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter" //$NON-NLS-1$
		};

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.EXIT);

		File file = new File(expectedTextOutputFilePath);

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		reader.close();
		assertEquals(null, line);
	}

	@Test
	public void usingArgumentWithNoValueTest()
			throws CoreException, IOException {
		String[] arguments = {"validate",//$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-using" //$NON-NLS-1$
		};

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.EXIT);

		File file = new File(expectedTextOutputFilePath);

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		reader.close();
		assertEquals(null, line);
	}

	@Test
	public void textExportedFileTest()
			throws CoreException {
		String[] arguments = {"validate",//$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute}; //$NON-NLS-1$

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.VALIDATE);

		File file = new File(expectedTextOutputFilePath);
		assertTrue(file.exists());
	}

	@Test
	public void htmlExportedFileTest()
			throws CoreException {
		String[] arguments = {"validate",//$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName,//$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName,//$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputHtmlFileName,//$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", htmlExporterAttribute};//$NON-NLS-1$

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.VALIDATE);

		File file = new File(expectedHtmlOutputFilePath);
		assertTrue(file.exists());
	}

	@Test
	public void unknownExportedFileTest()
			throws CoreException {
		String[] arguments = {"validate",//$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", anotherExporterAttribute};//$NON-NLS-1$

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.VALIDATE);

		File file = new File(expectedTextOutputFilePath);
		assertTrue(file.exists());
	}

	@Test
	public void unexistingModelTest()
			throws CoreException {
		String[] arguments = {"validate",//$NON-NLS-1$
			"-model", modelInputRootPath + "/unexistingFile.ecore",//$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName,//$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName,//$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute};//$NON-NLS-1$

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.EXIT);

		File file = new File(expectedTextOutputFilePath);
		assertTrue(!file.exists());
	}

	@Test
	public void unexistingOclFileTest()
			throws CoreException {
		String[] arguments = {"validate",//$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/unexistingFile.ocl", //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName,//$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute};//$NON-NLS-1$

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.EXIT);

		File file = new File(expectedTextOutputFilePath);
		assertTrue(!file.exists());
	}

	@Test
	public void unexistingOutputFileTest()
			throws CoreException, IOException {
		String[] arguments = {"validate",//$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName,//$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName,//$NON-NLS-1$ //$NON-NLS-2$
			"-output", "unexistingFile",//$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute};//$NON-NLS-1$

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.EXIT);

		File file = new File(expectedTextOutputFilePath);

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		reader.close();
		assertEquals(null, line);
	}

	@Test
	public void unknownOutputFileTest()
			throws CoreException {
		String unexistingOutputFolderPath = "output2" + "/" + "anotherName.txt";//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		String[] arguments = {"validate",//$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + inputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", unexistingOutputFolderPath, //$NON-NLS-1$
			"-exporter", textExporterAttribute};//$NON-NLS-1$

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.EXIT);

		File file = new File(unexistingOutputFolderPath);
		assertTrue(!file.exists());
	}

	@Test
	public void textOCLFileTest()
			throws CoreException {
		String textInputOCLFileName = "ocl_rules.txt";//$NON-NLS-1$
		String[] arguments = {"validate",//$NON-NLS-1$
			"-model", modelInputRootPath + "/" + inputModelName, //$NON-NLS-1$ //$NON-NLS-2$
			"-rules", oclInputRootPath + "/" + textInputOCLFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-output", outputRootPath + "/" + outputTextFileName, //$NON-NLS-1$ //$NON-NLS-2$
			"-exporter", textExporterAttribute};//$NON-NLS-1$

		StandaloneResponse applicationResponse = runtTest(arguments);
		assertEquals(applicationResponse, StandaloneResponse.VALIDATE);

		File file = new File(expectedTextOutputFilePath);
		assertTrue(file.exists());
	}
}
