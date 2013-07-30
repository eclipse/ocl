/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.analyzer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstant;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEqualsExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractNonNullExtendingCGModelVisitor;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;

/**
 * A FieldingAnalyzer identifies the necessary catches and throws.
 * <p>
 * <h2>Caught or Thrown Consumer Requirements</h2>
 * <p>
 * Most AST nodes just propagate invalid and so use of Java exception is convenient and efficient.
 * <p>
 * <h2>Caught Requirements</h2>
 * <p>
 * The only AST nodes that respond to invalid are validating operations, so it might seem appropriate
 * to just catch all validating operation inputs.
 * <p>
 * However VariableExps enable a value computed elsewhere to be re-used. Therefore if the re-use is
 * by a validating operation, the computation elsewhere must be caught in the sharing LetExp.
 * <p>
 * <h2>Algorithm</h2>
 * <p>
 * <h3>Pass 1</h3>
 * <p>
 * A tree descent/ascent maintains a set of external variable references from a node and its descendants. Wherever a validating operation is
 * encountered on the ascent, all external references from source and parameters are marked as caught variables.
 * <p>
 * <h3>Pass 2</h3>
 * <p>
 * A tree descent/ascent computes the isCaught state of all nodes. On the ascent children with incompatible isCaught state are corrected by
 * insertion of a CGCaughtExp to catch a not-isCaught or a CHThrowExp to throw an isCaught..
 */
public class FieldingAnalyzer
{
	/*
	 * Perform a tree descent/ascent returning the external variables referenced by the visiting node tree.
	 * The returned set may be null, is transient and may be reused by the caller.
	 */
	public static class AnalysisVisitor extends AbstractExtendingCGModelVisitor<Set<CGVariable>, FieldingAnalyzer>
	{
		public AnalysisVisitor(@NonNull FieldingAnalyzer context) {
			super(context);
		}
	
		public @Nullable Set<CGVariable> visiting(@NonNull CGElement visitable) {
			throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
		}
	
		/**
		 * By default all externals of all children are externals of this node.
		 */
		@Override
		public @Nullable Set<CGVariable> visitCGElement(@NonNull CGElement cgElement) {
			Set<CGVariable> childExternals = null;
			for (CGElement cgChild : cgElement.getChildren()) {
				if (cgChild != null) {
					Set<CGVariable> childExternal = cgChild.accept(this);
					if (childExternal != null) {
						if (childExternals == null) {
							childExternals = childExternal;
						}
						else {
							childExternals.addAll(childExternal);
						}
					}
				}
			}
			return childExternals;
		}

		/**
		 * All childExternals of a validating operation are marked as caught variables.
		 */
		@Override
		public @Nullable Set<CGVariable> visitCGIsInvalidExp(@NonNull CGIsInvalidExp cgElement) {
			Set<CGVariable> childExternals = super.visitCGIsInvalidExp(cgElement);
			context.setCaught(childExternals);
			return childExternals;
		}

		/**
		 * All childExternals of a validating operation are marked as caught variables.
		 */
		@Override
		public @Nullable Set<CGVariable> visitCGIsUndefinedExp(@NonNull CGIsUndefinedExp cgElement) {
			Set<CGVariable> childExternals = super.visitCGIsUndefinedExp(cgElement);
			context.setCaught(childExternals);
			return childExternals;
		}

		/**
		 * The externals of a LetExp are the externals of the children less the let variable.
		 */
		@Override
		public @Nullable Set<CGVariable> visitCGLetExp(@NonNull CGLetExp cgElement) {
			Set<CGVariable> childExternals = super.visitCGLetExp(cgElement);
			CGVariable cgInit = cgElement.getInit();
			if (childExternals != null) {
				childExternals.remove(cgInit);
			}
			return childExternals;
		}

		/**
		 * All childExternals of a validating operation are marked as caught variables.
		 */
		@Override
		public @Nullable Set<CGVariable> visitCGOperationCallExp(@NonNull CGOperationCallExp cgElement) {
			Set<CGVariable> childExternals = super.visitCGOperationCallExp(cgElement);
			if (cgElement.isValidating()) {
				context.setCaught(childExternals);
			}
			return childExternals;
		}

		/**
		 * The externals of a VariableExp are the externals of the referenced variable.
		 */
		@Override
		public @Nullable Set<CGVariable> visitCGVariableExp(@NonNull CGVariableExp cgElement) {
			Set<CGVariable> childExternal = null;
			CGVariable cgVariable = cgElement.getReferredVariable();
			if (cgVariable != null) {
				childExternal = new HashSet<CGVariable>();
				childExternal.add(cgVariable);
			}
			return childExternal;
		}
	}
	
