package org.eclipse.ocl.xtext.base.cs2as.tx;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformationExecutor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

public class CS2ASTransformationExecutor extends AbstractTransformationExecutor {

	public CS2ASTransformationExecutor(@NonNull EnvironmentFactory environmentFactory,
			@NonNull Class<? extends CS2ASTransformer> txClass)
					throws ReflectiveOperationException {
		super(environmentFactory, txClass);
	}

	@Override
	public @NonNull CS2ASTransformer getTransformer() {
		return (CS2ASTransformer) super.getTransformer();
	}
}
