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
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddCall;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.Visitable;


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

		js.appendIsRequired(true);
	    js.append(" protected final ");
	    js.appendClassReference(MetaModelManager.class);
	    js.append(" mmManager;\n");
	    js.appendIsRequired(true);
	    js.append(" protected final ");
	    js.appendClassReference(nProvider.getSpecificEnvironmentItf());
	    js.append(" result;\n");
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
		js.appendClassReference(nProvider.getSpecificEnvironmentItf());
		js.append(" result, ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(nProvider.getCommonContextItf());
		js.append("<");
		js.appendClassReference("org.eclipse.ocl.examples.pivot.Element"); // FIXME ADOLFOSBH parametrize
		js.append(">");		
		js.append(" context) {\n");
		
		js.pushIndentation(null);
		js.append("super(context);\n");
		js.append("this.mmManager = mmManager;\n");
		js.append("this.result = result;\n");
		js.popIndentation();
		js.append("}\n");
	}

	@Override
	protected void doVisiting(@NonNull CGClass cgClass) {
		js.append("public ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(nProvider.getSpecificEnvironmentItf());
		js.append(" visiting(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(Visitable.class); // FIXME parametrize
		js.append(" visitable) {\n");
		js.pushIndentation(null);
		js.append("return lookupInParentIfNotComplete();\n");
		js.popIndentation();
		js.append("}\n");
	}


	@Override
	protected void doAdditionalClassMethods(@NonNull CGClass cgClass) {
				
		doVisiting(cgClass); // FIXME This is a nasty workaround, due to the fragile logic in
					  // AutoCG2JavaVisitor::visitCGClass to print the doVisiting method
		
		js.appendIsRequired(true);
		js.append("\n");
		js.append("protected final ");
		js.appendClassReference(nProvider.getSpecificEnvironmentItf());
		js.append(" lookupInNewContext(");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(nProvider.getCommonContextItf());
		js.append("<");
		js.appendClassReference("org.eclipse.ocl.examples.pivot.Element"); // FIXME ADOLFOSBH parametrize
		js.append(">");		
		js.append("newContext) {\n");
		js.pushIndentation(null);
		js.append("return newContext == null ? result // If we have reached the top element\n");
		js.pushIndentation(null);
		js.append(": ");
		js.appendClassReference(DomainUtil.class);
		js.append(".nonNullState((newContext.getTarget()).accept(\n"); 
		js.append("new ");
		js.appendClassReference(nProvider.getSpecificVisitorClass());
		js.append("(mmManager, result, newContext)));\n");
		js.popIndentation();
		js.popIndentation();
		js.append("}\n");
			
		js.appendIsRequired(true);
		js.append("\n");
		js.append("protected ");
		js.appendClassReference(nProvider.getSpecificEnvironmentItf());
		js.append(" lookupFromNewElement(");
		js.appendClassReference("org.eclipse.ocl.examples.pivot.Element");
		js.append(" element) {\n");
		js.pushIndentation(null);
		js.append("return ");
		js.appendClassReference(DomainUtil.class);
		js.append(".nonNullState(element.accept(this));\n");		
		js.popIndentation();
		js.append("}\n");

		js.append("\n// Lookup propagation protocols\n\n");
		
		js.append("/**\n"
			+ "	* Used when ONLY looking up in local\n"
			+ " * @return the accumulated lookup result\n"
			+ " */\n");
		
		js.appendIsRequired(true);
		js.append("\n");
		js.append("protected ");
		js.appendClassReference(nProvider.getSpecificEnvironmentItf());
		js.append(" lookupOnlyLocal() {\n");
		js.pushIndentation(null);
		js.append("return result;\n");
		js.popIndentation();
		js.append("}\n");
		
		js.append("/**\n"
				+ "	* Used when looking up in local AND in parent environments if not found\n"
				+ " * in local -> outer scope/environment elements are occluded in nested\n"
				+ " * contexts\n"
				+ " * @return the accumulated lookup result\n"
				+ " */\n");
			
		js.appendIsRequired(true);
		js.append("\n");
		js.append("protected ");
		js.appendClassReference(nProvider.getSpecificEnvironmentItf());
		js.append(" lookupInParentIfNotComplete() {\n");
		js.pushIndentation(null);
		js.append("return result.isComplete() ? result : lookupInNewContext(context.getParent());\n");
		js.popIndentation();
		js.append("}\n");

		js.append("/**\n"
				+ "	* Used when looking up in local AND in parent environments\n"
				+ " * @return the accumulated lookup result\n"
				+ " */\n");
			
		js.appendIsRequired(true);
		js.append("\n");
		js.append("protected ");
		js.appendClassReference(nProvider.getSpecificEnvironmentItf());
		js.append(" lookupInParent() {\n");
		js.pushIndentation(null);
		js.append("return lookupInNewContext(context.getParent());\n");
		js.popIndentation();
		js.append("}\n");
		
	}	

	@Nullable
	public Boolean visitCGAddCall(@NonNull CGAddCall object) {
		
		js.append("ADD CALL\n");
				
		return true;
	}

	@Nullable
	public Boolean visitCGEnvVisitOp(@NonNull CGEnvVisitOp object) {
		
		Type csType = (Type) object.getAst();
		TypeDescriptor typeDescriptor = context.getUnboxedDescriptor(csType.getTypeId());
		
		js.append("@Override \n");
		js.append("public ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(nProvider.getSpecificEnvironmentItf());
		js.append(" " + object.getName() + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(typeDescriptor);
		js.append(" ");
		js.append("self");
		js.append(") {\n");
		js.pushIndentation(null);
		
		safeVisit(object.getBody());
		
		switch (object.getEnvLookupPropagation()) {
			case LOOKUP_IN_PARENT:
				js.append("return lookupInParent();\n"); break;
			case LOOKUP_IN_PARENT_IF_NOT_COMPLETE:
				js.append("return lookupInParentIfNotComplete();\n"); break;
			case LOOKUP_ONLY_LOCAL:
				js.append("return lookupOnlyLocal();\n"); break;
		}
		
		js.popIndentation();
		js.append("}\n");
		return true;
	}
	
	@Nullable
	public Boolean visitCGEnvVisitOpBody(@NonNull CGEnvVisitOpBody object) {
		
		js.appendClassReference(EReference.class);
		js.append(" containmentReference = context.getToChildReference();\n");
		
		List<CGEnvVisitIfPart> ifParts = object.getEnvConfigParts();
		if (ifParts.size() == 1) {
			safeVisit(ifParts.get(0));
		} else {
			
		}
		return true;
	}
	
	@Nullable
	public Boolean visitCGEnvVisitIfPart(@NonNull CGEnvVisitIfPart object) {		
		return safeVisit(object.getEnvExpression());
	}

	



	
}
