/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.Orphanage;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * ASSaverNormalizeVisitor normalizes contents by alphabeticizing 
 * - lists of Property.
 */
public class ASSaverNormalizeVisitor extends AbstractExtendingVisitor<Object, ASSaver>
{
	protected static final class PropertyComparator implements Comparator<Property>
	{
		public static final @NonNull Comparator<Property> INSTANCE = new PropertyComparator();

		public int compare(Property o1, Property o2) {
			assert o1 != null;
			assert o2 != null;
			int l1 = o1.isImplicit() ? 1 : 0;
			int l2 = o2.isImplicit() ? 1 : 0;
			if (l1 != l2) {
				return l1 - l2;
			}
			String n1 = o1.getName();
			String n2 = o2.getName();
			if (n1 == null) n1 = "";
			if (n2 == null) n2 = "";
			return n1.compareTo(n2);
		}
	}
	
	protected static final class TypeComparator implements Comparator<Type>
	{
		public static final @NonNull Comparator<Type> INSTANCE = new TypeComparator();

		public int compare(Type o1, Type o2) {
			assert o1 != null;
			assert o2 != null;
			String n1 = AS2Moniker.toString(o1);
			String n2 = AS2Moniker.toString(o2);
			return n1.compareTo(n2);
		}
	}

	public ASSaverNormalizeVisitor(@NonNull ASSaver context) {
		super(context);
	}

	protected <T> void sort(@NonNull List<T> ownedTypes, @NonNull Comparator<T> comparator) {
		List<T> sortedList = new ArrayList<T>(ownedTypes);
		Collections.sort(sortedList, comparator);
		ownedTypes.clear();
		ownedTypes.addAll(sortedList);
	}

	@Override
	public Object visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		List<Property> ownedAttributes = object.getOwnedAttribute();
		sort(ownedAttributes, PropertyComparator.INSTANCE);
		return null;
	}

	@Override
	public Object visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package object) {
		if (!(object instanceof Orphanage)) {			// The Orphanage is not assignable/sortable
			@NonNull List<Type> ownedTypes = object.getOwnedType();
			sort(ownedTypes, TypeComparator.INSTANCE);
		}
		return null;
	}

	public Object visiting(@NonNull Visitable visitable) {
		return null;
	}
}
