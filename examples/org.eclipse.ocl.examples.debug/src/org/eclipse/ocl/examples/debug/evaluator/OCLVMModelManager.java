/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.evaluator;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMModelManager;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * OCL Domain Manager is the class responsible for managing the OCL virtual
 * machine meta-models and models. 
 * A OCL Domain Manager object encapsulates the domain information need to 
 * modify the domains's models. 
 */
public class OCLVMModelManager extends VMModelManager
{
	/**
	 * The types upon which execution of the transformation may invoke allInstances().
	 */
//	private @NonNull Set<Type> allInstancesTypes;
	
	/**
	 * Instantiates a new OCL Domain Manager. Responsible for creating new
	 * instances of the middle model and the middle model EFactory.
	 */
	public OCLVMModelManager(@NonNull MetamodelManager metamodelManager) {
	    super(metamodelManager);
//	    this.allInstancesTypes = transformationAnalysis.getAllInstancesTypes();
	}

	/**
	 * Dispose.
	 */
	public void dispose() {
//		allInstancesTypes.clear();
	}

	public @NonNull Set<EObject> get(@NonNull org.eclipse.ocl.pivot.Class type) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Implemented by subclasses to determine whether the specified element
	 * is an instance of the specified class, according to the metamodel
	 * semantics implemented by the environment that created this extent map.
	 *
	 * @param requiredType the type
	 * @param eObject a potential run-time (M0) instance of that class
	 * @return <code>true</code> if this element is an instance of the given
	 * class; <code>false</code> otherwise
	 */
	protected boolean isInstance(@NonNull Type requiredType, @NonNull EObject eObject) {
		EClass eClass = eObject.eClass();
		EPackage ePackage = eClass.getEPackage();
		Type objectType = null;
		if (ePackage == PivotPackage.eINSTANCE) {
			String name = ClassUtil.nonNullEMF(eClass.getName());
			objectType = metamodelManager.getASClass(name);
		}
		else {
			try {
				objectType = metamodelManager.getASOf(Type.class,  eClass);
			} catch (ParserException e) {
// FIXME				if (!generatedErrorMessage) {
//					generatedErrorMessage = true;
//					logger.error("Failed to load an '" + eClass.getName() + "'", e);
//				}
			}
		}
	    return (objectType != null) && objectType.conformsTo(metamodelManager.getStandardLibrary(), requiredType);
	}
}
