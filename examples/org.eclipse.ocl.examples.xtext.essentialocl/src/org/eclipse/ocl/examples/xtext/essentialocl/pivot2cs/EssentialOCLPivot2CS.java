/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.BasePivot2CS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.BaseReferenceVisitor;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;

public class EssentialOCLPivot2CS extends BasePivot2CS
{	
	private static final class Factory implements Pivot2CS.Factory
	{
		private static @NonNull Pivot2CS.Factory INSTANCE = new Factory();

		public @NonNull EssentialOCLDeclarationVisitor createDeclarationVisitor(@NonNull Pivot2CSConversion converter) {
			return new EssentialOCLDeclarationVisitor(converter);
		}

		public @NonNull BaseReferenceVisitor createReferenceVisitor(@NonNull Pivot2CSConversion converter) {
			return new BaseReferenceVisitor(converter);
		}

		public @NonNull EClass[] getEClasses() {
			return new EClass[]{};
		}
	}
		
	public EssentialOCLPivot2CS(@NonNull Map<? extends /*BaseCS*/Resource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(ElementUtil.apiConvert(cs2asResourceMap), metaModelManager);
		addFactory(Factory.INSTANCE);
	}
}
