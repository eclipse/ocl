/**
 * <copyright>
 *
 * Copyright (c) 2013 Obeo and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - Initial API and implementation
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.ocl.examples.ui.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class Messages
{	
	static {
		NLS.initializeMessages(Messages.class.getName(), Messages.class);
	}

	public static String WizardNewCompleteOCLFileCreationPage_newCompleteOCLFile;
	public static String WizardNewCompleteOCLFileCreationPage_completeOCLFile;
	public static String WizardNewCompleteOCLFileCreationPage_fileExtension;
	public static String WizardNewCompleteOCLFileCreationPage_fileName;
	public static String WizardNewCompleteOCLFileCreationPage_file;
	public static String WizardNewCompleteOCLFileCreationPage_createCompleteOCLFileBasedOnModel;
	public static String WizardNewCompleteOCLFileCreationPage_oclFileNameLabel;
	public static String WizardNewCompleteOCLFileCreationPage_errorTitle;
	public static String WizardNewCompleteOCLFileCreationPage_internalErrorTitle;
	public static String WizardNewCompleteOCLFileCreationPage_internalErrorMessage;
	public static String WizardNewCompleteOCLFileCreationPage_nameExists;
	public static String WizardNewCompleteOCLFileCreationPage_resourceWillBeFilteredWarning;
	public static String WizardNewCompleteOCLFileCreationPage_browseRegisteredPackages_label;
	public static String WizardNewCompleteOCLFileCreationPage_browseTargetPlatformPackages_label;
	public static String WizardNewCompleteOCLFileCreationPage_selectRegisteredPackageURI;
	public static String WizardNewCompleteOCLFileCreationPage_packageSelection_label;
	public static String WizardNewCompleteOCLFileCreationPage_developmentTimeVersion_label;
	public static String WizardNewCompleteOCLFileCreationPage_runtimeVersion_label;
	public static String WizardNewCompleteOCLFileCreationPage_runtimePackageDetail_message;
	public static String WizardNewCompleteOCLFileCreationPage_information_title;
	public static String WizardNewCompleteOCLFileCreationPage_runtimePackageHeader_message;
	public static String WizardNewCompleteOCLFileCreationPage_resourceURI_label;
	public static String WizardNewCompleteOCLFileCreationPage_resourceURIs_label;
	public static String WizardNewCompleteOCLFileCreationPage_browseFileSystem_label;
	public static String WizardNewCompleteOCLFileCreationPage_browseWorkspace_label;
	
	public static String WizardNewCompleteOCLFileCreationPage_newFileWizardContextId;

	// source IDEWorkbenchMessages
	public static String WizardNewCompleteOCLFileCreationPage_ResourceGroup_resource;
	public static String WizardNewCompleteOCLFileCreationPage_ResourceGroup_nameExists;
	public static String WizardNewCompleteOCLFileCreationPage_ResourceGroup_folderEmpty;
	public static String WizardNewCompleteOCLFileCreationPage_ResourceGroup_noProject;
	public static String WizardNewCompleteOCLFileCreationPage_ResourceGroup_emptyName;
	public static String WizardNewCompleteOCLFileCreationPage_ResourceGroup_invalidFilename;
	public static String WizardNewCompleteOCLFileCreationPage_ResourceGroup_pathOccupied;
	
	public static String WizardNewCompleteOCLFileCreationPage_ContainerGroup_message;
	public static String WizardNewCompleteOCLFileCreationPage_ContainerGroup_selectFolder;
}