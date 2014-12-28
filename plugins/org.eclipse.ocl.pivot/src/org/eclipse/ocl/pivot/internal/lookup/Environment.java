package org.eclipse.ocl.pivot.internal.lookup;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.Evaluator;


public interface Environment {
	@NonNull Environment addElement(@Nullable NamedElement namedElement);
	@NonNull Environment addElements(@Nullable List<? extends NamedElement> namedElements);
	@NonNull Evaluator getEvaluator();
	boolean hasFinalResult();
}
