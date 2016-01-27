/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;

public class FinalAnalysis
{
	protected final @NonNull CompleteModelInternal completeModel;
	protected final @NonNull PivotMetamodelManager metamodelManager;
	private final @NonNull Map<CompleteClass, @NonNull Set<CompleteClass>> superCompleteClass2subCompleteClasses = new HashMap<CompleteClass, @NonNull Set<CompleteClass>>();
	private final @NonNull Map<Operation, Set<Operation>> operation2overrides = new HashMap<Operation, Set<Operation>>();

	public FinalAnalysis(@NonNull CompleteModelInternal completeModel) {
		this.completeModel = completeModel;
		this.metamodelManager = completeModel.getMetamodelManager();
		for (CompletePackage completePackage :  completeModel.getAllCompletePackages()) {
			for (CompleteClass subCompleteClass :  completePackage.getOwnedCompleteClasses()) {
				for (CompleteClass superCompleteClass : subCompleteClass.getSuperCompleteClasses()) {
					Set<CompleteClass> subCompleteClasses = superCompleteClass2subCompleteClasses.get(superCompleteClass);
					if (subCompleteClasses == null) {
						subCompleteClasses = new HashSet<CompleteClass>();
						superCompleteClass2subCompleteClasses.put(superCompleteClass, subCompleteClasses);
					}
					subCompleteClasses.add(subCompleteClass);
				}
			}
		}
		for (CompleteClass superCompleteClass : superCompleteClass2subCompleteClasses.keySet()) {
			Set<CompleteClass> subCompleteClasses = superCompleteClass2subCompleteClasses.get(superCompleteClass);
			assert subCompleteClasses != null;
			for (Operation domainOperation : superCompleteClass.getOperations(null)) {
				String opName = domainOperation.getName();
				ParametersId parametersId = domainOperation.getParametersId();
				LibraryFeature domainImplementation = metamodelManager.getImplementation(domainOperation);
				Set<Operation> overrides = operation2overrides.get(domainOperation);
				for (CompleteClass subCompleteClass : subCompleteClasses) {
					if (subCompleteClass != superCompleteClass) {
						for (Operation subOperation : subCompleteClass.getOperations(null)) {
							if (opName.equals(subOperation.getName()) && parametersId.equals(subOperation.getParametersId())) {
								LibraryFeature subImplementation = metamodelManager.getImplementation(subOperation);
								if ((domainImplementation != subImplementation)
								 || (domainOperation.getBodyExpression() != subOperation.getBodyExpression())
								 || (domainOperation.getTypeId() != subOperation.getTypeId())) {
									if (overrides == null) {
										overrides = new HashSet<Operation>();
										overrides.add(domainOperation);
									}
									overrides.add(subOperation);
								}
							}
						}
					}
				}
				operation2overrides.put(domainOperation, overrides);
			}
		}
//		StringBuilder s = new StringBuilder();
//		print(s);
//		System.out.println(s);
	}
	
	/**
	 * @since 1.1
	 */
	public @NonNull Iterable<Operation> getOverrides(@NonNull Operation operation) {
		Set<Operation> overrides = operation2overrides.get(operation);
		return overrides != null ? overrides : PivotMetamodelManager.EMPTY_OPERATION_LIST;
	}
	
	/**
	 * @since 1.1
	 */
	public @NonNull Iterable<Operation> getOverrides(@NonNull Operation operation, @NonNull CompleteClass completeClass) {
		Set<Operation> overrides = operation2overrides.get(operation);
		if (overrides == null) {
			return Collections.singletonList(operation);
		}
		List<Operation> results = new ArrayList<Operation>();
		StandardLibraryInternal standardLibrary = completeModel.getStandardLibrary();
		for (Operation override : overrides) {
			CompleteInheritance overrideInheritance = override.getInheritance(standardLibrary);
			if ((overrideInheritance != null) && overrideInheritance.getPivotClass().conformsTo(standardLibrary, completeClass.getPrimaryClass())) {
				results.add(override);
			}
		}
		return results;
	}
	
	public boolean isFinal(@NonNull CompleteClass completeClass) {
		Set<CompleteClass> subCompleteClasses = superCompleteClass2subCompleteClasses.get(completeClass);
		return (subCompleteClasses != null) && (subCompleteClasses.size() <= 1);
	}
	
	public boolean isFinal(@NonNull Operation operation) {
		Set<Operation> overrides = operation2overrides.get(operation);
		return overrides == null;
	}
	
	public @Nullable Operation isFinal(@NonNull Operation operation, @NonNull CompleteClass completeClass) {
		Set<Operation> overrides = operation2overrides.get(operation);
		if (overrides == null) {
			return operation;
		}
		Operation candidate = null;
		StandardLibraryInternal standardLibrary = completeModel.getStandardLibrary();
		for (Operation override : overrides) {
			CompleteInheritance overrideInheritance = override.getInheritance(standardLibrary);
			if ((overrideInheritance != null) && overrideInheritance.getPivotClass().conformsTo(standardLibrary, completeClass.getPrimaryClass())) {
				if (candidate != null) {
					return null;
				}
				candidate = override;
			}
		}
		return candidate;
	}
	
	public void print(@NonNull StringBuilder s) {
		List<CompleteClass> completeClasses = new ArrayList<CompleteClass>(superCompleteClass2subCompleteClasses.keySet());
		Collections.sort(completeClasses, new Comparator<CompleteClass>()
		{
			@Override
			public int compare(CompleteClass o1, CompleteClass o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		s.append("Final types");
		for (CompleteClass completeClass : completeClasses) {
			assert completeClass != null;
			if (isFinal(completeClass)) {
				s.append("\n\t");
				s.append(completeClass.getName());
			}
		}
		s.append("\nNon-final types");
		for (CompleteClass completeClass : completeClasses) {
			assert completeClass != null;
			if (!isFinal(completeClass)) {
				s.append("\n\t");
				s.append(completeClass.getName());
			}
		}	
	}

}
