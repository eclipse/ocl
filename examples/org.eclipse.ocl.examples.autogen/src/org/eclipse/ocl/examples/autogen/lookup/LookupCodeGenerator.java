/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (University of York) - Lookup Environment/Visitor
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.lookup;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * LookupCodeGenerator supports generation of the content of a JavaClassFile for the Lookup visitor.
 */
public class LookupCodeGenerator
{	
	public static void generate(@NonNull GenPackage genPackage,
			@Nullable GenPackage superGenPackage,
			@Nullable GenPackage baseGenPackage,
			@NonNull String projectName,
			@NonNull String lookupFilePath,
			@NonNull String lookupPackageName, 
			@Nullable String superLookupPackageName, 
			@Nullable String baseLookupPackage) {
		EPackage ePackage = genPackage.getEcorePackage();
		assert ePackage != null;

		Resource eResource = ClassUtil.nonNullState(ePackage.eResource());
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(eResource);
		
		List<org.eclipse.ocl.pivot.@NonNull Package> targetPackages = LookupCGUtil.getTargetPackages(genPackage,environmentFactory, lookupFilePath, projectName);
		for (org.eclipse.ocl.pivot.Package oclDocPackage : targetPackages){
			org.eclipse.ocl.pivot.Package asSuperPackage = null;
			if (superGenPackage != null) {
				String superProjectPrefix = superGenPackage.getPrefix();
				asSuperPackage = LookupCGUtil.getPackage(genPackage, superProjectPrefix, environmentFactory);
				if (asSuperPackage == null) {
					throw new IllegalStateException("No super-GenPackage found in UsedGenPackages for " + superProjectPrefix);
				}
			}
			org.eclipse.ocl.pivot.Package basePackage = asSuperPackage == null ? oclDocPackage : asSuperPackage;
			if (baseGenPackage != null) {
				String baseProjectPrefix = baseGenPackage.getPrefix();
				basePackage = LookupCGUtil.getPackage(genPackage, baseProjectPrefix, environmentFactory);
				if (basePackage == null) {
					throw new IllegalStateException("No super-GenPackage found in UsedGenPackages for " + baseProjectPrefix);
				}
			}
			
			new LookupUnqualifiedCodeGenerator(environmentFactory, oclDocPackage, asSuperPackage, basePackage, 
				genPackage,superGenPackage, baseGenPackage).saveSourceFile();
			new LookupQualifiedCodeGenerator(environmentFactory, oclDocPackage, asSuperPackage, basePackage, 
				genPackage,superGenPackage, baseGenPackage).saveSourceFile();
			new LookupExportedVisitorCodeGenerator(environmentFactory, oclDocPackage, asSuperPackage, basePackage, 
				genPackage,superGenPackage, baseGenPackage).saveSourceFile();
			new LookupFilterGenerator(environmentFactory, oclDocPackage, asSuperPackage, basePackage,
				genPackage,	superGenPackage, baseGenPackage,
				lookupPackageName, superLookupPackageName, baseLookupPackage).saveSourceFile();
		}
	}
}
