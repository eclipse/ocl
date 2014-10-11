/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.oclinecore.pivot2cs;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Model;
import org.eclipse.ocl.examples.xtext.base.basecs.DetailCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs.EssentialOCLDeclarationVisitor;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.SysMLCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.TopLevelCS;

public class OCLinEcoreDeclarationVisitor extends EssentialOCLDeclarationVisitor
{
	public OCLinEcoreDeclarationVisitor(@NonNull Pivot2CSConversion context) {
		super(context);
	}

	@Override
	public void postProcess(@NonNull BaseCSResource csResource, @NonNull Map<Namespace, List<String>> importedNamespaces) {
		EObject eObject = csResource.getContents().get(0);
		if (eObject instanceof TopLevelCS) {
			context.createImports((TopLevelCS) eObject, importedNamespaces);
		}
	}

	@Override
	public ElementCS visitAnnotation(@NonNull Annotation object) {
		if (PivotConstants.SYSML_ANNOTATION_SOURCE.equals(object.getName())) {
			SysMLCS csElement = context.refreshElement(SysMLCS.class, OCLinEcoreCSPackage.Literals.SYS_MLCS, object);
//			context.refreshList(csElement.getOwnedAnnotation(), context.visitDeclarations(AnnotationCS.class, object.getOwnedAnnotation(), null));
			context.refreshList(csElement.getOwnedDetails(), context.visitDeclarations(DetailCS.class, object.getOwnedDetail(), null));
			return csElement;
		}
		else {
			return super.visitAnnotation(object);
		}
	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		OCLinEcoreConstraintCS csElement = context.refreshNamedElement(OCLinEcoreConstraintCS.class, OCLinEcoreCSPackage.Literals.OC_LIN_ECORE_CONSTRAINT_CS, object);
		if (csElement != null) {
			csElement.setCallable(object.isCallable());
			refreshConstraint(csElement, object);
		}
		return csElement;
	}
	
	@Override
	public ElementCS visitModel(@NonNull Model object) {
		TopLevelCS csElement = context.refreshElement(TopLevelCS.class, OCLinEcoreCSPackage.Literals.TOP_LEVEL_CS, object);
		context.refreshList(csElement.getOwnedPackages(), context.visitDeclarations(PackageCS.class, object.getOwnedPackages(), null));
		context.visitDeclarations(ImportCS.class, object.getImports(), null);
		return csElement;
	}
}