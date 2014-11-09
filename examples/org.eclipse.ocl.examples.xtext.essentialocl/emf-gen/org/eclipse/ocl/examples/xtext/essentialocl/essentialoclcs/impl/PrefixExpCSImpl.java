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
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2AS;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCSPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Expression CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrefixExpCSImpl
		extends OperatorExpCSImpl
		implements PrefixExpCS {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrefixExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.PREFIX_EXP_CS;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitPrefixExpCS(this);
	}

	@Override
	public @Nullable ExpCS getLocalLeft() {
		return EssentialOCLCS2AS.getDerivedLeftExpCS(this);
	}

	@Override
	public @NonNull ExpCS getLocalLeftmostDescendant() {
		return this;
	}

	@Override
	public @Nullable ExpCS getLocalRight() {
		ExpCS ownedSource = getOwnedSource();
		return ownedSource != null ? ownedSource.getLocalLeftmostDescendant() : null;
	}

	@Override
	public @NonNull ExpCS getLocalRightmostDescendant() {
		ExpCS ownedSource = getOwnedSource();
		return ownedSource != null ? ownedSource.getLocalRightmostDescendant() : this;
	}

	public ExpCS getDerivedSource() {
		if (EssentialOCLCSPostOrderVisitor.interleaveInProgress) {
			assert !isInterleaved;
			return source;
		}
		if (EssentialOCLCSPostOrderVisitor.doesInterleave && !derivedSourceIsSet) {
			assert !isInterleaved || (source == null);
			return null;
		}
		if (!EssentialOCLCSPostOrderVisitor.doesInterleave && !isInterleaved) {
			return null;
		}
		assert isInterleaved || !(eContainer() instanceof OperatorExpCS);
		if (derivedSource == null) {
			ExpCS csLowestRight = null;
			for (ExpCS csRight = this; (csRight = csRight.getLocalRight()) != null; ) {
				if ((csRight instanceof OperatorExpCS) && ((OperatorExpCS) csRight).isLocalRightAncestorOf(this)) {
					break;
				}
				if ((csLowestRight == null) || ((csRight instanceof OperatorExpCS) && ((OperatorExpCS) csRight).isLocalRightAncestorOf(csLowestRight))) {
					csLowestRight = csRight;
				}
			}
			derivedSource = csLowestRight;
		}
		return derivedSource;
	}
	
	public boolean isLocalRightAncestorOf(@NonNull ExpCS csExp) {	// csExp should be to the right of this for associativity resolution
		return false;
	}
	
	@Override
	public void setInterleaved() {
		super.setInterleaved();
		ExpCS ownedSource2 = getOwnedSource();
		if (ownedSource2 != null) {
			ownedSource2.setInterleaved();
		}
	}
} //UnaryExpressionCSImpl
