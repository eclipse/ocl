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
package org.eclipse.ocl.examples.autogen.namereso;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaVisitor;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;


public class AutoLookupCG2JavaVisitor extends AutoCG2JavaVisitor
	implements NameResoCGModelVisitor<Boolean>{

	protected final AutoNameResoCGNamesProvider nProvider;
	public AutoLookupCG2JavaVisitor(@NonNull AutoLookupCodeGenerator codeGenerator,
			@Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator, sortedGlobals);
		nProvider = codeGenerator.getCGNamesProvider(); 
	}

	@Override
	protected void doClassFields(@NonNull CGClass cgClass) {
	
	};
	
	@Override
	protected void doConstructor(@NonNull CGClass cgClass) {

		js.append("public " + cgClass.getName() + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(MetaModelManager.class);
		js.append(" mmManager, ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(EReference.class);
		js.append(" reference, ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(String.class);
		js.append(" name) {\n");
		
		js.pushIndentation(null);
		js.append("super(mmManager, reference, name);\n");
		js.popIndentation();
		js.append("}\n");		
	}

	@Override
	protected void doAdditionalClassMethods(@NonNull CGClass cgClass) {
	

//		js.append("/**\n"
//				+ "	* If the environment is complete returns the current configured environment\n"
//				+ " * otherwise, go on gathering more results from parent's context\n"
//				+ " *\n"
//				+ " * @return the configured lookup environment\n"
//				+ " */\n");
//			
//		js.appendIsRequired(true);
//		js.append("\n");
//		js.append("protected ");
//		js.appendClassReference(nProvider.getSpecificEnvironmentItf());
//		js.append(" lookupInParentIfNotComplete() {\n");
//		js.pushIndentation(null);
//		js.append("return result.isComplete() ? result : lookupInNewContext(context.getParent());\n");
//		js.popIndentation();
//		js.append("}\n");
	}	

	
	@Nullable
	public Boolean visitCGAddOp(@NonNull CGAddOp object) {
		
		localContext = globalContext.getLocalContext(object);
		try {
			js.append("public void ");	
			js.append(object.getName() + "(");
			boolean isFirst = true;
			for (@SuppressWarnings("null")@NonNull CGParameter cgParameter : object.getParameters()) {
				if (!isFirst) {
					js.append(", ");
				}
				js.appendDeclaration(cgParameter);
				isFirst = false;
			}
			js.append(") {\n");
			js.pushIndentation(null);
			
			safeVisit(object.getBody());
			
			js.append("addNamedElement(");
			js.append(object.getBody().getValueName());
			js.append(");\n");
			js.popIndentation();
			js.append("}\n");
			return true;	
		} finally{
			localContext = null;
		}
		
	}
}
