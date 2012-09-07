package com.cduer.forum.action;

import static org.junit.Assert.assertNotNull;
import li.annotation.Inject;
import li.test.BaseTest;

import org.junit.Test;

public class ForumActionTest extends BaseTest {
	@Inject
	ForumAction forumAction;

	@Test
	public void list() {
		assertNotNull(forumAction);
	}
}