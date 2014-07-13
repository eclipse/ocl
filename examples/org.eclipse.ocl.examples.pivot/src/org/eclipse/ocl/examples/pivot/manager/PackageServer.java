/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     E.D.Willink (CEA LIST) - Bug 399378
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ReflectivePackage;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VoidType;

import com.google.common.collect.Iterables;

/**
 * A PackageServer adapts the primary Package to coordinate the coherent behavior of a primary and one or more
 * secondary Packages as required for Complete OCL package extension.
 */
public abstract class PackageServer extends ReflectivePackage implements PackageServerParent
{
	/**
	 * Map of (nested) package-name to package server.
	 */
	private @Nullable Map<String, NestedPackageServer> packageServers = null;

	protected final @NonNull PackageManager packageManager;
		
	/**
	 * List of all package extensions including this.
	 */
	private final @NonNull List<PackageTracker> trackers = new ArrayList<PackageTracker>();
	
	/**
	 * Lazily created map of nested class-name to multi-class server.
	 */
	private @Nullable Map<String, TypeServer> typeServers = null;
	
	/**
	 * Lazily cached best package representation.
	 */
	private @Nullable org.eclipse.ocl.examples.pivot.Package representativePackage = null;
	
	protected PackageServer(@NonNull PackageManager packageManager, @NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId) {
		super(name, nsPrefix, nsURI, packageId);
		this.packageManager = packageManager;
	}
	
	void addedMemberType(@NonNull DomainType pivotType) {
		if ((pivotType instanceof LambdaType) || (pivotType instanceof TupleType)) {	// FIXME parent not necessarily in place
			return;
		}
		if (typeServers != null) {
			getTypeServer(pivotType);
		}
	}
	
	public @NonNull PackageTracker addTrackedPackage(@NonNull DomainPackage pivotPackage) {
		assertSamePackage(pivotPackage);
		PackageTracker packageTracker = packageManager.findPackageTracker(pivotPackage);
		if (packageTracker == null) {
			packageTracker = new PackageTracker(this, pivotPackage);
			packageManager.addPackageTracker(pivotPackage, packageTracker);
			if (typeServers != null) {
				initMemberTypes(pivotPackage);
			}	
			initMemberPackages(pivotPackage);
		}
		if (!trackers.contains(packageTracker)) {
			trackers.add(packageTracker);
			representativePackage = null;		// Force recomputation
		}
		return packageTracker;
	}

	public void addedMemberPackage(@NonNull DomainPackage pivotPackage) {
		PackageServer packageServer = getMemberPackageServer(pivotPackage);
		packageServer.addTrackedPackage(pivotPackage);
	}

	protected void assertSamePackage(@Nullable DomainPackage domainPackage) {
		assert domainPackage != null;
		String typeBasedNsURI = domainPackage.getNsURI();
		String serverBasedNsURI = getNsURI();
		assert (typeBasedNsURI == serverBasedNsURI) || typeBasedNsURI.equals(serverBasedNsURI);
	}

	@Override
	protected @NonNull DomainInheritance createExecutorType(@NonNull DomainType domainType) {
		return getTypeServer(domainType);
	}

	protected void dispose() {
		if (!trackers.isEmpty()) {
			Collection<PackageTracker> savedPackageTrackers = new ArrayList<PackageTracker>(trackers);
			trackers.clear();
			for (PackageTracker tracker : savedPackageTrackers) {
				tracker.dispose();
			}
		}
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 != null) {
			Collection<TypeServer> savedTypeServers = new ArrayList<TypeServer>(typeServers2.values());
			typeServers2.clear();
			for (TypeServer typeServer : savedTypeServers) {
				typeServer.dispose();
			}
			typeServers = null;
		}
		Map<String, NestedPackageServer> packageServers2 = packageServers;
		if (packageServers2 != null) {
			Collection<NestedPackageServer> savedPackageServers = new ArrayList<NestedPackageServer>(packageServers2.values());
			packageServers2.clear();
			for (NestedPackageServer packageServer : savedPackageServers) {
				packageServer.dispose();
			}
			packageServers = null;
		}
	}
	
	public void disposedNestedPackageServer(@NonNull NestedPackageServer packageServer) {
		Map<String, NestedPackageServer> packageServers2 = packageServers;
		if (packageServers2 != null) {
			packageServers2.remove(packageServer.getName());
		}
		packageManager.disposedPackageServer(packageServer.getNsURI());
	}

	void disposedPackageTracker(@NonNull PackageTracker packageTracker) {
		trackers.remove(packageTracker);
		representativePackage = null;		// Force recomputation
		if (trackers.size() <= 0) {
			dispose();
		}	// FIXME else trash types and other caches
		packageManager.disposedPackageTracker(packageTracker);
	}

	void disposedTypeServer(@NonNull TypeServer typeServer) {
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 != null) {
			typeServers2.remove(typeServer.getName());
		}
	}

