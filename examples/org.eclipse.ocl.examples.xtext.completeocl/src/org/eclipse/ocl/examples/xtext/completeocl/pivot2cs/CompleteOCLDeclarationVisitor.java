/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.completeocl.pivot2cs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LanguageExpression;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSFactory;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.AliasAnalysis;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PathNameDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs.EssentialOCLDeclarationVisitor;

import com.google.common.collect.Lists;

public class CompleteOCLDeclarationVisitor extends EssentialOCLDeclarationVisitor
{
	public CompleteOCLDeclarationVisitor(@NonNull Pivot2CSConversion context) {
		super(context);
	}

	protected TypedRefCS convertTypeRef(@NonNull TypedMultiplicityElement object) {
		Type type = object.getType();
		if (type == null) {
			return null;
		}
		TypedRefCS typeRef = context.visitReference(TypedRefCS.class, type, null);
//		int upper = object.getUpper().intValue();
//		if (upper == 1) {
			return typeRef;
//		}
//		int lower = object.getLower().intValue();
//		CollectionTypeCS collectionTypeCS = EssentialOCLCSFactory.eINSTANCE.createCollectionTypeCS();
//		collectionTypeCS.setOwnedType(typeRef);
//		collectionTypeCS.setName(ElementUtil.getCollectionName(object.isOrdered(), object.isUnique()));
//		return collectionTypeCS;
	}

