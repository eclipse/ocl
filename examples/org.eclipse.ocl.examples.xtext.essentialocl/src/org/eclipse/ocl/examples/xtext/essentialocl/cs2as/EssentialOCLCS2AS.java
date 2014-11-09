/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - Bug 397429
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.cs2as;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.BaseCS2AS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

public class EssentialOCLCS2AS extends BaseCS2AS
{		
	public static @Nullable ExpCS getDerivedLeftExpCS(@NonNull ExpCS csExp) {
		ExpCS csChild = csExp;
		for (EObject eContainer; (eContainer = csChild.eContainer()) instanceof OperatorExpCS; ) {
			OperatorExpCS csParent = (OperatorExpCS)eContainer;
			if (csParent.getOwnedRight() == csChild) {
				return csParent;
			}
			csChild = csParent;
		}
		return null;
	}

	public static @Nullable ExpCS getDerivedRightExpCS(@NonNull ExpCS csExp) {
		ExpCS csChild = csExp;
		for (EObject eContainer; (eContainer = csChild.eContainer()) instanceof OperatorExpCS; ) {
			if (eContainer instanceof PrefixExpCS) {
				PrefixExpCS csParent = (PrefixExpCS)eContainer;
				csChild = csParent;
			}
			else/*if (eContainer instanceof InfixExpCS)*/ {
				InfixExpCS csParent = (InfixExpCS)eContainer;
				if (csParent.getOwnedLeft() == csChild) {
					return csParent;
				}
				csChild = csParent;
			}
		}
		return null;
	}

	public static boolean isLocalProperAncestorOf(@NonNull ExpCS csLeft, @NonNull ExpCS csRight) {
		Precedence leftPrecedence = csLeft.getPrecedence();
		Precedence rightPrecedence = csRight.getPrecedence();
		int leftOrder = leftPrecedence.getOrder().intValue();
		int rightOrder = rightPrecedence.getOrder().intValue();
		if (leftOrder > rightOrder) {
			return true;
		}
		else if (leftOrder > rightOrder) {
			return false;
		}
		else if (leftPrecedence.getAssociativity() == AssociativityKind.RIGHT) {
			return true;
		}
		else {
			return false;
		}
	}

	public EssentialOCLCS2AS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}
	
	public EssentialOCLCS2AS(@NonNull EssentialOCLCS2AS cs2as) {
		super(cs2as);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Continuation<?>> createContainmentVisitor(@NonNull CS2ASConversion converter) {
		return new EssentialOCLCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Element> createLeft2RightVisitor(@NonNull CS2ASConversion converter) {
		return new EssentialOCLCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Continuation<?>> createPostOrderVisitor(@NonNull CS2ASConversion converter) {
		return new EssentialOCLCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull EssentialOCLCSVisitor<Continuation<?>> createPreOrderVisitor(@NonNull CS2ASConversion converter) {
		return new EssentialOCLCSPreOrderVisitor(converter);
	}
}
