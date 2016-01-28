package org.eclipse.ocl.examples.autogen.lookup;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

public class LookupExportedVisitorCodeGenerator extends LookupVisitorsCodeGenerator{

	protected final @NonNull Operation asElementExportedEnvOperation;
	
	protected Property asImporterProperty;
	
	private @Nullable CGProperty cgImporterProperty = null;
	
	protected LookupExportedVisitorCodeGenerator(
			@NonNull EnvironmentFactoryInternal environmentFactory,
			@NonNull Package asPackage, @Nullable Package asSuperPackage,
			@NonNull Package asBasePackage, @NonNull GenPackage genPackage,
			@Nullable GenPackage superGenPackage,
			@Nullable GenPackage baseGenPackage) {
		super(environmentFactory, asPackage, asSuperPackage, asBasePackage, genPackage,
			superGenPackage, baseGenPackage);
		org.eclipse.ocl.pivot.Class asOclElement = metamodelManager.getStandardLibrary().getOclElementType();
		CompleteClass asElementCompleteClass = metamodelManager.getCompletePackage(metamodelManager.getStandardLibrary().getPackage()).getCompleteClass(asOclElement);
		OperationId exportedEnvOperationId = asOclElement.getTypeId().getOperationId(0, LookupVisitorsClassContext.EXPORTED_ENV_NAME, IdManager.getParametersId(asOclElement.getTypeId()));
		asElementExportedEnvOperation = ClassUtil.nonNullState(asElementCompleteClass.getOperation(exportedEnvOperationId));
	}
	
	@Override
	protected @NonNull AutoCG2JavaVisitor<@NonNull ? extends AutoCodeGenerator> createCG2JavaVisitor(
			@NonNull CGPackage cgPackage,
			@Nullable List<CGValuedElement> sortedGlobals) {
		return new LookupExportedCG2JavaVisitor(this, cgPackage, sortedGlobals);
	}
	
	@Override
	protected @NonNull String getLookupVisitorClassName(@NonNull String prefix) {
		return prefix + "ExportedLookupVisitor";
	}
	
	@Override
	protected List<Property> createAdditionalASProperties() {
		Type asOclElement = metamodelManager.getStandardLibrary().getOclElementType(); 
		this.asImporterProperty = createNativeProperty(LookupVisitorsClassContext.INMPORTER_NAME, asOclElement, true);
		return Collections.singletonList(asImporterProperty);
	}

	
	@Override
	protected boolean isRewrittenOperation(Operation operation) {
		return LookupVisitorsClassContext.EXPORTED_ENV_NAME.equals(operation.getName())
				&& operation != asElementExportedEnvOperation
				&& operation.getOwnedParameters().size() == 1;
	}

	/**
	 * Convert  'Element'::_exported_env(importer : Element) : Environment 
	 * to XXXXXExportedLookupVisitor::visit'Element'(element : 'Element') : Environment
	 * 
	 * with
	 *   - self accessed as element.
	 *   - importer parameter accessed as this.importer.
	 *   - LookupEnvironment{} rewritten as this.context ...
	 *   
	 * @throws ParserException 
	 */
	@Override
	protected @NonNull Operation createVisitOperationDeclaration(
			Map<Element, Element> reDefinitions, Operation operation) {
		ExpressionInOCL envExpressionInOCL = getExpressionInOCL(operation);
		//
		org.eclipse.ocl.pivot.Class asType = ClassUtil.nonNullState(operation.getOwningClass());
		Variable asElement = PivotUtil.createVariable(LookupVisitorsClassContext.ELEMENT_NAME, asType, true, null);
		reDefinitions.put(envExpressionInOCL.getOwnedContext(), asElement);
		//
		VariableExp asImporterSource = createThisVariableExp(asThisVariable);
		PropertyCallExp asImporterAccess = PivotUtil.createPropertyCallExp(asImporterSource, ClassUtil.nonNull(asImporterProperty));
		Variable asImporter = PivotUtil.createVariable(LookupVisitorsClassContext.CHILD_NAME, asImporterAccess);
		reDefinitions.put(envExpressionInOCL.getOwnedParameters().get(0), asImporter);
		
		//rewrite LookupEnvironment ShadowExp as accessing the context variable (it might be the init of let variable)
		VariableExp asContextAccess = createThisVariableExp(asContextVariable);
		OCLExpression body = envExpressionInOCL.getOwnedBody();
		OCLExpression rewrittenExp = body instanceof ShadowExp ? body : ((LetExp)body).getOwnedVariable().getOwnedInit() ;
		reDefinitions.put(rewrittenExp, asContextAccess);
		
		//
		Operation asOperation = createVisitorOperation("visit" + asType.getName(), operation.getType());
		reDefinitions.put(operation, asOperation);
		return asOperation;
	}

	@Override
	protected void trackCGProperty(Property asProperty, CGProperty cgProperty) {
		if (asProperty == asImporterProperty) {
			cgImporterProperty = cgProperty;
		}
	}
	
	public @NonNull CGProperty getImporterProperty() {
		return ClassUtil.nonNullState(cgImporterProperty);
	}
}
