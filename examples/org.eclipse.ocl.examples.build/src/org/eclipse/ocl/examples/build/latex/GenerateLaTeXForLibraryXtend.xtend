/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.latex

import org.eclipse.jdt.annotation.NonNull
import org.eclipse.ocl.examples.pivot.Namespace
import org.eclipse.ocl.examples.pivot.Element
import org.eclipse.ocl.examples.pivot.Model

public class GenerateLaTeXForLibraryXtend extends GenerateLaTeXForLibraryUtils
{
	@NonNull protected override String generateLaTeX(@NonNull Model model) {
		'''
		«emitPrecedences(model)»
		
		«emitClasses(model)»
		'''
	}

	protected def emitAssociations(org.eclipse.ocl.examples.pivot.Class asClass) {
		var asAssociations = getSortedAssociations(asClass);
		if (asAssociations.size() > 0) {
		'''

		\subsubsection{Associations}
		«FOR asAssociation : asAssociations»

			\textbf{«prettyPrint(asAssociation, asClass)»}
			«emitComment(asAssociation, asClass)»
		«ENDFOR»
		'''
		}
	}

	protected def emitAttributes(org.eclipse.ocl.examples.pivot.Class asClass) {
		var asAttributes = getSortedAttributes(asClass);
		if ( asAttributes.size() > 0) {
		'''

		\subsubsection{Attributes}
		«FOR asAttribute : asAttributes»

			\textbf{«prettyPrint(asAttribute, asClass)»}
			«emitComment(asAttribute, asClass)»
		«ENDFOR»
		'''
		}
	}

	protected def emitClasses(Model asRoot) {
		var asClasses = getSortedClasses(asRoot);
		'''
		«FOR asClass : asClasses»
			
			\subsection{«prettyPrint(asClass, asClass)»}\label{«asClass.name»}
			«emitComment(asClass, asClass)»
			«IF asClass.getSuperClasses().size() > 0»
			
			conformsTo «FOR asSuperClass : asClass.getSuperClasses() SEPARATOR ', '»"«prettyPrint(asSuperClass, asSuperClass)»":«asSuperClass.name»«ENDFOR»
			«ENDIF»
			«emitAttributes(asClass)»
			«emitAssociations(asClass)»
			«emitOperations(asClass)»
			«emitIterations(asClass)»
		«ENDFOR»
		'''
	}

	protected def emitComment(Element asElement, Namespace asNamespace) {
		if (asElement.getOwnedComment().size() > 0) {
		'''
			«FOR asComment : asElement.getOwnedComment()»
			
			«prettyPrint(asComment, asNamespace)»
			«ENDFOR»
		'''
		}
	}

	protected def emitIterations(org.eclipse.ocl.examples.pivot.Class asClass) {
		var asIterations = getSortedIterations(asClass);
		if (asIterations.size() > 0) {
		'''

		\subsubsection{Iterations}
		«FOR asIteration : asIterations»

			\textbf{«prettyPrint(asIteration, asClass)»}
			«emitComment(asIteration, asClass)»
			«FOR asConstraint : getSortedConstraints(asIteration)»
				\begin{verbatim}
				«prettyPrint(asConstraint, asClass)»
				\end{verbatim}
			«ENDFOR»
		«ENDFOR»
		'''
		}
	}

	protected def emitOperations(org.eclipse.ocl.examples.pivot.Class asClass) {
		var asOperations = getSortedOperations(asClass);
		if (asOperations.size() > 0) {
		'''

		\subsubsection{Operations}
		«FOR asOperation : asOperations»

			\textbf{«prettyPrint(asOperation, asClass)»«IF asOperation.isInvalidating» invalidating«ENDIF»«IF asOperation.isValidating» validating«ENDIF»}
			«IF asOperation.precedence != null»
			
				precedence: \textbf{«asOperation.precedence.name»}
			«ENDIF»
			«emitComment(asOperation, asClass)»
			«FOR asConstraint : getSortedPreconditions(asOperation)»
				\begin{verbatim}
				«prettyPrint(asConstraint, asClass)»
				\end{verbatim}
			«ENDFOR»
			«IF asOperation.bodyExpression != null»
				\begin{verbatim}
				body: «asOperation.bodyExpression.getBody()»
				\end{verbatim}
			«ENDIF»
			«FOR asConstraint : getSortedPostconditions(asOperation)»
				\begin{verbatim}
				«prettyPrint(asConstraint, asClass)»
				\end{verbatim}
			«ENDFOR»
		«ENDFOR»
		'''
		}
	}
	
	protected def emitPrecedences(Model asRoot) {
		'''
		\subsection{Precedences}\label{Precedences}

		«FOR asPrecedence : getPrecedences(asRoot) SEPARATOR ' < '»\textbf{«asPrecedence.name»}«ENDFOR»
		'''
	}
}
