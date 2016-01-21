package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;

/**
 * @author asanchez
 * @since 1.1
 * @noextend This class is not intended to be subclassed by clients. Just a convenient class 
 * for generated visitors of derived languages
 */
public class PivotAS2MonikerVisitor extends AS2MonikerVisitor {

	public PivotAS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
	}
}
