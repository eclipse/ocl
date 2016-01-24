/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (University of York) - Lookup Environment/Visitor
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.lookup;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.java.AutoVisitorsCG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;

/**
 * LookupCG2JavaVisitor refines the regular generation of Java code from an optimized Auto CG transformation tree
 * to add contributions that are inadequately represented by the CG model.
 */
public class LookupVisitorsCG2JavaVisitor extends AutoVisitorsCG2JavaVisitor<@NonNull LookupVisitorsCodeGenerator>
{
	public LookupVisitorsCG2JavaVisitor(@NonNull LookupVisitorsCodeGenerator codeGenerator, @NonNull CGPackage cgPackage,
			@Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator, cgPackage, sortedGlobals);
	}

	@Override
	protected void doConstructor(@NonNull CGClass cgClass) {
		js.append("public " + cgClass.getName() + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(getVisitorContext(cgClass)); 
		js.append(" " + LookupVisitorsClassContext.CONTEXT_NAME);
		if (LookupCGUtil.isExportedVisitorClass(cgClass)) {
			js.append(", ");
			js.appendIsRequired(true);
			js.append(" ");
			js.appendClassReference(Object.class);
			js.append(" " + LookupVisitorsClassContext.INMPORTER_NAME);
		}
		js.append(") {\n");
		js.pushIndentation(null);
			js.append("super(" + LookupVisitorsClassContext.CONTEXT_NAME + ");\n");
		if (LookupCGUtil.isCommonVisitorClass(cgClass)) {
			js.append("this." + JavaConstants.EXECUTOR_NAME + " = " + LookupVisitorsClassContext.CONTEXT_NAME + ".getExecutor();\n");
			js.append("this." + JavaConstants.ID_RESOLVER_NAME + " = " + JavaConstants.EXECUTOR_NAME + ".getIdResolver();\n");
		} else if (LookupCGUtil.isExportedVisitorClass(cgClass)) {
			js.append("this." + LookupVisitorsClassContext.INMPORTER_NAME + " = " +  LookupVisitorsClassContext.INMPORTER_NAME + ";\n");
		}
		js.popIndentation();
		js.append("}\n");
		
		if (LookupCGUtil.isUnqualifiedVisitorClass(cgClass) && !isDerivedVisitor(cgClass)) {
			doParentEnv(cgClass);
		}
	}
	
	@Override
	protected void doVisiting(@NonNull CGClass cgClass) {
		if (LookupCGUtil.isCommonVisitorClass(cgClass)) {
			super.doVisiting(cgClass);	// the default visiting method
		} else if (LookupCGUtil.isUnqualifiedVisitorClass(cgClass)) {
			js.append("\n");
			js.append("@Override\n");
			js.append("public ");
			js.appendIsRequired(false);
			js.append(" ");
			js.appendClassReference(context.getVisitorResultClass());
			js.append(" visiting(");
			js.appendIsRequired(true);
			js.append(" ");
			js.appendClassReference(context.getVisitableClass());
			js.append(" visitable) {\n");
			js.pushIndentation(null);
			js.append("return parentEnv((");
			js.appendClassReference(EObject.class);
			js.append(")");
			js.append("visitable);\n");
			js.popIndentation();
			js.append("}\n");
		} // else print nothing
	}

  	
	/**
	 * protected @Nullable Environment parentEnv(@NonNull EObject element) {
     *    EObject parent = element.eContainer();
	 *    if (parent instanceof Visitable) {
	 *        this.child = element;
	 *        return (Environment)((Visitable)parent).accept(this);
	 *    }
	 *    else {
	 *        return null;
	 *    }
	 * }
	 */
	protected void doParentEnv(@NonNull CGClass cgClass) {
		js.append("\n");
		js.append("/**\n");
		js.append(" * Continue the search for matches in the parent of " + LookupVisitorsClassContext.ELEMENT_NAME + ".\n");
		js.append(" */\n");
		js.append("protected ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(context.getEnvironmentClass());
		js.append(" " + LookupVisitorsClassContext.PARENT_ENV_NAME + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(EObject.class);
		js.append(" " + LookupVisitorsClassContext.ELEMENT_NAME + ") {\n");
		js.pushIndentation(null);
			js.appendClassReference(EObject.class);
			js.append(" " + LookupVisitorsClassContext.PARENT_NAME + " = " + LookupVisitorsClassContext.ELEMENT_NAME + ".eContainer();\n");
			js.append("if (" + LookupVisitorsClassContext.PARENT_NAME + " instanceof ");
			js.appendClassReference(context.getVisitableClass());
			js.append(") {\n");
			js.pushIndentation(null);
				js.append("this.");
				js.appendReferenceTo(context.getChildVariable());
				js.append(" = " + LookupVisitorsClassContext.ELEMENT_NAME + ";\n");
				js.append("return ((");
				js.appendClassReference(context.getVisitableClass());
				js.append(")" + LookupVisitorsClassContext.PARENT_NAME + ").accept(this);\n");
			js.popIndentation();
			js.append("}\n");
			js.append("else {\n");
			js.pushIndentation(null);
				js.append("return "+LookupVisitorsClassContext.CONTEXT_NAME +";\n");
			js.popIndentation();
		js.append("}\n");
		js.popIndentation();
		js.append("}\n");
	}
	
	
	/**
	 * @param cgClass the cgClass representing the Visitor Class
	 * @return another cgClass representing the visitor's context type
	 */
	@SuppressWarnings("null")
	private @NonNull CGClass getVisitorContext(CGClass cgClass) {
		
		
		if (LookupCGUtil.isCommonVisitorClass(cgClass)) {
			CGClass extendingVisitorCG = cgClass.getSuperTypes().get(0); // The first one is the extended visitor
			return extendingVisitorCG.getTemplateParameters().get(0); // The first one is the visitor result which will be the context
		} else {
			CGClass extendingVisitorCG = cgClass.getSuperTypes().get(1); // The second one is the visitor's interface	
			return extendingVisitorCG.getTemplateParameters().get(0); // The first one is the visitor result which will be the context
		}		
	}
	
	@Override
	protected boolean isDerivedVisitor(@NonNull CGClass cgClass) {		
		return LookupCGUtil.isDeriverdVisitorClass(cgClass);
	}
	
}
