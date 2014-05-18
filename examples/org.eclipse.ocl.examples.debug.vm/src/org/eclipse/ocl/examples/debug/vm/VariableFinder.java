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
package org.eclipse.ocl.examples.debug.vm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.data.VMTypeData;
import org.eclipse.ocl.examples.debug.vm.data.VMValueData;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.request.VMVariableRequest;
import org.eclipse.ocl.examples.debug.vm.response.VMResponse;
import org.eclipse.ocl.examples.debug.vm.response.VMVariableResponse;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;

public class VariableFinder
{
	public static @Nullable String computeDetail(@NonNull URI variableURI, @NonNull IVMEvaluationEnvironment<?> fEvalEnv) {
		VariableFinder finder = new VariableFinder(fEvalEnv, false);
		String[] variablePath = getVariablePath(variableURI);
		Object valueObject = finder.findStackObject(variablePath);
		
		if(valueObject != null) {
			try {
				return valueObject.toString();
			} catch(RuntimeException e) {
				// do nothing, empty detail will be returned
			}
		}
		return null;
	}

	public static @NonNull URI createURI(@NonNull String[] varPath) {
		return createURI(varPath, varPath.length - 1);
	}
	
	public static @NonNull URI createURI(@NonNull String[] varPath, int endIndex) {
		String[] segments = new String[endIndex + 1];
		for (int i = 0; i < segments.length; i++) {
			segments[i] =  URI.encodeSegment(varPath[i], true);
		}
		@SuppressWarnings("null") @NonNull URI hierarchicalURI = URI.createHierarchicalURI(segments, null, null);
		return hierarchicalURI;
	}
	
	public static @NonNull List<EStructuralFeature> getAllFeatures(@NonNull EClass eClass) {
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.addAll(eClass.getEAllStructuralFeatures());
/* 		if (eClass instanceof Root) {
			for (Iterator<EStructuralFeature> it = features.iterator(); it.hasNext();) {
				EStructuralFeature feature = it.next();
				if(feature instanceof ContextualProperty) {
					it.remove();
				}
			}
		}
		collectIntermediateProperties(features, eClass); */
		Collections.sort(features, new Comparator<EStructuralFeature>() {
			public int compare(EStructuralFeature var1, EStructuralFeature var2) {
				String n1 = var1.getName();
				String n2 = var2.getName();
				if (n1 == null) n1 = "";
				if (n2 == null) n2 = "";
				return n1.compareTo(n2);
			}
		});
		return features;
	}
	
	private static @NonNull String getOCLType(@NonNull EStructuralFeature feature) {
		return getOCLType(feature.getEType(), feature.isUnique(), feature.isOrdered(), feature.getLowerBound(), feature.getUpperBound());
	}
	
	private static @NonNull String getOCLType(@Nullable EClassifier eType, boolean isUnique, boolean isOrdered, int lowerBound, int upperBound) {
		StringBuilder s = new StringBuilder();
		if (eType == null) {
			s.append("null");
		}
		else if (upperBound != 1) {
			if (isUnique) {
				s.append(isOrdered ? "OrderedSet" : "Set");
			}
			else {
				s.append(isOrdered ? "Sequence" : "Bag");
			}
			s.append("(");
			s.append(eType.getName());
			DomainUtil.formatMultiplicity(s, lowerBound, upperBound);
			s.append(")");
		}
		else {
			s.append(eType.getName());
		}
		@SuppressWarnings("null")@NonNull String string = s.toString();
		return string;
	}

	public static String getRootVarName(URI variableURI) {
		if (variableURI.segmentCount() == 0) {
			throw new IllegalArgumentException();
		}
		return URI.decode(variableURI.segment(0));
	}

