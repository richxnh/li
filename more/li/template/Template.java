package li.template;

import java.util.Map;

public class Template {
	public String template;
	public Map<String, Object> map;

	public void setTemplate(String template) {
		this.template = template;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String merge() {
		return template;
	}
}