package org.eclipse.ocl.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.InvalidValueException;

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
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "non-negative", "negative"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
