package org.eclipse.ocl.examples.autogen.namereso;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;


public class NameResoGenModelHelper extends AbstractGenModelHelper {
	
	public NameResoGenModelHelper(@NonNull MetaModelManager mManager) {
		super(mManager);
	}


	public String getChildQualifiedFeatureAccessor(@NonNull  Type type, @NonNull String propertyName) {

		for (DomainProperty prop : metaModelManager.getAllProperties(type, null, propertyName)) {
			if (prop instanceof Property) {
				return getGenFeature((Property) prop).getQualifiedFeatureAccessor(); // We get the first one	
			}
		}
		return propertyName + " not found for type " + type.getName();
	}
}
