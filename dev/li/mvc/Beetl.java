package li.mvc;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import li.util.Log;

import org.bee.tl.core.GroupTemplate;
import org.bee.tl.core.Template;
import org.bee.tl.ext.ServletGroupTemplate;

public class Beetl {
	/**
	 * 返回beetl视图
	 */
	public static String beetl(String path) {
		try {
			GroupTemplate groupTemplate = (GroupTemplate) Log.get("groupTemplate"); // 从缓存中查找groupTemplate
			if (null == groupTemplate) { // 缓存中没有
				log.debug("beetl initializing ...");

				groupTemplate = new GroupTemplate(new File(getServletContext().getRealPath("/")));
				groupTemplate.setCharset("UTF-8");
				groupTemplate.enableNativeCall();
				Log.put("groupTemplate", groupTemplate); // 缓存groupTemplate
			}

			Template template = groupTemplate.getFileTemplate(path);

			Enumeration<String> requestAttributeNames = getRequest().getAttributeNames();
			while (requestAttributeNames.hasMoreElements()) {
				String name = requestAttributeNames.nextElement();
				Object value = getRequest().getAttribute(name);
				template.set(name, value);
			}

			template.getText(getResponse().getWriter());
			log.info("beetl to " + path);
		} catch (Exception e) {
			throw new RuntimeException("Error in li.mvc.Context.beetl(String)", e);
		}
		return "DONE";
	}

	/**
	 * 返回beetl视图
	 */
	public static String beetl2(String path) {
		try {
			ServletGroupTemplate servletGroupTemplate = (ServletGroupTemplate) Log.get("servletGroupTemplate"); // 从缓存中查找servletGroupTemplate
			if (null == servletGroupTemplate) { // 缓存中没有
				log.debug("beetl initializing ...");
				servletGroupTemplate = ServletGroupTemplate.instance();
				servletGroupTemplate.init(getServletContext());
				// servletGroupTemplate.setRoot(root)
				Log.put("servletGroupTemplate", servletGroupTemplate); // 缓存servletGroupTemplate
			}
			Template template = servletGroupTemplate.getTemplate(path, getRequest(), getResponse());
			template.getText(getResponse().getWriter());
		} catch (Exception e) {
			throw new RuntimeException("Error in li.mvc.Context.beetl(String)", e);
		}
		return "DONE";
	}

	private static final Log log = Log.init();

	private static HttpServletRequest getRequest() {
		return Context.getRequest();
	}

	private static HttpServletResponse getResponse() {
		return Context.getResponse();
	}

	private static ServletContext getServletContext() {
		return Context.getServletContext();
	}
}