/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.pivot2cs;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.WildcardType;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSFactory;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS;

public class BaseReferenceVisitor extends AbstractExtendingVisitor<ElementCS, Pivot2CSConversion>
{
	public static final Logger logger = Logger.getLogger(BaseReferenceVisitor.class);

	public BaseReferenceVisitor(@NonNull Pivot2CSConversion context) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
	}

	@Override
	public ElementCS visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		org.eclipse.ocl.examples.pivot.Class scopeClass = context.getScope();
		org.eclipse.ocl.examples.pivot.Package scopePackage = scopeClass != null ? PivotUtil.getPackage(scopeClass) : null;
		TypedTypeRefCS csRef = BaseCSFactory.eINSTANCE.createTypedTypeRefCS();
		Type type = PivotUtil.getUnspecializedTemplateableElement(object);
		PathNameCS csPathName = csRef.getOwnedPathName();
		if (csPathName == null) {
			@SuppressWarnings("null") @NonNull PathNameCS csPathName2 = BaseCSFactory.eINSTANCE.createPathNameCS();
			csPathName = csPathName2;
			csRef.setOwnedPathName(csPathName);
		}
		context.refreshPathName(csPathName, type, context.getScope());
		csRef.setPivot(type);		// FIXME object ??
		if (!(type instanceof PrimitiveType)) {
			org.eclipse.ocl.examples.pivot.Package objectPackage = PivotUtil.getPackage(type);
			if ((objectPackage != null) && (scopePackage != null) && objectPackage.eResource() != scopePackage.eResource()) {
				context.importNamespace(objectPackage, null);
			}
		}
		List<TemplateBinding> templateBindings = object.getOwnedTemplateBindings();
		if (templateBindings.isEmpty()) {
		}
		else {
			TemplateBindingCS csTemplateBinding = csRef.getOwnedTemplateBinding();
			if (csTemplateBinding == null) {
				csTemplateBinding = BaseCSFactory.eINSTANCE.createTemplateBindingCS();
				csRef.setOwnedTemplateBinding(csTemplateBinding);
			}
			List<TemplateParameterSubstitutionCS> csParameterSubstitutions = new ArrayList<TemplateParameterSubstitutionCS>();
			for (TemplateBinding templateBinding : templateBindings) {
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedTemplateParameterSubstitutions()) {
					Type actual = templateParameterSubstitution.getActual();
					if (actual != null) {
						TemplateParameterSubstitutionCS csTemplateParameterSubstitution = BaseCSFactory.eINSTANCE.createTemplateParameterSubstitutionCS();
						TypeRefCS csParameterable = context.visitReference(TypeRefCS.class, actual, null);
						csTemplateParameterSubstitution.setOwnedActualParameter(csParameterable);
						csParameterSubstitutions.add(csTemplateParameterSubstitution);
						csTemplateParameterSubstitution.setPivot(templateParameterSubstitution);
					}
				}
			}
			context.refreshList(csTemplateBinding.getOwnedSubstitutions(), csParameterSubstitutions);
		}
//		if (scopePackage == objectPackage) {
			return csRef;
//		}
		// FIXME cascade paths wrt import aliases
/*		QualifiedTypeRefCS qRef = BaseCSFactory.eINSTANCE.createQualifiedTypeRefCS();
		qRef.setNamespace(objectPackage);
		qRef.setElement(csRef);
		qRef.setPivot(object);
		return qRef;
*/	}

	@Override
	public ElementCS visitPrimitiveType(@NonNull PrimitiveType object) {
		PrimitiveTypeRefCS csRef = BaseCSFactory.eINSTANCE.createPrimitiveTypeRefCS();
//		Type type = PivotUtil.getUnspecializedTemplateableElement(object);
//		csRef.setType(type);
		csRef.setPivot(object);		// FIXME object ??
		csRef.setName(object.getName());		// FIXME object ??
		return csRef;
	}

	@Override
	public @Nullable ElementCS visitWildcardType(@NonNull WildcardType object) {
		WildcardTypeRefCS csRef = BaseCSFactory.eINSTANCE.createWildcardTypeRefCS();
		csRef.setPivot(object);
		// setSuper/setExtends
		return csRef;
	}

	public ElementCS visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for Pivot2CS Reference pass");
	}
}