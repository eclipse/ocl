/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.pivot2cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.PathElement;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS;

/**
 * An AliasAnalysis is dynamically created to support the serialization
 * of cross-references following a Pivot to CS conversion. It ensures the
 * resource-wide uniqueness of aliases for package names.
 * 
 * Uniqueness is achieved with respect to all names to avoid the complexity
 * of considering which name usages are not actually conflicting.
 */
public class AliasAnalysis extends AdapterImpl
{
	public static void dispose(@NonNull Resource resource) {
		List<Adapter> eAdapters = DomainUtil.nonNullEMF(resource.eAdapters());
		AliasAnalysis adapter = PivotUtil.getAdapter(AliasAnalysis.class, eAdapters);
		if (adapter != null) {
			adapter.dispose();
		}
	}

	public static @NonNull AliasAnalysis getAdapter(@NonNull Resource resource) {
		MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(resource);
		if (metaModelManager == null) {
			throw new IllegalStateException("No MetaModelManager");
		}
		return getAdapter(resource, metaModelManager);
	}

	public static @NonNull AliasAnalysis getAdapter(@NonNull Resource resource, @NonNull MetaModelManager metaModelManager) {
		List<Adapter> eAdapters = resource.eAdapters();
		for (Adapter adapter : eAdapters) {
			if (adapter instanceof AliasAnalysis) {
				AliasAnalysis aliasAnalysis = (AliasAnalysis)adapter;
				if (aliasAnalysis.metaModelManager == metaModelManager) {
					return aliasAnalysis;
				}
			}
		}
		AliasAnalysis aliasAnalysis = new AliasAnalysis(resource, metaModelManager);
		Set<org.eclipse.ocl.examples.pivot.Package> localPackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
		Set<org.eclipse.ocl.examples.pivot.Package> otherPackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
		aliasAnalysis.computePackages(localPackages, otherPackages);
		aliasAnalysis.computeAliases(localPackages, otherPackages);
		return aliasAnalysis;
	}

	protected final @NonNull MetaModelManager metaModelManager;
	
	/**
	 * Mapping of all named elements from the name to the name usage,
	 * which is non-null for a uniquely named element, or
	 * null for a shared name.
	 */
	private @NonNull Map<String, Object> allNames = new HashMap<String, Object>();
	
	/**
	 * The known or assigned package aliases/
	 */
	private @NonNull Map<DomainPackage, String> allAliases = new HashMap<DomainPackage, String>();

	public AliasAnalysis(@NonNull Resource resource, @NonNull MetaModelManager metaModelManager) {
		resource.eAdapters().add(this);
		this.metaModelManager = metaModelManager;
	}

	/**
	 * Assign a unique alias to each localPackage then to each otherPackage.
	 */
	private void computeAliases(@NonNull Set<org.eclipse.ocl.examples.pivot.Package> localPackages,
			@NonNull Set<org.eclipse.ocl.examples.pivot.Package> otherPackages) {		
		for (org.eclipse.ocl.examples.pivot.Package localPackage : localPackages) {
			if (localPackage != null) {
				DomainPackage primaryPackage = metaModelManager.getPackageServer(localPackage);
				if ((primaryPackage.getNsPrefix() != null) || (primaryPackage.getNestingPackage() == null)) {
					if (!allAliases.containsKey(primaryPackage)) {
						String alias = computeAlias(primaryPackage);
						allAliases.put(localPackage, alias);
					}
				}
			}
		}
		for (org.eclipse.ocl.examples.pivot.Package otherPackage : otherPackages) {
			if (otherPackage != null) {
				DomainPackage primaryPackage = metaModelManager.getPackageServer(otherPackage);
				if (!allAliases.containsKey(primaryPackage)) {
					String alias = computeAlias(primaryPackage);
					allAliases.put(primaryPackage, alias);
				}
			}
		}
	}

	/**
	 * Register the usage of name by primaryElement, and if name is already in use
	 * register the ambiguity as a usage by null.
	 */
	private void addName(@NonNull String name, @NonNull Object primaryElement) {
		if (!allNames.containsKey(name)) {
			allNames.put(name, primaryElement);
		}
		else if (allNames.get(name) != primaryElement) {
			allNames.put(name, null);
		}
	}

	/**
	 * Determine a unique alias for primaryPackage/
	 */
	private String computeAlias(@NonNull DomainPackage primaryPackage) {
		String nsPrefix = primaryPackage.getNsPrefix();
		String aliasBase = nsPrefix != null ? nsPrefix : getDefaultAlias(primaryPackage.getName());
		int index = 0;
		String alias = aliasBase;
		while (allNames.containsKey(alias) && (allNames.get(alias) != primaryPackage)) {
			@SuppressWarnings("unused")
			Object debugObject = allNames.get(alias);
			alias = aliasBase + "_" + index++;
		}
		addName(alias, primaryPackage);
		return alias;
	}

