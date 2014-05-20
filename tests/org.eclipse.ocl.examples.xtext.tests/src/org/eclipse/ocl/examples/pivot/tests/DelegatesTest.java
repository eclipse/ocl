/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 	E.D.Willink - Bug 306079, 322159, 353171
 *  K.Hussey - Bug 331143
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.tests;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import noreflectioncompany.NoreflectioncompanyFactory;
import noreflectioncompany.NoreflectioncompanyPackage;
import noreflectioncompany.util.NoreflectioncompanyValidator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.common.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.common.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.common.internal.options.CommonOptions;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.validation.DomainSubstitutionLabelProvider;
import org.eclipse.ocl.examples.pivot.EvaluationException;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.delegate.DelegateDomain;
import org.eclipse.ocl.examples.pivot.delegate.DelegateEPackageAdapter;
import org.eclipse.ocl.examples.pivot.delegate.DelegateInstaller;
import org.eclipse.ocl.examples.pivot.delegate.InvocationBehavior;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomainFactory;
import org.eclipse.ocl.examples.pivot.delegate.OCLInvocationDelegate;
import org.eclipse.ocl.examples.pivot.delegate.OCLInvocationDelegateFactory;
import org.eclipse.ocl.examples.pivot.delegate.OCLQueryDelegateFactory;
import org.eclipse.ocl.examples.pivot.delegate.OCLSettingDelegate;
import org.eclipse.ocl.examples.pivot.delegate.OCLSettingDelegateFactory;
import org.eclipse.ocl.examples.pivot.delegate.OCLValidationDelegateFactory;
import org.eclipse.ocl.examples.pivot.delegate.SettingBehavior;
import org.eclipse.ocl.examples.pivot.delegate.ValidationDelegate;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.oclinecore.validation.OCLinEcoreEObjectValidator;

import codegen.company.CodegencompanyFactory;
import codegen.company.CodegencompanyPackage;
import codegen.company.util.CodegencompanyValidator;

import company.CompanyFactory;
import company.CompanyPackage;
import company.util.CompanyValidator;

/**
 * Tests for the OCL delegate implementations.
 */
@SuppressWarnings("nls")
public class DelegatesTest extends PivotTestSuite
{
	protected static final @NonNull String COMPANY_XMI = "/model/Company.xmi";	
	protected static final @NonNull String NO_REFLECTION_COMPANY_XMI = "/model/NoReflectionCompany.xmi";
	protected static final @NonNull String MODEL_WITH_ERRORS_XMI = "/model/ModelWithErrors.xmi";
	protected static final @NonNull String MODEL_WITH_ERRORS_OCL = "/model/ModelWithErrors.ocl";
	public static final @NonNull String VIOLATED_TEMPLATE = "The ''{0}'' constraint is violated on ''{1}''";

	public Resource testResource;
	public EPackage companyPackage;
	public EFactory companyFactory;
	public EClass companyClass;
	public EAttribute companyName;
	public EReference companyEmployees;
	public EAttribute companySize;
	public EClass employeeClass;
	public EAttribute employeeName;
	public EReference employeeManager;
	public EReference employeeDirectReports;
	public EReference employeeAllReports;
	public EOperation employeeReportsTo;
	public EEnum sizeKind;
	public Enumerator sizeSmall;
	public Enumerator sizeMedium;
	public Enumerator sizeLarge;
	public EObject acme;
	public Map<String, EObject> employees;
	public EClass badClassClass;
	public EReference companyDetritus;

	public boolean usedLocalRegistry;
	//
	// Test framework
	//
	@SuppressWarnings("null")
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		usedLocalRegistry = false;
		EValidator.Registry.INSTANCE.put(null, new OCLinEcoreEObjectValidator());

