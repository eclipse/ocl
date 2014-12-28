package org.eclipse.ocl.pivot.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.OCL;
import org.eclipse.ocl.pivot.internal.helper.OCLHelper;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLRuntimeModule;
import org.eclipse.ocl.xtext.completeocl.ui.CompleteOCLUiModule;
import org.eclipse.ocl.xtext.completeocl.utilities.CompleteOCLPlugin;
import org.eclipse.ocl.xtext.essentialocl.EssentialOCLRuntimeModule;
import org.eclipse.ocl.xtext.essentialocl.ui.EssentialOCLUiModule;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLPlugin;
import org.eclipse.ocl.xtext.oclinecore.OCLinEcoreRuntimeModule;
import org.eclipse.ocl.xtext.oclinecore.ui.OCLinEcoreUiModule;
import org.eclipse.ocl.xtext.oclinecore.utilities.OCLinEcorePlugin;
import org.eclipse.ocl.xtext.oclstdlib.OCLstdlibRuntimeModule;
import org.eclipse.ocl.xtext.oclstdlib.ui.OCLstdlibUiModule;
import org.eclipse.ocl.xtext.oclstdlib.utilities.OCLstdlibPlugin;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Module;

/**
 * The OCLUI facade provides access to a variety of OCL UI capabilities such as Xtext editors without exposing the
 * internal APIs.
 */
public class OCLUI
{
	public static final @NonNull String COMPLETE_OCL_LANGUAGE_ID = CompleteOCLPlugin.LANGUAGE_ID;
	public static final @NonNull String ESSENTIAL_OCL_LANGUAGE_ID = EssentialOCLPlugin.LANGUAGE_ID;
	public static final @NonNull String OCL_IN_ECORE_LANGUAGE_ID = OCLinEcorePlugin.LANGUAGE_ID;
	public static final @NonNull String OCL_STDLIB_LANGUAGE_ID = OCLstdlibPlugin.LANGUAGE_ID;

	/**
	 * Return a new Xtext RuntimeModule for the specified OCL grammar, or return null if the grammar is unknown.
	 */
	public static @Nullable Module getRuntimeModule(@NonNull String grammar) {
		if (COMPLETE_OCL_LANGUAGE_ID.equals(grammar)) {
			return new CompleteOCLRuntimeModule();
		}
		else if (ESSENTIAL_OCL_LANGUAGE_ID.equals(grammar)) {
			return new EssentialOCLRuntimeModule();
		}
		else if (OCL_IN_ECORE_LANGUAGE_ID.equals(grammar)) {
			return new OCLinEcoreRuntimeModule();
		}
		else if (OCL_STDLIB_LANGUAGE_ID.equals(grammar)) {
			return new OCLstdlibRuntimeModule();
		}
		return null;
	}

	/**
	 * Return a new Xtext UiModule for use with a uiPlugin on the specified OCL grammar, or return null if the grammar is unknown.
	 */
	public static @Nullable Module getUiModule(@NonNull AbstractUIPlugin uiPlugin, @NonNull String grammar) {
		if (COMPLETE_OCL_LANGUAGE_ID.equals(grammar)) {
			return new CompleteOCLUiModule(uiPlugin);
		}
		else if (ESSENTIAL_OCL_LANGUAGE_ID.equals(grammar)) {
			return new EssentialOCLUiModule(uiPlugin);
		}
		else if (OCL_IN_ECORE_LANGUAGE_ID.equals(grammar)) {
			return new OCLinEcoreUiModule(uiPlugin);
		}
		else if (OCL_STDLIB_LANGUAGE_ID.equals(grammar)) {
			return new OCLstdlibUiModule(uiPlugin);
		}
		return null;
	}

	/**
	 * this method comes from the org.eclipse.ocl.examples.xtext.console.OCLConsolePage written by
	 *
	 * @param contextObject
	 * @return the metamodelManager
	 */
	protected MetamodelManager getMetamodelManager(EObject contextObject) {
		MetamodelManager metamodelManager = PivotUtilInternal.findMetamodelManager(contextObject);
		if (metamodelManager != null) {
			return metamodelManager;
		}
		if (metamodelManager == null) {
			metamodelManager = new PivotEnvironmentFactory(null, null).getMetamodelManager();
		}
		return metamodelManager;
	}

	/**
	 * Evaluate an oclExpression using selfObject as the OCL self object. Returns a boxed value.
	 */
	public static Object evaluate(@Nullable EObject selfObject, @NonNull String oclExpression) throws Exception {
		MetamodelManager metamodelManager = PivotUtilInternal.findMetamodelManager(selfObject);
		if (metamodelManager == null) {
			metamodelManager = new PivotEnvironmentFactory(null, null).getMetamodelManager();
			// FIXME install
		}
		EnvironmentFactoryInternal envFactory = metamodelManager.getEnvironmentFactory();
		OCL ocl = OCL.newInstance(envFactory);
		OCLHelper oclHelper = ocl.createOCLHelper(selfObject);
		if (selfObject != null) {
			oclHelper.setContext(selfObject.eClass());
		}
		ExpressionInOCL createQuery = oclHelper.createQuery(oclExpression);
		return ocl.evaluate(selfObject, createQuery);
	}
	
	/**
	 * Configure a csResource to use eObject as its OCL self context.
	 */
	public static void setParserContext(@NonNull XtextResource csResource, EObject eObject) throws Exception {
		if (csResource instanceof CSResource) {
			PivotUtil.setParserContext((CSResource) csResource, eObject);
		}
	}
}
