/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.ui.launching;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LaunchingUtils
{
	/**
	 * Called to prepare the Browse File System button, this implementation adds
	 * a selection listener that creates an appropriate {@link FileDialog}.
	 */
	public static void prepareBrowseFileSystemButton(@NonNull Button browseFileSystemButton, final @NonNull Text uriField, final boolean isSave) {
		// This method substantially copied from org.eclipse.emf.common.ui.dialogs.ResourceDialog.
		final Shell shell = browseFileSystemButton.getShell();
		browseFileSystemButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				FileDialog fileDialog = new FileDialog(shell, isSave ? SWT.SAVE : 0);
				fileDialog.open();

				String filterPath = fileDialog.getFilterPath();
				String fileName = fileDialog.getFileName();
				if (fileName != null) {
					uriField.setText(URI.createFileURI(filterPath + File.separator + fileName).toString());
				}
			}
		});
	}

	/**
	 * Called to prepare the Browse Workspace button, this implementation adds a
	 * selection listener that creates an appropriate
	 * {@link WorkspaceResourceDialog}.
	 */
	public static void prepareBrowseWorkspaceButton(@NonNull Button browseWorkspaceButton, final @NonNull Text uriField, final boolean isSave) {
		// This method substantially copied from org.eclipse.emf.common.ui.dialogs.ResourceDialog.
		final Shell shell = browseWorkspaceButton.getShell();
		browseWorkspaceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				IFile file = null;
				if (isSave) {
					String path = getContextPath();
					List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
					filters.add(new ViewerFilter(){
						@Override
						public boolean select(Viewer viewer, Object parentElement, Object element) {
							return true;
						}
					});
					file = WorkspaceResourceDialog.openNewFile(shell, null, null, path != null ? new Path(path) : null, filters);
				} else {
					IFile[] files = WorkspaceResourceDialog.openFileSelection(shell, null, null, false, getContextSelection(), null);
					if (files.length != 0) {
						file = files[0];
					}
				}
				if (file != null) {
					uriField.setText(URI.createPlatformResourceURI(file.getFullPath().toString(), true).toString());
				}
			}

			private String getContextPath() {
				String text = uriField.getText();
				try {
					URI context = text != null ? URI.createURI(text) : null;
//					return context != null && context.isPlatformResource() ? URI.createURI(".").resolve(context).path().substring(9) : null;
					return context != null && context.isPlatformResource() ? context.path().substring(9) : null;
				}
				catch (Exception e) {
					return null;
				}
			}

			private Object[] getContextSelection() {
				String path = getContextPath();
				if (path != null) {
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					IResource resource = root.findMember(path);
					if (resource != null && resource.isAccessible()) {
						return new Object[] { resource };
					}
				}
				return null;
			}
		});
	}
}
