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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * DomainTypeParameters provides a hashable list of type
 * parameters suitable for use when indexing specializations.
 */
public class DomainTypeParameters
{
	public static final @NonNull DomainTypeParameters EMPTY_LIST = new DomainTypeParameters();
	
	private final @NonNull DomainType[] typeParameters;
	private final int hashCode;

	public DomainTypeParameters(@NonNull DomainTemplateParameter... typeParameters) {
		this.typeParameters = new DomainType[typeParameters.length];
		int hash = 0;
		for (int i = 0; i < typeParameters.length; i++) {
			DomainType parameter = typeParameters[i];
			hash = 111 * hash + parameter.hashCode();
			this.typeParameters[i] = parameter;
		}
		hashCode = hash;
	}
	
	public DomainTypeParameters(@NonNull List<? extends DomainType> parameters) {
		typeParameters = new DomainType[parameters.size()];
		int hash = 0;
		for (int i = 0; i < typeParameters.length; i++) {
			DomainType parameter = parameters.get(i);
			hash = 111 * hash + parameter.hashCode();
			this.typeParameters[i] = parameter;
		}
		hashCode = hash;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof DomainTypeParameters)) {
			return false;
		}
		DomainTypeParameters that = (DomainTypeParameters)o;
		if (this.hashCode != that.hashCode){
			return false;
		}
		int iMax = typeParameters.length;
		if (iMax != that.typeParameters.length) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			DomainType thisParameter = this.typeParameters[i];
			DomainType thatParameter = that.typeParameters[i];
			if (thisParameter != null) {
				if (thatParameter != null) {
					if (!thisParameter.equals(thatParameter)) {
						return false;
					}
				}
				else {
					return false;
				}				
			}
			else {
				if (thatParameter != null) {
					return false;
				}
				else {
				}				
			}
		}
		return true;
	}

	@SuppressWarnings("null")
	public @NonNull DomainType get(int i) {
		return typeParameters[i];
	}		

	@Override
	public int hashCode() {
		return hashCode;
	}

	public int parametersSize() {
		return typeParameters.length;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		for (int i = 0; i < typeParameters.length; i++) {
			if (i > 0) {
				s.append(',');
			}
			s.append(String.valueOf(typeParameters[i]));
		}
		s.append(')');
		return s.toString();
	}
}
