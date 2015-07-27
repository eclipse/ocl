/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************
 * This code is 100% auto-generated
 * from: /org.eclipse.ocl.examples.xtext.tests/model/TestLibrary.oclstdlib
 * by: org.eclipse.ocl.examples.build.xtend.generateOCLstdlib.xtend
 * and: org.eclipse.ocl.examples.build.GenerateOCLstdlibModel.mwe2
 *
 * Do not edit it.
 *******************************************************************************/
package	org.eclipse.ocl.examples.xtext.tests.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.*;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.internal.utilities.AbstractContents;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;

/**
 * This is the http://www.eclipse.org/ocl/2015/CGLibrary Standard Library
 * auto-generated from /org.eclipse.ocl.examples.xtext.tests/model/TestLibrary.oclstdlib.
 * It facilitates efficient library loading without the overheads of model reading.
 * <p>
 * This Standard Library may be registered as the definition of a Standard Library for
 * the OCL evaluation framework by invoking {@link #install}.
 * <p>
 * The Standard Library is normally activated when the MetamodelManager attempts
 * to locate a library type when its default Standard Library URI is the same
 * as this Standard Library.
 */
@SuppressWarnings({"nls", "unused"})
public class TestsLibrary extends ASResourceImpl
{
	/**
	 *	The static package-of-types pivot model of the Standard Library.
	 */
	private static TestsLibrary INSTANCE = null;
	
	/**
	 *	The URI of this Standard Library.
	 */
	public static final @NonNull String STDLIB_URI = "http://www.eclipse.org/ocl/2015/CGLibrary";

	/**
	 * Return the default http://www.eclipse.org/ocl/2015/CGLibrary standard Library Resource. 
	 *  This static definition auto-generated from /org.eclipse.ocl.examples.xtext.tests/model/TestLibrary.oclstdlib
	 *  is used as the default when no overriding copy is registered.
	 * It cannot be unloaded or rather unloading has no effect.
	 */
	public static @NonNull TestsLibrary getDefault() {
		TestsLibrary oclstdlib = INSTANCE;
		if (oclstdlib == null) {
			Contents contents = new Contents("http://www.eclipse.org/ocl/2015/Library");
			oclstdlib = INSTANCE = new TestsLibrary(STDLIB_URI + PivotConstants.DOT_OCL_AS_FILE_EXTENSION, contents.getModel());
		}
		return oclstdlib;
	}

	/**
	 * Return the default http://www.eclipse.org/ocl/2015/CGLibrary standard Library model. 
	 *  This static definition auto-generated from /org.eclipse.ocl.examples.xtext.tests/model/TestLibrary.oclstdlib
	 *  is used as the default when no overriding copy is registered. 
	 */
	public static @NonNull Model getDefaultModel() {
		Model model = (Model)(getDefault().getContents().get(0));
		assert model != null;
		return model;
	}

	/**
	 * Return the default http://www.eclipse.org/ocl/2015/CGLibrary standard Library package. 
	 *  This static definition auto-generated from /org.eclipse.ocl.examples.xtext.tests/model/TestLibrary.oclstdlib
	 *  is used as the default when no overriding copy is registered. 
	 */
	public static @NonNull Package getDefaultPackage() {
		Package pkge = getDefaultModel().getOwnedPackages().get(0);
		assert pkge != null;
		return pkge;
	}

	/**
	 * Install this library in the {@link StandardLibraryContribution#REGISTRY}.
	 * This method may be invoked by standalone applications to replicate
	 * the registration that should appear as a standard_library plugin
	 * extension when running within Eclipse. 
	 */
	public static void install() {
		StandardLibraryContribution.REGISTRY.put(STDLIB_URI, new Loader());
	}

	/**
	 * Install this library in the {@link StandardLibraryContribution#REGISTRY}
	 * unless some other library contribution has already been installed.
	 */
	public static void lazyInstall() {
		if (StandardLibraryContribution.REGISTRY.get(STDLIB_URI) == null) {
			install();
		}
	}

	/**
	 * Unnstall this library from the {@link StandardLibraryContribution#REGISTRY}.
	 * This method may be invoked by standalone applications to release the library
	 * resources for garbage collection and memory leakage detection. 
	 */
	public static void uninstall() {
		StandardLibraryContribution.REGISTRY.remove(STDLIB_URI);
		INSTANCE = null;
	}
	
	/**
	 * The Loader shares the Standard Library instance whenever this default library
	 * is loaded from the registry of Standard Libraries populated by the standard_library 
	 * extension point.
	 */
	public static final class Loader implements StandardLibraryContribution
	{
		/**
		 * @noreference This method is not intended to be referenced by clients.
		 */
		@Override
		public @NonNull StandardLibraryContribution getContribution() {
			return this;
		}
		
