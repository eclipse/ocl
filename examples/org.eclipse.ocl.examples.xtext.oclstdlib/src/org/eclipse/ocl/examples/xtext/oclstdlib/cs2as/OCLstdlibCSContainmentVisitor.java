/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2as;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Model;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaclassNameCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.util.AbstractOCLstdlibCSContainmentVisitor;

public class OCLstdlibCSContainmentVisitor extends AbstractOCLstdlibCSContainmentVisitor
{
	public OCLstdlibCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	protected PackageId getPackageId(@NonNull PackageCS csElement) {
		if (csElement instanceof LibPackageCS) {
			return IdManager.METAMODEL;
		}
		return super.getPackageId(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitJavaClassCS(@NonNull JavaClassCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitLibClassCS(@NonNull LibClassCS csElement) {
		EClass eClass = null;
		MetaclassNameCS metaType = OCLstdlibCS2AS.lookUpMetaTypeName(csElement, OCLstdlibCSPackage.Literals.LIB_CLASS_CS__METACLASS_NAME);
		if ((metaType != null) && !metaType.eIsProxy()) {
			String metaTypeName = metaType.getName();
			eClass = (EClass) EcoreUtils.getNamedElement(PivotPackage.eINSTANCE.getEClassifiers(), metaTypeName);
		}
		if (eClass == null) {
			eClass = PivotPackage.Literals.CLASS;
		}
		@SuppressWarnings("unchecked")
		Class<org.eclipse.ocl.examples.pivot.Class> instanceClass = (Class<org.eclipse.ocl.examples.pivot.Class>)eClass.getInstanceClass();
		if (instanceClass != null) {
			org.eclipse.ocl.examples.pivot.Class pivotElement = refreshNamedElement(instanceClass, eClass, csElement);
			refreshClass(pivotElement, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitLibIterationCS(@NonNull LibIterationCS csElement) {
		@NonNull Iteration pivotElement = refreshNamedElement(Iteration.class, PivotPackage.Literals.ITERATION, csElement);
		pivotElement.setIsInvalidating(csElement.isIsInvalidating());
		pivotElement.setIsValidating(csElement.isIsValidating());
		context.refreshTemplateSignature(csElement, pivotElement);
		context.refreshPivotList(Parameter.class, pivotElement.getOwnedIterator(), csElement.getOwnedIterators());
		context.refreshPivotList(Parameter.class, pivotElement.getOwnedAccumulator(), csElement.getOwnedAccumulators());
		context.refreshPivotList(Parameter.class, pivotElement.getOwnedParameter(), csElement.getOwnedParameters());
		return null;
	}

	@Override
	public Continuation<?> visitLibOperationCS(@NonNull LibOperationCS csElement) {
		Continuation<?> cont = super.visitLibOperationCS(csElement);
		@NonNull Operation pivotElement = refreshNamedElement(Operation.class, PivotPackage.Literals.OPERATION, csElement);
		pivotElement.setIsInvalidating(csElement.isIsInvalidating());
		pivotElement.setIsValidating(csElement.isIsValidating());
		return cont;
	}

	@Override
	public Continuation<?> visitLibPackageCS(@NonNull LibPackageCS csElement) {
		Library pivotElement = refreshPackage(Library.class, PivotPackage.Literals.LIBRARY, csElement);		
		context.refreshPivotList(Precedence.class, pivotElement.getOwnedPrecedence(), csElement.getOwnedPrecedences());
		return null;
	}

	@Override
	public Continuation<?> visitLibRootPackageCS(@NonNull LibRootPackageCS csElement) {
		Resource eResource = csElement.eResource();
		if (eResource instanceof BaseCSResource) {
			@NonNull Model pivotElement = refreshRootPackage(Model.class, PivotPackage.Literals.MODEL, csElement);		
			context.installRootElement((BaseCSResource) eResource, pivotElement);		// Ensure containment viable for imported library type references
			importPackages(csElement);			// FIXME This has to be after refreshPackage which is irregular and prevents local realization of ImportCS etc
		}
		return null;
	}

	@Override
	public Continuation<?> visitPrecedenceCS(@NonNull PrecedenceCS csElement) {
		@NonNull Precedence pivotElement = refreshNamedElement(Precedence.class, PivotPackage.Literals.PRECEDENCE, csElement);
		pivotElement.setAssociativity(csElement.isIsRightAssociative() ? AssociativityKind.RIGHT : AssociativityKind.LEFT);
		return null;
	}
}
