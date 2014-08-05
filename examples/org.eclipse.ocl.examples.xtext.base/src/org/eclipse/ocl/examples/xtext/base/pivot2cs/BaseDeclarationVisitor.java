/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.pivot2cs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Import;
import org.eclipse.ocl.examples.pivot.LanguageExpression;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSFactory;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DetailCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;

public class BaseDeclarationVisitor extends AbstractExtendingVisitor<ElementCS, Pivot2CSConversion>
{
	public BaseDeclarationVisitor(@NonNull Pivot2CSConversion context) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
	}

	/**
	 * After the visit to all elements, perform any post-processing such as installing imports.
	 */
	public void postProcess(@NonNull BaseCSResource csResource, @NonNull Map<Namespace, List<String>> importedNamespaces) {}

	@Override
	public ElementCS visitAnnotation(@NonNull org.eclipse.ocl.examples.pivot.Annotation object) {
		AnnotationCS csElement = context.refreshNamedElement(AnnotationCS.class, BaseCSPackage.Literals.ANNOTATION_CS, object);
		context.refreshList(csElement.getOwnedContent(), context.visitDeclarations(ModelElementCS.class, object.getOwnedContent(), null));
		context.refreshList(csElement.getOwnedDetail(), context.visitDeclarations(DetailCS.class, object.getOwnedDetail(), null));
		List<Element> references = object.getReference();
		if (references.size() > 0) {
			List<ModelElementRefCS> csReferences = new ArrayList<ModelElementRefCS>(references.size());
			for (Element reference : references) {
				if (reference != null) {
					ModelElementRefCS csRef = BaseCSFactory.eINSTANCE.createModelElementRefCS();
					@SuppressWarnings("null") @NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
					csRef.setPathName(csPathName);
					context.refreshPathName(csPathName, reference, context.getScope());
					csReferences.add(csRef);
				}
			}
			context.refreshList(csElement.getOwnedReference(), csReferences);
		}
		else {
			csElement.getOwnedReference().clear();
		}
		return csElement;
	}

	@Override
	public ElementCS visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		org.eclipse.ocl.examples.pivot.Class savedScope = context.setScope(object);
		ClassCS csElement = context.refreshClassifier(ClassCS.class, BaseCSPackage.Literals.CLASS_CS, object);
		context.refreshList(csElement.getOwnedProperty(), context.visitDeclarations(StructuralFeatureCS.class, object.getOwnedAttribute(),
			new Pivot2CS.Predicate<Property>()
			{
				public boolean filter(@NonNull Property element) {
					return !element.isImplicit();
				}
			}));
		context.refreshList(csElement.getOwnedOperation(), context.visitDeclarations(OperationCS.class, object.getOwnedOperation(), null));
		final Type oclElementType = context.getMetaModelManager().getOclElementType();
		context.refreshList(csElement.getOwnedSuperType(), context.visitReferences(TypedRefCS.class, object.getSuperClass(),
			new Pivot2CS.Predicate<Type>()
			{
				public boolean filter(@NonNull Type element) {
					return element != oclElementType;
				}
			}));
		context.refreshQualifiers(csElement.getQualifier(), "abstract", object.isAbstract());
		context.refreshQualifiers(csElement.getQualifier(), "interface", object.isInterface());
		context.setScope(savedScope);
		return csElement;
	}

