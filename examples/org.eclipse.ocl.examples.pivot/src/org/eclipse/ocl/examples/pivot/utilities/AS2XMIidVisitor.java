/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.manager.Orphanage;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * The AS2XMIidVisitor generates an xmi:id for an AS element. Using one of three policies.
 * <p>
 * null - no xmi:id generated - saves space
 * <p>
 * false - xmi:id generated/reuses UUID - UUID only used internally so no need for predicatability
 * <p>
 * true - xmi:id generated/reuses friendly name - ID may be independently generated - must be predictable
 * <p>
 * Simple elements such as Package/Type/Property get a dot-separated hierarchical name.
 * <p>
 * Operations get a dot-separated hierarchical name suffixed by dot-dot-separated argument types.
 * <p>
 * Internally referenceable elements such as TemplateSignature get a UUID, reusing any xmi:id provided
 * in the context Moniker to XMIId Map.
 *
 */
public class AS2XMIidVisitor extends AbstractExtendingVisitor<Boolean, AS2XMIid>
{
	public static final int OVERFLOW_LIMIT = 1024;
	public static final @NonNull String OVERFLOW_MARKER = "##"; //$NON-NLS-1$

	public static final @NonNull String NULL_MARKER = "<<null-element>>"; //$NON-NLS-1$

	public static final @NonNull String FRAGMENT_SEPARATOR = "#"; //$NON-NLS-1$
	
	public static final @NonNull String ACCUMULATOR_PREFIX = "a"; //$NON-NLS-1$
	public static final @NonNull String BODYCONDITION_PREFIX = "c="; //$NON-NLS-1$
	public static final @NonNull String INVARIANT_PREFIX = "ci"; //$NON-NLS-1$
	public static final @NonNull String ITERATION_PREFIX = "i."; //$NON-NLS-1$
	public static final @NonNull String ITERATOR_PREFIX = "i"; //$NON-NLS-1$
	public static final @NonNull String OPERATION_PREFIX = "o."; //$NON-NLS-1$
	public static final @NonNull String PARAMETER_PREFIX = "p"; //$NON-NLS-1$
	public static final @NonNull String PACKAGE_PREFIX = "P."; //$NON-NLS-1$
	public static final @NonNull String POSTCONDITION_PREFIX = "c+"; //$NON-NLS-1$
	public static final @NonNull String PRECONDITION_PREFIX = "c-"; //$NON-NLS-1$
	public static final @NonNull String PRECEDENCE_PREFIX = "Z."; //$NON-NLS-1$
	public static final @NonNull String PROPERTY_PREFIX = "p."; //$NON-NLS-1$
	public static final @NonNull String TEMPLATE_PARAMETER_PREFIX = "t."; //$NON-NLS-1$
	public static final @NonNull String TEMPLATE_SIGNATURE_PREFIX = "s."; //$NON-NLS-1$
	public static final @NonNull String TYPE_PREFIX = "T."; //$NON-NLS-1$
	
	public static final @NonNull String OPERATION_PARAMETER_SEPARATOR = ".."; //$NON-NLS-1$
	public static final @NonNull String SCOPE_SEPARATOR = "."; //$NON-NLS-1$
	public static final @NonNull String TEMPLATE_PARAMETER_SEPARATOR = ".."; //$NON-NLS-1$

	protected final @NonNull StringBuilder s = new StringBuilder();
	
