/*******************************************************************************
 * Copyright (c) 2011,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 243079, 244948, 244886, 245619
 *   E.D.Willink - Bug 191689, 254919, 296409, 298634
 *   Obeo - Bug 291310
 *   E.D.Willink (CEA LIST) - Bug 388529
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import junit.framework.TestSuite;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.common.CodeGenHelper;
import org.eclipse.ocl.examples.codegen.dynamic.JavaGenModelCodeGenHelper;
import org.eclipse.ocl.examples.xtext.tests.TestCaseAppender;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.SemanticException;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.context.ClassContext;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.manager.AbstractMetamodelManagerResourceAdapter;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.EnvironmentFactoryResourceSetAdapter;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.library.LibraryUnaryOperation;
import org.eclipse.ocl.pivot.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.OCLHelper;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.RealValue;
import org.eclipse.ocl.pivot.values.Value;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.CS2ASResourceAdapter;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;

/**
 * Default test framework.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public abstract class PivotTestSuite extends PivotTestCase
{
	// set this variable true when testing for memory leaks
    private static boolean DISPOSE_RESOURCE_SET = false;
//	protected static int testCounter = 0;

	public static final @NonNull String ORG_ECLIPSE_OCL_EXAMPLES_XTEXT_TESTRESULTS = "org.eclipse.ocl.examples.xtext.tests";
	
    public static final class CheckedTestSuite extends TestSuite {

		public CheckedTestSuite(String name) {
			super(name);
		}

		public void createTestSuite(Class<? extends PivotTestSuite> testClass, String testName) {
	        addTest(new TestSuite(testClass, testName));
		}

		public void addTestSuite(CheckedTestSuite suite) {
	        addTest(suite);
		}
	}
/*	private static final class TestCaseAppender extends ConsoleAppender {

		public TestCaseAppender() {
			super(new SimpleLayout(), SYSTEM_OUT); 
			setName("TestHarness");
		}
		
		@Override
		public void append(LoggingEvent event) {
			if (event.getLevel().isGreaterOrEqual(Level.INFO)) {
				String renderedMessage = event.getRenderedMessage();
				ThrowableInformation throwableInformation = event.getThrowableInformation();
				Throwable throwable = throwableInformation != null ? throwableInformation.getThrowable() : null;
				throw new Error(renderedMessage, throwable);
			}
//			super.append(event);
		}
	} */
	
