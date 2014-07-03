/**
 * Copyright (c) 2014 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		 Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation
 */

package org.eclipse.ocl.examples.autogen.cs2as;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;
import org.eclipse.ocl.examples.autogen.autocgmodel.util.AutoCGModelVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;


public class AutoCG2JavaContainmentVisitor extends AutoCG2JavaVisitor 
	implements AutoCGModelVisitor<Boolean>{

	public AutoCG2JavaContainmentVisitor(@NonNull AutoCodeGenerator codeGenerator,
			@NonNull CGPackage cgPackage, @Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator, cgPackage, sortedGlobals);
	}

	protected void doConstructor(@NonNull CGClass cgClass) {
		js.append("/**\n");
		js.append(" * Initializes me with an initial value for my result.\n");
		js.append(" * \n");
		js.append(" * @param context my initial result value\n");
		js.append(" */\n");
		js.append("public " + cgClass.getName() + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(CS2PivotConversion.class);
		js.append(" context) {\n");
		js.pushIndentation(null);
		js.append("super(context);\n");
		js.append("this.converter = context.getConverter();\n");
			js.append("this.idResolver = converter.getMetaModelManager().getIdResolver();\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doVisiting() {
		js.append("public ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(Continuation.class);
		js.append(" visiting(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(VisitableCS.class);
		js.append(" visitable) {\n");
		js.pushIndentation(null);
		js.append("throw new UnsupportedOperationException();\n");
		js.popIndentation();
		js.append("}\n");
	}

	public @NonNull Boolean visitCGASTCallExp(@NonNull CGASTCallExp object) {
		CGValuedElement cgSource = DomainUtil.nonNullState(object.getSource());
		TypeDescriptor typeDescriptor = context.getTypeDescriptor(object);
		if (!js.appendLocalStatements(cgSource)) {
			return false;
		}
		js.appendDeclaration(object);
		js.append(" = ");
		js.appendReferenceTo(typeDescriptor, cgSource);
		js.append(".getPivot();\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGClass(@NonNull CGClass cgClass) {		
		String className = cgClass.getName();
		js.append("public class " + className);
		List<CGClass> cgSuperTypes = cgClass.getSuperTypes();
		boolean isFirst = true;
		for (CGClass cgSuperType : cgSuperTypes) {
			if (!cgSuperType.isInterface()) {
				if (isFirst) {
					js.append("\n\textends ");
				}
				else {
					js.append(", ");
				}
				js.appendClassReference(cgSuperType);
				isFirst = false;
			}
		}
		isFirst = true;
		for (CGClass cgSuperType : cgSuperTypes) {
			if (cgSuperType.isInterface()) {
				if (isFirst) {
					js.append("\n\timplements ");
				}
				else {
					js.append(", ");
				}
				js.appendClassReference(cgSuperType);
				isFirst = false;
			}
		}
		js.append("\n");
		js.append("{\n");
		js.pushIndentation(null);
		if (sortedGlobals != null) {
			for (CGValuedElement cgElement : sortedGlobals) {
				assert cgElement.isGlobal();
				cgElement.accept(this);
			}
		}
		js.append("\n");
	    js.append("protected final ");
	    js.appendIsRequired(true);
	    js.append(" ");
	    js.appendClassReference(CS2Pivot.class);
	    js.append(" converter;\n");
	    js.append("protected final ");
	    js.appendIsRequired(true);
	    js.append(" ");
	    js.appendClassReference(IdResolver.class);
	    js.append(" idResolver;\n");
		js.append("\n");
		doConstructor(cgClass);
		if (cgSuperTypes.size() <= 1) {
			js.append("\n");
			doVisiting();
		}
		for (CGOperation cgOperation : cgClass.getOperations()) {
			js.append("\n");
			cgOperation.accept(this);
		}
		js.popIndentation();
		js.append("}\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGEcoreOperation(@NonNull CGEcoreOperation object) {
		String visitName = object.getName();
		Type csType = (Type) object.getAst();
		TypeDescriptor typeDescriptor = context.getUnboxedDescriptor(csType.getTypeId());
		js.append("public ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(Continuation.class);
		js.append(" " + object.getName() + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(typeDescriptor);
		js.append(" ");
		js.append("self");
		js.append(") {\n");
		js.pushIndentation(null);
		js.append("throw new UnsupportedOperationException(\"");
		js.append(visitName);
		js.append(" is not supported by \" + getClass().getName()");
		js.append(");\n");
		js.popIndentation();
		js.append("}\n");
		return true;
	}

	public @Nullable Boolean visitCGContainmentBody(@NonNull CGContainmentBody object) {
		Type asType = DomainUtil.nonNullState(((Operation) object.getAst()).getType());
		String factoryName = context.getGenModelHelper().getQualifiedFactoryInterfaceName(asType);
		// TypeDescriptor typeDescriptor = context.getTypeDescriptor(asType.getTypeId(), false);
		String typeQualifiedName = context.getGenModelHelper().getEcoreInterfaceName(asType);
		js.append("//\n");
		js.append("// " + asType.getName() + "\n");
		js.append("//\n");
		js.appendClassReference(typeQualifiedName);
		js.append(" result;\n");
		js.appendClassReference(Element.class);
		js.append(" element = converter.getPivotElement(self);\n");
		
		js.append("if ((element != null) && (element.getClass() == ");
		js.appendClassReference(typeQualifiedName);
		js.append(".class)) {\n");
		js.pushIndentation(null);
		js.append("result = (");
		js.appendClassReference(typeQualifiedName);
		js.append(")element;\n");
		js.popIndentation();
		js.append("}\n");
		
		js.append("else {\n");
		js.pushIndentation(null);
		js.append("result = ");
		js.appendClassReference(factoryName);
		js.append(".eINSTANCE.create" + asType.getName() + "();\n");
		//
		js.append("assert result != null;\n");
		//
		js.append("converter.installPivotDefinition(self, result);\n");
		js.popIndentation();
		js.append("}\n");
		
		for (CGContainmentPart part : object.getParts()) {
			part.accept(this);
		}
		// TODO any heuristic to include comment update ?
		js.append("// AS element comments update;\n");
		js.append("context.refreshComments(result, self);\n");
		return true;
	}

	public @NonNull Boolean visitCGContainmentPart(@NonNull CGContainmentPart object) {
		CGValuedElement cgInit = DomainUtil.nonNullState(object.getInit());
		EStructuralFeature eStructuralFeature = DomainUtil.nonNullModel(object.getEStructuralFeature());
		js.append("//\n");
		js.append("// " + eStructuralFeature.getEContainingClass().getName() + "::" + eStructuralFeature.getName() + "\n");
		js.append("//\n");
		if (!js.appendLocalStatements(cgInit)) {
			return false;
		}
		//
		String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
		if (eStructuralFeature.isMany()) {
			js.append("context.refreshList(result.");
			js.append(getAccessor);
			js.append("(), ");
			js.appendValueName(cgInit);
			js.append(");\n");
		}
		else {
			String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
			String gotName = getSymbolName(null, getAccessor);
			TypeDescriptor initTypeDescriptor = context.getTypeDescriptor(cgInit);
			EClassifier eType = eStructuralFeature.getEType();
			Class<?> instanceClass = eType != null ? eType.getInstanceClass() : null;
			TypeId javaTypeId = instanceClass != null ? JavaConstants.getJavaTypeId(instanceClass) : TypeId.OCL_VOID;
			TypeDescriptor getTypeDescriptor = context.getUnboxedDescriptor(javaTypeId);
			//
			js.appendIsRequired(cgInit.isRequired());
			js.append(" ");
			js.appendClassReference(initTypeDescriptor);
			js.append(" " + gotName + " = result.");
			js.append(getAccessor);
			js.append("();\n");
			//
			js.append("if (");
			initTypeDescriptor.appendNotEqualsTerm(js, cgInit, getTypeDescriptor, gotName);
			js.append(") {\n");
			js.pushIndentation(null);
				js.append("result.");
				js.append(setAccessor);
				js.append("(");
				js.appendValueName(cgInit);
				js.append(");\n");
			js.popIndentation();
			js.append("}\n");
		}
		return true;
	}

	public @NonNull Boolean visitCGContainmentVisit(@NonNull CGContainmentVisit object) {
		JavaLocalContext localContext2 = globalContext.getLocalContext(object);
		if (localContext2 != null) {
			localContext = localContext2;
			try {
				CGValuedElement cgContainmentBody = DomainUtil.nonNullState(object.getBody());
				Type csType = (Type) object.getAst();
				TypeDescriptor typeDescriptor = context.getUnboxedDescriptor(csType.getTypeId());
				js.append("public ");
				js.appendIsRequired(false);
				js.append(" ");
				js.appendClassReference(Continuation.class);
				js.append(" " + object.getName() + "(");
				js.appendIsRequired(true);
				js.append(" ");
				js.appendClassReference(typeDescriptor);
				js.append(" ");
				js.append("self");
				js.append(") {\n");
				js.pushIndentation(null);
				cgContainmentBody.accept(this);
				js.append("return null;\n");
				js.popIndentation();
				js.append("}\n");
			}
			finally {
				localContext = null;
			}
		}
		return true;
	}
}
