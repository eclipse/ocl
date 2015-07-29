/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ids.IdResolver.IdResolverExtension;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * ShadowObjectManager manages the singleton instances resulting from side-effect free shadow object construction.
 */
public class ShadowObjectManager
{	
	/**
	 * The idResolver able to determine the oclHashCode of arbitrary objects.
	 */
	protected final @NonNull IdResolverExtension idResolver;
	
	/**
	 * The hashed map of singleton shadow objects. THe hash entry is null for no objects,
	 * a non-LIst for a single object, or a List of colliding objects.
	 */
	private @NonNull Map<Integer, Object> hash2shadowObjectOrObjects = new HashMap<Integer, Object>();
	
	public ShadowObjectManager(@NonNull IdResolverExtension idResolver) {
		this.idResolver = idResolver;
	}

	/**
	 * Return the singleton shadow object instance of shadowClass with shadowProperties
	 * initialized to same-index shadowValues. Other shadow properties assume default values.
	 */
	public @NonNull Object getShadowObject(@NonNull org.eclipse.ocl.pivot.Class shadowClass,
			@NonNull Property[] shadowProperties, @NonNull Object[] shadowValues) {
		//
		//	Return a matching old instance
		//
		int oclHashCode = shadowClass.getClass().hashCode();
		for (Object shadowValue : shadowValues) {
			oclHashCode += idResolver.oclHashCode(shadowValue);
		}
		Object eObjectOrObjects = hash2shadowObjectOrObjects.get(oclHashCode);
		if (eObjectOrObjects instanceof List<?>) {
			for (@SuppressWarnings("null")@NonNull Object eObject : (List<?>)eObjectOrObjects) {
				if (isMatchingShadowObject(eObject, shadowClass, shadowProperties, shadowValues)) {
					return eObject;
				}
			}
		}
		else if (eObjectOrObjects != null) {
			if (isMatchingShadowObject(eObjectOrObjects, shadowClass, shadowProperties, shadowValues)) {
				return eObjectOrObjects;
			}
		}
		//
		//	Create and initialize instance
		//
		Object eObject = shadowClass.createInstance();
		for (int partNumber = 0; partNumber < shadowValues.length; partNumber++) {
			Property shadowProperty = shadowProperties[partNumber];
			Object shadowValue = shadowValues[partNumber];
			shadowProperty.initValue(eObject, shadowValue);
		}
		//
		//	Save initialize instance in hash2shadowObjectOrObjects
		//
		if (eObjectOrObjects == null) {		// 0 => 1
			hash2shadowObjectOrObjects.put(oclHashCode, eObject);
		}
		else if (eObjectOrObjects instanceof List<?>) {		// >=2 => >=3
			@SuppressWarnings("unchecked")List<Object> eObjects = (List<Object>) eObjectOrObjects;
			eObjects.add(eObject);
		}
		else {								// 1 => 2
			List<Object> eObjects = new ArrayList<Object>();
			eObjects.add(eObjectOrObjects);
			hash2shadowObjectOrObjects.put(oclHashCode, eObjects);
			eObjects.add(eObject);
		}
		return eObject;
	}

	protected boolean isMatchingShadowObject(@NonNull Object eObject, @NonNull org.eclipse.ocl.pivot.Class shadowClass,
			@NonNull Property[] shadowProperties, @NonNull Object[] shadowValues) {
		for (int partNumber = 0; partNumber < shadowValues.length; partNumber++) {
			Property shadowProperty = shadowProperties[partNumber];
			Object shadowValue = shadowValues[partNumber];
			Object ecoreValue = shadowProperty.getValue(eObject);
			if (!ClassUtil.safeEquals(ecoreValue, shadowValue)) {
				return false;
			}
		}
		// FIXME Check all other properties are default.
		return true;
	}
}
