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
package org.eclipse.ocl.examples.autogen.namereso;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoCG2StringVisitor;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor;

public class AutoLookupCG2StringVisitor extends CG2StringVisitor implements NameResoCGModelVisitor<String>
{	

	private static final class MyFactory extends AbstractFactory
	{
		private MyFactory() {
			CG2StringVisitor.addFactory(this);
		}

		public @NonNull CG2StringVisitor createToStringVisitor() {
			return new AutoLookupCG2StringVisitor();
		}

		public @NonNull EPackage getEPackage() {
			NameResoCGModelPackage eInstance = NameResoCGModelPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static @NonNull AutoCG2StringVisitor.Factory FACTORY = new MyFactory();
	
	public AutoLookupCG2StringVisitor() {}

	@Nullable
	public String visitCGAddOp(@NonNull CGAddOp object) {
		return super.visitCGOperation(object);
	}
}
