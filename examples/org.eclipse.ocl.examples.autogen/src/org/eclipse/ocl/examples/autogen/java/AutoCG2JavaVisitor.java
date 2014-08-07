/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.java;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;
import org.eclipse.ocl.examples.autogen.autocgmodel.util.AutoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;

/**
 * AutoCG2JavaVisitor refines the regular generation of Java code from an optimized Auto CG transformation tree
 * to add contributions that are inadequately represented by the CG model.
 */
public abstract class AutoCG2JavaVisitor<CG extends AutoCodeGenerator> extends CG2JavaVisitor<CG> implements AutoCGModelVisitor<Boolean>
{
	protected final @NonNull AutoAnalyzer analyzer;
	protected final @NonNull CGPackage cgPackage;
	protected final @Nullable List<CGValuedElement> sortedGlobals;
	
	public AutoCG2JavaVisitor(@NonNull CG codeGenerator, @NonNull CGPackage cgPackage,
			@Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator);
		this.analyzer = codeGenerator.getAnalyzer();
		this.cgPackage = cgPackage;
		this.sortedGlobals = sortedGlobals;
	}

	@Override
	protected void doClassMethods(@NonNull CGClass cgClass) {
		doConstructor(cgClass);
		if (! isDerivedVisitor(cgClass)) {
			doVisiting(cgClass);
		}
		super.doClassMethods(cgClass);
	}

	@Override
	protected void doClassStatics(@NonNull CGClass cgClass) {
		if (sortedGlobals != null) {
			for (CGValuedElement cgElement : sortedGlobals) {
				assert cgElement.isGlobal();
				cgElement.accept(this);
			}
			js.append("\n");
		}
	}

	protected boolean isDerivedVisitor(CGClass cgClass) {
		return cgClass.getSuperTypes().size() > 1;
	}
	
	protected abstract void doConstructor(@NonNull CGClass cgClass);

	protected void doVisiting(@NonNull CGClass cgClass) {
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
		js.append("throw new UnsupportedOperationException(\"");
		js.append(cgClass.getName());
		js.append(" is not supported by \\\"\" + getClass().getName() + \"\\\"\"");
		js.append(");\n");
		js.popIndentation();
		js.append("}\n");
	}
	
	@Override
	protected void appendAtOverride(@NonNull CGOperation cgOperation) {
		// FIXME CGOperation is not properly modelled to wisely discern if the operation needs an Override or not
		// Custom logic based on specific visitors design
		if (!isDerivedVisitor(cgOperation.getContainingClass())) {
			js.append("@Override\n");
		}
	}

	@Override
	public @NonNull Boolean visitCGASTCallExp(@NonNull CGASTCallExp object) {
		return visiting(object);
	}

	@Override
	public @NonNull Boolean visitCGContainmentBody(@NonNull CGContainmentBody object) {
		return visiting(object);
	}

	@Override
	public @NonNull Boolean visitCGContainmentPart(@NonNull CGContainmentPart object) {
		return visiting(object);
	}

	@Override
	public @NonNull Boolean visitCGContainmentVisit(@NonNull CGContainmentVisit object) {
		return visiting(object);
	}

	@Override
	public @NonNull Boolean visitCGEcoreOperation(@NonNull CGEcoreOperation object) {
		return visiting(object);
	}
}
