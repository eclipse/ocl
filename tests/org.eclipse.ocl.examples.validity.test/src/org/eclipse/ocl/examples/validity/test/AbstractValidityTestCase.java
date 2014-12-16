/*******************************************************************************
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation
 *   E.D.Willink (CEA LIST) - 425799 Validity View Integration
 *******************************************************************************/
package org.eclipse.ocl.examples.validity.test;

import junit.framework.TestCase;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.ResultSet;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.export.ValidityExporterRegistry;
import org.eclipse.ocl.examples.emf.validation.validity.locator.EClassConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.locator.EClassifierConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.locator.EValidatorConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.IDEValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityViewRefreshJob;
import org.eclipse.ocl.examples.validity.locator.DelegateConstraintLocator;
import org.eclipse.ocl.examples.validity.locator.PivotConstraintLocator;
import org.eclipse.ocl.examples.validity.locator.UMLConstraintLocator;
import org.eclipse.ocl.examples.validity.test.ecoreTest.EcoreTestPackage;
import org.eclipse.ocl.examples.validity.test.ecoreTest2.EcoreTest2Package;
import org.eclipse.ocl.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ProjectMap;
import org.eclipse.ocl.pivot.utilities.StandaloneProjectMap;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.StandaloneProjectMap.IProjectDescriptor;
import org.eclipse.ocl.pivot.validation.PivotEObjectValidator.ValidationAdapter;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.xtext.completeocl.utilities.CompleteOCLCSResource;
import org.eclipse.ocl.xtext.completeocl.utilities.CompleteOCLLoader;

/**
 * Abstract shared functionality for testing.
 */
public abstract class AbstractValidityTestCase extends TestCase
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.ocl.examples.validity.test"; //$NON-NLS-1$
	public static final @NonNull TracingOption TEST_PROGRESS = new TracingOption(PLUGIN_ID, "test/progress");

	protected static @NonNull String TEST_PROJECT_LOCATION;

	static {
		if (EcorePlugin.IS_ECLIPSE_RUNNING) {
			TEST_PROJECT_LOCATION = "platform:/plugin/" +PLUGIN_ID;
		}
		else {
			StandaloneProjectMap projectMap = new StandaloneProjectMap();
			IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(PLUGIN_ID);
			TEST_PROJECT_LOCATION = projectDescriptor.getLocationURI().toString();
			if (TEST_PROJECT_LOCATION.endsWith("/")) {
				TEST_PROJECT_LOCATION = TEST_PROJECT_LOCATION.substring(0, TEST_PROJECT_LOCATION.length()-1);
			}
		}
	}

	protected static final @NonNull String OCL_CONSTRAINTS_MODEL = "model/ecore.ocl";
	protected static final @NonNull String OCL_CONSTRAINTS_MODEL2 = "model/ecoreTest.ocl";
	protected static final @NonNull String ECORE_MODEL_NAME = "model/ecoreTest.ecore";
	protected static final @NonNull String ECORE_MODEL_NAME2 = "model/validityModelTest.ecoretest";
	protected static final @NonNull String ECORE_MODEL_NAME3 = "model/ecoreTest2.ecore";
	
	protected static final Integer EXPECTED_SUCCESSES = 145; //147; //145;
	protected static final Integer EXPECTED_INFOS = 2;
	protected static final Integer EXPECTED_WARNINGS = 2;
	protected static final Integer EXPECTED_ERRORS = 2;
	protected static final Integer EXPECTED_FAILURES = 2;
	protected static final Integer EXPECTED_RESULTS = EXPECTED_SUCCESSES + EXPECTED_INFOS + EXPECTED_WARNINGS + EXPECTED_ERRORS + EXPECTED_FAILURES;

	protected static final @NonNull String CONSTRAINABLE_ECORE = "ecore in http://www.eclipse.org/emf/2002/Ecore";
	protected static final @NonNull String CONSTRAINABLE_ECORE_OCL_ECORE = "ecore in " + TEST_PROJECT_LOCATION + "/model/ecore.ocl.ecore";
	protected static final @NonNull String CONSTRAINABLE_ECORETEST = "ecoreTest in " + TEST_PROJECT_LOCATION + "/model/ecoreTest.ecore";
	protected static final @NonNull String CONSTRAINABLE_ECORETEST_OCL_ECORE = "ecoreTest in " + TEST_PROJECT_LOCATION + "/model/ecoreTest.ocl.ecore";
