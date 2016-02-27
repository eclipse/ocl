package org.eclipse.ocl.xtext.base.compatibility;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;

public abstract class CompatibilityDelegatingSemanticSequencer extends AbstractDelegatingSemanticSequencer
{
	protected CompatibilitySemanticSequencer genericSequencer;
	
	protected ISerializationContext createContext(EObject context, EObject semanticObject) {
		return null;//SerializationContext.fromEObject(context, semanticObject);
	}

	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		sequence(SerializationContext.fromEObject(context, semanticObject), semanticObject);
	}
	
	protected SequenceFeeder createSequencerFeeder(ISerializationContext context,
			EObject semanticObject) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected EObject getEObjectContext(ISerializationContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
