/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.lookup;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.lookup.Environment;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * LookupCG2JavaVisitor refines the regular generation of Java code from an optimized Auto CG transformation tree
 * to add contributions that are inadequately represented by the CG model.
 */
public class LookupCG2JavaVisitor extends AutoCG2JavaVisitor<LookupCodeGenerator>
{
	public LookupCG2JavaVisitor(@NonNull LookupCodeGenerator codeGenerator, @NonNull CGPackage cgPackage,
			@Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator, cgPackage, sortedGlobals);
	}

	@Override
	protected void doConstructor(@NonNull CGClass cgClass) {
		js.append("public " + cgClass.getName() + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(Environment.class);
		js.append(" " + LookupClassContext.CONTEXT_NAME + ") {\n");
		js.pushIndentation(null);
			js.append("super(" + LookupClassContext.CONTEXT_NAME + ");\n");
			js.append("this." + JavaConstants.EVALUATOR_NAME + " = " + LookupClassContext.CONTEXT_NAME + ".getEvaluator();\n");
			js.append("this." + JavaConstants.ID_RESOLVER_NAME + " = " + JavaConstants.EVALUATOR_NAME + ".getIdResolver();\n");
		js.popIndentation();
		js.append("}\n");
		doEnvForChild(cgClass);
		doParentEnv(cgClass);
	}
  	
	/**
	 * protected @Nullable Environment envForChild(@NonNull Element element, @Nullable Element child) {
	 *    this.child = child;
	 *    return element.accept(this);
	 * }
	 */
	protected void doEnvForChild(@NonNull CGClass cgClass) {
		js.append("\n");
		js.append("/**\n");
		js.append(" * Return the results of a lookup from the " + LookupClassContext.CHILD_NAME + " of " + LookupClassContext.ELEMENT_NAME + ".\n");
		js.append(" */\n");
		js.append("public ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(Environment.class);
		js.append(" " + LookupClassContext.ENV_FOR_CHILD_NAME + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(Element.class);
		js.append(" " + LookupClassContext.ELEMENT_NAME + ", ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(Element.class);
		js.append(" " + LookupClassContext.CHILD_NAME + ") {\n");
		js.pushIndentation(null);
			js.append("this.");
			js.appendReferenceTo(context.getChildVariable());
			js.append(" = " + LookupClassContext.ELEMENT_NAME + ";\n");
			js.append("return (");
			js.appendClassReference(Environment.class);
			js.append(")" + LookupClassContext.ELEMENT_NAME);
			js.append(".accept(this);\n");
		js.popIndentation();
		js.append("}\n");
	}
  	
	/**
	 * protected @Nullable Environment parentEnv(@NonNull Element element) {
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
		js.append(" * Continue the search for matches in the parent of " + LookupClassContext.ELEMENT_NAME + ".\n");
		js.append(" */\n");
		js.append("protected ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(Environment.class);
		js.append(" " + LookupClassContext.PARENT_ENV_NAME + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(Element.class);
		js.append(" " + LookupClassContext.ELEMENT_NAME + ") {\n");
		js.pushIndentation(null);
			js.appendClassReference(EObject.class);
			js.append(" " + LookupClassContext.PARENT_NAME + " = " + LookupClassContext.ELEMENT_NAME + ".eContainer();\n");
			js.append("if (" + LookupClassContext.PARENT_NAME + " instanceof ");
			js.appendClassReference(Visitable.class);
			js.append(") {\n");
			js.pushIndentation(null);
				js.append("this.");
				js.appendReferenceTo(context.getChildVariable());
				js.append(" = " + LookupClassContext.ELEMENT_NAME + ";\n");
				js.append("return (");
				js.appendClassReference(Environment.class);
				js.append(")((");
				js.appendClassReference(Visitable.class);
				js.append(")" + LookupClassContext.PARENT_NAME + ").accept(this);\n");
			js.popIndentation();
			js.append("}\n");
			js.append("else {\n");
			js.pushIndentation(null);
				js.append("return null;\n");		
			js.popIndentation();
		js.append("}\n");
		js.popIndentation();
		js.append("}\n");
	}
}
