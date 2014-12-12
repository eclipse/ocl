/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.elements;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.ids.IdManager;
import org.eclipse.ocl.domain.ids.ParametersId;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Type;

/**
 * DomainParameterTypesIterable provides a hashable list of operation
 * parameters suitable for use when indexing operation overloads.
 */
public class DomainParameterTypes
{
	public static final @NonNull DomainParameterTypes EMPTY_LIST = new DomainParameterTypes();
	
	private final @NonNull ParametersId parametersId;
	private final @NonNull Type[] parameterTypes;
	private final int hashCode;
	private /*@LazyNonNull*/ List<Parameter> parameters = null;
	
	public DomainParameterTypes(@NonNull Type... parameterTypes) {
		this.parametersId = IdManager.getParametersId(parameterTypes);
		this.parameterTypes = parameterTypes;
		hashCode = parametersId.hashCode() + 0x999;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DomainParameterTypes)) {
			return false;
		}
		DomainParameterTypes that = (DomainParameterTypes)obj;
		if (hashCode() != that.hashCode()) {
			return false;
		}
		Type[] thoseParameters = that.parameterTypes;
		if (parameterTypes.length != thoseParameters.length) {
			return false;
		}
		for (int i = 0; i < parameterTypes.length; i++) {
			if (!parameterTypes[i].equals(thoseParameters[i])) {
				return false;
			}
		}
		return true;
	}

	public @NonNull Type get(int index) {
		Type parameterType = parameterTypes[index];
		assert parameterType != null;
		return parameterType;
	}

	public @NonNull Type[] get() {
		return parameterTypes;
	}

	public @NonNull ParametersId getParametersId() {
		return parametersId;
	}
	
	public @NonNull List<Parameter> getParameters() {
		List<Parameter> parameters2 = parameters;
		if (parameters2 == null) {
			parameters = parameters2 = new ArrayList<Parameter>();
			for (int i = 0; i < parameterTypes.length; i++) {
				@SuppressWarnings("null")@NonNull Type type = parameterTypes[i];
				parameters2.add(new AbstractExecutorParameter("_" + i, type, false));
			}
		}
		return parameters2;
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	public int size() {
		return parameterTypes.length;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i > 0) {
				s.append(',');
			}
			s.append(parameterTypes[i].toString());
		}
		s.append(')');
		return s.toString();
	}
}