	/*
	 * Perform a tree descent/ascent wrapping all child nodes in CGCatchExp or CGThrowExp to ensure that they satisfy
	 * the mustBeCaught/mustBeThrown requirement of their usage.
	 * The return from each child visit is true if isCaught, false if isThrown or isNonInvalid.
	 */
	public static class RewriteVisitor extends AbstractNonNullExtendingCGModelVisitor<Boolean, CodeGenAnalyzer>
	{
		protected final @NonNull Set<CGVariable> caughtVariables;
		
		public RewriteVisitor(@NonNull CodeGenAnalyzer context, @NonNull Set<CGVariable> caughtVariables) {
			super(context);
			this.caughtVariables = caughtVariables;
		}

		protected void insertCatch(@NonNull CGValuedElement cgChild) {
			assert !(cgChild instanceof CGCatchExp);
			if (!cgChild.isNonInvalid()) {
				CGCatchExp cgCatchExp = CGModelFactory.eINSTANCE.createCGCatchExp();
				CGUtils.wrap(cgCatchExp, cgChild);
			}
		}

		protected void insertThrow(@NonNull CGValuedElement cgChild) {
			assert !(cgChild instanceof CGThrowExp);
			if (!cgChild.isNonInvalid()) {
				CGThrowExp cgThrowExp = CGModelFactory.eINSTANCE.createCGThrowExp();
				CGUtils.wrap(cgThrowExp, cgChild);
			}
		}

		protected void rewriteAsCaught(@Nullable CGValuedElement cgChild) {
			if (cgChild != null) {
				Boolean isCaught = cgChild.accept(this);
				assert isCaught != null;
				if (isCaught == Boolean.FALSE) {
					insertCatch(cgChild);
				}
			}
		}

		protected void rewriteAsThrown(@Nullable CGValuedElement cgChild) {
			if (cgChild != null) {
				Boolean isCaught = cgChild.accept(this);
				assert isCaught != null;
				if (isCaught == Boolean.TRUE) {
					insertThrow(cgChild);
				}
			}
		}
		
		@Override
		public @NonNull Boolean safeVisit(@Nullable CGElement cgElement) {
			return (cgElement != null) && visit(cgElement);
		}

		@Override
		public @NonNull Boolean visiting(@NonNull CGElement visitable) {
			throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
		}

		@Override
		public @NonNull Boolean visitCGConstant(@NonNull CGConstant cgConstant) {
			return false;
		}

		@Override
		public @NonNull Boolean visitCGConstantExp(@NonNull CGConstantExp cgElement) {
			return safeVisit(cgElement.getReferredConstant());
		}

		@Override
		public @NonNull Boolean visitCGElement(@NonNull CGElement cgElement) {
			boolean isCaught = false;
			for (CGElement cgChild : cgElement.getChildren()) {
				if ((cgChild != null) && DomainUtil.nonNullState(cgChild.accept(this))) {
					isCaught = true;
				}
			}
			return isCaught;
		}

		@Override
		public @NonNull Boolean visitCGEqualsExp(@NonNull CGEqualsExp cgElement) {
			rewriteAsThrown(cgElement.getSource());
			rewriteAsThrown(cgElement.getArgument());
			cgElement.setCaught(false);
			return false;
		}

		@Override
		public @NonNull Boolean visitCGIfExp(@NonNull CGIfExp cgElement) {
			CGValuedElement cgCondition = cgElement.getCondition();
			CGValuedElement cgThen = cgElement.getThenExpression();
			CGValuedElement cgElse = cgElement.getElseExpression();
			boolean conditionIsCaught = (cgCondition != null) && DomainUtil.nonNullState(cgCondition.accept(this));
			boolean thenIsCaught = (cgThen != null) && DomainUtil.nonNullState(cgThen.accept(this));
			boolean elseIsCaught = (cgElse != null) && DomainUtil.nonNullState(cgElse.accept(this));
			// if works for caught or thrown condition
			if (!conditionIsCaught || (thenIsCaught != elseIsCaught)) {
				if ((cgThen != null) && thenIsCaught) {
					insertThrow(cgThen);
				}
				if ((cgElse != null) && elseIsCaught) {
					insertThrow(cgElse);
				}
			}
			boolean isCaught = conditionIsCaught && thenIsCaught && elseIsCaught;
			cgElement.setCaught(false);
			return isCaught;
		}

		@Override
		public @NonNull Boolean visitCGInvalid(@NonNull CGInvalid object) {
			return true;
		}

		@Override
		public @NonNull Boolean visitCGIsInvalidExp(@NonNull CGIsInvalidExp cgElement) {
			rewriteAsCaught(cgElement.getSource());
			cgElement.setCaught(false);
			return false;
		}

		@Override
		public @NonNull Boolean visitCGIsUndefinedExp(@NonNull CGIsUndefinedExp cgElement) {
			rewriteAsCaught(cgElement.getSource());
			cgElement.setCaught(false);
			return false;
		}

