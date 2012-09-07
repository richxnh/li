package com.cduer.forum.action;

import static org.junit.Assert.assertNotNull;
import li.annotation.Inject;
import li.test.BaseActionTest;

import org.junit.Test;

public class PostActionTest extends BaseActionTest {
	@Inject
	PostAction postAction;

	@Test
	public void testList() {
		assertNotNull(postAction);
	}
}