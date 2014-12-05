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
package	org.eclipse.ocl.pivot.model;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.PackageId;
import org.eclipse.ocl.domain.library.LibraryFeature;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.domain.values.Unlimited;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.impl.LibraryImpl;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

public class AbstractContents extends PivotUtil
{
	protected @NonNull BagType createBagType(@NonNull String name, @Nullable String lower, @Nullable String upper, @NonNull TemplateParameter templateParameter) {
		return createCollectionType(PivotFactory.eINSTANCE.createBagType(), name, lower, upper, templateParameter);
	}

	protected @NonNull <T extends CollectionType> T createCollectionType(/*@NonNull*/ T pivotType, @NonNull String name, @Nullable  String lower, @Nullable String upper, @NonNull TemplateParameter templateParameter) {
		pivotType.setName(name);
		pivotType.setLower(lower != null ? DomainUtil.createNumberFromString(lower) : Integer.valueOf(0));
		pivotType.setUpper(upper != null ? DomainUtil.createNumberFromString(upper) : Unlimited.INSTANCE);
		initTemplateParameter(pivotType, templateParameter);
		pivotType.setElementType(templateParameter);
		return pivotType;
	}

	protected @NonNull CollectionType createCollectionType(@NonNull String name, @Nullable String lower, @Nullable String upper, @NonNull TemplateParameter templateParameter) {
		return createCollectionType(PivotFactory.eINSTANCE.createCollectionType(), name, lower, upper, templateParameter);
	}
	
	protected @NonNull ExpressionInOCL createExpressionInOCL(@NonNull Type type, @NonNull String exprString) {
		ExpressionInOCL pivotExpression = PivotFactory.eINSTANCE.createExpressionInOCL();
		pivotExpression.setType(type);
		pivotExpression.setBody(exprString);
		return pivotExpression;
	}
	
	protected @NonNull Iteration createIteration(@NonNull String name, @NonNull Type type, @Nullable String implementationClass, @NonNull LibraryFeature implementation, TemplateParameter... templateParameters) {
		Iteration pivotIteration = createIteration(name, type, implementationClass, implementation);
		initTemplateParameters(pivotIteration, templateParameters);
		return pivotIteration;
	}

	protected @NonNull Library createLibrary(@NonNull String name, @NonNull String nsPrefix, @NonNull String nsURI, @Nullable PackageId packageId) {
		Library pivotLibrary = PivotFactory.eINSTANCE.createLibrary();
		pivotLibrary.setName(name);
		pivotLibrary.setNsPrefix(nsPrefix);
		if (packageId != null) {
			((LibraryImpl)pivotLibrary).setPackageId(packageId);  // FIXME Add to API
		}
		pivotLibrary.setURI(nsURI);
		return pivotLibrary;
	}
	
	protected @NonNull Operation createOperation(@NonNull String name, @NonNull Type type, @Nullable String implementationClass, @Nullable LibraryFeature implementation, TemplateParameter... templateParameters) {
		Operation pivotOperation = createOperation(name, type, implementationClass, implementation);
		initTemplateParameters(pivotOperation, templateParameters);
		return pivotOperation;
	}

	protected @NonNull OrderedSetType createOrderedSetType(@NonNull String name, @Nullable String lower, @Nullable String upper, @NonNull TemplateParameter templateParameter) {
		return createCollectionType(PivotFactory.eINSTANCE.createOrderedSetType(), name, lower, upper, templateParameter);
	}

	protected @NonNull SequenceType createSequenceType(@NonNull String name, @Nullable String lower, @Nullable String upper, @NonNull TemplateParameter templateParameter) {
		return createCollectionType(PivotFactory.eINSTANCE.createSequenceType(), name, lower, upper, templateParameter);
	}

	protected @NonNull SetType createSetType(@NonNull String name, @Nullable String lower, @Nullable String upper, @NonNull TemplateParameter templateParameter) {
		return createCollectionType(PivotFactory.eINSTANCE.createSetType(), name, lower, upper, templateParameter);
	}

	protected <T extends CollectionType> void initTemplateParameter(@NonNull TemplateableElement pivotType, @NonNull TemplateParameter templateParameter) {
		TemplateSignature templateSignature = PivotFactory.eINSTANCE.createTemplateSignature();
		templateSignature.getOwnedTemplateParameters().add(templateParameter);
		pivotType.setOwnedTemplateSignature(templateSignature);
	}

	protected <T extends CollectionType> void initTemplateParameters(@NonNull TemplateableElement pivotType, TemplateParameter... templateParameters) {
		if ((templateParameters != null) && (templateParameters.length > 0)) {
			TemplateSignature templateSignature = PivotFactory.eINSTANCE.createTemplateSignature();
			for (TemplateParameter templateParameter : templateParameters) {
				templateSignature.getOwnedTemplateParameters().add(templateParameter);
			}
			pivotType.setOwnedTemplateSignature(templateSignature);
		}
	}

	protected void installComment(Element element, @NonNull String body) {
		Comment pivotComment = PivotFactory.eINSTANCE.createComment();
		pivotComment.setBody(body);
		element.getOwnedComment().add(pivotComment);
	}
}
