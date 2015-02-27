package org.eclipse.ocl.examples.xtext.tests;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.EAnnotationConstraintsNormalizer;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.EAnnotationsNormalizer;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.EDetailsNormalizer;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.EOperationsNormalizer;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.ETypedElementNormalizer;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.util.EmfFormatter;
import org.osgi.framework.Bundle;


public class TestUtil
{
	public static void assertSameModel(@NonNull Resource expectedResource, @NonNull Resource actualResource) throws IOException, InterruptedException {
		List<Normalizer> expectedNormalizations = normalize(expectedResource);
		List<Normalizer> actualNormalizations = normalize(actualResource);
		String expected = EmfFormatter.listToStr(expectedResource.getContents());
		String actual = EmfFormatter.listToStr(actualResource.getContents());
		TestCase.assertEquals(expected, actual);
		for (Normalizer normalizer : expectedNormalizations) {
			normalizer.denormalize();
		}
		for (Normalizer normalizer : actualNormalizations) {
			normalizer.denormalize();
		}
	}

	public static void closeIntro() {
		IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
		introManager.closeIntro(introManager.getIntro());
	}

	public static @NonNull IFile copyIFile(@NonNull OCL ocl, @NonNull URI sourceURI, IProject project, String projectPath) throws CoreException, IOException {
		URIHandler uriHandler = ocl.getResourceSet().getURIConverter().getURIHandler(sourceURI);
		InputStream inputStream = uriHandler.createInputStream(sourceURI, new HashMap<Object,Object>());
		IFile outFile = project.getFile(projectPath);
		mkdirs(outFile.getParent());
		outFile.create(inputStream, true, null);
		return outFile;
	}

	public static void createClassPath(@NonNull IProject project, @Nullable String[] srcPaths) throws IOException, CoreException {
		StringBuilder s = new StringBuilder();
		s.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); 
		s.append("<classpath>\n");
		s.append("	<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6\"/>\n");
		s.append("	<classpathentry kind=\"con\" path=\"org.eclipse.pde.core.requiredPlugins\"/>\n");
		if (srcPaths != null) {
			for (String srcPath : srcPaths) {
				s.append("	<classpathentry kind=\"src\" path=\"" + srcPath+ "\"/>\n"); 
			}
		}
		s.append("	<classpathentry kind=\"output\" path=\"bin\"/>\n"); 
		s.append("</classpath>\n");
		@SuppressWarnings("null")@NonNull String string = s.toString();
		TestUtil.createIFile(project, ".classpath", string);
	}

	public static void createFile(@NonNull File file, @NonNull String fileContent) throws IOException {
		Writer writer = new FileWriter(file);
		writer.append(fileContent);
		writer.close();
	}
	
	public static @NonNull IFile createIFile(@NonNull IContainer container, @NonNull String fileName, @NonNull String fileContents) throws IOException, CoreException {
		InputStream inputStream = new URIConverter.ReadableInputStream(fileContents, "UTF-8");
		IFile iFile = container.getFile(new Path(fileName));
		if (iFile.exists()) {
			iFile.delete(true, null);
		}
		iFile.create(inputStream, true, null);
		return iFile;
	}

	public static @NonNull FileEditorInput createFileEditorInput(@NonNull IContainer container, @NonNull String fileName, @NonNull InputStream inputStream) throws CoreException {
		IFile file1 = container.getFile(new Path(fileName));
		file1.create(inputStream, true, null);
		return new FileEditorInput(file1) {};	// Ensure classloader is here
	}

	public static @NonNull IFolder createFolder(@NonNull IContainer container, @NonNull String folderName) throws CoreException {
		IFolder folder = container.getFolder(new Path(folderName));
		if (!folder.exists()) {
			folder.create(true,  false,  null);
		}
		return folder;
	}
	
	public static @NonNull IProject createJavaProject(@NonNull String projectName) throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(projectName);
		if (!project.exists()) {
			project.create(null);
		}
		if (!project.isOpen()) {
			project.open(null);
		}
		IProjectDescription description = project.getDescription();
		ICommand command1 = description.newCommand();
		command1.setBuilderName("org.eclipse.jdt.core.javabuilder");
		ICommand command2 = description.newCommand();
		command2.setBuilderName("org.eclipse.pde.ManifestBuilder");
		ICommand command3 = description.newCommand();
		command3.setBuilderName("org.eclipse.pde.SchemaBuilder");
		description.setBuildSpec(new ICommand[]{command1, command2, command3});
		description.setNatureIds(new String[]{"org.eclipse.pde.PluginNature", "org.eclipse.jdt.core.javanature"});
		project.setDescription(description, null);
		return project;
	}

	public static void createManifest(@NonNull IProject project, @NonNull String projectName,
			@Nullable String[] requireBundles, @Nullable String[] additionalBundles, @Nullable String[] exportPackages) throws CoreException {
		IFolder folder = project.getFolder("META-INF");
		folder.create(true, false, null);
		IFile file = folder.getFile("MANIFEST.MF");
		StringBuilder s = new StringBuilder();
		s.append("Manifest-Version: 1.0\n"); 
		s.append("Bundle-ManifestVersion: 2\n");
		s.append("Bundle-Name: " + projectName + "\n"); 
		s.append("Bundle-SymbolicName: " + projectName + ";singleton:=true\n");
		s.append("Bundle-Version: 0.0.0.qualifier\n");
		s.append("Bundle-Localization: plugin\n");
		if (requireBundles != null) {
			s.append("Require-Bundle:");
			String prefix = " ";
			for (String requireBundle : requireBundles) {
				s.append(prefix);
				s.append(requireBundle);
				prefix = ",\n ";
			}
			s.append("\n");
		}
		if (exportPackages != null) {
			s.append("Export-Package:");
			String prefix = " ";
			for (String exportPackage : exportPackages) {
				s.append(prefix);
				s.append(exportPackage);
				prefix = ",\n ";
			}
			s.append("\n");
		}
		String manifestContents = s.toString();
		file.create(new ByteArrayInputStream(manifestContents.getBytes()), true, null);
		if (additionalBundles != null) {
			file = project.getFile("build.properties");
			s = new StringBuilder();
//			if (additionalBundles != null) {
				s.append("additional.bundles =");
				String prefix = " ";
				for (String additionalBundle : additionalBundles) {
					s.append(prefix);
					s.append(additionalBundle);
					prefix = ",\\\n\t";
				}
				s.append("\n");
//			}
			String buildPropertiesContents = s.toString();
			file.create(new ByteArrayInputStream(buildPropertiesContents.getBytes()), true, null);
		}
	}

	public static void deleteDirectory(@NonNull File dir) throws Exception {
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			if (file.isFile()) {
				file.delete();
			} else if (file.isDirectory()) {
				deleteDirectory(file);
			}
		}
		dir.delete();
	}

	public static void deleteIProject(@NonNull String testProjectName) throws Exception {
		TestUtil.suppressGitPrefixPopUp();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject project = workspace.getRoot().getProject(testProjectName);
		project.delete(true, true, null);
	}

