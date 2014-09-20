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
package org.eclipse.ocl.examples.pivot.manager;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.AbstractFragment;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ReflectiveInheritance;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.executor.PivotReflectiveFragment;

import com.google.common.base.Function;

/**
 * An AbstractTypeServer provides the co-ordinated operation, property and superclass lookup caches for one or more merged types.
 */
public class CompleteInheritance extends ReflectiveInheritance
{
	@SuppressWarnings("null")
	public static final @NonNull List<CompleteInheritance> EMPTY_LIST = Collections.<CompleteInheritance>emptyList();

	public static final class BestOperation implements Function<List<DomainOperation>, DomainOperation> {

		public DomainOperation apply(List<DomainOperation> operations) {
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

	protected final @NonNull CompleteClass.Internal completeClass;

	public CompleteInheritance(@NonNull CompleteClass.Internal completeClass) {
		super(DomainUtil.nonNullModel(completeClass.getName()), computeFlags(completeClass.getPivotClass()));
		this.completeClass = completeClass;
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull DomainInheritance baseInheritance) {
		return new PivotReflectiveFragment(this, baseInheritance);
	}

	public @NonNull CompleteClass.Internal getCompleteClass() {
		return completeClass;
	}

	@Override
	public @NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances() {
		return isOclAny() ? EMPTY_LIST : completeClass.getInitialSuperInheritances();
	}
	
	public @NonNull List<? extends DomainOperation> getLocalOperations() {
		return DomainUtil.nonNullEMF(completeClass.getPivotClass().getOwnedOperations());			// FIXME Use local cache
	}

	public @NonNull List<? extends DomainProperty> getLocalProperties() {
		return DomainUtil.nonNullEMF(completeClass.getPivotClass().getOwnedProperties());			// FIXME Use local cache
	}

	public @Nullable DomainProperty getMemberProperty(@NonNull String propertyName) {
		return completeClass.getProperty(propertyName);
	}

	public @NonNull String getMetaTypeName() {
		return completeClass.getPivotClass().getMetaTypeName();
	}

	public @NonNull List<? extends DomainProperty> getOwnedProperties() {
		return DomainUtil.nonNullEMF(completeClass.getPivotClass().getOwnedProperties());			// FIXME Use local cache
	}
	
	public @NonNull List<? extends DomainOperation> getOwnedOperations() {
		return DomainUtil.nonNullEMF(completeClass.getPivotClass().getOwnedOperations());			// FIXME Use local cache
	}

	public @NonNull Iterable<? extends DomainClass> getSuperClasses() {
		return completeClass.getProperSuperClasses();
	}
	
	public @NonNull DomainClass getType() {
		return getCompleteClass().getPivotClass();
	}

	@Override
	public final @NonNull TypeId getTypeId() {
		return completeClass.getPivotClass().getTypeId();
	}

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
