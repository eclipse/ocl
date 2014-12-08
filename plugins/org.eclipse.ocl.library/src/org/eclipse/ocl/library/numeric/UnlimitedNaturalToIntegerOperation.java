package org.eclipse.ocl.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.values.Value;
import org.eclipse.ocl.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.domain.values.util.ValuesUtil;

/**
 * UnlimitedNaturalToIntegerOperation realises the UnlimitedNatural::toInteger() library operation.
 */
public class UnlimitedNaturalToIntegerOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull UnlimitedNaturalToIntegerOperation INSTANCE = new UnlimitedNaturalToIntegerOperation();

	@Override
	public @NonNull Object evaluate(@Nullable Object sourceVal) {
		Value numericValue = asUnlimitedNaturalValue(sourceVal);
		if (numericValue != ValuesUtil.UNLIMITED_VALUE) {
			return numericValue;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "limited", "unlimited"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
