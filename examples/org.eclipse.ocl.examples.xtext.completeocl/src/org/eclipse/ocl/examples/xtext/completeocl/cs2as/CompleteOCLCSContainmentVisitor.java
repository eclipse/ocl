/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.completeocl.cs2as;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.util.AbstractCompleteOCLCSContainmentVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.attributes.AbstractOperationFilter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;

public class CompleteOCLCSContainmentVisitor extends AbstractCompleteOCLCSContainmentVisitor
{
	public class OperationDeclScopeFilter extends AbstractOperationFilter
	{
		private final @NonNull List<ParameterCS> csParameters;
		
		public OperationDeclScopeFilter(@Nullable Type sourceType, @NonNull List<ParameterCS> csParameters) {
			super(sourceType);
			this.csParameters = csParameters;
		}

		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			if (object instanceof Iteration) {
				return false;
			}
			if (object instanceof Operation) {
				Operation candidateOperation = (Operation)object;
				List<Parameter> candidateParameters = candidateOperation.getOwnedParameter();
				int iMax = csParameters.size();
				if (iMax != candidateParameters.size()) {
					return false;
				}
				Map<TemplateParameter, ParameterableElement> bindings = getOperationBindings(metaModelManager, candidateOperation);
				for (int i = 0; i < iMax; i++) {
					Parameter candidateParameter = candidateParameters.get(i);
					if (candidateParameter != null) {
						ParameterCS csParameter = csParameters.get(i);
						if (csParameter == null) {
							return false;
						}
						TypedRefCS csType = csParameter.getOwnedType();
						Type pType = PivotUtil.getPivot(Type.class, csType);
						if (pType == null) {
							return false;
						}
						Type candidateType = PivotUtil.getType(candidateParameter);
						pType = PivotUtil.getType(pType);			// FIXME make this a general facility
						if ((candidateType == null) || !metaModelManager.conformsTo(pType, candidateType, bindings)) {
							return false;
						}
					}
				}
				if (bindings != null) {
					installBindings(environmentView, object, bindings);
				}
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	/**
	 * Mapping from the complemented package to the complementing package for each complementing package, excluding
	 * the root complementing model.
	 */
	private Map<org.eclipse.ocl.examples.pivot.Package, org.eclipse.ocl.examples.pivot.Package> modelPackage2contextPackage =
			new HashMap<org.eclipse.ocl.examples.pivot.Package, org.eclipse.ocl.examples.pivot.Package>();
	
	/**
	 * Mapping from the complemented type to the complementing types for each complemented type.
	 */
	private Map<org.eclipse.ocl.examples.pivot.Class, List<org.eclipse.ocl.examples.pivot.Class>> modelType2contextTypes = new HashMap<org.eclipse.ocl.examples.pivot.Class, List<org.eclipse.ocl.examples.pivot.Class>>();
	
	/**
	 * Mapping from the complemented type to the list of complementing operations for each complementing type.
	 */
	private Map<Type, List<Operation>> modelType2contextOperations = new HashMap<Type, List<Operation>>();
	
	/**
	 * Mapping from the complemented type to the list of complementing properties for each complementing type.
	 */
	private Map<Type, List<Property>> modelType2contextProperties = new HashMap<Type, List<Property>>();

	/**
	 * Mapping from the complemented element to the list of constraints for that element.
	 */
	private Map<Operation, List<Constraint>> operation2postconditions = new HashMap<Operation, List<Constraint>>();
	private Map<Operation, List<Constraint>> operation2preconditions = new HashMap<Operation, List<Constraint>>();
	private Map<Property, List<Constraint>> property2invariants = new HashMap<Property, List<Constraint>>();
	private Map<Type, List<Constraint>> type2invariants = new HashMap<Type, List<Constraint>>();

	public CompleteOCLCSContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	protected void installOperationContainment(@NonNull Type modelType, @NonNull Type contextType) {
		List<Operation> newContextOperations = modelType2contextOperations.get(modelType);
		List<Operation> oldContextOperations = contextType.getOwnedOperation();
		if ((newContextOperations == null) || newContextOperations.isEmpty()) {
			if (!oldContextOperations.isEmpty()) {
				oldContextOperations.clear();
			}
		}
		else {
			PivotUtil.refreshList(oldContextOperations, newContextOperations);
			for (Operation contextOperation : newContextOperations) {
				assert contextOperation != null;
				PivotUtil.refreshList(contextOperation.getPrecondition(), operation2preconditions.get(contextOperation));
				PivotUtil.refreshList(contextOperation.getPostcondition(), operation2postconditions.get(contextOperation));
			}
		}
	}

	protected void installPackageContainment(@NonNull Root contextRoot) {
		Map<org.eclipse.ocl.examples.pivot.Package, Set<org.eclipse.ocl.examples.pivot.Package>> nestedContextPackageMaps =
				new HashMap<org.eclipse.ocl.examples.pivot.Package, Set<org.eclipse.ocl.examples.pivot.Package>>();
		Set<org.eclipse.ocl.examples.pivot.Package> nestedContextRoots = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
		for (org.eclipse.ocl.examples.pivot.Package modelPackage : modelPackage2contextPackage.keySet()) {
			org.eclipse.ocl.examples.pivot.Package contextPackage = modelPackage2contextPackage.get(modelPackage);
			org.eclipse.ocl.examples.pivot.Package parentModelPackage = modelPackage.getNestingPackage();
			if (parentModelPackage != null) {
				org.eclipse.ocl.examples.pivot.Package parentContextPackage = modelPackage2contextPackage.get(parentModelPackage);
				if (parentContextPackage != null) {
					Set<org.eclipse.ocl.examples.pivot.Package> nestedContextPackages = nestedContextPackageMaps.get(parentContextPackage);
					if (nestedContextPackages == null) {
						nestedContextPackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
						nestedContextPackageMaps.put(parentContextPackage, nestedContextPackages);
//						nestedContextPackages.addAll(parentContextPackage.getNestedPackage());
					}
					nestedContextPackages.add(contextPackage);
				}
			}
			else {
				EObject modelPackageContainer = modelPackage.eContainer();
				if (modelPackageContainer instanceof Root) {
					nestedContextRoots.add(contextPackage);
				}
			}
		}
		for (org.eclipse.ocl.examples.pivot.Package parentContextPackage : nestedContextPackageMaps.keySet()) {
			List<Package> nestedNestedPackages = parentContextPackage.getNestedPackage();
			Set<org.eclipse.ocl.examples.pivot.Package> nestedContextPackages = nestedContextPackageMaps.get(parentContextPackage);
			assert nestedNestedPackages != null;
			assert nestedContextPackages != null;
			PivotUtil.refreshSet(nestedNestedPackages, nestedContextPackages);
		}
		List<Package> nestedPackages = contextRoot.getNestedPackage();
		assert nestedPackages != null;
		PivotUtil.refreshSet(nestedPackages, nestedContextRoots);
	}

	protected void installPropertyContainment(@NonNull Type modelType, @NonNull Type contextType, @NonNull List<Constraint> allInvariants) {
		List<Property> contextProperties = modelType2contextProperties.get(modelType);
		if (contextProperties == null) {
			contextType.getOwnedAttribute().clear();
		}
		else {
			PivotUtil.refreshList(contextType.getOwnedAttribute(), contextProperties);
			for (Property contextProperty : contextProperties) {
				assert contextProperty != null;
				List<Constraint> derivedInvariants = property2invariants.get(contextProperty);
//				contextProperty.setDefaultExpression((derivations != null) && (derivations.size() > 0) ? derivations.get(0) : null);
				if (derivedInvariants != null) {
					allInvariants.addAll(derivedInvariants);
				}
			}
		}
	}

	protected void installTypeContainment() {
		Map<org.eclipse.ocl.examples.pivot.Package, Set<org.eclipse.ocl.examples.pivot.Class>> nestedContextTypeMaps =
				new HashMap<org.eclipse.ocl.examples.pivot.Package, Set<org.eclipse.ocl.examples.pivot.Class>>();
		for (org.eclipse.ocl.examples.pivot.Class modelType : modelType2contextTypes.keySet()) {
			for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.examples.pivot.Class contextType : modelType2contextTypes.get(modelType)) {
				org.eclipse.ocl.examples.pivot.Package parentModelPackage = modelType.getPackage();
				org.eclipse.ocl.examples.pivot.Package parentContextPackage = modelPackage2contextPackage.get(parentModelPackage);
				Set<org.eclipse.ocl.examples.pivot.Class> ownedTypes = nestedContextTypeMaps.get(parentContextPackage);
				if (ownedTypes == null) {
					ownedTypes = new HashSet<org.eclipse.ocl.examples.pivot.Class>();
					nestedContextTypeMaps.put(parentContextPackage, ownedTypes);
//					ownedTypes.addAll(parentContextPackage.getOwnedType());
				}
				ownedTypes.add(contextType);
				installOperationContainment(modelType, contextType);
				List<Constraint> allInvariants = new ArrayList<Constraint>();
				List<Constraint> typeInvariants = type2invariants.get(contextType);
				if (typeInvariants != null) {
					allInvariants.addAll(typeInvariants);
				}
				installPropertyContainment(modelType, contextType, allInvariants);
				PivotUtil.refreshList(contextType.getOwnedInvariant(), allInvariants);
			}
		}
		for (org.eclipse.ocl.examples.pivot.Package parentContextPackage : nestedContextTypeMaps.keySet()) {
			Set<org.eclipse.ocl.examples.pivot.Class> ownedTypes = nestedContextTypeMaps.get(parentContextPackage);
			if (ownedTypes != null) {
				List<org.eclipse.ocl.examples.pivot.Class> parentOwnedTypes = parentContextPackage.getOwnedType();
				assert parentOwnedTypes != null;
				PivotUtil.refreshSet(parentOwnedTypes, ownedTypes);
			}
		}
	}

