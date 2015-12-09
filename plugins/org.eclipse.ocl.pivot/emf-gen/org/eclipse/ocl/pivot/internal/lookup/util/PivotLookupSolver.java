/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.pivot/model/Pivot.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.pivot.internal.lookup.util;

import org.eclipse.ocl.pivot.evaluation.Executor;

/**
 * @since 1.1
 */
public class PivotLookupSolver {
	
	private Executor executor;
		
	public PivotLookupSolver (Executor executor) {
		this.executor = executor;
	}
	
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Operation> _lookupQualifiedOperation(org.eclipse.ocl.pivot.Class fromElement, String oName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.OPERATION, oName);
		PivotQualifiedLookupVisitor _lookupVisitor = new PivotQualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Operation>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Operation.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Property> _lookupQualifiedProperty(org.eclipse.ocl.pivot.Class fromElement, String pName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.PROPERTY, pName);
		PivotQualifiedLookupVisitor _lookupVisitor = new PivotQualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Property>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Property.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Class> _lookupQualifiedClass(org.eclipse.ocl.pivot.Namespace fromElement, String cName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.CLASS, cName);
		PivotQualifiedLookupVisitor _lookupVisitor = new PivotQualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Class>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Class.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Operation> _lookupQualifiedOperation(org.eclipse.ocl.pivot.Namespace fromElement, String oName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.OPERATION, oName);
		PivotQualifiedLookupVisitor _lookupVisitor = new PivotQualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Operation>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Operation.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Package> _lookupQualifiedPackage(org.eclipse.ocl.pivot.Namespace fromElement, String pName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.PACKAGE, pName);
		PivotQualifiedLookupVisitor _lookupVisitor = new PivotQualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Package>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Package.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Property> _lookupQualifiedProperty(org.eclipse.ocl.pivot.Namespace fromElement, String pName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.PROPERTY, pName);
		PivotQualifiedLookupVisitor _lookupVisitor = new PivotQualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Property>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Property.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Class> _lookupQualifiedClass(org.eclipse.ocl.pivot.Package fromElement, String cName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.CLASS, cName);
		PivotQualifiedLookupVisitor _lookupVisitor = new PivotQualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Class>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Class.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Package> _lookupQualifiedPackage(org.eclipse.ocl.pivot.Package fromElement, String pName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.PACKAGE, pName);
		PivotQualifiedLookupVisitor _lookupVisitor = new PivotQualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Package>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Package.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Class> _lookupClass(org.eclipse.ocl.pivot.util.Visitable fromElement, String cName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.CLASS, cName);
		PivotUnqualifiedLookupVisitor _lookupVisitor = new PivotUnqualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Class>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Class.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Namespace> _lookupNamespace(org.eclipse.ocl.pivot.util.Visitable fromElement, String nName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMESPACE, nName);
		PivotUnqualifiedLookupVisitor _lookupVisitor = new PivotUnqualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Namespace>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Namespace.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Operation> _lookupOperation(org.eclipse.ocl.pivot.util.Visitable fromElement, String oName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.OPERATION, oName);
		PivotUnqualifiedLookupVisitor _lookupVisitor = new PivotUnqualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Operation>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Operation.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Package> _lookupPackage(org.eclipse.ocl.pivot.util.Visitable fromElement, String pName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.PACKAGE, pName);
		PivotUnqualifiedLookupVisitor _lookupVisitor = new PivotUnqualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Package>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Package.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Property> _lookupProperty(org.eclipse.ocl.pivot.util.Visitable fromElement, String pName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.PROPERTY, pName);
		PivotUnqualifiedLookupVisitor _lookupVisitor = new PivotUnqualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Property>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Property.class));
	}
	
	public PivotLookupResult<org.eclipse.ocl.pivot.Variable> _lookupVariable(org.eclipse.ocl.pivot.util.Visitable fromElement, String vName) {
		PivotSingleResultLookupEnvironment _lookupEnv = new PivotSingleResultLookupEnvironment(executor, org.eclipse.ocl.pivot.PivotPackage.Literals.VARIABLE, vName);
		PivotUnqualifiedLookupVisitor _lookupVisitor = new PivotUnqualifiedLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new PivotLookupResultImpl<org.eclipse.ocl.pivot.Variable>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.ocl.pivot.Variable.class));
	}
}
