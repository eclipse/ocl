/*******************************************************************************
 * Copyright (c) 2007,2013 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   C.Damus(IBM) - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.evaluation;

import java.util.regex.Pattern;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainLogger;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;


/**
 * A decorator for evaluation visitors that is installed when evaluation tracing
 * is enabled, to trace interim evaluation results to the console.
 */
public class TracingEvaluationVisitor extends EvaluationVisitorDecorator {

    /**
     * Initializes me with the visitor whose evaluation I trace to the console.
     * 
     * @param decorated a real evaluation visitor
     */
    public TracingEvaluationVisitor(@NonNull EvaluationVisitor decorated) {
        super(decorated);
    }

	@Override
	public @NonNull EvaluationVisitor createNestedEvaluator() {
		return new TracingEvaluationVisitor(super.createNestedEvaluator());
	}

	public void dispose() {
//		delegate.dispose();
	}

	public @Nullable Object evaluate(@NonNull DomainExpression body) {
		return delegate.evaluate(body);
	}

	public @Nullable Object evaluate(@NonNull ExpressionInOCL expressionInOCL) {
		return delegate.evaluate(expressionInOCL);
	}
	
	public @NonNull EvaluationVisitor getEvaluator() {
		return delegate.getEvaluator();
	}

	public @NonNull IdResolver getIdResolver() {
		return delegate.getIdResolver();
	}

	public @Nullable DomainLogger getLogger() {
		return delegate.getLogger();
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return delegate.getMetaModelManager();
	}

