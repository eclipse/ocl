/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.DomainConstants;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for Name access.
 */
@SuppressWarnings({"nls"})
@RunWith(value = Parameterized.class)
public class EvaluateUMLTest4 extends PivotStateMachineTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false} /*, {true}*/};
		return Arrays.asList(data);
	}

	public EvaluateUMLTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateUML";
	}
	
	@BeforeClass public static void resetCounter() throws Exception {
		PivotTestSuite.resetCounter();
    }

    @Override
    @Before public void setUp() throws Exception {
        super.setUp();
    }

	@Override
	@After public void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Tests construction of a type instance with property values
	 * @throws ParserException 
	 */
	@Test public void test_oclIsInState() throws InvocationTargetException, ParserException {
		initStateMachinePackage();
		EObject context = statefulEFactory.create(c1Class);
		org.eclipse.ocl.examples.pivot.Class contextType = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Class.class, c1Class);
		assert contextType != null;
		assertSemanticErrorQuery2(contextType, "self.oclIsInState(S2b)", OCLMessages.UnresolvedProperty_ERROR_, "Model::C1", "S2b");	
		assertQueryInvalid(context, "self.oclIsInState(S1a)", "Failed to evaluate OclAny::oclIsInState(OclState) : Boolean", UnsupportedOperationException.class);	
	}

	public EObject doLoadUML(OCL ocl, String stem, String fragment) throws IOException {
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		String umlName = stem + ".uml";
		URI umlURI = getProjectFileURI(umlName).appendFragment(fragment);
		return metaModelManager.getExternalResourceSet().getEObject(umlURI, true);
	}
	
	/**
	 * Tests construction of a type instance with property values
	 * @throws ParserException 
	 */
	@Test public void test_stereotypes_Bug431638() throws Exception {
//		UML2AS.ADD_ELEMENT_EXTENSION.setState(true);
//		UML2AS.ADD_IMPORTED_RESOURCE.setState(true);
//		UML2AS.ADD_PROFILE_APPLICATION.setState(true);
//		UML2AS.CONVERT_RESOURCE.setState(true);
//		AbstractTypeServer.ADD_BASE_PROPERTY.setState(true);
//		AbstractTypeServer.ADD_EXTENSION_PROPERTY.setState(true);
		EObject context = doLoadUML(ocl, "Bug431638", "Bug431638Model.Class1.Attribute1");
		assertNotNull(context);
		org.eclipse.ocl.examples.pivot.Class contextType = (org.eclipse.ocl.examples.pivot.Class)metaModelManager.getIdResolver().getStaticTypeOf(context);	// FIXME cast
		org.eclipse.ocl.examples.pivot.Package contextPackage = contextType.getOwningPackage();
//		assertEquals(XMI2UMLResource.UML_METAMODEL_NS_URI, contextPackage.getNsURI());
//		assertEquals(IdManager.METAMODEL, contextPackage.getPackageId());
		assertEquals(DomainConstants.UML_METAMODEL_NAME, contextPackage.getPackageId().getDisplayName());
		assertValidQuery(contextType, "self.extension_vStereotype1");	
		assertSemanticErrorQuery2(contextType, "self.extension_Stereotype1", OCLMessages.UnresolvedProperty_ERROR_, "UML::Property", "extension_Stereotype1");	
		assertValidQuery(contextType, "self.extension_vStereotype1.base_NamedElement");	
		assertSemanticErrorQuery2(contextType, "self.extension_vStereotype1.base_Class", OCLMessages.UnresolvedProperty_ERROR_, "Bug431638Profile::vStereotype1", "base_Class");	
		assertSemanticErrorQuery2(contextType, "self.extension_vStereotype1.string", OCLMessages.UnresolvedProperty_ERROR_, "Bug431638Profile::vStereotype1", "string");	
		assertValidQuery(contextType, "self.extension_vStereotype1.oclAsType(Bug431638Profile::Stereotype1).string");	

//OK		assertQueryEquals(context, contextType, "self.oclType()");	
//OK		assertQueryEquals(context, "Property", "self.oclType().name");	
		assertQueryEquals(context, "overrideValue", "self.extension_vStereotype1.oclAsType(Bug431638Profile::Stereotype1).string");	
		
		
		
//		assertValidQuery((Type)contextType, "self.extension_vStereotype1.base_Class.oclIsKindOf(Property)");	
//		assertQueryFalse(context, "self.extension_vStereotype1.base_Class.oclIsKindOf(Property)");	
//		assertQueryTrue(context, "self.oclType().oclIsKindOf(self.extension_vStereotype1.base_NamedElement)");	
		assertSemanticErrorQuery2(contextType, "self.extension_vStereotype1.base_Class = self.oclType()", OCLMessages.UnresolvedProperty_ERROR_, "Bug431638Profile::vStereotype1", "base_Class");	
//		assertQueryTrue(context, "self.extension_vStereotype1.base_Class.oclIsKindOf(UML::Property)");	
//		assertSemanticErrorQuery2((Type)contextType, "self.extension_vStereotype1", OCLMessages.UnresolvedProperty_ERROR_, "Model::C1", "S2b");	
	}
}
