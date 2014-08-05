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

import java.util.HashSet
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.ocl.examples.pivot.AnyType
import org.eclipse.ocl.examples.pivot.CollectionType
import org.eclipse.ocl.examples.pivot.Comment
import org.eclipse.ocl.examples.pivot.EnumerationLiteral
import org.eclipse.ocl.examples.pivot.Iteration
import org.eclipse.ocl.examples.pivot.LambdaType
import org.eclipse.ocl.examples.pivot.Operation
import org.eclipse.ocl.examples.pivot.Parameter
import org.eclipse.ocl.examples.pivot.Precedence
import org.eclipse.ocl.examples.pivot.Property
import org.eclipse.ocl.examples.pivot.Root
import org.eclipse.ocl.examples.pivot.TemplateBinding
import org.eclipse.ocl.examples.pivot.TemplateParameter
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution
import org.eclipse.ocl.examples.pivot.TemplateSignature
import org.eclipse.ocl.examples.pivot.Type

public abstract class GenerateOCLCommonXtend extends GenerateOCLCommon
{
	protected def String declareCollectionTypes(org.eclipse.ocl.examples.pivot.Package pkg) {
		'''
			«FOR type : pkg.getRootPackage().getSortedCollectionTypes()»
				protected final @NonNull «type.eClass.name» «type.getPrefixedSymbolName("_" + type.partialName())» = create«type.
				eClass.name»("«type.name»"/*«type.elementType.name»*/, "«type.lower.toString()»", "«type.upper.toString()»");
			«ENDFOR»
		'''
	}

	protected def String declareEnumerations(org.eclipse.ocl.examples.pivot.Package pkg) {
		'''
			«FOR enumeration : pkg.getRootPackage().getSortedEnumerations()»
				«var enumerationName = enumeration.getPrefixedSymbolName("_" + enumeration.partialName())»
				protected final @NonNull Enumeration «enumerationName» = createEnumeration("«enumeration.name»");
				«FOR enumerationLiteral : enumeration.ownedLiteral»
					protected final @NonNull EnumerationLiteral «enumerationLiteral.getPrefixedSymbolName(
				"el_" + enumerationName + "_" + enumerationLiteral.name)» = createEnumerationLiteral("«enumerationLiteral.name»");
				«ENDFOR»
			«ENDFOR»
		'''
	}

	protected def String declareMetaclasses(org.eclipse.ocl.examples.pivot.Package pkg) {
		'''
			«FOR type : pkg.getRootPackage().getSortedMetaclasses()»
				protected final @NonNull Metaclass<?> «type.getPrefixedSymbolName("_" + type.partialName())» = createMetaclass("«type.
				name»");
			«ENDFOR»
		'''
	}

	protected def String declareOclTypes(org.eclipse.ocl.examples.pivot.Package pkg) {
		'''
			«FOR type : pkg.getSortedOclTypes()»
				protected final @NonNull «type.eClass.name» «type.getPrefixedSymbolName("_" + type.partialName())» = create«type.
				eClass.name»("«type.name»");
			«ENDFOR»
		'''
	}

	protected def String declareParameterTypes(org.eclipse.ocl.examples.pivot.Package pkg) {
		'''
			«FOR type : pkg.getRootPackage().getSortedParameterTypes()»
				protected final @NonNull Class «type.getPrefixedSymbolName("_" + type.partialName())» = createClass("«type.name»");
			«ENDFOR»
		'''
	}

	protected def String declarePrimitiveTypes(org.eclipse.ocl.examples.pivot.Package pkg) {'''
		«FOR type : pkg.getRootPackage().getSortedPrimitiveTypes()»
		protected final @NonNull PrimitiveType «type.getPrefixedSymbolName("_" + type.partialName())» = createPrimitiveType("«type.name»");
		«ENDFOR»
	'''}

	protected def String declareProperties(org.eclipse.ocl.examples.pivot.Package pkg) {
		var allProperties = getAllProperties(pkg.getRootPackage());
		'''
			«FOR property : allProperties»
				protected final @NonNull Property «property.getPrefixedSymbolName("pr_" + property.partialName())» = createProperty("«property.name»", «property.type.getSymbolName()»);
			«ENDFOR»
		'''
	}

