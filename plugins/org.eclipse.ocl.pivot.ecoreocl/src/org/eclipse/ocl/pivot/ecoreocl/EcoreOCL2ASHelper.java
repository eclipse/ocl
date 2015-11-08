/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ecoreocl;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.internal.ecore.es2as.AbstractEcore2ASHelper;
import org.eclipse.ocl.pivot.internal.ecore.es2as.AbstractExternal2AS;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2ASDeclarationSwitch;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2ASReferenceSwitch;

public class EcoreOCL2ASHelper extends AbstractEcore2ASHelper
{
	private static @Nullable EcoreOCL2ASHelper METAMODEL_INSTANCE = null;
	private static @Nullable EcoreOCL2ASHelper MODEL_INSTANCE = null;

	public static synchronized @NonNull EcoreOCL2ASHelper getMetamodelInstance() {
		if (METAMODEL_INSTANCE == null) {
			METAMODEL_INSTANCE = new EcoreOCL2ASHelper(org.eclipse.ocl.ecore.EcorePackage.eNS_URI, false);										// Create our own singleton
			METAMODEL_INSTANCE.install();
		}
		assert METAMODEL_INSTANCE != null;
		return METAMODEL_INSTANCE;
	}

	public static synchronized @NonNull EcoreOCL2ASHelper getModelInstance() {
		if (MODEL_INSTANCE == null) {
			MODEL_INSTANCE = new EcoreOCL2ASHelper(org.eclipse.ocl.ecore.EcoreEnvironment.OCL_STANDARD_LIBRARY_NS_URI, true);										// Create our own singleton
			MODEL_INSTANCE.install();
		}
		assert MODEL_INSTANCE != null;
		return MODEL_INSTANCE;
	}

	public static final class EcoreOCLEcore2ASDeclarationSwitch extends Ecore2ASDeclarationSwitch
	{
		public final class EcoreOCL2ASDeclarationSwitch extends org.eclipse.ocl.ecore.util.EcoreSwitch<Object>
		{
			@Override
			public Object caseAnyType(org.eclipse.ocl.ecore.AnyType eObject) {
				return refreshEcoreOCLClass(AnyType.class, PivotPackage.Literals.ANY_TYPE, eObject);
			}

			@Override
			public Object caseBagType(org.eclipse.ocl.ecore.BagType eObject) {
				BagType pivotElement = refreshEcoreOCLClass(BagType.class, PivotPackage.Literals.BAG_TYPE, eObject);
				queueReference(pivotElement);
				return pivotElement;
			}

			@Override
			public Object caseCollectionType(org.eclipse.ocl.ecore.CollectionType eObject) {
				CollectionType pivotElement = refreshEcoreOCLClass(CollectionType.class, PivotPackage.Literals.COLLECTION_TYPE, eObject);
				queueReference(pivotElement);
				return pivotElement;
			}

			@Override
			public Object caseInvalidType(org.eclipse.ocl.ecore.InvalidType eObject) {
				return refreshEcoreOCLClass(InvalidType.class, PivotPackage.Literals.INVALID_TYPE, eObject);
			}

			@Override
			public Object caseOrderedSetType(org.eclipse.ocl.ecore.OrderedSetType eObject) {
				OrderedSetType pivotElement = refreshEcoreOCLClass(OrderedSetType.class, PivotPackage.Literals.ORDERED_SET_TYPE, eObject);
				queueReference(pivotElement);
				return pivotElement;
			}

			@Override
			public Object casePrimitiveType(org.eclipse.ocl.ecore.PrimitiveType eObject) {
				PrimitiveType pivotElement = converter.refreshElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, eObject);
				String oldName = pivotElement.getName();
				String newName = technology.getOriginalName(eObject);
				boolean nameChange = (oldName != newName) || ((oldName != null) && !oldName.equals(newName));
				if (nameChange) {
					org.eclipse.ocl.pivot.Package parentPackage = pivotElement.getOwningPackage();
					if (parentPackage != null) {
						parentPackage.getOwnedClasses().remove(pivotElement);
					}
				}
				pivotElement.setName(newName);
				copyClassifier(pivotElement, eObject, null);
				return pivotElement;
			}

