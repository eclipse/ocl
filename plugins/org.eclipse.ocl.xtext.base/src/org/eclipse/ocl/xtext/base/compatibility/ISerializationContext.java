package org.eclipse.ocl.xtext.base.compatibility;

import java.util.Set;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;

public interface ISerializationContext extends org.eclipse.xtext.serializer.ISerializationContext {

	ParserRule getParserRule();

	Action getAssignedAction();

	Set<org.eclipse.xtext.Parameter> getEnabledBooleanParameters();

}
