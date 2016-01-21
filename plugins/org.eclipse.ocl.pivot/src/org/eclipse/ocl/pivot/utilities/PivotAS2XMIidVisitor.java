package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;

/**
 * @author asanchez
 * @since 1.1
 * @noextend This class is not intended to be subclassed by clients. Just a convenient class 
 * for generated visitors of derived languages
 */
public class PivotAS2XMIidVisitor extends AS2XMIidVisitor {

	public PivotAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}
}
