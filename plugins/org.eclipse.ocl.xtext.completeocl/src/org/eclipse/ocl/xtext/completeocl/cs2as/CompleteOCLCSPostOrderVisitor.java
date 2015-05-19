/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.DefOperationCS;
import org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS;
import org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.util.AbstractCompleteOCLCSPostOrderVisitor;

public class CompleteOCLCSPostOrderVisitor extends AbstractCompleteOCLCSPostOrderVisitor
{
	public CompleteOCLCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(@NonNull ClassifierContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitCompleteOCLDocumentCS(@NonNull CompleteOCLDocumentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitContextDeclCS(@NonNull ContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDefOperationCS(@NonNull DefOperationCS csElement) {
		Operation contextOperation = PivotUtil.getPivot(Operation.class, csElement);
		if (contextOperation != null) {
			context.refreshRequiredType(contextOperation, csElement);		// FIXME type consistency check
		}
		return null;
	}

	@Override
	public Continuation<?> visitDefPropertyCS(@NonNull DefPropertyCS csElement) {
		Property contextProperty = PivotUtil.getPivot(Property.class, csElement);
		if (contextProperty != null) {
			context.refreshRequiredType(contextProperty, csElement);		// FIXME type consistency check
		}
		return null;
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(@NonNull OperationContextDeclCS csElement) {
		Operation modelOperation = csElement.getReferredOperation();
		if ((modelOperation != null) && !modelOperation.eIsProxy()) {
			Operation contextOperation = PivotUtil.getPivot(Operation.class, csElement);
			if (contextOperation != null) {
				context.refreshName(contextOperation, ClassUtil.nonNullModel(modelOperation.getName()));
				context.setType(contextOperation, modelOperation.getType(), modelOperation.isIsRequired());		// FIXME type consistency check
			}
		}
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