/*******************************************************************************
 * Copyright (c) 2013,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.xtend

import org.eclipse.jdt.annotation.NonNull
import org.eclipse.ocl.examples.pivot.Root
import org.eclipse.ocl.examples.pivot.Namespace
import org.eclipse.ocl.examples.pivot.Element

public class GenerateOCLstdlibAsTextileXtend extends GenerateOCLstdlibAsTextileUtils
{
	@NonNull protected override String generateTextile(@NonNull Root root) {
		'''
		h1(#StandardLibrary). The OCL Standard Library
		
		This documentation on the OCL Standard Library is auto-generated from the
		org.eclipse.ocl.examples.library/model/OCL-2.5.oclstdlib that defines
		the behaviour of the Pivot evaluator and the Xtext editors. It is similar to the OCL 2.4 functionality.
		It is a prototype of functionality for OCL 2.5 where the use of models may eliminate ambiguities.
		
		The library support for the Ecore and UML bindings in Luna has been upgraded so that the available operations
		are similar to those documented here for the Pivot binding.
		
		«emitPrecedences(root)»
		
		«emitClasses(root)»
		'''
	}

	protected def emitAssociations(org.eclipse.ocl.examples.pivot.Class asClass) {
		var asAssociations = getSortedAssociations(asClass);
		if (asAssociations.size() > 0) {
		'''

		*Associations*
		«FOR asAssociation : asAssociations»

			@«prettyPrint(asAssociation, asClass)»@
			«emitComment(asAssociation, asClass)»
		«ENDFOR»
		'''
		}
	}

	protected def emitAttributes(org.eclipse.ocl.examples.pivot.Class asClass) {
		var asAttributes = getSortedAttributes(asClass);
		if ( asAttributes.size() > 0) {
		'''

		*Attributes*
		«FOR asAttribute : asAttributes»

			@«prettyPrint(asAttribute, asClass)»@
			«emitComment(asAttribute, asClass)»
		«ENDFOR»
		'''
		}
	}

	protected def emitClasses(Root asRoot) {
		var asClasses = getSortedClasses(asRoot);
		'''
		«FOR asClass : asClasses»
			
			h2(#«asClass.name»). **@«prettyPrint(asClass, asClass)»@**
			«emitComment(asClass, asClass)»
			«IF asClass.getSuperClasses().size() > 0»
			
			conformsTo «FOR asSuperClass : asClass.getSuperClasses() SEPARATOR ', '»"@«prettyPrint(asSuperClass, asSuperClass)»@":#«asSuperClass.name»«ENDFOR»
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

		*Iterations*
		«FOR asIteration : asIterations»

			@«prettyPrint(asIteration, asClass)»@
			«emitComment(asIteration, asClass)»
			«FOR asConstraint : getSortedConstraints(asIteration)»

				bc.. 
				«prettyPrint(asConstraint, asClass)»
				p. 
			«ENDFOR»
		«ENDFOR»
		'''
		}
	}

	protected def emitOperations(org.eclipse.ocl.examples.pivot.Class asClass) {
		var asOperations = getSortedOperations(asClass);
		if (asOperations.size() > 0) {
		'''

		*Operations*
		«FOR asOperation : asOperations»

			@«prettyPrint(asOperation, asClass)»«IF asOperation.isInvalidating» invalidating«ENDIF»«IF asOperation.isValidating» validating«ENDIF»@
			«IF asOperation.precedence != null»
				precedence: @«asOperation.precedence.name»@
			«ENDIF»
			«emitComment(asOperation, asClass)»
			«FOR asConstraint : getSortedPreconditions(asOperation)»

				bc.. 
				«prettyPrint(asConstraint, asClass)»
				p. 
			«ENDFOR»
			«IF asOperation.bodyExpression != null»

				bc.. 
				body: «asOperation.bodyExpression.getBody()»
				p. 
			«ENDIF»
			«FOR asConstraint : getSortedPostconditions(asOperation)»

				bc.. 
				«prettyPrint(asConstraint, asClass)»
				p. 
			«ENDFOR»
		«ENDFOR»
		'''
		}
	}
	
	protected def emitPrecedences(Root asRoot) {
		'''
		h2(#Precedences). *Precedences*

		«FOR asPrecedence : getPrecedences(asRoot) SEPARATOR ' > '»@«asPrecedence.name»@«ENDFOR»
		'''
	}
}