	protected void gatherPackages(@NonNull List<org.eclipse.ocl.examples.pivot.Package> allPackages, @NonNull List<org.eclipse.ocl.examples.pivot.Package> nestedPackages) {
		allPackages.addAll(nestedPackages);
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : nestedPackages) {
			List<org.eclipse.ocl.examples.pivot.Package> nestedNestedPackages = nestedPackage.getNestedPackage();
			assert nestedNestedPackages != null;
			gatherPackages(allPackages, nestedNestedPackages);
		}
	}

	protected void importPackage(@NonNull org.eclipse.ocl.examples.pivot.Package aPackage) {
		context.importNamespace(aPackage, null);
		org.eclipse.ocl.examples.pivot.Package nestingPackage = null;
		while ((nestingPackage = aPackage.getNestingPackage()) != null) {
			aPackage = nestingPackage;
			context.importNamespace(aPackage, null);
		}
	}

	@Override
	public void postProcess(@NonNull BaseCSResource csResource, @NonNull Map<Namespace, List<String>> importedNamespaces) {
		EObject eObject = csResource.getContents().get(0);
		if (eObject instanceof CompleteOCLDocumentCS) {
			context.createImports((CompleteOCLDocumentCS) eObject, importedNamespaces);
		}
	}

	protected void refreshPathNamedElement(@NonNull PathNameDeclCS csDecl, @NonNull NamedElement namedElement, Namespace scope) {
		PathNameCS csPathName = csDecl.getPathName();
		if (csPathName == null) {
			csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			assert csPathName != null;
			csDecl.setPathName(csPathName);
		}
		context.refreshPathName(csPathName, namedElement, scope);
	}

	@Override
	public ElementCS visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		return visitType(object);
	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		ConstraintCS csElement = context.refreshNamedElement(ConstraintCS.class, BaseCSPackage.Literals.CONSTRAINT_CS, object);
		if (csElement != null) {
			Namespace namespace = PivotUtil.getNamespace(object);
			LanguageExpression specification = object.getSpecification();
			if ((specification != null) && (namespace != null)) {
				specification.accept(this);					// Deep search for references
				ExpSpecificationCS csSpec = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS, specification);
				csElement.setSpecification(csSpec);
				//
				MetaModelManager metaModelManager = context.getMetaModelManager();
				PrettyPrintOptions.Global prettyPrintOptions = PrettyPrinter.createOptions(null); //metaModelManager.getPrimaryElement(namespace));
				@SuppressWarnings("null")@NonNull ArrayList<String> newArrayList = Lists.newArrayList("body", "context", "def", "endpackage", "inv", "package", "post", "inv");
				prettyPrintOptions.addReservedNames(newArrayList);	// FIXME use grammar
				prettyPrintOptions.setMetaModelManager(metaModelManager);
				prettyPrintOptions.setLinelength(80);
				Resource resource = object.eResource();
				AliasAnalysis adapter = resource != null ? AliasAnalysis.getAdapter(resource) : null;
				if (adapter != null) {
					for (@SuppressWarnings("null")@NonNull DomainPackage aliased : adapter.getAliases()) {
						DomainPackage primary = metaModelManager.getPrimaryPackage(aliased);
						if (primary instanceof Namespace) {
							String alias = adapter.getAlias((Namespace) primary, null);
							if (alias != null) {
								prettyPrintOptions.addAliases((Namespace) primary, alias);
							}
						}
					}
				}
				// FIXME BUG 419132 Need to do this in a deferred pass
				String expr = PrettyPrinter.print(specification, prettyPrintOptions);		
				csSpec.setExprString("\t" + expr.trim().replaceAll("\\r", "").replaceAll("\\n", "\n\t\t"));
			}
			else {
				ExpSpecificationCS csSpec = EssentialOCLCSFactory.eINSTANCE.createExpSpecificationCS();
				csElement.setSpecification(csSpec);
				csSpec.setExprString("\tnull");
			}
		}
		return csElement;
	}

	@Override
	public ElementCS visitDataType(@NonNull DataType object) {
		return visitType(object);
	}

	@Override
	public ElementCS visitEnumeration(@NonNull org.eclipse.ocl.examples.pivot.Enumeration object) {
		return visitType(object);
	}

	@Override
	public ElementCS visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		safeVisit(object.getBodyExpression());
		return super.visitExpressionInOCL(object);
	}

	@Override
	public ElementCS visitOperation(@NonNull Operation object) {
		if ((object.getPrecondition().size() <= 0) && (object.getBodyExpression() == null) && (object.getPostcondition().size() <= 0)) {
			return null;
		}
		Type modelType = object.getOwningType();
		org.eclipse.ocl.examples.pivot.Package modelPackage = modelType.getPackage();
		org.eclipse.ocl.examples.pivot.Class savedScope = context.setScope((org.eclipse.ocl.examples.pivot.Class)modelType);
		OperationContextDeclCS csContext = context.refreshElement(OperationContextDeclCS.class, CompleteOCLCSPackage.Literals.OPERATION_CONTEXT_DECL_CS, object);
		if (csContext != null) {
			refreshPathNamedElement(csContext, object, modelPackage);
//			csContext.getNamespace().add(owningType);
			csContext.setOwnedType(convertTypeRef(object));
			org.eclipse.ocl.examples.pivot.Package owningPackage = object.getOwningType().getPackage();
			if (owningPackage != null) {
				importPackage(owningPackage);
			}
			context.refreshList(csContext.getParameters(), context.visitDeclarations(ParameterCS.class, object.getOwnedParameter(), null));
			context.refreshList(csContext.getPreconditions(), context.visitDeclarations(ConstraintCS.class, object.getPrecondition(), null));
			context.refreshList(csContext.getPostconditions(), context.visitDeclarations(ConstraintCS.class, object.getPostcondition(), null));
			context.refreshList(csContext.getBodies(), context.visitDeclarationAsList(ExpSpecificationCS.class, object.getBodyExpression()));
			context.setScope(savedScope);
		}
		return csContext;
	}

	@Override
	public ElementCS visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package object) {
		ElementCS csElement = null;
		assert object.eContainer() != null;
		List<ContextDeclCS> contexts = new ArrayList<ContextDeclCS>();
		for (Type type : object.getOwnedType()) {
			assert type != null;
			ClassifierContextDeclCS classifierContext = context.visitDeclaration(ClassifierContextDeclCS.class, type);
			if (classifierContext !=  null) {
				contexts.add(classifierContext);
			}
			for (Operation operation : type.getOwnedOperation()) {
				assert operation != null;
				OperationContextDeclCS operationContext = context.visitDeclaration(OperationContextDeclCS.class, operation);
				if (operationContext !=  null) {
					contexts.add(operationContext);
				}
			}
			for (Property property : type.getOwnedAttribute()) {
				assert property != null;
				PropertyContextDeclCS propertyContext = context.visitDeclaration(PropertyContextDeclCS.class, property);
				if (propertyContext !=  null) {
					contexts.add(propertyContext);
				}
			}
		}
		if (contexts.size() > 0) {
			PackageDeclarationCS csPackage = context.refreshElement(PackageDeclarationCS.class, CompleteOCLCSPackage.Literals.PACKAGE_DECLARATION_CS, object);
			if (csPackage != null) {
//				context.refreshList(csPackage.getOwnedType(), context.visitDeclarations(ClassifierCS.class, object.getOwnedType(), null));
				refreshPathNamedElement(csPackage, object, PivotUtil.getContainingNamespace(object));
				importPackage(object);
				context.refreshList(csPackage.getContexts(), contexts);
				csElement = csPackage;
			}
		}
		return csElement;
	}

	@Override
	public ElementCS visitParameter(@NonNull Parameter object) {
//		VariableCS csElement = context.refreshNamedElement(VariableCS.class, EssentialOCLCSPackage.Literals.VARIABLE_CS, object);
		ParameterCS csElement = context.refreshNamedElement(ParameterCS.class, BaseCSPackage.Literals.PARAMETER_CS, object);
		csElement.setOwnedType(convertTypeRef(object));
		return csElement;
	}

	@Override
	public ElementCS visitProperty(@NonNull Property object) {
		if (object.getDefaultExpression() == null) {
			return null;
		}
		Type modelType = object.getOwningType();
		org.eclipse.ocl.examples.pivot.Package modelPackage = modelType.getPackage();
		org.eclipse.ocl.examples.pivot.Class savedScope = context.setScope((org.eclipse.ocl.examples.pivot.Class)modelType);
		PropertyContextDeclCS csContext = context.refreshElement(PropertyContextDeclCS.class, CompleteOCLCSPackage.Literals.PROPERTY_CONTEXT_DECL_CS, object);
		if ((csContext != null) && (modelPackage != null)) {
			refreshPathNamedElement(csContext, object, modelPackage);
	//		csContext.getNamespace().add(owningType);
			csContext.setOwnedType(convertTypeRef(object));
			importPackage(modelPackage);
			// FIXME derivationInvariants here rather than in Classifier
//			context.refreshList(csContext.getRules(), context.visitDeclarations(ContextConstraintCS.class, ownedRule, null));
			context.refreshList(csContext.getDefaultExpressions(), context.visitDeclarationAsList(ExpSpecificationCS.class, object.getDefaultExpression()));
			context.setScope(savedScope);
		}
		return csContext;
	}

	protected <T extends ConstraintCS> void refreshPropertyConstraints(@NonNull Class<T> csConstraintClass, @NonNull List<? super T> csPropertyConstraints, Property object) {
		T csConstraint = null;
		LanguageExpression defaultExpression = object.getDefaultExpression();
		if (defaultExpression != null) {
			csConstraint = context.visitDeclaration(csConstraintClass, defaultExpression);
		}
		if (csConstraint != null) {
			csConstraint.setStereotype(UMLReflection.DERIVATION);
			context.refreshList(csPropertyConstraints, Collections.singletonList(csConstraint));
		}
		else {
			csPropertyConstraints.clear();
		}
	}

	@Override
	public ElementCS visitRoot(@NonNull Root object) {
		ElementCS csElement;
		assert object.eContainer() == null;
		CompleteOCLDocumentCS csDocument = context.refreshElement(CompleteOCLDocumentCS.class, CompleteOCLCSPackage.Literals.COMPLETE_OCL_DOCUMENT_CS, object);
		List<org.eclipse.ocl.examples.pivot.Package> allPackages = new ArrayList<org.eclipse.ocl.examples.pivot.Package>();
		List<Package> nestedPackages = object.getNestedPackage();
		assert nestedPackages != null;
		gatherPackages(allPackages, nestedPackages); 
		context.refreshList(csDocument.getPackages(), context.visitDeclarations(PackageDeclarationCS.class, allPackages, null));
		csElement = csDocument;
		return csElement;
	}

	@Override
	public ElementCS visitType(@NonNull Type object) {
		List<Constraint> ownedInvariant = object.getOwnedInvariant();
		if (ownedInvariant.size() <= 0) {
			return null;
		}
		org.eclipse.ocl.examples.pivot.Package objectPackage = object.getPackage();
		ClassifierContextDeclCS csContext = context.refreshElement(ClassifierContextDeclCS.class, CompleteOCLCSPackage.Literals.CLASSIFIER_CONTEXT_DECL_CS, object);
		if ((csContext != null) && (objectPackage != null)) {
			refreshPathNamedElement(csContext, object, objectPackage);
			importPackage(objectPackage);
			context.refreshList(csContext.getInvariants(), context.visitDeclarations(ConstraintCS.class, ownedInvariant, null));
		}
		return csContext;
	}
}
