package dev.aop.asm;

public class DefaultClassLoader extends ClassLoader {
	public Class<?> defineClassFromFile(String className, byte[] classFile) throws ClassFormatError {
		return defineClass(className + Generator.SUFFIX, classFile, 0, classFile.length);
	}
}