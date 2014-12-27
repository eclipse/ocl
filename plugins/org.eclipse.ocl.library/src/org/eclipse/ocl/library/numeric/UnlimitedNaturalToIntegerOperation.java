package org.eclipse.ocl.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.Value;

/**
 * UnlimitedNaturalToIntegerOperation realises the UnlimitedNatural::toInteger() library operation.
 */
public class UnlimitedNaturalToIntegerOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull UnlimitedNaturalToIntegerOperation INSTANCE = new UnlimitedNaturalToIntegerOperation();

	@Override
	public @NonNull Object evaluate(@Nullable Object sourceVal) {
		Value numericValue = asUnlimitedNaturalValue(sourceVal);
		if (numericValue != ValueUtil.UNLIMITED_VALUE) {
			return numericValue;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, "limited", "unlimited"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
