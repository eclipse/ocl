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
package org.eclipse.ocl.examples.codegen.cse;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CGUtils;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;

public class CommonAnalysis extends AbstractAnalysis
{
	private /*@LazyNonNull*/ SimpleAnalysis primaryAnalysis = null;
	protected final @NonNull List<SimpleAnalysis> simpleAnalyses = new ArrayList<SimpleAnalysis>();
	private int minDepth = Integer.MAX_VALUE;
	private int maxDepth = Integer.MIN_VALUE;

	public CommonAnalysis(@NonNull SimpleAnalysis firstAnalysis, @NonNull SimpleAnalysis secondAnalysis) {
		this.primaryAnalysis = firstAnalysis;
		firstAnalysis.setCommonAnalysis(this);
		secondAnalysis.setCommonAnalysis(this);
	}

	@Override
	public @NonNull CommonAnalysis addAnalysis(@NonNull AbstractAnalysis anAnalysis) {
		return anAnalysis.addCommonAnalysis(this);
	}

	@Override
	public @NonNull CommonAnalysis addCommonAnalysis(@NonNull CommonAnalysis commonAnalysis) {
		for (@SuppressWarnings("null")@NonNull SimpleAnalysis simpleAnalysis : commonAnalysis.simpleAnalyses) {
			addSimpleAnalysis(simpleAnalysis);
		}
		return this;
	}

	@Override
	public @NonNull CommonAnalysis addSimpleAnalysis(@NonNull SimpleAnalysis simpleAnalysis) {
		simpleAnalysis.setCommonAnalysis(this);
		return this;
	}

	public @NonNull CommonAnalysis addedSimpleAnalysis(@NonNull SimpleAnalysis simpleAnalysis) {
		assert isStructurallyEqualTo(simpleAnalysis);
		simpleAnalyses.add(simpleAnalysis);
		int depth = simpleAnalysis.getDepth();
		if (primaryAnalysis == null) {
			primaryAnalysis = simpleAnalysis;
			this.minDepth = depth;
			this.maxDepth = depth;
		}
		else if (depth < this.minDepth) {
			primaryAnalysis = simpleAnalysis;
			this.minDepth = depth;
		}
		else if (depth > this.maxDepth) {
			this.maxDepth = depth;
		}
//		assert primaryAnalysis.isStructurallyEqualTo(simpleAnalysis);
		return this;
	}

	/**
	 * Return the depth of the deepest shared analysis.
	 */
	public int getMaxDepth() {
		return maxDepth;
	}

	/**
	 * Return the depth of the shallowest shared analysis.
	 */
	public int getMinDepth() {
		return minDepth;
	}

	@Override
	public int getStructuralHashCode() {
		return primaryAnalysis.getStructuralHashCode();
	}
	
	@Override
	public boolean isStructurallyEqualTo(@NonNull AbstractAnalysis thatAnalysis) {
		return primaryAnalysis.isStructurallyEqualTo(thatAnalysis);
	}
	
	@Override
	public boolean isStructurallyEqualTo(@NonNull SimpleAnalysis thatAnalysis) {
		return primaryAnalysis.isStructurallyEqualTo(thatAnalysis);
	}

	public void removedSimpleAnalysis(SimpleAnalysis simpleAnalysis) {
		simpleAnalyses.remove(simpleAnalysis);
	}

	public void rewrite(@NonNull CodeGenAnalyzer analyzer, @NonNull CGValuedElement controlElement) {
		if (simpleAnalyses.size() > 1) {
			CGValuedElement cgCSE = primaryAnalysis.getCGElement();
			CGVariable cgVariable = CGModelFactory.eINSTANCE.createCGLocalVariable();
			cgVariable.setTypeId(cgCSE.getTypeId());
			cgVariable.setRequired(cgCSE.isNonNull());
			cgVariable.setPivot(cgCSE.getPivot());
			cgVariable.setName(analyzer.getNameManager().getGlobalSymbolName(cgVariable, "_cse"));
			for (SimpleAnalysis simpleAnalysis : simpleAnalyses) {
				CGValuedElement commonElement = simpleAnalysis.getCGElement();
				rewriteAsVariableExp(commonElement, cgVariable);				
			}
			rewriteAsLet(controlElement, cgVariable);
			cgVariable.setInit(cgCSE);						// After all rewrites complete
		}
	}

	/**
	 * Insert a CGLetExp above cgIn for cgCSE.
	 */
	protected @NonNull CGLetExp rewriteAsLet(@NonNull CGValuedElement cgIn, @NonNull CGVariable cgVariable) {
		CGLetExp cgLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
		cgLetExp.setTypeId(cgIn.getTypeId());
		cgLetExp.setPivot(cgIn.getPivot());
		CGUtils.replace(cgIn, cgLetExp);
		cgLetExp.setIn(cgIn);
		cgLetExp.setInit(cgVariable);
		return cgLetExp;
	}

	protected void rewriteAsVariableExp(@NonNull CGValuedElement cgElement, @NonNull CGVariable cgVariable) {
		CGVariableExp cgVarExp = CGModelFactory.eINSTANCE.createCGVariableExp();
		cgVarExp.setTypeId(cgVariable.getTypeId());
		cgVarExp.setPivot(cgVariable.getPivot());
		cgVarExp.setReferredVariable(cgVariable);
		CGUtils.replace(cgElement, cgVarExp);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(simpleAnalyses.size() + "," + minDepth + ".." + maxDepth + " ");
		s.append(primaryAnalysis);
		for (SimpleAnalysis simpleAnalysis : simpleAnalyses) {
			if (simpleAnalysis != primaryAnalysis) {
				s.append(" => " + simpleAnalysis);
			}
		}
		return s.toString();
	}
}