package li.test;

import javax.servlet.ServletException;

import li.mock.MockFilterConfig;
import li.mock.MockHttpServletRequest;
import li.mock.MockHttpServletResponse;
import li.mock.MockHttpSession;
import li.mock.MockServletContext;
import li.model.Action;
import li.mvc.ActionFilter;
import li.mvc.Context;

/**
 * Action测试类的基类，准备内request response等的Mock对象
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-07-21)
 */
public class ActionTest extends BaseTest {
	/**
	 * 模拟的request
	 */
	protected MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 模拟的response
	 */
	protected MockHttpServletResponse response = new MockHttpServletResponse();

	/**
	 * 模拟的servletContext
	 */
	protected MockServletContext servletContext = request.getServletContext();

	/**
	 * 模拟的session
	 */
	protected MockHttpSession session = request.getSession();

	/**
	 * 模拟的FilterConfig
	 */
	private MockFilterConfig filterConfig = new MockFilterConfig(servletContext);

	/**
	 * 模拟Action
	 */
	protected Action action = new Action();

	/**
	 * 初始化方法，由于不会启动Filter，所以这里为Context ThreadLocal设值
	 */
	public ActionTest() {
		Context.init(request, response, action);
		try {
			new ActionFilter().init(filterConfig);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	public void setMethod(String method) {
		request.setMethod(method);
	}
}