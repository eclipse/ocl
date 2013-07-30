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
package org.eclipse.ocl.examples.codegen.analyzer;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstant;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElementId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInfinity;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInteger;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGReal;
import org.eclipse.ocl.examples.codegen.cgmodel.CGString;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cse.CommonSubexpressionEliminator;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;

/**
 * A CodeGenAnalyzer performs the analysis of a Pivot AST in preparation for code generation.
 * <p>
 * Pass 1: Pivot2CGAnalysisVisitor
 * <br>
 * Each Pivot Element is converted to a CGElement
 * <br>
 * This conversion creates objects such as CGLibraryOperationCallEXp that are more atuned to CG
 * and provides a tree that can be rewritten by optimizations.
 * <p>
 * Pass 2: CGPreAnalysisVisitor
 * <br>
 * Traversal of the CG containment tree performs
 * <br>
 * constant folding
 * <p>
 * <p>
 * Pass N-1: CG2JavaPreVisitor
 * <br>
 * Traversal of the CG containment tree prepares for Java CG by
 * <br>
 * gathering imports
 * <p>
 * Pass N: CG2JavaVisitor
 * <br>
 * Traversal of the CG containment tree emits code
 */
public class CodeGenAnalyzer
{
	protected final @NonNull CodeGenerator codeGenerator;
	protected final @NonNull NameManager nameManager;
	private @NonNull Map<ElementId, CGElementId> cgElementIds = new HashMap<ElementId, CGElementId>();
	protected final @NonNull CGBoolean cgFalse;
	protected final @NonNull CGBoolean cgTrue;
	private /*@LazyNonNull*/ CGInfinity cgInfinity = null;
	private /*@LazyNonNull*/ CGInvalid cgInvalid = null;
	protected final @NonNull CGNull cgNull;
	private final @NonNull Map<Number, CGInteger> cgIntegers = new HashMap<Number, CGInteger>();
	private final @NonNull Map<OperationId, CGExecutorOperation> cgOperations = new HashMap<OperationId, CGExecutorOperation>();
	private final @NonNull Map<PropertyId, CGExecutorProperty> cgProperties = new HashMap<PropertyId, CGExecutorProperty>();
	private final @NonNull Map<PropertyId, CGExecutorConstructorPart> cgParts = new HashMap<PropertyId, CGExecutorConstructorPart>();
	private final @NonNull Map<Number, CGReal> cgReals = new HashMap<Number, CGReal>();
	private final @NonNull Map<String, CGString> cgStrings = new HashMap<String, CGString>();

	public CodeGenAnalyzer(@NonNull CodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
		this.nameManager = codeGenerator.getNameManager();
		cgFalse = createCGBoolean(false);
		cgTrue = createCGBoolean(true);
		cgNull = createCGNull();
	}

	public void analyze(@NonNull CGElement cgRoot) {
		AnalysisVisitor analysisVisitor = codeGenerator.createAnalysisVisitor();
		cgRoot.accept(analysisVisitor);
		//
		BoxingAnalyzer boxingAnalyzer = codeGenerator.createBoxingAnalyzer();
		cgRoot.accept(boxingAnalyzer);
		//
		FieldingAnalyzer fieldingAnalyzer = codeGenerator.createFieldingAnalyzer();
		fieldingAnalyzer.analyze(cgRoot, false);
		//
		CommonSubexpressionEliminator cseEliminator = codeGenerator.createCommonSubexpressionEliminator();
		cseEliminator.optimize(cgRoot);
	}

	public @NonNull CGConstantExp createCGConstantExp(@NonNull OCLExpression element, @NonNull CGConstant constant) {
		CGConstantExp cgLiteralExp = CGModelFactory.eINSTANCE.createCGConstantExp();
		cgLiteralExp.setPivot(element);
		cgLiteralExp.setReferredConstant(constant);
		cgLiteralExp.setTypeId(getTypeId(element.getTypeId()));
		return cgLiteralExp;
	}

	protected @NonNull CGBoolean createCGBoolean(boolean booleanValue) {
		CGBoolean cgBoolean = CGModelFactory.eINSTANCE.createCGBoolean();
		setExplicitNames(cgBoolean, booleanValue);
		cgBoolean.setBooleanValue(booleanValue);
		cgBoolean.setTypeId(getTypeId(TypeId.BOOLEAN));
		return cgBoolean;
	}

	protected @NonNull CGNull createCGNull() {
		CGNull cgNull = CGModelFactory.eINSTANCE.createCGNull();
		setExplicitNames(cgNull, null);
		cgNull.setTypeId(getTypeId(TypeId.OCL_VOID));
		return cgNull;
	}

	public @NonNull CodeGenerator getCodeGenerator() {
		return codeGenerator;
	}
	
	public @NonNull CGBoolean getBoolean(boolean aBoolean) {
		return aBoolean ? cgTrue : cgFalse;
	}