//	protected static final @NonNull String CONSTRAINABLE_ECORETEST2 = "ecoreTest2 in " + TEST_PROJECT_LOCATION + "/model/ecoreTest2.ecore";
	protected static final @NonNull String CONSTRAINABLE_ECLASS1_E1_ATT1 = "Eclass1 in " + TEST_PROJECT_LOCATION + "/model/validityModelTest.ecoretest";
	protected static final @NonNull String CONSTRAINABLE_EATTRIBUTE_CONSTRAINT = "ecore::EAttribute::eattribute_constraint";
	protected static final @NonNull String CONSTRAINABLE_ECLASS_CONSTRAINT = "ecore::EClass::eclass_constraint";
	protected static final @NonNull String CONSTRAINABLE_EPACKAGE_CONSTRAINT_2 = "ecore::EPackage::epackage_constraint_2";
	protected static final @NonNull String CONSTRAINABLE_ECLASS1_CONSTRAINT = "ecoreTest::Eclass1::eclass1_constraint";
	protected static final @NonNull String CONSTRAINABLE_EPACKAGE_CONSTRAINT = "ecore::EPackage::epackage_constraint";
	protected static final @NonNull String CONSTRAINABLE_ECLASS2_CONSTRAINT = "ecoreTest::EClass2::eclass2_constraint";
	protected static final @NonNull String CONSTRAINABLE_ECLASS1 = "ecoreTest::Eclass1";
	protected static final @NonNull String CONSTRAINABLE_ECLASS2 = "ecoreTest::EClass2";
	protected static final @NonNull String CONSTRAINABLE_ECLASS3 = "ecoreTest::EClass3";
	protected static final @NonNull String CONSTRAINABLE_ECLASS5 = "ecoreTest2::Eclass5";
	
	protected static final @NonNull String VALIDATABLE_ECORE_TEST = "ecoreTest in " + TEST_PROJECT_LOCATION + "/model/ecoreTest.ecore";
	protected static final @NonNull String VALIDATABLE_ECORETEST2 = "ecoreTest2 in " + TEST_PROJECT_LOCATION + "/model/ecoreTest2.ecore";
	protected static final @NonNull String VALIDATABLE_ECLASS1_E1_ATT1 = "Eclass1 in " + TEST_PROJECT_LOCATION + "/model/validityModelTest.ecoretest";
	protected static final @NonNull String VALIDATABLE_E_CLASS3_ECLASS5 = "ecoreTest::EClass3";
	protected static final @NonNull String VALIDATABLE_ECLASS2 = "EClass2";
	protected static final @NonNull String VALIDATABLE_E_CLASS5 = "Eclass5";
	protected static final @NonNull String VALIDATABLE_E_CLASS2 = "Eclass1::EClass2";
	protected static final @NonNull String VALIDATABLE_E_ATTRIBUTE4_E_STRING = "ecoreTest::EClass2::eAttribute4";
	protected static final @NonNull String VALIDATABLE_E_ATTRIBUTE2_E_STRING = "ecoreTest::Eclass1::eAttribute2";
	protected static final @NonNull String VALIDATABLE_E_ATTRIBUTE1_E_STRING = "ecoreTest::Eclass1::eAttribute1";
	protected static final @NonNull String VALIDATABLE_E_ATTRIBUTE3_E_SHORT = "ecoreTest::EClass2::eAttribute3";
	protected static final @NonNull String VALIDATABLE_E_ATTRIBUTE5_E_STRING = "ecoreTest2::Eclass5::eAttribute5";

	protected static final @NonNull String TITLE_E_ATTRIBUTE5_E_STRING = "eAttribute5";
	
	private static ProjectMap projectMap = null;

	public static ConstrainingNode getConstrainingNodeByLabel(@NonNull Iterable<? extends ConstrainingNode> rootNodeChildren, @NonNull String label) {
		boolean matchPrefix = label.endsWith(" -> ");		// Too much effort to specify superclass/instance class detail
		String labelSpace = label + " ";
		for (ConstrainingNode constrainingNode : rootNodeChildren) {
			String nodeLabel = constrainingNode.getLabel();
			if (matchPrefix) {
				if (nodeLabel.startsWith(labelSpace)) {
					return constrainingNode;
				}
			}
			else {
				if (label.equals(nodeLabel)) {
					return constrainingNode;
				}
			}
		}
		return null;
	}

	public static ProjectMap getProjectMap() {
		if (projectMap == null) {
			projectMap = new ProjectMap();
		}
		return projectMap;
	}

	public static Result getResultFromResultValidatableNode(@NonNull Iterable<Result> validatableNodeResults, @NonNull String label) {
		for (Result resultIterated : validatableNodeResults) {
			if (label.equals(resultIterated.getResultValidatableNode().getLabel())) {
				return resultIterated;
			}
		}
		return null;
	}
	
	public static Result getResultOfValidatableNodeFromLabel(@NonNull Iterable<Result> results, @NonNull String labelValidatableNode, @NonNull String labelResultConstrainingNode) {
		for (Result resultIter : results) {
			if (labelValidatableNode.equals(resultIter.getResultValidatableNode().getLabel())
			 && labelResultConstrainingNode.equals(resultIter.getResultConstrainingNode().getLabel())) {
				return resultIter;
			}
		}
		return null;
	}

	public static @NonNull URI getTestModelURI(@NonNull String localFileName) {
		ProjectMap projectMap = getProjectMap();
		String urlString = projectMap.getLocation(PLUGIN_ID).toString();
		return ClassUtil.nonNullEMF(URI.createURI(urlString + localFileName));
	}
	
	public static ValidatableNode getValidatableNodeByLabel(@NonNull Iterable<? extends ValidatableNode> validatableNodes, @NonNull String label) {
		for (ValidatableNode constrainingNode : validatableNodes) {
			if (label.equals(constrainingNode.getLabel())) {
				return constrainingNode;
			}
		}
		return null;
	}

	public static boolean isCompleteOCLCSResourcePresent(@NonNull Iterable<Resource> resources) {
		for (Resource resource : resources) {
			if (resource instanceof CompleteOCLCSResource) {
				return true;
			}
		}
		return false;
	}

	protected ResourceSet resourceSet;
	protected Resource ecoreResource;
	protected Resource ecoreResource2;
	protected Resource ecoreResource3;
	protected Resource oclResource;
	protected Resource oclResource2;
	protected ValidationAdapter validationAdapter;
	protected ValidityModel validityModel;
	protected ValidityManager validityManager;
	protected RootNode rootNode;
	protected ResultSet resultSet;

	public void initTestModels() throws Exception {
		resourceSet = new ResourceSetImpl();
		// initialize all the needed resource factories to create ecore and ocl
		// resources in the global registry.
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			CompleteOCLStandaloneSetup.doSetup();
			EcoreTestPackage.eINSTANCE.getClass();
			EcoreTest2Package.eINSTANCE.getClass();
			ValidityExporterRegistry.initialize(ValidityExporterRegistry.INSTANCE);
			ValidityManager.addConstraintLocator("http://www.eclipse.org/emf/2002/Ecore", EClassConstraintLocator.INSTANCE);
			ValidityManager.addConstraintLocator("http://www.eclipse.org/emf/2002/Ecore", EClassifierConstraintLocator.INSTANCE);
			ValidityManager.addConstraintLocator("http://www.eclipse.org/emf/2002/Ecore", EValidatorConstraintLocator.INSTANCE);
			ValidityManager.addConstraintLocator("http://www.eclipse.org/ocl/2015/Pivot", PivotConstraintLocator.INSTANCE);
			ValidityManager.addConstraintLocator("http://www.eclipse.org/uml2/2.0.0/UML", UMLConstraintLocator.INSTANCE);
			ValidityManager.addConstraintLocator("http://www.eclipse.org/uml2/3.0.0/UML", UMLConstraintLocator.INSTANCE);
			ValidityManager.addConstraintLocator("http://www.eclipse.org/uml2/4.0.0/UML", UMLConstraintLocator.INSTANCE);
			ValidityManager.addConstraintLocator("http://www.eclipse.org/uml2/5.0.0/UML", UMLConstraintLocator.INSTANCE);
			ValidityManager.addConstraintLocator(null, EValidatorConstraintLocator.INSTANCE);
			ValidityManager.addConstraintLocator(null, DelegateConstraintLocator.INSTANCE);
		}
		// Plug the OCL validation mechanism.
		OCLDelegateDomain.initialize(resourceSet);

		URI ecoreURI = getTestModelURI(ECORE_MODEL_NAME);
		URI ecoreURI2 = getTestModelURI(ECORE_MODEL_NAME2);
		URI ecoreURI3 = getTestModelURI(ECORE_MODEL_NAME3);
		URI oclURI = getTestModelURI(OCL_CONSTRAINTS_MODEL);
		URI oclURI2 = getTestModelURI(OCL_CONSTRAINTS_MODEL2);

		ResourceSet resourceSet2 = ClassUtil.nonNullState(resourceSet);
		ecoreResource = resourceSet2.getResource(ecoreURI, true);
		ecoreResource2 = resourceSet2.getResource(ecoreURI2, true);
		ecoreResource3 = resourceSet2.getResource(ecoreURI3, true);

		CompleteOCLLoader helper = new CompleteOCLLoader(resourceSet2)
		{
			@Override
			protected boolean error(@NonNull String primaryMessage, @Nullable String detailMessage) {
				return false;
			}
		};

		oclResource = helper.loadResource(oclURI);
		oclResource2 = helper.loadResource(oclURI2);
		assertTrue(helper.loadMetaModels());
		helper.installPackages();

		validationAdapter = ValidationAdapter.findAdapter(resourceSet2);
		assertNotNull(validationAdapter);
	}

	protected void initValidityManager(@Nullable ValidityManager validityManager) {
		if (validityManager == null) {
			validityManager = new IDEValidityManager(new ValidityViewRefreshJob());
		}
		this.validityManager = validityManager;
		validityManager.setInput(resourceSet);
		rootNode = validityManager.getRootNode();
		validityModel = validityManager.getModel();
		resultSet = validityModel.createResultSet(new NullProgressMonitor());
	}

	@Override
	protected void setUp() throws Exception {
		if (TEST_PROGRESS.isActive()) {
			TEST_PROGRESS.println("-----Starting " + getClass().getSimpleName() + "." + getName() + "-----");
		}
		super.setUp();
	}

	public void tearDown() throws Exception {
		if (resourceSet != null) {
			for (Resource resource : resourceSet.getResources()) {
				resource.unload();
			}
			resourceSet.getResources().clear();
			resourceSet = null;
			TEST_PROGRESS.println("-resourceSet");
		}
		validationAdapter = null;
		rootNode = null;
		ecoreResource = null;
		validityModel = null;
		if (validityManager != null) {
			validityManager.dispose();
			validityManager = null;
			TEST_PROGRESS.println("-validityManager");
		}
		if (TEST_PROGRESS.isActive()) {
			TEST_PROGRESS.println("==> Finish " + getName());
		}
	}
}
