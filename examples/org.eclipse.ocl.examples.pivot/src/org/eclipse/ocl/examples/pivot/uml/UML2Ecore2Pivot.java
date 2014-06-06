/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.uml;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.UML2EcoreConverter;

public class UML2Ecore2Pivot extends Ecore2Pivot
{
/*	private static final class Factory implements MetaModelManager.Factory
	{
		private Factory() {
			UMLPackage.eINSTANCE.getClass();
			MetaModelManager.addFactory(this);
		}

		public boolean canHandle(Resource resource) {
			return isUML(resource);
		}

		public void configure(ResourceSet resourceSet) {
			OCL.initialize(resourceSet);
		}

		public URI getPackageURI(EObject eObject) {
			if (eObject instanceof org.eclipse.uml2.uml.Package) {
				String uri = ((org.eclipse.uml2.uml.Package)eObject).getURI();
				if (uri != null) {
					return URI.createURI(uri);
				}
			}
			return null;
		}

		public Element importFromResource(MetaModelManager metaModelManager, Resource umlResource, String uriFragment) {
			if (umlResource == null) {
				return null;
			}
			UML2Ecore2Pivot conversion = findAdapter(umlResource, metaModelManager);
			if ((conversion == null) && (umlResource.getContents().size() > 0)) {
				EObject firstContent = umlResource.getContents().get(0);
				for (EObject eContainer = firstContent.eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
					conversion = findAdapter(eContainer.eResource(), metaModelManager);
					if (conversion != null) {
						break;
					}
				}
			}
			if (conversion == null) {
				conversion = getAdapter(umlResource, metaModelManager);
			}
			Root pivotRoot = conversion.getPivotRoot();
			if (uriFragment == null) {
				return pivotRoot;
			}
			else {
				EObject umlObject = umlResource.getEObject(uriFragment);
				if (umlObject == null) {
					return null;
				}
				return conversion.getPivotOfUML(Element.class, umlObject);
			}
		}
	} */

	protected static class UML2EcoreConverterWithReverseMap extends UML2EcoreConverter
	{
		private Map<EModelElement, org.eclipse.uml2.uml.Element> reverseMap = null;
		
		public @Nullable org.eclipse.uml2.uml.Element getSource(@NonNull EModelElement eObject) {
			if (reverseMap == null) {
				reverseMap = new HashMap<EModelElement, org.eclipse.uml2.uml.Element>();
				for (Map.Entry<org.eclipse.uml2.uml.Element, EModelElement> entry : elementToEModelElementMap.entrySet()) {
					reverseMap.put(entry.getValue(), entry.getKey());
				}
			}
			return reverseMap.get(eObject);
		}

		@Override
		public Object casePackage(org.eclipse.uml2.uml.Package package_) {
			EPackage ePackage = (EPackage) super.casePackage(package_);
			ePackage.setNsPrefix(null);
			return ePackage;
		}
	}


	public static UML2Ecore2Pivot findAdapter(@NonNull Resource resource, @Nullable MetaModelManager metaModelManager) {
		for (Adapter adapter : resource.eAdapters()) {
			if (adapter instanceof UML2Ecore2Pivot) {
				UML2Ecore2Pivot ecore2Pivot = (UML2Ecore2Pivot)adapter;
				if (ecore2Pivot.getMetaModelManager() == metaModelManager) {
					return ecore2Pivot;
				}
			}
		}
		return null;
	}

	public static UML2Ecore2Pivot getAdapter(@NonNull Resource resource, @NonNull MetaModelManager metaModelManager) {
		List<Adapter> eAdapters = resource.eAdapters();
		UML2Ecore2Pivot adapter = PivotUtil.getAdapter(UML2Ecore2Pivot.class, resource);
		if (adapter != null) {
			return adapter;
		}
		adapter = new UML2Ecore2Pivot(resource, metaModelManager);
		eAdapters.add(adapter);
		return adapter;
	}

