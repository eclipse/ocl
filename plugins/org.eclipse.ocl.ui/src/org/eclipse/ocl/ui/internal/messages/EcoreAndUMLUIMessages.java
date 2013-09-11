/**
 * <copyright>
 *
 * Copyright (c) 2012,2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Obeo - OCL File creation wizard page strings externalization
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.ocl.ui.internal.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class EcoreAndUMLUIMessages
{	
	static {
		NLS.initializeMessages(EcoreAndUMLUIMessages.class.getName(), EcoreAndUMLUIMessages.class);
	}

	public static String PageTitle;

	public static String Preference_Severity_ByAlias;
	public static String Preference_Severity_ByAliasThenName;
	public static String Preference_Severity_ByName;
	
	public static String Preference_Severity_Error;
	public static String Preference_Severity_Info;
	public static String Preference_Severity_Ok;
	public static String Preference_Severity_Warning;	
	
	public static String LPG_UseTypeCaches;
	public static String LPG_OverloadAmbiguityIsInvalid;
	public static String LPG_AmbiguousAssociationEnds;
	public static String LPG_AnyLessIteratorReturnsInvalid;
	public static String LPG_ClosureIterator;
	public static String LPG_DynamicDispatch;
	public static String LPG_ConceptualOperationName;
	public static String LPG_DefinitionConstrainsFeature;
	public static String LPG_ElementNameQuoteEscape;
	public static String LPG_ImplicitRootClass;
	public static String LPG_InheritedFeatureContext;
	public static String LPG_LaxNullHandling;
	public static String LPG_PackageLookupStrategy;
	public static String LPG_StringCaseConversion;
	public static String LPG_StringSingleQuoteEscape;
	public static String LPG_SupportStaticFeatures;
	public static String LPG_UseBackslashEscapeProcessing;
	public static String LPG_UseCompareToOperation;
	public static String LPG_UseLongIntegers;
	public static String LPG_WarnOfXorOrAndPrecedenceChange;

	public static String WizardNewCompleteOCLFileCreationPage_newCompleteOCLFile;
	public static String WizardNewCompleteOCLFileCreationPage_completeOCLFile;
	public static String WizardNewCompleteOCLFileCreationPage_fileExtension;
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
	public static String WizardNewCompleteOCLFileCreationPage_OCLModelFileIcon;
}
