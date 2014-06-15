/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.DomainConstants;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

public interface PivotConstants extends DomainConstants
{
	@SuppressWarnings("null")
	static final @NonNull String PLUGIN_ID = PivotConstants.class.getPackage().getName();
	static final @NonNull String PIVOT_ECORE = PivotConstants.class.getPackage().getName() + "/model/Pivot.ecore";
	@SuppressWarnings("null")
	static final @NonNull URI GEN_MODEL_URI = URI.createPlatformPluginURI("/" + PLUGIN_ID + "/model/Pivot.merged.genmodel", true); //$NON-NLS-1$

	static final @NonNull String OCL_AS_FILE_EXTENSION = "oclas";
	static final @NonNull String DOT_OCL_AS_FILE_EXTENSION = "." + OCL_AS_FILE_EXTENSION;
	
	/**
	 * String-valued URI prefix of a package defining the primitive types. Proxy references to
	 * e.g. OCL's String rather than Ecore's EString are constructed by just appending 'String' to
	 * the prefix.
	 */
	static final @NonNull String PRIMITIVE_TYPES_URI_PREFIX = "PRIMITIVE_TYPES_URI_PREFIX";
	
	static final @SuppressWarnings("null")@NonNull String DOCUMENTATION_ANNOTATION_SOURCE = GenModelPackage.eNS_URI;
	static final @NonNull String DOCUMENTATION_ANNOTATION_KEY = "documentation";

	/**
	 * EPackage annotation identifying models that must be imported.
	 * Each detail is an alias-name, import uri pair.
	 */
	static final @NonNull String IMPORT_ANNOTATION_SOURCE = "http://www.eclipse.org/OCL/Import";
	static final @NonNull String SYSML_ANNOTATION_SOURCE = "http://www.omg.org/spec/SysML";
	
	/**
	 * EPackage annotation indicating that the EPackage is an Ecore serialisation of an OCL AS Library.
	 * No details are defined for this EAnnotation.
	 * <p>
	 * This annotation is used by /org.eclipse.ocl.examples.library/model/oclstdlib.ecore. It is not
	 * intended to be used by client code.
	 */
	static final @NonNull String AS_LIBRARY_ANNOTATION_SOURCE = "http://www.eclipse.org/OCL/ASLibrary";

	static final @NonNull String OMG_OCL_ANNOTATION_SOURCE = "http://www.omg.org/ocl";

	/**
	 * Ecore encoding of a UML redefines
	 */
	static final @NonNull String DUPLICATES_ANNOTATION_SOURCE = "duplicates"; // UMLUtil.ANNOTATION__DUPLICATES
	static final @NonNull String REDEFINES_ANNOTATION_SOURCE = "redefines"; // UMLUtil.ANNOTATION__REDEFINES
//	static final @NonNull String SUBSETS_ANNOTATION_SOURCE = "subsets"; // UMLUtil.ANNOTATION__SUBSETS
//	static final @NonNull String UNION_ANNOTATION_SOURCE = "union"; // UMLUtil.ANNOTATION__UNION

	/**
	 * The default values for a totally blind implicit opposite are determined by what it is safe to use for a fully deduced opposite.
	 * <br>
	 * [0..*] since we have no idea how many objects may be pointing at an object.
	 * <br>
	 * !ordered since we cannot hope to reconstruct order
	 * <br>
	 * !unique since we cannot know how many times an object can reference another once by a given relationship.
	 */
	static final @NonNull IntegerValue DEFAULT_IMPLICIT_OPPOSITE_LOWER_VALUE = ValuesUtil.ZERO_VALUE;
	static final boolean DEFAULT_IMPLICIT_OPPOSITE_ORDERED = false;
	static final boolean DEFAULT_IMPLICIT_OPPOSITE_UNIQUE = false;
	static final @NonNull IntegerValue DEFAULT_IMPLICIT_OPPOSITE_UPPER_VALUE = ValuesUtil.UNLIMITED_VALUE;

	/**
	 * The default values for annotated implicit opposites are determined by what is pragmatic.
	 * <br>
	 * [0..1] which is usually correct for non-collections and half correct for collections.
	 * <br>
	 * !ordered is common
	 * <br>
	 * unique is common
	 */
	static final @NonNull IntegerValue ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE = ValuesUtil.ZERO_VALUE;
	static final boolean ANNOTATED_IMPLICIT_OPPOSITE_ORDERED = false;
	static final boolean ANNOTATED_IMPLICIT_OPPOSITE_UNIQUE = true;
	static final @NonNull IntegerValue ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE = ValuesUtil.ONE_VALUE;

	@Deprecated // Tuples are now used for rich invariants
	static final @NonNull String MESSAGE_ANNOTATION_DETAIL_SUFFIX = "$message";

