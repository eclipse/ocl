/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.internal.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.uml.internal.UML2AS;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.UML2EcoreConverter;

/**
 * Test suite with a simple Fruit model.
 */
@SuppressWarnings("nls")
public abstract class PivotStateMachineTestSuite extends PivotTestSuite
{
	protected EPackage statefulEPackage;
	protected EFactory statefulEFactory;

//	protected org.eclipse.ocl.pivot.Package fruitPackage;
	
	protected EClass c1Class;

	public PivotStateMachineTestSuite(boolean useCodeGen) {
		super(useCodeGen);
	}

	@SuppressWarnings("null")
	protected Resource getPivotFromUML(MetamodelManager metamodelManager, Resource umlResource) throws ParserException {
//		String problem = UML2AS.initialize(metamodelManager.getExternalResourceSet());
//		assertNull(problem);
		UML2AS uml2as = UML2AS.getAdapter(umlResource, metamodelManager);
		Model pivotModel = uml2as.getPivotModel();
		Resource asResource = pivotModel.eResource();
		assertNoResourceErrors("Normalisation failed", asResource);
		assertNoValidationErrors("Normalisation invalid", asResource);
		return asResource;
	}
	
	protected Resource initStateMachinePackage() throws ParserException {
		ResourceSet resourceSet2 = resourceSet;
		assert resourceSet2 != null;
		UML2AS.initialize(resourceSet2);
		URI uri = getTestModelURI("model/StateMachines.uml");
		Resource umlResource = resourceSet2.getResource(uri, true);
		List<EObject> contents = umlResource.getContents();
		Map<String, String> options = new HashMap<String, String>();
		options.put(UML2EcoreConverter.OPTION__ECORE_TAGGED_VALUES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__REDEFINING_OPERATIONS, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__REDEFINING_PROPERTIES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__SUBSETTING_PROPERTIES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__UNION_PROPERTIES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DERIVED_FEATURES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATIONS, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__SUPER_CLASS_ORDER, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__ANNOTATION_DETAILS, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__INVARIANT_CONSTRAINTS, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__OPERATION_BODIES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__COMMENTS,  UMLUtil.OPTION__PROCESS);
		UML2EcoreConverter uml2EcoreConverter = new UML2EcoreConverter();
		Collection<? extends EObject> ecoreContents = uml2EcoreConverter.convert(contents, options, null, null);
		Resource ecoreResource = resourceSet2.createResource(URI.createURI("StateMachines.ecore"));
		ecoreResource.getContents().addAll(ecoreContents);
		statefulEPackage = (EPackage) ecoreResource.getContents().get(0);
		statefulEFactory = statefulEPackage.getEFactoryInstance();
		c1Class = (EClass) statefulEPackage.getEClassifier("C1");
//		OCL ocl1 = OCL.newInstance();
//		MetamodelManager metamodelManager1 = ocl1.getMetamodelManager();
//		try {
			Resource asResource = getPivotFromUML(metamodelManager, umlResource);
		return asResource;
	}

	@SuppressWarnings("null")
	@Override
    protected void setUp() throws Exception {
        super.setUp();
		metamodelManager.addGlobalNamespace(PivotConstantsInternal.OCL_NAME, metamodelManager.getASmetamodel());
    }
}
