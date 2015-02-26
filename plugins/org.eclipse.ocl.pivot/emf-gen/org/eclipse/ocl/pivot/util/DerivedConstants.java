package org.eclipse.ocl.pivot.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * DerivedConstants provides constants from plugins not necessarily on the plugin classpath.
*/
public interface DerivedConstants
{
	static final @NonNull String RESOURCE_OPTION_LINE_DELIMITER = "LINE_DELIMITER"; // org.eclipse.emf.ecore.resource.Resource.OPTION_LINE_DELIMITER since 2.9
	
	static final @NonNull String STEREOTYPE_BASE_PREFIX = "base_"; // org.eclipse.uml2.uml.Extension.METACLASS_ROLE_PREFIX
	static final @NonNull String STEREOTYPE_EXTENSION_PREFIX = "extension_"; // org.eclipse.uml2.uml.Extension.STEREOTYPE_ROLE_PREFIX

	static final @NonNull String UML2_GEN_MODEL_PACKAGE_1_1_NS_URI = "http://www.eclipse.org/uml2/1.1.0/GenModel";
	static final @NonNull String UML2_GEN_MODEL_PACKAGE_2_0_NS_URI = "http://www.eclipse.org/uml2/2.2.0/GenModel";

	static final @NonNull String UML2_UML_PACKAGE_2_0_NS_URI = "http://www.eclipse.org/uml2/2.0.0/UML"; // org.eclipse.uml2.uml.util.UMLUtil.UML2_UML_PACKAGE_2_0_NS_URI

	static final @NonNull String ANNOTATION_DETAIL__ORIGINAL_NAME = "originalName"; //$NON-NLS-1$ org.eclipse.uml2.uml.util.UML2EcoreConverter.ANNOTATION_DETAIL__ORIGINAL_NAME
}
