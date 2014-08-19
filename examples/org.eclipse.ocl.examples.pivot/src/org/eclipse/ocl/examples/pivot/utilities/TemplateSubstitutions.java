/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public class TemplateSubstitutions
{
	private static @Nullable TemplateSubstitutions getAllTemplateParametersAsBindings(@NonNull MetaModelManager metaModelManager, @NonNull EObject eObject) {
		if (eObject instanceof TemplateableElement) {
			eObject = PivotUtil.getUnspecializedTemplateableElement((TemplateableElement)eObject);
		}
		TemplateSubstitutions result = null;
		EObject eContainer = eObject.eContainer();
		if (eContainer != null) {
			result = getAllTemplateParametersAsBindings(metaModelManager, eContainer);
		}
		if (eObject instanceof TemplateableElement) {
//			TemplateableElement unspecializedTemplateableElement = getUnspecializedTemplateableElement((TemplateableElement)eObject);
			TemplateSignature templateSignature = ((TemplateableElement)eObject).getOwnedTemplateSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getOwnedTemplateParameters();
				if (templateParameters.size() > 0) {
					if (result == null) {
						result = new TemplateSubstitutions(metaModelManager);
					}
					for (TemplateParameter templateParameter : templateSignature.getOwnedTemplateParameters()) {
						result.put(templateParameter, null);
					}
				}
			}
		}
		return result;
	}

	private static TemplateSubstitutions getAllTemplateParameterSubstitutions(@NonNull MetaModelManager metaModelManager, TemplateSubstitutions bindings,
		Type argumentType, LambdaType lambdaType) {
		Type resultType = lambdaType.getResultType();
		if (resultType != null) {
			TemplateParameter resultTemplateParameter = resultType.isTemplateParameter();
			if (resultTemplateParameter != null) {
				if (bindings == null) {
					bindings = new TemplateSubstitutions(metaModelManager);
				}
				bindings.put(resultTemplateParameter, argumentType);
			}
		}
		// FIXME There is much more to do
		// FIXME Conflict checking
		return bindings;
	}

/*	public static @Nullable TemplateSolver getAllTemplateParameterSubstitutions(@Nullable TemplateSolver map,
			@Nullable TemplateableElement templateableElement) {
		for (EObject eObject = templateableElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				if (((TemplateableElement) eObject).getOwnedTemplateBindings().size() > 0) {
					return new TemplateSolver(templateableElement);
				}
			}
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Class) {
				for (org.eclipse.ocl.examples.pivot.Class superType : ((org.eclipse.ocl.examples.pivot.Class)eObject).getSuperClasses()) {
					map = getAllTemplateParameterSubstitutions(map, superType);
				}		
			}
		}
		return map;
	} */
	
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull Map<TemplateParameter, org.eclipse.ocl.examples.pivot.Type> templateParameter2type =
			new HashMap<TemplateParameter, org.eclipse.ocl.examples.pivot.Type>();
	protected final @NonNull Map<TemplateParameterSubstitution, org.eclipse.ocl.examples.pivot.Type> templateParameterSubstitution2type =
			new HashMap<TemplateParameterSubstitution, org.eclipse.ocl.examples.pivot.Type>();

	public TemplateSubstitutions(@NonNull MetaModelManager metaModelManager, Element... asElements) {
		this.metaModelManager = metaModelManager;
		if (asElements != null) {
			for (Element asElement : asElements){
				addTemplateBindings(asElement);
			}
		}
	}

	private void add(@NonNull TemplateParameterSubstitution templateParameterSubstitution) {
		templateParameterSubstitution2type.put(templateParameterSubstitution, templateParameterSubstitution.getActual());
		templateParameter2type.put(templateParameterSubstitution.getFormal(), templateParameterSubstitution.getActual());
	}
	
	
	private void addTemplateBindings(@Nullable Element asElement) {
		for (EObject eObject = asElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				for (TemplateBinding templateBinding : ((TemplateableElement) eObject).getOwnedTemplateBindings()) {
					for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedTemplateParameterSubstitutions()) {
						if (templateParameterSubstitution != null) {
							add(templateParameterSubstitution);
						}
					}
				}
			}
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Class) {
				for (org.eclipse.ocl.examples.pivot.Class superClass : ((org.eclipse.ocl.examples.pivot.Class)eObject).getSuperClasses()) {
					if (superClass != null) {
						addTemplateBindings(superClass);
					}
				}
			}
		}
	}