	public static @NonNull List<VMVariableData> getVariables(@NonNull IVMEvaluationEnvironment<?> evalEnv) {
		List<VMVariableData> result = new ArrayList<VMVariableData>();

		for (DomainTypedElement variable : evalEnv.getVariables()) {
			String varName = variable.getName();
			if (variable instanceof OCLExpression) {
				OCLExpression oclExpression = (OCLExpression) variable;
				EStructuralFeature eContainingFeature = oclExpression.eContainingFeature();
				if (eContainingFeature != null) {
					varName = "$" + eContainingFeature.getName();
					if (eContainingFeature.isMany()) {
						EObject eContainer = oclExpression.eContainer();
						if (eContainer != null) {
							Object eGet = eContainer.eGet(eContainingFeature);
							if (eGet instanceof List<?>) {
								int index = ((List<?>)eGet).indexOf(oclExpression);
								varName = varName + "[" + index + "]";
							}
						}
					}
					if (varName != null) {
						VMVariableData var = new VMVariableData(varName, null);
						var.kind = VMVariableData.LOCAL;
						Object value = null;
						try {
							value = evalEnv.getValueOf(oclExpression);
						}
						catch (Throwable e) {
							value = e;
						}
						DomainType declaredType = oclExpression.getType();
						setValueAndType(var, value, declaredType, evalEnv);
						result.add(var);
					}
				}
			}
			else if (varName != null) {
				VMVariableData var = new VMVariableData(varName, null);
				if (isPredefinedVar(varName, evalEnv)) {
					var.kind = VMVariableData.PREDEFINED_VAR;
				}
				Object value = null;
				try {
					value = evalEnv.getValueOf(variable);
				}
				catch (Throwable e) {
					value = e;
				}
				DomainType declaredType = variable.getType();
				setValueAndType(var, value, declaredType, evalEnv);
				result.add(var);
			}
		}
		
		Map<String, Resource> modelParameterVariables = evalEnv.getModelParameterVariables();
		for (String modelParam : modelParameterVariables.keySet()) {
			if (modelParam != null) {
				Resource model = modelParameterVariables.get(modelParam);
				VMVariableData var = new VMVariableData(modelParam, null);
				setValueAndType(var, model, model != null ? model.getURI().toString() : "$middle$", evalEnv);
				var.kind = VMVariableData.MODEL_PARAMETER; 
				
				result.add(var);
			}
		}
		return result;
	}
	
	private static boolean isPredefinedVar(String name, @NonNull IVMEvaluationEnvironment<?> evalEnv) {
		if(("self".equals(name) || "result".equals(name)) && evalEnv.getOperation() != null) {
			return true;
		}
		return "this".equals(name);
	}

