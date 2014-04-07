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
package org.eclipse.ocl.examples.test.standalone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.export.HTMLExporter;
import org.eclipse.ocl.examples.emf.validation.validity.export.ModelExporter;
import org.eclipse.ocl.examples.emf.validation.validity.export.TextExporter;
import org.eclipse.ocl.examples.standalone.StandaloneApplication;
import org.eclipse.ocl.examples.standalone.StandaloneResponse;
import org.junit.Test;

public class StandaloneExecutionTests extends StandaloneTestCase
{
	protected static void assertNoLogFile(@NonNull String logFileName) {
		File file = new File(logFileName);
		assertFalse(file.exists());
	}

	private void doFailingTest(@NonNull String[] arguments) throws CoreException {
		StandaloneApplication validityApplication = new StandaloneApplication();
		StandaloneResponse applicationResponse = validityApplication.execute(arguments);
		assertEquals(StandaloneResponse.FAIL, applicationResponse);
	}

	private void doOKTest(@NonNull String[] arguments) throws CoreException {
		StandaloneApplication validityApplication = new StandaloneApplication();
		StandaloneResponse applicationResponse = validityApplication.execute(arguments);
		assertEquals(StandaloneResponse.OK, applicationResponse);
	}

	private @NonNull List<String> checkLogFile(@NonNull String logFileName, int oks, int infos, int warnings, int errors, int fails) throws IOException {
		File file = new File(logFileName);
		assertTrue(file.exists());
		List<String> lines = new ArrayList<String>();
		BufferedReader r = new BufferedReader(new FileReader(file));
		int metricsLine = 0;
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			if ("==== METRICS ====".equals(line)) {
				metricsLine = lines.size();
			}
			lines.add(line);
		}
		r.close();
		assertEquals(lines.get(metricsLine + 2), "- Number of Success: " + oks);
		assertEquals(lines.get(metricsLine + 3), "- Number of Infos: " + infos);
		assertEquals(lines.get(metricsLine + 4), "- Number of Warnings: " + warnings);
		assertEquals(lines.get(metricsLine + 5), "- Number of Errors: " + errors);
		assertEquals(lines.get(metricsLine + 6), "- Number of Failures: " + fails);
		return lines;
	}

	@Test
	public void test_help() throws CoreException {
		String[] arguments = {"help"};
		doOKTest(arguments);
	}

	@Test
	public void test_mandatoryArgumentsOnly() throws CoreException {
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", inputOCLFileName};
		doOKTest(arguments);
		assertNoLogFile(getTextLogFileName());
	}

	@Test
	public void test_missingOutputArgument() throws CoreException, IOException {
		String[] arguments = {"validate", 
			"-model", inputModelName, 
			"-rules", inputOCLFileName, 
			"-output"
		};
		doFailingTest(arguments);
		assertNoLogFile(getTextLogFileName());
	}

	@Test
	public void test_missingExporterArgument() throws CoreException, IOException {
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", inputOCLFileName,
			"-exporter"
		};
		doFailingTest(arguments);
		assertNoLogFile(getTextLogFileName());
	}

	@Test
	public void test_missingUsingArgument() throws CoreException, IOException {
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", inputOCLFileName,
			"-using"
		};
		doFailingTest(arguments);
		assertNoLogFile(getTextLogFileName());
	}

	@Test
	public void test_textExportedFile() throws CoreException, IOException {
		String textLogFileName = getTextLogFileName();
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", inputOCLFileName,
			"-output", textLogFileName,
			"-exporter", TextExporter.EXPORTER_TYPE};
		doOKTest(arguments);
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) { // FIXME get 55 oks when run as part of full test suite 
			checkLogFile(textLogFileName, 54, 4, 4, 4, 0);
		}
	}

	@Test
	public void test_modelExportedFile() throws CoreException, IOException {
		String modelLogFileName = getLogFileName(ModelExporter.INSTANCE);
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", inputOCLFileName,
			"-output", modelLogFileName,
			"-exporter", ModelExporter.EXPORTER_TYPE};
		doOKTest(arguments);
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.getResource(URI.createFileURI(modelLogFileName), true);
		EObject eObject = resource.getContents().get(0);
		assertTrue(eObject instanceof RootNode);
	}

	@Test
	public void test_htmlExportedFile() throws CoreException {
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", inputOCLFileName,
			"-output", getHTMLLogFileName(),
			"-exporter", HTMLExporter.EXPORTER_TYPE};
		doOKTest(arguments);
		File file = new File(getHTMLLogFileName());
		assertTrue(file.exists());
	}

	@Test
	public void test_unknownExporter() throws CoreException {
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", inputOCLFileName,
			"-output", getTextLogFileName(),
			"-exporter", "anotherExporterAttribute"};
		doFailingTest(arguments);
		assertNoLogFile(getTextLogFileName());
	}

	@Test
	public void test_nonExistentModelFile() throws CoreException {
		String textLogFileName = getTextLogFileName();
		String[] arguments = {"validate",
			"-model", getProjectFileURI("models/nonExistentModel.ecore").toString(),
			"-rules", inputOCLFileName,
			"-output", textLogFileName,
			"-exporter", TextExporter.EXPORTER_TYPE};
		doFailingTest(arguments);
		assertNoLogFile(textLogFileName);
	}

	@Test
	public void test_nonExistentOclFile() throws CoreException, IOException {
		String textLogFileName = getTextLogFileName();
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", getProjectFileURI("models/nonExistentFile.ocl").toString(),
			"-output", textLogFileName,
			"-exporter", TextExporter.EXPORTER_TYPE};
		doOKTest(arguments);				// Missing file is ignored
		checkLogFile(textLogFileName, 30, 0, 0, 0, 0);
	}

/*	@Test
	public void test_unexistingOutputFileTest() throws CoreException, IOException {
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", inputOCLFileName,
			"-output", "unexistingFile",
			"-exporter", textExporterAttribute};
		doFailingTest(arguments);

		File file = new File(getTextLogFileName());

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		reader.close();
		assertEquals(null, line);
	} */

	@Test
	public void test_nonExistentOutputFolder() throws CoreException {
		String nonExistentOutputFolderPath = "nonExistent" + "/" + "anotherName.txt"; //$NON-NLS-3$
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", inputOCLFileName,
			"-output", nonExistentOutputFolderPath,
			"-exporter", TextExporter.EXPORTER_TYPE};
		doFailingTest(arguments);
		assertNoLogFile(nonExistentOutputFolderPath);
	}

	@Test
	public void test_listOfOCLFiles() throws CoreException, IOException {
		String textLogFileName = getTextLogFileName();
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", textInputOCLFileName,
			"-output", textLogFileName,
			"-exporter", TextExporter.EXPORTER_TYPE};
		doOKTest(arguments);
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) { // FIXME get 80 oks when run as part of full test suite 
			checkLogFile(textLogFileName, 78, 8, 8, 8, 0);
		}
	}

	@Test
	public void test_listOfOCLFilesToStdout() throws CoreException {
		String[] arguments = {"validate",
			"-model", inputModelName,
			"-rules", textInputOCLFileName,
			"-exporter", TextExporter.EXPORTER_TYPE};
		doOKTest(arguments);
		assertNoLogFile(getTextLogFileName());
	}
}
