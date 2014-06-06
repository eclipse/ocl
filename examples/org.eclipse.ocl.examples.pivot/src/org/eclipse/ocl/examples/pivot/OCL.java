/*******************************************************************************
 * Copyright (c) 2006, 2013 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.evaluation.EvaluationHaltedException;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.helper.OCLHelperImpl;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.QueryImpl;

/**
 * Convenient subclass of the <code>OCL</code> fa&ccedil;ade that binds the
 * Ecore metamodel to the superclass's generic type parameters.  This frees
 * client code from the long list of parameter substitutions.  This subclass
 * also provides a shortcut to creating an <code>OCL</code> on the shared
 * {@link EnvironmentFactory} instance.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @see EnvironmentFactory
 */
public class OCL {

	/**
	 * Initialize registries to support OCL and Ecore usage. This method is
	 * intended for initialization of standalone behaviors for which plugin extension
	 * registrations have not been applied. 
	 *<p> 
	 * A null resourceSet may be provided to initialize the global package registry
	 * and global URI mapping registry.
	 *<p> 
	 * A non-null resourceSet may be provided to identify a specific package registry.
	 *<p>
	 * This method is used to configure the ResourceSet used to load the OCL Standard Library.

	 * @param resourceSet to be initialized or null for global initialization
	 * @return a failure reason, null if successful
	 * 
	 */
	public static String initialize(@Nullable ResourceSet resourceSet) {
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet != null
			? resourceSet.getResourceFactoryRegistry()
			: Resource.Factory.Registry.INSTANCE;
		resourceFactoryRegistry.getExtensionToFactoryMap().put(
			"ecore", new EcoreResourceFactoryImpl()); //$NON-NLS-1$
		return null;
	}

