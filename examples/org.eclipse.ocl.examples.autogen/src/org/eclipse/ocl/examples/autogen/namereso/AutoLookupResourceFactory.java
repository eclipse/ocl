package org.eclipse.ocl.examples.autogen.namereso;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor;
import org.eclipse.ocl.examples.codegen.utilities.AbstractCGModelResourceFactory;


public class AutoLookupResourceFactory extends AbstractCGModelResourceFactory {
	public static final @NonNull AutoLookupResourceFactory INSTANCE = new AutoLookupResourceFactory();

	@Override
	public @NonNull CG2StringVisitor createToStringVisitor() {
		return AutoLookupCG2StringVisitor.FACTORY.createToStringVisitor();
	}
}