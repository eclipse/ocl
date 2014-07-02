/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.cs2as;

import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;

import com.google.common.collect.UnmodifiableIterator;

/**
 * An Iterator over the types of implicit source types or variables (most nested first).
 */
public abstract class AbstractImplicitSourceNamedElementIterator<T extends NamedElement> extends UnmodifiableIterator<T>
{
	protected static final boolean CONTINUE = false;
	protected static final boolean DONE = true;
	
	private @Nullable ElementCS cursor;
	protected @Nullable T next;
	
	protected AbstractImplicitSourceNamedElementIterator(@NonNull ElementCS csElement) {
		this.cursor = csElement;
		this.next = null;
		hasNext();
	}

	/**
	 * Assess csParent invoked from csChild and invoke setNext() if csParent provides a source variable.
	 * Return true if the hierarchical assessment is complete, false to continue.
	 */
	protected boolean doNext(@NonNull ElementCS csParent, @NonNull ElementCS csChild) {
		if (csParent instanceof ContextCS) {
			ExpressionInOCL asContext = PivotUtil.getPivot(ExpressionInOCL.class, (ContextCS)csParent);
			if (asContext != null) {
				Variable asVariable = asContext.getContextVariable();
				if (asVariable != null) {
					setNext(asVariable);
				}
			}
			return DONE; // no more parents
		}
		else if (csParent instanceof ConstraintCS) {
			Constraint asConstraint = PivotUtil.getPivot(Constraint.class, (ConstraintCS)csParent);
			if (asConstraint != null) {
				OpaqueExpression asContext = asConstraint.getSpecification();
				if (asContext instanceof ExpressionInOCL) {
					Variable asVariable = ((ExpressionInOCL)asContext).getContextVariable();
					if (asVariable != null) {
						setNext(asVariable);
					}
				}
			}
			return DONE; // no more parents
		}
		else if (csParent instanceof ExpSpecificationCS) {
			Element element = ((ExpSpecificationCS)csParent).getPivot();
			if (element instanceof ExpressionInOCL) {
				Variable asVariable = ((ExpressionInOCL)element).getContextVariable();
				if (asVariable != null) {
					setNext(asVariable);
				}
			}
		}
		else if ((csParent instanceof NameExpCS) && (((NameExpCS)csParent).getRoundBracketedClause() != null)){
			OCLExpression asCallExp = PivotUtil.getPivot(OCLExpression.class, (NameExpCS)csParent);
			if (asCallExp instanceof LoopExp) {
				List<Variable> asIterators = ((LoopExp)asCallExp).getIterator();
				if (asIterators.size() == 1) {
					Variable iterator = asIterators.get(0);
					if ((iterator != null) && iterator.isImplicit()) {
						setNext(iterator);
					}
				}
			}
		}
		return CONTINUE;
	}

	public boolean hasNext() {
		ElementCS csElement = cursor;
		while ((next == null) && (csElement != null)) {
			ElementCS csParent = csElement.getLogicalParent();
			if (csParent != null) {
				if (doNext(csParent, csElement) == DONE) {
					csElement = null;
					break;
				}
			}
			csElement = csParent;
		}
		cursor = csElement;
		return next != null;
	}

	public @NonNull T next() {
		T next2 = next;
		if (next2 == null) {
			throw new NoSuchElementException();
		}
		else {
			next = null;
			return next2;
		}
	}

	/**
	 * Assign the iterable element when iterating at asVariable.
	 */
	protected abstract void setNext(@NonNull Variable asVariable);
}