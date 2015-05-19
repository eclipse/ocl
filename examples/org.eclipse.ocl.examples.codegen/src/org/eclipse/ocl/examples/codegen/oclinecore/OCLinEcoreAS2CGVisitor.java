/*******************************************************************************
 * Copyright (c) 2013, 2015 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.oclinecore;

import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

public final class OCLinEcoreAS2CGVisitor extends AS2CGVisitor
{
	protected final @NonNull OCLinEcoreGlobalContext globalContext;
	
	public OCLinEcoreAS2CGVisitor(@NonNull CodeGenAnalyzer analyzer, @NonNull OCLinEcoreGlobalContext globalContext) {
		super(analyzer);
		this.globalContext = globalContext;
		createSeverityOperations(analyzer.getCodeGenerator().getEnvironmentFactory());
	}
	
	private void createSeverityOperations(@NonNull EnvironmentFactoryInternal environmentFactory) {
			// TODO Auto-generated method stub
			
		}

	@Override
	protected void addParameter(@NonNull Variable aParameter, @NonNull CGParameter cgParameter) {
		super.addParameter(aParameter, cgParameter);
		Parameter representedParameter = aParameter.getRepresentedParameter();
		if (representedParameter != null) {
			GenParameter genParameter = genModelHelper.getGenParameter(representedParameter);
			if (genParameter != null) {
				String name = ClassUtil.nonNullState(genParameter.getName());
				cgParameter.setValueName(name);
				// reserve name
			}
		}
	}

	@Override
	public @NonNull CGParameter getParameter(@NonNull Variable aParameter, @Nullable String name) {
		CGParameter cgParameter = super.getParameter(aParameter, name);
		if (PivotConstants.SELF_NAME.equals(aParameter.getName())) {
			cgParameter.setValueName("this");
		}
		return cgParameter;
	}

	@Override
	public @Nullable CGConstraint visitConstraint(@NonNull Constraint element) {
		CGConstraint cgConstraint = CGModelFactory.eINSTANCE.createCGConstraint();
		setAst(cgConstraint, element);
		LanguageExpression specification = element.getOwnedSpecification();
		if (specification != null) {
			try {
				EObject contextElement = ClassUtil.nonNullState(specification.eContainer());
//				if ((specification instanceof ExpressionInOCL) && ((ExpressionInOCL)specification).getOwnedBody() != null) {
//					return (ExpressionInOCL)specification;
//				}
				String expression = specification.getBody();
				if (expression == null) {
					throw new ParserException(PivotMessagesInternal.MissingSpecificationBody_ERROR_, NameUtil.qualifiedNameFor(contextElement), PivotUtilInternal.getSpecificationRole(specification));
				}
				ParserContext parserContext = metamodelManager.createParserContext(specification);
				if (parserContext == null) {
					throw new ParserException(PivotMessagesInternal.UnknownContextType_ERROR_, NameUtil.qualifiedNameFor(contextElement), PivotUtilInternal.getSpecificationRole(specification));
				}
				parserContext.setRootElement(specification);
				if (specification instanceof ExpressionInOCL) {
					Variable diagnosticsVariable = PivotUtil.createVariable("diagnostics", metamodelManager.getStandardLibrary().getOclAnyType(), false, null);
					((ExpressionInOCL)specification).getOwnedParameters().add(diagnosticsVariable);
					Variable contextVariable = PivotUtil.createVariable("context", metamodelManager.getStandardLibrary().getOclAnyType(), false, null);
					((ExpressionInOCL)specification).getOwnedParameters().add(contextVariable);
				}
				String constraintName = element.getName();
				if (constraintName.startsWith("validate")) {
					constraintName = constraintName.substring(8);		// FIXME Use genModel/avoid wrong AS
				}
				EObject eContainer = element.eContainer();
				if (eContainer instanceof NamedElement) {
					String containerName = ((NamedElement)eContainer).getName();
					if (containerName != null) {
						constraintName = containerName + "::" + constraintName;
					}
				}
				expression =
						"let severity = '" + constraintName + "'.getSeverity() in\n" + 
						"if severity <= 0 then true\n" + 
						"else let status = " + expression.trim() + " in '" + constraintName + "'.logDiagnostic(self, diagnostics, context, severity, status, 0)\n" + 
						"endif\n";
				ExpressionInOCL query = parserContext.parse(contextElement, expression);
				OCLinEcoreLocalContext localContext = (OCLinEcoreLocalContext) globalContext.getLocalContext(cgConstraint);
				Variable contextVariable = query.getOwnedContext();
				if (contextVariable != null) {
					CGParameter cgParameter = getParameter(contextVariable, null);
					cgConstraint.getParameters().add(cgParameter);
				}
				for (@SuppressWarnings("null")@NonNull Variable parameterVariable : query.getOwnedParameters()) {
					String diagnosticsName = localContext != null ? localContext.getDiagnosticsName() : null;
					String contextName = localContext != null ? localContext.getContextName() : null;
					CGParameter cgParameter;
					if ((diagnosticsName != null) && diagnosticsName.equals(parameterVariable.getName())) {
						cgParameter = getParameter(parameterVariable, diagnosticsName);
					}
					else if ((contextName != null) && contextName.equals(parameterVariable.getName())) {
						cgParameter = getParameter(parameterVariable, contextName);
					}
					else {
						cgParameter = getParameter(parameterVariable, null);
					}
					cgConstraint.getParameters().add(cgParameter);
				}
				cgConstraint.setBody(doVisit(CGValuedElement.class, query.getOwnedBody()));
			} catch (ParserException e) {
				throw new WrappedException(e);
			}
		}
		return cgConstraint;
	}
}
