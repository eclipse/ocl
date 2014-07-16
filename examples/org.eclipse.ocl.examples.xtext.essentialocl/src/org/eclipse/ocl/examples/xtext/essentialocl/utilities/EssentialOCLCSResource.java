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
package org.eclipse.ocl.examples.xtext.essentialocl.utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.utilities.IllegalLibraryException;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.ImportDiagnostic;
import org.eclipse.ocl.examples.xtext.base.cs2as.LibraryDiagnostic;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2Pivot;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs.EssentialOCLPivot2CS;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Triple;

public class EssentialOCLCSResource extends LazyLinkingResource implements BaseCSResource
{	
	protected static class RenamedDiagnostic extends AbstractDiagnostic
	{
		private final SyntaxErrorMessage syntaxErrorMessage;
		private final INode error;
		private final String newMessage;

		protected RenamedDiagnostic(SyntaxErrorMessage syntaxErrorMessage, INode error, String newMessage) {
			this.syntaxErrorMessage = syntaxErrorMessage;
			this.error = error;
			this.newMessage = newMessage;
		}

		@Override
		public String getCode() {
			return syntaxErrorMessage.getIssueCode();
		}

		@Override
		public int getColumn() {
			return -1;
		}

		@Override
		public String[] getData() {
			return syntaxErrorMessage.getIssueData();
		}

		public String getMessage() {
			return newMessage;
		}

		@Override
		protected INode getNode() {
			return error;
		}
	}

	private static final String NO_VIABLE_ALTERNATIVE_AT_INPUT_EOF = "no viable alternative at input '<EOF>'";
	private static final String NO_VIABLE_ALTERNATIVE_FOLLOWING = "no viable alternative following input ";
	private static final String NO_VIABLE_ALTERNATIVE_AT = "no viable alternative at ";
	private static final String MISSING_EOF_AT = "missing EOF at ";
	
	private static final Logger logger = Logger.getLogger(EssentialOCLCSResource.class);
	
	private @Nullable ParserContext parserContext = null;
	
	public EssentialOCLCSResource() {
		super();
	}

	protected void addLibraryError(List<Diagnostic> errors, IllegalLibraryException e) {
		String message = e.getMessage();
		for (Resource.Diagnostic diagnostic : errors) {
			if (diagnostic instanceof LibraryDiagnostic) {
				Exception exception = ((LibraryDiagnostic)diagnostic).getException();
				if (exception instanceof IllegalLibraryException) {
					if (message.equals(exception.getMessage())) {
						return;
					}
				}
			}
		}
		errors.add(new LibraryDiagnostic(e));
	}

	@Override		// FIXME This workaround should be eliminated by a BUG 404438 fix
	protected void addSyntaxErrors() {
		if (isValidationDisabled()) {
			return;
		}
		IParseResult parseResult = getParseResult();
		if (parseResult == null) {
			return;
		}
		List<Diagnostic> errors2 = getErrors();
		for (final INode error : parseResult.getSyntaxErrors()) {
			AbstractDiagnostic diagnostic = null;
			final SyntaxErrorMessage syntaxErrorMessage = error.getSyntaxErrorMessage();
			if (syntaxErrorMessage != null) {
				String message = syntaxErrorMessage.getMessage();
				// BUG 404438 "no viable alternative at input '<EOF>'" message is unhelpful.
				if ((message != null) && message.contains(NO_VIABLE_ALTERNATIVE_AT_INPUT_EOF)){
					int index = message.indexOf(NO_VIABLE_ALTERNATIVE_AT_INPUT_EOF);
					if (index >= 0) {
						String tokenText = NodeModelUtils.getTokenText(error);
						if (tokenText != null) {
							final String newMessage = message.substring(0, index) + NO_VIABLE_ALTERNATIVE_FOLLOWING + "'" + tokenText + "'" + message.substring(index+NO_VIABLE_ALTERNATIVE_AT_INPUT_EOF.length());
							diagnostic = new RenamedDiagnostic(syntaxErrorMessage, error, newMessage);
						}
					}
				}
				else if ((message != null) && message.contains(MISSING_EOF_AT)){
					int index = message.indexOf(MISSING_EOF_AT);
					if (index >= 0) {
						String tokenText = NodeModelUtils.getTokenText(error);
						if (tokenText != null) {
							final String newMessage = message.substring(0, index) + NO_VIABLE_ALTERNATIVE_AT + message.substring(index+MISSING_EOF_AT.length());
							diagnostic = new RenamedDiagnostic(syntaxErrorMessage, error, newMessage);
						}
					}
				}
			}
			if (diagnostic == null) {
				diagnostic = new XtextSyntaxDiagnostic(error);
			}
			errors2.add(diagnostic);
		}
	}

