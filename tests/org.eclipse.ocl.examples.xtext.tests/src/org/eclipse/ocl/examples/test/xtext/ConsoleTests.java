/**
 * <copyright>
 *
 * Copyright (c) 2011,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 392981
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.test.xtext;

import java.math.BigInteger;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.tests.PivotTestCase;
import org.eclipse.ocl.examples.xtext.console.ColorManager;
import org.eclipse.ocl.examples.xtext.console.OCLConsole;
import org.eclipse.ocl.examples.xtext.console.OCLConsolePage;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseDocument;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.part.IPageBookViewPage;

/**
 * Tests that exercise the Xtext OCL Console.
 */
@SuppressWarnings("restriction")
public class ConsoleTests extends PivotTestCase
{	
	public static class TestConsole extends OCLConsole
	{
		private static TestConsole instance;

		public static TestConsole getInstance() {
			if (instance == null) {
				instance = new TestConsole();
				ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] {instance});
			}			
			return instance;
		}

		private TestConsolePage page;
		
		@Override
		public void close() {
			super.close();
			flushEvents();
			instance = null;
		}

		@Override
		public IPageBookViewPage createPage(IConsoleView view) {
			page = new TestConsolePage(this);
			return page;
		}
		
		public final TestConsolePage getPage() {
			return page;
		}
	}
	
	public static class TestConsolePage extends OCLConsolePage
	{
		private StringBuilder s = new StringBuilder();
		
		public TestConsolePage(TestConsole testConsole) {
			super(testConsole);
		}

		@Override
		protected void append(String text, RGB rgb, boolean bold) {
			super.append(text, rgb, bold);
			String boldTag;
			if (bold) { boldTag = "b"; }
			else { boldTag = null; }
			String rgbTag;
			if (rgb == ColorManager.DEFAULT) { rgbTag = null; }
			else if (rgb == ColorManager.OUTPUT_ERROR) { rgbTag = "error"; }
			else if (rgb == ColorManager.OUTPUT_RESULTS) { rgbTag = null; }
			else { rgbTag = "?"; }
			if (boldTag != null) {
				s.append("<" + boldTag + ">");
			}
			if (rgbTag != null) {
				s.append("<" + rgbTag + ">");
			}
			s.append(text + "\n");
			if (rgbTag != null) {
				s.append("</" + rgbTag + ">");
			}
			if (boldTag != null) {
				s.append("</" + boldTag + ">");
			}
		}

		@Override
		public boolean evaluate(String expression) {
			return super.evaluate(expression);
		}

		public String get() {
			return s.toString();
		}

		public ILaunch launchDebugger() {
			return internalLaunchDebugger();
		}

		@Override
		public void refreshSelection(Object selected) {
			super.refreshSelection(selected);
		}

		@Override
		public void resetDocument() {
			super.resetDocument();
			s = new StringBuilder();
		}
	}

	public static void assertConsoleResult(TestConsolePage consolePage, EObject contextObject, String testExpression, String expectedResult) {
		consolePage.resetDocument();
		flushEvents();
		consolePage.refreshSelection(contextObject);
		flushEvents();
		BaseDocument editorDocument = consolePage.getEditorDocument();
//		System.out.println("Set " + testExpression);
		editorDocument.set(testExpression);
		flushEvents();			// Let ValidationJob and other activities have a go
		consolePage.evaluate(testExpression);
		flushEvents();			// FIXME on more than one occasion the previous result was returned (perhaps the new input was not set) (before additional flushEvents added above)
		String string = consolePage.get();
		assertEquals("<b>Evaluating:\n</b>" + testExpression + "\n<b>Results:\n</b>" + expectedResult, string);
	}

	public static void flushEvents() {
		for (int i = 0; i < 10; i++) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			while (workbench.getDisplay().readAndDispatch());
		}
	}

	public TestConsolePage consolePage;
	public MetaModelManager metaModelManager;
	public OCL ocl;
	public ASResource asResource;
	public Type englishClass;
	public Type frenchClass;
	public Type germanClass;
	public Type plainClass;
	public ElementExtension englishClassInEnglish;
	public Type inEnglishStereotype;
	public Type inFrenchStereotype;
	public Type inGermanStereotype;

	protected void closeIntro() {
		IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
		introManager.closeIntro(introManager.getIntro());
	}

	protected void enableSwitchToDebugPerspectivePreference() {
		DebugUIPlugin.getDefault().getPreferenceStore().setValue(IInternalDebugUIConstants.PREF_SWITCH_TO_PERSPECTIVE, MessageDialogWithToggle.ALWAYS);
	}
	
	protected @NonNull TestConsolePage openConsole() {
		closeIntro();
		flushEvents();
		TestConsole console = TestConsole.getInstance();
		IConsoleManager mgr = ConsolePlugin.getDefault().getConsoleManager();
		mgr.showConsoleView(console);
		flushEvents();
		@Nullable TestConsolePage consolePage = console.getPage();
		for (int i = 0; (consolePage == null) && (i < 100000); i++) {
			flushEvents();
			consolePage = console.getPage();
		}
		assert consolePage != null;
		return consolePage;
	}	
	
    @SuppressWarnings("null")
	@Override
    protected void setUp() throws Exception {
		suppressGitPrefixPopUp();    		
        super.setUp();
		OCLstdlib.install();
		ocl = OCL.newInstance();
		metaModelManager = ocl.getMetaModelManager();
		ResourceSet resourceSet = metaModelManager.getExternalResourceSet();
		consolePage = openConsole();

		URI testModelURI = getTestModelURI("model/InternationalizedClasses.uml");
        Resource umlResource = resourceSet.getResource(testModelURI, true);
        asResource = ocl.uml2pivot(umlResource);
        Root root = (Root) asResource.getContents().get(0);
        org.eclipse.ocl.examples.pivot.Package modelPackage = DomainUtil.getNamedElement(root.getNestedPackage(), "Model");
        englishClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "EnglishClass");
        frenchClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "FrenchClass");
        germanClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "GermanClass");
        plainClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "PlainClass");
        PackageServer profile = metaModelManager.getPackageManager().getPackageByURI("http://www.eclipse.org/ocl/examples/Internationalized");
        inEnglishStereotype = profile.getMemberType("InEnglish");
        inFrenchStereotype = profile.getMemberType("InFrench");
        inGermanStereotype = profile.getMemberType("InGerman");
        englishClassInEnglish = DomainUtil.getNamedElement(englishClass.getExtension(), "EnglishClass$InEnglish");
    }

