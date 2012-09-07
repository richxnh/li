package dev.aop.asm;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class DefaultMethodAdapter extends MethodAdapter {
	private String superClassName;

	public DefaultMethodAdapter(MethodVisitor mv) {
		super(mv);
	}

	public DefaultMethodAdapter(MethodVisitor mv, String superClassName) {
		super(mv);
		this.superClassName = superClassName;
	}

	public void visitCode() {
		invoke(SecurityChecker.class, "checkSecurity", "方法参数");
		invoke(SecurityChecker.class, "check1", "方法参数");
		invoke(SecurityChecker.class, "check4", "方法参数1", "方法参数2");
	}

	public void visitMethodInsn(int opcode, String owner, String methodName, String desc) {
		if (opcode == Opcodes.INVOKESPECIAL && methodName.equals("<init>")) { // 调用父类的构造函数时
			owner = superClassName;
		}
		super.visitMethodInsn(opcode, owner, methodName, desc);// 改写父类为 superClassName
	}

	// private methods
	private void invoke(Class<?> ownerType, String methodName, Object... args) {
		String owner = ownerType.getName().replace(".", "/");
		String desc = "(";// 参数列表
		for (Object arg : args) {
			desc += "L" + arg.getClass().getName().replace(".", "/") + ";";
		}
		desc += ")V";
		for (Object arg : args) {// 压入参数
			visitLdcInsn(arg);
		}
		visitMethodInsn(Opcodes.INVOKESTATIC, owner, methodName, desc);

		// visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");//访问静态变量
		// visitLdcInsn("Before execute");
		// visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
		//
		// mv.visitVarInsn(Opcodes.ALOAD, 0);
		// mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, owner, methodName, "()V");
		//
		// mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		// mv.visitLdcInsn("End execute");
		// mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
		//
		// mv.visitInsn(Opcodes.RETURN);
		// mv.visitMaxs(0, 0); //这个地方，最大的操作数栈和最大的本地变量的空间，是自动计算的，是因为构造ClassWriter的时候使用了ClassWriter.COMPUTE_MAXS
		// mv.visitEnd();
	}
}