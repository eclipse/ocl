package org.eclipse.ocl.pivot.lookup;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.pivot.NamedElement;


/**
 * @since 3.5
 */
public interface Environment {
	@NonNull Environment addElement(@Nullable NamedElement namedElement);
	@NonNull Environment addElements(@Nullable List<? extends NamedElement> namedElements);
	@NonNull DomainEvaluator getEvaluator();
	boolean hasFinalResult();
}
