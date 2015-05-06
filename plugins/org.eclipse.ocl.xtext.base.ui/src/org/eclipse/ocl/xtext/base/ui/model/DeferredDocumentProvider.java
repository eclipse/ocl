/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
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
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.ocl.xtext.base.ui.messages.BaseUIMessages;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * DeferredDocumentProvider defers the document provision. A please-wait page is displayed until
 * loading has completed on a worker thread.
 * <p>
 * setDocumentContent is intercepted and the sourceTExt is queued for assignment by a DeferredLoadingJob
 * a waiting message is displayed instead
 * once Editor.createPartControl() is complete the BaseEditor should invoke scheduleDeferredLoadingJob to assign the
 * true sourceText triggering what appears to be an edit with reconciliations, validations and updates.
 * <p>
 * To avoid the true sourceText making the editor dirty canSaveCocument is intercepted until sourceText
 * is assigned.
 */
public class DeferredDocumentProvider extends XtextDocumentProvider
{
	protected class DeferredLoadingJob extends Job implements IDocumentListener
	{
		protected final @NonNull XtextDocument document;
		protected final @NonNull String sourceText;

		public DeferredLoadingJob(@NonNull XtextDocument document, @NonNull String sourceText) {
			super("Deferred Editor Loading");
			this.document = document;
			this.sourceText = sourceText;
		}
		
		@Override
		public void documentAboutToBeChanged(DocumentEvent event) {}

		@Override
		public void documentChanged(DocumentEvent event) {
			document.removeDocumentListener(this);
			fireElementDirtyStateChanged(document2element.get(document), false);
		}
		
		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			Boolean didIt = document.modify(new DeferredSetText(document, sourceText));
			if (didIt != Boolean.TRUE) {
				schedule(250);
			}
			return Status.OK_STATUS;
		}
	}
	
	public class DeferredSetText implements IUnitOfWork<Boolean, XtextResource>
	{
		protected final @NonNull XtextDocument document;
		protected final @NonNull String sourceText;

		public DeferredSetText(@NonNull XtextDocument document, @NonNull String sourceText) {
			this.document = document;
			this.sourceText = sourceText;
		}

		@Override
		public Boolean exec(XtextResource state) throws Exception {
			if (state == null) {
				return Boolean.FALSE;
			}
			setDocumentText(document, sourceText);
			fireElementDirtyStateChanged(document2element.get(document), false);
			return Boolean.TRUE;
		}
	}

	private Map<IDocument, IEditorInput> document2element = new HashMap<IDocument, IEditorInput>();
	private Map<IDocument, DeferredLoadingJob> document2listener = new HashMap<IDocument, DeferredLoadingJob>();

	@Override
	public boolean canSaveDocument(Object element) {
		IDocument document = getDocument(element);
		if (document2listener.containsKey(document)) {
			return false;
		}
		return super.canSaveDocument(element);
	}

	protected @NonNull String getPleaseWaitText() {
		return "/* " + BaseUIMessages.DeferredDocumentProvider_PleaseWait + " */";
	}

	public void scheduleDeferredLoadingJob(IEditorInput input) {
		IDocument document = getDocument(input);
		DeferredLoadingJob deferredLoadingJob = document2listener.get(document);
		if (deferredLoadingJob != null) {
			deferredLoadingJob.schedule(100);		// Give XtextReconciler, ValidationJob a chance to finish
		}
	}

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		document2element.put(document, editorInput);
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
			@SuppressWarnings("null")@NonNull String string = s.toString();
			DeferredLoadingJob deferredLoadingJob = new DeferredLoadingJob((XtextDocument) document, string);
			document2listener.put(document, deferredLoadingJob);
			document.addDocumentListener(deferredLoadingJob);
			String loading = getPleaseWaitText();
			InputStream is = new ByteArrayInputStream(loading.getBytes());
			super.setDocumentContent(document, is, encoding);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Define the content of document as text. This is invoked by the Loading Job and queues
	 * an update on the main UI thread. It may be overloaded to change the text from read text
	 * to the display text.
	 * @throws CoreException 
	 */
	protected void setDocumentText(final @NonNull IDocument document, final @NonNull String text) throws CoreException {
		Runnable displayRefresh = new Runnable()
		{
			@Override
			public void run() {
				document.set(text);
				ElementInfo elementInfo = getElementInfo(document2element.get(document));
				elementInfo.fCanBeSaved = false;
				document2element.remove(document);
				document2listener.remove(document);
			}
		};
		Display.getDefault().asyncExec(displayRefresh);
	}
}
