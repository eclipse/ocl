/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.uml;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.validation.LoadableConstraintProvider;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * UMLProfileConstraintProvider supports loading of constraints from a UML Profile.
 * <p>
 * Pending improvement of the EMFv API:
 * <p>
 * Two ConstraintProviders should be specified for the one Category for the
 * org.eclipse.emf.validation.constraintProviders extension point.
 * <p>
 * The first ConstraintProvider default-classed XmlConstraintProvider may have a
 * single placeholder constraint that provides the initial content of the
 * Model Validation Constraints Preference page.
 * <p>
 * The second ConstraintProvider deriving from LoadableConstraintProvider
 * should have a Path-languaged constraint with an XML path parameter locating the
 * model source of the loadable constraints. These will be loaded by the first validation
 * run and repopulate the Preference page with their content.
 * <p>
 * See org.eclipse.ocl.examples.xtext.tests/plugin.xml for an example.
 */
public class UMLProfileConstraintProvider extends LoadableConstraintProvider
{
	private static final Logger logger = Logger.getLogger(UMLProfileConstraintProvider.class);

	@Override
	protected boolean load(@NonNull MetaModelManager metaModelManager, @NonNull URI uri, @NonNull Set<Category> categories) {
		ResourceSet resourceSet = metaModelManager.getExternalResourceSet();
		UMLResource umlResource = null;
		try {
			umlResource = (UMLResource) resourceSet.getResource(uri, true);
		}
		catch (WrappedException e) {
			logger.error("Failed to load '" + uri, e);
			throw e;
		}
		List<Resource.Diagnostic> errors = umlResource.getErrors();
		assert errors != null;
		String message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			logger.error("Failed to load '" + uri + message);
			return false;
		}
		
		Resource asResource;
		try {
			asResource = getOCL().uml2pivot(umlResource);
		} catch (ParserException e) {
			logger.error("Failed to load Pivot from '" + uri + "': ", e);
			return false;
		}
		return installResource(asResource, categories);
	}
}
