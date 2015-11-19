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
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.OCL;

public class LookupCGUtil {

	
	
	public static List<Package> getTargetPackages(GenPackage genPackage, EnvironmentFactory envFact, String oclDocFilePath, String oclDocProjectName, String projectPrefix) {
		
		List<Package> result = new ArrayList<Package>();
		URI projectResourceURI = URI.createPlatformResourceURI("/" + oclDocProjectName + "/", true);
		@SuppressWarnings("null")@NonNull URI nameResoURI = URI.createURI(oclDocFilePath).resolve(projectResourceURI);
		OCL ocl = envFact.createOCL();
		try {
			Resource resource = ClassUtil.nonNullState(ocl.parse(nameResoURI));
			for (EObject root : resource.getContents()) {
				if (root instanceof Model) {
					Package asPackage = ClassUtil.nonNullState(getPackage(genPackage, projectPrefix, envFact));
					for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.pivot.Package oclDocPackage : ((Model)root).getOwnedPackages()) {
						if (samePrimaryPackage(oclDocPackage, asPackage, envFact)) { 
							result.add(oclDocPackage);
						}
					}
				}
			}
		} finally {
			ocl.dispose();
		}
		return result;
	}
						
	@Nullable
	public static org.eclipse.ocl.pivot.Package getPackage(GenPackage genPackage, String packageName, EnvironmentFactory envFactory) {
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
	
	private static boolean samePrimaryPackage(@NonNull org.eclipse.ocl.pivot.Package p1, @NonNull org.eclipse.ocl.pivot.Package p2, @NonNull EnvironmentFactory envFactory) {
		MetamodelManager mm = envFactory.getMetamodelManager();
		return mm.getPrimaryPackage(p1).equals(mm.getPrimaryPackage(p2));
	}
}
