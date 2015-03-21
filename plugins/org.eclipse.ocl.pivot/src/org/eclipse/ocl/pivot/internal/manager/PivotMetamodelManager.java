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
package org.eclipse.ocl.pivot.internal.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.Slot;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.WildcardType;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.PackageImpl;
import org.eclipse.ocl.pivot.internal.compatibility.EMF_2_9;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceImpl;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.CompletePackageInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.context.ClassContext;
import org.eclipse.ocl.pivot.internal.context.OperationContext;
import org.eclipse.ocl.pivot.internal.context.PropertyContext;
import org.eclipse.ocl.pivot.internal.ecore.EcoreASResourceFactory;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.library.ConstrainedOperation;
import org.eclipse.ocl.pivot.internal.library.EInvokeOperation;
import org.eclipse.ocl.pivot.internal.library.ImplementationManager;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.internal.utilities.CompleteElementIterable;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.internal.utilities.IllegalLibraryException;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.library.UnsupportedOperation;
import org.eclipse.ocl.pivot.model.OCLmetamodel;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.osgi.util.NLS;

import com.google.common.collect.Iterables;

public class PivotMetamodelManager implements MetamodelManagerInternal, Adapter.Internal
{		
	public class CompleteTypeOperationsIterable extends CompleteElementIterable<org.eclipse.ocl.pivot.Class, Operation>
	{
		protected final Boolean selectStatic;	// null for static/non-static, true for static, false for non-static
		
		public CompleteTypeOperationsIterable(@NonNull Iterable<org.eclipse.ocl.pivot.Class> types, boolean selectStatic) {
			super(types);
			this.selectStatic = selectStatic;
		}

		@Override
		protected @NonNull Iterable<Operation> getInnerIterable(@NonNull org.eclipse.ocl.pivot.Class model) {
			return ClassUtil.nonNullEMF(model.getOwnedOperations());
		}

		@Override
		protected @Nullable Operation getInnerValue(@NonNull Operation element) {
			if (selectStatic != null) {
				if (element.isIsStatic() != selectStatic.booleanValue()) {
					return null;
				}
			}
			return element;
		}
	}
	
	public class CompleteClassPropertiesIterable extends CompleteElementIterable<org.eclipse.ocl.pivot.Class, Property>
	{
		protected final Boolean selectStatic;	// null for static/non-static, true for static, false for non-static
		
		public CompleteClassPropertiesIterable(@NonNull Iterable<org.eclipse.ocl.pivot.Class> types, boolean selectStatic) {
			super(types);
			this.selectStatic = selectStatic;
		}

		@Override
		protected @NonNull Iterable<Property> getInnerIterable(@NonNull org.eclipse.ocl.pivot.Class model) {
			return ClassUtil.nonNullEMF(model.getOwnedProperties());
		}

		@Override
		protected @Nullable Property getInnerValue(@NonNull Property element) {
			if (selectStatic != null) {
				if (element.isIsStatic() != selectStatic.booleanValue()) {
					return null;
				}
			}
			return element;
		}
	}

	public class CompleteElementInvariantsIterable
			extends CompleteElementIterable<org.eclipse.ocl.pivot.Class, Constraint> {

		public CompleteElementInvariantsIterable(@NonNull Iterable<? extends org.eclipse.ocl.pivot.Class> models) {
			super(models);
		}

		@Override
		protected @NonNull Iterable<Constraint> getInnerIterable(@NonNull org.eclipse.ocl.pivot.Class model) {
			return ClassUtil.nonNullEMF(model.getOwnedInvariants());
		}
	}
	
	private static final Logger logger = Logger.getLogger(PivotMetamodelManager.class);

	public static final @NonNull TracingOption CREATE_MUTABLE_CLONE = new TracingOption(PivotPlugin.PLUGIN_ID, "mm/createMutableClone");
	
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

	/**
	 * Leak debugging aid. Set non-null to diagnose MetamodelManager construction and finalization.
	 */
	public static WeakHashMap<PivotMetamodelManager,Object> liveMetamodelManagers = null;

	/**
	 * Return the non-null MetamodelManager for which resourceSet is an AS ResourceSet, or null if not an AS ResourceSet.
	 */
	public static @Nullable PivotMetamodelManager findAdapter(@NonNull ResourceSet asResourceSet) {
		@SuppressWarnings("null")@NonNull List<Adapter> eAdapters = asResourceSet.eAdapters();
		return ClassUtil.getAdapter(PivotMetamodelManager.class, eAdapters);
	}

	/**
	 * Return the non-null MetamodelManager for the asResourceSet.
	 */
	public static @NonNull PivotMetamodelManager getAdapter(@NonNull ResourceSet asResourceSet) {
		@SuppressWarnings("null")@NonNull List<Adapter> eAdapters = asResourceSet.eAdapters();
		PivotMetamodelManager adapter = ClassUtil.getAdapter(PivotMetamodelManager.class, eAdapters);
		return ClassUtil.nonNullState(adapter);
	}
	
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	private final @NonNull StandardLibraryInternal standardLibrary;
	private final @NonNull CompleteEnvironmentInternal completeEnvironment;

	/**
	 * The known packages.
	 */
	private final @NonNull CompleteModelInternal completeModel;
	
	/**
	 * The known precedences.
	 */
	private PrecedenceManager precedenceManager = null;			// Lazily created
	
	/**
	 * The known implementation load capabilities.
	 */
	private ImplementationManager implementationManager = null;			// Lazily created

	protected org.eclipse.ocl.pivot.Package asMetamodel = null;

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
	
	private final @NonNull Map<String, Namespace> globalNamespaces = new HashMap<String, Namespace>();
	private final @NonNull Set<Type> globalTypes = new HashSet<Type>();
	
	/**
	 * Map of URI to external resource converter.
	 */
	private final @NonNull Map<URI, External2AS> external2asMap = new HashMap<URI, External2AS>();

	/**
	 * Elements protected from garbage collection
	 */
	private @Nullable EAnnotation lockingAnnotation = null;

	private boolean autoLoadASmetamodel = true;
	
	private @Nullable Map<String, GenPackage> genPackageMap = null;
	
	/**
	 * Lazily computed, eagerly invalidated analysis of final classes and operations.
	 */
	private @Nullable FinalAnalysis finalAnalysis = null;

	private @Nullable Map<Resource,External2AS> es2ases = null;

	/**
	 * Construct a MetamodelManager that will use environmentFactory to create its artefacts
	 * such as an asResourceSet to contain pivot copies of meta-models.
	 */
	public PivotMetamodelManager(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ResourceSet asResourceSet) {
		this.environmentFactory = environmentFactory;
		this.asResourceSet = asResourceSet;
		List<Adapter> asResourceSetAdapters = asResourceSet.eAdapters();
		assert !asResourceSetAdapters.contains(this);
		asResourceSetAdapters.add(this);
		assert asResourceSetAdapters.contains(environmentFactory.getProjectManager());
		completeEnvironment = environmentFactory.getCompleteEnvironment();
		standardLibrary = environmentFactory.getStandardLibrary();
		completeModel = environmentFactory.getCompleteModel();
//		System.out.println("ctor " + this);
//		initializePivotResourceSet(asResourceSet);
		if (liveMetamodelManagers != null) {
			liveMetamodelManagers.put(this, null);
			PivotUtilInternal.debugPrintln("Create " + NameUtil.debugSimpleName(this)
				+ " " + NameUtil.debugSimpleName(asResourceSet));	
		}
	}

	@Override
	public void addClassLoader(@NonNull ClassLoader classLoader) {
		ImplementationManager implementationManager = getImplementationManager();
		implementationManager.addClassLoader(classLoader);
	}

	@Override
	public void addExternal2AS(@NonNull External2AS es2as) {
		Map<Resource, External2AS> es2ases2 = es2ases;
		if (es2ases2 == null){
			es2ases = es2ases2 = new HashMap<Resource,External2AS>();
		}
		External2AS oldES2AS = es2ases2.put(es2as.getResource(), es2as);
		assert oldES2AS == null;
		URI uri = es2as.getURI();
		external2asMap.put(uri, es2as);
	}

	@Override
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

	@Override
	public @Nullable Namespace addGlobalNamespace(@NonNull String name, @NonNull Namespace namespace) {
		return globalNamespaces.put(name, namespace);
	}

	public boolean addGlobalTypes(@NonNull Collection<Type> types) {
		return globalTypes.addAll(types);
	}
	
