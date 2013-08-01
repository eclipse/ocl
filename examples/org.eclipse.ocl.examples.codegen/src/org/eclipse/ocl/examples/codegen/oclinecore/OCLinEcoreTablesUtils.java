/**
 * <copyright>
 *
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.oclinecore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.common.NameQueries;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.domain.ids.BuiltInTypeId;
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.LibraryConstants;
import org.eclipse.ocl.examples.library.executor.ExecutorLambdaType;
import org.eclipse.ocl.examples.library.executor.ExecutorSpecializedType;
import org.eclipse.ocl.examples.library.executor.ExecutorTupleType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.xtext.util.Strings;

public class OCLinEcoreTablesUtils
{	
	public Comparator<DomainParameterTypes> templateBindingNameComparator = new Comparator<DomainParameterTypes>()
	{
		public int compare(DomainParameterTypes o1, DomainParameterTypes o2) {
			assert o1 != null && o2 != null;
			String n1 = getTemplateBindingsName(o1);
			String n2 = getTemplateBindingsName(o2);
			return n1.compareTo(n2);
		}
	};

	public static Comparator<Nameable> nameComparator = new Comparator<Nameable>()
	{
		public int compare(Nameable o1, Nameable o2) {
			String n1 = String.valueOf(o1.getName());
			String n2 = String.valueOf(o2.getName());
			return n1.compareTo(n2);
		}
	};

	public static Comparator<Property> propertyComparator = new Comparator<Property>()
	{
		public int compare(Property p1, Property p2) {
			String n1 = String.valueOf(p1.getName());
			String n2 = String.valueOf(p2.getName());
			int diff = n1.compareTo(n2);
			if (diff != 0) {
				return diff;
			}
			Property o1 = p1.getOpposite();
			Property o2 = p2.getOpposite();
			if (o1 == null) {
				if (o2 == null) {
					return 0;
				}
				else {
					return 1;
				}
			}
			else {
				if (o2 == null) {
					return -1;
				}
				else {
					n1 = String.valueOf(o1.getName());
					n2 = String.valueOf(o2.getName());
					return n1.compareTo(n2);
				}
			}
		}
	};
	
	public static Comparator<Operation> signatureComparator = new Comparator<Operation>()
	{
		public int compare(Operation o1, Operation o2) {
			assert o1 != null && o2 != null;
			String n1 = String.valueOf(getSignature(o1));
			String n2 = String.valueOf(getSignature(o2));
			return n1.compareTo(n2);
		}
	};

	private static <T extends GenPackage> T getLibraryGenPackage(List<T> genPackages) {
		for (T genPackage : genPackages) {
			EPackage ecorePackage = genPackage.getEcorePackage();
			EClassifier eClassifier = ecorePackage.getEClassifier("_Dummy");		// FIXME
			if (eClassifier != null) {
				return genPackage;
			}
		}		
		return null;
	}

	private static @Nullable <T extends GenPackage> T getMetaModelGenPackage(@NonNull List<T> genPackages) {
		for (T genPackage : genPackages) {
			EPackage ecorePackage = genPackage.getEcorePackage();
			EClassifier eClassifier = ecorePackage.getEClassifier("Element");
			if (eClassifier != null) {
				return genPackage;
			}
		}		
		return null;
	}

	private static @Nullable <T extends GenClassifier> T getNamedElement1(@Nullable List<T> genClasses, @NonNull String name) {
		if (genClasses != null) {
			for (T genClass : genClasses) {
				if (genClass.getName().equals(name)) {
					return genClass;
				}
			}
		}
		return null;
	}

	private static @Nullable <T extends GenFeature> T getNamedElement2(@Nullable List<T> genClasses, @NonNull String name) {
		if (genClasses != null) {
			for (T genClass : genClasses) {
				if (genClass.getName().equals(name)) {
					return genClass;
				}
			}
		}
		return null;
	}
	
	public static @NonNull Boolean isBuiltInType(@NonNull Type type) {
//		System.out.println(DomainUtil.debugSimpleName(type) + " + " + DomainUtil.debugSimpleName(type.getTypeId()) + " + " + type.getTypeId());
		return type.getTypeId() instanceof BuiltInTypeId;
	}

	private static @NonNull GenPackage loadGenPackage(@NonNull ResourceSet resourceSet, @NonNull URI genModelURI) {
		Resource resource = resourceSet.getResource(genModelURI, true);
		GenModel genModel = (GenModel) resource.getContents().get(0);
		GenPackage genPackage = genModel.getGenPackages().get(0);
		assert genPackage != null;
		return genPackage;
	}
	
	public static class CodeGenString
	{
		private final @NonNull StringBuilder s = new StringBuilder();
		private Map<String, String> classReferences = new HashMap<String, String>();
		
		protected final @NonNull Map<Type, String> typeNameMap = new HashMap<Type, String>();
		protected final @NonNull Set<String> typeNameUse = new HashSet<String>();
		
		public void append(@Nullable String string) {
			if (string != null) {
				s.append(string);
			}
		}

		public void addClassReference(@NonNull Class<?> referencedClass) {
			@SuppressWarnings("null")@NonNull String simpleName = referencedClass.getSimpleName();
			@SuppressWarnings("null")@NonNull String fullName = referencedClass.getName();
			addClassReference(simpleName, fullName);
		}

		protected String addClassReference(@NonNull String simpleName, @NonNull String fullName) {
			return classReferences.put(simpleName, fullName);
		}

		public void appendClassReference(@NonNull Class<?> referencedClass) {
//			s.append("<%");
			s.append(referencedClass.getSimpleName());
//			s.append("%>");
			addClassReference(referencedClass);
		}

		public void appendClassReference(@NonNull String referencedClass) {
			String key = referencedClass;
			int i = referencedClass.lastIndexOf(".");
			if (i > 0) {
				@SuppressWarnings("null")@NonNull String trimmedKey = referencedClass.substring(i+1);
				key = trimmedKey;
				s.append(key);
			}
			else {
//				s.append("<%");
				s.append(referencedClass);
//				s.append("%>");
			}
			addClassReference(key, referencedClass);
		}

		public void appendName(@NonNull NamedElement namedElement) {
			s.append(AbstractGenModelHelper.encodeName(namedElement));
		}

		/**
		 * Append the encoded name of a type with an _ prefix. The usage of the name is known to be unique to a particular package.
		 */
		public void appendScopedTypeName(@NonNull Type theType) {
			s.append("_" + AbstractGenModelHelper.encodeName(theType));
		}

		protected void appendString(@NonNull String string) {
			@SuppressWarnings("null")@NonNull String javaString = Strings.convertToJavaString(string);
			s.append("\"");
			s.append(javaString);
			s.append("\"");
		}

		/**
		 * Append the encoded name of a type with a suffix if disambiguation acros packages is required.
		 */
		public void appendUnscopedTypeName(@NonNull Type theType) {
			s.append(getTypeName(theType));
		}
		
		private @NonNull String getTypeName(@NonNull Type theType) {
			String name = typeNameMap.get(theType);
			if (name != null) {
				return name;
			}
			name = AbstractGenModelHelper.encodeName(theType);
			if (typeNameUse.contains(name)) {
				int index = 1;
				String candidateName = name + '_' + index;
				while (typeNameUse.contains(name + '_' + index)) {
					index++;
				}
				name = candidateName;
			}
			typeNameMap.put(theType, name);
			typeNameUse.add(name);
			return name;
		}

		public @NonNull List<String> getClassReferences() {
			List<String> names = new ArrayList<String>(classReferences.values());
			Collections.sort(names);
			return names;
		}
		
		@Override
		public @NonNull String toString() {
			@SuppressWarnings("null")@NonNull String string = s.toString();
			return string;
		}
	}

	public class DeclareParameterTypeVisitor extends AbstractExtendingVisitor<Object, Object>
	{
		protected DeclareParameterTypeVisitor(@NonNull Object context) {
			super(context);
		}

		public @Nullable Object visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException("Unsupported DeclareParameterTypeVisitor for " + visitable.eClass().getName());
		}

		@Override
		public @Nullable Object visitCollectionType(@NonNull CollectionType type) {
			s.append("new ");
			s.appendClassReference(ExecutorSpecializedType.class);
			s.append("(LIBRARY, ");
			s.appendString(DomainUtil.nonNullModel(type.getName()));
			s.append(", ");
			type.getElementType().accept(this);
			s.append(")");
			return null;
		}

		@Override
		public @Nullable Object visitLambdaType(@NonNull LambdaType lambdaType) {
			s.append("new ");
			s.appendClassReference(ExecutorLambdaType.class);
			s.append("(LIBRARY, ");
			s.appendString(DomainUtil.nonNullModel(lambdaType.getName()));
			s.append(", ");
			lambdaType.getContextType().accept(this);
			for (Type parameterType : lambdaType.getParameterType()) {
				s.append(", ");
				parameterType.accept(this);
			}
			s.append(")");
			return null;
		}

		@Override
		public @Nullable Object visitMetaclass(@NonNull Metaclass<?> metaclass) {
			s.append("new ");
			s.appendClassReference(ExecutorSpecializedType.class);
			s.append("(LIBRARY, ");
			s.appendString(DomainUtil.nonNullModel(metaclass.getName()));
			s.append(", ");
			metaclass.getInstanceType().accept(this);
			s.append(")");
			return null;
		}

		@Override
		public @Nullable Object visitTupleType(@NonNull TupleType tupleType) {
			s.append("new ");
			s.appendClassReference(ExecutorTupleType.class);
			s.append("(LIBRARY, ");
			s.appendString(DomainUtil.nonNullModel(tupleType.getName()));
			s.append(", ");
			for (Property part : tupleType.getOwnedAttribute()) {
				s.append(", ");
				part.getType().accept(this);
			}
			s.append(")");
			return null;
		}		

		@Override
		public @Nullable Object visitType(@NonNull Type type) {
			TemplateParameter owningTemplateParameter = type.getOwningTemplateParameter();
			if (owningTemplateParameter == null) {
				type.accept(emitQualifiedLiteralVisitor);
			}
			else if (owningTemplateParameter.getSignature().getTemplate() instanceof Type) {
				Type containerType = (Type) owningTemplateParameter.getSignature().getTemplate();
				assert containerType != null;
				String prefix = getQualifiedTablesClassName(containerType);
				if (prefix.length() <= 0) {
					s.append("(");
					s.appendClassReference(DomainType.class);
					s.append(")null/*containerType._package.name/");
				}
				else {
					s.appendClassReference(prefix);
					s.append(".TypeParameters.");
					s.appendScopedTypeName(containerType);
					s.append("_");
					s.appendUnscopedTypeName(type);
				}
			}
			else if (owningTemplateParameter.getSignature().getTemplate() instanceof Operation) {
				Operation containerOperation  = (Operation) owningTemplateParameter.getSignature().getTemplate();
				Type containerType = containerOperation.getOwningType();
				assert containerType != null;
				String prefix = getQualifiedTablesClassName(containerType);
				if (prefix.length() <= 0) {
					s.append("(");
					s.appendClassReference(DomainType.class);
					s.append(")null/*containerOperation.owningType._package.name/");
				}
				else {
					s.appendClassReference(prefix);
					s.append(".TypeParameters._");
					containerOperation.accept(emitLiteralVisitor);
					s.append("_");
					s.appendUnscopedTypeName(type);
				}
			}
			return null;
		}		
	}

	public class EmitLiteralVisitor extends AbstractExtendingVisitor<Object, Object>
	{
		protected EmitLiteralVisitor(@NonNull Object context) {
			super(context);
		}

		public @Nullable Object visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException("Unsupported EmitLiteralVisitor for " + visitable.eClass().getName());
		}

		@Override
		public @Nullable Object visitCollectionType(@NonNull CollectionType type) {
			CollectionType unspecializedType = PivotUtil.getUnspecializedTemplateableElement(type);
//			s.appendClassReference(getQualifiedTablesClassName(unspecializedType));
			s.append("Types.");
			s.appendScopedTypeName(unspecializedType);
			return null;
		}

		@Override
		public @Nullable Object visitConstraint(@NonNull Constraint constraint) {
			Type type = DomainUtil.nonNullModel((Type) constraint.eContainer());
			s.appendScopedTypeName(type);
			s.append("__");
			s.append(NameQueries.getUniqueText(type, constraint));
			return null;
		}

		@Override
		public @Nullable Object visitEnumerationLiteral(@NonNull EnumerationLiteral enumerationLiteral) {
			Enumeration enumeration = DomainUtil.nonNullModel(enumerationLiteral.getEnumeration());
//			s.appendClassReference(getQualifiedTablesClassName(enumeration));
			s.append("EnumerationLiterals.");
			s.appendScopedTypeName(enumeration);
			s.append("__");
			s.appendName(enumerationLiteral);
			return null;
		}

		@Override
		public @Nullable Object visitOperation(@NonNull Operation operation) {
			s.appendScopedTypeName(DomainUtil.nonNullModel(operation.getOwningType()));
			s.append("__");
			s.appendName(operation);
			return null;
		}

		@Override
		public @Nullable Object visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pkge) {
			s.append("_");
			s.appendName(pkge);
			return null;
		}

		@Override
		public @Nullable Object visitProperty(@NonNull Property property) {
			s.appendScopedTypeName(DomainUtil.nonNullModel(property.getOwningType()));
			s.append("__");
			s.appendName(property);
			return null;
		}

		@Override
		public @Nullable Object visitType(@NonNull Type type) {
			if (type.getOwningTemplateParameter() != null) {
				s.append("null");
			}
			else {
				s.append("Types.");
				s.appendScopedTypeName(type);
			}
			return null;
		}		
	}
	
	public class EmitQualifiedLiteralVisitor extends AbstractExtendingVisitor<Object, Object>
	{
		protected EmitQualifiedLiteralVisitor(@NonNull Object context) {
			super(context);
		}

		public @Nullable Object visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException("Unsupported EmitQualifiedLiteralVisitor for " + visitable.eClass().getName());
		}

		@Override
		public @Nullable Object visitCollectionType(@NonNull CollectionType object) {
			CollectionType unspecializedObject = PivotUtil.getUnspecializedTemplateableElement(object);
			s.appendClassReference(getQualifiedTablesClassName(unspecializedObject));
			s.append(".Types.");
			s.appendScopedTypeName(unspecializedObject);
			return null;
		}

		@Override
		public @Nullable Object visitEnumerationLiteral(@NonNull EnumerationLiteral enumerationLiteral) {
			Enumeration enumeration = DomainUtil.nonNullModel(enumerationLiteral.getEnumeration());
			s.appendClassReference(getQualifiedTablesClassName(enumeration));
			s.append(".EnumerationLiterals.");
			s.appendScopedTypeName(enumeration);
			s.append("__");
			s.appendName(enumerationLiteral);
			return null;
		}

		@Override
		public @Nullable Object visitOperation(@NonNull Operation operation) {
			Type type = DomainUtil.nonNullModel(operation.getOwningType());
			s.appendClassReference(getQualifiedTablesClassName(type));
			s.append(".Operations.");
			s.appendScopedTypeName(type);
			s.append("__");
			s.appendName(operation);
			return null;
		}

		@Override
		public @Nullable Object visitProperty(@NonNull Property property) {
			Type type = DomainUtil.nonNullModel(property.getOwningType());
			s.appendClassReference(getQualifiedTablesClassName(type));
			s.append(".Properties.");
			s.appendScopedTypeName(type);
			s.append("__");
			s.appendName(property);
			return null;
		}

		@Override
		public @Nullable Object visitTupleType(@NonNull TupleType type) {
			s.appendClassReference(getQualifiedTablesClassName(type));
			s.append(".tuple_type_");			// 
			s.appendUnscopedTypeName(type);
			return null;
//			[ast.getTablesClassName(genPackage).getPrefixedSymbolName('tuple_type_')/][/template]
		}

		@Override
		public @Nullable Object visitType(@NonNull Type type) {
			s.appendClassReference(getQualifiedTablesClassName(type));
			s.append(".Types.");
			s.appendScopedTypeName(type);
			return null;
		}		
	}

	protected final @NonNull CodeGenString s = new CodeGenString();
	protected final @NonNull GenPackage genPackage;
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull org.eclipse.ocl.examples.pivot.Package pPackage;
	protected final @NonNull DeclareParameterTypeVisitor declareParameterTypeVisitor = new DeclareParameterTypeVisitor(s);
	protected final @NonNull EmitLiteralVisitor emitLiteralVisitor = new EmitLiteralVisitor(s);
	protected final @NonNull EmitQualifiedLiteralVisitor emitQualifiedLiteralVisitor = new EmitQualifiedLiteralVisitor(s);
	protected final @NonNull Iterable<org.eclipse.ocl.examples.pivot.Class> activeClassesSortedByName;
	protected final @NonNull Map<DomainParameterTypes, String> templateBindingsNames = new HashMap<DomainParameterTypes, String>();
	

	protected OCLinEcoreTablesUtils(@NonNull GenPackage genPackage) {
		this.genPackage = genPackage;
		Resource genModelResource = genPackage.eResource();
		ResourceSet genModelResourceSet = genModelResource.getResourceSet();
		assert genModelResourceSet != null;
		MetaModelManagerResourceSetAdapter resourceSetAdapter = MetaModelManagerResourceSetAdapter.getAdapter(genModelResourceSet, null);
		this.metaModelManager = resourceSetAdapter.getMetaModelManager();
		this.pPackage = DomainUtil.nonNullModel(getPivotPackage(genPackage));
		activeClassesSortedByName = getActiveClassesSortedByName(pPackage);
	}

	protected @NonNull Iterable<org.eclipse.ocl.examples.pivot.Class> getActiveClassesSortedByName(@NonNull org.eclipse.ocl.examples.pivot.Package pPackage) {
		Set<? extends Type> activeTypes = getActiveTypes(pPackage);
		List<org.eclipse.ocl.examples.pivot.Class> sortedClasses = new ArrayList<org.eclipse.ocl.examples.pivot.Class>();
		for (Type activeType : activeTypes) {
			if (activeType instanceof org.eclipse.ocl.examples.pivot.Class) {
				sortedClasses.add((org.eclipse.ocl.examples.pivot.Class)activeType);
			}
		}
		Collections.sort(sortedClasses, nameComparator);
		return sortedClasses;
	}
	
	protected @NonNull Set<? extends Type> getActiveTypes(@NonNull org.eclipse.ocl.examples.pivot.Package pPackage) {
		Package oclstdlibPackage = metaModelManager.getBooleanType().getPackage();
		DomainPackage pivotMetaModel = metaModelManager.getPivotMetaModel();
		Type elementType = metaModelManager.getPivotType("Element");
		if (oclstdlibPackage == pPackage) {
			Set<Type> types = new HashSet<Type>();
			for (Type type : oclstdlibPackage.getOwnedType()) {
				assert type != null;
				TypeServer typeServer = metaModelManager.getTypeServer(type);
				if ((elementType != null) && typeServer.conformsTo(metaModelManager, elementType)) {
//					System.out.println("Prune " + type.getName());
				}
				else if (!"_Dummy".equals(type.getName())) {
					types.add(type);
				}
			}
			return types;
		}
		else if (pivotMetaModel == pPackage) {
			Set<Type> types = new HashSet<Type>();
			for (DomainType type : pivotMetaModel.getOwnedType()) {
				assert type != null;
				boolean pruned = false;
				Type myType = null;
				TypeServer typeServer = metaModelManager.getTypeServer(type);
				for (DomainType partialType : typeServer.getPartialTypes()) {
					DomainPackage partialPackage = partialType.getPackage();
					if (partialPackage == oclstdlibPackage) {
						if ((elementType != null) && !typeServer.conformsTo(metaModelManager, elementType)) {
//							System.out.println("Prune " + type.getName());
							pruned = true;
						}
					}
					else if (partialPackage == pPackage) {
						if (partialType instanceof Type) {
							myType = (Type) type;
						}
					}
				}
				if (!pruned && (myType != null)) {
					types.add(myType);
				}
			}
//			if (oclstdlibPackage != null) {
//				for (DomainType type : oclstdlibPackage.getOwnedType()) {
//					types.remove(type.getName());
//				}
//			}
			return types;
		}
		else {
			return new HashSet<Type>(pPackage.getOwnedType());
		}
	}

	protected @NonNull Iterable<org.eclipse.ocl.examples.pivot.Class> getAllProperSupertypesSortedByName(@NonNull org.eclipse.ocl.examples.pivot.Class pClass) {
		org.eclipse.ocl.examples.pivot.Class theClass = (org.eclipse.ocl.examples.pivot.Class)metaModelManager.getType(pClass);
		Map<org.eclipse.ocl.examples.pivot.Class, Integer> results = new HashMap<org.eclipse.ocl.examples.pivot.Class, Integer>();
		getAllSuperClasses(results, theClass);
		List<org.eclipse.ocl.examples.pivot.Class> sortedClasses = new ArrayList<org.eclipse.ocl.examples.pivot.Class>(results.keySet());
		sortedClasses.remove(theClass);
		Collections.sort(sortedClasses, nameComparator);
		return sortedClasses;
	}

	protected @NonNull List<org.eclipse.ocl.examples.pivot.Class> getAllSupertypesSortedByName(@NonNull org.eclipse.ocl.examples.pivot.Class pClass) {
		Map<org.eclipse.ocl.examples.pivot.Class, Integer> results = new HashMap<org.eclipse.ocl.examples.pivot.Class, Integer>();
		getAllSuperClasses(results, pClass);
		List<org.eclipse.ocl.examples.pivot.Class> sortedClasses = new ArrayList<org.eclipse.ocl.examples.pivot.Class>(results.keySet());
		Collections.sort(sortedClasses, nameComparator);
		return sortedClasses;
	}
	
	@SuppressWarnings("null")
	protected int getAllSuperClasses(@NonNull Map<org.eclipse.ocl.examples.pivot.Class, Integer> results, @NonNull org.eclipse.ocl.examples.pivot.Class aClass) {
		org.eclipse.ocl.examples.pivot.Class theClass = (org.eclipse.ocl.examples.pivot.Class)metaModelManager.getType(aClass);
		Integer depth = results.get(theClass);
		if (depth != null) {
			return depth;
		}
		int myDepth = 0;
		for (@NonNull DomainType superClass : metaModelManager.getAllSuperClasses(theClass)) {
			superClass = metaModelManager.getType(superClass);
			if ((superClass != theClass) && (superClass instanceof org.eclipse.ocl.examples.pivot.Class)) {
				superClass = PivotUtil.getUnspecializedTemplateableElement((org.eclipse.ocl.examples.pivot.Class)superClass);
				int superDepth = getAllSuperClasses(results, (org.eclipse.ocl.examples.pivot.Class)superClass);
				if (superDepth >= myDepth) {
					myDepth = superDepth+1;
				}
			}
		}
		results.put(theClass, myDepth);
		return myDepth;
	}
	
	protected @Nullable org.eclipse.ocl.examples.pivot.Package getExtendedPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pPackage) {
		Package oclstdlibPackage = metaModelManager.getBooleanType().getPackage();
		DomainPackage pivotMetaModel = metaModelManager.getPivotMetaModel();
		if (oclstdlibPackage == pPackage) {
			return null;
		}
		else if (pivotMetaModel == pPackage) {
			return oclstdlibPackage;
		}
		else {
			return null;
		}
	}

	public @NonNull GenPackage getGenPackage() {
		return genPackage;
	}
	
	protected @Nullable GenPackage getGenPackage(@NonNull Type type) {
		DomainPackage pPackage = type.getPackage();
		assert pPackage != null;
		Package oclstdlibPackage = metaModelManager.getBooleanType().getPackage();
		Type elementType = metaModelManager.getPivotType("Element");
		if ((elementType != null) && (oclstdlibPackage != null)) {
			DomainPackage pivotMetaModel = elementType.getPackage();
			assert pivotMetaModel != null;
			if (oclstdlibPackage == pPackage) {
				TypeServer typeServer = metaModelManager.getTypeServer(type);
				if (typeServer.conformsTo(metaModelManager, elementType)) {
					return getGenPackage(pivotMetaModel);
				}
				else {
					return getGenPackage(oclstdlibPackage);
				}
			}
			else if (pivotMetaModel == pPackage) {
				TypeServer typeServer = metaModelManager.getTypeServer(type);
				for (DomainType partialType : typeServer.getPartialTypes()) {
					DomainPackage partialPackage = partialType.getPackage();
					if (partialPackage == oclstdlibPackage) {
						if (!typeServer.conformsTo(metaModelManager, elementType)) {
							return getGenPackage(oclstdlibPackage);
						}
					}
				}
				return getGenPackage(pivotMetaModel);
			}
		}
		return getGenPackage(pPackage);
	}
	
	protected @Nullable GenPackage getGenPackage(@NonNull DomainPackage pivotPackage) {
		EPackage firstEPackage = genPackage.getEcorePackage();
		if (firstEPackage.getName().equals(pivotPackage.getName())) {
			return genPackage;
		}
		List<GenPackage> usedGenPackages = genPackage.getGenModel().getUsedGenPackages();
		assert usedGenPackages != null;
//		String nsURI = pivotPackage.getNsURI();
//		String name = pivotType.getName();
//		GenPackage usedGenPackage = getNsURIGenPackage(usedGenPackages, nsURI, name);
//		if (usedGenPackage != null) {
//			return usedGenPackage;
//		}		
		Resource genModelResource = genPackage.eResource();
		ResourceSet genModelResourceSet = genModelResource.getResourceSet();
		assert genModelResourceSet != null;
		DomainPackage metaModelPackage = metaModelManager.getPivotMetaModel();
		org.eclipse.ocl.examples.pivot.Package libraryPackage = metaModelManager.getLibraries().get(0);
		if (pivotPackage == libraryPackage) {
			GenPackage libraryGenPackage = getLibraryGenPackage(usedGenPackages);
			if (libraryGenPackage == null) {
				libraryGenPackage = loadGenPackage(genModelResourceSet, LibraryConstants.GEN_MODEL_URI);
			}
			return libraryGenPackage;
		}
		if (pivotPackage == metaModelPackage) {
			GenPackage metaModelGenPackage = getMetaModelGenPackage(usedGenPackages);
			if (metaModelGenPackage == null) {
				metaModelGenPackage = loadGenPackage(genModelResourceSet, PivotConstants.GEN_MODEL_URI);
			}
			return metaModelGenPackage;
		}
		String nsURI = pivotPackage.getNsURI();
		if (nsURI != null) {
			GenPackage genPackage2 = metaModelManager.getGenPackage(nsURI);
			if (genPackage2 != null) {
				return genPackage2;
			}
		}
		return genPackage;	// FIXME
	}

	protected @NonNull String getImplementationName(@NonNull Operation operation) {
		if (operation.getImplementationClass() != null) {
			return operation.getImplementationClass() + ".INSTANCE";
		}
		else {
//		    List<Constraint> constraints = operation.getOwnedRule();
//			if (constraints.size() > 0) {
//				return getQualifiedBodiesClassName(DomainUtil.nonNullModel(operation.getOwningType())) + "._" + operation.getName() + "_" + constraints.get(0).getStereotype() + "_.INSTANCE";
//			}
//			else {
				return "null";
//			}
		}
	}

	protected @NonNull Iterable<Operation> getLocalOperationsSortedBySignature(@NonNull org.eclipse.ocl.examples.pivot.Class pClass) {
		// cls.getOperations()->sortedBy(op2 : Operation | op2.getSignature())
		List<Operation> sortedOperations = new ArrayList<Operation>(getOperations(pClass));
		Collections.sort(sortedOperations, signatureComparator);
		return sortedOperations;
	}

	protected @NonNull List<Property> getLocalPropertiesSortedByName(@NonNull org.eclipse.ocl.examples.pivot.Class pClass) {
		List<Property> sortedProperties = new ArrayList<Property>();
		for (/*@NonNull*/ Property property : getProperties(pClass)) {
			assert property != null;
			if (isProperty(property)) {
				sortedProperties.add(property);
			}
		}
		Collections.sort(sortedProperties, nameComparator);
		return sortedProperties;
	}
	
	protected @NonNull LinkedHashSet<Operation> getOperations(@NonNull Type type) {
		LinkedHashSet<Operation> operations = new LinkedHashSet<Operation>();
		for (Operation operation : metaModelManager.getMemberOperations(type, false)) {
			operations.add(operation);
		}
		for (Operation operation : metaModelManager.getMemberOperations(type, true)) {
			operations.add(operation);
		}
		return operations;
	}

	protected @NonNull Operation getOverloadOp(@NonNull org.eclipse.ocl.examples.pivot.Class pClass, @NonNull Operation baseOp) {
		String baseSignature = getSignature(baseOp);
		Map<org.eclipse.ocl.examples.pivot.Class, Integer> results = new HashMap<org.eclipse.ocl.examples.pivot.Class, Integer>();
		getAllSuperClasses(results, pClass);
		int bestDepth = -1;
		Operation best = null;
		for (org.eclipse.ocl.examples.pivot.Class aClass : results.keySet()) {
			int aDepth = results.get(aClass);
			for (Operation op : getOperations(DomainUtil.nonNullState(aClass))) {
				if (baseSignature.equals(getSignature(DomainUtil.nonNullState(op))) && (aDepth > bestDepth)) {
					bestDepth = aDepth;
					best = op;
				}
			}
		}
		assert best != null;
		return best;
	}
	
	protected org.eclipse.ocl.examples.pivot.Package getPivotPackage(@NonNull GenPackage genPackage) {
		EPackage ePackage = genPackage.getEcorePackage();
		Resource ecoreResource = ePackage.eResource();
		if (ecoreResource == null) {
			return null;
		}
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
		org.eclipse.ocl.examples.pivot.Package pivotPackage = ecore2Pivot.getCreated(org.eclipse.ocl.examples.pivot.Package.class, ePackage);
		if (pivotPackage == null) {
			return null;
		}
		if (pivotPackage.getNsURI().equals(OCLstdlibPackage.eNS_URI)) {				// If generating OCLstdlibTables ...
			mergeLibrary(pivotPackage);			// FIXME: redundant once M2T scans all partial types
		}
		return pivotPackage;
	}
	
	protected @NonNull LinkedHashSet<Property> getProperties(@NonNull Type type) {
		LinkedHashSet<Property> properties = new LinkedHashSet<Property>();
		for (Property property : metaModelManager.getMemberProperties(type, false)) {
			if (property != null) {
				properties.add((Property) metaModelManager.getPrimaryProperty(property));
			}
		}
		for (Property property : metaModelManager.getMemberProperties(type, true)) {
			if (property != null) {
				properties.add((Property) metaModelManager.getPrimaryProperty(property));
			}
		}
		return properties;
	}
	
	protected @NonNull String getQualifiedTablesClassName(@NonNull Type type) {
		GenPackage genPackage = getGenPackage(type);
		if (genPackage != null) {
			return genPackage.getInterfacePackageName() + "." + getTablesClassName(genPackage);
		}
		else {
			return "UnknownMetaModelTables";
		}
	}
	
	protected @NonNull String getQualifiedTablesClassName(@NonNull org.eclipse.ocl.examples.pivot.Package pPackage) {
		GenPackage genPackage = getGenPackage(pPackage);
		if (genPackage != null) {
			return genPackage.getInterfacePackageName() + "." + getTablesClassName(genPackage);
		}
		else {
			return "UnknownMetaModelTables";
		}
	}
	
	protected @NonNull String getSharedLibrary() {
		org.eclipse.ocl.examples.pivot.Package thisPackage = getPivotPackage(genPackage);
		if (thisPackage != null) {
			PrimitiveType booleanType = metaModelManager.getBooleanType();
			DomainPackage libraryPackage = booleanType.getPackage();
			if (libraryPackage != null) {
				GenPackage gPackage = getGenPackage(libraryPackage);
				if (gPackage != null) {
					return gPackage.getInterfacePackageName() + "." + gPackage.getPrefix() + AbstractGenModelHelper.TABLES_CLASS_SUFFIX;
				}
			}
		}
/*		TypeServer typeServer = metaModelManager.getTypeServer(booleanType);
		for (DomainType type : typeServer.getPartialTypes()) {
			DomainPackage pivotPackage = type.getPackage();
			if ((pivotPackage != null) && (pivotPackage != thisPackage)) {
				GenPackage gPackage = getGenPackage(genPackage, pivotPackage);
				if (gPackage != null) {
					return getInterfacePackageName(gPackage) + "." + gPackage.getPrefix() + AbstractGenModelHelper.TABLES_CLASS_SUFFIX;
				}
			}
		} */
		return "";
	}
	
	public static @NonNull String getSignature(@NonNull Operation anOperation) {
		Type owningType = anOperation.getOwningType();
		if (owningType == null) {
			return "null";
		}
		String qualifiedSignature = PrettyPrinter.printType(anOperation, (Namespace)owningType);	// FIXME cast
		int index = qualifiedSignature.indexOf("::");
		if (index > 0) {
			@SuppressWarnings("null")@NonNull String substring = qualifiedSignature.substring(index+2);
			return substring;
		}
		else {
			return qualifiedSignature;	// FIXME with PrettyPrintOptions
		}
	}

	public @NonNull String getTablesClassName() {
		return getTablesClassName(genPackage);
	}

	protected @NonNull String getTablesClassName(@NonNull GenPackage genPackage) {
		return genPackage.getPrefix() + AbstractGenModelHelper.TABLES_CLASS_SUFFIX;
	}

	protected @NonNull String getTemplateBindingsName(@NonNull DomainParameterTypes templateBindings) {
		String name2 = templateBindingsNames.get(templateBindings);
		if (name2 == null) {
			StringBuilder s = new StringBuilder();
			s.append("_");
			if (templateBindings.size() > 0 ) {
				for (int i = 0; i < templateBindings.size(); i++) {
					if (i > 0) {
						s.append("___");
					}
					DomainType element = templateBindings.get(i);
					getTemplateBindingsName(s, element);
				}
			}
			@SuppressWarnings("null")@NonNull String string = s.toString();
			name2 = string;
			templateBindingsNames.put(templateBindings, name2);
		}
		return name2;
	}
	private void getTemplateBindingsName(@NonNull StringBuilder s, @NonNull Nameable element) {
		if (element instanceof ParameterableElement) {
			TemplateParameter templateParameter = ((ParameterableElement)element).getOwningTemplateParameter();
			if (templateParameter != null) {
				TemplateableElement template = templateParameter.getSignature().getTemplate();
				if (template instanceof Operation) {
					s.append(AbstractGenModelHelper.encodeName(DomainUtil.nonNullModel(((Operation) template).getOwningType())));
					s.append("_");
				}
				s.append(AbstractGenModelHelper.encodeName(DomainUtil.nonNullModel((NamedElement) template)));
				s.append("_");
			}
		}
		s.append(AbstractGenModelHelper.encodeName((NamedElement)element));
		if (element instanceof TemplateableElement) {
			List<TemplateBinding> templateBindings = ((TemplateableElement)element).getTemplateBinding();
			if (templateBindings.size() > 0) {
				s.append("_");
				for (TemplateBinding templateBinding : templateBindings) {
					for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitution()) {
						s.append("_");
						getTemplateBindingsName(s, DomainUtil.nonNullModel((Nameable) templateParameterSubstitution.getActual()));
					}
				}
				s.append("__");
			}
		}
		if (element instanceof LambdaType) {
			LambdaType lambdaType = (LambdaType)element;
			s.append("_");
			getTemplateBindingsName(s, DomainUtil.nonNullModel(lambdaType.getContextType()));
			for (/*@NonNull*/ Type type : lambdaType.getParameterType()) {
				assert type != null;
				s.append("_");
				getTemplateBindingsName(s, type);
			}
			s.append("_");
			getTemplateBindingsName(s, DomainUtil.nonNullModel(lambdaType.getResultType()));
		}
	}
	
	/**
	 * Return  true if property has an Ecore counterpart. Non-navigable opposites may have a Property
	 * but no Ecore EReference.
	 */
	protected @NonNull Boolean hasEcore(@NonNull Property property) {
		Type owningType = property.getOwningType();
		if (owningType == null) {
			return false;
		}
		String typeName = owningType.getName();
		if (typeName == null) {
			return false;
		}
		GenClass genClass = getNamedElement1(genPackage.getGenClasses(), typeName);
		if (genClass == null) {
			return false;
		}
		String propertyName = property.getName();
		if (propertyName == null) {
			return false;
		}
		GenFeature genFeature = getNamedElement2(genClass.getAllGenFeatures(), propertyName);
		if (genFeature == null) {
			return false;
		}
		return true;
	}

	protected @NonNull Boolean hasSharedLibrary() {
		org.eclipse.ocl.examples.pivot.Package thisPackage = getPivotPackage(genPackage);
		PrimitiveType booleanType = metaModelManager.getBooleanType();
		org.eclipse.ocl.examples.pivot.Package libraryPackage = booleanType.getPackage();
		return thisPackage != libraryPackage;
	}

	protected boolean isLambdaParameterList(@NonNull ParametersId parametersId) {
		for (TypeId typeId : parametersId) {
			if (typeId instanceof LambdaTypeId) {
				return true;
			}
		}
		return false;
	}

	protected boolean isProperty(@NonNull Property prop) {
		if (hasEcore(prop)) {
			return true;
		}
		Property opposite = prop.getOpposite();
		return (opposite != null) && hasEcore(opposite);
	}
	
	/**
	 * Return true if type has an Ecore counterpart. The Standard Library genmodel has
	 * no Ecore types, unless the Pivot model is also in use.
	 */
	protected @NonNull Boolean hasEcore(@NonNull Type type) {
		String typeName = type.getName();
		if (typeName != null) {
			GenClass genClass = getNamedElement1(genPackage.getGenClasses(), typeName);
			if (genClass != null) {
				return true;
			}
			GenEnum genEnum = getNamedElement1(genPackage.getGenEnums(), typeName);
			if (genEnum != null) {
				return true;
			}
		}
		return false;
	}
	
	protected void mergeLibrary(@NonNull org.eclipse.ocl.examples.pivot.Package primaryPackage) {
//		primaryPackage.setName("ocl");
		List<Type> primaryTypes = primaryPackage.getOwnedType();
		for (Library library : metaModelManager.getLibraries()) {
			Map<Type,Type> typeMap = new HashMap<Type,Type>();
			ArrayList<Type> libraryTypes = new ArrayList<Type>(library.getOwnedType());
			for (Type secondaryType : libraryTypes) {
				Type primaryType = DomainUtil.getNamedElement(primaryTypes, secondaryType.getName());
				if (primaryType != null) {
					typeMap.put(secondaryType, primaryType);
				}
				else {
					primaryTypes.add(secondaryType);
				}
			}
			for (Type secondaryType : libraryTypes) {
				Type primaryType = typeMap.get(secondaryType);
				if (primaryType != null) {
					List<Type> primarySuperClasses = primaryType.getSuperClass();
					for (Type secondarySuperClass : secondaryType.getSuperClass()) {
						Type primarySuperClass = typeMap.get(secondarySuperClass);
						if (primarySuperClass == null) {
							primarySuperClasses.add(secondarySuperClass);
						}
						else if (!primarySuperClasses.contains(primarySuperClass)) {
							primarySuperClasses.add(primarySuperClass);
						}
					}
					primaryType.getOwnedOperation().addAll(secondaryType.getOwnedOperation());
					primaryType.getOwnedAttribute().addAll(secondaryType.getOwnedAttribute());
				}
			}
		}
		for (Type primaryType : primaryTypes) {
			List<Type> primarySuperClasses = primaryType.getSuperClass();
			Type classType = DomainUtil.getNamedElement(primarySuperClasses, TypeId.CLASS_NAME);
			Type metaclass = DomainUtil.getNamedElement(primarySuperClasses, "Classifier");
			if ((classType != null) && (metaclass != null)) {
				primarySuperClasses.remove(classType);		// WIP FIXME fix at source
			}
		}
	}
}

