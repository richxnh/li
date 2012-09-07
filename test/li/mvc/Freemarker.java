package li.mvc;

import java.util.Map;

import freemarker.template.Configuration;

@SuppressWarnings({ "rawtypes", "deprecation" })
public class Freemarker {
	public static void main(String[] args) {
		fm();
	}

	public static void fm() {
		Configuration configuration = new Configuration();
		Map settings = configuration.getSettings();
		for (Object key : settings.keySet()) {
			System.out.println(key + "=" + settings.get(key));
		}
	}
}
