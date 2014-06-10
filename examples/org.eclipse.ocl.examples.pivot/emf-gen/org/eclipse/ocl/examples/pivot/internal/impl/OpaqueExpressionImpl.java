/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opaque Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl#getExpressionInOCL <em>Expression In OCL</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpaqueExpressionImpl
		extends ValueSpecificationImpl
		implements OpaqueExpression {

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected EList<String> body;

	/**
	 * The cached value of the '{@link #getExpressionInOCL() <em>Expression In OCL</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionInOCL()
	 * @generated
	 * @ordered
	 */
	protected ExpressionInOCL expressionInOCL;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected EList<String> language;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.OPAQUE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> getBody()
	{
		if (body == null)
		{
			body = new EDataTypeEList<String>(String.class, this, PivotPackage.OPAQUE_EXPRESSION__BODY);
		}
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> getLanguage()
	{
		if (language == null)
		{
			language = new EDataTypeUniqueEList<String>(String.class, this, PivotPackage.OPAQUE_EXPRESSION__LANGUAGE);
		}
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.OPAQUE_EXPRESSION__EXTENSION:
				return getExtension();
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.OPAQUE_EXPRESSION__IS_STATIC:
				return isStatic();
			case PivotPackage.OPAQUE_EXPRESSION__NAME:
				return getName();
			case PivotPackage.OPAQUE_EXPRESSION__IS_REQUIRED:
				return isRequired();
			case PivotPackage.OPAQUE_EXPRESSION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.OPAQUE_EXPRESSION__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.OPAQUE_EXPRESSION__BODY:
				return getBody();
			case PivotPackage.OPAQUE_EXPRESSION__EXPRESSION_IN_OCL:
				return getExpressionInOCL();
			case PivotPackage.OPAQUE_EXPRESSION__LANGUAGE:
				return getLanguage();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.OPAQUE_EXPRESSION__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__BODY:
				getBody().clear();
				getBody().addAll((Collection<? extends String>)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__EXPRESSION_IN_OCL:
				setExpressionInOCL((ExpressionInOCL)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__LANGUAGE:
				getLanguage().clear();
				getLanguage().addAll((Collection<? extends String>)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.OPAQUE_EXPRESSION__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.OPAQUE_EXPRESSION__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__BODY:
				getBody().clear();
				return;
			case PivotPackage.OPAQUE_EXPRESSION__EXPRESSION_IN_OCL:
				setExpressionInOCL((ExpressionInOCL)null);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__LANGUAGE:
				getLanguage().clear();
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.OPAQUE_EXPRESSION__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.OPAQUE_EXPRESSION__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.OPAQUE_EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.OPAQUE_EXPRESSION__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.OPAQUE_EXPRESSION__TYPE:
				return type != null;
			case PivotPackage.OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.OPAQUE_EXPRESSION__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.OPAQUE_EXPRESSION__BODY:
				return body != null && !body.isEmpty();
			case PivotPackage.OPAQUE_EXPRESSION__EXPRESSION_IN_OCL:
				return expressionInOCL != null;
			case PivotPackage.OPAQUE_EXPRESSION__LANGUAGE:
				return language != null && !language.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpressionInOCL(ExpressionInOCL newExpressionInOCL, NotificationChain msgs)
	{
		ExpressionInOCL oldExpressionInOCL = expressionInOCL;
		expressionInOCL = newExpressionInOCL;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.OPAQUE_EXPRESSION__EXPRESSION_IN_OCL, oldExpressionInOCL, newExpressionInOCL);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionInOCL(ExpressionInOCL newExpressionInOCL)
	{
		if (newExpressionInOCL != expressionInOCL)
		{
			NotificationChain msgs = null;
			if (expressionInOCL != null)
				msgs = ((InternalEObject)expressionInOCL).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.OPAQUE_EXPRESSION__EXPRESSION_IN_OCL, null, msgs);
			if (newExpressionInOCL != null)
				msgs = ((InternalEObject)newExpressionInOCL).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.OPAQUE_EXPRESSION__EXPRESSION_IN_OCL, null, msgs);
			msgs = basicSetExpressionInOCL(newExpressionInOCL, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.OPAQUE_EXPRESSION__EXPRESSION_IN_OCL, newExpressionInOCL, newExpressionInOCL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitOpaqueExpression(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public @Nullable ExpressionInOCL getExpressionInOCL()
	{
		if (expressionInOCL == null) {
			setExpressionInOCL(PivotUtil.getExpressionInOCL(this));
		}
		return expressionInOCL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ParserException 
	 * @generated NOT
	 */
	public @NonNull ExpressionInOCL getValidExpressionInOCL() throws ParserException
	{
		ExpressionInOCL expressionInOCL2 = expressionInOCL;
		if (expressionInOCL2 != null) {
			return expressionInOCL2;
		}
		String expression = PivotUtil.getBody(this);
		if (expression == null) {
			throw new ParserException("No body expression for " + this);
		}
		expressionInOCL2 = PivotUtil.getValidExpressionInOCL(this, expression);
		setExpressionInOCL(expressionInOCL2);
		return expressionInOCL2;
	}
} //OpaqueExpressionImpl
