/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.GlobalContext;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;

/**
 * A JavaGlobalContext maintains the Java-specific global context for generation of code.
 */
public abstract class JavaGlobalContext extends AbstractJavaContext implements GlobalContext
{
	protected final @NonNull NameManager nameManager;
	
	private @NonNull Map<CGElement, JavaLocalContext> localContexts = new HashMap<CGElement, JavaLocalContext>();
	private @NonNull Set<CGValuedElement> globals = new HashSet<CGValuedElement>();
	private @NonNull Set<String> imports = new HashSet<String>();
//	private @NonNull Map<EClass, JavaTypeDescriptor> eClass2descriptor = new HashMap<EClass, JavaTypeDescriptor>();
	
	protected final @NonNull String eName;
	protected final @NonNull String evaluateName;
	protected final @NonNull String instanceName;
	protected final @NonNull String selfName;

	public JavaGlobalContext(@NonNull JavaCodeGenerator codeGenerator) {
		super(codeGenerator);
		this.nameManager = codeGenerator.getNameManager();
		this.eName = nameManager.reserveName(JavaConstants.E_NAME, null);
		this.evaluateName = nameManager.reserveName(JavaConstants.EVALUATE_NAME, null);
		this.instanceName = nameManager.reserveName(JavaConstants.INSTANCE_NAME, null);
		this.selfName = nameManager.reserveName(JavaConstants.SELF_NAME, null);
	}

	protected boolean addGlobal(@NonNull CGValuedElement cgGlobal) {
//		if (cgGlobal instanceof CGCollectionPart) {
//			System.out.println(cgGlobal);
//		}
		if (cgGlobal.isInlineable()) {
			return false;
		}
		return globals.add(cgGlobal);
	}

	public void addImport(@NonNull String className) {
		imports.add(className);
	}

	protected abstract @NonNull JavaLocalContext createNestedContext(@NonNull CGElement cgScope);

	public @Nullable EClass getEClass(@NonNull ElementId elementId) {
		IdVisitor<EClass> id2EClassVisitor = codeGenerator.getId2EClassVisitor();
		return elementId.accept(id2EClassVisitor);
	}

/*	public @Nullable EClass getEClass(@NonNull CGValuedElement cgElement) {
		CGTypeId cgTypeId = DomainUtil.nonNullState(cgElement.getTypeId());
		JavaTypeDescriptor javaTypeDescriptor = typeId2descriptor.get(cgTypeId);
		if (javaTypeDescriptor == null) {
			javaTypeDescriptor = JavaTypeDescriptor.create(codeGenerator.getMetaModelManager(), cgTypeId);
			typeId2descriptor.put(cgTypeId, javaTypeDescriptor);
//			ElementId elementId = cgTypeId.getElementId();
//			if (elementId != null) {
//				if (cgElement.isNonInvalid() || (!cgElement.isCaught() && !cgElement.getValue().isCaught())) {
//					return getEClass(elementId);
//				}
//			}
		}
		return javaTypeDescriptor.getEClass();
	} */

	public @NonNull String getEName() {
		return eName;
	}

	public @NonNull String getEvaluateName() {
		return evaluateName;
	}

	public @NonNull Collection<CGValuedElement> getGlobals() {
		return globals;
	}

	public @NonNull Set<String> getImports() {
		return imports;
	}

	public @NonNull String getInstanceName() {
		return instanceName;
	}

	public @Nullable JavaLocalContext getLocalContext(@NonNull CGElement cgElement) {
		JavaLocalContext localContext = localContexts.get(cgElement);
		if (localContext == null) {
			CGElement cgScope = cgElement;
			CGIterationCallExp cgIterationScope = null;
			for (; cgScope != null; cgScope = cgScope.getParent()) {
				if (cgScope instanceof CGIterationCallExp) {
					cgIterationScope = (CGIterationCallExp)cgScope;
					localContext = localContexts.get(cgScope);
					if (localContext != null) {
						break;
					}
				}
				if (cgScope.isContext()) {
					break;
				}
			}
			if (cgScope == null) {
				return null;
			}
			if (localContext == null) {
				localContext = localContexts.get(cgScope);
				if (localContext == null) {
					localContext = createNestedContext(cgScope);
					localContexts.put(cgScope, localContext);
				}
				if (cgIterationScope != null) {
					localContext = localContext.createNestedContext(cgIterationScope);
					localContexts.put(cgIterationScope, localContext);
				}
			}
			localContexts.put(cgElement, localContext);
		}
		return localContext;
	}

	public @NonNull NameManager getNameManager() {
		return nameManager;
	}

	public @NonNull String getSelfName() {
		return selfName;
	}

	public @NonNull String getValueName(@NonNull CGValuedElement cgValuedElement) {
		JavaLocalContext localContext = getLocalContext(cgValuedElement);
		if (localContext != null) {
			return localContext.getValueName(cgValuedElement);
		}
		else {
			CGValuedElement cgValue = cgValuedElement.getValue();
			String valueName = cgValue.getValueName();
			if (valueName == null) {
				valueName = nameManager.getGlobalSymbolName(cgValue, cgValue.getName());
				cgValue.setValueName(valueName);
			}
			return valueName;
		}
	}
}