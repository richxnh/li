package t;

import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@SuppressWarnings("resource")
public class T2 {
	public static void main(String[] args) throws Throwable {

	}

	public static void test2() throws Throwable {
		String path = Class.forName("org.junit.Test").getResource("").getPath();
		path = path.split("file:/")[1].split("!")[0];
		ZipFile zipFile = new ZipFile(path);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry zipEntry = (ZipEntry) entries.nextElement();
			System.out.println(zipEntry);
		}
	}
}