/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.build.fragments;

import java.util.Set;

import org.eclipse.ocl.examples.xtext.base.cs2as.BaseFragmentProvider;
import org.eclipse.ocl.examples.xtext.base.services.PivotResourceServiceProvider;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotLinker;
import org.eclipse.ocl.examples.xtext.base.utilities.PivotDiagnosticConverter;
import org.eclipse.ocl.examples.xtext.base.utilities.PivotResourceValidator;
import org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs.EssentialOCLLocationInFileProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.serializer.EssentialOCLCrossReferenceSerializer;
import org.eclipse.ocl.examples.xtext.essentialocl.serializer.EssentialOCLHiddenTokenSequencer;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingDiagnosticMessageProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLQualifiedNameConverter;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLQualifiedNameProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLValueConverterService;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.autoedit.BaseAutoEditStrategyProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseDocument;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseTerminalsTokenTypeToPartitionMapper;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseURIEditorOpener;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.BaseAntlrTokenToAttributeIdMapper;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLHighlightingConfiguration;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLSemanticHighlightingCalculator;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.NamingAware;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapper;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.validation.ValidatingEditorCallback;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.IResourceValidator;

/**
 * Provide the standard EssentialOCL bindings as Abstract defaults
 */
public class EssentialOCLFragment extends DefaultGeneratorFragment implements NamingAware
{
	public static String getQualifiedName(Grammar grammar, Naming n) {
		return n.basePackageUi(grammar) + "." + GrammarUtil.getName(grammar) + "Editor";
	}

	private Naming naming;

	@SuppressWarnings("restriction")
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		BindFactory bindFactory = new BindFactory();
		bindFactory.addTypeToType(org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer.class.getName(), EssentialOCLCrossReferenceSerializer.class.getName());
		// Potential resolution of Pivot fragments for CS resource
		bindFactory.addTypeToType(IDiagnosticConverter.class.getName(), PivotDiagnosticConverter.class.getName());
		bindFactory.addTypeToType(IFragmentProvider.class.getName(), BaseFragmentProvider.class.getName());
		bindFactory.addTypeToType(org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer.class.getName(), EssentialOCLHiddenTokenSequencer.class.getName());
		bindFactory.addTypeToType(ILinker.class.getName(), CS2PivotLinker.class.getName());
		bindFactory.addTypeToType(ILinkingDiagnosticMessageProvider.class.getName(), EssentialOCLLinkingDiagnosticMessageProvider.class.getName());
		// External reference loading and resolution.
		bindFactory.addTypeToType(ILinkingService.class.getName(), EssentialOCLLinkingService.class.getName());
		// :: as scope separator
		bindFactory.addTypeToType(IQualifiedNameConverter.class.getName(), EssentialOCLQualifiedNameConverter.class.getName());
		// Name value to text serialisation.
		bindFactory.addTypeToType(IQualifiedNameProvider.class.getName(), EssentialOCLQualifiedNameProvider.class.getName());
		// pivot: scheme support
		bindFactory.addTypeToType(IResourceServiceProvider.class.getName(), PivotResourceServiceProvider.class.getName());
		// pivot AST validation support
//		bindFactory.addTypeToType(Diagnostician.class.getName(), PivotCancelableDiagnostician.class.getName());
		bindFactory.addTypeToType(IResourceValidator.class.getName(), PivotResourceValidator.class.getName());
		// DataType text to value parsing.
		bindFactory.addTypeToType(IValueConverterService.class.getName(), EssentialOCLValueConverterService.class.getName());
		bindFactory.addTypeToType(XtextResource.class.getName(), EssentialOCLCSResource.class.getName());
		return bindFactory.getBindings();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		BindFactory bindFactory = new BindFactory();
		bindFactory.addConfiguredBinding(String.class.getName(), "binder.bind(String.class).annotatedWith(com.google.inject.name.Names.named((org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor.COMPLETION_AUTO_ACTIVATION_CHARS))).toInstance(\".,:>\");");
		bindFactory.addTypeToType(AbstractAntlrTokenToAttributeIdMapper.class.getName(), BaseAntlrTokenToAttributeIdMapper.class.getName());
		bindFactory.addTypeToType(AbstractEditStrategyProvider.class.getName(), BaseAutoEditStrategyProvider.class.getName());
		bindFactory.addTypeToType(IHighlightingConfiguration.class.getName(), EssentialOCLHighlightingConfiguration.class.getName());
		bindFactory.addTypeToType(ILocationInFileProvider.class.getName(), EssentialOCLLocationInFileProvider.class.getName());
//		bindFactory.addTypeToType(org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.class.getName(), BaseReferenceFinder.class.getName());
		bindFactory.addTypeToType(ISemanticHighlightingCalculator.class.getName(), EssentialOCLSemanticHighlightingCalculator.class.getName());
		bindFactory.addTypeToType(ITokenTypeToPartitionTypeMapper.class.getName(), BaseTerminalsTokenTypeToPartitionMapper.class.getName());
		bindFactory.addTypeToType(IURIEditorOpener.class.getName(), BaseURIEditorOpener.class.getName());
		bindFactory.addTypeToType(IXtextEditorCallback.class.getName(), ValidatingEditorCallback.class.getName());
		bindFactory.addTypeToType(XtextDocument.class.getName(), BaseDocument.class.getName());
		bindFactory.addTypeToType(XtextEditor.class.getName(), getQualifiedName(grammar, getNaming()));
		return bindFactory.getBindings();
	}

	public Naming getNaming() {
		return naming;
	}

	public void registerNaming(Naming naming) {
		this.naming = naming;
	}
}