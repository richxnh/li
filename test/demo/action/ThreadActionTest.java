package demo.action;

import static org.junit.Assert.*;
import li.annotation.Inject;
import li.test.BaseActionTest;

import org.junit.Before;
import org.junit.Test;

import demo.action.ThreadAction;

public class ThreadActionTest extends BaseActionTest {
	@Inject
	ThreadAction threadAction;

	@Before
	public void before() {
		assertNotNull(threadAction);
	}

	@Test
	public void testList() {
	}
}
