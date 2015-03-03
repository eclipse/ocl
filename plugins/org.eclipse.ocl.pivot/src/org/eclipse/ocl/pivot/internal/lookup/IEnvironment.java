
package org.eclipse.ocl.pivot.internal.lookup;

import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.Evaluator;


/**
 * 
 * FIXME Rename to IEnvironment
 */
public interface IEnvironment {
	@NonNull IEnvironment addElement(@Nullable NamedElement namedElement);
	@NonNull IEnvironment addElements(@Nullable Collection<NamedElement> namedElements);
	@NonNull Evaluator getEvaluator();
	int getSize();
	boolean hasFinalResult();
}
