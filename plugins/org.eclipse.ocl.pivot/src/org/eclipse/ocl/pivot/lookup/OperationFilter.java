package org.eclipse.ocl.pivot.lookup;

import java.util.List;

import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.lookup.util.PivotLookupFilter;

/**
 * @since 1.1
 */
public class OperationFilter implements PivotLookupFilter {


	private List<Type> args;
	
	public OperationFilter(List<Type> args) {
		this.args = args;
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		return namedElement instanceof Operation ? matches((Operation) namedElement) : false;
	}
	
/*	private boolean matches(Operation op) {
		// OCL expression TO be generated
		if (!(args.size() == op.getOwnedParameters().size())) {
			return true;
		}
		boolean forAll = true;
		for (Argument arg : args) {
			Parameter param = op.getOwnedParameters().get(args.indexOf(arg));
			if (!param.getName().equals(arg.getName())) {
				forAll = false;
				break;
			}
		}
		if (forAll) {
			return true;
		}
		return false;
	} */
	
}
