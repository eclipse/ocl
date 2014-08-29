/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.cs2as;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagedAdapter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.scoping.BaseScopeView;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CSI2PivotMapping;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

/**
 * CS2Pivot manages the equivalence between a Concrete Syntax Resources
 * and their corresponding Pivot Resources creating a CS2PivotConversion
 * to update.
 */
public abstract class CS2Pivot extends AbstractConversion implements MetaModelManagedAdapter
{	
	public static interface UnresolvedProxyMessageProvider
	{
		@NonNull EReference getEReference();	
		@Nullable String getMessage(@NonNull EObject context, @NonNull String linkText);
	}

	public static abstract class AbstractUnresolvedProxyMessageProvider implements UnresolvedProxyMessageProvider
	{
		protected final @NonNull EReference eReference;
		
		public AbstractUnresolvedProxyMessageProvider(/*@NonNull*/ EReference eReference) {
			assert eReference != null;
			this.eReference = eReference;
		}
		public @NonNull EReference getEReference() {
			return eReference;
		}
		
		public abstract @Nullable String getMessage(@NonNull EObject context, @NonNull String linkText);
	}

	/**
	 * Return the containment features ordered so that library and import features are processed before anything else.
	 */
	public static EList<EObject> computeRootContainmentFeatures(RootCS csRoot) {
		BasicEList<EReference> containmentsList = new BasicEList<EReference>();
		for (EStructuralFeature eStructuralFeature : csRoot.eClass().getEAllStructuralFeatures()) {
			if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference) eStructuralFeature;
				if (eReference.isContainment()) {
					containmentsList.add(eReference);
				}
			}
		}
		int index = containmentsList.indexOf(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORT);
		if (index > 0) {
			containmentsList.move(0, index);		// Process imports second
		}
		index = containmentsList.indexOf(BaseCSPackage.Literals.ROOT_CS__OWNED_LIBRARY);
		if (index > 0) {
			containmentsList.move(0, index);		// Process libraries first
		}
		return new EContentsEList<EObject>(csRoot, containmentsList);
	}
	
	private static Map<EReference, UnresolvedProxyMessageProvider> unresolvedProxyMessageProviderMap = new HashMap<EReference, UnresolvedProxyMessageProvider>();

	/**
	 * Whether to show file and line number context at the start of messages.
	 */
	public static boolean showContext = false;

	/**
	 * Interface for an optional message binder that may be used to affix additional context
	 * for standalone and command line applications.
	 */
	public static interface MessageBinder
	{
		@NonNull String bind(@NonNull EObject csContext, @NonNull String messageTemplate, Object... bindings);	
	}

	/**
	 * Default message binder that just invokes {@link NLS#bind(String, Object[])}.
	 */
	public static class DefaultMessageBinder implements CS2Pivot.MessageBinder
	{
		public static final @NonNull MessageBinder INSTANCE = new DefaultMessageBinder();

		public @NonNull String bind(@NonNull EObject csContext, @NonNull String messageTemplate, Object... bindings) {
			return DomainUtil.bind(messageTemplate, bindings);
		}
	}

	/**
	 * Message binder that prefixes the uri and line number to the return from {@link NLS#bind(String, Object[])}.
	 */
	public static class MessageBinderWithLineContext implements CS2Pivot.MessageBinder
	{
		public static final MessageBinder INSTANCE = new MessageBinderWithLineContext();

		public @NonNull String bind(@NonNull EObject csContext, @NonNull String messageTemplate, Object... bindings) {
			String message = DomainUtil.bind(messageTemplate, bindings);
			ICompositeNode node = NodeModelUtils.getNode(csContext);
			if (node != null) {
				int startLine = node.getStartLine();
				String uri = csContext.eResource().getURI().toString();
				return uri + ":" + startLine + " " + message;
			}
			return message;
		}
	}
	
	private static MessageBinder messageBinder = DefaultMessageBinder.INSTANCE;

	public static void addUnresolvedProxyMessageProvider(UnresolvedProxyMessageProvider unresolvedProxyMessageProvider) {
		unresolvedProxyMessageProviderMap.put(unresolvedProxyMessageProvider.getEReference(), unresolvedProxyMessageProvider);
	}

	public static Element basicGetType(TypedTypeRefCS csTypedRef) {
		List<PathElementCS> path = csTypedRef.getPathName().getPath();
		int iLast = path.size()-1;
		for (int i = 0; i < iLast; i++) {
			Element element = path.get(i).basicGetElement();
			if (element == null) {
				return null;
			}
		}
		Element element = path.get(iLast).basicGetElement();
		if (element == null) {
			return null;
		}
		return element;
	}

	public static @Nullable DiagnosticMessage getUnresolvedProxyMessage(@NonNull EReference eReference, @NonNull EObject csContext, @NonNull String linkText) {
		String message = getUnresolvedProxyText(eReference, csContext, linkText);
		return message != null ? new DiagnosticMessage(message, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC) : null;
	}	

	public static @Nullable String getUnresolvedProxyText(@NonNull EReference eReference, @NonNull EObject csContext, @NonNull String linkText) {
		ExceptionAdapter exceptionAdapter = PivotUtil.getAdapter(ExceptionAdapter.class, csContext);
		if (exceptionAdapter != null) {
			return exceptionAdapter.getErrorMessage();
		}
		UnresolvedProxyMessageProvider unresolvedProxyMessageProvider = unresolvedProxyMessageProviderMap.get(eReference);
		if (unresolvedProxyMessageProvider != null) {
			return unresolvedProxyMessageProvider.getMessage(csContext, linkText);
		}
		@SuppressWarnings("null") @NonNull String messageTemplate = OCLMessages.Unresolved_ERROR_;
		String errorContext = "Unknown";
		EClass referenceType = eReference.getEReferenceType();
		if (referenceType != null) {
			errorContext = referenceType.getName();
		}
		return messageBinder.bind(csContext, messageTemplate, errorContext, linkText);
	}	
	
	public static @Nullable CS2Pivot findAdapter(@NonNull ResourceSet resourceSet) {
		return PivotUtil.getAdapter(CS2Pivot.class, resourceSet);
	}

	public static List<ILeafNode> getDocumentationNodes(@NonNull ICompositeNode node) {
		List<ILeafNode> documentationNodes = null;
		for (ILeafNode leafNode : node.getLeafNodes()) {
			EObject grammarElement = leafNode.getGrammarElement();
			if (!(grammarElement instanceof TerminalRule)) {
				break;
			}
			TerminalRule terminalRule = (TerminalRule) grammarElement;
			String name = terminalRule.getName();
			if ("WS".equals(name)) {
			}
			else if ("SL_COMMENT".equals(name)) {
			}
			else if ("ML_COMMENT".equals(name)) {
				if (documentationNodes == null) {
					documentationNodes = new ArrayList<ILeafNode>();
				}
				documentationNodes.add(leafNode);
			}
			else {
				break;
			}
		}
		return documentationNodes;
	}

	private static final class TypeValueFilter implements ScopeFilter
	{
		public static TypeValueFilter INSTANCE = new TypeValueFilter();

		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			if (object instanceof Type) {
				return true;
			}
			if (object instanceof TypedElement) {
				return false; //((TypedElement)object).getType() instanceof Metaclass<?>;
			}
			return false;
		}
	}
	
	private static final class UndecoratedNameFilter implements ScopeFilter
	{
		public static UndecoratedNameFilter INSTANCE = new UndecoratedNameFilter();

		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			return !(object instanceof Operation) && !(object instanceof org.eclipse.ocl.examples.pivot.Package);
		}
	}

	public static MessageBinder getMessageBinder() {
		return messageBinder;
	}
	
	private static long startTime = System.currentTimeMillis();
	private static @NonNull Map<Thread,Long> threadRunTimes = new HashMap<Thread,Long>();
	private static long[] indentRunTimes = new long[100];
	private static @NonNull Integer indentation = 0;
	private static @NonNull String indents= ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";

	public static void printDiagnostic(@NonNull String message, boolean dispose, int indent) {
		synchronized (indentation) {
			if (indent < 0) {
				indentation--;
			}
			long currentTimeMillis = System.currentTimeMillis();
			Thread currentThread = Thread.currentThread();
			Long threadStartTime = threadRunTimes.get(currentThread);
			if (threadStartTime == null) {
				threadStartTime = currentTimeMillis;
				threadRunTimes.put(currentThread, threadStartTime);
			}
			if (indent > 0) {
				System.out.printf("%s %8.3f %s -- %6.3f %s\n", indents.substring(0, Math.min(indentation, indents.length()-1)), (currentTimeMillis - startTime) * 0.001, currentThread.getName(),
					(currentTimeMillis - threadStartTime) * 0.001, message);
			}
			else {
				System.out.printf("%s %8.3f %s -- %6.3f %6.3f %s\n", indents.substring(0, Math.min(indentation, indents.length()-1)), (currentTimeMillis - startTime) * 0.001, currentThread.getName(),
					(currentTimeMillis - threadStartTime) * 0.001, (currentTimeMillis - indentRunTimes[indentation]) * 0.001, message);
			}
			if (dispose) {
				threadRunTimes.remove(currentThread);
			}
			if (indent > 0) {
				indentRunTimes[indentation] = currentTimeMillis;
				indentation++;
			}
		}
	}

	public static void refreshContext(@NonNull PathNameCS pathNameCS, ElementCS csContext) {
		if (pathNameCS.getContext() != csContext) {
			pathNameCS.setContext(csContext);
		}
	}
	
	public static void refreshElementType(PathElementCS pathElementCS, EClassifier elementType) {
		if ((pathElementCS != null)  && (pathElementCS.getElementType() != elementType)) {
			pathElementCS.setElementType(elementType);
		}
	}

	public static void refreshScopeFilter(@NonNull PathNameCS pathNameCS, ScopeFilter scopeFilter) {
		if (pathNameCS.getScopeFilter() != scopeFilter) {
			pathNameCS.setScopeFilter(scopeFilter);
		}
	}
	
	public static void setElementType(@NonNull PathNameCS pathNameCS, /*@NonNull*/ EClass elementType, @NonNull ElementCS csContext, @Nullable ScopeFilter scopeFilter) {
		assert elementType != null;
		refreshContext(pathNameCS, csContext);
		refreshScopeFilter(pathNameCS, scopeFilter);
		List<PathElementCS> path = pathNameCS.getPath();
		int iMax = path.size()-1;
		refreshElementType(path.get(iMax), elementType);
		if (PivotPackage.Literals.FEATURE.isSuperTypeOf(elementType) && (iMax > 0)) {
			refreshElementType(path.get(--iMax), PivotPackage.Literals.TYPE);
		}
		for (int i = 0; i < iMax; i++) {
			refreshElementType(path.get(i), PivotPackage.Literals.NAMESPACE);
		}
	}

	/**
	 * Define an alternative message binder. THe default null messageBinder uses
	 * {@link NLS#bind(String, Object[])} 
	 */
	public static MessageBinder setMessageBinder(MessageBinder messageBinder) {
		MessageBinder savedMessageBinder = CS2Pivot.messageBinder;
		CS2Pivot.messageBinder = messageBinder;
		return savedMessageBinder;
	}

	/**
	 * Define the resolution of a PathNameCS explicitly avoiding the need for the normal Xtext proxy resolution.
	 * This is used after a non-trivial selection occurs such as the selection of the best operation overload.
	 * If element is null the Xtext error message corresponding to an unresolved proxy is generated.
	 * @param ambiguities 
	 */
	public static void setPathElement(@NonNull PathNameCS csPathName, @Nullable Element element, @Nullable List<EObject> ambiguities) {
		List<PathElementCS> csPath = csPathName.getPath();
		@SuppressWarnings("null")@NonNull PathElementCS csLastElement = csPath.get(csPath.size()-1);
		AmbiguitiesAdapter.setAmbiguities(csLastElement, ambiguities);
		if ((element == null) || (ambiguities != null)) {
			EObject eObject = csLastElement;
			INode iNode = NodeModelUtils.getNode(csLastElement);
			Triple<EObject, EReference, INode> triple = Tuples.create(eObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__ELEMENT, iNode);
			Resource eResource = csLastElement.eResource();
			if (eResource instanceof BaseCSResource) {
				((BaseCSResource)eResource).createAndAddDiagnostic(triple);
			}
			csLastElement.setElement(null);
		}
		else {
			csLastElement.setElement(element);
		}
	}
	
	/**
	 * The CS resource mapped by this CS2Pivot.
	 */
	protected final @NonNull Set<? extends BaseCSResource> csResources;

	/**
	 * CS to Pivot mapping controller for aliases and CSIs.
	 */
	protected final @NonNull CSI2PivotMapping cs2PivotMapping;

	public CS2Pivot(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
		this.cs2PivotMapping = CSI2PivotMapping.getAdapter(metaModelManager);
		cs2PivotMapping.add(cs2asResourceMap);
		this.csResources = DomainUtil.nonNullState(cs2asResourceMap.keySet());
		metaModelManager.addListener(this);
		metaModelManager.getASResourceSet().eAdapters().add(this);
	}
	
	protected CS2Pivot(@NonNull CS2Pivot aConverter) {
		super(aConverter.metaModelManager);
		this.csResources = aConverter.csResources;
		this.cs2PivotMapping = CSI2PivotMapping.getAdapter(metaModelManager);
	}

	public @NonNull String bind(@NonNull EObject csContext, /*@NonNull*/ String messageTemplate, Object... bindings) {
		assert messageTemplate != null;
		return messageBinder.bind(csContext, messageTemplate, bindings);
	}

	protected abstract @NonNull BaseCSVisitor<Continuation<?>> createContainmentVisitor(@NonNull CS2PivotConversion cs2PivotConversion);

	protected@NonNull  CS2PivotConversion createConversion(@NonNull IDiagnosticConsumer diagnosticsConsumer, @NonNull Collection<? extends BaseCSResource> csResources) {
		return new CS2PivotConversion(this, diagnosticsConsumer, csResources);
	}

	protected abstract @NonNull BaseCSVisitor<Element> createLeft2RightVisitor(@NonNull CS2PivotConversion cs2PivotConversion);
	protected abstract @NonNull BaseCSVisitor<Continuation<?>> createPostOrderVisitor(@NonNull CS2PivotConversion converter) ;
	protected abstract @NonNull BaseCSVisitor<Continuation<?>> createPreOrderVisitor(@NonNull CS2PivotConversion converter);

	public void dispose() {
		cs2PivotMapping.removeCSResources(csResources);
		csResources.clear();
		metaModelManager.getASResourceSet().eAdapters().remove(this);
		metaModelManager.removeListener(this);
	}

	public @Nullable ModelElementCS getCSElement(@NonNull Element pivotElement) {
		return cs2PivotMapping.getCSElement(pivotElement);
	}

	public @NonNull Collection<? extends BaseCSResource> getCSResources() {
		return csResources;
	}

	public Element getPivotElement(@NonNull ModelElementCS csElement) {
		return cs2PivotMapping.get(csElement);
	}

	public @Nullable <T extends Element> T getPivotElement(@NonNull Class<T> pivotClass, @NonNull ModelElementCS csElement) {
		Element pivotElement = cs2PivotMapping.get(csElement);
		if (pivotElement == null) {
			return null;
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException(pivotElement.getClass().getName() + " is not assignable to " + pivotClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	public ASResource getPivotResource(@NonNull BaseCSResource csResource) {
		return cs2PivotMapping.getASResource(csResource);
	}

	public Collection<? extends Resource> getPivotResources() {
		return metaModelManager.getASResourceSet().getResources();//cs2asResourceMap.values();
	}

	public Notifier getTarget() {
		return metaModelManager.getASResourceSet();
	}
	
	/**
	 * Install the mapping from a CS element that defines a pivot element to the defined pivot element. The definition
	 * is 'owned' by the CS element, so if the CS element vanishes, so does the pivot element.
	 */
	public void installPivotDefinition(@NonNull ModelElementCS csElement, @NonNull Element newPivotElement) {
	//	logger.trace("Installing " + csElement.getDescription()); //$NON-NLS-1$ //$NON-NLS-2$	
		EObject oldPivotElement = csElement.getPivot();	
		if (oldPivotElement != newPivotElement) {
			assert !newPivotElement.eIsProxy();
			csElement.setPivot(newPivotElement);
			if (oldPivotElement != null) {
				// WIP Queue dead element
			}
		}
		cs2PivotMapping.put(csElement, newPivotElement);
	}
	
	/**
	 * Install the mapping from a CS element to a completely independent pivot element. If the pivot element vanishes, the
	 * reference is stale, if the CS element the pivot element is less referenced.
	 */
	public void installPivotReference(@NonNull ElementRefCS csElement, @NonNull Element newPivotElement, @NonNull EReference eReference) {
		assert eReference.getEContainingClass().isSuperTypeOf(csElement.eClass());
	//	logger.trace("Installing " + csElement.getDescription()); //$NON-NLS-1$ //$NON-NLS-2$	
		EObject oldPivotElement = csElement.getPivot();	
		if (oldPivotElement != newPivotElement) {
			assert !newPivotElement.eIsProxy();
			csElement.setPivot(newPivotElement);
		}
	}
	
	/**
	 * Install the mapping from a CS element to a related pivot element. This normally arises when more than one CS element
	 * are associated with a single pivot element. In this case one of the CS elements is the defining CS element and the
	 * others are users.
	 */
	public void installPivotUsage(@NonNull ModelElementCS csElement, @NonNull Element newPivotElement) {
	//	logger.trace("Installing " + csElement.getDescription()); //$NON-NLS-1$ //$NON-NLS-2$	
		EObject oldPivotElement = csElement.getPivot();	
		if (oldPivotElement != newPivotElement) {
			assert !newPivotElement.eIsProxy();
			csElement.setPivot(newPivotElement);
		}
	}

	public boolean isAdapterForType(Object type) {
		if (type instanceof Class<?>) {
			return ((Class<?>)type).isAssignableFrom(getClass());
		}
		else {
			return false;
		}
	}

	public boolean isAdapterFor(@NonNull MetaModelManager metaModelManager) {
		return this.metaModelManager == metaModelManager;
	}

	public @Nullable Iteration lookupIteration(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		setElementType(csPathName, PivotPackage.Literals.ITERATION, csElement, scopeFilter);
		Element namedElement = csPathName.getElement();
		if (namedElement instanceof Iteration) {
			return (Iteration) namedElement;
		}
		else {
			return null;
		}
	}

	public @Nullable Operation lookupOperation(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		setElementType(csPathName, PivotPackage.Literals.OPERATION, csElement, scopeFilter);
		Element namedElement = csPathName.getElement();
		if (namedElement instanceof Operation) {
			return (Operation) namedElement;
		}
		else {
			return null;
		}
	}

	public @Nullable VariableDeclaration lookupSelf(@NonNull ElementCS csElement) {
		@SuppressWarnings("null") @NonNull EReference eReference = PivotPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE;
		EnvironmentView environmentView = new EnvironmentView(metaModelManager, eReference, Environment.SELF_VARIABLE_NAME);
		ScopeView baseScopeView = BaseScopeView.getScopeView(metaModelManager, csElement, eReference);
		environmentView.computeLookups(baseScopeView);
		VariableDeclaration variableDeclaration = (VariableDeclaration) environmentView.getContent();
		return variableDeclaration;
	}

	public @Nullable Type lookupType(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName) {
		setElementType(csPathName, PivotPackage.Literals.TYPE, csElement, null);
		Element namedElement = csPathName.getElement();
		if (namedElement instanceof Type) {
			return (Type) namedElement;
		}
		else {
			return null;
		}
	}

	public @Nullable Type lookupTypeQualifier(@NonNull PathNameCS csPathName) {
		List<PathElementCS> path = csPathName.getPath();
		int iMax = path.size();
		if (iMax <= 1) {
			return null;
		}
		PathElementCS pathElementCS = path.get(iMax-2);
		refreshElementType(pathElementCS, PivotPackage.Literals.TYPE);
		for (int i = 0; i < iMax-2; i++) {
			refreshElementType(path.get(i), PivotPackage.Literals.NAMESPACE);
		}
		Element namedElement = pathElementCS.getElement();
		if (namedElement instanceof Type) {
			return (Type) namedElement;
		}
		else {
			return null;
		}
	}

	public @Nullable Type lookupTypeValue(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName) {
		setElementType(csPathName, PivotPackage.Literals.NAMED_ELEMENT, csElement, TypeValueFilter.INSTANCE);	// Type or Variable
		Element namedElement = csPathName.getElement();
		if (namedElement instanceof Type) {
			return (Type) namedElement;
		}
		else {
			return null;
		}
	}

	public @Nullable Element lookupUndecoratedName(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName) {
		setElementType(csPathName, PivotPackage.Literals.ELEMENT, csElement, UndecoratedNameFilter.INSTANCE);
		Element namedElement = csPathName.getElement();
		return namedElement;
	}

	public void metaModelManagerDisposed(@NonNull MetaModelManager metaModelManager) {
		dispose();
	}

	public void notifyChanged(Notification notification) {
		// Do nothing.
	}
	
	public @NonNull <T extends Element> T refreshModelElement(@NonNull Class<T> pivotClass, @NonNull EClass pivotEClass, @Nullable ModelElementCS csElement) {
		Element pivotElement = csElement != null ? getPivotElement(csElement) : null;
		@NonNull Element pivotElement2;
		if ((pivotElement != null)
		 && pivotClass.isAssignableFrom(pivotElement.getClass())					// Avoid resetting container of incidental reference
		 && ((csElement == null) || (csElement.eContainer() != null))) {			// Avoid resetting container of potentially re-used root
			PivotUtil.resetContainer(pivotElement);		// Bypass child-stealing detector
		}
		if ((pivotElement == null) || (pivotEClass != pivotElement.eClass())) {
			@SuppressWarnings("null") @NonNull Element pivotElement3 = (Element) pivotEClass.getEPackage().getEFactoryInstance().create(pivotEClass);
			pivotElement2 = pivotElement3;
		}
		else {
			pivotElement2 = pivotElement;
		}
		if (csElement != null) {
			installPivotDefinition(csElement, pivotElement2);
		}
		@SuppressWarnings("unchecked")
		@NonNull T castElement = (T) pivotElement2;
		return castElement;
	}

	public void setTarget(Notifier newTarget) {
		assert newTarget == metaModelManager.getASResourceSet();
	}

	public void unsetTarget(Notifier oldTarget) {
		assert oldTarget == metaModelManager.getASResourceSet();
	}
	
	public synchronized void update(@NonNull IDiagnosticConsumer diagnosticsConsumer) {
//		printDiagnostic("CS2Pivot.update start", false, 0);
		@SuppressWarnings("unused") Map<String, Element> oldCSI2Pivot = cs2PivotMapping.getMapping();
		@SuppressWarnings("unused") Set<String> newCSIs = cs2PivotMapping.computeCSIs(csResources);
//		System.out.println("==========================================================================");
		Collection<? extends BaseCSResource> csResources = getCSResources();
//		for (Resource csResource : csResources) {
//			System.out.println("CS " + csResource.getClass().getName() + "@" + csResource.hashCode() + " " + csResource.getURI());
//		}
		CS2PivotConversion conversion = createConversion(diagnosticsConsumer, csResources);
		conversion.update();
//		System.out.println("---------------------------------------------------------------------------");
//		Collection<? extends Resource> pivotResources = cs2asResourceMap.values();
//		for (Entry<? extends Resource, ? extends Resource> entry : cs2asResourceMap.entrySet()) {
//			Resource csResource = entry.getKey();
//			Resource asResource = entry.getValue();
//			System.out.println("CS " + csResource.getClass().getName() + "@" + csResource.hashCode() + " => " + asResource.getClass().getName() + "@" + asResource.hashCode());
//		}
/*		Set<String> deadCSIs = new HashSet<String>(oldCSI2Pivot.keySet());
		deadCSIs.removeAll(newCSIs);
		for (String deadCSI : deadCSIs) {
			Element deadPivot = oldCSI2Pivot.get(deadCSI);	// WIP
//			metaModelManager.kill(deadPivot);
		} */
		Map<BaseCSResource, ASResource> cs2asResourceMap = new HashMap<BaseCSResource, ASResource>();
		for (BaseCSResource csResource : csResources) {
			ASResource asResource = cs2PivotMapping.getASResource(csResource);
			cs2asResourceMap.put(csResource, asResource);
		}
		conversion.garbageCollect(cs2asResourceMap);
		cs2PivotMapping.update();
//		printDiagnostic("CS2Pivot.update end", false, 0);
	}
}
