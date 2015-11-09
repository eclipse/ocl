/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.util.XtextSwitch;

public final class XtextAbstractElementLabelGenerator extends AbstractLabelGenerator<AbstractElement>
{
	private class Xtext2String extends XtextSwitch<Object>
	{
		protected final @NonNull Builder labelBuilder;
		
		public Xtext2String(@NonNull Builder labelBuilder) {
			this.labelBuilder = labelBuilder;
		}
		
		@Override
		public Object caseAbstractRule(AbstractRule object) {
			String name = object.getName();
			if (name != null) {
				labelBuilder.appendString(name);
				return this;
			}
			return null;
		}

		@Override
		public Object caseAction(Action object) {
			String feature = object.getFeature();
			String operator = object.getOperator();
			TypeRef type = object.getType();
			labelBuilder.appendString("{");
			if (type != null) {
				labelBuilder.appendString(type.getClassifier().getName());
			}
			if (feature != null) {
				labelBuilder.appendString(".");
				labelBuilder.appendString(feature);
			}
			if (operator != null) {
				labelBuilder.appendString(operator);
				labelBuilder.appendString("current");
			}
			labelBuilder.appendString("}");
			labelBuilder.appendString(object.getCardinality());
			return this;
		}

		@Override
		public Object caseAlternatives(Alternatives object) {
			labelBuilder.appendString("(");
			boolean isFirst = true;
			for (AbstractElement element : object.getElements()) {
				if (!isFirst) {
					labelBuilder.appendString(" | ");
				}
				doSwitch(element);
				isFirst = false;
			}
			labelBuilder.appendString(")");
			labelBuilder.appendString(object.getCardinality());
			return this;
		}

		@Override
		public Object caseAssignment(Assignment object) {
			String feature = object.getFeature();
			if (feature != null) {
				labelBuilder.appendString(feature);
			}
			String operator = object.getOperator();
			if (operator != null) {
				labelBuilder.appendString(operator);
			}
			AbstractElement terminal = object.getTerminal();
			if (terminal != null) {
				doSwitch(terminal);
				labelBuilder.appendString(object.getCardinality());
				return this;
			}
			return null;
		}

		@Override
		public Object caseGroup(Group object) {
			labelBuilder.appendString("(");
			boolean isFirst = true;
			for (AbstractElement element : object.getElements()) {
				if (!isFirst) {
					labelBuilder.appendString(" ");
				}
				doSwitch(element);
				isFirst = false;
			}
			labelBuilder.appendString(")");
			labelBuilder.appendString(object.getCardinality());
			return this;
		}

		@Override
		public Object caseKeyword(Keyword object) {
			String value = object.getValue();
			if (value != null) {
				labelBuilder.appendString("'");
				labelBuilder.appendString(value);
				labelBuilder.appendString("'");
				labelBuilder.appendString(object.getCardinality());
				return this;
			}
			return null;
		}

		@Override
		public Object caseRuleCall(RuleCall object) {
			AbstractRule rule = object.getRule();
			if (rule != null) {
				doSwitch(rule);
				labelBuilder.appendString(object.getCardinality());
				return this;
			}
			return null;
		}

		@Override
		public Object defaultCase(EObject object) {
			labelBuilder.appendString(object.getClass().getSimpleName());
			return this;
		}

	}
	
	public static void initialize(Registry registry) {
		registry.install(AbstractElement.class, new XtextAbstractElementLabelGenerator());		
	}
	
	public XtextAbstractElementLabelGenerator() {
		super(AbstractElement.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull AbstractElement object) {
		new Xtext2String(labelBuilder).doSwitch(object);
	}
}