	static final int MONIKER_OVERFLOW_LIMIT = 1024;
	static final @NonNull String ANNOTATION_QUOTE = "'"; //$NON-NLS-1$
	static final @NonNull String BINDINGS_PREFIX = "/"; //$NON-NLS-1$ // FIXME Rename
	static final @NonNull String ITERATOR_SEPARATOR = ";"; //$NON-NLS-1$
	static final @NonNull String ACCUMULATOR_SEPARATOR = "|"; //$NON-NLS-1$
	static final @NonNull String NULL_MARKER = "<<null-element>>"; //$NON-NLS-1$
	static final @NonNull String NULL_ROOT = "$null$"; //$NON-NLS-1$
	static final @NonNull String OVERFLOW_MARKER = "##"; //$NON-NLS-1$
	static final @NonNull String MONIKER_PART_SEPARATOR = "@"; //$NON-NLS-1$
	static final @NonNull String MONIKER_SCOPE_SEPARATOR = "!"; //"::"; //$NON-NLS-1$
	static final @NonNull String MONIKER_OPERATOR_SEPARATOR = "~"; //$NON-NLS-1$
	static final @NonNull String PARAMETER_PREFIX = "("; //$NON-NLS-1$
	static final @NonNull String PARAMETER_SEPARATOR = ","; //$NON-NLS-1$
	static final @NonNull String PARAMETER_SUFFIX = ")"; //$NON-NLS-1$
	static final @NonNull String PRECEDENCE_PREFIX = "~"; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_BINDING_PREFIX = "["; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_BINDING_SEPARATOR = ","; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_BINDING_SUFFIX = "]"; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_PARAMETER_PREFIX = "?"; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_SIGNATURE_PREFIX = "{"; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_SIGNATURE_SEPARATOR = ","; //$NON-NLS-1$
	static final @NonNull String TEMPLATE_SIGNATURE_SUFFIX = "}"; //$NON-NLS-1$
	static final @NonNull String TUPLE_SIGNATURE_PREFIX = "{"; //$NON-NLS-1$
	static final @NonNull String TUPLE_SIGNATURE_PART_SEPARATOR = ","; //$NON-NLS-1$
	static final @NonNull String TUPLE_SIGNATURE_TYPE_SEPARATOR = ":"; //$NON-NLS-1$
	static final @NonNull String TUPLE_SIGNATURE_SUFFIX = "}"; //$NON-NLS-1$
	static final @NonNull String UNRESOLVED_PROXY_MARKER = "<<unresolved-proxy>>"; //$NON-NLS-1$
	static final @NonNull String WILDCARD_INDICATOR = "?"; //$NON-NLS-1$

	static final @NonNull String COLLECTION_NAVIGATION_OPERATOR = "->";
	static final @NonNull String OBJECT_NAVIGATION_OPERATOR = ".";
	static final @NonNull String GREATER_THAN_OPERATOR = ">";
	static final @NonNull String GREATER_THAN_OR_EQUAL_OPERATOR = ">=";
	static final @NonNull String LESS_THAN_OPERATOR = "<";
	static final @NonNull String LESS_THAN_OR_EQUAL_OPERATOR = "<=";
	
	static final @NonNull String MONIKER_IF_EXP = "if";
	static final @NonNull String MONIKER_INVALID_LITERAL_EXP = "invalid";
	static final @NonNull String MONIKER_LET_EXP = "let";
	static final @NonNull String MONIKER_NULL_LITERAL_EXP = "null";
	static final @NonNull String MONIKER_ROOT = "ROOT";
	static final @NonNull String MONIKER_ROOT_EXP = "root";
	static final @NonNull String MONIKER_STRING_LITERAL_EXP = "string";
	static final @NonNull String MONIKER_TUPLE_LITERAL_EXP = "tuple";
	static final @NonNull String MONIKER_UNLIMITED_NATURAL_LITERAL_EXP = "*";

	static final @NonNull String MONIKER_EXP_CHILD_PREFIX = "x";
	
	static final @NonNull String LIBRARY_MONIKER_PREFIX = "$";
	static final @NonNull String ORPHANAGE_NAME = "$$";
	static final @NonNull String ORPHANAGE_PREFIX = "orphanage";
	static final @NonNull String ORPHANAGE_URI = "http://www.eclipse.org/ocl/3.1.0/orphanage";
	
	static final @NonNull String UNKNOWN_TYPE_TEXT = "unknown-type";

	static final @NonNull String WILDCARD_NAME = "wildcard";
	
	static final @NonNull String OCL_LANGUAGE = "OCL";			// More visible UMLUtil.Language_OCL
	static final @NonNull String OCL_NAME = "ocl";
	
	static final @NonNull String MESSAGE_PART_NAME = "message";
	static final @NonNull String SEVERITY_PART_NAME = "severity";
	static final @NonNull String STATUS_PART_NAME = "status";
	
	public static @NonNull Map<EStructuralFeature,String> roleNames = new HashMap<EStructuralFeature,String>();
}
