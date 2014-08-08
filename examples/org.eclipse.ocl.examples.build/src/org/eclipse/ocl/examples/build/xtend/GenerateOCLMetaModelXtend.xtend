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
import org.eclipse.ocl.examples.pivot.CollectionType
import org.eclipse.ocl.examples.pivot.DataType
import org.eclipse.ocl.examples.pivot.Package
import org.eclipse.ocl.examples.pivot.Root

public class GenerateOCLMetaModelXtend extends GenerateOCLMetaModel
{
	protected override String declareEnumerations(Package pkg) {
		var allEnumerations = pkg.getRootPackage().getSortedEnumerations();
	'''
		«FOR enumeration : allEnumerations»
			«var enumerationName = enumeration.getPrefixedSymbolName("_"+enumeration.partialName())»
			protected final @NonNull Enumeration «enumerationName» = createEnumeration(«getEcoreLiteral(enumeration)»);
			«FOR enumerationLiteral : enumeration.ownedLiteral»
			protected final @NonNull EnumerationLiteral «enumerationLiteral.getPrefixedSymbolName("el_"+enumerationName+"_"+enumerationLiteral.name)» = createEnumerationLiteral(«getEcoreLiteral(enumerationLiteral)»);
			«ENDFOR»
		«ENDFOR»
	'''}
	
	protected override String declareOclTypes(Package pkg) {
		var allOclTypes = pkg.getSortedOclTypes();
	'''
		«FOR type : allOclTypes»
		protected final @NonNull «type.eClass().name» «type.getPrefixedSymbolName("_"+type.partialName())» = create«type.eClass().name»(«getEcoreLiteral(type)»);
		«ENDFOR»
	'''}
	
	protected override String declareProperties(Package pkg) {
		var allProperties = getAllProperties(pkg.getRootPackage());
	'''
			«FOR type : allProperties.getSortedOwningTypes2()»
				«FOR property : type.getSortedProperties(allProperties)»
					protected final @NonNull Property «property.getPrefixedSymbolName("pr_"+property.partialName())» = createProperty(«getEcorePropertyLiteral(property)», «property.type.getSymbolName()»);
				«ENDFOR»
			«ENDFOR»
	'''}
	
	protected def String defineCollectionTypeName(Set<org.eclipse.ocl.examples.pivot.Class> allTypes, String typeName) {
		var CollectionType collectionType = allTypes.findCollectionType(typeName);
		var collectionName = collectionType.getPrefixedSymbolName("_"+typeName);
		var signatureName = collectionType.ownedTemplateSignature.getPrefixedSymbolName("_"+typeName+"_");
		var parameterName = collectionType.ownedTemplateSignature.getOwnedParameter().get(0).getPrefixedSymbolName("_"+typeName+"_T");
	'''
		protected final @NonNull CollectionType «collectionName» = standardLibrary.get«typeName»Type();
		@SuppressWarnings("null") protected final @NonNull TemplateSignature «signatureName» = «collectionName».getOwnedTemplateSignature();
		@SuppressWarnings("null") protected final @NonNull TemplateParameter «parameterName» = «signatureName».getOwnedParameter().get(0);
	'''
	}
	
	protected def String definePrimitiveTypeName(Set<org.eclipse.ocl.examples.pivot.Class> allTypes, String typeName) {
		var DataType primitiveType = allTypes.findPrimitiveType(typeName);
	'''
		protected final @NonNull PrimitiveType «primitiveType.getPrefixedSymbolName("_"+typeName)» = standardLibrary.get«typeName»Type();
	'''}

