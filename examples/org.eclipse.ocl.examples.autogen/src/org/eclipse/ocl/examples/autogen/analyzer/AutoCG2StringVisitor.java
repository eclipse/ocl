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
package org.eclipse.ocl.examples.autogen.analyzer;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelPackage;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;
import org.eclipse.ocl.examples.autogen.autocgmodel.util.AutoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

public class AutoCG2StringVisitor extends CG2StringVisitor implements AutoCGModelVisitor<String>
{	
	private static final class MyFactory extends AbstractFactory
	{
		private MyFactory() {
			CG2StringVisitor.addFactory(this);
		}

		public @NonNull CG2StringVisitor createToStringVisitor() {
			return new AutoCG2StringVisitor();
		}

		public @NonNull EPackage getEPackage() {
			AutoCGModelPackage eInstance = AutoCGModelPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static @NonNull AutoCG2StringVisitor.Factory FACTORY = new MyFactory();

	public AutoCG2StringVisitor() {}

	public @Nullable String visitCGASTCallExp(@NonNull CGASTCallExp object) {
        CGValuedElement source = object.getSource();
		safeVisit(source);
		result.append(".$AST()");
		return null;
	}

	public @Nullable String visitCGContainmentBody(@NonNull CGContainmentBody object) {
		return visitCGValuedElement(object);
	}

	public @Nullable String visitCGContainmentPart(@NonNull CGContainmentPart object) {
		return visitCGValuedElement(object);
	}

	public @Nullable String visitCGContainmentVisit(@NonNull CGContainmentVisit object) {
		return visitCGOperation(object);
	}
}
