/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.cs2as;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LambdaLiteralExp;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;

import com.google.common.collect.UnmodifiableIterator;

/**
 * An Iterator over the (possibly implicit) source types or variables (most nested first).
 */
public abstract class AbstractSourceNamedElementIterator<T extends NamedElement> extends UnmodifiableIterator<T>
{
	protected static final boolean CONTINUE = false;
	protected static final boolean DONE = true;
	
	public static boolean canBeImplicitSource(@NonNull Variable asVariable) {
		EReference eContainmentFeature = asVariable.eContainmentFeature();
		return (eContainmentFeature == PivotPackage.Literals.EXPRESSION_IN_OCL__OWNED_CONTEXT)
			|| (eContainmentFeature == PivotPackage.Literals.LOOP_EXP__OWNED_ITERATORS);
	}

	private @Nullable ElementCS cursor;
	private @Nullable T next;
	private @NonNull List<T> nexts = new ArrayList<T>();
	private int nextNext = 0;
	
	protected AbstractSourceNamedElementIterator(@NonNull ElementCS csElement) {
		this.cursor = csElement;
		this.next = null;
		hasNext();
	}

	protected void addNext(@NonNull T asElement) {
		next = asElement;
		nexts.add(asElement);
	}

	/**
	 * Assess csParent invoked from csChild and invoke setNext() if csParent provides a source variable.
	 * Return true if the hierarchical assessment is complete, false to continue.
	 */
	protected boolean doNext(@NonNull ElementCS csParent, @NonNull ElementCS csChild) {
		if (csParent instanceof ContextCS) {
			ExpressionInOCL asContext = PivotUtil.getPivot(ExpressionInOCL.class, (ContextCS)csParent);
			if (asContext != null) {
				Variable asVariable = asContext.getOwnedContext();
				if (asVariable != null) {
					setNext(asVariable);
				}
			}
			return DONE; // no more parents
		}
		else if (csParent instanceof ConstraintCS) {
			Constraint asConstraint = PivotUtil.getPivot(Constraint.class, (ConstraintCS)csParent);
			if (asConstraint != null) {
				LanguageExpression asContext = asConstraint.getOwnedSpecification();
				if (asContext instanceof ExpressionInOCL) {
					Variable asVariable = ((ExpressionInOCL)asContext).getOwnedContext();
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
				Variable asVariable = ((ExpressionInOCL)element).getOwnedContext();
				if (asVariable != null) {
					setNext(asVariable);
				}
			}
		}
		else if (csParent instanceof LetVariableCS) {
			Element element = ((LetVariableCS)csParent).getPivot();
			if (element instanceof Variable) {
				Variable asVariable = (Variable)element;
				if (asVariable.getOwnedInit() instanceof LambdaLiteralExp) {
					setNext(asVariable);
				}
			}
		}
/*		else if (csParent instanceof LambdaLiteralExpCS) {
			Element element = ((LambdaLiteralExpCS)csParent).getPivot();
			if (element instanceof LetExp) {
				Variable asVariable = ((LetExp)element).getOwnedVariable();		// FIXME Multi-variables
				if ((asVariable != null) && (asVariable.getType() instanceof LambdaType)) {
					setNext(asVariable);
				}
			}
		} */
		else if ((csParent instanceof NameExpCS) && (((NameExpCS)csParent).getOwnedRoundBracketedClause() != null)){
			OCLExpression asCallExp = PivotUtil.getPivot(OCLExpression.class, (NameExpCS)csParent);
			if (asCallExp instanceof LoopExp) {
				List<Variable> asIterators = ((LoopExp)asCallExp).getOwnedIterators();
				if (asIterators.size() == 1) {
					Variable iterator = asIterators.get(0);
					if (iterator != null) {
						setNext(iterator);
					}
				}
			}
		}
		return CONTINUE;
	}

	@Override
	public boolean hasNext() {
		ElementCS csElement = cursor;
		while ((next == null) && (csElement != null)) {
			ElementCS csParent = csElement.getParent();
			if (csParent != null) {
				if (csParent instanceof LetVariableCS) {				// Step up to a LetVariable steps up to last LetVariable
					ElementCS csParentParent = csParent.getParent();
					if (csParentParent instanceof LetExpCS) {
						LetExpCS csLetExp = (LetExpCS) csParentParent;
						List<LetVariableCS> csVariables = csLetExp.getOwnedVariables();
						csParent = csVariables.get(csVariables.size()-1);
						assert csParent != null;
					}
				}
				else if (csElement instanceof LetVariableCS) {			// Step up from a LetVariable steps to previous LetVariable
					if (csParent instanceof LetExpCS) {
						LetExpCS csLetExp = (LetExpCS) csParent;
						List<LetVariableCS> csVariables = csLetExp.getOwnedVariables();
						int index = csVariables.indexOf(csElement);
						if (index > 0) {
							csParent = csVariables.get(index-1);
							assert csParent != null;
						}
					}
				}
				else if (csParent instanceof LetExpCS) {				// Step up to a LetExp steps up to last LetVariable
					LetExpCS csLetExp = (LetExpCS) csParent;
					List<LetVariableCS> csVariables = csLetExp.getOwnedVariables();
					csParent = csVariables.get(csVariables.size()-1);
					assert csParent != null;
				}
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

	@Override
	public @NonNull T next() {
		T next2 = next;
		if (next2 == null) {
			throw new NoSuchElementException();
		}
		else {
			T next3 = nexts.get(nextNext++);
			assert next2 == next3;
			next = null;
			return next2;
		}
	}

	/**
	 * Assign the iterable element when iterating at asVariable.
	 */
	protected abstract void setNext(@NonNull Variable asVariable);
}
