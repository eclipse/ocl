package org.eclipse.ocl.ui.wizards;

import java.io.File;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ocl.ui.wizards.utils.Messages;
import org.eclipse.ocl.ui.wizards.utils.OCLResourceUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

/**
 * Wizard page allowing creation of OCL rule files in the workspace.
 * 
 * @author mrostren
 * 
 */
public class NewCompleteOCLFileWizardPage
		extends WizardPage {

	private static final String DEFAULT_FILENAME = "*"; //$NON-NLS-1$

	private static final String DEFAULT_EXTENSION = "ocl"; //$NON-NLS-1$

	public static final String STANDARD_ACCEPTED_NAME_PATTERN_STRING = "[A-Za-z][A-Za-z0-9_ \\-]*[A-Za-z0-9]+"; //$NON-NLS-1$

	public static final String STANDARD_REFUSED_NAME_PATTERN_STRING = "[\\Q*\\E]*|[A-Za-z\\Q*\\E][A-Za-z0-9_ \\-\\Q*\\E]*[A-Za-z0-9\\Q*\\E]+"; //$NON-NLS-1$

	public static final Pattern STANDARD_ACCEPTED_NAME_PATTERN = Pattern
		.compile(STANDARD_ACCEPTED_NAME_PATTERN_STRING);

	public static final Pattern STANDARD_REFUSED_NAME_PATTERN = Pattern
		.compile(STANDARD_REFUSED_NAME_PATTERN_STRING);

	public static final String DEFAULT_METAMODEL_URI = "http://"; //$NON-NLS-1$
	
	private Text containerText;

	private Text fileText;

	private Combo modelUriCombo;

	private Text modelText;

	private Button modelUriRadioButton;

	private Button modelFileRadioButton;

	private Button modelBrowseWorkspaceButton;

	private Button modelBrowseSystemButton;

	private ISelection selection;

	private ComboViewer modelUriComboViewer;

	/**
	 * Constructor
	 * 
	 * @param selection
	 *            The selection
	 */
	protected NewCompleteOCLFileWizardPage(ISelection selection) {
		super("page"); //$NON-NLS-1$
		setTitle(Messages.getString("NewCompleteOCLFileWizardPage.3")); //$NON-NLS-1$
		setDescription(Messages.getString("NewCompleteOCLFileWizardPage.4")); //$NON-NLS-1$
		this.selection = selection;
	}

	/**
	 * Creates the main content of the page.
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(3, false));

		Label containerLabel = new Label(container, SWT.NONE);
		containerLabel.setText(Messages
			.getString("NewCompleteOCLFileWizardPage.5")); //$NON-NLS-1$
		GridData gd = new GridData();
		gd.widthHint = containerLabel.getText().length()
			* containerLabel.getFont().getFontData()[0].getHeight() * 2 / 3;
		containerLabel.setLayoutData(gd);

		containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
		containerText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
			false));
		containerText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		Button button = new Button(container, SWT.PUSH);
		button.setText(Messages.getString("NewCompleteOCLFileWizardPage.6")); //$NON-NLS-1$
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleBrowse();
			}
		});

		Label fileLabel = new Label(container, SWT.NONE);
		fileLabel.setText(Messages.getString("NewCompleteOCLFileWizardPage.7")); //$NON-NLS-1$

		fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(SWT.FILL, SWT.NONE, true, false);
		gd.horizontalSpan = 2;
		fileText.setLayoutData(gd);
		fileText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		modelUriRadioButton = new Button(container, SWT.RADIO);
		modelUriRadioButton.setText(Messages
			.getString("NewCompleteOCLFileWizardPage.8")); //$NON-NLS-1$
		modelUriRadioButton.setSelection(true);
		gd = new GridData();
		gd.widthHint = modelUriRadioButton.getFont().getFontData()[0]
			.getHeight() * modelUriRadioButton.getText().length() * 2 / 3 + 20;
		modelUriRadioButton.setLayoutData(gd);
		modelUriRadioButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				modelUriCombo.setEnabled(true);
				modelText.setEnabled(false);
				modelBrowseWorkspaceButton.setEnabled(false);
				modelBrowseSystemButton.setEnabled(false);
				dialogChanged();
			}
		});

		modelUriCombo = new Combo(container, SWT.BORDER);
		gd = new GridData(SWT.FILL, SWT.NONE, true, false);
		gd.horizontalSpan = 2;
		modelUriCombo.setLayoutData(gd);
		modelUriCombo.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		modelUriComboViewer = new ComboViewer(modelUriCombo);
		modelUriComboViewer.setSorter(new ViewerSorter());

		fillComboBox();

		modelFileRadioButton = new Button(container, SWT.RADIO);
		modelFileRadioButton.setText(Messages
			.getString("NewCompleteOCLFileWizardPage.9")); //$NON-NLS-1$
		modelFileRadioButton.setSelection(false);
		modelFileRadioButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				modelUriCombo.setEnabled(false);
				modelText.setEnabled(true);
				modelBrowseWorkspaceButton.setEnabled(true);
				modelBrowseSystemButton.setEnabled(true);
				dialogChanged();
			}
		});

		modelText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(SWT.FILL, SWT.NONE, true, false);
		gd.horizontalSpan = 2;
		modelText.setLayoutData(gd);
		modelText.setEnabled(false);
		modelText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		Composite modelButtonsComposite = new Composite(container, SWT.NONE);
		gd = new GridData(SWT.RIGHT, SWT.NONE, true, false);
		gd.horizontalSpan = 3;
		modelButtonsComposite.setLayoutData(gd);
		modelButtonsComposite.setLayout(new GridLayout(2, true));

		modelBrowseWorkspaceButton = new Button(modelButtonsComposite, SWT.PUSH);
		modelBrowseWorkspaceButton.setText(Messages
			.getString("NewCompleteOCLFileWizardPage.10")); //$NON-NLS-1$
		modelBrowseWorkspaceButton.setEnabled(false);
		modelBrowseWorkspaceButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleWorkspaceBrowse();
			}
		});

		modelBrowseSystemButton = new Button(modelButtonsComposite, SWT.PUSH);
		modelBrowseSystemButton.setText(Messages
			.getString("NewCompleteOCLFileWizardPage.11")); //$NON-NLS-1$
		modelBrowseSystemButton.setEnabled(false);
		modelBrowseSystemButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleSystemBrowse();
			}
		});

		initialize();
		dialogChanged();
		setControl(container);
	}

	/**
	 * Gets the location based on the workspace
	 * 
	 * @return The name of the container
	 */
	public IPath getLocation() {
		return new Path(containerText.getText());
	}

	/**
	 * Gets the filename
	 * 
	 * @return the filename
	 */
	public IPath getFileName() {
		return new Path(fileText.getText());
	}

	/**
	 * Gets the metamodel from the EMF registry.
	 * 
	 * @return a string representing the path to the metamodel.
	 */
	public String getMetamodelUri() {
		if (modelUriRadioButton.getSelection()) {
			return modelUriCombo.getText();
		} else {
			return modelText.getText();
		}
	}

	/**
	 * Gets the metamodel from a workspace resource.
	 * 
	 * @return a string representing the path to the metamodel.
	 */
	public String getMetaModelFromFile() {
		if (modelUriRadioButton.getSelection()) {
			return null;
		} else {
			return modelText.getText();
		}
	}

	/**
	 * Fill the text fields with default information
	 */
	private void initialize() {
		if (selection != null && !selection.isEmpty()
			&& selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() > 1) {
				return;
			}
			Object obj = structuredSelection.getFirstElement();
			if (obj instanceof IResource) {
				IContainer container;
				if (obj instanceof IContainer) {
					container = (IContainer) obj;
				} else {
					container = ((IResource) obj).getParent();
				}
				containerText.setText(container.getFullPath().toString());
			} else if (obj instanceof IJavaProject) {
				IJavaProject container = (IJavaProject) obj;
				containerText.setText(container.getProject().getFullPath()
					.toString());
			} else if (obj instanceof IPackageFragmentRoot) {
				IPackageFragmentRoot container = (IPackageFragmentRoot) obj;
				containerText.setText(container.getJavaProject().getProject()
					.getFolder(container.getElementName()).getFullPath()
					.toString());
			}
		}
		fileText.setText(DEFAULT_FILENAME + "." + DEFAULT_EXTENSION); //$NON-NLS-1$
	}

	/**
	 * Handles a simple browse operation
	 */
	private void handleBrowse() {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(
			getShell(), ResourcesPlugin.getWorkspace().getRoot(), false,
			Messages.getString("NewCompleteOCLFileWizardPage.13")); //$NON-NLS-1$
		if (dialog.open() == ContainerSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				containerText.setText(((Path) result[0]).toString());
			}
		}
	}

	/**
	 * Handles a workspace browse.
	 */
	private void handleWorkspaceBrowse() {
		ResourceSelectionDialog dialog = new ResourceSelectionDialog(
			getShell(), ResourcesPlugin.getWorkspace().getRoot(),
			Messages.getString("NewCompleteOCLFileWizardPage.13")); //$NON-NLS-1$
		if (dialog.open() == ResourceSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				modelText.setText(((IFile) result[0]).getFullPath().toString());
			}
		}
	}

	/**
	 * Handles a file system browse.
	 */
	private void handleSystemBrowse() {
		FileDialog dialog = new FileDialog(getShell());
		String result = dialog.open();
		if (result != null && !result.equals("")) //$NON-NLS-1$
		{
			modelText.setText(new File(result).getPath());
		}
	}

	/**
	 * Fills in the list according to values register in EMF registry.
	 */
	private void fillComboBox() {
		modelUriComboViewer.add(""); //$NON-NLS-1$
		for (String uri : EPackage.Registry.INSTANCE.keySet()) {
			modelUriComboViewer.add(uri);
		}
		modelUriComboViewer.getCombo().setText("http://"); //$NON-NLS-1$
	}

	/**
	 * Handles error/warning messages when items from the dialog change
	 */
	private void dialogChanged() {
		if (checkLocation() && checkFileName() && checkMetamodel()) {
			updateStatus(null);
		}
	}

	/**
	 * Checks collected information about the location.
	 * 
	 * @return <code>true</code> if the location is valid, <code>false</code>
	 *         otherwise.
	 */
	private boolean checkLocation() {
		IResource container = ResourcesPlugin.getWorkspace().getRoot()
			.findMember(getLocation());
		if (getLocation().segmentCount() == 0) {
			updateStatus(Messages.getString("NewCompleteOCLFileWizardPage.16")); //$NON-NLS-1$
			return false;
		}
		if (!container.exists()) {
			updateStatus(Messages.getString("NewCompleteOCLFileWizardPage.17")); //$NON-NLS-1$
			return false;
		}
		if (container.getType() == IResource.FILE) {
			updateStatus(Messages.getString("NewCompleteOCLFileWizardPage.18")); //$NON-NLS-1$
			return false;
		}
		if (!container.isAccessible()) {
			updateStatus(Messages.getString("NewCompleteOCLFileWizardPage.19")); //$NON-NLS-1$
			return false;
		}
		return true;
	}

	/**
	 * Checks collected information about the filename.
	 * 
	 * @return <code>true</code> if the filename is valid, <code>false</code>
	 *         otherwise.
	 */
	private boolean checkFileName() {
		IPath fileName = getFileName();
		if (fileName.removeFileExtension().isEmpty()) {
			updateStatus(Messages.getString("NewCompleteOCLFileWizardPage.20")); //$NON-NLS-1$
			return false;
		}
		if (!STANDARD_ACCEPTED_NAME_PATTERN.matcher(
			fileName.removeFileExtension().toString()).matches()
			&& STANDARD_REFUSED_NAME_PATTERN.matcher(
				fileName.removeFileExtension().toString()).matches()) {
			updateStatus(Messages.getString("NewCompleteOCLFileWizardPage.21")); //$NON-NLS-1$
			return false;
		}

		if (!DEFAULT_EXTENSION.equalsIgnoreCase(fileName.getFileExtension())) {
			updateStatus(Messages.getString("NewCompleteOCLFileWizardPage.22")); //$NON-NLS-1$
			return false;
		}
		if (resourceExist()) {
			updateStatus(Messages.getString("NewCompleteOCLFileWizardPage.23")); //$NON-NLS-1$
			return false;
		}
		return true;
	}

	/**
	 * Checks collected information about the metamodel.
	 * 
	 * @return <code>true</code> if the metamodel is known, <code>false</code>
	 *         otherwise.
	 */
	private boolean checkMetamodel() {
		if (getMetamodelUri().length() == 0) {
			updateStatus(Messages.getString("NewCompleteOCLFileWizardPage.24")); //$NON-NLS-1$
			return false;
		} else if (!isMetamodelURIValid()) {
			updateStatus(Messages.getString("NewCompleteOCLFileWizardPage.25")); //$NON-NLS-1$
			return false;
		}
		return true;
	}

	/**
	 * Checks if the metamodel uri is valid
	 * 
	 * @return <code>true</code> if the metamodel exists in the list,
	 *         <code>false</code> otherwise.
	 */
	private boolean isMetamodelURIValid() {
		for (String item : modelUriComboViewer.getCombo().getItems()) {
			if (item.equals(getMetamodelUri())) {
				return true;
			}
		}

		IPath pathFile = new Path(getMetamodelUri());
		if (!DEFAULT_METAMODEL_URI.equals(pathFile.toString())) {
			try {
				Resource loaded = OCLResourceUtil.loadResource(pathFile);
				if (loaded.getContents().get(0) instanceof EPackage) {
					return true;
				}
			} catch (Exception exception) {
				return false;
			}
		}

		return false;
	}

	/**
	 * Updates the status of the page.
	 * 
	 * @param message
	 *            a message to display in the message area.
	 */
	private void updateStatus(String message) {
		setMessage(message, WizardPage.ERROR);
		setPageComplete(message == null);
	}

	/**
	 * Checks that the OCL resource the user is creating does not already exist.
	 * 
	 * @return <code>true</code> if the future resource already exists,
	 *         <code>false</code> otherwise.
	 */
	private boolean resourceExist() {
		IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
		IResource oclResource = wsRoot.getFile(getLocation().append(
			getFileName()));
		return oclResource.exists();
	}
}
