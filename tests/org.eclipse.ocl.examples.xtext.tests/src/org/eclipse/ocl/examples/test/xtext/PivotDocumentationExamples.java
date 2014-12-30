/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.BookCategory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.internal.OCL;
import org.eclipse.ocl.pivot.internal.Query;
import org.eclipse.ocl.pivot.internal.helper.OCLHelper;
import org.eclipse.ocl.pivot.utilities.NameUtil;



/**
 * Tests for the OCL delegate implementations.
 */
@SuppressWarnings({"nls","null"})
public class PivotDocumentationExamples extends XtextTestCase
{
	public void debugPrintf(String format, Object... args) {
//		System.out.printf(format,  args);
	}
	
	public InputStream getInputStream(String fileName) throws MalformedURLException, IOException {
		URI uri = getTestModelURI(fileName);
		URL url = new URL(uri.toString());
		return url.openStream();
	}
	
	public URI getInputURI(String fileName) throws MalformedURLException, IOException {
		return getTestModelURI(fileName);
	}
	
	private List<Library> getLibraries() {
		return Collections.emptyList();
	}

	public Library getLibrary() {
		Library library = EXTLibraryFactory.eINSTANCE.createLibrary();
		Book aBook = EXTLibraryFactory.eINSTANCE.createBook();
		aBook.setTitle("Bleak House");
		library.getBooks().add(aBook);
		return library;
	}
	
	/*
	 * This 'test' provides the source text for the 'Parsing Constraints and Queries' example
	 * in org.eclipse.ocl.doc/doc/6310-pivot-parsing-constraints.textile
	 */
	public void test_parsingConstraintsExample() throws IOException, ParserException {
		// create an OCL instance
		OCL ocl = OCL.newInstance();

		EClass contextEClass = EXTLibraryPackage.Literals.LIBRARY;
		ExpressionInOCL invariant = ocl.createInvariant(contextEClass,
		    "books->forAll(b1, b2 | b1 <> b2 implies b1.title <> b2.title)");
		ExpressionInOCL query = ocl.createQuery(contextEClass,
		    "books->collect(b : Book | b.category)->asSet()");

		// define a post-condition specifying the value of EModelElement::getEAnnotation(EString).
		// This operation environment includes variables representing the operation
		// parameters (in this case, only "source : String") and the operation result
		EOperation contextEOperation = NameUtil.getENamedElement(
			EcorePackage.Literals.EMODEL_ELEMENT.getEOperations(), "getEAnnotation");
		ExpressionInOCL body = ocl.createPostcondition(contextEOperation, 
		    "result = self.eAnnotations->any(ann | ann.source = source)");

		// define a derivation constraint for the EReference::eReferenceType property
		EReference contextEReference = EcorePackage.Literals.EREFERENCE__EREFERENCE_TYPE;
		ExpressionInOCL derive = ocl.createQuery(contextEReference,
		    "self.eType->any(true).oclAsType(EClass)");

		// syntax errors such as bad text or semantic errors such as bad names throw a ParserException
		try {
			ocl.createInvariant(contextEClass, "books->forall(true)");
		}
		catch (ParserException e) {
			/*e.printStackTrace();*/
		}
		
		// ensure that resources are released
		ocl.dispose();

		if ((body == derive) && (invariant == query)) { /* Suppress the unused variable markers */ }
	}
	
	
	/*
	 * This 'test' provides the source text for the 'Evaluating Constraints and Queries' example
	 * in org.eclipse.ocl.doc/doc/6315-pivot-evaluating-constraints.textile
	 */
	public void test_evaluatingConstraintsExample() throws IOException, ParserException {
		OCL ocl = OCL.newInstance();
		OCLHelper helper = ocl.createOCLHelper(EXTLibraryPackage.Literals.LIBRARY);
		ExpressionInOCL invariant = helper.createInvariant(
		    "books->forAll(b1, b2 | b1 <> b2 implies b1.title <> b2.title)");
		ExpressionInOCL query = helper.createQuery(
		    "books->collect(b : Book | b.category)->asSet()");

		// create a Query to evaluate our query expression
		Query queryEval = ocl.createQuery(query);

		// create another to check our constraint
		Query constraintEval = ocl.createQuery(invariant);

		List<Library> libraries = getLibraries();  // hypothetical source of libraries

		// only print the set of book categories for valid libraries
		for (Library next : libraries) {
		    if (constraintEval.check(next)) {
		        // the OCL result type of our query expression is Set(BookCategory)
		        @SuppressWarnings("unchecked")
		        Set<BookCategory> categories = (Set<BookCategory>) queryEval.evaluate(next);
		        
		        debugPrintf("%s: %s%n\n", next.getName(), categories);
		    }
		}

		// Check one
		
		// check a single library
		Library lib = getLibrary();  // hypothetical source of a library

		// check whether it satisfies the constraint
		debugPrintf("%s valid: %b\n", lib.getName(), ocl.check(lib, invariant));

		// MoreSuccinct

		// only print the set of book categories for valid libraries
		for (Library next : constraintEval.select(libraries)) {
		    @SuppressWarnings("unchecked")
		    Set<BookCategory> categories = (Set<BookCategory>) queryEval.evaluate(next);
		    
		    debugPrintf("%s: %s%n\n", next.getName(), categories);
		}

		ocl.dispose();
	}

	/*
	 * This 'test' provides the source text for the 'Parsing OCL Document' example
	 * in org.eclipse.ocl.doc/doc/6320-pivot-parsing-documents.textile
	 */
	public void test_parsingDocumentsExample() throws IOException, ParserException {
		//-------------------------------------------------------------------------
		//	The OCL Input
		//-------------------------------------------------------------------------
		EPackage.Registry registry = new EPackageRegistryImpl();
		registry.put(EXTLibraryPackage.eNS_URI, EXTLibraryPackage.eINSTANCE);
		OCL ocl = OCL.newInstance(registry);

		// get an OCL text file via some hypothetical API
		URI uri = getInputURI("/model/parsingDocumentsExample.ocl");

		Map<String, ExpressionInOCL> constraintMap = new HashMap<String, ExpressionInOCL>();

		// parse the contents as an OCL document
		Resource asResource = ocl.parse(uri);
	    for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
	    	EObject next = tit.next();
	    	if (next instanceof Constraint) {
		        Constraint constraint = (Constraint)next;
		        ExpressionInOCL expressionInOCL = ocl.getSpecification(constraint);
		        if (expressionInOCL != null) {
					String name = constraint.getName();
					if (name != null) {
						constraintMap.put(name, expressionInOCL);
						debugPrintf("%s: %s%n\n", name,
				        	expressionInOCL.getOwnedBody());
					}
				}
	    	}
	    }
		//-------------------------------------------------------------------------
		//	Accessing the Constraints
		//-------------------------------------------------------------------------
		Library library = getLibrary();  // get library from a hypothetical source

		OCLHelper helper = ocl.createOCLHelper(EXTLibraryPackage.Literals.LIBRARY);

		// use the constraints defined in the OCL document

		// use the getBooks() additional operation to find a book
		ExpressionInOCL query = helper.createQuery(
		    "getBooks('Bleak House')->asSequence()->first()");

		Book book = (Book) ocl.evaluate(library, query);
		debugPrintf("Got book: %s%n\n", book);

		// use the unique_title constraint to validate the book
		boolean isValid = ocl.check(book, constraintMap.get("unique_title"));
		debugPrintf("Validate book: %b%n\n", isValid);	

		ocl.dispose();
	}
}
