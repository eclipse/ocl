/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.xtend

import java.util.Set
import org.eclipse.ocl.pivot.Class
import org.eclipse.ocl.pivot.CollectionType
import org.eclipse.ocl.pivot.DataType
import org.eclipse.ocl.pivot.Model
import org.eclipse.ocl.pivot.Package
import org.eclipse.jdt.annotation.NonNull
import org.eclipse.ocl.pivot.utilities.ClassUtil

public class GenerateOCLmetamodelXtend extends GenerateOCLmetamodel
{
	protected override String declareClassTypes(@NonNull Model root) {
		var pkge2classTypes = root.getSortedClassTypes();
		if (pkge2classTypes.isEmpty()) return "";
		var sortedPackages = root.getSortedPackages(pkge2classTypes.keySet());
		'''
		«FOR pkge : sortedPackages»

			«FOR type : pkge2classTypes.get(pkge)»
				private final @NonNull «type.eClass().name» «type.getPrefixedSymbolName("_"+type.partialName())» = create«type.eClass().name»(«getEcoreLiteral(type)»);
			«ENDFOR»
		«ENDFOR»
		'''
	}

	protected override String declareEnumerations(@NonNull Model root) {
		var pkge2enumerations = root.getSortedEnumerations();
		if (pkge2enumerations.isEmpty()) return "";
		var sortedPackages = root.getSortedPackages(pkge2enumerations.keySet());
		'''

		«FOR pkge : sortedPackages»
			«FOR enumeration : pkge2enumerations.get(pkge)»
				«var enumerationName = enumeration.getPrefixedSymbolName("_" + enumeration.partialName())»
				private final @NonNull Enumeration «enumerationName» = createEnumeration(«getEcoreLiteral(enumeration)»);
				«FOR enumerationLiteral : enumeration.ownedLiterals»
					private final @NonNull EnumerationLiteral «enumerationLiteral.getPrefixedSymbolName("el_"+enumerationName+"_"+enumerationLiteral.name)» = createEnumerationLiteral(«getEcoreLiteral(enumerationLiteral)»);
				«ENDFOR»
			«ENDFOR»
		«ENDFOR»
		'''
	}

	protected override String declareProperties(@NonNull Model root) {
		var pkge2properties = root.getSortedProperties();
		if (pkge2properties.isEmpty()) return "";
		var sortedPackages = root.getSortedPackages(pkge2properties.keySet());
		'''
			«FOR pkge : sortedPackages»

				«FOR property : pkge2properties.get(pkge)»
					private final @NonNull Property «property.getPrefixedSymbolName("pr_"+property.partialName())» = createProperty(«getEcorePropertyLiteral(property)», «property.type.getSymbolName()»);
				«ENDFOR»
			«ENDFOR»
		'''
	}

	protected def String defineCollectionTypeName(Set<Class> allTypes, String typeName) {
		var CollectionType collectionType = allTypes.findCollectionType(typeName);
		var collectionName = collectionType.getPrefixedSymbolName("_"+typeName);
		var signatureName = collectionType.getOwnedSignature.getPrefixedSymbolName("_"+typeName+"_");
		var parameterName = collectionType.getOwnedSignature.getOwnedParameters().get(0).getPrefixedSymbolName("_"+typeName+"_T");
		var collectionTypeName = collectionType.eClass().getName();
	'''
		private final @NonNull «collectionTypeName» «collectionName» = standardLibrary.get«typeName»Type();
		@SuppressWarnings("null") private final @NonNull TemplateSignature «signatureName» = «collectionName».getOwnedSignature();
		@SuppressWarnings("null") private final @NonNull TemplateParameter «parameterName» = «signatureName».getOwnedParameters().get(0);
	'''
	}
	
	protected def String definePrimitiveTypeName(Set<Class> allTypes, String typeName) {
		var DataType primitiveType = allTypes.findPrimitiveType(typeName);
	'''
		private final @NonNull PrimitiveType «primitiveType.getPrefixedSymbolName("_"+typeName)» = standardLibrary.get«typeName»Type();
	'''}

