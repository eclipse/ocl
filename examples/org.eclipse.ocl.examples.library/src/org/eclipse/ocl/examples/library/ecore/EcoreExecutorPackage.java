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
package org.eclipse.ocl.examples.library.ecore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorPackage;
import org.eclipse.ocl.examples.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.examples.library.executor.ExecutorType;

import com.google.common.collect.Lists;

public class EcoreExecutorPackage extends ExecutorPackage
{
	protected final EPackage ePackage;
	private ExecutorStandardLibrary standardLibrary = null;
	private ExecutorType[] types = null;
	private @Nullable List<EcoreExecutorPackage> packages = null;

	public EcoreExecutorPackage(/*@NonNull*/ EPackage ePackage) {
		super(DomainUtil.nonNullEMF(ePackage.getName()), ePackage.getNsPrefix(), ePackage.getNsURI(), IdManager.getPackageId(ePackage));
		this.ePackage = ePackage;		
	}

	/**
	 * @since 3.5
	 */
	public EcoreExecutorPackage(@NonNull EPackage ePackage, @NonNull PackageId packageId) {
		super(DomainUtil.nonNullEMF(ePackage.getName()), ePackage.getNsPrefix(), ePackage.getNsURI(), packageId);
		this.ePackage = ePackage;		
	}

	@Override
	public final EPackage getEPackage() {
		return ePackage;
	}

	public List<? extends DomainPackage> getNestedPackage() {
		List<EcoreExecutorPackage> packages2 = packages;
		if (packages2 == null) {
			synchronized (this) {
				packages2 = packages;
				if (packages2 == null) {
					packages2 = packages = new ArrayList<EcoreExecutorPackage>();
					for (EPackage eSubPackage : ePackage.getESubpackages()) {
						assert eSubPackage != null;
						EcoreExecutorPackage subPackage = standardLibrary.getPackage(eSubPackage);
						if (subPackage != null) {
							packages2.add(subPackage);
						}
					}
				}
			}
		}
		return packages2;
	}

	public DomainPackage getNestingPackage() {
		EPackage eSuperPackage = ePackage.getESuperPackage();
		if (eSuperPackage == null) {
			return null;
		}
		return standardLibrary.getPackage(eSuperPackage);
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull List<DomainInheritance> getOwnedType() {
		if (types != null) {
			return Lists.<DomainInheritance>newArrayList(types);
		}
		else {
			return Collections.emptyList();
		}
	}

	@Override
	public DomainInheritance getType(String typeName) {
		for (DomainInheritance type: getOwnedType()) {
			if (type.getName().equals(typeName)) {
				return type;
			}
		}
		return null;
	}
	
	public void init(@Nullable ExecutorStandardLibrary standardLibrary, @NonNull ExecutorType[] types) {
		assert this.standardLibrary == null;
		assert this.types == null;
		this.standardLibrary = standardLibrary;
		this.types = types;
		if (standardLibrary != null) {
			standardLibrary.addPackage(this, null);
		}
	}
	
/*	public void init2(EcoreExecutorPackage execPackage, ExecutorType[] types) {
		ExecutorStandardLibrary standardLibrary = execPackage.standardLibrary;
		assert this.standardLibrary == null;
		assert this.types == null;
		this.standardLibrary = standardLibrary;
		this.types = types;
		if (standardLibrary != null) {
			standardLibrary.addPackage(this, execPackage);
		}
	} */
	
	@Deprecated
	public void init(@NonNull ExecutorType[] types) {
		init((ExecutorStandardLibrary)null, types);
	}
	
//	public ExecutorType lookupType(int classIndex) {
//		return types[classIndex];
//	}
}