//	public @Nullable PackageTracker findPackageTracker(@NonNull DomainPackage pivotPackage) {
//		for (PackageTracker packageTracker : trackers) {
//			if (packageTracker.getTarget() == pivotPackage) {
//				return packageTracker;
//			}
//		}
//		return null;
//	}

	/**
	 * Return the Package to represent this package merge.
	 */
	public @Nullable org.eclipse.ocl.examples.pivot.Package findPivotPackage() {
		for (PackageTracker packageTracker : trackers) {
			DomainPackage trackedPackage = packageTracker.getPackage();
			if (trackedPackage instanceof org.eclipse.ocl.examples.pivot.Package) {
				return (org.eclipse.ocl.examples.pivot.Package)trackedPackage;
			}
		}
		return null;
	}

	@Override
	protected @NonNull Iterable<? extends DomainType> getDomainTypes() {
		return getMemberTypes();
	}

	@Override
	public EPackage getEPackage() {
		for (PackageTracker packageTracker : trackers) {
			DomainPackage target = packageTracker.getPackage();
			if (target instanceof org.eclipse.ocl.examples.pivot.Package) {
				org.eclipse.ocl.examples.pivot.Package pivotPackage = (org.eclipse.ocl.examples.pivot.Package)target;
				EObject eTarget = pivotPackage.getETarget();
				if (eTarget instanceof EPackage) {
					return (EPackage) eTarget;
				}
			}
		}
		return null;
	}

	/**
	 * @since 3.5
	 */
	public int getIndex(@NonNull org.eclipse.ocl.examples.pivot.Package asPackage) {
		PackageTracker packageTracker = getPackageTracker(asPackage);
		assert packageTracker != null;
		return trackers.indexOf(packageTracker);
	}

	public @Nullable NestedPackageServer getMemberPackage(@NonNull String memberPackageName) {
		Map<String, NestedPackageServer> packageServers2 = packageServers;
		if (packageServers2 == null) {
			return null;
		}
		return packageServers2.get(memberPackageName);
	}

	public @NonNull NestedPackageServer getMemberPackageServer(@NonNull DomainPackage pivotPackage) {
		Map<String, NestedPackageServer> packageServers2 = packageServers;
		if (packageServers2 == null) {
			packageServers2 = packageServers = new HashMap<String, NestedPackageServer>();
		}
		String name = pivotPackage.getName();
		if (name == null) {
			throw new IllegalStateException("Unnamed package");
		}
		NestedPackageServer packageServer = packageServers2.get(name);
		if (packageServer == null) {
			String nsPrefix = pivotPackage.getNsPrefix();
			String nsURI = pivotPackage.getNsURI();
			packageServer = new NestedPackageServer(this, name, nsPrefix, nsURI, pivotPackage.getPackageId());
			packageServers2.put(name, packageServer);
			if (nsURI != null) {
				packageManager.addPackageServer(packageServer);
			}
		}
		return packageServer;
	}

	public @Nullable NestedPackageServer getMemberPackageServer(@NonNull String name) {
		Map<String, NestedPackageServer> packageServers2 = packageServers;
		return packageServers2 != null ? packageServers2.get(name) : null;
	}

	public @NonNull List<NestedPackageServer> getMemberPackages() {
		Map<String, NestedPackageServer> packageServers2 = packageServers;
		if (packageServers2 == null) {
			return NestedPackageServer.EMPTY_LIST;
		}
		else {
			List<NestedPackageServer> values = new ArrayList<NestedPackageServer>(packageServers2.values());
			return values;
		}
	}

	public Type getMemberType(String typeName) {
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 == null) {
			typeServers2 = initMemberTypes();
		}
		TypeServer typeServer = typeServers2.get(typeName);
		return typeServer != null ? typeServer.getPivotType() : null;
	}

	public @NonNull Iterable<TypeServer> getMemberTypes() {
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 == null) {
			typeServers2 = initMemberTypes();
		}
		@SuppressWarnings("null")
