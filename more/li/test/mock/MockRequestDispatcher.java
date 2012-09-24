package li.test.mock;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MockRequestDispatcher implements RequestDispatcher {
	private String path;

	public MockRequestDispatcher(String path) {
		this.path = path;
	}

	public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.err.println("forward to : " + path);
	}

	public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.err.println("include : " + path);
	}
}
