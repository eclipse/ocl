/*******************************************************************************
 * Copyright (c) 2011,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388529
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.examples.pivot.manager.TemplateParameterSubstitutions;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public abstract class AbstractOperationMatcher
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @Nullable Type sourceType;
	protected final boolean sourceIsTypeof;
	private @Nullable List<EObject> ambiguities = null;

	protected AbstractOperationMatcher(@NonNull MetaModelManager metaModelManager, @Nullable Type sourceType, boolean sourceIsTypeof) {
		this.metaModelManager = metaModelManager;
		this.sourceType = sourceType != null ? PivotUtil.getType(sourceType) : null;		// FIXME redundant
		this.sourceIsTypeof = sourceIsTypeof;
	}

	protected int compareMatches(@NonNull Object match1, @NonNull TemplateParameterSubstitutions referenceBindings,
			@NonNull Object match2, @NonNull TemplateParameterSubstitutions candidateBindings) {
		@NonNull Operation reference = (Operation) match1;
		@NonNull Operation candidate = (Operation) match2;
		org.eclipse.ocl.examples.pivot.Class referenceClass = reference.getOwningClass();
		org.eclipse.ocl.examples.pivot.Class candidateClass = candidate.getOwningClass();
		Type referenceType = referenceClass != null ? PivotUtil.getType(referenceClass) : null;
		Type candidateType = candidateClass != null ? PivotUtil.getType(candidateClass) : null;
		Type specializedReferenceType = referenceType != null ? metaModelManager.getSpecializedType(referenceType, referenceBindings) : null;
		Type specializedCandidateType = candidateType != null ? metaModelManager.getSpecializedType(candidateType, candidateBindings) : null;
		if ((reference instanceof Iteration) && (candidate instanceof Iteration) && (specializedReferenceType != null) && (specializedCandidateType != null)) {
			int iteratorCountDelta = ((Iteration)candidate).getOwnedIterator().size() - ((Iteration)reference).getOwnedIterator().size();
			if (iteratorCountDelta != 0) {
				return iteratorCountDelta;
			}
			if (referenceType != candidateType) {
				if (metaModelManager.conformsTo(specializedReferenceType, TemplateParameterSubstitutions.EMPTY, specializedCandidateType, TemplateParameterSubstitutions.EMPTY)) {
					return 1;
				}
				else if (metaModelManager.conformsTo(specializedCandidateType, TemplateParameterSubstitutions.EMPTY, specializedReferenceType, TemplateParameterSubstitutions.EMPTY)) {
					return -1;
				}
			}
		}
		int referenceConversions = 0;
		int candidateConversions = 0;
		DomainType comparedSourceType = sourceType;
//		if (comparedSourceType instanceof DomainMetaclass) {
//			comparedSourceType = ((DomainMetaclass)comparedSourceType).getInstanceType();
//		}
		if (comparedSourceType != specializedReferenceType) {
			referenceConversions++;
		}
		if (comparedSourceType != specializedCandidateType) {
			candidateConversions++;
		}
		List<Parameter> candidateParameters = candidate.getOwnedParameter();
		List<Parameter> referenceParameters = reference.getOwnedParameter();
		for (int i = 0; i < candidateParameters.size(); i++) {
			OCLExpression pivotArgument = getArgument(i);
			if (pivotArgument == null) {
				return 0;
			}
			Type argumentType = pivotArgument.getType();
			Parameter referenceParameter = referenceParameters.get(i);
			Parameter candidateParameter = candidateParameters.get(i);
			if ((referenceParameter == null) || (candidateParameter == null)) {					// Doesn't happen (just a supurious NPE guard)
				referenceConversions = Integer.MIN_VALUE;
				candidateConversions = Integer.MIN_VALUE;
			}
			else {
				referenceType = PivotUtil.getType(DomainUtil.nonNullModel(referenceParameter.getType()));
				candidateType = PivotUtil.getType(DomainUtil.nonNullModel(candidateParameter.getType()));
				specializedReferenceType = metaModelManager.getSpecializedType(referenceType, referenceBindings);
				specializedCandidateType = metaModelManager.getSpecializedType(candidateType, candidateBindings);
				if (argumentType != specializedReferenceType) {
					referenceConversions++;
				}
				if (argumentType != specializedCandidateType) {
					candidateConversions++;
				}
			}
		}
		if (candidateConversions != referenceConversions) {
			return candidateConversions - referenceConversions;
		}
		int verdict = metaModelManager.compareOperationMatches(reference, referenceBindings, candidate, candidateBindings);
		if (verdict != 0) {
			return verdict;
		}
		if (isRedefinitionOf(reference, candidate)) {
			return 1;				// match2 inferior			
		}
		if (isRedefinitionOf(candidate, reference)) {
			return -1;				// match1 inferior			
		}
		org.eclipse.ocl.examples.pivot.Package p1 = PivotUtil.getContainingPackage(reference);
		org.eclipse.ocl.examples.pivot.Package p2 = PivotUtil.getContainingPackage(candidate);
		if (p1 == null) {
			return 0;
		}
		if (p2 == null) {
			return 0;
		}
		PackageManager packageManager = metaModelManager.getPackageManager();
		PackageServer s1 = packageManager.getPackageServer(p1);
		PackageServer s2 = packageManager.getPackageServer(p2);
		if (s1 != s2) {
			return 0;
		}
		int i1 = s1.getIndex(p1);
		int i2 = s2.getIndex(p2);
		int indexDiff = i2 - i1;
		if (indexDiff != 0) {
			return indexDiff;
		}
		if ((specializedReferenceType != null) && (specializedCandidateType != null)) {
			if (metaModelManager.conformsTo(specializedReferenceType, referenceBindings, specializedCandidateType, candidateBindings)) {
				return 1;
			}
			else if (metaModelManager.conformsTo(specializedCandidateType, candidateBindings, specializedReferenceType, referenceBindings)) {
				return -1;
			}
		}
		return 0;
	}

	public @Nullable List<EObject> getAmbiguities() {
		return ambiguities;
	}

	protected abstract OCLExpression getArgument(int i);

	protected abstract int getArgumentCount();

	public @Nullable Operation getBestOperation(@NonNull List<NamedElement> invocations) {
		ambiguities = null;
		Operation bestOperation = null;
		TemplateParameterSubstitutions bestBindings = TemplateParameterSubstitutions.EMPTY;
		List<EObject> ambiguities2 = ambiguities;
		for (NamedElement namedElement : invocations) {
			if (namedElement instanceof Operation) {
				Operation candidateOperation = (Operation)namedElement;
				TemplateParameterSubstitutions candidateBindings = matches(candidateOperation);
				if (candidateBindings != null) {
					if (bestOperation == null) {
						bestOperation = candidateOperation;
						bestBindings = candidateBindings;
					}
					else {
						int comparison = compareMatches(bestOperation, bestBindings, candidateOperation, candidateBindings);
						if (comparison < 0) {
							bestOperation = candidateOperation;
							bestBindings = candidateBindings;
							ambiguities = null;
						}
						else if (comparison == 0) {
							if (ambiguities2 == null) {
								ambiguities = ambiguities2 = new ArrayList<EObject>();
								ambiguities2.add(bestOperation);
							}
							ambiguities2.add(candidateOperation);
						}
					}
				}
			}
		}
		return bestOperation;
	}

	protected boolean isRedefinitionOf(@NonNull Operation operation1, @NonNull Operation operation2) {
		List<Operation> redefinedOperations = operation1.getRedefinedOperation();
		for (Operation redefinedOperation : redefinedOperations) {
			if (redefinedOperation != null) {
				if (redefinedOperation == operation2) {
					return true;
				}
				if (isRedefinitionOf(redefinedOperation, operation2)) {
					return true;
				}
			}
		}
		return false;
	}

	protected @Nullable TemplateParameterSubstitutions matches(@NonNull Operation candidateOperation) {
		List<Parameter> candidateParameters = candidateOperation.getOwnedParameter();
		int iSize = getArgumentCount();
		if (iSize != candidateParameters.size()) {
			return null;
		}
		TemplateParameterSubstitutions bindings = TemplateParameterSubstitutionVisitor.createBindings(metaModelManager, sourceType, sourceIsTypeof, candidateOperation);
		for (int i = 0; i < iSize; i++) {
			Parameter candidateParameter = candidateParameters.get(i);
			if (candidateParameter != null) {
				OCLExpression expression = getArgument(i);
				if (expression == null) {
					return null;
				}
				Type candidateType = PivotUtil.getType(candidateParameter);
				if (candidateType == null) {
					return null;
				}
				if (!candidateParameter.isTypeof()) {
					Type expressionType = metaModelManager.getUnencodedType(expression);
//					Type expressionType = expression.isTypeof() ? metaModelManager.getClassType() : PivotUtil.getType(expression);		// FIXME deep getType
					if (expressionType == null) {
						return null;
					}
					if (!metaModelManager.conformsTo(expressionType, TemplateParameterSubstitutions.EMPTY, candidateType, bindings)) {
						return null;
					}
				}
				else {
					if (!expression.isTypeof()) {
						return null;
					}
					Type expressionType = PivotUtil.getType(expression); //ApparentTypeVisitor.getApparentType(metaModelManager, expression);
					if (expressionType == null) {
						return null;
					}
					if (!metaModelManager.conformsTo(expressionType, TemplateParameterSubstitutions.EMPTY, candidateType, bindings)) {
						return null;
					}
				}
			}
		}
		return bindings;
	}
}