			@Override
			public Object caseSequenceType(org.eclipse.ocl.ecore.SequenceType eObject) {
				SequenceType pivotElement = refreshEcoreOCLClass(SequenceType.class, PivotPackage.Literals.SEQUENCE_TYPE, eObject);
				queueReference(pivotElement);
				return pivotElement;
			}

			@Override
			public Object caseSetType(org.eclipse.ocl.ecore.SetType eObject) {
				SetType pivotElement = refreshEcoreOCLClass(SetType.class, PivotPackage.Literals.SET_TYPE, eObject);
				queueReference(pivotElement);
				return pivotElement;
			}

			@Override
			public Object caseTupleType(org.eclipse.ocl.ecore.TupleType eObject) {
				TupleType pivotElement = converter.refreshElement(TupleType.class, PivotPackage.Literals.TUPLE_TYPE, eObject);
				String oldName = pivotElement.getName();
				String newName = technology.getOriginalName(eObject);
				boolean nameChange = (oldName != newName) || ((oldName != null) && !oldName.equals(newName));
				if (nameChange) {
					org.eclipse.ocl.pivot.Package parentPackage = pivotElement.getOwningPackage();
					if (parentPackage != null) {
						parentPackage.getOwnedClasses().remove(pivotElement);
					}
				}
				pivotElement.setName(newName);
				copyClassifier(pivotElement, eObject, null);
				return pivotElement;
			}

			@Override
			public Object caseTypeType(org.eclipse.ocl.ecore.TypeType eObject) {
				return refreshEcoreOCLClass(org.eclipse.ocl.pivot.Class.class, PivotPackage.Literals.CLASS, eObject);
			}

			@Override
			public Object caseVoidType(org.eclipse.ocl.ecore.VoidType eObject) {
				return refreshEcoreOCLClass(VoidType.class, PivotPackage.Literals.VOID_TYPE, eObject);
			}
		}

		protected final @NonNull EcoreOCL2ASDeclarationSwitch oclSwitch;
		
		public EcoreOCLEcore2ASDeclarationSwitch(@NonNull AbstractExternal2AS converter) {
			super(converter, new EcoreOCLEcore2ASReferenceSwitch(converter));
			oclSwitch = new EcoreOCL2ASDeclarationSwitch();
		}

		@Override
		public Object caseEClass(EClass eObject) {
			EAnnotation eAnnotation = eObject.getEAnnotation(org.eclipse.ocl.Environment.OCL_NAMESPACE_URI);
			if (eAnnotation != null) {
				List<EObject> references = eAnnotation.getReferences();
				if (references.size() == 1) {
					EObject eShadowObject = references.get(0);
					if (eShadowObject instanceof EClassifier) {
						org.eclipse.ocl.pivot.Class pivotClass = refreshEcoreOCLClass(org.eclipse.ocl.pivot.Class.class, PivotPackage.Literals.CLASS, (EClassifier)eShadowObject);
						doSwitchAll(pivotClass.getOwnedOperations(), eObject.getEOperations());
						doSwitchAll(pivotClass.getOwnedProperties(), eObject.getEStructuralFeatures());
						return this;
					}
				}
			}
			return super.caseEClass(eObject);
		}

		public Object doSwitch(EObject eObject) {
			Object result = oclSwitch.doSwitch(eObject);
			if (result == null) {
				result = super.doSwitch(eObject);
			}
			return result != this ? result : null;
		}

