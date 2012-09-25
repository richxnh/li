package li.test.mock;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class MockServletConfig implements ServletConfig {
	private ServletContext servletContext;
	private Map<String, String> initParameters = new HashMap<String, String>();

	public MockServletConfig(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public String getInitParameter(String key) {
		return initParameters.get(key);
	}

	public Enumeration<String> getInitParameterNames() {
		return new Vector(initParameters.keySet()).elements();
	}

	public ServletContext getServletContext() {
		return this.servletContext;
	}

	public String getServletName() {
		return null;
	}
}