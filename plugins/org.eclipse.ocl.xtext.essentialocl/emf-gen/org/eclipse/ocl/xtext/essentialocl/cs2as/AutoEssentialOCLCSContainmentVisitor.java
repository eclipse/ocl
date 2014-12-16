/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.ocl.xtext.essentialocl.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.NewBaseCSContainmentVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.AssociationClassCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ConstructorExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.OperationCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrimitiveLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PropertyCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor;

public class AutoEssentialOCLCSContainmentVisitor
	extends NewBaseCSContainmentVisitor
	implements EssentialOCLCSVisitor<Continuation<?>>
{
    protected final @NonNull CS2AS converter;
    protected final @NonNull IdResolver idResolver;
    
    /**
     * Initializes me with an initial value for my result.
     * 
     * @param context my initial result value
     */
    public AutoEssentialOCLCSContainmentVisitor(@NonNull CS2ASConversion context) {
        super(context);
        this.converter = context.getConverter();
        this.idResolver = converter.getMetaModelManager().getIdResolver();
    }
    
    @Override
    public @Nullable Continuation<?> visitAbstractNameExpCS(@NonNull AbstractNameExpCS self) {
        throw new UnsupportedOperationException("visitAbstractNameExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitAssociationClassCallExpCS(@NonNull AssociationClassCallExpCS self) {
        throw new UnsupportedOperationException("visitAssociationClassCallExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitBooleanLiteralExpCS(@NonNull BooleanLiteralExpCS self) {
        throw new UnsupportedOperationException("visitBooleanLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitCallExpCS(@NonNull CallExpCS self) {
        throw new UnsupportedOperationException("visitCallExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitCollectionLiteralExpCS(@NonNull CollectionLiteralExpCS self) {
        throw new UnsupportedOperationException("visitCollectionLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitCollectionLiteralPartCS(@NonNull CollectionLiteralPartCS self) {
        throw new UnsupportedOperationException("visitCollectionLiteralPartCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitCollectionPatternCS(@NonNull CollectionPatternCS self) {
        throw new UnsupportedOperationException("visitCollectionPatternCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitCollectionTypeCS(@NonNull CollectionTypeCS self) {
        throw new UnsupportedOperationException("visitCollectionTypeCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitConstructorExpCS(@NonNull ConstructorExpCS self) {
        throw new UnsupportedOperationException("visitConstructorExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitConstructorPartCS(@NonNull ConstructorPartCS self) {
        throw new UnsupportedOperationException("visitConstructorPartCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitContextCS(@NonNull ContextCS self) {
        throw new UnsupportedOperationException("visitContextCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitCurlyBracketedClauseCS(@NonNull CurlyBracketedClauseCS self) {
        throw new UnsupportedOperationException("visitCurlyBracketedClauseCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitExpCS(@NonNull ExpCS self) {
        throw new UnsupportedOperationException("visitExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitExpSpecificationCS(@NonNull ExpSpecificationCS self) {
        throw new UnsupportedOperationException("visitExpSpecificationCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitIfExpCS(@NonNull IfExpCS self) {
        throw new UnsupportedOperationException("visitIfExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitIfThenExpCS(@NonNull IfThenExpCS self) {
        throw new UnsupportedOperationException("visitIfThenExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitInfixExpCS(@NonNull InfixExpCS self) {
        throw new UnsupportedOperationException("visitInfixExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitInvalidLiteralExpCS(@NonNull InvalidLiteralExpCS self) {
        throw new UnsupportedOperationException("visitInvalidLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitIterateCallExpCS(@NonNull IterateCallExpCS self) {
        throw new UnsupportedOperationException("visitIterateCallExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitIterationCallExpCS(@NonNull IterationCallExpCS self) {
        throw new UnsupportedOperationException("visitIterationCallExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitLambdaLiteralExpCS(@NonNull LambdaLiteralExpCS self) {
        throw new UnsupportedOperationException("visitLambdaLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitLetExpCS(@NonNull LetExpCS self) {
        throw new UnsupportedOperationException("visitLetExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitLetVariableCS(@NonNull LetVariableCS self) {
        throw new UnsupportedOperationException("visitLetVariableCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitLiteralExpCS(@NonNull LiteralExpCS self) {
        throw new UnsupportedOperationException("visitLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitNameExpCS(@NonNull NameExpCS self) {
        throw new UnsupportedOperationException("visitNameExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitNavigatingArgCS(@NonNull NavigatingArgCS self) {
        throw new UnsupportedOperationException("visitNavigatingArgCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitNestedExpCS(@NonNull NestedExpCS self) {
        throw new UnsupportedOperationException("visitNestedExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitNullLiteralExpCS(@NonNull NullLiteralExpCS self) {
        throw new UnsupportedOperationException("visitNullLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitNumberLiteralExpCS(@NonNull NumberLiteralExpCS self) {
        throw new UnsupportedOperationException("visitNumberLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitOperationCallExpCS(@NonNull OperationCallExpCS self) {
        throw new UnsupportedOperationException("visitOperationCallExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitOperatorExpCS(@NonNull OperatorExpCS self) {
        throw new UnsupportedOperationException("visitOperatorExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPatternExpCS(@NonNull PatternExpCS self) {
        throw new UnsupportedOperationException("visitPatternExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPrefixExpCS(@NonNull PrefixExpCS self) {
        throw new UnsupportedOperationException("visitPrefixExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPrimitiveLiteralExpCS(@NonNull PrimitiveLiteralExpCS self) {
        throw new UnsupportedOperationException("visitPrimitiveLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitPropertyCallExpCS(@NonNull PropertyCallExpCS self) {
        throw new UnsupportedOperationException("visitPropertyCallExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitRoundBracketedClauseCS(@NonNull RoundBracketedClauseCS self) {
        throw new UnsupportedOperationException("visitRoundBracketedClauseCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitSelfExpCS(@NonNull SelfExpCS self) {
        throw new UnsupportedOperationException("visitSelfExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitSquareBracketedClauseCS(@NonNull SquareBracketedClauseCS self) {
        throw new UnsupportedOperationException("visitSquareBracketedClauseCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitStringLiteralExpCS(@NonNull StringLiteralExpCS self) {
        throw new UnsupportedOperationException("visitStringLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTupleLiteralExpCS(@NonNull TupleLiteralExpCS self) {
        throw new UnsupportedOperationException("visitTupleLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTupleLiteralPartCS(@NonNull TupleLiteralPartCS self) {
        throw new UnsupportedOperationException("visitTupleLiteralPartCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTypeLiteralExpCS(@NonNull TypeLiteralExpCS self) {
        throw new UnsupportedOperationException("visitTypeLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitTypeNameExpCS(@NonNull TypeNameExpCS self) {
        throw new UnsupportedOperationException("visitTypeNameExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitUnlimitedNaturalLiteralExpCS(@NonNull UnlimitedNaturalLiteralExpCS self) {
        throw new UnsupportedOperationException("visitUnlimitedNaturalLiteralExpCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitVariableCS(@NonNull VariableCS self) {
        throw new UnsupportedOperationException("visitVariableCS is not supported by " + getClass().getName());
    }
    
    @Override
    public @Nullable Continuation<?> visitVariableExpCS(@NonNull VariableExpCS self) {
        throw new UnsupportedOperationException("visitVariableExpCS is not supported by " + getClass().getName());
    }
}
