/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.ids.impl;


import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public abstract class AbstractTypeId extends AbstractElementId implements TypeId
{
	/**
	 * Map from the operation hashCode to the operationIds with the same hash. 
	 */
	private @Nullable OperationIdsMap memberOperations = null;

	public @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name) {
    	throw new UnsupportedOperationException();
    }

	public @NonNull String getMetaTypeName() {
		return TypeId.CLASS_NAME;
	}

    public @NonNull OperationId getOperationId(int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
//		System.out.println("getOperationId " + name + " " + DomainUtil.debugFullName(parametersId) + " with " + DomainUtil.debugFullName(templateParameters));		
		OperationIdsMap memberOperations2 = memberOperations;
		if (memberOperations2 == null) {
    		synchronized (this) {
    			memberOperations2 = memberOperations;
    	    	if (memberOperations2 == null) {
	    			memberOperations = memberOperations2 = new OperationIdsMap(this);
    	    	}
    		}
    	}
		return memberOperations2.getId(templateParameters, name, parametersId);
	}

    public @NonNull PropertyId getPropertyId(@NonNull String name) {
    	throw new UnsupportedOperationException();
    }
	
    public @NonNull TemplateParameterId getTemplateParameterId(int index) {
    	throw new UnsupportedOperationException();
    }
	
    public int getTemplateParameters() {
    	throw new UnsupportedOperationException();
    }
   
    public @NonNull TypeId specialize(@NonNull BindingsId templateBindings) {
    	throw new UnsupportedOperationException();
	}
}