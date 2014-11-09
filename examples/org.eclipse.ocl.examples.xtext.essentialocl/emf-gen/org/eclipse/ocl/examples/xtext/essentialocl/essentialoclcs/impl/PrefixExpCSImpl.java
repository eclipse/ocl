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
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
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

/*	@Override
	protected @NonNull Precedence computeLeftPrecedence() {
		ExpCS csSource = getOwnedSource();
		if (csSource instanceof OperatorExpCS) {
			Precedence sourcePrecedence = ((OperatorExpCS)csSource).getDerivedPrecedence();
			Precedence leftPrecedence = ((OperatorExpCS)csSource).getDerivedLeftPrecedence();
			return PivotUtil.highestPrecedence(sourcePrecedence, leftPrecedence);
		}
		else {
			return PrecedenceManager.NULL_PRECEDENCE;
		}
	} */

/*	@Override
	protected @NonNull Precedence computeRightPrecedence() {
//		ExpCS csArgument = getOwnedArgument();
//		if (csArgument instanceof OperatorExpCS) {
//			Precedence argumentPrecedence = ((OperatorExpCS)csArgument).getDerivedPrecedence();
//			Precedence rightPrecedence = ((OperatorExpCS)csArgument).getDerivedRightPrecedence();
//			return PivotUtil.highestPrecedence(argumentPrecedence, rightPrecedence);
//		}
//		else {
			return PrecedenceManager.NULL_PRECEDENCE;
//		}
	} */
	
/*	@Override
	public @NonNull Precedence getDerivedHighestPrecedence() {
		Precedence leftPrecedence = getOwnedSource().getDerivedHighestPrecedence();
		return PivotUtil.highestPrecedence(getDerivedPrecedence(), leftPrecedence);
	} */

	@Override
	public @Nullable ExpCS getDerivedLeftExpCS() {
		return EssentialOCLCS2AS.getDerivedLeftExpCS(this);
	}

	@Override
	public @NonNull ExpCS getDerivedLeftmostExpCS() {
		return this;
	}

	@Override
	public @Nullable ExpCS getDerivedRightExpCS() {
		ExpCS ownedSource = getOwnedSource();
		return ownedSource != null ? ownedSource.getDerivedLeftmostExpCS() : null;
	}

	@Override
	public @NonNull ExpCS getDerivedRightmostExpCS() {
		ExpCS ownedSource = getOwnedSource();
		return ownedSource != null ? ownedSource.getDerivedRightmostExpCS() : this;
	}

	public ExpCS getDerivedSource() {
		if (derivedSource == null) {
			ExpCS csBestRight = null;
			for (ExpCS csRight = this; (csRight = csRight.getDerivedRightExpCS()) != null; ) {
				ExpCS csThisWrtRight = EssentialOCLCS2AS.lowestPrecedence(this, csRight);
				if (csThisWrtRight != this) {
					break;
				}
				if (csBestRight == null) {
					csBestRight = csRight;
				}
				else {
					ExpCS csBestWrtRight = EssentialOCLCS2AS.lowestPrecedence(csBestRight, csRight);
					if (csBestWrtRight != csBestRight) {
						csBestRight = csRight;
					}
				}
			}
			derivedSource = csBestRight;
		}
		return derivedSource;
	}
} //UnaryExpressionCSImpl
