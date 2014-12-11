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
package org.eclipse.ocl.library.ecore;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.ExternalCrossReferencer;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.DomainConstants;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainElement;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainModel;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.domain.elements.DomainTypedElement;
import org.eclipse.ocl.domain.ids.IdManager;
import org.eclipse.ocl.domain.ids.NsURIPackageId;
import org.eclipse.ocl.domain.ids.PackageId;
import org.eclipse.ocl.domain.ids.RootPackageId;
import org.eclipse.ocl.domain.ids.TuplePartId;
import org.eclipse.ocl.domain.ids.TupleTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.library.executor.AbstractIdResolver;
import org.eclipse.ocl.library.executor.ExecutableStandardLibrary;
import org.eclipse.ocl.library.executor.ExecutorPackage;
import org.eclipse.ocl.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.TupleType;

/**
 * EcoreIdResolver provides a package discovery capability so that package identifiers can be resolved.
 * <p>
 * Given an initial seed of a standard library and one or more root EObjects, packages are discovered
 * by locating all packages and nested packages directly contained by the seed roots or by the roots of
 * any object referenced by any contained by the seed roots.
 */
public class EcoreIdResolver extends AbstractIdResolver implements Adapter
{
	protected final @NonNull Collection<? extends EObject> directRoots;
//	protected @NonNull Map<ElementId, DomainElement> id2element = new HashMap<ElementId, DomainElement>();

	/**
	 * Mapping from package URI to corresponding Pivot Package. (used to resolve NsURIPackageId).
	 */
	private Map<String, DomainPackage> nsURI2package = new HashMap<String, DomainPackage>();

	/**
	 * Mapping from root package name to corresponding Pivot Package. (used to resolve RootPackageId).
	 */
	private Map<String, DomainPackage> roots2package = new HashMap<String, DomainPackage>();
	private boolean directRootsProcessed = false;
	private boolean crossReferencedRootsProcessed = false;
	private @NonNull Map<EClassifier, WeakReference<DomainInheritance>> typeMap = new WeakHashMap<EClassifier, WeakReference<DomainInheritance>>();
	
	public EcoreIdResolver(@NonNull Collection<? extends EObject> roots, @NonNull ExecutorStandardLibrary standardLibrary) {
		super(standardLibrary);
		this.directRoots = roots;
	}

	private void addPackage(@NonNull DomainPackage userPackage) {
		String nsURI = userPackage.getURI();
		if (nsURI != null) {
			nsURI2package.put(nsURI, userPackage);
			EPackage ePackage = userPackage.getEPackage();
			if (ePackage != null) {
				if (DomainUtil.basicGetMetamodelAnnotation(ePackage) != null) {
					if (roots2package.get(DomainConstants.METAMODEL_NAME) == null) {
						roots2package.put(DomainConstants.METAMODEL_NAME, userPackage);
					}
				}
			}
			else {
				for (DomainClass asType : userPackage.getOwnedClasses()) {
					if ("Boolean".equals(asType.getName())) {			// FIXME Check PrimitiveType //$NON-NLS-1$
						if (roots2package.get(DomainConstants.METAMODEL_NAME) == null) {
							roots2package.put(DomainConstants.METAMODEL_NAME, userPackage);
						}
						break;
					}
				}
			}
		}
		else {
			String name = userPackage.getName();
			if (name != null) {
				roots2package.put(name, userPackage);
			}
		}
		addPackages(userPackage.getOwnedPackages());
	}

