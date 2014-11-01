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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil
import org.eclipse.ocl.examples.pivot.Class
import org.eclipse.ocl.examples.pivot.Element
import org.eclipse.ocl.examples.pivot.Namespace
import org.eclipse.jdt.annotation.Nullable

public class GenerateLaTeXForModelXtend extends GenerateLaTeXForModelUtils
{
	@NonNull protected override String generateLaTeX(@NonNull org.eclipse.ocl.examples.pivot.Package asPackage,
		@Nullable org.eclipse.ocl.examples.pivot.Package cs2asPackage,
		@Nullable org.eclipse.ocl.examples.pivot.Package cs2csPackage) {
		'''
		«emitClasses(asPackage, cs2asPackage, cs2csPackage)»
		'''
	}

	protected def emitAssociations(Class asClass) {
		var asAssociations = getSortedAssociations(asClass);
		if (asAssociations.size() > 0) {
		'''

		«emitHeading0a("Associations")»
		«FOR asAssociation : asAssociations»

			«emitHeading0b(prettyPrint(asAssociation, asClass))»
			«emitComment(asAssociation, asClass)»
		«ENDFOR»
		'''
		}
	}

	protected def emitAttributes(Class asClass) {
		var asAttributes = getSortedAttributes(asClass);
		if ( asAttributes.size() > 0) {
		'''

		«emitHeading0a("Attributes")»
		«FOR asAttribute : asAttributes»

			«emitHeading0b(prettyPrint(asAttribute, asClass))»
			«emitComment(asAttribute, asClass)»
		«ENDFOR»
		'''
		}
	}

	protected def emitClasses(@NonNull org.eclipse.ocl.examples.pivot.Package asPackage, @Nullable org.eclipse.ocl.examples.pivot.Package cs2asPackage, @Nullable org.eclipse.ocl.examples.pivot.Package cs2csPackage) {
		var asClasses = getSortedClasses(asPackage);
		'''
		«FOR asClass : asClasses»
			
			«emitHeading3(prettyPrint(asClass, asClass), asClass.name)»
			«emitComment(asClass, asClass)»
			«IF asClass.getSuperClasses().size() > 0»
			
			conformsTo «FOR asSuperClass : asClass.getSuperClasses() SEPARATOR ', '»«prettyPrint(asSuperClass, asSuperClass)»«ENDFOR»
			«ENDIF»
			«emitAttributes(asClass)»
			«emitAssociations(asClass)»
			«emitOperations(asClass)»
			«IF cs2csPackage != null»
			«emitCS2CS(asClass, DomainUtil.nonNullState(cs2csPackage))»
			«ENDIF»
			«IF cs2asPackage != null»
			«emitCS2AS(asClass, DomainUtil.nonNullState(cs2asPackage))»
			«ENDIF»
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

	protected def emitCS2AS(@NonNull org.eclipse.ocl.examples.pivot.Class asClass, @NonNull org.eclipse.ocl.examples.pivot.Package cs2asPackage) {
		var cs2asClass = DomainUtil.getNamedElement(cs2asPackage.getOwnedClasses(), asClass.getName());
		if (cs2asClass != null)  {
		'''

		«emitHeading0a("Abstract Syntax Synthesis")»
		«FOR asOperation : cs2asClass.getOwnedOperations()»

			«emitHeading0b(prettyPrint(asOperation, asClass))»
			«emitComment(asOperation, asClass)»
			«IF asOperation.bodyExpression != null»
				«emitBeginDefinition»
				body:
					«asOperation.bodyExpression.getBody()»
				«emitEndDefinition»
			«ENDIF»
		«ENDFOR»
		'''
		}
	}

	protected def emitCS2CS(@NonNull org.eclipse.ocl.examples.pivot.Class asClass, @NonNull org.eclipse.ocl.examples.pivot.Package cs2asPackage) {
		var cs2csClass = DomainUtil.getNamedElement(cs2asPackage.getOwnedClasses(), asClass.getName());
		if (cs2csClass != null)  {
		'''

		«emitHeading0a("Concrete Syntax Disambiguation")»
		«FOR asOperation : cs2csClass.getOwnedOperations()»

			«emitHeading0b(prettyPrint(asOperation, asClass))»
			«emitComment(asOperation, asClass)»
			«IF asOperation.bodyExpression != null»
				«emitBeginDefinition»
				body:
					«asOperation.bodyExpression.getBody()»
				«emitEndDefinition»
			«ENDIF»
		«ENDFOR»
		'''
		}
	}

	protected def emitOperations(Class asClass) {
		var asOperations = getSortedOperations(asClass);
		if (asOperations.size() > 0) {
		'''

		«emitHeading0a("Operations")»
		«FOR asOperation : asOperations»

			«emitHeading0b(prettyPrint(asOperation, asClass) /*+ (asOperation.isInvalidating ? " invalidating" : "") + (asOperation.isValidating ? " validating" : "")*/)»
			«IF asOperation.precedence != null»
			
				precedence: «emitHeading0b(asOperation.precedence.name)»
			«ENDIF»
			«emitComment(asOperation, asClass)»
			«FOR asConstraint : getSortedPreconditions(asOperation)»
				«emitBeginDefinition»
				«prettyPrint(asConstraint, asClass)»
				«emitEndDefinition»
			«ENDFOR»
			«IF asOperation.bodyExpression != null»
				«emitBeginDefinition»
				body: «asOperation.bodyExpression.getBody()»
				«emitEndDefinition»
			«ENDIF»
			«FOR asConstraint : getSortedPostconditions(asOperation)»
				«emitBeginDefinition»
				«prettyPrint(asConstraint, asClass)»
				«emitEndDefinition»
			«ENDFOR»
		«ENDFOR»
		'''
		}
	}
}
