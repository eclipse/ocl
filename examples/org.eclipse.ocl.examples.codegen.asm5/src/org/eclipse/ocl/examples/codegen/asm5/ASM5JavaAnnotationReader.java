/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.asm5;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/**
 * JavaAnnotationReader supports determination of the declared @NonNull, @Nullable state of a method .
 */
public class ASM5JavaAnnotationReader
{
	private static final Logger logger = Logger.getLogger(ASM5JavaAnnotationReader.class);

	private final /*@NonNull*/ Map<String, Boolean> desc2state = new HashMap<String, Boolean>();
	private final /*@NonNull*/ Set<String> readClasses = new HashSet<String>();
	private final /*@NonNull*/ String nonNullDesc = "Lorg/eclipse/jdt/annotation/NonNull;"; //Type.getDescriptor(NonNull.class);
	private final /*@NonNull*/ String nullableDesc = "Lorg/eclipse/jdt/annotation/Nullable;";//Type.getDescriptor(Nullable.class);

	/**
	 * Return true for an @NonNull annotation, false for an @Nullable annotation, null otherwise.
	 */
	public ASM5JavaAnnotationReader() {}

	public /*@Nullable*/ Boolean getIsNonNull(/*@NonNull*/ Method method) {
		final String className = method.getDeclaringClass().getName();
		final String requiredDesc = className + ";" + method.getName() + Type.getMethodDescriptor(method);
		Boolean state = desc2state.get(requiredDesc);
		if (state != null) {
			return state;
		}
		if (!readClasses.add(className)) {
			return null;
		}
//		System.out.println("getIsNonNull: " + requiredDesc);
		InputStream classStream = null;		
		try {
			final int flags = ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES | ClassReader.SKIP_CODE;
			ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
			String classFileName = className.replace('.', '/') + ".class";
			classStream = contextClassLoader.getResourceAsStream(classFileName);		
			final ClassReader cr = new ClassReader(classStream);
			ClassVisitor cv = new ClassVisitor(Opcodes.ASM4)
			{
				@Override
				public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
					final String methodDesc = className + ";" + name + desc;
//					System.out.println("  ClassVisitor.visitMethod: " + methodDesc);
					desc2state.put(methodDesc, null);
					return new MethodVisitor(Opcodes.ASM4)
					{
						@Override
						public AnnotationVisitor visitAnnotation(String annotationDesc, boolean visible) {
//							System.out.println("    MethodVisitor:" + annotationDesc + " " + true);
							if (annotationDesc.equals(nonNullDesc)) {
								desc2state.put(methodDesc, true);
							}
							else if (annotationDesc.equals(nullableDesc)) {
								desc2state.put(methodDesc, false);
							}
							return null;
						}

						@Override
						public AnnotationVisitor visitAnnotationDefault() {
							return null;
						}

						@Override
						public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
							return null;
						}

						@Override
						public void visitAttribute(Attribute attr) {}

						@Override
						public void visitCode() {}

						@Override
						public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
						}

						@Override
						public void visitInsn(int opcode) {
						}

						@Override
						public void visitIntInsn(int opcode, int operand) {}

						@Override
						public void visitVarInsn(int opcode, int var) {}

						@Override
						public void visitTypeInsn(int opcode, String type) {}

						@Override
						public void visitFieldInsn(int opcode, String owner, String name, String desc) {}

						@Override
						public void visitMethodInsn(int opcode, String owner, String name, String desc) {}

						@Override
						public void visitJumpInsn(int opcode, Label label) {}

						@Override
						public void visitLabel(Label label) {}

						@Override
						public void visitLdcInsn(Object cst) {}

						@Override
						public void visitIincInsn(int var, int increment) {}

						@Override
						public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {}

						@Override
						public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {}

						@Override
						public void visitMultiANewArrayInsn(String desc, int dims) {}

						@Override
						public void visitTryCatchBlock(Label start, Label end,Label handler, String type) {}

						@Override
						public void visitLocalVariable(String name,
								String desc, String signature, Label start,
								Label end, int index) {}

						@Override
						public void visitLineNumber(int line, Label start) {}

						@Override
						public void visitMaxs(int maxStack, int maxLocals) {}

						@Override
						public void visitEnd() {}				
					};
				}

				@Override
				public void visit(int version, int access, String name,
						String signature, String superName, String[] interfaces) {
				}

				@Override
				public void visitSource(String source, String debug) {}

				@Override
				public void visitOuterClass(String owner, String name, String desc) {}

				@Override
				public AnnotationVisitor visitAnnotation(String desc,boolean visible) {
					return null;
				}

				@Override
				public void visitAttribute(Attribute attr) {}

				@Override
				public void visitInnerClass(String name, String outerName,String innerName, int access) {}

				@Override
				public FieldVisitor visitField(int access, String name,String desc, String signature, Object value) {
					return null;
				}

				@Override
				public void visitEnd() {}
			};
			cr.accept(cv, flags);
		} catch (IOException e) {
			logger.error("Failed to read '" + className + "'", e);
		} finally {
			if (classStream != null) {
				try {
					classStream.close();
				} catch (IOException e) {}
			}
		}
		return desc2state.get(requiredDesc);
	}
}
