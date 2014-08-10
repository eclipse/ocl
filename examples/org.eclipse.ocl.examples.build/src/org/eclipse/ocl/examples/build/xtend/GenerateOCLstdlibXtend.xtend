/*******************************************************************************
 * Copyright (c) 2013,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.xtend

import org.eclipse.ocl.examples.pivot.DataType
import org.eclipse.ocl.examples.pivot.Root
import org.eclipse.jdt.annotation.NonNull
import org.eclipse.ocl.examples.domain.utilities.DomainUtil

public class GenerateOCLstdlibXtend extends GenerateOCLstdlib
{
	protected def String defineConstantType(DataType type) {'''
		«IF "Boolean".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._Boolean;«ELSEIF "Classifier".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._Classifier;«ELSEIF "Integer".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._Integer;«ELSEIF "Real".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._Real;«ELSEIF "String".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._String;«ELSEIF "UnlimitedNatural".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._UnlimitedNatural;«ELSE»
			protected final DataType «type.getPrefixedSymbolName("_"+type.partialName())» = createDataType("«type.name»");«ENDIF»
	'''}

	@NonNull protected override String generateMetamodel(@NonNull Root root) {
		var lib = DomainUtil.nonNullState(root.getLibrary());
		var allEnumerations = root.getSortedEnumerations();
		'''
			/*******************************************************************************
			 * Copyright (c) 2010,2014 E.D.Willink and others.
			 * All rights reserved. This program and the accompanying materials
			 * are made available under the terms of the Eclipse Public License v1.0
			 * which accompanies this distribution, and is available at
			 * http://www.eclipse.org/legal/epl-v10.html
			 *
			 * Contributors:
			 *     E.D.Willink - initial API and implementation
			 *******************************************************************************
			 * This code is 100% auto-generated
			 * from: «sourceFile»
			 * by: org.eclipse.ocl.examples.build.xtend.generateOCLstdlib.xtend
			 * and: org.eclipse.ocl.examples.build.GenerateOCLstdlibModel.mwe2
			 *
			 * Do not edit it.
			 *******************************************************************************/
			package	«javaPackageName»;
			
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
			import org.eclipse.ocl.examples.domain.ids.IdManager;
			import org.eclipse.ocl.examples.domain.ids.PackageId;
			import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
			import org.eclipse.ocl.examples.pivot.*;
			import org.eclipse.ocl.examples.pivot.Class;
			import org.eclipse.ocl.examples.pivot.Package;
			import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
			import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
			import org.eclipse.ocl.examples.pivot.resource.ASResourceImpl;
			import org.eclipse.ocl.examples.pivot.resource.OCLASResourceFactory;
			import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;
			import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
			
			/**
			 * This is the «uri» Standard Library
			 * auto-generated from «sourceFile».
			 * It facilitates efficient library loading without the overheads of model reading.
			 * <p>
			 * This Standard Library may be registered as the definition of a Standard Library for
			 * the OCL evaluation framework by invoking {@link #install}.
			 * <p>
			 * The Standard Library is normally activated when the MetaModelManager attempts
			 * to locate a library type when its default Standard Library URI is the same
			 * as this Standard Library.
			 */
			@SuppressWarnings({"nls", "unused"})
			public class «javaClassName» extends ASResourceImpl
			{
				/**
				 *	The static package-of-types pivot model of the Standard Library.
				 */
				private static «javaClassName» INSTANCE = null;
				
				/**
				 *	The URI of this Standard Library.
				 */
				public static final @NonNull String STDLIB_URI = "«uri»";
			
				/**
				 * Return the default OCL standard Library. 
				 *  This static definition auto-generated from «sourceFile»
				 *  is used as the default when no overriding copy is registered. 
				 */
				public static @NonNull OCLstdlib getDefault() {
					OCLstdlib oclstdlib = INSTANCE;
					if (oclstdlib == null) {
						Contents contents = new Contents();
						Root libraryModel = contents.create("«lib.getURI»", "«lib.name»", "«lib.nsPrefix»", "«lib.getURI»");
						oclstdlib = INSTANCE = new OCLstdlib(STDLIB_URI + PivotConstants.DOT_OCL_AS_FILE_EXTENSION, libraryModel);
					}
					return oclstdlib;
				}
			
				/**
				 * Return true if the default OCL standard Library has been created. 
				 */
			//	public static boolean hasDefault() {
			//		return INSTANCE != null;
			//	}
			
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
					if (StandardLibraryContribution.REGISTRY.size() == 0) {
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
				public static class Loader implements StandardLibraryContribution
				{
					public @NonNull StandardLibraryContribution getContribution() {
						return this;
					}
					
					public @NonNull Resource getResource() {
						return getDefault();
					}
				}
				
				/**
				 *	Define an OCL Standard Library contribution that renames the standard contribution
				 *  to extend a given actual metamodel NsURI. For UML, this ensures that the self-defining
				 *  OCL meta-namespaces and the self-defining UML meta-namespaces are the same.
				 */
				public static class RenamingLoader implements StandardLibraryContribution
				{
					protected final @NonNull String metamodelNsUri;
			
					public RenamingLoader(@NonNull String metamodelNsUri) {
						this.metamodelNsUri = metamodelNsUri;
					}
					
					public @NonNull StandardLibraryContribution getContribution() {
						return this;
					}
			
					public @NonNull Resource getResource() {
						Contents contents = new Contents();
						Root libraryModel = contents.create("http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib", "ocl", "ocl", metamodelNsUri);
						Resource resource = new OCLstdlib(STDLIB_URI + PivotConstants.DOT_OCL_AS_FILE_EXTENSION, libraryModel);
						return resource;
					}
				}
				
				/**
				 *	Construct a copy of the OCL Standard Library with specified resource URI,
				 *  and package name, prefix and namespace URI.
				 */
				public static @NonNull «javaClassName» create(@NonNull String asURI, @NonNull String name, @NonNull String nsPrefix, @NonNull String nsURI) {
					Contents contents = new Contents();
					Root libraryModel = contents.create(asURI, name, nsPrefix, nsURI);
					return new «javaClassName»(asURI, libraryModel);
				}
				
				/**
				 *	Construct an OCL Standard Library with specified resource URI and library content.
				 */
				public «javaClassName»(@NonNull String asURI, @NonNull Root libraryModel) {
					super(DomainUtil.nonNullState(URI.createURI(asURI)), OCLASResourceFactory.INSTANCE);
					assert PivotUtil.isASURI(asURI);
					getContents().add(libraryModel);
			//		System.out.println(Thread.currentThread().getName() + " Create " + debugSimpleName(this));		
			//		liveOCLstdlibs.put(this, null);
				}
			
				/**
				 * Overridden to inhibit entry of the static shared instance in any ResourceSet.
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
				 */
				@Override
				protected void doUnload() {
					if (this != INSTANCE) {
						super.doUnload();
					}
				}
			
				/**
				 * Ensure xmi:ids are auto-generated before reference.
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
			
				protected static class Contents extends AbstractContents
				{
					protected Root «root.getPrefixedSymbolName("root")»;
					protected Library «lib.getPrefixedSymbolName("library")»;
					// protected Package «root.getOrphanPackage().getPrefixedSymbolName("orphans")»;
			
					protected @NonNull Root create(@NonNull String asURI, @NonNull String name, @NonNull String nsPrefix, @NonNull String nsURI)
					{
						Root theRoot = «root.getSymbolName()» = createRoot(asURI);
						«lib.getSymbolName()» = createLibrary(name, nsPrefix, nsURI, IdManager.METAMODEL);
						installPackages();
						installOclTypes();
						installPrimitiveTypes();
			«IF allEnumerations.size() > 0»
						installEnumerations();
			«ENDIF»
						installParameterTypes();
						installCollectionTypes();
						installMetaclasses();
						installLambdaTypes();
						installTupleTypes();
						installOperations();
						installIterations();
						installProperties();
						installTemplateBindings();
						installPrecedences();
						installComments();
						return theRoot;
					}
				
					«lib.definePackages()»

					«lib.declareOclTypes()»

					«lib.declarePrimitiveTypes()»
					«IF allEnumerations.size() > 0»

					«lib.declareEnumerations()»
					«ENDIF»

					«lib.defineTemplateParameters()»

					«lib.declareCollectionTypes()»

					«lib.declareMetaclasses()»

					«lib.declareTupleTypes()»

					«lib.defineOclTypes()»

					«lib.definePrimitiveTypes()»
					«IF allEnumerations.size() > 0»

					«lib.defineEnumerations()»
					«ENDIF»

					«lib.defineParameterTypes()»

					«lib.defineCollectionTypes()»

					«lib.defineMetaclasses()»

					«lib.defineTupleTypes()»

					«lib.defineLambdaTypes()»	

					«lib.defineOperations()»	

					«lib.defineIterations()»	

					«lib.declareProperties()»

					«lib.defineProperties()»

					«lib.defineTemplateSignatures()»

					«lib.defineTemplateBindings()»

					«lib.definePrecedences()»

					«lib.defineComments()»
				}

			/*	private static WeakHashMap<OCLstdlib,Object> liveOCLstdlibs = new WeakHashMap<OCLstdlib,Object>();
				
				public static String debugSimpleName(Object object) {
					if (object == null) {
						return "null";
					}
					else {
						return object.getClass().getSimpleName() + "@" + Integer.toHexString(object.hashCode());
					}
				}

				@Override
				protected void finalize() throws Throwable {
					System.out.println("Finalize " + debugSimpleName(this));		
					super.finalize();
					Set<OCLstdlib> keySet = liveOCLstdlibs.keySet();
					if (!keySet.isEmpty()) {
						StringBuilder s = new StringBuilder();
						s.append(" live");
						for (OCLstdlib stdlib : keySet) {
							s.append(" @" + Integer.toHexString(stdlib.hashCode()));		
						}
						System.out.println(s);		
					}
				} */

			/*	public static void decontain() {
					Map<EObject, Object> allContents = new WeakHashMap<EObject,Object>(1000);
					for (OCLstdlib oclstdlib : liveOCLstdlibs.keySet()) {
						for (TreeIterator<EObject> tit = oclstdlib.getAllContents(); tit.hasNext(); ) {
							allContents.put(tit.next(), null);
						}
					}
					for (EObject eObject : allContents.keySet()) {
						for (EReference eReference : eObject.eClass().getEAllReferences()) {
							boolean isUnsettable = eReference.isUnsettable();
							boolean isChangeable = eReference.isChangeable();
							if (isChangeable) {
			//					System.out.println("unset : " + debugSimpleName(eObject) + " " + eReference.getName());
								try {
									eObject.eUnset(eReference);
								}
								catch (Exception e) {}
							}
						}
					}
					System.gc();
					System.runFinalization();
					for (EObject eObject : allContents.keySet()) {
						System.out.println("   still live : " + debugSimpleName(eObject));
					}
				} */
			}
		'''
	}
}
