package org.eclipse.ocl.pivot.lookup;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.Evaluator;


/**
 * @since 3.5
 */
public interface Environment {
	@NonNull Environment addElement(@Nullable NamedElement namedElement);
	@NonNull Environment addElements(@Nullable List<? extends NamedElement> namedElements);
	@NonNull Evaluator getEvaluator();
	boolean hasFinalResult();
}