//	public static void flushEvents() {
//		IWorkbench workbench = PlatformUI.getWorkbench();
//		while (workbench.getDisplay().readAndDispatch());
//	}

	public static void flushEvents() {
		for (int i = 0; i < 10; i++) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			while (workbench.getDisplay().readAndDispatch());
		}
	}

	public static void mkdirs(IContainer parent) throws CoreException {
		if (parent instanceof IProject) {
			IProject iProject = (IProject) parent;
			if (!iProject.exists()) {
				iProject.create(null);
			}
		}
		else if (parent instanceof IFolder) {
			IFolder iFolder = (IFolder) parent;
			if (!iFolder.exists()) {
				mkdirs(iFolder.getParent());
				iFolder.create(true, false, null);
			}
		}
	}

	public static List<Normalizer> normalize(Resource resource) {
		List<Normalizer> normalizers = new ArrayList<Normalizer>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof ETypedElement) {
				ETypedElement eTypedElement = (ETypedElement) eObject;
				if (eTypedElement.getUpperBound() == 1) {
					if (!eTypedElement.isOrdered() || !eTypedElement.isUnique()) {
						normalizers.add(new ETypedElementNormalizer(eTypedElement));
					}
				}
			}
			if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				if (eClass.getEOperations().size() >= 2) {
					normalizers.add(new EOperationsNormalizer(eClass));		// FIXME Until AS2Ecore has consistent ops/inv ordering
				}
			}
			if (eObject instanceof EModelElement) {
				EModelElement eModelElement = (EModelElement) eObject;
				if (eModelElement.getEAnnotations().size() >= 2) {
					normalizers.add(new EAnnotationsNormalizer(eModelElement));
				}
			}
			if (eObject instanceof EAnnotation) {
				EAnnotation eAnnotation = (EAnnotation) eObject;
				EMap<String, String> eDetails = eAnnotation.getDetails();
				if (eDetails.size() > 1) {
					normalizers.add(new EDetailsNormalizer(eAnnotation));
				}
				if (EcorePackage.eNS_URI.equals(eAnnotation.getSource()) && eDetails.containsKey("constraints")) {
					normalizers.add(new EAnnotationConstraintsNormalizer(eAnnotation));
				}
			}
		}
		for (Normalizer normalizer : normalizers) {
			normalizer.normalize();
		}
		return normalizers;
	}

	private static boolean testedEgitUiBundle = false;

	/**
	 * Suppress diagnostics from EGIT
	 * <p>
	 * This was originally necessary to eliminate a model PopUp that locked up the tests (Bug 390479).
	 * <p>
	 * Now it just suppresses a Console Log entry.
	 */
	public static void suppressGitPrefixPopUp() {
	    if (!testedEgitUiBundle) {
	    	testedEgitUiBundle = true;
	    	Bundle egitUiBundle = Platform.getBundle("org.eclipse.egit.ui");
	        if (egitUiBundle != null) {
				try {
					Class<?> activatorClass = egitUiBundle.loadClass("org.eclipse.egit.ui.Activator");
					Class<?> preferencesClass = egitUiBundle.loadClass("org.eclipse.egit.ui.UIPreferences");
					Method getDefaultMethod = activatorClass.getMethod("getDefault");
					AbstractUIPlugin activator = (AbstractUIPlugin) getDefaultMethod.invoke(null);
					IPreferenceStore store = activator.getPreferenceStore();
					Field field = preferencesClass.getField("SHOW_GIT_PREFIX_WARNING");
					String name = (String)field.get(null);
					store.setValue(name, false);
					field = preferencesClass.getField("SHOW_HOME_DIR_WARNING");
					name = (String)field.get(null);
					store.setValue(name, false);
				}
				catch (Exception e) {}			// Ignore
			}
	    }
	}

}