	private void addPackages(/*@NonNull*/ Iterable<? extends DomainPackage> userPackages) {
		for (DomainPackage userPackage : userPackages) {
			assert userPackage != null;
			addPackage(userPackage);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public synchronized @NonNull DomainInheritance getInheritance(@NonNull EClassifier eClassifier) {
		DomainInheritance type = weakGet(typeMap, eClassifier);
		if (type == null) {
			EPackage ePackage = eClassifier.getEPackage();
			assert ePackage != null;
			ExecutorPackage execPackage = ((ExecutorStandardLibrary)standardLibrary).getPackage(ePackage);
			if (execPackage == null) {
				PackageId packageId = IdManager.getPackageId(ePackage);
				DomainElement domainPackage = packageId.accept(this);
				if (domainPackage instanceof ExecutorPackage) {
					execPackage = (ExecutorPackage) domainPackage;
				}
			}
			if (execPackage != null) {
				DomainClass domainType = execPackage.getType(eClassifier.getName());	
				if (domainType != null) {
					type = standardLibrary.getInheritance(domainType);
					typeMap.put(eClassifier, new WeakReference<DomainInheritance>(type));
				}
			}
		}
		return DomainUtil.nonNullState(type);
	}

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public synchronized @NonNull TupleType getTupleType(@NonNull TupleTypeId typeId) {
		return ((ExecutableStandardLibrary)standardLibrary).getTupleType(typeId);
	}
	
	public @NonNull TupleType getTupleType(DomainTypedElement ... parts) {
		int iSize = parts.length;
		List<TuplePartId> partsList = new ArrayList<TuplePartId>(iSize);
		for (int i = 0; i < iSize; i++) {
			DomainTypedElement part = parts[i];
			String partName = DomainUtil.getSafeName(part);
			partsList.add(IdManager.getTuplePartId(i, partName, part.getTypeId()));
		}
		return getTupleType(IdManager.getTupleTypeId(TypeId.TUPLE_NAME, partsList));
	}

	@Override
	public @NonNull DomainClass getType(@NonNull EClassifier eClassifier) {
		return getInheritance(eClassifier).getType();
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return false;
	}

	@Override
	public void notifyChanged(Notification notification) {}			// FIXME ?? invalidate

	protected synchronized void processCrossReferencedRoots() {
		if (crossReferencedRootsProcessed ) {
			return;
		}
		crossReferencedRootsProcessed = true;
		new ExternalCrossReferencer(directRoots)
		{
			private static final long serialVersionUID = 1L;
			
			private Set<EObject> moreRoots = new HashSet<EObject>();

			{ findExternalCrossReferences(); }

			@Override
			protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
				EObject root = EcoreUtil.getRootContainer(crossReferencedEObject);
				if (moreRoots.add(root) && !directRoots.contains(root)) {
					if (root instanceof DomainModel) {
						addPackages(((DomainModel)root).getOwnedPackages());
					}
					else if (root instanceof DomainPackage) {					// Perhaps this is only needed for a lazy JUnit test
						addPackage((DomainPackage)root);
					}
				}
				return false;
			}
		};
	}

	protected synchronized void processDirectRoots() {
		if (directRootsProcessed) {
			return;
		}
		directRootsProcessed = true;
		Set<EPackage> ePackages = new HashSet<EPackage>();
		for (EObject eObject : directRoots) {
			if (eObject instanceof DomainModel) {
				addPackages(((DomainModel)eObject).getOwnedPackages());
			}
//			else if (eObject instanceof DomainPackage) {							// Perhaps this is only needed for a lazy JUnit test
//				addPackage((DomainPackage)eObject);
//			}
			ePackages.add(eObject.eClass().getEPackage());
		}
		for (EPackage ePackage : ePackages) {
			String nsURI = ePackage.getNsURI();
			if (nsURI2package.get(nsURI) == null) {
				PackageId packageId = IdManager.getPackageId(ePackage);
				DomainPackage domainPackage = new EcoreReflectivePackage(ePackage, this, packageId);
				nsURI2package.put(nsURI, domainPackage);
				if (packageId instanceof RootPackageId) {
					roots2package.put(((RootPackageId)packageId).getName(), domainPackage);
				}
			}
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {
//			assert newTarget == resource;
	}

	@Override
	public synchronized @NonNull DomainPackage visitNsURIPackageId(@NonNull NsURIPackageId id) {
		String nsURI = id.getNsURI();
		DomainPackage knownPackage = nsURI2package.get(nsURI);
		if (knownPackage != null) {
			return knownPackage;
		}
		DomainPackage libraryPackage = standardLibrary.getNsURIPackage(nsURI);
		if (libraryPackage != null) {
			nsURI2package.put(nsURI, libraryPackage);
			return libraryPackage;
		}
		if (!directRootsProcessed) {
			processDirectRoots();
			knownPackage = nsURI2package.get(nsURI);
			if (knownPackage != null) {
				return knownPackage;
			}
		}
		if (!crossReferencedRootsProcessed) {
			processCrossReferencedRoots();
			knownPackage = nsURI2package.get(nsURI);
			if (knownPackage != null) {
				return knownPackage;
			}
		}
		EPackage ePackage = id.getEPackage();
		if (ePackage != null) {
			EcoreReflectivePackage ecoreExecutorPackage = new EcoreReflectivePackage(ePackage, this, id);
//			EList<EClassifier> eClassifiers = ePackage.getEClassifiers();
//			EcoreReflectiveType[] types = new EcoreReflectiveType[eClassifiers.size()];
//			for (int i = 0; i < types.length; i++) {
//				types[i] = new EcoreReflectiveType(eClassifiers.get(i), ecoreExecutorPackage, 0);
//			}
//			ecoreExecutorPackage.init((ExecutorStandardLibrary) standardLibrary, types);
			nsURI2package.put(nsURI, ecoreExecutorPackage);
			return ecoreExecutorPackage;
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull DomainPackage visitRootPackageId(@NonNull RootPackageId id) {
		if (id == IdManager.METAMODEL) {
			return DomainUtil.nonNullState(getStandardLibrary().getOclAnyType().getOwningPackage());
		}
		String name = id.getName();
		DomainPackage knownPackage = roots2package.get(name);
		if (knownPackage != null) {
			return knownPackage;
		}
//		DomainPackage libraryPackage = standardLibrary.getNsURIPackage(nsURI);
//		if (libraryPackage != null) {
//			nsURI2package.put(nsURI, libraryPackage);
//			return libraryPackage;
//		}
		if (!directRootsProcessed) {
			processDirectRoots();
			knownPackage = roots2package.get(name);
			if (knownPackage != null) {
				return knownPackage;
			}
		}
		if (!crossReferencedRootsProcessed) {
			processCrossReferencedRoots();
			knownPackage = roots2package.get(name);
			if (knownPackage != null) {
				return knownPackage;
			}
		}
		throw new UnsupportedOperationException();
	}
}