	public @Nullable Monitor getMonitor() {
		return delegate.getMonitor();
	}

	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
		return delegate.getRegexPattern(regex);
	}

	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return delegate.getStandardLibrary();
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value) {
		return delegate.getStaticTypeOf(value);
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return delegate.getStaticTypeOf(value, values);
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		return delegate.getStaticTypeOf(value, values);
	}

	public boolean isCanceled() {
		return delegate.isCanceled();
	}

	public void setCanceled(boolean isCanceled) {
		delegate.setCanceled(isCanceled);
	}

	public void setLogger(@Nullable DomainLogger logger) {
		delegate.setLogger(logger);
	}

	public void setMonitor(@Nullable Monitor monitor) {
		delegate.setMonitor(monitor);
	}
    
    protected @Nullable Object trace(@NonNull Element expression, @Nullable Object value) {
        try {
            PivotPlugin.trace("Evaluate: " + expression); //$NON-NLS-1$
            PivotPlugin.trace("Result  : " + //$NON-NLS-1$
                (value != null ? TypeId.OCL_INVALID_NAME : String.valueOf(value))); //$NON-NLS-1$
        } catch (Exception e) {
            // tracing must not interfere with evaluation
        }
        
        return value;
    }
    
    @Override
    public @Nullable Object visitAssociationClassCallExp(@NonNull AssociationClassCallExp callExp) {
        return trace(callExp, delegate.visitAssociationClassCallExp(callExp));
    }

    @Override
    public @Nullable Object visitBooleanLiteralExp(@NonNull BooleanLiteralExp literalExp) {
        return trace(literalExp, delegate.visitBooleanLiteralExp(literalExp));
    }

    @Override
    public @Nullable Object visitCollectionItem(@NonNull CollectionItem item) {
        return trace(item, delegate.visitCollectionItem(item));
    }

    @Override
    public @Nullable Object visitCollectionLiteralExp(@NonNull CollectionLiteralExp literalExp) {
        return trace(literalExp, delegate.visitCollectionLiteralExp(literalExp));
    }

    @Override
    public @Nullable Object visitCollectionRange(@NonNull CollectionRange range) {
        return trace(range, delegate.visitCollectionRange(range));
    }

    @Override
    public @Nullable Object visitConstraint(@NonNull Constraint constraint) {
        return trace(constraint, delegate.visitConstraint(constraint));
    }

    @Override
	public @Nullable Object visitConstructorExp(@NonNull ConstructorExp constraint) {
        return trace(constraint, delegate.visitConstructorExp(constraint));
    }

    @Override
    public @Nullable Object visitEnumLiteralExp(@NonNull EnumLiteralExp literalExp) {
        return trace(literalExp, delegate.visitEnumLiteralExp(literalExp));
    }

    @Override
    public @Nullable Object visitExpressionInOCL(@NonNull ExpressionInOCL expression) {
        return trace(expression, delegate.visitExpressionInOCL(expression));
    }

    @Override
    public @Nullable Object visitIfExp(@NonNull IfExp ifExp) {
        return trace(ifExp, delegate.visitIfExp(ifExp));
    }

    @Override
    public @Nullable Object visitIntegerLiteralExp(@NonNull IntegerLiteralExp literalExp) {
        return trace(literalExp, delegate.visitIntegerLiteralExp(literalExp));
    }

    @Override
    public @Nullable Object visitInvalidLiteralExp(@NonNull InvalidLiteralExp literalExp) {
        return trace(literalExp, delegate.visitInvalidLiteralExp(literalExp));
    }

    @Override
    public @Nullable Object visitLetExp(@NonNull LetExp letExp) {
        return trace(letExp, delegate.visitLetExp(letExp));
    }

    @Override
    public @Nullable Object visitMessageExp(@NonNull MessageExp messageExp) {
        return trace(messageExp, delegate.visitMessageExp(messageExp));
    }

    @Override
    public @Nullable Object visitNullLiteralExp(@NonNull NullLiteralExp literalExp) {
        return trace(literalExp, delegate.visitNullLiteralExp(literalExp));
    }

    @Override
    public @Nullable Object visitOperationCallExp(@NonNull OperationCallExp callExp) {
        return trace(callExp, delegate.visitOperationCallExp(callExp));
    }

    @Override
    public @Nullable Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp callExp) {
        return trace(callExp, delegate.visitOppositePropertyCallExp(callExp));
    }

    @Override
    public @Nullable Object visitPropertyCallExp(@NonNull PropertyCallExp callExp) {
        return trace(callExp, delegate.visitPropertyCallExp(callExp));
    }

    @Override
    public @Nullable Object visitRealLiteralExp(@NonNull RealLiteralExp literalExp) {
        return trace(literalExp, delegate.visitRealLiteralExp(literalExp));
    }

    @Override
    public @Nullable Object visitStateExp(@NonNull StateExp stateExp) {
        return trace(stateExp, delegate.visitStateExp(stateExp));
    }

    @Override
    public @Nullable Object visitStringLiteralExp(@NonNull StringLiteralExp literalExp) {
        return trace(literalExp, delegate.visitStringLiteralExp(literalExp));
    }

    @Override
    public @Nullable Object visitTupleLiteralExp(@NonNull TupleLiteralExp literalExp) {
        return trace(literalExp, delegate.visitTupleLiteralExp(literalExp));
    }

    @Override
    public @Nullable Object visitTupleLiteralPart(@NonNull TupleLiteralPart part) {
        return trace(part, delegate.visitTupleLiteralPart(part));
    }

    @Override
    public @Nullable Object visitTypeExp(@NonNull TypeExp typeExp) {
        return trace(typeExp, delegate.visitTypeExp(typeExp));
    }

    @Override
    public @Nullable Object visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp literalExp) {
        return trace(literalExp, delegate.visitUnlimitedNaturalLiteralExp(literalExp));
    }

    @Override
    public @Nullable Object visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp unspecExp) {
        return trace(unspecExp, delegate.visitUnspecifiedValueExp(unspecExp));
    }

    @Override
    public @Nullable Object visitVariable(@NonNull Variable variable) {
        return trace(variable, delegate.visitVariable(variable));
    }

    @Override
    public @Nullable Object visitVariableExp(@NonNull VariableExp variableExp) {
        return trace(variableExp, delegate.visitVariableExp(variableExp));
    }
}
