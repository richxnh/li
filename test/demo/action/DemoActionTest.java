package demo.action;

import li.annotation.Inject;
import li.test.ActionTest;

import org.junit.Test;

public class DemoActionTest extends ActionTest {
	@Inject
	private DemoAction demoAction;

	@Test
	public void beetl() {
		demoAction.testBeetl();
	}

	@Test
	public void freemarker() {
		demoAction.testFreemarker();
	}

	@Test
	public void velocity() {
		demoAction.testVelocity();
	}

	@Test
	public void forward() {
		demoAction.testJSP();
	}

	@Test
	public void redirect() {
	}

	@Test
	public void write() {
		demoAction.test1();
	}

	@Test
	public void view() {
	}
}