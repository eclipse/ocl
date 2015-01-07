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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
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
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.PivotIdResolver;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.values.ObjectValue;

/**
 * Partial implementation of the {@link EnvironmentFactoryInternal} interface, useful
 * for subclassing to define the Pivot binding for a metamodel.
 */
public abstract class AbstractEnvironmentFactory extends AbstractCustomizable implements EnvironmentFactoryInternal
{
	/**
     * A convenient shared instance of the environment factory, that creates
     * environments using the global package registry.
	 */
    private static @Nullable EnvironmentFactory globalRegistryInstance = null;

	public static @Nullable EnvironmentFactory basicGetGlobalRegistryInstance() {
		return globalRegistryInstance;
	}

    /**
     * Dispose of the global instance; this is intended for leakage detection in tests.
     */
	public static void disposeGlobalRegistryInstance() {
		if (globalRegistryInstance != null) {
			globalRegistryInstance.getMetamodelManager().dispose();
			globalRegistryInstance = null;
		}
	}
	
	public static @NonNull EnvironmentFactory getGlobalRegistryInstance() {
		EnvironmentFactory globalRegistryInstance2 = globalRegistryInstance;
		if (globalRegistryInstance2 == null) {
			globalRegistryInstance = globalRegistryInstance2 = OCL.createEnvironmentFactory(null);
		}
		return globalRegistryInstance2;
	}

    private boolean traceEvaluation;
    private /*@LazyNonNull*/ ProjectManager projectManager;
    private /*@LazyNonNull*/ MetamodelManager metamodelManager;
    
    /**
     * Count of the number of OCL instances that are using the EnvironmentFactory. auto-disposes on cunbt down to zero.
     */
    private int attachCount = 0;;
	
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
	 * Initializes me.
	 */
	protected AbstractEnvironmentFactory(@Nullable ProjectManager projectManager) {
		this.projectManager = projectManager;
		this.metamodelManager = null;
	}

	@Override
	public synchronized void attach(Object object) {
		assert attachCount >= 0;
		attachCount++;
	}

	@Override
	public @NonNull ResourceSetImpl createASResourceSet(@NonNull MetamodelManager metamodelManager) {
		ResourceSetImpl asResourceSet = new ResourceSetImpl();
		StandaloneProjectMap.initializeURIResourceMap(asResourceSet);
		ASResourceFactoryRegistry.INSTANCE.configureResourceSet(asResourceSet);
		EPackage.Registry packageRegistry = asResourceSet.getPackageRegistry();
		packageRegistry.put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
		asResourceSet.eAdapters().add(metamodelManager);
		if (projectManager != null) {
			asResourceSet.eAdapters().add(projectManager);
		}
		return asResourceSet;
	}

