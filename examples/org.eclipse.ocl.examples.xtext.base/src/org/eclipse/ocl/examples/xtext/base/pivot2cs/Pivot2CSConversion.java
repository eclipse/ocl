/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.pivot2cs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSFactory;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DetailCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS;
import org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootCS;
import org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS.Factory;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;

public class Pivot2CSConversion extends AbstractConversion implements PivotConstants
{	
	private static final Logger logger = Logger.getLogger(Pivot2CSConversion.class);

	protected final @NonNull Pivot2CS converter;
	protected final @NonNull BaseDeclarationVisitor defaultDeclarationVisitor;
	protected final @NonNull BaseReferenceVisitor defaultReferenceVisitor;
	
	private org.eclipse.ocl.examples.pivot.Class scope = null;

	private final @NonNull Map<EClass, BaseDeclarationVisitor> declarationVisitorMap = new HashMap<EClass, BaseDeclarationVisitor>();
	private final @NonNull Map<EClass, BaseReferenceVisitor> referenceVisitorMap = new HashMap<EClass, BaseReferenceVisitor>();
	private Map<Namespace, List<String>> importedNamespaces = null;
	
	public Pivot2CSConversion(@NonNull Pivot2CS converter) {
		super(converter.getMetaModelManager());
		this.converter = converter;
		this.defaultDeclarationVisitor = converter.createDefaultDeclarationVisitor(this);
		this.defaultReferenceVisitor = converter.createDefaultReferenceVisitor(this);
	}

	protected void addBooleanQualifier(@NonNull List<String> qualifiers, @NonNull DetailCS csDetail, @NonNull String csString) {
		if ((csDetail.getValue().size() == 1) && Boolean.valueOf(csDetail.getValue().get(0))) {
			qualifiers.add(csString);
		}
		else {
			qualifiers.add("!" + csString);
		}
	}

