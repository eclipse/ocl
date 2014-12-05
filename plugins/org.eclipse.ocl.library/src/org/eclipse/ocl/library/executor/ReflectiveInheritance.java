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
package org.eclipse.ocl.library.executor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainCollectionType;
import org.eclipse.ocl.domain.elements.DomainFragment;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.types.AbstractFragment;
import org.eclipse.ocl.domain.types.AbstractInheritance;
import org.eclipse.ocl.domain.utilities.DomainUtil;

/**
 * A ReflectiveType defines a Type using a compact representation suitable for efficient
 * execution. The representation is derived reflectively from a less efficient representation.
 */
public abstract class ReflectiveInheritance extends AbstractInheritance
{	
	protected static int computeFlags(@NonNull DomainClass domainClass) {
		int flags = 0;
		if (domainClass instanceof DomainCollectionType) {
			DomainCollectionType collectionType = (DomainCollectionType)domainClass;
			if (collectionType.isOrdered()) {
				flags |= ORDERED;
			}
			if (collectionType.isUnique()) {
				flags |= UNIQUE;
			}
		}
		TypeId typeId = domainClass.getTypeId();
		if (typeId == TypeId.OCL_ANY){
			flags |= OCL_ANY;
		}
		else if (typeId == TypeId.OCL_VOID){
			flags |= OCL_VOID;
		}
		else if (typeId == TypeId.OCL_INVALID){
			flags |= OCL_INVALID;
		}
		return flags;
	}
	
	/**
	 * Depth ordered inheritance fragments. OclAny at depth 0, OclSelf at depth size-1.
	 */
	private DomainFragment[] fragments = null;
	
	/**
	 * The index in fragments at which inheritance fragments at a given depth start.
	 * depthIndexes[0] is always zero since OclAny is always at depth 0.
	 * depthIndexes[depthIndexes.length-2] is always depthIndexes.length-1 since OclSelf is always at depth depthIndexes.length-2.
	 * depthIndexes[depthIndexes.length-1] is always depthIndexes.length to provide an easy end stop.
	 */
	private int[] indexes = null;
	
	/**
	 * The Inheritances of sub-types that have been installed, and which must be
	 * uninstalled in the event of an inheritance change for this Inheritance.
	 */
	private Set<ReflectiveInheritance> knownSubInheritances = null;

	public ReflectiveInheritance(@NonNull String name, int flags, ExecutorTypeParameter... typeParameters) {
		super(name, flags);
	}

	public void addSubInheritance(@NonNull ReflectiveInheritance subInheritance) {
		if (knownSubInheritances == null) {
			knownSubInheritances = new HashSet<ReflectiveInheritance>();
		}
		knownSubInheritances.add(subInheritance);
	}

	protected abstract AbstractFragment createFragment(@NonNull DomainInheritance baseInheritance);

	public @NonNull Object createInstance() {
		throw new UnsupportedOperationException();
	}

	public @Nullable Object createInstance( @NonNull String value) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Add this Inheritance and all un-installed super-Inheritances to inheritances, returning true if this
	 * inheritance was already installed.
	 */
	public boolean gatherUninstalledInheritances(@NonNull List<ReflectiveInheritance> inheritances) {
		boolean gotOne = false;
		if (!inheritances.contains(this)) {
			inheritances.add(this);
			if (fragments == null) {
				for (DomainInheritance superInheritance : getInitialSuperInheritances()) {
					if (superInheritance instanceof ReflectiveInheritance) {
						if (((ReflectiveInheritance)superInheritance).gatherUninstalledInheritances(inheritances)) {
							gotOne = true;		// Transitively installed
						}
					}
					else {
						gotOne = true;			// Statically installed
					}
				}
			}
			else {
				gotOne = true;					// Locally installed
			}
		}
		return gotOne;
	}
	
	@Override
	public final @NonNull FragmentIterable getAllProperSuperFragments() {
		if (fragments == null) {
			initialize();
		}
		DomainFragment[] fragments2 = DomainUtil.nonNullState(fragments);
		return new FragmentIterable(fragments2, 0, fragments2.length-1);
	}

