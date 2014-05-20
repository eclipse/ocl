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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * A TypeManager adapts a ResourceSet to provide facilities for the pivot
 * model.
 * <p>
 * An PivotURI entry is maintained for each non-null EPackage.nsURI to
 * facilitate lookup, detect duplicates, and domain (Ecore/UML - Pivot - CS)
 * mappings.
 * <p>
 * An PivotPrefix entry is maintained for each non-null EPackage.nsPrefix to
 * facilitate alias generation for monikers.
 */
@Deprecated
public class TypeManager extends MetaModelManager
{	
/*	private static class ResourceTracker extends AbstractTracker<Resource>
	{
		public static ResourceTracker install(TypeCaches metaModelManager, Resource target) {
			return new ResourceTracker(metaModelManager, target);
		}

		public static  void uninstall(TypeCaches metaModelManager, Resource target) {
			ResourceTracker tracker = PivotUtil.getAdapter(ResourceTracker.class, target);
			if (tracker != null) {
				tracker.dispose();
			}
		}
		
		private ResourceTracker(TypeCaches metaModelManager, Resource target) {
			super(metaModelManager, target);
		}		

		@Override
		public void dispose() {
			unsetTarget(target);
		}
		
		public boolean isAdapterForType(Object type) {
			return type == ResourceTracker.class;
		}

		public void notifyChanged(Notification notification) {
			int featureID = notification.getFeatureID(ResourceSet.class);
			if (featureID == Resource.RESOURCE__CONTENTS) {
				int eventType = notification.getEventType();
				switch (eventType) {
					case Notification.ADD: {
						Object value = notification.getNewValue();
						ResourceTracker.install(metaModelManager, (Resource)value);
						break;
					}
					case Notification.REMOVE: {
						Object value = notification.getOldValue();
						ResourceTracker.uninstall(metaModelManager, (Resource)value);
						break;
					}
				}
			}
		}
	} */
	
	public TypeManager() {
		super();
	}

	public TypeManager(@NonNull ResourceSet asResourceSet) {
		super(asResourceSet);		
	}

//	public void addPackage(String key, Package pivotPackage) {
//		packageMap.put(key, pivotPackage);
//	}

//	public CompleteType getCompleteType(Type type) {
//		return completeEnvironmentManager.getCompleteType(type);
//	}

	/**
	 * Return the CompleteEnvironmentManager, which is null if none yet created.
	 * Invoke useCompleteEnvironmentManager to create one when required.
	 */
//	public CompleteEnvironmentManager getCompleteEnvironmentManager() {
//		return completeEnvironmentManager;
//	}

//	public CompletePackage getCompletePackage(
//			org.eclipse.ocl.examples.pivot.Package type) {
//		return completeEnvironmentManager.getCompletePackage(type);
//	}

//	public Collection<Resource> getExternalResources() {
//		return externalResources != null
//			? externalResources.values()
//			: Collections.<Resource> emptySet();
//	}

	// public String getPrefixPrecedenceName(String operatorName) {
	// return prefixToPrecedenceNameMap.get(operatorName);
	// }

/*	protected String getSpecializedMoniker(Type libraryType, List<? extends ParameterableElement> templateArguments) {
		Pivot2Moniker s = new Pivot2Moniker(null);
		s.appendElement((Element) libraryType.eContainer());
		s.append(PivotConstants.MONIKER_SCOPE_SEPARATOR);
		s.append(libraryType.getName());
		s.appendTemplateArguments(templateArguments, null);
		String moniker = s.toString();
		return moniker;
	} */

	/**
	 * Add a resource-specific map of elements to preferred aliases, updating
	 * the internal pivot-resource-set-wide map of elements to pivot-aliases
	 * and vice-versa.
	 * <b>
	 * Note that pivot aliases are unique and used only for monikers.
	 * 
	 * @param resource
	 * @param newAliasMap
	 * @return
	 *
	public Map<Element, String> putAliasMap(Resource resource, Map<Element, String> newAliasMap) {
		Map<Element, String> oldAliasMap = aliasMaps.put(resource, newAliasMap);
		if (oldAliasMap != null) {
			for (Element key : oldAliasMap.keySet()) {
				pivot2alias.remove(key);
				alias2pivot.remove(key);
			}
		}
		if (newAliasMap != null) {
			for (Element key : newAliasMap.keySet()) {
				String baseString = newAliasMap.get(key);
				String alias = PivotConstants.MONIKER_SCOPE_SEPARATOR + baseString;
				int index = 0;
				while (alias2pivot.containsKey(alias)) {
					alias = PivotConstants.MONIKER_SCOPE_SEPARATOR + index++ + PivotConstants.MONIKER_OPERATOR_SEPARATOR + baseString;
				}
				pivot2alias.put(key, alias);
				alias2pivot.put(alias, key);
			}
		}
		return oldAliasMap;
	} */
}
