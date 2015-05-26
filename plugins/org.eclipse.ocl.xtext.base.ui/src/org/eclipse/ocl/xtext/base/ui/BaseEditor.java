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
package org.eclipse.ocl.xtext.base.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ocl.xtext.base.ui.model.DeferredDocumentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;

public class BaseEditor extends XtextEditor
{
	public BaseEditor() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		scheduleDeferredSetTextJob();			// do SetText after the editor has been created
	}

	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		ISourceViewer sourceViewer = getSourceViewer();
		super.doSetInput(input);
		if ((input != null) && (sourceViewer != null)) {
			scheduleDeferredSetTextJob();		// do SetText as editor is re-used
		}
	}

	@SuppressWarnings("null")
	public @NonNull TextViewer getTextViewer() {
		return (TextViewer) getSourceViewer();
	}

	protected void scheduleDeferredSetTextJob() {
		IDocumentProvider documentProvider = getDocumentProvider();
		if (documentProvider instanceof DeferredDocumentProvider) {
			((DeferredDocumentProvider)documentProvider).scheduleDeferredSetTextJob(this);
		}
	}
}
