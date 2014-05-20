/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.types.IdResolver;

public abstract class AbstractTransformation
{
	protected final @NonNull DomainEvaluator evaluator;
	protected final @NonNull IdResolver idResolver;
	protected final @NonNull List<EObject>[] modelObjects;
	protected final @NonNull Map<String, Integer> modelIndexes = new HashMap<String, Integer>();
	
	protected AbstractTransformation(@NonNull DomainEvaluator evaluator, @NonNull String[] modelNames) {
		this.evaluator = evaluator;
		this.idResolver = evaluator.getIdResolver();
		@SuppressWarnings("unchecked")List<EObject>[] modelObjects = (List<EObject>[]) new List<?>[modelNames.length];
		this.modelObjects = modelObjects;
		for (int i = 0; i < modelNames.length; i++) {
			modelObjects[i] = new ArrayList<EObject>();
			modelIndexes.put(modelNames[i],  i);
		}
	}

    /**
     * Add eRootObjects to the modelIndex model.
     */
    public void addRootObjects(@NonNull String modelName, @NonNull List<? extends EObject> eRootObjects) {
    	Integer modelIndex = modelIndexes.get(modelName);
    	if (modelIndex == null) {
    		throw new IllegalStateException("Unknown model name '" + modelName + "'");
    	}
    	List<EObject> eObjects = modelObjects[modelIndex];
    	for (EObject eObject : eRootObjects) {
    		if (!eObjects.contains(eObject)) {
    			eObjects.add(eObject);
    		}
    	}
	}

    /**
     * Return all objects in the modelIndex model that conform to eClass.
     */
    protected @NonNull <T extends EObject> List<T> getObjectsByType(@NonNull Class<T> javaClass, int modelIndex, @NonNull EClass eClass) {
    	List<EObject> eRootObjects = modelObjects[modelIndex];
    	List<T> eObjects = new ArrayList<T>();
    	for (EObject eRootObject : eRootObjects) {
    		if (eClass.isInstance(eRootObject)) {
    			@SuppressWarnings("unchecked") T eObject2 = (T)eRootObject;
				eObjects.add(eObject2);
    		}
        	for (TreeIterator<EObject> tit = eRootObject.eAllContents(); tit.hasNext(); ) {
        		@SuppressWarnings("null")@NonNull EObject eObject = tit.next();
	    		if (eClass.isInstance(eObject)) {
	    			@SuppressWarnings("unchecked") T eObject2 = (T)eObject;
					eObjects.add(eObject2);
	    		}
        	}
    	}
		return eObjects;
	}

    /**
     * Return all the containerless objects in the modelName model.
     */
    public @NonNull List<EObject> getRootObjects(@NonNull String modelName) {
    	Integer modelIndex = modelIndexes.get(modelName);
    	if (modelIndex == null) {
    		throw new IllegalStateException("Unknown model name '" + modelName + "'");
    	}
    	List<EObject> eObjects = modelObjects[modelIndex];
    	List<EObject> eRootObjects = new ArrayList<EObject>(eObjects.size());
    	for (EObject eObject : eObjects) {
    		if (eObject.eContainer() == null) {
    			eRootObjects.add(eObject);
    		}
    	}
		return eRootObjects;
	}

    public abstract boolean run() throws Exception;
}