//	protected static Logger rootLogger = Logger.getRootLogger();
//	protected static TestCaseAppender testCaseAppender = new TestCaseAppender();
//	{
//		rootLogger.addAppender(testCaseAppender);
//	}
    
	protected static boolean noDebug = false;
	protected static ResourceSet resourceSet;
	private static ArrayList<Resource> standardResources;
	protected static int testCounter = 0;

	private static boolean initialized = false;
	
	public static void debugPrintln(String string) {
		if (!noDebug) {
			System.out.println(string);
		}		
	}

	public static boolean eclipseIsRunning() {
		try {
			Class<?> platformClass = Class.forName("org.eclipse.core.runtime.Platform");
			Method isRunningMethod = platformClass.getDeclaredMethod("isRunning");
			return Boolean.TRUE.equals(isRunningMethod.invoke(null));
		} catch (Exception e) {
		}
		return false;
	}

	public static void initializeStandalone() {
		if (initialized)
			return;
		initialized = true;
	}

	protected OCL ocl;
	protected final boolean useCodeGen;

	protected PivotTestSuite() {
		this.useCodeGen = false;
	}

	protected PivotTestSuite(boolean useCodeGen) {
		this.useCodeGen = useCodeGen;
	}
	
	public void addSupertype(@NonNull org.eclipse.ocl.pivot.Class aClass, @NonNull org.eclipse.ocl.pivot.Class superClass) {
		aClass.getSuperClasses().add(superClass);
	}
    
	/**
	 * Assert that an expression cannot be used as an invariant, because an exception is thrown
	 * with a diagnostic of severity containing a message that is the result of messageTemplate
	 * resolved by bindings.
	 */
	protected void assertBadInvariant(@NonNull Class<?> exception, int severity, @Nullable org.eclipse.ocl.pivot.Class contextType,
    		@NonNull String expression, /*@NonNull*/ String messageTemplate, Object... bindings) {
		CSResource resource = null;
        try {
    		MetamodelManager metamodelManager = ocl.getMetamodelManager();
    		ParserContext semanticContext = new ClassContext(metamodelManager, null, contextType, null);
			resource = semanticContext.createBaseResource(expression);
			PivotUtil.checkResourceErrors(StringUtil.bind(PivotMessagesInternal.ErrorsInResource, expression), resource);
            fail("Should not have parsed \"" + expression + "\"");
        } catch (ParserException e) {
        	assertEquals("Exception for \"" + expression + "\"", exception, e.getClass());
        	if (resource != null) {
        		Resource.Diagnostic diagnostic = getDiagnostic(resource);
    			assertNoException(diagnostic, ClassCastException.class);
            	assertNoException(diagnostic, NullPointerException.class);
//            	assertEquals("Severity for \"" + expression + "\"", severity, diagnostic.getSeverity());
            	String expectedMessage = StringUtil.bind(messageTemplate, bindings);
            	assertEquals("Message for \"" + expression + "\"", expectedMessage, diagnostic.getMessage());
        	}
        } catch (IOException e) {
			fail(e.getMessage());
		} finally {
			if (resource != null) {
				AbstractMetamodelManagerResourceAdapter.disposeAll(resource);
			}
		}	   
    }
	 
	/**
	 * Assert that an expression cannot be used as a query, because an exception is thrown
	 * with a diagnostic of severity containing a message that is the result of messageTemplate
	 * resolved by bindings.
	 * @throws IOException 
	 */
    @SuppressWarnings("null")
	protected void assertBadQuery(@NonNull Class<?> exception, int severity, @Nullable org.eclipse.ocl.pivot.Class contextType, @NonNull String expression, /*@NonNull*/ String messageTemplate, Object... bindings) {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		BaseCSResource csResource = null;
		try {
			ParserContext classContext = new ClassContext(metamodelManager, null, contextType, null);
			csResource = (BaseCSResource) classContext.createBaseResource(expression);
			PivotUtil.checkResourceErrors(StringUtil.bind(PivotMessagesInternal.ErrorsInResource, expression), csResource);
			CS2ASResourceAdapter cs2as = csResource.getCS2ASAdapter(metamodelManager);
			Resource asResource = cs2as.getASResource(csResource);
			assertNoValidationErrors("Validating", asResource);
			
			fail("Should not have parsed \"" + expression + "\"");
		} catch (ParserException e) {
			assertEquals("Exception for \"" + expression + "\"", exception, e.getClass());
			Resource.Diagnostic diagnostic = getDiagnostic(csResource);
			String expectedMessage = StringUtil.bind(messageTemplate, bindings);
			assertEquals("Message for \"" + expression + "\"", expectedMessage, diagnostic.getMessage());
			appendLog(getName(), contextType, expression, expectedMessage, null, null);
		} catch (IOException e) {
			fail(e.getMessage());
		} finally {
			if (csResource != null) {
				AbstractMetamodelManagerResourceAdapter.disposeAll(csResource);
			}
		}	   
	}
	
	/**
	 * Assert that an expression can be parsed as an invariant for a context and return the invariant.
	 */
	protected @Nullable ExpressionInOCL assertInvariant(@NonNull org.eclipse.ocl.pivot.Class context, @NonNull String expression) {
		try {
			ExpressionInOCL result = ocl.createInvariant(context, expression);
			return result;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that an expression evaluated as an invariant for a context returns false.
	 */
	protected @Nullable Object assertInvariantFalse(@Nullable Object context, @NonNull String expression) {
		try {
			Object value = check(context, expression);
			assertEquals(expression, false, value);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that an expression evaluated as an invariant for a context returns true.
	 */
	protected @Nullable Object assertInvariantTrue(@Nullable Object context, @NonNull String expression) {
		try {
			Object value = evaluate(null, context, expression);
			assertEquals(expression, true, value);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Asserts that a exception of the specified kind is not signalled by
	 * the a given diagnostic or (recursively) its children.
	 * 
	 * @param diagnostic a diagnostic
	 * @param excType an exception that must not be indicated by the diagnostic
	 */
    protected void assertNoException(Resource.Diagnostic diagnostic, java.lang.Class<? extends Throwable> excType) {
    	if (diagnostic instanceof ExceptionDiagnostic) {
	    	if (excType.isInstance(((ExceptionDiagnostic)diagnostic).getException())) {
	    		fail("Diagnostic signals a(n) " + excType.getSimpleName());
	    	}
	    	
//	    	for (Diagnostic nested : diagnostic.getChildren()) {
//	    		assertNoException(nested, excType);
//	    	}
    	}
    }
    
	/**
	 * Asserts that two objects are equal using OCL semantics. If they are not
	 * an AssertionFailedError is thrown with the given message.
	 */
	public void assertOCLEquals(String message, Object expected, Object actual) {
		IdResolver idResolver = ocl.getIdResolver();
		if (idResolver.oclEquals(expected, actual))
			return;
		failNotEquals(message, expected, actual);
	}
	
	/**
	 * Asserts that the specified choice is <em>not</em> to be found in the
	 * collection of <code>choices</code>.
	 * 
	 * @param choices a collection of {@link Choice}s
	 * @param kind the kind of choice not to find
	 * @param name the name of the choice not to find
	 *
	protected void assertNotChoice(Collection<Choice> choices, ChoiceKind kind, String name) {
		assertNull("Choice found: " + name + ", " + kind, //$NON-NLS-2$
			findChoice(choices, kind, name));
	} */
	
	/**
	 * Assert that an expression can be parsed as a query for a context and return the query.
	 */
	@SuppressWarnings("null")
	protected @NonNull ExpressionInOCL assertQuery(org.eclipse.ocl.pivot.Class context, @NonNull String expression) {
		try {
			ExpressionInOCL result = ocl.createQuery(context, expression);
			return result;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is not undefined.
	 * @return the evaluation result
	 */
	protected Object assertQueryDefined(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(null, context, expression);
			assertFalse(expression + " expected defined: ", value == null);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is equal to expected.
	 * @return the evaluation result
	 */
	protected @Nullable Object assertQueryEquals(@Nullable Object context, @Nullable Object expected, @NonNull String expression) {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		try {
			Object expectedValue = expected instanceof Value ? expected : metamodelManager.getIdResolver().boxedValueOf(expected);
//			typeManager.addLockedElement(expectedValue.getType());
			Object value = evaluate(null, context, expression);
//			String expectedAsString = String.valueOf(expected);
//			String valueAsString = String.valueOf(value);
			assertOCLEquals(expression, expectedValue, value);
			appendLog(getName(), context, expression, null, expectedValue != null ? expectedValue.toString() : null, null);
			// FIXME Following is probably redundant
			if (expectedValue instanceof OrderedSetValue) {
				assertTrue(expression, value instanceof OrderedSetValue);
				Iterator<?> es = ((OrderedSetValue)expectedValue).iterator();
				@SuppressWarnings("null")
				Iterator<?> vs = ((OrderedSetValue)value).iterator();
				while (es.hasNext()) {
					Object e = es.next();
					Object v = vs.next();
					assertEquals(expression, e, v);
				}
			}
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is equal to expected.
	 * @return the evaluation result
	 */
	@SuppressWarnings("null")
	protected @Nullable Object assertQueryEquals(@Nullable Object context, @NonNull BigDecimal expected, @NonNull BigDecimal delta, @NonNull String expression) {
		try {
			BigDecimal value = (BigDecimal) evaluate(null, context, expression);
			assertTrue(expression, (value.compareTo(expected.add(delta)) >= 0) && (value.compareTo(expected.subtract(delta)) >= 0));
			appendLog(getName(), context, expression, null, expected.toString(), delta.toString());
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is equal to expected.
	 * @return the evaluation result
	 */
	protected Object assertQueryEquals(Object context, @NonNull Number expected, @NonNull String expression, double tolerance) {
		try {
			IdResolver idResolver = ocl.getIdResolver();
			Object expectedValue = idResolver.boxedValueOf(expected);
			Object value = evaluate(null, context, expression);
			@SuppressWarnings("null")
			BigDecimal expectedVal = ((RealValue)expectedValue).bigDecimalValue();
			@SuppressWarnings("null")
			BigDecimal val = ((RealValue)value).bigDecimalValue();
			double delta = val.subtract(expectedVal).doubleValue();
			if ((delta < -tolerance) || (tolerance < delta)) {
				assertEquals(expression, expected, value);
			}
			appendLog(getName(), context, expression, null, expected.toString(), Double.toString(tolerance));
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is the same as expected.
	 */
	protected Object assertQueryEvaluate(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(null, context, expression);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is false.
	 * @return the evaluation result
	 */
	protected Object assertQueryFalse(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(null, context, expression);
			assertEquals(expression, Boolean.FALSE, value);
			appendLog(getName(), context, expression, null, "false", null);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is invalid.
	 * @return the evaluation result
	 */
	protected Value assertQueryInvalid(Object context, @NonNull String expression) {
		try {
			Object value = evaluateWithoutValidation(null, context, expression);
			fail(expression + " expected: invalid but was: " + value);
		} catch (InvalidValueException e) {		// OCL invalid is always an InvalidValueException
			appendLog(getName(), context, expression, null, "invalid", null);
		} catch (Exception e) {					// Something else is nasty
			failOn(expression, e);
		}
		return null;
	}

	protected Object assertQueryInvalid(Object context, @NonNull String expression, String reason, Class<?> exceptionClass) {
		try {
			Object value = evaluateWithoutValidation(null, context, expression);
//			if (!ValuesUtil.isInvalid(value)) {
				fail(expression + " expected: invalid but was: " + value);
//			}
//			InvalidValue invalidValue = (InvalidValue)value;
//           fail("Expected invalid for \"" + expression + "\"");
		} catch (InvalidValueException e) {
			Throwable ex = e;
			Throwable cause = e.getCause();
//			Exception cause = invalidValue.getException();
//			Throwable ex = cause;
			String message = e.getMessage();
			if (cause != null) {
				ex = cause;
				if (!(cause instanceof NumberFormatException)) {
					String m = ex.getMessage();
					if (m != null) {
						message = m;
					}
				}
			}
			if (reason != null) {
				assertEquals("Invalid Value Reason", reason, message);
			}
			if (exceptionClass != null) {
				assertEquals("Invalid Value Throwable", exceptionClass, ex.getClass());
			}
		} catch (Exception e) {
			if ((exceptionClass != null) && (exceptionClass != e.getClass())) {
				assertEquals("Invalid Value Throwable", exceptionClass, e.getClass() + " : " + e.getMessage());
			}
			if (reason != null) {
				assertEquals("Invalid Value Reason", reason, e.getMessage());
			}
//			failOn(expression, e);
		}
		return null;
	}

	/**
	 * Assert that the result of evaluating an expression as a query is not null.
	 * @return the evaluation result
	 */
	protected Object assertQueryNotJavaNull(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(null, context, expression);
			assertNotNull(expression, value);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}
	
	/**
	 * Assert that the result of evaluating an expression as a query is not the same as expected.
	 * @return the evaluation result
	 */
	protected Object assertQueryNotSame(Object context, Object expected, @NonNull String expression) {
		try {
			Object value = evaluate(null, context, expression);
			assertNotSame(expression, expected, value);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is OCL null.
	 * @return the evaluation result
	 */
	protected Object assertQueryNull(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(null, context, expression);
			assertEquals(expression, null, value);
			appendLog(getName(), context, expression, null, "null", null);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Creates a query given the expression that is to be evaluated, then
	 * asserts its result is equal to the evaluation of the given
	 * <code>expectedResultExpression</code>.
	 * <p>
	 * If either the expected result or the expression result is a double, we'll
	 * compare the two with a margin of 0.001.
	 * </p>
	 * 
	 * @param expectedResult
	 *            Object with which the query's result is to be compared.
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	protected Object assertQueryResults(Object context, @NonNull String expectedResultExpression, @NonNull String expression) {
		try {
			Object expectedResultQuery = evaluateLocal(context, expectedResultExpression);
			Object result = assertQueryEquals(context, expectedResultQuery, expression);
			appendLog(getName(), context, expression, null, expectedResultExpression, null);
			return result;
		} catch (Exception e) {
			failOn(expectedResultExpression, e);
			return null;
		}
	}
	/**
	 * Creates a query given the expression that is to be evaluated, then
	 * asserts its result contains all elements included in
	 * <code>expectedResult</code>.
	 * 
	 * @param expectedResult
	 *            Collection with which the query's result is to be compared.
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	@SuppressWarnings("null")
	protected Object assertResultContainsAll(Object context, @NonNull CollectionValue expectedResult, @NonNull String expression) {
		try {
			Object result = evaluate(null, context, expression);
			assertTrue(expectedResult.getClass().isInstance(result));
			assertSame(expectedResult.intSize(), ((CollectionValue) result).intSize());
			Object actualResult = ((CollectionValue) result).includesAll(expectedResult);
			assertTrue("Expected " + result + " to contain " + expectedResult, actualResult == ValueUtil.TRUE_VALUE);
			return result;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Creates a query given the expression that is to be evaluated, then
	 * asserts its result contains all elements included in
	 * <code>expectedResult</code>.
	 * 
	 * @param expectedResultExpression
	 *            Expression which is to be evaluated to determine the expected
	 *            result.
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	protected Object assertResultContainsAll(Object context, @NonNull String expectedResultExpression, @NonNull String expression) {
		try {
			Object expectedResultQuery = evaluateLocal(null, expectedResultExpression);
			assertTrue(expectedResultQuery instanceof CollectionValue);
			@SuppressWarnings("null")
			Object result = assertResultContainsAll(context, (CollectionValue) expectedResultQuery, expression);
			return result;
		} catch (Exception e) {
			failOn(expectedResultExpression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is the same as expected.
	 * @return the evaluation result
	 *
	protected Object assertQuerySame(Object context, Object expected, String expression) {
		try {
			Object value = evaluate(null, context, expression);
			assertSame(expression, expected, value);
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + expression + "\": " + e.getLocalizedMessage());
			return null;
		}
	} */

	/**
	 * Assert that the result of evaluating an expression as a query is true.
	 * @return the evaluation result
	 */
	protected Object assertQueryTrue(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(null, context, expression);
			assertEquals(expression, Boolean.TRUE, value);
			appendLog(getName(), context, expression, null, "true", null);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is an unlimited value.
	 * @return the evaluation result
	 */
	protected Object assertQueryUnlimited(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(null, context, expression);
			if (!ValueUtil.isUnlimited(value)) {
				assertEquals(expression, ValueUtil.UNLIMITED_VALUE, value);
			}
			appendLog(getName(), context, expression, null, "*", null);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	protected void assertSemanticErrorQuery(@Nullable org.eclipse.ocl.pivot.Class contextType, @NonNull String expression, String messageTemplate, Object... bindings) {
		assertBadQuery(SemanticException.class, Diagnostic.ERROR, contextType, expression, messageTemplate, bindings);	   
	}

	/**
	 * Assert that an expression cannot be used as a query, because an exception is thrown
	 * with a diagnostic of severity containing a message that is the result of messageTemplate
	 * resolved by bindings.
	 * @throws IOException 
	 */
   @SuppressWarnings("null")
   protected void assertValidationErrorQuery(@Nullable org.eclipse.ocl.pivot.Class contextType, @NonNull String expression,
		   String messageTemplate, Object... bindings) {
		BaseCSResource csResource = null;
		try {
	   		MetamodelManager metamodelManager = ocl.getMetamodelManager();
	   		ParserContext classContext = new ClassContext(metamodelManager, null, contextType, null);
	   		csResource = (BaseCSResource) classContext.createBaseResource(expression);
			PivotUtil.checkResourceErrors(StringUtil.bind(PivotMessagesInternal.ErrorsInResource, expression), csResource);
			CS2ASResourceAdapter cs2as = csResource.getCS2ASAdapter(metamodelManager);
			Resource asResource = cs2as.getASResource(csResource);
	       	String expectedMessage = StringUtil.bind(messageTemplate, bindings);
			assertValidationDiagnostics("Validating", asResource, new String[] {expectedMessage});
			appendLog(getName(), contextType, expression, expectedMessage, null, null);
		} catch (Exception e) {
			fail(e.getMessage());
		} finally {
			if (csResource != null) {
				AbstractMetamodelManagerResourceAdapter.disposeAll(csResource);
			}
		}	   
	}

   	/**
   	 * Assert that the expression is free of syntactic and semantic errors when parsed
   	 * for evaluation on an object of contextType. No evaluation is performed since no
   	 * object of contextType need exist. 
   	 */
	protected void assertValidQuery(@NonNull org.eclipse.ocl.pivot.Class contextType, @NonNull String expression) throws Exception {
		ExpressionInOCL query = ocl.createQuery(contextType, expression);
		assertNoValidationErrors(expression, query);
	}

	/**
	 * Asserts that the <code>toString</code> representation of an AST node as
	 * generated by the toString visitor does not throw a run-time exception
	 * and is not <code>null</code>.
	 * 
	 * @param node a visitable AST node
	 */
	protected void assertValidToString(@NonNull Visitable node) {
		try {
			String toString = node.toString();
			assertNotNull("ToStringVisitorImpl returned null", toString);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail("ToStringVisitorImpl threw an exception: " + e.getLocalizedMessage());
		}
	}
	
/*	protected boolean check(@NonNull String contextFreeExpression) {
		boolean result = false;
		
		try {
			String document = "package uml context String" +
					" inv: " + contextFreeExpression + " endpackage";
			ExpressionInOCL expr = parse(document);
			
			result = check(expr, "");
		} catch (Exception e) {
			fail("Check failed: " + e.getLocalizedMessage());
		}
		
		return result;
	} */
    
    protected boolean check(Object context, @NonNull String expression) throws ParserException {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		org.eclipse.ocl.pivot.Class contextType = ocl.getContextType(context);
    	ExpressionInOCL constraint = ocl.createInvariant(contextType, expression);
		if (constraint.getOwnedBody().getType() != metamodelManager.getStandardLibrary().getBooleanType()) {
			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
		}
		try {
			Object result = evaluate(constraint, context);
			return result == ValueUtil.TRUE_VALUE;
		} catch (Exception e) {
			return false;
		}
	}
	
/*	protected boolean check(@NonNull ExpressionInOCL expr, Object self) {
		boolean result = false;
		
		try {
			result = ocl.check(self, expr);
		} catch (RuntimeException e) {
			fail("Check failed: " + e.getLocalizedMessage());
		}
		
		return result;
	} */
 	
	/**
	 * This can be called by subclasses to provide a meaningful error message
	 * when the tests are run with an encoding distinct from UTF-8.
	 */
	protected void checkForUTF8Encoding() {
		String testCharacter = "´";
		int length = testCharacter.length();
		if ((length != 1) || (testCharacter.charAt(0) != 0xB4)) {
			StringBuilder s = new StringBuilder();
			s.append("The Resource text file encoding should be set to UTF-8: test character was");
			for (int i = 0; i < length; i++){
				s.append(" ");
				s.append(Integer.toHexString(testCharacter.charAt(i)));
			}
			s.append(" rather than B4");
			fail(s.toString());
		}
	}

	@SuppressWarnings("null")
	protected @NonNull ExpressionInOCL createBodyCondition(@NonNull Operation context, @NonNull String text) {
		OCLHelper helper = ocl.createOCLHelper(context);
		
		ExpressionInOCL result = null;
		
		try {
			result = helper.createBodyCondition(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}

	public org.eclipse.ocl.pivot.Class createClass() {
		return PivotFactory.eINSTANCE.createClass();
	}

	/**
	 * Return an isOrdered,isUnique collection containing args.
	 *
	protected @NonNull CollectionValue createCollection(boolean isOrdered, boolean isUnique, @NonNull TypeId typeId, @NonNull Object... args) {
		return ValuesUtil.createCollectionOfEach(isOrdered, isUnique, typeId, args);
	} */

	public Comment createComment() {
		return PivotFactory.eINSTANCE.createComment();
	}

	protected void createDocument(String text) {
		throw new UnsupportedOperationException();
//		try {
//			ocl.parse(new OCLInput(text));
//        } catch (Exception e) {
//            fail("Failed to parse: " + e.getLocalizedMessage());
//        }
	}

	public void createGeneralization(org.eclipse.ocl.pivot.Class special, org.eclipse.ocl.pivot.Class general) {
		special.getSuperClasses().add(general);
	}

//	protected @NonNull OCLHelper createHelper() {
//		return ocl.createOCLHelper();
//	}
	
	protected ExpressionInOCL createInvariant(@NonNull org.eclipse.ocl.pivot.Class context, @NonNull String expression) {
		return assertInvariant(context, expression);
	}

	protected @NonNull Model createModel() {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		Model aRoot = metamodelManager.createModel(null);
		return aRoot;
	}

	protected Property createOwnedAttribute(org.eclipse.ocl.pivot.Class aClass, String name, Type type) {
		Property eAttribute = PivotFactory.eINSTANCE.createProperty();
		eAttribute.setName(name);
		eAttribute.setType(type);
		aClass.getOwnedProperties().add(eAttribute);
		return eAttribute;
	}

	protected @NonNull org.eclipse.ocl.pivot.Class createOwnedClass(org.eclipse.ocl.pivot.Package aPackage, String name, boolean isAbstract) {
		org.eclipse.ocl.pivot.Class eClass = PivotFactory.eINSTANCE.createClass();
		eClass.setName(name);
		eClass.setIsAbstract(isAbstract);
		aPackage.getOwnedClasses().add(eClass);
		return eClass;
	}

	protected Enumeration createOwnedEnumeration(org.eclipse.ocl.pivot.Package aPackage, String name) {
		Enumeration eEnum = PivotFactory.eINSTANCE.createEnumeration();
		eEnum.setName(name);
		aPackage.getOwnedClasses().add(eEnum);
		return eEnum;
	}

	protected EnumerationLiteral createOwnedLiteral(Enumeration anEnumeration, String name) {
		EnumerationLiteral eLiteral = PivotFactory.eINSTANCE.createEnumerationLiteral();
		eLiteral.setName(name);
		anEnumeration.getOwnedLiterals().add(eLiteral);
		return eLiteral;
	}

	protected Operation createOwnedOperation(org.eclipse.ocl.pivot.Class aClass, String name, List<String> paramNames, List<Type> paramTypes, Type type, boolean isQuery) {
		Operation eOperation = PivotFactory.eINSTANCE.createOperation();
		eOperation.setName(name);
		eOperation.setType(type);
		if (paramNames != null) {
			for (int i = 0; i < paramNames.size(); i++) {
				createOwnedParameter(eOperation, paramNames.get(i), paramTypes.get(i));
			}
		}
		aClass.getOwnedOperations().add(eOperation);
		return eOperation;
	}

	protected Parameter createOwnedParameter(Operation eOperation, String name, Type type) {
		Parameter eParameter = PivotFactory.eINSTANCE.createParameter();
		eParameter.setName(name);
		eParameter.setType(type);
		eOperation.getOwnedParameters().add(eParameter);
		return eParameter;
	}

	protected Operation createOwnedPrimitiveOperation(org.eclipse.ocl.pivot.Class aPrimitiveType, String name, EList<String> paramNames, EList<Type> paramTypes, Type type, boolean isQuery) {
		return createOwnedOperation(aPrimitiveType, name, paramNames, paramTypes, type, isQuery);
	}

	protected org.eclipse.ocl.pivot.Class createOwnedPrimitiveType(org.eclipse.ocl.pivot.Package aPackage, String name) {
		org.eclipse.ocl.pivot.Class eClass = PivotFactory.eINSTANCE.createClass();
		eClass.setName(name);
		aPackage.getOwnedClasses().add(eClass);
		return eClass;
	}

	protected Property createOwnedReference(org.eclipse.ocl.pivot.Class aClass, String name, org.eclipse.ocl.pivot.Class type) {
		Property eReference = PivotFactory.eINSTANCE.createProperty();
		eReference.setName(name);
		eReference.setType(type);
		aClass.getOwnedProperties().add(eReference);
		return eReference;
	}

	protected @NonNull MetamodelManager createMetamodelManager() {
		EnvironmentFactory environmentFactory = OCL.createEnvironmentFactory(getProjectMap());
		return environmentFactory.getMetamodelManager();
	}

	protected @NonNull OCL createOCL() {
		return OCL.newInstance(getProjectMap());
	}

	protected @NonNull org.eclipse.ocl.pivot.Package createPackage(@NonNull Model parentRoot, @NonNull String name) {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		@SuppressWarnings("null")
		org.eclipse.ocl.pivot.Package aPackage = metamodelManager.createPackage(org.eclipse.ocl.pivot.Package.class, PivotPackage.Literals.PACKAGE, name, null, null);
		parentRoot.getOwnedPackages().add(aPackage);
		return aPackage;
	}

	protected @NonNull org.eclipse.ocl.pivot.Package createPackage(@NonNull org.eclipse.ocl.pivot.Package parentPackage, @NonNull String name) {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		@SuppressWarnings("null")
		org.eclipse.ocl.pivot.Package aPackage = metamodelManager.createPackage(org.eclipse.ocl.pivot.Package.class, PivotPackage.Literals.PACKAGE, name, null, null);
		parentPackage.getOwnedPackages().add(aPackage);
		return aPackage;
	}
	
	@SuppressWarnings("null")
	protected @NonNull ExpressionInOCL createPostcondition(@NonNull Operation context, @NonNull String text) {
		OCLHelper helper = ocl.createOCLHelper(context);
		
		ExpressionInOCL result = null;
		
		try {
			return helper.createPostcondition(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	@SuppressWarnings("null")
	protected @NonNull ExpressionInOCL createPrecondition(@NonNull Operation context, @NonNull String text) {
		OCLHelper helper = ocl.createOCLHelper(context);
		
		ExpressionInOCL result = null;
		
		try {
			result = helper.createPrecondition(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	protected @NonNull ExpressionInOCL createQuery(@NonNull org.eclipse.ocl.pivot.Class context, @NonNull String expression) {
		return assertQuery(context, expression);
	}
	
	@SuppressWarnings("null")
	protected @NonNull ExpressionInOCL createQuery(
			@NonNull EnvironmentFactoryInternal envFactory,
			@NonNull org.eclipse.ocl.pivot.Class context, @NonNull String text) {
		
		OCL localOcl = OCL.newInstance(envFactory);
		OCLHelper helper = localOcl.createOCLHelper(context);
		
		ExpressionInOCL result = null;
		
		try {
			result = helper.createQuery(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	public @NonNull ResourceSet createResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			"ecore", new EcoreResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(PivotPackage.eINSTANCE.getNsURI(), PivotPackage.eINSTANCE);
		return resourceSet;
	}
	
	protected void disposeResourceSet() {
		ResourceSet resourceSet2 = resourceSet;
		if (resourceSet2 != null) {
			ProjectMap projectMap = basicGetProjectMap();
			if (projectMap != null) {
				projectMap.unload(resourceSet2);
			}
	        for (Resource res : resourceSet2.getResources()) {
	            res.unload();
	            res.eAdapters().clear();
	        }
	        resourceSet2.getResources().clear();
	        resourceSet2.eAdapters().clear();
	        resourceSet = null;
		}
		standardResources = null;
	}
	
	protected @Nullable Object evaluate(@NonNull String contextFreeExpression) {
		Object result = null;
		
		try {
			String document = "package uml context String" +
					" inv: " + contextFreeExpression +" endpackage";
			ExpressionInOCL expr = parse(document);
			
			result = evaluate(expr, "");
		} catch (Exception e) {
			fail("Evaluation failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}

	protected @Nullable Object evaluate(Object unusedHelper, @Nullable Object context, @NonNull String expression) throws Exception {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		org.eclipse.ocl.pivot.Class classContext = ocl.getContextType(context);
		ParserContext parserContext = new ClassContext(metamodelManager, null, classContext, (context instanceof Type) && !(context instanceof ElementExtension) ? (Type)context : null);
		ExpressionInOCL query = parserContext.parse(classContext, expression);
		assertNoValidationErrors(expression, query);
        try {
        	return evaluate(query, context);
		} finally {
			metamodelManager.getASResourceSet().getResources().remove(query.eResource());
		}
    }

	protected @Nullable Object evaluateWithoutValidation(@Nullable Object unusedHelper, @Nullable Object context, @NonNull String expression) throws Exception {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		org.eclipse.ocl.pivot.Class contextType = ocl.getContextType(context);
		ExpressionInOCL query = ocl.createQuery(contextType, expression);
        try {
        	return evaluate(query, context);
		} finally {
			metamodelManager.getASResourceSet().getResources().remove(query.eResource());
		}
    }

	protected @Nullable Object evaluateLocal(@Nullable Object context, @NonNull String expression) throws Exception {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		org.eclipse.ocl.pivot.Class contextType = ocl.getContextType(context);
		ExpressionInOCL query = ocl.createQuery(contextType, expression);
        try {
    		return ocl.evaluate(context, query);
		} finally {
			metamodelManager.getASResourceSet().getResources().remove(query.eResource());
		}
    }
    
	protected @Nullable Object evaluate(@NonNull ExpressionInOCL expr, @Nullable Object self) throws Exception {
		Object result = null;
		
//		try {
			if (!useCodeGen) {
				result = ocl.evaluate(self, expr);
			}
			else {
				ProjectMap projectMap = getProjectMap();
				projectMap.initializeResourceSet(resourceSet);
				resourceSet.getPackageRegistry().put(org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eNS_URI, org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eINSTANCE);
				resourceSet.getPackageRegistry().put(org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eNS_URI, org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eINSTANCE);

				CodeGenHelper genModelHelper = getCodeGenHelper(ocl.getEnvironmentFactory());

				File targetFolder = new File("../" + ORG_ECLIPSE_OCL_EXAMPLES_XTEXT_TESTRESULTS + "/src-gen");
				targetFolder.mkdir();
				String packageName = getTestPackageName();			// FIXME need to create this
				String className = "TestClass" + testCounter++;
				File dir = new File(targetFolder, packageName);
				dir.mkdir();
				LibraryUnaryOperation testInstance = (LibraryUnaryOperation) genModelHelper.loadClass(expr, targetFolder, packageName, className, true);
				assert testInstance != null;
				Evaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
				OperationCallExp callExp = PivotFactory.eINSTANCE.createOperationCallExp();
				callExp.setType(expr.getType());
				result = testInstance.evaluate(evaluator, callExp.getTypeId(), self);
			}
//		} catch (Exception e) {
//			fail("Evaluation failed: " + e.getLocalizedMessage());
//		}
		
		return result;
	}
	
	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>Attribute</b></em>' reference list.
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 */
	protected Property getAttribute(@NonNull org.eclipse.ocl.pivot.Class classifier, @NonNull String name, @NonNull Type type) {
		Property feature = NameUtil.getNameable(classifier.getOwnedProperties(), name);
		if (feature == null)
			return null;
		// check type
		return feature;
	}

	@SuppressWarnings("null")
	public CodeGenHelper getCodeGenHelper(@NonNull EnvironmentFactory environmentFactory) throws IOException {
		URI genModelURI = URI.createPlatformResourceURI(
				"/org.eclipse.ocl.pivot/model/Pivot.merged.genmodel",
				true);
//		ResourceSet resourceSet = getResourceSet();
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		String errorsString = PivotUtil.formatResourceDiagnostics(
				genModelResource.getErrors(), "Loading " + genModelURI, "\n");
		if (errorsString != null) {
			// issues.addError(this, errorsString, null, null, null);
			return null;
		}
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
		return new JavaGenModelCodeGenHelper(genModel, environmentFactory);
//		return new GenModelCodeGenHelper(genModel, metamodelManager);
	}

	/**
     * Obtains the diagnostic describing the problem in the last failed parse,
     * asserting that it is not <code>null</code>.
     * 
     * @return the diagnostic
     */
    protected Resource.Diagnostic getDiagnostic(@NonNull Resource resource) {
    	org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic = resource.getErrors().get(0);
		return diagnostic;
    }

    protected @NonNull Value getEmptyBagValue() {
		return ocl.getIdResolver().createBagOfEach(TypeId.BAG.getSpecializedId(TypeId.OCL_VOID));
	}

	protected @NonNull Value getEmptyOrderedSetValue() {
		return ocl.getIdResolver().createOrderedSetOfEach(TypeId.ORDERED_SET.getSpecializedId(TypeId.OCL_VOID));
	}

	protected @NonNull Value getEmptySequenceValue() {
		return ocl.getIdResolver().createSequenceOfEach(TypeId.SEQUENCE.getSpecializedId(TypeId.OCL_VOID));
	}

	protected @NonNull Value getEmptySetValue() {
		return ocl.getIdResolver().createSetOfEach(TypeId.SET.getSpecializedId(TypeId.OCL_VOID));
	}
   
	protected @NonNull org.eclipse.ocl.pivot.Class getMetaclass(@NonNull String name) {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		return metamodelManager.getStandardLibrary().getRequiredLibraryType(name);
	}
	
	protected Object getNull() {
		return null;
	}

	protected @NonNull OCL getOCL() {
		return ClassUtil.nonNullState(ocl);
	}
	
	protected @NonNull StandardLibrary getStandardLibrary() {
		return ocl.getStandardLibrary();
	}

	protected @NonNull String getTestPackageName() {
		return "test_package";
	}
	
	protected @NonNull Type getUMLBoolean() {
		return getStandardLibrary().getBooleanType();
	}
	
	protected @NonNull Type getUMLInteger() {
		return getStandardLibrary().getIntegerType();
	}

	protected @NonNull org.eclipse.ocl.pivot.Package getUMLMetamodel() {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		return ClassUtil.nonNullState(metamodelManager.getASmetamodel());
	}
	
	protected @NonNull Type getUMLString() {
		return getStandardLibrary().getStringType();
	}
	
	protected @NonNull Type getUMLUnlimitedNatural() {
		return getStandardLibrary().getUnlimitedNaturalType();
	}

	protected void initializeResourceSet() {
	    resourceSet = createResourceSet();
		standardResources = new ArrayList<Resource>(resourceSet.getResources());
	}
	
	@SuppressWarnings("null")
	public void loadEPackage(@NonNull String alias, /*@NonNull*/ EPackage ePackage) {		
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		Element ecoreElement = Ecore2AS.importFromEcore(metamodelManager, alias, ePackage);
		metamodelManager.addGlobalNamespace(alias, (Namespace) ecoreElement);
	}
	
	/**
	 * Parses the specified <code>text</code>.
	 * 
	 * @param text the OCL text
	 * @return the OCL expression
	 */
	protected @NonNull ExpressionInOCL parse(@NonNull String text) {
		ExpressionInOCL result = parseUnvalidated(text);
		validate(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint.
	 * 
	 * @param text the OCL text
	 * @return the OCL constraint expression
	 */
	protected @NonNull ExpressionInOCL parseConstraint(@NonNull String text) {
		ExpressionInOCL result = parseConstraintUnvalidated(text);
		validate(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint, without
	 * validating it.
	 * 
	 * @param text the OCL text
	 * @return the OCL constraint expression, unvalidated
	 */
	protected @NonNull ExpressionInOCL parseConstraintUnvalidated(@NonNull String text) {
		throw new UnsupportedOperationException();
/*		List<Constraint> constraints;
		Constraint constraint = null;
		
		try {
			constraints = ocl.parse(new OCLInput(text));
			constraint = constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		} catch (IllegalArgumentException e) {
			fail("Parse failed (illegal argument): " + e.getLocalizedMessage());
		}
		
		ExpressionInOCL result = null;
		result = (ExpressionInOCL) constraint.getSpecification();
		
		assertNotNull(result);
		
		assertValidToString(result);
		
		return result; */
	}
	
	/**
	 * Parses the specified <code>text</code> as a def expression.  This differs
	 * from the {@link #parse} method in not separating the expression from its
	 * constraint, which is critically important to the structure of the defined
	 * feature.
	 * 
	 * @param env the environment in which the operation or property is to be defined
	 * @param text the OCL text
	 * @return the OCL def expression
	 */
	protected @NonNull ExpressionInOCL parseDef(@NonNull String text) {
		throw new UnsupportedOperationException();
/*		List<Constraint> constraints ;
		Constraint constraint = null;
		
		try {
			constraints = ocl.parse(new OCLInput(text));
			constraint = constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		} catch (IllegalArgumentException e) {
			fail("Parse failed (illegal argument): " + e.getLocalizedMessage());
		}
		
		ExpressionInOCL result = (ExpressionInOCL) constraint.getSpecification();		
		assertNotNull(result);
		validate(result);		
		assertValidToString(result);		
		return result; */
	}

	/**
	 * Parses the specified <code>text</code> without validating it.
	 * 
	 * @param text the OCL text
	 *    
	 * @return the OCL expression, unvalidated
	 */
	protected @NonNull ExpressionInOCL parseUnvalidated(@NonNull String text) {
		ExpressionInOCL result = parseConstraintUnvalidated(text);
		
		// forget the constraint because it interferes with validation
		EcoreUtil.remove(result);
		
		assertValidToString(result);
		
		return result;
	}

	/**
	 * Create a Resource to register a binding-dependent pkg for access with a given nsPrefix and nsUri.
	 */
	protected @NonNull org.eclipse.ocl.pivot.Package registerPackage(@NonNull org.eclipse.ocl.pivot.Package pkg, @NonNull String nsPrefix, @NonNull String nsUri) {
		pkg.setNsPrefix(nsPrefix);
        pkg.setURI(nsUri);
		Resource resource = new ResourceImpl(URI.createURI(nsUri));
        resource.getContents().add(pkg);
        resourceSet.getResources().add(resource);					// FIXME UML needs this
        resourceSet.getPackageRegistry().put(nsUri, pkg);			//  whereas Ecore needs this
        return pkg;
	}
	
	public static void resetCounter() throws Exception {
        testCounter = 0;
    }
	
	@SuppressWarnings("null")
	@Override
    protected void setUp() throws Exception {
		super.setUp();
		TestCaseAppender.INSTANCE.install();
 		OCLstdlib.install();
 		doEssentialOCLSetup();
		if ((resourceSet != null) && DISPOSE_RESOURCE_SET) {
        	disposeResourceSet();
        }
		if (!initialized) {
			noDebug = System.getProperty(PLUGIN_ID + ".nodebug") != null;
			if (!eclipseIsRunning()) {
				initializeStandalone();
			}
		}		
		if (resourceSet == null) {
			initializeResourceSet();
		}
		ocl = createOCL();
		EnvironmentFactoryResourceSetAdapter.getAdapter(resourceSet, ocl.getEnvironmentFactory());
//		debugPrintln("==> Start  " + getName());
		String repairs = System.getProperty(PLUGIN_ID + ".repairs");
		if (repairs != null)
			ocl.setParserRepairCount(Integer.parseInt(repairs));
//        ocl.setParseTracingEnabled(true);
//        ocl.setEvaluationTracingEnabled(true);
	}

	@SuppressWarnings("null")
	@Override
    protected void tearDown() throws Exception {
		//
		//	Unload any resources that a test may have loaded.
		//
		for (ListIterator<Resource> i = resourceSet.getResources().listIterator(); i.hasNext(); ) {
			Resource res = i.next();
			if (!standardResources.contains(res)) {
				i.remove();
				res.unload();
                res.eAdapters().clear();
			}				
		}
		//
		//	Null out any references that a test may have left behind, so that unwanted
		//	objects are not locked into memory.
		//
		for (java.lang.Class<?> aClass = getClass(); PivotTestSuite.class.isAssignableFrom(aClass); aClass = aClass.getSuperclass()) {
			for (Field field : aClass.getDeclaredFields()) {
				int modifiers = field.getModifiers();
				if (Modifier.isFinal(modifiers)) {
				}
				else if (!Modifier.isStatic(modifiers)) {
					java.lang.Class<?> fieldType = field.getType();
					if (Object.class.isAssignableFrom(fieldType)) {
						String fieldName = field.getName();
						try {
							String tearDownName = "tearDown_" + fieldName;
							Method method = aClass.getDeclaredMethod(tearDownName);
							try {
								tearDownUsing(method);
							} catch (Exception e) {
								// tearDown_xxx must be public
								fail("Failed to invoke " + getClass().getSimpleName() + "." + tearDownName + " : " + e);  //$NON-NLS-2$//$NON-NLS-3$
							}
						}
						catch (NoSuchMethodException e) {
							try {
								tearDownField(field);
							} catch (Exception e1) {
								// xxx without a tearDown_xxx must be public to ensure that leakage can be stopped
								fail("Failed to set " + getClass().getSimpleName() + "." + fieldName + " to null : " + e1); //$NON-NLS-2$ //$NON-NLS-3$
							}
						}
					}
				} else {
					tearDownStatic(aClass, field);
				}
			}
		}
		disposeResourceSet();
//		unloadResourceSet(resourceSet);
//		resourceSet = null;
		super.tearDown();
	}

	protected void tearDownField(@NonNull Field field) throws IllegalAccessException {
		field.set(this, null);
	}

	protected void tearDownStatic(@NonNull java.lang.Class<?> aClass, @NonNull Field field) {
		if (aClass != PivotTestSuite.class) {
			// Tests may not have statics since they are prone to memory leakage
			fail("static test variable:" + field); 
		}
	}

	protected void tearDownUsing(@NonNull Method method)
			throws IllegalAccessException, InvocationTargetException {
		method.invoke(this);
	}

	protected void tearDown_ocl() {
		if (ocl != null) {
			ocl.dispose();
			ocl = null;
		}
	}
    
    /**
     * Validates an OCL expression, asserting that it is valid.
     * 
     * @param expr the OCL expression to validate
     * @param env an environment to use for validation
     */
    protected void validate(@NonNull Constraint constraint) {
        try {
            ocl.validate(constraint);
        } catch (SemanticException e) {
            fail("Validation failed: " + e.getLocalizedMessage());
        }
    }
    
	/**
	 * Validates an OCL expression, asserting that it is valid.
	 * 
	 * @param expr the OCL expression to validate
	 * @param env an environment to use for validation
	 */
	@SuppressWarnings("null")
	protected void validate(@NonNull ExpressionInOCL expr) {
		try {
			EObject eContainer = expr.eContainer();
			if ((eContainer != null)
					&& Constraint.class.isAssignableFrom(eContainer.eContainer().getClass())) {
				// start validation from the constraint, for good measure
				Constraint eContainerContainer = (Constraint) eContainer.eContainer();
				validate(eContainerContainer);
			} else {
				ocl.validate(expr.getOwnedBody());
			}
		} catch (SemanticException e) {
			fail("Validation failed: " + e.getLocalizedMessage());
		}
	}
}
