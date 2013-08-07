package org.eclipse.ocl.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ocl.ui.common.OCLUIPlugin;
import org.eclipse.ocl.ui.wizards.utils.Messages;
import org.eclipse.ocl.ui.wizards.utils.MetamodelUtils;
import org.eclipse.ocl.ui.wizards.utils.OCLResourceUtil;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * Wizard allowing the user to create a new OCL rule file.
 * 
 * @author mrostren
 * 
 */
public class NewCompleteOCLFileWizard
		extends Wizard
		implements INewWizard {

	/** The only page contributing to the wizard */
	private NewCompleteOCLFileWizardPage page;

	/**
	 * Constructor
	 */
	public NewCompleteOCLFileWizard() {
		super();
		setWindowTitle(Messages.getString("NewCompleteOCLFileWizardPage.0")); //$NON-NLS-1$
		setDefaultPageImageDescriptor(OCLUIPlugin
			.getImageDescriptor("icons/OCLModelFile.gif")); //$NON-NLS-1$
	}

	/**
	 * Performs finish action of this wizard.
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final IFile file = root.getFile(page.getLocation().append(
			page.getFileName()));

		try {
			setInitialContent(file);
			openCreatedFile(file);
		} catch (PartInitException e) {
			OCLUIPlugin.log(e);
			return false;
		} catch (CoreException e) {
			OCLUIPlugin.log(e);
			return false;
		} catch (IOException ioe) {
			OCLUIPlugin.log(ioe);
			return false;
		}

		return true;
	}

	/**
	 * Opens file in the Editor
	 * @param the file to open
	 * @throws PartInitException
	 */
	private void openCreatedFile(IFile file)
			throws PartInitException {
		IWorkbenchPage currentPage = PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getActivePage();
		IDE.openEditor(currentPage, file, true);
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		page = new NewCompleteOCLFileWizardPage(selection);
		addPage(page);
	}

	/**
	 * Gets the initial content of a new Complete OCL file.
	 * 
	 * @return the initial content of a new OCL resource.
	 */
	private String getOCLFileContent() {
		String metamodelUri = MetamodelUtils.getESuperPackage(page
			.getMetamodelUri());
		String line = new String("import '"); //$NON-NLS-1$
		// Try to check if the ResolveAll Resources cannot be used here.
		EPackage packageTemp = null;
		if (page.getMetaModelFromFile() != null) {
			line = line.concat(page.getMetaModelFromFile()).concat("'\n"); //$NON-NLS-1$
			IPath pathFile = new Path(page.getMetamodelUri());
			Resource loaded = OCLResourceUtil.loadResource(pathFile);
			packageTemp = (EPackage) loaded.getContents().get(0);
			OCLResourceUtil.registerResolvedResources(packageTemp);
		} else {
			// selected from the URI
			line = line.concat(metamodelUri).concat("'\n"); //$NON-NLS-1$
			packageTemp = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);
			OCLResourceUtil.registerResolvedResources(packageTemp);
			if (!page.getMetamodelUri().equals(metamodelUri)) {
				line = line
					.concat("import '").concat(page.getMetamodelUri()).concat("'\n");; //$NON-NLS-1$ //$NON-NLS-2$
				packageTemp = EPackage.Registry.INSTANCE.getEPackage(page
					.getMetamodelUri());
				OCLResourceUtil.registerResolvedResources(packageTemp);
			}
		}

		String firstPackageName = "undefined_root_package_name"; //$NON-NLS-1$
		if (packageTemp != null) {
			firstPackageName = packageTemp.getName();
		}
		
		line = line + "\npackage " + firstPackageName + "\n\n"; //$NON-NLS-1$ //$NON-NLS-2$
		line = line + "\tcontext type\n"; //$NON-NLS-1$
		line = line + "\tinv InvariantName: true\n\n"; //$NON-NLS-1$
		line = line + "endpackage\n"; //$NON-NLS-1$

		return line;
	}

	/**
	 * Sets the initial content of the new OCL rule file.
	 * 
	 * @param file
	 *            The file to create and initialize
	 * @throws IOException
	 *             if the resource can not be closed
	 * @throws CoreException
	 *             if the initialization step failed
	 */
	private void setInitialContent(IFile file)
			throws CoreException, IOException {
		InputStream stream = new ByteArrayInputStream(getOCLFileContent()
			.getBytes());
		if (file.exists()) {
			file.setContents(stream, true, true, null);
		} else {
			file.create(stream, true, null);
		}
		stream.close();
	}
}
