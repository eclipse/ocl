/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.utilities;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.domain.DomainConstants;
import org.eclipse.ocl.examples.domain.elements.DomainIteration;
import org.eclipse.ocl.examples.domain.elements.DomainLambdaType;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.elements.Labelable;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.osgi.util.NLS;

public class DomainUtil
{
	private static final String maxIntValue = Integer.toString(Integer.MAX_VALUE);
	private static final int maxIntSize = maxIntValue.length();	
	private static final String maxLongValue = Long.toString(Long.MAX_VALUE);
	private static final int maxLongSize = maxLongValue.length();	

	public static final class EAnnotationComparator implements Comparator<EAnnotation>
	{
		public static final @NonNull EAnnotationComparator INSTANCE = new EAnnotationComparator();

		public int compare(EAnnotation o1, EAnnotation o2) {
			String n1 = o1.getSource();
			String n2 = o2.getSource();
			return DomainUtil.safeCompareTo(n1, n2);
		}
	}

	public static final class NameableComparator implements Comparator<Nameable>
	{	
		public static final @NonNull NameableComparator INSTANCE = new NameableComparator();

		public int compare(Nameable o1, Nameable o2) {
			String n1 = DomainUtil.getSafeName(o1);
			String n2 = DomainUtil.getSafeName(o2);
			return DomainUtil.safeCompareTo(n1, n2);
		}
	}

	public static final class ENamedElementComparator implements Comparator<ENamedElement>
	{
		public static final @NonNull ENamedElementComparator INSTANCE = new ENamedElementComparator();

		public int compare(ENamedElement o1, ENamedElement o2) {
			String n1 = o1.getName();
			String n2 = o2.getName();
			return DomainUtil.safeCompareTo(n1, n2);
		}
	}

	public static final NameableComparator NAMEABLE_COMPARATOR = NameableComparator.INSTANCE;

	/**
	 * Return the DomainConstants.AS_METAMODEL_ANNOTATION_SOURCE for ePackage or null if none.
	 * @since 3.5
	 */
	public static @Nullable EAnnotation basicGetMetamodelAnnotation(@NonNull EPackage ePackage) {
		EAnnotation asMetamodelAnnotation = ePackage.getEAnnotation(DomainConstants.AS_METAMODEL_ANNOTATION_SOURCE);
		return asMetamodelAnnotation;
	}

	public static @NonNull String bind(String messageTemplate, Object... bindings) {
		@SuppressWarnings("null") @NonNull String result = NLS.bind(messageTemplate, bindings);
		return result;
	}

