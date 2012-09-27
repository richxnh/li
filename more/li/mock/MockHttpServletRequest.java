package li.mock;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * MockHttpServletRequest
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-09-27)
 */
public class MockHttpServletRequest extends MockServletRequest implements HttpServletRequest {

	private MockHttpSession session = new MockHttpSession(getServletContext());

	private Map<String, List<String>> header = new HashMap<String, List<String>>();

	private String method = "GET";

	public String getHeader(String key) {
		if (null != header.get(key) && header.get(key).size() > 1) {
			return header.get(key).get(0);
		}
		return null;
	}

	public Enumeration<String> getHeaderNames() {
		return new Vector(header.keySet()).elements();
	}

	public Enumeration<String> getHeaders(String key) {
		return new Vector(header.get(key)).elements();
	}

	public int getIntHeader(String key) {
		return Integer.parseInt(getHeader(key));
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMethod() {
		return this.method;
	}

	public MockHttpSession getSession() {
		return this.session;
	}

	public HttpSession getSession(boolean flag) {
		return this.session;
	}

	public String getAuthType() {
		return "li.mock.MockHttpServletRequest.getAuthType()";
	}

	public String getContextPath() {
		return "li.mock.MockHttpServletRequest.getContextPath()";
	}

	public String getPathInfo() {
		return "li.mock.MockHttpServletRequest.getPathInfo()";
	}

	public String getPathTranslated() {
		return "li.mock.MockHttpServletRequest.getPathTranslated()";
	}

	public String getQueryString() {
		return "li.mock.MockHttpServletRequest.getQueryString()";
	}

	public String getRemoteUser() {
		return "li.mock.MockHttpServletRequest.getRemoteUser()";
	}

	public String getRequestURI() {
		return "li.mock.MockHttpServletRequest.getRequestURI()";
	}

	public StringBuffer getRequestURL() {
		return new StringBuffer("li.mock.MockHttpServletRequest.getRequestURL()");
	}

	public String getRequestedSessionId() {
		return "li.mock.MockHttpServletRequest.getRequestedSessionId()";
	}

	public String getServletPath() {
		return "li.mock.MockHttpServletRequest.getServletPath()";
	}

	public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
		return false;
	}

	public Cookie[] getCookies() {
		return null;
	}

	public long getDateHeader(String arg0) {
		return 0;
	}

	public Part getPart(String arg0) throws IOException, IllegalStateException, ServletException {
		return null;
	}

	public Collection<Part> getParts() throws IOException, IllegalStateException, ServletException {
		return null;
	}

	public Principal getUserPrincipal() {
		return null;
	}

	public boolean isRequestedSessionIdFromCookie() {
		return false;
	}

	public boolean isRequestedSessionIdFromURL() {
		return false;
	}

	public boolean isRequestedSessionIdFromUrl() {
		return false;
	}

	public boolean isRequestedSessionIdValid() {
		return false;
	}

	public boolean isUserInRole(String arg0) {
		return false;
	}

	public void login(String username, String pawssword) throws ServletException {
	}

	public void logout() throws ServletException {
	}
}