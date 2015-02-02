/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation, Borland Software Corp., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *   Borland - Bug 265066
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.context.ClassContext;
import org.eclipse.ocl.pivot.internal.context.ModelContext;
import org.eclipse.ocl.pivot.internal.context.OperationContext;
import org.eclipse.ocl.pivot.internal.context.PropertyContext;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractCustomizable;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractEvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.evaluation.OCLEvaluationVisitor;
import org.eclipse.ocl.pivot.internal.evaluation.PivotModelManager;
import org.eclipse.ocl.pivot.internal.evaluation.TracingEvaluationVisitor;
import org.eclipse.ocl.pivot.internal.library.ImplementationManager;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.pivot.internal.resource.ICSI2ASMapping;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.Technology;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.values.ObjectValue;

/**
 * Partial implementation of the {@link EnvironmentFactoryInternal} interface, useful
 * for subclassing to define the Pivot binding for a metamodel.
 */
public abstract class AbstractEnvironmentFactory extends AbstractCustomizable implements EnvironmentFactoryInternal
{
    private boolean traceEvaluation;
    private @NonNull ProjectManager projectManager;
    private /*@LazyNonNull*/ PivotMetamodelManager metamodelManager;
	private final @NonNull CompleteEnvironmentInternal completeEnvironment;
	private final @NonNull StandardLibraryInternal standardLibrary;
	private @Nullable ICSI2ASMapping csi2asMapping;
	/**
	 * The known packages.
	 */
	private final @NonNull CompleteModelInternal completeModel;

	private /*@LazyNonNull*/ IdResolver idResolver;
	
	/**
	 * EnvironmentFactoryListener instances to be notified of significant state changes; most notably disposal.
	 */
	private @Nullable List<Listener> listeners = null;
    
    /**
     * Count of the number of OCL instances that are using the EnvironmentFactory. auto-disposes on cunbt down to zero.
     */
    private int attachCount = 0;;
//    private List<WeakReference<Object>> attachers = null;;
    
    private @NonNull Technology technology = ASResourceFactoryRegistry.INSTANCE.getTechnology();
	
	/**
	 * Initializes me with an <code>EPackage.Registry</code> that the
     * environments I create will use to look up packages.
     * 
     * @param reg my package registry
	 * @param metamodelManager 
	 */
 //   protected AbstractEnvironmentFactory(@Nullable EPackage.Registry reg, @Nullable MetamodelManager metamodelManager) {
//		this.metamodelManager = metamodelManager != null ? metamodelManager : createMetamodelManager();
//		this.modelManager = reg != null ? createModelManager(reg) : null;
//	}

	/**
	 * @param projectManager
	 */
	protected AbstractEnvironmentFactory(@NonNull ProjectManager projectManager) {
		this.projectManager = projectManager;
		this.metamodelManager = null;
		this.completeEnvironment = createCompleteEnvironment();
		this.standardLibrary = completeEnvironment.getOwnedStandardLibrary();
		this.completeModel = completeEnvironment.getOwnedCompleteModel();
	}
	
	@Override
	public @NonNull EnvironmentFactoryAdapter adapt(@NonNull Notifier notifier) {
		List<Adapter> eAdapters = ClassUtil.nonNullEMF(notifier.eAdapters());
		EnvironmentFactoryAdapter adapter = ClassUtil.getAdapter(EnvironmentFactoryAdapter.class, eAdapters);
		if (adapter == null) {
			adapter = new EnvironmentFactoryAdapter(this, notifier);
			eAdapters.add(adapter);
		}
		return adapter;
	}

	@Override
	public void addListener(@NonNull Listener listener) {
		List<Listener> listeners2 = listeners;
		if (listeners2 == null) {
			listeners = listeners2 = new ArrayList<Listener>();
		}
		if (!listeners2.contains(listener)) {
			listeners2.add(listener);
		}
	}

	@Override
	public synchronized void attach(Object object) {
		assert attachCount >= 0;
		attachCount++;
//		if (attachers == null) {
//			attachers = new ArrayList<WeakReference<Object>>();
//		}
//		attachers.add(new WeakReference<Object>(object));
	}

	@Override
	public @NonNull ResourceSetImpl createASResourceSet() {
		ResourceSetImpl asResourceSet = new ResourceSetImpl();
		StandaloneProjectMap.initializeURIResourceMap(asResourceSet);
		ASResourceFactoryRegistry.INSTANCE.configureResourceSet(asResourceSet);
		EPackage.Registry packageRegistry = asResourceSet.getPackageRegistry();
		packageRegistry.put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
		asResourceSet.eAdapters().add(projectManager);
		projectManager.initializeResourceSet(asResourceSet);
		return asResourceSet;
	}

	@Override
	public @NonNull CompleteEnvironmentInternal createCompleteEnvironment() {
		CompleteEnvironmentInternal completeEnvironment = (CompleteEnvironmentInternal)PivotFactory.eINSTANCE.createCompleteEnvironment();
		completeEnvironment.init(this);
		return completeEnvironment;
	}

