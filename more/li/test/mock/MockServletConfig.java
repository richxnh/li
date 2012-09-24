package li.test.mock;

import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class MockServletConfig implements ServletConfig {
	private ServletContext servletContext;

	public MockServletConfig(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public String getInitParameter(String arg0) {
		return null;
	}

	public Enumeration<String> getInitParameterNames() {
		return null;
	}

	public ServletContext getServletContext() {
		return this.servletContext;
	}

	public String getServletName() {
		return null;
	}
}