		String oclDelegateURI = OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT;
		EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
			new OCLInvocationDelegateFactory.Global());
		EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
			new OCLSettingDelegateFactory.Global());
		EValidator.ValidationDelegate.Registry.INSTANCE.put(oclDelegateURI,
			new OCLValidationDelegateFactory.Global());
		QueryDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
			new OCLQueryDelegateFactory.Global());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			"xmi", new EcoreResourceFactoryImpl());		
		EPackage.Registry.INSTANCE.remove(CompanyPackage.eNS_URI);	// Reference and nullify the side effect of the reference			
		resourceSet.getPackageRegistry().remove(CompanyPackage.eNS_URI);	// In case previous test failed
		EPackage.Registry.INSTANCE.remove(NoreflectioncompanyPackage.eNS_URI);	// Reference and nullify the side effect of the reference
		resourceSet.getPackageRegistry().remove(NoreflectioncompanyPackage.eNS_URI);	// In case previous test failed

		// Install a DelegateResourceSetAdapter to supervise local registries and resource post-loading
		DelegateResourceSetAdapter adapter = DelegateResourceSetAdapter.getAdapter(resourceSet);

		// Install a local DelegateDomain.Factory
		DelegateDomain.Factory.Registry.Impl delegateDomainFactory =
			new DelegateDomain.Factory.Registry.Impl();
		delegateDomainFactory.put(oclDelegateURI, new OCLDelegateDomainFactory());
		adapter.putRegistry(DelegateDomain.Factory.Registry.class, delegateDomainFactory);
				
		// Install a local ValidationDelegate.Factory
		ValidationDelegate.Factory.Registry validationDelegateFactoryRegistry =
			new ValidationDelegate.Factory.Registry.Impl();
		validationDelegateFactoryRegistry.put(oclDelegateURI, new OCLValidationDelegateFactory(oclDelegateURI) {

			@Override
			public ValidationDelegate createValidationDelegate(@NonNull EClassifier classifier) {
				usedLocalRegistry = true;
				return super.createValidationDelegate(classifier);
			}
			
		});
		adapter.putRegistry(ValidationDelegate.Factory.Registry.class, validationDelegateFactoryRegistry);

		// Install a local SettingDelegate.Factory
		EStructuralFeature.Internal.SettingDelegate.Factory.Registry settingDelegateFactoryRegistry =
			new EStructuralFeature.Internal.SettingDelegate.Factory.Registry.Impl();
		settingDelegateFactoryRegistry.put(oclDelegateURI, new OCLSettingDelegateFactory(oclDelegateURI) {

			@Override
			public EStructuralFeature.Internal.SettingDelegate createSettingDelegate(EStructuralFeature structuralFeature) {
				usedLocalRegistry = true;
				return super.createSettingDelegate(structuralFeature);
			}
			
		});
		adapter.putRegistry(EStructuralFeature.Internal.SettingDelegate.Factory.Registry.class, settingDelegateFactoryRegistry);

		// Install a local InvocationDelegate.Factory
		EOperation.Internal.InvocationDelegate.Factory.Registry invocationDelegateFactoryRegistry =
			new EOperation.Internal.InvocationDelegate.Factory.Registry.Impl();
		invocationDelegateFactoryRegistry.put(oclDelegateURI, new OCLInvocationDelegateFactory(oclDelegateURI) {
			@Override
			public EOperation.Internal.InvocationDelegate createInvocationDelegate(EOperation operation) {
				usedLocalRegistry = true;
				return super.createInvocationDelegate(operation);
			}
			
		});
		adapter.putRegistry(EOperation.Internal.InvocationDelegate.Factory.Registry.class, invocationDelegateFactoryRegistry);	

		// Install a local QueryDelegate.Factory
		QueryDelegate.Factory.Registry queryDelegateFactoryRegistry =
			new QueryDelegate.Factory.Registry.Impl();
		queryDelegateFactoryRegistry.put(oclDelegateURI, new OCLQueryDelegateFactory(oclDelegateURI) {
			@Override
			public QueryDelegate createQueryDelegate(EClassifier context,
					Map<String, EClassifier> parameters, String expression) {
				usedLocalRegistry = true;
				return super.createQueryDelegate(context, parameters, expression);
			}});
		adapter.putRegistry(QueryDelegate.Factory.Registry.class, queryDelegateFactoryRegistry);			
	}

	@SuppressWarnings("null")
	@Override
	protected void tearDown() throws Exception {
		if (testResource != null) {
			testResource.unload();
		}
		EValidator.Registry.INSTANCE.remove(null);
		PivotEnvironmentFactory.disposeGlobalRegistryInstance();
		if (EPackage.Registry.INSTANCE.getEFactory(CompanyPackage.eNS_URI) instanceof CompanyFactory) {
			DelegateEPackageAdapter adapter = DelegateEPackageAdapter.findAdapter(CompanyPackage.eINSTANCE);
			if (adapter != null) {
				adapter.unloadDelegates();
			}
		}
		if (EPackage.Registry.INSTANCE.getEFactory(NoreflectioncompanyPackage.eNS_URI) instanceof NoreflectioncompanyFactory) {
			DelegateEPackageAdapter adapter = DelegateEPackageAdapter.findAdapter(NoreflectioncompanyPackage.eINSTANCE);
			if (adapter != null) {
				adapter.unloadDelegates();
			}
		}
		if (EPackage.Registry.INSTANCE.getEFactory(CodegencompanyPackage.eNS_URI) instanceof CodegencompanyFactory) {
			DelegateEPackageAdapter adapter = DelegateEPackageAdapter.findAdapter(CodegencompanyPackage.eINSTANCE);
			if (adapter != null) {
				adapter.unloadDelegates();
			}
		}
		super.tearDown();
	}

	protected void configureMetaModelManagerForDelegate(@NonNull EPackage ePackage) {
		if (metaModelManager != null) {
			metaModelManager.dispose();
		}
		DelegateEPackageAdapter adapter = DelegateEPackageAdapter.getAdapter(ePackage);
		DelegateDomain delegateDomain = adapter.getDelegateDomain(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		if (delegateDomain == null) {
			delegateDomain = adapter.loadDelegateDomain(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		}
		metaModelManager = ((OCLDelegateDomain)delegateDomain).getOCL().getMetaModelManager();
	}

	@SuppressWarnings("null")
	protected void initModel(@NonNull String testModelName) {
		URI uri = getTestModelURI(testModelName);
		testResource = resourceSet.getResource(uri, true);
		
		acme = testResource.getContents().get(0);

		companyClass = acme.eClass();
		companyPackage = companyClass.getEPackage();
		companyFactory = companyPackage.getEFactoryInstance();

		companyName = (EAttribute) companyClass.getEStructuralFeature("name");
		companyEmployees = (EReference) companyClass
			.getEStructuralFeature("employees");
		companySize = (EAttribute) companyClass.getEStructuralFeature("size");

		employeeClass = companyEmployees.getEReferenceType();
		employeeName = (EAttribute) employeeClass.getEStructuralFeature("name");
		employeeManager = (EReference) employeeClass
			.getEStructuralFeature("manager");
		employeeDirectReports = (EReference) employeeClass
			.getEStructuralFeature("directReports");
		employeeAllReports = (EReference) employeeClass
			.getEStructuralFeature("allReports");
		employeeReportsTo = getOperation(employeeClass, "reportsTo");

		sizeKind = (EEnum) companySize.getEAttributeType();
		sizeSmall = sizeKind.getEEnumLiteral("small").getInstance();
		sizeMedium = sizeKind.getEEnumLiteral("medium").getInstance();
		sizeLarge = sizeKind.getEEnumLiteral("large").getInstance();

		employees = new java.util.HashMap<String, EObject>();
		MetaModelManagerResourceAdapter.getAdapter(companyPackage.eResource(), metaModelManager);
	}

	protected Resource initModelWithErrors() {
		URI uri = getTestModelURI(MODEL_WITH_ERRORS_XMI);
		testResource = resourceSet.getResource(uri, true);
		acme = testResource.getContents().get(0);
		companyClass = acme.eClass();
		companyPackage = companyClass.getEPackage();
		companyFactory = companyPackage.getEFactoryInstance();
		badClassClass = (EClass) companyPackage.getEClassifier("BadClass");
		companyDetritus = (EReference) companyClass .getEStructuralFeature("detritus");
		return companyPackage.eResource();
	}

	@SuppressWarnings("null")
	protected void initModelWithErrorsAndOcl() {
		doCompleteOCLSetup();
		Resource ecoreResource = initModelWithErrors();
		configureMetaModelManagerForDelegate(companyPackage);
		MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
		String message = PivotUtil.formatResourceDiagnostics(ecoreResource.getErrors(), "Model load", "\n\t");
		if (message != null)
			fail(message);
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
		Root pivotRoot = ecore2Pivot.getPivotRoot();
		message = PivotUtil.formatResourceDiagnostics(pivotRoot.eResource().getErrors(), "Pivot load", "\n\t");
		if (message != null)
			fail(message);
		URI oclURI = getTestModelURI(MODEL_WITH_ERRORS_OCL);
		BaseResource xtextResource = (BaseResource) resourceSet.getResource(oclURI, true);
		message = PivotUtil.formatResourceDiagnostics(xtextResource.getErrors(), "OCL load", "\n\t");
		if (message != null)
			fail(message);
		Resource asResource = xtextResource.getASResource(metaModelManager);
		message = PivotUtil.formatResourceDiagnostics(asResource.getErrors(), "Pivot OCL load", "\n\t");
		if (message != null)
			fail(message);
		DelegateInstaller pivotInstaller = new DelegateInstaller(metaModelManager, null);
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : pivotRoot.getNestedPackage()) {
			pivotInstaller.installDelegates(metaModelManager.getPackageServer(nestedPackage));
		}
	}

	protected void initPackageRegistrations() {
		resourceSet.getPackageRegistry().put(CompanyPackage.eNS_URI, CompanyPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(NoreflectioncompanyPackage.eNS_URI, NoreflectioncompanyPackage.eINSTANCE);
		EValidator.Registry.INSTANCE.put(CompanyPackage.eINSTANCE, CompanyValidator.INSTANCE);
		EValidator.Registry.INSTANCE.put(NoreflectioncompanyPackage.eINSTANCE, NoreflectioncompanyValidator.INSTANCE);
	}

	protected void initCodeGeneratedPackageRegistrations() {
		resourceSet.getPackageRegistry().put(CodegencompanyPackage.eNS_URI, CodegencompanyPackage.eINSTANCE);
		EValidator.Registry.INSTANCE.put(CodegencompanyPackage.eINSTANCE, CodegencompanyValidator.INSTANCE);
	}

	protected void removePackageRegistrations() {
		resourceSet.getPackageRegistry().remove(CompanyPackage.eNS_URI);
		resourceSet.getPackageRegistry().remove(NoreflectioncompanyPackage.eNS_URI);
		resourceSet.getPackageRegistry().remove(CodegencompanyPackage.eNS_URI);
		EValidator.Registry.INSTANCE.remove(CompanyPackage.eNS_URI);
		EValidator.Registry.INSTANCE.remove(NoreflectioncompanyPackage.eNS_URI);
		EValidator.Registry.INSTANCE.remove(CodegencompanyPackage.eNS_URI);
	}

	public void doTest_allInstances(@NonNull String modelName) {
		initModel(modelName);
		Collection<EObject> amyAllReports = allReports(employee("Amy"));
		assertEquals(5, amyAllReports.size());
		assertTrue(amyAllReports.contains(employee("Bob")));
		assertTrue(amyAllReports.contains(employee("Jane")));
		assertTrue(amyAllReports.contains(employee("Fred")));
		assertTrue(amyAllReports.contains(employee("Norbert")));
		assertTrue(amyAllReports.contains(employee("Sally")));

		// change the set of all instances of Employee
		set(create(acme, companyEmployees, employeeClass, "Manuel"),
			employeeManager, employee("Bob"));

		amyAllReports = allReports(employee("Amy"));
		assertEquals(6, amyAllReports.size());
		assertTrue(amyAllReports.contains(employee("Manuel")));
	}

	public void doTest_constraintValidation(@NonNull String modelName) {
		initModel(modelName);
		EObject employee = create(acme, companyEmployees, employeeClass, null);
		set(employee, employeeManager, employee("Bob"));
		validateConstraintWithSeverity("mustHaveName", Diagnostic.WARNING, employee);
		
		set(employee, employeeName, "Joe");
		validateWithoutError(employee);

		validateWithoutError(acme);
	}

	public void doTest_crossReferences(@NonNull String modelName) {
		initModel(modelName);
		EcoreUtil.CrossReferencer.find(testResource.getContents());
	}

	public void doTest_eAttributeDerivation(@NonNull String modelName) {
		initModel(modelName);
		assertSame(sizeSmall, size(acme));

		// add a load of employees
		EList<EObject> emps = employees(acme);

		for (int i = 0; i < 60; i++) {
			emps.add(companyFactory.create(employeeClass));
		}

		assertSame(sizeMedium, size(acme));

		// and another bunch
		for (int i = 0; i < 1000; i++) {
			emps.add(companyFactory.create(employeeClass));
		}

		assertSame(sizeLarge, size(acme));
	}

	public void doTest_eReferenceDerivation(@NonNull String modelName) {
		initModel(modelName);
		EList<EObject> amyReports = directReports(employee("Amy"));
		assertEquals(3, amyReports.size());
		assertTrue(amyReports.contains(employee("Bob")));
		assertTrue(amyReports.contains(employee("Jane")));
		assertTrue(amyReports.contains(employee("Fred")));

		EList<EObject> bobReports = directReports(employee("Bob"));
		assertEquals(2, bobReports.size());
		assertTrue(bobReports.contains(employee("Norbert")));
		assertTrue(bobReports.contains(employee("Sally")));

		EList<EObject> sallyReports = directReports(employee("Sally"));
		assertEquals(0, sallyReports.size());
	}

	public void doTest_invariantValidation(@NonNull String modelName, boolean hasInvariants, int severity) {
		initModel(modelName);
		EObject joe = create(acme, companyEmployees, employeeClass, "Joe");
		if (hasInvariants) {
			validateInvariantWithSeverity("noManagerImpliesDirectReports", severity, joe);
		}
		else {
			validateConstraintWithSeverity("noManagerImpliesDirectReports", severity, joe);
		}

		set(employee("Amy"), employeeManager, joe);
		validateWithoutError(joe);
	}

	public void doTest_operationInvocation(@NonNull String modelName) throws InvocationTargetException {
		initModel(modelName);
		EObject amy = employee("Amy");

		// allReports is implemented using reportsTo()
		Collection<EObject> amyAllReports = allReports(amy);
		assertEquals(5, amyAllReports.size());

		for (EObject next : amyAllReports) {
			assertTrue(this.<Boolean> invoke(next, employeeReportsTo, amy));
		}
	}

	@SuppressWarnings("null")
	public void doTest_queryExecution(@NonNull String modelName) {
		initModel(modelName);
		configureMetaModelManagerForDelegate(companyPackage);
		QueryDelegate.Factory factory = QueryDelegate.Factory.Registry.INSTANCE
			.getFactory(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);

		String n = "n";
		String expression = "self.employees->select(employee | employee.manager <> null and employee.manager.name = n)";
		EObject amy = employee("Amy");
		Map<String, EClassifier> parameters = new HashMap<String, EClassifier>();
		parameters.put(n, EcorePackage.Literals.ESTRING);

		QueryDelegate delegate = factory.createQueryDelegate(companyClass, parameters, expression);
		executeWithException(delegate, amy, null,
			OCLMessages.WrongContextClassifier_ERROR_, getType(amy), getType(acme));

		executeWithException(delegate, acme, null,
			OCLMessages.MismatchedArgumentCount_ERROR_, 0, 1);
		Map<String, Object> badArguments = new HashMap<String, Object>();
		badArguments.put(n, amy);
		executeWithException(delegate, acme, badArguments,
			OCLMessages.MismatchedArgumentType_ERROR_, n, getType(amy), PivotUtil.findTypeOf(metaModelManager, EcorePackage.Literals.ESTRING));

		Map<String, Object> arguments = new HashMap<String, Object>();
		arguments.put(n, "Amy");

		Collection<?> amyReports = (Collection<?>) execute(delegate, acme, arguments);
		assertEquals(3, amyReports.size());
		assertTrue(amyReports.contains(employee("Bob")));
		assertTrue(amyReports.contains(employee("Jane")));
		assertTrue(amyReports.contains(employee("Fred")));

		executeWithException(delegate, employee("Bob"), null,
			OCLMessages.WrongContextClassifier_ERROR_, getType(amy), getType(acme));

		arguments = new HashMap<String, Object>();
		arguments.put(n, "Bob");

		Collection<?> bobReports = (Collection<?>) execute(delegate, acme, arguments);
		assertEquals(2, bobReports.size());
		assertTrue(bobReports.contains(employee("Norbert")));
		assertTrue(bobReports.contains(employee("Sally")));

		executeWithException(delegate, employee("Sally"), null,
			OCLMessages.WrongContextClassifier_ERROR_, getType(amy), getType(acme));

		arguments = new HashMap<String, Object>();
		arguments.put(n, "Sally");

		Collection<?> sallyReports = (Collection<?>) execute(delegate, acme, arguments);
		assertEquals(0, sallyReports.size());
	}

	@SuppressWarnings("null")
	public void doTest_queryExecutionWithExceptions(@NonNull String modelName) throws InvocationTargetException {
		initModel(modelName);
		configureMetaModelManagerForDelegate(companyPackage);
		QueryDelegate.Factory factory = QueryDelegate.Factory.Registry.INSTANCE
			.getFactory(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);

		String okName = "ok";
		String badName = "xyzzy";
		EObject amy = employee("Amy");
		Map<String, Object> okBindings = new HashMap<String, Object>();
		okBindings.put(okName, Integer.valueOf(123));
		Map<String, EClassifier> variables = new HashMap<String, EClassifier>();
		variables.put(okName, EcorePackage.Literals.ESTRING);
		QueryDelegate delegate;
		//
		//	Syntax error in expression
		//
		delegate = factory.createQueryDelegate(companyClass, null, "n=");
		executeWithException2(delegate, amy, null, getErrorsInMessage("company", "Company", "n=") + 
			DomainUtil.bind("1: no viable alternative following input ''{0}''", "="));
		//
		//	Undeclared variable
		//
		delegate = factory.createQueryDelegate(companyClass, variables, badName);
		executeWithException2(delegate, acme, null, getErrorsInMessage("company", "Company", badName) +
			DomainUtil.bind("1: " + OCLMessages.UnresolvedProperty_ERROR_, badName, ""));
		//
		//	Definition of undeclared variable
		//
		delegate = factory.createQueryDelegate(companyClass, variables, "self");
		Map<String, Object> bindings = new HashMap<String, Object>();
		bindings.put(okName, "xx");
		bindings.put(badName, Integer.valueOf(123));
		executeWithException(delegate, acme, bindings,
			OCLMessages.MismatchedArgumentCount_ERROR_, 2, 1);
		//
		//	Mis-definition of context
		//
		delegate = factory.createQueryDelegate(companyClass, variables, "self");
		delegate.prepare();
		executeWithException(delegate, amy, okBindings,
			OCLMessages.WrongContextClassifier_ERROR_, getType(amy), getType(acme));
		//
		//	Mis-definition of variable
		//
		delegate = factory.createQueryDelegate(companyClass, variables, "self");
		delegate.prepare();
		executeWithException(delegate, acme, okBindings,
			OCLMessages.MismatchedArgumentType_ERROR_, okName, "UnlimitedNatural", "String");
	}

	public @Nullable EObject getStereotypeApplication(@NonNull org.eclipse.uml2.uml.Element umlElement, @NonNull org.eclipse.uml2.uml.Stereotype umlStereotype) {
		for (EObject eObject : umlElement.eResource().getContents()) {
			if (DomainUtil.safeEquals(eObject.eClass().getName(), umlStereotype.getName())) {
				for (EStructuralFeature eFeature : eObject.eClass().getEAllStructuralFeatures()) {
					if ((eFeature instanceof EReference) && !eFeature.isMany()) {
						Object object = eObject.eGet(eFeature);
						if (object == umlElement) {
							return eObject;
						}
					}
				}
			}
		}
		return null;
	}

	public void test_allInstances() {
		doTest_allInstances(COMPANY_XMI);
		assertTrue(usedLocalRegistry);
	}

	public void test_allInstances_registered() {
		initPackageRegistrations();
		doTest_allInstances(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
	}

	public void test_allInstances_codeGenerated() {
		initCodeGeneratedPackageRegistrations();
		doTest_allInstances(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
	}

	public void test_cossReferences_codeGenerated() {
		PivotTables.PACKAGE.getClass();;
		initCodeGeneratedPackageRegistrations();
		doTest_crossReferences(COMPANY_XMI);	// Verify Bug 412690 comment 2
	}

	public void test_attributeDefinedWithDerivationAndInitial() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		Object actual = get(badClassInstance, (EAttribute)badClassClass.getEStructuralFeature("attributeDefinedWithDerivationAndInitial"));
		assertEquals(42, actual);
	}

	public void test_attributeDefinedWithInitial() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		Object actual = get(badClassInstance, (EAttribute)badClassClass.getEStructuralFeature("attributeDefinedWithInitial"));
		assertEquals(-42, actual);
	}

	public void test_attributeDefinedWithoutDerivation() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		EStructuralFeature eStructuralFeature = getStructuralFeature(badClassClass, "attributeDefinedWithoutDerivation");
		Property property = metaModelManager.getPivotOfEcore(Property.class, eStructuralFeature);
		getWithException(badClassInstance, eStructuralFeature.getName(),
			DomainUtil.bind(OCLMessages.MissingDerivationForSettingDelegate_ERROR_, property));
	}

	public void test_attributeDefinedWithoutDerivationBody() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		EStructuralFeature eStructuralFeature = getStructuralFeature(badClassClass, "attributeDefinedWithoutDerivationBody");
		Property property = metaModelManager.getPivotOfEcore(Property.class, eStructuralFeature);
		getWithException(badClassInstance, eStructuralFeature.getName(),
			DomainUtil.bind(OCLMessages.MissingDerivationForSettingDelegate_ERROR_, property));
	}

	public void test_attributeEvaluatingToInvalid() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		EStructuralFeature eStructuralFeature = getStructuralFeature(badClassClass, "attributeEvaluatingToInvalid");
		Property property = metaModelManager.getPivotOfEcore(Property.class, eStructuralFeature);
		getWithException(badClassInstance, eStructuralFeature.getName(),
			DomainUtil.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, property));
	}

	public void test_attributeEvaluatingToNull() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		EStructuralFeature eStructuralFeature = badClassInstance.eClass().getEStructuralFeature("attributeEvaluatingToNull");
		assertEquals(null, get(badClassInstance, eStructuralFeature));
	}

	public void test_attributeEvaluatingToWrongType() {
		initModelWithErrors();
		EObject testEObject = create(acme, companyDetritus, badClassClass, null);
		EStructuralFeature structuralFeature = getStructuralFeature(badClassClass, "attributeEvaluatingToWrongType");
		EStructuralFeature.Internal.SettingDelegate settingDelegate = ((EStructuralFeature.Internal)structuralFeature).getSettingDelegate();
		Property property = ((OCLSettingDelegate) settingDelegate).getProperty();
		String objectLabel = DomainUtil.getLabel(property);
		getWithException(testEObject, "attributeEvaluatingToWrongType",
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Property", "CompatibleDefaultExpression", objectLabel));
//			DomainUtil.bind(OCLMessages.InitOrDerConstraintConformance_ERROR_, "String", "attributeEvaluatingToWrongType", "Boolean"));
	}

	public void test_attributeParsingToLexicalError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		getWithException(badClassInstance, "attributeParsingToLexicalError",
			getErrorsInMessage(badClassInstance.eClass().getName(), "attributeParsingToLexicalError", "gh##jk") +
			DomainUtil.bind("1: no viable alternative at input ''{0}''", "#"));
	}

	public void test_attributeParsingToSemanticError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		getWithException(badClassInstance, "attributeParsingToSemanticError",
			getErrorsInMessage(badClassInstance.eClass().getName(), "attributeParsingToSemanticError", "'5' and 6") +
			DomainUtil.bind("1: " + OCLMessages.UnresolvedOperationCall_ERROR_, "and", "String", "UnlimitedNatural"));
	}

	public void test_attributeParsingToSyntacticError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		getWithException(badClassInstance, "attributeParsingToSyntacticError",
			getErrorsInMessage(badClassInstance.eClass().getName(), "attributeParsingToSyntacticError", "invalid null") +
			DomainUtil.bind("1: extraneous input ''{0}'' expecting EOF", "null"));
	}

	/**
	 * Ensures that {@link InvocationBehavior#getOperationBody(OCL, EOperation)}
	 * consistently returns <code>null</code> for stdlib operations that don't
	 * have a body defined at all instead of returning an <code>invalid</code> literal.
	 * @throws ParserException 
	 *
	public void test_attributeNotDefinedInOCLRemainsNull() throws ParserException {
		helper.setContext(EcorePackage.eINSTANCE.getEClassifier());
		OCLExpression expr = (OCLExpression) helper.createQuery("self.name");
		assertTrue(expr instanceof PropertyCallExp);
		PropertyCallExp pce = (PropertyCallExp) expr;
		Property p = pce.getReferredProperty();
		OCLExpression body = SettingBehavior.INSTANCE.getFeatureBody((OCL) ocl, p);
		assertNull(body);
		// and again, now reading from cache
		OCLExpression bodyStillNull = SettingBehavior.INSTANCE.getFeatureBody((OCL) ocl, p);
		assertNull(bodyStillNull);
	} */

	public void test_constraintValidation() {
		doTest_constraintValidation(COMPANY_XMI);
		assertTrue(usedLocalRegistry);
	}

	public void test_constraintValidation_withoutReflection() {
		doTest_constraintValidation(NO_REFLECTION_COMPANY_XMI);
	}

	public void test_constraintValidation_registered() {
		initPackageRegistrations();
		doTest_constraintValidation(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
	}

	public void test_constraintValidation_codeGenerated() {
//		PivotTables.PACKAGE.getClass();
		initCodeGeneratedPackageRegistrations();
		doTest_constraintValidation(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
	}

	public void test_defaultIsLPG() {
		assertEquals(OCLConstants.OCL_DELEGATE_URI_LPG, CommonOptions.DEFAULT_DELEGATION_MODE.getPreferredValue());
	}

//	public void test_defaultIsPivot() {
//		assertEquals(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT, CommonOptions.DEFAULT_DELEGATION_MODE.getPreferredValue());
//	}

	public void test_eAttributeDerivation() {
		doTest_eAttributeDerivation(COMPANY_XMI);
	}

/*	public void test_eAttributeDerivation_registered() {
		initPackageRegistrations();
		doTest_eAttributeDerivation(COMPANY_XMI);
	} */

	public void test_eReferenceDerivation() {
		doTest_eReferenceDerivation(COMPANY_XMI);
	}

	public void test_eReferenceDerivation_registered() {
		initPackageRegistrations();
		doTest_eReferenceDerivation(COMPANY_XMI);
	}

	public void test_eReferenceDerivation_codeGenerated() {
		initCodeGeneratedPackageRegistrations();
		doTest_eReferenceDerivation(COMPANY_XMI);
	}

	/**
	 * Caches an operation AST in the annotation used by the {@link SettingBehavior} implementation
	 * and ensures that it's used by the delegate as well as the {@link EvaluationVisitorImpl}
	 * @throws ParserException 
	 * @throws InvocationTargetException 
	 *
	public void test_eReferenceDerivationUsedFromCache() throws ParserException, InvocationTargetException {
		initModel(COMPANY_XMI);
		EObject company = companyFactory.create(companyClass);
		EObject manager = companyFactory.create(employeeClass);
		manager.eSet(employeeClass.getEStructuralFeature("company"), company);
		EObject employee = companyFactory.create(employeeClass);
		employee.eSet(employeeClass.getEStructuralFeature("company"), company);
		employee.eSet(employeeClass.getEStructuralFeature("manager"), manager);
		OCL ocl = OCL.newInstance();
		Helper helper = ocl.createOCLHelper();
		helper.setContext(employeeClass);
		OCLExpression expr = helper.createQuery("self.directReports");
		assertTrue(((Collection<?>) ocl.evaluate(manager, expr)).contains(employee));
		EStructuralFeature directReportsRef = employeeClass.getEStructuralFeature("directReports");
		// Now cache a NullLiteralExp as the derivation expression for directReports:
		NullLiteralExp nullLiteralExp = PivotFactory.eINSTANCE.createNullLiteralExp();
		EAnnotation directReportsAnn = directReportsRef.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		assertTrue(directReportsAnn.getDetails().containsKey(SettingBehavior.DERIVATION_CONSTRAINT_KEY));
		String derivationExpression =  directReportsAnn.getDetails().get(SettingBehavior.DERIVATION_CONSTRAINT_KEY);
		try {
			directReportsAnn.getDetails().remove(SettingBehavior.DERIVATION_CONSTRAINT_KEY);
			// ensure that the plugin cache doesn't have an expression cached:
			SettingBehavior.INSTANCE.cacheOCLExpression(directReportsRef, nullLiteralExp);
			assertNull(ocl.evaluate(manager, expr));
		} finally {
			directReportsAnn.getDetails().put(SettingBehavior.DERIVATION_CONSTRAINT_KEY, derivationExpression);
			SettingBehavior.INSTANCE.cacheOCLExpression(directReportsRef, null);
		}
	} */

/*	public void test_invariantCacheBeingUsed() throws ParserException {
		initPackageRegistrations();
		initModel(COMPANY_XMI);
		EAnnotation annotation = employeeClass.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		
		DiagnosticChain diagnostics = new BasicDiagnostic();
		// first ensure that contents are padded up to where we need it:
		assertTrue("Expecting \"Amy\" to be a valid name",
			CompanyValidator.INSTANCE.validateEmployee_mustHaveName((Employee) employee("Amy"), diagnostics, context));
		final String constraintName = "mustHaveName";
		String mustHaveNameConstraint = annotation.getDetails().get(constraintName);
		Helper helper = OCL.newInstance().createOCLHelper();
		helper.setContext(employeeClass);
		OCLExpression query = helper.createQuery("false"); // a constraint always returning false
		try {
			annotation.getDetails().remove(constraintName);
			ValidationBehavior.INSTANCE.cacheOCLExpression(employeeClass,
				constraintName, query);
			assertFalse(
				"Expected the always-false cached constraint to be used",
				CompanyValidator.INSTANCE.validateEmployee_mustHaveName(
					(Employee) employee("Amy"), diagnostics, context));
		} finally {
			// restore annotation detail
			annotation.getDetails().put(constraintName, mustHaveNameConstraint);
		}
	} */
	
/*	public void test_invariantCachingForFirst() {
		initPackageRegistrations();
		initModel(COMPANY_XMI);
		DiagnosticChain diagnostics = new BasicDiagnostic();
		ValidationBehavior.INSTANCE.cacheOCLExpression(employeeClass, "mustHaveName", null);
		CompanyValidator.INSTANCE.validateEmployee_mustHaveName((Employee) employee("Amy"), diagnostics, context);
		OCLExpression cached = ValidationBehavior.INSTANCE.getCachedOCLExpression(employeeClass, "mustHaveName");
		assertTrue("Expected to find compiled expression in cache",
			cached != null && !ValidationBehavior.isNoOCLDefinition(cached));
	} */
	
/*	public void test_invariantCachingForSecond() {
		initPackageRegistrations();
		initModel(COMPANY_XMI);
		DiagnosticChain diagnostics = new BasicDiagnostic();
		ValidationBehavior.INSTANCE.cacheOCLExpression(employeeClass, "mustHaveNonEmptyName", null);
		CompanyValidator.INSTANCE.validateEmployee_mustHaveNonEmptyName((Employee) employee("Amy"), diagnostics, context);
		OCLExpression cached = ValidationBehavior.INSTANCE.getCachedOCLExpression(employeeClass, "mustHaveNonEmptyName");
		assertTrue("Expected to find compiled expression in cache",
			cached != null && !ValidationBehavior.isNoOCLDefinition(cached));
	} */
	
	public void test_invariantValidation() {
		doTest_invariantValidation(COMPANY_XMI, false, Diagnostic.WARNING);
		assertTrue(usedLocalRegistry);
	}

	public void test_invariantValidation_registered() {
		initPackageRegistrations();
		doTest_invariantValidation(COMPANY_XMI, true, Diagnostic.ERROR);
		assertFalse(usedLocalRegistry);
	}
	
	public void test_invariantValidation_codeGenerated() {
		initCodeGeneratedPackageRegistrations();
		doTest_invariantValidation(COMPANY_XMI, false, Diagnostic.WARNING);
		assertFalse(usedLocalRegistry);
	}

	public void test_invariantValidation_withoutReflection() {
		doTest_invariantValidation(NO_REFLECTION_COMPANY_XMI, false, Diagnostic.WARNING);
	}
/*	public void test_invariantValidation_withoutReflection_registered() {
		initPackageRegistrations();
		doTest_invariantValidation(NO_REFLECTION_COMPANY_XMI, true);
	} */

	public void test_operationDefinedWithoutBody() throws InvocationTargetException {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		EOperation eOperation = getOperation(badClassClass, "operationDefinedWithoutBody");
		Operation operation = metaModelManager.getPivotOfEcore(Operation.class, eOperation);
		invokeWithException(badClassInstance, eOperation.getName(),
			DomainUtil.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, operation));
	}

	public void test_operationDefinedWithoutBodyBody() throws InvocationTargetException {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		EOperation eOperation = getOperation(badClassClass, "operationDefinedWithoutBodyBody");
		Operation operation = metaModelManager.getPivotOfEcore(Operation.class, eOperation);
		invokeWithException(badClassInstance, eOperation.getName(),
			DomainUtil.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, operation));
	}

	public void test_operationEvaluatingToInvalid() throws InvocationTargetException {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		EOperation eOperation = getOperation(badClassClass, "operationEvaluatingToInvalid");
		Operation operation = metaModelManager.getPivotOfEcore(Operation.class, eOperation);
		invokeWithException(badClassInstance, eOperation.getName(),
			DomainUtil.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, operation));
	}

	public void test_operationEvaluatingToNull() throws InvocationTargetException {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		EOperation operation = getOperation(badClassInstance.eClass(), "operationEvaluatingToNull");
		assertEquals(null, invoke(badClassInstance, operation));
	}

	public void test_operationEvaluatingToWrongType() throws InvocationTargetException {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		EOperation eOperation = getOperation(badClassClass, "operationEvaluatingToWrongType");
		EOperation.Internal.InvocationDelegate invocationDelegate = ((EOperation.Internal)eOperation).getInvocationDelegate();
		Operation operation = ((OCLInvocationDelegate) invocationDelegate).getOperation();
		String objectLabel = DomainUtil.getLabel(operation);
		invokeWithException(badClassInstance, "operationEvaluatingToWrongType",
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Operation", "CompatibleReturn", objectLabel));
//			OCLMessages.BodyConditionConformance_ERROR_, "operationEvaluatingToWrongType", "Integer", "Boolean");
	}

	public void test_operationInvocation() throws InvocationTargetException {
		doTest_operationInvocation(COMPANY_XMI);
		assertTrue(usedLocalRegistry);
	}

/*	public void test_operationInvocation_registered() throws InvocationTargetException {
		initPackageRegistrations();
		doTest_operationInvocation(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
	} */

	public void test_operationParsingToLexicalError() throws InvocationTargetException {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		invokeWithException(badClassInstance, "operationParsingToLexicalError",
			getErrorsInMessage(badClassInstance.eClass().getName(), "operationParsingToLexicalError", "@@") + DomainUtil.bind("1: no viable alternative at input ''{0}''", "@"));
	}

	public void test_operationParsingToSemanticError() throws InvocationTargetException {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		invokeWithException(badClassInstance, "operationParsingToSemanticError",
			getErrorsInMessage(badClassInstance.eClass().getName(), "operationParsingToSemanticError", "self->at(1)") + DomainUtil.bind("1: " + OCLMessages.UnresolvedOperationCall_ERROR_, "at", "Set(modelWithErrors::BadClass)", "1"));
	}

	public void test_operationParsingToSyntacticError() throws InvocationTargetException {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		invokeWithException(badClassInstance, "operationParsingToSyntacticError",
			getErrorsInMessage(badClassInstance.eClass().getName(), "operationParsingToSyntacticError", "let in") + DomainUtil.bind("1: no viable alternative at input ''{0}''", "in"));
	}

	/**
	 * Ensures that {@link InvocationBehavior#getOperationBody(OCL, EOperation)}
	 * consistently returns <code>null</code> for stdlib operations that don't
	 * have a body defined at all instead of returning an <code>invalid</code> literal.
	 * @throws ParserException 
	 */
	public void test_operationDefinedInStdlibBodyRemainsNull() throws ParserException {
		ExpressionInOCL expr = helper.createQuery("'abc'.oclAsType(String)");
		OperationCallExp oce = (OperationCallExp) expr.getBodyExpression();
		Operation o = oce.getReferredOperation();
		try {
			@SuppressWarnings({"unused", "null"})
			ExpressionInOCL body = InvocationBehavior.INSTANCE.getExpressionInOCL(metaModelManager, o);
			fail("Expected to catch OCLDelegateException");
		}
		catch (OCLDelegateException e) {		
		}
		// and again, now reading from cache
		try {
			@SuppressWarnings({"unused", "null"})
			ExpressionInOCL bodyStillNull = InvocationBehavior.INSTANCE.getExpressionInOCL(metaModelManager, o);
			fail("Expected to catch OCLDelegateException");
		}
		catch (OCLDelegateException e) {		
		}
	}
	
	/**
	 * Caches an operation AST in the annotation used by the {@link InvocationBehavior} implementation
	 * and ensures that it's used by the delegate as well as the {@link EvaluationVisitorImpl}.
	 * Implicitly, the test ensures that no modification is applied to the original textual annotation,
	 * so that the annotation's contents are <em>not</em> used to cache the compiled AST because that
	 * may make some clients expecting the metamodel resources to remain unchanged angry.
	 * 
	 * @throws ParserException 
	 * @throws InvocationTargetException 
	 *
	public void test_operationUsedFromCache() throws ParserException, InvocationTargetException {
		initModel(COMPANY_XMI);
		EObject manager = companyFactory.create(employeeClass);
		EObject employee = companyFactory.create(employeeClass);
		employee.eSet(employeeClass.getEStructuralFeature("manager"), manager);
		helper.setContext(employeeClass);
		OCLExpression expr = (OCLExpression) helper.createQuery("self.reportsTo(self.manager)");
		assertTrue((Boolean) ocl.evaluate(employee, expr)); // by the default impl, employee reports to manager
		EOperation reportsToOp = employeeClass.getEOperation(CompanyPackage.EMPLOYEE___REPORTS_TO__EMPLOYEE);
		// Now cache a BooleanLiteralExp with the "false" literal as the implementation for reportsTo:
		BooleanLiteralExp falseLiteralExp = EcoreFactory.eINSTANCE.createBooleanLiteralExp();
		falseLiteralExp.setBooleanSymbol(false);
		EAnnotation reportsToAnn = reportsToOp.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		assertTrue(reportsToAnn.getDetails().containsKey(InvocationBehavior.BODY_CONSTRAINT_KEY));
		String body = reportsToAnn.getDetails().get(InvocationBehavior.BODY_CONSTRAINT_KEY);
		try {
			reportsToAnn.getDetails().remove(InvocationBehavior.BODY_CONSTRAINT_KEY);
			// ensure that the plugin cache doesn't have an expression cached:
			InvocationBehavior.INSTANCE.cacheOCLExpression(reportsToOp, falseLiteralExp);
			assertFalse((Boolean) ocl.evaluate(employee, expr));
		} finally {
			reportsToAnn.getDetails().put(InvocationBehavior.BODY_CONSTRAINT_KEY, body);
			InvocationBehavior.INSTANCE.cacheOCLExpression(reportsToOp, null);
		}
	} */
	
/*	public void test_performanceOfCacheRetrieval() throws ParserException {
		initModel(COMPANY_XMI);
		EObject manager = companyFactory.create(employeeClass);
		EObject employee = companyFactory.create(employeeClass);
		employee.eSet(employeeClass.getEStructuralFeature("manager"), manager);
		OCL ocl = OCL.newInstance();
		Helper helper = ocl.createOCLHelper();
		helper.setContext(employeeClass);
		String expression = "self.reportsTo(self.manager)";
		OCLExpression expr = helper.createQuery(expression);
		final int TIMES = 1;
		final int REPEAT = 1;
		for (int r = 0; r < REPEAT; r++) {
			long start = System.currentTimeMillis();
			for (int i = 0; i < TIMES; i++) {
				ocl.evaluate(employee, expr);
			}
			long end = System.currentTimeMillis();
			System.out.println("Executing " + expression + " " + TIMES
				+ " times took " + (end - start) + "ms");
		}
	} */

	public void test_queryExecution() {
		doTest_queryExecution(COMPANY_XMI);
		assertTrue(usedLocalRegistry);
	}

	public void test_queryExecution_registered() {
		initPackageRegistrations();
		doTest_queryExecution(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
	}

	public void test_queryExecution_codeGenerated() {
		initCodeGeneratedPackageRegistrations();
		doTest_queryExecution(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
	}

	public void test_queryExecutionWithExceptions() throws InvocationTargetException {
		doTest_queryExecutionWithExceptions(COMPANY_XMI);
		assertTrue(usedLocalRegistry);
	}

	public void test_queryExecutionWithExceptions_registered() throws InvocationTargetException {
		initPackageRegistrations();
		doTest_queryExecutionWithExceptions(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
	}

	public void test_queryExecutionWithExceptions_codeGenerated() throws InvocationTargetException {
		initCodeGeneratedPackageRegistrations();
		doTest_queryExecutionWithExceptions(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
	}

	/**
	 * Verify that query delegates work independently of other EAnnotation declared delegates.
	 */
	public void test_queryExecution_Bug353171() {
		QueryDelegate.Factory factory = QueryDelegate.Factory.Registry.INSTANCE
			.getFactory(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		String n = "n";
		String expression = "self.name";
		Library library = EXTLibraryFactory.eINSTANCE.createLibrary();
		library.setName("test");
		Map<String, EClassifier> parameters = new HashMap<String, EClassifier>();
		parameters.put(n, EcorePackage.Literals.ESTRING);
		QueryDelegate delegate = factory.createQueryDelegate(EXTLibraryPackage.Literals.LIBRARY,
			parameters, expression);
		Map<String, Object> bindings = new HashMap<String, Object>();
		bindings.put(n, "test");
		Object result = execute(delegate, library, bindings);
		assertEquals(result, "test");
	}

	/**
	 * EObjectValidator  .validateDelegatedConstraints just skips over missing constraints.
	 *
	public void test_validationOfMissingConstraint() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		validateConstraintWithError("MissingConstraint", badClassInstance);
	} */
	
	/**
	 * EObjectValidator  .validateDelegatedConstraints just skips over null bodies.
	 *
	public void test_validationOfMissingConstraintBody() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("MissingConstraintBody"), null);
		validateConstraintWithError("MissingConstraint", badClassInstance);
	} */
	
	public void test_validationEvaluatingToInvalid() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationEvaluatingToInvalid"), null);
		validateWithDelegationSeverity("evaluatingToInvalid", Diagnostic.ERROR, badClassInstance, null,
			EvaluationException.class, OCLMessages.ValidationResultIsInvalid_ERROR_, "ValidationEvaluatingToInvalid", "evaluatingToInvalid", DomainUtil.getLabel(badClassInstance), "invalid");
	}
	
	public void test_validationEvaluatingToNull() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationEvaluatingToNull"), null);
		validateWithDelegationSeverity("evaluatingToNull", Diagnostic.ERROR, badClassInstance, null,
			EvaluationException.class, OCLMessages.ValidationResultIsNull_ERROR_, badClassInstance.eClass().getName(), "evaluatingToNull", DomainUtil.getLabel(badClassInstance));
	}
	
	public void test_validationEvaluatingToWrongType() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationEvaluatingToWrongType"), null);
		validateWithDelegationSeverity("evaluatingToWrongType", Diagnostic.ERROR, badClassInstance, null,
			EvaluationException.class, OCLMessages.ValidationConstraintIsNotBooleanType_ERROR_, "ValidationEvaluatingToWrongType", "evaluatingToWrongType", "OclInvalid");
	}
	
	public void test_validationParsingToLexicalError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationParsingToLexicalError"), null);
		validateWithDelegationSeverity("parsingToLexicalError", Diagnostic.ERROR, badClassInstance, "'part",
			SemanticException.class, "1: Invalid token {0}", "'part");
	}
	
	public void test_validationParsingToSemanticError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationParsingToSemanticError"), null);
		validateWithDelegationSeverity("parsingToSemanticError", Diagnostic.ERROR, badClassInstance, "not '5'",
			SemanticException.class, "1: " + OCLMessages.UnresolvedOperation_ERROR_, "not", "String");
	}
	
	public void test_validationParsingToSyntacticError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationParsingToSyntacticError"), null);
		validateWithDelegationSeverity("parsingToSyntacticError", Diagnostic.ERROR, badClassInstance, "else", 
			SemanticException.class, "1: no viable alternative at input ''{0}''", "else");
	}
	
	public void test_validationWithMessage() {
		initModelWithErrors();
		
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationWithMessage"), null);
		validateWithSeverity("ValidationWithMessage", Diagnostic.WARNING, badClassInstance, 
			"custom message ");
	}
	
	public void test_validationWithCompleteOCL() {
		initModelWithErrorsAndOcl();
		
		EClass eClassifier = (EClass) companyPackage.getEClassifier("Detritus");
		EObject badClassInstance = create(acme, companyDetritus, eClassifier, null);
		validateWithSeverity("CompleteOCLInvariant", Diagnostic.WARNING, badClassInstance, 
			"Failure on " + eClassifier.getName());
	}
	
	public void test_tutorialValidationMessage() {
		validateTutorial("model/Tutorial1.ecore", "There are 3 loans for the 2 copies of b2");
		validateTutorial("model/Tutorial2.ecore", "There are 3 loans for the 2 copies of ''b2''");		// Doubled quotes for NLS.bind
		validateTutorial("model/Tutorial1.ecore", "There are 3 loans for the 2 copies of b2");
	}

	public void test_tutorial_umlValidation_with_lpg_408990() {
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLConstants.OCL_DELEGATE_URI_LPG);
		ResourceSet resourceSet2 = DomainUtil.nonNullState(resourceSet);
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet2);			
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			assertNull(UML2Pivot.initialize(resourceSet2));
		}
		URI uri = getProjectFileURI("Bug408990.uml");
		Resource umlResource = DomainUtil.nonNullState(resourceSet2.getResource(uri, true));
		assertNoResourceErrors("Loading", umlResource);
		String label = EcoreUtils.qualifiedNameFor(umlResource.getContents().get(1));
		assertValidationDiagnostics("Loading", umlResource, DomainUtil.bind(VIOLATED_TEMPLATE, "Stereotype1::IntegerConstraint", label));
	}

	public void test_tutorial_umlValidation_with_pivot_408990() {
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet2 = DomainUtil.nonNullState(resourceSet);
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet2);			
		OCLDelegateDomain.initialize(resourceSet2, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			assertNull(UML2Pivot.initialize(resourceSet2));
		}
		URI uri = getProjectFileURI("Bug408990.uml");
		Resource umlResource = DomainUtil.nonNullState(resourceSet2.getResource(uri, true));
		assertNoResourceErrors("Loading", umlResource);
		org.eclipse.uml2.uml.Model umlModel = (org.eclipse.uml2.uml.Model)umlResource.getContents().get(0);
		org.eclipse.uml2.uml.Class umlClass1 = (org.eclipse.uml2.uml.Class)umlModel.getOwnedType("Class1");
		org.eclipse.uml2.uml.Profile umlProfile = umlModel.getProfileApplications().get(0).getAppliedProfile();
		org.eclipse.uml2.uml.Stereotype umlStereotype1 = (org.eclipse.uml2.uml.Stereotype)umlProfile.getOwnedType("Stereotype1");
		assert (umlClass1 != null) && (umlStereotype1 != null);
		String label = EcoreUtils.qualifiedNameFor(getStereotypeApplication(umlClass1, umlStereotype1));
		assertValidationDiagnostics("Loading", umlResource, DomainUtil.bind(VIOLATED_TEMPLATE, "Stereotype1::IntegerConstraint", label));
	}

	public void test_tutorial_umlValidation_with_pivot_432920() {
		resetRegistries();
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet2 = DomainUtil.nonNullState(resourceSet);
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet2);			
		OCLDelegateDomain.initialize(resourceSet2, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			assertNull(UML2Pivot.initialize(resourceSet2));
		}
		OCLDelegateDomain.initializePivotOnlyDiagnosticianResourceSet(resourceSet2);
		URI uri = getProjectFileURI("bug432920.uml");
		Resource umlResource = DomainUtil.nonNullState(resourceSet2.getResource(uri, true));
		assertNoResourceErrors("Loading", umlResource);
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		OCLDelegateDomain.initializePivotOnlyDiagnosticianContext(validationContext);
		org.eclipse.uml2.uml.Model umlModel = (org.eclipse.uml2.uml.Model)umlResource.getContents().get(0);
		org.eclipse.uml2.uml.Class umlClass1 = (org.eclipse.uml2.uml.Class)umlModel.getOwnedType("Class1");
		org.eclipse.uml2.uml.Property umlAttribute1 = umlClass1.getOwnedAttribute("Attribute1", null);
		org.eclipse.uml2.uml.ValueSpecification lowerValue = umlAttribute1.getLowerValue();
		org.eclipse.uml2.uml.ValueSpecification upperValue = umlAttribute1.getUpperValue();
		org.eclipse.uml2.uml.Profile umlProfile = umlModel.getProfileApplications().get(0).getAppliedProfile();
		org.eclipse.uml2.uml.Stereotype umlMyClassExtension = (org.eclipse.uml2.uml.Stereotype)umlProfile.getOwnedType("MyClassExtension");
		org.eclipse.uml2.uml.Stereotype umlMyPropertyExtension = (org.eclipse.uml2.uml.Stereotype)umlProfile.getOwnedType("MyPropertyExtension");
		assert (lowerValue != null) && (upperValue != null) && (umlMyClassExtension != null) && (umlMyPropertyExtension != null);
		String string1 = EcoreUtils.qualifiedNameFor(getStereotypeApplication(upperValue, umlMyClassExtension));
		String string2 = EcoreUtils.qualifiedNameFor(getStereotypeApplication(upperValue, umlMyPropertyExtension));
		String string3 = EcoreUtils.qualifiedNameFor(getStereotypeApplication(lowerValue, umlMyClassExtension));
		String string4 = EcoreUtils.qualifiedNameFor(getStereotypeApplication(lowerValue, umlMyPropertyExtension));
		String string5 = EcoreUtils.qualifiedNameFor(getStereotypeApplication(umlAttribute1, umlMyPropertyExtension));
		assertValidationDiagnostics("Loading", umlResource, validationContext,
			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, "MyClassExtension", "ClassConstraint1", string1,
				  DomainUtil.bind(EvaluatorMessages.IncompatibleOclAsTypeSourceType, "UML::LiteralUnlimitedNatural", "Class")),
			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, "MyPropertyExtension", "Constraint1", string2,
				  DomainUtil.bind(EvaluatorMessages.IncompatibleOclAsTypeSourceType, "UML::LiteralUnlimitedNatural", "Property")),
			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, "MyClassExtension", "ClassConstraint1", string3,
				  DomainUtil.bind(EvaluatorMessages.IncompatibleOclAsTypeSourceType, "UML::LiteralInteger", "Class")),
			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, "MyPropertyExtension", "Constraint1", string4,
			  DomainUtil.bind(EvaluatorMessages.IncompatibleOclAsTypeSourceType, "UML::LiteralInteger", "Property")),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "MyPropertyExtension", "Constraint1", string5),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "MyPropertyExtension", "Constraint2", string2),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "MyPropertyExtension", "Constraint2", string4));
	}
	
	public void test_tutorial_umlValidation_with_pivot_434433() {
		resetRegistries();
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet2 = DomainUtil.nonNullState(resourceSet);
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet2);			
		OCLDelegateDomain.initialize(resourceSet2, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			assertNull(UML2Pivot.initialize(resourceSet2));
		}
		OCLDelegateDomain.initializePivotOnlyDiagnosticianResourceSet(resourceSet2);
		URI uri = getProjectFileURI("Bug434433.uml");
		Resource umlResource = DomainUtil.nonNullState(resourceSet2.getResource(uri, true));
		assertNoResourceErrors("Loading", umlResource);
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		OCLDelegateDomain.initializePivotOnlyDiagnosticianContext(validationContext);
		org.eclipse.uml2.uml.Model umlModel = (org.eclipse.uml2.uml.Model)umlResource.getContents().get(0);
		org.eclipse.uml2.uml.Class umlClass1 = (org.eclipse.uml2.uml.Class)umlModel.getOwnedType("Class1");
		org.eclipse.uml2.uml.Profile umlProfile = umlModel.getProfileApplications().get(0).getAppliedProfile();
		org.eclipse.uml2.uml.Stereotype umlStereotype1 = (org.eclipse.uml2.uml.Stereotype)umlProfile.getOwnedType("Stereotype1");
		assert (umlClass1 != null) && (umlStereotype1 != null);
		String label = EcoreUtils.qualifiedNameFor(getStereotypeApplication(umlClass1, umlStereotype1));
		assertValidationDiagnostics("Loading", umlResource, validationContext,
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Stereotype1", "Constraint3", label));
	}
	
	public void test_tutorial_umlValidation_Bug434356() {
		UML2Pivot.TYPE_EXTENSIONS.setState(true);
		resetRegistries();
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet2 = DomainUtil.nonNullState(resourceSet);
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet2);			
		OCLDelegateDomain.initialize(resourceSet2, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			assertNull(UML2Pivot.initialize(resourceSet2));
		}
		OCLDelegateDomain.initializePivotOnlyDiagnosticianResourceSet(resourceSet2);
		URI uri = getProjectFileURI("Bug434356.uml");
		Resource umlResource = DomainUtil.nonNullState(resourceSet2.getResource(uri, true));
		assertNoResourceErrors("Loading", umlResource);
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		OCLDelegateDomain.initializePivotOnlyDiagnosticianContext(validationContext);
		org.eclipse.uml2.uml.Model umlModel = (org.eclipse.uml2.uml.Model)umlResource.getContents().get(0);
		org.eclipse.uml2.uml.Realization umlRealization1 = (org.eclipse.uml2.uml.Realization)umlModel.getPackagedElement("Realization1");
		org.eclipse.uml2.uml.Profile umlProfile = umlModel.getProfileApplications().get(0).getAppliedProfile();
		org.eclipse.uml2.uml.Stereotype umlStereotype1 = (org.eclipse.uml2.uml.Stereotype)umlProfile.getOwnedType("ParentRealization");
		assert (umlRealization1 != null) && (umlStereotype1 != null);
		String label = EcoreUtils.qualifiedNameFor(getStereotypeApplication(umlRealization1, umlStereotype1));
		assertValidationDiagnostics("Loading", umlResource, validationContext,
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "ParentRealization", "In case of a ParentRealization relationship, the supplier should be a child of the client", label));
	}

	public void validateTutorial(@NonNull String ecoreURI, @NonNull String message) {
		MetaModelManager metaModelManager = new MetaModelManager();
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
			URI xmiURI = getTestModelURI("model/Tutorial.xmi");
			Resource ecoreResource = resourceSet.getResource(getTestModelURI(ecoreURI), true);
			EPackage ePackage = (EPackage) ecoreResource.getContents().get(0);
			resourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
			Resource xmiResource = resourceSet.getResource(xmiURI, true);
			EObject rootContent = xmiResource.getContents().get(0);
			EObject book = null;
			for (EObject eObject : rootContent.eContents()) {
				EClass eClass = eObject.eClass();
				if ("Book".equals(eClass.getName())) {
					for (EStructuralFeature eFeature : eClass.getEAllStructuralFeatures()) {
						if ("name".equals(eFeature.getName())) {
							String name = (String) eObject.eGet(eFeature);
							if ("b2".equals(name)) {
								book = eObject;
								break;
							}
						}
					}
				}
			}
			validateWithSeverity("ValidationWithMessage", Diagnostic.WARNING, book,  message);
			unloadResourceSet(resourceSet);
		} finally {
			metaModelManager.dispose();
		}
	}
	
	void add(EObject owner, EStructuralFeature feature, Object value) {
		this.<EList<Object>> get(owner, feature).add(value);
	}

	Collection<EObject> allReports(EObject employee) {
		Collection<EObject> collection = get(employee, employeeAllReports);
		assertTrue(collection instanceof InternalEList<?>);				// Check EMF internal API (fixing Bug 412690)
		assertTrue(collection instanceof EStructuralFeature.Setting);	// Check EMF internal API (fixing Bug 412690)
		return collection;
	}

	EObject create(EObject owner, EReference containment, EClass type,
			String name) {
		EObject result = companyFactory.create(type);

		if (containment.isMany()) {
			add(owner, containment, result);
		} else {
			set(owner, containment, result);
		}

		if (name != null) {
			set(result, type.getEStructuralFeature("name"), name);
		}

		return result;
	}

	EList<EObject> directReports(EObject employee) {
		return get(employee, employeeDirectReports);
	}

	EObject employee(String name) {
		EObject result = employees.get(name);

		if (result == null) {
			EList<EObject> emps = get(acme, companyEmployees);

			for (EObject next : emps) {

				if (name.equals(name(next))) {
					result = next;
					employees.put(name, result);
					break;
				}
			}
		}

		return result;
	}

	EList<EObject> employees(EObject company) {
		return get(company, companyEmployees);
	}

	@SuppressWarnings("unchecked")
	<T> T get(EObject owner, EStructuralFeature feature) {
		Object result = owner.eGet(feature);
		return (T) result;
	}

	public EOperation getOperation(EClass eClass, String name) {
		for (EOperation eOperation : eClass.getEOperations()) {
			if (name.equals(eOperation.getName())) {
				return eOperation;
			}
		}
		fail("Expected to find operation: " + name);
		return null;
	}

	public EStructuralFeature getStructuralFeature(EClass eClass, String name) {
		for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
			if (name.equals(eStructuralFeature.getName())) {
				return eStructuralFeature;
			}
		}
		fail("Expected to find structural feature: " + name);
		return null;
	}

	protected DomainType getType(EObject eObject) {
		return metaModelManager.getIdResolver().getStaticTypeOf(eObject);
	}

	public void getWithException(EObject eObject, String featureName, String expectedMessage) {
		EClass eClass = eObject.eClass();
		EAttribute eAttribute = (EAttribute) eClass.getEStructuralFeature(featureName);
		try {
			@SuppressWarnings("unused")
			Object object = get(eObject, eAttribute);
			fail("Expected to catch OCLDelegateException: " + expectedMessage);
		} catch (OCLDelegateException e) {
			assertEquals("OCLDelegateException: ", expectedMessage, e.getCause().getLocalizedMessage());
		}
	}	

	@SuppressWarnings("unchecked")
	<T> T invoke(EObject target, EOperation operation, Object... arguments) throws InvocationTargetException {
//		try {
			return (T) target.eInvoke(operation, (arguments.length == 0)
				? ECollections.<Object> emptyEList()
				: new BasicEList.UnmodifiableEList<Object>(arguments.length,
					arguments));
//		} catch (InvocationTargetException ite) {
//			fail("Failed to invoke operation: " + ite.getLocalizedMessage());
//			return null;
//		}
	}

	public void invokeWithException(EObject eObject, String name, String expectedMessage) throws InvocationTargetException {
		EClass eClass = eObject.eClass();
		for (EOperation eOperation : eClass.getEOperations()) {
			if (name.equals(eOperation.getName())) {
				try {
					@SuppressWarnings("unused")
					Object object = invoke(eObject, eOperation);
					fail("Expected to catch InvocationTargetException: " + expectedMessage);
				} catch (OCLDelegateException e) {
					Throwable cause = e.getCause();
					assertEquals("OCLDelegateException: ", expectedMessage, cause.getLocalizedMessage());
					return;
				}
			}
		}
		fail("Expected to find: " + name);
	}

	Object execute(QueryDelegate delegate, Object target,
			Map<String, Object> bindings) {
		try {
			return delegate.execute(target, bindings);
		} catch (InvocationTargetException ite) {
			fail("Failed to execute query: " + ite.getCause().getLocalizedMessage());
			return null;
		}
	}

	public void executeWithException(QueryDelegate delegate, Object target,
			Map<String, Object> bindings, String messageTemplate,
			Object... messageBindings) {
		String expectedMessage = DomainUtil.bind(messageTemplate, messageBindings);
		try {
			@SuppressWarnings("unused")
			Object object = delegate.execute(target, bindings);
			fail("Expected to catch InvocationTargetException: " + expectedMessage);
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			assertEquals(cause.getClass().getSimpleName() + ": ", expectedMessage, cause.getLocalizedMessage());
		}
	}

	public void executeWithException2(QueryDelegate delegate, Object target, Map<String, Object> bindings, String expectedMessage) {
		try {
			@SuppressWarnings("unused")
			Object object = delegate.execute(target, bindings);
			fail("Expected to catch InvocationTargetException: " + expectedMessage);
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			assertEquals(cause.getClass().getSimpleName() + ": ", expectedMessage, cause.getLocalizedMessage());
		}
	}

	<T> EList<T> list(T... element) {
		return new BasicEList<T>(Arrays.asList(element));
	}

	EObject manager(EObject employee) {
		return get(employee, employeeManager);
	}

	String name(EObject employeeOrCompany) {
		EAttribute name = employeeClass.isInstance(employeeOrCompany)
			? employeeName
			: companyName;

		return get(employeeOrCompany, name);
	}

	void set(EObject owner, EStructuralFeature feature, Object value) {
		owner.eSet(feature, value);
	}

	Enumerator size(EObject company) {
		return get(company, companySize);
	}

	protected void validateWithoutError(EObject eObject) {
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic validation = Diagnostician.INSTANCE.validate(eObject, validationContext);
		if (validation.getSeverity() != Diagnostic.OK) {
			List<Diagnostic> diagnostics = validation.getChildren();
			if (!diagnostics.isEmpty()) {
				StringBuilder s = null;
				for (Diagnostic diagnostic : diagnostics) {
					if (s == null) {
						s = new StringBuilder();
					}
					else {
						s.append("\n");
					}
					s.append(diagnostic.getMessage());
				}
				@SuppressWarnings("null")
				String string = s.toString();
				fail(string);
			}
		}
		assertEquals("Validation severity:", Diagnostic.OK, validation.getSeverity());
		List<Diagnostic> diagnostics = validation.getChildren();
		assertEquals("Validation child count:", 0, diagnostics.size());
	}

	protected void validateConstraintWithSeverity(String constraintName, int severity, EObject eObject) {
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic validation = Diagnostician.INSTANCE.validate(eObject, validationContext);
		assertEquals("Validation of '" + constraintName + "' severity:", severity, validation.getSeverity());
		List<Diagnostic> diagnostics = validation.getChildren();
		assertEquals("Validation of '" + constraintName + "' child count:", 1, diagnostics.size());
		Diagnostic diagnostic = diagnostics.get(0);
		assertEquals("Validation of '" + constraintName + "' data count:", 1, diagnostic.getData().size());
		assertEquals("Validation of '" + constraintName + "' data object:", eObject, diagnostic.getData().get(0));
		Object objectLabel = EcoreUtils.qualifiedNameFor(eObject);
//		Object objectLabel = DomainUtil.getLabel(eObject);
		String message = DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_,
			eObject.eClass().getName(), constraintName, objectLabel);
		assertEquals("Validation of '" + constraintName + "' message:", message, diagnostic.getMessage());
	}

	protected void validateInvariantWithSeverity(String constraintName, int severity, EObject eObject) {
		validateWithSeverity(constraintName, severity, eObject, EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic"), constraintName, DomainUtil.getLabel(eObject));
	}

	protected void validateWithSeverity(String constraintName, int severity, EObject eObject, String messageTemplate, Object... bindings) {
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic validation = Diagnostician.INSTANCE.validate(eObject, validationContext);
		assertEquals("Validation of '" + constraintName + "' severity:", severity, validation.getSeverity());
		List<Diagnostic> diagnostics = validation.getChildren();
		assertEquals("Validation of '" + constraintName + "' child count:", 1, diagnostics.size());
		Diagnostic diagnostic = diagnostics.get(0);
		assertEquals("Validation of '" + constraintName + "' data count:", 1, diagnostic.getData().size());
		assertEquals("Validation of '" + constraintName + "' data object:", eObject, diagnostic.getData().get(0));
		String message = DomainUtil.bind(messageTemplate, bindings);
		assertEquals("Validation of '" + constraintName + "' message:", message, diagnostic.getMessage());
	}

	protected void validateWithDelegationSeverity(String constraintName, int severity, EObject eObject, String source, Class<? extends Exception> exceptionClass, String messageTemplate, Object... bindings) {
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic validation = Diagnostician.INSTANCE.validate(eObject, validationContext);
		assertEquals("Validation of '" + constraintName + "' severity:", severity, validation.getSeverity());
		List<Diagnostic> diagnostics = validation.getChildren();
		assertEquals("Validation of '" + constraintName + "' child count:", 1, diagnostics.size());
		Diagnostic diagnostic = diagnostics.get(0);
		List<?> data = diagnostic.getData();
		int size = data.size();
		if (size == 2)	{				// EMF 2.10.0M3 and later
			assertEquals("Validation of '" + constraintName + "' exception:", exceptionClass, data.get(1).getClass());
		}
		else if (size != 1) {			// EMF 2.10.0M2 and earlier
			fail("Validation of '" + constraintName + "' child count: " + size);
		}
		String message = getErrorsInMessage(eObject.eClass().getName(), constraintName, source);
		message += DomainUtil.bind(messageTemplate, bindings);
		assertEquals("Validation of '" + constraintName + "' data object:", eObject, data.get(0));
		assertEquals("Validation of '" + constraintName + "' message:", message, diagnostic.getMessage());
	}

	protected String getErrorsInMessage(String packageName, String typeName, String source) {
		return source != null ? (DomainUtil.bind(OCLMessages.ValidationConstraintIsInvalid_ERROR_, packageName, typeName, source) + "\n") : "";
	}
}