	/**
	 * Convert an (annotated) Ecore resource to a Pivot Model.
	 * @param alias 
	 * 
	 * @param umlResource the annotated Ecore resource
	 * 
	 * @return the Pivot root package
	 */
	public static Root importFromUML(@NonNull MetaModelManager metaModelManager, String alias, @NonNull Resource umlResource) {
		UML2Ecore2Pivot conversion = getAdapter(umlResource, metaModelManager);
		return conversion.getPivotRoot();
	}

	public static boolean isUML(Resource resource) {
		List<EObject> contents = resource.getContents();
		for (EObject content : contents) {
			if (content instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
		}
		return false;
	}
	
	protected final @NonNull Resource umlResource;					// Set via eAdapters.add()
	private UML2EcoreConverterWithReverseMap uml2EcoreConverter = null;
	private Map<String, String> options = null;

	public UML2Ecore2Pivot(@NonNull Resource umlResource, @NonNull MetaModelManager metaModelManager) {
		super(DomainUtil.nonNullState(metaModelManager.getExternalResourceSet().createResource(umlResource.getURI().appendFileExtension("ecore"))), metaModelManager);
		this.umlResource = umlResource;
	}

	@Override
	public void addMapping(@NonNull EObject eObject, @NonNull Element pivotElement) {
		if ((uml2EcoreConverter != null) && (eObject instanceof EModelElement)) {
			org.eclipse.uml2.uml.Element umlElement = uml2EcoreConverter.getSource((EModelElement)eObject);
			if (umlElement != null) {
				super.addMapping(umlElement, pivotElement);
			}
			addCreated(eObject, pivotElement);
		}
		else {
			super.addMapping(eObject, pivotElement);
		}
	}

	@Override
	protected @NonNull URI createPivotURI() {
		URI uri = umlResource.getURI();
		if (uri == null) {
			throw new IllegalStateException("Missing resource URI");
		}
		return PivotUtil.getASURI(uri);
	}

	@Override
	public void dispose() {
		super.dispose();
//		CacheAdapter.INSTANCE.clear(umlResource);
	}

	@Override
	public @Nullable <T extends Element> T getCreated(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
		EObject ecoreObject = (EObject) uml2EcoreConverter.doSwitch(eObject);
		if (ecoreObject == null) {
			ecoreObject = eObject;
		}
		return super.getCreated(requiredClass, ecoreObject);
	}

	public @Nullable <T extends Element> T getPivotOfUML(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
		EObject ecoreObject = (EObject) uml2EcoreConverter.doSwitch(eObject);
		return ecoreObject != null ? getPivotOfEcore(requiredClass, ecoreObject) : null;
	}

	@Override
	public @NonNull Root getPivotRoot() {
		if (pivotRoot == null) {
			List<EObject> contents = umlResource.getContents();
			if (options == null) {
				options = new HashMap<String, String>();
				options.put(UML2EcoreConverter.OPTION__ECORE_TAGGED_VALUES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__REDEFINING_OPERATIONS, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__REDEFINING_PROPERTIES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__SUBSETTING_PROPERTIES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__UNION_PROPERTIES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__DERIVED_FEATURES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATIONS, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__SUPER_CLASS_ORDER, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__ANNOTATION_DETAILS, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__INVARIANT_CONSTRAINTS, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__OPERATION_BODIES, UMLUtil.OPTION__PROCESS);
				options.put(UML2EcoreConverter.OPTION__COMMENTS,  UMLUtil.OPTION__PROCESS);
			}
			if (uml2EcoreConverter == null) {
				uml2EcoreConverter = new UML2EcoreConverterWithReverseMap();
			}
			Collection<? extends EObject> ecoreContents = uml2EcoreConverter.convert(contents, options, null, null);
			ecoreResource.getContents().addAll(ecoreContents);
		}
		return super.getPivotRoot();
	}

	@Override
	public @Nullable Resource getResource() {
		return umlResource;
	}

	@Override
	public @NonNull Notifier getTarget() {
		return umlResource;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == UML2Ecore2Pivot.class;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		assert (newTarget == null) || (newTarget == umlResource);
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		assert (oldTarget == umlResource);
	}
}