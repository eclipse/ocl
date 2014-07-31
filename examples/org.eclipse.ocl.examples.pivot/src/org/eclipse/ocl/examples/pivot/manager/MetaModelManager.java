/*******************************************************************************
 * Copyright (c) 2010,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *	E.D.Willink (CEA LIST) - Bug 399252
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.domain.DomainConstants;
import org.eclipse.ocl.examples.domain.compatibility.EMF_2_9;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainNamespace;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.UnsupportedOperation;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.DelegatedSinglePackageResource;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.context.ClassContext;
import org.eclipse.ocl.examples.pivot.context.OperationContext;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.context.PropertyContext;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.model.OCLMetaModel;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.resource.ASResourceFactory;
import org.eclipse.ocl.examples.pivot.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;
import org.eclipse.ocl.examples.pivot.utilities.CompleteElementIterable;
import org.eclipse.ocl.examples.pivot.utilities.External2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.IllegalLibraryException;
import org.eclipse.ocl.examples.pivot.utilities.PivotObjectImpl;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.Iterables;

public class MetaModelManager extends PivotStandardLibrary implements Adapter.Internal, MetaModelManageable
{		
	public class CompleteTypeOperationsIterable extends CompleteElementIterable<Type, Operation>
	{
		protected final Boolean selectStatic;	// null for static/non-static, true for static, false for non-static
		
		public CompleteTypeOperationsIterable(@NonNull Iterable<Type> types, boolean selectStatic) {
			super(types);
			this.selectStatic = selectStatic;
		}

		@Override
		protected @NonNull Iterable<Operation> getInnerIterable(@NonNull Type model) {
			return DomainUtil.nonNullEMF(model.getOwnedOperation());
		}

		@Override
		protected @Nullable Operation getInnerValue(@NonNull Operation element) {
			if (selectStatic != null) {
				if (element.isStatic() != selectStatic.booleanValue()) {
					return null;
				}
			}
			return element;
		}
	}
	
	public class CompleteClassPropertiesIterable extends CompleteElementIterable<Type, Property>
	{
		protected final Boolean selectStatic;	// null for static/non-static, true for static, false for non-static
		
		public CompleteClassPropertiesIterable(@NonNull Iterable<Type> types, boolean selectStatic) {
			super(types);
			this.selectStatic = selectStatic;
		}

		@Override
		protected @NonNull Iterable<Property> getInnerIterable(@NonNull Type model) {
			return DomainUtil.nonNullEMF(model.getOwnedAttribute());
		}

		@Override
		protected @Nullable Property getInnerValue(@NonNull Property element) {
			if (selectStatic != null) {
				if (element.isStatic() != selectStatic.booleanValue()) {
					return null;
				}
			}
			return element;
		}
	}
	
	public class CompleteClassSuperClassesIterable
			extends CompleteElementIterable<Type, Type> {

		public CompleteClassSuperClassesIterable(@NonNull Iterable<Type> types) {
			super(types);
		}

		@Override
		protected @NonNull Iterable<Type> getInnerIterable(@NonNull Type model) {
			return DomainUtil.nonNullEMF(model.getSuperClass());
		}
	}

	public class CompleteElementCommentsIterable
			extends CompleteElementIterable<DomainElement, Comment> {

		public CompleteElementCommentsIterable(@NonNull Iterable<? extends DomainElement> models) {
			super(models);
		}

		@Override
		protected Iterable<Comment> getInnerIterable(@NonNull DomainElement model) {
			if (model instanceof Element) {
				return DomainUtil.nonNullEMF(((Element)model).getOwnedComment());
			}
			else {
				return EMPTY_COMMENT_LIST;
			}
		}
	}

	public class CompleteElementInvariantsIterable
			extends CompleteElementIterable<Type, Constraint> {

		public CompleteElementInvariantsIterable(@NonNull Iterable<? extends Type> models) {
			super(models);
		}

		@Override
		protected @NonNull Iterable<Constraint> getInnerIterable(@NonNull Type model) {
			return DomainUtil.nonNullEMF(model.getOwnedInvariant());
		}
	}

	/**
	 * An OrphanServer maintains the set of OrphanClients identifying active references to an orphan element.
	 * When the final reference is removed the orphan is killed off.
	 *
	public static class OrphanServer
	{
		protected final Element element;
		private Set<OrphanClient> clients = null;
		
		public OrphanServer(Element element) {
			this.element = element;
		}

		public void addClient(OrphanClient client) {
			if (client != null) {
				if (clients == null) {
					clients = new HashSet<OrphanClient>();
				}
				clients.add(client);
			}			
		}

//		public Element getElement() {
//			return element;
//		}

		public void removeClient(OrphanClient client) {
			if (client != null) {
				if (clients != null) {
					clients.remove(client);
					if (clients.isEmpty()) {
						clients = null;
						element.eSet(element.eContainmentFeature(), null);
					}
				}
			}			
		}
		
		@Override
		public String toString() {
			return "<orphan-node> " + element;
		}
	} */
	
	/**
	 * An OrphanClient adapts an EObject with an eReference to an OrphanServer within the domina of a TypeCache.
	 * 
	 * Changes to eContainer and eReference cause the eReference to be activated and deactivated accordingly so that
	 * the OrphanServer is aware of how many active clients there are.
	 *
	public static class OrphanClient implements Adapter
	{
		protected final TypeCaches typeCache;
		protected final EObject target;
		protected final EReference eReference;
		private OrphanServer orphanServer;
		
		public OrphanClient(TypeCaches typeCache, EObject target, EReference eReference) {
			this.typeCache = typeCache;
			this.target = target;
			this.eReference = eReference;
			this.orphanServer = null;
			target.eAdapters().add(this);
		}

		protected void activate(NamedElement pivotElement) {
			orphanServer = null; // W I P typeCache.getOrphanServer(pivotElement);
			if (orphanServer != null) {
				orphanServer.addClient(this);
			}
		}

		protected void deActivate() {
			if (orphanServer != null) {
				orphanServer.removeClient(this);
				orphanServer = null;
			}
		}
		
		public Notifier getTarget() {
			return target;
		}

		public boolean isAdapterForType(Object type) {
			return type == OrphanClient.class;
		}

		public void notifyChanged(Notification notification) {
			if (notification.getNotifier() == target) {
				int eventType = notification.getEventType();
				switch (eventType) {
					case Notification.SET: {
						Object oldValue = notification.getOldValue();
						Object newValue = notification.getNewValue();
						if (newValue != oldValue) {
							Object feature = notification.getFeature();
							if (feature == eReference) {
								if (oldValue != null) {
									deActivate();
								}
								if (newValue instanceof NamedElement) {
									activate((NamedElement) newValue);
								}
							}
							else if (feature == target.eContainmentFeature()) {
								if (oldValue != null) {
									deActivate();
								}
								if (newValue != null) {
									assert target == newValue;
									Object orphan = target.eGet(eReference);
									if (orphan instanceof NamedElement) {
										activate((NamedElement) orphan);
									}
								}
							}
						}
					}
				}
			}			
		}

		public void setTarget(Notifier newTarget) {
			assert (newTarget == null) || (newTarget == target);
		}		
	} */
	
	private static final Logger logger = Logger.getLogger(MetaModelManager.class);

	public static final @NonNull TracingOption CREATE_MUTABLE_CLONE = new TracingOption(PivotPlugin.PLUGIN_ID, "mm/createMutableClone");

	@SuppressWarnings("null")
	public static final @NonNull List<Comment> EMPTY_COMMENT_LIST = Collections.<Comment>emptyList();
	
	@SuppressWarnings("null")
	public static final @NonNull List<Constraint> EMPTY_CONSTRAINT_LIST = Collections.<Constraint>emptyList();

	@SuppressWarnings("null")
	public static final @NonNull List<Element> EMPTY_ELEMENT_LIST = Collections.<Element>emptyList();

	@SuppressWarnings("null")
	public static final @NonNull List<Operation> EMPTY_OPERATION_LIST = Collections.<Operation>emptyList();

	@SuppressWarnings("null")
	public static final @NonNull List<Property> EMPTY_PROPERTY_LIST = Collections.<Property>emptyList();

	@SuppressWarnings("null")
	public static final @NonNull List<State> EMPTY_STATE_LIST = Collections.<State>emptyList();

	@SuppressWarnings("null")
	public static final @NonNull List<TemplateParameter> EMPTY_TEMPLATE_PARAMETER_LIST = Collections.<TemplateParameter>emptyList();

	@SuppressWarnings("null")
	public static final @NonNull List<Type> EMPTY_TYPE_LIST = Collections.<Type>emptyList();

	@SuppressWarnings("null")
	public static final @NonNull List<TypeServer> EMPTY_TYPE_SERVER_LIST = Collections.<TypeServer>emptyList();

	/**
	 * Leak debugging aid. Set non-null to diagnose MetaModelManager construction and finalization.
	 */
	public static WeakHashMap<MetaModelManager,Object> liveMetaModelManagers = null;

	public static @Nullable MetaModelManager findAdapter(@Nullable ResourceSet resourceSet) {
		if (resourceSet == null) {
			return null;
		}
		return PivotUtil.getAdapter(MetaModelManager.class, resourceSet);
	}

	public static @NonNull MetaModelManager getAdapter(@NonNull ResourceSet resourceSet) {
		List<Adapter> eAdapters = DomainUtil.nonNullEMF(resourceSet.eAdapters());
		MetaModelManager adapter = PivotUtil.getAdapter(MetaModelManager.class, eAdapters);
		if (adapter == null) {
			if (resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().get(ASResource.CONTENT_TYPE) == null) {
				MetaModelManager.initializeASResourceSet(resourceSet);
			}
			adapter = new MetaModelManager(resourceSet);
//			eAdapters.add(adapter);
		}
		return adapter;
	}

	public static void initializeASResourceSet(@NonNull ResourceSet asResourceSet) {
//		System.out.println("initializeASResourceSet " + DomainUtil.debugSimpleName(asResourceSet));
		StandaloneProjectMap.initializeURIResourceMap(asResourceSet);
		ASResourceFactoryRegistry.INSTANCE.configureResourceSet(asResourceSet);
		EPackage.Registry packageRegistry = asResourceSet.getPackageRegistry();
		packageRegistry.put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
	}
	
	/**
	 * The known packages.
	 */
	private final @NonNull PackageManager packageManager = createPackageManager();
	
	/**
	 * The known precedences.
	 */
	private PrecedenceManager precedenceManager = null;			// Lazily created
	
	/**
	 * The known tuple types.
	 */
	private TupleTypeManager tupleManager = null;			// Lazily created
	
	/**
	 * The known tuple types.
	 */
	private LambdaTypeManager lambdaManager = null;			// Lazily created
	
	/**
	 * The known implementation load capabilities.
	 */
	private ImplementationManager implementationManager = null;			// Lazily created
		
	private Orphanage orphanage = null;

	protected DomainPackage asMetamodel = null;

	private boolean libraryLoadInProgress = false;

	protected final @NonNull ResourceSet asResourceSet;
	
	/**
	 * All Library packages imported into the current type managed domain. All libraries
	 * share the same URI, which for supplementary libraries may be null.
	 */
	protected final @NonNull List<Library> asLibraries = new ArrayList<Library>();	

	/**
	 * The resource of the first of the asLibraries. Set once actually loaded.
	 */
	protected @Nullable Resource asLibraryResource = null;

	protected @Nullable ResourceSetImpl externalResourceSet = null;
	
	private final @NonNull Map<String, DomainNamespace> globalNamespaces = new HashMap<String, DomainNamespace>();
	private final @NonNull Set<Type> globalTypes = new HashSet<Type>();

	private int unspecifiedTypeCount = 0;
	
	/**
	 * Map of URI to external resource converter.
	 */
	private final @NonNull Map<URI, External2Pivot> external2PivotMap = new HashMap<URI, External2Pivot>();

	/**
	 * The resolver for Ids and EObjects
	 */
	protected final @NonNull PivotIdResolver idResolver;

	/**
	 * Elements protected from garbage collection
	 */
	private @Nullable EAnnotation lockingAnnotation = null;
	
	/**
	 * MetaModelManagerListener instances to be notified of significant state changes; most notably disposal.
	 */
	private @Nullable List<MetaModelManagerListener> listeners = null;

	private boolean autoLoadASMetamodel = true;
	
	private @Nullable Map<String, GenPackage> genPackageMap = null;
	
	public MetaModelManager() {
		this(new ResourceSetImpl());
//		initializePivotResourceSet(asResourceSet);
	}
	
	/**
	 * Construct a MetaModelManager that will use projectMap to assist in locating resources.
	 */
	public MetaModelManager(@NonNull StandaloneProjectMap projectMap) {
		this();
		asResourceSet.eAdapters().add(projectMap);
	}

	/**
	 * Construct a MetaModelManager that will use asResourceSet to contain pivot copies
	 * of meta-models, and {@link ProjectMap#getAdapter(ResourceSet)} to assist in locating resources.
	 */
	public MetaModelManager(@NonNull ResourceSet asResourceSet) {
		if (asResourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().get(ASResource.CONTENT_TYPE) == null) {
			initializeASResourceSet(asResourceSet);
		}
		idResolver = createIdResolver();
//		System.out.println("ctor " + this);
		this.asResourceSet = asResourceSet;
		asResourceSet.eAdapters().add(this);
		if (liveMetaModelManagers != null) {
			liveMetaModelManagers.put(this, null);
			System.out.println(Thread.currentThread().getName() + " Create " + PivotUtil.debugSimpleName(this)
				+ " " + PivotUtil.debugSimpleName(asResourceSet));	
		}
	}

	public void addClassLoader(@NonNull ClassLoader classLoader) {
		ImplementationManager implementationManager = getImplementationManager();
		implementationManager.addClassLoader(classLoader);
	}

	public void addExternalResource(@NonNull External2Pivot external2Pivot) {
		URI uri = external2Pivot.getURI();
		Resource resource = external2Pivot.getResource();
		if ((resource != null) && DomainUtil.isRegistered(resource)) {
			ResourceSet externalResourceSet2 = getExternalResourceSet();
			getProjectMap().useGeneratedResource(resource, externalResourceSet2);
		}
		external2PivotMap.put(uri, external2Pivot);
	}

	/**
	 * Add all resources in ResourceSet to the externalResourceSet.
	 * @since 3.5
	 */
	public void addExternalResources(@NonNull ResourceSet resourceSet) {
		ResourceSet externalResourceSet = getExternalResourceSet();
		if (externalResourceSet instanceof ResourceSetImpl) {
			Map<URI, Resource> uriResourceMap = ((ResourceSetImpl)externalResourceSet).getURIResourceMap();
			if (uriResourceMap != null) {
				for (Resource eResource : resourceSet.getResources()) {
					URI uri = eResource.getURI();
					if (uri != null) {
						uriResourceMap.put(uri, eResource);
					}
				}
				if (resourceSet instanceof ResourceSetImpl) {
					Map<URI, Resource> contextResourceMap = ((ResourceSetImpl)resourceSet).getURIResourceMap();
					if (contextResourceMap != null) {
						for (URI uri : contextResourceMap.keySet()) {
							uriResourceMap.put(uri, contextResourceMap.get(uri));
						}
					}
				}
			}
		}
	}

	public void addGenModel(@NonNull GenModel genModel) {
		for (@SuppressWarnings("null")@NonNull GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
			addGenPackage(genPackage);
		}
	}

	public void addGenPackage(@NonNull GenPackage genPackage) {
		Map<String, GenPackage> genPackageMap2 = genPackageMap;
		if (genPackageMap2 == null) {
			genPackageMap = genPackageMap2 = new HashMap<String, GenPackage>();
		}
		genPackageMap2.put(genPackage.getNSURI(), genPackage);
	}

	public @Nullable DomainNamespace addGlobalNamespace(@NonNull String name, @NonNull DomainNamespace namespace) {
		return globalNamespaces.put(name, namespace);
	}

	public boolean addGlobalTypes(@NonNull Collection<Type> types) {
		return globalTypes.addAll(types);
	}

	public void addListener(@NonNull MetaModelManagerListener listener) {
		List<MetaModelManagerListener> listeners2 = listeners;
		if (listeners2 == null) {
			listeners = listeners2 = new ArrayList<MetaModelManagerListener>();
		}
		if (!listeners2.contains(listener)) {
			listeners2.add(listener);
		}
	}
	
	public void addLockedElement(@NonNull Object lockedElement) {
		if (lockedElement instanceof EObject) {
			EAnnotation lockingAnnotation2 = lockingAnnotation;
			if (lockingAnnotation2 == null) {
				lockingAnnotation = lockingAnnotation2 = EcoreFactory.eINSTANCE.createEAnnotation();
			}
			List<EObject> lockingReferences = lockingAnnotation2.getReferences();
			if (!lockingReferences.contains(lockedElement)) {
				lockingReferences.add((EObject) lockedElement);
			}
		}
	}

