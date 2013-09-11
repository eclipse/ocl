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

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ocl.examples.ui.wizards.WizardNewCompleteOCLFileCreation;
import org.eclipse.ui.IWorkbench;

/**
 * Wizard allowing the user to create a new OCL rule file.
 */
public class WizardNewCompleteOCLFileCreationForTest
		extends WizardNewCompleteOCLFileCreation {

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.page = new WizardCreationPageForPerformFinishTest(selection);
		addPage(page);
	}
}