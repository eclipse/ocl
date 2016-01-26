/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.ocl.xtext.base.ui.BaseEditor;
import org.eclipse.ocl.xtext.base.ui.BaseUiPluginHelper;
import org.eclipse.ocl.xtext.base.ui.messages.BaseUIMessages;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * DeferredDocumentProvider defers the document provision. A please-wait page is displayed until
 * loading has completed on a worker thread.
 * <p>
 * setDocumentContent is intercepted and the sourceText is queued for assignment by a DeferredSetTextJob
 * a waiting message is displayed instead.
 * <br>
 * once Editor.createPartControl() is complete the BaseEditor should invoke scheduleDeferredSetTextJob
 * to assign the true sourceText triggering what appears to be an edit with reconciliations, validations
 * and updates.
 */
public class DeferredDocumentProvider extends XtextDocumentProvider
{
	/**
	 * Job scheduled on a worker thread to compute the editor text.
	 */
	protected class DeferredSetTextJob extends Job
	{
		protected final @NonNull XtextDocument document;
		protected final @NonNull String sourceText;

		public DeferredSetTextJob(@NonNull XtextDocument document, @NonNull String sourceText) {
			super("Deferred Editor SetText");
			this.document = document;
			this.sourceText = sourceText;
//			System.out.println("Create DeferredSetTextJob@" + System.identityHashCode(this));
		}
		
		@Override
		protected IStatus run(final IProgressMonitor monitor) {
//			System.out.println("Schedule DeferredSetTextJob@" + System.identityHashCode(this));
			Boolean didIt = document.modify(new DeferredSetTextUnitOfWork(document, sourceText));
			if (didIt != Boolean.TRUE) {
				schedule(250);
			}
			return Status.OK_STATUS;
		}
	}
	
	/**
	 * IUnitOfWork for execution on the worker thread with exclusive modify access to compute the
	 * editor text.
	 */
	public class DeferredSetTextUnitOfWork implements IUnitOfWork<Boolean, XtextResource>
	{
		protected final @NonNull XtextDocument document;
		protected final @NonNull String sourceText;

		public DeferredSetTextUnitOfWork(@NonNull XtextDocument document, @NonNull String sourceText) {
			this.document = document;
			this.sourceText = sourceText;
		}

		@Override
		public Boolean exec(XtextResource state) throws Exception {
			if (state == null) {
				return Boolean.FALSE;
			}
			setDocumentText(document, sourceText);
			return Boolean.TRUE;
		}
	}
	
	/**
	 * Runnable for execution on the main UI thread to actually assign the text.
	 */
	protected class DeferredSetTextRunnable implements Runnable
	{
		protected final @NonNull XtextDocument document;
		protected final @NonNull String displayText;

		public DeferredSetTextRunnable(@NonNull XtextDocument document, @NonNull String displayText) {
			this.displayText = displayText;
			this.document = document;
		}

		@Override
		public void run() {
//			System.out.println("SetText XtextDocument@" + System.identityHashCode(document) + "\n" + displayText);
			document.set(displayText);
			IEditorInput element = document2element.get(document);
			ElementInfo elementInfo = getElementInfo(element);
			if (elementInfo != null) {
				elementInfo.fCanBeSaved = false;
			}
			document2element.remove(document);
			/*DeferredSetTextJob oldJob =*/ document2job.remove(document);
//			System.out.println("Remove DeferredSetTextJob@" + System.identityHashCode(oldJob));
			TextViewer sourceViewer = document2viewer.remove(document);
			fireElementDirtyStateChanged(element, false);
			if ((document instanceof BaseDocument) && (sourceViewer != null)) {
				IUndoManager undoManager = sourceViewer.getUndoManager();
				if (undoManager != null) {
					undoManager.connect(sourceViewer);
				}
			}
		}
	}