//	public void addModel(Model pivotModel) {
//		packageManager.addModel(pivotModel);
//	}
	
	public void addOrphanClass(@NonNull Type pivotElement) {
		if (pivotElement.getUnspecializedElement() != null) {
			assert pivotElement.getUnspecializedElement().getUnspecializedElement() == null;
		}
		else {
			assert (pivotElement instanceof LambdaType)
				|| (pivotElement instanceof TupleType)
				|| (pivotElement instanceof UnspecifiedType);
		}
		pivotElement.setPackage(getOrphanage());
	}

	@Deprecated // Since Luna M3
	public void assignLibraryIds(@NonNull AS2XMIid as2xmIid) {
		assignLibraryIds(as2xmIid, null);
	}

	/**
	 * Assign xmi:id values to referenceable elements in the libraries.
	 */
	public void assignLibraryIds(@NonNull AS2XMIid as2xmIid, @Nullable Map<?, ?> options) {
		for (@SuppressWarnings("null")@NonNull Library asLibrary : asLibraries) {
			Resource eResource = asLibrary.eResource();
			if (eResource instanceof ASResource) {
				as2xmIid.assignIds((ASResource) eResource, options);
			}
		}
	}

	/**
	 * Return -ve if match1 is inferior to match2, +ve if match2 is inferior to match1, or
	 * zero if both matches are of equal validity.
	 */
	public int compareOperationMatches(@NonNull Operation reference, @Nullable Map<TemplateParameter, ParameterableElement> referenceBindings,
			@NonNull Operation candidate, @Nullable Map<TemplateParameter, ParameterableElement> candidateBindings) {
		if ((reference instanceof Iteration) && (candidate instanceof Iteration)) {
			int iteratorCountDelta = ((Iteration)candidate).getOwnedIterator().size() - ((Iteration)reference).getOwnedIterator().size();
			if (iteratorCountDelta != 0) {
				return iteratorCountDelta;
			}
			Type referenceType = PivotUtil.getOwningType(reference);
			Type candidateType = PivotUtil.getOwningType(candidate);
			Type specializedReferenceType = getSpecializedType(referenceType, referenceBindings);
			Type specializedCandidateType = getSpecializedType(candidateType, candidateBindings);
			if (referenceType != candidateType) {
				if (conformsTo(specializedReferenceType, specializedCandidateType, null)) {
					return 1;
				}
				else if (conformsTo(specializedCandidateType, specializedReferenceType, null)) {
					return -1;
				}
			}
		}
		List<Parameter> candidateParameters = candidate.getOwnedParameter();
		List<Parameter> referenceParameters = reference.getOwnedParameter();
		int parameterCountDelta = candidateParameters.size() - referenceParameters.size();
		if (parameterCountDelta != 0) {
			return parameterCountDelta;
		}
		boolean referenceConformsToCandidate = true;
		boolean candidateConformsToReference = true;
		for (int i = 0; i < candidateParameters.size(); i++) {
			Parameter referenceParameter = referenceParameters.get(i);
			Parameter candidateParameter = candidateParameters.get(i);
			if ((referenceParameter == null) || (candidateParameter == null)) {					// Doesn't happen (just a supurious NPE guard)
				referenceConformsToCandidate = false;
				candidateConformsToReference = false;
			}
			else {
				Type referenceType = PivotUtil.getBehavioralType(referenceParameter);
				Type candidateType = PivotUtil.getBehavioralType(candidateParameter);
				Type specializedReferenceType = getSpecializedType(referenceType, referenceBindings);
				Type specializedCandidateType = getSpecializedType(candidateType, candidateBindings);
				if (referenceType != candidateType) {
					if (!conformsTo(specializedReferenceType, specializedCandidateType, null)) {
						referenceConformsToCandidate = false;
					}
					if (!conformsTo(specializedCandidateType, specializedReferenceType, null)) {
						candidateConformsToReference = false;
					}
				}
			}
		}
		if (referenceConformsToCandidate != candidateConformsToReference) {
			return referenceConformsToCandidate ? 1 : -1;
		}
		Type referenceType = DomainUtil.nonNullModel(PivotUtil.getOwningType(reference));
		Type candidateType = DomainUtil.nonNullModel(PivotUtil.getOwningType(candidate));
		Type specializedReferenceType = getSpecializedType(referenceType, referenceBindings);
		Type specializedCandidateType = getSpecializedType(candidateType, candidateBindings);
		if (referenceType != candidateType) {
			if (conformsTo(specializedReferenceType, specializedCandidateType, null)) {
				return 1;
			}
			else if (conformsTo(specializedCandidateType, specializedReferenceType, null)) {
				return -1;
			}
		}
		return 0;
	}

	/**
	 * Configure the PackageRegistry associated with the externalResourceSet to use a load strategy that uses whichever of
	 * the namespace or platform URI is firtst encounterted and which suppresses diagnostics about subsequent use of the
	 * other form of URI.
	 */
	public void configureLoadFirstStrategy() {
		configureLoadStrategy(StandaloneProjectMap.LoadFirstStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
	}

	/**
	 * Configure the PackageRegistry associated with the externalResourceSet to use a packageLoadStrategy and conflictHandler when
	 * resolving namespace ansd platform URIs.
	 */
	public void configureLoadStrategy(@NonNull StandaloneProjectMap.IResourceLoadStrategy packageLoadStrategy, @Nullable StandaloneProjectMap.IConflictHandler conflictHandler) {
		ResourceSet externalResourceSet = getExternalResourceSet();
		StandaloneProjectMap projectMap = getProjectMap();
		projectMap.configure(externalResourceSet, StandaloneProjectMap.LoadFirstStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
	}

	public boolean conformsTo(@NonNull Type firstType, @NonNull Type secondType, @Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		if (bindings != null) {
			TemplateParameter firstTemplateParameter = firstType.getOwningTemplateParameter();
			if (firstTemplateParameter != null) {
				ParameterableElement parameterableElement = bindings.get(firstTemplateParameter);
				if (parameterableElement instanceof Type) {
					firstType = (Type) parameterableElement;
				}
			}
			TemplateParameter secondTemplateParameter = secondType.getOwningTemplateParameter();
			if (secondTemplateParameter != null) {
				ParameterableElement parameterableElement = bindings.get(secondTemplateParameter);
				if (parameterableElement instanceof Type) {
					secondType = (Type) parameterableElement;
				}
				else if ((parameterableElement == null) && bindings.containsKey(secondTemplateParameter)) {
					bindings.put(secondTemplateParameter, firstType);
					return true;
				}
			}
		}
		if (firstType == secondType) {
			return true;
		}
//		firstType = getModelType(firstType);
//		secondType = getModelType(secondType);
		firstType = getPrimaryType(firstType);
		secondType = getPrimaryType(secondType);
		if (firstType == secondType) {
			return true;
		}
		firstType = PivotUtil.getType(firstType);
		secondType = PivotUtil.getType(secondType);
		if (firstType == secondType) {
			return true;
		}
		if (secondType instanceof AnyType) {			// FIXME Shouldn't the library model definitions apply here too
			return true;
		}
		else if (firstType instanceof AnyType) {
			return false;
		}
		else if (firstType instanceof InvalidType) {
			return true;
		}
		else if (secondType instanceof InvalidType) {
			return false;
		}
		else if (firstType instanceof VoidType) {
			return true;
		}
		else if (secondType instanceof VoidType) {
			return false;
		}
		else if (firstType instanceof Metaclass<?>) {
			if (secondType instanceof Metaclass<?>) {
				return conformsToMetaclass((Metaclass<?>)firstType, (Metaclass<?>)secondType, bindings);
			}
			// Drop-through and maybe match xxClassifoer<xx> against OclType
		}
		else if (firstType instanceof CollectionType) {
			if (secondType instanceof CollectionType) {
				return conformsToCollectionType((CollectionType)firstType, (CollectionType)secondType, bindings);
			}
			return false;
		}
		else if (firstType instanceof LambdaType) {
			if (secondType instanceof LambdaType) {
				return conformsToLambdaType((LambdaType)firstType, (LambdaType)secondType, bindings);
			}
			return false;
		}
		else if (firstType instanceof TupleType) {
			if (secondType instanceof TupleType) {
				return conformsToTupleType((TupleType)firstType, (TupleType)secondType, bindings);
			}
			return false;
		}
		for (Type superClass : getSuperClasses(firstType)) {
			if ((superClass != null) && conformsTo(superClass, secondType, bindings)) {
				return true;
			}
		}
//		List<TemplateBinding> templateBindings = actualType.getTemplateBinding();
//		if (templateBindings.size() > 0) {
//			TemplateableElement template = PivotUtil.getUnspecializedTemplateableElement(actualType);
//			return conformsToClass((org.eclipse.ocl.examples.pivot.Class)template, requiredType);
//		}
		return false;
	}

	@Override
	public boolean conformsToCollectionType(@NonNull DomainCollectionType firstCollectionType, @NonNull DomainCollectionType secondCollectionType) {
		Map<TemplateParameter, ParameterableElement> bindings = secondCollectionType instanceof EObject ? PivotUtil.getAllTemplateParametersAsBindings((EObject) secondCollectionType) : null;
		return conformsToCollectionType((CollectionType)firstCollectionType, (CollectionType)secondCollectionType, bindings);	// FIXME cast
	}

	protected boolean conformsToCollectionType(@NonNull CollectionType firstType, @NonNull CollectionType secondType,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		CollectionType unspecializedFirstType = PivotUtil.getUnspecializedTemplateableElement(firstType);
		CollectionType unspecializedSecondType = PivotUtil.getUnspecializedTemplateableElement(secondType);
		if (!isSuperClassOf(unspecializedSecondType, unspecializedFirstType)) {
			return false;
		}
		Type firstElementType = firstType.getElementType();
		Type secondElementType = secondType.getElementType();
		if ((firstElementType == null) || (secondElementType == null)) {
			return false;
		}
		IntegerValue firstLower = firstType.getLowerValue();
		IntegerValue secondLower = secondType.getLowerValue();
		if (firstLower.compareTo(secondLower) < 0) {
			return false;
		}
		IntegerValue firstUpper = firstType.getUpperValue();
		IntegerValue secondUpper = secondType.getUpperValue();
		if (firstUpper.compareTo(secondUpper) > 0) {
			return false;
		}
		if (bindings != null) {
//			if (firstElementType != null) {
				TemplateParameter firstTemplateParameter = firstElementType.getOwningTemplateParameter();
				if (firstTemplateParameter != null) {
					ParameterableElement parameterableElement = bindings.get(firstTemplateParameter);
					if (parameterableElement instanceof Type) {
						firstElementType = (Type) parameterableElement;
					}
				}
//			}
//			if (secondElementType != null) {
				TemplateParameter secondTemplateParameter = secondElementType.getOwningTemplateParameter();
				if (secondTemplateParameter != null) {
					ParameterableElement parameterableElement = bindings.get(secondTemplateParameter);
					if (parameterableElement instanceof Type) {
						secondElementType = (Type) parameterableElement;
					}
					else if ((parameterableElement == null) && bindings.containsKey(secondTemplateParameter)) {
						bindings.put(secondTemplateParameter, firstElementType);
						return true;
					}
				}
//			}
		}
		if (firstElementType == secondElementType) {
			return true;
		}
		else if (firstElementType instanceof UnspecifiedType) {
			Type lowerBound = ((UnspecifiedType)firstElementType).getLowerBound();
			if ((lowerBound != null) && conformsTo(secondElementType, lowerBound, bindings)) {
				((UnspecifiedType)firstElementType).setLowerBound(secondElementType);
				return true;
			}
			else {
				return false;
			}
		}
		else if (secondElementType instanceof UnspecifiedType) {
			Type upperBound = ((UnspecifiedType)secondElementType).getUpperBound();
			if ((upperBound != null) && conformsTo(upperBound, firstElementType, bindings)) {
				((UnspecifiedType)secondElementType).setUpperBound(firstElementType);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return conformsTo(firstElementType, secondElementType, bindings);
		}
	}

	protected boolean conformsToLambdaType(@NonNull LambdaType actualType, @NonNull LambdaType requiredType,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		Type actualContextType = actualType.getContextType();
		Type requiredContextType = requiredType.getContextType();
		if ((actualContextType == null) || (requiredContextType == null)) {
			return false;
		}
		if (!conformsTo(actualContextType, requiredContextType, bindings)) {
			return false;
		}
		Type actualResultType = actualType.getResultType();
		Type requiredResultType = requiredType.getResultType();
		if ((actualResultType == null) || (requiredResultType == null)) {
			return false;
		}
		if (!conformsTo(requiredResultType, actualResultType, bindings)) {	// contravariant
			return false;
		}
		List<Type> actualParameterTypes = actualType.getParameterType();
		List<Type> requiredParameterTypes = requiredType.getParameterType();
		int iMax = actualParameterTypes.size();
		if (iMax != requiredParameterTypes.size()) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			Type actualParameterType = actualParameterTypes.get(i);
			Type requiredParameterType = requiredParameterTypes.get(i);
			if ((actualParameterType == null) || (requiredParameterType == null)) {
				return false;
			}
			if (!conformsTo(actualParameterType, requiredParameterType, bindings)) {
				return false;
			}
		}
		return true;
	}

	protected boolean conformsToMetaclass(@NonNull Metaclass<?> firstType, @NonNull Metaclass<?> secondType,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		Type firstElementType = firstType.getInstanceType();
		Type secondElementType = secondType.getInstanceType();
		if (bindings != null) {
			TemplateParameter firstTemplateParameter = firstElementType.getOwningTemplateParameter();
			if (firstTemplateParameter != null) {
				ParameterableElement parameterableElement = bindings.get(firstTemplateParameter);
				if (parameterableElement instanceof Type) {
					firstElementType = (Type) parameterableElement;
				}
			}
			TemplateParameter secondTemplateParameter = secondElementType.getOwningTemplateParameter();
			if (secondTemplateParameter != null) {
				ParameterableElement parameterableElement = bindings.get(secondTemplateParameter);
				if (parameterableElement instanceof Type) {
					secondElementType = (Type) parameterableElement;
				}
				else if ((parameterableElement == null) && bindings.containsKey(secondTemplateParameter)) {
					bindings.put(secondTemplateParameter, firstElementType);
					return true;
				}
			}
		}
		if ((firstElementType == null) || (secondElementType == null)) {
			return false;
		}
		else if (firstElementType instanceof UnspecifiedType) {
			Type lowerBound = ((UnspecifiedType)firstElementType).getLowerBound();
			if ((lowerBound != null) && conformsTo(secondElementType, lowerBound, bindings)) {
				((UnspecifiedType)firstElementType).setLowerBound(secondElementType);
				return true;
			}
			else {
				return false;
			}
		}
		else if (secondElementType instanceof UnspecifiedType) {
			Type upperBound = ((UnspecifiedType)secondElementType).getUpperBound();
			if ((upperBound != null) && conformsTo(upperBound, firstElementType, bindings)) {
				((UnspecifiedType)secondElementType).setUpperBound(firstElementType);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return conformsTo(firstElementType, secondElementType, bindings);
		}
	}

	protected boolean conformsToTupleType(@NonNull TupleType actualType, @NonNull TupleType requiredType,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		List<Property> actualProperties = actualType.getOwnedAttribute();
		List<Property> requiredProperties = requiredType.getOwnedAttribute();
		if (actualProperties.size() != requiredProperties.size()) {
			return false;
		}
		for (Property actualProperty : actualProperties) {
			Property requiredProperty = DomainUtil.getNamedElement(requiredProperties, actualProperty.getName());
			if (requiredProperty == null) {
				return false;
			}
			Type actualPropertyType = actualProperty.getType();
			Type requiredPropertyType = requiredProperty.getType();
			if ((actualPropertyType == null) || (requiredPropertyType == null)) {
				return false;
			}
			if (!conformsTo(actualPropertyType, requiredPropertyType, bindings)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @since 3.5
	 */
	public @NonNull BooleanLiteralExp createBooleanLiteralExp(boolean booleanSymbol) {
		BooleanLiteralExp asBoolean = PivotFactory.eINSTANCE.createBooleanLiteralExp();
		asBoolean.setBooleanSymbol(booleanSymbol);
		asBoolean.setType(getBooleanType());
		asBoolean.setIsRequired(true);
		return asBoolean;
	}

	protected @NonNull PivotIdResolver createIdResolver() {
		return new PivotIdResolver(this);
	}

	/**
	 * @since 3.5
	 */
	public @NonNull IfExp createIfExp(@NonNull OperationCallExp asCondition, @NonNull OCLExpression asThen, @NonNull OCLExpression asElse) {
		Type commonType = getCommonType(DomainUtil.nonNullState(asThen.getType()), DomainUtil.nonNullState(asElse.getType()), null);
		IfExp asIf = PivotFactory.eINSTANCE.createIfExp();
		asIf.setCondition(asCondition);
		asIf.setThenExpression(asThen);
		asIf.setElseExpression(asElse);
		asIf.setType(commonType);
		asIf.setIsRequired(true);
		return asIf;
	}
	
	protected @NonNull ImplementationManager createImplementationManager() {
		return new ImplementationManager(this);
	}

	/**
	 * @since 3.5
	 */
	public @NonNull IntegerLiteralExp createIntegerLiteralExp(@NonNull Number integerSymbol) {
		IntegerLiteralExp asInteger = PivotFactory.eINSTANCE.createIntegerLiteralExp();
		asInteger.setIntegerSymbol(integerSymbol);
		asInteger.setType(getIntegerType());
		asInteger.setIsRequired(true);
		return asInteger;
	}

	public @NonNull InvalidLiteralExp createInvalidExpression(/*Object object, String boundMessage, Throwable e*/) {
		InvalidLiteralExp invalidLiteralExp = PivotFactory.eINSTANCE.createInvalidLiteralExp();
		invalidLiteralExp.setType(getOclInvalidType());
//		invalidLiteralExp.setObject(object);
//		invalidLiteralExp.setReason(boundMessage);
//		invalidLiteralExp.setThrowable(e);
		return invalidLiteralExp;
	}

	protected @NonNull LambdaTypeManager createLambdaManager() {
		return new LambdaTypeManager(this);
	}

	/**
	 * @since 3.5
	 */
	public @NonNull NullLiteralExp createNullLiteralExp() {
		NullLiteralExp asNull = PivotFactory.eINSTANCE.createNullLiteralExp();
		asNull.setType(getOclVoidType());
		asNull.setIsRequired(false);
		return asNull;
	}

	protected @NonNull Orphanage createOrphanage() {
		return Orphanage.getOrphanage(asResourceSet);
	}

	@Deprecated
	public @NonNull <T extends org.eclipse.ocl.examples.pivot.Package> T createPackage(@NonNull Class<T> pivotClass,
			@NonNull EClass pivotEClass, @NonNull String name, @Nullable String nsURI) {
		return createPackage(pivotClass, pivotEClass, name, nsURI, null);
	}

	/**
	 * @since 3.5
	 */
	public @NonNull <T extends org.eclipse.ocl.examples.pivot.Package> T createPackage(@NonNull Class<T> pivotClass,
			@NonNull EClass pivotEClass, @NonNull String name, @Nullable String nsURI, @Nullable PackageId packageId) {
		@SuppressWarnings("unchecked")
		T asPackage = (T) pivotEClass.getEPackage().getEFactoryInstance().create(pivotEClass);
		asPackage.setName(name);
		if (packageId != null) {
			((PackageImpl)asPackage).setPackageId(packageId);
		}
		asPackage.setNsURI(nsURI);
		return asPackage;
	}

	protected @NonNull PackageManager createPackageManager() {
		return new PackageManager(this);
	}

	protected @NonNull PrecedenceManager createPrecedenceManager() {
		PrecedenceManager precedenceManager = new PrecedenceManager();
		List<String> errors = precedenceManager.compilePrecedences(asLibraries);
		for (String error : errors) {
			logger.error(error);
		}
		return precedenceManager;
	}

	@Deprecated // since Kepler M7 use getResource
	public @NonNull ASResource createResource(@NonNull URI uri, @Nullable String contentType) {
		return getResource(uri, contentType);
	}

	/**
	 * @since 3.5
	 */
	public @NonNull RealLiteralExp createRealLiteralExp(@NonNull Number realSymbol) {
		RealLiteralExp asReal = PivotFactory.eINSTANCE.createRealLiteralExp();
		asReal.setRealSymbol(realSymbol);
		asReal.setType(getRealType());
		asReal.setIsRequired(true);
		return asReal;
	}

	public @NonNull Root createRoot(String externalURI) {
		return createRoot(Root.class, PivotPackage.Literals.ROOT, externalURI);
	}

	@Deprecated // Since Luna M3
	public @NonNull Root createRoot(String name, String externalURI) {
		return createRoot(Root.class, PivotPackage.Literals.ROOT, externalURI);
	}

	@Deprecated // Since Luna M3
	public @NonNull <T extends Root> T createRoot(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, String name, String externalURI) {
		return createRoot(pivotClass, pivotEClass, externalURI);
	}

	public @NonNull <T extends Root> T createRoot(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, String externalURI) {
		assert pivotEClass != null;
		@SuppressWarnings("unchecked")
		T pivotRoot = (T) pivotEClass.getEPackage().getEFactoryInstance().create(pivotEClass);
		pivotRoot.setExternalURI(externalURI);
		return pivotRoot;
	}

	/**
	 * @since 3.5
	 */
	public @NonNull StringLiteralExp createStringLiteralExp(@NonNull String stringSymbol) {
		StringLiteralExp asString = PivotFactory.eINSTANCE.createStringLiteralExp();
		asString.setStringSymbol(stringSymbol);
		asString.setType(getStringType());
		asString.setIsRequired(true);
		return asString;
	}
	
	protected @NonNull TupleTypeManager createTupleManager() {
		return new TupleTypeManager(this);
	}

	/**
	 * @since 3.5
	 */
	public @NonNull UnlimitedNaturalLiteralExp createUnlimitedNaturalLiteralExp(@NonNull Number unlimitedNaturalSymbol) {
		UnlimitedNaturalLiteralExp asUnlimitedNatural = PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
		asUnlimitedNatural.setUnlimitedNaturalSymbol(unlimitedNaturalSymbol);
		asUnlimitedNatural.setType(getUnlimitedNaturalType());
		asUnlimitedNatural.setIsRequired(true);
		return asUnlimitedNatural;
	}

	public @NonNull UnspecifiedType createUnspecifiedType() {
		String value = "<unspecified:" + unspecifiedTypeCount++ + ">";
		UnspecifiedType unspecifiedType = PivotFactory.eINSTANCE.createUnspecifiedType();
		unspecifiedType.setName(value);
		unspecifiedType.setLowerBound(getOclAnyType());
		unspecifiedType.setUpperBound(getOclVoidType());
		addOrphanClass(unspecifiedType);
		return unspecifiedType;
	}

	@Override
	public void dispose() {
		if (listeners != null) {
			List<MetaModelManagerListener> savedListeners = listeners;
			listeners = null;
			for (MetaModelManagerListener listener : savedListeners) {
				listener.metaModelManagerDisposed(this);
			}
		}
//		System.out.println("dispose AS " + DomainUtil.debugSimpleName(asResourceSet));
		asResourceSet.eAdapters().remove(this);
		for (Resource resource : asResourceSet.getResources()) {
			resource.unload();
		}
		asResourceSet.getResources().clear();
		asResourceSet.setPackageRegistry(null);
		asResourceSet.setResourceFactoryRegistry(null);
		asResourceSet.setURIConverter(null);
//		asResourceSet.setURIResourceMap(null);
		asLibraries.clear();	
		asLibraryResource = null;
		StandaloneProjectMap.dispose(asResourceSet);
		ResourceSetImpl externalResourceSet2 = externalResourceSet;
		if (externalResourceSet2 != null) {
//			System.out.println("dispose CS " + DomainUtil.debugSimpleName(externalResourceSet));
			StandaloneProjectMap.dispose(externalResourceSet2);
			externalResourceSet2.setPackageRegistry(null);
			externalResourceSet2.setResourceFactoryRegistry(null);
			externalResourceSet2.setURIConverter(null);
			externalResourceSet2.setURIResourceMap(null);
			List<Resource> resources = externalResourceSet2.getResources();
			for (int i = resources.size(); --i >= 0; ) {
				resources.get(i).unload();
			}
			externalResourceSet = null;
		}
		globalNamespaces.clear();
		globalTypes.clear();
		external2PivotMap.clear();
		lockingAnnotation = null;
		idResolver.dispose();
		packageManager.dispose();
		if (tupleManager != null) {
			tupleManager.dispose();
			tupleManager = null;
		}
		if (lambdaManager != null) {
			lambdaManager.dispose();
			lambdaManager = null;
		}
		if (precedenceManager != null) {
			precedenceManager.dispose();
			precedenceManager = null;
		}
		if (implementationManager != null) {
			implementationManager.dispose();
			implementationManager = null;
		}
		orphanage = null;
		asMetamodel = null;
		super.dispose();
	}

	@Override
	protected void finalize() throws Throwable {
		if (liveMetaModelManagers != null) {
			System.out.println("Finalize " + PivotUtil.debugSimpleName(this));		
			List<MetaModelManager> keySet = new ArrayList<MetaModelManager>(liveMetaModelManagers.keySet());
			if (!keySet.isEmpty()) {
				StringBuilder s = new StringBuilder();
				s.append(" live");
				for (MetaModelManager metaModelManager : keySet) {
					s.append(" @" + Integer.toHexString(metaModelManager.hashCode()));		
				}
				System.out.println(s);		
			}
		}
	}
	
//	public @Nullable PackageTracker findPackageTracker(@NonNull DomainPackage asPackage) {
//		return packageManager.findPackageTracker(asPackage);
//	}
	
//	public @Nullable TypeTracker findTypeTracker(@NonNull Type pivotType) {
//		return packageManager.findTypeTracker(pivotType);
//	}

	/**
	 * Return all constraints applicable to a type and its superclasses.
	 */
	public @NonNull Iterable<Constraint> getAllInvariants(@NonNull Type pivotType) {
		Set<Constraint> knownInvariants = new HashSet<Constraint>();
		for (DomainType partialSuperType : getPartialTypes(pivotType)) {
			if (partialSuperType instanceof Type) {
				DomainPackage partialPackage = partialSuperType.getPackage();
				if (!(partialPackage instanceof PackageImpl) || !((PackageImpl)partialPackage).isIgnoreInvariants()) {
					knownInvariants.addAll(((Type)partialSuperType).getOwnedInvariant());
				}
			}
		}
		for (DomainType superType : getAllSuperClasses(pivotType)) {
			if (superType != null) {
				for (DomainType partialSuperType : getPartialTypes(superType)) {
					if (partialSuperType instanceof Type) {
						DomainPackage partialPackage = partialSuperType.getPackage();
						if (!(partialPackage instanceof PackageImpl) || !((PackageImpl)partialPackage).isIgnoreInvariants()) {
							knownInvariants.addAll(((Type)partialSuperType).getOwnedInvariant());
						}
					}
				}
			}
		}
		return knownInvariants;
	}
	
	public @NonNull Iterable<? extends DomainOperation> getAllOperations(@NonNull DomainType type, @Nullable FeatureFilter featureFilter) {
		TypeServer typeServer = packageManager.getTypeServer(type);
		return typeServer.getAllOperations(featureFilter);
	}
	
	public @NonNull Iterable<? extends DomainOperation> getAllOperations(@NonNull DomainType type, @Nullable FeatureFilter featureFilter, @NonNull String name) {
		TypeServer typeServer = packageManager.getTypeServer(type);
		return typeServer.getAllOperations(featureFilter, name);
	}

	public @NonNull Iterable<? extends DomainOperation> getAllOperations(@NonNull DomainOperation pivotOperation) {
		DomainInheritance pivotClass = pivotOperation.getInheritance(this);
		if (pivotClass == null) {
			throw new IllegalStateException("Missing owning type");
		}
		TypeServer typeServer = packageManager.findTypeServer(pivotClass);
		if (typeServer != null) {
			Iterable<? extends DomainOperation> memberOperations = typeServer.getMemberOperations(pivotOperation);
			if (memberOperations != null) {
				return memberOperations;
			}
		}
		@SuppressWarnings("null") @NonNull List<DomainOperation> singletonList = Collections.singletonList(pivotOperation);
		return singletonList;
	}

	@Override
	public @NonNull Iterable<PackageServer> getAllPackages() {
		if (!libraryLoadInProgress && (asMetamodel == null))  {
			getASMetamodel();
		}
		return packageManager.getAllPackages();
	}
	
	public @NonNull Iterable<? extends DomainProperty> getAllProperties(@NonNull DomainType type, @Nullable FeatureFilter featureFilter) {
		TypeServer typeServer = packageManager.getTypeServer(type);
		return typeServer.getAllProperties(featureFilter);
	}
	
	public @NonNull Iterable<? extends DomainProperty> getAllProperties(@NonNull DomainType type, @Nullable FeatureFilter featureFilter, @NonNull String name) {
		TypeServer typeServer = packageManager.getTypeServer(type);
		return typeServer.getAllProperties(featureFilter, name);
	}

	public @NonNull Iterable<? extends DomainProperty> getAllProperties(@NonNull DomainProperty pivotProperty) {
		DomainInheritance pivotClass = pivotProperty.getInheritance(this);
		if (pivotClass == null) {
			throw new IllegalStateException("Missing owning type");
		}
		TypeServer typeServer = packageManager.findTypeServer(pivotClass);
		if (typeServer != null) {
			Iterable<? extends DomainProperty> memberProperties = typeServer.getMemberProperties(pivotProperty);
			if (memberProperties != null) {
				return memberProperties;
			}
		}
		@SuppressWarnings("null") @NonNull List<DomainProperty> singletonList = Collections.singletonList(pivotProperty);
		return singletonList;
	}
	
	public @NonNull Iterable<? extends DomainType> getAllSuperClasses(@NonNull DomainType type) {
		TypeServer typeServer = packageManager.getTypeServer(type);
		return typeServer.getAllSuperClasses();
	}

	@Deprecated
	public @NonNull Iterable<Type> getAllTypes(@NonNull Type pivotType) {
//		if (pivotType == null) {
//			return EMPTY_TYPE_LIST;
//		}
//		return getTypeTracker(pivotType).getTypeServer().getTypes();
		TypeServer typeServer = packageManager.findTypeServer(pivotType);
		if (typeServer != null) {
			@SuppressWarnings("null") @NonNull Iterable<Type> filter = Iterables.filter(typeServer.getPartialTypes(), Type.class);
			return filter;
		}
		else  {
			@SuppressWarnings("null") @NonNull List<Type> singletonList = Collections.singletonList(pivotType);
			return singletonList;
		}
	}
	
	public @Nullable DomainPackage getASMetamodel() {
		if ((asMetamodel == null) && autoLoadASMetamodel) {
			org.eclipse.ocl.examples.pivot.Package stdlibPackage = null;
			getOclAnyType();				// Load a default library if necessary.
			if (!asLibraries.isEmpty()) {
				stdlibPackage = asLibraries.get(0);
			}
			if (stdlibPackage != null) {
				loadASMetamodel(stdlibPackage);				
			}
		}
		return asMetamodel;
	}

	public @NonNull ResourceSet getASResourceSet() {
		return asResourceSet;
	}

	public @NonNull CollectionType getBagType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getBagType(getType(elementType), lower, upper);
	}

	public @NonNull CollectionType getBagType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(getBagType(), elementType, lower, upper);
	}

	public @Nullable OpaqueExpression getBodyExpression(@NonNull Operation operation) {
		OpaqueExpression bodyExpression = null;
		for (DomainOperation domainOperation : getAllOperations(operation)) {
			if (domainOperation instanceof Operation) {
				OpaqueExpression anExpression = ((Operation)domainOperation).getBodyExpression();
				if (anExpression != null) {
					if (bodyExpression != null) {
						throw new IllegalStateException("Multiple bodies for " + operation);
					}
					else {
						bodyExpression = anExpression; //PivotUtil.getExpressionInOCL(operation, anExpression);
					}
				}
			}
		}
		return bodyExpression;
	}

	public @NonNull CollectionType getCollectionType(boolean isOrdered, boolean isUnique) {
		if (isOrdered) {
			if (isUnique) {
				return getOrderedSetType();
			}
			else {
				return getSequenceType();
			}
		}
		else {
			if (isUnique) {
				return getSetType();
			}
			else {
				return getBagType();
			}
		}
	}
	
	@Override
	public @NonNull CollectionType getCollectionType(@NonNull DomainType containerType, @NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType((CollectionType)getType(containerType), getType(elementType), lower, upper);
	}

	public @NonNull CollectionType getCollectionType(boolean isOrdered, boolean isUnique, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(getCollectionType(isOrdered, isUnique), elementType, lower, upper);
	}

	public @NonNull Type getCollectionType(@NonNull String collectionTypeName, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		if (elementType.eIsProxy()) {
			return getOclInvalidType();
		}
		return getCollectionType((CollectionType)getRequiredLibraryType(collectionTypeName), elementType, lower, upper);
	}

	public @NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		assert containerType == PivotUtil.getUnspecializedTemplateableElement(containerType);
		TemplateSignature templateSignature = containerType.getOwnedTemplateSignature();
		if (templateSignature == null) {
			throw new IllegalArgumentException("Collection type must have a template signature");
		}
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		if (templateParameters.size() != 1) {
			throw new IllegalArgumentException("Collection type must have exactly one template parameter");
		}
		boolean isUnspecialized = elementType == templateParameters.get(0).getParameteredElement();
		if (isUnspecialized) {
			return containerType;	
		}
		TypeServer typeServer2 = getTypeServer(containerType);
		CollectionTypeServer typeServer = (CollectionTypeServer) typeServer2;
		@SuppressWarnings("unchecked")
		T specializedType = (T) typeServer.getSpecializedType(elementType, lower, upper);
		return specializedType;
	}

	public @NonNull Set<DomainInheritance> getCommonClasses(@NonNull Type leftClass, @NonNull Type rightClass, @NonNull Set<DomainInheritance> commonClasses) {
		if (conformsTo(rightClass, leftClass, null)) {
			commonClasses.add(leftClass.getInheritance(this));
		}
		for (Type superClass : leftClass.getSuperClass()) {
			if (superClass != null) {
				Set<DomainInheritance> commonSuperClasses = getCommonClasses(superClass, rightClass, commonClasses);
				commonClasses.addAll(commonSuperClasses);
			}
		}
		return commonClasses;
	}
	
	public @NonNull Type getCommonType(@NonNull Type leftType, @NonNull Type rightType, @Nullable Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions) {
		if (leftType instanceof UnspecifiedType) {
			((UnspecifiedType)leftType).setUpperBound(rightType);
			return rightType;
		}
		if (rightType instanceof UnspecifiedType) {
			((UnspecifiedType)rightType).setUpperBound(leftType);
			return leftType;
		}
		if ((leftType instanceof TupleType) && (rightType instanceof TupleType)) {
			TupleTypeManager tupleManager = getTupleManager();
			Type commonType = tupleManager.getCommonType((TupleType)leftType, (TupleType)rightType, templateParameterSubstitutions);
			if (commonType == null) {
				commonType = getOclAnyType();
			}
			return commonType;
		}
		if ((leftType instanceof CollectionType) && (rightType instanceof CollectionType)) {
			DomainInheritance leftInheritance = leftType.getInheritance(this);
			DomainInheritance rightInheritance = rightType.getInheritance(this);
			DomainInheritance commonInheritance = leftInheritance.getCommonInheritance(rightInheritance);
			Type commonCollectionType = getType(commonInheritance); 
			Type leftElementType = DomainUtil.nonNullModel(((CollectionType)leftType).getElementType());
			Type rightElementType = DomainUtil.nonNullModel(((CollectionType)rightType).getElementType());
			Type commonElementType = getCommonType(leftElementType, rightElementType, templateParameterSubstitutions); 
			return getCollectionType(commonCollectionType, commonElementType, null, null);
		}
		if (conformsTo(leftType, rightType, templateParameterSubstitutions)) {
			return rightType;
		}
		if (conformsTo(rightType, leftType, templateParameterSubstitutions)) {
			return leftType;
		}
		DomainInheritance leftInheritance = leftType.getInheritance(this);
		DomainInheritance rightInheritance = rightType.getInheritance(this);
		DomainInheritance commonInheritance = leftInheritance.getCommonInheritance(rightInheritance);
		return getType(commonInheritance); 
	}

	public @NonNull String getDefaultStandardLibraryURI() {
		return defaultStandardLibraryURI;
	}

	public @Nullable OpaqueExpression getDefaultExpression(@NonNull Property property) {
		OpaqueExpression defaultExpression = null;
		for (DomainProperty domainProperty : getAllProperties(property)) {
			if (domainProperty instanceof Property) {
				OpaqueExpression anExpression = ((Property)domainProperty).getDefaultExpression();
				if (anExpression != null) {
					if (defaultExpression != null) {
						throw new IllegalStateException("Multiple derivations for " + property);
					}
					else {
						defaultExpression = anExpression; //PivotUtil.getExpressionInOCL(property, anExpression);
					}
				}
			}
		}
		return defaultExpression;
	}

	public @Nullable <T extends EObject> T getEcoreOfPivot(@NonNull Class<T> ecoreClass, @NonNull Element element) {
		EObject eTarget = element.getETarget();
		if (eTarget != null) {
			if (!ecoreClass.isAssignableFrom(eTarget.getClass())) {
				logger.error("Ecore " + eTarget.getClass().getName() + "' element is not a '" + ecoreClass.getName() + "'"); //$NON-NLS-1$
				return null;
			}
			@SuppressWarnings("unchecked")
			T castTarget = (T) eTarget;
			return castTarget;
		}
		Root root = (Root)EcoreUtil.getRootContainer(element);
		Resource metaModel = element.eResource();
		if (metaModel == null) {
			return null;
		}
		if (metaModel instanceof OCLstdlib) {		// Not really a model so no Ecore
			return null;
		}
		URI ecoreURI = DomainUtil.nonNullEMF(URI.createURI(root.getExternalURI()).appendFileExtension("ecore"));
		Pivot2Ecore converter = new Pivot2Ecore(this, ecoreURI, null);
		converter.convertResource(metaModel, ecoreURI);					// FIXME install ETargets
		return converter.getCreated(ecoreClass, element);
	}

	/**
	 * Return an ElementExtension for asStereotype reusing any that already exist in asElementExtensions.
	 */
	public @NonNull ElementExtension getElementExtension(@NonNull Element asStereotypedElement, @NonNull Stereotype asStereotype) {
		List<ElementExtension> extensions = asStereotypedElement.getExtension();
		for (ElementExtension asElementExtension : extensions) {
			if (asElementExtension.getStereotype() == asStereotype) {
				return asElementExtension;
			}
		}
		@SuppressWarnings("null")@NonNull ElementExtension asElementExtension = PivotFactory.eINSTANCE.createElementExtension();
		asElementExtension.setStereotype(asStereotype);
		asElementExtension.setName(((NamedElement)asStereotypedElement).getName() + "$" + asStereotype.getName());	// FIXME cast
//		asElementExtension.getSuperClass().add(getOclAnyType());
		extensions.add(asElementExtension);
		return asElementExtension;
	}

	public @NonNull ResourceSet getExternalResourceSet() {
		ResourceSetImpl externalResourceSet2 = externalResourceSet;
		if (externalResourceSet2 == null) {
			externalResourceSet2 = externalResourceSet = new ResourceSetImpl();
			StandaloneProjectMap projectMap = getProjectMap();
			projectMap.initializeResourceSet(externalResourceSet2);			
			externalResourceSet2.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emof", new EMOFResourceFactoryImpl()); //$NON-NLS-1$
			MetaModelManagerResourceSetAdapter.getAdapter(externalResourceSet2, this);
			ASResourceFactoryRegistry.INSTANCE.configureResourceSet(externalResourceSet2);
		}
		return externalResourceSet2;
	}

	public @Nullable GenPackage getGenPackage(@NonNull String nsURI) {
		if (genPackageMap != null) {
			GenPackage genPackage = genPackageMap.get(nsURI);
			if (genPackage != null) {
				return genPackage;
			}
		}
		ResourceSet externalResourceSet = getExternalResourceSet();
		URI uri = EMF_2_9.EcorePlugin.getEPackageNsURIToGenModelLocationMap(false).get(nsURI);
		if (uri != null) {
			Resource resource = externalResourceSet.getResource(uri, true);
			for (EObject eObject : resource.getContents()) {
				if (eObject instanceof GenModel) {
					for (GenPackage genPackage : ((GenModel)eObject).getGenPackages()) {
						if (genPackage != null) {
							return genPackage;
						}
					}
				}
			}
		}
		return null;
	}

	public @NonNull Set<Map.Entry<String, DomainNamespace>> getGlobalNamespaces() {
		@SuppressWarnings("null")
		@NonNull Set<Entry<String, DomainNamespace>> entrySet = globalNamespaces.entrySet();
		return entrySet;
	}

	public @NonNull Iterable<Type> getGlobalTypes() {
		return globalTypes;
	}

	public @NonNull PivotIdResolver getIdResolver() {
		return idResolver;
	}
	
	public @NonNull LibraryFeature getImplementation(@NonNull Feature feature) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		LibraryFeature implementation = feature.getImplementation();
		if (implementation == null) {
			ImplementationManager implementationManager = getImplementationManager();
			implementation = implementationManager.loadImplementation(feature);
			if (implementation == null) {
				implementation = UnsupportedOperation.INSTANCE;
			}
		}
		return implementation;
	}
	
	public @NonNull LibraryOperation getImplementation(@NonNull Operation operation) {
		LibraryOperation implementation = (LibraryOperation) operation.getImplementation();
		if (implementation == null) {
			ImplementationManager implementationManager = getImplementationManager();
			implementation = implementationManager.getOperationImplementation(operation);
			operation.setImplementation(implementation);
		}
		return implementation;
	}

	public @NonNull LibraryProperty getImplementation(@Nullable Object sourceValue, @NonNull Property property) {
		LibraryProperty implementation = (LibraryProperty) property.getImplementation();
		if (implementation == null) {
			ImplementationManager implementationManager = getImplementationManager();
			implementation = implementationManager.getPropertyImplementation(sourceValue, property);
			property.setImplementation(implementation);
		}
		return implementation;
	}
	
	public @NonNull ImplementationManager getImplementationManager() {
		ImplementationManager implementationManager2 = implementationManager;
		if (implementationManager2 == null) {
			implementationManager2 = implementationManager = createImplementationManager();
		}
		return implementationManager2;
	}

	public @Nullable Precedence getInfixPrecedence(@NonNull String operatorName) {
		PrecedenceManager precedenceManager = getPrecedenceManager();
		return precedenceManager.getInfixPrecedence(operatorName);
	}

	public @NonNull DomainInheritance getInheritance(@NonNull DomainType type) {
		Type type1 = getType(type);
		Type unspecializedType = (Type) type1.getUnspecializedElement();
		Type theType = unspecializedType != null ? unspecializedType : type1;
		TypeServer typeServer = getTypeServer(theType);
		return typeServer;
	}

	public @NonNull LambdaTypeManager getLambdaManager() {
		LambdaTypeManager lambdaManager2 = lambdaManager;
		if (lambdaManager2 == null) {
			lambdaManager2 = lambdaManager = createLambdaManager();
		}
		return lambdaManager2;
	}
	   
	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		LambdaTypeManager lambdaManager = getLambdaManager();
		return lambdaManager.getLambdaType(typeName, contextType, parameterTypes, resultType, bindings);
	}
	
	public @NonNull List<Library> getLibraries() { return asLibraries; }
	public @Nullable Resource getLibraryResource() { return asLibraryResource; }

	public @Nullable Type getLibraryType(@NonNull String string, @NonNull List<? extends ParameterableElement> templateArguments) {
		Type libraryType = getRequiredLibraryType(string);
		return getLibraryType(libraryType, templateArguments);
	}

	public @NonNull <T extends Type> T getLibraryType(@NonNull T libraryType, @NonNull List<? extends ParameterableElement> templateArguments) {
//		assert !(libraryType instanceof CollectionType);
		assert !(libraryType instanceof Metaclass<?>);
		assert libraryType == PivotUtil.getUnspecializedTemplateableElement(libraryType);
		TemplateSignature templateSignature = libraryType.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature != null ? templateSignature.getOwnedParameter() : EMPTY_TEMPLATE_PARAMETER_LIST;
		if (templateParameters.isEmpty()) {
			return libraryType;
		}
		if (templateArguments.size() != templateParameters.size()) {
			throw new IllegalArgumentException("Incorrect template bindings for template type");
		}
		boolean isUnspecialized = isUnspecialized(templateParameters, templateArguments);
		if (isUnspecialized) {
			return libraryType;	
		}
		TypeServer libraryTypeServer = getTypeServer(libraryType);
		if (libraryTypeServer instanceof TemplateableTypeServer) {
			TemplateableTypeServer typeServer = (TemplateableTypeServer) libraryTypeServer;
			@SuppressWarnings("unchecked")
			T specializedType = (T) typeServer.getSpecializedType(templateArguments);
			return specializedType;
		}
		else if (libraryTypeServer instanceof MetaclassServer) {
			MetaclassServer typeServer = (MetaclassServer) libraryTypeServer;
			assert templateArguments.size() == 1;
			ParameterableElement parameterableElement = templateArguments.get(0);
			assert parameterableElement instanceof Type;
			@SuppressWarnings("unchecked")
			T specializedType = (T) typeServer.getMetaclass((Type) parameterableElement);
			return specializedType;
		}
		else if (libraryTypeServer instanceof CollectionTypeServer) {
			CollectionTypeServer typeServer = (CollectionTypeServer) libraryTypeServer;
			assert templateArguments.size() == 1;
			ParameterableElement parameterableElement = templateArguments.get(0);
			assert parameterableElement instanceof Type;
			@SuppressWarnings("unchecked")
			T specializedType = (T) typeServer.getSpecializedType((Type) parameterableElement, null, null);
			return specializedType;
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	public @NonNull Iterable<TypeServer> getLocalClasses(@NonNull org.eclipse.ocl.examples.pivot.Package pkg) {
		return getPackageServer(pkg).getMemberTypes();
	}

	public Iterable<Comment> getLocalComments(@NonNull Operation operation) {
		if (operation.getOwningTemplateParameter() != null) {
			return EMPTY_COMMENT_LIST;
		}
		else {
			return new CompleteElementCommentsIterable(getAllOperations(operation));
		}
	}

	public @NonNull Iterable<Comment> getLocalComments(@NonNull Property property) {
		if (property.getOwningTemplateParameter() != null) {
			return EMPTY_COMMENT_LIST;
		}
		else {
			return new CompleteElementCommentsIterable(getAllProperties(property));
		}
	}

	public @NonNull Iterable<Comment> getLocalComments(@NonNull Type type) {
//		if (type == null) {
//			return EMPTY_COMMENT_LIST;
//		}
		if (type.getOwningTemplateParameter() != null) {
			return EMPTY_COMMENT_LIST;
		}
		else {
			type = PivotUtil.getUnspecializedTemplateableElement(type);
			return new CompleteElementCommentsIterable(getAllTypes(type));
		}
	}

/*	public @NonNull Iterable<Constraint> getLocalConstraints(@NonNull Operation operation) {
		if (operation.getOwningTemplateParameter() != null) {
			return EMPTY_CONSTRAINT_LIST;
		}
		else {
			return new CompleteElementConstraintsIterable(getAllOperations(operation));
		}
	} */

/*	public @NonNull Iterable<Constraint> getLocalConstraints(@NonNull Property property) {
		if (property.getOwningTemplateParameter() != null) {
			return EMPTY_CONSTRAINT_LIST;
		}
		else if (property.eContainer() instanceof TupleType) {			// FIXME Find a better way
			return EMPTY_CONSTRAINT_LIST;
		}
		else {
			return new CompleteElementConstraintsIterable(getAllProperties(property));
		}
	} */

	public @NonNull Iterable<Constraint> getLocalInvariants(@NonNull Type type) {
//		if (type == null) {
//			return EMPTY_CONSTRAINT_LIST;
//		}
		if (type.getOwningTemplateParameter() != null) {
			return EMPTY_CONSTRAINT_LIST;
		}
		else {
			type = PivotUtil.getUnspecializedTemplateableElement(type);
			return new CompleteElementInvariantsIterable(getAllTypes(type));
		}
	}

	public @Nullable EObject getLockingObject() {
		return lockingAnnotation;
	}

	public @NonNull Iterable<Operation> getMemberOperations(@NonNull Type type, boolean selectStatic) {
		if (type.getOwningTemplateParameter() != null) {
			return EMPTY_OPERATION_LIST;
		}
		else {
			type = PivotUtil.getUnspecializedTemplateableElement(type);
			return new CompleteTypeOperationsIterable(getAllTypes(type), selectStatic);
		}
	}

	public @NonNull Iterable<? extends PackageServer> getMemberPackages(@NonNull DomainPackage pkg) {
		return getPackageServer(pkg).getMemberPackages();
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return this;
	}

	public @Nullable String getMetamodelNsURI(@NonNull EPackage ePackage) {
		for (ASResourceFactory asResourceFactory : ASResourceFactoryRegistry.INSTANCE.getResourceFactories()) {
			String metamodelNsURI = asResourceFactory.getMetamodelNsURI(ePackage);
			if (metamodelNsURI != null) {
				return metamodelNsURI;
			}
		}
		return null;
	}

	public @NonNull Iterable<Property> getMemberProperties(@NonNull Type type, boolean selectStatic) {
		if (type.getOwningTemplateParameter() != null) {
			return EMPTY_PROPERTY_LIST;
		}
		else {
			type = PivotUtil.getUnspecializedTemplateableElement(type);
			return new CompleteClassPropertiesIterable(getAllTypes(type), selectStatic);
		}
	}

	public @NonNull Metaclass<?> getMetaclass(@NonNull DomainType domainInstanceType) {
		Type instanceType;
		if (domainInstanceType instanceof Type) {
			instanceType = (Type)domainInstanceType;
		}
		else {
			instanceType = getType(domainInstanceType);
		}
		Metaclass<?> metaclassType =  getMetaclassType();
		if (instanceType == metaclassType) {
			return metaclassType;
		}
		TemplateSignature templateSignature = metaclassType.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		boolean isUnspecialized = instanceType == templateParameters.get(0).getParameteredElement();	// Checked in getMetaclassType().
		if (isUnspecialized) {
			return metaclassType;	
		}
		MetaclassServer typeServer = (MetaclassServer) getTypeServer(metaclassType);
		Metaclass<?> metaclass = typeServer.getMetaclass(instanceType);
		return metaclass;
	}

	/**
	 * @since 3.5
	 */
	public @NonNull PackageId getMetapackageId(@NonNull DomainPackage dPackage) {
		if (dPackage instanceof PivotObjectImpl) {
			EObject eTarget = ((PivotObjectImpl)dPackage).getETarget();
			if (eTarget != null) {
				EClass eClass = eTarget.eClass();
				if (eClass != null) {
					EPackage ePackage = eClass.getEPackage();
					if (ePackage instanceof UMLPackage) {
						return IdManager.getRootPackageId(DomainConstants.UML_METAMODEL_NAME);
					}
					else if (ePackage instanceof TypesPackage) {
						return IdManager.getRootPackageId(DomainConstants.TYPES_METAMODEL_NAME);
					}
//					if (ePackage instanceof EcorePackage) {
//						return IdManager.getRootPackageId(DomainConstants.ECORE_METAMODEL_NAME);
//					}
				}
			}
		}
		return IdManager.METAMODEL;
	}

	@Override
	public DomainType getMetaType(@NonNull DomainType instanceType) {
		if (instanceType instanceof PrimitiveType) {
			return getPivotType(TypeId.PRIMITIVE_TYPE_NAME);
		}
//		throw new UnsupportedOperationException();
		return getMetaclass(instanceType);
	}

	protected @NonNull Type getMutable(@NonNull Type asType) {
//		if ("Class".equals(asType.getName())) {
//			System.out.println("Got it");
//		}
		Resource asResource = asType.eResource();
		if (DomainUtil.isRegistered(asResource)) {
			for (DomainType domainType : getPartialTypes(asType)) {
				if ((domainType != asType) && (domainType instanceof Type)) {
					Type asPartialType = (Type)domainType;
					if (!DomainUtil.isRegistered(asPartialType.eResource())) {
						if (CREATE_MUTABLE_CLONE.isActive()) {
							CREATE_MUTABLE_CLONE.println(asType + " " + DomainUtil.debugSimpleName(asType) + " => " + DomainUtil.debugSimpleName(asPartialType));
						}
						return asPartialType;
					}
				}
			}
			Resource clonedResource = null;
			org.eclipse.ocl.examples.pivot.Package asPackage = asType.getPackage();
			String name = DomainUtil.nonNullModel(asPackage.getName());
			String nsPrefix = DomainUtil.nonNullModel(asPackage.getNsPrefix());
			String nsURI = DomainUtil.nonNullModel(asPackage.getNsURI());
			if (asPackage instanceof Library) {
				String uriString = DomainUtil.nonNullModel(asResource.getURI().toString());
				clonedResource = OCLstdlib.create(uriString, name, nsPrefix, nsURI);
			}
			else if (asResource instanceof OCLMetaModel) {
				org.eclipse.ocl.examples.pivot.Package mutableMetamodel = OCLMetaModel.create(this, name, nsPrefix, nsURI);
				clonedResource = mutableMetamodel.eResource();
			}
			if (clonedResource != null) {
				installResource(clonedResource);
				asResourceSet.getResources().add(clonedResource);
			}
			else {
				throw new UnsupportedOperationException("No cloned type");
			}
			for (DomainType domainType : getPartialTypes(asType)) {
				if ((domainType != asType) && (domainType instanceof Type)) {
					Type asPartialType = (Type)domainType;
					if (!DomainUtil.isRegistered(asPartialType.eResource())) {
						if (CREATE_MUTABLE_CLONE.isActive()) {
							CREATE_MUTABLE_CLONE.println(asType + " " + DomainUtil.debugSimpleName(asType) + " => " + DomainUtil.debugSimpleName(asPartialType));
						}
						return asPartialType;
					}
				}
			}
			throw new UnsupportedOperationException("No cloned library type " + asType);
		}
		if (CREATE_MUTABLE_CLONE.isActive()) {
			CREATE_MUTABLE_CLONE.println(asType + " " + DomainUtil.debugSimpleName(asType));
		}
		return asType;
	}

	@Override
	public DomainPackage getNestedPackage(@NonNull DomainPackage domainPackage, @NonNull String name) {
		PackageServer packageServer = getPackageServer(domainPackage);
		return packageServer.getMemberPackage(name);
	}

	@Override
	public DomainType getNestedType(@NonNull DomainPackage domainPackage, @NonNull String name) {
		PackageServer packageServer = getPackageServer(domainPackage);
		return packageServer.getMemberType(name);
	}

	@Override
	public DomainPackage getNsURIPackage(@NonNull String nsURI) {
		return packageManager.getPackageByURI(nsURI);
	}

	public @Nullable DomainType getOclType(@NonNull String typeName) {
		Type pivotType = getPivotType(typeName);
		return pivotType != null ? getInheritance(pivotType) : null;
	}

	@Override
	public @Nullable DomainElement getOperationTemplateParameter(@NonNull DomainOperation anOperation, int index) {
		if (anOperation instanceof Operation) {
			anOperation = PivotUtil.getUnspecializedTemplateableElement((Operation)anOperation);
		}
		TypeTemplateParameter templateParameter = (TypeTemplateParameter) anOperation.getTypeParameters().get(index);
		ParameterableElement parameteredElement = templateParameter.getParameteredElement();
		if (!(parameteredElement instanceof DomainType)) {
			throw new UnsupportedOperationException();
		}
		return parameteredElement;
	}

	public @NonNull CollectionType getOrderedSetType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getOrderedSetType(getType(elementType), lower, upper);
	}

	public @NonNull CollectionType getOrderedSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(getOrderedSetType(), elementType, lower, upper);
	}

	public @NonNull Orphanage getOrphanage() {
		Orphanage orphanage2 = orphanage;
		if (orphanage2 == null) {
			orphanage2 = orphanage = createOrphanage();
		}
		return orphanage2;
	}

	public PackageManager getPackageManager() {
		return packageManager;
	}
	
	public @NonNull PackageServer getPackageServer(@NonNull DomainPackage asPackage) {
		if (!libraryLoadInProgress && asMetamodel == null) {
			getASMetamodel();
		}
		return packageManager.getPackageServer(asPackage);
	}

	/**
	 * Return a parserContext suitable for parsing OCL expressions in the context of a pivot element.
	 * 
	 * @throws ParserException if eObject cannot be converted to a Pivot element
	 */
	public @Nullable ParserContext getParserContext(@NonNull Element element, Object... todoParameters) {
		Element pivotElement = element;
		if (element instanceof OpaqueExpression) {
			EObject pivotContainer = pivotElement.eContainer();
			if (pivotContainer instanceof Operation) {							// Operation.bodyExpression
				Operation pivotOperation = (Operation) pivotContainer;
				return new OperationContext(this, null, pivotOperation, null);
			}
			if (pivotContainer instanceof Property) {
				Property pivotProperty = (Property) pivotContainer;
				return new PropertyContext(this, null, pivotProperty);
			}
			if (pivotContainer instanceof Constraint) {							// Operation.pre/postCondition
				EObject pivotContainerContainer = pivotContainer.eContainer();
				if (pivotContainerContainer instanceof Operation) {				
					Operation pivotOperation = (Operation) pivotContainerContainer;
					String resultName = null;
					if (pivotOperation.getPostcondition().contains(pivotContainer)) {
						Type resultType = pivotOperation.getType();
						if ((resultType != null) && !(resultType instanceof VoidType)) {
							resultName = Environment.RESULT_VARIABLE_NAME;
						}
					}
					return new OperationContext(this, null, pivotOperation, resultName);
				}
				if (pivotContainerContainer instanceof Type) {				
					Type pivotType = (Type) pivotContainerContainer;
					return new ClassContext(this, null, pivotType);
				}
			}
		}
		//
		//	The JUnit tests are satisfied by the new code above. The following provides legacy support, perhaps satisfying unusual invocations
		//
		if (pivotElement instanceof Constraint) {
			EObject pivotContainer = pivotElement.eContainer();
			if (pivotContainer instanceof Operation) {
				Operation pivotOperation = (Operation) pivotContainer;
				String resultName = null;
				if (pivotOperation.getPostcondition().contains(pivotElement)) {
					Type resultType = pivotOperation.getType();
					if ((resultType != null) && !(resultType instanceof VoidType)) {
						resultName = Environment.RESULT_VARIABLE_NAME;
					}
				}
				return new OperationContext(this, null, pivotOperation, resultName);
			}
		}
		else if (pivotElement instanceof OpaqueExpression) {
			EObject pivotContainer = pivotElement.eContainer();
			if (pivotContainer instanceof Operation) {
				Operation pivotOperation = (Operation) pivotContainer;
				return new OperationContext(this, null, pivotOperation, null);
			}
		}
		if (pivotElement instanceof Property) {
			return new PropertyContext(this, null, (Property) pivotElement);
		}
		else if (pivotElement instanceof Operation) {
			return new OperationContext(this, null, (Operation) pivotElement, null);
		}
		else if (pivotElement instanceof OppositePropertyCallExp) {
			Property referredOppositeProperty = ((OppositePropertyCallExp) pivotElement).getReferredProperty();
			if (referredOppositeProperty != null) {
				Property referredProperty = referredOppositeProperty.getOpposite();
				if (referredProperty != null) {
					return new PropertyContext(this, null, referredProperty);
				}
			}
		}
		else if (pivotElement instanceof PropertyCallExp) {
			Property referredProperty = ((PropertyCallExp) pivotElement).getReferredProperty();
			if (referredProperty != null) {
				return new PropertyContext(this, null, referredProperty);
			}
		}
		else if (pivotElement instanceof OperationCallExp) {
			Operation referredOperation = ((OperationCallExp) pivotElement).getReferredOperation();
			if (referredOperation != null) {
				return new OperationContext(this, null, referredOperation, null);
			}
		}
		else if (pivotElement instanceof LoopExp) {
			Iteration referredIteration = ((LoopExp) pivotElement).getReferredIteration();
			if (referredIteration != null) {
				return new OperationContext(this, null, referredIteration, null);
			}
		}
//		else if (pivotElement instanceof Stereotype) {
//			Stereotype pivotStereotype = (Stereotype) pivotElement;
//			return new ClassContext(this, null, pivotStereotype);
//		}
//		else if (pivotElement instanceof org.eclipse.ocl.examples.pivot.Class) {
//			org.eclipse.ocl.examples.pivot.Class pivotClass = (org.eclipse.ocl.examples.pivot.Class) pivotElement;
////			Metaclass<?> metaClass = getMetaclass(pivotClass);
//			return new ClassContext(this, null, pivotClass);
//		}
		else {		// Class, Stereotype, State
			for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
				if ((eObject instanceof Type) && (((Type)eObject).getPackage() != null)) {	// StateMachines etc do not have Packages
					return new ClassContext(this, null, (Type)eObject);
				}
			}
		}
		return null;
	}

	public @NonNull Iterable<? extends DomainPackage> getPartialPackages(@NonNull DomainPackage pkg, boolean loadASMetamodelFirst) {
		if (!libraryLoadInProgress && loadASMetamodelFirst && (asMetamodel == null)) {
			getASMetamodel();
		}
		PackageServer packageServer = packageManager.getPackageServer(pkg);
		return packageServer.getPartialPackages();
	}

	public @NonNull Iterable<? extends DomainType> getPartialTypes(@NonNull DomainType pivotType) {
		TypeServer typeServer = packageManager.getTypeServer(pivotType);
		return typeServer.getPartialTypes();
	}

	public @Nullable <T extends Element> T getPivotOf(@NonNull Class<T> pivotClass, @Nullable EObject eObject) throws ParserException {
		if (eObject != null) {
			ASResourceFactory bestHelper = ASResourceFactoryRegistry.INSTANCE.getResourceFactory(eObject);
			if (bestHelper != null) {
				return bestHelper.getASElement(this, pivotClass, eObject);
			}
		}
		return null;
	}

	public @Nullable <T extends Element> T getPivotOfEcore(@NonNull Class<T> pivotClass, @Nullable EObject eObject) {
		if (eObject == null) {
			return null;
		}
		Resource metaModel = eObject.eResource();
		if (metaModel == null) {
			return null;
		}
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(metaModel, this);
		if (ecore2Pivot == null) {
			return null;
		}
		return ecore2Pivot.getCreated(pivotClass, eObject);
	}

	/**
	 * Return the pivot model class for className with the Pivot Model.
	 */
	public @Nullable Type getPivotType(@NonNull String className) {
		if (asMetamodel == null) {
			getASMetamodel();
			if (asMetamodel == null) {
				return null;
			}
		}
		return (Type) DomainUtil.getNamedElement(asMetamodel.getOwnedType(), className);		// FIXME bad cast
	}	

	@SuppressWarnings("null")
	protected @NonNull PrecedenceManager getPrecedenceManager() {
		if (precedenceManager == null) {
			synchronized (this) {
				if (precedenceManager == null) {
					synchronized (this) {
						precedenceManager = createPrecedenceManager();
					}
				}
			}
		}
		return precedenceManager;
	}

