
package org.eclipse.ocl.examples.pivot.lookup;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;


/**
 * @since 3.5
 * 
 * FIXME Rename to IEnvironment
 */
public interface Environment {
	@NonNull Environment addElement(@Nullable DomainNamedElement namedElement);
	@NonNull Environment addElements(@Nullable List<? extends DomainNamedElement> namedElements);
	@NonNull DomainEvaluator getEvaluator();
	int getSize();
	boolean hasFinalResult();
}
