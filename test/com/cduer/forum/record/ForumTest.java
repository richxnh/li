package com.cduer.forum.record;

import static org.junit.Assert.assertNotNull;
import li.annotation.Inject;
import li.test.BaseTest;

import org.junit.Test;

public class ForumTest extends BaseTest {
	@Inject
	Forum forum;

	@Test
	public void testList() {
		assertNotNull(forum);
	}
}
