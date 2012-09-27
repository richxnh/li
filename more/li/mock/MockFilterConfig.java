package li.mock;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.FilterConfig;

/**
 * MockFilterConfig
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-09-27)
 */
public class MockFilterConfig implements FilterConfig {

	private MockServletContext servletContext;

	private Map<String, String> initParameters = new HashMap<String, String>();

	public MockFilterConfig(MockServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public MockServletContext getServletContext() {
		return this.servletContext;
	}

	public Enumeration<String> getInitParameterNames() {
		return new Vector(initParameters.keySet()).elements();
	}

	public String getFilterName() {
		return "li.mock.MockFilterConfig.getFilterName()";
	}

	public String getInitParameter(String key) {
		return "li.mock.MockFilterConfig.getInitParameter(String)";
	}

}