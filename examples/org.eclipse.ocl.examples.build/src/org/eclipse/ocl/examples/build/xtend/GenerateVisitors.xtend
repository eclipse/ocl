/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - bug397429
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.build.xtend

import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.jdt.annotation.NonNull
import org.eclipse.emf.ecore.ETypeParameter

public abstract class GenerateVisitors extends GenerateVisitorsWorkflowComponent
{
	protected def static EClass firstSuperClass(EClass eClass, EClass nullClass) {
		if (eClass.getESuperTypes().size() == 0) {
			return nullClass;
		} else {
			var EClass eSuperClass = eClass.getESuperTypes().get(0);
			if (eSuperClass.interface) {
				return firstSuperClass(eSuperClass, nullClass);
			} else {
				return eSuperClass;
			}
		}
	}

	@NonNull protected def static List<EClass> getSortedEClasses(@NonNull EPackage ePackage) {
		var List<EClass> sortedEClasses = new ArrayList<EClass>();
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if ((eClassifier instanceof EClass) && !(eClassifier as EClass).interface) {
				sortedEClasses.add(eClassifier as EClass);
			}
		}
		var Comparator<ENamedElement> comparator = [ENamedElement e1, ENamedElement e2|e1.name.compareTo(e2.name);];
		Collections.sort(sortedEClasses, comparator);
		return sortedEClasses;
	}
	
	@NonNull protected def static String getTemplatedName(@NonNull EClass eClass) {
		var StringBuilder s = new StringBuilder();
		s.append(eClass.name);
		var List<ETypeParameter> eTypeParameters = eClass.getETypeParameters();
		if (eTypeParameters.size() > 0) {
			s.append("<");
			var int i = 0;
			while (i < eTypeParameters.size()) {
				if (i > 0) {
					s.append(",");
				}
				s.append("?");
				i = i + 1;
			}
			s.append(">");
		}
		return s.toString();
	}

	/*
	 * Abstract«projectPrefix»«generic»Visitor
	 */
	protected def void generateAbstractGenericVisitor(@NonNull EPackage ePackage, @NonNull String generic, @NonNull Class<?> returnClass, @NonNull Class<?> contextClass) {
		var boolean isDerived = isDerived();
		var boolean needsOverride = needsOverride();
		var MergeWriter writer = new MergeWriter(outputFolder + "Abstract" + projectPrefix + generic + "Visitor.java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»
			
			import «returnClass.getName()»;
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;
			import «contextClass.getName()»;
			«IF isDerived»import «superVisitorPackageName»ities.«superProjectPrefix»«generic»Visitor;«ENDIF»
			
			/**
			 * An Abstract«projectPrefix»«generic»Visitor provides a default implementation for each
			 * visitXxx method that delegates to the visitYyy method of the first
			 * super class, (or transitively its first super class' first super class
			 * until a non-interface super-class is found). In the absence of any
			 * suitable first super class, the method delegates to visiting().
			 */
			public abstract class Abstract«projectPrefix»«generic»Visitor
				«IF isDerived»extends «superProjectPrefix»«generic»Visitor«ENDIF»
				implements «visitorClassName»<«returnClass.getSimpleName()»>
			{
				/**
				 * Initializes me with an initial value for my result.
				 * 
				 * @param context my initial result value
				 */
				protected Abstract«projectPrefix»«generic»Visitor(@NonNull «contextClass.getSimpleName()» context) {
					super(context);
				}	
				«FOR eClass : getSortedEClasses(ePackage)»
				«var EClass firstSuperClass = eClass.firstSuperClass(eClass)»
			
				«IF needsOverride»
				@Override
				«ENDIF»
				public @Nullable «returnClass.getSimpleName()» visit«eClass.name»(@NonNull «modelPackageName».«getTemplatedName(eClass)» object) {
					«IF firstSuperClass == eClass»
					return visiting(object);
					«ELSE»
					return visit«firstSuperClass.name»(object);
					«ENDIF»
				}
				«ENDFOR»
			}
		''');
		writer.close();
	}

	/*
	 * AbstractDelegatingVisitor
	 */
	protected def void generateAbstractDelegatingVisitor(@NonNull EPackage ePackage) {
		var boolean isDerived = isDerived();
		var boolean needsOverride = needsOverride();
		var MergeWriter writer = new MergeWriter(outputFolder + "AbstractDelegating" + visitorClassName + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»
			
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;
			
			/**
			 * An AbstractDelegating«visitorClassName» delegates all visits.
			 */
			public abstract class AbstractDelegating«visitorClassName»<R, C, D extends «visitorClassName»<R>>
				extends «IF isDerived»«superVisitorPackageName».AbstractDelegating«superVisitorClassName»<R, C, D>«ELSE»«IF isDerived»«superVisitorClassName»«ELSE»Abstract«visitorClassName»«ENDIF»<R, C>«ENDIF»
				implements «visitorClassName»<R>
			{
				«IF isDerived»
				protected AbstractDelegating«visitorClassName»(@NonNull D delegate, @NonNull C context) {
					super(delegate, context);
				}
				«ELSE»
				protected final D delegate;
				
				protected AbstractDelegating«visitorClassName»(@NonNull D delegate, @NonNull C context) {
					super(context);
				//	assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$
					this.delegate = delegate;		
				//	delegate.setUndecoratedVisitor(this);
				}

				/**
				 * Delegates to my decorated visitor.
				 */
				//	public @NonNull Decorable«visitorClassName»<R> createNestedVisitor() {
				//		return delegate.createNestedVisitor();
				//	}

				/**
				 * Obtains the visitor that I decorate.
				 * 
				 * @return my decorated visitor
				 */
				@SuppressWarnings("null")
				protected final @NonNull D getDelegate() {
					return delegate;
				}
				«ENDIF»
			
				«IF isDerived»
				@Override
				«ENDIF»
				public @Nullable R visiting(@NonNull «visitablePackageName».«visitableClassName» visitable) {
					return delegate.visiting(visitable);
				}
				«FOR eClass : getSortedEClasses(ePackage)»

				«IF needsOverride»
				@Override
				«ENDIF»
				public @Nullable R visit«eClass.name»(@NonNull «modelPackageName».«getTemplatedName(eClass)» object) {
					return delegate.visit«eClass.name»(object);
				}
				«ENDFOR»
			}
		''');
		writer.close();
	}

	/*
	 * AbstractExtendingDelegatingVisitor
	 */
	protected def void generateAbstractExtendingDelegatingVisitor(@NonNull EPackage ePackage) {
		var MergeWriter writer = new MergeWriter(outputFolder + "AbstractExtendingDelegating" + visitorClassName + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»
			
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;
			import «superVisitorPackageName».AbstractDelegating«superVisitorClassName»;
			import «superVisitorPackageName».«superVisitorClassName»;
			
			/**
			 * An AbstractExtendingDelegating«visitorClassName» provides a default implementation for each
			 * visitXxx method that delegates to the supertype if the supertype is in the same package as
			 * the visited type, otherwise it delegates to the delegate.
			 */
			public abstract class AbstractExtendingDelegating«visitorClassName»<R, C, D extends «superVisitorClassName»<R>>
				extends AbstractDelegating«superVisitorClassName»<R, C, D>
				implements «visitorClassName»<R>
			{
				«IF true»
				protected AbstractExtendingDelegating«visitorClassName»(@NonNull D delegate, @NonNull C context) {
					super(delegate, context);
				}
				«ELSE»
				protected final D delegate;
				
				protected AbstractExtendingDelegating«visitorClassName»(@NonNull D delegate, @NonNull C context) {
					super(context);
				//	assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$		
					this.delegate = delegate;		
				//	delegate.setUndecoratedVisitor(this);
				}

				/**
				 * Delegates to my decorated visitor.
				 */
				//	public Decorable«visitorClassName»<R> createNestedVisitor() {
				//		return delegate.createNestedVisitor();
				//	}

				/**
				 * Obtains the visitor that I decorate.
				 * 
				 * @return my decorated visitor
				 */
				protected final D getDelegate() {
					return delegate;
				}
				«ENDIF»

				@Override
				public @Nullable R visiting(@NonNull «visitablePackageName».«visitableClassName» visitable) {
					return delegate.visiting(visitable);
				}
				«FOR eClass : getSortedEClasses(ePackage)»
				«var EClass firstSuperClass = eClass.firstSuperClass(eClass)»

				«IF needsOverride»
				@Override
				«ENDIF»
				public @Nullable R visit«eClass.name»(@NonNull «modelPackageName».«getTemplatedName(eClass)» object) {
					«IF firstSuperClass == eClass»
					return visiting(object);
					«ELSEIF firstSuperClass.getEPackage() == eClass.getEPackage()»
					return visit«firstSuperClass.name»(object);
					«ELSE»
					return delegate.visit«firstSuperClass.name»(object);
					«ENDIF»
				}
				«ENDFOR»
			}
		''');
		writer.close();
	}

	/*
	 * AbstractExtendingVisitor
	 */
	protected def void generateAbstractExtendingVisitor(@NonNull EPackage ePackage) {
		var boolean isDerived = isDerived();
		var boolean needsOverride = needsOverride();
		var MergeWriter writer = new MergeWriter(outputFolder + "AbstractExtending" + visitorClassName + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»
			
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;
			
			/**
			 * An AbstractExtending«visitorClassName» provides a default implementation for each
			 * visitXxx method that delegates to the visitYyy method of the first
			 * super class, (or transitively its first super class' first super class
			 * until a non-interface super-class is found). In the absence of any
			 * suitable first super class, the method delegates to visiting().
			 */
			public abstract class AbstractExtending«visitorClassName»<R, C>
				extends «IF isDerived»«superVisitorPackageName».AbstractExtending«superVisitorClassName»«ELSE»Abstract«visitorClassName»«ENDIF»<R, C>
				implements «visitorClassName»<R>
			{
				/**
				 * Initializes me with an initial value for my result.
				 * 
				 * @param context my initial result value
				 */
				protected AbstractExtending«visitorClassName»(@NonNull C context) {
					super(context);
				}	
				«FOR eClass : getSortedEClasses(ePackage)»
				«var EClass firstSuperClass = eClass.firstSuperClass(eClass)»
			
				«IF needsOverride»
				@Override
				«ENDIF»
				public @Nullable R visit«eClass.name»(@NonNull «modelPackageName».«getTemplatedName(eClass)» object) {
					«IF firstSuperClass == eClass»
					return visiting(object);
					«ELSE»
					return visit«firstSuperClass.name»(object);
					«ENDIF»
				}
				«ENDFOR»
			}
		''');
		writer.close();
	}
	/*
	 * AbstractNonNullExtendingVisitor
	 */
	protected def void generateAbstractNonNullExtendingVisitor(@NonNull EPackage ePackage) {
		var boolean isDerived = isDerived();
		var boolean needsOverride = needsOverride();
		var MergeWriter writer = new MergeWriter(outputFolder + "AbstractNonNullExtending" + visitorClassName + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»
			
			import org.eclipse.jdt.annotation.NonNull;
			
			/**
			 * An AbstractExtendingNonNull«visitorClassName» provides a default implementation for each
			 * visitXxx method that delegates to the visitYyy method of the first
			 * super class, (or transitively its first super class first super class
			 * until a non-interface super-class is found). In the absence of any
			 * suitable first super class, the method delegates to visiting().
			 * The return in annotated as @NonNull.
			 */
			public abstract class AbstractNonNullExtending«visitorClassName»<R, C>
				extends «IF isDerived»«superVisitorPackageName».AbstractNonNullExtending«superVisitorClassName»«ELSE»Abstract«visitorClassName»«ENDIF»<R, C>
				implements «visitorClassName»<R>
			{
				/**
				 * Initializes me with an initial value for my result.
				 * 
				 * @param context my initial result value
				 */
				protected AbstractNonNullExtending«visitorClassName»(@NonNull C context) {
					super(context);
				}	
				«IF !isDerived»
				
				/**
				 * Perform a visit to the specified visitable.
				 * 
				 * @param visitable a visitable
				 * @return the non-null result of visiting it
				 */
				@Override
				public @NonNull R visit(@NonNull «visitablePackageName».«visitableClassName» visitable) {
					R result = visitable.accept(this);
					if (result == null) {
						throw new IllegalStateException("null return from non-null " + getClass().getName());
					}
					return result;
				}
				«ENDIF»
				«FOR eClass : getSortedEClasses(ePackage)»
				«var EClass firstSuperClass = eClass.firstSuperClass(eClass)»
			
				«IF needsOverride»
				@Override
				«ENDIF»
				public @NonNull R visit«eClass.name»(@NonNull «modelPackageName».«getTemplatedName(eClass)» object) {
					«IF firstSuperClass == eClass»
					return visiting(object);
					«ELSE»
					return visit«firstSuperClass.name»(object);
					«ENDIF»
				}
				«ENDFOR»
				«IF !isDerived»

				/**
				 * Return the result of visiting a visitable for which no more specific pivot type method
				 * is available.
				 */
				«IF needsOverride»
				@Override
				«ENDIF»
				public abstract @NonNull R visiting(@NonNull «visitablePackageName».«visitableClassName» visitable);
				«ENDIF»
			}
		''');
		writer.close();
	}

	/*
	 * AbstractNullVisitor
	 */
	protected def void generateAbstractNullVisitor(@NonNull EPackage ePackage) {
		var boolean isDerived = isDerived();
		var boolean needsOverride = needsOverride();
		var MergeWriter writer = new MergeWriter(outputFolder + "AbstractNull" + visitorClassName + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»

			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;

			/**
			 * An AbstractNull«visitorClassName» provides a default implementation for each
			 * visitXxx method that returns null.
			 */
			public abstract class AbstractNull«visitorClassName»<R, C>
				«IF !isDerived»
				extends Abstract«visitorClassName»<R, C>
				«ELSE»
				extends «superVisitorPackageName».AbstractNull«superVisitorClassName»<R, C> implements «visitorClassName»<R>
				«ENDIF»
			{
				/**
				 * Initializes me with an initial value for my result.
				 * 
				 * @param context my initial result value
				 */
				protected AbstractNull«visitorClassName»(@NonNull C context) {
					super(context);
				}	
				«FOR eClass : getSortedEClasses(ePackage)»

				«IF needsOverride»
				@Override
				«ENDIF»
				public @Nullable R visit«eClass.name»(@NonNull «modelPackageName».«getTemplatedName(eClass)» object) {
					return null;
				}
				«ENDFOR»
			}
		''');
		writer.close();
	}

	/*
	 *AbstractVisitor
	 */
	protected def void generateAbstractVisitor(@NonNull EPackage ePackage) {
		var boolean isDerived = isDerived();
		var boolean needsOverride = needsOverride();
		var MergeWriter writer = new MergeWriter(outputFolder + "Abstract" + visitorClassName + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»
			
			import org.eclipse.jdt.annotation.NonNull;
			«IF !isDerived»
			import org.eclipse.jdt.annotation.Nullable;
			«ENDIF»
			
			/*
			 * An Abstract«visitorClassName» provides a default implementation of the visitor framework
			 * but n implementations of the visitXXX methods..
			 */
			public abstract class Abstract«visitorClassName»<R, C>
				«IF isDerived»
				extends «superVisitorPackageName».Abstract«superVisitorClassName»<R, C>
				«ENDIF»
				implements «visitorClassName»<R>
			{
				«IF !isDerived»
				/**
				 * Context for the AST visitation.
				 */
				protected final @NonNull C context;

				«ENDIF»	
				/**
				 * Initializes me with an initial value for my result.
				 * 
				 * @param context my initial result value
				 */
				protected Abstract«visitorClassName»(@NonNull C context) {
					«IF !isDerived»
					this.context = context;
					«ELSE»
					super(context);
					«ENDIF»
				}
				«IF !isDerived»

				@SuppressWarnings("unchecked")
				«IF needsOverride»
				@Override
				«ENDIF»
				public <A> A getAdapter(@NonNull Class<A> adapter) {
					if (adapter.isAssignableFrom(getClass())) {
						return (A) this;
					}
					else {
						return null;
					}
				}
				
				/**
				 * A null-safe visitation of the specified visitable.
				 * 
				 * @param v a visitable, or <code>null</code>
				 * @return <code>null</code> if the visitable is <code>null</code>;
				 *	 otherwise, the result of visiting it
				 */
				public @Nullable R safeVisit(@Nullable «visitablePackageName».«visitableClassName» v) {
					return (v == null) ? null : v.accept(this);
				}
				
				/**
				 * Perform a visit to the specified visitable.
				 * 
				 * @param v a visitable, or <code>null</code>
				 * @return <code>null</code> if the visitable is <code>null</code>;
				 *	 otherwise, the result of visiting it
				 */
				public @Nullable R visit(@NonNull «visitablePackageName».«visitableClassName» v) {
					return v.accept(this);
				}

				//	public @Nullable R visiting(@NonNull «visitablePackageName».«visitableClassName» visitable) {
				//		return null;
				//	}
				«ENDIF»
			}
		''');
		writer.close();
	}
	
	/*
	 * AbstractWrappingVisitor
	 */
	protected def void generateAbstractWrappingVisitor(@NonNull EPackage ePackage) {
		var boolean isDerived = isDerived();
		var boolean needsOverride = needsOverride();
		var MergeWriter writer = new MergeWriter(outputFolder + "AbstractWrapping" + visitorClassName + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»
			
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;
			
			/**
			 * An AbstractWrapping«visitorClassName» delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
			 */
			public abstract class AbstractWrapping«visitorClassName»<R, C, D extends «visitorClassName»<R>, P>
				extends «IF isDerived»«superVisitorPackageName».AbstractWrapping«superVisitorClassName»<R, C, D, P>«ELSE»«IF isDerived»«superVisitorClassName»«ELSE»Abstract«visitorClassName»«ENDIF»<R, C>«ENDIF»
				implements «visitorClassName»<R>
			{
				«IF isDerived»
				protected AbstractWrapping«visitorClassName»(@NonNull D delegate, @NonNull C context) {
					super(delegate, context);
				}
				«ELSE»
				protected final D delegate;
				
				protected AbstractWrapping«visitorClassName»(@NonNull D delegate, @NonNull C context) {
					super(context);
					this.delegate = delegate;		
				//	delegate.setUndecoratedVisitor(this);
				}

				/**
				 * Intercept an exception thrown by the delegated visit to perform some post-functionality that may use the visitable object,
				 * the result of preVisit and the thrown exception to determine the overall wrapped result.
				 * 
				 * @return a rethrown RuntimeException or a RuntimeException-wrapped non-RuntimeException.
				 */
				protected @Nullable R badVisit(@NonNull «visitablePackageName».«visitableClassName» visitable, @Nullable P prologue, @NonNull Throwable e) throws RuntimeException {
					if (e instanceof Exception) {
						throw (RuntimeException)e;
					}
					else {
						throw new RuntimeException(e);
					}
				}

				/**
				 * Obtains the visitor that I wrap.
				 * 
				 * @return my wrapped visitor
				 */
				@SuppressWarnings("null")
				protected @NonNull D getDelegate() {
					return delegate;
				}

				/**
				 * Intercept the result of the delegated visit to perform some post-functionality that may use the visitable object,
				 * the result of preVisit and the result of the delegated visit to determine the overall wrapped result.
				 * 
				 * @return the epilogue result, which defaults to the delegated result.
				 */
				protected @Nullable R postVisit(@NonNull «visitablePackageName».«visitableClassName» visitable, @Nullable P prologue, @Nullable R result) {
					return result;
				}

				/**
				 * Compute and return some value before performing the delegated visit.
				 * 
				 * @return the prologue result, which defauilts to null.
				 */
				protected @Nullable P preVisit(@NonNull «visitablePackageName».«visitableClassName» visitable) {
					return null;
				}

				public @Nullable R visiting(@NonNull «visitablePackageName».«visitableClassName» visitable) {
					throw new UnsupportedOperationException();		// Cannot happen since all methods delegate.
				}
				«ENDIF»
				«FOR eClass : getSortedEClasses(ePackage)»

				«IF needsOverride»
				@Override
				«ENDIF»
				public @Nullable R visit«eClass.name»(@NonNull «modelPackageName».«getTemplatedName(eClass)» object) {
					P prologue = preVisit(object);
					try {
						R result = delegate.visit«eClass.name»(object);
						return postVisit(object, prologue, result);
					}
					catch (Throwable e) {
						return badVisit(object, prologue, e);
					}
				}
				«ENDFOR»
			}
		''');
		writer.close();
	}

	/*
	 * DecorableVisitorInterface
	 */
	protected def void generateDecorableVisitorInterface(@NonNull EPackage ePackage, String visitorRootClass) {
		var boolean isDerived = isDerived();
		var MergeWriter writer = new MergeWriter(outputFolder + "Decorable" + visitorClassName + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»
			
			import org.eclipse.jdt.annotation.NonNull;
			
			/**
			 */
			public interface Decorable«visitorClassName»<R> extends «visitorClassName»<R>«IF isDerived», «superVisitorPackageName».Decorable«superVisitorClassName»<R>«ENDIF»
			{
				void setUndecoratedVisitor(@NonNull «visitorRootClass»<R> visitor);
			}
		''');
		writer.close();
	}

	protected def String generateHeader(@NonNull EPackage ePackage, String javaPackage) {
		'''
		/*******************************************************************************
		 * «MergeWriter.getCopyright(copyright).replace("\n", "\n* ")»
		 *
		 * This code is auto-generated
		 * from: «projectName»/«sourceFile»
		 *
		 * Only the copyright statement is editable.
		 *******************************************************************************/
		package	«javaPackage»;
		'''
	}

	protected def void generateVisitableInterface(@NonNull EPackage ePackage) {
		var MergeWriter writer = new MergeWriter(outputFolder + visitableClassName + ".java");
		writer.append('''
			«ePackage.generateHeader(visitablePackageName)»

			import org.eclipse.emf.ecore.EClass;
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;

			public interface «visitableClassName»
			{
				/**
				 * Returns the result of accepting a visit from a visitor.
				 * Implementations typically invoke a derived-class-specific
				 * variant of visitXXX() to facilitate derived-class-specific
				 * processing or just visit() when no such method is available.
				 * <p>
				 * Implementations of visit() may use the EcoreSwitch to perform
				 * derived-class-specific processing.
				 * <p>
				 * Derived implementations of accept() may use getAdapter() to obtain
				 * richer visitor interfaces.
				 * @param <R, C>
				 * @param visitor
				 * @return the result of the visit.
				 */
				@Nullable <R> R accept(@NonNull «visitorPackageName».«visitorClassName»<R> visitor);
				
				EClass eClass();
			}
		''');
		writer.close();
	}

	protected def void generateVisitorInterface(@NonNull EPackage ePackage) {
		var boolean isDerived = isDerived();
		var MergeWriter writer = new MergeWriter(outputFolder + visitorClassName + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»

			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;

			/**
			 */
			public interface «visitorClassName»<R>«IF isDerived» extends «superVisitorPackageName».«superVisitorClassName»<R>«ENDIF»
			{
				«IF !isDerived»
				/**
				 * Returns an object which is an instance of the given class
				 * associated with this object. Returns <code>null</code> if
				 * no such object can be found.
				 *
				 * @param adapter the adapter class to look up
				 * @return an object of the given class, 
				 *    or <code>null</code> if this object does not
				 *    have an adapter for the given class
				 */
				@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

				/**
				 * Return the result of visiting a visitable for which no more specific pivot type method
				 * is available.
				 */
				@Nullable R visiting(@NonNull «visitablePackageName».«visitableClassName» visitable);

				«ENDIF»
				«FOR eClass : getSortedEClasses(ePackage)»
				@Nullable R visit«eClass.name»(@NonNull «modelPackageName».«getTemplatedName(eClass)» object);
				«ENDFOR»
			}
		''')
		writer.close();
	}
}