		protected  @NonNull <T extends org.eclipse.ocl.pivot.Class> T refreshEcoreOCLClass(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull EClassifier eObject) {
			T pivotElement = converter.refreshElement(pivotClass, pivotEClass, eObject);
			copyClassifier(pivotElement, eObject, null);
			String oldName = pivotElement.getName();
			String newName = eObject.getName();
			int index = newName.indexOf("(");
			if (index > 0) {
				newName = newName.substring(0, index);
			}
			boolean nameChange = (oldName != newName) || ((oldName != null) && !oldName.equals(newName));
			if (nameChange) {
				org.eclipse.ocl.pivot.Package parentPackage = pivotElement.getOwningPackage();
				if (parentPackage != null) {
					parentPackage.getOwnedClasses().remove(pivotElement);
				}
			}
			pivotElement.setName(newName);
/*				List<Operation> pivotOperations = pivotElement.getOwnedOperations();
			List<Constraint> pivotInvariants = pivotElement.getOwnedInvariants();
			for (@SuppressWarnings("null")@NonNull EOperation eOperation : eObject2.getEOperations()) {
				if (converter.isInvariant(eOperation)) {
					Object pivotObject = doSwitch(eOperation);
					pivotInvariants.add((Constraint) pivotObject);
				}
				else {
					Object pivotObject = doSwitch(eOperation);
					pivotOperations.add((Operation) pivotObject);
				}
			}
			List<Property> pivotProperties = pivotElement.getOwnedProperties();
			doSwitchAll(pivotProperties, eObject2.getEStructuralFeatures());
			if (duplicatesAnnotation != null) {
				for (EObject eContent : duplicatesAnnotation.getContents()) {
					if (eContent instanceof EOperation) {
						if (converter.isInvariant((EOperation) eContent)) {
							Constraint pivotInvariant = (Constraint) doSwitch(eContent);
							pivotInvariants.add(pivotInvariant);
						}
						else {
							Operation pivotOperation = (Operation) doSwitch(eContent);
							pivotOperations.add(pivotOperation);
						}
						converter.queueReference(eContent);				// For redefinition
					}
					else if (eContent instanceof EStructuralFeature) {
						Property pivotProperty = (Property) doSwitch(eContent);
						pivotProperties.add(pivotProperty);
						converter.queueReference(eContent);				// For redefinition
					}
					else if (eContent instanceof EAnnotation) {
					}
					else {
						converter.error("Unsupported duplicate " + eContent.eClass().getName());
					}
				}
			} */
			queueReference(eObject);				// For superclasses
			return pivotElement;
		}
	}
	
	public static final class EcoreOCLEcore2ASReferenceSwitch extends Ecore2ASReferenceSwitch
	{
		public final class EcoreOCL2ASReferenceSwitch extends org.eclipse.ocl.ecore.util.EcoreSwitch<Object>
		{
			@Override
			public Object caseCollectionType(org.eclipse.ocl.ecore.CollectionType eObject) {
				CollectionType pivotCollection = converter.getCreated(CollectionType.class, eObject);
				if (pivotCollection != null) {
					Type pivotElement = converter.getCreated(Type.class, eObject.getElementType());
					pivotCollection.setElementType(pivotElement);
				}
				return this;
			}

			@Override
			public Object defaultCase(EObject object) {
				// TODO Auto-generated method stub
				return super.defaultCase(object);
			}
		}

		protected final @NonNull EcoreOCL2ASReferenceSwitch oclSwitch;
		
		public EcoreOCLEcore2ASReferenceSwitch(@NonNull AbstractExternal2AS converter) {
			super(converter);
			oclSwitch = new EcoreOCL2ASReferenceSwitch();
		}

		@Override
		public Object caseEClass(EClass eObject) {
			if (eObject.getEAnnotation(org.eclipse.ocl.Environment.OCL_NAMESPACE_URI) !=  null) {
								// For shadow content
				return this;
			}
			else {
				return super.caseEClass(eObject);
			}
		}

		public Object doSwitch(EObject eObject) {
			Object result = oclSwitch.doSwitch(eObject);
			if (result == null) {
				result = super.doSwitch(eObject);
			}
			return result != this ? result : null;
		}
	}
	
	public EcoreOCL2ASHelper(@NonNull String uri, boolean isModel) {
		super(uri, isModel);
	}

	@Override
	public @NonNull Ecore2ASDeclarationSwitch createEcore2ASDeclarationSwitch(@NonNull AbstractExternal2AS converter) {
		return new EcoreOCLEcore2ASDeclarationSwitch(converter);
	}
}