	protected override String generateMetamodel(Root root) {
		var Package pkg = root.ownedPackages.findPackage();
		if (pkg == null) {
			return null;
		}
		var allMetaclasses  = root.getAllMetaclasses();
		var allCollectionTypes = root.getAllCollectionTypes();
		var allEnumerations = root.getAllEnumerations();
		var allLambdaTypes = root.getAllLambdaTypes();
		var allPrecedences = root.getAllPrecedences();
		var allPrimitiveTypes = root.getAllPrimitiveTypes();
		var allTemplateBindings = root.getAllTemplateBindings();
		var allTemplateSignatures = root.getAllTemplateSignatures();
		var allTupleTypes = root.getAllTupleTypes();
		var allTypes = root.getAllTypes();
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
			 * by: org.eclipse.ocl.examples.build.xtend.GenerateOCLMetaModel.xtend
			 * and: org.eclipse.ocl.examples.build.GeneratePivotMetaModel.mwe2
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
			import org.eclipse.ocl.examples.domain.ids.IdManager;
			import org.eclipse.ocl.examples.domain.library.LibraryFeature;
			import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
			import org.eclipse.ocl.examples.pivot.*;
			import org.eclipse.ocl.examples.pivot.Class;
			import org.eclipse.ocl.examples.pivot.Package;
			import org.eclipse.ocl.examples.pivot.manager.PivotStandardLibrary;
			import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
			import org.eclipse.ocl.examples.pivot.resource.ASResourceImpl;
			import org.eclipse.ocl.examples.pivot.resource.OCLASResourceFactory;
			import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
			
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
			
				public static @NonNull Package create(@NonNull PivotStandardLibrary standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
					«javaClassName» resource = new «javaClassName»(DomainUtil.nonNullEMF(URI.createURI(PIVOT_URI)));
					Contents contents = new Contents(standardLibrary, name, nsPrefix, nsURI);
					resource.getContents().add(contents.root);
					return contents.metamodel;
				}
			
				protected OCLMetaModel(@NonNull URI uri) {
					super(uri, OCLASResourceFactory.INSTANCE);
				}
			
				protected static class LibraryContents extends AbstractContents
				{
					protected final @NonNull PivotStandardLibrary standardLibrary;
			
					protected LibraryContents(@NonNull PivotStandardLibrary standardLibrary) {
						this.standardLibrary = standardLibrary;
					}
				}

				protected static class Contents extends LibraryContents
				{
					protected final @NonNull Root «root.getPrefixedSymbolName("root")»;
					protected final @NonNull Package «pkg.getPrefixedSymbolName("metamodel")»;
					«allTypes.defineCollectionTypeName("Bag")»
					
					«allTypes.definePrimitiveTypeName("Boolean")»
					
					«allTypes.defineCollectionTypeName("Collection")»
					
					«allTypes.definePrimitiveTypeName("Integer")»
					
					protected final @NonNull Class _OclAny = standardLibrary.getOclAnyType();
					protected final @NonNull Class _OclElement = standardLibrary.getOclElementType();
					
					«allTypes.defineCollectionTypeName("OrderedCollection")»
					
					«allTypes.defineCollectionTypeName("OrderedSet")»
					
					«allTypes.definePrimitiveTypeName("Real")»
					
					«allTypes.defineCollectionTypeName("Sequence")»
					
					«allTypes.defineCollectionTypeName("Set")»
					
					«allTypes.definePrimitiveTypeName("String")»
					
					«allTypes.definePrimitiveTypeName("UnlimitedNatural")»
					
					«allTypes.defineCollectionTypeName("UniqueCollection")»

					protected Contents(@NonNull PivotStandardLibrary standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
						super(standardLibrary);
						«root.getSymbolName()» = createRoot("«pkg.getURI»");
						«pkg.getSymbolName()» = createPackage(name, nsPrefix, nsURI, IdManager.METAMODEL);
						installPackages();
						installOclTypes();
						«IF allPrimitiveTypes.size() > 0»
						installPrimitiveTypes();
						«ENDIF»
						«IF allEnumerations.size() > 0»
						installEnumerations();
						«ENDIF»
						installParameterTypes();
						«IF allCollectionTypes.size() > 0»
						installCollectionTypes();
						«ENDIF»
						«IF allMetaclasses.size() > 0»
						installMetaclasses();
						«ENDIF»
						«IF allLambdaTypes.size() > 0»
						installLambdaTypes();
						«ENDIF»
						«IF allTupleTypes.size() > 0»
						installTupleTypes();
						«ENDIF»
						installOperations();
						installIterations();
						installProperties();
						«IF allTemplateSignatures.size() > 0»
						installTemplateSignatures();
						«ENDIF»
						«IF allTemplateBindings.size() > 0»
						installTemplateBindings();
						«ENDIF»
						«IF allPrecedences.size() > 0»
						installPrecedences();
						«ENDIF»
						installComments();
					}
				
					«pkg.definePackages()»

					«pkg.declareOclTypes()»
					«IF allPrimitiveTypes.size() > 0»

					«pkg.declarePrimitiveTypes()»
					«ENDIF»
					«IF allEnumerations.size() > 0»

					«pkg.declareEnumerations()»
					«ENDIF»

					«pkg.declareParameterTypes()»
					«IF allCollectionTypes.size() > 0»

					«pkg.declareCollectionTypes()»
					«ENDIF»
					«IF allMetaclasses.size() > 0»

					«pkg.declareMetaclasses()»
					«ENDIF»
					«IF allTupleTypes.size() > 0»

					«pkg.declareTupleTypes()»
					«ENDIF»

					«pkg.defineOclTypes()»

					«pkg.definePrimitiveTypes()»
					«IF allEnumerations.size() > 0»

					«pkg.defineEnumerations()»
					«ENDIF»

					«pkg.defineParameterTypes()»
					«IF allCollectionTypes.size() > 0»

					«pkg.defineCollectionTypes()»
					«ENDIF»
					«IF allMetaclasses.size() > 0»

					«pkg.defineMetaclasses()»
					«ENDIF»
					«IF allTupleTypes.size() > 0»

					«pkg.defineTupleTypes()»
					«ENDIF»	
					«IF allLambdaTypes.size() > 0»

					«pkg.defineLambdaTypes()»	
					«ENDIF»	

					«pkg.defineOperations()»

					«pkg.defineIterations()»	

					«pkg.declareProperties()»

					«pkg.defineProperties()»
					«IF allTemplateSignatures.size() > 0»

					«pkg.defineTemplateSignatures()»
					«ENDIF»
					«IF allTemplateBindings.size() > 0»

					«pkg.defineTemplateBindings()»
					«ENDIF»
					«IF allPrecedences.size() > 0»

					«pkg.definePrecedences()»
					«ENDIF»

					«pkg.defineComments()»
				}
			}
		'''
	}
}