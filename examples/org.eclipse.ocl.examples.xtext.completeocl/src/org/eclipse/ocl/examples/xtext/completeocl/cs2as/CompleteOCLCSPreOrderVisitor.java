/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.completeocl.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.util.AbstractCompleteOCLCSPreOrderVisitor;

public class CompleteOCLCSPreOrderVisitor extends AbstractCompleteOCLCSPreOrderVisitor
{	
	public CompleteOCLCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(@NonNull ClassifierContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDefCS(@NonNull DefCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(@NonNull OperationContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPackageDeclarationCS(@NonNull PackageDeclarationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPropertyContextDeclCS(@NonNull PropertyContextDeclCS csElement) {
		return null;
	}
}