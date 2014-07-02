/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - Bug 397429
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2as;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2Pivot;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaTypeName;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSFactory;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.util.OCLstdlibCSVisitor;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class OCLstdlibCS2Pivot extends EssentialOCLCS2Pivot
{	
	private static @Nullable Map<String, MetaTypeName> metaTypeNames = null;

	public static @Nullable MetaTypeName lookUpMetaTypeName(@NonNull EObject csElement, /*@NonNull*/ EStructuralFeature eFeature) {
		Map<String, MetaTypeName> metaTypeNames2 = metaTypeNames;
		if (metaTypeNames2 == null) {
			Resource metaTypeResource = new ResourceImpl(URI.createURI("internal_list;;//of_meta-type_names"));
			List<EObject> metaTypes = metaTypeResource.getContents();
			metaTypeNames2 = metaTypeNames = new HashMap<String, MetaTypeName>();
			for (EClassifier eClassifier : PivotPackage.eINSTANCE.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					if (PivotPackage.Literals.CLASS.isSuperTypeOf((EClass) eClassifier)) {
						MetaTypeName metaTypeName = OCLstdlibCSFactory.eINSTANCE.createMetaTypeName();
						String name = eClassifier.getName();
						metaTypeName.setName(name);
						metaTypeNames2.put(name, metaTypeName);
						metaTypes.add(metaTypeName);			// Avoid detection of orphans by EnvironmentView.addElement()
					}
				}
			}
		}
		List<INode> featureNodes = NodeModelUtils.findNodesForFeature(csElement, eFeature);
		if ((featureNodes != null) && (featureNodes.size() > 0)) {
			String metaTypeNameText = NodeModelUtils.getTokenText(featureNodes.get(0));
			MetaTypeName metaTypeName = metaTypeNames2.get(metaTypeNameText);
			csElement.eSet(eFeature, metaTypeName);
			return metaTypeName;
		}
		return null;
	}

	public OCLstdlibCS2Pivot(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}
	
	public OCLstdlibCS2Pivot(@NonNull OCLstdlibCS2Pivot cs2pivot) {
		super(cs2pivot);
	}

	@Override
	protected @NonNull OCLstdlibCSVisitor<Continuation<?>> createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLstdlibCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull OCLstdlibCSVisitor<Element> createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLstdlibCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull OCLstdlibCSVisitor<Continuation<?>> createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLstdlibCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull OCLstdlibCSVisitor<Continuation<?>> createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLstdlibCSPreOrderVisitor(converter);
	}

	@Override
	public synchronized void update(@NonNull IDiagnosticConsumer diagnosticsConsumer) {
		metaModelManager.setLibraryLoadInProgress(true);
		try {
			super.update(diagnosticsConsumer);
		} finally {
			metaModelManager.setLibraryLoadInProgress(false);
		}
	}
}
