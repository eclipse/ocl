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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.DomainConstants;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.IllegalMetamodelException;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * PackageManager encapsulates the knowledge about known packages and their nsURIs.
 */
public class PackageManager implements PackageServerParent
{
	private static final Logger logger = Logger.getLogger(PackageManager.class);

	/**
	 * The MetaModelManager for which this PackageManager manages the packages.
	 */
	protected final @NonNull MetaModelManager metaModelManager;

	/**
	 * Map of (nested) package-name to package server.
	 */
	private final @NonNull Map<String, RootPackageServer> packageServers = new HashMap<String, RootPackageServer>();

	private final @NonNull Set<RootTracker> rootTrackers = new HashSet<RootTracker>();

	/**
	 * Map from package URI to primary package. 
	 */
	private final @NonNull Map<String, PackageServer> uri2package = new HashMap<String, PackageServer>();
	
	/**
	 * Map of synonym URI to shared URI.
	 */
	private final @NonNull Map<String, String> synonymURI2sharedURI = new HashMap<String, String>();
	
	/**
	 * Map of shared URIs to synonyms
	 */
	private final @NonNull Map<String, Set<String>> sharedURI2synonymURIs = new HashMap<String, Set<String>>();

	/**
	 * Map from each merged package to the PackageTracker that supervises its merge. PackageTrackers are only
	 * created for merged packages, so a missing entry just denotes an unmerged package. 
	 */
	private final @NonNull Map<DomainPackage, PackageTracker> package2tracker = new HashMap<DomainPackage, PackageTracker>();

	/**
	 * Map from each merged type to the TypeTracker that supervises its merge. TypeTrackers are only
	 * created for merged types, so a missing entry just denotes an unmerged type. 
	 */
	private final @NonNull Map<DomainType, TypeTracker> type2tracker = new WeakHashMap<DomainType, TypeTracker>();

	/**
	 * Map from each primitive type name to the TypeServer that supervises its merge. 
	 */
	private final @NonNull Map<String, PrimitiveTypeServer> primitiveType2server = new HashMap<String, PrimitiveTypeServer>();
	
	/**
	 * Lazily computed, eagerly invalidated analysis of final classes and operations.
	 */
	private @Nullable FinalAnalysis finalAnalysis = null;
	
