/**
 * Copyright (c) 2010,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.LanguageExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LanguageExpressionImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LanguageExpressionImpl#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LanguageExpressionImpl extends ValueSpecificationImpl implements LanguageExpression
{
	/**
	 * The default value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected static final String BODY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected String body = BODY_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageExpressionImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.LANGUAGE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBody()
	{
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(String newBody)
	{
		String oldBody = body;
		body = newBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.LANGUAGE_EXPRESSION__BODY, oldBody, body));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage()
	{
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!LanguageExpression!language
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case PivotPackage.LANGUAGE_EXPRESSION__COMMENT:
				return getComment();
			case PivotPackage.LANGUAGE_EXPRESSION__EXTENSION:
				return getExtension();
			case PivotPackage.LANGUAGE_EXPRESSION__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.LANGUAGE_EXPRESSION__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.LANGUAGE_EXPRESSION__IS_STATIC:
				return isStatic();
			case PivotPackage.LANGUAGE_EXPRESSION__NAME:
				return getName();
			case PivotPackage.LANGUAGE_EXPRESSION__IS_REQUIRED:
				return isRequired();
			case PivotPackage.LANGUAGE_EXPRESSION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.LANGUAGE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.LANGUAGE_EXPRESSION__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.LANGUAGE_EXPRESSION__BODY:
				return getBody();
			case PivotPackage.LANGUAGE_EXPRESSION__LANGUAGE:
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PivotPackage.LANGUAGE_EXPRESSION__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__BODY:
				setBody((String)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.LANGUAGE_EXPRESSION__COMMENT:
				getComment().clear();
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.LANGUAGE_EXPRESSION__BODY:
				setBody(BODY_EDEFAULT);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.LANGUAGE_EXPRESSION__COMMENT:
				return comment != null && !comment.isEmpty();
			case PivotPackage.LANGUAGE_EXPRESSION__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.LANGUAGE_EXPRESSION__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.LANGUAGE_EXPRESSION__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.LANGUAGE_EXPRESSION__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.LANGUAGE_EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.LANGUAGE_EXPRESSION__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.LANGUAGE_EXPRESSION__TYPE:
				return type != null;
			case PivotPackage.LANGUAGE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.LANGUAGE_EXPRESSION__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.LANGUAGE_EXPRESSION__BODY:
				return BODY_EDEFAULT == null ? body != null : !BODY_EDEFAULT.equals(body);
			case PivotPackage.LANGUAGE_EXPRESSION__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? getLanguage() != null : !LANGUAGE_EDEFAULT.equals(getLanguage());
		}
		return eDynamicIsSet(featureID);
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

} //LanguageExpressionImpl
