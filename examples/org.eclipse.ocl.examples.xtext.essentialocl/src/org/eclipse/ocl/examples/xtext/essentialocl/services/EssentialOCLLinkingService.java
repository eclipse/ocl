/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.essentialocl.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.IllegalLibraryException;
import org.eclipse.ocl.examples.xtext.base.cs2as.ExceptionAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.BaseScopeProvider;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;

public class EssentialOCLLinkingService extends DefaultLinkingService
{
	public static boolean DEBUG_RETRY = false;			// Set true to retry for debug tracing
	
	public static class Ambiguities extends ExceptionAdapter
	{
		private List<EObject> eObjects;
		
		public Ambiguities(List<EObject> eObjects) {
			super(null);
			this.eObjects = eObjects;
		}

		@Override
		public String getErrorMessage() {
			StringBuilder s = new StringBuilder();
			s.append("Ambiguous resolution:");
			for (EObject eObject : eObjects) {
				s.append("\n\t");
				s.append(eObject.eClass().getName());
				s.append(" : ");
				s.append(eObject);				
			}
			return s.toString();
		}
	}
	
	private static int depth = -1;
	
	@Inject
	private IValueConverterService valueConverterService;

	@Inject
	private IGlobalScopeProvider globalScopeProvider;
	
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		try {
			depth++;
			String text = getText(node);
			boolean traceLookup = BaseScopeProvider.LOOKUP.isActive();
			if (text == null) {			
				if (traceLookup) {
					BaseScopeProvider.LOOKUP.println("" + depth + " Lookup null");
				}
				return Collections.emptyList();
			}
			IScope scope = null;
			String uri = TypesPackage.eNS_URI;
//			if (ref.getEReferenceType().getEPackage() == TypesPackage.eINSTANCE) {	// This was costly, so don't inflict it when not needed
			if (ref.getEReferenceType().getEPackage().getNsURI().equals(uri)) {
				scope = globalScopeProvider.getScope(context.eResource(), ref, null);
			}
			else {
				scope = getScope(context, ref);
				if (traceLookup) {
//					EObject target = ((ScopeView)scope).getTarget();
//					String inString = target instanceof ElementCS ? ((ElementCS)target).getSignature() : target.toString();
//					BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " in " + inString);
					BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text);
				}
			}
			if (scope == null) {
				return Collections.emptyList();
			}
			QualifiedName qualifiedName = QualifiedName.create(text);				// FIXME use IQualifiedNameConverter
			List<EObject> linkedObjects = lookUp(scope, qualifiedName);
			if ((linkedObjects.size() <= 0) && text.startsWith("_")) {				// Deprecated compatibility
				linkedObjects = lookUp(scope, QualifiedName.create(text.substring(1)));
			}
			if (traceLookup) {
				BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + text + " failed");
			}
			List<Adapter> eAdapters = context.eAdapters();
			Adapter adapter = EcoreUtil.getAdapter(eAdapters, ExceptionAdapter.class);
			if (adapter != null) {
				eAdapters.remove(adapter);
			}
			if (linkedObjects.size() > 1) {
				if (DEBUG_RETRY) {
					scope.getElements(qualifiedName);
				}
				eAdapters.add(new Ambiguities(linkedObjects));
				return Collections.emptyList();
			}
			if (linkedObjects.size() <= 0) {
				if (DEBUG_RETRY) {
					scope.getElements(qualifiedName);
				}
			}
			return linkedObjects;
		}
		catch (IllegalLibraryException e) {
			context.eAdapters().add(new ExceptionAdapter(e));
			return Collections.emptyList();
		}
		finally {
			depth--;
		}
	}

	@Override
	protected IScope getScope(EObject context, EReference reference) {
		IScopeProvider scopeProvider = getScopeProvider();
		if (scopeProvider == null)
			throw new IllegalStateException("scopeProvider must not be null.");
//		try {
//			registerImportedNamesAdapter(context);
			return scopeProvider.getScope(context, reference);
//		} finally {
//			unRegisterImportedNamesAdapter();
//		}
	}

	public @Nullable String getText(@Nullable INode node) {
		if (node == null) {
			return null;
		}
		ILeafNode leafNode = ElementUtil.getLeafNode(node);
		if (leafNode == null) {
			return null;
		}
		EObject grammarElement = leafNode.getGrammarElement();
		String ruleName = getLinkingHelper().getRuleNameFrom(grammarElement);
		return (String) valueConverterService.toValue(leafNode.getText(), ruleName, leafNode);
	}

	protected List<EObject> lookUp(@NonNull IScope scope, QualifiedName qualifiedName) {
		@NonNull List<EObject> linkedObjects = new ArrayList<EObject>();
		for (IEObjectDescription eObjectDescription : scope.getElements(qualifiedName)) {
			EObject eObjectOrProxy = eObjectDescription.getEObjectOrProxy();
			linkedObjects.add(eObjectOrProxy);
			if (BaseScopeProvider.LOOKUP.isActive()) {
				BaseScopeProvider.LOOKUP.println("" + depth + " Lookup " + qualifiedName + " => " + eObjectOrProxy);									
			}
		}
		return linkedObjects;
	}
}