/*	public void testConsole_Ecore() throws Exception {
//		assertConsoleResult(consolePage, EcorePackage.Literals.ECLASS, "self.name", "'EClass'");
//		assertConsoleResult(consolePage, EcorePackage.Literals.ECLASS, "self.name", "'EClass'");
		assertConsoleResult(consolePage, EcorePackage.Literals.ECLASS, "self.instanceType.eAttributes.name", "");
		assertConsoleResult(consolePage, EcorePackage.Literals.ECLASS, "self.ownedAttribute.name->iterate(s : String ; acc : String = '' | acc + ' ' + s)", "' abstract interface'");
	} */

	@Override
	protected void tearDown() throws Exception {
		ocl.dispose();
		ocl = null;
		metaModelManager = null;
		TestConsole.getInstance().close();
		consolePage = null;
		super.tearDown();
	}

	public void testConsole_UML() throws Exception {
		assertConsoleResult(consolePage, englishClass, "self.name", "'EnglishClass'\n");
//		assertConsoleResult(consolePage, englishClass, "self.extension_InEnglish.oclType().instanceType.name", "'EnglishClass$InEnglish'\n");
	}

	public void testConsole_oclLog() throws Exception {
		assertConsoleResult(consolePage, null, "7", "7\n");
		assertConsoleResult(consolePage, null, "7.oclLog('seven = ')", "seven = 7\n7\n");
	}

	public void zztestConsole_debugger() throws Exception {
//		VMVirtualMachine.LOCATION.setState(true);
//		VMVirtualMachine.PRE_VISIT.setState(true);
//		VMVirtualMachine.POST_VISIT.setState(true);
//		VMVirtualMachine.VISITOR_STACK.setState(true);
//		VMVirtualMachine.VM_EVENT.setState(true);
//		VMVirtualMachine.VM_REQUEST.setState(true);
//		VMVirtualMachine.VM_RESPONSE.setState(true);
		enableSwitchToDebugPerspectivePreference();
//		assertConsoleResult(consolePage, englishClass, "self.name", "'EnglishClass'\n");
		assertConsoleResult(consolePage, EcorePackage.Literals.ECLASS, "self.name <> null", "true\n");
		ILaunch launch = consolePage.launchDebugger();
		assertNotNull(launch);
		IDebugTarget debugTarget = launch.getDebugTarget();
		IThread vmThread = debugTarget.getThreads()[0];
		vmThread.stepInto();
		waitForLaunchToTerminate(launch);
	}

	public void testConsole_UMLallInstances() throws Exception {
		assertConsoleResult(consolePage, englishClass.getETarget(), "Stereotype.allInstances()->sortedBy(name)", "");		// Tests Bug 392981
		assertConsoleResult(consolePage, englishClass, "Stereotype.allInstances()->sortedBy(name)", "");
		assertConsoleResult(consolePage, inEnglishStereotype, "Stereotype.allInstances()->sortedBy(name)", "InternationalizedProfile::InEnglish\nInternationalizedProfile::InFrench\nInternationalizedProfile::InGerman\nInternationalizedProfile::Internationalized\n");
		assertConsoleResult(consolePage, englishClass, "Class.allInstances()->sortedBy(name)", "Model::EnglishClass\nModel::FrenchClass\nModel::GermanClass\nModel::LanguageClass\nModel::PlainClass\nString\n");
	}

	public void testConsole_OCLinEcoreTutorial() throws Exception {
		ResourceSet resourceSet = metaModelManager.getExternalResourceSet();
		URI testModelURI = getTestModelURI("model/OCLinEcoreTutorialForPivot.xmi");
		Resource xmiResource = resourceSet.getResource(testModelURI, true);
		EObject xmiLibrary = xmiResource.getContents().get(0);
		EClass ecoreLibrary = xmiLibrary.eClass();
		EStructuralFeature ecoreBooks = ecoreLibrary.getEStructuralFeature("books");
		EStructuralFeature ecoreLoans = ecoreLibrary.getEStructuralFeature("loans");
		EClass ecoreBook = (EClass) ecoreBooks.getEType();
		EClass ecoreLoan = (EClass) ecoreLoans.getEType();
		EStructuralFeature bookName = ecoreBook.getEStructuralFeature("name");
		EStructuralFeature loanBook = ecoreLoan.getEStructuralFeature("book");
		EStructuralFeature bookCopies = ecoreBook.getEStructuralFeature("copies");
		@SuppressWarnings("unchecked")
		List<EObject> xmiBooks = (List<EObject>) xmiLibrary.eGet(ecoreBooks);
		EObject b1Book = null;
		EObject b2Book = null;
		for (EObject xmiBook : xmiBooks) {
			if (xmiBook.eGet(bookName).equals("b1")) {
				b1Book = xmiBook;
			}
			else if (xmiBook.eGet(bookName).equals("b2")) {
				b2Book = xmiBook;
			}
		}
		if (b2Book == null) {
			fail();
			return;
		}
		@SuppressWarnings("unchecked")
		EObject aLoan = ((List<EObject>) xmiLibrary.eGet(ecoreLoans)).get(0);
		//
		assertConsoleResult(consolePage, xmiLibrary, "books->sortedBy(name)", "Library lib::Book b1\nLibrary lib::Book b2\n");
		assertConsoleResult(consolePage, xmiLibrary, "isAvailable()", "<b><error>Parsing failure\n</error></b><error>\n1: Unresolved Operation '::isAvailable()'\n</error>");
		assertConsoleResult(consolePage, b2Book, "isAvailable()", "false\n");
		assertConsoleResult(consolePage, b1Book, "isAvailable()", "true\n");
		aLoan.eSet(loanBook, b1Book);
		assertConsoleResult(consolePage, b2Book, "isAvailable()", "false\n");
		assertConsoleResult(consolePage, b1Book, "isAvailable()", "false\n");
		b2Book.eSet(bookCopies, BigInteger.valueOf(3));
		assertConsoleResult(consolePage, b2Book, "isAvailable()", "true\n");
		assertConsoleResult(consolePage, b1Book, "isAvailable()", "false\n");
		//
		assertConsoleResult(consolePage, ecoreBook, "name", "'Book'\n");
		assertConsoleResult(consolePage, ecoreBook, "copies", "<b><error>Parsing failure\n</error></b><error>\n1: Unresolved Property '::copies'\n</error>");
		assertConsoleResult(consolePage, ecoreBook, "oclType().ownedAttribute->sortedBy(name)",
			"ecore::EClass::EClass\n" + 
			"ecore::EClass::EClass\n" + 
			"ecore::EClass::EReference\n" + 
			"ecore::EClass::abstract\n" + 
			"ecore::EClass::eAllAttributes\n" + 
			"ecore::EClass::eAllContainments\n" + 
			"ecore::EClass::eAllGenericSuperTypes\n" + 
			"ecore::EClass::eAllOperations\n" + 
			"ecore::EClass::eAllReferences\n" + 
			"ecore::EClass::eAllStructuralFeatures\n" + 
			"ecore::EClass::eAllSuperTypes\n" + 
			"ecore::EClass::eAttributes\n" + 
			"ecore::EClass::eGenericSuperTypes\n" + 
			"ecore::EClass::eIDAttribute\n" + 
			"ecore::EClass::eOperations\n" + 
			"ecore::EClass::eReferences\n" + 
			"ecore::EClass::eStructuralFeatures\n" + 
			"ecore::EClass::eSuperTypes\n" + 
			"ecore::EClass::interface\n");
	}
	
	protected void waitForLaunchToTerminate(@NonNull ILaunch launch) throws InterruptedException, DebugException {
		while (true) {
			for (int i = 0; i < 10; i++){
				flushEvents();
				Thread.sleep(100);
			}
			boolean allDead = true;
			for (IDebugTarget debugTarget : launch.getDebugTargets()) {
				IProcess process = debugTarget.getProcess();
				if (!process.isTerminated()) {
					allDead = false;
				}
				for (IThread debugThread : debugTarget.getThreads()) {
					if (!debugThread.isTerminated()) {
						allDead = false;
					}
				}
			}
			if (allDead) {
				break;
			}
		}
	}
}