	protected def String declareTupleTypes(org.eclipse.ocl.examples.pivot.Package pkg) {
		'''
			«FOR type : pkg.getRootPackage().getSortedTupleTypes()»
				protected final @NonNull TupleType «type.getPrefixedSymbolName("_" + type.partialName())» = createTupleType("«type.name»",
				«FOR property : type.getSortedTupleParts() BEFORE ("\t") SEPARATOR (",\n\t")»
				createProperty("«property.name»", «property.type.getSymbolName()»)«ENDFOR»);
			«ENDFOR»
		'''
	}

	protected def String defineCollectionTypes(org.eclipse.ocl.examples.pivot.Package pkg) {
		var org.eclipse.ocl.examples.pivot.Package orphanPackage = pkg.getOrphanPackage();
		'''
			protected void installCollectionTypes() {
				final List<Class> ownedTypes = «pkg.getSymbolName()».getOwnedType();
				«IF orphanPackage != null»
				final List<Class> orphanTypes = «orphanPackage.getSymbolName()».getOwnedType();
				«ENDIF»
				CollectionType type;
				List<Type> superClasses;
				«FOR type : pkg.getRootPackage().getSortedCollectionTypes()»
				«IF type.unspecializedElement == null»
				ownedTypes.add(type = «type.getSymbolName()»);
				«ELSE»
				orphanTypes.add(type = «type.getSymbolName()»);
				type.setUnspecializedElement(«type.unspecializedElement.getSymbolName()»);
				«ENDIF»
				type.setElementType(«type.elementType.getSymbolName()»);
				«type.emitSuperClasses()»
			«ENDFOR»
			}
		'''
	}

