package com.cduer.forum.action;

import static org.junit.Assert.assertNotNull;
import li.annotation.Inject;
import li.test.BaseActionTest;

import org.junit.Test;

public class ThreadActionTest extends BaseActionTest {
	@Inject
	ThreadAction threadAction;

	@Test
	public void testList() {
		assertNotNull(threadAction);
	}
}
