/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package	org.eclipse.ocl.examples.pivot.model;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.impl.LibraryImpl;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class AbstractContents extends PivotUtil
{
	@Deprecated
	protected @NonNull Library createLibrary(@NonNull String name, @NonNull String nsPrefix, @NonNull String nsURI) {
		return createLibrary(name, nsPrefix, nsURI, null);
	}

	/**
	 * @since 3.5
	 */
	protected @NonNull Library createLibrary(@NonNull String name, @NonNull String nsPrefix, @NonNull String nsURI, @Nullable PackageId packageId) {
		Library pivotLibrary = PivotFactory.eINSTANCE.createLibrary();
		pivotLibrary.setName(name);
		pivotLibrary.setNsPrefix(nsPrefix);
		if (packageId != null) {
			((LibraryImpl)pivotLibrary).setPackageId(packageId);  // FIXME Add to API
		}
		pivotLibrary.setNsURI(nsURI);
		return pivotLibrary;
	}
	
	protected @NonNull OpaqueExpression createOpaqueExpression(@NonNull Type type, @NonNull String exprString) {
		OpaqueExpression pivotExpression = PivotFactory.eINSTANCE.createOpaqueExpression();
		pivotExpression.setType(type);
		pivotExpression.getBody().add(exprString);
		pivotExpression.getLanguage().add(PivotConstants.OCL_LANGUAGE);
		return pivotExpression;
	}

	@Deprecated
	protected @NonNull Package createPackage(@NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
		return createPackage(name, nsPrefix, nsURI, null);
	}

	@Deprecated // since Luna M3
	protected @NonNull Root createRoot(@NonNull String name, @NonNull String externalURI) {
		return createRoot(externalURI);
	}

	protected void installComment(Element element, @NonNull String body) {
		Comment pivotComment = PivotFactory.eINSTANCE.createComment();
		pivotComment.setBody(body);
		element.getOwnedComment().add(pivotComment);
	}
}
