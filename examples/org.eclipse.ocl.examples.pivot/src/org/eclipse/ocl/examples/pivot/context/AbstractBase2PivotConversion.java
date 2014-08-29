/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.context;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * AbstractBase2PivotConversion provides the Xtext independent support for Concrete Syntax
 * to Pivot conversion.
 */
public abstract class AbstractBase2PivotConversion extends AbstractConversion implements Base2PivotConversion
{
	/**
	 * Set of all expression nodes whose type involves an UnspecifiedType. These are
	 * created during the left2right pass and are finally resolved to
	 * minimize invalidity.
	 */
	private HashSet<TypedElement> underspecifiedTypedElements = null;

	protected AbstractBase2PivotConversion(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
	}

	protected void addUnderspecifiedTypedElement(@NonNull TypedElement pivotElement) {
		if (underspecifiedTypedElements == null) {
			underspecifiedTypedElements  = new HashSet<TypedElement>();
		}
		underspecifiedTypedElements.add(pivotElement);
	}

	public void refreshName(@NonNull NamedElement pivotNamedElement, @Nullable String newName) {
		String oldName = pivotNamedElement.getName();
		if ((newName != oldName) && ((newName == null) || !newName.equals(oldName))) {
			pivotNamedElement.setName(newName);
		}
	}

	public void refreshNsURI(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage, String newNsURI) {
		String oldNsURI = pivotPackage.getURI();
		if ((newNsURI != oldNsURI) && ((newNsURI == null) || !newNsURI.equals(oldNsURI))) {
			pivotPackage.setURI(newNsURI);
		}
	}

	public void setBehavioralType(@NonNull TypedElement targetElement, @NonNull TypedElement sourceElement) {
		if (!sourceElement.eIsProxy()) {
			Type type = PivotUtil.getType(sourceElement);
			if ((type == null) || !type.eIsProxy()) {
				setType(targetElement, type, sourceElement.isRequired());
				return;
			}
		}
		setType(targetElement, null, sourceElement.isRequired());
	}

	public void setContextVariable(@NonNull ExpressionInOCL pivotSpecification, @NonNull String selfVariableName, @Nullable Type contextType, @Nullable Type contextInstance) {
		Variable contextVariable = pivotSpecification.getContextVariable();
		if (contextVariable == null) {
			@SuppressWarnings("null")
			@NonNull Variable nonNullContextVariable = PivotFactory.eINSTANCE.createVariable();
			contextVariable = nonNullContextVariable;
			pivotSpecification.setContextVariable(contextVariable);
		}
		refreshName(contextVariable, selfVariableName);
		setType(contextVariable, contextType, contextVariable.isRequired(), contextInstance);
	}

	public void setClassifierContext(@NonNull ExpressionInOCL pivotSpecification, @NonNull Type contextType) {
		Variable contextVariable = pivotSpecification.getContextVariable();
		if (contextVariable != null) {
			if (contextType.eIsProxy()) {
				setType(contextVariable, null, false);
			}
			else {
				setType(contextVariable, contextType, true);
			}
		}
	}

	public void setOperationContext(@NonNull ExpressionInOCL pivotSpecification, @NonNull Operation contextOperation, @Nullable String resultName) {
		Variable contextVariable = pivotSpecification.getContextVariable();
//		pivotSpecification.getParameterVariable().clear();
		if ((contextVariable != null) && !contextOperation.eIsProxy()) {
			setType(contextVariable, contextOperation.getOwningClass(), true);
			setParameterVariables(pivotSpecification, DomainUtil.nonNullEMF(contextOperation.getOwnedParameter()));
		}
		if (resultName != null) {
			setResultVariable(pivotSpecification, contextOperation, resultName);
		}
	}