//	@Override
//	public ElementCS visitComment(Comment object) {
//		ParameterCS pivotElement = context.refreshNamedElement(ParameterCS.class, BaseCSPackage.Literals.COMMENT_CS, object);
//		return null;
//	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		ConstraintCS csElement = context.refreshNamedElement(ConstraintCS.class, BaseCSPackage.Literals.CONSTRAINT_CS, object);
		LanguageExpression specification = object.getSpecification();
		csElement.setSpecification(specification != null ? context.visitDeclaration(SpecificationCS.class, specification) : null);
		return csElement;
	}

	@Override
	public ElementCS visitDataType(@NonNull DataType object) {
		DataTypeCS csElement = context.refreshClassifier(DataTypeCS.class, BaseCSPackage.Literals.DATA_TYPE_CS, object);
		context.refreshQualifiers(csElement.getQualifier(), "serializable", object.isSerializable());
		return csElement;
	}

	@Override
	public ElementCS visitDetail(@NonNull Detail object) {
		DetailCS csElement = context.refreshNamedElement(DetailCS.class, BaseCSPackage.Literals.DETAIL_CS, object);
		csElement.getValue().clear();
		csElement.getValue().addAll(object.getValue());
		return csElement;
	}

	@Override
	public ElementCS visitEnumeration(@NonNull org.eclipse.ocl.examples.pivot.Enumeration object) {
		EnumerationCS csElement = context.refreshClassifier(EnumerationCS.class, BaseCSPackage.Literals.ENUMERATION_CS, object);
		context.refreshList(csElement.getOwnedLiterals(), context.visitDeclarations(EnumerationLiteralCS.class, object.getOwnedLiteral(), null));
		context.refreshQualifiers(csElement.getQualifier(), "serializable", object.isSerializable());
		return csElement;
	}

	@Override
	public ElementCS visitEnumerationLiteral(@NonNull EnumerationLiteral object) {
		EnumerationLiteralCS csElement = context.refreshNamedElement(EnumerationLiteralCS.class,
			BaseCSPackage.Literals.ENUMERATION_LITERAL_CS, object);
		if (object.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE)) {
			csElement.setValue(object.getValue().intValue());
		}
		else {
			csElement.eUnset(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE);
		}
		return csElement;
	}

	@Override
	public ElementCS visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		SpecificationCS csElement = context.refreshElement(SpecificationCS.class, BaseCSPackage.Literals.SPECIFICATION_CS, object);
		String body = object.getBody();
		csElement.setExprString(body);
		return csElement;
	}

	@Override
	public ElementCS visitImport(@NonNull Import object) {
		Namespace importedNamespace = object.getImportedNamespace();
		if (importedNamespace != null) {
			context.importNamespace(importedNamespace, object.getName());
		}
		return null;
	}

	@Override
	public ElementCS visitOperation(@NonNull Operation object) {
		OperationCS csElement = context.refreshTypedElement(OperationCS.class, BaseCSPackage.Literals.OPERATION_CS, object);
		TemplateSignature ownedTemplateSignature = object.getOwnedTemplateSignature();
		csElement.setOwnedTemplateSignature(context.visitDeclaration(TemplateSignatureCS.class, ownedTemplateSignature));
		context.refreshList(csElement.getOwnedParameter(), context.visitDeclarations(ParameterCS.class, object.getOwnedParameter(), null));
		context.refreshList(csElement.getOwnedException(), context.visitReferences(TypedRefCS.class, object.getRaisedException(), null));
		//
		context.refreshList(csElement.getOwnedPrecondition(), context.visitDeclarations(ConstraintCS.class, object.getPrecondition(), null));
		List<LanguageExpression> bodyExpressions = object.getBodyExpression() != null ? Collections.singletonList(object.getBodyExpression()) : Collections.<LanguageExpression>emptyList();
		context.refreshList(csElement.getOwnedBodyExpression(), context.visitDeclarations(SpecificationCS.class, bodyExpressions, null));
		context.refreshList(csElement.getOwnedPostcondition(), context.visitDeclarations(ConstraintCS.class, object.getPostcondition(), null));
		return csElement;
	}

	@Override
	public ElementCS visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package object) {
		PackageCS csPackage = context.refreshNamedElement(PackageCS.class, BaseCSPackage.Literals.PACKAGE_CS, object);
		context.refreshList(csPackage.getOwnedType(), context.visitDeclarations(ClassifierCS.class, object.getOwnedType(), null));
		csPackage.setNsPrefix(object.getNsPrefix());
		csPackage.setNsURI(object.getURI());
		context.refreshList(csPackage.getOwnedNestedPackage(), context.visitDeclarations(PackageCS.class, object.getNestedPackage(), null));
		return csPackage;
	}

	@Override
	public ElementCS visitParameter(@NonNull Parameter object) {
		ParameterCS csElement = context.refreshTypedElement(ParameterCS.class, BaseCSPackage.Literals.PARAMETER_CS, object);
		return csElement;
	}

	@Override
	public ElementCS visitProperty(@NonNull Property object) {
		StructuralFeatureCS csElement;
		Type type = object.getType();
		if (type instanceof CollectionType) {
			type = ((CollectionType)type).getElementType();
		}
		if (type instanceof DataType) {
			AttributeCS csAttribute = context.refreshStructuralFeature(AttributeCS.class, BaseCSPackage.Literals.ATTRIBUTE_CS, object);
			context.refreshQualifiers(csAttribute.getQualifier(), "id", object.isID());
			csElement = csAttribute;
		}
		else {
			ReferenceCS csReference = context.refreshStructuralFeature(ReferenceCS.class, BaseCSPackage.Literals.REFERENCE_CS, object);
			context.refreshQualifiers(csReference.getQualifier(), "composes", object.isComposite());
			context.refreshQualifiers(csReference.getQualifier(), "resolve", "!resolve", object.isResolveProxies() ? null : Boolean.FALSE);
			Property opposite = object.getOpposite();
			if (opposite != null) {
				if (!opposite.isImplicit()) {
					csReference.setOpposite(opposite);
				}
				else {
					// FIXME BUG 377626
				}
			}
			context.refreshList(csReference.getKeys(), object.getKeys());
			csElement = csReference;
		}
		List<LanguageExpression> defaultExpressions = object.getDefaultExpression() != null ? Collections.singletonList(object.getDefaultExpression()) : Collections.<LanguageExpression>emptyList();
		context.refreshList(csElement.getOwnedDefaultExpression(), context.visitDeclarations(SpecificationCS.class, defaultExpressions, null));
		return csElement;
	}

	@Override
	public ElementCS visitRoot(@NonNull Root object) {
		RootPackageCS csElement = context.refreshElement(RootPackageCS.class, BaseCSPackage.Literals.ROOT_PACKAGE_CS, object);
		context.refreshList(csElement.getOwnedNestedPackage(), context.visitDeclarations(PackageCS.class, object.getNestedPackage(), null));
		context.visitDeclarations(ImportCS.class, object.getImports(), null);
		return csElement;
	}

	@Override
	public ElementCS visitTemplateSignature(@NonNull TemplateSignature object) {
		TemplateSignatureCS csElement = context.refreshElement(TemplateSignatureCS.class, BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS, object);
		context.refreshList(csElement.getOwnedTemplateParameter(), context.visitDeclarations(TemplateParameterCS.class, object.getOwnedParameter(), null));
		return csElement;
	}

	@Override
	public ElementCS visitTypeTemplateParameter(@NonNull TypeTemplateParameter object) {
		ParameterableElement parameteredElement = object.getParameteredElement();
		if (parameteredElement == null) {
			return null;
		}
		TypeParameterCS csElement = context.refreshElement(TypeParameterCS.class, BaseCSPackage.Literals.TYPE_PARAMETER_CS, parameteredElement);
		csElement.setName(((NamedElement) parameteredElement).getName());
		return csElement;
	}

	public ElementCS visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for Pivot2CS Declaration pass");
	}
}
