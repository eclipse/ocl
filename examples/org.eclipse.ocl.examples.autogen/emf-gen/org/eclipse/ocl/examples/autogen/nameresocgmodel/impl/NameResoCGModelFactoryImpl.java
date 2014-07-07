/**
 * <copyright>
 * 
 * Copyright (c) 2014 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	 Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.autogen.nameresocgmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddCall;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.EnvLookupKind;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelFactory;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.NameResoCGModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NameResoCGModelFactoryImpl extends EFactoryImpl implements NameResoCGModelFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright>\r\n\r\nCopyright (c) 2014 Willink Transformations, University of York and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n\t Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation\r\n\r\n</copyright>";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NameResoCGModelFactory init() {
		try {
			NameResoCGModelFactory theNameResoCGModelFactory = (NameResoCGModelFactory)EPackage.Registry.INSTANCE.getEFactory(NameResoCGModelPackage.eNS_URI);
			if (theNameResoCGModelFactory != null) {
				return theNameResoCGModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NameResoCGModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameResoCGModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NameResoCGModelPackage.CG_ADD_CALL: return createCGAddCall();
			case NameResoCGModelPackage.CG_ENV_VISIT_OP: return createCGEnvVisitOp();
			case NameResoCGModelPackage.CG_ENV_VISIT_OP_BODY: return createCGEnvVisitOpBody();
			case NameResoCGModelPackage.CG_ENV_VISIT_IF_PART: return createCGEnvVisitIfPart();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case NameResoCGModelPackage.ENV_LOOKUP_KIND:
				return createEnvLookupKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case NameResoCGModelPackage.ENV_LOOKUP_KIND:
				return convertEnvLookupKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGAddCall createCGAddCall() {
		CGAddCallImpl cgAddCall = new CGAddCallImpl();
		return cgAddCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGEnvVisitOp createCGEnvVisitOp() {
		CGEnvVisitOpImpl cgEnvVisitOp = new CGEnvVisitOpImpl();
		return cgEnvVisitOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGEnvVisitOpBody createCGEnvVisitOpBody() {
		CGEnvVisitOpBodyImpl cgEnvVisitOpBody = new CGEnvVisitOpBodyImpl();
		return cgEnvVisitOpBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGEnvVisitIfPart createCGEnvVisitIfPart() {
		CGEnvVisitIfPartImpl cgEnvVisitIfPart = new CGEnvVisitIfPartImpl();
		return cgEnvVisitIfPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvLookupKind createEnvLookupKindFromString(EDataType eDataType, String initialValue) {
		EnvLookupKind result = EnvLookupKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnvLookupKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameResoCGModelPackage getNameResoCGModelPackage() {
		return (NameResoCGModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NameResoCGModelPackage getPackage() {
		return NameResoCGModelPackage.eINSTANCE;
	}

} //NameResoCGModelFactoryImpl
