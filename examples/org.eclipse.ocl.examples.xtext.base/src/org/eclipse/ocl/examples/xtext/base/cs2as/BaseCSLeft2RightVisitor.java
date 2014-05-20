/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DetailCS;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS;

public class BaseCSLeft2RightVisitor extends AbstractExtendingBaseCSVisitor<Element, CS2PivotConversion>
{
	public BaseCSLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Element visitAnnotationCS(@NonNull AnnotationCS object) {
		return null;
	}

	@Override
	public Element visitClassifierCS(@NonNull ClassifierCS object) {
		return null;
	}

	@Override
	public Element visitConstraintCS(@NonNull ConstraintCS object) {
		return null;
	}

	@Override
	public Element visitDetailCS(@NonNull DetailCS object) {
		return null;
	}

	@Override
	public Element visitOperationCS(@NonNull OperationCS object) {
		return null;
	}

	@Override
	public Element visitParameterCS(@NonNull ParameterCS object) {
		return null;
	}

	@Override
	public Element visitSpecificationCS(@NonNull SpecificationCS object) {
		return null;
	}

	@Override
	public Element visitStructuralFeatureCS(@NonNull StructuralFeatureCS object) {
		return null;
	}

	@Override
	public Element visitTemplateBindingCS(@NonNull TemplateBindingCS object) {
		return null;
	}

	@Override
	public Element visitTemplateParameterCS(@NonNull TemplateParameterCS object) {
		return null;
	}

	@Override
	public Element visitTemplateParameterSubstitutionCS(@NonNull TemplateParameterSubstitutionCS object) {
		return null;
	}

	@Override
	public Element visitTemplateSignatureCS(@NonNull TemplateSignatureCS object) {
		return null;
	}

	@Override
	public Element visitTuplePartCS(@NonNull TuplePartCS object) {
		return null;
	}

	@Override
	public Element visitTupleTypeCS(@NonNull TupleTypeCS object) {
		return null;
	}

	@Override
	public Element visitTypeRefCS(@NonNull TypeRefCS object) {
		return null;
	}

	public Element visiting(@NonNull VisitableCS visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for CS2Pivot Left2Right pass");
	}
}