	public static @NonNull String[] getVariablePath(@NonNull URI variableURI) {
		String[] ids = new String[variableURI.segmentCount()];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = URI.decode(variableURI.segment(i));
		}
		return ids;
	}

	@SuppressWarnings("null")
	public static @NonNull URI parseURI(String variableURI) throws IllegalArgumentException {
		return URI.createURI(variableURI);
	}
	
	public static VMResponse process(@NonNull VMVariableRequest request, @NonNull List<UnitLocation> stack, @NonNull IVMEvaluationEnvironment<?> fEvalEnv) {
		
		UnitLocation location = VMVirtualMachine.lookupEnvironmentByID(request.frameID, stack);
		if (location == null) {
			return VMResponse.createERROR();
		}

		String variableURIStr = request.variableURI;
		URI variableURI = parseURI(variableURIStr);

		String[] variablePath = getVariablePath(variableURI);

		VariableFinder variableManager = new VariableFinder(fEvalEnv, false);
		
		List<VMVariableData> variables = new ArrayList<VMVariableData>();
		variableManager.find(variablePath, request.includeChildVars, variables);

		if (variables.isEmpty()) {
			return VMResponse.createERROR();
		}

		VMVariableData[] children = null;
		int size = variables.size();
		if (size > 1) {
			children = variables.subList(1, size).toArray(new VMVariableData[size - 1]);
		}
		VMVariableData variable0 = variables.get(0);
		return variable0 != null ? new VMVariableResponse(variable0, children) : null;
	}
	
	private static EClass selectEClass(EClass eClass, int index) {
		if(index > 0) {
			EList<EClass> superClasses = eClass.getEAllSuperTypes();
			if(index < superClasses.size()) {
				return superClasses.get(index);
			}
		}
		
		return eClass;
	}

	public static void setValueAndType(@NonNull VMVariableData variable, @Nullable Object value, @Nullable DomainType optDeclaredType, @NonNull EvaluationEnvironment evalEnv) {
		String declaredTypeName = (optDeclaredType != null) ? optDeclaredType.toString() : null;
		setValueAndType(variable, value, declaredTypeName, evalEnv);
	}

	public static void setValueAndType(@NonNull VMVariableData variable, @Nullable Object value, @Nullable EClassifier optDeclaredType, @NonNull EvaluationEnvironment evalEnv) {
		String declaredTypeName = (optDeclaredType != null) ? optDeclaredType.getName() : null;
		setValueAndType(variable, value, declaredTypeName, evalEnv);
	}

	public static void setValueAndType(@NonNull VMVariableData variable, @Nullable Object value, @Nullable String declaredTypeName, @NonNull EvaluationEnvironment evalEnv) {
		VMValueData vmValue;
		VMTypeData vmType;
		if (value == null) {
			vmType = new VMTypeData(VMTypeData.DATATYPE, "OclVoid", declaredTypeName); //$NON-NLS-1$
			vmValue = null;
		} else if (value instanceof InvalidValueException) {
			vmValue = new VMValueData(VMValueData.INVALID, "invalid - " + ((InvalidValueException)value).getMessage());
			vmType = new VMTypeData(VMTypeData.DATATYPE, "OclInvalid", declaredTypeName); //$NON-NLS-1$
		} else if (value instanceof Resource) {
			Resource resource = (Resource) value;
//			EClass eClass = eObject.eClass();
			@SuppressWarnings("null")@NonNull String strVal = String.valueOf(resource.getURI());
			vmValue = new VMValueData(VMValueData.RESOURCE, strVal, true);
			@SuppressWarnings("null")@NonNull String className = resource.getClass().getSimpleName();
			vmType = new VMTypeData(VMTypeData.EOBJECT, className, declaredTypeName);
		} else if (value instanceof EObject) {
			EObject eObject = (EObject) value;
			EClass eClass = eObject.eClass();
			String strVal = eClass.getEPackage().getName() + "::" + eClass.getName() + " @" + Integer.toHexString(System.identityHashCode(value));
			boolean hasVariables = !eClass.getEAllStructuralFeatures().isEmpty() || value instanceof Resource;
			vmValue = new VMValueData(VMValueData.OBJECT_REF, strVal, hasVariables);
			@SuppressWarnings("null")@NonNull String className = eClass.getName();
			vmType = new VMTypeData(VMTypeData.EOBJECT, className, declaredTypeName);
		} else if (value instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) value;
			Class<?> javaType = value.getClass();

			StringBuilder strVal = new StringBuilder();
			if (declaredTypeName != null) {
				strVal.append(declaredTypeName);
			} else {
				strVal.append(javaType.getSimpleName());
			}

			strVal.append('[').append(collection.size()).append(']');
			@SuppressWarnings("null")@NonNull String string = strVal.toString();
			vmValue = new VMValueData(VMValueData.COLLECTION_REF, string, !collection.isEmpty());
			// TODO - use mapping by runtime class to OCL type
			@SuppressWarnings("null")@NonNull String className = javaType.getSimpleName();
			vmType = new VMTypeData(VMTypeData.COLLECTION, className, declaredTypeName);
			
		} else {
			// everything else we see as a data type
			@SuppressWarnings("null")@NonNull String valueOf = String.valueOf(value);
			if (value.getClass().equals(String.class)) {
				valueOf = "'" + valueOf + "'";
			}
			vmValue = new VMValueData(VMValueData.PRIMITIVE, valueOf);
			@SuppressWarnings("null")@NonNull String className = value.getClass().getSimpleName();
			vmType = new VMTypeData(VMTypeData.DATATYPE, className, declaredTypeName);
		}
		variable.type = vmType;
		variable.value = vmValue;
	}

	private final @NonNull IVMEvaluationEnvironment<?> fEvalEnv;
	private final boolean fIsStoreValues;
	private @Nullable VMVariableData fTargetVar;
	private @Nullable String fRootDeclaredType;

	public VariableFinder(@NonNull IVMEvaluationEnvironment<?> fEvalEnv, boolean isStoreValues) {
		this.fEvalEnv = fEvalEnv;
		fIsStoreValues = isStoreValues;
	}
	
	public void collectChildVars(Object root, @NonNull String[] parentPath, @Nullable String containerType, @NonNull List<VMVariableData> result) {
		String childPath[] = new String[parentPath.length + 1];
		System.arraycopy(parentPath, 0, childPath, 0, parentPath.length);
		
		if (root instanceof Resource) {
			Resource model = (Resource) root;
			root = model.getContents();
			containerType = "(EClassifier)EcoreEnvironmentFactory.INSTANCE.createEnvironment().getOCLFactory().createSetType(QvtOperationalStdLibrary.INSTANCE.getElementType())";
		}
		
		if (root instanceof EObject) {
			EObject eObject = (EObject) root;
			@SuppressWarnings("null")@NonNull EClass eClass = eObject.eClass();

			StringBuilder uriBuf = new StringBuilder();			
			List<EStructuralFeature> eAllFeatures = getAllFeatures(eClass);
			
			List<EClass> superClasses = eClass.getEAllSuperTypes();
			for (EStructuralFeature feature : eAllFeatures) {		
				EClass owner;
				
//				if(feature.eClass() == ExpressionsPackage.eINSTANCE.getContextualProperty()) {
//					ContextualProperty ctxProperty = (ContextualProperty) feature;
//					owner = ctxProperty.getContext();
					
//					uriBuf.append('+');//.append(intermPropIndex++);
//				} else {
					owner = feature.getEContainingClass();
//				}
							
				int index = superClasses.indexOf(owner);
				uriBuf.append(index < 0 ? 0 : index);
				uriBuf.append('.').append(feature.getName());
				
				childPath[childPath.length - 1] = uriBuf.toString();
				VMVariableData elementVar = createFeatureVar(feature, getValue(feature, eObject), createURI(childPath).toString());
				result.add(elementVar);
				
				uriBuf.setLength(0);
			}
		} else if(root instanceof Collection<?>) {
			Collection<?> elements = (Collection<?>) root;
			String elementType = "(containerType instanceof CollectionType) ? ((CollectionType) containerType) .getElementType() : fFeatureAccessor.getStandardLibrary().getOclAny()";
									
//			Dictionary<Object, Object> asDictionary = null;
//			if(root instanceof Dictionary<?, ?>) {
//				@SuppressWarnings("unchecked")
//				Dictionary<Object, Object> dict = (Dictionary<Object, Object>) root;
//				asDictionary = dict;
//				elements = asDictionary.keys();
//			}			
			
			int i = 0;
			for (Object element : elements) {
				childPath[childPath.length - 1] = String.valueOf(i);
				VMVariableData elementVar;
//				if(asDictionary == null) {
					elementVar = createCollectionElementVar(i, element, elementType, createURI(childPath).toString());
//				} else {
//					Object key = element;
//					Object value = asDictionary.get(element);
//					elementVar = createDictionaryElementVar(key, value, elementType, createURI(childPath).toString());
//				}
				result.add(elementVar);
				i++;
			}
		}
	}
	
	private @NonNull VMVariableData createCollectionElementVar(int elementIndex, Object element, @Nullable String elementType, String uri) {
		String varName = "[" + elementIndex + "]"; //$NON-NLS-1$ //$NON-NLS-2$
		int kind = VMVariableData.COLLECTION_ELEMENT;
		return createVariable(varName, kind, elementType, element, uri);
	}
	
