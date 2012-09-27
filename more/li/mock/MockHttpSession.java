package li.mock;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * MockHttpSession
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-09-27)
 */
public class MockHttpSession implements HttpSession {
	private ServletContext servletContext;
	private final Map<String, Object> session = new HashMap<String, Object>();

	public MockHttpSession(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public Object getAttribute(String key) {
		return session.get(key);
	}

	public Enumeration<String> getAttributeNames() {
		return new Vector(session.keySet()).elements();
	}

	public long getCreationTime() {
		return 0;
	}

	public String getId() {
		return null;
	}

	public long getLastAccessedTime() {
		return 0;
	}

	public int getMaxInactiveInterval() {
		return 0;
	}

	public ServletContext getServletContext() {
		return this.servletContext;
	}

	public HttpSessionContext getSessionContext() {
		return null;
	}

	public Object getValue(String key) {
		return session.get(key);
	}

	public String[] getValueNames() {
		return session.keySet().toArray(new String[0]);
	}

	public void invalidate() {
	}

	public boolean isNew() {
		return false;
	}

	public void putValue(String key, Object value) {
		session.put(key, value);
	}

	public void removeAttribute(String key) {
		System.err.println("remove session " + key);
		session.remove(key);
	}

	public void removeValue(String value) {
		//
	}

	public void setAttribute(String key, Object value) {
		session.put(key, value);
	}

	public void setMaxInactiveInterval(int arg0) {
	}
}