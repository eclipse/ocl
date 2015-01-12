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

package org.eclipse.ocl.pivot.utilities;

import java.io.IOException;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.SemanticException;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.EvaluationHaltedException;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.OCLDebugOptions;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.helper.HelperUtil;
import org.eclipse.ocl.pivot.internal.helper.OCLHelperImpl;
import org.eclipse.ocl.pivot.internal.helper.QueryImpl;
import org.eclipse.ocl.pivot.internal.manager.EnvironmentFactoryResourceSetAdapter;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * Convenient subclass of the <code>OCL</code> fa&ccedil;ade that binds the
 * Ecore metamodel to the superclass's generic type parameters.  This frees
 * client code from the long list of parameter substitutions.  This subclass
 * also provides a shortcut to creating an <code>OCL</code> on the shared
 * {@link EnvironmentFactoryInternal} instance.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @see EnvironmentFactoryInternal
 */
public class OCL
{
	public static class Internal extends OCL
	{
		public static @NonNull EnvironmentFactoryInternal createEnvironmentFactory(@Nullable ProjectManager projectManager) {
			return ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(projectManager);
		}
		
		public static @NonNull Internal newInstance() {
			return newInstance(createEnvironmentFactory(null));
		}
		
		public static @NonNull Internal newInstance(@Nullable ProjectManager projectManager) {	
			return newInstance(createEnvironmentFactory(projectManager));
		}
		
		public static @NonNull Internal newInstance(@NonNull EnvironmentFactoryInternal environmentFactory) {	
			return new Internal(environmentFactory);
		}
		
		public Internal(@NonNull EnvironmentFactoryInternal environmentFactory) {
			super(environmentFactory);
		}

		@Override
		public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
			return getEnvironmentFactoryInternal();
		}

