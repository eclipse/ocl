/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.domain.values.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * UML implementation of a tuple value.
 * 
 * @author Christian W. Damus (cdamus)
 * @generated NOT
 */
public class TupleValueImpl extends ValueImpl implements TupleValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.TUPLE_VALUE;
	}

	protected final @NonNull TupleTypeId tupleTypeId;
    private final @NonNull Object[] partValues;
    private Integer hashCode = null;

    /**
     * Initializes me with a map of part values.
     * 
     * @param tupleTypeId my type
     * @param values my parts
     */
    public TupleValueImpl(@NonNull TupleTypeId tupleTypeId, @NonNull Map<? extends TuplePartId, Object> values) {
		this.tupleTypeId = tupleTypeId;
	    partValues = new Object[tupleTypeId.getPartIds().length];
        for (Map.Entry<? extends TuplePartId, Object> entry : values.entrySet()) {
        	partValues[entry.getKey().getIndex()] = entry.getValue();
        }
    }
    
    /**
     * Convenience constructor to initialize me with a list of values as
     * required by the Collection::product() operation.
     * 
     * @param tupleTypeId my type
     * @param values my values which are aligned to the tupleTypeId.getParts()
     */
    public TupleValueImpl(@NonNull TupleTypeId tupleTypeId, @NonNull Object... values) {
		this.tupleTypeId = tupleTypeId;
		TuplePartId[] partIds = tupleTypeId.getPartIds();
		if (partIds.length != values.length) {
			throw new InvalidValueException("Mismatching tuple values");
		}
	    partValues = new Object[partIds.length];
		for (int i = 0; i < values.length; i++) {
			partValues[i] = values[i];
		}
    }

	public @NonNull Object asObject() {
		return partValues;
	}

    @Override
	public @NonNull TupleValue asTupleValue() {
        return this;
    }

    // overrides the inherited implementation
    @Override
    public boolean equals(Object o) {
    	if (this == o) {
    		return true;
    	}
    	if (!(o instanceof TupleValueImpl)) {
    		return false;
    	}
    	TupleValueImpl that = (TupleValueImpl)o;
    	if (this.tupleTypeId != that.tupleTypeId) {
    		return false;
    	}
		for (int i = 0; i < partValues.length; i++) {
			Object thisPart = partValues[i];
			Object thatPart = that.partValues[i];
			if (thisPart == null) {
				if (thatPart != null) {
					return false;
				}
			}
			else {
				if (!thisPart.equals(thatPart)) {
					return false;
				}
			}
		}
    	return true;
    }

	public @NonNull TupleTypeId getTypeId() {
		return tupleTypeId;
	}

    // implements the inherited specification
    public @Nullable Object getValue(@NonNull TuplePartId partId) {
        return getValue(partId.getIndex());
    }

    // implements the inherited specification
    public @Nullable Object getValue(int index) {
        return partValues[index];
    }

    // overrides the inherited implementation
    @Override
    public int hashCode() {
    	if (hashCode == null) {
            int hash = tupleTypeId.hashCode();
    		for (Object partValue : partValues) {
    			hash = 37* hash + (partValue != null ? partValue.hashCode() : 0);
    		}
    		hashCode = hash;
    	}
		return hashCode;
    }

	@Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Tuple{"); //$NON-NLS-1$       
        TuplePartId[] partIds = tupleTypeId.getPartIds();
		for (int i = 0; i < partIds.length; i++) {
			TuplePartId partId = partIds[i];
            if (i != 0) {
                result.append(", "); //$NON-NLS-1$
            }
			result.append(partId.getDisplayName());
            result.append(" = "); //$NON-NLS-1$a	
            ValuesUtil.toString(partValues[i], result, 40);
        }       
        result.append("}"); //$NON-NLS-1$
        return result.toString();
    }
    
/*    private String toString(Object o) {
        / *if (o instanceof String) {
            return "'" + (String) o + "'"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if (o instanceof NullValue) {
            return o.toString();
        } else if (o instanceof CollectionValue) {
            return toString((CollectionValue) o);
        } else* / if (o == null) {
            return "null"; //$NON-NLS-1$
        } else {
            return o.toString();
        }
    } */
}