	@Override
	protected void createAndAddDiagnostic(Triple<EObject, EReference, INode> triple) {
		if (isValidationDisabled())
			return;
		EObject context = triple.getFirst();
		if (context instanceof ElementCS) {
			if (!hasError((ElementCS)context)) {
				super.createAndAddDiagnostic(triple);
				setHasError((ElementCS)context);
			}
		}
		else {
			super.createAndAddDiagnostic(triple);
		}
	}

	public @NonNull CS2Pivot createCS2Pivot(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new EssentialOCLCS2Pivot(cs2asResourceMap, metaModelManager);
	}

	@Override			// FIXME Bug 380232 workaround
	protected Diagnostic createDiagnostic(Triple<EObject, EReference, INode> triple, DiagnosticMessage message) {
		EObject first = triple.getFirst();
		if (first instanceof PathElementWithURICS) {
			return new ImportDiagnostic(triple.getThird(), message.getMessage(), message.getIssueCode(), message.getIssueData());
		}
		else {
			return new XtextLinkingDiagnostic(triple.getThird(), message.getMessage(), message.getIssueCode(), message.getIssueData())
			{
				@Override
				public int getColumn() {
					return -1;
				}
			};
		}
	}

	public @NonNull Pivot2CS createPivot2CS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new EssentialOCLPivot2CS(cs2asResourceMap, metaModelManager);
	}

	public @NonNull MetaModelManager createMetaModelManager() {
		ResourceSet resourceSet = getResourceSet();
		if (resourceSet != null) {
			MetaModelManagerResourceSetAdapter resourceSetAdapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
			if (resourceSetAdapter != null) {
				return resourceSetAdapter.getMetaModelManager();
			}
		}
		return new MetaModelManager();
	}

	@Override
	protected void doLinking() {
//		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".doLinking start", false, +1);
		List<Diagnostic> errors = getErrors();
		if (errors.size() > 0) {
			for (int i = errors.size(); --i >= 0; ) {
				Diagnostic error = errors.get(i);
				if (error instanceof LibraryDiagnostic) {
					errors.remove(i);
				}
			}
		}
		super.doLinking();
//		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".doLinking end", false, -1);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
//		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".doLoad start", false, +1);
		try {
			super.doLoad(inputStream, options);
		}
		finally {
//			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".doLoad end", true, -1);
		}
	}
	
	public final @Nullable CS2PivotResourceAdapter findCS2ASAdapter() {
		return PivotUtil.getAdapter(CS2PivotResourceAdapter.class, this);
	}
	
	public @NonNull String getASContentType() {
		return ASResource.ESSENTIALOCL_CONTENT_TYPE;
	}
	
	public final @NonNull CS2PivotResourceAdapter getCS2ASAdapter(@Nullable MetaModelManager metaModelManager) {
		CS2PivotResourceAdapter adapter = PivotUtil.getAdapter(CS2PivotResourceAdapter.class, this);
		if (adapter == null) {
			if (metaModelManager == null) {
				metaModelManager = PivotUtil.findMetaModelManager(this);					
				if (metaModelManager == null) {
					metaModelManager = createMetaModelManager();
					ResourceSet csResourceSet = getResourceSet();
					if (csResourceSet != null) {
						MetaModelManagerResourceSetAdapter.getAdapter(csResourceSet, metaModelManager);
					}
				}
				ClassLoader classLoader = getClass().getClassLoader();
				if (classLoader != null) {
					metaModelManager.addClassLoader(classLoader);
				}
			}
			@SuppressWarnings("null")@NonNull Registry resourceFactoryRegistry = metaModelManager.getASResourceSet().getResourceFactoryRegistry();
			initializeResourceFactory(resourceFactoryRegistry);
			adapter = new CS2PivotResourceAdapter(this, metaModelManager);
			eAdapters().add(adapter);
		}
		return adapter;
	}

	public @NonNull String getEditorName() {
		return "Essential OCL";
	}

	public final @Nullable ParserContext getParserContext() {
		return parserContext;
	}

	public final @NonNull ASResource getASResource(@Nullable MetaModelManager metaModelManager) {
		CS2PivotResourceAdapter adapter = getCS2ASAdapter(metaModelManager);
		ASResource asResource = adapter.getASResource(this);
		if (asResource == null) {
			throw new IllegalStateException("No Pivot Resource created");
		}
		return asResource;
	}

	@SuppressWarnings("null")
	public @NonNull URI getASURI(@NonNull URI csURI) {
		return csURI.appendFileExtension(PivotConstants.OCL_AS_FILE_EXTENSION);
	}

	protected boolean hasError(ElementCS csElement) {
		while ((csElement instanceof PathElementCS) || (csElement instanceof PathNameCS)) {
			csElement = csElement.getLogicalParent();
		}
		while (csElement instanceof ExpCS) {
			if (((ExpCS) csElement).isHasError()) {
				return true;
			}
			csElement = csElement.getLogicalParent();
			if (!(csElement instanceof NavigationOperatorCS) && !(csElement instanceof NameExpCS)) {
				break;
			}
		}
		return false;
	}

	/**
	 * Install any required extension/content-type registrations to enable AS Resources
	 * to be created satisfactorily.
	 */
	protected void initializeResourceFactory(@NonNull Resource.Factory.Registry resourceFactoryRegistry) {}

	public @Nullable NamedElement isPathable(@NonNull EObject element) {
		if (element instanceof Feature) {
			return (Feature)element;
		}
		else if (element instanceof Type) {
			return (Type)element;
		}
		else if (element instanceof Namespace) {
			return (Namespace)element;
		}
		else if (element instanceof EnumerationLiteral) {
			return (EnumerationLiteral)element;
		}
		else if ((element instanceof Variable) && (element.eContainer() instanceof LoopExp)) {
			return (Variable)element;
		}
		else if ((element instanceof Variable) && (element.eContainer() instanceof LetExp)) {
			return (Variable)element;
		}
		// ?? Constraint, Signal, ...
		else {
			return null;
		}
	}

	@Override
	public void reparse(String newContent) throws IOException {
		try {
			super.reparse(newContent);
		}
		catch (IllegalArgumentException e) {
			logger.error("Failed to reparse", e);
		}
	}

	public final @NonNull URI resolve(@NonNull URI uri) {
		URI csURI = getURI();
		if (csURI.isRelative()) {
			File csRelative = new File(csURI.toFileString());
			File csAbsolute = csRelative.getAbsoluteFile();
			csURI = URI.createFileURI(csAbsolute.toString());
		}
		URI resolvedURI = uri.resolve(csURI);
		assert resolvedURI != null;
		return resolvedURI;
	}

	@Override
	public void resolveLazyCrossReferences(CancelIndicator mon) {	// FIXME move to Validation rules
		List<Diagnostic> errors = getErrors();
		assert errors != null;
		if (ElementUtil.hasSyntaxError(errors)) {
			return;
		}
		MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(this);
		if (metaModelManager != null) {
//			if (metaModelManager.getLibraryResource() != org.eclipse.ocl.examples.library.oclstdlib.OCLstdlib.INSTANCE) {
//				metaModelManager.resetLibrary();		// FIXME is this needed; if so test it
//			}
			try {
				metaModelManager.getOclAnyType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOclElementType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOclVoidType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOclInvalidType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getMetaclassType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getBooleanType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getRealType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getIntegerType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getUnlimitedNaturalType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getStringType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getCollectionType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getBagType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getSequenceType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getSetType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOrderedSetType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getEnumerationType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOclTupleType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOclLambdaType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
		}
		super.resolveLazyCrossReferences(mon);
	}

	protected void setHasError(ElementCS csElement) {
		while ((csElement instanceof PathElementCS) || (csElement instanceof PathNameCS)) {
			csElement = csElement.getLogicalParent();
		}
		while (csElement instanceof ExpCS) {
			((ExpCS) csElement).setHasError(true);
			csElement = csElement.getLogicalParent();
			if (!(csElement instanceof NavigationOperatorCS)) {
				break;
			}
		}
	}

	public final void setParserContext(@Nullable ParserContext parserContext) {
		this.parserContext = parserContext;
	}

	public void updateFrom(@NonNull ASResource asResource, @NonNull MetaModelManager metaModelManager) {		
		Map<BaseCSResource, ASResource> cs2PivotResourceMap = new HashMap<BaseCSResource, ASResource>();
		cs2PivotResourceMap.put(this, asResource);
		Pivot2CS pivot2cs = createPivot2CS(cs2PivotResourceMap, metaModelManager);
		pivot2cs.update();
	}
}
