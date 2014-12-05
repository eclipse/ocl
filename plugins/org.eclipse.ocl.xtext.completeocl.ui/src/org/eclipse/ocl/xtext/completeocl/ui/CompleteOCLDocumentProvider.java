/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

/**
 * CompleteOCLDocumentProvider adds Annotation support for XtextReadonlyEditorInputs. 
 */
public class CompleteOCLDocumentProvider extends XtextDocumentProvider
{
	@Override	// BUG 434948#5 add support for annotated ranges so that debug single stepping shows current element as a range
	protected IAnnotationModel createAnnotationModel(Object element) throws CoreException {
		IAnnotationModel annotationModel = super.createAnnotationModel(element);
		if ((annotationModel == null) && (element instanceof IStorageEditorInput)) {
			return new AnnotationModel();
		}
		return annotationModel;
	}
}