//		@NonNull Iterable<Type> transform = Iterables.transform(typeServers2.values(), TypeServer.server2type);
		@NonNull Collection<TypeServer> values = typeServers2.values();
		return values;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return packageManager.getMetaModelManager();
	}

	public List<NestedPackageServer> getNestedPackage() {
		return getMemberPackages();
	}

	public final @NonNull PackageManager getPackageManager() {
		return packageManager;
	}

	public @NonNull PackageTracker getPackageTracker(@NonNull DomainPackage pivotPackage) {
		for (PackageTracker packageTracker : trackers) {
			if (packageTracker.getPackage() == pivotPackage) {
				return packageTracker;
			}
		}
		return addTrackedPackage(pivotPackage);
	}

	abstract @Nullable PackageServerParent getParentPackageServer();  // FIXME Change to PackageServer

	@SuppressWarnings("null")
	public @NonNull Iterable<DomainPackage> getPartialPackages() {
		return Iterables.transform(trackers, PackageTracker.tracker2package);
	}

	/**
	 * Return a Package that represents this package merge.
	 */
	public @NonNull org.eclipse.ocl.examples.pivot.Package getPivotPackage() {
		org.eclipse.ocl.examples.pivot.Package representativePackage2 = representativePackage;
		if (representativePackage2 == null) {
			representativePackage2 = representativePackage = findPivotPackage();
			if (representativePackage2 == null) {
				throw new IllegalStateException("Missing pivot package");
			}
		}
		return representativePackage2;
	}

	/**
	 * @since 3.5
	 */
	public @NonNull RootPackageServer getRootPackageServer() {
		for (PackageServer packageServer = this; packageServer != null; packageServer = (PackageServer)packageServer.getParentPackageServer()) {
			if (packageServer instanceof RootPackageServer) {
				return (RootPackageServer) packageServer;
			}
		}
		return DomainUtil.nonNullState(null);		// Never happens
	}

	@Override
	protected @NonNull DomainStandardLibrary getStandardLibrary() {
		return packageManager.getMetaModelManager();
	}
	
	@NonNull TypeServer getTypeServer(@NonNull DomainType pivotType) {
		if (pivotType instanceof TypeServer) {
			return (TypeServer)pivotType;
		}
		assert !(pivotType instanceof Type) || (pivotType instanceof Metaclass<?>) || (((Type)pivotType).getUnspecializedElement() == null);
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 == null) {
			typeServers2 = initMemberTypes();
		}
		String name = pivotType.getName();
		if (name == null) {
			throw new IllegalStateException("Unnamed type");
		}
		TypeServer typeServer = typeServers2.get(name);
		if (typeServer == null) {
			if (pivotType instanceof InvalidType) {
				typeServer = new InvalidTypeServer(this, (InvalidType)pivotType);
			}
			else if (pivotType instanceof VoidType) {
				typeServer = new VoidTypeServer(this, (VoidType)pivotType);
			}
			else if (pivotType instanceof AnyType) {
				typeServer = new AnyTypeServer(this, (AnyType)pivotType);
			}
			else if (pivotType instanceof Enumeration) {
				typeServer = new EnumerationTypeServer(this, (Enumeration)pivotType);
			}
			else if (pivotType instanceof CollectionType) {
				typeServer = new CollectionTypeServer(this, (CollectionType)pivotType);
			}
			else if (pivotType instanceof PrimitiveType) {
				typeServer = packageManager.getPrimitiveTypeServer((PrimitiveType)pivotType);
			}
			else if (pivotType instanceof Metaclass<?>) {
				typeServer = new MetaclassServer(this, (Metaclass<?>)pivotType);
			}
//			else if (pivotType instanceof ElementExtension) {
//				typeServer = new ExtensionTypeServer(this, (ElementExtension)pivotType);
//			}
			else {
				typeServer = new TemplateableTypeServer(this, pivotType);
			}
			if ((pivotType instanceof Type) && (((Type)pivotType).getUnspecializedElement() == null)) {
				typeServers2.put(name, typeServer);
			}
		}
		if (typeServer instanceof ExtensibleTypeServer) {
			((ExtensibleTypeServer)typeServer).getTypeTracker(pivotType);
		}
		return typeServer;
	}

	private void initMemberPackages(@NonNull DomainPackage pivotPackage) {
		for (DomainPackage nestedPackage : pivotPackage.getNestedPackage()) {
			if (nestedPackage != null) {
				addedMemberPackage(nestedPackage);
			}
		}
	}		
	
	private @NonNull Map<String, TypeServer> initMemberTypes() {
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 == null) {
			typeServers2 = typeServers = new HashMap<String, TypeServer>();
			if (!PivotConstants.ORPHANAGE_URI.equals(nsURI)) {
				for (PackageTracker packageTracker : trackers) {
					initMemberTypes(packageTracker.getPackage());
				}
			}
		}
		return typeServers2;
	}

	private void initMemberTypes(@NonNull DomainPackage pivotPackage) {
		for (DomainType pivotType : pivotPackage.getOwnedType()) {
			if (pivotType != null) {
				addedMemberType(pivotType);
			}
		}
	}		

	void removedMemberPackage(@NonNull DomainPackage pivotPackage) {
		packageManager.removedPackage(pivotPackage);
	}

	void removedMemberType(@NonNull DomainType pivotType) {
		packageManager.removedType(pivotType);
	}

	@Override
	public String toString() {
		return getName() + " : " + getNsURI();
	}
}