/*	public boolean containsKey(@NonNull TemplateParameter asTemplateParameter) {
		// TODO Auto-generated method stub
		return false;
	}

	public void put(TemplateParameter templateParameter, Object object) {
		// TODO Auto-generated method stub
		
	}

	public Type get(Type actual) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<TemplateParameter> keySet() {
		// TODO Auto-generated method stub
		return null;
	} */

	/**
	 * Update the template parameter solution so that all TemplatreParameterSubstituions in formalType are compatible with the required actualType.
	 * Returns true unless an update was impossible.
	 */
	private boolean mapTypes(@NonNull Type formalType, @NonNull Type actualType) {
		TemplateParameter templateParameter = formalType.isTemplateParameter();
		if (templateParameter != null) {
			if (actualType.conformsTo(metaModelManager, templateParameter.getLowerBound())
			 && templateParameter.getUpperBound().conformsTo(metaModelManager, actualType)) {
				templateParameter.setLowerBound(actualType);
				templateParameter.setUpperBound(actualType);
				return true;
			}
			else {
				return false;
			}
		}
		org.eclipse.ocl.examples.pivot.Class formalTemplateableElement = formalType.isClass();
		org.eclipse.ocl.examples.pivot.Class actualTemplateableElement = actualType.isClass();
		if ((formalTemplateableElement == null) || (actualTemplateableElement == null)) {
			return false;
		}
		List<TemplateBinding> actualTemplateBindings = actualTemplateableElement.getOwnedTemplateBindings();
		int iMax = actualTemplateBindings.size();
		List<TemplateBinding> formalTemplateBindings = formalTemplateableElement.getOwnedTemplateBindings();
		TemplateSignature formalTemplateSignature = formalTemplateableElement.getOwnedTemplateSignature();
		List<TemplateParameter> formalTemplateParameters = formalTemplateSignature != null ? formalTemplateSignature.getOwnedTemplateParameters() : MetaModelManager.EMPTY_TEMPLATE_PARAMETER_LIST;
/*		if (iMax == formalTemplateBindings.size()) {
			for (int i = 0; i < iMax; i++) {
				formalTemplateBindings.get(i);
				if (actualType.conformsTo(metaModelManager, templateParameter.getLowerBound())
				 && templateParameter.getUpperBound().conformsTo(metaModelManager, actualType)) {
					templateParameter.setLowerBound(actualType);
					templateParameter.setUpperBound(actualType);
					return true;
				}
				else {
					return false;
				}
			}
		}
		else if (iMax == formalTemplateBindings.size()) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			
			if (actualType.conformsTo(metaModelManager, templateParameter.getLowerBound())
			 && templateParameter.getUpperBound().conformsTo(metaModelManager, actualType)) {
				templateParameter.setLowerBound(actualType);
				templateParameter.setUpperBound(actualType);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		} */
		return false;
	}

/*	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	} */
	
	private void put(@NonNull TemplateParameter templateParameter, @Nullable Type actualType) {
		templateParameter2type.put(templateParameter, actualType);
	}

/*	public @Nullable Type get(@NonNull TemplateParameter templateParameter) {
		return templateParameter2type.get(templateParameter);
	} */

	public @Nullable Type get(@NonNull TemplateParameterSubstitution templateParameterSubstitution) {
		Type type = templateParameterSubstitution2type.get(templateParameterSubstitution);
		if (type instanceof TemplateParameter) {
			Type type2 = templateParameter2type.get(type);
			if (type2 != null) {
				return type2;
			}
		}
		return type;
	}

/*	public void setOclSelf(Type sourceType) {
		put(null, sourceType);		// Use the null key to pass OclSelf without creating an object
	} */
}