	public void setParameterVariables(@NonNull ExpressionInOCL pivotSpecification, @NonNull List<Parameter> parameters) {
		List<Variable> oldVariables = new ArrayList<Variable>(pivotSpecification.getParameterVariable());
		List<Variable> newVariables = new ArrayList<Variable>();
		for (Parameter parameter : parameters) {
		    String name = parameter.getName();
			Variable param = DomainUtil.getNamedElement(oldVariables, name);
		    if (param != null) {
		    	oldVariables.remove(param);
		    }
		    else {
		    	param = PivotFactory.eINSTANCE.createVariable();
		        param.setName(name);
		    }
		    setBehavioralType(param, parameter);
		    param.setRepresentedParameter(parameter);
		    newVariables.add(param);
		}
		refreshList(DomainUtil.nonNullModel(pivotSpecification.getParameterVariable()), newVariables);
	}

	public void setParameterVariables(@NonNull ExpressionInOCL pivotSpecification, @NonNull Map<String, Type> parameters) {
		List<Variable> oldVariables = new ArrayList<Variable>(pivotSpecification.getParameterVariable());
		List<Variable> newVariables = new ArrayList<Variable>();
		for (String name : parameters.keySet()) {
		    Type type = parameters.get(name);
			Variable param = DomainUtil.getNamedElement(oldVariables, name);
		    if (param != null) {
		    	oldVariables.remove(param);
		    }
		    else {
		    	param = PivotFactory.eINSTANCE.createVariable();
		        param.setName(name);
		    }
			setType(param, type, param.isRequired());
//		    param.setRepresentedParameter(parameter);
		    newVariables.add(param);
		}
		refreshList(DomainUtil.nonNullModel(pivotSpecification.getParameterVariable()), newVariables);
	}

	public void setPropertyContext(@NonNull ExpressionInOCL pivotSpecification, @NonNull Property contextProperty) {
		Variable contextVariable = pivotSpecification.getContextVariable();
		if ((contextVariable != null) && !contextProperty.eIsProxy()) {
			setType(contextVariable, contextProperty.getOwningClass(), true);
		}
	}

	public void setResultVariable(@NonNull ExpressionInOCL pivotSpecification, @NonNull Operation contextOperation, @NonNull String resultName) {
		Type returnType = contextOperation.getType();
		if (returnType != null) {					// FIXME BUG 385711 Use OclVoid rather than null
			Variable resultVariable = pivotSpecification.getResultVariable();
			if (resultVariable == null) {
				resultVariable = PivotFactory.eINSTANCE.createVariable();
			}
			resultVariable.setName(resultName);
			setBehavioralType(resultVariable, contextOperation);
			pivotSpecification.setResultVariable(resultVariable);
		}
		else {
			pivotSpecification.setResultVariable(null);
		}
	}

	/**
	 * Set the type and so potentially satisfy some TypeOfDependency. This method ensures that
	 * type is not set to null.
	 */
	@Deprecated
	public void setType(@NonNull TypedElement pivotElement, Type type) {
		setType(pivotElement, type, pivotElement.isRequired());
	}
	public void setType(@NonNull OCLExpression pivotElement, Type type, boolean isRequired, @Nullable Type typeValue) {
		setType(pivotElement, type, isRequired);
		Type primaryTypeValue = typeValue != null ? metaModelManager.getPrimaryType(typeValue) : null;
		if (primaryTypeValue != pivotElement.getTypeValue()) {
			pivotElement.setTypeValue(primaryTypeValue);
		}
	}
	public void setType(@NonNull VariableDeclaration pivotElement, Type type, boolean isRequired, @Nullable Type typeValue) {
		setType(pivotElement, type, isRequired);
		Type primaryTypeValue = typeValue != null ? metaModelManager.getPrimaryType(typeValue) : null;
		if (primaryTypeValue != pivotElement.getTypeValue()) {
			pivotElement.setTypeValue(primaryTypeValue);
		}
	}
	public void setType(@NonNull TypedElement pivotElement, Type type, boolean isRequired) {
		Type primaryType = type != null ? metaModelManager.getPrimaryType(type) : null;
		if (primaryType != pivotElement.getType()) {
			pivotElement.setType(primaryType);
		}
		boolean wasRequired = pivotElement.isRequired();
		if (wasRequired != isRequired) {
			pivotElement.setIsRequired(isRequired);
		}
		if (primaryType != null) {
			PivotUtil.debugWellContainedness(primaryType);
		}
	}
}