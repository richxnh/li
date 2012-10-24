package li.template;

import java.io.FileInputStream;

public class TemplateClassLoader extends ClassLoader {
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			FileInputStream fileInputStream = new FileInputStream("E:\\workspace\\li\\more\\li\\quartz\\Demo.java");
			byte[] data = new byte[fileInputStream.available()];
			fileInputStream.read(data);
			return defineClass(name, data, 0, data.length);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