/*	private VMVariable createDictionaryElementVar(Object key, Object value, @Nullable String elementType, String uri) {
		String varName = String.valueOf(key);
		int kind = VMVariable.COLLECTION_ELEMENT;
		return createVariable(varName, kind, elementType, value, uri);
	} */
	
	private @NonNull VMVariableData createFeatureVar(@NonNull EStructuralFeature feature, Object value, String uri) {
		String varName = DomainUtil.nonNullModel(feature.getName());
		String declaredType = getOCLType(feature);
		
		int kind = VMVariableData.ATTRIBUTE;
		if (feature instanceof EReference) {
			kind = VMVariableData.REFERENCE;
		}
//		if (feature instanceof ContextualProperty) {
//			kind = VMVariable.INTERM_PROPERTY;
//		}
		
		return createVariable(varName, kind, declaredType, value, uri);
	}

	private @NonNull VMVariableData createVariable(@NonNull String varName, int kind, @Nullable String declaredType, Object varObj, String uri) {
		VMVariableData result = new VMVariableData(varName, uri);
		result.kind = kind;
		setValueAndType(result, varObj, declaredType, fEvalEnv);
		if (fIsStoreValues) {
			result.valueObject = varObj;
		}
		return result;
	}

	public void find(@NonNull String[] objectPath, boolean fetchChildVariables, @NonNull List<VMVariableData> result) {
		if (result.contains(null)) {
			throw new IllegalArgumentException("null result variables"); //$NON-NLS-1$
		}
		try {	
			Object referencedObj = findStackObject(objectPath);
			VMVariableData variable = fTargetVar;

			if (variable != null) {
				result.add(variable);

				if (fetchChildVariables) {
					collectChildVars(referencedObj, objectPath, fRootDeclaredType, result);
				}
			}
		} finally {
			fTargetVar = null;
		}
	}

	private Object findChildObject(Object parentObj, @Nullable String optParentDeclaredType, @NonNull String[] varTreePath, int pathIndex) {
		URI uri = createURI(varTreePath, pathIndex);
		// FIXME - deduce the type from actual type, ensure null is not propagated
		
		VMVariableData childVar = null;
		Object nextObject = null;
		String nextDeclaredType = null;
		
		if (parentObj instanceof Resource) {
			parentObj = ((Resource)parentObj).getContents();
			nextDeclaredType = "QvtOperationalStdLibrary.INSTANCE.getElementType()";
		}
		
		if (parentObj instanceof EObject) {
			EObject eObject = (EObject) parentObj;
			EStructuralFeature eFeature = findFeature(DomainUtil.nonNullState(varTreePath[pathIndex]), eObject.eClass());
			if (eFeature != null) {
				Object value = getValue(eFeature, eObject);
				childVar = createFeatureVar(eFeature, value, uri.toString());
				nextObject = value;
				nextDeclaredType = getOCLType(eFeature);
			}
			
		} else if (parentObj instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) parentObj;
			int elementIndex = -1;
			try {
				elementIndex = Integer.parseInt(varTreePath[pathIndex]);
			} catch(NumberFormatException e) {
				// FIXME 
				throw new IllegalArgumentException();
			}
			
			if (elementIndex < 0 || elementIndex >= collection.size()) {
				// not valid element position in this collection
				throw new IllegalArgumentException();
			}
						
//			if (optParentDeclaredType instanceof CollectionType) {
//				CollectionType type = (CollectionType) optParentDeclaredType;
//				nextDeclaredType = "type.getElementType()";
//			} else if(nextDeclaredType == null) {
				// FIXME
				nextDeclaredType = "OclAny";
//			}

			Object element = getElement(collection, elementIndex);
			
			childVar = createCollectionElementVar(elementIndex, element, nextDeclaredType, uri.toString());
			nextObject = element;
		}

		int nextIndex = pathIndex + 1;
		if (nextIndex < varTreePath.length) {
			if (nextObject != null) {
				// continue navigation in the hierarchy
				return findChildObject(nextObject, nextDeclaredType, varTreePath, nextIndex);
			} else {
				// we can't navigate further via the path due to <null> termination object
				return null;
			}
		}

		this.fTargetVar = childVar;		
		return nextObject;
	}
	
	private @Nullable Object findStackObject(@NonNull String[] varTreePath) {
		String envVarName = DomainUtil.nonNullState(varTreePath[0]);
		Set<DomainTypedElement> variables = new HashSet<DomainTypedElement>();
		for (IVMEvaluationEnvironment<?> evalEnv = fEvalEnv; evalEnv != null; evalEnv = evalEnv.getParentEvaluationEnvironment()) {
			Set<DomainTypedElement> localVariables = evalEnv.getVariables();
			variables.addAll(localVariables);
			if (DomainUtil.getNamedElement(localVariables, "self") != null) {
				break;
			}
		}
		Object rootObj = DomainUtil.getNamedElement(variables, envVarName);
		if (rootObj instanceof Variable) {
			rootObj = fEvalEnv.getValueOf((DomainTypedElement)rootObj);
		}
		if (rootObj == null) { //&& !evalEnv.getNames().contains(envVarName)) {
			rootObj = fEvalEnv.getModelParameterVariables().get(envVarName);
			
		}
		fRootDeclaredType = rootObj instanceof EObject ? ((EObject)rootObj).eClass().getName() : "evalEnv.getTypeOf(envVarName)";
		if(rootObj != null && varTreePath.length == 1) {
			// refers to environment variable only
			String[] uri = new String[] { envVarName };
			fTargetVar = createVariable(envVarName, VMVariableData.LOCAL, fRootDeclaredType, rootObj, createURI(uri).toString());
			return rootObj;
		}
		
		if(rootObj == null) {
			// can't navigate further via <null> object
			return null;
		}

		// navigate from the root object using the remaining variable path
		return findChildObject(rootObj, fRootDeclaredType, varTreePath, 1); 
	}

	private @Nullable Object getElement(@NonNull Collection<?> collection, int index) {
		if (collection instanceof EList<?>) {
			EList<?> eList = (EList<?>) collection;
			return eList.get(index);
		}

		int curr = 0;
		for (Iterator<?> it = collection.iterator(); it.hasNext();) {
			Object object = it.next();
			if (curr++ == index) {
				return object;
			}
		}
		return null;
	}

	private @Nullable EStructuralFeature findFeature(@NonNull String featureRef, EClass actualTarget) {
		String actualRef = featureRef.startsWith("+") ? featureRef.substring(1) : featureRef;
		boolean isIntermediate = featureRef.length() != actualRef.length();
		
		int classIndex;
		String featureName;
		try {
			int delimiterPos = actualRef.indexOf('.');
			if(delimiterPos <= 0 || delimiterPos >= actualRef.length() - 1) {
				throw new IllegalArgumentException("navigatin feature: " + actualRef);
			}
			
 			classIndex = Integer.parseInt(actualRef.substring(0, delimiterPos));
 			featureName = actualRef.substring(delimiterPos + 1);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Illegal feature reference: " + featureRef);
		}
		
		EClass featureOwner = selectEClass(actualTarget, classIndex);
		if(featureOwner == null) {
			return null;
		}
		
		if(!isIntermediate) {
			return featureOwner.getEStructuralFeature(featureName);
		}
		
//		EClass contextualPropMetaClass = ExpressionsPackage.eINSTANCE.getContextualProperty();
		
//		for (EStructuralFeature feature : actualTarget.getEAllStructuralFeatures()) {					
//			if(feature.eClass() == contextualPropMetaClass && feature.equals(feature.getName())) {
//				return feature;
//			}
//		}
		
		return null;
	}

	public Object getValue(EStructuralFeature feature, EObject target) {
		return /*fEvalEnv*/navigateProperty(feature, null, target);
//		throw new UnsupportedOperationException();
	}

