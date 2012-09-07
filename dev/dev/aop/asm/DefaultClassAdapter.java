package dev.aop.asm;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

public class DefaultClassAdapter extends ClassAdapter {
	public DefaultClassAdapter(ClassVisitor classVisitor) {
		super(classVisitor);
	}

	public void visit(final int version, final int access, final String name, final String signature, final String superName, final String[] interfaces) {
		super.visit(version, access, (name + Generator.SUFFIX), signature, name, interfaces);
	}

	public MethodVisitor visitMethod(final int access, final String methodName, final String desc, final String signature, final String[] exceptions) {
		MethodVisitor methodVisitor = cv.visitMethod(access, methodName, desc, signature, exceptions);
		if (methodName.equals("<init>")) {
			return methodVisitor;
		}
		return new DefaultMethodAdapter(methodVisitor);
	}
}