	@Override
	public final @NonNull FragmentIterable getAllSuperFragments() {
		if (fragments == null) {
			initialize();
		}
		return new FragmentIterable(DomainUtil.nonNullState(fragments));
	}

	@Override
	public final int getDepth() {
		if (indexes == null) {
			initialize();
		}
		return indexes.length-2;
	}

	@Override
	public DomainFragment getFragment(int fragmentNumber) {
		if ((fragments == null) && isOclAny()) {
			installOclAny();
		}
		return fragments[fragmentNumber];
	}
	
	@Override
	public @NonNull Iterable<DomainFragment> getFragments() {
		DomainFragment[] fragments2 = fragments;
		if (fragments2 == null) {
			initialize();
			fragments2 = fragments;
			assert fragments2 != null;
		}
		return new FragmentIterable(fragments2);
	}

	@Override
	public int getIndex(int fragmentNumber) {
		return indexes[fragmentNumber];
	}

	@Override
	public int getIndexes(){
		return indexes.length;
	}

	/**
	 * Return the immediate superinheritances without reference to the fragments.
	 */
	protected abstract @NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances();

	@Override
	public @NonNull DomainFragment getSelfFragment() {
		if (indexes == null) {
			initialize();
		}
		DomainFragment fragment = getFragment(fragments.length-1);
		if (fragment == null) {
			throw new IllegalStateException("No self fragment"); //$NON-NLS-1$
		}
		return fragment;
	}
	
	@Override
	public final @NonNull FragmentIterable getSuperFragments(int depth) {
		return new FragmentIterable(DomainUtil.nonNullState(fragments), indexes[depth], indexes[depth+1]);
	}

	protected synchronized void initialize() {
		List<ReflectiveInheritance> uninstalledInheritances = new ArrayList<ReflectiveInheritance>();
		// Detect missing OclAny inheritance
		// - any installed superclass must inherit from OclAny so ok.
		// - an all-uninstalled superclass list must include OclAny to be ok.
		if (!gatherUninstalledInheritances(uninstalledInheritances)) {
//			boolean containsOclAny = false;
//			for (DomainInheritance anInheritance : uninstalledInheritances) {
//				if (anInheritance.isOclAny()) {
//					containsOclAny = true;
//					break;
//				}
//			}
//			if (!containsOclAny)  {	// FIXME may be an rather than the OclAny - need a way to find the partial types.
/*				List<ReflectiveType> uninstalledInheritances2 = new ArrayList<ReflectiveType>();
				gatherUninstalledInheritances(uninstalledInheritances2);
				assert uninstalledInheritances.contains(oclAnyInheritance); */
//			} 
		}
//		int oldPendingCount = uninstalledInheritances.size();
		@SuppressWarnings("unused") List<ReflectiveInheritance> debugOldUninstalledInheritances = new ArrayList<ReflectiveInheritance>(uninstalledInheritances);
		while (true) {
			Boolean gotOne = false;
			for (ListIterator<ReflectiveInheritance> it = uninstalledInheritances.listIterator(); it.hasNext(); ) {
				ReflectiveInheritance uninstalledInheritance = it.next();
				if (uninstalledInheritance.isInstallable()) {
					uninstalledInheritance.install();
					it.remove();
					gotOne = true;
				}
			}
			if (uninstalledInheritances.isEmpty()) {
				break;
			}
//			int newPendingCount = uninstalledInheritances.size();
			if (!gotOne) {
				List<ReflectiveInheritance> debugNewUninstalledInheritances = new ArrayList<ReflectiveInheritance>();
				gatherUninstalledInheritances(debugNewUninstalledInheritances);
				StringBuilder s = new StringBuilder();
				s.append("Inheritance loop for "); //$NON-NLS-1$
				for (ListIterator<ReflectiveInheritance> it = uninstalledInheritances.listIterator(); it.hasNext(); ) {
					ReflectiveInheritance uninstalledInheritance = it.next();
					if (!uninstalledInheritance.isInstallable()) {
						s.append("\n  "); //$NON-NLS-1$
						s.append(uninstalledInheritance);
					}
				}
				throw new IllegalStateException(s.toString());
			}
//			oldPendingCount = newPendingCount;
		}
	}

