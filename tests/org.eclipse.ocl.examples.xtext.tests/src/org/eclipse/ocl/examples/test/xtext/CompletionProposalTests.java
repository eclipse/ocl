/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.OCLinEcoreUiModule;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.internal.OCLinEcoreActivator;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateProposal;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

/**
 * Tests that completion proposals include expected results and/or exclude unwanted offerings.
 * 
 * It is not intended to provide exhaustive testing of all possible proposals.
 * 
 * It is assumed that the grammar-driven capabilities of Xtext will be generally correct.
 * 
 * There we test first to conform that completion propsals exist and so detect whether some
 * unwanted evolution has occurred in Xtext or its usage.
 * 
 * Then we test known challenging cases especially regressions.
 */
@SuppressWarnings("null")
public class CompletionProposalTests extends XtextTestCase
{		
	public static interface IReferenceCompletionProposal
	{
		boolean covers(@NonNull ICompletionProposal aProposal);
	}
	
	public static class ReferenceCompletionProposal implements IReferenceCompletionProposal
	{
		protected final @NonNull String name;
		
		public ReferenceCompletionProposal(@NonNull String name) {
			this.name = name;
		}

		@Override
		public boolean covers(@NonNull ICompletionProposal aProposal) {
			if (!name.equals(aProposal.getDisplayString())) {
				return false;
			}
			return true;
		}	
	}
	
	public static class ReferenceConfigurableCompletionProposal extends ReferenceCompletionProposal implements IReferenceCompletionProposal
	{
		public ReferenceConfigurableCompletionProposal(@NonNull String name) {
			super(name);
		}

		@Override
		public boolean covers(@NonNull ICompletionProposal aProposal) {
			if (!(aProposal instanceof ConfigurableCompletionProposal)) {
				return false;
			}
			return super.covers(aProposal);
		}	
	}
	
	public static class ReferenceXtextTemplateProposal extends ReferenceCompletionProposal
	{
		public ReferenceXtextTemplateProposal(@NonNull String name) {
			super(name);
		}

		@Override
		public boolean covers(@NonNull ICompletionProposal aProposal) {
			if (!(aProposal instanceof XtextTemplateProposal)) {
				return false;
			}
			return super.covers(aProposal);
		}	
	}
	
	public static final @NonNull IReferenceCompletionProposal abstractKeywordProposal = new ReferenceConfigurableCompletionProposal("abstract");
	public static final @NonNull IReferenceCompletionProposal annotationTemplateProposal = new ReferenceXtextTemplateProposal("Annotation - annotation declaration");
	public static final @NonNull IReferenceCompletionProposal selfKeywordProposal = new ReferenceConfigurableCompletionProposal("self");
	public static final @NonNull IReferenceCompletionProposal sNameProposal = new ReferenceConfigurableCompletionProposal("s");

	public static void assertExcludes(ICompletionProposal[] actualProposals, IReferenceCompletionProposal expectedProposal) {
		for (ICompletionProposal actualProposal : actualProposals) {
			if (expectedProposal.covers(actualProposal)) {
				fail("Unexpected completion proposal" + expectedProposal);
			}
		}
	}

	public static void assertIncludes(ICompletionProposal[] actualProposals, IReferenceCompletionProposal expectedProposal) {
		for (ICompletionProposal actualProposal : actualProposals) {
			if (expectedProposal.covers(actualProposal)) {
				return;
			}
		}
		fail("Missing completion proposal" + expectedProposal);
	}

	protected XtextContentAssistProcessor contentAssistProcessor = null;
	protected XtextEditor editor = null;
	
	protected FileEditorInput createEcoreFileEditorInput(String projectName, String fileName, String testDocument)throws IOException, CoreException {
		OCL ocl0 = OCL.newInstance();
		MetaModelManager metaModelManager0 = ocl0.getMetaModelManager();
		String ecoreString = createEcoreString(metaModelManager0, fileName, testDocument, true);
		InputStream inputStream = new URIConverter.ReadableInputStream(ecoreString, "UTF-8");
		FileEditorInput fileEditorInput = createFileEditorInput(projectName, fileName, inputStream);
		metaModelManager0.dispose();
		return fileEditorInput;
	}

