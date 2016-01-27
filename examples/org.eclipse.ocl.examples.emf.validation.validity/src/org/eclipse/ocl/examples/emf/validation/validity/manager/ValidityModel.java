/*******************************************************************************
 * Copyright (c) 2013, 2015 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *  Obeo - Manage the Navigation from the ValidityView -> to the Editor
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultSet;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidityFactory;
import org.eclipse.ocl.examples.emf.validation.validity.locator.ConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.utilities.IVisibilityFilter;
import org.eclipse.ocl.examples.emf.validation.validity.utilities.SeveritiesVisibilityFilter;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.util.DerivedConstants;

public class ValidityModel
{
	private static final Logger logger = Logger.getLogger(ValidityManager.class);
	
	public static final int WORK_FOR_CLEAN_UP = 50;
	public static final int WORK_FOR_CREATE_MODEL = 50;
	private static final int WORK_FOR_ANALYZE_RESOURCES = 300;
	private static final int WORK_FOR_LOCATE_CONSTRAINTS = 300;
	private static final int WORK_FOR_CREATE_RESULTS = 300;
	private static final int WORK_FOR_SORT_CONSTRAINING_NODES = 50;
	private static final int WORK_FOR_SORT_VALIDATABLE_NODES = 50;
	public static final int WORK_FOR_ALL_SET_INPUT = WORK_FOR_CLEAN_UP +
			WORK_FOR_CREATE_MODEL + WORK_FOR_ANALYZE_RESOURCES +
			WORK_FOR_LOCATE_CONSTRAINTS + WORK_FOR_CREATE_RESULTS +
			WORK_FOR_SORT_CONSTRAINING_NODES + WORK_FOR_SORT_VALIDATABLE_NODES;
	
	private static @NonNull Comparator<AbstractNode> labelComparator = new Comparator<AbstractNode>()
	{
		public int compare(AbstractNode o1, AbstractNode o2) {
			String l1 = o1.getLabel();
			String l2 = o2.getLabel();
			return l1.compareTo(l2);
		}
	};
	
	private static @NonNull Comparator<AbstractNode> natureComparator = new Comparator<AbstractNode>()
	{
		public int compare(AbstractNode o1, AbstractNode o2) {
			EClass c1 = o1.eClass();
			EClass c2 = o2.eClass();
			if (c1 == c2) {
				return o1.getLabel().compareTo(o2.getLabel());
			}
			String l1 = c1.getName();
			String l2 = c2.getName();
			return l1.compareTo(l2);
		}
	};
	
	private static @Nullable Set<ConstraintLocator> badConstraintLocators = null;
	
	protected final @NonNull ValidityManager validityManager;
	private final @SuppressWarnings("null")@NonNull RootNode rootNode = ValidityFactory.eINSTANCE.createRootNode();
	private final @NonNull Map<ConstrainingURI, ConstrainingNode> allConstrainingNodes = new HashMap<ConstrainingURI, ConstrainingNode>();
	private final @NonNull Map<ValidatableURI, ValidatableNode> allValidatableNodes = new HashMap<ValidatableURI, ValidatableNode>();

	private final @NonNull Set<IVisibilityFilter> validatableFilters = new HashSet<IVisibilityFilter>();
	private final @NonNull Set<IVisibilityFilter> constrainingFilters = new HashSet<IVisibilityFilter>();
	
	private final @NonNull SeveritiesVisibilityFilter constrainingNodesFilterByKind = new SeveritiesVisibilityFilter();
	private final @NonNull SeveritiesVisibilityFilter validatableNodesFilterByKind = new SeveritiesVisibilityFilter();
	
	private final @NonNull Map<TypeURI, Set<TypeURI>> typeClosures = new HashMap<TypeURI, Set<TypeURI>>();
	private final @NonNull Collection<Resource> resources;

	/**
	 * Map from the URI of a type to be validated to the Constraining URIs of the types that provide constraints on instances of the type.
	 */
	private final @NonNull Map<TypeURI, List<ConstrainingURI>> type2constrainingType = new HashMap<TypeURI, List<ConstrainingURI>>();
	
	/**
	 * The Constructor.
	 * 
	 * @param validityManager
	 *            The ValidityManager
	 * @param newResources
	 *            All resources found in the resourceSet
	 */
	public ValidityModel(@NonNull ValidityManager validityManager, @NonNull Collection<Resource> newResources) {
		this.validityManager = validityManager;
		this.resources = newResources;
	}

	public @Nullable Set<ConstrainingURI> accumulateConstrainingURIs(@Nullable Set<ConstrainingURI> constrainingURIs, @NonNull TypeURI typeURI) {
		List<ConstrainingURI> moreConstrainingURIs = type2constrainingType.get(typeURI);
		if (moreConstrainingURIs != null) {
			if (constrainingURIs == null) {
				constrainingURIs = new HashSet<ConstrainingURI>();
			}
			constrainingURIs.addAll(moreConstrainingURIs);
		}
		return constrainingURIs;
	}

	public void addConstrainingFilter(@NonNull IVisibilityFilter filter) {
		constrainingFilters.add(filter);
	}
	
	public void addFilteredSeverity(@NonNull Severity severity) {
		constrainingNodesFilterByKind.addFilteredSeverity(severity);
		addConstrainingFilter(constrainingNodesFilterByKind);
		validatableNodesFilterByKind.addFilteredSeverity(severity);
		addValidatableFilter(validatableNodesFilterByKind);
	}

	public void addValidatableFilter(@NonNull IVisibilityFilter filter) {
		validatableFilters.add(filter);
	}

	/**
	 * Looks for all EPackages in the source Resources.
	 * 
	 * @param resources
	 *            the Collection of all resources in the resourceSet
	 * @return a map containing all EPackages of all resources
	 */
	protected @NonNull Map<EPackage,Set<Resource>> analyzeResources(@NonNull Collection<Resource> resources, @NonNull Monitor monitor, int worked) {
		monitor.setTaskName("Analyzing Resources");
		MonitorStep monitorStep = new MonitorStep(monitor, worked);
		try {
			List<Resource> allResources = new ArrayList<Resource>(resources);
			Map<EPackage,Set<Resource>> ePackage2resources = new HashMap<EPackage,Set<Resource>>();
			int allResourcesCount = allResources.size();
			for (int i = 0; i < allResourcesCount; i++) {
				Resource resource = allResources.get(i);
				@NonNull String uri = String.valueOf(resource.getURI());
				monitor.subTask("'" + uri + "'");
				ValidityManager.ANALYZE_RESOURCE.println(uri);
				Set<EClass> eClasses;
				ResourceSet resourceSet = resource.getResourceSet();
				if (resourceSet != null) {
					synchronized (resourceSet) {	// See Bug 405072 for rationale that avoids CMEs as UML stereotypes are discovered lazily
						eClasses = analyzeResource(resource);
					}
				}
				else {
					eClasses = analyzeResource(resource);
				}
				Set<EPackage> ePackages = new HashSet<EPackage>();
				for (@SuppressWarnings("null")@NonNull EClass eClass : eClasses) {
					ePackages.add(eClass.getEPackage());
					for (@SuppressWarnings("null")@NonNull EClass eSuperClass : eClass.getEAllSuperTypes()) {
						ePackages.add(eSuperClass.getEPackage());
					}
				}
				for (@SuppressWarnings("null")@NonNull EPackage ePackage : ePackages) {
					Set<Resource> ePackageResources = ePackage2resources.get(ePackage);
					if (ePackageResources == null) {
						ePackageResources = new HashSet<Resource>();
						ePackage2resources.put(ePackage, ePackageResources);
					}
					ePackageResources.add(resource);
					String nsURI = ePackage.getNsURI();
					if (nsURI !=null) {
						ValidityManager.ANALYZE_RESOURCE.println(" -> " + nsURI);
						Iterable<ConstraintLocator> list = getConstraintLocators(nsURI);
						if (list != null) {
							for (ConstraintLocator constraintLocator : list) {
								try {
									Collection<Resource> moreResources = constraintLocator.getImports(ePackage, resource);
									if (moreResources != null) {
										for (Resource anotherResource : moreResources) {
											if (!allResources.contains(anotherResource)) {
												allResources.add(anotherResource);
											}
										}
									}
								}
								catch (Exception e) {
									Set<ConstraintLocator> badConstraintLocators2 = badConstraintLocators;
									if (badConstraintLocators2 == null) {
										synchronized (this) {
											badConstraintLocators = badConstraintLocators2 = new HashSet<ConstraintLocator>();
										}
									}
									if (!badConstraintLocators2.contains(constraintLocator)) {
										synchronized (badConstraintLocators2) {
											if (badConstraintLocators2.add(constraintLocator)) {
												logger.error("ConstraintLocator " + constraintLocator + " failed", e);
											}
										}
									}
								}
							}
						}
					}
				}
				monitorStep.workedFraction(allResourcesCount);
			}
			return ePackage2resources;
		} finally {
			monitorStep.done();
		}
	}

	protected Set<EClass> analyzeResource(Resource resource) {
		Set<EClass> eClasses = new HashSet<EClass>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			@SuppressWarnings("null")@NonNull EObject eObject = tit.next();
			@SuppressWarnings("null")@NonNull EClass eClass = eObject.eClass();
			eClasses.add(eClass);
		}
		return eClasses;
	}

	/**
	 * Return all types that may provide constraints to an instance of aType.
	 */
	protected @NonNull Set<TypeURI> buildTypeClosure(@NonNull EObject constrainingObject) {
		TypeURI typeURI = validityManager.getTypeURI(constrainingObject);
		Set<TypeURI> typeClosure = typeClosures.get(typeURI);
		if (typeClosure == null) {
			typeClosure = new HashSet<TypeURI>();
			typeClosures.put(typeURI, typeClosure);
		}
		String nsURI = constrainingObject.eClass().getEPackage().getNsURI();
		if (nsURI != null) {
			Iterable<ConstraintLocator> constraintLocators = ValidityManager.getConstraintLocators(nsURI);
			if (constraintLocators != null) {
				for (ConstraintLocator constraintLocator : constraintLocators) {
					StringBuilder s = null;
					if (ValidityManager.BUILD_TYPE.isActive()) {
						s = new StringBuilder();
						s.append("PackageURI \"" + nsURI + "\" using \"" + constraintLocator.getName() + "\"");
						s.append("\n  ConstraintURI \"" + validityManager.getConstrainingURI(constrainingObject) + "\" applies to");
					}
					Set<TypeURI> allTypes = constraintLocator.getAllTypes(validityManager, constrainingObject);
					for (TypeURI aType : allTypes) {
						if (s != null) {
							s.append("\n    TypeURI \"" + aType + "\"");
						}
						typeClosure.add(aType);
					}
					if (s != null){
						ValidityManager.BUILD_TYPE.println(s.toString());
					}
				}
			}
		}
		return typeClosure;
	}

	/**
	 * Creates a ConstrainingNode.
	 * 
	 * @return the created ConstrainingNode
	 */
	@SuppressWarnings("null")
	protected @NonNull ConstrainingNode createConstrainingNode() {
		return ValidityFactory.eINSTANCE.createConstrainingNode();
	}

	/**
	 * creates a LeafConstrainingNode
	 * 
	 * @return the created LeafConstrainingNode
	 */
	@SuppressWarnings("null")
	public @NonNull LeafConstrainingNode createLeafConstrainingNode() {
		return ValidityFactory.eINSTANCE.createLeafConstrainingNode();
	}

	/**
	 * Return a new Result object, or return null if the creation process is to be aborted.
	 * <p>
	 * The default implementation always return an object. Derived implementations may cancel
	 * in response to a progress monitor request.
	 * 
	 * @param monitor the corresponding monitor
	 * @return the created new Result object
	 */
	protected @Nullable Result createResult(@Nullable IProgressMonitor monitor) {
		return ValidityFactory.eINSTANCE.createResult();
	}	

	/**
	 * Creates a ResultConstrainingNode.
	 * 
	 * @return the created ResultConstrainingNode
	 */
	@SuppressWarnings("null")
	protected @NonNull ResultConstrainingNode createResultConstrainingNode() {
		return ValidityFactory.eINSTANCE.createResultConstrainingNode();
	}

	/**
	 * Create the ResultValidatableNode,ResultConstrainingNode cross-linkage for
	 * all validateableObject,constraint pairs.
	 * 
	 * @param resources
	 *            the resources
	 */
	protected void createResultNodes(@NonNull Collection<Resource> resources, @NonNull Monitor monitor, int worked) {
		monitor.setTaskName("Create Result Nodes");
		MonitorStep monitorStep = new MonitorStep(monitor, worked);
		try {
			int resourcesCount = resources.size();
			for (Resource resource : resources) {
				monitor.subTask("'" + resource.getURI() + "'");
				ConstraintLocator constraintLocator = ValidityManager.getConstraintLocator(resource);	// Get a resource-specific locator, e.g. the UML stereotype application handler
				for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
					if (monitor.isCanceled()) {
						return;
					}
					@SuppressWarnings("null")@NonNull EObject validatableObject = tit.next();
					Set<ConstrainingURI> allConstrainingURIs = null;
					Set<TypeURI> allTypeURIs = null;
//					if (validatableObject instanceof DynamicEObjectImpl) {
//						allConstrainingURIs = null;
//					}
					if (constraintLocator != null) {
						allTypeURIs = constraintLocator.getTypeURIs(validityManager, validatableObject);
						if (allTypeURIs != null) {
							for (TypeURI typeURI : allTypeURIs) {
								Set<TypeURI> typeURIs = typeClosures.get(typeURI);
								if (typeURIs == null) {
//									buildTypeClosure(eClass);
									List<TypeURI> typeURIkeys = new ArrayList<TypeURI>(typeClosures.keySet());
									Collections.sort(typeURIkeys);
//									typeURIs = buildTypeClosure(eClass);
								}
								if (typeURIs != null) {
									for (TypeURI typeURI2 : typeURIs) {
										if (typeURI2 != null) {
											allConstrainingURIs = accumulateConstrainingURIs(allConstrainingURIs, typeURI2);
										}
									}
								}
							}
						}
					}
					if (allTypeURIs == null) {
						EClass eClass = validatableObject.eClass();
						if (eClass != null) {
							TypeURI typeURI = validityManager.getTypeURI(eClass);
							Set<TypeURI> typeURIs = typeClosures.get(typeURI);
							if (typeURIs == null) {
								buildTypeClosure(eClass);
								List<TypeURI> typeURIkeys = new ArrayList<TypeURI>(typeClosures.keySet());
								Collections.sort(typeURIkeys);
								typeURIs = buildTypeClosure(eClass);
							}
							if (typeURIs != null) {
								for (@SuppressWarnings("null")@NonNull TypeURI typeURI2 : typeURIs) {
									allConstrainingURIs = accumulateConstrainingURIs(allConstrainingURIs, typeURI2);
								}
							}
						}
					}
					if (allConstrainingURIs != null) {
						List<ConstrainingURI> sortedURIs = new ArrayList<ConstrainingURI>(allConstrainingURIs);
						Collections.sort(sortedURIs);
						for (ConstrainingURI constrainingURI : sortedURIs) {
							if (constrainingURI != null) {
								createResultNodes(validatableObject, constrainingURI);
							}
						}
					}
				}
				monitorStep.workedFraction(resourcesCount);
			}
		} finally {
			monitorStep.done();
		}
	}

	/**
	 * Create the ResultValidatableNode,ResultConstrainingNode cross-linkage
	 * between constrainedObject and each child constraint of constrainingType.
	 * 
	 * @param constrainedObject
	 *            the constraining object
	 * @param constrainingURI
	 *            the uri of the constrainingNode
	 */
	protected void createResultNodes(@NonNull EObject constrainedObject, @NonNull ConstrainingURI constrainingURI) {
		ValidatableNode validatable = getValidatableNode(constrainedObject);
		ConstrainingNode constrainingNode = allConstrainingNodes.get(constrainingURI);
		if (constrainingNode != null) {
			createResultNodes(validatable, constrainingNode);
		}
	}

	protected void createResultNodes(@NonNull ValidatableNode validatable, @NonNull ConstrainingNode constrainingNode) {
		List<ConstrainingNode> children = constrainingNode.getChildren();
		if (children.size() > 0) {
			for (@SuppressWarnings("null")@NonNull ConstrainingNode childConstrainingNode : children) {
				if (childConstrainingNode instanceof LeafConstrainingNode) {
					ResultConstrainingNode resultConstrainingNode = createResultConstrainingNode();
					ResultValidatableNode resultValidatableNode = createResultValidatableNode();
					resultConstrainingNode.setResultValidatableNode(resultValidatableNode);
					resultConstrainingNode.setLabel(getResultConstrainingLabel(validatable));
					resultValidatableNode.setLabel(getResultValidatableLabel(childConstrainingNode));
					childConstrainingNode.getChildren().add(resultConstrainingNode);
					validatable.getChildren().add(resultValidatableNode);
					ValidityManager.CREATE_RESULT.println(resultConstrainingNode + " => " + resultValidatableNode);
				}
				else {
					createResultNodes(validatable, childConstrainingNode);
				}
			}
		}
	}

	/**
	 * Creates a ResultSet.
	 * 
	 * @return the created ResultSet
	 */
	@SuppressWarnings("null")
	protected @NonNull ResultSet createResultSet() {
		return ValidityFactory.eINSTANCE.createResultSet();
	}

	/**
	 * Return a new ResultSet object containing an initial result for every
	 * enabled combination of ValidatableNode and ConstrainingNode. Returns null
	 * if the creation process was aborted.
	 * 
	 * @param monitor
	 *            the corresponding monitor
	 * @return the ResultSet
	 */
	public /*synchronized*/ @Nullable ResultSet createResultSet(@Nullable IProgressMonitor monitor) {
		ResultSet resultSet = createResultSet();
		List<Result> results = resultSet.getResults();
		if (!createResults(results, rootNode.getValidatableNodes(), monitor)) {
			return null;
		}
		else {
			rootNode.getResultSets().add(resultSet);
			return resultSet;
		}
	}

	/**
	 * Creates a ResultValidatableNode
	 * 
	 * @return the created ResultValidatableNode
	 */
	@SuppressWarnings("null")
	protected @NonNull ResultValidatableNode createResultValidatableNode() {
		return ValidityFactory.eINSTANCE.createResultValidatableNode();
	}

	/**
	 * Created Results of all validatableNodes.
	 * 
	 * @param results
	 *            the created results
	 * @param validatableNodes
	 *            the validatableNodes
	 * @param monitor
	 *            the corresponding monitor
	 * @return true if the results are created well, false otherwise
	 */
	protected boolean createResults(@NonNull List<Result> results, @NonNull List<? extends ValidatableNode> validatableNodes, @Nullable IProgressMonitor monitor) {
		for (int i = 0; i < validatableNodes.size(); i++) {		// Avoid CME from domain growth
			ValidatableNode validatable = validatableNodes.get(i);
			AbstractNode parent = validatable.getParent();
			if (validatable.isEnabled() && (parent == null || parent.isEnabled())) {
				if (validatable instanceof ResultValidatableNode) {
					ResultValidatableNode resultValidatableNode = (ResultValidatableNode) validatable;
					ConstrainingNode constraint = resultValidatableNode.getResultConstrainingNode().getParent();
					Result result = createResult(monitor);
					if (result == null) {
						return false;
					}
					result.setResultValidatableNode(resultValidatableNode);
					
					ResultConstrainingNode resultConstrainingNode = resultValidatableNode.getResultConstrainingNode();
					
					if (!constraint.isEnabled() || !resultConstrainingNode.isEnabled()) {
						result.setSeverity(Severity.UNKNOWN);
					} else {
						results.add(result);
					}
				}
			}
			if (!createResults(results, validatable.getChildren(), monitor)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return the created RootConstrainingNode
	 */
	@SuppressWarnings("null")
	protected @NonNull RootConstrainingNode createRootConstrainingNode() {
		return ValidityFactory.eINSTANCE.createRootConstrainingNode();
	}

	/**
	 * @return the created RootValidatableNode
	 */
	@SuppressWarnings("null")
	protected @NonNull RootValidatableNode createRootValidatableNode() {
		return ValidityFactory.eINSTANCE.createRootValidatableNode();
	}

	/**
	 * Create the LeafConstrainingNode parents for each EModelElement that provides constraints
	 * 
	 * @param allConstraints
	 *            the map from each model element to the LeafConstrainingNode of each of its constraints
	 */
	protected void createTypeConstrainingNodes(@NonNull Map<EObject, List<LeafConstrainingNode>> allConstraints, @NonNull Monitor monitor) {	// FIXME rename
		Set<ConstrainingNode> allTypeConstrainingNodes = new HashSet<ConstrainingNode>();
		for (@SuppressWarnings("null")@NonNull EObject constrainingType : allConstraints.keySet()) {
			if (monitor.isCanceled()) {
				break;
			}
			buildTypeClosure(constrainingType);
			TypeURI typeURI = validityManager.getTypeURI(constrainingType);
			List<ConstrainingURI> typeURIconstrainingURIs = type2constrainingType.get(typeURI);
			if (typeURIconstrainingURIs == null) {
				typeURIconstrainingURIs = new ArrayList<ConstrainingURI>();
				type2constrainingType.put(typeURI, typeURIconstrainingURIs);
			}
			List<LeafConstrainingNode> leafConstrainingNodes = allConstraints.get(constrainingType);
			if (leafConstrainingNodes != null) {
				for (LeafConstrainingNode leafConstrainingNode : leafConstrainingNodes) {
					Object constrainingObject = leafConstrainingNode.getConstrainingObject();
					if (constrainingObject != null) {
						ConstraintLocator constraintLocator = leafConstrainingNode.getConstraintLocator();
						EObject constrainingContainer = constraintLocator.getConstrainingType(constrainingType, constrainingObject);
						ConstrainingURI constrainingURI = validityManager.getConstrainingURI(constrainingContainer);
						if (!typeURIconstrainingURIs.contains(constrainingURI)) {
//							System.out.println(typeURI + " is constrained by " + constrainingURI);
							typeURIconstrainingURIs.add(constrainingURI);
						}
						ConstrainingNode typeConstrainingNode = getConstrainingNode(constrainingContainer);
						typeConstrainingNode.getChildren().add(leafConstrainingNode);
						allTypeConstrainingNodes.add(typeConstrainingNode);
					}
				}
			}
		}
	}

	/**
	 * @return the created ValidatableNode
	 */
	@SuppressWarnings("null")
	protected @NonNull ValidatableNode createValidatableNode() {
		return ValidityFactory.eINSTANCE.createValidatableNode();
	}

	/**
	 * Returns the eObject label
	 * 
	 * @param eObject
	 * @return The eObject label
	 */
	public @NonNull String getConstrainingLabel(@NonNull EObject eObject) {
		return validityManager.getConstrainingLabel(eObject);
	}

	/**
	 * Return the ConstrainingNode node for EObject creating any parent
	 * ConstrainingNodes that are required to ensure that the returned
	 * ConstrainingNode is installed in the root.
	 */
	public @NonNull ConstrainingNode getConstrainingNode(@NonNull EObject constrainingObject) {
		ConstrainingURI constrainingURI = validityManager.getConstrainingURI(constrainingObject);
		ConstrainingNode constrainingNode = allConstrainingNodes.get(constrainingURI);
		if (constrainingNode == null) {
			EObject eContainer = constrainingObject.eContainer();
			if (eContainer == null) {
				RootConstrainingNode rootConstrainingNode = createRootConstrainingNode();
				rootNode.getConstrainingNodes().add(rootConstrainingNode);
				constrainingNode = rootConstrainingNode;
			}
			else {
				constrainingNode = createConstrainingNode();
				ConstrainingNode parentConstrainingNode = getConstrainingNode(eContainer);
				parentConstrainingNode.getChildren().add(constrainingNode);
			}
			constrainingNode.setConstrainingObject(constrainingObject);
			String label = validityManager.getConstrainingLabel(constrainingObject);
			constrainingNode.setLabel(label);
			constrainingNode.setEnabled(true);
			allConstrainingNodes.put(constrainingURI, constrainingNode);
			ValidityManager.CREATE_CONSTRAINING.println(constrainingURI + " => " + constrainingNode);
		}
		return constrainingNode;
	}
	
	protected @NonNull Iterable<ConstraintLocator> getConstraintLocators(@NonNull String nsURI) {
		return validityManager.getActiveConstraintLocators(nsURI);
	}

	/**
	 * @return all resources
	 */
	public @NonNull Collection<Resource> getResources() {
		return resources;
	}

	public @NonNull String getResultConstrainingLabel(@NonNull ValidatableNode validatableNode) {
		StringBuilder s = getResultPath(new StringBuilder(), validatableNode.getParent());
		s.append(validatableNode.getLabel());
		return s.toString();
	}

	protected @NonNull StringBuilder getResultPath(@NonNull StringBuilder s, @Nullable AbstractNode abstractNode) {
		if (abstractNode != null) {
			getResultPath(s, abstractNode.getParent());
//			String label = abstractNode.getLabel();
//			int index = label.indexOf(' ');
//			s.append(index > 0 ? label.substring(0, index) : label);
//			s.append(label);
//			StringBuilder s = new StringBuilder();
			if (abstractNode instanceof ConstrainingNode) {
				s.append(ILabelGenerator.Registry.INSTANCE.labelFor(((ConstrainingNode)abstractNode).getConstrainingObject(), ValidityManager.LABEL_OPTIONS));
			}
			else if (abstractNode instanceof ValidatableNode) {
				s.append(ILabelGenerator.Registry.INSTANCE.labelFor(((ValidatableNode)abstractNode).getConstrainedObject(), ValidityManager.LABEL_OPTIONS));
			}
			s.append("::");
		}
		return s;
	}

	public @NonNull String getResultValidatableLabel(@NonNull ConstrainingNode constrainingNode) {
		StringBuilder s = getResultPath(new StringBuilder(), constrainingNode.getParent());
		s.append(constrainingNode.getLabel());
		return s.toString();
	}

	/**
	 * @return the root node
	 */
	public @NonNull RootNode getRootNode() {
		return rootNode;
	}

	/**
	 * Return the ValidatableNode node for EObject creating any ValidatableNodes
	 * that are required to ensure that the returned ValidatableNode is
	 * installed in the root.
	 * 
	 * @param eObject
	 *            the modelElement
	 * @return the ValidatableNode node for EObject
	 */
	protected @NonNull ValidatableNode getValidatableNode(@NonNull EObject eObject) {
		ValidatableURI validatableURI = validityManager.getValidatableURI(eObject);
		ValidatableNode validatable = allValidatableNodes.get(validatableURI);
		if (validatable == null) {
			EObject eContainer = eObject.eContainer();
			if (eContainer == null && eObject instanceof DynamicEObjectImpl) {
				EClass eClass = eObject.eClass();
				for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
					String featureName = eStructuralFeature.getName();
					if ((featureName != null) && featureName.startsWith(DerivedConstants.STEREOTYPE_BASE_PREFIX)
					  && (eStructuralFeature instanceof EReference)
					  && eObject.eIsSet(eStructuralFeature)) { // Unset for an applicable stereotype that has not been applied
						eContainer = (EObject) eObject.eGet(eStructuralFeature);
						break;
					}
				}
			}
			if (eContainer != null) {
				validatable = createValidatableNode();
				ValidatableNode parentValidatableNode = getValidatableNode(eContainer);
				parentValidatableNode.getChildren().add(validatable);
			}
			else {
				RootValidatableNode rootValidatableNode = createRootValidatableNode();
				rootNode.getValidatableNodes().add(rootValidatableNode);
				validatable = rootValidatableNode;
			}
			validatable.setEnabled(true);
			validatable.setLabel(validityManager.getValidatableLabel(eObject, eContainer == null));
			validatable.setConstrainedObject(eObject);
			allValidatableNodes.put(validatableURI, validatable);
			ValidityManager.CREATE_VALIDATABLE.println(validatableURI + " => " + validatable);
		}
		return validatable;
	}

	/**
	 * Initialize the ValidityModel
	 */
	public void init(@NonNull Monitor monitor) {
//		long start = System.currentTimeMillis();
//		System.out.format(Thread.currentThread().getName() + " %3.3f analyzeResources\n", (System.currentTimeMillis() - start) * 0.001);
		Map<EPackage,Set<Resource>> ePackage2resources = analyzeResources(resources, monitor, WORK_FOR_ANALYZE_RESOURCES);			//	Find all EClasses and EPackages in the source Resources
//		System.out.format(Thread.currentThread().getName() + " %3.3f locateConstraints\n", (System.currentTimeMillis() - start) * 0.001);
		Map<EObject, List<LeafConstrainingNode>> allConstraints = locateConstraints(ePackage2resources, monitor, WORK_FOR_LOCATE_CONSTRAINTS);
		if (monitor.isCanceled()) {
			return;
		}
		if (allConstraints != null) {
//			System.out.format(Thread.currentThread().getName() + " %3.3f createLeafConstrainingNodes\n", (System.currentTimeMillis() - start) * 0.001);
			createTypeConstrainingNodes(allConstraints, monitor);
		}
		if (monitor.isCanceled()) {
			return;
		}
//		System.out.format(Thread.currentThread().getName() + " %3.3f createResultNodes\n", (System.currentTimeMillis() - start) * 0.001);
		createResultNodes(resources, monitor, WORK_FOR_CREATE_RESULTS);
		if (monitor.isCanceled()) {
			return;
		}
		monitor.setTaskName("Sorting Constraints");
//		System.out.format(Thread.currentThread().getName() + " %3.3f sort ConstrainingNodes\n", (System.currentTimeMillis() - start) * 0.001);
		sortNodes(rootNode.getConstrainingNodes(), labelComparator);
		monitor.worked(WORK_FOR_SORT_CONSTRAINING_NODES);
		if (monitor.isCanceled()) {
			return;
		}
		monitor.setTaskName("Sorting Model Elements");
//		System.out.format(Thread.currentThread().getName() + " %3.3f sort ValidatableNodes\n", (System.currentTimeMillis() - start) * 0.001);
		sortNodes(rootNode.getValidatableNodes(), natureComparator);
		monitor.worked(WORK_FOR_SORT_VALIDATABLE_NODES);
	}

	/**
	 * Find all constraints for each EClass
	 * 
	 * @param ePackage2resources
	 *            the map of all ePackages and their resources
	 * @return all constraints for each EClass
	 */
	protected @Nullable Map<EObject, List<LeafConstrainingNode>> locateConstraints(@NonNull Map<EPackage,Set<Resource>> ePackage2resources, @NonNull Monitor monitor, int worked) {
		monitor.setTaskName("Locating Constraints");
		MonitorStep monitorStep = new MonitorStep(monitor, worked);
		try {
			Map<EObject, List<LeafConstrainingNode>> allConstraints = new HashMap<EObject, List<LeafConstrainingNode>>();
			Set<EPackage> ePackages = ePackage2resources.keySet();
			int ePackagesCount = ePackages.size();
			for (@SuppressWarnings("null")@NonNull EPackage ePackage : ePackages) {
				if (monitor.isCanceled()) {
					return null;
				}
				String nsURI = ePackage.getNsURI();
				if (nsURI != null) {
					monitor.subTask("'" + nsURI + "'");
					Iterable<ConstraintLocator> list = getConstraintLocators(nsURI);
					if (list != null) {
						Set<Resource> ePackageResources = ePackage2resources.get(ePackage);
						assert ePackageResources != null;
						for (ConstraintLocator constraintLocator : list) {
							if (monitor.isCanceled()) {
								return null;
							}
							String subTaskName = "PackageURI \"" + nsURI + "\" - \"" + constraintLocator.getName() + "\"";
							monitor.subTask(subTaskName);
							ValidityManager.LOCATE_RESOURCE.println(subTaskName);
							try {
								Map<EObject, List<LeafConstrainingNode>> availableConstraints = constraintLocator.getConstraints(this, ePackage, ePackageResources, monitor);
								if (availableConstraints != null) {
									assert !availableConstraints.containsKey(null);
									for (@SuppressWarnings("null")@NonNull EObject constrainedType : availableConstraints.keySet()) {
										List<LeafConstrainingNode> typeConstraints = allConstraints.get(constrainedType);
										if (typeConstraints == null) {
											typeConstraints = new ArrayList<LeafConstrainingNode>();
											allConstraints.put(constrainedType, typeConstraints);
										}
										int oldSize = typeConstraints.size();
										typeConstraints.addAll(availableConstraints.get(constrainedType));
										int newSize = typeConstraints.size();
										if (newSize > oldSize) {
											ValidityManager.LOCATE_RESOURCE.println((newSize-oldSize) + " constraints for ConstrainingURI \"" + validityManager.getConstrainingURI(constrainedType) + "\"");
										}
									}
								}
							}
							catch (Exception e) {
								Set<ConstraintLocator> badConstraintLocators2 = badConstraintLocators;
								if (badConstraintLocators2 == null) {
									synchronized (this) {
										badConstraintLocators = badConstraintLocators2 = new HashSet<ConstraintLocator>();
									}
								}
								if (!badConstraintLocators2.contains(constraintLocator)) {
									synchronized (badConstraintLocators2) {
										if (badConstraintLocators2.add(constraintLocator)) {
											logger.error("ConstraintLocator " + constraintLocator + " failed", e);
										}
									}
								}
							}
						}
					}
				}
				monitorStep.workedFraction(ePackagesCount);
			}
			return allConstraints;
		} finally {
			monitorStep.done();
		}
	}

	public void refreshModel(@Nullable List<AbstractNode> grayedValidatableNodes,
			@Nullable List<AbstractNode> grayedConstrainingNodes) {
		RootNode rootNode = validityManager.getRootNode();
		if (rootNode != null) {
//			long start = System.currentTimeMillis();
			@NonNull List<RootValidatableNode> validatableNodes = new ArrayList<RootValidatableNode>(rootNode.getValidatableNodes());  // Avoid CME
			@NonNull List<RootConstrainingNode> constrainingNodes = new ArrayList<RootConstrainingNode>(rootNode.getConstrainingNodes());  // Avoid CME
//			System.out.format(Thread.currentThread().getName() + " %3.3f revisible ValidatableNodes\n", (System.currentTimeMillis() - start) * 0.001);
			for (AbstractNode aNode : validatableNodes) {
				aNode.refreshVisibleChildren(validatableFilters);
			}
//			System.out.format(Thread.currentThread().getName() + " %3.3f revisible ConstrainingNodes\n", (System.currentTimeMillis() - start) * 0.001);
			for (AbstractNode aNode : constrainingNodes) {
				aNode.refreshVisibleChildren(constrainingFilters);
			}
//			System.out.format(Thread.currentThread().getName() + " %3.3f regray ValidatableNodes\n", (System.currentTimeMillis() - start) * 0.001);
			for (AbstractNode aNode : validatableNodes) {
				aNode.refreshGrayed();
			}
//			System.out.format(Thread.currentThread().getName() + " %3.3f regray ConstrainingNodes\n", (System.currentTimeMillis() - start) * 0.001);
			for (AbstractNode aNode : constrainingNodes) {
				aNode.refreshGrayed();
			}
			List<AbstractNode> grayedValidatableNodes2 = grayedValidatableNodes;
			if (grayedValidatableNodes2 != null) {
//				System.out.format(Thread.currentThread().getName() + " %3.3f Redraw compute grays\n", (System.currentTimeMillis() - start) * 0.001);
				for (AbstractNode abstractNode : validatableNodes) {
					abstractNode.getGrayedElements(grayedValidatableNodes2);
				}
			}
			List<AbstractNode> grayedConstrainingNodes2 = grayedConstrainingNodes;
			if (grayedConstrainingNodes2 != null) {
				for (AbstractNode abstractNode : constrainingNodes) {
					abstractNode.getGrayedElements(grayedConstrainingNodes2);
				}
			}
		}
	}

	public void removeConstrainingFilter(@NonNull IVisibilityFilter filter) {
		constrainingFilters.remove(filter);
	}
	
	public void removeFilteredSeverity(@NonNull Severity severity) {
		if (!constrainingNodesFilterByKind.removeFilteredSeverity(severity)) {
			constrainingFilters.remove(constrainingNodesFilterByKind);
		}
		if (!validatableNodesFilterByKind.removeFilteredSeverity(severity)) {
			validatableFilters.remove(validatableNodesFilterByKind);
		}
	}

	public void removeValidatableFilter(@NonNull IVisibilityFilter filter) {
		validatableFilters.remove(filter);
	}
	
	/**
	 * Sorts the list.
	 * 
	 * @param nodes
	 *            the list of nodes needing to be sorted.
	 */
	protected <T extends AbstractNode> void sortEList(@NonNull EList<T> nodes, @NonNull Comparator<AbstractNode> comparator) {
		List<T> sortedList = new ArrayList<T>(nodes);
		Collections.sort(sortedList, comparator);
		for (int i = 0; i < sortedList.size(); i++) {
			nodes.move(i, sortedList.get(i));
		}
	}

	/**
	 * Sorts the list.
	 * 
	 * @param nodes
	 *            the list of nodes needing to be sorted.
	 */
	protected <T extends AbstractNode> void sortNodes(@NonNull EList<T> nodes, @NonNull Comparator<AbstractNode> comparator) {
		sortEList(nodes, comparator);
		for (AbstractNode node : nodes) {
			sortNodes(node.getChildren(), comparator);
		}
	}
}