	private @NonNull Map<IDocument, IEditorInput> document2element = new HashMap<IDocument, IEditorInput>();
	private @NonNull Map<IDocument, IDocument> document2document = new HashMap<IDocument, IDocument>();		// See BUG 469967
	private @NonNull Map<IDocument, DeferredSetTextJob> document2job = new HashMap<IDocument, DeferredSetTextJob>();
	private @NonNull Map<IDocument, TextViewer> document2viewer = new HashMap<IDocument, TextViewer>();

	protected @NonNull String getPleaseWaitText() {
		return "/* " + BaseUIMessages.DeferredDocumentProvider_PleaseWait + " */";
	}

	@Override
	protected void handleElementContentChanged(IFileEditorInput editorInput) {
		super.handleElementContentChanged(editorInput);
		IDocument document = getDocument(editorInput);
		DeferredSetTextJob deferredLoadingJob = document2job.get(document);
		if (deferredLoadingJob != null) {
//			System.out.println("Schedule2 DeferredSetTextJob@" + System.identityHashCode(deferredLoadingJob));
//			document2viewer.put(document, sourceViewer);
			deferredLoadingJob.schedule(100);
		}
	}

	public void scheduleDeferredSetTextJob(@NonNull BaseEditor baseEditor) {
		TextViewer sourceViewer = baseEditor.getTextViewer();
		IEditorInput editorInput = baseEditor.getEditorInput();
		IDocument document = getDocument(editorInput);
		DeferredSetTextJob deferredLoadingJob = document2job.get(document);
		if (deferredLoadingJob != null) {
			document2viewer.put(document, sourceViewer);
			deferredLoadingJob.schedule(100);		// Give XtextReconciler, ValidationJob a chance to finish
		}
	}
	
	@Deprecated // not used from RC2 onwards
	public void scheduleDeferredSetTextJob(IEditorInput input) {
		IDocument document = getDocument(input);
		DeferredSetTextJob deferredLoadingJob = document2job.get(document);
		if (deferredLoadingJob != null) {
			deferredLoadingJob.schedule(100);		// Give XtextReconciler, ValidationJob a chance to finish
		}
	}

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		document2element.put(document, editorInput);
		IDocument oldDocument = getDocument(editorInput);
		if (oldDocument != null) {
			document2document.put(document, oldDocument);
		}
//		System.out.println("setDocumentContent XtextDocument@" + System.identityHashCode(document) + " IEditorInput@" + System.identityHashCode(editorInput));
		return super.setDocumentContent(document, editorInput, encoding);
	}

	@Override
	protected void setDocumentContent(IDocument document, InputStream contentStream, String encoding) throws CoreException {
		assert document instanceof XtextDocument;
		try {
			StringBuilder s = new StringBuilder();
			Reader reader = new InputStreamReader(contentStream, encoding);
			char[] cbuf = new char[16384];
			int len;
			while ((len = reader.read(cbuf)) > 0) {
				s.append(cbuf, 0, len);
			}
			@NonNull String string = s.toString();
			IDocument document2 = document2document.get(document);
			if (document2 != null) {
				document = document2;
			}
			DeferredSetTextJob deferredLoadingJob = new DeferredSetTextJob((XtextDocument) document, string);
			document2job.put(document, deferredLoadingJob);
			String loading = getPleaseWaitText();
			InputStream is = new ByteArrayInputStream(loading.getBytes());
//			System.out.println("setDocumentContent XtextDocument@" + System.identityHashCode(document) + "\n" + loading);
			super.setDocumentContent(document, is, encoding);
		} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR, BaseUiPluginHelper.PLUGIN_ID, IStatus.OK, "Failed to read document", e);
			throw new CoreException(status);
		}
	}

	/**
	 * Define the content of document as text. This is invoked by the Job and queues
	 * an update on the main UI thread. It may be overloaded to change the text from sourceText
	 * to the displayText.
	 */
	protected void setDocumentText(final @NonNull XtextDocument document, final @NonNull String text) throws CoreException {
		Runnable displayRefresh = new DeferredSetTextRunnable(document, text);
		Display.getDefault().asyncExec(displayRefresh);
	}
}
