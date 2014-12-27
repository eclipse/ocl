package org.eclipse.ocl.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * IntegerToUnlimitedNaturalOperation realises the Integer::toUnlimitedNatural() library operation.
 */
public class IntegerToUnlimitedNaturalOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull IntegerToUnlimitedNaturalOperation INSTANCE = new IntegerToUnlimitedNaturalOperation();

	@Override
	public @NonNull Object evaluate(@Nullable Object sourceVal) {
		IntegerValue numericValue = asIntegerValue(sourceVal);
		if (numericValue.signum() >= 0) {
			return numericValue;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, "non-negative", "negative"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