	/**
	 * Install this Inheritance establishing its superClass tables and registering
	 * it to be notified of any changes.
	 * 
	 * @return true if installed, false if some superClass uninstallable
	 */
	public boolean install() {
		if (fragments != null) {
			return true;
		}
//		System.out.println("Install " + this);
		if (isOclAny()) {
			installOclAny();
		}
		else {
			List<List<DomainInheritance>> all = new ArrayList<List<DomainInheritance>>();
			for (DomainInheritance superInheritance : getInitialSuperInheritances()) {
//				installIn(superInheritance, this, all);
				int j = 0;
				for (int i = 0; i < superInheritance.getIndexes()-1; i++) {
					List<DomainInheritance> some = (i < all.size()) ? all.get(i) : null;
					if (some == null) {
						some = new ArrayList<DomainInheritance>();
						all.add(some);
					}
					int jMax = superInheritance.getIndex(i+1);
					for (; j < jMax; j++) {
						DomainFragment fragment = superInheritance.getFragment(j);
						DomainInheritance baseInheritance = fragment.getBaseInheritance();
						if (!some.contains(baseInheritance)) {
							some.add(baseInheritance);
							if (baseInheritance instanceof ReflectiveInheritance) {
								((ReflectiveInheritance)baseInheritance).addSubInheritance(this);
							}
						}
					}
				}
			}
			int superDepths = all.size();
			int superInheritances = 0;
			for (List<DomainInheritance> some : all) {
				superInheritances += some.size();
			}
			assert superDepths > 0;
			fragments = new DomainFragment[superInheritances+1];	// +1 for OclSelf
			indexes = new int[superDepths+2];		// +1 for OclSelf, +1 for tail pointer
			int j = 0;
			indexes[0] = 0;
			for (int i = 0; i < superDepths; i++) {
				for (DomainInheritance some : all.get(i)) {
					if (some != null) {
						fragments[j++] = createFragment(some);
					}
				}
				indexes[i+1] = j;
			}
			indexes[superDepths++] = j;
			fragments[j++] = createFragment(this);
			indexes[superDepths++] = j;
		}
		return true;
	}

	/**
	 * Install the root OclAny Inheritance.
	 */
	protected final void installOclAny() {
		assert fragments == null;
		fragments = new DomainFragment[] { createFragment(this) };
		indexes = new int[] { 0, 1 };
	}
	
	/**
	 * Return true if this is installed or able to be installed. Returns false if some superclass
	 * must be installed first.
	 */
	public boolean isInstallable() {
		if (isOclAny()) {
			return true;
		}
		if (fragments != null) {
//			System.out.println("isInstallable true (already) " + this);
			return true;
		}
//		DomainInheritance oclAnyInheritance = getOclAnyInheritance();
		for (DomainInheritance superInheritance : getInitialSuperInheritances()) {
			if ((superInheritance instanceof ReflectiveInheritance) && !((ReflectiveInheritance)superInheritance).isInstalled()) {
//				System.out.println("isInstallable false " + this);
				return false;
			}
		}
//		System.out.println("isInstallable true " + this);
		return true;
	}

	/**
	 * Return true if this is installed.
	 */
	public boolean isInstalled() {
		return fragments != null;
	}

	public void removeSubInheritance(@NonNull ReflectiveInheritance subInheritance) {
		if (knownSubInheritances != null) {
			knownSubInheritances.remove(subInheritance);
		}
	}

	public void uninstall() {
		if (fragments != null) {
//			System.out.println("Uninstall " + this);
			for (DomainFragment fragment : fragments) {
				DomainInheritance baseInheritance = fragment.getBaseInheritance();
				if (baseInheritance instanceof ReflectiveInheritance) {
					((ReflectiveInheritance)baseInheritance).removeSubInheritance(this);
				}
			}
			fragments = null;
			indexes = null;
			if (knownSubInheritances != null) {
				Set<ReflectiveInheritance> previouslyKnownSubInheritances = knownSubInheritances;
				knownSubInheritances = null;
				for (ReflectiveInheritance subInheritance : previouslyKnownSubInheritances) {
					subInheritance.uninstall();
				}
			}
		}
	}
}
