/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.java;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.ids.impl.WeakHashMapOfWeakReference;
import org.eclipse.ocl.domain.types.IdResolver;
import org.eclipse.ocl.examples.codegen.java.types.JavaTypeId;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.library.UnboxedCompositionProperty;
import org.eclipse.ocl.pivot.library.UnboxedExplicitNavigationProperty;
import org.eclipse.ocl.pivot.library.UnboxedOppositeNavigationProperty;

public class JavaConstants
{
	/**
	 * Map from a Java class to the corresponding JavaTypeId. 
	 */
	private static @NonNull WeakHashMapOfWeakReference<Class<?>, JavaTypeId> javaTypes =
		new WeakHashMapOfWeakReference<Class<?>, JavaTypeId>()
		{
			@Override
			protected @NonNull JavaTypeId newId(@NonNull Class<?> javaClass) {
				return new JavaTypeId(javaClass);
			}
		};

	public static final @NonNull String E_NAME = "e";
	public static final @NonNull String EVALUATE_NAME = "evaluate";
	public static final @NonNull String EVALUATOR_NAME = "evaluator";
	public static final @NonNull String ID_RESOLVER_NAME = "idResolver";
	public static final @NonNull String INSTANCE_NAME = "INSTANCE";
	public static final @NonNull String SELF_NAME = "self";
	public static final @NonNull String STANDARD_LIBRARY_NAME = "standardLibrary";
	public static final @NonNull String TYPE_ID_NAME = "typeId";
	

	public static final @NonNull TypeId PROPERTY_TYPE_ID = getJavaTypeId(Property.class);
	public static final @NonNull TypeId DOMAIN_TYPE_TYPE_ID = getJavaTypeId(DomainClass.class);
	public static final @NonNull TypeId EVALUATOR_TYPE_ID = getJavaTypeId(DomainEvaluator.class);
	public static final @NonNull TypeId ID_RESOLVER_TYPE_ID = getJavaTypeId(IdResolver.class);
//	public static final @NonNull TypeId SELF_TYPE_ID = getJavaTypeId(Object.class);
	public static final @NonNull TypeId STANDARD_LIBRARY_TYPE_ID = getJavaTypeId(DomainStandardLibrary.class);
	public static final @NonNull TypeId TYPE_ID_TYPE_ID = getJavaTypeId(TypeId.class);
	public static final @NonNull TypeId UNBOXED_COMPOSITION_PROPERTY_TYPE_ID = getJavaTypeId(UnboxedCompositionProperty.class);
	public static final @NonNull TypeId UNBOXED_EXPLICIT_NAVIGATION_PROPERTY_TYPE_ID = getJavaTypeId(UnboxedExplicitNavigationProperty.class);
	public static final @NonNull TypeId UNBOXED_OPPOSITE_NAVIGATION_PROPERTY_TYPE_ID = getJavaTypeId(UnboxedOppositeNavigationProperty.class);
	
	/**
	 * Return the named Java typeId.
	 */
	public static @NonNull TypeId getJavaTypeId(@NonNull Class<?> javaClass) {
		if (javaClass == Boolean.class) {
			return TypeId.BOOLEAN;
		}
		else if (javaClass == String.class) {
			return TypeId.STRING;
		}
		return javaTypes.getId(javaClass);
	}
}