	@Override
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
	public int compareOperationMatches(@NonNull Operation reference, @NonNull TemplateParameterSubstitutions referenceBindings,
			@NonNull Operation candidate, @NonNull TemplateParameterSubstitutions candidateBindings) {
		if ((reference instanceof Iteration) && (candidate instanceof Iteration)) {
			int iteratorCountDelta = ((Iteration)candidate).getOwnedIterators().size() - ((Iteration)reference).getOwnedIterators().size();
			if (iteratorCountDelta != 0) {
				return iteratorCountDelta;
			}
			org.eclipse.ocl.pivot.Class referenceClass = reference.getOwningClass();
			org.eclipse.ocl.pivot.Class candidateClass = candidate.getOwningClass();
			Type referenceType = referenceClass != null ? PivotUtilInternal.getType(referenceClass) : null;
			Type candidateType = candidateClass != null ? PivotUtilInternal.getType(candidateClass) : null;
			Type specializedReferenceType = referenceType != null ? completeModel.getSpecializedType(referenceType, referenceBindings) : null;
			Type specializedCandidateType = candidateType != null ? completeModel.getSpecializedType(candidateType, candidateBindings) : null;
			if ((referenceType != candidateType) && (specializedReferenceType != null) && (specializedCandidateType != null)) {
				if (conformsTo(specializedReferenceType, referenceBindings, specializedCandidateType, candidateBindings)) {
					return 1;
				}
				else if (conformsTo(specializedCandidateType, candidateBindings, specializedReferenceType, referenceBindings)) {
					return -1;
				}
			}
		}
		List<Parameter> candidateParameters = candidate.getOwnedParameters();
		List<Parameter> referenceParameters = reference.getOwnedParameters();
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
				Type referenceType = PivotUtilInternal.getBehavioralType(referenceParameter);
				Type candidateType = PivotUtilInternal.getBehavioralType(candidateParameter);
				Type specializedReferenceType = completeModel.getSpecializedType(referenceType, referenceBindings);
				Type specializedCandidateType = completeModel.getSpecializedType(candidateType, candidateBindings);
				if (referenceType != candidateType) {
					if (!conformsTo(specializedReferenceType, referenceBindings, specializedCandidateType, candidateBindings)) {
						referenceConformsToCandidate = false;
					}
					if (!conformsTo(specializedCandidateType, candidateBindings, specializedReferenceType, referenceBindings)) {
						candidateConformsToReference = false;
					}
				}
			}
		}
		if (referenceConformsToCandidate != candidateConformsToReference) {
			return referenceConformsToCandidate ? 1 : -1;
		}
		Type referenceType = ClassUtil.nonNullModel(reference.getOwningClass());
		Type candidateType = ClassUtil.nonNullModel(candidate.getOwningClass());
		Type specializedReferenceType = completeModel.getSpecializedType(referenceType, referenceBindings);
		Type specializedCandidateType = completeModel.getSpecializedType(candidateType, candidateBindings);
		if (referenceType != candidateType) {
			if (conformsTo(specializedReferenceType, referenceBindings, specializedCandidateType, candidateBindings)) {
				return 1;
			}
			else if (conformsTo(specializedCandidateType, candidateBindings, specializedReferenceType, referenceBindings)) {
				return -1;
			}
		}
		return 0;
	}

	@Override
	public boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions) {
		return completeModel.conformsTo(firstType, firstSubstitutions, secondType, secondSubstitutions);
	}

	public @NonNull BooleanLiteralExp createBooleanLiteralExp(boolean booleanSymbol) {
		BooleanLiteralExp asBoolean = PivotFactory.eINSTANCE.createBooleanLiteralExp();
		asBoolean.setBooleanSymbol(booleanSymbol);
		asBoolean.setType(standardLibrary.getBooleanType());
		asBoolean.setIsRequired(true);
		return asBoolean;
	}

	public @NonNull IfExp createIfExp(@NonNull OperationCallExp asCondition, @NonNull OCLExpression asThen, @NonNull OCLExpression asElse) {
		Type commonType = getCommonType(ClassUtil.nonNullState(asThen.getType()), TemplateParameterSubstitutions.EMPTY,
			ClassUtil.nonNullState(asElse.getType()), TemplateParameterSubstitutions.EMPTY);
		IfExp asIf = PivotFactory.eINSTANCE.createIfExp();
		asIf.setOwnedCondition(asCondition);
		asIf.setOwnedThen(asThen);
		asIf.setOwnedElse(asElse);
		asIf.setType(commonType);
		asIf.setIsRequired(true);
		return asIf;
	}

	public @NonNull IntegerLiteralExp createIntegerLiteralExp(@NonNull Number integerSymbol) {
		IntegerLiteralExp asInteger = PivotFactory.eINSTANCE.createIntegerLiteralExp();
		asInteger.setIntegerSymbol(integerSymbol);
		asInteger.setType(standardLibrary.getIntegerType());
		asInteger.setIsRequired(true);
		return asInteger;
	}

	public @NonNull InvalidLiteralExp createInvalidExpression(/*Object object, String boundMessage, Throwable e*/) {
		InvalidLiteralExp invalidLiteralExp = PivotFactory.eINSTANCE.createInvalidLiteralExp();
		invalidLiteralExp.setType(standardLibrary.getOclInvalidType());
//		invalidLiteralExp.setObject(object);
//		invalidLiteralExp.setReason(boundMessage);
//		invalidLiteralExp.setThrowable(e);
		return invalidLiteralExp;
	}

	public @NonNull NullLiteralExp createNullLiteralExp() {
		NullLiteralExp asNull = PivotFactory.eINSTANCE.createNullLiteralExp();
		asNull.setType(standardLibrary.getOclVoidType());
		asNull.setIsRequired(false);
		return asNull;
	}

	public @NonNull Orphanage createOrphanage() {
		return Orphanage.getOrphanage(asResourceSet);
	}

	/**
	 * Return a parserContext suitable for parsing OCL expressions in the context of a pivot element.
	 * 
	 * @throws ParserException if eObject cannot be converted to a Pivot element
	 */
	@Override
	public @Nullable ParserContext createParserContext(@NonNull Element element, Object... todoParameters) {
		Element pivotElement = element;
		if (element instanceof ExpressionInOCL) {
			EObject pivotContainer = pivotElement.eContainer();
			if (pivotContainer instanceof Operation) {							// Operation.bodyExpression
				Operation pivotOperation = (Operation) pivotContainer;
				return new OperationContext(environmentFactory, null, pivotOperation, null);
			}
			if (pivotContainer instanceof Property) {
				Property pivotProperty = (Property) pivotContainer;
				return new PropertyContext(environmentFactory, null, pivotProperty);
			}
			if (pivotContainer instanceof Constraint) {							// Operation.pre/postCondition
				EObject pivotContainerContainer = pivotContainer.eContainer();
				if (pivotContainerContainer instanceof Operation) {				
					Operation pivotOperation = (Operation) pivotContainerContainer;
					String resultName = null;
					if (pivotOperation.getOwnedPostconditions().contains(pivotContainer)) {
						Type resultType = pivotOperation.getType();
						if ((resultType != null) && !(resultType instanceof VoidType)) {
							resultName = PivotConstants.RESULT_NAME;
						}
					}
					return new OperationContext(environmentFactory, null, pivotOperation, resultName);
				}
				if (pivotContainerContainer instanceof org.eclipse.ocl.pivot.Class) {				
					org.eclipse.ocl.pivot.Class pivotType = (org.eclipse.ocl.pivot.Class) pivotContainerContainer;
					return new ClassContext(environmentFactory, null, pivotType, null);
				}
			}
			if (pivotContainer instanceof Slot) {
				Property asDefiningFeature = ((Slot)pivotContainer).getDefiningProperty();
				if (asDefiningFeature != null) {
					org.eclipse.ocl.pivot.Class pivotType = asDefiningFeature.getOwningClass();
					if (pivotType != null) {				
						return new ClassContext(environmentFactory, null, pivotType, null);
					}
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
				if (pivotOperation.getOwnedPostconditions().contains(pivotElement)) {
					Type resultType = pivotOperation.getType();
					if ((resultType != null) && !(resultType instanceof VoidType)) {
						resultName = PivotConstants.RESULT_NAME;
					}
				}
				return new OperationContext(environmentFactory, null, pivotOperation, resultName);
			}
		}
		
		if (pivotElement instanceof Property) {
			return new PropertyContext(environmentFactory, null, (Property) pivotElement);
		}
		else if (pivotElement instanceof Operation) {
			return new OperationContext(environmentFactory, null, (Operation) pivotElement, null);
		}
		else if (pivotElement instanceof OppositePropertyCallExp) {
			Property referredOppositeProperty = ((OppositePropertyCallExp) pivotElement).getReferredProperty();
			if (referredOppositeProperty != null) {
				Property referredProperty = referredOppositeProperty.getOpposite();
				if (referredProperty != null) {
					return new PropertyContext(environmentFactory, null, referredProperty);
				}
			}
		}
		else if (pivotElement instanceof PropertyCallExp) {
			Property referredProperty = ((PropertyCallExp) pivotElement).getReferredProperty();
			if (referredProperty != null) {
				return new PropertyContext(environmentFactory, null, referredProperty);
			}
		}
		else if (pivotElement instanceof OperationCallExp) {
			Operation referredOperation = ((OperationCallExp) pivotElement).getReferredOperation();
			if (referredOperation != null) {
				return new OperationContext(environmentFactory, null, referredOperation, null);
			}
		}
		else if (pivotElement instanceof LoopExp) {
			Iteration referredIteration = ((LoopExp) pivotElement).getReferredIteration();
			if (referredIteration != null) {
				return new OperationContext(environmentFactory, null, referredIteration, null);
			}
		}
//		else if (pivotElement instanceof Stereotype) {
//			Stereotype pivotStereotype = (Stereotype) pivotElement;
//			return new ClassContext(this, null, pivotStereotype);
//		}
//		else if (pivotElement instanceof org.eclipse.ocl.pivot.Class) {
//			org.eclipse.ocl.pivot.Class pivotClass = (org.eclipse.ocl.pivot.Class) pivotElement;
////			Metaclass<?> metaClass = getMetaclass(pivotClass);
//			return new ClassContext(this, null, pivotClass);
//		}
		else {		// Class, Stereotype, State
			for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
				if ((eObject instanceof org.eclipse.ocl.pivot.Class) && (((org.eclipse.ocl.pivot.Class)eObject).getOwningPackage() != null)) {	// StateMachines etc do not have Packages
					return new ClassContext(environmentFactory, null, (org.eclipse.ocl.pivot.Class)eObject, null);
				}
			}
		}
		return null;
	}

	protected @NonNull PrecedenceManager createPrecedenceManager() {
		PrecedenceManager precedenceManager = new PrecedenceManager();
		List<String> errors = precedenceManager.compilePrecedences(asLibraries);
		for (String error : errors) {
			logger.error(error);
		}
		return precedenceManager;
	}

	public @NonNull RealLiteralExp createRealLiteralExp(@NonNull Number realSymbol) {
		RealLiteralExp asReal = PivotFactory.eINSTANCE.createRealLiteralExp();
		asReal.setRealSymbol(realSymbol);
		asReal.setType(standardLibrary.getRealType());
		asReal.setIsRequired(true);
		return asReal;
	}

	public @NonNull StringLiteralExp createStringLiteralExp(@NonNull String stringSymbol) {
		StringLiteralExp asString = PivotFactory.eINSTANCE.createStringLiteralExp();
		asString.setStringSymbol(stringSymbol);
		asString.setType(standardLibrary.getStringType());
		asString.setIsRequired(true);
		return asString;
	}

	public @NonNull UnlimitedNaturalLiteralExp createUnlimitedNaturalLiteralExp(@NonNull Number unlimitedNaturalSymbol) {
		UnlimitedNaturalLiteralExp asUnlimitedNatural = PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
		asUnlimitedNatural.setUnlimitedNaturalSymbol(unlimitedNaturalSymbol);
		asUnlimitedNatural.setType(standardLibrary.getUnlimitedNaturalType());
		asUnlimitedNatural.setIsRequired(true);
		return asUnlimitedNatural;
	}

	public @NonNull WildcardType createWildcardType(@Nullable org.eclipse.ocl.pivot.Class lowerBound, @Nullable org.eclipse.ocl.pivot.Class upperBound) {
		WildcardType wildcardType = PivotFactory.eINSTANCE.createWildcardType();
		wildcardType.setName("?");			// Name is not significant
		wildcardType.setLowerBound(lowerBound != null ? lowerBound : standardLibrary.getOclAnyType());
		wildcardType.setUpperBound(upperBound != null ? upperBound : standardLibrary.getOclVoidType());
		return wildcardType;
	}

	public void dispose() {
//		System.out.println("dispose AS " + ClassUtil.debugSimpleName(asResourceSet));
		asResourceSet.eAdapters().remove(this);
		List<Resource> asResources = asResourceSet.getResources();
		for (Resource asResource : new ArrayList<Resource>(asResources)) {
			asResource.unload();
			asResource.eAdapters().clear();
		}
		asResources.clear();
		asResourceSet.setPackageRegistry(null);
		asResourceSet.setResourceFactoryRegistry(null);
		asResourceSet.setURIConverter(null);
//		asResourceSet.setURIResourceMap(null);
		asLibraries.clear();	
		asLibraryResource = null;
		StandaloneProjectMap projectMap = StandaloneProjectMap.findAdapter(asResourceSet);
		if (projectMap != null) {
			projectMap.unload(asResourceSet);
		}
		asResourceSet.eAdapters().clear();
//		StandaloneProjectMap.dispose(asResourceSet);
/*		ResourceSet externalResourceSet2 = externalResourceSet;
		if (externalResourceSet2 != null) {
//			System.out.println("dispose CS " + ClassUtil.debugSimpleName(externalResourceSet));
			StandaloneProjectMap projectMap2 = StandaloneProjectMap.findAdapter(externalResourceSet2);
			if (projectMap2 != null) {
				projectMap2.unload(externalResourceSet2);
				externalResourceSet2.eAdapters().remove(projectMap2);
			}
//			StandaloneProjectMap.dispose(externalResourceSet2);
			externalResourceSet2.setPackageRegistry(null);
			externalResourceSet2.setResourceFactoryRegistry(null);
			externalResourceSet2.setURIConverter(null);
			if (externalResourceSet2 instanceof ResourceSetImpl) {
				((ResourceSetImpl)externalResourceSet2).setURIResourceMap(null);
			}
			for (Resource resource : new ArrayList<Resource>(externalResourceSet2.getResources())) {
				resource.unload();
			}
			externalResourceSet = null;
		} */
		globalNamespaces.clear();
		globalTypes.clear();
		external2asMap.clear();
		if (es2ases != null) {
			for (External2AS es2as : es2ases.values()) {
				es2as.dispose();
			}
		}
		lockingAnnotation = null;
		completeModel.dispose();
		if (precedenceManager != null) {
			precedenceManager.dispose();
			precedenceManager = null;
		}
		if (implementationManager != null) {
			implementationManager.dispose();
			implementationManager = null;
		}
		asMetamodel = null;
		standardLibrary.dispose();
	}

	@Override
	protected void finalize() throws Throwable {
		if (liveMetamodelManagers != null) {
			PivotUtilInternal.debugPrintln("Finalize " + NameUtil.debugSimpleName(this));		
			List<PivotMetamodelManager> keySet = new ArrayList<PivotMetamodelManager>(liveMetamodelManagers.keySet());
			if (!keySet.isEmpty()) {
				StringBuilder s = new StringBuilder();
				s.append(" live");
				for (PivotMetamodelManager metamodelManager : keySet) {
					s.append(" @" + Integer.toHexString(metamodelManager.hashCode()));		
				}
				System.out.println(s.toString());		
			}
		}
	}

	/**
	 * Return the pivot model class for className with the Pivot Model.
	 */
	@Override
	public @Nullable org.eclipse.ocl.pivot.Class getASClass(@NonNull String className) {
		if (asMetamodel == null) {
			getASmetamodel();
			if (asMetamodel == null) {
				return null;
			}
		}
		return NameUtil.getNameable(asMetamodel.getOwnedClasses(), className);
	}

	public @Nullable Element getASElement(@NonNull URI uri) {
		if (uri.fragment() == null) {
			ASResource resource = (ASResource)asResourceSet.getResource(uri, true);
			return resource.getModel();
		}
		else {
			Element element = (Element)asResourceSet.getEObject(uri, true);
			return element;
		}
	}

	@Override
	public @Nullable <T extends Element> T getASOf(@NonNull Class<T> pivotClass, @Nullable EObject eObject) throws ParserException {
			if (eObject != null) {
				Resource eResource = eObject.eResource();
				ASResourceFactory bestHelper = eResource != null ? ASResourceFactoryRegistry.INSTANCE.getASResourceFactory(eResource) : EcoreASResourceFactory.getInstance();
	//			ASResourceFactory bestHelper = ASResourceFactoryRegistry.INSTANCE.getResourceFactory(eObject);
				if (bestHelper != null) {
					return bestHelper.getASElement(environmentFactory, pivotClass, eObject);
				}
			}
			return null;
		}

	@Override
	public @Nullable <T extends Element> T getASOfEcore(@NonNull Class<T> pivotClass, @Nullable EObject eObject) {
		if (eObject == null) {
			return null;
		}
		Resource metamodel = eObject.eResource();
		if (metamodel == null) {
			return null;
		}
		External2AS es2as = Ecore2AS.findAdapter(metamodel, environmentFactory);
		if (es2as == null) {
			es2as = Ecore2AS.getAdapter(metamodel, environmentFactory);
		}
		if (es2as == null) {
			return null;
		}
		return es2as.getCreated(pivotClass, eObject);
	}

	@Override
	public @Nullable org.eclipse.ocl.pivot.Package getASmetamodel() {
		if ((asMetamodel == null) && autoLoadASmetamodel) {
			org.eclipse.ocl.pivot.Package stdlibPackage = null;
			standardLibrary.getOclAnyType();				// Load a default library if necessary.
			if (!asLibraries.isEmpty()) {
				stdlibPackage = asLibraries.get(0);
			}
			if (stdlibPackage != null) {
				loadASmetamodel(stdlibPackage);
			}
		}
		return asMetamodel;
	}

	@Override
	public @NonNull ResourceSet getASResourceSet() {
		return asResourceSet;
	}

	public @NonNull Iterable<CompletePackageInternal> getAllCompletePackages() {
		if (!libraryLoadInProgress && (asMetamodel == null))  {
			getASmetamodel();
		}
		return completeModel.getAllCompletePackages();
	}

	/**
	 * Return all constraints applicable to a type and its superclasses.
	 */
	@Override
	public @NonNull Iterable<Constraint> getAllInvariants(@NonNull Type pivotType) {
		Set<Constraint> knownInvariants = new HashSet<Constraint>();
		for (CompleteClass superType : getAllSuperCompleteClasses(pivotType)) {
			if (superType != null) {
				for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.pivot.Class partialSuperType : superType.getPartialClasses()) {
					org.eclipse.ocl.pivot.Package partialPackage = partialSuperType.getOwningPackage();
					if (!(partialPackage instanceof PackageImpl) || !((PackageImpl)partialPackage).isIgnoreInvariants()) {
						knownInvariants.addAll(partialSuperType.getOwnedInvariants());
					}
				}
			}
		}
		return knownInvariants;
	}
	
	public @NonNull Iterable<Operation> getAllOperations(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		CompleteClass completeClass = completeModel.getCompleteClass(type);
		return completeClass.getOperations(featureFilter);
	}
	
	public @NonNull Iterable<Operation> getAllOperations(@NonNull Type type, @Nullable FeatureFilter featureFilter, @NonNull String name) {
		CompleteClass completeClass = completeModel.getCompleteClass(type);
		return completeClass.getOperations(featureFilter, name);
	}