	protected org.eclipse.ocl.examples.pivot.Package refreshContextPackage(@NonNull org.eclipse.ocl.examples.pivot.Package modelPackage, @Nullable PackageDeclarationCS csElement) {
		if (modelPackage.eIsProxy()) {
			return null;
		}
		org.eclipse.ocl.examples.pivot.Package contextPackage1 = modelPackage2contextPackage.get(modelPackage);
		@NonNull org.eclipse.ocl.examples.pivot.Package contextPackage;
		if (contextPackage1 == null) {
			contextPackage = context.refreshModelElement(org.eclipse.ocl.examples.pivot.Package.class, PivotPackage.Literals.PACKAGE, csElement);
			String newName = modelPackage.getName();
			if (csElement != null) {
				List<PathElementCS> newPath = csElement.getPathName().getPath();
				PathElementCS lastPathElement = newPath.get(newPath.size() - 1);
				Element asElement = lastPathElement.getPivot();
				if ((asElement instanceof Nameable) && !asElement.eIsProxy()) {
					newName = ((Nameable)asElement).getName();
				}
				else {
					newName = ElementUtil.getTextName(lastPathElement);
				}
			}
			context.refreshName(contextPackage, DomainUtil.nonNullModel(newName));
			PackageImpl packageImpl = (PackageImpl)contextPackage;
			if (packageImpl.basicGetPackageId() == null) {
				packageImpl.setPackageId(modelPackage.getPackageId());
			}
			context.refreshNsURI(contextPackage, modelPackage.getNsURI());
			modelPackage2contextPackage.put(modelPackage, contextPackage);
			org.eclipse.ocl.examples.pivot.Package parentModelPackage = modelPackage.getNestingPackage();
			if (parentModelPackage != null) {
				refreshContextPackage(parentModelPackage, null);
			}
		}
		else {
			contextPackage = contextPackage1;
		}
		if (csElement != null) {
			context.refreshComments(contextPackage, csElement);
			context.installPivotUsage(csElement, contextPackage);
		}
		return contextPackage;
	}