	protected FileEditorInput createFileEditorInput(String projectName, String testFile, InputStream inputStream) throws CoreException {
		IProject project = createProject(projectName);
		IFile file1 = project.getFile(testFile);
		file1.create(inputStream, true, null);
		return new FileEditorInput(file1);
	}

	protected IProject createProject(String projectName) throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(projectName);
		if (!project.exists()) {
			project.create(null);
		}
		project.open(null);
		return project;
	}

	protected void doTearDown(XtextEditor editor) {
		IXtextDocument document = editor.getDocument();
		MetaModelManager metaModelManager = document.modify(new IUnitOfWork<MetaModelManager, XtextResource>() {				// Cancel validation
			@Override
			public MetaModelManager exec(@Nullable XtextResource state) throws Exception {
				return PivotUtil.findMetaModelManager(state);
			}
		});
		flushEvents();
		editor.close(false);
		flushEvents();
		if (metaModelManager != null) {
			metaModelManager.dispose();
		}
	}

	public void doTestEditor(@NonNull String testContent, @Nullable IReferenceCompletionProposal[] expectedProposals,
			@Nullable IReferenceCompletionProposal[] unexpectedProposals) throws Exception {
		int cursorIndex = testContent.indexOf("$");
		String trueContent = testContent.replace("$",  "");
		IXtextDocument document = editor.getDocument();
		document.set(trueContent);
		ITextViewer viewer = editor.getInternalSourceViewer();
		ICompletionProposal[] actualProposals = contentAssistProcessor.computeCompletionProposals(viewer, cursorIndex);
		if (expectedProposals != null) {
			for (IReferenceCompletionProposal expectedProposal : expectedProposals) {
				assertIncludes(actualProposals, expectedProposal);
			}
		}
		if (unexpectedProposals != null) {
			for (IReferenceCompletionProposal unexpectedProposal : unexpectedProposals) {
				assertExcludes(actualProposals, unexpectedProposal);
			}
		}
	}

	protected void flushEvents() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		while (workbench.getDisplay().readAndDispatch());
	}
	
	@Override
	protected void setUp() throws Exception {
		suppressGitPrefixPopUp();    		
		super.setUp();
	}

	protected void doSetUp(@NonNull String editorId, Injector injector, @NonNull String fileName, @NonNull String initialContent)
			throws CoreException, PartInitException {
		contentAssistProcessor = injector.getInstance(XtextContentAssistProcessor.class);
		InputStream inputStream = new URIConverter.ReadableInputStream(initialContent, "UTF-8");
		FileEditorInput fileEditorInput = createFileEditorInput("test", fileName, inputStream);
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage page = activeWorkbenchWindow.getActivePage();
		editor = (XtextEditor) IDE.openEditor(page, fileEditorInput, editorId, true);
	}

	public void testEditor_OCLinEcore_Completions() throws Exception {
		Injector injector = OCLinEcoreActivator.getInstance().getInjector(OCLinEcoreActivator.ORG_ECLIPSE_OCL_EXAMPLES_XTEXT_OCLINECORE_OCLINECORE);
		doSetUp(OCLinEcoreUiModule.EDITOR_ID, injector, "completion.oclinecore", "package test : test = 'test' {}");
		doTestEditor("package p : p = 'p' {$}",
			new IReferenceCompletionProposal[]{abstractKeywordProposal, annotationTemplateProposal}, null);
		doTestEditor("package p : p = 'p' { class C { invariant I:$}}",
			new IReferenceCompletionProposal[]{selfKeywordProposal}, null);
		doTestEditor("package p : p = 'p' { class C { property s:String; invariant I:self.$}}",
			new IReferenceCompletionProposal[]{sNameProposal}, null/*new IReferenceCompletionProposal[]{selfKeywordProposal}*/);
		doTearDown(editor);
	}
}