		@Override
		public @NonNull StandardLibraryInternal getStandardLibrary() {
			return getEnvironmentFactoryInternal().getStandardLibrary();
		}
	}
	
	public static @NonNull EnvironmentFactory createEnvironmentFactory(@Nullable ProjectManager projectManager) {
//		OCLstdlib.lazyInstall();
		return ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(projectManager);
	}
	
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
     * This automatically creates a new EnvironmentFactory and MetamodelManager.
     * 
     * @return the new <code>OCL</code>
     */
	public static @NonNull OCL newInstance() {
		return newInstance(createEnvironmentFactory(null));
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore package registry.
     * This automatically creates an new EnvironmentFactory and MetamodelManager.
     * 
     * @param reg Ecore package registry
     * @return the new <code>OCL</code>
     */
	public static @NonNull OCL newInstance(@Nullable ProjectManager projectManager) {	
		return newInstance(createEnvironmentFactory(projectManager));
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore package registry.
     * This automatically creates an new EnvironmentFactory and MetamodelManager.
     * 
     * @param reg Ecore package registry
     * @return the new <code>OCL</code>
     */
	public static @NonNull OCL newInstance(@NonNull EPackage.Registry reg) {			// FIXME exploit reg to give narrower MetamodelManager capability
		return newInstance(createEnvironmentFactory(null));
	}
	
    /**
     * Creates a new <code>OCL</code> suitable for the specified resourceSet content.
     * This automatically creates an new EnvironmentFactory and MetamodelManager.
     */
	public static @NonNull OCL newInstance(@NonNull ResourceSet resourceSet) {
		EnvironmentFactory environmentFactory = OCL.createEnvironmentFactory(null);
		EnvironmentFactoryResourceSetAdapter.getAdapter(resourceSet, environmentFactory);
		return newInstance(environmentFactory);
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment
     * factory.
     * 
     * @param environmentFactory an environment factory for Ecore
     * @return the new <code>OCL</code>
     */
	public static @NonNull OCL newInstance(@NonNull EnvironmentFactory environmentFactory) {	
		return new OCL((EnvironmentFactoryInternal) environmentFactory);
	}
	
	/**
	 * The EnvironmentFactory that can create objects and which provides the MetamodelManager, CompleteEnvironment and StandardLibrary.
	 * This is non-null until the OCL is disposed. Any subsequent usage will provoke NPEs.
	 */
	private /*@NonNull*/ EnvironmentFactoryInternal environmentFactory;			// Set null once disposed, so NPE is use after dispose
	
	private @Nullable ModelManager modelManager;

	private @Nullable Diagnostic problems;
	private @Nullable Diagnostic evaluationProblems;	

	private int parserRepairCount = 0;

	private boolean traceParsing = HelperUtil.shouldTrace(OCLDebugOptions.PARSING);

	private boolean traceEvaluation = HelperUtil.shouldTrace(OCLDebugOptions.EVALUATION);

	/**
	 * Initializes me with my environment factory and root environment.
	 * 
	 * @param envFactory
	 *            my environment factory
	 * @param rootEnv
	 *            my root environment
	 */
	protected OCL(@NonNull EnvironmentFactoryInternal environmentFactory) {
		this.environmentFactory = environmentFactory;
		environmentFactory.attach(this);
		environmentFactory.setEvaluationTracingEnabled(traceEvaluation);
	}

	/**
	 * Update the CS resource from a asResource.
	 * 
	 * For a first update, the csResource may be created by something like
	 * <p><tt>
	 * (BaseResource) resourceSet.createResource(outputURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
	 * </tt>
	 */
	public void as2cs(@NonNull ASResource asResource, @NonNull CSResource csResource) {
		csResource.updateFrom(asResource, getEnvironmentFactory());
	}

	/**
	 * Return the Ecore resource counterpart of a asResource, specifying the uri of the resulting Ecore resource.
	 */
	public @NonNull Resource as2ecore(@NonNull Resource asResource, @NonNull URI uri) throws IOException {
		Resource ecoreResource = AS2Ecore.createResource(getEnvironmentFactoryInternal(), asResource, uri, null);
		return ecoreResource;
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
		LanguageExpression specification =  constraint.getOwnedSpecification();
		if (specification == null) {
			return false;
		}
		ExpressionInOCL query;
		try {
			query = getMetamodelManager().getQueryOrThrow(specification);
		} catch (ParserException e) {
//			e.printStackTrace();
			return false;
		}
		return check(context, query);
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
		StandardLibrary stdlib = getStandardLibrary();
		if (specification.getOwnedBody().getType() != stdlib.getBooleanType()) {
			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
		}
		try {
			Object result = evaluate(context, specification);
			return result == ValueUtil.TRUE_VALUE;
		} catch (InvalidValueException e) {
			return false;
		}
	}

    /**
     * Creates a new evaluation visitor, for the evaluation of an OCL expression in a context.
     * The evaluationVisitor reuses any previously established ModelManager.
     */
	public @NonNull EvaluationVisitor createEvaluationVisitor(@Nullable Object context, @NonNull ExpressionInOCL expression) {
		return environmentFactory.createEvaluationVisitor(context, expression, modelManager);
	}

	/**
	 * Parse oclExpression using selfType as the type of each run-time self object.
	 * @param self
	 * @param string
	 * @return
	 * @throws ParserException 
	 */
	public @NonNull ExpressionInOCL createInvariant(@NonNull EObject contextElement, @NonNull String oclExpression) throws ParserException {
		return createOCLHelper(contextElement).createInvariant(oclExpression);
	}
	
	public ExpressionInOCL createPostcondition(@NonNull EOperation contextOperation, @NonNull String oclExpression) throws ParserException {
		return createOCLHelper(contextOperation).createPostcondition(oclExpression);
	}
    
	/**
	 * Creates a new {@link OCLHelper} instance for convenient parsing of
	 * embedded constraints and query expressions for the specified context
	 * which may be an Ecore EClassifier/EOperation/EStructuralFeature or
	 * or Pivot Class/Operation/Property.
	 * 
	 * @return a new helper object
	 */
    public @NonNull OCLHelper createOCLHelper(@Nullable EObject contextElement) {
        return new OCLHelperImpl(this, contextElement);
     }

	public @NonNull ExpressionInOCL createQuery(@Nullable EObject contextElement, @NonNull String oclExpression) throws ParserException {
		return createOCLHelper(contextElement).createQuery(oclExpression);
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
	public @NonNull Query createQuery(@NonNull ExpressionInOCL query) {
		return new QueryImpl(this, query);
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
	 * @throws ParserException 
	 * 
	 * @see #createQuery(ExpressionInOCL)
	 */
	public Query createQuery(@NonNull Constraint constraint) throws ParserException {
		LanguageExpression specification = ClassUtil.nonNullState(constraint.getOwnedSpecification());
		ExpressionInOCL query = getMetamodelManager().getQueryOrThrow(specification);
		return new QueryImpl(this, query);
	}

	/**
	 * Return the Pivot resource counterpart of an Xtext csResource.
	 */
	public @NonNull Resource cs2as(@NonNull CSResource csResource) {
		Resource asResource = csResource.getASResource(getEnvironmentFactory());
		return asResource;
	}

	/**
	 * Disposes any objects that I have created while I have been in use. This
	 * includes disposing of any {@link #getConstraints() constraints} that I
	 * have parsed and {@linkplain EnvironmentInternal#dispose() disposing} of
	 * my environment.
	 */
	public synchronized void dispose() {
		EnvironmentFactoryInternal environmentFactory2 = environmentFactory;
		if (environmentFactory2 != null) {
			environmentFactory = null;
			environmentFactory2.detach(this);
		}
	}

	/**
	 * Return the Pivot resource counterpart of an ecoreResource.
	 */
	public @NonNull ASResource ecore2as(@NonNull Resource ecoreResource) throws ParserException {
		Ecore2AS ecore2as = Ecore2AS.getAdapter(ecoreResource, getEnvironmentFactoryInternal());
		Model pivotModel = ecore2as.getPivotModel();
		ASResource asResource = (ASResource) pivotModel.eResource();
		return ClassUtil.nonNullModel(asResource);
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
		EvaluationVisitor evaluationVisitor = createEvaluationVisitor(context, expression);
		try {
			Object result = expression.accept(evaluationVisitor);
			return result;
		} catch (EvaluationHaltedException e) {
			evaluationProblems = e.getDiagnostic();
			throw e;
		}
	}

	/**
	 * If the user neglects to dispose() then detach() the EnvironmentFactory to give it a chance to clean up.
	 */
	@Override
	public synchronized void finalize() {
		EnvironmentFactoryInternal environmentFactory2 = environmentFactory;
		if (environmentFactory2 != null) {
			environmentFactory = null;
			environmentFactory2.detach(this);
		}
	}

	public @NonNull CompleteEnvironment getCompleteEnvironment() {
		return environmentFactory.getCompleteEnvironment();
	}

	public @NonNull org.eclipse.ocl.pivot.Class getContextType(@Nullable Object contextObject) {
		MetamodelManager metamodelManager = getMetamodelManager();
		IdResolver idResolver = getIdResolver();
		org.eclipse.ocl.pivot.Class staticTypeOf = idResolver.getStaticTypeOf(contextObject);
		return metamodelManager.getType(staticTypeOf);
	}

	@SuppressWarnings("null")
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	@SuppressWarnings("null")
	protected @NonNull EnvironmentFactoryInternal getEnvironmentFactoryInternal() {
		return environmentFactory;
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

	public @NonNull IdResolver getIdResolver() {
		return environmentFactory.getIdResolver();
	}

	public @NonNull MetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	/**
	 * Obtains the model manager, if any, provided by the client to customize the
	 * evaluation of constraints.
	 * 
	 * @return the client-provided custom model manager, or <code>null</code> if
	 *         thie OCL is using the default dynamic extent map implementation
	 */
	public @Nullable ModelManager getModelManager() {
		return modelManager;
	}

	public @NonNull EPackage.Registry getPackageRegistry() {
		return ClassUtil.nonNullEMF(getResourceSet().getPackageRegistry());
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

	public @NonNull ResourceSet getResourceSet() {
		return getMetamodelManager().getExternalResourceSet();
	}

	/**
	 * Return the Constraint specification as an ExpressionInOCL, parsing any OpaqueExpression
	 * that may be encountered.
	 */
	public @Nullable ExpressionInOCL getSpecification(@NonNull Constraint constraint) throws ParserException {
		LanguageExpression specification = constraint.getOwnedSpecification();
		if (specification == null) {
			return null;
		}
		if (specification instanceof ExpressionInOCL) {
			ExpressionInOCL query = (ExpressionInOCL)specification;
			if ((query.getOwnedBody() != null) || (query.getBody() == null)) {
				return query;
			}
		}
		return getMetamodelManager().getQueryOrThrow(specification);
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return getEnvironmentFactory().getStandardLibrary();
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
	public @Nullable CSResource load(@NonNull URI uri) {
		ResourceSet externalResourceSet = getMetamodelManager().getExternalResourceSet();
		return (CSResource) externalResourceSet.getResource(uri, true);
	}

	/**
	 * Load the Complete OCL document specified by the URI into the external ResourceSet and
	 * parse the concrete syntax resource returning the resulting abstract syntax resource.
	 */
	public @Nullable Resource parse(@NonNull URI uri) {
		CSResource csResource = load(uri);
		return csResource != null ? cs2as(csResource) : null;
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
		environmentFactory.setEvaluationTracingEnabled(traceEvaluation);
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
	public void setModelManager(@Nullable ModelManager modelManager) {
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