	protected Type refreshContextType(@NonNull org.eclipse.ocl.examples.pivot.Class modelClassifier, @Nullable ClassifierContextDeclCS csElement) {
		if (modelClassifier.eIsProxy()) {
			return null;
		}
		@NonNull org.eclipse.ocl.examples.pivot.Class contextClassifier = context.refreshModelElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, csElement);
		List<org.eclipse.ocl.examples.pivot.Class> contextClassifiers = modelType2contextTypes.get(modelClassifier);
		if (contextClassifiers == null) {
			contextClassifiers = new ArrayList<org.eclipse.ocl.examples.pivot.Class>();
			modelType2contextTypes.put(modelClassifier, contextClassifiers);
		}
		context.refreshName(contextClassifier, DomainUtil.nonNullModel(modelClassifier.getName()));
		contextClassifiers.add(contextClassifier);
		org.eclipse.ocl.examples.pivot.Package modelPackage = modelClassifier.getPackage();
		if (modelPackage != null) {
			PackageDeclarationCS csPackage = null;
			if (csElement != null) {
				EObject eContainer = csElement.eContainer();
				if (eContainer instanceof PackageDeclarationCS) {
					csPackage = (PackageDeclarationCS)eContainer;
				}
			}
			Package contextPackage = contextClassifier.getPackage();
			if ((csPackage != null) || (contextPackage == null)) {
				refreshContextPackage(modelPackage, csPackage);
			}
			else {
				modelPackage2contextPackage.put(modelPackage, contextPackage);				
			}
		}
		if (csElement != null) {
			context.refreshComments(contextClassifier, csElement);
			context.installPivotUsage(csElement, contextClassifier);
		}
		return contextClassifier;
	}