	public @NonNull CGElementId getElementId(@NonNull ElementId elementId) {
		CGElementId cgElementId = cgElementIds.get(elementId);
		if (cgElementId == null) {
			if (elementId instanceof TypeId) {
				return getTypeId((TypeId)elementId);
			}
			cgElementId = CGModelFactory.eINSTANCE.createCGElementId();
			cgElementId.setElementId(elementId);
			setNames(cgElementId, elementId);
			cgElementIds.put(elementId, cgElementId);
		}
		return cgElementId;
	}

	public @NonNull CGExecutorOperation getExecutorOperation(@NonNull Operation pivotOperation) {
		OperationId operationId = pivotOperation.getOperationId();
		CGExecutorOperation cgOperation = cgOperations.get(operationId);
		if (cgOperation == null) {
			cgOperation = CGModelFactory.eINSTANCE.createCGExecutorOperation();
			CGElementId cgOperationId = getElementId(operationId);
			cgOperation.setUnderlyingOperationId(cgOperationId);
			cgOperation.setPivot(pivotOperation);
			cgOperation.setName(nameManager.getGlobalSymbolName(pivotOperation));
			cgOperation.setValueName(cgOperation.getName());
			cgOperations.put(operationId, cgOperation);
			cgOperation.getDependsOn().add(cgOperationId);
		}
		return cgOperation;
	}

	public @NonNull CGExecutorOperation getExecutorOperation(@NonNull OperationId operationId) {
		return DomainUtil.nonNullState(cgOperations.get(operationId));
	}

	public @NonNull CGExecutorConstructorPart getExecutorConstructorPart(@NonNull Property pivotProperty) {
		PropertyId propertyId = pivotProperty.getPropertyId();
		CGExecutorConstructorPart cgPart = cgParts.get(propertyId);
		if (cgPart == null) {
			cgPart = CGModelFactory.eINSTANCE.createCGExecutorConstructorPart();					
			CGElementId cgPropertyId = getElementId(propertyId);
			cgPart.setUnderlyingPropertyId(cgPropertyId);
			cgPart.setPivot(pivotProperty);
			cgPart.setName(nameManager.getGlobalSymbolName(cgPart, "CTORid_" + pivotProperty.getName()));
			cgPart.setValueName(cgPart.getName());
			cgParts.put(propertyId, cgPart);
			cgPart.getDependsOn().add(cgPropertyId);
		}
		return cgPart;
	}

	public @NonNull CGExecutorConstructorPart getExecutorConstructorPart(@NonNull PropertyId propertyId) {
		return DomainUtil.nonNullState(cgParts.get(propertyId));
	}

	public @NonNull CGExecutorProperty getExecutorProperty(@NonNull Property pivotProperty) {
		PropertyId propertyId = pivotProperty.getPropertyId();
		CGExecutorProperty cgProperty = cgProperties.get(propertyId);
		if (cgProperty == null) {
			CGElementId cgPropertyId = getElementId(propertyId);
			Property pivotOppositeProperty = pivotProperty.getOpposite();
			if (pivotOppositeProperty != null) {
				if (pivotOppositeProperty.isComposite()) {
					cgPropertyId = getElementId(propertyId);
					cgProperty = CGModelFactory.eINSTANCE.createCGExecutorCompositionProperty();					
				}
				else if (pivotProperty.isImplicit()){
					cgPropertyId = getElementId(pivotOppositeProperty.getPropertyId());
					cgProperty = CGModelFactory.eINSTANCE.createCGExecutorOppositeProperty();					
				}
			}
			if (cgProperty == null) {
				cgProperty = CGModelFactory.eINSTANCE.createCGExecutorNavigationProperty();					
			}
			cgProperty.setUnderlyingPropertyId(cgPropertyId);
			cgProperty.setPivot(pivotProperty);
			cgProperty.setName(nameManager.getGlobalSymbolName(cgProperty, "IMPPROPid_" + pivotProperty.getName()));
			cgProperty.setValueName(cgProperty.getName());
			cgProperties.put(propertyId, cgProperty);
			cgProperty.getDependsOn().add(cgPropertyId);
		}
		return cgProperty;
	}

	public @NonNull CGExecutorProperty getExecutorProperty(@NonNull PropertyId propertyId) {
		return DomainUtil.nonNullState(cgProperties.get(propertyId));
	}

	public @NonNull CGValuedElement getExpression(@Nullable CGValuedElement cgExpression) {
		if (cgExpression == null) {
			CGConstantExp cgLiteralExp = CGModelFactory.eINSTANCE.createCGConstantExp();
//			cgLiteralExp.setPivot(element);
			cgLiteralExp.setReferredConstant(cgInvalid);
			cgLiteralExp.setTypeId(getTypeId(TypeId.OCL_INVALID));
			cgExpression = cgLiteralExp;
		};
		return cgExpression;
	}