	@Override
	public @NonNull CompleteEnvironmentInternal createCompleteEnvironment(@NonNull MetamodelManager metamodelManager) {
		CompleteEnvironmentInternal completeEnvironment = (CompleteEnvironmentInternal)PivotFactory.eINSTANCE.createCompleteEnvironment();
		completeEnvironment.init(metamodelManager);
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
			IdResolver idResolver = getMetamodelManager().getIdResolver();
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
			return new PivotModelManager(getMetamodelManager(), (EObject) object);
		}
		return ModelManager.NULL;
	}

	@Override
	public  @NonNull PivotIdResolver createIdResolver(@NonNull MetamodelManager metamodelManager) {
		return new PivotIdResolver(metamodelManager);
	}

	@Override
	public @NonNull MetamodelManager createMetamodelManager() {
		return new MetamodelManager(this, null);
	}

	@Override
	@NonNull
	public MetamodelManager createMetamodelManager(@NonNull ResourceSet resourceSet) {
		assert metamodelManager == null;
		metamodelManager = new MetamodelManager(this, resourceSet);
		assert metamodelManager != null;
		return metamodelManager;
	}

	@Override
	public @NonNull ParserContext createParserContext(@Nullable EObject context) {
    	MetamodelManager metamodelManager = getMetamodelManager();
		if (context instanceof org.eclipse.ocl.pivot.Class) {
			return new ClassContext(metamodelManager, null, (org.eclipse.ocl.pivot.Class)context, null);
        }
        else if (context instanceof Operation) {
    		return new OperationContext(metamodelManager, null, (Operation)context, null);
        }
        else if (context instanceof Property) {
        	return new PropertyContext(metamodelManager, null, (Property)context);
        }
        else if (context instanceof EClassifier) {
        	org.eclipse.ocl.pivot.Class contextClass = metamodelManager.getPivotOfEcore(org.eclipse.ocl.pivot.Class.class, context);
        	return new ClassContext(metamodelManager, null, contextClass, null);
        }
        else if (context instanceof EOperation) {
    		Operation asOperation = metamodelManager.getPivotOfEcore(Operation.class, context);
    		if (asOperation != null) {
    			return new OperationContext(metamodelManager, null, asOperation, null);
    		}
        }
        else if (context instanceof EStructuralFeature) {
        	Property asProperty = metamodelManager.getPivotOfEcore(Property.class, context);
    		if (asProperty != null) {
    			return new PropertyContext(metamodelManager, null, asProperty);
    		}
        }
        return new ModelContext(metamodelManager, null);
	}
	
	@Override
	public @NonNull ImplementationManager createImplementationManager() {
		return new ImplementationManager(getMetamodelManager());
	}

	@Override
	public synchronized void detach(Object object) {
		assert attachCount > 0;
		if (--attachCount <= 0) {
			dispose();
		}
	}

	protected void dispose() {
		if (this != basicGetGlobalRegistryInstance()) { // dispose of my environment
			if (metamodelManager != null) {
				metamodelManager.dispose();
				metamodelManager = null;
			}
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
		MetamodelManager metamodelManager = getMetamodelManager();
		org.eclipse.ocl.pivot.Class dType = metamodelManager.getIdResolver().getStaticTypeOf(context);
		return metamodelManager.getType(dType);
	}

	@Override
	public String getExtensionName(@NonNull Element asStereotypedElement) {
		String name = "????";
		if (asStereotypedElement instanceof NamedElement) {
			name = ((NamedElement)asStereotypedElement).getName();
		}
		return name;
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		return getMetamodelManager().getIdResolver();
	}

	@Override
	public RootPackageId getMetamodelId(@NonNull EPackage ePackage) {
		assert !"http://www.eclipse.org/uml2/5.0.0/UML".equals(ePackage.getNsURI());
		assert !"http://www.eclipse.org/uml2/5.0.0/Types".equals(ePackage.getNsURI());
		RootPackageId metamodel = null;
		if (ClassUtil.basicGetMetamodelAnnotation(ePackage) != null) {
			metamodel = IdManager.METAMODEL;
		}
		else {
			String nsURI = ePackage.getNsURI();
			String sharedNsURI = getMetamodelManager().getCompleteModel().getCompleteURI(nsURI);
			if ((sharedNsURI != null) && !sharedNsURI.equals(nsURI)) {
				metamodel = IdManager.getRootPackageId(sharedNsURI);
			}
		}
		return metamodel;
	}

	@Override
	public @NonNull MetamodelManager getMetamodelManager() {
		MetamodelManager metamodelManager2 = metamodelManager;
		if (metamodelManager2 == null) {
			metamodelManager = metamodelManager2 = createMetamodelManager();
		}
		return metamodelManager2;
	}

	@Override
	public @NonNull PackageId getMetapackageId(@NonNull org.eclipse.ocl.pivot.Package asPackage) {
		if (asPackage instanceof PivotObjectImpl) {
			EObject eTarget = ((PivotObjectImpl)asPackage).getETarget();
			if (eTarget != null) {
				EClass eClass = eTarget.eClass();
				if (eClass != null) {
					EPackage ePackage = eClass.getEPackage();
					assert !"http://www.eclipse.org/uml2/5.0.0/UML".equals(ePackage.getNsURI());
					assert !"http://www.eclipse.org/uml2/5.0.0/Types".equals(ePackage.getNsURI());
				}
			}
		}
		return IdManager.METAMODEL;
	}

	@Override
	public String getOriginalName(@NonNull ENamedElement eNamedElement) {
		return eNamedElement.getName();
	}

	@Override
	protected @Nullable EnvironmentFactoryInternal getParent() {
		return null;
	}

	@Override
	public @Nullable Element getParseableElement(@NonNull EObject eObject) throws ParserException {
		if (eObject instanceof Element) {
			return (Element) eObject;
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull ProjectManager getProjectManager() {
		ProjectManager projectManager2 = projectManager;
		if (projectManager2 == null) {
			projectManager = projectManager2 = EcorePlugin.IS_ECLIPSE_RUNNING ? new StandaloneProjectMap() : new ProjectMap();
		}
		return projectManager2;
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
	public boolean isStereotype(@NonNull EClass eClass) {
		for (EStructuralFeature eFeature : eClass.getEAllStructuralFeatures()) {
			EClassifier eType = eFeature.getEType();
			if (eType != null) {
				EPackage ePackage = eType.getEPackage();
				assert !"http://www.eclipse.org/uml2/5.0.0/UML".equals(ePackage.getNsURI());
			}
		}
		return false;
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