	protected def String defineComments(org.eclipse.ocl.examples.pivot.Package pkg) {
		'''
			protected void installComments() {
				«FOR pElement : pkg.getRootPackage().getSortedCommentedElements()»
				«FOR pComment : pElement.getSortedComments()»
					installComment(«pElement.getSymbolName()», "«pComment.javaString()»");
				«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String defineEnumerations(org.eclipse.ocl.examples.pivot.Package pkg) {
		'''
			protected void installEnumerations() {
				final List<Class> ownedTypes = «pkg.getSymbolName()».getOwnedType();
				Enumeration type;
				List<EnumerationLiteral> enumerationLiterals;
				«FOR enumeration : pkg.getRootPackage().getSortedEnumerations()»
					ownedTypes.add(type = «enumeration.getSymbolName()»);
					enumerationLiterals = type.getOwnedLiteral();
					«FOR enumerationLiteral : enumeration.ownedLiteral»
						enumerationLiterals.add(«enumerationLiteral.getSymbolName()»);
					«ENDFOR»
					type.getSuperClass().add(_Enumeration);
				«ENDFOR»
			}
		'''
	}

	protected def String defineIterations(org.eclipse.ocl.examples.pivot.Package pkg) {
		var List<Iteration> allIterations = pkg.getRootPackage().getSortedIterations();
		'''
			«IF allIterations.size() > 0»
				«FOR iteration : allIterations»
					protected final @NonNull Iteration «iteration.getPrefixedSymbolName("it_" + iteration.partialName())» = createIteration("«iteration.
					name»", «iteration.type.getSymbolName()», «IF iteration.implementationClass != null»"«iteration.
					implementationClass»", «iteration.implementationClass».INSTANCE«ELSE»null, null«ENDIF»);
				«ENDFOR»

			«ENDIF»
			protected void installIterations() {
				List<Operation> ownedIterations;
				List<Parameter> ownedParameters;
				Iteration iteration;
				Parameter parameter;
				«FOR type : allIterations.getSortedOwningTypes()»
					ownedIterations = «type.getSymbolName()».getOwnedOperation();
					«FOR iteration : type.getSortedIterations(allIterations)»
						ownedIterations.add(iteration = «iteration.getSymbolName()»);
						«IF iteration.isInvalidating»
							iteration.setIsInvalidating(true);
						«ENDIF»
						«IF !iteration.isRequired»
							iteration.setIsRequired(false);
						«ENDIF»
						«IF iteration.isStatic»
							iteration.setIsStatic(true);
						«ENDIF»
						«IF iteration.isValidating»
							iteration.setIsValidating(true);
						«ENDIF»
						«IF iteration.ownedIterator.size() > 0»
							ownedParameters = iteration.getOwnedIterator();
							«FOR parameter : iteration.ownedIterator»
								ownedParameters.add(parameter = createParameter("«parameter.name»", «parameter.type.getSymbolName()», «parameter.
				isRequired»));
								«IF !parameter.isRequired»
									parameter.setIsRequired(false);
								«ENDIF»
							«ENDFOR»
						«ENDIF»
						«IF iteration.ownedAccumulator.size() > 0»
							ownedParameters = iteration.getOwnedAccumulator();
							«FOR parameter : iteration.ownedAccumulator»
								ownedParameters.add(parameter = createParameter("«parameter.name»", «parameter.type.getSymbolName()», «parameter.
				isRequired»));
								«IF !parameter.isRequired»
									parameter.setIsRequired(false);
								«ENDIF»
							«ENDFOR»
						«ENDIF»
						«IF iteration.ownedParameter.size() > 0»
							ownedParameters = iteration.getOwnedParameter();
							«FOR parameter : iteration.ownedParameter»
								ownedParameters.add(parameter = createParameter("«parameter.name»", «parameter.type.getSymbolName()», «parameter.
				isRequired»));
								«IF !parameter.isRequired»
									parameter.setIsRequired(false);
								«ENDIF»
							«ENDFOR»
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String defineLambdaTypes(org.eclipse.ocl.examples.pivot.Package pkg) {
		var allLambdaTypes = pkg.getRootPackage().getSortedLambdaTypes();
		var orphanPackage = pkg.getOrphanPackage();
		'''
			«FOR type : allLambdaTypes»
				protected final @NonNull LambdaType «type.getPrefixedSymbolName("_" + type.partialName())» = createLambdaType("«type.
				name»");
			«ENDFOR»
			
			protected void installLambdaTypes() {
				final List<Class> orphanTypes = «orphanPackage.getSymbolName()».getOwnedType();
				LambdaType type;
				List<Type> superClasses;
				«FOR type : allLambdaTypes»
					orphanTypes.add(type = «type.getSymbolName()»);
					type.setContextType(«type.contextType.getSymbolName()»);
					«FOR parameterType : type.parameterType»
						type.getParameterType().add(«parameterType.getSymbolName()»);
					«ENDFOR»
					type.setResultType(«type.resultType.getSymbolName()»);
					«type.emitSuperClasses()»
				«ENDFOR»
			}
		'''
	}

	protected def String defineMetaclasses(org.eclipse.ocl.examples.pivot.Package pkg) {
		var allMetaclasses = pkg.getRootPackage().getSortedMetaclasses();
		var orphanPackage = pkg.getOrphanPackage();
		'''
			protected void installMetaclasses() {
				final List<Class> ownedTypes = «pkg.getSymbolName()».getOwnedType();
				«IF orphanPackage != null»
					final List<Class> orphanTypes = «orphanPackage.getSymbolName()».getOwnedType();
				«ENDIF»
				Metaclass<?> type;
				List<Type> superClasses;
				«FOR type : allMetaclasses»
					«IF type.unspecializedElement == null»
						ownedTypes.add(type = «type.getSymbolName()»);
					«ELSE»
						orphanTypes.add(type = «type.getSymbolName()»);
						type.setUnspecializedElement(«type.unspecializedElement.getSymbolName()»);
					«ENDIF»
					type.setInstanceType(«type.instanceType.getSymbolName()»);
					«type.emitSuperClasses()»
				«ENDFOR»
			}
		'''
	}

	protected def String defineOclTypes(org.eclipse.ocl.examples.pivot.Package pkg) {
		var allOclTypes = pkg.getSortedOclTypes();
		'''
			protected void installOclTypes() {
				final List<Class> ownedTypes = «pkg.getSymbolName()».getOwnedType();
				Class type;
				List<Type> superClasses;
				«FOR type : allOclTypes»
					ownedTypes.add(type = «type.getSymbolName()»);
					«IF !(type instanceof AnyType)»
						«type.emitSuperClasses()»
					«ENDIF»
				«ENDFOR»
			}
		'''
	}

	protected def String defineOperations(org.eclipse.ocl.examples.pivot.Package pkg) {
		var allOperations = pkg.getRootPackage().getSortedOperations();
		'''
			«FOR operation : allOperations»
				protected final @NonNull Operation «operation.getPrefixedSymbolName("op_" + operation.partialName())» = createOperation("«operation.
				name»", «operation.type.getSymbolName()», «IF operation.implementationClass != null»"«operation.
				implementationClass»", «operation.implementationClass».INSTANCE«ELSE»null, null«ENDIF»);
			«ENDFOR»
			
			protected void installOperations() {
				List<Operation> ownedOperations;
				List<Parameter> ownedParameters;
				Operation operation;
				Parameter parameter;
				«FOR type : allOperations.getSortedOwningTypes()»
					ownedOperations = «type.getSymbolName()».getOwnedOperation();
					«FOR operation : type.getSortedOperations(allOperations)»
						ownedOperations.add(operation = «operation.getSymbolName()»);
						«IF operation.isInvalidating»
							operation.setIsInvalidating(true);
						«ENDIF»
						«IF !operation.isRequired»
							operation.setIsRequired(false);
						«ENDIF»
						«IF operation.isStatic»
							operation.setIsStatic(true);
						«ENDIF»
						«IF operation.isValidating»
							operation.setIsValidating(true);
						«ENDIF»
						«IF operation.bodyExpression != null»
							operation.setBodyExpression(createExpressionInOCL(«operation.type.getSymbolName()», "«operation.bodyExpression.javaString()»"));
						«ENDIF»
						«IF operation.ownedParameter.size() > 0»
							ownedParameters = operation.getOwnedParameter();
							«FOR parameter : operation.ownedParameter»
								ownedParameters.add(parameter = createParameter("«parameter.name»", «parameter.type.getSymbolName()», «parameter.isRequired»));
							«ENDFOR»
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String definePackages(org.eclipse.ocl.examples.pivot.Package pkg0) {
		var rootPackage = pkg0.getRootPackage();
		var allPackages = rootPackage.getSortedPackages();
		var morePackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>(allPackages);
		morePackages.remove(pkg0);
		'''
			«IF morePackages.size() > 0»
				«FOR pkg1 : morePackages»
					protected final @NonNull «pkg1.eClass().name» «pkg1.getPrefixedSymbolName("pk_" + pkg1.partialName())» = create«pkg1.eClass().name»("«pkg1.name»", «IF pkg1.nsPrefix != null»"«pkg1.nsPrefix»"«ELSE»null«ENDIF», «IF pkg1.nsURI != null»"«pkg1.nsURI»"«ELSE»null«ENDIF», null);
				«ENDFOR»

			«ENDIF»
			protected void installPackages() {
				«emitRoot(rootPackage)»
				«IF allPackages.size() > 0»
				«FOR pkg2 : allPackages»
				«emitPackage(pkg2)»
				«ENDFOR»
				«ENDIF»
			}
		'''
	}

	protected def String defineParameterTypes(org.eclipse.ocl.examples.pivot.Package pkg) {
		'''
			protected void installParameterTypes() {
			}
		'''
	}

	protected def String definePrecedences(org.eclipse.ocl.examples.pivot.Package pkg) {
		var allLibraries = pkg.getRootPackage().getSortedLibraries();
		var allOperations = pkg.getRootPackage().getSortedOperationsWithPrecedence();
		'''
			«IF allLibraries.size() > 0»
				protected void installPrecedences() {
					«FOR lib : allLibraries»
						«var allPrecedences = lib.getSortedPrecedences()»
						«FOR precedence : allPrecedences»
							final Precedence «precedence.getPrefixedSymbolName("prec_" + precedence.partialName())» = createPrecedence("«precedence.name»", AssociativityKind.«precedence.associativity.toString().toUpperCase()»);
						«ENDFOR»

						final List<Precedence> ownedPrecedences = «lib.getSymbolName()».getOwnedPrecedence();
						«FOR precedence : lib.ownedPrecedence»
							ownedPrecedences.add(«precedence.getSymbolName()»);
						«ENDFOR»
					«ENDFOR»

					«FOR operation : allOperations»
						«operation.getSymbolName()».setPrecedence(«operation.precedence.getSymbolName()»);
					«ENDFOR»
				}
			«ENDIF»
		'''
	}

	protected def String definePrimitiveTypes(org.eclipse.ocl.examples.pivot.Package pkg) {
		var allTypes = pkg.getRootPackage().getSortedPrimitiveTypes();
		'''
			protected void installPrimitiveTypes() {
				final List<Class> ownedTypes = «pkg.getSymbolName()».getOwnedType();
				PrimitiveType type;
				«FOR type : allTypes»
					«var superClasses = type.getSuperclassesInPackage()»
					ownedTypes.add(type = «type.getSymbolName()»);
					«FOR superClass : superClasses»
						type.getSuperClass().add(«superClass.getSymbolName()»);
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String defineProperties(org.eclipse.ocl.examples.pivot.Package pkg) {
		var allProperties = getAllProperties(pkg.getRootPackage());
		'''
			protected void installProperties() {
				List<Property> ownedProperties;
				Property property;
				«FOR type : allProperties.getSortedOwningTypes2()»
					ownedProperties = «type.getSymbolName()».getOwnedAttribute();
					«FOR property : type.getSortedProperties(allProperties)»
						ownedProperties.add(property = «property.getSymbolName()»);
						«IF property.isComposite»
							property.setIsComposite(true);
						«ENDIF»
						«IF property.isDerived»
							property.setIsDerived(true);
						«ENDIF»
						«IF property.isID»
							property.setIsID(true);
						«ENDIF»
						«IF property.implicit»
							property.setImplicit(true);
						«ENDIF»
						«IF property.isReadOnly»
							property.setIsReadOnly(true);
						«ENDIF»
						«IF !property.isRequired»
							property.setIsRequired(false);
						«ENDIF»
						«IF property.isResolveProxies»
							property.setIsResolveProxies(true);
						«ENDIF»
						«IF property.isStatic»
							property.setIsStatic(true);
						«ENDIF»
						«IF property.isTransient»
							property.setIsTransient(true);
						«ENDIF»
						«IF property.isUnsettable»
							property.setIsUnsettable(true);
						«ENDIF»
						«IF property.isVolatile»
							property.setIsVolatile(true);
						«ENDIF»
						«IF property.opposite != null»
							property.setOpposite(«property.opposite.getSymbolName()»);
						«ENDIF»
						«IF property.implementationClass != null»
							property.setImplementationClass("«property.implementationClass»");
							property.setImplementation(«property.implementationClass».INSTANCE);
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String defineTemplateBindings(org.eclipse.ocl.examples.pivot.Package pkg) {
		var allTemplateableElements = pkg.getRootPackage().getSortedTemplateableElements();
		'''
			protected void installTemplateBindings() {
				«FOR templateableElement : allTemplateableElements»
					«FOR templateBinding : templateableElement.templateBinding»
						«templateableElement.getSymbolName()».getTemplateBinding().add(createTemplateBinding(«templateBinding.signature.getSymbolName()»,
							«FOR templateParameterSubstitution : templateBinding.parameterSubstitution SEPARATOR (",\n")»
							createTemplateParameterSubstitution(«templateParameterSubstitution.formal.getSymbolName()», «templateParameterSubstitution.actual.getSymbolName()»)«ENDFOR»));
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}

	protected def String defineTemplateSignatures(org.eclipse.ocl.examples.pivot.Package pkg) {
		var allTemplateParameters = pkg.getRootPackage().getSortedTemplateParameters();
		var allTemplateSignatures = pkg.getRootPackage().getSortedTemplateSignatures();
		'''
			«FOR templateParameter : allTemplateParameters»
			protected final @NonNull TypeTemplateParameter «templateParameter.getPrefixedSymbolName(
						"tp_" + templateParameter.partialName())» = createTypeTemplateParameter(«templateParameter.
						ownedParameteredElement.getSymbolName()»);
			«ENDFOR»
			
			«FOR templateSignature : allTemplateSignatures»
			protected final @NonNull TemplateSignature «templateSignature.getPrefixedSymbolName(
						"ts_" + templateSignature.partialName())» = createTemplateSignature(«templateSignature.template.getSymbolName()»«FOR templateParameter : templateSignature.
						ownedParameter», «templateParameter.getSymbolName()»«ENDFOR»);
			«ENDFOR»
			
			protected void installTemplateSignatures() {
			}
		'''
	}

	protected def String defineTupleTypes(org.eclipse.ocl.examples.pivot.Package pkg) {
		var allTupleTypes = pkg.getRootPackage().getSortedTupleTypes();
		var orphanPackage = pkg.getOrphanPackage();
		'''
			protected void installTupleTypes() {
				final List<Class> orphanTypes = «orphanPackage.getSymbolName()».getOwnedType();
				TupleType type;
				List<Type> superClasses;
				«FOR type : allTupleTypes»
					orphanTypes.add(type = «type.getSymbolName()»);
					«FOR property : type.getSortedProperties()»
						«IF property.implementationClass != null»
							«property.getSymbolName()».setImplementationClass("«property.implementationClass»");
							«property.getSymbolName()».setImplementation(«property.implementationClass».INSTANCE);
						«ENDIF»
					«ENDFOR»
					«type.emitSuperClasses()»
				«ENDFOR»
			}
		'''
	}

	protected def String emitCreateProperty(Property property) {
		return "createProperty(" + property.name + ", " + property.type.getSymbolName() + ")";
	}

	protected def String emitPackage(org.eclipse.ocl.examples.pivot.Package pkg) {
		'''
			«FOR nestedPackage : pkg.getSortedPackages()»
				«IF nestedPackage.getNestedPackage().size() > 0»
					«emitPackage(nestedPackage)»
				«ENDIF»
				«pkg.getSymbolName()».getNestedPackage().add(«nestedPackage.getSymbolName()»);
			«ENDFOR»
		'''
	}

	protected def String emitRoot(Root pkg) {
		'''
			«FOR nestedPackage : pkg.getSortedPackages()»
				«IF nestedPackage.getNestedPackage().size() > 0»
					«emitPackage(nestedPackage)»
				«ENDIF»
				«pkg.getSymbolName()».getNestedPackage().add(«nestedPackage.getSymbolName()»);
			«ENDFOR»
		'''
	}

	protected def String emitSuperClasses(Type type) {
		var superClasses = type.getSuperclassesInPackage();
		'''
			«IF superClasses.size() > 0»
				superClasses = type.getSuperClass();
				«FOR superClass : superClasses»
					superClasses.add(«superClass.getSymbolName()»);
				«ENDFOR»
			«ELSEIF (type instanceof CollectionType)»
				superClasses = type.getSuperClass();
				superClasses.add(_OclAny);
			«ELSEIF !(type instanceof AnyType)»
				superClasses = type.getSuperClass();
				superClasses.add(_OclElement);
			«ENDIF»
		'''
	}

	protected override String partialName(EObject element) {
		switch element {
			CollectionType case element.elementType == null: return element.javaName()
			CollectionType: return element.javaName() + "_" + element.elementType.partialName()
//			InvalidType: return "invalid"		
			LambdaType case element.contextType == null: return "null"
			LambdaType: return element.javaName() + "_" + element.contextType.partialName()
//			VoidType: return "void"		
			Type case element.getTemplateParameter() != null: return element.getTemplateParameter().simpleName() + "_" + element.javaName()
			Type case element.templateBinding.size() > 0: return '''«element.javaName()»«FOR TemplateParameterSubstitution tps : element.getTemplateParameterSubstitutions()»_«tps.actual.simpleName()»«ENDFOR»'''
			Type: return element.javaName()
			Comment case element.body == null: return "null"
			Comment: return element.javaName(element.body.substring(0, Math.min(11, element.body.length() - 1)))
			EnumerationLiteral case element.enumeration == null: return "null"
			EnumerationLiteral: return element.enumeration.partialName() + "_" + element.javaName()
			Operation case element.owningType == null: return "null_" + element.javaName()
			Operation: return element.owningType.partialName() + "_" + element.javaName()
			org.eclipse.ocl.examples.pivot.Package: return element.javaName()
			Parameter case element.eContainer() == null: return "null_" + element.javaName()
			Parameter: return element.eContainer().partialName() + "_" + element.javaName()
			Precedence: return element.javaName()
			Property: return getPartialName(element)
			TemplateBinding case element.signature.template == null: return "null"
			TemplateBinding: return element.boundElement.partialName()
			TemplateParameter case element.signature.template == null: return "[" + element.signature.partialName() + "]"
			TemplateParameter case element.parameteredElement == null: return element.signature.template.partialName()
			TemplateParameter case true: return element.signature.template.partialName()
			TemplateParameter: return element.signature.template.partialName() + "_" + element.parameteredElement.simpleName()
			TemplateParameterSubstitution case element.templateBinding == null: return "null"
			TemplateParameterSubstitution case element.templateBinding.boundElement == null: return "null"
			TemplateParameterSubstitution: return element.templateBinding.boundElement.partialName()
			TemplateSignature case element.template == null: return "null"
			TemplateSignature: return element.template.partialName()
			default: return "xyzzy" + element.eClass().name
		}		
	}

	protected def String simpleName(EObject element) {
		switch element {
//			InvalidType: return "invalid"		
//			VoidType: return "void"		
			TemplateParameter case element.signature.template == null: return "null"
			TemplateParameter: return element.signature.template.simpleName()
			TemplateParameterSubstitution case element.templateBinding == null: return "null"
			TemplateParameterSubstitution case element.templateBinding.boundElement == null: return "null"
			TemplateParameterSubstitution: return element.templateBinding.boundElement.simpleName()
			Type case element.getTemplateParameter() == null: return element.javaName()
			Type: return element.getTemplateParameter().simpleName() + "_" + element.javaName()
			Operation case element.owningType == null: return "null_" + element.javaName()
			Operation: return element.owningType.simpleName() + "_" + element.javaName()
			default: return "xyzzy" + element.eClass().name
		}		
	}
}
