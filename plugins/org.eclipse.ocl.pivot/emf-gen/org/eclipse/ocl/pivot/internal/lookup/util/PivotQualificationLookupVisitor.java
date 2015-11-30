/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: uk.ac.york.cs.asbh.lang.cs2as/model/TargetMM1.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.pivot.internal.lookup.util;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment;
import org.eclipse.ocl.pivot.util.AbstractPivotLookupVisitor;
import org.eclipse.ocl.pivot.util.Visitable;


/**
 * @since 1.1
 */
public class PivotQualificationLookupVisitor extends AbstractPivotLookupVisitor {

	public PivotQualificationLookupVisitor(@NonNull LookupEnvironment context) {
		super(context);
	}

    @Override
    public @Nullable LookupEnvironment visiting(@NonNull Visitable visitable) {
        return context;
    }
        
    @Override
    public @Nullable LookupEnvironment visitPackage(@NonNull org.eclipse.ocl.pivot.Package element) {
    	   	
	    final @NonNull /*@Thrown*/ List<org.eclipse.ocl.pivot.Package> ownedPackages = element.getOwnedPackages();
	    @SuppressWarnings("null")
	    final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements(ownedPackages);
	    
	    final @NonNull /*@Thrown*/ List<org.eclipse.ocl.pivot.Class> ownedClasses = element.getOwnedClasses();
	    @SuppressWarnings("null")
	    final @NonNull /*@Thrown*/ LookupEnvironment addElements2 = addElements.addElements(ownedClasses);
	    return addElements2;
    }
    
    @Override
    public @Nullable LookupEnvironment visitClass(@NonNull Class element) {
	    final @NonNull /*@Thrown*/ List<Property> ownedProperties = element.getOwnedProperties();
	    @SuppressWarnings("null")
	    final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements(ownedProperties);
	    
	    final @NonNull /*@Thrown*/ List<Operation> ownedOperations = element.getOwnedOperations();
	    @SuppressWarnings("null")
	    final @NonNull /*@Thrown*/ LookupEnvironment addElements2 = addElements.addElements(ownedOperations);
	    return addElements2;
    }
}