//	public Iterable<? extends Nameable> getPrecedences(org.eclipse.ocl.examples.pivot.Package asPackage) {
//		return asPackage.getOwnedPrecedence(); // FIXME make package independent
//	}
	
	public @Nullable Precedence getPrefixPrecedence(@NonNull String operatorName) {
		PrecedenceManager precedenceManager = getPrecedenceManager();
		return precedenceManager.getPrefixPrecedence(operatorName);
	}

	@SuppressWarnings("unchecked")
	public @NonNull <T extends EObject> T getPrimaryElement(@NonNull T element) {
		if (element instanceof DomainOperation) {
			return (T) getPrimaryOperation((DomainOperation)element);
		}
		else if (element instanceof DomainPackage) {
			return (T) getPrimaryPackage((DomainPackage)element);
		}
		else if (element instanceof DomainProperty) {
			return (T) getPrimaryProperty((DomainProperty)element);
		}
		else if (element instanceof Type) {
			return (T) getPrimaryType((DomainType)element);
		} 
		return element;
	}

	public @NonNull DomainOperation getPrimaryOperation(@NonNull DomainOperation pivotOperation) {
		DomainInheritance pivotClass = pivotOperation.getInheritance(this);
		if (pivotClass != null) {					// Null for an EAnnotation element
			TypeServer typeServer = packageManager.findTypeServer(pivotClass);
			if (typeServer != null) {
				DomainOperation operation = typeServer.getMemberOperation(pivotOperation);
				if (operation != null) {
					return operation;
				}
			}
		}
		return pivotOperation;
	}

	/**
	 * Lookup a primary package by its URI and optionally a sub-package path.
	 */
	public @Nullable PackageServer getPrimaryPackage(@NonNull String nsURI, String... subPackagePath) {
		PackageServer packageServer = packageManager.getPackageByURI(nsURI);
		if (packageServer == null) {
			return null;
		}
		if (subPackagePath != null) {
			for (String subPackageName : subPackagePath) {
				if (subPackageName == null) {
					return null;
				}
				packageServer = packageServer.getMemberPackage(subPackageName);
				if (packageServer == null) {
					return null;
				}
			}
		}
		return packageServer;
	}

	/**
	 * Lookup a primary sub-package.
	 *
	public @Nullable PackageServer getPrimaryPackage(@NonNull DomainPackage parentPackage, @NonNull String subPackageName) {
		PackageTracker packageTracker = packageManager.findPackageTracker(parentPackage);
		if (packageTracker != null) {
			return packageTracker.getPackageServer().getMemberPackage(subPackageName);
		}
		else {
			return PivotUtil.getNamedElement(parentPackage.getNestedPackage(), subPackageName);
		}
	} */

	public @NonNull DomainPackage getPrimaryPackage(@NonNull DomainPackage aPackage) {
		return getPackageServer(aPackage).getPivotPackage();
//		PackageTracker packageTracker = packageManager.findPackageTracker(asPackage);
//		if (packageTracker != null) {
//			return packageTracker.getPrimaryPackage();
//		}
//		else {
//			return asPackage;
//		}
	}

	public @NonNull DomainProperty getPrimaryProperty(@NonNull DomainProperty pivotProperty) {
		if ((pivotProperty instanceof Property) && (((Property)pivotProperty).eContainer() instanceof TupleType)) {		// FIXME Find a better way
			return pivotProperty;
		}
		DomainInheritance owningInheritance = pivotProperty.getInheritance(this);
		if (owningInheritance != null) {
			@NonNull String name = DomainUtil.nonNullModel(pivotProperty.getName());
			DomainProperty opposite = pivotProperty.getOpposite();
			String oppositeName = opposite != null ? opposite.getName() : null;
			TypeServer typeServer = packageManager.getTypeServer(owningInheritance);
			Iterator<? extends DomainProperty> memberProperties = typeServer.getMemberProperties(name);
			if (memberProperties != null) {
				while (memberProperties.hasNext()) {
					DomainProperty memberProperty = memberProperties.next();
					if ((memberProperty != null) && (memberProperty.isStatic() == pivotProperty.isStatic())) {
						DomainProperty memberOpposite = memberProperty.getOpposite();
						String memberOppositeName = memberOpposite != null ? memberOpposite.getName() : null;
						if ((oppositeName == null) || oppositeName.equals(memberOppositeName)) {
							return memberProperty;
						}
					}
				}
			}
		}
		return pivotProperty;
	}

	public @NonNull Type getPrimaryType(@NonNull DomainType type) {
		if (/*(type instanceof Type) &&*/ !isTypeServeable(type)) {
			return (Type) type;			// FIXME bad cast
		}
		return getTypeServer(type).getPivotType();
//		TypeTracker typeTracker = packageManager.findTypeTracker(pivotType);
//		if (typeTracker != null) {
//			return typeTracker.getPrimaryType();
//		}
//		else {
//			return pivotType;
//		}
	}

	public @Nullable org.eclipse.ocl.examples.pivot.Type getPrimaryType(@NonNull String nsURI, @NonNull String path, String... extraPath) {
		PackageServer packageServer = packageManager.getPackageByURI(nsURI);
		if (packageServer == null) {
			return null;
		}
		if ((extraPath == null) || (extraPath.length == 0)) {
			return packageServer.getMemberType(path);
		}
		else {
			packageServer = packageServer.getMemberPackage(path);
			if (packageServer == null) {
				return null;
			}
			int iMax = extraPath.length-1;
			for (int i = 0; i < iMax; i++) {
				String subPackageName = extraPath[i];
				if (subPackageName == null) {
					return null;
				}
				packageServer = packageServer.getMemberPackage(subPackageName);
				if (packageServer == null) {
					return null;
				}
			}
			String subPackageName = extraPath[iMax];
			if (subPackageName == null) {
				return null;
			}
			return packageServer.getMemberType(subPackageName);
		}
	}

	/**
	 * Return the ProjectMap used to resolve EPackages for the extertnalResourceSet.
	 */
	public @NonNull StandaloneProjectMap getProjectMap() {
		return ProjectMap.getAdapter(asResourceSet);
	}

	/**
	 * Lookup a primary type.
	 *
	public @Nullable Type getPrimaryType(@NonNull PackageServer parentPackage, @NonNull String typeName) {
		PackageServer packageServer = packageManager.getPackageServer(parentPackage);
		return packageServer.getMemberType(typeName);
//		PackageTracker packageTracker = packageManager.getPackageTracker(parentPackage);
//		if (packageTracker != null) {
//			return packageTracker.getPackageServer().getMemberType(typeName);
//		}
//		else {
//			return PivotUtil.getNamedElement(getLocalClasses(parentPackage), typeName);
//			return PivotUtil.getNamedElement(parentPackage.getOwnedType(), typeName);
//		}
	} */

	public @NonNull ASResource getResource(@NonNull URI uri, @Nullable String contentType) {
		Object asResourceFactory = asResourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().get(contentType);
		if (asResourceFactory == null) {
			throw new IllegalStateException("No registration for content type '" + contentType + "'");
		} else if (!(asResourceFactory instanceof ASResourceFactory)) {
			throw new IllegalStateException("Non ASResourceFactory registration for content type '" + contentType + "'");
		}
		Resource asResource = asResourceSet.getResource(uri, false);
		if (asResource == null) {
			asResource = asResourceSet.createResource(uri, contentType);
		}
		if (asResource == null) {
			throw new IllegalStateException("Failed to create '" + uri + "'");
		} else if (!(asResource instanceof ASResource)) {
			throw new IllegalStateException("Non ASResource created for content type '" + contentType + "'");
		}
		return (ASResource)asResource;
	}
	
	/**
	 * Return the URI to be used for a concrete syntax resource for an expression associated
	 * with a uniqueContext. If uniqueContext is an Element the moniker is used as
	 * part of the URI, otherwise a unique value is created and cached for reuse.
	 * 
	 * @deprecated URIs are auto-generated
	 */
	@Deprecated
	public URI getResourceIdentifier(Object uniqueContext, String subContext) {
		return URI.createURI(EcoreUtil.generateUUID() + ".essentialocl");
	}

	@Override
	public @Nullable org.eclipse.ocl.examples.pivot.Package getRootPackage(@NonNull String name) {
		return packageManager.getRootPackage(name);
	}

	public @NonNull CollectionType getSequenceType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getSequenceType(getType(elementType), lower, upper);
	}

	public @NonNull CollectionType getSequenceType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(getSequenceType(), elementType, lower, upper);
	}

	public @NonNull CollectionType getSetType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getSetType(getType(elementType), lower, upper);
	}

	public @NonNull CollectionType getSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(getSetType(), elementType, lower, upper);
	}

	protected @NonNull CollectionType getSpecializedCollectionType(@NonNull CollectionType type, @NonNull Map<TemplateParameter, ParameterableElement> usageBindings) {
		CollectionType unspecializedType = PivotUtil.getUnspecializedTemplateableElement(type);
		Map<TemplateParameter, ParameterableElement> typeBindings = PivotUtil.getAllTemplateParametersAsBindings(type);
		PivotUtil.getAllTemplateParameterSubstitutions(typeBindings, type);
		if ((typeBindings != null) && !typeBindings.isEmpty()) {
			rebindTemplateBindings(typeBindings, usageBindings);	//	Re-bind the type bindings to use those of the usage.
			TemplateParameter templateParameter = unspecializedType.getOwnedTemplateSignature().getOwnedParameter().get(0);
			ParameterableElement templateArgument = typeBindings.get(templateParameter);
			if (templateArgument == null) {
				templateArgument = templateParameter.getParameteredElement();
			}
			if (templateArgument instanceof Type) {
				Type templateTypeArgument = (Type)templateArgument;
				templateTypeArgument = getSpecializedType(templateTypeArgument, usageBindings);
				return getCollectionType(unspecializedType, templateTypeArgument, null, null);
			}
		}
		return type;
	}

	protected @NonNull Type getSpecializedLambdaType(@NonNull LambdaType type, @Nullable Map<TemplateParameter, ParameterableElement> usageBindings) {
		String typeName = DomainUtil.nonNullModel(type.getName());
		Type contextType = DomainUtil.nonNullModel(type.getContextType());
		@NonNull List<Type> parameterType = type.getParameterType();
		Type resultType = DomainUtil.nonNullModel(type.getResultType());
		LambdaType specializedLambdaType = getLambdaType(typeName, contextType, parameterType, resultType, usageBindings);
		return specializedLambdaType;
	}

	protected @NonNull Metaclass<?> getSpecializedMetaclass(@NonNull Metaclass<?> type, @NonNull Map<TemplateParameter, ParameterableElement> usageBindings) {
		Map<TemplateParameter, ParameterableElement> typeBindings = PivotUtil.getAllTemplateParametersAsBindings(type);
//		Map<TemplateParameter, ParameterableElement> typeBindings = PivotUtil.getAllTemplateParametersAsBindings(getMetaclassType());		// unspecType gets lost in save
		PivotUtil.getAllTemplateParameterSubstitutions(typeBindings, type);
		if ((typeBindings != null) && !typeBindings.isEmpty()) {
			rebindTemplateBindings(typeBindings, usageBindings);	//	Re-bind the type bindings to use those of the usage.
			TemplateParameter templateParameter = getMetaclassType().getOwnedTemplateSignature().getOwnedParameter().get(0);
			ParameterableElement templateArgument = typeBindings.get(templateParameter);
			if (templateArgument == null) {
//				templateArgument = templateParameter.getParameteredElement();
//				assert templateArgument != null;
				templateArgument = getOclAnyType();
			}
			if (templateArgument instanceof Type) {
				templateArgument = getSpecializedType((Type)templateArgument, usageBindings);
			}
			return getMetaclass((DomainType) templateArgument);
		}
		return type;
	}

	public @NonNull Type getSpecializedType(@NonNull Type type, @Nullable Map<TemplateParameter, ParameterableElement> usageBindings) {
		TemplateParameter owningTemplateParameter = type.getOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			if (usageBindings == null) {
				return type;
			}
			ParameterableElement parameterableElement = usageBindings.get(owningTemplateParameter);
			return parameterableElement instanceof Type ? (Type) parameterableElement : type;
		}
		else if (usageBindings == null) {
			return type;
		}
		else if (type instanceof CollectionType) {
			return getSpecializedCollectionType((CollectionType)type, usageBindings);
		}
		else if (type instanceof Metaclass<?>) {
			return getSpecializedMetaclass((Metaclass<?>)type, usageBindings);
		}
		else if (type instanceof TupleType) {
			return getTupleType((TupleType) type, usageBindings);
		}
		else if (type instanceof LambdaType) {
			return getSpecializedLambdaType((LambdaType)type, usageBindings);
		}
		else {
			//
			//	Get the bindings of the type.
			//
			Type unspecializedType = PivotUtil.getUnspecializedTemplateableElement(type);
			Map<TemplateParameter, ParameterableElement> typeBindings = PivotUtil.getAllTemplateParametersAsBindings(type);
			PivotUtil.getAllTemplateParameterSubstitutions(typeBindings, type);
			if ((typeBindings != null) && !typeBindings.isEmpty()) {
				//
				//	Re-bind the type bindings to use those of the usage.
				//
				rebindTemplateBindings(typeBindings, usageBindings);
				//
				//	Prepare the template argument list, one template argument per template parameter.
				//
				List<TemplateParameter> templateParameters = PivotUtil.getAllTemplateParameters(unspecializedType);
				if (templateParameters != null) {
					List<ParameterableElement> templateArguments = new ArrayList<ParameterableElement>(templateParameters.size());
					for (TemplateParameter templateParameter : templateParameters) {
						ParameterableElement templateArgument = typeBindings.get(templateParameter);
						if (templateArgument == null) {
							templateArgument = templateParameter.getParameteredElement();
						}
						if (templateArgument instanceof Type) {
							templateArgument = getSpecializedType((Type)templateArgument, usageBindings);
						}
						templateArguments.add(templateArgument);
					}
					return getLibraryType(unspecializedType, templateArguments);
				}
			}
		}
		return type;
	}
	
	public Iterable<Type> getSuperClasses(Type pivotType) {
		if ((pivotType == null) || (pivotType.getOwningTemplateParameter() != null)) {
			return Collections.<Type>singletonList(getOclAnyType());	// FIXME lower bound
		}
		else {
//			if (type.getTemplateBinding().size() > 0) {		// FIXME need lazy specialization
//			pivotType = PivotUtil.getUnspecializedTemplateableElement(pivotType);
//			}
			if (!libraryLoadInProgress && (asMetamodel == null) && (pivotType == getClassType()))  {
				getASMetamodel();
			}
			return new CompleteClassSuperClassesIterable(getAllTypes(pivotType));
		}
	}

	public ResourceSet getTarget() {
		return asResourceSet;
	}

	public TupleTypeManager getTupleManager() {
		if (tupleManager == null) {
			tupleManager = createTupleManager();
		}
		return tupleManager;
	}

	public @NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<? extends DomainTypedElement> parts,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		TupleTypeManager tupleManager = getTupleManager();
		return tupleManager.getTupleType(typeName, parts, bindings);
	}
	
	public @NonNull TupleType getTupleType(@NonNull TupleType tupleType, @Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		TupleTypeManager tupleManager = getTupleManager();
		return tupleManager.getTupleType(tupleType, bindings);
	}

	public @NonNull Type getType(@NonNull DomainType dType) {				// FIXME simplify eliminate
		if (dType instanceof Type) {
			return getPrimaryType(dType);
		}
		DomainPackage dPackage = dType.getPackage();
		if (dPackage != null) {
			PackageServer packageServer = getPackageServer(dPackage);
			Type primaryType = packageServer.getMemberType(dType.getName());
			if (primaryType != null) {
				return primaryType;
			}
		}
		throw new UnsupportedOperationException();		// FIXME
	}
	
	public @NonNull TypeServer getTypeServer(@NonNull DomainType pivotType) {
		if (!libraryLoadInProgress && (asMetamodel == null) && !(pivotType instanceof CollectionType) && !(pivotType instanceof VoidType) && !(pivotType instanceof InvalidType)) {
			getASMetamodel();
		}
		return packageManager.getTypeServer(pivotType);
	}

	/**
	 * Create implicit an opposite property if there is no explicit opposite.
	 */
	public void installPropertyDeclaration(@NonNull Property thisProperty) {
		// WE cannot detect ambiguous opoposites reliably since a later Property might invalide previously ok derived opposites
		if ((thisProperty.isTransient() || thisProperty.isVolatile()) && !thisProperty.isDerived()) {		// FIXME Are any exclusions justified?
			return;
		}
		Property opposite = thisProperty.getOpposite();
		if (opposite != null) {
			return;
		}
		Type thatType = thisProperty.getType();
		if (thatType instanceof CollectionType) {
			thatType = ((CollectionType)thatType).getElementType();
		}
		if ((thatType == null) || (thatType instanceof DataType)) {
			return;
		}
		Type thisType = thisProperty.getOwningType();
		if (thisType == null) {								// e.g. an EAnnotation
			return;
		}
		String name = thisType.getName();
		if (name == null) {
			return;
		}
		// If there is no implicit property with the implicit name, create one
		//   result a pair of mutual opposites		
		Property newOpposite = PivotFactory.eINSTANCE.createProperty();
		newOpposite.setImplicit(true);
		newOpposite.setName(name);
		if (thisProperty.isComposite()) {
			newOpposite.setType(thisType);
			newOpposite.setIsRequired(false);
		}
		else {
			newOpposite.setType(getCollectionType(
				PivotConstants.DEFAULT_IMPLICIT_OPPOSITE_ORDERED,
				PivotConstants.DEFAULT_IMPLICIT_OPPOSITE_UNIQUE,
				thisType,
				PivotConstants.DEFAULT_IMPLICIT_OPPOSITE_LOWER_VALUE,
				PivotConstants.DEFAULT_IMPLICIT_OPPOSITE_UPPER_VALUE));
			newOpposite.setIsRequired(true);
		}
		thatType = getMutable(thatType);
		thatType.getOwnedAttribute().add(newOpposite);		// WIP moved for debugging
		newOpposite.setOpposite(thisProperty);
		thisProperty.setOpposite(newOpposite);
	}

	public void installResource(@NonNull Resource asResource) {
		for (EObject eObject : asResource.getContents()) {
			if (eObject instanceof Root) {
				installRoot((Root)eObject);
			}
		}
		if (!libraryLoadInProgress && (asLibraryResource == null) && (asResource instanceof OCLstdlib) && (asLibraries.size() > 0)) {
			getOclAnyType();
		}
	}

	public void installRoot(@NonNull Root pivotRoot) {
		packageManager.addRoot(pivotRoot);
		for (DomainPackage asPackage : pivotRoot.getNestedPackage()) {
			if ((asPackage instanceof Library) && !asLibraries.contains(asPackage)) {
				Library asLibrary = (Library)asPackage;
				String uri = asLibrary.getNsURI();
				if (asLibraries.isEmpty()) {
					if (uri == null) {
						throw new IllegalLibraryException(OCLMessages.MissingLibraryURI_ERROR_);
					}
					setDefaultStandardLibraryURI(uri);
				}
				else {
					String libraryURI = getDefaultStandardLibraryURI();
					if ((uri != null) && !uri.equals(libraryURI)) {
						throw new IllegalLibraryException(NLS.bind(OCLMessages.ImportedLibraryURI_ERROR_, uri , libraryURI));
					}
				}
				asLibraries.add(asLibrary);
			}
		}
	}

	public boolean isAdapterFor(@NonNull MetaModelManager metaModelManager) {
		return this == metaModelManager;
	}

	public boolean isAdapterForType(Object type) {
		return type == MetaModelManager.class;
	}

	public boolean isSuperClassOf(@NonNull Type unspecializedFirstType, @NonNull Type secondType) {
		Type unspecializedSecondType = PivotUtil.getUnspecializedTemplateableElement(secondType);	// FIXME cast
		if (unspecializedFirstType == unspecializedSecondType) {
			return true;
		}
		for (Type superClass : getSuperClasses(unspecializedSecondType)) {
			if ((superClass != null) && isSuperClassOf(unspecializedFirstType, superClass)) {
				return true;
			}
		}
		return false;
	}

	public boolean isTypeServeable(@NonNull DomainType type) {
		if (!(type instanceof Type)) {
			return false;			
		}
		Type pivotType = (Type)type;
//		if (pivotType .getUnspecializedElement() != null) {
//			return false;
//		}
		if (pivotType.getOwningTemplateParameter() != null) {
			return false;
		}
//		if (pivotType instanceof UnspecifiedType) {
//			return false;
//		}
		if (pivotType instanceof LambdaType) {
			return false;
		}
//		if (pivotType instanceof TupleType) {
//			return false;
//		}
		if (pivotType.eContainer() instanceof TemplateParameterSubstitution) {
			return false;
		}
		return true;
	}
	
	/**
	 * Retyurn true if this type involves an UnspecifiedType.
	 */
	public boolean isUnderspecified(@Nullable ParameterableElement type) {
		if (type == null) {
			return false;
		}
		if (type instanceof TemplateableElement) {
			for (TemplateBinding templateBinding : ((TemplateableElement)type).getTemplateBinding()) {
				for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitution()) {
					if (isUnderspecified(templateParameterSubstitution.getActual())) {
						return true;
					}
				}
			}
		}
		if (type instanceof UnspecifiedType) {
			return true;
		}
		if (type instanceof CollectionType) {
			return isUnderspecified(((CollectionType)type).getElementType());
		}
		if (type instanceof TupleType) {
			for (Property part : ((TupleType)type).getOwnedAttribute()) {
				if (isUnderspecified(part.getType())) {
					return true;
				}
			}
		}
		if (type instanceof LambdaType) {
			LambdaType lambdaType = (LambdaType)type;
			if (isUnderspecified(lambdaType.getContextType())) {
				return true;
			}
			for (Type parameterType : lambdaType.getParameterType()) {
				if (isUnderspecified(parameterType)) {
					return true;
				}
			}
			if (isUnderspecified(lambdaType.getResultType())) {
				return true;
			}
		}
		return false;
	}

	protected boolean isUnspecialized(@NonNull List<TemplateParameter> templateParameters,
			@NonNull List<? extends ParameterableElement> templateArguments) {
		int iMax = templateParameters.size();
		assert templateArguments.size() == iMax;
		boolean isUnspecialized = true;
		for (int i = 0; i < iMax; i++) {
			if (templateArguments.get(i) != templateParameters.get(i).getParameteredElement()) {
				isUnspecialized = false;
			}
		}
		return isUnspecialized;
	}

	/**
	 * Load the Pivot MetaModel of the Pivot Model to accompany a given asLibrary.
	 * 
	 * If this asLibrary has an Element type it is assumed to be a complete custom meta-model and it is used as such.
	 * 
	 * Otherwise the built-in Pivot Metamodel is created with name, nsPrefix and nsURI determined by the given library.
	 * 
	 * @param asLibrary
	 */
	protected void loadASMetamodel(@NonNull org.eclipse.ocl.examples.pivot.Package asLibrary) {
		for (DomainPackage libPackage : getPartialPackages(asLibrary, false)) {
			if (DomainUtil.getNamedElement(libPackage.getOwnedType(), PivotPackage.Literals.ELEMENT.getName()) != null) {
				setASMetamodel(libPackage);	// Custom meta-model
				return;
			}
		}
		String name = DomainUtil.nonNullState(asLibrary.getName());
//		String nsURI = DomainUtil.nonNullState(asLibrary.getNsURI());
		org.eclipse.ocl.examples.pivot.Package oclMetamodel = OCLMetaModel.create(this, name, asLibrary.getNsPrefix(), OCLMetaModel.PIVOT_URI);
		asResourceSet.getResources().add(oclMetamodel.eResource());
		setASMetamodel(oclMetamodel);		// Standard meta-model
		@SuppressWarnings("null")
		@NonNull Resource asResource = oclMetamodel.eResource();
//		asResourceSet.getResources().add(asResource);
		installResource(asResource);
	}

	@Override
	protected @Nullable Resource loadDefaultLibrary(@Nullable String uri) {
		boolean savedLibraryLoadInProgress = libraryLoadInProgress;
		libraryLoadInProgress = true;
		try {
			if (asLibraries.isEmpty()) {
				if (uri == null) {
					return null;
				}
				StandardLibraryContribution contribution = StandardLibraryContribution.REGISTRY.get(uri);
				if (contribution == null) {
					return null;
				}
				installResource(contribution.getResource());
			}
			assert asLibraryResource == null;
			if (!asLibraries.isEmpty()) {
				asLibraryResource = asLibraries.get(0).eResource();
				for (Library asLibrary : asLibraries) {
					if (asLibrary != null) {
						PackageServer packageServer = packageManager.getPackageServer(asLibrary);
						packageServer.getMemberTypes();			// FIXME side effect of creating type trackers
						for (Type type : asLibrary.getOwnedType()) {
							if (type != null) {
								Type primaryType = getPrimaryType(type);
								if ((type == primaryType) && PivotUtil.isLibraryType(type)) {
									defineLibraryType(primaryType);
								}
							}
						}
					}
				}
			}
			return asLibraryResource;
		}
		finally {
			libraryLoadInProgress = savedLibraryLoadInProgress;
		}
	}

	public @Nullable Element loadResource(@NonNull URI uri, String alias, @Nullable ResourceSet resourceSet) throws ParserException {
		// if (EPackage.Registry.INSTANCE.containsKey(resourceOrNsURI))
		// return EPackage.Registry.INSTANCE.getEPackage(resourceOrNsURI);
		ResourceSet externalResourceSet = resourceSet != null ? resourceSet : getExternalResourceSet();
		EPackage.Registry packageRegistry = externalResourceSet.getPackageRegistry();
		URI resourceURI = uri.trimFragment();
		String uriString = resourceURI.toString();
		String fragment = uri.fragment();
		Resource resource = null;
		if (fragment == null) {
			//
			//	fragment-less URI may be explicit namespace URI
			//
			EPackage ePackage = packageRegistry.getEPackage(uriString);
			if (ePackage != null) {
				return getPivotOf(Element.class, ePackage);
			}
			//
			//	fragment-less URI may be an OCL Standard Library
			//
			if (uriString.equals(defaultStandardLibraryURI)) {
				if (asLibraryResource != null) {
					resource = asLibraryResource;
				}
				else {
					resource = loadDefaultLibrary(uriString);
				}
				if (resource instanceof XMLResource) {
					EObject eObject = ((XMLResource)resource).getEObject(fragment);
					if (eObject instanceof Element) {
						return (Element) eObject;
					}
				}
			}
			else {
				StandardLibraryContribution contribution = StandardLibraryContribution.REGISTRY.get(uriString);
				if (contribution != null) {
					resource = contribution.getResource();
				}
			}
		}
		else {
			//
			//	fragment-full URI may have a registered package to mark the unfragmented name
			//
			EPackage ePackage = packageRegistry.getEPackage(uriString);
			if (ePackage != null) {
				Resource eResource = ePackage.eResource();
				if (eResource instanceof XMLResource) {
					EObject eObject = ((XMLResource)eResource).getEObject(fragment);
					if (eObject != null) {
						Element asElement = getPivotOf(Element.class, eObject);
						if (asElement != null) {
							return asElement;
						}
					}
				}
			}
		}
		if (resource == null) {
			External2Pivot external2Pivot = external2PivotMap.get(uri);
			if (external2Pivot != null) {
				resource = external2Pivot.getResource();
			}
			else {
				try {
					resource = externalResourceSet.getResource(resourceURI, true);
				}
				catch (RuntimeException e) {
					resource = externalResourceSet.getResource(resourceURI, false);
					if (resource != null) {
						externalResourceSet.getResources().remove(resource);
						resource = null;
					}
					throw e;
				}
//				if (resource != null) {
//					if (externalResources == null) {
//						externalResources = new HashMap<URI, Resource>();
//					}
//					externalResources.put(uri, resource);
//				}
				//
				//	If this resource already loaded under its internal URI reuse old one
				//
				if (resource != null) {
					if (resource instanceof DelegatedSinglePackageResource) {
						resource = ((DelegatedSinglePackageResource)resource).getResource();
					}
					List<EObject> contents = resource.getContents();
					if (contents.size() > 0) {
						EObject firstContent = contents.get(0);
						if (firstContent != null) {
							for (ASResourceFactory resourceFactory : ASResourceFactoryRegistry.INSTANCE.getResourceFactories()) {
								URI packageURI = resourceFactory.getPackageURI(firstContent);
								if (packageURI != null) {
									External2Pivot external2Pivot2 = external2PivotMap.get(packageURI);
									if (external2Pivot2 != null) {
										Resource knownResource = external2Pivot2.getResource();
										if ((knownResource != null) && (knownResource != resource)) {
											for (EObject eContent : resource.getContents()) {
												if (eContent instanceof Pivotable) {
													Element pivot = ((Pivotable)firstContent).getPivot();
													if (pivot instanceof Root) {
														Root root = (Root)pivot;
														packageManager.removeRoot(root);
														Resource asResource = root.eResource();
														if (asResource != null) {
															asResourceSet.getResources().remove(asResource);
															asResource.unload();
														}
													}
												}
											}
											if (!resourceFactory.isCompatibleResource(resource, knownResource)) {
												logger.error("Resource '" + resource.getURI() + "' already loaded as '" + knownResource.getURI() + "'");
											}
//											resource.unload();
											resource.getResourceSet().getResources().remove(resource);
											resource = knownResource;
										}
									}
									break;
								}
							}
						}
					}
				}
			}
		}
		if (resource != null) {
			return loadResource(resource, uri);
		}
		logger.warn("Cannot load package with URI '" + uri + "'");
		return null;
	}

	/**
	 * Ensure that EPackage has been loaded in the externalResourceSet PackageRegistry.
	 */
	public EPackage loadEPackage(@NonNull EPackage ePackage) {
		ResourceSet externalResourceSet = getExternalResourceSet();
		return externalResourceSet.getPackageRegistry().getEPackage(ePackage.getNsURI());
	}

	public @Nullable Element loadResource(@NonNull Resource resource, @Nullable URI uri) throws ParserException {
		ASResourceFactory bestFactory = ASResourceFactoryRegistry.INSTANCE.getResourceFactory(resource);
		if (bestFactory != null) {
			ResourceSet resourceSet = resource.getResourceSet();
			if ((resourceSet != null) && (resourceSet != externalResourceSet)) {
				addExternalResources(resourceSet);
			}
			return bestFactory.importFromResource(this, resource, uri);
		}
		throw new ParserException("Cannot create pivot from '" + uri + "'");
//		logger.warn("Cannot convert to pivot for package with URI '" + uri + "'");
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainOperation dynamicOperation) throws SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
		return getImplementation((Operation) dynamicOperation);
	}

	public void notifyChanged(Notification notification) {}

	//
	//	Re-bind the type bindings to use those of the usage.
	//
	protected void rebindTemplateBindings(@NonNull Map<TemplateParameter, ParameterableElement> typeBindings,
			@NonNull Map<TemplateParameter, ParameterableElement> usageBindings) {
		for (TemplateParameter templateParameter : typeBindings.keySet()) {
			ParameterableElement parameterableElement = typeBindings.get(templateParameter);
			if (parameterableElement != null) {
				TemplateParameter aTemplateParameter = parameterableElement.getOwningTemplateParameter();
				if (aTemplateParameter != null) {
					ParameterableElement aParameterableElement = usageBindings.get(aTemplateParameter);
					if (aParameterableElement != null) {
						typeBindings.put(templateParameter, aParameterableElement);
					}
				}
				else if (parameterableElement instanceof SelfType) {
					ParameterableElement aParameterableElement = usageBindings.get(null);
					if (aParameterableElement != null) {
						typeBindings.put(templateParameter, aParameterableElement);
					}
				}
			}
		}
	}

	public void removeExternalResource(@NonNull External2Pivot external2Pivot) {
		external2PivotMap.remove(external2Pivot.getURI());
	}

	public void removeListener(@NonNull MetaModelManagerListener listener) {
		if (listeners != null) {
			listeners.remove(listener);
		}
	}

	/**
	 * Return all matching operations.
	 */
	protected void resolveAllOperations(@NonNull Set<Operation> allOperations, @NonNull Type forType, @Nullable FeatureFilter featureFilter, @NonNull String operationName, @NonNull List<Parameter> parameters) {
		int iMax = parameters.size();
		for (DomainOperation candidateOperation : getAllOperations(forType, featureFilter, operationName)) {
			if (candidateOperation instanceof Operation) {
				List<Parameter> candidateParameters = ((Operation)candidateOperation).getOwnedParameter();
				if (candidateParameters.size() == iMax) {
					int i = 0;
					for ( ; i < iMax; i++) {
						Type type = parameters.get(i).getType();
						Type candidateType = candidateParameters.get(i).getType();
						if (type != candidateType) {		// FIXME behavioural equivalence
							break;
						}
					}
					if (i >= iMax) {
						allOperations.add((Operation)candidateOperation);
					}
				}
			}
		}
	}

	/**
	 * Return the un-overloaded operation.
	 */
	public @NonNull Operation resolveBaseOperation(@NonNull Operation operation) {
		Set<Operation> allOperations = new HashSet<Operation>();
		@SuppressWarnings("null") @NonNull Type owningType = operation.getOwningType();
		@SuppressWarnings("null") @NonNull String operationName = operation.getName();
		@NonNull List<Parameter> ownedParameter = operation.getOwnedParameter();
		resolveAllOperations(allOperations, owningType, operation.isStatic() ? FeatureFilter.SELECT_STATIC : FeatureFilter.SELECT_NON_STATIC, operationName, ownedParameter);
		Operation baseOperation = operation;
		for (Operation candidateOperation : allOperations) {
			if (candidateOperation != operation) {
				@SuppressWarnings("null") @NonNull Type baseType = baseOperation.getOwningType();
				@SuppressWarnings("null") @NonNull Type candidateType = candidateOperation.getOwningType();
				if (conformsTo(baseType, candidateType, null)) {
					baseOperation = candidateOperation;
				}
			}
		}
		return baseOperation;
	}

	public @Nullable Set<Operation> resolveLocalOperation(@NonNull Type pivotClass, @NonNull String operationName, Type... pivotArguments) {
		@Nullable Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions = null; 	// FIXME
		Set<Operation> pivotOperations = null;
		for (Operation pivotOperation : pivotClass.getOwnedOperation()) {
			if (operationName.equals(pivotOperation.getName())) {
				List<Parameter> pivotParameters = pivotOperation.getOwnedParameter();
				if (pivotArguments.length == pivotParameters.size()) {
					boolean typesConform = true;
					for (int i = 0; i < pivotArguments.length; i++) {
						Type argumentType = pivotArguments[i];
						if (argumentType == null) {
							typesConform = false;
							break;
						}
						Parameter pivotParameter = pivotParameters.get(i);
						if (pivotParameter == null) {
							typesConform = false;
							break;
						}
						Type parameterType = PivotUtil.getType(pivotParameter);
						if (parameterType == null) {
							typesConform = false;
							break;
						}
						if (!conformsTo(argumentType, parameterType, templateParameterSubstitutions)) {
							typesConform = false;
							break;
						}
					}
					if (typesConform) {
						if (pivotOperations == null) {
							pivotOperations = new HashSet<Operation>();
						}
						pivotOperations.add(pivotOperation);
					}
				}
			}
		}
		return pivotOperations;
	}

	public Operation resolveOperation(@NonNull Type leftType, @NonNull String operationName, Type... rightTypes) {
		Set<Operation> candidateOperations = resolveOperations(leftType, operationName, rightTypes);
		if (candidateOperations == null) {
			return null;
		}
		if (candidateOperations.size() > 1) {
			logger.warn("Ambiguous operation '" + operationName + "'");
		}
		return candidateOperations.iterator().next();
	}

	public Set<Operation> resolveOperations(@NonNull Type pivotClass, @NonNull String operationName, Type... pivotArguments) {
		@SuppressWarnings("unused")
		Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions = PivotUtil.getAllTemplateParameterSubstitutions(null, pivotClass);
		Set<Operation> pivotOperations = resolveLocalOperation(pivotClass, operationName, pivotArguments);
		for (TemplateBinding templateBinding : pivotClass.getTemplateBinding()) {
			TemplateSignature signature = templateBinding.getSignature();
			TemplateableElement template = signature.getTemplate();
			if (template instanceof Type) {
				Set<Operation> morePivotOperations = resolveLocalOperation((Type) template, operationName, pivotArguments);
				if (morePivotOperations != null) {
					if (pivotOperations == null) {
						pivotOperations = morePivotOperations;
					}
					else {
						pivotOperations.addAll(morePivotOperations);
					}
				}
			}
		}
		if (pivotOperations == null) {
			List<Type> superClasses = pivotClass.getSuperClass();
			if (!superClasses.isEmpty()) {
				for (Type superClass : superClasses) {
					if (superClass != null) {
						Set<Operation> superOperations = resolveOperations(superClass, operationName, pivotArguments);
						if (superOperations != null) {
							if (pivotOperations == null) {
								pivotOperations = superOperations;
							} else {
								pivotOperations.addAll(superOperations);
							}
						}
					}
				}
			}
			else {
				AnyType oclAnyType = getOclAnyType();
				if (pivotClass != oclAnyType) {		// Typically a template parameter type
					pivotOperations = resolveOperations(oclAnyType, operationName, pivotArguments);
				}
			}
		}
		return pivotOperations;
	}

	public void setASMetamodel(DomainPackage asPackage) {
		asMetamodel = asPackage;
		String uri = asMetamodel.getNsURI();
		if (uri != null) {
			packageManager.addPackageNsURISynonym(uri, DomainConstants.METAMODEL_NAME);
		}
	}

	public void setAutoLoadASMetamodel(boolean autoLoadASMetamodel) {
		this.autoLoadASMetamodel  = autoLoadASMetamodel;
	}

	public void setDefaultStandardLibraryURI(@NonNull String defaultStandardLibraryURI) {
		assert !PivotUtil.isASURI(defaultStandardLibraryURI);
		this.defaultStandardLibraryURI = defaultStandardLibraryURI;
	}

	public void setLibraryLoadInProgress(boolean libraryLoadInProgress) {
		this.libraryLoadInProgress = libraryLoadInProgress;	
	}

	public void setMetamodelNsURI(@NonNull String metaNsURI) {
		if (asMetamodel == null) {
//			if (StandardLibraryContribution.REGISTRY.get(metaNsURI) == null) {
//				StandardLibraryContribution.REGISTRY.put(metaNsURI, new OCLstdlib.Loader());
//			}
//			setDefaultStandardLibraryURI(metaNsURI);
			getASMetamodel();
		}
		else if (!metaNsURI.equals(asMetamodel.getNsURI())) {
			packageManager.addPackageNsURISynonym(metaNsURI, DomainConstants.METAMODEL_NAME);
//			throw new IllegalMetamodelException(asMetamodel.getNsURI(), metaNsURI);
		}
	}

	public void setTarget(Notifier newTarget) {
//		assert newTarget == asResourceSet;
	}

	public void unsetTarget(Notifier oldTarget) {
//		assert oldTarget == asResourceSet;
	}
}
