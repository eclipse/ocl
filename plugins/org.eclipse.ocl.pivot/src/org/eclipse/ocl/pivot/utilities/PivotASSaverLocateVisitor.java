package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;

/**
 * @author asanchez
 * @since 1.1
 * @noextend This class is not intended to be subclassed by clients. Just a convenient class 
 * for generated visitors of derived languages
 */
public class PivotASSaverLocateVisitor extends ASSaverLocateVisitor {

	public PivotASSaverLocateVisitor(@NonNull ASSaver context) {
		super(context);
	}

	
}
