/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.build.modelspecs;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CGUtils;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstant;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElementId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEqualsExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInfinity;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInteger;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGReal;
import org.eclipse.ocl.examples.codegen.cgmodel.CGSettableVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGString;
import org.eclipse.ocl.examples.codegen.cgmodel.CGText;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.cse.AbstractPlace;
import org.eclipse.ocl.examples.codegen.cse.CatchPlace;
import org.eclipse.ocl.examples.codegen.cse.ControlPlace;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;
import org.eclipse.ocl.examples.codegen.cse.InnerStackPlace;
import org.eclipse.ocl.examples.codegen.cse.LetPlaces;
import org.eclipse.ocl.examples.codegen.cse.OuterStackPlace;
import org.eclipse.ocl.examples.codegen.cse.IfPlaces;
import org.eclipse.ocl.examples.codegen.cse.ThrowPlace;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * CGValuedElementModelSpec supports generation of the many methods that contribute to the CGValuedElement.xxxx() method hierarchy.
 * <p>
 * The exposition here as a two-dimensional Java table provides a readable, type-checked preserntation that would be harder to achieve
 * using a spreadsheet (poor checking) or a model (no 2D tools).  
 */
public class CGValuedElementModelSpec extends ModelSpec
{
	protected abstract static class MyMethodSpec extends MethodSpec
	{
		public MyMethodSpec(@NonNull Class<?> rootClass, @NonNull String interfaceDecl, @Nullable String variableDecl, @Nullable String comment) {
			super(rootClass, interfaceDecl, variableDecl, comment);
		}

		@Override
		protected final @Nullable String getBody(@NonNull ModelSpec modelSpec) {
			if (modelSpec instanceof CGValuedElementModelSpec) {
				return getBody((CGValuedElementModelSpec)modelSpec);
			}
			else {
				return null;
			}
		}

		protected abstract @Nullable String getBody(@NonNull CGValuedElementModelSpec cgModelSpec);		
	}

	/**
	 * The algorithm options for isBoxed()/isUnboxed()
	 */
	protected static enum Box { BIBOX, DELEG, FALSE, IF, OP, PARAM, RANGE, TRUE }

	/**
	 * The algorithm options for isCommonable()
	 */
	protected static enum Com { FALSE, TRUE }

	/**
	 * The algorithm options for isConstant()
	 */
	protected static enum Con { CPART, DELEG, FALSE, PARTS, ROOT, TORF, TRUE }

	/**
	 * The algorithm options for getPlace()
	 */
	protected static enum Ctl { BODY, CATCH, CNTRL, GLOBL, IF, INNER, LET, THROW, UNSUP }

	/**
	 * The algorithm options for isContext()
	 */
	protected static enum Ctx { FALSE, ROOT, TRUE }

	/**
	 * The algorithm options for getConstantValue()
	 */
	protected static enum Cvl { BOOL, EL_ID, INFTY, INTGR, INVLD, NULL, REAL, ROOT, STRNG, TEXT }

	/**
	 * The algorithm options for isCaught()
	 */
	protected static enum Ct { FALSE, ROOT, TRUE }

	/**
	 * The algorithm options for isGlobal()
	 */
	protected static enum Glo { CPART, DELEG, FALSE, PARTS, ROOT, TRUE }

	/**
	 * The algorithm options for isInlineable()
	 */
	protected static enum Inl { FALSE, ISCON, ROOT, TRUE, T_ID }

	/**
	 * The algorithm options for isInvalid()/isNonInvalid()/setNonInvalid()
	 */
	protected static enum Inv { CPART, FALSE, IF, PARTS, ROOT, TRUE, VAR }

	/**
	 * The algorithm options for isFalse()/isTrue()
	 */
	protected static enum Log { BOOL, DELEG, EQUAL, ISINV, ISUND, FALSE, ROOT }

	/**
	 * The algorithm options for isNonNull()/isNull()/setNonNull()
	 */
	protected static enum Nul { CPART, DELEG, FALSE, FEAT, IF, ROOT, TRUE, VAR }

	/**
	 * The algorithm options for getReferredValue()
	 */
	protected static enum Ref { CPART, DELEG, PARTS, THIS }

	/**
	 * The algorithm options for isSettable()
	 */
	protected static enum Set { FALSE, TRUE }

	/**
	 * The algorithm options for getValue()
	 */
	protected static enum Val { DELEG, REF, ROOT, THIS, TYPEX }
	
