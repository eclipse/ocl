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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl;

/**
 * PackageManager encapsulates the knowledge about known packages and their nsURIs.
 */
public class PackageManager //implements PackageServerParent
{
	/**
	 * The MetaModelManager for which this PackageManager manages the packages.
	 */
	protected final @NonNull MetaModelManager metaModelManager;

	/**
	 * Map from each merged package to the PackageTracker that supervises its merge. PackageTrackers are only
	 * created for merged packages, so a missing entry just denotes an unmerged package. 
	 */
//	private final @NonNull Map<DomainPackage, PackageTracker> package2tracker = new HashMap<DomainPackage, PackageTracker>();
	
	/**
	 * Lazily computed, eagerly invalidated analysis of final classes and operations.
	 */
	private @Nullable FinalAnalysis finalAnalysis = null;
	
	/**
	 * The known packages.
	 */
	@SuppressWarnings("null")
	private final @NonNull CompleteModelImpl completeModel = (CompleteModelImpl) PivotFactory.eINSTANCE.createCompleteModel();
	
	protected PackageManager(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
		completeModel.initPackageManager(this);
	}

/*	void addPackageTracker(@NonNull DomainPackage pivotPackage, @NonNull PackageTracker packageTracker) {
		packageTracker.getPackageServer().assertSamePackage(pivotPackage);
		PackageTracker oldTracker = package2tracker.put(pivotPackage, packageTracker);
		assert oldTracker == null;
	} */

/*	public void addedMemberPackage(@NonNull DomainPackage pivotPackage) {
		CompletePackage completePackage = getMemberPackageServer(pivotPackage);
		completePackage.addTrackedPackage(pivotPackage);
	} */

/*	void disposedPackageTracker(@NonNull PackageTracker packageTracker) {
		if (!package2tracker.isEmpty()) {						// Empty if disposing
			package2tracker.remove(packageTracker.getPackage());
		}
	} */

/*	@Nullable PackageTracker findPackageTracker(@NonNull DomainPackage pivotPackage) {
		return package2tracker.get(pivotPackage);
	} */
	
	@SuppressWarnings("unused")
	private final @Nullable TypeTracker findTypeTracker(@NonNull DomainType pivotType) {		
		throw new UnsupportedOperationException("Not implemented since specializations have a TypeServer but no TypeTracker");
		//return type2tracker.get(pivotType);
	}

	public @NonNull CompleteModelImpl getCompleteModel() {
		return completeModel;
	}
	
	public @NonNull FinalAnalysis getFinalAnalysis() {
		FinalAnalysis finalAnalysis2 = finalAnalysis;
		if (finalAnalysis2 == null) {
			finalAnalysis = finalAnalysis2 = new FinalAnalysis(this);
		}
		return finalAnalysis2;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

/*	public @NonNull PackageTracker getPackageTracker(@NonNull DomainPackage pivotPackage) {	// FIXME Review wrt getMemberPackageServer()
		PackageTracker packageTracker = package2tracker.get(pivotPackage);
		if (packageTracker == null) {
			DomainPackage nestingPackage = pivotPackage.getOwningPackage();
			CompletePackage completePackage;
			if (nestingPackage != null) {
				CompletePackage nestingCompletePackage = getPackageServer(nestingPackage);
				completePackage = nestingCompletePackage.getMemberPackageServer(pivotPackage);
			}
			else {
				String sharedURI = getSharedURI(pivotPackage.getURI());
				completePackage = uri2package.get(sharedURI);
				if (completePackage == null) {
					completePackage = createRootCompletePackage(pivotPackage);
				}
			}
			completePackage.assertSamePackage(pivotPackage);
			packageTracker = completePackage.getPackageTracker(pivotPackage);
		}
		else {
			packageTracker.getPackageServer().assertSamePackage(pivotPackage);
		}
		return packageTracker;
	} */

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

//	@SuppressWarnings("null")
//	public @NonNull Iterable<Root> getRoots() {
//		return Iterables.transform(rootTrackers, RootTracker.tracker2root);
//	}

//	public void installAs(@NonNull String nsURI, @NonNull EcoreExecutorPackage tablesPackage) {
//		CompletePackage completePackage = uri2package.get(nsURI);
//		if (completePackage != null) {
//			completePackage.addTrackedPackage(tablesPackage);
//			for (DomainPackage nestedPackage : tablesPackage.getNestedPackage()) {
//				if (nestedPackage != null) {
//					addPackage(completePackage, nestedPackage);
//				}
//			}
//		}
//	}

/*	void removedPackage(@NonNull DomainPackage pivotPackage) {
		PackageTracker packageTracker = package2tracker.get(pivotPackage);
		if (packageTracker != null) {
			packageTracker.dispose();
		}
	} */
}
