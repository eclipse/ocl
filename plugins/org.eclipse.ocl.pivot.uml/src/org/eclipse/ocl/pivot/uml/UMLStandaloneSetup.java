/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.uml;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.labels.ILabelGenerator.Registry;
import org.eclipse.ocl.pivot.uml.internal.es2as.UML2AS;
import org.eclipse.ocl.pivot.uml.internal.labels.CommentLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralBooleanLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralIntegerLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralNullLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralRealLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralStringLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralUnlimitedNaturalLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.NamedElementLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.OpaqueExpressionLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.PackageImportLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.SlotLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.UMLElementExtensionLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.resource.UMLASResourceFactory;
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

/**
 * Initialization support for UML Pivot models without equinox extension registry
 */
public class UMLStandaloneSetup //implements ISetup
{
	private static boolean initialized = false;
	private static final Logger logger = Logger.getLogger(UMLStandaloneSetup.class);

	/**
	 * Verify that initialization has occurred, generation a warning log message if not and initilaizing anyway.
	 */
	public static void assertInitialized() {
		if (!initialized) {
			logger.warn("UMLStandaloneSetup.init() should be called before using OCL's UML facilities");
			init();
		}
	}

	/**
	 * Initialize the OCL facilities and the associated UML facilities.
	 */
	public static void init() {
		if (!initialized) {
			initialized = true;
			PivotStandaloneSetup.init();
			UMLASResourceFactory.getInstance();
			UML2AS.initialize();
			UMLResourcesUtil.init(null);
			initializeLabelGenerators(ILabelGenerator.Registry.INSTANCE);
		}
	}

	/**
	 * Initialize labelRegistry with the UML-specific lable generators.
	 */
	public static void initializeLabelGenerators(@NonNull Registry labelRegistry) {
		CommentLabelGenerator.initialize(labelRegistry);
		LiteralBooleanLabelGenerator.initialize(labelRegistry);
		LiteralIntegerLabelGenerator.initialize(labelRegistry);
		LiteralNullLabelGenerator.initialize(labelRegistry);
		LiteralRealLabelGenerator.initialize(labelRegistry);
		LiteralStringLabelGenerator.initialize(labelRegistry);
		LiteralUnlimitedNaturalLabelGenerator.initialize(labelRegistry);
		NamedElementLabelGenerator.initialize(labelRegistry);
		OpaqueExpressionLabelGenerator.initialize(labelRegistry);
		PackageImportLabelGenerator.initialize(labelRegistry);
		SlotLabelGenerator.initialize(labelRegistry);
		UMLElementExtensionLabelGenerator.initialize(labelRegistry);
	}
}