//	@Override
	public Object navigateProperty(EStructuralFeature property, List<?> qualifiers, Object target) throws IllegalArgumentException {
/*		if(target instanceof ModuleInstance) {
			ModuleInstance moduleTarget = (ModuleInstance) target;
			EClassifier owningClassifier = QvtOperationalStdLibrary.INSTANCE.getEnvironment().getUMLReflection().getOwningClassifier(property);			
			if (owningClassifier instanceof Module) {
				target = moduleTarget.getThisInstanceOf((Module) owningClassifier);
			}
			else {
				target = moduleTarget.getThisInstanceOf(moduleTarget.getModule());
			}
		} */

		EStructuralFeature resolvedProperty = property;		

//		if (property instanceof ContextualProperty) {
//			IntermediatePropertyModelAdapter.ShadowEntry shadow = IntermediatePropertyModelAdapter.getPropertyHolder(
//														property.getEContainingClass(), (ContextualProperty)property, target);
//			target = shadow.getPropertyRuntimeOwner(target, this);
//			resolvedProperty = shadow.getProperty();
//		}
		
		// FIXME - workaround for a issue of multiple typle type instances, possibly coming from 
		// imported modules. The super impl. looks for the property by feature instance, do it
		// by name here to avoid lookup failure, IllegalArgExc...
/*		if(target instanceof Tuple<?, ?>) {
			if (target instanceof EObject) {
	            EObject etarget = (EObject) target;
	            resolvedProperty = etarget.eClass().getEStructuralFeature(property.getName());
	            if(resolvedProperty == null) { 
	            	return null;
	            }
			}
			else {
				resolvedProperty = null;
				for (EStructuralFeature feature : ((Tuple<EOperation, EStructuralFeature>) target).getTupleType().oclProperties()) {
					if (property.getName().equals(feature.getName())) {
						resolvedProperty = feature;
						break;
					}
				}
	            if(resolvedProperty == null) { 
	            	return null;
	            }
			}
		}
		else if(property.getEType() instanceof CollectionType<?, ?> && target instanceof EObject) {
			// module property of direct OCL collection type => override the super impl which coerce the result value 
			// and takes only the first element and returns from navigate call
            EObject eTarget = (EObject) target;
            if (eTarget.eClass().getEAllStructuralFeatures().contains(resolvedProperty)) {
                return eTarget.eGet(resolvedProperty, true);
            }
		} */
		
		try {
			return superNavigateProperty(resolvedProperty, qualifiers, target);
		}
		catch (IllegalArgumentException e) {
            fEvalEnv.throwVMException(new VMRuntimeException("Unknown property '" + property.getName() + "'", e)); //$NON-NLS-1$ //$NON-NLS-2$
			return ValuesUtil.INVALID_VALUE; //getInvalidResult();
		}
	}
	// implements the inherited specification
	public Object superNavigateProperty(EStructuralFeature property,
			List<?> qualifiers, Object target)
			throws IllegalArgumentException {

		if (target instanceof EObject) {
			EObject etarget = (EObject) target;

			if (etarget.eClass().getEAllStructuralFeatures().contains(property)) {
				if (property.getEType() instanceof VoidType) {
					// then the only instance is null; using eGet would
					// cause a ClassCastException because VoidTypeImpl
					// is neither an EClass nor an EDataType.
					return null;
				}
				return /*coerceValue(property,*/ etarget.eGet(property)/*, true)*/;
			}
    	} /*else if (target instanceof Tuple<?, ?>) {
    		@SuppressWarnings("unchecked")
    		Tuple<EOperation, EStructuralFeature> tuple = (Tuple<EOperation, EStructuralFeature>) target;
    		
    		if (tuple.getTupleType().oclProperties().contains(property)) {
    			return tuple.getValue(property);
    		}
    	} */

		throw new IllegalArgumentException();
	}
}