/*	@Override
	public @NonNull Iterable<org.eclipse.ocl.pivot.Package> getAllPackages() {
		if (!libraryLoadInProgress && (asMetamodel == null))  {
			getASmetamodel();
		}
		return packageManager.getAllPackages();
	} */
	
	public @NonNull Iterable<? extends Property> getAllProperties(@NonNull Type type, @Nullable FeatureFilter featureFilter) {
		CompleteClass completeClass = completeModel.getCompleteClass(type);
		return completeClass.getProperties(featureFilter);
	}
	
	public @NonNull Iterable<? extends Property> getAllProperties(@NonNull Type type, @Nullable FeatureFilter featureFilter, @NonNull String name) {
		CompleteClass completeClass = completeModel.getCompleteClass(type);
		return completeClass.getProperties(featureFilter, name);
	}

	public @NonNull Iterable<? extends Property> getAllProperties(@NonNull Property pivotProperty) {
		CompleteInheritance pivotClass = pivotProperty.getInheritance(standardLibrary);
		if (pivotClass == null) {
			throw new IllegalStateException("Missing owning type");
		}
		CompleteClass completeClass = completeModel.getCompleteClass(pivotClass.getPivotClass());
		Iterable<? extends Property> memberProperties = completeClass.getProperties(pivotProperty);
		if (memberProperties != null) {
			return memberProperties;
		}
		@SuppressWarnings("null") @NonNull List<Property> singletonList = Collections.singletonList(pivotProperty);
		return singletonList;
	}
	
	public @NonNull Iterable<CompleteClass> getAllSuperCompleteClasses(@NonNull Type type) {
		CompleteClass completeClass = completeModel.getCompleteClass(type);
		return completeClass.getSuperCompleteClasses();
	}

	@Deprecated
	public @NonNull Iterable<org.eclipse.ocl.pivot.Class> getAllTypes(@NonNull org.eclipse.ocl.pivot.Class pivotType) {
//		if (pivotType == null) {
//			return EMPTY_TYPE_LIST;
//		}
//		return getTypeTracker(pivotType).getTypeServer().getTypes();
		CompleteClass completeClass = completeModel.getCompleteClass(pivotType);
		@SuppressWarnings("null") @NonNull Iterable<org.eclipse.ocl.pivot.Class> filter = Iterables.filter(completeClass.getPartialClasses(), org.eclipse.ocl.pivot.Class.class);
		return filter;
	}

	@Deprecated
	public @NonNull Iterable<Type> getAllTypes(@NonNull Type pivotType) {
//		if (pivotType == null) {
//			return EMPTY_TYPE_LIST;
//		}
//		return getTypeTracker(pivotType).getTypeServer().getTypes();
		CompleteClass completeClass = completeModel.getCompleteClass(pivotType);
		@SuppressWarnings("null") @NonNull Iterable<Type> filter = Iterables.filter(completeClass.getPartialClasses(), Type.class);
		return filter;
	}
	
	public @Nullable ExpressionInOCL getBodyExpression(@NonNull Operation operation) {
		ExpressionInOCL bodyExpression = null;
		for (@SuppressWarnings("null")@NonNull Operation domainOperation : getOperationOverloads(operation)) {
			LanguageExpression anExpression = domainOperation.getBodyExpression();
			if (anExpression != null) {
				if (bodyExpression != null) {
					throw new IllegalStateException("Multiple bodies for " + operation);
				}
				try {
					bodyExpression = parseSpecification(anExpression);
				} catch (ParserException e) {
					String message = e.getMessage();
					if (message == null) {
						message = "";
					}
					logger.error(message);
					bodyExpression = PivotUtil.createExpressionInOCLError(message);
				}
			}
		}
		return bodyExpression;
	}

	public @NonNull CollectionType getCollectionType(boolean isOrdered, boolean isUnique) {
		if (isOrdered) {
			if (isUnique) {
				return standardLibrary.getOrderedSetType();
			}
			else {
				return standardLibrary.getSequenceType();
			}
		}
		else {
			if (isUnique) {
				return standardLibrary.getSetType();
			}
			else {
				return standardLibrary.getBagType();
			}
		}
	}

	public @NonNull CollectionType getCollectionType(boolean isOrdered, boolean isUnique, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return completeEnvironment.getCollectionType(getCollectionType(isOrdered, isUnique), elementType, lower, upper);
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getCollectionType(@NonNull String collectionTypeName, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		if (elementType.eIsProxy()) {
			return standardLibrary.getOclInvalidType();
		}
		return completeEnvironment.getCollectionType(standardLibrary.getRequiredLibraryType(collectionTypeName), elementType, lower, upper);
	}
	
	public @NonNull Type getCommonType(@NonNull Type leftType, @NonNull TemplateParameterSubstitutions leftSubstitutions,
			@NonNull Type rightType, @NonNull TemplateParameterSubstitutions rightSubstitutions) {
		if ((leftType instanceof TupleType) && (rightType instanceof TupleType)) {
			TupleTypeManager tupleManager = completeModel.getTupleManager();
			Type commonType = tupleManager.getCommonType((TupleType)leftType, leftSubstitutions, (TupleType)rightType, rightSubstitutions);
			if (commonType == null) {
				commonType = standardLibrary.getOclAnyType();
			}
			return commonType;
		}
		if ((leftType instanceof CollectionType) && (rightType instanceof CollectionType)) {
			CompleteInheritance leftInheritance = leftType.getInheritance(standardLibrary);
			CompleteInheritance rightInheritance = rightType.getInheritance(standardLibrary);
			CompleteInheritance commonInheritance = leftInheritance.getCommonInheritance(rightInheritance);
			org.eclipse.ocl.pivot.Class commonCollectionType = getPrimaryClass(commonInheritance.getPivotClass()); 
			Type leftElementType = ClassUtil.nonNullModel(((CollectionType)leftType).getElementType());
			Type rightElementType = ClassUtil.nonNullModel(((CollectionType)rightType).getElementType());
			Type commonElementType = getCommonType(leftElementType, leftSubstitutions, rightElementType, rightSubstitutions); 
			return completeEnvironment.getCollectionType(commonCollectionType, commonElementType, null, null);
		}
		if (conformsTo(leftType, leftSubstitutions, rightType, rightSubstitutions)) {
			return rightType;
		}
		if (conformsTo(rightType, rightSubstitutions, leftType, leftSubstitutions)) {
			return leftType;
		}
		CompleteInheritance leftInheritance = leftType.getInheritance(standardLibrary);
		CompleteInheritance rightInheritance = rightType.getInheritance(standardLibrary);
		CompleteInheritance commonInheritance = leftInheritance.getCommonInheritance(rightInheritance);
		return getPrimaryClass(commonInheritance.getPivotClass()); 
	}

	@Override
	public @NonNull CompleteClassInternal getCompleteClass(@NonNull Type pivotType) {
		if (!libraryLoadInProgress && (asMetamodel == null) && !(pivotType instanceof CollectionType) && !(pivotType instanceof VoidType) && !(pivotType instanceof InvalidType)) {
			getASmetamodel();
		}
		return completeModel.getCompleteClass(pivotType);
	}

	public @NonNull CompleteEnvironmentInternal getCompleteEnvironment() {
		return completeEnvironment;
	}

	@Override
	public @NonNull CompleteModelInternal getCompleteModel() {
		return completeModel;
	}
	
	@Override
	public @NonNull CompletePackage getCompletePackage(@NonNull org.eclipse.ocl.pivot.Package asPackage) {
		if (!libraryLoadInProgress && asMetamodel == null) {
			getASmetamodel();
		}
		return completeModel.getCompletePackage(asPackage);
	}

	public @Nullable ExpressionInOCL getDefaultExpression(@NonNull Property property) {
		ExpressionInOCL defaultExpression = null;
		for (@SuppressWarnings("null")@NonNull Property domainProperty : getAllProperties(property)) {
			LanguageExpression anExpression = domainProperty.getOwnedExpression();
			if (anExpression != null) {
				if (defaultExpression != null) {
					throw new IllegalStateException("Multiple derivations for " + property);
				}
				try {
					defaultExpression = parseSpecification(anExpression);
				} catch (ParserException e) {
					String message = e.getMessage();
					if (message == null) {
						message = "";
					}
					logger.error(message);
					defaultExpression = PivotUtil.createExpressionInOCLError(message);
				}
			}
		}
		return defaultExpression;
	}

	@Override
	public @Nullable <T extends EObject> T getEcoreOfPivot(@NonNull Class<T> ecoreClass, @NonNull Element element) {
		EObject eTarget = element.getESObject();
		if (eTarget != null) {
			if (!ecoreClass.isAssignableFrom(eTarget.getClass())) {
				logger.error("Ecore " + eTarget.getClass().getName() + "' element is not a '" + ecoreClass.getName() + "'"); //$NON-NLS-1$
				return null;
			}
			@SuppressWarnings("unchecked")
			T castTarget = (T) eTarget;
			return castTarget;
		}
		Model root = (Model)EcoreUtil.getRootContainer(element);
		Resource asResource = element.eResource();
		if (asResource == null) {
			return null;
		}
		if (asResource instanceof OCLstdlib) {		// Not really a model so no Ecore
			return null;
		}
		URI ecoreURI;
		String externalUri = root.getExternalURI();
		URI externalURI = URI.createURI(externalUri);
		if (PivotUtilInternal.isASURI(externalUri)) {
			ecoreURI = ClassUtil.nonNullEMF(externalURI.trimFileExtension());
		}
		else {
			ecoreURI = ClassUtil.nonNullEMF(externalURI.appendFileExtension("ecore"));
		}
		AS2Ecore converter = new AS2Ecore(environmentFactory, ecoreURI, null);
		converter.convertResource(asResource, ecoreURI);
		return converter.getCreated(ecoreClass, element);
	}

	/**
	 * Return an ElementExtension for asStereotype reusing any that already exist in asElementExtensions.
	 */
	public @NonNull ElementExtension getElementExtension(@NonNull Element asStereotypedElement, @NonNull Stereotype asStereotype) {
		List<ElementExtension> extensions = asStereotypedElement.getOwnedExtensions();
		for (ElementExtension asElementExtension : extensions) {
			if (asElementExtension.getStereotype() == asStereotype) {
				return asElementExtension;
			}
		}
		@SuppressWarnings("null")@NonNull ElementExtension asElementExtension = PivotFactory.eINSTANCE.createElementExtension();
		asElementExtension.setStereotype(asStereotype);
		String name = environmentFactory.getTechnology().getExtensionName(asStereotypedElement);
		asElementExtension.setName(name + "$" + asStereotype.getName());
//		asElementExtension.getSuperClass().add(getOclAnyType());
		extensions.add(asElementExtension);
		return asElementExtension;
	}

	@Override
	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return environmentFactory;
	}

	public @Nullable External2AS getES2AS(@NonNull Resource esResource) {
		return es2ases != null ? es2ases.get(esResource) : null;
	}
	
	public @NonNull FinalAnalysis getFinalAnalysis() {
		FinalAnalysis finalAnalysis2 = finalAnalysis;
		if (finalAnalysis2 == null) {
			finalAnalysis = finalAnalysis2 = new FinalAnalysis(completeModel);
		}
		return finalAnalysis2;
	}

	@Override
	public @Nullable GenPackage getGenPackage(@NonNull String nsURI) {
		if (genPackageMap != null) {
			GenPackage genPackage = genPackageMap.get(nsURI);
			if (genPackage != null) {
				return genPackage;
			}
		}
		ResourceSet externalResourceSet = environmentFactory.getResourceSet();
		URI uri = EMF_2_9.EcorePlugin.getEPackageNsURIToGenModelLocationMap(false).get(nsURI);
		if (uri != null) {
			Resource resource = externalResourceSet.getResource(uri, true);
			for (EObject eObject : resource.getContents()) {
				if (eObject instanceof GenModel) {
					GenModel genModel = (GenModel)eObject;
					genModel.reconcile();
					for (GenPackage genPackage : genModel.getGenPackages()) {
						if (genPackage != null) {
							return genPackage;
						}
					}
				}
			}
		}
		return null;
	}

	public @NonNull Set<Map.Entry<String, Namespace>> getGlobalNamespaces() {
		@SuppressWarnings("null")
		@NonNull Set<Entry<String, Namespace>> entrySet = globalNamespaces.entrySet();
		return entrySet;
	}

	public @NonNull Iterable<Type> getGlobalTypes() {
		return globalTypes;
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
	
	public @NonNull LibraryFeature getImplementation(@NonNull Operation operation) {
		LibraryFeature implementation = operation.getImplementation();
		if (implementation == null) {
			boolean isCodeGeneration = getCompleteEnvironment().isCodeGeneration();
			if (isCodeGeneration) {
				LanguageExpression specification = operation.getBodyExpression();
				if (specification != null) {
					org.eclipse.ocl.pivot.Class owningType = operation.getOwningClass();
					if (owningType != null) {
						try {
							ExpressionInOCL query = parseSpecification(specification);
							implementation = new ConstrainedOperation(query);
						} catch (ParserException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
							implementation = UnsupportedOperation.INSTANCE;
						}
					}
				}
			}
			if (implementation == null) {
				EObject eTarget = operation.getESObject();
				if (eTarget != null) {
					EOperation eOperation = null;
					if (eTarget instanceof EOperation) {
						eOperation = (EOperation) eTarget;
						while (eOperation.eContainer() instanceof EAnnotation) {
							EAnnotation redefines = eOperation.getEAnnotation("redefines");
							if (redefines != null) {
								List<EObject> references = redefines.getReferences();
								if (references.size() > 0) {
									EObject eReference = references.get(0);
									if (eReference instanceof EOperation) {
										eOperation = (EOperation)eReference;
									}
								}
							}
						}
					}
					else {
						Resource resource = operation.eResource();
						if (resource instanceof ASResource) {
							ASResource asResource = (ASResource)resource;
							eOperation = asResource.getASResourceFactory().getEOperation(asResource, eTarget);
						}
					}
					if ((eOperation != null) && (eOperation.getEType() != null)) {
						implementation = new EInvokeOperation(eOperation);
					}
				}
			}
			if (!isCodeGeneration && (implementation == null)) {
				LanguageExpression specification = operation.getBodyExpression();
				if (specification != null) {
					org.eclipse.ocl.pivot.Class owningType = operation.getOwningClass();
					if (owningType != null) {
						try {
							ExpressionInOCL query = parseSpecification(specification);
							implementation = new ConstrainedOperation(query);
						} catch (ParserException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
							implementation = UnsupportedOperation.INSTANCE;
						}
					}
				}
			}
			if (implementation == null) {
				implementation = UnsupportedOperation.INSTANCE;
			}
			operation.setImplementation(implementation);
		}
		return implementation;
	}

	@Deprecated //in use by QVTiAS2CGVisitor
	public @NonNull LibraryProperty getImplementation(@Nullable Object sourceValue, @NonNull Property property) {
		return getImplementation(null, sourceValue, property);	// Change dead argument to @NonNull once removed
	}
	public @NonNull LibraryProperty getImplementation(@Nullable Element asNavigationExp, @Nullable Object sourceValue, @NonNull Property property) {
		LibraryProperty implementation = (LibraryProperty) property.getImplementation();
		if (implementation == null) {
			ImplementationManager implementationManager = getImplementationManager();
			implementation = implementationManager.getPropertyImplementation(asNavigationExp, sourceValue, property);
			property.setImplementation(implementation);
		}
		return implementation;
	}
	
	public @NonNull ImplementationManager getImplementationManager() {
		ImplementationManager implementationManager2 = implementationManager;
		if (implementationManager2 == null) {
			implementationManager2 = implementationManager = environmentFactory.createImplementationManager();
		}
		return implementationManager2;
	}

	public @Nullable Precedence getInfixPrecedence(@NonNull String operatorName) {
		getStandardLibrary();
		PrecedenceManager precedenceManager = getPrecedenceManager();
		return precedenceManager.getInfixPrecedence(operatorName);
	}

	public @NonNull CompleteInheritance getInheritance(@NonNull org.eclipse.ocl.pivot.Class type) {
		org.eclipse.ocl.pivot.Class type1 = getPrimaryClass(type);
		org.eclipse.ocl.pivot.Class unspecializedType = (org.eclipse.ocl.pivot.Class) type1.getUnspecializedElement();
		org.eclipse.ocl.pivot.Class theType = unspecializedType != null ? unspecializedType : type1;
		CompleteInheritanceImpl completeInheritance = getCompleteClass(theType).getCompleteInheritance();
		return completeInheritance;
	}
	
	public @NonNull List<Library> getLibraries() { return asLibraries; }
	public @Nullable Resource getLibraryResource() { return asLibraryResource; }

	public @Nullable org.eclipse.ocl.pivot.Class getLibraryType(@NonNull String string, @NonNull List<? extends Type> templateArguments) {
		org.eclipse.ocl.pivot.Class libraryType = standardLibrary.getRequiredLibraryType(string);
		return getLibraryType(libraryType, templateArguments);
	}

	public @NonNull <T extends org.eclipse.ocl.pivot.Class> T getLibraryType(@NonNull T libraryType, @NonNull List<? extends Type> templateArguments) {
//		assert !(libraryType instanceof CollectionType);
		assert libraryType == PivotUtil.getUnspecializedTemplateableElement(libraryType);
		TemplateSignature templateSignature = libraryType.getOwnedSignature();
		List<TemplateParameter> templateParameters = templateSignature != null ? templateSignature.getOwnedParameters() : EMPTY_TEMPLATE_PARAMETER_LIST;
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
		CompleteClassInternal libraryCompleteClass = getCompleteClass(libraryType);
		org.eclipse.ocl.pivot.Class pivotClass = libraryCompleteClass.getPrimaryClass();
		if (pivotClass instanceof CollectionType) {
			assert pivotClass instanceof CollectionType;
			assert templateArguments.size() == 1;
			@SuppressWarnings("null")@NonNull Type templateArgument = templateArguments.get(0);
			@SuppressWarnings("unchecked") T specializedType = (T) completeModel.getCollectionType(libraryCompleteClass, TypeUtil.createCollectionTypeParameters(templateArgument, null, null));
			return specializedType;
		}
		else if (pivotClass instanceof MapType) {
			assert pivotClass instanceof MapType;
			assert templateArguments.size() == 2;
			@SuppressWarnings("null")@NonNull Type keyTemplateArgument = templateArguments.get(0);
			@SuppressWarnings("null")@NonNull Type valueTemplateArgument = templateArguments.get(1);
			@SuppressWarnings("unchecked") T specializedType = (T) completeModel.getMapType(libraryCompleteClass, TypeUtil.createMapTypeParameters(keyTemplateArgument, valueTemplateArgument));
			return specializedType;
		}
		else {
			@SuppressWarnings("unchecked")
			T specializedType = (T) libraryCompleteClass.getPartialClasses().getSpecializedType(templateArguments);
			return specializedType;
		}
	}

	public @NonNull Iterable<Constraint> getLocalInvariants(@NonNull org.eclipse.ocl.pivot.Class type) {
		type = PivotUtil.getUnspecializedTemplateableElement(type);
		return new CompleteElementInvariantsIterable(getAllTypes(type));
	}

	public @Nullable EObject getLockingObject() {
		return lockingAnnotation;
	}

	public @NonNull org.eclipse.ocl.pivot.Class getMapType(@NonNull String mapTypeName, @NonNull Type keyType, @NonNull Type valueType) {
		if (keyType.eIsProxy() || valueType.eIsProxy()) {
			return standardLibrary.getOclInvalidType();
		}
		return completeEnvironment.getMapType(standardLibrary.getRequiredLibraryType(mapTypeName), keyType, valueType);
	}

	public @NonNull Iterable<Operation> getMemberOperations(@NonNull org.eclipse.ocl.pivot.Class type, boolean selectStatic) {
		type = PivotUtil.getUnspecializedTemplateableElement(type);
		return new CompleteTypeOperationsIterable(getAllTypes(type), selectStatic);
	}

	public @NonNull Iterable<? extends CompletePackage> getMemberPackages(@NonNull org.eclipse.ocl.pivot.Package pkg) {
		return getCompletePackage(pkg).getOwnedCompletePackages();
	}

	public @NonNull Iterable<Property> getMemberProperties(@NonNull org.eclipse.ocl.pivot.Class type, boolean selectStatic) {
		type = PivotUtil.getUnspecializedTemplateableElement(type);
		return new CompleteClassPropertiesIterable(getAllTypes(type), selectStatic);
	}

	public @NonNull org.eclipse.ocl.pivot.Class getMetaclass(@NonNull Type domainInstanceType) {
		org.eclipse.ocl.pivot.Class metaType = null;
		if (domainInstanceType instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)domainInstanceType;
			if (collectionType.isOrdered()) {
				if (collectionType.isUnique()) {
					metaType = getASClass(TypeId.ORDERED_SET_TYPE_NAME);
				}
				else {
					metaType = getASClass(TypeId.SEQUENCE_TYPE_NAME);
				}
			}
			else {
				if (collectionType.isUnique()) {
					metaType = getASClass(TypeId.SET_TYPE_NAME);
				}
				else {
					metaType = getASClass(TypeId.BAG_TYPE_NAME);
				}
			}

		}
		if (metaType != null) {
			return metaType;
		}
		return standardLibrary.getClassType();
	}

	protected @NonNull org.eclipse.ocl.pivot.Class getMutable(@NonNull org.eclipse.ocl.pivot.Class asType) {
//		if ("Class".equals(asType.getName())) {
//			System.out.println("Got it");
//		}
		Resource asResource = asType.eResource();
		if (ClassUtil.isRegistered(asResource)) {
			for (Type domainType : getPartialClasses(asType)) {
				if ((domainType != asType) && (domainType instanceof org.eclipse.ocl.pivot.Class)) {
					org.eclipse.ocl.pivot.Class asPartialType = (org.eclipse.ocl.pivot.Class)domainType;
					if (!ClassUtil.isRegistered(asPartialType.eResource())) {
						if (CREATE_MUTABLE_CLONE.isActive()) {
							CREATE_MUTABLE_CLONE.println(asType + " " + NameUtil.debugSimpleName(asType) + " => " + NameUtil.debugSimpleName(asPartialType));
						}
						return asPartialType;
					}
				}
			}
			Resource clonedResource = null;
			org.eclipse.ocl.pivot.Package asPackage = asType.getOwningPackage();
			String name = ClassUtil.nonNullModel(asPackage.getName());
			String nsPrefix = ClassUtil.nonNullModel(asPackage.getNsPrefix());
			String nsURI = ClassUtil.nonNullModel(asPackage.getURI());
			if (asPackage instanceof Library) {
				String uriString = ClassUtil.nonNullModel(asResource.getURI().toString());
				clonedResource = OCLstdlib.create(uriString, name, nsPrefix, nsURI);
			}
			else if (asResource instanceof OCLmetamodel) {
				org.eclipse.ocl.pivot.Package mutableMetamodel = OCLmetamodel.create(standardLibrary, name, nsPrefix, nsURI);
				clonedResource = mutableMetamodel.eResource();
			}
			if (clonedResource != null) {
				installResource(clonedResource);
				asResourceSet.getResources().add(clonedResource);
			}
			else {
				throw new UnsupportedOperationException("No cloned type");
			}
			for (Type domainType : getPartialClasses(asType)) {
				if ((domainType != asType) && (domainType instanceof org.eclipse.ocl.pivot.Class)) {
					org.eclipse.ocl.pivot.Class asPartialType = (org.eclipse.ocl.pivot.Class)domainType;
					if (!ClassUtil.isRegistered(asPartialType.eResource())) {
						if (CREATE_MUTABLE_CLONE.isActive()) {
							CREATE_MUTABLE_CLONE.println(asType + " " + NameUtil.debugSimpleName(asType) + " => " + NameUtil.debugSimpleName(asPartialType));
						}
						return asPartialType;
					}
				}
			}
			throw new UnsupportedOperationException("No cloned library type " + asType);
		}
		if (CREATE_MUTABLE_CLONE.isActive()) {
			CREATE_MUTABLE_CLONE.println(asType + " " + NameUtil.debugSimpleName(asType));
		}
		return asType;
	}

	public @Nullable Type getOclType(@NonNull String typeName) {
		org.eclipse.ocl.pivot.Class pivotType = getASClass(typeName);
		return pivotType != null ? getInheritance(pivotType).getPivotClass() : null;
	}

	public @NonNull Iterable<? extends Operation> getOperationOverloads(@NonNull Operation pivotOperation) {
		CompleteInheritance pivotClass = pivotOperation.getInheritance(standardLibrary);
		if (pivotClass == null) {
			throw new IllegalStateException("Missing owning type");
		}
		CompleteClass completeClass = completeModel.getCompleteClass(pivotClass.getPivotClass());
		Iterable<? extends Operation> operationOverloads = completeClass.getOperationOverloads(pivotOperation);
		if (operationOverloads != null) {
			return operationOverloads;
		}
		@SuppressWarnings("null") @NonNull List<Operation> singletonList = Collections.singletonList(pivotOperation);
		return singletonList;
	}

	public @NonNull Iterable<? extends org.eclipse.ocl.pivot.Package> getPartialPackages(@NonNull org.eclipse.ocl.pivot.Package pkg, boolean loadASmetamodelFirst) {
		if (!libraryLoadInProgress && loadASmetamodelFirst && (asMetamodel == null)) {
			getASmetamodel();
		}
		CompletePackage completePackage = completeModel.getCompletePackage(pkg);
		return completePackage.getPartialPackages();
	}

	public @NonNull Iterable<org.eclipse.ocl.pivot.Class> getPartialClasses(@NonNull Type pivotType) {
		CompleteClass completeClass = completeModel.getCompleteClass(pivotType);
		return completeClass.getPartialClasses();
	}

	@SuppressWarnings("null")
	protected @NonNull PrecedenceManager getPrecedenceManager() {
		if (precedenceManager == null) {
			standardLibrary.getOclAnyType();		// Make sure OCL Standard Library has defined operations to be compiled with precedence
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

//	public Iterable<? extends Nameable> getPrecedences(org.eclipse.ocl.pivot.Package asPackage) {
//		return asPackage.getOwnedPrecedence(); // FIXME make package independent
//	}
	
	public @Nullable Precedence getPrefixPrecedence(@NonNull String operatorName) {
		PrecedenceManager precedenceManager = getPrecedenceManager();
		return precedenceManager.getPrefixPrecedence(operatorName);
	}

	@SuppressWarnings("unchecked")
	public @NonNull <T extends EObject> T getPrimaryElement(@NonNull T element) {
		if (element instanceof Operation) {
			return (T) getPrimaryOperation((Operation)element);
		}
		else if (element instanceof org.eclipse.ocl.pivot.Package) {
			return (T) getPrimaryPackage((org.eclipse.ocl.pivot.Package)element);
		}
		else if (element instanceof Property) {
			return (T) getPrimaryProperty((Property)element);
		}
		else if (element instanceof Type) {
			return (T) getPrimaryType((Type)element);
		} 
		return element;
	}

	@Override
	public @NonNull Operation getPrimaryOperation(@NonNull Operation pivotOperation) {
		CompleteInheritance pivotClass = pivotOperation.getInheritance(standardLibrary);
		if (pivotClass != null) {					// Null for an EAnnotation element
			CompleteClass completeClass = completeModel.getCompleteClass(pivotClass.getPivotClass());
			Operation operation = completeClass.getOperation(pivotOperation);
			if (operation != null) {
				return operation;
			}
		}
		return pivotOperation;
	}

	/**
	 * Lookup a primary package by its URI and optionally a sub-package path.
	 */
	public @Nullable org.eclipse.ocl.pivot.Package getPrimaryPackage(@NonNull String nsURI, String... subPackagePath) {
		CompletePackage completePackage = completeModel.getCompletePackageByURI(nsURI);
		if (completePackage == null) {
			return null;
		}
		if (subPackagePath != null) {
			for (String subPackageName : subPackagePath) {
				if (subPackageName == null) {
					return null;
				}
				completePackage = completePackage.getOwnedCompletePackage(subPackageName);
				if (completePackage == null) {
					return null;
				}
			}
		}
		return completePackage.getPrimaryPackage();
	}

	/**
	 * Lookup a primary sub-package.
	 *
	public @Nullable PackageServer getPrimaryPackage(@NonNull org.eclipse.ocl.pivot.Package parentPackage, @NonNull String subPackageName) {
		PackageTracker packageTracker = packageManager.findPackageTracker(parentPackage);
		if (packageTracker != null) {
			return packageTracker.getPackageServer().getMemberPackage(subPackageName);
		}
		else {
			return PivotUtil.getNamedElement(parentPackage.getNestedPackage(), subPackageName);
		}
	} */

	@Override
	public @NonNull org.eclipse.ocl.pivot.Package getPrimaryPackage(@NonNull org.eclipse.ocl.pivot.Package aPackage) {
		return ClassUtil.nonNullState(getCompletePackage(aPackage).getPrimaryPackage());
	}

	@Override
	public @NonNull Property getPrimaryProperty(@NonNull Property pivotProperty) {
		if (pivotProperty.eContainer() instanceof TupleType) {		// FIXME Find a better way
			return pivotProperty;
		}
		CompleteInheritance owningInheritance = pivotProperty.getInheritance(standardLibrary);
		if (owningInheritance != null) {
			@NonNull String name = ClassUtil.nonNullModel(pivotProperty.getName());
			Property opposite = pivotProperty.getOpposite();
			String oppositeName = opposite != null ? opposite.getName() : null;
			CompleteClass completeClass = completeModel.getCompleteClass(owningInheritance.getPivotClass());
			Iterable<? extends Property> memberProperties = completeClass.getProperties(pivotProperty.isIsStatic() ? FeatureFilter.SELECT_STATIC : FeatureFilter.SELECT_NON_STATIC, name);
			Property bestProperty = null;
			for (Property memberProperty : memberProperties) {
				if (memberProperty != null) {
					Property memberOpposite = memberProperty.getOpposite();
					String memberOppositeName = memberOpposite != null ? memberOpposite.getName() : null;
					if ((oppositeName != null) && oppositeName.equals(memberOppositeName)) {
						return memberProperty;
					}
					else if ((bestProperty == null) || (oppositeName == null) || oppositeName.equals(memberOppositeName)) {
						bestProperty = memberProperty;
					}
				}
			}
			if (bestProperty != null) {
				return bestProperty;
			}
		}
		return pivotProperty;
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getPrimaryClass(@NonNull org.eclipse.ocl.pivot.Class type) {
		if (/*(type instanceof Type) &&*/ !isTypeServeable(type)) {
			return type;
		}
		return getCompleteClass(type).getPrimaryClass();
//		TypeTracker typeTracker = packageManager.findTypeTracker(pivotType);
//		if (typeTracker != null) {
//			return typeTracker.getPrimaryType();
//		}
//		else {
//			return pivotType;
//		}
	}

	// FIXME ASBH This should probably disappear
	public @NonNull Type getPrimaryType(@NonNull Type type) {
		if (/*(type instanceof Type) &&*/ !isTypeServeable(type)) {
			return type;			// FIXME bad cast
		}
		return getCompleteClass(type).getPrimaryClass();
//		TypeTracker typeTracker = packageManager.findTypeTracker(pivotType);
//		if (typeTracker != null) {
//			return typeTracker.getPrimaryType();
//		}
//		else {
//			return pivotType;
//		}
	}

	@Override
	public @Nullable org.eclipse.ocl.pivot.Class getPrimaryType(@NonNull String nsURI, @NonNull String path, String... extraPath) {
		CompletePackage completePackage = completeModel.getCompletePackageByURI(nsURI);
		if (completePackage == null) {
			return null;
		}
		if ((extraPath == null) || (extraPath.length == 0)) {
			return completePackage.getMemberType(path);
		}
		else {
			completePackage = completePackage.getOwnedCompletePackage(path);
			if (completePackage == null) {
				return null;
			}
			int iMax = extraPath.length-1;
			for (int i = 0; i < iMax; i++) {
				String subPackageName = extraPath[i];
				if (subPackageName == null) {
					return null;
				}
				completePackage = completePackage.getOwnedCompletePackage(subPackageName);
				if (completePackage == null) {
					return null;
				}
			}
			String subPackageName = extraPath[iMax];
			if (subPackageName == null) {
				return null;
			}
			return completePackage.getMemberType(subPackageName);
		}
	}

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
	
	@Override
	public @NonNull StandardLibraryInternal getStandardLibrary() {
		return standardLibrary;
	}
	
	public Iterable<CompleteClass> getSuperCompleteClasses(@NonNull org.eclipse.ocl.pivot.Class pivotType) {
		if (!libraryLoadInProgress && (asMetamodel == null) && (pivotType == standardLibrary.getClassType()))  {
			getASmetamodel();
		}
		CompleteClass completeClass = getCompleteClass(pivotType);
		return getSuperCompleteClasses(completeClass);
	}
	public Iterable<CompleteClass> getSuperCompleteClasses(@NonNull CompleteClass completeClass) {
		return completeClass.getProperSuperCompleteClasses();
	}

	@Override
	public ResourceSet getTarget() {
		return asResourceSet;
	}

	/**
	 * Create implicit an opposite property if there is no explicit opposite.
	 */
	public void installPropertyDeclaration(@NonNull Property thisProperty) {
		// WE cannot detect ambiguous opoposites reliably since a later Property might invalide previously ok derived opposites
		if ((thisProperty.isIsTransient() || thisProperty.isIsVolatile()) && !thisProperty.isIsDerived()) {		// FIXME Are any exclusions justified?
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
		if (thatType == null) {
			return;
		}
		org.eclipse.ocl.pivot.Class thatClass = thatType.isClass();
		if ((thatClass == null) || (thatClass instanceof DataType)) {
			return;
		}
		org.eclipse.ocl.pivot.Class thisClass = thisProperty.getOwningClass();
		if (thisClass == null) {								// e.g. an EAnnotation
			return;
		}
		String name = thisClass.getName();
		if (name == null) {
			return;
		}
		// If there is no implicit property with the implicit name, create one
		//   result a pair of mutual opposites		
		Property newOpposite = PivotFactory.eINSTANCE.createProperty();
		newOpposite.setIsImplicit(true);
		newOpposite.setName(name);
		if (thisProperty.isIsComposite()) {
			newOpposite.setType(thisClass);
			newOpposite.setIsRequired(false);
		}
		else {
			newOpposite.setType(getCollectionType(
				PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_ORDERED,
				PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UNIQUE,
				thisClass,
				PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_LOWER_VALUE,
				PivotConstantsInternal.DEFAULT_IMPLICIT_OPPOSITE_UPPER_VALUE));
			newOpposite.setIsRequired(true);
		}
		thatClass = getMutable(thatClass);
		thatClass.getOwnedProperties().add(newOpposite);		// WIP moved for debugging
		newOpposite.setOpposite(thisProperty);
		thisProperty.setOpposite(newOpposite);
	}

	public void installResource(@NonNull Resource asResource) {
		for (EObject eObject : asResource.getContents()) {
			if (eObject instanceof Model) {
				installRoot((Model)eObject);
			}
		}
		if (!libraryLoadInProgress && (asLibraryResource == null) && (asResource instanceof OCLstdlib) && (asLibraries.size() > 0)) {
			standardLibrary.getOclAnyType();
		}
	}

	@Override
	public void installRoot(@NonNull Model pivotModel) {
		completeModel.getPartialModels().add(pivotModel);
		for (org.eclipse.ocl.pivot.Package asPackage : pivotModel.getOwnedPackages()) {
			if ((asPackage instanceof Library) && !asLibraries.contains(asPackage)) {
				Library asLibrary = (Library)asPackage;
				String uri = asLibrary.getURI();
				if (asLibraries.isEmpty()) {
					if (uri == null) {
						throw new IllegalLibraryException(PivotMessagesInternal.MissingLibraryURI_ERROR_);
					}
					standardLibrary.setDefaultStandardLibraryURI(uri);
				}
				else {
					String libraryURI = standardLibrary.getDefaultStandardLibraryURI();
					if ((uri != null) && !uri.equals(libraryURI)) {
						throw new IllegalLibraryException(NLS.bind(PivotMessagesInternal.ImportedLibraryURI_ERROR_, uri , libraryURI));
					}
				}
				asLibraries.add(asLibrary);
			}
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == PivotMetamodelManager.class;
	}

	public boolean isLibraryLoadInProgress() {
		return libraryLoadInProgress;	
	}

	public boolean isSuperClassOf(@NonNull org.eclipse.ocl.pivot.Class unspecializedFirstType, @NonNull org.eclipse.ocl.pivot.Class secondType) {
		CompleteClass firstCompleteClass = getCompleteClass(unspecializedFirstType);
		CompleteClass secondCompleteClass = getCompleteClass(secondType);
		return isSuperCompleteClassOf(firstCompleteClass, secondCompleteClass);
	}

	public boolean isSuperCompleteClassOf(@NonNull CompleteClass unspecializedFirstType, @NonNull CompleteClass secondType) {
		CompleteClass unspecializedSecondType = getCompleteClass(PivotUtil.getUnspecializedTemplateableElement(secondType.getPrimaryClass()));	// FIXME cast
//		org.eclipse.ocl.pivot.Class unspecializedSecondType = PivotUtil.getUnspecializedTemplateableElement(secondType);	// FIXME cast
		if (unspecializedFirstType == unspecializedSecondType) {
			return true;
		}
		for (CompleteClass superCompleteClass : getSuperCompleteClasses(unspecializedSecondType)) {
			if ((superCompleteClass != null) && isSuperCompleteClassOf(unspecializedFirstType, superCompleteClass)) {
				return true;
			}
		}
		return false;
	}

	public boolean isTypeServeable(@NonNull Type type) {
//		if (pivotType .getUnspecializedElement() != null) {
//			return false;
//		}
		if (type.isTemplateParameter() != null) {
			return false;
		}
//		if (pivotType instanceof UnspecifiedType) {
//			return false;
//		}
		if (type instanceof LambdaType) {
			return false;
		}
//		if (pivotType instanceof TupleType) {
//			return false;
//		}
		if (type.eContainer() instanceof TemplateParameterSubstitution) {
			return false;
		}
		return true;
	}

	protected boolean isUnspecialized(@NonNull List<TemplateParameter> templateParameters, @NonNull List<? extends Type> templateArguments) {
		int iMax = templateParameters.size();
		assert templateArguments.size() == iMax;
		for (int i = 0; i < iMax; i++) {
			if (templateArguments.get(i) != templateParameters.get(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Load the Pivot Metamodel of the Pivot Model to accompany a given asLibrary.
	 * 
	 * If this asLibrary has an Element type it is assumed to be a complete custom meta-model and it is used as such.
	 * 
	 * Otherwise the built-in Pivot Metamodel is created with name, nsPrefix and nsURI determined by the given library.
	 * 
	 * @param asLibrary
	 */
	protected void loadASmetamodel(@NonNull org.eclipse.ocl.pivot.Package asLibrary) {
		for (org.eclipse.ocl.pivot.Package libPackage : getPartialPackages(asLibrary, false)) {
			if (NameUtil.getNameable(libPackage.getOwnedClasses(), PivotPackage.Literals.ELEMENT.getName()) != null) {
				setASmetamodel(libPackage);	// Custom meta-model
				return;
			}
		}
		String name = ClassUtil.nonNullState(asLibrary.getName());
//		String nsURI = ClassUtil.nonNullState(asLibrary.getNsURI());
		org.eclipse.ocl.pivot.Package oclMetamodel = OCLmetamodel.create(standardLibrary, name, asLibrary.getNsPrefix(), OCLmetamodel.PIVOT_URI);
		asResourceSet.getResources().add(oclMetamodel.eResource());
		setASmetamodel(oclMetamodel);		// Standard meta-model
		@SuppressWarnings("null")
		@NonNull Resource asResource = oclMetamodel.eResource();
//		asResourceSet.getResources().add(asResource);
		installResource(asResource);
	}

	public @Nullable Resource loadDefaultLibrary(@Nullable String uri) {
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
//						CompletePackage completePackage = packageManager.getPackageServer(asLibrary);
//						completePackage.getMemberTypes();			// FIXME side effect of creating type trackers
						for (org.eclipse.ocl.pivot.Class type : asLibrary.getOwnedClasses()) {
							if (type != null) {
								org.eclipse.ocl.pivot.Class primaryType = getPrimaryClass(type);
								if ((type == primaryType) && PivotUtilInternal.isLibraryType(type)) {
									standardLibrary.defineLibraryType(primaryType);
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

	@Override
	public @Nullable Element loadResource(@NonNull URI uri, String zzalias, @Nullable ResourceSet resourceSet) throws ParserException {
		// FIXME alias not used
		URI resourceURI = uri.trimFragment();
		if (PivotUtilInternal.isASURI(resourceURI)) {
			return getASElement(uri);
		}
		// if (EPackage.Registry.INSTANCE.containsKey(resourceOrNsURI))
		// return EPackage.Registry.INSTANCE.getEPackage(resourceOrNsURI);
		ResourceSet externalResourceSet = resourceSet != null ? resourceSet : environmentFactory.getResourceSet();
		EPackage.Registry packageRegistry = externalResourceSet.getPackageRegistry();
		String uriString = resourceURI.toString();
		Resource resource = null;
		String fragment = uri.fragment();
		if (fragment == null) {
			//
			//	fragment-less URI may be explicit namespace URI
			//
			EPackage ePackage = packageRegistry.getEPackage(uriString);
			if (ePackage != null) {
				return getASOf(Element.class, ePackage);
			}
			//
			//	fragment-less URI may be an OCL Standard Library
			//
			if (uriString.equals(standardLibrary.getDefaultStandardLibraryURI())) {
				if (asLibraryResource != null) {
					resource = asLibraryResource;
				}
				else {
					resource = standardLibrary.loadDefaultLibrary(uriString);
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
						Element asElement = getASOf(Element.class, eObject);
						if (asElement != null) {
							return asElement;
						}
					}
				}
			}
		}
		if (resource == null) {
			External2AS external2as = external2asMap.get(resourceURI);
			if (external2as != null) {
				resource = external2as.getResource();
			}
			else {
//				try {
					resource = externalResourceSet.getResource(resourceURI, true);
//				}
//				catch (RuntimeException e) {
//					resource = externalResourceSet.getResource(resourceURI, false);
//					if (resource != null) {
////						externalResourceSet.getResources().remove(resource);
//						resource = null;
//					}
//					throw e;
//				}
				if (resource != null) {
					for (Resource.Diagnostic diagnostic : resource.getErrors()) {
						if (diagnostic instanceof WrappedException) {
							throw (WrappedException)diagnostic;
						}
					}
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
					if (resource instanceof StandaloneProjectMap.DelegatedSinglePackageResource) {
						resource = ((StandaloneProjectMap.DelegatedSinglePackageResource)resource).getResource();
					}
					List<EObject> contents = resource.getContents();
					if (contents.size() > 0) {
						EObject firstContent = contents.get(0);
						if (firstContent != null) {
							for (ASResourceFactory resourceFactory : ASResourceFactoryRegistry.INSTANCE.getLoadedResourceFactories()) {
								URI packageURI = resourceFactory.getPackageURI(firstContent);
								if (packageURI != null) {
									External2AS external2as2 = external2asMap.get(packageURI);
									if (external2as2 != null) {
										Resource knownResource = external2as2.getResource();
										if ((knownResource != null) && (knownResource != resource)) {
											for (EObject eContent : resource.getContents()) {
												if (eContent instanceof Pivotable) {
													Element pivot = ((Pivotable)firstContent).getPivot();
													if (pivot instanceof Model) {
														Model root = (Model)pivot;
														completeModel.getPartialModels().remove(root);
														Resource asResource = root.eResource();
														if (asResource != null) {
															asResourceSet.getResources().remove(asResource);
															asResource.unload();
														}
													}
												}
											}
											if (!resourceFactory.getASResourceFactory().isCompatibleResource(resource, knownResource)) {
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
			return environmentFactory.loadResource(resource, uri);
		}
		logger.warn("Cannot load package with URI '" + uri + "'");
		return null;
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull Operation dynamicOperation) throws SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
		return getImplementation(dynamicOperation);
	}

	@Override
	public void notifyChanged(Notification notification) {}

	/**
	 * Return the compiled query for a specification resolving a String body into a non-null bodyExpression.
	 * Throws a ParserException if conversion fails.
	 */
	@Override
	public @NonNull ExpressionInOCL parseSpecification(@NonNull LanguageExpression specification) throws ParserException {
		EObject contextElement = ClassUtil.nonNullState(specification.eContainer());
		if ((specification instanceof ExpressionInOCL) && ((ExpressionInOCL)specification).getOwnedBody() != null) {
			return (ExpressionInOCL)specification;
		}
		String expression = specification.getBody();
		if (expression == null) {
			throw new ParserException(PivotMessagesInternal.MissingSpecificationBody_ERROR_, NameUtil.qualifiedNameFor(contextElement), PivotUtilInternal.getSpecificationRole(specification));
		}
		ParserContext parserContext = createParserContext(specification);
		if (parserContext == null) {
			throw new ParserException(PivotMessagesInternal.UnknownContextType_ERROR_, NameUtil.qualifiedNameFor(contextElement), PivotUtilInternal.getSpecificationRole(specification));
		}
		parserContext.setRootElement(specification);
		return parserContext.parse(contextElement, expression);
	}

	public void removeExternalResource(@NonNull External2AS external2as) {
		external2asMap.remove(external2as.getURI());
	}

	public void removeExternalResource(@NonNull Resource esResource) {
		if (es2ases != null) {
			External2AS es2as = es2ases.remove(esResource);
			if (es2as != null) {
				es2as.dispose();
			}
		}
	}

	public void setASmetamodel(org.eclipse.ocl.pivot.Package asPackage) {
		asMetamodel = asPackage;
		String uri = asMetamodel.getURI();
		if (uri != null) {
			completeModel.addPackageURI2completeURI(uri, PivotConstants.METAMODEL_NAME);
		}
	}

	public void setAutoLoadASmetamodel(boolean autoLoadASmetamodel) {
		this.autoLoadASmetamodel  = autoLoadASmetamodel;
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
			getASmetamodel();
		}
		else if (!metaNsURI.equals(asMetamodel.getURI())) {
			completeModel.addPackageURI2completeURI(metaNsURI, PivotConstants.METAMODEL_NAME);
//			throw new IllegalMetamodelException(asMetamodel.getNsURI(), metaNsURI);
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {
//		assert newTarget == asResourceSet;
	}
	
	/**
	 * Return the specialized form of type analyzing expr to determine the formal to actual parameter mappings
	 * using selfType as the value of OclSelf.
	 */
	public @NonNull Type specializeType(@NonNull Type type, @NonNull CallExp callExp, @NonNull Type selfType, @Nullable Type selfTypeValue) {
		return TemplateParameterSubstitutionVisitor.specializeType(type, callExp, environmentFactory, selfType, selfTypeValue);
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
//		assert oldTarget == asResourceSet;
	}
}
