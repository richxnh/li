package li.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * MockServletRequest
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-09-27)
 */
class MockServletRequest implements ServletRequest {

	private MockServletContext servletContext = new MockServletContext();

	private Map<String, Object> request = new HashMap<String, Object>();

	private Map<String, String[]> parameterMap = new HashMap<>();

	private String encoding;

	private String contentType;

	public MockServletContext getServletContext() {
		return this.servletContext;
	}

	public void removeAttribute(String key) {
		request.remove(key);
	}

	public void setAttribute(String key, Object value) {
		request.put(key, value);
	}

	public Object getAttribute(String key) {
		return request.get(key);
	}

	public Enumeration<String> getAttributeNames() {
		return new Vector<>(request.keySet()).elements();
	}

	public String getParameter(String key) {
		String[] params = parameterMap.get(key);
		return null == params ? null : params[0];
	}

	public Map<String, String[]> getParameterMap() {
		return this.parameterMap;
	}

	public Enumeration<String> getParameterNames() {
		return new Vector<>(parameterMap.keySet()).elements();
	}

	public String[] getParameterValues(String key) {
		return parameterMap.get(key);
	}

	public void setParameter(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}

	public void setParameter(String key, String value) {
		parameterMap.put(key, new String[] { value });
	}

	public void setParameter(String key, String[] value) {
		parameterMap.put(key, value);
	}

	public String getCharacterEncoding() {
		return this.encoding;
	}

	public void setCharacterEncoding(String encoding) throws UnsupportedEncodingException {
		System.err.println("set encoding " + encoding);
		this.encoding = encoding;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		System.err.println("set contentType " + contentType);
		this.contentType = contentType;
	}

	public MockRequestDispatcher getRequestDispatcher(String path) {
		return new MockRequestDispatcher(path);
	}

	public AsyncContext getAsyncContext() {
		return null;
	}

	public int getContentLength() {
		return 0;
	}

	public DispatcherType getDispatcherType() {
		return null;
	}

	public ServletInputStream getInputStream() throws IOException {
		return null;
	}

	public String getLocalAddr() {
		return null;
	}

	public String getLocalName() {
		return null;
	}

	public int getLocalPort() {
		return 0;
	}

	public Locale getLocale() {
		return null;
	}

	public Enumeration<Locale> getLocales() {
		return null;
	}

	public String getProtocol() {
		return null;
	}

	public BufferedReader getReader() throws IOException {
		return null;
	}

	public String getRealPath(String path) {
		return null;
	}

	public String getRemoteAddr() {
		return null;
	}

	public String getRemoteHost() {
		return null;
	}

	public int getRemotePort() {
		return 0;
	}

	public String getScheme() {
		return null;
	}

	public String getServerName() {
		return null;
	}

	public int getServerPort() {
		return 0;
	}

	public boolean isAsyncStarted() {
		return false;
	}

	public boolean isAsyncSupported() {
		return false;
	}

	public boolean isSecure() {
		return false;
	}

	public AsyncContext startAsync() {
		return null;
	}

	public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1) {
		return null;
	}
}