	protected void createImports(@NonNull Resource csResource, @NonNull Map<Namespace, List<String>> importedNamespaces) {
		AliasAnalysis.dispose(csResource);			// Force reanalysis
		MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(csResource);
		if (metaModelManager == null) {
			throw new IllegalStateException("No MetaModelManager");
		}
		AliasAnalysis aliasAnalysis = null;
		URI csURI = csResource.getURI();
		RootCS documentCS = (RootCS) csResource.getContents().get(0);
		List<ImportCS> imports = new ArrayList<ImportCS>();
		for (Namespace importedNamespace : importedNamespaces.keySet()) {
			if (importedNamespace != null) {
				if (importedNamespace instanceof org.eclipse.ocl.examples.pivot.Package){
					Package pivotPackage = metaModelManager.getPackageServer((org.eclipse.ocl.examples.pivot.Package)importedNamespace).getPivotPackage();
		//			ModelElementCS csElement = createMap.get(importedPackage);
		//			if ((csElement != null) && (csElement.eResource() == xtextResource)) {
		//				continue;		// Don't import defined packages
		//			}
					if (metaModelManager.getLibraries().contains(pivotPackage)) {
						continue;
					}
				}
				List<String> aliases = importedNamespaces.get(importedNamespace);
				if ((aliases == null) || aliases.isEmpty()) {
					if (aliasAnalysis == null) {
						aliasAnalysis = AliasAnalysis.getAdapter(csResource, metaModelManager);
					}
					String alias = aliasAnalysis.getAlias(importedNamespace, null);
					aliases = Collections.singletonList(alias);
				}
				EObject eObject = importedNamespace.getETarget();
				String importURI = null;
				if (eObject instanceof EPackage) {
					EPackage ePackage = (EPackage)eObject;
					Resource resource = ePackage.eResource();
					if (DomainUtil.isRegistered(resource)) {
						importURI = ePackage.getNsURI();
					}
				}
				if (importURI == null) {
					URI fullURI = EcoreUtil.getURI(eObject != null ? eObject : importedNamespace);
					URI deresolvedURI = fullURI.deresolve(csURI, true, true, false);
					importURI = deresolvedURI.toString();
				}
				for (String alias : aliases) {
					ImportCS importCS = BaseCSFactory.eINSTANCE.createImportCS();
					importCS.setName(alias);
					@SuppressWarnings("null") @NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
					importCS.setPathName(csPathName);
					List<PathElementCS> csPath = csPathName.getPath();
					PathElementWithURICS csSimpleRef = BaseCSFactory.eINSTANCE.createPathElementWithURICS();
					csPath.add(csSimpleRef);
					csSimpleRef.setElement(importedNamespace);
					csSimpleRef.setUri(importURI);
					importCS.setPivot(importedNamespace);
					imports.add(importCS);
				}
			}
		}
		if (aliasAnalysis != null) {
			aliasAnalysis.dispose();
		}
		aliasAnalysis = AliasAnalysis.getAdapter(csResource, metaModelManager);
		for (ImportCS csImport : imports) {
			Namespace namespace = csImport.getNamespace();
			String alias = csImport.getName();
			if ((namespace != null) && (alias == null)) {
				alias = aliasAnalysis.getAlias(namespace, null);
				if (alias == null) {
					String hint = null;
					if (namespace instanceof org.eclipse.ocl.examples.pivot.Package) {
						hint = ((org.eclipse.ocl.examples.pivot.Package)namespace).getNsPrefix();
					}
					if (hint == null) {
						String name = namespace.getName();
						if (name.length() > 0) {
							hint = name.substring(0, 1).toLowerCase() + name.substring(1);
						}
					}
					if (hint != null) {
						alias = aliasAnalysis.getAlias(namespace, hint);
					}
				}
				if (alias != null) {
					csImport.setName(alias);
				}
			}
		}
		Collections.sort(imports, new Comparator<ImportCS>()
		{
			public int compare(ImportCS o1, ImportCS o2) {
				Namespace ns1 = o1.getNamespace();
				Namespace ns2 = o2.getNamespace();
				int d1 = PivotUtil.getContainmentDepth(ns1);
				int d2 = PivotUtil.getContainmentDepth(ns2);
				if (d1 != d2) {
					return d1 - d2;
				}
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
		documentCS.getOwnedImport().addAll(imports);
	}

	public @Nullable BaseDeclarationVisitor getDeclarationVisitor(@NonNull EClass eClass) {
		BaseDeclarationVisitor declarationVisitor = declarationVisitorMap.get(eClass);
		if ((declarationVisitor == null) && !declarationVisitorMap.containsKey(eClass)) {
			Factory factory = converter.getFactory(eClass);
			if (factory != null) {
				declarationVisitor = factory.createDeclarationVisitor(this);
			}
			else {
				declarationVisitor = defaultDeclarationVisitor;
			}
			declarationVisitorMap.put(eClass, declarationVisitor);
		}
		return declarationVisitor;
	}

	public @Nullable BaseReferenceVisitor getReferenceVisitor(@NonNull EClass eClass) {
		BaseReferenceVisitor referenceVisitor = referenceVisitorMap.get(eClass);
		if ((referenceVisitor == null) && !referenceVisitorMap.containsKey(eClass)) {
			Factory factory = converter.getFactory(eClass);
			if (factory != null) {
				referenceVisitor = factory.createReferenceVisitor(this);
			}
			else {
				referenceVisitor = defaultReferenceVisitor;
			}
			referenceVisitorMap.put(eClass, referenceVisitor);
		}
		return referenceVisitor;
	}

	public org.eclipse.ocl.examples.pivot.Class getScope() {
		return scope;
	}

	protected List<TemplateBindingCS> getTemplateBindings(ElementCS csElement) {
		List<TemplateBindingCS> csTemplateBindings;
//		EObject container = csElement.eContainer();
//		if (container instanceof ElementCS) {			
//			csTemplateBindings = getTemplateBindings((ElementCS) container);
//		}
//		else {
			csTemplateBindings = new ArrayList<TemplateBindingCS>();
//		}
		if (csElement instanceof TypedTypeRefCS) {
			TypedTypeRefCS csTemplateableElement = (TypedTypeRefCS)csElement;
			TemplateBindingCS csTemplateBinding = csTemplateableElement.getOwnedTemplateBinding();
			if (csTemplateBinding != null) {
				csTemplateBindings.add(csTemplateBinding);
			}
		}
		return csTemplateBindings;
	}

	public void importNamespace(@NonNull Namespace importNamespace, @Nullable String alias) {
		Namespace primaryNamespace = metaModelManager.getPrimaryElement(importNamespace);
		List<String> aliases = importedNamespaces.get(primaryNamespace);
		if (aliases == null) {
			aliases = new ArrayList<String>();
			importedNamespaces.put(primaryNamespace, aliases);
		}
		if ((alias != null) && !aliases.contains(alias)) {
			aliases.add(alias);
		}
	}

	protected <T extends ClassifierCS> T refreshClassifier(@NonNull Class<T> csClass, /*@NonNull*/ EClass csEClass, @NonNull Type object) {
		T csElement = refreshNamedElement(csClass, csEClass, object);
		List<ConstraintCS> csInvariants = visitDeclarations(ConstraintCS.class, object.getOwnedInvariant(), null);
		for (ConstraintCS csInvariant : csInvariants) {
			csInvariant.setStereotype(UMLReflection.INVARIANT);
		}
		refreshList(csElement.getOwnedConstraint(), csInvariants);
		TemplateSignature ownedTemplateSignature = object.getOwnedTemplateSignature();
		if (ownedTemplateSignature != null) {
			csElement.setOwnedTemplateSignature(visitDeclaration(TemplateSignatureCS.class, ownedTemplateSignature));
		}
		if (object.eIsSet(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME)) {
			csElement.setInstanceClassName(object.getInstanceClassName());
		}
		else {
			csElement.eUnset(BaseCSPackage.Literals.CLASSIFIER_CS__INSTANCE_CLASS_NAME);
		}
		return csElement;
	}

	public <T extends ModelElementCS> T refreshElement(@NonNull Class<T> csClass, /*@NonNull*/ EClass csEClass, @NonNull Element object) {
		assert csClass == csEClass.getInstanceClass();
		EFactory eFactoryInstance = csEClass.getEPackage().getEFactoryInstance();
		ModelElementCS csElement = (ModelElementCS) eFactoryInstance.create(csEClass);
		if (!csClass.isAssignableFrom(csElement.getClass())) {
			throw new ClassCastException();
		}
		csElement.setPivot(object);
		@SuppressWarnings("unchecked")
		T castElement = (T) csElement;
		return castElement;
	}

	public <T extends NamedElementCS> T refreshNamedElement(@NonNull Class<T> csClass, /*@NonNull */EClass csEClass, @NonNull NamedElement object) {
		T csElement = refreshElement(csClass, csEClass, object);
		String name = object.getName();
		csElement.setName(name);
		refreshList(csElement.getOwnedAnnotation(), visitDeclarations(AnnotationCS.class, object.getOwnedAnnotation(), null));
		return csElement;
	}

	/**
	 * Assign a sequence of one or more path elements to csPathName that identify element with respect
	 * to scope.
	 * <br>
	 * For example A::B::C::D::E with respect to A::B::C::X::Y is D::E.
	 * <br>
	 * Validation is performed to check that the shortened name resolves to the same
	 * element.
	 * <br>
	 * For example if there is also an A::B::C::X::D::E, the scope is shortened to A::B so
	 * that the result is C::D::E.
	 */
	public void refreshPathName(@NonNull PathNameCS csPathName, @NonNull Element element, @Nullable Namespace scope) {
		Namespace safeScope = scope;
		Element primaryElement = metaModelManager.getPrimaryElement(element);
		if ((safeScope != null) && (primaryElement instanceof Type)) {
			String name = ((Type)primaryElement).getName();
			for (EObject eObject = safeScope; eObject != null; eObject = eObject.eContainer()) {
				if (eObject instanceof Namespace) {
					safeScope = (Namespace) eObject;
				}
				if (eObject instanceof DomainPackage) {
					PackageServer packageServer = metaModelManager.getPackageServer((DomainPackage)eObject);
					Type memberType = packageServer.getMemberType(name);
					if (memberType == primaryElement) {
						if ((eObject != scope) && (eObject != PivotUtil.getContainingPackage(scope))) {
							eObject = eObject.eContainer(); // If eObject is needed in path, optional scope is its container
						}
						if (eObject instanceof Namespace) {
							safeScope = (Namespace) eObject;
						}
						break;
					}
				}
			}
		}
		ElementUtil.setPathName(csPathName, primaryElement, safeScope);
	}

	public void refreshQualifiers(List<String> qualifiers, String string, boolean polarity) {
		for (String qualifier : qualifiers) {
			if (qualifier.equals(string)) {
				if (!polarity) {
					qualifiers.remove(qualifier);
				}
				return;		
			}
		}
		if (polarity) {
			qualifiers.add(string);
		}
	}

	public void refreshQualifiers(List<String> qualifiers, String trueString, String falseString, Boolean polarity) {
		boolean isFalse = false;
		boolean isTrue = false;
		for (String qualifier : qualifiers) {
			if (qualifier.equals(trueString)) {
				if (isTrue || (polarity != Boolean.TRUE)) {
					qualifiers.remove(qualifier);
				}
				isTrue = true;
			}
			if (qualifier.equals(falseString)) {
				if (isTrue || (polarity != Boolean.FALSE)) {
					qualifiers.remove(qualifier);
				}
				isFalse = true;
			}
		}
		if (polarity == Boolean.TRUE) {
			if (!isTrue) {
				qualifiers.add(trueString);
			}
		}
		else if (polarity == Boolean.FALSE) {
			if (!isFalse) {
				qualifiers.add(falseString);
			}
		}
	}

	public <T extends StructuralFeatureCS> T refreshStructuralFeature(@NonNull Class<T> csClass, /*@NonNull */EClass csEClass, @NonNull Property object) {
		T csElement = refreshTypedMultiplicityElement(csClass, csEClass, object);
		refreshQualifiers(csElement.getQualifier(), "derived", object.isDerived());
		refreshQualifiers(csElement.getQualifier(), "readonly", object.isReadOnly());
		refreshQualifiers(csElement.getQualifier(), "static", object.isStatic());
		refreshQualifiers(csElement.getQualifier(), "transient", object.isTransient());
		refreshQualifiers(csElement.getQualifier(), "unsettable", object.isUnsettable());
		refreshQualifiers(csElement.getQualifier(), "volatile", object.isVolatile());
		if (object.eIsSet(PivotPackage.Literals.PROPERTY__DEFAULT)) {
			csElement.setDefault(object.getDefault());
		}
		else {
			csElement.eUnset(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT);
		}
		return csElement;
	}
	
	public <T extends TypedElementCS> T refreshTypedElement(@NonNull Class<T> csClass, /*@NonNull */EClass csEClass, @NonNull TypedElement object) {
		T csElement = refreshNamedElement(csClass, csEClass, object);
		Type type = object.getType();
		if ((type instanceof CollectionType) && (type.getUnspecializedElement() != metaModelManager.getCollectionType())) {
			PivotUtil.debugWellContainedness(type);
			type = ((CollectionType)type).getElementType();
		}
		else if (type instanceof VoidType) {
			type = null;
		}
		if (type != null) {
			PivotUtil.debugWellContainedness(type);
			TypedRefCS typeRef = visitReference(TypedRefCS.class, type);
			csElement.setOwnedType(typeRef);
		}
		else {
			csElement.setOwnedType(null);
		}
//		refreshList(csElement.getOwnedConstraint(), visitDeclarations(ConstraintCS.class, object.getOwnedRule(), null));		
		return csElement;
	}

	public <T extends TypedElementCS> T refreshTypedMultiplicityElement(@NonNull Class<T> csClass, /*@NonNull */EClass csEClass, @NonNull TypedMultiplicityElement object) {
		T csElement = refreshTypedElement(csClass, csEClass, object);
		TypedRefCS csTypeRef = csElement.getOwnedType();
		if (csTypeRef != null) {
			int lower;
			int upper;
			Type type = object.getType();
			if ((type instanceof CollectionType) && (type.getUnspecializedElement() != metaModelManager.getCollectionType())) {
				CollectionType collectionType = (CollectionType)type;
				lower = collectionType.getLower().intValue();
				Number upper2 = collectionType.getUpper();
				upper = upper2 instanceof Unlimited ? -1 : upper2.intValue();
				List<String> qualifiers = csElement.getQualifier();
				refreshQualifiers(qualifiers, "ordered", "!ordered", collectionType.isOrdered() ? Boolean.TRUE : null);
				refreshQualifiers(qualifiers, "unique", "!unique", collectionType.isUnique() ? null : Boolean.FALSE);
			}
			else {
				lower = object.isRequired() ? 1 : 0;
				upper = 1;
			}
			if ((lower == 1) && (upper == 1)) {
				csTypeRef.setMultiplicity(null);
			}
			else {
				String stringValue = null;
				if (lower == 0) {
					if (upper == 1) {
						stringValue = "?";
					}
					else if (upper == -1) {
						stringValue = "*";				
					}
		//			else if (upper == -2) {
		//				stringValue = "0..?";				
		//			}
				}
				else if (lower == 1) {
					if (upper == -1) {
						stringValue = "+";				
					}
				}
				if (stringValue != null) {
					MultiplicityStringCS csMultiplicity = BaseCSFactory.eINSTANCE.createMultiplicityStringCS();
					csMultiplicity.setStringBounds(stringValue);
					csTypeRef.setMultiplicity(csMultiplicity);
				}
				else {
					MultiplicityBoundsCS csMultiplicity = BaseCSFactory.eINSTANCE.createMultiplicityBoundsCS();
					if (lower != 1) {
						csMultiplicity.setLowerBound(lower);
					}
					if (upper != 1) {
						csMultiplicity.setUpperBound(upper);
					}
					csTypeRef.setMultiplicity(csMultiplicity);
				}
			}
		}
		return csElement;
	}

	public org.eclipse.ocl.examples.pivot.Class setScope(org.eclipse.ocl.examples.pivot.Class object) {
		org.eclipse.ocl.examples.pivot.Class savedScope = scope;
		this.scope = object;
		return savedScope;
	}

	/**
	 * Sequence the update passes to make the pivot match the CS.
	 * @param csResources 
	 */
	public void update(@NonNull Collection<? extends Resource> csResources) {
		Map<Resource, Map<Namespace, List<String>>> imports = new HashMap<Resource, Map<Namespace, List<String>>>();
		//
		//	Perform the pre-order traversal to create the CS for each declaration. A
		//	separate reference pass is not needed since references are to the pivot model.
		//
		for (Resource csResource : csResources) {
			if (csResource != null) {
				importedNamespaces = new HashMap<Namespace, List<String>>();
				Resource asResource = converter.getPivotResource(csResource);
				if (asResource != null) {
					List<PackageCS> list = visitDeclarations(PackageCS.class, asResource.getContents(), null);
					refreshList(csResource.getContents(), list);
					imports.put(csResource, importedNamespaces);
				}
			}
		}
		for (Resource csResource : csResources) {
			if (csResource != null) {
				Map<Namespace, List<String>> importedNamespaces = imports.get(csResource);
				if (importedNamespaces != null) {
					createImports(csResource, importedNamespaces);
				}
			}
		}
	}

	public @Nullable <T extends ElementCS> T visitDeclaration(@NonNull Class<T> csClass, @Nullable EObject eObject) {
		if (eObject == null) {
			return null;
		}
		@SuppressWarnings("null") @NonNull EClass eClass = eObject.eClass();
		BaseDeclarationVisitor declarationVisitor = getDeclarationVisitor(eClass);
		if ((declarationVisitor == null) || !(eObject instanceof Visitable)) {
			logger.warn("Unsupported declaration " + eClass.getName());
			return null;
		}
		ElementCS csElement = ((Visitable)eObject).accept(declarationVisitor);
		@SuppressWarnings("unchecked")
		T castElement = (T) csElement;
		return castElement;
	}

	public @Nullable <T extends ElementCS, V extends EObject> List<T> visitDeclarationAsList(@NonNull Class<T> csClass, @Nullable V eObject) {
		if (eObject == null) {
			return null;
		}
		T csElement = visitDeclaration(csClass, eObject);
		if (csElement == null) {
			return null;
		}
		return Collections.singletonList(csElement);
	}

	public @NonNull <T extends ElementCS, V extends EObject> List<T> visitDeclarations(@NonNull Class<T> csClass, /*@NonNull*/ List<V> eObjects, @Nullable Pivot2CS.Predicate<V> predicate) {
		assert eObjects != null;
		List<T> csElements = new ArrayList<T>();
		for (V eObject : eObjects) {
			if ((eObject != null) && ((predicate == null) || predicate.filter(eObject))) {
				T csElement = visitDeclaration(csClass, eObject);
				if (csElement != null) {
					csElements.add(csElement);
				}
			}
		}
		return csElements;
	}

	public @Nullable <T extends ElementCS> T visitReference(@NonNull Class<T> csClass, @NonNull EObject eObject) {
		@SuppressWarnings("null") @NonNull EClass eClass = eObject.eClass();
		BaseReferenceVisitor referenceVisitor = getReferenceVisitor(eClass);
		if ((referenceVisitor == null) || !(eObject instanceof Visitable)) {
			logger.warn("Unsupported reference " + eObject.eClass().getName());
			return null;
		}
		ElementCS csElement = ((Visitable)eObject).accept(referenceVisitor);
		if (csElement == null) {
			return null;
		}
		if (!csClass.isAssignableFrom(csElement.getClass())) {
			logger.error("CS " + csElement.getClass().getName() + "' element is not a '" + csClass.getName() + "'"); //$NON-NLS-1$
			return null;
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) csElement;
		return castElement;
	}

	public @NonNull <T extends ElementCS, V extends EObject> List<T> visitReferences(@NonNull Class<T> csClass, /*@NonNull*/ List<? extends V> eObjects, @Nullable Pivot2CS.Predicate<V> predicate) {
		assert eObjects != null;
		List<T> csElements = new ArrayList<T>();
		for (V eObject : eObjects) {
			if ((eObject != null) && ((predicate == null) || predicate.filter(eObject))) {
				T csElement = visitReference(csClass, eObject);
				if (csElement != null) {
					csElements.add(csElement);
				}
			}
		}
		return csElements;
	}
}
