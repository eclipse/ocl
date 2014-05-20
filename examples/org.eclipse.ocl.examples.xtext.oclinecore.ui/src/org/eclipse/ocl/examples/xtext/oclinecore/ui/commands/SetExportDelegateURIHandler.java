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
package org.eclipse.ocl.examples.xtext.oclinecore.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.model.OCLinEcoreDocumentProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * Create a dynamic instance of an {@link EClass}.
 */
public class SetExportDelegateURIHandler extends AbstractHandler
{
	public Object execute(ExecutionEvent event) throws ExecutionException {
		event.getApplicationContext();
		String id = event.getCommand().getId();
		String uri;
		if (id.contains("LPG")) {
			uri = OCLConstants.OCL_DELEGATE_URI_LPG;
		}
		else if (id.contains("Pivot")) {
			uri = OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT;
		}
		else {
			uri = OCLConstants.OCL_DELEGATE_URI;
		}
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		if (window == null) {
			return null;
		}
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (!(editor instanceof XtextEditor)) {
			return null;
		}
		IDocumentProvider documentProvider = ((XtextEditor)editor).getDocumentProvider();
		if (!(documentProvider instanceof OCLinEcoreDocumentProvider)) {
			return null;
		}
		((OCLinEcoreDocumentProvider)documentProvider).setExportDelegateURI(editor.getEditorInput(), uri);
		return null;
	}
}
