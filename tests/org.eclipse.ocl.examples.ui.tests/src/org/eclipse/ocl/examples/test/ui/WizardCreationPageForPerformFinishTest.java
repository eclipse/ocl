/**
 * <copyright>
 *
 * Copyright (c) 2013 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.test.ui;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ocl.examples.ui.wizards.WizardNewCompleteOCLFileCreationPage;

/**
 * Wizard creation page to test performFinish of WizardNewCompleteOCLFileCreation
 * 
 */
public class WizardCreationPageForPerformFinishTest
		extends WizardNewCompleteOCLFileCreationPage {

	private IStructuredSelection selection;

	public WizardCreationPageForPerformFinishTest(IStructuredSelection selection) {
		super(selection); //$NON-NLS-1$
		this.selection = selection;
	}

	@Override
	protected IPath getNewFilePath() {
		if (selection != null && !selection.toList().isEmpty()) {
			@SuppressWarnings("rawtypes")
			Iterator it = selection.iterator();
			if (it.hasNext()) {
				Object next = it.next();
				if ((next instanceof IFile)) {
					IFile file = (IFile) next;
					return file.getParent().getFullPath()
						.append("/NewOCLFile.ocl");
				}
			}
		}
		return null;
	}
}