    /**
     * Creates a new <code>OCL</code> with no initial Ecore package registry.
     * This automatically creates a new EnvironmentFactory and MetaModelManager.
     * 
     * @return the new <code>OCL</code>
     */
	public static @NonNull OCL newInstance() {
		return newInstance(new PivotEnvironmentFactory(null, new MetaModelManager()));
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore package registry.
     * This automatically creates an new EnvironmentFactory and MetaModelManager.
     * 
     * @param reg Ecore package registry
     * @return the new <code>OCL</code>
     */
	public static @NonNull OCL newInstance(@NonNull EPackage.Registry reg) {	
		return newInstance(new PivotEnvironmentFactory(reg, new MetaModelManager()));
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment
     * factory.
     * 
     * @param envFactory an environment factory for Ecore
     * @return the new <code>OCL</code>
     */
	public static @NonNull OCL newInstance(@NonNull EnvironmentFactory envFactory) {	
		return new OCL(envFactory, envFactory.createEnvironment());
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment
     * factory and a resource from which to load the initial environment.
     * 
     * @param envFactory an environment factory for Ecore
     * @param resource the resource containing a persistent environment
     *    (which may be empty for an initially empty environment)
     * @return the new <code>OCL</code>
     */
	public static @NonNull OCL newInstance(@NonNull EnvironmentFactory envFactory, @NonNull Resource resource) {	
		return new OCL(envFactory, envFactory.loadEnvironment(resource));
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified initial Ecore
     * environment.
     * 
     * @param env an environment for Ecore
     * @return the new <code>OCL</code>
     */
	public static @NonNull OCL newInstance(@NonNull Environment env) {	
		return new OCL(env.getFactory(), env);
	}
	
	private final @NonNull EnvironmentFactory environmentFactory;

	private final @NonNull Environment rootEnvironment;

	private /*@LazyNonNull*/ EvaluationEnvironment evalEnv;

	private @Nullable DomainModelManager modelManager;

	private @NonNull List<Constraint> constraints = new java.util.ArrayList<Constraint>();

	private @Nullable Diagnostic problems;
	private @Nullable Diagnostic evaluationProblems;	

	private int parserRepairCount = 0;

	private boolean traceParsing = PivotPlugin.shouldTrace(OCLDebugOptions.PARSING);

	private boolean traceEvaluation = PivotPlugin.shouldTrace(OCLDebugOptions.EVALUATION);

	/**
	 * Initializes me with my environment factory and root environment.
	 * 
	 * @param envFactory
	 *            my environment factory
	 * @param rootEnv
	 *            my root environment
	 */
	protected OCL(@NonNull EnvironmentFactory envFactory, @NonNull Environment rootEnv) {
		this.environmentFactory = envFactory;
		this.rootEnvironment = rootEnv;

		if (envFactory instanceof AbstractEnvironmentFactory) {
			AbstractEnvironmentFactory abstractFactory = (AbstractEnvironmentFactory) envFactory;

			abstractFactory.setEvaluationTracingEnabled(traceEvaluation);
		}
	}

	/**
	 * Checks whether a constraint is satisfied by an object. If the constraint
	 * is an invariant constraint, then no additional variable bindings are
	 * required. If it is an operation precondition or postcondition, however,
	 * then the appropriate parameter variables and (in the postcondition case)
	 * result variable should be bound in the evaluation environment.
	 * 
	 * @param context
	 *            the <tt>self</tt> object of the constraint
	 * @param constraint
	 *            the constraint to check
	 * 
	 * @return whether the context object satisfies the constraint
	 * 
	 * @see #check(Object, ExpressionInOCL)
	 * @see #evaluate(Object, ExpressionInOCL)
	 */
	public boolean check(Object context, @NonNull Constraint constraint) {
		OpaqueExpression specification =  constraint.getSpecification();
		return (specification instanceof ExpressionInOCL) && check(context, (ExpressionInOCL)specification);
	}

	/**
	 * Checks whether a constraint, specified simply as an OCL expression, is
	 * satisfied by an object. If the constraint is an invariant constraint,
	 * then no additional variable bindings are required. If it is an operation
	 * precondition or postcondition, however, then the appropriate parameter
	 * variables and (in the postcondition case) result variable should be bound
	 * in the evaluation environment.
	 * 
	 * @param context
	 *            the <tt>self</tt> object of the constraint
	 * @param specification
	 *            the constraint to check, which must be a boolean-valued
	 *            expression
	 * 
	 * @return whether the context object satisfies the constraint
	 * 
	 * @see #check(Object, ExpressionInOCL)
	 * @see #evaluate(Object, ExpressionInOCL)
	 * 
	 * @throws IllegalArgumentException
	 *             if the constraint expression is not boolean-valued
	 */
	public boolean check(Object context, @NonNull ExpressionInOCL specification) {
		DomainStandardLibrary stdlib = getEnvironment().getOCLStandardLibrary();
		if (specification.getBodyExpression().getType() != stdlib.getBooleanType()) {
			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
		}
		try {
			Object result = evaluate(context, specification);
			return result == ValuesUtil.TRUE_VALUE;
		} catch (InvalidValueException e) {
			return false;
		}
	}

    /**
     * Creates a new evaluation visitor, for the evaluation of an OCL expression in a context.
     * The evaluationVisitor reuses any previously established ModelManager.
     */
	public @NonNull EvaluationVisitor createEvaluationVisitor(@Nullable Object context, @NonNull ExpressionInOCL expression) {
		return environmentFactory.createEvaluationVisitor(rootEnvironment, context, expression, modelManager);
	}

	/**
	 * Creates a new {@link OCLHelper} instance for convenient parsing of
	 * embedded constraints and query expressions in this environment. The
	 * helper is particularly useful for parsing constraints embedded in the
	 * model, in which case the context of a constraint is determined by its
	 * placement and the textual context declarations are unnecessary.
	 * 
	 * @return a new helper object
	 */
    public @NonNull OCLHelper createOCLHelper() {
        return new OCLHelperImpl(this);
     }
    
	/**
	 * Creates a new {@link OCLHelper} instance for convenient parsing of
	 * embedded constraints and query expressions in the nested environment
	 * of a specified element which mya be a Type, Operation or Property. The
	 * helper is particulary useful for parsing constraints embedded in the
	 * model, in which case the context of a constraint is determined by its
	 * placement and the textual context declarations are unnecessary.
	 * 
	 * @return a new helper object
	 */
    public @NonNull OCLHelper createOCLHelper(@NonNull EObject element) {
        OCLHelperImpl helper = new OCLHelperImpl(this);
        if (element instanceof Type) {
        	helper.setContext((Type)element);
        }
        else if (element instanceof Operation) {
        	Operation operation = (Operation)element;
			Type owningType = operation.getOwningType();
			if (owningType != null) {
				helper.setOperationContext(owningType, operation);
			}
        }
        else if (element instanceof Property) {
        	Property property = (Property)element;
			Type owningType = property.getOwningType();
			if (owningType != null) {
				helper.setPropertyContext(owningType, property);
			}
        }
        else if (element instanceof EClassifier) {
        	helper.setContext((EClassifier)element);
        }
        else if (element instanceof EOperation) {
        	EOperation operation = (EOperation)element;
			EClass eContainingClass = operation.getEContainingClass();
			if (eContainingClass != null) {
				helper.setOperationContext(eContainingClass, operation);
			}
        }
        else if (element instanceof EStructuralFeature) {
        	EStructuralFeature property = (EStructuralFeature)element;
			EClass eContainingClass = property.getEContainingClass();
			if (eContainingClass != null) {
				helper.setPropertyContext(eContainingClass, property);
			}
        }
		return helper;
     }

	/**
	 * Creates a new {@link Query} encapsulating a query expression with the
	 * current environment and extent map. This is convenient for repeated
	 * evaluation of expressions and for filtering/transforming objects using a
	 * query or constraint expression.
	 * <p>
	 * Every query maintains its own evaluation environment, which enables
	 * concurrent evaluation (where this may be safe in an EMF-based model) and
	 * different bindings for client-supplied "global" variables.
	 * </p>
	 * 
	 * @param specification
	 *            the OCL query expression, which may be interpreted as a
	 *            constraint if it is boolean-valued
	 * 
	 * @return the new query object
	 * 
	 * @see #createQuery(ExpressionInOCL)
	 */
	public @NonNull Query createQuery(@NonNull ExpressionInOCL specification) {
		return new QueryImpl(this, specification);
	}

	/**
	 * Creates a new {@link Query} encapsulating a constraint with the current
	 * environment and extent map. This is convenient for repeated evaluation of
	 * constraints and for filtering objects using the constraint expression.
	 * <p>
	 * Every query maintains its own evaluation environment, which enables
	 * concurrent evaluation (where this may be safe in an EMF-based model) and
	 * different bindings for client-supplied "global" variables.
	 * </p>
	 * 
	 * @param constraint
	 *            the OCL constraint
	 * 
	 * @return the new query object
	 * 
	 * @see #createQuery(ExpressionInOCL)
	 */
	public Query createQuery(@NonNull Constraint constraint) {
		OpaqueExpression specification = constraint.getSpecification();
		if (specification instanceof ExpressionInOCL) {
			return new QueryImpl(this, (ExpressionInOCL) specification);
		}
		else {
			return null;
		}
	}

	/**
	 * Return the Pivot resource counterpart of an Xtext csResource.
	 */
	public @NonNull Resource cs2pivot(@NonNull BaseResource csResource) {
		MetaModelManager metaModelManager = getMetaModelManager();
		Resource asResource = csResource.getASResource(metaModelManager);
		return asResource;
	}

	/**
	 * Disposes any objects that I have created while I have been in use. This
	 * includes disposing of any {@link #getConstraints() constraints} that I
	 * have parsed and {@linkplain Environment#dispose() disposing} of
	 * my environment.
	 */
	public void dispose() {
		// dispose of constraints by clearing their adapters
		for (Constraint constraint : getConstraints()) {
			EObject eObject = constraint;
			if (eObject.eResource() == null) {
				ObjectUtil.dispose(constraint);
			}
		}

		// forget the constraints
		getConstraints().clear();

		if (environmentFactory != PivotEnvironmentFactory.basicGetGlobalRegistryInstance()) { // dispose of my environment
			getEnvironment().dispose();
			getMetaModelManager().dispose();
		}
	}

	/**
	 * Return the Pivot resource counterpart of an ecoreResource.
	 */
	public @NonNull ASResource ecore2pivot(@NonNull Resource ecoreResource) throws ParserException {
		MetaModelManager metaModelManager = getMetaModelManager();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
		Root pivotRoot = ecore2Pivot.getPivotRoot();
		ASResource asResource = (ASResource) pivotRoot.eResource();
		return DomainUtil.nonNullModel(asResource);
	}

	/**
	 * Evaluates a query expression on a context object (which is bound to the
	 * <tt>self</tt> variable).
	 * 
	 * @param context
	 *            the context (self) object
	 * @param expression
	 *            the OCL expression to evaluate
	 * 
	 * @return the value of the expression, or <tt>OclInvalid</tt> if the
	 *         evaluation fails for reasons other than a run-time exception
	 * 
	 * @see #check(Object, ExpressionInOCL)
	 */
	public @Nullable Object evaluate(@Nullable Object context, @NonNull ExpressionInOCL expression) {
		evaluationProblems = null;
		EvaluationVisitor evaluationVisitor = environmentFactory.createEvaluationVisitor(rootEnvironment, context, expression, modelManager);
		try {
			Object result = expression.accept(evaluationVisitor);
			return result;
		} catch (EvaluationHaltedException e) {
			evaluationProblems = e.getDiagnostic();
			throw e;
		}
	}

	/**
	 * Obtains all of the constraints parsed hitherto by this OCL instance.
	 * These accumulate with every document that is parsed.
	 * 
	 * @return the constraints that I have parsed
	 * 
	 * @see #parse(URI)
	 */
	public @NonNull List<Constraint> getConstraints() {
		return constraints;
	}

	/**
	 * Obtains the root OCL parsing environment.
	 * 
	 * @return the parsing environment
	 */
	public @NonNull Environment getEnvironment() {
		return rootEnvironment;
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	/**
	 * Obtains the OCL evaluation environment. Clients may manipulate this
	 * environment to support custom requirements, such as binding the values of
	 * "global" variables.
	 * 
	 * @return the evaluation environment
	 * 
	 * @see #getEnvironment()
	 * @deprecated no longer called
	 */
	@Deprecated
	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		EvaluationEnvironment evalEnv2 = evalEnv;
		if (evalEnv2 == null) {
			evalEnv2 = evalEnv = environmentFactory.createEvaluationEnvironment();
		}
		return evalEnv2;
	}
	
	/**
	 * Obtains problems, if any, occurred during evaluation of the last OCL
	 * constraint or query expression.
	 * 
	 * @return evaluation problems or <code>null</code> if all was OK
	 */
	public @Nullable Diagnostic getEvaluationProblems() {
		return evaluationProblems;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return rootEnvironment.getMetaModelManager();
	}

	/**
	 * Obtains the model manager, if any, provided by the client to customize the
	 * evaluation of constraints.
	 * 
	 * @return the client-provided custom model manager, or <code>null</code> if
	 *         thie OCL is using the default dynamic extent map implementation
	 */
	public @Nullable DomainModelManager getModelManager() {
		return modelManager;
	}

	/**
	 * <p>
	 * Queries the number of repairs to be made by the parser.
	 * </p>
	 * <p>
	 * The default zero value selects use of the deterministic parser, which
	 * terminates after one serious syntax error is detected.
	 * </p>
	 * <p>
	 * A non-zero value selects the backtracking parser. The backtracking parser
	 * may be about three times slower.
	 * </p>
	 * 
	 * @return the number of repairs to be attempted
	 * 
	 * @see #setParserRepairCount(int)
	 */
	public int getParserRepairCount() {
		return parserRepairCount;
	}

	/**
	 * Obtains problems, if any, found in parsing the last OCL constraint or
	 * query expression.
	 * 
	 * @return parsing problems or <code>null</code> if all was OK
	 */
	public @Nullable Diagnostic getProblems() {
		return problems;
	}

	/**
	 * Return the Constraint specification as an ExpressionInOCL, parsing any OpaqueExpression
	 * that may be encountered.
	 */
	public @Nullable ExpressionInOCL getSpecification(@NonNull Constraint constraint) throws ParserException {
		OpaqueExpression specification = constraint.getSpecification();
		ExpressionInOCL expressionInOCL = null;
		if (specification instanceof ExpressionInOCL) {
			expressionInOCL = (ExpressionInOCL)specification;
		}
		else if (specification != null){
			String expression = PivotUtil.getBody(specification);
		    if (expression != null) {
		    	NamedElement contextElement = constraint.getContext();
				if (contextElement != null) {
					OCLHelper helper = createOCLHelper(contextElement);
					if (contextElement instanceof Operation) {
						expressionInOCL = helper
							.createBodyCondition(expression);
					} else {
						expressionInOCL = helper.createQuery(expression);
					}
				}
		    }
		}
		return expressionInOCL;
	}

	/**
	 * Queries whether tracing of evaluation is enabled. Tracing logs the
	 * progress of evaluation to the console, which may be of use in diagnosing
	 * problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option.
	 * </p>
	 * 
	 * @return whether evaluation tracing is enabled
	 * 
	 * @see #setEvaluationTracingEnabled(boolean)
	 */
	public boolean isEvaluationTracingEnabled() {
		return traceEvaluation;
	}

	/**
	 * Queries whether a value is the special <tt>invalid</tt> token. This is
	 * useful for determining whether the result of an expression evaluation is
	 * valid.
	 * 
	 * @param value
	 *            some OCL value
	 * @return <code>true</code> if it is the <tt>invalid</tt>;
	 *         <code>false</code>, otherwise
	 * 
	 * @see #evaluate(Object, OCLExpression)
	 */
//	public boolean isInvalid(Object value) {
//		return getEnvironment().getOCLStandardLibrary().getInvalidValue() == value;
//	}

	/**
	 * Queries whether tracing of parsingis enabled. Tracing logs the progress
	 * of parsing to the console, which may be of use in diagnosing problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/parsing</tt> debug option.
	 * </p>
	 * 
	 * @return whether parse tracing is enabled
	 * 
	 * @see #setParseTracingEnabled(boolean)
	 */
	public boolean isParseTracingEnabled() {
		return traceParsing;
	}

	/**
	 * Load the Complete OCL document specified by the URI into the external ResourceSet and
	 * return the concrete syntax resource.
	 */
	public @Nullable BaseResource load(@NonNull URI uri) {
		ResourceSet externalResourceSet = getMetaModelManager().getExternalResourceSet();
		return (BaseResource) externalResourceSet.getResource(uri, true);
	}

	/**
	 * Load the Complete OCL document specified by the URI into the external ResourceSet and
	 * parse the concrete syntax resource returning the resulting abstract syntax resource.
	 */
	public @Nullable Resource parse(@NonNull URI uri) {
		BaseResource csResource = load(uri);
		return csResource != null ? cs2pivot(csResource) : null;
	}

	/**
	 * Update the CS resource from a asResource.
	 * 
	 * For a first update, the csResource may be created by something like
	 * <p><tt>
	 * (BaseResource) resourceSet.createResource(outputURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
	 * </tt>
	 */
	public void pivot2cs(@NonNull ASResource asResource, @NonNull BaseResource csResource) {
		MetaModelManager metaModelManager = getMetaModelManager();
		csResource.updateFrom(asResource, metaModelManager);
	}

	/**
	 * Return the Ecore resource counterpart of a asResource, specifying the uri of the resulting Ecore resource.
	 */
	public @NonNull Resource pivot2ecore(@NonNull Resource asResource, @NonNull URI uri) throws IOException {
		MetaModelManager metaModelManager = getMetaModelManager();
		Resource ecoreResource = Pivot2Ecore.createResource(metaModelManager, asResource, uri, null);
		return ecoreResource;
	}

	/**
	 * Sets whether tracing of evaluation is enabled. Tracing logs the progress
	 * of parsing to the console, which may be of use in diagnosing problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option.
	 * </p>
	 * 
	 * @param b
	 *            whether evaluation tracing is enabled
	 * 
	 * @see #isEvaluationTracingEnabled()
	 */
	public void setEvaluationTracingEnabled(boolean b) {
		traceEvaluation = b;

		if (environmentFactory instanceof AbstractEnvironmentFactory) {
			AbstractEnvironmentFactory abstractFactory = (AbstractEnvironmentFactory) environmentFactory;

			abstractFactory.setEvaluationTracingEnabled(traceEvaluation);
		}
	}

	/**
	 * Assigns a custom extent map to define the extents of classes in
	 * evaluation of OCL constraints. This is only needed if the default dynamic
	 * extent-map implementation is not suitable.
	 * 
	 * @param modelManager
	 *            a custom extent map, or <code>null</code> to use the default
	 *            dynamic extent map implementation
	 */
	public void setModelManager(@Nullable DomainModelManager modelManager) {
		this.modelManager = modelManager;
	}

	/**
	 * <p>
	 * Sets the number of repairs to be made by the parser.
	 * </p>
	 * <p>
	 * The default zero value selects use of the deterministic parser, which
	 * terminates after one serious syntax error is detected.
	 * </p>
	 * <p>
	 * A non-zero value selects the backtracking parser. The backtracking parser
	 * may be about three times slower.
	 * </p>
	 * 
	 * @param parserRepairCount
	 *            whether evaluation tracing is enabled
	 * 
	 * @throws IllegalArgumentException
	 *             if the <tt>parserRepairCount</tt> is negative
	 * 
	 * @see #getParserRepairCount()
	 */
	public void setParserRepairCount(int parserRepairCount) {
		if (parserRepairCount < 0) {
			throw new IllegalArgumentException("negative repair count"); //$NON-NLS-1$
		}

		this.parserRepairCount = parserRepairCount;
	}

	/**
	 * Sets whether tracing of parsing is enabled. Tracing logs the progress of
	 * parsing to the console, which may be of use in diagnosing problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/parsing</tt> debug option.
	 * </p>
	 * 
	 * param b whether parsing tracing is enabled
	 * 
	 * @see #isParseTracingEnabled()
	 */
	public void setParseTracingEnabled(boolean b) {
		traceParsing = b;
	}

	/**
	 * Return the Pivot resource counterpart of a umlResource.
	 * @throws ParserException 
	 */
	public @NonNull ASResource uml2pivot(@NonNull Resource umlResource) throws ParserException {
		MetaModelManager metaModelManager = getMetaModelManager();
		UML2Pivot uml2Pivot = UML2Pivot.getAdapter(umlResource, metaModelManager);
		Root pivotRoot = uml2Pivot.getPivotRoot();
		ASResource asResource = (ASResource) pivotRoot.eResource();
		return DomainUtil.nonNullModel(asResource);
	}

	/**
	 * Validates an OCL expression, which may have been loaded from some
	 * resource or constructed via the API (perhaps by translation from some
	 * other language).
	 * 
	 * @param expression
	 *            an expression to validate
	 * 
	 * @throws SemanticException
	 *             on detection of any well-formedness problem in the expression
	 * 
	 * @see #validate(Constraint)
	 */
	public void validate(@NonNull OCLExpression expression) throws SemanticException {
		throw new UnsupportedOperationException(getClass().getName() + ".validate");
		// clear out old diagnostics
/*		ProblemHandler ph = OCLUtil.getAdapter(rootEnvironment,
			ProblemHandler.class);
		if (ph != null) {
			ph.beginValidation();
		}

		expression.accept(ValidationVisitor.getInstance(rootEnvironment));

		if (ph != null) {
			ph.endValidation();

			try {
				OCLUtil.checkForErrors(ph);
			} catch (SyntaxException e) {
				// shouldn't actually be able to get this from validation
				throw new SemanticException(e.getDiagnostic());
			}
		} */
	}

	/**
	 * Validates an OCL constraint, which may have been loaded from some
	 * resource or constructed via the API (perhaps by translation from some
	 * other language).
	 * 
	 * @param constraint
	 *            a constraint to validate
	 * 
	 * @throws SemanticException
	 *             on detection of any well-formedness problem in the constraint
	 */
	public void validate(@NonNull Constraint constraint) throws SemanticException {
		throw new UnsupportedOperationException(getClass().getName() + ".validate");
		// clear out old diagnostics
/*		ProblemHandler ph = OCLUtil.getAdapter(rootEnvironment,
			ProblemHandler.class);
		if (ph != null) {
			ph.beginValidation();
		}

		ValidationVisitor.getInstance(rootEnvironment).visitConstraint(
			constraint);

		if (ph != null) {
			ph.endValidation();

			try {
				OCLUtil.checkForErrors(ph);
			} catch (SyntaxException e) {
				// shouldn't actually be able to get this from validation
				throw new SemanticException(e.getDiagnostic());
			}
		} */
	}
}