		/**
		 * @noreference This method is not intended to be referenced by clients.
		 */
		@Override
		public @NonNull Resource getResource() {
			return getDefault();
		}
	}
	
	/**
	 *	Construct a copy of the OCL Standard Library with specified resource URI,
	 *  and package name, prefix and namespace URI.
	 */
	public static @NonNull TestsLibrary create(@NonNull String asURI) {
		Contents contents = new Contents(asURI);
		return new TestsLibrary(asURI, contents.getModel());
	}
	
	/**
	 *	Construct an OCL Standard Library with specified resource URI and library content.
	 */
	private TestsLibrary(@NonNull String asURI, @NonNull Model libraryModel) {
		super(ClassUtil.nonNullState(URI.createURI(asURI)), OCLASResourceFactory.getInstance());
		assert PivotUtilInternal.isASURI(asURI);
		getContents().add(libraryModel);
	}

	/**
	 * Overridden to inhibit entry of the static shared instance in any ResourceSet.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
		if (this != INSTANCE) {
			return super.basicSetResourceSet(resourceSet, notifications);
		}
		else {
			return notifications;
		}
	}

	/**
	 * Overridden to inhibit unloading of the static shared instance.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	protected void doUnload() {
		if (this != INSTANCE) {
			super.doUnload();
		}
	}

	/**
	 * Ensure xmi:ids are auto-generated before reference.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	public EObject getEObject(String uriFragment) {
		if (getEObjectToIDMap().isEmpty()) {
			new AS2XMIid().assignIds(this, null);
		}
		return super.getEObject(uriFragment);
	}

	/**
	 * Overridden to trivialise loading of the static shared instance.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	public void load(Map<?, ?> options) throws IOException {
		if (this != INSTANCE) {
			super.load(options);
		}
		else {
			setLoaded(true);
		}
	}

	/**
	 * Overridden to inhibit unloading of the static shared instance.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	protected Notification setLoaded(boolean isLoaded) {
		if (isLoaded || (this != INSTANCE)) {
			return super.setLoaded(isLoaded);
		}
		else {
			return null;
		}
	}

	private static class Contents extends AbstractContents
	{
		private final @NonNull Model model;
		private final @NonNull Library ocl;

		private Contents(@NonNull String asURI)
		{
			model = createModel(asURI);
			ocl = createLibrary("ocl", "ocl", "http://www.eclipse.org/ocl/2015/Library", IdManager.METAMODEL);
			installPackages();
			installClassTypes();
			installCollectionTypes();
			installOperations();
			installComments();
		}
		
		/**
		 * @noreference This method is not intended to be referenced by clients.
		 */
		public @NonNull Model getModel() {
			return model;
		}
		
		private final @NonNull Package _ocl = getPackage(org.eclipse.ocl.pivot.model.OCLstdlib.getDefaultModel(), "ocl");
		private final @NonNull AnyType _OclAny = getAnyType(_ocl, "OclAny");
		private final @NonNull Class _OclElement = getClass(_ocl, "OclElement");
		
		private void installPackages() {
			model.getOwnedPackages().add(ocl);
			model.getOwnedImports().add(createImport(null, _ocl));
		}
		
		private final @NonNull Class _CollectionType = createClass("CollectionType");
		
		private final @NonNull TemplateParameter tp_Collection_T = createTemplateParameter("T");
		
		private final @NonNull CollectionType _Collection_Collection_T = createCollectionType("Collection"/*T*/, "0", "*", tp_Collection_T);
		
		private void installClassTypes() {
			List<Class> ownedClasses;
			List<Class> superClasses;
			Class type;
		
			ownedClasses = ocl.getOwnedClasses();
			ownedClasses.add(type = _CollectionType);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
		}
		
		private void installCollectionTypes() {
			List<Class> ownedClasses;
			List<Class> superClasses;
			CollectionType type;
		
			ownedClasses = ocl.getOwnedClasses();
			ownedClasses.add(type = _Collection_Collection_T);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
		}
		
		private final @NonNull Operation op_Collection_staticType = createOperation("staticType", _CollectionType, "org.eclipse.ocl.examples.xtext.tests.CollectionStaticTypeOperation", org.eclipse.ocl.examples.xtext.tests.CollectionStaticTypeOperation.INSTANCE);
		
		private void installOperations() {
			List<Operation> ownedOperations;
			List<Parameter> ownedParameters;
			Operation operation;
			Parameter parameter;
		
			ownedOperations = _Collection_Collection_T.getOwnedOperations();
			ownedOperations.add(operation = op_Collection_staticType);
		}
		
		private void installComments() {
		}
	}
}