	protected override String generateMetamodel(Model root) {
		thisModel = root;
		var Package pkg = root.ownedPackages.findPackage();
		if (pkg == null) {
			return null;
		}
		var allTypes = root.getAllTypes();
		'''
			/*******************************************************************************
			 * Copyright (c) 2010,2015 E.D.Willink and others.
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
			 * by: org.eclipse.ocl.examples.build.xtend.GenerateOCLmetamodel.xtend
			 * and: org.eclipse.ocl.examples.build.GeneratePivotMetamodel.mwe2
			 *
			 * Do not edit it.
			 *******************************************************************************/
			package	«javaPackageName»;
			
			import java.math.BigInteger;
			import java.util.List;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;
			import org.eclipse.ocl.pivot.*;
			import org.eclipse.ocl.pivot.Class;
			import org.eclipse.ocl.pivot.Package;
			import org.eclipse.ocl.pivot.ids.IdManager;
			import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
			import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
			import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
			import org.eclipse.ocl.pivot.internal.utilities.AbstractContents;
			import org.eclipse.ocl.pivot.library.LibraryFeature;
			import org.eclipse.ocl.pivot.model.OCLstdlib;
			import org.eclipse.ocl.pivot.utilities.ClassUtil;
			import org.eclipse.ocl.pivot.utilities.PivotUtil;
			
			/**
			 * This is the «uri» Pivot Model of the Pivot Model
			 * auto-generated from «sourceFile».
			 * It facilitates efficient model loading without the overheads of model reading.
			 */
			@SuppressWarnings({"nls", "unused"})
			public class «javaClassName» extends ASResourceImpl
			{
				/**
				 *	The URI of this Standard Library.
				 */
				public static final @NonNull String PIVOT_URI = "«uri»";
			
				public static @NonNull Package create(@NonNull StandardLibraryInternal standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
					«javaClassName» resource = new «javaClassName»(ClassUtil.nonNullEMF(URI.createURI(PIVOT_URI)));
					Contents contents = new Contents(standardLibrary, name, nsPrefix, nsURI);
					resource.getContents().add(contents.getModel());
					return contents.getPackage();
				}
			
				protected OCLmetamodel(@NonNull URI uri) {
					super(uri, OCLASResourceFactory.getInstance());
				}
			
				protected static class LibraryContents extends AbstractContents
				{
					protected final @NonNull StandardLibraryInternal standardLibrary;
			
					protected LibraryContents(@NonNull StandardLibraryInternal standardLibrary) {
						this.standardLibrary = standardLibrary;
					}
				}

				private static class Contents extends LibraryContents
				{
					private final @NonNull Model «root.getPrefixedSymbolName("root")»;
					«FOR pkge : root.getSortedPackages()»
					private final @NonNull «pkge.eClass().getName()» «pkge.getPrefixedSymbolName(if (pkge == root.getOrphanPackage()) "orphanage" else pkge.getName())»;
					«ENDFOR»

					«allTypes.defineCollectionTypeName("Bag")»
					
					«allTypes.definePrimitiveTypeName("Boolean")»
					
					«allTypes.defineCollectionTypeName("Collection")»
					
					«allTypes.definePrimitiveTypeName("Integer")»
					
					private final @NonNull Class _OclAny = standardLibrary.getOclAnyType();
					private final @NonNull Class _OclElement = standardLibrary.getOclElementType();
					
					«allTypes.defineCollectionTypeName("OrderedCollection")»
					
					«allTypes.defineCollectionTypeName("OrderedSet")»
					
					«allTypes.definePrimitiveTypeName("Real")»
					
					«allTypes.defineCollectionTypeName("Sequence")»
					
					«allTypes.defineCollectionTypeName("Set")»
					
					«allTypes.definePrimitiveTypeName("String")»
					
					«allTypes.definePrimitiveTypeName("UnlimitedNatural")»
					
					«allTypes.defineCollectionTypeName("UniqueCollection")»

					protected Contents(@NonNull StandardLibraryInternal standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
						super(standardLibrary);
						«root.getSymbolName()» = createModel("«pkg.getURI»");
						«FOR pkge : root.getSortedPackages()»
						«pkge.getSymbolName()» = create«pkge.eClass().getName()»("«pkge.getName()»", "«pkge.getNsPrefix()»", "«pkge.getURI()»", «if (pkge == root.getOrphanPackage()) "null" else "IdManager.METAMODEL"»);
						«ENDFOR»
						«root.installPackages()»
						«root.installClassTypes()»
						«root.installPrimitiveTypes()»
						«root.installEnumerations()»
						«root.installCollectionTypes()»
						«root.installLambdaTypes()»
						«root.installTupleTypes()»
						«root.installOperations()»
						«root.installIterations()»
						«root.installCoercions()»
						«root.installProperties()»
						«root.installTemplateBindings()»
						«root.installPrecedences()»
						«root.installComments()»
					}
					
					public @NonNull Model getModel() {
						return «root.getSymbolName()»;
					}
					
					public @NonNull Package getPackage() {
						return «ClassUtil.nonNullModel(root.getOnlyPackage()).getSymbolName()»;
					}
					«root.definePackages(null)»
					«root.declareClassTypes()»
					«root.declarePrimitiveTypes()»
					«root.declareEnumerations()»
					«root.defineTemplateParameters()»
					«root.declareCollectionTypes()»
					«root.declareTupleTypes()»
					«root.defineClassTypes()»
					«root.definePrimitiveTypes()»
					«root.defineEnumerations()»
					«root.defineCollectionTypes()»
					«root.defineTupleTypes()»
					«root.defineLambdaTypes()»
					«root.defineOperations()»
					«root.defineIterations()»
					«root.defineCoercions()»
					«root.declareProperties()»
					«root.defineProperties()»
					«root.defineTemplateBindings()»
					«root.definePrecedences()»
					«root.defineComments()»
				}
			}
		'''
	}
}