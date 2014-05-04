/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.debug.ui.launching;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ParameterRow extends Composite implements ModifyListener
{
	protected @NonNull MainTab mainTab;
	protected @NonNull Label name;
	protected @NonNull Text path;

	public ParameterRow(@NonNull MainTab mainTab, @NonNull Group group, int style, @NonNull String parameterName, @NonNull String parameterPath) {
		super(group, style);
		this.mainTab = mainTab;
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		GridLayout gridLayout = new GridLayout(4, false);
		gridLayout.marginWidth = 0;
		setLayout(gridLayout);
		
		name = new Label(this, SWT.NONE);
		name.setText(parameterName);
		
		path = new Text(this, SWT.BORDER);
		path.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		name.setText(parameterPath);
		
		Button browseWS = new Button(this, SWT.NONE);
		browseWS.setText("Browse Workspace...");
		Button browseFile = new Button(this, SWT.NONE);
		browseFile.setText("Browse File...");

		path.addModifyListener(this);
		boolean isSave = (style & SWT.SAVE) != 0;
		LaunchingUtils.prepareBrowseWorkspaceButton(browseWS, path, isSave);
		LaunchingUtils.prepareBrowseFileSystemButton(browseFile, path, isSave);
	}

	@Override
	public void modifyText(ModifyEvent e) {
		mainTab.updateLaunchConfigurationDialog();
	}
}