		@Override
		public @NonNull Boolean visitCGIterationCallExp(@NonNull CGIterationCallExp cgElement) {
			rewriteAsThrown(cgElement.getSource());
			for (CGIterator cgIterator : cgElement.getIterators()) {
				cgIterator.accept(this);
			}
			rewriteAsThrown(cgElement.getBody());
			cgElement.setCaught(false);
			return false;
		}

		@Override
		public @NonNull Boolean visitCGIterator(@NonNull CGIterator cgElement) {
			rewriteAsThrown(cgElement.getInit());
			cgElement.setCaught(false);
			return false;
		}

		@Override
		public @NonNull Boolean visitCGLetExp(@NonNull CGLetExp cgElement) {
			safeVisit(cgElement.getInit());
			boolean isCaught = safeVisit(cgElement.getIn());
			cgElement.setCaught(false);
			return isCaught;
		}

		@Override
		public @NonNull Boolean visitCGLibraryIterateCallExp(@NonNull CGLibraryIterateCallExp cgElement) {
			safeVisit(cgElement.getResult());
			boolean isCaught = super.visitCGLibraryIterateCallExp(cgElement) == Boolean.TRUE;
			return isCaught;
		}

		@Override
		public @NonNull Boolean visitCGOperationCallExp(@NonNull CGOperationCallExp cgElement) {
			List<CGValuedElement> cgArguments = cgElement.getArguments();
			int iSize = cgArguments.size();
			if (cgElement.isValidating()) {
				rewriteAsCaught(cgElement.getSource());
				for (int i = 0; i < iSize; i++) {				// Indexed to avoid CME
					rewriteAsCaught(cgArguments.get(i));
				}
			}
			else {
				rewriteAsThrown(cgElement.getSource());
				for (int i = 0; i < iSize; i++) {				// Indexed to avoid CME
					rewriteAsThrown(cgArguments.get(i));
				}
			}
			cgElement.setCaught(false);
			return false;
		}

		@Override
		public @NonNull Boolean visitCGPropertyCallExp(@NonNull CGPropertyCallExp cgElement) {
			rewriteAsThrown(cgElement.getSource());
			cgElement.setCaught(false);
			return false;
		}

		@Override
		public @NonNull Boolean visitCGValuedElement(@NonNull CGValuedElement cgElement) {
			boolean isCaught = super.visitCGValuedElement(cgElement) == Boolean.TRUE;
			cgElement.setCaught(isCaught);
			return isCaught;
		}

		@Override
		public @NonNull Boolean visitCGVariable(@NonNull CGVariable cgElement) {
			boolean isCaught = false;
			CGValuedElement cgInit = cgElement.getInit();
			if (cgInit != null) {
				if (DomainUtil.nonNullState(cgInit.accept(this))) {	// If explicitly caught
					isCaught = true;								// then just propagate caught
				}
				else if (caughtVariables.contains(cgElement)) {		// In not caught but needs to be
					insertCatch(cgInit);							//  catch it
					isCaught = true;
				}
			}
			cgElement.setCaught(isCaught);
			return isCaught;
		}

		@Override
		public @NonNull Boolean visitCGVariableExp(@NonNull CGVariableExp cgElement) {
			boolean isCaught = caughtVariables.contains(cgElement.getReferredVariable());
			return isCaught;
		}
	}
	
	protected final @NonNull CodeGenAnalyzer analyzer;

	/**
	 * The CGVariables that are accessed outside their defining tree.
	 */
	private final @NonNull Set<CGVariable> caughtVariables = new HashSet<CGVariable>();
	
	public FieldingAnalyzer(@NonNull CodeGenAnalyzer analyzer) {
		this.analyzer = analyzer;
	}

	public void analyze(@NonNull CGElement cgTree, boolean mustBeCaught) {	
		AnalysisVisitor analysisVisitor = createAnalysisVisitor();
		cgTree.accept(analysisVisitor);
		RewriteVisitor rewriteVisitor = createRewriteVisitor(caughtVariables);
		cgTree.accept(rewriteVisitor);
	}

	protected @NonNull AnalysisVisitor createAnalysisVisitor() {
		return new AnalysisVisitor(this);
	}

	protected @NonNull RewriteVisitor createRewriteVisitor(@NonNull Set<CGVariable> caughtVariables) {
		return new RewriteVisitor(analyzer, caughtVariables);
	}

	protected boolean isValidating(EObject eObject) {
		if (eObject instanceof OperationCallExp) {
			OperationCallExp operationCall = (OperationCallExp)eObject;
			Operation operation = operationCall.getReferredOperation();
			if (operation.isValidating()) {
				return true;
			}
		}
		return false;
	}

	public void setCaught(@Nullable Set<CGVariable> catchers) {
		if (catchers != null) {
			for (CGVariable catcher : catchers) {
				if (!catcher.isNonInvalid()) {
					caughtVariables.add(catcher);
				}
			}
		}
	}
}
