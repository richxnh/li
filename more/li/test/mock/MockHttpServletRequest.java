package li.test.mock;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class MockHttpServletRequest extends MockServletRequest implements HttpServletRequest {
	private MockHttpSession session = new MockHttpSession(getServletContext());
	private String method = "GET";

	public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
		return false;
	}

	public String getAuthType() {
		return null;
	}

	public String getContextPath() {
		return null;
	}

	public Cookie[] getCookies() {
		return null;
	}

	public long getDateHeader(String arg0) {
		return 0;
	}

	public String getHeader(String arg0) {
		return null;
	}

	public Enumeration<String> getHeaderNames() {
		return null;
	}

	public Enumeration<String> getHeaders(String arg0) {
		return null;
	}

	public int getIntHeader(String arg0) {
		return 0;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMethod() {
		return this.method;
	}

	public Part getPart(String arg0) throws IOException, IllegalStateException, ServletException {
		return null;
	}

	public Collection<Part> getParts() throws IOException, IllegalStateException, ServletException {
		return null;
	}

	public String getPathInfo() {
		return null;
	}

	public String getPathTranslated() {
		return null;
	}

	public String getQueryString() {
		return null;
	}

	public String getRemoteUser() {
		return null;
	}

	public String getRequestURI() {
		return null;
	}

	public StringBuffer getRequestURL() {
		return null;
	}

	public String getRequestedSessionId() {
		return null;
	}

	public String getServletPath() {
		return null;
	}

	public MockHttpSession getSession() {
		return this.session;
	}

	public HttpSession getSession(boolean arg0) {
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

	public void login(String arg0, String arg1) throws ServletException {
	}

	public void logout() throws ServletException {
	}
}