	protected static MethodSpec getConstantValue = new MyMethodSpec(CGConstant.class, "@NonNull Object getConstantValue()", null,
		"Return the constant (boxed) value of this element.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Cvl enumValue = modelSpec.cvl;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case BOOL: return "return booleanValue == true;";
					case EL_ID: return "return " + classRef(DomainUtil.class) + ".nonNullState(elementId);";
					case INFTY: return "return " + classRef(ValuesUtil.class) + ".UNLIMITED_VALUE;";
					case INTGR: return "return " + classRef(DomainUtil.class) + ".nonNullState(integerValue);";
					case INVLD: return "return " + classRef(ValuesUtil.class) + ".INVALID_VALUE;";
					case NULL: return "return " + classRef(ValuesUtil.class) + ".NULL_VALUE;";
					case REAL: return "return " + classRef(DomainUtil.class) + ".nonNullState(realValue);";
					case ROOT: return null;
					case STRNG: return "return " + classRef(DomainUtil.class) + ".nonNullState(stringValue);";
					case TEXT: return "return " + classRef(DomainUtil.class) + ".nonNullState(textValue);";
					default: return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
		
	protected static MethodSpec getPlace = new MyMethodSpec(CGElement.class, "@Nullable " + classRef(AbstractPlace.class) + " getPlace(@NonNull " + classRef(Map.class) + "<" + classRef(CGElement.class) + "," + classRef(AbstractPlace.class) + "> element2place)", null,
		"Returns the place for this element, updating and reusing element2place as required.\nAll parent elements have entries in element2place.\nNo child elements have entries in element2place.\nThe global place is accessible as the null element.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Ctl enumValue = modelSpec.ctl;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case BODY: 		return "return " + classRef(OuterStackPlace.class) + ".createPlace(element2place, this, body);";
					case CATCH: 	return "return " + classRef(CatchPlace.class) + ".createPlace(element2place, this);";
					case CNTRL: 	return "return " + classRef(ControlPlace.class) + ".createPlace(element2place, this);";
					case GLOBL: 	return "return " + classRef(GlobalPlace.class) + ".createPlace(element2place, this);";
					case IF: 		return "return " + classRef(IfPlaces.class) + ".createPlaces(element2place, this);";
					case LET: 		return "return " + classRef(LetPlaces.class) + ".createPlaces(element2place, this);";
					case INNER: 	return "return " + classRef(InnerStackPlace.class) + ".createPlace(element2place, this);";
					case THROW: 	return "return " + classRef(ThrowPlace.class) + ".createPlace(element2place, this);";
					case UNSUP: 	return "throw new UnsupportedOperationException();";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};

	protected static MethodSpec getReferredValuedElement = new MyMethodSpec(CGValuedElement.class, "@NonNull " + classRef(CGValuedElement.class) + " getReferredValuedElement()", null,
		"Return the value to which this valuedElement delegates to obtain its value.\nReturns this if no delegation occurs.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Ref enumValue = modelSpec.ref;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case CPART:
						return classRef(CGValuedElement.class) + " first2 = first;\n" +
						"		if (first2 != null) {\n" +
						"			if (first2.isInvalid()) {\n" +
						"				return first2;\n" +
						"			}\n" +
						"			" + classRef(CGValuedElement.class) + " last2 = last;\n" +
						"			if (last2 != null) {\n" +
						"				if (last2.isInvalid()) {\n" +
						"					return last2;\n" +
						"				}\n" +
						"			}\n" +
						"			else {\n" +
						"				return first2;\n" +
						"			}\n" +
						"		}\n" +
						"		return this;";
						case DELEG: 	return "return " + modelSpec.delegate + " != null ? " + modelSpec.delegate + " : this;";
						case PARTS: 
						return "for (" + modelSpec.delegate + " cgPart : getParts()) {\n" +
						"			if (cgPart.isInvalid()) {\n" +
						"				return cgPart;\n" +
						"			}\n" +
						"		}\n" +
						"		return this;";
						case THIS: 		return "return this;";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
	
	protected static MethodSpec getValue = new MyMethodSpec(CGValuedElement.class, "@NonNull " + classRef(CGValuedElement.class) + " getValue()", null,
		"Return the value of this element.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Val enumValue = modelSpec.val;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case DELEG: return null;
					case REF: return "return getReferredValuedElement();";
					case ROOT:
					return classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
					"		if (referredValue == this) {\n" +
					"			return this;\n" +
					"		}\n" +
					"		else {\n" +
					"			return referredValue.getValue();\n" +
					"		}";
					case THIS: return "return this;";
					case TYPEX: return "return referredType.getValue();";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
	
	protected static MethodSpec getValueName = new MyMethodSpec(CGValuedElement.class, "@Nullable String getValueName()", null,
		"Return the declared name value of this element. The text is valid for use in the target language and\nunique within the context in which this element is declared.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Val enumValue = modelSpec.val;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case DELEG: return "return " + modelSpec.delegate + " != null ? " + modelSpec.delegate + ".getValueName() : null;";
					case REF: return null;
					case ROOT:
					return "if (valueName != null) {\n" +
					"			return valueName;\n" +
					"		}\n" +
					"		" + classRef(CGValuedElement.class) + " value = getValue(); // FIXME getReferredValuedElement();\n" +
					"		if (value != this) {\n" +
					"			return value.getValueName();\n" +
					"		}\n" +
					"		return null;";
					case THIS: return null;
					case TYPEX: return null;
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};

	protected static MethodSpec isBoxed = new MyMethodSpec(CGValuedElement.class, "boolean isBoxed()", null,
		"Return true if this value is a boxed value.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Box enumValue = modelSpec.box;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case BIBOX: 	return "return true;";
					case DELEG: 	return classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
									"//		CGValuedElement value = getValue();\n" +
									"		assert referredValue != this : \"isBoxed must be overridden for a \" + getClass().getSimpleName() + \" since referredValue returns this\";\n" +
									"		return referredValue.isBoxed();";
					case FALSE: 	return "return false;";
					case IF: 		return "return thenExpression.isBoxed() || elseExpression.isBoxed();";
					case OP: 		return "return eOperation == null;";
					case PARAM: 	return "return (init != null) ? init.isBoxed() : operation != null ? operation.isBoxed() : true;";
					case RANGE: 	return "return isRange() || first.isBoxed();";
					case TRUE: 		return "return true;";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
		
	protected static MethodSpec isCaught = new MyMethodSpec(CGValuedElement.class, "boolean isCaught()", null,
		"Returns true if any exception associated with this value has been caught and consequently the value may be an InvalidValueException.\nReturns true if any exception has been thrown.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Ct enumValue = modelSpec.ct;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case FALSE: 	return "return false;";
					case ROOT: 		return "return caught;";
					case TRUE: 		return "return true;";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
		
		protected static MethodSpec isCommonable = new MyMethodSpec(CGValuedElement.class, "boolean isCommonable()", null,
			"Return true if this value can be shared as part of a Common Subexpression.")
			{
				@Override
				protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
					Com enumValue = modelSpec.com;
					if (enumValue == null) {
						return null;
					}
					switch (enumValue) {
						case FALSE: return "return false;";
						case TRUE: return "return true;";
						default: 		return "MISSING_CASE_for_" + enumValue + ";";
					}
				}
			};

	protected static MethodSpec isConstant = new MyMethodSpec(CGValuedElement.class, "boolean isConstant()", null,
		"Return true if this value is a local constant (dependent of the user type system).")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Con enumValue = modelSpec.con;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case CPART: return "return first.isConstant() && ((last == null) || last.isConstant());";
					case DELEG: return "return (" + modelSpec.delegate + " != null) && " + modelSpec.delegate + ".isConstant();";
					case FALSE: 	return "return false;";
					case PARTS:
					return "for (" + modelSpec.delegate + " cgPart : getParts()) {\n" +
					"			if (!cgPart.isConstant()) {\n" +
					"				return false;\n" +
					"			}\n" +
					"		}\n" +
					"		return true;";
					case ROOT:
					return classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
					"		return (referredValue != this) && referredValue.isConstant();";
					case TORF: return "return isFalse() || isTrue();";
					case TRUE: 		return "return true;";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
		
/*	protected static MethodSpec isControlledChild = new MyMethodSpec(CGElement.class, "boolean isControlledChild(@NonNull " + classRef(CGElement.class) + " cgElement)", null,
		"Returns true if the cgElement has a control dependency on this element.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Ctl enumValue = modelSpec.ctl;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case FALSE: 	return "return false;";
					case IF: 		return "return (cgElement == thenExpression) || (cgElement == elseExpression);";
					case LET: 		return "return cgElement == in;";
					case LOOP: 		return "return cgElement == body;";
					case TRUE: 		return "return true;";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		}; */
		
	protected static MethodSpec isContext = new MyMethodSpec(CGElement.class, "boolean isContext()", null,
		"Returns true if this node may have its own symbol name context.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Ctx enumValue = modelSpec.ctx;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case FALSE: 	return "return false;";
					case TRUE: 		return "return true;";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};

	protected static MethodSpec isFalse = new MyMethodSpec(CGValuedElement.class, "boolean isFalse()", null,
		"Return true if this value is false.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Log enumValue = modelSpec.log;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case BOOL: 	return "return booleanValue == false;";
					case DELEG: return "return (" + modelSpec.delegate + " != null) && " + modelSpec.delegate + ".isConstant() && !" + modelSpec.delegate + ".isTrue();";	
// FIXME Why not	case DELEG: return "return (" + modelSpec.delegate + " != null) && " + modelSpec.delegate + ".isFalse();";	
					case EQUAL: return "return (source != null) && (argument != null) && source.isConstant() && argument.isConstant() && !source.equals(argument);";
					case ISINV: return "return (source != null) && source.isNonInvalid();";
					case ISUND: return "return (source != null) && source.isNonInvalid() && source.isNonNull();";
					case FALSE: return "return false;";
					case ROOT: 	return classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
						"		return (referredValue != this) && referredValue.isFalse();";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
			
	protected static MethodSpec isGlobal = new MyMethodSpec(CGValuedElement.class, "boolean isGlobal()", null,
		"Return true if this value is a global constant (independent of the user type system).")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Glo enumValue = modelSpec.glo;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case CPART: return "return first.isGlobal() && ((last == null) || last.isGlobal());";
					case DELEG: return "return (" + modelSpec.delegate + " != null) && " + modelSpec.delegate + ".isGlobal();";
					case FALSE: return "return false;";
					case PARTS:
					return "for (" + modelSpec.delegate + " cgPart : getParts()) {\n" +
					"			if (!cgPart.isGlobal()) {\n" +
					"				return false;\n" +
					"			}\n" +
					"		}\n" +
					"		return true;";
					case ROOT: 
					return "for (" + classRef(CGValuedElement.class) + " cgElement : getDependsOn()) {\n" +
					"			if (!cgElement.isGlobal()) {\n" +
					"				return false;\n" +
					"			}\n" +
					"		}\n" +
					"		" + classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
					"		return (referredValue != this) && referredValue.isGlobal();";
					case TRUE: return "return true;";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
	
	protected static MethodSpec isInlineable = new MyMethodSpec(CGValuedElement.class, "boolean isInlineable()", null,
		"Return true if this value can be inlined as an expression term.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Inl enumValue = modelSpec.inl;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case FALSE: return "return false;";
					case ISCON: return "return isConstant();";
					case ROOT: 
					return classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
					"		return (referredValue != this) && referredValue.isInlineable();";
					case TRUE: return "return true;";
					case T_ID: return "return (elementId != null) && " + classRef(CGUtils.class) + ".isInlineableId(elementId);";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
	
	protected static MethodSpec isInvalid = new MyMethodSpec(CGValuedElement.class, "boolean isInvalid()", null,
		"Return true if this value is false.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Inv enumValue = modelSpec.inv;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case CPART: return "return first.isInvalid() || ((last != null) && last.isInvalid());";
					case FALSE: return "return false;";
					case IF: return "return condition.isInvalid() || (condition.isTrue() ? thenExpression.isInvalid() : condition.isFalse() ? elseExpression.isInvalid() : thenExpression.isInvalid() && elseExpression.isInvalid());";
					case PARTS:
					return "for (" + modelSpec.delegate + " cgPart : getParts()) {\n" +
					"			if (cgPart.isInvalid()) {\n" +
					"				return true;\n" +
					"			}\n" +
					"		}\n" +
					"		return false;";
					case ROOT: 	return classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
						"		return (referredValue != this) && referredValue.isInvalid();";
					case TRUE: return "return true;";
					case VAR: return "return !nonInvalid && super.isInvalid();";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
	
	protected static MethodSpec isNonInvalid = new MyMethodSpec(CGValuedElement.class, "boolean isNonInvalid()", null,
		"Return true if this value is false.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Inv enumValue = modelSpec.inv;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case CPART: return "return first.isNonInvalid() && ((last == null) || last.isNonInvalid());";
					case FALSE: return "return true;";
					case IF: return "return condition.isTrue() ? thenExpression.isNonInvalid() : condition.isFalse() ? elseExpression.isNonInvalid() : thenExpression.isNonInvalid() && elseExpression.isNonInvalid();";
					case PARTS:
					return "for (" + modelSpec.delegate + " cgPart : getParts()) {\n" +
					"			if (!cgPart.isNonInvalid()) {\n" +
					"				return false;\n" +
					"			}\n" +
					"		}\n" +
					"		return true;";
					case ROOT: 	return classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
						"		return (referredValue != this) && referredValue.isNonInvalid();";
					case TRUE: return "return false;";
					case VAR: return "return nonInvalid || super.isNonInvalid();";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
	
	protected static MethodSpec isNonNull = new MyMethodSpec(CGValuedElement.class, "boolean isNonNull()", null,
		"Return true if this value is not null.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Nul enumValue = modelSpec.nul;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case CPART: return "return first.isNonNull() || ((last != null) && last.isNonNull());";
					case DELEG: return "return (" + modelSpec.delegate + " != null) && " + modelSpec.delegate + ".isRequired();";
					case FALSE: return "return true;";
					case FEAT: return "return (" + modelSpec.delegate + " != null) && (" + modelSpec.delegate + ".isRequired()  || " + modelSpec.delegate + ".isMany());";
					case IF: return "return condition.isTrue() ? thenExpression.isNonNull() : condition.isFalse() ? elseExpression.isNonNull() : thenExpression.isNonNull() && elseExpression.isNonNull();";
					case ROOT: 	return classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
						"		return (referredValue != this) && referredValue.isNonNull();";
					case TRUE: return "return false;";
					case VAR: return "return nonNull || super.isNonNull();";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
	
	protected static MethodSpec isNull = new MyMethodSpec(CGValuedElement.class, "boolean isNull()", null,
		"Return true if this value is null.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Nul enumValue = modelSpec.nul;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case CPART: return "return first.isNull() && (last == null);";
					case DELEG: return "return false;";
					case FALSE: return "return false;";
					case FEAT: return "return false;";
					case IF: return "return condition.isTrue() ? thenExpression.isNull() : condition.isFalse() ? elseExpression.isNull() : thenExpression.isNull() && elseExpression.isNull();";
					case ROOT: 	return classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
						"		return (referredValue != this) && referredValue.isNull();";
					case TRUE: return "return true;";
					case VAR: return "return !nonNull && super.isNull();";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
	
	protected static MethodSpec isRange = new MyMethodSpec(CGCollectionPart.class, "boolean isRange()", null,
		"Return true if this is a collection range.")
	{
		@Override
		protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
			if (modelSpec.cgClass != rootClass) {
				return null;
			}
			return "return last != null;";
		}
	};
	
	protected static MethodSpec isSettable = new MyMethodSpec(CGValuedElement.class, "boolean isSettable()", null,
		"Return true if this value can be inlined as an expression term.")
	{
		@Override
		protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
			Set enumValue = modelSpec.set;
			if (enumValue == null) {
				return null;
			}
			switch (enumValue) {
				case FALSE: return "return false;";
				case TRUE: return "return true;";
				default: 		return "MISSING_CASE_for_" + enumValue + ";";
			}
		}
	};

	protected static MethodSpec isTrue = new MyMethodSpec(CGValuedElement.class, "boolean isTrue()", null,
		"Return true if this value is true.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Log enumValue = modelSpec.log;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case BOOL: 	return "return booleanValue == true;";
					case DELEG: return "return (" + modelSpec.delegate + " != null) && " + modelSpec.delegate + ".isTrue();";
					case EQUAL: return "return (source != null) && (argument != null) && source.isConstant() && argument.isConstant() && source.equals(argument);";
					case FALSE: return "return false;";
					case ISINV: return "return (source != null) && source.isInvalid();";
					case ISUND: return "return (source != null) && (source.isInvalid() || source.isNull());";
					case ROOT:
					return classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
					"		return (referredValue != this) && referredValue.isTrue();";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
	
	protected static MethodSpec isUnboxed = new MyMethodSpec(CGValuedElement.class, "boolean isUnboxed()", null,
		"Return true if this value is an unboxed value.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
				Box enumValue = modelSpec.box;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case BIBOX: 	return "return true;";
					case DELEG: 	return classRef(CGValuedElement.class) + " referredValue = getReferredValuedElement();\n" +
									"//		CGValuedElement value = getValue();\n" +
									"		assert referredValue != this : \"isUnboxed must be overridden for a \" + getClass().getSimpleName() + \" since referredValue returns this\";\n" +
									"		return referredValue.isUnboxed();";
					case FALSE: 	return "return true;";
					case IF: 		return "return thenExpression.isUnboxed() && elseExpression.isUnboxed();";
					case OP: 		return "return eOperation != null;";
					case PARAM: 	return "return (init != null) ? init.isUnboxed() : operation != null ? operation.isUnboxed() : false;";
					case RANGE: 	return "return isRange() || first.isUnboxed();";
					case TRUE: 		return "return false;";
					default: 		return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};
	
	protected static MethodSpec setCaught = new MyMethodSpec(CGValuedElement.class, "void setCaught(boolean isCaught)", "boolean caught = false",
		"Set the caught status.")
	{
		@Override
		protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
			Ct enumValue = modelSpec.ct;
			if (enumValue == null) {
				return null;
			}
			switch (enumValue) {
				case FALSE: 	return "assert !isCaught;";
				case ROOT: 		return "caught = isCaught;";
				case TRUE: 		return "assert isCaught;";
				default: 		return "MISSING_CASE_for_" + enumValue + ";";
			}
		}
	};
	
	protected static MethodSpec setNonInvalid = new MyMethodSpec(CGVariable.class, "void setNonInvalid()", "boolean nonInvalid = false",
		"Set the non-invalid status.")
	{
		@Override
		protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
			if (modelSpec.cgClass != rootClass) {
				return null;
			}
			return "nonInvalid = true;";
		}
	};
	
	protected static MethodSpec setNonNull = new MyMethodSpec(CGVariable.class, "void setNonNull()", "boolean nonNull = false",
		"Set the non-null status.")
	{
		@Override
		protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
			if (modelSpec.cgClass != rootClass) {
				return null;
			}
			return "nonNull = true;";
		}
	};
	
	protected static MethodSpec setValueName = new MyMethodSpec(CGValuedElement.class, "void setValueName(@NonNull String valueName)", "String valueName = null",
		"Set the name of the value.")
	{
		@Override
		protected @Nullable String getBody(@NonNull CGValuedElementModelSpec modelSpec) {
			if (modelSpec.cgClass != rootClass) {
				return null;
			}
			return "this.valueName = valueName;";
		}
	};
	
	// FIXME why is CGUnboxExpr CON.FALSE
	// FIXME Why isNonNull FEAT isMany
	public static void register() {
		new CGValuedElementModelSpec(CGElement.class, null,							null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , Ctx.TRUE , Ctl.GLOBL, null     );

		new CGValuedElementModelSpec(CGValuedElement.class, null,					Box.DELEG, Ref.THIS , Log.ROOT , Nul.ROOT , Inv.ROOT , Glo.ROOT , Inl.ROOT , Set.FALSE, Ct.ROOT , Con.ROOT , Val.ROOT , null     , Ctx.FALSE, Ctl.CNTRL, Com.TRUE );

		new CGValuedElementModelSpec(CGConstant.class, null,						Box.BIBOX, Ref.THIS , Log.FALSE, Nul.FALSE, Inv.FALSE, Glo.TRUE , Inl.FALSE, null     , null    , Con.TRUE , Val.THIS , Cvl.ROOT , null     , null     , Com.FALSE);
		new CGValuedElementModelSpec(CGBoolean.class, "booleanValue",				null     , null     , Log.BOOL , null     , null     , null     , Inl.TRUE , null     , null    , null     , null     , Cvl.BOOL , null     , null     , null     );
		new CGValuedElementModelSpec(CGInfinity.class, null,						Box.TRUE , null     , null     , null     , null     , null     , Inl.TRUE , null     , null    , null     , null     , Cvl.INFTY, null     , null     , null     );
		new CGValuedElementModelSpec(CGInteger.class, null,							Box.TRUE , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , Cvl.INTGR, null     , null     , null     );
		new CGValuedElementModelSpec(CGInvalid.class, null,							null     , null     , null     , null     , Inv.TRUE , null     , Inl.TRUE , null     , null    , null     , null     , Cvl.INVLD, null     , null     , null     );
		new CGValuedElementModelSpec(CGNull.class, null,							null     , null     , null     , Nul.TRUE , null     , null     , Inl.TRUE , null     , null    , null     , null     , Cvl.NULL , null     , null     , null     );
		new CGValuedElementModelSpec(CGReal.class, null,							Box.TRUE , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , Cvl.REAL , null     , null     , null     );
		new CGValuedElementModelSpec(CGString.class, null,							null     , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , Cvl.STRNG, null     , null     , null     );
		new CGValuedElementModelSpec(CGText.class, null,							null     , null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , Cvl.TEXT , null     , null     , Com.TRUE );
		new CGValuedElementModelSpec(CGElementId.class, null,						Box.TRUE , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , Cvl.EL_ID, null     , null     , null     );
		new CGValuedElementModelSpec(CGTypeId.class, null,							null     , null     , null     , null     , null     , null     , Inl.T_ID , null     , null    , null     , null     , null     , null     , null     , null     );

		new CGValuedElementModelSpec(CGCallExp.class, null,							null     , null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , Val.THIS , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGBoxExp.class, "source",						Box.TRUE , Ref.DELEG, null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGCatchExp.class, "source",					null     , Ref.DELEG, null     , null     , null     , null     , null     , Set.TRUE , Ct.TRUE , null     , null     , null     , null     , Ctl.CATCH, null     );
		new CGValuedElementModelSpec(CGEqualsExp.class, null,						Box.TRUE , null     , Log.EQUAL, Nul.FALSE, Inv.FALSE, null     , null     , null     , Ct.FALSE, null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGGuardExp.class, "source",					null     , Ref.DELEG, null     , Nul.FALSE, null,      null     , null     , null     , null    , null     , Val.REF  , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGIsInvalidExp.class, "source",				Box.BIBOX, Ref.DELEG, Log.ISINV, Nul.FALSE, Inv.FALSE, null     , Inl.ISCON, null     , Ct.FALSE, Con.TORF , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGIsUndefinedExp.class, "source",				Box.BIBOX, Ref.DELEG, Log.ISUND, Nul.FALSE, Inv.FALSE, null     , Inl.ISCON, null     , Ct.FALSE, Con.TORF , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGThrowExp.class, "source",					null     , Ref.DELEG, null     , null     , null     , null     , null     , null     , Ct.FALSE, null     , Val.REF  , null     , null     , Ctl.THROW, null     );
		new CGValuedElementModelSpec(CGUnboxExp.class, "source",					Box.FALSE, Ref.DELEG, null     , null     , null     , null     , null     , null     , null    , Con.FALSE, null     , null     , null     , null     , null     );

		new CGValuedElementModelSpec(CGIterationCallExp.class, "referredIteration",	null     , null     , null     , Nul.DELEG, null     , null     , null     , null     , null    , null     , null     , null     , null     , Ctl.INNER, null     );
		new CGValuedElementModelSpec(CGBuiltInIterationCallExp.class, null,			Box.TRUE , null     , null     , null     , null     , null     , null     , Set.TRUE , Ct.FALSE, null     , Val.THIS , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGLibraryIterateCallExp.class, null,			Box.TRUE , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGLibraryIterationCallExp.class, null,			Box.TRUE , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );

		new CGValuedElementModelSpec(CGOperationCallExp.class, "referredOperation",	null     , null     , null     , Nul.FEAT , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGEcoreOperationCallExp.class, null,			Box.FALSE, null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGExecutorOperationCallExp.class, null,		Box.TRUE , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGLibraryOperationCallExp.class, null,			Box.TRUE , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		
		new CGValuedElementModelSpec(CGPropertyCallExp.class, "referredProperty",	null     , null     , null     , Nul.FEAT , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGEcorePropertyCallExp.class, null,			Box.FALSE, null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGExecutorPropertyCallExp.class, null,			Box.FALSE, null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGLibraryPropertyCallExp.class, null,			Box.TRUE , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGTuplePartCallExp.class, null,				Box.TRUE , null     , null     , null     , Inv.FALSE, null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );

		new CGValuedElementModelSpec(CGConstructorExp.class, "CGConstructorPart",	null     , Ref.PARTS, null     , Nul.FALSE, null     , Glo.PARTS, null     , null     , null    , Con.PARTS, null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGEcoreClassConstructorExp.class, null,		Box.FALSE, null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , Con.FALSE, null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGEcoreDataTypeConstructorExp.class, null,		Box.FALSE, null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );

		new CGValuedElementModelSpec(CGVariable.class, "init",						null     , Ref.DELEG, null     , Nul.VAR  , Inv.VAR  , null     , null     , null     , null    , null     , null     , null     , null     , null     , Com.FALSE);
		new CGValuedElementModelSpec(CGFinalVariable.class, null,					null     , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGLocalVariable.class, null,					null     , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGSettableVariable.class, null,				null     , null     , null     , null     , null     , null     , null     , null     , null    , null     , Val.THIS , null     , null     , null     , null     );

		new CGValuedElementModelSpec(CGParameter.class, "init",						Box.PARAM, null     , null     , null     , Inv.FALSE, Glo.DELEG, null     , null     , null    , Con.DELEG, Val.THIS , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGCastParameter.class, "referredParameter",	null     , Ref.DELEG, null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGIterator.class, null,						null     , null     , null     , null     , null     , Glo.FALSE, null     , Set.TRUE , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGTextParameter.class, null,					Box.FALSE, Ref.THIS , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );

		new CGValuedElementModelSpec(CGCollectionExp.class, "CGCollectionPart",		Box.TRUE , Ref.PARTS, null     , Nul.FALSE, Inv.PARTS, Glo.PARTS, null     , null     , null    , Con.PARTS, null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGCollectionPart.class, null,					Box.RANGE, Ref.CPART, null     , Nul.CPART, Inv.CPART, Glo.CPART, null     , null     , null    , Con.CPART, null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGConstantExp.class, "referredConstant",		null     , Ref.DELEG, null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGConstructorPart.class, null,					Box.TRUE , Ref.THIS , null     , null     , null     , Glo.FALSE, null     , null     , null    , Con.FALSE, null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGExecutorOperation.class, null,				Box.TRUE , null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , Con.TRUE , Val.THIS , null     , Ctx.TRUE , Ctl.UNSUP, null     );
		new CGValuedElementModelSpec(CGExecutorProperty.class, null,				Box.TRUE , null     , null     , Nul.FALSE, Inv.FALSE, Glo.FALSE, null     , null     , null    , Con.TRUE , Val.THIS , null     , Ctx.TRUE , Ctl.UNSUP, null     );
		new CGValuedElementModelSpec(CGExecutorType.class, null,					Box.TRUE , null     , null     , Nul.FALSE, Inv.FALSE, Glo.FALSE, null     , null     , null    , Con.TRUE , Val.THIS , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGIfExp.class, null,							Box.IF   , Ref.THIS , null     , Nul.IF   , Inv.IF   , Glo.FALSE, null     , Set.TRUE , null    , null     , null     , null     , null     , Ctl.IF   , null     );
		new CGValuedElementModelSpec(CGLetExp.class, "in",							null     , Ref.DELEG, null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , Ctl.LET  , null     );
		new CGValuedElementModelSpec(CGOperation.class, null,						Box.OP   , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , Ctx.TRUE , Ctl.BODY , null     );
		new CGValuedElementModelSpec(CGProperty.class, null,						Box.TRUE , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , Ctx.TRUE , Ctl.BODY , null     );
		new CGValuedElementModelSpec(CGTupleExp.class, "CGTuplePart",				Box.TRUE , Ref.PARTS, null     , Nul.FALSE, Inv.FALSE, Glo.PARTS, null     , null     , null    , Con.PARTS, null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGTuplePart.class, "init",						Box.TRUE , Ref.DELEG, null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGTypeExp.class, "referredType",				Box.TRUE , Ref.DELEG, null     , null     , null     , null     , null     , null     , null    , null     , Val.TYPEX, null     , null     , null     , null     );
		new CGValuedElementModelSpec(CGVariableExp.class, "referredVariable",		null     , Ref.DELEG, null     , null     , null     , null     , null     , null     , null    , null     , Val.DELEG, null     , null     , null     , Com.FALSE);
	}
	
	protected final @Nullable String delegate;
	protected final @Nullable Box box;
	protected final @Nullable Ref ref;
	protected final @Nullable Log log;
	protected final @Nullable Nul nul;
	protected final @Nullable Inv inv;
	protected final @Nullable Glo glo;
	protected final @Nullable Inl inl;
	protected final @Nullable Set set;
	protected final @Nullable Ct ct;
	protected final @Nullable Con con;
	protected final @Nullable Val val;
	protected final @Nullable Cvl cvl;
	protected final @Nullable Ctx ctx;
	protected final @Nullable Ctl ctl;
	protected final @Nullable Com com;
	
	protected CGValuedElementModelSpec(@NonNull Class<?> cgClass, @Nullable String delegate,
			@Nullable Box box, @Nullable Ref ref, @Nullable Log log, @Nullable Nul nul, @Nullable Inv inv,
			@Nullable Glo glo, @Nullable Inl inl, @Nullable Set set, @Nullable Ct ct, @Nullable Con con,
			@Nullable Val val, @Nullable Cvl cvl, @Nullable Ctx ctx, @Nullable Ctl ctl, @Nullable Com com) {
		super(cgClass);
		this.delegate = delegate;
		this.box = box;
		this.ref = ref;
		this.log = log;
		this.nul = nul;
		this.inv = inv;
		this.glo = glo;
		this.inl = inl;
		this.set = set;
		this.ct = ct;
		this.con = con;
		this.val = val;
		this.cvl = cvl;
		this.ctx = ctx;
		this.ctl = ctl;
		this.com = com;
	}
	
	@Override
	public void generate(@NonNull StringBuilder s, @NonNull GenModel genModel, boolean isImplementation) {
		getConstantValue.generate(s, this, genModel, isImplementation);
		getPlace.generate(s, this, genModel, isImplementation);
		getReferredValuedElement.generate(s, this, genModel, isImplementation);
		getValue.generate(s, this, genModel, isImplementation);
		getValueName.generate(s, this, genModel, isImplementation);
		isBoxed.generate(s, this, genModel, isImplementation);
		isCaught.generate(s, this, genModel, isImplementation);
		isCommonable.generate(s, this, genModel, isImplementation);
		isConstant.generate(s, this, genModel, isImplementation);
		isContext.generate(s, this, genModel, isImplementation);
		isFalse.generate(s, this, genModel, isImplementation);
		isGlobal.generate(s, this, genModel, isImplementation);
		isInlineable.generate(s, this, genModel, isImplementation);
		isInvalid.generate(s, this, genModel, isImplementation);
		isNonInvalid.generate(s, this, genModel, isImplementation);
		isNonNull.generate(s, this, genModel, isImplementation);
		isNull.generate(s, this, genModel, isImplementation);
		isRange.generate(s, this, genModel, isImplementation);
		isSettable.generate(s, this, genModel, isImplementation);
		isTrue.generate(s, this, genModel, isImplementation);
		isUnboxed.generate(s, this, genModel, isImplementation);
		setCaught.generate(s, this, genModel, isImplementation);
		setNonInvalid.generate(s, this, genModel, isImplementation);
		setNonNull.generate(s, this, genModel, isImplementation);
		setValueName.generate(s, this, genModel, isImplementation);
	}
}
