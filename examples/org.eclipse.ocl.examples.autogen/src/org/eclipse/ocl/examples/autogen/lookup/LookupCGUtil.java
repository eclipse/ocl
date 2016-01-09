package org.eclipse.ocl.examples.autogen.lookup;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModel;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.OCL;

public class LookupCGUtil {

	
	
	public static List<@NonNull Package> getTargetPackages(GenPackage genPackage, EnvironmentFactory envFact, String oclDocFilePath, String oclDocProjectName, String projectPrefix) {
		
		List<@NonNull Package> result = new ArrayList<@NonNull Package>();
		URI projectResourceURI = URI.createPlatformResourceURI("/" + oclDocProjectName + "/", true);
		@SuppressWarnings("null")@NonNull URI nameResoURI = URI.createURI(oclDocFilePath).resolve(projectResourceURI);
		OCL ocl = envFact.createOCL();
		try {
			Resource resource = ClassUtil.nonNullState(ocl.parse(nameResoURI));
			for (EObject root : resource.getContents()) {
				if (root instanceof Model) {
					Package asPackage = ClassUtil.nonNullState(getPackage(genPackage, projectPrefix, envFact));
					for (@SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Package oclDocPackage : ((Model)root).getOwnedPackages()) {
						if (samePrimaryPackage(oclDocPackage, asPackage, envFact)) { 
							if (samePrimaryPackage(oclDocPackage, asPackage, envFact)) { 
								result.add(oclDocPackage);
							}
						}
					}
				}
			}
		} finally {
			ocl.dispose();
		}
		return result;
	}

	public static org.eclipse.ocl.pivot.@Nullable Package getPackage(GenPackage genPackage, String packageName, EnvironmentFactory envFactory) {
		MetamodelManager metaModelManager = envFactory.getMetamodelManager();
		for (GenPackage gPackage : genPackage.getGenModel().getAllGenAndUsedGenPackagesWithClassifiers()) {
			String name = gPackage.getPrefix();
			if (name.startsWith(packageName)) { // FIXME startsWith ? Make this more robust
				EPackage eSuperPackage = gPackage.getEcorePackage();
				return metaModelManager.getASOfEcore(org.eclipse.ocl.pivot.Package.class, eSuperPackage);
			}
		}
		return null;
	}
	
	private static boolean samePrimaryPackage(org.eclipse.ocl.pivot.@NonNull Package p1, org.eclipse.ocl.pivot.@NonNull Package p2, @NonNull EnvironmentFactory envFactory) {
		MetamodelManager mm = envFactory.getMetamodelManager();
		CompletePackage completePackage1 = mm.getCompleteModel().getCompletePackage(p1);
		CompletePackage completePackage2 = mm.getCompleteModel().getCompletePackage(p2);
		org.eclipse.ocl.pivot.@NonNull Package primaryPackage1 = mm.getPrimaryPackage(p1);
		org.eclipse.ocl.pivot.@NonNull Package primaryPackage2 = mm.getPrimaryPackage(p2);
		return primaryPackage1.equals(primaryPackage2);
	}
	
	
	public static boolean isCommonVisitorClass(@NonNull CGClass cgClass) {
		return cgClass.getName().contains("Common"); // FIXME more robust check ?
	}
	
	public static boolean isUnqualifiedVisitorClass(@NonNull CGClass cgClass) {
		return cgClass.getName().contains("Unqualified"); // FIXME more robust check ?
	}
	
	public static boolean isExportedVisitorClass(@NonNull CGClass cgClass) {
		return cgClass.getName().contains("Exported"); // FIXME more robust check ?
	}
	
	/**
	 * A derived visitor class will considered as such, if it's not the commom visitor class
	 * or it doesn't extend it
	 * 
	 * @param cgClass
	 * @return true if this cgClass corresponds to derived visitor class generation
	 */
	@SuppressWarnings("null")
	public static boolean isDeriverdVisitorClass(@NonNull CGClass cgClass) {
		
		if (isCommonVisitorClass(cgClass)) {
			return false;
		}
		for (CGClass superClass : cgClass.getSuperTypes()) {
			if (isCommonVisitorClass(superClass)) {
				return false;
			}
		}
		return true;
	}
	
	public static CGClass getCommonVisitorClass(@NonNull CGClass cgClass, @NonNull  String commonVisitorClassName) {
		
		CGModel cgModel = (CGModel) cgClass.getContainingPackage().eContainer();
		for (CGPackage cgPackg: cgModel.getPackages()) {
			CGClass cgCommonClass = NameUtil.getNameable(cgPackg.getClasses(), commonVisitorClassName);
			if (cgCommonClass != null) {
				return cgCommonClass;
			}
		}
		return null;
	}
}
