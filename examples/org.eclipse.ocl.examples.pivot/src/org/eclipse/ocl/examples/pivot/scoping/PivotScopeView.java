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
package org.eclipse.ocl.examples.pivot.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * ScopeViews support access to some or all of the elements in a scope.
 * Accesses are filtered on the fly since a cache of results does not remain valid
 * for long enough to merit it, with incremental reparsing regularly trashing
 * the CST.
 */
public class PivotScopeView implements ScopeView
{
	/**
     * The <code>NULLSCOPEVIEW</code> to be returned by the most outer scope
     */
    public static final @NonNull ScopeView NULLSCOPEVIEW = new ScopeView()
    {
		public @NonNull Attribution getAttribution() {
			return NullAttribution.INSTANCE;
		}

		public @Nullable Element getChild() {
			return null;
		}

		public @Nullable EStructuralFeature getContainmentFeature() {
			return null;
		}

		public @NonNull ScopeView getParent() {
			return NULLSCOPEVIEW;
		}

		public @NonNull ScopeView getRoot() {
			return NULLSCOPEVIEW;
		}

		public Element getTarget() {
			return null;
		}

		public boolean isQualified() {
			return false;
		}
    };
	
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull Element target;							// AST node in which a lookup is to be performed
	protected final @Nullable Element child;							// AST node from which a lookup is to be performed
	protected final boolean isQualified;								// True of the lookup has an explicit namespace qualification
	private ScopeView parent = null;									// Lazily computed scope view for target's parent
	private Attribution attribution = null;								// Lazily computed attributes helper for the target CS node
	
	protected PivotScopeView(@NonNull MetaModelManager metaModelManager, @NonNull Element target, @Nullable Element child, boolean isQualified) {
		this.metaModelManager = metaModelManager;
		this.target = target;
		this.child = child;
		this.isQualified = isQualified;
	}

	public @Nullable ScopeView computeLookup(@NonNull EnvironmentView environmentView, @NonNull EObject aTarget) {
		assert aTarget instanceof Element;
		if (attribution == null) {
			attribution = PivotUtil.getAttribution(target);
		}
		return attribution.computeLookup(aTarget, environmentView, this);
	}

	public @NonNull Attribution getAttribution() {
		Attribution attribution2 = attribution;
		if (attribution2 == null) {
			attribution = attribution2 = PivotUtil.getAttribution(target);
		}
		return attribution2;
	}

	public @Nullable Element getChild() {
		return child;
	}

	public @Nullable EStructuralFeature getContainmentFeature() {
//		assert ((child == null) && (containmentFeature == null)) || ((child != null) && (child.eContainmentFeature() ==  containmentFeature));
		return (child != null) ? child.eContainmentFeature() : null;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public @NonNull ScopeView getParent() {
		ScopeView parent2 = parent;
		if (parent2 == null) {
			EObject pParent = target.eContainer();
			if (pParent instanceof Element) {
				parent2 = new PivotScopeView(metaModelManager, (Element)pParent, target, isQualified);
			}
			else {
				parent2 = NULLSCOPEVIEW;
			}
			parent = parent2;
		}
		return parent2;
	}

	public @NonNull ScopeView getRoot() {
		ScopeView parent = getParent();
		if (parent == NULLSCOPEVIEW) {
			return this;
		}
		else {
			return parent.getRoot();
		}
	}

	public final @NonNull Element getTarget() {
		return target;
	}

	public boolean isQualified() {
		return isQualified;
	}

	@Override
	public String toString() {
		Element target = getTarget();
		StringBuilder s = new StringBuilder();
		s.append("["); //$NON-NLS-1$
		s.append(target.eClass().getName());
		EStructuralFeature containmentFeature = getContainmentFeature();
		if (containmentFeature != null) {
			s.append("::"); //$NON-NLS-1$
			s.append(containmentFeature.getName());
		}
		s.append("] "); //$NON-NLS-1$
		s.append(String.valueOf(target));
		return s.toString();
	}
}
