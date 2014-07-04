/*******************************************************************************
 * Copyright (c) 2013, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Framework Refactoring 
 */
package org.eclipse.ocl.examples.autogen.java;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;

/**
 * A AutoCG2JavaVisitor supports generation of Java code from an optimized Auto CG transformation tree.
 */
public abstract class AutoCG2JavaVisitor extends CG2JavaVisitor
{
	protected final @NonNull AutoAnalyzer analyzer;
	protected final @Nullable List<CGValuedElement> sortedGlobals;
	
	public AutoCG2JavaVisitor(@NonNull AutoCodeGenerator codeGenerator,
			@Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator);
		this.analyzer = codeGenerator.getAnalyzer();
		this.sortedGlobals = sortedGlobals;
	}
	
	
	@Override
	public @NonNull Boolean visitCGClass(@NonNull CGClass cgClass) {		
		String className = cgClass.getName();
		js.append("public class " + className);
		
		List<CGClass> cgSuperTypes = cgClass.getSuperTypes();
		printClassExtendsImplements(cgSuperTypes);

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
		doClassFields(cgClass);
		
		js.append("\n");
		doConstructor(cgClass);
		if (cgSuperTypes.size() <= 1) {
			js.append("\n");
			doVisiting(cgClass);
		}
		
		js.append("\n");
		doAdditionalClassMethods(cgClass);
		
		for (CGOperation cgOperation : cgClass.getOperations()) {
			js.append("\n");
			cgOperation.accept(this);
		}
		js.popIndentation();
		js.append("}\n");
		return true;
	}
	
	private void printClassExtendsImplements(List<CGClass> cgSuperTypes) {
		
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
	}
	
	abstract protected void doClassFields(@NonNull CGClass cgClass);
	
	abstract protected void doConstructor(@NonNull CGClass cgClass);
	
	abstract protected void doVisiting(@NonNull CGClass cgClass);
	
	abstract protected void doAdditionalClassMethods(@NonNull CGClass cgClass);
}