	public AS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}

	protected void appendName(@Nullable String name) {
		if (name == null) {
			s.append(NULL_MARKER);
		}
		else {
			for (int i = 0; i < name.length(); i++) {
				char c = name.charAt(i);
				if (('0' <= c) && (c <= '9')) {
					s.append(c);
				}
				else if (('A' <= c) && (c <= 'Z')) {
					s.append(c);
				}
				else if (('a' <= c) && (c <= 'z')) {
					s.append(c);
				}
				else if (c == '_') {
					s.append(c);
				}
				else if (c == '$') {
					s.append(c);
				}
				else if (c == '%') {
					s.append("%%");
				}
				else {
					s.append("%");
					s.append((int)c);
					s.append("%");
				}
			}
		}
	}
	
	/**
	 * @since 3.5
	 */
	protected void appendNameOf(@NonNull Object element) {
		if (element instanceof Nameable) {
			s.append(((Nameable)element).getName());
		}
		else {
			s.append(System.identityHashCode(element));
		}
	}

	protected void appendOperation(Operation object) {
		appendParent(object);
		appendName(object.getName());
		List<Parameter> parameters = object instanceof Iteration ? ((Iteration)object).getOwnedIterator() : object.getOwnedParameter();
		for (Parameter parameter : parameters) {
			s.append(OPERATION_PARAMETER_SEPARATOR);
			appendType(parameter.getType());
		}
	}

	@Deprecated
	protected void appendParent(@Nullable NamedElement element) {
		appendParent((EObject)element);
	}
	/**
	 * @since 3.5
	 */
	protected void appendParent(@Nullable EObject element) {
		if (toString().length() >= OVERFLOW_LIMIT) {
			s.append(OVERFLOW_MARKER);
		}
		else if (element == null) {
			s.append(NULL_MARKER);	
			s.append(SCOPE_SEPARATOR);
		}
		else {
			EObject eContainer = element.eContainer();
			if (eContainer instanceof Root) {
			}
			else if (eContainer != null) {
				if (!(eContainer instanceof ParameterableElement) || (((ParameterableElement)eContainer).getOwningTemplateParameter() == null)) {
					appendParent(eContainer);
				}
				appendNameOf(eContainer);
				s.append(SCOPE_SEPARATOR);
			}
		}
	}

	protected void appendType(@Nullable Type type) {
		if (type == null) {
			s.append(NULL_MARKER);	
		}
		else {
			if (type.getOwningTemplateParameter() == null) {
				appendParent(type);
			}
			appendName(type.getName());
		}
	}

	public @Nullable String getID(@NonNull Element element, boolean internalUUIDs) {
		Boolean status = element.accept(this);
		if (status == null) {
			return null;
		}
		else if (status) {
			return s.toString();
		}
		else {
			return context.getID(element, internalUUIDs);
		}
	}	

	@Override
	public String toString() {
		return s.toString();
	}

	@Override
	public Boolean visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		
		if (Orphanage.isTypeOrphanage(object.getPackage())) {
			return false;
		}
		String name = object.getName();
		if (PivotConstants.WILDCARD_NAME.equals(name)) {
			if (Orphanage.isTypeOrphanage(PivotUtil.getContainingPackage(object))) {
				return false;
			}
		}
		TemplateParameter owningTemplateParameter = object.getOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			NamedElement template = (NamedElement) owningTemplateParameter.getSignature().getTemplate();
			if ((template instanceof Type) && Orphanage.isTypeOrphanage(((Type)template).getPackage())) {
				return false;
			}
			s.append(TYPE_PREFIX);
			appendParent(template);
			s.append(SCOPE_SEPARATOR);
			appendName(template.getName());
			appendName(name);
		}
		else {
			s.append(TYPE_PREFIX);
			appendParent(object);
			appendName(name);
		}
		return true;
	}

	@Override
	public @Nullable Boolean visitCollectionType(@NonNull CollectionType object) {
		if (object.getTemplateBinding().isEmpty()) {
			appendName(object.getName());
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public @Nullable Boolean visitConstraint(@NonNull Constraint object) {
		String name = object.getName();
		if ((name != null) && !"".equals(name)) {
			EReference eContainmentFeature = object.eContainmentFeature();
			if (eContainmentFeature == PivotPackage.Literals.OPERATION__PRECONDITION) {
				s.append(PRECONDITION_PREFIX);
			}
			else if (eContainmentFeature == PivotPackage.Literals.OPERATION__BODY_EXPRESSION) {
				s.append(BODYCONDITION_PREFIX);
			}
			else if (eContainmentFeature == PivotPackage.Literals.OPERATION__POSTCONDITION) {
				s.append(POSTCONDITION_PREFIX);
			}
			else {
				s.append(INVARIANT_PREFIX);
			}
			appendParent(object);
			appendName(name);
			return true;
		}
		return null;
	}


	@Override
	public @Nullable Boolean visitElement(@NonNull Element object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitLambdaType(@NonNull LambdaType object) {
		return false;
	}

	@Override
	public Boolean visitIteration(@NonNull Iteration object) {
		s.append(ITERATION_PREFIX);
		appendOperation(object);
		return true;
	}

	@Override
	public @Nullable Boolean visitMetaclass(@NonNull Metaclass<?> object) {
		if (object.getTemplateBinding().isEmpty()) {
			appendName(object.getName());
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public @Nullable Boolean visitOperation(@NonNull Operation object) {
		s.append(OPERATION_PREFIX);
		appendOperation(object);
		return true;
	}

	@Override
	public @Nullable Boolean visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package object) {
		String name = object.getName();
		if (name != null) {
			s.append(PACKAGE_PREFIX);
			appendParent(object);
			appendName(name);
			return true;
		}
		else if (object.getNsURI() != null) {
			appendName(object.getNsURI());
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public @Nullable Boolean visitParameter(@NonNull Parameter object) {
		Operation operation = (Operation)object.eContainer();
		int index = operation.getOwnedParameter().indexOf(object);
		if (index >= 0) {
			s.append(PARAMETER_PREFIX);
			s.append(index);
		}
		else if (operation instanceof Iteration) {
			Iteration iteration = (Iteration)operation;
			index = iteration.getOwnedIterator().indexOf(object);
			if (index >= 0) {
				s.append(ITERATOR_PREFIX);
				s.append(index);
			}
			else {
				index = iteration.getOwnedAccumulator().indexOf(object);
				if (index >= 0) {
					s.append(ACCUMULATOR_PREFIX);
					s.append(index);
				}
			}
		}
		operation.accept(this);
		return true;
	}

	@Override
	public @Nullable Boolean visitPrecedence(@NonNull Precedence object) {
		s.append(PRECEDENCE_PREFIX);
		appendName(object.getName());
		return true;
	}

	@Override
	public @Nullable Boolean visitPrimitiveType(@NonNull PrimitiveType object) {
		appendName(object.getName());
		return true;
	}

	@Override
	public @Nullable Boolean visitProperty(@NonNull Property object) {
		EObject eContainer = object.eContainer();
		if (eContainer instanceof TupleType) {
			return false;	// TupleParts of synthesized types use UUIDs
		}
		String name = object.getName();
		if (object.isImplicit() && (eContainer instanceof Type)) {
			for (Property asProperty : ((Type)eContainer).getOwnedAttribute()) {
				if ((asProperty != object) && name.equals(asProperty.getName())) {
					return false;	// Ambiguous implicit opposites must use UUIDs
				}
			}
		}
		s.append(PROPERTY_PREFIX);
		appendParent(object);
		appendName(name);
		return true;
	}

	@Override
	public @Nullable Boolean visitSelfType(@NonNull SelfType object) {
		appendName(object.getName());
		return true;
	}

	@Override
	public @Nullable Boolean visitTemplateParameter(@NonNull TemplateParameter object) {
		s.append(TEMPLATE_PARAMETER_PREFIX);
		NamedElement template = (NamedElement) object.getSignature().getTemplate();
		appendParent(template);
		s.append(SCOPE_SEPARATOR);
		appendName(template.getName());
		appendName(((NamedElement)object.getParameteredElement()).getName());
		return true;
	}

	@Override
	public @Nullable Boolean visitTemplateSignature(@NonNull TemplateSignature object) {
		s.append(TEMPLATE_SIGNATURE_PREFIX);
		TemplateableElement template = object.getTemplate();
		template.accept(this);
		return true;
	}

	@Override
	public @Nullable Boolean visitTupleType(@NonNull TupleType object) {
		return false;
	}

	@Override
	public @Nullable Boolean visitTypeTemplateParameter(@NonNull TypeTemplateParameter object) {
		s.append(TEMPLATE_PARAMETER_PREFIX);
		NamedElement template = (NamedElement) object.getSignature().getTemplate();
		appendParent(template);
		s.append(SCOPE_SEPARATOR);
		appendName(template.getName());
		appendName(((NamedElement)object.getParameteredElement()).getName());
		return true;
	}

	@Override
	public @Nullable Boolean visitVariableDeclaration(@NonNull VariableDeclaration object) {
		return null;
	}

	public @Nullable Boolean visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}
}
