/*******************************************************************************
 * Copyright (c) 2000, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Alexander Fedorov <Alexander.Fedorov@borland.com>
 *     		- Bug 172000 [Wizards] WizardNewFileCreationPage should support overwriting existing resources
 *     Obeo - Adapt the implementation for New Complete OCL File creation
 */
package org.eclipse.ocl.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ocl.common.ui.internal.Activator;
import org.eclipse.ocl.ui.internal.messages.EcoreAndUMLUIMessages;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.undo.CreateFileOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.eclipse.ui.internal.ide.IIDEHelpContextIds;
import org.eclipse.ui.internal.ide.misc.ResourceAndContainerGroup;

/**
 * Wizard page allowing creation of OCL rule files in the workspace.
 */
@SuppressWarnings("restriction")
public class WizardNewCompleteOCLFileCreationPage
		extends WizardPage
		implements Listener {

	// constants
	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	private static final int SIZING_CONTAINER_GROUP_HEIGHT = 120;

	// the current resource selection
	private IStructuredSelection currentSelection;

	// cache of newly-created file
	private IFile newFile;

	// widgets
	private ResourceAndContainerGroup resourceGroup;

	// initial value stores
	private String initialFileExtension;

	// Load Resource Area buttons
	private Text uriField;

	// first package of the selected meta model URI
	private EPackage firstPackage = null;

	/**
	 * Creates a new complete OCL file creation wizard page. If the initial
	 * resource selection contains exactly one container resource then it will
	 * be used as the default container resource.
	 * 
	 * @param selection
	 *            the current resource selection
	 */
	public WizardNewCompleteOCLFileCreationPage(IStructuredSelection selection) {
		super("page"); //$NON-NLS-1$
		setPageComplete(false);
		this.initialFileExtension = EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_fileExtension;
		setTitle(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_completeOCLFile);
		setDescription(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_createCompleteOCLFileBasedOnModel);
		this.currentSelection = selection;
	}

	/**
	 * Creates a file resource handle for the file with the given workspace
	 * path. This method does not create the file resource; this is the
	 * responsibility of <code>createNewFile</code>.
	 * 
	 * @param filePath
	 *            the path of the file resource to create a handle for
	 * @return the new complete OCL file resource handle
	 * @see #createFile
	 */
	protected IFile createFileHandle(IPath filePath) {
		return Activator.getPluginWorkspace().getRoot().getFile(filePath);
	}

	/**
	 * Creates a new complete OCL file resource in the selected container and
	 * with the selected name. Creates any missing resource containers along the
	 * path; does nothing if the container resources already exist.
	 * <p>
	 * In normal usage, this method is invoked after the user has pressed Finish
	 * on the wizard; the enablement of the Finish button implies that all
	 * controls on on this page currently contain valid values.
	 * </p>
	 * <p>
	 * Note that this page caches the new complete OCL file once it has been
	 * successfully created; subsequent invocations of this method will answer
	 * the same file resource without attempting to create it again.
	 * </p>
	 * <p>
	 * This method should be called within a workspace modify operation since it
	 * creates resources.
	 * </p>
	 * 
	 * @return the created file resource, or <code>null</code> if the file was
	 *         not created
	 */
	public IFile createNewFile() {
		if (newFile != null) {
			return newFile;
		}

		// create the new complete OCL file and cache it if successful
		final IPath containerPath = resourceGroup.getContainerFullPath();
		IPath newFilePath = containerPath.append(resourceGroup.getResource());
		final IFile newFileHandle = createFileHandle(newFilePath);
		final InputStream initialContents = getInitialContents();

		IRunnableWithProgress op = new IRunnableWithProgress() {

			public void run(IProgressMonitor monitor) {
				CreateFileOperation op = new CreateFileOperation(
					newFileHandle,
					null,
					initialContents,
					EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_newCompleteOCLFile);
				try {
					op.execute(monitor,
						WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
				} catch (final ExecutionException e) {
					getContainer().getShell().getDisplay()
						.syncExec(new Runnable() {

							public void run() {
								if (e.getCause() instanceof CoreException) {
									ErrorDialog
										.openError(
											getContainer().getShell(),
											EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_errorTitle,
											null, // no special
											// message
											((CoreException) e.getCause())
												.getStatus());
								} else {
									Activator.log(getClass(),
										"createNewFile()", e.getCause()); //$NON-NLS-1$
									MessageDialog
										.openError(
											getContainer().getShell(),
											EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_internalErrorTitle,
											NLS.bind(
												EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_internalErrorTitle,
												e.getCause().getMessage()));
								}
							}
						});
				}
			}
		};
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return null;
		} catch (InvocationTargetException e) {
			// Execution Exceptions are handled above but we may still get
			// unexpected runtime errors.
			Activator.log(getClass(),
				"createNewFile()", e.getTargetException()); //$NON-NLS-1$
			MessageDialog
				.open(
					MessageDialog.ERROR,
					getContainer().getShell(),
					EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_internalErrorTitle,
					NLS.bind(
						EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_internalErrorMessage,
						e.getTargetException().getMessage()), SWT.SHEET);

			return null;
		}

		newFile = newFileHandle;

		return newFile;
	}

	/**
	 * (non-Javadoc) Method declared on IDialogPage.
	 */
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		// top level group
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout());
		topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
			| GridData.HORIZONTAL_ALIGN_FILL));
		topLevel.setFont(parent.getFont());
		PlatformUI.getWorkbench().getHelpSystem()
			.setHelp(topLevel, IIDEHelpContextIds.NEW_FILE_WIZARD_PAGE);

		// resource and container group
		resourceGroup = new ResourceAndContainerGroup(
			topLevel,
			this,
			getNewFileLabel(),
			EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_oclFileNameLabel,
			false, SIZING_CONTAINER_GROUP_HEIGHT);
		resourceGroup.setAllowExistingResources(false);
		initialPopulateContainerNameField();
		if (initialFileExtension != null) {
			resourceGroup.setResourceExtension(initialFileExtension);
		}

		// load meta model area
		createLoadMetamodelArea(topLevel);

		validatePage();
		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(topLevel);
	}

	private void createLoadMetamodelArea(Composite parent) {
		Label separatorLabel = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		{
			GridData data = new GridData(GridData.FILL_BOTH);
			separatorLabel.setLayoutData(data);
		}

		// meta model uri group
		Composite metamodelURIGroup = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			layout.marginWidth = 0;
			metamodelURIGroup.setLayout(layout);
			metamodelURIGroup.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
			metamodelURIGroup.setFont(parent.getFont());
		}

		Label metamodelURILabel = new Label(metamodelURIGroup, SWT.NONE);
		metamodelURILabel
			.setText(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_resourceURI_label);

		uriField = new Text(metamodelURIGroup, SWT.BORDER);
		{
			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
			data.widthHint = SIZING_TEXT_FIELD_WIDTH;
			uriField.setLayoutData(data);
		}

		Composite modelButtonsComposite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 4;
			layout.marginWidth = 0;
			modelButtonsComposite.setLayout(layout);
			modelButtonsComposite.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
			modelButtonsComposite.setFont(parent.getFont());
		}

		Button browseRegisteredPackagesButton = new Button(
			modelButtonsComposite, SWT.PUSH);
		browseRegisteredPackagesButton
			.setText(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_browseRegisteredPackages_label);
		prepareBrowseRegisteredPackagesButton(browseRegisteredPackagesButton);
		{
			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
			browseRegisteredPackagesButton.setLayoutData(data);
		}

		Button browseTargetPlatformPackagesButton = new Button(
			modelButtonsComposite, SWT.PUSH);
		browseTargetPlatformPackagesButton
			.setText(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_browseTargetPlatformPackages_label);
		prepareBrowseTargetPlatformPackagesButton(browseTargetPlatformPackagesButton);
		{
			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
			browseTargetPlatformPackagesButton.setLayoutData(data);
		}

		Button browseFileSystemButton = new Button(modelButtonsComposite,
			SWT.PUSH);
		browseFileSystemButton
			.setText(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_browseFileSystem_label);
		prepareBrowseFileSystemButton(browseFileSystemButton);

		if (EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE) {
			Button browseWorkspaceButton = new Button(modelButtonsComposite,
				SWT.PUSH);
			{
				GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
					| GridData.GRAB_HORIZONTAL);
				browseWorkspaceButton.setLayoutData(data);
			}
			{
				GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
					| GridData.GRAB_HORIZONTAL);
				browseFileSystemButton.setLayoutData(data);
			}
			browseWorkspaceButton
				.setText(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_browseWorkspace_label);
			prepareBrowseWorkspaceButton(browseWorkspaceButton);
		} else {
			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
			browseFileSystemButton.setLayoutData(data);
		}

		separatorLabel = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		{
			GridData data = new GridData(GridData.FILL_BOTH);
			separatorLabel.setLayoutData(data);
		}
	}

	/**
	 * Called to prepare the Browse File System button, this implementation adds
	 * a selection listener that creates an appropriate {@link FileDialog}.
	 */
	protected void prepareBrowseFileSystemButton(Button browseFileSystemButton) {
		browseFileSystemButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				FileDialog fileDialog = new FileDialog(getShell(), 0);
				fileDialog.open();

				String filterPath = fileDialog.getFilterPath();
				String fileName = fileDialog.getFileName();
				if (fileName != null) {
					URI uri = URI.createFileURI(filterPath + File.separator
						+ fileName);
					uriField.setText(uri.toString());

					firstPackage = null;
					Resource resource = loadResource(uri);
					for (EPackage ePackage : getAllPackages(resource)) {
						if (firstPackage == null) {
							firstPackage = ePackage;
						}
					}
				}
			}
		});
	}

	/**
	 * Called to prepare the Browse Workspace button, this implementation adds a
	 * selection listener that creates an appropriate
	 * {@link WorkspaceResourceDialog}.
	 */
	protected void prepareBrowseWorkspaceButton(Button browseWorkspaceButton) {
		browseWorkspaceButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				IFile file = null;

				IFile[] files = WorkspaceResourceDialog.openFileSelection(
					getShell(), null, null, false, null, null);
				if (files.length != 0) {
					file = files[0];
				}

				if (file != null) {
					URI uri = URI.createPlatformResourceURI(file.getFullPath()
						.toString(), true);
					uriField.setText(uri.toString());

					firstPackage = null;
					Resource resource = loadResource(uri);
					for (EPackage ePackage : getAllPackages(resource)) {
						if (firstPackage == null) {
							firstPackage = ePackage;
						}
					}
				}
			}
		});
	}

	protected void prepareBrowseTargetPlatformPackagesButton(
			Button browseTargetPlatformPackagesButton) {
		browseTargetPlatformPackagesButton
			.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent event) {
					TargetPlatformPackageDialog classpathPackageDialog = new TargetPlatformPackageDialog(
						getShell());
					classpathPackageDialog.open();
					Object[] result = classpathPackageDialog.getResult();
					if (result != null) {
						List<?> nsURIs = Arrays.asList(result);
						ResourceSet resourceSet = new ResourceSetImpl();
						resourceSet.getURIConverter().getURIMap()
							.putAll(EcorePlugin.computePlatformURIMap(true));

						StringBuffer uris = new StringBuffer();
						Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin
							.getEPackageNsURIToGenModelLocationMap(true);
						for (int i = 0, length = result.length; i < length; i++) {
							URI location = ePackageNsURItoGenModelLocationMap
								.get(result[i]);
							Resource resource = resourceSet.getResource(
								location, true);
							EcoreUtil.resolveAll(resource);
						}

						EList<Resource> resources = resourceSet.getResources();

						firstPackage = null;
						for (Resource resource : resources) {
							for (EPackage ePackage : getAllPackages(resource)) {
								if (nsURIs.contains(ePackage.getNsURI())) {
									if (firstPackage == null) {
										firstPackage = ePackage;
									}
									uris.append(resource.getURI());
									uris.append("  "); //$NON-NLS-1$
									break;
								}
							}
						}
						uriField.setText(uris.toString().trim());
					}
				}
			});
	}

	protected void prepareBrowseRegisteredPackagesButton(
			Button browseRegisteredPackagesButton) {
		browseRegisteredPackagesButton
			.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent event) {
					RegisteredPackageDialog registeredPackageDialog = new RegisteredPackageDialog(
						getShell());
					registeredPackageDialog.open();
					Object[] result = registeredPackageDialog.getResult();
					if (result != null) {
						List<?> nsURIs = Arrays.asList(result);
						if (registeredPackageDialog.isDevelopmentTimeVersion()) {
							ResourceSet resourceSet = new ResourceSetImpl();
							resourceSet
								.getURIConverter()
								.getURIMap()
								.putAll(
									EcorePlugin.computePlatformURIMap(false));

							StringBuffer uris = new StringBuffer();
							Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin
								.getEPackageNsURIToGenModelLocationMap(false);
							for (int i = 0, length = result.length; i < length; i++) {
								URI location = ePackageNsURItoGenModelLocationMap
									.get(result[i]);
								Resource resource = resourceSet.getResource(
									location, true);
								EcoreUtil.resolveAll(resource);
							}

							EList<Resource> resources = resourceSet
								.getResources();

							firstPackage = null;
							for (Resource resource : resources) {
								for (EPackage ePackage : getAllPackages(resource)) {
									if (nsURIs.contains(ePackage.getNsURI())) {
										if (firstPackage == null) {
											firstPackage = ePackage;
										}
										uris.append(resource.getURI());
										uris.append("  "); //$NON-NLS-1$
										break;
									}
								}
							}
							uriField.setText(uris.toString().trim());
						} else {
							StringBuffer uris = new StringBuffer();
							for (int i = 0, length = result.length; i < length; i++) {
								uris.append(result[i]);
								uris.append("  "); //$NON-NLS-1$
							}
							uriField.setText(uris.toString().trim());

							if (uriField.getText().startsWith("http")) { //$NON-NLS-1$
								String metamodelUri = getESuperPackage(uriField
									.getText());
								firstPackage = EPackage.Registry.INSTANCE
									.getEPackage(metamodelUri);
							}
						}
					}
				}
			});
	}

	protected Collection<EPackage> getAllPackages(Resource resource) {
		List<EPackage> result = new ArrayList<EPackage>();
		for (TreeIterator<?> j = new EcoreUtil.ContentTreeIterator<Object>(
			resource.getContents()) {

			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<? extends EObject> getEObjectChildren(
					EObject eObject) {
				return eObject instanceof EPackage
					? ((EPackage) eObject).getESubpackages().iterator()
					: Collections.<EObject> emptyList().iterator();
			}
		}; j.hasNext();) {
			Object content = j.next();
			if (content instanceof EPackage) {
				result.add((EPackage) content);
			}
		}
		return result;
	}

	public static class TargetPlatformPackageDialog
			extends ElementListSelectionDialog {

		public TargetPlatformPackageDialog(Shell parent) {
			super(parent, new LabelProvider() {

				@Override
				public Image getImage(Object element) {
					return ExtendedImageRegistry.getInstance().getImage(
						Activator.getImageDescriptor("icons/EPackage")); //$NON-NLS-1$
				}
			});

			setMultipleSelection(false);
			setMessage(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_selectRegisteredPackageURI);
			setFilter("*"); //$NON-NLS-1$
			setTitle(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_packageSelection_label);
		}

		protected void updateElements() {
			Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin
				.getEPackageNsURIToGenModelLocationMap(true);
			Object[] result = ePackageNsURItoGenModelLocationMap.keySet()
				.toArray(new Object[ePackageNsURItoGenModelLocationMap.size()]);
			Arrays.sort(result);
			setListElements(result);
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite result = (Composite) super.createDialogArea(parent);
			updateElements();
			return result;
		}
	}

	public static class RegisteredPackageDialog
			extends ElementListSelectionDialog {

		protected boolean isDevelopmentTimeVersion = true;

		public RegisteredPackageDialog(Shell parent) {
			super(parent, new LabelProvider() {

				@Override
				public Image getImage(Object element) {
					return ExtendedImageRegistry.getInstance().getImage(
						Activator.getImageDescriptor("icons/EPackage")); //$NON-NLS-1$
				}
			});

			setMultipleSelection(false);
			setMessage(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_selectRegisteredPackageURI);
			setFilter("*"); //$NON-NLS-1$
			setTitle(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_packageSelection_label);
		}

		public boolean isDevelopmentTimeVersion() {
			return isDevelopmentTimeVersion;
		}

		protected void updateElements() {
			if (isDevelopmentTimeVersion) {
				Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin
					.getEPackageNsURIToGenModelLocationMap(false);
				Object[] result = ePackageNsURItoGenModelLocationMap.keySet()
					.toArray(
						new Object[ePackageNsURItoGenModelLocationMap.size()]);
				Arrays.sort(result);
				setListElements(result);
			} else {
				Object[] result = EPackage.Registry.INSTANCE.keySet().toArray(
					new Object[EPackage.Registry.INSTANCE.size()]);
				Arrays.sort(result);
				setListElements(result);
			}
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite result = (Composite) super.createDialogArea(parent);
			Composite buttonGroup = new Composite(result, SWT.NONE);
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			buttonGroup.setLayout(layout);
			final Button developmentTimeVersionButton = new Button(buttonGroup,
				SWT.RADIO);
			developmentTimeVersionButton
				.addSelectionListener(new SelectionAdapter() {

					@Override
					public void widgetSelected(SelectionEvent event) {
						isDevelopmentTimeVersion = developmentTimeVersionButton
							.getSelection();
						updateElements();
					}
				});
			developmentTimeVersionButton
				.setText(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_developmentTimeVersion_label);
			Button runtimeTimeVersionButton = new Button(buttonGroup, SWT.RADIO);
			runtimeTimeVersionButton
				.setText(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_runtimeVersion_label);
			developmentTimeVersionButton.setSelection(true);

			updateElements();

			return result;
		}
	}

	/**
	 * Returns the current full path of the containing resource as entered or
	 * selected by the user, or its anticipated initial value.
	 * 
	 * @return the container's full path, anticipated initial value, or
	 *         <code>null</code> if no path is known
	 */
	public IPath getContainerFullPath() {
		return resourceGroup.getContainerFullPath();
	}

	/**
	 * Returns the current file name as entered by the user, or its anticipated
	 * initial value. <br>
	 * <br>
	 * The current file name will include the file extension if the
	 * preconditions are met.
	 * 
	 * @see WizardNewFileCreationPage#setFileExtension(String)
	 * 
	 * @return the file name, its anticipated initial value, or
	 *         <code>null</code> if no file name is known
	 */
	public String getFileName() {
		return resourceGroup.getResource();
	}

	/**
	 * Returns a stream containing the initial contents to be given to new
	 * complete OCL file resource instances.
	 * 
	 * @return initial contents to be given to new complete OCL file resource
	 *         instances
	 */
	protected InputStream getInitialContents() {
		if (uriField != null && !uriField.getText().isEmpty()) {
			String line = new String("import '"); //$NON-NLS-1$
			line = line.concat(uriField.getText()).concat("'\n"); //$NON-NLS-1$

			String firstPackageName = "undefined_root_package_name"; //$NON-NLS-1$
			if (firstPackage != null) {
				firstPackageName = firstPackage.getName();
			}

			line = line + "\npackage " + firstPackageName + "\n\n"; //$NON-NLS-1$ //$NON-NLS-2$
			line = line + "\tcontext type\n"; //$NON-NLS-1$
			line = line + "\tinv InvariantName: true\n\n"; //$NON-NLS-1$
			line = line + "endpackage\n"; //$NON-NLS-1$
			return new ByteArrayInputStream(line.getBytes());
		}
		return null;
	}

	/**
	 * Returns the label to display in the file name specification visual
	 * component group.
	 * 
	 * @return the label to display in the file name specification visual
	 *         component group
	 */
	protected String getNewFileLabel() {
		return EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_oclFileNameLabel;
	}

	/**
	 * The <code>WizardNewFileCreationPage</code> implementation of this
	 * <code>Listener</code> method handles all events and enablements for
	 * controls on this page. Subclasses may extend.
	 */
	public void handleEvent(Event event) {
		setPageComplete(validatePage());
	}

	/**
	 * Sets the initial contents of the container name entry field, based upon
	 * either a previously-specified initial value or the ability to determine
	 * such a value.
	 */
	@SuppressWarnings("rawtypes")
	protected void initialPopulateContainerNameField() {
		Iterator it = currentSelection.iterator();
		if (it.hasNext()) {
			Object object = it.next();
			IResource selectedResource = null;
			if (object instanceof IResource) {
				selectedResource = (IResource) object;
			} else if (object instanceof IAdaptable) {
				selectedResource = (IResource) ((IAdaptable) object)
					.getAdapter(IResource.class);
			}
			if (selectedResource != null) {
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}
				if (selectedResource.isAccessible()) {
					resourceGroup.setContainerFullPath(selectedResource
						.getFullPath());
				}
			}
		}
	}

	/**
	 * Returns whether this page's controls currently all contain valid values.
	 * 
	 * @return <code>true</code> if all controls are valid, and
	 *         <code>false</code> if at least one is invalid
	 */
	protected boolean validatePage() {
		boolean valid = true;
		setMessage(EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_createCompleteOCLFileBasedOnModel);
		setErrorMessage(null);

		if (!resourceGroup.areAllValuesValid()) {
			// if blank name then fail silently
			if (resourceGroup.getProblemType() == ResourceAndContainerGroup.PROBLEM_RESOURCE_EMPTY
				|| resourceGroup.getProblemType() == ResourceAndContainerGroup.PROBLEM_CONTAINER_EMPTY) {
				setMessage(resourceGroup.getProblemMessage());
				setErrorMessage(null);
			} else {
				setErrorMessage(resourceGroup.getProblemMessage());
			}
			valid = false;
		}

		String resourceName = resourceGroup.getResource();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus result = workspace.validateName(resourceName, IResource.FILE);
		if (!result.isOK()) {
			setErrorMessage(result.getMessage());
			return false;
		}

		if (resourceGroup.getAllowExistingResources()) {
			String problemMessage = NLS
				.bind(
					EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_nameExists,
					getFileName());
			IPath resourcePath = getContainerFullPath().append(getFileName());
			if (workspace.getRoot().getFolder(resourcePath).exists()) {
				setErrorMessage(problemMessage);
				valid = false;
			}
			if (workspace.getRoot().getFile(resourcePath).exists()) {
				setMessage(problemMessage, IMessageProvider.WARNING);
			}
		}

		if (isFilteredByParent()) {
			setMessage(
				EcoreAndUMLUIMessages.WizardNewCompleteOCLFileCreationPage_resourceWillBeFilteredWarning,
				IMessageProvider.ERROR);
			valid = false;
		}
		return valid;
	}

	/**
	 * Loads an EMF resource and returns it.
	 * 
	 * @param uri
	 *            The resource uri to load given as a {@link URI}
	 * @return a resource
	 */
	private Resource loadResource(URI uri) {
		ResourceSet set = new ResourceSetImpl();
		set.getLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
		set.getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION,
			true);
		set.setPackageRegistry(new EPackageRegistryImpl(
			EPackage.Registry.INSTANCE));
		return set.getResource(uri, true);
	}

	/**
	 * Gets the highest package from a meta model
	 * 
	 * @param mmUri
	 *            the meta model uri
	 * @return NsURI from the container package at the highest level
	 */
	private String getESuperPackage(String mmUri) {

		EPackage packageTemp = EPackage.Registry.INSTANCE.getEPackage(mmUri);
		// Calling register on superPackage
		if (packageTemp != null) {
			EPackage eSuperPackage = packageTemp.getESuperPackage();
			if (eSuperPackage != null) {
				while (eSuperPackage != null
					&& eSuperPackage.getESuperPackage() != null) {
					eSuperPackage = eSuperPackage.getESuperPackage();
				}
				return eSuperPackage.getNsURI();
			} else {
				return packageTemp.getNsURI();
			}
		}
		return ""; //$NON-NLS-1$
	}

	private boolean isFilteredByParent() {
		IPath containerPath = resourceGroup.getContainerFullPath();
		if (containerPath == null)
			return false;
		String resourceName = resourceGroup.getResource();
		if (resourceName == null)
			return false;
		if (resourceName.length() > 0) {
			IPath newFolderPath = containerPath.append(resourceName);
			IFile newFileHandle = createFileHandle(newFolderPath);
			IWorkspace workspace = newFileHandle.getWorkspace();
			return !workspace.validateFiltered(newFileHandle).isOK();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			resourceGroup.setFocus();
		}
	}
}