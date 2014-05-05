package org.eclipse.ocl.examples.debug.vm.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;


public interface IVMEvaluator
{
	Boolean execute();

	@NonNull NamedElement getDebuggable();

	@NonNull MetaModelManager getMetaModelManager();

	void saveModels();

	void setSuspendOnStartUp(boolean suspendOnStartup);
}
