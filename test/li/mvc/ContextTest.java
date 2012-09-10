package li.mvc;

import li.test.BaseActionTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContextTest extends BaseActionTest {
	@Before
	public void before() {
		Context.init(request, response, null);
	}

	@Test
	public void getRequest() {
		assertNotNull(Context.getRequest());
	}
}