	protected void registerOperation(@NonNull Type modelClassifier, @NonNull Operation pivotElement) {
		List<Operation> contextOperations = modelType2contextOperations.get(modelClassifier);
		if (contextOperations == null) {
			contextOperations = new ArrayList<Operation>();
			modelType2contextOperations.put(modelClassifier, contextOperations);
		}
		contextOperations.add(pivotElement);
	}

	protected void registerProperty(@NonNull Type modelClassifier, @NonNull Property pivotElement) {
		List<Property> contextProperties = modelType2contextProperties.get(modelClassifier);
		if (contextProperties == null) {
			contextProperties = new ArrayList<Property>();
			modelType2contextProperties.put(modelClassifier, contextProperties);
		}
		contextProperties.add(pivotElement);
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(@NonNull ClassifierContextDeclCS csElement) {
		org.eclipse.ocl.examples.pivot.Class modelClassifier = csElement.getClassifier();
		if (modelClassifier != null) {
			Type contextClassifier = refreshContextType(modelClassifier, csElement);
			if (contextClassifier != null) {
				for (ConstraintCS csInvariant : csElement.getInvariants()) {
					Constraint constraint = PivotUtil.getPivot(Constraint.class, csInvariant);
					if (constraint != null) {
						List<Element> constrainedElements = constraint.getConstrainedElement();
						constrainedElements.clear();
						constrainedElements.add(contextClassifier);
						List<Constraint> invariants = type2invariants.get(contextClassifier);
						if (invariants == null) {
							invariants = new ArrayList<Constraint>();
							type2invariants.put(contextClassifier, invariants);
						}
						invariants.add(constraint);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitCompleteOCLDocumentCS(@NonNull CompleteOCLDocumentCS csElement) {
		for (IncludeCS csInclude : csElement.getOwnedInclude()) {
			csInclude.getNamespace();					// Resolve the proxy to perform the import.
		}
		@NonNull Root contextRoot = refreshRoot(Root.class, PivotPackage.Literals.ROOT, csElement);
		List<Root> modelRoots = new ArrayList<Root>();
		for (org.eclipse.ocl.examples.pivot.Package modelPackage : modelPackage2contextPackage.keySet()) {
			org.eclipse.ocl.examples.pivot.Package parentModelPackage = modelPackage.getNestingPackage();
			if (parentModelPackage == null) {
				modelRoots.add((Root) modelPackage.eContainer());
			}
		}
		installTypeContainment();
		installPackageContainment(contextRoot);
		return null;
	}

	@Override
	public Continuation<?> visitDefOperationCS(@NonNull DefOperationCS csElement) {
		@NonNull Operation contextOperation = refreshNamedElement(Operation.class, PivotPackage.Literals.OPERATION, csElement);
		ClassifierContextDeclCS csClassifierContextDecl = csElement.getClassifierContextDecl();
		Type modelClassifier = csClassifierContextDecl.getClassifier();
		if (modelClassifier != null) {
			registerOperation(modelClassifier, contextOperation);
		}
		context.refreshPivotList(Parameter.class, contextOperation.getOwnedParameter(), csElement.getParameters());
		ExpressionInOCL pivotSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csElement.getSpecification());
		contextOperation.setBodyExpression(pivotSpecification);
		return null;
	}

	@Override
	public Continuation<?> visitDefPropertyCS(@NonNull DefPropertyCS csElement) {
		@NonNull Property contextProperty = refreshNamedElement(Property.class, PivotPackage.Literals.PROPERTY, csElement);
		ClassifierContextDeclCS csClassifierContextDecl = csElement.getClassifierContextDecl();
		Type modelClassifier = csClassifierContextDecl.getClassifier();
		if (modelClassifier != null) {
			registerProperty(modelClassifier, contextProperty);
		}
		contextProperty.setIsDerived(true);
		contextProperty.setIsReadOnly(true);
		contextProperty.setIsTransient(true);
		contextProperty.setIsVolatile(true);
		contextProperty.setIsResolveProxies(false);
		ExpressionInOCL pivotSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csElement.getSpecification());
		contextProperty.setDefaultExpression(pivotSpecification);
		return null;
	}

	@Override
	public Continuation<?> visitImportCS(@NonNull ImportCS csElement) {
		super.visitImportCS(csElement);
		Namespace namespace = csElement.getNamespace();													// Resolve the proxy to perform the import.
		if ((namespace != null) && !namespace.eIsProxy()) {
			context.installPivotUsage(csElement, namespace);
		}
		return null;
	}

	@Override
	public Continuation<?> visitIncludeCS(@NonNull IncludeCS csElement) {
		return null;		// Suppressed here to avoid reversed post-order
	}

	@Override
	public Continuation<?> visitLibraryCS(@NonNull LibraryCS csElement) {
		Namespace pPackage = csElement.getPackage();						// Resolve the proxy to perform the import.
		if ((pPackage != null) && !pPackage.eIsProxy()) {
			context.installPivotUsage(csElement, pPackage);
		}
		return null;
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(@NonNull OperationContextDeclCS csElement) {
		List<ParameterCS> csParameters = csElement.getParameters();
		assert csParameters != null;
		PathNameCS pathName = csElement.getPathName();
		assert pathName != null;
		CS2Pivot.setElementType(pathName, PivotPackage.Literals.OPERATION, csElement,
			new OperationDeclScopeFilter(null, csParameters));
		/*
		 * Types have not yet been resolved so operation overloads are not resolveable.
		 *
		Operation modelOperation = csElement.getOperation(); */
		List<PathElementCS> path = pathName.getPath();
		int pathSize = path.size();
		Element modelParent = pathSize >= 2 ? path.get(pathSize-2).getElement() : null;
		@NonNull Operation contextOperation = context.refreshModelElement(Operation.class, PivotPackage.Literals.OPERATION, csElement);
		if (modelParent instanceof org.eclipse.ocl.examples.pivot.Class) {
			org.eclipse.ocl.examples.pivot.Class modelClassifier = (org.eclipse.ocl.examples.pivot.Class) modelParent;
			refreshContextType(modelClassifier, null);
			registerOperation(modelClassifier, contextOperation);
		}
		context.refreshPivotList(Parameter.class, contextOperation.getOwnedParameter(), csParameters);
		context.refreshComments(contextOperation, csElement);
		for (ConstraintCS csPrecondition : csElement.getPreconditions()) {
			Constraint precondition = PivotUtil.getPivot(Constraint.class, csPrecondition);
			if (precondition != null) {
				List<Element> constrainedElements = precondition.getConstrainedElement();
				constrainedElements.clear();
				constrainedElements.add(contextOperation);
				List<Constraint> preconditions = operation2preconditions.get(contextOperation);
				if (preconditions == null) {
					preconditions = new ArrayList<Constraint>();
					operation2preconditions.put(contextOperation, preconditions);
				}
				preconditions.add(precondition);
			}
		}
		for (ConstraintCS csPostcondition : csElement.getPostconditions()) {
			Constraint postcondition = PivotUtil.getPivot(Constraint.class, csPostcondition);
			if (postcondition != null) {
				List<Element> constrainedElements = postcondition.getConstrainedElement();
				constrainedElements.clear();
				constrainedElements.add(contextOperation);
				List<Constraint> postconditions = operation2postconditions.get(contextOperation);
				if (postconditions == null) {
					postconditions = new ArrayList<Constraint>();
					operation2postconditions.put(contextOperation, postconditions);
				}
				postconditions.add(postcondition);
			}
		}
		List<ExpSpecificationCS> csBodies = csElement.getBodies();
		int iMax = csBodies.size();
		for (int i = 1; i < iMax; i++) {
			SpecificationCS csBody = csBodies.get(i);
			if (csBody != null) {
				context.addDiagnostic(csBody, "Multiple body expression ignored");
			}
		}
		SpecificationCS csBody = (iMax > 0) ? csBodies.get(0) : null;
		contextOperation.setBodyExpression(PivotUtil.getPivot(ExpressionInOCL.class, csBody));
		return null;
	}

	@Override
	public Continuation<?> visitPackageDeclarationCS(@NonNull PackageDeclarationCS csElement) {
		org.eclipse.ocl.examples.pivot.Package modelPackage = csElement.getPackage();
		if (modelPackage != null) {
			refreshContextPackage(modelPackage, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitPropertyContextDeclCS(@NonNull PropertyContextDeclCS csElement) {
		Property modelProperty = csElement.getProperty();
		@NonNull Property contextProperty = context.refreshModelElement(Property.class, PivotPackage.Literals.PROPERTY, csElement);
		if ((modelProperty != null) && !modelProperty.eIsProxy()) {
			context.refreshName(contextProperty, DomainUtil.nonNullModel(modelProperty.getName()));
			contextProperty.setType(modelProperty.getType());
			org.eclipse.ocl.examples.pivot.Class modelClassifier = (org.eclipse.ocl.examples.pivot.Class)modelProperty.getOwningType();	// FIXME cast
			if (modelClassifier != null) {
				refreshContextType(modelClassifier, null);
				registerProperty(modelClassifier, contextProperty);
			}
		}
		context.refreshComments(contextProperty, csElement);
		for (ConstraintCS csInvariant : csElement.getDerivedInvariants()) {
			Constraint invariant = PivotUtil.getPivot(Constraint.class, csInvariant);
			if (invariant != null) {
				List<Element> constrainedElements = invariant.getConstrainedElement();
				constrainedElements.clear();
				constrainedElements.add(contextProperty);
				List<Constraint> invariants = property2invariants.get(contextProperty);
				if (invariants == null) {
					invariants = new ArrayList<Constraint>();
					property2invariants.put(contextProperty, invariants);
				}
				invariants.add(invariant);
			}
		}
		List<ExpSpecificationCS> csDefaults = csElement.getDefaultExpressions();
		int iMax = csDefaults.size();
		for (int i = 1; i < iMax; i++) {
			SpecificationCS csDefault = csDefaults.get(i);
			if (csDefault != null) {
				context.addDiagnostic(csDefault, "Multiple default expression ignored");
			}
		}
		SpecificationCS csDefault = (iMax > 0) ? csDefaults.get(0) : null;
		contextProperty.setDefaultExpression(PivotUtil.getPivot(ExpressionInOCL.class, csDefault));
		return null;
	}
}
