package t;

import java.io.File;
import java.util.List;

import li.util.Files;

public class T4 {
	public static void main(String[] args) {
		String regex = "^.*\\\\WEB-INF\\\\lib\\\\.*.jar$";
		List<String> list = Files.list(new File(System.getProperty("user.dir")), regex, true);
		for (String string : list) {
			System.out.println(string);
		}
	}
}