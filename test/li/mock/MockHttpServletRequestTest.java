package li.mock;

import li.test.BaseTest;

import org.junit.Test;

public class MockHttpServletRequestTest extends BaseTest {

	@Test
	public void test() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setParameter("id", "1");
		request.setParameter("username", "li");
		request.setParameter("password", "wode");
		request.setParameter("email", "limw@w.cn");
		System.out.println(request.getQueryString());
	}
}