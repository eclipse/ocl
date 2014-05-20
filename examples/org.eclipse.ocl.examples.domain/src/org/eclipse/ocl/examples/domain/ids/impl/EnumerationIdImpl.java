/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class EnumerationIdImpl extends AbstractTypeId implements EnumerationId
{
	protected final @NonNull PackageId parent;
	protected final @NonNull String name;
	protected final int hashCode;

	/**
	 * Map from a nested type name to the corresponding EnumerationLiteralId. 
	 */
	private @Nullable WeakHashMapOfWeakReference<String, EnumerationLiteralId> memberEnumerationLiterals = null;

	public EnumerationIdImpl(@NonNull PackageId parent, @NonNull String name) {
		this.hashCode = 97 * parent.hashCode() + name.hashCode();
		this.parent = parent;
		this.name = name;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitEnumerationId(this);
	}

	public @NonNull String getDisplayName() {
		if (parent instanceof NsURIPackageId) {
			return name;
		}
		else {
			return parent + "::" + name;
		}
	}

	@Override
	public @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name) {
    	WeakHashMapOfWeakReference<String, EnumerationLiteralId> memberEnumerationLiterals2 = memberEnumerationLiterals;
		if (memberEnumerationLiterals2 == null) {
    		synchronized (this) {
    			memberEnumerationLiterals2 = memberEnumerationLiterals;
    	    	if (memberEnumerationLiterals2 == null) {
    	    		memberEnumerationLiterals = memberEnumerationLiterals2 = new WeakHashMapOfWeakReference<String, EnumerationLiteralId>()
    				{
						@Override
						protected @NonNull EnumerationLiteralId newId(@NonNull String name) {
							return new EnumerationLiteralIdImpl(EnumerationIdImpl.this, name);
						}
					};
	    	   }
    		}
    	}
		return memberEnumerationLiterals2.getId(name);
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return TypeId.ENUMERATION_NAME;
	}

	public @NonNull String getName() {
		return name;
	}
	
	public @NonNull PackageId getParent() {
		return parent;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}
	
	@Override
	public String toString() {
		return parent + "::" + name;
	}

}