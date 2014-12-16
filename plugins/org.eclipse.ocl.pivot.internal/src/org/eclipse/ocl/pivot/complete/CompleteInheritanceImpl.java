/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.complete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.library.executor.ReflectiveInheritance;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.elements.DomainTypeParameters;
import org.eclipse.ocl.pivot.executor.PivotReflectiveFragment;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.types.AbstractFragment;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

import com.google.common.base.Function;

/**
 * An AbstractTypeServer provides the co-ordinated operation, property and superclass lookup caches for one or more merged types.
 */
public class CompleteInheritanceImpl extends ReflectiveInheritance implements CompleteInheritance
{
	@SuppressWarnings("null")
	public static final @NonNull List<CompleteInheritanceImpl> EMPTY_LIST = Collections.<CompleteInheritanceImpl>emptyList();

	public static final class BestOperation implements Function<List<Operation>, Operation> {

		@Override
		public Operation apply(List<Operation> operations) {
			return operations.get(0);
		}
	}
	
	public static final @NonNull BestOperation bestOperation = new BestOperation();

	public static @NonNull TemplateParameterSubstitution createTemplateParameterSubstitution(@NonNull TemplateParameter formalParameter, @NonNull Type type) {
		TemplateParameterSubstitution templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
		templateParameterSubstitution.setFormal(formalParameter);
		templateParameterSubstitution.setActual(type);
		return templateParameterSubstitution;
	}

	protected final @NonNull CompleteClassInternal completeClass;

	public CompleteInheritanceImpl(@NonNull CompleteClassInternal completeClass) {
		super(ClassUtil.nonNullModel(completeClass.getName()), computeFlags(completeClass.getPivotClass()));
		this.completeClass = completeClass;
		org.eclipse.ocl.pivot.Class pivotClass = completeClass.getPivotClass();
		assert !(pivotClass instanceof DataType) || (((DataType)pivotClass).getBehavioralClass() == null);	// DataTypes must use the inheritance of their behavioral class
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull CompleteInheritance baseInheritance) {
		return new PivotReflectiveFragment(this, baseInheritance);
	}

	public @NonNull CompleteClassInternal getCompleteClass() {
		return completeClass;
	}

	@Override
	public @NonNull Iterable<? extends CompleteInheritance> getInitialSuperInheritances() {
		return isOclAny() ? EMPTY_LIST : completeClass.getPartialClasses().getInitialSuperInheritances();
	}
	
	public @NonNull List<? extends Operation> getLocalOperations() {
		return ClassUtil.nonNullEMF(completeClass.getPivotClass().getOwnedOperations());			// FIXME Use local cache
	}

	public @NonNull List<? extends Property> getLocalProperties() {
		return ClassUtil.nonNullEMF(completeClass.getPivotClass().getOwnedProperties());			// FIXME Use local cache
	}

	@Override
	public @Nullable Operation getMemberOperation(@NonNull OperationId operationId) {
		return completeClass.getOperation(operationId);
	}

	@Override
	public @Nullable Property getMemberProperty(@NonNull String propertyName) {
		return completeClass.getProperty(propertyName);
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return completeClass.getPivotClass().getMetaTypeName();
	}

	@Override
	public @NonNull List<Property> getOwnedProperties() {
		return ClassUtil.nonNullEMF(completeClass.getPivotClass().getOwnedProperties());			// FIXME Use local cache
	}
	
	@Override
	public @NonNull List<Operation> getOwnedOperations() {
		return ClassUtil.nonNullEMF(completeClass.getPivotClass().getOwnedOperations());			// FIXME Use local cache
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getSuperClasses() {
		List<org.eclipse.ocl.pivot.Class> superClasses = new ArrayList<org.eclipse.ocl.pivot.Class>();
		for (org.eclipse.ocl.pivot.Class superClass : completeClass.getProperSuperClasses()) {
			superClasses.add(superClass);
		}
		return superClasses;
	}
	
	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getType() {
		return getCompleteClass().getPivotClass();
	}

	@Override
	public final @NonNull TypeId getTypeId() {
		return completeClass.getPivotClass().getTypeId();
	}

	@Override
	public @NonNull DomainTypeParameters getTypeParameters() {
		return DomainTypeParameters.EMPTY_LIST;
	}

	@Override
	public String toString() {
		return completeClass.getPivotClass().toString();	
	}

	@Override
	public void uninstall() {
//		System.out.println("uninstall " + toString());
		completeClass.uninstall();
		super.uninstall();
	}
}
