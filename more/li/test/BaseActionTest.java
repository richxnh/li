package li.test;

import li.mvc.Context;
import li.test.mock.MockHttpServletRequest;
import li.test.mock.MockHttpServletResponse;
import li.test.mock.MockHttpSession;
import li.test.mock.MockServletConfig;
import li.test.mock.MockServletContext;

/**
 * Action测试类的基类，准备内request response等的Mock对象
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-07-21)
 */
public class BaseActionTest extends BaseTest {
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
	 * 模拟的servletConfig
	 */
	protected MockServletConfig servletConfig = new MockServletConfig(servletContext);

	/**
	 * 模拟的session
	 */
	protected MockHttpSession session = request.getSession();

	/**
	 * 初始化方法，由于不会启动Filter，所以这里为Context ThreadLocal设值
	 */
	public BaseActionTest() {
		Context.init(request, response, null);
	}
}