	public @NonNull CGInfinity getInfinity() {
		CGInfinity cgInfinity2 = cgInfinity;
		if (cgInfinity2 == null) {
			cgInfinity = cgInfinity2 = CGModelFactory.eINSTANCE.createCGInfinity();
			setNames(cgInfinity2, ValuesUtil.UNLIMITED_VALUE);
			cgInfinity2.setTypeId(getTypeId(TypeId.UNLIMITED_NATURAL));
		}
		return cgInfinity2;
	}

	public @NonNull CGInteger getInteger(@NonNull Number aNumber) {
		CGInteger cgInteger = cgIntegers.get(aNumber);
		if (cgInteger == null) {
			cgInteger = CGModelFactory.eINSTANCE.createCGInteger();
			setNames(cgInteger, aNumber);
			cgInteger.setIntegerValue(aNumber);
			cgInteger.setTypeId(getTypeId(TypeId.INTEGER));
			cgIntegers.put(aNumber, cgInteger);
		}
		return cgInteger;
	}

	public @NonNull CGInvalid getInvalid() {
		CGInvalid cgInvalid2 = cgInvalid;
		if (cgInvalid2 == null) {
			cgInvalid = cgInvalid2 = CGModelFactory.eINSTANCE.createCGInvalid();
//			cgInvalid.setPivot(ValuesUtil.INVALID_VALUE);
			setNames(cgInvalid2, ValuesUtil.INVALID_VALUE);
			cgInvalid2.setTypeId(getTypeId(TypeId.OCL_INVALID));
		}
		return cgInvalid2;
	}

	public @NonNull CGInvalid getInvalid(/*@NonNull*/ String messageTemplate, Object... bindings) {
		CGInvalid cgInvalid = CGModelFactory.eINSTANCE.createCGInvalid();
		setNames(cgInvalid, ValuesUtil.INVALID_VALUE);
		cgInvalid.setTypeId(getTypeId(TypeId.OCL_INVALID));
		cgInvalid.setMessageTemplate(messageTemplate);
		for (Object binding : bindings) {
			cgInvalid.getBindings().add(binding);
		}
		return cgInvalid;
	}

	public @NonNull CGNull getNull() {
		return cgNull;
	}

	public @NonNull CGReal getReal(@NonNull Number aNumber) {
		CGReal cgReal = cgReals.get(aNumber);
		if (cgReal == null) {
			cgReal = CGModelFactory.eINSTANCE.createCGReal();
			setNames(cgReal, aNumber);
			cgReal.setRealValue(aNumber);
			cgReal.setTypeId(getTypeId(TypeId.REAL));
			cgReals.put(aNumber, cgReal);
		}
		return cgReal;
	}

	public @NonNull CGString getString(@NonNull String aString) {
		CGString cgString = cgStrings.get(aString);
		if (cgString == null) {
			cgString = CGModelFactory.eINSTANCE.createCGString();
			setNames(cgString, aString);
			cgString.setStringValue(aString);
			cgString.setTypeId(getTypeId(TypeId.STRING));
			cgStrings.put(aString, cgString);
		}
		return cgString;
	}

	public @NonNull NameManager getNameManager() {
		return DomainUtil.nonNullState(nameManager);
	}

	public @NonNull CGTypeId getTypeId(@NonNull TypeId typeId) {
		CGElementId cgElementId = cgElementIds.get(typeId);
		CGTypeId cgTypeId = (CGTypeId)cgElementId;
		if (cgTypeId == null) {
			cgTypeId = CGModelFactory.eINSTANCE.createCGTypeId();
			cgTypeId.setElementId(typeId);
			cgTypeId.setName(nameManager.getGlobalSymbolName(typeId));
			cgTypeId.setValueName(cgTypeId.getName());
			cgElementIds.put(typeId, cgTypeId);
		}
		return cgTypeId;
	}

	public void setConstant(@NonNull CGValuedElement oldElement, @Nullable CGValuedElement aConstant) {
		CGConstantExp newElement = CGModelFactory.eINSTANCE.createCGConstantExp();		// FIXME wrapper not needed
		newElement.setReferredConstant(aConstant);
		newElement.setTypeId(oldElement.getTypeId());
		newElement.setPivot(oldElement.getPivot());
		CGUtils.replace(oldElement, newElement);		
	}

	public void setExplicitNames(@NonNull CGValuedElement cgValue, @Nullable Object anObject) {
		String name = nameManager.getExplicitName(anObject);
		cgValue.setName(name);
		cgValue.setValueName(name);
	}

	public void setNames(@NonNull CGValuedElement cgValue, @NonNull Object anObject) {
		String name = nameManager.getGlobalSymbolName(anObject);
		cgValue.setName(name);
		cgValue.setValueName(name);
	}
}
