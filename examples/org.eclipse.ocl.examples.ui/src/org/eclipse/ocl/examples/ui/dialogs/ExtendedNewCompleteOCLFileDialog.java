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
 *   		references WizardNewFileCreationPage, ResourceDialog and ExtendedLoadResourceDialog
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.ui.dialogs;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor.ExtendedLoadResourceAction.ExtendedLoadResourceDialog;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor.ExtendedLoadResourceAction.RegisteredPackageDialog;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor.ExtendedLoadResourceAction.TargetPlatformPackageDialog;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ocl.common.ui.internal.Activator;
import org.eclipse.ocl.examples.ui.internal.ripoffs.ResourceAndContainerGroup;
import org.eclipse.ocl.examples.ui.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

public class ExtendedNewCompleteOCLFileDialog
		extends ExtendedLoadResourceDialog {

	// constants
	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	private static final int SIZING_CONTAINER_GROUP_HEIGHT = 120;

	public static final String PREFIX = Activator.PLUGIN_ID + "."; //$NON-NLS-1$

	private static final String NEW_FILE_WIZARD_PAGE = PREFIX
		+ Messages.WizardNewCompleteOCLFileCreationPage_newFileWizardContextId; //$NON-NLS-1$

	// initial value stores
	private final String newFileExtension = Messages.WizardNewCompleteOCLFileCreationPage_fileExtension;

	private final String newFileName = Messages.WizardNewCompleteOCLFileCreationPage_fileName;

	private final String resourceType = Messages.WizardNewCompleteOCLFileCreationPage_file;

	private final String newFileLabel = Messages.WizardNewCompleteOCLFileCreationPage_oclFileNameLabel;

	// the current resource selection
	private IStructuredSelection selection;

	private Listener listener;

	// widgets
	private ResourceAndContainerGroup resourceGroup;

	// Useful data
	private URI metamodelURI;

	private String metamodelNsURI;

	private EPackage firstPackage = null;

	/**
	 * Creates an extended new complete OCL file creation dialog. If the initial
	 * resource selection contains exactly one container resource then it will
	 * be used as the default container resource.
	 * 
	 * @param parent
	 *            composite widget to parent the group
	 * @param domain
	 * @param selection
	 *            the current resource selection
	 * @param listener
	 *            object interested in changes to the group's fields value
	 */
	public ExtendedNewCompleteOCLFileDialog(Shell parent, EditingDomain domain,
			IStructuredSelection selection, Listener listener) {
		super(parent, domain);
		this.selection = selection;
		this.listener = listener;
	}

	public Composite createControlArea(Composite parent) {
		initializeDialogUnits(parent);
		// top level group
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout());
		topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
			| GridData.HORIZONTAL_ALIGN_FILL));
		topLevel.setFont(parent.getFont());
		PlatformUI.getWorkbench().getHelpSystem()
			.setHelp(topLevel, NEW_FILE_WIZARD_PAGE);

		// resource and container group
		resourceGroup = new ResourceAndContainerGroup(topLevel, listener,
			getNewFileLabel(), getResourceType(), false,
			SIZING_CONTAINER_GROUP_HEIGHT);
		resourceGroup.setAllowExistingResources(false);
		initialPopulateContainerNameField();
		resourceGroup.setResourceExtension(getNewFileExtension());
		resourceGroup.setResource(getNewFileName());

		// load meta model area
		createLoadMetamodelArea(topLevel);
		return topLevel;
	}

	/**
	 * Returns the extension to display in the file name specification visual
	 * component group.
	 * 
	 * @return the extension to display in the file name specification visual
	 *         component group
	 */
	public String getNewFileExtension() {
		return newFileExtension;
	}

	/**
	 * Returns the name to display in the file name specification visual
	 * component group.
	 * 
	 * @return the name to display in the file name specification visual
	 *         component group
	 */
	public String getNewFileName() {
		return newFileName;
	}

	/**
	 * Returns the label to display in the file name specification visual
	 * component group.
	 * 
	 * @return the label to display in the file name specification visual
	 *         component group
	 */
	public String getNewFileLabel() {
		return newFileLabel;
	}

	/**
	 * Returns the resource type : one word, in lowercase, to describe the
	 * resource to the user (file, folder, project)
	 * 
	 * @return the resource type to display to describe the resource to the user
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * @return the resource group
	 */
	public ResourceAndContainerGroup getGroup() {
		return resourceGroup;
	}

	/**
	 * @return The selected meta model NsURI
	 */
	public String getMetamodelNsURI() {
		return metamodelNsURI;
	}

	/**
	 * @param metamodelNsURI
	 *            The selected metamodel nsuri
	 */
	private void setMetamodelNsURI(String metamodelNsURI) {
		this.metamodelNsURI = metamodelNsURI;
		if (uriField != null) {
			uriField.setText(metamodelNsURI);
		}
	}

	/**
	 * @return The selected meta model uri
	 */
	public URI getURI() {
		return metamodelURI;
	}

	/**
	 * @param uri
	 *            The selected metamodel uri
	 */
	private void setURI(URI uri) {
		metamodelURI = uri;
	}

	/**
	 * @return The first package of the selected meta model URI
	 */
	public EPackage getFirstPackage() {
		return firstPackage;
	}

	/**
	 * @param firstPackage
	 *            The first package of the selected metamodel
	 */
	private void setFirstPackage(EPackage firstPackage) {
		this.firstPackage = firstPackage;
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
			.setText(Messages.WizardNewCompleteOCLFileCreationPage_resourceURI_label);

		uriField = new Text(metamodelURIGroup, SWT.BORDER);
		{
			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
			data.widthHint = SIZING_TEXT_FIELD_WIDTH;
			uriField.setLayoutData(data);
		}

		setInitialUriContent();

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
			.setText(Messages.WizardNewCompleteOCLFileCreationPage_browseRegisteredPackages_label);
		prepareBrowseRegisteredPackagesButton(browseRegisteredPackagesButton);
		{
			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
			browseRegisteredPackagesButton.setLayoutData(data);
		}

		Button browseTargetPlatformPackagesButton = new Button(
			modelButtonsComposite, SWT.PUSH);
		browseTargetPlatformPackagesButton
			.setText(Messages.WizardNewCompleteOCLFileCreationPage_browseTargetPlatformPackages_label);
		prepareBrowseTargetPlatformPackagesButton(browseTargetPlatformPackagesButton);
		{
			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
			browseTargetPlatformPackagesButton.setLayoutData(data);
		}

		Button browseFileSystemButton = new Button(modelButtonsComposite,
			SWT.PUSH);
		browseFileSystemButton
			.setText(Messages.WizardNewCompleteOCLFileCreationPage_browseFileSystem_label);
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
				.setText(Messages.WizardNewCompleteOCLFileCreationPage_browseWorkspace_label);
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

	@SuppressWarnings("rawtypes")
	private void setInitialUriContent() {
		if (selection != null && !selection.toList().isEmpty()) {
			Iterator it = selection.iterator();
			if (it.hasNext()) {
				Object next = it.next();
				if ((next instanceof IFile)) {
					IFile file = (IFile) next;
					URI uri = URI.createPlatformResourceURI(file.getFullPath()
						.toString(), true);
					uriField.setText(uri.toString());

					fillContentsFromFilePath(file.getFullPath().toString());
					setMetamodelNsURI(uri.toString());
				}
			}
		}
	}

	/**
	 * Sets the initial contents of the container name entry field, based upon
	 * either a previously-specified initial value or the ability to determine
	 * such a value.
	 */
	@SuppressWarnings("rawtypes")
	private void initialPopulateContainerNameField() {
		Iterator it = selection.iterator();
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

	public boolean isURIFieldValid() {
		return uriField != null && uriField.getText() != "";//$NON-NLS-1$
	}

	public Collection<EPackage> getResourcePackages(Resource resource) {
		return this.getAllPackages(resource);
	}

	/**
	 * Called to prepare the Browse File System button, this implementation adds
	 * a selection listener that creates an appropriate {@link FileDialog}.
	 */
	@Override
	protected void prepareBrowseFileSystemButton(Button browseFileSystemButton) {
		browseFileSystemButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				FileDialog fileDialog = new FileDialog(getShell(), 0);
				fileDialog.open();

				String filterPath = fileDialog.getFilterPath();
				String fileName = fileDialog.getFileName();
				if (fileName != null) {
					fillContentsFromFilePath(filterPath + File.separator
						+ fileName);
				}
			}
		});
	}

	/**
	 * Called to prepare the Browse Workspace button, this implementation adds a
	 * selection listener that creates an appropriate
	 * {@link WorkspaceResourceDialog}.
	 */
	@Override
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
					fillContentsFromWorkspacePath(file.getFullPath().toString());
				}
			}
		});
	}

	@Override
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
						fillContentsFromDevelopmentTimeVersion((String) nsURIs
							.get(0));
					}
				}
			});
	}

	@Override
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
							fillContentsFromDevelopmentTimeVersion((String) nsURIs
								.get(0));
						} else {
							fillContentsFromRunTimeVersion((String) nsURIs
								.get(0));
						}
					}
				}
			});
	}

	/**
	 * Fills the selected metamodel URI and the first package of the selected
	 * metamodel basing on parsing a fullpath string.
	 * 
	 * @param fullPath
	 */
	public void fillContentsFromFilePath(String fullPath) {
		setURI(URI.createFileURI(fullPath));

		Resource resource = loadResource(getURI());
		for (EPackage ePackage : getAllPackages(resource)) {
			setFirstPackage(ePackage);
			if (metamodelURI != null) {
				setMetamodelNsURI(metamodelURI.toString());
			}
			break;
		}
	}
	
	/**
	 * Fills the selected metamodel URI and the first package of the selected
	 * metamodel basing on parsing a fullpath string.
	 * 
	 * @param fullPath
	 */
	public void fillContentsFromWorkspacePath(String fullPath) {
		setURI(URI.createFileURI(fullPath));

		Resource resource = loadResource(getURI());
		for (EPackage ePackage : getAllPackages(resource)) {
			setFirstPackage(ePackage);
			URI uri = URI.createPlatformResourceURI(fullPath, true);
			setMetamodelNsURI(uri.toString());
			break;
		}
	}

	/**
	 * Fills the selected metamodel URI and the first package of the selected
	 * metamodel basing on parsing a list of selected URIs.
	 * 
	 * @param nsURIs
	 *            Platform-specific URIs
	 */
	public void fillContentsFromDevelopmentTimeVersion(String nsURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getURIConverter().getURIMap()
			.putAll(EcorePlugin.computePlatformURIMap(true));

		Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin
			.getEPackageNsURIToGenModelLocationMap(true);
		URI location = ePackageNsURItoGenModelLocationMap.get(nsURI);
		Resource resourceToResolve = resourceSet.getResource(location, true);
		EcoreUtil.resolveAll(resourceToResolve);

		EList<Resource> resources = resourceSet.getResources();

		for (Resource resource : resources) {
			for (EPackage ePackage : getAllPackages(resource)) {
				if (nsURI.equals(ePackage.getNsURI())) {
					setFirstPackage(ePackage);
					setURI(resource.getURI());
					setMetamodelNsURI(nsURI);
					break;
				}
			}
		}
	}

	/**
	 * Fills the selected metamodel URI and the first package of the selected
	 * metamodel basing on the selected nsURI.
	 * 
	 * @param nsURI
	 *            runtime-specific URI = nsURI
	 */
	public void fillContentsFromRunTimeVersion(String nsURI) {
		if (nsURI.startsWith("http")) { //$NON-NLS-1$
			String metamodelUri = getESuperPackage(nsURI);
			setFirstPackage(EPackage.Registry.INSTANCE
				.getEPackage(metamodelUri));
			setMetamodelNsURI(nsURI);
		}
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
}
