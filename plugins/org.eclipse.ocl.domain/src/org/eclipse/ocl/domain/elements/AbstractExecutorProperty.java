/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.elements;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.PropertyId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.LibraryFeature;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.pivot.AssociationClass;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Property;

public abstract class AbstractExecutorProperty extends AbstractExecutorTypedElement implements Property
{
	protected final int propertyIndex;
	protected Property opposite;

	public AbstractExecutorProperty(@NonNull String name, @NonNull DomainType executorType, int propertyIndex) {
		super(name, executorType);
		this.propertyIndex = propertyIndex;
		this.opposite = null;
	}

	@Override
	public LanguageExpression getDefaultExpression() {
		throw new UnsupportedOperationException(); 			// FIXME
	}

	@Override
	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return executorType.getInheritance(standardLibrary);
	}

	@Override
	public @NonNull Property getOpposite() {
		return DomainUtil.nonNullState(opposite);
	}

	@Override
	public @NonNull TypeId getTypeId() {
		DomainType type2 = getType();
		return type2.getTypeId();
	}

	void initOpposite(@NonNull Property opposite) {
		this.opposite = opposite;
	}

	@Override
	public void initValue(@NonNull EObject objectValue, @Nullable Object propertyValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isStatic() {
		return false;								// WIP FIXME
	}

	@Override
	public AssociationClass getAssociationClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getDefault() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getImplementationClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Property> getKeys() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Class getOwningClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public PropertyId getPropertyId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Property> getRedefinedProperty() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Property getReferredProperty() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Property> getSubsettedProperty() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isAttribute(Property p) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isComposite() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isDerived() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isID() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isImplicit() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isReadOnly() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isResolveProxies() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isTransient() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isUnsettable() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isVolatile() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAssociationClass(AssociationClass value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDefault(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDefaultExpression(LanguageExpression value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setImplicit(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setImplementation(LibraryFeature value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setImplementationClass(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsComposite(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsDerived(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsID(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsReadOnly(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsResolveProxies(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsStatic(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsUnsettable(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsTransient(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsVolatile(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOpposite(Property value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwningClass(Class value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setReferredProperty(Property value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean validateCompatibleDefaultExpression(
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		return String.valueOf(executorType) + "::" + String.valueOf(name); //$NON-NLS-1$
	}
}