	protected PackageManager(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

	void addPackage(@NonNull PackageServerParent parentPackageServer, @NonNull DomainPackage pivotPackage) {
		PackageServer packageServer = null;
		String name = pivotPackage.getName();
		String nsURI = pivotPackage.getNsURI();
		if (nsURI != null) {										// Explicit nsURI for explicit package (merge)
			packageServer = uri2package.get(nsURI);
		}
		else if (name != null) {										// Null nsURI can merge into same named package
			packageServer = getMemberPackage(name);
		}
		if (packageServer == null) {
			packageServer = parentPackageServer.getMemberPackageServer(pivotPackage);
			packageServer.assertSamePackage(pivotPackage);
		}
		packageServer.addTrackedPackage(pivotPackage);
		for (DomainPackage nestedPackage : pivotPackage.getNestedPackage()) {
			if (nestedPackage != null) {
				addPackage(packageServer, nestedPackage);
			}
		}
	}

	/**
	 * The OCL Standard Library is normally registered under it's own nsURI and the OCL Pivot MetaModel is changed to share
	 * the same URI. This routine allows the original OCL Pivot MetaModel nsURI to reference the merged packes too.
	 */

	public void addPackageNsURISynonym(@NonNull String newURI, @NonNull String oldURI) {
		String sharedURI = synonymURI2sharedURI.get(newURI);
		if (oldURI.equals(sharedURI)) {
			return;
		}
		if (sharedURI != null) {
			throw new IllegalMetamodelException(oldURI, sharedURI);	// FIXME Better name
		}
		if (sharedURI2synonymURIs.containsKey(newURI)) {
			throw new IllegalMetamodelException(newURI, sharedURI);	// FIXME Better name
		}
		synonymURI2sharedURI.put(newURI, oldURI);
		Set<String> synonymURIs = sharedURI2synonymURIs.get(oldURI);
		if (synonymURIs == null) {
			synonymURIs = new HashSet<String>();
			sharedURI2synonymURIs.put(oldURI, synonymURIs);
		}
		synonymURIs.add(newURI);
	}

	void addPackageServer(@NonNull PackageServer packageServer) {
		String nsURI = packageServer.getNsURI();
		PackageServer oldPackageServer = uri2package.put(nsURI, packageServer);
		if (packageServer instanceof RootPackageServer) {
			String sharedNsURI = getSharedURI(nsURI);
			if ((sharedNsURI != null) && (sharedNsURI == nsURI)) {
				packageServers.put(nsURI, (RootPackageServer) packageServer);
			}
		}
		assert oldPackageServer == null;
	}

	void addPackageTracker(@NonNull DomainPackage pivotPackage, @NonNull PackageTracker packageTracker) {
		packageTracker.getPackageServer().assertSamePackage(pivotPackage);
		PackageTracker oldTracker = package2tracker.put(pivotPackage, packageTracker);
		assert oldTracker == null;
	}
	
	public synchronized void addRoot(@NonNull Root pivotRoot) {
		for (org.eclipse.ocl.examples.pivot.Package asPackage : pivotRoot.getNestedPackage()) {
			String nsURI = asPackage.getNsURI();
			String sharedURI = getSharedURI(nsURI);
			if (sharedURI == nsURI) {
				PackageId packageId = asPackage.getPackageId();
				if (packageId == IdManager.METAMODEL) {
					if (nsURI != null) {
						addPackageNsURISynonym(nsURI, DomainConstants.METAMODEL_NAME);
					}
				}
			}
		}
		rootTrackers.add(new RootTracker(this, pivotRoot));
		for (DomainPackage pivotPackage : pivotRoot.getNestedPackage()) {
			if (pivotPackage != null) {
				addPackage(this, pivotPackage);
			}
		}
	}

	void addTypeTracker(@NonNull DomainType pivotType, @NonNull TypeTracker typeTracker) {
		TypeTracker oldTracker = type2tracker.put(pivotType, typeTracker);
		assert oldTracker == null;
	}

	public void addedMemberPackage(@NonNull DomainPackage pivotPackage) {
		PackageServer packageServer = getMemberPackageServer(pivotPackage);
		packageServer.addTrackedPackage(pivotPackage);
	}

	void addedNestedPrimaryPackage(@NonNull DomainPackage pivotPackage) {
		String nsURI = PivotUtil.getNsURI(pivotPackage);
		DomainPackage primaryPackage = null;
		if (nsURI != null) {
			primaryPackage = getPackageByURI(nsURI);
		}
		if (primaryPackage == pivotPackage) {
			// Recursive call
		}
		else if (primaryPackage != null) {
			throw new IllegalArgumentException("Duplicate nsURI '" + nsURI + "'");
		}
		else {
			getPackageTracker(pivotPackage);
		}
	}

	protected @NonNull RootPackageServer createRootPackageServer(@NonNull DomainPackage pivotPackage) {
		String name = pivotPackage.getName();
//		if (name == null) {
//			throw new IllegalStateException("Unnamed package");
//		}
		String nonNullName = name;
		if (nonNullName == null) {
			nonNullName = "$anon_" + Integer.toHexString(System.identityHashCode(pivotPackage));
		}
		String nsPrefix = pivotPackage.getNsPrefix();
		String nsURI = getSharedURI(pivotPackage.getNsURI());
		PackageId packageId = pivotPackage.getPackageId();
		RootPackageServer rootPackageServer;
		if (Orphanage.isTypeOrphanage(pivotPackage)) {
			rootPackageServer = new OrphanPackageServer(this, nonNullName, nsPrefix, nsURI, packageId);
		}
		else {
			PackageId metapackageId = metaModelManager.getMetapackageId(pivotPackage);
			rootPackageServer = new RootPackageServer(this, nonNullName, nsPrefix, nsURI, packageId, metapackageId);
		}
		if (name != null) {
			if (!packageServers.containsKey(name)) {
				PackageServer oldPackageServer = packageServers.put(name, rootPackageServer);		// New name
				assert oldPackageServer == null;
			}
			else {
				packageServers.put(name, null);														// Ambiguous name
			}
		}
		if (nsURI != null) {
			addPackageServer(rootPackageServer);
		}
		return rootPackageServer;
	}

	public synchronized void dispose() {
		if (!rootTrackers.isEmpty()) {
			Collection<RootTracker> savedRootTrackers = new ArrayList<RootTracker>(rootTrackers);
			rootTrackers.clear();
			for (RootTracker rootTracker : savedRootTrackers) {
				rootTracker.dispose();
			}
		}
		if (!package2tracker.isEmpty()) {
			Collection<PackageTracker> savedPackageTrackers = new ArrayList<PackageTracker>(package2tracker.values());
			package2tracker.clear();
			for (PackageTracker packageTracker : savedPackageTrackers) {
				packageTracker.dispose();
			}
		}
		if (!type2tracker.isEmpty()) {
			Collection<TypeTracker> savedTypeTrackers = new ArrayList<TypeTracker>(type2tracker.values());
			type2tracker.clear();
			for (TypeTracker typeTracker : savedTypeTrackers) {
				typeTracker.dispose();
			}
		}
		uri2package.clear();
		Collection<RootPackageServer> savedPackageServers = new ArrayList<RootPackageServer>(packageServers.values());
		packageServers.clear();
		for (RootPackageServer packageServer : savedPackageServers) {
			packageServer.dispose();
		}
	}

	public void disposedRootPackageServer(@NonNull RootPackageServer packageServer) {
		packageServers.remove(packageServer.getName());
		disposedPackageServer(packageServer.getNsURI());
	}

	void disposedPackageServer(@Nullable String nsURI) {
		if (nsURI != null) {
			uri2package.remove(nsURI);
			Set<String> synonymURIs = sharedURI2synonymURIs.remove(nsURI);
			if (synonymURIs != null) {
				for (String synonymURI : synonymURIs) {
					synonymURI2sharedURI.remove(synonymURI);
				}
			}
		}
	}

	void disposedPackageTracker(@NonNull PackageTracker packageTracker) {
		if (!package2tracker.isEmpty()) {						// Empty if disposing
			package2tracker.remove(packageTracker.getPackage());
		}
	}

	void disposedRootTracker(@NonNull RootTracker rootTracker) {
		rootTrackers.remove(rootTracker);
	}

	void disposedTypeTracker(@NonNull TypeTracker typeTracker) {
		type2tracker.remove(typeTracker.getTarget());
	}

	@Nullable PackageTracker findPackageTracker(@NonNull DomainPackage pivotPackage) {
		return package2tracker.get(pivotPackage);
	}
	
	public @Nullable ExtensibleTypeServer findTypeServer(@NonNull DomainType pivotType) {
		TypeTracker typeTracker = type2tracker.get(pivotType);
		return typeTracker != null ? typeTracker.getTypeServer() : null;
	}
	
	@SuppressWarnings("unused")
	private final @Nullable TypeTracker findTypeTracker(@NonNull DomainType pivotType) {		
		throw new UnsupportedOperationException("Not implemented since specializations have a TypeServer but no TypeTracker");
		//return type2tracker.get(pivotType);
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<PackageServer> getAllPackages() {
		return uri2package.values();
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<PackageServer> getAllPackagesWithUris() {
		return uri2package.values();
	}
	
	public @NonNull FinalAnalysis getFinalAnalysis() {
		FinalAnalysis finalAnalysis2 = finalAnalysis;
		if (finalAnalysis2 == null) {
			finalAnalysis = finalAnalysis2 = new FinalAnalysis(this);
		}
		return finalAnalysis2;
	}

	public @Nullable RootPackageServer getMemberPackage(@NonNull String memberPackageName) {
		return packageServers.get(memberPackageName);
	}
	public @NonNull RootPackageServer getMemberPackageServer(@NonNull DomainPackage pivotPackage) {
		//
		//	Try to find package by nsURI
		//
		String nsURI = pivotPackage.getNsURI();
		if (nsURI != null) {
			String sharedURI = getSharedURI(nsURI);
			PackageServer packageServer = uri2package.get(sharedURI);
			if (packageServer != null) {
				return (RootPackageServer) packageServer;
			}
		}
		//
		//	Else generate an error for a name-less Package, fatally if also nsURI-less.
		//
		String name = pivotPackage.getName();
		if (name == null) {
			String message = null;
			if (pivotPackage instanceof EObject) {
				for (EObject eObject = (EObject) pivotPackage; eObject != null; eObject = eObject.eContainer()) {
					if (eObject instanceof Root) {
						message = "Unnamed package for '" + nsURI + "' in '" + ((Root)eObject).getExternalURI() + "'";
						break;
					}
				}
			}
			if (message == null) {
				message = "Unnamed package for '" + nsURI + "'";
			}
			logger.error(message);
			name = nsURI;
			if (name == null) {
				throw new IllegalStateException(message);
			}
		}
		//
		//	Try to find package by name, provided there is no nsURI conflict
		//
		RootPackageServer rootPackageServer = packageServers.get(name);
		if (rootPackageServer != null) {
			String nsURI2 = rootPackageServer.getNsURI();
			if ((nsURI == null) || (nsURI2 == null) || nsURI.equals(nsURI2)) {
				return rootPackageServer;
			}
		}
		rootPackageServer = createRootPackageServer(pivotPackage);
		return rootPackageServer;
	}

	public @NonNull Iterable<RootPackageServer> getMemberPackages() {
		@SuppressWarnings("null")
		@NonNull Collection<RootPackageServer> values = packageServers.values();
		return values;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public @Nullable PackageServer getPackageByURI(@NonNull String nsURI) {
		int lastIndex = nsURI.lastIndexOf("#/");
		if (lastIndex > 0) {
			@SuppressWarnings("null") @NonNull String substring = nsURI.substring(0, lastIndex);
			nsURI = substring;
		}
		String sharedURI = getSharedURI(nsURI);
		return uri2package.get(sharedURI);
	}

	public @NonNull PackageServer getPackageServer(@NonNull DomainPackage pivotPackage) {
		PackageServer packageServer = null;
		if (pivotPackage instanceof PackageServer) {
			((PackageServer)pivotPackage).assertSamePackage(pivotPackage);
			packageServer = (PackageServer)pivotPackage;
		}
		else {
			String nsURI = pivotPackage.getNsURI();
			if (nsURI != null) {
				String sharedURI = getSharedURI(nsURI);
				packageServer = uri2package.get(sharedURI);
			}
			if (packageServer == null) {
				PackageServerParent packageServerParent;
				DomainPackage pivotPackageParent = pivotPackage.getNestingPackage();
				if (pivotPackageParent == null) {
					packageServerParent = this;
				}
				else {
					PackageTracker parentTracker = getPackageTracker(pivotPackageParent);
					packageServerParent = parentTracker.getPackageServer();
					((PackageServer)packageServerParent).assertSamePackage(pivotPackageParent);
				}
				packageServer = packageServerParent.getMemberPackageServer(pivotPackage);
				packageServer.addTrackedPackage(pivotPackage);
				packageServer.assertSamePackage(pivotPackage);
			}
		}
		packageServer.assertSamePackage(pivotPackage);
		return packageServer;
	}

	public @NonNull PackageTracker getPackageTracker(@NonNull DomainPackage pivotPackage) {	// FIXME Review wrt getMemberPackageServer()
		PackageTracker packageTracker = package2tracker.get(pivotPackage);
		if (packageTracker == null) {
			DomainPackage nestingPackage = pivotPackage.getNestingPackage();
			PackageServer packageServer;
			if (nestingPackage != null) {
				PackageServer nestingPackageServer = getPackageServer(nestingPackage);
				packageServer = nestingPackageServer.getMemberPackageServer(pivotPackage);
			}
			else {
				String sharedURI = getSharedURI(pivotPackage.getNsURI());
				packageServer = uri2package.get(sharedURI);
				if (packageServer == null) {
					packageServer = createRootPackageServer(pivotPackage);
				}
			}
			packageServer.assertSamePackage(pivotPackage);
			packageTracker = packageServer.getPackageTracker(pivotPackage);
		}
		else {
			packageTracker.getPackageServer().assertSamePackage(pivotPackage);
		}
		return packageTracker;
	}

/*	public synchronized Iterable<DomainPackage> getPartialPackages(DomainPackage pkg) {
		PackageTracker packageTracker = findPackageTracker(pkg);
		Set<DomainPackage> allPackages = new HashSet<DomainPackage>();
		if (packageTracker != null) {
			for (DomainPackage aPackage : packageTracker.getPackageServer().getTrackedPackages()) {
				allPackages.add(aPackage);
			}
		}
		else {
			allPackages.add(pkg);
		}
		getAllPartialPackages(allPackages, allPackages);		// FIXME Inconsistent name/functionality
		return allPackages;
	} */

/*	private void getAllPartialPackages(Set<DomainPackage> knownPackages, Set<DomainPackage> newPackages) {
		Set<DomainPackage> morePackages = null;
		for (DomainPackage newPackage : newPackages) {
			for (DomainPackage importedPackage : newPackage.getImportedPackage()) {
				if (morePackages == null) {
					morePackages = new HashSet<DomainPackage>();
				}
				PackageTracker packageTracker = findPackageTracker(importedPackage);
				if (packageTracker != null) {
					for (DomainPackage aPackage : packageTracker.getPackageServer().getTrackedPackages()) {
						morePackages.add(aPackage);
					}
				}
				else {
					morePackages.add(importedPackage);
				}
			}
		}
		if (morePackages != null) {
			morePackages.removeAll(knownPackages);
			if (morePackages.size() > 0) {
				knownPackages.addAll(morePackages);
				getAllPartialPackages(knownPackages, morePackages);
			}
		}
	} */

	public @NonNull PrimitiveTypeServer getPrimitiveTypeServer(@NonNull PrimitiveType primitiveType) {
		String name = primitiveType.getName();
		PrimitiveTypeServer primitiveTypeServer = primitiveType2server.get(name);
		if (primitiveTypeServer == null) {
			org.eclipse.ocl.examples.pivot.Package primitivePackage = primitiveType.getPackage();
			if (!(primitivePackage instanceof Library)) {
				AnyType oclAnyType = metaModelManager.getOclAnyType();
				primitivePackage = DomainUtil.nonNullState(oclAnyType.getPackage());
			}
			PackageServer packageServer = getPackageServer(primitivePackage);
			primitiveTypeServer = new PrimitiveTypeServer(packageServer, primitiveType);
			primitiveType2server.put(name, primitiveTypeServer);
		}
		return primitiveTypeServer;
	}

//	@SuppressWarnings("null")
//	public @NonNull Iterable<Root> getRoots() {
//		return Iterables.transform(rootTrackers, RootTracker.tracker2root);
//	}

	public @Nullable org.eclipse.ocl.examples.pivot.Package getRootPackage(@NonNull String name) {
		PackageServer packageServer = packageServers.get(name);
//		if (packageServer == null) {
//			packageServer = uri2package.get(name);		// FIXME avoid double lookup
//		}
		return packageServer != null ? packageServer.getPivotPackage() : null;
	}

	/**
	 * @since 3.5
	 */
	public @Nullable String getSharedURI(@Nullable String nsURI) {
		String sharedURI = synonymURI2sharedURI.get(nsURI);
		if (sharedURI != null) {
			return sharedURI;
		}
		else {
			return nsURI;
		}
	}
	
	public @NonNull TypeServer getTypeServer(@NonNull DomainType pivotType) {
		if (pivotType instanceof ElementExtension) {
			Stereotype stereotype = ((ElementExtension)pivotType).getStereotype();
			if (stereotype != null) {
				pivotType = stereotype;
			}
		}
		if (pivotType instanceof TypeServer) {
			return (TypeServer)pivotType;
		}
		assert metaModelManager.isTypeServeable(pivotType);
		TypeTracker typeTracker = type2tracker.get(pivotType);
		if (typeTracker != null) {
			return typeTracker.getTypeServer();
		}
		else if (pivotType instanceof PrimitiveType) {
			PrimitiveTypeServer primitiveTypeServer = getPrimitiveTypeServer((PrimitiveType) pivotType);
			primitiveTypeServer.getTypeTracker(pivotType);
			return primitiveTypeServer;
		}
		else {
			DomainPackage pivotPackage = pivotType.getPackage();
			if (pivotPackage == null) {
				throw new IllegalStateException("type has no package");
			}
			PackageServer packageServer = getPackageServer(pivotPackage);
			return packageServer.getTypeServer(pivotType);
		}
	}

//	public void installAs(@NonNull String nsURI, @NonNull EcoreExecutorPackage tablesPackage) {
//		PackageServer packageServer = uri2package.get(nsURI);
//		if (packageServer != null) {
//			packageServer.addTrackedPackage(tablesPackage);
//			for (DomainPackage nestedPackage : tablesPackage.getNestedPackage()) {
//				if (nestedPackage != null) {
//					addPackage(packageServer, nestedPackage);
//				}
//			}
//		}
//	}
	
	public synchronized void removeRoot(@NonNull Root pivotRoot) {
		for (RootTracker rootTracker : rootTrackers) {
			if (rootTracker.getTarget() == pivotRoot) {
				pivotRoot.getNestedPackage().clear();
				rootTracker.dispose();
				break;
			}
		}
	}

	void removedPackage(@NonNull DomainPackage pivotPackage) {
		PackageTracker packageTracker = package2tracker.get(pivotPackage);
		if (packageTracker != null) {
			packageTracker.dispose();
		}
	}

	void removedType(@NonNull DomainType pivotType) {
		TypeTracker typeTracker = type2tracker.get(pivotType);
		if (typeTracker != null) {
			typeTracker.dispose();
		}
	}

	void resolveSuperClasses(@NonNull Type specializedClass, @NonNull Type unspecializedClass, Map<TemplateParameter, ParameterableElement> allBindings) {
		for (Type superType : unspecializedClass.getSuperClass()) {
			List<TemplateBinding> superTemplateBindings = superType.getTemplateBinding();
			if (superTemplateBindings.size() > 0) {
				List<ParameterableElement> superTemplateArgumentList = new ArrayList<ParameterableElement>();
				for (TemplateBinding superTemplateBinding : superTemplateBindings) {
					for (TemplateParameterSubstitution superParameterSubstitution : superTemplateBinding.getParameterSubstitution()) {
						ParameterableElement superActual = superParameterSubstitution.getActual();
						TemplateParameter superTemplateParameter = superActual.getTemplateParameter();
						ParameterableElement actualActual = allBindings.get(superTemplateParameter);
						superTemplateArgumentList.add(actualActual);
					}
				}
				@NonNull Type unspecializedSuperType = PivotUtil.getUnspecializedTemplateableElement(superType);
				TypeServer superTypeServer = metaModelManager.getTypeServer(unspecializedSuperType);
				if ((superTypeServer instanceof CollectionTypeServer) && (superTemplateArgumentList.size() == 1)) {
					ParameterableElement templateArgument = superTemplateArgumentList.get(0);
					if (templateArgument instanceof Type) {
						Type specializedSuperType = ((CollectionTypeServer)superTypeServer).getSpecializedType((Type)templateArgument, null, null);
						specializedClass.getSuperClass().add(specializedSuperType);
					}
				}
				else if ((superTypeServer instanceof MetaclassServer) && (superTemplateArgumentList.size() == 1)) {
					ParameterableElement templateArgument = superTemplateArgumentList.get(0);
					if (templateArgument instanceof Type) {
						Type superMetaclass = ((MetaclassServer)superTypeServer).getMetaclass((Type)templateArgument);
						specializedClass.getSuperClass().add(superMetaclass);
					}
				}
				else if (superTypeServer instanceof TemplateableTypeServer) {
					Type specializedSuperType = ((TemplateableTypeServer)superTypeServer).getSpecializedType(superTemplateArgumentList);
					specializedClass.getSuperClass().add(specializedSuperType);
				}
			}
			else {
				specializedClass.getSuperClass().add(superType);
			}
		}
	}
}