	/**
	 * Scan the target resource to identify allNames of any form that appear,
	 * allAliases assigned by explicit imports, all localPackages whose name is
	 * defined within the target resource all all otherPackages. Nested packages
	 * of localPackages are excluded from localPackages.
	 */
	private void computePackages(@NonNull Set<org.eclipse.ocl.examples.pivot.Package> localPackages,
			@NonNull Set<org.eclipse.ocl.examples.pivot.Package> otherPackages) {
		for (TreeIterator<EObject> tit = ((Resource)target).getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof ImportCS) {
				String name = ((ImportCS)eObject).getName();
				Namespace namespace = ((ImportCS)eObject).getNamespace();
				if (namespace instanceof org.eclipse.ocl.examples.pivot.Package) {
					allAliases.put((org.eclipse.ocl.examples.pivot.Package) namespace, name);
				}
			}
			EObject csObject = eObject;
			if (eObject instanceof Pivotable) {
				eObject = ((Pivotable)eObject).getPivot();
			}
			if (eObject instanceof DomainNamedElement) {
				DomainNamedElement domainNamedElement = (DomainNamedElement) eObject;
				if (!(eObject instanceof PackageServer)) {
					if (eObject instanceof PackageServer) {
						;
					}
					else if (eObject instanceof DomainPackage) {
						domainNamedElement = metaModelManager.getPackageServer((DomainPackage)eObject);
					}
					else {
//						domainNamedElement = metaModelManager.getPrimaryElement((NamedElement)eObject);
					}
				}
				String name = domainNamedElement.getName();
				if (name != null) {
					addName(name, domainNamedElement);
				}
				if ((eObject instanceof org.eclipse.ocl.examples.pivot.Package) && (csObject instanceof RootPackageCS)) {			// FIXME
					org.eclipse.ocl.examples.pivot.Package pivotPackage = (org.eclipse.ocl.examples.pivot.Package)eObject;
					String nsPrefix = pivotPackage.getNsPrefix();
					if (nsPrefix != null) {
						addName(nsPrefix, domainNamedElement);
					}
					localPackages.add(pivotPackage);
				}
				else {
					for (EObject eContainer = eObject; eContainer != null; eContainer = eContainer.eContainer()) {
						if (eContainer instanceof org.eclipse.ocl.examples.pivot.Package) {
							otherPackages.add((org.eclipse.ocl.examples.pivot.Package)eContainer);
							break;
						}
						if (eContainer instanceof Type) {
							eContainer = PivotUtil.getUnspecializedTemplateableElement((Type)eContainer);
						}
					}
				}
			}
		}
		otherPackages.removeAll(localPackages);
		Set<org.eclipse.ocl.examples.pivot.Package> nestedPackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
		for (org.eclipse.ocl.examples.pivot.Package localPackage : localPackages) {
			EObject eContainer = localPackage.eContainer();
			if (eContainer instanceof org.eclipse.ocl.examples.pivot.Package) {
				EObject eContainerContainer = eContainer.eContainer();
				if (eContainerContainer instanceof org.eclipse.ocl.examples.pivot.Package) {
					nestedPackages.add(localPackage);
				}
			}
		}
		localPackages.removeAll(nestedPackages);
	}
	
	public void dispose() {
		target.eAdapters().remove(this);
	}

	/**
	 * Return the alias for eObject, or null if there is none.
	 */
	@Deprecated
	public @Nullable String getAlias(@NonNull EObject eObject) {
		return getAlias(eObject, null);
	}
	/**
	 * Return the alias for eObject, using a non-null hint as a stem for auto-generation, or null if there is none.
	 */
	public @Nullable String getAlias(@NonNull EObject eObject, @Nullable String hint) {
		EObject eObject2 = eObject;
		if (eObject2 instanceof Pivotable) {
			eObject2 = ((Pivotable)eObject2).getPivot();
		}
		if (eObject2 instanceof DomainPackage) {
			PackageServer packageServer = metaModelManager.getPackageServer((DomainPackage)eObject2);
			String alias = allAliases.get(packageServer);
			if (alias != null) {
				return alias;
			}
/*			MetaModelManager metaModelManager = ElementUtil.findMetaModelManager((Resource)getTarget());
			if (metaModelManager != null) {
				eObject = metaModelManager.getPrimaryElement(eObject);
				return allAliases.get(eObject);
			} */
			if (hint != null) {
				if (allNames.get(hint) != null) {
					int counter = 0;
					while (allNames.get(hint + "_" + counter) != null) {
						counter++;
					}
					hint = hint + "_" + counter;
				}
				allNames.put(hint, packageServer);
				allAliases.put(packageServer, hint);				
				return hint;
			}
		}
		return null;
	}

	/**
	 * Return the alias for eObject.
	 */
	@SuppressWarnings("null")
	public @NonNull Iterable<DomainPackage> getAliases() {
		return allAliases.keySet();
	}
	
	protected @NonNull String getDefaultAlias(@Nullable String name) {
		if (name == null) {
			return "anon";			// Never happens
		}
		int iMax = name.length();
		if (iMax <= 0) {
			return "anon";			// Never happens
		}
		if (Character.isLowerCase(name.charAt(0))) {
			return name;
		}
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < iMax; i++) {
			char c = name.charAt(i);
			if (Character.isUpperCase(c)) {
				s.append(Character.toLowerCase(c));
			}
			else {
				s.append(name.substring(i));
				break;
			}
		}
		@SuppressWarnings("null") @NonNull String string = s.toString();
		return string;
	}

	public @NonNull List<PathElement> getPath(@NonNull Element eObject) {
		EObject eContainer = eObject.eContainer();
		if (eContainer == null) {
			return new ArrayList<PathElement>();
		}
		List<PathElement> result = getPath((Element) eContainer);
		if (eObject instanceof NamedElement) {
			result.add(new PathElement(((NamedElement)eObject).getName(), eObject));
		}
		else if (eObject instanceof ENamedElement) {
			result.add(new PathElement(((ENamedElement)eObject).getName(), eObject));
		}
		else if (eObject instanceof NamedElementCS) {
			result.add(new PathElement(((NamedElementCS)eObject).getName(), eObject));
		}
		return result;
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == AliasAnalysis.class;
	}
}