	@Override
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull NamedElement executableObject, @NonNull ModelManager modelManager) {
		return new AbstractEvaluationEnvironment(this, executableObject, modelManager);
	}

	@Override
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent, @NonNull NamedElement executableObject) {
		return new AbstractEvaluationEnvironment(parent, executableObject);
	}

	@Override
	public @NonNull EvaluationVisitor createEvaluationVisitor(@Nullable Object context, @NonNull ExpressionInOCL expression, @Nullable ModelManager modelManager) {
		if (modelManager == null) {
			// let the evaluation environment create one
			modelManager = createModelManager(context);
		}
		// can determine a more appropriate context from the context
		// variable of the expression, to account for stereotype constraints
//		context = HelperUtil.getConstraintContext(rootEnvironment, context, expression);
		EvaluationEnvironment evaluationEnvironment = createEvaluationEnvironment(expression, modelManager);
		Variable contextVariable = expression.getOwnedContext();
		if (contextVariable != null) {
			IdResolver idResolver = getIdResolver();
			Object value = idResolver.boxedValueOf(context);
			evaluationEnvironment.add(contextVariable, value);
		}
		for (Variable parameterVariable : expression.getOwnedParameters()) {
			if (parameterVariable != null) {
				evaluationEnvironment.add(parameterVariable, null);
			}
		}
		return createEvaluationVisitor(evaluationEnvironment);
	}

	// implements the interface method
	@Override
	public @NonNull EvaluationVisitor createEvaluationVisitor(@NonNull EvaluationEnvironment evalEnv) {
	    EvaluationVisitor result = new OCLEvaluationVisitor(evalEnv);
	    
	    if (isEvaluationTracingEnabled()) {
	        // decorate the evaluation visitor with tracing support
	        result = new TracingEvaluationVisitor(result);
	    }
	    
	    return result;
	}

	@Override
	public  @NonNull IdResolver createIdResolver() {
		return technology.createIdResolver(this);
	}

	@Override
	public @NonNull ImplementationManager createImplementationManager() {
		return new ImplementationManager(this);
	}

	@Override
	public @NonNull PivotMetamodelManager createMetamodelManager() {
		return new PivotMetamodelManager(this, createASResourceSet(), null);
	}

	public @NonNull PivotMetamodelManager createMetamodelManager(@NonNull ResourceSet externalResourceSet) {
		assert metamodelManager == null;
		metamodelManager = new PivotMetamodelManager(this, createASResourceSet(), externalResourceSet);
		assert metamodelManager != null;
		return metamodelManager;
	}

	protected @NonNull ModelManager createModelManager() {
		return ModelManager.NULL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NonNull ModelManager createModelManager(@Nullable Object object) {
		if (object instanceof ObjectValue) {
			object = ((ObjectValue) object).getObject();
		}
		if (object instanceof EObject) {
			return new PivotModelManager(this, (EObject) object);
		}
		return ModelManager.NULL;
	}

	@Override
	public @NonNull ParserContext createParserContext(@Nullable EObject context) {
    	PivotMetamodelManager metamodelManager = getMetamodelManager();
		if (context instanceof org.eclipse.ocl.pivot.Class) {
			return new ClassContext(this, null, (org.eclipse.ocl.pivot.Class)context, null);
        }
        else if (context instanceof Operation) {
    		return new OperationContext(this, null, (Operation)context, null);
        }
        else if (context instanceof Property) {
        	return new PropertyContext(this, null, (Property)context);
        }
        else if (context instanceof EClassifier) {
        	org.eclipse.ocl.pivot.Class contextClass = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Class.class, context);
        	return new ClassContext(this, null, contextClass, null);
        }
        else if (context instanceof EOperation) {
    		Operation asOperation = metamodelManager.getASOfEcore(Operation.class, context);
    		if (asOperation != null) {
    			return new OperationContext(this, null, asOperation, null);
    		}
        }
        else if (context instanceof EStructuralFeature) {
        	Property asProperty = metamodelManager.getASOfEcore(Property.class, context);
    		if (asProperty != null) {
    			return new PropertyContext(this, null, asProperty);
    		}
        }
        return new ModelContext(this, null);
	}
	
	@Override
	public synchronized void detach(Object object) {
		assert attachCount > 0;
//		if (attachers != null) {
//			for (WeakReference<Object> attacher : attachers) {
//				if (attacher.get() == object) {
//					attachers.remove(attacher);
//					break;
//				}
//			}
//		}
		if (--attachCount <= 0) {
			dispose();
		}
	}

	@Override
	public void dispose() {
		if (listeners != null) {
			List<Listener> savedListeners = listeners;
			listeners = null;
			for (Listener listener : savedListeners) {
				listener.environmentFactoryDisposed(this);
			}
		}
		assert attachCount == 0;
		if (this != OCL.Internal.basicGetGlobalEnvironmentFactory()) {
			if (metamodelManager != null) {
				metamodelManager.dispose();
				metamodelManager = null;
			}
			if (idResolver != null) {
				idResolver.dispose();
				idResolver = null;
			}
			if (csi2asMapping != null) {
				csi2asMapping.dispose();
				csi2asMapping = null;
			}
		}
	}

	@Override
	public void disposeGlobal() {
		assert this == OCL.Internal.basicGetGlobalEnvironmentFactory();
		dispose();
		if (metamodelManager != null) {
			metamodelManager.dispose();
			metamodelManager = null;
		}
		if (idResolver != null) {
			idResolver.dispose();
			idResolver = null;
		}
		if (csi2asMapping != null) {
			csi2asMapping.dispose();
			csi2asMapping = null;
		}
	}

	/**
	 * The abstract environment factory implementation is adaptable.  The
	 * default implementation adapts to and interface actually implemented by
	 * the receiver.
	 * <p>
	 * Subclasses may override or extend this implementation.
	 * </p>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(java.lang.Class<T> adapterType) {
		T result;
		
		if (adapterType.isAssignableFrom(getClass())) {
			result = (T) this;
		} else {
			result = null;
		}
		
		return result;
	}

	/**
     * Obtains client metamodel's classifier for the specified
     * <code>context</code> object, which may be an instance of a classifier
     * in the user model or may actually be a classifier in the user model.
     * 
     * @param context a context object or classifier
     * @return the user model's classifier for this context object, or the
     *     context itself if it is a classifier
     */
	protected @NonNull org.eclipse.ocl.pivot.Class getClassifier(@NonNull Object context) {
		PivotMetamodelManager metamodelManager = getMetamodelManager();
		org.eclipse.ocl.pivot.Class dType = getIdResolver().getStaticTypeOf(context);
		return metamodelManager.getType(dType);
	}

	@Override
	public @NonNull CompleteEnvironmentInternal getCompleteEnvironment() {
		return completeEnvironment; //completeModel.getCompleteEnvironment();
	}

	@Override
	public @NonNull CompleteModelInternal getCompleteModel() {
		return completeModel;
	}

	@Override
	public @Nullable ICSI2ASMapping getCSI2ASMapping() {
		return csi2asMapping;
	}

	@Override
	public @Nullable String getDoSetupName(@NonNull URI uri) {
		String fileExtension = uri.fileExtension();
		if (PivotConstants.ESSENTIAL_OCL_FILE_EXTENSION.equals(fileExtension)) {
			return "EssentialOCLStandaloneSetup.doSetup()";
		}
		else if (PivotConstants.OCL_FILE_EXTENSION.equals(fileExtension)) {
			return "CompleteOCLStandaloneSetup.doSetup()";
		}
		else if (PivotConstants.OCLINECORE_FILE_EXTENSION.equals(fileExtension)) {
			return "OCLinEcoreStandaloneSetup.doSetup()";
		}
		else if (PivotConstants.OCLSTDLIB_FILE_EXTENSION.equals(fileExtension)) {
			return "OCLstdlibStandaloneSetup.doSetup()";
		}
		return null;
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		IdResolver idResolver2 = idResolver;
		if (idResolver2 == null) {
			idResolver = idResolver2 = createIdResolver();
		}
		return idResolver2;
	}

	@Override
	public @NonNull PivotMetamodelManager getMetamodelManager() {
		PivotMetamodelManager metamodelManager2 = metamodelManager;
		if (metamodelManager2 == null) {
			metamodelManager = metamodelManager2 = createMetamodelManager();
		}
		return metamodelManager2;
	}

	@Override
	protected @Nullable EnvironmentFactoryInternal getParent() {
		return null;
	}

	/**
	 * Return the ProjectMap used to resolve EPackages.
	 */
	@Override
	public @NonNull ProjectManager getProjectManager() {
		return projectManager;
	}
	
	@Override
	public @NonNull ResourceSet getResourceSet() {
		return getMetamodelManager().getExternalResourceSet();
	}

	@Override
	public @NonNull StandardLibraryInternal getStandardLibrary() {
		return standardLibrary;
	}

	@Override
	public @NonNull Technology getTechnology() {
		return technology;
	}

	/**
     * Queries whether tracing of evaluation is enabled.  Tracing
     * logs the progress of evaluation to the console, which may
     * be of use in diagnosing problems.
     * <p>
     * In an Eclipse environment, tracing is also enabled by turning on the
     * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option. 
     * </p>
     * 
     * @return whether evaluation tracing is enabled
     * 
     * @see #setEvaluationTracingEnabled(boolean)
     */
    protected boolean isEvaluationTracingEnabled() {
        return traceEvaluation;
    }

	@Override
	public void removeListener(@NonNull Listener listener) {
		if (listeners != null) {
			listeners.remove(listener);
		}
	}

	@Override
	public void setCSI2ASMapping(ICSI2ASMapping csi2asMapping) {
		this.csi2asMapping = csi2asMapping;
	}
	
    /**
     * Sets whether tracing of evaluation is enabled.  Tracing logs
     * the progress of parsing to the console, which may be of use in diagnosing
     * problems.
     * <p>
     * In an Eclipse environment, tracing is also enabled by turning on the
     * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option. 
     * </p>
     * 
     * param b whether evaluation tracing is enabled
     * 
     * @see #isEvaluationTracingEnabled()
     */
    @Override
	public void setEvaluationTracingEnabled(boolean b) {
        traceEvaluation = b;
    }
}
