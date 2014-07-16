package org.eclipse.ocl.examples.autogen.namereso

import org.eclipse.jdt.annotation.NonNull
import org.eclipse.ocl.examples.autogen.namereso.NameResolutionUtil.AddingCallArgExp
import org.eclipse.ocl.examples.pivot.CollectionType
import org.eclipse.ocl.examples.pivot.Type

class AutoNameResoCGNamesProvider {
	
	private static final String autoPrefix = "Auto"; // FIXME To be removed in the future
	
	private final String projectPrefix;
	
	new(@NonNull String projectPrefix) {
		this.projectPrefix = projectPrefix;
	}

	@NonNull
	def public String getCommonContextItf() {
		return '''«autoPrefix»ILookupContext'''
	}
	
	@NonNull
	def public String getSpecificContextItf() {
		return '''«autoPrefix»I«projectPrefix»LookupContext'''
	}
	
	@NonNull
	def public String getCommonContextClass() {
		return '''«autoPrefix»LookupContext'''
	}	
	
	@NonNull
	def public String getSpecificContextClass() {
		return '''«autoPrefix»«projectPrefix»LookupContext'''
	}
	
	// Result
	@NonNull
	def public String getCommonResultItf() {
		return '''«autoPrefix»ILookupResult'''
	}
	
	@NonNull
	def public String getSpecificResultItf() {
		return '''«autoPrefix»I«projectPrefix»LookupResult'''
	}
	
	@NonNull
	def public String getCommonResultClass() {
		return '''«autoPrefix»LookupResult'''
	}
	
	@NonNull
	def public String getSpecificResultClass() {
		return '''«autoPrefix»«projectPrefix»LookupResult'''
	}
	
	// Named Result
	
	@NonNull
	def public String getCommonNamedResultItf() {
		return '''«autoPrefix»INamedLookupResult'''
	}
	
	@NonNull
	def public String getSpecificNamedResultItf() {
		return '''«autoPrefix»I«projectPrefix»NamedLookupResult'''
	}
	
	@NonNull
	def public String getCommonNamedResultClass() {
		return '''«autoPrefix»NamedLookupResult'''
	}
	
	@NonNull
	def public String getSpecificNamedResultClass() {
		return '''«autoPrefix»«projectPrefix»NamedLookupResult'''
		
	}
	
	// Unnamed Result
	@NonNull
	def public String getCommonUnnamedResultItf() {
		return '''«autoPrefix»IUnnamedLookupResult'''
	}
	
	@NonNull
	def public String getSpecificUnnamedResultItf() {
		return '''«autoPrefix»I«projectPrefix»UnnamedLookupResult'''
	}
	
	@NonNull
	def public String getCommonUnnamedResultClass() {
		return '''«autoPrefix»UnnamedLookupResult'''
	}
	
	@NonNull
	def public String getSpecificUnnamedResultClass() {
		return '''«autoPrefix»«projectPrefix»UnnamedLookupResult'''
		
	}
	
	// Environment
	@NonNull
	def public String getCommonEnvironmentItf() {
		return '''«autoPrefix»ILookupEnvironment'''
	}
	
	@NonNull
	def public String getSpecificEnvironmentItf() {
		return '''«autoPrefix»I«projectPrefix»LookupEnvironment'''
	}
	
	@NonNull
	def public String getCommonEnvironmentClass() {
		return '''«autoPrefix»LookupEnvironment'''
	}
	
	@NonNull
	def public String getSpecificEnvironmentClass() {
		return '''«autoPrefix»«projectPrefix»LookupEnvironment'''
	}
	
	// Named Environment
	
	@NonNull
	def public String getCommonNamedEnvironmentItf() {
		return '''«autoPrefix»INamedLookupEnvironment'''
	}
	
	@NonNull
	def public String getSpecificNamedEnvironmentItf() {
		return '''«autoPrefix»I«projectPrefix»NamedLookupEnvironment'''
	}
	
	@NonNull
	def public String getCommonNamedEnvironmentClass() {
		return '''«autoPrefix»NamedLookupEnvironment'''
	}
	
	@NonNull
	def public String getSpecificNamedEnvironmentClass() {
		return '''«autoPrefix»«projectPrefix»NamedLookupEnvironment'''
		
	}
	
	@NonNull
	def public String getSpecificAbstractNamedEnvironmentClass() {
		return '''«autoPrefix»Abstract«projectPrefix»NamedLookupEnvironment'''
	}
	
	// Unnamed Environment
	@NonNull
	def public String getCommonUnnamedEnvironmentItf() {
		return '''«autoPrefix»IUnnamedLookupEnvironment'''
	}
	
	@NonNull
	def public String getSpecificUnnamedEnvironmentItf() {
		return '''«autoPrefix»I«projectPrefix»UnnamedLookupEnvironment'''
	}
	
	@NonNull
	def public String getCommonUnnamedEnvironmentClass() {
		return '''«autoPrefix»UnnamedLookupEnvironment'''
	}
	
	@NonNull
	def public String getSpecificUnnamedEnvironmentClass() {
		return '''«autoPrefix»«projectPrefix»UnnamedLookupEnvironment'''
		
	}
	
	// Visitor
	@NonNull
	def public String getSpecificVisitorItf() {
		return '''«autoPrefix»I«projectPrefix»LookupVisitor''' 
	}
	
	@NonNull
	def public String getSpecificVisitorClass() {
		return '''«autoPrefix»«projectPrefix»LookupVisitor'''
	}
	
	@NonNull
	def public String getCustomSpecificVisitorClass() {
		return '''New«projectPrefix»LookupVisitor"'''	
	}
		
	// Name Resolver
	@NonNull
	def public String getSpecificNameResolverItf() {
		return '''«autoPrefix»I«projectPrefix»NameResolver'''
	}
	
	@NonNull
	def public String getSpecificNameResolverClass() {
		return '''«autoPrefix»«projectPrefix»NameResolver'''
	}	
	
	// Some more useful methods
	
	def public String getAddMethodName(Type type, AddingCallArgExp addingCallArgExp) {
		val typeName = type.name
		val expType = addingCallArgExp.getType
		val isMany = expType instanceof CollectionType
		val expTypeName = if (expType instanceof CollectionType) expType.elementType.name else expType.name
		val addingCallPos = addingCallArgExp.number
		return '''add«typeName»«addingCallPos»_«expTypeName.toFirstUpper»Element«if(isMany)"s"»'''
	}
	
	
}