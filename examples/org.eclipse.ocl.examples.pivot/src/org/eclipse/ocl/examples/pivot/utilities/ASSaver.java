/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.Orphanage;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * ASSaver ensures that all references to synthesized types are terminated
 * by local copies of the synthesized types.
 */
public class ASSaver
{
	protected final @NonNull Resource resource;
	
	public ASSaver(@NonNull Resource resource) {
		this.resource = resource;
	}

	/**
	 * The moniker to operation map for operations defined with the saved resource.
	 */
	private Map<String, Operation> operations = new HashMap<String, Operation>();

	/**
	 * TypedElements that refer to specializations.
	 */
	private @NonNull List<Element> specializingElements = new ArrayList<Element>();

	/**
	 * The extra package for copies of specializations.
	 */
	private /*@LazyNonNull*/ org.eclipse.ocl.examples.pivot.Package orphanage = null;

	/**
	 * Map of original specialization to local specialization
	 */
	private @NonNull Map<Type, Type> specializations = new HashMap<Type, Type>();

	/**
	 * The extra package for copies of specializations.
	 */
	private /*@LazyNonNull*/ Type orphanageClass = null;

	public void addSpecializingElement(@NonNull Element object) {
		specializingElements.add(object);
	}

	public boolean addSpecializingElement(@NonNull Element object, @NonNull Operation referredOperation) {
		if (!isOrphanOperation(referredOperation)) {
			return false;
		}
		else {
			specializingElements.add(object);
			return true;
		}
	}

	public boolean addSpecializingElement(@NonNull Element object, @NonNull Type referredType) {
		if (PivotUtil.isLibraryType(referredType)) {
			return false;
		}
		else {
			specializingElements.add(object);
			return true;
		}
	}

