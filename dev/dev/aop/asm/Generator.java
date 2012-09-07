package dev.aop.asm;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class Generator {
	public static final String SUFFIX = "$aop";

	@SuppressWarnings({ "unchecked", "hiding" })
	public static <T> T wrap(Class<T> type) {
		try {
			ClassReader classReader = new ClassReader(type.getName());
			ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
			ClassAdapter classAdapter = new DefaultClassAdapter(classWriter);
			classReader.accept(classAdapter, ClassReader.SKIP_DEBUG);
			return (T) new DefaultClassLoader().defineClassFromFile(type.getName(), classWriter.toByteArray()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}