	/**
	 * Mostly copied from {@link java.util.Properties#loadConvert} via
	 * {@link org.eclipse.xtext.util.Strings#convertFromJavaString}
	 */
	public static@NonNull  String convertFromOCLString(@NonNull String javaString) {
		char[] in = javaString.toCharArray();
		int off = 0;
		int len = javaString.length();
		char[] convtBuf = new char[len];
		char aChar;
		char[] out = convtBuf;
		int outLen = 0;
		int end = off + len;

		while (off < end) {
			aChar = in[off++];
			if (aChar == '\\') {
				aChar = in[off++];
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					if(off+4 > end)
						throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
					for (int i = 0; i < 4; i++) {
						aChar = in[off++];
						switch (aChar) {
							case '0':
							case '1':
							case '2':
							case '3':
							case '4':
							case '5':
							case '6':
							case '7':
							case '8':
							case '9':
								value = (value << 4) + aChar - '0';
								break;
							case 'a':
							case 'b':
							case 'c':
							case 'd':
							case 'e':
							case 'f':
								value = (value << 4) + 10 + aChar - 'a';
								break;
							case 'A':
							case 'B':
							case 'C':
							case 'D':
							case 'E':
							case 'F':
								value = (value << 4) + 10 + aChar - 'A';
								break;
							default:
								throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
						}
					}
					out[outLen++] = (char) value;
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					else if (aChar == 'b')
						aChar = '\b';
					else if (aChar == '"')
						aChar = '\"';
					else if (aChar == '\'')
						aChar = '\'';
					else if (aChar == '\\')
						aChar = '\\';
					else
						throw new IllegalArgumentException("Illegal escape character \\" + aChar);
					out[outLen++] = aChar;
				}
			} else {
				out[outLen++] = aChar;
			}
		}
		return new String(out, 0, outLen);
	}

	/**
	 * Mostly copied from {@link java.util.Properties#saveConvert} via
	 * {@link org.eclipse.xtext.util.Strings#convertToJavaString}
	 */
	public static String convertToOCLString(String theString) {
		if (theString == null) {
			return null;
		}
		int len = theString.length();
		int bufLen = len * 2;
		if (bufLen < 0) {
			bufLen = Integer.MAX_VALUE;
		}
		StringBuilder outBuffer = new StringBuilder(bufLen);

		for (int x = 0; x < len; x++) {
			char aChar = theString.charAt(x);
			// Handle common case first, selecting largest block that
			// avoids the specials below
			if ((aChar > 61) && (aChar < 127)) {
				if (aChar == '\\') {
					outBuffer.append('\\');
					outBuffer.append('\\');
					continue;
				}
				outBuffer.append(aChar);
				continue;
			}
			switch (aChar) {
				case ' ':
					outBuffer.append(' ');
					break;
				case '\t':
					outBuffer.append('\\');
					outBuffer.append('t');
					break;
				case '\n':
					outBuffer.append('\\');
					outBuffer.append('n');
					break;
				case '\r':
					outBuffer.append('\\');
					outBuffer.append('r');
					break;
				case '\f':
					outBuffer.append('\\');
					outBuffer.append('f');
					break;
				case '\b':
					outBuffer.append('\\');
					outBuffer.append('b');
					break;
				case '\'':
					outBuffer.append('\\');
					outBuffer.append('\'');
					break;
//				case '"':
//					outBuffer.append('\\');
//					outBuffer.append('"');
//					break;
				default:
					if (((aChar < 0x0020) || (aChar > 0x007e))) {
						outBuffer.append('\\');
						outBuffer.append('u');
						outBuffer.append(toHex((aChar >> 12) & 0xF));
						outBuffer.append(toHex((aChar >> 8) & 0xF));
						outBuffer.append(toHex((aChar >> 4) & 0xF));
						outBuffer.append(toHex(aChar & 0xF));
					} else {
						outBuffer.append(aChar);
					}
			}
		}
		return outBuffer.toString();
	}

	public static @NonNull Number createNumberFromString(@NonNull String aValue) throws NumberFormatException {
		if ("*".equals(aValue)) {
			return Unlimited.INSTANCE;
		}
		int len = aValue.length();
		if ((len < maxIntSize) || ((len == maxIntSize) && (maxIntValue.compareTo(aValue) >= 0))) {
			Integer result = Integer.valueOf(aValue);
			assert result != null;
			return result;
		}
		else if ((len < maxLongSize) || ((len == maxLongSize) && (maxLongValue.compareTo(aValue) >= 0))) {
			Long result = Long.valueOf(aValue);
			assert result != null;
			return result;
		}
		else {
			return new BigInteger(aValue);
		}
	}

	public static String debugEventType(int eventType) {
		switch (eventType) {
			case Notification.SET: return "SET";
			case Notification.UNSET: return "UNSET";
			case Notification.ADD: return "ADD";
			case Notification.REMOVE: return "REMOVE";
			case Notification.ADD_MANY: return "ADD_MANY";
			case Notification.REMOVE_MANY: return "REMOVE_MANY";
			case Notification.MOVE: return "MOVE";
			case Notification.REMOVING_ADAPTER: return "REMOVING_ADAPTER";
			case Notification.RESOLVE: return "RESOLVE";
		}
		return "Unknown-EventType-" + eventType;
	}
	
	public static String debugFullName(Object object) {
		if (object == null) {
			return "null";
		}
		else {
			return object.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object));
		}
	}
	
	public static String debugSimpleName(Object object) {
		if (object == null) {
			return "null";
		}
		else {
			return object.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(object));
		}
	}

	/**
	 * Append a multiplicity string such as "[1..5]" to a StringBuilder.
	 * <br>
	 * Shortforms such as "[?]",  "[+]",  "[*]",  "[1]",  "[2..*]" are used if possible.
	 * <br>
	 * A -ve upper signals unlimited.
	 */
	public static void formatMultiplicity(@NonNull StringBuilder s, long lower, long upper) {
		s.append("[");
		if (upper < 0) {
			if (lower == 1) {
				s.append("+");
			}
			else {
				if (lower != 0) {
					s.append(lower);
					s.append("..");
				}
				s.append("*");
			}
		}
		else if ((lower == 0) && (upper == 1)) {
			s.append("?");
		}
		else {
			s.append(lower);
			if (lower != upper) {
				s.append("..");
				s.append(upper);
			}
		}
		s.append("]");
	}

	/**
	 * Return the sourceURI annotation of eModelElement, creating and installing it if required.
	 */
	public static @NonNull EAnnotation getEAnnotation(@NonNull EModelElement eModelElement, String sourceURI) {
		EAnnotation eAnnotation = eModelElement.getEAnnotation(sourceURI);
		if (eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(sourceURI);
			eModelElement.getEAnnotations().add(eAnnotation);
		}
		return eAnnotation;
	}

	/**
	 * Return a simple readable description of eObject using an IItemLabelProvider if possible.
	 */
	public static String getLabel(EObject eObject) {
		if (eObject instanceof Labelable) {
			String text = ((Labelable)eObject).getText();
			if (text != null) {
				return text;
			}
		}
		return EcoreUtils.qualifiedNameFor(eObject);
	}

	public static String getIndentation(int depth, @NonNull String string) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			s.append(string);
		}
		return s.toString();
	}

	/**
	 * Return a simple readable description of object. If non-null eClassifier
	 * identifies the type of object. If non-null context may provide an ESubstitutionLabelProvider.
	 */
	public static String getLabel(EClassifier eClassifier, Object object, Map<Object, Object> context) {
		if (eClassifier instanceof EDataType) {
			return EObjectValidator.getValueLabel((EDataType) eClassifier, object, context);
		}
		else if (object instanceof EObject) {
			if (context != null) {					// Use an ESubstitutionLabelProvider
				return EObjectValidator.getObjectLabel((EObject)object, context);
			}
			else {									// Use an ItemProvider rather than EcoreUtil.getIdentification
				return getLabel((EObject)object);
			}
		}
		else {			// Never happens
			return String.valueOf(object);
		}
	}

	public static @NonNull DomainType[] getLambdaParameterTypes(@NonNull DomainLambdaType lambdaType) {
		int iParameter = 0;
		List<? extends DomainType> ownedParameters = lambdaType.getParameterTypes();
		DomainType[] parameterTypes = new DomainType[ownedParameters.size() + 2];
		parameterTypes[iParameter++] = lambdaType.getContextType();
		parameterTypes[iParameter++] = lambdaType.getResultType();
		for (DomainType parameterType : ownedParameters) {
			parameterTypes[iParameter++] = parameterType;
		}
		return parameterTypes;
	}

	/**
	 * Return the DomainConstants.AS_METAMODEL_ANNOTATION_SOURCE for ePackage, creating it if needed.
	 * @since 3.5
	 */
	public static @NonNull EAnnotation getMetamodelAnnotation(@NonNull EPackage ePackage) {
		EAnnotation eAnnotation = ePackage.getEAnnotation(DomainConstants.AS_METAMODEL_ANNOTATION_SOURCE);
		if (eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(DomainConstants.AS_METAMODEL_ANNOTATION_SOURCE);
			ePackage.getEAnnotations().add(eAnnotation);
		}
		return eAnnotation;
	}

	public static <T extends Nameable> T getNamedElement(Iterable<T> elements, String name) {
		if (elements == null)
			return null;
		for (T element : elements)
			if (ClassUtils.equals(name, element.getName()))
				return element;
		return null;				
	}

	public static @NonNull DomainType[] getOperationParameterTypes(@NonNull DomainOperation anOperation) {
		DomainType[] parameterTypes;
		int iParameter = 0;
		List<? extends DomainTypedElement> ownedParameters = anOperation.getOwnedParameter();
		if (anOperation instanceof DomainIteration) {
			DomainIteration anIteration = (DomainIteration)anOperation;
			List<? extends DomainTypedElement> ownedIterators = anIteration.getOwnedIterator();
			List<? extends DomainTypedElement> ownedAccumulators = anIteration.getOwnedAccumulator();
			parameterTypes = new DomainType[ownedIterators.size() + ownedAccumulators.size() + ownedParameters.size()];
			for (DomainTypedElement ownedIterator : ownedIterators) {
				parameterTypes[iParameter++] = ownedIterator.getType();
			}
			for (DomainTypedElement ownedAccumulator : ownedAccumulators) {
				parameterTypes[iParameter++] = ownedAccumulator.getType();
			}
		}
		else {
			parameterTypes = new DomainType[ownedParameters.size()];
		}
		for (DomainTypedElement ownedParameter : ownedParameters) {
			parameterTypes[iParameter++] = ownedParameter.getType();
		}
		return parameterTypes;
	}

	public static @NonNull String getSafeName(@Nullable Nameable aNameable) {
		if (aNameable == null) {
			return "";
		}
		String name = aNameable.getName();
		if (name == null) {
			name = "";
		}
		return name;
	}

	/**
	 * Return true if resource is a registered resource; hosting a compile Java model.
	 */
	public static boolean isRegistered(Resource resource) {
		if (resource == null) {
			return false;
		}
		return resource.getResourceSet() == null;
	}

	/**
	 * Return aT, checking the assertion that this call would not be necessary if EMF had comprehensive @NonNull annotations.
	 */
	public static @NonNull <T> T nonNullEMF(@Nullable T aT) {// FIXME remove once EMF guarantees non-null
		assert aT != null;
		return aT;
	}

	/**
	 * Check for an in appropriate model state which should have been detected by a model validation pass. Typical problems
	 * that nonNullModel detects are null mandatory model elements.
	 *<p>
	 * Return aT, checking the assertion that this call would not be necessary if the Ecore model was guaranteed to be valid.
	 */
	public static @NonNull <T> T nonNullModel(@Nullable T aT) {
		assert aT != null;			// FIXME Change to InvalidModelException
		return aT;
	}

	/**
	 * Return aT, checking the assertion that this call would not be necessary if the Pivot model was guaranteed to be valid.
	 */
	public static @NonNull <T> T nonNullPivot(@Nullable T aT) {
		assert aT != null;			// FIXME Change to InvalidModelException
		return aT;
	}

	/**
	 * Check for an in appropriate program state. This should not happen, but is not impossible. For instance
	 * a Resource should be contained in a ResourceSet, but that doesn;t mean it always is.
	 *<p>
	 * If the inappropriate state really cannot happen, an assertion should be used instead to avoid non-debug
	 * run-time cost.
	 * <p>
	 * Return aT, throwing an IllegalStateException if null.
	 */
	public static @NonNull <T> T nonNullState(@Nullable T aT) {
		if (aT == null) {
			throw new IllegalStateException();
		}
		return aT;
	}

	/**
	 * Safely determines the relative order of <code>object</code> and
	 * <code>otherObject</code>, i.e. without throwing an exception if
	 * <code>object</code> is <code>null</code>.
	 */
	public static <T extends Comparable<T>> int safeCompareTo(@Nullable T object, @Nullable T otherObject) {
		if (object == null) {
			return otherObject == null ? 1 : 0;
		}
		else {
			return otherObject == null ? -1 : object.compareTo(otherObject);
		}
	}

	/**
	 * Safely determines whether <code>object</code> equals
	 * <code>otherObject</code>, i.e. without throwing an exception if
	 * <code>object</code> is <code>null</code>.
	 * 
	 * @param object
	 *            The first object to compare.
	 * @param otherObject
	 *            The second object to compare.
	 * @return <code>true</code> if <code>object</code> equals
	 *         <code>otherObject</code>; <code>false</code> otherwise.
	 */
	public static boolean safeEquals(@Nullable Object object, @Nullable Object otherObject) {
		return object == null
			? otherObject == null
			: object.equals(otherObject);
	}

	/**
	 * This dummy function may be invoked from auto-generated code that does not throw
	 * an exception to avoid a compilation error.
	 * 
	 * @throws InvalidValueException
	 * @deprecated
	 */
	@Deprecated
	public static void suppressThrowWarnings()  {}

	/**
	 * Copied from {@link java.util.Properties}
	 */
	public static char toHex(int nibble) {
		return hexDigit[(nibble & 0xF)];
	}

	/**
	 * Copied from {@link java.util.Properties}
	 */
	private static final char[] hexDigit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
}