	protected @NonNull ASSaverLocateVisitor getLocateVisitor(@NonNull EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource instanceof ASResource) {
			return ((ASResource)resource).getASResourceFactory().createASSaverLocateVisitor(this);
		}
		else if (resource == null) {
			throw new IllegalStateException("Cannot locate " + ASSaverLocateVisitor.class.getName() + " for resource-less " + eObject.eClass().getName());
		}
		else {
			throw new IllegalStateException("Cannot locate " + ASSaverLocateVisitor.class.getName() + " for non-OCL " + resource.getClass().getName());
		}
	}

	protected @NonNull ASSaverNormalizeVisitor getNormalizeVisitor(@NonNull EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource instanceof ASResource) {
			return ((ASResource)resource).getASResourceFactory().createASSaverNormalizeVisitor(this);
		}
		else if (resource == null) {
			throw new IllegalStateException("Cannot locate " + ASSaverLocateVisitor.class.getName() + " for resource-less " + eObject.eClass().getName());
		}
		else {
			throw new IllegalStateException("Cannot locate " + ASSaverLocateVisitor.class.getName() + " for non-OCL " + resource.getClass().getName());
		}
	}

	protected @NonNull Type getOrphanClass(@NonNull org.eclipse.ocl.examples.pivot.Package orphanagePackage) {
		Type orphanageClass2 = orphanageClass;
		if (orphanageClass2 == null) {
			orphanageClass = orphanageClass2 = PivotFactory.eINSTANCE.createAnyType();		// No superclasses
			orphanageClass2.setName(PivotConstants.ORPHANAGE_NAME);
			orphanagePackage.getOwnedType().add(orphanageClass2);
		}
		return orphanageClass2;
	}

	protected @NonNull org.eclipse.ocl.examples.pivot.Package getOrphanPackage(@NonNull Resource resource) {
		Package orphanage2 = orphanage;
		if (orphanage2 == null) {
			orphanage = orphanage2 = PivotFactory.eINSTANCE.createPackage();
			orphanage2.setName(PivotConstants.ORPHANAGE_NAME);
			orphanage2.setNsPrefix(PivotConstants.ORPHANAGE_PREFIX);
			orphanage2.setNsURI(PivotConstants.ORPHANAGE_URI);
			EList<EObject> contents = resource.getContents();
			if ((contents.size() > 0) && (contents.get(0) instanceof Root)) {
				((Root)contents.get(0)).getNestedPackage().add(orphanage2);
			}
			else {
				contents.add(orphanage2);
			}
		}
		return orphanage2;
	}

	protected @NonNull ASSaverResolveVisitor getResolveVisitor(@NonNull EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource instanceof ASResource) {
			return ((ASResource)resource).getASResourceFactory().createASSaverResolveVisitor(this);
		}
		else if (resource == null) {
			throw new IllegalStateException("Cannot locate " + ASSaverResolveVisitor.class.getName() + " for resource-less " + eObject.eClass().getName());
		}
		else {
			throw new IllegalStateException("Cannot locate " + ASSaverResolveVisitor.class.getName() + " for non-OCL " + resource.getClass().getName());
		}
	}

	protected boolean isOrphanOperation(@NonNull Operation operation) {		// FIXME Non-static PivotUtils
		// FIXME surely an orphan is one for which eResource() is null,
		//  or one that is in the orphanage.
		if (operation.getTemplateBinding().size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Prepare a pivot resource for save by redirecting all type references to
	 * specializations to local copies of the specializations.
	 */
	public void localizeSpecializations() {
		locateSpecializations(resource.getContents());
		if (specializingElements.size() > 0) {
			loadOrphanage(resource);
			for (int i = 0; i < specializingElements.size(); i++) {	// Domain may grow
				Element element = specializingElements.get(i);
				if (element != null) {
					ASSaverResolveVisitor resolveVisitor = getResolveVisitor(element);
					resolveVisitor.safeVisit(element);
				}
			}
//			List<Type> ownedTypes = orphanage.getOwnedType();
//			List<Type> sorted = ownedTypes; //WIP PivotUtil.sortByMoniker(new ArrayList<Type>(ownedTypes));
//			ownedTypes.clear();
//			ownedTypes.addAll(sorted);
		}
	}

	protected void loadOrphanage(@NonNull Resource resource) {
		Root root = null;
		Package orphanage2 = orphanage;
		if (orphanage2 == null) {
			for (EObject eRoot : resource.getContents()) {
				if (eRoot instanceof Root) {
					if (root == null) {
						root = (Root) eRoot;
					}
					if (orphanage2 == null) {
						for (org.eclipse.ocl.examples.pivot.Package asPackage : ((Root)eRoot).getNestedPackage()) {
							if (Orphanage.isTypeOrphanage(asPackage)) {
								orphanage = orphanage2 = asPackage;
								for (Type asType : orphanage2.getOwnedType()) {
									if (PivotConstants.ORPHANAGE_NAME.equals(asType.getName())) {
										orphanageClass = asType;
									}
									else {
										specializations.put(asType, asType);
									}
								}
								break;
							}
						}					
					}
				}
				if ((eRoot instanceof org.eclipse.ocl.examples.pivot.Package) && Orphanage.isTypeOrphanage((org.eclipse.ocl.examples.pivot.Package)eRoot)) {	// FIXME Obsolete
					orphanage = orphanage2 = (org.eclipse.ocl.examples.pivot.Package)eRoot;
					for (Type asType : orphanage2.getOwnedType()) {
						if (PivotConstants.ORPHANAGE_NAME.equals(asType.getName())) {
							orphanageClass = asType;
						}
						else {
							specializations.put(asType, asType);
						}
					}
					break;
				}
			}
		}
	}

	protected void locateSpecializations(/*@NonNull*/ List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			if (eObject instanceof Visitable) {
				ASSaverLocateVisitor locateVisitor = getLocateVisitor(eObject);
				locateVisitor.safeVisit((Visitable) eObject);
			}
			locateSpecializations(eObject.eContents());
		}
	}

	public void normalizeContents() {
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			@SuppressWarnings("null")@NonNull EObject eObject = tit.next();
			ASSaverNormalizeVisitor normalizeVisitor = getNormalizeVisitor(eObject);
			if (eObject instanceof Visitable) {
				normalizeVisitor.safeVisit((Visitable) eObject);
			}
		}
	}

	/**
	 * Return the resolved variant of referredType, which may require creation
	 * of a local copy of a specialization.
	 */
	public @NonNull <T extends Operation> T resolveOperation(@NonNull T referredOperation) {
		if (!isOrphanOperation(referredOperation)) {
			return referredOperation;
		}
		String moniker = AS2Moniker.toString(referredOperation);
		Operation operation = operations.get(moniker);
		if (operation != null) {
			@SuppressWarnings("unchecked") 
			T castOperation = (T) operation;
			return castOperation;
		}
		T resolvedOperation = DomainUtil.nonNullEMF(EcoreUtil.copy(referredOperation));
		if (orphanageClass == null) {
			Package orphanage2 = orphanage;
			if (orphanage2 == null) {
				orphanage2 = getOrphanPackage(resource);
			}
			orphanageClass = getOrphanClass(orphanage2);
		}
		orphanageClass.getOwnedOperation().add(resolvedOperation);
		operations.put(moniker, resolvedOperation);
		String newMoniker = AS2Moniker.toString(resolvedOperation);
		assert moniker.equals(newMoniker);
		locateSpecializations(Collections.singletonList(resolvedOperation));
		return resolvedOperation;
	}

	/**
	 * Return the resolved variant of referredType, which may require creation
	 * of a local copy of a specialization.
	 */
	public @NonNull <T extends Type> T resolveType(@NonNull T referredType) {
		if (PivotUtil.isLibraryType(referredType)) {
			return referredType;
		}
		@SuppressWarnings("unchecked")
		T resolvedType = (T) specializations.get(referredType);
		if (resolvedType == null) {
			resolvedType = DomainUtil.nonNullEMF(EcoreUtil.copy(referredType));
			specializations.put(referredType, resolvedType);
			specializations.put(resolvedType, resolvedType);
			EObject eContainer = resolvedType.eContainer();
			if (eContainer == null) {
				Package orphanage2 = orphanage;
				if (orphanage2 == null) {
					orphanage2 = getOrphanPackage(resource);
				}
				orphanage.getOwnedType().add(resolvedType);
			}
		}
/*			String moniker = Pivot2Moniker.toString(referredType);
		Type type = types.get(moniker);
		if (type != null) {
			@SuppressWarnings("unchecked") 
			T castType = (T) type;
			return castType;
		}
		T resolvedType = EcoreUtil.copy(referredType);
		orphanage.getOwnedType().add(resolvedType);
		types.put(moniker, resolvedType);
		String newMoniker = Pivot2Moniker.toString(resolvedType);
//		assert moniker.equals(newMoniker) : newMoniker + " is not equal to " + moniker;
		if (!moniker.equals(newMoniker)) {
			String moniker2 = Pivot2Moniker.toString(referredType);
			String newMoniker2 = Pivot2Moniker.toString(resolvedType);
			assert moniker.equals(newMoniker) : newMoniker + " is not equal to " + moniker;
		} */
		locateSpecializations(Collections.singletonList(resolvedType));
		return resolvedType;
	}
}