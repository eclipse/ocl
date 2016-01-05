/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
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
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;

/**
 * CS2ASCG2JavaVisitor refines the regular generation of Java code from an optimized Auto CG transformation tree
 * to add contributions that are inadequately represented by the CG model.
 */
public class CS2ASCG2JavaVisitor extends AutoCG2JavaVisitor<@NonNull CS2ASCodeGenerator>
{
	public CS2ASCG2JavaVisitor(@NonNull CS2ASCodeGenerator codeGenerator, @NonNull CGPackage cgPackage,
			@Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator, cgPackage, sortedGlobals);
	}

	@Override
	protected void doClassFields(@NonNull CGClass cgClass) {
		js.append("protected final ");
	    js.appendIsRequired(true);
	    js.append(" ");
	    js.appendClassReference(CS2AS.class);
	    js.append(" converter;\n");
	    js.append("protected final ");
	    js.appendIsRequired(true);
	    js.append(" ");
	    js.appendClassReference(IdResolver.class);
	    js.append(" idResolver;\n");
		js.append("\n");
	}

	@Override
	protected void doConstructor(@NonNull CGClass cgClass) {
		js.append("/**\n");
		js.append(" * Initializes me with an initial value for my result.\n");
		js.append(" * \n");
		js.append(" * @param context my initial result value\n");
		js.append(" */\n");
		js.append("public " + cgClass.getName() + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(CS2ASConversion.class);
		js.append(" context) {\n");
		js.pushIndentation(null);
		js.append("super(context);\n");
		js.append("this.converter = context.getConverter();\n");
		js.append("this.idResolver = converter.getEnvironmentFactory().getIdResolver();\n");
		js.popIndentation();
		js.append("}\n");
	}

	@Override
	public @NonNull Boolean visitCGASTCallExp(@NonNull CGASTCallExp object) {
		CGValuedElement cgSource = ClassUtil.nonNullState(object.getSource());
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
	public @NonNull Boolean visitCGContainmentBody(@NonNull CGContainmentBody object) {
		org.eclipse.ocl.pivot.Class asType = (org.eclipse.ocl.pivot.Class)ClassUtil.nonNullState(((Operation) object.getAst()).getType());	// FIXME cast
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

	@Override
	public @NonNull Boolean visitCGContainmentPart(@NonNull CGContainmentPart object) {
		CGValuedElement cgInit = ClassUtil.nonNullState(object.getInit());
		EStructuralFeature eStructuralFeature = ClassUtil.nonNullModel(object.getEStructuralFeature());
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

	@Override
	public @NonNull Boolean visitCGContainmentVisit(@NonNull CGContainmentVisit object) {
		JavaLocalContext<?> localContext2 = globalContext.getLocalContext(object);
		if (localContext2 != null) {
			localContext = localContext2;
			try {
				CGValuedElement cgContainmentBody = ClassUtil.nonNullState(object.getBody());
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
				js.append(PivotConstants.SELF_NAME);
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

	@Override
	public @NonNull Boolean visitCGEcoreOperation(@NonNull CGEcoreOperation object) {
		String visitName = object.getName();
		Type csType = (Type) object.getAst();
		TypeDescriptor typeDescriptor = context.getUnboxedDescriptor(csType.getTypeId());
		js.append("@Override\n");
		js.append("public ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(Continuation.class);
		js.append(" " + object.getName() + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(typeDescriptor);
		js.append(" ");
		js.append(PivotConstants.SELF_NAME);
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
}
